/**
 * sub 페이지에서 명령어 사용방법을 단순화 시킨다.
 * 
 */

var alert = function(msg) {
	window.parent.alert(msg);
} 

var danger = function(msg) {
	window.parent.danger(msg);
}

var toastMsg = function(msg) {
	window.parent.toastMsg(msg);
}

var mask = window.parent.mask;

var navClose = window.parent.navClose;

var tabResize = function() {
	//console.log("tabResize()");
	try {
		var div = document.getElementById("tab_container");
		var parentDiv = document.getElementById("tab_container").firstElementChild.innerText;
		//toastMsg("parentDiv : " + parentDiv);
		if (div.offsetHeight != 0) {
			/*console.log("parentDiv:" + parentDiv);
			console.log("div:" + div);
			console.log("div.offsetHeight:" + div.offsetHeight);*/
			/* iframe 높이
			$('#' + parentDiv, window.parent.document).css(
					"height", div.offsetHeight + 170 + "px");
			$('#' + parentDiv, window.parent.document).css(
					"min-height", "500px");
			*/
			$('#' + parentDiv, window.parent.document).css(
					"height", div.offsetHeight + 0 + "px");
			$('#' + parentDiv, window.parent.document).css(
					"min-height", "500px");
			
			$('#mainNav-wrap').css('height', $(document).height());

			/* 북마크 */
			$('.bookmark-page').css('height', $(document).height());
			/* 바로가기 */
			$('.ico-menu').css('height', $(document).height() - 45);
		}
	} catch (e) {
		//toastMsg(e);
	}	
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

var subPageInit = function() {
	//console.log("subPageInit()");
	tabResize();
	parent.leftNavResize();
}



$(document.body).ready(function() {
	//console.log("subPageStart");
	subPageInit();
});



	

	