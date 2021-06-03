var unitGrid;
var unitGrid3;
var deviceMap = new HashMap();

var picker = new ax5.ui.picker();
var pGridEmp="";
//var deviceSelectList = new Array({deviceId: "1", deviceName: "2"},{deviceId: "3", deviceName: "4"});
var deviceSelectList = new Array();
(function() {
	mask.open();
})();

function search() {

	var searchType="ACCOUNT";//사용자조회
	var sort = $('.nameId').val();
	if(sort === 'empName') {
		$('#empName').val($('#searchData').val());
		$('#empId').val("");
	} else if (sort === 'empId') {
		$('#empId').val($('#searchData').val());
		$('#empName').val("");
	}
	
	var pEmpId = $('#empId').val();
	var pEmpName = $('#empName').val();
	var pClsCode = $('#clsCode').val();
	var pLocCode = $('#locCode').val();
	var params = {empId:pEmpId, empName:pEmpName, clsCode:pClsCode, locCode:pLocCode};
	var objList = getAjaxList("/WAC021SsoAccountInt/ajaxSearch.do", params, searchType);
	
	return false;
}

/**
 * ajax로 리스트 가져오기
 * @param url
 */
function getAjaxList (url, params, searchType) {
	mask.open();
	var objList;
	$.ajax({
		url: url,
		type    : "POST",
//		async : false,
		data : params,
		success : function (data){
			//console.log(data);
			try{
				var parse = JSON.parse(data);
    			if(parse.result === RESULT_Y){
    				objList = parse;
    				try {
    					gridSetData(objList, searchType);
    				} catch (e) {
    					console.log(e);
    				}
    			}else {
    				toastMsg('조회된 데이터가 없습니다.');
    				return;
    			}
			}catch(e){
				console.log(e);
			}
		},
		error: function(e){ 
			//console.log(e);
		},
		complete: function(e) {
			//console.log(e);
			
			mask.close();
		}
	});
	
	return objList;
}

/**
 * ajax로 저장하기
 * @param url, params
 */
function saveAction(url, params) {
	var stateMsg;
	var ajaxParams = params;
	console.log("ajaxParams:" + ajaxParams);
	console.log(JSON.stringify(ajaxParams));
	$.ajax({
		url : url,
		type : "post",
		data : JSON.stringify(ajaxParams),
        contentType: "application/json",
        success : function(res) {
			console.log("saveAction.success");
			var data = JSON.parse(res);
			if(data.result === RESULT_OK) {
				stateMsg = RESULT_OK;
			} else {
				console.log("err");
				stateMsg = data.errMsg;
			}
			
		},
		error : function() {
			console.log("saveAction.error");
			stateMsg = "error";
		},
		complete : function() {
			console.log("saveAction.complete");
			console.log("stateMsg:" + stateMsg);
			toastMsg(stateMsg);
			
		}
	});	
}

//=== grid =================================================


function gridSetData (objList, searchType) {
	
	if(searchType=="ACCOUNT"){
		unitGrid.setData(objList.list);
		$('span.total').text(objList.list.length);	
		unitGrid.select(0, {selected: true});
		unitGrid.focus(0);
		createGridSub1();
		createGridSub2();
		$('span.applyUserName').text("");
		$('span.applyUserCompany').text("");
	}else if(searchType=="COMPANY"){
		unitGrid2.setData(objList.list);
		createGridSub2();
		if(unitGrid2.list.length> 0){
			//unitGrid.clearSelect();
			unitGrid2.focus(0);
			unitGrid2.select(0, {selected: true});
			unitGrid2.onClick();
		}
	}else{
		var deviceObj = new Object();
		deviceSelectList=[];
		try { 
			deviceSelectList.push({value: "", text: "없음"});
			objList.deviceList.forEach(function(item, index) {
				/*
				deviceMap.put("deviceId", item.deviceId);
				deviceMap.put("deviceName",item.deviceName);
				
				alert(deviceMap.get("deviceId")+index);
				alert(deviceMap.get("deviceName")+index);
				deviceSelectList.push(deviceMap);
				 */
				/*
				deviceObj.deviceId = item.deviceId+"T";
				deviceObj.deviceName = item.deviceName;
				deviceSelectList[index]=deviceObj;
				*/
				//alert(index+"==="+deviceSelectList.length+"==="+deviceObj.deviceName+"====="+deviceSelectList[index].deviceName);
				deviceSelectList.push({value: item.deviceId, text: item.deviceName});
			});	
			createGridSub2();

		} catch (e) {
			//console.log(e);
		}		
		unitGrid3.setData(objList.list);
	}

}

//=== grid =================================================
function createGrid(){
	unitGrid = new ax5.ui.grid({
        target: $('[data-ax5grid="unit-grid"]'),
        header: {
            align: "center"
        },
        body: {
        	align: "center",
        	onClick : function() {
					this.self.clearSelect();
					this.self.select(this.dindex);
					//디바이스조회
					var pEmpNumber = this.item.empNumber;	//ID
					
					var searchType="COMPANY";//시스템조회
					var params = {empNumber: pEmpNumber};
					var objList = getAjaxList("/WAC023SsoAccountDevice/ajaxSearchDeviceCompany.do", params, searchType);
					$('span.applyUserName').text(this.item.empName);
			},
        },
        columns: [
            {key: "clsName", label: "사업부"},
            {key: "locName", label: "사업장"},
            {key: "empId", label: "아이디"},
            {key: "empName", label: "이름"},          
            {key: "empNumber", label: "사번"},
            {key: "empEmail", label: "이메일", width:200}
        ]
	});
}

function createGridSub1(){
	
	unitGrid2 = new ax5.ui.grid({
        target: $('[data-ax5grid="unit-grid2"]'),
        header: {
            align: "center"
        },
        body: {
        	align: "center",
        	onClick : function() {
        		this.self.clearSelect();
				this.self.select(this.dindex);

				//디바이스조회
				var pEmpNumber = this.item.empNumber;	//ID
				var pInOutType ="I";	//내부(I)/외부(O) 구분
				//DNKA===CLS000001, DNKE===CLS000002, DNKR===CLS000003
				var pCompany = this.item.company;
				var pChangeCompany = this.item.company;
				var pEmpWorkPlace = this.item.workPlace;	//사업장
				/*
				var pChangeCompany = "";	//사업부
				//alert(chkCompany+"===" +this.item.clsCode);
				if(chkCompany=="CLS000001"){
					pChangeCompany="PS";
				}else if(chkCompany=="CLS000002"){
					pChangeCompany="PE";
				}else if(chkCompany=="CLS000003"){
					pChangeCompany="KR";
				}
				*/
				var searchType="DEVICE";//시스템조회
				var params = {empNumber: pEmpNumber, company: pCompany, changeCompany: pChangeCompany, inOutType: pInOutType, workPlace: pEmpWorkPlace};
				var objList = getAjaxList("/WAC021SsoAccountInt/ajaxSearchDetail.do", params, searchType);
				$('span.applyUserCompany').text(this.item.clsName+" "+this.item.locName);
        	},/*
        	onDBLClick : function() {
					this.self.clearSelect();
					this.self.select(this.dindex);

					//디바이스조회
					var pEmpNumber = this.item.empNumber;	//ID
					var pInOutType ="I";	//내부(I)/외부(O) 구분
					//DNKA===CLS000001, DNKE===CLS000002, DNKR===CLS000003
					var pCompany = this.item.company;
					var pChangeCompany = this.item.company;
					
					var searchType="DEVICE";//시스템조회
					var params = {empNumber: pEmpNumber, company: pCompany, changeCompany: pChangeCompany, inOutType: pInOutType};
					var objList = getAjaxList("/WAC021SsoAccountInt/ajaxSearchDetail.do", params, searchType);

					$('span.applyUserCompany').text(this.item.clsName);
			},
			*/
        },
        columns: [
           {key: "empNumber", label: "사번"},
           {key: "empId", label: "사용자ID"},
           {key: "empName", label: "사용자명"},
           {key: "clsName", label: "사업부명"},
           {key: "company", label: "사업부"},
           {key: "locName", label: "사업장명"},
           {key: "workPlace", label: "사업장"}
        ]
	});
}

function createGridSub2(){
	unitGrid3 = new ax5.ui.grid({
        target: $('[data-ax5grid="unit-grid3"]'),
        header: {
            align: "center"
        },
        body: {
        	align: "center",
        	onClick : function() {
				this.self.clearSelect();
				this.self.select(this.dindex);
				/*
	    		$('#sysSeq').val(this.item.sysSeq);
	    		$('#userId').val(this.item.empId);
	    		$('#systemId').val(this.item.systemId);
	    		$('#systemPW').val(this.item.systemPW);
	    		$('#systemGroup').val(this.item.systemGroup);
	    		$('#remarks').val(this.item.remarks);
				 */
        	},
			onDataChanged :function() {
				if (this.key === "systemId"){
					var pSystemIdOrg = this.item.systemId;	//사업부
					var pSystemId = pSystemIdOrg.replace(/([ㄱ-힣])/g, '');
					unitGrid3.setValue(this.dindex, "systemId", pSystemId);
				}
				if (this.key === "systemPW"){
					var pSystemPWOrg = this.item.systemPW;	//사업부
					var pSystemPW = pSystemPWOrg.replace(/([ㄱ-힣])/g, '');
					unitGrid3.setValue(this.dindex, "systemPW", pSystemPW);
				}
			}
        },
        columns: [
            {key: "sysName", label: "시스템"},
            /*
            {key: "systemId", label: "아이디", editor : {	type : "text",disabled: function () {  return true; },
            	attributes: { 'maxlength': 5, 'data-maxlength': 10 }
            	}
            },
            */
            {key: "systemId", label: "아이디", editor: {type: "text", disabled: function () {
            	var rlt = false;
            	if (this.item.sysSeq == "7"|| this.item.sysSeq == "9"){
            		rlt = true;
            	}
            	return rlt;
            	},
            	 attributes:{'maxlength': 10,'data-maxlength': 10} },
            	 styleClass: function () { return (this.item.sysSeq == "7"|| this.item.sysSeq == "9") ? "" : "grid-cell-blue"; } //JSP파일의 스타일 CSS참조
            },
            {key: "systemPW", label: "패스워드", editor: {type: "text", disabled: function () {
            	var rlt = false;
            	if (this.item.sysSeq == "7"|| this.item.sysSeq == "9"){
            		rlt = true;
            	}
            	return rlt;
            	},
            	attributes:{'maxlength': 10,'data-maxlength': 10}},
            	 styleClass: function () { return (this.item.sysSeq == "7"|| this.item.sysSeq == "9") ? "" : "grid-cell-blue"; } //JSP파일의 스타일 CSS참조
            },   
            	
            {key: "systemGroup", label: "디바이스", editor: {
            	type: "select",
            	//config: {columnKeys: {optionValue: "deviceId", optionText: "deviceName"}, options: deviceSelectList}
        		config: {options: deviceSelectList}
            	}, styleClass: function () { return "grid-cell-blue"; }
            },
            {key: "remarks", label: "비고", width:200, editor: {type: "textarea", attributes:{'maxlength': 50,'data-maxlength': 50}},
            	styleClass: function () { return "grid-cell-blue";} }
            ,
            {key: "company", label: "사업부"},           
            {key: "workPlace", label: "사업장"}
        ]
	});
}

function commonClear(){
	createGrid();
	createGridSub1();
	createGridSub2();

}
$(document).ready(function() {
	mask.close();
	
//	=== grid =================================================
	createGrid();
	createGridSub1();
	createGridSub2();
	
	$('._searchBtn_').on('click', function() {
		search();
		return false;
	});	
	
	$('.exel').on('click', function() {
		alert("지원하지 않는 기능입니다.");
		return;
		//unitGrid.exportExcel("사용자정보.xls");
	});
//	=== //grid =================================================
    
	
	$('[data-ax5formatter]').ax5formatter();
	 // Select Month
    picker.bind({
        target: $('[data-picker-date="month"]'),
        content: {
            type: 'date',
            config: {
                mode: "year", selectMode: "month"
            },
            formatter: {
                pattern: 'date(month)'
            }
        }
    });
  //아이디,성명 셀렉트박스의 값이 변경될때  
	$('select.nameId').change(function(){
		var nameId = this.value;
		if (nameId === 'empName') {
			$('#empName').val($('#searchData').val());
			$('#empId').val("");
		} else {
			$('#empId').val($('#searchData').val());
			$('#empName').val("");
		}
	});
	
	$('[data-grid-control]').click(function () {
		switch (this.getAttribute("data-grid-control")) {
			case "row-save":
				/*
				console.log(unitGrid3.getList("modified"));
				console.log(unitGrid3.getList("modified").length);
				var saveParams = unitGrid3.getList("modified");
				//console.log(saveParams.length);
				if (saveParams.length != 0){
					console.log("SAVE");
					//var saveObjList = saveAction("/WAC021SsoAccountInt/saveAction.do", saveParams);
				}
				*/	
				var saveParams = [];
				var modifiedList = unitGrid3.getList('modified');	//수정 List
				var deletedList = unitGrid3.getList('deleted');	//삭제 List
				
				//수정 List array ADD
				for(var i=0; i<modifiedList.length; i++){
					modifiedList[i]['useYn'] = 'Y';	
					saveParams[i] = modifiedList[i]
                }
				console.log(saveParams);
				//삭제 List array ADD
				for(var i=0;  i<deletedList.length ; i++){
					deletedList[i]['useYn'] = 'N';
					saveParams[saveParams.length++] = deletedList[i]
               }
				console.log(saveParams);

				if (saveParams.length != 0){
					console.log("SAVE");
					var saveObjList = saveAction("/WAC021SsoAccountInt/saveAction.do", saveParams);
				}
				
				break;
			case "row-delete":
				//unitGrid3.removeRow("selected"); 
				unitGrid3.deleteRow("selected"); 
				alert("[알림]화면에서만 삭제됩니다. 저장버튼을 눌러주세요.");

				/*
				console.log(unitGrid3.getList("deleted"));
				console.log(unitGrid3.getList("deleted").length);
				var saveParams = unitGrid3.getList("deleted");
				console.log(saveParams);

				//console.log(saveParams.length);
				if (saveParams.length != 0){
					console.log("Delete");
					//var saveObjList = saveAction("/WAC021SsoAccountInt/saveAction.do", saveParams);
				}
				*/
				break;
			
		}
	});
}) 
