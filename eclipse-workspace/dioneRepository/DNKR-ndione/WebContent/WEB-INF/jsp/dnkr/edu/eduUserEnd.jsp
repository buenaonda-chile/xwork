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

<script type="text/javascript" src="/assets/js/jquery-2.1.3.min.js"></script>
<script type="text/javascript">
//뒤로가기 막기
history.pushState(null, null, location.href);
window.onpopstate = function(event) {
	history.go(1);
};


$(document).ready(function(){
	$("#btnEnd").click(function() {
		window.close();
	});
});
</script>

<style>

body {
	text-shadow: none;
}

</style>

</head>
<body>
    
    <!-- 메뉴바 -->
    <jsp:include page="/userHeader.do" flush="true"></jsp:include>
    <!-- 메뉴바/ -->

    <!-- 가운데 잡아줌 -->

      <div class="layout-LW">
        <!-- 좌측 -->

        <div class="left" style="width:60%;">
          <!-- 1번표 -->
          
            <col style="width:100px" /><col />
            <h2 class="subpage-tit"><spring:message code='label.eduUserEnd1'/></h2>

            <div class="second_table5">
                    <div class="celebration">
                        <div class="wepper">
                            <div class="celebration_text">
                            <p><spring:message code='label.eduUserEnd2'/></p>
                            <p><spring:message code='label.eduUserEnd3'/></p>
                            </div>
                        </div>
                </div>
            </div>

            <div class="checkbox_center">
            <a style="float: right;color: #fff;" class="button" id="btnEnd"><i class="w_ok"></i><spring:message code='label.eduUserEnd4'/></a>
        </div>
        </div>
        <!-- 가운데 잡아줌// -->

        </div>
</body>
</html>