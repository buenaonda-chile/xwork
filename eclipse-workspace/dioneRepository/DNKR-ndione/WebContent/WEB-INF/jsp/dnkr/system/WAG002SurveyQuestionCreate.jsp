<%--
 * PROJECTï¼
 *
 * [KR] 
 * 
 * $Id$
 *
 * Copyright (c) 2017 DENSO CORPORATION. All rights reserved.
 *
--%>
<!-- [EN] Contents area -->
<!-- [JP] ã³ã³ãã³ãã¨ãªã¢ -->
<link media="all" href="/css/board.css" rel="stylesheet"/>
<!-- <script type="text/javascript" src="/js/admin/WAG002SurveyQuestionCreate.js"></script> -->
<script type="text/javascript">
<!--
/**
 * [KO] 답변 수 추가하기
 *
 * @param targetId 'insertDiv'
 */
 function PrintAnswerLayout(targetID)
{
	var obj = document.getElementById(targetID);
	var Layout = "<input type=\"text\" class=\"research-tit\" name=\"answerTitle[]\" size=\"20\" title=\"설문제목을 입력해주세요\">";
	$(obj).append(Layout);
}

function addquestion()
{	
	var state = false
	if(document.getElementsByName("qstTitle")[0].value=="")
	{
		alert("질문을 등록하세요");
		document.getElementsByName("qstTitle")[0].focus();
		return false;
	}
	if(method.nType!="text"){
		//객관식인 경우
		var aCnt = document.getElementsByName("answerTitle[]").length;
		for(var i = 0 ;i < aCnt; i++)
		{
			if(document.getElementsByName("answerTitle[]")[i].value!="")
			{				
				state = true;
				break;
			}
		}
	}else{
		//주관식인 경우
		state = true;
	}
	if(!state)
	{
		alert("답변을 등록해 주세요");
	}
	else
	{
		if(confirm("추가 하시겠습니까?")){
			document.WAG002SurveyQuestionCreate.submit();
		}
	}
	return false;
}

var method = {
	init:function(){
		try{
			this.changeLayout();				
			var shCheck = document.getElementsByName("qstType");
			var len = shCheck.length;
			for(var i=0;i<len;i++){					
				shCheck[i].onclick = function(){
					method.changeLayout();						
				}
			}
		}catch(e){
			//초기화 실패시 객관식기능 활성화
			this.multipleChoiceLayout();
		}
					
	},
	changeLayout:function(){
		//선택항목에 맞는 레이아웃 구성 함수 호출
		var shCheck = document.getElementsByName("qstType");
		var len = shCheck.length;
		for(var i=0;i<len;i++){
			if(shCheck[i].checked){
				switch(shCheck[i].value){
					case "text":							
						this.shortAnswerLayout();
						this.nType = "text";
						break;
					case "radio":
						this.multipleChoiceLayout();
						this.nType = "radio";
						break;
					case "checkbox":
						this.multipleChoiceLayout();
						this.nType = "checkbox";
						break;
					default:
						this.multipleChoiceLayout();
						this.nType = "radio";
				}
			}
		}			
	},
	multipleChoiceLayout:function(){
		//객관식 레이아웃 구성
		$(".shortAnswerNode").hide();
		$(".answerTr").show();			
	},
	shortAnswerLayout:function(){
		//주관식 레이아웃 구성
		$(".answerTr").hide();
		$(".shortAnswerNode").show();
	}
};
	
	
	
	
function updateQuestion(srvCode,qstCode){
	if(confirm("확인을 누르시면 해당 질문을 수정하실 수 있습니다.")){
		location.href= "${pageContext.request.contextPath}/WAG002SurveyQuestionCreate/init.do?menu=${menu}&tabId=${tabId}&srvCode="+srvCode+"&qstCode="+qstCode;
	}  
}

function modiCancle(srvCode){
	if(confirm("확인을 누르시면 원래하면으로 돌아갑니다.")){
		location.href= "${pageContext.request.contextPath}/WAG002SurveyQuestionCreate/init.do?menu=${menu}&tabId=${tabId}&srvCode="+srvCode;
	}  
}

function modiQuestion(srvCode,qstCode){
	var form = document.WAG002SurveyQuestionCreate;
	if(confirm("해당 질문을 수정하시겠습니까?")){
		form.action = "${pageContext.request.contextPath}/WAG003SurveyQuestionUpdate/update.do?menu=${menu}&tabId=${tabId}";
		form.submit();
	}
}

function deleteQuestion(srvCode,qstCode,mode){
	if(confirm("해당 질문을 삭제하시겠습니까?(삭제하면 다른언어에 관한 항목들도 삭제됩니다.)")){
		location.href="${pageContext.request.contextPath}/WAG003SurveyQuestionUpdate/delete.do?menu=${menu}&tabId=${tabId}&srvCode="+srvCode+"&qstCode="+qstCode+"&mode="+mode;
	}
}

function deleteAnswer(srvCode,aswCode,mode){
	if(confirm("해당 질문을 삭제하시겠습니까?(삭제하면 다른언어에 관한 항목들도 삭제됩니다.)")){
		location.href="${pageContext.request.contextPath}/WAG003SurveyQuestionUpdate/delete.do?menu=${menu}&tabId=${tabId}&srvCode="+srvCode+"&qstCode="+aswCode+"&mode="+mode;
	}
}
	
function loadquestion(surveyidx) {
	
	if(confirm('이전문항을 불러오시겠습니까?\n* 주의 : 현재 작성되어있는 설문문항들은 삭제됩니다.')) {
		// 이전문항 세팅
		$.ajax({
			type:"POST",
			url:"${pageContext.request.contextPath}/WAG003SurveyQuestionUpdate/prevData.do?menu=${menu}&tabId=${tabId}",
			data : {srvCode : surveyidx},
			dataType : "json",
			async: false,
			success: function(data){
				alert(data.result);
			},
			error: function(xhr, status, error) {
				alert(error);
			}   
		});
		
		document.location.reload();
	}
}

$(function(){
	method.init();
});
//-->
</script>
<div class="research-cont-wrap">
	<div class="research-cont-top">
		<p class="ctxt"><span></span> 해당 설문에 대한 질문과 답변 항목을 추가 / 수정 / 삭제 하실 수 있습니다.</p>
		<form:form action="${pageContext.request.contextPath}/WAG002SurveyQuestionCreate/create.do?menu=${menu}&tabId=${tabId }" modelAttribute="WAG002SurveyQuestionCreate" name="WAG002SurveyQuestionCreate" method="POST">
		<input type="hidden" name="srvCode" value="${srvCode }"/>
		<input type="hidden" name="qstCode" value="${domain.qstCode }"/>
		
			<span class="top-border"></span>
			<table>
				<colgroup>
					<col width="10%">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th colspan="3" class="bg tc tit"><spring:message code="label.WAG001.surveyOption"/></th>
					</tr>
					<tr>
						<th class="tl stit"><spring:message code="label.WAG001.surveyKind"/></th>
						<c:if test="${domain ne null }">
							<c:set var="disabledCheck">disabled</c:set>
							<input type="hidden" name="qstType" value="${domain.qstType }"/>
						</c:if>
						<td class="type">
							<input type="radio" name="qstType" value="text" ${disabledCheck } id="write"  <c:if test="${domain.qstType eq 'text' }">checked</c:if>>
							<label for="write"><span class="radio-deco"></span> <spring:message code="label.WAG001.ceremony"/></label>
							<input type="radio" name="qstType" value="checkbox" ${disabledCheck } id="choice-and" <c:if test="${domain.qstType eq 'checkbox' }">checked</c:if>>
							<label for="choice-and"><span class="radio-deco"></span> <spring:message code="label.WAG001.Multiple"/> <span>(<spring:message code="label.WAG001.plurality"/> <spring:message code="label.WAG001.possible"/>)</span></label>
							<input type="radio" name="qstType" value="radio" ${disabledCheck } id="choice-or" <c:if test="${(domain eq null) or (domain.qstType eq 'radio')}">checked</c:if>>
							<label for="choice-or"><span class="radio-deco"></span> <spring:message code="label.WAG001.Multiple"/> <span>(<spring:message code="label.WAG001.plurality"/> <spring:message code="label.WAG001.impossible"/>)</span></label>
						</td>
					</tr>
					<tr>
						<th class="tl stit"><spring:message code="label.WAG001.question"/></th>
						<td>
							<input class="research-tit" type="text" name="qstTitle" id="qstTitle" title="설문제목을 입력해주세요" value="${domain.qstTitle }"></input>
						</td>
					</tr>
					<tr>
						<th class="tl stit"><spring:message code="label.WAG001.help"/></th>
						<td colspan="2">
							<input class="research-tit" type="text" name="qstHelp" title="설문제목을 입력해주세요" value="${domain.qstHelp }"></input>
						</td>
					</tr>
					<tr class="answerTr">
						<th class="tl stit"><spring:message code="label.WAG001.answer"/></th>
						<td>
						<div id="insertDiv">
							<c:choose>
								<c:when test="${domain.aswTitle ne '' && domain.aswTitle ne null }">
									<c:forTokens items="${domain.aswTitle }" delims="|" var="asw">
										<input class="research-tit" type="text" name="answerTitle[]" title="설문제목을 입력해주세요" value="${asw }"></input>
										<!-- <a href="#" title="삭제" class="del"><font size="5px">-</font></a> -->
									</c:forTokens>
								</c:when>
								<c:otherwise>
									<input class="research-tit" type="text" name="answerTitle[]" title="설문제목을 입력해주세요"></input>
								</c:otherwise>
							</c:choose>
							
						</div>
						<br>
							<button class="con-add-bnt" type="button" onClick="javascript:PrintAnswerLayout('insertDiv'); return false;">
								<span>추가</span>
							</button>
						</td>

					</tr>
			</table>
			</form:form>
			<div class="research-conB-bnt">
				<button type="button" class="prev-page" onClick="javascript:loadquestion('${srvCode}'); return false;">
					<span><spring:message code="label.WAG001.prevQuestion"/></span>
				</button>
				<button type="button" class="listback-b" name="Return" onclick="location.href='/WAG001SurveySearch/init.do?menu=${menu}&tabId=${tabId }'">
					<span><spring:message code="label.WAG001.ListView"/></span>
				</button>
				<c:choose>
					<c:when test="${domain ne null }">
						<c:if test="${fn:substring(authBinaryNum, 1, 2) eq '1' }">
							<button type="button" class="add-bnt red" name="Prepare" onClick="javascript:modiQuestion('${srvCode }','${rs.qstCode }'); return false;">
								<span><spring:message code="label.modify"/></span>
							</button>
						</c:if>
						<button type="button" class="add-bnt red" name="Prepare" onClick="javascript:modiCancle('${srvCode}'); return false;">
							<span><spring:message code="label.cancel"/></span>
						</button>
					</c:when>
					<c:otherwise>
						<c:if test="${fn:substring(authBinaryNum, 2, 3) eq '1' }">
							<button type="button" class="add-bnt red" name="Prepare" onClick="javascript:addquestion(); return false;">
								<span><spring:message code="label.WAG001.create"/></span>
							</button>	
						</c:if>
					</c:otherwise>
				</c:choose>
				
			</div>
	</div> <!--research-top-->
	<div class="gap20"></div>
	<div class="research-cont">
		<form name="ansForm">
			<table>
				<caption></caption>
				<tbody>
					<tr>
						<td>
				
						<c:forEach var="rs" items="${questionList}" varStatus="status">
							<c:choose>
								<c:when test="${rs.qstType eq 'text' }">
									<div>
										<div class="tit">
											<p class="txt">${status.index+1 }. ${rs.qstTitle }</p>
											<p class="bnt">
											<c:if test="${fn:substring(authBinaryNum, 0, 1) eq '1' }">
												<a href="#" onClick="javascript:deleteQuestion('${srvCode }','${rs.qstCode }','QUESTION'); return false;" title="삭제" class="del">-</a>
											</c:if>
											<c:if test="${fn:substring(authBinaryNum, 1, 2) eq '1' }">
												<a href="#" onClick="javascript:updateQuestion('${srvCode }','${rs.qstCode }'); return false;" title="추가" class="add">+</a>
											</c:if>
											</p>
										</div>
										<p class="help">( ${rs.qstHelp } )</p>
										<div class="ans">
											<textarea name="write" style="width:98%;height:80px;"></textarea>
										</div>
										<div class="gap20"></div>
									</div>
								</c:when>
								<c:when test="${rs.qstType eq 'checkbox' }">
									<div>
										<div class="tit">
											<p class="txt">${status.index+1 }. ${rs.qstTitle }</p>
											<p class="bnt">
												<c:if test="${fn:substring(authBinaryNum, 0, 1) eq '1' }">
												<a href="#" onClick="javascript:deleteQuestion('${srvCode }','${rs.qstCode }','QUESTION'); return false;" title="삭제" class="del">-</a>
												</c:if>
												<c:if test="${fn:substring(authBinaryNum, 1, 2) eq '1' }">
													<a href="#" onClick="javascript:updateQuestion('${srvCode }','${rs.qstCode }'); return false;" title="추가" class="add">+</a>
												</c:if>
											</p>
										</div>
										<p class="help">( ${rs.qstHelp } )</p>
										<c:set var="aswCnt2" value="0"></c:set>
										<c:forTokens items="${rs.aswTitle }" delims="|" var="asw">
	
										<div class="ans">
											<label>
												<input type="checkbox" name="asw[]" value=""><span class="radio-deco"></span>${asw}
											</label>
											<c:if test="${fn:substring(authBinaryNum, 0, 1) eq '1' }">
											<a href="#" onClick="javascript:deleteAnswer('${srvCode }','${fn:split(rs.aswCode,'|')[aswCnt2] }','ANSWER'); return false;" title="삭제" class="del">-</a>
											</c:if>
										</div>
										<c:set var="aswCnt2">${aswCnt2+1 }</c:set>
										</c:forTokens>
										<div class="gap20"></div>
									</div>
								</c:when>
								<c:when test="${rs.qstType eq 'radio' }">
									<div>
										<div class="tit">
											<p class="txt">${status.index+1 }. ${rs.qstTitle }</p>
											<p class="bnt">
											<c:if test="${fn:substring(authBinaryNum, 0, 1) eq '1' }">
												<a href="#" onClick="javascript:deleteQuestion('${srvCode }','${rs.qstCode }','QUESTION'); return false;" title="삭제" class="del">-</a>
											</c:if>
											<c:if test="${fn:substring(authBinaryNum, 1, 2) eq '1' }">
												<a href="#" onClick="javascript:updateQuestion('${srvCode }','${rs.qstCode }'); return false;" title="추가" class="add">+</a>
											</c:if>
											</p>
										</div>
										<p class="help">( ${rs.qstHelp } )</p>
										<c:set var="aswCnt3" value="0"></c:set>
										<c:forTokens items="${rs.aswTitle }" delims="|" var="asw">
										
										<div class="ans">
											<label>
												<input type="radio" name="ans03" value=""><span class="radio-deco"></span>${asw }
											</label>
											<c:if test="${fn:substring(authBinaryNum, 0, 1) eq '1' }">
												<a href="#" onClick="javascript:deleteAnswer('${srvCode }','${fn:split(rs.aswCode,'|')[aswCnt3] }','ANSWER'); return false;" title="삭제" class="del">-</a>
											</c:if>
										</div>
										<c:set var="aswCnt3">${aswCnt3+1 }</c:set>
										</c:forTokens>
										<div class="gap20"></div>
									</div>
								</c:when>
							</c:choose>
						</c:forEach>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div><!--research-list-->
</div>
		