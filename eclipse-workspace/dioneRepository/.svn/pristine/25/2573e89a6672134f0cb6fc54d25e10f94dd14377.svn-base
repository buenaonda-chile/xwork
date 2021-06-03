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
function ActionObj (seq, sysSeq, company, sysName, sysUrl, sysUrl2, sysType, popupYn, inOutType, loginYn, popupW, popupH, subYn, useTf, ssoTf) {
	this.seq = seq;
	this.sysSeq = sysSeq;
	this.company = company;
	this.sysName = sysName;
	this.sysUrl = sysUrl;
	this.sysUrl2 = sysUrl2;
	this.sysType = sysType;
	this.popupYn = popupYn;
	this.inOutType = inOutType;
	this.loginYn = loginYn;
	this.popupW = popupW;
	this.popupH = popupH;
	this.subYn = subYn;
	this.useTf = useTf;
	this.ssoTf = ssoTf;

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
		url : "/ajaxLinkSso/update.do",
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
	
	arrTdEl[1].innerText = dataObj.sysSeq;

	if(dataObj.company === 'CLS000002'){
		arrTdEl[2].innerText = "구KE";
	} else if(dataObj.company === 'CLS000001'){
		arrTdEl[2].innerText = "구KA";
	} else if(dataObj.company === 'CLS000004'){
		arrTdEl[2].innerText = "공통";
	}
	arrTdEl[3].innerText = dataObj.sysName;
	arrTdEl[4].innerText = dataObj.sysUrl;
	arrTdEl[5].innerText = dataObj.sysUrl2;
	arrTdEl[6].innerText = dataObj.sysType;
	arrTdEl[7].innerText = dataObj.popupYn;
	if(dataObj.inOutType === 'O'){
		arrTdEl[8].innerText = "외부";
	} else {
		arrTdEl[8].innerText = "내부";
	}
	arrTdEl[9].innerText = dataObj.loginYn;
	arrTdEl[10].innerText = dataObj.popupW;
	arrTdEl[11].innerText = dataObj.popupH;
	if(dataObj.subYn === 'Y'){
		arrTdEl[12].innerText = "사용";
	} else {
		arrTdEl[12].innerText = "미사용";
	}
	if(dataObj.useTf === 'Y'){
		arrTdEl[13].innerText = "사용";
	} else {
		arrTdEl[13].innerText = "미사용";
	}
	if(dataObj.ssoTf === 'Y'){
		arrTdEl[14].innerText = "사용";
	} else {
		arrTdEl[14].innerText = "미사용";
	}
	
	trEl.addClass('displayNone');
	$(targetEl).removeClass('displayNone');
}

function deleteAction(deleteSeq) {
	mask.open();
	var stateMsg = "";
	$.ajax({
		url : "/ajaxLinkSso/delete.do",
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
		var sysSeq = $(trEl[0]).find('.sysSeq').val();
		var company = $(trEl[0]).find('.company').val();
		var sysName = $(trEl[0]).find('.sysName').val();
		var sysUrl = $(trEl[0]).find('.sysUrl').val();
		var sysUrl2 = $(trEl[0]).find('.sysUrl2').val();
		var sysType = $(trEl[0]).find('.sysType').val();		
		var check_popupYn = $(trEl[0]).find('.popupYn').is(':checked');
		var popupYn;
		if(check_popupYn){
			popupYn = 'Y';
		} else {
			popupYn = 'N';
		}
		var inOutType = $(trEl[0]).find('.inOutType').val();
		var check_loginYn = $(trEl[0]).find('.loginYn').is(':checked');
		var loginYn;
		if(check_loginYn){
			loginYn = 'Y';
		} else {
			loginYn = 'N';
		}
		var popupW = $(trEl[0]).find('.popupW').val();
		/*if(inOutType != "I" || popupW.length==0){
			$(trEl[0]).find('.popupW').val("1024");			
		}*/
		var popupH = $(trEl[0]).find('.popupH').val();
		/*
		if(popupH.length==0){
			$(trEl[0]).find('.popupH').val("768");			
		}*/
		var check_subYn = $(trEl[0]).find('.subYn').is(':checked');
		var subYn;
		if(check_subYn){
			subYn = 'Y';
		} else {
			subYn = 'N';
		}
		var check_useYn = $(trEl[0]).find('.useYn').is(':checked');
		var useTf;
		if(check_useYn){
			useTf = 'Y';
		} else {
			useTf = 'N';
		}		
		var check_ssoTf = $(trEl[0]).find('.ssoTf').is(':checked');
		var ssoTf;
		if(check_ssoTf){
			ssoTf = 'Y';
		} else {
			ssoTf = 'N';
		}
		//console.log(popupH+"===" +check_ssoTf +"===" +ssoTf);
		if( val_chk(sysName, '시스템명')){
			if($(e.target).attr('data-click-target') === 'action-save'){	
				mask.open();
				//alert("check_popupYn==="+popupYn+"=="+$('input[name=popupYn]:checkbox:checked').val());
				
				//alert(document.WAC019SsoManagementForm.popupYn.value);
				/*document.WAC019SsoManagementForm.action="create.do";
				document.WAC019SsoManagementForm.method = "POST";
	            document.WAC019SsoManagementForm.submit();*/

			    $("#WAC019SsoManagementForm").attr("action", 'create.do');
			    $("#WAC019SsoManagementForm").submit();
			}else if($(e.target).attr('data-click-target') === 'action-modify'){
				var actionObj = new ActionObj(seq, sysSeq, company, sysName, sysUrl, sysUrl2, sysType, popupYn, inOutType, loginYn, popupW, popupH, subYn, useTf, ssoTf);
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
