<%--
 * PROJECTÃ¯Â¼Â
 *
 * [KR] 
 * 
 * $Id$
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

var LN_SELECT_TPLID = "<spring:message code='WAN-I0-0014'/>";

var LN_CHK_TPLID = "<spring:message code='label.WAN021.tplid'/>";
var LN_CHK_COLNO = "<spring:message code='label.WAN021.colno'/>";
var LN_CHK_COLMN = "<spring:message code='label.WAN021.colmn'/>";
var LN_CHK_COMNT = "<spring:message code='label.WAN021.comnt'/>";
var LN_CHK_REQYN = "<spring:message code='label.WAN021.reqyn'/>";
var LN_CHK_STYPE = "<spring:message code='label.WAN021.stype'/>";
var LN_CHK_LENGH = "<spring:message code='label.WAN021.lengh'/>";

var LN_DEL_CHK1 = "<spring:message code='label.WAN000.delChk1'/>";
var LN_INS_CHK1 = "<spring:message code='label.WAN000.insChk1'/>";
var LN_UPD_CHK1 = "<spring:message code='label.WAN000.updChk1'/>";
var LN_UPD_CHK2 = "<spring:message code='label.WAN000.updChk2'/>";

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
						<spring:message code='label.search'/>
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
							<spring:message code='label.register'/>
						</button>
					</div>
					<div class="displayNone">
						<button type="button" class="AXButton Blue _saveBtn_" onclick = "">
							<spring:message code='label.save'/>	<!-- 저장 -->			
						</button>
						<button type="button" class="AXButton Normal _closeBtn_" style="" onclick="">
							<i><!--  class="axi axi-ion-person-add"> --></i> 
							<spring:message code='label.close'/>	<!-- 닫기 -->
						</button>
					</div>
					
					<button type="button" class="xlsDown" onclick="downloadExcel();">
						<span><spring:message code='label.excelDown' /></span><!-- 엑셀다운로드 -->
					</button>
				</div>
					
				<div class="gridBtnBlock k_sg1">
					
					<label class="k_l1">템플릿</label>
					<select name="getTplid" id="getTplid" class="getTplid">
						<option value="T001">서열형(P6)</option>
						<option value="T002">서열형(P7)</option>
						<option value="T003">비서열(표준양식)</option>
						<option value="T004">확정오더(표준양식)</option>
						<option value="T005">확정오더(HMC CKD_창원)</option>
						<option value="T006">확정오더(HMC CKD_화성)</option>
						<option value="T007">확정오더(KMC CKD)</option>
						<option value="T008">확정오더(MOBIS CKD)</option>
						<option value="T009">확정오더(MOBIS AS_SRS)</option>
						<option value="T010">확정오더(MOBIS AS_SPIN)</option>
						<option value="T011">확정오더(GLOVIS)</option>
					</select>
				</div>
				
			</div>
			
			<div class="cb pt5">
			</div>
			
		     <div class="grid-container" style="position: relative; height: 650px;">
				<div id="wijmoGrid" ></div>
				<a href="javascript:zoomIn($('#wijmoGrid'),flexGrid);">확대</a>
				<a href="javascript:zoomOut($('#wijmoGrid'),flexGrid);">축소</a>
		    </div>
		</div>
	</div>
</div>


<script>

	//getscript로  처리하면 timestamp기능이 뒤에 붙어서 캐쉬사용없이 계속 로딩함. -수정사항이 바로 반영됨-	
	$.getScript('/js/sal/FileUploadParameterMst.js');					
	
	//그리드 사용하기 위한 공통 script
	// 그리드 로딩이 가끔씩 빠져서 다시 위로 선언함.
	// wijmo 공통선언은 최상위에서 하고 실사용 js파일은 아래에 정의해야.
	/*		
	$.getScript('/wijmo/controls/wijmo.min.js').done(function() {
			
		$.getScript('/wijmo/controls/wijmo.grid.min.js'),					//grid
		$.getScript('/wijmo/controls/wijmo.input.min.js'),					//grid 필터기능에서 input박스가 들어감으로 필요함.
		$.getScript('/wijmo/controls/wijmo.xlsx.min.js'),					//엑셀변환
		$.getScript('/wijmo/controls/wijmo.grid.xlsx.min.js'),				//그리드 엑셀변환
		$.getScript('/wijmo/controls/wijmo.grid.filter.min.js'),			//필터기능
		$.getScript('/wijmo/controls/cultures/wijmo.culture.ko.min.js'),	//한국어
		$.getScript('/wijmo/controls/jszip.min.js'),						//엑셀파일 다운로드시 필요
		$.getScript('${pageContext.request.contextPath}/js/sal/FileUploadParameterMst.js?ver=1.1'),
		$.Deferred(function( deferred ){
		})
				
	});
	*/
	
</script>