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
	src="${pageContext.request.contextPath}/js/admin/WAC017Link.js?ver=0.1"></script>
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
/* 
table th:first-child, table th:nth-child(4) {
	width: 10%
}

table th:nth-child(2), table th:nth-child(3) {
	width: 25%
}
 */
/* .input_tr input, .update_tr input {
	height: 17px;
} */



</style>
<!-- [EN] Contents area -->
<!-- [JP] コンテンツエリア -->

<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%--조회권한 --%>
	<div class="board-bList-wrap">
		<form:form action='${pageContext.request.contextPath}/WAC017LinkManagement/init.do?tabId=${tabId}' method="POST" modelAttribute="WAC017LinkManagementForm" name="WAC017LinkManagementForm" id="WAC017LinkManagementForm">
			<div class="list-top">
				<div class="search">
					<spring:message code="DNKR-I0-0010" var="LN_INSERT_AUTHGROUP"/><!-- 권한그룹명을 입력해주세요. -->
					<form:select autofocus="true" path="pType" style="width:150px"> 
							<form:option value="" label="전체" />
							<form:option value="MAKER" label="MAKER 업무사이트" />
							<form:option value="GLOBAL" label="DESNO 글로벌사이트" />
					</form:select>
					<form:select path="pUseTf">
							<form:option value="" label="전체" />
							<form:option value="Y" label="사용" />
							<form:option value="N" label="미사용" />
					</form:select>
						
<%-- 					<form:input class="search-text AXInput" type="text" path="authName" name="authName" id="authName" placeholder="${LN_INSERT_AUTHGROUP}" title="${LN_INSERT_AUTHGROUP}"/>
 --%>					

 	             	<form:button class="AXButton Black _searchBtn_ ml5" name="search"><i class="axi axi-ion-android-search"></i><spring:message code="label.search" /></form:button>
			
					<c:if test="${fn:substring(authBinaryNum, 2, 3) eq '1' }"> <%--등록권한 --%>
						<button type="button" class="AXButton Red _addBtn_ ml5" style="" onclick="" data-click-target="action-add">
							<i>
								<!--  class="axi axi-ion-person-add"> -->
							</i> 
							<spring:message code="label.register" /> <%-- 링크추가등록 --%>
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
<%-- 				<col scope="col" width="*"> --%>
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
				<%--	<th>SEQ No</th> <%-- SEQ --%>
						<th><spring:message code='label.number'/></th> <%-- No --%>
						<th><spring:message code='label.type'/></th> <%-- 구분 --%>
						<th><spring:message code='label.siteName'/></th> <%-- 사이트명 --%>
						<th><spring:message code='label.siteUrl'/></th> <%-- 사이트주소 --%>
						<th><spring:message code='label.description'/></th> <%-- 사이트설명 --%>
						<th><spring:message code='label.sortNo'/></th> <%-- 정렬순서 --%>
						<th><spring:message code='label.useYn'/></th> <%-- 사용여부 --%>
						<th><spring:message code='label.etc'/></th> <%-- 비고  --%>
						<th><spring:message code='label.management'/></th> <%-- 관리  --%>
					</tr>
				</thead>
				<tbody>
 					<c:if test="${fn:substring(authBinaryNum, 2, 3) eq '1' }"><%--등록권한 --%>
						<tr class="input_tr displayNone">
						<%--	<td> SEQ</td> --%>
							<td><%-- ROW NUM --%></td>
							<td>
								<form:select path="iType" style="width:150px">
									<form:option value="MAKER" label="MAKER 업무사이트" />
									<form:option value="GLOBAL" label="DENSO 글로벌사이트" />
								</form:select>
							</td>
							<td><input class="AXInput siteName" style="width: 100%;" type="text"
								id="siteName" name="siteName" placeholder="사이트명을 입력해주세요" title="사이트명을 입력하세요"  maxlength="40" />
							</td>
							<td><input class="AXInput siteUrl" style="width: 100%;" type="text"
								id="siteUrl" name="siteUrl" placeholder="사이트주소를 입력해주세요" title="사이트주소를 입력하세요"  maxlength="80" />
							</td>
							<td><input class="AXInput intro" style="width: 100%;" type="text"
								id="intro" name="intro" placeholder="사이트 설명을 입력해주세요" title="사이트 설명을 입력하세요" maxlength="80" />
							</td>
							<td><input class="AXInput sort" style="width: 100%;" type="text"
								id="sort" name="sort" placeholder="정렬순서를 입력해주세요" title="사이트명을 입력하세요" maxlength="3" />
							</td>
							<td>
								<spring:message code="DNKR-I0-0012" var="LN_AUTH_USEYN"/><%-- 사용여부를 체크해주세요. --%>
								<input class="useYn" style="width: 100%;" type="checkBox"
								id="useTf" name="useTf" value="Y" title="" checked />
							</td>
							<td><input class="AXInput etc" style="width: 100%;" type="text"
								id="etc" name="etc"	placeholder="" title="" />
							</td>
							<td>
								<div class="">
									<c:if test="${fn:substring(authBinaryNum, 2, 3) eq '1' }"><%--등록권한 --%>
										<button type="button" class="AXButton Blue _saveBtn_" onclick="" data-click-target="action-save">
											<spring:message code='label.save' />
											<%-- 저장 --%>
										</button>
									</c:if>
									<button type="button" class="AXButton Normal _cancelBtn_" onclick="" data-click-target="">
										<spring:message code='label.cancel' />
										 <%-- 취소--%>
									</button>
								</div>
							</td>
						</tr>
					</c:if>
					<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"> <%--조회권한 --%>
						<c:choose>
							<c:when test="${fn:length(linkList) > 0}">	
									<c:if test="${fn:length(linkList) > 0}">
										<c:set value="${fn:length(linkList)}" var="linkListSize"/>
										<c:forEach var="linkDomain" items="${linkList}" varStatus="status">
											<tr>
											<%-- 	<td>${linkDomain.seq}</td> --%>
												<td>${linkDomain.rowNum}</td>
												<td><c:choose>
														<c:when test="${linkDomain.type eq 'GLOBAL'}">
															DESNO 글로벌사이트
														</c:when>
														<c:otherwise>
															MAKER 업무사이트
														</c:otherwise>
													</c:choose></td>
												<td>${linkDomain.siteName}</td>
												<td>${linkDomain.siteUrl}</td>
												<td>${linkDomain.intro}</td>
												<td>${linkDomain.sort}</td>
												<td><c:choose>
														<c:when test="${linkDomain.useTf eq 'Y'}">
															<spring:message code='label.useY' /><%-- 사용  --%>
														</c:when>
														<c:otherwise>
															<spring:message code='label.useN' /><%-- 미사용  --%>
														</c:otherwise>
													</c:choose></td>
												<td>${linkDomain.etc}</td>
												<td>
													 <div class="">
														<c:if test="${fn:substring(authBinaryNum, 1, 2) eq '1' }"> <%--수정권한  --%> 
														<%--
														AXButton Red _modifyBtn_ clickable     AXButton Normal _modifyBtn
														    AXButton Normal clickable          AXButton Normal _deleteBtn_
														--%>
															<button type="button" class="AXButton Normal _modifyBtn_" style="" onclick="" data-click-target="">
																<i>
																	<!--  class="axi axi-ion-person-add"> -->
																</i> 
																<spring:message code='label.modify' /><!-- 수정 -->
															</button>
														</c:if>
														<c:if test="${fn:substring(authBinaryNum, 0, 1) eq '1' }"><%--삭제권한 --%>
															<button type="button" class="AXButton Normal _deleteBtn_" onclick="" data-loction="" data-click-target="${linkDomain.seq}">
																<spring:message code='label.delete' />
																<!-- 삭제 -->
															</button>
														</c:if>
													</div> 
												</td>
											</tr>
											<c:if test="${fn:substring(authBinaryNum, 1, 2) eq '1' }"><%--수정권한 --%>
												<tr class="update_tr displayNone">
													<td><input type="hidden" class="seq" value="${linkDomain.seq}"/>
														${linkDomain.rowNum}
													</td>							
													<td>
														<%-- <form:select class="AXInput type" path="type" style="width:150px" >
																<form:option value="GLOBAL" label="DESNO 글로벌사이트" 
																	
																 />
																<form:option value="MAKER" label="MAKER 업무사이트" 
																	selected="true"
																 />
														</form:select> --%>
														<select id="type" name ="type" cstyle="width:150px" class="AXInput type" > 											
															<option value="MAKER" <c:if test="${linkDomain.type eq 'MAKER' }"> selected </c:if>>MAKER 업무사이트 </option> 
															<option value="GLOBAL" <c:if test="${linkDomain.type eq 'GLOBAL' }"> selected </c:if> >DENSO 글로벌사이트</option> 
														</select>	
													</td>
													<td><input class="AXInput siteName" style="width: 100%;" type="text" placeholder="사이트명을 입력해주세요" title="사이트명을 입력하세요" 
														value="${linkDomain.siteName}" maxlength="40"></input></td>
													<td><input class="AXInput siteUrl" style="width: 100%;" type="text" placeholder="사이트주소를 입력해주세요" title="사이트주소를 입력하세요" 
														value="${linkDomain.siteUrl}"  maxlength="80"></input></td>
													<td><input class="AXInput intro" style="width: 100%;" type="text" placeholder="사이트 설명을 입력해주세요" title="사이트 설명을 입력하세요" 
														value="${linkDomain.intro}"  maxlength="80"></input></td>
													<td><input class="AXInput sort" style="width: 100%;" type="text" value="${linkDomain.sort}" maxlength="3"></input></td>
													<td><input class="useYn" style="width: 100%;" type="checkBox" title=""
														<c:choose>
																<c:when test="${linkDomain.useTf eq 'Y'}">
																	value="Y" checked 
																</c:when>
																<c:otherwise>
																	value="N"
																</c:otherwise>
															</c:choose> />
													</td>
													<td><input class="AXInput etc" style="width: 100%;" type="text" placeholder="" title=""	value="${linkDomain.etc}"></input></td>
													<td>
														<div class="">
															<button type="button" class="AXButton Blue _saveBtn_" onclick="" data-click-target="action-modify">
																<spring:message code='label.save' />
																<!-- 삭제 -->
															</button>
															<button type="button" class="AXButton Normal _cancelBtn_" onclick="" data-click-target="">
																<spring:message code='label.cancel' />
																<!-- 삭제 -->
															</button>
														</div>
													</td>
												</tr>
											</c:if>
										</c:forEach>
									</c:if>
							</c:when>
							<c:otherwise>
								<tr><td colspan="9">데이터가 없습니다.</td></tr>
							</c:otherwise>
						</c:choose>
					</c:if>
					<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '0' }">  <%--조회권한 --%>
						<tr><td colspan="10"><spring:message code='DNKR-E2-0000'/><!-- 권한이 없습니다. --></td></tr>
					</c:if>
				</tbody> 
			</table>
			</div>
			<div class="gap20"></div>
			
			<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%--조회권한 --%>
				<c:if test="${fn:length(linkList) > 0}">
					<div class="pagenation">
			            <smpl:seqpaging maxSeq="3" action="${pageContext.request.contextPath}/WAC017LinkManagement/init.do" formId="WAC017LinkManagementForm" />
			        </div>
			        <ai:pagingoption countPerPage="10" />
		        </c:if>
	        </c:if>
		</form:form>
	</div><!--board-view-wrap-->
</c:if>
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '0' }"><%--조회권한 --%>
	<div>
		<span><spring:message code='DNKR-E2-0000'/><!-- 권한이 없습니다. --></span>
	</div>
</c:if>
	
