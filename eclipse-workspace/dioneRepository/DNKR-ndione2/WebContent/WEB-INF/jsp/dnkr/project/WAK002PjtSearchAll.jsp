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

<link rel="stylesheet" media="all" href="/css/board.css"/>
<link rel="stylesheet" media="all" href="/css/content.css"/>
<c:if test="${fn:length(workSList) > 0}">
	<script type="text/javascript">
	var options = [];
	
	
	<c:forEach var="workSDomain" items="${workSList}" varStatus="status">
	
		options.push({value: "${workSDomain.workCode}", text: "${workSDomain.workTypeNm}"});
	
		
	</c:forEach>
	</script>
</c:if>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/project/WAK002PjtSearchAll.js?ver=1"></script>

<!-- [EN] Contents area -->
<!-- [JP] コンテンツエリア -->
<style>
	/* .pjt_board .list-top {
		overflow: visible;
	} */
	
#workAutoComplete input {
	height: 17px;
}

[data-ax5autocomplete] {
	display: inline-block;
	width: 150px;
	vertical-align: middle;
}

.form-control {
	/* height: 30px; */
	padding: 3px 12px;
}

.ax5autocomplete-display .ax5autocomplete-display-table 
[data-ax5autocomplete-display="label"]{
	
	padding: 0;
}

.ax5autocomplete-display .ax5autocomplete-display-table 
[data-ax5autocomplete-display="label-holder"] {
	width: 120px;
	height: 22px;
}

.ax5autocomplete-display .ax5autocomplete-display-table 
[data-ax5autocomplete-display="label"] 
[data-ax5autocomplete-selected-label] span {
	max-width: 100px;
}

.detail{
	left: auto;
	right: 150px;
}

</style>
<div class="board-bList-wrap pjt_board">
	<form:form action="${pageContext.request.contextPath}/WAK002PjtSearchAll/init.do?tabId=${tabId}" modelAttribute="pjtDomain" method="POST" name="pjtDomain" id="pjtDomain">
		<div class="list-top">
			
			<div class="fl">
				<div class="dropdown">
					<span class="calendar_icon vcen2"></span>
					<form:input type="text" class="dropbtn calendar_input" path="startDate" name="startDate" id="startDate"/>
					<div class="dropdown-menu" role="menu"  id="pjtAllCalendar" style="width:250px;
					           border:1px solid #ccc;
					           border-radius: 5px;
					           padding: 5px;
					           overflow: hidden;" >
					</div>
				</div>
				~
				<div class="dropdown">
					<span class="calendar_icon vcen2"></span>
					<form:input type="text" class="dropbtn calendar_input" path="endDate" name="endDate" id="endDate"/>
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
				<!-- asdfg -->
			<div class="searchWrap fl">
				<select class="workLCode" name="workLCode" id="workLCode" title="업무분류[대]를 선택해주세요">
					<option value=""><spring:message code="label.WAK001.list5"/><!-- 업무분류(대) --></option>
					<c:if test="${fn:length(workLList) > 0}">
						<c:forEach var="workLDomain" items="${workLList}" varStatus="status">
							<!-- <option>사업부전체</option> -->
							<option value="${workLDomain.workCode}" 
								<c:if test="${workLDomain.workCode eq getWorkLCode}">selected</c:if>
							><c:out value="${workLDomain.workTypeNm}"/></option>
						</c:forEach>
					</c:if>
				</select>
				<select class="workMCode" name="workMCode" id="workMCode" title="업무분류[중]를 선택해주세요">
					<option value=""><spring:message code="label.WAK001.list6"/><!-- 업무분류(중) --></option>
					<c:if test="${fn:length(workMList) > 0}">
						<c:forEach var="workMDomain" items="${workMList}" varStatus="status">
							<!-- <option>사업부전체</option> -->
							<option value="${workMDomain.workCode}"
								<c:if test="${workMDomain.workCode eq getWorkMCode}">selected</c:if>
							><c:out value="${workMDomain.workTypeNm}"/></option>
						</c:forEach>
					</c:if>
				</select>
				
				<select class="workSCode" name="workSCode" id="workSCode" title="업무분류[소]를 선택해주세요">
					<option value=""><spring:message code="label.WAK001.list7"/><!-- 업무분류(중) --></option>
					<c:if test="${fn:length(workSList) > 0}">
						<c:forEach var="workSDomain" items="${workSList}" varStatus="status">
							<!-- <option>사업부전체</option> -->
							<option value="${workSDomain.workCode}"
								<c:if test="${workSDomain.workCode eq getWorkSCode}">selected</c:if>
							><c:out value="${workSDomain.workTypeNm}"/></option>
						</c:forEach>
					</c:if>
				</select>
				
				<!-- 
				<div id="workAutoComplete" data-ax5autocomplete="workAutoComplete" data-ax5autocomplete-config="{editable: true}">
					<span>
         				<spring:message code="label.WAK001.list7"/><!-- 업무분류(소)
         			</span>
				</div>
       			<form:input type="hidden" id="workCode" path="workCode" name="workCode"/>
       			 -->
       			 
       			<spring:message code="DNKR-I0-0013" var="LN_REL_SYS"/><!-- 관련시스템을 입력하세요 -->
       			<form:input type="text" id="relSys" path="relSys" name="relSys" class="AXInput" placeholder="${LN_REL_SYS}" title="${LN_REL_SYS}"/>
       			<!-- <div id="workAutoComplete" data-ax5autocomplete="workAutoComplete" data-ax5autocomplete-config="{editable: true}"></div>
       			<input type="hidden" id="workCode" name="workCode"/> -->
				
				<button type="button" class="AXButton Black _searchBtn_" onclick="">
					<i class="axi axi-ion-android-search"></i>
					<spring:message code='label.search'/>
				</button>
			</div>
			
		</div>
		<div class="gap20"></div>
		<span class="top-border"></span>
		<%-- <form action="${pageContext.request.contextPath}/WAK009WorkConfirmSearch/update.do?tabId=<c:out value="${tabId}"/>" method="POST" name="pjtDomain" id="pjtDomainForm"> --%>
			<table class="pj_regist" id="pjtAllTable">
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
					<!-- <col scope="col" width="*">
					<col scope="col" width="*"> -->
				</colgroup>
				<thead>
					<tr>
						<th>
							<spring:message code="label.WAK001.list3"/><!-- 일자 -->
						</th>
						<th>
							<spring:message code="label.WAK001.list5"/><!-- 업무분류(대) -->
						</th>
						<th>
							<spring:message code="label.WAK001.list6"/><!-- 업무분류(중) -->
						</th>
						<th>
							<spring:message code="label.WAK001.list7"/><!-- 업무분류(소) -->
						</th>
						<th>
							<spring:message code="label.WAK001.list8"/><!-- 관련시스템  -->
						</th>
						<th>
							<spring:message code="label.WAK001.list9"/><!-- 업무영역(공통/지역) -->
						</th>
						<th>
							<spring:message code="label.WAK001.list4"/><!-- 업무시간(h) -->
						</th>
						<th>
							<spring:message code="label.WAK001.list10"/><!-- 업무상세  -->
						</th>
						<!-- <th>승인</th>
						<th>비고</th> -->
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${fn:length(pjtList) > 0}" >
							<c:forEach var="pjtDomain" items="${pjtList}" varStatus="status"> 
								<tr>
									<td><c:out value="${pjtDomain.regDate}"/></td>
									<td><c:out value="${pjtDomain.workLTypeNm}"/></td>
									<td><c:out value="${pjtDomain.workMTypeNm}"/></td>
									<td><c:out value="${pjtDomain.workTypeNm}"/></td>
									<td><c:out value="${pjtDomain.relSys}"/></td>
									<td>
										<c:choose>
											<c:when test="${pjtDomain.workTrtr eq 'CMCM00003'}">
												<spring:message code="label.WAK001.list14"/><!-- 공통 -->
											</c:when>
											<c:otherwise>
												<spring:message code="label.WAK001.list15"/><!-- 지역 -->
											</c:otherwise>
										</c:choose>
									<%-- 공통<c:out value="${pjtDomain.workTrtr}"/> --%>
									</td>
									<td>
										<c:choose>
										<c:when test="${(pjtDomain.workHour mod 60) eq 0}">
											<fmt:parseNumber integerOnly="true" value="${pjtDomain.workHour/60}"/>
											/0
										</c:when>
										<c:when test="${(pjtDomain.workHour mod 60) ne 0 && (pjtDomain.workHour/60)>0}">
											<fmt:parseNumber integerOnly="true" value="${pjtDomain.workHour/60}"/>
											/
											<fmt:parseNumber integerOnly="true" value="${pjtDomain.workHour mod 60}"/>
										</c:when>
										<c:otherwise>
											0
											/
											<fmt:parseNumber integerOnly="true" value="${pjtDomain.workHour}"/>
										</c:otherwise>
									</c:choose>
									</td>
									<td>
										<!-- 업무상세 영역 -->
										<button type="button" class="AXButton Red _detailBtn_"
												onclick="" data-loction=""
												data-click-target="${pjtDomain.pjtNum}">
												<spring:message code='label.view' /><!-- 보기 -->
										</button>
										<div class="detail">
											<div class="detail_wrap">
												<p class="tl mb10 pt3"><strong><spring:message code='label.WAK001.list10' /><!-- 업무상세 --></strong></p>
												<textarea class="workDtlCnts" readonly="readonly">
													<c:out value="${pjtDomain.workDtlCnts}"/>
												</textarea>
												<div class="sssgap"></div>
													<!-- <button type="submit" class="btn_type01 red">저장</button> -->
													<!-- <button type="button" class="btn_type01 close gray">닫기</button> -->
													<%-- <button type="button" class="AXButton Blue _saveBtn_" onclick=""
														data-click-target="">
														<spring:message code='label.save' />
														<!-- 저장 -->
													</button> --%>
													<button type="button" class="AXButton Normal _cancelBtn_"
														onclick="" data-click-target="workDtlCnts">
														<spring:message code='label.close' />
														<!-- 취소 -->
													</button>
											</div>
										</div>
									</td>
									<%-- <td>
										<input type="hidden" value="${pjtDomain.pjtNum}" name="pjtList[${status.index}].pjtNum" id="pjtList[${status.index}].pjtNum"/>승인
										<input type="radio" value="Y" name="pjtList[${status.index}].aprvType" id="pjtList[${status.index}].aprvType"/>승인
										<input type="radio" value="N" name="pjtList[${status.index}].aprvType" id="pjtList[${status.index}].aprvType"/>반려
									</td>
									<td>
										<input type="text" name="pjtList[${status.index}].note" value="${pjtDomain.note}"/>
									</td> --%>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="8">
									<spring:message code='label.WAK004.list8' /><!-- 데이터가 없습니다. -->
								</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		<!-- </form> -->
		<div class="gap20"></div>
		<div class="gap20"></div>
		<%-- <form:form action="${pageContext.request.contextPath}/WAK002PjtSearchAll/init.do" method="POST" modelAttribute="pjtDomain" name="pjtDomain" id="pjtDomainFormPage"> --%>
	
			<c:if test="${fn:length(pjtList) > 0}">
				<div class="pagenation">
		            <smpl:seqpaging maxSeq="10" action="${pageContext.request.contextPath}/WAK002PjtSearchAll/init.do" formId="pjtDomain" />
		        </div>
		        <ai:pagingoption countPerPage="10" />
	        </c:if>
		<%-- </form:form> --%>
		<div class="fl">
			<button type="button" onclick="javascript:location.href='${pageContext.request.contextPath}/WAK000PjtSearch/init.do?tabId=<c:out value="${tabId}"></c:out>&menu=<c:out value="${menu}"></c:out>'" class="gray" name="Cancel">
				뒤로가기
				<%-- <spring:message code="label.cancel" /> --%><!-- 취소 -->
			</button>
		</div>
		<div  class="fr inlineBlock">
			<button type="button" class="xlsDown" style="right:0px" onclick="downloadExcel();">
				<span><spring:message code='label.excelDown' /><!-- 엑셀다운 --></span>
			</button>
		</div>
	</form:form>
</div><!--board-view-wrap-->