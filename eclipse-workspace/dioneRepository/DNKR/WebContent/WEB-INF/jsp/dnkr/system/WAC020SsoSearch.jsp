<%--
 * PROJECT：
 *
 * [KR] 
 *  Rev0
      - 2018.11.23 JHB
      - 제외항목(DIONE, HR, Session은 메인화면에서 SSO처리로 제외함.)
      - 메인화면에서 제어하는경우는 별도의 SSO권한 처리를 하지 않음
 * $Id$
 *
 * Copyright (c) 2017 DENSO CORPORATION. All rights reserved.
 *
--%>
<!-- [EN] Contents area -->
<!-- [JP] コンテンツエリア -->
<%-- <spring:message code="label.filename" />
:
<c:out value="${url }"></c:out> --%>

<link rel="stylesheet" media="all" href="/css/board.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/admin/WAC020SsoSearch.js?ver=0.1"></script>
<style>

/*==== board.css추가 ====*/
/* .list-top .search .search-text {
	height: 27px;
}

.list-top .search .search-bnt {
	padding: 5px 10px 5px 25px;
	vertical-align: bottom;
} */
/*==== //board.css추가 ====*/
/* 
table th:first-child, table th:nth-child(4) {
	width: 10%
}

table th:nth-child(2), table th:nth-child(3) {
	width: 25%
}
 */
/* .input_tr input, .update_tr input {
	height: 17px;
} */



</style>
<!-- [EN] Contents area -->
<!-- [JP] コンテンツエリア -->

<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%--조회권한 --%>
	<div class="board-bList-wrap">
 		<form:form action='${pageContext.request.contextPath}/WAC020SsoSearch/init.do?tabId=${tabId}&menu=${menu}' method="POST" modelAttribute="WAC020SsoSearchForm" name="WAC020SsoSearchForm" id="WAC020SsoSearchForm">
			<div class="list-top">
				<div class="search">
					<spring:message code="DNKR-I0-0010" var="LN_INSERT_AUTHGROUP"/><!-- 권한그룹명을 입력해주세요. -->
					<form:select path="pCompany" id="pCompany" name="pCompany" autofocus="true" style="width:80px">
							<%-- <form:option value="" label="전체" />
							<form:option value="PE" label="구KE" />
							<form:option value="PS" label="구KA" /> --%>
							<form:option value="" label="전체" />
							<%--<form:option value="CLS000004" label="공통" /> --%>
							<form:option value="CLS000002" label="구KE" />
							<form:option value="CLS000001" label="구KA" />
					</form:select> 
					
				</div>
				<!-- search -->
			</div>
			<!-- list-top -->
			<div class="gap10"></div>
			<span class="top-border"></span>
			<div class="m-scroll">
			<table style="min-width:700px">
				<caption></caption>
				<colgroup>
 				<%--<col scope="col" width="*">--%>
					
					<col scope="col" width="*">
					<col scope="col" width="*">
					<col scope="col" width="*">
					<col scope="col" width="*">
					<col scope="col" width="*">
				</colgroup> 
				<thead>
					<tr>
						<th><spring:message code='label.number'/></th> <%-- No --%>
					<%--<th><spring:message code='label.sysSeq'/></th> <!--시스템SEQ--> --%>
						<th><spring:message code='label.WAB002.clsCode'/></th> <%-- 사업부 --%>
						<th><spring:message code='label.sysName'/></th> <%-- 시스템명 --%>
						<th><spring:message code='label.sysType'/></th> <%-- 시스템구분 --%>
						<th><spring:message code='label.inOutType'/></th> <%-- 내부/외부구분  --%>

					</tr>
				</thead>
				<tbody>
					<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"> <%--조회권한 --%>
						<c:choose>
							<c:when test="${fn:length(ssoList) > 0}">	
									<c:if test="${fn:length(ssoList) > 0}">
										<c:set value="${fn:length(ssoList)}" var="ssoListSize"/>
										<c:forEach var="linkDomain" items="${ssoList}" varStatus="status" >
											<%--
											<tr onmouseover="this.bgColor='#dfdfdf';" onmouseout="this.bgColor='#ffffff'" ondblclick="openLink(${linkDomain.sysSeq}, '${linkDomain.sysType}', '${linkDomain.company}')" title ="<spring:message code="label.tooltip1"/>" style="height: 45px;">
 											--%>											
 											<tr onmouseover="this.bgColor='#dfdfdf';" onmouseout="this.bgColor='#ffffff'" ondblclick="openLink(${linkDomain.sysSeq}, '${linkDomain.sysType}', '${linkDomain.company}')" title ="<spring:message code="label.tooltip1"/>" style="height: 45px;">
												<td>${linkDomain.rowNum}</td>
												<%-- <td>${linkDomain.sysSeq}</td> --%>
												<td>
												    <%-- 
													<c:choose>
														<c:when test="${linkDomain.company eq 'PE'}">
															구KE
														</c:when>
														<c:otherwise>
															구KA
														</c:otherwise>
													</c:choose>
													 --%>
													<c:choose>
														<c:when test="${linkDomain.company eq 'CLS000002'}">
															구KE
														</c:when>
														<c:when test="${linkDomain.company eq 'CLS000001'}">
															구KA
														</c:when>
														<c:otherwise>
															공통
														</c:otherwise>
													</c:choose>
												</td>
												<td>${linkDomain.sysName}</td>
												<td>${linkDomain.sysType}</td>	
												<td><c:choose>
														<c:when test="${linkDomain.inOutType eq 'O'}">
															외부
														</c:when>
														<c:otherwise>
															내부
														</c:otherwise>
													</c:choose>
												</td>
											</tr>
											
										</c:forEach>
									</c:if>
							</c:when>
							<c:otherwise>
								<tr><td colspan="5">데이터가 없습니다.</td></tr>
							</c:otherwise>
						</c:choose>
					</c:if>
					<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '0' }">  <%--조회권한 --%>
						<tr><td colspan="10"><spring:message code='DNKR-E2-0000'/><!-- 권한이 없습니다. --></td></tr>
					</c:if>
				</tbody> 
			</table>
			</div>
			<div class="gap20"></div>
			
			<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%--조회권한 --%>
				<c:if test="${fn:length(ssoList) > 0}">
					<div class="pagenation">
			            <smpl:seqpaging maxSeq="3" action="${pageContext.request.contextPath}/WAC020SsoSearch/search.do" formId="WAC020SsoSearchForm" />
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
	
