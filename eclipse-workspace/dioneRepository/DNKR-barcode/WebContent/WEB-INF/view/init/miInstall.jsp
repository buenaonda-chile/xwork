<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="serverAddr" value="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/"/>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<%--
 pgm password를 ad로그인password로 사용 
<c:set var="globalVal" value="${pageContext.session.id}::${sessionScope.userInfo.USER_ID}::${sessionScope.userInfo.USER_NAME}::${sessionScope.userInfo.COMPANY}::${sessionScope.userInfo.PLANT_CD}::${sessionScope.userInfo.PASSWORD}::${sessionScope.userInfo.EMAIL_ID}::${sessionScope.userInfo.LIB1}::${sessionScope.userInfo.LIB2}::${sessionScope.userInfo.LIB3}::${sessionScope.userInfo.MENU_PW}"/>
--%>
<c:set var="globalVal" value="${pageContext.session.id}::${sessionScope.userInfo.USER_ID}::${sessionScope.userInfo.USER_NAME}::${sessionScope.userInfo.COMPANY}::${sessionScope.userInfo.PLANT_CD}::${sessionScope.userInfo.PASSWORD}::${sessionScope.userInfo.EMAIL_ID}::${sessionScope.userInfo.LIB1}::${sessionScope.userInfo.LIB2}::${sessionScope.userInfo.LIB3}::${sessionScope.userInfo.LDAPPASS}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DensoKorea</title>
<SCRIPT LANGUAGE="JavaScript" src="<c:url value="/resources/static/js/miInstall.js"/>"></SCRIPT>
<SCRIPT language="vbscript">

</SCRIPT>

<SCRIPT LANGUAGE="JavaScript">
	var TotalVersionFileCnt;
	var TotalItemCnt;
	var progressColor = "red";	// set to progress bar color
	var pg_cell_At = 0;
	var pg1_cell_At = 0;
	var IsError = false;
	var proMsg;
	var procMsg;

	// cookie delete
	function deleteCookie( cookieName )
	{
	 var expireDate = new Date();
	 
	 //어제 날짜를 쿠키 소멸 날짜로 설정한다.
	 expireDate.setDate( expireDate.getDate() - 1 );
	 document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString() + "; path=/";
	}

	deleteCookie("pwfcCount");

	/* modify date : 20171219  */
	// 별도의 자바스립트생성시 파일다운로드 html화면 생성안됨.
	function fnCheckModule()
	{
		try
		{
			if(MiInstaller.Version == undefined)
				return false; // 설치가 안되어 있거나 system32에 MiInstlr321.dll 이 없는 경우.(unregistered 된 경우)
			else
				return true;
		}
		catch(ex)
		{	// MiInstaller.js 가 올라오지 못해서 object를 사용할 수 없는 경우 
			return false;
		}
	}
	
	function fnOnLoad() {
	
		// MiInstaller사용 시 Object tag 에서 Param으로 Version과 Key 입력		
		if(fnCheckModule()==true) {
		//if(fnCheckModule()=="TRUE") {

			var tmp_len = progress.offsetWidth; // span
			var tmp_tot_len = pg.offsetWidth; // div

			fnPgCellInit(tmp_len, pg, "progress", tmp_tot_len);
			fnPgCellInit(tmp_len, pg1, "progress1", tmp_tot_len);

			//MiInstaller.Key = "denso";
			MiInstaller.Key = "DensoKorea";
			//MiInstaller.DeviceType = "win32";
			MiInstaller.Launch = true;
			MiInstaller.Width  = 1280;
			MiInstaller.Height	= 768;
			MiInstaller.Retry = 0;
			MiInstaller.Timeout = 300;
			MiInstaller.GlobalVal = "${globalVal}"; // 파라미터 전달 시 필요(사용자 ID/PW, ...)
			MiInstaller.OnlyOne = true;
			//MiInstaller.OnlyOne = false;
			//MiInstaller.ComponentPath = "%component%"; // 2007.04.27 기본 컴포너트 경로 사용 테스트
			//MiInstaller.ComponentPath = "%UserApp%kt\\denso\\component";
			MiInstaller.ComponentPath = "%UserApp%\\denso\\component";
			
			//MiInstaller.StartXml  = "${serverAddr}${cp}/ui/denso_ci_main_Win32.xml";
			MiInstaller.StartXml  = "${serverAddr}${cp}/ui/denso_ci_main2_Win32.xml";


			MiInstaller.StartImage  = "null";
			//MiInstaller.StartImage  = "%component%next_start.gif";
			//MiInstaller.Resource = "%component%resource.xml";

			//if(checkOS()=="VISTA" && !MiInstaller.IsUACEnabled()) {	//WIN10인 경우 UAC가 TRUE로 리턴되어 사용불가.
			if(checkOS()=="VISTA") {
				MiInstaller.UpdateURL = "${serverAddr}${cp}/miInstallU/MiUpdate320UUAC.xml";

			} else {
				MiInstaller.UpdateURL = "${serverAddr}${cp}/miInstallU/MiUpdate320U.xml";
			}


			var Bcnt = MiInstaller.ExistVersionUpCnt();
						
			if(Bcnt) {

				MiInstaller.StartDownload();

			} else {

				fnRun();
			}
		}
	}


	function fnCreateIcon() {

		// 단축 아이콘 만들기
		// UBKImage : 250 * 300

		// BYTE가 256을 넘으면 안됨..
		// 256을 넘을 경우 MiInstaller의 property를 이용할 것!

		//var strCommand = '-V 3.2 -D Win32 -R FALSE -K eKins -L TRUE -U ${cp}/miInstall/MiUpdate320A.xml -X ${cp}/ui/eKins_ci_main_Win32.xml';
		//var strCommand = '-V 3.2 -D Win32 -R FALSE -K eKins -L TRUE -LE TRUE -BI "%component%next_upd.gif" ';
		//MiInstaller.MakeShortCut("%system%MiUpdater320U.exe", strCommand, "eKins", "%Component%icon_next.ico", "");
		//var strCommand = '-V 3.2 -D Win32 -R FALSE -K eKins -L TRUE -LE TRUE -BI %component%next_upd.gif';

		var strCommand;

		//MiInstaller.Key = "denso";
		MiInstaller.Key = "DensoKorea";
		MiInstaller.Launch = true;
		MiInstaller.Width  = 1280;
		MiInstaller.Height	= 768;
		MiInstaller.Retry = 0;
		MiInstaller.Timeout = 300;
		MiInstaller.GlobalVal = "${globalVal}"; // 파라미터 전달 시 필요(사용자 ID/PW, ...)
		MiInstaller.OnlyOne = false;
		//MiInstaller.ComponentPath = "%UserApp%kt\\denso\\component";
		MiInstaller.ComponentPath = "%UserApp%\\denso\\component";
		//MiInstaller.StartXml  = '<c:url value="/ui/denso_ci_main_Win32.xml"/>';
		MiInstaller.StartXml  = '<c:url value="/ui/denso_ci_main2_Win32.xml"/>';
		MiInstaller.StartImage  = "null";
		
		MiInstaller.UpdateURL = '<c:url value="/miInstallU/MiUpdate320U.xml"/>';	
		MiInstaller.Resource = "%component%resource.xml";
		
		strCommand = "-V 3.2 -D Win32U -R FALSE -K DensoKorea -L TRUE ";
		
		MiInstaller.MakeShortCut("%system%MiUpdater321.exe", strCommand, "DensoKorea", "%Component%icon128.ico", "desktop");
	
		// MakeShortCut 바로가기를 만드는 함수
		// strExeName: 바로가기를 만들 실행 파일 이름
		// strCommand: 바로가기를 만들 때 필요한 Command 정보
		// strShortcutName: 바로가기 파일 이름
		// strIConPath: 변경하려는 Icon 경로를 %alias%형태로 입력할 수 있습니다.
		// strPos: Startmenu-시작 / Desktop-바탕화면(Default)

		// Alias 참고
		// %MiPlatform%
		// %Component%
		// %system%
		// %Window%
		// %ProgramFiles%
	}

	var chkFlag = false;
	function fnRun()
	{
		if(chkFlag) return;			
		else chkFlag = true;
		
		if(IsError) return;
				
		MiInstaller.run(); 			// Application 실행!
		
		opener = self;
		CloseWnd(); 				// 익스플로어 7 이상 종료 함수

	}
	 function CloseWnd()
	 {
	  window.opener = 'nothing';
	  window.open('','_parent','');
	  window.close();
	 }

	function fnPgCellInit(icell_width,obj,cell_id_nm,tot_len) { // pg_cell_init

		var inum = 0;
		var ins_cell_str = "";

		while ( inum <= tot_len ) {

			inum += icell_width*2;
			ins_cell_str += '<span id="' + cell_id_nm + '">&nbsp;</span><span>&nbsp;</span>';
		}

		obj.innerHTML = ins_cell_str;
	}

	function fnProgressClear(obj) { // progress_clear

		for (var i=0; i<obj.length; i++) {

			obj[i].style.backgroundColor = 'transparent';
		}
	}
	
	function fnProgressUpdate(obj,cur_cnt) { // progress_update

		if (cur_cnt>=obj.length) {

			cur_cnt = obj.length - 1;
		}

		obj[cur_cnt].style.backgroundColor = progressColor;
	}
</SCRIPT>


<SCRIPT language=JavaScript for=MiInstaller event=OnConfirm(ItemName)>
{
	var a = "OnConfirm=>Item=";

	a += ItemName;

	//alert(a);
}
</SCRIPT>


<SCRIPT language=JavaScript for=MiInstaller event=OnStartDownLoad(VersionFileName,DownFileName,Type,TotalCnt,CurIndex)>
{
	
	if(Type==1) // EVENTCONFIG
	{
		fnProgressClear(progress);
	}
	else if(Type==2) // EVENTGETVERSIONCNT
	{
		ins_tbl.className = "show";
		reinstall.className = "show";
		fnProgressClear(progress1);
		pg1_cell_At = 0;
	}
	else if(Type==3) // EVENTDOWNLOAD
	{
		item_nm.innerHTML = "&nbsp;" + DownFileName;
		prc_msg.innerHTML = "&nbsp;파일 다운로드 중....";
	}
	else if(Type==4) // EVENTDISTRIBUTE
	{
		prc_msg.innerHTML = "&nbsp;실제 경로 배포 중....";
	}	
}
</SCRIPT>

<!--ItemSize는 미지정 -->
<SCRIPT language=JavaScript for=MiInstaller event=OnEndDownLoad(VersionFileName,DownFileName,Type,TotalCnt,CurIndex)>
{
	if(Type==1) // EVENTCONFIG
	{
		fnRun();
	}
	else if(Type==2) // EVENTGETVERSIONCNT
	{

	}
	else if(Type==3) // EVENTDOWNLOAD
	{
	    var before_At = pg1_cell_At;

		comp_cnt.innerHTML = "&nbsp;" + CurIndex + "/" + TotalCnt;

		pg1_cell_At += parseInt((((CurIndex-1)/TotalCnt)*progress1.length)-before_At);

		for(var i=before_At;i<pg1_cell_At;i++) {

			fnProgressUpdate(progress1, i);
		}
		prc_msg.innerHTML = "&nbsp;파일 다운로드 완료....";
	}
	else if(Type==4) // EVENTDISTRIBUTE
	{
		tot_item.innerHTML = "&nbsp;" + CurIndex + "/" + TotalCnt;
		item_nm.innerHTML = "&nbsp;" + DownFileName;
	    var before_At = pg_cell_At;

		pg_cell_At += parseInt((((CurIndex-1)/TotalCnt)*progress.length)-before_At);

		for(var i=before_At;i<pg_cell_At;i++) {
		
			fnProgressUpdate(progress, i);
		}
		prc_msg.innerHTML = "&nbsp;파일 설치 완료";
	}
}
</SCRIPT>

<SCRIPT language=JavaScript for=MiInstaller event=OnError(ItemName,ErrorCode,ErrorMsg)>
{
	IsError = true;
	err_msg.innerHTML += '<font class="f2" color="red">' + ItemName + '&nbsp;다운&nbsp;실패&nbsp; -- ErrorCode:' + ErrorCode + '<br>' + ErrorMsg + "<br>";
	t_err.className = "show";
	reinstall.className = "show";
	MiInstaller.stop();
}
</SCRIPT>

</HEAD>
<BODY leftmargin="0" topmargin="0" onload="fnOnLoad()">
<br><br>
<center>
<table id="ins_tbl" align="center" border=0 width="600">
  <tr>
    <td><table width="637" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr> 
          <td height="10"></td>
        </tr>
        <tr> 
          <td><img src="<c:url value="/resources/static/images/miInstall/insu_down_listbg1.gif"/>" width="637" height="11"></td>
        </tr>
        <tr> 
          <td height="37" bgcolor="#EEEEEE"> <table width="607" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr> 
                <td height="15"></td>
              </tr>
              <tr> 
                <td><table width="590" border="0" align="center" cellpadding="0" cellspacing="0">
                    <tr> 
                      <td width="10" rowspan="3"><img src="<c:url value="/resources/static/images/miInstall/insu_down_img.gif"/>" width="150" height="90"></td>
                      <td width="590" height="35"><img src="<c:url value="/resources/static/images/miInstall/insu_down_title.gif"/>" width="204" height="27"></td>
                    </tr>
                    <tr> 
                      <td height="45"><img src="<c:url value="/resources/static/images/miInstall/insu_down_title2.gif"/>" width="329" height="32"></td>
                    </tr>
                  </table></td>
              </tr>
              <tr> 
                <td>&nbsp;</td>
              </tr>
              <tr> 
                <td><table width="607" border="0" cellspacing="0" cellpadding="0">
                    <tr> 
                      <td width="12" height="12"><img src="<c:url value="/resources/static/images/miInstall/insu_down_listbg_sub1.gif"/>" width="12" height="12"></td>
                      <td width="583" height="12" bgcolor="#FFFFFF"></td>
                      <td width="12" height="12"><img src="<c:url value="/resources/static/images/miInstall/insu_down_listbg_sub2.gif"/>" width="12" height="12"></td>
                    </tr>
                    <tr> 
                      <td rowspan="5" bgcolor="#FFFFFF">&nbsp;</td>
                      <td bgcolor="#FFFFFF">
						<table width="570" border="0" align="center" cellpadding="0" cellspacing="0">
						<tr>
                            <td width="10" valign="top"><img src="<c:url value="/resources/static/images/miInstall/insu_down_list_icon1.gif"/>" width="8" height="11"></td>
                            <td width="570">암호화 프로그램 설치여부를 묻는 보안경고창이 나타나면 반드시 
                            “<strong><font color="#FF7200">예</font></strong>”를 선택하여주시기 바랍니다.<br>
                            “아니오”를 선택하시면 보안을 위해 사용이 제한됩니다.
                            </td>
                          </tr>
                        </table>
                      </td>
                      <td rowspan="5" bgcolor="#FFFFFF">&nbsp;</td>
                    </tr>
                    <tr> 
                      <td bgcolor="#FFFFFF">&nbsp;</td>
                    </tr>
                    <tr> 
                      <td bgcolor="#FFFFFF">
                      <table width="570" border="0" align="center" cellpadding="0" cellspacing="0">
						<tr> 
                            <td width="10" valign="top">
                            <img src="<c:url value="/resources/static/images/miInstall/insu_down_list_icon1.gif"/>" width="8" height="11">
                            </td>
                            <td width="570">윈도우 XP 서비스팩2 사용자께서는 주소 표시줄 아래 경고문구  
                            “ <img src="<c:url value="/resources/static/images/miInstall/insu_down_list_icon2.gif"/>" width="15" height="15" align="absmiddle">
							이 사이트에서...여기를 클릭하십시오” 를 선택하시어, Active X컨트롤을 설치하시기 바랍니다.
							</td>
                          </tr>
                      </table>
                      </td>
                    </tr>
                    <tr> 
                      <td bgcolor="#FFFFFF">&nbsp;</td>
                    </tr>
                    <tr> 
					  <td bgcolor="#FFFFFF">
						<table width="570" border="0" align="center" cellpadding="0" cellspacing="0">
							<tr> 
                            <td width="10" valign="top"><img src="<c:url value="/resources/static/images/miInstall/insu_down_list_icon1.gif"/>" width="8" height="11"></td>
                            <td width="570">프로그램 설치가 정상적이지 않을 경우에는 
                            <strong><font color="#FF7200"><a href="<c:url value="/miInstallU/MiPlatform_SetupUpdater321.exe"/>">수동설치</a></font></strong>를 통해 수동설치하시거나 
                            <strong><font color="#FF7200">문의하기</font></strong>를 통해 질문하시면 신속히 답변을 드리겠습니다.
							</td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                    <tr> 
                      <td width="12" height="12"><img src="<c:url value="/resources/static/images/miInstall/insu_down_listbg_sub3.gif"/>" width="12" height="12"></td>
                      <td bgcolor="#FFFFFF"></td>
                      <td width="12" height="12"><img src="<c:url value="/resources/static/images/miInstall/insu_down_listbg_sub4.gif"/>" width="12" height="12"></td>
                    </tr>
                  </table></td>
              </tr>
            </table></td>
        </tr>
        <tr> 
          <td><img src="<c:url value="/resources/static/images/miInstall/insu_down_listbg2.gif"/>" width="637" height="11"></td>
        </tr>
        <tr>
          <td height="5"></td>
        </tr>
      </table></td>
  </tr>
</table>
</center>
<table  id="ins_tbl" align="center" border=0 width="600" >
<tr>
	<td>
	<table >
		<tr>
			<td class="f2"> 파일다운로드 진행 상황</td><td id="comp_cnt" class="f2" align=left NOWRAP>&nbsp;</td>
		</tr>
	</table>
	</td>
</tr>
<tr>
	<td>
	<div id=pg1 style="font-size:8pt;padding:1px;border:1px GROOVE silver;">
		<span id="progress1">&nbsp;</span>
	</div>	
	
	</td>
</tr>
<tr>
	<td>
	<table>
		<tr>
		<td class="f2">파일설치 진행 상황</td><td id="tot_item" align=left class="f2" NOWRAP>&nbsp;</td>
		</tr>
	</table>
	</td>		
</tr>
<tr>
	<td>
	<div id=pg style="font-size:8pt;padding:1px;border:1px GROOVE silver;" >
		<span id="progress">&nbsp;</span>
	</div>
	</td>
</tr>
<tr>
	<td>
	<table>
		<tr>
			<td class="f2">대상파일</td><td id="item_nm" class="f2" align=left NOWRAP>&nbsp;</td>
		</tr>
	</table>
	</td>		
</tr>
<tr>
	<td id=prc_msg class="f2" >&nbsp;<td>
</tr>
</table>

<%-- 
<table class="ins_tbl" align=center>
	<tr>
		<td class="f2">기존 사용자 처리사항</td>
	</tr>
	<tr>
		<td class="f2">1.Program files\\TobeSoft\\Miplatform320U\Componnet\remove\next_remove.bat을 실행시켜 파일을 삭제</td>
	</tr>
	<tr>
		<td class="f2">2.Program files\\TobeSoft\\Miplatform320U 폴더  삭제</td>
	</tr>
	<tr>
		<td class="f2">3.레지스트리에서 HKEY_CURRENT_USER\\Software\\tobesoft\\miplatform320U 삭제</td>
	</tr>
</table>
 --%>

<table class="hide" id=t_err align=center>
	<tr>
		<td class="f2">설치시 에러가 발생한 항목</td>
	</tr>
	<tr>
		<td id=err_msg class="f2">&nbsp;</td>
	</tr>
</table>

<SCRIPT LANGUAGE="JavaScript">
	CreateMiInstlr("MiInstaller", "Win32U", "3.2", "DensoKorea");
</SCRIPT>



</BODY>
</HTML>