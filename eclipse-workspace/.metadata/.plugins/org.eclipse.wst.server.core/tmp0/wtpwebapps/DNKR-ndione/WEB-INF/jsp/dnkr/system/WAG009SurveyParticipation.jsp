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
<script>
	function applysurvey(srvCode){
		location.href="/WAG005SurveyPaper/paperView.do?menu=${menu}&tabId=${tabId}&srvCode="+srvCode;
	}
	
	function setData(type, relationCode){
		//console.log("setData()");
		$.ajax({
			method : "post",
			url : "/ajaxRelation/init.do",
			data : {
				type: type,
				parentCode: relationCode,			
			},
			success : function(res) {
				//console.log(res);
				var data = JSON.parse(res);
				if (data.list.length > 0) {
					
					//조회 select 외의 데이터 초기화
					if(type === "LOC") {
//						teamCode 리스트 초기화
						$('select.teamCode').html('<option value="">부서(팀)전체</option>');
						var listStr = "<option value=''>사업장전체</option>";
						data.list.forEach(function(item, index){
							listStr += '<option value="'+ item.relationCode +'">'+item.relationName+'</option>';	
						});
						
						$('select.locCode').html(listStr);
					} else if(type === "TEAM") {
						var listStr = "<option value=''>부서(팀)전체</option>";
						data.list.forEach(function(item, index){
							listStr += '<option value="'+ item.relationCode +'">'+item.relationName+'</option>';	
						});
						
						$('select.teamCode').html(listStr);
					}
					setTimeout(function() {
						mask.close();
					}, 1000);
				} else {
					
					//하위그리드 데이터 조회일 때 초기화
					if(type === "LOC") {
//						locCode에 리스트 초기화
						$('select.locCode').html('<option value="">사업장전체</option>');
//						teamCode에 리스트 초기화
						$('select.teamCode').html('<option value="">부서(팀)전체</option>');
						
						//사업부서 등록 시 상위코드로 사용할 사업장 코드 초기화
						currLocCode = "";
						
					} else if(type === "TEAM"){
//						teamCode에 리스트 초기화
						$('select.teamCode').html('<option value="">부서(팀)전체</option>');
					}
					
					setTimeout(function() {
						mask.close();
						toastMsg("데이터가 없습니다.");
					}, 1000);
				}
			},
			error : function(res) {
				//console.log("error");
				//console.log(res);
			},
			complete : function(res) {
				setTimeout(function() {
					mask.close();
				}, 1000);
			}
		});
		//console.log('ajaxend');
		// return true;
	}

	function tableToCSV( table ) {
	// We'll be co-opting `slice` to create arrays
	var slice = Array.prototype.slice;

	return slice.call( table.rows ).map(function ( row ) {
	  return slice.call( row.cells ).map(function ( cell ) {
	    return '"t"'.replace( "t", cell.textContent );
	  }).join( "," );
	}).join( "\r\n" );

	}

	function searchSubmit() {
	console.log('search clicked');
	var sort = $('.nameId').val();
	if(sort === 'empName') {
		$('#empName').val($('#searchData').val());
		$('#empId').val("");
	} else if (sort === 'empId') {
		$('#empId').val($('#searchData').val());
		$('#empName').val("");
	}
	$('#TargetDomainForm').submit();
	}

	function enterProc() {
	 if(event.keyCode==13){
		searchSubmit();
	 }
	}

	$(function(){	
		/* 
		$('select.clsCode').change(function(){
			//console.log('select changed');
			var currClsCode = this.value;
			$('#clsCode').val(currClsCode);
			if($('#clsCode').val() == "사업부전체"){
				$('#clsCode').val("");
			}
			currLocCode = null;
			currTeamCode = null;
			setData('LOC', currClsCode);
		});
		 */

		//사업장 셀렉트박스의 값이 변경될때  
		$('select.locCode').change(function(){
			//console.log('select changed');
			var currLocCode = this.value;
			$('#locCode').val(currLocCode);
			if($('#clsCode').val() == "사업장전체"){
				$('#clsCode').val("");
			}
			currTeamCode = null;
			setData('TEAM', currLocCode);
		});

		//사업부서(팀) 셀렉트박스의 값이 변경될때  
		$('select.teamCode').change(function(){
			//consoleo.log('aa');
			var teamClsCode = this.value;
			$('#teamCode').val(teamClsCode);
			//console.log('select changed');
		});

		//아이디,성명 셀렉트박스의 값이 변경될때  
		$('select.nameId').change(function(){
			//console.log('select.nameId');
			var nameId = this.value;
			if (nameId === 'empName') {
				$('#empName').val($('#searchData').val());
				$('#empId').val("");
			} else {
				$('#empId').val($('#searchData').val());
				$('#empName').val("");
			}
		});

		//조회버튼 클릭
		$('._searchBtn_').on('click', function(){
			searchSubmit();
		});
		
	});
</script>


<div class="research-list-wrap">
<form:form action="${pageContext.request.contextPath}/WAG001SurveySearch/participation.do?menu=${menu}&tabId=${tabId}" modelAttribute="TargetDomainForm" name="TargetDomainForm" method="POST">
<div class="list-top">
		<div class="list-top text-right">
			<div class="ssgap"></div>
		<div class="list-top text-right" style="clear:both;">
				<input type="hidden" name="maEmpYn" value="N" />
				<input type="hidden" name="srvCode" value="${paraEmp.srvCode }" />
				<input type="hidden" name="mode" value="${mode }" />
				<input type="hidden" name="view" value="${view }" />
				
				
				<form:input type="hidden" name="empName" path="empName" id="empName"/>
				<form:input type="hidden" name="empId" path="empId" id="empId"/>
				
				<%-- 
				<!-- 사업부를 선택해주세요 -->
				<select class="clsCode" name="clsCode" style="width:99.2px" title="<spring:message code='DNKR-I0-0000'/>">
					<option value="">
						<spring:message code='label.cls_total'/><!-- 사업부전체 -->
					</option>
					<c:if test="${fn:length(clsList) > 0}">
						<c:forEach var="clsDomain" items="${clsList}" varStatus="status">
							<option value="${clsDomain.relationCode}"
								<c:if test="${clsDomain.relationCode eq paraEmp.clsCode}">
									selected
								</c:if>
							><c:out value="${clsDomain.relationName}"/></option>
						</c:forEach>
					</c:if>
				</select>
				 --%>
				
				<!-- 사업장을 선택해주세요 -->
				<select class="locCode" name="locCode" style="width:99.2px" title="<spring:message code='DNKR-I0-0001'/>">
					<option value="">
						<spring:message code='label.loc_total'/><!-- 사업장전체 -->
					</option>
					<c:if test="${fn:length(locList) > 0}">
						<c:forEach var="locDomain" items="${locList}" varStatus="status">
							<option value="${locDomain.relationCode}"
								<c:if test="${locDomain.relationCode eq paraEmp.locCode}">
									selected
								</c:if>
							><c:out value="${locDomain.relationName}"/></option>
						</c:forEach>
					</c:if>
				</select>
				
				<!-- 부서(팀)를 선택해주세요 -->
				<select class="teamCode" name="teamCode" style="width:252.8px" title="<spring:message code='DNKR-I0-0002'/>">
					<option value="">
						<spring:message code='label.team_total'/><!-- 부서(팀)전체 -->
					</option>
					<c:if test="${fn:length(teamList) > 0}">
						<c:forEach var="teamDomain" items="${teamList}" varStatus="status">
							<option value="${teamDomain.relationCode}"
								<c:if test="${teamDomain.relationCode eq paraEmp.teamCode}">
									selected
								</c:if>
							><c:out value="${teamDomain.relationName}"/></option>
						</c:forEach>
					</c:if>
				</select>
				
				<!-- 성명 또는 아이디를 선택해주세요 -->
				<select class="nameId" name="" style="width:72.8px" title="<spring:message code='DNKR-I0-0003'/>">
					<c:choose>
						<c:when test="${paraEmp.empName ne ''}">
							<option value="empName" selected>
								<spring:message code='label.person_name'/><!-- 성명 -->
							</option>
							<option value="empId" >
								<spring:message code='label.WAB002.empId'/><!-- 아이디 -->
							</option>
						</c:when>
						<c:otherwise>
							<option value="empName">
								<spring:message code='label.person_name'/><!-- 성명 -->
							</option>
							<option value="empId" selected>
								<spring:message code='label.WAB002.empId'/><!-- 아이디 -->
							</option>
						</c:otherwise>
					</c:choose>
				</select>
				
				<!-- 성명 또는 아이디를 입력해주세요  -->
				<input class="AXInput" id="searchData" style="width:161.6px" type="text" onkeypress="return enterProc();" placeholder="<spring:message code='DNKR-I0-0004'/>" title="<spring:message code='DNKR-I0-0004'/>" 
					<c:choose>
						<c:when test="${paraEmp.empName ne ''}">
							value="${paraEmp.empName}"
						</c:when>
						<c:otherwise>
							value="${paraEmp.empId}"
						</c:otherwise>
					</c:choose>
				/>
				
				<button type="button" class="AXButton Black _searchBtn_">
					<i class="axi axi-ion-android-search"></i>
					<spring:message code='label.search'/>
				</button>
		</div>
		</div>
	</div>

 </form:form>
			<div class="research-top">
			</div> <!--research-top-->
			<div class="gap20"></div>
			
			<div class="research-list">
				<span class="top-border"></span>
				<table id="empTable">
			<caption></caption>
			<colgroup>
				<col scope="col" width="*">
				<col scope="col" width="*">
				<col scope="col" width="*">
				<col scope="col" width="*">
				<col scope="col" width="*">
				<!-- <col scope="col" width="*" class="w60p"> -->
				<col scope="col" width="*">
				<col scope="col" width="*">
				<col scope="col" width="*">
			</colgroup>
			<thead>
				<tr>
					<th><spring:message code='label.number'/><!-- 번호 --></th>
					<th><spring:message code='label.WAB002.empInoutType'/><!-- 직원구분 --></th>
					<th><spring:message code='label.WAB002.clsCode'/><!-- 사업부 --></th>
					<th><spring:message code='label.WAB002.locCode'/><!-- 사업장 --></th>
					<th><spring:message code='label.WAB002.teamCode'/><!-- 부서(팀) --></th>
					<th><spring:message code='label.WAB002.empNumber'/><!-- 사번 --></th>
					<th><spring:message code='label.WAB002.empName'/><!-- 성명 --></th>
					<th><spring:message code='label.WAB002.empId'/><!-- 아이디 --></th>
					<th><spring:message code='label.email'/><!-- 이메일 --></th>
					<th><spring:message code='label.WAG001.surveyResult'/><!-- 사용 --></th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%--조회권한 --%>
						<c:choose>
							<c:when test="${fn:length(surveyList) > 0}">
								<c:set value="${fn:length(surveyList)}" var="empListSize"/>
									<c:forEach var="empDomain" items="${surveyList}" varStatus="status">
										<tr>
											<td>${totCount + 1 - empDomain.rowNum}</td>
											<td>
												<c:choose>
													<c:when test="${empDomain.inOutType eq 'I'}">
														<spring:message code="label.WAB002.empInternal" /><!-- 내부 -->
													</c:when>
													<c:otherwise>
														<spring:message code="label.WAB002.empOutside" /><!-- 외부 -->
													</c:otherwise>
												</c:choose>
											</td>
											<td>${empDomain.clsName}</td>
											<td>${empDomain.locName}</td>
											<td>${empDomain.teamName}</td>
											<td>${empDomain.empNumber}</td>
											<td>${empDomain.empName}</td>
											<td>${empDomain.empId}</td>
											<td>${empDomain.empEmail}</td>
											<td>
												<button class="btn_type01" onclick="location.href='/WAG006SurveyPrivateSelect/init.do?menu=${menu}&tabId=${tabId }&empNumber=${empDomain.empNumber }&srvCode=${paraEmp.srvCode }'"><spring:message code="label.WAG001.surveyResult"/></button>
											</td>
										</tr>
									</c:forEach>
							</c:when>
							<c:otherwise>
								<tr><td colspan="11"><spring:message code='label.WAK004.list8' /><!-- 데이터가 없습니다. --></td></tr>
							</c:otherwise>
						</c:choose>
						
				</c:if>
				<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '0' }"><%--조회권한 --%>
					<tr>
						<td colspan="11">
							<spring:message code='DNKR-E2-0000'/><!-- 권한이 없습니다. -->
						</td>
					</tr>
				</c:if>
			</tbody>
		</table>
<div class="gap20"></div>				
			</div><!--research-list-->
			<form:form action="${pageContext.request.contextPath}/WAG001SurveySearch/participation.do?menu=${menu}&tabId=${tabId}" modelAttribute="TargetDomainForm"  method="POST">	
			<c:if test="${fn:length(surveyList) > 0}">
				<div class="pagenation">
		            <smpl:seqpaging maxSeq="10" action='${pageContext.request.contextPath}/WAG001SurveySearch/participation.do?tabId=${tabId}&menu=${menu}' formId="TargetDomain" />
		        </div>
		        <ai:pagingoption countPerPage="10" />
	        </c:if>
	        </form:form>
		
		 
		<div  style="display: inline-block; float:right">
			<!-- <button type="button" class="downLoad _excelBtn_" style="right:0px">
				<span>엑셀다운</span>
			</button> -->
			<button type="button" class="listback-b" name="Return" onclick="location.href='/WAG001SurveySearch/init.do?menu=${menu}&tabId=${tabId }'">
							<span><spring:message code="label.WAG001.ListView"/></span>
						</button>
			
			
			
		</div>

		</div><!--research-list-wrap-->