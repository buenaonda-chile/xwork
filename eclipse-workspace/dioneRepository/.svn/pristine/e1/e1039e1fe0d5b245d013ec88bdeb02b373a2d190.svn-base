/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
"use strict";

var itemObj = null;
var currGridIndex,
    dataLength = 0;

/**
 * [ko]객체
 * @param type  
 * @param itnbr
 * @param itdsc
 * @param useYn
 */
function ItemObj (itnbr, itdsc) {
	this.itnbr = itnbr;
	this.itdsc = itdsc;
}

/**
 * [KO] 그리드에 data 셋팅
 * @param params Obj 
 * @param _pageNo
 * @param gridTarget
 */
function setList(params, _pageNo, gridTarget) {
	$.ajax({
		method : "post",
		url : "/ajaxItemMaster/init.do",
		data : params,
		success : function(res) {
			/*
			var data = JSON.parse(res);
			
			if (data.list.length > 0) {
				gridTarget.setData({
					list : data.list,
					page : {
						currentPage : _pageNo || 0,
						pageSize : 50,
						totalElements : 500,
						totalPages : 100
					}
				});

				setTimeout(function() {
					mask.close();
				}, 1000);
			} else {
				gridDataInit(gridTarget);
				
				setTimeout(function() {
					mask.close();
					toastMsg(LN_NO_DATA);
				}, 1000);
			}
			*/			
		},
		error : function() {
			//console.log("error");
		},
		complete : function() {
			//console.log("completed");			
			//gridBtnInit();			
			setTimeout(function() {
				mask.close();				
			}, 1000);
			
			$(".getComps").val(window.opener.document.getElementById("getComps").value);
			search();
		}
	});
}

/**
 * ======================================
 * [ko] 정보 검색하는 함수<br>
 * ======================================
 */
function search() {
	$.ajax({
		method : "post",
		url : "/ajaxItemMaster/search.do",
		data : {
			"getItnbr" : $(".getItnbr").val(),
			"getGbn" : "1",
			"getComps" : $(".getComps").val()
		},
		success : function(res) {
			var data = JSON.parse(res);			
						
			dataLength = data.list.length;

			if (data.list.length > 0) {
				grid.target.setData({
					list : data.list,
					page : {
						currentPage : 0,
						pageSize : 50,
						totalElements : 500,
						totalPages : 100
					}
				});
				
				setTimeout(function() {
					mask.close();
				}, 500);
				
			} else {
				gridBtnInit();
				gridDataInit(grid.target);
				
				setTimeout(function() {
					mask.close();
					toastMsg(LN_NO_DATA);
				}, 500);
			}
		},
		error : function() {
			//console.log("dataset.error");
		},
		completed : function() {
			//console.log("dataset.completed");			
			setTimeout(function() {
				mask.close();				
			}, 500);
			
		}
	});
}

/**
 * ==================================================================== 
 * [KO] Function: 그리드 빈값으로 초기화. <br>
 * [KO] Argument: [1st argument] 초기화할 그리드 <br>
 * [KO] Summary : 이함수는 그리드를 빈값으로 초기화한다. <br>
 * [EN] Summary : <br>
 * ====================================================================
 */
function gridDataInit(gridTarget) {
	gridTarget.setData({
		list : [],
		page : {
			currentPage : 0,
			pageSize : 50,
			totalElements : 500,
			totalPages : 100
		}						
	});
}

// ===================== 그리드 ====================================/
var grid = {
	initView : function(labels) {
		this.target = new ax5.ui.grid();
		this.target
				.setConfig({
					target : $('[data-ax5grid="grid"]'),
					frozenRowIndex : 0,
					showLineNumber : true,
					lineNumberColumnWidth: 40,
					rowSelectorColumnWidth : 25,
					header : {
						align : "center",
						columnHeight : 28
					},
					body : {
						align : "center",
						columnHeight : 28,
						onClick : function() {
							itemObj = new ItemObj(this.item.itnbr, this.item.itdsc);
							
							this.self.clearSelect();
							this.self.select(this.dindex);
						},
					},
					page : {
						navigationItemCount : 1,
						height : 30,
						display : false,
						firstIcon : '<i class="fa fa-step-backward" aria-hidden="true"></i>',
						prevIcon : '<i class="fa fa-caret-left" aria-hidden="true"></i>',
						nextIcon : '<i class="fa fa-caret-right" aria-hidden="true"></i>',
						lastIcon : '<i class="fa fa-step-forward" aria-hidden="true"></i>',
						onChange : function() {
							gridView.setData(this.page.selectPage);
						}
					},
					columns : [
					// 첫번째 컬럼에 선택 css 가 있어 숨김 컬럼을 추가.
					{
						key : "",
						label : "",
						width : 0
					}, {
						key : "itnbr",
						label : labels.itnbr.label,
						width : 180,
						enableFilter : true,
						align : "center"
					}, {
						key : "itdsc",
						display: false,
						width : 180,
						label : labels.itdsc.label,
						align : "left"
					}, {
						key : "ittyp",
						display: false,
						width : 80,
						label : labels.ittyp.label,
						align : "left"
					} ],
				});
		return this;
	},
	setData : function(_pageNo) {
		mask.open();
		var gridTarget = this.target;
		var params = {

		};
		
		setList(params, _pageNo, gridTarget);

		return this;
	}
};

// ===================== // 그리드 ====================================/

$(document.body).ready(function() {

	$('#getItnbr').bind("keyup", function(){       
	    $(this).val($(this).val().toUpperCase());  
	});
	
	$('._closeBtn_').on( 'click', function(e){
		self.close();
	});
	
	$('._applyBtn_').on( 'click', function(e){
		if(itemObj === null){
			toastMsg(LN_SELECT_ITEM)
			return false;
		}
		var params = {
				itnbr: itemObj.itnbr,
				itdsc: itemObj.itdsc,
		};

		window.opener.getReturnValue(JSON.stringify(params));
		window.close();
	});

});