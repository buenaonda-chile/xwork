/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
"use strict";
var currClsCode = "";
var currLocCode = "";
var currTeamCode = "";
var currClsRltnCode = "";
var currLocRltnCode = "";
var clsObj = null;
var locObj = null;
var teamObj = null;
var clsGridInputHandler = null,
	locGridInputHandler = null,
	teamGridInputHandler = null;

/**
 * [ko]조직도 객체
 * @param type  
 * @param relationCode
 * @param relationName
 * @param useYn
 */
function RelationObj (type, relationCode, relationName, useYn) {
	this.type = type;
	this.relationCode = relationCode;
	this.relationName = relationName;
	this.useYn = useYn;
}

/**
 * [ko]조직도 객체 + 권한
 * @param type  
 * @param relationCode
 * @param relationName
 * @param useYn
 * @param authCode
 */
function RelationTeamObj (type, relationCode, relationName, useYn, authCode) {
	RelationObj.apply(this, arguments);
	this.authCode = authCode;
}

/**
 * [ko]조직도 버튼 초기화
 */
/*function relationBtnInit() {
	var arrAddBtn = $('._addBtn_');
	var arrSaveBtn = $('._saveBtn_');
	for(var i=0; i<arrSaveBtn.length; i++){
		console.log("i:" + i);
		addBtnUiSet(arrSaveBtn[i]);
		$(arrAddBtn[i]).css("display", "inline-block");
		$(arrSaveBtn[i]).css("display", "none");
	}
}*/

/**
 * [KO] 그리드에 data 셋팅
 * @param params Obj 
 * @param _pageNo
 * @param gridTarget
 */
function setList(params, _pageNo, gridTarget) {
	console.log("paramsType:" + params.type);
	$.ajax({
		method : "post",
		url : "/ajaxRelation/init.do",
		data : params,
		success : function(res) {
			console.log(res);
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
				
				//조회그리드 외의 그리드 초기화
				if(params.type === "CLS") {
					gridDataInit(locGrid.target);
					gridDataInit(teamGrid.target);
				} else if(params.type === "LOC") {
					gridDataInit(teamGrid.target);
				} else {
					
				}
				
				setTimeout(function() {
					mask.close();
				}, 1000);
			} else {
				
				//하위그리드 데이터 조회일 때 초기화
				if(params.type === "CLS") {
					
					gridDataInit(gridTarget);
					gridDataInit(locGrid.target);
					gridDataInit(teamGrid.target);
					
					//조직도 등록 시 상위코드로 사용할 코드 초기화
					currClsCode = "";
					currLocCode = "";
					
				} else if(params.type === "LOC") {
					gridDataInit(locGrid.target);
					gridDataInit(teamGrid.target);
					
					//사업부서 등록 시 상위코드로 사용할 사업장 코드 초기화
					currLocCode = "";
					
				} else if(params.type === "TEAM"){
					gridDataInit(teamGrid.target);
				}
				
				setTimeout(function() {
					mask.close();
					toastMsg("데이터가 없습니다.");
				}, 1000);
			}
		},
		error : function(res) {
			console.log("error");
			console.log(res);
		},
		complete : function(res) {
			gridBtnInit();
			setTimeout(function() {
				mask.close();
			}, 1000);
			//console.log("completed");
			//console.log(res);
		}
	});
	//console.log('ajaxend');
	// return true;
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

// ===================== 사업부 그리드 ====================================/
var clsGrid = {
	initView : function(labels) {
		this.target = new ax5.ui.grid();
		this.target
				.setConfig({
					target : $('[data-ax5grid="cls-grid"]'),
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
							currClsRltnCode = this.item.rltnCode;
							currClsCode = this.item.relationCode;
							clsObj = new RelationObj("CLS", this.item.relationCode, this.item.relationName);
							locObj = null;
							teamObj = null;
							currLocRltnCode = null;
							locGrid.setData("LOC", this.item.relationCode);
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
					columns : [ {
						key : "relationCode",
//						label : "사업부코드",
						label : labels.relationCode.label,
						width : 105,
						styleClass : function() {
							return "ABC";
						},
						enableFilter : true,
						align : "center",
						editor : {
							/*type : "text",*/
							type : "",	//코드입력 비활성화를 위해 type 비움
							disabled : function() {
								// item, value
								return false;
							}
						},
						formatter:function(){							
							return clsGridInputHandler.getTextInput(this);
						}
					}, {
						key : "relationName",
						display: false,
						width : 105,
//						label : "사업부명칭",
						label : labels.relationName.label,
						align : "center",
						editor : {
							type : "text"
						},
						formatter:function(){							
							return clsGridInputHandler.getTextInput(this);
						}
					} ],
				});
		return this;
	},
	setData : function(type, clsCode, _pageNo) {
		mask.open();
		var gridTarget = this.target;
		var params = {
				"type": type,
				"clsCode": clsCode,
		};
		
		setList(params, _pageNo, gridTarget);
//		relationBtnInit();
		return this;
	}
};

// ===================== // 사업부 그리드 ====================================/

//===================== 사업장 그리드 ====================================/
var locGrid = {
	initView : function(labels) {
		this.target = new ax5.ui.grid();
		this.target
				.setConfig({
					target : $('[data-ax5grid="loc-grid"]'),
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
							locObj = new RelationObj("LOC", this.item.relationCode, this.item.relationName);
							teamObj = null;
							currLocCode = this.item.relationCode;
							currLocRltnCode = this.item.rltnCode;
							teamGrid.setData("TEAM", this.item.relationCode);
							
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
					columns : [ {
						key : "relationCode",
//						label : "사업장코드",
						label : labels.relationCode.label,
						width : 105,
						styleClass : function() {
							return "ABC";
						},
						enableFilter : true,
						align : "center",
						editor : {
							type : "",
							disabled : function() {
								// item, value
								return false;
							}
						},
						formatter:function(){
							return locGridInputHandler.getTextInput(this);
						}
					}, {
						key : "relationName",
						width : 105,
//						label : "사업장명칭",
						label : labels.relationName.label,
						align : "center",
						editor : {
							type : "text"
						},
						formatter:function(){							
							return locGridInputHandler.getTextInput(this);
						}
					} ],
				});
		return this;
	},
	setData : function(type, clsCode, _pageNo) {
		mask.open();
		var thatTarget = this.target;
		var params = {
				"type": type,
				"parentCode": clsCode,
		};
		setList(params, _pageNo, thatTarget);
//		relationBtnInit();
		return this;
	}
};

// ===================== // 사업장 그리드 ====================================/

// ===================== 사업부서 그리드 ====================================/
var teamGrid = {
	initView : function(labels) {
		this.target = new ax5.ui.grid();
		this.target
				.setConfig({
					target : $('[data-ax5grid="team-grid"]'),
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
							currTeamCode = this.item.relationCode;
							teamObj = new RelationObj("T", this.item.relationCode, this.item.relationName);
							
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
					columns : [ {
						key : "relationCode",
//						label : "사업부서코드",
						label : labels.relationCode.label,
						width : 105,
						styleClass : function() {
							return "ABC";
						},
						enableFilter : true,
						align : "center",
						editor : {
							type : "",
							disabled : function() {
								// item, value
								return false;
							}
						},
						formatter:function(){							
							return teamGridInputHandler.getTextInput(this);
						}
					}, {
						key : "relationName",
						width : 150,
//						label : "사업부서명칭",
						label : labels.relationName.label,
						align : "center",
						editor : {
							type : "text"
						},
						formatter:function(){							
							return teamGridInputHandler.getTextInput(this);
						}
					} ],
				});
		return this;
	},
	setData : function(type, locCode, _pageNo) {
		//2020.09.25 JHB 추가 : WAD013사용
		var allView= 'N';
		if($("input:checkbox[name=allView]").is(":checked") == true) {
			allView='Y';
		}
		mask.open();
		var thatTarget = this.target;
		var params = {
				"type": type, 
				"parentCode": locCode, 
				"allView": allView
		};
	
		setList(params, _pageNo, thatTarget);
//		relationBtnInit();
		return this;
	}
};
// ===================== // 사업부서 그리드 ====================================/

$(document.body).ready(function() {
	clsGridInputHandler = new GridInput(clsGrid);
	locGridInputHandler = new GridInput(locGrid);
	teamGridInputHandler = new GridInput(teamGrid);
	
	$('._closeBtn_').on( 'click', function(e){
		self.close();
	});
	
	$('._applyBtn_').on( 'click', function(e){
		if(clsObj === null){
			//toastMsg("사업부를 선택해주세요")
			toastMsg(LN_SELECT_CLS_CODE)
			return false;
		} else if (locObj === null) {
			//toastMsg("사업장을 선택해주세요")
			toastMsg(LN_SELECT_LOC_CODE)
			return false;
		} else if (teamObj === null) {
			//toastMsg("부서(팀)를 선택해주세요")
			toastMsg(LN_SELECT_TEAM_CODE)
			return false;
		}
		var params = {
				clsCode: clsObj.relationCode,
				clsRltnCode: currClsRltnCode,
				clsName: clsObj.relationName,
				locCode: locObj.relationCode,
				locRltnCode: currLocRltnCode,
				locName: locObj.relationName,
				teamCode: teamObj.relationCode,
				teamName: teamObj.relationName,
		};
		window.opener.getReturnValue(JSON.stringify(params));
		window.close();
	});

});