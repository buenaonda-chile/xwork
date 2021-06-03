<%--
 * Project : 
 *
 * [EN] JSP is a common header area of the entire screen.
 * [EN] Please implement depending on the requirements of each application.
 *
 * [JP] 全画面のヘッダエリア共通のJSPです。
 * [JP] 各アプリの要件に応じて実装してください。
 *
 * $ header.jsp 2311 2016-04-04 08:48:41Z 10088DS00879 $
 *
 * Copyright (c) 2015 DENSO IT SOLUTIONS. All rights reserved.
--%>

<%-- [EN] Variable definition --%>
<%-- [JP] 変数定義 --%>

<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] 画面ID (@ViewIdで定義) --%>
<c:set var="screenId" value="<%= request.getAttribute(Globals.SCREEN_ID_KEY) %>"/>


<%-- [EN] Screen drawing --%>
<%-- [JP] 画面描画 --%>

<%-- header-wrap --%>
<div id="header-wrap">
  <%-- header --%>
  <div id="header">
    <%-- div-wrap --%>
    <div class="div-wrap">
      <%-- hd-left --%>
      <div class="hd-left">
        <!--<p class="username-deco"><img src="<c:url value="/assets/img/username-deco.png"/>"/></p>-->
        <p class="user-txt1">
          <span class="user-name">${userStore.getEgovUserVO().getFulnm()}</span>
          <span class="user-dept">
          (<c:choose>
            <c:when test="${userStore.getEgovUserVO().getOfficeCd() != null}">
              ${userStore.getEgovUserVO().getOfficeNm()}
            </c:when>
            <c:otherwise>
              ${userStore.getEgovUserVO().getDeptNm()}
            </c:otherwise>
          </c:choose>)
          </span>
          님 반갑습니다.</p>
      </div>
      <%--// hd-left --%>
      <%-- hd-right --%>
      <div class="hd-right">

        <%-- .hd-icon --%>
        <div class="hd-icon">
          <p class="logout">
            <a href="<c:url value="/j_spring_security_logout"/>"><!--<span class="icon-logout"></span>-->로그아웃</a>
          </p>
        </div>
        <%--// .hd-icon --%>
        <div class="gnb_global">
          <a href="https://densokorea.webex.com/meet/denso" target="_blank">Webex 바로가기</a>
        </div>
        <div class="gnb_global">
          <a id="changepasswd" href="<c:url value="/popup/password/init"/>" target="_blank">비밀번호변경</a>
          <script type="text/javascript">
            $(document).ready(function() {
              $("#changepasswd").click(function(e) {
                e.preventDefault();
                var href = $(this).attr("href");
                window.open(href,'','location=0,directories=0,resizable=1,status=0,toolbar=0,menubar=0,scrollbars=1,width=500,height=250,left='
                    + ((screen.availWidth-500)/2) + ',top=' + ((screen.availHeight-420)/2) + '');
              });
            });
          </script>
        </div>
        <div class="dropdown hd-lang-sel">
          <button type="button" class="dropbtn-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Language</button>
          <ul id="ddnLang" class="dropdown-menu" role="menu">
            <li role="presentation"><a href="#">Korean</a></li>
            <li role="presentation"><a href="#">English</a></li>
            <li role="presentation"><a href="#">Japanese</a></li>
          </ul>
        </div>
        <%--// .hd-lang-sel --%>

      </div>
      <%--// hd-right --%>
    </div>
    <%--// div-wrap --%>
  </div>
  <%--// header --%>
</div>
<%--// header-wrap --%>

<%-- mainNav-wrap --%>
<div id="mainNav-wrap">
  <h1 id="logo"><a href="<c:url value="/"/>" title="메인"><img src="<c:url value="/assets/img/logo.png"/>" alt="로고"></a></h1>
  <p class="menu-bnt"><a href="javascript:void(0);"><img src="<c:url value="/assets/img/menu-bnt.png"/>" align="전체메뉴버튼"></a></p>
  <div class="gap20"></div>
  <%-- mainNav --%>
  <div id="mainNav">
    <tiles:insertTemplate template="/WEB-INF/jsp/base/menu.jsp" />
    <div class="gap20"></div>
    <div class="mNav-ctrl">
      <a href="javascript:;" class="als-prev"><img src="<c:url value="/assets/img/arrow-top.png"/>" alt="위로가기"></a>
      <a href="javascript:;" class="als-next"><img src="<c:url value="/assets/img/arrow-bottom.png"/>" alt="아래로가기"></a>
    </div>
  </div>
  <%--// mainNav --%>
  <div class="home"><a href="/main"><img src="<c:url value="/assets/img/home.png"/>" alt="홈버튼"></a></div>
</div>
<%--// mainNav-wrap --%>