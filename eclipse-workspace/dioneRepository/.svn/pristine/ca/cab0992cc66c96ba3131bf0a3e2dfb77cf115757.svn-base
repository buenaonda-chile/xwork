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
<jsp:useBean id="today" class="java.util.Date"/>

<link rel="stylesheet" media="all" href="/css/content.css?ver"/>
<style>
	[data-ax5grid-container="root"] [data-ax5grid-panel-scroll="body"] table tr> td:FIRST-CHILD {
	    cursor: text;
	    box-shadow: inset 0 0 0 0 transparent;
	    background-color: transparent;
	    border-radius: inherit;
	    border-bottom: 1px solid #ccc !important;
	    border-right: 1px solid #ccc !important;
	}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/wae/WAE007MaterialReceiving.js"></script>
<!-- [EN] Contents area -->
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%--조회권한 --%>
	<form:form action="${pageContext.request.contextPath}/WAE007DWH/search.do?tabId=${tabId}&menu=${menu}" method="POST"  modelAttribute="WAE001MaterialReceivingSearchForm" name="WAE001MaterialReceivingSearchForm">
	<div class="WAE001_wrap">
			<div class="fr">
				<button class="blue btn-st02 _searchBtn_" type="button">
					<span>조회</span>
				</button>
			</div>
			<div class="sssgap"></div>
			<div class="top-bar cb">
				<strong class="pr5">사업부</strong>
				<!-- <select class="mr20 sel-st01" style="width:200px">
					<option>현대모비스</option>
					<option></option>
					<option></option>
				</select> -->
				<select name="comps" id="ComboBoxPlant" dataSet="ds_ComCode_PLNT">
					<c:if test="${fn:length(codeList) > 0}">
						<c:forEach var="codeD2Domain" items="${codeList}" varStatus="status">
							<option value="${codeD2Domain.code2}"><c:out value="${codeD2Domain.code_name}"/></option>
						</c:forEach>
					</c:if>
				</select>
				
				<!-- 조회년도를 선택해주세요 -->
				<div class="date-inwrap" data-ax5picker="basic" style="width:140px;">
					<span class="calendar_icon_b vcen2 c1"></span>
					<input type="text" name="year" id="year" style="width:140px; padding:0 40px" placeholder="yyyy" data-picker-date="year" 
					value='<fmt:formatDate value="${today}" pattern="yyyy"/>'/>
				</div>
				<!-- <select class="mr30 sel-st01" style="width:100px;">
					<option>생성일자</option>
					<option></option>
					<option></option>
				</select> -->
				<!-- <div class="date">
					<div class="date-inwrap">
						<span class="calendar_icon_b vcen2 c1"></span>
						<input class="boxform tc w90px" value="2018-02-02" readonly="" type="text">
					</div>
						<span>&nbsp;&nbsp;</span>
					<div class="date-inwrap">
						<span class="calendar_icon_b vcen2 c2"></span>
						<input class="boxform tc w90px" value="2018-02-02" readonly="" type="text">
					</div>
				</div> -->
			</div>
			<div class="sssgap"></div>
			<!--cont-->
			<div class="fl total">
				<strong>Total : <span class="total">0</span></strong>
			</div>
			<button class="green btn-st02 exel fr" type="button" name="Search">
				<span>엑셀</span>
			</button> 
			<div class="sssgap"></div>
			
			<c:choose>
				<c:when test="${false}">
					<div class="cont">
						<div class="ScollWarp">
						<table class="tableNew">
							<caption></caption>
							<colgroup>
								<col>
								<!-- <col> -->
								<col>
								<col>
								<col>
								<col>
								<col>
								<!-- <col class="pb">
								<col class="pm"> -->
								<col>
								<col>
								<col>
								<col>
								<col>
								<col>
								<col>
								<col>
								<col>
								<col>
								<col>
								<col>
								<col>
								<col>
								<col>
								<col>
								<col>
								<col>
								<col>
								<col>
							</colgroup>
							<thead>
				
								<tr>
									<th><spring:message code='label.number'/><!-- 번호 --></th>
									<%-- <th><spring:message code='label.comps'/><!-- 엡체 --></th> --%>
									<th><spring:message code='label.house'/><!-- 품번 --></th>
									<th><spring:message code='label.vndnr'/><!-- 품명 --></th>
									<th><spring:message code='label.vname'/><!-- 차종 --></th>
									<th><spring:message code='label.pspno'/><!-- 년계획단가 --></th>
									<th><spring:message code='label.itdsc'/><!-- 현단가 --></th>
									<th><spring:message code='label.ittyp'/><!-- 원재료 --></th>
									<th><spring:message code='label.itcls'/><!-- 원재료(KR) --></th>
									<th><spring:message code='label.prdgu'/><!-- 원재료(US) --></th>
									<th><spring:message code='label.prdcd'/><!-- 원재료(JP) --></th>
									<th><spring:message code='label.supgu'/><!-- 원재료(UR) --></th>
									<th><spring:message code='label.trcst'/><!-- 구매품(UR) --></th>
									<th><spring:message code='label.crcyw'/><!-- 구매품(KD) --></th>
									<th><spring:message code='label.trfot'/><!-- ＣＫＤ(US) --></th>
				
				                    <th><spring:message code='label.january'/><!-- 1월  --></th>
				                    <th><spring:message code='label.february'/><!-- 2월 --></th>
				                    <th><spring:message code='label.march'/><!-- 3월 --></th>
									<th><spring:message code='label.april'/><!-- 4월 --></th>
									<th><spring:message code='label.may'/><!-- 5월 --></th>
									<th><spring:message code='label.june'/><!-- 6월 --></th>
									<th><spring:message code='label.july'/><!-- 7월 --></th>
									<th><spring:message code='label.august'/><!-- 8월 --></th>
									<th><spring:message code='label.september'/><!-- 9월 --></th>
									<th><spring:message code='label.october'/><!-- 10월 --></th>
									<th><spring:message code='label.november'/><!-- 11월 --></th>
									<th><spring:message code='label.december'/><!-- 12월 --></th>
								</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${fn:length(materialReceivingList) > 0}">
										<c:forEach var="DataWareHouseDomain" items="${materialReceivingList}" varStatus="status">
										<tr>
											<td>${status.count}</td>
											<%-- <td>${DataWareHouseDomain.comps}</td> --%>
											<td>${DataWareHouseDomain.house}</td>
											<td>${DataWareHouseDomain.vndnr}</td>
											<td>${DataWareHouseDomain.vname}</td>
											<td>${DataWareHouseDomain.pspno}</td>
											<td>${DataWareHouseDomain.itdsc}</td>
											<td>${DataWareHouseDomain.ittyp}</td>
											<td>${DataWareHouseDomain.itcls}</td>
											<td>${DataWareHouseDomain.prdgu}</td>
				
											<td>${DataWareHouseDomain.prdcd}</td>
											<td>${DataWareHouseDomain.supgu}</td>
											<td>${DataWareHouseDomain.trcst}</td>
											<td>${DataWareHouseDomain.crcyw}</td>
											<td>${DataWareHouseDomain.trfot}</td>
											<td>${DataWareHouseDomain.month1}</td>
											<td>${DataWareHouseDomain.month2}</td>
											<td>${DataWareHouseDomain.month3}</td>
											<td>${DataWareHouseDomain.month4}</td>
											<td>${DataWareHouseDomain.month5}</td>
											
											<td>${DataWareHouseDomain.month6}</td>
											<td>${DataWareHouseDomain.month7}</td>
											<td>${DataWareHouseDomain.month8}</td>
											<td>${DataWareHouseDomain.month9}</td>
											<td>${DataWareHouseDomain.month10}</td>
											<td>${DataWareHouseDomain.month11}</td>
											<td>${DataWareHouseDomain.month12}</td>
											<%-- <td>${logDomain.mcdCode }</td> --%>
				
										</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<tr><td colspan="27"><spring:message code='label.WAK004.list8' /></td></tr>
									</c:otherwise>
								</c:choose>
							</tbody>
						</table>
					</div>
				<div class="gap"></div>
				</div><!--cont-->
			</c:when>
			<c:otherwise>
				<div style="position: relative;height:500px;" id="grid-parent">
				    <div data-ax5grid="unit-grid" data-ax5grid-config="{
				                    showLineNumber: true,
				                    lineNumberColumnWidth: 40}" style="height: 100%;">
			        </div>
				</div>
			</c:otherwise>
			
		</c:choose>
		
		
		
		
			<%-- <c:if test="${fn:length(materialReceivingList) > 0}">
				<div class="paging-wrap">
		            <smpl:seqpaging maxSeq="10" action="${pageContext.request.contextPath}/WAE001ManagementSearchController/MaterialReceiving/search.do?tabId=${tabId}&menu=${menu}" formId="WAE001MaterialReceivingSearchForm" />
                    
		        </div>
	        <ai:pagingoption countPerPage="10" />
	        </c:if> --%>
		</div><!--WAE001_wrap-->
    </form:form>
		 
</c:if>
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '0' }"><%--조회권한 --%>
	<div>
		<span><spring:message code='DNKR-E2-0000'/><!-- 권한이 없습니다. --></span>
	</div>
</c:if>