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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/wae/WAE001Management.js"></script>
<!-- [EN] Contents area -->
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%--조회권한 --%>
	<form:form action="${pageContext.request.contextPath}/WAE001ManagementSearchController/StandardCost/search.do?tabId=${tabId}&menu=${menu}" method="POST"  modelAttribute="WAE001StandardCostSearchForm" name="WAE001StandardCostSearchForm">
	<div class="board-bList-wrap log_board">
		<div class="list-top">
			<div class="fl">
				 
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
				
				<!-- 사업장을 선택해주세요 -->
				<select class="locCode" id="locCode" name="locCode" title="<spring:message code='DNKR-I0-0001'/>">
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
				<!-- 조회년을 선택해주세요 -->
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
			</div>
			<div class="searchWrap fr">	
				<button type="button" class="AXButton Black _searchBtn_" onclick="javascript:document.WAE001StandardCostSearchForm.submit();">
					<i class="axi axi-ion-android-search"></i>
					<spring:message code='label.search'/>
				</button>
			</div>
			 
		</div>
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
					<th><spring:message code='label.number'/><!-- 번호 --></th>
					<th><spring:message code='label.eprtno'/><!-- 엡체 --></th>
					<th><spring:message code='label.eitdsc'/><!-- 품번 --></th>
					<th><spring:message code='label.eprocd'/><!-- 품명 --></th>
					<th><spring:message code='label.emnfcs'/><!-- 차종 --></th>
					<th><spring:message code='label.edircs'/><!-- 년계획단가 --></th>
					<th><spring:message code='label.emcost'/><!-- 현단가 --></th>
					<th><spring:message code='label.ermatc'/><!-- 원재료 --></th>
					<th><spring:message code='label.ermatl'/><!-- 원재료(KR) --></th>
					<th><spring:message code='label.ermati'/><!-- 원재료(US) --></th>

					<th><spring:message code='label.ermimc'/><!-- 원재료(JP) --></th>
					<th><spring:message code='label.epurcs'/><!-- 원재료(UR) --></th>
					<th><spring:message code='label.epurcl'/><!-- 구매품(UR) --></th>
					<th><spring:message code='label.epurci'/><!-- 구매품(KD) --></th>
					<th><spring:message code='label.eppimc'/><!-- ＣＫＤ(US) --></th>
                    <th><spring:message code='label.eprcst'/><!-- 원재료(JP) --></th>
                    <th><spring:message code='label.elabcs'/><!-- 원재료(UR) --></th>
                    <th><spring:message code='label.edepcs'/><!-- 구매품(UR) --></th>
                    <th><spring:message code='label.emfexp'/><!-- 구매품(KD) --></th>
                    <th><spring:message code='label.ediecs'/><!-- ＣＫＤ(US) --></th>

                    <th><spring:message code='label.emohcs'/><!-- 원재료(JP) --></th>
                    <th><spring:message code='label.efixdt'/><!-- 원재료(UR) --></th>
                    <th><spring:message code='label.ercomp'/><!-- 구매품(UR) --></th>
                    <th><spring:message code='label.ebrmtl'/><!-- 구매품(KD) --></th>
                    <th><spring:message code='label.ebrmti'/><!-- ＣＫＤ(US) --></th>
                    <th><spring:message code='label.ebrmic'/><!-- 원재료(JP) --></th>
                    <th><spring:message code='label.ebpurl'/><!-- 원재료(UR) --></th>
                    <th><spring:message code='label.ebpuri'/><!-- 구매품(UR) --></th>
                    <th><spring:message code='label.ebppic'/><!-- 구매품(KD) --></th>
                    <th><spring:message code='label.eblabc'/><!-- ＣＫＤ(US) --></th>

                    <th><spring:message code='label.ebdepc'/><!-- 원재료(JP) --></th>
                    <th><spring:message code='label.ebmexp'/><!-- 원재료(UR) --></th>
                    <th><spring:message code='label.ebdiec'/><!-- 구매품(UR) --></th>
                    <th><spring:message code='label.eocean'/><!-- 구매품(KD) --></th>
                    <th><spring:message code='label.einsdt'/><!-- ＣＫＤ(US) --></th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${fn:length(standardCostList) > 0}">
						<c:forEach var="DataWareHouseDomain" items="${standardCostList}" varStatus="status">
						<tr>
							<td>${DataWareHouseDomain.seqNo}</td>
							<td>${DataWareHouseDomain.prtno}</td>
							<td>${DataWareHouseDomain.itdsc}</td>
							<td>${DataWareHouseDomain.procd}</td>
							<td>${DataWareHouseDomain.mnfcs}</td>
							<td>${DataWareHouseDomain.dircs}</td>
							<td>${DataWareHouseDomain.mcost}</td>
							<td>${DataWareHouseDomain.rmatc}</td>
							<td>${DataWareHouseDomain.rmatl}</td>
							<td>${DataWareHouseDomain.rmati}</td>

							<td>${DataWareHouseDomain.rmimc}</td>
							<td>${DataWareHouseDomain.purcs}</td>
							<td>${DataWareHouseDomain.purcl}</td>
							<td>${DataWareHouseDomain.purci}</td>
							<td>${DataWareHouseDomain.ppimc}</td>
                            <td>${DataWareHouseDomain.prcst}</td>
                            <td>${DataWareHouseDomain.labcs}</td>
                            <td>${DataWareHouseDomain.depcs}</td>
                            <td>${DataWareHouseDomain.mfexp}</td>
                            <td>${DataWareHouseDomain.diecs}</td>

                            <td>${DataWareHouseDomain.mohcs}</td>
                            <td>${DataWareHouseDomain.fixdt}</td>
                            <td>${DataWareHouseDomain.rcomp}</td>
                            <td>${DataWareHouseDomain.brmtl}</td>
                            <td>${DataWareHouseDomain.brmti}</td>
                            <td>${DataWareHouseDomain.brmic}</td>
                            <td>${DataWareHouseDomain.bpurl}</td>
                            <td>${DataWareHouseDomain.bpuri}</td>
                            <td>${DataWareHouseDomain.bppic}</td>
                            <td>${DataWareHouseDomain.blabc}</td>

                            <td>${DataWareHouseDomain.bdepc}</td>
                            <td>${DataWareHouseDomain.bmexp}</td>
                            <td>${DataWareHouseDomain.bdiec}</td>
                            <td>${DataWareHouseDomain.ocean}</td>
                            <td>${DataWareHouseDomain.insdt}</td>
							<%-- <td>${logDomain.mcdCode }</td> --%>

						</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr><td colspan="35"><spring:message code='label.WAK004.list8' /></td></tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
		<div class="gap20"></div>
			<c:if test="${fn:length(standardCostList) > 0}">
				<div class="paging-wrap">
		            <smpl:seqpaging maxSeq="10" action="${pageContext.request.contextPath}/WAE001ManagementSearchController/StandardCost/search.do?tabId=${tabId}&menu=${menu}" formId="WAE001StandardCostSearchForm" />
                    
		        </div>
	        <ai:pagingoption countPerPage="10" />
	        </c:if>
	</div><!--board-view-wrap-->
    </form:form>
		 
</c:if>
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '0' }"><%--조회권한 --%>
	<div>
		<span><spring:message code='DNKR-E2-0000'/><!-- 권한이 없습니다. --></span>
	</div>
</c:if>