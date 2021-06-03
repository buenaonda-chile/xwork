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
var LB_JM_LABOR = "<spring:message code='label.WAT004.jmLabor'/>"; 
var LB_PRFR_TIME = "<spring:message code='label.WAT004.prfrTime'/>"; 
var LB_MRG_FCT = "<spring:message code='label.WAT004.mrgFct'/>"; 
var LB_STDR_LABOR = "<spring:message code='label.WAT004.stdrLabor'/>"; 
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
			<div class="k_cg1" style="text-align: center">
				<div class="k_sg1 gridBtnBlock" style="text-align: center">
					<label class="k_l1">사업부</label>			
					<select id="getComps" name="getComps" class="getComps schLine" onchange ="initSetMaster();">
						<option value="E1">마산</option>
						<option value="C1">창원</option>
						<option value="S1">화성</option>
					</select>	
					<label class="k_l1">년도</label>
					<input type="text" class="AXInput getYear" style="width:50px; margin: 0px 15px 0px 0px;" name="getYear" id="getYear" maxlength="4" onfocusout ="search();">
					<label class="k_l1">상/하반기 구분</label>			
					<select id="getFsHalf" name="getFsHalf" class="getFsHalf schLine" onchange ="search();">
						<option value="F">상반기</option>
						<option value="S">하반기</option>
					</select>
					<label class="k_l1">품목코드</label>
					<input type="text" class="AXInput getPyvnd" style="width : 100px;" name="getItemCode" id="getItemCode" >
					<label class="k_l1">품목명</label>
					<input type="text" class="AXInput getPyvnd" style="width : 300px;" name="getItemNm" id="getItemNm">						
						
				</div>
			
				<div class="gridBtnBlock k_bg1">
					<button type="button" class="AXButton Black" onclick="search();">
						<i class="axi axi-ion-android-search"></i>
						<spring:message code='label.search'/><!-- 조회 -->
					</button>
		
					<div class="inlineBlock">
						<button type="button" class="AXButton Normal" style="" onclick="return update()">
							<spring:message code="label.save" /><!-- 저장 -->
						</button>
						<button type="button" class="AXButton Normal _delBtn" style="" onclick="">
							<spring:message code="label.delete" /><!-- 삭제 -->
						</button>
					</div>
					
					<div class="inlineBlock">
						<button type="button" class="AXButton Red _addBtn_" style="" onclick = "">
							<i><!--  class="axi axi-ion-person-add"> --></i>
							<spring:message code='label.register'/><!-- 추가 -->
						</button>
					</div>
					
					<button type="button" class="xlsDown" onclick="downloadExcel();">
						<span><spring:message code='label.excelDown' /></span><!-- 엑셀다운로드 -->
					</button>
				</div>			
		
			</div>	

			<div class="gridContents" style="position: relative; height: 650px;">
		    	<div id="wijmoGrid" ></div>
		    	<a href="javascript:zoomIn($('#wijmoGrid'),flexGrid);">확대</a>
				<a href="javascript:zoomOut($('#wijmoGrid'),flexGrid);">축소</a>
									       
		    </div>
		    
		</div>	 	       
	</div>
	
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/prdind/MnhrCntrBaseBaseBase.js"></script>