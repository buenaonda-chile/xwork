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
	<form:form action="${pageContext.request.contextPath}/WAE001ManagementSearchController/MaterialCostPeriod/search.do?tabId=${tabId}&menu=${menu}" method="POST"  modelAttribute="WAE001MngSearchForm" name="WAE001MngSearchForm">
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
				~
				<div class="dropdown">
					<span class="calendar_icon vcen2"></span>
					<input type="text" class="dropbtn calendar_input" name="endDate" id="endDate" value="${endDate}"/>
				</div>

				<select name="output1">
					<option value="-">-선택해주세요.-</option>
					<option value="1">1: 제조원가 명세서</option>
					<option value="2">2: STANDARD COST(OCEANS)</option>

				</select>
								
				<select name="output2">
					<option value="-">-선택해주세요.-</option>
					<option value="A">A: 생산실적</option>
					<option value="B">B: 판매실적</option>

				</select>
			</div>
			<div class="searchWrap fr">	
				<button type="button" class="AXButton Black _searchBtn_" onclick="javascript:document.WAE001MngSearchForm.submit();">
					<i class="axi axi-ion-android-search"></i>
					<spring:message code='label.search'/>
				</button>
			</div>			 
		</div>
		<div class="gap20"></div>
		<span class="top-border"></span>
		<div style="width:100%; overflow:auto">
		<table style="overflow: auto">
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
			</colgroup>
			<thead>

				<tr>
					<th><spring:message code='label.number'/><!-- 번호 --></th>
					<th><spring:message code='label.pyvnd'/><!-- 엡체 --></th>
					
					<th><spring:message code='label.pspno'/><!-- 품번 --></th>
					<th><spring:message code='label.itdsc'/><!-- 품명 --></th>
					<th><spring:message code='label.carnm'/><!-- 차종 --></th>
					<th><spring:message code='label.WAE001.yearPcost'/><!-- 년계획단가 --></th>
					<th><spring:message code='label.WAE001.price'/><!-- 현단가 --></th>
					<th><spring:message code='label.WAE001.krsur'/><!-- 원재료 --></th>
					<th><spring:message code='label.WAE001.surkr'/><!-- 원재료(KR) --></th>
					<th><spring:message code='label.WAE001.surus'/><!-- 원재료(US) --></th>
					<th><spring:message code='label.WAE001.surjp'/><!-- 원재료(JP) --></th>
					<th><spring:message code='label.WAE001.surur'/><!-- 원재료(UR) --></th>
					<th><spring:message code='label.WAE001.krpur'/><!-- 구매품(UR) --></th>
					<th><spring:message code='label.WAE001.krckd'/><!-- 구매품(KD) --></th>
					<th><spring:message code='label.WAE001.ckdus'/><!-- ＣＫＤ(US) --></th>
					<th><spring:message code='label.WAE001.ckdjp'/><!-- ＣＫＤ(JP) --></th>
					<th><spring:message code='label.WAE001.ckdusur'/><!-- ＣＫＤ(UR) --></th>
					<th><spring:message code='label.WAE001.ckduskr'/><!-- ＣＫＤ(KR) --></th>

					<th><spring:message code='label.april'/><!-- 4월 --></th>
					<th><spring:message code='label.may'/><!-- 5월 --></th>
					<th><spring:message code='label.june'/><!-- 6월 --></th>
					<th><spring:message code='label.july'/><!-- 7월 --></th>
					<th><spring:message code='label.august'/><!-- 8월 --></th>
					<th><spring:message code='label.september'/><!-- 9월 --></th>
					<th><spring:message code='label.october'/><!-- 10월 --></th>
					<th><spring:message code='label.november'/><!-- 11월 --></th>
					<th><spring:message code='label.december'/><!-- 12월 --></th>
					<th><spring:message code='label.january'/><!-- 1월  --></th>
					<th><spring:message code='label.february'/><!-- 2월 --></th>
					<th><spring:message code='label.march'/><!-- 3월 --></th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${fn:length(materialCostPeriodList) > 0}">
						<c:forEach var="DataWareHouseDomain" items="${materialCostPeriodList}" varStatus="status">
						<tr>
							<td>${DataWareHouseDomain.seqNo}</td>
							<td>${DataWareHouseDomain.pyvnd}</td>
							<td>${DataWareHouseDomain.pspno}</td>
							<td>${DataWareHouseDomain.itdsc}</td>
							<td>${DataWareHouseDomain.carnm}</td>
							<td>${DataWareHouseDomain.yearPcost}</td>
							<td>${DataWareHouseDomain.price}</td>
							<td>${DataWareHouseDomain.krsur}</td>
							<td>${DataWareHouseDomain.surkr}</td>
							<td>${DataWareHouseDomain.surus}</td>

							<td>${DataWareHouseDomain.surjp}</td>
							<td>${DataWareHouseDomain.surur}</td>
							<td>${DataWareHouseDomain.krpur}</td>
							<td>${DataWareHouseDomain.krckd}</td>
							<td>${DataWareHouseDomain.ckdus}</td>
							<td>${DataWareHouseDomain.ckdjp}</td>
							<td>${DataWareHouseDomain.ckdur}</td>
							<td>${DataWareHouseDomain.ckdkr}</td>
							<td>${DataWareHouseDomain.qty04}</td>
							<td>${DataWareHouseDomain.qty05}</td>
							
							<td>${DataWareHouseDomain.qty06}</td>
							<td>${DataWareHouseDomain.qty07}</td>
							<td>${DataWareHouseDomain.qty08}</td>
							<td>${DataWareHouseDomain.qty09}</td>
							<td>${DataWareHouseDomain.qty10}</td>
							<td>${DataWareHouseDomain.qty11}</td>
							<td>${DataWareHouseDomain.qty12}</td>
							<td>${DataWareHouseDomain.qty01}</td>
							<td>${DataWareHouseDomain.qty02}</td>
							<td>${DataWareHouseDomain.qty03}</td>
							<%-- <td>${logDomain.mcdCode }</td> --%>

						</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr><td colspan="30"><spring:message code='label.WAK004.list8' /></td></tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
		</div>
		<div class="gap20"></div>
			<c:if test="${fn:length(materialCostPeriodList) > 0}">
				<div class="paging-wrap">
		            <smpl:seqpaging maxSeq="10" action="${pageContext.request.contextPath}/WAE001ManagementSearchController/MaterialCostPeriod/search.do?tabId=${tabId}&menu=${menu}" formId="WAE001MngSearchForm" />
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