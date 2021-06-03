/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
"use strict";

function boardCheck() {
	console.log("boardCheck");
	obj.getById["cnts"].exec("UPDATE_CONTENTS_FIELD", []);
	//패스워드란이 활성화 되어 있으면
	//작성자 데이터 확인
	if ($('#writer').val().trim().length === 0 ) {
		toastMsg("작성자명을 입력하세요.");
		return false;
	}
	
	//비밀번호 데이터 확인
	if($('#pwd').size() > 0){
		if ($('#pwd').val().trim().length === 0 ) {
			toastMsg("비밀번호를 입력하세요.");
			return false;
		}
		
		if($('#secretYnChk').is(':checked')){
			$('#secretYn').val('Y');
		}else{
			$('#secretYn').val('N');
		}
	}
	
	
	//제목 데이터 확인
	if ($('#title').val().trim().length === 0 ) {
		toastMsg("제목을 입력하세요.");
		return false;
	}
	
	//내용 데이터 확인
	if ($('#cnts').val().trim().length === 0 ) {
		toastMsg("내용을 입력하세요.");
		return false;
	}
	
	if($('#noticeYnChk').is(':checked')){
		$('#noticeYn').val('Y');
	}else{
		$('#noticeYn').val('N');
	}
	
	var check = confirm(LN_CONFIRM_SAVE);
	
	if(check){
		console.log('true');
		return true;
	}
	return false;
}

function downFile(fidx, idx){
	var frm = document.file_form;
	frm.fidx.value = fidx;
	frm.idx.value = idx;
	frm.submit();
}

/**
 * 팝업창에서 값넘겨받아 부모창에 데이터 set
 * 
 * @param returnValue
 */
var circulation_num = 0;
//회람자란에 데이터추가.
function getReturnValue(returnValue) {
	if(returnValue !== null) {
		var circulationObj = JSON.parse(returnValue);
		var circulation_div = $('#circulationIdTxt');
		var circulation_EmpId = $('#circulation_Id');//hidden값
		var circulation_btn = $('#circulationAddBtn');
		var circulation_num_val = $('#circulation_num');
		
		var empId = circulation_EmpId.val();
		
		var div_html=circulation_div.html();
		var chk = [];
		
		if(circulation_num_val.val() != 0 || circulation_num_val.val() != null){
			circulation_num = circulation_num_val.val() - 1 ;
		}else{
			circulation_num = 0;
		}
		
		for (var i=0; i < circulationObj.length; i++){
			var circulation = circulationObj[i].split('/');
			//circulation[0]	=>	empName
			//circulation[1]	=>	empId
			//circulation[2]	=>	teamCode
			
			var emp_chk = empId.split(',');//중복일때는 다시 안올라오게.
			for(var t = 0; t<emp_chk.length;t++){
				var emp_div = emp_chk[t].split('/');
				//emp_div[1] => emp_id
				console.log("ee : "+emp_div[1]);
				if(emp_div[1] == circulation[1]){
					circulationObj[i] = "";
				}
			}
			if(circulationObj[i] != ""){
				circulation_num++;
				circulationObj[i] =  circulationObj[i].replace(/(\s*)/g,"");
				empId += circulationObj[i]+",";
				console.log("jebal..."+circulationObj[i]);
				div_html	+=	"<a href='#' id=del_circulation"+circulation_num+" name="+circulationObj[i]+">";
				div_html	+=	"<span>";
				div_html	+=		circulation[0];
				div_html	+=	"</span>";
				div_html	+=	"&nbsp";
				div_html	+=	"<i class='axi axi-cancel' onclick='del_circulation("+circulation_num+",2);'></i>";
				div_html	+=	"&nbsp";
				div_html	+=	"</a>";
			}
		}
		circulation_num_val.val(circulation_num+1);
		var Addbtn = circulation_btn.html();
		var Addbtn_html = '';
		Addbtn_html += '<button type="button" onclick="all_delete(2);" class="AXButton Normal">';
		Addbtn_html += '전체삭제';
		Addbtn_html += '</button>';
		
		circulation_EmpId.val(empId);
		
		circulation_div.html(div_html);
		circulation_btn.html(Addbtn_html);
	}
}
function getReturnTeamValue(returnValue) {
	if(returnValue !== null) {
		var circulationObj = JSON.parse(returnValue);
		var circulation_div = $('#circulationIdTxt_Team');
		var circulation_EmpId = $('#circulation_Id_Team');//hidden값
		var circulation_btn = $('#circulationAddBtn_Team');
		var circulation_num_val = $('#circulation_num_Team');
		
		var empId = circulation_EmpId.val();
		
		var div_html=circulation_div.html();
		var chk = [];
		
		if(circulation_num_val.val() != 0 || circulation_num_val.val() != null){
			circulation_num = circulation_num_val.val() - 1 ;
		}else{
			circulation_num = 0;
		}
		
		for (var i=0; i < circulationObj.length; i++){
			var circulation = circulationObj[i].split('/');
//			console.log(i + " 0 : " + circulation[0]);
//			console.log(i + " 1 : " + circulation[1]);
			//circulation[0]	=>	empName
			//circulation[1]	=>	empId
			//circulation[2]	=>	teamCode
			
			var emp_chk = empId.split(',');//중복일때는 다시 안올라오게.
			for(var t = 0; t<emp_chk.length;t++){
				var emp_div = emp_chk[t].split('/');
				//emp_div[1] => emp_id
				if(emp_div[1] == circulation[1]){
					circulationObj[i] = "";
				}
			}
			if(circulationObj[i] != ""){
				circulation_num++;
				circulationObj[i] =  circulationObj[i].replace(/(\s*)/g,"");
				empId += circulationObj[i]+",";
				div_html	+=	"<a href='#' id=del_circulation_Team"+circulation_num+" name="+circulationObj[i]+">";
				div_html	+=	"<span>";
				div_html	+=		circulation[0];
				div_html	+=	"</span>";
				div_html	+=	"&nbsp";
				div_html	+=	"<i class='axi axi-cancel' onclick='del_circulation("+circulation_num+",1);'></i>";
				div_html	+=	"&nbsp";
				div_html	+=	"</a>";
			}
		}
		circulation_num_val.val(circulation_num+1);
		var Addbtn = circulation_btn.html();
		var Addbtn_html = '';
		Addbtn_html += '<button type="button" onclick="all_delete(1);" class="AXButton Normal">';
		Addbtn_html += '전체삭제';
		Addbtn_html += '</button>';
		
		circulation_EmpId.val(empId);
		
		circulation_div.html(div_html);
		circulation_btn.html(Addbtn_html);
	}
}

//회람자 전체삭제
function all_delete(type){
	if(type == 1){	// 팀별 선택
		var circulation_div = $('#circulationIdTxt_Team');
		var circulation_EmpId = $('#circulation_Id_Team');
		var circulation_btn = $('#circulationAddBtn_Team');
		
	}else if(type == 2){	// 개인별 선택
		var circulation_div = $('#circulationIdTxt');
		var circulation_EmpId = $('#circulation_Id');
		var circulation_btn = $('#circulationAddBtn');
	}
	circulation_div.html("");
	circulation_EmpId.val("");
	circulation_btn.html("");
}

//회람자 사원명 클릭시 삭제
function del_circulation(circulation_num, type){
	if(type == 1){
		var delete_html = $('#del_circulation_Team'+circulation_num);
		var circulation_hidden = $('#circulation_Id_Team');
		var circulation_btn = $('#circulationAddBtn_Team');		
	}else if (type == 2){
		var delete_html = $('#del_circulation'+circulation_num);
		var circulation_hidden = $('#circulation_Id');
		var circulation_btn = $('#circulationAddBtn');
	}

	var delete_name = delete_html.attr('name');
	var hidden = circulation_hidden.val();
	
	hidden = hidden.replace(delete_name+",","");
	
	delete_html.html("");
	circulation_hidden.val(hidden);
	if(hidden == ""){
		circulation_btn.html("");
	}
}

$(function(){
	
	$('._deleteBtn_').on( 'click', function(e){
		var check = confirm(LN_CONFIRM_DELETE);
		if(check) {
			var delBoardId = $(e.target).attr('data-click-target');
			location.replace("/WAC001BoardSearch/infoDelete.do?boardId="+delBoardId);
		} 
	});
	
	$('._circulatorBtn_').on('click', function() {
		var openPop = window.open("/WAC005BoardPop/empListPop.do","circulatorPop","width=1100,height=700,scrollbars=yes,top=100,left=100");
		openPop.focus();
	});	
	$('._circulatorBtn_Team').on('click', function() {
		var openPop = window.open("/WAC005BoardPop/empListTeamPop.do","circulatorPop","width=1100,height=700,scrollbars=yes,top=100,left=100");
		openPop.focus();
	});
	
	//저장버튼 클릭
	$('._saveBtn_PopList').on('click', function(){
		//console.log("_saveBtn_ clicked");
		
		var check = confirm(LN_CONFIRM_SAVE);
		if(check){
			alert("test");
			//self.close(); 
			var DATA;
		      $('input:checkbox[name=empNumList[]]').each(function() {
		          if($(this).is(':checked'))
		             DATA += "|"+($(this).val());
		       });
		      alert(DATA);
		}
	});
});