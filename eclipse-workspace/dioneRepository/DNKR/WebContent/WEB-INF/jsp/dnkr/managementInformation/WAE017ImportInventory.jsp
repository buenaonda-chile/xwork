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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/dwh/WAE017ImportInventory.js"></script>

<!-- [EN] Contents area -->
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }">
	<%--조회권한 --%>
 	<form name="WAE017ImportInventoryForm" id="WAE017ImportInventoryForm">
		<div class="searchCondition">
			<div class="sssgap"></div>
			<div class="top-bar cb">
				<!--  
				<strong class="pr5"><spring:message code='label.comps'/><%-- 공장 --%></strong> <select name="comps"
					id="comps" dataSet="ds_ComCode_PLNT">
					<c:if test="${fn:length(codeList) > 0}">
						<c:forEach var="codeD2Domain" items="${codeList}"
							varStatus="status">
							<option value="${codeD2Domain.code2}"><c:out
									value="${codeD2Domain.code_name}" /></option>
						</c:forEach>
					</c:if>
				</select>
				-->			
				<!-- 사업장을 선택해주세요 -->
				<strong class="pr5"><spring:message code='label.comps'/><%-- 공장 --%></strong>
				<select class="locCode" autofocus="true" name="locCode"  id="locCode"  style="width:99.2px" title="<spring:message code='DNKR-I0-0001'/>" onchange="commonClear()">
					<c:if test="${fn:length(locList) > 0}">
						<c:forEach var="locDomain" items="${locList}" varStatus="status">
							<option value="${locDomain.relationCode}"
								<c:if test="${locDomain.relationCode eq paraEmp.locCode}">
									selected
								</c:if>
							><c:out value="${locDomain.relationName}"/></option>
						</c:forEach>
					</c:if>
				</select>
				

				<!-- 품번을 선택해주세요 -->
				<strong class="pr5">수입품번</strong>
				<input type="text" name="expno" id="expno" style="width: 200px; padding: 0 20px" maxlength="15"/>
				<!-- 품번을 선택해주세요 -->
				<strong class="pr5">재고존재품번만</strong>
				<input type="checkbox" name="mohtqTf" id="mohtqTf" checked="checked" />
								
				<div class="fr">
					<button class="blue btn-st02 _searchBtn_" type="button">
						<span><spring:message code="label.search"/><!-- 조회 --></span>
					</button>
					<button class="green btn-st02 exel fr" type="button" name="Search" style="margin-left:10px;">
						<span><spring:message code="label.excelBtn" /><!-- 엑셀 --></span>
					</button>
				</div>
				<%--팝업 파라미터용 --%>
				<input type="text" name="pExpno" id="pExpno" hidden="true"/>

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
	</form>
</c:if>
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '0' }">
	<%--조회권한 --%>
	<div>
		<span><spring:message code='DNKR-E2-0000' /> <!-- 권한이 없습니다. --></span>
	</div>
</c:if>