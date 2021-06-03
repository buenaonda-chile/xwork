<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible"  content="IE=Edge" />
<meta http-equiv="Pragma"           content="no-cache" />
<meta http-equiv="Cache-Control"    content="no-cache, no-store" />
<meta http-equiv="Expires"          content="-1" />

<title>덴소코리아</title>

<!-- 메뉴바 -->
<link rel="stylesheet" type="text/css" href="/assets/css/font-awesome.css" />
<link type="text/css" href="/assets/css/common.css" rel="stylesheet" />
<link type="text/css" href="/assets/css/layout.css" rel="stylesheet" />
<link type="text/css" href="/assets/css/main.css" rel="stylesheet" />

<link rel="stylesheet" type="text/css" href="/assets/css/lib.css"/>
<link rel="stylesheet" type="text/css" href="/assets/css/sub-layout.css"/>
<link rel="stylesheet" type="text/css" href="/assets/css/content.css"/>
<link rel="stylesheet" type="text/css" href="/assets/css/template.css"/>
<link rel="stylesheet" type="text/css" href="/assets/css/main2018.css"/>
<!-- 메뉴바/ -->

<link rel="stylesheet" type="text/css" href="/assets/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/assets/css/bootstrap-reset.css" />
<link rel="stylesheet" type="text/css" href="/assets/css/jquery-ui.css" />
<link rel="stylesheet" type="text/css" href="/assets/js/jqgrid-4.6.0/css/ui.jqgrid.css" />
<link rel="stylesheet" type="text/css" href="/assets/css/ui.jqgrid-reset.css" />
 
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
 
 <link rel="stylesheet" type="text/css" href="/assets/css/font.css"/>
 <!-- 커스텀이에요 -->
<link rel="stylesheet" type="text/css" href="/assets/css/custom.css"/>
<!-- 커스텀이에요 -->
 
<script type="text/javascript" src="/assets/js/jquery-2.1.3.min.js"></script>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
  
<script type="text/javascript" src="/assets/js/commonGridUtil.js" charset='utf-8'></script>
<script type="text/javascript" src="/assets/js/commonTextUtil.js" charset='utf-8'></script>
<script type="text/javascript" src="/assets/js/jquery.jqGrid.min.js" charset='utf-8'></script>
<script type="text/javascript" src="/assets/js/jqgrid/i18n/grid.locale-en.js" charset='utf-8'></script>
<script type="text/javascript" src="/assets/js/jqueryAjax.js" charset='utf-8'></script>

  
<!--[if lt IE 9]>
<script type="text/javascript" src="/assets/js/html5shiv.min.js"></script>
<![endif]-->

<style>
span {
	font-size: 12px;
	color: #fff;
}

.center_search_container p {
	display: inline;
	font-size: 12px;
}
</style>


<script type="text/javascript">

$(function(){
	
	/* $("#p_start_date, #p_end_date").datepicker({
		closeText          : '닫기',
        currentText        : '오늘',
        dateFormat         : 'yy-mm-dd',
        prevText           : '이전 달',
        nextText           : '다음 달',
        monthNames         : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
        monthNamesShort    : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
        dayNames           : ['일','월','화','수','목','금','토'],
        dayNamesShort      : ['일','월','화','수','목','금','토'],
        dayNamesMin        : ['일','월','화','수','목','금','토'],
        showMonthAfterYear : true,
        buttonImage        : '/images/icon/calendar.gif',
        buttonImageOnly    : true,
        changeMonth        : true,
        changeYear         : true,
        showButtonPanel    : true			    	
  	}); */
	
    /* $("a.b1.toggle").on("click",function(e){
        e.preventDefault();
        var $that = $($(this).attr('href'));
        if($(this).hasClass("on")){
            $(this).removeClass("on");
            $that.hide();
        }else{
            $(this).addClass("on");
            $that.show();
        }
    }); */
});

var idRow;
var idCol;
var kRow;
var kCol;
var resultData = [];

var jqGridObj = $('#jqGridList');

$(document).ready(function(){
	
	$('#jqGridList').jqGrid({ 
	    datatype: 'json', 
	    mtype: 'POST',
	    url: 'eduRltDtlList.do',
	    //ajaxGridOptions: { contentType: "application/json;charset=utf-8" },
	    postData : fn_getFormData('#application_form'),
	    colNames : ['SEQ', '공장', '지역명', '팀명', '사용자', '사용자ID', '교육여부', '사용자의견'],
	    colModel : [
					{name:'emp_number',index:'emp_number', width:35, hidden : true},
					{name:'cls_name',index:'cls_name', width:35},
					{name:'loc_name',index:'loc_name', width:35, sortable:false, align:'center'},
					{name:'team_name',index:'team_name', width:35, align:'center'},
					{name:'emp_name',index:'emp_name', align:'center', width:40},
					{name:'emp_id',index:'emp_id', width:35, sortable:false, align:'center'},
					{name:'edu_complete', width:35, align:'center', sortable:true, title:false},
					{name:'user_descript', width:100, align:'center', sortable:true, title:false}
				],
	    gridview: true,
	    toolbar: [false, "bottom"],
	    viewrecords: true,
	    autowidth: false,
	    cellEdit : true,
        cellsubmit : 'clientArray', // grid edit mode 2
	    scrollOffset : 17,
	    shrinkToFit:true,
	    multiselect: false,
	    rownumbers: true,
	    pager: $('#btnjqGridList'),
	    rowList:[100,500,1000],
	    recordtext: '내용 {0} - {1}, 전체 {2}',
	    emptyrecords:'조회 내역 없음',
	    rowNum : 100, 
		beforeEditCell :  function(rowid, cellname, value, iRow, iCol) {
	    	idRow=rowid;
	    	idCol=iCol;
	    	kRow = iRow;
	    	kCol = iCol;
		},
		beforeSaveCell : chmResultEditEnd,
		jsonReader : {
	        root: "rows",
	        page: "page",
	        total: "total",
	        records: "records",  
	        repeatitems: false,
	    },        
	    //imgpath: 'themes/basic/images',
	    onPaging: function(pgButton) {
	    	
    		var pageIndex         = parseInt($(".ui-pg-input").val());
   			var currentPageIndex  = parseInt($('#jqGridList').getGridParam("page"));// 페이지 인덱스
   			var lastPageX         = parseInt($('#jqGridList').getGridParam("lastpage"));  
   			var pages = 1;
   			var rowNum 			  = 100;	   

   			if (pgButton == "user") {
   				if (pageIndex > lastPageX) {
   			    	pages = lastPageX
   			    } else pages = pageIndex;
   				
   				rowNum = $('.ui-pg-selbox option:selected').val();
   			}
   			else if(pgButton == 'next'){
   				pages = currentPageIndex+1;
   				rowNum = $('.ui-pg-selbox option:selected').val();
   			} 
   			else if(pgButton == 'last'){
   				pages = lastPageX;
   				rowNum = $('.ui-pg-selbox option:selected').val();
   			}
   			else if(pgButton == 'prev'){
   				pages = currentPageIndex-1;
   				rowNum = $('.ui-pg-selbox option:selected').val();
   			}
   			else if(pgButton == 'first'){
   				pages = 1;
   				rowNum = $('.ui-pg-selbox option:selected').val();
   			}
 	   		else if(pgButton == 'records') {
   				rowNum = $('.ui-pg-selbox option:selected').val();     
   			}
   			
   			$(this).jqGrid("clearGridData");
   			$(this).setGridParam({datatype: 'json',page:''+pages, rowNum:''+rowNum}).triggerHandler("reloadGrid"); 		
		 },		
		 loadComplete: function (data) {
			 
			var $this = $(this);
			if ($this.jqGrid('getGridParam', 'datatype') === 'json') {
			    $this.jqGrid('setGridParam', {
			        datatype: 'local',
			        data: data.rows,
			        pageServer: data.page,
			        recordsServer: data.records,
			        lastpageServer: data.total
			    });
			
			    this.refreshIndex();
			
			    if ($this.jqGrid('getGridParam', 'sortname') !== '') {
			        $this.triggerHandler('reloadGrid');
			    }
			} else {
			    $this.jqGrid('setGridParam', {
			        page: $this.jqGrid('getGridParam', 'pageServer'),
			        records: $this.jqGrid('getGridParam', 'recordsServer'),
			        lastpage: $this.jqGrid('getGridParam', 'lastpageServer')
			    });
			    this.updatepager(false, true);
			}	
			
		},
		ondblClickRow: function(row_id, iCol, cellcontent, e) {
				
			var cm = $(this).jqGrid( "getGridParam", "colModel" );
			var colName = cm[iCol];

			var edu_pk = $("#edu_pk").val();
			if(row_id != null) {
				var item = $('#jqGridList').jqGrid('getRowData',row_id);
				
				if(item.edu_complete == 'O') {
					// 동의서 출력
					window.open("eduRltPopup.do?edu_pk="+edu_pk+"&emp_id="+item.emp_id, "<spring:message code='label.eduDetail17'/>", "width=1100, height=800, left=300, top=50");
				}
				
	        }
		}
	}); //end of jqGrid

	// jqGrid 크기 동적화
	fn_gridresize( $(".left"), $( "#jqGridList" ), -300 );
	
	
	// Search 버튼 클릭 시 Ajax로 리스트를 받아 넣는다.
	$("#btnSearch").click(function(){
		fn_search();
	});
	
	$("#btnReg").click(function(){
		var edu_pk = $("#edu_pk").val();
		location.href = "eduRltListExcel.do?edu_pk="+ edu_pk;
	});
	
	
});

//검색
function fn_search() {
	
	//검색 시 스크롤 깨짐현상 해결
	$( "#jqGridList" ).closest(".ui-jqgrid-bdiv").scrollLeft(0); 
	
	var sUrl = "/eduRltDtlList.do";
	$( "#jqGridList" ).jqGrid( "clearGridData" );
	$( "#jqGridList" ).jqGrid( 'setGridParam', {
		url : sUrl,
		mtype : 'POST',
		datatype : 'json',
		page : 1,
		postData : fn_getFormData( "#application_form" )
	} ).trigger( "reloadGrid" );
}

//afterSaveCell oper 값 지정
function chmResultEditEnd( irowId, cellName, value, irow, iCol ) {
	var item = $( '#jqGridList' ).jqGrid( 'getRowData', irowId );
	if( item.oper != 'I' ){
		item.oper = 'U';
		$( '#jqGridList' ).jqGrid('setCell', irowId, cellName, '', { 'background' : '#6DFF6D' } );
	}
	$( '#jqGridList' ).jqGrid( "setRowData", irowId, item );
	$( "input.editable,select.editable", this ).attr( "editable", "0" );
}
  
</script>
</head>
<body>
    <form id="application_form" name="application_form">
        <input type="hidden" id="edu_pk" name="edu_pk" value="${edu_pk}" />
        <jsp:include page="/eduHeader.do" flush="true"></jsp:include>
        
        <!-- 가운데 잡아줌 -->
        <div class="doc-wrap" id="docBaseWrap">
            <div class="layout-LW">
                <!-- 좌측 -->
                <div class="left" style="width:923px;">
                    <!-- 1번표 -->
                    <col style="width:100px" />
                    <h2 class="subpage-tit">교육결과현황</h2>
                    <div class="search">
                        <div id="btnSearch" >
                        	<a class="button">
                        		<i class="w_search"></i>
                        		<span>검색</span>
                        	</a>
                        </div>
                        <div class="center_search_container">
                            <p>이름</p>
                            <input type="text" id="p_subject" name="p_subject" value="" />
                            <p></p>
                           	<select id="p_complete" name="p_complete">
                           		<option value="">전체</option>
                           		<option value="O">완료</option>
                           		<option value="X">미완료</option>
                           	 </select>
                        </div>
                    </div>
                        
         			<table id="jqGridList" class="bWrite" ></table>
                    <div id="btnjqGridList" ></div>
                    <br />
                    <div class="enrollment">
                        <div id="btnReg">
                        	<a class="button">
                        		<span>전체 다운로드</span>
                        	</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</body>
</html>