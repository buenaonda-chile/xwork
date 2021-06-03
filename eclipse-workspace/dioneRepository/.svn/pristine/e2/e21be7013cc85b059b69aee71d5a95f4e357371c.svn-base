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

div#viewLoading {
 width: 100%;  
 height: 100%;  
 top: 0;
 left: 0;
 position: fixed;  
 display: block;  
 opacity: 0.7;  
 background-color: #fff;  
 z-index: 99;  
 text-align: center;
 padding : 100px 0px;

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
	   
	$('#viewLoading').hide(); //첫 시작시 로딩바를 숨겨준다.
	
	$('#jqGridList').jqGrid({ 
	    datatype: 'json', 
	    mtype: 'POST',
	    url: 'salaryRltDtlList.do',
	    //ajaxGridOptions: { contentType: "application/json;charset=utf-8" },
	    postData : fn_getFormData('#application_form'),
	    colNames : ['SEQ', '공장', '지역명', '팀명', '사용자', '사번', '체결여부', '연봉', '연봉(한글)','역량평가','승급액','업적평가','지급액'],
	    colModel : [
					{name:'emp_number',index:'emp_number', width:100, hidden : true},
					{name:'cls_name',index:'cls_name', width:50},
					{name:'loc_name',index:'loc_name', width:40, sortable:false, align:'center'},
					{name:'team_name',index:'team_name', width:190, align:'left'},
					{name:'emp_name',index:'emp_name', align:'center', width:60},
					{name:'emp_number',index:'emp_number', width:70, sortable:false, align:'center'},
					{name:'edu_complete', width:50, align:'center', sortable:true, title:false},
					{name:'salary_amt', width:90, align:'center', sortable:true, title:false},
					{name:'salary_kr', width:120, align:'center', sortable:true, title:false},
					{name:'capacity_rt', width:50, align:'center', sortable:true, title:false},
					{name:'capacity_amt', width:80, align:'center', sortable:true, title:false},
					{name:'perfor_rt', width:50, align:'center', sortable:true, title:false},
					{name:'perfor_amt', width:80, align:'center', sortable:true, title:false}
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
					window.open("salaryRltPopup.do?edu_pk="+edu_pk+"&emp_id="+item.emp_number+"&emp_number="+item.emp_number, "<spring:message code='label.eduDetail17'/>", "width=1100, height=800, left=300, top=50");
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
	
	// 전체다운로드 버튼 처리
	$("#btnReg").click(function(){
		var edu_pk = $("#edu_pk").val();
		location.href = "salaryRltListExcel.do?edu_pk="+ edu_pk;
	});
	
	// 메일전송 버튼 처리
	$("#btnMailSend").click(function(){
		btnMailSend();
	});
	
	
	// Search 버튼 클릭 시 Ajax로 리스트를 받아 넣는다.
	$("#btnUpload").click(function(){
		fn_mountInfoUpload();
	});
	
	
	var fileTarget = $('.filebox .upload-hidden');
	fileTarget.on('change', function(){ // 값이 변경되면

		if(window.FileReader){ // modern browser

            var temp = $(this)[0].files;
            for (var i=0; i<temp.length; i++) {

                var filename = temp[i].name;

                var file = temp[i];

                var formData = new FormData();
                formData.append("file", file);

                // 파일 업로드 AJAX 통신
                fn_upload(formData);
			}

		} else { // old IE
			var filename = $(this).val().split('/').pop().split('\\').pop(); // 파일명만 추출

            var file = $(this)[0].files[0];

            var formData = new FormData();
            formData.append("file", file);

            // 파일 업로드 AJAX 통신
            fn_upload(formData);
		}
	});
	
});


//검색
function fn_search() {
	
	//검색 시 스크롤 깨짐현상 해결
	$( "#jqGridList" ).closest(".ui-jqgrid-bdiv").scrollLeft(0); 
	
	var sUrl = "salaryRltDtlList.do";
	$( "#jqGridList" ).jqGrid( "clearGridData" );
	$( "#jqGridList" ).jqGrid( 'setGridParam', {
		url : sUrl,
		mtype : 'POST',
		datatype : 'json',
		page : 1,
		postData : fn_getFormData( "#application_form" )
	} ).trigger( "reloadGrid" );
}

// 연봉 정보 파일 업로드 
function fn_mountInfoUpload() {

	var edu_pk = $("#edu_pk").val();
	
	location.href = "salaryInfoUpload.do?edu_pk="+edu_pk;

	
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
  

// 리마인드메일 전송
function btnMailSend() {
	
	//ajax 실행시 
	$(document).ajaxStart(function () {
	    $("#viewLoading").show();
	});
	
	//ajax 실행시 완료시
	$(document).ajaxStop(function () {
		$("#viewLoading").hide();
	});
	
	var edu_pk = $("#edu_pk").val();
	
    var formData = null;

 	$.ajax({
 		url: "mailSend.do?edu_pk="+ edu_pk,
 		data: formData,
 		dataType: "json",
 		type: "POST",
 		//이 파라미터를 넣으면 비동기에서 동기화로 바뀝니다. 
 		// 동기화 하면 ajaxStart,ajaxStart 안됨
 		//async: false,
 		error: function () {
 			alert('시스템 오류입니다.\n전산담당자에게 문의해주세요.');
 		},
 		success: function (data) {
            
			alert("리마인드메일 전송 완료\n했습니다.");
			
			var str = "교육 미완료자는 " + data.getNoEduMailList + " 명입니다.<br>"
					+ "메일 전송수는 " + data.mailSendSuccess + " 건입니다."
			$("#mailSendMsg").append(str);
			
 		}
 	});
}


//파일 업로드
function fn_upload(formData){
	
  $.ajax({
		url: "attachFileUpload.do?edu_pk="+$("#edu_pk").val(),
		dataType: "json",
		data: formData,
		type: "POST",
		//multipart/form-data 방식으로 넘겨야 하기에 false
		processData: false,
		contentType: false,
		error: function () {
			alert('시스템 오류입니다.\n전산담당자에게 문의해주세요.');
		},
		//이 파라미터를 넣으면 비동기에서 동기화로 바뀝니다.
      async:false,
		success: function (data) {
		    console.log("1 : "+data)
          console.log("1 : "+JSON.stringify(data));
		    if ( data.result == 'fail' ) {
				alert("첨부파일 업로드 실패");
			} else {
				fn_printFile(data);
				$("#p_imagecours").val(data.edu_pk);
			}
		}

	});
}

//파일목록 추가
function fn_printFile(data){

  console.log("fn_printFile : "+data);
  
  var str = "";
  var del_link = "javascript:fn_deleteFile(" + data.edu_pk +","+data.pk +");";
  str = "<br><li class='file_list' id='li_" + data.pk + "' >"
 		 + "<a href='/fileDownload.do?fileName=" + data.file_name + "&org_file_name=" + encodeURI(data.org_file_name) + "' target='_blank'>" 
  	+  data.org_file_name + "</a>" +
      "<br><input type='button' value='삭제' onclick='" + del_link + "'/></li><br>";
      
  $("#file_list").append(str);
}


//파일목록 삭제
function fn_printFileDel(pk){
  $("#li_" +pk).remove();
  $(".filebox").val('');
  $(".upload-hidden").val('');
}

//파일 목록 조회
function fn_selectFile(edu_pk){
	var formData = null;

	$.ajax({
		url: "/salary/searchFileDataList.do?edu_pk="+edu_pk,
		data: formData,
		dataType: "json",
		type: "POST",
		error: function () {
			alert('시스템 오류입니다.\n전산담당자에게 문의해주세요.');
		},
		success: function (data) {

			if ( data.result == 'fail' ) {
				alert("첨부파일 조회 실패");
			} else {
			    // 목록 표시
              for (var i = 0; i < data.list.length; i++) {
                  var item = data.list[i];
                  $("#p_imagecours").val(item.edu_pk);
                  $('.pk').val(item.pk);
                  fn_printFile(item);
              }
			}
		}
	});
}

//파일 삭제
function fn_deleteFile(edu_pk, pk){
	 var formData = null;

	$.ajax({
		url: "attachFileDelete.do?edu_pk="+edu_pk+"&pk="+pk,
		data: formData,
		dataType: "json",
		type: "POST",
		error: function () {
			alert('시스템 오류입니다.\n전산담당자에게 문의해주세요.');
		},
		success: function (data) {
			//alert("data.result : " + data.result);
			if ( data.result == 'fail' ) {
				alert("첨부파일 삭제 실패");
			} else {
              fn_printFileDel(pk);
			}
		}
	});
}


</script>
</head>
<body>

    <form id="application_form" name="application_form">
        <input type="hidden" id="edu_pk" name="edu_pk" value="${edu_pk}" />
        <jsp:include page="/salary/salaryHeader.do" flush="true"></jsp:include>

        <!-- 가운데 잡아줌 -->
        <div class="doc-wrap" id="docBaseWrap">
            <div class="layout-LW">
                <!-- 좌측 -->
                <div class="left" style="width:1300px;position:relative;">
                    <!-- 1번표 -->
                    <col style="width:100px" />
                    <h2 class="subpage-tit">연봉체결현황</h2>
                    <div class="search" style="margin-top:-10px">
                        <div id="btnSearch">
                        

		                    <!-- <div class="enrollment">
		                        <div id="btnMailSend" style="position:absolute;right:8px;top:37px;">
		                        	<a class="button">
		                        		<span>리마인드 메일 발송</span>
		                        	</a>
		                        </div>
		                    </div>	 -->	                    
		                    <ul id="mailSendMsg"></ul>
							<a class="button" >
                        		<i class="w_search"></i>
                        		<span>검색</span>
                        	</a>                         
                        </div>
                        <div class="center_search_container">
                            <p>이름&nbsp;</p>
                            <input type="text" id="p_subject" name="p_subject" value="" />
                            <p></p>
                           	<select id="p_complete" name="p_complete" style="font-size:12px;">
                           	
                           		<option value="">전체</option>
                           		<option value="O">완료</option>
                           		<option value="X">미완료</option>
                           	 </select>                         	 
                        </div>
                        
                        <table class="bWrite" style="width: 1272px;">
				            <div class="layout-LW">
				                <tbody>
				                    <tr>
				                        <th style="width:130px">연봉업로드</th>
				                        <td style="text-align: left;">
				                       		<div class="filebox">
												<input type="file" id="file" name="file"  class="upload-hidden"
												 style="text-align:center; width:250px; height:32px;padding:5px;"
												 multiple/>
				                        	</div>
				                        	<ul id="file_list"></ul>
				                        </td>
				                        <td style="width:165px;text-align: left;">
				                         	<div id="btnReg">
					                        	<a class="button bc1">
					                        		<span>   전체 다운로드   </span>
					                        	</a>
					                         </div>
						                     <div id="btnUpload" >
						                       	<a class="button bc1">
						                       		<span>   업로드   </span>
						                       	</a>
						                     </div>
				                        </td>
				                    </tr>
				               </tbody>
				            </div>
				        </table>
                        
                    </div>
                    
                    <!-- 로딩이미지 -->
                    <div id="viewLoading">
				 		<img src="images/ajax-loader-5.gif" />
					</div>
					
         			<table id="jqGridList" class="bWrite" ></table>
                    <div id="btnjqGridList" ></div>
			        
                   <!--  <div class="enrollment">
                        <div id="btnReg">
                        	<a class="button">
                        		<span>전체 다운로드</span>
                        	</a>
                        </div>
                    </div> -->

                </div>
            </div>
        </div>
    </form>
</body>
</html>