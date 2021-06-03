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

<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%-- 조회권한 --%>

<style>
[data-ax5grid-container="root"] [data-ax5grid-panel-scroll="body"] table tr> td:FIRST-CHILD {
    cursor: text;
    box-shadow: inset 0 0 0 0 transparent;
    background-color: transparent;
    border-radius: inherit;
    border-bottom: 1px solid #ccc !important;
    border-right: 1px solid #ccc !important;
}

[data-ax5grid-container="root"] [data-ax5grid-panel-scroll="body"] table tr> td:FIRST-CHILD:hover {
    background-color: transparent;
}

/* div[data-ax5grid-container="header"] {
    height: 26px !important;
} */

[data-ax5grid-panel="header"] table tr:first-child {
    display: none;
}

[data-ax5grid-panel="header"] table tr:nth-child(2) {
    height: 52px
} 

[data-ax5grid-container="root"] {
	height: 484px !important;
}

/* [data-ax5grid-scroller="vertical"] {
	height: 442px !important;
} */

[data-ax5grid-panel="body"] {
	/* height: 438px !important; */
	height: 234px !important;
}

[data-ax5grid-panel="bottom-body"] {
	height: 156px !important;
	top: auto !important;
	bottom: 0px;
}

</style>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/waf/WAF016PssalPCarOutStatus.js"></script>
<form name="searchForm" id="searchForm">
<div class="top-btns fr">
	<button class="btn-st01 black" type="button" onclick="javascript:searchData();" style="cursor: pointer;">
		<span><spring:message code='label.search' /><!-- 조회 --></span>
	</button>
	<button class="xlsDown btn-st01 green excelBtn" type="button" style="cursor: pointer;">
		<span><spring:message code='label.excelDown' /><!-- 엑셀다운 --></span>
	</button>
</div>
<div class="cb pt5"></div>
<table class="pd-s-table">
	<colgroup>
		<col style="width:150px;" />
		<col style="width:150px;" />
		<col style="width:150px;" />
		<col style="width:150px;" />
		<col style="width:150px;" />
		<col style="width:150px;" />
		<col style="width:400px" />
	</colgroup>
	<tbody>
		<tr>
			<th>
				사업부
			</th>
			<td>
				<select name="comps" id="ComboBoxPlant" dataSet="ds_ComCode_PLNT">
					<c:if test="${fn:length(codeList) > 0}">
						<c:forEach var="codeD2Domain" items="${codeList}" varStatus="status">
							<option value="${codeD2Domain.code2}"><c:out value="${codeD2Domain.code_name}"/></option>
						</c:forEach>
					</c:if>
				</select>
			</td>
			<th>
				선택년
			</th>
			<td colspan="3">
				<div data-ax5picker="basic" style="width:140px;">
					<input type="text" name="jpyym" id="" style="width:140px;" placeholder="yyyy" data-picker-date="year" 
					value='<c:out value="${year }"></c:out>' />
				</div>
			</td>
			<td rowspan="2">
				<span>
					&lt; 수량은 C/M, M/M만 / 금액은 반올림 적용 &gt;<br>
					&lt; 수량: 臺 &nbsp;&nbsp;금액: 阡 &gt;
				</span>
			</td>
		</tr>

		<tr>
			<th>
				업체
			</th>
			<td colspan="3">
				<input type="text" id="pyvnd" name="pyvnd" placeholder="00000000" maxlength="8" style="width:140px;"/>
				~
				<input type="text" id="pyvnd2" name="pyvnd2" placeholder="00000000" maxlength="8" style="width:140px;"/>
			</td>
			<th>
				납입일자
			</th>
			<td>
				<div data-ax5picker="basic" style="width:140px;">
					<input type="text" name="jpsdt" id="" style="width:140px;" placeholder="yyyy-mm-dd" data-picker-date="date" 
					value='<c:out value="${today }"></c:out>'/>
				</div>
			</td>
		</tr>
		
	</tbody>
</table>
</form>


<div style="margin-top:10px;">
	<!-- BindDataSet : ds_omg312_gridVal -->
	
</div>

<div style="position: relative;height:652px;" id="grid-parent">
    <div data-ax5grid="first-grid" data-ax5grid-config="{
                    showLineNumber: true,
                    showRowSelector: true,
                    sortable: true,
                    header: {align:"center"}
                    }" style="height: 100%;"></div>
</div>

</c:if>