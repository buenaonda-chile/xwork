<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DIONE(DENSO Enterprise Information Potal System)</title>
<script language="javascript" src="${cp}/common/js/jquery-1.4.1.js"></script>
<link rel="stylesheet" href="${cp}/style/miInstall.css" type="text/css">
<script language="JavaScript" type="text/javascript">
window.open("http://dione.dnke.kr/closePop2.html", "noticePop", "resizable=yes, width=700,height=500");
location.href="http://ndione.densokorea.com";
/* 삭제 : 2019.01.15
// cookie input
function setCookie( name, value, expirehours ) {
	var todayDate = new Date();
	//todayDate.setHours( todayDate.getHours() + expirehours );
	//document.cookie = name + "=" + escape( value ) + "; path=/; expires=" + todayDate.toGMTString() + ";"
	//2015.07.01 제환복
	//변경내용 : Cookie저장시간 48시간->무제한변경(9999)
	//todayDate.setMinutes(todayDate.getMinutes() + expirehours );
	//document.cookie = name + "=" + escape( value ) + "; path=/; expires=" + todayDate.toGMTString() + ";"	
	todayDate.setDate( todayDate.getDate() + expirehours );
	document.cookie = name + "=" + escape( value ) + "; path=/; expires=" + todayDate.toGMTString() + ";"
}
// cookie output
function getCookie(name){
	 var nameOfCookie = name + "=";
	 var x = 0;
	 while ( x <= document.cookie.length ){
	  var y = (x+nameOfCookie.length);
	  if ( document.cookie.substring( x, y ) == nameOfCookie ) {
	   if ( (endOfCookie=document.cookie.indexOf( ";", y )) == -1 ) {
	    endOfCookie = document.cookie.length;
	   }
	   return unescape( document.cookie.substring( y, endOfCookie ) );
	  }
	  x = document.cookie.indexOf( " ", x ) + 1;
	  if ( x == 0 )
	  break;
	 }
	 return "";
}

// cookie delete
function deleteCookie( cookieName )
{
 var expireDate = new Date();
 
 //어제 날짜를 쿠키 소멸 날짜로 설정한다.
 expireDate.setDate( expireDate.getDate() - 1 );
 document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString() + "; path=/";
}


var resultMessage = "${resultMessage}";
var resultPwfcReset = "${resultPwfcReset}";
var resultPassYn = "${resultPassYn}";

	if(resultPassYn != ""){
		alert(resultMessage);
		document.location.href = "login2.do";
	}


	$(document).ready(function(){
		if(resultMessage != ""){
			alert(resultMessage);
			// 쿠키생성(1시간)
			if(getCookie("pwfcCount") != ""){
				setCookie("pwfcCount",parseInt(getCookie("pwfcCount"))+1,1);
			} else {
				setCookie("pwfcCount",1,1);
			}
			$("#password").focus();
		}else{
			$("#userId").focus();
		}

		if(resultPwfcReset != ""){
			deleteCookie("pwfcCount");
		}
		
		window.open("http://dione.dnke.kr/closePop.html", "noticePop", "resizable=yes, width=700,height=500");
		//window.open("http://dione.dnke.kr/closePop.html", "noticePop");

		$("#loginBtn").click(function(data){
			if($.trim($("#userId").val()) == ""){
				alert("아이디를 입력해 주세요.");
				$("#userId").focus();
				return;
			}
			if($.trim($("#password").val()) == ""){
				alert("비밀번호를 입력해 주세요.");
				$("#password").focus();
				return;				
			}

			if(loginForm.idSave.checked == true){
				//setCookie("user_id",$.trim($("#userId").val()),48);
				//2015.07.01 제환복
				//변경내용 : Cookie저장시간 48시간->무제한변경(9999)
				//setCookie("user_id",$.trim($("#userId").val()),1);
				setCookie("user_id",$.trim($("#userId").val()),9999);
			}else{
				//2015.07.01 제환복
				//변경내용 : 아이디저장체크해제시 cookie삭제
				if(getCookie("user_id") != ""){
					//alert("=="+getCookie("user_id")+"==");
					deleteCookie("user_id");
				}
			}
			$("#loginForm").submit();
		});		
		
	});
	*/
</script>
</head>
<body leftmargin="0" topmargin="0">
<form id="loginForm" method="post" action="${cp}/login/checkLoginLdap.do">
<div style="position:absolute; left:412px; top:390px; z-index:1;">
<table border='0' cellspacing='0' cellpadding='0' style="border-width:0;">
  <tr>
  	<td>
    	<input id="userId" name="userId" type="text" value="${userId }" onkeypress="if (13 == event.keyCode) document.getElementById('password').focus();" style="font-size:9pt; height:18;width:120px; border-width:1; ime-mode:disabled;" maxlength="10"/>
    </td>
  </tr>  
  <tr>
  	<td>
    	<input id="password" name="password" type="password" onkeypress="if (13 == event.keyCode) document.getElementById('loginBtn').click();" style="font-size:9pt; height:18;width:120px; border-width:1; ime-mode:disabled;" maxlength="18"/>
    </td>
  </tr>  
  <tr>
  	<td>
    	<input id="idSave" name="idSave" type="checkbox" onkeypress="if (13 == event.keyCode) document.getElementById('loginBtn').click();" style="font-size:9pt; height:18;width:18px; border-width:1; ime-mode:disabled;" maxlength="18"/>
    	<FONT SIZE="2" COLOR="">아이디 저장</FONT>
    </td>
  </tr> 
</table>
</div>

<div style="position:absolute; left:412px; top:480px; z-index:1;">
<table border='0' cellspacing='0' cellpadding='0' style="border-width:0;">
<tr>
  	<td>
    	<FONT SIZE="4" COLOR="red">▶</FONT>
    	<FONT SIZE="2" COLOR="red"> 컴퓨터 부팅시 아이디/패스워드와 동일합니다. </FONT>
    	<FONT SIZE="4" COLOR="red">◀</FONT>
    </td>
  </tr>
   <tr>
  	<td>
    	<FONT SIZE="4" COLOR="red">▶</FONT>
    	<FONT SIZE="2" COLOR="red"> コンピューターを起動の時アイディー/パスワードと同じです。 </FONT>
    	<FONT SIZE="4" COLOR="red">◀</FONT>
    </td>
  </tr>
</table>
</div>

<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td valign=top>
      <table width="1024" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td valign=top><img src="${cp}/image/login.jpg" width="1259" height="770" border="0" usemap="#Map" hidefocus/></td>
        </tr>
      </table>
    </td>
  </tr>
</table>

<map name="Map" id="Map">
  <area id="loginBtn" shape="rect" coords="550,394,618,433" href="#"/>
  <area id="requestBtn" shape="rect" coords="445,175,530,193" href="#"/>
</map>
</form>
</body>
</html>

<script language="JavaScript" type="text/javascript">
	loginForm.userId.value = getCookie("user_id");
	if(loginForm.userId.value != ""){
		loginForm.idSave.checked = true;
		$("#password").focus();
	}
</script>
