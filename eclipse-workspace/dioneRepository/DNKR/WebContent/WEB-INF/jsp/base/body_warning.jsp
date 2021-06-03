<%--
 * PROJECT：アプリ基盤 サンプルアプリケーション
 *
 * body_warning.jsp
 *
 * [EN] It is a JSP-body screen layout for warning exception.
 * [EN] As an example, we define a simple configuration layout (header, body, footer) of.
 * [EN] Depending on the requirements of each application, please use to define the layout.
 *
 * [JP] 警告例外を使用する画面レイアウトのボディ部となるJSPです。
 * [JP] サンプルとして、シンプル構成(ヘッダ、コンテンツ、フッタ)のレイアウトを定義しています。
 * [JP] 各アプリの要件に応じて、レイアウトを定義して利用してください。
 *
 *
 * Copyright (c) 2015 DENSO CORPORATION. All rights reserved.
--%>

<c:set var="warningDisplay" value="<%= request.getAttribute(Globals.WARNING_DIALOG_DISPLAY) %>" />
<c:set var="warningMessage" value="<%= request.getAttribute(Globals.WARNING_EXCEPTION_MESSAGE) %>" />
<c:set var="warningFormId" value="<%= request.getAttribute(Globals.WARNING_FORM_ID) %>" />
<c:set var="warningRetryAction" value='<%= request.getAttribute(Globals.WARNING_RETRY_ACTION) %>' />
<body onload="warningDialog('${warningDisplay}','${warningMessage}','${warningFormId}','${warningRetryAction}');" >

    <%-- for checking uploading file size --%>
    <div id="maxFileSize" style="display:none;">${maxFileSizeVar}</div>
    <div id="maxFileSizeMsg" style="display:none;"><spring:message code="AI-E0-FS00" arguments="${maxFileSizeVar}" /></div>

    <div>
        <%-- [EN] (Including the message area) header area --%>
        <%-- [JP] ヘッダーエリア(メッセージエリア含む) --%>
        <tiles:insertAttribute name="header" flush="false">
            <tiles:putAttribute name="type">
                <tiles:getAsString name="type" />
            </tiles:putAttribute>
        </tiles:insertAttribute>

        <%-- [EN] Contents area --%>
        <%-- [JP] コンテンツエリア --%>
        <tiles:insertAttribute name="contents" flush="false" />

        <%-- [EN] Footer --%>
        <%-- [JP] フッター --%>
        <tiles:insertAttribute name="footer" flush="false" />
    </div>

</body>
