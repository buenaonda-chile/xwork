// 컬랙션 뷰는 조회후에 그리드의 상태변경을 체크한다. 
var cv = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수

var flexGrid = new wijmo.grid.FlexGrid('#wijmoGrid');	//그리드 전역변수
var zoomSize = 11;

var itemMast = null;
var prdtCodeMast = null;

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

function initSetMaster(){
	getDeptMaster();
	search();
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
		
	return true;
}


function handleEvent(){

	//등록폼 닫기버튼
	$("._closeBtn_").on("click",function(){
		var target = this.getAttribute("data-click-target");
		addBtnUiSet(this);
	});

	$('._custBtn_').on('click', function() {
		window.open("/ajaxCustomer/init.do","customerPop","width=550,height=600,scrollbars=yes,top=100,left=100");
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
    				
    	    		if(data.errMsg == "LN_UPD_CHK1") stateMsg = LN_UPD_CHK1;
    				if(data.errMsg == "LN_UPD_CHK2") stateMsg = LN_UPD_CHK2;
    				if(data.errMsg == "LN_UPD_CHK3") stateMsg = LN_UPD_CHK3;
    				if(data.errMsg == "LN_UPD_CHK4") stateMsg = LN_UPD_CHK4;			
    			} 
    	    },
            error : function() {
    			stateMsg = "error";
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


function gridInit(){

	var yyyy = new Date().getFullYear();
	var columnsDefinition=[
        {binding:'clsCode', header:'사업부코드', visible: false},
        {binding:'locCode', header:'부서코드', visible: false},
        {binding:'year', header:'년도', visible: false},
        { header: '라인', align: 'center',  columns: [
 			{binding:'lineCode',header: '코드', width: '*', align:'center', dataType:'String', isReadOnly: true},
 			{binding:'lineNm',header: '코드명', width: '*', align:'center', dataType:'String', isReadOnly: true},
 		 ]
        },
        {binding:'code',header: '작업코드', width: '*', align:'center', dataType:'String', visible : false},
        {binding:'codeNm',header: '항목', width: '*', align:'center', dataType:'String', isReadOnly: true},
 		{binding:'iem',header: '항목 (= 항목)', visible:false },
 		{ header: yyyy+'년', align: 'center',  columns: [
			{binding:'apr',header: '4월', width: '*', align:'center', dataType:'Number', maxLength:4},
			{binding:'may',header: '5월', width: '*', align:'center', dataType:'Number', maxLength:4},
			{binding:'jun',header: '6월', width: '*', align:'center', dataType:'Number', maxLength:4},
			{binding:'july',header: '7월', width: '*', align:'center', dataType:'Number', maxLength:4},
			{binding:'aug',header: '8월', width: '*', align:'center', dataType:'Number', maxLength:4},
			{binding:'sep',header: '9월', width: '*', align:'center', dataType:'Number', maxLength:4},
			{binding:'oct',header: '10월', width: '*', align:'center', dataType:'Number', maxLength:4},
			{binding:'nov',header: '11월', width: '*', align:'center', dataType:'Number', maxLength:4},
			{binding:'dec',header: '12월', width: '*', align:'center', dataType:'Number', maxLength:4},
			{binding:'jan',header: '1월', width: '*', align:'center', dataType:'Number', maxLength:4},
			{binding:'feb',header: '2월', width: '*', align:'center', dataType:'Number', maxLength:4},
			{binding:'mar',header: '3월', width: '*', align:'center', dataType:'Number', maxLength:4}
		]},
		{binding:'totSum',header: '누계', width: '*', align:'center', dataType:'Number', maxLength:8, isReadOnly: true}
	];	
	//컬럼 초기화
	flexGrid.initialize({
		columns: columnsDefinition
	});
	
}

function isCodeValid(d){
	var re = /^[A-Za-z0-9+]*$/;
    return re.test(d);
}
//셀 벨리데이션 체크
// 최소 1건 이상의 데이터가 있으
function gridEvent(){
	//validation
	cv.getError = function(item,prop){
		switch(prop){
			
			/*case "lineCode":
				if(item.lineCode==null || wijmo.isEmpty(item.lineCode) || item.lineCode == "" ){
					return "[라인코드]을 입력 하세요.";
				}else{
					var flag = isCodeValid(item.lineCode);
					if(!flag) {
						item.lineCode = "";
					}					
				}
				return null;*/						
		}
		return null;
	}

	//대문자 변경
	flexGrid.cellEditEnded.addHandler(function(s,e){
		var value = s.getCellData(e.row,e.col,false);
		//제품1
		if(e.col == 8 || e.col == 10 || e.col == 12) {
			if(s.columns[e.col].dataType==wijmo.DataType.String){
				value = value.toUpperCase();
				s.setCellData(e.row,e.col,value); //제품코드
			}
			var flag = true;
			if(value==null || wijmo.isEmpty(value) || value == "" ){
				
			}else{
				var flag = true;
				if(flag) {
					s.setCellData(e.row,e.col,""); //제품코드					
					s.setCellData(e.row,e.col+1,""); //제품명
				}
			}
		}
	});
}


$(document.body).ready(function() {
	getYearList();
	$.getScript('/js/sal/gridCommon.js').done(function() {
		commonGrid.init(flexGrid,cv); //그리드 공통부분		
		initSetMaster();
		gridInit();  	//그리드 초기화
		gridEvent();	//그리드 이벤트
		handleEvent();	//프로그램 버튼 이벤트
	});	
});
