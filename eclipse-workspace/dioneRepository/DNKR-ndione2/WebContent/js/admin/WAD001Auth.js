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
function AuthObj (authCode, authName, authDescription, useYn) {
	this.authCode = authCode;
	this.authName = authName;
	this.authDescription = authDescription;
	this.useYn = useYn;
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
function updateAuth(updateData) {
	var stateMsg,
		ajaxParams = updateData;
	
	$.ajax({
		url : "/ajaxAuth/update.do",
		type : "post",
		data : ajaxParams,
		success : function(res) {
			console.log("updateAuth.success");
			var data = JSON.parse(res);
			if(data.result === RESULT_OK) {
				stateMsg = RESULT_OK;
			} else {
				console.log("err");
				stateMsg = data.errMsg;
			}
			
		},
		error : function() {
			console.log("updateAuth.error");
			stateMsg = "error";
		},
		complete : function() {
			console.log("updateAuth.complete");
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
	arrTdEl[1].innerText = dataObj.authName;
	arrTdEl[2].innerText = dataObj.authDescription;
	if(dataObj.useYn === 'Y'){
		arrTdEl[3].innerText = "사용";
	} else {
		arrTdEl[3].innerText = "미사용";
	}
	trEl.addClass('displayNone');
	$(targetEl).removeClass('displayNone');
}

function deleteAuth(deleteAuthCode) {
	mask.open();
	var stateMsg = "";
	$.ajax({
		url : "/ajaxAuth/delete.do",
		type : "get",
		data : {
			"authCode" : deleteAuthCode,
		},
		success : function(res) {
			console.log("deleteAuth.success");
			var data = JSON.parse(res);
			if(data.result === "OK") {
				location.reload();
			}
			
		},
		error : function() {
			console.log("deleteAuth.error");
			stateMsg = "error";
		},
		complete : function() {
			console.log("deleteAuth.complete");
			setTimeout(function() {
				mask.close();
				toastMsg(stateMsg);
			}, 1000);
			
		}
	});
}

$(document.body).ready(function() {
	mask.close();
	
	$('._searchBtn_').on('click', function(e) {
		console.log("searchBtn");
		$('#WAD001AuthSearchForm').submit();
	});
	
	$('._addBtn_').on('click', function(e){
		console.log($(e.target).attr('data-click-target'));
		
		//권한그룹등록 버큰
		if($(e.target).attr('data-click-target') === 'auth-add'){
			$('.input_tr').toggle();
		}
	});
	$('._saveBtn_').on('click', function(e){
		console.log('saveBtn clicked');
		var trEl = $($(e.target).closest('tr'));
		var authCode = $(trEl[0]).find('.authCode').val();
		var authName = $(trEl[0]).find('.authName').val();
		var authDescription = $(trEl[0]).find('.authDescription').val();
		var check_useYn = $(trEl[0]).find('.useYn').is(':checked');
		var useYn;
		
		if(check_useYn){
			useYn = 'Y'
		} else {
			useYn = 'N'
		}
		
		if( val_chk(authName, '권한그룹명')){
			if($(e.target).attr('data-click-target') === 'auth-save'){	
				mask.open();
				var createForm = $('#WAD001AuthCreateForm');
				createForm.children('.authName').val(authName);
				createForm.children('.authDescription').val(authDescription);
				createForm.children('.useYn').val(useYn);
				createForm.submit();				
				
			}else if($(e.target).attr('data-click-target') === 'auth-modify'){
				var authObj = new AuthObj(authCode, authName, authDescription, useYn);
				updateAuth(authObj);
				dataSet(e.target, authObj);
			}
		}
	});
	
	/*$('._saveBtn_').on('click', function(e){
		if($(e.target).attr('data-click-target') === 'auth-save'){
			if(val_chk($('#authName').val(), '권한그룹명')){
				mask.open();
				$('#WAD001AuthCreateForm').submit();
			}
		}else if($(e.target).attr('data-click-target') === 'auth-modify'){
			console.log("modify");
			var trEl = $($(e.target).closest('tr'));
			var authCode = $(trEl[0]).find('.authCode').val();
			var authName = $(trEl[0]).find('.authName').val();
			var authDescription = $(trEl[0]).find('.authDescription').val();
			var check_useYn = $(trEl[0]).find('.useYn').is(':checked');
			var useYn;
			
			if(check_useYn){
				useYn = 'Y'
			} else {
				useYn = 'N'
			}
			
			if(val_chk(authName, '권한그룹명')){
				var authObj = new AuthObj(authCode, authName, authDescription, useYn);
				updateAuth(authObj);
				dataSet(e.target, authObj);
				
			}
		}
	});*/
	
	$('._modifyBtn_').on( 'click', function(e){
		var trEl = $($(e.target).closest('tr'));
		trEl[0].classList.add('displayNone');
		trEl[0].nextSibling.nextSibling.classList.remove('displayNone');
	});
	
	$('._deleteBtn_').on( 'click', function(e){
		var delAuthCode = $(e.target).attr('data-click-target');
		var deleteCheck = confirm(LN_CONFIRM_DELETE);
		if(deleteCheck){
			deleteAuth(delAuthCode);
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
	
	$('._authConfigBtn_').on( 'click', function(e){
		var authCode = e.target.getAttribute('data-click-target');
		var menu = e.target.getAttribute('data-menu');
//		console.log("authCode:" + authCode);
		window.open("/WAD005AuthConfig/init.do?authCode="+authCode,"new","width=950,scrollbars=yes,height=700,top=100,left=100");
	});
	
});