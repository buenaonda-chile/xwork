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
<link media="all" href="/css/board.css" rel="stylesheet"/>

<script>
	function applyQuestion(){
		var form = document.WAG008SurveyPaperViewForm;
		if(confirm("설문을 등록하시겠습니까?")){
			form.submit();
		}
	}
	
	function openDept() {
		var deptWindow = window.open("/WAD009RelationPopSelect/init.do","relationPop","width=900,height=700,scrollbars=yes,top=100,left=100");
		deptWindow.focus();
	}
	
	/**
	 * 팝업창에서 값넘겨받아 부모창에 데이터 set
	 * 
	 * @param returnValue
	 */
	function getReturnValue(returnValue) {
		if(returnValue !== null) {
			var relationObj = JSON.parse(returnValue);
			console.log(relationObj.clsRltnCode);
			//$('#clsCode').val(relationObj.clsCode);
			//$('#clsCode').attr('data-rltnCode', relationObj.clsRltnCode);
			//$('#clsCode').prev().val(relationObj.clsName);
			//$('#locCode').val(relationObj.locCode);
			//$('#locCode').attr('data-rltnCode', relationObj.locRltnCode);
			//$('#locCode').prev().val(relationObj.locName);
			//$('#teamCode').val(relationObj.teamCode);
			//$('#teamCode').prev().val(relationObj.teamName);
			
			$('#teamCdNm').val(relationObj.teamName);
			$('#teamCdNm').prev().val(relationObj.teamName);
		}
		
	}

</script>

<div class="sub_Toptit">설문조사</div>

<!-- container:S -->
<div id="research-ans-container">
	<form:form action="/WAG005SurveyPaper/create.do?menu=${menu }&tabId=${tabId}" modelAttribute="WAG008SurveyPaperViewForm" name="WAG008SurveyPaperViewForm" method="POST">
	<input type="hidden" name="srvCode" value="${srvCode }">
	<div class="subCont_wrap">
		<table class="tbl_st01">
			<caption><span class="blind">''</span></caption>
			<thead>
				<tr>
					<th>
						<p class="btxt">${surveyDomain.srvTitle }
						<span class="rsc-date">${fn:substring(surveyDomain.srvStart,0,16) } ~ ${fn:substring(surveyDomain.srvEnd,0,16) }</span></p>
					</th>
				</tr>
				<!--	작성자 데이터가 없음 
				<tr>
					<th class="tl smTxt"><span><strong>작성자</strong> : 관리자</span></th>
				</tr>
				 -->
			</thead>
			<tbody>
				<tr>
					<td class="tl">
						<c:choose>
							<c:when test="${fn:length(questionList)  >0 }">
							
						
						<c:forEach var="rs" items="${questionList}" varStatus="status">
							<c:choose>
								<c:when test="${rs.qstType eq 'text' }">
									<p class="rsc-tit">${status.index+1 }. ${rs.qstTitle }</p>
									<c:if test="${(rs.qstHelp ne null) and (fn:trim(rs.qstHelp) ne '')}">
										<p class="rsc-help">( ${rs.qstHelp } )</p>
									</c:if>
									
									
									<c:choose>
										<%-- <c:when test="${(status.index eq 0)}"> --%>
										<c:when test="${(status.index eq 0) and (isAnonymous eq 'Y') and (rs.qstTitle eq SELECT_TEAM_TITLE)}">
											<div class="form-group">
												<div class="inlineBlock">
													<input type="hidden" name="drQstCode[]" value="${rs.qstCode }">
													<input style="width:150px;" type="text" class="form-control" disabled/>
													<input type="hidden" name="drAns[]" id="teamCdNm" value="">
													<%-- <form:hidden cssClass="form-control" id="teamCode" path="teamCode"/> --%>
							            			<%-- <form:errors path="teamCode" cssStyle="color:#ff0000;" element="span" /> --%>
						            			</div>
						            			<div class="inlineBlock">	
													<button type="button" onclick="openDept(this)" class="AXButton Normal _deptBtn_">
														<spring:message code="label.deptName" /><!-- 부서 -->
														<spring:message code="label.select" /><!-- 선택 -->
													</button>
												</div>
						            		</div>
										</c:when>
										<c:otherwise>
											<div class="ans">
												<textarea name="drAns[]" style="width:98%;height:80px;"></textarea>
												<input type="hidden" name="drQstCode[]" value="${rs.qstCode }">
											</div>
										</c:otherwise>
									</c:choose>
									
									
									<div class="gap20"></div>
								</c:when>
								<c:when test="${rs.qstType eq 'checkbox' }">
									<input type="hidden" name="qstCodeStr[]" value="${rs.qstCode }" />
									<p class="rsc-tit">${status.index+1 }. ${rs.qstTitle }</p>
									<c:if test="${(rs.qstHelp ne null) and (fn:trim(rs.qstHelp) ne '')}">
										<p class="rsc-help">( ${rs.qstHelp } )</p>
									</c:if>
									<c:set var="asw2Cnt">0</c:set>
									<c:forTokens items="${rs.aswTitle }" delims="|" var="asw">

									<div class="ans">
										<label>
											<input type="checkbox" name="asw_${rs.qstCode }" class="R-Cb-st01" value="${rs.qstCode}§${fn:split(rs.aswCode,'|')[asw2Cnt] }"><span class="R-Cb-deco01"></span>${asw}
											
										</label>
									</div>
									<c:set var="asw2Cnt">${asw2Cnt+1 }</c:set>
									</c:forTokens>
									<div class="gap20"></div>
								</c:when>
								<c:when test="${rs.qstType eq 'radio' }">
									<input type="hidden" name="qstCodeStr[]" value="${rs.qstCode }" />
									<p class="rsc-tit">${status.index+1 }. ${rs.qstTitle }</p>
									</div>
									<c:if test="${(rs.qstHelp ne null) and (fn:trim(rs.qstHelp) ne '')}">
										<p class="rsc-help">( ${rs.qstHelp } )</p>
									</c:if>
									<c:set var="asw3Cnt">0</c:set>
									<c:forTokens items="${rs.aswTitle }" delims="|" var="asw">
									<div class="ans">
										<label>
											<input type="radio" name="asw_${rs.qstCode }" class="R-Cb-st01" value="${rs.qstCode}§${fn:split(rs.aswCode,'|')[asw3Cnt] }"><span class="R-Cb-deco01"></span>${asw }
										</label>
									</div>
									<c:set var="asw3Cnt">${asw3Cnt+1 }</c:set>
									</c:forTokens>
								</c:when>
							</c:choose>
						</c:forEach>
							</c:when>
							<c:otherwise>
							<div style="float:center;margin-left:250px;">
											<h1><spring:message code="label.WAG001.ready"/></h1>
							</div>
							</c:otherwise>
						</c:choose>
						
						<!-- <div class="pt10">
							<p class="rsc-tit">1. 홈페이지에서 가장 마음에 드시는 부분은 어디입니까?</p>
							<p class="rsc-help">( 구체적으로 작성해주세요 )</p>
							<textarea name="" style="width:98%;height:80px;" class="rsc-ans"></textarea>
							<div class="gap20"></div>
						</div>
						<div class="pt10">
							<p class="rsc-tit">2. 꼭 있었으면 하는 기능이 있다면 무엇입니까?</p>
							<p class="rsc-help">( 중복 선택 가능합니다 )</p>
							<label class="rsc-ans dreak">
								<input type="checkbox" name="" value=""class="R-Cb-st01"><span class="R-Cb-deco01"></span>스케쥴 알림 기능
							</label>
							</div>
							<label class="rsc-ans dreak">
								<input type="checkbox" name="" value=""class="R-Cb-st01"><span class="R-Cb-deco01"></span>비밀글 설정
							</label>
							<label class="rsc-ans dreak">
								<input type="checkbox" name="" value=""class="R-Cb-st01"><span class="R-Cb-deco01"></span>기능 전체 보기
							</label>
							<div class="gap20"></div>
						</div>
						<div class="pt10">
							<p class="rsc-tit">3. 즐겨찾기 아이콘 갯수는 얼마 정도가 좋다고 생각하십니까?</p>
							</div>
							<p class="rsc-help">( 중복 선택 불가능합니다 )</p>
							<label class="rsc-ans dreak">
								<input type="radio" name="ans03" value=""class="R-Cb-st01"><span class="R-Cb-deco01"></span>많을 수록 좋다.
							</label>
							<label class="rsc-ans dreak">
								<input type="radio" name="ans03" value=""class="R-Cb-st01"><span class="R-Cb-deco01"></span>10개 이하면 좋겠다.
							</label>
							<label class="rsc-ans dreak">
								<input type="radio" name="ans03" value="" class="R-Cb-st01"><span class="R-Cb-deco01"></span>갯수 상관 없다.
							</label>
							<div class="gap30"></div>                    
					</div> -->
					</td>
				</tr>
			</tbody>
		</table> 
		<div class="gap10"></div> 
	
		<div class="btnCntr">
			<c:if test="${fn:length(questionList)  >0 }">
				<button type="button" class="btn-st1 bt-red" name="Prepare" onClick="javascript:applyQuestion(); return false;">
					<span><spring:message code="label.apply"/></span>
				</button>
			</c:if>
			<button type="button" class="listback-b" name="Return" onclick="location.href='/WAG005SurveyPaper/init.do?menu=${menu}&tabId=${tabId}'">
				<span><spring:message code="label.WAG001.ListView" /></span>
			</button>
			<!-- <button type="" class="btn-st1 bt-red" name="" onclick="javascript:history.back()">제출</button> -->
		</div>
	
		<div class="gap20"></div> 
</div><!--subCont_wrap-->
</form:form>
</div>
 <!-- container:E -->