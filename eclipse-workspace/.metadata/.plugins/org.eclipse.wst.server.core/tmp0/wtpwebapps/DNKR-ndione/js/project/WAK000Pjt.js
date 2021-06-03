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
 * @param pjtNum
 * @param workCode
 * @param workMCode
 * @param workLCode
 * @param workHour
 * @param relSys
 * @param workTrtr
 * @param workDtlCnts
 */
function PjtObj (pjtNum, workCode, workMCode, workLCode, workHour, relSys, workTrtr, workDtlCnts) {
	this.pjtNum = pjtNum;
	this.workCode = workCode;
	this.workMCode = workMCode;
	this.workLCode = workLCode;
	this.workHour = workHour;
	this.relSys = relSys;
	this.workTrtr = workTrtr;
	this.workDtlCnts = workDtlCnts;
}

/**
 * 
 * @param type 업무분류코드 타입(L, M, S)
 * @param upperCode 상위코드
 * @param target 선택한 셀릭트박스
 */
function setSelectData(type, upperCode, target){
	var parentTag = $(target).parent().prop('tagName');
	var parentEl;
	if (parentTag === 'TD') {
		console.log('TD');
		parentEl = $(target).closest('tr');
	} else if (parentTag === 'LI'){
		console.log('LI');
		parentEl = $(target).closest('ul');
	}
	console.log(parentEl.find('select.workMCode'));
	console.log("parentTag:" + parentTag);
	console.log("setSelectData()");
	console.log("type:" + type);
	console.log("upperCode" + upperCode);
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
					parentEl.find('select.workMCode').html('<option value="">' + LN_WORK_M + '</option>');
					//$('select.workMCode').html('<option value="">업무분류(중)</option>');
					var listStr = "<option value=''>" + LN_WORK_M + "</option>";
					data.list.forEach(function(item, index){
						listStr += '<option value="'+ item.workCode +'">'+item.workTypeNm+'</option>';	
					});
					
					parentEl.find('select.workMCode').html(listStr);
					parentEl.find('select.workSCode').html('<option value="">' + LN_WORK_S + '</option>');
				} else if(type === "S") {
					var listStr = "<option value=''>" + LN_WORK_S + "</option>";
					data.list.forEach(function(item, index){
						listStr += '<option value="'+ item.workCode +'">'+item.workTypeNm+'</option>';	
					});
					
					parentEl.find('select.workSCode').html(listStr);
				}
				
				
				
				
				setTimeout(function() {
					mask.close();
				}, 1000);
			} else {
				
				//하위그리드 데이터 조회일 때 초기화
				if(type === "M") {
//					locCode에 리스트 초기화
					//$('select.workMCode').html('<option value="">업무분류(중)</option>');
					parentEl.find('select.workMCode').html('<option value="">' + LN_WORK_M + '</option>');
//					workCode에 리스트 초기화
//					$('select.workCode').html('<option>업무분류(소)</option>');
					parentEl.find('select.workSCode').html('<option value="">' + LN_WORK_S + '</option>');
					
					//사업부서 등록 시 상위코드로 사용할 사업장 코드 초기화
					currWorkMCode = "";
					
				} else if(type === "S"){
//					workSCode에 리스트 초기화
					parentEl.find('select.workSCode').html('<option value="">' + LN_WORK_S + '</option>');
				}
				
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
	//console.log('update')
	mask.open();
	var stateMsg = "",
		ajaxParams = updateData;
	var tabId = document.getElementById("tab_container").firstElementChild.innerText;
	
	$.ajax({
		url : "/ajaxPjt/update.do?tabId=" + tabId,
		type : "post",
		data : ajaxParams,
		success : function(res) {
			//console.log("updateAuth.success");
			var data = JSON.parse(res);
			if(data.result === "OK") {
				toastMsg('수정되었습니다.');
				location.replace('/WAK000PjtSearch/init.do')
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
			setTimeout(function() {
				mask.close();
			}, 1000);
			
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
function dataSet(btnObj, dataObj, workCodeNm, workMCodeNm, workLCodeNm) {
	var trEl = $($(btnObj).closest('tr'));
	var targetEl = trEl[0].previousSibling.previousSibling;
	var arrTdEl = $(targetEl).find('td');
	arrTdEl[1].innerText = workLCodeNm;
	arrTdEl[2].innerText = workMCodeNm;
	arrTdEl[3].innerText = workCodeNm;
	arrTdEl[4].innerText = dataObj.relSys;
	arrTdEl[6].innerText = dataObj.workHour;
	$(arrTdEl[7]).find('.workDtlCnts').val(dataObj.workDtlCnts);
	arrTdEl[9].innerText = '대기';
	
	if (dataObj.workTrtr === 'CMCM00003') {
		arrTdEl[5].innerText = '공통';
	} else if (dataObj.workTrtr === 'CMCM00004') {
		arrTdEl[5].innerText = '지역';
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
				location.replace("/WAK000PjtSearch/init.do")
			}
			
		},
		error : function() {
			//console.log("deleteAuth.error");
			stateMsg = "error";
			toastMsg(stateMsg);
		},
		complete : function() {
			//console.log("deleteAuth.complete");
			setTimeout(function() {
				mask.close();
			}, 1000);
			
		}
	});
}

$(document).ready(function() {
	mask.close();
	
	var clickTarget;
	//사업부서(팀) autocomplete 리스트
	$('.relSysAutoComplete').on('click', function(e) {
		clickTarget = this;
		var targetEl = $(e.target);
		console.log("targetEl:" + targetEl);
		console.log("targetEl:" + targetEl.prop('tagName'));
    	targetEl.closest('td').find('span.relSys').css('z-index', '-100');
    	targetEl.closest('.relSysAutoComplete').find('[data-ax5autocomplete-display="input"]').focus();
	});
	
	//사업부서(팀) autocomplete
    $('#relSysAutoComplete').ax5autocomplete({
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
        	console.log("CHANGE");
        	console.log(this.value[0].value);
        	//console.log(typeof this.value);
        	$('.regist_form #relSys').val(this.value[0].value);
        	/* setValue($('#workAutoComplete'), {value:"", text:""}) */
        },
        onStateChanged: function() {
        	console.log("onStateChanged");
        	
        	if(this.state === "close") {
        		console.log("onState closed");
        		try {
        			var relSys = $(clickTarget).find('[data-ax5autocomplete-selected-text]')[0].innerText;
        		} catch (e) {
        			console.log(e);
        		}
        		$('.regist_form #relSys').val(relSys);
        	}
        }
	});
    
    $('.relSysAutoComplete').ax5autocomplete({
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
        	$(clickTarget).closest('td').find('input.relSys').val(this.value[0].value);
//        	 setValue($('#workAutoComplete'), {value:"", text:""}) 
        },
        onStateChanged: function() {
        	console.log("onStateChanged");
        	
        	if(this.state === "close") {
        		console.log("onState closed");
        		try {
        			var relSys = $(clickTarget).find('[data-ax5autocomplete-selected-text]')[0].innerText;
        		} catch (e) {
        			console.log(e);
        		}
        		$(clickTarget).closest('td').find('input.relSys').val(relSys);
        	}
        }
	});
    
    $('#relSysAutoComplete').on('click', function(e) {
		console.log("autocomplete2.click");
    	clickTarget = this;
    	var targetEl = $(e.target);
    	targetEl.css('z-index', '-100');
    	targetEl.closest('#relSysAutoComplete').find('[data-ax5autocomplete-display="input"]').focus();
	});
	
	//업무분류(대) 셀렉트박스의 값이 변경될때  
	$('select.workLCode').change(function(e){
		//console.log('select changed');
		var target = $(e.target);
		var currWorkLCode = this.value;
//		$('#workLCode').val(currworkLCode);
		currWorkMCode = null;
		currWorkSCode = null;
		setSelectData('M', currWorkLCode, target);
	});
	
	//업무분류(중) 셀렉트박스의 값이 변경될때  
	$('select.workMCode').change(function(e){
		console.log('select changed');
		var target = $(e.target);
		var currWorkMCode = this.value;
		console.log(currWorkMCode);
//		$('#locCode').val(currLocCode);
		currWorkSCode = null;
		setSelectData('S', currWorkMCode, target);
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
		console.log("_saveBtn_ clicked");
		var trEl,
			saveForm;
		try {
			trEl = $($(e.target).closest('tr'));
		} catch(e) {
			console.log(e);
		}
		try {
			saveForm = $(e.target).closest('.regist_form');
		} catch(e) {
			console.log(e);
		}	
		if($(e.target).attr('data-click-target') === 'pjt-save'){
			console.log("target: pjt-save");
			
			if(val_chk(saveForm.find('#relSys').val(), '관련시스템')
					&& val_chk(saveForm.find('#workCode').val(), '업무분류(소)')
					&& val_chk(saveForm.find('#workMCode').val(), '업무분류(중)')
					&& val_chk(saveForm.find('#workLCode').val(), '업무분류(대)')
					&& val_chk(saveForm.find('#workHour').val(), '업무시간')	){
				
//				if (confirm(LN_CONFIRM_SAVE)) {
					mask.open();
					$('#WAK001PjtCreateForm').submit();
//				}
			}
		}else if($(e.target).attr('data-click-target') === 'pjt-modify'){
			
			if(val_chk(trEl.find('input.relSys').val(), '관련시스템')
					&& val_chk(trEl.find('#workCode').val(), '업무분류(소)')
					&& val_chk(trEl.find('#workMCode').val(), '업무분류(중)')
					&& val_chk(trEl.find('#workLCode').val(), '업무분류(대)')
					&& val_chk(trEl.find('#workHour').val(), '업무시간')){
				
				var pjtNum = $(trEl[0]).find('#pjtNum').val();
				var workHour = $(trEl[0]).find('#workHour').val();
				var workCode = $(trEl[0]).find('#workCode').val();
				var workMCode = $(trEl[0]).find('#workMCode').val();
				var workLCode = $(trEl[0]).find('#workLCode').val();
				var relSys = $(trEl[0]).find('input.relSys').val();
				var workTrtr = $(trEl[0]).find('#workTrtr').val();
				var workDtlCnts = $(trEl[0]).find('.workDtlCnts').val();
				var pjtObj = new PjtObj (pjtNum, workCode, workMCode, workLCode, workHour, relSys, workTrtr, workDtlCnts)
				
				var workCodeNm = $(trEl[0]).find('#workCode option:selected').text();
				var workMCodeNm = $(trEl[0]).find('#workMCode option:selected').text();
				var workLCodeNm = $(trEl[0]).find('#workLCode option:selected').text();
				updatePjt(pjtObj);
				//dataSet(e.target, pjtObj, workCodeNm, workMCodeNm, workLCodeNm);
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
	
	var myCalendar1 = new ax5.ui.calendar({
        target: document.getElementById("calendar-target1"),
        control: {
            left: '<i class="fa fa-chevron-left"></i>',
            yearTmpl: '%s',
            monthTmpl: '%s',
            right: '<i class="fa fa-chevron-right"></i>',
            yearFirst: true
        },
        displayDate: (new Date()),
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
            //console.log(this);
            //console.log(myCalendar1.getSelection());
            $(this.target).css('display', 'none');
            $(this.target).prev().val(myCalendar1.getSelection());
//            $('#pjtSearchForm').submit();
        },
        onStateChanged: function () {
            //console.log(this);
        }
    });
	
	var regCalendar = new ax5.ui.calendar({
        target: document.getElementById("regCalendar"),
        control: {
            left: '<i class="fa fa-chevron-left"></i>',
            yearTmpl: '%s',
            monthTmpl: '%s',
            right: '<i class="fa fa-chevron-right"></i>',
            yearFirst: true
        },
        displayDate: (new Date()),
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
            //console.log(this);
            //console.log(myCalendar1.getSelection());
            $(this.target).css('display', 'none');
            $(this.target).prev().val(regCalendar.getSelection());
//            $('#pjtSearchForm').submit();
        },
        onStateChanged: function () {
            //console.log(this);
        }
    });
	
	$('.pjt-wrap .dropdown').on('click', function(e){
		//console.log($(e.target));
		//console.log($($(e.target).next('.dropdown-menu')));
		$($(e.target).next('.dropdown-menu')).css('display', 'block');
	});
	
	$('.pjt-wrap ._searchBtn_').on('click', function(e) {
		$('#pjtSearchForm').submit();
	});
	
	
});

