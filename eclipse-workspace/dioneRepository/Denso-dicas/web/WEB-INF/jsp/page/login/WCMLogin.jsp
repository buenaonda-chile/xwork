<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2018-11-01
  Time: 오후 9:20
  To change this template use File | Settings | File Templates.
--%>
<%-- login-box --%>
<div class="login-box">

  <form name="frmLogin" id="frmLogin" action="<c:url value="/j_spring_security_check"/>" method="post">
    <div class="login-left">
      <fieldset>
          <input type="text" name="j_username" class="id" title="아이디 입력" placeholder="USER ID">
          <input type="password" name="j_password" class="pw" title="비밀번호 입력" placeholder="PASSWORD">
      </fieldset>
    </div>
    <button type="submit" class="login-bnt"><spring:message code="button.login" /></button>
    <div class="gap30"></div>
    <div class="LB-bottom-line"></div>
  </form>
  <div class="gap20"></div>
  <%-- login-text --%>
  <div class="login-text">
    <div class="gap20"></div>
    <p class="left"> 로그인 방법은?<a href="javascript:void(0);" class="pop-bnt">로그인 방법</a></p>
    <div id="lText-pop" class="lText-pop">
      <p class="tit">로그인 방법<a href="javascript:void(0);" class="close">X</a></p>
      <p class="stxt">
        1. 내부직원은 PC의 아이디, 비밀번호를 입력해주세요.<br/>
        2, 외부직원은 발급받으신 아이디, 비밀번호를 입력해주세요.
      </p>
    </div>
    <p class="right">로그인 정보를 잊어버리셨나요? 유선상으로 관리자에게 문의하세요.</p>
    <c:set value="${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}" var="errorMsg"/>
    <c:if test="${errorMsg != null}">
      <div class="loginFail">
        <p class="tit"><span>${errorMsg}</span><a href="javascript:void(0);" class="close">X</a></p>
      </div>
      <c:remove scope="session" var="SPRING_SECURITY_LAST_EXCEPTION" />
    </c:if>
  </div>
  <%--// login-text --%>
  <div class="gap30"></div>
  <div class="gap30"></div>
  <p class="copyright">
    COPYRIGHT Ⓒ 2018 DENSO CORPORATION. ALL RIGHTS RESERVED.
  </p>
</div>
<%--// Login-box --%>

<%-- login-bg --%>
<div class="login-bg" id="login-bg">

  <div>
    <img src="<c:url value="/assets/img/login-bg.jpg"/>" />
  </div>
  <!--div>
    <img src="<c:url value="/assets/img/login-bg-e1.jpg"/>" />
  </div-->
</div>
<%--// login-bg --%>

<script type="text/javascript">

  $(document).ready(function() {
    $("#frmLogin").submit(function () {
      if ($("input[type=text]", "#frmLogin").val() == ""
          || $("input[type=password]", "#frmLogin").val() == "")
        return false;
    });

    $("div.login-text a.pop-bnt").click(function(e) {
      e.preventDefault();
      $("#lText-pop").fadeIn(300);
    });

    $("div#lText-pop a.close").click(function(e) {
      $("#lText-pop").fadeOut(300);
    });

    $("div.loginFail a.close").click(function(e) {
      $("div.loginFail").fadeOut(300);
    });

  });

</script>
