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

<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/WAB001Emp.js?ver"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/WAB002EmpCreate.js"></script>
<link rel="stylesheet" media="all" href="/css/board.css"/>

<%-- <spring:message code="label.filename" /> : <c:out value="${url }"></c:out> --%>
<style>
.input_tr input, .update_tr input, .form-group input {
	height: 17px;
}

.list-top {
	overflow: visible;
}

[data-ax5autocomplete] {
	display: inline-block;
	width: 150px;
	vertical-align: bottom;
}

.form-control {
	height: 30px;
	padding: 3px 12px;
}

.ax5autocomplete-display .ax5autocomplete-display-table 
[data-ax5autocomplete-display="label"]{
	padding: 0;
}

.board-write-wrap table th {
    min-width: 110px;
}

</style>

<div class="board-write-wrap">
			<span class="top-border"></span> 
			<form:form action="${pageContext.request.contextPath}/WAB002EmpCreate/create.do?menu=${menu}" modelAttribute="WAB002EmpCreateForm" name="WAB002EmpCreateForm" method="POST">
			<input type="hidden" name="tabId" value="<c:out value="${tabId}"></c:out>" />
				<table class="write_01" summary="각 해당하는 항목에 알맞게 내용을 입력해주세요">
					<caption>내용 입력폼</caption>
					<colgroup>
						<col width="12%">
						<col width="88%">
					</colgroup>
					<tbody>
						<tr>
							<th class="check">
								<span class="necessary">* </span>
								<spring:message code="label.WAB002.empInoutType" />
								<!-- 사원 구분 -->
							</th>
							<td>
<%-- 							
								<label>	
									<form:radiobutton id="inOutTypeI" path="inOutType" value="I" checked="checked"/>
										<spring:message code="label.WAB002.empInternal" /><!-- 내부직원 -->&nbsp;
								</label>
								<label>
									<form:radiobutton id="inOutTypeO" path="inOutType" value="O" />
										<spring:message code="label.WAB002.empOutside" /><!-- 외부업체 -->
								</label>
--%>
								<c:choose>
									<c:when test="${menu eq '2'}">
								        <label>	
											<form:radiobutton id="inOutTypeI" path="inOutType" value="I" checked="checked"/>
												<spring:message code="label.WAB002.empInternal" /><!-- 내부직원 -->&nbsp;
										</label>
										<label>
											<form:radiobutton id="inOutTypeO" path="inOutType" value="O" />
												<spring:message code="label.WAB002.empOutside" /><!-- 외부업체 -->
										</label>
								    </c:when>
								    <c:otherwise>
								        <label>	
											<form:radiobutton id="inOutTypeI" path="inOutType" value="I"/>
												<spring:message code="label.WAB002.empInternal" /><!-- 내부직원 -->&nbsp;
										</label>
										<label>
											<form:radiobutton id="inOutTypeO" path="inOutType" value="O" checked="checked" />
												<spring:message code="label.WAB002.empOutside" /><!-- 외부업체 -->
										</label>								    
									</c:otherwise>
								</c:choose> 
									<form:errors path="inOutType" cssStyle="color:#ff0000;" element="span" />
							</td>
						</tr> 
						<tr>
							<th class="check">
								<span class="necessary">* </span>
								<label for="empNumber">
									<spring:message code="label.WAB002.empNumber" />
								</label>
							</th>
							<td>
								<div class="inlineBlock">
									<form:input style="width:150px;" cssClass="form-control input-xs required inlineBlock" type="text" id="empNumber" path="empNumber" maxlength="10" cssErrorClass="form-control input-xs bg_error" required="true" autofocus="true" />
									<span class="displayNone" style="color: red;"> &nbsp;외부업체 사번은 임의 생성됩니다.</span>
									<form:errors path="empNumber" cssStyle="color:#ff0000;" element="span" />
									
								</div>
								<div class="inlineBlock">
									<button type="button" onclick="" class="AXButton Normal _duplicateCheckBtn_" name="Cancel" data-click-target="empNumber">
										<spring:message code="label.duplicateCheck" /><!-- 중복확인 -->
									</button>
								</div>
							</td>
						</tr>
						<tr>
							<th class="check">
								<label for="empName">
									<spring:message code="label.WAB002.empName" /><!-- 사원명 -->
								</label>
							</th>
							<td>
								<form:input style="width:150px;" cssClass="form-control" type="text" id="empName" path="empName" maxlength="45" cssErrorClass="form-control input-xs bg_error" autofocus="true" />
								<form:errors path="authCode" cssStyle="color:#ff0000;" element="span" />
							</td>
						</tr>
						<tr>
							<th class="check">
								
								<spring:message code="label.WAB002.clsCode" /><!-- 사업부 -->
							</th>
							<td>
								<div class="form-group">
									<input style="width:100px;" type="text" class="form-control" disabled/>
									<form:hidden style="width:100px;" data-rltnCode="" cssClass="form-control" id="clsCode" path="clsCode"/>
			            			<form:errors path="clsCode" cssStyle="color:#ff0000;" element="span" />	
			            		</div>
							</td>
						</tr>
						<tr>
							<th class="check">
								<spring:message code="label.WAB002.locCode" /><!-- 사업장 -->
							</th>
							<td>
								<div class="form-group">
			            			<input style="width:100px;" type="text" class="form-control" disabled/>
									<form:hidden data-rltnCode="" cssClass="form-control" id="locCode" path="locCode"/>
			            			<form:errors path="locCode" cssStyle="color:#ff0000;" element="span" />
			            		</div>
								<%-- <form:input style="width:100px;" cssClass="form-control" type="text" id="locCode" path="locCode" maxlength="45" cssErrorClass="form-control input-xs bg_error" autofocus="true" />
								<form:errors path="locCode" cssStyle="color:#ff0000;" element="span" /> --%>
							</td>
						</tr>
						<tr>
							<th class="check">
								<spring:message code="label.WAB002.teamCode" /><!-- 부서(팀) -->
							</th>
							<td>
								<div class="form-group">
									<div class="inlineBlock">
										<input style="width:150px;" type="text" class="form-control" disabled/>
										<form:hidden cssClass="form-control" id="teamCode" path="teamCode"/>
				            			<form:errors path="teamCode" cssStyle="color:#ff0000;" element="span" />
			            			</div>
			            			<div class="inlineBlock">	
										<button type="button" onclick="" class="AXButton Normal _deptBtn_">
											<spring:message code="label.deptName" /><!-- 부서 -->
											<spring:message code="label.select" /><!-- 선택 -->
										</button>
									</div>
			            		</div>
								<%-- <form:input style="width:100px;" cssClass="form-control" type="text" id="teamCode" path="teamCode" maxlength="45" cssErrorClass="form-control input-xs bg_error" autofocus="true" />
								<form:errors path="teamCode" cssStyle="color:#ff0000;" element="span" /> --%>
							</td>
						</tr> 
						<tr>
						<!-- Start 추가시 에러발생함  -->
						<tr class="displayNone">
							<th class="check">
								<spring:message code="label.supplyComps" /><!-- 협력업체(납품공장) -->
							</th>
							<td>
<%-- 							
								<form:input style="width:150px;" cssClass="form-control" type="text" id="relationCopLoc" path="relationCopLoc" maxlength="2" cssErrorClass="form-control input-xs bg_error"  disabled="true"/>
								<form:errors path="relationCopLoc" cssStyle="color:#ff0000;" element="span" />
--%>
							<form:select id="relationCopLoc" name="relationCopLoc"  path="relationCopLoc" class="relationCopLoc" autofocus="true" style="width:120px" cssClass="form-control" >
								<form:option value="">
									<spring:message code='label.loc_na'/><!-- 해당없음 -->
								</form:option>
								<c:if test="${fn:length(locList) > 0}">
									<c:forEach var="locDomain" items="${locList}" varStatus="status">
										<form:option value="${locDomain.relationCode}" label="${locDomain.relationName}"></form:option>
									</c:forEach>
								</c:if>
							</form:select>
							
							</td>
						</tr>
						<tr class="displayNone">
							<th class="check">
								<spring:message code="label.companyId" /><!-- 협력업체(사업자번호) -->
							</th>
							<td>
								<form:input style="width:250px;" cssClass="form-control" type="text" id="relationCopNo" path="relationCopNo" maxlength="45" cssErrorClass="form-control input-xs bg_error"  disabled="true"/>
								<form:errors path="relationCopNo" cssStyle="color:#ff0000;" element="span" />
	
							</td>
						</tr>
						<!-- End -->
							<th class="check">
								<label for ="empEmail">
									<spring:message code="label.email" /><!-- 이메일 -->
								</label>
							</th>
							<td>
								<form:input style="width:250px;" cssClass="form-control fl" type="text" id="empEmail" path="empEmail" maxlength="45" cssErrorClass="form-control input-xs bg_error" autofocus="true" />
								<form:errors path="empEmail" cssStyle="color:#ff0000;" element="span" />
							</td>
						</tr>
						<tr>
							<th class="check">
								<label for="empId">
									<spring:message code="label.WAB002.empId" /><!-- 아이디 -->
								</label>
							</th>
							<td>
								<div class="inlineBlock">
									<form:input style="width:150px;" cssClass="form-control inlineBlock" type="text" id="empId" path="empId" maxlength="45" cssErrorClass="form-control input-xs bg_error" autofocus="true" readOnly="true"/>
									<span style="color: red;">
									 	&nbsp;<spring:message code="DNKR-I0-0009" /><!-- 내부직원 아이디는 자동 생성됩니다. -->
									 </span>
									<form:errors path="empId" cssStyle="color:#ff0000;" element="span" />
								</div>
								<div class="displayNone">	
									<button type="button" onclick="" class="AXButton Normal _duplicateCheckBtn_" data-click-target="empId">
										<spring:message code="label.duplicateCheck" /><!-- 중복확인 -->
									</button>
								</div>
							</td>
						</tr>
						<tr class="displayNone pwdTr">
							<th class="check">
								<spring:message code="label.WAB002.empPasswd" /><!-- 비밀번호 -->
							</th>
							<td>
								<form:input style="width:150px;" cssClass="form-control" type="password" id="empPwd" path="empPwd" maxlength="45" cssErrorClass="form-control input-xs bg_error" autofocus="true" />
								<form:errors path="empPwd" cssStyle="color:#ff0000;" element="span" />
							</td>
						</tr>
						<tr class="displayNone">
							<th class="check">
								<spring:message code="label.WAB002.empPasswdConfirm" /><!-- 비밀번호 확인 -->
							</th>
							<td>
								<input style="width:150px;" class="form-control" type="password" id="empPwdAgain" maxlength="45"/>
							</td>
						</tr>
						<%-- <tr>
							<th class="check">
								<span class="necessary">* </span>
								개인권한 사용여부
							</th>
							<td>
								<form:radiobutton id="empPrivateAuthY" path="empPrivateAuth" value="Y" />예
								<form:radiobutton id="empPrivateAuthN" path="empPrivateAuth" value="N" checked="checked"/>아니오
								<form:errors path="empPrivateAuth" cssStyle="color:#ff0000;" element="span" />
							</td>
						</tr>
						<tr class="displayNone">
							<th class="check">
								개인권한
							</th>
							<td>
								<form:select cssClass="form-control input-xs required" id="language"  path="language" required="true">
		                            <c:choose>
		                                <c:when test="${WA0002EmpCreateForm.language == 'ja'}">
		                                    <option value="ja" selected="selected"><spring:message code='label.lang.japanese' /></option>
		                                    <option value="en"><spring:message code='label.lang.english' /></option>
		                                </c:when>
		                                <c:otherwise>
		                                    <option value="ja"><spring:message code='label.lang.japanese' /></option>
		                                    <option value="en" selected="selected"><spring:message code='label.lang.english' /></option>
		                                </c:otherwise>
		                            </c:choose>
		                        </form:select>
		                        
		                        	<button type="button" class="AXButton Normal _authConfigBtn_" style=""
										onclick="" data-click-target="">
										<i>
											<!--  class="axi axi-ion-person-add"> -->
										</i> 개인권한설정
										<spring:message code='label.cmcregister'/>
									</button> 
		                        
								<form:hidden id="authCode" path="authCode" maxlength="45" cssErrorClass="form-control input-xs bg_error"/>
								<form:errors path="authCode" cssStyle="color:#ff0000;" element="span" />
							</td>
						</tr> --%>
						<tr>
							<th class="check">
								<span class="necessary">* </span>
								<spring:message code="label.WAB002.empAvailability" /><!-- 사원 사용여부 -->
							</th>
							<td>
								<form:radiobutton id="empUseY" path="empUse" value="Y" checked="checked"/>
									<spring:message code="label.yes" /><!-- 예 -->&nbsp;
								<form:radiobutton id="empUseN" path="empUse" value="N" />
									<spring:message code="label.no" /><!-- 아니오 -->
								<form:errors path="empUse" cssStyle="color:#ff0000;" element="span" />
							</td>
						</tr>
					</tbody>
				</table> 
				
				<div class="list-bnt writeOnly">
					<button type="submit" class="red" name="Register" onclick="return empCheck()">
						<spring:message code="label.add" /><!-- 등록 -->
					</button>
					<%-- <button type="button" onclick="javascript:location.href='${pageContext.request.contextPath}/WAB001EmpSearch/init.do?tabId=<c:out value="${tabId}"></c:out>&menu=<c:out value="${menu}"></c:out>'" class="gray" name="Cancel">
						<spring:message code="label.cancel" /><!-- 취소 -->
					</button> --%>
					<button type="button" onclick="javascript:history.back()" class="gray" name="Cancel">
						<spring:message code="label.cancel" /><!-- 취소 -->
					</button>
				</div>
			
			</form:form>
			
		</div> 
	
  