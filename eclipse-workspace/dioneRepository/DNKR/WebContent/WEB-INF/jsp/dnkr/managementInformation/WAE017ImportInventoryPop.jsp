<%--
 * PROJECT：
 *
 * [KR] 품목별 입출고 조회
 * 
 * $Id$
 *
 * Copyright (c) 2017 DENSO CORPORATION. All rights reserved.
 *
--%>
<!-- [EN] Contents area -->
<!-- [JP] コンテンツエリア -->
<%-- <spring:message code="label.filename" /> : <c:out value="${url }"></c:out> --%>
<jsp:useBean id="today" class="java.util.Date" />

<link rel="stylesheet" media="all" href="/css/content.css?ver" />
<style>
[data-ax5grid-container="root"] [data-ax5grid-panel-scroll="body"] table tr>td:FIRST-CHILD
	{
	cursor: text;
	box-shadow: inset 0 0 0 0 transparent;
	background-color: transparent;
	border-radius: inherit;
	border-bottom: 1px solid #ccc !important;
	border-right: 1px solid #ccc !important;
}
.pd-s-table td input[type="text"] {width:160px !important}
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/dwh/WAE017ImportInventoryPop.js"></script>
<!-- [EN] Contents area -->

<!-- <form name="gridForm" id="gridForm"> -->
<form name="WAE017ImportInventoryPopForm" id="WAE017ImportInventoryPopForm">

<table class="pd-s-table" style="margin-top:20px;">
	<colgroup>
		<col style="width:120px;" />
		<col style="width:180px;" />
		<col style="width:120px;" />
		<col style="width:180px;" />
		<col style="width:120px;" />
		<col style="width:180px;" />
	</colgroup>
	<tbody>
		<input type="text" name="comps" id="comps" hidden="true" value="${pop1List.comps}" /></td> 
		<tr>
			<th><spring:message code='label.expno'/><%-- 수입품번 --%> </th>
			<td ><input type="text" name="expno" id="expno" style="text-align:left" value="${pop1List.expno}" readonly="true"/></td> 
			<th><spring:message code='label.itdsc'/></th>
			<td><input type="text" name="exdsc" id="exdsc" style="text-align:left" value="${pop1List.exdsc}" readonly="true"/></td>
			<th><spring:message code='label.exrtt'/><%-- 안전재고--%></th>
			<td><input type="text" name="exrtt" id="exrtt" style="text-align:right" value="${pop1List.exrtt}" readonly="true"/>%</td>
		</tr>
		<tr>
			<th><spring:message code='label.carcd'/><%-- 차종코드--%></th>
			<td><input type="text" name="carcd" id="carcd" style="text-align:left" value="${pop1List.carcd}" readonly="true"/></td>			 
			<th><spring:message code='label.carnm'/><%-- 차종명 --%></th>
			<td><input type="text" name="carnm" id="carnm" style="text-align:left" value="${pop1List.carnm}" readonly="true"/></td>
			<th><spring:message code='label.exphs'/><%-- HSNO--%></th>
			<td><input type="text" name="exphs" id="exphs" style="text-align:left" value="${pop1List.exphs}" readonly="true"/></td>
		</tr>
		<tr>
			<th><spring:message code='label.vndnr'/><%-- 구매업체코드--%>	</th>
			<td><input type="text" name="vndnr" id="vndnr" style="text-align:left" value="${pop1List.vndnr}" readonly="true"/></td>		 
			<th><spring:message code='label.vname'/><%-- 구매업체명--%></th>
			<td><input type="text" name="vname" id="vname" style="text-align:left" value="${pop1List.vname}" readonly="true"/></td>
			<th><spring:message code='label.densoPspno'/><%-- 덴소품번--%></th>
			<td><input type="text" name="pspno" id="pspno" style="text-align:left" value="${pop1List.pspno}" readonly="true"/></td>
		</tr>
		<tr>
			<th><spring:message code='label.d1'/><%-- 무상사급--%></th>
			<td colspan=3><input type="text" name="d1" id="d1" style="text-align:right" value="${pop1List.d1}" readonly="true"/></td>
			<th><spring:message code='label.exrat'/><%-- 단위환산--%></th>
			<td><input type="text" name="exrat" id="exrat" style="text-align:right" value="${pop1List.exrat}" readonly="true"/></td>
		</tr>
		<tr>
			<th colspan=2><현재 재고량></th>
			<th colspan=2><2018/09 기준변경소요량></th>
			<th colspan=2><오더 미입고></th>
		</tr>
		<tr>
			<th><spring:message code='label.d2'/><%-- 발주재고--%></th>
			<td><input type="text" name="d2" id="d2" style="text-align:right" value="${pop1List.d2}" readonly="true"/></td>
			<th><spring:message code='label.m00qy'/><%-- M --%> </th>
			<td><input type="text" name="m00qy" id="m00qy" style="text-align:right" value="${pop1List.m00qy}" readonly="true"/></td>
			<td colspan=2 rowspan=9>
				<div style="position: relative;  width:285px; height:310px;" id="grid-parent" >
				<div data-ax5grid="unit-gridPop"
					data-ax5grid-config="{
				                    showLineNumber: true,
				                    lineNumberColumnWidth: 40}"
					style="height: 100%;width:320px; "></div>
				</div>
			</td>
		</tr>
		<tr>
			<th><spring:message code='label.d3'/><%-- 보세재고--%></th>
			<td><input type="text" name="d3" id="d3" style="text-align:right" value="${pop1List.d3}" readonly="true"/></td>
			<th><spring:message code='label.m10qy'/><%-- M+1 --%> </th>
			<td><input type="text" name="m10qy" id="m10qy" style="text-align:right" value="${pop1List.m10qy}" readonly="true"/></td>
		</tr>
		<tr>
			<th><spring:message code='label.d4'/><%-- 자재재고--%></th>
			<td><input type="text" name="d4" id="d4" style="text-align:right" value="${pop1List.d4}" readonly="true"/></td>
			<th><spring:message code='label.m20qy'/><%-- M+2 --%> </th>
			<td><input type="text" name="m20qy" id="m20qy" style="text-align:right" value="${pop1List.m20qy}" readonly="true"/></td>
		</tr>
		<tr>
			<th><spring:message code='label.d5'/><%-- 재고합계--%></th>
			<td><input type="text" name="d5" id="d5" style="text-align:right" value="${pop1List.d5}" readonly="true"/></td>
			<th><spring:message code='label.m30qy'/><%-- M+3 --%> </th>
			<td><input type="text" name="m30qy" id="m30qy" style="text-align:right" value="${pop1List.m30qy}" readonly="true"/></td>
		</tr>
		<tr>
			<th><spring:message code='label.d6'/><%-- 미통관수--%></th>
			<td colspan=3><input type="text" name="d6" id="d6" style="text-align:right" value="${pop1List.d6}" readonly="true"/></td>
		</tr>
		<tr>
			<th colspan=4><기본 소요량기준></th>
		</tr>
		<tr>
			<th><spring:message code='label.smdqy1'/><%-- 일소요량--%></th>
			<td><input type="text" name="smdqy1" id="smdqy1" style="text-align:right" value="${pop1List.smdqy1}" readonly="true"/></td>
			<th><spring:message code='label.smddt1'/><%-- 현재고일--%></th>
			<td><input type="text" name="smddt1" id="smddt1" style="text-align:right" value="${pop1List.smddt1}" readonly="true"/></td>
		</tr>
		<tr>
			<th><spring:message code='label.exrtt'/><%-- 안전재고--%></th>
			<td><input type="text" name="smaqy1" id="smaqy1" style="text-align:right" value="${pop1List.smaqy1}" readonly="true"/></td>
			<th><spring:message code='label.smadt1'/><%-- 안전일수--%></th>
			<td><input type="text" name="smadt1" id="smadt1" style="text-align:right" value="${pop1List.smadt1}" readonly="true"/></td>
		</tr>
		<tr>
			<th><spring:message code='label.smcqy1'/><%-- 과소재고--%></th>
			<td><input type="text" name="smcqy1" id="smcqy1" style="text-align:right" value="${pop1List.smcqy1}" readonly="true"/></td>
			<th><spring:message code='label.smcdt1'/><%-- 과소일수--%></th>
			<td><input type="text" name="smcdt1" id="smcdt1" style="text-align:right" value="${pop1List.smcdt1}" readonly="true"/></td>
		</tr>
	</tbody>
</table>
</form>

