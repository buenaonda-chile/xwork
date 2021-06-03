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
    popGugn;

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
		url : "/ajaxCustOrderTypeHistMstView/init.do",
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

	//gridBtnInit();
	gridDataInit(grid.target);
	
	mask.open();
	$.ajax({
		method : "post",
		url : "/ajaxCustOrderTypeHistMstView/search.do",
		data : {
			"getComps" : $(".getComps").val(),
			"getPyvnd" : $(".getPyvnd").val(),
			"getPspno" : $(".getPspno").val(),
			"getGubcd" : $(".getGubcd").val()
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
							key : "pspno",
//							label : "품번",
							label : labels.pspno.label,
							width : 250,
							align : "left",
							columns : [
								{
									key : "itdsc",
									width : 250,
//									label : "품명",
									label : labels.itdsc.label,
									align : "left"
								}
							  ]
						}, {
							key : "gubcd",
							width : 80,
//							label : "구분",
							label : labels.gubcd.label,
							align : "center"
						}, {
							key : "mcrcd1",
							width : 120,
//							label : "전차종",
							label : labels.mcrcd1.label,
							align : "center",
							columns : [
								{
									key : "mcrcd2",
									width : 120,
//									label : "후차종",
									label : labels.mcrcd2.label,
									align : "center"
								}
					          ]
						}, {
							key : "seqcd1",
							width : 80,
//							label : "서열",
							label : labels.seqcd1.label,
							align : "center",
							columns : [
								{
									key : "seqcd2",
									width : 80,
//									label : "서열",
									label : labels.seqcd2.label,
									align : "center"
								}
					          ]
						}, {
							key : "seqno1",
							width : 80,
//							label : "서열",
							label : labels.seqno1.label,
							align : "center",
							columns : [
								{
									key : "seqno2",
									width : 80,
//									label : "서열",
									label : labels.seqno2.label,
									align : "center"
								}
					          ]
						}, {
							key : "efffr1",
							width : 100,
//							label : "적용일자FR",
							label : labels.efffr1.label,
							align : "center",
							columns : [
								{
									key : "efffr2",
									width : 100,
//									label : "적용일자FR",
									label : labels.efffr2.label,
									align : "center"
								}
					          ]
						}, {
							key : "effto1",
							width : 100,
//							label : "적용일자TO",
							label : labels.effto1.label,
							align : "center",
							columns : [
								{
									key : "effto2",
									width : 100,
//									label : "적용일자TO",
									label : labels.effto2.label,
									align : "center"
								}
					          ]
						}, {
							key : "devnm2",
							width : 100,
//							label : "단말기명",
							label : labels.devnm2.label,
							align : "center",
							columns : [
								{
									key : "uptdt2",
									width : 100,
//									label : "변경일자",
									label : labels.uptdt2.label,
									align : "center"
								}
					          ]
						}, {
							key : "usrid2",
							width : 100,
//							label : "사용자ID",
							label : labels.usrid2.label,
							align : "center",
							columns : [
								{
									key : "upttm2",
									width : 100,
//									label : "변경시간",
									label : labels.upttm2.label,
									align : "center",
									formatter:function(){
										var time = this.value;
										if(time.length == 6) { 
											return time.substr(0, 2) + ":" + time.substr(2, 2) + ":" + time.substr(4); 
										} else { 
											return time; 
										}
									}									
								}
					          ]
						} ],	
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
	
	$('#getPspno').bind("keyup", function(){       
	    $(this).val($(this).val().toUpperCase());  
	});
	
	$('.getPyvnd').on('change', function() {
		$(".getCusnm").val("");
	});
	
	$('.getPspno').on('change', function() {
		$(".getItdsc").val("");
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
		grid.target.exportExcel("업체서열차종이력마스타조회.xls");
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
				else {
					toastMsg(LN_IO_CHK1 + " : " + $("#getPyvnd").val());
					$('#getPyvnd').val("");
					//$('#getCusnm').val("");
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
				"getGbn" : "1",
				"getComps" : $("#getComps").val()
			},
			success : function(res) {
				var data = JSON.parse(res);			
				
				if (data.list.length > 0) {
					$('#getItdsc').val(data.list[0].itdsc);
				}			
				else {
					toastMsg(LN_CHK1 + " : " + $("#getPspno").val());
					$("#getPspno").val("");
					//$("#getItdsc").val("");
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