/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
"use strict";

/**
 * [ko]권한코드 객체
 */
function ActionObj (seq, type, siteName, siteUrl, intro, sort, useTf, etc) {
	this.seq = seq;
	this.type = type;
	this.siteName = siteName;
	this.siteUrl = siteUrl;
	this.intro = intro;
	this.sort = sort;
	this.useTf = useTf;
	this.etc = etc;
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
function updateAction(updateData) {
	var stateMsg,
		ajaxParams = updateData;
	
	$.ajax({
		url : "/ajaxLink/update.do",
		type : "post",
		data : ajaxParams,
		success : function(res) {
			console.log("updateAction.success");
			var data = JSON.parse(res);
			if(data.result === RESULT_OK) {
				stateMsg = RESULT_OK;
			} else {
				console.log("err");
				stateMsg = data.errMsg;
			}
			
		},
		error : function() {
			console.log("updateAction.error");
			stateMsg = "error";
		},
		complete : function() {
			console.log("updateAction.complete");
			console.log("stateMsg:" + stateMsg);
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
	console.log("dataSet()");
	var trEl = $($(btnObj).closest('tr'));
	var targetEl = trEl[0].previousSibling.previousSibling;
	var arrTdEl = $(targetEl).find('td');
	//arrTdEl[2].innerText = dataObj.type;
	if(dataObj.type === 'GLOBAL'){
		arrTdEl[1].innerText = "DENSO 글로벌사이트";
	} else {
		arrTdEl[1].innerText = "MAKER 업무사이트";
	}
	arrTdEl[2].innerText = dataObj.siteName;
	arrTdEl[3].innerText = dataObj.siteUrl;
	arrTdEl[4].innerText = dataObj.intro;
	arrTdEl[5].innerText = dataObj.sort;
	if(dataObj.useTf === 'Y'){
		arrTdEl[6].innerText = "사용";
	} else {
		arrTdEl[6].innerText = "미사용";
	}
	arrTdEl[7].innerText = dataObj.etc;
	trEl.addClass('displayNone');
	$(targetEl).removeClass('displayNone');
}

function deleteAction(deleteSeq) {
	mask.open();
	var stateMsg = "";
	$.ajax({
		url : "/ajaxLink/delete.do",
		type : "get",
		data : {
			"seq" : deleteSeq,
		},
		success : function(res) {
			console.log("deleteAction.success");
			var data = JSON.parse(res);
			if(data.result === "OK") {
				location.reload();
			}
			
		},
		error : function() {
			console.log("deleteAction.error");
			stateMsg = "error";
		},
		complete : function() {
			console.log("deleteAction.complete");
			setTimeout(function() {
				mask.close();
				toastMsg(stateMsg);
			}, 1000);
			
		}
	});
}

$(document.body).ready(function() {
	mask.close();
	
/*	$('._searchBtn_').on('click', function(e) {
		console.log("searchBtn");
		$('#WAD001AuthSearchForm').submit();
	});
*/
	
	$('._addBtn_').on('click', function(e){
		console.log($(e.target).attr('data-click-target'));
		
		//권한그룹등록 버큰
		if($(e.target).attr('data-click-target') === 'action-add'){
			$('.input_tr').toggle();
		}
	});
	$('._saveBtn_').on('click', function(e){
		console.log('saveBtn clicked');
		//ajax 업데이트용 변수처리
		//class명으로 가져옴
		var trEl = $($(e.target).closest('tr'));
		var seq = $(trEl[0]).find('.seq').val();
		var type = $(trEl[0]).find('.type').val();
		var siteName = $(trEl[0]).find('.siteName').val();
		var siteUrl = $(trEl[0]).find('.siteUrl').val();
		var intro = $(trEl[0]).find('.intro').val();
		var sort = $(trEl[0]).find('.sort').val();
		var etc = $(trEl[0]).find('.etc').val();
		
		
		var check_useYn = $(trEl[0]).find('.useYn').is(':checked');
		var useTf;
		if(check_useYn){
			useTf = 'Y'
		} else {
			useTf = 'N'
		}
		
		if( val_chk(siteName, '사이트명')){
			if($(e.target).attr('data-click-target') === 'action-save'){	
				mask.open();
				document.WAC017LinkManagementForm.action="create.do";
	            document.WAC017LinkManagementForm.submit();
				
			}else if($(e.target).attr('data-click-target') === 'action-modify'){
				var actionObj = new ActionObj(seq, type, siteName, siteUrl, intro, sort, useTf, etc);
				updateAction(actionObj);
				dataSet(e.target, actionObj);
			}
		}
	});
	
	$('._modifyBtn_').on( 'click', function(e){
		var trEl = $($(e.target).closest('tr'));
		trEl[0].classList.add('displayNone');
		trEl[0].nextSibling.nextSibling.classList.remove('displayNone');
	});
	
	$('._deleteBtn_').on( 'click', function(e){
		var delSeq= $(e.target).attr('data-click-target');
		var deleteCheck = confirm(LN_CONFIRM_DELETE);
		if(deleteCheck){
			deleteAction(delSeq);
		}
	});
	
	$('._cancelBtn_').on('click', function(e) {
		var tr = $($(e.target).closest('tr')); 
		tr[0].classList.add('displayNone');
		try {
			tr[0].previousSibling.previousSibling.classList.remove('displayNone');
		} catch (e) {
			$(tr[0]).css('display', 'none');
		}
	});
		
});
