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

<link rel="stylesheet" media="all" href="/css/board.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/project/WAK005WorkSort.js?ver=1"></script>

<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%--조회권한 --%>
	<div class="board-bList-wrap">
		<form:form action='${pageContext.request.contextPath}/WAK005WorkSortSearch/search.do?tabId=${tabId}' method="POST" modelAttribute="teamSearchForm" name="teamSearchForm">
			<div class="list-top">
				<div class="fl">	
				
					<%-- 
					<!-- 사업부 구분 삭제 - 180831 -->
					<!-- 사업부를 선택해주세요 -->
					<select class="clsCode" id="clsCode" style="width:99.2px" name=clsCode title="<spring:message code='DNKR-I0-0000'/>">
						<option value="">
							<spring:message code='label.cls_total'/><!-- 사업부전체 -->
						</option>
						<c:if test="${fn:length(clsList) > 0}">
							<c:forEach var="clsDomain" items="${clsList}" varStatus="status">
								<!-- <option>사업부전체</option> -->
								<option value="${clsDomain.relationCode}"
									<c:if test="${clsDomain.relationCode eq paraDomain.clsCode}">
										selected
									</c:if>
								><c:out value="${clsDomain.relationName}"/></option>
							</c:forEach>
						</c:if>
					</select>
					 --%>
					
					<!-- 사업장을 선택해주세요 -->
					<select class="locCode" autofocus="true" id="locCode" style="width:99.2px" name="locCode" title="<spring:message code='DNKR-I0-0001'/>">
						<option value="">
							<spring:message code='label.loc_total'/><!-- 사업장전체  -->
						</option>
						<c:if test="${fn:length(locList) > 0}">
							<c:forEach var="locDomain" items="${locList}" varStatus="status">
								<!-- <option>사업부전체</option> -->
								<option value="${locDomain.relationCode}"
									<c:if test="${locDomain.relationCode eq paraDomain.locCode}">
										selected
									</c:if>
								><c:out value="${locDomain.relationName}"/></option>
							</c:forEach>
						</c:if>
					</select>
					
					<!-- 부서(팀)를 선택해주세요 -->
					<select class="teamCode" id="teamCode" style="width:252.8px" name="relationCode" title="<spring:message code='DNKR-I0-0002'/>">
						<option value="">
							<spring:message code='label.team_total'/><!-- 부서(팀)전체 -->
						</option>
						<c:if test="${fn:length(teamList) > 0}">
							<c:forEach var="teamDomain" items="${teamList}" varStatus="status">
								<!-- <option>사업부전체</option> -->
								<option value="${teamDomain.relationCode}"
									<c:if test="${teamDomain.relationCode eq paraDomain.relationCode}">
										selected
									</c:if>
								><c:out value="${teamDomain.relationName}"/></option>
							</c:forEach>
						</c:if>
					</select>
					
					<button type="submit" class="AXButton Black _searchBtn_" onclick="">
						<i class="axi axi-ion-android-search"></i>
						<spring:message code='label.search'/>
					</button>
				</div>
				<!-- search -->
			</div>
			<!-- list-top -->
			<div class="gap10"></div>
			<span class="top-border"></span>
			<table>
				<caption></caption>
				<colgroup>
					<col scope="col" width="*">
					<!-- <col scope="col" width="*"> -->
					<!-- <col scope="col" width="*"> -->
					<!-- <col scope="col" width="*"> -->
					<col scope="col" width="*">
					<!-- <col scope="col" width="*" class="w60p"> -->
					<col scope="col" width="*">
					<col scope="col" width="*">
					<!-- <col scope="col" width="*"> -->
					<!-- <col scope="col" width="*"> -->
					<col scope="col" width="*">
				</colgroup>
				<thead>
					<tr>
						<th><!-- 번호 --><spring:message code='label.number'/></th>
						<th><spring:message code='label.WAB002.clsCode'/><!-- 사업부 --></th>
						<th><spring:message code='label.WAB002.locCode'/><!-- 사업장 --></th>
						<th><spring:message code='label.WAB002.teamCode'/><!-- 부서(팀) --></th>
						<th><!-- 관리 --><spring:message code='label.management'/></th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%--조회권한 --%>
						<c:choose>
							<c:when test="${fn:length(mainTeamList) > 0}">
								<%-- <c:set value="${fn:length(mainTeamList)}" var="authListSize"/> --%>
								<c:forEach var="teamDomain" items="${mainTeamList}" varStatus="status">
									<tr>
										<td>${totCount + 1 - teamDomain.rowNum}</td>
										<td>${teamDomain.clsName}</td>
										<td>${teamDomain.locName}</td>
										<td>${teamDomain.relationName}</td>
										<td>
											<div class="">
												<c:if test="${fn:substring(authBinaryNum, 2, 3) eq '1' }"><%--등록권한 --%>
													<button type="button" class="AXButton Red _workSortManage_" style=""
														onclick="" data-menu='<c:out value="${menu}"/>' data-click-target="${teamDomain.relationCode}">
														<i>
															<!--  class="axi axi-ion-person-add"> -->
														</i> 
														<spring:message code='label.WAK005.name' /><!-- 업무분류관리 -->
													</button>
												</c:if>
											</div>
										</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr><td colspan="5">데이터가 없습니다.</td></tr>
							</c:otherwise>
						</c:choose>
					</c:if>
					<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '0' }"><%--조회권한 --%>
						<tr><td colspan="5"><spring:message code='DNKR-E2-0000'/><!-- 권한이 없습니다. --></td></tr>
					</c:if>
				</tbody>
			</table>
			<div class="gap20"></div>
			
			<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%--조회권한 --%>
				<c:if test="${fn:length(mainTeamList) > 0}">
					<div class="paging-wrap">
			            <smpl:seqpaging maxSeq="10" action="${pageContext.request.contextPath}/WAK005WorkSortSearch/search.do?tabId=${tabId}&menu=${menu}" formId="teamSearchForm" />
			        </div>
			        <ai:pagingoption countPerPage="10" />
		        </c:if>
	        </c:if>
		</form:form>
	</div><!--board-view-wrap-->
</c:if>
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '0' }"><%--조회권한 --%>
	<div>
		<span><spring:message code='DNKR-E2-0000'/><!-- 권한이 없습니다. --></span>
	</div>
</c:if>