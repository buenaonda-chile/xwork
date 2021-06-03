<%--
 * Project :
 *
 * [EN] It is a JSP-based screen layout which is the lowest level of all.
 * [EN] As an example, we define a simple configuration layout (header, body, footer) of.
 * [EN] Depending on the requirements of each application, please use to define the layout.
 *
 * [JP] すべての画面レイアウトの最下層となるベースのJSPです。
 * [JP] サンプルとして、シンプル構成(ヘッダ、ボディ、フッタ)のレイアウトを定義しています。
 * [JP] 各アプリの要件に応じて、レイアウトを定義して利用してください。
 *
 * $ base.jsp 2516 2016-07-22 02:08:12Z 10088DS00879 $
 *
 * Copyright (c) 2015 DENSO IT SOLUTIONS. All rights reserved.
--%>

<%-- [EN] Variable definition --%>
<%-- [JP] 変数定義 --%>
<tilesx:useAttribute id="tileNm"  name="tileNm" ignore="true" classname="java.lang.String" />

<%-- [EN] Screen drawing --%>
<%-- [JP] 画面描画 --%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8"/>
  <meta http-equiv="X-UA-Compatible" content="IE=Edge"/>
  <meta http-equiv="Pragma" content="no-cache"/>
  <meta http-equiv="Cache-Control" content="no-cache, no-store"/>
  <meta http-equiv="Expires" content="-1"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <meta name="author" content="DENSO DICAS" />
  <meta name="keywords" content="DENSO DICAS" />
  <meta name="description" content="DENSO DICAS" />

  <%-- [EN] Title  --%>
  <%-- [JP] タイトル  --%>
  <title><spring:message code="title.dnkr" /> &gt; <spring:message code="title.login" /></title>

	<c:choose>
    <c:when test="${tileNm != 'mobile'}">
      <%-- CSS --%>
      <link type="text/css" href="<c:url value="/assets/css/messageArea.css"/>" rel="stylesheet"/>
      <link type="text/css" href="<c:url value="/assets/css/common.css"/>" rel="stylesheet"/>
      <link type="text/css" href="<c:url value="/assets/css/login.css"/>" rel="stylesheet"/>
      <%--// CSS --%>

      <%-- JavaScript --%>
      <script type="text/javascript" src="<c:url value="/assets/js/jquery-2.1.3.min.js"/>"></script>
      <script type="text/javascript" src="<c:url value="/assets/js/warningDialog.js"/>"></script>
      <%--// JavaScript --%>

    </c:when>
		<c:otherwise>
      <%-- CSS --%>
      <link type="text/css" rel="stylesheet" href="<c:url value="/assets/mobile/css/define/jquery-ui.css"/>" />
      <link type="text/css" rel="stylesheet" href="<c:url value="/assets/mobile/css/font.css"/>" />
      <link type="text/css" rel="stylesheet" href="<c:url value="/assets/mobile/css/lib.css"/>" />
      <link type="text/css" rel="stylesheet" href="<c:url value="/assets/mobile/css/login.css"/>" />
      <%--// CSS --%>
      <%-- JavaScript --%>
			<script type="text/javascript" src="<c:url value="/assets/mobile/js/define/jquery-1.12.4.min.js"/>"></script>
      <script type="text/javascript" src="<c:url value="/assets/mobile/js/define/jquery.easing.1.3.js"/>"></script>
      <script type="text/javascript" src="<c:url value="/assets/mobile/js/define/jquery-ui.js"/>"></script>
      <script type="text/javascript" src="<c:url value="/assets/mobile/js/lib_fnc.js"/>"></script>
      <script type="text/javascript" src="<c:url value="/assets/mobile/js/lib.js"/>"></script>
      <%--// JavaScript --%>

    </c:otherwise>
  </c:choose>

</head>
<body>
<%-- [EN] (Including the message area) header area --%>
<%-- [JP] ヘッダエリア(メッセージエリア含む) --%>
<tiles:insertAttribute name="header" flush="false"/>

<%-- [EN] Contents area --%>
<%-- [JP] コンテンツエリア --%>
<tiles:insertAttribute name="body" flush="false"/>

<%-- [EN] Footer --%>
<%-- [JP] フッタ --%>
<c:if test="${tileNm != 'mobile'}">
  <tiles:insertAttribute name="footer" flush="false"/>
</c:if>
</body>
</html>