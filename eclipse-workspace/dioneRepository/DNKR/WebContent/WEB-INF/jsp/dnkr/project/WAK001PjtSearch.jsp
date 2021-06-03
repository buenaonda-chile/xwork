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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/project/WAK001Pjt.js"></script>

<style>
table.pj_regist td {
   width: 8%;
}

table.pj_regist td input {
	width: 100%
}

#workAutoComplete input {
	height: 17px;
}

[data-ax5autocomplete] {
	display: inline-block;
	width: 150px;
	vertical-align: bottom;
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

select {
	min-width: 100px;
}
</style>

<!-- [EN] Contents area -->
<!-- [JP] コンテンツエリア -->

<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%--조회권한 --%>
	<div class="board-bList-wrap pjt-wrap">
		<div class="list-top">
			<div class="fl bnt">
						<button type="button" class="black" onclick="javascript:location.href='${pageContext.request.contextPath}/WAK003PjtStatsSearch/init.do?tabId=<c:out value="${tabId}"></c:out>&menu=<c:out value="${menu}"></c:out>'">
							<spring:message code="label.WAK001.list1"/>
						</button>
						<button type="button" class="black" onclick="javascript:location.href='${pageContext.request.contextPath}/WAK002PjtSearchAll/init.do?tabId=<c:out value="${tabId}"></c:out>&menu=<c:out value="${menu}"></c:out>'">
							<spring:message code="label.WAK001.list2"/>
						</button>
					</div>
			<div class="fr top_right">
			<form action="${pageContext.request.contextPath}/WAK001PjtSearch/init.do?tabId=<c:out value="${tabId}"/>&menu=<c:out value="${menu}"></c:out>" method="POST" id="pjtSearchForm">
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
						<spring:message code="label.WAK001.list4"/><!-- 업무시간(h) -->
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
						<spring:message code="label.WAK001.list10"/><!-- 업무상세  -->
					</th>
					<th style="width:135px;min-width:135px">
						<spring:message code="label.WAK001.list11"/><!-- 관리 -->
					</th>
					<th>
						<spring:message code="label.WAK001.list12"/><!-- 승인 -->
					</th>
					<th>
						<spring:message code="label.WAK001.list13"/><!-- 비고 -->
					</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${fn:length(pjtList) > 0}">
					<c:forEach var="pjtDomain" items="${pjtList}" varStatus="status">
						<tr>
							<td><c:out value="${pjtDomain.workDate}"/></td>
							<td><c:out value="${pjtDomain.workHour}"/></td>
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
								<td><input type="text" class="AXInput text w90p" name="workHour" title="업무시간을 입력해주세요" id="workHour" placeholder="업무시간" value="<c:out value="${pjtDomain.workHour}"/>"></td>
								<td>
									<c:out value="${pjtDomain.workLTypeNm}"/>
								</td>
								<td>
								<c:out value="${pjtDomain.workMTypeNm}"/>
								</td>
								<td>
									<c:out value="${pjtDomain.workTypeNm}"/>
								</td>
								<td><input type="text" class="AXInput text w90p" name="relSys" title="관련시스템을 입력해주세요" id="relSys" placeholder="관련시스템" value="<c:out value="${pjtDomain.relSys}"/>"></td>
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
				</c:if>
				<c:if test="${fn:substring(authBinaryNum, 2, 3) eq '1' }"><%--등록권한 --%>
					<!-- 추가 입력폼 -->
					<tr class="input_tr displayNone">
						<form:form action='${pageContext.request.contextPath}/WAK001PjtSearch/create.do?tabId=${tabId}' method="POST" id="WAK001PjtCreateForm">
							<td>
								<jsp:useBean id="toDay" class="java.util.Date" />
								<fmt:formatDate value="${toDay}" pattern="yyyy-MM-dd" />
							</td>
							<td><input type="text" class="AXInput text w90p" name="workHour" title="업무시간을 입력해주세요" id="workHour" placeholder="업무시간"></td>
							<td>
								<select class="workLCode" name="workLCode" id="workLCode" title="업무분류[대]를 선택해주세요">
									<option value=""><spring:message code="label.WAK001.list5"/><!-- 업무분류(대) --></option>
									<c:if test="${fn:length(workLList) > 0}">
										<c:forEach var="workLDomain" items="${workLList}" varStatus="status">Y
											<option value="${workLDomain.workCode}"><c:out value="${workLDomain.workTypeNm}"/></option>
										</c:forEach>
									</c:if>
								</select>
							</td>
							<td>
								<select class="workMCode" name="workMCode" id="workMCode" title="업무분류[중]를 선택해주세요">
									<option value=""><spring:message code="label.WAK001.list6"/><!-- 업무분류(중) --></option>
									<c:if test="${fn:length(workMList) > 0}">
										<c:forEach var="workMDomain" items="${workMList}" varStatus="status">
											<option value="${workMDomain.workCode}"><c:out value="${workMDomain.workTypeNm}"/></option>
										</c:forEach>
									</c:if>
								</select>
							</td>
							<td>
								
		            			<div id="workAutoComplete" data-ax5autocomplete="workAutoComplete" data-ax5autocomplete-config="{editable: true}">
		            				<span>
		            					<spring:message code="label.WAK001.list7"/><!-- 업무분류(소) -->
		            				</span>
		            			</div>
		            			<input type="hidden" id="workCode" name="workCode"/>
		            			
		            			<form:errors path="workCode" cssStyle="color:#ff0000;" element="span" />
			            		
							</td>
							<td><input type="text" class="AXInput text w90p" name="relSys" title="관련시스템을 입력해주세요" id="relSys" placeholder="관련시스템"></td>
							<td>
								<select id="workTrtr" name="workTrtr">
									<option value="CMCM00003"><spring:message code="label.WAK001.list14"/><!-- 공통 --></option>
									<option value="CMCM00004"><spring:message code="label.WAK001.list15"/><!-- 지역 --></option>
								</select>
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
										<textarea class="workDtlCnts" id="workDtlCnts" name="workDtlCnts"></textarea>
										<div class="sssgap"></div>
											<button type="submit" class="btn_type01 red">
												<spring:message code='label.save' /><!-- 저장 -->
											</button>
											<button type="button" class="btn_type01 close gray"><spring:message code='label.close' /><!-- 닫기 --></button>
									</div>
								</div>
							</td>
							<td>
								<div class="">
									<button type="button" class="AXButton Blue _saveBtn_" onclick=""
										data-click-target="pjt-save">
										<spring:message code='label.save' />
										<!-- 삭제 -->
									</button>
									<button type="button" class="AXButton Normal _cancelBtn_"
										onclick="" data-click-target="">
										<spring:message code='label.cancel' />
										<!-- 삭제 -->
									</button>
								</div>
							</td>
						</form:form>
						<td>
						</td>
						<td>
						</td>
					</tr>
				</c:if>
			</tbody>
		</table>
		<div class="gap20"></div>
		<div class="">
			<c:if test="${fn:substring(authBinaryNum, 2, 3) eq '1' }"><%--등록권한 --%>
				<button name="Prepare" type="button" class="AXButton Red fl _addBtn_" onclick="" data-click-target="" onclick="" data-loction=""data-click-target="">
					<i class="axi axi-plus"></i>
					<spring:message code='label.add' />
				</button>
			</c:if>
		</div>
		<div class="gap20"></div>
	</div><!--board-view-wrap-->
</c:if>
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '0' }"><%--조회권한 --%>
	<div>
		<span><spring:message code='DNKR-E2-0000'/><!-- 권한이 없습니다. --></span>
	</div>
</c:if>