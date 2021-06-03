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

<!-- spreadjs 추가 시작-->
<link rel="stylesheet" type="text/css" href="/spreadJS/css/gc.spread.sheets.excel2013white.13.2.1.css" />
<script type="text/javascript" src="/spreadJS/scripts/gc.spread.sheets.all.13.2.1.min.js"></script>
<script type="text/javascript" src="/spreadJS/scripts/interop/gc.spread.excelio.13.2.1.min.js" ></script>
<script type="text/javascript" src="/spreadJS/scripts/interop/gc.spread.sheets.migration.13.2.1.min.js" ></script>
<script type="text/javascript" src="/spreadJS/scripts/resources/ko/gc.spread.sheets.resources.ko.13.2.1.min.js" ></script>
<!-- 엑셀파일 생성시 필요함 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/FileSaver.js/2014-11-29/FileSaver.min.js"></script>  

<!-- spreadjs 추가끝 -->

<script  type="text/javascript">

//ì¬ìë¶ë¥¼ ì íí´ì£¼ì¸ì.
var LN_SELECT_COMPS = "<spring:message code='WAN-I0-0001'/>";
//ìì²´ë¥¼ ì íí´ì£¼ì¸ì.
var LN_SELECT_PYVND = "<spring:message code='WAN-I0-0002'/>";
//[íì¸] ìì²´ì½ë íì¸ë°ëëë¤.
var LN_IO_CHK1 = "<spring:message code='WAN-I0-Chk1'/>";

var LN_CHK_MKCAR = "<spring:message code='label.WAN004.mkcar'/>";
var LN_CHK_SEYNO = "<spring:message code='label.WAN004.seyno'/>";
var LN_CHK_SEYCD = "<spring:message code='label.WAN004.seycd'/>";

var LN_DEL_CHK1 = "<spring:message code='label.WAN000.delChk1'/>";
var LN_INS_CHK1 = "<spring:message code='label.WAN000.insChk1'/>";
var LN_INS_CHK2 = "<spring:message code='label.WAN000.insChk2'/>";
var LN_UPD_CHK1 = "<spring:message code='label.WAN000.updChk1'/>";
var LN_UPD_CHK2 = "<spring:message code='label.WAN000.updChk2'/>";
var LN_UPD_CHK3 = "<spring:message code='label.WAN000.updChk3'/>";

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
.gridContents {
	width: 1100px;
	overflow-x: auto;
}

.grid-block {
	min-width:1100px; 
	display:inline-block; 
	margin:0 5px
}

.third-grid-block {
	min-width: 420px;
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

[data-ax5grid] [data-ax5grid-container="root"] 
[data-ax5grid-container="body"] [data-ax5grid-panel] 
table tr td [data-ax5grid-cellHolder] {
	padding: 2px 5px;
}

[data-ax5grid-container="root"] [data-ax5grid-panel-scroll="body"] table tr> td:FIRST-CHILD {
	cursor: pointer;
    box-shadow: inset 0px 0px 1px 1px #e0eaf3;
    background-color: #eef4f9;
    border-radius: 3px;
    border-bottom: 1px solid #d6d6d6 !important;
    border-right: 2px solid #d6d6d6 !important;
}

.schLine {
#	border-top : 1px solid #bbb;
#	border-left : 1px solid #bbb;
#	border-right : 1px solid #bbb;
#	border-bottom : 1px solid #bbb;
	
	margin: 0px 15px 0px 0px;
}

.spread-container {
    width: 100%;
    height: 100%;
    overflow: hidden;
    float: left;

}

.spreadsheets {
    width: 100%;
    height: 600px;
        border:1px solid gray;
}

#statusBar {
    width: 100%;
    height: 30px;
}

</style>

<div class="grid-block team-ms">
	<div class="gridContents" style="" id="grid-parent">
		<div class="gridBtnBlock">
			<button type="button" class="AXButton Black" onclick="search();">
				<i class="axi axi-ion-android-search"></i>
				<spring:message code='label.search'/>
			</button>

			<div class="inlineBlock">
				<button type="button" id="updateButton" class="AXButton Normal" disabled="disabled" style="" onclick="update()">
					<spring:message code="label.save" /><!-- Ã¬ÂÂÃ¬Â Â -->
				</button>
				<button type="button" class="AXButton Normal _delBtn" style="" onclick="">
					<spring:message code="label.delete" /><!-- Ã¬ÂÂ­Ã¬Â Â -->
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
					<spring:message code='label.save'/>	<!-- Ã¬Â ÂÃ¬ÂÂ¥ -->			
				</button>
				<button type="button" class="AXButton Normal _closeBtn_" style="" onclick="">
					<i><!--  class="axi axi-ion-person-add"> --></i> 
					<spring:message code='label.close'/>	<!-- Ã«ÂÂ«ÃªÂ¸Â° -->
				</button>
			</div>
			
			<button type="button" class="xlsDown" onclick="downloadExcel()">
				<span><spring:message code='label.excelDown' /></span>
			</button>
		</div>
		
		<div class="gridBtnBlock">
			
			<select name="getComps" id="getComps" class="getComps schLine" disabled>
				<c:if test="${fn:length(codeList) > 0}">
					<c:forEach var="codeD2Domain" items="${codeList}" varStatus="status">
						<option value="${codeD2Domain.code2}"
							<c:if test="${codeD2Domain.code2 eq empComps}">
								selected
							</c:if>
						><c:out value="${codeD2Domain.code_name}"/></option>
					</c:forEach>
				</c:if>
			</select>
			
			<div class="inlineBlock schLine">	
				<input type="text" class="AXInput getPyvnd" style="width : 50px;" name="getPyvnd" id="getPyvnd" 
					onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)' onBlur="getCustSch();">
				<button type="button" onclick="" class="AXButton Normal _custBtn_">
					<spring:message code="label.select" />
				</button>
				<input type="text" class="AXInput getCusnm" style="width : 180px;" name="getCusnm" id="getCusnm" placeholder="<spring:message code='WAN-I0-0002'/>" title="<spring:message code='WAN-I0-0002'/>" disabled readOnly>
			</div>
			
		</div>
		
		<div class="cb pt5 " style="min-width:780px;">

			<input type="hidden" id="setComps" name="setComps" value=""/>
			<input type="hidden" id="setPyvnd" name="setPyvnd" value=""/>
			<input type="hidden" id="setMkcar" name="setMkcar" value=""/>
			<input type="hidden" id="setSeyno" name="setSeyno" value=""/>
			<input type="hidden" id="setSeycd" name="setSeycd" value=""/>
			
			<input type="hidden" id="setOldMkcar" name="setOldMkcar" value=""/>
			<input type="hidden" id="setOldSeyno" name="setOldSeyno" value=""/>
			<input type="hidden" id="setOldSeycd" name="setOldSeycd" value=""/>

		</div>
		
		 <!-- 
	    <div class="pt5 cmcGrid" data-ax5grid="grid" data-ax5grid-config="{showLineNumber: true}"></div>
		 -->
		 
		<div class="spread-container">
	        <div id="grid" class="spreadsheets"></div>
	        <div id="statusBar"></div>
	    </div>
			 	       
	</div>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/sal/CustTypeOrderExceptMst.js"></script>