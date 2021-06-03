<%--
 * PROJECT：
 *
 * [KR] 종합정보-판매정보-출하매출현황
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
<style>
[data-ax5grid-container="root"] [data-ax5grid-panel-scroll="body"] table tr>td:FIRST-CHILD
	{
	cursor: text;
	box-shadow: inset 0 0 0 0 transparent;
	background-color: transparent;
	border-radius: inherit;
	border-bottom: 1px solid #ccc !important;
	border-right: 1px solid #ccc !important;
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/dwh/WAE037DupPartCheck.js"></script>
<!-- [EN] Contents area -->
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }">
	<%--조회권한 --%>
	<form:form>
		<div class="searchCondition">
			
			<div class="sssgap"></div>
			<div class="top-bar cb">
				<!-- 사업부 선택해주세요 -->
				<!-- 
				<strong class="pr5">사업부</strong> <select name="comps"
					id="comps">
					<c:if test="${fn:length(codeList) > 0}">
						<c:forEach var="codeD2Domain" items="${codeList}"
							varStatus="status">
							<option value="${codeD2Domain.code2}"><c:out
									value="${codeD2Domain.code_name}" /></option>
						</c:forEach>
							<option value="" selected><c:out value="전체"/></option>
					</c:if>
				</select>
				 -->
				<!-- 사업장을 선택해주세요 -->
				<strong class="pr5"><spring:message code='label.comps'/><%-- 공장 --%></strong>
				
				 <select class="locCode" autofocus="true" name="locCode"  id="locCode"  style="width:99.2px" title="<spring:message code='DNKR-I0-0001'/>" onchange="commonClear()">
					<option value="LOC000004">구KE</option>
					<option value="LOC000001">구KA</option>
				</select>
				
				<div class="fr">
					<button class="blue btn-st02 _searchBtn_" type="button">
						<span><spring:message code="label.search"/><!-- 조회 --></span>
					</button>
					<button class="green btn-st02 exel fr" type="button" name="Search" style="margin-left:10px;">
						<span><spring:message code="label.excelBtn" /><!-- 엑셀 --></span>
					</button>
				</div>

			</div>
			<div class="sssgap"></div>
			<!--cont-->
			<div class="fl total">
				<strong>Total : <span class="total">0</span></strong>
			</div>
			
			<div class="sssgap"></div>
			<div style="position: relative; height: 650px;" id="grid-parent">
				<div data-ax5grid="unit-grid"
					data-ax5grid-config="{
				                    showLineNumber: true,
				                    lineNumberColumnWidth: 40}"
					style="height: 100%;"></div>
			</div>
		</div>
		<!--WAE001_wrap-->
	</form:form>

</c:if>
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '0' }">
	<%--조회권한 --%>
	<div>
		<span><spring:message code='DNKR-E2-0000' /> <!-- 권한이 없습니다. --></span>
	</div>
</c:if>