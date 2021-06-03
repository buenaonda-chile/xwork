/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
"use strict";
var currWorkLCode = "";
var currWorkMCode = "";
var workLGridInputHandler = null, workMGridInputHandler = null, workSGridInputHandler = null;

/**
 * [ko]업무분류 객체
 */
function WorkSortObj(type, workCode, workTypeNm, useYn) {
	this.type = type;
	this.workCode = workCode;
	this.workTypeNm = workTypeNm;
	this.useYn = useYn;
}

/**
 * [ko]업무분류 객체 + 승인사원 
 */
function WorkSortAprvObj(type, workCode, workTypeNm, useYn, aprvCode) {
	RelationObj.apply(this, arguments);
	this.aprvCode = aprvCode;
}

/**
 * [KO] 그리드에 data 셋팅
 * 
 * @param params Obj
 * @param _pageNo
 * @param gridTarget
 */
function setList(params, _pageNo, gridTarget) {
	//console.log("paramsType:" + params.type);
	var ajaxParams = $.extend({"sort": "WORK"}, params)
	$.ajax({
		method : "post",
		url : "/ajaxWorkSort/init.do",
		data : ajaxParams,
		success : function(res) {
   
			//선택한 값을 넣음
			if(params.type === "M") {
				$(".getWtcL").val(params.upperCode);
				$(".getWtcM").val("");
			} else {
				$(".getWtcM").val(params.upperCode);
			}
			//console.log(res);
			//console.log(res.language);
			var data = JSON.parse(res);
			//console.log(data.language);
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
				if(params.type === "L") {
					gridDataInit(workMGrid.target);
					gridDataInit(workSGrid.target);
				} else if(params.type === "M") {
					gridDataInit(workSGrid.target);
				} else {
					
				}
				
				setTimeout(function() {
					mask.close();
				}, 1000);
			} else {
				
				//하위그리드 데이터 조회일 때 초기화
				if(params.type === "L") {
					
					gridDataInit(gridTarget);
					gridDataInit(workMGrid.target);
					gridDataInit(workSGrid.target);
					
					//조직도 등록 시 상위코드로 사용할 코드 초기화
					currWorkLCode = "";
					currWorkMCode = "";
					
				} else if(params.type === "M") {
					gridDataInit(workMGrid.target);
					gridDataInit(workSGrid.target);
					
					//사업부서 등록 시 상위코드로 사용할 사업장 코드 초기화
					currWorkMCode = "";
					
				} else if(params.type === "S"){
					gridDataInit(workSGrid.target);
				}
				
				setTimeout(function() {
					mask.close();
					toastMsg("데이터가 없습니다.");
				}, 1000);
			}
		},
		error : function(res) {
//			console.log("error");
//			console.log(res);
		},
		complete : function(res) {
			gridBtnInit();
			setTimeout(function() {
				mask.close();
			}, 1000);
//			console.log("completed");
//			console.log(res);
		}
	});
}

/**
 * ==================================================================== [KO]
 * Function: 그리드 빈값으로 초기화. <br>
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
 * ====================================== [ko] 조직도 명칭으로 조직도 정보 검색하는 함수<br>
 * [KO] Argument: [1st argument] 검색값 Element <br>
 * [KO] Argument: [2st argument] 조직도 검색 type <br>
 * ======================================
 */
function searchWorkSort(input, type) {
	
	//상위 코드가 선택되었는지 확인
	if(!$(".getWtcL").val() && type === 'M'){
		toastMsg("업무분류(대)를 선택해주세요.");
		return false;
	}else if(!$(".getWtcM").val() && type === 'S'){
		toastMsg("업무분류(중)을 선택해주세요.");
		return false;
	}
	
	$.ajax({
		method : "post",
		url : "/ajaxWorkSort/search.do",
		data : {
			"teamCode" : $('#teamCode').val(),
			"workTypeNm" : input.value,
			"type" : type,
			"getWtcL" : $(".getWtcL").val(),
			"getWtcM" : $(".getWtcM").val()
		},
		success : function(res) {
			//console.log("searchWorkSort.dataset.success");
			///console.log("res:" + res);
			var data = JSON.parse(res);
			if (data.list.length > 0) {
				if (type === 'L') {

					// 하위조직도 등록시 사용하는 상위코드 초기화
					currWorkLCode = "";
					currWorkMCode = "";

					//console.log("searchWorkSort.ajax.Cls")
					workLGrid.target.setData({
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

				} else if (type === 'M') {

					// 하위조직도 등록시 사용하는 상위코드 초기화
					currWorkLCode = "";
					currWorkMCode = "";

					//console.log("searchWorkSort.ajax.M")
					workMGrid.target.setData({
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
				} else if (type === 'S') {
					//console.log("searchWorkSort.ajax.S")
					workSGrid.target.setData({
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
 * ==================================================================== [KO]
 * Function: 등록폼에 입력한 조직도의 내용을 등록. <br>
 * [KO] Argument: [1st argument] 등록data <br>
 * [KO] Summary : 이함수는 화면에 입력한 조직도의 내용을 등록한다. <br>
 * [EN] Summary : <br>
 * ====================================================================
 */
function insertWorSort(dataObj) {
	var ajaxParams = dataObj;
	var teamCode = $('#teamCode').val();
	ajaxParams = $.extend({"teamCode" : teamCode}, dataObj)
	console.log();
	if (dataObj.type !== "L") {
		var upperCode = "";
		if (dataObj.type === "M") {
			upperCode = currWorkLCode;
		} else {
			upperCode = currWorkMCode;
		}

		if (upperCode.trim() === "") {
			toastMsg(LN_NO_SELECT_PARENTCODE);
			gridBtnInit();
			return;
		} else {
			ajaxParams = $.extend({
				"upperCode" : upperCode
			}, ajaxParams)
		}
	} 

	$.ajax({
		method : "post",
		url : "/ajaxWorkSort/create.do",
		data : ajaxParams,
		success : function(res) {
			//console.log("success");
			var data = JSON.parse(res);
			if (data.result === RESULT_OK) {

				console.log(ajaxParams.type);
				if (ajaxParams.type === "L") {
					//console.log("insert.L")
					workLGrid.setData("L");
				} else if (ajaxParams.type === "M") {
					//console.log("insert.M")
					workMGrid.setData("M", upperCode);
				} else if (ajaxParams.type === "S") {
					//console.log("insert.S")
					workSGrid.setData("S", upperCode);
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
 * ==================================================================== [KO]
 * Function: 화면에 입력한 조직도의 내용을 수정.<br>
 * [KO] Argument: [1st argument] 수정할 내용객체(RelationObj or RelationTeamObj)<br>
 * [KO] Summary : 이함수는 화면에 입력한 조직도의 내용을 수정한다.<br>
 * [KO] Argument: [1st argument] RelationObj or RelationTeamObj<br>
 * [EN] Summary : <br>
 * ====================================================================
 */
function updateWorkSort(updateData) {
	var stateMsg, ajaxParams = updateData;

	$.ajax({
		url : "/ajaxWorkSort/update.do",
		type : "post",
		data : ajaxParams,
		success : function(res) {
			//console.log("updateWorkSort.success");
			var data = JSON.parse(res);
			if (data.result === RESULT_OK) {
				stateMsg = RESULT_OK;
			} else {
				//console.log("err");
				stateMsg = data.errMsg;
			}

		},
		error : function() {
			//console.log("updateWorkSort.error");
			stateMsg = "error";
		},
		complete : function() {
			//console.log("updateWorkSort.complete");
			//console.log("stateMsg:" + stateMsg);
			toastMsg(stateMsg);

		}
	});
}

/*
 * ==================================================================== [KO]
 * Function: 화면에 선택된 조직도 레코드를 삭제. [KO] Argument: [1st argument] relationCode
 * String [KO] Argument: [2st argument] type String [KO] Argument: [3st
 * argument] delIndex number [KO] Summary : 이함수는 화면에 선택된 조직도 레코드를 삭제한다. [EN]
 * Function: . [EN] Argument: [1st argument] relationCode String [EN] Argument:
 * [2st argument] type String [EN] Argument: [3st argument] delIndex number [EN]
 * Summary : Execute delete process.
 * ====================================================================
 */
function deleteWorkSort(workCode, type, delIndex) {

	mask.open();
	var stateMsg = "";
	$.ajax({
		url : "/ajaxWorkSort/delete.do",
		type : "get",
		data : {
			"workCode" : workCode,
			"type" : type
		},
		success : function(res) {
			//console.log("deleteWorkSort.success");
			var data = JSON.parse(res);
			if (data.result === "OK") {
				stateMsg = "OK";
				if (type === "L") {
					workLGrid.target.deleteRow(delIndex);
				} else if (type === "M") {
					workMGrid.target.deleteRow(delIndex);
				} else if (type === "S") {
					workSGrid.target.deleteRow(delIndex);
				}
			} else {
				//console.log("err");
				stateMsg = data.errMsg ? data.errMsg : "";
			}

		},
		error : function() {
			//console.log("deleteWorkSort.error");
			stateMsg = "error";
		},
		complete : function() {
			//console.log("deleteWorkSort.complete");
			setTimeout(function() {
				mask.close();
				toastMsg(stateMsg);
			}, 1000);

		}
	});

}

/**
 * 
 * @param workCode
 */
function selectAprvEmp (workCode) {
	if(workCode.trim() === "" ){
		toastMsg("승인관리자 선택은 업무분류등록 후 <br>선택하실 수 있습니다.")
		return false;
	}
	//console.log(workCode);
	window.open("/WAB001EmpSearch/empSelectPop.do?workCode=" + workCode, "workAprvEmpSelectPop", "width=950,height=700,scrollbars=yes,top=100,left=100");
}

/*ax5.ui.grid.tmpl.page_status = function() {
	return '<span>{{{progress}}} {{fromRowIndex}} - {{toRowIndex}} of {{dataRowCount}} {{#dataRealRowCount}}  '
			+ '현재페이지 {{.}}{{/dataRealRowCount}} {{#totalElements}}  전체갯수 {{.}}{{/totalElements}}</span>';
};*/

// ===================== 업무분류(대) 그리드 ====================================/
var workLGrid = {
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
							if (this.column.key === "workCode") {
								if (this.item.rowType !== "insert") {
									workMGrid.setData("M", this.item.workCode);
									currWorkLCode = this.item.workCode;
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
						items : [ {
							label : LN_DELETE/*삭제*/
						} ],
						popupFilter : function(item, param) {
							if (param.element) {
								return true;
							} else {
								return item.type == 1;
							}
						},
						onClick : function(item, param) {
							workLGrid.target.contextMenu.close();
							//if (item.label === '삭제하기') {
							if (item.label === LN_DELETE) {
								deleteWorkSort(param.item.workCode, 'L', param.dindex);
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
						key : "workCode",
						label : labels.cmcCode.label,
						width : 80,
						styleClass : function() {
							return "ABC";
						},
						enableFilter : true,
						align : "center",
						editor : {
							/* type : "text", */
							type : "", // 코드입력 비활성화를 위해 type 비움
							disabled : function() {
								// item, value
								return false;
							}
						},
						formatter : function() {
							return workLGridInputHandler.getTextInput(this);
						}
					}, {
						key : "workTypeNm",
						width : 190,
						label : labels.cnmName.label,
						align : "center",
						editor : {
							type : "text"
						},
						formatter : function() {
							return workLGridInputHandler.getTextInput(this);
						}
					}, {
						key : "useYn", 
						label : labels.cmcUseYN.label,
						width : 60, 
						sortable : false, 
						editor : { 
							type : "checkbox", 
							config : { height : 17, trueValue : "Y", falseValue : "N" } 
						},
						formatter:function(){ 
							//console.log(this);
							return workLGridInputHandler.getTextInput(this); } 
						}
					 ],
				});
		this.target.onLoad = function() {
			//console.log("");
		}, this.target.onDataChanged = function() {
			//console.log("onDataChanged");
			//console.log(this.item.rowType);
			// 입력폼이 아닐 때
			if (this.item.rowType !== 'insert') {
				var updateData = new WorkSortObj("L", this.item.workCode,
						this.item.workTypeNm, this.item.useYn);
				updateWorkSort(updateData);
			}
		}
		return this;
	},
	setData : function(type, workCode, _pageNo) {
		mask.open();
		var gridTarget = this.target;
		var teamCode = $('#teamCode').val();
		var params = {
			"type" : type,
			"teamCode" : teamCode,
			"workCode" : workCode,
		};

		setList(params, _pageNo, gridTarget);
//		relationBtnInit();
		return this;
	}
};

// ===================== // 업무분류(대) 그리드 ====================================/

// ===================== 업무분류(중) 그리드 ====================================/
var workMGrid = {
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
							if (this.column.key === "workCode") {
								if (this.item.rowType !== "insert") {
									workSGrid.setData("S", this.item.workCode);									
									currWorkMCode = this.item.workCode;
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
						items : [ {
							label : LN_DELETE/*삭제*/
						} ],
						popupFilter : function(item, param) {
							if (param.element) {
								return true;
							} else {
								return item.type == 1;
							}
						},
						onClick : function(item, param) {
							workMGrid.target.contextMenu.close();
							
							//if (item.label === '삭제하기') {
							if (item.label === LN_DELETE) {
								deleteWorkSort(param.item.workCode, 'M', param.dindex);
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
						key : "workCode",
						label : labels.cmcCode.label,
						width : 80,
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
						formatter : function() {
							return workMGridInputHandler.getTextInput(this);
						}
					}, {
						key : "workTypeNm",
						width : 190,
						label : labels.cnmName.label,
						align : "center",
						editor : {
							type : "text"
						},
						formatter : function() {
							return workMGridInputHandler.getTextInput(this);
						}
					}, {
						key : "useYn",
						label :labels.cmcUseYN.label,
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
						formatter : function() {
							return workMGridInputHandler.getTextInput(this);
						}
					}, {
						key : "aprvCode",
						label : labels.cmcMngt.label,//승인관리자
//						label : labels.authCode.label,
						align : "left",
						width : 90,
						editor : {
							type : ""
						},
						formatter:function(){	
							var workCode = this.item.workCode;
//							var thisIndex = e;
//							return teamGridInputHandler.getTextInput(this);
							return "<input type='button' class='AXButton Red gridBtn' title='" + LN_APRV_MNG + "' value='" + LN_APRV_MNG + "' onClick='selectAprvEmp(" + '"' + workCode + '"' + ")'/>";
						}
					},
					],
				});
		this.target.onLoad = function() {
		}, this.target.onDataChanged = function() {
			//console.log("onDataChanged");
			//console.log(this.item.rowType);
			// 입력폼이 아닐 때
			if (this.item.rowType !== 'insert') {
				var updateData = new WorkSortObj("M", this.item.workCode, this.item.workTypeNm, this.item.useYn);
				updateWorkSort(updateData);
			}
		}
		return this;
	},
	setData : function(type, workCode, _pageNo) {
		mask.open();
		var thatTarget = this.target;
		var params = {
			"type" : type,
			"upperCode" : workCode,
		};
		setList(params, _pageNo, thatTarget);
//		relationBtnInit();
		return this;
	}
};

// ===================== // 업무분류(중) 그리드 ====================================/

// ===================== 업무분류(소) 그리드 ====================================/
var workSGrid = {
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
						items : [ {
							label : LN_DELETE/*삭제*/
						} ],
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
								deleteWorkSort(param.item.workCode, 'S', param.dindex);
							} else if (item.label === '수정하기') {
							}
							workSGrid.target.contextMenu.close();
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
					columns : [
							{
								key : "workCode",
								label : labels.cmcCode.label,
								width : 80,
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
								formatter : function() {
									return workSGridInputHandler.getTextInput(this);
								}
							},
							{
								key : "workTypeNm",
								width : 190,
								label : labels.cnmName.label,
								align : "center",
								editor : {
									type : "text"
								},
								formatter : function() {
									return workSGridInputHandler.getTextInput(this);
								}
							}, {
								key : "useYn",
								label : labels.cmcUseYN.label,
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
								formatter : function() {
									return workSGridInputHandler.getTextInput(this);
								}
							},
						],
				});
		this.target.onDataChanged = function() {
			//console.log("onDataChanged");

			// 입력폼이 아닐 때
			if (this.item.rowType !== 'insert') {
				var updateData = new WorkSortObj("S", this.item.workCode, this.item.workTypeNm, this.item.useYn);
				updateWorkSort(updateData);
			}
		}
		return this;
	},
	setData : function(type, workCode, _pageNo) {
		mask.open();
		var thatTarget = this.target;
		var params = {
			"type" : type,
			"upperCode" : workCode,
		};

		setList(params, _pageNo, thatTarget);
//		relationBtnInit();
		return this;
	}
};
// ===================== // 업무분류(소) 그리드 ====================================/

$(document.body).ready(function() {
	workLGridInputHandler = new GridInput(workLGrid);
	workMGridInputHandler = new GridInput(workMGrid);
	workSGridInputHandler = new GridInput(workSGrid);

	// 등록버튼
	$("._addBtn_").on("click",function() {
		var target = this.getAttribute("data-click-target")
		saveBtnUiSet(this);

		if (target === "L") {
			workLGridInputHandler.addInput();
		} else if (target === "M") {
			workMGridInputHandler.addInput();
		} else if (target === "S") {
			workSGridInputHandler.addInput();
		} else {
			alert("잠시 후 시도해 주십시요");
		}
//		this.style.display = "none";
//		this.nextSibling.nextSibling.style.display = "inline-block";

	});

	//저장버튼
	$("._saveBtn_").on("click", function(){
		var check = confirm(LN_CONFIRM_SAVE);
		var saveCheck = false;
		var type = this.getAttribute("data-click-target")
		var checkInput;
		if(check){
			if(type === "L") {
				checkInput = workLGridInputHandler.saveData(function(data){
					
					if(!val_chk(data.workTypeNm, "명칭")){
						return false;
					}
					
					//console.log("type:" + type);
					//console.log("workCode:" + data.workCode);
					//console.log("workTypeNm:" + data.workTypeNm);
					//console.log("useYn:" + data.useYn);
					if (data.useYn === ''){
						data.useYn = 'N';
					}
					var workLObj = new WorkSortObj(type, data.workCode, data.workTypeNm, data.useYn);
					insertWorSort(workLObj);
					saveCheck = true;
					workLGridInputHandler.clearInput();	
					
				});
			} else if(type === "M") {
				//console.log("M save");
				checkInput = workMGridInputHandler.saveData(function(data){
				
					if(!val_chk(data.workTypeNm, "명칭")){
						return false;
					}
					
					if (data.useYn === ''){
						data.useYn = 'N';
					}
					
					var workMObj = new WorkSortObj(type, data.workCode, data.workTypeNm, data.useYn);
					insertWorSort(workMObj);
					saveCheck = true;
					workMGridInputHandler.clearInput();	
		
				});
			} else if(type === "S") {
				checkInput = workSGridInputHandler.saveData(function(data){
					
					if(!val_chk(data.workTypeNm, "명칭")){
						return false;
					}
					
					if (data.useYn === ''){
						data.useYn = 'N';
					}
					
					var workSObj = new WorkSortObj(type, data.workCode, data.workTypeNm, data.useYn);
					insertWorSort(workSObj);
					saveCheck = true;
					workSGridInputHandler.clearInput();	
			
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

	$('[data-grid-control]').click(function() {
		var clickBtn = this.getAttribute("data-grid-control");
		if (clickBtn == "row-create") {
			var type = this.getAttribute("data-grid-type");
			insertCmc(type);
		} else if (clickBtn == "row-cancel") {
			$('#cmcAddBtn').css('display', 'none');
		}
	});
	
	//등록폼 닫기버튼
	$("._closeBtn_").on("click",function(){
		var target = this.getAttribute("data-click-target");
		//console.log(target);
		addBtnUiSet(this);
		
		if (target === 'L') {
			workLGridInputHandler.clearInput();
		} else if (target === 'M') {
			workMGridInputHandler.clearInput();
		} else if (target === 'S') {
			workSGridInputHandler.clearInput();
		}
		
	});

});