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

<link rel="stylesheet" type="text/css" href="/js/lib/assets/lib/ax5ui-autocomplete/dist/ax5autocomplete.css">
<script type="text/javascript" src="/js/lib/assets/lib/ax5ui-autocomplete/dist/ax5autocomplete.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/WAB001Emp.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/WAB002EmpCreate.js"></script>
<link rel="stylesheet" media="all" href="/css/board.css"/>


<%-- <spring:message code="label.filename" /> : <c:out value="${url }"></c:out> --%>

<script type="text/javascript">

$(document.body).ready(function () {
	
	$('._pwdModifyBtn_').on('click', function() {
		$("#pwdWrap").fadeIn(300);
	});
	
	$("#close").click(function(){
		$("#pwdWrap").fadeOut(300);	
	});
	
	
	
});    
function closeTab(){
	var tabId = $('#tabId').val();
	var tabNum = tabId.substring(6,8);
	var target = $('#myTab04_AX_Tabs_AX_' + tabNum, parent.document);
	
	//닫을 탭 콘텐츠 삭제하기
	$(target.closest('div.cont-wrap').find('#'+tabId)).remove();
	//탭 클릭해서 탭닫기
	target.children('.AXTabClose').trigger('click');
}
</script>

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

#pwdWrap {
    width: 580px;
    background: #fff;
    color: #333;
    position: absolute;
    top: 50%;
    left: 30%;
    box-shadow: 5px 5px 20px rgba(0, 0, 0, 0.9);
    display: none;
}

#pwdWrap p.tit {
    font-size: 16px;
    font-weight: bold;
    color: #fff;
    background: #dc2217;
    padding-bottom: 10px;
    padding: 7px 10px;
    position: relative;
}

#pwdWrap .stxt {
    padding: 20px 15px;
}

#pwdWrap p.tit .close {
    position: absolute;
    top: 6px;
    right: 12px;
    color: #fff;
}

#pwdWrap button{
	margin-bottom: 10px;
}

</style>

<div class="board-write-wrap">
	<span class="top-border"></span> 
	<form:form action="${pageContext.request.contextPath}/WAB006EmpMyPage/update.do?menu=${menu}" modelAttribute="WAB002EmpCreateForm" name="WAB002EmpCreateForm" method="POST">
	<input type="hidden" name="tabId" id="tabId" value="<c:out value="${tabId}"></c:out>" />
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
						<c:choose>
							<c:when test="${empDomain.inOutType eq 'I'}">
								<spring:message code="label.WAB002.empInternal" /><!-- 내부직원 -->
							</c:when>
							<c:otherwise>
								<spring:message code="label.WAB002.empOutside" /><!-- 외부업체 -->
							</c:otherwise>
						</c:choose>
					</td>
				</tr>  
				<tr>
					<th class="check">
						<span class="necessary">* </span>
						<spring:message code="label.WAB002.empNumber" />
					</th>
					<td>
						<input value="${empDomain.empNumber}" style="width:150px;" class="form-control input-xs required" type="text" maxlength="10" disabled/>
						<form:hidden value="${empDomain.empNumber}" path="empNumber" maxlength="10" cssErrorClass="form-control input-xs bg_error" required="true"/>
						<form:errors path="empNumber" cssStyle="color:#ff0000;" element="span" />
					</td>
				</tr>
				<tr>
					<th class="check">
							<label for="empName">
							<spring:message code="label.WAB002.empName" /><!-- 사원명 -->
						</label>
					</th>
					<td>
						<form:input value="${empDomain.empName}" style="width:150px;" cssClass="form-control" type="text" id="empName" path="empName" maxlength="45" cssErrorClass="form-control input-xs bg_error" autofocus="true" />
						<form:errors path="authCode" cssStyle="color:#ff0000;" element="span" />
					</td>
				</tr>
				
				<c:if test="${empDomain.inOutType eq 'I'}">
					<tr>
						<th class="check">
							<spring:message code="label.WAB002.clsCode" /><!-- 사업부 -->
						</th>
						<td>
				 			<input value="${empDomain.clsName}" style="width:100px;" class="form-control" type="text" disabled/>
							<form:hidden value="${empDomain.clsCode}" style="width:100px;" cssClass="form-control" id="clsCode" path="clsCode"/>
							<form:errors path="clsCode" cssStyle="color:#ff0000;" element="span" />
						</td>
					</tr>
					<tr>
						<th class="check">
							<spring:message code="label.WAB002.locCode" /><!-- 사업장 -->
						</th>
						<td>
							<input value="${empDomain.locName}" style="width:100px;" class="form-control" type="text" disabled/>
							<form:hidden value="${empDomain.locCode}" style="width:100px;" cssClass="form-control" id="locCode" path="locCode"/>
							<form:errors path="locCode" cssStyle="color:#ff0000;" element="span" />
						</td>
					</tr>
					<tr>
						<th class="check">
							<spring:message code="label.WAB002.teamCode" /><!-- 부서(팀) -->
						</th>
						<td>
		            		<div class="inlineBlock">
								<input value="${empDomain.teamName}" style="width:100px;" class="form-control" type="text" disabled/>
								<form:hidden value="${empDomain.teamCode}" style="width:100px;" cssClass="form-control" id="teamCode" path="teamCode"/>
								<form:errors path="teamCode" cssStyle="color:#ff0000;" element="span" />
							</div>
							<div class="inlineBlock">	
								<button type="button" onclick="" class="AXButton Normal _deptBtn_" name="Cancel">
									<spring:message code="label.deptName" /><!-- 부서 -->
									<spring:message code="label.select" /><!-- 선택 -->
								</button>
							</div>
						</td>
					</tr> 
				</c:if>
				<tr>
					<th class="check">
						<label for="empEmail">
							<spring:message code="label.email" /><!-- 이메일 -->
						</label>
					</th>
					<td>
						<form:input value="${empDomain.empEmail}" style="width:250px;" cssClass="form-control fl" type="text" id="empEmail" path="empEmail" maxlength="45" cssErrorClass="form-control input-xs bg_error" autofocus="true" />
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
						<form:input value="${empDomain.empId}" style="width:150px;" cssClass="form-control" type="text" id="empId" path="empId" maxlength="45" cssErrorClass="form-control input-xs bg_error" autofocus="true" disabled="true"/>
						<form:errors path="empId" cssStyle="color:#ff0000;" element="span" />
					</td>
				</tr>
				<c:if test="${empDomain.inOutType eq 'O'}">
					<tr>
						<th class="check">
							<spring:message code="label.WAB002.empPasswd" /><!-- 비밀번호 -->
						</th>
						<td>
							<button type="button" class="AXButton Normal _pwdModifyBtn_" style=""
								onclick="" data-click-target="">
								<i>
									<!--  class="axi axi-ion-person-add"> -->
								</i>
								<spring:message code="label.WAB002.empPasswd" /><!-- 비밀번호 -->
								<spring:message code="label.modify" />
							</button> 
						</td>
					</tr>
				</c:if>
			</tbody>
		</table> 
		
		<div class="list-bnt writeOnly">
			<button type="submit" class="red" name="Register" onclick="return window.confirm('<spring:message code='DNKR-Q1-0002' />');">
				<spring:message code="label.modify" /><!-- 수정 -->
			</button>
			<%-- <button type="button" onclick="javascript:parent.location.href='${pageContext.request.contextPath}/main.do?'" class="gray" name="Cancel"><spring:message code="label.cancel" /><!-- 취소 --></button> --%>
			 <button type="button" onclick="javascript:closeTab();" class="gray" name="Cancel">
				<spring:message code="label.cancel" /><!-- 취소 -->
			</button>
		</div>
	
	</form:form>
	
</div> 
<div id="pwdWrap">
	<form id="">
		<div id="lText-pop" class="lText-pop">
			<p class="tit">비밀번호 변경<a href="#n" class="close" id="close">X</a></p>
			<div class="stxt">
				<table>
					<tr>
						<th class="check">
							<label for="pwd">
								비밀번호
								<%-- <spring:message code="label.WAB002.empId" /> --%><!-- 아이디 -->
							</label>
						</th>
						<td>
							<input id="empPwd" value="" style="width:250px;" class="form-control" type="password" maxlength="15" />
						</td>
					</tr>
					<tr>
						<th class="check">
							<label for="pwdCheck">
								비밀번호확인
								<%-- <spring:message code="label.WAB002.empId" /> --%><!-- 아이디 -->
							</label>
						</th>
						<td>
							<input id="empPwdAgain" value="" style="width:250px;" class="form-control" type="password" maxlength="15" />
						</td>
					</tr>
					
				</table>
				<input id="pwdEmp" value="${empDomain.empNumber}" type="hidden" maxlength="10"/>
				<button type="button" onclick="return pwdCheck()" class="red fr" name="Register" onclick="return window.confirm('<spring:message code='SMPL-Q0-0003' />');">
					<spring:message code="label.modify" /><!-- 수정 -->
				</button>
				
			</div>
		</div>
	</form>
</div>