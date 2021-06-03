<%--
 * PROJECT：アプリ基盤 サンプルアプリケーション
 *
 * dnkrBody.jsp
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
<script type="text/javascript" src="/js/commonGrid.js"></script>
<script type="text/javascript">

//kr
var LN_CHK = "<spring:message code='label.lang_chk'/>";

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
</script>
<body>

	<%-- for checking uploading file size --%>
    <div id="maxFileSize" style="display:none;">1048576</div>
    <div id="maxFileSizeMsg" style="display:none;"><spring:message code="AI-E0-FS00" arguments="1048576" /></div>
    
	<div class="doc-wrap">
		<%-- [EN] (Including the message area) header area --%>
        <%-- [JP] ヘッダーエリア(メッセージエリアを含む) --%>
        <%-- <tiles:insertAttribute name="header" flush="false">
            <tiles:putAttribute name="type">
                <tiles:getAsString name="type" />
            </tiles:putAttribute>
        </tiles:insertAttribute> --%>

        
		<tiles:insertAttribute name="contents" flush="false" />
		
       	<%-- [EN] Footer --%>
        <%-- [JP] フッター --%>
        <%-- <tiles:insertAttribute name="footer" flush="false" /> --%>
	</div>
	
</body>
