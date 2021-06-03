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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/WAD012SsoAuthPopConfig.js?ver=3"></script>

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
			            <!-- 사업부 선택해주세요 -->
						<strong class="pr5"><spring:message code='label.comps'/></strong> 
						<select id="changeCompany" name="changeCompany" path="changeCompany" style="width:80px" onchange="companyOnChage()">
							<option value="CLS000001" label="구KA" <c:if test="${changeCompany == 'CLS000001'}"> selected </c:if> />
							<option value="CLS000002" label="구KE" <c:if test="${changeCompany == 'CLS000002'}"> selected </c:if> />
							<option value="CLS000003" label="구KR" <c:if test="${changeCompany == 'CLS000003'}"> selected </c:if> />
						</select>
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
		</colgroup>
		<thead>
			<tr>
				<th><spring:message code='label.number'/><!-- 번호 --></th>
				<th><spring:message code='label.sysSeq'/><!-- 스템SEQ --></th>
				<th><spring:message code='label.sysName'/><!-- 시스템명 --></th>
				<th><spring:message code='label.comps'/><!-- 사업부 --></th>
				<th><spring:message code='label.add'/><!-- 등록 --></th>
			</tr>
		</thead>
		<tbody>			
			<form:form action="" modelAttribute="SsoAuthDomain" method="POST" name="SsoAuthDomain" id="SsoAuthDomain">				
				<c:choose>
					<c:when test="${empNumber ne null}">
						<form:hidden id="empNumber" name="empNumber" value="${empNumber}" path="empNumber" class="empNumber"/>
						<form:hidden id="empId" name="empId" value="${empId}" path="empId" class="empId"/>
					</c:when>
					<c:otherwise>
					</c:otherwise>
					
				</c:choose>
				<c:if test="${fn:length(ssoAuthList) > 0}">
					<c:forEach var="ssoAuthDomain" items="${ssoAuthList}" varStatus="status">
						<tr>
							<td>${status.index + 1}
								<form:hidden id="ssoAuthList[${status.index}].empNumber" value="${empNumber}" path="ssoAuthList[${status.index}].empNumber"/>
								<form:hidden id="ssoAuthList[${status.index}].empId" value="${empId}" path="ssoAuthList[${status.index}].empId"/>
								<form:hidden id="ssoAuthList[${status.index}].sysSeq" value="${ssoAuthDomain.sysSeq}" path="ssoAuthList[${status.index}].sysSeq"/>
								<form:hidden id="ssoAuthList[${status.index}].company" value="${ssoAuthDomain.company}" path="ssoAuthList[${status.index}].company"/>
								<form:hidden id="ssoAuthList[${status.index}].tempUseTf" value="${ssoAuthDomain.useTf}" path="ssoAuthList[${status.index}].tempUseTf"/>
								<form:hidden id="ssoAuthList[${status.index}].useTf" value="${ssoAuthDomain.useTf}" path="ssoAuthList[${status.index}].useTf" class="useTf"/>
							</td>
							<td>${ssoAuthDomain.sysSeq}</td>
							<td>${ssoAuthDomain.sysName}</td>
							<td>
								<c:choose>
									<c:when test="${ssoAuthDomain.useCompany eq 'PE'}">
										<c:out value="구KE"></c:out>
									</c:when>
									<c:otherwise>
										<c:out value="구KA"></c:out>
									</c:otherwise>
								</c:choose>
							</td>
							<td class="authChkBox"><input class="useYn" name="authOption" type="checkBox" title="권한 사용여부를 체크해주세요" 
							<c:choose>
								<c:when test="${ssoAuthDomain.useTf eq 'Y'}">
									value="Y" checked 
								</c:when>
								<c:otherwise>
									value="N"
								</c:otherwise>
							</c:choose>
							/></td>				
						</tr>
					</c:forEach>
				</c:if>
				
			</form:form>
		</tbody>
	</table>
</div>
<!--board-view-wrap-->