<%--
 * PROJECT：
 *
 * [KR] 
 * 
 * $Id$
 *
 * Copyright (c) 2017 DENSO CORPORATION. All rights reserved.
 *
--%>
<!-- [EN] Contents area -->
<!-- [JP] コンテンツエリア -->
<spring:message code="label.filename" /> : <c:out  value="${url }"></c:out>
<div class="login-wrap">
	<div class="login-box">
		<h1 class="logo"><img src="/img/login/logo-R.png" alt="덴소코리아로고"></h1>
		<script>
			'use strict'
			function checkForm(){
				if(document.getElementsByName("USER").value==""){
					alert("아이디를 입력하세요");		
					return false;
				}
				if(document.getElementsByName("PASSWORD").value==""){
					alert("패스워드를 입력하세요");		
					return false;
				}
				return true;
			}
		</script>
		<p class="title"><strong>업무관리시스템</strong>로그인</p>
		<form name="loginForm" method="post" onsubmit="return checkForm();">
			<div class="login-left">
				<input class="loing_input id" value title="아이디를입력해주세요" name="USER" type="text" placeholder="아이디" style="border-radius:5px; width:360px; height:40px; box-shadow:0px 0px 10px rgba(0, 0, 0, 0.3); background:url(/img/login/id-icon.png)no-repeat 15px 17px #fff; padding-left:40px;">
				<input class="loing_input pw" value title="비밀번호를입력해주세요" name="PASSWORD" type="password" placeholder="패스워드" style="border-radius:5px; width:360px; height:40px; box-shadow:0px 0px 10px rgba(0, 0, 0, 0.3); background:url(/img/login/pw-icon.png)no-repeat 15px 14px #fff; padding-left:40px;">
				<input type=hidden name="SMENC" value="UTF-8" />
                <input type=hidden name="SMLOCALE" value="us-en" />
                <input type=hidden name="LOCALE" value="EN" />
                <input type=hidden name=target value="$$target$$" />
                <input type=hidden name=smauthreason value="$$smauthreason$$" />
                <input type=hidden name=postpreservationdata value="$$postpreservationdata$$" />
                <input type=hidden name=smagentname value="$$smagentname$$" />
			</div>
			<button type="submit" class="login-bnt">로그인</button>
			<div class="gap20"></div>
			<div class="login-radio">
				<input name="idSave" value="idSave" id="idSave" type="checkbox"><label for="idSave"><span class="idSave"></span>아이디저장</label> 
				<input name="type" value="mem" id="mem" type="radio"><label for="mem" class="type1"><span class="type"></span>사원</label>
				<input name="type" value="etc" id="etc" type="radio"><label for="etc"><span class="type"></span>외부인</label>
			</div>
			<div class="gap30"></div>
			<div class="LB-bottom-line"></div>
		</form>
		<div class="gap20"></div>
		<div class="login-text">
			<p class="left">로그인 방법<a href="#n" class="pop-bnt">로그인 방법</a></p>
			<div class="lText-pop">
				<p class="tit">로그인 방법<a href="#n" class="close">X</a></p>
				<p class="stxt">
				로그인 방법<br>로그인 방법<br>로그인 방법<br>로그인 방법
			</p>
			</div>
			<p class="right">로그인 정보를 잊어버리셨나요?<a href="#n">ID / PW 찾기</a></p>
		</div>
		<div class="gap30"></div>
		<div class="gap30"></div>
	</div><!--login-box-->
</div><!--login-wrap-->
<div class="login-bg"></div>