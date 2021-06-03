<%--
 * PROJECTÃ¯Â¼Â
 *
 * [KR] 
 * 
 * $Id$
 *
 * Copyright (c) 2017 DENSO CORPORATION. All rights reserved.
 *
--%>
<!-- [EN] Contents area -->
<!-- [JP] Ã£ÂÂ³Ã£ÂÂ³Ã£ÂÂÃ£ÂÂ³Ã£ÂÂÃ£ÂÂ¨Ã£ÂÂªÃ£ÂÂ¢ -->
<%-- <spring:message code="label.filename" /> : <c:out value="${url }"></c:out> --%>

<link rel="stylesheet" media="all" href="/css/board.css"/>
<link rel="stylesheet" media="all" href="/css/content.css"/>

<!-- 그리드 css -->
<link rel="stylesheet" href="/wijmo/styles/wijmo.css"/>

<script type="text/javascript" src="/wijmo/controls/wijmo.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.grid.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.input.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.xlsx.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.grid.xlsx.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.grid.filter.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/cultures/wijmo.culture.ko.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/jszip.min.js"></script>

<script  type="text/javascript">

//위즈모 LicenseKey 설정
wijmo.setLicenseKey('${wijmoLicenseKey}');

//사업부 필수체크 메시지
var LN_SELECT_COMPS = "<spring:message code='WAN-I0-0001'/>";
//업체 필수체크 메시지
var LN_SELECT_PYVND = "<spring:message code='WAN-I0-0002'/>";
//차종 필수체크 메시지
var LN_SELECT_MCRCD = "<spring:message code='WAN-I0-0003'/>";
//서열 필수체크 메시지
var LN_SELECT_MSECD = "<spring:message code='WAN-I0-0004'/>";
//업체코드확인바랍니다 메시지
var LN_IO_CHK1 = "<spring:message code='WAN-I0-Chk1'/>";

var LN_CHK_MCRC1 = "<spring:message code='label.WAN000.mcrc1'/>"; //차종
var LN_CHK_MSEC1 = "<spring:message code='label.WAN000.msec1'/>"; //서열

var LN_DEL_CHK1 = "<spring:message code='label.WAN000.delChk1'/>";
var LN_INS_CHK1 = "<spring:message code='label.WAN000.insChk1'/>";
var LN_INS_CHK2 = "<spring:message code='label.WAN000.insChk2'/>";
var LN_UPD_CHK1 = "<spring:message code='label.WAN000.updChk1'/>";
var LN_UPD_CHK2 = "<spring:message code='label.WAN000.updChk2'/>";
var LN_UPD_CHK3 = "<spring:message code='label.WAN000.updChk3'/>";

/* var LN_CHK1 = "<spring:message code='label.WAN002.Chk4'/>";

$(function(){
	grid.initView({
		mcrc1:{label:"<spring:message code='label.WAN000.mcrc1'/>"},
		msec1:{label:"<spring:message code='label.WAN000.msec1'/>"},
	}).setData();
});  */

function onlyNumber(event){
	event = event || window.event;
	var keyID = (event.which) ? event.which : event.keyCode;
	if ( (keyID >= 48 && keyID <= 57) || (keyID >= 96 && keyID <= 105) || keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39 ) 
		return;
	else
		return false;
}
function removeChar(event) {
	event = event || window.event;
	var keyID = (event.which) ? event.which : event.keyCode;
	if ( keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39 ) 
		return;
	else
		event.target.value = event.target.value.replace(/[^0-9]/g, "");
}
</script>

<style>
.gridContents {
	width: 100%;
	overflow-x: auto;
	position: relative;
	display: inline-block;
}

.grid-block {
	#min-width:1100px; 
	display:inline-block; 
	margin:0 5px;
	width: 100%;
}

.third-grid-block {
	min-width: 420px;
	line-height: 14px;
}

@media screen and (max-width:1100px) {
	.third-grid-block.team-ms {
		min-width: 0;
		min-width: 660px;
	}
}

@media screen and (max-width:800px) {
	.grid-block.team-ms {
		min-width: 0;
		width: 49%;
		margin: 0 0px;
	}
	.third-grid-block.team-ms {
		width: 100%;
	}
}

.gridBtn {
	height:22px;
	line-height: 14px;
}

/* 2021.01.27 스타일수정-박가람
[data-ax5grid] [data-ax5grid-container="root"] 
[data-ax5grid-container="body"] [data-ax5grid-panel] 
table tr td [data-ax5grid-cellHolder] {
	padding: 2px 5px;
} */

.schLine {
	margin: 0px 15px 0px 0px;
}

/* 	@media screen and (max-width:1200px) {
		.pd-s-table td input[type="text"] {width:100% !important}
	}	 */
.wj-flexgrid {
	max-height: 570px;
	height: auto;
	width: 100%;
	/*font-size: 11pt;*/
	/*font-size:10px;*/
}

.wj-header {
	background: white;
}

/* 2021.01.08 */
.k_cg1 {
	padding:14px 10px 0 15px;
}

.k_cg1 .k_bg1 {
	width:320px;
}

.k_cg1 .k_sg1 {
	width:calc(100% - 320px);
}
.pt5{
 padding-bottom: 5px;
}
</style>

<div class="grid-block team-ms">
	<div class="gridContents" style="" id="grid-parent">
		<div style="margin: 0px 15px 0px 0px;">
			<div class="k_cg1">
				<div class="gridBtnBlock k_bg1">
					<button type="button" class="AXButton Black" onclick="search();">
						<i class="axi axi-ion-android-search"></i>
						<spring:message code='label.search' />
						<!-- 조회 -->
					</button>

					<div class="inlineBlock">
						<button type="button" class="AXButton Normal" style=""
							onclick="return update()">
							<spring:message code="label.save"/>
							<!-- 저장-->
						</button>
						<button type="button" class="AXButton Normal _delBtn" style=""
							onclick="">
							<spring:message code="label.delete" />
							<!-- 삭제 -->
						</button>
					</div>

					<div class="inlineBlock">
						<button type="button" class="AXButton Red _addBtn_" style=""
							onclick="">
							<i>
								<!--  class="axi axi-ion-person-add"> -->
							</i>
							<spring:message code='label.register' />
						</button>
					</div>
					<%-- <div class="displayNone">
						<button type="button" class="AXButton Blue _saveBtn_" onclick="">
							<spring:message code='label.save' />
							<!-- Ã¬Â ÂÃ¬ÂÂ¥ -->
						</button>
						<button type="button" class="AXButton Normal _closeBtn_" style=""
							onclick="">
							<i>
								<!--  class="axi axi-ion-person-add"> -->
							</i>
							<spring:message code='label.close' />
							<!-- Ã«ÂÂ«ÃªÂ¸Â° -->
						</button>
					</div> --%>

					<button type="button" class="xlsDown" onclick="downloadExcel();">
						<span><spring:message code='label.excelDown' /></span>
					</button>
				</div>

				<div class="gridBtnBlock k_sg1">
					
					<input type="hidden" id="getCompany" name="getCompany" value="${company}"/>
					
					<label class="k_l1"><spring:message code='label.WAN002.comps2' /></label>	
					<select name="getComps" id="getComps" class="getComps schLine">

						<option value="E1">마산</option>
						<option value="C1">창원</option>
						<option value="S1">화성</option>

						<!--<c:if test="${fn:length(codeList) > 0}">
						<c:forEach var="codeD2Domain" items="${codeList}" varStatus="status">
							<option value="${codeD2Domain.code2}"
								<c:if test="${codeD2Domain.code2 eq empComps}">
									selected
								</c:if>
							><c:out value="${codeD2Domain.code_name}"/></option>
						</c:forEach>
					</c:if>-->
					</select>

					<div class="inlineBlock schLine">
						<label class="k_l1"><spring:message code='label.WAN019.cusnm'/></label>	
						<input type="text" class="AXInput getPyvnd" style="width : 60px;" name="getPyvnd" id="getPyvnd"  maxlength="8"
							onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)' onBlur="getCustSch('input', this.value);">
						<button type="button" onclick="" class="AXButton Normal _custBtn_">
							<spring:message code="label.select" />
						</button>
						<input type="text" class="AXInput getCusnm" style="width: 180px;"
							name="getCusnm" id="getCusnm"
							placeholder="<spring:message code='WAN-I0-0002'/>"
							title="<spring:message code='WAN-I0-0002'/>" disabled readOnly>
					</div>

					<div class="inlineBlock schLine">
						<label class="k_l1"><spring:message code='label.WAN000.mcrc1' /></label>	
						<!-- TO..DO.. onBlur="getCarSch('input', this.value);" -->
						<input type="text" class="AXInput getMcrcd" style="width: 180px;"
							name="getMcrcd" id="getMcrcd" maxlength="2"
							placeholder="<spring:message code='WAN-I0-0003'/>"
							title="<spring:message code='WAN-I0-0003'/>">
					</div>

					<div class="inlineBlock">
						<label class="k_l1"><spring:message code='label.WAN000.msec1' /></label>	
						<input type="text" class="AXInput getMsecd" style="width: 180px;"
							name="getMsecd" id="getMsecd" maxlength="3"
							placeholder="<spring:message code='WAN-I0-0004'/>"
							title="<spring:message code='WAN-I0-0004'/>">
					</div>
				</div>
			</div>
			<div class="cb pt5 ">

			 	<table class="pd-s-table first-tbl">
					<tr>
						<th style="width: 8%;"><spring:message
								code='label.WAN000.pspno' /></th>
						<td style="width: 12%;"><input type="text" name="pspno"
							id="pspno" style="width: 100%" title="" readonly disabled /></td>
						<th style="width: 8%;"><spring:message
								code='label.WAN000.itdsc' /></th>
						<td style="width: 12%;"><input type="text" name="itdsc"
							id="itdsc" style="width: 100%" title="" readonly disabled /></td>
						<th style="width: 8%;"><spring:message
								code='label.WAN000.cusnm' /></th>
						<td style="width: 12%;"><input type="text" name="cusnm"
							id="cusnm" style="width: 100%" title="" readonly disabled /></td>
						<th style="width: 8%;"><spring:message
								code='label.WAN000.carnm' /></th>
						<td style="width: 12%;"><input type="text" name="carnm"
							id="carnm" style="width: 100%" title="" readonly disabled /></td>
						<th style="width: 8%;"><spring:message
								code='label.WAN000.cprtn' /></th>
						<td style="width: 12%;"><input type="text" name="cprtn"
							id="cprtn" style="width: 100%" title="" readonly disabled /></td>
					</tr>
				</table>
			</div>

			<!-- <div class="pt5 cmcGrid" data-ax5grid="grid"
				data-ax5grid-config="{showLineNumber: true}"></div> -->
			<div class="grid-container" style="position: relative; height: 600px;">
				<div id="wijmoGrid" ></div>
				<a href="javascript:zoomIn($('#wijmoGrid'),flexGrid);">확대</a>
				<a href="javascript:zoomOut($('#wijmoGrid'),flexGrid);">축소</a>
		    </div>

		</div>
	</div>
</div>

<script>
	$.getScript('/js/sal/DuplTypeOrderCodeMst.js');
</script>
