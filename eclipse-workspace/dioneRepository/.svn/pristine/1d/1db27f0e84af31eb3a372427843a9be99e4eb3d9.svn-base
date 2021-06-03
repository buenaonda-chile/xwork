/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
"use strict";
var currDepth1Code,
	currDepth2Code,
	currTarget,
	currGrid,
	currGridIndex,
	currGridItem,
	depth1GridInputHandler = null,
	depth2GridInputHandler = null,
	depth3GridInputHandler = null;

/**
 * [ko]메뉴 객체
 * 
 * @param mcdCode
 * @param mcdName
 * @param mcdUse
 * @param mcdDepth
 * @param mcdRef
 * @param mcdSort
 */
function MenuObj (mcdCode, mcdName, mcdUse, mcdDepth, mcdRef, mcdSort) {
	this.mcdCode = mcdCode;
	this.mcdName = mcdName;
	this.mcdUse = mcdUse;
	this.mcdDepth = mcdDepth;
	this.mcdRef = mcdRef;
	this.mcdSort = mcdSort;
}

/**
 * ajax로 결과 체크하기
 * @param url
 */
function getAjaxDomain (url, params, pType) {
	if(pType === undefined) {
		pType = "GET";
	}
	var resultObj;
	$.ajax({
		url: url,
		type    : pType,
		async : false,
		data : params,
		success : function (data){
			console.log(data);
			try{
				var parse = JSON.parse(data);
				resultObj = parse;
			}catch(e){
				console.log(e);
			}
		},
		error: function(e){ 
			console.log(e);
		},
		complete: function(e) {
			console.log(e);
			setTimeout(function() {
				mask.close();
			}, 1000);
		}
	});
	
	return resultObj;
}


/**
 * [KO] 그리드에 data 셋팅
 * @param params Obj 
 * @param _pageNo
 * @param gridTarget
 */
function setList(params, gridTarget) {
	//console.log("paramsType:" + params.type);
//	var ajaxParams = $.extend({"sort": "MENU"}, params)
	$.ajax({
		method : "post",
		url : "/ajaxMenu/getGridVal.do",
		data : params,
		success : function(res) {
			console.log(res);

			var data = JSON.parse(res);
			if (data.list.length > 0) {
				gridTarget.setData(data.list);
				//조회그리드 외의 그리드 초기화
//				if(params.type === "DEPTH1") {
//					gridDataInit(locGrid.target);
//					gridDataInit(teamGrid.target);
//				} else if(params.type === "LOC") {
//					gridDataInit(teamGrid.target);
//				} else {
//					
//				}
				
				setTimeout(function() {
					mask.close();
				}, 1000);
			} else {
				//하위그리드 데이터 조회일 때 초기화
//				if(params.type === "CLS") {
//					gridDataInit(gridTarget);
//					gridDataInit(locGrid.target);
//					gridDataInit(teamGrid.target);
//					
//					//조직도 등록 시 상위코드로 사용할 코드 초기화
//					currClsCode = "";
//					currLocCode = "";
//					
//				} else if(params.type === "LOC") {
//					gridDataInit(locGrid.target);
//					gridDataInit(teamGrid.target);
//					
//					//사업부서 등록 시 상위코드로 사용할 사업장 코드 초기화
//					currLocCode = "";
//					
//				} else if(params.type === "TEAM"){
//					gridDataInit(teamGrid.target);
//				}
				
				setTimeout(function() {
					mask.close();
					toastMsg(LN_NO_DATA);
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
 * [KO] Function: 등록폼에 입력한 메뉴의 내용을 등록. <br>
 * [KO] Argument: [1st argument] 등록 type(D_1, D_2, D_3) <br>
 * [KO] Summary : 이함수는 화면에 입력한 메뉴의 내용을 등록한다. <br>
 * [EN] Summary : <br>
 * ====================================================================
 */
function insertMenu(type) {
	var checkInput;
	var url = "/ajaxMenu/gridCreate.do";
	
	if(type === "D_1") {
		checkInput = depth1GridInputHandler.saveData(function(data){
			
			if(!val_chk(data.mcdName, "메뉴명")){
				return false;
			}
			
			if(data.mcdSort.trim() === "") {
				data.mcdSort = 0;
			}
			
			var menuObj = new MenuObj("", data.mcdName, data.mcdUse, "1", "0", data.mcdSort);
			var result = getAjaxDomain(url, menuObj, "POST");
			if (result.result === RESULT_Y) {
				depth1Grid.initView(labels).setData();
				depth2Grid.initView(labels);
				depth3Grid.initView(labels);
			} else {
				toastMsg("오류가 발생했습니다.<br> 잠시 후 시도해 주세요");
			}
			depth1GridInputHandler.clearInput();	
			
		});
	} else if(type === "D_2") {
		//console.log("LOC save");
		checkInput = depth2GridInputHandler.saveData(function(data){
		
			if(!val_chk(data.mcdName, "메뉴명")){
				return false;
			}
			
			if(currDepth1Code === undefined || currDepth1Code.trim() === "") {
				toastMsg(LN_NO_SELECT_PARENTCODE);
				gridBtnInit();
				return;
			}
			
			if(data.mcdSort.trim() === "") {
				data.mcdSort = 0;
			}
			var menuObj = new MenuObj("", data.mcdName, data.mcdUse, "2", currDepth1Code, data.mcdSort);
			var result = getAjaxDomain(url, menuObj, "POST");
			if (result.result === RESULT_Y) {
				depth2Grid.initView(labels).setData(currDepth1Code);
				depth3Grid.initView(labels);
				
			} else {
				toastMsg("오류가 발생했습니다.<br> 잠시 후 시도해 주세요");
			}
//			saveCheck = true;
			depth2GridInputHandler.clearInput();	

		});
	} else if(type === "D_3") {
		checkInput = depth3GridInputHandler.saveData(function(data){
			toastMsg(data.mcdName);
			if(!val_chk(data.mcdName, "명칭")){
				return false;
			}
			
			if(currDepth2Code === undefined || currDepth2Code.trim() === "") {
				toastMsg(LN_NO_SELECT_PARENTCODE);
				gridBtnInit();
				return;
			}
			
			if(data.mcdSort.trim() === "") {
				data.mcdSort = 0;
			}
			var menuObj = new MenuObj("", data.mcdName, data.mcdUse, "3", currDepth2Code, data.mcdSort);
			var result = getAjaxDomain(url, menuObj, "POST");
			if (result.result === RESULT_Y) {
				depth3Grid.initView(labels).setData(currDepth2Code);
			} else {
				toastMsg("오류가 발생했습니다.<br> 잠시 후 시도해 주세요");
			}
//			saveCheck = true;
			depth3GridInputHandler.clearInput();	
	
		});
	} else {
		alert("잠시 후 시도해 주십시요");
	}
	
	return checkInput;
}

/*
 * ==================================================================== 
 * [KO] Function: 화면에 선택된 메뉴 레코드를 삭제. 
 * [KO] Argument: [1st argument] mcdCode String 
 * [KO] Argument: [2st argument] type String
 * [KO] Argument: [3st argument] delIndex number  
 * [KO] Summary : 이함수는 화면에 선택된 메뉴 레코드를 삭제한다. 
 * [EN] Function: . 
 * [EN] Argument: [1st argument] mcdCode String 
 * [EN] Argument: [2st argument] type String
 * [EN] Argument: [3st argument] delIndex number 
 * [EN] Summary : Execute delete process.
 *  ====================================================================
 */
function deleteMenu(mcdCode, type, delIndex) {
	var url = "/ajaxMenu/delete.do";
	mask.open();
	var stateMsg = "";
	var depth;
	if (type === "D_1") {
		depth = 1;
	} else if (type === "D_2") {
		depth = 2;
	} else if (type === "D_3") {
		depth = 3;
	}  
	var param = {
			mcdCode: mcdCode,
			mcdDepth: depth,
	};
	var result = getAjaxDomain(url, param);
	if(result.result === RESULT_OK) {
		toastMsg(LN_MSG_DELETE);
		if (type === "D_1") {
			depth1Grid.target.deleteRow(delIndex);
		} else if (type === "D_2") {
			depth2Grid.target.deleteRow(delIndex);
		} else if (type === "D_3") {
			depth3Grid.target.deleteRow(delIndex);
		}
	} else if(result.errMsg !== undefined){
		toastMsg(result.errMsg);
	} else {
		toastMsg("오류가 발생했습니다.<br>잠시 후 시도해주세요.");
	}
	
	var menuObj = new MenuObj("", "", "", "", "", "");
	editFormDataBind(menuObj);
}

/**
 * ==================================================================== 
 * [KO] Function: 수정폼에 클릭한 메뉴의 내용을 데이터 바인딩.<br> 
 * [KO] Argument: [1st argument] 수정할 내용객체(MenuObj)<br>
 * [KO] Summary : 이함수는 화면에 클릭한 메뉴의 내용을 바인딩한다.<br>
 * [KO] Argument: [1st argument] MenuObj<br>
 * [EN] Summary : <br>
 * ====================================================================
 */
function editFormDataBind(data) {
	console.log(data);
	$('#mcdCode').val(data.mcdCode);
	$('#mcdIcon').val(data.mcdIcon);
	$('#mcdName').val(data.mcdName);
	$('#mcdUrl').val(data.mcdUrl);
	if(data.mcdUse === "Y") {
		$('input#mcdUseY').prop("checked", true);
	} else {
		$('input#mcdUseN').prop("checked", true);
	}
	
	console.log(data.mcdNewWindow);
	if(data.mcdNewWindow === "Y") {
		$('input#mcdNewWindowY').prop("checked", true);
	} else {
		$('input#mcdNewWindowN').prop("checked", true);
	}
	
	console.log(data.mcdAddCert);
	if(data.mcdAddCert === "Y") {
		$('input#mcdAddCertY').prop("checked", true);
	} else {
		$('input#mcdAddCertN').prop("checked", true);
	}
	
	if(data.mcdMobile === "Y") {
		$('input#mcdMobileY').prop("checked", true);
	} else {
		$('input#mcdMobileN').prop("checked", true);
	}
}

/**
 * ==================================================================== 
 * [KO] Function: 그리드에 입력한 메뉴의 내용을 수정.<br> 
 * [KO] Argument: [1st argument] 수정할 내용객체(RelationObj or RelationTeamObj)<br>
 * [KO] Summary : 이함수는 그리드에 입력한 메뉴의 내용을 수정한다.<br>
 * [KO] Argument: [1st argument] RelationObj or RelationTeamObj<br>
 * [EN] Summary : <br>
 * ====================================================================
 */
function updateGridMenu(updateData) {
	console.log("currGridIndex");
	console.log(currGridIndex);
	var url = "/ajaxMenu/update.do";
	var resultObj = getAjaxDomain(url, updateData, "POST");
	console.log(resultObj);
	try {
		if(resultObj.result === RESULT_OK) {
			if(currGridIndex !== undefined) {
				$('#updateForm #mcdName').val(updateData.mcdName);
				if(updateData.mcdUse === "Y") {
					$('input#mcdUseY').prop("checked", true);
				} else {
					$('input#mcdUseN').prop("checked", true);
				}
			}
			toastMsg(LN_PROCESSED_OK);	
		} else {
			toastMsg("오류가 발생했습니다.<br>잠시 후 시도해 주세요.");
		}
	} catch (e) {
		console.log(e)
	}
}

/**
 * ==================================================================== 
 * [KO] Function: 화면에 입력폼에 입력한 메뉴의 내용을 수정.<br> 
 * [KO] Argument: [1st argument] 수정할 내용객체(RelationObj or RelationTeamObj)<br>
 * [KO] Summary : 이함수는 화면에 입력폼에 입력한 메뉴의 내용을 수정한다.<br>
 * [KO] Argument: [1st argument] RelationObj or RelationTeamObj<br>
 * [EN] Summary : <br>
 * ====================================================================
 */
function updateFormMenu() {
	
	console.log("currGridItem");
	console.log(currGridItem);
	if($('#updateForm #mcdCode').val().trim() === ""){
		toastMsg("수정할 메뉴를 선택해 주세요.");
		return false;
	}
	if(!val_chk($('#updateForm #mcdName').val(), "메뉴명")){
		return false;
	}
	currGridItem.mcdIcon = $('#updateForm #mcdIcon').val();
	currGridItem.mcdName = $('#updateForm #mcdName').val();
	currGrid.setValue(currGridIndex, "mcdName", $('#updateForm #mcdName').val())
	currGridItem.mcdUrl = $('#updateForm #mcdUrl').val();
	if($('input[id=mcdUseY]').is(':checked')){
		currGridItem.mcdUse = "Y";
		currGrid.setValue(currGridIndex, "mcdUse", "Y")
	} else {
		currGridItem.mcdUse = "N";
		currGrid.setValue(currGridIndex, "mcdUse", "N")
	}
	if($('input[id=mcdNewWindowY]').is(':checked')){
		currGridItem.mcdNewWindow = "Y";
	} else {
		currGridItem.mcdNewWindow = "N";
	}
	if($('input[id=mcdAddCertY]').is(':checked')){
		currGridItem.mcdAddCert = "Y";
	} else {
		currGridItem.mcdAddCert = "N";
	}
	if($('input[id=mcdMobileY]').is(':checked')){
		currGridItem.mcdMobile = "Y";
	} else {
		currGridItem.mcdMobile = "N";
	}
	
	var url = "/ajaxMenu/update.do";
	var param = $('#updateForm').serialize();
//	console.log(param);
	var result = getAjaxDomain(url, param, "POST");
	try {
		if(result.result === RESULT_OK) {
			toastMsg("수정되었습니다.");
		} else {
			//console.log("err");
			toastMsg(result.errMsg);
		}
	} catch (e) {
		console.log(e);
	}
}

/**
 * ======================================
 * [ko] 메뉴 명칭으로 메뉴 정보 검색하는 함수<br>
 * [KO] Argument: [1st argument] 검색값 Element <br>
 * [KO] Argument: [2st argument] 메뉴 검색 type <br>
 * ======================================
 */
function searchMenu(input, type) {
	
	//1Depth가 아닐 시 상위 코드가 선택되었는지 확인
	if(currDepth1Code == undefined && type === 'D_2'){
		toastMsg("1Depth 메뉴를 선택해주세요.");
		return false;
	}else if(currDepth2Code == undefined && type === 'D_3'){
		toastMsg("2Depth 메뉴를 선택해주세요.");
		return false;
	}

	//(mcdCode, mcdName, mcdUse, mcdDepth, mcdRef, mcdSort)
	var menuObj = new MenuObj("", input.value, "", 1, "", 0);
	
	if(type === 'D_2') {
		menuObj.mcdDepth = "2";
		menuObj.mcdRef = currDepth1Code;
	} else if(type === 'D_3') {
		menuObj.mcdDepth = "3";
		menuObj.mcdRef = currDepth2Code;
	} 
	
	var url = "/ajaxMenu/getGridVal.do"; 
	
	var resultObj = getAjaxDomain(url, menuObj, "POST");
	
	try {
		if(resultObj.result === RESULT_Y) {
			if(resultObj.list.length > 0) {
				if(type === 'D_1') {
					//하위메뉴 등록시 사용하는 상위메뉴코드 초기화
					currDepth1Code = undefined;
					currDepth2Code = undefined;
					depth1Grid.target.setData(resultObj.list);
				} else if(type === 'D_2') {
					//하위메뉴 등록시 사용하는 상위메뉴코드 초기화
					currDepth1Code = undefined;
					currDepth2Code = undefined;
					depth2Grid.target.setData(resultObj.list);
				} else if(type === 'D_3') {
					depth3Grid.target.setData(resultObj.list);
				}
			} else {
				toastMsg(LN_NO_DATA);
			}
		} else {
			toastMsg("오류가 발생했습니다<br>잠시 후 시도해 주세요.");
		}
	} catch (e) {
		console.log(e);
	}
	
}

//===================== 메뉴 depth1 그리드 ====================================/
var depth1Grid = {
	initView : function(labels) {
		this.target = new ax5.ui.grid();
		this.target
				.setConfig({
					target : $('[data-ax5grid="depth1-grid"]'),
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
							if(this.column.key === "mcdCode") {
								if(this.item.rowType !== "insert") {
									depth2Grid.setData(this.item.mcdCode);
									currDepth1Code = this.item.mcdCode;
									currTarget = "D_1";
									currGridIndex = this.dindex;
									currGrid = this.self;
									currGridItem = this.self.list[this.dindex];
									editFormDataBind(this.item);
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
							depth1Grid.target.contextMenu.close();
							
							if (item.label === LN_DELETE) {
							//if (item.label === '삭제하기') {
								deleteMenu(param.item.mcdCode, "D_1", param.dindex);
							} else if (item.label === '수정하기') {
							}
							// 또는 return true;
						}
					},
					page : {
						navigationItemCount : 1,
						height : 30,
						display : false,
						onChange : function() {
							gridView.setData(this.page.selectPage);
						}
					},
					columns : [ {
						key : "mcdCode",
//						label : "메뉴코드",
						label : labels.mcdCode.label,
						width : 60,
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
							return depth1GridInputHandler.getTextInput(this);
						}
					}, {
						key : "mcdName",
						width : 130,
//						label : "메뉴명",
						label : labels.mcdName.label,
						align : "center",
						editor : {
							type : "text"
						},
						formatter:function(){							
							return depth1GridInputHandler.getTextInput(this);
						}
					}, {
						key : "mcdSort",
						width : 60,
//						label : "메뉴순서",
						label : labels.menuSort.label,
						align : "center",
						editor : {
							type : "text"
						},
						formatter:function(){							
							return depth1GridInputHandler.getTextInput(this);
						}
					}, {
						key : "mcdUse",
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
							return depth1GridInputHandler.getTextInput(this);
						}
					} ],
				});
		this.target.onLoad = function() {
			//console.log("");
		},
		this.target.onDataChanged = function() {
//			console.log("onDataChanged");
//			console.log(this.item.rowType);
			//입력폼이 아닐 때 
			if (this.item.rowType !== 'insert') {
				
				//(mcdCode, mcdName, mcdUse, mcdDepth, mcdRef,mcdSort)
				var updateData = new MenuObj(this.item.mcdCode, this.item.mcdName, this.item.mcdUse, "0", "", this.item.mcdSort);
				updateGridMenu(updateData);	
			}
		}
		return this;
	},
	setData : function() {
		mask.open();
		var gridTarget = this.target;
		var params = {
				"mcdDepth": "1",
		};
		
		setList(params, gridTarget);
//		relationBtnInit();
		return this;
	}
};
//===================== // 메뉴 depth1 그리드 ====================================/

//===================== 메뉴 depth2 그리드 ====================================/
var depth2Grid = {
		initView : function(labels) {
			this.target = new ax5.ui.grid();
			this.target
					.setConfig({
						target : $('[data-ax5grid="depth2-grid"]'),
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
								if(this.column.key === "mcdCode") {
									if(this.item.rowType !== "insert") {
										depth3Grid.setData(this.item.mcdCode);
										currDepth2Code = this.item.mcdCode;
										currTarget = "D_2";
										currGridIndex = this.dindex;
										currGrid = this.self;
										currGridItem = this.self.list[this.dindex];
										editFormDataBind(this.item);
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
								depth2Grid.target.contextMenu.close();
								
								if (item.label === LN_DELETE) {
								//if (item.label === '삭제하기') {
									deleteMenu(param.item.mcdCode, "D_2", param.dindex);
								} else if (item.label === '수정하기') {
								}
								// 또는 return true;
							}
						},
						page : {
							navigationItemCount : 1,
							height : 30,
							display : false,
							onChange : function() {
								gridView.setData(this.page.selectPage);
							}
						},
						columns : [ {
							key : "mcdCode",
//							label : "메뉴코드",
							label : labels.mcdCode.label,
							width : 60,
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
								return depth2GridInputHandler.getTextInput(this);
							}
						}, {
							key : "mcdName",
							width : 130,
//							label : "메뉴명",
							label : labels.mcdName.label,
							align : "center",
							editor : {
								type : "text"
							},
							formatter:function(){							
								return depth2GridInputHandler.getTextInput(this);
							}
						}, {
							key : "mcdSort",
							width : 60,
//							label : "메뉴순서",
							label : labels.menuSort.label,
							align : "center",
							editor : {
								type : "text"
							},
							formatter:function(){							
								return depth2GridInputHandler.getTextInput(this);
							}
						}, {
							key : "mcdUse",
//							label : "사용여부",
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
								return depth2GridInputHandler.getTextInput(this);
							}
						}, 
						],
					});
			this.target.onLoad = function() {
				//console.log("");
			},
			this.target.onDataChanged = function() {
//				console.log("onDataChanged");
//				console.log(this.item.rowType);
				//입력폼이 아닐 때 
				if (this.item.rowType !== 'insert') {
					//(mcdCode, mcdName, mcdUse, mcdDepth, mcdRef,mcdSort)
					var updateData = new MenuObj(this.item.mcdCode, this.item.mcdName, this.item.mcdUse, "0", "", this.item.mcdSort);
					updateGridMenu(updateData);	
				}
			}
			return this;
		},
		setData : function(mcdCode) {
			mask.open();
			var gridTarget = this.target;
			var params = {
					"mcdDepth": "2",
					"mcdRef": mcdCode
			};
			
			setList(params, gridTarget);
//			relationBtnInit();
			return this;
		}
	};
//===================== // 메뉴 depth2 그리드 ====================================/

//===================== 메뉴 depth3 그리드 ====================================/
var depth3Grid = {
		initView : function(labels) {
			this.target = new ax5.ui.grid();
			this.target
					.setConfig({
						target : $('[data-ax5grid="depth3-grid"]'),
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
								if(this.column.key === "mcdCode") {
									if(this.item.rowType !== "insert") {
										this.self.clearSelect();
										this.self.select(this.dindex);
										currTarget = "D_3";
										currGridIndex = this.dindex;
										currGrid = this.self;
										currGridItem = this.self.list[this.dindex];
										editFormDataBind(this.item);
									}
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
								depth3Grid.target.contextMenu.close();
								
								if (item.label === LN_DELETE) {
								//if (item.label === '삭제하기') {
									deleteMenu(param.item.mcdCode, "D_3", param.dindex);
								} else if (item.label === '수정하기') {
								}
								// 또는 return true;
							}
						},
						page : {
							navigationItemCount : 1,
							height : 30,
							display : false,
							onChange : function() {
								gridView.setData(this.page.selectPage);
							}
						},
						columns : [ {
							key : "mcdCode",
//							label : "메뉴코드",
							label : labels.mcdCode.label,
							width : 60,
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
								return depth3GridInputHandler.getTextInput(this);
							}
						}, {
							key : "mcdName",
							width : 130,
//							label : "메뉴명",
							label : labels.mcdName.label,
							align : "center",
							editor : {
								type : "text"
							},
							formatter:function(){							
								return depth3GridInputHandler.getTextInput(this);
							}
						}, {
							key : "mcdSort",
							width : 60,
//							label : "메뉴순서",
							label : labels.menuSort.label,
							align : "center",
							editor : {
								type : "text"
							},
							formatter:function(){							
								return depth3GridInputHandler.getTextInput(this);
							}
						}, {
							key : "mcdUse",
//							label : "사용여부",
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
								return depth3GridInputHandler.getTextInput(this);
							}
						}, ],
					});
			this.target.onLoad = function() {
				//console.log("");
			},
			this.target.onDataChanged = function() {
//				console.log("onDataChanged");
//				console.log(this.item.rowType);
				//입력폼이 아닐 때 
				if (this.item.rowType !== 'insert') {
					
					//(mcdCode, mcdName, mcdUse, mcdDepth, mcdRef,mcdSort)
					var updateData = new MenuObj(this.item.mcdCode, this.item.mcdName, this.item.mcdUse, "0", "", this.item.mcdSort);
					updateGridMenu(updateData);	
				}
			}
			return this;
		},
		setData : function(mcdCode) {
			mask.open();
			var gridTarget = this.target;
			var params = {
					"mcdDepth": "3",
					"mcdRef": mcdCode,
			};
			
			setList(params, gridTarget);
//			relationBtnInit();
			return this;
		}
	};
//===================== // 메뉴 depth3 그리드 ====================================/

$(document.body).ready(function() {
	depth1GridInputHandler = new GridInput(depth1Grid);
	depth2GridInputHandler = new GridInput(depth2Grid);
	depth3GridInputHandler = new GridInput(depth3Grid);
	
	//등록버튼
	$("._addBtn_").on("click",function(){
		var target = this.getAttribute("data-click-target")
		saveBtnUiSet(this);
		if(target === "D_1") {
			depth1GridInputHandler.addInput();
		} else if(target === "D_2") {
			if(currDepth1Code === undefined || currDepth1Code.trim() === "") {
				toastMsg(LN_NO_SELECT_PARENTCODE);
				gridBtnInit();
				return;
			}
			depth2GridInputHandler.addInput();
		} else if(target === "D_3") {
			if(currDepth2Code === undefined || currDepth2Code.trim() === "") {
				toastMsg(LN_NO_SELECT_PARENTCODE);
				gridBtnInit();
				return;
			}
			depth3GridInputHandler.addInput();
		} else {
			alert("잠시 후 시도해 주십시요");
		}
		
	});
	
	//등록폼 닫기버튼
	$("._closeBtn_").on("click",function(){
		var target = this.getAttribute("data-click-target");
		//console.log(target);
		addBtnUiSet(this);
		
		if (target === 'D_1') {
			depth1GridInputHandler.clearInput();
		} else if (target === 'D_2') {
			depth2GridInputHandler.clearInput();
		} else if (target === 'D_3') {
			depth3GridInputHandler.clearInput();
		}
		
	});
	
	//저장버튼
	$("._saveBtn_").on("click", function(){
		var check = confirm(LN_CONFIRM_SAVE);
		var type = this.getAttribute("data-click-target")
		var checkInput;
		if(check){
			checkInput = insertMenu(type);
		}
		
		
		if(!checkInput){
			toastMsg(LN_PRESS_REGISTERBTN);
		}
		
		/*if(saveCheck){
			this.style.display = "none";
			this.previousSibling.previousSibling.style.display = "inline-block";
		}*/
	});
	
	//삭제버튼
	$("._deleteBtn_").on("click", function(){
		deleteMenu($('#updateForm #mcdCode').val(), currTarget, currGridIndex)
	});
	
	$('._iconSearchBtn_').on('click', function(e) {
		window.open("http://axicon.axisj.com/","new","width=800,height=500,scrollbars=yes,top=100,left=100");
	});
});

