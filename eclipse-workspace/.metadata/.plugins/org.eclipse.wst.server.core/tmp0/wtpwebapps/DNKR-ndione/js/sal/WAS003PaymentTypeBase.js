// 컬랙션 뷰는 조회후에 그리드의 상태변경을 체크한다. 
var cv = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수


var flexGrid = new wijmo.grid.FlexGrid('#wijmoGrid');	//그리드 전역변수
var zoomSize = 11;

var comps = [
	{ id: 'PE', name: LN_OPT_2 },
	{ id: 'PS', name: LN_OPT_3 }
];
var compsMap = new wijmo.grid.DataMap(comps, 'id', 'name');

//사업부-업체-업체명 list 변수
var e1CustSch = "";
var s1CustSch = "";

/**
 조회버튼
 */
function search() {
	/*initSetMaster();*/

	if (!$(".getComps").val()) {
		toastMsg(LN_SELECT_COMPS);
		return false;
	}

	var url = '/ajaxPaymentTypeBase/search.do';
	var params = {
		'getComps': $(".getComps").val(),
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

/**
 * 팝업창에서 값넘겨받아 부모창에 데이터 set
 * 
 * @param returnValue
 */
function getReturnValue(returnValue) {
	if (returnValue !== null) {
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
		toastMsg("[" + LN_INS_CHK3 + "]");
		return false;
	}
	if (item.pyvnd == null || wijmo.isEmpty(item.pyvnd) || item.pyvnd == "") {
		toastMsg("[" + LN_INS_CHK4 + "]");
		return false;
	} else {
		var value = item.pyvnd;
		value = value.trim();
		var flag = true;
		if (item.comps == 'PS') {
			s1CustSch.forEach(function(data, index) {
				var custNo = data.cusno;
				var custNm = data.cusnm;
				var trimCode = "";
				if (custNo != null) {
					trimCode = custNo.trim();
				}
				var pyvnd = item.pyvnd;
				var trimPyvnd = pyvnd.trim();
				if (trimPyvnd == trimCode) {
					item.cusnm = custNm;
					flag = false;
					return false;
				}
			});
		}
		if (item.comps == 'PE') {
			e1CustSch.forEach(function(data, index) {
				var custNo = data.cusno;
				var custNm = data.cusnm;
				var trimCode = "";
				if (custNo != null) {
					trimCode = custNo.trim();
				}
				var pyvnd = item.pyvnd;
				var trimPyvnd = pyvnd.trim();
				if (trimPyvnd == trimCode) {
					item.cusnm = custNm;
					flag = false;
					return false;
				}
			});
		}
		if (flag) {
			item.pyvnd = "";
			item.cusnm = "";
			return toastMsg("[" + LN_INS_CHK5 + "]");
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
		toastMsg("[" + LN_ERROR_ALT + "]");
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
	for (var i = 0; i < cv.itemsEdited.length; i++) {

		$.ajax({
			method: "post",
			url: "/ajaxPaymentTypeBase/update.do",
			data: cv.itemsEdited[i],
			async: false,
			success: function(xhr) {
				var data = JSON.parse(xhr);

				if (data.result != RESULT_OK) {
					var rowNum = cv.itemsEdited[i].rownum;
					addErrorLineColor(flexGrid, rowNum);
					if (data.errMsg == "LN_UPD_CHK1") stateMsg = LN_UPD_CHK1;
					if (data.errMsg == "LN_UPD_CHK2") stateMsg = LN_UPD_CHK2;
					if (data.errMsg == "LN_UPD_CHK3") stateMsg = LN_UPD_CHK3;
					if (data.errMsg == "LN_UPD_CHK4") stateMsg = LN_UPD_CHK4;
				}
				if (data.result == RESULT_OK) {
					//성공시 rownum이 있으면 라인색상 제거
					var rowNum = cv.itemsEdited[i].rownum;
					if (typeof rownum != "undefined" && rownum != "" && rownum != null) {
						removeErrorLineColor(flexGrid, rowNum);
					}
				}
			},
			error: function() {
				stateMsg = "error";
				var rowNum = cv.itemsEdited[i].rownum;
				addErrorLineColor(flexGrid, rowNum);
			},
			complete: function() {
				//toastMsg(stateMsg);
			}
		});


		isModify = true;

	}
	// Create : 생성 처리

	for (var i = 0; i < cv.itemsAdded.length; i++) {

		$.ajax({
			method: "post",
			url: "/ajaxPaymentTypeBase/create.do",
			data: cv.itemsAdded[i],
			async: false,
			success: function(xhr) {
				var data = JSON.parse(xhr);

				if (data.result != RESULT_OK) {
					var rowNum = cv.itemsAdded[i].rownum;
					addErrorLineColor(flexGrid, rowNum);
					if (data.errMsg == "LN_INS_CHK1") stateMsg = LN_INS_CHK1;
					if (data.errMsg == "LN_INS_CHK2") stateMsg = LN_INS_CHK2;

				}
				if (data.result == RESULT_OK) {
					//성공시 rownum이 있으면 라인색상 제거
					var rowNum = cv.itemsAdded[i].rownum;
					if (typeof rownum != "undefined" && rownum != "" && rownum != null) {
						removeErrorLineColor(flexGrid, rowNum);
					}
				}
			},
			error: function() {
				toastMsg("error");
				var rowNum = cv.itemsEdited[i].rownum;
				addErrorLineColor(flexGrid, rowNum);
			},
			complete: function() {

			}
		});

		isModify = true;
	}

	// Delete : 삭제 처리 
	for (var i = 0; i < cv.itemsRemoved.length; i++) {
		$.ajax({
			method: "post",
			url: "/ajaxPaymentTypeBase/delete.do",
			data: cv.itemsRemoved[i],
			async: false,
			success: function(xhr) {

				var data = JSON.parse(xhr);

				if (data.result != RESULT_OK) {
					if (data.errMsg == "LN_DEL_CHK1") stateMsg = LN_DEL_CHK1;
				}
			},
			error: function() {
				toastMsg("error");
			},
			complete: function() {

			}
		});

		isModify = true;

	}

	if (isModify) {

		if (stateMsg == RESULT_OK) {
			toastMsg(RESULT_OK);
			search();

		} else {
			toastMsg(stateMsg);
		}

	} else {
		toastMsg("[" + LN_ERROR_ALT + "]");
	}


}

/**
 * 엑셀 다운로드
 */
function downloadExcel() {

	var fileName = LN_FILE_NM;
	transExcel(flexGrid, fileName);

}



/**
	버튼 이벤트 처리
 */
function handleEvent() {

	if ($('.getComps').val() == 'ALL') {
		$('.getCusnm').prop("disabled", true);
		$('.getPyvnd').prop("disabled", true);
		$('._custBtn_').prop("disabled", true);
	}

	$('.getComps').on('change', function() {
		$(".getPyvnd").val("");
		$(".getCusnm").val("");
		cv.sourceCollection = [];

		if ($('.getComps').val() == 'ALL') {
			$('.getCusnm').prop("disabled", true);
			$('.getPyvnd').prop("disabled", true);
			$('._custBtn_').prop("disabled", true);
		} else {
			$('.getCusnm').prop("disabled", false);
			$('.getPyvnd').prop("disabled", false);
			$('._custBtn_').prop("disabled", false);
		}

	});

	$('.getPyvnd').on('change', function() {
		$(".getCusnm").val("");
		cv.sourceCollection = [];
	});

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
		var getComps = $(".getComps").val();
		if (getComps == "ALL") {
			getComps = "[" + LN_GRID_CHK1 + "]";
		} else {
			getComps = $(".getComps").val();
		}
		var addRow = cv.addNew();
		addRow.comps = getComps;
		cv.commitNew();
		flexGrid.select(new wijmo.grid.CellRange(flexGrid.rows.length + 1, 0), true);
	});

	// 그리드 row 삭제
	$("._delBtn").on("click", function() {
		var removeNum = flexGrid.selection.row;
		for (var i = removeNum; i < flexGrid.rows.length; i++) {
			var rownum = flexGrid.getCellData(i, 'rownum')
			if (typeof rownum != "undefined" && rownum != "" && rownum != null) {
				flexGrid.setCellData(i, 'rownum', rownum - 1);
			}
		}

		cv.remove(cv.currentItem);
	});

}


/**
  그리드 초기화
 */
function gridInit() {
	//컬럼정의
	var columnsDefinition = [
		{ binding: 'comps', header: LN_CHK_COMPS, width: '*', align: 'center', dataType: 'String', maxLength: 3, dataMap: compsMap,isRequired:false }, //사업부
		{ binding: 'pyvnd', header: LN_CHK_PYVND, width: '*', align: 'center', dataType: 'String', maxLength: 4,isRequired:false }, //업체코드
		{ binding: 'cusnm', header: LN_CHK_CUSNM, width: '*', align: 'center', dataType: 'String', isReadOnly: true }, //업체명
		{ binding: 'oldPyvnd', visible: false },
		{ binding: 'rownum', visible: false }

	];
	//컬럼 초기화
	flexGrid.initialize({
		columns: columnsDefinition
	});

}

function isCodeValid(d) {
	var re = /^[0-9+]*$/;
	return re.test(d);
}

function gridEvent() {

	//validation

	cv.getError = function(item, prop) {

		switch (prop) {
			case "comps":

				if (item.comps == null || wijmo.isEmpty(item.comps) || item.comps == "") {
					return "[" + LN_GRID_CHK1 + "]";
				}
				return null;

			case "pyvnd":

				if (item.pyvnd == null || wijmo.isEmpty(item.pyvnd) || item.pyvnd == "") {
					return "[" + LN_GRID_CHK2 + "]";
				} else {
					var value = item.pyvnd;
					value = value.trim();
					var flag = true;
					if (item.comps == 'PS') {
						s1CustSch.forEach(function(data, index) {
							var custNo = data.cusno;
							var custNm = data.cusnm;
							var trimCode = "";
							if (custNo != null) {
								trimCode = custNo.trim();
							}
							var pyvnd = item.pyvnd;
							var trimPyvnd = pyvnd.trim();
							if (trimPyvnd == trimCode) {
								item.cusnm = custNm;
								flag = false;
								return false;
							}
						});
					}
					if (item.comps == 'PE') {
						e1CustSch.forEach(function(data, index) {
							var custNo = data.cusno;
							var custNm = data.cusnm;
							var trimCode = "";
							if (custNo != null) {
								trimCode = custNo.trim();
							}
							var pyvnd = item.pyvnd;
							var trimPyvnd = pyvnd.trim();
							if (trimPyvnd == trimCode) {
								item.cusnm = custNm;
								flag = false;
								return false;
							}
						});
					}
					if (flag) {
						item.pyvnd = "";
						item.cusnm = "";
						return toastMsg("[" + LN_GRID_CHK3 + "]");
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
	flexGrid.cellEditEnding.addHandler(function(s, e) {

		var oldVal = s.getCellData(e.row, e.col);
		if (typeof s.activeEditor != "undefined" && s.activeEditor != "" && s.activeEditor != null) {
			var newVal = s.activeEditor.value;

			if (oldVal != newVal) {
				s.setCellData(e.row, "rownum", e.row, true);
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

/**
 * 업체코드로 업체명 검색하여 데이터 set
 * 
 * @param 업체코드
 */
function getCustSch(comps, value, num) {
	var cusName = "";
	var gubn = "";
	if (num == '1') {
		if (comps == 'PS') {
			comps = "S1";
			gubn = "input";
		} else {
			comps = "E1";
			gubn = "input";
		}
	}
	$.ajax({
		method: "post",
		url: "/ajaxCustomer/search.do",
		async: false,
		data: {
			"getCusno": value,
			"getComps": comps
		},
		success: function(res) {
			if (num == '1') {
				var data = JSON.parse(res);
				if (data.list.length > 0) {
					if (gubn == "input") $('#getCusnm').val(data.list[0].cusnm);
				} else {
					toastMsg(LN_IO_CHK1 + " : " + value);
					if (gubn == "input") {
						$('#getPyvnd').val("");
					}
				}
			} else {
				if (comps == 'E1') {
					e1CustSch = JSON.parse(res).list;
				} else {
					s1CustSch = JSON.parse(res).list;
				}
			}
		},
		error: function() {
			//console.log("dataset.error");
		},
		completed: function() {
			//console.log("dataset.completed");
		}
	});
}

/*
\	업체명 list
*/
function getCusName() {
	getCustSch('E1', '', '2');
	getCustSch('S1', '', '2');
}

$(document.body).ready(function() {
	//그리드 공통js 호출 후에 나머지 함수 호출함.
	$.getScript('/js/sal/gridCommon.js').done(function() {

		commonGrid.init(flexGrid, cv); //그리드 공통부분
		getCusName(); //업체명 취득
		gridInit();  	//그리드 초기화
		gridEvent();	//그리드 이벤트
		handleEvent();	//프로그램 버튼 이벤트		

		if ($('.getComps').val() != "") {
			//loc코드 →comps코드 변환(기개발된 업체코드/품번 체크 function 사용으로 해당 로직 추가)
			var transComps = $(".getComps").val();
			if (transComps == "PE") $("#getTrncCode").val("E1");
			else if (transComps == "PS") $("#getTrncCode").val("C1");
		}

	});
});

