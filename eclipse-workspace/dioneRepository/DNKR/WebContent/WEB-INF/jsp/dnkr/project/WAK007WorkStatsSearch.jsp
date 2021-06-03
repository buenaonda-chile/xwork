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
<%-- <spring:message code="label.filename" /> : <c:out value="${url }"></c:out> --%>
<spring:message var="errormessage_tel" code="SMPL-E8-0004" />

<link rel="stylesheet" media="all" href="/css/board.css"/>
<link rel="stylesheet" media="all" href="/css/content.css"/>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/project/WAK007WorkStats.js?ver=2"></script>
<script type="text/javascript">
	var works = [];
	var chartTitle = "";
	works.push(['Task', 'Hours per Day']);
	
	<c:if test="${fn:length(pjtChartDatas) > 0}">
		
			<c:if test="${empty workType or workType eq 'L'}">
				chartTitle = "<spring:message code='label.WAK001.list5'/>";
				<c:forEach var="pjtDomain" items="${pjtChartDatas}" varStatus="status">
					works.push([ "${pjtDomain.workLTypeNm}", ${pjtDomain.workHour}]);
				</c:forEach>
			</c:if>
			<c:if test="${workType eq 'M'}">
				chartTitle = "<spring:message code='label.WAK001.list5'/>";
				<c:forEach var="pjtDomain" items="${pjtChartDatas}" varStatus="status">
					works.push([ "${pjtDomain.workMTypeNm}", ${pjtDomain.workHour}]);
				</c:forEach>
			</c:if>
			<c:if test="${workType eq 'S'}">
			chartTitle = "<spring:message code='label.WAK001.list5'/>";
				<c:forEach var="pjtDomain" items="${pjtChartDatas}" varStatus="status">
					works.push([ "${pjtDomain.workTypeNm}", ${pjtDomain.workHour}]);
				</c:forEach>
			</c:if>
			<c:if test="${workType eq 'REL_SYS'}">
				//chartTitle = "관련시스템";
				chartTitle = LN_REL_SYS;
				<c:forEach var="pjtDomain" items="${pjtList}" varStatus="status">
					works.push([ "${fn:trim(pjtDomain.relSys)}", ${pjtDomain.workHour}]);
				</c:forEach>
			</c:if>
		
		
		
		$(function(){
			
			if(works.length > 1) {
				google.charts.load('current', {'packages':['corechart']});
				google.charts.setOnLoadCallback(drawChart);
				
					
			}
		});
		
	</c:if>
		
		function drawChart() {
			//console.log('drawChart()');
			var data = google.visualization.arrayToDataTable(
				works		
			); 
			/* var data = google.visualization.arrayToDataTable([
			  ['Task', 'Hours per Day'],
			  ['Work',     11],
			  ['Eat',      2],
			  ['Commute',  2],
			  ['Watch TV', 2],
			  ['Sleep',    7]
			]); */
			
			var options = {
			  title: chartTitle,
			  width: 800,
			  height: 350,
			};
			
			var chart = new google.visualization.PieChart(document.getElementById('piechart'));
			
		    chart.draw(data, options);
		}
	
</script>
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%--조회권한 --%>
	<div class="board-bList-wrap pjt-wrap">
		<form:form action="${pageContext.request.contextPath}/WAK007WorkStatsSearch/search.do?tabId=${tabId}" modelAttribute="pjtSearchForm" method="POST" id="pjtSearchForm">
			<div class="list-top">
				<div class="pr20" id="searchDataBox">
					
					<div class="dropdown">
						<span class="calendar_icon vcen2"></span>
						<form:input autofocus="true" type="text" class="dropbtn boxform tc w90px calendar_input" path="startDate" id="startDate"/>
						<div class="dropdown-menu" role="menu"  id="calendar-workStats" style="width:250px;
						           border:1px solid #ccc;
						           border-radius: 5px;
						           padding: 5px;
						           overflow: hidden;" >
						</div>
					</div>
					~
					<div class="dropdown">
						<span class="calendar_icon vcen2"></span>
						<form:input type="text" class="dropbtn boxform tc w90px calendar_input" path="endDate" id="endDate"/>
					</div>
					
					
					
					<%--
					<!-- 소속팀원만 조회 가능으로 선택박스 필요없어짐 180222  -->
					<span class="pr5" style="margin-left:30px">분류</span>
						<select class="clsCode" id="clsCode" name=clsCode title=""사업부를 선택해주세요">
							<option value="">사업부전체</option>
							<c:if test="${fn:length(clsList) > 0}">
								<c:forEach var="clsDomain" items="${clsList}" varStatus="status">
									<option value="${clsDomain.relationCode}"
										<c:if test="${clsDomain.relationCode eq paraEmpDomain.clsCode}">
											selected
										</c:if>
									><c:out value="${clsDomain.relationName}"/></option>
								</c:forEach>
							</c:if>
						</select>
						<select class="locCode" id="locCode" name="locCode" title="사업장을 선택해주세요">
							<option>사업장전체</option>
							<c:if test="${fn:length(locList) > 0}">
								<c:forEach var="locDomain" items="${locList}" varStatus="status">
									<option onClick="setData('TEAM', '${locDomain.relationCode}')" value="${locDomain.relationCode}"
										<c:if test="${locDomain.relationCode eq paraEmpDomain.locCode}">
											selected
										</c:if>
									><c:out value="${locDomain.relationName}"/></option>
								</c:forEach>
							</c:if>
						</select>
						<select class="teamCode" id="teamCode" name="teamCode" title="부서(팀)를 선택해주세요">
							<option>부서(팀)전체</option>
							<c:if test="${fn:length(teamList) > 0}">
								<c:forEach var="teamDomain" items="${teamList}" varStatus="status">
									<!-- <option>사업부전체</option> -->
									<option value="${teamDomain.relationCode}"
										<c:if test="${teamDomain.relationCode eq paraEmpDomain.teamCode}">
											selected
										</c:if>
									><c:out value="${teamDomain.relationName}"/></option>
								</c:forEach>
							</c:if>
						</select>
						 --%>
						
						
					<input type="hidden" id="workType" name="workType" value="L"/>
					<button type="button" class="AXButton Black _searchBtn_" onclick="">
						<spring:message code='label.search'/>
					</button>
					
						<button type="button" class="xlsDown" onclick="downloadExcel('${workType}');">
							<span>엑셀 다운</span>
						</button>
		
			
				</div>
				
				<div class="sssgap"></div>
				<c:choose>
					<c:when test="${fn:length(pjtList) <= 0}">
						<div class="fl" style="padding-top: 15px; padding-bottom:5px;"><span style="color:red;"><spring:message code='label.no_data'/></span></div>
					</c:when>
				</c:choose>
				<div class="fr">
					<ul class="pj-smtab">
						<li 
							<%-- <c:if test="${(workType eq 'L' ) || (workType eq '')}"> --%>
							<%-- <c:if test="${workType eq 'L'}"> --%>
							<c:choose>
								<c:when test="${empty workType or workType eq 'L'}">
									class="over"
								</c:when>
								<c:otherwise>
									class="first"
								</c:otherwise>
							</c:choose>
						><a href="javascript:void(0);" data-click="L"><span data-click="L"><spring:message code='label.WAK001.list5'/></span></a>
						</li>
						<li
							<c:if test="${workType eq 'M'}">
								class="over"
							</c:if>
						><a href="javascript:void(0);" data-click="M"><span data-click="M"><spring:message code='label.WAK001.list6'/></span></a>
						</li>
						<li
							<c:if test="${workType eq 'S'}">
								class="over"
							</c:if>
						><a href="javascript:void(0);" data-click="S"><span data-click="S"><spring:message code='label.WAK001.list7'/></span></a>
						</li>
						<li  
							<c:if test="${workType eq 'REL_SYS'}">
								class="over"
							</c:if>
						><a href="javascript:void(0);" data-click="REL_SYS"><span data-click="REL_SYS"><spring:message code='label.WAK001.list8'/></span></a>
						</li>
					</ul>
				</div>
			</div><!--list-top-->
			
			<div class="gap10"></div>
			<div class="cont_gp thr">
				<div class="fl"  style="width: 100%">
				<!-- <div class="" style="margin:auto;width: 32%"> --><!-- 시간별 차트만 보일때  -->
					<p class="tit"><spring:message code='label.WAK007.list2'/></p>
					<div class="gp-wrap">
						<div id="piechart"></div>
						<!-- <div id="piechart"></div> -->
					</div>
				</div>
				<!-- <div class="fl">
					<p class="tit">미정일별</p>
					<div class="gp-wrap"></div>
				</div>
				<div class="fl last">
					<p class="tit">미정월별</p>
					<div class="gp-wrap"></div>
				</div> -->
			</div><!--cont-->
			<div class="gap20"></div>
			<span class="top-border"></span>
			<table>
				<caption></caption>
				<colgroup>
					<col scope="col" width="*">
					<col scope="col" width="*">
					<col scope="col" width="*">
					<col scope="col" width="*">
					<col scope="col" width="*">
					<col scope="col" width="*">
					<col scope="col" width="*">
					<col scope="col" width="*">
					<col scope="col" width="*">
				</colgroup>
				<thead>
					<tr>
						<th><spring:message code='label.number'/><!-- 번호 --></th>
						<th><spring:message code='label.WAK001.list5'/><!-- 업무분류(대) --></th>
						<th><spring:message code='label.WAK001.list6'/><!-- 업무분류(중) --></th>
						<th><spring:message code='label.WAK001.list7'/><!-- 업무분류(소) --></th>
						<th><spring:message code='label.WAK001.list8'/><!-- 관련시스템 --></th>
						<th><spring:message code='label.WAK004.list3'/><!-- 업무시간 --></th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${fn:length(pjtList) > 0}" >
							<c:forEach var="pjtDomain" items="${pjtList}" varStatus="status">
								<tr>
									<td><c:out value="${pjtDomain.rowNum}"/></td>
									<td><!-- 일반업무 --><c:out value="${pjtDomain.workLTypeNm}"/></td>
									<td><!-- 정기업무 --><c:out value="${pjtDomain.workMTypeNm}"/></td>
									<td><!-- 업무일지작성 --><c:out value="${pjtDomain.workTypeNm}"/></td>
									<td><!-- 업무일지작성 --><c:out value="${pjtDomain.relSys}"/></td>
									<td><!-- 10 -->
										<c:choose>
											<c:when test="${(pjtDomain.workHour mod 60) eq 0}">
												<fmt:parseNumber integerOnly="true" value="${pjtDomain.workHour/60}"/>
												: 0
											</c:when>
											<c:when test="${(pjtDomain.workHour mod 60) ne 0 && (pjtDomain.workHour/60)>0}">
												<fmt:parseNumber integerOnly="true" value="${pjtDomain.workHour/60}"/>
												:
												<fmt:parseNumber integerOnly="true" value="${pjtDomain.workHour mod 60}"/>
											</c:when>
											<c:otherwise>
												0
												:
												<fmt:parseNumber integerOnly="true" value="${pjtDomain.workHour}"/>
											</c:otherwise>
										</c:choose>
									</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:when test="${pjtCount > 0}">
							<td colspan="6">
								<spring:message code='label.WAK007.list3'/>
							</td>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="6">
									<spring:message code='label.no_data'/>
								</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
			<div class="gap20"></div>
			
			<c:if test="${fn:length(pjtList) > 0}">
				<div class="pagenation">
		            <smpl:seqpaging maxSeq="3" action="${pageContext.request.contextPath}/WAK007WorkStatsSearch/search.do?tabId=${tabId}" formId="pjtDomain" />
		        </div>
		        <ai:pagingoption countPerPage="10" />
	        </c:if>

		</form:form>
	</div><!--board-view-wrap-->
</c:if>
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '0' }"><%--조회권한 --%>
	<div>
		<span><spring:message code='DNKR-E2-0000'/><!-- 권한이 없습니다. --></span>
	</div>
</c:if>