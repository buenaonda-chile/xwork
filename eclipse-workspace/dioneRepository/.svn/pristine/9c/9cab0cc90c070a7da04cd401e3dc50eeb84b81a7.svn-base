<%--
 * PROJECTï¼
 *
 * [KR] 
 * 
 * $Id$
 *
 * Copyright (c) 2017 DENSO CORPORATION. All rights reserved.
 *
--%>
<!-- [EN] Contents area -->
<!-- [JP] ã³ã³ãã³ãã¨ãªã¢ -->
<%-- <spring:message code="label.filename" /> : <c:out value="${url }"></c:out> --%>
<link type="text/css" href="/css/commonGrid.css?ver" rel="stylesheet">
<script type="text/javascript" src="/js/commonPop.js"></script>
<script type="text/javascript" src="/js/commonGrid.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/prdind/DeptPopSelect.js?ver"></script>
<script>

//거래처를 선택해주세요.
var LN_SELECT_CUST = "<spring:message code='WAN-I0-0006'/>";

$(function(){
	grid.initView({
		cusno:{label:"<spring:message code='label.CUST.cusno'/>"},
		cusnm:{label:"<spring:message code='label.CUST.cusnm'/>"},
		cusa1:{label:"<spring:message code='label.CUST.cusa1'/>"},
	}).setData();
}); 

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

.select-wrap {
 	width: 500px;
 	min-width: 500px;
 	margin: 0;
}

.gridContents {
	width: 100%;
	overflow-x: auto;
	position: relative;
	display: inline-block;
}

.grid-block {
	min-width:500px; 
	display:inline-block; 
	width: 100%;
}

.gridBtn {
	height:22px;
	line-height: 14px;
}

.doc-wrap {
	width:100%; 
	min-width:950px;
	padding: 20px;
	box-sizing: border-box;
}

[data-ax5grid] [data-ax5grid-container="root"] 
[data-ax5grid-container="body"] [data-ax5grid-panel] 
table tr td [data-ax5grid-cellHolder] {
	padding: 2px 5px;	
}

.schLine {
	margin: 0px 15px 0px 0px;
}

.k_cg1{background:#f6f6f6;border:1px solid #ccc;padding:5px 10px 0 10px;border-radius:5px;}
.k_cg1:after{content:'';display:table;clear:both;width:0;height:0;margin:0;padding:0;font-size:0;line-height:0;}
.k_cg1 .k_bg1{float:left;width:100px;text-align:right !important}
.k_cg1 .k_sg1{float:left;width:calc(100% - 100px);text-align:left !important;height:auto !important;}
.k_cg1 .k_l1{position:relative;display:inline-block;padding-left:10px;padding-right:8px;}
.k_cg1 .k_l1:before{position:absolute;left:0;top:50%;margin-top:-2px;content:'';display:block;width:3px;height:3px;background:#666;border-radius:50%;}

</style>

<div class="doc-wrap">
	<h2 class="subpage-tit"><spring:message code='label.WATPOP.deptTitle'/></h2>
	<div class="board-bList-wrap select-wrap">
		<div class="k_cg1" style="height : 40px;">
			<div class="gridBtnBlock k_sg1">
				<label class="k_l1"><spring:message code='label.WAN002.comps2'/></label>
				<select name="getComps" id="getComps" class="getComps schLine" disabled readOnly>
					<option value="E1">마산</option>
					<option value="C1">창원</option>
					<option value="S1">화성</option>
				</select>
			
				<label class="k_l1"><spring:message code='label.WAT001.code'/></label>
				<input type="text" class="AXInput getCode" style="width : 80px;" name="getCode" id="getCode" maxlength="8" 
				    onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)' placeholder="" title="">
			</div>
			<div class="gridBtnBlock k_bg1">
				<button type="button" class="AXButton Black" onclick="search();">
					<i class="axi axi-ion-android-search"></i>
					<spring:message code='label.search'/>
				</button>		
			</div>		
		</div>
			
		<div class="grid-block">
			<div class="gridContents" style="" id="grid-parent">
			    <div class="pt5 cmcGrid" data-ax5grid="grid" data-ax5grid-config="{showLineNumber: true}"></div>
			</div>
		</div>
	
		<div class="fr">
			<button type="button" class="AXButton Blue _applyBtn_" style=""
				onclick="" data-click-target="auth-save">
				<spring:message code='label.applyEmp' />
			</button>
			<button type="button" class="AXButton Normal _closeBtn_" onclick=""
				data-click-target="auth-close">
				<spring:message code='label.close' />
	
			</button>
		</div>
	</div>
</div>