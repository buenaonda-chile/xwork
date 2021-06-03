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

<%-- <c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }">조회권한
</c:if> --%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/wamCommon.css?" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/wam/WAM002Sheet.js?ver=1"></script>
<div class="wrap">
	<div>
		<form method="POST" name="searchForm">
		<!-- 물류센터ID -->
		<!-- <select name="lc_id">
			<option value="0000001102">KCP미국향수출선적</option>
			
			<option value="0000001480">KCP창원물류센터</option>
			<option value="0000001101">KCP미국향수출선적</option>
			<option value="0000001102">LOGISALL USA물류센터</option>
		</select> -->
		
		<%-- <select class="clsCode" name="searchDate" id="searchDate" title="<spring:message code='DNKR-I0-0000'/>">
			
			<c:if test="${fn:length(dateList) > 0}">
				<option>
					<spring:message code='label.select'/>
				</option>
				<c:forEach var="domain" items="${dateList}" varStatus="status">
					<option value="${domain.releaseDate}"><c:out value="${domain.releaseDate}"/></option>
				</c:forEach>
			</c:if>
			<c:if test="${fn:length(dateList) == 0}">
				<option>
					<spring:message code='label.no_data'/>
				</option>
			</c:if>
		</select> --%>
		
		<div class="dropdown" id="cal_where1">
			<input autofocus="true" type="text" class="dropbtn calendar_input"  title="날짜를 선택해주세요" name="searchDate" id="searchDate">
			<div class="dropdown-menu" role="menu"  id="calendar_where1" style="width:250px;
			           border:1px solid #ccc;
			           border-radius: 5px;
			           padding: 5px;
			           overflow: hidden;" >
			</div>
		</div>
		
		<button type="button" class="AXButton Black _searchBtn_" onclick="">
			<i class="axi axi-ion-android-search"></i>
			<spring:message code='label.search'/>
		</button>
		<button type="button" class="xlsDown _excelBtn_" style="vertical-align: middle;">
			<span><spring:message code='label.excelDown' /><!-- 엑셀다운 --></span>
		</button>
	</div>
	</form>
	<div class="fl tipMsg" style="padding-top: 15px;"><span style="color:red;">날짜 선택 후 조회하세요.</span></div>
	<div class="ssgap"></div>
	<div class="gridWarp" style="height: 600px;">
		<div data-ax5grid="ship-grid" data-ax5grid-config="{frozenColumnIndex: 8, }" style="height: 100%;">
        </div>
    </div>
</div>