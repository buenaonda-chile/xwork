/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
"use strict";

function trans() {
	
	if(!$(".getComps").val()){
		toastMsg(LN_SELECT_COMPS);
		return false;
	}else if(!$(".getPlnym").val()){
		toastMsg(LN_SELECT_PLNYM);
		return false;
	}else if(!$(".getPyvnd").val()){
		toastMsg(LN_SELECT_PYVND);
		return false;
	}else if(!$("#cigmaDate").val()){
		toastMsg("[알림] 지원하지 않는 시스템 입니다. 정보관리팀으로 문의하십시요.");
		return false;
	}

	//console.log($("#cigmaDate").val());
	
	// 기준일자에 해당하는 자료 등록 여부 확인
	$.ajax({
		method : "post",
		url : "/WAN013OrderDayTransferWork/check.do",
		data : {			
			"getComps" : $("#getComps").val(),
			"getPyvnd" : $("#getPyvnd").val(),
			"getPlndt" : $("#getPlnym").val().replace(/-/gi, "")
		},
		success : function(res) {
			var data = JSON.parse(res);			
			
			var checkMsg = "";
			if (data.countMST040PF == "Y") {
				checkMsg = "업체코드 " + $(".getPyvnd").val() + "는 기준일자 " + $(".getPlnym").val() + "에 \n\nCIGMA이관처리 작업내역이 있습니다. \n\n수주이관작업을 재처리하시겠습니까?";
			}
			else checkMsg = "업체코드 " + $(".getPyvnd").val() + "의 기준일자 " + $(".getPlnym").val() + "에 \n\n수주이관작업을 하시겠습니까?";
			
			checkMsg = checkMsg + "\n\n<업로드 내역>\n" + data.msg;
			
			var check = confirm(checkMsg);
			if(check){
				remoteCall();
			}	
		},
		error : function() {
			//console.log("error");
		},
		completed : function() {
			//console.log("completed");
		}
	});
}

function remoteCall(){
	var selChk = $(":input:radio[name=getSelchk]:checked").val();
	
	var comps = $(".getComps").val();
	var plnym = $(".getPlnym").val().replace(/-/gi, "");
		
	var pyvnd = $(".getPyvnd").val();
	// 업체 8자리 '0'채우기	
	var st = "";
	for(var i=0; i<(8-pyvnd.length);i++){
		st += "0";
	}
	pyvnd = st + pyvnd;
	
	var cigmaDate = $("#cigmaDate").val().replace(/-/gi, "");
	var systemDate = $("#systemDate").val().replace(/-/gi, "");
	
	var userId = $("#getUserId").val();
	
	userId = 're' + userId;
	
	var param = comps + plnym + pyvnd + cigmaDate + systemDate;

	for(i=param.length+1;i<=40;i++){
		param += " ";
	}
	param += userId;		
	for(var j=1;j<=10-userId.length;j++){
		param += " ";
	}
	//param += "000";
	param += "000";

	// 73자리를 위한 20자리 공백
	//param += "                    ";
	
	console.log(param);
	//E120201223000011002020051420201223      E150046   000
	
	mask.open();
	$.ajax({
		method : "post",
		url : "/WAN013OrderDayTransferWork/trans.do",
		data : {
			"getParam" : param,
			
			// HISTORY 조건
			"getComps" : comps,
			"getPlndt" : plnym,
			"getPyvnd" : $(".getPyvnd").val(),
			"getAdsdt" : cigmaDate
		},
		success : function(res) {
			var data = JSON.parse(res);

			alert(data.rtnMsg);

			setTimeout(function() {
				mask.close();
			}, 500);
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

function cigmaDataExcelDownload(){
	if(!$(".getComps").val()){
		toastMsg(LN_SELECT_COMPS);
		return false;
	}else if(!$(".getPlnym").val()){
		toastMsg(LN_SELECT_PLNYM);
		return false;
	}else if(!$(".getPyvnd").val()){
		toastMsg(LN_SELECT_PYVND);
		return false;
	}
	
	mask.open();

	var downGrid = new ax5.ui.grid({
        target: $('[data-ax5grid="down-grid"]'),
        columns: [
        ]
    });
	
	$.ajax({
		method : "post",
		url : "/WAN013OrderDayTransferWork/cigmaDataSearch.do",
		data : {
			"getComps" : $(".getComps").val(),
			"getPyvnd" : $(".getPyvnd").val(),
			"getPlnym" : $(".getPlnym").val().replace(/-/gi, "")
		},
		success : function(res) {
			var data = JSON.parse(res);
				
			if (data.list.length > 0) {
				var stTitle    = "사업부,분류,업체코드,풍성품번,최종갱신일자,계획일자,계획수량,계획구분," +
				                 "CUSTOMER DUE DATE,ORDER QTY,SHIP INST. ALLOC QTY,SHIPPED QTY,SHIPPING DATE,CUSTOMER P.O. NO.";
                var stTitleKey = "comps,typcd,pyvnd,pspno,chgdt,plndt,basqy,plncd," + 
                                 "duedt,orqty,alqty,shdqy,shpdt,corno";
				
            	var downTitleArr = stTitle.split(',');
            	var downTitleKeyArr = stTitleKey.split(',');
            	for(var i=0 ; i<downTitleArr.length ; i++){
            		downGrid.addColumn({key: downTitleKeyArr[i], label: downTitleArr[i], align: "center", width : 250});
            	}

            	downGrid.appendToList(data.list);
            	
            	downGrid.exportExcel("CIGMA 수주 DATA.xls");
        		
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

$(document.body).ready(function() {

	var plnym_calendar = new ax5.ui.calendar({
        target: document.getElementById("plnym_calendar"),
        control: {
            left: '<i class="fa fa-chevron-left"></i>',
            yearTmpl: '%s',
            monthTmpl: '%s',
            right: '<i class="fa fa-chevron-right"></i>',
            yearFirst: true
        },
        displayDate: (new Date()),
        dimensions: {
            height: 250,
            controlHeight: 40,
            itemPadding: 1
        },
        lang: {
        	/*yearTmpl: "%s년",*/
            /*months: ['일월', '이월', '삼월', '사월', '오월', '육월', '칠월', '팔월', '구월', '시월', '십일월', '십이월'],*/
        	yearTmpl: YEAR_FORMAT,
        	months: MONTH,
        	dayTmpl: "%s"
        },
        onClick: function () {
            $(this.target).css('display', 'none');
            $(this.target).prev().val(plnym_calendar.getSelection());
        },
        onStateChanged: function () {
            //console.log(this);
        }
    });
	
	$('.log_board .dropdown').on('click', function(e){
		$($(e.target).next('.dropdown-menu')).css('display', 'block');
	});

	$('.getComps').on('change', function() {
		$(".getPyvnd").val("");
		$(".getCusnm").val("");
		
		// 사업부 변경되면 CIGMA일자 불러오기
		$.ajax({
			method : "post",
			url : "/WAN013OrderDayTransferWork/cigmaDate.do",
			data : {			
				"getComps" : $("#getComps").val()
			},
			success : function(res) {
				var data = JSON.parse(res);			
				
				if (data.cigmaDate == undefined) $("#cigmaDate").val("");
				else $('#cigmaDate').val(data.cigmaDate);
			},
			error : function() {
				//console.log("error");
			},
			completed : function() {
				//console.log("completed");
			}
		});
	});
	
	$('.getPyvnd').on('change', function() {
		$(".getCusnm").val("");
	});
    
	$('._custBtn_').on('click', function() {
		window.open("/ajaxCustomer/init.do","customerPop","width=550,height=600,scrollbars=yes,top=100,left=100");
	});
	 
	$('._excelDownBtn_').on('click', function() {
		cigmaDataExcelDownload();
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
					toastMsg(LN_IO_CHK1 + " : " + $('#getPyvnd').val());
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
 * 팝업창에서 값넘겨받아 부모창에 데이터 set
 * 
 * @param returnValue
 */
function getReturnValue(returnValue) {
	if(returnValue !== null) {
		var retObj = JSON.parse(returnValue);

		$('#getPyvnd').val(retObj.cusno);
		$('#getCusnm').val(retObj.cusnm);	
	}
}