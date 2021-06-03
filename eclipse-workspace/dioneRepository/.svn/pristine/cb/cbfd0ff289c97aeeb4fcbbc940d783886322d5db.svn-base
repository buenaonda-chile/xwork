<%--
 * dnkrLogin.jsp
 *
 * [EN] It is a JSP-based screen layout which is the lowest level of all.
 * [EN] As an example, we define a simple configuration layout (header, body, footer) of.
 * [EN] Depending on the requirements of each application, please use to define the layout.
 *
 * [JP] すべての画面レイアウトの最下層となるベースのJSPです。
 * [JP] サンプルとして、シンプル構成(ヘッダ、ボディ、フッタ)のレイアウトを定義しています。
 * [JP] 各アプリの要件に応じて、レイアウトを定義して利用してください。
 *
 * $ dnkrLogin.jsp 
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
		<link rel="stylesheet" media="all" href="/css/common.css"/>
		<link rel="stylesheet" media="all" href="/css/login.css"/>
		
		<script type="text/javascript" src="/js/jquery-1.11.3.min.js"></script>
		<script src="/js/jquery.mCustomScrollbar.concat.min.js"></script>
		
		<script type="text/javascript" src="/js/login.js"></script>

	</head>

	<%-- [EN] Body area --%>
    <%-- [JP] ボディエリア --%>
    <body>
	<tiles:insertAttribute name="body" flush="false" />
	</body>
</html>