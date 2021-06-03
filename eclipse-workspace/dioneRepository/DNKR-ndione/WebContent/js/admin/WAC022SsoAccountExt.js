var unitGrid;

var picker = new ax5.ui.picker();
//Grid2에서 사용하기위함.
var gridEmpNumber;
var gridEmpId;
var gridEmpName;
var gridCompany;
var gridWorkPlace;


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
	var objList = getAjaxList("/WAC022SsoAccountExt/ajaxSearch.do", params, searchType);
	
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
	/*
	try { 
		objList.vnameList.forEach(function(item, index) {
			vnameMap.put(item.vndnr, item.vname);
		});
		
	} catch (e) {
		//console.log(e);
	}
	*/
	if(searchType=="ACCOUNT"){
		unitGrid.setData(objList.list);
		$('span.total').text(objList.list.length);	
		//unitGrid.select(0,{selectedClear: true});
		unitGrid.select(0, {selected: true});
		unitGrid.focus(0);
		//unitGrid.body.click.call(unitGrid.focus(0), 0);
		//unitGrid.body.click.call(unitGrid, 0);
		//createGridSub1();	//초기화 - 삭제 2019.02.25 : row추가시 중복발생
		//createGridSub2();	//초기화- 삭제 2019.02.25 : row추가시 중복발생
		$('span.applyUserName').text("");
		$('span.applyUserCompany').text("");
		createGridSub1();
		createGridSub2();

	}
	else if(searchType=="COMPANY"){
		unitGrid2.setData(objList.list);
		createGridSub2();
		if(unitGrid2.list.length> 0){
			//unitGrid.clearSelect();
			unitGrid2.focus(0);
			unitGrid2.select(0, {selected: true});
		}
		$('span.applyUserCompany').text("");
	}else {
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
				var objList = getAjaxList("/WAC022SsoAccountExt/ajaxSearchSystemCompany.do", params, searchType);
				$('span.applyUserName').text(this.item.empName);
				//console.log(this.item.clsCode);
				gridEmpNumber = this.item.empNumber;
				gridEmpId = this.item.empId;
				gridEmpName = this.item.empName;
				gridCompany = this.item.clsCode;
				gridWorkPlace = this.item.locCode;

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
	unitGrid2= null;
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
				var pInOutType ="O";	//내부(I)/외부(O) 구분
				var pEmpCompany = this.item.company;	//사업부
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
				var searchType="SYSTEM";//시스템조회
				var params = {empNumber: pEmpNumber, company: pEmpCompany, changeCompany: pChangeCompany, inOutType: pInOutType, workPlace: pEmpWorkPlace};
				var objList = getAjaxList("/WAC022SsoAccountExt/ajaxSearchDetail.do", params, searchType);
				$('span.applyUserCompany').text(this.item.clsName);
        	}
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
				if (this.key === "systemGroup"){
					var pSystemGroupOrg = this.item.systemGroup;	//사업부
					var pSystemPW = pSystemPWOrg.replace(/([ㄱ-힣])/g, '');
					unitGrid3.setValue(this.dindex, "systemPW", pSystemPW);
				}
			}

        },
        columns: [
            {key: "sysName", label: "시스템"},
            {key: "systemId", label: "아이디", editor: {type: "text", disabled: function () {
            	var rlt = false;
            	console.log(this.item.ssoYn);
            	if (this.item.ssoYn == "N"){
            		rlt = true;
            	}
            	return rlt;
            	},
            	attributes:{'maxlength': 10,'data-maxlength': 10} },
            	styleClass: function () { return (this.item.ssoYn == "N") ? "" : "grid-cell-blue"; } //JSP파일의 스타일 CSS참조
            },
            {key: "systemPW", label: "패스워드", editor: {type: "text", disabled: function () {
            	var rlt = false;
            	console.log(this.item.ssoYn);
            	if (this.item.ssoYn == "N"){
            		rlt = true;
            	}
            	return rlt;
            	},
            	attributes:{'maxlength': 10,'data-maxlength': 10} },
            	styleClass: function () { return (this.item.ssoYn == "N") ? "" : "grid-cell-blue"; } //JSP파일의 스타일 CSS참조
            },      
            {key: "systemGroup", label: "그룹", editor: {type: "text", disabled: function () {
            	var rlt = false;
            	console.log(this.item.ssoYn);
            	if (this.item.ssoYn == "N"){
            		rlt = true;
            	}
            	return rlt;
            	},
            	attributes:{'maxlength': 10,'data-maxlength': 10} },
            	styleClass: function () { return (this.item.ssoYn == "N") ? "" : "grid-cell-blue"; } //JSP파일의 스타일 CSS참조
            },
            {key: "remarks", label: "비고", width:200, editor: {type: "text", disabled: function () {
            	var rlt = false;
            	console.log(this.item.ssoYn);
            	if (this.item.ssoYn == "N"){
            		rlt = true;
            	}
            	return rlt;
            	},
            	attributes:{'maxlength': 50,'data-maxlength': 50} },
            	styleClass: function () { return (this.item.ssoYn == "N") ? "" : "grid-cell-blue"; } //JSP파일의 스타일 CSS참조
            },
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
			case "row-add": 
				var rowSize = unitGrid2.list.length;
				var addCompany ="";
				var addWorkPlace ="";

				if(rowSize == 0){
					addCompany = gridCompany;
					addWorkPlace = gridWorkPlace;
					if(gridCompany=="CLS000003"){	//구의왕의 기본이 창원
						addCompany = "CLS000001";
						addWorkPlace = "LOC000001";
					}
				}else{
					if(gridCompany=="CLS000001"){	//구KA
						addCompany = "CLS000002";
						addWorkPlace = "LOC000004";
					}else if(gridCompany=="CLS000002"){	//구KE
						addCompany = "CLS000001";
						addWorkPlace = "LOC000001";
					}else if(gridCompany=="CLS000003"){	//구의왕
						addCompany = "CLS000002";
						addWorkPlace = "LOC000004";
					}
				}
				if(rowSize < 2){
					var gridCompanyName="";
					var gridWorkPlaceName="";
					if(addCompany=="CLS000001"){
						gridCompanyName = "구 DNKA";
					}else if(addCompany=="CLS000002"){
						gridCompanyName = "구 DNKE";
					}else if(addCompany=="CLS000003"){
						gridCompanyName = "구 DIKR";
					}
					
					if(addWorkPlace=="LOC000001"){
						gridWorkPlaceName = "창원";
					}else if(addWorkPlace=="LOC000002"){
						gridWorkPlaceName = "홍성";
					}else if(addWorkPlace=="LOC000003"){
						gridWorkPlaceName = "화성";
					}else if(addWorkPlace=="LOC000004"){
						gridWorkPlaceName = "마산";
					}else if(addWorkPlace=="LOC000005"){
						gridWorkPlaceName = "의왕";
					}
					var vItem = {"empNumber" : gridEmpNumber, "empId" : gridEmpId, "empName" : gridEmpName, "company" : addCompany, "clsName" : gridCompanyName, "locName": gridWorkPlaceName, "workPlace": addWorkPlace};
					unitGrid2.addRow($.extend({}, vItem, {}), "last", {focus: "END"});	
					unitGrid2.clearSelect();
					unitGrid2.select(rowSize);
					
					var pInOutType ="O";	//내부(I)/외부(O) 구분
					
					var searchType="SYSTEM";//시스템조회
					var params = {empNumber: gridEmpNumber, company: addCompany, changeCompany: addCompany, inOutType: pInOutType, workPlace: pEmpWorkPlace};
					var objList = getAjaxList("/WAC022SsoAccountExt/ajaxSearchDetail.do", params, searchType);
					$('span.applyUserCompany').text(gridCompanyName);
				
				}else{
					alert("[알림]최대2행까지만 추가가능합니다.");
				}
			
				break;
			case "row-remove":
				//unitGrid2.removeRow("selected");
				unitGrid2.removeRow();
				createGridSub2();
				break;
			
			case "row-save":
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
					var saveObjList = saveAction("/WAC022SsoAccountExt/saveAction.do", saveParams);
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
