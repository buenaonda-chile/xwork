//code intellisense typescript 정의
///<reference path = "../../wijmo/controls/wijmo.d.ts"/>	
///<reference path = "../../wijmo/controls/wijmo.grid.d.ts"/>
///<reference path = "../../wijmo/controls/wijmo.input.d.ts"/>


// 컬랙션 뷰는 조회후에 그리드의 상태변경을 체크한다. 
var cv = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수
var flexGrid = new wijmo.grid.FlexGrid('#wijmoGrid');	//그리드 전역변수
var zoomSize = 11;
var itemMast = null;

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
 * 더존 부서정보 취득
 */

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

function getYearList(){
	var dt = new Date();
	var year = dt.getFullYear();
	var yearList = "";
	for(var i = (year - 20); i<= (year + 2); i++){
		if(i == year){
			yearList += $("#getYear").append("<option value='"+i+"' selected>"+i+"</option>");
		}else{
			yearList += $("#getYear").append("<option value='"+i+"'>"+i+"</option>");
		}
	}
}

function getDeptMaster() {
	if($('#getComps').val() != ""){	
		$.ajax({
			method : "post",
			url : "/ajaxPrdctIndComBase/searchDeptMaster.do",
			data : {
				'getComps' : $("#getComps").val()
			},
			success : function(res) {
				itemMast = JSON.parse(res).list;
			},
			error : function(e) {
				console.log("dataset.error : "+e);
			},
			completed : function() {
				setTimeout(function() {
					mask.close();				
				}, 500);
			},
			done : function(){
				mask.close();
			}
		});
	}
}

function clearGrid(){
	cv.sourceCollection=[];
}

function clearGridPlanYear(){
	cv.sourceCollection=[];
	gridInit();
}


function getToday(){
    var date = new Date();
    var year = date.getFullYear();
    var month = ("0" + (1 + date.getMonth())).slice(-2);
    var day = ("0" + date.getDate()).slice(-2);

    return year + month + day;
}


/**
 * 업체코드로 업체명 검색하여 데이터 set
 * 
 * @param 업체코드
 */
function getCustSch() {
	if($('#getPyvnd').val() != ""){	
		$.ajax({
			method : "post",
			url : "/ajaxCustomer/search.do",
			data : {
				"getCusno" : $("#getPyvnd").val()
			},
			success : function(res) {
				var data = JSON.parse(res).list;
				cv.sourceCollection = data;
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
 * 등록시 오류검증
 */
function validation(item){
	if(item.apr==null || wijmo.isEmpty(item.apr)){
	}else {
		if(item.apr.toString().split(".")[0].length > 6 ) {
			toastMsg("정수 값은 6자리를 초과하면 안됩니다.");
			return false;
		}		
	}
	if(item.jun==null || wijmo.isEmpty(item.jun)){
	}else {
		if(item.jun.toString().split(".")[0].length > 6 ) {
			toastMsg("정수 값은 6자리를 초과하면 안됩니다.");
			return false;
		}		
	}
	if(item.july==null || wijmo.isEmpty(item.july)){
	}else {
		if(item.july.toString().split(".")[0].length > 6 ) {
			toastMsg("정수 값은 6자리를 초과하면 안됩니다.");
			return false;
		}		
	}
	if(item.aug==null || wijmo.isEmpty(item.aug)){
	}else {
		if(item.aug.toString().split(".")[0].length > 6 ) {
			toastMsg("정수 값은 6자리를 초과하면 안됩니다.");
			return false;
		}		
	}
	if(item.sep==null || wijmo.isEmpty(item.sep)){
	}else {
		if(item.sep.toString().split(".")[0].length > 6 ) {
			toastMsg("정수 값은 6자리를 초과하면 안됩니다.");
			return false;
		}		
	}
	if(item.oct==null || wijmo.isEmpty(item.oct)){
	}else {
		if(item.oct.toString().split(".")[0].length > 6 ) {
			toastMsg("정수 값은 6자리를 초과하면 안됩니다.");
			return false;
		}		
	}
	if(item.nov==null || wijmo.isEmpty(item.nov)){
	}else {
		if(item.nov.toString().split(".")[0].length > 6 ) {
			toastMsg("정수 값은 6자리를 초과하면 안됩니다.");
			return false;
		}		
	}
	if(item.dec==null || wijmo.isEmpty(item.dec)){
	}else {
		if(item.dec.toString().split(".")[0].length > 6 ) {
			toastMsg("정수 값은 6자리를 초과하면 안됩니다.");
			return false;
		}		
	}
	if(item.jan==null || wijmo.isEmpty(item.jan)){
	}else {
		if(item.jan.toString().split(".")[0].length > 6 ) {
			toastMsg("정수 값은 6자리를 초과하면 안됩니다.");
			return false;
		}		
	}
	if(item.feb==null || wijmo.isEmpty(item.feb)){
	}else {
		if(item.feb.toString().split(".")[0].length > 6 ) {
			toastMsg("정수 값은 6자리를 초과하면 안됩니다.");
			return false;
		}		
	}
	if(item.mar==null || wijmo.isEmpty(item.mar)){
	}else {
		if(item.mar.toString().split(".")[0].length > 6 ) {
			toastMsg("정수 값은 6자리를 초과하면 안됩니다.");
			return false;
		}		
	}		
	return true;
}


function handleEvent(){

	//등록폼 닫기버튼
	$("._closeBtn_").on("click",function(){
		var target = this.getAttribute("data-click-target");
		addBtnUiSet(this);
	});

	$('._custBtn_').on('click', function() {
		window.open("/ajaxPrdctIndComBase/initDeptPop.do","deptPop","width=550,height=620,scrollbars=yes,top=100,left=100");
	});
	
	// 그리드 row 삭제
	$("._delBtn").on('click', function() {
		for(var i = 8; i<21; i++){
			flexGrid.setCellData(cv._idx, i, 0);
		}
	});
	
}

function search(){
	//validation 체크기능으로 입력칸에 커서가 활성화 되어있을경우 조회시 오류가 발생함.
	//validation edit 기능을 비활성화 시키고 조회시킴.
	flexGrid.validateEdits = false;

	if(!$(".getComps").val()){
		toastMsg(LN_SELECT_COMPS);
		return false;
	}else if(!$("#getLocId").val()){
		toastMsg(LN_SELECT_DEPT);
		return false;
	}

	var url = "/ajaxPrdYrPlnCrtRgs/search.do";	
	var params = {
		'getComps' : $("#getComps").val(),
		'getYear' : $("#getYear").val(),
		'getLocId' : $("#getLocId").val()
	};
	
	mask.open();
	$.ajax({
		method : "post",
		url : url,
		data :params,
		success : function(res) {
			var data = JSON.parse(res).list;
			cv.sourceCollection = data;
		},
		error : function() {
			console.log("dataset.error");
			
		},
		complete : function() {
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
	
		$.ajax({
			method : "post",
			url : "/ajaxPrdYrPlnCrtRgs/update.do",
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
    
    // Delete : 삭제 처리 
    for ( var i = 0; i <cv.itemsRemoved.length; i ++) {
    	console.debug(cv.itemsRemoved[i]);
		$.ajax({
			method : "post",
			url : "/ajaxPrdYrPlnCrtRgs/delete.do",
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

/**
 * 엑셀 다운로드
 */
function downloadExcel(){
	var yyyy = new Date().getFullYear();
	var fileName = yyyy+'년생산지수년계획등록.xlsx';
	transExcel(flexGrid,fileName);
}

var inputNumber = new wijmo.input.InputNumber(document.createElement('div'),{
	format:'n2'
});

function gridInit(){	
	var yyyy = $("#getYear option:selected").val();
	var columnsDefinition=[
        {binding:'clsCode', header:'사업부코드', visible: false},
        {binding:'locCode', header:'부서코드', visible: false},
        {binding:'year', header:'년도', visible: false},
        { header: '라인', align: 'center',  columns: [
 			{binding:'lineCode',header: '코드', width: 80, align:'center', dataType:'String', isReadOnly: true,allowMerging :true},
 			{binding:'lineNm',header: '코드명', width: 120, align:'center', dataType:'String', isReadOnly: true,allowMerging :true},
 		 ]
        },
        {binding:'code',header: '작업코드', width: 100, align:'center', dataType:'String', visible : false},
        {binding:'codeNm',header: '항목', width: 150, align:'left', dataType:'String', isReadOnly: true},
 		{binding:'iem',header: '항목', visible:false },
 		{header: yyyy+'년', align: 'center',  columns: [
			{binding:'apr',header: '4월', width: 120, align:'right', dataType:'Number', format:'n2', editor:inputNumber,isRequired:false},
			{binding:'may',header: '5월', width: 120, align:'right', dataType:'Number', format:'n2',editor:inputNumber,isRequired:false},
			{binding:'jun',header: '6월', width: 120, align:'right', dataType:'Number', format:'n2', editor:inputNumber,isRequired:false},
			{binding:'july',header: '7월', width: 120, align:'right', dataType:'Number', format:'n2', editor:inputNumber,isRequired:false},
			{binding:'aug',header: '8월', width: 120, align:'right', dataType:'Number', format:'n2', editor:inputNumber,isRequired:false},
			{binding:'sep',header: '9월', width: 120, align:'right', dataType:'Number', format:'n2', editor:inputNumber,isRequired:false},
			{binding:'oct',header: '10월', width: 120, align:'right', dataType:'Number', format:'n2', editor:inputNumber,isRequired:false},
			{binding:'nov',header: '11월', width: 120, align:'right', dataType:'Number', format:'n2', editor:inputNumber,isRequired:false},
			{binding:'dec',header: '12월', width: 120, align:'right', dataType:'Number', format:'n2', editor:inputNumber,isRequired:false},
			{binding:'jan',header: '1월', width: 120, align:'right', dataType:'Number', format:'n2', editor:inputNumber,isRequired:false},
			{binding:'feb',header: '2월', width: 120, align:'right', dataType:'Number', format:'n2', editor:inputNumber,isRequired:false},
			{binding:'mar',header: '3월', width: 120, align:'right', dataType:'Number', format:'n2', editor:inputNumber,isRequired:false}
		]},
		{binding:'totSum',header: '누계', width: 120, align:'right', dataType:'Number', format:'n4',  isReadOnly: true},
		{binding:'rownum',visible:false}			
	];
		
	//컬럼 초기화
	flexGrid.initialize({
		columns: columnsDefinition,
		allowMerging: 'Cells' 
	});
	flexGrid.allowSorting = false;
//	flexGrid.columnHeaders.rows.defaultSize = 40; 	// 열 헤더 영역에 행의 높이 설정	
	

/*	flexGrid.gotFocus.addHandler(function(s){
		startEditing(s);
	});
	
	flexGrid.selectionChanged.addHandler(function(s){
		startEditing(s);
	});*/
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
			case "apr":
				if(item.apr==null || wijmo.isEmpty(item.apr) || item.apr == ""){
				}else {
					return item.apr.toString().split(".")[0].length > 6 ? "정수 값은 6자리를 초과하면 안됩니다" : "";									
				}
				return null;
			case "may":
				if(item.may==null || wijmo.isEmpty(item.may) || item.may == ""){
				}else {
					return item.may.toString().split(".")[0].length > 6 ? "정수 값은 6자리를 초과하면 안됩니다" : "";			
				}
				return null;
			case "jun":
				if(item.jun==null || wijmo.isEmpty(item.jun) || item.jun == ""){
				}else {
					return item.jun.toString().split(".")[0].length > 6 ? "정수 값은 6자리를 초과하면 안됩니다" : "";				
				}
				return null;
			case "july":
				if(item.july==null || wijmo.isEmpty(item.july) || item.july == ""){
				}else {
					return item.july.toString().split(".")[0].length > 6 ? "정수 값은 4자리를 초과하면 안됩니다" : "";					
				}
				return null;
			case "aug":
				if(item.aug==null || wijmo.isEmpty(item.aug) || item.aug == ""){
				}else {
					return item.aug.toString().split(".")[0].length > 6 ? "정수 값은 6자리를 초과하면 안됩니다" : "";					
				}
				return null;
			case "sep":
				if(item.sep==null || wijmo.isEmpty(item.sep) || item.sep == ""){
				}else {
					return item.sep.toString().split(".")[0].length > 6 ? "정수 값은 6자리를 초과하면 안됩니다" : "";				
				}
				return null;
			case "oct":
				if(item.oct==null || wijmo.isEmpty(item.oct) || item.oct == ""){
				}else {
					return item.oct.toString().split(".")[0].length > 6 ? "정수 값은 6자리를 초과하면 안됩니다" : "";				
				}
				return null;
			case "nov":
				if(item.nov==null || wijmo.isEmpty(item.nov) || item.nov == ""){
				}else {
					return item.nov.toString().split(".")[0].length > 6 ? "정수 값은 6자리를 초과하면 안됩니다" : "";				
				}
				return null;
			case "dec":
				if(item.dec==null || wijmo.isEmpty(item.dec) || item.dec == ""){
				}else {
					return item.dec.toString().split(".")[0].length > 6 ? "정수 값은 6자리를 초과하면 안됩니다" : "";					
				}
				return null;
			case "jan":
				if(item.jan==null || wijmo.isEmpty(item.jan) || item.jan == ""){
				}else {
					return item.jan.toString().split(".")[0].length > 6 ? "정수 값은 6자리를 초과하면 안됩니다" : "";					
				}
				return null;	
			case "feb":
				if(item.feb==null || wijmo.isEmpty(item.feb) || item.feb == ""){
				}else {
					return item.feb.toString().split(".")[0].length > 6 ? "정수 값은 6자리를 초과하면 안됩니다" : "";					
				}
				return null;	
			case "mar":
				if(item.mar==null || wijmo.isEmpty(item.mar) || item.mar == ""){
				}else {
					return item.mar.toString().split(".")[0].length > 6 ? "정수 값은 6자리를 초과하면 안됩니다" : "";					
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
}

$(document.body).ready(function() {
	getYearList();
	$.getScript('/js/sal/gridCommon.js').done(function() {
		commonGrid.init(flexGrid,cv,false); //그리드 공통부분		
//		getDeptMaster();
		gridInit();  	//그리드 초기화
		gridEvent();	//그리드 이벤트		
		handleEvent();	//프로그램 버튼 이벤트
	});	
});
