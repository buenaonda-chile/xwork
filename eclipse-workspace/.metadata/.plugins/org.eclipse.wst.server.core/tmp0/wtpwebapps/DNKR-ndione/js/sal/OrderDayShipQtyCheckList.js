/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
"use strict";

var currGridIndex,
    checkList = "",
    checkTitle = "",
    errorList = "",
    errorTitle = "";

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
		url : "/ajaxOrderDayShipQtyCheckList/init.do",
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
				gridDataInit(gridTarget, "");
				
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
function gridDataInit(gridTarget, dateList) {
	if(dateList == "") dateList = [];
	
	gridTarget.setData({
		list : dateList,
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
	}else if(!$(".getChald").val()){
		toastMsg(LN_SELECT_DUMCB);
		return false;
	}
	
	//gridBtnInit();	
	gridDataInit(grid.target, "");
	
	var selChk = $(":input:radio[name=getSelchk]:checked").val();
	var gChald = $(".getChald").val().replace(/-/gi, "");
	
	var orgcomps="";
	if($(".getComps").val() == "E1") orgcomps = "PE";
	else orgcomps = "PS";
	
	mask.open();
	$.ajax({
		method : "post",
		url : "/ajaxOrderDayShipQtyCheckList/search.do",
		data : {
			"getSelchk" : selChk,
			"getComps" : $(".getComps").val(),
			"getGcomps" : orgcomps,			
			"getChldt" : gChald,			
			"getPyvnd1" : $(".getPyvnd1").val()?$(".getPyvnd1").val():"00000000",
			"getPyvnd2" : $(".getPyvnd2").val()?$(".getPyvnd2").val():"99999999",
					
			"getChkdt" : "PDATE",  // 시작일자 PARAM
			"getChkcnt" : "14"  // 리턴수
		},
		success : function(res) {			
			var data = JSON.parse(res);

			//console.log(data.checkList);
			//console.log(data.errorList);
			
			if(data.checkList != undefined){
				checkList = data.checkList;
				checkTitle = data.checkTitle;
			}
			if(data.errorList != undefined){
				errorList = data.errorList;
				errorTitle = data.errorTitle;
			}
			
			if (checkList.length > 0 || errorList.length > 0) {
				
				$(".gubcd").prop('disabled', false);
				
				if($(":input:radio[name=getGubcd]:checked").val() == "1"){
					grid = gridCheck;
					gridCheckinit(checkTitle);
					gridDataInit(grid.target, checkList);
				}else{
					grid = gridError;
					gridErrorinit(errorTitle);
					gridDataInit(grid.target, errorList);
				}

				/*
				//CHLCD값에 따라 데이터가 달라짐.RPG참고
				//속도 저하시 삭제가능함. 단...RPG와 내용이 틀려짐.
				ds_SPDE141Q_142PF_CHK.Copy(ds_SPDE141Q_142PF);
				for(i=0; i<ds_SPDE141Q_142PF.rowcount; i++){
					var k=0;
					for(j=0; j<7; j++){
						if(ds_SAL100.GetColumn(j,"CLHCD")=="1"){
							ds_SPDE141Q_142PF.SetColumn(i,"SUJQ"+j,ds_SPDE141Q_142PF_CHK.GetColumn(i,"SUJQ"+k));
							ds_SPDE141Q_142PF.SetColumn(i,"SUJQ"+j+"S",ds_SPDE141Q_142PF_CHK.GetColumn(i,"SUJQ"+k+"S"));
							k++;
						}else{
							ds_SPDE141Q_142PF.SetColumn(i,"SUJQ"+j,0);
							ds_SPDE141Q_142PF.SetColumn(i,"SUJQ"+j+"S",0);
						}	
					}
				}	
				*/
				
				setTimeout(function() {
					mask.close();
				}, 500);
				
			} else {
				$(".gubcd").prop('disabled', true);
			
				if($(":input:radio[name=getGubcd]:checked").val() == "1") gridCheckinit("");
				else gridErrorinit("");
				
				//gridBtnInit();
				gridDataInit(grid.target, "");
				
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

var gridCheck = {
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
						//mergeCells: ["chldt", "cusnm", "pyvnd"],
						/* 소계는 한줄만 표현 가능. (footSum 처럼 2차원 배열도 아니고, columns 지원 안됨)
						grouping : {
							by : ["pyvnd", "mkcar"],
							columns : [
								{}, 
								{
									label : function() {
										return this.groupBy.labels.join(", ") + " 합계";
									},
									colspan : 5,
									align : "center",
									height : 28
								}, 
								{
									key : "makqy",
									collector : "sum",
									formatter : "money",
									align : "right"
								},
								{
									key : "pspqy",
									collector : "sum",
									formatter : "money",
									align : "right"
								},
								{
									key : "suyqy",
									collector : "sum",
									formatter : "money",
									align : "right"
								}, 
								{
									key : "cllq1",								
									collector : "sum",
									formatter : "money",
									align : "right"
								}, 
								// cllbox1
								{
									key : "clpq1",
									collector : "sum",
									formatter : "money",
									align : "right"
								}, 
								// boxq1
								{
									key : "cllq2",
									collector : "sum",
									formatter : "money",
									align : "right"
								}, 
								// cllbox2
								{
									key : "clpq2",
									collector : "sum",
									formatter : "money",
									align : "right"
								}, 
								// boxq2
								{
									key : "junqy",
									collector : "sum",
									formatter : "money",
									align : "right"
								}, 
								{
									key : "notqy",
									collector : "sum",
									formatter : "money",
									align : "right"
								}, 
								{
									key : "trimd",
									collector : "sum",
									formatter : "money",
									align : "right"
								}, 
								{
									key : "pbsqy",
									collector : "sum",
									formatter : "money",
									align : "right"
								}, 						
								{
									key : "datq0",
									collector : "sum",
									formatter : "money",
									align : "right"
								},
								//dapq0
								//sujq0
								{
									key : "dat11",
									collector : "sum",
									formatter : "money",
									align : "right"
								},
								//dap11
								{
									key : "dat12",
									collector : "sum",
									formatter : "money",
									align : "right"
								},
								//dap12
								//sujq1
								{
									key : "dat21",
									collector : "sum",
									formatter : "money",
									align : "right"
								},
								//dap21
								{
									key : "dat22",
									collector : "sum",
									formatter : "money",
									align : "right"
								},
								//dap22
								//sujq2
								{
									key : "dat31",
									collector : "sum",
									formatter : "money",
									align : "right"
								},
								//dap31
								{
									key : "dat32",
									collector : "sum",
									formatter : "money",
									align : "right"
								},
								//dap32
								//sujq3
								{
									key : "dat41",
									collector : "sum",
									formatter : "money",
									align : "right"
								},
								//dap41
								{
									key : "dat42",
									collector : "sum",
									formatter : "money",
									align : "right"
								},
								//dap42
								//sujq4
								{
									key : "dat51",
									collector : "sum",
									formatter : "money",
									align : "right"
								},
								//dap51
								{
									key : "dat52",
									collector : "sum",
									formatter : "money",
									align : "right"
								},
								//dap52
								//sujq5
								{
									key : "dat61",
									collector : "sum",
									formatter : "money",
									align : "right"
								},
								//dap61
								{
									key : "dat62",
									collector : "sum",
									formatter : "money",
									align : "right"
								},
								//dap62
								//sujq6
								{
									key : "datqy",
									collector : "sum",
									formatter : "money",
									align : "right"
								},
								//sujqy
								{
									key : "plqty",
									collector : "sum",
									formatter : "money",
									align : "right"
								}
								//slqty
								//dalpr
							]							
						}
						*/
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
							key : "chldt",
							width : 100,
							label : labels.chldt.label,
							align : "center",
							formatter:function(){
								var date = this.value;
								if(date.length == 8) return date.substr(0, 4) + "-" + date.substr(4, 2) + "-" + date.substr(6, 2);
								else return date;
							}
						}, {					
							label : labels.cusnm.label,
							columns : [
								{
									key : "cusnm",
									width : 150,
									label : labels.cusnm.label,
									align : "left"
								},								
								{
									key : "pyvnd",
									width : 60,
									label : labels.pyvnd.label,
									align : "center"
								}
					          ]						
						}, {
							key : "faccd",
							width : 60,
							label : labels.faccd.label,
							align : "center",
							columns : [
								{
									key : "seycd",
									width : 60,
									label : labels.seycd.label,
									align : "center",
									columns : [
										{
											key : "mkcar",
											width : 60,
											label : labels.mkcar.label,
											align : "center"
										}
									]
								}
							]
						}, {
							key : "mkpno",
							width : 200,
							label : labels.mkpno.label,
							align : "left",
							columns : [
								{
									key : "pspno",
									width : 200,
									label : labels.pspno.label,
									align : "left",
									columns : [
										{
											key : "itmnm",
											width : 200,
											label : labels.itmnm.label,
											align : "left"
										}
									]
								}
					          ]
						}, {
							label : "재고현황",
							columns : [
								{
									key : "makqy",
									width : 60,
									label : labels.makqy.label,
									align : "right"
								},
								{
									key : "pspqy",
									width : 60,
									label : labels.pspqy.label,
									align : "right"
								}
					          ]
						}, {
							label : "계획대비 출하현황",
							columns : [
								{
									key : "suyqy",
									width : 60,
									label : labels.suyqy.label,
									align : "right"
								}, {
									key : "cllq1",
									width : 60,
									label : labels.cllq1.label,
									align : "right",
									columns : [
										{
											key : "cllbox1",
											width : 60,
											label : labels.cllbox1.label,
											align : "left"
										}
									]
								}, {
									key : "clpq1",
									width : 60,
									label : labels.clpq1.label,
									align : "right",
									columns : [
										{
											key : "boxq1",
											width : 60,
											label : labels.boxq1.label,
											align : "right"
										}
									]
								},{
									key : "cllq2",
									width : 60,
									label : labels.cllq2.label,
									align : "right",
									columns : [
										{
											key : "cllbox2",
											width : 60,
											label : labels.cllbox2.label,
											align : "left"
										}
									]
								}, {
									key : "clpq2",
									width : 60,
									label : labels.clpq2.label,
									align : "right",
									columns : [
										{
											key : "boxq2",
											width : 60,
											label : labels.boxq2.label,
											align : "right"
										}
									]
								}, {
									key : "junqy",
									width : 60,
									label : labels.junqy.label,
									align : "right"
								}, {
									key : "notqy",
									width : 60,
									label : labels.notqy.label,
									align : "right"
								}
					          ]
						}, {
							label : "생산계획 대비 부족량",
							columns : [
								{
									key : "trimd",
									width : 60,
									label : labels.trimd.label,
									align : "right"
								}, {
									key : "pbsqy",
									width : 60,
									label : labels.pbsqy.label,
									align : "right"
								}, {
									key : "datq0",
									width : 60,
									label : labels.datq0.label,
									align : "right",
									columns : [
										{
											key : "dapq0",
											width : 60,
											label : labels.dapq0.label,
											align : "right",
											columns : [
												{
													key : "sujq0",
													width : 60,
													label : labels.sujq0.label,
													align : "right"
												}
											]
										}
									]
								}, {
									key : "dat11",
									width : 60,
									label : labels.dat11.label,
									align : "right",
									columns : [
										{
											key : "dap11",
											width : 60,
											label : labels.dap11.label,
											align : "right",
											columns : [
												{
													key : "",
													label : "8T",
													width : 60
												}
											]
										}
									]
								}, {
									key : "dat12",
									width : 60,
									label : labels.dat12.label,
									align : "right",
									columns : [
										{
											key : "dap12",
											width : 60,
											label : labels.dap12.label,
											align : "right",
											columns : [
												{
													key : "sujq1",
													width : 60,
													label : labels.sujq1.label,
													align : "right"
												}
											]
										}
									]
								}, {
									key : "dat21",
									width : 60,
									label : labels.dat21.label,
									align : "right",
									columns : [
										{
											key : "dap21",
											width : 60,
											label : labels.dap21.label,
											align : "right",
											columns : [
												{
													key : "",
													label : "Day",
													width : 60
												}
											]
										}
									]
								}, {
									key : "dat22",
									width : 60,
									label : labels.dat22.label,
									align : "right",
									columns : [
										{
											key : "dap22",
											width : 60,
											label : labels.dap22.label,
											align : "right",
											columns : [
												{
													key : "sujq2",
													width : 60,
													label : labels.sujq2.label,
													align : "right"
												}
											]
										}
									]
								}, {
									key : "dat31",
									width : 60,
									label : labels.dat31.label,
									align : "right",
									columns : [
										{
											key : "dap31",
											width : 60,
											label : labels.dap31.label,
											align : "right",
											columns : [
												{
													key : "",
													label : "Day",
													width : 60
												}
											]
										}
									]
								}, {
									key : "dat32",
									width : 60,
									label : labels.dat32.label,
									align : "right",
									columns : [
										{
											key : "dap32",
											width : 60,
											label : labels.dap32.label,
											align : "right",
											columns : [
												{
													key : "sujq3",
													width : 60,
													label : labels.sujq3.label,
													align : "right"
												}
											]
										}
									]
								}, {
									key : "dat41",
									width : 60,
									label : labels.dat41.label,
									align : "right",
									columns : [
										{
											key : "dap41",
											width : 60,
											label : labels.dap41.label,
											align : "right",
											columns : [
												{
													key : "",
													label : "Day",
													width : 60
												}
											]
										}
									]
								}, {
									key : "dat42",
									width : 60,
									label : labels.dat42.label,
									align : "right",
									columns : [
										{
											key : "dap42",
											width : 60,
											label : labels.dap42.label,
											align : "right",
											columns : [
												{
													key : "sujq4",
													width : 60,
													label : labels.sujq4.label,
													align : "right"
												}
											]
										}
									]
								}, {
									key : "dat51",
									width : 60,
									label : labels.dat51.label,
									align : "right",
									columns : [
										{
											key : "dap51",
											width : 60,
											label : labels.dap51.label,
											align : "right",
											columns : [
												{
													key : "",
													label : "Day",
													width : 60
												}
											]
										}
									]
								}, {
									key : "dat52",
									width : 60,
									label : labels.dat52.label,
									align : "right",
									columns : [
										{
											key : "dap52",
											width : 60,
											label : labels.dap52.label,
											align : "right",
											columns : [
												{
													key : "sujq5",
													width : 60,
													label : labels.sujq5.label,
													align : "right"
												}
											]
										}
									]
								}, {
									key : "dat61",
									width : 60,
									label : labels.dat61.label,
									align : "right",
									columns : [
										{
											key : "dap61",
											width : 60,
											label : labels.dap61.label,
											align : "right",
											columns : [
												{
													key : "",
													label : "Day",
													width : 60
												}
											]
										}
									]
								}, {
									key : "dat62",
									width : 60,
									label : labels.dat62.label,
									align : "right",
									columns : [
										{
											key : "dap62",
											width : 60,
											label : labels.dap62.label,
											align : "right",
											columns : [
												{
													key : "sujq6",
													width : 60,
													label : labels.sujq6.label,
													align : "right"
												}
											]
										}
									]
								}, {
									key : "datqy",
									width : 60,
									label : labels.datqy.label,
									align : "right",
									columns : [
										{
											key : "",
											width : 60,
											label : "",
											columns : [
												{
													key : "sujqy",
													width : 60,
													label : labels.sujqy.label,
													align : "right"
												}
											]
										}
									]
								}
					          ]
						}, {
							key : "plqty",
							width : 100,
							label : labels.plqty.label,
							align : "right",
							columns : [
								{
									key : "slqty",
									width : 100,
									label : labels.slqty.label,
									align : "right",
									columns : [
										{
											key : "dalpr",
											width : 100,
											label : labels.dalpr.label,
											align : "right"
										}
									]
								}
							]
						} 
					],	
					footSum : [
						[
							{}, 
							{
								label : "총계",
								colspan : 5,
								align : "center"
							}, 
							{
								key : "makqy",
								collector : "sum",
								formatter : "money",
								align : "right"
							},
							{
								key : "pspqy",
								collector : "sum",
								formatter : "money",
								align : "right"
							},
							{
								key : "suyqy",
								collector : "sum",
								formatter : "money",
								align : "right"
							}, 
							{
								key : "cllq1",
								collector : "sum",
								formatter : "money",
								align : "right"
							}, 
							// cllbox1
							{
								key : "clpq1",
								collector : "sum",
								formatter : "money",
								align : "right"							
							}, 
							// boxq1
							{
								key : "cllq2",
								collector : "sum",
								formatter : "money",
								align : "right"
							}, 
							// cllbox2
							{
								key : "clpq2",
								collector : "sum",
								formatter : "money",
								align : "right"
							}, 
							// boxq2
							{
								key : "junqy",
								collector : "sum",
								formatter : "money",
								align : "right"
							}, 
							{
								key : "notqy",
								collector : "sum",
								formatter : "money",
								align : "right"
							}, 
							{
								key : "trimd",
								collector : "sum",
								formatter : "money",
								align : "right"
							}, 
							{
								key : "pbsqy",
								collector : "sum",
								formatter : "money",
								align : "right"
							}, 						
							{
								key : "datq0",
								collector : "sum",
								formatter : "money",
								align : "right"
							},
							//dapq0
							//sujq0
							{
								key : "dat11",
								collector : "sum",
								formatter : "money",
								align : "right"
							},
							//dap11
							{
								key : "dat12",
								collector : "sum",
								formatter : "money",
								align : "right"
							},
							//dap12
							//sujq1
							{
								key : "dat21",
								collector : "sum",
								formatter : "money",
								align : "right"
							},
							//dap21
							{
								key : "dat22",
								collector : "sum",
								formatter : "money",
								align : "right"
							},
							//dap22
							//sujq2
							{
								key : "dat31",
								collector : "sum",
								formatter : "money",
								align : "right"
							},
							//dap31
							{
								key : "dat32",
								collector : "sum",
								formatter : "money",
								align : "right"
							},
							//dap32
							//sujq3
							{
								key : "dat41",
								collector : "sum",
								formatter : "money",
								align : "right"
							},
							//dap41
							{
								key : "dat42",
								collector : "sum",
								formatter : "money",
								align : "right"
							},
							//dap42
							//sujq4
							{
								key : "dat51",
								collector : "sum",
								formatter : "money",
								align : "right"
							},
							//dap51
							{
								key : "dat52",
								collector : "sum",
								formatter : "money",
								align : "right"
							},
							//dap52
							//sujq5
							{
								key : "dat61",
								collector : "sum",
								formatter : "money",
								align : "right"
							},
							//dap61
							{
								key : "dat62",
								collector : "sum",
								formatter : "money",
								align : "right"
							},
							//dap62
							//sujq6
							{
								key : "datqy",
								collector : "sum",
								formatter : "money",
								align : "right"
							},
							//sujqy
							{
								key : "plqty",
								collector : "sum",
								formatter : "money",
								align : "right"
							}
							//slqty
							//dalpr
						],
						[
							{}, 
							{
								label : "",
								colspan : 5,
								align : "center"
							}, 
							{},
							{},
							{}, 
							{
								label : "BOX",
								align : "left"
							}, 
							{
								key : "boxq1",
								collector : "sum",
								formatter : "money",
								align : "right"							
							}, 
							{
								label : "BOX",
								align : "left"
							},
							{
								key : "boxq2",
								collector : "sum",
								formatter : "money",
								align : "right"
							}, 
							{}, 
							{}, 
							{}, 
							{}, 						
							{
								key : "dapq0",
								collector : "sum",
								formatter : "money",
								align : "right"
							},
							//sujq0
							{
								key : "dap11",
								collector : "sum",
								formatter : "money",
								align : "right"
							},
							{
								key : "dap12",
								collector : "sum",
								formatter : "money",
								align : "right"
							},
							//sujq1
							{
								key : "dap21",
								collector : "sum",
								formatter : "money",
								align : "right"
							},
							{
								key : "dap22",
								collector : "sum",
								formatter : "money",
								align : "right"
							},
							//sujq2
							{
								key : "dap31",
								collector : "sum",
								formatter : "money",
								align : "right"
							},
							{
								key : "dap32",
								collector : "sum",
								formatter : "money",
								align : "right"
							},
							//sujq3
							{
								key : "dap41",
								collector : "sum",
								formatter : "money",
								align : "right"
							},
							{
								key : "dap42",
								collector : "sum",
								formatter : "money",
								align : "right"
							},
							//sujq4
							{
								key : "dap51",
								collector : "sum",
								formatter : "money",
								align : "right"
							},
							{
								key : "dap52",
								collector : "sum",
								formatter : "money",
								align : "right"
							},
							//sujq5
							{
								key : "dap61",
								collector : "sum",
								formatter : "money",
								align : "right"
							},
							{
								key : "dap62",
								collector : "sum",
								formatter : "money",
								align : "right"
							},
							//sujq6
							{},
							{
								key : "slqty",
								collector : "sum",
								formatter : "money",
								align : "right"
							}
							//dalpr
						],
						[
							{}, 
							{
								label : "",
								colspan : 5,
								align : "center"
							}, 
							{},
							{},
							{}, 
							{},
							{}, 
							{}, 
							{}, 
							{}, 
							{}, 
							{}, 
							{}, 						
							{
								key : "sujq0",
								collector : "sum",
								formatter : "money",
								align : "right"
							},
							{},
							{
								key : "sujq1",
								collector : "sum",
								formatter : "money",
								align : "right"
							},
							{},
							{
								key : "sujq2",
								collector : "sum",
								formatter : "money",
								align : "right"
							},
							{},
							{
								key : "sujq3",
								collector : "sum",
								formatter : "money",
								align : "right"
							},
							{},
							{
								key : "sujq4",
								collector : "sum",
								formatter : "money",
								align : "right"
							},
							{},
							{
								key : "sujq5",
								collector : "sum",
								formatter : "money",
								align : "right"
							},
							{},
							{
								key : "sujq6",
								collector : "sum",
								formatter : "money",
								align : "right"
							},
							{
								key : "sujqy",
								collector : "sum",
								formatter : "money",
								align : "right"
							},
							{
								key : "dalpr",
								collector : "sum",
								formatter : "money",
								align : "right"
							}
						]
					]
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

var gridError = {
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
						//mergeCells: ["chldt", "cusnm", "pyvnd"]
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
							key : "chldt",
							width : 100,
							label : labels.chldt.label,
							align : "center",
							formatter:function(){
								var date = this.value;
								return date.substr(0, 4) + "-" + date.substr(4, 2) + "-" + date.substr(6, 2); 
							}
						}, {
							label : labels.cusnm.label,
							columns : [
								{
									key : "cusnm",
									width : 150,
									label : labels.cusnm.label,
									align : "left"
								},{
									key : "pyvnd",
									width : 60,
									label : labels.pyvnd.label,
									align : "left"
								}
							]
						}, {
							key : "faccd",
							width : 60,
							label : labels.faccd.label,
							align : "left"
						}, {
							key : "mkcar",
							width : 60,
							label : labels.mkcar.label,
							align : "left"
						}, {
							key : "seycd",
							width : 60,
							label : labels.seycd.label,
							align : "left"
						}, {
							key : "mkpno",
							width : 120,
							label : labels.mkpno.label,
							align : "left"
						}, {
							key : "pspno",
							width : 120,
							label : labels.pspno.label,
							align : "left"
						}, {
							key : "",							
							width : 60,
							label : "MK재고",
							align : "left"
						}, {
							key : "",							
							width : 60,
							label : "PS재고",
							align : "left"
						}, {
							key : "trimdt",
							width : 60,
							label : labels.trimdt.label,
							align : "right"
						}, {
							key : "pbsqyt",
							width : 60,
							label : labels.pbsqyt.label,
							align : "right"
						}, {
							key : "datq0t",
							width : 60,
							label : labels.datq0t.label,
							align : "right"
						}, {
							key : "datq1t",
							width : 60,
							label : labels.datq1t.label,
							align : "right"
						}, {
							key : "datq2t",
							width : 60,
							label : labels.datq2t.label,
							align : "right"
						}, {
							key : "datq3t",
							width : 60,
							label : labels.datq3t.label,
							align : "right"
						}, {
							key : "datq4t",
							width : 60,
							label : labels.datq4t.label,
							align : "right"
						}, {
							key : "datq5t",
							width : 60,
							label : labels.datq5t.label,
							align : "right"
						}, {
							key : "datq6t",
							width : 60,
							label : labels.datq6t.label,
							align : "right"
						}, {
							key : "datq7t",
							width : 60,
							label : labels.datq7t.label,
							align : "right"
						}, {
							key : "datq8t",
							width : 60,
							label : labels.datq8t.label,
							align : "right"
						}, {
							key : "datq9t",
							width : 60,
							label : labels.datq9t.label,
							align : "right"
						}, {
							key : "datqat",
							width : 60,
							label : labels.datqat.label,
							align : "right"
						}, {
							key : "datqbt",
							width : 60,
							label : labels.datqbt.label,
							align : "right"
						}, {
							key : "datqct",
							width : 60,
							label : labels.datqct.label,
							align : "right"
						}, {
							label : labels.errcd.label,
							columns : [
								{
									key : "errcd",
									width : 60,
									label : labels.errcd.label,
									align : "center"
								}, {
									key : "errnm",
									width : 200,
									label : labels.errnm.label,
									align : "left"
								}
							]
						}
					],	
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

	$('.getComps').on('change', function() {
		$(".getPyvnd1").val("");
		$(".getPyvnd2").val("");
	});
	
	$('.getGubcd').on('change', function() {
		if($(":input:radio[name=getGubcd]:checked").val() == "1"){
			grid = gridCheck;
			gridCheckinit(checkTitle);
			gridDataInit(grid.target, checkList);
		}else{
			grid = gridError;
			gridErrorinit(errorTitle);
			gridDataInit(grid.target, errorList);
		}
	});
	
	$('._excelBtn_').on('click', function() {
		if($(":input:radio[name=getGubcd]:checked").val() == "1") grid.target.exportExcel("서열형 일일출하및수주량 CHECK LIST.xls");
		else grid.target.exportExcel("서열형 일일출하및수주량 ERROR LIST.xls");
	});
});


/**
 * 업체코드로 업체명 검색하여 데이터 set
 * 
 * @param 업체코드
 */
function getCustSch(gubn, value) {
	if(value != ""){
		
		$.ajax({
			method : "post",
			url : "/ajaxCustomer/search.do",
			data : {
				"getCusno" : value,
				"getComps" : $("#getComps").val()
			},
			success : function(res) {
				var data = JSON.parse(res);			
				
				if (data.list.length == 0) {
					toastMsg(LN_IO_CHK1 + " : " + value);
					$('#getPyvnd' + gubn).val("");
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