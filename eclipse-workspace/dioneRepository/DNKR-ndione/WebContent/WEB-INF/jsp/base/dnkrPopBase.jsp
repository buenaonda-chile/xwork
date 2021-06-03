<%--
 * dnkrBase.jsp
 *
 * [EN] It is a JSP-based screen layout which is the lowest level of all.
 * [EN] As an example, we define a simple configuration layout (header, body, footer) of.
 * [EN] Depending on the requirements of each application, please use to define the layout.
 *
 * [JP] すべての画面レイアウトの最下層となるベースのJSPです。
 * [JP] サンプルとして、シンプル構成(ヘッダ、ボディ、フッタ)のレイアウトを定義しています。
 * [JP] 各アプリの要件に応じて、レイアウトを定義して利用してください。
 *
 * $ base.jsp 1753 2015-07-03 00:24:13Z 815372040074 $
 *
 * Copyright (c) 2012 DENSO CORPORATION. All rights reserved.
--%>

<%-- [EN] Variable definition -----------------------------------------------------%>
<%-- [JP] 変数定義 ----------------------------------------------------------------%>

<%-- for checking uploading file size --%>
<c:set var="maxFileSizeVar">
    <c:catch>
        <spring:message code="<%= Globals.MIYABI_CONSTANTS_KEY_FILEUPLOAD_MAXSIZE %>" />
    </c:catch>
</c:set>
    
<c:set var="tableWidth" scope="request">550px</c:set>


<%-- [EN] Screen drawing ----------------------------------------------------------------%>
<%-- [JP] 画面描画 ----------------------------------------------------------------%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<meta http-equiv="X-UA-Compatible" content="IE=Edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
		
		<%-- [EN] Title  --%>
        <%-- [JP] タイトル  --%>
		<title><spring:message code="label.system.name" /></title>
		
		<%-- CSS --%>
	    <!-- <link type="text/css" href="/js/lib/assets/css/docs.css" rel="stylesheet"> -->
        <!-- <link type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css" rel="stylesheet"> -->
        <link type="text/css" href="/css/font-awesome.min.css" rel="stylesheet">
        <link type="text/css" href="${pageContext.request.contextPath}/css/jquery-ui.min.css" rel="stylesheet" />
        <link type="text/css" href="/js/lib/axisj/ui/arongi/page.css" rel="stylesheet"/>
        <link type="text/css" href="/js/lib/axisj/ui/arongi/AXJ.min.css" rel="stylesheet">
        <link type="text/css" href="/js/lib/assets/lib/ax5ui-toast/dist/ax5toast.css" rel="stylesheet">
        <link type="text/css" href="/js/lib/assets/lib/ax5ui-mask/dist/ax5mask.css" rel="stylesheet"/>
        <link type="text/css" href="/js/lib/assets/lib/ax5ui-autocomplete/dist/ax5autocomplete.css" rel="stylesheet" >
        <link type="text/css" href="/js/lib/assets/lib/ax5ui-calendar/dist/ax5calendar.css" rel="stylesheet">
		<link type="text/css" href="/js/lib/assets/lib/ax5ui-picker/dist/ax5picker.css" rel="stylesheet">
		<link type="text/css" href="/js/lib/assets/lib/ax5ui-select/dist/ax5select.css" rel="stylesheet"> 
		<link type="text/css" href="/js/lib/assets/lib/ax5ui-menu/dist/ax5menu.css" rel="stylesheet">
        <link type="text/css" href="/js/lib/assets/lib/ax5ui-grid/dist/ax5grid.css" rel="stylesheet">
        <link type="text/css" href="/js/lib/axisj/axicon/axicon.min.css" rel="stylesheet">
        <link type="text/css" href="/css/jquery.mCustomScrollbar.css" rel="stylesheet" />
        <link media="all" href="/css/common.css" rel="stylesheet"/>
		<link media="all" href="/css/layout.css?ver=1" rel="stylesheet"/> 
		<link media="all" href="/css/main.css" rel="stylesheet"/>
		<link media="all" href="/css/board.css" rel="stylesheet" />
		<link media="all" href="/css/pop.css?ver=2" rel="stylesheet"/>
        
		<%-- JavaScript --%>
		<script type="text/javascript" src="/js/jquery-2.1.3.min.js"></script>
		<script type="text/javascript" src="/js/jquery.mCustomScrollbar.concat.min.js"></script>
		
		<%-- JavaScript (Library) --%>
		<script type="text/javascript" src="/js/lib/axisj/lib/AXConfig.js"></script>
		<script type="text/javascript" src="/js/lib/axisj/dist/AXJ.min.js"></script>
		<script type="text/javascript" src="/js/lib/axisj/lib/AXTab.js"></script>
		<script type="text/javascript" src="/js/lib/assets/js/docs.js"></script>
		<script type="text/javascript" src="/js/lib/assets/lib/bootstrap/dist/js/bootstrap.min.js"></script>
	    <script type="text/javascript" src="/js/lib/assets/lib/ax5core/dist/ax5core.min.js"></script>
		<script type="text/javascript" src="/js/lib/assets/lib/ax5ui-toast/dist/ax5toast.min.js"></script>	
		<script type="text/javascript" src="/js/lib/assets/lib/ax5ui-mask/dist/ax5mask.min.js"></script>
		<script type="text/javascript" src="/js/lib/assets/lib/ax5ui-autocomplete/dist/ax5autocomplete.min.js"></script>
		<script type="text/javascript" src="/js/lib/assets/lib/ax5ui-calendar/dist/ax5calendar.min.js"></script>
		<script type="text/javascript" src="/js/lib/assets/lib/ax5ui-picker/dist/ax5picker.min.js"></script>
		<script type="text/javascript" src="/js/lib/assets/lib/ax5ui-formatter/dist/ax5formatter.min.js"></script>
		<script type="text/javascript" src="/js/lib/assets/lib/ax5ui-select/dist/ax5select.min.js"></script>
		<script type="text/javascript" src="/js/lib/assets/lib/ax5ui-menu/dist/ax5menu.min.js"></script>
		<!-- <script type="text/javascript" src="/js/lib/assets/lib/ax5ui-grid/dist/ax5grid.min.js"></script> -->
		<script type="text/javascript" src="/js/lib/assets/lib/ax5ui-grid/dist/ax5grid.js"></script>
        <script type="text/javascript" src="/js/lib/ai-allbuttoninactivate_pl.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/fileUploadCheck.js"></script>
		
		<%-- JavaScript (Application Common) --%>
		<script type="text/javascript" src="/js/ai.js"></script>
		<script type="text/javascript" src="/js/common.js"></script>
		<script type="text/javascript" src="/js/common_const.js"></script>
		
	</head>

	<%-- [EN] Body area --%>
    <%-- [JP] ボディエリア --%>
	<tiles:insertAttribute name="body" flush="false" />

</html>