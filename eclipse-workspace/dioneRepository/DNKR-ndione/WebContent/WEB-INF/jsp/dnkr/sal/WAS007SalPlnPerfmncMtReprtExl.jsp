<%--
 * PROJECTÃ¯Â¼Â
 *
 * [KR] 
 * 
 * yoonjae.jeong
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
<link rel="stylesheet" href="/css/wijmo.css"/>
 
<script type="text/javascript" src="/wijmo/controls/wijmo.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.grid.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.input.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.xlsx.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.grid.xlsx.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.grid.filter.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/cultures/wijmo.culture.ko.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/jszip.min.js"></script>

<!-- chart 관련 -->
<script type="text/javascript" src="/wijmo/controls/wijmo.chart.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.pdf.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.nav.min.js"></script>


<script  type="text/javascript">

//위즈모 LicenseKey 설정
wijmo.setLicenseKey('${wijmoLicenseKey}');

//사업부 필수체크 메시지
var LN_SELECT_COMPS = "<spring:message code='WAN-I0-0001'/>";
//업체 필수체크 메시지
var LN_SELECT_PYVND = "<spring:message code='WAN-I0-0002'/>";
//업체코드확인바랍니다 메시지
var LN_IO_CHK1 = "<spring:message code='WAN-I0-Chk1'/>";

//var LN_CHK_MKCAR = "<spring:message code='label.WAN004.mkcar'/>";
//var LN_CHK_SEYNO = "<spring:message code='label.WAN004.seyno'/>";
//var LN_CHK_SEYCD = "<spring:message code='label.WAN004.seycd'/>";

var LN_DEL_CHK1 = "<spring:message code='label.WAN000.delChk1'/>";
var LN_INS_CHK1 = "<spring:message code='label.WAN000.insChk1'/>";
var LN_INS_CHK2 = "<spring:message code='label.WAN000.insChk2'/>";
var LN_UPD_CHK1 = "<spring:message code='label.WAN000.updChk1'/>";
var LN_UPD_CHK2 = "<spring:message code='label.WAN000.updChk2'/>";
var LN_UPD_CHK3 = "<spring:message code='label.WAN000.updChk3'/>";

var LB_ROADMORE = "<spring:message code='label.WAS007.roadMore'/>";
var LB_TITLE2 = "<spring:message code='label.WAS007.tabTitle2'/>";
var LB_YAER = "<spring:message code='label.WAS007.year'/>";
var LB_MM = "<spring:message code='label.WAS007.mm'/>";

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
	min-width:1100px; 
	display:inline-block; 
	margin:0 5px;
	width: 100%;
}

.third-grid-block {
	min-width: 420px;
	line-height: 14px;
}

	@media screen and (max-width:1100px){
		.third-grid-block.team-ms {min-width:0; min-width:660px;}
	}
	@media screen and (max-width:800px){
		.grid-block.team-ms {min-width:0; width:49%; margin:0 0px;}
		.third-grid-block.team-ms {width:100%;}
	}

.gridBtn {
	height:22px;
	line-height: 14px;
}


.schLine {
	margin: 0px 15px 0px 0px;
}


.wj-flexgrid {
	max-height: 620px;
	height: auto;
	width: 100%;
}

.wj-flexchart {
	height: 500px;
}


.wj-header {
 	background: white;
    
}
.k_l2{
	width:70px;
	font-size: 15px; "
}

/* 2021.01.08 */
.k_cg1{padding:14px 10px 0 15px;}
.k_cg1 .k_bg1{width:340px;}
.k_cg1 .k_sg1{width:calc(100% - 340px);}


</style>

<div class="grid-block team-ms">
	<div class="gridContents" style="" id="grid-parent">
		<div style="margin: 0px 15px 0px 0px;">
			<div class="k_cg1">
				<div class="gridBtnBlock k_bg1">
					<button type="button" class="AXButton Black" onclick="search();">
						<i class="axi axi-ion-android-search"></i>
						<spring:message code='label.search'/><!-- 조회 -->
					</button>
					<button type="button" class="pdfDown" onclick="downloadPdf();">
						<span><spring:message code='label.WAS000.pdfDown' /></span>
					</button>
					<button type="button" class="AXButton loadMore">
						<span><spring:message code='label.WAS007.roadMore' /></span><!-- 더보기 -->
					</button>
				</div>
				<div class="gridBtnBlock k_sg1">
					<!-- 년,월 캘린더 -->
					<div class="board-bList-wrap log_board">
						<div class="list-top">
							<div class="fl schLine">
								<label class="k_l1"><spring:message code='label.WAS004.repym'/></label>
								<div class="dropdown">
									<span class="calendar_icon vcen2"></span>
									<input type="text" class="dropbtn calendar_input getDumcb" name="getDumcb" id="getDumcb" value="${dumcb}"/>
									<div class="dropdown-menu" role="menu"  id="chk_calendar" style="width:250px;
									           border:1px solid #ccc;
									           border-radius: 5px;
									           padding: 5px;
									           overflow: hidden;" >
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- 공장구분 -->
					<label class="k_l1"><spring:message code='label.WAS007.locList'/></label>
					<select name="getLocCode" id="getLocCode" class="getLocCode schLine">
						<c:if test="${fn:length(locList) > 0}">
							<c:forEach var="locDomain" items="${locList}" varStatus="status">
							<option value="${locDomain.relationCode}"
							<c:if test="${locDomain.relationCode eq empLoc}">
							selected
							</c:if>
							><c:out value="${locDomain.relationName}"/></option>
							</c:forEach>
						</c:if>
					</select>
					
				</div>
				<div class="k_sg4 checkboxList" style="display: none;">
					<div class="inlineBlock schLine" >
						<input type="checkbox" class="allCheck" name="allCheck" id="allCheck" value="allCheck" style="width: 30px;"/><label class="k_l2" ><spring:message code='label.WAS007.allCheck'/></label>
						<input type="checkbox" class="check_all_list" name="cluster" id="cluster" value="cluster" style="width: 30px;"/><label class="k_l2" >CLUSTER</label>
						<input type="checkbox" class="check_all_list" name="smk" id="smk" value="smk" style="width: 30px;"/><label class="k_l2" >SMK</label>
						<input type="checkbox" class="check_all_list" name="hud" id="hud" value="hud" style="width: 30px;"/><label class="k_l2" >HUD</label>
						<input type="checkbox" class="check_all_list" name="cvvt" id="cvvt" value="cvvt" style="width: 30px;"/><label class="k_l2" >CVVT</label>
						<input type="checkbox" class="check_all_list" name="ocv" id="ocv" value="ocv" style="width: 30px;"/><label class="k_l2" >OCV</label>
						<input type="checkbox" class="check_all_list" name="copCoil" id="copCoil" value="copCoil" style="width: 30px;"/><label class="k_l2" >COP COIL</label>
						<input type="checkbox" class="check_all_list" name="fPump" id="fPump" value="fPump" style="width: 30px;"/><label class="k_l2" >F/PUMP</label>
						<input type="checkbox" class="check_all_list" name="atSol" id="atSol" value="atSol" style="width: 30px;"/><label class="k_l2" >AT SOL</label>
						<input type="checkbox" class="check_all_list" name="etc" id="etc" value="etc" style="width: 30px;"/><label class="k_l2" >ETC</label>
						<input type="checkbox" class="check_all_list" name="ac" id="ac" value="ac" style="width: 30px;"/><label class="k_l2" ><spring:message code='label.WAS007.ac'/></label>
						<input type="checkbox" class="check_all_list" name="busAc" id="busAc" value="busAc" style="width: 30px;"/><label class="k_l2" >BUS A/C</label>
						<input type="checkbox" class="check_all_list" name="wm" id="wm" value="wm" style="width: 30px;"/><label class="k_l2" >W/M</label>
					</div>
				</div>
			</div>
			
			<div class="cb pt5 ">
			</div>
	    	
	    	<div id="theTabPanel" class="custom-headers tabs-below">
	    		<!-- 판매현황 계획/실적 -->
		    	<div>
		          	<a>1.<spring:message code='label.WAS007.tabTitle1'/></a>
		          	<div>
		          		<div id="chartSalPln" class="chart-block1"></div>
		          	</div>
		        </div>
		        
		        <!-- 주요상품별 사업계획 대비 증감수량 -->
		        <div>
		          	<a class="title2">2.<spring:message code='label.WAS007.tabTitle2'/></a>
		          	<div>
		            	<div id="chart" class="chart-block1"></div>
		            	<textarea id="text1" name="text1" style="resize: none;width: 50%;height: 300px;" readonly="true">${text1}</textarea><textarea id="text2" name="text2" style="resize: none;width: 50%;height: 300px;" readonly="true">${text2}</textarea>
		          	</div>
		        </div>
		        
			</div>
	    	 
			
 		</div>
	</div>
</div>


<script>

	//code generator 후 js파일 경로 수정해줘야함.
	$.getScript('/js/sal/WAS007SalPlnPerfmncMtReprtExl.js');
	
	
</script>
   


