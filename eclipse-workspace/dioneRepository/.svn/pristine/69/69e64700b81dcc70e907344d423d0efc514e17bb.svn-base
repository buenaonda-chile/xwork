<%--
 * PROJECT：
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

<script type="text/javascript" src="${pageContext.request.contextPath}/js/commonPop.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/WAB005EmpSelectPop.js?ver"></script>

<h2 class="subpage-tit"><c:out value="${workTypeNm}"/> <spring:message code='label.WAC015.gridlabel.cmcMngt'/> <spring:message code='label.select'/><!-- 승인관리자선택 --></h2>
<div class="board-bList-wrap">
	<div class="list-top">
		<div class="list-top text-right">
			<form:form action="${pageContext.request.contextPath}/WAB001EmpSearch/empSelectPop.do" method="POST" name="EmpDomain" id="WAB005EmpList">
				<input type="hidden" id="clsCode"/>
				<input type="hidden" id="locCode"/>
				<input type="hidden" id="teamCode"/>
				<input type="hidden" name="empName" id="empName"/>
				<input type="hidden" name="empId" id="empId"/>
				<input type="hidden" id="workCode" name="workCode" value="${workCode}"/>
				
				<%-- 
				<!-- 사업부를 선택해주세요 -->
				<select class="clsCode" name="clsCode" style="width:99.2px"  title="<spring:message code='DNKR-I0-0000'/>">
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
				<select class="locCode" name="locCode" style="width:99.2px" title="<spring:message code='DNKR-I0-0001'/>">
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
				<select class="teamCode" name="teamCode" style="width:252.8px"  title="<spring:message code='DNKR-I0-0002'/>">
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
				
				<!-- 성명 또는 아이디를 선택해주세요 -->
				<select class="nameId" name="" style="width:72.8px"  title="<spring:message code='DNKR-I0-0003'/>">
					<c:choose>
						<c:when test="${paraEmp.empName ne ''}">
							<option value="empName" selected>
								<spring:message code='label.person_name'/><!-- 성명 -->
							</option>
							<option value="empId" >
								<spring:message code='label.WAB002.empId'/><!-- 아이디 -->
							</option>
						</c:when>
						<c:otherwise>
							<option value="empName">
								<spring:message code='label.person_name'/><!-- 성명 -->
							</option>
							<option value="empId" selected>
								<spring:message code='label.WAB002.empId'/><!-- 아이디 -->
							</option>
						</c:otherwise>
					</c:choose>
				</select>
				
				<!-- 성명 또는 아이디를 입혁해 주세요. -->
				<input class="AXInput" id="searchData" style="width:161.6px"  type="text" placeholder="<spring:message code='DNKR-I0-0004'/>" title="<spring:message code='DNKR-I0-0004'/>"
				
					<c:choose>
						<c:when test="${paraEmp.empName ne ''}">
							value="${paraEmp.empName}"
						</c:when>
						<c:otherwise>
							value="${paraEmp.empId}"
						</c:otherwise>
					</c:choose>
				/>
				
				<button type="button" class="AXButton Black _searchBtn_" onclick="">
					<i class="axi axi-ion-android-search"></i>
					<spring:message code='label.search'/>
				</button>
				<button type="button" class="AXButton Blue _saveBtn_" style="" onclick="" data-click-target="">
					<spring:message code='label.save'/><!-- 저장  -->
				</button>
				<button type="button" class="AXButton Normal _closeBtn_" style="" data-click-target="">
					<spring:message code='label.close'/><!-- 사용자등록  -->
				</button>
			</form:form>
		</div>
	</div>

	<!-- list-top -->
	<div class="gap20"></div>
	<span class="top-border"></span>
	<table>
		<caption></caption>
		<colgroup>
			<col scope="col" width="*">
			<col scope="col" width="*">
			<col scope="col" width="*">
			<col scope="col" width="*">
			<col scope="col" width="*">
		</colgroup>
		<thead>
			<tr>
				<th><spring:message code='label.number'/><!-- 번호 --></th>
				<th><spring:message code='label.WAB002.clsCode'/><!-- 사업부 --></th>
				<th><spring:message code='label.WAB002.locCode'/><!-- 사업장 --></th>
				<th><spring:message code='label.WAB002.teamCode'/><!-- 부서(팀) --></th>
				<th><spring:message code='label.WAB002.empName'/><!-- 성명 --></th>
				<th><spring:message code='label.select'/><!-- 선택 --></th>
			</tr>
		</thead>
		<tbody>
			<%-- <form:form action="/ajaxWorkSort/aprvEmpSet.do?" id="aprvEmpSetForm" name="aprvEmpSetForm"  method="POST"> --%>
			<form action="/ajaxWorkSort/aprvEmpSet.do?"  modelAttribute="empDomain" id="aprvEmpSetForm" name="aprvEmpList"  method="POST">
				<input type="hidden" id="workCode" name="workCode" value="${workCode}"/>
				<c:choose>
					<c:when test="${researchList eq null}">
						<c:if test="${fn:length(empList) > 0}">
							<c:set value="${fn:length(empList)}" var="itemListSize"/>
							<c:forEach var="empDomain" items="${empList}" varStatus="status">
								<tr>
									<%-- <td>${empDomain.rowNum}</td> --%>
									<td><c:out value="${status.index + 1}"/></td>
									<td><c:out value="${empDomain.clsName}"/></td>
									<td><c:out value="${empDomain.locName}"/></td>
									<td><c:out value="${empDomain.teamName}"/></td>
									<td><c:out value="${empDomain.empName}"/> ( <c:out value="${empDomain.empId}"/> )</td>
									<td>
										
										<input type="checkbox" id="empNumList[${status.index}]" name="empNumList[${status.index}]" value="${empDomain.empNumber}"
											<c:if test="${workCode eq aprvEmpMap[empDomain.empNumber]}">
												checked
											</c:if>
										/>
									</td>
								</tr>
							</c:forEach>
						</c:if>
					</c:when>
					<c:otherwise>
						<c:if test="${fn:length(researchList) > 0}">
							<c:set value="${fn:length(researchList)}" var="itemListSize"/>
							<c:forEach var="authDomain" items="${researchList}" varStatus="status">
								<tr>
									<td>${itemListSize - status.index}</td>
									<td>${authDomain.authName}</td>
									<td>${authDomain.authDescription}</td>
									<td>
										<c:choose>
											<c:when test="${authDomain.useYn eq 'Y'}">
												<input type="radio" name="authCode" value="${authDomain.authCode}"
													<c:if test="${authDomain.authCode eq authCode }">
														checked
													</c:if>
												/>
											</c:when>
											<c:otherwise>
												<spring:message code='label.useN'/><!-- 미사용 -->
											</c:otherwise>
										</c:choose>
											
									</td>
								</tr>
							</c:forEach>
						</c:if>
					</c:otherwise>
				</c:choose>
			</form>
		</tbody>
	</table>
	<div class="gap20"></div>
	<%-- <form:form action="${pageContext.request.contextPath}/WAB001EmpSearch/empSelectPop.do" method="POST" modelAttribute="WAB001EmpSearchForm" name="WAB001EmpSearchForm" id="WAB001EmpSearchForm">

		<c:if test="${fn:length(empList) > 0}">
			<div class="pagenation">
	            <smpl:seqpaging maxSeq="3" action="${pageContext.request.contextPath}/WAB001EmpSearch/init.do" formId="WAB001EmpSearchForm" />
	        </div>
	        <ai:pagingoption countPerPage="3" />
        </c:if>
	</form:form> --%>
</div>
<!--board-view-wrap-->