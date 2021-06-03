<%--
 * PROJECT：アプリ基盤 サンプルアプリケーション
 *
 * dnkrSubBody.jsp
 *
 * [EN] It is a JSP-sub body screen layout for warning exception.
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
<link rel="stylesheet" type="text/css" href="/js/lib/assets/lib/ax5ui-autocomplete/dist/ax5autocomplete.css">
<link type="text/css" href="/css/subCommon.css" rel="stylesheet"/>
<link type="text/css" href="/css/commonGrid.css?ver" rel="stylesheet"/>
<script type="text/javascript" src="/js/lib/assets/lib/ax5ui-autocomplete/dist/ax5autocomplete.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/ai-paging_pl.js"></script>
<script type="text/javascript" src="/js/form_valid.js"></script>
<script type="text/javascript" src="/js/subCommon.js?ver"></script>
<script type="text/javascript" src="/js/commonGrid.js"></script>
<script type="text/javascript">
	 
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

	//삭제되었습니다.
	var LN_MSG_DELETE = "<spring:message code='DNKR-I0-0014'/>";
	
	//정상적으로 처리되었습니다.
	var LN_PROCESSED_OK = "<spring:message code='DNKR-I0-0015'/>";

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
	var LN_WORK_L = "<spring:message code='label.WAK001.list5'/>";
	
	//업무분류(중)
	var LN_WORK_M = "<spring:message code='label.WAK001.list6'/>";
	
	//업무분류(소)
	var LN_WORK_S = "<spring:message code='label.WAK001.list7'/>";
	
	//관련시스템
	var LN_REL_SYS = "<spring:message code='label.WAK001.list8'/>";
	
	//승인관리자 선택
	var LN_APRV_MNG = "<spring:message code='label.WAC015.gridlabel.cmcMngt'/>";
	
	//--------------------------- //Project ----------------------------------

	
</script>
<body>

<div class="doc-wrap">
	<div class="container" id="tab_container">
		<div style="display:none"><c:out value="${tabId}"></c:out></div>
		<tiles:insertAttribute name="contents" flush="false" />
		
	</div>
	<%--123 --%>
	<div class="sub-con-bg"></div>
</div>
	
</body>
