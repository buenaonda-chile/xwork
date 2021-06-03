var unitGrid;
var vnameMap = new HashMap();

var picker = new ax5.ui.picker();
var selectRow=0;

(function() {
	mask.open();
})();

function search() {
	
	//$('span.codeTypeNm').text($('#pCodeType').text());
	$('span.codeTypeNm').text($("#pCodeType option:checked").text());

	var pCodeType= $('#pCodeType').val();	//예외코드 타입(A:부서코드 B:기타)
	var params = {pCodeType: pCodeType};
	var objList = getAjaxList("/WAD013ExceptionCodeMngSearch/ajaxSearch.do", params)
/*
	var pCodeType = $('#codeType').val();	//사업부
	if (val_chk(pLocCode, "종료일자")) {
		var params = {locCode: pLocCode};
		var objList = getAjaxList("/WAD013ExceptionCodeMngSearch/ajaxSearch.do", params)
	}
*/	
	return false;
}

/**
 * ajax로 리스트 가져오기
 * @param url
 */
function getAjaxList (url, params) {
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
    					gridSetData(objList);
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
			
			/*setTimeout(function() {
				unitGrid.repaint();
				console.log("complete");
			}, 100);
			*/
		}
	});	
}
//=== grid =================================================

function gridSetData (objList) {
	try { 
		objList.vnameList.forEach(function(item, index) {
			vnameMap.put(item.vndnr, item.vname);
		});
		
	} catch (e) {
		//console.log(e);
	}
	unitGrid.setData(objList.list);
	$('span.total').text(objList.list.length);
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
					
					selectRow = this.dindex; //업데이트를 위해 행정보 저장
/*
					$('#codeType').val(this.item.codeType);	//예외구분
					$('#clsCode').val(this.item.clsCode);	//사업장코드
					$('#locCode').val(this.item.locCode);	//사업부코드
					$('#code').val(this.item.code);	//부서코드
					//$('#etc').val(this.item.etc);	//비고
					$('#etc').val(this.key);	//비고
					$('#useTf').val(this.item.useTf);	//타시스템 사용여부
*/					
					
/*					//row타입 가져오기
					var items =  this.options.textInput[obj.key];	
					console.log("items == "+items);
					console.log("rowType == "+items[this.dindex].rowType);*/
					
					//console.log("items == "+this.cellType);

					myModel.setModel(this.item); // grid 클릭 시 해당 item을 Binding
					//비화설화
					$("#codeType").attr("disabled", true); //예외구분
					$("#clsCode").attr("disabled", true); //사업장코드
					$("#locCode").attr("disabled", true); //사업부코드
					$("#code").attr("disabled", true); //부서코드
					//$("#deptBtn").attr("disabled", true); //부서코드
					//$("#etc").attr("disabled", false); //비고
					//$("#useTf").attr("disabled", false); //타시스템 사용여부
			},
				onDataChanged: function () {
					console.log("myModel == ");
					myModel.setModel(this.item); // grid가 달라질 때 해당 item을
					
					setTimeout(function() {
						unitGrid.repaint();
						console.log("repaint");
					}, 100);
					
					//this.self.repaint();
					//this.__modified_='true';
			}
		},
        columns: [
            {key: "codeType", label: "예외구분", width:80, styleClass: "grid-cell-red"},
            {key: "clsCode", label: "사업장코드", width:80},
            {key: "clsName", label: "사업장명", width:80, styleClass: "grid-cell-red"},
            {key: "locCode", label: "사업부코드", width:80},
            {key: "locName", label: "사업부명", width:80, styleClass: "grid-cell-red"},
            {key: "code", label: "부서코드", width:80},
            {key: "codeName", label: "부서명", styleClass: "grid-cell-red"},
            {key: "etc", label: "비고", styleClass: "grid-cell-red"},
            //{key: "useTf", label: "타시스템 사용여부", width:110}        
            {key: "useTf", label: "타시스템 사용여부", width:110, editor: {
	           	type: "select",
	           	config: {
	        		columnKeys: { optionValue: "cd", optionText: "cdnm"},
	        		options: [
						{cd: "Y", cdnm: "사용"},
						{cd: "N", cdnm: "미사용"}
						]
	           		}
        	   }, styleClass: "grid-cell-red"}
        ]
	});
}

function commonClear(){
	createGrid();
	$('span.total').text("");
}

function gridReload(obj){
	
	//timeout이 없으면 2회후 동작함.
	setTimeout(function() {
		unitGrid.repaint();
		console.log("repaint");
	}, 100);
	

	
}

/**
 * 팝업창에서 값넘겨받아 부모창에 데이터 set
 * 
 * @param returnValue
 */
function getReturnValue(returnValue) {
	if(returnValue !== null) {
		var relationObj = JSON.parse(returnValue);
		console.log(relationObj);
		$('#clsCode').val(relationObj.clsCode);
		$('#locCode').val(relationObj.locCode);
		$('#code').val(relationObj.teamCode);
		$('#codeName').val(relationObj.teamName);
		 
		var vItem = {"clsCode": relationObj.clsCode, "clsName": $("#clsCode option:checked").text(), "locCode": relationObj.locCode,
			 			"locName": $("#locCode option:checked").text(), "code": relationObj.teamCode, "codeName": relationObj.teamName};
		unitGrid.updateRow($.extend({}, unitGrid.list[selectRow], vItem), selectRow);
			
		gridReload();	
	}	
}


$(document).ready(function() {
	mask.close();
	
	myModel = new ax5.ui.binder(); // myModel이라는 binder 선언
	myModel.setModel({}, $(document["binder-form"])); // binder-form 과 연결

		
	$('._deptBtn_').on('click', function() {
		window.open("/WAD009RelationPopSelect/init.do?","relationPop","width=900,height=700,scrollbars=yes,top=100,left=100");
	});
//	=== grid =================================================
	createGrid();
	
	$('._searchBtn_').on('click', function() {
		search();
		return false;
	});	
	
	
	$('.addBtn').on('click', function() {
		var vItem = {"codeType": $("#pCodeType option:checked").val(), "useTf":"Y"};
		unitGrid.addRow($.extend({}, vItem, {}), "last", {focus: "END", rowType: "insert"});
	
		
		
		//unitGrid.focus(unitGrid.list.length-1);
		var getRowNm=unitGrid.list.length-1;
		//console.log("getRowNm == "+getRowNm);
		unitGrid.clearSelect();
		unitGrid.select(getRowNm, {selected: true});
		
		
		
		var that={
				self :"",
				column : "",
				list :"",
				item :"",
				value : "",
				dindex : 0
				}
		
		//unitGrid.config.body.onClick(that);
		/*unitGrid.body.onclick("list", function () {
			console.log(this);
			
		});*/
		
		//활성화
		//$("#codeType").attr("disabled", false); //예외구분
		//$("#clsCode").attr("disabled", false); //사업장코드
		//$("#locCode").attr("disabled", false); //사업부코드
		$("#code").attr("disabled", false); //부서코드
		$("#deptBtn").attr("disabled", false); //부서코드
		//$("#etc").attr("disabled", false); //비고
		//$("#useTf").attr("disabled", false); //타시스템 사용여부
		
		
		
	});
	
	$('.delBtn').on('click', function() {
		unitGrid.deleteRow("selected"); 
		alert("[알림]화면에서만 삭제됩니다. 저장버튼을 눌러주세요.");	
	});
	
	$('.saveBtn').on('click', function() {
		console.log(unitGrid.getList("selected"));
		//console.log(unitGrid.getList("modified"));
		
		var saveParams = [];
		var modifiedList = unitGrid.getList('modified');	//수정 List
		var deletedList = unitGrid.getList('deleted');	//삭제 List
		
		//수정 List array ADD
		for(var i=0; i<modifiedList.length; i++){
			modifiedList[i]['trProcCode'] = 'Y';	
			saveParams[i] = modifiedList[i]
        }
		console.log(saveParams);
		//삭제 List array ADD
		for(var i=0;  i<deletedList.length ; i++){
			deletedList[i]['trProcCode'] = 'N';
			saveParams[saveParams.length++] = deletedList[i]
       }
		console.log(saveParams);

		if (saveParams.length != 0){
			console.log("SAVE");
			var saveObjList = saveAction("/WAD013ExceptionCodeMngSearch/saveAction.do", saveParams);
		}
	});
	
	$('.exel').on('click', function() {
		unitGrid.exportExcel("예외부서코드 현황.xls");
	});
	


}) 
