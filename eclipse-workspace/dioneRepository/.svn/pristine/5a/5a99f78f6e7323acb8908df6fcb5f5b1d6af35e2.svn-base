//code intellisense typescript 정의
///<reference path = "../../wijmo/controls/wijmo.d.ts"/>	
///<reference path = "../../wijmo/controls/wijmo.grid.d.ts"/>
///<reference path = "../../wijmo/controls/wijmo.input.d.ts"/>


// 컬랙션 뷰는 조회후에 그리드의 상태변경을 체크한다. 
var cv = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수

var itemMast = "";

var flexGrid = new wijmo.grid.FlexGrid('#wijmoGrid');	//그리드 전역변수
var zoomSize = 11;

/**
 * 등록시 오류검증
 */
function validation(item) {
	
	if (item.endccd == null || wijmo.isEmpty(item.endccd) || item.endccd == "") {
		alert("수정이나 추가한 행의 ["+LB_LAST_CSTMR_CODE+"]컬럼을 입력해야 됩니다.");
		return false;
	}
	
	if (item.comps == null || wijmo.isEmpty(item.comps) || item.comps == "") {
		alert("수정이나 추가한 행의 ["+LB_COMPS+"]를 선택해야 됩니다.");
		return false;
	}
	
	if (item.pyvnd == null || wijmo.isEmpty(item.pyvnd) || item.pyvnd == "") {
		alert("수정이나 추가한 행의 ["+LB_COMPS+"]를 입력해야 됩니다.");
		return false;
	}
	
	if (item.brnnm == null || wijmo.isEmpty(item.brnnm) || item.brnnm == "") {
		alert("수정이나 추가한 행의 ["+LB_LAST_CSTMR_SPOTNM+"]를 입력해야 됩니다.");
		return false;
	}
	
	return true;
}


function handleEvent() {

	//행 추가버튼
	$("._addBtn_").on("click", function() {
		var addRow = cv.addNew();
		addRow.rownum = flexGrid.rows.length -1;
		cv.commitNew();
		flexGrid.select(new wijmo.grid.CellRange(flexGrid.rows.length+1,0), true);

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
	
	//대문자전환
	$('#endccd').bind("keyup", function(){       
	    $(this).val($(this).val().toUpperCase());  
	});
	
	
}


/*
조회버튼
*/
function search() {
	
	//validation 체크기능으로 입력칸에 커서가 활성화 되어있을경우 조회시 오류가 발생함.
	//validation edit 기능을 비활성화 시키고 조회시킴.
	flexGrid.validateEdits = false;
	
	var url = "/ajaxFinlCustTypeBase/search.do";
	var params = {
		'endccd': $("#endccd").val(),
		'endcnm': $("#endcnm").val()
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
			url : "/ajaxFinlCustTypeBase/update.do",
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
			url : "/ajaxFinlCustTypeBase/create.do",
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
			url : "/ajaxFinlCustTypeBase/delete.do",
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

	var fileName = '최종고객구분관리.xlsx';

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

/**
	그리드 row height 자동크기조절
 */
function autoSizeRowsAsync(grid, rowIndex) {
	if (rowIndex != null) {
		grid.rows[rowIndex].height = null;
	} else {
		grid.rows.forEach(function(row) {
			row.height = null;
		});
	}
	setTimeout(function() {
		grid.onScrollPositionChanged();
	})
}



/** 
 * 확대
 */
function zoomIn() {

	if (zoomSize > 17) return;
	zoomSize++;

	var headerSize = zoomSize - 11;
	if (headerSize < 0) headerSize = headerSize * -1;

	$("#wijmoGrid").css("font-size", zoomSize + "pt");
	flexGrid.collectionView.refresh();
	flexGrid.columnHeaders.rows.defaultSize = flexGrid.columnHeaders.rows.defaultSize + (headerSize / 2); 	// 열 헤더 영역에 행의 높이 설정

}

/**
 * 축소
 */
function zoomOut() {
	if (zoomSize < 6) return;
	zoomSize--;

	var headerSize = zoomSize - 11;
	if (headerSize < 0) headerSize = headerSize * -1;

	$("#wijmoGrid").css("font-size", zoomSize + "pt");
	flexGrid.collectionView.refresh();
	flexGrid.columnHeaders.rows.defaultSize = flexGrid.columnHeaders.rows.defaultSize - (headerSize / 2); 	// 열 헤더 영역에 행의 높이 설정
}


function gridInit() {
	var comps = [
		{id:'PS',name:'구KA'},
		{id:'PE',name:'구KE'},
	];
	var compsMap = new wijmo.grid.DataMap(comps, 'id', 'name');

	var columnsDefinition = [
		{binding: 'endccd', header: '* ' + LB_LAST_CSTMR_CODE, width: '*', align: 'center', dataType: 'String',maxLength:4}, //최종고객코드
		{binding: 'endcnm', header: LB_LAST_CSTMR_NAME, width: '*', align: 'center', dataType: 'String', maxLength: 50,isReadOnly:true}, //최공고객명
		{binding: 'comps', header: '* ' + LB_COMPS, width: '*', align: 'center', dataType: 'String',dataMap:compsMap}, //사업부
		{binding: 'pyvnd', header: '* ' + LB_LAST_CSTMR_CSTMRCO, width: '*', align: 'center', dataType: 'String', maxLength: 4}, //업체크도
		{binding: 'pyvndnm', header: LB_LAST_CSTMR_CSTMRNM, width: '*', align: 'center', dataType: 'String',isReadOnly:true}, //고객명
		{binding: 'brnnm', header: '* ' + LB_LAST_CSTMR_SPOTNM, width: '*', align: 'center', dataType: 'String',maxLength:50}, //지점명
		{binding: 'desc', header:  LB_LAST_CUSTMR_DESC, width: '*', align: 'center', dataType: 'String',maxLength:50}, //설명
		{binding: 'oldComps', visible: false },
		{binding: 'oldPyvnd', visible: false },
		{binding: 'oldEndccd', visible: false },
		{binding:'rownum',visible:false}
	];
	//컬럼 초기화s
	flexGrid.initialize({
		columns: columnsDefinition
	});
	
	

}


function isDatetimeValid(d){
    var re = /[0-9]{4}(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])/;
    return re.test(d);
}

function gridEvent() {
	//validation
	cv.getError = function(item, prop) {
		switch (prop) {
							
			case "endccd":

				if (item.endccd == null || wijmo.isEmpty(item.endccd) || item.endccd == "") {
					return "["+LB_LAST_CSTMR_CODE+"]를 입력해야 됩니다.";
				}
				return null;

			case "comps":

				if (item.comps == null || wijmo.isEmpty(item.comps) || item.comps == "") {
					return "["+LB_COMPS+"]를 선택해야 됩니다.";
				}
				return null;
				
			case "pyvnd":

				if (item.pyvnd == null || wijmo.isEmpty(item.pyvnd) || item.pyvnd == "") {
					return "["+LB_COMPS+"]를 입력해야 됩니다.";
				}
				return null;	
			
			case "brnnm":

				if (item.brnnm == null || wijmo.isEmpty(item.brnnm) || item.brnnm == "") {
					return "["+LB_LAST_CSTMR_SPOTNM+"]을 입력해야 됩니다.";
				}
				return null;	
			
			case "desc":

				if (item.desc == null || wijmo.isEmpty(item.desc) || item.desc == "") {
					return "["+LB_LAST_CUSTMR_DESC+"]을 입력하세요.";
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
		var editKey = s.columns[e.col].binding;
		
		if (s.columns[e.col].dataType == wijmo.DataType.String) {
			value = value.trim();
			s.setCellData(e.row,e.col,value.toUpperCase());
		}
		
		if (editKey == "endccd") {
			var endcName = getEndCcd(value);
			if(endcName==""){
				alert('최종고객 코드가 존재하지 않습니다.');
				s.setCellData(e.row,e.col,"");
				s.setCellData(e.row,endcnm,"");
			}else{
				s.setCellData(e.row,'endcnm',getEndCcd(value));	
			}
			 
		}
		
		if (editKey == "pyvnd") {
			//사업부가 있을경우만 거래처확인 가능
			var compsCode=s.getCellData(e.row,'comps',false);
			
			if (compsCode == null || wijmo.isEmpty(compsCode) || compsCode == "") {
				
				alert('사업부를 선택후 업체코드를 입력하세요!');
				s.setCellData(e.row,e.col,"");
				return;
			}
			
			var custNm = getCustSch(compsCode,value);
			
			if(custNm==""){
				alert('업체코드가 존재하지 않습니다. 확인하세요');
				s.setCellData(e.row,e.col,"");
				s.setCellData(e.row,'pyvndnm',"");
			}else{
				s.setCellData(e.row,'pyvndnm',custNm)	
			}
			
		}
		
		
	});

}

/**
 * 최종고객코드
 */
function getEndCcd(value){
	
	var endcName = "";
	
	$.ajax({
		method : "post",
		url : "/ajaxFinlCustInfoBase/search.do",
		async: false,
		data : {
			'endccd': value.toUpperCase()
		},
		success : function(res) {
			var data = JSON.parse(res);			
			
			if(data.list.length > 0){
				endcName =  data.list[0].endcnm
			}
			
		},
		error : function() {
			//console.log("dataset.error");
		},
		completed : function() {
			//console.log("dataset.completed");
		}
	});
	
	return endcName;
}


/**
 * 업체코드로 업체명 검색하여 데이터 set
 * 
 * @param 업체코드
 */
function getCustSch(comps, value) {
	
	var cusName = "";
	
	$.ajax({
		method : "post",
		url : "/ajaxCustomer/search.do",
		async: false,
		data : {
			"getCusno" : value,
			"getComps" : comps
		},
		success : function(res) {
			var data = JSON.parse(res);			
		
			if(data.list.length > 0){
				cusName =  data.list[0].cusnm;
			}
			
		},
		error : function() {
			//console.log("dataset.error");
		},
		completed : function() {
			//console.log("dataset.completed");
		}
	});
	
	return cusName;
	
}




$(document.body).ready(function() {
	$.getScript('/js/sal/gridCommon.js').done(function() {
		commonGrid.init(flexGrid,cv); //그리드 공통부분
		gridInit();  	//그리드 초기화
		gridEvent();	//그리드 이벤트
		handleEvent();	//프로그램 버튼 이벤트
	});			
});
