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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/dwh/WAE031SupplyShipping.js"></script>
<!-- [EN] Contents area -->
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }">
	<%--조회권한 --%>
	<form:form>
		<div class="searchCondition">
			
			<div class="sssgap"></div>
			<div class="top-bar cb">
				<!-- 사업장을 선택해주세요 -->
				<!--  
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
				-->
				<strong class="pr5"><spring:message code='label.comps'/><!-- 공장 --></strong>
				<select style="width:99.2px" title="<spring:message code='DNKR-I0-0001'/>">
					<option value=""> 구KA전체	</option>
				</select>
				<!-- 자료선택 -->
				<strong class="pr5"><spring:message code='label.selectMenu'/><%-- 자료선택--%></label></strong>
					<input type="radio" name="selectMenu" value="DWH201PF" onclick="commonClear(this.value)" checked="checked">일반조회
					<input type="radio" name="selectMenu" value="DWH202PF" onclick="commonClear(this.value)"> 홍성전용				
				<!-- 조회년도를 선택해주세요 -->
				<strong class="pr5"><spring:message code='label.excYm'/><%-- 최종처리년월--%></strong> 
				<div class="date-inwrap" data-ax5picker="basic"
					style="width: 140px;">
					<%--
					<span class="calendar_icon_b vcen2 c1"></span> <input type="text"
						name="year" id="year" style="width: 140px; padding: 0 40px"
						placeholder="yyyy-mm" data-picker-date="month"
						value="${year}" readonly="readonly" />
					 --%>	
					<span class="calendar_icon_b vcen2 c1"></span> <input type="text"
						name="year" id="year" style="width: 140px; padding: 0 40px"
						placeholder="yyyy-mm" 
						value="${year}" readonly="readonly" />
		
				</div>
				<strong class="pr5">*매월 저장품마감후  DATA가 생성됩니다.</strong> 	
				
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