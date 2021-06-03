<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<TITLE></TITLE>
<meta http-equiv="Content-Type" content="text/html">
<link rel="stylesheet" href="./image/style.css" type="text/css">


<SCRIPT LANGUAGE="JavaScript" src="./common/js/miInstall.js"></SCRIPT>

<script language="JavaScript" type="text/javascript">
	var empNo = <%= request.getParameter("EmpNo") %>; 
	var company = <%= request.getParameter("Company")%>; 
 	var plantCd = <%= request.getParameter("PlantCd")%>; 
 	var p_Param = "::"+empNo+":: "+"::"+company+"::"+plantCd;
 	var setupTF1=true;

	var TotalVersionFileCnt;
	var TotalItemCnt;
	var progressColor = "red";	// set to progress bar color
	var pg_cell_At = 0,pg1_cell_At = 0; 
	var IsError = false;
	var proMsg, procMsg;

	function fn_OnLoad()
	{

		//MiPlatform_Updater321.cab설치여부 확인	
		/*
		var InstallTF=check("Updater321", "Cy_MiInstaller3.CyMiInstaller321");
		if(InstallTF==false){
			alert("[알림]Updater321이 설치되지 않았습니다.");
			document.write('<strong><font color="#FF7200"><a href="${cp}/miInstallU/MiPlatform_Updater321.cab">Updater321 수동설치');  			
			return;
		}
		*/
		//Max5250설치여부 확인	
/*		
		var InstallTF=check("MAX5250", "WTA_RemoteCall.WT_RemoteCall");
		if(InstallTF==false){
			alert("[알림]MAX5250이 설치되지 않았습니다.");
			document.write('<strong><font color="#FF7200"><a href="${cp}/miInstallU/MsiMsp/Max5250Setup.exe">Max5250 수동설치');  			
			return;
		}
		if(setupTF1==false){
			return;
		}
*/		
		//alert(p_Param);
		MiInstaller.Key = "Session";
		MiInstaller.Launch = true;	
		MiInstaller.Width  = 800;//세션해상도
		MiInstaller.Height	= 535;//세션해상도
		MiInstaller.Retry = 1;
		MiInstaller.Timeout = 300;
		//MiInstaller.GlobalVal = "";
		MiInstaller.GlobalVal = p_Param; // 파라미터 전달 시 필요(사용자 ID/PW, ...)
		//alert(MiInstaller.GlobalVal);
		MiInstaller.OnlyOne = true;
		//MiInstaller.StartXml  = "http://10.74.227.115/ui/newDione_ci_main_Win32.xml";	//개발환경
		//MiInstaller.StartXml  = "http://10.73.206.44/DENSO/ui/newDione_ci_main_Win32.xml";	//TEST서버
		MiInstaller.StartXml  = "http://10.73.254.21/ui/newDione_ci_main_Win32.xml";	//실서버
		//MiInstaller.StartXml  = "http://10.73.254.21/ui/Group1/NewSESSION.xml";
		//MiInstaller.StartXml  = "http://10.73.254.21/ui/denso_m_ci_main_Win32.xml";
		//MiInstaller.StartXml  = "${serverAddr}${cp}/ui/denso_ci_main_Win32.xml";
		MiInstaller.InitUrl = "Group1::NewSESSION";
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
	function activex_error(msg) {
		 alert(msg+"이 설치가 되지 않았습니다");
		 setupTF1=false;
		 //return;
	} 
	//ActiveX가 활성화 되어 있어야 사용가능함.
	function check(name, progid){
alert(progid);
		var installed;
        try {
			var axObj = new ActiveXObject(progid);
alert("try="+name+axObj);
			if(axObj){
				installed = true;
			} else {
				installed = false;
 			}
        } catch (e) {
alert("catch="+name+axObj);
			alert("도구 > 인터넷 옵션 > 보안 > 사용자 지정 수준 클릭>스크립팅하기 안전하지 않은 것으로 표시된 ActiveX컨트롤 초기화 및 스크립팅을 확인으로 변경하세요!\n");
			installed = false;
        }
        return installed;
	}
</SCRIPT>

</HEAD>

<BODY leftmargin="0" topmargin="0" onload="fn_OnLoad()">
<br>연결중입니다.<br>


<SCRIPT LANGUAGE="JavaScript">
	CreateMiInstlr("MiInstaller","Win32U","3.2","denso");
	/*
	var strID="MiInstaller";
	var Device="Win32U";
	var Version="3.2";
	var Key="denso";
	*/
<%--
	document.write('<OBJECT ID="'+strID+'" CLASSID="CLSID:1A000B1F-B285-4fbf-B3CD-B50845003EBB" ' +
            '    CodeBase="${cp}/MiinstallU/MiPlatform_Updater321.cab#VERSION=2013.5.31.1" width=0 height=0 SHOWASTEXT> ' +
            '    <param name="Version"       value="3.2"> ' +
            '    <param name="DeviceType"    value="'+Device+'"> ' +
            '    <param name="Key"           value="'+Key+'"> ' +
           '</OBJECT> ');
--%>

</SCRIPT>
</BODY>

<%-- MiPlatform_SetupUpdater321.exe class ID  --%>
<%--
	<object id="MiUpdater" classid="clsid:8F0B18AE-8177-4C20-A2AC-DBD2416E1ED8"
	 codebase="${cp}/miInstallU/MiPlatform_SetupUpdater321.exe#version=3.21.700" onError="activex_error('Updater321');"> </object>
%-->	 
<%-- MiPlatform_InstallEngine320U.msi class ID --%>
<%--
	<object id="InstallEngine" classid="clsid:65673658-248C-49AC-9EC4-25682074A312"
	 codebase="${cp}/miInstallU/MsiMsp/MiPlatform_InstallEngine320U.msi#version=3.20.750" onError="activex_error('InstallEngine');"> </object>
--%>
<%-- 8CADBCAE-169D-4E19-93AC-9C0545DF38FB --%>

<%-- Max5250Setup.exe class ID 
	<object id="Max5250" classid="clsid:47A2ECE9-948E-46D3-B6E1-7D7DC7D84158" 
	 codebase="${cp}/miInstallU/MsiMsp/Max5250Setup.exe" onError="activex_error('Max5250');"> </object>
---%>
<%--
 WTA_Remotecall : clsid:47A2ECE9-948E-46D3-B6E1-7D7DC7D84158
 WTC_IBM5555 : clsid:EFC3E24D-AFE1-41F9-A3D7-6013F699177D
--%>

</HTML>

