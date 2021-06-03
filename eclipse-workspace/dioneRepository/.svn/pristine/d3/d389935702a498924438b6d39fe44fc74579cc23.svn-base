<%--
 * Project : 
 *
 * [EN] Message Area (Box version)
 * [JP] メッセージ表示(ボックス表示)
 *
 * $ messageArea_box.jsp 2609 2016-09-08 04:14:01Z 10088DS00879 $
 *
 * Copyright (c) 2015 DENSO IT SOLUTIONS. All rights reserved.
--%>

<%-- Error messages --%>
<c:set var="error" value="<%= request.getAttribute(Globals.ERROR_KEY) %>" />

<%-- Warning messages --%>
<c:set var="warning" value="<%= request.getAttribute(Globals.WARNING_KEY) %>" />

<%-- Information messages --%>
<c:set var="information" value="<%= request.getAttribute(Globals.INFORMATION_KEY) %>" />

<%-- User defined messages --%>
<%-- 
<c:set var="messages" value='<%= request.getAttribute(Globals.MESSAGE_KEY_PREFIX + "key") %>' />
 --%>

<%-- Display of message --%>
<c:if test="${error != null || warning != null || information != null}">
    <table class="messagearea_box" >
        <tr>
            <td>
                <div class="messagearea_scroll">

                    <c:if test="${error != null}">
                        <span class="messagearea_error">
                            <c:forEach var="message" items="${error}">
                                <spring:message message="${message}" />
                                <br />
                            </c:forEach>
                        </span>
                    </c:if>

                    <c:if test="${warning != null}">
                        <span class="messagearea_warning">
                            <c:forEach var="message" items="${warning}">
                                <spring:message message="${message}" />
                                <br />
                            </c:forEach>
                        </span>
                    </c:if>

                    <c:if test="${information != null}">
                        <span class="messagearea_information">
                            <c:forEach var="message" items="${information}">
                                <spring:message message="${message}" />
                                <br />
                            </c:forEach>
                        </span>
                    </c:if>

                    <%-- 
                    <c:if test="${messages != null}">
                        <div class="messagearea_information">
                            <c:forEach var="message" items="${messages}">
                                <spring:message message="${message}" />
                                <br />
                            </c:forEach>
                        </div>
                    </c:if>
                     --%>

                </div>
            </td>
        </tr>
    </table>
</c:if>

