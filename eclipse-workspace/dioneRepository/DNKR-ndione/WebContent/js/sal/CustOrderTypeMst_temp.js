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
    popGugn,
    gridInputHandler = null;

/**
 * [ko]객체
 */
function SeqObj () {
	this.comps = $("#setComps").val();	
	this.pyvnd = $("#setPyvnd").val();
	this.pspno = $("#setPspno").val();
	this.mcrcd = $("#setMcrcd").val();
	this.seqno = $("#setSeqno").val();
	this.seqcd = $("#setSeqcd").val();
	this.efffr = $("#setEfffr").val();
	this.effto = $("#setEffto").val();
	
	this.oldSeqno = $("#setOldSeqno").val();
	this.oldSeqcd = $("#setOldSeqcd").val();
	this.oldMcrcd = $("#setOldMcrcd").val();
	this.oldEfffr = $("#setOldEfffr").val();
	this.oldEffto = $("#setOldEffto").val();
}

/**
 * [ko] 선택자료 set
 */
function setSeqObj (item) {
	if(item == null){
		$("#setComps").val("");	
		$("#setPyvnd").val("");
		$("#setPspno").val("");
		$("#setMcrcd").val("");
		$("#setSeqno").val("");
		$("#setSeqcd").val("");
		$("#setEfffr").val("");
		$("#setEffto").val("");
	} else {	
		$("#setComps").val(item.comps);	
		$("#setPyvnd").val(item.pyvnd);
		$("#setPspno").val(item.pspno);
		$("#setMcrcd").val(item.mcrcd);
		$("#setSeqno").val(item.seqno);
		$("#setSeqcd").val(item.seqcd);
		$("#setEfffr").val(item.efffr);
		$("#setEffto").val(item.effto);
	}
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
		url : "/ajaxCustOrderTypeMst/init.do",
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
	
	/*
	if($(":input:radio[name=getPchk]:checked").val() == "2") $("._delBtn_").addClass("displayNone");
	else $("._delBtn_").removeClass("displayNone");
	*/
	
	// 초기화
	setSeqObj(null);
	
	$("#setOldSeqno").val("");
	$("#setOldSeqcd").val("");
	$("#setOldMcrcd").val("");
	$("#setOldEfffr").val("");
	$("#setOldEffto").val("");

	//gridBtnInit();
	gridDataInit(grid.target);
	
	mask.open();
	$.ajax({
		method : "post",
		url : "/ajaxCustOrderTypeMst/search.do",
		data : {
			"getComps" : $(".getComps").val(),
			"getPchk" : $(":input:radio[name=getPchk]:checked").val(),
			"getPyvnd" : $(".getPyvnd").val(),
			"getPspno" : $(".getPspno").val()
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
				$("#setPspno").val(data.list[0].pspno);
				$("#setMcrcd").val(data.list[0].mcrcd);
				$("#setSeqno").val(data.list[0].seqno);
				$("#setSeqcd").val(data.list[0].seqcd);
				$("#setEfffr").val(data.list[0].efffr);
				$("#setEffto").val(data.list[0].effto);
				
				$("#setOldSeqno").val(data.list[0].oldSeqno);
				$("#setOldSeqcd").val(data.list[0].oldSeqcd);
				$("#setOldMcrcd").val(data.list[0].oldMcrcd);
				$("#setOldEfffr").val(data.list[0].oldEfffr);
				$("#setOldEffto").val(data.list[0].oldEffto);
				
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
function insertSeq() {
	var ajaxParams = new SeqObj();
	
	mask.open();
	$.ajax({
		method : "post",
		url : "/ajaxCustOrderTypeMst/create.do",
		data : ajaxParams,
		success : function(res) {
			var data = JSON.parse(res);
			
			if (data.result === RESULT_OK) {
				toastMsg(RESULT_OK);
				
				search();

				setTimeout(function() {
					mask.close();
				}, 500);
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
function updateSeq() {

	var stateMsg,
	    ajaxParams = new SeqObj();
	
	$.ajax({
		url : "/ajaxCustOrderTypeMst/update.do",
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
function deleteSeq() {
	
	if(dataLength <= 0){
		toastMsg(LN_NO_DATA);
		return false;
	}
	
	var check = confirm(LN_CONFIRM_DELETE);
	if(check){	
		mask.open();
		var stateMsg,
		    delIndex = currGridIndex,
		    ajaxParams = new SeqObj();
		
		$.ajax({
			url : "/ajaxCustOrderTypeMst/delete.do",
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
							currGridIndex = this.dindex;
							
							setSeqObj(this.item);
							
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
						width : 0
					}, {
						key : "pspno",
//						label : "품번",
						label : labels.pspno.label,
						width : 120,
						//enableFilter : true,
						align : "left"
					}, {
						key : "itdsc",
						width : 240,
//						label : "품명",
						label : labels.itdsc.label,
						align : "left"
					}, {
						key : "carnm",
						width : 120,
//						label : "차종명",
						label : labels.carnm.label,
						align : "left"
					}, {
						key : "mkpno",
						width : 120,
//						label : "업체품번",
						label : labels.mkpno.label,
						align : "left"
					}, {
						key : "mcrcd",
						width : 70,
//						label : "차종코드",
						label : "* " + labels.mcrcd.label,
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
						key : "seqcd",
						width : 70,
//						label : "서열코드",
						label : "* " + labels.seqcd.label,
						align : "center",
						editor : {
							type : "text",
							attributes : {
								'maxlength' : 4,
								'data-maxlength' : 4
							}
						},
						formatter:function(){							
							return gridInputHandler.getTextInput(this);
						}
					}, {
						key : "seqno",
						width : 70,
//						label : "서열번호",
						label : "* " + labels.seqno.label,
						align : "center",
						editor : {
							type : "number",
							attributes : {
								'maxlength' : 3,
								'data-maxlength' : 3
							}
						},
						formatter:function(){							
							return gridInputHandler.getTextInput(this);
						}
					}, {
						key : "efffr",
						width : 100,
//						label : "적용FROM",
						label : "* " + labels.efffr.label,
						align : "center",
						editor : {
							type : "number",
							attributes : {
								'maxlength' : 8,
								'data-maxlength' : 8
							}
						},
						formatter:function(){							
							return gridInputHandler.getTextInput(this);
						}
					}, {
						key : "effto",
						width : 100,
//						label : "적용TO",
						label : "* " + labels.effto.label,
						align : "center",
						editor : {
							type : "number",
							attributes : {
								'maxlength' : 8,
								'data-maxlength' : 8
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
			//console.log(this.item.rowType);
			
			
			var efffr = this.item.efffr;
			var effto = this.item.effto;
			
			if(!(efffr == "" || efffr == null || efffr == "99999999") && !(effto == "" || effto == null || effto == "99999999")){
				if(efffr > effto){					
					grid.target.setValue(currGridIndex, "effto", "");
					toastMsg(LN_SELECT_EFFCK);
					return false;
				}
			}
			
			
			if (this.key == "mcrcd") {
				grid.target.setValue(currGridIndex, "mcrcd", this.item.mcrcd.toUpperCase());
				// TO..DO.. getCarSch(this.item.mcrcd);
			}
			if (this.key == "seqcd") {
				grid.target.setValue(currGridIndex, "seqcd", this.item.seqcd.toUpperCase());
			}
			
			setSeqObj(this.item);			
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
	
	$('#getPspno').bind("keyup", function(){       
	    $(this).val($(this).val().toUpperCase());  
	});
	
	$('.getPyvnd').on('change', function() {
		$(".getCusnm").val("");
	});
	
	$('.getPspno').on('change', function() {
		$(".getItdsc").val("");
	});
	
	$('.getPchk').on('change', function() {
		setSeqObj(null);
		
		$("#setOldSeqno").val("");
		$("#setOldSeqcd").val("");
		$("#setOldMcrcd").val("");
		$("#setOldEfffr").val("");
		$("#setOldEffto").val("");

		gridDataInit(grid.target);
	});
	
	gridInputHandler = new GridInput(grid);
	
	//저장버튼
	$("._saveBtn_").on("click", function(){
		
		if(dataLength <= 0){
			toastMsg(LN_NO_DATA);
			return false;
		}
		
		if(!val_chk($("#setMcrcd").val(), LN_CHK_MCRCD) || !val_chk($("#setSeqcd").val(), LN_CHK_SEQCD) || !val_chk($("#setSeqno").val(), LN_CHK_SEQNO)){
			return false;
		}
		
		/*
		var vEfffr = $("#setEfffr").val();
		var vEffto = $("#setEffto").val();
		
		if(!(vEfffr == "" || vEfffr == null || vEfffr == "99999999") && !(vEffto == "" || vEffto == null || vEffto == "99999999")){
			if(vEfffr > vEffto){					
				$("#setEfffo").val("");
				toastMsg(LN_SELECT_EFFCK);
				return false;
			}
		}
		*/
		
		var check = confirm(LN_CONFIRM_SAVE);
		var stateMsg,
		    saveCheck = false,
		    ajaxParams = new SeqObj(); 
				
		if(check){
			//중복차종 서열코드마스타 Check(중복차종서열코드마스타에　등록된　대표차종,서열은　등록不)
			$.ajax({
				url : "/ajaxCustOrderTypeMst/check.do",
				type : "post",
				data : ajaxParams,
				success : function(res) {
					var data = JSON.parse(res);
					
					if(data.result === RESULT_OK) {
						stateMsg = RESULT_OK;
						saveCheck = true;
					} else {
						stateMsg = data.errMsg;
					}
					
				},
				error : function() {
					stateMsg = "error";
				},
				complete : function() {				
					if (saveCheck) {
						if(vEfffr == "" || vEfffr == null) $("#setEfffr").val(new Date().toISOString().substr(0, 10).replace('T', ' ').replace(/-/gi, ''));

						if(vEffto == "" || vEffto == null) $("#setEffto").val("99999999");

						// 조회 자료에서 사업부 값이 없으면 신규로 확인
						if($("#setComps").val() == "") {
							$("#setComps").val($(".getComps").val());
							insertSeq();
						}
						else updateSeq();
					}
					else {
						if(stateMsg == "LN_CHK1") toastMsg(LN_CHK1);
						else if(stateMsg == "LN_CHK2") toastMsg(LN_CHK2);
						else if(stateMsg == "LN_CHK3") toastMsg(LN_CHK3);
						else if(stateMsg == "LN_CHK4") toastMsg(LN_CHK4);
						else toastMsg(stateMsg);
					}
				}
			});
		}
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
		grid.target.exportExcel("업체서열차종마스타.xls");
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
				"getCusno" : $("#getPyvnd").val()
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
				"getGbn" : "1"
			},
			success : function(res) {
				var data = JSON.parse(res);			

				if (data.list.length > 0) {
					$('#getItdsc').val(data.list[0].itdsc);
				}	
				else toastMsg(LN_CHK6);
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

/**
 * 대표차종코드로 차종명 검색하여 데이터 set
 * 
 * @param 대표차종코드
 */
function getCarSch(value) {
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
					grid.target.setValue(currGridIndex, "mcrcd", "");					
					toastMsg(LN_CHK5);					
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