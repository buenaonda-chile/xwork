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


var LN_DEL_CHK1 = "<spring:message code='label.WAN000.delChk1'/>";
var LN_INS_CHK1 = "<spring:message code='label.WAS006.insChk1'/>";
var LN_INS_CHK2 = "<spring:message code='label.WAN000.insChk2'/>";
var LN_UPD_CHK1 = "<spring:message code='label.WAN000.updChk1'/>";
var LN_UPD_CHK2 = "<spring:message code='label.WAN000.updChk2'/>";
var LN_UPD_CHK3 = "<spring:message code='label.WAN000.updChk3'/>";

var LN_CHK4 = "<spring:message code='label.WAN002.Chk4'/>";

var LN_TITLE1 = "<spring:message code='label.WAS008.title1'/>";
var LN_TITLE2 = "<spring:message code='label.WAS008.title2'/>";

var LN_OPT_1 = "<spring:message code='label.WAS000.opt1'/>";
var LN_OPT_2 = "<spring:message code='label.WAS000.opt2'/>";
var LN_OPT_3 = "<spring:message code='label.WAS000.opt3'/>";

var LB_LOCNM1 = "<spring:message code='label.WAS000.locNm1'/>";
var LB_LOCNM3 = "<spring:message code='label.WAS000.locNm3'/>";
var LB_LOCNM4 = "<spring:message code='label.WAS000.locNm4'/>";
	
var LN_FILE_NM = "<spring:message code='label.WAS008.fileNm'/>";

var LN_ALERT_MS = "<spring:message code='label.WAS008.slectalert'/>";

var LN_COMENT_TITLE1 = "<spring:message code='label.WAS008.comentTitle1'/>";
var LN_COMENT_TITLE2 = "<spring:message code='label.WAS008.comentTitle2'/>";
var LN_COMENT_TITLE3 = "<spring:message code='label.WAS008.comentTitle3'/>";
var LN_COMENT_TITLE4 = "<spring:message code='label.WAS008.comentTitle4'/>";
var LN_COMENT_TITLE5 = "<spring:message code='label.WAS008.comentTitle5'/>";

var LN_CHART_TITLE1 = "<spring:message code='label.WAS008.chartTitle1'/>";
var LN_CHART_TITLE2 = "<spring:message code='label.WAS008.chartTitle2'/>";
var LN_CHART_TITLE3 = "<spring:message code='label.WAS008.chartTitle3'/>";
var LN_CHART_TITLE4 = "<spring:message code='label.WAS008.chartTitle4'/>";
var LN_CHART_TITLE5 = "<spring:message code='label.WAS008.chartTitle5'/>";
var LN_CHART_TITLE6 = "<spring:message code='label.WAS008.chartTitle6'/>";

var LN_CHART_LB1 = "<spring:message code='label.WAS000.charLb1'/>";
var LN_CHART_LB2 = "<spring:message code='label.WAS000.charLb2'/>";
var LN_CHART_LB3 = "<spring:message code='label.WAS000.charLb3'/>";
var LN_CHART_LB4 = "<spring:message code='label.WAS000.charLb4'/>";

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

.chart-block1{
	width: 25vw;
    min-width: 350px;
    display: inline-block;
    margin: 0 5px 15px;
}

.chart-block2{
	width: 15vw;
    min-width: 200px;
    display: inline-block;
    margin: 0 5px 15px;
}

.comment{
	width: 30%;
    min-width: 200px;
    display: inline-block;
    margin: 0 5px 15px;
}

.wj-flexchart {
	height: 400px;
}
.wj-data-label {
	font-size: 10px;
}
.wj-flexchart .wj-header .wj-title {
  font-size: 13px;
  font-weight: bold;
}
.wj-flexchart .wj-footer .wj-title {
  font-size: 13px;
  font-weight: bold;
}
.wj-flexchart .wj-axis-x .wj-label {
  font-size: 13px;
}

/* 2021.01.08 */
.k_cg1{padding:14px 10px 0 15px;}
.k_cg1 .k_bg1{width:340px;}
.k_cg1 .k_sg1{width:calc(100% - 340px);}

.dropdown input{
	border: 1px solid #ff0000;
	border-radius: 4px;
}
._saveBtn1_{
	margin: 10px 0px 3px 0px;
}
._saveBtn2_{
	margin: 10px 0px 3px 0px;
}
.pdfDown1{
	margin: 10px 0px 3px 0px;
}
.pdfDown2{
	margin: 10px 0px 3px 0px;
}
.tabs-below {
    height: 100%;
    min-height: 600px;
}
</style>

<div class="grid-block team-ms">
	<div class="gridContents" style="" id="grid-parent">
		<div style="margin: 0px 15px 0px 0px;">
			<div class="k_cg1">
				<div class="gridBtnBlock k_bg1">
					<button type="button" id="searchBtn" class="AXButton Black" onclick="search();">
						<i class="axi axi-ion-android-search"></i>
						<spring:message code='label.search'/><!-- 조회 -->
					</button>
					<button type="button" class="pdfDown" onclick="downloadPdf();">
						<!--<span><spring:message code='label.excelDown' /></span> 엑셀다운로드 -->
						<span><spring:message code='label.WAS000.pdfDown' /></span>
					</button>
				</div>
		
				<div class="gridBtnBlock k_sg1">
					<!-- 년,월 캘린더 -->
					<div class="board-bList-wrap log_board">
						<div class="list-top">
							<div class="fl schLine">
								<label class="k_l1"><spring:message code='label.WAS000.repym'/></label>
								<div class="dropdown">
									<span class="calendar_icon vcen2"></span>
									<input type="text" class="dropbtn calendar_input getDumcb" name="getDumcb" id="getDumcb" value="${dumcb}" onblur="clearGrid('1');"/>
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
					<label class="k_l1"><spring:message code='label.WAS000.comps'/></label>
					<select name="getComps" id="getComps" class="getComps requiredLine" onchange="clearGrid('2');"/>
						<option value="AL"><spring:message code='label.WAS000.opt1'/></option><!-- 전체 -->
						<option value="PE"><spring:message code='label.WAS000.opt2'/></option><!-- 마산 -->
						<option value="PS"><spring:message code='label.WAS000.opt3'/></option><!-- 창원,화성 -->
					</select>
					<!-- 계획구분 -->
					<label class="k_l1"><spring:message code='label.WAS005.planPart'/></label>
					<select name="getPlngb" id="getPlngb" class="getPlngb requiredLine" onchange="clearGrid('2');">
						<option value="1"><spring:message code='label.WAS007.charLb6'/></option><!-- 계획 -->
						<option value="2" disabled="disabled"><spring:message code='label.WAS006.update'/></option><!-- 수정 -->
					</select>
					<br>
					<button type="button" class="AXButton loadMore">
						<span><spring:message code='label.WAS007.loadMore' /></span><!-- 더보기 -->
					</button>
					<button type="button" class="AXButton close"  style="display: none;">
						<span><spring:message code='label.WAS007.close' /></span><!-- 닫기 -->
					</button>
				</div>
				<div class="checkboxWrap" style="display: none;">
				<div class="k_sg4 checkboxAllList" style="display: none;">
					<div class="inlineBlock schLine2" >
					<strong><spring:message code='label.WAS008.slectalert'/></BR>  
							<spring:message code='label.WAS008.slectalert2'/></strong></BR>
					<strong>-- <spring:message code='label.WAS000.locNm1'/> --</strong></BR><!-- 마산 -->
						<c:if test="${fn:length(prdcdE1List) > 0}">
								<c:forEach var="prdcdE1AllList" items="${prdcdE1List}" varStatus="status">
									<c:choose>
										<c:when test="${status.index%10 == 0 && status.index > 0}">
											</br><span style="width:200px"><input type="checkbox" class="prdcdE1List" id="${prdcdE1AllList.prdnm}" value="${prdcdE1AllList.prdcd}" name="prdcdE1List"  style="width:20px" onclick="CountChecked()"/>
											<label for="${prdcdE1AllList.prdnm}" class="k_l2" style="width: 130px;" ><c:out value="${prdcdE1AllList.prdnm}"/></label></span>
										</c:when>
									<c:otherwise>
											<span style="width:200px"><input type="checkbox" class="prdcdE1List" id="${prdcdE1AllList.prdnm}" value="${prdcdE1AllList.prdcd}" name="prdcdE1List" onclick="CountChecked()"/>
												<label for="${prdcdE1AllList.prdnm}" class="k_l2" style="width: 130px;" ><c:out value="${prdcdE1AllList.prdnm}"/></label></span>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</c:if>
					</div>
						<div class="inlineBlock schLine2" >
							<strong>-- <spring:message code='label.WAS000.locNm3'/> --</strong></BR><!-- 창원 -->
							<c:if test="${fn:length(prdcdS1List) > 0}">
								<c:forEach var="prdcdS1AllList" items="${prdcdS1List}" varStatus="status">
								    <c:choose>
									    <c:when test="${status.index%10 == 0 && status.index > 0}">
											</br><span style="width:200px"><input type="checkbox" class="prdcdC1List" id="${prdcdS1AllList.prdnm}" value="${prdcdS1AllList.prdcd}" name="prdcdC1List"  style="width:20px" onclick="CountChecked()"/>
												<label for="${prdcdS1AllList.prdnm}" class="k_l2" style="width: 130px;" ><c:out value="${prdcdS1AllList.prdnm}"/></label></span>											
										</c:when>
										<c:otherwise>
											<span style="width:200px"><input type="checkbox" class="prdcdC1List" id="${prdcdS1AllList.prdnm}" value="${prdcdS1AllList.prdcd}" name="prdcdC1List"  style="width:20px" onclick="CountChecked()"/>
												<label for="${prdcdS1AllList.prdnm}" class="k_l2" style="width: 130px;" ><c:out value="${prdcdS1AllList.prdnm}"/></label></span>	
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</c:if>
						</div>
						<div class="inlineBlock schLine2" >
							<strong>-- <spring:message code='label.WAS000.locNm4'/> --</strong></BR><!-- 화성 -->
							<c:if test="${fn:length(prdcdS1List) > 0}">
								<c:forEach var="prdcdS1AllList" items="${prdcdS1List}" varStatus="status">
								    <c:choose>
									    <c:when test="${status.index%10 == 0 && status.index > 0}">
											</br><span style="width:200px"><input type="checkbox" class="prdcdS1List" id="${prdcdS1AllList.prdcd}" value="${prdcdS1AllList.prdcd}" name="prdcdS1List"  style="width:20px" onclick="CountChecked()"/>
												<label for="${prdcdS1AllList.prdcd}" class="k_l2" style="width: 130px;" ><c:out value="${prdcdS1AllList.prdnm}"/></label></span>											
										</c:when>
										<c:otherwise>
											<span style="width:200px"><input type="checkbox" class="prdcdS1List" id="${prdcdS1AllList.prdcd}" value="${prdcdS1AllList.prdcd}" name="prdcdS1List"  style="width:20px" onclick="CountChecked()"/>
												<label for="${prdcdS1AllList.prdcd}" class="k_l2" style="width: 130px;" ><c:out value="${prdcdS1AllList.prdnm}"/></label></span>	
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</c:if>
						</div>
					</div>
				<div class="k_sg4 checkboxS1List" style="display: none;">
				<div class="inlineBlock schLine2" >
				<strong><spring:message code='label.WAS008.slectalert'/></BR>  
							<spring:message code='label.WAS008.slectalert2'/></strong></BR>
							<strong>-- <spring:message code='label.WAS000.locNm3'/> --</strong></BR><!-- 창원 -->
							<c:if test="${fn:length(prdcdS1List) > 0}">
								<c:forEach var="prdcdS1AllList" items="${prdcdS1List}" varStatus="status">
								    <c:choose>
									    <c:when test="${status.index%10 == 0 && status.index > 0}">
											</br><span style="width:200px"><input type="checkbox" class="prdcdC1List" id="${prdcdS1AllList.prdcd}" value="${prdcdS1AllList.prdcd}" name="prdcdC1List"  style="width:20px" onclick="CountChecked()"/>
												<label for="${prdcdS1AllList.prdcd}" class="k_l2" style="width: 130px;" ><c:out value="${prdcdS1AllList.prdnm}"/></label></span>											
										</c:when>
										<c:otherwise>
											<span style="width:200px"><input type="checkbox" class="prdcdC1List" id="${prdcdS1AllList.prdcd}" value="${prdcdS1AllList.prdcd}" name="prdcdC1List"  style="width:20px" onclick="CountChecked()"/>
												<label for="${prdcdS1AllList.prdcd}" class="k_l2" style="width: 130px;" ><c:out value="${prdcdS1AllList.prdnm}"/></label></span>	
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</c:if>
						</div>
					<div class="inlineBlock schLine2" >	
							<strong>-- <spring:message code='label.WAS000.locNm4'/> --</strong></BR><!-- 화성 -->
							<c:if test="${fn:length(prdcdS1List) > 0}">
								<c:forEach var="prdcdS1AllList" items="${prdcdS1List}" varStatus="status">
									<c:choose>
										<c:when test="${status.index%10 == 0 && status.index > 0}">
											</br><span style="width:200px"><input type="checkbox" class="prdcdS1List" id="${prdcdS1AllList.prdcd}" value="${prdcdS1AllList.prdcd}" name="prdcdS1List" onclick="CountChecked()"/>
												<label for="${prdcdS1AllList.prdcd}" class="k_l2" style="width: 130px;" ><c:out value="${prdcdS1AllList.prdnm}"/></label></span>
										</c:when>
										<c:otherwise>
											<span style="width:200px"><input type="checkbox" class="prdcdS1List" id="${prdcdS1AllList.prdcd}" value="${prdcdS1AllList.prdcd}" name="prdcdS1List" onclick="CountChecked()"/>
												<label for="${prdcdS1AllList.prdcd}" class="k_l2" style="width: 130px;" ><c:out value="${prdcdS1AllList.prdnm}"/></label></span>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</c:if>
						</div>
				</div>
				<div class="k_sg4 checkboxE1List" style="display: none;">
					<div class="inlineBlock schLine2" >
							<strong><spring:message code='label.WAS008.slectalert'/></BR>  
							<spring:message code='label.WAS008.slectalert2'/></strong></BR>
							<c:if test="${fn:length(prdcdE1List) > 0}">
								<c:forEach var="prdcdE1AllList" items="${prdcdE1List}" varStatus="status">
									<c:choose>
										<c:when test="${status.index%10 == 0 && status.index > 0}">
											</br><span style="width:200px"><input type="checkbox" class="prdcdE1List" id="${prdcdE1AllList.prdnm}" value="${prdcdE1AllList.prdcd}" name="prdcdE1List" onclick="CountChecked()"/>
												<label for="${prdcdE1AllList.prdnm}" class="k_l2" style="width: 130px;" ><c:out value="${prdcdE1AllList.prdnm}"/></label></span>
										</c:when>
										<c:otherwise>
											<span style="width:200px"><input type="checkbox" class="prdcdE1List" id="${prdcdE1AllList.prdnm}" value="${prdcdE1AllList.prdcd}" name="prdcdE1List" onclick="CountChecked()"/>
													<label for="${prdcdE1AllList.prdnm}" class="k_l2" style="width: 130px;" ><c:out value="${prdcdE1AllList.prdnm}"/></label></span>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						</c:if>
					</div>
				</div>
			</div>
			</div>
			
			<div class="cb pt5 ">
				
			</div>
	    
		    <div id="theTabPanel" class="custom-headers tabs-below" style="position: relative; height: 700px;">
		    	<div>
		          	<a>
		          		<spring:message code='label.WAS008.title1'/> <!--월매상현황(MAKER) -->
		          	</a>
		          	<div>
			          		<div id="chartMaker" class="chart-block1" ></div>
			          		<div id="chartMakerComps" class="chart-block2"></div>
			          		<div id="chartMakerCompsSum" class="chart-block2"></div>
			          		<div id="comment" class="comment" style="display: none;">
			          			<button type="button" class="pdfDown1" id="pdfDown1" value="1">
									<spring:message code='label.WAS006.update'/><!-- 수정 -->
								</button>
								<button type="button" class="AXButton Red _saveBtn1_" id="saveBtn1" value="1" style="display: none;">
									<spring:message code='label.WAS006.save'/><!-- 등록 -->
								</button>
			            	<textarea class="text" id="text1" name="text1" style="width: 100%;height: 350px;" readonly="true;">${text1}</textarea>
			          		<input type="hidden" id="comps1" name="comps1" value=""/>
			         		<input type="hidden" id="reprtse1" name="reprtse1" value=""/>
			          		<input type="hidden" id="cmnitm1" name="cmnitm1" value=""/>
			          		</div>
			          	<br>
		          		<div id="chartMaker2" class="chart-block1"></div>
		          		<div id="chartMakerComps2" class="chart-block2"></div>
		          		<div id="chartMakerCompsSum2" class="chart-block2"></div>		          		
		          		<div id="comment3" class="comment" style="display: none;">
		          			<button type="button" class="pdfDown1" id="pdfDown2" value="3">
								<spring:message code='label.WAS006.update'/><!-- 수정 -->
							</button>
							<button type="button" class="AXButton Red _saveBtn1_" id="saveBtn3" value="3" style="display: none;">
								<spring:message code='label.WAS006.save'/><!-- 등록 -->
							</button>
		            	<textarea class="text" id="text3" name="text3" style="width: 100%;height: 350px;" readonly="true;">${text3}</textarea>
		          		<input type="hidden" id="comps3" name="comps3" value=""/>
		         		<input type="hidden" id="reprtse3" name="reprtse3" value=""/>
		          		<input type="hidden" id="cmnitm3" name="cmnitm3" value=""/>
		          		</div>
		          	</div>
		         </div>
		        <div>
		          	<a>
		          		<spring:message code='label.WAS008.title2'/> <!--월매상현황(ITEM) -->
		          	</a>
		          	<div>
		          		<div id="chartITME" class="chart-block1"></div>
		            	<div id="chartITMEComps" class="chart-block2"></div>
		            	<div id="chartITMECompsSum" class="chart-block2"></div>
		            	<div class="comment" id="comment2"  style="display: none;">
		            		<button type="button" class="pdfDown2" id="pdfDown4" value="2">
								<spring:message code='label.WAS006.update'/><!-- 수정 -->
							</button>
							<button type="button" class="AXButton Red _saveBtn2_" id="saveBtn2" value="2" style="display: none;" >
								<spring:message code='label.WAS006.save'/><!-- 등록 -->
							</button>			
		            	<textarea class="text" id="text2" name="text2" style="width: 100%;height: 350px;" readonly="true;">${text2}</textarea>
		          		<input type="hidden" id="comps2" name="comps2" value=""/>
		         		<input type="hidden" id="reprtse2" name="reprtse2" value=""/>
		          		<input type="hidden" id="cmnitm2" name="cmnitm2" value=""/>
		          		</div>
		          		<br>
		          		<div id="chartITME2" class="chart-block1"></div>
		            	<div id="chartITMEComps2" class="chart-block2"></div>
		            	<div id="chartITMECompsSum2" class="chart-block2"></div>
		            	<div class="comment"  id="comment5" style="display: none;">
		            		<button type="button" class="pdfDown2" id="pdfDown5" value="5">
								<spring:message code='label.WAS006.update'/><!-- 수정 -->
							</button>
							<button type="button" class="AXButton Red _saveBtn2_" id="saveBtn5" value="5" style="display: none;" >
								<spring:message code='label.WAS006.save'/><!-- 등록 -->
							</button>			
		            	<textarea class="text" id="text5" name="text5" style="width: 100%;height: 350px;" readonly="true;">${text5}</textarea>
		          		<input type="hidden" id="comps5" name="comps5" value=""/>
		         		<input type="hidden" id="reprtse5" name="reprtse5" value=""/>
		          		<input type="hidden" id="cmnitm5" name="cmnitm5" value=""/>
		          		</div>
		          		<br>
		          		<div id="chartITME3" class="chart-block1"></div>
		            	<div id="chartITMEComps3" class="chart-block2"></div>
		            	<div id="chartITMECompsSum3" class="chart-block2"></div>
		            	<div class="comment" id="comment6" style="display: none;">
		            		<button type="button" class="pdfDown2" id="pdfDown6" value="6">
								<spring:message code='label.WAS006.update'/><!-- 수정 -->
							</button>
							<button type="button" class="AXButton Red _saveBtn2_" id="saveBtn6" value="6" style="display: none;" >
								<spring:message code='label.WAS006.save'/><!-- 등록 -->
							</button>			
		            	<textarea class="text" id="text6" name="text6" style="width: 100%;height: 350px;" readonly="true;">${text6}</textarea>
		          		<input type="hidden" id="comps6" name="comps6" value=""/>
		         		<input type="hidden" id="reprtse6" name="reprtse6" value=""/>
		          		<input type="hidden" id="cmnitm6" name="cmnitm6" value=""/>
		          		</div>
		          	</div>
		        </div>
			</div>
			
 		</div>
	</div>
</div>


<script>

	//code generator 후 js파일 경로 수정해줘야함.
	$.getScript('/js/sal/WAS008SalPlnPerfmncMtReprtPpt.js');
	
	
</script>
   


