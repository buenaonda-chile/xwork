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
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/sal/WAS005SalAnlysView.js?ver"></script>

<script type="text/javascript">
//사업부 필수체크 메시지
var LN_SELECT_COMPS = "<spring:message code='WAN-I0-0001'/>";
//업체 필수체크 메시지
var LN_SELECT_PYVND = "<spring:message code='WAN-I0-0002'/>";
//업체코드확인바랍니다 메시지
var LN_IO_CHK1 = "<spring:message code='WAN-I0-Chk1'/>";

var LN_CHK1 = "<spring:message code='label.WAN002.Chk6'/>";

$(function(){
	grid = grid1;
	gridinit();
}); 

function gridinit() {
	grid.initView({
		prdcd : { //제품
			label : "<spring:message code='label.WAS005.prdcd'/>"
		},
		prdnm : { //제품명
			label : "<spring:message code='label.WAS005.prdnm'/>"
		},
		ysum : { //년계
			label : "<spring:message code='label.WAS005.ysum'/>"
		},
		msum : { //단계
			label : "<spring:message code='label.WAS005.msum'/>"
		},
		paysum : { //판매실적
			label : "<spring:message code='label.WAS005.paysum'/>"
		},
		amount : { //금액
			label : "<spring:message code='label.WAS005.amount'/>"
		},
		gap : { //차이
			label : "<spring:message code='label.WAS005.gap'/>"
		},
		achirate : { //달성률
			label : "<spring:message code='label.WAS005.achirate'/>"
		},
		cust : { //거래처
			label : "<spring:message code='label.WAS005.cust'/>"
		},
		custnm : { //거래처명
			label : "<spring:message code='label.WAS005.custnm'/>"
		},
		qty: { //수량
			label : "<spring:message code='label.WAS005.qty'/>"
		},
	});
}


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

.required { content:"*";color:red; }


</style>

<div class="grid-block team-ms">
	<div class="gridContents" style="" id="grid-parent">
		<div style="margin: 0px 15px 0px 0px;">
			<div class="k_cg1">
				<div class="gridBtnBlock k_bg1">
					<button type="button" class="AXButton Black" onclick="search();">
						<i class="axi axi-ion-android-search"></i>
						<spring:message code='label.search' />
					</button>

					<button type="button" class="xlsDown _excelBtn_">
						<span><spring:message code='label.excelDown' /></span>
					</button>
				</div>

				<div class="gridBtnBlock k_sg1">

					<!-- 사업부 -->
					<label class="k_l1">사업부</label>
					<select name="getComps" id="getComps" class="getComps requiredLine">
						<option value="">전체</option><!-- 전체 -->
						<option value="PE">구KE</option><!-- 마산 -->
						<option value="PS">구KA</option><!-- 창원,화성 -->
					</select>					
					
					<!-- 공장구분 -->
					<label class="k_l1">공장구분</label>
					<select name="getPltcd" id="getPltcd" class="getPltcd requiredLine">
						<option value="">전체</option><!-- 전체 -->
						<option value="E1" disabled>마산</option>
						<option value="C1" disabled>창원</option>
						<option value="S1" disabled>화성</option>
					</select>

					<!-- 계획년월 -->
					<label class="k_l1"><%-- <spring:message code='label.WAS004.repym'/> --%>계획년월</label>
					<div class="dropdown ">
						<span class="calendar_icon vcen2"></span>
						<input type="text" class="dropbtn calendar_input getPlnym" name="getPlnym" id="getPlnym" value="${plnym}"/>
						<div class="dropdown-menu" role="menu"  id="chk_calendar" style="width:250px;
						           border:1px solid #ccc;
						           border-radius: 5px;
						           padding: 5px;
						           overflow: hidden;" >
						</div>
					</div>
								
					<!-- 계획구분 -->
					<label class="k_l1"><%-- <spring:message code='label.WAS004.repym'/> --%>계획구분</label>
						<select name="getPlngub" id="getPlngub" class="getPlngub requiredLine">
							<option value="1"><%-- <spring:message code='label.add' /> --%>년계</option>
							<option value="2"><%-- <spring:message code='label.modify' /> --%>수계</option>
						</select>
					
					<br><!-- 다음행 -->
					<!-- 업체코드 -->
					<label class="k_l1"><spring:message code='label.WAN002.pyvnd2'/></label>	
						<input type="text" class="AXInput getPyvnd" style="width : 60px;" name="getPyvnd1" id="getPyvnd1"  maxlength="8"
							onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)' onBlur="getCustSch('input', this.value);">
						<input type="text" class="AXInput getCusnm1" style="width : 180px;" name="getCusnm1" id="getCusnm1" placeholder="<spring:message code='WAN-I0-0002'/>" title="<spring:message code='WAN-I0-0002'/>" disabled readOnly>
						<button type="button" onclick="" class="AXButton Normal _custBtn_">
							<spring:message code="label.select" />
						</button>	
						~
						<input type="text" class="AXInput getPyvnd" style="width : 60px;" name="getPyvnd2" id="getPyvnd2"  maxlength="8"
							onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)' onBlur="getCustSch('input', this.value);">
						<input type="text" class="AXInput getCusnm2" style="width : 180px;" name="getCusnm2" id="getCusnm2" placeholder="<spring:message code='WAN-I0-0002'/>" title="<spring:message code='WAN-I0-0002'/>" disabled readOnly>
						<button type="button" onclick="" class="AXButton Normal _custBtn_">
							<spring:message code="label.select" />
						</button>						
					
					<br><!-- 다음행 -->
					<!-- 제품코드 -->
					<label class="k_l1"><%-- <spring:message code='label.WAS004.repym'/> --%>제품코드</label>
						<select name="getPrdcd1" id="getPrdcd1" class="getPrdcd1">
							<option value="1"><%-- <spring:message code='label.add' /> --%></option>
							<option value="2"><%-- <spring:message code='label.modify' /> --%></option>
						</select>
						~
						<select name="getPrdcd2" id="getPrdcd2" class="getPrdcd2">
							<option value="1"><%-- <spring:message code='label.add' /> --%></option>
							<option value="2"><%-- <spring:message code='label.modify' /> --%></option>
							</option>
						</select>
					
					<!-- 조회구분 -->
					<label class="k_l1"><%-- <spring:message code='label.WAS004.repym'/> --%>조회구분</label>
						<select name="getSelectgub" id="getSelectgub" class="getSelectgub">
							<option value="1"><%-- <spring:message code='label.add' /> --%>제품별</option>
							<option value="2"><%-- <spring:message code='label.modify' /> --%>득의선별</option>
							<option value="3"><%-- <spring:message code='label.modify' /> --%>제품/득의선별</option>
							<option value="4"><%-- <spring:message code='label.modify' /> --%>득의선/제품별</option>
						</select>
					
					<br><!-- 다음행 -->
					<!-- 출하일자 -->
					<label class="k_l1"><%-- <spring:message code='label.WAN023.plndt'/> --%>출하일자</label>
						<div class="dropdown">						
							<span class="calendar_icon vcen2"></span>
							<input type="text" class="dropbtn calendar_input getGodt1"  name="startDate" id="startDate" value="${startDate}"/>
							<div class="dropdown-menu" role="menu"  id="dodt1_calendar" style="width:250px;
							           border:1px solid #ccc;
							           border-radius: 5px;
							           padding: 5px;
							           overflow: hidden;" >
						</div>
						~
						<div class="dropdown">
							<span class="calendar_icon vcen2"></span>
							<input type="text" class="dropbtn calendar_input getGodt2" name="endDate" id="endDate" value="${endDate}"/>
							<!-- <div class="dropdown-menu" role="menu"  id="dodt2_calendar" style="width:250px;
							           border:1px solid #ccc;
							           border-radius: 5px;
							           padding: 5px;
							           overflow: hidden;" >
							</div> -->
						</div>
					</div>
					
					<!-- 납입구분 -->
					<label class="k_l1"><%-- <spring:message code='label.WAS004.repym'/> --%>납입구분</label>
						<select name="getPaygub" id="getPaygub" class="getPaygub">
							<option value="1"><%-- <spring:message code='label.add' /> --%></option>
							<option value="2"><%-- <spring:message code='label.modify' /> --%></option>
						</select>
					
					<!-- 품번 -->
					<label class="k_l1"><%-- <spring:message code='label.WAS004.repym'/> --%>품번</label>
					<select name="getPspno" id="getPspno" class="getPspno">
						<option value="1"><%-- <spring:message code='label.add' /> --%></option>
						<option value="2"><%-- <spring:message code='label.modify' /> --%></option>
					</select>
					
					<!-- 최종고객구분 -->
					<label class="k_l1"><%-- <spring:message code='label.WAS004.repym'/> --%>최종고객구분</label>
					<select name="getEndcgub" id="getEndcgub" class="getEndcgub">
						<option value="1"><%-- <spring:message code='label.add' /> --%></option>
						<option value="2"><%-- <spring:message code='label.modify' /> --%></option>
					</select>
					
					
				</div>
			</div>
			<div class="pt5 salGrid" data-ax5grid="grid"
				data-ax5grid-config="{showLineNumber: true}"></div>

		</div>
	</div>
</div>
