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
<!-- [JP] コンテンツエリア -->
<link media="all" href="/css/board.css" rel="stylesheet"/>
<script type="text/javascript">
<!--
$(function() {
	$('._excelBtn_').on('click', function(){
		//console.log('excelBtn clicked');
		//fnExcelReport('empExcel', 'empInfo');
		var surveyCode = $(this).attr("data-srvCode");
		location.href = "/WAG007SurveyTotalSelect/excel.do?filename=surveyList&srvCode=" + surveyCode;
	});
}) 
-->
</script>
<div class="research-cont result">
			<div class="research-cont-top">
				<!-- <p class="ctxt"><span></span> 해당 설문에 대한 질문과 답변 항목을 추가 / 수정 / 삭제 하실 수 있습니다.</p> -->
				<div class="research-conB-bnt" style="text-align:right;">
					<button type="button" class="xlsDown _excelBtn_" data-srvCode="${srvCode }">
						<span><spring:message code='label.excelDown' /><!-- 엑셀다운 --></span>
					</button>
					<button type="button" class="listback-b" name="Return" onclick="location.href='/WAG001SurveySearch/init.do?menu=${menu}&tabId=${tabId}'">
						<span><spring:message code="label.WAG001.ListView"/></span>
					</button>
					
				</div>
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
												<p class="txt">${status.index+1 }. ${rs.qstTitle }<span class="fr">주관식<span></p>
											</div>
											<p class="help">( ${rs.qstHelp } )</p>
											<div class="ans">
												
												<c:forEach var="rsText" items="${rs.drAnswerList}" varStatus="status">${status.index+1}. ${rsText}<br>
												</c:forEach>
												
												<input type="hidden" name="drQstCode[]" value="${rs.qstCode }">
											</div>
											<div class="gap20"></div>
										</div>
									</c:when>
									<c:when test="${rs.qstType eq 'checkbox' }">
										<div>
											<div class="tit">
												<input type="hidden" name="qstCodeStr[]" value="${rs.qstCode }" />
												<p class="txt">${status.index+1 }. ${rs.qstTitle }<span class="fr">객관식(복수응답)<span></p>
											</div>
											<p class="help">( ${rs.qstHelp } )</p>
											<c:set var="asw2Cnt">0</c:set>
											<c:forTokens items="${rs.aswTitle }" delims="|" var="asw">

											
												<div class="ans">
													<p  class="rs-tit">${asw}</p>
													<!--그래프-->
													<c:set var="widthPercent">${fn:split(rs.aswTotalPercent,"|")[asw2Cnt] }</c:set>
													<p class="graphshape">
														<span class="shape01" style='width:${widthPercent}%;'></span>
													<p class="gTxt"><span>${fn:split(rs.aswTotalCount,"|")[asw2Cnt] }명</span> / ${fn:split(rs.aswTotalPercent,"|")[asw2Cnt] }%</p>
												</div>
											
												<c:set var="asw2Cnt">${asw2Cnt+1 }</c:set>
											</c:forTokens>
											<div class="gap20"></div>
										</div>
									</c:when>
									<c:when test="${rs.qstType eq 'radio' }">
										<div>
											<div class="tit">
												<input type="hidden" name="qstCodeStr[]" value="${rs.qstCode }" />
											<p class="txt">${status.index+1 }. ${rs.qstTitle }<span class="fr">객관식(단일응답)<span></p>
											</div>
											<p class="help">( ${rs.qstHelp } )</p>
											<c:set var="asw3Cnt">0</c:set>
											<c:forTokens items="${rs.aswTitle }" delims="|" var="asw">
												<div class="ans">
													<p  class="rs-tit">${asw}</p>
													<!--그래프-->
													<c:set var="widthPercent">${fn:split(rs.aswTotalPercent,"|")[asw3Cnt] }</c:set>
													<p class="graphshape">
														<span class="shape01" style='width:${widthPercent}%'></span>
													<p class="gTxt"><span>${fn:split(rs.aswTotalCount,"|")[asw3Cnt] }명</span> / ${fn:split(rs.aswTotalPercent,"|")[asw3Cnt] }%</p>
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
				
			</div><!--research-list-->
			</div>
		