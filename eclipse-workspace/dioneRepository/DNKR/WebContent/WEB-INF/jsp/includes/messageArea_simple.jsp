<%--
 * messageArea_simple.jsp
 *
 * [JP] メッセージ表示
 * [EN] Message Area
 *
 * $ messageArea_simple.jsp 1865 2015-07-30 06:46:03Z 10088DS00879 $
 *
 * Copyright (c) 2014 DENSO CORPORATION. All rights reserved.
--%>

<%-- Error messages --%>
<c:set var="error" value="<%= request.getAttribute(Globals.ERROR_KEY) %>" />
<c:if test="${error != null}">
    <div class="messagearea_error">
        <c:forEach var="message" items="${error}">
            <spring:message message="${message}" />
            <br />
        </c:forEach>
    </div>
</c:if>

<%-- Warning messages --%>
<c:set var="warning" value="<%= request.getAttribute(Globals.WARNING_KEY) %>" />
<c:if test="${warning != null}">
    <div class="messagearea_warning">
        <c:forEach var="message" items="${warning}">
            <spring:message message="${message}" />
            <br />
        </c:forEach>
    </div>
</c:if>

<%-- Information messages --%>
<c:set var="information" value="<%= request.getAttribute(Globals.INFORMATION_KEY) %>" />
<c:if test="${information != null}">
    <div class="messagearea_information">
        <c:forEach var="message" items="${information}">
            <spring:message message="${message}" />
            <br />
        </c:forEach>
    </div>
</c:if>

<%-- User defined messages --%>
<%-- 
<c:set var="messages" value='<%= request.getAttribute(Globals.MESSAGE_KEY_PREFIX + "key") %>' />
<c:if test="${messages != null}">
    <div class="messagearea_information">
        <c:forEach var="message" items="${messages}">
            <spring:message message="${message}" />
            <br />
        </c:forEach>
    </div>
</c:if>
 --%>

