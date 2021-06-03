/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */

"use strict";
var currClsCode,
currLocCode,
currTeamCode;

function setData(type, relationCode){
	//console.log("setData()");
	$.ajax({
		method : "post",
		url : "/ajaxRelation/init.do",
		data : {
			type: type,
			parentCode: relationCode,			
		},
		success : function(res) {
			//console.log(res);
			var data = JSON.parse(res);
			if (data.list.length > 0) {
				
				//조회 select 외의 데이터 초기화
				if(type === "LOC") {
//					teamCode 리스트 초기화
					$('select.teamCode').html('<option value="">부서(팀)전체</option>');
					var listStr = "<option value=''>사업장전체</option>";
					data.list.forEach(function(item, index){
						listStr += '<option value="'+ item.relationCode +'">'+item.relationName+'</option>';	
					});
					
					$('select.locCode').html(listStr);
				} else if(type === "TEAM") {
					var listStr = "<option value=''>부서(팀)전체</option>";
					data.list.forEach(function(item, index){
						listStr += '<option value="'+ item.relationCode +'">'+item.relationName+'</option>';	
					});
					
					$('select.teamCode').html(listStr);
				}
				setTimeout(function() {
					mask.close();
				}, 1000);
			} else {
				
				//하위그리드 데이터 조회일 때 초기화
				if(type === "LOC") {
//					locCode에 리스트 초기화
					$('select.locCode').html("<option value=''>사업장전체</option>");
//					teamCode에 리스트 초기화
					$('select.teamCode').html("<option value=''>부서(팀)전체</option>");
					
					//사업부서 등록 시 상위코드로 사용할 사업장 코드 초기화
					currLocCode = "";
					
				} else if(type === "TEAM"){
//					teamCode에 리스트 초기화
					$('select.teamCode').html("<option value=''>부서(팀)전체</option>");
				}
				
				setTimeout(function() {
					mask.close();
					toastMsg("데이터가 없습니다.");
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


$(document.body).ready(function() {
	//등록폼 닫기버튼
	$("._workSortManage_").on("click",function(e){
		var teamCode = e.target.getAttribute('data-click-target');
		window.open("/WAK005WorkSortSearch/workSortSearchPop.do?teamCode="+teamCode,"workSortSearchPop","width=1253,height=700,scrollbars=yes,top=100,left=100");
	});
	
	//사업부 셀렉트박스의 값이 변경될때  
	$('select.clsCode').change(function(){
		//console.log('select changed');
		var currClsCode = this.value;
		$('#clsCode').val(currClsCode);
		currLocCode = null;
		currTeamCode = null;
		setData('LOC', currClsCode);
	});
	
	//사업장 셀렉트박스의 값이 변경될때  
	$('select.locCode').change(function(){
		//console.log('select changed');
		var currLocCode = this.value;
		$('#locCode').val(currLocCode);
		currTeamCode = null;
		setData('TEAM', currLocCode);
	});
	
	//사업부서(팀) 셀렉트박스의 값이 변경될때  
	$('select.teamCode').change(function(){
		//consoleo.log('aa');
		var teamClsCode = this.value;
		$('#teamCode').val(teamClsCode);
		//console.log('select changed');
	});

});