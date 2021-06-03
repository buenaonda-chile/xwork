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


<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/WAD008Relation.js?ver"></script>

<script  type="text/javascript">
$(function(){
	clsGrid.initView({
		relationCode:{label:"<spring:message code='label.WAB002.clsCode'/>&nbsp;<spring:message code='label.code'/>"},
		relationName:{label:"<spring:message code='label.WAB002.clsCode'/>&nbsp;<spring:message code='label.name'/>"},
		useYn:{label:"<spring:message code='label.useYn'/>"},
	}).setData('CLS');
	locGrid.initView({
		relationCode:{label:"<spring:message code='label.WAB002.locCode'/>&nbsp;<spring:message code='label.code'/>"},
		relationName:{label:"<spring:message code='label.WAB002.locCode'/>&nbsp;<spring:message code='label.name'/>"},
		useYn:{label:"<spring:message code='label.useYn'/>"},
	});
	teamGrid.initView({
		relationCode:{label:"<spring:message code='label.WAB002.teamCode'/>&nbsp;<spring:message code='label.code'/>"},
		relationName:{label:"<spring:message code='label.WAB002.teamCode'/>&nbsp;<spring:message code='label.name'/>"},
		useYn:{label:"<spring:message code='label.useYn'/>"},
		authCode:{label:"<spring:message code='label.WAD008.name'/>"},
	});
}); 
</script>
<style>
.gridContents {
	width: 100%;
}

.grid-block {
	min-width:320px; 
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

</style>

<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%--조회권한 --%>
	<div class="grid-block team-ms">
		<div class="gridContents" style="" id="grid-parent">
			<div class="gridBtnBlock">
				
				<input type="hidden" class="getCls" name="getCls" id="getCls" value=""/>
				<!-- 사업부를 입력해주세요. -->
				<input type="text" autofocus="true" class="AXInput" name="searchCodeInput" value="" onkeydown="enterProcess(this);" 
					placeholder="<spring:message code='DNKR-I0-0006'/>" title="<spring:message code='DNKR-I0-0006'/>">
				<button type="button" class="AXButton Black" onclick="searchRelation(document.getElementsByName('searchCodeInput')[0], 'CLS');">
					<i class="axi axi-ion-android-search"></i>
					<spring:message code='label.search'/>
				</button>
				<c:if test="${fn:substring(authBinaryNum, 2, 3) eq '1' }"><%--등록권한 --%>
					<div class="inlineBlock">
						<button type="button" class="AXButton Red _addBtn_" style="" onclick = "" data-click-target="CLS">
							<i><!--  class="axi axi-ion-person-add"> --></i>
							<spring:message code='label.register'/>
						</button>
					</div>
					<div class="displayNone">
						<button type="button" class="AXButton Blue _saveBtn_" onclick = "" data-click-target="CLS">
							<spring:message code='label.save'/>	<!-- 저장 -->			
						</button>
						<button type="button" class="AXButton Normal _closeBtn_" style="" onclick="" data-click-target="CLS">
							<i><!--  class="axi axi-ion-person-add"> --></i> 
							<spring:message code='label.close'/>	<!-- 닫기 -->
						</button>
					</div>
				</c:if>
			</div>
			
		    <div class="cmcGrid" data-ax5grid="cls-grid" data-ax5grid-config="{showLineNumber: true}"></div>
		       
		</div>
	</div>
	
	<div class="grid-block team-ms">
		<div class="gridContents" style="" id="grid-parent">
			<div  class="gridBtnBlock">
			
				<input type="hidden" class="getLoc" name="getLoc" id="getLoc" value=""/>
				<!-- 사업장을 입력해주세요. -->
				<input type="text" class="AXInput" name="searchCodeInput" value="" onkeydown="enterProcess(this);" 
					placeholder="<spring:message code='DNKR-I0-0007'/>" title="<spring:message code='DNKR-I0-0007'/>">
				<button type="button" class="AXButton Black" onclick="searchRelation(document.getElementsByName('searchCodeInput')[1], 'LOC');">
					<i class="axi axi-ion-android-search"></i>
					<spring:message code='label.search'/>
				</button>
				<c:if test="${fn:substring(authBinaryNum, 2, 3) eq '1' }"><%--등록권한 --%>
					<div class="inlineBlock">
						<button type="button" class="AXButton Red _addBtn_" style="" onclick = ""  data-click-target="LOC">
							<i><!--  class="axi axi-ion-person-add"> --></i>
							<!-- 사업장등록 -->
							<spring:message code='label.register'/>
						</button>
					</div>
					<div class="displayNone">
						<button type="button" class="AXButton Blue _saveBtn_" onclick = "" data-click-target="LOC">
							<spring:message code='label.save'/>	<!-- 저장 -->			
						</button>
						<button type="button" class="AXButton Normal _closeBtn_" style="" onclick="" data-click-target="LOC">
							<i><!--  class="axi axi-ion-person-add"> --></i> 
							<spring:message code='label.close'/>	<!-- 닫기 -->
						</button>
					</div>
				</c:if>
			</div>
			
		    <div class="cmcGrid" data-ax5grid="loc-grid" data-ax5grid-config="{showLineNumber: true}"></div>
	    </div>
	</div>
	
	<div class="grid-block third-grid-block team-ms">
		<div class="gridContents" style="" id="grid-parent">
			<div  class="gridBtnBlock">
				<!-- DNKR-I0-0008=부서(팀)을 입력해주세요. -->
				<input type="text" class="AXInput" name="searchCodeInput" value="" onkeydown="enterProcess(this);" 
					placeholder="<spring:message code='DNKR-I0-0008'/>" title="<spring:message code='DNKR-I0-0008'/>">
				<%-- <input type="text" class="AXInput" name="searchCodeInput" value="" onkeydown="enterProcess(this);" 
				placeholder="<spring:message code='label.comment.cnmcodename'/>"> --%>
				<button type="button" class="AXButton Black" onclick="searchRelation(document.getElementsByName('searchCodeInput')[2], 'TEAM');">
					<i class="axi axi-ion-android-search"></i>
					<spring:message code='label.search'/>
				</button>
				<c:if test="${fn:substring(authBinaryNum, 2, 3) eq '1' }"><%--등록권한 --%>
					<div class="inlineBlock">
						<button type="button" class="AXButton Red _addBtn_" style="" onclick = ""  data-click-target="TEAM">
							<i><!--  class="axi axi-ion-person-add"> --></i>
							<!-- 사업부서등록 -->
							<spring:message code='label.register'/>
						</button>
					</div>
					<div class="displayNone">
						<button type="button" class="AXButton Blue _saveBtn_" onclick = "" data-click-target="TEAM">
							<spring:message code='label.save'/>	<!-- 저장 -->			
						</button>
						<button type="button" class="AXButton Normal _closeBtn_" style="" onclick="" data-click-target="TEAM">
							<i><!--  class="axi axi-ion-person-add"> --></i> 
							<spring:message code='label.close'/>	<!-- 닫기 -->
						</button>
					</div>
				</c:if>
		</div>
			
		    <div class="cmcGrid" data-ax5grid="team-grid" data-ax5grid-config="{showLineNumber: true}"></div>
		       
		</div>
		
	</div>

	<form name="deptRntn" action="${pageContext.request.contextPath}/WAD008RelationSearch/deptRntn.do">
		<div class="inlineBlock">
			<button type="submit" class="AXButton Red _deptRntn_" style="" onclick = ""  data-click-target="DNKR">
				부서정보 받아오기
			</button>
		</div>
	</form>
</c:if>
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '0' }"><%--조회권한 --%>
	<div>
		<span><spring:message code='DNKR-E2-0000'/><!-- 권한이 없습니다. --></span>
	</div>
</c:if>