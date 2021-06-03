/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */

"use strict";

function addFile(num){
	var obj = '<input type="file" class="input_text" name="upfile' + num + '" style="width:70%;height:25px;border:1px solid #ddd;margin-right:10px;" title="첨부하실 파일을 선택해주세요">';
	$('#fileTd').append(obj);
}

function delFile(obj, fidx){
	
	
	$.ajax({
		url : "/ajaxBoard/fileDelete.do",
		type : "post",
		data : {fidx : fidx},
		success : function(res) {
			var data = JSON.parse(res);
			var result = data.result;
			
			$(obj).prev().remove();
			$(obj).remove();
			chkAdd();
			
		},
		error : function() {
			console.log("fileDelete.error");
			stateMsg = "error";
		},
		complete : function() {
			console.log("fileDelete.complete");
			
		}
	});	
	
	
}

function test(obj, fidx){
	$.ajax({
		url : "/ajaxBoard/test.do",
		type : "post",
		data : {fidx : fidx},
		success : function(res) {
			var data = JSON.parse(res);
			var result = data.result;
			
			alert(result);
		},
		error : function() {
			console.log("test.error");
			stateMsg = "error";
		},
		complete : function() {
			console.log("test.complete");
		}
	});		
}

function chkAdd(){
	var fileNum = $('#fileNum').val();
	var fileCnt = $('input[type=file]').size();
	
	console.log(fileNum + ' , ' + fileCnt);
	if(fileNum > fileCnt){
		addFile(fileNum + 1);
	}
}

$(document.body).ready(function () {
	var obj = $('#cntsTmp');
	if(obj){
		$('#cnts').val(obj.val());
	}
});