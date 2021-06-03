/*
 * Project : DNKR
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
"use strict";
var parentCode = "";
var mainCodeGridInputHandler = null;
var subCodeGridInputHandler = null;

/**
 * [ko] 그리드에 data 셋팅
 * @param type 
 * @param _pageNo
 */
function setList(type, _pageNo) {
	$.ajax({
		method : "post",
		url : "/ajaxCode/init.do",
		data : {
			"cmcType" : type
		},
		success : function(res) {
			var data = JSON.parse(res);
			if (data.list.length > 0) {
				cmcGrid.setData({
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
				}, 500);
			} else {
				setTimeout(function() {
					mask.close();
					toastMsg(LN_NO_DATA);
				}, 500);
			}
		},
		error : function(res) {
			//console.log("error")
			//console.log(res)
		},
		complete : function(res) {
			setTimeout(function() {
				mask.close();
			}, 500);
			//console.log("completed")
			//console.log(res)
		}
	});
	//console.log('ajaxend');
	// return true;
}

/**
 * [ko]메인 공통코드 객체
 */
function CmcObj(cmcType, cmcCode, cnmName, cmcUseYn) {
	this.cmcType = cmcType;
	this.cmcCode = cmcCode;
	this.cnmName = cnmName;
	this.cmcUseYn = cmcUseYn;
}

/**
 * [ko]서브 공통코드 객체
 */
function SubCmcObj(cmcType, cmcCode, cnmName, cmcUseYn, parentCode, cnmDesc) {
	CmcObj.apply(this, arguments);
	this.cmcParentCode = parentCode;
	this.cnmDescription = cnmDesc;
}

/**
 * [ko] 코드번호로 공통코드정보 조회하는 함수
 */
function searchCmc(input, type) {
	$.ajax({
		method : "post",
		url : "/ajaxCode/search.do",
		data : {
			"cnmName" : input.value,
			"cmcType" : type
		},
		success : function(res) {
			//console.log("searchCmc.dataset.success");
			//console.log("res:" + res);
			var data = JSON.parse(res);
			if (data.list.length > 0) {
				if(type === 'MAIN') {
					//console.log("searchCmc.ajax.Main")
					cmcGrid.target.setData({
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
					//console.log("searchCmc.ajax.Sub")
					subCmcGrid.target.setData({
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
 * [ko] 공통코드 등록하는 함수
 * @param dataObj
 */
function insertCmc(dataObj) {
	var ajaxParams = dataObj;
	var cmcCode = dataObj.cmcCode;
	if (dataObj.cmcType === "SUB") {
		if(parentCode.trim() === "") {
			toastMsg(LN_NO_SELECT_PARENTCODE);
			gridBtnInit();
			return;
		}
	} 
	
	ajaxParams.toString();
	$.ajax({
		method : "post",
		url : "/ajaxCode/create.do",
		data : ajaxParams,
		success : function(res) {
			//console.log("success");
			var data = JSON.parse(res);
			if (data.result === RESULT_OK) {
				
				if(cmcCode === undefined || cmcCode === ""){
					cmcCode = data.cmcCode;
				}
				//console.log(ajaxParams.type);
				if (ajaxParams.cmcType == 'MAIN') {
					//console.log("insertCmc.mains")
					cmcGrid.setData("MAIN");
				} else {
					//console.log("insertCmc.SUB")
					subCmcGrid.setData("SUB", parentCode);
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
				//console.log("completed")
				//console.log(res)
			}, 500);
		}
	});
}

/*
 * ==================================================================== 
 * [KO] Function: 화면에 입력한 공통코드의 내용을 수정. 
 * [KO] Argument: [1st argument] target form
 * [KO] [2st argument] path from context-root 
 * [KO] [3st argument] target index
 * [KO] Summary : 이함수는 화면에 입력한 공통코드의 내용을 수정한다. 
 * [KO] Argument: [1st argument] target form 
 * [KO] [2st argument] path from context-root 
 * [KO] [3st argument] target index 
 * [EN] Summary : I return sub common code information of selected
 * 		common code on Screen.
 * ====================================================================
 */
function updateCmcCode(updateData) {
	var stateMsg,
		ajaxParams = updateData;
	
	$.ajax({
		url : "/ajaxCode/update.do",
		type : "post",
		data : ajaxParams,
		success : function(res) {
			//console.log("updateCmcCode.success");
			var data = JSON.parse(res);
			if(data.result === RESULT_OK) {
				stateMsg = RESULT_OK;
			} else {
				//console.log("err");
				stateMsg = data.errMsg;
			}
			
		},
		error : function() {
			//console.log("updateCmcCode.error");
			stateMsg = "error";
		},
		complete : function() {
			//console.log("updateCmcCode.complete");
			//console.log("stateMsg:" + stateMsg);
			toastMsg(stateMsg);
			
		}
	});	
}

/*
 * ==================================================================== 
 * [KO] Function: 화면에 선택된 공통코드를 삭제. 
 * [KO] Argument: [1st argument] Common code 
 * [KO] Argument: [2st argument] Common code type 
 * [KO] Summary : 이함수는 화면에 선택된 공통코드를 삭제한다. 
 * [EN] Function: . 
 * [EN] Argument: [1st argument] Common code 
 * [EN] Argument: [1st argument] Common code type 
 * [EN] Summary : Execute delete process.
 *  ====================================================================
 */
function deleteCmc(cmcCode, cmcType, delIndex) {
	mask.open();
	var stateMsg = "";
	$.ajax({
		url : "/ajaxCode/delete.do",
		type : "get",
		data : {
			"cmcCode" : cmcCode,
			"cmcType" : cmcType
		},
		success : function(res) {
			//console.log("deleteCmcCode.success");
			var data = JSON.parse(res);
			if(data.result === RESULT_OK) {
				stateMsg = RESULT_OK;
				if(cmcType === "MAIN") {
					cmcGrid.target.deleteRow(delIndex);	
				} else if (cmcType === "SUB") {
					subCmcGrid.target.deleteRow(delIndex);
				}
			} else {
				//console.log("err");
				stateMsg = data.errMsg;
			}
			
		},
		error : function() {
			//console.log("deleteCmcCode.error");
			stateMsg = "error";
		},
		complete : function() {
			//console.log("deleteCmcCode.complete");
			setTimeout(function() {
				mask.close();
				toastMsg(stateMsg);
			}, 500);
			
		}
	});

}

ax5.ui.grid.tmpl.page_status = function() {
	return '<span>{{{progress}}} {{fromRowIndex}} - {{toRowIndex}} of {{dataRowCount}} {{#dataRealRowCount}}  '
			+ '현재페이지 {{.}}{{/dataRealRowCount}} {{#totalElements}}  전체갯수 {{.}}{{/totalElements}}</span>';
};

// ===================== 상위코드 그리드 ====================================/
var cmcGrid = {
	initView : function(labels) {
		this.target = new ax5.ui.grid();
		this.target
				.setConfig({
					target : $('[data-ax5grid="cmc-grid"]'),
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
							//console.log(this.item);
							//console.log(this.column.key);
							if(this.column.key === 'cmcCode'){
								if(this.item.rowType !== 'insert'){
									subCmcGrid.setData("SUB", this.item.cmcCode);
									parentCode = this.item.cmcCode;
								}
								this.self.clearSelect();
								this.self.select(this.dindex);
							}
						},
						onDBLClick : function () {
							//console.log("dbl");
							//console.log(this.item.rowType);
							if (this.item.rowType !== 'insert') {
								subCmcGrid.setData("SUB", this.item.cmcCode);
								parentCode = this.item.cmcCode;
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
						items : [{label : LN_DELETE}],
						popupFilter : function(item, param) {
							if (param.element) {
								return true;
							} else {
								return item.type == 1;
							}
						},
						onClick : function(item, param) {
							cmcGrid.target.contextMenu.close();
							if (item.label === LN_DELETE) {
								var check = confirm(LN_CONFIRM_DELETE);
								if (check) {
									deleteCmc(param.item.cmcCode, 'MAIN', param.dindex);
								}
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
						key : "cmcCode",
						label : labels.cmcCode.label,
						width : 130,
						styleClass : function() {
							return "ABC";
						},
						enableFilter : true,
						align : "center",
						editor : {
							type : "",
							disabled : function() {
								// item, value
								return true;
							}
						},
						formatter:function(){							
							return mainCodeGridInputHandler.getTextInput(this);
						}
					}, {
						key : "cnmName",
						width : 150,
						label : labels.cnmName.label,
						align : "center",
						editor : {
							type : "text"
						},
						formatter:function(){							
							return mainCodeGridInputHandler.getTextInput(this);
						}
					}, {
						key : "cmcUseYN",
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
						formatter:function(){							
							return mainCodeGridInputHandler.getTextInput(this);
						}
					} ],
				});
		this.target.onLoad = function() {
			//console.log("################");
		},
		this.target.onDataChanged = function() {
			//console.log("onDataChanged");
			//console.log(this.item.rowType);
			//입력폼이 아닐 때 
			if (this.item.rowType !== 'insert') {
				var updateData = new CmcObj("MAIN", this.item.cmcCode, this.item.cnmName, this.item.cmcUseYN);
				updateCmcCode(updateData);	
			}
		}
		return this;
	},
	setData : function(type, _pageNo) {
		mask.open();
		var thatTarget = this.target;
		var list = [];
		$.ajax({
			method : "post",
			url : "/ajaxCode/init.do",
			data : {
				"cmcType" : type
			},
			success : function(res) {
				//console.log("dataset.success")
				var data = JSON.parse(res);
				if (data.list.length > 0) {
					
					thatTarget.setData({
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
					}, 500);
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
			complete : function(res) {
				//console.log("code set data.complete");
				gridBtnInit();
				setTimeout(function() {
					mask.close();
					//console.log("dataset.completed")
					//console.log(res)
				}, 500);
				
			}
		});
		return this;
	}
};

// ===================== // 상위코드 그리드 ====================================/

// ===================== 하위코드 그리드 ====================================/
var subCmcGrid = {
	initView : function(labels) {
		this.target = new ax5.ui.grid();
		this.target
				.setConfig({
					target : $('[data-ax5grid="cnm-grid"]'),
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
						items : [{label : LN_DELETE}],
						popupFilter : function(item, param) {
							if (param.element) {
								return true;
							} else {
								return item.type == 1;
							}
						},
						onClick : function(item, param) {
							if (item.label === LN_DELETE) {
								var check = confirm(LN_CONFIRM_DELETE);
								if (check) {
//								if (item.label === '삭제하기') {
									deleteCmc(param.item.cmcCode, 'SUB', param.dindex);
								}	
							} else if (item.label === '수정하기') {
							}
							subCmcGrid.target.contextMenu.close();
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
						key : "cmcCode",
//						label : "코드",
						label : labels.cmcCode.label,
						width : 130,
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
							return subCodeGridInputHandler.getTextInput(this);
						}
					}, {
						key : "cnmName",
						width : 150,
//						label : "코드명",
						label : labels.cnmName.label,
						align : "center",
						editor : {
							type : "text"
						},
						formatter:function(){							
							return subCodeGridInputHandler.getTextInput(this);
						}
					}, {
						key : "cmcUseYN",
//						label : "사용여부",
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
						formatter:function(){							
							return subCodeGridInputHandler.getTextInput(this);
						}
					}, {
						key : "cnmDescription",
//						label : "코드설명",
						label : labels.cnmDescription.label,
						align : "left",
						width : 283,
						editor : {
							type : "text"
						},
						formatter:function(){							
							return subCodeGridInputHandler.getTextInput(this);
						}
					}, ],
				});
			this.target.onDataChanged = function() {
			//console.log("onDataChanged");
			//입력폼이 아닐 때 
			if (this.item.rowType !== 'insert') {
				var updateData = new SubCmcObj("SUB", this.item.cmcCode, this.item.cnmName, this.item.cmcUseYN, parentCode, this.item.cnmDescription);
				updateCmcCode(updateData);
			}
		}
		return this;
	},
	setData : function(type, cmcCode, _pageNo) {
		mask.open();
		var thatTarget = this.target;
		var list = [];

		$.ajax({
			method : "post",
			url : "/ajaxCode/init.do",
			data : {
				"cmcType" : type,
				"cmcCode" : cmcCode
			},
			success : function(res) {
				var data = JSON.parse(res);
				if (data.list.length > 0) {
					thatTarget.setData({
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
					}, 500);
				} else {
					setTimeout(function() {
						mask.close();
						toastMsg(LN_NO_DATA);
					}, 500);
					
					thatTarget.setData({
						list : [],
						page : {
							currentPage : _pageNo || 0,
							pageSize : 50,
							totalElements : 500,
							totalPages : 100
						}
					});

				}
			},
			error : function(res) {
				//console.log("error")
				//console.log(res)
			},
			complete : function(res) {
				gridBtnInit();
				//console.log("completed")
				//console.log(res)
			}
		});

		return this;
	}
};
// ===================== // 하위코드 그리드 ====================================/



$(document.body).ready(function() {

	mainCodeGridInputHandler = new GridInput(cmcGrid);
	subCodeGridInputHandler = new GridInput(subCmcGrid);
	
	//상위코드 등록버튼
	$("._addBtn_").on("click",function(){
		saveBtnUiSet(this);
		mainCodeGridInputHandler.addInput();
	});
	
	//저장버튼
	$("._saveBtn_").on("click",function(){
		var target = this.getAttribute("data-click-target");
		var checkInput;
		if(target === 'MAIN'){
			checkInput = mainCodeGridInputHandler.saveData(function(data){
				if(!val_chk(data.cnmName, "명칭")){
					return false;
				}
				
				var check = confirm(LN_CONFIRM_SAVE);
				if (check) {
					var cmcObj = new CmcObj("MAIN", data.cmcCode, data.cnmName, data.cmcUseYn);
					insertCmc(cmcObj);
					mainCodeGridInputHandler.clearInput();	
				}
			});
		} else if (target === 'SUB') {
			checkInput = subCodeGridInputHandler.saveData(function(data){
				if(!val_chk(data.cnmName, "명칭")){
					return false;
				}
				var check = confirm(LN_CONFIRM_SAVE);
				if (check) {
					var subCmcObj = new SubCmcObj("SUB", data.cmcCode, data.cnmName, data.cmcUseYN, parentCode, data.cnmDescription);
					insertCmc(subCmcObj);
					subCodeGridInputHandler.clearInput();
				}
			});
		}
		
		if(checkInput == false){
			toastMsg(LN_PRESS_REGISTERBTN);
		}	
		
	});
	
	//하위코드 등록버튼
	$("._addSubBtn_").on("click",function(){
		saveBtnUiSet(this);
		subCodeGridInputHandler.addInput();
	});
	
	//등록폼 닫기버튼
	$("._closeBtn_").on("click",function(){
		
		addBtnUiSet(this);
		
		var target = this.getAttribute("data-click-target");
		
		if (target === 'MAIN') {
			mainCodeGridInputHandler.clearInput();
		} else if (target === 'SUB') {
			subCodeGridInputHandler.clearInput();
		}
		
	});
	
	//초기화 버튼
	$("._addSubBtn3_").on("click",function(){
		subCodeGridInputHandler.clearInputData();
	});

	$('[data-grid-control]').click(function() {
		var clickBtn = this.getAttribute("data-grid-control");
		if (clickBtn == "row-create") {
			var type = this.getAttribute("data-grid-type");
			insertCmc(type);
		} else if (clickBtn == "row-cancel") {
			$('#cmcAddBtn').css('display',
					'none');
		}
	});

});