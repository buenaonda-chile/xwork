<%--
 * �
 *
 * [KR] 
 * 
 * $Id$
 *
 * Copyright (c) 2017 DENSO CORPORATION. All rights reserved.
 *
--%>
<!-- [EN] Contents area -->
<!-- [JP]  -->
<%-- <spring:message code="label.filename" /> : <c:out value="${url }"></c:out> --%>

<link rel="stylesheet" media="all" href="/css/board.css"/>
<link rel="stylesheet" media="all" href="/css/content.css"/>


<link rel="stylesheet" type="text/css" href="/spreadJS/css/gc.spread.sheets.excel2013white.13.2.1.css" />
<script type="text/javascript" src="/spreadJS/scripts/gc.spread.sheets.all.13.2.1.min.js"></script>
<script type="text/javascript" src="/spreadJS/scripts/interop/gc.spread.excelio.13.2.1.min.js" ></script>
<script type="text/javascript" src="/spreadJS/scripts/interop/gc.spread.sheets.migration.13.2.1.min.js" ></script>
<script type="text/javascript" src="/spreadJS/scripts/resources/ko/gc.spread.sheets.resources.ko.13.2.1.min.js" ></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/FileSaver.js/2014-11-29/FileSaver.min.js"></script>  

<script  type="text/javascript">

var LB_LINE_CODE = "<spring:message code='label.WAT001.lineCode'/>";
var LB_LINE_NAME = "<spring:message code='label.WAT001.lineName'/>";
var LB_LOC = "<spring:message code='label.WAT001.loc'/>";
var LB_PART = "<spring:message code='label.WAT001.part'/>";
var LB_TEAM = "<spring:message code='label.WAT001.team'/>";
var LB_WORK_STLE = "<spring:message code='label.WAT001.workStle'/>";
var LB_PRDT1 = "<spring:message code='label.WAT001.prdt1'/>";
var LB_PRDT2 = "<spring:message code='label.WAT001.prdt2'/>";
var LB_PRDT3 = "<spring:message code='label.WAT001.prdt3'/>";
var LB_IF_CODE = "<spring:message code='label.WAT001.ifCode'/>";
var LB_CODE = "<spring:message code='label.WAT001.code'/>";
var LB_NAME = "<spring:message code='label.WAT001.name'/>";
var LB_CLS_CODE = "<spring:message code='label.WAT001.comps'/>";
var LB_LCODE_GB = "<spring:message code='label.WAT001.lcodeGb'/>";
var LB_WORK_STLE = "<spring:message code='label.WAT001.workStle'/>";


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
    width: 98%;
	overflow-x: auto;
}

.grid-block {
    width: 100%;
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
		<div class="k_cg1" style="text-align: center">
			<div class="k_sg1">
				<label class="k_l1">사업부</label>			
				<select name="comps" id="comps" class="getComps schLine" disabled>
					<option value="E1">마산</option>
					<option value="C1">창원</option>
					<option value="S1">화성</option>
				</select>	
				<label class="k_l1"><spring:message code='label.WAT001.lineCode'/></label>
				<input type="text" class="AXInput getPyvnd" style="width : 100px;" name="code" id="code" >
				<label class="k_l1"><spring:message code='label.WAT001.lineName'/></label>
				<input type="text" class="AXInput getPyvnd" style="width : 300px;" name="name" id="name" >
			</div>	
		
			<div class="k_bg1">
				<button type="button" class="AXButton Black" onclick="search();">
					<i class="axi axi-ion-android-search"></i>
					<spring:message code='label.search'/>
				</button>			
				<button type="button" class="xlsDown" onclick="downloadExcel()">
					<span><spring:message code='label.excelDown' /></span>
				</button>			
			</div>			
	
		</div>	
		<br>		
		<div class="gridBtnBlock">
			
			<div class="inlineBlock">
				<button type="button" class="AXButton Red _addBtn_" style="" onclick = "">
					<i><!--  class="axi axi-ion-person-add"> --></i>
					<spring:message code='label.register'/>
				</button>
			</div>
			
			<div class="inlineBlock">
				<button type="button" class="AXButton Normal _delBtn" style="" onclick="">
					<spring:message code="label.delete" />
				</button>
				<button type="button" id="updateButton" class="AXButton Normal" style="" onclick="update()">
					<spring:message code="label.save" />
				</button>
			</div>
			

<!-- 			
			<div class="inlineBlock">
				<button type="button" class="AXButton Blue _saveBtn_" onclick = "">
					<spring:message code='label.save'/>		
				</button>
				<button type="button" class="AXButton Normal _closeBtn_" style="" onclick="">
					<i></i> 
					<spring:message code='label.close'/>
				</button>
			</div>
 -->						
			
			
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

<script type="text/javascript" src="${pageContext.request.contextPath}/js/prdind/ProdctIndctBaseLine.js"></script>