<%--
 * PROJECT：
 *
 * [KR] 품목별 입출고 조회
 * 
 * $Id$
 *
 * Copyright (c) 2017 DENSO CORPORATION. All rights reserved.
 *
--%>
<!-- [EN] Contents area -->
<!-- [JP] コンテンツエリア -->
<%-- <spring:message code="label.filename" /> : <c:out value="${url }"></c:out> --%>
<jsp:useBean id="today" class="java.util.Date" />

<link rel="stylesheet" media="all" href="/css/content.css?ver" /> 
<c:set var="gSessionId" value="${pageContext.session.id}"></c:set>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/mrp/WAN001DioneView.js"></script>
<script LANGUAGE=javascript FOR=MiPlatformCtrl EVENT=NavigateComplete( pDisp, strReqID, strServiceID, strURL )>
	//alert("NavigateComplete");
	// DoRun 할떄 한번만 발생됨 ...

	var G_ParamKey = "${gSessionId}"+"${gSessionIdValue}";
	var G_PgmUrl = "${paraDomain.pgmId}";
	
   	MiPlatformCtrl.SetGlobalVariableValue(MiPlatformCtrl.startxml,"G_ParamKey", G_ParamKey);
   	MiPlatformCtrl.SetGlobalVariableValue(MiPlatformCtrl.startxml,"G_PgmUrl", G_PgmUrl);
	MiPlatformCtrl.CallScript(MiPlatformCtrl.startxml,"setParam()");	//MiPlatformMX용
	//alert(MiPlatformCtrl.GetGlobalVariableValue(MiPlatformCtrl.startxml,"G_BtnAuth"));
	//trace(MiPlatformCtrl.GetGlobalVariableValue(MiPlatformCtrl.startxml,"G_BtnAuth"));
</script>

<!-- [EN] Contents area -->
<%-- <c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"> --%>
	<%--조회권한 --%>
	
	<form:form id="WAN001MiPlatformForm" name ="WAN001MiPlatformForm" action="${pageContext.request.contextPath}/WAN001MiPlatform/view.do?menu=${menu}&pgmId=${paraDomain.pgmId}&company=${paraDomain.company}&mode=${paraDomain.mode}" method="POST">
		<div class="searchCondition">		
			<div class="sssgap"></div>
			<div class="top-bar cb" style="height: 34px">	
				<b style="display: ${displayFlag};">
					기준 공장 : 
					<select class="locCode" autofocus="true" name="locCode"  id="locCode"  style="width:200px" title="<spring:message code='DNKR-I0-0001'/>" onchange="locationChange();">					
						<option value="C"  <c:if test="${'C' eq paraDomain.locCode}"> selected</c:if>>창원공장</option>
						<option value="S"  <c:if test="${'S' eq paraDomain.locCode}"> selected</c:if>>화성공장</option>
						<option value="H"  <c:if test="${'H' eq paraDomain.locCode}"> selected</c:if>>홍성공장</option>
					</select>
				</b>
				<div class="fr" id = "MiPlatformBtn">
					<button class="blue btn-st02 _searchBtn_" type="button" id="searchBtn">
						<span><spring:message code="label.search"/><!-- 조회 --></span>
					</button>
					<button class="gray btn-st02 addBtn" type="button" id="registerBtn">
						<span><spring:message code="label.register"/><!-- 추가 --></span>
					</button>
					<button class="red btn-st02 delBtn" type="button" id="deleteBtn">
						<span><spring:message code="label.delete"/><!-- 삭제 --></span>
					</button>
					<button class="black btn-st02 saveBtn" type="button" id="saveBtn" >
						<span><spring:message code="label.save"/><!-- 저장 --></span>
					</button>
					<button class="orange btn-st02 printBtn" type="button" id="printBtn">
						<span><spring:message code="label.print"/><!--출력 --></span>
					</button>
					<button class="green btn-st02 exel fr" type="button" id="excelBtn" style="margin-left:4px;">
						<span><spring:message code="label.excelBtn" /><!-- 엑셀 --></span>
					</button>
				</div>
		</div>
		
			<div class="sssgap"></div>
			<!--cont-->
			<div id="MiPlatformArea" class="MI">
			<TABLE  id="test" cellpadding="0" cellspacing="0" border="0" height="100%" width="100%" >
				<TR>
					<TD align="center" valign="middle">				
						<OBJECT ID="MiPlatformCtrl" width="100%" height="650px" bgcolor="red" Visible="true" CLASSID="CLSID:3F4762E6-3DBD-458C-9BE8-10C0F26C969D">
							<param NAME="AutoSize" VALUE="false">
							<param NAME="Key" VALUE="callDione">
				            <param NAME="wmode" VALUE="opaque"></param>
				            <!-- 
							<param NAME="startxml" VALUE="http://10.73.254.21/ui/denso_ci_main_Win32_Inf.xml">
							 -->
							<param NAME="startxml" VALUE="http://10.73.254.21/ui/denso_ci_main_Win32_Inf.xml">
							<param NAME="InitUrl" VALUE="Common::ContentInf.xml"> <%-- 실행PGM파일명 --%>					
						</OBJECT>
					</TD>
				</TR>
			</TABLE>
			</div>
		</div>

		<!--WAE001_wrap-->
	</form:form>
	

<%--</c:if>  --%>
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '0' }">
	<%--조회권한 --%>
	<div>
		<span><spring:message code='DNKR-E2-0000' /> <!-- 권한이 없습니다. --></span>
	</div>
</c:if>