<%--
 * dnkrBase.jsp
 *
 * [EN] It is a JSP-based screen layout which is the lowest level of all.
 * [EN] As an example, we define a simple configuration layout (header, body, footer) of.
 * [EN] Depending on the requirements of each application, please use to define the layout.
 *
 * [JP] すべての画面レイアウトの最下層となるベースのJSPです。
 * [JP] サンプルとして、シンプル構成(ヘッダ、ボディ、フッタ)のレイアウトを定義しています。
 * [JP] 各アプリの要件に応じて、レイアウトを定義して利用してください。
 *
 * $ base.jsp 1753 2015-07-03 00:24:13Z 815372040074 $
 *
 * Copyright (c) 2012 DENSO CORPORATION. All rights reserved.
--%>

<%-- [EN] Variable definition -----------------------------------------------------%>
<%-- [JP] 変数定義 ----------------------------------------------------------------%>

<%-- for checking uploading file size --%>
<c:set var="maxFileSizeVar">
    <c:catch>
        <spring:message code="<%= Globals.MIYABI_CONSTANTS_KEY_FILEUPLOAD_MAXSIZE %>" />
    </c:catch>
</c:set>

<%-- [EN] Table width (used by jquery.tablefix_1.0.1.js) --%>
<%-- [JP] テーブル幅 (jquery.tablefix_1.0.1.js から利用) --%>
<c:choose>
    <c:when test="${type == 'menu' || type == 'main'}">
        <c:set var="tableWidth" scope="request">980px</c:set>
    </c:when>
    <c:otherwise>
        <c:set var="tableWidth" scope="request">100%</c:set>
    </c:otherwise>
</c:choose>

<%-- [EN] Screen drawing ----------------------------------------------------------------%>
<%-- [JP] 画面描画 ----------------------------------------------------------------%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<meta http-equiv="X-UA-Compatible" content="IE=Edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
		
		<%-- [EN] Title  --%>
        <%-- [JP] タイトル  --%>
		<title><spring:message code="label.system.name" /></title>
		<link type="text/css" href="/js/lib/axisj/ui/arongi/AXJ.min.css" rel="stylesheet">
		<link type="text/css" href="/js/lib/assets/lib/ax5ui-calendar/dist/ax5calendar.css" rel="stylesheet">
		<link type="text/css" href="/js/lib/assets/lib/ax5ui-mask/dist/ax5mask.css" rel="stylesheet"/>
		<link type="text/css" href="/js/lib/assets/lib/ax5ui-toast/dist/ax5toast.css" rel="stylesheet">
		
		<%-- CSS --%>
	    <!-- <link type="text/css" href="/js/lib/assets/css/docs.css" rel="stylesheet"> -->
        <!-- <link type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css" rel="stylesheet"> -->
        <!-- <link type="text/css" href="/css/font-awesome.min.css" rel="stylesheet">
        <link type="text/css" href="/js/lib/axisj/ui/arongi/page.css" rel="stylesheet"/>
        <link type="text/css" href="/js/lib/axisj/ui/arongi/AXJ.min.css" rel="stylesheet">
        <link type="text/css" href="/js/lib/assets/lib/ax5ui-toast/dist/ax5toast.css" rel="stylesheet">
        <link type="text/css" href="/js/lib/assets/lib/ax5ui-mask/dist/ax5mask.css" rel="stylesheet"/>
        <link type="text/css" href="/js/lib/assets/lib/ax5ui-calendar/dist/ax5calendar.css" rel="stylesheet">
		<link type="text/css" href="/js/lib/assets/lib/ax5ui-picker/dist/ax5picker.css" rel="stylesheet">
		<link type="text/css" href="/js/lib/assets/lib/ax5ui-select/dist/ax5select.css" rel="stylesheet"> 
		<link type="text/css" href="/js/lib/assets/lib/ax5ui-menu/dist/ax5menu.css" rel="stylesheet">
        <link type="text/css" href="/js/lib/assets/lib/ax5ui-grid/dist/ax5grid.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="/js/lib/assets/lib//ax5ui-calendar/dist/ax5calendar.css">
        <link type="text/css" href="/js/lib/axisj/axicon/axicon.min.css" rel="stylesheet">
        <link type="text/css" href="/css/jquery.mCustomScrollbar.css" rel="stylesheet" /> -->
        <link media="all" href="/css/m/common.css" rel="stylesheet"/>
        <link media="all" href="/css/m/defalut.css" rel="stylesheet"/>
		<link media="all" href="/css/m/layout.css?ver=1" rel="stylesheet"/> 
		<link media="all" href="/css/m/main.css" rel="stylesheet"/>
		<link media="all" href="/css/m/slick.css" rel="stylesheet"/>
		<link media="all" href="/css/m/slick-theme.css" rel="stylesheet"/>
        
		<%-- JavaScript --%>
		<script type="text/javascript" src="/js/jquery-2.1.3.min.js"></script>
		<script type="text/javascript" src="/js/m/jquery.easing.1.3.js"></script>
		<!-- <script type="text/javascript" src="/js/jquery.mCustomScrollbar.concat.min.js"></script> -->
		
		<script type="text/javascript" src="/js/lib/assets/lib/ax5core/dist/ax5core.min.js"></script>
		<script type="text/javascript" src="/js/lib/assets/lib/ax5ui-calendar/dist/ax5calendar.min.js"></script>
		<script type="text/javascript" src="/js/lib/assets/lib/ax5ui-mask/dist/ax5mask.min.js"></script>
		<script type="text/javascript" src="/js/lib/axisj/dist/AXJ.min.js"></script>
		<script type="text/javascript" src="/js/lib/assets/lib/ax5ui-toast/dist/ax5toast.min.js"></script>
		<%-- JavaScript (Library) --%>
		<!--<script type="text/javascript" src="/js/lib/axisj/lib/AXConfig.js"></script> 
		<script type="text/javascript" src="/js/lib/axisj/dist/AXJ.min.js"></script>
		<script type="text/javascript" src="/js/lib/axisj/lib/AXTab.js"></script>
		<script type="text/javascript" src="/js/lib/assets/js/docs.js"></script>
		<script type="text/javascript" src="/js/lib/assets/lib/bootstrap/dist/js/bootstrap.min.js"></script>
	    <script type="text/javascript" src="/js/lib/assets/lib/ax5core/dist/ax5core.min.js"></script>
		<script type="text/javascript" src="/js/lib/assets/lib/ax5ui-toast/dist/ax5toast.min.js"></script>	
		<script type="text/javascript" src="/js/lib/assets/lib/ax5ui-mask/dist/ax5mask.min.js"></script>
		<script type="text/javascript" src="/js/lib/assets/lib/ax5ui-calendar/dist/ax5calendar.min.js"></script>
		<script type="text/javascript" src="/js/lib/assets/lib/ax5ui-picker/dist/ax5picker.min.js"></script>
		<script type="text/javascript" src="/js/lib/assets/lib/ax5ui-formatter/dist/ax5formatter.min.js"></script>
		<script type="text/javascript" src="/js/lib/assets/lib/ax5ui-select/dist/ax5select.min.js"></script>
		<script type="text/javascript" src="/js/lib/assets/lib/ax5ui-menu/dist/ax5menu.min.js"></script>
		<script type="text/javascript" src="/js/lib/assets/lib/ax5ui-grid/dist/ax5grid.js"></script>
		<script type="text/javascript" src="/js/lib/assets/lib/ax5ui-calendar/dist/ax5calendar.min.js"></script>
        <script type="text/javascript" src="/js/lib/ai-allbuttoninactivate_pl.js"></script> -->
		
		<%-- JavaScript (Application Common) --%>
		<script type="text/javascript" src="/js/ai.js"></script>
		<script type="text/javascript" src="/js/common.js"></script>
		<script type="text/javascript" src="/js/common_const.js"></script>
		<script type="text/javascript" src="/js/m/slick.js"></script>
		<script type="text/javascript" src="/js/m/jquery.mousewheel.js"></script>
		<script type="text/javascript" src="/js/m/main.js"></script>
		
		<link rel="stylesheet" type="text/css" href="/js/lib/assets/lib/ax5ui-autocomplete/dist/ax5autocomplete.css">
<link type="text/css" href="/css/subCommon.css" rel="stylesheet"/>
<link type="text/css" href="/css/commonGrid.css?ver" rel="stylesheet"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/ai-paging_pl.js"></script>
<script type="text/javascript" src="/js/form_valid.js"></script>
<!-- <script type="text/javascript" src="/js/subCommon.js"></script> -->
<script type="text/javascript" src="/js/commonGrid.js"></script>

<script type="text/javascript">
	var mask = window.mask;	 
	
	var check = true;
	
	//kr
	var LN_CHK = "<spring:message code='label.lang_chk'/>";
	
	//사업부를 선택해주세요.
	var LN_SELECT_CLS_CODE = "<spring:message code='DNKR-I0-0000'/>";
	
	//사업장을 선택해주세요.
	var LN_SELECT_LOC_CODE = "<spring:message code='DNKR-I0-0001'/>";
	
	//사업부서(팀)을 선택해주세요.
	var LN_SELECT_TEAM_CODE = "<spring:message code='DNKR-I0-0002'/>";
	
	//사업부를 입력해주세요.
	var LN_INSERT_CLS_CODE = "<spring:message code='DNKR-I0-0006'/>";

	//삭제
	var LN_DELETE = "<spring:message code='label.delete'/>";
	
	//저장
	var LN_SAVE = "<spring:message code='label.save'/>";
	
	//수정
	var LN_MODIFY = "<spring:message code='label.modify'/>";
	
	//등록버튼을 눌러주세요.
	var LN_PRESS_REGISTERBTN = "<spring:message code='label.press_registerBtn'/>";
	
	//상위코드를 선택하지 않으셨습니다.
	var LN_NO_SELECT_PARENTCODE = "<spring:message code='label.no_select_parentCode'/>";
	
	//저장하시겠습니까?
	var LN_CONFIRM_SAVE = "<spring:message code='label.confirm_save'/>";
	
	//삭제하시겠습니까?
	var LN_CONFIRM_DELETE = "<spring:message code='label.confirm_delete'/>";
	
	//데이터가 없습니다
	var LN_NO_DATA = "<spring:message code='label.no_data'/>";
	
	//--------------------------- Menu ----------------------------------
	//하위메뉴가 존재합니다.
	var LN_EXIST_SUBMENU = "<spring:message code='label.exist_submenu'/>";
	//--------------------------- //Menu ----------------------------------
	
	//--------------------------- Calendar ----------------------------------
	var MONTH = [
				"<spring:message code='label.jan'/>",
				"<spring:message code='label.feb'/>",
				"<spring:message code='label.mar'/>",
				"<spring:message code='label.apr'/>",
				"<spring:message code='label.may'/>",
				"<spring:message code='label.jun'/>",
				"<spring:message code='label.jul'/>",
				"<spring:message code='label.aug'/>",
				"<spring:message code='label.sep'/>",
				"<spring:message code='label.oct'/>",
				"<spring:message code='label.nov'/>",
				"<spring:message code='label.dec'/>",
	             ];
	var YEAR_FORMAT = "%s<spring:message code='label.year'/>";
	
	//--------------------------- // Calendar ----------------------------------
	
	//--------------------------- Project ----------------------------------
	
	//업무분류(대)
	var LN_WORK_L = "<spring:message code="label.WAK001.list5"/>";
	
	//업무분류(중)
	var LN_WORK_M = "<spring:message code="label.WAK001.list6"/>";
	
	//업무분류(소)
	var LN_WORK_S = "<spring:message code="label.WAK001.list7"/>";
	
	//관련시스템
	var LN_REL_SYS = "<spring:message code="label.WAK001.list8"/>";
	
	//승인관리자 선택
	var LN_APRV_MNG = "<spring:message code="label.WAC015.gridlabel.cmcMngt"/>";
	
	//--------------------------- //Project ----------------------------------
	var tabResize = function() {
		
	}
	

</script>
	</head>

	<%-- [EN] Body area --%>
    <%-- [JP] ボディエリア --%>
	<tiles:insertAttribute name="bodyM" flush="false" />

</html>