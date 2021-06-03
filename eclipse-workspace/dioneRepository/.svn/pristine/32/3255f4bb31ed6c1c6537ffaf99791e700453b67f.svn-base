<%--
 * PROJECT：
 *
 * [KR] 수입품 진도관리 조회
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/dwh/WAE041ImportProgress.js"></script>
<!-- [EN] Contents area -->
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }">
	<%--조회권한 --%>
	<form:form>
		<div class="searchCondition">
			
			<div class="sssgap"></div>
			<div class="top-bar cb">
				<strong class="pr5"><spring:message code='label.comps'/><%-- 공장 --%></strong>
				<%-- 
				 <select class="pLocCode" autofocus="true" name="pLocCode"  id="pLocCode"  style="width:99.2px" title="<spring:message code='DNKR-I0-0001'/>" onchange="commonClear()">
					<option value="LOC000001" 
								<c:if test="${paraDomain.locCode ne 'LOC000004'}">
									selected
								</c:if>
							>구KA</option>
					<option value="LOC000004"
								<c:if test="${paraDomain.locCode eq 'LOC000004'}">
									selected
								</c:if>
							>구KE</option>
				</select>
				 --%>
				<select class="pLocCode" autofocus="true" name="pLocCode"  id="pLocCode"  style="width:99.2px" title="<spring:message code='DNKR-I0-0001'/>" onchange="commonClear()">
					<c:if test="${fn:length(locList) > 0}">
						<c:forEach var="locDomain" items="${locList}" varStatus="status">
							<option value="${locDomain.relationCode}"
								<c:if test="${locDomain.relationCode eq paraDomain.locCode}">
									selected
								</c:if>
							><c:out value="${locDomain.relationName}"/></option>
						</c:forEach>
					</c:if>
				</select>
				
				<%-- 일자구분 선택해주세요 --%>
				&nbsp;&nbsp;&nbsp; 
				<strong class="pr5"><spring:message code='label.type'/><%-- 구분 --%></strong>
				<select id="pGubun" name="pGubun"  onchange="changeDate()">
					<option value="X" selected>전체</option>
					<option value="Z">오더</option>
					<option value="Y">개설</option>
					<option value="A">결제</option>
					<option value="B">도착</option>
					<option value="C">사입</option>
					<option value="D">통관</option>
				</select>
				
				<!-- 조회년도를 선택해주세요 -->
				&nbsp;&nbsp;&nbsp; 
				<%-- <strong class="pr5"><spring:message code='label.stYm'/>기준년월</strong>  --%>
				<strong class="pr5">기준일자 </strong>
				<div class="date-inwrap" data-ax5picker="basic" style="width: 120px;">
					<span class="calendar_icon_b vcen2 c1"></span> <input type="text"
						name="startDate" id="startDate" style="width: 120px; padding: 0 0px 0px 35px"
						placeholder="yyyy-MM-dd" data-picker-date="date1"
						value='<fmt:formatDate value="${today}" pattern="yyyy-MM-dd"/>'  onchange="commonClear()"/>
				</div>
				~
				<div class="date-inwrap" data-ax5picker="basic" style="width: 120px;">
					<span class="calendar_icon_b vcen2 c1"></span> <input type="text"
						name="endDate" id="endDate" style="width: 120px; padding: 0 0px 0px 35px"
						placeholder="yyyy-MM-dd" data-picker-date="date2"
						value='<fmt:formatDate value="${today}" pattern="yyyy-MM-dd"/>'  onchange="commonClear()" />
				</div>
				
				<!-- 오더번호을 선택해주세요 -->
				&nbsp;&nbsp;&nbsp; 
				<strong class="pr5">오더번호</strong>
				<input type="text" name="pOrder" id="pOrder" style="width: 200px; padding: 0 20px" maxlength="7"/>
				
				
				<div class="fr">
					<button class="blue btn-st02 _searchBtn_" type="button">
						<span><spring:message code="label.search"/><!-- 조회 --></span>
					</button>
					<button class="green btn-st02 exel fr" type="button" name="Search" style="margin-left:10px;">
						<span><spring:message code="label.excelBtn" /><!-- 엑셀 --></span>
					</button>
				</div>
					&nbsp;&nbsp;&nbsp; 
				<strong class="pr5">※ 구분을 오더로 선택시 기준일자는 년월을 기준으로 합니다. </strong>

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