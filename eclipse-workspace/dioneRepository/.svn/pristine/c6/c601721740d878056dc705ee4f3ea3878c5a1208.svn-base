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
	this.comps = $("#setComps").val();
	this.pyvnd = $("#setPyvnd").val();
	this.mkcar = $("#setMkcar").val();
	this.seyno = $("#setSeyno").val();
	this.seycd = $("#setSeycd").val();
	
	this.oldMkcar = $("#setOldMkcar").val();
	this.oldSeyno = $("#setOldSeyno").val();
	this.oldSeycd = $("#setOldSeycd").val();
}

/**
 * [ko] 선택자료 set
 */
function setCarObj (comps, pyvnd, mkcar, seyno, seycd, oldMkcar, oldSeyno, oldSeycd) {
	$("#setComps").val(comps);
	$("#setPyvnd").val(pyvnd);
	$("#setMkcar").val(mkcar);
	$("#setSeyno").val(seyno);
	$("#setSeycd").val(seycd);
	if(oldMkcar != null) $("#setOldMkcar").val(oldMkcar);
	if(oldSeyno != null) $("#setOldSeyno").val(oldSeyno);
	if(oldSeycd != null) $("#setOldSeycd").val(oldSeycd);
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
		url : "/ajaxCustTypeOrderExceptMst/init.do",
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

	if(!$(".getComps").val()){
		toastMsg(LN_SELECT_COMPS);
		return false;
	}else if(!$(".getPyvnd").val()){
		toastMsg(LN_SELECT_PYVND);
		return false;
	}
	
	// 초기화
	$("#setComps").val("");
	$("#setPyvnd").val("");
	$("#setMkcar").val("");
	$("#setSeyno").val("");
	$("#setSeycd").val("");
	$("#setOldMkcar").val("");
	$("#setOldSeyno").val("");
	$("#setOldSeycd").val("");

	mask.open();
	$.ajax({
		method : "post",
		url : "/ajaxCustTypeOrderExceptMst/search.do",
		data : {
			"getComps" : $(".getComps").val(),
			"getPyvnd" : $(".getPyvnd").val()
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
				$("#setComps").val(data.list[0].comps);
				$("#setPyvnd").val(data.list[0].pyvnd);
				$("#setMkcar").val(data.list[0].mkcar);
				$("#setSeyno").val(data.list[0].seyno);
				$("#setSeycd").val(data.list[0].seycd);
				$("#setOldMkcar").val(data.list[0].oldMkcar);
				$("#setOldSeyno").val(data.list[0].oldSeyno);
				$("#setOldSeycd").val(data.list[0].oldSeycd);
				
				setTimeout(function() {
					mask.close();
				}, 500);
				
			} else {
				gridBtnInit();
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
		url : "/ajaxCustTypeOrderExceptMst/create.do",
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
					if(data.errMsg == "LN_INS_CHK1") toastMsg(LN_INS_CHK1);
					if(data.errMsg == "LN_INS_CHK2") toastMsg(LN_INS_CHK2);
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
	
	var stateMsg,
	    ajaxParams = new CarObj();
	
	$.ajax({
		url : "/ajaxCustTypeOrderExceptMst/update.do",
		type : "post",
		data : ajaxParams,
		success : function(res) {
			var data = JSON.parse(res);
			
			if(data.result === RESULT_OK) {
				stateMsg = RESULT_OK;
			} else {
				//stateMsg = data.errMsg;
				
				if(data.errMsg == "LN_UPD_CHK1") stateMsg = LN_UPD_CHK1;
				if(data.errMsg == "LN_UPD_CHK2") stateMsg = LN_UPD_CHK2;				
				if(data.errMsg == "LN_UPD_CHK3") stateMsg = LN_UPD_CHK3;
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
	
	mask.open();
	var stateMsg,
	    delIndex = currGridIndex,
	    ajaxParams = new CarObj();
	
	$.ajax({
		url : "/ajaxCustTypeOrderExceptMst/delete.do",
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
								
								setCarObj(this.item.comps, this.item.pyvnd, this.item.mkcar, this.item.seyno, this.item.seycd,
										  this.item.oldMkcar, this.item.oldSeyno, this.item.oldSeycd);
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
						}						
					}, {
						key : "mkcar",
//						label : "차종",
						label : labels.mkcar.label,
						width : 350,
						//enableFilter : true,
						align : "center",
						editor : {
							type : "text"
						},
						formatter:function(){							
							return gridInputHandler.getTextInput(this);
						}
					}, {
						key : "seyno",
						width : 350,
//						label : "서열",
						label : labels.seyno.label,
						align : "center",
						editor : {
							type : "text"
						},
						formatter:function(){							
							return gridInputHandler.getTextInput(this);
						}
					}, {
						key : "seycd",
						width : 350,
//						label : "번호",
						label : labels.seycd.label,
						align : "center",
						editor : {
							type : "text"
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
			//console.log(this.item.rowType);
			//입력폼이 아닐 때 
			if (this.item.rowType !== 'insert') {
				setCarObj(this.item.comps, this.item.pyvnd, this.item.mkcar, this.item.seyno, this.item.seycd,
						  this.item.oldMkcar, this.item.oldSeyno, this.item.oldSeycd);
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
	
	$('.getPyvnd').on('change', function() {
		$(".getCusnm").val("");
	});

	gridInputHandler = new GridInput(grid);
	
	//등록버튼
	$("._addBtn_").on("click",function(){
		var target = this.getAttribute("data-click-target")
		saveBtnUiSet(this);

		setCarObj($(".getComps").val(), $(".getPyvnd").val(), "", "", "", "", "", "");
		
		gridInputHandler.addInput();
	});
	
	//저장버튼
	$("._saveBtn_").on("click", function(){
		var check = confirm(LN_CONFIRM_SAVE);
		var checkInput;
		if(check){
			checkInput = gridInputHandler.saveData(function(data){
					
				if(!val_chk(data.mkcar, LN_CHK_MKCAR) || !val_chk(data.seyno, LN_CHK_SEYNO) //|| !val_chk(data.seycd, LN_CHK_SEYCD)
				  ){
					return false;
				}

				setCarObj(data.comps?data.comps:$(".getComps").val(), data.pyvnd?data.pyvnd:$(".getPyvnd").val(), data.mkcar, data.seyno, data.seycd,
						  null, null, null);
				
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
				else toastMsg(LN_IO_CHK1);
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