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
<link media="all" href="/css/board.css" rel="stylesheet"/>
<script>
	function applyQuestion(){
		var form = document.WAG008SurveyPaperViewForm;
		if(confirm("설문을 등록하시겠습니까?")){
			form.submit();
		}
	}

</script>
<div class="research-cont-wrap">
			<div class="research-cont-top">
				<p class="ctxt"><span></span> 해당 설문에 대한 질문과 답변 항목을 추가 / 수정 / 삭제 하실 수 있습니다.</p>
			</div> <!--research-top-->
			<div class="gap20"></div>
			<div class="research-cont">
			<form:form action="/WAG005SurveyPaper/create.do?menu=${menu }&tabId=${tabId}" modelAttribute="WAG008SurveyPaperViewForm" name="WAG008SurveyPaperViewForm" method="POST">
			<input type="hidden" name="srvCode" value="${srvCode }">
			
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
											</div>
											<p class="help">( ${rs.qstHelp } )</p>
											<div class="ans">
												${rs.drAnswer }
											</div>
											<div class="gap20"></div>
										</div>
									</c:when>
									<c:when test="${rs.qstType eq 'checkbox' }">
										<div>
											<div class="tit">
												<p class="txt">${status.index+1 }. ${rs.qstTitle }</p>
											</div>
											<p class="help">( ${rs.qstHelp } )</p>
											<c:set var="asw2Cnt">0</c:set>
											<c:forTokens items="${rs.aswTitle }" delims="|" var="asw">
											<c:set var="checked" value=""></c:set>
											<c:if test="${fn:split(rs.aswCode,'|')[asw2Cnt] eq fn:split(rs.mulCheck,'|')[asw2Cnt] }">
												<c:set var="checked" value="checked"></c:set>
											</c:if>

											<div class="ans">
												<label>
													<input type="checkbox" ${checked } name="asw_${rs.qstCode }" value="" disabled><span class="radio-deco"></span>${asw}
													
												</label>
											</div>
											<c:set var="asw2Cnt">${asw2Cnt+1 }</c:set>
											</c:forTokens>
											<div class="gap20"></div>
										</div>
									</c:when>
									<c:when test="${rs.qstType eq 'radio' }">
										<div>
											<div class="tit">
											<p class="txt">${status.index+1 }. ${rs.qstTitle }</p>
											</div>
											<p class="help">( ${rs.qstHelp } )</p>
											<c:set var="asw3Cnt">0</c:set>
											<c:forTokens items="${rs.aswTitle }" delims="|" var="asw">
											<div class="ans">
											<c:set var="checked" value=""></c:set>
											<c:if test="${fn:split(rs.aswCode,'|')[asw3Cnt] eq fn:split(rs.mulCheck,'|')[asw3Cnt] }">
												<c:set var="checked" value="checked"></c:set>
											</c:if>
												<label>
													<input type="radio" ${checked } name="asw_${rs.qstCode }" value="" disabled><span class="radio-deco"></span>${asw }
												</label>
											</div>
											<c:set var="asw3Cnt">${asw3Cnt+1 }</c:set>
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
			</form:form>
				<div class="research-conB-bnt" style="text-align:center;">
						
						<button type="button" class="listback-b" name="Return" onclick="location.href='/WAG001SurveySearch/participation.do?menu=${menu}&tabId=${tabId}&srvCode=${srvCode }'">
							<span>목록보기</span>
						</button>
						
					</div>
			</div><!--research-list-->
			</div>
		