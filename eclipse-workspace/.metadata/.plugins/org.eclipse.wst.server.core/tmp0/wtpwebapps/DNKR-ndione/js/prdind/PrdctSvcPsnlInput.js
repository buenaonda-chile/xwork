// 컬랙션 뷰는 조회후에 그리드의 상태변경을 체크한다. 
var cv = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수

var itemMast = "";

var flexGrid = new wijmo.grid.FlexGrid('#wijmoGrid');	//그리드 전역변수
var zoomSize = 11;

/**
 * 더존 부서정보 취득
 */
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

function initSetMaster(){
	getDeptMaster();
	clearGrid();
}

function clearGrid() {
	cv.sourceCollection=[];
}

/**
 * 등록시 오류검증
 */
function validation(item) {

	if (item.servcNo == null || wijmo.isEmpty(item.servcNo) || item.servcNo == "") {
		toastMsg("수정이나 추가한 행의 [용역번호]컬럼을 입력해야 됩니다.");
		return false;
	}

	if (item.locCode == null || wijmo.isEmpty(item.locCode) || item.locCode == "") {
		toastMsg("수정이나 추가한 행의 [작업부서(반)코드]컬럼을 입력 하세요");
		return false;
	}else{
		var value = item.locCode;
		value = value.trim();
		var flag = true;
		itemMast.forEach (function (data, index) {
			var code = data.code;
			if(code != null) {
				code = code.trim();
			}
			if(value == code) {
				flag = false;
				return true;
			}
		});	
		if(flag) {
			toastMsg("수정이나 추가한 행의[부서(반)]코드값이 없습니다.");
			return false;
		}					
	}

	if(item.startDe==null || wijmo.isEmpty(item.startDe) || item.startDe ==""){
		toastMsg("수정이나 추가한 행의 [시작일]컬럼을 입력 하세요");
		return false;
	}else{
		var flag = isDatetimeValid(item.startDe);
		if(!flag) {
			toastMsg("시작일은 [yyyymmdd] 형식으로 입력해주세요.");
			return false;
		}		
	}
	
	if(item.endDe==null || wijmo.isEmpty(item.endDe) || item.endDe ==""){
		toastMsg("수정이나 추가한 행의 [종료일]컬럼을 입력 하세요");
		return false;
	}else{
		var flag = isDatetimeValid(item.endDe);
		if(!flag) {
			toastMsg("종료일은 [yyyymmdd] 형식으로 입력해주세요.");
			return false;
		}		
	}	
		
	if(item.startDe!=null && !wijmo.isEmpty(item.startDe) && item.startDe != "" && item.endDe!=null && !wijmo.isEmpty(item.endDe) && item.endDe != ""){
		var startDe = item.startDe.replace(/-/g,"");
		var endDe = item.endDe.replace(/-/g,"");		
		var itemStartDe = Number(startDe);
		var itemEndDe = Number(endDe);
		if(itemEndDe < itemStartDe) {
			toastMsg("시작일이 종료일 보다 큽니다.");
			return false;			
		}
	}

	if (item.nm == null || wijmo.isEmpty(item.nm) || item.nm == "") {
		toastMsg("수정이나 추가한 행의 [성명]컬럼을 입력 하세요");
		return false;
	}

	return true;
}


function handleEvent() {

	//등록폼 닫기버튼
	$("._closeBtn_").on("click", function() {
		var target = this.getAttribute("data-click-target");
		addBtnUiSet(this);
	});

	$('._custBtn_').on('click', function() {
		window.open("/ajaxCustomer/init.do", "customerPop", "width=550,height=600,scrollbars=yes,top=100,left=100");
	});

	//행 추가버튼
	$("._addBtn_").on("click", function() {
		var addRow = cv.addNew();
		addRow.rownum = flexGrid.rows.length -1;		
		addRow.clsCode = $(".getComps").val();
		cv.commitNew();	
		flexGrid.select(new wijmo.grid.CellRange(flexGrid.rows.length+1,0), true);
	});

	// 그리드 row 삭제
	$("._delBtn").on("click", function() {
		var removeNum = flexGrid.selection.row;
		for(var i=removeNum;i<flexGrid.rows.length;i++){
			var rowNum = flexGrid.getCellData(i,'rownum')
			if(typeof rowNum != "undefined" && rowNum != "" && rowNum != null){		
				flexGrid.setCellData(i,'rownum',rowNum-1);
			}
		}		
		cv.remove(cv.currentItem);
	});
}

/*
조회버튼
*/
function search() {
	flexGrid.validateEdits = false;		
	if (!$(".getComps").val()) {
		//		toastMsg(LN_SELECT_COMPS);
		return false;
	}
	var url = "/ajaxPrdctSvcPsnlInput/search.do";
	var params = {
		'getComps': $("#getComps").val(),
		'servcNo': $("#servcNo").val(),
		'locCode': $("#locCode").val(),
		'startDe': $("#startDe").val()
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

/*
등록버튼
*/
function update() {
	/**
	 * 익스플로러에서 그리드외 다른영역으로 포커스가 빠졌을경우(클릭) 컬랙션뷰에서 변경된 내용을 인식하지 못하는 버그발생
	 * 아래처럼 포커스와 셀을 강제로 영역을 지정함.
	 */
	flexGrid.focus();
	flexGrid.select(new wijmo.grid.CellRange(0, 0, 0, 0, 0, 0, 0), true);


	/*if (flexGrid.rows.length < 1) {
		toastMsg("등록할 내용이 없습니다.");
		return;
	}*/

	//validation	
	for (var i = 0; i < cv.itemsAdded.length; i++) {
		if (!validation(cv.itemsAdded[i])) {
			return false;
		}
		isModify = true;
	}

	for (var i = 0; i < cv.itemsEdited.length; i++) {
		if (!validation(cv.itemsEdited[i])) {
			return false;
		}
		isModify = true;
	}


	var stateMsg = RESULT_OK;
	var isModify = false;

	var stateMsg=RESULT_OK;
	var isModify = false;
	// Update : 업데이트 프로세스 
    for ( var i = 0; i <cv.itemsEdited.length; i ++) {
		console.log(cv.itemsEdited[i]);

		$.ajax({
			method : "post",
			url : "/ajaxPrdctSvcPsnlInput/update.do",
			data : cv.itemsEdited[i],
			async: false,
			success : function(xhr) {
    	    	var data = JSON.parse(xhr);
            	
    	    	if(data.result != RESULT_OK) {
					var rowNum = cv.itemsEdited[i].rownum;
					if(typeof rowNum != "undefined" && rowNum != "" && rowNum != null){						
						addErrorLineColor(flexGrid,rowNum);
					}
    	    		if(data.errMsg == "LN_UPD_CHK1") stateMsg = LN_UPD_CHK1;
    				if(data.errMsg == "LN_UPD_CHK2") stateMsg = LN_UPD_CHK2;
    				if(data.errMsg == "LN_UPD_CHK3") stateMsg = LN_UPD_CHK3;
    				if(data.errMsg == "LN_UPD_CHK4") stateMsg = LN_UPD_CHK4;			
    			} 
				if(data.result == RESULT_OK){
					//성공시 rownum이 있으면 라인색상 제거
					var rowNum = cv.itemsEdited[i].rownum;
					if(typeof rowNum != "undefined" && rowNum != "" && rowNum != null){		
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
			url : "/ajaxPrdctSvcPsnlInput/create.do",
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
					if(typeof rowNum != "undefined" && rowNum != "" && rowNum != null){		
						removeErrorLineColor(flexGrid,rowNum);
					}
				}				
				  			
            },
            error : function() {
				stateMsg = "error";
				var rowNum = cv.itemsAdded[i].rownum;
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
			url : "/ajaxPrdctSvcPsnlInput/delete.do",
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

function getToday(){
	var date = new Date();
	return date.getFullYear() + "-" + ("0"+(date.getMonth()+1)).slice(-2) + "-" + ("0"+date.getDate()).slice(-2);
}

/**
 * 엑셀 다운로드
 */
function downloadExcel() {

	var fileName = "생산용역인원마스타.xlsx_"+getToday()+".xlsx";

	wijmo.grid.xlsx.FlexGridXlsxConverter.saveAsync(flexGrid,
		{ includeColumnHeaders: true },
		fileName,
		function(base64) {
			// user can access the base64 string in this callback.
			document.getElementById('importFile').href = 'data:application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;' + 'base64,' + base64;
			//console.log(base64);
		},
		function(reason) {
			//User can catch the failure reason in this callback.
			console.log('The reason of save failure is ' + reason);
		}
	);
}

function gridInit() {
	var columnsDefinition = [
		{binding:'rownum',visible:false},	
		{binding:'oldServcNo',visible:false},					
		{binding: 'clsCode',visible:false},
		{binding: 'servcNo', header: '* ' + LB_SERVC_NO, width: '*', align: 'center', dataType: 'String'}, //용역번호
		{binding: 'nm', header: '* ' + LB_NM, width: '*', align: 'center', dataType: 'String', maxLength: 30 }, //성명
		{
			header: '* 작업부서(반)', align: 'center', columns: [
				{ binding: 'locCode', header: '* ' + LB_LOC_CODE, width: '*', align: 'center', dataType: 'String', maxLength: 4}, //부서코드
				{ binding: 'locNm', header: '* ' + LB_LOC_NM, width: '*', align: 'center', dataType: 'String', isReadOnly: true }, //부서명
			]
		},
		{binding: 'startDe', header: '* ' + LB_START_DE, width: '*', align: 'center', dataType: 'String', maxLength: 10}, //시작일자
		{binding: 'endDe', header: '* ' + LB_END_DE, width: '*', align: 'center', dataType: 'String',maxLength: 10 }, //종료일자
		{binding: 'refrn', header: LB_REFRN, width: '*', align: 'center', dataType: 'String', maxLength: 50 } //참조
	];
	//컬럼 초기화
	flexGrid.initialize({
		columns: columnsDefinition
	});
}

function isDatetimeValid(data){
	var str = data.replace(/-/g,"");	
    var re = /[0-9]{4}(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])/;
	if(re.test(str)) {
		var intStr = Number(str);
		if(intStr > 0) {
			return true;
		}else {
			return false;
		}
	}else {
		return false;
	}
}

function getChangeDate(data){
	var strVal = "";
	if(!isDatetimeValid(data)) {
		return "";
	}else {
		var index = data.indexOf('-');
		if(index > 0) {
			strVal = data;
		}else {
			
			strVal = data.substring(0,4)+"-"+data.substring(4,6)+"-"+data.substring(6,8);
		}
	}
   	return strVal;
}

function isCodeValid(d){
	var re = /^[A-Za-z0-9+]*$/;
    return re.test(d);
}

function gridEvent() {
	//validation
	cv.getError = function(item, prop) {
		if(item != "undefined" || item != "" || item != null){				
			switch (prop) {
				case "servcNo":
					var flag = false;
					if (item.servcNo == null || wijmo.isEmpty(item.servcNo) || item.servcNo == "") {
						return "[용역번호]를 입력해야 됩니다.";
					}else{
						var flag = isCodeValid(item.servcNo);
						if(!flag) {
							item.servcNo = "";						
						}							
					}
					return null;
	
				case "locCode":
					var flag = false;
					if (item.locCode == null || wijmo.isEmpty(item.locCode) || item.locCode == "") {
						return "[부서(반)코드]를 입력 하세요.";
					}else{
						var flag = true;
						itemMast.forEach (function (data, index) {			  		
							var code = data.code;
							var name = data.name;	
							var trimCode = "";	
							if(code != null) {
								trimCode = code.trim();
							}
							var locCode = item.locCode;
							var trimLocCode = locCode.trim();
							if(trimLocCode == trimCode) {
								item.locNm = name;
								flag = false;
								return false;
							}
						});	
						if(flag) {
							item.locNm = "";
							return "해당하는[부서(반)코드]가 없습니다."
						}
					}
					return null;
	
				case "startDe":
					var flag = false;
					if(item.startDe==null || wijmo.isEmpty(item.startDe) || item.startDe == "" ){
						return "[시작일]]를 입력 하세요.";
					}else{
						var flag = isDatetimeValid(item.startDe);
					}
					if(!flag) {
						return "날짜는 yyyymmdd 형식으로 입력해주세요.";
					}
	
					if(item.endDe!=null && !wijmo.isEmpty(item.endDe) && item.endDe != "" ){
						var iStartDe = item.startDe.replace(/-/g,"");						
						var iendDe = item.endDe.replace(/-/g,"");							
	
						var itemStartDe = Number(iStartDe);
						var itemEndDe = Number(iendDe);
						
						if(itemEndDe < itemStartDe) {
							return "시작일이 종료일 보다 큽니다.";
						}
					}
					return null;
					
				case "endDe":
					var flag = false;
					if(item.endDe==null || wijmo.isEmpty(item.endDe) || item.endDe == "" ){
						item.endDe = "9999-12-31";
					}else{
						var flag = isDatetimeValid(item.endDe);
					}
					if(!flag) {
						return "날짜는 yyyymmdd 형식으로 입력해주세요.";
					}
					
					if(item.startDe!=null && !wijmo.isEmpty(item.startDe) && item.startDe != "" ){
						var iStartDe = item.startDe.replace(/-/g,"");						
						var iendDe = item.endDe.replace(/-/g,"");							
	
						var itemStartDe = Number(iStartDe);
						var itemEndDe = Number(iendDe);
						
						if(itemEndDe < itemStartDe) {
							return "시작일이 종료일 보다 큽니다.";
						}
					}				
					return null;
	
				case "nm":
					var flag = false;
					if (item.nm == null || wijmo.isEmpty(item.nm) || item.nm == "") {
						return "[성명]을 입력 하세요.";
					}
					return null;
	
			}
		}
		return null;
	}

	flexGrid.pastedCell.addHandler(function(s,e){
		s.setCellData(e.row,"rownum",e.row,true);
	});
	
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
			value = value.trim();
			s.setCellData(e.row,e.col,value);
		}
		//Date Validateion
		if(e.col == 6 || e.col == 7 ) {
			var flag = true;
			if(value==null || wijmo.isEmpty(value) || value == "" ){
			}else{
				var flag = true;
				var flag = isDatetimeValid(value);
				if(flag) {
					var strVal = getChangeDate(value);
					s.setCellData(e.row,e.col,strVal); //시간
					return false;			
				}else{
					toastMsg("일자는 [yyyymmdd] 형식으로 입력해주세요.")	
					return false;	
				}				
		
			}
		}		
		
	});

}


$(document.body).ready(function() {
	$.getScript('/js/sal/gridCommon.js').done(function() {
		commonGrid.init(flexGrid,cv); //그리드 공통부분	
		getDeptMaster();
		gridInit();  	//그리드 초기화
		gridEvent();	//그리드 이벤트
		handleEvent();	//프로그램 버튼 이벤트
	});			
});
