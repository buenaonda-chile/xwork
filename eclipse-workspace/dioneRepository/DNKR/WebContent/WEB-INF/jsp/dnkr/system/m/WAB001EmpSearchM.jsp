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
<link type="text/css" rel="stylesheet" media="all" href="/css/m/content.css">



<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/WAB001Emp.js?ver=1"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/WAB001EmpSearch.js?ver=1" charset="utf-8"></script>

<div class="sub_Toptit">사용자관리</div>


<!-- container:S -->
<div id="userMG_container">
	<form:form action='${pageContext.request.contextPath}/WAB001EmpSearch/search.do?tabId=${tabId}&menu=${menu}' method="POST"  modelAttribute="WAB001EmpSearchForm" name="WAB001EmpSearchForm">
		<div class="uM_search">
			<input type="hidden" name="maEmpYn" value="N" />
			<form:input type="hidden" name="empName" path="empName" id="empName"/>
			<form:input type="hidden" name="empId" path="empId" id="empId"/>
			
			<!-- 사업부를 선택해주세요 -->
			<select class="clsCode select-st01" name="clsCode" title="<spring:message code='DNKR-I0-0000'/>">
				<option value="">
					<spring:message code='label.cls_total'/><!-- 사업부전체 -->
				</option>
				<c:if test="${fn:length(clsList) > 0}">
					<c:forEach var="clsDomain" items="${clsList}" varStatus="status">
						<option value="${clsDomain.relationCode}"
							<c:if test="${clsDomain.relationCode eq paraEmp.clsCode}">
								selected
							</c:if>
						><c:out value="${clsDomain.relationName}"/></option>
					</c:forEach>
				</c:if>
			</select>
			
			<!-- 사업장을 선택해주세요 -->
			<select class="locCode select-st01 sel-02" name="locCode" title="<spring:message code='DNKR-I0-0001'/>">
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
			
			<!-- 부서(팀)를 선택해주세요 -->
			<select class="teamCode select-st01 sel-03" name="teamCode" title="<spring:message code='DNKR-I0-0002'/>">
				<option value="">
					<spring:message code='label.team_total'/><!-- 부서(팀)전체 -->
				</option>
				<c:if test="${fn:length(teamList) > 0}">
					<c:forEach var="teamDomain" items="${teamList}" varStatus="status">
						<option value="${teamDomain.relationCode}"
							<c:if test="${teamDomain.relationCode eq paraEmp.teamCode}">
								selected
							</c:if>
						><c:out value="${teamDomain.relationName}"/></option>
					</c:forEach>
				</c:if>
			</select>
			
			<!-- 성명 또는 아이디를 선택해주세요 -->
			<select class="nameId sel-last select-st01" name="" title="<spring:message code='DNKR-I0-0003'/>">
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
			<div class="width-wrap">
			<!-- 성명 또는 아이디를 입력해주세요  -->
				<input class="search-text" id="searchData" type="text" onkeypress="return enterProc();" placeholder="<spring:message code='DNKR-I0-0004'/>" title="<spring:message code='DNKR-I0-0004'/>" 
					<c:choose>
						<c:when test="${paraEmp.empName ne ''}">
							value="${paraEmp.empName}"
						</c:when>
						<c:otherwise>
							value="${paraEmp.empId}"
						</c:otherwise>
					</c:choose>
				/>
				<button type="button" class=" _searchBtn_ search-bnt" onclick="">
					<spring:message code='label.search'/>
				</button>
			</div>
			
			
			<!-- <select name="" title="검색내용을 선택해주세요" class="select-st01">
				<option>사업부전체</option>
				<option>DNKA</option>
				<option>DNKE</option>
			</select>
			<select name="" title="검색내용을 선택해주세요" class="select-st01 sel-02">
				<option>사업장전체</option>
				<option>DNKE마산</option>
			</select>
			<select name="" title="검색내용을 선택해주세요" class="select-st01 sel-03">
				<option>부서(팀)전체</option>
				<option>생산관리1팀</option>
				<option>생산관리2팀</option>
				<option>생산관리3팀</option>
				<option>EF팀 </option>
				<option>IT팀 </option>
				<option>안전환경팀 </option>
				<option>선행기술2팀 </option>
				<option>Cluster기술1팀(SYSTEM)</option>
				<option>Cluster기술2팀(외장) </option>
				<option>Cluster기술3팀 </option>
				<option>Cluster기술4팀 </option>
				<option>교섭지원팀 </option>
				<option>BODY기술1팀(SYSTEM)</option>
				<option>BODY기술2팀(외장)</option>
				<option>BODY기술3팀</option>
				<option>제조2팀</option>
				<option>회계팀</option>
				<option>재무팀</option>
				<option>법무팀</option>
				<option>사업계획팀</option>
				<option>사업기획팀</option>
				<option>구매기획팀</option>
				<option>구매개발1팀</option>
				<option>구매개발2팀</option>
				<option>인사총무팀</option>
				<option>CS팀</option>
				<option>품질전략팀</option>
				<option>신차2팀</option>
				<option>양산3팀</option>
				<option>해외품보팀</option>
				<option>부품품질강화팀</option>
				<option>부품품질개선4팀</option>
				<option>품질검증팀</option>
				<option>제조1팀</option>
			</select>
			<select class="sel-last select-st01" name="" title="검색내용을 선택해주세요">
				<option>성명</option>
				<option>아이디</option>
			</select>
			<div class="width-wrap">
				<input class="search-text" name="" title="검색내용을 입력해주세요" type="text"> 
				<button class="search-bnt" type="">
					<span>조회</span>
				</button>
			</div> -->
		</div><!--search-->
		<div class="board-wrap">
			<select name="inOutType" title="검색내용을 선택해주세요" class="inoutType select-st01 w90px fl mt10 mb5">
					<option value="">전체</option>
					<option value="I"
						<c:if test="${'I' eq paraEmp.inOutType}">
							selected
						</c:if>
					><spring:message code="label.WAB002.empInternal" /><!-- 내부 --></option>
					<option value="O"
						<c:if test="${'O' eq paraEmp.inOutType}">
							selected
						</c:if>
					><spring:message code="label.WAB002.empOutside" /><!-- 외부 --></option>
			</select>
			<table id="empTable" class="boardLst tblleft">
				<caption></caption>
				<colgroup>
					<col scope="col" width="*">
					<col scope="col" width="*">
					<col scope="col" width="*">
					<col scope="col" width="*">
				</colgroup>
				<thead>
					<tr>
						<th><spring:message code='label.number'/><!-- 번호 --></th>
						<th><spring:message code='label.WAB002.teamCode'/><!-- 부서(팀) --></th>
						<th><spring:message code='label.WAB002.empNumber'/><!-- 사번 --></th>
						<th><spring:message code='label.WAB002.empName'/><!-- 성명 --></th>
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
												<td>${empDomain.teamName}</td>
												<td>${empDomain.empNumber}</td>
												<td>${empDomain.empName}</td>
											</tr>
										</c:forEach>
								</c:when>
								<c:otherwise>
									<tr><td colspan="4"><spring:message code='label.WAK004.list8' /><!-- 데이터가 없습니다. --></td></tr>
								</c:otherwise>
							</c:choose>
							
					</c:if>
					<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '0' }"><%--조회권한 --%>
						<tr>
							<td colspan="4">
								<spring:message code='DNKR-E2-0000'/><!-- 권한이 없습니다. -->
							</td>
						</tr>
					</c:if>
				</tbody>
			</table>
		
		
			<!-- <select name="" title="검색내용을 선택해주세요" class="select-st01 w90px fl mt10 mb5">
					<option>전체</option>
					<option>내부직원</option>
					<option>외부업체</option>
			</select>
			<table class="boardLst tblleft">
				<caption>기본게시판</caption>
				<colgroup>
					<col class="w20p">
					<col class="">
					<col class="">
					<col class="">
				</colgroup>
				<thead>
					<tr>
						<th>번호</span></th>
						<th>부서</th>
						<th>사원<span class="in_bl">번호</span></th>
						<th>사원명</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>2564</td>
						<td>위기관리1</td>
						<td>OSW_test</td>
						<td>홍길동</td>
					</tr>
				</tbody>
			</table> -->
		</div>
		
		<div class="ssgap"></div>
		
		<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%--조회권한 --%>
			<c:if test="${fn:length(empList) > 0}">
				<div class="pagenation">
		            <smpl:seqpaging maxSeq="5" action='${pageContext.request.contextPath}/WAB001EmpSearch/search.do?tabId=${tabId}&menu=${menu}' formId="WAB001EmpSearchForm" />
		        </div>
		        <ai:pagingoption countPerPage="5" />
	        </c:if>
		</c:if>
		
		<!-- <ul class="paging-wrap">
			<li><a href="#n" class="first BdBg">첫페이지로</a></li>
			<li><a href="#n" class="prev BdBg">이전 페이지로</a></li>
			<li><a href="#n" class="active">1</a></li>
			<li><a href="#n" title="2페이지로 이동합니다.">2</a></li>
			<li><a href="#n" title="3페이지로 이동합니다.">3</a></li>
			<li><a href="#n" title="4페이지로 이동합니다.">4</a></li>
			<li><a href="#n" title="5페이지로 이동합니다.">5</a></li>
			<li><a href="#n" class="next BdBg">다음페이지로</a></li>
			<li><a href="#n" class="last BdBg">마지막페이지로</a></li>
		</ul> -->
		
		<div class="ssgap"></div>
		
		
		<div class="gap"></div>
	</form:form>
</div>


 <!-- container:E -->