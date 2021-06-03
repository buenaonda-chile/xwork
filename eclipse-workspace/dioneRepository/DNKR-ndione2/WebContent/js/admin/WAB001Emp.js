/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
"use strict";

function duplicateCheck(target, params) {
	$.ajax({
		method : "post",
		url : "/ajaxEmp/duplicateCheck.do",
		data : params,
		success : function(res) {
			var data = JSON.parse(res);
			console.log(data);
			if(data.result === RESULT_OK){
				toastMsg(data.result);
			}else if (data.errMsg){
				toastMsg(data.errMsg);
				$('#' + target).val("");
				$('#' + target).focus();
			}
		},
		error : function(res) {
			console.log("error")
			console.log(res)
		},
		complete : function(res) {
			setTimeout(function() {
				mask.close();
			}, 500);
			console.log("completed")
			console.log(res)
		}
	});	
}

function empCheck() {
	console.log("empCheck");
	//
	var check = false; 
	if($('input[name=inOutType]:radio:checked').val() === 'I'){
		console.log('내부직원');
		if(val_chk($('#empNumber').val(), '사원번호') 
				&& val_chk($('#teamCode').val(), '부서(팀)')) {
			check = true;
		}
	} else if($('input[name=inOutType]:radio:checked').val() === 'O'){
		console.log('외부업체');
		if(val_chk($('#empId').val(), '아이디')){
			if( $('#empPwd').val() !== $('#empPwdAgain').val()){
				toastMsg("비밀번호가 일치하지 않습니다.");
			} else if ($('#empPwd').val().trim().length === 0 || $('#empPwdAgain').val().trim().length === 0) {
				toastMsg("비밀번호를 입력하세요.");
			} else {
				check = true;
			
			}
		}
	}
	
	if(check){
		confirm(LN_CONFIRM_SAVE);
		return true;
	}
	return false;
}

/**
 * 팝업창에서 값넘겨받아 부모창에 데이터 set
 * 
 * @param returnValue
 */
function getReturnValue(returnValue) {
	if(returnValue !== null) {
		var relationObj = JSON.parse(returnValue);
		console.log(relationObj.clsRltnCode);
		$('#clsCode').val(relationObj.clsCode);
		$('#clsCode').attr('data-rltnCode', relationObj.clsRltnCode);
		$('#clsCode').prev().val(relationObj.clsName);
		$('#locCode').val(relationObj.locCode);
		$('#locCode').attr('data-rltnCode', relationObj.locRltnCode);
		$('#locCode').prev().val(relationObj.locName);
		$('#teamCode').val(relationObj.teamCode);
		$('#teamCode').prev().val(relationObj.teamName);
		makeEmpId(relationObj.clsRltnCode, relationObj.locRltnCode);
	}
	
}

/**
 * 사업부와 사업장에 따라 아이디생성
 * 
 * @param clsRltnCode
 * @param locRltnCode
 */
function makeEmpId(clsRltnCode, locRltnCode) {
	//더존 회사코드변경시 수정필요
	console.log(clsRltnCode);
	//console.log(locRltnCode);
	var empNum = $('#empNumber').val();
	/*
	if (clsRltnCode === '1000' && locRltnCode === '1000') {
		$('#empId').val('C' + empNum);
	} else if (clsRltnCode === '1000' && locRltnCode === '2000') {
		$('#empId').val('H' + empNum);
	} else if (clsRltnCode === '1000' && locRltnCode === '3000') {
		$('#empId').val('S' + empNum);
	} else if (clsRltnCode === '2000' && locRltnCode === '1000') {
		$('#empId').val('E' + empNum);
	} else {
		$('#empId').val(empNum);
	}

	if ((clsRltnCode === '1000' && locRltnCode === '1000') || (clsRltnCode === 'DENSO' && locRltnCode === '2000')) {
		$('#empId').val('C' + empNum);
	} else if ((clsRltnCode === '1000' && locRltnCode === '2000') || (clsRltnCode === 'DENSO' && locRltnCode === '5000')) {
		$('#empId').val('H' + empNum);
	} else if ((clsRltnCode === '1000' && locRltnCode === '3000') || (clsRltnCode === 'DENSO' && locRltnCode === '3000')) {
		$('#empId').val('S' + empNum);
	} else if ((clsRltnCode === '2000' && locRltnCode === '1000') || (clsRltnCode === 'DENSO' && locRltnCode === '1000')) {
		$('#empId').val('E' + empNum);
	} else if (clsRltnCode === 'DENSO' && locRltnCode === '4000') {
		$('#empId').val('R' + empNum);
	} else {
		$('#empId').val(empNum);
	}
	
	if (clsRltnCode === '1000' && locRltnCode === '2000') {
		$('#empId').val('C' + empNum);
	} else if (clsRltnCode === '1000' && locRltnCode === '5000') {
		$('#empId').val('H' + empNum);
	} else if (clsRltnCode === '1000' && locRltnCode === '3000') {
		$('#empId').val('S' + empNum);
	} else if (clsRltnCode === '2000' && locRltnCode === '1000') {
		$('#empId').val('E' + empNum);
	} else if (clsRltnCode === '3000' && locRltnCode === '4000') {
		$('#empId').val('R' + empNum);
	} else {
		$('#empId').val(empNum);
	}
	
	if ((clsRltnCode === '1000' && locRltnCode === '2000') || (clsRltnCode === 'DENSO' && locRltnCode === '2000')) {
		$('#empId').val('C' + empNum);
	} else if ((clsRltnCode === '1000' && locRltnCode === '5000') || (clsRltnCode === 'DENSO' && locRltnCode === '5000')) {
		$('#empId').val('H' + empNum);
	} else if ((clsRltnCode === '1000' && locRltnCode === '3000') || (clsRltnCode === 'DENSO' && locRltnCode === '3000')) {
		$('#empId').val('S' + empNum);
	} else if ((clsRltnCode === '2000' && locRltnCode === '1000') || (clsRltnCode === 'DENSO' && locRltnCode === '1000')) {
		$('#empId').val('E' + empNum);
	} else if ((clsRltnCode === '3000' && locRltnCode === '4000') || (clsRltnCode === 'DENSO' && locRltnCode === '4000')) {
		$('#empId').val('R' + empNum);
	} else {
		$('#empId').val(empNum);
	}
	
	*/
	/*
    // 2020.06.18 삭제
	if ((clsRltnCode === '1000' && locRltnCode === '2000') || (clsRltnCode === 'DENSO' && locRltnCode === '2000')) {
		$('#empId').val('C' + empNum);
	} else if ((clsRltnCode === '1000' && locRltnCode === '5000') || (clsRltnCode === 'DENSO' && locRltnCode === '5000')) {
		$('#empId').val('H' + empNum);
	} else if ((clsRltnCode === '1000' && locRltnCode === '3000') || (clsRltnCode === 'DENSO' && locRltnCode === '3000')) {
		$('#empId').val('S' + empNum);
	} else if ((clsRltnCode === '2000' && locRltnCode === '1000') || (clsRltnCode === 'DENSO' && locRltnCode === '1000')) {
		$('#empId').val('E' + empNum);
	} else if ((clsRltnCode === '3000' && locRltnCode === '4000') || (clsRltnCode === 'DENSO' && locRltnCode === '4000')) {
		$('#empId').val('R' + empNum);
	} else {
		$('#empId').val(empNum);
	}
	*/

	//2020.06.18 GCI-AD 변경 : 사업부코드(E/C/S/H/R) → 국가코드(40004)
	if ((clsRltnCode === '1000' && locRltnCode === '2000') || (clsRltnCode === 'DENSO' && locRltnCode === '2000')) {
		$('#empId').val('40004' + empNum);
	} else if ((clsRltnCode === '1000' && locRltnCode === '5000') || (clsRltnCode === 'DENSO' && locRltnCode === '5000')) {
		$('#empId').val('40004' + empNum);
	} else if ((clsRltnCode === '1000' && locRltnCode === '3000') || (clsRltnCode === 'DENSO' && locRltnCode === '3000')) {
		$('#empId').val('40004' + empNum);
	} else if ((clsRltnCode === '2000' && locRltnCode === '1000') || (clsRltnCode === 'DENSO' && locRltnCode === '1000')) {
		$('#empId').val('40004' + empNum);
	} else if ((clsRltnCode === '3000' && locRltnCode === '4000') || (clsRltnCode === 'DENSO' && locRltnCode === '4000')) {
		$('#empId').val('40004' + empNum);
	} else {
		$('#empId').val(empNum);
	}
	
}


function pwdCheck() {
	console.log('aaaa');
	var check = false;
	if( $('#empPwd').val() !== $('#empPwdAgain').val()){
		toastMsg("비밀번호가 일치하지 않습니다.");
	} else if ($('#empPwd').val().trim().length === 0 || $('#empPwdAgain').val().trim().length === 0) {
		toastMsg("비밀번호를 입력하세요.");
	} else {
		check = true;
	
	}
	
	if(check){
		if(confirm("비밀번호를 변경하시겠습니까?")){
			updatePwd();
		}
		return true;
	}
	return false;
}

function updatePwd() {
	mask.open();
	var stateMsg ="";
	$.ajax({
		method : "post",
		url : "/ajaxEmp/update.do",
		data : {
			"empNumber" : $('#pwdEmp').val(),
			"empPwd" : $('#empPwd').val(),
		},
		success : function(res) {
			console.log('res:' + res);
			var data = JSON.parse(res);
			if(data.result === RESULT_OK) {
				stateMsg = RESULT_OK;
			} else {
				console.log("err");
				stateMsg = data.errMsg;
			}
		},
		error : function(res) {
			console.log(res);
			stateMsg = "error";
		},
		complete : function(res) {
			setTimeout(function() {
				mask.close();
				toastMsg(stateMsg);
				$("#pwdWrap").fadeOut(300);	
				$('#empPwd').val("");
				$('#empPwdAgain').val("");
				
			}, 500);
			console.log(res);
		}
		
	});
}

//내부직원, 외부업체에 따라 디스플레이 필드 초기화
function empfieldInit (inOutTypeValue) {
	//외부업체
	if(inOutTypeValue === 'O'){
		//사원번호 입력란 readOnly로 변경 및 임의생성 알림 display
		$('#empNumber').attr('readonly', true);
		$('#empNumber').val('자동생성');
		$('#empNumber').next().removeClass('displayNone');
		$('#empNumber').closest('div').next().addClass('displayNone');
		$('#empNumber').closest('div').next().removeClass('inlineBlock');
		//$('#empNumberD').attr('required', false);
		$('#empId').attr('readonly', false);
		$('#empId').next().addClass('displayNone');
		$('#empId').closest('div').next().addClass('inlineBlock');
		$('#empId').closest('div').next().removeClass('displayNone');
		
		//비번 활성화
		$('#empPwd').attr('disabled', false);
		$('.pwdTr').removeClass('displayNone');
		$('.pwdTr').next().removeClass('displayNone');
		
		//사업부 display none
		$('#clsCode').attr('disabled', true);
		$('#locCode').attr('disabled', true);
		$('#teamCode').attr('disabled', true);
		$('#clsCode').closest('tr').addClass('displayNone');
		$('#locCode').closest('tr').addClass('displayNone');
		$('#teamCode').closest('tr').addClass('displayNone');
		
		//협력업체(납품공장, 사업바번호) - 활성화
		$('#relationCopLoc').attr('disabled', false);
		$('#relationCopNo').attr('disabled', false);
		$('#relationCopLoc').closest('tr').removeClass('displayNone');
		$('#relationCopNo').closest('tr').removeClass('displayNone');
		
		
	//내부직원	
	} else {
		//아이디 입력란 readOnly로 변경 및 자동생성 알림 display
		$('#empNumber').attr('readonly', false);
		$('#empNumber').val('');
		$('#empNumber').next().addClass('displayNone');
		$('#empNumber').closest('div').next().addClass('inlineBlock');
		$('#empNumber').closest('div').next().removeClass('displayNone');
		$('#empNumber').attr('required', true);
		$('#empId').attr('readOnly', true);
		$('#empId').next().removeClass('displayNone');
		$('#empId').closest('div').next().addClass('displayNone');
		$('#empId').closest('div').next().removeClass('inlineBlock');
		
		//비번 비활성화
		$('#empPwd').attr('disabled', true);
		$('.pwdTr').addClass('displayNone');
		$('.pwdTr').next().addClass('displayNone');
		
		//사업부 display
		$('#clsCode').attr('disabled', false);
		$('#locCode').attr('disabled', false);
		$('#teamCode').attr('disabled', false);
		$('#clsCode').closest('tr').removeClass('displayNone');
		$('#locCode').closest('tr').removeClass('displayNone');
		$('#teamCode').closest('tr').removeClass('displayNone');
		
		//협력업체(납품공장, 사업바번호)

		$('#relationCopLoc').attr('disabled', true);
		$('#relationCopNo').attr('disabled', true);
		$('#relationCopLoc').closest('tr').addClass('displayNone');
		$('#relationCopNo').closest('tr').addClass('displayNone');
	}
}

$(function(){
	$('._authConfigBtn_').on( 'click', function(e){
		var empNumber = e.target.getAttribute('data-click-target') || "";
		//아래 링크 삭제해도 될듯 중복처리되어 있음(WAB004EmpUpdate.jsp). - 제환복
		window.open("/WAD005PrivateAuthConfig/init.do?empNumber="+empNumber,"new","width=950,height=700,scrollbars=yes,top=100,left=100");
	});
	
	$('._deleteBtn_').on( 'click', function(e){
		var check = confirm(LN_CONFIRM_DELETE);
		if(check) {
			var menu = $(e.target).attr('data-menu');
			var delEmpNumber = $(e.target).attr('data-click-target');
			//location.replace("/WAB001EmpSearch/delete.do?menu=" + menu + "&empNumber="+delEmpNumber);
			if(menu === '2'){
				location.replace("/WAB001EmpSearch/delete.do?menu=" + menu + "&empNumber="+delEmpNumber);
			}else{
				location.replace("/WAB007RelationCompanySearch/delete.do?menu=" + menu + "&empNumber="+delEmpNumber);
			}
		} 
	});
	//2018.11.22추가
	$('._ssoBtn_').on( 'click', function(e){
		var empNumber = $(e.target).attr('data-id');
		var chkCompany = $(e.target).attr('data-company');
		var pChangeCompany = $(e.target).attr('data-company');
		
		var pCompany = "";	//사업부
		//alert(chkCompany+"===" +this.item.clsCode);
		if(chkCompany=="CLS000001"){
			pCompany="PS";
		}else if(chkCompany=="CLS000002"){
			pCompany="PE";
		}else if(chkCompany=="CLS000003"){
			pCompany="KR";
		}
		window.open("/WAD012SsoAuthConfig/init.do?empNumber="+empNumber+"&company="+pCompany+"&changeCompany="+pChangeCompany,"new","width=950,height=700,scrollbars=yes,top=100,left=100");
	});
	
	//내부직원 외부업체 구분에 따른 패스워드 입력란 디스플레이 유무
	$('input[name=inOutType]:radio').on('change', function() {
		console.log('inOutType change');
		var inOutTypeValue = this.value;
		empfieldInit(inOutTypeValue)
	});
	
	$('._duplicateCheckBtn_').on('click', function() {
		mask.open();
		var target = $(this).attr('data-click-target');
		var targetObj = $('#' + target);
		var params = {};
		if(val_chk(targetObj.val(), target)){
			
			if(target === 'empNumber') {
				params = {
						empNumber : targetObj.val(),
				};
			} else if(target === 'empId') {
				params = {
						empId : targetObj.val(),
				};
			}
			duplicateCheck(target, params);
		} else {
			mask.close();
		}
		
	});
	
	$('._deptBtn_').on('click', function() {
		window.open("/WAD009RelationPopSelect/init.do","relationPop","width=900,height=700,scrollbars=yes,top=100,left=100");
	});
});