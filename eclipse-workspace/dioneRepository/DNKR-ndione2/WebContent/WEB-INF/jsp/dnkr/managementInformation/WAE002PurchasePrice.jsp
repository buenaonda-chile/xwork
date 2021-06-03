<%--
 * PROJECT：
 *
 * [KR] 
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
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/dwh/WAE002PurchasePrice.js"></script>
<!-- [EN] Contents area -->
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }">
	<%--조회권한 --%>
	<form:form>
		<div class="searchCondition">

			<div class="top-bar cb">
				<strong class="pr5">사업부</strong> 
				<select autofocus="true" name="comps" id="ComboBoxPlant" dataSet="ds_ComCode_PLNT">
					<c:if test="${fn:length(codeList) > 0}">
						<c:forEach var="codeD2Domain" items="${codeList}" varStatus="status">
							<option value="${codeD2Domain.code2}"><c:out value="${codeD2Domain.code_name}" /></option>
						</c:forEach>
					</c:if>
				</select>
				<!-- 조회년도를 선택해주세요 -->
				<div class="date-inwrap" data-ax5picker="basic"
					style="width: 140px;">
					<span class="calendar_icon_b vcen2 c1"></span> <input type="text"
						name="year" id="year" style="width: 140px; padding: 0 40px"
						placeholder="yyyy" data-picker-date="year"
						value='<fmt:formatDate value="${today}" pattern="yyyy"/>' />
				</div>
				
				<div class="fr">
					<button class="blue btn-st02 _searchBtn_ mr10" type="button">
						<span><spring:message code="label.search"/><!-- 조회 --></span>
					</button>
					<button class="green btn-st02 exel fr" type="button" name="Search">
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