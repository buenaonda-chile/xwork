<%--
 * PROJECT：
 *
 * [KR] 품목별 입출고 조회
 * 
 * $Id$
 *
 * Copyright (c) 2017 DENSO CORPORATION. All rights reserved.
 *
--%>
<!-- [EN] Contents area -->
<!-- [JP] コンテンツエリア -->
<%-- <spring:message code="label.filename" /> : <c:out value="${url }"></c:out> --%>
<jsp:useBean id="today" class="java.util.Date" />

<link rel="stylesheet" media="all" href="/css/content.css?ver" />
<style>
[data-ax5grid-container="root"] [data-ax5grid-panel-scroll="body"] table tr>td:FIRST-CHILD
	{
	cursor: text;
	box-shadow: inset 0 0 0 0 transparent;
	background-color: transparent;
	border-radius: inherit;
	border-bottom: 1px solid #ccc !important;
	border-right: 1px solid #ccc !important;
}
.pd-s-table td input[type="text"] {width:80px !important}
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/WAA001SessionIdSelectPop.js"></script>
<!-- [EN] Contents area -->

<!-- <form name="gridForm" id="gridForm"> -->
<form name="WAA001SessionIdSelectPopForm" id="WAA001SessionIdSelectPopForm">

<table class="pd-s-table" style="margin-top:20px;width:280px">
	<colgroup>
		<col style="width:50px;" />
		<col style="width:50px;" />
	</colgroup>
	공장을 선택해주세요.
	<thead>
	<tr>
		<th><spring:message code='label.WAB002.empId'/></th> <%-- 아이디 --%>
		<th><spring:message code='label.WAB002.locCode'/></th> <%-- 사업장 --%>
	</tr>
	</thead>
	<tbody>
		<c:choose>
		<c:when test="${fn:length(idList) > 0}">	
			<c:if test="${fn:length(idList) > 0}">
				<c:set value="${fn:length(idList)}" var="linkListSize"/>
					<c:forEach var="idListDomain" items="${idList}" varStatus="status">
						<tr onmouseover="this.bgColor='#dfdfdf';" onmouseout="this.bgColor='#ffffff'" ondblclick="linkOpen('disPlay','${idListDomain.dioneId}','${idListDomain.companyCd}','${idListDomain.plantCd}')" title ="<spring:message code="label.tooltip1"/>" style="height: 45px;">
							<td style="text-align:center;">${idListDomain.dioneId}</td>
							<!--  
							<td style="text-align:center;">${idListDomain.plantCd}</td>
							-->
							<td style="text-align:center;">
								<%-- 
								<c:if test="${idListDomain.plantCd == 'E1'}"> 마산 </c:if>
								<c:if test="${idListDomain.plantCd == 'C1'}"> 창원 </c:if>
								<c:if test="${idListDomain.plantCd == 'S1'}"> 화성 </c:if>
								<c:if test="${idListDomain.plantCd == 'H1'}"> 홍성 </c:if>
								 --%>
								<c:if test="${idListDomain.plantCd == 'LOC000004'}"> 마산 </c:if>
								<c:if test="${idListDomain.plantCd == 'LOC000001'}"> 창원 </c:if>
								<c:if test="${idListDomain.plantCd == 'LOC000003'}"> 화성 </c:if>
								<c:if test="${idListDomain.plantCd == 'LOC000002'}"> 홍성 </c:if>
							</td>
							<%-- 
							<td style="text-align:center;">
								${idListDomain.companyCd}
							</td>
					 		--%>
						</tr>
					</c:forEach>
			</c:if>
		</c:when>
		<c:otherwise>
				<tr><td colspan="2">데이터가 없습니다.</td></tr>
		</c:otherwise>
		</c:choose>
	</tbody>
</table>
</form>

