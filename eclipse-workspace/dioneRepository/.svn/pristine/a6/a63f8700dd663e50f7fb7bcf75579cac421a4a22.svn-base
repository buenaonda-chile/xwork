
function tableToCSV( table ) {
    // We'll be co-opting `slice` to create arrays
    var slice = Array.prototype.slice;

    return slice.call( table.rows ).map(function ( row ) {
      return slice.call( row.cells ).map(function ( cell ) {
        return '"t"'.replace( "t", cell.textContent );
      }).join( "," );
    }).join( "\r\n" );

  }


function fnExcelReport()
{
	console.log('fnExcelReport');
    var tab_text="<table border='2px'><tr bgcolor='#87AFC6'>";
    var textRange; var j=0;
    tab = document.getElementById('boardInfoTable'); // id of table
    console.log(tab);
    for(j = 0 ; j < tab.rows.length ; j++) 
    {     
        tab_text=tab_text+tab.rows[j].innerHTML+"</tr>";
        tab_text=tab_text+"</tr>";
    }

    tab_text=tab_text+"</table>";
    tab_text= tab_text.replace(/<A[^>]*>|<\/A>/g, "");//remove if u want links in your table
    tab_text= tab_text.replace(/<img[^>]*>/gi,""); // remove if u want images in your table
    tab_text= tab_text.replace(/<input[^>]*>|<\/input>/gi, ""); // reomves input params

    var ua = window.navigator.userAgent;
    var msie = ua.indexOf("MSIE ");
    var agent = navigator.userAgent.toLowerCase(); 

    //IE old version ( IE 10 or Lower ) ||  / IE 11 
    if (msie > 0 || agent.search("trident") > -1)      // If Internet Explorer
    {
    	console.log("1번째");
    	var sa;
    	var txtArea1 = window.open("about:blank", "_blank");
        txtArea1.document.open("txt/html","replace");
        txtArea1.document.write(tab_text);
        txtArea1.document.close();
        txtArea1.focus(); 
        sa=txtArea1.document.execCommand("SaveAs",true,"Say Thanks to Sumit.xls");
    
        // Microsoft Edge
    } else if (agent.search( "edge/" ) > -1 ){
    	console.log("2번째");
    	toastMsg("Microsoft Edge는 지원하지 않습니다.");
    	// Generate our CSV string from out HTML Table
//    	  var csv = tableToCSV(document.querySelector(tab_text));
    	  // Create a CSV Blob
    	
    	
//    	  var blob = new Blob( [ tab_text ], { type: "text/html"} );
//    	  navigator.msSaveOrOpenBlob( blob, "output.xls" );
    	
    	
    } else {                 //other browser
    	
    	console.log("3번째");
//        sa = window.open('data:application/vnd.ms-excel,' + tab_text);
//    sa = window.open('data:application/vnd.ms-excel,' + encodeURIComponent(tab_text));
        var a = document.createElement('a');
	    var data_type = 'data:application/vnd.ms-excel';
	    var table_html = encodeURIComponent(tab_text);
	    a.href = data_type + ', ' + table_html;
	    a.download = 'test.xls';
	    
	    a.click();
//	    e.preventDefault();
    }
    return (sa);
}

function onKeyDown(e){
     if(e.keyCode == 13){
         searchProc();
         $('#WAC001BoardInfoSearchForm').submit();
         return false;
     }else{
    	 return true;
     }
}

function searchProc(){
	console.log('seachProc 실행');
	var sort = $('.nameId').val();
	if(sort === 'boardNm') {
		$('#boardNm').val($('#searchData').val());
	} else if (sort === 'boardId') {
		$('#boardId').val($('#searchData').val());
	}
	//$('#WAC001BoardInfoSearchForm').submit();
}

$(function(){	
	
	//조회버튼 클릭
	$('._searchBtn_').on('click', function(){
		console.log('조회 버튼 클릭');
		var sort = $('.nameId').val();
		if(sort === 'boardNm') {
			$('#boardNm').val($('#searchData').val());
		} else if (sort === 'boardId') {
			$('#boardId').val($('#searchData').val());
		}
		$('#WAC001BoardInfoSearchForm').submit();
	});
	
	$('._excelBtn_').on('click', function(){
		fnExcelReport();
	});
})