<%--
 * PROJECT：
 *
 * [KR] 
 * 
 * $Id$
 *
 * Copyright (c) 2017 DENSO CORPORATION. All rights reserved.
 *
--%>
<!-- [EN] Contents area -->
<!-- [JP] コンテンツエリア -->
<%-- <spring:message code="label.filename" /> : <c:out value="${url }"></c:out> --%>
<link type="text/css" href="/css/commonGrid.css?ver" rel="stylesheet">
<script type="text/javascript" src="/js/commonPop.js"></script>
<script type="text/javascript" src="/js/commonGrid.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/WAD009RelationPopSelect.js?ver=3"></script>
<script>

$(function(){
	clsGrid.initView({
		relationCode:{label:"<spring:message code='label.WAB002.clsCode'/>&nbsp;<spring:message code='label.code'/>"},
		relationName:{label:"<spring:message code='label.WAB002.clsCode'/>&nbsp;<spring:message code='label.name'/>"},
	}).setData('CLS');
	
	locGrid.initView({
		relationCode:{label:"<spring:message code='label.WAB002.locCode'/>&nbsp;<spring:message code='label.code'/>"},
		relationName:{label:"<spring:message code='label.WAB002.locCode'/>&nbsp;<spring:message code='label.name'/>"},
	});
	
	teamGrid.initView({
		relationCode:{label:"<spring:message code='label.WAB002.teamCode'/>&nbsp;<spring:message code='label.code'/>"},
		relationName:{label:"<spring:message code='label.WAB002.teamCode'/>&nbsp;<spring:message code='label.name'/>"},
	});
}); 
</script>
<style>

.relationSelect-wrap {
 	width: 850px;
 	min-width: 850px;
 	margin: 0;
}

.gridContents {
	width: 100%;
}

.grid-block {
	min-width:255px; 
	display:inline-block; 
	margin:0 5px
}

.grid-block:nth-child(3) {
 	width: 300px;
 	min-width: 300px;
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

.list-top {
    text-align: right;
    margin-right: 65px;
    margin-top: 30px;
}

</style>
<h2 class="subpage-tit"><spring:message code="label.selectBusiness" /><!-- 사업부서 선택 --></h2>
<div style="text-align:right; margin-top: 5px;margin-bottom: 5px;margin-right: 65px;">
<input type="checkbox" name="allView" id="allView" value="" /> 미사용 부서포함
</div>
<div class="board-bList-wrap relationSelect-wrap">
	<div class="grid-block">
		<div class="gridContents" style="" id="grid-parent">
		    <div class="cmcGrid" data-ax5grid="cls-grid" data-ax5grid-config="{showLineNumber: true}"></div>
		       
		</div>
	</div>
	
	<div class="grid-block">
		<div class="gridContents" style="" id="grid-parent">
		    <div class="cmcGrid" data-ax5grid="loc-grid" data-ax5grid-config="{showLineNumber: true}"></div>
	    </div>
	</div>
	
	<div class="grid-block">
		<div class="gridContents" style="" id="grid-parent">
		    <div class="cmcGrid" data-ax5grid="team-grid" data-ax5grid-config="{showLineNumber: true}"></div>
		       
		</div>
	</div>
	<div class="gap10"></div>
	<div class="fr">
		<button type="button" class="AXButton Blue _applyBtn_" style=""
			onclick="" data-click-target="auth-save">
			<spring:message code='label.applyEmp' /><!-- 적용 -->
		</button>
		<button type="button" class="AXButton Normal _closeBtn_" onclick=""
			data-click-target="auth-close">
			<spring:message code='label.close' />
			<!-- 삭제 -->
		</button>
	</div>
</div>