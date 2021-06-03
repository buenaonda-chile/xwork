
// 컬랙션 뷰는 조회후에 그리드의 상태변경을 체크한다. 
var cv = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수

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
	}else if(!$(".getCarcd").val()){
		toastMsg(LN_SELECT_CARCD);
		return false;
	}else if(!$(".getBdycd").val()){
		toastMsg(LN_SELECT_BDYCD);
		return false;
	}
		
	var url = '/ajaxTopCustTypeMst/search.do';
	var params = {
		"getComps" : $(".getComps").val(),
		"getPyvnd" : $(".getPyvnd").val(),
		"getCarcd" : $(".getCarcd").val(),
		"getBdycd" : $(".getBdycd").val()		
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
 * 대표차종코드로 차종명 검색하여 데이터 set
 * 
 * @param 대표차종코드
 */
function getCarSch(gubn, value, s, e) {
	if(value != ""){
		$.ajax({
			method : "post",
			url : "/ajaxTopCustTypeMst/schnm.do",
			data : {
				"getComps" : $("#getComps").val(),
				"getTflag" : "CAR",
				"getTval" : value
			},
			success : function(res) {
				var data = JSON.parse(res);			

				if (data.list == undefined) {
					toastMsg(LN_CHK4 + " : " + value);
					
					if(gubn == "input") {
						$('#getCarcd').val("");
						$('#getCarnm').val("");
					}
					if(gubn == "grid") {
						var oldValue = s.getCellData(e.row,"oldCarcd2",false);
						if(oldValue == "" || oldValue == null || oldValue == undefined) oldValue = ""; 
						s.setCellData(e.row,e.col,oldValue);
					}
				}
				else {
					if(gubn == "input") $('#getCarnm').val(data.list.mstsm);
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
 * 대표규격코드로 규격명 검색하여 데이터 set
 * 
 * @param 대표규격코드
 */
function getBdySch(gubn, value, s, e) {
	if(value != ""){		
		$.ajax({
			method : "post",
			url : "/ajaxTopCustTypeMst/schnm.do",
			data : {
				"getComps" : $("#getComps").val(),
				"getTflag" : "BDY",
				"getTval" : value
			},
			success : function(res) {
				var data = JSON.parse(res);			
				
				if (data.list == undefined) {
					toastMsg(LN_CHK5 + " : " + value);
					
					if(gubn == "input") {
						$('#getBdycd').val("");
						$('#getBdynm').val("");
					}
					if(gubn == "grid") {
						var oldValue = s.getCellData(e.row,"oldBdycd2",false);
						if(oldValue == "" || oldValue == null || oldValue == undefined) oldValue = ""; 
						s.setCellData(e.row,e.col,oldValue);
					}
				}
				else {
					if(gubn == "input") $('#getBdynm').val(data.list.mstsm);
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
	
	if(item.comps2==null || wijmo.isEmpty(item.comps2) || item.comps2 == ""){
		alert("수정이나 추가한 행의 [사업부]컬럼을 입력해야 됩니다.");
		return false;
	}
	
	if(!(item.comps2 == null || item.comps2 == "")){
		if($("#getComps").val() == "E1"){
		//if($("#getCompany").val() == "E1"){
			if(item.comps2 != "E1"){
				alert(LN_CHK1 + "합니다.");
				return false;
			}
		}else{
			if(!(item.comps2 == "C1" || item.comps2 == "H1" || item.comps2 == "S1")){
				alert(LN_CHK2 + "합니다.");
				return false;
			}
		}				
	}
	
	if(item.pyvnd2==null || wijmo.isEmpty(item.pyvnd2) || item.pyvnd2 ==""){
		alert("수정이나 추가한 행의 [업체]컬럼을 입력 하세요");
		return false;
	}
		
	if(item.carcd2==null || wijmo.isEmpty(item.carcd2) || item.carcd2 ==""){
		alert("수정이나 추가한 행의 [차종]컬럼을 입력 하세요");
		return false;
	}
	
	if(item.bdycd2==null || wijmo.isEmpty(item.bdycd2) || item.bdycd2 ==""){
		alert("수정이나 추가한 행의 [규격]컬럼을 입력 하세요");
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
			url : "/ajaxTopCustTypeMst/update.do",
			data : cv.itemsEdited[i],
			async: false,
			success : function(xhr) {
    	    	var data = JSON.parse(xhr);
            	
    	    	if(data.result != RESULT_OK) {
    				
    				if(data.errMsg == "LN_CHK3") stateMsg = LN_CHK3;
    				if(data.errMsg == "LN_CHK4") stateMsg = LN_CHK4;
    				if(data.errMsg == "LN_CHK5") stateMsg = LN_CHK5;
    				
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
			url : "/ajaxTopCustTypeMst/create.do",
			data : cv.itemsAdded[i],
			async: false,
			success : function(xhr) {
            	var data = JSON.parse(xhr);
            	
    			if (data.result != RESULT_OK) {
    				
					if(data.errMsg == "LN_CHK3") stateMsg = LN_CHK3;
					if(data.errMsg == "LN_CHK4") stateMsg = LN_CHK4;
					if(data.errMsg == "LN_CHK5") stateMsg = LN_CHK5;
					
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
			url : "/ajaxTopCustTypeMst/delete.do",
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
	
	var fileName = '대표업체차종마스타.xlsx';
	transExcel(flexGrid,fileName);
	
}



/**
	버튼 이벤트 처리
 */
function handleEvent(){

	$('#getCarcd').bind("keyup", function(){       
	    $(this).val($(this).val().toUpperCase());  
	});
	$('#getBdycd').bind("keyup", function(){       
	    $(this).val($(this).val().toUpperCase());  
	});
	
	$('.getComps').on('change', function() {
		$(".getPyvnd").val("");
		$(".getCusnm").val("");
		
		$(".getCarcd").val("");
		$(".getCarnm").val("");
		
		$(".getBdycd").val("");
		$(".getBdynm").val("");
		
		// 그리드 헤더 변경
		gridInit();
	});
	
	$('.getPyvnd').on('change', function() {
		$(".getCusnm").val("");
	});

	$('.getCarcd').on('change', function() {
		$(".getCarnm").val("");
	});
	
	$('.getBdycd').on('change', function() {
		$(".getBdynm").val("");
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
		}else if(!$(".getCarcd").val()){
			toastMsg(LN_SELECT_CARCD);
			return false;
		}else if(!$(".getBdycd").val()){
			toastMsg(LN_SELECT_BDYCD);
			return false;
		}
		
		var addRow = cv.addNew();
		addRow.comps1 = $(".getComps").val();
		addRow.pyvnd1 = $(".getPyvnd").val();
		addRow.carcd1 = $(".getCarcd").val();
		addRow.bdycd1 = $(".getBdycd").val();
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

	var compsHeader = LN_CHK_COMPS2;
	
	if($("#getComps").val() == "E1") compsHeader += " (" + LN_CHK1 + ")";
	else compsHeader += " (" + LN_CHK2 + ")";
	
	/**
	 *	grid 셋팅
	 *	gridCommon.js 에서 공통으로 처리되있는 옵션을 변경하고 싶다면 gridInit 함수에서 바꾸고싶은 옵션만 재정의 하면됨.
	 */
	//컬럼정의
	columnsDefinition = [
		{binding:'comps1',visible:false},
	    {binding:'pyvnd1',visible:false},
	    {binding:'carcd1',visible:false},
	    {binding:'bdycd1',visible:false},
	    {binding:'oldComps2',visible:false},
	    {binding:'oldPyvnd2',visible:false},
	    {binding:'oldCarcd2',visible:false},
	    {binding:'oldBdycd2',visible:false},
	    {binding: 'comps2', header: '* '+ compsHeader, width: '*', wordWrap: true, align:'center',dataType:'String',maxLength:2  },  //wordWrap: true: 텍스트 자동줄바꿈 autorowHeights랑 같이 사용
	    {binding: 'pyvnd2', header: '* '+ LN_CHK_PYVND2, width: '*', align:'center',dataType:'Number', format:'d', maxLength:8 },
	    {binding: 'carcd2', header: '* '+ LN_CHK_CARCD2, width: '*', align:'center',dataType:'String', maxLength:3},
	    {binding: 'bdycd2', header: '* '+ LN_CHK_BDYCD2, width: '*', align:'center',dataType:'String', maxLength:3}
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
			case "comps2":
				
				if(item.comps2==null || wijmo.isEmpty(item.comps2) || item.comps2 == ""){
					return "[사업부]를 입력 하세요.";
				}
				return null;
				
			case "pyvnd2":
				
				if(item.pyvnd2==null || wijmo.isEmpty(item.pyvnd2) || item.pyvnd2 == "" ){
					return "[업체]를 입력 하세요.";
				}
				return null;
				
			case "carcd2":
			
				if(item.carcd2==null || wijmo.isEmpty(item.carcd2) || item.carcd2 == "" ){
					return "[차종]을 입력 하세요.";
				}
				return null;
				
			case "bdycd2":
				
				if(item.bdycd2==null || wijmo.isEmpty(item.bdycd2) || item.bdycd2 == "" ){
					return "[규격]을 입력 하세요.";
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
		
		if (editKey == "pyvnd2") {
			getCustSch('grid', value, s, e);
		}
		if (editKey == "carcd2") {
			getCarSch('grid', value.toUpperCase(), s, e);			
		}
		if (editKey == "bdycd2") {
			getBdySch('grid', value.toUpperCase(), s, e);
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
