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

<%-- <spring:message code="label.filename" /> : <c:out value="${url }"></c:out> --%>

<link rel="stylesheet" media="all" href="/css/board.css"/>
<link rel="stylesheet" media="all" href="/css/content.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/project/WAK004PjtRegStatus.js"></script>
<!-- <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script> -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/gstaticLoader.js"></script>
<script type="text/javascript">	

var empList = [];
var hourList = [];
var barHight = 100;
empList[0] = "";
hourList[0] = "Hour";

<c:if test="${fn:length(pjtList) > 0}">
	
		<c:forEach var="pjtDomain" items="${pjtList}" varStatus="status">
				empList[${status.index + 1}] = "${pjtDomain.empName}";
				hourList[${status.index + 1}] = <fmt:parseNumber integerOnly="true" value="${pjtDomain.workHour/60}"/>;
		</c:forEach>
		
		console.log("empList:" + empList);
		console.log("hourList:" + hourList);
		if (empList.length > 1 && empList.length <4 ){
			console.log("11");
			/* console.log((empList.length - 1) * 5); */
			
			barHight = ((empList.length - 1) * 80);
			/* $('#barchart_material').css('height', ((empList.length - 1) * 5) + 'px' );
			$('#barchart_material').css('height', '5px' ); */
		} else if (empList.length >= 4){
			console.log("22");
			barHight = ((empList.length - 1) * 60);
		
		} else {
			console.log("33");
			barHight = 250;
		}
		
</c:if>

function drawChart() {
    var data = google.visualization.arrayToDataTable([
      empList,
      hourList
      /* ['', 'Sales', 'Expenses', 'Profit', 'aa'],
      ['Hour', 2, 4, 2, 8], */
    ]);
    
    var options = {
        chart: {
        	title: '',
          	/* subtitle: 'Sales, Expenses, and Profit: 2014-2017', */
        },
        chartArea:{left:20,top:30,width:'100%',height:'100%'},
        bars: 'horizontal', // Required for Material Bar Charts.
        hAxis: {title: "Hour",
        		gridlines: {color: '#333', count: 8}	
        },
        lineWidth: 4,
        axes: {
             x: {
                distance: {label: 'parsecs', lineWidth:4}, // Bottom x-axis.
                brightness: {side: 'bottom', label: 'apparent magnitude'}, // Top x-axis.
                
            } 
        },
        'width': 500, 
        'height': barHight,
        'margin': 'auto',
        
        /* vAxis: { gridlines: { count: 8 } }, */
       
      };

      var chart = new google.charts.Bar(document.getElementById('barchart_material'));

      chart.draw(data, google.charts.Bar.convertOptions(options));
}

$(function(){
	if(hourList.length > 1) {
		google.charts.load('current', {'packages':['bar']});
		google.charts.setOnLoadCallback(drawChart);
		
			
	}
})


	
</script>


<style>
.pjt-wrap .dropdown .dropbtn {
	padding-left: 30px;
    width: 120px;
}

.project02_wrap .list-top ._searchBtn_ {
    background: url(/img/content/check_icon.png) no-repeat 8px center #1e1e1e;
    padding-left: 30px;
}

.gp-wrap {
	margin: auto;
}
</style>
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%--조회권한 --%>
	<div class="board-bList-wrap pjt-wrap project02_wrap">
		<form:form action="${pageContext.request.contextPath}/WAK004PjtRegStatusSearch/search.do?tabId=${tabId}" modelAttribute="empDomain"  method="POST" name="empDomain"  id="empDomain">
			<div class="list-top">
				
					<div class="dropdown">
						<span class="calendar_icon vcen2"></span>
						<input autofocus="true" type="text" value="<c:out value="${searchDate}"/>" class="dropbtn" name="searchDate" id="searchDate"/>
						<div class="dropdown-menu" role="menu"  id="calendar-target" style="width:250px;
						           border:1px solid #ccc;
						           border-radius: 5px;
						           padding: 5px;
						           overflow: hidden;" >
						</div>
					</div>
					
					<button type="button" class="AXButton Black _searchBtn_" onclick="">
						<!-- <i class="axi axi-ion-android-search"></i> -->
						<spring:message code='label.search'/>
					</button>
				
			</div>
			
			<div class="gap10"></div>
			<div class="cont">
				<div class="contL fl board-bList-wrap">
					<span class="top-border"></span>
					<table>
						<caption></caption>
						<colgroup>
							<col scope="col" width="25%">
							<col scope="col" width="25%">
							<col scope="col" width="25%">
							<col scope="col" width="25%">
						</colgroup>
						<thead>
							<tr>
								<th>
									<spring:message code="label.WAK004.list1"/>
								</th>
								<th>
									<spring:message code="label.WAK004.list2"/>
								</th>
								<th>
									<spring:message code="label.WAK004.list3"/>
								</th>
								<th>
									<spring:message code="label.WAK004.list4"/>
								</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${fn:length(pjtList) > 0}">
									<c:forEach var="pjtDomain" items="${pjtList}" varStatus="status">
										<tr>
											<td><c:out value="${pjtDomain.workDate}"/></td>
											<td><c:out value="${pjtDomain.empName}"/></td>
											<td>
												<c:choose>
													<c:when test="${(pjtDomain.workHour mod 60) eq 0}">
														<fmt:parseNumber integerOnly="true" value="${pjtDomain.workHour/60}"/>
														/0
													</c:when>
													<c:when test="${(pjtDomain.workHour mod 60) ne 0 && (pjtDomain.workHour/60)>0}">
														<fmt:parseNumber integerOnly="true" value="${pjtDomain.workHour/60}"/>
														/
														<fmt:parseNumber integerOnly="true" value="${pjtDomain.workHour mod 60}"/>
													</c:when>
													<c:otherwise>
														0
														/
														<fmt:parseNumber integerOnly="true" value="${pjtDomain.workHour}"/>
													</c:otherwise>
												</c:choose>
											</td>
											<td>
												<c:choose>
													<c:when test="${pjtDomain.workHour < 480}">
														<span class="c-red"><!-- 미완료 -->
															<spring:message code="label.WAK004.list5"/>
														</span>
													</c:when>
													<c:otherwise>
														<span class="c-blue"><!-- 입력완료 -->
															<spring:message code="label.WAK004.list6"/>
														</span>
													</c:otherwise>
												</c:choose>
											</td>
										</tr>	
									</c:forEach>
								</c:when>
								<c:when test="${pjtCount > 0}">
									<td colspan="4">
										<!-- 날짜를 선택하여 조회하면 데이터가 조회됩니다. -->
										<spring:message code="label.WAK004.list7"/>
									</td>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="4">
											<!-- 조회할 데이터가 없습니다. -->
											<spring:message code="label.WAK004.list8"/>
										</td>
									</tr>
								</c:otherwise>
							</c:choose>	
								
						</tbody>
					</table>
					</div>
					<div class="cont_gp contR fr">
						<p class="tit">
							<spring:message code="label.WAK004.list3"/>
						</p>
						<div class="gp-wrap">
							<div id="barchart_material" style="width:100%"></div>
						</div>
					</div>
				</div>
			</form:form>
		
		
	</div>
</c:if>
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '0' }"><%--조회권한 --%>
	<div>
		<span><spring:message code='DNKR-E2-0000'/><!-- 권한이 없습니다. --></span>
	</div>
</c:if>