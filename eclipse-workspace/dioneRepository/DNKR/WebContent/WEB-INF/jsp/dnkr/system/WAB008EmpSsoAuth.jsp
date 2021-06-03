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

<c:if test="${fn:length(relationList) > 0}">
	<script type="text/javascript">
	var options = [];
	
	
	<c:forEach var="relationDomain" items="${relationList}" varStatus="status">
	
		options.push({value: "${relationDomain.relationCode}", text: "${relationDomain.relationName}"});
	
	</c:forEach>
	</script>
</c:if>
<script type="text/javascript">
var options2 = [];
function setOptions(params) {
	$.ajax({
		method : "post",
		url : "/ajaxRelation/init.do",
		data : params,
		success : function(res) {
			//console.log(res);
			var data = JSON.parse(res);
			//console.log(data);
			//console.log(typeof data);
			options = [];
			if(data.list.length > 0){
				data.list.forEach(function(n) {
					//console.log(typeof n.relationName);
					options.push({value: ""+ n.relationCode, text: ""+n.relationName});
				});
			}
			//console.log("options2:" + options2)
			 
		},
		error : function(res) {
			
		},
		completed : function(res) {
			
		}
	});
}
$(document.body).ready(function () {
	
	$('#clsAutoComplete').on('click', function() {
		//console.log("autocomplete1.click");
		var params = {
				"type": "CLS",
				"clsCode": "",
		};
    	setOptions(params);
	});
	
	$('#locAutoComplete').on('click', function() {
		//console.log("locAutoComplete.click");
		var clsCode = $('#clsAutoComplete select.form-control').val() + "";
		
		if( clsCode.trim().length === 0 || clsCode === null || clsCode === "null"){
			toastMsg('사업부를 먼져 입력해주세요');
			options = [];
			return;
		}
		var params = {
				"type": "LOC",
				"parentCode": clsCode,
		};
    	
    	setOptions(params);
	});
	
	$('#teamAutoComplete').on('click', function() {
		//console.log("autocomplete2.click");
		var locCode = $('#locAutoComplete select.form-control').val() + "";
		
		if( locCode.trim().length === 0 || locCode === null || locCode === "null"){
			toastMsg('사업장를 먼져 입력해주세요');
			options = [];
			return;
		}
		var params = {
				"type": "TEAM",
				"parentCode": locCode,
		};
    	
    	setOptions(params);
	});
	
	
    $('#clsAutoComplete').ax5autocomplete({
        removeIcon: '<i class="fa fa-times" aria-hidden="true"></i>',
        onSearch: function (callBack) {
            var searchWord = this.searchWord;
            setTimeout(function () {
                var regExp = new RegExp(searchWord);
                var myOptions = [];
                options.forEach(function (n) {
                    if (n.text.match(regExp)) {
                        myOptions.push({
                            value: n.value,
                            text: n.text
                        })
                    }
                });
                callBack({
                    options: myOptions
                });
            }, 150);

        },
        onChange: function() {
        	
        }
    });
    
    
    $('#locAutoComplete').ax5autocomplete({
        removeIcon: '<i class="fa fa-times" aria-hidden="true"></i>',
        onSearch: function (callBack) {
        	//console.log(this);
            var searchWord = this.searchWord;
            setTimeout(function () {
                var regExp = new RegExp(searchWord);
                var myOptions = [];
                
                options.forEach(function (n) {
                    if (n.text.match(regExp)) {
                        myOptions.push({
                            value: n.value,
                            text: n.text
                        })
                    }
                });
                callBack({
                	options: myOptions
                });
            }, 150);

        },
        onChange: function() {
        	setValue($('#clsAutoComplete'), {value:"", text:""})
        }
	});
    
    $('#teamAutoComplete').ax5autocomplete({
        removeIcon: '<i class="fa fa-times" aria-hidden="true"></i>',
        onSearch: function (callBack) {
            var searchWord = this.searchWord;
            setTimeout(function () {
                var regExp = new RegExp(searchWord);
                var myOptions = [];
                options.forEach(function (n) {
                    if (n.text.match(regExp)) {
                        myOptions.push({
                            value: n.value,
                            text: n.text
                        })
                    }
                });
                callBack({
                	options: myOptions
                });
            }, 150);

        },
	});
    
	$('input[name=empPrivateAuth]:radio').on('change', function() {
		//console.log('change');
		var empPrivateAuthValue = this.value;
		if(empPrivateAuthValue === 'Y'){
			$('#authCode').closest('tr').removeClass('displayNone');
		} else {
			$('#authCode').closest('tr').addClass('displayNone');
		}
	});
	
	$('._authConfigBtn_').on( 'click', function(e){
		var empNumber = $('#empNumber').val();
		if(empNumber)
		window.open("/WAD006PrivateAuthConfig/init.do?empNumber="+empNumber,"new","width=950,height=700,scrollbars=yes,top=100,left=100");
	});
	
	$('._pwdModifyBtn_').on('click', function() {
		$("#pwdWrap").fadeIn(300);
	});
	
	$("#close").click(function(){
		$("#pwdWrap").fadeOut(300);	
	});
	
	
	
});    
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
	<form:form action="${pageContext.request.contextPath}/WAB004EmpUpdate/update.do?menu=${menu}" modelAttribute="WAB002EmpCreateForm" name="WAB002EmpCreateForm" method="POST">
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
								<input value="${empDomain.teamName}" style="width:150px;" class="form-control" type="text" disabled/>
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
				<!-- Start 추가시 에러발생함  -->
					<tr>
						<th class="check">
							<spring:message code="label.supplyComps" /><!-- 협력업체(납품공장) -->
						</th>
						<td>
<!--						
							<form:input value="${empDomain.relationCopLoc}" style="width:150px;" cssClass="form-control" type="text" id="relationCopLoc" path="relationCopLoc" maxlength="2" cssErrorClass="form-control input-xs bg_error" autofocus="true"/>
							<form:errors path="relationCopLoc" cssStyle="color:#ff0000;" element="span" />
-->							
							<form:select id="relationCopLoc" name="relationCopLoc" path="relationCopLoc">
								<form:option value=""><spring:message code="label.loc_na"/></form:option>
								<c:if test="${fn:length(locList)>0}" >
									<c:forEach var="locDomain" items="${locList}" varStatus="status">
										<c:choose>
											<c:when test="${locDomain.relationCode eq empDomain.relationCopLoc}">
								                 <form:option value="${locDomain.relationCode}" label="${locDomain.relationName}" selected="true" > </form:option>
								            </c:when>
								            <c:otherwise>
								                <form:option value="${locDomain.relationCode}" label="${locDomain.relationName}"> </form:option>
								            </c:otherwise>
								        </c:choose> 
									</c:forEach>
								</c:if>
							</form:select>
						</td>
					</tr>
					<tr>
						<th class="check">
							<spring:message code="label.companyId" /><!-- 협력업체(사업자번호) -->
						</th>
						<td>
							<form:input value="${empDomain.relationCopNo}" style="width:250px;" cssClass="form-control" type="text" id="relationCopNo" path="relationCopNo" maxlength="45" cssErrorClass="form-control input-xs bg_error" autofocus="true"/>
							<form:errors path="relationCopNo" cssStyle="color:#ff0000;" element="span" />

						</td>
					</tr>
				<!-- End -->	
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
				<tr>
					<th class="check">
						<spring:message code="label.WAB002.privateAuth" /><!-- 개인권한 -->&nbsp;
						<spring:message code="label.useYn" /><!-- 사용여부 -->&nbsp;
					</th>
					<td>
						<c:choose>
							<c:when test="${empDomain.empPrivateAuth eq 'Y'}">
								<form:radiobutton id="empPrivateAuthY" path="empPrivateAuth" value="Y" checked="checked"/>
									<spring:message code="label.yes" /><!-- 예 -->&nbsp;
								<form:radiobutton id="empPrivateAuthN" path="empPrivateAuth" value="N"/>
									<spring:message code="label.no" /><!-- 아니오 -->			
							</c:when>
							<c:otherwise>
								<%-- 							
								<form:radiobutton id="empPrivateAuthY" path="empPrivateAuth" value="Y" />
									<spring:message code="label.yes" /><!-- 예 -->&nbsp;
								<form:radiobutton id="empPrivateAuthN" path="empPrivateAuth" value="N" checked="checked"/>
									<spring:message code="label.no" /><!-- 아니오 -->			
								--%>
								<c:choose>							
									<c:when test="${menu eq '2'}">
										<form:radiobutton id="empPrivateAuthY" path="empPrivateAuth" value="Y" />
											<spring:message code="label.yes" /><!-- 예 -->&nbsp;
										<form:radiobutton id="empPrivateAuthN" path="empPrivateAuth" value="N" checked="checked"/>
											<spring:message code="label.no" /><!-- 아니오 -->			
									</c:when>
									<c:otherwise>
										<form:radiobutton id="empPrivateAuthY" path="empPrivateAuth" value="Y" disabled="true"/>
											<spring:message code="label.yes" /><!-- 예 -->&nbsp;
										<form:radiobutton id="empPrivateAuthN" path="empPrivateAuth" value="N" checked="checked"/>
											<spring:message code="label.no" /><!-- 아니오 -->			
									</c:otherwise>	
								</c:choose>
							</c:otherwise>
						</c:choose>
						
						<form:errors path="empPrivateAuth" cssStyle="color:#ff0000;" element="span" />
					</td>
				</tr>
				<tr
			
					<c:if test="${empDomain.empPrivateAuth ne 'Y'}">
						class="displayNone"
					</c:if>
						
				>
					<th class="check">
						<spring:message code="label.WAB002.privateAuth" /><!-- 개인권한 -->
					</th>
					<td>
                        <button type="button" class="AXButton Normal _authConfigBtn_" style=""
								onclick="" data-click-target="">
								<i>
									<!--  class="axi axi-ion-person-add"> -->
								</i>
								<spring:message code="label.WAB002.privateAuthConfig" /><!-- 개인권한설정 -->
						</button> 
						<form:hidden id="authCode" value="${empDomain.authCode}" path="authCode" maxlength="45" cssErrorClass="form-control input-xs bg_error"/>
						<form:errors path="authCode" cssStyle="color:#ff0000;" element="span" />
					</td>
				</tr>
				<tr>
					<th class="check">
						<span class="necessary">* </span>
						<spring:message code="label.WAB002.empAvailability" /><!-- 사원 사용여부 -->
					</th>
					<td>
						<c:choose>
							<c:when test="${empDomain.empUse eq 'Y'}">
								<form:radiobutton id="empUseY" path="empUse" value="Y" checked="checked"/>
									<spring:message code="label.yes" /><!-- 예 -->&nbsp;
								<form:radiobutton id="empUseN" path="empUse" value="N" />
									<spring:message code="label.no" /><!-- 아니오 -->
							</c:when>
							<c:otherwise>
								<form:radiobutton id="empUseY" path="empUse" value="Y"/>
									<spring:message code="label.yes" /><!-- 예 -->&nbsp;
								<form:radiobutton id="empUseN" path="empUse" value="N" checked="checked"/>
									<spring:message code="label.no" /><!-- 아니오 -->
							</c:otherwise>
						</c:choose>
						<form:errors path="empUse" cssStyle="color:#ff0000;" element="span" />
					</td>
				</tr>
			</tbody>
		</table> 
		
		<div class="list-bnt writeOnly">
			<button type="submit" class="red" name="Register" onclick="return window.confirm('<spring:message code='DNKR-Q1-0002' />');">
				<spring:message code="label.modify" /><!-- 수정 -->
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
				<button type="button" onClick="return pwdCheck()" class="red fr" name="Register" onclick="return window.confirm('<spring:message code='SMPL-Q0-0000' />');">
					<spring:message code="label.modify" /><!-- 수정 -->
				</button>
				
			</div>
		</div>
	</form>
</div>