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

<title>연봉계약</title>

<link rel="stylesheet" type="text/css" href="/assets/js/jqgrid-4.6.0/css/ui.jqgrid.css" />
<link rel="stylesheet" type="text/css" href="/assets/css/ui.jqgrid-reset.css" />
<link rel="stylesheet" type="text/css" href="/assets/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/assets/css/bootstrap-reset.css" />
<link rel="stylesheet" type="text/css" href="/assets/css/jquery-ui.css" />
<link rel="stylesheet" type="text/css" href="/assets/js/tui-grid/tui-grid.css"/>
<link rel="stylesheet" type="text/css" href="/assets/css/tui-grid-reset.css"/>
<link rel="stylesheet" type="text/css" href="/assets/js/tui-pagination/tui-pagination.css"/>
<link rel="stylesheet" type="text/css" href="/assets/js/tui-tree/tui-tree.css"/>

<!-- 메뉴바 -->
<link rel="stylesheet" type="text/css" href="/assets/css/font-awesome.css" />
<link type="text/css" href="/assets/js/axisj/ui/arongi/page.css" rel="stylesheet"/>
<link type="text/css" href="/assets/js/axisj/ui/arongi/AXJ.min.css" rel="stylesheet">
<link type="text/css" href="/assets/js/axisj/axicon/axicon.min.css" rel="stylesheet" />
<!-- <link type="text/css" href="/assets/js/ax5ui/ax5ui-kernel/dist/ax5ui.all.css" rel="stylesheet"> -->
<link type="text/css" href="/assets/css/messageArea.css" rel="stylesheet" />
<link type="text/css" href="/assets/css/jquery.mCustomScrollbar.css" rel="stylesheet" />
<link type="text/css" href="/assets/css/common.css" rel="stylesheet" />
<link type="text/css" href="/assets/css/layout.css" rel="stylesheet" />
<link type="text/css" href="/assets/css/main.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="/assets/css/font.css"/>
<link rel="stylesheet" type="text/css" href="/assets/css/lib.css"/>
<link rel="stylesheet" type="text/css" href="/assets/css/sub-layout.css"/>
<link rel="stylesheet" type="text/css" href="/assets/css/content.css"/>
<link rel="stylesheet" type="text/css" href="/assets/css/template.css"/>
<link rel="stylesheet" type="text/css" href="/assets/css/main2018.css"/>
<!-- 메뉴바/ -->

<!-- include jquery -->
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.13.0/moment.min.js"></script>

<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.min.css" rel="stylesheet"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
<link rel="stylesheet" href="/assets/css/summernote-bs4.css">


<!-- 커스텀이에요 -->
<link rel="stylesheet" type="text/css" href="/assets/css/custom.css"/>
<!-- 커스텀이에요 -->

<!-- <script type="text/javascript" src="/assets/js/kendo-2018.3.1017/js/jquery.min.js"></script> -->
<script type="text/javascript" src="/assets/js/underscore/underscore-min.js"></script>
<script type="text/javascript" src="/assets/js/backbone/backbone-min.js"></script>
<!-- <script type="text/javascript" src="/assets/js/jquery.mockjax.min.js"></script> -->
<!-- <script type="text/javascript" src="/assets/js/fileUploadCheck.js"></script> -->
<script type="text/javascript" src="/assets/js/warningDialog.js"></script>
<!-- <script type="text/javascript" src="/assets/js/jquery.mCustomScrollbar.concat.min.js"></script> -->
<!-- <script type="text/javascript" src="/assets/js/bootstrap.min.js"></script> -->

<!-- <script src="/assets/js/kendo-2018.3.1017/js/kendo.all.min.js"></script>
<script src="/assets/js/kendo-2018.3.1017/js/kendo.timezones.min.js"></script>
<script src="/assets/js/kendo-2018.3.1017/js/cultures/kendo.culture.ko-KR.min.js"></script> -->

<!-- <script type="text/javascript" src="/assets/js/tui-code-snippet/tui-code-snippet.min.js"></script>
<script type="text/javascript" src="/assets/js/tui-pagination/tui-pagination.min.js"></script>
<script type="text/javascript" src="/assets/js/tui-grid/tui-grid.js"></script>
<script type="text/javascript" src="/assets/js/tui-tree/tui-tree.js"></script> -->
<script type="text/javascript" src="/assets/js/libphonenumber-js.min.js"></script>
<script type="text/javascript" src="/assets/js/moment.min.js"></script>
<script type="text/javascript" src="/assets/js/moment.timezone.js"></script>

<!-- <script type="text/javascript" src="/assets/js/ax5ui/ax5ui-kernel/dist/ax5ui.all.min.js"></script> -->
<script type="text/javascript" src="/assets/js/subcommon.js"></script>
<script type="text/javascript" src="/assets/js/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="/assets/js/axisj/dist/AXJ.coremin.js"></script>
<script type="text/javascript" src="/assets/js/axisj/lib/AXTab.js"></script>


<script type="text/javascript" src="/assets/js/commonGridUtil.js" charset='utf-8'></script>
<script type="text/javascript" src="/assets/js/commonTextUtil.js" charset='utf-8'></script>
<script type="text/javascript" src="/assets/js/jqueryAjax.js" charset='utf-8'></script>
<script type="text/javascript" src="/assets/js/jquery.form.js" charset='utf-8'></script>
<!-- <script type="text/javascript" src="/assets/js/common.js"></script> -->
<!-- <script type="text/javascript" src="/assets/js/layout.js"></script> -->
<!--[if lt IE 9]>
<script type="text/javascript" src="/assets/js/html5shiv.min.js"></script>
<![endif]-->

<script type="text/javascript" src="/assets/js/summernote-bs4.js"></script>
<!-- include summernote-ko-KR -->
<script src="/assets/js/summernote-ko-KR.js"></script>
<script src="/assets/js/summernote-ja-JP.js"></script>
  
<script type="text/javascript" src="/assets/js/jqueryAjax.js" charset='utf-8'></script>


<!-- include jquery -->
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.13.0/moment.min.js"></script>

<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.min.css" rel="stylesheet"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
<link rel="stylesheet" href="/assets/css/summernote-bs4.css">

<!-- 커스텀이에요 -->
<link rel="stylesheet" type="text/css" href="/assets/css/custom.css"/>
<!-- 커스텀이에요 -->

<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.8.2/moment-with-locales.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.min.js"></script>

<!-- 달력 디자인 사용못함 썸머노트때문에 사용 불가 
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script> 
-->


<!-- include libs stylesheets -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<!-- <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.43/css/bootstrap-datetimepicker.min.css" />
<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.43/js/bootstrap-datetimepicker.min.js"></script> -->

<script type="text/javascript" src="/assets/js/commonGridUtil.js" charset='utf-8'></script>
<script type="text/javascript" src="/assets/js/commonTextUtil.js" charset='utf-8'></script>
<script type="text/javascript" src="/assets/js/jqueryAjax.js" charset='utf-8'></script>
<script type="text/javascript" src="/assets/js/jquery.form.js" charset='utf-8'></script>

<script type="text/javascript" src="/assets/js/summernote-bs4.js"></script>
<!-- include summernote-ko-KR -->
<script src="/assets/js/summernote-ko-KR.js"></script>
<script src="/assets/js/summernote-ja-JP.js"></script>

<!--[if lt IE 9]>
	<script type="text/javascript" src="assets/js/html5shiv.min.js"></script>
<![endif]-->

<!-- <style type="text/css" media="print">
        @page 
        {
            size: auto;   /* auto is the current printer page size */
            margin: 0mm;  /* this affects the margin in the printer settings */
        }

        body 
        {
            background-color:#FFFFFF; 
            border: solid 1px black ;
            margin: 0px;  /* the margin on the content before printing */
       }
    </style>-->
<script type="text/javascript"> 



// 뒤로가기 막기
history.pushState(null, null, location.href);
window.onpopstate = function(event) {
	history.go(1);
};

$(document).ready(function(){
	
	$('#p_agree_summernote').summernote({
		toolbar: [ ],
		followingToolbar: true,
		height: 890,	
		width : 930,
		lang: 'ko-KR'
	});
	// 서머노트 쓰기 비활성화
	$('#p_agree_summernote').summernote('disable');
	$("#btnConfirm").click(function() {
		
		
		var inbody = document.body.innerHTML; // 이전 body 영역 저장

		window.onbeforeprint = function(){ // 프린트 화면 호출 전 발생하는 이벤트

		    document.body.innerHTML = document.getElementById('p_agree_summernote').innerHTML; // 원하는 영역 지정

		}

		window.onafterprint = function(){ // 프린트 출력 후 발생하는 이벤트

		    document.body.innerHTML = inbody; // 이전 body 영역으로 복구

		}

		window.print();

	});
	
});

//폼데이터를 Json Arry로 직렬화
function fn_getFormData(form) {
    var unindexed_array = $(form).serializeArray();
    var indexed_array = {};
	
    $.map(unindexed_array, function(n, i){
        indexed_array[n['name']] = n['value'];
    });
	
    return indexed_array;
};

</script>

<style>

body {
	text-shadow: none;
}

</style>

</head>
<body>
<form id="application_form" name="application_form" >
<input type="hidden" id="edu_pk" name="edu_pk" value="${edu_pk }" />
<input type="hidden" id="userId" name="userId" value="${userId }" />

    <!-- 가운데 잡아줌 -->

      <div class="layout-LW">
        <!-- 좌측 -->
        
        <!-- 좌측 -->
        <div class="left" style="width:85%;">
             <!-- 1번표 -->
             <h2 class="subpage-tit">연봉정보</h2>
             
            <a style="float: right;color: #fff;" class="button" id="btnConfirm"><i class="w_ok"></i>인쇄</a>
             <table  class="bWrite">
                 <tbody id="second_table_2">
                 	<colgroup>
                 		<col width="20%" />
                 		<col width="20%" />
                 		<col width="20%" />
                 		<col width="*" />
                 		<col width="20%" />
                 		
                 	</colgroup>
                   <%--   <tr>
                         <th rowspan="2">역량평가</th>
                         <th>19년평가</th>
                         <th>승급액</th>
                         <th>20년연봉(조정후)</th>
                         <th>비고</th>
                     </tr>
                     <tr>
                     	 <td>${capacity_rt}</td>
                     	 <td>${capacity_amt}</td>
                     	 <td>${salary_amt}</td>
                     	 <td>연봉계약서금액</td>
                     </tr>
                      <tr>
                         <th rowspan="2">업적평가</th>
                         <th>19년평가</th>
                         <th colspan="2">지급액</th>
                         <th>비고</th>
                     </tr>
                     <tr>
                     	 <td>${perfor_rt}</td>                     	 
                     	 <td colspan="2">${perfor_amt}</td>
                     	 <td>연봉계약서불포함</td>
                     </tr>
                      --%>
                     
                     
                        <!-- 일반 연봉계약의 경우는 N -->
                     <c:if test="${emp_type_promotion == 'N' }">
	                     <tr>
	                         <th rowspan="2">역량평가</th>
	                         <th>19년평가</th>
	                         <th>승급액</th>
	                         <th>20년연봉(조정후)</th>
	                         <th>비고</th>
	                     </tr>
	                     <tr>
	                     	 <td>${capacity_rt}</td>
	                     	 <td>${capacity_amt}</td>
	                     	 <td>${salary_amt}</td>
	                     	 <td>연봉계약서금액</td>
	                     </tr>
	                     <tr>
	                         <th rowspan="2">업적평가</th>
	                         <th>19년평가</th>
	                         <th colspan="2">지급액</th>
	                         <th>비고</th>
	                     </tr>
	                     <tr>
	                     	 <td>${perfor_rt}</td>                     	 
	                     	 <td colspan="2">${perfor_amt}</td>
	                     	 <td>연봉계약서불포함</td>
	                     </tr>                     
                     </c:if >
                     
                     <!-- 승격연봉계약의 경우는 Y -->
                     <c:if test="${emp_type_promotion == 'Y' }">
                    	 <tr>
	                         <th>승격 전 연봉</th>
	                         <th>인상액</th>
	                         <th>승격후연봉</th>
	                         <th>비고</th>
	                     </tr>
	                     <tr>
	                     	 <td>${capacity_rt}</td>
	                     	 <td>${capacity_amt}</td>
	                     	 <td>${salary_amt}</td>
	                     	 <td>승격당해년도는 당해년도분 업적금 미발생</td>
	                     </tr>
                     </c:if >  
                     
                     
                     
                     <%-- <tr>
                         <th><spring:message code='label.eduUser5'/></th>
                         <td style="text-align: left;">${time} <spring:message code='label.eduUser11'/></td>
                     </tr> --%>
                     <%-- <tr>
                         <th><spring:message code='label.eduUser6'/></th>
                         <!--  <td class="download"><a href="javascript:fileDownlaod();">${org_att_name}</a></td>-->
                         <td style="text-align: left;"><ul id="file_list"></ul></td>
                     </tr> --%>
                 </tbody>
             </table>
         </div>
                
                

        <div class="left" style="width:51%;">
          <!-- 1번표 -->
          
            <col style="width:10px" />
            <h2 class="subpage-tit">계약서</h2>
			<br />
			<div algin="center">${agree_title}</div>

	           	<style type="text/css">
				.note-editor.note-frame .note-editing-area{width:100%;}
				</style>            
	        <div class="summernote" id="p_agree_summernote">${agree}</div>
        </div>
        <!-- 가운데 잡아줌// -->

	</div>
</form>
</body>
</html>