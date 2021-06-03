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
<link rel="stylesheet" media="all" href="/css/content.css"/>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/project/WAK008PersonalDetail.js?ver=2"></script>
<style>
.chart1, .chart2 {
	width: 48%;
	display: inline-block;
}
/* 
.chart1 {
	margin-right: calc(100% - 97.5%);;
} */
</style>

<!-- 개인별 상세통계 차트부분  -->
<c:if test="${fn:length(pjtList) > 0}">
<script type="text/javascript">
	var works = [];
	var chartTitle = "";
	works.push(['Task', 'Hours per Day']);
	
	<c:if test="${fn:length(pjtList) > 0}">
		
			<c:if test="${empty workType or workType eq 'L'}">
				//chartTitle = "업무분류(대)";
				chartTitle = LN_WORK_L;
				<c:forEach var="pjtDomain" items="${pjtList}" varStatus="status">
					works.push([ "${pjtDomain.workLTypeNm}", ${pjtDomain.workHour}]);
				</c:forEach>
			</c:if>
			<c:if test="${workType eq 'M'}">
				//chartTitle = "업무분류(중)";
				chartTitle = LN_WORK_M;
				<c:forEach var="pjtDomain" items="${pjtList}" varStatus="status">
					works.push([ "${pjtDomain.workMTypeNm}", ${pjtDomain.workHour}]);
				</c:forEach>
			</c:if>
			<c:if test="${workType eq 'S'}">
				//chartTitle = "업무분류(소)";
				chartTitle = LN_WORK_S;
				<c:forEach var="pjtDomain" items="${pjtList}" varStatus="status">
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
</c:if>

<!-- 소속팀 평균 차트부분  -->
<c:if test="${fn:length(teamPjtList) > 0}">
<script type="text/javascript">
	var works2 = [];
	var chartTitle2 = "";
	works2.push(['Task', 'Hours per Day']);
	
	<c:if test="${fn:length(teamPjtList) > 0}">
		
			<c:if test="${empty workType or workType eq 'L'}">
				//chartTitle = "업무분류(대)";
				chartTitle2 = LN_WORK_L;
				<c:forEach var="pjtTeamDomain" items="${teamPjtList}" varStatus="status">
				works2.push([ "${pjtTeamDomain.workLTypeNm}", ${pjtTeamDomain.workHour}]);
				</c:forEach>
			</c:if>
			<c:if test="${workType eq 'M'}">
				//chartTitle2 = "업무분류(중)";
				chartTitle2 = LN_WORK_M;
				<c:forEach var="pjtTeamDomain" items="${teamPjtList}" varStatus="status">
				works2.push([ "${pjtTeamDomain.workMTypeNm}", ${pjtTeamDomain.workHour}]);
				</c:forEach>
			</c:if>
			<c:if test="${workType eq 'S'}">
				chartTitle2 = "업무분류(소)";
				<c:forEach var="pjtTeamDomain" items="${teamPjtList}" varStatus="status">
				works2.push([ "${pjtTeamDomain.workTypeNm}", ${pjtTeamDomain.workHour}]);
				</c:forEach>
			</c:if>
			<c:if test="${workType eq 'REL_SYS'}">
				//chartTitle2 = "관련시스템";
				chartTitle2 = LN_REL_SYS;
				<c:forEach var="pjtTeamDomain" items="${teamPjtList}" varStatus="status">
				works2.push([ "${fn:trim(pjtTeamDomain.relSys)}", ${pjtTeamDomain.workHour}]);
				</c:forEach>
			</c:if>
		
		
		
		$(function(){
			
			if(works2.length > 1) {
				google.charts.load('current', {'packages':['corechart']});
				google.charts.setOnLoadCallback(drawChart2);
				
					
			}
		});
		
	</c:if>
		
		function drawChart2() {
			//console.log('drawChart()');
			var data = google.visualization.arrayToDataTable(
					works2		
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
			  title: chartTitle2,
			  width: 800,
			  height: 350,
			};
			
			var chart2 = new google.visualization.PieChart(document.getElementById('piechart2'));
			
			chart2.draw(data, options);
		}
	</script>
</c:if>
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%--조회권한 --%>
	<div class="board-list-wrap pjt-wrap">
		<form:form action="${pageContext.request.contextPath}/WAK008PersonalDetailSearch/init.do?tabId=${tabId}" modelAttribute="pjtDomain" method="POST" name="pjtDomain" id="pjtDomain">
			<div class="list-top">
				<div class="pr20" id="searchBoxDiv">
					
					<div class="dropdown">
						<span class="calendar_icon vcen2"></span>
						<form:input autofocus="true" type="text" class="dropbtn boxform tc w90px calendar_input" path="startDate" id="startDate" value="${startDate}"/>
						<div class="dropdown-menu" role="menu"  id="calendar-personalDetail" style="width:250px;
						           border:1px solid #ccc;
						           border-radius: 5px;
						           padding: 5px;
						           overflow: hidden;" >
						</div>
					</div>
					~
					<div class="dropdown">
						<span class="calendar_icon vcen2"></span>
						<form:input type="text" class="dropbtn boxform tc w90px calendar_input" path="endDate" id="endDate" value="${endDate}"/>
					</div>
				
					<span class="pr5" style="margin-left:30px"></span>
					
					<%-- 
					<!-- 사업부 구분삭제 - 180831 -->
					<!-- 사업부를 선택해주세요 -->
					<select class="clsCode" id="clsCode" style="width:99.2px" name=clsCode title="<spring:message code='DNKR-I0-0000'/>">
						<option value="">
							<spring:message code='label.cls_total'/><!-- 사업부전체 -->
						</option>
						<c:if test="${fn:length(clsList) > 0}">
							<c:forEach var="clsDomain" items="${clsList}" varStatus="status">
								<!-- <option>사업부전체</option> -->
								<option value="${clsDomain.relationCode}"
									<c:if test="${clsDomain.relationCode eq paraEmpDomain.clsCode}">
										selected
									</c:if>
								><c:out value="${clsDomain.relationName}"/></option>
							</c:forEach>
						</c:if>
					</select>
					 --%>
					
					<!-- 사업장을 선택해주세요 -->
					<select class="locCode" id="locCode" style="width:99.2px" name="locCode" title="<spring:message code='DNKR-I0-0001'/>">
						<option value="">
							<spring:message code='label.loc_total'/><!-- 사업장전체 -->
						</option>
						<c:if test="${fn:length(locList) > 0}">
							<c:forEach var="locDomain" items="${locList}" varStatus="status">
								<!-- <option>사업부전체</option> -->
								<option value="${locDomain.relationCode}"
									<c:if test="${locDomain.relationCode eq paraEmpDomain.locCode}">
										selected
									</c:if>
								><c:out value="${locDomain.relationName}"/></option>
							</c:forEach>
						</c:if>
					</select>
					
					<!-- 부서(팀)를 선택해주세요  -->
					<select class="teamCode" id="teamCode" style="width:252.8px" name="teamCode" title="<spring:message code='DNKR-I0-0002'/>">
						<option value="">
							<spring:message code='label.team_total'/><!-- 부서(팀)전체 -->
						</option>
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
					
					<!-- 성명을 선택해주세요 -->
					<select class="empNumber" id="empNumber" style="width:79.8px" name="empNumber" title="<spring:message code='DNKR-I0-0005'/>">
						<option value="">
							<spring:message code='label.person_name'/><!-- 성명 -->
						</option>
						<c:if test="${fn:length(empList) > 0}">
							<c:forEach var="empDomain" items="${empList}" varStatus="status">
								<!-- <option>사업부전체</option> -->
								<option value="${empDomain.empNumber}"
									<c:if test="${empDomain.empNumber eq paraEmpDomain.empNumber}">
										selected
									</c:if>
								><c:out value="${empDomain.empName}"/></option>
							</c:forEach>
						</c:if>
					</select>
					<input type="hidden" id="workType" name="workType" value="L"/>
					<button type="button" class="AXButton Black _searchBtn_" onclick="">
						<!-- <i class="axi axi-ion-android-search"></i> -->
						<spring:message code='label.search'/>
					</button>
					
				</div><!-- pr20 -->
				<div class="gap10"></div>
				<c:choose>
					<c:when test="${paraEmpDomain eq null}">
						<div class="fl" style="padding-top: 15px; padding-bottom:5px;"><span style="color:red;">조회할 사원을 선택하세요</span></div>
					</c:when>
					<c:when test="${teamCheck ne null}">
						<div class="fl" style="padding-top: 15px;"><span style="color:red;">같은 팀원만 조회가능합니다.</span></div>
					</c:when>
					
					<c:when test="${fn:length(pjtList) <= 0}">
						<div class="fl" style="padding-top: 15px;"><span style="color:red;"><spring:message code='label.no_data'/><!-- 데이터가 없습니다. --></span></div>
					</c:when>
				</c:choose>
				<div class="fr">
					<ul class="pj-smtab">
						<li 
							<c:choose>
								<c:when test="${empty workType or workType eq 'L'}">
									class="over"
								</c:when>
								<c:otherwise>
									class="first"
								</c:otherwise>
							</c:choose>
						><a href="javascript:void(0);" data-click="L"><span data-click="L"><spring:message code='label.WAK001.list5'/></span></a></li>
						<li
							<c:if test="${workType eq 'M'}">
								class="over"
							</c:if>
						><a href="javascript:void(0);" data-click="M"><span data-click="M"><spring:message code='label.WAK001.list6'/></span></a></li>
						<li
							<c:if test="${workType eq 'S'}">
								class="over"
							</c:if>
						><a href="javascript:void(0);" data-click="S"><span data-click="S"><spring:message code='label.WAK001.list7'/></span></a></li>
						<li  
							<c:if test="${workType eq 'REL_SYS'}">
								class="over"
							</c:if>
						><a href="javascript:void(0);" data-click="REL_SYS"><span data-click="REL_SYS"><spring:message code='label.WAK001.list8'/></span></a></li>
					</ul>
				</div>
			</div><!-- list-top -->
		</form:form>	
		<div class="gap10"></div>
		<span class="top-border"></span>
		<div class="gap20"></div>
		<div class="cont_gp">
			<div class="chart1">
				<p class="tit"><spring:message code="label.WAK008.name"/><!-- 개인별상세통계 --></p>
				<div class="gp-wrap">
					<div id="piechart" style="width: 90%; height: 100%;"></div>
				</div>
			</div>
			<div class="chart2 fr">
				<p class="tit"><spring:message code="label.teamAvg"/><!-- 소속팀 평균 --></p>
				<div class="gp-wrap">
					<div id="piechart2" style="width: 90%; height: 100%;"></div>
				</div>
			</div>
		</div>
	</div><!-- board-list-wrap  -->
</c:if>
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '0' }"><%--조회권한 --%>
	<div>
		<span><spring:message code='DNKR-E2-0000'/><!-- 권한이 없습니다. --></span>
	</div>
</c:if>