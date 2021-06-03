/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
"use strict";

var currWorkLCode,
	currWorkMCode,
	currWorkSCode;

/**
 * [ko]프로젝트 관리 객체
 */
function PjtObj (pjtNum, workHour, relSys, workTrtr, workDtlCnts) {
	this.pjtNum = pjtNum;
	this.workHour = workHour;
	this.relSys = relSys;
	this.workTrtr = workTrtr;
	this.workDtlCnts = workDtlCnts;
}

/**
 * 
 * @param type
 * @param relationCode
 */
function setSelectData(type, upperCode){
	//console.log("setSelectData()");
	$.ajax({
		method : "post",
		url : "/ajaxWorkSort/init.do",
		data : {
			type: type,
			upperCode: upperCode,			
		},
		success : function(res) {
			//console.log(res);
			var data = JSON.parse(res);
			if (data.list.length > 0) {
				
				//조회 select 외의 데이터 초기화
				if(type === "M") {
//					teamCode 리스트 초기화
					$('select.workMCode').html('<option value="">' + LN_WORK_M + '</option>');
					//$('select.workMCode').html('<option value="">업무분류(중)</option>');
					var listStr = "<option value=''>" + LN_WORK_M + "</option>";
					data.list.forEach(function(item, index){
						listStr += '<option value="'+ item.workCode +'">'+item.workTypeNm+'</option>';	
					});
					
					$('select.workMCode').html(listStr);
				} else if(type === "S") {
					$('select.workSCode').html('<option value="">' + LN_WORK_S + '</option>');
					//var listStr = "<option>업무분류(소)</option>";
					var listStr = "<option value=''>" + LN_WORK_S + "</option>";
					data.list.forEach(function(item, index){
						listStr += '<option value="'+ item.workCode +'">'+item.workTypeNm+'</option>';	
					});	
					
					$('select.workSCode').html(listStr);
				}
				
				
				
				
				setTimeout(function() {
					mask.close();
				}, 1000);
			} else {
				
				//하위그리드 데이터 조회일 때 초기화
				if(type === "M") {
//					locCode에 리스트 초기화
					$('select.workMCode').html('<option value="">' + LN_WORK_M + '</option>');
					//$('select.workMCode').html('<option value="">업무분류(중)</option>');
//					teamCode에 리스트 초기화
//					$('select.workSCode').html('<option>업무분류(소)</option>');
					
					//사업부서 등록 시 상위코드로 사용할 사업장 코드 초기화
					currWorkMCode = "";
					
				}/* else if(type === "S"){
//					teamCode에 리스트 초기화
					$('select.workSCode').html('<option>부서(팀)전체</option>');
				}*/
				
				setTimeout(function() {
					mask.close();
					toastMsg(LN_NO_DATA);
				}, 1000);
			}
		},
		error : function(res) {
			//console.log("error");
			//console.log(res);
		},
		complete : function(res) {
			setTimeout(function() {
				mask.close();
			}, 1000);
		}
	});
	//console.log('ajaxend');
	// return true;
}

/**
 * 
 * @param params
 */
function setOptions(params) {
	$.ajax({
		method : "post",
		url : "/ajaxWorkSort/init.do",
		data : params,
		success : function(res) {
			//console.log(res);
			var data = JSON.parse(res);
			//console.log(data);
			//console.log(typeof data);
			options = [];
			if(data.list.length > 0){
				data.list.forEach(function(n) {
					//console.log(typeof n.relationName);
					options.push({value: ""+ n.workCode, text: ""+n.workTypeNm});
				});
			}
			
			 
		},
		error : function(res) {
			
		},
		complete : function(res) {
			
		}
	});
}

/**
 * ==================================================================== 
 * [KO] Function: 화면에 입력한 권한의 내용을 수정.<br> 
 * [KO] Argument: [1st argument] 수정할 내용객체(AuthObj)<br>
 * [KO] Summary : 이함수는 화면에 입력한 권한 내용을 수정한다.<br>
 * [KO] Argument: [1st argument] AuthObj<br>
 * [EN] Summary : <br>
 * ====================================================================
 */
function updatePjt(updateData) {
	var stateMsg,
		ajaxParams = updateData;
	
	$.ajax({
		url : "/ajaxPjt/update.do",
		type : "post",
		data : ajaxParams,
		success : function(res) {
			//console.log("updateAuth.success");
			var data = JSON.parse(res);
			if(data.result === RESULT_OK) {
				stateMsg = RESULT_OK;
			} else {
				//console.log("err");
				stateMsg = data.errMsg;
			}
			
		},
		error : function() {
			//console.log("updateAuth.error");
			stateMsg = "error";
		},
		complete : function() {
			//console.log("updateAuth.complete");
			//console.log("stateMsg:" + stateMsg);
			toastMsg(stateMsg);
			
		}
	});	
}

/**
 * ==================================================================== 
 * [KO] Function: 수정한 내용을 화면에 반영.<br> 
 * [KO] Argument: [1st argument] 수정할 tr Element의 저장버튼<br>
 * [KO] Argument: [2st argument] 수정할 내용객체(AuthObj)<br>
 * [KO] Summary : 이함수는 수정한 내용을 화면에 반영한다.<br>
 * [EN] Argument: [1st argument] save button of tr Element<br>
 * [EN] Argument: [2st argument] AuthObj<br>
 * [EN] Summary : <br>
 * ====================================================================
 */
function dataSet(btnObj, dataObj) {
	//console.log("dataSet()");
	var trEl = $($(btnObj).closest('tr'));
	var targetEl = trEl[0].previousSibling.previousSibling;
	var arrTdEl = $(targetEl).find('td');
	arrTdEl[1].innerText = dataObj.workHour;
	arrTdEl[5].innerText = dataObj.relSys;
//	arrTdEl[7].innerText = dataObj.workDtlCnts;
	//console.log(dataObj.workDtlCnts)
	$(arrTdEl[7]).find('.workDtlCnts').val(dataObj.workDtlCnts);
	
	if (dataObj.workTrtr === 'CMCM00003') {
		arrTdEl[6].innerText = '공통';
	} else if (dataObj.workTrtr === 'CMCM00004') {
		arrTdEl[6].innerText = '지역';
	}
	
	
	trEl.addClass('displayNone');
	$(targetEl).removeClass('displayNone');
	$('.detail').hide();
}

function deletePjt(deletePjtNum) {
	mask.open();
	var stateMsg = "";
	$.ajax({
		url : "/ajaxPjt/delete.do",
		type : "get",
		data : {
			"pjtNum" : deletePjtNum,
		},
		success : function(res) {
			//console.log("deleteAuth.success");
			var data = JSON.parse(res);
			if(data.result === "OK") {
				toastMsg('삭제되었습니다.');
				location.reload();
			}
			
		},
		error : function() {
			//console.log("deleteAuth.error");
			stateMsg = "error";
		},
		complete : function() {
			//console.log("deleteAuth.complete");
			setTimeout(function() {
				mask.close();
				toastMsg(stateMsg);
			}, 1000);
			
		}
	});
}

function downloadExcel(){
	//fnExcelReport('pjtExcel', 'pjt');
	location.href = "/WAK002PjtSearchAll/pjtExcel.do?filename=pjtList";
}

$(document).ready(function() {
	mask.close();
	
	$('.pjt_board .dropdown').on('click', function(e){
		$($(e.target).closest('div.fl').find('.dropdown-menu')).css('display', 'block');
	});
	
	var pjtAllCalendar = new ax5.ui.calendar({
        target: document.getElementById("pjtAllCalendar"),
        control: {
            left: '<i class="fa fa-chevron-left"></i>',
            yearTmpl: '%s',
            monthTmpl: '%s',
            right: '<i class="fa fa-chevron-right"></i>',
            yearFirst: true
        },
        displayDate: (new Date()),
        multipleSelect: 2,
        lang: {
        	/*yearTmpl: "%s년",*/
            /*months: ['일월', '이월', '삼월', '사월', '오월', '육월', '칠월', '팔월', '구월', '시월', '십일월', '십이월'],*/
        	yearTmpl: YEAR_FORMAT,
        	months: MONTH,
        	dayTmpl: "%s"
        },
        dimensions: {
            height: 250,
            controlHeight: 50,
            itemPadding: 5
        },
        onClick: function () {
        	var dates = this.self.getSelection();
            if (dates.length > 1) {
                var minDate = new Date(Math.min(ax5.util.date(dates[0]).getTime(), ax5.util.date(dates[1]).getTime()));
                var maxDate = new Date(Math.max(ax5.util.date(dates[0]).getTime(), ax5.util.date(dates[1]).getTime()));
                if(dates[0] < dates[1]) {
                	$(this.target).prev().val(dates[0]);
                    $($(this.target).closest('div.dropdown').next()).find('input').val(dates[1]);
                } else {
                	$(this.target).prev().val(dates[1]);
                    $($(this.target).closest('div.dropdown').next()).find('input').val(dates[0]);
                }
                
                this.self.setPeriod({
                    range: [
                        {from: minDate, to: maxDate, fromLabel: '', toLabel: ''}
                    ]
                });
                $(this.target).css('display', 'none');
            } else {
            	$(this.target).prev().val(dates[0]);
            }
        },
        onStateChanged: function () {
            //console.log(this);
        }
    });
	
	//사업부서(팀) autocomplete 리스트
	$('#workAutoComplete').on('click', function(e) {
		//console.log("autocomplete2.click");
		//console.log(e.target);
		var divEl = $(e.target).closest('.searchWrap');
		var workMCode = divEl.find('select#workMCode').val() + "";
		//console.log(divEl);
		//console.log("workMCode:" + workMCode);
		if( workMCode.trim().length === 0 || workMCode === null || workMCode === "null" || workMCode === "undefined" || workMCode === undefined){
			toastMsg('업무분류(대), 업무분류(소)를 먼져 선택해주세요');
			options = [];
			return;
		}
		var params = {
				"type": "S",
				"upperCode": workMCode,
		};
    	
    	setOptions(params);
    	$(this).children('span').css('z-index', '-100');
    	$(this).find('[data-ax5autocomplete-display="input"]').focus();
	});
	
	//사업부서(팀) autocomplete
    $('#workAutoComplete').ax5autocomplete({
        removeIcon: '<i class="fa fa-times" aria-hidden="true"></i>',
        onSearch: function (callBack) {
            var searchWord = this.searchWord;
            setTimeout(function () {
                var regExp = new RegExp(searchWord);
                var myOptions = [];
                options.forEach(function (n) {
                    if (n.text.match(regExp)) {
                        myOptions.push({
                            value: n.value,
                            text: n.text
                        })
                    }
                });
                callBack({
                	options: myOptions
                });
            }, 150);

        },
        onChange: function() {
        	//console.log('aa');
        	//console.log(this.value[0].value);
        	//console.log(typeof this.value);
        	$('#workCode').val(this.value[0].value);
        	/* setValue($('#workAutoComplete'), {value:"", text:""}) */
        }
	});
	
	//업무분류(대) 셀렉트박스의 값이 변경될때  
	$('select.workLCode').change(function(){
		//console.log('select changed');
		var currWorkLCode = this.value;
//		$('#workLCode').val(currworkLCode);
		currWorkMCode = null;
		currWorkSCode = null;
		setSelectData('M', currWorkLCode);
	});
	
	//업무분류(중) 셀렉트박스의 값이 변경될때  
	$('select.workMCode').change(function(){
		//console.log('select changed');
		var currWorkMCode = this.value;
//		$('#locCode').val(currLocCode);
		currWorkSCode = null;
		setSelectData('S', currWorkMCode);
	});
	
	//업무상세보기 버튼
	$('._detailBtn_').click(function(){
		$('.pj_regist').find('.detail').hide();
		$(this).parent('td').find('.detail').show();	
	}).focus(function(){
		$(this).parent('td').find('.detail').show();	
		$(this).siblings('td').find('.detail').hide();
	});
	
	$('.detail').find('.close').click(function(){
		$('.detail').hide();
	});
	
	
	$('._addBtn_').click(function() {
		//console.log('addbtn Clicked');
		$('.input_tr').removeClass('displayNone');
		
	});
	
	$('._cancelBtn_').on('click', function(e) {
		//console.log($(e.target).attr('data-click-target'));
		if($(e.target).attr('data-click-target') === 'workDtlCnts'){
			//console.log("_cancelBtn_1");
			$('.detail').hide();
		} else {
			//console.log("_cancelBtn_2");
			var tr = $($(e.target).closest('tr')); 
			tr[0].classList.add('displayNone');
			tr[0].previousSibling.previousSibling.classList.remove('displayNone');
		}
	});
	
	$('._saveBtn_').on('click', function(e) {
		//console.log("_saveBtn_ clicked");
		var trEl = $($(e.target).closest('tr'));
		if($(e.target).attr('data-click-target') === 'pjt-save'){
			//console.log("target: pjt-save");
			
			if(val_chk(trEl.find('#workHour').val(), '업무시간')
					& val_chk(trEl.find('#workLCode').val(), '업무분류(대)')
					& val_chk(trEl.find('#workMCode').val(), '업무분류(중)')
					& val_chk(trEl.find('#workCode').val(), '업무분류(소)')){
				mask.open();
				$('#WAK001PjtCreateForm').submit();
			}
		}else if($(e.target).attr('data-click-target') === 'pjt-modify'){
			//console.log("modify");
			
			var pjtNum = $(trEl[0]).find('#pjtNum').val();
			var workHour = $(trEl[0]).find('#workHour').val();
			var relSys = $(trEl[0]).find('#relSys').val();
			var workTrtr = $(trEl[0]).find('#workTrtr').val();
			var workDtlCnts = $(trEl[0]).find('.workDtlCnts').val();
			
			if(val_chk(trEl.find('#workHour').val(), '업무시간')){
				var pjtObj = new PjtObj (pjtNum, workHour, relSys, workTrtr, workDtlCnts)
				updatePjt(pjtObj);
				dataSet(e.target, pjtObj);
			}
		}
	});
	
	$('._modifyBtn_').on( 'click', function(e){
		var trEl = $($(e.target).closest('tr'));
		trEl[0].classList.add('displayNone');
		trEl[0].nextSibling.nextSibling.classList.remove('displayNone');
	});
	
	$('._deleteBtn_').on( 'click', function(e){
		var delPjtNum = $(e.target).attr('data-click-target');
		var deleteCheck = confirm(LN_CONFIRM_DELETE);
		if(deleteCheck){
			deletePjt(delPjtNum);
		}
	});
	
	//조회버튼 클릭
	$('._searchBtn_').on('click', function(){
		//console.log('search clicked');
		$('#pjtDomain').submit();
	});
});

