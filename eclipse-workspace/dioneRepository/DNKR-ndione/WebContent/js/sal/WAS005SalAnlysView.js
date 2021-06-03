//code intellisense typescript 정의
///<reference path = "../../wijmo/controls/wijmo.d.ts"/>	
///<reference path = "../../wijmo/controls/wijmo.grid.d.ts"/>
///<reference path = "../../wijmo/controls/wijmo.input.d.ts"/>

/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
"use strict";

var currGridIndex,
    dataLength = 0,
    popGugn;

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
		url : "/ajaxSalAnlysView/init.do",
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
	}else if(!$(".getPyvnd").val()){
		toastMsg(LN_SELECT_PYVND);
		return false;
	}

	//gridBtnInit();
	gridDataInit(grid.target);
	
	mask.open();
	$.ajax({
		method : "post",
		url : "/ajaxSalAnlysView/search.do",
		data : {
			"getComps" : $(".getComps").val(),
			"getPyvnd" : $(".getPyvnd").val(),
			"getPspno" : $(".getPspno").val(),
			"getGubcd" : $(".getGubcd").val()
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

//제품별
var grid1 = {
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
					},
					contextMenu : {
						iconWidth : 20,
						acceleratorWidth : 100,
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
							key : "prdcd",
//							label : "제품",
							label : labels.prdcd.label,
							width : 100,
							align : "center",
						}, {
							key : "prdnm",
							width : 100,
//							label : "제품명",
							label : labels.prdnm.label,
							align : "center"
						}, {
//							key : "qty",
//							label : "수량",
							label : labels.qty.label,
							columns : [
								{
									key : "ysum",
									width : 100,
//									label : "년계",
									label : labels.ysum.label,
									align : "center"
								},
								{
									key : "msum",
									width : 100,
//									label : "단계",
									label : labels.msum.label,
									align : "center"
								},
								{
									key : "paysum",
									width : 100,
//									label : "판매실적",
									label : labels.paysum.label,
									align : "center"
								},
								{
									key : "ysum",
//									label : "년계",
									label : labels.ysum.label,
									columns : [
										{
											key : "gap",
											width : 100,
//											label : "차이",
											label : labels.gap.label,
											align : "center"
										}	
									]
								},
								{
									key : "ysum",
//									label : "년계",
									label : labels.ysum.label,
									columns : [
										{
											key : "achirate",
											width : 100,
//											label : "달성율",
											label : labels.achirate.label,
											align : "center"
										}	
									]
								},
								{
									key : "msum",
//									label : "단계",
									label : labels.msum.label,
									columns : [
										{
											key : "gap",
											width : 100,
//											label : "차이",
											label : labels.gap.label,
											align : "center"
										}	
									]
								},
								{
									key : "msum",
//									label : "단계",
									label : labels.msum.label,
									columns : [
										{
											key : "achirate",
											width : 100,
//											label : "달성율",
											label : labels.achirate.label,
											align : "center"
										}	
									]
								}
					          ]
						},{
//							key : "amount",
//							label : "금액",
							label : labels.amount.label,
							columns : [
								{
									key : "ysum",
									width : 100,
//									label : "년계",
									label : labels.ysum.label,
									align : "center"
								},
								{
									key : "msum",
									width : 100,
//									label : "단계",
									label : labels.msum.label,
									align : "center"
								},
								{
									key : "paysum",
									width : 100,
//									label : "판매실적",
									label : labels.paysum.label,
									align : "center"
								},
								{
									key : "ysum",
//									label : "년계",
									label : labels.ysum.label,
									columns : [
										{
											key : "gap",
											width : 100,
//											label : "차이",
											label : labels.gap.label,
											align : "center"
										}	
									]
								},
								{
									key : "ysum",
//									label : "년계",
									label : labels.ysum.label,
									columns : [
										{
											key : "achirate",
											width : 100,
//											label : "달성율",
											label : labels.achirate.label,
											align : "center"
										}	
									]
								},
								{
									key : "msum",
//									label : "단계",
									label : labels.msum.label,
									columns : [
										{
											key : "gap",
											width : 100,
//											label : "차이",
											label : labels.gap.label,
											align : "center"
										}	
									]
								},
								{
									key : "msum",
//									label : "단계",
									label : labels.msum.label,
									columns : [
										{
											key : "achirate",
											width : 100,
//											label : "달성율",
											label : labels.achirate.label,
											align : "center"
										}	
									]
								}
					          ]
						}],	
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

//득의선별
var grid2 = {
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
					},
					contextMenu : {
						iconWidth : 20,
						acceleratorWidth : 100,
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
							key : "cust",
//							label : "거래처",
							label : labels.cust.label,
							width : 100,
							align : "center",
						}, {
							key : "custnm",
							width : 100,
//							label : "거래처명",
							label : labels.custnm.label,
							align : "center"
						}, {
//							key : "qty",
//							label : "수량",
							label : labels.qty.label,
							columns : [
								{
									key : "ysum",
									width : 100,
//									label : "년계",
									label : labels.ysum.label,
									align : "center"
								},
								{
									key : "msum",
									width : 100,
//									label : "단계",
									label : labels.msum.label,
									align : "center"
								},
								{
									key : "paysum",
									width : 100,
//									label : "판매실적",
									label : labels.paysum.label,
									align : "center"
								},
								{
									key : "ysum",
//									label : "년계",
									label : labels.ysum.label,
									columns : [
										{
											key : "gap",
											width : 100,
//											label : "차이",
											label : labels.gap.label,
											align : "center"
										}	
									]
								},
								{
									key : "ysum",
//									label : "년계",
									label : labels.ysum.label,
									columns : [
										{
											key : "achirate",
											width : 100,
//											label : "달성율",
											label : labels.achirate.label,
											align : "center"
										}	
									]
								},
								{
									key : "msum",
//									label : "단계",
									label : labels.msum.label,
									columns : [
										{
											key : "gap",
											width : 100,
//											label : "차이",
											label : labels.gap.label,
											align : "center"
										}	
									]
								},
								{
									key : "msum",
//									label : "단계",
									label : labels.msum.label,
									columns : [
										{
											key : "achirate",
											width : 100,
//											label : "달성율",
											label : labels.achirate.label,
											align : "center"
										}	
									]
								}
					          ]
						},{
//							key : "amount",
//							label : "금액",
							label : labels.amount.label,
							columns : [
								{
									key : "ysum",
									width : 100,
//									label : "년계",
									label : labels.ysum.label,
									align : "center"
								},
								{
									key : "msum",
									width : 100,
//									label : "단계",
									label : labels.msum.label,
									align : "center"
								},
								{
									key : "paysum",
									width : 100,
//									label : "판매실적",
									label : labels.paysum.label,
									align : "center"
								},
								{
									key : "ysum",
//									label : "년계",
									label : labels.ysum.label,
									columns : [
										{
											key : "gap",
											width : 100,
//											label : "차이",
											label : labels.gap.label,
											align : "center"
										}	
									]
								},
								{
									key : "ysum",
//									label : "년계",
									label : labels.ysum.label,
									columns : [
										{
											key : "achirate",
											width : 100,
//											label : "달성율",
											label : labels.achirate.label,
											align : "center"
										}	
									]
								},
								{
									key : "msum",
//									label : "단계",
									label : labels.msum.label,
									columns : [
										{
											key : "gap",
											width : 100,
//											label : "차이",
											label : labels.gap.label,
											align : "center"
										}	
									]
								},
								{
									key : "msum",
//									label : "단계",
									label : labels.msum.label,
									columns : [
										{
											key : "achirate",
											width : 100,
//											label : "달성율",
											label : labels.achirate.label,
											align : "center"
										}	
									]
								}
					          ]
						}],	
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

//제품/득의선별
var grid3 = {
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
					},
					contextMenu : {
						iconWidth : 20,
						acceleratorWidth : 100,
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
							key : "prdcd",
//							label : "제품",
							label : labels.prdcd.label,
							width : 100,
							align : "center",
						}, {
							key : "prdnm",
							width : 100,
//							label : "제품명",
							label : labels.prdnm.label,
							align : "center"
						}, {
							key : "cust",
//							label : "거래처",
							label : labels.cust.label,
							width : 100,
							align : "center",
						}, {
							key : "custnm",
							width : 100,
//							label : "거래처명",
							label : labels.custnm.label,
							align : "center"
						}, {
//							key : "qty",
//							label : "수량",
							label : labels.qty.label,
							columns : [
								{
									key : "ysum",
									width : 100,
//									label : "년계",
									label : labels.ysum.label,
									align : "center"
								},
								{
									key : "msum",
									width : 100,
//									label : "단계",
									label : labels.msum.label,
									align : "center"
								},
								{
									key : "paysum",
									width : 100,
//									label : "판매실적",
									label : labels.paysum.label,
									align : "center"
								},
								{
									key : "ysum",
//									label : "년계",
									label : labels.ysum.label,
									columns : [
										{
											key : "gap",
											width : 100,
//											label : "차이",
											label : labels.gap.label,
											align : "center"
										}	
									]
								},
								{
									key : "ysum",
//									label : "년계",
									label : labels.ysum.label,
									columns : [
										{
											key : "achirate",
											width : 100,
//											label : "달성율",
											label : labels.achirate.label,
											align : "center"
										}	
									]
								},
								{
									key : "msum",
//									label : "단계",
									label : labels.msum.label,
									columns : [
										{
											key : "gap",
											width : 100,
//											label : "차이",
											label : labels.gap.label,
											align : "center"
										}	
									]
								},
								{
									key : "msum",
//									label : "단계",
									label : labels.msum.label,
									columns : [
										{
											key : "achirate",
											width : 100,
//											label : "달성율",
											label : labels.achirate.label,
											align : "center"
										}	
									]
								}
					          ]
						},{
//							key : "amount",
//							label : "금액",
							label : labels.amount.label,
							columns : [
								{
									key : "ysum",
									width : 100,
//									label : "년계",
									label : labels.ysum.label,
									align : "center"
								},
								{
									key : "msum",
									width : 100,
//									label : "단계",
									label : labels.msum.label,
									align : "center"
								},
								{
									key : "paysum",
									width : 100,
//									label : "판매실적",
									label : labels.paysum.label,
									align : "center"
								},
								{
									key : "ysum",
//									label : "년계",
									label : labels.ysum.label,
									columns : [
										{
											key : "gap",
											width : 100,
//											label : "차이",
											label : labels.gap.label,
											align : "center"
										}	
									]
								},
								{
									key : "ysum",
//									label : "년계",
									label : labels.ysum.label,
									columns : [
										{
											key : "achirate",
											width : 100,
//											label : "달성율",
											label : labels.achirate.label,
											align : "center"
										}	
									]
								},
								{
									key : "msum",
//									label : "단계",
									label : labels.msum.label,
									columns : [
										{
											key : "gap",
											width : 100,
//											label : "차이",
											label : labels.gap.label,
											align : "center"
										}	
									]
								},
								{
									key : "msum",
//									label : "단계",
									label : labels.msum.label,
									columns : [
										{
											key : "achirate",
											width : 100,
//											label : "달성율",
											label : labels.achirate.label,
											align : "center"
										}	
									]
								}
					          ]
						}],	
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

//제품/득의선별
var grid4 = {
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
					},
					contextMenu : {
						iconWidth : 20,
						acceleratorWidth : 100,
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
							key : "cust",
//							label : "거래처",
							label : labels.cust.label,
							width : 100,
							align : "center",
						}, {
							key : "custnm",
							width : 100,
//							label : "거래처명",
							label : labels.custnm.label,
							align : "center"
						}, {
							key : "prdcd",
//							label : "제품",
							label : labels.prdcd.label,
							width : 100,
							align : "center",
						}, {
							key : "prdnm",
							width : 100,
//							label : "제품명",
							label : labels.prdnm.label,
							align : "center"
						}, {
//							key : "qty",
//							label : "수량",
							label : labels.qty.label,
							columns : [
								{
									key : "ysum",
									width : 100,
//									label : "년계",
									label : labels.ysum.label,
									align : "center"
								},
								{
									key : "msum",
									width : 100,
//									label : "단계",
									label : labels.msum.label,
									align : "center"
								},
								{
									key : "paysum",
									width : 100,
//									label : "판매실적",
									label : labels.paysum.label,
									align : "center"
								},
								{
									key : "ysum",
//									label : "년계",
									label : labels.ysum.label,
									columns : [
										{
											key : "gap",
											width : 100,
//											label : "차이",
											label : labels.gap.label,
											align : "center"
										}	
									]
								},
								{
									key : "ysum",
//									label : "년계",
									label : labels.ysum.label,
									columns : [
										{
											key : "achirate",
											width : 100,
//											label : "달성율",
											label : labels.achirate.label,
											align : "center"
										}	
									]
								},
								{
									key : "msum",
//									label : "단계",
									label : labels.msum.label,
									columns : [
										{
											key : "gap",
											width : 100,
//											label : "차이",
											label : labels.gap.label,
											align : "center"
										}	
									]
								},
								{
									key : "msum",
//									label : "단계",
									label : labels.msum.label,
									columns : [
										{
											key : "achirate",
											width : 100,
//											label : "달성율",
											label : labels.achirate.label,
											align : "center"
										}	
									]
								}
					          ]
						},{
//							key : "amount",
//							label : "금액",
							label : labels.amount.label,
							columns : [
								{
									key : "ysum",
									width : 100,
//									label : "년계",
									label : labels.ysum.label,
									align : "center"
								},
								{
									key : "msum",
									width : 100,
//									label : "단계",
									label : labels.msum.label,
									align : "center"
								},
								{
									key : "paysum",
									width : 100,
//									label : "판매실적",
									label : labels.paysum.label,
									align : "center"
								},
								{
									key : "ysum",
//									label : "년계",
									label : labels.ysum.label,
									columns : [
										{
											key : "gap",
											width : 100,
//											label : "차이",
											label : labels.gap.label,
											align : "center"
										}	
									]
								},
								{
									key : "ysum",
//									label : "년계",
									label : labels.ysum.label,
									columns : [
										{
											key : "achirate",
											width : 100,
//											label : "달성율",
											label : labels.achirate.label,
											align : "center"
										}	
									]
								},
								{
									key : "msum",
//									label : "단계",
									label : labels.msum.label,
									columns : [
										{
											key : "gap",
											width : 100,
//											label : "차이",
											label : labels.gap.label,
											align : "center"
										}	
									]
								},
								{
									key : "msum",
//									label : "단계",
									label : labels.msum.label,
									columns : [
										{
											key : "achirate",
											width : 100,
//											label : "달성율",
											label : labels.achirate.label,
											align : "center"
										}	
									]
								}
					          ]
						}],	
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

	//셀렉트박스 미사용 사업부코드 제거
	//$("#getLocCode option[value='H1']").remove();
	//$("#getLocCode option[value='R1']").remove();
	
	//조회구분에 따른 그리드 변경
	$('.getSelectgub').on('change', function() {
		if($('.getSelectgub').val() == "1"){ //제품별
			grid = grid1;
			gridinit();
				
		}else if($('.getSelectgub').val() == "2"){ //득의선별
			grid = grid2;
			gridinit();
				
		}else if($('.getSelectgub').val() == "3"){ //제품/득의선별
			grid = grid3;
			gridinit();
				
		}else { //득의선별/제품
			grid = grid4;
			gridinit();
				
		}
	});
	
	handleEvent(); //버튼 핸들러
	
	//계획년월
	calendar(); //캘린더
	calendarFromTo();//출하일자캘린더
});


/**
	버튼 이벤트 처리
 */
function handleEvent() {

	// 사업부 변경
	$('.getComps').on('change', function() {
		
		if ($(".getComps").val() == '') {
			// 전체 선택시 전체만 표시
			$("#getPltcd option[value='']").prop('disabled',false);
			$("#getPltcd option[value='E1']").prop('disabled',true);
			$("#getPltcd option[value='C1']").prop('disabled',true);
			$("#getPltcd option[value='S1']").prop('disabled',true);
			
			$("#getPltcd option[value='']").prop('selected',true);
			
		} else if ($(".getComps").val() == 'PE') {
			//구KE (마산) 선택시 마산만 표시
			$("#getPltcd option[value='']").prop('disabled',true);
			$("#getPltcd option[value='E1']").prop('disabled',false);
			$("#getPltcd option[value='C1']").prop('disabled',true);
			$("#getPltcd option[value='S1']").prop('disabled',true);
			
			$("#getPltcd option[value='E1']").prop('selected',true);
			
		} else if ($(".getComps").val() == 'PS') {
			//구KA (창원,화성) 선택시 전체,창원,화성 표시
			$("#getPltcd option[value='']").prop('disabled',false);
			$("#getPltcd option[value='E1']").prop('disabled',false);
			$("#getPltcd option[value='C1']").prop('disabled',true);
			$("#getPltcd option[value='S1']").prop('disabled',false);
			
			$("#getPltcd option[value='']").prop('selected',true);
				
		}

	});
	
	
	$('.getPyvnd').on('change', function() {
		$(".getCusnm").val("");
	});


	$('#getPspno').bind("keyup", function(){       
	    $(this).val($(this).val().toUpperCase());  
	});
	
	$('.getPyvnd').on('change', function() {
		$(".getCusnm").val("");
	});
	
	$('.getPspno').on('change', function() {
		$(".getItdsc").val("");
	});

	$('._custBtn_').on('click', function() {
		popGugn = "CUST";
		window.open("/ajaxCustomer/init.do","customerPop","width=550,height=600,scrollbars=yes,top=100,left=100");
	});
	
	$('._itemBtn_').on('click', function() {
		popGugn = "ITEM";
		window.open("/ajaxItemMaster/init.do","itemPop","width=550,height=600,scrollbars=yes,top=100,left=100");
	});	
	
	$('._excelBtn_').on('click', function() {
		grid.target.exportExcel("매출분석조회.xls");
	});
}


function calendar(){
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
		mode: "month",
    	selectMode: "month",
		dateFormat: 'yyyy-MM', // yyyy-mm-dd 
        dimensions: {
            height: 250,
            controlHeight: 40,
            itemPadding: 1
        },
        lang: {
        	/*yearTmpl: "%s년",*/
            /*months: ['일월', '이월', '삼월', '사월', '오월', '육월', '칠월', '팔월', '구월', '시월', '십일월', '십이월'],*/
        	yearTmpl: YEAR_FORMAT,
        	months: MONTH
        },
        onClick: function () {
            $(this.target).css('display', 'none');
			var date = JSON.stringify(chk_calendar.getSelection());
            $(this.target).prev().val(date.substring(2,9));
        },
        onStateChanged: function () {
            //console.log(this);
        }
    });
	
	$('.log_board .dropdown').on('click', function(e){
		$($(e.target).next('.dropdown-menu')).css('display', 'block');
	});
}

function calendarFromTo(){
	var log_calendar = new ax5.ui.calendar({
        target: document.getElementById("log_calendar"),
        control: {
            left: '<i class="fa fa-chevron-left"></i>',
            yearTmpl: '%s',
            monthTmpl: '%s',
            right: '<i class="fa fa-chevron-right"></i>',
            yearFirst: true
        },
        displayDate: (new Date()),
        multipleSelect: 2,
        dimensions: {
            height: 250,
            controlHeight: 50,
            itemPadding: 5
        },
        lang: {
        	/*yearTmpl: "%s년",*/
            /*months: ['일월', '이월', '삼월', '사월', '오월', '육월', '칠월', '팔월', '구월', '시월', '십일월', '십이월'],*/
        	yearTmpl: YEAR_FORMAT,
        	months: MONTH,
        	dayTmpl: "%s"
        },
        onClick: function () {
        	var dates = this.self.getSelection();
            
            if (dates.length > 1) {
                var minDate = new Date(Math.min(ax5.util.date(dates[0]).getTime(), ax5.util.date(dates[1]).getTime()));
                var maxDate = new Date(Math.max(ax5.util.date(dates[0]).getTime(), ax5.util.date(dates[1]).getTime()));
                if(dates[0] < dates[1]) {
                	$(this.target).prev().val(dates[0]);
                    $($(this.target).closest('div.dropdown').next()).find('input').val(dates[1]);
                } else {
                	$(this.target).prev().val(dates[1]);
                    $($(this.target).closest('div.dropdown').next()).find('input').val(dates[0]);
                }
                
                this.self.setPeriod({
                    range: [
                        {from: minDate, to: maxDate, fromLabel: '', toLabel: ''}
                    ]
                });
                $(this.target).css('display', 'none');
            } else {
            	$(this.target).prev().val(dates[0]);
            }
            
        },
        onStateChanged: function () {
            console.log(this);
        }
    });
	
	$('.log_board .dropdown').on('click', function(e){
		$($(e.target).closest('div.fl').find('.dropdown-menu')).css('display', 'block');
	});
}

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
					$('#getPyvnd').val("");
					//$('#getCusnm').val("");
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
 * 품목코드로 품목명 검색하여 데이터 set
 * 
 * @param 품목코드
 */
function getItemSch() {
	if($('#getPspno').val() != ""){
		
		$.ajax({
			method : "post",
			url : "/ajaxItemMaster/search.do",
			data : {
				"getItnbr" : $("#getPspno").val(),
				"getGbn" : "1",
				"getComps" : $("#getComps").val()
			},
			success : function(res) {
				var data = JSON.parse(res);			
				
				if (data.list.length > 0) {
					$('#getItdsc').val(data.list[0].itdsc);
				}			
				else {
					toastMsg(LN_CHK1 + " : " + $("#getPspno").val());
					$("#getPspno").val("");
					//$("#getItdsc").val("");
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

		if(popGugn == "CUST"){
			$('#getPyvnd').val(retObj.cusno);
			$('#getCusnm').val(retObj.cusnm);
		}
		if(popGugn == "ITEM"){
			$('#getPspno').val(retObj.itnbr);
			$('#getItdsc').val(retObj.itdsc);
		}		
	}
}