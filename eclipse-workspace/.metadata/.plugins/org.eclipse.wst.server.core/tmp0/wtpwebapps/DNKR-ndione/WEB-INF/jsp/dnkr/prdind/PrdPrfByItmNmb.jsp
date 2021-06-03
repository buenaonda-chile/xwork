<%--
 * �
 *
 * [KR] 
 * 
 * $Id$
 *
 * Copyright (c) 2017 DENSO CORPORATION. All rights reserved.
 *
--%>
<!-- [EN] Contents area -->
<!-- [JP]  -->
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


<script type="text/javascript" src="/wijmo/controls/wijmo.nav.min.js"></script>

<script  type="text/javascript">

//wijmo LicenseKey 설정
wijmo.setLicenseKey('${wijmoLicenseKey}');

var LB_COMPS = "<spring:message code='label.WAT001.comps'/>"; 
var LB_LINE_CODE = "<spring:message code='label.WAT001.lineCode'/>"; 
var LB_LINE_NM = "<spring:message code='label.WAT001.lineName'/>"; 
var LB_PRDT_CODE = "<spring:message code='label.WAT002.prdtCode'/>"; 
var LB_PRDT_NM = "<spring:message code='label.WAT002.prdtNm'/>"; 

var LB_CYCLE_TIME = "<spring:message code='label.WAT004.cycleTime'/>"; 
var LB_DRCT_HDCN = "<spring:message code='label.WAT004.drctHdcn'/>"; 
var LB_INDR_HDCN = "<spring:message code='label.WAT004.indrHdcn'/>"; 
var LB_PRFR_TIME = "<spring:message code='label.WAT004.prfrTime'/>"; 
var LB_MRG_FCT = "<spring:message code='label.WAT004.mrgFct'/>"; 
var LB_EXC_TM_RT = "<spring:message code='label.WAT004.excTmRt'/>"; 
var LB_IND_TM_RT = "<spring:message code='label.WAT004.indTmRt'/>"; 
var LB_EXC_IND_RT = "<spring:message code='label.WAT004.excIndRt'/>"; 
var LB_SGM_RGS_ARB = "<spring:message code='label.WAT004.sgmRgsArb'/>"; 
var LB_UPH = "<spring:message code='label.WAT004.uph'/>"; 
var LB_ITEM_CODE = "<spring:message code='label.WAT004.itemCode'/>"; 
var LB_ITEM_NM = "<spring:message code='label.WAT004.itemNm'/>"; 
var LN_IO_CHK1 = "<spring:message code='WAT-I0-Chk1'/>";

var LN_DEL_CHK1 = "<spring:message code='label.WAN000.delChk1'/>";
var LN_INS_CHK1 = "<spring:message code='label.WAN000.insChk1'/>";
var LN_INS_CHK2 = "<spring:message code='label.WAN000.insChk2'/>";
var LN_UPD_CHK1 = "<spring:message code='label.WAN000.updChk1'/>";
var LN_UPD_CHK2 = "<spring:message code='label.WAN000.updChk2'/>";
var LN_UPD_CHK3 = "<spring:message code='label.WAN000.updChk3'/>";
var LN_UPD_CHK4 = "<spring:message code='label.WAT000.updChk1'/>";

var LN_SELECT_DEPT = "<spring:message code='WAN-I0-0015'/>";
var LN_CHK_REPYM = "<spring:message code='label.WAS004.repym'/>"; //년월

var LB_JM_LABOR = "<spring:message code='label.WAT021.jmLabor'/>"; 
var LB_STDR_LABOR = "<spring:message code='label.WAT021.stdrLabor'/>";
var LB_RESULT_MAN_HOUR = "<spring:message code='label.WAT021.resultManHour'/>";
var LB_TOTAL_QY = "<spring:message code='label.WAT021.totalQY'/>";
var LB_JM_BASE_TIME = "<spring:message code='label.WAT021.jmBaseTime'/>";
var LB_INDEX_PLAN = "<spring:message code='label.WAT021.indexPlan'/>";
var LB_INDEX_RESULT = "<spring:message code='label.WAT021.indexResult'/>";
var LB_PROD_INDEX = "<spring:message code='label.WAT021.prodIndex'/>";
var LB_PROD_INDEX = "<spring:message code='label.WAT021.prodIndex'/>";
var LB_TTL = "<spring:message code='label.WAT021.ttl'/>";
var LB_NML_MNHR_STNDRD_TM = "<spring:message code='label.WAT021.nmlMnHrStndrdTm'/>";
var LB_PRDCTN_INPUT_TM = "<spring:message code='label.WAT021.prdctnInptTm'/>";


/*
$(function(){
	grid.initView({
		mkcar:{label:"<spring:message code='label.WAN004.mkcar'/>"},
		seyno:{label:"<spring:message code='label.WAN004.seyno'/>"},
		seycd:{label:"<spring:message code='label.WAN004.seycd'/>"},
	}).setData();
}); 
*/
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
	/*font-size: 11pt;*/
	/*font-size:10px;*/
}

.wj-header {
 	background: white;
  	text-align : center! important;      
}

.redRow{
	background-color:pink !important;
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
					<button type="button" id="searchBtn" class="AXButton Black" onclick="mainSearch();">
						<i class="axi axi-ion-android-search"></i>
						<spring:message code='label.search'/><!-- 조회 -->
					</button>
					<!-- <button type="button" class="pdfDown" onclick="downloadPdf();">
						<span><spring:message code='label.WAS000.pdfDown' /></span>
					</button> -->
					<button type="button" class="excelDown" onclick="downloadExcelTop();">
						<span><spring:message code='label.excelDown' /></span>
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
									<input type="text" class="dropbtn calendar_input getDumcb" name="getDumcb" id="getDumcb" value="${dumcb}"  onBlur ="clearGrid();"/>
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
					<!-- 사업부 -->
					<label class="k_l1">사업부</label>			
					<select id="getComps" name="getComps" class="getComps schLine" onchange ="clearComps();">
						<option value="E1">마산</option>
						<option value="C1">창원</option>
						<option value="S1">화성</option>
					</select>	
					<!-- 부서(반) -->
					<div class="inlineBlock schLine">
						<label class="k_l1"><spring:message code='label.WAT001.loc'/></label>	
						<input type="text" class="AXInput getCusnm" style="width : 60px;" name="getLocId" id="getLocId"  maxlength="8"
							onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)' onBlur="getDeptSch('input', this.value);">
						<button type="button" onclick="" class="AXButton Normal _custBtn_">
							<spring:message code="label.select" />
						</button>
						<input type="text" class="AXInput getCusnm" style="width : 180px;" name="getLocNm" id="getLocNm" placeholder="<spring:message code='WAN-I0-0015'/>" title="<spring:message code='WAN-I0-0015'/>" disabled readOnly>
					</div>	
					<button id="mesBt" type="button" onclick="return mesSave();" style="visibility:hidden;">MES 생산실적 가져오기</button>	
					<span id="mesSpan" style="color:red;visibility:hidden;">MES 최신 정보를 확인하시려면 "MES 생산실적 가져오기" 버튼을 클릭하십시오.</span>
				</div>
			</div>
			
			<div class="cb pt5 ">
				
			</div>
	    
		    <div id="theTabPanel" class="custom-headers tabs-below">
		    	<div>
		          	<a>품번별생산실적</a>
		          	 <div id="tab0" style="display: block;">
						<div class="gridContents" style="position: relative; height: 650px;">
					    	<div id="wijmoGrid" ></div>
				    	<a href="javascript:zoomIn($('#wijmoGrid'),flexGrid);">확대</a>
						<a href="javascript:zoomOut($('#wijmoGrid'),flexGrid);">축소</a>
					    </div>
		          	</div>
		         </div>
		        <div>
		          	<a>생산실적</a>
		          	<div id="tab1" style="display: none;">
						<div class="gridContents" style="position: relative; height: 650px;">
					    	<div id="wijmoGrid2" ></div>
					    	<a href="javascript:zoomIn($('#wijmoGrid2'),flexGrid);">확대</a>
							<a href="javascript:zoomOut($('#wijmoGrid2'),flexGrid);">축소</a>
					    </div>
		          	</div>
		        </div>
		        <div>
		          	<a>기준시간(시간)</a>
		          	<div id="tab2" style="display: none;">
						<div class="gridContents" style="position: relative; height: 650px;">
					    	<div id="wijmoGrid4" ></div>
					    	<a href="javascript:zoomIn($('#wijmoGrid4'),flexGrid);">확대</a>
							<a href="javascript:zoomOut($('#wijmoGrid4'),flexGrid);">축소</a>
					    </div>
		          	</div>
		        </div>
		        <div>
		          	<a>정미공수기준시간(분)</a>
		          	<div id="tab3" style="display: none;">
						<div class="gridContents" style="position: relative; height: 650px;">
					    	<div id="wijmoGrid3" ></div>
					    	<a href="javascript:zoomIn($('#wijmoGrid3'),flexGrid);">확대</a>
							<a href="javascript:zoomOut($('#wijmoGrid3'),flexGrid);">축소</a>
					    </div>
		          	</div>
		        </div>
		        <div>
		          	<a>직접생산투입시간(분)</a>
		          	<div id="tab4" style="display: none;">
						<div class="gridContents" style="position: relative; height: 650px;">
					    	<div id="wijmoGrid5" ></div>
					    	<a href="javascript:zoomIn($('#wijmoGrid5'),flexGrid);">확대</a>
							<a href="javascript:zoomOut($('#wijmoGrid5'),flexGrid);">축소</a>
					    </div>
		          	</div>
		        </div>
<!-- 		        
		        <div>
		        	<a>공수저감지수실적</a>
		        	<div id="tab5" style="display: none;">
						<div class="gridContents" style="position: relative; height: 650px;">
					    	<div id="wijmoGrid6" ></div>
					    	<a href="javascript:zoomIn($('#wijmoGrid6'),flexGrid);">확대</a>
							<a href="javascript:zoomOut($('#wijmoGrid6'),flexGrid);">축소</a>
					    </div>
		          	</div>
		        </div>
 -->		        
		        <div>
		        	<a>설총율</a>
		        	<div id="tab5" style="display: none;">
						<div class="gridContents" style="position: relative; height: 650px;">
					    	<div id="wijmoGrid7" ></div>
					    	<a href="javascript:zoomIn($('#wijmoGrid7'),flexGrid);">확대</a>
							<a href="javascript:zoomOut($('#wijmoGrid7'),flexGrid);">축소</a>
					    </div>
		          	</div>
		        </div>
<!-- 
		        <div>
		        	<a>공수저감지수목표</a>
		        	<div id="tab7" style="display: none;">
						<div class="gridContents" style="position: relative; height: 650px;">
					    	<div id="wijmoGrid8" ></div>
					    	<a href="javascript:zoomIn($('#wijmoGrid8'),flexGrid);">확대</a>
							<a href="javascript:zoomOut($('#wijmoGrid8'),flexGrid);">축소</a>
					    </div>
		          	</div>
		        </div>
 -->		        
			</div>
 		</div>
	</div>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/prdind/PrdPrfByItmNmbTab2.js?ver=1.2"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/prdind/PrdPrfByItmNmbTab3.js?ver=1.2"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/prdind/PrdPrfByItmNmbTab4.js?ver=1.2"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/prdind/PrdPrfByItmNmbTab5.js?ver=1.2"></script>
<!-- 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/prdind/PrdPrfByItmNmbTab6.js?ver=1.2"></script>
 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/prdind/PrdPrfByItmNmbTab7.js?ver=1.2"></script>
<!-- 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/prdind/PrdPrfByItmNmbTab8.js?ver=1.2"></script>
 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/prdind/PrdPrfByItmNmb.js?ver=1.2"></script>