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

var popGugn = "";

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
	}else if(!$(".getPspno").val()){
		toastMsg(LN_SELECT_PSPNO);
		return false;
	}
	
	//초기화
	$("#pspno").val("");
    $("#itdsc").val("");
    $("#carcd").val("");
    $("#carnm").val("");
    $("#mkpno").val("");
    $("#mkpnm").val("");
    $("#bdycd").val("");
    $("#bdynm").val("");
        
	var url = '/ajaxCustPartConstMst/search.do';
	var params = {
		'getComps' : $(".getComps").val(), //List2 사업부
		'getSelchk' : $(":input:radio[name=getSelchk]:checked").val(), //selchk
		'getPyvnd' : $(".getPyvnd").val(), //업체
		'getPspno' : $(".getPspno").val() //품번

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
                $("#carcd").val(data[0].carcd);
                $("#carnm").val(data[0].carnm);
                $("#mkpno").val(data[0].mkpno);
                $("#mkpnm").val(data[0].mkpnm);
                $("#bdycd").val(data[0].bdycd);
                $("#bdynm").val(data[0].bdynm);
            }
         
	      var data2 = JSON.parse(res).list2;
		  cv.sourceCollection = data2;
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
	
	/*wijmo.httpRequest ( url, { 
		data: params,
	    success : function (xhr) { 
	    	var response = JSON.parse(xhr.response).list;
	    	cv.sourceCollection = response;
	    	var response2 = JSON.parse(xhr.response).list2;
	    	cv.sourceCollection = response2;
	     }*/ 
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
					if(gubn == "grid"){
						
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
 * 품번코드으로 품번명 검색하여 데이터 set
 * 
 * @param 품번코드
 */
function getItemSch(gubn, value, s, e) {
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
					if(gubn == "input") $('#getItdsc').val(data.list[0].itdsc);
				}
				else {
					toastMsg(LN_CHK1 + " : " + value);
					if(gubn == "input") {
						$('#getPspno').val("");
											
					}
					if(gubn == "grid") {
						var oldValue = s.getCellData(e.row,"oldCinbr",false);
						if(oldValue == "" || oldValue == null || oldValue == undefined) oldValue = ""; 
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
 * 등록시 오류검증
 */
function validation(item){
	
	if(item.cinbr==null || wijmo.isEmpty(item.cinbr) || item.cinbr == ""){
		alert("수정이나 추가한 행의 [구성품번]컬럼을 입력해야 됩니다.");
		return false;
	}
	
	if(item.qtypr==null || wijmo.isEmpty(item.qtypr) || item.qtypr ==""){
		alert("수정이나 추가한 행의 [구성수량]컬럼을 입력 하세요");
		return false;
	}
	
	if(parseInt(item.qtypr) < 0){
		alert("수정이나 추가한 행의 [구성수량]컬럼에 음수를 입력할 수 없습니다.");
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
	flexGrid.select( new wijmo.grid.CellRange( 0 , 0 , 0 ), true );
	
		
	if(flexGrid.rows.length<1 && cv.itemsRemoved.length == 0){
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
			url : "/ajaxCustPartConstMst/update.do",
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
    	console.debug(cv.itemsAdded[i]);
		
		$.ajax({
			method : "post",
			url : "/ajaxCustPartConstMst/create.do",
			data : cv.itemsAdded[i],
			async: false,
			success : function(xhr) {
            	var data = JSON.parse(xhr);
            	
    			if (data.result != RESULT_OK) {
    				
    				if(data.errMsg == "LN_INS_CHK1") stateMsg = LN_INS_CHK1;
				
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
			url : "/ajaxCustPartConstMst/delete.do",
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
	
	var fileName = '업체부품구성마스타.xlsx';
	transExcel(flexGrid,fileName);
	
}



/**
	버튼 이벤트 처리
**/
function handleEvent(){

	$('.getPyvnd').on('change', function() {
		$(".getCusnm").val("");
	});
	
	$('#getPspno').bind("keyup", function(){       
	    $(this).val($(this).val().toUpperCase());  
	});
	
	$('.getPspno').on('change', function() {
		$(".getItdsc").val("");
	});
	
	//selchk변경시 reset
	$('.getSelchk').on('change', function() {
		$("#pspno").val("");
		$("#itdsc").val("");
		$("#carcd").val("");
		$("#carnm").val("");
		$("#mkpno").val("");
		$("#mkpnm").val("");
		$("#bdycd").val("");
		$("#bdynm").val("");
		
		cv.sourceCollection = [];
	});

	$('._custBtn_').on('click', function() {
		popGugn = "CUST";
		window.open("/ajaxCustomer/init.do","customerPop","width=550,height=600,scrollbars=yes,top=100,left=100");
	});
	
	$('._itemBtn_').on('click', function() {
		popGugn = "ITEM";
		window.open("/ajaxItemMaster/init.do","itemPop","width=550,height=600,scrollbars=yes,top=100,left=100");
	});
	
	//행 추가버튼
	$("._addBtn_").on("click",function(){
		if($(":input:radio[name=getSelchk]:checked").val() == "1"){
			toastMsg(LN_CHK_SELCHK);
			return false;
                
		}else{

       		if(!$(".getComps").val()){
				toastMsg(LN_SELECT_COMPS);
				return false;
			}else if(!$(".getPyvnd").val()){
				toastMsg(LN_SELECT_PYVND);
				return false;
			}else if(!$(".getPspno").val()){
				toastMsg(LN_SELECT_PSPNO);
				return false;
			}
		
    		var stateMsg,
            saveCheck = false;
    	
    		$.ajax({
    			url : "/ajaxCustPartConstMst/check.do",
    			type : "post",
    			data : {
    				"getComps" : $(".getComps").val(),
    				"pyvnd" : $(".getPyvnd").val(),
    				"pspno" : $(".getPspno").val()
    			},
    			success : function(res) {
    				var data = JSON.parse(res);
    				
    				if(data.result === RESULT_OK) {
    					stateMsg = RESULT_OK;
    					saveCheck = true;
    				} else {
    					stateMsg = data.errMsg;
    				}
    				
    			},
    			error : function() {
    				stateMsg = "error";
    			},
    			complete : function() {				
    				if (!saveCheck) {
    					if(stateMsg == "LN_CHK2") toastMsg(LN_CHK2);
    					else toastMsg(stateMsg);
    				}
    				else {					
    					var addRow = cv.addNew();
    					addRow.comps = $(".getComps").val();
    					addRow.selchk = $(":input:radio[name=getSelchk]:checked").val();
    					addRow.pyvnd = $(".getPyvnd").val();
    					addRow.pspno = $(".getPspno").val();
    					cv.commitNew();				
    				}
    			}
    		});

		}
		
	});
	
	// 그리드 row 삭제
	$("._delBtn").on("click",function(){
			if($("#setComps").val() == "" && $("#setOldCinbr").val() == ""){
    	        toastMsg("추가상태의 자료는 수정할 수 없습니다.");
                return false;
                
		}else{
			cv.remove(cv.currentItem);
		}
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
	    {binding:'comps',visible:false}, /*E1*/
	    {binding:'pyvnd',visible:false}, /*1400*/
	    {binding:'pspno',visible:false}, /*41000-000900Q*/
	    {binding:'oldCinbr',visible:false},
	    {binding:'oldQtypr',visible:false},
        {binding: 'cinbr', header: '* '+LN_CHK_CINBR, width: '*', wordWrap: true, align:'center',dataType:'String',maxLength:15  },  //wordWrap: true: 텍스트 자동줄바꿈 autorowHeights랑 같이 사용
        {binding: 'qtypr', header: '* '+LN_CHK_QTYPR, width: '*', align:'center',dataType:'Number',format:'n0', maxLength:2 }
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
			case "cinbr":
				
				if(item.cinbr==null || wijmo.isEmpty(item.cinbr) || item.cinbr == ""){
					return "[구성품번]을 입력해주세요.";
				}
				return null;
				
			case "qtypr":
				
				if(item.qtypr==null || wijmo.isEmpty(item.qtypr) || item.qtypr == "" ){
					return "[구성수량]을 입력해주세요.";
				}
													
				if(parseInt(item.qtypr)< 0){
					return "[구성수량]에는 음수는 입력할 수 없습니다."	;
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
		
		var editKey = s.columns[e.col].binding;
		
		if (editKey == "cinbr") {
			getItemSch('grid', value.toUpperCase(), s, e);
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
