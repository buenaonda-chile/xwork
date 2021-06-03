<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<c:set var="serverAddr" value="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/"/>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<TITLE></TITLE>
<meta http-equiv="Content-Type" content="text/html">
<script language="javascript" src="${cp}/common/js/jquery-1.4.1.js"></script>
<link rel="stylesheet" href="./image/style.css" type="text/css">

<SCRIPT LANGUAGE="JavaScript" src="./common/js/miInstall.js"></SCRIPT>

<script language="JavaScript" type="text/javascript">
	
	var empNo = <%= request.getParameter("empID") %>; 
	var company = <%= request.getParameter("empComps")%>; 
 	var plantCd = <%= request.getParameter("empPlace")%>;
 	
 	var sessionID = <%= request.getParameter("sysID")%>;
 	var sessionPW = <%= request.getParameter("sysPW")%>;
 	var sessionGroup = <%= request.getParameter("sysGroup")%>;
 	var p_Param = "::"+empNo+"::"+company+"::"+plantCd+"::"+sessionID+"::"+sessionPW+"::"+sessionGroup;
 	
	function fn_OnLoad()
	{

		MiInstaller.Key = "Session1";
		MiInstaller.Launch = true;	
		MiInstaller.Width  = 800;//세션해상도
		MiInstaller.Height	= 535;//세션해상도
		MiInstaller.Retry = 1;
		MiInstaller.Timeout = 300;
		//MiInstaller.GlobalVal = "";
		MiInstaller.GlobalVal = p_Param; // 파라미터 전달 시 필요(사용자 ID/PW, ...)
		//alert(MiInstaller.GlobalVal);
		MiInstaller.OnlyOne = true;
		//MiInstaller.StartXml  = "http://10.74.227.115/ui/newDione_Session1_Win32.xml";	//개발환경
		//MiInstaller.StartXml  = "http://dione.dnke.kr/ui/newDione_Session1_Win32.xml";	//서버환경
		//MiInstaller.StartXml  = "http://10.74.227.115/ui/newDione_NewSession1_Win32.xml";	//서버환경
		MiInstaller.StartXml  = "http://dione.dnke.kr/ui/newDione_NewSession1_Win32.xml";	//서버환경

		MiInstaller.Resource = "";	
		MiInstaller.StartImage  = "";

		fn_run();
	}
	function fn_run()
	{
		MiInstaller.run();
		opener = self;  
		CloseWnd(); // 익스플로어 7 이상 종료 함수
	}
	function CloseWnd()
	{
	  window.opener = 'nothing';
	  window.open('','_parent','');
	  window.close();
	}

</SCRIPT>

</HEAD>
<BODY leftmargin="0" topmargin="0" onload="fn_OnLoad()">

<SCRIPT LANGUAGE="JavaScript">
	CreateMiInstlr("MiInstaller","Win32U","3.2","denso");
</SCRIPT>
</BODY>
</HTML>

