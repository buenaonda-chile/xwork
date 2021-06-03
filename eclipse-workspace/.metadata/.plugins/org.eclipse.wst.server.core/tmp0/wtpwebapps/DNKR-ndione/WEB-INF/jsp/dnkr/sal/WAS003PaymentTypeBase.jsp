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

<script  type="text/javascript">

//위즈모 LicenseKey 설정
wijmo.setLicenseKey('${wijmoLicenseKey}');

//사업부 필수체크 메시지
var LN_SELECT_COMPS = "<spring:message code='WAN-I0-0001'/>";
//업체 필수체크 메시지
var LN_SELECT_PYVND = "<spring:message code='WAN-I0-0002'/>";
//업체코드확인바랍니다 메시지
var LN_IO_CHK1 = "<spring:message code='WAN-I0-Chk1'/>";

var LN_CHK_COMPS = "<spring:message code='label.WAS003.comps'/>";
var LN_CHK_PYVND = "<spring:message code='label.WAS001.cstmrCo'/>";
var LN_CHK_CUSNM = "<spring:message code='label.WAS001.cstmrNm'/>";

var LN_OPT_2 = "<spring:message code='label.WAS000.opt2'/>";
var LN_OPT_3 = "<spring:message code='label.WAS000.opt3'/>";

var LN_DEL_CHK1 = "<spring:message code='label.WAN000.delChk1'/>";
var LN_INS_CHK1 = "<spring:message code='label.WAN000.insChk1'/>";
var LN_INS_CHK2 = "<spring:message code='label.WAN000.insChk2'/>";
var LN_INS_CHK3 = "<spring:message code='label.WAS002.insChk2'/>"; //수정이나 추가한 행의 사업부를 입력해야합니다 메세지
var LN_INS_CHK4 = "<spring:message code='label.WAS002.insChk3'/>"; //수정이나 추가한 행의 업체코드를 입력해야합니다 메세지
var LN_INS_CHK5 = "<spring:message code='label.WAS002.insChk5'/>"; //해당하는 최종고객명이 없습니다 메세지
var LN_UPD_CHK1 = "<spring:message code='label.WAN000.updChk1'/>";
var LN_UPD_CHK2 = "<spring:message code='label.WAN000.updChk2'/>";
var LN_UPD_CHK3 = "<spring:message code='label.WAN000.updChk3'/>"; 
var LN_ERROR_ALT = "<spring:message code='label.WAS000.errAlert'/>"; //등록할 내역이 없습니다 메세지
var LN_FILE_NM = "<spring:message code='label.WAS003.fileNm'/>"; //납입구분관리 파일명
var LN_GRID_CHK1 = "<spring:message code='label.WAS002.gridChk2'/>"; //사업부를 선택해야합니다.
var LN_GRID_CHK2 = "<spring:message code='label.WAS002.gridChk3'/>"; //업체코드를 입력해야합니다.
var LN_GRID_CHK3 = "<spring:message code='label.WAS003.gridChk1'/>"; //해당하는 업체명이 없습니다.


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


.wj-flexgrid {
	max-height: 620px;
	height: auto;
	width: 100%;
}

.wj-header {
 	background: white;
    
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
		
				<div class="gridBtnBlock k_sg1">
 					<!-- 사업부 -->
 					<label class="k_l1"><spring:message code='label.WAS003.comps'/></label>
					<select name="getComps" id="getComps" class="getComps schLine">
						<option value="ALL"><spring:message code='label.WAS000.opt1'/></option>
						<option value="PE"><spring:message code='label.WAS000.opt2'/></option>
						<option value="PS"><spring:message code='label.WAS000.opt3'/></option>
					</select>	
					<input type="text" class="getTrncCode" name="getTrncCode" id="getTrncCode" value="" style="display: none;"/>
					<!-- 업체 -->
					<div class="inlineBlock schLine">
						<label class="k_l1"><spring:message code='label.WAS001.cstmr'/></label>	
						<input type="text" class="AXInput getPyvnd" style="width : 60px;" name="getPyvnd" id="getPyvnd"  maxlength="4"
							onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)' onBlur="getCustSch(getComps.value, this.value, '1');">
						<input type="text" class="AXInput getCusnm" style="width : 180px;" name="getCusnm" id="getCusnm" placeholder="<spring:message code='WAN-I0-0002'/>" title="<spring:message code='WAN-I0-0002'/>" disabled readOnly>
						<button type="button" onclick="" class="AXButton Normal _custBtn_">
							<spring:message code="label.select" />
						</button>						
					</div>
				</div>
			</div>
			
			<div class="cb pt5 ">	
			</div>
	    
		     <div class="grid-container" style="position: relative; height: 650px;">
				<div id="wijmoGrid" ></div>
				<a href="javascript:zoomIn($('#wijmoGrid'),flexGrid);"><span><spring:message code='label.WAS000.gridSize1' /></span></a><!-- 확대 --> 
				<a href="javascript:zoomOut($('#wijmoGrid'),flexGrid);"><span><spring:message code='label.WAS000.gridSize2' /></span></a><!-- 축소 --> 
		    </div>
			
 		</div>
	</div>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/sal/WAS003PaymentTypeBase.js"></script>
   


