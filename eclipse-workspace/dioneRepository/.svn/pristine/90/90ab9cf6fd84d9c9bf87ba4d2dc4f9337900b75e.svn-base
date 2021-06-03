/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
"use strict";

/**
 * [ko]즐겨찾기 객체
 */
function bkmkObj (mcdCode, mcdRefName, mcdName, useYn) {
	this.mcdCode = mcdCode;
	this.mcdRefName = mcdRefName;
	this.mcdName = mcdName;
	this.useYn = useYn;
}

/**
 * ==================================================================== 
 * [KO] Function: 선택한 메뉴 즐겨찾기 추가.<br> 
 * [KO] Argument: [1st argument] 수정할 내용객체(BkmkObj)<br>
 * [KO] Summary : 이함수는 화면에 체크한 즐겨찾기를 추가 한다.<br>
 * [KO] Argument: [1st argument] BkmkObj<br>
 * [EN] Summary : <br>
 * ====================================================================
 */
function updateDataBkmk(updateData) {
	//console.log(updateData.mcdCode + ' : ' + updateData.useYn);
	
	//즐겨찾기가 선택되었는지 확인
	if(chkBkmkMenuCode(updateData.mcdCode)){	//이미 선택된 즐겨 찾기가 있으므로 N이면 삭제 Y이면 경고창
		console.log('있음');
		if(updateData.useYn == 'N'){
			deleteBkmk(updateData);
		}else{
			toastMsg('이미 선택된 즐겨찾기가 있습니다.');
		}
		
	}else{	//선택된 즐겨찾기가 없으므로 Y이면 추가 N이면 경고창
		console.log('없음');
		if(updateData.useYn == 'Y'){
			createBkmk(updateData);
		}else{
			toastMsg('선택된 즐겨찾기가 없습니다.');
		}
	}
	
}

//즐겨찾기가 선택되었는지 확인
function chkBkmkMenuCode(mcdCode){
	
	var flag = false;
	
	$('.ui-state-default').each(function(){
		$(this).children('input[name=menuCode]').each(function(){
			var menuCd = $(this).val();
			console.log('menuCode : ' + menuCd + '  , mcdCode : ' + mcdCode);
			if(mcdCode == menuCd){
				flag = true;
			}
		});
	});
	
	/*$('.ui-state-default').each(function(){
		$(this).children('input[name=menuCd]').each(function(){
			var menuCd = $(this).val();
			console.log('menuCd : ' + menuCd + '  , mcdCode : ' + mcdCode);
			if(mcdCode == menuCd){
				flag = true;
			}
		});
	});*/
	
	console.log('return falg : ' + flag);
	return flag;
}

//즐겨찾기 저장
function createBkmk(updateData){
	var stateMsg,
	ajaxParams = updateData;

	$.ajax({
		url : "/ajaxBkmk/create.do",
		type : "post",
		data : ajaxParams,
		success : function(res) {
			console.log("createBkmk.success");
			var data = JSON.parse(res);
			if(data.result === RESULT_OK) {
				stateMsg = RESULT_OK;
				addBkmk(updateData.mcdCode, updateData.mcdName);
			} else {
				console.log("err");
				stateMsg = data.errMsg;
			}
			
		},
		error : function() {
			console.log("createBkmk.error");
			stateMsg = "error";
		},
		complete : function() {
			console.log("createBkmk.complete");
			console.log("stateMsg:" + stateMsg);
			toastMsg(stateMsg);
			
		}
	});
}

//즐겨찾기 수정
function updateBkmk(updateData){
	var stateMsg,
	ajaxParams = updateData;

	$.ajax({
		url : "/ajaxBkmk/update.do",
		type : "post",
		data : ajaxParams,
		success : function(res) {
			console.log("updateBkmk.success");
			var data = JSON.parse(res);
			if(data.result === RESULT_OK) {
				stateMsg = RESULT_OK;
				if(updateData.useYn == 'N'){
					removeBkmk(mcdCode);
				}else{
					addBkmk(updateData.mcdCode, updateData.mcdName);
				}
			} else {
				console.log("err");
				stateMsg = data.errMsg;
			}
			
		},
		error : function() {
			console.log("updateBkmk.error");
			stateMsg = "error";
		},
		complete : function() {
			console.log("updateBkmk.complete");
			console.log("stateMsg:" + stateMsg);
			toastMsg(stateMsg);
			
		}
	});
}

//즐겨찾기 삭제
function deleteBkmk(updateData){
	var stateMsg,
	ajaxParams = updateData;

	$.ajax({
		url : "/ajaxBkmk/delete.do",
		type : "post",
		data : ajaxParams,
		success : function(res) {
			console.log("deleteBkmk.success");
			var data = JSON.parse(res);
			if(data.result === RESULT_OK) {
				stateMsg = RESULT_OK;
				removeBkmk(updateData.mcdCode);
			} else {
				console.log("err");
				stateMsg = data.errMsg;
			}
			
		},
		error : function() {
			console.log("deleteBkmk.error");
			stateMsg = "error";
		},
		complete : function() {
			console.log("deleteBkmk.complete");
			console.log("stateMsg:" + stateMsg);
			toastMsg(stateMsg);
			
		}
	});
}

//즐겨찾기 데이터 삭제
function delBkmk(mcdCode){
	var updateData = new bkmkObj(mcdCode, '', '', '');
	deleteBkmk(updateData);
	removeBkmk(mcdCode);
}

//오른쪽 즐겨찾기에서 추가
function addBkmk(mcdCode, mcdName){
	var obj = '';
	obj += '<li class="ui-state-default"><i class="ico-drag-arrow"></i>' + mcdName;
	obj += '<input type="checkbox" name="menuCode" value="' + mcdCode + '" checked style="display:none;">';
	/*obj += '<span class="delete">';
	obj += '		<button type="button" class="AXButton Normal _deleteBtn_" onclick="javascript:delBkmk(\'' + mcdCode + '\', this);return false;" data-loction="" data-click-target="">';
	obj += '			<spring:message code="label.delete" />';
	obj += '		</button>';*/
	obj += '</span>';
	obj += '</li>';
	
	$('#sortable').append(obj);
}

//오른쪽 즐겨찾기에서 제거
function removeBkmk(mcdCode){
	
	$('.ui-state-default').each(function(){
		$(this).children('input[name=menuCode]').each(function(){
			var menuCode = $(this).val();
			if(mcdCode == menuCode){
				$(this).parent().remove();
			}
		});
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
 * [KO] 그리드에 data 셋팅
 * @param params Obj 
 * @param _pageNo
 * @param gridTarget
 */
function setList(_pageNo, gridTarget) {
	//console.log("paramsType:" + params.type);
	$.ajax({
		method : "post",
		url : "/ajaxBkmk/init.do",
		//data : params,
		success : function(res) {
			//console.log(res);
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
				//그리드 초기화
				//gridDataInit(menuGrid.target);						
				
				setTimeout(function() {
					mask.close();
				}, 1000);
			} else {
				
				//gridDataInit(menuGrid.target);
				
				setTimeout(function() {
					mask.close();
					toastMsg("데이터가 없습니다.");
				}, 1000);
			}
		},
		error : function(res) {
			console.log("error");
			//console.log(res);
		},
		complete : function(res) {
			gridBtnInit();
			setTimeout(function() {
				mask.close();
			}, 1000);
			console.log("completed");
			//console.log(res);
		}
	});
	console.log('ajaxend');
	// return true;
}

//===================== 사업부 그리드 ====================================/
var menuGrid = {
	initView : function(labels) {
		this.target = new ax5.ui.grid();
		this.target
				.setConfig({
					target : $('[data-ax5grid="menu-grid"]'),
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
							/*if(this.column.key === "relationCode") {
								if(this.item.rowType !== "insert") {
										locGrid.setData("LOC", this.item.relationCode);
										currClsCode = this.item.relationCode;		
								}
							}*/
							
						},
					},
					contextMenu : {
						iconWidth : 30,
						acceleratorWidth : 100,
						itemClickAndClose : false,
						icons : {
							'arrow' : '<i class="fa fa-caret-right"></i>'
						},
						items : [{label : "삭제하기"}],
						popupFilter : function(item, param) {
							if (param.element) {
								return true;
							} else {
								return item.type == 1;
							}
						},
						onClick : function(item, param) {
							/*clsGrid.target.contextMenu.close();
							if (item.label === '삭제하기') {
								deleteRelation(param.item.relationCode, 'CLS', param.dindex);
							} else if (item.label === '수정하기') {
							}*/
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
							menuGrid.setData(this.page.selectPage);
						}
					},
					columns : [ {
						key : "mcdCode",
						//label : "메뉴코드",
						label : labels.mcdCode.label,
						width : 80,
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
							return menuGridInputHandler.getTextInput(this);
						}
					}, {
						key : "mcdRefName",
						width : 105,
						//label : "상위메뉴명",
						label : labels.mcdRefName.label,
						align : "center",
						editor : {
							type : "text"
						},
						formatter:function(){							
							return menuGridInputHandler.getTextInput(this);
						}
					}, {
						key : "mcdName",
						width : 150,
						//label : "메뉴명",
						label : labels.mcdName.label,
						align : "center",
						editor : {
							type : "text"
						},
						formatter:function(){							
							return menuGridInputHandler.getTextInput(this);
						}
					}, {
						key : "useYn",
						//label : "사용여부",
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
							return menuGridInputHandler.getTextInput(this);
						}
					} ],
				});
		this.target.onLoad = function() {
			console.log("onload");
		},
		this.target.onDataChanged = function() {
			console.log("onDataChanged");
			//console.log(this.item.rowType);
			//입력폼이 아닐 때 
			if (this.item.rowType !== 'insert') {
				var updateData = new bkmkObj(this.item.mcdCode, this.item.mcdRefName, this.item.mcdName, this.item.useYn);
				updateDataBkmk(updateData);
			}
		}
		return this;
	},
	setData : function(type, _pageNo) {
		mask.open();
		var gridTarget = this.target;
		
		setList(_pageNo, gridTarget);
//		relationBtnInit();
		return this;
	}
};

// ===================== // 메뉴 그리드 ====================================/


$( function() {
	/*
	menuGrid.initView({
		relationCode:{label:"<spring:message code='label.WAB002.locCode'/>&nbsp;<spring:message code='label.code'/>"},
		relationName:{label:"<spring:message code='label.WAB002.locCode'/>&nbsp;<spring:message code='label.name'/>"},
		useYn:{label:"<spring:message code='label.useYn'/>"},
	}).setData('menu');
	*/
	
	
    $( "#sortable" ).sortable({
    	 update: function( event, ui ) {
    		 $(this).children().each(function(index) {
    			 console.log(index);
    		 });
    		
    	}, 
      placeholder: "ui-state-highlight"
    });
    //$( "#sortable" ).disableSelection();
    
  //등록폼 닫기버튼
	$("._addBtn_").on("click",function(){
		
		var menuCode = "";
		var i=0;
		$('.ui-state-default').each(function(){
			$(this).children('input[name=menuCode]').each(function(){
				var mcdCode = $(this).val();
				
				if(i==0){
					menuCode += mcdCode;
				}else{
					menuCode += ","+mcdCode;
				}
				i++;
				
				
			});
		});
		
		if(i>0){
			var updateData = new bkmkObj(menuCode, '', '', '');
			
			var stateMsg,
			ajaxParams = updateData;

			$.ajax({
				url : "/ajaxBkmk/sortUpdate.do",
				type : "post",
				data : ajaxParams,
				success : function(res) {
					console.log("updateBkmk.success");
					var data = JSON.parse(res);
					if(data.result === RESULT_OK) {
						stateMsg = RESULT_OK;
					} else {
						console.log("err");
						stateMsg = data.errMsg;
					}
					
				},
				error : function() {
					console.log("updateBkmk.error");
					stateMsg = "error";
				},
				complete : function() {
					console.log("updateBkmk.complete");
					console.log("stateMsg:" + stateMsg);
					toastMsg(stateMsg);
					
				}
			});
		}
		
	});

    
});

var menuGridInputHandler = null

$(document.body).ready(function() {
	menuGridInputHandler = new GridInput(menuGrid);

});
	