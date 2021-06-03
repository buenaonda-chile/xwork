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
//년도
var LB_YEAR = "<spring:message code='label.WAS006.year'/>";

/*  $(function(){
	gridinit();
});  */

 function gridinit() {
	grid.initView({
	standrd : { //기준일자
		label : "<spring:message code='label.WAS006.standrd'/>"
	},
	mnUnit : { //금액단위
		label : "<spring:message code='label.WAS006.mnUnit'/>"
	}, 
	progrsRate : { //진도율
		label : "<spring:message code='label.WAS006.progrsRate'/>"
	},
	locNm : { //공장
		label : "<spring:message code='label.WAS006.locNm'/>"
	},
	majrItem : { //주요품목
		label : "<spring:message code='label.WAS006.majrItem'/>"
	},
	salPlan: { //판매계획
		label : "<spring:message code='label.WAS006.salPlan'/>"
	},
	salPerfrmnc : {//판매실적
		label : "<spring:message code='label.WAS006.salPerfrmnc'/>"
	},
	achivRate : { //달성률
		label : "<spring:message code='label.WAS006.achivRate'/>"
	},
	yearSum : { //년계
		label : "<spring:message code='label.WAS006.yearSum'/>"
	},
	shtSum : { //단계
		label : "<spring:message code='label.WAS006.shtSum'/>"
	},
	achivRateStandard : { //진도율기준
		label : "<spring:message code='label.WAS006.achivRateStandard'/>"
	},
	margin : {//차이
		label : "<spring:message code='label.WAS006.margin'/>"
	},
	yearSumCompr : { //년계비
		label : "<spring:message code='label.WAS006.yearSumCompr'/>"
	},
	shtSumCompr : { //단계비
		label : "<spring:message code='label.WAS006.shtSumCompr'/>"
	},
	progreCompr : { //진도비
		label : "<spring:message code='label.WAS006.progreCompr'/>"
	},
	});
} 

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
.k_l2{
	width:70px;
	font-size: 15px; "
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
					<button type="button" class="xlsDown" onclick="downloadExcel();">
						<span><spring:message code='label.excelDown' /></span><!-- 엑셀다운로드 -->
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
				</div>
			</div>
			
			<div class="cb pt5 ">
			</div>
	    	<div class="chartContents" style="position: relative; height: 600px;">
		    	<div id="chartMaker" class="chart-block1"></div>
		      	<div class="pt5 salGrid" data-ax5grid="grid" data-ax5grid-config="{showLineNumber: true}"></div>
		      	<div>
		          	<div id="comment"></div>
		           	<textarea id="text1" name="text1" style="resize: none;width: 50%;height: 300px;" readonly="true">${text1}</textarea><textarea id="text2" name="text2" style="resize: none;width: 48%;height: 300px;" readonly="true">${text2}</textarea>
		      	</div>
		    </div>
 		</div>
	</div>
</div>


<script>

	//code generator 후 js파일 경로 수정해줘야함.
	$.getScript('/js/sal/WAS006SalPlnPerfmncWkReprtExl.js');
	
	
</script>
   


