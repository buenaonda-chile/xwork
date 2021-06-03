//code intellisense typescript 정의
///<reference path = "../../wijmo/controls/wijmo.d.ts"/>	
///<reference path = "../../wijmo/controls/wijmo.grid.d.ts"/>
///<reference path = "../../wijmo/controls/wijmo.input.d.ts"/>

var lgsDstRtSum = 0;

var workMast = null;  //빵,쿠폰 마스트

// 컬랙션 뷰는 조회후에 그리드의 상태변경을 체크한다. 
var cv = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수

var flexGrid = new wijmo.grid.FlexGrid('#wijmoGrid');	//그리드 전역변수
var zoomSize = 11;
var baseLgstTime = 0;

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
	if(item.prsnl1==null || wijmo.isEmpty(item.prsnl1) || item.prsnl1 == ""){
	}else {
		if(item.prsnl1.toString().split(".")[0].length > 6 ) {
			toastMsg("정수 값은 6자리를 초과하면 안됩니다.");
			return false;
		}
	}	
	if(item.prsnl2==null || wijmo.isEmpty(item.prsnl2) || item.prsnl2 == ""){
	}else {
		if(item.prsnl2.toString().split(".")[0].length > 6 ) {
			toastMsg("정수 값은 6자리를 초과하면 안됩니다.");
			return false;
		}
	}
	if(item.prsnl3==null || wijmo.isEmpty(item.prsnl3) || item.prsnl3 == ""){
	}else {
		if(item.prsnl3.toString().split(".")[0].length > 6 ) {
			toastMsg("정수 값은 6자리를 초과하면 안됩니다.");
			return false;
		}
	}
	if(item.prsnl4==null || wijmo.isEmpty(item.prsnl4) || item.prsnl4 == ""){
	}else {
		if(item.prsnl4.toString().split(".")[0].length > 6 ) {
			toastMsg("정수 값은 6자리를 초과하면 안됩니다.");
			return false;
		}
	}
	if(item.prsnl5==null || wijmo.isEmpty(item.prsnl5) || item.prsnl5 == ""){
	}else {
		if(item.prsnl5.toString().split(".")[0].length > 6 ) {
			toastMsg("정수 값은 6자리를 초과하면 안됩니다.");
			return false;
		}
	}
	if(item.prsnl6==null || wijmo.isEmpty(item.prsnl6) || item.prsnl6 == ""){
	}else {
		if(item.prsnl6.toString().split(".")[0].length > 6 ) {
			toastMsg("정수 값은 6자리를 초과하면 안됩니다.");
			return false;
		}
	}
	if(item.prsnl7==null || wijmo.isEmpty(item.prsnl7) || item.prsnl7 == ""){
	}else {
		if(item.prsnl7.toString().split(".")[0].length > 6 ) {
			toastMsg("정수 값은 6자리를 초과하면 안됩니다.");
			return false;
		}
	}
	if(item.prsnl8==null || wijmo.isEmpty(item.prsnl8) || item.prsnl8 == ""){
	}else {
		if(item.prsnl8.toString().split(".")[0].length > 6 ) {
			toastMsg("정수 값은 6자리를 초과하면 안됩니다.");
			return false;
		}
	}	
			
					
		

	return true;
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
		window.open("/ajaxPrdctIndComBase/initDeptPop.do","deptPop","width=550,height=620,scrollbars=yes,top=100,left=100");
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
		addRow.locCode = $(".getLocId").val();		
		cv.commitNew();		
		flexGrid.select(new wijmo.grid.CellRange(flexGrid.rows.length+1,0), true);		
		
	});
	
	// 그리드 row 삭제
	$("._delBtn").on("click",function(){
		cv.remove(cv.currentItem);
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
	
	
	var url = "/ajaxLnPrsInpTm/search.do";	
	var params = {
		'getComps' : $("#getComps").val()
		,'getLocId' : $("#getLocId").val()
		,'getOpertDe' : $("#getOpertDe").val()	
	};
	
	mask.open();
	$.ajax({
		method : "post",
		url : url,
		data :params,
		success : function(res) {
			var data = JSON.parse(res).list;
			var resBaseLgstTime = JSON.parse(res).baseLgstTime;	
			var resBaseHrMntSum = JSON.parse(res).baseHrMntSum;	
			var prSnlSum = JSON.parse(res).prSnlSum;				
			var reqWork = JSON.parse(res).reqWork;							
			var ruling = JSON.parse(res).ruling;							
						
			$("#reqWork").val(reqWork);   //특근신청 총작업시간								
			$("#ttlLgst").val(resBaseLgstTime); //특근신청물류시간
			$("#getLgstTm").val(prSnlSum);   //저장된 물류시간	
			$("#ruling").val(ruling);   //판정			
			$("#ttlWork").val(resBaseHrMntSum);   //총작업시간

			cv.sourceCollection = data;
			setRowReadOnly();
			//물류시간 분배시간
			changeRgstTime();
			
//			for(var i=0; i<data.length; i ++ ) {
//				lgsDstRtSum = lgsDstRtSum + Number(data[i].lgsDstRt);
//			}
			
//			flexGrid.columnFooters.setCellData(0, 3, lgsDstRtSum);

		},
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

function clearGrid(){
	cv.sourceCollection=[];
}

//수정
function update(){
	/**
	 * 익스플로러에서 그리드외 다른영역으로 포커스가 빠졌을경우(클릭) 컬랙션뷰에서 변경된 내용을 인식하지 못하는 버그발생
	 * 아래처럼 포커스와 셀을 강제로 영역을 지정함.
	 */
	flexGrid.focus ();
	flexGrid.select( new wijmo.grid.CellRange( 0 , 0 , 0 , 0 ), true );

	//validation	
	for ( var i = 0; i <cv.itemsAdded.length; i ++) {
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
	}
	
	var stateMsg=RESULT_OK;
	var isModify = false;

	// Update : 업데이트 프로세스
    for ( var i = 0; i <cv.itemsEdited.length; i ++) {
		console.log(cv.itemsEdited[i]);
		chkItem = cv.itemsEdited[i];
		$.ajax({
			method : "post",
			url : "/ajaxLnPrsInpTm/update.do",
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
				if(typeof rowNum != "undefined" && rowNum != "" && rowNum != null){			
					addErrorLineColor(flexGrid,rowNum);	
				}
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
			url : "/ajaxLnPrsInpTm/create.do",
			data : cv.itemsAdded[i],
			async: false,
			success : function(xhr) {
            	var data = JSON.parse(xhr);
            	
    			if (data.result != RESULT_OK) {
					var rowNum = cv.itemsAdded[i].rownum;
					addErrorLineColor(flexGrid,rowNum);	    				
    				if(data.errMsg == "LN_INS_CHK1") stateMsg = LN_INS_CHK1;
					if(data.errMsg == "LN_INS_CHK2") stateMsg = LN_INS_CHK2;
				
				}     			
				if(data.result == RESULT_OK){
					//성공시 rownum이 있으면 라인색상 제거
					var rowNum = cv.itemsAdded[i].rownum;
					if(typeof rowNum != "undefined" && rowNum != "" && rowNum != null){		
						removeErrorLineColor(flexGrid,rowNum);
					}
				}					
            },
            error : function() {
				stateMsg = "error";
				var rowNum = cv.itemsAdded[i].rownum;
				addErrorLineColor(flexGrid,rowNum);	
    		},
    		complete : function() {
    			
    		}
		});
		
		isModify = true;
    } 

    // Delete : 삭제 처리 
    for ( var i = 0; i <cv.itemsRemoved.length; i ++) {
    	console.debug(cv.itemsRemoved[i]);
		$.ajax({
			method : "post",
			url : "/ajaxLnPrsInpTm/delete.do",
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

	//물류시간 갱신
	lgstTmUpdate();

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


/**
 * 엑셀 다운로드
 */
function downloadExcel(){

	var fileName = "라인인원투입시간등록_"+getToday()+".xlsx";	
	
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

/**
	그리드 row height 자동크기조절  ==> 공통코드에 이미 정의되어 있음.

function autoSizeRowsAsync(grid, rowIndex) {
    if (rowIndex != null) {
      grid.rows[rowIndex].height = null;
    } else {
      grid.rows.forEach(function(row) {
        row.height = null;
      });
    }
    setTimeout(function() {
      grid.onScrollPositionChanged();
    })
}
 */


//물류시간
function lgstTmUpdate() {
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
		,'getLgstTm' : $("#getLgstTm").val()		
	};
	
	$.ajax({
		method : "post",
		url : "/ajaxStEmpAbsTrd/SaveLgstTm.do",
		data : paramsData,
		async: false,
		success : function(xhr) {
        	var data = JSON.parse(xhr);
			if (data.result != RESULT_OK) {
				if(data.errMsg == "LN_INS_CHK1") stateMsg = LN_INS_CHK1;
				if(data.errMsg == "LN_INS_CHK2") stateMsg = LN_INS_CHK2;
			}
//			if (data.result == RESULT_OK) {
//				changeRgstTime();
//			}			
		
        },
        error : function() {
			toastMsg("error");
		},
		complete : function() {

		}
	});

}

var inputNumber1 = new wijmo.input.InputNumber(document.createElement('div'),{
	format:'n0'
});

var inputNumber2 = new wijmo.input.InputNumber(document.createElement('div'),{
	format:'n0'
});
inputNumber2.inputElement.maxLength = 10;

function gridInit(){
//	var comsBase = new DataMap(coms_base, 'id', 'name');

	var columnsDefinition=[	
		{binding:'clsCode',visible:false},				
		{binding:'locCode',visible:false},
		{binding:'lineCode',visible:false},
		{binding:'opertDe',visible:false},
		{binding:'type',visible:false},		
		{binding:'lineNm',header: '라인명', width: 180, align:'center',dataType:'String', maxLength:50,isReadOnly: true, allowMerging :true},		
		{binding:'dayTit',header: '대상일자', width: 130, align:'center',dataType:'String', maxLength:50,isReadOnly: true},		
		{binding:'lgstTime',header: '물류시간', width: 120, align:'center',dataType:'Number', maxLength:50,isReadOnly: true},				
		{ header: 'No1', align: 'center',  columns: [
			{binding:'prsnl1',header: '인원(명)', width: 85, align:'right', dataType:'Number', editor:inputNumber1,isRequired:false},
			{binding:'hrMnt1',header: '시간(분)', width: 85, align:'right',dataType:'Number', editor:inputNumber2,isRequired:false},
		]},
		{ header: 'No2', align: 'center',  columns: [
			{binding:'prsnl2',header: '인원(명)', width: 85, align:'right',dataType:'Number', editor:inputNumber1,isRequired:false},
			{binding:'hrMnt2',header: '시간(분)', width: 85, align:'right',dataType:'Number', editor:inputNumber2,isRequired:false},
		]},
		{ header: 'No3', align: 'center',  columns: [
			{binding:'prsnl3',header: '인원(명)', width: 85, align:'right',dataType:'Number', editor:inputNumber1,isRequired:false},
			{binding:'hrMnt3',header: '시간(분)', width: 85, align:'right',dataType:'Number', editor:inputNumber2,isRequired:false},
		]},		
		{ header: 'No4', align: 'center',  columns: [
			{binding:'prsnl4',header: '인원(명)', width: 85, align:'right',dataType:'Number', editor:inputNumber1,isRequired:false},
			{binding:'hrMnt4',header: '시간(분)', width: 85, align:'right',dataType:'Number', editor:inputNumber2,isRequired:false},
		]},
		{ header: 'No5', align: 'center',  columns: [
			{binding:'prsnl5',header: '인원(명)', width: 85, align:'right',dataType:'Number', editor:inputNumber1,isRequired:false},
			{binding:'hrMnt5',header: '시간(분)', width: 85, align:'right',dataType:'Number', editor:inputNumber2,isRequired:false},
		]},
		{ header: 'No6', align: 'center',  columns: [
			{binding:'prsnl6',header: '인원(명)', width: 85, align:'right',dataType:'Number', editor:inputNumber1,isRequired:false},
			{binding:'hrMnt6',header: '시간(분)', width: 85, align:'right',dataType:'Number', editor:inputNumber2,isRequired:false},
		]},
		{ header: 'No7', align: 'center',  columns: [
			{binding:'prsnl7',header: '인원(명)', width: 85, align:'right',dataType:'Number', editor:inputNumber1,isRequired:false},
			{binding:'hrMnt7',header: '시간(분)', width: 85, align:'right',dataType:'Number', editor:inputNumber2,isRequired:false},
		]},
		{ header: 'No8', align: 'center',  columns: [
			{binding:'prsnl8',header: '인원(명)', width: 85, align:'right',dataType:'Number', editor:inputNumber1,isRequired:false},
			{binding:'hrMnt8',header: '시간(분)', width: 85, align:'right',dataType:'Number', editor:inputNumber2,isRequired:false},
		]},
		{binding:'hrMntSum',header: '라인소계',width: 120, align:'center',dataType:'Number', isReadOnly: true,isRequired:false },
		{binding:'rownum',visible:false}			
		
	];	
	//컬럼 초기화
	flexGrid.initialize({
		columns: columnsDefinition,
		allowMerging: 'Cells', 
		allowSorting: 0
		/*
		gotFocus: function(s){
		startEditing(s);
		},
		selectionChanged: function(s){
		startEditing(s);
		}
		*/		
		
	});
	
	
//	flexGrid.gotFocus.addHandler(function(s){
//		startEditing(s);
//	});
	
//	flexGrid.selectionChanged.addHandler(function(s){
//		startEditing(s);
//	});
	
//	flexGrid.columnHeaders.rows.defaultSize = 40; 	// 열 헤더 영역에 행의 높이 설정	
//	flexGrid.columnFooters.rows.push(new wijmo.grid.GroupRow());
//   flexGrid.bottomLeftCells.setCellData(0, 0, '\u03A3');

	//필터제거
	flexGridFilter.filterColumns = [];
}

function startEditing(grid) {
    var index = grid.selection.col
	//,col = index > -1 ? grid.columns[index] : null;   => ie 에서 ? 조건문이 혹시나 안먹힐까싶어서 아래 if문으로 변경해놨어요..
	var col = null;
	if(index > -1){
		col = grid.columns[index];
	}else{
		col = null;
	}
	
    if (col && !col.isReadOnly) {
        setTimeout(function() {  //ie에서는 setTimeout 적용하면 안되어서 뺐습니다. ==> ie에서도 settimeout은 기본적으로 작동합니다.
            grid.startEditing(false); 
        }, 1);
    }
}

function gridEvent(){
	//validation
	cv.getError = function(item,prop){
		switch(prop){
			case "clsCode":
				if(item.clsCode==null || wijmo.isEmpty(item.clsCode) || item.clsCode == ""){
					return "[사업부]을 입력해야 됩니다.";
				}
				return null;
			case "prsnl1":
				if(item.prsnl1==null || wijmo.isEmpty(item.prsnl1) || item.prsnl1 == ""){
				}else {
					return item.prsnl1.toString().split(".")[0].length > 6 ? "정수 값은 6자리를 초과하면 안됩니다" : "";					
				}
				return null;
			case "prsnl2":
				if(item.prsnl2==null || wijmo.isEmpty(item.prsnl2) || item.prsnl2 == ""){
				}else {
					return item.prsnl2.toString().split(".")[0].length > 6 ? "정수 값은 6자리를 초과하면 안됩니다" : "";					
				}
				return null;
			case "prsnl3":
				if(item.prsnl3==null || wijmo.isEmpty(item.prsnl3) || item.prsnl3 == ""){
				}else {
					return item.prsnl3.toString().split(".")[0].length > 6 ? "정수 값은 6자리를 초과하면 안됩니다" : "";					
				}
				return null;
			case "prsnl4":
				if(item.prsnl4==null || wijmo.isEmpty(item.prsnl4) || item.prsnl4 == ""){
				}else {
					return item.prsnl4.toString().split(".")[0].length > 6 ? "정수 값은 6자리를 초과하면 안됩니다" : "";					
				}
				return null;
			case "prsnl5":
				if(item.prsnl5==null || wijmo.isEmpty(item.prsnl5) || item.prsnl5 == ""){
				}else {
					return item.prsnl5.toString().split(".")[0].length > 6 ? "정수 값은 6자리를 초과하면 안됩니다" : "";					
				}
				return null;
			case "prsnl6":
				if(item.prsnl6==null || wijmo.isEmpty(item.prsnl6) || item.prsnl6 == ""){
				}else {
					return item.prsnl6.toString().split(".")[0].length > 6 ? "정수 값은 6자리를 초과하면 안됩니다" : "";					
				}
				return null;
			case "prsnl7":
				if(item.prsnl7==null || wijmo.isEmpty(item.prsnl7) || item.prsnl7 == ""){
				}else {
					return item.prsnl7.toString().split(".")[0].length > 6 ? "정수 값은 6자리를 초과하면 안됩니다" : "";					
				}
				return null;
			case "prsnl8":
				if(item.prsnl8==null || wijmo.isEmpty(item.prsnl8) || item.prsnl8 == ""){
				}else {
					return item.prsnl8.toString().split(".")[0].length > 6 ? "정수 값은 6자리를 초과하면 안됩니다" : "";					
				}
				return null;
				
		}
		return null;
	}
	
	flexGrid.pastedCell.addHandler(function(s,e){
		s.setCellData(e.row,"rownum",e.row,true);
	});
	
	flexGrid.cellEditEnding.addHandler(function(s,e){
		var oldVal = s.getCellData(e.row,e.col);
		if(typeof s.activeEditor != "undefined" && s.activeEditor != "" && s.activeEditor != null){		
			var newVal = s.activeEditor.value;
			if(oldVal!=newVal){
				s.setCellData(e.row,"rownum",e.row,true);
			}
		}
	});
		
	
	flexGrid.cellEditEnded.addHandler(function(s,e){
		var value = s.getCellData(e.row,e.col,false);
		if(s.columns[e.col].dataType==wijmo.DataType.String){
			value = value.trim();
		}

		var row = e.row +1;
		//짝수열만 계산
		if(row%2 == 0) {
			if(e.col == 8 || e.col == 9 || e.col == 10 || e.col == 11 || e.col == 12 || e.col == 13 || e.col == 14 || e.col == 15 || e.col == 16 || e.col == 17 || e.col == 18 || e.col == 19|| e.col == 20|| e.col == 21 || e.col == 22 || e.col == 23 ) {
				calFunction(s, e);
//				if(value==null || wijmo.isEmpty(value) || value == "" ){		
//				}else{
//					calFunction(s, e);
//				}
			}		
		}
		/*	
		if(s.columns[e.col].dataType==wijmo.DataType.Number){
			if(s.getCellData(e.row,e.col,true)==null){
				e.cell.innerHTML = "";
			}		
		}
		*/
		
		
	});	
}

//        	int lineHrMbtSumPct = 0;
//        	int lineLgstTime = 0;
//        	if(lineHrMbtSum > 0) {
//        		//라인별 시간 퍼센트 구함
//        		lineHrMbtSumPct = (lineHrMbtSum / prSnlSum) * 100;
//           	 	//총 근태정보 물류시간 취득
//            	lineLgstTime = (lgstTime / 100) * lineHrMbtSum;
//        	}

function calFunction(s, e){	
	var baseLgstTimeSum = 0;
	var lgst = 0;
	lgst = $("#getLgstTm").val(); 
	if(typeof lgst != "undefined" && lgst != "" && lgst != null){
		if(lgst > 0) {
			baseLgstTimeSum = lgst; 
		}
	}else {
		lgst =  $("#ttlLgst").val();
		if(typeof lgst != "undefined" && lgst != "" && lgst != null){		
			baseLgstTimeSum =lgst;  //가져온 총 물류
		}else{
			baseLgstTimeSum = 0;
		}
	}
	
	var rowHrMntSum = 0; //총 시간입력값

	var prsnl1 = s.getCellData(e.row,8,false);
	var prsnl2 = s.getCellData(e.row,10,false);
	var prsnl3 = s.getCellData(e.row,12,false);
	var prsnl4 = s.getCellData(e.row,14,false);
	var prsnl5 = s.getCellData(e.row,16,false);
	var prsnl6 = s.getCellData(e.row,18,false);
	var prsnl7 = s.getCellData(e.row,20,false);
	var prsnl8 = s.getCellData(e.row,22,false);				

	var hrMnt1 = s.getCellData(e.row,9,false);
	var hrMnt2 = s.getCellData(e.row,11,false);
	var hrMnt3 = s.getCellData(e.row,13,false);
	var hrMnt4 = s.getCellData(e.row,15,false);
	var hrMnt5 = s.getCellData(e.row,17,false);
	var hrMnt6 = s.getCellData(e.row,19,false);
	var hrMnt7 = s.getCellData(e.row,21,false);
	var hrMnt8 = s.getCellData(e.row,23,false);

	var hrMnt1Tm = Number(prsnl1) * Number(hrMnt1);
	var hrMnt2Tm = Number(prsnl2) * Number(hrMnt2);	
	var hrMnt3Tm = Number(prsnl3) * Number(hrMnt3);	
	var hrMnt4Tm = Number(prsnl4) * Number(hrMnt4);	
	var hrMnt5Tm = Number(prsnl5) * Number(hrMnt5);	
	var hrMnt6Tm = Number(prsnl6) * Number(hrMnt6);
	var hrMnt7Tm = Number(prsnl7) * Number(hrMnt7);
	var hrMnt8Tm = Number(prsnl8) * Number(hrMnt8);		
	
	var lineHrMbtSum = Number(hrMnt1Tm) + Number(hrMnt2Tm) + Number(hrMnt3Tm) + Number(hrMnt4Tm) + Number(hrMnt5Tm) + Number(hrMnt6Tm) + Number(hrMnt7Tm) + Number(hrMnt8Tm);

	s.setCellData(e.row,24,lineHrMbtSum); //라인소계	
	
	var rowCnt = flexGrid.rows.length;
	for(var i = 1; i < rowCnt+1; i++) {
		if(i%2 == 0) {
			var value = s.getCellData(i-1,24,false);
			rowHrMntSum = rowHrMntSum +Number(value);
		}
	}	
	for(var i = 1; i < rowCnt+1; i++) {
			var prsnl1 = 0;
			var prsnl2 = 0;
			var prsnl3 = 0;
			var prsnl4 = 0;
			var prsnl5 = 0;
			var prsnl6 = 0;
			var prsnl7 = 0;
			var prsnl8 = 0;	
					
			var hrMnt1 = 0;
			var hrMnt2 = 0;
			var hrMnt3 = 0;
			var hrMnt4 = 0;
			var hrMnt5 = 0;
			var hrMnt6 = 0;
			var hrMnt7 = 0;
			var hrMnt8 = 0;	
			var lineHrMbtSum = 0;
		//짝수열 라인
		if(i%2 == 0) {
			prsnl1 = s.getCellData(i-1,8,false); //1부터 시작되어 -1을 해준다.
			prsnl2 = s.getCellData(i-1,10,false);
			prsnl3 = s.getCellData(i-1,12,false);
			prsnl4 = s.getCellData(i-1,14,false);
			prsnl5 = s.getCellData(i-1,16,false);
			prsnl6 = s.getCellData(i-1,18,false);
			prsnl7 = s.getCellData(i-1,20,false);
			prsnl8 = s.getCellData(i-1,22,false);
						
			hrMnt1 = s.getCellData(i-1,9,false); //1부터 시작되어 -1을 해준다.
			hrMnt2 = s.getCellData(i-1,11,false);
			hrMnt3 = s.getCellData(i-1,13,false);
			hrMnt4 = s.getCellData(i-1,15,false);
			hrMnt5 = s.getCellData(i-1,17,false);
			hrMnt6 = s.getCellData(i-1,19,false);
			hrMnt7 = s.getCellData(i-1,21,false);
			hrMnt8 = s.getCellData(i-1,23,false);						
		
			var hrMnt1Tm = Number(prsnl1) * Number(hrMnt1);
			var hrMnt2Tm = Number(prsnl2) * Number(hrMnt2);	
			var hrMnt3Tm = Number(prsnl3) * Number(hrMnt3);	
			var hrMnt4Tm = Number(prsnl4) * Number(hrMnt4);	
			var hrMnt5Tm = Number(prsnl5) * Number(hrMnt5);	
			var hrMnt6Tm = Number(prsnl6) * Number(hrMnt6);
			var hrMnt7Tm = Number(prsnl7) * Number(hrMnt7);
			var hrMnt8Tm = Number(prsnl8) * Number(hrMnt8);				
		
			lineHrMbtSum = Number(hrMnt1Tm) + Number(hrMnt2Tm) + Number(hrMnt3Tm) + Number(hrMnt4Tm) + Number(hrMnt5Tm) + Number(hrMnt6Tm) + Number(hrMnt7Tm) + Number(hrMnt8Tm);
			s.setCellData(i-1,24,lineHrMbtSum); //라인소계
			
	   		//라인별 시간 퍼센트 구함
			var linePercent = (lineHrMbtSum * 100) / rowHrMntSum;
	   	 	//총 근태정보 물류시간 취득
	       	lineLgstTime = (baseLgstTimeSum * linePercent) / 100;   //(Base물류시간 / 100)*라인퍼센트
	
			s.setCellData(i-1,7,lineLgstTime); //물류시간
		}
	}	
	//물류제외 총작업시간
	var numRowHrMntSum = Math.round(rowHrMntSum);
	$("#ttlWork").val(numRowHrMntSum);
}

function changeRgstTime(){	
	var baseLgstTimeSum = 0;
	var lgst = 0;
	lgst = $("#getLgstTm").val(); 
	if(typeof lgst != "undefined" && lgst != "" && lgst != null){
		if(lgst > 0) {
			baseLgstTimeSum = lgst; 
		}else {
			lgst =  $("#ttlLgst").val();
			if(typeof lgst != "undefined" && lgst != "" && lgst != null){	
				if(lgst > 0) {		
					baseLgstTimeSum =lgst;  //가져온 총 물류
				}
			}else{
				baseLgstTimeSum = 0;
			}			
		}
	}else {
		lgst = $("#ttlLgst").val();
		if(typeof lgst != "undefined" && lgst != "" && lgst != null){		
			if(lgst > 0) {		
				baseLgstTimeSum =lgst;  //가져온 총 물류
			}			
		}else{
			baseLgstTimeSum = 0;
		}
	}
	
	var rowCnt = flexGrid.rows.length;
	var rowHrMntSum = $("#ttlWork").val(); //물류제외 총작업시간

	for(var i = 1; i < rowCnt+1; i++) {
			var prsnl1 = 0;
			var prsnl2 = 0;
			var prsnl3 = 0;
			var prsnl4 = 0;
			var prsnl5 = 0;
			var prsnl6 = 0;
			var prsnl7 = 0;
			var prsnl8 = 0;	
					
			var hrMnt1 = 0;
			var hrMnt2 = 0;
			var hrMnt3 = 0;
			var hrMnt4 = 0;
			var hrMnt5 = 0;
			var hrMnt6 = 0;
			var hrMnt7 = 0;
			var hrMnt8 = 0;	
			var lineHrMbtSum = 0;
		if(i%2 == 0) {
			prsnl1 = flexGrid.getCellData(i-1,8,false);
			prsnl2 = flexGrid.getCellData(i-1,10,false);
			prsnl3 = flexGrid.getCellData(i-1,12,false);
			prsnl4 = flexGrid.getCellData(i-1,14,false);
			prsnl5 = flexGrid.getCellData(i-1,16,false);
			prsnl6 = flexGrid.getCellData(i-1,18,false);
			prsnl7 = flexGrid.getCellData(i-1,20,false);
			prsnl8 = flexGrid.getCellData(i-1,22,false);
			
			hrMnt1 = flexGrid.getCellData(i-1,9,false);
			hrMnt2 = flexGrid.getCellData(i-1,11,false);
			hrMnt3 = flexGrid.getCellData(i-1,13,false);
			hrMnt4 = flexGrid.getCellData(i-1,15,false);
			hrMnt5 = flexGrid.getCellData(i-1,17,false);
			hrMnt6 = flexGrid.getCellData(i-1,19,false);
			hrMnt7 = flexGrid.getCellData(i-1,21,false);
			hrMnt8 = flexGrid.getCellData(i-1,23,false);	
			
			var hrMnt1Tm = Number(prsnl1) * Number(hrMnt1);
			var hrMnt2Tm = Number(prsnl2) * Number(hrMnt2);	
			var hrMnt3Tm = Number(prsnl3) * Number(hrMnt3);	
			var hrMnt4Tm = Number(prsnl4) * Number(hrMnt4);	
			var hrMnt5Tm = Number(prsnl5) * Number(hrMnt5);	
			var hrMnt6Tm = Number(prsnl6) * Number(hrMnt6);
			var hrMnt7Tm = Number(prsnl7) * Number(hrMnt7);
			var hrMnt8Tm = Number(prsnl8) * Number(hrMnt8);	
								
			lineHrMbtSum = Number(hrMnt1Tm) + Number(hrMnt2Tm) + Number(hrMnt3Tm) + Number(hrMnt4Tm) + Number(hrMnt5Tm) + Number(hrMnt6Tm) + Number(hrMnt7Tm) + Number(hrMnt8Tm);
			flexGrid.setCellData(i-1,24,lineHrMbtSum); //라인소계
				
	   		//라인별 시간 퍼센트 구함
			var linePercent = (lineHrMbtSum * 100) / rowHrMntSum;
			if (!isNaN(linePercent)) {
		   	 	//총 근태정보 물류시간 취득
		       	var lineLgstTime = (baseLgstTimeSum * linePercent) / 100;   //(Base물류시간 / 100)*라인퍼센트
			
				flexGrid.setCellData(i-1,7,lineLgstTime); //물류시간
			}
		}
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

function setRowReadOnly(){
	
	var rows = flexGrid.rows;
	var cnt = 0;
	for (var i =0; i < rows.length; i ++) {
		cnt = i +1;
		if(cnt%2 == 0) {
		}else{
			rows[i].isReadOnly = true;
			rows[i].cssClassAll = "readOnlyColor";
		}
	}
}

function getToday(){
	var date = new Date();
	return date.getFullYear() + "-" + ("0"+(date.getMonth()+1)).slice(-2) + "-" + ("0"+date.getDate()).slice(-2);
}


/** 
 * 확대
 * grid : 그리드 div
 * flexGrid : 그리드 객체변수
 */
var zoomInSf = function($grid, flexGrid) {

	if (zoomSize > 17) return;
	zoomSize++;

	var headerSize = zoomSize - 11;
	if (headerSize < 0) headerSize = headerSize * -1;

	$grid.css("font-size", zoomSize + "pt");
	flexGrid.collectionView.refresh();
	flexGrid.columnHeaders.rows.defaultSize = flexGrid.columnHeaders.rows.defaultSize + (headerSize / 2); 	// 열 헤더 영역에 행의 높이 설정
	
	setRowReadOnly();

}

/**
 * 축소
 */
var zoomOutSf = function($grid, flexGrid) {
	if (zoomSize < 6) return;
	zoomSize--;

	var headerSize = zoomSize - 11;
	if (headerSize < 0) headerSize = headerSize * -1;

	$grid.css("font-size", zoomSize + "pt");
	flexGrid.collectionView.refresh();
	flexGrid.columnHeaders.rows.defaultSize = flexGrid.columnHeaders.rows.defaultSize - (headerSize / 2); 	// 열 헤더 영역에 행의 높이 설정
	
	setRowReadOnly();

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
			search();
		}
    });	

	$.getScript('/js/sal/gridCommon.js').done(function() {
		commonGrid.init(flexGrid,cv); //그리드 공통부분	
		gridInit();  	//그리드 초기화
		gridEvent();	//그리드 이벤트
		handleEvent();	//프로그램 버튼 이벤트

		$("#ttlLgst").val("");
	});		
	
});
