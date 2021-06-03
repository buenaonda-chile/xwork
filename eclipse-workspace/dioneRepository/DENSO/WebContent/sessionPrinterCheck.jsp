<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<TITLE></TITLE>
<meta http-equiv="Content-Type" content="text/html">
<script language="javascript" src="${cp}/common/js/jquery-1.4.1.js"></script>
<link rel="stylesheet" href="./image/style.css" type="text/css">
<script language="JavaScript" type="text/javascript">


	var prtParam1 = <%= request.getParameter("PrtSetup1") %>; 
	var prtParam2 = <%= request.getParameter("PrtSetup2") %>; 
	var sessionCnt = <%= request.getParameter("SessionCnt") %>; 
	var setupTF=true;

	var execPrtSessionX86="C:\\Program Files\\WeveTec\\Max5250\\TS400Printer.exe";	//32bit
	var execPrtSessionX64="C:\\Program Files (x86)\\WeveTec\\Max5250\\TS400Printer.exe";	//64bit
	var osVersion  = navigator.userAgent;	//OS버전체크
	var agentUserOs= osVersion.replace(/ /g,'');
	var execName="";	//실행파일
	
	function runFileCheck(){
		var rlt = true;				
		execName="";	//실행파일

		try {
			var WshShell = new ActiveXObject("WScript.Shell");
		} catch (e) {
			// TODO: handle exception
			rlt = false;
			alert("1)인터넷옵션>보안>>신뢰할수 있는 사이트에  등록 \n"+
			     "2)인터넷옵션>보안>인터넷>사용자지정수준>스크립팅하기 안전하지 않은 것으로 표시된 ActiveX 컨트롤 초기화를 '사용'으로 수정하셔야 정상작동 합니다.");
		}
		if(rlt != false){	//ActiveX가 정상동작일 때만 동작
			var fileTF = new ActiveXObject("Scripting.FileSystemObject");
			//execName = execPrtSession;
			//OS bit체크
			if(agentUserOs.indexOf("WOW64") != -1){
				//alert("WOW64");
				execName = execPrtSessionX64;
			}else{
				//alert("on x86");
				execName = execPrtSessionX86;
			} 
			var writeHtml="";
			
			if(!fileTF.FileExists(execName)){
				alert("[알림]MAX5250이 설치되지 않았습니다.");
				writeHtml += '<strong><font color="#FF7200"><a href="${cp}/miInstallU/MsiMsp/Max5250Setup.exe">1. Max5250 수동설치  </a><br>';
				writeHtml += '<strong><font color="#FF7200">수동설치 후 아래 두가지를 수정해야 정상작동 합니다.<br>';
				writeHtml += '<strong><font color="#FF7200">1)인터넷옵션>보안>>신뢰할수 있는 사이트에  http://dione.dnke.kr 등록<br>';
				writeHtml += '<strong><font color="#FF7200">2)인터넷옵션>보안>인터넷>사용자지정수준>스크립팅하기 안전하지 않은 것으로 표시된 ActiveX 컨트롤 초기화를 [사용]으로  변경<br>';
				writeHtml += '<strong><font color="#FF7200">설치 및 설정이  완료되면 [F5] 키를 눌러 새로고침 하시거나, 브라우저를 닫은 후 다시 접속하여 주시기 바랍니다.';
				document.getElementById('infoConents').innerHTML = writeHtml;					
				rlt = false;
			}	
		}
		return rlt;
	}	
	function fn_OnLoad()
	{
		//MiPlatform_InstallEngine320U 설치여부 확인
		var setupTF=runFileCheck();
		if(setupTF==false){
			return;
		}
		//alert("PGM설치 : OK");
		fn_run();
	}

	function fn_run()
	{
		var excShell = new ActiveXObject("Shell.Application");
		
		for(i=1; i <=sessionCnt; i++){
			var prtParam="";
				prtParam = prtParam1;
			if(i==1){
				prtParam = prtParam1;
			}else{
				prtParam = prtParam2;
			}
			prtParam+="#"+i
			excShell.ShellExecute(execName, " "+prtParam, "", "open", "1");
		} 			
		setTimeout(function() {
			window.close();  
		}, 500); 	//0.5초이후에 창 닫힘.
	}

</script>

</HEAD>
<BODY leftmargin="0" topmargin="0" onload="fn_OnLoad()">
<div id=infoConents>
	<br>연결중입니다.<br>
</div>
</BODY>
	
</HTML>

