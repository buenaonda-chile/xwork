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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/dwh/WAE035MonthlyShipmentCheckList.js"></script>
<!-- [EN] Contents area -->
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }">
	<%--조회권한 --%>
	<form:form>
		<div class="searchCondition">
			
			<div class="sssgap"></div>
			<div class="top-bar cb">				
				<!-- 사업부를 선택해주세요 -->
				<strong class="pr5"><spring:message code="label.WAB002.clsCode"/></strong> <select name="company"
					id="company" onchange="commonClear()">
					<c:if test="${fn:length(codeList2) > 0}">
						<c:forEach var="codeD2Domain2" items="${codeList2}"
							varStatus="status">
							<option value="${codeD2Domain2.code1}"><c:out
									value="${codeD2Domain2.code_name}" /></option>
						</c:forEach>
					</c:if>
				</select>			
				<!-- 사업장를 선택해주세요 -->
				<%-- 				
				<strong class="pr5"><spring:message code="label.WAB002.locCode"/></strong> <select name="comps"
					id="comps">
					<c:if test="${fn:length(codeList) > 0}">
						<c:forEach var="codeD2Domain" items="${codeList}"
							varStatus="status">
							<option value="${codeD2Domain.code2}"><c:out
									value="${codeD2Domain.code_name}" /></option>
						</c:forEach>
					</c:if>
				</select>
				 --%>
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