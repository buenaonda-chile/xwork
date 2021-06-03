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
<link rel="stylesheet" media="all" href="/css/board.css?ver"/>
<script>
	function checksurvey(mode)
	{
		
		var form = document.WAG001SurveyCreateForm;
		if(form.srvTitle.value=="")
		{
			alert('타이틀을 적어주세요');
			form.srvTitle.focus();
			return false;
		}
		
		if(mode == "update"){
			form.action = form.action + "&srvCode=${sdomain.srvCode}";
		}
		form.submit();
	}
	
	function deleteSurvey(srvCode, title){
		if(confirm("'"+title+"' 설문조사를 삭제하시겠습니까?(해당설문에 관한 내용이 모두 지워집니다.)")){
			location.href="${pageContext.request.contextPath}/WAG001SurveySearch/delete.do?menu=${menu}&tabId=${tabId}&srvCode="+srvCode;
		}
	}
	
	function useUpdate(srvCode,useYn,title){
		
		if(confirm("'"+title+"' 설문조사의 상태를 변경하시겠습니까?")){
			location.href="${pageContext.request.contextPath}/WAG001SurveySearch/update.do?menu=${menu}&tabId=${tabId}&srvCode="+srvCode+"&srvUse="+useYn;		
		}
	}
</script>
<div class="research-list-wrap">
			<div class="research-top">
				<form:form action="${pageContext.request.contextPath}/WAG001SurveySearch/create.do?menu=${menu}&tabId=${tabId}" modelAttribute="WAG001SurveyCreateForm" name="WAG001SurveyCreateForm" method="POST">
					<table>
						<colgroup>
							<col width="12%">
							<col width="12%">
							<col width="*">
							<col width="12%">
						</colgroup>
						<tbody>
							<tr>
								<th rowspan="4" class="bg tc"><spring:message code="label.menu.survey"/></th>
								<th class="tl stit"><spring:message code="label.WAG001.title"/></th>
								<td>
									<input autofocus="true" class="research-tit" type="text" name="srvTitle" title="설문제목을 입력해주세요" value="${sdomain.srvTitle }"></input>
								</td>
								
								<td rowspan="4" class="bg-w tc">
									
										<c:choose>
											<c:when test="${sdomain.srvCode ne null && sdomain.srvCode ne ''}">
											<c:if test="${fn:substring(authBinaryNum, 1, 2) eq '1' }">
											<button class="add-bnt red" onClick="javascript:checksurvey('update'); return false;">
												<span><spring:message code="label.modify"/></span>
											</button>
											</c:if>
												<div class="list-bnt listOnly" style="padding-right:20px;">
													<a href="${pageContext.request.contextPath}/WAG001SurveySearch/init.do?menu=${menu}&tabId=${tabId}" class="gray" style="padding: 8px 32px;"><spring:message code="label.cancel"/></a>
												</div>
											</c:when>
											<c:otherwise>
											<c:if test="${fn:substring(authBinaryNum, 2, 3) eq '1' }">
												<button class="add-bnt red" onClick="javascript:checksurvey('insert'); return false;">
													<span><spring:message code="label.WAG001.create"/></span>
												</button>
											</c:if>
											</c:otherwise>
										</c:choose>
										
								</td>
							</tr>
							<tr>
								<th class="tl stit"><spring:message code="label.WAG001.startDate"/></th>
								<td>
									<div class="st-date">
										<c:choose>
											<c:when test="${sdomain.srvCode ne null }">
												<c:set var="startDate">${fn:split(sdomain.srvStart,' ')[0] }</c:set>
												<c:set var="endDate">${fn:split(sdomain.srvEnd,' ')[0] }</c:set>
												<c:set var="startTime">${fn:split(sdomain.srvStart,' ')[1] }</c:set>
												<c:set var="endTime">${fn:split(sdomain.srvEnd,' ')[1] }</c:set>
											</c:when>
											<c:otherwise>
												<c:set var="startDate">${year }-${month }-${day }</c:set>
												<c:set var="endDate">${year }-${month }-${day }</c:set>
												
											</c:otherwise>
										</c:choose>
									
										<select name="startY" title="날짜를 선택해주세요">
										<c:forEach begin="${year -2}" end="${year +3}" varStatus="i">
											<option value="${i.index }" <c:if test="${fn:split(startDate,'-')[0] eq i.index }">selected</c:if>>${i.index } &nbsp;<spring:message code="label.WAG001.year"/></option>
										</c:forEach>
										</select>
										<select name="startM" title="날짜를 선택해주세요">
											<c:forEach begin="1" end="12" varStatus="i">
												<option value="${i.index }" <c:if test="${fn:split(startDate,'-')[1] eq i.index }">selected</c:if>>${i.index } &nbsp;<spring:message code="label.WAG001.month"/></option>
											</c:forEach>
										</select>
										<select name="startD" title="날짜를 선택해주세요">
											<c:forEach begin="1" end="31" varStatus="i">
												<option value="${i.index }" <c:if test="${fn:split(startDate,'-')[2] eq i.index }">selected</c:if>>${i.index } &nbsp;<spring:message code="label.WAG001.day"/></option>
											</c:forEach>
										</select>
										<select name="startH" title="날짜를 선택해주세요">
											<c:forEach begin="0" end="23" varStatus="i">
												<option value="${i.index }" <c:if test="${fn:split(startTime,':')[0] eq i.index }">selected</c:if>>${i.index }&nbsp; <spring:message code="label.WAG001.hour"/></option>
											</c:forEach>
										</select>
										<select name="startI" title="날짜를 선택해주세요">
											<c:forEach begin="0" end="50" step="10" varStatus="i">
												<option value="${i.index }" <c:if test="${fn:split(startTime,':')[1] eq i.index }">selected</c:if>>${i.index } &nbsp;<spring:message code="label.WAG001.minute"/></option>
											</c:forEach>
										</select>
										<span>~</span>
									</div><!--st-date-->
								</td>
								
							</tr>
							<tr>
								<th class="tl stit"><spring:message code="label.WAG001.endDate"/></th>
								<td>
									<div class="end-date">
										<select name="endY" title="날짜를 선택해주세요">
											<c:forEach begin="${year -2}" end="${year +3}" varStatus="i">
											<option value="${i.index }" <c:if test="${fn:split(endDate,'-')[0] eq i.index }">selected</c:if>>${i.index } &nbsp;<spring:message code="label.WAG001.year"/></option>
										</c:forEach>
										</select>
										<select name="endM" title="날짜를 선택해주세요">
											<c:forEach begin="1" end="12" varStatus="i">
												<option value="${i.index }" <c:if test="${fn:split(endDate,'-')[1] eq i.index }">selected</c:if>>${i.index } &nbsp;<spring:message code="label.WAG001.month"/></option>
											</c:forEach>
										</select>
										<select name="endD" title="날짜를 선택해주세요">
											<c:forEach begin="1" end="31" varStatus="i">
												<option value="${i.index }" <c:if test="${fn:split(endDate,'-')[2] eq i.index }">selected</c:if>>${i.index }&nbsp; <spring:message code="label.WAG001.day"/></option>
											</c:forEach>
										</select>
										<select name="endH" title="날짜를 선택해주세요">
											<c:forEach begin="0" end="23" varStatus="i">
												<option value="${i.index }" <c:if test="${fn:split(endTime,':')[0] eq i.index }">selected</c:if>>${i.index } &nbsp;<spring:message code="label.WAG001.hour"/></option>
											</c:forEach>
										</select>
										<select name="endI" title="날짜를 선택해주세요">
											<c:forEach begin="0" end="50" step="10" varStatus="i">
												<option value="${i.index }" <c:if test="${fn:split(endTime,':')[1] eq i.index }">selected</c:if>>${i.index } &nbsp;<spring:message code="label.WAG001.minute"/></option>
											</c:forEach>
										</select>
										
									</div><!--end-date-->
								</td>
							</tr> 
							<tr>
								<th class="tl stit"><spring:message code="label.WAG001.noname"/></th>
								<td>	
								<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }">
									<input type="radio" name="srvAnonymous" id="srvAnonymousY" value="Y" 
									<c:choose><c:when test="${sdomain.srvAnonymous eq 'Y'}">checked</c:when><c:when test="${sdomain eq null }">checked</c:when></c:choose> >&nbsp;
									<label for="srvAnonymousY"><span style="vertical-align: bottom;">
									<spring:message code="label.yes"/></span></label>
									&nbsp;&nbsp;
									<input type="radio" name="srvAnonymous" id="srvAnonymousN" value="N" <c:if test="${sdomain.srvAnonymous eq 'N'}">checked</c:if> >&nbsp;
									<label for="srvAnonymousN"><span style="vertical-align: bottom;"><spring:message code="label.no" /></span></label>
								</c:if>
									</td>
							</tr>
					</table>
				</form:form>
			</div> <!--research-top-->
			<div class="gap10"></div>
			
			<div class="research-list">
			<span class="top-border"></span>
			<div class="m-scroll">
				<table style="min-width:850px">
					<caption></caption>
					<colgroup>
						
						<col scope="col" width="5%">
						<!-- <col scope="col" width="25%"> -->
						<col scope="col" width="*">
						<col scope="col" width="5%">
						<col scope="col" width="20%">
						<col scope="col" width="5%">
						<col scope="col" width="5%">
						<col scope="col" width="8%">
						<col scope="col" width="12%">
					</colgroup>
					<thead>
						<tr>
							
							<th><spring:message code="label.number"/></th>
							<th><spring:message code="label.title"/></th>
							<th><spring:message code="label.apply"/></th>
							<th><spring:message code="label.process"/></th>
							<th><spring:message code="label.WAG004.name"/></th>
							<th><spring:message code="label.bigo"/></th>
							<th><spring:message code="label.status"/></th>
							<th><spring:message code="label.delete"/></th>
						</tr>
					</thead>
					<tbody>
					 <c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }">
					<c:choose>
					<c:when test="${fn:length(surveyList) > 0}">
					<c:forEach var="surveyDomain" items="${surveyList}" varStatus="status">
					<%-- <c:if test="${sessionteamCode eq surveyDomain.teamCode}"> --%>
						<tr>
							<td>${surveyDomain.rowNum }</td>
							<td class="leftImpr c_b3">
								<a href="${pageContext.request.contextPath}/WAG001SurveySearch/init.do?menu=${menu}&tabId=${tabId}&srvCode=${surveyDomain.srvCode}&pageNo=${paging.pageNo }">
									<c:choose>
										<c:when test="${fn:length(surveyDomain.srvTitle ) > 20}">
											${fn:substring(surveyDomain.srvTitle,0,20) }....
										</c:when>
										<c:otherwise>
											${surveyDomain.srvTitle}
										</c:otherwise>
									</c:choose>
								</a>
								<c:if test="${surveyDomain.srvAnonymous eq 'Y' }">
									</br>
									<c:out value="${pageContext.request.contextPath}"/>/WAG005SurveyPaper/paperView.do?srvCode=<c:out value="${surveyDomain.srvCode}"/>
								</c:if>
							</td>
							<td>${surveyDomain.cnt }</td>
							<td>${fn:substring(surveyDomain.srvStart,0,16) } ~<br> ${fn:substring(surveyDomain.srvEnd,0,16) }</td>
							
							<!-- 대상자선택 -->
							<td align="center" class="mg-btn">
							<c:if test="${fn:substring(authBinaryNum, 2, 3) eq '1' }">
								<c:choose>
									<c:when test="${surveyDomain.srvAnonymous eq 'Y' }">
										<button class="btn_type01" onclick="javascript:alert('익명성 설문조사입니다.'); return false;">익명성<br>설문조사</button>
										<%-- <button class="btn_type01" onclick="javascript:alert('익명성 설문조사입니다.'); return false;"><spring:message code="label.WAG004.name"/><spring:message code="label.select"/></button>
										<button class="btn_type01" onclick="javascript:alert('익명성 설문조사입니다.'); return false;"><spring:message code="label.WAG001.surveyConfirm"/></button> --%>	
									</c:when>
									<c:otherwise>
										<button class="btn_type01" onclick="window.open('/WAG004SurveyTarget/init.do?srvCode=${surveyDomain.srvCode}&view=normal','Target','width=950,height=700,top=100,left=100,scrollbars=yes');"><spring:message code="label.WAG004.name"/><spring:message code="label.select"/></button>
										<button class="btn_type01" onclick="window.open('/WAG004SurveyTarget/init.do?srvCode=${surveyDomain.srvCode}&mode=view','Target','width=950,height=700,top=100,left=100,scrollbars=yes');"><spring:message code="label.WAG001.surveyConfirm"/></button>
									</c:otherwise>									
								</c:choose>		
							</c:if>
							</td>
							
							<td align="center" class="mg-btn">
								<button class="btn_type01" onClick="location.href='/WAG002SurveyQuestionCreate/init.do?menu=${menu}&tabId=${tabId }&srvCode=${surveyDomain.srvCode}'"><spring:message code="label.WAG001.itemManage"/></button>
								<c:choose>
									<c:when test="${surveyDomain.srvAnonymous eq 'Y' }">
									<button class="btn_type01" onclick="javascript:alert('익명성 설문조사입니다.'); return false;"><spring:message code="label.WAG001.participants"/></button>
									</c:when>
									<c:otherwise>
									<button class="btn_type01" onclick="location.href='/WAG001SurveySearch/participation.do?menu=${menu}&tabId=${tabId }&srvCode=${surveyDomain.srvCode}'"><spring:message code="label.WAG001.participants"/></button>
									</c:otherwise>									
								</c:choose>
								<button class="btn_type01" onclick="location.href='/WAG007SurveyTotalSelect/init.do?menu=${menu}&tabId=${tabId }&srvCode=${surveyDomain.srvCode}&pageNo=${paging.pageNo }'"><spring:message code="label.WAG001.results"/></button>
							</td>
							<td  class="mg-btn">
							<c:choose>
								<c:when test="${surveyDomain.srvUse eq 'Y' }">
									<%-- <a href="#" onClick="javascript:useUpdate('${surveyDomain.srvCode}','${surveyDomain.srvUse}','${surveyDomain.srvTitle }'); return false;"><spring:message code="label.useY"/></a> --%>
									<button class="btn_type01" style="height: 34px;" onClick="javascript:useUpdate('${surveyDomain.srvCode}','${surveyDomain.srvUse}','${surveyDomain.srvTitle }'); return false;"><spring:message code="label.useY"/></button>
								</c:when>
								<c:otherwise>
									<button class="btn_type01" style="height: 34px;" onClick="javascript:useUpdate('${surveyDomain.srvCode}','${surveyDomain.srvUse}','${surveyDomain.srvTitle }'); return false;"><spring:message code="label.useN"/></button>
									<%-- <a href="#" onClick="javascript:useUpdate('${surveyDomain.srvCode}','${surveyDomain.srvUse}','${surveyDomain.srvTitle }'); return false;"><spring:message code="label.useN"/></a> --%>
								</c:otherwise>
							</c:choose>
							</td>
							<td>
							<c:if test="${fn:substring(authBinaryNum, 0, 1) eq '1' }">
								<button class="btn_type01" onclick="javascript:deleteSurvey('${surveyDomain.srvCode}','${surveyDomain.srvTitle}'); return false;"><spring:message code="label.delete"/></button>
							</c:if>
							</td>
						</tr>
					<%-- </c:if> --%>
					</c:forEach>	
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="8">
								<spring:message code="label.no_data"/>
							</td>
						</tr>
					</c:otherwise>
					</c:choose>
					</c:if>
					</tbody>
				</table>
			</div>
			</div><!--research-list-->
			
				<form:form action="${pageContext.request.contextPath}/WAG001SurveySearch/init.do?menu=${menu}&tabId=${tabId}" modelAttribute="WAG001SurveySearchForm" name="WAG001SurveySearchForm" method="POST">
				<div class="gap20"></div>
				 <c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }">
					<c:if test="${fn:length(surveyList) > 0}">
						<div class="pagenation">
				            <smpl:seqpaging maxSeq="10" action='${pageContext.request.contextPath}/WAG001SurveySearch/init.do?tabId=${tabId}&menu=${menu}' formId="WAG001SurveySearchForm" />
				        </div>
				        <ai:pagingoption countPerPage="10" />
			        </c:if>
				</c:if>
				</form:form>
			</ul>
		</div><!--research-list-wrap-->
		