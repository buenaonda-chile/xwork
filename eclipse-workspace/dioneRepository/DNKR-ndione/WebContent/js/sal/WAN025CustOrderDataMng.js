
// 컬랙션 뷰는 조회후에 그리드의 상태변경을 체크한다. 
var cv = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수

var flexGrid = new wijmo.grid.FlexGrid('#wijmoGrid');	//그리드 전역변수
var zoomSize = 11;


/**
조회버튼
*/
function search(){
	
	if(!$(".getLocCode").val()){
		toastMsg(LN_SELECT_COMPS);
		return false;
	}else if(!$(".getChgdt").val()){
		toastMsg(LN_SELECT_CHGDT);
		return false;
	}/*else if(!$(".getTypcd").val()){
		toastMsg(LN_SELECT_TYPCD);
		return false;
	}
	*/
	var oGetChgdt = $('#getChgdt').val();	//기준일자
	var pGetChgdt = oGetChgdt.replace(/-/gi,"");
	var oGetPlndt = $('#getPlndt').val();	//계획일자
	var pGetPlndt = oGetPlndt.replace(/-/gi,"");
	
	
	var url = '/WAN025CustOrderDataMng/search.do';
	var params = {
		"getLocCode" : $(".getLocCode").val(),
		//"getComps" : $(".getLocCode").val(),
		"getChgdt" : pGetChgdt,
		"getTypcd" : $(".getTypcd").val(),	
		"getPyvnd" : $(".getPyvnd").val(),
		"getPspno" : $(".getPspno").val(),
		"getPlndt" : pGetPlndt
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
 * 업체코드로 업체명 검색하여 데이터 set
 * 
 * @param 업체코드
 */
function getCustSch(gubn, value, s, e) {
	if(value != ""){
		//loc코드 →comps코드 변환(기개발된 업체코드/품번 체크 function 사용으로 해당 로직 추가)
		var transComps= $(".getLocCode").val();
		if(transComps=="LOC000004")  $("#getComps").val("E1");
		else if(transComps=="LOC000001") $("#getComps").val("C1");
		else if(transComps=="LOC000002") $("#getComps").val("H1");
		else if(transComps=="LOC000003") $("#getComps").val("S1");
		else if(transComps=="LOC000005") $("#getComps").val("R1");
		
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
					if(gubn == "grid") {
						var oldValue = s.getCellData(e.row,'oldPyvnd2',false);
						
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

/**
 * 품목코드로 품목명 검색하여 데이터 set
 * 
 * @param 품목코드
 */
function getItemSch() {
	if($('#getPspno').val() != ""){
		//loc코드 →comps코드 변환(기개발된 업체코드/품번 체크 function 사용으로 해당 로직 추가)
		var transComps= $(".getLocCode").val();
		if(transComps=="LOC000004")  $("#getComps").val("E1");
		else if(transComps=="LOC000001") $("#getComps").val("C1");
		else if(transComps=="LOC000002") $("#getComps").val("H1");
		else if(transComps=="LOC000003") $("#getComps").val("S1");
		else if(transComps=="LOC000005") $("#getComps").val("R1");
		
		$.ajax({
			method : "post",
			url : "/ajaxItemMaster/search.do",
			data : {
				"getItnbr" : $('#getPspno').val(),
				"getGbn" : "1",
				"getComps" : $("#getComps").val()
			},
			success : function(res) {
				var data = JSON.parse(res);			
				
				if (data.list.length == 0) {					
					toastMsg(LN_IO_CHK2 + " : " + $('#getPspno').val()); 
					$('#getPspno').val("");
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
	
	if(item.basqy==null || wijmo.isEmpty(item.basqy) || item.basqy ==""){
		alert("수정한 행의 [계획수량]컬럼을 입력 하세요");
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
	/*
	for ( var i = 0; i <cv.itemsAdded.length; i ++) {
		if(!validation(cv.itemsAdded[i])){
			return false;
		}	
	}
	 */
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
			url : "/WAN025CustOrderDataMng/update.do",
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

    // Delete : 삭제 처리 
    for ( var i = 0; i <cv.itemsRemoved.length; i ++) {
    	
		$.ajax({
			method : "post",
			url : "/WAN025CustOrderDataMng/delete.do",
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
	
	var fileName = '수주업로드자료관리.xlsx';
	transExcel(flexGrid,fileName);
	
}



/**
	버튼 이벤트 처리
 */
function handleEvent(){

	$('#getPspno').bind("keyup", function(){       
	    $(this).val($(this).val().toUpperCase());  
	});
	
	$('.getLocCode').on('change', function() {
		//loc코드 →comps코드 변환(기개발된 업체코드/품번 체크 function 사용으로 해당 로직 추가)
		var transComps= $(".getLocCode").val();
		if(transComps=="LOC000004")  $("#getComps").val("E1");
		else if(transComps=="LOC000001") $("#getComps").val("C1");
		else if(transComps=="LOC000002") $("#getComps").val("H1");
		else if(transComps=="LOC000003") $("#getComps").val("S1");
		else if(transComps=="LOC000005") $("#getComps").val("R1");
		
	    $(".getPyvnd").val("");
		$(".getCusnm").val("");
		
		$(".getPspno").val("");
		$(".getPlndt").val("");

		// 그리드 헤더 변경
		gridInit();
	});
	
	$('.getPyvnd').on('change', function() {
		$(".getCusnm").val("");
	});

/*	
	//등록폼 닫기버튼
	$("._closeBtn_").on("click",function(){
		
	});

	//행 추가버튼
	$("._addBtn_").on("click",function(){
		

	});
*/
	// 그리드 row 삭제
	$("._delBtn").on("click",function(){
		cv.remove(cv.currentItem);
	});
	
	$('._custBtn_').on('click', function() {
		window.open("/ajaxCustomer/init.do","customerPop","width=550,height=600,scrollbars=yes,top=100,left=100");
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
	    {binding: 'comps', header: LB_COMPS, width: '*', align:'center', isReadOnly: true},  //wordWrap: true: 텍스트 자동줄바꿈 autorowHeights랑 같이 사용
	    {binding: 'typcd',visible:false},
	    {binding: 'typcnm', header: LB_TYPCNM, width: '*', align:'center', isReadOnly: true },
	    {binding: 'pyvnd', header: LB_PYVND, width: '*', align:'center', isReadOnly: true},
	    {binding: 'cusnm', header: LB_CUSNM, width: '*', align:'center', isReadOnly: true},
	    {binding: 'pspno', header: LB_PSPNO, width: '*', align:'center', isReadOnly: true},
	    {binding: 'plndt', header: LB_PLNDT, width: '*', align:'center', isReadOnly: true},
	    {binding: 'basqy', header: '* '+ LN_CHK_BASQY, width: '*', align:'center',dataType:'Number', format:'d', maxLength:7 },
	    {binding: 'plncd', header: LB_PLNCD, width: '*', align:'center', isReadOnly: true},
	    {binding: 'chgdt', header: LB_CHGDT, width: '*', align:'center', isReadOnly: true}
	
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
			case "basqy":
				
				if(item.basqy==null || wijmo.isEmpty(item.basqy) || item.basqy == ""){
					return "[계획수량]을 입력 하세요.";
				}
				return null;
			
		}
		return null;
	}

	//대문자 변경, 자료 유효성 확인
	flexGrid.cellEditEnded.addHandler(function(s,e){
		
		var value = s.getCellData(e.row,e.col,false);
		
		if(s.columns[e.col].dataType==wijmo.DataType.String){
			s.setCellData(e.row,e.col,value.toUpperCase());
		}
		
		
		var editKey = s.columns[e.col].binding;
		
	});
	
}

function getToday(){
	var date = new Date();
	return date.getFullYear() + "-" + ("0"+(date.getMonth()+1)).slice(-2) + "-" + ("0"+date.getDate()).slice(-2);
}

$(document.body).ready(function() {

	var chgdt_calendar = new ax5.ui.calendar({
        target: document.getElementById("chgdt_calendar"),
        control: {
            left: '<i class="fa fa-chevron-left"></i>',
            yearTmpl: '%s',
            monthTmpl: '%s',
            right: '<i class="fa fa-chevron-right"></i>',
            yearFirst: true
        },
        displayDate: (new Date()),
        dimensions: {
            height: 250,
            controlHeight: 40,
            itemPadding: 1
        },
        lang: {
        	/*yearTmpl: "%s년",*/
            /*months: ['일월', '이월', '삼월', '사월', '오월', '육월', '칠월', '팔월', '구월', '시월', '십일월', '십이월'],*/
        	yearTmpl: YEAR_FORMAT,
        	months: MONTH,
        	dayTmpl: "%s"
        },
        onClick: function () {
            $(this.target).css('display', 'none');
            $(this.target).prev().val(chgdt_calendar.getSelection());            
        },
        onStateChanged: function () {
            //console.log(this);
        }
    });
	
	var plndt_calendar = new ax5.ui.calendar({
        target: document.getElementById("plndt_calendar"),
        control: {
            left: '<i class="fa fa-chevron-left"></i>',
            yearTmpl: '%s',
            monthTmpl: '%s',
            right: '<i class="fa fa-chevron-right"></i>',
            yearFirst: true
        },
        displayDate: (new Date()),
        dimensions: {
            height: 250,
            controlHeight: 40,
            itemPadding: 1
        },
        lang: {
        	/*yearTmpl: "%s년",*/
            /*months: ['일월', '이월', '삼월', '사월', '오월', '육월', '칠월', '팔월', '구월', '시월', '십일월', '십이월'],*/
        	yearTmpl: YEAR_FORMAT,
        	months: MONTH,
        	dayTmpl: "%s"
        },
        onClick: function () {
            $(this.target).css('display', 'none');
            $(this.target).prev().val(plndt_calendar.getSelection());            
        },
        onStateChanged: function () {
            //console.log(this);
        }
    });
	
	$('.gridContents .dropdown').on('click', function(e){
		$($(e.target).next('.dropdown-menu')).css('display', 'block');
	});
	
	//그리드 공통js 호출 후에 나머지 함수 호출함.
	$.getScript('/js/sal/gridCommon.js').done(function() {
		
		commonGrid.init(flexGrid,cv); //그리드 공통부분
		
		gridInit();  	//그리드 초기화
		gridEvent();	//그리드 이벤트
		handleEvent();	//프로그램 버튼 이벤트	
		
		// 처리일자 오늘날짜로 셋팅
		var nowDate = getToday();
		$('#getChgdt').val(nowDate);
		
	});
	
	//셀렉트박스 미사용 사업부코드 제거
	$("#getLocCode option[value='LOC000002']").remove();
	$("#getLocCode option[value='LOC000005']").remove();
		
	//loc코들 →comps코드 변환(기개발된 업체코드/품번 체크 function 사용으로 해당 로직 추가)
	var transComps= $(".getLocCode").val();
	if(transComps=="LOC000004")  $("#getComps").val("E1");
	else if(transComps=="LOC000001") $("#getComps").val("C1");
	else if(transComps=="LOC000002") $("#getComps").val("H1");
	else if(transComps=="LOC000003") $("#getComps").val("S1");
	else if(transComps=="LOC000005") $("#getComps").val("R1");
	
});