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

<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/WAC016Log.js"></script>
<!-- [EN] Contents area -->
<!-- [JP] コンテンツエリア -->
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%--조회권한 --%>
	<form:form action="${pageContext.request.contextPath}/WAC016Log/init.do?tabId=${tabId}&menu=${menu}" method="POST"  modelAttribute="WAC016LogSearchForm" name="WAC016LogSearchForm">
	<div class="board-bList-wrap log_board">
		<div class="list-top">
			<div class="fl">
				 
				<div class="dropdown">
					<span class="calendar_icon vcen2"></span>
					<input type="text" class="dropbtn calendar_input" name="startDate" id="startDate" value="${startDate}"/>
					<div class="dropdown-menu" role="menu"  id="log_calendar" style="width:250px;
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
				<!-- <select name="yy" title="날짜를 선택해주세요">
					<option>2017-10-05</option>
				</select> -->
			</div>
			<!-- <div class="gap10"></div> -->
				<!-- <input type="hidden" name="clsCode" id="clsCode"/>
				<input type="hidden" name="locCode" id="locCode"/>
				<input type="hidden" name="teamCode" id="teamCode"/>
				<input type="hidden" name="empName" id="empName"/>
				<input type="hidden" name="empId" id="empId"/> -->
			<div class="searchWrap fr">	
				
				<%-- 
				<!-- 사업부 구분 삭제-180831 -->
				<!-- 사업부를 선택해주세요 -->
				<select class="clsCode" id="clsCode" name=clsCode title="<spring:message code='DNKR-I0-0000'/>">
					<option value="">
						<spring:message code='label.cls_total'/><!-- 사업부전체 -->
					</option>
					<c:if test="${fn:length(clsList) > 0}">
						<c:forEach var="clsDomain" items="${clsList}" varStatus="status">
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
				<select class="locCode" autofocus="true" id="locCode" name="locCode" title="<spring:message code='DNKR-I0-0001'/>">
					<option value="">
						<spring:message code='label.loc_total'/><!-- 사업장전체 -->
					</option>
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
				
				<!-- 부서(팀)를 선택해주세요 -->
				<%-- <select class="teamCode" id="teamCode" name="teamCode" title="<spring:message code='DNKR-I0-0002'/>">
					<option>
						<spring:message code='label.team_total'/><!-- 부서(팀)전체 -->
					</option>
					<c:if test="${fn:length(teamList) > 0}">
						<c:forEach var="teamDomain" items="${teamList}" varStatus="status">
							<option value="${teamDomain.relationCode}"><c:out value="${teamDomain.relationName}"/></option>
						</c:forEach>
					</c:if>
				</select> --%>
				
				<!-- 성명 또는 아이디를 선택해주세요 -->
				<select class="nameId" name="nameId" title="<spring:message code='DNKR-I0-0003'/>">
			<%-- 			<option value="empName">
							<spring:message code='label.person_name'/><!-- 성명 -->
						</option>
						<option value="empId">
							<spring:message code='label.WAB002.empId'/><!-- 아이디 -->
						</option> --%>
						
						<c:choose>
						<c:when test="${paraDomain.empName ne ''}">
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
				
				<!-- 성명 또는 아이디를 입력해주세요  -->
				<input class="AXInput" id="searchData" name="searchData" type="text" title="<spring:message code='DNKR-I0-0004'/>"
					<c:choose>
						<c:when test="${paraDomain.empName ne ''}">
							value="${paraDomain.empName}"
						</c:when>
						<c:otherwise>
							value="${paraDomain.empId}"
						</c:otherwise>
					</c:choose>
				/>
				<button type="button" class="AXButton Black _searchBtn_" onclick="javascript:document.WAC016LogSearchForm.submit();">
					<i class="axi axi-ion-android-search"></i>
					<spring:message code='label.search'/>
				</button>
			</div>
			 
		</div>
		<div class="gap10"></div>
		<div class="m-scroll">
		<span class="top-border"></span>
		<table style="min-width:1000px">
			<caption></caption>
			<colgroup>
				<col scope="col" width="*">
				<col scope="col" width="*">
				<col scope="col" width="*">
				<col scope="col" width="*">
				<col scope="col" width="*">
				<!-- <col scope="col" width="*" class="w60p"> -->
				<col scope="col" width="*">
				<col scope="col" width="*">
				<col scope="col" width="*">
				<col scope="col" width="*">
			</colgroup>
			<thead>
				<tr>
					<th><spring:message code='label.number'/><!-- 번호 --></th>
					<th>접속일</th>
					<th>접속시간</th>
					<th><spring:message code='label.WAB002.clsCode'/><!-- 사업부 --></th>
					<th><spring:message code='label.WAB002.locCode'/><!-- 사업장 --></th>
					<th><spring:message code='label.WAB002.empName'/><!-- 성명 --></th>
					<th><spring:message code='label.WAB002.empId'/><!-- 아이디 --></th>
					<th>IP</th>
					<th>접속메뉴</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${fn:length(logList) > 0}">
						<c:forEach var="logDomain" items="${logList}" varStatus="status">
						<tr>
							<td>${logDomain.logIdx }</td>
							<td>${fn:substring(logDomain.logDate,0,10) }</td>
							<td>${fn:substring(logDomain.logDate,10,16) }</td>
							<td>${logDomain.clsName }</td>
							<td>${logDomain.locName }</td>
							<td>${logDomain.empName }</td>
							<td>${logDomain.empId }</td>
							<td>${logDomain.logIp }</td>
							<td>${logDomain.mcdName }</td>
							<%-- <td>${logDomain.mcdCode }</td> --%>
						</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr><td colspan="9"><spring:message code='label.WAK004.list8' /></td></tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
 		</div>
 		
		<div class="gap20"></div>
			<c:if test="${fn:length(logList) > 0}">
				<div class="paging-wrap">
		            <smpl:seqpaging maxSeq="10" action="${pageContext.request.contextPath}/WAC016Log/init.do?tabId=${tabId}&menu=${menu}" formId="WAC016LogSearchForm" />
		        </div>
	        <ai:pagingoption countPerPage="10" />
	        </c:if>
        </form:form>
		 
	</div><!--board-view-wrap-->
</c:if>
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '0' }"><%--조회권한 --%>
	<div>
		<span><spring:message code='DNKR-E2-0000'/><!-- 권한이 없습니다. --></span>
	</div>
</c:if>