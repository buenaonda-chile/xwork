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

	<%-- [EN] Title  --%>
	<%-- [JP] タイトル  --%>
	<title><spring:message code="title.dnkr" /> &gt; <spring:message code="title.dicas" /></title>

	<%-- CSS --%>
	<c:choose>
		<c:when test="${tilesType == 'main' || tilesType == 'sub' || tilesType == 'modeless'}">
			<link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/font-awesome.css"/>" />
			<link type="text/css" href="<c:url value="/assets/js/axisj/ui/arongi/page.css"/>" rel="stylesheet"/>
			<link type="text/css" href="<c:url value="/assets/js/axisj/ui/arongi/AXJ.min.css"/>" rel="stylesheet">
			<link type="text/css" href="<c:url value="/assets/js/axisj/axicon/axicon.min.css"/>" rel="stylesheet" />
			<link type="text/css" href="<c:url value="/assets/js/ax5ui/ax5ui-kernel/dist/ax5ui.all.css"/>" rel="stylesheet">
			<link type="text/css" href="<c:url value="/assets/css/messageArea.css"/>" rel="stylesheet" />
			<link type="text/css" href="<c:url value="/assets/css/jquery.mCustomScrollbar.css"/>" rel="stylesheet" />
			<link type="text/css" href="<c:url value="/assets/css/common.css"/>" rel="stylesheet" />
			<link type="text/css" href="<c:url value="/assets/css/layout.css"/>" rel="stylesheet" />
			<c:if test="${tilesType == 'main'}">
				<link type="text/css" href="<c:url value="/assets/css/main.css"/>" rel="stylesheet" />
				<link rel="stylesheet" type="text/css" href="/assets/css/font-awesome.css" />
				<link rel="stylesheet" type="text/css" href="/assets/css/font.css"/>
				<link rel="stylesheet" type="text/css" href="/assets/css/lib.css"/>
				<link rel="stylesheet" type="text/css" href="/assets/css/sub-layout.css"/>
				<link rel="stylesheet" type="text/css" href="/assets/css/content.css"/>
				<link rel="stylesheet" type="text/css" href="/assets/css/template.css"/>
				<link rel="stylesheet" type="text/css" href="/assets/css/main2018.css"/>
			</c:if>
			<c:if test="${tilesType == 'modeless'}">
				<%--<link type="text/css" href="<c:url value="/assets/css/bootstrap.css"/>" rel="stylesheet" />--%>
				<link type="text/css" href="<c:url value="/assets/js/ax5ui/ax5ui-autocomplete/dist/ax5autocomplete.css" />" rel="stylesheet"/>
			</c:if>

			<%-- JavaScript --%>
			<script type="text/javascript" src="<c:url value="/assets/js/jquery-2.1.3.min.js"/>"></script>
			<script type="text/javascript" src="<c:url value="/assets/js/fileUploadCheck.js"/>"></script>
			<script type="text/javascript" src="<c:url value="/assets/js/warningDialog.js"/>"></script>
			<script type="text/javascript" src="<c:url value="/assets/js/jquery.mCustomScrollbar.concat.min.js"/>"></script>
			<script type="text/javascript" src="<c:url value="/assets/js/bootstrap.min.js"/>"></script>

			<%--<script type="text/javascript" src="<c:url value="/assets/js/axisj/lib/AXConfig.js"/>"></script>--%>
			<script type="text/javascript" src="<c:url value="/assets/js/axisj/dist/AXJ.coremin.js"/>"></script>
			<script type="text/javascript" src="<c:url value="/assets/js/axisj/lib/AXTab.js"/>"></script>
			<script type="text/javascript" src="<c:url value="/assets/js/ax5ui/ax5ui-kernel/dist/ax5ui.all.min.js"/>"></script>
			<script type="text/javascript" src="<c:url value="/assets/js/common.js"/>"></script>
			<c:if test="${tilesType == 'modeless'}">
				<script type="text/javascript" src="<c:url value="/assets/js/ax5ui/ax5ui-autocomplete/dist/ax5autocomplete.min.js"/>"></script>
			</c:if>
		</c:when>
		<c:otherwise>
			<link rel="stylesheet" type="text/css" href="<c:url value="/assets/js/ax5ui/ax5ui-kernel/dist/ax5ui.all.css"/>" />
			<%-- kendoui css --%>
			<link rel="stylesheet" type="text/css" href="<c:url value="/assets/js/kendo-2018.3.1017/css/web/kendo.common.min.css"/>" />
			<link rel="stylesheet" type="text/css" href="<c:url value="/assets/js/kendo-2018.3.1017/css/web/kendo.rtl.min.css"/>" />
			<link rel="stylesheet" type="text/css" href="<c:url value="/assets/js/kendo-2018.3.1017/css/web/kendo.default.min.css"/>" />
			<link rel="stylesheet" type="text/css" href="<c:url value="/assets/js/kendo-2018.3.1017/css/web/kendo.default.mobile.min.css"/>" />
			<link rel="stylesheet" type="text/css" href="<c:url value="/assets/js/kendo-2018.3.1017/css/dataviz/kendo.dataviz.min.css"/>" />
			<link rel="stylesheet" type="text/css" href="<c:url value="/assets/js/kendo-2018.3.1017/css/dataviz/kendo.dataviz.default.min.css"/>" />
			<link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/kendo-reset.css"/>" />

			<link rel="stylesheet" type="text/css" href="<c:url value="/assets/js/jqgrid-4.6.0/css/ui.jqgrid.css"/>" />
			<link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/ui.jqgrid-reset.css"/>" />
			<link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/bootstrap.min.css"/>" />
			<link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/bootstrap-reset.css"/>" />
			<link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/jquery-ui.css"/>" />
			<link rel="stylesheet" type="text/css" href="<c:url value="/assets/js/tui-grid/tui-grid.css"/>"/>
			<link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/tui-grid-reset.css"/>"/>
			<link rel="stylesheet" type="text/css" href="<c:url value="/assets/js/tui-pagination/tui-pagination.css"/>"/>
			<link rel="stylesheet" type="text/css" href="<c:url value="/assets/js/tui-tree/tui-tree.css"/>"/>
			<c:if test="${_editor_ == 'tui.editor'}">
				<link rel="stylesheet" href="<c:url value="/assets/js/editor/codemirror/lib/codemirror.css"/>" />
				<link rel="stylesheet" href="<c:url value="/assets/js/editor/highlightjs/styles/github.css"/>" />
				<link rel="stylesheet" href="<c:url value="/assets/js/editor/tui-editor/dist/tui-editor.min.css"/>" />
				<link rel="stylesheet" href="<c:url value="/assets/js/editor/tui-editor/dist/tui-editor-contents.min.css"/>" />
			</c:if>
			<c:if test="${_editor_ == 'tui.viewer'}">
				<link rel="stylesheet" href="<c:url value="/assets/js/editor/tui-editor/dist/tui-editor-contents.min.css"/>" />
			</c:if>
			<link rel="stylesheet" type="text/css" href="<c:url value="/assets/js/tags-input/jquery.tagsinput.css"/>" />

			<link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/font-awesome.css"/>" />
			<link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/font.css"/>"/>
			<link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/lib.css"/>"/>
			<link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/sub-layout.css"/>"/>
			<link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/content.css"/>"/>
			<link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/template.css"/>"/>

			<script type="text/javascript" src="<c:url value="/assets/js/kendo-2018.3.1017/js/jquery.min.js"/>"></script>
			<script type="text/javascript" src="<c:url value="/assets/js/underscore/underscore-min.js"/>"></script>
			<script type="text/javascript" src="<c:url value="/assets/js/backbone/backbone-min.js"/>"></script>
			<script type="text/javascript" src="<c:url value="/assets/js/jquery.mockjax.min.js"/>"></script>
			<script type="text/javascript" src="<c:url value="/assets/js/fileUploadCheck.js"/>"></script>
			<script type="text/javascript" src="<c:url value="/assets/js/warningDialog.js"/>"></script>
			<script type="text/javascript" src="<c:url value="/assets/js/jquery.mCustomScrollbar.concat.min.js"/>"></script>
			<script type="text/javascript" src="<c:url value="/assets/js/bootstrap.min.js"/>"></script>
			<script src="<c:url value="/assets/js/kendo-2018.3.1017/js/kendo.all.min.js"/>"></script>
			<script src="<c:url value="/assets/js/kendo-2018.3.1017/js/kendo.timezones.min.js"/>"></script>
			<script src="<c:url value="/assets/js/kendo-2018.3.1017/js/cultures/kendo.culture.ko-KR.min.js"/>"></script>

			<script type="text/javascript" src="<c:url value="/assets/js/tui-code-snippet/tui-code-snippet.min.js"/>"></script>
			<script type="text/javascript" src="<c:url value="/assets/js/tui-pagination/tui-pagination.min.js"/>"></script>
			<script type="text/javascript" src="<c:url value="/assets/js/tui-grid/tui-grid.js"/>"></script>
			<script type="text/javascript" src="<c:url value="/assets/js/tui-tree/tui-tree.js"/>"></script>
			<c:if test="${_editor_ == 'tui.editor'}">
				<script type="text/javascript" src="<c:url value="/assets/js/editor/markdown-it/dist/markdown-it.min.js"/>"></script>
				<script type="text/javascript" src="<c:url value="/assets/js/editor/to-mark/dist/to-mark.min.js"/>"></script>
				<script type="text/javascript" src="<c:url value="/assets/js/editor/tui-code-snippet/dist/tui-code-snippet.min.js"/>"></script>
				<script type="text/javascript" src="<c:url value="/assets/js/editor/codemirror/lib/codemirror.js"/>"></script>
				<script type="text/javascript" src="<c:url value="/assets/js/editor/highlightjs/highlight.pack.min.js"/>"></script>
				<script type="text/javascript" src="<c:url value="/assets/js/editor/squire-rte/build/squire-raw.js"/>"></script>
				<script type="text/javascript" src="<c:url value="/assets/js/editor/tui-editor/dist/tui-editor-Editor.min.js"/>"></script>
			</c:if>
			<c:if test="${_editor_ == 'tui.viewer'}">
				<script type="text/javascript" src="<c:url value="/assets/js/editor/markdown-it/dist/markdown-it.min.js"/>"></script>
				<script type="text/javascript" src="<c:url value="/assets/js/editor/to-mark/dist/to-mark.min.js"/>"></script>
				<script type="text/javascript" src="<c:url value="/assets/js/editor/tui-code-snippet/dist/tui-code-snippet.min.js"/>"></script>
				<script type="text/javascript" src="<c:url value="/assets/js/editor/codemirror/lib/codemirror.js"/>"></script>
				<script type="text/javascript" src="<c:url value="/assets/js/editor/highlightjs/highlight.pack.min.js"/>"></script>
				<script type="text/javascript" src="<c:url value="/assets/js/editor/squire-rte/build/squire-raw.js"/>"></script>
				<script type="text/javascript" src="<c:url value="/assets/js/editor/tui-editor/dist/tui-editor-Viewer.min.js"/>"></script>
			</c:if>

			<script type="text/javascript" src="<c:url value="/assets/js/libphonenumber-js.min.js"/>"></script>
			<script type="text/javascript" src="<c:url value="/assets/js/moment.min.js"/>"></script>
			<script type="text/javascript" src="<c:url value="/assets/js/moment.timezone.js"/>"></script>

			<script type="text/javascript" src="<c:url value="/assets/js/ax5ui/ax5ui-kernel/dist/ax5ui.all.min.js"/>"></script>
			<script type="text/javascript" src="<c:url value="/assets/js/subcommon.js"/>"></script>
			<script type="text/javascript" src="<c:url value="/assets/js/tags-input/jquery.tagsinput.js"/>"></script>
			<script type="text/javascript" src="<c:url value="/assets/js/jquery-ui.js"/>"></script>
		</c:otherwise>
	</c:choose>

	<!--[if lt IE 9]>
	<script type="text/javascript" src="<c:url value="/assets/js/html5shiv.min.js"/>"></script>
	<![endif]-->


	<script type="text/javascript">
    var DICAS_URL = "${pageContext.request.contextPath}";
	</script>
</head>
<body>
<c:choose>
	<c:when test="${tilesType == 'main' || tilesType == 'sub'}">
		<div class="doc-wrap" id="docBaseWrap">
				<%-- [EN] (Including the message area) header area --%>
				<%-- [JP] ヘッダエリア(メッセージエリア含む) --%>
			<tiles:insertAttribute name="header" flush="false" />

				<%-- [EN] Contents area --%>
				<%-- [JP] コンテンツエリア --%>
			<tiles:insertAttribute name="body" flush="false" />

				<%-- [EN] Footer --%>
				<%-- [JP] フッタ --%>
				<%--<tiles:insertAttribute name="footer" flush="false" />--%>
		</div>
	</c:when>
	<c:when test="${tilesType == 'modal'}">
		<div class="popup1">
			<tiles:insertAttribute name="contents" flush="false"/>
		</div>
	</c:when>
	<c:otherwise>
		<div class="doc-wrap">
			<div class="body" id="tab_container">
				<div id="body_cotent">
					<tiles:insertAttribute name="contents" flush="false" />
				</div>
			</div>
		</div>
	</c:otherwise>
</c:choose>
<%-- for checking uploading file size --%>
<div id="maxFileSize" style="display:none;">${maxFileSizeVar}</div>
<div id="maxFileSizeMsg" style="display:none;"><spring:message code="AI-E0-FS00"
																															 arguments="${maxFileSizeVar}"/></div>
</body>
<c:if test="${tilesType == 'main' || tilesType == 'sub'}">
	<script type="text/javascript" src="<c:url value="/assets/js/layout.js"/>"></script>
</c:if>
</html>