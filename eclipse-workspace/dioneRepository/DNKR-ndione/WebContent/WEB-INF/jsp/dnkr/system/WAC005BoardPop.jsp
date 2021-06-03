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

<script type="text/javascript" src="${pageContext.request.contextPath}/js/commonPop.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/WAB005EmpSelectPop.js"></script>


<script>
	function emplSave(){
		$.ajax({
			type:"POST",
			url:"${pageContext.request.contextPath}/WAG004SurveyTarget/create.do?menu=${menu}&tabId=${tabId}",
			data : {srvCode : surveyidx},
			dataType : "json",
			async: false,
			success: function(data){
				alert(data.result);
			},
			error: function(xhr, status, error) {
				alert(error);
			}   
		});
	}
</script>

<h2 class="subpage-tit"><c:out value="${workTypeNm}"/> <spring:message code='label.circulation'/>&nbsp;<spring:message code='label.WAG001.individualSelect'/><!-- 회람자 개인별선택 --></h2>
<div class="board-bList-wrap">
	<div class="list-top">
		<div class="list-top text-right">
			<form:form action="${pageContext.request.contextPath}/WAC005BoardPop/empListPop.do" method="POST" name="EmpDomain" id="WAC005BoardPop">
		<div class="list-top text-right">
				<input type="hidden" name="clsCode" id="clsCode" value="${paraEmp.clsCode }" />
				<input type="hidden" name="locCode" id="locCode" value="${paraEmp.locCode }" />
				<input type="hidden" name="teamCode" id="teamCode" value="${paraEmp.teamCode }" />
				<input type="hidden" name="empName" id="empName" value="${paraEmp.empName }" />
				<input type="hidden" name="empId" id="empId" value="${paraEmp.empId }" />
				<input type="hidden" id="workCode" name="workCode" value="${workCode}"/>
				<input type="hidden" id="srvCode" name="srvCode" value="${srvCode }">
				
				<%-- 
				<!-- 사업부를 선택해주세요 -->
				<select class="clsCode" name="" style="width:88px" title="<spring:message code='DNKR-I0-0000'/>">
					<option>
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
				 --%>
				
				<!-- 사업장을 선택해주세요 -->
				<select class="locCode" name="" style="width:88px" title="<spring:message code='DNKR-I0-0001'/>">
					<option>
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
				<select class="teamCode" name="" style="width:150px" title="<spring:message code='DNKR-I0-0002'/>">
					<option>
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
				<select class="nameId" name="" style="width:72.8px" title="<spring:message code='DNKR-I0-0003'/>">
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
					<spring:message code='label.search'/><!-- 조회 -->
				</button>
				<button type="button" class="AXButton Blue _saveBtn_PopList" style="" onclick="" data-click-target="">
					<spring:message code='label.save'/><!-- 저장  -->
				</button>
				<button type="button" class="AXButton Normal _closeBtn_" style="" data-click-target="">
					<spring:message code='label.close'/><!-- 닫기 -->
				</button>
		</div>
			</form:form>
		</div>
	</div>

	<!-- list-top -->
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
		</colgroup>
		<thead>
			<tr>
				<th><spring:message code='label.number'/><!-- 번호 --></th>
				<th><spring:message code='label.WAB002.clsCode'/><!-- 사업부 --></th>
				<th><spring:message code='label.WAB002.locCode'/><!-- 사업장 --></th>
				<th><spring:message code='label.WAB002.teamCode'/><!-- 부서(팀) --></th>
				<th><spring:message code='label.WAB002.empName'/><!-- 성명 --></th>
				<th>
					<spring:message code='label.select'/><!-- 선택 -->
					<input type="checkbox" id="all_check" name="all_check">
				</th>
			</tr>
		</thead>
		<tbody>
			<%-- <form:form action="/ajaxWorkSort/aprvEmpSet.do?" id="aprvEmpSetForm" name="aprvEmpSetForm"  method="POST"> --%>
			<form action="/ajaxWorkSort/aprvEmpSet.do?"  modelAttribute="empDomain" id="aprvEmpSetForm" name="aprvEmpList"  method="POST">
				<input type="hidden" id="workCode" name="workCode" value="${workCode}"/>
				<c:choose>
					<c:when test="${fn:length(empList) > 0}">
						<c:set value="${fn:length(empList)}" var="itemListSize"/>
						<c:forEach var="empDomain" items="${empList}" varStatus="status">
							<tr>
								<%-- <td>${empDomain.rowNum}</td> --%>
								<td><c:out value="${status.index + 1}"/></td><!-- 번호 -->
								<td><c:out value="${empDomain.clsName}"/></td><!-- 사업부 -->
								<td><c:out value="${empDomain.locName}"/></td><!-- 사업장 -->
								
								<td><c:out value="${empDomain.teamName}"/></td><!-- 부서(팀) -->
								<td><c:out value="${empDomain.empName}"/> ( <c:out value="${empDomain.empId}"/> )</td><!-- 성명 -->
								<td><!-- 체크박스 -->
									
									<input type="checkbox" id="empNumList[${status.index}]" name="empNumList_${empDomain.teamCode}" class="empNumList"  value="${empDomain.empName}/${empDomain.empId}"
									/>
								</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr><td colspan="11"><spring:message code='label.WAK004.list8' /><!-- ë°ì´í°ê° ììµëë¤. --></td></tr>
					</c:otherwise>
				</c:choose>
			</form>
		</tbody>
	</table>
	<div class="gap20"></div>
	<%-- <form:form action="${pageContext.request.contextPath}/WAB001EmpSearch/empSelectPop.do" method="POST" modelAttribute="WAB001EmpSearchForm" name="WAB001EmpSearchForm" id="WAB001EmpSearchForm">

		<c:if test="${fn:length(empList) > 0}">
			<div class="pagenation">
	            <smpl:seqpaging maxSeq="3" action="${pageContext.request.contextPath}/WAB001EmpSearch/init.do" formId="WAB001EmpSearchForm" />
	        </div>
	        <ai:pagingoption countPerPage="3" />
        </c:if>
	</form:form> --%>
</div>
<!--board-view-wrap-->