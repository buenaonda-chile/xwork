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

<title><spring:message code='label.edutitle'/></title>

<!-- <link rel="stylesheet" type="text/css" href="/assets/js/ax5ui/ax5ui-kernel/dist/ax5ui.all.css" />
<link rel="stylesheet" type="text/css" href="/assets/js/kendo-2018.3.1017/css/web/kendo.common.min.css" />
<link rel="stylesheet" type="text/css" href="/assets/js/kendo-2018.3.1017/css/web/kendo.rtl.min.css" />
<link rel="stylesheet" type="text/css" href="/assets/js/kendo-2018.3.1017/css/web/kendo.default.min.css" />
<link rel="stylesheet" type="text/css" href="/assets/js/kendo-2018.3.1017/css/web/kendo.default.mobile.min.css" />
<link rel="stylesheet" type="text/css" href="/assets/js/kendo-2018.3.1017/css/dataviz/kendo.dataviz.min.css" />
<link rel="stylesheet" type="text/css" href="/assets/js/kendo-2018.3.1017/css/dataviz/kendo.dataviz.default.min.css" /> -->
<link rel="stylesheet" type="text/css" href="/assets/css/kendo-reset.css" />
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

<!-- <script type="text/javascript" src="/assets/js/common.js"></script> -->
<!-- <script type="text/javascript" src="/assets/js/layout.js"></script> -->
<!--[if lt IE 9]>
<script type="text/javascript" src="/assets/js/html5shiv.min.js"></script>
<![endif]-->
  
<script type="text/javascript" src="/assets/js/jqueryAjax.js" charset='utf-8'></script>

<script type="text/javascript">
// 뒤로가기 막기
history.pushState(null, null, location.href);
window.onpopstate = function(event) {
	history.go(1);
};

$(document).ready(function(){
	
	$("#btnConfirm").click(function() {
		
		if($("input:checkbox[id='confirmChk']").is(":checked")) {
			
			var formData = fn_getFormData('#application_form');
			
			$.ajax({
				url         :   "agreeConfirm.do",
				dataType    :   "json",
				contentType :   "application/x-www-form-urlencoded; charset=UTF-8",
	            type        :   "post",
				data        :   formData,
				success     :   function(data){
		           	//alert(data.resultMsg);
		   			if ( data.result == 'success' ) {
		   				location.href = "eduUserEnd.do";
		   			}
				},
		        error       :   function(request, status, error) {
		        	alert( "시스템 오류입니다.\n전산담당자에게 문의해주세요." );
				}
			});
			
		} else {
			alert("동의에 체크 후, 확인버튼을 눌러주세요.");
			return false;
		}
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
<input type="hidden" id="emp_number" name="emp_number" value="${emp_number }" />

    <!-- 메뉴바 -->
    <jsp:include page="/userHeader.do" flush="true"></jsp:include>
    <!-- 메뉴바/ -->

    <!-- 가운데 잡아줌 -->

      <div class="layout-LW">
        <!-- 좌측 -->

        <div class="left" style="width:60%;">
          <!-- 1번표 -->
          
            <col style="width:100px" />
            <h2 class="subpage-tit"><spring:message code='label.eduUserAgree1'/></h2>
			<br />
			<div algin="center">${agree_title }</div>
            <div class="second_table4">
                <div class="txet_conteiner">
                    <p>${agree }</p>
                </div>
            </div>

            <div>
            	<br/>
           		<input type="checkbox" id="confirmChk" name="confirmChk" value="" />
           		<font><b><spring:message code='label.eduUserAgree2'/></b></font>    	           
           		            	
            	<img src="/images/sign/${signId}.gif" style="height:50px"/>
            	<a style="float: right;color: #fff;" class="button" id="btnConfirm"><i class="w_ok"></i>
            	<spring:message code='label.eduUserAgree3'/></a>
        	</div>
        </div>
        <!-- 가운데 잡아줌// -->

	</div>
</form>
</body>
</html>