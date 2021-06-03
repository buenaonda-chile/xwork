//code intellisense typescript 정의
///<reference path = "../../wijmo/controls/wijmo.d.ts"/>	
///<reference path = "../../wijmo/controls/wijmo.grid.d.ts"/>
///<reference path = "../../wijmo/controls/wijmo.input.d.ts"/>


// 컬랙션 뷰는 조회후에 그리드의 상태변경을 체크한다. 
var cv = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수

/*
	그룹화 시킬때
var cv = new wijmo.collections.CollectionView(null,{
	sortDescriptions: ['mcrc1'],
    groupDescriptions: ['mcrc1']	
	
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
	}else if(!$(".getMcrcd").val()){
		toastMsg(LN_SELECT_MCRCD);
		return false;
	}else if(!$(".getMsecd").val()){
		toastMsg(LN_SELECT_MSECD);
		return false;
	}
	
	// 초기화
	$("#pspno").val("");
	$("#itdsc").val("");
	$("#cusnm").val("");
	$("#carnm").val("");
	$("#cprtn").val("");
	
	var url = '/ajaxDuplTypeOrderCodeMst/search.do';
	var params = {
		'getComps' : $(".getComps").val(),
		'getPyvnd' : $(".getPyvnd").val(),
		'getMcrcd' : $(".getMcrcd").val(),
		'getMsecd' : $(".getMsecd").val(),
		'getSelchk' : "1"
	};
	
	mask.open();
	$.ajax({
		method : "post",
		url : url,
		data :params,
		success : function(res) {
			var data = JSON.parse(res).list;
			
			if (data.length > 0) {
				$("#pspno").val(data[0].pspno);
				$("#itdsc").val(data[0].itdsc);
				$("#cusnm").val(data[0].cusnm);
				$("#carnm").val(data[0].carnm);
				$("#cprtn").val(data[0].cprtn);
			}
			
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
 * 업체코드로 업체명 검색하여 데이터 set
 * 
 * @param 업체코드
 */
function getCustSch(gubn, value) {
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
	
	if(item.mcrc1==null || wijmo.isEmpty(item.mcrc1) || item.mcrc1 == ""){
		alert("수정이나 추가한 행의 [차종]컬럼을 입력해야 됩니다.");
		return false;
	}
	
	if(item.msec1==null || wijmo.isEmpty(item.msec1) || item.msec1 ==""){
		alert("수정이나 추가한 행의 [서열]컬럼을 입력 하세요");
		return false;
	}
	
	if(parseInt(item.msec1) < 0){
		alert("수정이나 추가한 행의 [서열]컬럼에 음수를 입력할 수 없습니다.");
		return false;
	}
	
	return true;
}

/**
	등록버튼
 */
function update(){
	
	/**
	 * 익스플로러에서 그리드외 다른영역으로 포커스가 빠졌을경우(클릭) 컬랙션뷰에서 변경된 내용을 인식하지 못하는 버그발생
	 * 아래처럼 포커스와 셀을 강제로 영역을 지정함.
	 */
	flexGrid.focus ();
	flexGrid.select( new wijmo.grid.CellRange( 0 , 0 , 0 ), true );
	
		
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
			url : "/ajaxDuplTypeOrderCodeMst/update.do",
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
			url : "/ajaxDuplTypeOrderCodeMst/create.do",
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
			url : "/ajaxDuplTypeOrderCodeMst/delete.do",
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
	
	var fileName = '중복차종서열코드마스타.xlsx';
	
	transExcel(flexGrid,fileName);
	
}



/**
	버튼 이벤트 처리
 */
function handleEvent(){
	
		
	$('.getPyvnd').on('change', function() {
		$(".getCusnm").val("");
	});

	//대문자
	$('.getMcrcd').on('keyup',function() {
		$(this).val($(this).val().toUpperCase());
	});
	$('.getMsecd').on('keyup',function() {
		$(this).val($(this).val().toUpperCase());
	});
	
	//등록폼 닫기버튼
	/*$("._closeBtn_").on("click",function(){
		var target = this.getAttribute("data-click-target");
		addBtnUiSet(this);
	});*/

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
		}else if(!$(".getMcrcd").val()){
			toastMsg(LN_SELECT_MCRCD);
			return false;
		}else if(!$(".getMsecd").val()){
			toastMsg(LN_SELECT_MSECD);
			return false;
		}
		
		// 등록을 위한 업체 서열 차종 자료 확인
		$.ajax({
			method : "post",
			url : "/ajaxDuplTypeOrderCodeMst/search.do",
			data : {
				"getComps" : $(".getComps").val(),
				"getPyvnd" : $(".getPyvnd").val(),
				"getMcrcd" : $(".getMcrcd").val(),
				"getMsecd" : $(".getMsecd").val(),
				"getSelchk" : "2",
			},
			success : function(res) {
				var data = JSON.parse(res);			

				if (data.list.length > 0) {

					$("#pspno").val(data.list[0].pspno);
					$("#itdsc").val(data.list[0].itdsc);
					$("#cusnm").val(data.list[0].cusnm);
					$("#carnm").val(data.list[0].carnm);
					$("#cprtn").val(data.list[0].cprtn);
				
					var addRow = cv.addNew();
					addRow.comps = $(".getComps").val();
					addRow.pyvnd = $(".getPyvnd").val();
					addRow.mcrcd = $(".getMcrcd").val();
					addRow.msecd = $(".getMsecd").val();
					cv.commitNew();					
				}
				else {
					toastMsg("[알림]차종/서열이 미등록된 자료입니다.");
					return false;
				}
			},
			error : function() {

			},
			completed : function() {

			}
		});
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
	 *	grid 셋팅
	 *	gridCommon.js 에서 공통으로 처리되있는 옵션을 변경하고 싶다면 gridInit 함수에서 바꾸고싶은 옵션만 재정의 하면됨.
	 */
	//컬럼정의
	columnsDefinition = [
	    {binding:'comps',visible:false},
	    {binding:'pyvnd',visible:false},
	    {binding:'mcrcd',visible:false},
	    {binding:'msecd',visible:false},
	    {binding:'oldMcrc1',visible:false},
	    {binding:'oldMsec1',visible:false},
        {binding: 'mcrc1', header: '* '+ LN_CHK_MCRC1, width: '*', wordWrap: true, align:'center',dataType:'String',maxLength:2  },  //wordWrap: true: 텍스트 자동줄바꿈 autorowHeights랑 같이 사용
        {binding: 'msec1', header: '* '+ LN_CHK_MSEC1, width: '*', align:'center',dataType:'String', maxLength:3 }
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
			case "mcrc1":
				
				if(item.mcrc1==null || wijmo.isEmpty(item.mcrc1) || item.mcrc1 == ""){
					return "[차종]을 입력해야 됩니다.";
				}
				return null;
				
			case "msec1":
				
				if(item.msec1==null || wijmo.isEmpty(item.msec1) || item.msec1 == "" ){
					return "[서열]을 입력 하세요.";
				}
													
				if(parseInt(item.msec1)< 0){
					return "[서열]에는 음수는 입력할 수 없습니다."	;
				}
				return null;
				
		}
		return null;
	}

	//대문자 변경
	flexGrid.cellEditEnded.addHandler(function(s,e){
		var value = s.getCellData(e.row,e.col,false);
		
		if(s.columns[e.col].dataType==wijmo.DataType.String){
			s.setCellData(e.row,e.col,value.toUpperCase());
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
