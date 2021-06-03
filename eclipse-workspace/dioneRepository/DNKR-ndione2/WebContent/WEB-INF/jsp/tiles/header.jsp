<%--
 * header.jsp
 *
 * [EN] JSP is a common header area of the entire screen.
 * [EN] Please implement depending on the requirements of each application.
 *
 * [JP] 全画面のヘッダエリア共通のJSPです。
 * [JP] 各アプリの要件に応じて実装してください。
 *
 * $ header.jsp 1753 2015-07-03 00:24:13Z 815372040074 $
 *
 * Copyright (c) 2012 DENSO CORPORATION. All rights reserved.
--%>

<%-- [EN] Variable definition -----------------------------------------------------%>
<%-- [JP] 変数定義 ----------------------------------------------------------------%>

<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] 画面ID (@ViewIdで定義) --%>
<c:set var="screenId" value="<%= request.getAttribute(Globals.SCREEN_ID_KEY) %>"/>

<%-- [EN] Screen type (defined in tiles-defs.xml) --%>
<%-- [JP] 画面種別 (tiles-defs.xmlに定義) --%>
<c:set var="type"><tiles:getAsString name="type" /></c:set>

<%-- [EN] Screen mode (defined in tiles-defs.xml) --%>
<%-- [JP] 画面モード (tiles-defs.xmlに定義) --%>
<c:set var="mode"><tiles:getAsString name="mode" /></c:set>

<%-- [EN] Availability of changing language (defined i tiles-defs.xml) --%>
<%-- [JP] 言語切替可否 (tiles-defs.xmlに定義) --%>
<c:set var="language"><tiles:getAsString name="language" /></c:set>

<%-- [EN] Screen drawing ----------------------------------------------------------%>
<%-- [JP] 画面描画 ----------------------------------------------------------------%>


<div class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <c:choose>
                <c:when test="${type == 'menu' || type == 'main'}">
                    <a href="${pageContext.request.contextPath}/init.do" class="navbar-brand" title="<spring:message code="label.comment.title.returntop" />">
                        <spring:message code="label.header.title" />
                    </a>
                </c:when>
                <c:otherwise>
                    <div class="navbar-brand">
                        <spring:message code="label.header.title" />
                    </div>
                </c:otherwise>
            </c:choose>
            <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
                <c:if test="${type == 'main'}">
                    <span class="icon-bar"></span>
                </c:if>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <c:if test="${type == 'menu' || type == 'main'}">
                    <span class="icon-bar"></span>
                    <c:if test="${language == 'on'}">
                        <span class="icon-bar"></span>
                    </c:if>
                </c:if>
            </button>
        </div>
        <div class="navbar-collapse collapse" id="navbar-main">
            <ul class="nav navbar-nav navbar-right">
                <c:if test="${type == 'main'}">
                    <c:choose>
                        <c:when test="${mode == 'basic'}">
                            <li><a href="${pageContext.request.contextPath}/WA0000Menu/init.do"><i class="fa fa-home fa-fw"></i>Menu</a></li>
                        </c:when>
                        <c:otherwise>
                            <li></li>
                        </c:otherwise>
                    </c:choose>
                </c:if>
                <li><a href="#" onclick="openHelp('${screenId}');"><i class="fa fa-question fa-fw"></i>Help</a></li>
                <c:if test="${type == 'menu' || type == 'main'}">
                    <li><a href="${pageContext.request.contextPath}/logout.do"><i class="fa fa-sign-out fa-fw"></i>LogOut</a></li>
                    <c:if test="${language == 'on'}">
                        <li class="dropdown">
                            <a class="dropdown-toggle" role="button" aria-expanded="false" href="#" data-toggle="dropdown"><i class="fa fa-globe fa-fw"></i>Language<span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="init.do?locale=ja">JA:日本語</a></li>
                                <li><a href="init.do?locale=en">EN:ENGLISH</a></li>
                            </ul>
                        </li>
                    </c:if>
                </c:if>
            </ul>
        </div>
    </div>
</div>


<div class="container">

    <%-- [EN] Screen Name --%>
    <%-- [JP] 画面名 --%>
    <c:choose>
        <c:when test="${screenId != null}">
            <h3><spring:message code="label.${screenId}.name" /></h3>
        </c:when>
        <c:otherwise>
            <h3><spring:message code="label.unknownscreen.name" /></h3>
        </c:otherwise>
    </c:choose>

    <%-- [EN] Message area --%>
    <%-- [JP] メッセージエリア --%>
    <div id="messageArea">
        <jsp:include page="/WEB-INF/jsp/includes/messageArea_temp.jsp" />
    </div>

</div>

