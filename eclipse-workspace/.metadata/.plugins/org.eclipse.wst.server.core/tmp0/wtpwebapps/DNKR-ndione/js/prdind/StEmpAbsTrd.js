
//code intellisense typescript 정의
///<reference path = "../../wijmo/controls/wijmo.d.ts"/>	
///<reference path = "../../wijmo/controls/wijmo.grid.d.ts"/>
///<reference path = "../../wijmo/controls/wijmo.input.d.ts"/>

var lgsDstRtSum = 0;

var workMastG = null;  //조
var workMastA = null;  //근무코드

var workMastGMap = null;  //조
var workMastAMap = null;  //근무코드

// 컬랙션 뷰는 조회후에 그리드의 상태변경을 체크한다. 
var cv = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수

var flexGrid = new wijmo.grid.FlexGrid('#wijmoGrid');	//그리드 전역변수
var zoomSize = 11;

/**
 * 팝업창에서 값넘겨받아 부모창에 데이터 set
 * 
 * @param returnValue
 */
function getReturnValue(returnValue) {
	if(returnValue !== null) {
		var custObj = JSON.parse(returnValue);

		$('#getLocId').val(custObj.code);
		$('#getLocNm').val(custObj.name);
	}
}

/**
 * 등록시 오류검증
 */
function validation(item){	
	if(item.clsCode==null || wijmo.isEmpty(item.clsCode) || item.clsCode == ""){
		toastMsg("수정이나 추가한 행의 [사업부]컬럼을 입력해야 됩니다.");
		return false;
	}

	return true;
}

function clearGrid(){
	initSetCodeMaster('G');	//조
	initSetCodeMaster('A');	//근무코드	
	cv.sourceCollection=[];
}


function handleEvent(){
//	$('.getPyvnd').on('change', function() {
//		$(".getCusnm").val("");
//	});

	
	//등록폼 닫기버튼
	$("._closeBtn_").on("click",function(){
		var target = this.getAttribute("data-click-target");
		addBtnUiSet(this);
	});

	$('._custBtn_').on('click', function() {
		window.open("/ajaxPrdctIndComBase/initDeptPop.do","deptPop","width=550,height=600,scrollbars=yes,top=100,left=100");
	});
	
	//행 추가버튼
	$("._addBtn_").on("click",function(){
/*		
		if(!$(".getComps").val()){
			toastMsg(LN_SELECT_COMPS);
			return false;
		}else if(!$(".getPyvnd").val()){
			toastMsg(LN_SELECT_PYVND);
			return false;
		}
*/		
		var addRow = cv.addNew();
		addRow.clsCode = $(".getComps").val();
		cv.commitNew();	
		flexGrid.select(new wijmo.grid.CellRange(flexGrid.rows.length+1,0), true);		
	});
	
	// 그리드 row 삭제
	$("._delBtn").on("click",function(){
		cv.remove(cv.currentItem);
	});
}

function mailSend() {
	
	var formData = null;
	
	if(!$("#getComps").val()){
		toastMsg(LN_SELECT_COMPS);
		return false;
	}else if(!$("#getLocId").val()){
		toastMsg(LN_SELECT_DEPT);
		return false;
	}else if(!$("#getOpertDe").val()){
		toastMsg("작업일자를 입력해주세요.");
		return false;
	}	
	var url = "/ajaxStEmpAbsTrd/mailSend.do";
	var params = {
		'getComps' : $("#getComps").val()
		,'getLocId' : $("#getLocId").val()
		,'getOpertDe' : $("#getOpertDe").val()
		,'getLocNm' : $("#getLocNm").val()	
	};

 	$.ajax({
 		url: url,
 		data: params,
 		dataType: "json",
 		type: "POST",
 		error: function () {
 			alert('시스템 오류입니다.\n전산담당자에게 문의해주세요.');
 		},
 		success: function (data) {
            
			if (data.mailSendSuccess == -1) {
				alert("메일 발송을 실패하였습니다.");
				return;
			}
			
			if (data.ovrtmRqstngItms < 0) {
				alert("잔업신청 대상자가 없습니다.");
				return;
			}
			
			if (data.domainMailList <= 0) {
				alert("승인자 메일 주소가 등록되지 않았습니다.");
				return;
			}
			
			alert("작업 특근 신청 메일 전송 완료\n했습니다.");
			
			var str = "메일 대상자는 " + data.getMailList + " 명입니다.<br>"
					+ "메일 전송수는 " + data.mailSendSuccess + " 건입니다."
			
 		}
 		
 	});
} 



function search(){
	if(!$("#getComps").val()){
		toastMsg(LN_SELECT_COMPS);
		return false;
	}else if(!$("#getLocId").val()){
		toastMsg(LN_SELECT_DEPT);
		return false;
	}else if(!$("#getOpertDe").val()){
		toastMsg("작업일자를 입력해주세요.");
		return false;
	}	
	var url = "/ajaxStEmpAbsTrd/search.do";	
	var params = {
		'getComps' : $("#getComps").val()
		,'getLocId' : $("#getLocId").val()
		,'getOpertDe' : $("#getOpertDe").val()		
//		,'name' : $("#name").val()		
	};
	
	mask.open();
	$.ajax({
		method : "post",
		url : url,
		data :params,
		success : function(res) {
			var data = JSON.parse(res).list;
			cv.sourceCollection = data;
			var rcvsupTm = JSON.parse(res).rcvsupTm;
			$("#getRcvsupTm").val(rcvsupTm);
			var sumWorkTime = JSON.parse(res).sumWorkTime;
			$("#getTtlWork").val(sumWorkTime);			
/*			for ( var i = 0; i < cv._src.length; i ++) {
				cv._src[i].rownum = i;
			}			
*/		},
		error : function() {
			console.log("dataset.error");
		},
		complete : function() {
			//console.log("dataset.completed");
			setTimeout(function() {
				mask.close();				
			}, 500);
			
		}
	});
	
}

//수정
function update(){
	/**
	 * 익스플로러에서 그리드외 다른영역으로 포커스가 빠졌을경우(클릭) 컬랙션뷰에서 변경된 내용을 인식하지 못하는 버그발생
	 * 아래처럼 포커스와 셀을 강제로 영역을 지정함.
	 */
	flexGrid.focus ();
	flexGrid.select( new wijmo.grid.CellRange( 0 , 0 , 0 , 0 ), true );
		
//	if(flexGrid.rows.length<1){
//		toastMsg("등록할 내용이 없습니다.");
//		return;
//	} 

	//validation	
/*	for ( var i = 0; i <cv.itemsAdded.length; i ++) {
		if(!validation(cv.itemsAdded[i])){
			return false;
		}	
		isModify = true;
	}
	
	for ( var i = 0; i <cv.itemsEdited.length; i ++) {
		if(!validation(cv.itemsEdited[i])){
			return false;
		}	
		isModify = true;
	}*/


	for ( var i = 0; i <cv._src.length; i ++) {
		if(!validation(cv._src[i])){
			return false;
		}
		isModify = true;
	}
		
	var stateMsg=RESULT_OK;
	var isModify = false;

 	for ( var i = 0; i <cv._src.length; i ++) {
//		console.log(cv._src[i]);
		if( typeof cv._src[i].workCode != "undefined" && cv._src[i].workCode != "" && cv._src[i].workCode != null &&   
			typeof cv._src[i].shiftwork != "undefined" && cv._src[i].shiftwork != "" && cv._src[i].shiftwork != null
		){		
			cv._src[i].rownum = i;
			$.ajax({
				method : "post",
				url : "/ajaxStEmpAbsTrd/update.do",
				data : cv._src[i],
				async: false,
				success : function(xhr) {
	    	    	var data = JSON.parse(xhr);
	            	
	    	    	if(data.result != RESULT_OK) {
						var rowNum = cv._src[i].rownum;
						if(typeof rowNum != "undefined" && rowNum != "" && rowNum != null){						
							addErrorLineColor(flexGrid,rowNum);
						}
						    				
	    	    		if(data.errMsg == "LN_UPD_CHK1") stateMsg = LN_UPD_CHK1;
	    				if(data.errMsg == "LN_UPD_CHK2") stateMsg = LN_UPD_CHK2;
	    				if(data.errMsg == "LN_UPD_CHK3") stateMsg = LN_UPD_CHK3;
	    				if(data.errMsg == "LN_UPD_CHK4") stateMsg = LN_UPD_CHK4;	
	    				if(data.errMsg == "LN_INS_CHK5") stateMsg = LN_INS_CHK5;	
	
	    			} 
					if(data.result == RESULT_OK){
						//성공시 rownum이 있으면 라인색상 제거
						var rowNum = cv._src[i].rownum;
						if(typeof rowNum != "undefined" && rowNum != "" && rowNum != null){		
							removeErrorLineColor(flexGrid,rowNum);
						}
					}
	    	    },
	            error : function() {
	    			stateMsg = "error";
					var rowNum = cv._src[i].rownum;
					addErrorLineColor(flexGrid,rowNum);	
	    		},
	    		complete : function() {
	    			//toastMsg(stateMsg);
	    		}
			});
		}
		
		isModify = true;
		
     } 
	
	// Update : 업데이트 프로세스 
/*    for ( var i = 0; i <cv.itemsEdited.length; i ++) {
		console.log(cv.itemsEdited[i]);
		$.ajax({
			method : "post",
			url : "/ajaxStEmpAbsTrd/update.do",
			data : cv.itemsEdited[i],
			async: false,
			success : function(xhr) {
    	    	var data = JSON.parse(xhr);
            	
    	    	if(data.result != RESULT_OK) {
					var rowNum = cv.itemsEdited[i].rownum;
					if(typeof rowNum != "undefined" && rowNum != "" && rowNum != null){						
						addErrorLineColor(flexGrid,rowNum);
					}
    	    		if(data.errMsg == "LN_UPD_CHK1") stateMsg = LN_UPD_CHK1;
    				if(data.errMsg == "LN_UPD_CHK2") stateMsg = LN_UPD_CHK2;
    				if(data.errMsg == "LN_UPD_CHK3") stateMsg = LN_UPD_CHK3;
    				if(data.errMsg == "LN_UPD_CHK4") stateMsg = LN_UPD_CHK4;	
    				if(data.errMsg == "LN_INS_CHK5") stateMsg = LN_INS_CHK5;	
    			} 
				if(data.result == RESULT_OK){
					//성공시 rownum이 있으면 라인색상 제거
					var rowNum = cv.itemsEdited[i].rownum;
					if(typeof rowNum != "undefined" && rowNum != "" && rowNum != null){		
						removeErrorLineColor(flexGrid,rowNum);
					}
				}
    	    },
            error : function() {
    			stateMsg = "error";
				var rowNum = cv.itemsEdited[i].rownum;
				addErrorLineColor(flexGrid,rowNum);	
    		},
    		complete : function() {
    			//toastMsg(stateMsg);
    		}
		});
		
		
		isModify = true;
		
     } 
    // Create : 생성 처리
    
    for ( var i = 0; i <cv.itemsAdded.length; i ++) {
    	console.debug(cv.itemsAdded[i]);
		
		$.ajax({
			method : "post",
			url : "/ajaxStEmpAbsTrd/create.do",
			data : cv.itemsAdded[i],
			async: false,
			success : function(xhr) {
            	var data = JSON.parse(xhr);
            	
    			if (data.result != RESULT_OK) {
    				if(data.errMsg == "LN_INS_CHK1") stateMsg = LN_INS_CHK1;
					if(data.errMsg == "LN_INS_CHK2") stateMsg = LN_INS_CHK2;
				}     			
            },
            error : function() {
    			toastMsg("error");
    		},
    		complete : function() {
    			
    		}
		});
		
		isModify = true;
    } */

    // Delete : 삭제 처리 
    for ( var i = 0; i <cv.itemsRemoved.length; i ++) {
    	console.debug(cv.itemsRemoved[i]);
		$.ajax({
			method : "post",
			url : "/ajaxStEmpAbsTrd/delete.do",
			data : cv.itemsRemoved[i],
            async: false,
            success : function(xhr) {
            	
            	var data = JSON.parse(xhr);
            	
            	if (data.result != RESULT_OK) {
    				if(data.errMsg == "LN_DEL_CHK1") stateMsg = LN_DEL_CHK1;
				} 
    		},
            error : function() {
    			toastMsg("error");
    		},
    		complete : function() {
    			
    		}
		});		
		
		isModify = true;    	
    }
    
	if(isModify){
		
		if(stateMsg == RESULT_OK){
    		toastMsg(RESULT_OK);
    		search();
	    	
	    }else{
	    	toastMsg(stateMsg);
	    }
			
	}else{
		toastMsg("등록할 내역이 없습니다.");
	}
}

//지원받은시간(분) 저장
function rcvsupTmUpdate() {
	if(!$("#getComps").val()){
		toastMsg(LN_SELECT_COMPS);
		return false;
	}else if(!$("#getLocId").val()){
		toastMsg(LN_SELECT_DEPT);
		return false;
	}else if(!$("#getOpertDe").val()){
		toastMsg("작업일자를 입력해주세요.");
		return false;
	}		
	
	var stateMsg=RESULT_OK;	
	var paramsData = {
		'getComps' : $("#getComps").val()
		,'getLocId' : $("#getLocId").val()
		,'getOpertDe' : $("#getOpertDe").val()		
		,'getRcvsupTm' : $("#getRcvsupTm").val()		
	};
	
	$.ajax({
		method : "post",
		url : "/ajaxStEmpAbsTrd/SaveRcvsupTm.do",
		data : paramsData,
		async: false,
		success : function(xhr) {
        	var data = JSON.parse(xhr);
			if (data.result != RESULT_OK) {
				if(data.errMsg == "LN_INS_CHK1") stateMsg = LN_INS_CHK1;
				if(data.errMsg == "LN_INS_CHK2") stateMsg = LN_INS_CHK2;
			}
		     			
        },
        error : function() {
			toastMsg("error");
		},
		complete : function() {

		}
	});

	if(stateMsg == RESULT_OK){
		toastMsg(RESULT_OK);
		search();
    }else{
    	toastMsg(stateMsg);
    }
}

/**
 * 엑셀 다운로드
 */
function downloadExcel(){
	
	var fileName = "일일근태등록_"+getToday()+".xlsx";
	
	wijmo.grid.xlsx.FlexGridXlsxConverter.saveAsync(flexGrid, 
		{includeColumnHeaders: true},
	    fileName,
	    function (base64) {
			// user can access the base64 string in this callback.
			document.getElementById('importFile').href = 'data:application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;' + 'base64,' + base64;
			//console.log(base64);
		}, 
		function (reason) {
			//User can catch the failure reason in this callback.
			console.log('The reason of save failure is ' + reason);
	  	}
	);
	
	
}

var inputNumber = new wijmo.input.InputNumber(document.createElement('div'),{
	format:'n0'
});

inputNumber.inputElement.maxLength = 3;

function gridInit(){
//	var comsBase = new DataMap(coms_base, 'id', 'name');
	var columnsDefinition=[	
		{binding:'opertDe',visible:false},
		{binding:'clsCode',visible:false},				
		{binding:'locCode',visible:false},
		{binding:'empnm',header: '* '+ LB_FULL_NM, width: 150, align:'center',dataType:'String', maxLength:50,isReadOnly: true},		
		{binding:'empno',header: '* '+ LB_EMP_NUMBER, width: 150, align:'center',dataType:'String', maxLength:50,isReadOnly: true},		
		{header: '근무조', align: 'center',  columns: [
			{binding:'shiftwork',header: '코드', width: 150, align:'center',dataType:'String', maxLength:2, dataMap: workMastGMap},
			{binding:'shiftworkNm',header: '코드명', width: 150, align:'center',dataType:'String',  maxLength:50,isReadOnly: true}
		]},
		{binding:'logiType',header: '물류Check', width: 150, align:'center',dataType:'Boolean', maxLength:1},		
		{binding:'workCode',header: '근무코드', width:120, align:'center',dataType:'String', maxLength:2, dataMap: workMastAMap},			
//		{header: '근무코드', align: 'center',  columns: [
//			{binding:'workCode',header: '코드', width:120, align:'center',dataType:'String', maxLength:2, dataMap: workMastAMap},
//			{binding:'workNm',header: '코드명', width: '*', align:'center',dataType:'String', maxLength:50,isReadOnly: true}
//		]},	
		//{binding:'lrlyTime',header: '조퇴', width: '*', align:'center', dataType:'Number', editor: inputMask, isRequired:false},
//		{binding:'lrlyTime',header: '조퇴', width: '*', align:'center',   dataType:'Number', editor:inputNumber, isRequired:false},
//		{binding:'latenTime',header: '지각', width: '*', align:'center',dataType:'Number', editor:inputNumber, isRequired:false},
//		{binding:'gnotTime',header: '외출', width: '*', align:'center',dataType:'Number', editor:inputNumber, isRequired:false},
		{binding:'rsnsOvrt',header: '잔업사유', width: 300, align:'left',dataType:'String', maxLength:50},
		{binding:'arqstTime',header: '지원보낸시간', width: 100, align:'center',dataType:'Number', editor:inputNumber, isRequired:false},
		{binding:'workPsbTime',header: '근무가능시간', width: 100, align:'center',dataType:'Number',editor:inputNumber, isReadOnly: true},
		{binding:'saveSts',header: '저장상태', width: 120, align:'center',dataType:'String', isReadOnly: true},			
		{binding:'rownum',visible:false}
	];
	//컬럼 초기화
	flexGrid.initialize({
		columns: columnsDefinition
	});
//	flexGrid.columnHeaders.rows.defaultSize = 50; 	// 열 헤더 영역에 행의 높이 설정		
}

/*
function validationCodeNull(item){
	if(item.shiftwork.length > 0 
	||item.shiftwork.length > 0 
	){
		
	}
}
*/


function gridEvent(){
	//validation
	cv.getError = function(item,prop){
		switch(prop){
			case "clsCode":
				if(item.clsCode==null || wijmo.isEmpty(item.clsCode) || item.clsCode == ""){
					return "[사업부]을 입력해야 됩니다.";
				}
				return null;
			case "shiftwork":
				if(item.shiftwork==null || wijmo.isEmpty(item.shiftwork) || item.shiftwork == "" ){
				}else{					
					var flag = true;
					if(workMastG != null) {					
						workMastG.forEach (function (data, index) {			  		
							var mastCode = data.code;
							var masterName = data.codeNm;
							var itemCode = item.shiftwork;
							if(itemCode != null) {
								itemCode = itemCode.trim();
							}
							if(mastCode != null) {
								mastCode = mastCode.trim();
							}						
							if(itemCode == mastCode) {
								item.shiftworkNm = masterName;
								flag = false;
								return false;
							}
						});	
					}
					if(flag) {
						item.shiftwork = "";
						item.shiftworkNm = "";
					}						
				}
				return null;
			case "workCode":
				if(item.workCode==null || wijmo.isEmpty(item.workCode) || item.workCode == "" ){
				}else{
					var flag = true;
					var message = "";
					if(workMastA != null) {					
						workMastA.forEach (function (data, index) {			  		
							var mastCode = data.code;
							var masterName = data.codeNm;
							var overtimeM = data.overtimeM; //근무시간
							
							var itemCode = item.workCode;
							if(itemCode != null) {
								itemCode = itemCode.trim();
							}
							if(mastCode != null) {
								mastCode = mastCode.trim();
							}
							if(itemCode == mastCode) {
								item.workNm = masterName;
								//근무시간이 근무가능시간보다 클경우
								var numOvertimeM = getChangeNumber(overtimeM);	
								var numWorkPsbTime = getChangeNumber(item.workPsbTime);	//근무시간
								var numLrlyTime = getChangeNumber(item.lrlyTime);	    //조퇴
								var numLatenTime = getChangeNumber(item.latenTime);	    //지각
								var numGnotTime = getChangeNumber(item.gnotTime);	    //외출
								var workTime = numWorkPsbTime - (numLrlyTime + numLatenTime + numGnotTime);
								if(numOvertimeM > workTime) {
									flag = true;
									message = "주52시간관리로 OVER 되었습니다.";	
									return false;	
								}
								flag = false;
								return false;															
							}
						});	
					}
					if(flag) {
						item.workCode = "";
						item.workNm = "";
						if(message.length > 0) {
							return message;
						}
					}
				}
				return null;
			case "lrlyTime":
				if(item.lrlyTime==null || wijmo.isEmpty(item.lrlyTime) || item.lrlyTime == ""){
				}else{
					var strVal = item.lrlyTime.toString().split(".")[0];
					 return strVal.length > 4 ? "네 자리 이하 정수를 입력하시오" : "";
				}
				return null;				
								
		}
		return null;
	}
	
	flexGrid.pastedCell.addHandler(function(s,e){
		s.setCellData(e.row,"rownum",e.row,true);
	});
	
	/**
	 * 수정할경우 rownum 넣어주는 이벤트
	 * 기존에 cellEditEnded 이벤트에 넣어주니 같은값으로 변경될때도 rownum이 들어가는 오류와 
  	 * 수정을 안하고 input박스만 생성되는 경우도 rownum이 찍히는 버그가 발생하여 cellEditEnding 이벤트로 변경함. 
	 */
	flexGrid.cellEditEnding.addHandler(function(s,e){
		var oldVal = s.getCellData(e.row,e.col);
		if(typeof s.activeEditor != "undefined" && s.activeEditor != "" && s.activeEditor != null){				
			var newVal = s.activeEditor.value;
			if(oldVal!=newVal){
				s.setCellData(e.row,"rownum",e.row,true);
			}
		}
		

	});	
		
	/**
	 * 수정할경우 rownum 넣어주는 이벤트
	 * 기존에 cellEditEnded 이벤트에 넣어주니 같은값으로 변경될때도 rownum이 들어가는 오류와 
  	 * 수정을 안하고 input박스만 생성되는 경우도 rownum이 찍히는 버그가 발생하여 cellEditEnding 이벤트로 변경함. 
	 */
/*	flexGrid.cellEditEnding.addHandler(function(s,e){
		
		var oldVal = s.getCellData(e.row,e.col);
		if(typeof s.activeEditor != "undefined" && s.activeEditor != "" && s.activeEditor != null){			
			var newVal = s.activeEditor.value;
	       	
			if(oldVal!=newVal){
				s.setCellData(e.row,"rownum",e.row,true);
			}
		}

	});	*/
/*	
	flexGrid.hostElement.addEventListener('keypress',function(e){
		var edt = flexGrid.activeEditor;
		if(edt){
			var col = flexGrid.columns[flexGrid.selection.col];
			if(col.dataType==wijmo.DataType.Number){
				if(edt.selectionStart == edt.selectionEnd && Math.trunc(edt.value).toString().length >3){
					if(e.keyCode!="46"){
						e.preventDefault();	
						}
				}
			}
		}
	});
*/	
}

function initSetCodeMaster(code){
	if($('#getComps').val() != ""){	
		$.ajax({
			method : "post",
			url : "/ajaxWorkCodeBase/search.do",
			data : {
				'getComps' : $("#getComps").val(),
				'getSe' : code
			},
			success : function(res) {
				if(code == "G") {
					workMastG = JSON.parse(res).list;
					workMastGMap = new wijmo.grid.DataMap(workMastG, 'code', 'code');						
				}else if(code == "A") {
					workMastA = JSON.parse(res).list;
					workMastAMap = new wijmo.grid.DataMap(workMastA, 'code', 'name');										
				}
				gridInit();
			},
			error : function() {
				console.log("dataset.error");
			},
			completed : function() {
				setTimeout(function() {
					mask.close();				
				}, 500);
			}
		});
		
	}	
}

/**
 * 부서코드로 업체명 검색하여 데이터 set
 * 
 * @param 업체코드
 */
function getDeptSch(gubn, value,s,e) {
	if(value != ""){
		clearGrid();
		$.ajax({
			method : "post",
			url : "/ajaxPrdctIndComBase/searchDeptMaster.do",
			data : {
				"getCode" : value,
				"getComps" : $("#getComps").val()
			},
			success : function(res) {
				var data = JSON.parse(res);			
				
				if (data.list.length > 0) {
					if(gubn == "input") $('#getLocNm').val(data.list[0].name);
				}
				else {
					toastMsg(LN_IO_CHK1 + " : " + value);
					if(gubn == "input") {
						$('#getLocCode').val("");
					}
					if(gubn == "grid"){
						var oldValue = s.getCellData(e.row,5,false);
						if(oldValue == "" || oldValue == null || oldValue == undefined) oldValue = "0"; // dataType:'Number' 에는 공백 초기화가 안됨.
						s.setCellData(e.row,e.col,oldValue);
					} 
				}
			},
			error : function() {
				//console.log("dataset.error");
			},
			completed : function() {
				//console.log("dataset.completed");
			}
		});
	}
}

function getToday(){
	var date = new Date();
	return date.getFullYear() + "-" + ("0"+(date.getMonth()+1)).slice(-2) + "-" + ("0"+date.getDate()).slice(-2);
}

function getChangeNumber(data) {
	if(typeof data != "undefined" && data != "" && data != null) {
		return Number(data);
	}else {
		return 0;
	}
}

function ymdFormatter(){
	var num = $("#getOpertDe").val();
     if(!num) return "";
     var formatNum = '';
     // 공백제거
     num=num.replace(/\s/gi, "");
     try{
     	if(num.length == 8) {
        	formatNum = num.replace(/(\d{4})(\d{2})(\d{2})/, '$1-$2-$3');
         }
     } catch(e) {
         $("#getOpertDe").val("");
          console.log(e);
     }
	if(formatNum.length == 10) {
		$("#getOpertDe").val(formatNum);
	}
}
	
	
$(document.body).ready(function() {
    var curr = new Date(), firstDay = new Date(curr.setDate(curr.getDate() - curr.getDay())), lastDay = new Date(curr.setDate(curr.getDate() - curr.getDay() + 6));
	
	wijmo.input.InputDate.controlTemplate = '<div style="position:relative" class="wj-template">' +
    '<div class="wj-input">' +
    '<div class="wj-input-group wj-input-btn-visible">' +
    '<input wj-part="input" type="text" class="wj-form-control getOpertDe" name="getOpertDe" id="getOpertDe" onchange ="ymdFormatter();" style="width : 90px;height: 32px;box-sizing: border-box;"/>' +

    '<span wj-part="btn" class="wj-input-group-btn" tabindex="-1">' +
    '<button class="wj-btn wj-btn-default" type="button" tabindex="-1" style="height: 32px;">' +
    '<span class="wj-glyph-calendar"></span>' +
    '</button>' +
    '</span>' +
    '</div>' +
    '</div>' +
    '<div wj-part="dropdown" class="wj-content wj-dropdown-panel" ' +
    'style="display:none;position:absolute;z-index:100">' +
    '</div>' +
    '</div>';

    new wijmo.input.InputDate('#theInputDate', {
        format: 'yyyy-MM-dd',
		valueChanged:function(){
			clearGrid()
		}
    });	
		
	$.getScript('/js/sal/gridCommon.js').done(function() {
		commonGrid.init(flexGrid,cv); //그리드 공통부분	
		initSetCodeMaster('G');	//조
		initSetCodeMaster('A');	//근무코드
		gridInit();  	//그리드 초기화
		gridEvent();	//그리드 이벤트
		handleEvent();	//프로그램 버튼 이벤트
		
		
	});		
});
