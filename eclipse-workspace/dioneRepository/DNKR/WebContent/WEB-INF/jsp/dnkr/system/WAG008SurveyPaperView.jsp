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
		var tempCode = $('#tempCode').val();
		if(tempCode==''){
			alert('귀하의 소속을 반드시 선택해주세요');
			$('#tempCode').focus();
			return;
		}
		
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
	
	function insertData() {

		//console.log($('#tempCode').val());
		$('#teamCdNm').val($('#tempCode').val());
	}

</script>
<div class="research-cont-wrap">
			<div class="research-cont-top">
			</div> <!--research-top-->
			<div class="gap20"></div>
			<div class="research-cont">
			<form:form action="/WAG005SurveyPaper/create.do?menu=${menu }&tabId=${tabId}" modelAttribute="WAG008SurveyPaperViewForm" name="WAG008SurveyPaperViewForm" method="POST">
			<input type="hidden" name="srvCode" value="${srvCode }">
			
				<table>
					<caption></caption>
					<tbody>
						<tr>
							<td>
							<c:choose>
								<c:when test="${fn:length(questionList)  >0 }">
								
							
									<c:forEach var="rs" items="${questionList}" varStatus="status">
										<c:choose>
											<c:when test="${rs.qstType eq 'text' }">
												<div>
													<div class="tit">
														<p class="txt">${status.index+1 }. ${rs.qstTitle }</p>
													</div>
													<c:if test="${(rs.qstHelp ne null) and (fn:trim(rs.qstHelp) ne '')}">
														<p class="help">( ${rs.qstHelp } )</p>
													</c:if>
													
													<c:choose>
														<%-- <c:when test="${(status.index eq 0)}"> --%>
														
														<c:when test="${(status.index eq 0) and (isAnonymous eq 'Y') }">
															<div class="ans">
																<div class="form-group">
																	<input type="hidden" name="drQstCode[]" value="${rs.qstCode }">
																	<input type="hidden" name="drAns[]" id="teamCdNm" value="">
																	
																	<%-- <input style="width:150px;display:inline-block" type="text" class="form-control" disabled/>
																	<button type="button" onclick="openDept(this)" class="AXButton Normal _deptBtn_">
																		<spring:message code="label.deptName" /><!-- 부서 -->
																		<spring:message code="label.select" /><!-- 선택 -->
																	</button> --%>
																	<!-- 사업장을 선택해주세요 -->
																	<select id="tempCode" style="width:200px" onchange="javascript:insertData();">
																		<option value="">소속선택</option>																		
																		<option value="중역">중역(Director)</option>
																		<option value="안전위생환경팀">안전위생환경팀(SafeEnvironment)</option>
																		<option value="사업계획팀">사업계획팀(BusinessDesign)</option>
																		<option value="회계팀">회계팀(Account)</option>
																		<option value="재무팀">재무팀(Finance)</option>
																		<option value="법무팀">법무팀(Legal)</option>
																		<option value="구매기획팀">구매기획팀(PurchasePlanning)</option>
																		<option value="구매개발1팀">구매개발1팀(Purchase1)</option>
																		<option value="구매개발2팀">구매개발2팀(Purchase2)</option>
																		<option value="인사팀">인사팀(HR)</option>
																		<option value="총무팀">총무팀(GeneralAffairs)</option>
																		<option value="영업기획팀">영업기획팀(SalesPlanning)</option>
																		<option value="파워트레인1팀">파워트레인1팀(Powertrain1)</option>
																		<option value="파워트레인2팀">파워트레인2팀(Powertrain2)</option>
																		<option value="정안팀">정안팀(DrivingAssistSafety)</option>
																		<option value="소형모터팀">소형모터팀(SmallSizeMoter)</option>
																		<option value="공조/냉각팀">공조/냉각팀(AC/Cooling)</option>
																		<option value="상용공조팀">상용공조팀(CommercialAC)</option>
																		<option value="시판팀">시판팀(AfterMarket)</option>
																		<option value="서비스팀">서비스팀(Service)</option>
																		<option value="판매관리팀">판매관리팀(Delivery)</option>
																		<option value="기술기획관리팀">기술기획관리팀(TechnologyPlanningManagement)</option>
																		<option value="GE개발팀">GE개발팀(G/EDevelopment)</option>
																		<option value="DE개발팀">DE개발팀(D/EDevelopment)</option>
																		<option value="모빌리티개발팀">모빌리티개발팀(MobilityDevelopment)</option>
																		<option value="전동화개발팀">전동화개발팀(MotorizationDevelopment)</option>
																		<option value="CS팀">CS팀(CS)</option>
																		<option value="품질경영팀">품질경영팀(QualityManagement)</option>
																		<option value="품보1팀">품보1팀(QA1)</option>
																		<option value="부품품질개선1팀">부품품질개선1팀(PartsQualityImprovement1)</option>
																		<option value="품보2팀(QA2)">품보2팀(QA2)</option>
																		<option value="부품품질개선2팀">부품품질개선2팀(PartsQualityImprovement2)</option>
																		<option value="해외품보팀">해외품보팀(AbroadQA)</option>
																		<option value="품보3팀">품보3팀(QA3)</option>
																		<option value="부품품질개선3팀">부품품질개선3팀(PartsQualityImprovement3)</option>
																		<option value="품보4팀">품보4팀(QA4)</option>
																		<option value="EF팀">EF팀(EF)</option>
																		<option value="생산추진팀">생산추진팀(ProductionPromotion)</option>
																		<option value="IT팀">IT팀(IT)</option>
																		<option value="생산기술팀">생산기술팀(ProductionEngineering)</option>
																		<option value="화성생기팀">화성생기팀(HwaseongProductionEngineering)</option>
																		<option value="마산생기팀">마산생기팀(MasanProductionEngineering)</option>
																		<option value="공기팀">공기팀(Machinery&Tools)</option>
																		<option value="마산공기팀">마산공기팀(MasanMachinery&Tools)</option>
																		<option value="파워트레인기획팀">파워트레인기획팀(PowertrainPlanning)</option>
																		<option value="파워트레인기술1팀">파워트레인기술1팀(PowertrainTechnology1)</option>
																		<option value="파워트레인기술2팀">파워트레인기술2팀(PowertrainTechnology2)</option>
																		<option value="제조1팀(창)">제조1팀(창)(Manufacture1(Chang))</option>
																		<option value="제조2팀(창)">제조2팀(창)(Manufacture2(Chang))</option>
																		<option value="보전팀">보전팀(Maintenance)</option>
																		<option value="생산관리팀(창)">생산관리팀(창)(ProductionManagement(Chang))</option>
																		<option value="제조1팀(화)">제조1팀(화)(Manufacture1(Hwa))</option>
																		<option value="생산관리팀(화)">생산관리팀(화)(ProductionManagement(Hwa))</option>
																		<option value="모터기획팀">모터기획팀(MotorPlanning)</option>
																		<option value="모터기술1팀">모터기술1팀(MotorTechnology1)</option>
																		<option value="모터기술2팀">모터기술2팀(MotorTechnology2)</option>
																		<option value="제조2팀(화)">제조2팀(화)(Manufacture2(Hwa))</option>
																		<option value="M&E기획팀">M&E기획팀(M&EPlanning)</option>
																		<option value="CP개발기술팀">CP개발기술팀(CPDevelopmentTechnology)</option>
																		<option value="CPSYS기술팀">CPSYS기술팀(CPSYSTechnology)</option>
																		<option value="CP의장기술1팀">CP의장기술1팀(CPOutfitTechnology1)</option>
																		<option value="CP의장기술2팀">CP의장기술2팀(CPOutfitTechnology2)</option>
																		<option value="CP회로기술팀">CP회로기술팀(CPCircuitTechnology)</option>
																		<option value="CPSW기술팀">CPSW기술팀(CPSWTechnology)</option>
																		<option value="중국연구소">중국연구소(ChinaResearch)</option>
																		<option value="BD개발기술팀">BD개발기술팀(BDDevelopmentTechnology)</option>
																		<option value="BDSYS기술팀">BDSYS기술팀(BDSYSTechnology)</option>
																		<option value="BD회로기술팀">BD회로기술팀(BDCircuitTechnology)</option>
																		<option value="BDSW기술팀">BDSW기술팀(BDSWTechnology)</option>
																		<option value="제조1팀(마)">제조1팀(마)(Manufacture1(Ma))</option>
																		<option value="제조2팀(마)">제조2팀(마)(Manufacture2(Ma))</option>
																		<option value="생산관리팀(마)">생산관리팀(마)(ProductionManagement(Ma))</option>
																		<option value="자재관리팀(마)">자재관리팀(마)(MaterialManagement(Ma))</option>
																		<option value="서멀기획팀">서멀기획팀(ThermalPlanning)</option>
																		<option value="서멀구매팀">서멀구매팀(ThermalPurchase)</option>
																		<option value="승용냉각기술팀">승용냉각기술팀(PasCarCooling)</option>
																		<option value="승용공조기술팀">승용공조기술팀(PasCarAC)</option>
																		<option value="버스AC기술팀">버스AC기술팀(BusAC)</option>
																		<option value="서멀생산기술팀">서멀생산기술팀(ThermalProductionEngineering)</option>
																		<option value="서멀생산관리팀">서멀생산관리팀(ThermalProductionManagement)</option>
																		<option value="서멀제조팀">서멀제조팀(ThermalManufacture)</option>																		
																	</select>
																</div>	
										            		</div>
														</c:when>
														<c:otherwise>
															<div class="ans">
																<textarea name="drAns[]" style="width:98%;height:40px;"></textarea>
																<input type="hidden" name="drQstCode[]" value="${rs.qstCode }">
															</div>
														</c:otherwise>
													</c:choose>
													<%-- <div class="ans">
														<textarea name="drAns[]" style="width:98%;height:80px;"></textarea>
														<input type="hidden" name="drQstCode[]" value="${rs.qstCode }">
													</div> --%>
													<div class="gap20"></div>
												</div>
											</c:when>
											<c:when test="${rs.qstType eq 'checkbox' }">
												<div>
													<div class="tit">
														<input type="hidden" name="qstCodeStr[]" value="${rs.qstCode }" />
														<p class="txt">${status.index+1 }. ${rs.qstTitle }</p>
													</div>
													<c:if test="${(rs.qstHelp ne null) and (fn:trim(rs.qstHelp) ne '')}">
														<p class="help">( ${rs.qstHelp } )</p>
													</c:if>
													<c:set var="asw2Cnt">0</c:set>
													<c:forTokens items="${rs.aswTitle }" delims="|" var="asw">
		
													<div class="ans">
														<label>
															<input type="checkbox" name="asw_${rs.qstCode }" value="${rs.qstCode}§${fn:split(rs.aswCode,'|')[asw2Cnt] }"><span class="radio-deco"></span>${asw}
															
														</label>
													</div>
													<c:set var="asw2Cnt">${asw2Cnt+1 }</c:set>
													</c:forTokens>
													<div class="gap20"></div>
												</div>
											</c:when>
											<c:when test="${rs.qstType eq 'radio' }">
												<div>
													<div class="tit">
														<input type="hidden" name="qstCodeStr[]" value="${rs.qstCode }" />
													<p class="txt">${status.index+1 }. ${rs.qstTitle }</p>
													</div>
													<c:if test="${(rs.qstHelp ne null) and (fn:trim(rs.qstHelp) ne '')}">
														<p class="help">( ${rs.qstHelp } )</p>
													</c:if>
													<c:set var="asw3Cnt">0</c:set>
													<c:forTokens items="${rs.aswTitle }" delims="|" var="asw">
													<div class="ans">
														<label>
															<input type="radio" name="asw_${rs.qstCode }" value="${rs.qstCode}§${fn:split(rs.aswCode,'|')[asw3Cnt] }"><span class="radio-deco"></span>${asw }
														</label>
													</div>
													<c:set var="asw3Cnt">${asw3Cnt+1 }</c:set>
													</c:forTokens>
													<div class="gap20"></div>
												</div>
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
							</td>
							
						</tr>
					</tbody>
				</table>
			</form:form>
				<div class="research-conB-bnt" style="text-align:center;">
						<c:if test="${fn:length(questionList)  >0 }">
						<button type="button" class="add-bnt red" name="Prepare" onClick="javascript:applyQuestion(); return false;">
								<span><spring:message code="label.apply"/></span>
							</button>
						</c:if>
						<c:if test="${surveyDomain.srvAnonymous ne 'Y'}">
							<button type="button" class="listback-b" name="Return" onclick="location.href='/WAG005SurveyPaper/init.do?menu=${menu}&tabId=${tabId}'">
								<span><spring:message code="label.WAG001.ListView" /></span>
							</button>
						</c:if>
					</div>
			</div><!--research-list-->
			</div>
		