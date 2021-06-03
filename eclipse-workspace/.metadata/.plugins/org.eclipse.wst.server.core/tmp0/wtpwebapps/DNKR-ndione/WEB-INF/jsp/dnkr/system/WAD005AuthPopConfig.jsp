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
<c:if test="${fn:length(authList) > 0}">
	<script type="text/javascript">
	var options = [];
	
	
	<c:forEach var="authDomain" items="${authList}" varStatus="status">
	
		options.push({value: "${authDomain.authCode}", text: "${authDomain.authName}"});
	
	</c:forEach>
	</script>
</c:if>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/WAD005AuthPopConfig.js?ver=1"></script>
<h2 class="subpage-tit">
	<c:choose>
		<c:when test="${empNumber ne null}">
			${empName}
		</c:when>
		<c:otherwise>
			${authName}
		</c:otherwise>
			
	</c:choose>
	&nbsp;<spring:message code='label.WAD005.name'/><!-- 권한설정 -->
</h2>
<div class="board-bList-wrap">
	<div class="list-top">
		<div class="search">
			<div class="row">
			    <div class="col-md-6">
			        <div class="form-group">
			        	<input type="hidden" id="paraAuthCode" value="${authCode}"/>
			        	<%-- <input type="text" placeholder="<spring:message code="DNKR-I0-0010"/>" size="30"> --%>
			            <div data-ax5autocomplete="autocomplete1" data-ax5autocomplete-config="{editable: true}" title="<spring:message code="DNKR-I0-0010"/>">
			            	<span><spring:message code="DNKR-I0-0010"/><!-- 권한그룹명을 입력해주세요. --></span>
			            </div>
						<button type="button" class="AXButton Black _searchBtn_" onclick="">
							<i class="axi axi-ion-android-search"></i>
							<spring:message code='label.select'/>
						</button>
						<button type="button" class="AXButton Blue _saveBtn_" style=""
							onclick="" data-click-target="auth-save">
							<spring:message code='label.save' />
						</button>
						<button type="button" class="AXButton Normal _closeBtn_" onclick=""
							data-click-target="auth-close">
							<spring:message code='label.close' />
							<!-- 삭제 -->
						</button>
						<!-- </form> -->
			        </div>
			    </div>
			</div>
		</div>
		<!-- search -->
	</div>
	<!-- list-top -->
	<div class="gap20"></div>
	<span class="top-border"></span>
	<table class="authMenuCfgTbl">
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
				<th><spring:message code='label.firstMenu'/><!-- 1차메뉴 --></th>
				<th style="min-width:50px;max-width:50px;width:50px;"><spring:message code='label.belowAllClick'/><!-- 하위메뉴<br>전체선택 --></th>
				<th><spring:message code='label.secondMenu'/><!-- 2차메뉴 --></th>
				<th><spring:message code='label.thirdMenu'/><!-- 3차메뉴 --></th>
				<th style="min-width:50px;max-width:50px;width:50px;"><spring:message code='label.menuAllClick'/><!-- 메뉴별<br>전체선택 --><!-- 전체 --></th>
				<th><spring:message code='label.search'/><!-- 조회 --></th>
				<th><spring:message code='label.add'/><!-- 등록 --></th>
				<th><spring:message code='label.modify'/><!-- 수정 --></th>
				<th><spring:message code='label.delete'/><!-- 삭제 --></th>
			</tr>
		</thead>
		<tbody>
			
			<form:form action="/WAD005AuthConfig/authConfig.do" modelAttribute="authDomain" method="POST" name="AuthDomain" id="AuthDomain">				
				<c:choose>
					<c:when test="${empNumber ne null}">
						<form:hidden id="empNumber" name="empNumber" value="${empNumber}" path="empNumber" class="empNumber"/>
					</c:when>
					<c:otherwise>
						<form:hidden id="authCode" name="authCode" value="${authCode}" path="authCode" class="authCode"/>
					</c:otherwise>
					
				</c:choose>
				<c:if test="${fn:length(menuList) > 0}">
					<input type="hidden" name="menuListCnt" value="${fn:length(menuList) }"/>
					<c:set var="menuNum" value="${0}"/>
					<c:forEach var="authDomain" items="${menuList}" varStatus="status">
						<tr
							<c:choose>
								<c:when test="${authDomain.menuDepth eq '1'}">
									class="group<c:out value="${menuNum = menuNum + 1}"/>"
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${authDomain.menuDepth ne '1'}">
									class="group<c:out value="${menuNum}"/>"
								</c:when>
							</c:choose>
						>
						
							<td>${status.index + 1}
								<input type="hidden" id="authList[${status.index}].menuCode" value="${authDomain.menuCode}" name="authList[${status.index}].menuCode"/>
								<input type="hidden" id="authList[${status.index}].authCode" value="${authCode}" name="authList[${status.index}].authCode"/>
								<input type="hidden" id="authList[${status.index}].authNum" name="authList[${status.index}].authNum" value="${authDomain.authNum}" class="authNum"/>
								<%-- <form:hidden id="authList[${status.index}].menuCode" value="${authDomain.menuCode}" path="authList[${status.index}].menuCode"/>
								<form:hidden id="authList[${status.index}].authCode" value="${authCode}" path="authList[${status.index}].authCode"/>
								<form:hidden id="authList[${status.index}].authNum" name="authList[0].authNum" value="${authDomain.authNum}" path="authList[${status.index}].authNum" class="authNum"/> --%>
							</td>
							<%-- <c:choose>
								<c:when test="${authDomain.menuDepth eq '1'}">
									<td>${authDomain.menuName}</td>
									<td>	
										<input type="checkbox" class="groupChkBox" title="선택하면 하위메뉴가 전부 선택됩니다.">
									</td>
									<td></td>
									<td></td>
								</c:when>
								<c:when test="${authDomain.menuDepth eq '2'}">
									<td></td>
									<td></td>
									<td>${authDomain.menuName}</td>
									<td></td>
								</c:when>
								<c:otherwise>
									<td></td>
									<td></td>
									<td></td>
									<td>${authDomain.menuName}</td>
								</c:otherwise>
							</c:choose> --%>
							<td><c:if test="${authDomain.menuDepth eq '1'}">${authDomain.menuName}</c:if></td>
							<td><c:if test="${authDomain.menuDepth eq '1'}"><input type="checkbox" class="groupChkBox" title="선택하면 하위메뉴가 전부 선택됩니다."></c:if></td>
							<td><c:if test="${authDomain.menuDepth eq '2'}">${authDomain.menuName}</c:if></td>
							<td><c:if test="${authDomain.menuDepth eq '3' or authDomain.menuDepth eq '4' }">${authDomain.menuName}</c:if></td>
							<td>
								<input type="checkbox" class="selectAll" title="선택하면 전체권한이 선택됩니다."/>
							</td>
							<td class="authChkBox">
							${authDomain.setAuthBinaryNum(authDomain.authNum)}
							<c:set var="authBinaryNum" value="${authDomain.getAuthBinaryNum()}"/>
							
							<input class="" name="authOption" type="checkBox" title="권한 사용여부를 체크해주세요" onclick="sumAuth(this, this.value)" value="1" <c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }">checked="checked"</c:if> 	/></td>
							<td class="authChkBox"><input class="" name="authOption" type="checkBox" title="권한 사용여부를 체크해주세요" onclick="sumAuth(this, this.value)" value="2" <c:if test="${fn:substring(authBinaryNum, 2, 3) eq '1' }">checked="checked"</c:if> /></td>
							<td class="authChkBox"><input class="" name="authOption" type="checkBox" title="권한 사용여부를 체크해주세요" onclick="sumAuth(this, this.value)" value="4" <c:if test="${fn:substring(authBinaryNum, 1, 2) eq '1' }">checked="checked"</c:if> /></td>
							<td class="authChkBox"><input class="" name="authOption" type="checkBox" title="권한 사용여부를 체크해주세요" onclick="sumAuth(this, this.value)" value="8" <c:if test="${fn:substring(authBinaryNum, 0, 1) eq '1' }">checked	="checked"</c:if> /></td>
						</tr>
					</c:forEach>
				</c:if>
					<%-- </c:forEach> --%>
				<%-- </c:if> --%>
			</form:form>
		</tbody>
	</table>
</div>
<!--board-view-wrap-->