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
<link rel="stylesheet" media="all" href="/css/board.css"/>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<script>
	function applysurvey(srvCode){
		location.href="/WAG005SurveyPaper/paperView.do?menu=${menu}&tabId=${tabId}&srvCode="+srvCode;
	}
</script>


<div class="research-list-wrap">
			<div class="research-top">
			<form:form action="${pageContext.request.contextPath}/WAG005SurveyPaper/init.do?menu=${menu}&tabId=${tabId }" modelAttribute="WAG001SurveySearchForm" name="WAG001SurveySearchForm" method="POST">
				<table>
						<colgroup>
							<col width="12%">
							<col width="*%">
							
						</colgroup>
						<tbody>
						<tr>
								<th class="tl stit"><spring:message code="label.WAG001.title"/></th>
								<td>
									<input autofocus="true" class="research-tit" type="text" name="srvTitle" title="설문제목을 입력해주세요" value="${form.srvTitle }"></input>
								</td>
						</tr>		
						<tr>
								<th class="tl stit"><spring:message code="label.WAG001.startDate"/></th>
								<td>
									<div class="st-date">
									
									<c:choose>
										<c:when test="${form.srvStart ne null }">
											<c:set var="startDate">${fn:split(form.srvStart,' ')[0] }</c:set>
											<c:set var="endDate">${fn:split(form.srvEnd,' ')[0] }</c:set>
											<c:set var="startTime">${fn:split(form.srvStart,' ')[1] }</c:set>
											<c:set var="endTime">${fn:split(form.srvEnd,' ')[1] }</c:set>
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
										<%-- <select name="startH" title="날짜를 선택해주세요">
											<c:forEach begin="0" end="23" varStatus="i">
												<option value="${i.index }" <c:if test="${fn:split(startTime,':')[0] eq i.index }">selected</c:if>>${i.index }&nbsp; <spring:message code="label.WAG001.hour"/></option>
											</c:forEach>
										</select>
										<select name="startI" title="날짜를 선택해주세요">
											<c:forEach begin="0" end="50" step="10" varStatus="i">
												<option value="${i.index }" <c:if test="${fn:split(startTime,':')[1] eq i.index }">selected</c:if>>${i.index } &nbsp;<spring:message code="label.WAG001.minute"/></option>
											</c:forEach>
										</select> --%>
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
										<%-- <select name="endH" title="날짜를 선택해주세요">
											<c:forEach begin="0" end="23" varStatus="i">
												<option value="${i.index }" <c:if test="${fn:split(endTime,':')[0] eq i.index }">selected</c:if>>${i.index } &nbsp;<spring:message code="label.WAG001.hour"/></option>
											</c:forEach>
										</select>
										<select name="endI" title="날짜를 선택해주세요">
											<c:forEach begin="0" end="50" step="10" varStatus="i">
												<option value="${i.index }" <c:if test="${fn:split(endTime,':')[1] eq i.index }">selected</c:if>>${i.index } &nbsp;<spring:message code="label.WAG001.minute"/></option>
											</c:forEach>
										</select> --%>
									<div style="float:right;margin-right:45px;">
										<button type="submit" class="AXButton Black _searchBtn_" style="width:80px;">
											<i class="axi axi-ion-android-search"></i>
											<spring:message code='label.search'/>
										</button>
									</div>	
									</div><!--end-date-->
									
								</td>
							</tr> 
					</tbody>
				</table>
			</div> <!--research-top-->
			<div class="gap20"></div>
			<div class="research-list">
				<span class="top-border"></span>
				<table>
					<caption></caption>
					<colgroup>
						
						<col scope="col" width="5%">
						<col scope="col" width="38%">
						<col scope="col" width="*">
						<col scope="col" width="15%">
					</colgroup>
					<thead>
						<tr>
							
							<th><spring:message code="label.number"/></th>
							<th><spring:message code="label.title"/></th>
							<th><spring:message code="label.process"/></th>
							<th><spring:message code="label.apply"/></th>
							
						</tr>
					</thead>
					<tbody>
					<c:choose>
					<c:when test="${fn:length(surveyList) > 0}">
					<c:forEach var="surveyDomain" items="${surveyList}" varStatus="status">
						<tr>
							
							<td>${surveyDomain.rowNum }</td>
							<td>
								<jsp:useBean id="now" class="java.util.Date" />
								<fmt:parseDate value="${fn:substring(surveyDomain.srvStart,0,16) }" pattern="yyyy-MM-dd HH:mm" var="startDate" />
								<fmt:parseDate value="${fn:substring(surveyDomain.srvEnd,0,16) }" pattern="yyyy-MM-dd HH:mm" var="endDate" />
								 <fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm" var="nowDate" />    
	
								 
								<fmt:formatDate value="${startDate }" pattern="yyyy-MM-dd HH:mm" var="openDate"/>    
								<fmt:formatDate value="${endDate}" pattern="yyyy-MM-dd HH:mm" var="closeDate"/>
								<c:choose>
									<c:when test="${fn:length(surveyDomain.srvTitle ) > 20}">
										<c:choose>
											<c:when test="${surveyDomain.cnt > 0}">
												<a href="#" class="add-bnt" onClick="javascript:toastMsg('이미 입력완료하신 설문입니다.'); return false;">
													${fn:substring(surveyDomain.srvTitle,0,20) }....
												</a>
											</c:when>
										 	<c:when test="${openDate > nowDate}">
												<a href="#" class="add-bnt blue" onClick="javascript:toastMsg('준비중인 설문입니다.'); return false;" style="width:110px;">
													${fn:substring(surveyDomain.srvTitle,0,20) }....
												</a>
											</c:when>
											<c:when test="${closeDate <= nowDate}">
												<a href="#" class="add-bnt blue" onClick="javascript:toastMsg('이미 종료된 설문입니다.'); return false;" style="width:110px;">
													${fn:substring(surveyDomain.srvTitle,0,20) }....
												</a>
											</c:when>  
											<c:otherwise>
												<a href="#" class="add-bnt red" onClick="javascript:applysurvey('${surveyDomain.srvCode}'); return false;" style="width:110px;">
													${fn:substring(surveyDomain.srvTitle,0,20) }....
												</a>
											</c:otherwise>
										</c:choose>
									</c:when>
									<c:otherwise>
										<c:choose>
											<c:when test="${surveyDomain.cnt > 0}">
												<a href="#" class="add-bnt" onClick="javascript:toastMsg('이미 입력완료하신 설문입니다.'); return false;">
													${surveyDomain.srvTitle}
												</a>
											</c:when>
											 <c:when test="${openDate > nowDate}">
												<a href="#" class="add-bnt blue" onClick="javascript:toastMsg('준비중인 설문입니다.'); return false;" style="width:110px;">
													${surveyDomain.srvTitle}
												</a>
											</c:when>
											<c:when test="${closeDate <= nowDate}">
												<a href="#" class="add-bnt blue" onClick="javascript:toastMsg('이미 종료된 설문입니다.'); return false;" style="width:110px;">
													${surveyDomain.srvTitle}
												</a>
											</c:when>  
											<c:otherwise>
												<a href="#" class="add-bnt red" onClick="javascript:applysurvey('${surveyDomain.srvCode}'); return false;" style="width:110px;">
													${surveyDomain.srvTitle}
												</a>
											</c:otherwise>
										</c:choose>
									</c:otherwise>
								</c:choose>
							
							
							</td>
							<td>${fn:substring(surveyDomain.srvStart,0,16) } ~<br> ${fn:substring(surveyDomain.srvEnd,0,16) }</td>
							<td>
								<c:choose>
									<c:when test="${surveyDomain.cnt > 0}">
										
										<button class="add-bnt" onClick="javascript:alert('이미 입력완료하신 설문입니다.'); return false;">
											<span><spring:message code="label.WAK004.list6"/></span>
										</button>
									</c:when>
									 <c:when test="${openDate > nowDate}">
										<button class="add-bnt blue" onClick="javascript:alert('준비중인 설문입니다.'); return false;" style="width:110px;">
											<span><spring:message code="label.WAG001.surveyReady"/></span>
										</button>
									</c:when>
									<c:when test="${closeDate <= nowDate}">
										<button class="add-bnt blue" onClick="javascript:alert('이미 종료된 설문입니다.'); return false;" style="width:110px;">
											<span><spring:message code="label.WAG001.end"/></span>
										</button>
									</c:when>  
									<c:otherwise>
										<button class="add-bnt red" onClick="javascript:applysurvey('${surveyDomain.srvCode}'); return false;" style="width:110px;">
											<span><spring:message code="label.apply"/></span>
										</button>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
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
					</tbody>
				</table>
			</div><!--research-list-->
				
				<div class="gap20"></div>
				
				
				
				<div class="gap20"></div>
					<c:if test="${fn:length(surveyList) > 0}">
						<div class="pagenation">
				            <smpl:seqpaging maxSeq="10" action='${pageContext.request.contextPath}/WAG005SurveyPaper/init.do?tabId=${tabId}&menu=${menu}' formId="WAG001SurveySearchForm" />
				        </div>
				        <ai:pagingoption countPerPage="10" />
			        </c:if>
				</form:form>
				
		</div><!--research-list-wrap-->