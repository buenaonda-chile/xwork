// 컬랙션 뷰는 조회후에 그리드의 상태변경을 체크한다. 
var cv = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수


var flexGrid = new wijmo.grid.FlexGrid('#wijmoGrid');	//그리드 전역변수
var zoomSize = 11;
//var reprtse = [];
//var cmnitm = [];
/*
* 데이터 임의로 지정
*/
var comps = [
		{id:'E1',name:'마산'},
		{id:'C1',name:'창원'},
		{id:'S1',name:'화성'}
	];
var compsMap = new wijmo.grid.DataMap(comps, 'id', 'name');
	
/*var reprtse = [
		{id:'01',name:'주간보고'},
		{id:'02',name:'월간보고-주요제품별'},
		{id:'03',name:'월간보고-창원'},
		{id:'04',name:'월간보고-화성마산'}
	];*/
//var reprtseMap = new wijmo.grid.DataMap(reprtse, 'id', 'id');
	
/*var cmnitm = [
		{id:'aa',name:'코멘트1'},
		{id:'bb',name:'코멘트2'},
	];*/
//var cmnitmMap = new wijmo.grid.DataMap(cmnitm, 'id', 'name');


/**
 * 보고서, 코멘트 취득
 */
function getCodMaster() {
	if ($('#getComps').val() != "") {
		$.ajax({
			method: "post",
			url: "/ajaxSalplanBase/searchInfoMaster.do",
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
}

function initSetMaster(){
	getCodMaster();
	clearGrid();
}

function clearGrid() {
	cv.sourceCollection=[];
}

/*function makeDataMap(item){
	itemMast.forEach (function (data, index) {
		var sub = data.sub;
		if(sub == 'REPR'){
			reprtse.push({code: data.code, name: data.name});
			console.log(data.code+"/"+data.name);
		}
		if(sub == 'COMM') {
			cmnitm.push({code: data.code, name: data.name});
			console.log(data.code+"/"+data.name);
		//cmnitmMap = new wijmo.grid.DataMap(cmnitm, 'data.code', 'data.name');
		}
		reprtseMap = new wijmo.grid.DataMap(reprtse, 'reprtse.code', 'reprtse.code');
	});	
	console.log("확인"+reprtse);
}*/

/**
 조회버튼
 */
function search() {
	initSetMaster();

	if (!$(".getComps").val()) {
		toastMsg(LN_SELECT_COMPS);
		return false;
	}

	var url = '/ajaxSalAnlysComent/search.do';
	var params = {
		'getComps': $(".getComps").val(),
		'getReprtNm': $(".getReprtNm").val(),
		'getRepym' : $(".getDumcb").val().replace(/-/gi, "")
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

/**
 * 등록시 오류검증
 */
function validation(item) {

	if (item.repym == null || wijmo.isEmpty(item.repym) || item.repym == "") {
		alert("수정이나 추가한 행의 [년월]컬럼을 입력 하세요");
		return false;
	}
	if (item.comps == null || wijmo.isEmpty(item.comps) || item.comps == "") {
		alert("수정이나 추가한 행의 [공장]컬럼을 입력 하세요");
		return false;
	}
	if (item.reprtse == null || wijmo.isEmpty(item.reprtse) || item.reprtse == "") {
		alert("수정이나 추가한 행의 [보고서종류]컬럼을 입력 하세요");
		return false;
	}else{
		var value = item.reprtse;
		value = value.trim();
		var flag = true;
		itemMast.forEach (function (data, index) {
			var sub = data.sub;
			if(sub == 'REPR'){
				console.log("start");
			var code = data.code;
			if(code != null) {
				code = code.trim();
			}
			if(value == code) {
				flag = false;
				return true;
			}
			}
		});	
		if(flag){
			item.reprtNm = "";
			alert("해당하는[보고서명이 없습니다.]");
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
			url : "/ajaxSalAnlysComent/update.do",
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
			url : "/ajaxSalAnlysComent/create.do",
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
			url : "/ajaxSalAnlysComent/delete.do",
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


	//등록폼 닫기버튼
	$("._closeBtn_").on("click", function() {
		var target = this.getAttribute("data-click-target");
		addBtnUiSet(this);
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
		cv.remove(cv.currentItem);
	});

}


/**
  그리드 초기화
 */
function gridInit() {
	/*function makeDataMap(item){
	itemMast.forEach (function (data, index) {
		var sub = data.sub;
		if(sub == 'REPR'){
			reprtse.push({code: data.code, name: data.name});
			console.log(data.code+"/"+data.name);
		var reprtseMap = new wijmo.grid.DataMap(reprtse, 'data.code', 'data.code');
		}
		if(sub == 'COMM') {
			cmnitm.push({code: data.code, name: data.name});
			console.log(data.code+"/"+data.name);
		var cmnitmMap = new wijmo.grid.DataMap(cmnitm, 'data.code', 'data.name');
		}
	});	
	console.log("확인"+reprtse);
}*/
	/*var reprtseMap = new wijmo.grid.DataMap(reprtse, 'data.code', 'data.code');
	var cmnitmMap = new wijmo.grid.DataMap(cmnitm, 'data.code', 'data.name');*/
	
	//컬럼정의
	var columnsDefinition = [
		{ binding: 'repym', header: LN_CHK_REPYM, width: '*', align: 'center', dataType: 'String', maxLength: 6 }, //년월
		{ binding: 'comps', header: LN_CHK_COMPS, width: '*', align: 'center', dataType: 'String', dataMap: compsMap}, //공장
		{ binding: 'reprtse', header: LN_CHK_REPRTSE, width: '*', align: 'center', dataType: 'String'/*, dataMap: reprtseMap*/}, //보고서종류
		{ binding: 'reprtNm', header: LN_CHK_REPRTNM, width: '*', align: 'center', dataType: 'String', isReadOnly: true }, //보고서명
		{ binding: 'cmnitm', header: LN_CHK_CMNITM, width: '*', align: 'center', dataType: 'String'/*, dataMap: cmnitmMap*/}, //코멘트항목
		{ binding: 'cmncn', header: LN_CHK_CMNCN, width: '*', align: 'center', dataType: 'String', maxLength: 1000 }, //코멘트내용
		{ binding: 'oldComps', visible: false },
		{ binding: 'oldRepym', visible: false },
		{ binding: 'oldReprtse', visible: false },
		{ binding: 'oldCmnitm', visible: false },
		{binding:'rownum',visible:false}	

	];
	//컬럼 초기화
	flexGrid.initialize({
		columns: columnsDefinition
	});

}

function isDatetimeValid(d){
    var re = /[0-9]{4}(0[1-9]|1[0-2])/;
    return re.test(d);
}

function gridEvent() {

	//validation

	cv.getError = function(item, prop) {

		switch (prop) {
			case "repym":

				if (item.repym == null || wijmo.isEmpty(item.repym) || item.repym == "") {
					return "[년월]를 입력해야 됩니다.";
				}else{
					var flag = isDatetimeValid(item.repym);
				}
				if(!flag) {
					return "날짜는 yyyymm 형식으로 입력해주세요.";
				}
				return null;
				
			case "comps":

				if (item.comps == null || wijmo.isEmpty(item.comps) || item.comps == "") {
					return "[공장]을 입력해야 됩니다.";
				}
				return null;

			case "reprtse":

				if (item.reprtse == null || wijmo.isEmpty(item.reprtse) || item.reprtse == "") {
					return "[보고서종류]를 선택해야 됩니다.";
				} else {
					var flag = true;
						itemMast.forEach (function (data, index) {		  		
							var sub  = data.sub;//REPR
							if(sub == "REPR"){
								var code = data.code; //RE4
								var name = data.name;	//월간-화성마산
								var trimCode = "";
								if(code != null) {
									trimCode = code.trim();
								}
								var reprtse = item.reprtse;
								var trimReprtse = reprtse.trim();
								if(trimReprtse == trimCode) {
									item.reprtNm = name;
									flag = false;
									return false;
								}
							}
						});	
					if (flag) {
						item.reprtNm = "";
						return "해당하는[보고서명]이 없습니다."
					}
				}
				return null;
			
			case "cmnitm":

				if (item.cmnitm == null || wijmo.isEmpty(item.cmnitm) || item.cmnitm == "") {
					return "[코멘트 항목]을 선택해야 됩니다.";
				}
				return null;
			
			case "cmncn":

				if (item.cmncn == null || wijmo.isEmpty(item.cmncn) || item.cmncn == "") {
					return "[코멘트내용]을 입력해야 됩니다.";
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

function calendar(){
	var chk_calendar = new ax5.ui.calendar({
        target: document.getElementById("chk_calendar"),
        control: {
            left: '<i class="fa fa-chevron-left"></i>',
            yearTmpl: '%s',
            monthTmpl: '%s',
            right: '<i class="fa fa-chevron-right"></i>',
            yearFirst: true
        },
        displayDate: (new Date()),
		mode: "month",
    	selectMode: "month",
		dateFormat: 'yyyy-MM', // yyyy-mm-dd 
        dimensions: {
            height: 250,
            controlHeight: 40,
            itemPadding: 1
        },
        lang: {
        	/*yearTmpl: "%s년",*/
            /*months: ['일월', '이월', '삼월', '사월', '오월', '육월', '칠월', '팔월', '구월', '시월', '십일월', '십이월'],*/
        	yearTmpl: YEAR_FORMAT,
        	months: MONTH
        },
        onClick: function () {
            $(this.target).css('display', 'none');
			var date = JSON.stringify(chk_calendar.getSelection());
            $(this.target).prev().val(date.substring(2,9));
        },
        onStateChanged: function () {
            //console.log(this);
        }
    });
	
	$('.log_board .dropdown').on('click', function(e){
		$($(e.target).next('.dropdown-menu')).css('display', 'block');
	});
}

$(document.body).ready(function() {

	//그리드 공통js 호출 후에 나머지 함수 호출함.
	$.getScript('/js/sal/gridCommon.js').done(function() {
		initSetMaster();
		//makeDataMap();
		commonGrid.init(flexGrid, cv); //그리드 공통부분
		gridInit();  	//그리드 초기화
		gridEvent();	//그리드 이벤트
		handleEvent();	//프로그램 버튼 이벤트		
		calendar(); //캘린더
	});

});

