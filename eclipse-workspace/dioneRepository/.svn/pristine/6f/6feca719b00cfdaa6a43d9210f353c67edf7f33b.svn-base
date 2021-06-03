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
<!-- 강제입고등록 -->

<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%-- 조회권한 --%>
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/wafCommon.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/waf/WAF001Psogm.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/waf/WAF004PsogmForceICreate.js"></script>
	<style>
		.psogmFIC_wrap .last-tbl tr:first-child input{
			width: 85%;
			/*min-width: 80px;*/
			min-width:50px;
			text-align: right;
		}
	</style>
	<div class="waf_wrap psogmFIC_wrap">
			<form id="searchForm" name="searchForm">
				<div class="top-btns fr">
					<button class="AXButton Black iSearchBtn" data-target="search" onclick="return false;">
						<i class="axi axi-ion-android-search"></i><spring:message code='label.search'/><!-- 조회 -->
					</button>
					<button class="AXButton Red addBtn"  onclick="return false;">
						<spring:message code='label.add'/><!-- 조회 -->
					</button>
					<button type="button" class="downLoad _excelBtn_">
						<span><spring:message code='label.excelDown' /><!-- 엑셀다운 --></span>
					</button>		
				</div>
				<div class="cb pt5">
				<table class="pd-s-table">
					<colgroup>
						<col/>
						<col/>
						<col/>
						<col/>
						<col/>
						<col/>
					</colgroup>
					<tbody>
						<tr>
							<th>
								사업부
							</th>
							<td>
								<select name="" id="comps" disabled>
									<c:if test="${fn:length(codeList) > 0}">
										<c:forEach var="codeD2Domain" items="${codeList}" varStatus="status">
											<option value="${codeD2Domain.code2}"><c:out value="${codeD2Domain.code_name}"/></option>
										</c:forEach>
									</c:if>
								</select>
							</td>
							<th>
								분류
							</th>
							<td>
								<select id="groupSelect" title="선택해주세요" disabled>
									<option value="1" selected>예비품</option>
									<option value="2">비품</option>
									<option value="3">식자재</option>
								</select>
								<input type="hidden" id="group" name="group" value="1"/>
							</td>
							<th>
								입고일자
							</th>
							<td colspan="2" style="width: 40%">
								<div class="fl" data-ax5picker="basic" style="display: inline-block;">
									<%-- <input type="text" name="" id="" style="width:120px;" maxlength="10" value="<fmt:formatDate value="${today}" pattern="yyyy-MM-dd"/>"/> --%>
									<input type="text" name="indatfrom" id="" style="width:120px;" maxlength="10" value="<c:out value="${firstDay}"/>"/>
									~ <input type="text" name="indatto" id="" style="width:120px;" maxlength="10" value="<c:out value="${today}"/>"/> 
								</div>
							</td>
						</tr>
						<tr>
							<th>
								Part No
							</th>
							<td colspan="3">
								<input type="text" name="prtno" id="prtno" title="" placeholder="" maxlength=""/>
								<input type="text" name="" id="" title="" placeholder="" maxlength="" disabled/>
								<!-- <button class="black btn-st02">
									<i class="axi axi-ion-android-search"></i>
								</button> -->
								<button class="AXButton Black searchBtn" onclick="return false;" data-target="prtno" data-menu='<c:out value="${menu}"/>'>
									<i class="axi axi-ion-android-search"></i>
								</button>
							</td>
							<th>
								구입선
							</th>
							<td colspan="2">
								<input type="text" name="vndnr" id="vndnr" maxlength="10" title="" placeholder=""/>
								<input type="text" name="" id="" title="" placeholder="" maxlength="" disabled/>
								<!-- <button class="black btn-st02">
									<i class="axi axi-ion-android-search"></i>
								</button> -->
								<button class="AXButton Black searchBtn"  data-target="vndnr"  onclick="return false;" data-menu='<c:out value="${menu}"/>'>
									<i class="axi axi-ion-android-search"></i>
								</button>
							</td>
					</tbody>
				</table>
			</form>
		</div>
		<div class="sssgap"></div>
		<div style="position: relative;height:400px;" id="grid-parent">
		    <div data-ax5grid="psogmFIC-grid" data-ax5grid-config="{
		                    showLineNumber: true,
		                    showRowSelector: true,
		                    sortable: true,
		                    header: {align:"center"}
		                    }" style="height: 100%;"></div>
		</div>	
		<div class="sssgap"></div>
		<div style="min-height: 200px;">
			<form:form  action='${pageContext.request.contextPath}/WAF004PsogmForceICreate/create.do?tabId=${tabId}&menu=${menu}' id="createForm" name="">
				<input type="hidden" name="group" id="" style="width:120px;" maxlength="10" title="" placeholder="" value="1"/><!-- 분류(예비품) -->
				<table class="pd-s-table">
					<colgroup>
						<col/>
						<col/>
						<col/>
						<col/>
						<col/>
						<col/>
					</colgroup>
					<tbody>
						<tr>
							<th>입고번호</th>
							<td><input type="text" name="" id="inpno" maxlength="10" title="" placeholder=""/></td>
							<th>입고일자</th>
							<td>
								<div data-ax5picker="basic2" style="display: inline-block;">
									<input type="text" name="indat" id="indat" style="width:120px;" maxlength="10" title="" placeholder="" value="<c:out value="${today}"/>"/>
								</div>
							</td>
							<th>입고담당자</th>
							<td>
								<input type="text" name="indid" id="emp" maxlength="" title="" placeholder="" value="<c:out value="${sabun}"/>" onfocusout="getName(this)" onkeydown="return onlyNum(event)"/>
								<input type="text" name="" id="" title="" placeholder="" maxlength="" value="<c:out value="${empName}"/>" disabled/>
								<!-- <button class="black btn-st02">
									<i class="axi axi-ion-android-search"></i>
								</button> -->
								<button class="AXButton Black searchBtn" data-target="emp" onclick="return false;" data-menu='<c:out value="${menu}"/>'>
									<i class="axi axi-ion-android-search"></i>
								</button>
							</td>
						</tr>
						<tr>
							<th>Part No</th>
							<td colspan="3">
								<input type="text" name="prtno" id="prtno2" maxlength="" title="" placeholder="" onfocusout="getPartInfo(this.value)"/>
								<input type="text" name="" id="" title="" placeholder="" maxlength="" disabled/>
								<!-- <button class="black btn-st02">
									<i class="axi axi-ion-android-search"></i>
								</button> -->
								<button class="AXButton Black searchBtn" data-target="prtno2" onclick="return false;" data-menu='<c:out value="${menu}"/>'>
									<i class="axi axi-ion-android-search"></i>
								</button>
								<input type="text" name="model" id="model" title="" placeholder="" maxlength="" disabled/>
							</td>
							<th>구입선</th>
							<td>
								<input type="text" name="vndnr" id="vndnr2" maxlength="" title="" placeholder="" />
								<input type="text" name="vname" id="vname" title="" placeholder="" maxlength="" disabled/>
								<!-- <button class="black btn-st02">
									<i class="axi axi-ion-android-search"></i>
								</button> -->
								<button class="AXButton Black searchBtn"  data-target="vndnr2" onclick="return false;">
									<i class="axi axi-ion-android-search"></i>
								</button>
							</td>
					</tbody>
				</table>
				<table class="pd-s-table last-tbl" style="border-top: none">
					<colgroup>
						<col/>
						<col/>
						<col/>
						<col/>
						<col/>
						<col/>
					</colgroup>
					<tbody>
						<tr>
							<th>재고수량</th>
							<td>
								<input type="number" name="qty" id="jg" title="" placeholder="" maxlength=""/>
							</td>
							<th>입고수량</th>
							<td>
								<input type="number" name="inqty" id="inqty" value="0" onkeydown="return onlyNum(event)" onfocusout="calcuCost(this.value)" title="" placeholder="" maxlength=""/>
							</td>
							<th>평균단가</th>
							<td>
								<input type="number" name="pcost" id="pcost" title="" placeholder="" maxlength=""/>
							</td>
							<th>입고단가</th>
							<td>
								<input type="number" name="icost" id="icost" title="" placeholder="" maxlength=""/>
							</td>
							<th>입고금액</th>
							<td>
								<input type="number" name="iamt" id="iamt" title="" placeholder="" maxlength="">
							</td>
						</tr>
						<tr>
							<th>용도</th>
							<td colspan="9">
								<input type="text" name="inuse" id="inuse" title="" placeholder="" maxlength="" style="width: 99%"/>
							</td>
						</tr>
					</tbody>
				</table>
			</form:form>
		</div>
	</div>
	
</c:if>