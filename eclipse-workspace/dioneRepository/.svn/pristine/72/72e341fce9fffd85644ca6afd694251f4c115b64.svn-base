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
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/ai-paging_pl.js"></script>
	<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/WAB001Emp.js?ver=1"></script> --%>
	<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/WAB001EmpSearch.js?ver=2" charset="utf-8"></script> --%>
	<!-- [EN] Contents area -->
	<!-- [JP] コンテンツエリア -->
	
	
	<script>
	var currClsCode,
	currLocCode,
	currTeamCode;
	
	/**
	* 
	* @param type
	* @param relationCode
	*/
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
	/* console.log('search clicked');
	var sort = $('.nameId').val();
	if(sort === 'empName') {
		$('#empName').val($('#searchData').val());
		$('#empId').val("");
	} else if (sort === 'empId') {
		$('#empId').val($('#searchData').val());
		$('#empName').val("");
	} */
	$('#TargetDomainForm').submit();
	}
	
	function enterProc() {
	 if(event.keyCode==13){
		searchSubmit();
	 }
	}
	
	$(function(){
	/* 	
	//사업부 셀렉트박스의 값이 변경될때  
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
	
	/* //아이디,성명 셀렉트박스의 값이 변경될때  
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
	}); */
	
	//조회버튼 클릭
	$('._searchBtn_').on('click', function(){
		searchSubmit();
	});
	
	$("#allCheck").click(function(){ 
		//만약 전체 선택 체크박스가 체크된상태일경우 
		if($("#allCheck").prop("checked")) { 
			//해당화면에 전체 checkbox들을 체크해준다 
			$("input[type=checkbox]").not(":disabled").prop("checked",true); 
			// 전체선택 체크박스가 해제된 경우 
			} else { //해당화면에 모든 checkbox들의 체크를해제시킨다.
				$("input[type=checkbox]").prop("checked",false); 
			}
		});
	
	});
	
	function surveyApply(mode){
		var form =document.TargetDomainForm;
		var srvCode = form.srvCode.value;
		var checkboxValues = [];
		$("input[name=empChk]:checked").each(function() {
			 checkboxValues.push($(this).val());
		});
		var chklength = $("input[name=empChk]:checked").length;
		
		
		
		if(chklength == 0){
			alert("한개이상의 직원을 선택해주세요.");
			return false;
		}
		
		$.ajax({
			type:"POST",
			url:"${pageContext.request.contextPath}/WAG004SurveyTarget/creat.do",
			data : {srvCode : srvCode, empNumberList : checkboxValues, mode : mode, view : "${view}"},
			dataType : "json",
			async: false,
			success: function(data){
				
				alert(data.result);
				document.location.reload();
			},
			error: function(xhr, status, error) {
				alert(error);
			}   
		});
		
	}
	
	
	</script>
	<div class="board-bList-wrap">
	<c:if test="${mode ne 'view' }">
			<div class="fl">
					<ul class="pj-smtab" style="border-left:1px; solid">
						<li <c:if test="${view eq 'normal' }">class="over first"</c:if>><a href="/WAG004SurveyTarget/init.do?srvCode=${srvCode }&view=normal"><span><spring:message code="label.WAG001.individualSelect"/></span></a></li>
						<li <c:if test="${view eq 'team' }">class="over first"</c:if>><a href="/WAG004SurveyTarget/teamList.do?srvCode=${srvCode }&view=team"><span><spring:message code="label.WAG001.teamSelect"/></span></a></li>
					</ul>
			</div>
	</c:if>
	<%-- <form:form action="${pageContext.request.contextPath}/WAB001EmpSearch/search.do" method="POST" name="EmpDomain" id="WAD001EmpSearch"> --%>
		<form:form action='${pageContext.request.contextPath}/WAG004SurveyTarget/teamList.do' method="POST"  modelAttribute="TargetDomainForm" name="TargetDomainForm">
			<div class="ssgap"></div>
			<div class="list-top text-right" style="clear:both;">
					<input type="hidden" name="maEmpYn" value="N" />
					<input type="hidden" name="srvCode" value="${srvCode }" />
					<input type="hidden" name="mode" value="${mode }" />
					<input type="hidden" name="view" value="${view }" />
					
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
					
					
					<!-- 성명 또는 아이디를 입력해주세요  -->
					
					
						<button type="button" class="AXButton Black _searchBtn_" onclick="javascript:searchSubmit(); return false;">
						<i class="axi axi-ion-android-search"></i>
						<spring:message code='label.search'/>
					</button>
					<%-- <c:if test="${fn:substring(authBinaryNum, 2, 3) eq '1' }">등록권한 --%>
						<c:choose>
						<c:when test="${mode ne 'view' }">
						<button type="button" class="AXButton Red _addBtn_" style="" onclick="javascript:surveyApply('insert'); return false;" data-click-target="CLS">
							<i><!--  class="axi axi-ion-person-add"> --></i>
							<spring:message code='label.WAB002.employee'/>&nbsp;
							<spring:message code='label.add'/><!-- 사용자 등록  -->
						</button>
						</c:when>
						<c:otherwise>
							<button type="button" class="AXButton Red _addBtn_" style="" onclick="javascript:surveyApply('delete'); return false;" data-click-target="CLS">
							<i><!--  class="axi axi-ion-person-add"> --></i>
							<spring:message code='label.WAB002.employee'/>&nbsp;
							<spring:message code='label.delete'/><!-- 사용자 등록  -->
						</button>
						</c:otherwise>
						</c:choose>
					<%-- </c:if> --%>
			</div>
				 
			<div class="gap20"></div>
			<span class="top-border"></span>
			<table id="empTable">
				<caption></caption>
				<colgroup>
					<col scope="col" width="5%">
					<col scope="col" width="*">
					<col scope="col" width="*">
					<col scope="col" width="*">
					<col scope="col" width="*">
					<!-- <col scope="col" width="*" class="w60p"> -->
				</colgroup>
				<thead>
					<tr>
						<th><input type="checkbox" name="all" id="allCheck"><!-- 번호 --></th>
						<th><spring:message code='label.number'/><!-- 번호 --></th>
						<th><spring:message code='label.WAB002.clsCode'/><!-- 사업부 --></th>
						<th><spring:message code='label.WAB002.locCode'/><!-- 사업장 --></th>
						<th><spring:message code='label.WAB002.teamCode'/><!-- 부서(팀) --></th>
						<th>
						</th>
					</tr>
				</thead>
				<tbody>
							<c:choose>
								<c:when test="${fn:length(targetTeamList) > 0}">
									<c:set value="${fn:length(targetTeamList)}" var="empListSize"/>
									<c:set value="0" var="cnt"/>
										<c:forEach var="empDomain" items="${targetTeamList}" varStatus="status">
											<tr>
												<td>
												<c:set var="checkYn" value=""></c:set>
												<c:choose>
													<c:when test="${empDomain.chkYn > 0}">
														<c:set var="checkYn">disabled="disabled"</c:set>
													</c:when>
												</c:choose>
												<input type="checkbox" ${checkYn } name="empChk" id="empList_${empDomain.teamCode }" value="${empDomain.teamCode }">
												
												</td>
												<td>${empListSize - cnt}</td>
												<td>${empDomain.clsName}</td>
												<td>${empDomain.locName}</td>
												<td><%-- <a href="#" onClick="javascript:teamClick('${empDomain.teamCode}'); return false;"> --%>
												${empDomain.teamName}
												<!-- </a> -->
												</td>
											</tr>
											<c:set var="cnt">${cnt+1 }</c:set>
										</c:forEach>
								</c:when>
								<c:otherwise>
									<tr><td colspan="11"><spring:message code='label.WAK004.list8' /><!-- 데이터가 없습니다. --></td></tr>
								</c:otherwise>
							</c:choose>
				</tbody>
			</table>
			<!-- <div class="list-bnt listOnly">
				<a href="#" class="gray">삭제</a>
				<a href="#" class="red">글쓰기</a>
			</div> -->
			<div class="gap20"></div>
			
			 
		</form:form>
	</div><!--board-view-wrap--> 
	
