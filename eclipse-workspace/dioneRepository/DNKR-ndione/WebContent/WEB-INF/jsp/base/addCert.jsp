
	<script type="text/javascript">
		function checkForm(){
			
			if(document.getElementById("userid").value==""){
				alert("아이디를 입력하세요");		
				return false;
			}
			if(document.getElementById("userpass").value==""){
				alert("비밀번호를 입력하세요");		
				return false;
			}
			return true;
		}
	</script>

	<form name="loginForm" method="POST" action="" onsubmit="return checkForm();">
		<div class="sub-con-wrap">
			<div class="cLogin_wrap">
				<p class="info">추가인증이 필요한 페이지입니다.</p>
				<input type="hidden" name="menu" value="${menunum }">
				<input class="clogin_input" title="아이디를입력해주세요" name="userid" id="userid" type="text" placeholder="아이디">
				<input class="clogin_input" title="비밀번호를입력해주세요" name="userpass" id="userpass" type="password" placeholder="비밀번호">
				<button type="submit" class="login-bnt" style="cursor:pointer;">로그인</button>
			</div>
		</div>
	</form>
