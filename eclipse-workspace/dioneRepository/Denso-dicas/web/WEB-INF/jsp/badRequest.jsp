<%--
 * Project : 
 *
 * [EN] Bad request screen
 * [JP] リクエスト不正画面
 *
 * $ badRequest.jsp 2609 2016-09-08 04:14:01Z 10088DS00879 $
 *
 * Copyright (c) 2015 DENSO IT SOLUTIONS. All rights reserved.
--%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible"  content="IE=Edge" />
    <meta http-equiv="Pragma"           content="no-cache" />
    <meta http-equiv="Cache-Control"    content="no-cache, no-store" />
    <meta http-equiv="Expires"          content="-1" />
    <title>Bad Request Page</title>
</head>
<body>
    <%-- ERROR Message --%>
    <%-- Please configure message. --%>
    <spring:message code="label.xxx" />
</body>
</html>