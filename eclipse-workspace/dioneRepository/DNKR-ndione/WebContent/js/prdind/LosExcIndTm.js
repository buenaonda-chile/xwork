var lgsDstRtSum = 0;

var workMast = null; // 빵,쿠폰 마스트

// 컬랙션 뷰는 조회후에 그리드의 상태변경을 체크한다.
var cv = new wijmo.collections.CollectionView(null); // 컬랙션뷰 전역변수
var flexGrid = new wijmo.grid.FlexGrid('#wijmoGrid'); // 그리드 전역변수
var zoomSize = 11;
var baseLgstTime = 0;

/**
 * 팝업창에서 값넘겨받아 부모창에 데이터 set
 * 
 * @param returnValue
 */
function getReturnValue(returnValue) {
	if (returnValue !== null) {
		var custObj = JSON.parse(returnValue);

		$('#getLocId').val(custObj.code);
		$('#getLocNm').val(custObj.name);
	}
}

/**
 * 등록시 오류검증
 */
function validation(item) {
	if (item.clsCode == null || wijmo.isEmpty(item.clsCode) || item.clsCode == "") {
		toastMsg("수정이나 추가한 행의 [사업부]컬럼을 입력해야 됩니다.");
		return false;
	}

	return true;
}

function handleEvent() {
	// 등록폼 닫기버튼
	$("._closeBtn_").on("click", function() {
		var target = this.getAttribute("data-click-target");
		addBtnUiSet(this);
	});

	$('._custBtn_')
			.on(
					'click',
					function() {
						window
								.open("/ajaxPrdctIndComBase/initDeptPop.do",
										"deptPop",
										"width=550,height=620,scrollbars=yes,top=100,left=100");
					});

	// 그리드 row 삭제
	$("._delBtn").on("click", function() {
		cv.remove(cv.currentItem);
	});
}

function search() {

	// 그리드 갱신
	gridInit();

	if (!$("#getComps").val()) {
		toastMsg(LN_SELECT_COMPS);
		return false;
	} else if (!$("#getLocId").val()) {
		toastMsg(LN_SELECT_DEPT);
		return false;
	} else if (!$("#opertDe").val()) {
		toastMsg("작업일자를 입력해주세요.");
		return false;
	}

	var url = "/ajaxLosExcIndTm/search.do";
	var opertDe = $("#opertDe").val().replaceAll("-", "");

	var params = {
		'getComps' : $("#getComps option:selected").val(),
		'getLocId' : $("#getLocId").val(),
		'getOpertDe' : parseInt(opertDe)
	};

	mask.open();
	$.ajax({
		method : "post",
		url : url,
		data : params,
		success : function(res) {

			var data = JSON.parse(res).list;
			cv.sourceCollection = data;

		},
		error : function(e) {
			console.log("dataset.error : " + e);
			setTimeout(function() {
				mask.close();
			}, 500);
		},
		complete : function() {
			// console.log("dataset.completed");
			setTimeout(function() {
				mask.close();
			}, 500);

		}
	});
	
}

// 수정
function update() {
	/**
	 * 익스플로러에서 그리드외 다른영역으로 포커스가 빠졌을경우(클릭) 컬랙션뷰에서 변경된 내용을 인식하지 못하는 버그발생 아래처럼 포커스와
	 * 셀을 강제로 영역을 지정함.
	 */
	flexGrid.focus();
	flexGrid.select(new wijmo.grid.CellRange(0, 0, 0, 0), true);

	// validation
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

	// Update : 업데이트 프로세스
	for (var i = 0; i < cv.itemsEdited.length; i++) {
		updateGrid(cv.itemsEdited[i]);
		isModify = true;
	}

	// Create : 생성 처리
	for (var i = 0; i < cv.itemsAdded.length; i++) {
		insertGrid(cv.itemsAdded[i]);
		isModify = true;
	}

	// Delete : 삭제 처리
	for (var i = 0; i < cv.itemsRemoved.length; i++) {
		deleteGrid(cv.itemsRemoved[i]);
		isModify = true;
	}

	if (isModify) {
		// if(stateMsg == RESULT_OK){
		// search();
		// }
	}
}

/**
 * 스프레드 추가
 */
function insertGrid(item) {

	$.ajax({
		method : "post",
		url : "/ajaxLnPrsInpTm/create.do",
		data : item,
		async : false,
		success : function(res) {
			if (res != "") {
				var data = JSON.parse(res);
				if (data.result === RESULT_OK) {
					toastMsg(RESULT_OK);
				} else {
					setTimeout(function() {
						toastMsg(data.errMsg);
					}, 500);
				}
			}
		},
		error : function() {
			toastMsg("error");
		},
		complete : function() {

		}
	});

}

/**
 * 스프레드 수정
 * value가 0이면 삭제, 공백은 skip, 값이 있으면 업데이트, 공백에서 값이 생성되면 Insert
 */
function updateGrid(item) {
	var stateMsg = "OK";
	$.ajax({
		url : "/ajaxLosExcIndTm/update.do",
		type : "post",
		data : item,
		async : false,
		success : function(res) {
			if (res != "") {
				var data = JSON.parse(res);
				if (data.result == 'OK') {
					stateMsg = "OK";
					search();
					toastMsg(RESULT_OK);
				} else {
					stateMsg = data.errMsg;
				}
			}
		},
		error : function() {
			stateMsg = "error";
		},
		complete : function() {
			
		}
	});
}

/**
 * 엑셀 다운로드
 */
function downloadExcel() {

	var fileName = $("#opertDe").val + '일 손실제외간접시간.xlsx';

	wijmo.grid.xlsx.FlexGridXlsxConverter
			.saveAsync(
					flexGrid,
					{
						includeColumnHeaders : true
					},
					fileName,
					function(base64) {
						// user can access the base64 string in this callback.
						document.getElementById('importFile').href = 'data:application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;'
								+ 'base64,' + base64;
						// console.log(base64);
					}, function(reason) {
						// User can catch the failure reason in this callback.
						console.log('The reason of save failure is ' + reason);
					});

}

/**
 * 그리드 row height 자동크기조절
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

function getLines() {
	var url = "/ajaxLosExcIndTm/searchLine.do";
	var params = {
		'getComps' : $("#getComps").val(),
		'getLocId' : $("#getLocId").val()
	};
	var columnsDefinition = [];
	$.ajax({
		method : "post",
		url : url,
		data : params,
		success : function(res) {
			var data = JSON.parse(res).linelist;
		},
		error : function(e) {
			setTimeout(function() {
				mask.close();
			}, 500);
		},
		complete : function() {

		}
	});
	return columnsDefinition;
}

function gridInit() {

	var gridColumns = new Array();
	var url = "/ajaxLosExcIndTm/searchLine.do";
	var params = {
		'getComps' : $("#getComps").val(),
		'getLocId' : $("#getLocId").val()
	};
	var columnsDefinition = new Array();

	var jObject1 = new Object();
	jObject1.binding = 'clsCode';
	jObject1.visible = false;
	columnsDefinition.push(jObject1);

	var jObject2 = new Object();
	jObject2.binding = 'locCode';
	jObject2.visible = false;
	columnsDefinition.push(jObject2);

	var jObject3 = new Object();
	jObject3.binding = 'lineCode';
	jObject3.visible = false;
	columnsDefinition.push(jObject3);

	var jObject4 = new Object();
	jObject4.binding = 'se';
	jObject4.visible = false;
	columnsDefinition.push(jObject4);

	var jObject5 = new Object();
	jObject5.binding = 'seNm';
	jObject5.align = 'center';
	jObject5.header = '작업구분';
	jObject5.dataType = 'String';
	jObject5.width = 200;
	jObject5.visible = true;
	jObject5.isReadOnly = true;
	jObject5.allowMerging = true;
	columnsDefinition.push(jObject5);

	var jObject6 = new Object();
	var jObject6_1 = new Array();
	var jObject6_1_1 = new Object();
	var jObject6_1_2 = new Object();
	jObject6.header = '구분';
	jObject6.align = 'center';
	jObject6_1_1.binding = 'code';
	jObject6_1_1.header = '코드';
	jObject6_1_1.width = 200;
	jObject6_1_1.align = 'center';
	jObject6_1_1.isReadOnly = true;
	jObject6_1_1.visible = true;

	jObject6_1_2.binding = 'codeNm';
	jObject6_1_2.header = '코드명';
	jObject6_1_2.width = 200;
	jObject6_1_2.align = 'center';
	jObject6_1_2.isReadOnly = true;
	jObject6_1_2.visible = true;
	jObject6_1.push(jObject6_1_1);
	jObject6_1.push(jObject6_1_2);
	jObject6.columns = jObject6_1;
	columnsDefinition.push(jObject6);

	// 부서(반)의 검색값이 존재할 경우에만 라인을 표시한다.
	if ($("#getLocId").val() != "") {
		$.ajax({
			method : "post",
			url : url,
			data : params,
			async : true,
			success : function(res) {

				if (res != 'null') {
					var data = JSON.parse(res).lineList;

					if (data.length > 0) {
						for (var i = 0; i < data.length; i++) {

							var jObject = new Object();
							jObject.binding = "line_" + data[i].locCode+ "_" + data[i].lineCode;
							jObject.header = data[i].lineNm;
							jObject.align = 'center';
							jObject.dataType = 'Number';
							jObject.format = 'n0';
							jObject.width = '*';
							columnsDefinition.push(jObject);

						}
					} else {
						var jObject = new Object();
						jObject.header = '해당 검색에 대한 라인이 없습니다.';
						jObject.align = 'center';
						jObject.width = '*';
						columnsDefinition.push(jObject);
					}
					flexGrid.initialize({
						columns : columnsDefinition,
						allowMerging : 'Cells'
					});
					flexGrid.columnHeaders.rows.defaultSize = 40; // 열 헤더 영역에
																	// 행의 높이 설정
				}
				setTimeout(function() {
					mask.close();
				}, 500);
			},
			error : function(e) {
				setTimeout(function() {
					mask.close();
				}, 500);
			},
			complete : function() {

			}
		});
	} else {
		var jObjectInit = new Object();
		jObjectInit.header = '부서(반) 선택시 라인이 표시됩니다.';
		jObjectInit.align = 'center';
		jObjectInit.width = '*';
		columnsDefinition.push(jObjectInit);

		flexGrid.initialize({
			columns : columnsDefinition,
			allowMerging : 'Cells'
		});
		flexGrid.columnHeaders.rows.defaultSize = 40;
		mask.close();
	}
	// 컬럼 초기화

}

function gridEvent() {
	// validation
	cv.getError = function(item, prop) {
		switch (prop) {
		case "clsCode":
			if (item.clsCode == null || wijmo.isEmpty(item.clsCode)
					|| item.clsCode == "") {
				return "[사업부]을 입력해야 됩니다.";
			}
			return null;
		}
		return null;
	}


}

function calFunction(s, e) {
	return 0;
}

function clearGrid(){
	cv.sourceCollection=[];
}

/**
 * 부서코드로 업체명 검색하여 데이터 set
 * 
 * @param 업체코드
 */
function getDeptSch(gubn, value, s, e) {
	if (value != "") {
		clearGrid();
		$.ajax({
			method : "post",
			url : "/ajaxPrdctIndComBase/searchDeptMaster.do",
			data : {
				"getCode" : value,
				"getComps" : $("#getComps").val()
			},
			success : function(res) {
				var data = JSON.parse(res);

				if (data.list.length > 0) {
					if (gubn == "input")
						$('#getLocNm').val(data.list[0].name);
				} else {
					toastMsg(LN_IO_CHK1 + " : " + value);
					if (gubn == "input") {
						$('#getLocCode').val("");
					}
					if (gubn == "grid") {
						var oldValue = s.getCellData(e.row, 5, false);
						if (oldValue == "" || oldValue == null
								|| oldValue == undefined)
							oldValue = "0"; // dataType:'Number' 에는 공백 초기화가 안됨.
						s.setCellData(e.row, e.col, oldValue);
					}
				}
			},
			error : function() {
				// console.log("dataset.error");
			},
			completed : function() {
				// console.log("dataset.completed");
			}
		});
	}
}

function setRowReadOnly() {
	var rows = flexGrid.rows;
	var cnt = 0;
	for (var i = 0; i < rows.length; i++) {
		cnt = i + 1;
		if (cnt % 2 == 0) {
		} else {
			rows[i].isReadOnly = true;
		}
	}
}

function getToday() {
	var date = new Date();
	return date.getFullYear() + "-" + ("0" + (date.getMonth() + 1)).slice(-2)
			+ "-" + ("0" + date.getDate()).slice(-2);
}

$(document.body).ready(function() {
	// 작업일자
	var plndt_calendar = new ax5.ui.calendar({
		target : document.getElementById("plndt_calendar"),
		control : {
			left : '<i class="fa fa-chevron-left"></i>',
			yearTmpl : '%s',
			monthTmpl : '%s',
			right : '<i class="fa fa-chevron-right"></i>',
			yearFirst : true
		},
		displayDate : (new Date()),
		dimensions : {
			height : 250,
			controlHeight : 40,
			itemPadding : 1
		},
		lang : {
			yearTmpl : YEAR_FORMAT,
			months : MONTH,
			dayTmpl : "%s"
		},
		onClick : function() {
			$(this.target).css('display', 'none');
			$(this.target).prev().val(plndt_calendar.getSelection());
		},
		onStateChanged : function() {
			// console.log(this);
		}
	});
	
	$("#delBtn").on('click', function(e) {
		var item = flexGrid.selectedItems;
		var rowNo = flexGrid.selection.row;
		
		for(var i=0; i<item.length; i++){
			var data= item[i];
			for (let key in data) {
				if(key.includes("line_") == true){
					flexGrid.setCellData(rowNo, key, 0);
				} 
			}
		}
		
	});
	
	$('.log_board .dropdown').on('click', function(e) {
		$($(e.target).next('.dropdown-menu')).css('display', 'block');
	});

	$.getScript('/js/sal/gridCommon.js').done(function() {
		commonGrid.init(flexGrid, cv); // 그리드 공통부분
		gridInit(); // 그리드 초기화
		gridEvent(); // 그리드 이벤트
		handleEvent(); // 프로그램 버튼 이벤트

		var nowDate = getToday();
		$("#opertDe").val(nowDate);
		$("#ttlLgst").val("100");
	});

});
