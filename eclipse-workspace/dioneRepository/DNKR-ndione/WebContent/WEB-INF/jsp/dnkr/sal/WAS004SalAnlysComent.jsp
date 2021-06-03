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

var LN_CHK_COMPS = "<spring:message code='label.WAS004.comps'/>"; //공장
var LN_CHK_REPYM = "<spring:message code='label.WAS004.repym'/>"; //년월
var LN_CHK_REPRTSE = "<spring:message code='label.WAS004.reprtse'/>"; //보고서종류
var LN_CHK_REPRTNM = "<spring:message code='label.WAS004.reprtNm'/>"; //보고서명
var LN_CHK_CMNITM = "<spring:message code='label.WAS004.cmnitm'/>"; //코멘트항목
var LN_CHK_CMNCN = "<spring:message code='label.WAS004.cmncn'/>"; //코멘트내용

var LN_DEL_CHK1 = "<spring:message code='label.WAN000.delChk1'/>";
var LN_INS_CHK1 = "<spring:message code='label.WAN000.insChk1'/>";
var LN_INS_CHK2 = "<spring:message code='label.WAN000.insChk2'/>";
var LN_UPD_CHK1 = "<spring:message code='label.WAN000.updChk1'/>";
var LN_UPD_CHK2 = "<spring:message code='label.WAN000.updChk2'/>";
var LN_UPD_CHK3 = "<spring:message code='label.WAN000.updChk3'/>";


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
					<!-- 사업부 -->				
					<label class="k_l1"><spring:message code='label.WAS004.comps'/></label>
					<select name="getComps" id="getComps" class="getComps schLine">
						<option value="E1">마산</option>
						<option value="C1">창원</option>
						<option value="S1">화성</option>

					</select>
					<!-- 보고서명 -->
					<div class="inlineBlock schLine">
						<label class="k_l1"><spring:message code='label.WAS004.reprtNm'/></label>
					<select name="getReprtNm" id="getReprtNm" class="getReprtNm schLine">
						<option value=""></option>
						<option value="01">주간보고</option>
						<option value="02">월간보고-주요제품별</option>
						<option value="03">월간보고-창원</option>
						<option value="04">월간보고-화성마산</option>
					</select>
					</div>
					
				</div>
			</div>
			
			<div class="cb pt5 ">	
			</div>
	    
		     <div class="grid-container" style="position: relative; height: 650px;">
				<div id="wijmoGrid" ></div>
				<a href="javascript:zoomIn($('#wijmoGrid'),flexGrid);">확대</a>
				<a href="javascript:zoomOut($('#wijmoGrid'),flexGrid);">축소</a>
		    </div>
			
 		</div>
	</div>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/sal/WAS004SalAnlysComent.js"></script>
   


