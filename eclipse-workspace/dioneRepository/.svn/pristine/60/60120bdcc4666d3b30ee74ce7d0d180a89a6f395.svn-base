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

//var LN_CHK_MKCAR = "<spring:message code='label.WAN004.mkcar'/>";
//var LN_CHK_SEYNO = "<spring:message code='label.WAN004.seyno'/>";
//var LN_CHK_SEYCD = "<spring:message code='label.WAN004.seycd'/>";

var LN_DEL_CHK1 = "<spring:message code='label.WAN000.delChk1'/>";
var LN_INS_CHK1 = "<spring:message code='label.WAN000.insChk1'/>";
var LN_INS_CHK2 = "<spring:message code='label.WAN000.insChk2'/>";
var LN_UPD_CHK1 = "<spring:message code='label.WAN000.updChk1'/>";
var LN_UPD_CHK2 = "<spring:message code='label.WAN000.updChk2'/>";
var LN_UPD_CHK3 = "<spring:message code='label.WAN000.updChk3'/>";

var LN_CHK4 = "<spring:message code='label.WAN002.Chk4'/>";


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
	width: 500px;
    min-width: 350px;
    display: inline-block;
    margin: 0 5px;
}

.chart-block2{
	width: 270px;
    min-width: 200px;
    display: inline-block;
    margin: 0 5px;
}

.wj-flexchart {
	height: 400px;
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
						<!--<span><spring:message code='label.excelDown' /></span> 엑셀다운로드 -->
						<span><spring:message code='label.WAS000.pdfDown' /></span>
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
			</div>
			
			<div class="cb pt5 ">
				
			</div>
	    
		    <div id="theTabPanel" class="custom-headers tabs-below">
		    	<div>
		          	<a>월매상현황(MAKER)</a>
		          	<div>
		          		
		          		<div id="chartMaker" class="chart-block1"></div>
		          		<div id="chartMakerComps" class="chart-block2"></div>
		          		<div id="chartMakerCompsSum" class="chart-block2"></div>
		          		<div class="comment" style="margin-top: 10px;">
		            	<textarea id="text1" name="text1" style="resize: none;width: 100%;height: 300px;" readonly="true">${text1}</textarea>
		          		</div>
		          	</div>
		         </div>
		        <div>
		          	<a>월매상현황(ITEM)</a>
		          	<div>
		          		<div id="chartITME" class="chart-block1"></div>
		            	<div id="chartITMEComps" class="chart-block2"></div>
		            	<div id="chartITMECompsSum" class="chart-block2"></div>
		            	<div class="comment" style="margin-top: 10px;">
		            	<textarea id="text1" name="text1" style="resize: none;width: 100%;height: 300px;" readonly="true">${text1}</textarea>
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
   


