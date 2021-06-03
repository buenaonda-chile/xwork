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
<script type="text/javascript" src="/wijmo/controls/wijmo.grid.xlsx.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.grid.filter.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.input.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.xlsx.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/cultures/wijmo.culture.ko.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/jszip.min.js"></script>

<!-- sheet -->
<script type="text/javascript" src="/wijmo/controls/wijmo.grid.sheet.min.js"></script>

<!-- chart 관련 -->
<script type="text/javascript" src="/wijmo/controls/wijmo.chart.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.pdf.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.nav.min.js"></script>
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

var LN_DEL_CHK1 = "<spring:message code='label.WAN000.delChk1'/>";
var LN_INS_CHK1 = "<spring:message code='label.WAS006.insChk1'/>";
var LN_INS_CHK2 = "<spring:message code='label.WAN000.insChk2'/>";
var LN_UPD_CHK2 = "<spring:message code='label.WAN000.updChk2'/>";
var LN_UPD_CHK3 = "<spring:message code='label.WAN000.updChk3'/>";

var LB_TITLE1 = "<spring:message code='label.WAS007.tabTitle1'/>";
var LB_TITLE2 = "<spring:message code='label.WAS007.tabTitle2'/>";
var LB_TITLE3 = "<spring:message code='label.WAS007.tabTitle3'/>";
var LB_YAER = "<spring:message code='label.WAS007.year'/>";
var LB_MM = "<spring:message code='label.WAS007.mm'/>";

var LB_LOC ="<spring:message code='label.WAS007.loc'/>"; 
var LB_DSTNCTN ="<spring:message code='label.WAS007.dstnctn'/>";

var LN_FILE_NM = "<spring:message code='label.WAS007.fileNm'/>";

//판매현황 탭 차트 라벨
var LB_CHAR1 = "<spring:message code='label.WAS007.charLb1'/>";
var LB_CHAR2 = "<spring:message code='label.WAS007.charLb2'/>";
var LB_CHAR3 = "<spring:message code='label.WAS007.charLb3'/>";
var LB_CHAR4 = "<spring:message code='label.WAS007.charLb4'/>";
var LB_CHAR5 = "<spring:message code='label.WAS007.charLb5'/>";

//판매현황 탭 그리드 라벨
var LB_GRID1 = "<spring:message code='label.WAS007.gridLb1'/>";
var LB_GRID2 = "<spring:message code='label.WAS007.gridLb2'/>";
var LB_GRID3 = "<spring:message code='label.WAS007.gridLb3'/>";
var LB_GRID4 = "<spring:message code='label.WAS007.gridLb4'/>";
var LB_GRID5 = "<spring:message code='label.WAS007.gridLb5'/>";
var LB_GRID6 = "<spring:message code='label.WAS007.gridLb6'/>";

//주요제품별 탭 차트 라벨
var LB_CHAR6 = "<spring:message code='label.WAS007.charLb6'/>";
var LB_CHAR7 = "<spring:message code='label.WAS007.charLb7'/>";
var LB_CHAR8 = "<spring:message code='label.WAS007.charLb8'/>";
var LB_CHAR9 = "<spring:message code='label.WAS007.charLb9'/>";
var LB_CHAR10 = "<spring:message code='label.WAS007.charLb10'/>";

var LB_CHAR11 = "<spring:message code='label.WAS007.charLb11'/>";
var LB_CHAR12 = "<spring:message code='label.WAS007.charLb12'/>";
var LB_CHAR13 = "<spring:message code='label.WAS007.charLb13'/>";
var LB_CHAR14 = "<spring:message code='label.WAS007.charLb14'/>";
var LB_CHAR15 = "<spring:message code='label.WAS005.gap'/>";
var LB_CHAR16 = "<spring:message code='label.WAS007.charLb16'/>";
var LB_CHAR17 = "<spring:message code='label.WAS007.charLb17'/>";

var LB_COMENT1 = "<spring:message code='label.WAS007.coment1'/>";
var LB_COMENT2 = "<spring:message code='label.WAS007.coment2'/>";


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
$(document).ready(function () {
//	debugger;
	//alert($(prdcdS1List).index())
});


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

.chart-block2{
	width: 20vw;
    min-width: 270px;
    display: inline-block;
    margin: 0 5px 15px;
    float : left;
}

.chart-block3{
	width: 74vw;
    min-width: 350px;
    display: inline-block;
    margin: 0 5px 15px;
    float : right;
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

.chart-block1 {
	height: 500px;
	width: 97vw;
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
	font-size: 15px; "
}

.wj-flexsheet {
    height: 400px;
    margin: 6px 0;
}

/* 2021.01.08 */

.k_cg1{padding:14px 10px 0 15px;}
.k_cg1 .k_bg1{width:340px;}
.k_cg1 .k_sg1{width:calc(100% - 340px);}

.dropdown input{
	border: 1px solid #ff0000;
	border-radius: 4px;
}
.bntDiv{
	margin: 15px 0px 5px 0px;
}
._saveBtn1_{
	margin: 0px 0px 0px 680px;
}
._saveBtn2_{
	margin: 0px 0px 0px 645px;
	
}
.pdfDown1{
	margin: 0px 0px 0px 680px;
}
.pdfDown2{
	margin: 0px 0px 0px 645px;
}

.tabs-below {
    height: 100%;
    min-height: 570px;
}
.schLine2{
	width: 100%;
}
.loadMore{
	margin: 5px 0px 0px 0px;
}
.close{
	margin: 5px 0px 0px 0px;
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
					<select name="getComps" id="getComps" class="getComps requiredLine" onchange="clearGrid('2');">
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
						<strong>-- <spring:message code='label.WAS000.opt2'/> --</strong></BR><!-- 구KE -->
						<c:if test="${fn:length(prdcdE1List) > 0}">
								<span style="width:200px"><input type="checkbox" class="checkboxElemt" name="prdcdE1AllList" id="prdcdE1AllList" value="prdcdE1AllList"  style="width:20px" ><label class="k_l2" for="prdcdE1AllList"  style="width:130px"><spring:message code='label.WAS007.allCheck'/></label></span>
								<c:forEach var="prdcdE1AllList" items="${prdcdE1List}" varStatus="status">
									<c:choose>
										<c:when test="${status.index%10 == 0 && status.index > 0}">
											</br><span style="width:200px"><input type="checkbox" class="prdcdE1List" id="${prdcdE1AllList.prdnm}" value="${prdcdE1AllList.prdcd}" name="prdcdE1List"  style="width:20px"/>
											<label for="${prdcdE1AllList.prdnm}" class="k_l2" style="width: 130px;" ><c:out value="${prdcdE1AllList.prdnm}"/></label></span>
										</c:when>
									<c:otherwise>
											<span style="width:200px"><input type="checkbox" class="prdcdE1List" id="${prdcdE1AllList.prdnm}" value="${prdcdE1AllList.prdcd}" name="prdcdE1List"/>
												<label for="${prdcdE1AllList.prdnm}" class="k_l2" style="width: 130px;" ><c:out value="${prdcdE1AllList.prdnm}"/></label></span>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</c:if>
					</div>
					<div class="inlineBlock schLine2" >
							<strong>-- <spring:message code='label.WAS000.opt3'/> --</strong></BR><!-- 구KA -->
							<c:if test="${fn:length(prdcdS1List) > 0}">
								<span style="width:200px"><input type="checkbox" class="checkboxElemt" name="prdcdS1AllList" id="prdcdS1AllList" value="prdcdS1AllList"  style="width:14px" ><label class="k_l2" for="prdcdS1AllList"  style="width:130px"><spring:message code='label.WAS007.allCheck'/></label></span>
								<c:forEach var="prdcdS1AllList" items="${prdcdS1List}" varStatus="status">
								    <c:choose>
									    <c:when test="${status.index%10 == 0 && status.index > 0}">
											</br><span style="width:200px"><input type="checkbox" class="prdcdS1List" id="${prdcdS1AllList.prdnm}" value="${prdcdS1AllList.prdcd}" name="prdcdS1List"  style="width:20px"/>
												<label for="${prdcdS1AllList.prdnm}" class="k_l2" style="width: 130px;" ><c:out value="${prdcdS1AllList.prdnm}"/></label></span>											
										</c:when>
										<c:otherwise>
											<span style="width:200px"><input type="checkbox" class="prdcdS1List" id="${prdcdS1AllList.prdnm}" value="${prdcdS1AllList.prdcd}" name="prdcdS1List"  style="width:20px"/>
												<label for="${prdcdS1AllList.prdnm}" class="k_l2" style="width: 130px;" ><c:out value="${prdcdS1AllList.prdnm}"/></label></span>	
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</c:if>
					</div>
				</div>
				<div class="k_sg4 checkboxS1List" style="display: none;">
					<div class="inlineBlock schLine2" >
							<c:if test="${fn:length(prdcdS1List) > 0}">
								<span style="width:200px"><input type="checkbox" class="checkboxElemt" name="prdcdS1List" id="prdcdS1AllList" value="prdcdS1AllList"  style="width:14px" ><label class="k_l2" for="prdcdS1AllList"  style="width:130px"><spring:message code='label.WAS007.allCheck'/></label></span>
								<c:forEach var="prdcdS1AllList" items="${prdcdS1List}" varStatus="status">
									<c:choose>
										<c:when test="${status.index%10 == 0 && status.index > 0}">
											</br><span style="width:200px"><input type="checkbox" class="prdcdS1List" id="${prdcdS1AllList.prdnm}" value="${prdcdS1AllList.prdcd}" name="prdcdS1List"/>
												<label for="${prdcdS1AllList.prdnm}" class="k_l2" style="width: 130px;" ><c:out value="${prdcdS1AllList.prdnm}"/></label></span>
										</c:when>
										<c:otherwise>
											<span style="width:200px"><input type="checkbox" class="prdcdS1List" id="${prdcdS1AllList.prdnm}" value="${prdcdS1AllList.prdcd}" name="prdcdS1List"/>
												<label for="${prdcdS1AllList.prdnm}" class="k_l2" style="width: 130px;" ><c:out value="${prdcdS1AllList.prdnm}"/></label></span>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</c:if>
					</div>
				</div>
				<div class="k_sg4 checkboxE1List" style="display: none;">
					<div class="inlineBlock schLine2" >
							<c:if test="${fn:length(prdcdE1List) > 0}">
								<span style="width:200px"><input type="checkbox" class="checkboxElemt" name="prdcdE1AllList" id="prdcdE1AllList" value="prdcdE1AllList"  style="width:20px" ><label class="k_l2" for="prdcdE1AllList"  style="width:130px"><spring:message code='label.WAS007.allCheck'/></label></span>
								<c:forEach var="prdcdE1AllList" items="${prdcdE1List}" varStatus="status">
									<c:choose>
										<c:when test="${status.index%10 == 0 && status.index > 0}">
											</br><span style="width:200px"><input type="checkbox" class="prdcdE1List" id="${prdcdE1AllList.prdnm}" value="${prdcdE1AllList.prdcd}" name="prdcdE1List"/>
												<label for="${prdcdE1AllList.prdnm}" class="k_l2" style="width: 130px;" ><c:out value="${prdcdE1AllList.prdnm}"/></label></span>
										</c:when>
										<c:otherwise>
											<span style="width:200px"><input type="checkbox" class="prdcdE1List" id="${prdcdE1AllList.prdnm}" value="${prdcdE1AllList.prdcd}" name="prdcdE1List"/>
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
	    		<!-- 판매현황 계획/실적 -->
		    	<div>
		          	<a>1.<spring:message code='label.WAS007.tabTitle1'/></a>
		          	<div>
		          		<div id="chartSalPlnSum" class="chart-block2"></div>
		          		<div id="chartSalPln" class="chart-block3"></div>
		          		<div id="salPlnGrid"></div>
		          	</div>
		          	
		        </div>
		        
		        <!-- 주요상품별 사업계획 대비 증감수량 -->
				<div>
					<a class="title2">2.<spring:message	code='label.WAS007.tabTitle2' /></a>
					<div>
						<div id="chart" class="chart-block1"></div>
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
						<textarea id="text1" name="text1" style="width: 100%; height: 200px;" readonly="true;">${text1}</textarea>
						</td>
						<td>
						<textarea id="text2" name="text2" style=" width: 100%; height: 200px;" readonly="true;">${text2}</textarea>
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
	</div>
</div>


<script>

	//code generator 후 js파일 경로 수정해줘야함.
	$.getScript('/js/sal/WAS007SalPlnPerfmncMtReprtExl.js');
	
</script>


