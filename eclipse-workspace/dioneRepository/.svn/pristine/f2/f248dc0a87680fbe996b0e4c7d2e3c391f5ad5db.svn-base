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
var clsGridInputHandler = null,
	locGridInputHandler = null,
	teamGridInputHandler = null;

/**
 * [ko]조직도 객체
 */
function RelationObj (type, relationCode, relationName, useYn) {
	this.type = type;
	this.relationCode = relationCode;
	this.relationName = relationName;
	this.useYn = useYn;
}

/**
 * [ko]조직도 객체 + 권한
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
	//console.log("paramsType:" + params.type);
	var ajaxParams = $.extend({"sort": "RELATION"}, params)
	$.ajax({
		method : "post",
		url : "/ajaxRelation/init.do",
		data : ajaxParams,
		success : function(res) {
			//console.log(res);
			
			//선택한 값을 넣음
			if(params.type === "LOC") {
				$(".getCls").val(params.parentCode);
				$(".getLoc").val("");
			} else {
				$(".getLoc").val(params.parentCode);
			}
			
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
					toastMsg(LN_NO_DATA);
				}, 1000);
			}
		},
		error : function(res) {
			//console.log("error");
			//console.log(res);
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

/**
 * ======================================
 * [ko] 조직도 명칭으로 조직도 정보 검색하는 함수<br>
 * [KO] Argument: [1st argument] 검색값 Element <br>
 * [KO] Argument: [2st argument] 조직도 검색 type <br>
 * ======================================
 */
function searchRelation(input, type) {
	
	//상위 코드가 선택되었는지 확인
	if(!$(".getCls").val() && type === 'LOC'){
		toastMsg("사업부를 선택해주세요.");
		return false;
	}else if(!$(".getLoc").val()  && type === 'TEAM'){
		toastMsg("사업장을 선택해주세요.");
		return false;
	}
	
	$.ajax({
		method : "post",
		url : "/ajaxRelation/search.do",
		data : {
			"relationName" : input.value,
			"type" : type,
			"getCls" : $(".getCls").val(),
			"getLoc" : $(".getLoc").val()
		},
		success : function(res) {
			//console.log("searchRelation.dataset.success");
			//console.log("res:" + res);
			
			var data = JSON.parse(res);			
			
			if (data.list.length > 0) {
				if(type === 'CLS') {
					
					//하위조직도 등록시 사용하는 상위코드 초기화
					currClsCode = "";
					currLocCode = "";
					
					//console.log("searchRelation.ajax.Cls")
					clsGrid.target.setData({
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
					
				} else if(type === 'LOC') {
					
					//하위조직도 등록시 사용하는 상위코드 초기화
					currClsCode = "";
					currLocCode = "";
					
					//console.log("searchRelation.ajax.Loc")
					locGrid.target.setData({
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
				} else if(type === 'TEAM') {
					//console.log("searchRelation.ajax.Team")
					teamGrid.target.setData({
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
				}
				
			} else {
				setTimeout(function() {
					mask.close();
					toastMsg(LN_NO_DATA);
				}, 500);
			}
		},
		error : function(res) {
			//console.log("dataset.error")
			//console.log(res)
		},
		completed : function(res) {
			setTimeout(function() {
				mask.close();
				//console.log("dataset.completed")
				//console.log(res)
			}, 500);
			
		}
	});
}

/**
 * ==================================================================== 
 * [KO] Function: 등록폼에 입력한 조직도의 내용을 등록. <br>
 * [KO] Argument: [1st argument] 등록data <br>
 * [KO] Summary : 이함수는 화면에 입력한 조직도의 내용을 등록한다. <br>
 * [EN] Summary : <br>
 * ====================================================================
 */
function insertRelation(dataObj) {
	var ajaxParams = dataObj;
	if (dataObj.type !== "CLS") {
		var parentCode = "";
		if (dataObj.type === "LOC"){
			parentCode = currClsCode;
		} else {
			parentCode = currLocCode;
		}
		
		if(parentCode.trim() === "") {
			toastMsg(LN_NO_SELECT_PARENTCODE);
			gridBtnInit();
			return;
		} else {
			ajaxParams = $.extend({"parentCode": parentCode}, dataObj)
		}
	} 
	
	$.ajax({
		method : "post",
		url : "/ajaxRelation/create.do",
		data : ajaxParams,
		success : function(res) {
			//console.log("success");
			var data = JSON.parse(res);
			if (data.result === RESULT_OK) {
				
				//console.log(ajaxParams.type);
				if (ajaxParams.type === "CLS") {
					//console.log("insertCmc.CLS")
					clsGrid.setData("CLS");
				} else if (ajaxParams.type === "LOC") {
					//console.log("insertCmc.LOC")
					locGrid.setData("LOC", parentCode);
				} else if (ajaxParams.type === "TEAM") {
					//console.log("insertCmc.TEAM")
					teamGrid.setData("TEAM", parentCode);
				}

				toastMsg(RESULT_OK);
				setTimeout(function() {
					mask.close();
				}, 500);
			} else {
				setTimeout(function() {
					mask.close();
					toastMsg(data.errMsg);
				}, 500);
				
			}
		},
		error : function(res) {
			var data = JSON.parse(res);
			//console.log("error")
			toastMsg(data.errMsg);
			//console.log(res)
		},
		complete : function(res) {
			gridBtnInit();
			setTimeout(function() {
				mask.close();
				//console.log("completed");
				//console.log(res);
			}, 500);
		}
	});
}

/**
 * ==================================================================== 
 * [KO] Function: 화면에 입력한 조직도의 내용을 수정.<br> 
 * [KO] Argument: [1st argument] 수정할 내용객체(RelationObj or RelationTeamObj)<br>
 * [KO] Summary : 이함수는 화면에 입력한 조직도의 내용을 수정한다.<br>
 * [KO] Argument: [1st argument] RelationObj or RelationTeamObj<br>
 * [EN] Summary : <br>
 * ====================================================================
 */
function updateRelationCode(updateData) {
	var stateMsg,
		ajaxParams = updateData;
	
	$.ajax({
		url : "/ajaxRelation/update.do",
		type : "post",
		data : ajaxParams,
		success : function(res) {
			//console.log("updateRelationCode.success");
			var data = JSON.parse(res);
			if(data.result === RESULT_OK) {
				stateMsg = RESULT_OK;
			} else {
				//console.log("err");
				stateMsg = data.errMsg;
			}
			
		},
		error : function() {
			//console.log("updateRelationCode.error");
			stateMsg = "error";
		},
		complete : function() {
			//console.log("updateRelationCode.complete");
			//console.log("stateMsg:" + stateMsg);
			toastMsg(stateMsg);
			
		}
	});	
}

/*
 * ==================================================================== 
 * [KO] Function: 화면에 선택된 조직도 레코드를 삭제. 
 * [KO] Argument: [1st argument] relationCode String 
 * [KO] Argument: [2st argument] type String
 * [KO] Argument: [3st argument] delIndex number  
 * [KO] Summary : 이함수는 화면에 선택된 조직도 레코드를 삭제한다. 
 * [EN] Function: . 
 * [EN] Argument: [1st argument] relationCode String 
 * [EN] Argument: [2st argument] type String
 * [EN] Argument: [3st argument] delIndex number 
 * [EN] Summary : Execute delete process.
 *  ====================================================================
 */
function deleteRelation(relationCode, type, delIndex) {
	
	mask.open();
	var stateMsg = "";
	$.ajax({
		url : "/ajaxRelation/delete.do",
		type : "get",
		data : {
			"relationCode" : relationCode,
			"type" : type
		},
		success : function(res) {
			//console.log("deleteRelation.success");
			var data = JSON.parse(res);
			if(data.result === "OK") {
				stateMsg = "OK";
				if(type === "CLS") {
					clsGrid.target.deleteRow(delIndex);	
				} else if (type === "LOC") {
					locGrid.target.deleteRow(delIndex);
				} else if (type === "TEAM") {
					teamGrid.target.deleteRow(delIndex);
				}
			} else {
				//console.log("err");
				stateMsg = data.errMsg?data.errMsg:"";
			}
			
		},
		error : function() {
			//console.log("deleteRelation.error");
			stateMsg = "error";
		},
		complete : function() {
			//console.log("deleteRelation.complete");
			setTimeout(function() {
				mask.close();
				toastMsg(stateMsg);
			}, 1000);
			
		}
	});

}

function selectAuth(teamCode) {
	if(teamCode.trim() === "" ){
		toastMsg("권한선택은 부서등록 후 <br>선택하실 수 있습니다.")
		return false;
	}
	//console.log(teamCode);
	window.open("/WAD006AuthPopSelect/init.do?teamCode=" + teamCode, "authSelectPop", "width=950,height=700,scrollbars=yes,top=100,left=100");
	
}

ax5.ui.grid.tmpl.page_status = function() {
	return '<span>{{{progress}}} {{fromRowIndex}} - {{toRowIndex}} of {{dataRowCount}} {{#dataRealRowCount}}  '
			+ '현재페이지 {{.}}{{/dataRealRowCount}} {{#totalElements}}  전체갯수 {{.}}{{/totalElements}}</span>';
};

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
							if(this.column.key === "relationCode") {
								if(this.item.rowType !== "insert") {
										locGrid.setData("LOC", this.item.relationCode);
										currClsCode = this.item.relationCode;		
								}
								this.self.clearSelect();
								this.self.select(this.dindex);
							}
						},
					},
					contextMenu : {
						iconWidth : 20,
						acceleratorWidth : 100,
						itemClickAndClose : false,
						icons : {
							'arrow' : '<i class="fa fa-caret-right"></i>'
						},
						items : [{label : LN_DELETE/*삭제*/}],
						popupFilter : function(item, param) {
							if (param.element) {
								return true;
							} else {
								return item.type == 1;
							}
						},
						onClick : function(item, param) {
							clsGrid.target.contextMenu.close();
							
							if (item.label === LN_DELETE) {
							//if (item.label === '삭제하기') {
								deleteRelation(param.item.relationCode, 'CLS', param.dindex);
							} else if (item.label === '수정하기') {
							}
							// 또는 return true;
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
					columns : [ {
						key : "relationCode",
//						label : "사업부코드",
						label : labels.relationCode.label,
						width : 105,
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
					}, {
						key : "useYn",
//						label : "사용여부",
						label : labels.useYn.label,
						width : 60,
						sortable : false,
						editor : {
							type : "checkbox",
							config : {
								height : 17,
								trueValue : "Y",
								falseValue : "N"
							}
						},
						formatter:function(){		
							return clsGridInputHandler.getTextInput(this);
						}
					} ],
				});
		this.target.onLoad = function() {
			//console.log("");
		},
		this.target.onDataChanged = function() {
			//console.log("onDataChanged");
			//console.log(this.item.rowType);
			//입력폼이 아닐 때 
			if (this.item.rowType !== 'insert') {
				var updateData = new RelationObj("CLS", this.item.relationCode, this.item.relationName, this.item.useYn);
				updateRelationCode(updateData);	
			}
		}
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
							if(this.column.key === "relationCode") {
								if(this.item.rowType !== "insert") {
									teamGrid.setData("TEAM", this.item.relationCode);
									currLocCode = this.item.relationCode;
								}
								this.self.clearSelect();
								this.self.select(this.dindex);
							}
						},
					},
					contextMenu : {
						iconWidth : 20,
						acceleratorWidth : 100,
						itemClickAndClose : false,
						icons : {
							'arrow' : '<i class="fa fa-caret-right"></i>'
						},
						items : [{label : LN_DELETE /*삭제*/}],
						popupFilter : function(item, param) {
							if (param.element) {
								return true;
							} else {
								return item.type == 1;
							}
						},
						onClick : function(item, param) {
							locGrid.target.contextMenu.close();
							
							if (item.label === LN_DELETE) {
							//if (item.label === '삭제하기') {
								deleteRelation(param.item.relationCode, 'LOC', param.dindex);
							} else if (item.label === '수정하기') {
							}
							// 또는 return true;
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
					}, {
						key : "useYn",
//						label : "사용여부",
						label : labels.useYn.label,
						width : 60,
						sortable : false,
						editor : {
							type : "checkbox",
							config : {
								height : 17,
								trueValue : "Y",
								falseValue : "N"
							}
						},
						formatter:function(){							
							return locGridInputHandler.getTextInput(this);
						}
					} ],
				});
		this.target.onLoad = function() {
		},
		this.target.onDataChanged = function() {
			//console.log("onDataChanged");
			//console.log(this.item.rowType);
			//입력폼이 아닐 때 
			if (this.item.rowType !== 'insert') {
				var updateData = new RelationObj("LOC", this.item.relationCode, this.item.relationName, this.item.useYn);
				updateRelationCode(updateData);	
			}
		}
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
							if(this.column.key !=="authCode"){
								this.self.select(this.dindex);
							}
						},
					},
					contextMenu : {
						iconWidth : 20,
						acceleratorWidth : 100,
						itemClickAndClose : false,
						icons : {
							'arrow' : '<i class="fa fa-caret-right"></i>'
						},
						items : [{label : LN_DELETE/*삭제*/}],
						popupFilter : function(item, param) {
							if (param.element) {
								return true;
							} else {
								return item.type == 1;
							}
						},
						onClick : function(item, param) {
							
							if (item.label === LN_DELETE) {
							//if (item.label === '삭제하기') {
								deleteRelation(param.item.relationCode, 'TEAM', param.dindex);
							} else if (item.label === '수정하기') {
							}
							teamGrid.target.contextMenu.close();
							// 또는 return true;
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
						width : 105,
//						label : "사업부서명칭",
						label : labels.relationName.label,
						align : "center",
						editor : {
							type : "text"
						},
						formatter:function(){							
							return teamGridInputHandler.getTextInput(this);
						}
					}, {
						key : "useYn",
//						label : "사용여부",
						label : labels.useYn.label,
						width : 60,
						sortable : false,
						editor : {
							type : "checkbox",
							config : {
								height : 17,
								trueValue : "Y",
								falseValue : "N"
							}
						},
						formatter:function(){	
							
							return teamGridInputHandler.getTextInput(this);
						}
					}, {
						key : "authCode",
//						label : "권한",
						label : labels.authCode.label,
						align : "left",
						width : 100,
						editor : {
							type : ""
						},
						formatter:function(){	
							var teamCode = this.item.relationCode;
//							var thisIndex = e;
//							return teamGridInputHandler.getTextInput(this);
							return "<input type='button' class='AXButton Red gridBtn' value='권한선택' onClick='selectAuth(" + '"' + teamCode + '"' + ")'/>";
						}
					}, ],
				});
		this.target.onDataChanged = function() {
			//console.log("onDataChanged");
			
			//입력폼이 아닐 때 
			if (this.item.rowType !== 'insert') {
				var updateData = new RelationTeamObj("TEAM", this.item.relationCode, this.item.relationName, this.item.useYn);
				updateRelationCode(updateData);	
			}
		}
		return this;
	},
	setData : function(type, locCode, _pageNo) {
		mask.open();
		var thatTarget = this.target;
		var params = {
				"type": type,
				"parentCode": locCode,
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
	
	//등록버튼
	$("._addBtn_").on("click",function(){
		var target = this.getAttribute("data-click-target")
		saveBtnUiSet(this);
		if(target === "CLS") {
			clsGridInputHandler.addInput();
		} else if(target === "LOC") {
			locGridInputHandler.addInput();
		} else if(target === "TEAM") {
			teamGridInputHandler.addInput();
		} else {
			alert("잠시 후 시도해 주십시요");
		}
		/*this.style.display = "none";
		this.nextSibling.nextSibling.style.display = "inline-block";*/
		
	});
	
	//저장버튼
	$("._saveBtn_").on("click", function(){
		var check = confirm(LN_CONFIRM_SAVE);
		var saveCheck = false;
		var type = this.getAttribute("data-click-target")
		var checkInput;
		if(check){
			if(type === "CLS") {
				checkInput = clsGridInputHandler.saveData(function(data){
					
					if(!val_chk(data.relationName, "명칭")){
						return false;
					}
					
					var relationObj = new RelationObj(type, data.relationCode, data.relationName, data.useYn);
					insertRelation(relationObj);
					saveCheck = true;
					clsGridInputHandler.clearInput();	
					
				});
			} else if(type === "LOC") {
				//console.log("LOC save");
				checkInput = locGridInputHandler.saveData(function(data){
				
					if(!val_chk(data.relationName, "명칭")){
						return false;
					}
					
					var relationObj = new RelationObj(type, data.relationCode, data.relationName, data.useYn);
					insertRelation(relationObj);
					saveCheck = true;
					locGridInputHandler.clearInput();	
		
				});
			} else if(type === "TEAM") {
				checkInput = teamGridInputHandler.saveData(function(data){
					
					if(!val_chk(data.relationName, "명칭")){
						return false;
					}
					
					var relationTeamObj = new RelationTeamObj(type, data.relationCode, data.relationName, data.useYn);
					insertRelation(relationTeamObj);
					saveCheck = true;
					teamGridInputHandler.clearInput();	
			
				});
			} else {
				alert("잠시 후 시도해 주십시요");
			}
		}
		
		
		if(!checkInput){
			toastMsg(LN_PRESS_REGISTERBTN);
		}
		
		/*if(saveCheck){
			this.style.display = "none";
			this.previousSibling.previousSibling.style.display = "inline-block";
		}*/
	});

	/*$('[data-grid-control]').click(function() {
		var clickBtn = this.getAttribute("data-grid-control");
		if (clickBtn == "row-create") {
			var type = this.getAttribute("data-grid-type");
			insertCmc(type);
		} else if (clickBtn == "row-cancel") {
			$('#cmcAddBtn').css('display',
					'none');
		}
	});*/
	
	//등록폼 닫기버튼
	$("._closeBtn_").on("click",function(){
		var target = this.getAttribute("data-click-target");
		//console.log(target);
		addBtnUiSet(this);
		
		if (target === 'CLS') {
			clsGridInputHandler.clearInput();
		} else if (target === 'LOC') {
			locGridInputHandler.clearInput();
		} else if (target === 'TEAM') {
			teamGridInputHandler.clearInput();
		}
		
	});

});