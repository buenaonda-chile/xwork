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
<style>
/* .waf_wrap h1 {
    text-align: center;
    border: 1px solid #bbb;
    
    width: 400px;
    margin: auto;
    height: 35px;
    line-height: 35px;
}

.waf_wrap h1 span {
    left: 0;
    display: inline-block;
    float: left;
    width: 150px;
    border-right: 1px solid #bbb;
    background: #ffebea;
}

.mon-plan-table label{
	margin-bottom: 0;
} */
</style>
<script src="${pageContext.request.contextPath}/js/waf/WAF006PsogmMonPerform.js?ver=2"></script>
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%-- 조회권한 --%>
<div class="waf_wrap waf_monPerform_wrap">
	<div class="list-top">
		<h1><span><fmt:formatDate value="${today}" pattern="yyyy"/></span>年度 月別 計劃 對 實績</h1>
		
		<div style="text-align: right;">
			<button type="button" class="AXButton Black _searchBtn_">
				<i class="axi axi-ion-android-search"><spring:message code='label.search'/><!-- 조회 --></i>
			</button>
			<button type="button" class="downLoad _excelBtn_">
				<span><spring:message code='label.excelDown' /><!-- 엑셀다운 --></span>
			</button>
		</div>
		<div class="sssgap"></div>	
		<table class="pd-s-table mon-plan-table">
			<caption>사업부 선택표</caption>
			<colgroup></colgroup>
			<tbody>
				<tr>
					<th>사업부</th>
					<td style="width: 20%">
						<select autofocus="true" name="comps" id="ComboBoxPlant" dataSet="ds_ComCode_PLNT">
							<c:if test="${fn:length(codeList) > 0}">
								<c:forEach var="codeD2Domain" items="${codeList}" varStatus="status">
									<option value="${codeD2Domain.code2}"><c:out value="${codeD2Domain.code_name}"/></option>
								</c:forEach>
							</c:if>
						</select>
					</td>
					<th>기준년월</th>
					
					<td>
						<div data-ax5picker="basic">
							<input name="year" type="text" id="waf006Calendar" placeholder="yyyy"  data-picker-date="year" value='<fmt:formatDate value="${today}" pattern="yyyy"/>'/>
						</div>
					</td>
					<td>
						<c:choose>
							<c:when test="${pyear ne null}">
								<c:choose>
									<c:when test="${pyear eq '01'}">
										<input type="radio" name="mon" value="04" id="mon4" class="radio-st01"><label for="mon4" class="mr3"><span class="radio-deco"></span>4월기준</label>
										<input type="radio" name="mon" value="01" id="mon1" class="radio-st01" checked><label for="mon1"><span class="radio-deco"></span>1월기준</label>
									</c:when>
									<c:otherwise>
										<input type="radio" name="mon" value="04" id="mon4" class="radio-st01" checked><label for="mon4" class="mr3"><span class="radio-deco"></span>4월기준</label>
										<input type="radio" name="mon" value="01" id="mon1" class="radio-st01"><label for="mon1"><span class="radio-deco"></span>1월기준</label>
									</c:otherwise>
								</c:choose>								
							</c:when>
							<c:otherwise>
								<input type="radio" name="mon" value="04" id="mon4" class="radio-st01" checked><label for="mon4" class="mr3"><span class="radio-deco"></span>4월기준</label>
								<input type="radio" name="mon" value="01" id="mon1" class="radio-st01"><label for="mon1"><span class="radio-deco"></span>1월기준</label>
							</c:otherwise>
						</c:choose>
					</td>
					<th>교정구분</th>
					<td colspan="2">
						<c:choose>
							<c:when test="${g_gub ne null}">
								<input type="radio" name="g_gub" value="" id="opt01" class="radio-st01" value="1,2,3"
									<c:if test="${g_gub eq '1,2,3'}">
										checked
									</c:if>
								 ><label for="opt01" class="mr3"><span class="radio-deco"></span>전체</label>
								<input type="radio" name="g_gub" value="" id="opt02" class="radio-st01" value="1"
									<c:if test="${g_gub eq '1'}">
										checked
									</c:if>
								><label for="opt02" class="mr3"><span class="radio-deco"></span>사내</label>
								<input type="radio" name="g_gub" value="" id="opt03" class="radio-st01" value="2"
									<c:if test="${g_gub eq '2'}">
										checked
									</c:if>
								><label for="opt03" class="mr3"><span class="radio-deco"></span>사외</label>
								<input type="radio" name="g_gub" value="" id="opt04" class="radio-st01" value="3"
									<c:if test="${g_gub eq '3'}">
										checked
									</c:if>
								><label for="opt04"><span class="radio-deco"></span>표준기(사외)</label>
								
							</c:when>
							<c:otherwise>
								<input type="radio" name="g_gub" id="opt01" class="radio-st01" value="1,2,3" checked><label for="opt01" class="mr3"><span class="radio-deco"></span>전체</label>
								<input type="radio" name="g_gub" id="opt02" class="radio-st01" value="1"><label for="opt02" class="mr3"><span class="radio-deco"></span>사내</label>
								<input type="radio" name="g_gub" id="opt03" class="radio-st01" value="2"><label for="opt03" class="mr3"><span class="radio-deco"></span>사외</label>
								<input type="radio" name="g_gub" id="opt04" class="radio-st01" value="3"><label for="opt04"><span class="radio-deco"></span>표준기(사외)</label>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="sgap"></div>				
	<div style="position: relative;height:500px;" id="grid-parent">
	    <div data-ax5grid="monPlan-grid" data-ax5grid-config="{
	                    showLineNumber: true,
	                    lineNumberColumnWidth: 30,}" style="height: 100%;">
        </div>
	</div>
</div>
</c:if>