

// 컬랙션 뷰는 조회후에 그리드의 상태변경을 체크한다. 
var cv = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수

var flexGrid = new wijmo.grid.FlexGrid('#wijmoGrid');	//그리드 전역변수
var zoomSize = 11;

var popGugn = "";

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
 * 품목코드로 품목명 검색하여 데이터 set
 * 
 * @param 품목코드
 */
function getItemSch(gubn, value) {
	if(value != ""){
		
		$.ajax({
			method : "post",
			url : "/ajaxItemMaster/search.do",
			data : {
				"getItnbr" : value,
				"getGbn" : "1",
				"getComps" : $("#getComps").val()
			},
			success : function(res) {
				var data = JSON.parse(res);			
				
				if (data.list.length > 0) {
					$('#getItdsc').val(data.list[0].itdsc); 
				}
				else {
					toastMsg(LN_CHK1 + " : " + value);
					if(gubn == "input") {
						$("#getPspno").val("");	
						//$("#getItdsc").val("");
					}					
					//if(gubn == "grid") grid.target.setValue(currGridIndex, "pspno", "");
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
		var retObj = JSON.parse(returnValue);

		if(popGugn == "CUST"){
			$('#getPyvnd').val(retObj.cusno);
			$('#getCusnm').val(retObj.cusnm);
		}
		if(popGugn == "ITEM"){
			$('#getPspno').val(retObj.itnbr);
			$('#getItdsc').val(retObj.itdsc);
		}		
	}
}

/**
 * ======================================
 * [ko] 정보 검색하는 함수<br>
 * ======================================
 */
function search() {
	
	if(!$(".getComps").val()){
		toastMsg(LN_SELECT_COMPS);
		return false;
	}else if(!$(".getPyvnd").val()){
		toastMsg(LN_SELECT_PYVND);
		return false;
	}

	var url = '/ajaxCustOrderTypeMst/search.do';
	
	var params = {
		"getComps" : $(".getComps").val(),
		"getPchk" : $(":input:radio[name=getPchk]:checked").val(),
		"getPyvnd" : $(".getPyvnd").val(),
		"getPspno" : $(".getPspno").val()
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
	
	var modName = "";
	if($(":input:radio[name=getPchk]:checked").val() == "2") modName = "추가";
	else modName = "수정";
	
	if(item.mcrcd==null || wijmo.isEmpty(item.mcrcd) || item.mcrcd == ""){
		alert(modName + "할 행의 [차종코드]컬럼을 입력하세요");
		return false;
	}
	
	if(item.seqcd==null || wijmo.isEmpty(item.seqcd) || item.seqcd ==""){
		alert(modName + "할 행의 [서열코드]컬럼을 입력하세요");
		return false;
	}
	
	if(item.seqno==null || wijmo.isEmpty(item.seqno) || item.seqno ==""){
		alert(modName + "할 행의 [서열번호]컬럼을 입력하세요");
		return false;
	}
	
	/*
	if(item.efffr==null || wijmo.isEmpty(item.efffr) || item.efffr ==""){
		alert(modName + "할 행의 [적용FROM]컬럼을 입력하세요");
		return false;
	}
	
	if(item.effto==null || wijmo.isEmpty(item.effto) || item.effto ==""){
		alert(modName + "할 행의 [적용TO]컬럼을 입력하세요");
		return false;
	}
	*/
	
	return true;
}

function itemCheck(checkItem){
	var stateMsg,
        saveCheck = false;
	
	var comps = checkItem.comps;
	if(comps==null || wijmo.isEmpty(comps) || comps =="") comps = $(".getComps").val();
	
	var params = {
			"comps" : comps,
			"pyvnd" : checkItem.pyvnd,
			"mcrcd" : checkItem.mcrcd,
			"seqcd" : checkItem.seqcd,
			"efffr" : checkItem.efffr,
			"effto" : checkItem.effto,
			"pspno" : checkItem.pspno	
		};
    
	//중복차종 서열코드마스타 Check(중복차종서열코드마스타에　등록된　대표차종,서열은　등록不)
	$.ajax({
		url : "/ajaxCustOrderTypeMst/check.do",
		type : "post",
		async : false,
		data : params,
		success : function(res) {
			var data = JSON.parse(res);
			
			if(data.result === RESULT_OK) {
				stateMsg = RESULT_OK;
				saveCheck = true;
			} else {
				stateMsg = data.errMsg;
				
				if(stateMsg == "LN_CHK1") alert(LN_CHK1);
				else if(stateMsg == "LN_CHK2") alert(LN_CHK2);
				else if(stateMsg == "LN_CHK3") alert(LN_CHK3);
				else if(stateMsg == "LN_CHK4") alert(LN_CHK4);
				else alert(stateMsg);
			}
			
		},
		error : function() {
			stateMsg = "error";
		},
		complete : function() {				

		}
	});

	return saveCheck;
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
	
	/*
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
	*/
	
	var editList = cv.itemsEdited;

	if(editList.length == 0 && cv.itemsRemoved.length == 0){
		alert("저장할 내용이 없습니다.");
		return;
	} 
	
	for ( var i = 0; i <editList.length; i ++) {
		var item = editList[i];
		
		if(!validation(item) || !itemCheck(item)){
			return false;
		}
		else {
			if(item.efffr==null || wijmo.isEmpty(item.efffr) || item.efffr =="") editList[i].efffr = new Date().toISOString().substr(0, 10).replace('T', ' ').replace(/-/gi, '');

			if(item.effto==null || wijmo.isEmpty(item.effto) || item.effto =="") editList[i].effto = "99999999";
		}
	}

	var ajaxUrl = "";
	//if($(":input:radio[name=getPchk]:checked").val() == "2") ajaxUrl = "create.do";
	//else ajaxUrl = "update.do";
	
	var stateMsg=RESULT_OK;
	var isModify = false;
	
	// Update : 업데이트 프로세스 
    for ( var i = 0; i <editList.length; i ++) {
    	console.debug(editList[i]);

    	if(editList[i].comps==null || wijmo.isEmpty(editList[i].comps) || editList[i].comps =="") {
    		ajaxUrl = "create.do";
    		editList[i].comps = $(".getComps").val();	
    	}
    	else ajaxUrl = "update.do";
    	
		$.ajax({
			method : "post",
			url : "/ajaxCustOrderTypeMst/" + ajaxUrl,
			data : editList[i],
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
    
    /*
    // Create : 생성 처리
    for ( var i = 0; i <cv.itemsAdded.length; i ++) {
    	console.debug(cv.itemsAdded[i]);
    	
		$.ajax({
			method : "post",
			url : "/ajaxCustOrderTypeMst/create.do",
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
	*/
    
    // Delete : 삭제 처리 
    for ( var i = 0; i <cv.itemsRemoved.length; i ++) {
    	console.debug(cv.itemsRemoved[i]);
    	
		$.ajax({
			method : "post",
			url : "/ajaxCustOrderTypeMst/delete.do",
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


// 엑셀다운 버튼 처리
function downloadExcel(){
	
	var fileName = '업체서열차종마스타'+".xlsx";
	
	transExcel(flexGrid,fileName);
	
}

/**
	버튼 이벤트 처리
 */
function handleEvent(){
	
	//업체 선택버튼
	$('._custBtn_').on('click', function() {
		popGugn = "CUST";
		window.open("/ajaxCustomer/init.do","customerPop","width=550,height=600,scrollbars=yes,top=100,left=100");
	});
	
	// 품번 선택버튼
	$('._itemBtn_').on('click', function() {
		popGugn = "ITEM";
		window.open("/ajaxItemMaster/init.do","itemPop","width=550,height=600,scrollbars=yes,top=100,left=100");
	});	
	
	
	$('#getPspno').bind("keyup", function(){       
	    $(this).val($(this).val().toUpperCase());  
	});
	
	$('.getPyvnd').on('change', function() {
		$(".getCusnm").val("");
	});
	
	$('.getPspno').on('change', function() {
		$(".getItdsc").val("");
	});
	

	//행 삭제
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
	    {binding:'oldSeqno',visible:false},
	    {binding:'oldSeqcd',visible:false},
	    {binding:'oldMcrcd',visible:false},
	    {binding:'oldEfffr',visible:false},
	    {binding:'oldEffto',visible:false},
        {binding: 'pspno', header: LN_CHK_PSPNO, width: '*', wordWrap: true, align:'center',dataType:'String',isReadOnly: true},  //wordWrap: true: 텍스트 자동줄바꿈 autorowHeights랑 같이 사용
        {binding: 'itdsc', header: LN_CHK_ITDSC, width: '*', align:'center',dataType:'String',isReadOnly: true},
        {binding: 'carnm', header: LN_CHK_CARNM, width: '*', align:'center',dataType:'String',isReadOnly: true},
        {binding: 'mkpno', header: LN_CHK_MKPNO, width: '*', align:'center',dataType:'String',isReadOnly: true},
        {binding: 'mcrcd', header: '* '+ LN_CHK_MCRCD, width: '*', align:'center',dataType:'String', maxLength:2},
        {binding: 'seqcd', header: '* '+ LN_CHK_SEQCD, width: '*', align:'center',dataType:'String', maxLength:4},
        {binding: 'seqno', header: '* '+ LN_CHK_SEQNO, width: '*', align:'center',dataType:'String', maxLength:3},
        {binding: 'efffr', header: '* '+ LN_CHK_EFFFR, width: '*', align:'center',dataType:'String', maxLength:8},
        {binding: 'effto', header: '* '+ LN_CHK_EFFTO, width: '*', align:'center',dataType:'String', maxLength:8}
		// 콤보박스 추가하려면 dataMap
    ];

	//컬럼 초기화
	flexGrid.initialize({
		columns: columnsDefinition
	});
	
}

function isDatetimeValid(d){
    var re = /[0-9]{4}(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])/;
    return re.test(d);
}

function gridEvent(){
	
	//validation
	/*
	cv.getError = function(item,prop){
		switch(prop){
			case "mcrcd":
				
				if(item.mcrcd==null || wijmo.isEmpty(item.mcrcd) || item.mcrcd == ""){
					return "[차종코드]를 입력 하세요.";
				}
				return null;
			case "seqcd":
				
				if(item.seqcd==null || wijmo.isEmpty(item.seqcd) || item.seqcd == ""){
					return "[서열코드]를 입력 하세요.";
				}
				return null;
			case "seqno":
				
				if(item.seqno==null || wijmo.isEmpty(item.seqno) || item.seqno == ""){
					return "[서열번호]를 입력 하세요.";
				}
				return null;
			case "efffr":
				
				if(item.efffr==null || wijmo.isEmpty(item.efffr) || item.efffr == ""){
					return "[적용FROM]를 입력 하세요.";
				}
				return null;
			case "effto":
				
				if(item.effto==null || wijmo.isEmpty(item.effto) || item.effto == ""){
					return "[적용TO]를 입력 하세요.";
				}
				return null;
		}
		return null;
	}
	*/

	//대문자 변경
	flexGrid.cellEditEnded.addHandler(function(s,e){
		var value = s.getCellData(e.row,e.col,false);
		
		var editKey = s.columns[e.col].binding;
		
		if(s.columns[e.col].dataType==wijmo.DataType.String){
			// 서열번호 숫자만 입력 : dataType:'Number' 일때 0값(005 등) 입력이 안되서 처리
			// 날짜 숫자만 입력
			if (editKey == "seqno" || editKey == "efffr" || editKey == "effto") {
				s.setCellData(e.row,e.col,value.replace(/[^0-9]/g,''));
			}
			else s.setCellData(e.row,e.col,value.toUpperCase());
		}
		
		if (editKey == "efffr" || editKey == "effto") {
			var efffr = s.getCellData(e.row,'efffr',false);
			var effto = s.getCellData(e.row,'effto',false);

			if(!(efffr == "" || efffr == null || efffr == "99999999")){
				var frFlag = isDatetimeValid(efffr);				
				if(!frFlag) {
					toastMsg("날짜는 yyyymmdd 형식으로 입력해주세요.");
					s.setCellData(e.row,"efffr","");
					return false;
				}
			}
			
			if(!(effto == "" || effto == null || effto == "99999999")){
				var toFlag = isDatetimeValid(effto);
				if(!toFlag) {
					toastMsg("날짜는 yyyymmdd 형식으로 입력해주세요.");
					s.setCellData(e.row,"effto","");
					return false;
				}
			}
			
			if(!(efffr == "" || efffr == null || efffr == "99999999") && !(effto == "" || effto == null || effto == "99999999")){
				if(efffr > effto){	
					s.setCellData(e.row,"effto","");
					toastMsg(LN_SELECT_EFFCK);
					return false;
				}
			}
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


