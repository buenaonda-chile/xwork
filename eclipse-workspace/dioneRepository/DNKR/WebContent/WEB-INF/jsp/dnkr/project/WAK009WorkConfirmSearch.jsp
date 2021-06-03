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
<spring:message var="errormessage_tel" code="SMPL-E8-0004" />

<link rel="stylesheet" media="all" href="/css/board.css"/>
<link rel="stylesheet" media="all" href="/css/content.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/project/WAK009WorkConfirmSearch.js?ver=1"></script>

<!-- [EN] Contents area -->
<!-- [JP] コンテンツエリア -->
<style>
.pjt_board .list-top {
	overflow: visible;
}

table.pj_regist td, .pj_regist td {
    padding: 10px 5px !important;
}

table.pj_regist th:first-child, table.pj_regist th:nth-child(2), table.pj_regist th:nth-child(3), table.pj_regist th:nth-child(4),
table.pj_regist th:nth-child(9) {
	width: 9%;
}
table.pj_regist th:nth-child(6), table.pj_regist th:nth-child(7), table.pj_regist th:nth-child(8), table.pj_regist th:nth-child(10) {
	width: 4%;
}
 
table.pj_regist th:nth-child(5){
	width: 18%;
}

table.pj_regist th:nth-child(9) {
	min-width: 130px; /* 영문버튼너비에 맞춤 */
}

table.pj_regist select {
	width: 100%
}
</style>

<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%--조회권한 --%>
	<div class="board-bList-wrap pjt_board">
		<div class="list-top">
			<form:form action="${pageContext.request.contextPath}/WAK009WorkConfirmSearch/search.do?tabId=${tabId}" method="POST" name="WorkConfirmDomain" id="WAK009WorkConfirmSearch">
				<div class="fl">
					<div class="dropdown">
						<span class="calendar_icon vcen2"></span>
						<input autofocus="true" type="text" class="dropbtn calendar_input" name="startDate" id="startDate" value="${startDate}"/>
						<div class="dropdown-menu" role="menu"  id="calendar-target" style="width:250px;
						           border:1px solid #ccc;
						           border-radius: 5px;
						           padding: 5px;
						           overflow: hidden;" >
						</div>
					</div>
					~
					<div class="dropdown">
						<span class="calendar_icon vcen2"></span>
						<input type="text" class="dropbtn calendar_input" name="endDate" id="endDate" value="${endDate}"/>
					</div>
				</div>
				<div class="searchWrap fl">	
				
					<%-- 
					<!-- 사업부를 삭제 - 180831 -->
					<!-- 사업부를 선택해주세요 -->
					<select class="clsCode" id="clsCode" style="width:99.2px" name=clsCode title="<spring:message code='DNKR-I0-0000'/>">
						<option value="">
							<spring:message code='label.cls_total'/><!-- 사업부전체 -->
						</option>
						<c:if test="${fn:length(clsList) > 0}">
							<c:forEach var="clsDomain" items="${clsList}" varStatus="status">
								<!-- <option>사업부전체</option> -->
								<option value="${clsDomain.relationCode}"
									<c:if test="${clsDomain.relationCode eq paraEmp.clsCode}">
										selected
									</c:if>
								><c:out value="${clsDomain.relationName}"/></option>
							</c:forEach>
						</c:if>
					</select>
					 --%>
					
					<!-- 사업장을 선택해주세요 -->
					<select class="locCode" id="locCode" style="width:99.2px" name="locCode" title="<spring:message code='DNKR-I0-0001'/>">
						<option value="">
							<spring:message code='label.loc_total'/><!-- 사업장전체 -->
						</option>
						<c:if test="${fn:length(locList) > 0}">
							<c:forEach var="locDomain" items="${locList}" varStatus="status">
								<!-- <option>사업부전체</option> -->
								<option value="${locDomain.relationCode}"
									<c:if test="${locDomain.relationCode eq paraEmp.locCode}">
										selected
									</c:if>
								><c:out value="${locDomain.relationName}"/></option>
							</c:forEach>
						</c:if>
					</select>
					
					<!-- 부서(팀)를 선택해주세요 -->
					<select class="teamCode" id="teamCode" style="width:180px" name="teamCode" title="<spring:message code='DNKR-I0-0002'/>">
						<option value="">
							<spring:message code='label.team_total'/><!-- 부서(팀)전체 -->
						</option>
						<c:if test="${fn:length(teamList) > 0}">
							<c:forEach var="teamDomain" items="${teamList}" varStatus="status">
								<!-- <option>사업부전체</option> -->
								<option value="${teamDomain.relationCode}"
									<c:if test="${teamDomain.relationCode eq paraEmp.teamCode}">
										selected
									</c:if>
								><c:out value="${teamDomain.relationName}"/></option>
							</c:forEach>
						</c:if>
					</select>
					
					<!-- 성명을 선택해주세요 -->
					<select class="empNumber" id="empNumber" style="width:79.8px" name="empNumber" title="<spring:message code='DNKR-I0-0005'/>">
						<option value="">
							<spring:message code='label.person_name'/><!-- 성명 -->
						</option>
						<c:if test="${fn:length(empList) > 0}">
						<c:forEach var="empDomain" items="${empList}" varStatus="status">
							<!-- <option>사업부전체</option> -->
							<option value="${empDomain.empNumber}"
								<c:if test="${empDomain.empNumber eq paraEmp.empNumber}">
									selected
								</c:if>
							><c:out value="${empDomain.empName}"/></option>
						</c:forEach>
					</c:if>
					</select>
					
					<button type="button" class="AXButton Black _searchBtn_" onclick="">
						<i class="axi axi-ion-android-search"></i>
						<spring:message code='label.search'/>
					</button>
				</div>
			</form:form>
		</div>
		<div class="gap10"></div>
		<span class="top-border"></span>
		<form action="${pageContext.request.contextPath}/WAK009WorkConfirmSearch/update.do?tabId=<c:out value="${tabId}"/>" method="POST" name="pjtDomain" id="pjtDomainForm">
			<div class="m-scroll">
			<table class="pj_regist" style="min-width:800px">
				<caption></caption>
				<colgroup>
					<col scope="col" width="*">
					<col scope="col" width="*">
					<col scope="col" width="*">
					<col scope="col" width="*">
					<col scope="col" width="*">
					<col scope="col" width="*">
					<col scope="col" width="*">
					<col scope="col" width="*">
					<col scope="col" width="*">
					<col scope="col" width="*">
				</colgroup>
				<thead>
					<tr>
						<th>
							<spring:message code='label.WAK001.list3'/>
						</th>
						<th>
							<spring:message code='label.WAK001.list5'/>
						</th>
						<th>
							<spring:message code='label.WAK001.list6'/>
						</th>
						<th>
							<spring:message code='label.WAK001.list7'/> 
						</th>
						<th>
							<spring:message code='label.WAK001.list8'/> 
						</th>
						<th style="min-width: 100px;">
							<spring:message code='label.WAK001.list9'/> 
						</th>
						<th style="min-width: 100px;">
							<spring:message code='label.WAK001.list4'/> 
						</th>
						<th style="min-width: 100px;">
							<spring:message code='label.WAK001.list10'/> 
						</th>
						<th>
							<spring:message code='label.WAK001.list12'/> 
						</th>
						<th>
							<spring:message code="label.WAK001.rejectedReson"/><!-- 반려사유 --> 
						</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${fn:length(pjtList) > 0}" >
							<c:forEach var="pjtDomain" items="${pjtList}" varStatus="status"> 
								<tr>
									<td><c:out value="${pjtDomain.regDate}"/></td>
									<td><c:out value="${pjtDomain.workLTypeNm}"/></td>
									<td><c:out value="${pjtDomain.workMTypeNm}"/></td>
									<td><c:out value="${pjtDomain.workTypeNm}"/></td>
									<td><c:out value="${pjtDomain.relSys}"/></td>
									<td>
										<c:choose>
											<c:when test="${pjtDomain.workTrtr eq 'CMCM00003'}">
												<spring:message code='label.WAK001.list14' /><!-- 공통 -->
											</c:when>
											<c:otherwise>
												<spring:message code='label.WAK001.list15' /><!-- 지역 -->
											</c:otherwise>
										</c:choose>
									<%-- 공통<c:out value="${pjtDomain.workTrtr}"/> --%>
									</td>
									<td>
										<c:choose>
											<c:when test="${(pjtDomain.workHour mod 60) eq 0}">
												<fmt:parseNumber integerOnly="true" value="${pjtDomain.workHour/60}"/>
												/0
											</c:when>
											<c:when test="${(pjtDomain.workHour mod 60) ne 0 && (pjtDomain.workHour/60)>0}">
												<fmt:parseNumber integerOnly="true" value="${pjtDomain.workHour/60}"/>
												/
												<fmt:parseNumber integerOnly="true" value="${pjtDomain.workHour mod 60}"/>
											</c:when>
											<c:otherwise>
												0
												/
												<fmt:parseNumber integerOnly="true" value="${pjtDomain.workHour}"/>
											</c:otherwise>
										</c:choose></td>
									<td>
										<!-- 업무상세 영역 -->
										<button type="button" class="AXButton Red _detailBtn_"
												onclick="" data-loction=""
												data-click-target="${pjtDomain.pjtNum}">
												<spring:message code='label.view' /><!-- 보기 -->
										</button>
										<div class="detail">
											<div class="detail_wrap">
												<p class="tl mb10 pt3"><strong><spring:message code='label.WAK001.list10' /><!-- 업무상세 --></strong></p>
												<textarea class="workDtlCnts" readonly="readonly">
													<c:out value="${pjtDomain.workDtlCnts}"/>
												</textarea>
												<div class="sssgap"></div>
													<!-- <button type="submit" class="btn_type01 red">저장</button> -->
													<!-- <button type="button" class="btn_type01 close gray">닫기</button> -->
													<%-- <button type="button" class="AXButton Blue _saveBtn_" onclick=""
														data-click-target="">
														<spring:message code='label.save' />
														<!-- 저장 -->
													</button> --%>
													<button type="button" class="AXButton Normal _cancelBtn_"
														onclick="" data-click-target="workDtlCnts">
														<spring:message code='label.close' />
														<!-- 취소 -->
													</button>
											</div>
										</div>
									</td>
									<td style="min-width: 90px;">
										<input type="hidden" value="${pjtDomain.pjtNum}" name="pjtList[${status.index}].pjtNum" id="pjtList[${status.index}].pjtNum"/>
										<input type="hidden" value="${pjtDomain.workMCode}" name="pjtList[${status.index}].workMCode" id="pjtList[${status.index}].workMCode"/>
										<c:choose>	
											<c:when test="${pjtDomain.aprvType eq 'S'}">
												<label><input type="radio" value="Y" name="pjtList[${status.index}].aprvType" id="pjtList[${status.index}].aprvType"/><spring:message code='label.WAK001.list12' /><!-- 승인 --></label>
												<label><input type="radio" value="N" name="pjtList[${status.index}].aprvType" id="pjtList[${status.index}].aprvType"/><spring:message code='label.WAK001.rejected' /><!-- 반려 --></label>
											</c:when>
											<c:when test="${pjtDomain.aprvType eq 'Y'}">
												<label><input type="radio" value="Y" name="pjtList[${status.index}].aprvType" id="pjtList[${status.index}].aprvType" checked/><spring:message code='label.WAK001.list12' /><!-- 승인 --></label>
												<label><input type="radio" value="N" name="pjtList[${status.index}].aprvType" id="pjtList[${status.index}].aprvType"/><spring:message code='label.WAK001.rejected' /><!-- 반려 --></label>
											</c:when>
											<c:otherwise>
													<label><input type="radio" value="Y" name="pjtList[${status.index}].aprvType" id="pjtList[${status.index}].aprvType"/><spring:message code='label.WAK001.list12' /><!-- 승인 --></label>
												<label><input type="radio" value="N" name="pjtList[${status.index}].aprvType" id="pjtList[${status.index}].aprvType" checked/><spring:message code='label.WAK001.rejected' /><!-- 반려 --></label>
											</c:otherwise>
										</c:choose>
									</td>
									<td>
										<input type="text" name="pjtList[${status.index}].note" value="${pjtDomain.note}"/>
									</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:when test="${pjtCount > 0}">
							<tr>
								<td colspan="10">
									업무 승인 처리할 사원의 정보를 조회하면 데이터가 조회됩니다.
								</td>
							</tr>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="10">
									<spring:message code='label.no_data'/> 
								</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
			</div>
		</form>
		<div class="gap20"></div>
		<c:if test="${fn:substring(authBinaryNum, 2, 3) eq '1' }"><%--등록권한 --%>
			<div class="text-right">
				<%-- <button type="submit" class="red" name="Register" onclick="return window.confirm('<spring:message code='SMPL-Q0-0000' />');"> --%>
				<button type="submit" class="AXButton Normal _allConfirmBtn_" name="Register">
					<spring:message code="label.WAK009.AllConfirm" /><!-- 전체승인 -->
				</button>
				<button type="submit" class="AXButton Blue _saveBtn_" onclick="" data-click-target="">
					<spring:message code="label.save" />
				</button>
			</div>
		</c:if>
		<div class="gap20"></div>
	</div><!--board-view-wrap-->
</c:if>
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '0' }"><%--조회권한 --%>
	<div>
		<span><spring:message code='DNKR-E2-0000'/><!-- 권한이 없습니다. --></span>
	</div>
</c:if>