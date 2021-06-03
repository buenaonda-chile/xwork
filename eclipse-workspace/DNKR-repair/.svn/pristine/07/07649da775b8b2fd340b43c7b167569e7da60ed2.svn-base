<%--
  Created by IntelliJ IDEA.
  User: julicekim
  Date: 2019-01-21
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<div class="bg"></div>

<%-- #login --%>
<div id="login">
	<h1>DENSO DICAS</h1>

	<%-- #wrap --%>
	<div class="wrap">
		<form name="frmLogin" id="frmLogin" action="<c:url value="/j_spring_security_check"/>" method="post">
			<fieldset>
				<input type="text" id="username" class="ic_user" name="j_username" title="사용자ID" placeholder="사용자ID" autocomplete="off" />
				<input type="password" id="password" class="ic_pwd" name="j_password" title="비밀번호" placeholder="비밀번호" autocomplete="off" />
			</fieldset>
			<button type="submit" value="submit">로그인</button>
		</form>
	</div>
	<%--// #wrap --%>
	<c:set value="${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}" var="errorMsg"/>
	<c:if test="${errorMsg != null}">
		<div class="loginFail">
			<p class="tit"><span>${errorMsg}</span><a href="javascript:void(0);" class="close">X</a></p>
		</div>
		<c:remove scope="session" var="SPRING_SECURITY_LAST_EXCEPTION" />
	</c:if>
	<!-- address -->
	<address>COPYRIGHT Ⓒ 2018 DENSO CORPORATION.<br />ALL RIGHTS RESERVED.</address>
	<!-- //address -->
</div>
<%--// #login --%>

<script type="text/javascript">

  $(document).ready(function() {
    $("#frmLogin").submit(function () {
      if ($("input[type=text]", "#frmLogin").val() == ""
          || $("input[type=password]", "#frmLogin").val() == "")
        return false;
    });

    $("div.loginFail a.close").click(function(e) {
      $("div.loginFail").fadeOut(300);
    });

  });

</script>
