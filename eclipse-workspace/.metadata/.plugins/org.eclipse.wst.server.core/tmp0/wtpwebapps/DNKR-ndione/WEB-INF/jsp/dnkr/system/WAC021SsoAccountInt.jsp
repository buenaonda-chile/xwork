<%--
 * PROJECT：
 *
 * [KR] 내부SSO사용자 관리
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

.grid-cell-red{
	background: #f8d2cb;
}
.grid-cell-blue{
	background: #dcf0f8;
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/WAC021SsoAccountInt.js"></script>
<!-- [EN] Contents area -->
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }">
	<%--조회권한 --%>
	<form:form>
		<div class="searchCondition">
			<div class="sssgap"></div>
			<div class="top-bar cb">
<%-- 				
				<!-- 사업부를 선택해주세요 -->
				<strong class="pr5"><spring:message code="label.WAB002.clsCode"/></strong> <select name="company"
					id="company">
					<c:if test="${fn:length(codeList2) > 0}">
						<c:forEach var="codeD2Domain2" items="${codeList2}"
							varStatus="status">
							<option value="${codeD2Domain2.code1}"><c:out
									value="${codeD2Domain2.code_name}" /></option>
						</c:forEach>
					</c:if>
				</select>			
				<!-- 사업장를 선택해주세요 -->
				<strong class="pr5"><spring:message code="label.WAB002.locCode"/></strong> <select name="comps"
					id="comps">
					<c:if test="${fn:length(codeList) > 0}">
						<c:forEach var="codeD2Domain" items="${codeList}"
							varStatus="status">
							<option value="${codeD2Domain.code2}"><c:out
									value="${codeD2Domain.code_name}" /></option>
						</c:forEach>
					</c:if>
				</select>
				 --%>
				 <!-- 사업부를 선택해주세요 -->
				<select class="clsCode" id="clsCode" name="clsCode" autofocus="true" onchange="commonClear()" style="width:99.2px" title="<spring:message code='DNKR-I0-0000'/>">
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
				<!-- 사업장를 선택해주세요 -->
				
				<select class="locCode" id="locCode" name="locCode" onchange="commonClear()" style="width:99.2px" title="<spring:message code='DNKR-I0-0001'/>">
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
				
				<!-- 성명 또는 아이디를 선택해주세요 -->
				<select class="nameId" name="" style="width:72.8px" title="<spring:message code='DNKR-I0-0003'/>">
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
				<input type="hidden" name="empName" path="empName" id="empName"/>
				<input type="hidden" name="empId" path="empId" id="empId"/>
				<input class="AXInput" id="searchData" style="width:161.6px" type="text" placeholder="<spring:message code='DNKR-I0-0004'/>" title="<spring:message code='DNKR-I0-0004'/>" 
					<c:choose>
						<c:when test="${paraDomain.empName ne ''}">
							value="${paraDomain.empName}"
						</c:when>
						<c:otherwise>
							value="${paraDomain.empId}"
						</c:otherwise>
					</c:choose>
				/>
				
				<div class="fr">
					<button class="blue btn-st02 _searchBtn_" type="button">
						<span><spring:message code="label.search"/><!-- 조회 --></span>
					</button>
					<button class="green btn-st02 exel fr" type="button" name="Search" style="margin-left:10px;">
						<span><spring:message code="label.excelBtn" /><!-- 엑셀 --></span>
					</button>
				</div>

			</div>
		</div>
			
		<div class="sssgap"></div>
		<!--cont-->
		<div class="fl total">
			<strong>Total : <span class="total">0</span></strong>
		</div>		
		<div class="sssgap"></div>
	
		<div class="grid-block">
			<table>
				<tr>
					<td rowspan="3">
						<div style="position: relative; height: 650px; width:760px;" id="grid-parent">
							<div data-ax5grid="unit-grid"
								data-ax5grid-config="{
							                    showLineNumber: true,
							                    lineNumberColumnWidth: 40}"
								style="height: 100%;"></div>
						</div>
					</td>
					<td><strong><spring:message code='label.WAB002.employee'/> : <span class="applyUserName"></span></strong>
						<div style="position: relative; height: 150px; width:760px;" id="grid-parent2">
							<div data-ax5grid="unit-grid2"
								data-ax5grid-config="{
							                    showLineNumber: true,
							                    lineNumberColumnWidth: 40}"
								style="height: 100%;"></div>
						</div>
					</td>
				</tr>
				<tr>	
					<td><strong>공장 : <span class="applyUserCompany"></span></strong>
						<div style="position: relative; height: 300px; width:760px;" id="grid-parent3">
							<div data-ax5grid="unit-grid3"
								data-ax5grid-config="{
							                    showLineNumber: true,
							                    lineNumberColumnWidth: 40}"
								style="height: 100%;"></div>
						</div>
						<div style="padding: 10px;">                                                          
							<button type="button" class="btn btn-default" data-grid-control="row-save">Save</button>      
							<button type="button" class="btn btn-default" data-grid-control="row-delete">Delete</button>      
						</div>
					</td>
				</tr>
<%-- 				
				<tr>
					<td>
						<span class="top-border"></span> 
						<table>
							<tr>
								<td><spring:message code='label.sysSeq'/><!-- 시스템Seq --></td>
								<td><input type ="text" id="sysSeq" name ="sysSeq" readonly=true></td>
							</tr>
							<tr>
								<td><spring:message code='label.WAB002.empId'/><!-- 사용자ID --></td>
								<td><input type ="text" id="userId" name ="userId" readonly=true></td>
							</tr>
							<tr>
								<td><spring:message code='label.systemId'/><!-- 시스템ID --></td>
								<td><input type ="text" id="systemId" name ="systemId"></td>
							</tr>
							<tr>
								<td><spring:message code='label.password'/><!-- 패스워드 --></td>
								<td><input type ="text" id="systemPW" name ="systemPW"></td>
							</tr>
							<tr>
								<td><spring:message code='label.device'/><!-- 디바이스 --></td>
								<td><input type ="text" id="systemGroup" name ="systemGroup"></td>
							</tr>
							<tr>
								<td><spring:message code='label.bigo'/><!-- 비고 --></td>
								<td><input type ="text" id="remarks" name ="remarks"></td>
							</tr>
						</table>
						</div>
					</td>
				</tr> --%>
				
			</table>
		</div>
		<div class="sssgap"></div>
		
		<!--WAE001_wrap-->
	</form:form>

</c:if>
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '0' }">
	<%--조회권한 --%>
	<div>
		<span><spring:message code='DNKR-E2-0000' /> <!-- 권한이 없습니다. --></span>
	</div>
</c:if>