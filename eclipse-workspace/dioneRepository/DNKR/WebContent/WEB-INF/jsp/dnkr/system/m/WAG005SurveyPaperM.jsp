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
<%-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> --%>
<link type="text/css" rel="stylesheet" media="all" href="/css/m/content.css">

<script>
	function applysurvey(srvCode){
		location.href="/WAG005SurveyPaper/paperView.do?menu=${menu}&tabId=${tabId}&srvCode="+srvCode;
	}
</script>

<div class="sub_Toptit">설문조사</div>

<!-- container:S -->
<div id="research-Lst-container">
	<form:form action="${pageContext.request.contextPath}/WAG005SurveyPaper/init.do?menu=${menu}&tabId=${tabId }" modelAttribute="WAG001SurveySearchForm" name="WAG001SurveySearchForm" method="POST">
	<div class="subCont_wrap">
		<table class="boardLst tblleft">
			<caption>기본게시판</caption>
			<colgroup>
				<col class="">
				<col class="w40p">
			</colgroup>
			<thead>
				<tr>
					<th><spring:message code="label.title"/></th>
					<th><spring:message code="label.process"/></th>
				</tr>
			</thead>
			<tbody>
			<c:choose>
				<c:when test="${fn:length(surveyList) > 0}">
				<c:forEach var="surveyDomain" items="${surveyList}" varStatus="status">
					<jsp:useBean id="now" class="java.util.Date" />
					<fmt:parseDate value="${fn:substring(surveyDomain.srvStart,0,16) }" pattern="yyyy-MM-dd HH:mm" var="startDate" />
					<fmt:parseDate value="${fn:substring(surveyDomain.srvEnd,0,16) }" pattern="yyyy-MM-dd HH:mm" var="endDate" />
					 <fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm" var="nowDate" />    

					 
					<fmt:formatDate value="${startDate }" pattern="yyyy-MM-dd HH:mm" var="openDate"/>    
					<fmt:formatDate value="${endDate}" pattern="yyyy-MM-dd HH:mm" var="closeDate"/>
					<tr>
						<td class="left">
							<div class="tit-box">
								<c:choose>
									<c:when test="${surveyDomain.cnt > 0}">
										<a class="cont-tit" href="#n" onClick="javascript:alert('이미 입력완료하신 설문입니다.'); return false;">
											<c:choose>
												<c:when test="${fn:length(surveyDomain.srvTitle ) > 20}">
													${fn:substring(surveyDomain.srvTitle,0,20) }....
												</c:when>
												<c:otherwise>
													${surveyDomain.srvTitle}
												</c:otherwise>
											</c:choose> 
										</a>
									</div>
									</c:when>
									 <c:when test="${openDate > nowDate}">
									 	<a class="cont-tit" href="#n" onClick="javascript:alert('준비중인 설문입니다.'); return false;">
									 	<c:choose>
												<c:when test="${fn:length(surveyDomain.srvTitle ) > 20}">
													${fn:substring(surveyDomain.srvTitle,0,20) }....
												</c:when>
												<c:otherwise>
													${surveyDomain.srvTitle}
												</c:otherwise>
											</c:choose> 
										</a>
									</div>
									</c:when>
									<c:when test="${closeDate <= nowDate}">
										<a class="cont-tit" href="#n" onClick="javascript:alert('이미 종료된 설문입니다.'); return false;">
										<c:choose>
												<c:when test="${fn:length(surveyDomain.srvTitle ) > 20}">
													${fn:substring(surveyDomain.srvTitle,0,20) }....
												</c:when>
												<c:otherwise>
													${surveyDomain.srvTitle}
												</c:otherwise>
											</c:choose> 
										</a>
									</div>
									</c:when>  
									<c:otherwise>
										<a class="cont-tit" href="#n" onClick="javascript:applysurvey('${surveyDomain.srvCode}'); return false;">
										<c:choose>
												<c:when test="${fn:length(surveyDomain.srvTitle ) > 20}">
													${fn:substring(surveyDomain.srvTitle,0,20) }....
												</c:when>
												<c:otherwise>
													${surveyDomain.srvTitle}
												</c:otherwise>
											</c:choose> 
										</a>
										
									</div>
									<div class="icon">
										<span class="new"></span>
									</div>
									</c:otherwise>
								</c:choose>
							
						</td>
						<td class="date">
							${fn:substring(surveyDomain.srvStart,0,16) } <span class="Tbreak">~</span> ${fn:substring(surveyDomain.srvEnd,0,16) }
						</td>
					</tr>
				</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="2">
							<spring:message code="label.no_data"/>
						</td>
					</tr>
				</c:otherwise>
			</c:choose>
				<!-- <tr>
					<td class="left">
						<div class="tit-box">
							<a class="cont-tit" href="/WAG005SurveyPaper/paperView.do">새로운 사이트에 대한 설문입니다. </a>
						</div>
						<div class="icon">
							<span class="new"></span>
						</div>
					</td>
					<td class="date">2017.12.14 15:00 <span class="Tbreak">~</span> 2017.12.14 15:00</td>
				</tr>
				<tr>
					<td class="left">
						<div class="tit-box">
							<a class="cont-tit" href="/WAG005SurveyPaper/paperView.do">새로운 사이트에 대한 설문입니다. </a>
						</div>
						<div class="icon">
							<span class="new"></span>
						</div>
					</td>
					<td class="date">2017.12.14 15:00 <span class="Tbreak">~</span> 2017.12.14 15:00</td>
				</tr>
				<tr>
					<td class="left">
						<div class="tit-box">
							<a class="cont-tit" href="/WAG005SurveyPaper/paperView.do">새로운 사이트에 대한 설문입니다. </a>
						</div>
						<div class="icon">
							<span class="new"></span>
						</div>
					</td>
					<td class="date">2017.12.14 15:00 <span class="Tbreak">~</span> 2017.12.14 15:00</td>
				</tr>
				<tr>
					<td class="left">
						<div class="tit-box">
							<a class="cont-tit" href="/WAG005SurveyPaper/paperView.do">새로운 사이트에 대한 설문입니다. </a>
						</div>
						<div class="icon">
							<span class="new"></span>
						</div>
					</td>
					<td class="date">2017.12.14 15:00 <span class="Tbreak">~</span> 2017.12.14 15:00</td>
				</tr>
				<tr>
					<td class="left">
						<div class="tit-box">
							<a class="cont-tit" href="/WAG005SurveyPaper/paperView.do">새로운 사이트에 대한 설문입니다. </a>
						</div>
						<div class="icon">
							<span class="new"></span>
						</div>
					</td>
					<td class="date">2017.12.14 15:00 <span class="Tbreak">~</span> 2017.12.14 15:00</td>
				</tr>
				<tr>
					<td class="left">
						<div class="tit-box">
							<a class="cont-tit" href="/WAG005SurveyPaper/paperView.do">새로운 사이트에 대한 설문입니다. </a>
						</div>
						<div class="icon">
							<span class="new"></span>
						</div>
					</td>
					<td class="date">2017.12.14 15:00 <span class="Tbreak">~</span> 2017.12.14 15:00</td>
				</tr>
				<tr>
					<td class="left">
						<div class="tit-box">
							<a class="cont-tit" href="/WAG005SurveyPaper/paperView.do">새로운 사이트에 대한 설문입니다. </a>
						</div>
						<div class="icon">
							<span class="new"></span>
						</div>
					</td>
					<td class="date">2017.12.14 15:00 <span class="Tbreak">~</span> 2017.12.14 15:00</td>
				</tr>
				<tr>
					<td class="left">
						<div class="tit-box">
							<a class="cont-tit" href="/WAG005SurveyPaper/paperView.do">새로운 사이트에 대한 설문입니다. </a>
						</div>
						<div class="icon">
							<span class="new"></span>
						</div>
					</td>
					<td class="date">2017.12.14 15:00 <span class="Tbreak">~</span> 2017.12.14 15:00</td>
				</tr>
				<tr>
					<td class="left">
						<div class="tit-box">
							<a class="cont-tit" href="/WAG005SurveyPaper/paperView.do">새로운 사이트에 대한 설문입니다. </a>
						</div>
						<div class="icon">
							<span class="new"></span>
						</div>
					</td>
					<td class="date">2017.12.14 15:00 <span class="Tbreak">~</span> 2017.12.14 15:00</td>
				</tr>
				<tr>
					<td class="left">
						<div class="tit-box">
							<a class="cont-tit" href="/WAG005SurveyPaper/paperView.do">새로운 사이트에 대한 설문입니다. </a>
						</div>
						<div class="icon">
							<span class="new"></span>
						</div>
					</td>
					<td class="date">2017.12.14 15:00 <span class="Tbreak">~</span> 2017.12.14 15:00</td>
				</tr> -->
			</tbody>
		</table>
	</div>
	
	<!-- <div class="lst-num">
		<p class="num-icon"></p>
		<p class="num-box"><span class="num">1637</span>건</p>
	</div> -->
	<div class="sgap"></div>
	<c:if test="${fn:length(surveyList) > 0}">
		<div class="pagenation">
        	<smpl:seqpaging maxSeq="5" action='${pageContext.request.contextPath}/WAG005SurveyPaper/init.do?tabId=${tabId}&menu=${menu}' formId="WAG001SurveySearchForm" />
      	</div>
    	<ai:pagingoption countPerPage="5" />
    </c:if>
	<!-- <ul class="paging-wrap">
		<li><a href="#n" class="first BdBg">첫페이지로</a></li>
		<li><a href="#n" class="prev BdBg">이전 페이지로</a></li>
		<li><a href="#n" class="active">1</a></li>
		<li><a href="#n" title="2페이지로 이동합니다.">2</a></li>
		<li><a href="#n" title="3페이지로 이동합니다.">3</a></li>
		<li><a href="#n" title="4페이지로 이동합니다.">4</a></li>
		<li><a href="#n" title="5페이지로 이동합니다.">5</a></li>
		<li><a href="#n" class="next BdBg">다음페이지로</a></li>
		<li><a href="#n" class="last BdBg">마지막페이지로</a></li>
	</ul> -->
	
	<div class="gap"></div>



	</form:form>
 </div>


 <!-- container:E -->
