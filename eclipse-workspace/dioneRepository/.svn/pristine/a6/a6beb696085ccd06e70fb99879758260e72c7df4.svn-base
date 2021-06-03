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

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" 	prefix="fn" %>

<link rel="stylesheet" media="all" href="/css/board.css"/>
<link rel="stylesheet" media="all" href="/css/bkmk.css"/>
<!-- <link rel="stylesheet" type="text/css" href="/js/lib/camohub_sortableList/style.css" media="screen"> -->
<script type="text/javascript" src="/js/lib/camohub_sortableList/jquery-sortable-lists.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/WAP001Bkmk.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/showModalDialog.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
<script>
$( function() {
	menuGrid.initView({
		mcdCode:{label:"<spring:message code='label.WAP001.mcdCode'/>"},
		mcdRefName:{label:"<spring:message code='label.WAP001.mcdRefName'/>"},
		mcdName:{label:"<spring:message code='label.WAP001.mcdName'/>"},
		useYn:{label:"<spring:message code='label.useYn'/>"},
	}).setData('menu');
});
</script>
<style>
.gridContents {
	width: 100%;
}

.grid-block {
	min-width:436px; 
	display:inline-block; 
	margin:0 5px;
	float: left;
}

.bkmk-block {
	min-width: 440px; 
	width: 440px;
	
}

.gridBtn {
	height:22px;
	line-height: 14px;
}

.gridBtnBlock{
	clear:both;
	float:right;
	margin-bottom: 10px;
}

.btnDiv {
	text-align:right;
	margin-bottom: 20px;
}

.subpage-tit{
	margin-bottom: 10px;
}

[data-ax5grid] [data-ax5grid-container="root"] 
[data-ax5grid-container="body"] [data-ax5grid-panel] 
table tr td [data-ax5grid-cellHolder] {
	padding: 2px 5px;
}

</style>
<h2 class="subpage-tit"><spring:message code='label.WAP001.title' />&nbsp;<spring:message code='label.management' /></h2>
<div class="">
	<form name="bkmk_form" method="post">
		
	<div class="btnDiv">
		<button type="button" class="AXButton Red _addBtn_" style="" onclick = "" data-click-target="CLS">
			<i><!--  class="axi axi-ion-person-add"> --></i>
			<spring:message code='label.sort' />&nbsp;<spring:message code='label.save' /><%--순서 저장 --%>
		</button>
	</div>
			
	<div class="grid-block">
		<div class="gridContents" style="" id="grid-parent">
		    <div class="menuGrid" data-ax5grid="menu-grid" data-ax5grid-config="{showLineNumber: true}"></div>
	    </div>
	</div>
	<div class="grid-block bkmk-block"> 
		<ul id="sortable">
			<c:forEach var="list" items="${bkmkList }">
			  <li class="ui-state-default"><i class="ico-drag-arrow"></i>${list.menuCodeNm }
				  <input type="checkbox" name="menuCode" value="${list.menuCode }" checked style="display:none;">
				  <%-- <span class="delete">
				  	<button type="button" class="AXButton Normal _deleteBtn_" onclick="javascript:delBkmk('${list.menuCode}', this);return false;" data-loction="" data-click-target="">
						<spring:message code='label.delete' />
						<!-- 삭제 -->
					</button>
				  </span> --%>
			  </li>
			</c:forEach>
		</ul>
		<ul class="ui-sortable" id="sortable"></ul>
		
	</div>
	<%-- <c:if test="${fn:length(vobkmk) eq 0 }">
		<li>선택된 마이메뉴가 없습니다.</li>
	</c:if>
	</ul> --%>
	</form>
</div>
