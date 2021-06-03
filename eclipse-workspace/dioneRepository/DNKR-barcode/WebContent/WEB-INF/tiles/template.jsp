<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../view/include/taglib.jsp"%>
<%
	response.setHeader("Pragma", "no-cache"); 
	response.setHeader("Cache-Control", "no-cache"); 
	response.setDateHeader("Expires", 0); 
%>

<!DOCTYPE html>
<html lang="ko">
<head>
	<tiles:insertAttribute name="head" />
</head>
<body>
	<!-- s: header container -->
	<div id="header_container"> 
		<tiles:insertAttribute name="gnb" />
	</div>		
	<!-- e: header container -->

	<!-- body -->
	<!-- s: body container -->
	<div id="body_container">
		<div class="inner_content">
			<tiles:insertAttribute name="lnb" />
			<tiles:insertAttribute name="body" />
		</div>
	</div>
	<!--// body -->
	
	<!-- footer -->
	<div id="footer">
		<tiles:insertAttribute name="footer" />
	</div>
	<!--// footer -->

</body>
</html>