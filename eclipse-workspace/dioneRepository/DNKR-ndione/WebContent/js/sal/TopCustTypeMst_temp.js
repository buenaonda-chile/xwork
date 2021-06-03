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
    gridInputHandler = null;

/**
 * [ko]객체
 */
function CarObj () {
	this.comps1 = $("#setComps1").val();
	this.pyvnd1 = $("#setPyvnd1").val();
	this.carcd1 = $("#setCarcd1").val();
	this.bdycd1 = $("#setBdycd1").val();
	this.comps2 = $("#setComps2").val();
	this.pyvnd2 = $("#setPyvnd2").val();
	this.carcd2 = $("#setCarcd2").val();
	this.bdycd2 = $("#setBdycd2").val();
	
	this.oldComps2 = $("#setOldComps2").val();
	this.oldPyvnd2 = $("#setOldPyvnd2").val();
	this.oldCarcd2 = $("#setOldCarcd2").val();
	this.oldBdycd2 = $("#setOldBdycd2").val();
}

/**
 * [ko] 선택자료 set
 */
function setCarObj (comps2, pyvnd2, carcd2, bdycd2, oldComps2, oldPyvnd2, oldCarcd2, oldBdycd2) {
	$("#setComps2").val(comps2);
	$("#setPyvnd2").val(pyvnd2);
	$("#setCarcd2").val(carcd2);
	$("#setBdycd2").val(bdycd2);
	if(oldComps2 != null) $("#setOldComps2").val(oldComps2);
	if(oldPyvnd2 != null) $("#setOldPyvnd2").val(oldPyvnd2);
	if(oldPyvnd2 != null) $("#setOldCarcd2").val(oldCarcd2);
	if(oldBdycd2 != null) $("#setOldBdycd2").val(oldBdycd2);
}

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
		url : "/ajaxTopCustTypeMst/init.do",
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
			gridBtnInit();
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
	gridBtnInit();
	
	if(!$(".getComps").val()){
		toastMsg(LN_SELECT_COMPS);
		return false;
	}else if(!$(".getPyvnd").val()){
		toastMsg(LN_SELECT_PYVND);
		return false;
	}else if(!$(".getCarcd").val()){
		toastMsg(LN_SELECT_CARCD);
		return false;
	}else if(!$(".getBdycd").val()){
		toastMsg(LN_SELECT_BDYCD);
		return false;
	}
	
	// 초기화
	$("#setComps1").val("");
	$("#setPyvnd1").val("");
	$("#setCarcd1").val("");
	$("#setBdycd1").val("");
	$("#setComps2").val("");
	$("#setPyvnd2").val("");
	$("#setCarcd2").val("");
	$("#setBdycd2").val("");
	$("#setOldComps2").val("");
	$("#setOldPyvnd2").val("");
	$("#setOldCarcd2").val("");
	$("#setOldBdycd2").val("");
	
	mask.open();
	$.ajax({
		method : "post",
		url : "/ajaxTopCustTypeMst/search.do",
		data : {
			"getComps" : $(".getComps").val(),
			"getPyvnd" : $(".getPyvnd").val(),
			"getCarcd" : $(".getCarcd").val(),
			"getBdycd" : $(".getBdycd").val()
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
				
				// 첫번째 자료
				$("#setComps1").val(data.list[0].comps1);
				$("#setPyvnd1").val(data.list[0].pyvnd1);
				$("#setCarcd1").val(data.list[0].carcd1);
				$("#setBdycd1").val(data.list[0].bdycd1);
				$("#setComps2").val(data.list[0].comps2);
				$("#setPyvnd2").val(data.list[0].pyvnd2);
				$("#setCarcd2").val(data.list[0].carcd2);
				$("#setBdycd2").val(data.list[0].bdycd2);
				$("#setOldComps2").val(data.list[0].oldComps2);
				$("#setOldPyvnd2").val(data.list[0].oldPyvnd2);
				$("#setOldCarcd2").val(data.list[0].oldCarcd2);
				$("#setOldBdycd2").val(data.list[0].oldBdycd2);
				
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

/**
 * ==================================================================== 
 * [KO] Function: 입력한 내용을 등록. <br>
 * [KO] Argument: [1st argument] 등록data <br>
 * [KO] Summary : 이함수는 화면에 입력한 조직도의 내용을 등록한다. <br>
 * [EN] Summary : <br>
 * ====================================================================
 */
function insertCar() {
	var ajaxParams = new CarObj();
	
	mask.open();
	$.ajax({
		method : "post",
		url : "/ajaxTopCustTypeMst/create.do",
		data : ajaxParams,
		success : function(res) {
			var data = JSON.parse(res);

			if (data.result === RESULT_OK) {
				toastMsg(RESULT_OK);

				search();
				gridBtnInit();
				setTimeout(function() {
					mask.close();
				}, 500);
				
				gridInputHandler.clearInput();
			} else {

				setTimeout(function() {
					mask.close();
					//toastMsg(data.errMsg);
					if(data.errMsg == "LN_CHK3") toastMsg(LN_CHK3);
					if(data.errMsg == "LN_CHK4") toastMsg(LN_CHK4);
					if(data.errMsg == "LN_CHK5") toastMsg(LN_CHK5);
					
					if(data.errMsg == "LN_INS_CHK1") toastMsg(LN_INS_CHK1);
				}, 500);
				
			}
		},
		error : function() {
			toastMsg("error");
		},
		complete : function() {
			//gridBtnInit();
			setTimeout(function() {
				mask.close();
			}, 500);
		}
	});
}

/**
 * ==================================================================== 
 * [KO] Function: 화면에 입력한 내용을 수정.<br> 
 * [KO] Argument: [1st argument] 수정할 내용객체<br>
 * [KO] Summary : 이함수는 화면에 입력한 조직도의 내용을 수정한다.<br>
 * [KO] Argument: [1st argument] Obj <br>
 * [EN] Summary : <br>
 * ====================================================================
 */
function updateCar() {
	
	if(dataLength <= 0){
		toastMsg(LN_NO_DATA);
		return false;
	}
	
	if($("#setOldComps2").val() == "" && $("#setOldPyvnd2").val() == "" && $("#setOldCarcd2").val() == "" && $("#setOldBdycd2").val() == ""){
		toastMsg("추가상태의 자료는 수정할 수 없습니다.");
		return false;
	}
	
	var stateMsg,
	    ajaxParams = new CarObj();
	
	$.ajax({
		url : "/ajaxTopCustTypeMst/update.do",
		type : "post",
		data : ajaxParams,
		success : function(res) {
			var data = JSON.parse(res);
			
			if(data.result === RESULT_OK) {
				stateMsg = RESULT_OK;
			} else {
				//stateMsg = data.errMsg;
				
				if(data.errMsg == "LN_CHK3") stateMsg = LN_CHK3;
				if(data.errMsg == "LN_CHK4") stateMsg = LN_CHK4;
				if(data.errMsg == "LN_CHK5") stateMsg = LN_CHK5;
				
				if(data.errMsg == "LN_UPD_CHK1") stateMsg = LN_UPD_CHK1;
				if(data.errMsg == "LN_UPD_CHK2") stateMsg = LN_UPD_CHK2;				
			}
			
		},
		error : function() {
			stateMsg = "error";
		},
		complete : function() {
			toastMsg(stateMsg);
		}
	});	
}

/*
 * ==================================================================== 
 * [KO] Function: 화면에 선택된 레코드를 삭제. 
 * [KO] Argument: [1st argument] 
 * [KO] Summary : 이함수는 화면에 선택된 레코드를 삭제한다. 
 * [EN] Function: . 
 * [EN] Argument: [1st argument] 
 * [EN] Summary : Execute delete process.
 *  ====================================================================
 */
function deleteCar() {
	
	if(dataLength <= 0){
		toastMsg(LN_NO_DATA);
		return false;
	}
	
	if($("#setOldComps2").val() == "" && $("#setOldPyvnd2").val() == "" && $("#setOldCarcd2").val() == "" && $("#setOldBdycd2").val() == ""){
		toastMsg("추가상태의 자료는 삭제할 수 없습니다.");
		return false;
	}
	
	var check = confirm(LN_CONFIRM_DELETE);
	if(check){
		mask.open();
		var stateMsg,
		    delIndex = currGridIndex,
		    ajaxParams = new CarObj();
		
		$.ajax({
			url : "/ajaxTopCustTypeMst/delete.do",
			type : "get",
			data : ajaxParams,
			success : function(res) {
				//console.log("delete.success");
				var data = JSON.parse(res);
				if(data.result === "OK") {
					stateMsg = "OK";
					grid.target.deleteRow(delIndex);	
				} else {
					//console.log("err");
					stateMsg = data.errMsg?data.errMsg:"";
				}
				
			},
			error : function() {
				//console.log("delete.error");
	
				stateMsg = "error";
			},
			complete : function() {
				//console.log("delete.complete");
				
				search();
				setTimeout(function() {
					mask.close();
					if(stateMsg == "LN_DEL_CHK1") toastMsg(LN_DEL_CHK1);
					else toastMsg(stateMsg);
				}, 1000);
			}
		});
	}
}

ax5.ui.grid.tmpl.page_status = function() {
	return '<span>{{{progress}}} {{fromRowIndex}} - {{toRowIndex}} of {{dataRowCount}} {{#dataRealRowCount}}  '
			+ '현재페이지 {{.}}{{/dataRealRowCount}} {{#totalElements}}  전체갯수 {{.}}{{/totalElements}}</span>';
};

// ===================== 그리드 ====================================/
var grid = {
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
							if(this.item.rowType !== "insert") {
								currGridIndex = this.dindex;
								
								setCarObj(this.item.comps2, this.item.pyvnd2, this.item.carcd2, this.item.bdycd2, 
										  this.item.oldComps2, this.item.oldPyvnd2, this.item.oldCarcd2, this.item.oldBdycd2);
							}
							
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
						//items : [{label : LN_DELETE/*삭제*/}],
						popupFilter : function(item, param) {
							if (param.element) {
								return true;
							} else {
								return item.type == 1;
							}
						},
						onClick : function(item, param) {
							grid.target.contextMenu.close();
							/*
							if (item.label === LN_DELETE) {
							//if (item.label === '삭제하기') {
								deleteMsec();
							} else if (item.label === '수정하기') {
							}
							// 또는 return true;
							*/
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
						width : 0,
						editor : {
							type : "text"
						},					
					}, {
						key : "comps2",
//						label : "사업부",
						label : labels.comps2.label,
						width : 200,
						//enableFilter : true,
						align : "center",
						editor : {
							type : "text",
							attributes : {
								'maxlength' : 2,
								'data-maxlength' : 2
							}
						},
						formatter:function(){							
							return gridInputHandler.getTextInput(this);
						}
					}, {
						key : "pyvnd2",
						width : 250,
//						label : "업체",
						label : labels.pyvnd2.label,
						align : "center",
						editor : {
							type : "text",	//"number",
							attributes : {
								'maxlength' : 8,
								'data-maxlength' : 8
							}
						},
						formatter:function(){							
							return gridInputHandler.getTextInput(this);
						}
					}, {
						key : "carcd2",
						width : 250,
//						label : "차종",
						label : labels.carcd2.label,
						align : "center",
						editor : {
							type : "text",
							attributes : {
								'maxlength' : 3,
								'data-maxlength' : 3
							}
						},
						formatter:function(){							
							return gridInputHandler.getTextInput(this);
						}
					}, {
						key : "bdycd2",
						width : 250,
//						label : "규격",
						label : labels.bdycd2.label,
						align : "center",
						editor : {
							type : "text",
							attributes : {
								'maxlength' : 3,
								'data-maxlength' : 3
							}
						},
						formatter:function(){							
							return gridInputHandler.getTextInput(this);
						}
					} ],
				});
		this.target.onLoad = function() {
			//console.log("");
		},
		this.target.onDataChanged = function() {
			//console.log("onDataChanged");
			if (this.key == "comps2") {
				grid.target.setValue(currGridIndex, "comps2", this.item.comps2.toUpperCase());
			}
			if (this.key == "pyvnd2") {
				getCustSch('grid', this.item.pyvnd2);
			}
			if (this.key == "carcd2") {
				grid.target.setValue(currGridIndex, "carcd2", this.item.carcd2.toUpperCase());
				getCarSch('grid', this.item.carcd2);			
			}
			if (this.key == "bdycd2") {
				grid.target.setValue(currGridIndex, "bdycd2", this.item.bdycd2.toUpperCase());
				getBdySch('grid', this.item.bdycd2);
			}
				
			//입력폼이 아닐 때 
			if (this.item.rowType !== 'insert') {
				setCarObj(this.item.comps2, this.item.pyvnd2, this.item.carcd2, this.item.bdycd2, 
						  this.item.oldComps2, this.item.oldPyvnd2, this.item.oldCarcd2, this.item.oldBdycd2);				
			}
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

	$('#getCarcd').bind("keyup", function(){       
	    $(this).val($(this).val().toUpperCase());  
	});
	$('#getBdycd').bind("keyup", function(){       
	    $(this).val($(this).val().toUpperCase());  
	});
	
	$('.getPyvnd').on('change', function() {
		$(".getCusnm").val("");
	});
	
	$('.getCarcd').on('change', function() {
		$(".getCarnm").val("");
	});
	
	$('.getBdycd').on('change', function() {
		$(".getBdynm").val("");
	});	
	
	gridInputHandler = new GridInput(grid);
	
	//등록버튼
	$("._addBtn_").on("click",function(){
		/*
		if(dataLength <= 0){
			toastMsg(LN_NO_DATA);
			return false;
		}
		*/
		
		if(!$(".getCusnm").val() || !$(".getCarnm").val() || !$(".getBdynm").val()){
			toastMsg("조회조건의 업체/차종/규격을 확인하세요.");
			return false;
		}
		
		var target = this.getAttribute("data-click-target")
		saveBtnUiSet(this);

		setCarObj($(".getComps").val(), $(".getPyvnd").val(), $(".getCarcd").val(), $(".getBdycd").val(), "", "", "", "");
		
		gridInputHandler.addInput();
	});
	
	//저장버튼
	$("._saveBtn_").on("click", function(){
		var check = confirm(LN_CONFIRM_SAVE);
		var checkInput = true;
		if(check){
			checkInput = gridInputHandler.saveData(function(data){
					
				if(!val_chk(data.comps2, LN_CHK_COMPS2) || !val_chk(data.pyvnd2, LN_CHK_PYVND2) || 
				   !val_chk(data.carcd2, LN_CHK_CARCD2) || !val_chk(data.bdycd2, LN_CHK_BDYCD2)){
					return false;
				}

				if(data.comps2 != ""){
					if($("#getCompany").val() == "E1"){
						if(data.comps2 != "E1"){
							toastMsg(LN_CHK1);
							return false;
						}
					}else{
						if(data.comps2 != "C1" && data.comps2 != "H1" && data.comps2 != "S1"){
							toastMsg(LN_CHK2);
							return false;
						}
					}				
				}
				
				setCarObj(data.comps2, data.pyvnd2, data.carcd2, data.bdycd2, 
						  null, null, null, null);
				
				insertCar();
			});
		}
		
		if(!checkInput){
			toastMsg(LN_PRESS_REGISTERBTN);
		}
	});	
	
	//등록폼 닫기버튼
	$("._closeBtn_").on("click",function(){
		var target = this.getAttribute("data-click-target");

		addBtnUiSet(this);
		
		gridInputHandler.clearInput();
	});

	$('._custBtn_').on('click', function() {
		window.open("/ajaxCustomer/init.do","customerPop","width=550,height=600,scrollbars=yes,top=100,left=100");
	});
	
	
	$('._excelBtn_').on('click', function() {
		grid.target.exportExcel("대표업체차종마스타.xls");
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
				"getCusno" : value
			},
			success : function(res) {
				var data = JSON.parse(res);			
				
				if (data.list.length > 0) {
					if(gubn == "input") $('#getCusnm').val(data.list[0].cusnm);
				}
				else {
					toastMsg(LN_IO_CHK1);
					if(gubn == "input") $('#getCusnm').val("");
					if(gubn == "grid") grid.target.setValue(currGridIndex, "pyvnd2", "");
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
 * 대표차종코드로 차종명 검색하여 데이터 set
 * 
 * @param 대표차종코드
 */
function getCarSch(gubn, value) {
	if(value != ""){
		$.ajax({
			method : "post",
			url : "/ajaxTopCustTypeMst/schnm.do",
			data : {
				"getComps" : $("#getComps").val(),
				"getTflag" : "CAR",
				"getTval" : value
			},
			success : function(res) {
				var data = JSON.parse(res);			

				if (data.list == undefined) {
					if(gubn == "input") {
						//$('#getCarcd').val("");
						$('#getCarnm').val("");
					}
					if(gubn == "grid") grid.target.setValue(currGridIndex, "carcd2", "");					
					toastMsg(LN_CHK4);					
				}
				else {
					if(gubn == "input") $('#getCarnm').val(data.list.mstsm);
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
 * 대표규격코드로 규격명 검색하여 데이터 set
 * 
 * @param 대표규격코드
 */
function getBdySch(gubn, value) {
	if(value != ""){		
		$.ajax({
			method : "post",
			url : "/ajaxTopCustTypeMst/schnm.do",
			data : {
				"getComps" : $("#getComps").val(),
				"getTflag" : "BDY",
				"getTval" : value
			},
			success : function(res) {
				var data = JSON.parse(res);			
				
				if (data.list == undefined) {
					toastMsg(LN_CHK5);
					
					if(gubn == "input") {
						//$('#getBdycd').val("");
						$('#getBdynm').val("");
					}
					if(gubn == "grid") grid.target.setValue(currGridIndex, "bdycd2", "");
				}
				else {
					if(gubn == "input") $('#getBdynm').val(data.list.mstsm);
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
		var custObj = JSON.parse(returnValue);

		$('#getPyvnd').val(custObj.cusno);
		$('#getCusnm').val(custObj.cusnm);
	}
}