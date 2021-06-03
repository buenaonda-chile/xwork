<%--
 * Project :
 *
 * [EN] It is a JSP-based screen layout which is the lowest level of all.
 * [EN] As an example, we define a simple configuration layout (header, body, footer) of.
 * [EN] Depending on the requirements of each application, please use to define the layout.
 *
 * [JP] すべての画面レイアウトの最下層となるベースのJSPです。
 * [JP] サンプルとして、シンプル構成(ヘッダ、ボディ、フッタ)のレイアウトを定義しています。
 * [JP] 各アプリの要件に応じて、レイアウトを定義して利用してください。
 *
 * $ base.jsp 2516 2016-07-22 02:08:12Z 10088DS00879 $
 *
 * Copyright (c) 2015 DENSO IT SOLUTIONS. All rights reserved.
--%>

<%-- [EN] Variable definition --%>
<%-- [JP] 変数定義 --%>

<%-- for checking uploading file size --%>
<c:set var="maxFileSizeVar">
	<c:catch>
		<spring:message code="<%= Globals.MIYABI_CONSTANTS_KEY_FILEUPLOAD_MAXSIZE %>" />
	</c:catch>
</c:set>

<%-- [EN] Screen type (defined in tiles-defs.xml) --%>
<%-- [JP] 画面種別 (tiles-defs.xmlに定義) --%>
<tilesx:useAttribute id="tilesType" name="type" classname="java.lang.String"/>

<%-- [EN] User login info --%>
<%-- [JP] User login info --%>
<sec:authentication property="principal" var="userStore" scope="session"/>

<%-- [EN] Screen drawing --%>
<%-- [JP] 画面描画 --%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<meta http-equiv="X-UA-Compatible"  content="IE=Edge" />
	<meta http-equiv="Pragma"           content="no-cache" />
	<meta http-equiv="Cache-Control"    content="no-cache, no-store" />
	<meta http-equiv="Expires"          content="-1" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta name="author" content="DENSO DICAS" />
	<meta name="keywords" content="DENSO DICAS" />
	<meta name="description" content="DENSO DICAS" />

	<%-- [EN] Title  --%>
	<%-- [JP] タイトル  --%>
	<title><spring:message code="title.dnkr" /> &gt; <spring:message code="title.dicas" /></title>

	<%-- Css --%>
	<link rel="stylesheet" type="text/css" href="<c:url value="/assets/js/ax5ui/ax5ui-kernel/dist/ax5ui.all.css"/>" />

	<link rel="stylesheet" type="text/css" href="<c:url value="/assets/js/kendo-2018.3.1017/css/mobile/kendo.mobile.all.min.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value="/assets/js/kendo-2018.3.1017/css/mobile/kendo.mobile.common.min.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value="/assets/js/kendo-2018.3.1017/css/mobile/kendo.dataviz.mobile.min.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/kendo-reset.css"/>" />

	<link type="text/css" rel="stylesheet" href="<c:url value="/assets/mobile/css/define/jquery-ui.css"/>" />
	<link type="text/css" rel="stylesheet" href="<c:url value="/assets/mobile/css/font.css"/>" />
	<link type="text/css" rel="stylesheet" href="<c:url value="/assets/mobile/css/lib.css"/>" />
	<link type="text/css" rel="stylesheet" href="<c:url value="/assets/mobile/css/layout.css"/>" />
	<link type="text/css" rel="stylesheet" href="<c:url value="/assets/mobile/css/template.css"/>" />
	<link type="text/css" rel="stylesheet" href="<c:url value="/assets/mobile/css/content.css"/>" />
	<c:if test="${_editor_ == 'tui.viewer'}">
		<link rel="stylesheet" href="<c:url value="/assets/js/editor/tui-editor/dist/tui-editor-contents.min.css"/>" />
	</c:if>
	<%--// Css --%>

	<%-- Javascript --%>
	<script type="text/javascript" src="<c:url value="/assets/mobile/js/define/jquery-1.12.4.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/assets/mobile/js/define/jquery.easing.1.3.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/assets/mobile/js/define/jquery-ui.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/assets/mobile/js/lib_fnc.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/assets/mobile/js/lib.js"/>"></script>

	<script type="text/javascript" src="<c:url value="/assets/js/kendo-2018.3.1017/js/kendo.all.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/assets/js/kendo-2018.3.1017/js/kendo.timezones.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/assets/js/kendo-2018.3.1017/js/cultures/kendo.culture.ko-KR.min.js"/>"></script>

	<script type="text/javascript" src="<c:url value="/assets/js/libphonenumber-js.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/assets/js/moment.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/assets/js/moment.timezone.js"/>"></script>

	<script type="text/javascript" src="<c:url value="/assets/js/ax5ui/ax5ui-kernel/dist/ax5ui.all.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/assets/js/subcommon.js"/>"></script>
	<c:if test="${_editor_ == 'tui.viewer'}">
		<script type="text/javascript" src="<c:url value="/assets/js/editor/markdown-it/dist/markdown-it.min.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/assets/js/editor/to-mark/dist/to-mark.min.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/assets/js/editor/tui-code-snippet/dist/tui-code-snippet.min.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/assets/js/editor/codemirror/lib/codemirror.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/assets/js/editor/highlightjs/highlight.pack.min.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/assets/js/editor/squire-rte/build/squire-raw.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/assets/js/editor/tui-editor/dist/tui-editor-Viewer.min.js"/>"></script>
	</c:if>
	<%--// Javascript --%>

	<script type="text/javascript">
    var DICAS_URL = "${pageContext.request.contextPath}";
	</script>

</head>
<body>
<%--◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇ #container ◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇--%>
<div id="container">
	<tiles:insertAttribute name="header" flush="false" />
	<tiles:insertAttribute name="body" flush="false" />
</div>
<%--// ◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇ #container ◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇--%>
<%-- for checking uploading file size --%>
<div id="maxFileSize" style="display:none;">${maxFileSizeVar}</div>
<div id="maxFileSizeMsg" style="display:none;"><spring:message code="AI-E0-FS00" arguments="${maxFileSizeVar}"/></div>
<script id="alertTemplate" type="text/x-kendo-template">
	<div id='alertPopupLayer' class='layerpopup' style='display:block'>
		<div class="bg"></div>
		<div class='wrap1' style='margin-left:-150px;margin-top:-120px;width:#= width #;height:#= height #;'>
			<h2>#= title #</h2>
			<a class='b1 layer_close close' data-bind="click: _cancel">창닫기</a>
			<div class='popup_body'>
				<p style='text-align: center;'>#= message #</p>
				<div class='btns tac'>
					<button type='button' class='button submit' data-bind='click: _confirm'>확인</button>
				</div>
			</div>
		</div>
	</div>
</script>
<script id="confirmTemplate" type="text/x-kendo-template">
	<div id='confirmPopupLayer' class='layerpopup' style='display:block'>
		<div class="bg"></div>
		<div class='wrap1' style='margin-left:-150px;margin-top:-120px;width:#= width #;height:#= height #;'>
			<h2>#= title #</h2>
			<a class='b1 layer_close close' data-bind="click: _cancel">창닫기</a>
			<div class='popup_body'>
				<p style='text-align: center;'>#= message #</p>
				<div class='btns tac'>
					<button type='button' class='button submit' data-bind='click: _confirm'>확인</button>
					<button type='button' class='button' data-bind='click: _cancel'>취소</button>
				</div>
			</div>
		</div>
	</div>
</script>
</body>
</html>