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
	src="${pageContext.request.contextPath}/js/admin/WAC019Sso.js?ver=0.1"></script>
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
		<form:form action='${pageContext.request.contextPath}/WAC019SsoManagement/init.do?tabId=${tabId}' method="POST" modelAttribute="WAC019SsoManagementForm" name="WAC019SsoManagementForm" id="WAC019SsoManagementForm">
			<div class="list-top">
				<div class="search">
					<spring:message code="DNKR-I0-0010" var="LN_INSERT_AUTHGROUP"/><!-- 권한그룹명을 입력해주세요. -->
					<form:select path="pInOutType">
							<form:option value="" label="전체" selected="true"/>
							<form:option value="I" label="내부" /> 
							<form:option value="O" label="외부" /> 
					</form:select>
					<form:select autofocus="true" path="pCompany" style="width:80px">
							<form:option value="" label="전체" />
							<form:option value="CLS000004" label="공통" />
							<form:option value="CLS000002" label="구KE" />
							<form:option value="CLS000001" label="구KA" />
					</form:select>
					<form:select path="pUseTf">
							<form:option value="" label="전체" selected="true"/>
							<form:option value="Y" label="사용"/> 
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
						<th><spring:message code='label.sysSeq'/></th> <%-- 시스템SEQ --%>
						<th><spring:message code='label.WAB002.clsCode'/></th> <%-- 사업부 --%>
						<th><spring:message code='label.sysName'/></th> <%-- 시스템명 --%>
						<th><spring:message code='label.sysUrl'/></th> <%-- 자동URL --%>
						<th><spring:message code='label.sysUr2'/></th> <%-- 로그인URL --%>
						<th><spring:message code='label.sysType'/></th> <%-- 시스템구분 --%>
						<th><spring:message code='label.popupYn'/></th> <%-- 팝업유무  --%>
						<th><spring:message code='label.inOutType'/></th> <%-- 내부/외부구분  --%>
						<th><spring:message code='label.loginYn'/></th> <%-- 자동로그인여부  --%>
						<th><spring:message code='label.popupW'/></th> <%-- 팝업창너비  --%>
						<th><spring:message code='label.popupH'/></th> <%-- 팝업창높이  --%>
						<th><spring:message code='label.subYn'/></th> <%-- 협력업체사용유무  --%>
						<th><spring:message code='label.useYn'/></th> <%-- 사용여부  --%>
						<th>SSO관리여부</</th> <%-- sso관리여부  --%>
						<th><spring:message code='label.management'/></th> <%-- 관리  --%>
					</tr>
				</thead>
				<tbody>
 					<c:if test="${fn:substring(authBinaryNum, 2, 3) eq '1' }"><%--등록권한 --%>
						<tr class="input_tr displayNone">
						<%--	<td> SEQ</td> --%>
							<td><%-- ROW NUM --%></td>
							<td><input class="AXInput sysSeq" style="width: 100%;" type="text"
								id="sysSeq" name="sysSeq" placeholder="시스템 SEQ를 입력하세요" title="시스템 SEQ를 입력하세요"  maxlength="3" />
							</td>
							<td>
								<form:select path="iCompany" style="width:70px">
									<form:option value="CLS000002" label="구KE" />
									<form:option value="CLS000001" label="구KA" />
									<form:option value="CLS000004" label="공통" />
								</form:select>
							</td>
							<td><input class="AXInput sysName" style="width: 100%;" type="text"
								id="sysName" name="sysName" placeholder="시스템명을 입력해주세요" title="시스템명을 입력하세요"  maxlength="20" />
							</td>
							<td><input class="AXInput sysUrl" style="width: 100%;" type="text"
								id="sysUrl" name="sysUrl" placeholder="자동URL을 입력해주세요" title="자동URL을 입력해주세요"  maxlength="110" />
							</td>
							<td><input class="AXInput sysUrl2" style="width: 100%;" type="text"
								id="sysUrl2" name="sysUrl2" placeholder="로그인 URL을 입력해주세요" title="로그인 URL을 입력해주세요" maxlength="110" />
							</td>
							<td>
								<form:select path="iSysType" style="width:70px">
									<form:option value="WEB" label="WEB" />
									<form:option value="CS" label="CS" />
								</form:select>
							</td>
							<td>
								<spring:message code="DNKR-I0-0012" var="LN_AUTH_USEYN"/><%-- 사용여부를 체크해주세요. --%>
								<input  class="popupYn" style="width: 100%;" type="checkBox"
								id="popupYn" name="popupYn" value="Y" title="" />
							</td>
							<td>
								<form:select path="iInOutType" style="width:70px">
									<form:option value="O" label="외부" />
									<form:option value="I" label="내부" />
								</form:select>
							</td>
							<td>
								<spring:message code="DNKR-I0-0012" var="LN_AUTH_USEYN"/><%-- 사용여부를 체크해주세요. --%>
								<input class="loginYn" style="width: 100%;" type="checkBox"
								id="loginYn" name="loginYn" value="Y" title="" checked />
							</td>
							<td><input class="AXInput popupW" style="width: 100%;" type="text"
								id="popupW" name="popupW" placeholder="팝업창너비" title="팝업창너비를 입력하세요" maxlength="4" />
							</td>
							<td><input class="AXInput popupH" style="width: 100%;" type="text"
								id="popupH" name="popupH" placeholder="팝업창높이" title="팝업창높이를 입력하세요" maxlength="4" />
							</td>
							<td>
								<spring:message code="DNKR-I0-0012" var="LN_AUTH_USEYN"/><%-- 사용여부를 체크해주세요. --%>
								<input class="subYn" style="width: 100%;" type="checkBox"
								id="subYn" name="subYn" value="Y" title="" />
							</td>
							<td>
								<spring:message code="DNKR-I0-0012" var="LN_AUTH_USEYN"/><%-- 사용여부를 체크해주세요. --%>
								<input class="useTf" style="width: 100%;" type="checkBox"
								id="useTf" name="useTf" value="Y" title="" checked />
							</td>
							<td>
								<spring:message code="DNKR-I0-0012" var="LN_AUTH_USEYN"/><%-- 사용여부를 체크해주세요. --%>
								<input class="ssoTf" style="width: 100%;" type="checkBox"
								id="ssoTf" name="ssoTf" value="Y" title="" checked />
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
							<c:when test="${fn:length(ssoList) > 0}">	
									<c:if test="${fn:length(ssoList) > 0}">
										<c:set value="${fn:length(ssoList)}" var="ssoListSize"/>
										<c:forEach var="linkDomain" items="${ssoList}" varStatus="status">
											<tr>
											<%-- 	<td>${linkDomain.seq}</td> --%>
												<td>${linkDomain.rowNum}</td>
												<td>${linkDomain.sysSeq}</td>
												<td>
													<c:choose>
														<c:when test="${linkDomain.company eq 'CLS000002'}">
															구KE
														</c:when>
														<c:when test="${linkDomain.company eq 'CLS000001'}">
															구KA
														</c:when>
														<c:otherwise>
															공통
														</c:otherwise>
													</c:choose>
												</td>
												<td>${linkDomain.sysName}</td>
												<td>${linkDomain.sysUrl}</td>
												<td>${linkDomain.sysUrl2}</td>
												<td>${linkDomain.sysType}</td>
												<td>${linkDomain.popupYn}</td>
												<%-- 
												<td>${linkDomain.inOutType}</td>
												 --%>
												<td><c:choose>
														<c:when test="${linkDomain.inOutType eq 'O'}">
															외부
														</c:when>
														<c:otherwise>
															내부
														</c:otherwise>
													</c:choose>
												</td>
												<td>${linkDomain.loginYn}</td>
												<td>${linkDomain.popupW}</td>
												<td>${linkDomain.popupH}</td>
												<td><c:choose>
														<c:when test="${linkDomain.subYn eq 'Y'}">
															<spring:message code='label.useY' /><%-- 사용  --%>
														</c:when>
														<c:otherwise>
															<spring:message code='label.useN' /><%-- 미사용  --%>
														</c:otherwise>
													</c:choose>
												</td>
												<td><c:choose>
														<c:when test="${linkDomain.useTf eq 'Y'}">
															<spring:message code='label.useY' /><%-- 사용  --%>
														</c:when>
														<c:otherwise>
															<spring:message code='label.useN' /><%-- 미사용  --%>
														</c:otherwise>
													</c:choose>
												</td>
												</td>
												<td><c:choose>
														<c:when test="${linkDomain.ssoTf eq 'Y'}">
															<spring:message code='label.useY' /><%-- 사용  --%>
														</c:when>
														<c:otherwise>
															<spring:message code='label.useN' /><%-- 미사용  --%>
														</c:otherwise>
													</c:choose>
												</td>
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
													<td><input class="AXInput sysSeq" style="width: 100%;" type="text" placeholder="시스템 SEQ를 입력하세요" title="시스템 SEQ를 입력하세요" 
														value="${linkDomain.sysSeq}" maxlength="3"></input></td>
													<td>
													<%--
 														<form:select class="AXInput company" path="company" style="width:150px" >
																<form:option value="PE" label="구KE"										
																 />
																<form:option value="PS" label="구KA" 
																 />
														</form:select>
														 --%>
														<select id="company" name ="company" cstyle="width:150px" class="AXInput company" > 											
															<option value="CLS000002" <c:if test="${linkDomain.company eq 'CLS000002' }"> selected </c:if>>구KE</option> 
															<option value="CLS000001" <c:if test="${linkDomain.company eq 'CLS000001' }"> selected </c:if>>구KA</option> 
															<option value="CLS000004" <c:if test="${linkDomain.company eq 'CLS000004' }"> selected </c:if>>공통</option> 
														</select> 
													</td>
													<td><input class="AXInput sysName" style="width: 100%;" type="text" placeholder="시스템명을 입력해주세요" title="시스템명을 입력하세요" 
														value="${linkDomain.sysName}" maxlength="20"></input></td>
													<td><input class="AXInput sysUrl" style="width: 100%;" type="text" placeholder="자동URL을 입력해주세요" title="자동URL을 입력하세요" 
														value="${linkDomain.sysUrl}"  maxlength="110"></input></td>
													<td><input class="AXInput sysUrl2" style="width: 100%;" type="text" placeholder="로그인 URL을입력해주세요" title="로그인 URL을 입력하세요" 
														value="${linkDomain.sysUrl2}"  maxlength="110"></input></td>
													<td>
														<select id="sysType" name ="sysType" cstyle="width:150px" class="AXInput sysType" > 											
															<option value="WEB" <c:if test="${linkDomain.sysType eq 'WEB' }"> selected </c:if>>WEB </option> 
															<option value="CS" <c:if test="${linkDomain.sysType eq 'CS' }"> selected </c:if>>CS</option> 
														</select>
													</td>
													<td><input class="popupYn" style="width: 100%;" type="checkBox" title=""
														<c:choose>
															<c:when test="${linkDomain.popupYn eq 'Y'}">
																value="Y" checked 
															</c:when>
															<c:otherwise>
																value="N"
															</c:otherwise>
														</c:choose> />
													</td>
													<td>
														<select id="inOutType" name ="inOutType" cstyle="width:150px" class="AXInput inOutType" > 											
															<option value="O" <c:if test="${linkDomain.inOutType eq 'O' }"> selected </c:if>>외부 </option> 
															<option value="I" <c:if test="${linkDomain.inOutType eq 'I' }"> selected </c:if>>내부</option> 
														</select>
													</td>
													<td><input class="loginYn" style="width: 100%;" type="checkBox" title=""
														<c:choose>
															<c:when test="${linkDomain.loginYn eq 'Y'}">
																value="Y" checked 
															</c:when>
															<c:otherwise>
																value="N"
															</c:otherwise>
														</c:choose> />
													</td>
													<td><input class="AXInput popupW" style="width: 100%;" type="text" placeholder="팝업창너비를 입력하세요" title="팝업창너비를 입력하세요" 
														value="${linkDomain.popupW}" maxlength="4"></input></td>
													<td><input class="AXInput popupH" style="width: 100%;" type="text" placeholder="팝업창높이를 입력하세요" title="팝업창높이를 입력하세요" 입력하세요" 
														value="${linkDomain.popupH}" maxlength="4"></input></td>
													<td><input class="subYn" style="width: 100%;" type="checkBox" title=""
														<c:choose>
															<c:when test="${linkDomain.subYn eq 'Y'}">
																value="Y" checked 
															</c:when>
															<c:otherwise>
																value="N"
															</c:otherwise>
														</c:choose> />
													</td>
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
													<td><input class="ssoTf" style="width: 100%;" type="checkBox" title=""
														<c:choose>
															<c:when test="${linkDomain.ssoTf eq 'Y'}">
																value="Y" checked 
															</c:when>
															<c:otherwise>
																value="N"
															</c:otherwise>
														</c:choose> />
													</td>
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
				<c:if test="${fn:length(ssoList) > 0}">
					<div class="pagenation">
			            <smpl:seqpaging maxSeq="3" action="${pageContext.request.contextPath}/WAC019SsoManagement/init.do" formId="WAC019SsoManagementForm" />
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
	
