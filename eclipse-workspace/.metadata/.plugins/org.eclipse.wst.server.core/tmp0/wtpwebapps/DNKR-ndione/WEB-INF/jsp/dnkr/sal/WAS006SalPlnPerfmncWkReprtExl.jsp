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
<script type="text/javascript" src="/wijmo/controls/wijmo.chart.annotation.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.chart.animation.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.pdf.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.nav.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.pdf.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.grid.pdf.min.js"></script>
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
var LN_INS_CHK1 = "<spring:message code='label.WAS006.insChk1'/>";
var LN_INS_CHK2 = "<spring:message code='label.WAN000.insChk2'/>";
var LN_UPD_CHK1 = "<spring:message code='label.WAN000.updChk1'/>";
var LN_UPD_CHK2 = "<spring:message code='label.WAN000.updChk2'/>";
var LN_UPD_CHK3 = "<spring:message code='label.WAN000.updChk3'/>";

var LN_CHK4 = "<spring:message code='label.WAN002.Chk4'/>";

var LB_YEAR = "<spring:message code='label.WAS006.year'/>"; //년도 
var LB_LOCCODE = "<spring:message code='label.WAS006.locCode'/>"; //공장
var LB_STANDRD = "<spring:message code='label.WAS006.standrd'/>"; //기준
var LB_MNUNIT = "<spring:message code='label.WAS006.mnUnit'/>"; //금액단위:억WON
var LB_PROGRSRATE = "<spring:message code='label.WAS006.progrsRate'/>"; //진도율
var LB_LOCNM = "<spring:message code='label.WAS006.locNm'/>"; //공장
var LB_MAJRITEM = "<spring:message code='label.WAS006.majrItem'/>"; //주요품목
var LB_SALPLAN = "<spring:message code='label.WAS006.salPlan'/>"; //판매계획
var LB_SALPERFRMNC = "<spring:message code='label.WAS006.salPerfrmnc'/>"; //판매실적
var LB_ACHIVRATE = "<spring:message code='label.WAS006.achivRate'/>"; //달성률
var LB_YEARSUM = "<spring:message code='label.WAS006.yearSum'/>"; //년계
var LB_SHTSUM = "<spring:message code='label.WAS006.shtSum'/>"; //단계
var LB_ACHIVRATESTANDARD = "<spring:message code='label.WAS006.achivRateStandard'/>"; //진도율기준
var LB_MARGIN = "<spring:message code='label.WAS006.margin'/>"; //차이
var LB_YEARSUMCOMPR = "<spring:message code='label.WAS006.yearSumCompr'/>"; //년계비
var LB_SHTSUMCOMPR = "<spring:message code='label.WAS006.shtSumCompr'/>"; //단계비
var LB_PROGRECOMPR = "<spring:message code='label.WAS006.progreCompr'/>"; //진도비

var LB_DATEINFO = "<spring:message code='label.WAS006.dateInfo'/>"; //조회할 주간의 월요일을 선택해 주세요.

var LN_FILE_NM = "<spring:message code='label.WAS006.fileNm'/>";

//차트라벨
var LB_CHAR1 = "<spring:message code='label.WAS006.charLb1'/>";
var LB_CHAR2 = "<spring:message code='label.WAS006.charLb2'/>";
var LB_CHAR3 = "<spring:message code='label.WAS006.charLb3'/>";
var LB_CHAR4 = "<spring:message code='label.WAS006.charLb4'/>";
var LB_CHAR5 = "<spring:message code='label.WAS006.charLb5'/>";
var LB_CHAR6 = "<spring:message code='label.WAS006.charLb6'/>";

var LB_COMENT1 = "<spring:message code='label.WAS006.coment1'/>";
var LB_COMENT2 = "<spring:message code='label.WAS006.coment2'/>";

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

.wj-flexchart .wj-header .wj-title {
  font-size: 15px;
  font-weight: bold;
}
.wj-flexchart .wj-footer .wj-title {
  font-size: 15px;
  font-weight: bold;
}

.wj-data-label {
	font-size: 10px;
}

.wj-header {
 	background: white;
    
}
.k_l2{
	width:70px;
	font-size: 15px;
}

.table{
	border : 1px solid #ABB2B9;
	float : right;
	width:330px;
	font-size: 15px;	
}


/* 2021.01.08 */
.k_cg1{padding:14px 10px 0 15px;}
.k_cg1 .k_bg1{width:340px;}
.k_cg1 .k_sg1{width:calc(100% - 340px);}

.salGrid {
    height:40%;
    min-height: 350px;
    margin-top: 10px;
    margin-bottom: 10px;
}
.dropdown input{
	border: 1px solid #ff0000;
	border-radius: 4px;
}
.stndrdDate{
	margin: 30px 770px 30px 0px;
}

.bntDiv{
	margin: 15px 0px 5px 0px;
}

._saveBtn1_{
	margin: 0px 0px 0px 690px;
}
._saveBtn2_{
	margin: 0px 0px 0px 655px;
	
}
.pdfDown1{
	margin: 0px 0px 0px 690px;
}
.pdfDown2{
	margin: 0px 0px 0px 655px;
	
}
.tabs-below {
    height: 100%;
    min-height: 570px;
}
</style>

<div class="grid-block team-ms">
	<div class="gridContents" style="" id="grid-parent">
		<div style="margin: 0px 15px 0px 0px;">
			<div class="k_cg1">
				<div class="gridBtnBlock k_bg1">
				<input type="hidden" class="today"  name="today" id="today" value="${startDate}"/>
					<button type="button" id="searchBtn" class="AXButton Black" onclick="search();">
						<i class="axi axi-ion-android-search"></i>
						<spring:message code='label.search'/><!-- 조회 -->
					</button>
					<button type="button" class="pdfDown" onclick="downloadPdf();">
						<span><spring:message code='label.WAS000.pdfDown' /></span>
					</button>
				</div>
		
				<div class="gridBtnBlock k_sg1">
				<div class="board-bList-wrap log_board1">
					<!-- 년,월,주 캘린더 -->
					<label class="k_l1"><spring:message code='label.WAS006.ymw'/></label>
						<div class="dropdown">						
							<span class="calendar_icon vcen2"></span>
							<input type="text" class="dropbtn calendar_input"  name="startDate" id="startDate" value="${startDate2}" onblur="clearGrid();"/>
							<div class="dropdown-menu" role="menu"  id="log_calendar" style="width:250px;
							           border:1px solid #ccc;
							           border-radius: 5px;
							           padding: 5px;
							           overflow: hidden;">
						</div>
						~
						<div class="dropdown">
							<span class="calendar_icon vcen2"></span>
							<input type="text" class="dropbtn calendar_input" name="endDate" id="endDate" value="${endDate}" onblur="clearGrid();"/>
							<div class="dropdown-menu" role="menu" id="chk_calendar" style="width:250px; 
							           border:1px solid #ccc;
							           border-radius: 5px;
							           padding: 5px;
							           overflow: hidden;">
							</div>
						</div>
					</div>
					<!-- 계획구분 -->
					<label class="k_l1"><spring:message code='label.WAS005.planPart'/></label>
					<select name="getPlngb" id="getPlngb" class="getPlngb requiredLine" onchange="clearGrid('2');">
						<option value="1"><spring:message code='label.WAS007.charLb6'/></option><!-- 계획 -->
						<option value="2" disabled="disabled"><spring:message code='label.WAS006.update'/></option><!-- 수정 -->
					</select>
				</div>
				</div>
			</div>
			
			<div class="cb pt5 ">
			</div>
	    	<div class="chartContents" style="position: relative; height: 680px;">
		    	<div id="chartMaker" class="chart-block1"></div>
		    	<table class="table">
		    	<th class="tableHeader" border = "1px solid black" bgcolor = "#EAECEE"><spring:message code='label.WAS006.progrsRate' /></th>
		    	<td id="rate" align = "right">${rate}</td>
		    	</table>
		    	<div class="gridInfo" id="gridInfo">
		    	<a class="stndrdDate" id="stndrdDate"> </a>
		    	<span><spring:message code='label.WAS006.mnUnit' /></span>
		    	</div>
		    	<div id="wijmoGrid" ></div>
				<a href="javascript:zoomIn($('#wijmoGrid'),flexGrid);"><spring:message code='label.WAS000.gridSize1' /></a><!-- 확대 -->
				<a href="javascript:zoomOut($('#wijmoGrid'),flexGrid);"><spring:message code='label.WAS000.gridSize2' /></a><!-- 축소 -->
				<div class="comment" style="display: none;">
				    <table>
				    <tr>
					<div class="bntDiv" >
					    <td>
						<div class="inlineBlock btn1" style="float: right;" >
							<button type="button" class="pdfDown1" id="pdfDown1" value="1" style="float: right;">
								<spring:message code='label.WAS006.update' />
								<!-- 수정 -->
							</button>
							<button type="button" class="AXButton Red _saveBtn1_" value="1" onclick="return update('1');" style="display: none;float: right;"">
								<spring:message code='label.WAS006.save' />
								<!-- 등록 -->
							</button>
						</div>						
						</td>
						<td>
						<div class="inlineBlock btn2" style="float: right;" >
							<button type="button" class="pdfDown2" id="pdfDown2" value="2" style="float: right;">
								<spring:message code='label.WAS006.update' />
								<!-- 수정 -->
							</button>
							<button type="button" class="AXButton Red _saveBtn2_" value="2" onclick="return update('2');" style="display: none;float: right;">
								<spring:message code='label.WAS006.save' />
								<!-- 등록 -->
							</button>
						</div>
						</td>
					</div>
					</tr>
					<tr>
						<td>
						<textarea id="text1" name="text1" style="width: 99%; height: 200px;" readonly="true;">${text1}</textarea>
						</td>
						<td>
						<textarea id="text2" name="text2" style=" width: 99%; height: 200px;" readonly="true;">${text2}</textarea>
						</td>
					</tr>
						<td>	<input type="hidden" id="comps1" name="comps1" value="" />
						</td>
						<td><input type="hidden" id="comps2" name="comps2" value="" />
						</td>
					</tr>
						<td>	<input type="hidden" id="reprtse1" name="reprtse1" value="" />
						</td>
						<td>	<input type="hidden" id="reprtse2" name="reprtse2" value="" />
						</td>
					</tr>
						<td>	<input type="hidden" id="cmnitm1" name="cmnitm1" value="" />
						</td>
						<td>	<input type="hidden" id="cmnitm2" name="cmnitm2" value="" />
						</td>
					</tr>

					</table>
				</div>
			</div>
 		</div>
	</div>
</div>


<script>
	//code generator 후 js파일 경로 수정해줘야함.
	$.getScript('/js/sal/WAS006SalPlnPerfmncWkReprtExl.js');
</script>
<script src="http://html2canvas.hertzen.com/dist/html2canvas.min.js"></script>
   


