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

<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/WAB001Emp.js?ver=1"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/WAB001EmpSearch.js?ver=1" charset="utf-8"></script>
<!-- [EN] Contents area -->
<!-- [JP] コンテンツエリア -->

<script type="text/javascript">
	var deleteMsg = "${resultMsg}";
	if (deleteMsg !== "") {
		toastMsg(deleteMsg);
	}
</script>

<div class="board-bList-wrap">
	<form:form action='${pageContext.request.contextPath}/WAB007RelationCompanySearch/search.do?tabId=${tabId}&menu=${menu}' method="POST"  modelAttribute="WAB001EmpSearchForm" name="WAB001EmpSearchForm">
		<div class="list-top text-right">
				<input type="hidden" name="maEmpYn" value="N" />
				<form:input type="hidden" name="empName" path="empName" id="empName"/>
				<form:input type="hidden" name="empId" path="empId" id="empId"/>
				
				<!-- 사업장을 선택해주세요 -->
				<select class="locCode" autofocus="true" name="locCode" style="width:99.2px" title="<spring:message code='DNKR-I0-0001'/>">
					<option value="">
						<spring:message code='label.loc_total'/><!-- 사업장전체 -->
					</option>
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
								
				<!-- 성명 또는 아이디를 선택해주세요 -->
				<select class="nameId" name="" style="width:72.8px" title="<spring:message code='DNKR-I0-0003'/>">
					<c:choose>
						<c:when test="${paraEmp.empName ne ''}">
							<option value="empName" selected>
								<spring:message code='label.cusnm'/><!-- 업체명 -->
							</option>
							<option value="empId" >
								<spring:message code='label.WAB002.empId'/><!-- 아이디 -->
							</option>
						</c:when>
						<c:otherwise>
							<option value="empName">
								<spring:message code='label.cusnm'/><!-- 업체명 -->
							</option>
							<option value="empId" selected>
								<spring:message code='label.WAB002.empId'/><!-- 아이디 -->
							</option>
						</c:otherwise>
					</c:choose>
				</select>

				<div class="dilb">
				<!-- 성명 또는 아이디를 입력해주세요  -->
				<input class="AXInput" id="searchData" style="width:161.6px" type="text" onkeypress="return enterProc();" placeholder="<spring:message code='DNKR-I0-0004'/>" title="<spring:message code='DNKR-I0-0004'/>" 
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
				<c:if test="${fn:substring(authBinaryNum, 2, 3) eq '1' }"><%--등록권한 --%>
					<button type="button" class="AXButton Red _addBtn_" style="" onclick="javascript:location.href='/WAB002EmpCreate/init.do?tabId=<c:out value="${tabId}"></c:out>&menu=<c:out value="${menu}"></c:out>&type=exteranlAccount';" data-click-target="CLS">
						<i><!--  class="axi axi-ion-person-add"> --></i>
						<spring:message code='label.WAB002.employee'/>&nbsp;
						<spring:message code='label.add'/><!-- 사용자 등록  -->
					</button>
				</c:if>
				</div>
				
			<div class="WAB001ES-tbtnM pt5" style="display: inline-block;">
				<button type="button" class="_excelBtn_ xlsDown" style="margin-left:0;" data-menu="${menu}">
					<span><spring:message code='label.excelDown' /><!-- 엑셀다운 --></span>
				</button>
			</div>
		
		</div>
			 
		<div class="gap10"></div>
		<span class="top-border"></span>
		<div class="m-scroll">
		<table id="empTable" style="min-width:1110px;">
			<caption></caption>
			<colgroup>
				<col scope="col" >
				<col scope="col" >
				<col scope="col" >
				<col scope="col">
				<col scope="col">
				<col scope="col">
				<col scope="col">
				<col scope="col">
			</colgroup>
			<thead>
				<tr>
					<th><spring:message code='label.number'/><!-- 번호 --></th>
					<th><spring:message code='label.WAB002.empInoutType'/><!-- 직원구분 --></th>
					<th><spring:message code='label.WAB002.empNumber'/><!-- 사번 --></th>
					<th><spring:message code='label.cusnm'/><!-- 업체명 --></th>
					<th><spring:message code='label.WAB002.empId'/><!-- 아이디 --></th>
					<th><spring:message code='label.email'/><!-- 이메일 --></th>
					<th><spring:message code='label.supplyComps'/><!-- 협력업체(납품공장) --></th>
					<th><spring:message code='label.companyId'/><!-- 협력업체(사업자번호) --></th>
					<th><spring:message code='label.useYn'/><!-- 사용 --></th>
					<th><spring:message code='label.management'/><!-- 관리 --></th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%--조회권한 --%>
						<c:choose>
							<c:when test="${fn:length(empList) > 0}">
								<c:set value="${fn:length(empList)}" var="empListSize"/>
									<c:forEach var="empDomain" items="${empList}" varStatus="status">
										<tr>
											<td>${totCount + 1 - empDomain.rowNum}</td>
											<td>
												<c:choose>
													<c:when test="${empDomain.inOutType eq 'I'}">
														<spring:message code="label.WAB002.empInternal" /><!-- 내부 -->
													</c:when>
													<c:otherwise>
														<spring:message code="label.WAB002.empOutside" /><!-- 외부 -->
													</c:otherwise>
												</c:choose>
											</td>
											<td>${empDomain.empNumber}</td>
											<td>${empDomain.empName}</td>
											<td>${empDomain.empId}</td>
											<td>${empDomain.empEmail}</td>
											<td>${empDomain.relationCopLocName}</td>
											<td>${empDomain.relationCopNo}</td>
											<td>
												<c:choose>
													<c:when test="${empDomain.empUse eq 'Y'}">
														<spring:message code="label.yes" /><!-- 사용 -->
													</c:when>
													<c:otherwise>
														<spring:message code="label.no" /><!-- 미사용 -->
													</c:otherwise>
												</c:choose>
											</td>
											<td>
												<div>
													<%-- <button type="button" class="AXButton Normal _authConfigBtn_" style=""
														onclick="" data-click-target="${empDomain.empNumber}">
														<i>
															<!--  class="axi axi-ion-person-add"> -->
														</i> 개인권한설정
														<spring:message code='label.cmcregister'/>
													</button> --%>
													
													<c:if test="${fn:substring(authBinaryNum, 1, 2) eq '1' }"><%--수정권한 --%>
														<button type="button" class="AXButton Normal _modifyBtn_"
															style="" onclick="javascript:location.href='/WAB004EmpUpdate/init.do?tabId=<c:out value="${tabId}"></c:out>&menu=<c:out value="${menu}"></c:out>&empNumber=<c:out value="${empDomain.empNumber}"></c:out>';" data-click-target="">
															<i>
																<!--  class="axi axi-ion-person-add"> -->
															</i> 
															<spring:message code='label.modify'/><!-- 수정 -->
														</button>
													</c:if>
													<c:if test="${fn:substring(authBinaryNum, 0, 1) eq '1' }"><%--삭제권한 --%>
														<button type="button" class="AXButton Normal _deleteBtn_"
															onclick="" data-loction="" data-menu="${menu}"
															data-click-target="${empDomain.empNumber}">
															<spring:message code='label.delete' />
															<!-- 삭제 -->
														</button>
													</c:if>
												</div>
											</td>
										</tr>
									</c:forEach>
							</c:when>
							<c:otherwise>
								<tr><td colspan="11"><spring:message code='label.WAK004.list8' /><!-- 데이터가 없습니다. --></td></tr>
							</c:otherwise>
						</c:choose>
						
				</c:if>
				<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '0' }"><%--조회권한 --%>
					<tr>
						<td colspan="11">
							<spring:message code='DNKR-E2-0000'/><!-- 권한이 없습니다. -->
						</td>
					</tr>
				</c:if>
			</tbody>
		</table>
		</div>
		<!-- <div class="list-bnt listOnly">
			<a href="#" class="gray">삭제</a>
			<a href="#" class="red">글쓰기</a>
		</div> -->
		<div class="gap20"></div>
		
		<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%--조회권한 --%>
			<c:if test="${fn:length(empList) > 0}">
				<div class="pagenation">
		            <smpl:seqpaging maxSeq="10" action='${pageContext.request.contextPath}/WAB007RelationCompanySearch/search.do?tabId=${tabId}&menu=${menu}' formId="WAB001EmpSearchForm" />
		        </div>
		        <ai:pagingoption countPerPage="10" />
	        </c:if>
		</c:if>

	</form:form>
</div><!--board-view-wrap--> 
