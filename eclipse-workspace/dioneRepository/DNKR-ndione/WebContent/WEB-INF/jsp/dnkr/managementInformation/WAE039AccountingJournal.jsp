<%--
 * PROJECT：
 *
 * [KR] 종합정보-경영정보-일일 부문비현황
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/dwh/WAE039AccountingJournal.js"></script>
<!-- [EN] Contents area -->
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }">
	<%--조회권한 --%>
	<form:form>
		<div class="searchCondition">
			
			<div class="sssgap"></div>
			<div class="top-bar cb">
				<%-- 
				<!-- 사업장을 선택해주세요 -->
				<strong class="pr5"><spring:message code='label.comps'/><!-- 공장 --></strong>
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
				 --%>
				<%--
				<strong class="pr5"><spring:message code='label.comps'/><!-- 공장 --></strong>
				<select class="locCode" autofocus="true" name="locCode"  id="locCode"  style="width:99.2px" title="<spring:message code='DNKR-I0-0001'/>" onchange="commonClear()">
					<option value="LOC000004">구KE</option>
					<option value="LOC000001">구KA</option>
				</select>
				--%>
				<!-- 전표구분을 선택해주세요 -->
				<strong class="pr5"><spring:message code='label.comps'/><!-- 공장 --></strong>
				<select class="locCode" autofocus="true" name="locCode"  id="locCode"  style="width:99.2px" title="<spring:message code='DNKR-I0-0001'/>" disabled="disabled">
					<option value="LOC000000">통합</option>
					<option value="LOC000004">구KE</option>
					<option value="LOC000001">구KA</option>
				</select>
				<!-- 조회년도를 선택해주세요 -->
				&nbsp;&nbsp;&nbsp; 
				<strong class="pr5"><spring:message code='label.stYm'/><%-- 기준년월--%></strong> 
				<div class="date-inwrap" data-ax5picker="basic" style="width: 120px;">
					<span class="calendar_icon_b vcen2 c1"></span> <input type="text"
						name="startDate" id="startDate" style="width: 120px; padding: 0 0px 0px 35px"
						placeholder="yyyy-MM" data-picker-date="date"
						value='<fmt:formatDate value="${today}" pattern="yyyy-MM"/>'  onchange="commonClear()"/>
				</div>
				~
				<div class="date-inwrap" data-ax5picker="basic" style="width: 120px;">
					<span class="calendar_icon_b vcen2 c1"></span> <input type="text"
						name="endDate" id="endDate" style="width: 120px; padding: 0 0px 0px 35px"
						placeholder="yyyy-MM" data-picker-date="date"
						value='<fmt:formatDate value="${today}" pattern="yyyy-MM"/>'  onchange="commonClear()" />
				</div>
				<!-- 전표구분을 선택해주세요 -->
				<!-- 계정과목을 선택해주세요 -->
				&nbsp;&nbsp;&nbsp; 
				<strong class="pr5">계정과목</strong>
				<select class="pGlobj" autofocus="true" name="pGlobj"  id="pGlobj" style="width:180px" onchange="commonClear()">
					<c:if test="${fn:length(codeF0901List) > 0}">
						<option value="0" selected><c:out value="전체"/></option>
						<c:forEach var="codeF0901" items="${codeF0901List}" varStatus="status">
							<option value="${codeF0901.gmobj}">
							<c:out value="${codeF0901.gmobjName}"/></option>
						</c:forEach>
					</c:if>
				</select>
				~
				<select class="pGlobj2" autofocus="true" name="pGlobj2"  id="pGlobj2" contenteditable="true" style="width:180px" onchange="commonClear()">
					<c:if test="${fn:length(codeF0901List) > 0}">
						<option value="99999" selected><c:out value="전체"/></option>
						<c:forEach var="codeF0901" items="${codeF0901List}" varStatus="status">
							<option value="${codeF0901.gmobj}">
							<c:out value="${codeF0901.gmobjName}"/></option>
						</c:forEach>
					</c:if>
				</select>
				
				<!-- 시스템 구분을 선택해주세요  -->
				&nbsp;&nbsp;&nbsp; 
				<input name="systemType" value="" id="systemType" class="radio-st01" type="checkbox" onclick="changeLocde(this)"><label for="systemType"><span class="radio-deco"></span> 구환경</label>

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