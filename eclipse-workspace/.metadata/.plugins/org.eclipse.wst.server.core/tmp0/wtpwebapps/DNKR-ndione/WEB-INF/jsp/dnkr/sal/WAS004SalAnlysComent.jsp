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
<script type="text/javascript" src="/wijmo/controls/wijmo.grid.cellmaker.min.js"></script>
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
var LN_CMNSAVE = "<spring:message code='label.WAS004.cmnSave'/>";//코멘트등록

var LN_CMN1 = "<spring:message code='label.WAS006.coment1'/>";//코멘트1
var LN_CMN2 = "<spring:message code='label.WAS006.coment2'/>";//코멘트2
var LN_CMNE1 = "<spring:message code='label.WAS004.cmnE1'/>";//마산코멘트
var LN_CMNC1 = "<spring:message code='label.WAS004.cmnC1'/>";//창원코멘트
var LN_CMNS1 = "<spring:message code='label.WAS004.cmnS1'/>";//화성코멘트
var LN_CMNKE = "<spring:message code='label.WAS004.cmnKe'/>";//구KE
var LN_CMNKA = "<spring:message code='label.WAS004.cmnKa'/>";//구KA

var LN_OPT4 = "<spring:message code='label.WAS000.opt4'/>";//구KE,구KA
var LN_OPT2 = "<spring:message code='label.WAS000.opt2'/>";//구KE
var LN_OPT3 = "<spring:message code='label.WAS000.opt3'/>";//구KA

var LN_WKREPRT = "<spring:message code='label.WAS004.wkReprt'/>";//주간보고
var LN_MNREPRTMJRPRDT = "<spring:message code='label.WAS004.mnReprtMjrPrdt'/>";//월간보고-주요제품별
var LN_MNREPRTMAKER = "<spring:message code='label.WAS004.mnReprtMaker'/>";//월간보고-MAKER
var LN_MNREPRTITEM = "<spring:message code='label.WAS004.mnReprtItem'/>";//월간보고-ITEM

//validation
var LN_VAL_REPYM = "<spring:message code='label.WAS004.valiRepym'/>";//년월
var LN_VAL_COMPS = "<spring:message code='label.WAS004.valiComps'/>";//사업부
var LN_VAL_REPRTSE = "<spring:message code='label.WAS004.valiReprtse'/>";//보고서종류
var LN_VAL_CMNITM = "<spring:message code='label.WAS004.valiCmnitm'/>";//코멘트항목
var LN_VAL_CMNCN = "<spring:message code='label.WAS004.valiCmncn'/>";//코멘트내용

//XLSX
var LB_XLSXTITLE = "<spring:message code='label.WAS004.xlsxTitle'/>";//매출분석코멘트

//사업부를 먼저 선택해주세요.
var LB_COMPSMSG= "<spring:message code='label.WAS004.compsMsg'/>";
//사업부,보고서종류를 먼저 선택해주세요.
var LB_COMPSREPRTMSG= "<spring:message code='label.WAS004.compsReprtseMsg'/>";
//gridEvent msg
var LB_GRIDREPYM= "<spring:message code='label.WAS004.gridRepym'/>";//년월
var LB_GRIDDATETYPE= "<spring:message code='label.WAS004.gridDateType'/>";//yyyymm
var LB_GRIDCOMPS= "<spring:message code='label.WAS004.gridComps'/>";//사업부
var LB_GRIDREPRTSE= "<spring:message code='label.WAS004.gridReprtse'/>";//보고서종류 선택
var LB_GRIDCMNITM= "<spring:message code='label.WAS004.gridCmnitm'/>";//코멘트항목 선택
var LB_GRIDCMNCN= "<spring:message code='label.WAS004.gridCmncn'/>";//코멘트내용 입력

var LN_ERRALERT = "<spring:message code='label.WAS000.errAlert'/>";
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


.redRow{
	background-color:pink !important;
}
.dropdown input{
	border: 1px solid #ff0000;
	border-radius: 4px;
}

/* 2021.01.08 */
.k_cg1{padding:14px 10px 0 15px;}
.k_cg1 .k_bg1{width:400px;}
.k_cg1 .k_sg1{width:calc(100% - 400px);}

.popover{
	text-align: center;
}
#commentTxt{
	 width: 400px;
	 height:300px;
}
.form-actions{
	margin: 0px 0px 5px 0px;
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
					
					<div class="inlineBlock">
					<button type="button" class="xlsDown _excelBtn_" onclick="downloadExcel();">
						<spring:message code='label.WAS000.excelDown' /><!-- 엑셀다운로드 -->
					</button>
					</div>
				</div>
		
				<div class="gridBtnBlock k_sg1">
					<!-- 년,월 캘린더 -->
					<div class="board-bList-wrap log_board">
						<div class="list-top">
							<div class="fl schLine">
								<label class="k_l1"><spring:message code='label.WAS004.repym'/></label>
								<div class="dropdown">
									<span class="calendar_icon vcen2"></span>
									<input type="text" class="dropbtn calendar_input getDumcb" name="getDumcb" id="getDumcb" value="${dumcb}" onblur="reset();"/>
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
					<select name="getComps" id="getComps" class="getComps requiredLine">
						<option value=""><spring:message code='label.WAS000.opt1'/></option><!-- 전체 -->
						<option value="AL"><spring:message code='label.WAS000.opt4'/></option><!-- 마산,창원,화성 (전체레포트일경우) -->
						<option value="PE"><spring:message code='label.WAS000.opt2'/></option><!-- 마산 -->
						<option value="PS"><spring:message code='label.WAS000.opt3'/></option><!-- 창원,화성 -->
					</select>	
					<!-- 보고서명 -->
					<div class="inlineBlock schLine">
					<label class="k_l1"><spring:message code='label.WAS004.reprtNm'/></label>
					<select name="getReprtNm" id="getReprtNm" class="getReprtNm schLine">
						<option value=""><spring:message code='label.WAS000.opt1'/></option><!-- 전체 -->
						<option value="R1"><spring:message code='label.WAS004.wkReprt'/></option><!-- 전체 -->
						<option value="R2"><spring:message code='label.WAS004.mnReprtMjrPrdt'/></option><!-- 전체 -->
						<option value="R3"><spring:message code='label.WAS004.mnReprtMaker'/></option><!-- 전체 -->
						<option value="R4"><spring:message code='label.WAS004.mnReprtItem'/></option><!-- 전체 -->
					</select>
					</div>
				</div>
			</div>
			
			<div class="cb pt5 ">	
			</div>
	    
		     <div class="grid-container" style="position: relative; height: 650px;">
				<div id="wijmoGrid" ></div>
				<div id="popComment" class="popover" style="display: none;">
		            <span class="popover-title">
		                <spring:message code='label.WAS004.cmnText'/>
		            </span>
		            <div class="popover-content">
		                <form name="popoverForm">
		                    <div class="form-group" >
		                        <div class="input-group">
		                            <textarea id="commentTxt" rows="" cols=""></textarea>
		                        </div>
		                    </div>
		                    <div class="form-actions" >
		                        <button class="btn btn-danger wj-hide"><spring:message code='label.WAS007.close'/></button>
		                        <button class="btn btn-primary wj-hide-ok" ><spring:message code='label.WAS004.cmnSave'/></button>
		                    </div>
		                </form>
		            </div>
		        </div>
				<a href="javascript:zoomIn($('#wijmoGrid'),flexGrid);"><spring:message code='label.WAS000.gridSize1'/></a>
				<a href="javascript:zoomOut($('#wijmoGrid'),flexGrid);"><spring:message code='label.WAS000.gridSize2'/></a>
		    </div>
 		</div>
	</div>
</div>


<script>
	//code generator 후 js파일 경로 수정해줘야함.
	$.getScript('/js/sal/WAS004SalAnlysComent.js');
	
</script>
   
   


