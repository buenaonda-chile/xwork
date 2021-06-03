/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
"use strict";
var picker = new ax5.ui.picker();

// 설비선택
function ogm312_pop_OnClick() {
	// var str =
	// dialog("psogmlib::ogm200_pop.xml","설비선택",300,300,"TitleBar=true");
	if ($('#mshno').val() !== undefined && $('#mshno').val().trim() !== '') {
		txtmshno_chk($('#mshno').val());
	} else {
		window.open("/WAF003PsogmPerSearch/machineSelectPop.do", "machinePop",
				"width=540,height=700,scrollbars=yes,top=100,left=100");
	}

}

/**
 * 팝업창에서 값넘겨받아 부모창에 데이터 set
 * 
 * @param type
 * @param returnValue
 */
function getReturnValue(type, returnValue) {
	if (returnValue !== null) {
		var param = JSON.parse(returnValue);
		// console.log(param);
		if (type === "jisno") {
			// console.log('mshno:' + param.mshno);
			$('#mshno').val(param.mshno);
			$('#txtmshnm').val(param.mshnm).prop('readonly', true);
			$('#txtmshnm').css('background-color', 'rgb(234, 233, 233)');
			txtmshno_chk(param.mshno);
			// } else if (type !== "prtno2") {
		} else {
			if (type === "emp") {
				param.code = param.code.substr(1, param.code.length);
			} else if (type === "prtno2") {
				var url = "/WAF004PsogmForceICreate/searchSpareUnit.do";
				var params = {
						prtno: param.code,
						group: $('#group').val(),
				}; 
				var jsonData = getAjaxDomain(url, params);
				var pDomain = jsonData.pDomain;
				setFICData(pDomain);
			}
			var targetEl = $('#' + type);
			var nextEl = $('#' + type).next();
			targetEl.val(param.code);
			nextEl.val(param.name1);
		}/*
			 * else { //console.log("else"); }
			 */
	}

}

/**
 * ajax로 결과 체크하기 (현재 미사용 180621)
 * @param url
 */
function getAjaxResult (url, params) {
	var resultStr;
	$.ajax({
		url: url,
		type    : "POST",
		async : false,
		data : params,
		success : function (data){
			//console.log(data);
			try{
				var parse = JSON.parse(data);
    			if(parse.result === RESULT_Y){
    				resultStr = RESULT_Y;
    			}else if(parse.result === RESULT_N){
    				resultStr = RESULT_N;
    				return;
    			}
			}catch(e){
				//console.log(e);
			}
		},
		error: function(e){ 
			//console.log(e);
		},
		complete: function(e) {
			//console.log(e);
		}
	});
	
	return resultStr;
}

/**
 * ajax로 도메인 가져오기
 * @param url
 */
function getAjaxDomain (url, params, pType) {
	if (pType === undefined) {
		pType = "POST";
	}
	mask.open();
	var obj;
	$.ajax({
		url: url,
		type    : pType,
		async : false,
		data : params,
		success : function (data){
			//console.log(data);
			try{
				var parse = JSON.parse(data);
    			if(parse.result === RESULT_Y){
    				obj = parse;
    			}else {
    				obj = undefined;
    				return;
    			}
			}catch(e){
				//console.log(e);
			}
		},
		error: function(e){ 
			//console.log(e);
		},
		complete: function(e) {
			//console.log(e);
			mask.close();
		}
	});
	
	return obj;
}

function txtmshno_chk(str) {
	if (str !== "" && str !== undefined) {
		$
				.ajax({
					type : "GET",
					// contentType : "application/json",
					url : "/WAF003PsogmPerSearch/getPrtcdTimcdByMshno.do",
					data : {
						"mshno" : str
					},
					// dataType : "json",
					success : function(resData) {
						//console.log(resData)
						try {
							var data = JSON.parse(resData);
							if (data.result === RESULT_Y) {
								var strDate = data.machineInfo.indat.substr(0,
										4)
										+ '-'
										+ data.machineInfo.indat.substr(4, 2)
										+ ' - 취득';
								$('#txtmshnm').val(data.machineInfo.mshnm);
								$('#txttimnm').val(data.machineInfo.timnm);
								$('#txtprtnm').val(data.machineInfo.prtnm);
								$('#mtbindat').val(strDate);
								
								/*신규이력등록 페이지*/
								if($('#timcd') !== undefined) {
									$('#timcd').val(data.machineInfo.timcd);
								}
								if($('#prtcd') !== undefined) {
									$('#prtcd').val(data.machineInfo.prtcd);
								}
								/*//신규이력등록 페이지*/
							} else {
								toastMsg('조회된 데이터가 없습니다.');
								$('#mshno').val("");
								$('#txtmshnm').val("");
								$('#txttimnm').val("");
								$('#txtprtnm').val("");
								$('#mtbindat').val("");
								
								/*신규이력등록 페이지*/
								if($('#timcd') !== undefined) {
									$('#timcd').val("");
								}
								if($('#prtcd') !== undefined) {
									$('#prtcd').val("");
								}
								/*//신규이력등록 페이지*/
							}
						} catch (e) {
							//console.log(e);
						}
					},
					error : function(x, e) {
						ajaxError(x, e);
					}
				});
	} else {
		//console.log("emplty txtmshno_chk");
	}
}

/**
 * [KO] 사번으로 사원명 가져오기
 * 
 * @param targetEl
 */
function getName(targetEl) {
	var param = targetEl.value.trim();
	if (param.length > 0) {
		$.ajax({
			type : "GET",
			url : "/WAF001PsogmSearch/getEmpInfo.do",
			data : {
				sabun : param
			},
			success : function(resData) {
				 //console.log(resData);
				try {
					var data = JSON.parse(resData);
					var nextEl = $(targetEl).next();
					if (data.result === RESULT_Y) {
						nextEl.val(data.empInfo.kornm);
						if($('#sdpcd') !== undefined) {
							$('#sdpcd').val(data.empInfo.sdpcd);
						}
						
						if($('#dptcd') !== undefined) {
							$('#dptcd').val(data.empInfo.dptcd);
						}
					} else {
						toastMsg("존재하지 않는 사번입니다.");
						targetEl.value = "";
						nextEl.val("");
					}
				} catch (e) {
					//console.log(e);
				}
			},
			error : function(e) {
				//console.log(e);
			}

		});
	}
}

function enterProc() {
	if (event.keyCode === 13) {
		return false;
	}

}

/**
 * 
 * @param type
 * @param url
 */
function setData(type, url, typeL) {
	var params = {
		comps : $('#comps').val()
	};
	if (typeL !== undefined && typeL.trim() !== "") {
		params = $.extend({
			"typeL" : typeL
		}, params);
	}

	$.ajax({
		method : "post",
		url : url,
		data : params,
		success : function(res) {
			// console.log(res);
			var data = JSON.parse(res);
			if (data.result === RESULT_Y) {
				var listStr = "<option value=''></option>";
				var ulListStr = "";
				if (type === 'PART') {
					data.list.forEach(function(item, index) {
						// listStr += '<option value="' + item.prtcd + '">' +
						// item.prtcd + "|" + item.prtnm + '</option>';
						listStr += '<option value="' + item.prtcd + '">'
								+ item.prtnm + '</option>';
					});
					$('#prtcd').html(listStr);
				} else if (type === 'LINE') {
					data.lineList.forEach(function(item, index) {
						// listStr += '<option value="' + item.prtcd + '">' +
						// item.prtcd + "|" + item.prtnm + '</option>';
						listStr += '<option value="' + item.lincd + '">'
								+ item.linnm + '</option>';
					});
					$('#lincd').html(listStr);
				} else if (type === 'UMHEN') {
					data.partsList.forEach(function(item, index) {
						ulListStr += '<li onclick="onClickUmhen(this, ' + "'"
								+ item.umhen + "', '" + typeL + "'"
								+ ')"><span>' + item.umhen + '</span></li>';
					});
					$('#' + typeL + '-umhen').html(ulListStr);
				} else if (type === 'SETS') {
					data.partsList.forEach(function(item, index) {
						ulListStr += '<li onclick="onClickSets(this, ' + "'"
								+ item.comcd + "', '" + item.comcd + ' '
								+ item.cpart + "', '" + typeL + "'"
								+ ')"><span>' + item.comcd + ' ' + item.cpart
								+ '</span></li>';
					});
					$('#' + typeL + '-sets').html(ulListStr);
					$('#' + typeL + '-sets').removeClass('displayNone');
				}

			} else {
				toastMsg(LN_NO_DATA);
			}
		},
		error : function(res) {
			console.log(res);
		},
		complete : function() {

		}
	});
}

/**
 * [KO]select 박스에서 선택한 값으로 Ul태그에 데이터 뿌리기
 * 
 * @param type
 * @param changeEl
 * @param param
 */
function setUlList(type, changeEl, param) {
	var params = {
		param : param,
		typeL : type
	};
	// if(typeL !== undefined && typeL.trim() !== "") {
	// params = $.extend({"typeL": typeL}, params);
	// }

	$.ajax({
		method : "post",
		url : "/WAF001PsogmSearch/getSelectedInfo.do",
		data : params,
		success : function(res) {
			// console.log(res);
			var data = JSON.parse(res);
			if (data.result === RESULT_Y) {
				var ulListStr = "";
				if (type === 'hyo') { // 현상
					data.list.forEach(function(item, index) {
						ulListStr += '<li onclick="bindData(this, ' + "'"
								+ item.hyocd + "', '" + item.hyonm + "'"
								+ ')"><span>' + item.hyocd + ' | ' + item.hkdnm
								+ ' | ' + item.hyonm + '</span></li>';
					});
					changeEl.html(ulListStr);
				} else if (type === 'cau') { // 원인
					data.list.forEach(function(item, index) {
						ulListStr += '<li onclick="bindData(this, ' + "'"
								+ item.caucd + "', '" + item.cause + "'"
								+ ')"><span>' + item.caucd + ' | ' + item.ckdnm
								+ ' | ' + item.cause + '</span></li>';
					});
					changeEl.html(ulListStr);
				} else if (type === 'truC') { // 실원인
					data.list.forEach(function(item, index) {
						ulListStr += '<li onclick="bindData(this, ' + "'"
								+ item.trucd + "', '" + item.trunm + "'"
								+ ')"><span>' + item.trucd + ' | ' + item.tkdnm
								+ ' | ' + item.trunm + '</span></li>';
					});
					changeEl.html(ulListStr);
				} else if (type === 'eff') { // 효과구분(종합관리>설비보전관리>신규이력등록)
					data.list.forEach(function(item, index) {
						ulListStr += '<li onclick="bindData(this, ' + "'"
								+ item.effcd + "', '" + item.effnm + "'"
								+ ')"><span>' + item.effcd + ' | ' + item.effnm
								+ '</span></li>';
					});
					changeEl.html(ulListStr);
				}
			} else {
				toastMsg(LN_NO_DATA);
			}
		},
		error : function(res) {
			console.log(res);
		},
		complete : function() {

		}
	});
}

/**
 * [KO] 셋트부품 - 부품분류코드와 검색-음행에 따른 complete 부품 정보를 가져온다 <br>
 * 
 * @param clickEl
 * @param umhen
 */
function onClickUmhen(clickEl, umhen, typeL) {
	var kndcd = $('#' + typeL + '-knd').val().trim();
	var url = "/WAF001PsogmSearch/getPartsInfo.do?kndcd=" + kndcd + "&umhen="
			+ umhen;
	$(clickEl).closest('ul').addClass('displayNone');
	setData("SETS", url, typeL);
}

/**
 * [KO] 셋트부품 - 선택한 셋트부품값을 select박스에 셋팀
 * 
 * @param clickEl
 * @param comcd
 * @param cpart
 */
function onClickSets(clickEl, comcd, cpart, typeL) {
	$(clickEl).closest('ul').addClass('displayNone');
	$('#' + typeL).html(
			'<option value="' + comcd + '" checked>' + cpart + '</option>');
	$('#' + typeL).removeClass('displayNone');
}

/**
 * 
 * @param targetEl
 * @param code
 * @param codeNm
 */
function bindData(clickEl, code, codeNm) {
	$(clickEl).closest('ul').addClass('displayNone');
	var targetEl = $(clickEl).closest('.selectWrap').children(
			'select:first-child');
	targetEl.html("<option value='" + code + "' checked>" + code + " " + codeNm
			+ "</option>");
	// console.log(targetEl);
}

/**
 * 선택값 초기화
 * 
 * @param clickEl
 */
function initData(clickEl) {
	if (confirm("재선택 하시겠습니까?")) {
		var nextEl = $(clickEl).next();
		clickEl.classList.add('displayNone');
		clickEl.value = "";
		nextEl.val("");
		nextEl.removeClass('displayNone');
	}
}

/**
 * select박스에서 선택한 값으로 조회한 결과를 ul태그의 리스트로 뿌리기
 * 
 * @param clickEl
 * @param url
 */
function selectToUl(clickEl, url) {
	var type = clickEl.getAttribute('data-type');
	var prevEl = $(clickEl).prev();
	var nextEl = $(clickEl).next();
	setUlList(type, nextEl, clickEl.value);
	clickEl.classList.add('displayNone');
	prevEl.removeClass("displayNone");
	nextEl.removeClass("displayNone");
}

//보전이력검색 조회
function search() {
	// console.log("search()");
	var params = $('#psogmSearchForm').serialize();

	//
	var jisnoVal = $('#txtjisno').val().trim();
	if (jisnoVal.length > 0) {
		var comps = $('#comps').val();
		window.open("/WAF001PsogmSearch/resultPop.do?jisno=" + jisnoVal
				+ "&comps=" + comps, "resultPop",
				"width=1080,height=845,scrollbars=yes,top=100,left=100");
	} else {

		makeGogub();
		openSearchPop();
	}
}

/**
 * [KO] 보전작업구분 체크박스 값에 따라 gogub 값 셋팅
 */
function makeGogub() {
	var CheckedCount = Number($('#bm').is(':checked'))
			+ Number($('#pm').is(':checked')) + Number($('#cm').is(':checked'));// 합이 3
	var rvalue = " (";
	var checking = 0;

	// if(CheckedCount !== 3) {
	if ($('#bm').is(':checked') === true) {
		checking = checking + 1;
		// console.log("checking:" + checking);
		rvalue = rvalue + "'" + "BM" + "'";
	}
	if ($('#pm').is(':checked') === true) {
		if (checking != 0)
			rvalue = rvalue + ",";
		checking = checking + 1;
		rvalue = rvalue + "'" + "PM" + "'";
	}
	if ($('#cm').is(':checked') === true) {
		if (checking != 0)
			rvalue = rvalue + ",";
		checking = checking + 1;
		rvalue = rvalue + "'" + "CM" + "'";
	}
	rvalue = rvalue + ")";
	$('#gogub').val(rvalue);
	// }
}

// 보전이력검색 조회결과 팝업
function openSearchPop() {
	var params = $('#psogmSearchForm').serialize();
	var searchForm = document.psogmSearchForm;
	var url = "/WAF001PsogmSearch/searchPop.do";
	window.open('', 'searchPop',
			"width=1080,height=700,scrollbars=yes,top=100,left=100");

	searchForm.action = url;
	searchForm.method = "POST";
	searchForm.target = 'searchPop';
	searchForm.param = params;
	searchForm.submit();
}

// 지시No input 에서 포커스가 변경될 때 수행하는 함수
function txtjisno_OnKillFocus() {
	var jisnoVal = $('#txtjisno').val().trim();
	var selectEls = $('select');
	var inputEls = $('input');

	// 지시No에 값이 입력되었을 때
	if (jisnoVal.length > 0) {

		for (var i = 1; i < selectEls.length; i++) {
			$(selectEls[i]).val("");
			$(selectEls[i]).prop('disabled', true);
		}

		for (var j = 0; j < inputEls.length; j++) {
			$(inputEls[j]).val("");
			$(inputEls[j]).prop('disabled', true);
		}

		$('#txtjisno').val(jisnoVal);
		$('#txtjisno').prop('disabled', false);
		/*
		 * $('#prtcd').val(""); $('#prtcd').prop('disabled', true);
		 * $('#lincd').val(""); $('#lincd').prop('disabled', true);
		 * 
		 * $('#mshno').val(""); $('#mshno').prop('disabled', true);
		 * $('#bm').prop('checked', false); $('#pm').prop('checked', false);
		 * $('#cm').prop('checked', false); $('#bm').prop('disabled', true);
		 * $('#pm').prop('disabled', true); $('#cm').prop('disabled', true);
		 * $('#jobcd').val(""); $('#jobcd').prop('disabled', true);
		 * 
		 * $('#sdpcd').val(""); $('#sdpcd').prop('disabled', true);
		 * $('#wrkm1').val(""); $('#wrkm1').prop('disabled', true);
		 * $('#subas').val(""); $('#subas').prop('disabled', true);
		 * $('#com').val(""); $('#com').prop('disabled', true);
		 * $('#dec').val(""); $('#dec').prop('disabled', true);
		 * $('#cho').val(""); $('#cho').prop('disabled', true);
		 * $('#hyo').val(""); $('#hyo').prop('disabled', true);
		 * $('#caucd').val(""); $('#caucd').prop('disabled', true);
		 * $('#trucd').val(""); $('#trucd').prop('disabled', true); andor = "";
		 * $('#hyosn1').val(""); $('#hyosn1').prop('disabled', true);
		 * $('#hyosn2').val(""); $('#hyosn2').prop('disabled', true);
		 * $('#hyosn3').val(""); $('#hyosn3').prop('disabled', true);
		 * $('#wonin1').val(""); $('#wonin1').prop('disabled', true);
		 * $('#wonin2').val(""); $('#wonin2').prop('disabled', true);
		 * $('#wonin3').val(""); $('#wonin3').prop('disabled', true);
		 * $('#daech1').val(""); $('#daech1').prop('disabled', true);
		 * $('#daech2').val(""); $('#daech2').prop('disabled', true);
		 * $('#daech3').val(""); $('#daech3').prop('disabled', true);
		 * $('#txtmshnm').val("");
		 * 
		 * $('#com-knd').prop('disabled', true); $('#dec-knd').prop('disabled',
		 * true); $('#phenomenon').prop('disabled', true);
		 * $('#cause').prop('disabled', true); $('#truC').prop('disabled',
		 * true);
		 * 
		 * $('button.next-arrow').prop('disabled', true);
		 * 
		 * txtDpart.Text=""; txtCpart.Text="";
		 */

		// /=====
		// lblAndOr.Enable=false;
	} else { // 지시No에 값이 입력되지 않았을 때

		for (var i = 1; i < selectEls.length; i++) {
			$(selectEls[i]).prop('disabled', false);
		}

		for (var j = 0; j < inputEls.length; j++) {
			$(inputEls[j]).prop('disabled', false);
		}

		// cmbprtcd.Enable=true;
		// cmblincd.Enable=true;
		//		
		// txtmshno.Enable=true;
		// ckbBM.Enable=true;
		// ckbPM.Enable=true;
		// ckbCM.Enable=true;
		// cmbJobCd.Enable=true;
		//		
		// cmbsdpcd.Enable=true;
		// txtwrkm1.Enable=true;
		// cmbSubas.Enable=true;
		// cmbComCd.Enable=true;
		// cmbDecCd.Enable=true;
		// cmbChoCd.Enable=true;
		// cmbHyoCd.Enable=true;
		// cmbCauCd.Enable=true;
		// cmbTruCd.Enable=true;
		// lblAndOr.Enable=true;
		// txthyosn1.Enable=true;
		// txthyosn2.Enable=true;
		// txthyosn3.Enable=true;
		// txtwonin1.Enable=true;
		// txtwonin2.Enable=true;
		// txtwonin3.Enable=true;
		// txtdaech1.Enable=true;
		// txtdaech2.Enable=true;
		// txtdaech3.Enable=true;

		$('.next-arrow').prop('disabled', false);
	}
}

/**
 * [KO] 입력폼 초기화

 * @param eventEl
 */
function clearInput(eventEl) {
	var selectEls = $('select');
	var inputEls = $('input');

	for (var i = 1; i < selectEls.length; i++) {
		$(selectEls[i]).val("");
		// $(selectEls[i]).prop('disabled', true);
	}

	for (var j = 0; j < inputEls.length; j++) {
		$(inputEls[j]).val("");
		// $(inputEls[j]).prop('disabled', true);
	}
	
	//신규이력등록페이지일시
	if(eventEl.getAttribute('data-target') === "psogmC") {
		var textEls = $('textarea');
		for (var k = 0; k < textEls.length; k++) {
			$(textEls[k]).val("");
			// $(inputEls[j]).prop('disabled', true);
		}
		dataInit();
	}
}

/**
 * [KO] 예비품/설비보전/계측기 관리자 권한확인       
 * @returns {Boolean}
 */
function chkManager(param) {
	var url = "/WAF001PsogmSearch/chkManager.do";
	var jsonData = getAjaxDomain(url, param);
	var obj = jsonData.pDomain;
	//console.log(obj);
	if (obj != undefined && obj.mager === "M"){
		return true;
	} else {
		toastMsg("권한이 없습니다. 관리자만 처리할 수 있습니다.");
		return false;
	}
	
}


$(function() {
	// $('#prtcd').on('click', function() {
	// setData('PART', "/WAF001PsogmSearch/getPartInfo.do");
	// });
	//	
	// $('#lincd').on('click', function() {
	// console.log("lincd clicked");
	//		
	// setData('LINE', "/WAF003PsogmPerSearch/getLineInfo.do");
	// });

	// Date
	picker.bind({
		target : $('[data-ax5picker="basic"]'),
		direction : "top",
		content : {
			width : 270,
			margin : 10,
			type : 'date',
			config : {
				control : {
					left : '<i class="fa fa-chevron-left"></i>',
					yearTmpl : '%s',
					monthTmpl : '%s',
					right : '<i class="fa fa-chevron-right"></i>'
				},
				lang : {
					yearTmpl : "%s년",
					months : [ '01월', '02월', '03월', '04월', '05월', '06월', '07월',
							'08월', '09월', '10월', '11월', '12월' ],
					dayTmpl : "%s"
				}
			}
		},
		onStateChanged : function() {

		}
	});

	$('#prtcd').on('change', function() {
		$('select#lincd').val("");
		$('#mshno').val("");
		$('#txtmshnm').val("");
	});

	$('#lincd').on('change', function() {
		$('select#prtcd').val("");
		$('#mshno').val("");
		$('#txtmshnm').val("");
	});

	$('#jobcd').on('change', function() {
		$('#bm').attr('checked', false);
		$('#pm').attr('checked', false);
		$('#cm').attr('checked', false);
	});

	$('.textSearchTbl .btn-st02').on('click', function() {
		// console.log("btn clicked");
		var symb = this.getAttribute('data-symb');

		if (symb === "Or") {
			$('#andor').val("or");
		} else {
			$('#andor').val("and");
		}
		var tblEl = $(this).closest('table');
		var tdEls = $(tblEl).find('td.logicSymb').text(symb);
	});

	$('select#com-knd').on(
			'change',
			function() {
				this.classList.add('displayNone');
				// console.log(this.value);
				var prevEl = $(this).prev();
				var nextEl = $(this).next();
				prevEl.removeClass("displayNone");
				setData("UMHEN", "/WAF001PsogmSearch/getPartsInfo.do?kndcd="
						+ this.value, "com");
				nextEl.removeClass("displayNone");
			});

	$('select#dec-knd').on(
			'change',
			function() {
				this.classList.add('displayNone');
				// console.log(this.value);
				var prevEl = $(this).prev();
				var nextEl = $(this).next();
				prevEl.removeClass("displayNone");
				setData("UMHEN", "/WAF001PsogmSearch/getPartsInfo.do?kndcd="
						+ this.value, "dec");
				nextEl.removeClass("displayNone");
			});

	$('select#phenomenon').on('change', function() {
		// var url = "/WAF001PsogmSearch/getSelectedInfo.do?param="+this.value;
		selectToUl(this);
		// this.classList.add('displayNone');
		// var prevEl = $(this).prev();
		// var nextEl = $(this).next();
		// var url =
		// "/WAF001PsogmSearch/getPhenomenonInfo.do?hkind="+this.value;
		// prevEl.removeClass("displayNone");
		// setCauseList("hyo", nextEl, url);
		// nextEl.removeClass("displayNone");
	});

	$('select#cause').on('change', function() {
		selectToUl(this);
	});

	$('select#truC').on('change', function() {
		selectToUl(this);
	});

	// 조회
	$('._searchBtn_').on('click', function() {
		search();
	});

	// input 초기화
	$('._clearBtn_').on('click', function(e) {
		clearInput(e.target);
	});

})