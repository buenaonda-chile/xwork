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
<!-- 금형진척현황조회 -->

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/content.css?ver" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/wafCommon.css" />
<script src="${pageContext.request.contextPath}/js/waf/WAF012Psfac.js"></script>
<style>
	.jin_cbox_01 {
	    width: 100px;
	    height: 27px;
	    background-color: #00FF00;
	    border: 0.5px solid #000;
	    float: right;
	}
	
	.jin_cbox_02 {
	    width: 100px;
	    height: 27px;
	    background-color: #FFFF00;
	    border: 1px solid #000;
	    float: right;
	}
	
	.jin_cbox_03 {
	    width: 100px;
	    height: 27px;
	    background-color: #FF0000;
	    border: 1px solid #000;
	    /* margin-right: 0px; */
	    float: right;
	}
	
	.limeColor {
		background-color: #00FF00;
	}
	
	.yellowColor {
		background-color: #FFFF00;
	}
	
	.redColor {
		background-color: #FF0000;
	}
</style>
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%-- 조회권한 --%>
<jsp:useBean id="today" class="java.util.Date"/>
	<div class="waf_wrap">
		<form name="psfacForm" id="psfacForm">
		<div class="top-btns fr">
			<button type="button" class="AXButton Black _searchBtn_">
				<i class="axi axi-ion-android-search"><spring:message code='label.search'/><!-- 조회 --></i>
			</button>
			<button type="button" class="downLoad _excelBtn_ xlsDown">
				<span><spring:message code='label.excelDown' /><!-- 엑셀다운 --></span>
			</button>
		</div>
		<div class="cb pt5"></div>
			<table class="pd-s-table">
				<caption>사업부, 작업완료구분, 품번, 리플레시타임, 범례 내용이 담긴 표</caption>
				<colgroup>
					<col style="" />
					<col style="" />
					<col style="" />
					<col style="" />
					<col style="" />
					<col style="" />
					<col style="" />
				</colgroup>
				<tbody>
					<tr>
						<th>
							사업부
						</th>
						<td>
							<select autofocus="true" name="comps" id="ComboBoxPlant" dataSet="ds_ComCode_PLNT">
								<c:if test="${fn:length(codeList) > 0}">
									<c:forEach var="codeD2Domain" items="${codeList}" varStatus="status">
										<option value="${codeD2Domain.code2}"><c:out value="${codeD2Domain.code_name}"/></option>
									</c:forEach>
								</c:if>
							</select>
						</td>
						<th>
							작업완료구분
						</th>
						<td>
							<select name="smgdth" title="작업완료 구분을 선택해주세요">
								<option value="">전체</option>
								<option value="1">완료</option>
								<option value="0">진행</option>
							</select>
						</td>
						<th>
							품번
						</th>
						<td colspan="1">
							<input name="itmno" type="text" title="품번을 입력하세요"/>
						</td>
						<td colspan="3">
							<span style="margin:0 10px 0 10px;">
								기준일 : <fmt:formatDate value="${today}" pattern="yyyy - MM - dd"/>
							</span>
						</td>
					</tr>
					<tr>
						<th>
							범례
						</th>
						<td>
							<div class="jin_cbox_01 fr"></div>
						</td>
						<td><b>: ~ 1 %</b></td>
						<td>
							<div class="jin_cbox_02 fr"></div>
						</td>
						<td><b>: 1 ~ 10 %</b></td>
						<td>
							<div class="jin_cbox_03 fr"></div>
						</td>
						<td><b>: 10% ~ </b></td>
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
		<div class="sgap"></div>
		<div class="grid-parent">
			<div data-ax5grid="mold-grid" data-ax5grid-config="{
	                    showLineNumber: true,
	                    showRowSelector: true,
	                    sortable: true,
	                    header: {align:"center"}
	                    }" style="height: 400px">
             </div>
		</div>
	</div>
</c:if>