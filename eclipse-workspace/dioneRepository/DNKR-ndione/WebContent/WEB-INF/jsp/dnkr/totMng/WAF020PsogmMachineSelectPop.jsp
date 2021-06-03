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
.machinePopWrap {
	width: 100%;
    max-width: 500px;
}

.pd-s-table td select {
	width: 120px;
}

.contentTb th, .contentTb td{
	border: 1px solid #bbb;
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/waf/WAF020PsogmMachineSelectPop.js"></script>

<!--설비No별실적 팝업 cont_s-->
<div class="machinePopWrap">
	<div class="inwrap">
		<h2 class="subpage-tit">설비선택</h2>
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
		<div class="sssgap"></div>
		<div class="">
			<form name="" id="machineSearchForm">
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
							<th>파트코드</th>
							<td>
								<select id="prtcd" name="prtcd" title="검색조건을 선택해주세요">
									<option value=""></option>
									<c:if test="${fn:length(partList) > 0}">
										<c:forEach var="partDomain" items="${partList}">
											<option value="${partDomain.prtcd}">
												<c:out value="${partDomain.prtnm}"/>
											</option>
										</c:forEach>
									</c:if>
								</select>
							</td>
							<th>라인코드</th>
							<td>
								<select id="lincd" name="lincd" title="검색조건을 선택해주세요">
									<option value=""></option>
								</select>
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
				    <div style="height: 500px" id="machineGrid" class="machineGrid" data-ax5grid="" data-ax5grid-config="{showLineNumber: true}"></div>
				       
				</div>
			</div>
		</div>
	</div><!--설비No별실적 팝업 팝업 cont_e-->
</div>