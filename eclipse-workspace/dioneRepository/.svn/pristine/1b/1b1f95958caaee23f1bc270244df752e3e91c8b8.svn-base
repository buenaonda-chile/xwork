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
<link rel="stylesheet" media="all" href="/css/content.css?ver=2"/>

<c:choose>
	<c:when test="${fn:length(workSList) > 0}">
		<script type="text/javascript">
		var options = [];
		
		
		<c:forEach var="relSys" items="${relSysList}" varStatus="status">
		
			options.push({value: "${fn:trim(relSys)}", text: "${fn:trim(relSys)}"});
		
		</c:forEach>
		</script>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
			var options = [];
		</script>
	</c:otherwise>
</c:choose>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/project/WAK000Pjt.js?ver=2"></script>

<style>
.table_wrap {
	position: relative;
	width: 100%;
	/*min-width: 1100px;*/
	display: inline-block;	 
	overflow-x: scroll;
}

.table_wrap table {
	width: 100%;
}

table.pj_regist td {
   width: 8%;
}

table.pj_regist td input {
	width: 100%
}

.relSysAutoComplete input ,#relSysAutoComplete input {
	height: 17px;
}

/* [data-ax5autocomplete] {
	display: inline-block;
	width: 150px;
	vertical-align: bottom;
} */

.form-control {
	 height: 36px; 
	 padding: 3px 0; 
}

/* .ax5autocomplete-display .ax5autocomplete-display-table 
[data-ax5autocomplete-display="label"]{
	
	padding: 0;
} */

/* .ax5autocomplete-display .ax5autocomplete-display-table 
[data-ax5autocomplete-display="label-holder"] {
	width: 120px;
	height: 22px;
} */

[data-ax5autocomplete].relSysAutoComplete > span {
 	color: black;
}

.ax5autocomplete-display .ax5autocomplete-display-table 
[data-ax5autocomplete-display="label"] 
[data-ax5autocomplete-selected-label] span {
	max-width: 100px;
}

.regist_form .ax5autocomplete-display .ax5autocomplete-display-table {
	height: 35px;
}

/* .board-write-wrap table th {
    min-width: 110px;
} */
.pjt-wrap .dropdown .dropdown-menu {
	left: auto;
	right: 0;
}

.pjt-wrap .dropdown .dropbtn {
	padding-left: 30px;
    width: 120px;
}

table.pj_regist td{
    padding: 10px 5px !important;
}

.regist_form li:first-child,.regist_form li:nth-child(2), .regist_form li:last-child {
	width: 11%
}

.regist_form li:nth-child(3), .regist_form li:nth-child(4), .regist_form li:nth-child(5){
	width: 13%;
}

.regist_form li:nth-child(6) {
	width: 22%;
}

	@media screen and (max-width:1200px){
		.regist_form li:first-child,.regist_form li:nth-child(2), .regist_form li:last-child {
			width: 25%
		}		
		.regist_form li:nth-child(3), .regist_form li:nth-child(4), .regist_form li:nth-child(5){
			width: 25%;
		}
	}


table.pj_regist th {
	min-width: 120px;
}

table.pj_regist th:nth-child(2), table.pj_regist th:nth-child(3), table.pj_regist th:nth-child(4) {
	width: 9%;
	min-width: 200px;
}

table.pj_regist th:first-child, 
table.pj_regist th:nth-child(9) {
	width: 9%;
}
table.pj_regist th:nth-child(6), table.pj_regist th:nth-child(7), table.pj_regist th:nth-child(8), table.pj_regist th:nth-child(10) {
	width: 4%;
}
 
table.pj_regist th:nth-child(5){
	width: 18%;
}

table.pj_regist th:nth-child(6), table.pj_regist th:nth-child(7), table.pj_regist th:nth-child(8) {
	min-width: 90px;
}

table.pj_regist th:nth-child(9) {
	min-width: 130px; /* 영문버튼너비에 맞춤 */
}

table.pj_regist select {
	width: 100%
}

table.pj_regist tr:last-child td {
	background: transparent;
}

.regist_form .dropdown .dropbtn{
	width: 100%
}

.regist_form .dropdown .dropdown-menu {
	left: 0;
	right: auto;
}
</style>

<!-- [EN] Contents area -->
<!-- [JP] コンテンツエリア -->

<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%--조회권한 --%>
	<div class="board-bList-wrap pjt-wrap">
		<div class="list-top">
			<c:if test="${fn:substring(authBinaryNum, 2, 3) eq '1' }"><%--등록권한 --%>
				<form:form action='${pageContext.request.contextPath}/WAK000PjtSearch/create.do?tabId=${tabId}' method="POST" id="WAK001PjtCreateForm">
					<span class="regist_form_tit">
						<spring:message code="label.project"/><!-- 프로젝트 -->
						<spring:message code="label.add"/><!-- 등록 -->
					</span>
					<div class="regist_form">
						<ul class="mb20">
							<li>
								<span class="stit"><spring:message code="label.WAK001.list3"/><!-- 일자 --></span>
								<div class="dropdown">
									<span class="calendar_icon vcen2"></span>
									<input autofocus="true" type="text" value="<c:out value="${insertDomain.workDate}"/>" class="dropbtn" name="workDate" id="workDate"/>
									<div class="dropdown-menu" role="menu"  id="regCalendar" style="width:250px;
									           border:1px solid #ccc;
									           border-radius: 5px;
									           padding: 5px;
									           overflow: hidden;" >
									</div>
								</div>
							</li>
							<li>
								<span class="stit"><spring:message code="label.WAK004.list3"/>(Min)<!-- 업무시간 --></span>
								<%-- <input class="text w90p" name="workHour" id="workHour" title="업무시간을 입력해주세요" type="text" value="${insertDomain.workHour}" placeholder="<spring:message code="label.WAK004.list3"/>(Min)"> --%>
								<input class="text w90p" name="workHour" id="workHour" title="업무시간을 입력해주세요" type="text" value="<fmt:parseNumber integerOnly="true" value="${insertDomain.workHour}"/>" placeholder="<spring:message code="label.WAK004.list3"/>(Min)">
							</li>
							<li>
								<span class="stit"><spring:message code="label.WAK001.list5"/><!-- 업무분류(대) --></span>
								<select class="workLCode" name="workLCode" id="workLCode" title="업무분류(대)를 선택해주세요">
									<option value=""><spring:message code="label.WAK001.list5"/><!-- 업무분류(대) --></option>
									<c:if test="${fn:length(workLList) > 0}">
										<c:forEach var="workLDomain" items="${workLList}" varStatus="status">Y
											<option value="${workLDomain.workCode}"
												<c:if test="${workLDomain.workCode eq insertDomain.workLCode}">
													selected
												</c:if>
											><c:out value="${workLDomain.workTypeNm}"/></option>
										</c:forEach>
									</c:if>
								</select>
							</li>
							<li>
								<span class="stit"><spring:message code="label.WAK001.list6"/><!-- 업무분류(중) --></span>
								<select class="workMCode" name="workMCode" id="workMCode" title="업무분류(중)를 선택해주세요">
									<option value=""><spring:message code="label.WAK001.list6"/><!-- 업무분류(중) --></option>
									<c:if test="${fn:length(workMList) > 0}">
										<c:forEach var="workMDomain" items="${workMList}" varStatus="status">
											<option value="${workMDomain.workCode}"
												<c:if test="${workMDomain.workCode eq insertDomain.workMCode}">
													selected
												</c:if>
											><c:out value="${workMDomain.workTypeNm}"/></option>
										</c:forEach>
									</c:if>
								</select>
							</li>
							<li>
								<span class="stit"><spring:message code="label.WAK001.list7"/><!-- 업무분류(소) --></span>
								<select class="workSCode" name="workCode" id="workCode" title="업무분류(소)를 선택해주세요">
									<option value=""><spring:message code="label.WAK001.list7"/><!-- 업무분류(소) --></option>
									<c:if test="${fn:length(workSList) > 0}">
										<c:forEach var="workDomain" items="${workSList}" varStatus="status">
											<option value="${workDomain.workCode}"
												<c:if test="${workDomain.workCode eq insertDomain.workCode}">
													selected
												</c:if>
											><c:out value="${workDomain.workTypeNm}"/></option>
										</c:forEach>
									</c:if>
								</select>
							</li>
							<li>
								<span class="stit"><spring:message code="label.WAK001.list8"/><!-- 관련시스템 --></span>
								<div id="relSysAutoComplete" data-ax5autocomplete="AutoComplete" data-ax5autocomplete-config="{editable: true}">
		            				<span>
		            					<spring:message code="label.WAK001.list8"/><!-- 관련시스템 -->
		            				</span>
		            			</div>
		            			<input type="hidden" id="relSys" name="relSys" />
		            			
		            			<!-- 자동완성기능 안쓸때 -->
		            			<%-- <input type="text" id="relSys" name="relSys" value="${insertDomain.relSys}"/> --%>
		            			<!-- //자동완성기능 안쓸때 -->
							</li>
							<li>
								<span class="stit"><spring:message code="label.WAK001.list9"/><!-- 업무영역 --></span>
								<select id="workTrtr" name="workTrtr">
									<c:choose>
										<c:when test="${insertDomain.workTrtr eq 'CMCM00004'}">
											<option value="CMCM00003"><spring:message code="label.WAK001.list14"/><!-- 공통 --></option>
											<option value="CMCM00004" selected><spring:message code="label.WAK001.list15"/><!-- 지역 --></option>
										</c:when>
										<c:otherwise>
											<option value="CMCM00003" selected><spring:message code="label.WAK001.list14"/><!-- 공통 --></option>
											<option value="CMCM00004"><spring:message code="label.WAK001.list15"/><!-- 지역 --></option>
										</c:otherwise>
									</c:choose>
								</select>
							</li>
						</ul>
						<div class="txt pb10">
							<span class="stit pb5"><spring:message code="label.WAK001.list10"/><!-- 업무상세 --></span>
							<textarea rows="4" style="width:98.8%" class="workDtlCnts" id="workDtlCnts" name="workDtlCnts"><c:out value="${insertDomain.workDtlCnts}"/></textarea>
						</div>
						
						<div class="" style="text-align: right">
						<c:if test="${fn:substring(authBinaryNum, 2, 3) eq '1' }"><%--등록권한 --%>
							<button name="Prepare" type="button" class="AXButton Red _saveBtn_" onclick="" data-click-target="pjt-save" onclick="" data-loction=""data-click-target="">
								<i class="axi axi-plus"></i>
								<spring:message code='label.add' />
							</button>
						</c:if>
					</div>
						
						
					</div>
					<div class="ssgap"></div>
				</form:form>
			</c:if>	
		
		
			<div class="fl bnt">
						<button type="button" class="black" onclick="javascript:location.href='${pageContext.request.contextPath}/WAK003PjtStatsSearch/init.do?tabId=<c:out value="${tabId}"></c:out>&menu=<c:out value="${menu}"></c:out>'">
							<spring:message code="label.WAK001.list1"/>
						</button>
						<button type="button" class="black" onclick="javascript:location.href='${pageContext.request.contextPath}/WAK002PjtSearchAll/init.do?tabId=<c:out value="${tabId}"></c:out>&menu=<c:out value="${menu}"></c:out>'">
							<spring:message code="label.WAK001.list2"/>
						</button>
					</div>
			<div class="fr top_right">
			<form action="${pageContext.request.contextPath}/WAK000PjtSearch/init.do?tabId=<c:out value="${tabId}"/>&menu=<c:out value="${menu}"></c:out>" method="POST" id="pjtSearchForm">
				<div class="dropdown">
					<span class="calendar_icon vcen2"></span>
					<input type="text" value="<c:out value="${searchDate}"/>" class="dropbtn" name="searchDate" id="searchDate"/>
					<div class="dropdown-menu" role="menu"  id="calendar-target1" style="width:250px;
					           border:1px solid #ccc;
					           border-radius: 5px;
					           padding: 5px;
					           overflow: hidden;" >
					</div>
				</div>
				<button type="button" class="AXButton Black _searchBtn_" onclick="">
						<!-- <i class="axi axi-ion-android-search"></i> -->
					<spring:message code='label.search'/>
				</button>
			</form>
			</div>
			<div class="gap10"></div>
			
			
			<div class="gap10"></div>
			
		</div>
		
		<div class="gap20"></div>
		<span class="top-border"></span>
		<div class="table_wrap">
			<table class="pj_regist">
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
				</colgroup>
				<thead>
					<tr>
						<th style="width:95px;min-width:95px">
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
						<th>
							<spring:message code="label.WAK001.list11"/><!-- 관리 -->
						</th>
						<th>
							<spring:message code="label.WAK001.list12"/><!-- 승인 -->
						</th>
						<th>
							<spring:message code="label.WAK001.rejectedReson"/><!-- 반려사유 -->
						</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${fn:length(pjtList) > 0}">
							<c:set var="sumHour" value="0"/>
							<c:forEach var="pjtDomain" items="${pjtList}" varStatus="status">
								<tr>
									<td><c:out value="${pjtDomain.workDate}"/></td>
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
									</td>
									<td>
										<c:set var="sumHour" value="${sumHour+pjtDomain.workHour}"/>
										<%-- <c:out value="${pjtDomain.workHour/60}"/> --%>
										<c:choose>
											<c:when test="${(pjtDomain.workHour mod 60) eq 0}">
												<fmt:parseNumber integerOnly="true" value="${pjtDomain.workHour/60}"/>
												: 0
											</c:when>
											<c:when test="${(pjtDomain.workHour mod 60) ne 0 && (pjtDomain.workHour/60)>0}">
												<fmt:parseNumber integerOnly="true" value="${pjtDomain.workHour/60}"/>
												:
												<fmt:parseNumber integerOnly="true" value="${pjtDomain.workHour mod 60}"/>
											</c:when>
											<c:otherwise>
												0
												:
												<fmt:parseNumber integerOnly="true" value="${pjtDomain.workHour}"/>
											</c:otherwise>
										</c:choose>
										
									</td>
									<td>
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
													<button type="button" class="AXButton Normal _cancelBtn_"
														onclick="" data-click-target="workDtlCnts">
														<spring:message code='label.close' />
														<!-- 취소 -->
													</button>
											</div>
										</div>
									</td>
									<td>
										<div class="">
											<c:if test="${pjtDomain.aprvType ne 'Y'}">
												<c:if test="${fn:substring(authBinaryNum, 1, 2) eq '1' }"><%--수정권한 --%>
													<button type="button" class="AXButton Normal _modifyBtn_"
														style="" onclick="" data-click-target="">
														<i>
															<!--  class="axi axi-ion-person-add"> -->
														</i> <spring:message code='label.modify' /> 
													</button>
												</c:if>
												<c:if test="${fn:substring(authBinaryNum, 0, 1) eq '1' }"><%--삭제권한 --%>
													<button type="button" class="AXButton Normal _deleteBtn_"
														onclick="" data-loction=""
														data-click-target="${pjtDomain.pjtNum}">
														<spring:message code='label.delete' />
														<!-- 삭제 -->
													</button>
												</c:if>
											</c:if>
										</div>
									</td>
									<td id="aprvType">
										<c:choose>
											<c:when test="${pjtDomain.aprvType eq 'S'}">
												<spring:message code='label.WAK001.waiting' /><!-- 대기 -->
											</c:when>
											<c:when test="${pjtDomain.aprvType eq 'Y'}">
												<spring:message code='label.WAK001.list12' /><!-- 승인 -->
											</c:when>
											<c:when test="${pjtDomain.aprvType eq 'N'}">
												<spring:message code='label.WAK001.rejected' /><!-- 반려 -->
											</c:when>
										</c:choose>
									</td>
									<td>
										<c:out value="${pjtDomain.note}"/>
									</td>
								</tr>
								<tr class="update_tr displayNone">
									<form:form action="${pageContext.request.contextPath}/WAK001PjtSearch/update.do" method="POST" id="">
										<td>
											<c:out value="${pjtDomain.workDate}"/>
											<input type="hidden" id="pjtNum" name="pjtNum" value="${pjtDomain.pjtNum}" />
										</td>
										<td>
											<select class="workLCode" name="workLCode" id="workLCode" title="업무분류(대)를 선택해주세요">
												<option value=""><spring:message code="label.WAK001.list5"/><!-- 업무분류(대) --></option>
												<c:if test="${fn:length(workLList) > 0}">
													<c:forEach var="workLDomain" items="${workLList}" varStatus="status">Y
														<option value="${workLDomain.workCode}"
															<c:if test="${pjtDomain.workLCode eq workLDomain.workCode}">
																selected
															</c:if>
														><c:out value="${workLDomain.workTypeNm}"/></option>
													</c:forEach>
												</c:if>
											</select>
										</td>
										<td>
											<select class="workMCode" name="workMCode" id="workMCode" title="업무분류(중)를 선택해주세요">
												<option value=""><spring:message code="label.WAK001.list6"/><!-- 업무분류(중) --></option>
												<c:if test="${fn:length(workMList) > 0}">
													<c:forEach var="workMDomain" items="${workMList}" varStatus="status">
														<option value="${workMDomain.workCode}"
															<c:if test="${pjtDomain.workMCode eq workMDomain.workCode}">
																selected
															</c:if>
														><c:out value="${workMDomain.workTypeNm}"/></option>
													</c:forEach>
												</c:if>
											</select>
										</td>
										<td>
											<select class="workSCode" name="workCode" id="workCode" title="업무분류(소)를 선택해주세요">
												<option value=""><spring:message code="label.WAK001.list7"/><!-- 업무분류(소) --></option>
												<c:if test="${fn:length(workSList) > 0}">
													<c:forEach var="workDomain" items="${workSList}" varStatus="status">
														<option value="${workDomain.workCode}"
															<c:if test="${pjtDomain.workCode eq workDomain.workCode}">
																selected
															</c:if>
														><c:out value="${workDomain.workTypeNm}"/></option>
													</c:forEach>
												</c:if>
											</select>
										</td>
										<td>
											<div class="relSysAutoComplete" data-ax5autocomplete="AutoComplete" data-ax5autocomplete-config="{editable: true}">
					            				<span class="relSys">
					            					<c:out value="${pjtDomain.relSys}"/>
				            					</span>
					            			</div>
											<input type="hidden" class="AXInput text w90p relSys" name="relSys" title="관련시스템을 입력해주세요" class="relSys" placeholder="관련시스템" value="<c:out value="${pjtDomain.relSys}"/>">
											<%-- <input type="text" class="AXInput text w90p relSys" name="relSys" title="관련시스템을 입력해주세요" id="relSys" placeholder="관련시스템" value="<c:out value="${pjtDomain.relSys}"/>"> --%>
										</td>
										<td>
											<select id="workTrtr" name="workTrtr">
												<c:choose>
													<c:when test="${pjtDomain.workTrtr eq 'CMCM00003'}">
														<option value="CMCM00003" selected><spring:message code="label.WAK001.list14"/><!-- 공통 --></option>
														<option value="CMCM00004"><spring:message code="label.WAK001.list15"/><!-- 지역 --></option>
													</c:when>
													<c:otherwise>
														<option value="CMCM00003"><spring:message code="label.WAK001.list14"/><!-- 공통 --></option>
														<option value="CMCM00004" selected><spring:message code="label.WAK001.list15"/><!-- 지역 --></option>
													</c:otherwise>
												</c:choose>
											</select>
										</td>
										<td><input type="text" class="AXInput text w90p" name="workHour" title="업무시간을 입력해주세요" id="workHour" placeholder="업무시간" value="<fmt:parseNumber integerOnly="true" value="${pjtDomain.workHour}"/>"/></td>
										<td>
											<button type="button" class="AXButton Red _detailBtn_"
												onclick="" data-loction=""
												data-click-target="${pjtDomain.pjtNum}">
												<spring:message code='label.view' /><!-- 보기 -->
											</button>
											<div class="detail">
												<div class="detail_wrap">
													<p class="tl mb10 pt3"><strong><spring:message code='label.WAK001.list10' /><!-- 업무상세 --></strong></p>
													<textarea class="workDtlCnts" name="workDtlCnts">
														<c:out value="${pjtDomain.workDtlCnts}"/>
													</textarea>
													<div class="sssgap"></div>
														<c:if test="${fn:substring(authBinaryNum, 1, 2) eq '1' }"><%--수정권한 --%>
															<button type="button" class="AXButton Blue _saveBtn_" onclick=""
																data-click-target="pjt-modify">
																<spring:message code='label.save' />
																<!-- 저장 -->
															</button>
														</c:if>
														<button type="button" class="AXButton Normal _cancelBtn_"
															onclick="" data-click-target="workDtlCnts">
															<spring:message code='label.cancel' />
															<!-- 취소 -->
														</button>
												</div>
											</div>
										</td>
										<td>
											<c:if test="${fn:substring(authBinaryNum, 1, 2) eq '1' }"><%--수정권한 --%>
												<div class="">
													<button type="button" class="AXButton Blue _saveBtn_" onclick=""
														data-click-target="pjt-modify">
														<spring:message code='label.save' />
														<!-- 저장 -->
													</button>
													<button type="button" class="AXButton Normal _cancelBtn_"
														onclick="" data-click-target="">
														<spring:message code='label.cancel' /><!-- 취소 -->
													</button>
												</div>
											</c:if>
										</td>
									</form:form>
									<td>
										<c:choose>
											<c:when test="${pjtDomain.aprvType eq 'S'}">
												<spring:message code='label.WAK001.waiting' /><!-- 대기 -->
											</c:when>
											<c:when test="${pjtDomain.aprvType eq 'Y'}">
												<spring:message code='label.WAK001.list12' /><!-- 승인 -->
											</c:when>
											<c:when test="${pjtDomain.aprvType eq 'N'}">
												<spring:message code='label.WAK001.rejected' /><!-- 반려 -->
											</c:when>
										</c:choose>
									</td>
									<td>
										<c:out value="${pjtDomain.note}"/>
									</td>
								</tr>
							</c:forEach>	
							<tr style="background:#ffebea; height: 55px; border-bottom: 2px solid #d7363c; color:#555;">
								<td colspan="6"><h2>업무시간(h)&nbsp;&nbsp;&nbsp; 합계</h2></td>
								<td style="border-left:1px solid #ddd;">
									<h2>
										<c:choose>
											<c:when test="${(sumHour mod 60) eq 0}">
												<fmt:parseNumber integerOnly="true" value="${sumHour/60}"/>
												: 0
											</c:when>
											<c:when test="${(sumHour mod 60) ne 0 && (sumHour/60)>0}">
												<fmt:parseNumber integerOnly="true" value="${sumHour/60}"/>
												:
												<fmt:parseNumber integerOnly="true" value="${sumHour mod 60}"/>
											</c:when>
											<c:otherwise>
												0
												:
												<fmt:parseNumber integerOnly="true" value="${sumHour}"/>
											</c:otherwise>
										</c:choose>
									</h2>
								</td>
								<td colspan="4"></td>
							</tr>
						</c:when>
						<c:otherwise>
							<tr><td colspan="11"><spring:message code='label.WAK004.list8' /><!-- 데이터가 없습니다. --></td></tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
		<div class="gap20"></div>
		
		<div class="gap20"></div>
	</div><!--board-view-wrap-->
</c:if>
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '0' }"><%--조회권한 --%>
	<div>
		<span><spring:message code='DNKR-E2-0000'/><!-- 권한이 없습니다. --></span>
	</div>
</c:if>