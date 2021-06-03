<%--
 * base.jsp
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

<%-- [EN] Table width (used by jquery.tablefix_1.0.1.js) --%>
<%-- [JP] テーブル幅 (jquery.tablefix_1.0.1.js から利用) --%>
<c:choose>
    <c:when test="${type == 'menu' || type == 'main'}">
        <c:set var="tableWidth" scope="request">980px</c:set>
    </c:when>
    <c:otherwise>
        <c:set var="tableWidth" scope="request">100%</c:set>
    </c:otherwise>
</c:choose>

<%-- [EN] Screen drawing ----------------------------------------------------------------%>
<%-- [JP] 画面描画 ----------------------------------------------------------------%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible"  content="IE=Edge" />
        <meta http-equiv="pragma"           content="no-cache" />
        <meta http-equiv="cache-control"    content="no-cache" />
        <meta http-equiv="Content-Type"     content="text/html; charset=${pageContext.request.characterEncoding}" />

        <%-- [EN] Title  --%>
        <%-- [JP] タイトル  --%>
        <title>DNKR 시스템</title>

        <%-- CSS --%>
        <%-- We do not use bootstrap-theme.css in ai_sample --%>
        <link type="text/css" href="${pageContext.request.contextPath}/css/sample.css" rel="stylesheet" />
        <link type="text/css" href="${pageContext.request.contextPath}/css/messageArea.css" rel="stylesheet" />
        <link type="text/css" href="${pageContext.request.contextPath}/css/ai-paging_pl.css" rel="stylesheet" />
        <link type="text/css" href="${pageContext.request.contextPath}/css/jquery-ui.min.css" rel="stylesheet" />
        <link type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" />
        <link type="text/css" href="${pageContext.request.contextPath}/css/font-awesome.css" rel="stylesheet" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/axisj-1.1.11/ui/arongi/AXJ.min.css" />
		
        <%-- JavaScript --%>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.3.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/fileUploadCheck.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/warningDialog.js"></script>

        <%-- JavaScript (Application Common) --%>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/ai.js"></script>
        
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/axisj-1.1.11/dist/AXJ.min.js"></script>
        
		
    </head>

    <%-- [EN] Body area --%>
    <%-- [JP] ボディエリア --%>
    <tiles:insertAttribute name="body" flush="false" />

</html>