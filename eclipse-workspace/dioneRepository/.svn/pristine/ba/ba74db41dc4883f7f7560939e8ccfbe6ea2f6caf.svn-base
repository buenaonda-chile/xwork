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
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%-- 조회권한 --%>
<script type="text/javascript">
	var sabun = "${sabun}";
	var empName = "${empName}";
</script>
<c:if test="${errMsg ne null}">
	<c:out value="${errMsg}"/>
	<script type="text/javascript">
		(function(){alert('${errMsg}')})();
	</script>
</c:if>

	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/wafCommon.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/waf/WAF001Psogm.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/waf/WAF002PsogmCreate.js"></script>
	<div class="waf_wrap psogm_wrap" id="psogm_create_wrap">
		<form:form action="${pageContext.request.contextPath}/WAF002PsogmCreate/create.do?menu=${menu}" id="psogmCreateForm" name="psogmCreateForm">
			<input type="hidden" id="menu" value="${menu}"/>
			<input type="hidden" name="tabId" value="<c:out value="${tabId}"></c:out>" />
			<input type="hidden" id="status" name="status" value=""/>
			<input type="hidden" id="managerYn" value="${manager}"/>
			<div class="m-scroll">
			<div class="top-btns fr">
				<button type="button" id="addBtn" class="AXButton Red addBtn" onclick="fn_save(this)" data-target="save">
					<spring:message code='label.save'/><!-- 저장 -->
				</button>
				<button type="button" class="AXButton Blue attachedFBtn" data-menu="${menu}">
					<span>첨부</span>
				<%-- <i class="axi axi-ion-android-search"><spring:message code='label.search'/><!-- 조회 --></i> --%>
				</button>
				<button type="button" class="AXButton Black ubiRptBtn">
					<span>발행</span>
				</button>
				<button type="button" class="AXButton Black _clearBtn_" data-target="psogmC">
					<span  data-target="psogmC">표시 클리어</span>
				</button>
			</div>
			<div class="cb pt5 " style="min-width:780px;">	
				<table class="pd-s-table first-tbl">
					<tr>
						<th>
							사업부
						</th>
						<td style="min-width: 210px;">
							<select name="comps" id="comps" disabled>
								<c:if test="${fn:length(codeList) > 0}">
									<c:forEach var="codeD2Domain" items="${codeList}" varStatus="status">
										<option value="${codeD2Domain.code2}"
											<c:if test="${codeD2Domain.code2 eq empComps}">
												selected
											</c:if>
										><c:out value="${codeD2Domain.code_name}"/></option>
									</c:forEach>
								</c:if>
							</select>
						</td>
						<th>
							지시 No
						</th>
						<td colspan="3">
							<input type="text" name="jisno" id="jisno" title="지시No을 입력해주세요" readonly/>
						</td>
					</tr>
					<tr>
						<th>
							설비 No
						</th>
						<td>
							<input autofocus="true" class="required" type="text" name="mshno" id="mshno" placeholder="설비번호를 입력해주세요" title="설비번호를 입력해주세요" maxlength="10" onfocusout="txtmshno_chk(this.value)"/>
							<button class="next-arrow" type="button" onclick="javascript:ogm312_pop_OnClick();"></button>
							<input type="text" name="txtmshnm" title="설비명" id="txtmshnm" readonly/>
							<input type="hidden" name="timcd" title="" id="timcd"/>
							<input type="hidden" name="prtcd" title="" id="prtcd"/>
						</td>
						<th>
							보 전 방 법
						</th>
						<td>
							<select id="jobcd" name="jobcd" title="라인을 선택해주세요">
								<option value=""></option>
								<c:if test="${fn:length(jobList) > 0}">
									<c:forEach var="jobDomain" items="${jobList}" varStatus="status">
										<option value="${jobDomain.jobcd}"><c:out value="${jobDomain.kogub}"/></option>
									</c:forEach>
								</c:if>
							</select>
						</td>
						<th>
							기 능 저 하
						</th>
						<td>
							<select id="kdown" name="kdown" title="선택해주세요">
								<c:forEach var="item" items="${items = [0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 49, 100]}" varStatus="status"> 
									<option><c:out value="${item}"/></option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<th>
							내외구분
						</th>
						<td>
							<select id="inocd" name="inocd" title="">
								<option value=""></option>
								<c:if test="${fn:length(inoutList) > 0}">
									<c:forEach var="inoutDomain" items="${inoutList}" varStatus="status">
										<option value="${inoutDomain.inocd}"><c:out value="${inoutDomain.inonm}"/></option>
									</c:forEach>
								</c:if>
							</select>
						</td>
						<th>
							우선도
						</th>
						<td>
							<select id="emgcd" name="emgcd" title="">
								<option value=""></option>
								<c:if test="${fn:length(emgList) > 0}">
									<c:forEach var="emgDomain" items="${emgList}" varStatus="status">
										<option value="${emgDomain.emgcd}"><c:out value="${emgDomain.emgry}"/></option>
									</c:forEach>
								</c:if>
							</select>
						</td>
						<th>
							품질확인
						</th>
						<td>
							<select id="qorcd" name="qorcd" title="">
								<option value=""></option>
								<c:if test="${fn:length(qualityList) > 0}">
									<c:forEach var="qualityDomain" items="${qualityList}" varStatus="status">
										<option value="${qualityDomain.qorcd}"><c:out value="${qualityDomain.qornm}"/></option>
									</c:forEach>
								</c:if>
							</select>
						</td>
					</tr>
				</table>
				<table class="pd-s-table">
					<%-- <tr class="ul_wrap_tr">
						<th>작업개소</th>
						<td colspan="5">
							<div>
								<ul>
									<li>
										<h3>설비부위분류</h3>
										<select name="subas" id="subas">
											<option value=""></option>
											<c:if test="${fn:length(assyList) > 0}">
												<c:forEach var="assyDomain" items="${assyList}" varStatus="status">
													<option value="${assyDomain.subas}"><c:out value="${assyDomain.assnm}"/></option>
												</c:forEach>
											</c:if>
										</select>
									</li>
									<li>
										<h3>ASSY NO</h3>
										<input type="text" placeholer="" title="" value="<c:out value="${resultDomain.assno}"/>"  readonly/>
									</li>
									<li>
										<h3>ASSY부품</h3>
										<div class="selectWrap">
											<select name="comcd" id="com" class="displayNone" onclick="initData(this)">
												<option></option>
											</select>
											<select id="com-knd">
												<option value=""></option>
												<c:if test="${fn:length(kndList) > 0}">
													<c:forEach var="kndDomain" items="${kndList}" varStatus="status">
														<option value="${kndDomain.kndcd}"><c:out value="${kndDomain.kndnm}"/></option>
													</c:forEach>
												</c:if>
											</select>
											<ul class="selectUl displayNone" id="com-umhen">
											</ul>
											<ul class="selectUl displayNone" id="com-sets">
											</ul>
										</div>
									</li>
									<li>
										<h3>단위부품</h3>
										<div class="selectWrap">
											<select name="deccd" id="dec" class="displayNone" onclick="initData(this)">
												<option></option>
											</select>
											<select id="dec-knd">
												<option value=""></option>
												<c:if test="${fn:length(unitList) > 0}">
													<c:forEach var="unitDomain" items="${unitList}" varStatus="status">
														<option value="${unitDomain.kndcd}"><c:out value="${unitDomain.kndnm}"/></option>
													</c:forEach>
												</c:if>
											</select>
											<ul class="selectUl displayNone" id="dec-umhen">
											</ul>
											<ul class="selectUl displayNone" id="dec-sets">
											</ul>
										</div>
									</li>
									<li>
										<h3>부품 No</h3>
										<input type="text" placeholer="" title="" value="<c:out value="${resultDomain.prtno}"/>"  readonly/>
									</li>
									<li>
										<h3>처치</h3>
										<select id="cho" name="chocd">
											<option value=""></option>
											<c:if test="${fn:length(choList) > 0}">
												<c:forEach var="choDomain" items="${choList}" varStatus="status">
													<option value="${choDomain.chocd}"><c:out value="${choDomain.chonm}"/></option>
												</c:forEach>
											</c:if>
										</select>
									</li>
									
								</ul>
							</div>
						</td>
					</tr> --%>
					<tr class="ul_wrap_tr maintenaceCategory">
						<th>작업개소</th>
						<td>
							<div>
								<h3>설비부위분류</h3>
								<select name="subas" id="subas">
									<option value=""></option>
									<c:if test="${fn:length(assyList) > 0}">
										<c:forEach var="assyDomain" items="${assyList}" varStatus="status">
											<option value="${assyDomain.subas}"><c:out value="${assyDomain.assnm}"/></option>
										</c:forEach>
									</c:if>
								</select>
							</div>
						</td>
						<td>
							<div>	
								<h3>ASSY NO</h3>
								<input type="text" name="assno" id="assno" placeholder="" title="" value="01"/>
							</div>
						</td>
						<td>
							<div>
								<h3>ASSY부품</h3>
								<div class="selectWrap">
									<select name="comcd" id="com" class="displayNone" onclick="initData(this)">
										<option></option>
									</select>
									<select id="com-knd">
										<option value=""></option>
										<c:if test="${fn:length(kndList) > 0}">
											<c:forEach var="kndDomain" items="${kndList}" varStatus="status">
												<option value="${kndDomain.kndcd}"><c:out value="${kndDomain.kndnm}"/></option>
											</c:forEach>
										</c:if>
									</select>
									<ul class="selectUl displayNone" id="com-umhen">
									</ul>
									<ul class="selectUl displayNone" id="com-sets">
									</ul>
								</div>
							</div>
						</td>
						<td>
							<div>
								<h3>단위부품</h3>
								<div class="selectWrap">
									<select name="deccd" id="dec" class="displayNone" onclick="initData(this)">
										<option></option>
									</select>
									<select id="dec-knd">
										<option value=""></option>
										<c:if test="${fn:length(unitList) > 0}">
											<c:forEach var="unitDomain" items="${unitList}" varStatus="status">
												<option value="${unitDomain.kndcd}"><c:out value="${unitDomain.kndnm}"/></option>
											</c:forEach>
										</c:if>
									</select>
									<ul class="selectUl displayNone" id="dec-umhen">
									</ul>
									<ul class="selectUl displayNone" id="dec-sets">
									</ul>
								</div>
							</div>
						</td>
						<td>
							<h3>부품 No</h3>
							<input type="text" name="prtno" id="prtno" placeholder="" title="" value="001"/>
						</td>
						<td>
							<div>
								<h3>처치</h3>
								<select id="cho" name="chocd">
									<option value=""></option>
									<c:if test="${fn:length(choList) > 0}">
										<c:forEach var="choDomain" items="${choList}" varStatus="status">
											<option value="${choDomain.chocd}"><c:out value="${choDomain.chonm}"/></option>
										</c:forEach>
									</c:if>
								</select>
							</div>
						</td>
					</tr>
				</table>
				<table class="pd-s-table thirdTbl">
					<tr>
						<th>현 상</th>
						<td style="min-width: 160px; width:26.5%">
							<div class="selectWrap">
								<select name="hyocd" id="hyo" class="displayNone" onclick="initData(this)">
									<option></option>
								</select>
								<select id="phenomenon" data-type="hyo">
									<option value=""></option>
									<c:if test="${fn:length(phenomenonList) > 0}">
										<c:forEach var="phenomenonDomain" items="${phenomenonList}" varStatus="status">
											<option value="${phenomenonDomain.hkind}"><c:out value="${phenomenonDomain.hkdnm}"/></option>
										</c:forEach>
									</c:if>
								</select>
								<ul class="selectUl displayNone" style="width: 200px;" id="">
								</ul>
							</div>
						</td>
						<th>
							원 인
						</th>
						<td>
							<div class="selectWrap">
								<select name="caucd" id="caucd" class="displayNone" onclick="initData(this)">
									<option></option>
								</select>
								<select id="cause" data-type="cau">
									<option></option>
									<c:if test="${fn:length(causeList) > 0}">
										<c:forEach var="causeDomain" items="${causeList}" varStatus="status">
											<option value="${causeDomain.ckind}"><c:out value="${causeDomain.ckdnm}"/></option>
										</c:forEach>
									</c:if>
								</select>
								<ul class="selectUl displayNone" id="" style="width: 200px;" >
								</ul>
							</div>
						</td>
						<th>
							실 원 인
						</th>
						<td>
							<div class="selectWrap">
								<select name="trucd" id="trucd" class="displayNone" onclick="initData(this)">
									<option></option>
								</select>
								<select id="truC"  data-type="truC">
									<option></option>
									<c:if test="${fn:length(trueCauseList) > 0}">
										<c:forEach var="trueCause" items="${trueCauseList}" varStatus="status">
											<option value="${trueCause.tkind}"><c:out value="${trueCause.tkdnm}"/></option>
										</c:forEach>
									</c:if>
								</select>
								<ul class="selectUl displayNone" id="" style="width: 200px;" >
								</ul>
							</div>
						</td>
					</tr>
				</table>
				<table class="pd-s-table time_tbl">
					<caption>사업부 선택표</caption>
					<colgroup></colgroup>
					<tbody>
						<tr>
							<th>발생일시</th>
							<td style="width:26.5%">
								<div data-ax5picker="basic" style="display: inline-block;">
									<input type="text" name="padat" id="padat" style="width:120px;" maxlength="10" value="<fmt:formatDate value="${today}" pattern="yyyy-MM-dd"/>"/>
								</div>
								<input type="text"  name="patim" id="patim" style="min-width: 60px; width: 20%;" placeholder="hh:mi" data-ax5formatter="time" title=""/>
							</td>
							<th>수리대기시간</th>
							<td colspan="2">
								<input type="text" name="wathr" style="width: 95%;" placeholder="" title="" readonly/>
							</td>
							<th>설비정지시간</th>
							<td colspan="2">
								<input type="text" name="stphr" style="width: 95%;" placeholder="" title="" readonly/>
							</td>
							<td colspan="2"rowspan="4" style="border-left: 1px solid #dadada; width:390px;">
								<div>
									<h4>외주업자</h4>
									<textarea rows="3" cols="" name="subcn" style="width: 95%"></textarea>
									<div class="fr">
										<h4 style="display: inline-block;">비용</h4>
										<input type="number" name="scost" id="scost" placeholder="" title="" value="0"/> 천원
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<th>의뢰일시</th>
							<td>
								<div data-ax5picker="basic_reg" style="display: inline-block;">
									<input type="text" name="urdat" id="urdat" style="width:120px;" maxlength="10" value="<fmt:formatDate value="${today}" pattern="yyyy-MM-dd"/>"/>
								</div>
								<input type="text" name="urtim" id="urtim" style="min-width: 60px; width:20%;" placeholder="hh:mi" data-ax5formatter="time" title=""/>
							</td>
							<td colspan="2" rowspan="3" style="border-left: 1px solid #dadada;">
								<div style="min-width:180px;">
									<h4>작업시간</h4>
									<div>
										<span class="title">준비</span>
										<input type="number" id="bfrhr" name="bfrhr" placeholder="" title="" style="width: 30%;" value="0"> 분
									</div>
									<div>
										<span class="title">실보전시간</span>
										<input type="number" id="wrkhr" name="wrkhr" placeholder="" title="" style="width: 30%;" value="0"> 분
									</div>
								</div>
							</td>
							<td colspan="4" rowspan="3" style="border-left: 1px solid #dadada;">
								<div>
									<h4>책임</h4>
									<div>
										<span class="title">책임자</span>
										<input type="text" class="required" name="wrkm" id="wrkm" placeholder="" title="" onfocusout="getName(this)" value='<c:out value="${sabun}"/>' style="width: 30%;">
										<input type="text" name="" id="" placeholder="" title="" value='<c:out value="${empName}"/>' disabled style="width: 30%;">
										<input type="hidden" name="sdpcd" id="sdpcd" placeholder="" title="">
										<input type="hidden" name="dptcd" id="dptcd" placeholder="" title="">
									</div>
									<div>
										<span class="title">부책임자</span>
										<input type="text" name="wrkm2" id="wrkm2" placeholder="" title="" onfocusout="getName(this)" style="width: 30%;">
										<input type="text" placeholder="" title="" style="width: 30%;" disabled>
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<th>개시일시</th>
							<td>
								<div data-ax5picker="basic_open" style="display:inline-block">
									<input type="text" class="required" name="ksdat" id="ksdat" style="width:120px;" maxlength="10" value="<fmt:formatDate value="${today}" pattern="yyyy-MM-dd"/>"/>
								</div>
								<input type="text" class="required" name="kstim" id="kstim" style="min-width: 60px; width: 20%;"  placeholder="hh:mi" data-ax5formatter="time" title=""/>
							</td>
						</tr>
						<tr>
							<th>완료일시</th>
							<td>
								<div data-ax5picker="basic_wan" style="display:inline-block">
									<input type="text" name="wndat" id="wndat" style="width:120px;" maxlength="10" value="<fmt:formatDate value="${today}" pattern="yyyy-MM-dd"/>"/>
								</div>
								<input type="text" name="wntim" id="wntim" style="min-width: 60px; width: 20%;"  placeholder="hh:mi" data-ax5formatter="time" title=""/>
							</td>
						</tr>
					</table>
					<table class="pd-s-table">
						<caption>사업부 선택표</caption>
						<colgroup></colgroup>
						<tbody>
						<tr>
							<th>생산장애시간</th>
							<td style="min-width: 160px; width:26.5%;" colspan="4">
								<input type="number" id="janhr" name="janhr" style="width: 20%;" placeholder="" title="" value="0.0"/> H
							</td>
							<th>재발방지</th>
							<td class="mw145">
								<select name="repcd" id="repcd">
									<option value=""></option>
									<c:if test="${fn:length(relapseList) > 0}">
										<c:forEach var="relapseDomain" items="${relapseList}" varStatus="status">
											<option value="${relapseDomain.repcd}"><c:out value="${relapseDomain.repnm}"/></option>
										</c:forEach>
									</c:if>
								</select>
							</td>
							<th>효과구분</th>
							<td class="effectTd" colspan="2">
								<div class="selectWrap">
									<select name="effcd" id="eff" class="displayNone" onclick="initData(this)">
										<option></option>
									</select> 
									<select id="effect" data-type="eff">
										<option value=""></option>
										<c:if test="${fn:length(effectList) > 0}">
											<c:forEach var="effctDomain" items="${effectList}" varStatus="status">
												<option value="${effctDomain.effcd}"><c:out value="${effctDomain.effnm}"/></option>
											</c:forEach>
										</c:if>
									</select>
									<ul class="selectUl displayNone" style="width: 200px;" id="">
									</ul>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
				<table class="pd-s-table last_tbl">
					<caption>사업부 선택표</caption>
					<colgroup></colgroup>
					<tbody>
						<tr>
							<th>현상파악</th>
							<td><textarea class="required" name="hyosn" id="hyosn"><c:out value="${resultDomain.hyosn}"/></textarea></td>
						</tr>
						<tr>
							<th>원인추구</th>
							<td><textarea name="wonin" id="wonin"><c:out value="${resultDomain.wonin}"/></textarea></td>
						</tr>
						<tr>
							<th>처치</th>
							<td><textarea name="daech" id="daech"><c:out value="${resultDomain.daech}"/></textarea></td>
						</tr>
						<tr>
							<th>작업완료</th>
							<td>
								<input type="text" id="cmplt" name="cmplt" placeholder="" title="" onfocusout="chk_complete(this)">
								<input type="text" placeholder="" title="" value="미완료" disabled>
							</td>
						</tr>
					</tbody>
				</table>
				<div class="r_tbl_wrap">
					<table class="pd-s-table">
						<caption>교환부품표</caption>
						<colgroup></colgroup>
						<tbody>
							<tr>
								<td  style="text-align: center; width:14.5%; min-width:73px;">
									<button type="button" class="AXButton Normal improveBtn" data-target="imprv">개선상세</button>
								</td>
								<td colspan="3">
									<span>비용</span>
									<input type="number" name="ecost" id="ecost" placeholder="" title="" value="0" readonly> 천원
								</td>
							</tr>
							<tr>
								<td style="text-align: center;">
									<button type="button" class="AXButton Normal changeUnitBtn" data-menu="${menu}"  data-target="change">교환부품</button>
								</td>
								<td colspan="3">
									<span>비용</span>
									<input type="number" id="pcost" name="pcost" placeholder="" title="" value="0" readonly> 천원
								</td>
							</tr>
						</tbody>
					</table>
					<div class="scrollDiv">
						<table class="pd-s-table last_tbl_r1 changeUnitTable">
							<thead>
								<tr>
									<th>부품명</th>
									<th>규격</th>
									<th>수량</th>
									<th>금액</th>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
					</div>
					<table class="pd-s-table last_tbl_r2">
						<caption></caption>
						<colgroup></colgroup>
						<tbody>
							<tr>
								<th>비고</th>
								<td><textarea name="cnote"><c:out value="${resultDomain.cnote}"/></textarea></td>
							</tr>
						</tbody>
					</table>
					</div>
				</div>
			</div>
		</form:form>
	</div>

</c:if>