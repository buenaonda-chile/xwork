/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
"use strict";
var picker = new ax5.ui.picker();
		
		var psogmFIC_grid = {
			initView : function() {
				this.target = new ax5.ui.grid();
				this.target.setConfig({
					target : $('[data-ax5grid="psogmFIC-grid"]'),
			showLineNumber: true,
			header: {
	            align: "center"
	        },
	        body: {
	        	align: "center",
	        	onClick : function() {
	        		this.self.clearSelect();
					this.self.select(this.dindex);
					$('#inpno').val(this.item.inpno);
					$('#prtno2').val(this.item.prtno);
//					$('#prtno2').next().val(this.item.prtnm);
//					$('#model').val(this.item.model);
//					$('#vndnr2').val(this.item.vndnr);
//					$('#vname').val(this.item.vname);
//					$('#inqty').val(this.item.inqty);
//					$('#icost').val(this.item.icost);
					$('#iamt').val(Number(this.item.iamt));
					$('#inuse').val(this.item.inuse);
					
					getPartInfo(this.item.prtno);
	        	}
	        },
	        columns:
        	[
				{label: "입고일자", key: "indat", width: 100,
					formatter : function() {
						return this.value.substr(0,4) + '-' + this.value.substr(4,2) + '-' + this.value.substr(6,2);
					}
				},
				{label: "Part no", key: "prtno", width: 100},
				{label: "품명", key: "prtnm", width: 150},
				{label: "규격", key: "model", width: 150},
				{label: "단위", key: "punit", width: 50},
				{label: "구입선", key: "vname", width: 100},
				{label: "입고량", key: "inqty", width: 70, align: "right",
					formatter : function() {
						return Number(this.value);
					}
				},
				{label: "입고단가", key: "icost", width: 80, align: "right",
					formatter : function() {
						return Number(this.value);
					}
				},
				{label: "입고금액", key: "iamt", width: 80, align: "right",
					formatter : function() {
						return Number(this.value);
					}
				},
				{label: "입고자", key: "kornm", width: 100},
				{label: "용도", key: "inuse", width: 100},
				{label: "재고수량", key: "jg", width: 70, align: "right"},
				{label: "평균단가", key: "pcost", width: 80, align: "right",
					formatter : function() {
						return Number(this.value);
					}
				},
        	 ],
		});
	}
};
		
//돋보기 버튼 클릭 시 리스트 조회
function searchDetailList(target) {
	var type = target.getAttribute('data-target');
	var comps = $('#comps').val();
	var group = $('#group').val();
	var menu = target.getAttribute('data-menu');
	var inputEl = $(target).closest('td').find('input');
	var param = inputEl[0].value;
	var url = "/WAF004PsogmForceICreate/ficSearchPop.do?menu=";
	url += menu  + "&type=" + type + "&comps=" + comps + "&group=" + group;
	window.open(url + "&pData=" + param,"ficSearchPop","width=580,height=700,scrollbars=yes,top=100,left=100");
}

//강제입고등록조회
function searchFIC() {
	var params = $('#searchForm').serialize();
	$.ajax({
		type    : "POST",
		url     : "/WAF004PsogmForceICreate/getGridVal.do",
		data    : params,
		success : function (data){
			//console.log(data);
			try{
    			var parse = JSON.parse(data);
    			if(parse.result === RESULT_Y){
    				psogmFIC_grid.target.setData(parse.list);
    			}else {
    				toastMsg('조회된 데이터가 없습니다.');
    				document.searchForm.reset();
    				psogmFIC_grid.target.setData([]);
    			}
			}catch(e){
				console.log(e);
			}
		},
		error: function(){ 
		
		},
		complete: function() {
			
		}
	});
}


/**
 * [KO] 등록폼에 prtno2로 조회한 정보 bind
 * @param pDomain object
 */
function setFICData (pDomain) {
	if(pDomain !== undefined) {
		$('#prtno2').next().val(pDomain.prtnm);
		$('#model').val(pDomain.model);
		$('#jg').val(pDomain.jg);
		$('#createForm #vndnr2').val(pDomain.vndnr);
		$('#createForm #vndnr2').next().val(pDomain.vname);
		$('#createForm #pcost').val(pDomain.pcost);
		$('#createForm #icost').val(pDomain.pcost);
		if ($('#inqty').val().trim().length > 0) {
			calcuCost($('#inqty').val());
		}
	} else {
		toastMsg("[확인] 품목이 존재하지 않습니다. 확인바랍니다.");
	}
}


/**
 * [KO] #prtno2 에 값이 입력되면 품목정보 가져오기 
 * @param param
 */
function getPartInfo(param) {
	if(param.trim().length > 0) {
		var url = "/WAF004PsogmForceICreate/searchSpareUnit.do";
		var params = {
				prtno: param,
				group: $('#group').val(),
		}
		var jsonData = getAjaxDomain(url, params);
		var pDomain = jsonData.pDomain;
		setFICData(pDomain);
	}
}


/**
 * 입고금액 계산
 * @param inqty 입고수량
 */
function calcuCost(inqty) {
	$('#iamt').val(Number(inqty) * Number($('#icost').val()) || 0);
}

/**
 * [KO] 마감된 월인지 체크 true : 마감전, false : 마감                   
 * 
 * @returns {Boolean} 
 */
function closeYN() {
	var url = "/WAF004PsogmForceICreate/chkClose.do";
	var param = {"indat" : $('#indat').val()};
	var jsonData = getAjaxDomain(url, param);
//	var obj = jsonData.pDomain;
//	if (obj === undefined) {
	if (jsonData === undefined) {
		return true;
	} else {
		toastMsg("마감처리된 월입니다.");
		return false;
	}
}

		
$(document.body).ready(function() {
	
	//Date
	picker.bind({
        target: $('[data-ax5picker="basic"]'),
        direction: "top",
        content: {
            width: 270,
            margin: 10,
            type: 'date',
            config: {
                control: {
                    left: '<i class="fa fa-chevron-left"></i>',
                    yearTmpl: '%s',
                    monthTmpl: '%s',
                    right: '<i class="fa fa-chevron-right"></i>'
                },
                lang: {
                    yearTmpl: "%s년",
                    months: ['01월', '02월', '03월', '04월', '05월', '06월', '07월', '08월', '09월', '10월', '11월', '12월'],
                    dayTmpl: "%s"
                }
            }
        },
        onStateChanged: function () {

        }
    });
	
	//Date
	picker.bind({
        target: $('[data-ax5picker="basic2"]'),
        direction: "top",
        content: {
            width: 270,
            margin: 10,
            type: 'date',
            config: {
                control: {
                    left: '<i class="fa fa-chevron-left"></i>',
                    yearTmpl: '%s',
                    monthTmpl: '%s',
                    right: '<i class="fa fa-chevron-right"></i>'
                },
                lang: {
                    yearTmpl: "%s년",
                    months: ['01월', '02월', '03월', '04월', '05월', '06월', '07월', '08월', '09월', '10월', '11월', '12월'],
                    dayTmpl: "%s"
                }
            }
        },
        onStateChanged: function () {

        }
    });
	
	psogmFIC_grid.initView();
	searchFIC();
	
	//전체조회
	$('.iSearchBtn').on('click', function() {
		searchFIC();
	});
	
	//돋보기 버튼조회
	$('.searchBtn').on('click', function() {
		searchDetailList(this);
	});
	
	//등록
	$('.addBtn').on('click', function() {
		if(chkManager({group : "1"}) 
				&& closeYN() 
				&& val_chk($('#inuse').val().trim(), "용도")
				&& val_chk($('#emp').val().trim(), "입고담당자")
				&& val_chk($('#prtno2').val().trim(), "품번")
				&& val_chk($('#prtno2').next().val().trim(), "품번")
				&& val_chk($('#vndnr2').val().trim(), "업체번호")
				&& val_chk($('#vndnr2').next().val().trim(), "업체번호")
				&& val_chk($('#inqty').val().trim(), "입고수량")){
			if(Number($('#inqty').val()) === 0) {
				toastMsg("입고수량을 입력하세요 (1이상)");
				return false;
			}
			if(confirm("선택하신 품목을 입고처리 하시겠습니까?")) {
				if(Number($('#inqty').val()) > 0) {
					$('#createForm').submit();
				}
			}
			
		}		
	});
	
	//엑셀
	$('._excelBtn_').on('click', function() {
		psogmFIC_grid.target.exportExcel("psogmCre-excel.xls");
	});
});

