<%--
 * 占�
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

<link rel="stylesheet" href="/wijmo/styles/wijmo.css"/>
<script type="text/javascript" src="/wijmo/controls/wijmo.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.grid.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.input.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.xlsx.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.grid.xlsx.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.grid.filter.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/cultures/wijmo.culture.ko.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/jszip.min.js"></script>  


<script>
	$.getScript('/js/prdind/LosExcIndTm.js');
</script>
<script  type="text/javascript">
//wijmo LicenseKey �ㅼ��
wijmo.setLicenseKey('${wijmoLicenseKey}');

var LB_COMPS = "<spring:message code='label.WAT001.comps'/>"; 
var LB_EMP_NUMBER = "<spring:message code='label.WAT007.empNumber'/>"; 
var LB_FULL_NM = "<spring:message code='label.WAT007.fullNm'/>";
var LB_CPN_CODE = "<spring:message code='label.WAT001.code'/>"; 
var LB_CPN_NM = "<spring:message code='label.WAT001.codeNm'/>";

var LN_SELECT_COMPS = "<spring:message code='WAN-I0-0001'/>";
var LN_SELECT_DEPT = "<spring:message code='WAN-I0-0015'/>";
var LN_IO_CHK1 = "<spring:message code='WAT-I0-Chk1'/>";

var LN_DEL_CHK1 = "<spring:message code='label.WAN000.delChk1'/>";
var LN_INS_CHK1 = "<spring:message code='label.WAN000.insChk1'/>";
var LN_INS_CHK2 = "<spring:message code='label.WAN000.insChk2'/>";
var LN_UPD_CHK1 = "<spring:message code='label.WAN000.updChk1'/>";
var LN_UPD_CHK2 = "<spring:message code='label.WAN000.updChk2'/>";
var LN_UPD_CHK3 = "<spring:message code='label.WAN000.updChk3'/>";
var LN_UPD_CHK4 = "<spring:message code='label.WAT000.updChk1'/>";

var VIW_ID = "014";
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

/* 2021.01.08 */
.k_cg1{padding:14px 10px 0 15px;}
.k_cg1 .k_bg1{width:340px;}
.k_cg1 .k_sg1{width:calc(100% - 340px);}



</style>

<div class="grid-block team-ms">
	<div class="gridContents" style="" id="grid-parent" >
		<div style="margin: 0px 15px 0px 0px;">
			<div class="k_cg1" style="text-align: center">
				<div class="gridBtnBlock k_bg1">
					<button type="button" class="AXButton Black" onclick="return search()">
						<i class="axi axi-ion-android-search"></i>
						<spring:message code='label.search'/><!-- 조회 -->
					</button>
		
					<div class="inlineBlock">
						<button type="button" class="AXButton Normal" style="" onclick="return update()">
							<spring:message code="label.save" /><!-- 저장 -->
						</button>
						<button type="button" class="AXButton Normal" id="delBtn" style="" >
							<spring:message code="label.delete" /><!-- 삭제 -->
						</button>
					</div>
					
					<button type="button" class="xlsDown" onclick="downloadExcel();">
						<span><spring:message code='label.excelDown' /></span><!-- 엑셀다운 -->
					</button>
				</div>			
			
	  			<div class="k_sg4">
					<div class="board-bList-wrap log_board">
						<div class="gridBtnBlock k_sg1">
									
							<label class="k_l1"><spring:message code='label.WAN002.comps2'/></label>			
							<select id="getComps" name="getComps" class="getComps schLine" onchange ="clearGrid();">
								<option value="E1"><spring:message code='label.WAT012.masan'/></option>
								<option value="C1"><spring:message code='label.WAT012.changwon'/></option>
								<option value="S1"><spring:message code='label.WAT012.hwasung'/></option>
							</select>
							
							<div class="inlineBlock schLine">
								<label class="k_l1"><spring:message code='label.WAT001.loc'/></label>	
								<input type="text" class="AXInput getPyvnd" style="width : 60px;" name="getLocId" id="getLocId"  maxlength="8"
									onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)' onBlur="getDeptSch('input', this.value);">
								<button type="button" onclick="" class="AXButton Normal _custBtn_">
									<spring:message code="label.select" />
								</button>
								<input type="text" class="AXInput getCusnm" style="width : 180px;" name="getLocNm" id="getLocNm" placeholder="<spring:message code='WAN-I0-0015'/>" title="<spring:message code='WAN-I0-0015'/>" disabled readOnly>
							</div>	
							
							<label class="k_l1"><spring:message code='label.WAT014.workDay'/></label>
							<div class="dropdown schLine">						
								<span class="calendar_icon vcen2"></span>
								<input type="text" class="dropbtn calendar_input opertDe" name="opertDe" id="opertDe" onBlur ="clearGrid();" />
								<div class="dropdown-menu" role="menu"  id="plndt_calendar" style="width:250px;
								           border:1px solid #ccc;
								           border-radius: 5px;
								           padding: 5px;
								           overflow: hidden;" >
								</div>
							</div>	
								
						</div>	
					</div>
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


