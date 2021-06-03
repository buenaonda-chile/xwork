/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
"use strict";

function create() {
	
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
	
	var check = confirm($(".getPlnym").val() + " HKMC VAN 일일판매 생성작업입니다. 작업하시겠습니까? ");
	if(check){
		remoteCall();
	}		
}

function remoteCall(){
	// * 코드가 10이라면 0이 6자리 : 00000010
	// 문자열 73자리수
	// 1  2   사업부
	// 3  8   기준일자
	// 11 8   업체코드
	// 41 10  아이디
	// 51 3   코드 (공백으로 스페이스3칸)	

	var comps = $(".getComps").val();
	var plnym = $(".getPlnym").val().replace(/-/gi, "");
		
	var pyvnd = $(".getPyvnd").val();
	// 업체 8자리 '0'채우기	
	var st = "";
	for(var i=0; i<(8-pyvnd.length);i++){
		st += "0";
	}
	pyvnd = st + pyvnd;
	
	var userId = $("#getUserId").val();

	//
	var param = comps + plnym + pyvnd;

	for(i=param.length+1;i<=40;i++){
		param += " ";
	}
	param += userId;		
	for(var j=1;j<=10-userId.length;j++){
		param += " ";
	}
	//param += '000';
	param += "   ";

	// 73자리를 위한 20자리 공백
	param += "                    ";
	
	
	console.log(param);
	//E12020122300001100                      E150046   000
	
	mask.open();
	$.ajax({
		method : "post",
		url : "/WAN010OrderDaySaleCreate/create.do",
		data : {
			"getParam" : param
		},
		success : function(res) {
			
			var data = JSON.parse(res);

			//alert(data.rtnMsg);
			confirm(data.rtnMsg);
			
			setTimeout(function() {
				mask.close();
			}, 500);
		},
		error : function() {
			
			confirm("error");
			//toastMsg("error");
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

	$('.getComps').on('change', function() {
		$(".getPyvnd").val("");
		$(".getCusnm").val("");
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
				else {
					toastMsg(LN_IO_CHK1 + " : " + $("#getPyvnd").val());
					$("#getPyvnd").val("");
					//$("#getCusnm").val("");
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