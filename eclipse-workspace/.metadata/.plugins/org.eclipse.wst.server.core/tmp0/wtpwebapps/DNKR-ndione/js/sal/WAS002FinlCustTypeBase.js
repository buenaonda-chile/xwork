//code intellisense typescript 정의
///<reference path = "../../wijmo/controls/wijmo.d.ts"/>	
///<reference path = "../../wijmo/controls/wijmo.grid.d.ts"/>
///<reference path = "../../wijmo/controls/wijmo.input.d.ts"/>


// 컬랙션 뷰는 조회후에 그리드의 상태변경을 체크한다. 
var cv = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수

var flexGrid = new wijmo.grid.FlexGrid('#wijmoGrid');	//그리드 전역변수
var zoomSize = 11;

//사업부-업체-업체명 list 변수
var e1CustSch ="";
var s1CustSch ="";

/**
 * 등록시 오류검증
 */
function validation(item) {
	
	if (item.endccd == null || wijmo.isEmpty(item.endccd) || item.endccd == "") {
		toastMsg("["+LN_INS_CHK3+"]");
		return false;
	}
	
	if (item.comps == null || wijmo.isEmpty(item.comps) || item.comps == "") {
		toastMsg("["+LN_INS_CHK4+"]");
		return false;
	}
	
	if (item.pyvnd == null || wijmo.isEmpty(item.pyvnd) || item.pyvnd == "") {
		toastMsg("["+LN_INS_CHK5+"]");
		return false;
	} else {
			var value = item.pyvnd;
			value = value.trim();
			var flag = true;
				if(item.comps == 'PS'){
					s1CustSch.forEach(function (data, index){
					var custNo = data.cusno;
					var custNm = data.cusnm;
					var trimCode = "";
					if(custNo != null){
						trimCode = custNo.trim();
					}
					var pyvnd = item.pyvnd;
					var trimPyvnd = pyvnd.trim();
					if(trimPyvnd == trimCode){
						item.pyvndnm = custNm;
						flag = false;
						return false;
					}
				});
				}
				if(item.comps == 'PE'){
					e1CustSch.forEach(function (data, index){
					var custNo = data.cusno;
					var custNm = data.cusnm;
					var trimCode = "";
					if(custNo != null){
						trimCode = custNo.trim();
					}
					var pyvnd = item.pyvnd;
					var trimPyvnd = pyvnd.trim();
					if(trimPyvnd == trimCode){
						item.pyvndnm = custNm;
						flag = false;
						return false;
						}
					});
					}
					if(flag){
						item.pyvnd = "";
						item.pyvndnm = "";
						return toastMsg("["+LN_INS_CHK7+"]");
					}
				}
	
	if (item.brnnm == null || wijmo.isEmpty(item.brnnm) || item.brnnm == "") {
		toastMsg("["+LN_INS_CHK6+"]");
		return false;
	}
	
	return true;
}


function handleEvent() {
	
	$('.getEndccd').on('change', function() {
		$(".getEndcnm").val("");
		cv.sourceCollection = [];
	});
	
	
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
		'endccd': $("#getEndccd").val(),
		'endcnm': $("#getEndcnm").val()
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
		toastMsg(LN_ERROR_ALT);
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
		//console.log(cv.itemsEdited[i]);

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
    	//console.debug(cv.itemsAdded[i]);
		
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
    	//console.debug(cv.itemsRemoved[i]);
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
		toastMsg("["+LN_ERROR_ALT+"]");
	}
 
}

/**
 * 엑셀 다운로드
 */
function downloadExcel() {

	var fileName = LN_FILE_NM;

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
	
	//최종고객코드 콤보박스 (최종고객코드관리화면에서 등록한 데이터 선택가능)
	var endCcdList = getEndCcdList();
	var endccdMap = new wijmo.grid.DataMap(endCcdList, 'endccd', 'endccd');

	// 사업부 콤보박스
	var comps = [
		{id:'PS',name:LN_OPT_3}, //구KA
		{id:'PE',name:LN_OPT_2}, //구KE
	];
	var compsMap = new wijmo.grid.DataMap(comps, 'id', 'name');
	var columnsDefinition = [
		{binding: 'endccd', header: '* ' + LB_LAST_CSTMR_CODE, width: '*', align: 'center', dataType: 'String', dataMap:endccdMap,isRequired:false}, //최종고객코드
		{binding: 'endcnm', header: LB_LAST_CSTMR_NAME, width: '*', align: 'center', dataType: 'String', maxLength: 50,isReadOnly:true}, //최공고객명
		{binding: 'comps', header: '* ' + LB_COMPS, width: '*', align: 'center', dataType: 'String',dataMap:compsMap,isRequired:false}, //사업부
		{binding: 'pyvnd', header: '* ' + LB_LAST_CSTMR_CSTMRCO, width: '*', align: 'center', dataType: 'String', maxLength: 4,isRequired:false}, //업체크도
		{binding: 'pyvndnm', header: LB_LAST_CSTMR_CSTMRNM, width: '*', align: 'center', dataType: 'String',isReadOnly:true}, //고객명
		{binding: 'brnnm', header: '* ' + LB_LAST_CSTMR_SPOTNM, width: '*', align: 'center', dataType: 'String',maxLength:50,isRequired:false}, //지점명
		{binding: 'desc', header:  LB_LAST_CUSTMR_DESC, width: '*', align: 'center', dataType: 'String',maxLength:50,isRequired:false}, //설명
		{binding: 'oldComps', visible: false },
		{binding: 'oldPyvnd', visible: false },
		{binding: 'oldEndccd', visible: false },
		{binding:'rownum',visible:false}
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

function gridEvent() {
	//validation
	
	cv.getError = function(item, prop) {
		switch (prop) {
							
			case "endccd":

				if (item.endccd == null || wijmo.isEmpty(item.endccd) || item.endccd == "") {
					return "["+LN_GRID_CHK1+"]";
				}
				return null;

			case "comps":

				if (item.comps == null || wijmo.isEmpty(item.comps) || item.comps == "") {
					return "["+LN_GRID_CHK2+"]";
				}
				return null;
				
			case "pyvnd":

				if (item.pyvnd == null || wijmo.isEmpty(item.pyvnd) || item.pyvnd == "") {
					return "["+LN_GRID_CHK3+"]";
				} else {
					var value = item.pyvnd;
					value = value.trim();
					var flag = true;
					if(item.comps == 'PS'){
						s1CustSch.forEach(function (data, index){
						var custNo = data.cusno;
						var custNm = data.cusnm;
						var trimCode = "";
						if(custNo != null){
							trimCode = custNo.trim();
						}
						var pyvnd = item.pyvnd;
						var trimPyvnd = pyvnd.trim();
						if(trimPyvnd == trimCode){
							item.pyvndnm = custNm;
							flag = false;
							return false;
						}
					});
					}
					if(item.comps == 'PE'){
						e1CustSch.forEach(function (data, index){
						var custNo = data.cusno;
						var custNm = data.cusnm;
						var trimCode = "";
						if(custNo != null){
							trimCode = custNo.trim();
						}
						var pyvnd = item.pyvnd;
						var trimPyvnd = pyvnd.trim();
						if(trimPyvnd == trimCode){
							item.pyvndnm = custNm;
							flag = false;
							return false;
						}
					});
					}
					if(flag){
						item.pyvnd = "";
						item.pyvndnm = "";
						return toastMsg("["+LN_INS_CHK7+"]");
					}
				}
				return null;
			
			case "brnnm":

				if (item.brnnm == null || wijmo.isEmpty(item.brnnm) || item.brnnm == "") {
					return "["+LN_GRID_CHK4+"]";
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

	/**
    * 드롭다운 edit 기능비활성화  => 선택만 가능 
    */

   flexGrid.hostElement.addEventListener("keydown", function(e) {
      var dropDown = wijmo.closestClass(e.target, 'wj-hasdropdown');
      if (dropDown) {
         e.preventDefault();
      }
   }, true);

   flexGrid.beginningEdit.addHandler(function(s, e) {
      if (e.data && e.data.type == 'keypress' && s.columns[e.col].dataMap) {
         e.cancel = true;
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
				alert("["+LN_ERROR_ALT2+"]");
				s.setCellData(e.row,e.col,"");
				s.setCellData(e.row,endcnm,"");
			}else{
				s.setCellData(e.row,'endcnm',getEndCcd(value));	
			}
			 
		}
		
		// 사업부 변경시 업체코드,고객명 재조회
 		if (editKey == "comps") {
			s.setCellData(e.row,'pyvnd',"");
			s.setCellData(e.row,'pyvndnm',"");
		}
		
		/*if (editKey == "pyvnd") {
			getCustSch(comps, value);
		}*/
		
		
	});
	
}

/**
 * 최종고객코드 리스트
 */
function getEndCcdList(){
	
	var endCcdList ="";
	//validation 체크기능으로 입력칸에 커서가 활성화 되어있을경우 조회시 오류가 발생함.
	//validation edit 기능을 비활성화 시키고 조회시킴.
	flexGrid.validateEdits = false;
	
	var url = "/ajaxFinlCustInfoBase/search.do";
	var params = {
	};
	mask.open();
	$.ajax({
		method: "post",
		url: url,
		data: params,
		async:false,
		success: function(res) {
			var data = JSON.parse(res).list;
			//cv.sourceCollection = data;
			endCcdList =  data;
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
	return endCcdList;
}


/**
 * 최종고객코드명 취득
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
			if(comps == 'E1'){
				e1CustSch = JSON.parse(res).list;
			} else {
				s1CustSch = JSON.parse(res).list;
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

/*
\	업체명 list
*/
function getCusName(){
	getCustSch('E1', '');
	getCustSch('S1', '');
}


$(document.body).ready(function() {
	$.getScript('/js/sal/gridCommon.js').done(function() {
		commonGrid.init(flexGrid,cv); //그리드 공통부분
		getCusName(); //사업명 취득
		gridInit();  	//그리드 초기화
		gridEvent();	//그리드 이벤트
		handleEvent();	//프로그램 버튼 이벤트
	});			
});
