<%@ page import="com.fasterxml.jackson.databind.ObjectMapper" %>
<%@ page import="org.springframework.dao.DataAccessException" %>
<%@ page import="com.ibatis.sqlmap.engine.transaction.TransactionException" %>
<%@ page import="org.springframework.web.HttpSessionRequiredException" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="org.omg.CORBA.portable.ApplicationException" %>
<%@ page import="com.globaldenso.ai.core.exception.IntegrationLayerException" %>
<%@ page import="org.springframework.http.MediaType" %>
<%@ page import="org.springframework.web.multipart.MaxUploadSizeExceededException" %><%--
 * Project :
 *
 * [EN] System error screen
 * [JP] システムエラー画面
 *
 * $ error.jsp 2609 2016-09-08 04:14:01Z 10088DS00879 $
 *
 * Copyright (c) 2011 DENSO IT SOLUTIONS. All rights reserved.
--%>

<%@ page isErrorPage="true" %>

<%-- [EN] Custom tag dedicated Application Development Infrastructure --%>
<%-- [EN] Do not use this ai:aiErrorTag for your application without permission. --%>
<%-- [JP] アプリ基盤専用のカスタムタグ --%>
<%-- [JP] このai:aiErrorTagをアプリ側で勝手に利用しないで下さい。 --%>
<ai:aiErrorTag/>

<%
  boolean isAjax = "XMLHttpRequest".equals(request.getHeader("X-Requested-With"))
      || request.getHeader("Accept").contains(MediaType.APPLICATION_JSON_VALUE);

  if (isAjax) {
    response.setContentType("text/plain");
    Map<String, Object> retMap = new HashMap<>();

    response.setStatus(500);

    if (pageContext.getException() instanceof IntegrationLayerException) {
      retMap.put("message", pageContext.getException().getLocalizedMessage());
    } else if (pageContext.getException() instanceof HttpSessionRequiredException) {
      response.setStatus(403);
      retMap.put("message", "로그인 정보가 필요합니다");
    } else if (pageContext.getException() instanceof ApplicationException) {
      retMap.put("message", pageContext.getException().getMessage());
    } else if (pageContext.getException() instanceof MaxUploadSizeExceededException) {
      response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
      response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
      response.setDateHeader("Expires", 0); // Proxies.

      retMap.put("message", pageContext.getException().getMessage());
    } else {
      Throwable cause = pageContext.getException().getCause();
      if (cause == null) {
        retMap.put("message", "처리 중 오류가 발생하였습니다");
      } else if (cause instanceof ApplicationException) {
        retMap.put("message", cause.getMessage());
      } else if (cause instanceof Exception) {
        retMap.put("message", cause.getMessage());
      }
    }

    ObjectMapper objectMapper = new ObjectMapper();
    String strJson = objectMapper.writeValueAsString(retMap);

    response.getWriter().write(strJson);
  } else {
%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8"/>
  <meta http-equiv="X-UA-Compatible" content="IE=Edge"/>
  <meta http-equiv="Pragma" content="no-cache"/>
  <meta http-equiv="Cache-Control" content="no-cache, no-store"/>
  <meta http-equiv="Expires" content="-1"/>
  <title>Error Page</title>
</head>
<body>
<p>Status code : <c:out value="${STATUS_CODE}"/></p>
<p>Request URI : <c:out value="${REQUEST_URI}"/></p>
<p>Exception type : <c:out value="${EXCEPTION_TYPE}"/></p>
<p>Exception ID : <c:out value="${ID}"/></p>
<p>Exception code : <c:out value="${CODE}"/></p>
<p>Exception message : <c:out value="${ERROR_MESSAGE}"/></p>
<p>Date and time the exception occurred : <fmt:formatDate value="${DATE}"
                                                          pattern="yyyy-MM-dd HH:mm:ss.SSS"/></p>
</body>
</html>
<% } %>