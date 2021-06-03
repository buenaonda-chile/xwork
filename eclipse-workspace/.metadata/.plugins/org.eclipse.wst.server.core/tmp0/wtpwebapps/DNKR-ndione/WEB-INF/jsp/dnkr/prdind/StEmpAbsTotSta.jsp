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


var LN_DEL_CHK1 = "<spring:message code='label.WAN000.delChk1'/>";
var LN_INS_CHK1 = "<spring:message code='label.WAN000.insChk1'/>";
var LN_INS_CHK2 = "<spring:message code='label.WAN000.insChk2'/>";
var LN_UPD_CHK1 = "<spring:message code='label.WAN000.updChk1'/>";
var LN_UPD_CHK2 = "<spring:message code='label.WAN000.updChk2'/>";
var LN_UPD_CHK3 = "<spring:message code='label.WAN000.updChk3'/>";
var LN_UPD_CHK4 = "<spring:message code='label.WAT000.updChk1'/>";

var LN_SELECT_DEPT = "<spring:message code='WAN-I0-0015'/>"; //부서(반)을 선택해 주세요.
var LN_SELECT_LINE = "<spring:message code='WAN-I0-0018'/>"; //라인코드를 입력해 주세요.

var LN_CHK_REPYM = "<spring:message code='label.WAS004.repym'/>"; //년월

var LB_JM_LABOR = "<spring:message code='label.WAT021.jmLabor'/>"; 
var LB_STDR_LABOR = "<spring:message code='label.WAT021.stdrLabor'/>";
var LB_RESULT_MAN_HOUR = "<spring:message code='label.WAT021.resultManHour'/>";
var LB_TOTAL_QY = "<spring:message code='label.WAT021.totalQY'/>";
var LB_JM_BASE_TIME = "<spring:message code='label.WAT021.jmBaseTime'/>";
var LB_INDEX_PLAN = "<spring:message code='label.WAT021.indexPlan'/>";
var LB_INDEX_RESULT = "<spring:message code='label.WAT021.indexResult'/>";
var LB_PROD_INDEX = "<spring:message code='label.WAT021.prodIndex'/>";
var LN_SELECT_COMPS = "<spring:message code='WAN-I0-0001'/>";

var LB_CODE = "<spring:message code='label.WAT001.code'/>";
var LB_NAME = "<spring:message code='label.WAT001.name'/>";
var LB_CLS_CODE = "<spring:message code='label.WAT001.comps'/>";
var LB_LOC = "<spring:message code='label.WAT001.loc'/>";
var LB_PART = "<spring:message code='label.WAT001.part'/>";

var LB_GROUP = "<spring:message code='label.WAT025.group'/>";
var LB_PART_CODE = "<spring:message code='label.WAT025.partCode'/>";
var LB_PART_NM = "<spring:message code='label.WAT025.partNm'/>";
var LB_LOC_CODE = "<spring:message code='label.WAT025.locCode'/>";
var LB_LOC_NM = "<spring:message code='label.WAT025.locNm'/>";
var LB_BA_UNI = "<spring:message code='label.WAT025.BaUni'/>";
var LB_RE_CNT = "<spring:message code='label.WAT025.reCnt'/>";
var LB_FR_RA = "<spring:message code='label.WAT025.frRa'/>";
var LB_ST_TI_YCT = "<spring:message code='label.WAT025.stTiYct'/>";
var LB_ST_TI_PR = "<spring:message code='label.WAT025.stTiPr'/>";
var LB_OB_TI = "<spring:message code='label.WAT025.obTi'/>";
var LB_HR_MNT_DE = "<spring:message code='label.WAT025.hrMntDe'/>";
var LB_PR_IN = "<spring:message code='label.WAT025.prIn'/>";
var LB_PR_IND = "<spring:message code='label.WAT025.prInd'/>";
var LB_ST_LA = "<spring:message code='label.WAT025.stLa'/>";
var LB_PMON_PRF = "<spring:message code='label.WAT025.pmonPrf'/>";
var LB_WS_RE_IN = "<spring:message code='label.WAT025.wsReIn'/>";
var LB_PRF_IND = "<spring:message code='label.WAT025.prfInd'/>";
var LB_ACH_RA = "<spring:message code='label.WAT025.achRa'/>";
var LB_UND_TI = "<spring:message code='label.WAT025.undTi'/>";
var LB_EFF_AMO = "<spring:message code='label.WAT025.effAmo'/>";
var LB_PRD_OB_EFF_AMO = "<spring:message code='label.WAT025.prdObEffAmo'/>";
var LB_PRD_EFF_AMO = "<spring:message code='label.WAT025.prdEffAmo'/>";
var LB_UND_AMO = "<spring:message code='label.WAT025.undAmo'/>";
var LB_EX_IND_TI = "<spring:message code='label.WAT025.exIndTi'/>";
var LB_TOT_HR_MNT = "<spring:message code='label.WAT025.totHrMnt'/>";
var LB_EX_TI_OB = "<spring:message code='label.WAT025.exTiOb'/>";
var LB_EX_TI_PRF = "<spring:message code='label.WAT025.exTiPrf'/>";
var LB_EX_USE_RA = "<spring:message code='label.WAT025.exUseRa'/>";
var LB_IND_TI_OB = "<spring:message code='label.WAT025.indTiOb'/>";
var LB_IND_TI_PRF = "<spring:message code='label.WAT025.indTiPrf'/>";
var LB_IND_USE_RA = "<spring:message code='label.WAT025.indUseRa'/>";
var LB_EX_IND_TI_OB = "<spring:message code='label.WAT025.exIndTiOb'/>";
var LB_EX_IND_TI_PRF = "<spring:message code='label.WAT025.exIndTiPrf'/>";
var LB_EX_IND_USE_RA = "<spring:message code='label.WAT025.exIndUseRa'/>";

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
.gridContents1 {
    width: 98%;
	overflow-x: auto;
}

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
.k_cg1 .k_bg1{width:400px;}
.k_cg1 .k_sg1{width:calc(100% - 400px);}


</style>


<div class="grid-block team-ms">
	<div class="gridContents" style="" id="grid-parent">
		<div style="margin: 0px 15px 0px 0px;">
			<div class="k_cg1" style="text-align: center">
				<div class="gridBtnBlock k_bg1">
					
					<!-- button type="button" class="AXButton Normal" onclick="mailSend();">
						<spring:message code='label.mailSend1'/>
					</button--><!-- 메일발송 -->
					
					<button type="button" class="AXButton Black" onclick="search();">
						<i class="axi axi-ion-android-search"></i>
						<spring:message code='label.search'/><!-- 조회 -->
					</button>
		
					<div class="inlineBlock">
						<!--button type="button" class="AXButton Normal"  style="margin-left: 10px;" onclick="return update()">
							<spring:message code="label.save" />
						</button--><!-- 저장 -->
						<!-- button type="button" class="AXButton Normal _delBtn" style="margin-left: 10px;" onclick="">
							<spring:message code="label.delete" />
						</button--><!-- 삭제 -->
					</div>
					
					<button type="button" class="xlsDown" onclick="downloadExcel();">
						<span><spring:message code='label.excelDown' /></span><!-- 엑셀다운로드 -->
					</button>
				</div>			
	  			<div class="k_sg4">
					<div class="board-bList-wrap log_board">
						<div class="gridBtnBlock k_sg1">
							<label class="k_l1">작업일자</label>
							<div id="theInputDate" style="margin-right: 15px;"></div>										
<!-- 							
							<div class="dropdown schLine">						
								<span class="calendar_icon vcen2"></span>
								<input type="text" class="dropbtn calendar_input getOpertDe" name="getOpertDe" id="getOpertDe" onBlur ="clearGrid();" />
								<div class="dropdown-menu" role="menu"  id="plndt_calendar" style="width:250px;
								           border:1px solid #ccc;
								           border-radius: 5px;
								           padding: 5px;
								           overflow: hidden;" >
								</div>
							</div>				
 -->									
							<label class="k_l1">사업부</label>			
							<select id="getComps" name="getComps" class="getComps schLine" onchange ="clearGrid();">
								<option value="E1">마산</option>
								<option value="C1">창원</option>
								<option value="S1">화성</option>
							</select>							
						</div>	
					</div>
				</div>
			</div>
			<div class="gridContents" style="position: relative; height: 650px;">
		    	<div id="wijmoGrid" ></div>	       
		    </div>
		</div>	 	       
	</div>
	
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/prdind/StEmpAbsTotSta.js?ver=1.127"></script>