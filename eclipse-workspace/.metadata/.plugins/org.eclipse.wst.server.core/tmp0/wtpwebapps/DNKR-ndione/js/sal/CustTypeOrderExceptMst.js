//code intellisense typescript 정의
///<reference path = "../../wijmo/controls/wijmo.d.ts"/>	
///<reference path = "../../wijmo/controls/wijmo.grid.d.ts"/>
///<reference path = "../../wijmo/controls/wijmo.input.d.ts"/>


// 컬랙션 뷰는 조회후에 그리드의 상태변경을 체크한다. 
var cv = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수

/*
	그룹화 시킬때
var cv = new wijmo.collections.CollectionView(null,{
	sortDescriptions: ['mkcar'],
    groupDescriptions: ['mkcar']	
	
});	//컬랙션뷰 전역변수
*/


var flexGrid = new wijmo.grid.FlexGrid('#wijmoGrid');	//그리드 전역변수
var zoomSize = 11;
/**
 조회버튼
 */
function search(){
	
	if(!$(".getComps").val()){
		toastMsg(LN_SELECT_COMPS);
		return false;
	}else if(!$(".getPyvnd").val()){
		toastMsg(LN_SELECT_PYVND);
		return false;
	}
	
	//validation 체크기능으로 입력칸에 커서가 활성화 되어있을경우 조회시 오류가 발생함.
	//validation edit 기능을 비활성화 시키고 조회시킴.
	flexGrid.validateEdits = false;
	
	var url = '/ajaxCustTypeOrderExceptMst/search.do';
	var params = {
		'getComps' : $(".getComps").val(),
		'getPyvnd' : $(".getPyvnd").val()
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
			mask.close();
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
 * 업체코드로 업체명 검색하여 데이터 set
 * 
 * @param 업체코드
 */
function getCustSch(gubn, value,s,e) {
	if(value != ""){
		
		$.ajax({
			method : "post",
			url : "/ajaxCustomer/search.do",
			data : {
				"getCusno" : value,
				"getComps" : $("#getComps").val()
			},
			success : function(res) {
				var data = JSON.parse(res);			
				
				if (data.list.length > 0) {
					if(gubn == "input") $('#getCusnm').val(data.list[0].cusnm);
				}
				else {
					toastMsg(LN_IO_CHK1 + " : " + value);
					if(gubn == "input") {
						$('#getPyvnd').val("");
						//$('#getCusnm').val("");					
					}
					//if(gubn == "grid") grid.target.setValue(currGridIndex, "pyvnd", "");
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

/**
 * 팝업창에서 값넘겨받아 부모창에 데이터 set
 * 
 * @param returnValue
 */
function getReturnValue(returnValue) {
	if(returnValue !== null) {
		var custObj = JSON.parse(returnValue);

		$('#getPyvnd').val(custObj.cusno);
		$('#getCusnm').val(custObj.cusnm);
	}
}

/**
 * 등록시 오류검증
 */
function validation(item){
	
	if(item.mkcar==null || wijmo.isEmpty(item.mkcar) || item.mkcar == ""){
		alert("수정이나 추가한 행의 [차종]컬럼을 입력 하세요");
		return false;
	}
	/*
	if(item.seyno==null || wijmo.isEmpty(item.seyno) || item.seyno ==""){
		alert("수정이나 추가한 행의 [서열]컬럼을 입력 하세요");
		return false;
	}
	
	if(parseInt(item.seyno) < 0){
		alert("수정이나 추가한 행의 [서열]컬럼에 음수를 입력할 수 없습니다.");
		return false;
	}
	
	if(item.seycd==null || wijmo.isEmpty(item.seycd) || item.seycd ==""){
		alert("수정이나 추가한 행의 [번호]컬럼을 입력 하세요");
		return false;
	}
	*/
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
	
		
	if(flexGrid.rows.length<1){
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
		console.debug(cv.itemsEdited[i]);
    	
		$.ajax({
			method : "post",
			url : "/ajaxCustTypeOrderExceptMst/update.do",
			data : cv.itemsEdited[i],
			async: false,
			success : function(xhr) {
    	    	var data = JSON.parse(xhr);
            	
    	    	if(data.result != RESULT_OK) {
    				
    	    		if(data.errMsg == "LN_UPD_CHK1") stateMsg = LN_UPD_CHK1;
    				if(data.errMsg == "LN_UPD_CHK2") stateMsg = LN_UPD_CHK2;				
    				if(data.errMsg == "LN_UPD_CHK3") stateMsg = LN_UPD_CHK3;
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
    	console.debug(cv.itemsAdded[i]);
		
		$.ajax({
			method : "post",
			url : "/ajaxCustTypeOrderExceptMst/create.do",
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
    } 

    // Delete : 삭제 처리 
    for ( var i = 0; i <cv.itemsRemoved.length; i ++) {
    	console.debug(cv.itemsRemoved[i]);
		$.ajax({
			method : "post",
			url : "/ajaxCustTypeOrderExceptMst/delete.do",
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
	
	var fileName = '업체차종서열제외마스타.xlsx';
	transExcel(flexGrid,fileName);
	
}



/**
	버튼 이벤트 처리
 */
function handleEvent(){
	
		
	$('.getPyvnd').on('change', function() {
		$(".getCusnm").val("");
	});

	
	//등록폼 닫기버튼
	$("._closeBtn_").on("click",function(){
		var target = this.getAttribute("data-click-target");
		addBtnUiSet(this);
	});

	$('._custBtn_').on('click', function() {
		window.open("/ajaxCustomer/init.do","customerPop","width=550,height=600,scrollbars=yes,top=100,left=100");
	});
	
	//행 추가버튼
	$("._addBtn_").on("click",function(){
		
		if(!$(".getComps").val()){
			toastMsg(LN_SELECT_COMPS);
			return false;
		}else if(!$(".getPyvnd").val()){
			toastMsg(LN_SELECT_PYVND);
			return false;
		}
		
		var addRow = cv.addNew();
		addRow.comps = $(".getComps").val();
		addRow.pyvnd = $(".getPyvnd").val();
		cv.commitNew();
		
		//추가된 행으로 포커스및 화면이동
		flexGrid.select(new wijmo.grid.CellRange(flexGrid.rows.length+1,0),true);
		
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

	
	/**
	 * grid 셋팅
	 * gridCommon.js 에서 공통으로 처리되있는 옵션을 변경하고 싶다면 gridInit 함수에서 바꾸고싶은 옵션만 재정의 하면됨.
	 */
	//컬럼정의
	columnsDefinition = [
		{binding:'pyvnd',visible:false},
	    {binding:'comps',visible:false},
	    {binding:'oldMkcar',visible:false},
	    {binding:'oldSeyno',visible:false},
	    {binding:'oldSeycd',visible:false},
        {binding: 'mkcar', header: '* '+ LN_CHK_MKCAR, width: '*', wordWrap: true, align:'center',dataType:'String',maxLength:2  },  //wordWrap: true: 텍스트 자동줄바꿈 autorowHeights랑 같이 사용
        {binding: 'seyno', header: LN_CHK_SEYNO, width: '*', align:'center',dataType:'String', maxLength:3},
        {binding: 'seycd', header: LN_CHK_SEYCD, width: '*', align:'center',dataType:'String', maxLength:4}
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
			case "mkcar":
				
				if(item.mkcar==null || wijmo.isEmpty(item.mkcar) || item.mkcar == ""){
					return "[차종]을 입력 하세요.";
				}
				return null;
			/*	
			case "seyno":
				
				if(item.seyno==null || wijmo.isEmpty(item.seyno) || item.seyno == "" ){
					return "[서열]을 입력 하세요.";
				}
													
				if(parseInt(item.seyno)< 0){
					return "[서열]에는 음수는 입력할 수 없습니다."	;
				}
				return null;
				
			case "seycd":
			
				if(item.seycd==null || wijmo.isEmpty(item.seycd) || item.seycd == "" ){
					return "[번호]를 입력 하세요.";
				}
				return null;
			*/
		}
		return null;
	}

	//대문자 변경
	flexGrid.cellEditEnded.addHandler(function(s,e){
		var value = s.getCellData(e.row,e.col,false);
		
		var editKey = s.columns[e.col].binding;
		
		if(s.columns[e.col].dataType==wijmo.DataType.String){
			// 서열 숫자만 입력 : dataType:'Number' 일때 0값(005 등) 입력이 안되서 처리
			if (editKey == "seyno") {
				s.setCellData(e.row,e.col,value.replace(/[^0-9]/g,''));
			}
			else s.setCellData(e.row,e.col,value.toUpperCase());
		}
	});
	
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

