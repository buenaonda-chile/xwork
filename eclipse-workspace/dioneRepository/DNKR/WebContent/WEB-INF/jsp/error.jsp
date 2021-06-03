<!DOCTYPE html>
<%--
 * error.jsp
 *
 * [JP] システムエラー画面
 * [EN] System error screen
 *
 * $ error.jsp 1753 2015-07-03 00:24:13Z 815372040074 $
 *
 * Copyright (c) 2011 DENSO IT SOLUTIONS. All rights reserved.
--%>

<%@page isErrorPage="true" %>
<%-- [JP] アプリ基盤専用のカスタムタグ --%>
<%-- [EN] Custom tag dedicated Application Development Infrastructure --%>
<%-- [JP] このai:aiErrorTagをアプリ側で勝手に利用しないで下さい。 --%>
<%-- [EN] Do not use this ai:aiErrorTag for your application without permission. --%>
<%@ taglib prefix="ai" uri="http://ai.globaldenso.com/customTag" %>
<ai:aiErrorTag />

<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=Edge" />
    <meta http-equiv="Content-Type"  content="text/html; charset=${pageContext.request.characterEncoding}" />
    <title>Error Page</title>
</head>
<body>
    <p>Status code : ${STATUS_CODE}</p>
    <p>Request URI : ${REQUEST_URI}</p>
    <p>Exception type : ${EXCEPTION_TYPE}</p>
    <p>Exception ID : ${ID}</p>
    <p>Exception code : ${CODE}</p>
    <p>Exception message : ${ERROR_MESSAGE}</p>
    <p>Date and time the exception occurred : <fmt:formatDate value="${DATE}" pattern="yyyy-MM-dd HH:mm:ss.SSS"/></p>
</body>
</html>
