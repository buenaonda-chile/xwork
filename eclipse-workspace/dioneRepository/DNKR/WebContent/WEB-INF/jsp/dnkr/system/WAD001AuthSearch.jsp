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
<%-- <spring:message code="label.filename" />
:
<c:out value="${url }"></c:out> --%>

<link rel="stylesheet" media="all" href="/css/board.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/admin/WAD001Auth.js?ver=0.1"></script>
<style>

/*==== board.css추가 ====*/
/* .list-top .search .search-text {
	height: 27px;
}

.list-top .search .search-bnt {
	padding: 5px 10px 5px 25px;
	vertical-align: bottom;
} */
/*==== //board.css추가 ====*/

table th:first-child, table th:nth-child(4) {
	width: 10%
}

table th:nth-child(2), table th:nth-child(3) {
	width: 25%
}

/* .input_tr input, .update_tr input {
	height: 17px;
} */



</style>
<!-- [EN] Contents area -->
<!-- [JP] コンテンツエリア -->

<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%--조회권한 --%>
	<div class="board-bList-wrap">
		<form:form action='${pageContext.request.contextPath}/WAD001AuthSearch/init.do?tabId=${tabId}' method="POST" modelAttribute="WAD001AuthSearchForm" name="WAD001AuthSearchForm" id="WAD001AuthSearchForm">
			<div class="list-top">
				<div class="search">
					<spring:message code="DNKR-I0-0010" var="LN_INSERT_AUTHGROUP"/><!-- 권한그룹명을 입력해주세요. -->
					<form:input class="search-text AXInput" type="text" path="authName" autofocus="true" name="authName" id="authName" placeholder="${LN_INSERT_AUTHGROUP}" title="${LN_INSERT_AUTHGROUP}"/>
					<button type="button" class="AXButton Black _searchBtn_" onclick="">
						<i class="axi axi-ion-android-search"></i>
						<spring:message code='label.search'/>
					</button>
					<c:if test="${fn:substring(authBinaryNum, 2, 3) eq '1' }"><%--등록권한 --%>
						<button type="button" class="AXButton Red _addBtn_" style=""
							onclick="" data-click-target="auth-add">
							<i>
								<!--  class="axi axi-ion-person-add"> -->
							</i> 
							<spring:message code="label.register" /><!-- 권한그룹등록 -->
						</button>
					</c:if>
					<%-- <button type="button" class="AXButton Normal _saveBtn_" onclick=""
						data-click-target="auth-save">
						<spring:message code='label.save' />
						<!-- 삭제 -->
					</button> --%>
					<!-- </form> -->
				</div>
				<!-- search -->
			</div>
			<!-- list-top -->
			<div class="gap10"></div>
			<span class="top-border"></span>
			<div class="m-scroll">
			<table style="min-width:700px">
				<caption></caption>
				<colgroup>
					<col scope="col" width="*">
					<!-- <col scope="col" width="*"> -->
					<!-- <col scope="col" width="*"> -->
					<!-- <col scope="col" width="*"> -->
					<col scope="col" width="*">
					<!-- <col scope="col" width="*" class="w60p"> -->
					<col scope="col" width="*">
					<col scope="col" width="*">
					<!-- <col scope="col" width="*"> -->
					<!-- <col scope="col" width="*"> -->
					<col scope="col" width="*">
				</colgroup>
				<thead>
					<tr>
						<th><!-- 번호 --><spring:message code='label.number'/></th>
						<th><!-- 권한그룹명 --><spring:message code='label.WAD001.list2'/></th>
						<th><!-- 권한그룹설명 --><spring:message code='label.WAD001.list3'/></th>
						<th><!-- 권한사용여부 --><spring:message code='label.useYn'/></th>
						<th><!-- 관리 --><spring:message code='label.management'/></th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${fn:substring(authBinaryNum, 2, 3) eq '1' }"><%--등록권한 --%>
						<tr class="input_tr displayNone">
							<%-- <form:form
								action="${pageContext.request.contextPath}/WAD001AuthSearch/create.do"
								method="POST" id="WAD001AuthCreateForm"> --%>
								<td></td>
								<td>
									<spring:message code="DNKR-I0-0011" var="LN_INSERT_AUTH_DESC"/><!-- 권한그룹 설명을 입력해주세요. -->
									<input class="AXInput authName" style="width: 100%;" type="text"
									id="authName" name="authName" placeholder="${LN_INSERT_AUTHGROUP}"
									title="${LN_INSERT_AUTHGROUP}" />
								</td>
								<td><input class="AXInput authDescription" style="width: 100%;" type="text"
									id="authDescription" name="authDescription"
									placeholder="${LN_INSERT_AUTH_DESC}" title="${LN_INSERT_AUTH_DESC}" /></td>
								<td>
									<spring:message code="DNKR-I0-0012" var="LN_AUTH_USEYN"/><!-- 권한 사용여부를 체크해주세요. -->
									<input class="useYn" style="width: 100%;" type="checkBox"
										id="useYn" value="Y" title="${LN_AUTH_USEYN}" checked />
								</td>
								<td>
									<div class="">
										<c:if test="${fn:substring(authBinaryNum, 2, 3) eq '1' }"><%--등록권한 --%>
											<button type="button" class="AXButton Blue _saveBtn_" onclick=""
												data-click-target="auth-save">
												<spring:message code='label.save' />
												<!-- 저장 -->
											</button>
										</c:if>
										<button type="button" class="AXButton Normal _cancelBtn_"
											onclick="" data-click-target="">
											<spring:message code='label.cancel' />
											<!-- 취소 -->
										</button>
									</div>
								</td>
							<%-- </form:form> --%>
						</tr>
					</c:if>
					<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%--조회권한 --%>
						<c:choose>
							<c:when test="${fn:length(authList) > 0}">	
								
									<c:if test="${fn:length(authList) > 0}">
										<c:set value="${fn:length(authList)}" var="authListSize"/>
										<c:forEach var="authDomain" items="${authList}" varStatus="status">
											<tr>
												<td>${totCount + 1 - authDomain.rowNum}</td>
												<td>${authDomain.authName}</td>
												<td>${authDomain.authDescription}</td>
												<td><c:choose>
														<c:when test="${authDomain.useYn eq 'Y'}">
															<spring:message code='label.useY' /><!-- 사용 -->
														</c:when>
														<c:otherwise>
															<spring:message code='label.useN' /><!-- 미사용 -->
														</c:otherwise>
													</c:choose></td>
												<td>
													<div class="">
														<c:if test="${fn:substring(authBinaryNum, 2, 3) eq '1' }"><%--등록권한 --%>
															<button type="button" class="AXButton Red _authConfigBtn_" style=""
																onclick="" data-menu='<c:out value="${menu}"/>' data-click-target="${authDomain.authCode}">
																<i>
																	<!--  class="axi axi-ion-person-add"> -->
																</i> 
																<spring:message code='label.WAD005.name' /><!-- 권한설정 -->
															</button>
														</c:if>
														<c:if test="${fn:substring(authBinaryNum, 1, 2) eq '1' }"><%--수정권한 --%>
															<button type="button" class="AXButton Normal _modifyBtn_"
																style="" onclick="" data-click-target="">
																<i>
																	<!--  class="axi axi-ion-person-add"> -->
																</i> 
																<spring:message code='label.modify' /><!-- 수정 -->
															</button>
														</c:if>
														<c:if test="${fn:substring(authBinaryNum, 0, 1) eq '1' }"><%--삭제권한 --%>
															<button type="button" class="AXButton Normal _deleteBtn_"
																onclick="" data-loction=""
																data-click-target="${authDomain.authCode}">
																<spring:message code='label.delete' />
																<!-- 삭제 -->
															</button>
														</c:if>
													</div>
												</td>
											</tr>
											
											<c:if test="${fn:substring(authBinaryNum, 1, 2) eq '1' }"><%--수정권한 --%>
												<tr class="update_tr displayNone">
													<%-- <form:form
														action="${pageContext.request.contextPath}/WAD001AuthSearch/update.do"
														method="POST" id="WAD001AuthCreateForm"> --%>
														<td>${totCount + 1 - authDomain.rowNum}</td>
							
														<td><input type="hidden" class="authCode" value="${authDomain.authCode}" />
															<input class="AXInput authName" style="width: 100%;" type="text" placeholder="${LN_INSERT_AUTHGROUP}"
															title="${LN_INSERT_AUTHGROUP}" value="${authDomain.authName}"></td>
														<td><input class="AXInput authDescription" style="width: 100%;" type="text" placeholder="${LN_INSERT_AUTH_DESC}" title="${LN_INSERT_AUTH_DESC}"
															value="${authDomain.authDescription}"></input></td>
														<td><input class="useYn" style="width: 100%;" type="checkBox" title="${LN_AUTH_USEYN}"
															<c:choose>
																	<c:when test="${authDomain.useYn eq 'Y'}">
																		value="Y" checked 
																	</c:when>
																	<c:otherwise>
																		value="N"
																	</c:otherwise>
																</c:choose> />
														</td>
														<!-- <td>223.112.92.101</td> -->
														<td>
															<div class="">
																<button type="button" class="AXButton Blue _saveBtn_" onclick=""
																	data-click-target="auth-modify">
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
													<%-- </form:form> --%>
												</tr>
											</c:if>
										</c:forEach>
									</c:if>
								
							</c:when>
							<c:otherwise>
								<tr><td colspan="5">데이터가 없습니다.</td></tr>
							</c:otherwise>
						</c:choose>
					</c:if>
					<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '0' }"><%--조회권한 --%>
						<tr><td colspan="5"><spring:message code='DNKR-E2-0000'/><!-- 권한이 없습니다. --></td></tr>
					</c:if>
				</tbody>
			</table>
			</div>
			<div class="gap20"></div>
			
		<%-- <form:form action="${pageContext.request.contextPath}/WAD001AuthSearch/init.do" method="POST" modelAttribute="WAD001AuthSearchForm" name="WAD001AuthSearchForm" id="WAD001AuthSearchFormPage"> --%>
			<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%--조회권한 --%>
				<c:if test="${fn:length(authList) > 0}">
					<div class="pagenation">
			            <smpl:seqpaging maxSeq="3" action="${pageContext.request.contextPath}/WAD001AuthSearch/init.do" formId="WAD001AuthSearchForm" />
			        </div>
			        <ai:pagingoption countPerPage="10" />
		        </c:if>
	        </c:if>
		<%-- </form:form> --%>
		</form:form>
		<form:form action='${pageContext.request.contextPath}/WAD001AuthSearch/create.do?tabId=<c:out value="${tabId}"/>' method="POST" id="WAD001AuthCreateForm">
			<input class="authName" name="authName" style="width: 100%;" type="hidden">
			<input class="authDescription" name="authDescription" type="hidden"/>
			<input class="useYn" type="hidden" id="useYn" name="useYn"/>
		</form:form>
	</div><!--board-view-wrap-->
</c:if>
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '0' }"><%--조회권한 --%>
	<div>
		<span><spring:message code='DNKR-E2-0000'/><!-- 권한이 없습니다. --></span>
	</div>
</c:if>
	
