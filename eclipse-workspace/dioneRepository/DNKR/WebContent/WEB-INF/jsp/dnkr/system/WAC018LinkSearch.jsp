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
<%-- <spring:message code="label.filename" />
:
<c:out value="${url }"></c:out> --%>

<link rel="stylesheet" media="all" href="/css/board.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/admin/WAC018LinkSearch.js?ver=0.1"></script>
<style>

</style>
<!-- [EN] Contents area -->
<!-- [JP] コンテンツエリア -->

	<div class="board-bList-wrap">
<%-- 		
		<form:form action='${pageContext.request.contextPath}/WAC018LinkSearch/init.do?tabId=${tabId}&menu=${menu}&pType=${pType}' method="POST" modelAttribute="WAC018LinkSearchForm" name="WAC018LinkSearchForm" id="WAC018LinkSearchForm">
 --%>		
 		<form:form action='${pageContext.request.contextPath}/WAC018LinkSearch/init.do?tabId=${tabId}&menu=${menu}' method="POST" modelAttribute="WAC018LinkSearchForm" name="WAC018LinkSearchForm" id="WAC018LinkSearchForm">
			<div class="list-top">
				<div class="search">
				<form:select autofocus="true" path="pType" style="width:200px" onChange="reSearch()">
							<form:option value="MAKER" label="MAKER 업무사이트" />
							<form:option value="GLOBAL" label="DESNO 글로벌사이트" />
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
					<!-- <col scope="col" width="*"> -->
					<col scope="col" width="*">
					<col scope="col" width="*">
					<col scope="col" width="*">
					<col scope="col" width="*">
					<col scope="col" width="*">
				</colgroup> 
				<thead>
					<tr>
					<%-- <th>페이지이동</th> No --%>
						<th><spring:message code='label.number'/></th> <%-- No --%>
						<th><spring:message code='label.siteName'/></th> <%-- 사이트명 --%>
						<th><spring:message code='label.siteUrl'/></th> <%-- 사이트주소 --%>
						<th><spring:message code='label.description'/></th> <%-- 사이트설명 --%>
						<th><spring:message code='label.etc'/></th> <%-- 비고  --%>
					</tr>
				</thead>
				<tbody>
						<c:choose>
							<c:when test="${fn:length(linkList) > 0}">	
									<c:if test="${fn:length(linkList) > 0}">
										<c:set value="${fn:length(linkList)}" var="linkListSize"/>
										<c:forEach var="linkDomain" items="${linkList}" varStatus="status">
											<tr onmouseover="this.bgColor='#dfdfdf';" onmouseout="this.bgColor='#ffffff'" ondblclick="linkOpen('${linkDomain.siteUrl}')" title ="<spring:message code="label.tooltip1"/>" style="height: 45px;">
												<td>${linkDomain.rowNum}</td>
												<td>${linkDomain.siteName}</td>
												<td style="text-align: left;">${linkDomain.siteUrl}</td>
												<td style="text-align: left;">${linkDomain.intro}</td>
												<td style="text-align: left;">${linkDomain.etc}</td>
											</tr>
										</c:forEach>
									</c:if>
							</c:when>
							<c:otherwise>
								<tr><td colspan="6">데이터가 없습니다.</td></tr>
							</c:otherwise>
						</c:choose>
				</tbody> 
			</table>
			</div>
			<div class="gap20"></div>
			<c:if test="${fn:length(linkList) > 0}">
				<div class="pagenation">
					<smpl:seqpaging maxSeq="3" action="${pageContext.request.contextPath}/WAC018LinkSearch/search.do" formId="WAC018LinkSearchForm" />
				</div>
				<ai:pagingoption countPerPage="10" />
			</c:if>
		</form:form>
	</div><!--board-view-wrap-->

	
