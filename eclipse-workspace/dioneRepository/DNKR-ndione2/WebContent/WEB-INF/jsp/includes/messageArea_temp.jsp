<%--
 * messageArea_temp.jsp
 *
 * [EN] Message Area (AI-Sample only)
 * [JP] メッセージ表示(AI-Sample独自)
 *
 * $Id$
 *
 * Copyright (c) 2014 DENSO CORPORATION. All rights reserved.
--%>

<%-- Error messages --%>
<c:set var="error" value="<%= request.getAttribute(Globals.ERROR_KEY) %>" />
<c:if test="${error != null}">
    <div class="alert alert-dismissable alert-danger">
        <c:forEach var="message" items="${error}">
            <spring:message message="${message}" />
            <br />
        </c:forEach>
    </div>
</c:if>

<%-- Warning messages --%>
<c:set var="warning" value="<%= request.getAttribute(Globals.WARNING_KEY) %>" />
<c:if test="${warning != null}">
    <div class="alert alert-dismissable alert-warning">
        <c:forEach var="message" items="${warning}">
            <spring:message message="${message}" />
            <br />
        </c:forEach>
    </div>
</c:if>

<%-- Information messages --%>
<c:set var="information" value="<%= request.getAttribute(Globals.INFORMATION_KEY) %>" />
<c:if test="${information != null}">
    <div class="alert alert-dismissable alert-info">
        <c:forEach var="message" items="${information}">
            <spring:message message="${message}" />
            <br />
        </c:forEach>
    </div>
</c:if>

