<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

<link rel="stylesheet" type="text/css" href="/assets/js/jqgrid-4.6.0/css/ui.jqgrid.css" />
<link rel="stylesheet" type="text/css" href="/assets/css/ui.jqgrid-reset.css" />
<link rel="stylesheet" type="text/css" href="/assets/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/assets/css/bootstrap-reset.css" />
<link rel="stylesheet" type="text/css" href="/assets/css/jquery-ui.css" />
 
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
 
 <link rel="stylesheet" type="text/css" href="/assets/css/font.css"/>
 <!-- 커스텀이에요 -->
<link rel="stylesheet" type="text/css" href="/assets/css/custom.css"/>
<!-- 커스텀이에요 -->
<style>
.enrollment_center {
	position: relative;
	left: 206px;
}
</style>
 
<script type="text/javascript" src="/assets/js/jquery-2.1.3.min.js"></script>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
  
<script type="text/javascript" src="/assets/js/commonGridUtil.js" charset='utf-8'></script>
<script type="text/javascript" src="/assets/js/commonTextUtil.js" charset='utf-8'></script>
<script type="text/javascript" src="/assets/js/jquery.jqGrid.min.js" charset='utf-8'></script>
<script type="text/javascript" src="/assets/js/jqgrid/i18n/grid.locale-en.js" charset='utf-8'></script>
<script type="text/javascript" src="/assets/js/jqueryAjax.js" charset='utf-8'></script>
<!--[if lt IE 9]>
	<script type="text/javascript" src="assets/js/html5shiv.min.js"></script>
<![endif]-->

<script type="text/javascript">
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
	    url: 'getClsCodeList.do',
	    //ajaxGridOptions: { contentType: "application/json;charset=utf-8" },
	    postData : fn_getFormData('#application_form'),
	    colNames : ['사업부 코드', '사업부 명칭', 'OPER'],
	    colModel : [
					{name:'cls_code',index:'cls_code', width:100, align:'center'},
					{name:'rel_name',index:'rel_name', width:120, align:'center'},
					{name:'oper', width:50, align:'center', sortable:true, title:false, hidden: true}
				],
	    gridview: true,
	    toolbar: [false, "bottom"],
	    viewrecords: true,
	    autowidth: false,
	    cellEdit : true,
        cellsubmit : 'clientArray', // grid edit mode 2
	    //scrollOffset : 17,
	    shrinkToFit:true,
	    multiselect: false,
	    rownumbers: true,
	    //pager: $('#btnjqGridList'),
	    rowList:[100,500,1000],
	    recordtext: '내용 {0} - {1}, 전체 {2}',
	    emptyrecords:'조회 내역 없음',
	    rowNum : 9999, 
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
		gridComplete : function() {
			var rows = $( "#jqGridList" ).getDataIDs();
			for ( var i = 0; i < rows.length; i++ ) {
				$( "#jqGridList" ).jqGrid( 'setCell', rows[i], 'cls_code', '', { cursor : 'pointer' } );
				$( "#jqGridList" ).jqGrid( 'setCell', rows[i], 'rel_name', '', { cursor : 'pointer' } );
			}
		},
		onCellSelect: function(rowid, iCol, e){ // cell을 클릭 시

         	var item = $("#jqGridList").jqGrid('getRowData', rowid);

			$("#cls_code").val(item.cls_code);
			fn_loc_search();
	
		}
	}); //end of jqGrid
	
	$('#jqGridList2').jqGrid({ 
	    datatype: 'json', 
	    mtype: 'POST',
	    url: '',
	    postData : fn_getFormData('#application_form'),
	    colNames : ['사업장 코드', '사업장 명칭', 'OPER'],
	    colModel : [
					{name:'loc_code',index:'loc_code', width:100, align:'center'},
					{name:'rel_name',index:'rel_name', width:120, align:'center'},
					{name:'oper', width:50, align:'center', sortable:true, title:false, hidden: true}
				],
	    gridview: true,
	    toolbar: [false, "bottom"],
	    viewrecords: true,
	    autowidth: false,
	    cellEdit : true,
        cellsubmit : 'clientArray', // grid edit mode 2
	    //scrollOffset : 17,
	    shrinkToFit:true,
	    multiselect: false,
	    rownumbers: true,
	    //pager: $('#btnjqGridList'),
	    rowList:[100,500,1000],
	    recordtext: '내용 {0} - {1}, 전체 {2}',
	    emptyrecords:'조회 내역 없음',
	    rowNum : 9999, 
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
   			var currentPageIndex  = parseInt($('#jqGridList2').getGridParam("page"));// 페이지 인덱스
   			var lastPageX         = parseInt($('#jqGridList2').getGridParam("lastpage"));  
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
		gridComplete : function() {
			var rows = $( "#jqGridList2" ).getDataIDs();
			for ( var i = 0; i < rows.length; i++ ) {
				$( "#jqGridList2" ).jqGrid( 'setCell', rows[i], 'loc_code', '', { cursor : 'pointer' } );
				$( "#jqGridList2" ).jqGrid( 'setCell', rows[i], 'rel_name', '', { cursor : 'pointer' } );
			}
		},
		onCellSelect: function(rowid, iCol, e){ // cell을 클릭 시

         	var item = $("#jqGridList2").jqGrid('getRowData', rowid);

			$("#loc_code").val(item.loc_code);
			$("#loc_name").val(item.rel_name);
			fn_team_search();
	
		}
	}); //end of jqGrid
	
	$('#jqGridList3').jqGrid({ 
	    datatype: 'json', 
	    mtype: 'POST',
	    url: '',
	    //ajaxGridOptions: { contentType: "application/json;charset=utf-8" },
	    postData : fn_getFormData('#application_form'),
	    colNames : ['부서(팀) 코드', '부서(팀) 명칭', 'OPER'],
	    colModel : [
					{name:'team_code',index:'team_code', width:100, align:'center'},
					{name:'rel_name',index:'rel_name', width:120, align:'center'},
					{name:'oper', width:50, align:'center', sortable:true, title:false, hidden: true}
				],
	    gridview: true,
	    toolbar: [false, "bottom"],
	    viewrecords: true,
	    autowidth: false,
	    cellEdit : true,
        cellsubmit : 'clientArray', // grid edit mode 2
	    //scrollOffset : 17,
	    shrinkToFit:true,
	    multiselect: true,
	    rownumbers: true,
	    //pager: $('#btnjqGridList'),
	    rowList:[100,500,1000],
	    recordtext: '내용 {0} - {1}, 전체 {2}',
	    emptyrecords:'조회 내역 없음',
	    rowNum : 9999, 
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
   			var currentPageIndex  = parseInt($('#jqGridList3').getGridParam("page"));// 페이지 인덱스
   			var lastPageX         = parseInt($('#jqGridList3').getGridParam("lastpage"));  
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
			
		}
	}); //end of jqGrid

	// jqGrid 크기 동적화
	fn_insideGridresize( $(window), $( "#left1" ), $( "#jqGridList" ), -150, 0.5 );
	fn_insideGridresize( $(window), $( "#left2" ), $( "#jqGridList2" ), -150, 0.5 );
	fn_insideGridresize( $(window), $( "#left3" ), $( "#jqGridList3" ), -150, 0.5 );
	
	/* fn_gridresize( $("#left1"), $( "#jqGridList" ), -150 );
	fn_gridresize( $("#left2"), $( "#jqGridList2" ), 0 );
	fn_gridresize( $("#left3"), $( "#jqGridList3" ), 0 ); */
	
	
	// Search 버튼 클릭 시 Ajax로 리스트를 받아 넣는다.
	$("#btnSearch").click(function(){
		fn_cls_search();
	});
	$("#btnSearch2").click(function(){
		fn_loc_search();
	});
	$("#btnSearch3").click(function(){
		fn_team_search();
	});
	
	$("#btnSave").click(function(){
		
		//아이템 체크 Validation
		var selarrrow = $("#jqGridList3").jqGrid('getGridParam', 'selarrrow');
		
		if(selarrrow == ""){
			alert("부서를 선택하세요.");
			return false;
		}
		
		var dept_pk = [];
		var dept_name = [];
		
		var str = opener.$("#p_dept_cd").val();
		if(str.split(",").length > 0) {
			for(var i=0; i<str.split(",").length; i++) {
				if(str.split(",")[i] != '') {
					dept_pk.push(str.split(",")[i]);
				}
			}			
		}
		
		var strNm = opener.$("#p_dept_name").val();
		if(strNm.split(",").length > 0) {
			for(var i=0; i<strNm.split(",").length; i++) {
				if(strNm.split(",")[i] != '') {
					dept_name.push(strNm.split(",")[i]);
				}
			}			
		}
		
		for(var i=0; i<selarrrow.length; i++) {
			var item = $("#jqGridList3").jqGrid( 'getRowData', selarrrow[i]);
			dept_pk.push(item.team_code);
			dept_name.push($("#loc_name").val() + "_" + item.rel_name);
		}
		
		var resultArr = [];
		var resultNameArr = [];
		resultArr = removeDuplicatesArray(dept_pk);
		resultNameArr = removeDuplicatesArray(dept_name);
		
		opener.$("#p_dept_cd").val(resultArr);
		opener.$("#p_dept_name").val(resultNameArr);
		opener.$("#p_dept").text(resultNameArr);
		
		//적용시 창 유지
		//self.close();
	});
	
	$("#btnCancel").click(function(){
		self.close();
	});
	
});

function removeDuplicatesArray(arr) {
    var tempArr = [];
    for (var i = 0; i < arr.length; i++) {
        if (tempArr.length == 0) {
            tempArr.push(arr[i]);
        } else {
            var duplicatesFlag = true;
            for (var j = 0; j < tempArr.length; j++) {
                if (tempArr[j] == arr[i]) {
                    duplicatesFlag = false;
                    break;
                }
            }
            if (duplicatesFlag) {
                tempArr.push(arr[i]);
            }
        }
    }
    return tempArr;
}

function fn_cls_search() {
	
	//검색 시 스크롤 깨짐현상 해결
	$( "#jqGridList" ).closest(".ui-jqgrid-bdiv").scrollLeft(0); 
	
	var sUrl = "/getClsCodeList.do";
	$( "#jqGridList" ).jqGrid( "clearGridData" );
	$( "#jqGridList" ).jqGrid( 'setGridParam', {
		url : sUrl,
		mtype : 'POST',
		datatype : 'json',
		page : 1,
		postData : fn_getFormData( "#application_form" )
	} ).trigger( "reloadGrid" );
}

function fn_loc_search() {
	
	//검색 시 스크롤 깨짐현상 해결
	$( "#jqGridList2" ).closest(".ui-jqgrid-bdiv").scrollLeft(0); 
	
	var sUrl = "/getLocCodeList.do";
	$( "#jqGridList2" ).jqGrid( "clearGridData" );
	$( "#jqGridList2" ).jqGrid( 'setGridParam', {
		url : sUrl,
		mtype : 'POST',
		datatype : 'json',
		page : 1,
		postData : fn_getFormData( "#application_form" )
	} ).trigger( "reloadGrid" );
}

function fn_team_search() {
	
	//검색 시 스크롤 깨짐현상 해결
	$( "#jqGridList3" ).closest(".ui-jqgrid-bdiv").scrollLeft(0); 
	
	var sUrl = "/getTeamCodeList.do";
	$( "#jqGridList3" ).jqGrid( "clearGridData" );
	$( "#jqGridList3" ).jqGrid( 'setGridParam', {
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
<input type="hidden" id="cls_code" name="cls_code" value=""/>
<input type="hidden" id="loc_code" name="loc_code" value=""/>
<input type="hidden" id="loc_name" name="loc_name" value=""/>
    <!-- 가운데 잡아줌 -->
    <div class="doc-wrap" id="docBaseWrap">
        <div class="layout-LW">
            <!-- 좌측 -->
            <div style="width: 1000px;">
            
                <div class="left" style="width: 300px;" id="left1">
                    <!-- 1번표 -->
                    <col style="width:100px" />
                    <col />
                    <h2 class="subpage-tit">팀별권한설정</h2>
                    <div class="enrollment_center_3">
                        <input type="text" id="clsQuery" name="clsQuery" placeholder="Search..." value="" />
                        <a class="button" id="btnSearch"><i class="w_cancel"></i>검색</a>
                    </div>
                    <br>
                    <table id="jqGridList" class="bWrite" ></table>
                </div>
                
                <div class="left" style="width: 300px; margin-left: 15px;" id="left2">
                    <!-- 1번표 -->
                    <col style="width:100px" />
                    <col />
                    <h2 style="background-image:none;">&nbsp;</h2>
                    <div class="enrollment_center_3">
                        <input type="text" id="locQuery" name="locQuery" placeholder="Search..." value="" />
                        <a class="button" id="btnSearch2"><i class="w_cancel"></i>검색</a>
                    </div>
                    <br>
                    <table id="jqGridList2" class="bWrite" ></table>
                </div>
                
                <div class="left" style="width: 300px; margin-left: 15px;" id="left3">
                    <!-- 1번표 -->
                    <col style="width:100px" />
                    <col />
                    <h2 style="background-image:none;">&nbsp;</h2>
                    <div class="enrollment_center_3">
                        <input type="text" id="teamQuery" name="teamQuery" placeholder="Search..." value="" />
                        <a class="button" id="btnSearch3"><i class="w_cancel"></i>검색</a>
                    </div>
                    <br>
                    <table id="jqGridList3" class="bWrite" ></table>
                </div>
                
            </div>
        </div>
        
        <div class="enrollment_center">
            <a class="button" id="btnSave"><i class="w_save"></i>적용</a>
            <a class="button" id="btnCancel"><i class="w_cancel"></i>닫기</a>
        </div>
    </div>
</form>    
</body>
</html>