/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
"use strict";

var currGridIndex,
    dataLength = 0;

/**
 * [KO] 그리드에 data 셋팅
 * @param params Obj 
 * @param _pageNo
 * @param gridTarget
 */
function setList(params, _pageNo, gridTarget) {
	var ajaxParams = params;
	
	$.ajax({
		method : "post",
		url : "/ajaxOrderHostUpCheckList/init.do",
		data : ajaxParams,
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

/**
 * ======================================
 * [ko] 정보 검색하는 함수<br>
 * ======================================
 */
function search() {
	
	if(!$(".getComps").val()){
		toastMsg(LN_SELECT_COMPS);
		return false;
	}else if(!$(".getDumcb").val()){
		toastMsg(LN_SELECT_DUMCB);
		return false;
	}
	
	//gridBtnInit();	
	gridDataInit(grid.target);
	
	var selChk = $(":input:radio[name=getSelchk]:checked").val();
	var gDumcb = $(".getDumcb").val().replace(/-/gi, "");
	var gGubcd = $(":input:radio[name=getGubcd]:checked").val();
	if(selChk == "P6") {
		gGubcd = "";		
	}else {
		gridP7init($(".getDumcb").val());
	}
	
	mask.open();
	$.ajax({
		method : "post",
		url : "/ajaxOrderHostUpCheckList/search.do",
		data : {
			"getSelchk" : selChk,
			"getComps" : $(".getComps").val(),
			"getPyvnd" : $(".getPyvnd").val(),
			"getDumcb" : gDumcb,
			"getDumym" : gDumcb.substr(0,6),
			"getGubcd" : gGubcd	
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
				//gridBtnInit();
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

ax5.ui.grid.tmpl.page_status = function() {
	return '<span>{{{progress}}} {{fromRowIndex}} - {{toRowIndex}} of {{dataRowCount}} {{#dataRealRowCount}}  '
			+ '현재페이지 {{.}}{{/dataRealRowCount}} {{#totalElements}}  전체갯수 {{.}}{{/totalElements}}</span>';
};

// ===================== 그리드 ====================================/
var grid;

var gridP6 = {
	initView : function(labels) {
		this.target = new ax5.ui.grid();
		this.target
				.setConfig({
					target : $('[data-ax5grid="grid"]'),
					frozenRowIndex : 0,
					showLineNumber : true,
					rowSelectorColumnWidth : 25,
					header : {
						align : "center",
						columnHeight : 28
					},
					body : {
						align : "center",
						columnHeight : 28,
						onClick : function() {
							currGridIndex = this.dindex;

							this.self.clearSelect();
							this.self.select(this.dindex);
						},
						//mergeCells: ["pyvnd", "cusnm", "dfacd", "dmkcr"]
					},
					contextMenu : {
						iconWidth : 20,
						acceleratorwidth : 100,
						itemClickAndClose : false,
						icons : {
							'arrow' : '<i class="fa fa-caret-right"></i>'
						},
						popupFilter : function(item, param) {
							if (param.element) {
								return true;
							} else {
								return item.type == 1;
							}
						},
						onClick : function(item, param) {
							grid.target.contextMenu.close();
						}
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
							label : "DENSO거래처",
							columns : [
								{
									key : "pyvnd",
									width : 60,
									label : labels.pyvnd.label,
									align : "left"
								},								
								{
									key : "cusnm",
									width : 150,
									label : labels.cusnm.label,
									align : "left"
								}
					          ]						
						}, {
							key : "dfacd",
							width : 60,
							label : labels.dfacd.label,
							align : "left"
						}, {
							label : "대표",
							columns : [
								{
									key : "dmkcr",
									width : 60,
									label : labels.dmkcr.label,
									align : "left"
								},
								{
									key : "dsecd",
									width : 60,
									label : labels.dsecd.label,
									align : "left"
								},
								{
									key : "dseno",
									width : 60,
									label : labels.dseno.label,
									align : "left"
								}
					          ]
						}, {
							key : "cprtn",
							width : 150,
							label : labels.cprtn.label,
							align : "left"
						}, {
							key : "pspno",
							width : 150,
							label : labels.pspno.label,
							align : "left",
							columns : [
								{
									key : "itdsc",
									width : 150,
									label : labels.itdsc.label,
									align : "left"
								}
					          ]
						}, {
							key : "oemjg",
							width : 60,
							label : labels.oemjg.label,
							align : "right"
						}, {
							label : "DENSO재고",
							columns : [
								{
									key : "sane",
									width : 60,
									label : labels.sane.label,
									align : "right"
								},
								{
									key : "sawe",
									width : 60,
									label : labels.sawe.label,
									align : "right"
								},
								{
									key : "mohtq",
									width : 60,
									label : labels.mohtq.label,
									align : "right"
								}
					          ]
						}, {
							key : "trimd",
							width : 60,
							label : labels.trimd.label,
							align : "right",
							columns : [
								{
									key : "pbsqy",
									width : 60,
									label : labels.pbsqy.label,
									align : "right"
								}
					          ]
						}, {
							key : "patqy",
							width : 60,
							label : labels.patqy.label,
							align : "right",
							columns : [
								{
									key : "wbsqy",
									width : 60,
									label : labels.wbsqy.label,
									align : "right"
								}
					          ]
						}, {
							key : "culjis",
							width : 60,
							label : labels.culjis.label,
							align : "right",
							columns : [
								{
									key : "ilonjs",
									width : 60,
									label : labels.ilonjs.label,
									align : "right"
								}
					          ]
						}, {
							key : "pbs",
							width : 60,
							label : labels.pbs.label,
							align : "right",
							columns : [
								{
									key : "dtq01",
									width : 60,
									label : labels.dtq01.label,
									align : "right"
								}
					          ]
						}, {
							key : "d0t01",
							width : 60,
							label : labels.d0t01.label,
							align : "right",
							columns : [
								{
									key : "dtt01",
									width : 60,
									label : labels.dtt01.label,
									align : "right"
								}
					          ]
						}, {
							key : "d0t02",
							width : 60,
							label : labels.d0t02.label,
							align : "right",
							columns : [
								{
									key : "dtt02",
									width : 60,
									label : labels.dtt02.label,
									align : "right"
								}
					          ]
						}, {
							key : "d0t03",
							width : 60,
							label : labels.d0t03.label,
							align : "right",
							columns : [
								{
									key : "dtt03",
									width : 60,
									label : labels.dtt03.label,
									align : "right"
								}
					          ]
						}, {
							key : "d0t04",
							width : 60,
							label : labels.d0t04.label,
							align : "right",
							columns : [
								{
									key : "dtt04",
									width : 60,
									label : labels.dtt04.label,
									align : "right"
								}
					          ]
						}, {
							key : "d0t05",
							width : 60,
							label : labels.d0t05.label,
							align : "right",
							columns : [
								{
									key : "dtt05",
									width : 60,
									label : labels.dtt05.label,
									align : "right"
								}
					          ]
						}, {
							key : "d0t06",
							width : 60,
							label : labels.d0t06.label,
							align : "right",
							columns : [
								{
									key : "dtt06",
									width : 60,
									label : labels.dtt06.label,
									align : "right"
								}
					          ]
						}, {
							key : "d0t07",
							width : 60,
							label : labels.d0t07.label,
							align : "right",
							columns : [
								{
									key : "dtt07",
									width : 60,
									label : labels.dtt07.label,
									align : "right"
								}
					          ]
						}, {
							key : "d0t08",
							width : 60,
							label : labels.d0t08.label,
							align : "right",
							columns : [
								{
									key : "dtt08",
									width : 60,
									label : labels.dtt08.label,
									align : "right"
								}
					          ]
						}, {
							key : "d0t09",
							width : 60,
							label : labels.d0t09.label,
							align : "right",
							columns : [
								{
									key : "dtt09",
									width : 60,
									label : labels.dtt09.label,
									align : "right"
								}
					          ]
						}, {
							key : "d0t10",
							width : 60,
							label : labels.d0t10.label,
							align : "right",
							columns : [
								{
									key : "dtt10",
									width : 60,
									label : labels.dtt10.label,
									align : "right"
								}
					          ]
						}, {
							key : "d0tqy",
							width : 60,
							label : labels.d0tqy.label,
							align : "right",
							columns : [
								{
									key : "dtq02",
									width : 60,
									label : labels.dtq02.label,
									align : "right"
								}
					          ]
						}, {
							key : "d1t01",
							width : 60,
							label : labels.d1t01.label,
							align : "right",
							columns : [
								{
									key : "dtq13",
									width : 60,
									label : "",
									align : "right"
								}
					          ]
						}, {
							key : "d1t02",
							width : 60,
							label : labels.d1t02.label,
							align : "right",
							columns : [
								{
									key : "dtq14",
									width : 60,
									label : "",
									align : "right"
								}
					          ]
						}, {
							key : "d1t03",
							width : 60,
							label : labels.d1t03.label,
							align : "right",
							columns : [
								{
									key : "dtq13",
									width : 60,
									label : "",
									align : "right"
								}
					          ]
						}, {
							key : "d1t04",
							width : 60,
							label : labels.d1t04.label,
							align : "right",
							columns : [
								{
									key : "dtq14",
									width : 60,
									label : "",
									align : "right"
								}
					          ]
						}, {
							key : "d1t05",
							width : 60,
							label : labels.d1t05.label,
							align : "right",
							columns : [
								{
									key : "dtq13",
									width : 60,
									label : "",
									align : "right"
								}
					          ]
						}, {
							key : "d1t06",
							width : 60,
							label : labels.d1t06.label,
							align : "right",
							columns : [
								{
									key : "dtq14",
									width : 60,
									label : "",
									align : "right"
								}
					          ]
						}, {
							key : "d1t07",
							width : 60,
							label : labels.d1t07.label,
							align : "right",
							columns : [
								{
									key : "dtq13",
									width : 60,
									label : "",
									align : "right"
								}
					          ]
						}, {
							key : "d1t08",
							width : 60,
							label : labels.d1t08.label,
							align : "right",
							columns : [
								{
									key : "dtq14",
									width : 60,
									label : "",
									align : "right"
								}
					          ]
						}, {
							key : "d1t09",
							width : 60,
							label : labels.d1t09.label,
							align : "right",
							columns : [
								{
									key : "dtq13",
									width : 60,
									label : "",
									align : "right"
								}
					          ]
						}, {
							key : "d1t10",
							width : 60,
							label : labels.d1t10.label,
							align : "right",
							columns : [
								{
									key : "dtq14",
									width : 60,
									label : "",
									align : "right"
								}
					          ]
						}, {
							key : "d1tqy",
							width : 60,
							label : labels.d1tqy.label,
							align : "right",
							columns : [
								{
									key : "dtq03",
									width : 60,
									label : labels.dtq03.label,
									align : "right"
								}
					          ]
						}, {
							key : "d2t01",
							width : 60,
							label : labels.d2t01.label,
							align : "right",
							columns : [
								{
									key : "dtq13",
									width : 60,
									label : "",
									align : "right"
								}
					          ]
						}, {
							key : "d2t02",
							width : 60,
							label : labels.d2t02.label,
							align : "right",
							columns : [
								{
									key : "dtq14",
									width : 60,
									label : "",
									align : "right"
								}
					          ]
						}, {
							key : "d2t03",
							width : 60,
							label : labels.d2t03.label,
							align : "right",
							columns : [
								{
									key : "dtq13",
									width : 60,
									label : "",
									align : "right"
								}
					          ]
						}, {
							key : "d2t04",
							width : 60,
							label : labels.d2t04.label,
							align : "right",
							columns : [
								{
									key : "dtq14",
									width : 60,
									label : "",
									align : "right"
								}
					          ]
						}, {
							key : "d2t05",
							width : 60,
							label : labels.d2t05.label,
							align : "right",
							columns : [
								{
									key : "dtq13",
									width : 60,
									label : "",
									align : "right"
								}
					          ]
						}, {
							key : "d2t06",
							width : 60,
							label : labels.d2t06.label,
							align : "right",
							columns : [
								{
									key : "dtq14",
									width : 60,
									label : "",
									align : "right"
								}
					          ]
						}, {
							key : "d2t07",
							width : 60,
							label : labels.d2t07.label,
							align : "right",
							columns : [
								{
									key : "dtq13",
									width : 60,
									label : "",
									align : "right"
								}
					          ]
						}, {
							key : "d2t08",
							width : 60,
							label : labels.d2t08.label,
							align : "right",
							columns : [
								{
									key : "dtq14",
									width : 60,
									label : "",
									align : "right"
								}
					          ]
						}, {
							key : "d2t09",
							width : 60,
							label : labels.d2t09.label,
							align : "right",
							columns : [
								{
									key : "dtq13",
									width : 60,
									label : "",
									align : "right"
								}
					          ]
						}, {
							key : "d2t10",
							width : 60,
							label : labels.d2t10.label,
							align : "right",
							columns : [
								{
									key : "dtq14",
									width : 60,
									label : "",
									align : "right"
								}
					          ]
						}, {
							key : "d2tqy",
							width : 60,
							label : labels.d2tqy.label,
							align : "right",
							columns : [
								{
									key : "dtq04",
									width : 60,
									label : labels.dtq04.label,
									align : "right"
								}
					          ]
						}, {
							key : "d3t01",
							width : 60,
							label : labels.d3t01.label,
							align : "right",
							columns : [
								{
									key : "dtq13",
									width : 60,
									label : "",
									align : "right"
								}
					          ]
						}, {
							key : "d3t02",
							width : 60,
							label : labels.d3t02.label,
							align : "right",
							columns : [
								{
									key : "dtq14",
									width : 60,
									label : "",
									align : "right"
								}
					          ]
						}, {
							key : "d3t03",
							width : 60,
							label : labels.d3t03.label,
							align : "right",
							columns : [
								{
									key : "dtq13",
									width : 60,
									label : "",
									align : "right"
								}
					          ]
						}, {
							key : "d3t04",
							width : 60,
							label : labels.d3t04.label,
							align : "right",
							columns : [
								{
									key : "dtq14",
									width : 60,
									label : "",
									align : "right"
								}
					          ]
						}, {
							key : "d3t05",
							width : 60,
							label : labels.d3t05.label,
							align : "right",
							columns : [
								{
									key : "dtq13",
									width : 60,
									label : "",
									align : "right"
								}
					          ]
						}, {
							key : "d3t06",
							width : 60,
							label : labels.d3t06.label,
							align : "right",
							columns : [
								{
									key : "dtq14",
									width : 60,
									label : "",
									align : "right"
								}
					          ]
						}, {
							key : "d3t07",
							width : 60,
							label : labels.d3t07.label,
							align : "right",
							columns : [
								{
									key : "dtq13",
									width : 60,
									label : "",
									align : "right"
								}
					          ]
						}, {
							key : "d3t08",
							width : 60,
							label : labels.d3t08.label,
							align : "right",
							columns : [
								{
									key : "dtq14",
									width : 60,
									label : "",
									align : "right"
								}
					          ]
						}, {
							key : "d3t09",
							width : 60,
							label : labels.d3t09.label,
							align : "right",
							columns : [
								{
									key : "dtq13",
									width : 60,
									label : "",
									align : "right"
								}
					          ]
						}, {
							key : "d3t10",
							width : 60,
							label : labels.d3t10.label,
							align : "right",
							columns : [
								{
									key : "dtq14",
									width : 60,
									label : "",
									align : "right"
								}
					          ]
						}, {
							key : "d3tqy",
							width : 60,
							label : labels.d3tqy.label,
							align : "right",
							columns : [
								{
									key : "dtq05",
									width : 60,
									label : labels.dtq05.label,
									align : "right"
								}
					          ]
						}, {
							key : "d4t01",
							width : 60,
							label : labels.d4t01.label,
							align : "right",
							columns : [
								{
									key : "dtq13",
									width : 60,
									label : "",
									align : "right"
								}
					          ]
						}, {
							key : "d4t02",
							width : 60,
							label : labels.d4t02.label,
							align : "right",
							columns : [
								{
									key : "dtq14",
									width : 60,
									label : "",
									align : "right"
								}
					          ]
						}, {
							key : "d4t03",
							width : 60,
							label : labels.d4t03.label,
							align : "right",
							columns : [
								{
									key : "dtq13",
									width : 60,
									label : "",
									align : "right"
								}
					          ]
						}, {
							key : "d4t04",
							width : 60,
							label : labels.d4t04.label,
							align : "right",
							columns : [
								{
									key : "dtq14",
									width : 60,
									label : "",
									align : "right"
								}
					          ]
						}, {
							key : "d4t05",
							width : 60,
							label : labels.d4t05.label,
							align : "right",
							columns : [
								{
									key : "dtq13",
									width : 60,
									label : "",
									align : "right"
								}
					          ]
						}, {
							key : "d4t06",
							width : 60,
							label : labels.d4t06.label,
							align : "right",
							columns : [
								{
									key : "dtq14",
									width : 60,
									label : "",
									align : "right"
								}
					          ]
						}, {
							key : "d4t07",
							width : 60,
							label : labels.d4t07.label,
							align : "right",
							columns : [
								{
									key : "dtq13",
									width : 60,
									label : "",
									align : "right"
								}
					          ]
						}, {
							key : "d4t08",
							width : 60,
							label : labels.d4t08.label,
							align : "right",
							columns : [
								{
									key : "dtq14",
									width : 60,
									label : "",
									align : "right"
								}
					          ]
						}, {
							key : "d4t09",
							width : 60,
							label : labels.d4t09.label,
							align : "right",
							columns : [
								{
									key : "dtq13",
									width : 60,
									label : "",
									align : "right"
								}
					          ]
						}, {
							key : "d4t10",
							width : 60,
							label : labels.d4t10.label,
							align : "right",
							columns : [
								{
									key : "dtq14",
									width : 60,
									label : "",
									align : "right"
								}
					          ]
						}, {
							key : "d4tqy",
							width : 60,
							label : labels.d4tqy.label,
							align : "right",
							columns : [
								{
									key : "dtq06",
									width : 60,
									label : labels.dtq06.label,
									align : "right"
								}
					          ]
						}, {
							key : "remqy",
							width : 60,
							label : labels.remqy.label,
							align : "right"
						}, {
							key : "grtot",
							width : 60,
							label : labels.grtot.label,
							align : "right"
						} ],	
				});
		this.target.onLoad = function() {
			//console.log("");
		}
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

var gridP7 = {
	initView : function(labels) {
		this.target = new ax5.ui.grid();
		this.target
				.setConfig({
					target : $('[data-ax5grid="grid"]'),
					frozenRowIndex : 0,
					showLineNumber : true,
					rowSelectorColumnWidth : 25,
					header : {
						align : "center",
						columnHeight : 28
					},
					body : {
						align : "center",
						columnHeight : 28,
						onClick : function() {
							currGridIndex = this.dindex;

							this.self.clearSelect();
							this.self.select(this.dindex);
						},
						//mergeCells: ["pyvnd", "cusnm", "dfacd", "dmkcr"]
					},
					contextMenu : {
						iconWidth : 20,
						acceleratorwidth : 100,
						itemClickAndClose : false,
						icons : {
							'arrow' : '<i class="fa fa-caret-right"></i>'
						},
						popupFilter : function(item, param) {
							if (param.element) {
								return true;
							} else {
								return item.type == 1;
							}
						},
						onClick : function(item, param) {
							grid.target.contextMenu.close();
						}
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
							label : "DENSO거래처",
							columns : [
								{
									key : "pyvnd",
									width : 60,
									label : labels.pyvnd.label,
									align : "left"
								},								
								{
									key : "cusnm",
									width : 150,
									label : labels.cusnm.label,
									align : "left"
								}
					          ]						
						}, {
							key : "dfacd",
							width : 60,
							label : labels.dfacd.label,
							align : "left"
						}, {
							label : "대표",
							columns : [
								{
									key : "dmkcr",
									width : 60,
									label : labels.dmkcr.label,
									align : "left"
								},
								{
									key : "dsecd",
									width : 60,
									label : labels.dsecd.label,
									align : "left"
								},
								{
									key : "dseno",
									width : 60,
									label : labels.dseno.label,
									align : "left"
								}
					          ]
						}, {
							key : "cprtn",
							width : 150,
							label : labels.cprtn.label,
							align : "left"
						}, {
							key : "pspno",
							width : 150,
							label : labels.pspno.label,
							align : "left",
							columns : [
								{
									key : "itdsc",
									width : 150,
									label : labels.itdsc.label,
									align : "left"
								}
					          ]
						}, {
							key : "oemjg",
							width : 60,
							label : labels.oemjg.label,
							align : "right"
						}, {
							label : "DENSO재고",
							columns : [
								{
									key : "sane",
									width : 60,
									label : labels.sane.label,
									align : "right"
								},
								{
									key : "sawe",
									width : 60,
									label : labels.sawe.label,
									align : "right"
								},
								{
									key : "mohtq",
									width : 60,
									label : labels.mohtq.label,
									align : "right"
								}
					          ]
						}, {
							key : "trimd",
							width : 60,
							label : labels.trimd.label,
							align : "right",
							columns : [
								{
									key : "pbsqy",
									width : 60,
									label : labels.pbsqy.label,
									align : "right"
								}
					          ]
						}, {
							key : "patqy",
							width : 60,
							label : labels.patqy.label,
							align : "right",
							columns : [
								{
									key : "wbsqy",
									width : 60,
									label : labels.wbsqy.label,
									align : "right"
								}
					          ]
						}, {
							key : "culjis",
							width : 60,
							label : labels.culjis.label,
							align : "right",
							columns : [
								{
									key : "ilonjs",
									width : 60,
									label : labels.ilonjs.label,
									align : "right"
								}
					          ]
						}, {
							key : "pbs",
							width : 60,
							label : labels.pbs.label,
							align : "right",
							columns : [
								{
									key : "dtq01",
									width : 60,
									label : labels.dtq01.label,
									align : "right"
								}
					          ]
						}, {
							key : "dat00",
							width : 60,
							label : labels.dat00.label,
							align : "right",
							columns : [
								{
									key : "dtq02",
									width : 60,
									label : labels.dtq02.label,
									align : "right"
								}
					          ]
						}, {
							key : "dat01",
							width : 60,
							label : labels.dat01.label,
							align : "right",
							columns : [
								{
									key : "dtq03",
									width : 60,
									label : labels.dtq03.label,
									align : "right"
								}
					          ]
						}, {
							key : "dat02",
							width : 60,
							label : labels.dat02.label,
							align : "right",
							columns : [
								{
									key : "dtq04",
									width : 60,
									label : labels.dtq04.label,
									align : "right"
								}
					          ]
						}, {
							key : "dat03",
							width : 60,
							label : labels.dat03.label,
							align : "right",
							columns : [
								{
									key : "dtq05",
									width : 60,
									label : labels.dtq05.label,
									align : "right"
								}
					          ]
						}, {
							key : "dat04",
							width : 60,
							label : labels.dat04.label,
							align : "right",
							columns : [
								{
									key : "dtq06",
									width : 60,
									label : labels.dtq06.label,
									align : "right"
								}
					          ]
						}, {
							key : "dat05",
							width : 60,
							label : labels.dat05.label,
							align : "right",
							columns : [
								{
									key : "dtq07",
									width : 60,
									label : labels.dtq07.label,
									align : "right"
								}
					          ]
						}, {
							key : "dat06",
							width : 60,
							label : labels.dat06.label,
							align : "right",
							columns : [
								{
									key : "dtq08",
									width : 60,
									label : labels.dtq08.label,
									align : "right"
								}
					          ]
						}, {
							key : "dat07",
							width : 60,
							label : labels.dat07.label,
							align : "right",
							columns : [
								{
									key : "dtq09",
									width : 60,
									label : labels.dtq09.label,
									align : "right"
								}
					          ]
						}, {
							key : "dat08",
							width : 60,
							label : labels.dat08.label,
							align : "right",
							columns : [
								{
									key : "dtq10",
									width : 60,
									label : labels.dtq10.label,
									align : "right"
								}
					          ]
						}, {
							key : "dat09",
							width : 60,
							label : labels.dat09.label,
							align : "right",
							columns : [
								{
									key : "dtq11",
									width : 60,
									label : labels.dtq11.label,
									align : "right"
								}
					          ]
						}, {
							key : "dat10",
							width : 60,
							label : labels.dat10.label,
							align : "right",
							columns : [
								{
									key : "dtq12",
									width : 60,
									label : labels.dtq12.label,
									align : "right"
								}
					          ]
						}, {
							key : "dat11",
							width : 60,
							label : labels.dat11.label,
							align : "right",
							columns : [
								{
									key : "dtq13",
									width : 60,
									label : labels.dtq13.label,
									align : "right"
								}
					          ]
						}, {
							key : "dat12",
							width : 60,
							label : labels.dat12.label,
							align : "right",
							columns : [
								{
									key : "dtq14",
									width : 60,
									label : labels.dtq14.label,
									align : "right"
								}
					          ]
						}, {
							key : "remqy",
							width : 60,
							label : labels.remqy.label,
							align : "right",
							columns : [
								{
									key : "okqty",
									width : 60,
									label : labels.okqty.label,
									align : "right"
								}
					          ]
						}, {
							key : "mitqy",
							width : 60,
							label : labels.mitqy.label,
							align : "right",
							columns : [
								{
									key : "prseq",
									width : 60,
									label : labels.prseq.label,
									align : "right"
								}
					          ]
						}, {
							key : "miqqy",
							width : 80,
							label : labels.miqqy.label,
							align : "right",
							columns : [
								{
									key : "mioqy",
									width : 80,
									label : labels.mioqy.label,
									align : "right"
								}
					          ]
						}, {
							key : "grtot",
							width : 60,
							label : labels.grtot.label,
							align : "right"
						} ],	
				});
		this.target.onLoad = function() {
			//console.log("");
		}
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

	var chk_calendar = new ax5.ui.calendar({
        target: document.getElementById("chk_calendar"),
        control: {
            left: '<i class="fa fa-chevron-left"></i>',
            yearTmpl: '%s',
            monthTmpl: '%s',
            right: '<i class="fa fa-chevron-right"></i>',
            yearFirst: true
        },
        displayDate: (new Date()),
        dimensions: {
            height: 250,
            controlHeight: 40,
            itemPadding: 1
        },
        lang: {
        	/*yearTmpl: "%s년",*/
            /*months: ['일월', '이월', '삼월', '사월', '오월', '육월', '칠월', '팔월', '구월', '시월', '십일월', '십이월'],*/
        	yearTmpl: YEAR_FORMAT,
        	months: MONTH,
        	dayTmpl: "%s"
        },
        onClick: function () {
            $(this.target).css('display', 'none');
            $(this.target).prev().val(chk_calendar.getSelection());
        },
        onStateChanged: function () {
            //console.log(this);
        }
    });
	
	$('.log_board .dropdown').on('click', function(e){
		$($(e.target).next('.dropdown-menu')).css('display', 'block');
	});
	
	
	$('.getSelchk').on('change', function() {
		if($(":input:radio[name=getSelchk]:checked").val() == "P6"){
			grid = gridP6;
			gridP6init();
			
			$('.gubcd').css("display", "none");			
		}else{
			grid = gridP7;
			gridP7init("");
			
			$('.gubcd').css("display", "");
		}
	});
	
	$('.getComps').on('change', function() {
		$(".getPyvnd").val("");
		$(".getCusnm").val("");
	});
	
	$('.getPyvnd').on('change', function() {
		$(".getCusnm").val("");
	});

	// 달력 크기 때문에 height=400
	$('._saleBtn_').on('click', function() {
		window.open("/WAN010OrderDaySaleCreate/init.do","OrderDaySaleCreatePop","width=800,height=400,scrollbars=yes,top=100,left=100");
	});
	
	$('._custBtn_').on('click', function() {
		window.open("/ajaxCustomer/init.do","customerPop","width=550,height=600,scrollbars=yes,top=100,left=100");
	});
	
	$('._excelBtn_').on('click', function() {
		grid.target.exportExcel("서열형 HOST UP CHECK LIST.xls");
	});
});

/**
 * 업체코드로 업체명 검색하여 데이터 set
 * 
 * @param 업체코드
 */
function getCustSch() {
	if($('#getPyvnd').val() != ""){
		
		$.ajax({
			method : "post",
			url : "/ajaxCustomer/search.do",
			data : {
				"getCusno" : $("#getPyvnd").val(),
				"getComps" : $("#getComps").val()
			},
			success : function(res) {
				var data = JSON.parse(res);			
				
				if (data.list.length > 0) {
					$('#getCusnm').val(data.list[0].cusnm);
				}
				else {
					toastMsg(LN_IO_CHK1 + " : " + $("#getPyvnd").val());
					$("#getPyvnd").val("");
					//$("#getCusnm").val("");					
				}
			},
			error : function() {
				//console.log("dataset.error");
			},
			completed : function() {
				//console.log("dataset.completed");
			}
		});
	}
}

/**
 * 팝업창에서 값넘겨받아 부모창에 데이터 set
 * 
 * @param returnValue
 */
function getReturnValue(returnValue) {
	if(returnValue !== null) {
		var retObj = JSON.parse(returnValue);

		$('#getPyvnd').val(retObj.cusno);
		$('#getCusnm').val(retObj.cusnm);	
	}
}


function date_add(sDate, nDays) {
    var yy = parseInt(sDate.substr(0, 4), 10);
    var mm = parseInt(sDate.substr(5, 2), 10);
    var dd = parseInt(sDate.substr(8), 10);
 
    var d = new Date(yy, mm - 1, dd + nDays);
 
    yy = d.getFullYear();
    mm = d.getMonth() + 1; mm = (mm < 10) ? '0' + mm : mm;
    dd = d.getDate(); dd = (dd < 10) ? '0' + dd : dd;
 
    //return '' + yy + '-' +  mm  + '-' + dd;
    return mm  + '/' + dd;
}