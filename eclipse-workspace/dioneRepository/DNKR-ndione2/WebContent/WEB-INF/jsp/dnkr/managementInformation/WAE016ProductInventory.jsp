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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/dwh/WAE016ProductInventory.js"></script>
<!-- [EN] Contents area -->
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }">
	<%--조회권한 --%>
	<form:form>
		<div class="searchCondition">
			
			<div class="sssgap"></div>
			<div class="top-bar cb">
				<!-- 자료선택 -->
				<strong class="pr5"><spring:message code='label.selectMenu'/><%-- 자료선택--%></label></strong>
					<input type="radio" name="selectMenu" value="item" onclick="commonClear()" checked="checked"><span><spring:message code="label.type.item" />&nbsp;<%-- 품번별 --%>
					<input type="radio" name="selectMenu" value="prdcd" onclick="commonClear()"> <span><spring:message code="label.type.prdcd" />(구KA전용)&nbsp;<%-- 제품별  --%>
					<input type="radio" name="selectMenu" value="house" onclick="commonClear()"> <span><spring:message code="label.type.house" />(구KA전용)&nbsp;<%-- 창고별  --%>
				<br>
				<!-- 사업부 선택해주세요 -->
				<!--  
				<strong class="pr5">사업부</strong> <select name="comps"
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
				<strong class="pr5">품번</strong>
				<input type="text" name="pspno" id="pspno" style="width: 200px; padding: 0 20px" maxlength="15"/>
				
				<div class="fr">
					<button class="blue btn-st02 _searchBtn_" type="button">
						<span><spring:message code="label.search"/><!-- 조회 --></span>
					</button>
					<button class="green btn-st02 exel fr" type="button" name="Search" style="margin-left:10px;">
						<span><spring:message code="label.excelBtn" /><!-- 엑셀 --></span>
					</button>
				</div>
				
				<%-- 창고코드를 선택해주세요 --%>
				<strong class="pr5"><spring:message code='label.house'/><%-- 창고 --%></strong>
				<select name="house" id="house" >
					<c:if test="${fn:length(codeHouseList) > 0}">
						<option value="">전체	</option>
						<c:forEach var="codeHouseDomain" items="${codeHouseList}"
							varStatus="status">
							<option value="${codeHouseDomain.code2}"><c:out
									value="${codeHouseDomain.code_name}"/></option>
						</c:forEach>
					</c:if>
				</select>
				<%-- 제품코드를 선택해주세요 --%>
				<strong class="pr5"><spring:message code='label.prdcd'/><%-- 제품코드 --%></strong>
				<select name="prdcd" id="prdcd">
					<c:if test="${fn:length(codePrdcdList) > 0}">
						<option value="">전체	</option>
						<c:forEach var="codePrdcdDomain" items="${codePrdcdList}"
							varStatus="status">
							<option value="${codePrdcdDomain.mstcd}"><c:out
									value="${codePrdcdDomain.mstrm}" /></option>
						</c:forEach>
					</c:if>
				</select>
				<%-- 구분 선택해주세요 --%>
				<strong class="pr5"><spring:message code='label.type'/><%-- 구분 --%></strong>
				<select id="itcls" name="itcls">
					<option value="" selected>전체</option>
					<option value="1">제품</option>
					<option value="3">내제품</option>
				</select>
				<!-- 패킹동장을 선택해주세요 -->
				<strong class="pr5">패킹사업부</strong>
				<select class="packc" autofocus="true" name="packc"  id="packc"  style="width:99.2px" title="<spring:message code='DNKR-I0-0001'/>" onchange="commonClear()">
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