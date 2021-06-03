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

<link type="text/css" href="/css/subCommon.css" rel="stylesheet">
<link type="text/css" href="/css/commonGrid.css?ver" rel="stylesheet">
<script type="text/javascript" src="/js/form_valid.js"></script>
<script type="text/javascript" src="/js/commonPop.js"></script>
<script type="text/javascript" src="/js/commonGrid.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/project/WAK006WorkSortPop.js?ver=3"></script>

<script type="text/javascript">
$(function(){
	workLGrid.initView({
		cmcCode:{label:"<spring:message code='label.WAC015.gridlabel.cmcCode'/>"},
		cnmName:{label:"<spring:message code='label.WAC015.gridlabel.cnmName'/>"},
		cmcUseYN:{label:"<spring:message code='label.WAC015.gridlabel.cmcUseYN'/>"}
	}).setData('L');
	workMGrid.initView({
		cmcCode:{label:"<spring:message code='label.WAC015.gridlabel.cmcCode'/>"},
		cnmName:{label:"<spring:message code='label.WAC015.gridlabel.cnmName'/>"},
		cmcUseYN:{label:"<spring:message code='label.WAC015.gridlabel.cmcUseYN'/>"},
		cmcMngt:{label:"<spring:message code='label.WAC015.gridlabel.cmcMngt'/>"}
	});
	workSGrid.initView({
		cmcCode:{label:"<spring:message code='label.WAC015.gridlabel.cmcCode'/>"},
		cnmName:{label:"<spring:message code='label.WAC015.gridlabel.cnmName'/>"},
		cmcUseYN:{label:"<spring:message code='label.WAC015.gridlabel.cmcUseYN'/>"}
	});
}); 
</script>
<style>

.doc-wrap {
	padding: 10px;
}

.gridContents {
	width: 100%;
}

.grid-block, .third-grid-block{
	width:375px; 
	display:inline-block; 
	margin:0;
}

.second-grid-block {
	width:465px; 
	display:inline-block; 
	margin:0;
}

.gridBtnBlock {
	height: auto;
}

.gridBtn {
	height:22px;
	line-height: 14px;
}

.sc_tit {
	color: #555;
    font-weight: bold;
    width: 110px;
    font-size: 16px;
    text-align: center;
    margin: 0 auto 10px;
}

.sc_tit .btLine {
    display: block;
    height: 4px;
    background: url(/img/btl_bg.jpg) repeat-y -7px center #c1393b;
    border-radius: 20px;
    margin-top: 4px;
}

.second-grid-block .cmcGrid .AXButton.Red {
    max-width: 80px;
    text-overflow: ellipsis;
    white-space: nowrap;
    word-wrap: normal;
    overflow: hidden;
}

</style>

<h2 class="subpage-tit"><spring:message code="label.WAK005.name" /><!-- 업무분류 관리 --></h2>
<div class="board-bList-wrap">
	<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%--조회권한 --%>
		<input type="hidden" value="${teamCode}" id="teamCode">
		<div class="grid-block">
			<div class="gridContents" style="" id="grid-parent">
				<div class="sc_tit">
					<input type="hidden" class="getWtcL" name="getWtcL" id="getWtcL" value=""/>
					<!-- 업무분류 (대) -->
					<spring:message code='label.WAK001.list5'/>
					<span class="btLine"></span>
				</div>
				<div class="gridBtnBlock">
					<input type="text" class="AXInput" name="searchCodeInput" value="" onkeydown="enterProcess(this);" 
					placeholder="<spring:message code='label.comment.cnmcodename'/>">
					<button type="button" class="AXButton Black" onclick="searchWorkSort(document.getElementsByName('searchCodeInput')[0], 'L');">
						<i class="axi axi-ion-android-search"></i>
						<spring:message code='label.search'/>
					</button>
					<c:if test="${fn:substring(authBinaryNum, 2, 3) eq '1' }"><%--등록권한 --%>
						<div class="inlineBlock">
							<button type="button" class="AXButton Red _addBtn_" style="" onclick = "" data-click-target="L">
								<i><!--  class="axi axi-ion-person-add"> --></i>
								<!-- 등록 -->
							<spring:message code='label.add'/>
							</button>
						</div>
						<div class="displayNone">
							<button type="button" class="AXButton Blue _saveBtn_" onclick = "" data-click-target="L">
								<spring:message code='label.save'/>	<!-- 저장 -->			
							</button>
							<button type="button" class="AXButton Normal _closeBtn_" onclick="" data-click-target="L">
								<i><!--  class="axi axi-ion-person-add"> --></i> 
								<spring:message code='label.close'/>	<!-- 닫기 -->
							</button>
						</div>
					</c:if>
				</div>
				
			    <div class="cmcGrid" data-ax5grid="cls-grid" data-ax5grid-config="{showLineNumber: true}"></div>
			       
			</div>
			
		</div>
		
		<div class="grid-block second-grid-block">
			<div class="gridContents" style="" id="grid-parent">
			<!-- <h2 style="text-align:right">업무분류(중)[직무]</h2> -->
				<div class="sc_tit">
					<input type="hidden" class="getWtcM" name="getWtcM" id="getWtcM" value=""/>
					<!-- 업무분류 (중) -->
					<spring:message code='label.WAK001.list6'/>
					<span class="btLine"></span>
				</div>
				<div class="gridBtnBlock">
					<input type="text" class="AXInput" name="searchCodeInput" value="" onkeydown="enterProcess(this);" 
						placeholder="<spring:message code='label.comment.cnmcodename'/>">
					<button type="button" class="AXButton Black" onclick="searchWorkSort(document.getElementsByName('searchCodeInput')[1], 'M');">
						<i class="axi axi-ion-android-search"></i>
						<spring:message code='label.search'/>
					</button>
					<c:if test="${fn:substring(authBinaryNum, 2, 3) eq '1' }"><%--등록권한 --%>
						<div class="inlineBlock">
							<button type="button" class="AXButton Red _addBtn_" style="" onclick = "" data-click-target="M">
								<i><!--  class="axi axi-ion-person-add"> --></i>
								<!-- 등록 -->
								<spring:message code='label.add'/>
							</button>
						</div>
						<div class="displayNone">
							<button type="button" class="AXButton Blue _saveBtn_" onclick = "" data-click-target="M">
								<spring:message code='label.save'/>	<!-- 저장 -->			
							</button>
							<button type="button" class="AXButton Normal _closeBtn_" onclick="" data-click-target="M">
								<i><!--  class="axi axi-ion-person-add"> --></i> 
								<spring:message code='label.close'/>	<!-- 닫기 -->
							</button>
						</div>
					</c:if>
				</div>
				
			    <div class="cmcGrid" data-ax5grid="loc-grid" data-ax5grid-config="{showLineNumber: true}"></div>
		    </div>
		</div>
		
		<div class="grid-block third-grid-block">
			<div class="gridContents" style="" id="grid-parent">
				<!-- <h2 style="text-align:right">업무분류(소)[개인입력]</h2> -->
				<div class="sc_tit">
					<!-- 업무분류 (소) -->
					<spring:message code='label.WAK001.list7'/>
					<span class="btLine"></span>
				</div>
				<div class="gridBtnBlock">
					<input type="text" class="AXInput" name="searchCodeInput" value="" onkeydown="enterProcess(this);" 
					placeholder="<spring:message code='label.comment.cnmcodename'/>">
					<button type="button" class="AXButton Black" onclick="searchWorkSort(document.getElementsByName('searchCodeInput')[2], 'S');">
						<i class="axi axi-ion-android-search"></i>
						<spring:message code='label.search'/>
					</button>
					
					<div class="inlineBlock">
						<button type="button" class="AXButton Red _addBtn_" style="" onclick = "" data-click-target="S">
							<i><!--  class="axi axi-ion-person-add"> --></i>
							<!-- 등록 -->
							<spring:message code='label.add'/>
						</button>
					</div>
					<div class="displayNone">
						<button type="button" class="AXButton Blue _saveBtn_" onclick = "" data-click-target="S">
							<spring:message code='label.save'/>	<!-- 저장 -->			
						</button>
						<button type="button" class="AXButton Normal _closeBtn_" onclick="" data-click-target="S">
							<i><!--  class="axi axi-ion-person-add"> --></i> 
							<spring:message code='label.close'/>	<!-- 닫기 -->
						</button>
					</div>
				</div>
				
			    <div class="cmcGrid" data-ax5grid="team-grid" data-ax5grid-config="{showLineNumber: true}"></div>
			       
			</div>
		</div>
	</c:if>
	<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '0' }"><%--조회권한 --%>
		<div>
			<span><spring:message code='DNKR-E2-0000'/><!-- 권한이 없습니다. --></span>
		</div>
	</c:if>
</div>