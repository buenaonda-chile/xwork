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

	console.log($("#cigmaDate").val());
	var check = confirm($(".getPlnym").val() + " 일일 수주이관작업입니다. 작업하시겠습니까? ");
	if(check){
		remoteCall();
	}		
}

function remoteCall(){
	var typcd = $(":input:radio[name=getTypcd]:checked").val();
	
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

	//
	var param = comps + plnym + pyvnd + cigmaDate + systemDate;

	for(i=param.length+1;i<=40;i++){
		param += " ";
	}
	param += userId;		
	for(var j=1;j<=10-userId.length;j++){
		param += " ";
	}
	//param += "000";
	param += "   ";

	// 73자리를 위한 20자리 공백
	param += "                    ";
	
	console.log(param);
	//E120201223000011002020051420201223      E150046   000
	
	mask.open();
	$.ajax({
		method : "post",
		url : "/WAN018NonOrderDayTransferWork/trans.do",
		data : {
			"getParam" : param
		},
		success : function(res) {
			var data = JSON.parse(res);

			toastMsg(data.rtnMsg);

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


	$('.getPyvnd').on('change', function() {
		$(".getCusnm").val("");
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
		var retObj = JSON.parse(returnValue);

		$('#getPyvnd').val(retObj.cusno);
		$('#getCusnm').val(retObj.cusnm);	
	}
}