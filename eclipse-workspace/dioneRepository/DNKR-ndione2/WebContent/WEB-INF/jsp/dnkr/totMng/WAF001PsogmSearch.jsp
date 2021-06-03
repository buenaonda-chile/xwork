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

<jsp:useBean id="today" class="java.util.Date"/>

<%-- <spring:message code="label.filename" /> : <c:out value="${url }"></c:out> --%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/wafCommon.css" />

<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/content.js"></script> --%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/waf/WAF001Psogm.js"></script>

<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%-- 조회권한 --%>
	<div class="waf_wrap psogm_wrap">	
		<form id="psogmSearchForm" name="psogmSearchForm">
			<input type="hidden" id="andor" name="andor" value="and"/>
			<input type="hidden" id="gogub" name="gogub" value=" ('BM','PM','CM')"/>
			<div class="top-btns fr">
				<button type="button" class="AXButton Black _searchBtn_">
					<i class="axi axi-ion-android-search"><spring:message code='label.search'/><!-- 조회 --></i>
				</button>
				<button type="button" class="AXButton Black _clearBtn_" onclick="" data-target="psogmC">
					<span>표시 클리어</span>
				</button>
			</div>
			<div class="cb pt5">	
				<table class="pd-s-table line-table first-tbl">
					<tr>
						<th>
							사업부
						</th>
						<td>
							<select autofocus="true" name="comps" id="comps">
								<c:if test="${fn:length(codeList) > 0}">
									<c:forEach var="codeD2Domain" items="${codeList}" varStatus="status">
										<option value="${codeD2Domain.code2}"><c:out value="${codeD2Domain.code_name}"/></option>
									</c:forEach>
								</c:if>
							</select>
						</td>
						<th>
							지시 No
						</th>
						<td colspan="3">
							<input type="text" id="txtjisno" title="내용을 입력해주세요" onfocusout="txtjisno_OnKillFocus()"/>
						</td>
					</tr>
					<tr>
						<th>
							파트 No
						</th>
						<td>
							<select name="prtcd" id="prtcd">
								<option value=""></option>
								<c:if test="${fn:length(partList) > 0}">
									<c:forEach var="partDomain" items="${partList}" varStatus="status">
										<option value="${partDomain.prtcd.trim()}"><c:out value="${partDomain.prtnm.trim()}"/></option>
									</c:forEach>
								</c:if>
							</select>
						</td>
						<th rowspan="3">
							보전<br><br>
							작업<br><br>
							구분
						</th>
						<td style="width: 100px;" rowspan="3">
							<div class="checkDiv">
								<div>
									<input id="bm" class="radio-st01" type="checkbox" checked><label for="bm"><span class="radio-deco"></span> BM</label>
								</div>
								<div>
									<input id="pm" class="radio-st01" type="checkbox" checked><label for="pm"><span class="radio-deco"></span> PM</label>
								</div>
								<div>
									<input id="cm" class="radio-st01" type="checkbox" checked><label for="cm"><span class="radio-deco"></span> CM</label>
								</div>
							</div>
						</td>
						<th>
							보전방법
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
					</tr>
					<tr>
						<th>
							라인
						</th>
						<td>
							<select id="lincd" name="lincd" title="라인을 선택해주세요">
								<option value=""></option>
								<c:if test="${fn:length(lineList) > 0}">
									<c:forEach var="lineDomain" items="${lineList}" varStatus="status">
										<option value="${lineDomain.lincd}"><c:out value="${lineDomain.linnm}"/></option>
									</c:forEach>
								</c:if>
							</select>
						</td>
						<th>
							실시부서
						</th>
						<td>
							<select id="sdpcd" name="sdpcd" title="부서를 선택해주세요">
								<option value=""></option>
								<c:if test="${fn:length(sdeptList) > 0}">
									<c:forEach var="sdeptDomain" items="${sdeptList}" varStatus="status">
										<option value="${sdeptDomain.sdpcd}"><c:out value="${sdeptDomain.sdpnm}"/></option>
									</c:forEach>
								</c:if>
							</select>
						</td>
					</tr>
					<tr>
						<th>
							설비
						</th>
						<td>
							<input type="text" name="mshno" id="mshno" placeholder="설비번호를 입력해주세요" title="설비번호를 입력해주세요" maxlength="10" onfocusout="txtmshno_chk(this.value)"/>
							<button class="next-arrow" type="button" onclick="javascript:ogm312_pop_OnClick();"></button>
							<input type="text" name="txtmshnm" title="설비명" id="txtmshnm" readonly/>
						</td>
						<th>
							책임자
						</th>
						<td>
							<input type="text" id="wrkm" name="wrkm" placeholder="사번을 입력해주세요 " title="사번을 입력해주세요 " onfocusout="getName(this)"/>
							<!-- <input type="text" id="wrkm" name="wrkm" placeholder="사번을 입력해주세요 " title="사번을 입력해주세요 " onfocusout="getogm200_hmd020pf(this.value)" onkeypress="return false;"/> -->
							<input type="text" title="사원명" id="kornm" readonly/>
						</td>
					</tr>
				</table>
			</div>
			<div class="date">
				<div data-ax5picker="basic">
					검색개시일 &nbsp;
					<input type="text" name="wndats" id="wndats" style="width:120px;" placeholder="yyyy-mm-dd" data-ax5formatter="date" value="<c:out value="${beforeMonth}"/>"/>
		            ~ 검색종료일 &nbsp;
		            <input type="text" name="wndate" id="wndats" style="width:120px;" placeholder="yyyy-mm-dd" data-ax5formatter="date" value="<fmt:formatDate value="${today}" pattern="yyyy-MM-dd"/>"/>
				</div>
			</div>
			<div class="maintenaceCategory">
				<ul>
					<li>
						<p class="s-title">보전작업구분</p>
					</li>
					<li>
						<h3>ASSY분류</h3>
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
						<h3>셋트부품</h3>
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
						<!-- <div>
							<input type="text" title="" readonly/>
						</div> -->
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
						<!-- <div>
							<input type="text" title="" readonly/>
						</div> -->
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
			<div class="status">
				<ul>
					<li>
						<div>
							<span class="title">현상</span>
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
						</div>
						<!-- <input type="text" title="현상" readonly> -->
					</li>
					<li>
						<div>
							<span class="title">원인</span>
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
						</div>
						<!-- <input type="text" title="원인" readonly> -->
					</li>
					<li>
						<div>
							<span class="title">실원인</span>
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
						</div>
						<!-- <input type="text" title="실원인" readonly> -->
					</li>
				</ul>
			</div>
			
			<div class="textSearchBox">
				<p class="s-title">문자검색</p>
				<table class="textSearchTbl">
						<colgroup>
							<col width="40px">
							<col width="120px">
							<col width="*">
							<col width="50px">
							<col width="*">
							<col width="50px">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<td rowspan="3" class="last" >
									<button class="red btn-st02 and andBtn" type="button" data-symb="&">
										<span>AND</span>
									</button>
									<div class="sssgap"></div>
									<button class="black btn-st02 or orBtn" type="button" data-symb="Or">
										<span>OR</span>
									</button>
								</td>
								<th class="tr">현상파악</th>
								<td>
									<input id="hyosn" name="hyosn" title="내용을 입력해주세요" type="text">
								</td>
								<td class="logicSymb">&amp;</td>
								<td>
									<input id="hyosn2" name="hyosn2" title="내용을 입력해주세요" type="text">
								</td>
								<td class="logicSymb">&amp;</td>
								<td>
									<input id="hyosn3" name="hyosn3" title="내용을 입력해주세요" type="text">
								</td>
							</tr>
							<tr>
								<th class="tr">원인추구</th>
								<td>
									<input id="wonin" name="wonin" title="내용을 입력해주세요" type="text">
								</td>
								<td class="logicSymb">&amp;</td>
								<td>
									<input id="wonin2" name="wonin2" title="내용을 입력해주세요" type="text">
								</td>
								<td class="logicSymb">&amp;</td>
								<td>
									<input id="wonin3" name="wonin3" title="내용을 입력해주세요" type="text">
								</td>
							</tr>
							<tr>
								<th class="tr">대책</th>
								<td>
									<input id="daech" name="daech" title="내용을 입력해주세요" type="text">
								</td>
								<td class="logicSymb">&amp;</td>
								<td>
									<input id="daech2" name="daech2" title="내용을 입력해주세요" type="text">
								</td>
								<td class="logicSymb">&amp;</td>
								<td>
									<input id="daech3" name="daech3" title="내용을 입력해주세요" type="text">
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</form>
			<div class="gap"></div>
		</div><!--psogm_wrap-->

</c:if>