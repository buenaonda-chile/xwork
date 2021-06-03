/**
 * 작업완료란 확인
 * 작업완료란 : 1 == 완료
 * 작업완료란 : 1 != 미완료
 **/
function chk_complete(clickEl) {
	//console.log("chk_complete");
	var str = clickEl.value.trim();
	//console.log(str);
	if(str.length > 0) {
		if(str === '1') {
			$(clickEl).next().val("완료");
		} else {
			clickEl.value = "";
			$(clickEl).next().val("미완료");
		}
	}
}

/**
 * [KO] 신규이력등록 전 입력검사
 */
function form_chk () {
	if(confirm($('#cmplt').next().val() + ": 저장하시겠습니까?")){
		var chkNum = 0;
		
		$('#mshno').css('background', '#fff');
		$('#wrkm').css('background', '#fff');
		$('#hyosn').css('background', '#fff');
		$('#ksdat').css('background', '#fff');
		$('#kstim').css('background', '#fff');
		
		$('#jobcd').css('background', '#fff');
		$('#inocd').css('background', '#fff');
		$('#emgcd').css('background', '#fff');
		$('#qorcd').css('background', '#fff');
		$('#subas').css('background', '#fff');
		$('#assno').css('background', '#fff');
		$('#com-knd').css('background', '#fff');
		$('#dec-knd').css('background', '#fff');
		$('#prtno').css('background', '#fff');
		$('#cho').css('background', '#fff');
		$('#phenomenon').css('background', '#fff');
		$('#repcd').css('background', '#fff');
		$('#ecost').css('background', '#ededed');
		$('#wonin').css('background', '#fff');
		$('#daech').css('background', '#fff');
		
		$('#padat').css('background', '#fff');
		$('#patim').css('background', '#fff');
		$('#urdat').css('background', '#fff');
		$('#urtim').css('background', '#fff');
		$('#kdown').css('background', '#fff');
		$('#ksdat').css('background', '#fff');
		$('#kstim').css('background', '#fff');
		$('#wndat').css('background', '#fff');
		$('#wntim').css('background', '#fff');
		$('#bfrhr').css('background', '#fff');
		$('#wrkhr').css('background', '#fff');
		$('#janhr').css('background', '#fff');
		
		//필수 입력폼 체크
		if($('#mshno').val().trim().length === 0
				|| $('#wrkm').val().trim().length === 0
				|| $('#hyosn').val().trim().length === 0
				|| $('#ksdat').val().trim().length === 0
				|| $('#kstim').val().trim().length === 0) {
			
			$('#mshno').css('background', '#e2f0f5');
			$('#wrkm').css('background', '#e2f0f5');
			$('#hyosn').css('background', '#e2f0f5');
			$('#ksdat').css('background', '#e2f0f5');
			$('#kstim').css('background', '#e2f0f5');
			
			chkNum += 1;
		}
		
		//2. 완료등록,미완료등록일때 jobcd의 값(PM,CM,BM)에 따라 에러체크 처리 하는 부분 
		if($('#cmplt').val().trim() === "1") {
			
			if($('#jobcd').val().trim().length === 0
					||$('#inocd').val().trim().length === 0
					||$('#emgcd').val().trim().length === 0
					||$('#qorcd').val().trim().length === 0
					||$('#subas').val().trim().length === 0
					||$('#assno').val().trim().length === 0
					||$('#com').val().trim().length === 0
					||$('#dec').val().trim().length === 0
					||$('#prtno').val().trim().length === 0
					||$('#cho').val().trim().length === 0
					||$('#hyo').val().trim().length === 0
					||$('#repcd').val().trim().length === 0
					||$('#ecost').val().trim().length === 0
					||$('#wonin').val().trim().length === 0
					||$('#daech').val().trim().length === 0) {
				
				chkNum += 1;
				$('#jobcd').css('background', '#e2f0f5');
				$('#inocd').css('background', '#e2f0f5');
				$('#emgcd').css('background', '#e2f0f5');
				$('#qorcd').css('background', '#e2f0f5');
				$('#subas').css('background', '#e2f0f5');
				$('#assno').css('background', '#e2f0f5');
				$('#com-knd').css('background', '#e2f0f5');
				$('#dec-knd').css('background', '#e2f0f5');
				$('#prtno').css('background', '#e2f0f5');
				$('#cho').css('background', '#e2f0f5');
				$('#phenomenon').css('background', '#e2f0f5');
				$('#repcd').css('background', '#e2f0f5');
				$('#ecost').css('background', '#e2f0f5');
				$('#wonin').css('background', '#e2f0f5');
				$('#daech').css('background', '#e2f0f5');
			}
			
			if($('#hyo').val().trim() !== "99") { //99 해당없음 
				if($('#caucd').val().trim().length === 0
						||$('#trucd').val().trim().length === 0) {
				
					chkNum += 1;	
					$('#cause').css('background', '#e2f0f5');
					$('#truC').css('background', '#e2f0f5');
				}
			}
			
			if($('#jobcd').val().trim() === "21" || $('#jobcd').val().trim() === "22") {
				if($('#padat').val().trim().length === 0
						|| $('#patim').val().trim().length === 0
						|| $('#urdat').val().trim().length === 0
						|| $('#urtim').val().trim().length === 0
						|| $('#kdown').val().trim().length === 0
						|| $('#ksdat').val().trim().length === 0
						|| $('#kstim').val().trim().length === 0
						|| $('#wndat').val().trim().length === 0
						|| $('#wntim').val().trim().length === 0
						|| $('#bfrhr').val().trim().length === 0
						|| $('#wrkhr').val().trim().length === 0
						|| $('#janhr').val().trim().length === 0) {
					
					chkNum += 1;
					$('#padat').css('background', '#e2f0f5');
					$('#patim').css('background', '#e2f0f5');
					$('#urdat').css('background', '#e2f0f5');
					$('#urtim').css('background', '#e2f0f5');
					$('#kdown').css('background', '#e2f0f5');
					$('#ksdat').css('background', '#e2f0f5');
					$('#kstim').css('background', '#e2f0f5');
					$('#wndat').css('background', '#e2f0f5');
					$('#wntim').css('background', '#e2f0f5');
					$('#bfrhr').css('background', '#e2f0f5');
					$('#wrkhr').css('background', '#e2f0f5');
					$('#janhr').css('background', '#e2f0f5');
				}
			}
			
		}
		
		if(chkNum > 0) {
			alert("[경고]필수 입력항목입니다.");
			return false;
		} else {
			return true;
		}
	}	
	return false;
}

/**
 * 입력폼 초기화
 */
function dataInit() {
	$('#kdown').val("0");
	$('#assno').val("01");
	$('#prtno').val("001");
	$('#bfrhr').val("0");
	$('#wrkhr').val("0");
	$('#janhr').val("0.0");
	$('#scost').val("0");
	$('#ecost').val("0");
	$('#pcost').val("0");
	$('#cmplt').next().val("미완료");
	$('#wrkm').val(sabun);
	$('#wrkm').next().val(empName);
}

/**
 * [KO] 신규이력 등록 <br>
 * [KO] 개선상세 클릭 시 저장 후 개선상세페이지 팝업<br> 
 * [KO] 교환부품 클릭 시 저장 후 개선상세페에지 팝업<br>
 * 
 * @param target 클릭버튼
 */
function fn_save(target, flag) {
	if(!flag) {
		var chk = form_chk();
	}
	 
	if(chk || flag) {
		var jisno;
		var url = "/WAF002PsogmCreate/ajaxCreate.do";
		var params = $('#psogmCreateForm').serialize();
		var jsonData = getAjaxDomain(url, params);
		var menu = $('#menu').val();	
		
		if (jsonData !== undefined) {
			var pDomain = jsonData.pDomain;
			try {
				jisno = pDomain.jisno;
				$('#jisno').val(jisno);
			} catch(e) {
				console.log(e);
			}
			
			if(target.getAttribute("data-target") === "save") {	//저장
				toastMsg("처리 완료되었습니다.");
			} else if(target.getAttribute("data-target") === "imprv"){	//개선상세
				//개선상세 팝업
				window.open("/WAF026PsogmImprvD/init.do?menu=" + menu + "&jisno=" + jisno,"changeUnitPop","width=1080,height=700,scrollbars=yes,top=100,left=100");
			} else if(target.getAttribute("data-target") === "change"){	//교환부품
//				var menu = target.getAttribute('data-menu');
				window.open("/WAF002PsogmCreate/changeUnitPop.do?menu=" + menu + "&jisno=" + jisno,"changeUnitPop","width=1000,height=700,scrollbars=yes,top=100,left=100");
			}
			
			if(jsonData.repcdMsg !== undefined) {
				toastMsg(jsonData.repcdMsg);
			}
			
			if(jsonData.errMsg !== undefined) {
				toastMsg(jsonData.errMsg);
			}
		} else {
			toastMsg("오류가 발생했습니다<br>잠시 후 다시 시도해 주십시요");
			window.location.reload();
		}

	} else {
		//개선상세나 교환부품 저장취소시 상태초기화
		$('#status').val("");	
	}
}

/**
 * [KO] 지시No에 값이 있는지 체크 (true:비어있음, false:값 있음)
 * 
 * @return boolean
 */
function isEmptyJisno () {
	var status = false;
	if($('#jisno').val() === undefined || $('#jisno').val().trim().length === 0) {
		status = true;
	}
	return status;
}

/**
 * [KO] 교환부품창 닫을 때 교환부품리스트가 있으면 데이터 셋팅
 */
function setChangeUnit (returnValue) {
	var pCost = 0;
	var appendStr = "";
		
	var trEls = $('.changeUnitTable tbody tr');
		
	if(trEls.length > 0) {
		for(var i = trEls.length; i > 0 ; i--) {
			$('.changeUnitTable tbody tr:nth-child(' + i + ')').remove();
		}
	}
	
	if (returnValue !== null) {
		var params = JSON.parse(returnValue);
		params.forEach(function (item, index) {
			pCost += Number(item.amont);
			appendStr += "<tr>";
			appendStr += "<td>";
			appendStr += item.prtnm;
			appendStr += "</td>";
			appendStr += "<td>";
			appendStr += item.ptype;
			appendStr += "</td>";
			appendStr += "<td>";
			appendStr += item.quaty;
			appendStr += "</td>";
			appendStr += "<td>";
			appendStr += item.amont;
			appendStr += "</td>";
			appendStr += "</tr>";
		});
		
		pCost = Math.ceil(pCost/1000);
		//console.log("appendStr:" + appendStr);
		 
	}
	
	$('#pcost').val(pCost);
	$('.changeUnitTable').append(appendStr);
	
	$('#status').val("partaft");
	fn_save(document.getElementById("addBtn"), true);
}

/**
 * [KO] 개선상세 팝업창에서 저장버튼을 눌렀을 때 ecost값을 바인드 하기위한 함수
 * 
 * @param ecost
 */
function setEcost(ecost) {
	$('#ecost').val(ecost);
}

$(document.body).ready(function() {
	//Date - 의뢰일시
	picker.bind({
        target: $('[data-ax5picker="basic_reg"]'),
        direction: "top",
        content: {
            width: 270,
            margin: 10,
            type: 'date',
            config: {
                control: {
                    left: '<i class="fa fa-chevron-left"></i>',
                    yearTmpl: '%s',
                    monthTmpl: '%s',
                    right: '<i class="fa fa-chevron-right"></i>'
                },
                lang: {
                    yearTmpl: "%s년",
                    months: ['01월', '02월', '03월', '04월', '05월', '06월', '07월', '08월', '09월', '10월', '11월', '12월'],
                    dayTmpl: "%s"
                }
            }
        },
        onStateChanged: function () {

        }
    });
	
	
	//Date - 개시일시
	picker.bind({
        target: $('[data-ax5picker="basic_open"]'),
        direction: "top",
        content: {
            width: 270,
            margin: 10,
            type: 'date',
            config: {
                control: {
                    left: '<i class="fa fa-chevron-left"></i>',
                    yearTmpl: '%s',
                    monthTmpl: '%s',
                    right: '<i class="fa fa-chevron-right"></i>'
                },
                lang: {
                    yearTmpl: "%s년",
                    months: ['01월', '02월', '03월', '04월', '05월', '06월', '07월', '08월', '09월', '10월', '11월', '12월'],
                    dayTmpl: "%s"
                }
            }
        },
        onStateChanged: function () {

        }
    });
	
	//Date - 완료일시
	picker.bind({
        target: $('[data-ax5picker="basic_wan"]'),
        direction: "top",
        content: {
            width: 270,
            margin: 10,
            type: 'date',
            config: {
                control: {
                    left: '<i class="fa fa-chevron-left"></i>',
                    yearTmpl: '%s',
                    monthTmpl: '%s',
                    right: '<i class="fa fa-chevron-right"></i>'
                },
                lang: {
                    yearTmpl: "%s년",
                    months: ['01월', '02월', '03월', '04월', '05월', '06월', '07월', '08월', '09월', '10월', '11월', '12월'],
                    dayTmpl: "%s"
                }
            }
        },
        onStateChanged: function () {

        }
    });
	
	
	$('button.ubiRptBtn').on('click', function() {
		var comps = $('#comps').val();
		var jisno = $('#jisno').val();
		window.open("/WAF001PsogmSearch/ubiReportPop.do?jisno=" + jisno + "&comps=" + comps,"resultPop","width=1080,height=845,scrollbars=yes,top=100,left=100");
	});
	
	
	//효과구분(종합관리>설비보전관리>신규이력등록페이지)
	$('select#effect').on('change', function() {
		selectToUl(this);
	});
	
	
	//첨부버튼
	$('.attachedFBtn').on('click', function() {
		if(isEmptyJisno()) {
			toastMsg("[알림] 미완료 저장후 첨부하여 주세요.");
			return false;
		}
		
		if($('#managerYn').val() !== "M" && $('#cmplt').val() === "1") {
			toastMsg("완료된 작업일지입니다.");
			return false;
		}
		
		var menu = this.getAttribute('data-menu');
		var jisno = $('#jisno').val();
		window.open("/WAF002PsogmCreate/attachedFilePop.do?menu=" + menu + "&jisno=" + jisno,"attachedFPop","width=950,height=550,scrollbars=yes,top=100,left=100");
	});
	
	//개선상세 버튼클릭
	$('.improveBtn').on('click', function(e) {
		$('#status').val("");
		if(isEmptyJisno()) {
			toastMsg("[알림] 미완료 저장후 개선상세로 들어가주세요.");
			return false;
		}
		
		//개선상세버튼을 누르면 입력한 내용을 자동저장되게 함.
		$('#status').val("partbfr"); //"partbfr"이면 개선상세나 교환부품에 들어가기전 저장하는것임(부분저장);
		
		fn_save(e.target);
	}); 
	
	//부품변경 버튼클릭
	//유효성 검사(입력값) 후 문제 없으면 저장하고 팝업
	$('.changeUnitBtn').on('click', function(e) {
		
		$('#status').val("");	
		
		if(isEmptyJisno()) {
			toastMsg("[알림] 미완료 저장후 교환부품으로 들어가주세요.");
			return false;
		}
		
		//교환부품버튼을 누르면 자동저장되게 함.
		$('#status').val("partbfr"); //"partbfr"이면 개선상세나 교환부품에 들어가기전 저장하는것임(부분저장);
		
		fn_save(e.target);
	});
});
