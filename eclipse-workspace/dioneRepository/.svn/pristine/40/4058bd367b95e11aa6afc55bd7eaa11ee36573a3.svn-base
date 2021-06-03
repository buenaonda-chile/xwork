
// 컬랙션 뷰는 조회후에 그리드의 상태변경을 체크한다. 
var cv = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수

var flexGrid = new wijmo.grid.FlexGrid('#wijmoGrid');	//그리드 전역변수
var zoomSize = 11;

/**
조회버튼
*/
function search(){
	
	if(!$(".getTplid").val()){
		toastMsg(LN_SELECT_TPLID);
		return false;
	}
		
	var url = '/ajaxFileUploadParameterMst/search.do';
	var params = {
		"getTplid" : $(".getTplid").val()
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
			//console.log("dataset.completed");
			setTimeout(function() {
				mask.close();				
			}, 500);
			
		}
	});
}

/**
 * 등록시 오류검증
 */
function validation(item){
	
	if(item.tplid==null || wijmo.isEmpty(item.tplid) || item.tplid == ""){
		alert("수정이나 추가한 행의 [템플릿ID]컬럼을 입력해야 됩니다.");
		return false;
	}
	
	if(item.colno==null || wijmo.isEmpty(item.colno) || item.colno == ""){
		alert("수정이나 추가한 행의 [열번호]컬럼을 입력해야 됩니다.");
		return false;
	}

	if(item.colmn==null || wijmo.isEmpty(item.colmn) || item.colmn ==""){
		alert("수정이나 추가한 행의 [컬럼]컬럼을 입력 하세요");
		return false;
	}
		
	if(item.comnt==null || wijmo.isEmpty(item.comnt) || item.comnt ==""){
		alert("수정이나 추가한 행의 [설명]컬럼을 입력 하세요");
		return false;
	}
	
	if(item.reqyn==null || wijmo.isEmpty(item.reqyn) || item.reqyn ==""){
		alert("수정이나 추가한 행의 [필수체크]컬럼을 입력 하세요");
		return false;
	}
	
	if(item.stype==null || wijmo.isEmpty(item.stype) || item.stype ==""){
		alert("수정이나 추가한 행의 [타입]컬럼을 입력 하세요");
		return false;
	}
	
	return true;
}

/**
	등록버튼
 */
function update(){

	/**
	 * 익스플로러에서 그리드외 다른영역으로 포커스가 빠졌을경우(클릭) flexGrid.rows 함수가 인식못하는 버그
	 * 아래처럼 포커스와 셀을 강제로 영역을 지정함.
	 */
	flexGrid.focus ();
	flexGrid.select( new wijmo.grid.CellRange( 0 , 0 , 0 , 0 ), true );
	
	if(flexGrid.rows.length < 1 && cv.itemsRemoved.length == 0){
		alert("등록할 내용이 없습니다.");
		return;
	} 
	
	//validation	
	for ( var i = 0; i <cv.itemsAdded.length; i ++) {
		if(!validation(cv.itemsAdded[i])){
			return false;
		}	
	}

	for ( var i = 0; i <cv.itemsEdited.length; i ++) {
		if(!validation(cv.itemsEdited[i])){
			return false;
		}	
	}
	
	
	var stateMsg=RESULT_OK;
	var isModify = false;
	
	// Update : 업데이트 프로세스 
    for ( var i = 0; i <cv.itemsEdited.length; i ++) {
    	
		$.ajax({
			method : "post",
			url : "/ajaxFileUploadParameterMst/update.do",
			data : cv.itemsEdited[i],
			async: false,
			success : function(xhr) {
    	    	var data = JSON.parse(xhr);
            	
    	    	if(data.result != RESULT_OK) {

    				if(data.errMsg == "LN_UPD_CHK1") stateMsg = LN_UPD_CHK1;
    				if(data.errMsg == "LN_UPD_CHK2") stateMsg = LN_UPD_CHK2;
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
    
    // Create : 생성 처리    
    for ( var i = 0; i <cv.itemsAdded.length; i ++) {
    	
		$.ajax({
			method : "post",
			url : "/ajaxFileUploadParameterMst/create.do",
			data : cv.itemsAdded[i],
			async: false,
			success : function(xhr) {
            	var data = JSON.parse(xhr);
            	
    			if (data.result != RESULT_OK) {

					if(data.errMsg == "LN_INS_CHK1") stateMsg = LN_INS_CHK1;
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
    	
		$.ajax({
			method : "post",
			url : "/ajaxFileUploadParameterMst/delete.do",
			data : cv.itemsRemoved[i],
            async: false,
            success : function(xhr) {
            	
            	var data = JSON.parse(xhr);
            	
            	if (data.result != RESULT_OK) {
            		
    				if(data.errMsg == "LN_DEL_CHK1") stateMsg = LN_DEL_CHK1;
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
	
	var fileName = '파일업로드파라메터관리.xlsx';
	transExcel(flexGrid,fileName);
	
}



/**
	버튼 이벤트 처리
 */
function handleEvent(){

	//등록폼 닫기버튼
	$("._closeBtn_").on("click",function(){
		var target = this.getAttribute("data-click-target");
		addBtnUiSet(this);
	});
	
	//행 추가버튼
	$("._addBtn_").on("click",function(){
		
		if(!$(".getTplid").val()){
			toastMsg(LN_SELECT_TPLID);
			return false;
		}
		
		var addRow = cv.addNew();
		addRow.tplid = $(".getTplid").val();
		addRow.stype = "문자";
		addRow.reqyn = "Y";
		cv.commitNew(); 

	});
	
	// 그리드 row 삭제
	$("._delBtn").on("click",function(){
		cv.remove(cv.currentItem);
	});
	
}

/**
  그리드 초기화
 */
function gridInit() {

	
	var type = [
		 {code:"문자",name:"문자"}
		,{code:"숫자",name:"숫자"}
	];
	var typeMap = new wijmo.grid.DataMap(type, 'code', 'name');
	
	var yn = [
		 {code:"Y",name:"Y"}
		,{code:"N",name:"N"}
	];
	var ynMap = new wijmo.grid.DataMap(yn, 'code', 'name');
	
	/**
	 *	grid 셋팅
	 *	gridCommon.js 에서 공통으로 처리되있는 옵션을 변경하고 싶다면 gridInit 함수에서 바꾸고싶은 옵션만 재정의 하면됨.
	 */
	//컬럼정의
	columnsDefinition = [
	    {binding:'oldTplid',visible:false},
	    {binding:'oldColno',visible:false},
	    {binding:'oldColmn',visible:false},
	    {binding: 'tplid', header: LN_CHK_TPLID, width: '*', wordWrap: true, align:'center',dataType:'String',maxLength:4,isReadOnly: true},  //wordWrap: true: 텍스트 자동줄바꿈 autorowHeights랑 같이 사용
	    {binding: 'colno', header: '* '+ LN_CHK_COLNO, width: '*', align:'center',dataType:'String', maxLength:2},
	    {binding: 'colmn', header: '* '+ LN_CHK_COLMN, width: '*', align:'center',dataType:'String', maxLength:5},
	    {binding: 'comnt', header: '* '+ LN_CHK_COMNT, width: '*', align:'center',dataType:'String', maxLength:100},
	    {binding: 'reqyn', header: '* '+ LN_CHK_REQYN, width: '*', align:'center',dataType:'String', maxLength:1, dataMap: ynMap},
	    {binding: 'stype', header: '* '+ LN_CHK_STYPE, width: '*', align:'center',dataType:'String', maxLength:6, dataMap: typeMap},
	    {binding: 'lengh', header: LN_CHK_LENGH, width: '*', align:'center',dataType:'Number', format:'n0', maxLength:3}
		// 콤보박스 추가하려면 dataMap
	];
	
	//컬럼 초기화
	flexGrid.initialize({
		columns: columnsDefinition
	});
	
}

function gridEvent(){
	
	//validation
	cv.getError = function(item,prop){
		switch(prop){
			case "tplid":
				
				if(item.tplid==null || wijmo.isEmpty(item.tplid) || item.tplid == ""){
					return "[템플릿ID]를 입력 하세요.";
				}
				return null;
				
			case "colno":
				
				if(item.colno==null || wijmo.isEmpty(item.colno) || item.colno == "" ){
					return "[열번호]를 입력 하세요.";
				}
				return null;
				
			case "colmn":
			
				if(item.colmn==null || wijmo.isEmpty(item.colmn) || item.colmn == "" ){
					return "[컬럼]을 입력 하세요.";
				}
				return null;
				
			case "comnt":
				
				if(item.comnt==null || wijmo.isEmpty(item.comnt) || item.comnt == "" ){
					return "[설명]을 입력 하세요.";
				}
				return null;
				
			case "reqyn":
				
				if(item.reqyn==null || wijmo.isEmpty(item.reqyn) || item.reqyn == "" ){
					return "[필수체크]을 입력 하세요.";
				}
				return null;
				
			case "stype":
				
				if(item.stype==null || wijmo.isEmpty(item.stype) || item.stype == "" ){
					return "[타입]을 입력 하세요.";
				}
				return null;
		}
		return null;
	}

	//대문자 변경
	flexGrid.cellEditEnded.addHandler(function(s,e){
		
		var value = s.getCellData(e.row,e.col,false);
		
		var editKey = s.columns[e.col].binding;
		
		if(s.columns[e.col].dataType==wijmo.DataType.String){
			
			// 열번호 숫자만 입력 : dataType:'Number' 일때 0값(엑셀 0부터 시작) 입력이 안되서 처리
			if (editKey == "colno") {
				s.setCellData(e.row,e.col,value.replace(/[^0-9]/g,''));
			}
			
			// 영문만 입력
			else if (editKey == "colmn") {
				s.setCellData(e.row,e.col,value.replace(/[^\\!-z]/gi,'').toUpperCase());
			}
			
			else s.setCellData(e.row,e.col,value.toUpperCase());
		}

	});
	
	
	// cell read-only
	// 컬럼정의 에서 isReadOnly: true 또는 addHandler
	/*
	flexGrid.beginningEdit.addHandler(function(s,e){
		var editKey = s.columns[e.col].binding;
		
		if(editKey == "tplid"){
			e.cancel=true;
		}
	});
	*/
}


$(document.body).ready(function() {
	
	//그리드 공통js 호출 후에 나머지 함수 호출함.
	$.getScript('/js/sal/gridCommon.js').done(function() {
		
		commonGrid.init(flexGrid,cv); //그리드 공통부분
		
		gridInit();  	//그리드 초기화
		gridEvent();	//그리드 이벤트
		handleEvent();	//프로그램 버튼 이벤트		
				
	});
	
});
