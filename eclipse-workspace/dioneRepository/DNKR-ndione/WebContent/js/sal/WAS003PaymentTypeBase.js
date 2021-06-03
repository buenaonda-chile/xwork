// 컬랙션 뷰는 조회후에 그리드의 상태변경을 체크한다. 
var cv = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수


var flexGrid = new wijmo.grid.FlexGrid('#wijmoGrid');	//그리드 전역변수
var zoomSize = 11;

var comps = [
		{id:'PS',name:'구KA'},
		{id:'PE',name:'구KE'},
	];
var compsMap = new wijmo.grid.DataMap(comps, 'id', 'name');
/**
 * 더존 부서정보 취득
 */
function getDeptMaster() {
		if($('.getComps').val() != ""){
		//loc코드 →comps코드 변환(기개발된 업체코드/품번 체크 function 사용으로 해당 로직 추가)
		var transComps= $(".getComps").val();
		if(transComps=="PE")  $("#getTrncCode").val("E1");
		else if(transComps=="PS") $("#getTrncCode").val("C1");
		}
		
		console.log(getComps);
		$.ajax({
			method: "post",
			url: "/ajaxCustomer/search.do",
			data: {
				'getComps': $("#getComps").val()
			},
			success: function(res) {
				itemMast = JSON.parse(res).list;
			},
			error: function() {
				console.log("dataset.error");
			},
			completed: function() {
				setTimeout(function() {
					mask.close();
				}, 500);
			}
		});
}

/**
 조회버튼
 */
function search() {
	initSetMaster();

	if (!$(".getComps").val()) {
		toastMsg(LN_SELECT_COMPS);
		return false;
	}

	var url = '/ajaxPaymentTypeBase/search.do';
	var params = {
		'getComps' : $(".getComps").val(),
		'getPyvnd': $(".getPyvnd").val()
	};

	mask.open();
	$.ajax({
		method: "post",
		url: url,
		data: params,
		success: function(res) {
			var data = JSON.parse(res).list;
			cv.sourceCollection = data;

		},
		error: function() {
			console.log("dataset.error");

		},
		complete: function() {
			//console.log("dataset.completed");
			setTimeout(function() {
				mask.close();
			}, 500);

		}
	});

}


function initSetMaster() {
	getDeptMaster();
}

/**
 * 업체코드로 업체명 검색하여 데이터 set
 * 
 * @param 업체코드
 */
function getCustSch(gubn, value,s,e) {
	if($('.getComps').val() != ""){
		//loc코드 →comps코드 변환(기개발된 업체코드/품번 체크 function 사용으로 해당 로직 추가)
		var transComps= $(".getComps").val();
		if(transComps=="PE")  $("#getTrncCode").val("E1");
		else if(transComps=="PS") $("#getTrncCode").val("C1");
		}
		
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
					}
					if(gubn == "grid"){
						
						//var oldValue = s.getCellData(e.row,5,false);
						//if(oldValue == "" || oldValue == null || oldValue == undefined) oldValue = "0"; // dataType:'Number' 에는 공백 초기화가 안됨.
						//s.setCellData(e.row,e.col,oldValue);
						
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
function validation(item) {

	if (item.comps == null || wijmo.isEmpty(item.comps) || item.comps == "") {
		alert("수정이나 추가한 행의 [사업부]컬럼을 입력해야 됩니다.");
		return false;
	}
	if (item.pyvnd == null || wijmo.isEmpty(item.pyvnd) || item.pyvnd == "") {
		alert("수정이나 추가한 행의 [업체]컬럼을 입력 하세요");
		return false;
	} else {
		var flag = isCodeValid(item.pyvnd);
		if(!flag) {
			alert("숫자만 입력 가능 합니다.");
			return false;
		}
		var value = item.pyvnd;
		value = value.trim();
		var flag = true;
		itemMast.forEach(function(data, index) {
			var cusno = data.cusno;
			if (cusno != null) {
				cusno = cusno.trim();
			}
			if (value == cusno) {
				flag = false;
				return true;
			}
		});
		if (flag) {
			alert("수정이나 추가한 행의[업체]코드값이 없습니다.");
			return false;
		}
	}

	return true;
}

/**
	등록버튼
 */
function update() {

	/**
	 * 익스플로러에서 그리드외 다른영역으로 포커스가 빠졌을경우(클릭) flexGrid.rows 함수가 인식못하는 버그
	 * 아래처럼 포커스와 셀을 강제로 영역을 지정함.
	 */
	flexGrid.focus();
	flexGrid.select(new wijmo.grid.CellRange(0, 0, 0, 0), true);


	if (flexGrid.rows.length < 1 && cv.itemsRemoved.length == 0) {
		alert("등록할 내용이 없습니다.");
		return;
	}

	//validation	
	for (var i = 0; i < cv.itemsAdded.length; i++) {
		if (!validation(cv.itemsAdded[i])) {
			return false;
		}
	}

	for (var i = 0; i < cv.itemsEdited.length; i++) {
		if (!validation(cv.itemsEdited[i])) {
			return false;
		}
	}


	var stateMsg = RESULT_OK;
	var isModify = false;


	// Update : 업데이트 프로세스 
	 for ( var i = 0; i <cv.itemsEdited.length; i ++) {
		console.log(cv.itemsEdited[i]);

		$.ajax({
			method : "post",
			url : "/ajaxPaymentTypeBase/update.do",
			data : cv.itemsEdited[i],
			async: false,
			success : function(xhr) {
    	    	var data = JSON.parse(xhr);
            	
    	    	if(data.result != RESULT_OK) {
    				var rowNum = cv.itemsEdited[i].rownum;
					addErrorLineColor(flexGrid,rowNum);
    	    		if(data.errMsg == "LN_UPD_CHK1") stateMsg = LN_UPD_CHK1;
    				if(data.errMsg == "LN_UPD_CHK2") stateMsg = LN_UPD_CHK2;
    				if(data.errMsg == "LN_UPD_CHK3") stateMsg = LN_UPD_CHK3;
    				if(data.errMsg == "LN_UPD_CHK4") stateMsg = LN_UPD_CHK4;			
    			}
				if(data.result == RESULT_OK){
					//성공시 rownum이 있으면 라인색상 제거
					var rowNum = cv.itemsEdited[i].rownum;
					if(typeof rownum != "undefined" && rownum != "" && rownum != null){
						removeErrorLineColor(flexGrid,rowNum);
					}
				}
    	    },
            error : function() {
    			stateMsg = "error";
				var rowNum = cv.itemsEdited[i].rownum;
				addErrorLineColor(flexGrid,rowNum);	
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
			url : "/ajaxPaymentTypeBase/create.do",
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
					if(typeof rownum != "undefined" && rownum != "" && rownum != null){
						removeErrorLineColor(flexGrid,rowNum);
					}
				}     			
            },
            error : function() {
    			toastMsg("error");
				var rowNum = cv.itemsEdited[i].rownum;
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
			url : "/ajaxPaymentTypeBase/delete.do",
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
function downloadExcel() {

	var fileName = '납입구분관리.xlsx';
	transExcel(flexGrid, fileName);

}



/**
	버튼 이벤트 처리
 */
function handleEvent() {
	
	$('.getComps').on('change', function() {
		$(".getPyvnd").val("");
		$(".getCusnm").val("");
		cv.sourceCollection = [];
	});
	
	$('.getPyvnd').on('change', function() {
		$(".getCusnm").val("");
	});
	
	//등록폼 닫기버튼
	$("._closeBtn_").on("click", function() {
		var target = this.getAttribute("data-click-target");
		addBtnUiSet(this);
	});

	$('._custBtn_').on('click', function() {
		window.open("/ajaxCustomer/init.do","customerPop","width=550,height=600,scrollbars=yes,top=100,left=100");
	});

	//행 추가버튼
	$("._addBtn_").on("click", function() {
		var addRow = cv.addNew();
		addRow.comps = $(".getComps").val();
		cv.commitNew();
		flexGrid.select(new wijmo.grid.CellRange(flexGrid.rows.length + 1, 0), true);
	});

	// 그리드 row 삭제
	$("._delBtn").on("click", function() {
		var removeNum = flexGrid.selection.row;
		for(var i=removeNum;i<flexGrid.rows.length;i++){
			var rownum = flexGrid.getCellData(i,'rownum')
			if(typeof rownum != "undefined" && rownum != "" && rownum != null){
				flexGrid.setCellData(i,'rownum',rownum-1);
			}
		}
	});

}


/**
  그리드 초기화
 */
function gridInit() {
	//컬럼정의
	var columnsDefinition = [
		{ binding: 'comps', header: LN_CHK_COMPS, width: '*', align: 'center', dataType: 'String', maxLength: 3, dataMap:compsMap}, //사업부
		{ binding: 'pyvnd', header: LN_CHK_PYVND, width: '*', align: 'center', dataType: 'String', maxLength: 4 }, //업체코드
		{ binding: 'cusnm', header: LN_CHK_CUSNM, width: '*', align: 'center', dataType: 'String', isReadOnly: true }, //업체명
		{ binding: 'oldPyvnd', visible: false },
		{binding:'rownum',visible:false}	

	];
	//컬럼 초기화
	flexGrid.initialize({
		columns: columnsDefinition
	});

}

function isCodeValid(d){
	var re = /^[0-9+]*$/;
    return re.test(d);
}

function gridEvent() {

	//validation

	cv.getError = function(item, prop) {

		switch (prop) {
			case "comps":

				if (item.comps == null || wijmo.isEmpty(item.comps) || item.comps == "") {
					return "[사업부]를 입력해야 됩니다.";
				} 
				return null;

			case "pyvnd":

				if (item.pyvnd == null || wijmo.isEmpty(item.pyvnd) || item.pyvnd == "") {
					return "[업체]를 입력해야 됩니다.";
				} else {
					var flag = isCodeValid(item.pyvnd);
					if(!flag) {
						return "숫자만 입력 가능 합니다."
					}
					var flag = true;
					itemMast.forEach(function(data, index) {
						var cusno = data.cusno;
						var cusnm = data.cusnm;
						var trimCode = "";
						if (cusno != null) {
							trimCode = cusno.trim();
						}
						var pyvnd = item.pyvnd;
						var trimPyvnd = pyvnd.trim();
						if (trimPyvnd == trimCode) {
							item.cusnm = cusnm;
							flag = false;
							return false;
						}
					});
					if (flag) {
						item.locNm = "";
						return "해당하는[업체]가 없습니다."
					}
				}
				return null;
		}


		return null;
	}
	
	/**
	 * 수정할경우 rownum 넣어주는 이벤트
	 * 기존에 cellEditEnded 이벤트에 넣어주니 같은값으로 변경될때도 rownum이 들어가는 오류와 
  	 * 수정을 안하고 input박스만 생성되는 경우도 rownum이 찍히는 버그가 발생하여 cellEditEnding 이벤트로 변경함. 
	 */
	flexGrid.cellEditEnding.addHandler(function(s,e){
		
		var oldVal = s.getCellData(e.row,e.col);
		if(typeof s.activeEditor != "undefined" && s.activeEditor != "" && s.activeEditor != null){				
			var newVal = s.activeEditor.value;
	       	
			if(oldVal!=newVal){
				s.setCellData(e.row,"rownum",e.row,true);
			}
		}
		

	});

	//대문자 변경
	flexGrid.cellEditEnded.addHandler(function(s, e) {
		var value = s.getCellData(e.row, e.col, false);
		if (s.columns[e.col].dataType == wijmo.DataType.String) {
			s.setCellData(e.row, e.col, value.toUpperCase());
		}

	});

}


$(document.body).ready(function() {
	//셀렉트박스 미사용 사업부코드 제거
	$("#getComps option[value='H1']").remove();
	$("#getComps option[value='R1']").remove();	
	
	//그리드 공통js 호출 후에 나머지 함수 호출함.
	$.getScript('/js/sal/gridCommon.js').done(function() {

		commonGrid.init(flexGrid, cv); //그리드 공통부분
		initSetMaster();
		gridInit();  	//그리드 초기화
		gridEvent();	//그리드 이벤트
		handleEvent();	//프로그램 버튼 이벤트		
	
	if($('.getComps').val() != ""){
		//loc코드 →comps코드 변환(기개발된 업체코드/품번 체크 function 사용으로 해당 로직 추가)
		var transComps= $(".getComps").val();
		if(transComps=="PE")  $("#getTrncCode").val("E1");
		else if(transComps=="PS") $("#getTrncCode").val("C1");
		}
	
	});
});

