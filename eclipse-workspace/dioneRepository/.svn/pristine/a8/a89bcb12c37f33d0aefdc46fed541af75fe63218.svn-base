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

<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%-- 조회권한 --%>
<jsp:useBean id="today" class="java.util.Date"/>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/wafCommon.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/waf/WAF008PsogmProdStatus.js"></script>
	<div class="waf_wrap" id="prodStatus_wrap">
		<form name="prodStatusForm" id="prodStatusForm">
		<div class="top-btns fr">
			<button type="button" class="AXButton Black _searchBtn_" onclick="javascript:searchData();">
				<i class="axi axi-ion-android-search">조회</i>
			</button>
		</div>
		<div class="cb pt5"></div>
			<table class="pd-s-table">
				<colgroup>
					<col style="width:120px;" />
					<col style="width:300px;" />
					<col style="width:120px;" />
					<col style="width:*px" />
				</colgroup>
				<tbody>
					<tr>
						<th>
							사업부
						</th>
						<td colspan="9">
							<select autofocus="true" name="comps" id="comp">
								<c:if test="${fn:length(codeList) > 0}">
									<c:forEach var="codeD2Domain" items="${codeList}" varStatus="status">
										<option value="${codeD2Domain.code2}"><c:out value="${codeD2Domain.code_name}"/></option>
									</c:forEach>
								</c:if>
							</select>
						</td>
					</tr>
					<tr>
						<th>
							작업일자
						</th>
						<td colspan="3">
							<div data-ax5picker="basic">
								<input type="text" name="ordat" id="" style="width:120px;" maxlength="10" value="<fmt:formatDate value="${today}" pattern="yyyy-MM-dd"/>"/>
							</div>
						</td>
						<th>
							주야구분
						</th>
						<td>
							<select id="daygu" name="daygu">
								<option value="">전체</option>
								<option value="D" selected>주간</option>
								<option value="N">야간</option>
							</select>
						</td>
						<th>
							화면선택
						</th>
						<td>
							<select id="rowgb" name="rowgb" style="width: 150px;">
								<option value="1">2공장2층, 3공장2층 외</option>
								<option value="2">3공장2층 외, 전자공장</option>
								<option value="3">전자공장, 성형반</option>
							</select>
						</td>
						<th>
							리플레시 타임
						</th>
						<td>
							<select id="replayTime">
								<option value="10">10</option>
								<option value="20">20</option>
								<option value="30">30</option>
								<option value="40">40</option>
								<option value="50">50</option>
								<option value="60">60</option>
								<option value="0" selected>정지</option>
							</select>
						</td>
						 
					</tr>
				</tbody>
			</table>
		</form>
		<div id="updateTime" style="text-align: right">
			<span>갱신시간 : <fmt:formatDate value="${today}" pattern="yyyy년  MM월 dd일 HH시 mm분 ss초"/></span>
		</div>
		
		<div class="content">
			<div class="grid-parent">
				<h3>2공장2층</h3>
				<div data-ax5grid="first-grid" data-ax5grid-config="{
				                    showLineNumber: true,
				                    showRowSelector: true,
				                    sortable: true,
				                    header: {align:"center"}
				                    }" style="height: 100%;">
                </div>
                <div class="ssgap"></div>
				<div>
					<h3>2공장 2층</h3>
					<table class="pd-s-table line-table" id="sumTable0">
						<colgroup>
							<col style="" />
							<col style="" />
							<col style="" />
							<col style="" />
						</colgroup>
						<tbody>
							<tr>
								<th>
									생산계획 합계
								</th>
								<th>
									생산능력 합계
								</th>
								<th>
									생산실적 합계
								</th>
								<th>
									실적/계획 %
								</th>
								<th>
									실적/능력 %
								</th>
							</tr>
							<tr>
								<td class="sum1">
								</td>
								<td class="sum2">
								</td>
								<td class="sum3">
								</td>
								<td class="per1">
								</td>
								<td class="per2">
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="ssgap"></div> 
				<div>
					<h3>전자공장</h3>
					<table class="pd-s-table line-table" id="sumTable2">
						<colgroup>
							<col style="" />
							<col style="" />
							<col style="" />
							<col style="" />
						</colgroup>
						<tbody>
							<tr>
								<th>
									생산계획 합계
								</th>
								<th>
									생산능력 합계
								</th>
								<th>
									생산실적 합계
								</th>
								<th>
									실적/계획 %
								</th>
								<th>
									실적/능력 %
								</th>
							</tr>
							<tr>
								<td class="sum1">
								</td>
								<td class="sum2">
								</td>
								<td class="sum3">
								</td>
								<td class="per1">
								</td>
								<td class="per2">
								</td>
							</tr>
						</tbody>
					</table>
				</div>                    
			</div>
			<div class="grid-parent">
				<h3>3공장2층 외</h3>
				<div data-ax5grid="second-grid" data-ax5grid-config="{
				                    showLineNumber: true,
				                    showRowSelector: true,
				                    sortable: true,
				                    header: {align:"center"}
				                    }" style="height: 100%;">
                </div>
                <div class="ssgap"></div>
				<div>
					<h3>3공장 2층 외</h3>
					<table class="pd-s-table line-table" id="sumTable1">
						<colgroup>
							<col style="" />
							<col style="" />
							<col style="" />
							<col style="" />
						</colgroup>
						<tbody>
							<tr>
								<th>
									생산계획 합계
								</th>
								<th>
									생산능력 합계
								</th>
								<th>
									생산실적 합계
								</th>
								<th>
									실적/계획 %
								</th>
								<th>
									실적/능력 %
								</th>
							</tr>
							<tr>
								<td class="sum1">
								</td>
								<td class="sum2">
								</td>
								<td class="sum3">
								</td>
								<td class="per1">
								</td>
								<td class="per2">
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="ssgap"></div> 
				<div>
					<h3>성형반</h3>
					<table class="pd-s-table line-table" id="sumTable3">
						<colgroup>
							<col style="" />
							<col style="" />
							<col style="" />
							<col style="" />
						</colgroup>
						<tbody>
							<tr>
								<th>
									생산계획 합계
								</th>
								<th>
									생산능력 합계
								</th>
								<th>
									생산실적 합계
								</th>
								<th>
									실적/계획 %
								</th>
								<th>
									실적/능력 %
								</th>
							</tr>
							<tr>
								<td class="sum1">
								</td>
								<td class="sum2">
								</td>
								<td class="sum3">
								</td>
								<td class="per1">
								</td>
								<td class="per2">
								</td>
							</tr>
						</tbody>
					</table>
				</div> 
			</div>
		</div>
	</div>
</c:if>