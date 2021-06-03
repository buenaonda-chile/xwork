<%--
 * PROJECTï¼Â
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

<%-- <c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"> 조회권한
</c:if> --%>
<style>
.ficSearchWrap {
	width: 100%;
    max-width: 545px;
}

.pd-s-table td select {
	width: 120px;
}

.contentTb th, .contentTb td{
	border: 1px solid #bbb;
}
</style>
<c:choose>
	<c:when test="${type eq 'prtno'}">
		<c:set value="품목" var="title"/>
	</c:when>
	<c:when test="${type eq 'vndnr'}">
		<c:set value="업체" var="title"/>
	</c:when>
	<c:when test="${type eq 'emp'}">
		<c:set value="담당자" var="title"/>
	</c:when>
	<c:otherwise>
	</c:otherwise>
</c:choose>
<script type="text/javascript">
	<%-- var sort = '<c:out value="${type}"/>'; --%>
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/waf/WAF024PsogmFICSearchPop.js"></script>

<!--설비No별실적 팝업 cont_s-->
<div class="ficSearchWrap">
	<div class="inwrap">
		<h2 class="subpage-tit">
			<c:out value="${title}"/>
			선택
		</h2>
		
		<div class="sssgap"></div>
		<div class="">
			<form name="" id="searchForm">
				<input type="hidden" id="comps" name="comps" value='<c:out value="${comps}"/>'/>
				<input type="hidden" id="type" name="type" value='<c:out value="${type}"/>'/>
				<input type="hidden" id="group" name="group" value='<c:out value="${group}"/>'/>
				<table class="pd-s-table">
					<caption>교정분야선택표</caption>
					<colgroup>
						<col width="125px">
						<col width="*">
						<col width="125px">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th>CODE</th>
							<td>
								<input type="text" name="pData" value='<c:out value="${pData}"/>' placeholder="코드를 입력하세요" title="코드를 입렧하세요"/>
								<button class="AXButton Black">
									<i class="axi axi-ion-android-search searchBtn"></i>
									<spring:message code='label.search'/><!-- 조회 -->
								</button>
							</td>
							<td>
								<div class="fr">
									<button type="button" class="AXButton Blue _applyBtn_" style=""
										onclick="" data-click-target="auth-save">
										<spring:message code='label.applyEmp' /><!-- 적용 -->
									</button>
									<button type="button" class="AXButton Normal _closeBtn_" onclick=""
										data-click-target="auth-close">
										<spring:message code='label.close' />
										<!-- 삭제 -->
									</button>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
		<div class="sssgap"></div>
		<div class="">
			<div class="grid-block">
				<div class="gridContents" style="" id="grid-parent">
				    <div style="height: 500px" id="searchGrid" class="searchGrid" data-ax5grid="" data-ax5grid-config="{showLineNumber: true}"></div>
				       
				</div>
			</div>
		</div>
	</div><!---->
</div>