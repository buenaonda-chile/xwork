var unitGrid;
var unitGrid2;
var unitGrid3;

var vnameMap = new HashMap();

var picker = new ax5.ui.picker();

//Grid2에서 사용하기위함.
var gridEmpNumber;
var gridEmpId;
var gridEmpName;
var gridCompany;
var gridWorkPlace;
//var gridCompanyName;

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
	var objList = getAjaxList("/WAC023SsoAccountDevice/ajaxSearch.do", params, searchType);
	
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
	//console.log("ajaxParams:" + ajaxParams);
	//console.log(JSON.stringify(ajaxParams));
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
					var objList = getAjaxList("/WAC023SsoAccountDevice/ajaxSearchDeviceCompany.do", params, searchType);
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
            {key: "empEmail", label: "이메일"}//JSP파일의 스타일 CSS참조
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
				var pEmpCompany = this.item.company;	//사업부
				var pEmpWorkPlace = this.item.workPlace;	//사업장
				
				var searchType="DEVICE";//시스템조회
				var params = {empNumber: pEmpNumber, company: pEmpCompany, workPlace: pEmpWorkPlace};
				var objList = getAjaxList("/WAC023SsoAccountDevice/ajaxSearchDetail.do", params, searchType);
				$('span.applyUserCompany').text(this.item.clsName+" "+this.item.locName);

				/*
				 if (this.item.rowType !== 'insert') {
							subCmcGrid.setData("SUB", this.item.cmcCode);
							parentCode = this.item.cmcCode;
						}
				 */
        	}/*,
        	onDBLClick : function() {
					this.self.clearSelect();
					this.self.select(this.dindex);
					//디바이스조회
					var pEmpNumber = this.item.empNumber;	//ID
					var pEmpCompany = this.item.company;	//사업부
					
					var searchType="DEVICE";//시스템조회
					var params = {empNumber: pEmpNumber, company: pEmpCompany};
					var objList = getAjaxList("/WAC023SsoAccountDevice/ajaxSearchDetail.do", params, searchType);
					$('span.applyUserCompany').text(this.item.clsName);
					
			}*/
        	/*,
			onDataChanged :function() {
				  var setClsName="";
				  var pEmpCompany = this.item.company;	//사업부
	        	  if(pEmpCompany=="CLS000001"){
	        		  setClsName = "구 DNKA";
	        	  }else if(pEmpCompany=="CLS000002"){
	        		   setClsName = "구 DNKE";
	        	  }
	        	  unitGrid2.setValue(this.dindex, "clsName", setClsName);
	        	  createGridSub2();
	        	  $('span.applyUserCompany').text("");
			}*/
        },
        columns: [
           {key: "empNumber", label: "사번"},
           {key: "empId", label: "사용자ID"},
           {key: "empName", label: "사용자명"},
           {key: "clsName", label: "사업부명"},
           {key: "company", label: "사업부"},
           {key: "locName", label: "사업장명"},
           {key: "workPlace", label: "사업장"}
          /* 
           {key: "company", label: "사업부",
        	   editor: {
	           	type: "select",
	           	config: {
	        		columnKeys: { optionValue: "cd", optionText: "cdnm"},
	        		options: [
						{cd: "CLS000001", cdnm: "구KA"},
						{cd: "CLS000002", cdnm: "구KE"}
						]
	           		}
        	   },
	           formatter: function(){
	    		   return this.value
	    	   }
           }*/
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
				if (this.key === "deviceName"){
					var pDeviceNameOrg = this.item.deviceName;	//사업부
					var pDeviceName = pDeviceNameOrg.replace(/([ㄱ-힣])/g, '');
					unitGrid3.setValue(this.dindex, "deviceName", pDeviceName.toUpperCase());
					
					var pDeviceNameChk = pDeviceName;	//사업부
					var duplicate= 0;
					for(var i=0; i < unitGrid3.list.length; i++) {
						/*
						var idx = ax5.util.search(unitGrid3.list[i], function () {
							if(this == pDeviceNameChk && this !=''){
								duplicate++;
							}
						});
						*/
						var duplicateVal = unitGrid3.list[i][
								ax5.util.search(unitGrid3.list[i], function (k) {
						            return k == "deviceName";
						   })
						]
						if(duplicateVal == pDeviceNameChk && duplicateVal !=''){
							duplicate++;
						}
					}
					if(duplicate>1){
						alert("[알림]"+pDeviceNameChk+"중복된 DATA가 존재합니다. 확인해주세요.");
					}
				}
				//onChange : 컬럼값 변경시 색상변경
				if (this.key === "useYn"){
					/*var pStyle = this.item.useYn;	//사용유무
					this.key.styleClass == function () {
						var chgStyle="";
						if (pStyle == "Y"){
							chgStyle ="grid-cell-ime-red";
						} else{
							chgStyle ="grid-cell-ime-blue";
						}
						return chgStyle;
					} //JSP파일의 스타일 CSS참조
*/					this.self.repaint();
				}
			}
        },
        columns: [
           {key: "deviceId", label: "디바이스 코드"},
           {key: "empNumber", label: "사번"},
           {key: "deviceType", label: "디바이스 ID"},
           {key: "deviceName", label: "디바이스명",
        	   //editor: {type: "text", disabled: function() {return false;}, attributes:{'maxlength': 5,'data-maxlength': 5}},
        	   editor: {type: "text", attributes:{'maxlength': 5,'data-maxlength': 5}},
        	   styleClass: function () { return (this.item.useYn == "Y") ? "grid-cell-ime-red" : "grid-cell-ime-blue"; } //JSP파일의 스타일 CSS참조

           /*,
		       formatter : function() {
		    	   	var upperData = this.value;
	        		if(upperData != null) {
	        			return upperData.toUpperCase();
	        		} else {
	        			return upperData;
	        		}
		   	   }
		    */
           },
           {key: "useYn", label: "사용유무",
        	   editor: {
	           	type: "select",
	           	config: {
	        		columnKeys: { optionValue: "cd", optionText: "cdnm"},
	        		options: [
						{cd: "Y", cdnm: "사용"},
						{cd: "N", cdnm: "미사용"}
						]
	           		}
        	   },
	           /*formatter: function(){
	    		   return this.value
	    	   },*/
        	   /*
        	   formatter: "useYn", 
               editor: {
                   type: "AXSelect",
                   options: [
                       {optionValue: "Y", optionText: "사용"},
                       {optionValue: "N", optionText: "미사용"}
                   ]
               }
				*/
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
					if(gridCompany=="CLS000001"){
						addCompany = "CLS000002";
						addWorkPlace = "LOC000004";
					}else if(gridCompany=="CLS000002"){
						addCompany = "CLS000001";
						addWorkPlace = "LOC000001";
					}else if(gridCompany=="CLS000003"){	//구의왕
						addCompany = "CLS000002";
						addWorkPlace = "LOC000004";
					}
				}
				if(rowSize < 2){
					//unitGrid2.addRow($.extend({}, unitGrid2.list[Math.floor(Math.random() * unitGrid2.list.length)], {__index: undefined}));
					//var vItem = {"empNumber" : "New User", "empId" : "empId User", "empName" : "empNamer", "company" : "CLS000001"};
					//var sItem = unitGrid.getList("selected");
					//var vItem = {"empNumber" : sItem.item.empNumber, "empId" : "empId User", "empName" : "empNamer", "company" : "CLS000001"};
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
					var vItem = {"empNumber": gridEmpNumber, "empId": gridEmpId, "empName": gridEmpName, "company": addCompany, "clsName": gridCompanyName, "locName": gridWorkPlaceName, "workPlace": addWorkPlace};
					unitGrid2.addRow($.extend({}, vItem, {}), "last", {focus: "END"});	
					unitGrid2.clearSelect();
					unitGrid2.select(rowSize);
					//unitGrid2.body.dblClick.call(unitGrid2, 1);
					
					var searchType="DEVICE";//시스템조회
					var params = {empNumber: gridEmpNumber, company: addCompany, workPlace: addWorkPlace};
					var objList = getAjaxList("/WAC023SsoAccountDevice/ajaxSearchDetail.do", params, searchType);
					$('span.applyUserCompany').text(gridCompanyName+" "+gridWorkPlaceName);
				
				}else{
					alert("[알림]최대2행까지만 추가가능합니다.");
				}
			
				break;
			case "row-remove":
				unitGrid2.removeRow();
				createGridSub2();
				break;
				/*
			case "row-update":			
				var updateIndex = Math.floor(Math.random() * unitGrid2.list.length);
				unitGrid2.updateRow($.extend({}, unitGrid2.list[updateIndex], {price: 100, amount: 100, cost: 10000}), updateIndex);
				break;
			*/	
			case "row-save":
				//console.log(unitGrid3.getList("modified"));
				/*
				var saveParams = unitGrid3.getList("modified");
				if (saveParams != null){
					var saveObjList = saveAction("/WAC023SsoAccountDevice/saveAction.do", saveParams);
				}
				*/				
				var saveParams = unitGrid3.getList("modified");
				if (saveParams.length != 0){
					var saveObjList = saveAction("/WAC023SsoAccountDevice/saveAction.do", saveParams);
				}
				/*
				ax5Grid.getList();
				ax5Grid.getList("selected");
				ax5Grid.getList("modified");
				ax5Grid.getList("deleted");
				*/
				break;
			
		}
	});
          
}) 
