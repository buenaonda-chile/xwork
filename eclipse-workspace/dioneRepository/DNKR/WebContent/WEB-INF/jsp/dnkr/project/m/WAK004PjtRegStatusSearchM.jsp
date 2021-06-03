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
<link type="text/css" rel="stylesheet" media="all" href="/css/m/content.css">

<script type="text/javascript" src="${pageContext.request.contextPath}/js/project/WAK004PjtRegStatus.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

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
.uM_search .dropdown .dropbtn {
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

<div class="sub_Toptit">프로젝트등록현황</div>

<!-- container:S -->
<div id="userMG_container">
	<form:form action="${pageContext.request.contextPath}/WAK004PjtRegStatusSearch/search.do?tabId=${tabId}" modelAttribute="empDomain"  method="POST" name="empDomain"  id="empDomain">
		<div class="uM_search">
			<div class="dropdown">
				<span class="calendar_icon vcen2"></span>
				<input type="text" value="<c:out value="${searchDate}"/>" class="dropbtn" name="searchDate" id="searchDate"/>
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
			
		</div><!--search-->
		<div class="board-wrap">
			<table id="empTable" class="boardLst tblleft">
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
					<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%--조회권한 --%>
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
														<span class="c-red"><!-- ë¯¸ìë£ -->
															<spring:message code="label.WAK004.list5"/>
														</span>
													</c:when>
													<c:otherwise>
														<span class="c-blue"><!-- ìë ¥ìë£ -->
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
										<!-- ë ì§ë¥¼ ì ííì¬ ì¡°ííë©´ ë°ì´í°ê° ì¡°íë©ëë¤. -->
										<spring:message code="label.WAK004.list7"/>
									</td>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="4">
											<!-- ì¡°íí  ë°ì´í°ê° ììµëë¤. -->
											<spring:message code="label.WAK004.list8"/>
										</td>
									</tr>
								</c:otherwise>
							</c:choose>	
							
					</c:if>
					<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '0' }"><%--조회권한 --%>
						<tr>
							<td colspan="4">
								<spring:message code='DNKR-E2-0000'/><!-- 권한이 없습니다. -->
							</td>
						</tr>
					</c:if>
				</tbody>
			</table>
		
		
			<!-- <select name="" title="검색내용을 선택해주세요" class="select-st01 w90px fl mt10 mb5">
					<option>전체</option>
					<option>내부직원</option>
					<option>외부업체</option>
			</select>
			<table class="boardLst tblleft">
				<caption>기본게시판</caption>
				<colgroup>
					<col class="w20p">
					<col class="">
					<col class="">
					<col class="">
				</colgroup>
				<thead>
					<tr>
						<th>번호</span></th>
						<th>부서</th>
						<th>사원<span class="in_bl">번호</span></th>
						<th>사원명</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>2564</td>
						<td>위기관리1</td>
						<td>OSW_test</td>
						<td>홍길동</td>
					</tr>
				</tbody>
			</table> -->
		</div>
		<div class="cont_gp contR fr">
			<p class="tit">
				<spring:message code="label.WAK004.list3"/>
			</p>
			<div class="gp-wrap">
				<div id="barchart_material" style="width:100%"></div>
			</div>
		</div>
		
		<div class="ssgap"></div>
		
		
		
		<div class="gap"></div>
	</form:form>
</div>


 <!-- container:E -->