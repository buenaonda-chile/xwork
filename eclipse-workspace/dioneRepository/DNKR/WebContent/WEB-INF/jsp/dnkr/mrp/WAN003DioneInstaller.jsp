<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--  
<c:set var="serverAddr" value="http://dione.dnka.kr:80"/>
<c:set var="cp" value="http://dione.dnka.kr/DENSO"/>

<c:set var="serverAddr" value="http://10.74.227.115:80"/>
<c:set var="cp" value="http://10.74.227.115"/>
--%>
<c:set var="serverAddr" value="http://dione.dnke.kr:80"/>
<c:set var="cp" value="http://dione.dnke.kr/DENSO"/>

<script type="text/javascript" src="${cp}/common/js/miInstall.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/mrp/WAN002DioneInstaller.js"></script>

<SCRIPT LANGUAGE="JavaScript">
	var TotalVersionFileCnt;
	var TotalItemCnt;
	var progressColor = "red";	// set to progress bar color
	var pg_cell_At = 0;
	var pg1_cell_At = 0;
	var IsError = false;
	var proMsg;
	var procMsg;

	/* modify date : 20171219  */
	// 별도의 자바스립트생성시 파일다운로드 html화면 생성안됨.
	function fnCheckModule(){
		
		var rlt="ActiveX"; //Uninstall, Installed,ActiveX
		try	{
			if(MiInstaller.Version == undefined){
				//alert("false");
				rlt="Uninstall"; //Uninstall, Installed,ActiveX
				return rlt; // 설치가 안되어 있거나 system32에 MiInstlr321.dll 이 없는 경우.(unregistered 된 경우)
			
			}else{
				//alert("true");
				rlt="Installed"; //Uninstall, Installed,ActiveX
				return rlt;
			}
		}catch(ex){	// MiInstaller.js 가 올라오지 못해서 object를 사용할 수 없는 경우 
			rlt="ActiveX"; //Uninstall, Installed,ActiveX
			return rlt;
		}
	}
	

	function fnOnLoad() {
		var rltCheck=fnCheckModule();
		//alert("fnOnLoad=="+rltCheck);

		// MiInstaller사용 시 Object tag 에서 Param으로 Version과 Key 입력		
		if(rltCheck=="Installed") {
			var tmp_len = progress.offsetWidth; // span
			var tmp_tot_len = pg.offsetWidth; // div

			fnPgCellInit(tmp_len, pg, "progress", tmp_tot_len);
			fnPgCellInit(tmp_len, pg1, "progress1", tmp_tot_len);
	

			if(checkOS()=="VISTA") {
				MiInstaller.UpdateURL = "${serverAddr}/miInstallU/MiUpdate320UUAC.xml";
			} else {
				MiInstaller.UpdateURL = "${serverAddr}/miInstallU/MiUpdate320U.xml";
			}


			var Bcnt = MiInstaller.ExistVersionUpCnt();

			if(Bcnt) {
				//alert("bnt =true");
				MiInstaller.StartDownload();
			} else {
				//alert("bnt =false");
				//fnRun();// 체크픞래그 추가
				var rlt = setSessionSuccess();
				alert("[알림]마이플렛폼이 정상적으로 설치되었습니다.");
			}
		}
		else if(rltCheck=="Uninstall") {
			alert("[알림]최초설치입니다. 화면의 수동설치 문자를 클릭해주세요. 설치후 새로고침[F5]실행해주세요.");
		}else if(rltCheck=="ActiveX") {
			alert("[알림]허용해주세요.");
		}
	}


	var chkFlag = false;
	function fnRun()
	{
		if(chkFlag) return;			
		else chkFlag = true;
		
		if(IsError) return;
				
		MiInstaller.run(); // Application 실행!
		
		opener = self;
		//self.close(); // 익스플로어 6 이하 종료 함수
		CloseWnd(); // 익스플로어 7 이상 종료 함수
		
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
		//alert(Type+"==="+DownFileName);
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
		//fnRun();// 체크픞래그 추가
		var rlt = setSessionSuccess();
		alert("[알림]마이플렛폼이 정상적으로 설치되었습니다.");
	}
	else if(Type==2) // EVENTGETVERSIONCNT
	{
/*
		if(TotalCnt==CurIndex)
		{
			for(var i=pg1_cell_At;i<progress1.length;i++) fnProgressUpdate(progress1,i);
		}
		else
		{
			if(CurIndex>1) {

			    var before_At = pg_cell_At;

				pg_cell_At += parseInt((((CurIndex-1)/TotalCnt)*progress.length)-before_At);

				for(var i=before_At; i<pg_cell_At; i++) {

					fnProgressUpdate(progress, i);
				}
			}
			pg1_cell_At = 0;
			tot_item.innerHTML = "&nbsp;" + CurIndex + "/" + TotalCnt;
		}
*/
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
<form:form id="DioneInstallerForm" name ="DioneInstallerForm">
<table id="ins_tbl"  align="center" style="width:600px;border:0;">
  <tr>
    <td><table align="center" cellpadding="0" cellspacing="0" style="width:637px;border:0;">
        <tr> 
          <td height="10"></td>
        </tr>
        <tr> 
          <td><img src="${cp}/ui/image/miInstall/insu_down_listbg1.gif" width="637" height="11"></td>
        </tr>
        <tr> 
          <td height="37" bgcolor="#EEEEEE"> <table align="center" cellpadding="0" cellspacing="0" style="width:607px;border:0;">
              <tr> 
                <td height="15"></td>
              </tr>
              <tr> 
                <td><table align="center" cellpadding="0" cellspacing="0" style="width:590px;border:0;">
                    <tr> 
                      <td width="10" rowspan="3"><img src="${cp}/ui/image/miInstall/insu_down_img.gif" width="150" height="90"></td>
                      <td width="590" height="35"><img src="${cp}/ui/image/miInstall/insu_down_title.gif" width="204" height="27"></td>
                    </tr>
                    <tr> 
                      <td height="45"><img src="${cp}/ui/image/miInstall/insu_down_title2.gif" width="329" height="32"></td>
                    </tr>
                  </table></td>
              </tr>
              <tr> 
                <td>&nbsp;</td>
              </tr>
              <tr> 
                <td><table cellspacing="0" cellpadding="0" style="width:607px;border:0;">
                    <tr> 
                      <td width="12" height="12"><img src="${cp}/ui/image/miInstall/insu_down_listbg_sub1.gif" style="width:12px;height:12px;"></td>
                      <td width="583" height="12" bgcolor="#FFFFFF"></td>
                      <td width="12" height="12"><img src="${cp}/ui/image/miInstall/insu_down_listbg_sub2.gif" style="width:12px;height:12px;"></td>
                    </tr>
                    <tr> 
                      <td rowspan="5" bgcolor="#FFFFFF">&nbsp;</td>
                      <td bgcolor="#FFFFFF">
						<table align="center" cellpadding="0" cellspacing="0" style="width:570px;border:0;">
						<tr>
                            <td style="width:10px;" valign="top"><img src="${cp}/ui/image/miInstall/insu_down_list_icon1.gif" style="width:8px;height:8px;"></td>
                            <td style="width:570px;">암호화 프로그램 설치여부를 묻는 보안경고창이 나타나면 반드시 
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
                      <table align="center" cellpadding="0" cellspacing="0" style="width:570px;border:0;">
						<tr> 
                            <td style="width:10px;" valign="top">
                            <img src="${cp}/ui/image/miInstall/insu_down_list_icon1.gif" style="width:8px;height:11px;">
                            </td>
                            <td style="width:570px;">윈도우 XP 서비스팩2 사용자께서는 주소 표시줄 아래 경고문구  
                            “ <img src="${cp}/ui/image/miInstall/insu_down_list_icon2.gif" style="width:15px;height:15px;" align="absmiddle">
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
						<table align="center" cellpadding="0" cellspacing="0" style="width:570px;border:0;">
							<tr> 
                            <td style="width:10px;" valign="top"><img src="${cp}/ui/image/miInstall/insu_down_list_icon1.gif" style="width:8px;height:11px;"></td>
                            <td style="width:570px;">프로그램 설치가 정상적이지 않을 경우에는 
                            <strong><font color="#FF7200"><a href="${cp}/miInstallU/MiPlatform_SetupUpdater321.exe" style="color:#0000ff;text-decoration: underline;">수동설치</a></font></strong>를 통해 수동설치하시거나 
                            <strong><font color="#FF7200">문의하기</font></strong>를 통해 질문하시면 신속히 답변을 드리겠습니다.
							</td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                    <tr> 
                      <td style="width:12px;" height="12"><img src="${cp}/ui/image/miInstall/insu_down_listbg_sub3.gif" style="width:12px;height:12px;"></td>
                      <td bgcolor="#FFFFFF"></td>
                      <td style="width:12px;" height="12"><img src="${cp}/ui/image/miInstall/insu_down_listbg_sub4.gif" style="width:12px;height:12px;"></td>
                    </tr>
                  </table></td>
              </tr>
            </table></td>
        </tr>
        <tr> 
          <td><img src="${cp}/ui/image/miInstall/insu_down_listbg2.gif" style="width:637px;height:11px;"></td>
        </tr>
        <tr>
          <td height="5"></td>
        </tr>
      </table></td>
  </tr>
</table>
</center>
<table  id="ins_tbl" align="center" style="width:600px;border:0;">
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

<table class="hide" id=t_err align=center style="width:600px;border:0;">
	<tr>
		<td class="f2">설치시 에러가 발생한 항목</td>
	</tr>
	<tr>
		<td id=err_msg class="f2">&nbsp;</td>
	</tr>
</table>
</form:form>
<SCRIPT LANGUAGE="JavaScript">
	CreateMiInstlr("MiInstaller", "Win32U", "3.2", "denso");
</SCRIPT>

</HTML>