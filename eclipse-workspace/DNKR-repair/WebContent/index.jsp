<%@ page import="org.springframework.mobile.device.Device" %>
<%@ page import="org.springframework.mobile.device.DeviceUtils" %>
<%@ page import="org.springframework.web.context.request.RequestContextHolder" %>
<%@ page import="org.springframework.web.context.request.ServletRequestAttributes" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2018-10-25
  Time: 오전 10:07
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Pragma"           content="no-cache" />
	<meta http-equiv="Cache-Control"    content="no-cache, no-store" />
	<meta http-equiv="Expires"          content="-1" />
		<%-- [EN] Title  --%>
		<%-- [JP] タイトル  --%>
		<title><spring:message code="title.dnkr" /> &gt; <spring:message code="title.dicas" /></title>
		<script type="text/javascript">
      document.location.href="<c:url value="/index"/>";
		</script>
	</head>
</html>
