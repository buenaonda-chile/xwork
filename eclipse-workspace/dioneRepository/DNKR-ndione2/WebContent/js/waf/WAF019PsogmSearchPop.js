/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
"use strict";


$(document.body).ready(function() {

	//책임자 버튼
	$('.directorBtn').on('click', function() {
		var btnType = this.getAttribute('data-type');
		var classNm = this.getAttribute('data-target');
		changeDisplay(classNm, btnType);
	});
	
	//완료일 버튼
	$('.wndatBtn').on('click', function() {
		var btnType = this.getAttribute('data-type');
		var classNm = this.getAttribute('data-target');
		changeDisplay(classNm, btnType);
	});
	
	//지시No 버튼
	$('.jisnoBtn').on('click', function() {
		var btnType = this.getAttribute('data-type');
		var classNm = this.getAttribute('data-target');
		changeDisplay(classNm, btnType);
	});
	
	//현상 버튼
	$('.hyosnBtn').on('click', function() {
		var btnType = this.getAttribute('data-type');
		var classNm = this.getAttribute('data-target');
		changeDisplay(classNm, btnType);
	});
	
	//원인 버튼
	$('.woninBtn').on('click', function() {
		var btnType = this.getAttribute('data-type');
		var classNm = this.getAttribute('data-target');
		changeDisplay(classNm, btnType);
	});
	
	//대책 버튼
	$('.daechBtn').on('click', function() {
		var btnType = this.getAttribute('data-type');
		var classNm = this.getAttribute('data-target');
		changeDisplay(classNm, btnType);
	});
	
	$('.exel').on('click', function() {
		//location.href = "/WAF001PsogmSearch/psogmExcel.do?filename=searchList";
		
		var params = $('#searchForm').serialize();
		var searchForm = document.searchForm;
		var url = "/WAF001PsogmSearch/psogmExcel.do";
		window.open('', '_blank');
		
		searchForm.action = url;
		searchForm.method = "POST";
		searchForm.target = '_blank';
		searchForm.param = params;
		searchForm.submit();
	});
});

/**
 * 
 * @param jisno
 */
function resultPop(jisno) {
	var comps = $('#comps').val();
	window.open("/WAF001PsogmSearch/resultPop.do?jisno=" + jisno + "&comps=" + comps,"resultPop","width=1080,height=845,scrollbars=yes,top=100,left=100");
}


function changeDisplay (targetName, type) {
	var targets = [];
	if(type === "D") {
		targets = [["directorTd"], ["wndatTd"], ["jisnoTd"]];
	} else {
		targets = [["hyosnTd"], ["woninTd"], ["daechTd"]];
		
		if(targetName === "hyosnTd") {
			
		} else if (targetName === "woninTd") {
			
		} else if (targetName === "daechTd") {
			
		}
	}
	
	targets.forEach(function(item, index) {
		$('.' + item).addClass('displayNone');
		console.log(item);
	});
	$('.' + targetName).removeClass('displayNone');
}

/**
 * [KO]화면의 테이블을 엑셀파일로 다운로드시켜주는 함수
 * @param tableId 테이블 태그의 아이디 
 */
var fnExcelReport = function(tableId, id){
	//console.log('fnExcelReport');
    var tab_text = "<table border='2px'><tr bgcolor='#87AFC6'>";
    var textRange; 
    var j=0;
//    tab = document.getElementById('empTable'); // id of table
    var tab = document.getElementById(tableId); // id of table
    //console.log(tab);
    for(j = 0 ; j < tab.rows.length ; j++){
    	//console.log("for");
    	console.log(j + ":" + tab.rows[j]);
    	console.log(j + ":" + tab.rows[j].innerHTML);
        tab_text = tab_text + tab.rows[j].innerHTML+"</tr>";
        tab_text = tab_text + "</tr>";
    }

    tab_text = tab_text + "</table>";
    tab_text= tab_text.replace(/<A[^>]*>|<\/A>/g, "");//remove if u want links in your table
    tab_text= tab_text.replace(/<img[^>]*>/gi,""); // remove if u want images in your table
    tab_text= tab_text.replace(/<input[^>]*>|<\/input>/gi, ""); // reomves input params

    var ua = window.navigator.userAgent;
    var msie = ua.indexOf("MSIE ");
    var agent = navigator.userAgent.toLowerCase(); 

    //IE old version ( IE 10 or Lower ) ||  / IE 11 
    if (msie > 0 || agent.search("trident") > -1)      // If Internet Explorer
    {
    	//console.log("1번째");
    	var sa;
    	var txtArea1 = window.open("about:blank", "_blank");
        txtArea1.document.open("txt/html","replace");
        txtArea1.document.write(tab_text);
        txtArea1.document.close();
        txtArea1.focus(); 
        sa=txtArea1.document.execCommand("SaveAs",true,"Say Thanks to Sumit.xls");
    
        // Microsoft Edge
    } else if (agent.search( "edge/" ) > -1 ){
    	//console.log("2번째");
    	toastMsg("Microsoft Edge는 지원하지 않습니다.");
    	// Generate our CSV string from out HTML Table
//    	  var csv = tableToCSV(document.querySelector(tab_text));
    	  // Create a CSV Blob
    	
    	
//    	  var blob = new Blob( [ tab_text ], { type: "text/html"} );
//    	  navigator.msSaveOrOpenBlob( blob, "output.xls" );
    	
    	
    } else {                 //other browser
    	
    	//console.log("3번째");
//        sa = window.open('data:application/vnd.ms-excel,' + tab_text);
//    sa = window.open('data:application/vnd.ms-excel,' + encodeURIComponent(tab_text));
        var a = document.createElement('a');
	    var data_type = 'data:application/vnd.ms-excel;charset=UTF-8';
	    var table_html = encodeURIComponent(tab_text);
	    console.log(table_html);
	    a.href = data_type + ',%EF%BB%BF' + table_html;
	    a.download = id + '_excel.xls';
	    
	    console.log(a);
	    a.click();
//	    e.preventDefault();
    }
    return (sa);
}
