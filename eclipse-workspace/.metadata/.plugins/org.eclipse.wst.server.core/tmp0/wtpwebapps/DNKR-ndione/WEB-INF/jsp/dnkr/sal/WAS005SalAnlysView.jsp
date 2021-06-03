<%--
 *
 * [KR] 
 * 
 * 판매계획 - 매출분석조회
 *
 * Copyright (c) 2017 DENSO CORPORATION. All rights reserved.
 *
--%>



<link rel="stylesheet" media="all" href="/css/board.css" />
<link rel="stylesheet" media="all" href="/css/content.css" />

<!-- 그리드 css -->
<link rel="stylesheet" href="/wijmo/styles/wijmo.css"/>
<link rel="stylesheet" href="/css/wijmo.css"/>
 
<script type="text/javascript" src="/wijmo/controls/wijmo.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.grid.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.input.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.xlsx.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.grid.xlsx.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.grid.filter.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/cultures/wijmo.culture.ko.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/jszip.min.js"></script>

<script type="text/javascript">

//위즈모 LicenseKey 설정
wijmo.setLicenseKey('${wijmoLicenseKey}');

//사업부 필수체크 메시지
var LN_SELECT_COMPS = "<spring:message code='WAN-I0-0001'/>";
//업체 필수체크 메시지
var LN_SELECT_PYVND = "<spring:message code='WAN-I0-0002'/>";
//업체코드확인바랍니다 메시지
var LN_IO_CHK1 = "<spring:message code='WAN-I0-Chk1'/>";

var LN_CHK1 = "<spring:message code='label.WAN002.Chk6'/>";

var LB_COMPS = "<spring:message code='label.WAB002.clsCode'/>";
var LB_PRDCD = "<spring:message code='label.WAS005.prdcd'/>";
var LB_PRDNM = "<spring:message code='label.WAS005.prdnm'/>";
var LB_YSUM = "<spring:message code='label.WAS005.ysum'/>";
var LB_MSUM = "<spring:message code='label.WAS005.msum'/>";
var LB_PAYSUM= "<spring:message code='label.WAS005.paysum'/>";
var LB_AMOUNT = "<spring:message code='label.WAS005.amount'/>";
var LB_GAP = "<spring:message code='label.WAS005.gap'/>";
var LB_CUST = "<spring:message code='label.WAS005.cust'/>";
var LB_CUSTNM = "<spring:message code='label.WAS005.custnm'/>";
var LB_QTY = "<spring:message code='label.WAS005.qty'/>";
var LB_ACHIRATE = "<spring:message code='label.WAS005.achirate'/>";
var LB_XLSXTITLE = "<spring:message code='label.WAS005.xlsxTitle'/>";
var LB_CHECKPLNUMDATE = "<spring:message code='label.WAS005.checkPlnymDate'/>";
var LB_CHECKPRDCD = "<spring:message code='label.WAS005.checkPrdcd'/>";
var LB_CARCD = "<spring:message code='label.WAS005.carcd'/>";
var LB_CARNM = "<spring:message code='label.WAS005.carnm'/>";

function onlyNumber(event) {
	event = event || window.event;
	var keyID = (event.which) ? event.which : event.keyCode;
	if ((keyID >= 48 && keyID <= 57) || (keyID >= 96 && keyID <= 105)
			|| keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39)
		return;
	else
		return false;
}
function removeChar(event) {
	event = event || window.event;
	var keyID = (event.which) ? event.which : event.keyCode;
	if (keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39)
		return;
	else
		event.target.value = event.target.value.replace(/[^0-9]/g, "");
}
</script>

<style>

/* 팝업 사이즈 */
.popover .wj-flexgrid {
	height: 420px !important;
}

.gridContents {
	width: 100%;
	overflow-x: auto;
	position: relative;
	display: inline-block;
}

.grid-block { #
	min-width: 1100px;
	display: inline-block;
	margin: 0 5px;
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
	height: 22px;
	line-height: 14px;
}

.schLine {
	margin: 0px 15px 0px 0px;
}

.requiredLine {
	margin: 0px 15px 0px 0px;
	border-color: red ;
}

[data-ax5grid] [data-ax5grid-container="root"] 
[data-ax5grid-container="body"] [data-ax5grid-panel] 
table tr td [data-ax5grid-cellHolder] {
	padding: 2px 5px;
}


/* 2021.01.08 */
.k_cg1 {
	padding: 14px 10px 0 15px;
}

.k_cg1 .k_bg1 {
	width: 300px;
}

.k_cg1 .k_sg1 {
	width: calc(100% - 300px);
}

.salGrid {
    height: 100%;
    min-height: 650px;
}

.dropdown input{
	border: 1px solid #ff0000;
	border-radius: 4px;
}

</style>

<div class="grid-block team-ms">
	<div class="gridContents" style="" id="grid-parent">
		<div style="margin: 0px 15px 0px 0px;">
			<div class="k_cg1">
				<div class="gridBtnBlock k_bg1">
					<!-- 검색 -->
					<button type="button" class="AXButton Black" onclick="search();">
						<i class="axi axi-ion-android-search"></i>
						<spring:message code='label.search' />
					</button>

					<!-- 엑셀다운 -->
					<button type="button" class="xlsDown _excelBtn_" onclick="downloadExcel();">
						<span><spring:message code='label.WAS000.excelDown' /></span>
					</button>
				</div>

				<div class="gridBtnBlock k_sg1">
					<div class="board-bList-wrap log_board1">
					<!-- 사업부 -->
					<label class="k_l1"><spring:message code='label.WAS000.comps' /></label>
					<select name="getComps" id="getComps" class="getComps requiredLine">
						<option value="ALL"><spring:message code='label.WAS000.opt1' /></option><!-- 전체 -->
						<option value="PE"><spring:message code='label.WAS000.opt2' /></option><!-- 마산 -->
						<option value="PS"><spring:message code='label.WAS000.opt3' /></option><!-- 창원,화성 -->
					</select>					
					
					<!-- 공장구분 -->
					<label class="k_l1"><spring:message code='label.WAS005.loc'/></label>
					<select name="getPltcd" id="getPltcd" class="getPltcd requiredLine">
						<option value="ALL"><spring:message code='label.WAS000.opt1' /></option><!-- 전체 -->
						<option value="E1" disabled><spring:message code='label.WAS000.locNm1' /></option>
						<option value="C1" disabled><spring:message code='label.WAS000.locNm3' /></option>
						<option value="S1" disabled><spring:message code='label.WAS000.locNm4' /></option>
					</select>

					<!-- 계획년월 -->
					<label class="k_l1"><spring:message code='label.WAS005.planYM'/></label>
						<div class="dropdown">
						<span class="calendar_icon vcen2"></span>
						<input type="text" class="dropbtn calendar_input getPlnym" name="getPlnym" id="getPlnym" value="${plnym}" onblur="clear('1');"/>
						<div class="dropdown-menu" role="menu"  id="chk_calendar" style="width:250px;
						           border:1px solid #ccc;
						           border-radius: 5px;
						           padding: 5px;
						           overflow: hidden;" >
						</div>
						</div>
								
					<!-- 계획구분 -->
					<label class="k_l1"><spring:message code='label.WAS005.planPart'/></label>
						<select name="getPlngb" id="getPlngb" class="getPlngb requiredLine">
							<option value="1"><spring:message code='label.WAS005.yearPlan'/></option>
							<option value="2"><spring:message code='label.WAS005.modifiPlan'/></option>
						</select>
					<!-- 출하일자 -->
					<label class="k_l1"><spring:message code='label.WAS005.shipmentDate'/></label>
						<div class="dropdown date">						
							<span class="calendar_icon vcen2"></span>
							<input type="text" class="dropbtn calendar_input"  name="startDate" id="startDate" value="${startDate}"/>
							<div class="dropdown-menu menu2" role="menu"  id="log_calendar" style="width:250px;
							           border:1px solid #ccc;
							           border-radius: 5px;
							           padding: 5px;
							           overflow: hidden;">
							</div>
						</div>
						~
						<div class="dropdown date">
							<span class="calendar_icon vcen2"></span>
							<input type="text" class="dropbtn calendar_input" name="endDate" id="endDate" value="${endDate}"/>
							<!-- <div class="dropdown-menu" role="menu"  id="dodt2_calendar" style="width:250px;
							           border:1px solid #ccc;
							           border-radius: 5px;
							           padding: 5px;
							           overflow: hidden;" >
							</div> -->
						</div>
					</div>
					</div>
					<br>
					<div class="board-bList-wrap" style="float:left; ">
					<!-- 업체코드 -->
					<label class="k_l1"><spring:message code='label.WAS001.cstmrCo'/></label>	
						<input type="text" class="AXInput getPyvnd" style="width : 60px;" name="getPyvnd1" id="getPyvnd1"  maxlength="4"
							onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)' onBlur="getCustSch1(getComps.value, this.value, '1');" disabled="true;">
						<input type="text" class="AXInput getCusnm1" style="width : 180px;" name="getCusnm1" id="getCusnm1" placeholder="<spring:message code='WAN-I0-0002'/>" title="<spring:message code='WAN-I0-0002'/>" disabled readOnly>
						<button type="button" onclick="" class="AXButton Normal _custBtn1_"  value="1">
							<spring:message code="label.select" />
						</button>	
						~
						<input type="text" class="AXInput getPyvnd" style="width : 60px;" name="getPyvnd2" id="getPyvnd2"  maxlength="4"
							onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)' onBlur="getCustSch2(getComps.value, this.value, '1');" disabled="true;">
						<input type="text" class="AXInput getCusnm2" style="width : 180px;" name="getCusnm2" id="getCusnm2" placeholder="<spring:message code='WAN-I0-0002'/>" title="<spring:message code='WAN-I0-0002'/>" disabled readOnly>
						<button type="button" onclick="" class="AXButton Normal _custBtn2_" value="2">
							<spring:message code="label.select" />
						</button>		
					<!-- 제품코드 -->
					<label class="k_l1"><spring:message code='label.WAS005.prdcd' /></label>
						<select name="getPrdcdE1" id="getPrdcdE1" class="getPrdcdList1" disabled="true;">
							<option value=""><spring:message code='label.WAS000.opt1' /></option>
							<c:if test="${fn:length(prdcdE1List) > 0}">
							<c:forEach var="prdcdE1AllList" items="${prdcdE1List}" varStatus="status">
								<option value="${prdcdE1AllList.prdcd}">
									<c:out value="${prdcdE1AllList.prdcd}"/>
								</option>
							</c:forEach>
							</c:if>
						</select>
						<select name="getPrdcdS1" id="getPrdcdS1" class="getPrdcdList1" style="display: none;" >
							<option value=""><spring:message code='label.WAS000.opt1' /></option>
							<c:if test="${fn:length(prdcdS1List) > 0}">
							<c:forEach var="prdcdS1AllList" items="${prdcdS1List}" varStatus="status">
								<option value="${prdcdS1AllList.prdcd}">
									<c:out value="${prdcdS1AllList.prdcd}"/>
								</option>
							</c:forEach>
							</c:if>
						</select>
						~
						<select name="getPrdcd2E1" id="getPrdcd2E1" class="getPrdcdList2" disabled="true;" >
							<option value=""><spring:message code='label.WAS000.opt1' /></option>
							<c:if test="${fn:length(prdcdE1List) > 0}">
							<c:forEach var="prdcdE1AllList" items="${prdcdE1List}" varStatus="status">
								<option value="${prdcdE1AllList.prdcd}">
									<c:out value="${prdcdE1AllList.prdcd}"/>
								</option>
							</c:forEach>
							</c:if>
						</select>
						<select name="getPrdcd2S1" id="getPrdcd2S1" class="getPrdcdList2" style="display: none;">
							<option value=""><spring:message code='label.WAS000.opt1' /></option>
							<c:if test="${fn:length(prdcdS1List) > 0}">
							<c:forEach var="prdcdS1AllList" items="${prdcdS1List}" varStatus="status">
								<option value="${prdcdS1AllList.prdcd}">
									<c:out value="${prdcdS1AllList.prdcd}"/>
								</option>
							</c:forEach>
							</c:if>
						</select>
					
					<!-- 조회구분 -->
					<label class="k_l1"><spring:message code='label.WAS005.selectGub' /></label>
						<select name="getSelectgub" id="getSelectgub" class="getSelectgub">
							<option value="1"><spring:message code='label.WAS005.prdct' /></option>
							<option value="2"><spring:message code='label.WAS005.slecIntrs' /></option>
							<option value="3"><spring:message code='label.WAS005.prdct/slecIntrs' /></option>
							<option value="4"><spring:message code='label.WAS005.slecIntrs/prdct' /></option>
							<option value="5"><spring:message code='label.WAS005.car' /></option>
						</select>
					<!-- 납입구분 -->
					<label class="k_l1"><spring:message code='label.WAS005.paymentClssf'/></label>
						<select name="getPaygub" id="getPaygub" class="getPaygub" onchange="gridClear();">
							<option value=""><spring:message code='label.WAS005.incluTrans'/></option>
							<option value="1"><spring:message code='label.WAS005.excluTrans'/></option>
						</select>
					<!-- 최종고객구분 -->
					<label class="k_l1"><spring:message code='label.WAS005.lastCstmrType'/></label>
						<select name="getEndccdAll" id="getEndccdAll" class="getEndccdList" onchange="gridClear();">
						<option value = ""><spring:message code='label.WAS000.opt1' /></option>
						<c:if test="${fn:length(endccdAllList) > 0}">
						<c:forEach var="finlCustInfoBaseDomain" items="${endccdAllList}" varStatus="status">
							<option value="${finlCustInfoBaseDomain.endccd}">
								<c:out value="${finlCustInfoBaseDomain.endcnm}" />
							</option>
						</c:forEach>
						</c:if>
						</select>
						<select name="getEndccdPE" id="getEndccdPE" class="getEndccdList" style="display: none;"  onchange="gridClear();">
						<option value = ""><spring:message code='label.WAS000.opt1' /></option>
						<c:if test="${fn:length(endccdPEList) > 0}">
						<c:forEach var="finlCustInfoBaseDomain" items="${endccdPEList}" varStatus="status">
							<option value="${finlCustInfoBaseDomain.endccd}">
								<c:out value="${finlCustInfoBaseDomain.endcnm}" />
							</option>
						</c:forEach>
						</c:if>
						</select>
						<select name="getEndccdPS" id="getEndccdPS" class="getEndccdList" style="display: none;"  onchange="gridClear();">
						<option value = ""><spring:message code='label.WAS000.opt1' /></option>
						<c:if test="${fn:length(endccdPSList) > 0}">
						<c:forEach var="finlCustInfoBaseDomain" items="${endccdPSList}" varStatus="status">
							<option value="${finlCustInfoBaseDomain.endccd}">
								<c:out value="${finlCustInfoBaseDomain.endcnm}" />
							</option>
						</c:forEach>
						</c:if>
						</select>
					</div>
				</div>
			<div class="blank"></div>
			 <div class="grid-container" style="position: relative; height: 650px;">
				<div id="wijmoGrid" ></div>
				
				<div id="popDetail" class="popover" style="display: none; width: 1200px; height: 500px; padding: 10px;">
		            <span class="popover-title">
		               <spring:message code='label.WAS005.details'/>
		            </span>
		            <div class="popover-content">
		                <div id="popGrid"></div>
		                
		                <div class="form-actions" >
	                        <button class="btn btn-danger wj-hide float-right">닫기</button>
	                    </div>
		            </div>
		        </div>
				<a href="javascript:zoomIn($('#wijmoGrid'),flexGrid);"><spring:message code='label.WAS000.gridSize1'/></a>
				<a href="javascript:zoomOut($('#wijmoGrid'),flexGrid);"><spring:message code='label.WAS000.gridSize2'/></a>
		    </div>
		</div>
	</div>
</div>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/sal/WAS005SalAnlysView.js"></script>
