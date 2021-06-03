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
	//패스워드란이 활성화 되어 있으면
	//게시판명 데이터 확인
	if ($('#boardNm').val().trim().length === 0 ) {
		toastMsg("게시판명을 입력하세요.");
		return false;
	}
	
	//데이터노출수 데이터 확인
	if ($('#rowCnt').val().trim().length === 0 ) {
		toastMsg("데이터노출수를 입력하세요.");
		return false;
	}
	
	//페이지노출수 데이터 확인
	if ($('#pageCnt').val().trim().length === 0 ) {
		toastMsg("페이지노출수를 입력하세요.");
		return false;
	}
	
	var check = confirm(LN_CONFIRM_SAVE);
	
	if(check){
		console.log('true');
		return true;
	}
	return false;
}

$(function(){
	
	$('._deleteBtn_').on( 'click', function(e){
		var check = confirm(LN_CONFIRM_DELETE);
		if(check) {
			var delBoardId = $(e.target).attr('data-click-target');
			location.replace("/WAC001BoardSearch/infoDelete.do?boardId="+delBoardId);
		} 
	});
});