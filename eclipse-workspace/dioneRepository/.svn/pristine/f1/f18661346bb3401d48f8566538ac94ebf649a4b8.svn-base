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
<spring:message var="errormessage_tel" code="SMPL-E8-0004" />

<link rel="stylesheet" media="all" href="/css/board.css"/>
<link rel="stylesheet" media="all" href="/css/content.css"/>
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/project/WAK003PjtStats.js"></script>
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
					works.push([ "${pjtDomain.relSys}", ${pjtDomain.workHour}]);
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
			  width: 500,
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
				//chartTitle2 = "업무분류(소)";
				chartTitle2 = LN_WORK_S;
				<c:forEach var="pjtTeamDomain" items="${teamPjtList}" varStatus="status">
					works2.push([ "${pjtTeamDomain.workTypeNm}", ${pjtTeamDomain.workHour}]);
				</c:forEach>
			</c:if>
			<c:if test="${workType eq 'REL_SYS'}">
				//chartTitle2 = "관련시스템";
				chartTitle2 = LN_REL_SYS;
				<c:forEach var="pjtTeamDomain" items="${teamPjtList}" varStatus="status">
					works2.push([ "${pjtTeamDomain.relSys}", ${pjtTeamDomain.workHour}]);
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
			//console.log('drawChart2()');
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
			  width: 500,
			  height: 350,
			};
			
			var chart2 = new google.visualization.PieChart(document.getElementById('piechart2'));
			
			chart2.draw(data, options);
		}
	</script>
</c:if>

<div class="board-bList-wrap pjt-wrap">
	<form:form action="${pageContext.request.contextPath}/WAK003PjtStatsSearch/init.do?tabId=${tabId}&menu=${menu}" modelAttribute="pjtDomain" method="POST" name="pjtDomain" id="pjtDomain">
		<div class="list-top">
		<div class="pr20"> 
			<div class="dropdown">
				<span class="calendar_icon vcen2"></span>
				<form:input type="text" class="dropbtn boxform tc w90px calendar_input" path="startDate" id="startDate"/>
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
			
			<input type="hidden" id="workType" name="workType" value="L"/>
			<button type="button" class="AXButton Black _searchBtn_" onclick="">
				<!-- <i class="axi axi-ion-android-search"></i> -->
				<spring:message code='label.search'/>
			</button>
			
		</div><!-- pr20 -->
		<div class="gap10"></div>
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
				><a href="javascript:void(0);" data-click="L"><span data-click="L"><spring:message code="label.WAK001.list5"/><!-- 업무분류(대) --></span></a></li>
				<li
					<c:if test="${workType eq 'M'}">
						class="over"
					</c:if>
				><a href="javascript:void(0);" data-click="M"><span data-click="M"><spring:message code="label.WAK001.list6"/><!-- 업무분류(중) --></span></a></li>
				<li
					<c:if test="${workType eq 'S'}">
						class="over"
					</c:if>
				><a href="javascript:void(0);" data-click="S"><span data-click="S"><spring:message code="label.WAK001.list7"/><!-- 업무분류(소) --></span></a></li>
				<li 
					<c:if test="${workType eq 'REL_SYS'}">
						class="over"
					</c:if>
				><a href="javascript:void(0);" data-click="REL_SYS"><span data-click="REL_SYS"><spring:message code="label.WAK001.list8"/><!-- 관련시스템  --></span></a></li>
			</ul>
		</div>
	</div><!-- list-top -->
		<div class="gap20"></div>
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
		
		<!-- </form> -->
		<div class="gap20"></div>
		
		<div class="fl">
			<button type="button" onclick="javascript:location.href='${pageContext.request.contextPath}/WAK000PjtSearch/init.do?tabId=<c:out value="${tabId}"></c:out>&menu=<c:out value="${menu}"></c:out>'" class="gray" name="Cancel">				
				<spring:message code="label.back" /><!-- 뒤로가기 -->
			</button>
		</div>
	</form:form>
</div><!--board-view-wrap-->