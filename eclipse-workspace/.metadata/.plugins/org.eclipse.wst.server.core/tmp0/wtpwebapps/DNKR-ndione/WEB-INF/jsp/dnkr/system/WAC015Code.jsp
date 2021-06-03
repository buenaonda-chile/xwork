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
<spring:message var="errormessage_tel" code="SMPL-E8-0004" />
<!-- <script type="text/javascript" src="/js/subCommon.js"></script> -->

<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/WAC015Code.js"></script>
<script>
	
	$(function(){
		cmcGrid.initView({
			cmcCode:{label:"<spring:message code='label.WAC015.gridlabel.cmcCode'/>"},
			cnmName:{label:"<spring:message code='label.WAC015.gridlabel.cnmName'/>"},
			cmcUseYN:{label:"<spring:message code='label.WAC015.gridlabel.cmcUseYN'/>"}
		}).setData('MAIN');
		subCmcGrid.initView({
			cmcCode:{label:"<spring:message code='label.WAC015.gridlabel.cmcCode'/>"},
			cnmName:{label:"<spring:message code='label.WAC015.gridlabel.cnmName'/>"},
			cmcUseYN:{label:"<spring:message code='label.WAC015.gridlabel.cmcUseYN'/>"},
			cnmDescription:{label:"<spring:message code='label.WAC015.gridlabel.cnmDescription'/>"}
		});
	}); 
		
</script>
<!-- [EN] Contents area -->
<!-- [JP] コンテンツエリア -->


<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%--조회권한 --%>
	<div class="cmcContents" style="" id="grid-parent">
		<div style="width:100%;margin-bottom:10px;text-align:right;">
			<input autofocus="true" type="text" class="AXInput" name="searchCodeInput" value="" title="<spring:message code='label.comment.cnmcodename'/>" placeholder="<spring:message code='label.comment.cnmcodename'/>">
			
			<%-- <button class="search-bnt" type="button"  onclick="searchCmc(document.getElementsByName('searchCodeInput')[0], 'MAIN');">
				<span><spring:message code='label.select'/></span><!-- 조회 -->
			</button>
			 --%>
			<button type="button" class="AXButton Black" onclick="searchCmc(document.getElementsByName('searchCodeInput')[0], 'MAIN');">
				<i class="axi axi-ion-android-search"></i>
				<spring:message code='label.search'/>
			</button>
			<!-- <button type="button" class="AXButton Normal" style="" onclick = "openEditBox('main');"> -->
			<c:if test="${fn:substring(authBinaryNum, 2, 3) eq '1' }"><%--등록권한 --%>
				<div class="inlineBlock">
					<button type="button" class="AXButton Red _addBtn_" style="" onclick = "" >
						<i><!-- class="axi axi-ion-person-add" --></i>
						<spring:message code='label.cmcregister'/><!-- 코드 등록  -->
					</button>
				</div>
				<div  class="displayNone">
					<button type="button" class="AXButton Blue _saveBtn_" style="" onclick = "" data-click-target="MAIN">
						<spring:message code='label.save'/>	<!-- 저장 -->			
					</button>
					<button type="button" class="AXButton Normal _closeBtn_" style="" onclick="" data-click-target="MAIN">
						<i><!--  class="axi axi-ion-person-add"> --></i> 
						<spring:message code='label.close'/>	<!-- 닫기 -->
					</button>
				</div>
			</c:if>
		</div>
		
	    <div class="cmcGrid" data-ax5grid="cmc-grid" data-ax5grid-config="{showLineNumber: true}"></div>
	       
	</div>
	<div class="cnmContents" id="grid-parent">
	
		<div style="width:100%;margin-bottom:13px;height:28px;text-align:right;">
			<c:if test="${fn:substring(authBinaryNum, 2, 3) eq '1' }"><%--등록권한 --%>
				<div>
					<button type="button" class="AXButton Red _addSubBtn_" style="" onclick="">
						<i><!--  class="axi axi-ion-person-add"> --></i> 
						<spring:message code='label.subcmcregister'/><!-- 코드 등록  -->
					</button>
				</div>
				<div class="displayNone">
					<button type="button" class="AXButton Blue _saveBtn_" style="" onclick="" data-click-target="SUB">
						<i><!-- class="axi axi-ion-person-add"> --></i> 
						<spring:message code='label.save'/>	<!-- 저장 -->	
					</button>
					<button type="button" class="AXButton Normal _closeBtn_" style="" onclick="" data-click-target="SUB">
						<i><!--  class="axi axi-ion-person-add"> --></i> 
						<spring:message code='label.close'/>	<!-- 닫기 -->
					</button>
				</div>
			</c:if>
		</div>
		
		<div class="cnmGrid" data-ax5grid="cnm-grid" data-ax5grid-config="{}"></div>
	</div>
</c:if>
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '0' }"><%--조회권한 --%>
	<div>
		<span><spring:message code='DNKR-E2-0000'/><!-- 권한이 없습니다. --></span>
	</div>
</c:if>