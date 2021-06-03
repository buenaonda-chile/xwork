//code intellisense typescript 정의
///<reference path = "../../wijmo/controls/wijmo.d.ts"/>	
///<reference path = "../../wijmo/controls/wijmo.grid.d.ts"/>
///<reference path = "../../wijmo/controls/wijmo.grid.cellmaker.d.ts"/>
///<reference path = "../../wijmo/controls/wijmo.input.d.ts"/>
///<reference path = "../../wijmo/controls/wijmo.grid.filter.d.ts"/>

// 컬랙션 뷰는 조회후에 그리드의 상태변경을 체크한다. 
var cv = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수

var flexGrid = new wijmo.grid.FlexGrid('#wijmoGrid');	//그리드 전역변수
var zoomSize = 11;
var selectComps = "";//사업부 val 취득
var selectReprt = "";//보고서 val 취득
/*
* 데이터 임의로 지정
*/
var comps = [
	{ id: 'AL', name: LN_OPT4 },
	{ id: 'PE', name: LN_OPT2 },
	{ id: 'PS', name: LN_OPT3 }
];

var reprtse = [
	{ parentId: 'AL', id: 'R1', name: LN_WKREPRT },
	{ id: 'R2', name: LN_MNREPRTMJRPRDT },
	{ id: 'R3', name: LN_MNREPRTMAKER },
	{ id: 'R4', name: LN_MNREPRTITEM }
];

var cmmnt = [
	{ parentId: 'R1', id: 'C1', code: 'C1', name: LN_CMN1 },
	{ parentId: 'R1', id: 'C2', code: 'C2', name: LN_CMN2 },
	{ parentId: 'R2', id: 'C1', code: 'C1', name: LN_CMN1 },
	{ parentId: 'R2', id: 'C2', code: 'C2', name: LN_CMN2 },
	{ parentId: 'R3', id: 'C6', code: 'R3PE', name: LN_CMNKE },
	{ parentId: 'R3', id: 'C7', code: 'R3PS', name: LN_CMNKA },
	{ parentId: 'R4', id: 'C3', code: 'R4PE', name: LN_CMNE1 },
	{ parentId: 'R4', id: 'C4', code: 'R4PS', name: LN_CMNC1 },
	{ parentId: 'R4', id: 'C5', code: 'R4PS', name: LN_CMNS1 }
];


/**
 조회버튼
 */
function search() {
	flexGrid.validateEdits = false;
	var url = '/ajaxSalAnlysComent/search.do';
	var params = {
		'getComps': $(".getComps").val(),
		'getReprtNm': $(".getReprtNm").val(),
		'getRepym': $(".getDumcb").val().replace(/-/gi, "")
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
		toastMsg(LN_VAL_REPYM);
		return false;
	}
	if (item.comps == null || wijmo.isEmpty(item.comps) || item.comps == "") {
		toastMsg(LN_VAL_COMPS);
		return false;
	}
	if (item.reprtse == null || wijmo.isEmpty(item.reprtse) || item.reprtse == "") {
		toastMsg(LN_VAL_REPRTSE);
		return false;
	} else {
		var flag = true;
		reprtse.forEach(function(data, index) {
			var reprtse = data.id;
			var reprtNm = data.name;
			var trimCode = reprtse.trim();
			var reprtse = item.reprtse;
			var trimReprtse = reprtse.trim();
			if (trimReprtse == trimCode) {
				item.reprtNm = reprtNm;
				flag = false;
				return false;
			}
		});
	}
	if (item.cmnitm == null || wijmo.isEmpty(item.cmnitm) || item.cmnitm == "") {
		toastMsg(LN_VAL_CMNITM);
		return false;
	}
	if (item.cmncn == null || wijmo.isEmpty(item.cmncn) || item.cmncn == "") {
		toastMsg(LN_VAL_CMNCN);
		return false;
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
		toastMsg(LN_ERRALERT);
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
			url: "/ajaxSalAnlysComent/update.do",
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
		console.debug(cv.itemsAdded[i]);

		$.ajax({
			method: "post",
			url: "/ajaxSalAnlysComent/create.do",
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
		console.debug(cv.itemsRemoved[i]);
		$.ajax({
			method: "post",
			url: "/ajaxSalAnlysComent/delete.do",
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
		toastMsg(LN_ERRALERT);
	}

}

/**
 * 엑셀 다운로드
 */
function downloadExcel() {

	var fileName = LB_XLSXTITLE + '.xlsx';
	transExcel(flexGrid, fileName);

}


/**
	년월 변경시 리셋
 */
function reset() {
	cv.sourceCollection = [];
	$("#getComps option[value='']").attr('selected', true);
	$("#getReprtNm option[value='']").attr('selected', true);
}


/**
	그리드 리셋
 */
function clearGrid() {
	cv.sourceCollection = [];
}

/**
	버튼 이벤트 처리
 */
function handleEvent() {

	$('.getComps').on('change', function() {
		clearGrid();
	});

	$('.getReprtNm').on('change', function() {
		clearGrid();
	});

	//등록폼 닫기버튼
	$("._closeBtn_").on("click", function() {
		var target = this.getAttribute("data-click-target");
		addBtnUiSet(this);
	});

	//행 추가버튼
	$("._addBtn_").on("click", function() {
		var addRow = cv.addNew();

		addRow.comps = $(".getComps").val();
		addRow.repym = $(".getDumcb").val().replace(/-/gi, "");
		addRow.reprtse = LB_COMPSMSG;
		addRow.cmnitm = LB_COMPSREPRTMSG;
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

	var compsMap = new wijmo.grid.DataMap(comps, 'id', 'name');
	var reprtseMap = new wijmo.grid.DataMap(reprtse, 'id', 'id');
	var cmmntMap = new wijmo.grid.DataMap(cmmnt, 'id', 'name');

	//COMPS에 따른 REPRTSE 드롭박스 리셋
	reprtseMap.getDisplayValues = function() {

		var cate1 = flexGrid.collectionView.currentItem.comps;
		var cate2 = reprtse.filter(function(value) {
			if (value.parentId == "AL") {
				return cate1 == "AL"
			} else {
				return cate1
			}
		})

		return cate2.map(function(value) {
			return value.id
		});
	}

	//REPRTSE에 따른CMMNT 드롭박스 리셋
	cmmntMap.getDisplayValues = function() {

		var cate1 = flexGrid.collectionView.currentItem.reprtse;
		var cate2 = cmmnt.filter(function(value) {
			if (selectComps == 'PS') {
				if (selectReprt == 'R3') {
					return value.code == "R3PS"
				} else if (selectReprt == 'R4') {
					return value.code == "R4PS"
				} else {
					return value.parentId == cate1
				}
			} else if (selectComps == 'PE') {
				if (selectReprt == 'R3') {
					return value.code == "R3PE"
				} else if (selectReprt == 'R4') {
					return value.code == "R4PE"
				} else {
					return value.parentId == cate1
				}
			} else {
				return value.parentId == cate1
			}
		})

		return cate2.map(function(value) {
			return value.name
		});
	}



	var cellMaker = wijmo.grid.cellmaker.CellMaker;

	//컬럼정의
	var columnsDefinition = [
		{ binding: 'repym', header: '*' + LN_CHK_REPYM, width: '*', align: 'center', dataType: 'String', maxLength: 6, isReadOnly: true }, //년월
		{ binding: 'comps', header: '*' + LN_CHK_COMPS, width: '*', align: 'center', dataType: 'String', dataMap: compsMap, isRequired: false }, //사업부
		{ binding: 'reprtse', header: '*' + LN_CHK_REPRTSE, width: '*', align: 'center', dataType: 'String', dataMap: reprtseMap, isRequired: false }, //보고서종류
		{ binding: 'reprtNm', header: '*' + LN_CHK_REPRTNM, width: '*', align: 'center', dataType: 'String', isReadOnly: true }, //보고서명
		{ binding: 'cmnitm', header: '*' + LN_CHK_CMNITM, width: '*', align: 'center', dataType: 'String', dataMap: cmmntMap, isRequired: false }, //코멘트항목
		{ binding: 'cmncn', header: '*' + LN_CHK_CMNCN, width: '*', align: 'left', dataType: 'String', maxLength: 500, multiLine: true, wordWrap: true, isReadOnly: true }, //코멘트내용
		{
			header: LN_CMNSAVE, isRequired: false, width: 100, cellTemplate: cellMaker.makeButton({
				text: "<b style='color: white'>" + LN_CMNSAVE + "</b>",
				click: function(e, ctx) {
					//코멘트 내용 초기화
					var comment = flexGrid.getCellData(ctx.row.index, 'cmncn', true);
					popComment.show(true, function(sender) {
						if (sender.dialogResult == 'wj-hide-ok') {
							//등록될때 코멘트내용 셀에 데이터 넣음.
							flexGrid.setCellData(ctx.row.index, 'cmncn', $("#commentTxt").val(), true);
							//넣고난뒤 해당row의 height조절
							autoSizeRowsAsync(flexGrid, ctx.row.index);
							flexGrid.focus();
						}
					});
					$("#commentTxt").val(comment);
					$("#commentTxt").focus();
				}
			})
		},
		{ binding: 'oldComps', visible: false },
		{ binding: 'oldRepym', visible: false },
		{ binding: 'oldReprtse', visible: false },
		{ binding: 'oldCmnitm', visible: false },
		{ binding: 'rownum', visible: false }

	];
	//컬럼 초기화
	flexGrid.initialize({
		columns: columnsDefinition
	});

	var popComment = new wijmo.input.Popup('#popComment');
}


function isDatetimeValid(d) {
	var re = /[0-9]{4}(0[1-9]|1[0-2])/;
	return re.test(d);
}

function gridEvent() {

	//validation

	cv.getError = function(item, prop) {

		switch (prop) {
			case "repym":

				if (item.repym == null || wijmo.isEmpty(item.repym) || item.repym == "") {
					return LB_GRIDREPYM;
				}
				return null;

			case "comps":

				if (item.comps == null || wijmo.isEmpty(item.comps) || item.comps == "") {
					return LB_GRIDCOMPS;
				}
				return null;

			case "reprtse":
				if (item.comps !== null && !wijmo.isEmpty(item.comps) && item.comps !== "") {
					if (item.reprtse == null || wijmo.isEmpty(item.reprtse) || item.reprtse == "") {
						return LB_GRIDREPRTSE;
					} else {
						var flag = true;
						reprtse.forEach(function(data, index) {
							var reprtse = data.id;
							var reprtNm = data.name;
							var trimCode = reprtse.trim();
							var reprtse = item.reprtse;
							var trimReprtse = reprtse.trim();
							if (trimReprtse == trimCode) {
								item.reprtNm = reprtNm;
								flag = false;
								return false;
							}
						});
					}
				}
				return null;

			case "cmnitm":
				if (item.reprtse !== null && !wijmo.isEmpty(item.reprtse) && item.reprtse !== "") {
					if (item.cmnitm == null || wijmo.isEmpty(item.cmnitm) || item.cmnitm == "") {
						return LB_GRIDCMNITM;
					}
				}
				return null;
			case "cmncn":

				if (item.cmncn == null || wijmo.isEmpty(item.cmncn) || item.cmncn == "") {
					return LB_GRIDCMNCN;
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
		var editKey = s.columns[e.col].binding;
		var value = s.getCellData(e.row, e.col, false);
		if (typeof value != "undefined" && value != "" && value != null) {
			if (s.columns[e.col].dataType == wijmo.DataType.String) {
				s.setCellData(e.row, e.col, value.toUpperCase());
			}
		}

		// 사업부 변경시 보고서,코멘트 재조회
		if (editKey == "comps") {
			selectComps = s.getCellData(e.row, 'comps', true);
			if (selectComps == LN_OPT4) {
				selectComps = "AL";
			} else if (selectComps == LN_OPT3) {
				selectComps = "PS";
			} else {
				selectComps = "PE";
			}
			s.setCellData(e.row, 'reprtse', "");
			s.setCellData(e.row, 'reprtNm', "");
			s.setCellData(e.row, 'cmnitm', "");
		}
		//보고서 변경시 코멘트 재조회
		if (editKey == "reprtse") {
			selectReprt = s.getCellData(e.row, 'reprtse', true);
			s.setCellData(e.row, 'cmnitm', "");
		}
	});
}


function calendar() {
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
		onClick: function() {
			$(this.target).css('display', 'none');
			var date = JSON.stringify(chk_calendar.getSelection());
			$(this.target).prev().val(date.substring(2, 9));
		},
		onStateChanged: function() {
			//console.log(this);
		}
	});

	$('.log_board .dropdown').on('click', function(e) {
		$($(e.target).next('.dropdown-menu')).css('display', 'block');
	});
}

$(document.body).ready(function() {

	//그리드 공통js 호출 후에 나머지 함수 호출함.
	$.getScript('/js/sal/gridCommon.js').done(function() {

		commonGrid.init(flexGrid, cv); //그리드 공통부분
		gridInit();  	//그리드 초기화
		gridEvent();	//그리드 이벤트
		handleEvent();	//프로그램 버튼 이벤트		
		calendar(); //캘린더

	});

});

