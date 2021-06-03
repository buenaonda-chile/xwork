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

<link rel="stylesheet" media="all" href="/css/board.css">
<link type="text/css" href="/css/commonGrid.css" rel="stylesheet">
<script type="text/javascript" src="/js/commonGrid.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/WAD011Menu.js"></script>
<script>
var labels = {
		menu:{label:"<spring:message code='label.menu'/>"},
		mcdCode:{label:"<spring:message code='label.WAP001.mcdCode'/>"},
		mcdName:{label:"<spring:message code='label.WAP001.mcdName'/>"},
		menuSort:{label:"<spring:message code='label.menu'/>&nbsp;<spring:message code='label.sort'/>"},
		useYn:{label:"<spring:message code='label.useYn'/>"},
	};
$(document.body).ready(function() {
	
	depth1Grid.initView(labels).setData();
	depth2Grid.initView(labels);
	depth3Grid.initView(labels);
})
</script>
<style>
.menu_wrap {
    width: 1100px;
    overflow-x: auto;
}

.menuGrid {
 	min-height: 250px;
}

.gridContents {
	width: 100%;
}

.grid-block {
	width : 350px;
	min-width:350px; 
	display:inline-block; 
	margin:0 5px
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

.menu_wrap .gridBtnBlock {
	height: 68px;
}

.board-write-wrap {
	width: 1080px;
    margin-left: 5px;
}

.menu_wrap .board-write-wrap table th, .menu_wrap .board-write-wrap table td {
	padding: 5px 20px;
}

.menu_wrap .board-write-wrap table th .necessary {
	margin-left: -10px;
}

.menu_wrap .board-write-wrap tr {
    height: 47px;
}
</style>

<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%--조회권한 --%>
<div class="m-scroll">
	<div class="menu_wrap">
		<div class="grid-block">
			<div class="gridContents" style="" id="grid-parent">
				<div class="gridBtnBlock">
					<div class="sc_tit">
						1Depth<span class="btLine"></span>
					</div>
					<input type="text" autofocus="true" class="AXInput" name="searchCodeInput" value="" placeholder="메뉴명을 입력해 주세요." title="메뉴명을 입력해 주세요.">
						<%-- <input type="text" class="AXInput" name="searchCodeInput" value="" onkeydown="enterProcess(this);" 
						placeholder="<spring:message code='DNKR-I0-0006'/>" title="<spring:message code='DNKR-I0-0006'/>"> --%>
					<button type="button" class="AXButton Black" onclick="searchMenu(document.getElementsByName('searchCodeInput')[0], 'D_1');">
						<i class="axi axi-ion-android-search"></i>
						<spring:message code='label.search'/>
					</button>
					<c:if test="${fn:substring(authBinaryNum, 2, 3) eq '1' }"><%--등록권한 --%>
						<div class="inlineBlock">
							<button type="button" class="AXButton Red _addBtn_" style="" onclick = "" data-click-target="D_1">
								<i><!--  class="axi axi-ion-person-add"> --></i>
								<spring:message code='label.register'/>
							</button>
						</div>
						<div class="displayNone">
							<button type="button" class="AXButton Blue _saveBtn_" onclick = "" data-click-target="D_1">
								<spring:message code='label.save'/>	<!-- 저장 -->			
							</button>
							<button type="button" class="AXButton Normal _closeBtn_" style="" onclick="" data-click-target="D_1">
								<i><!--  class="axi axi-ion-person-add"> --></i> 
								<spring:message code='label.close'/>	<!-- 닫기 -->
							</button>
						</div>
					</c:if>
				</div>
				
			    <div class="menuGrid" data-ax5grid="depth1-grid" data-ax5grid-config="{showLineNumber: true}"></div>
			       
			</div>
		</div>
		
		<div class="grid-block">
			<div class="gridContents" style="" id="grid-parent">
				<div  class="gridBtnBlock">
				
					<div class="sc_tit">
						2Depth<span class="btLine"></span>
					</div>
					<input type="text" class="AXInput" name="searchCodeInput" placeholder="메뉴명을 입력해 주세요." title="메뉴명을 입력해주세요">
					<button type="button" class="AXButton Black" onclick="searchMenu(document.getElementsByName('searchCodeInput')[1], 'D_2');">
						<i class="axi axi-ion-android-search"></i>
						<spring:message code='label.search'/>
					</button>
					<c:if test="${fn:substring(authBinaryNum, 2, 3) eq '1' }"><%--등록권한 --%>
						<div class="inlineBlock">
							<button type="button" class="AXButton Red _addBtn_" style="" onclick = ""  data-click-target="D_2">
								<i><!--  class="axi axi-ion-person-add"> --></i>
								<!-- 사업장등록 -->
								<spring:message code='label.register'/>
							</button>
						</div>
						<div class="displayNone">
							<button type="button" class="AXButton Blue _saveBtn_" onclick = "" data-click-target="D_2">
								<spring:message code='label.save'/>	<!-- 저장 -->			
							</button>
							<button type="button" class="AXButton Normal _closeBtn_" style="" onclick="" data-click-target="D_2">
								<i><!--  class="axi axi-ion-person-add"> --></i> 
								<spring:message code='label.close'/>	<!-- 닫기 -->
							</button>
						</div>
					</c:if>
				</div>
				
			    <div class="menuGrid" data-ax5grid="depth2-grid" data-ax5grid-config="{showLineNumber: true}"></div>
		    </div>
		</div> 
		
		<div class="grid-block">
			<div class="gridContents" style="" id="grid-parent">
				<div  class="gridBtnBlock">
					<div class="sc_tit">
						3Depth<span class="btLine"></span>
					</div>
					<input type="text" class="AXInput" name="searchCodeInput" placeholder="메뉴명을 입력해 주세요." title="메뉴명을 입력해주세요">
					<button type="button" class="AXButton Black" onclick="searchMenu(document.getElementsByName('searchCodeInput')[2], 'D_3');">
						<i class="axi axi-ion-android-search"></i>
						<spring:message code='label.search'/>
					</button>
					<c:if test="${fn:substring(authBinaryNum, 2, 3) eq '1' }"><%--등록권한 --%>
						<div class="inlineBlock">
							<button type="button" class="AXButton Red _addBtn_" style="" onclick = ""  data-click-target="D_3">
								<i><!--  class="axi axi-ion-person-add"> --></i>
								<!-- 사업부서등록 -->
								<spring:message code='label.register'/>
							</button>
						</div>
						<div class="displayNone">
							<button type="button" class="AXButton Blue _saveBtn_" onclick = "" data-click-target="D_3">
								<spring:message code='label.save'/>	<!-- 저장 -->			
							</button>
							<button type="button" class="AXButton Normal _closeBtn_" style="" onclick="" data-click-target="D_3">
								<i><!--  class="axi axi-ion-person-add"> --></i> 
								<spring:message code='label.close'/>	<!-- 닫기 -->
							</button>
						</div>
					</c:if>
			</div>
				
			    <div class="menuGrid" data-ax5grid="depth3-grid" data-ax5grid-config="{showLineNumber: true}"></div>
			       
			</div>
			
		</div>
	</div><!-- menu_wrap -->
</div>
	<div class="sssgap"></div>
	<!-- <div class="menu_wrap"> -->
<div class="m-scroll">
	<div class="menu_wrap">
		<div class="board-write-wrap">
			<span class="top-border"></span> 
			<form:form action="${pageContext.request.contextPath}/ajaxMenu/update.do?menu=${menu}" id="updateForm" modelAttribute="WAD011MenuCreateForm" name="WAD011MenuCreateForm" method="POST">
			<input type="hidden" name="tabId" value="<c:out value="${tabId}"></c:out>" />
			<input type="hidden" id="mcdCode" name="mcdCode"/>
				<table class="write_01" summary="각 해당하는 항목에 알맞게 내용을 입력해주세요">
					<caption>내용 입력폼</caption>
					<colgroup>
						<col width="12%">
						<col width="88%">
					</colgroup>
					<tbody>
						<tr>
							<th class="check">
								<label for="mcdIcon">
									아이콘
									<%-- <spring:message code="label.WAB002.empNumber" /> --%>
								</label>
							</th>
							<td>
								<div class="inlineBlock">
									<form:input style="width:150px; margin-right:10px;" cssClass="form-control input-xs required inlineBlock" type="text" id="mcdIcon" path="mcdIcon" maxlength="100" cssErrorClass="form-control input-xs bg_error" placeholder="아이콘 클래스명을 입력해 주세요." title="아이콘 클래스명을 입력해 주세요." required="true" autofocus="true" />
									<form:errors path="mcdIcon" cssStyle="color:#ff0000;" element="span" />
									<button type="button" class="AXButton Normal _iconSearchBtn_" style="" id="" data-click-target="icon_search">
										<!-- 아이콘링크 -->
										<spring:message code='label.WAA002.name'/>
									</button>
								</div>
							</td>
						</tr>
						<tr>
							<th class="check">
								<span class="necessary">* </span>
								<label for="mcdName">
									메뉴명
									<%-- <spring:message code="label.WAB002.empNumber" /> --%>
								</label>
							</th>
							<td>
								<div class="inlineBlock">
									<form:input style="width:200px;" cssClass="form-control input-xs required inlineBlock" type="text" id="mcdName" path="mcdName" maxlength="100" cssErrorClass="form-control input-xs bg_error" placeholder="메뉴명을 입력해 주세요." title="메뉴명을 입력해 주세요." required="true" autofocus="true" />
									<form:errors path="mcdName" cssStyle="color:#ff0000;" element="span" />
									
								</div>
							</td>
						</tr>
						<tr>
							<th class="check">
								<label for="mcdUrl">
									URL
									<%-- <spring:message code="label.WAB002.empNumber" /> --%>
								</label>
							</th>
							<td>
								<div class="inlineBlock">
									<form:input style="width:600px;" cssClass="form-control input-xs required inlineBlock" type="text" id="mcdUrl" path="mcdUrl" maxlength="500" cssErrorClass="form-control input-xs bg_error" placeholder="URL을 입력해 주세요." title="URL을 입력해 주세요." required="true" autofocus="true" />
									<form:errors path="mcdUrl" cssStyle="color:#ff0000;" element="span" />
									
								</div>
							</td>
						</tr>
						<tr>
							<th class="check">
								사용여부
								<%-- <spring:message code="label.WAB002.empAvailability" /> --%><!-- 사원 사용여부 -->
							</th>
							<td>
								<form:radiobutton id="mcdUseY" path="mcdUse" value="Y" checked="checked"/>
									<spring:message code="label.yes" /><!-- 예 -->&nbsp;
								<form:radiobutton id="mcdUseN" path="mcdUse" value="N" />
									<spring:message code="label.no" /><!-- 아니오 -->
								<form:errors path="mcdUse" cssStyle="color:#ff0000;" element="span" />
							</td>
						</tr>
						<tr>
							<th class="check">
								새창여부
								<%-- <spring:message code="label.WAB002.empAvailability" /> --%><!-- 사원 사용여부 -->
							</th>
							<td>
								<form:radiobutton id="mcdNewWindowY" path="mcdNewWindow" value="Y" checked="checked"/>
									<spring:message code="label.yes" /><!-- 예 -->&nbsp;
								<form:radiobutton id="mcdNewWindowN" path="mcdNewWindow" value="N" />
									<spring:message code="label.no" /><!-- 아니오 -->
								<form:errors path="mcdNewWindow" cssStyle="color:#ff0000;" element="span" />
							</td>
						</tr>
						<tr>
							<th class="check">
								추가인증
								<%-- <spring:message code="label.WAB002.empAvailability" /> --%><!-- 사원 사용여부 -->
							</th>
							<td>
								<form:radiobutton id="mcdAddCertY" path="mcdAddCert" value="Y" checked="checked"/>
									<spring:message code="label.yes" /><!-- 예 -->&nbsp;
								<form:radiobutton id="mcdAddCertN" path="mcdAddCert" value="N" />
									<spring:message code="label.no" /><!-- 아니오 -->
								<form:errors path="mcdAddCert" cssStyle="color:#ff0000;" element="span" />
							</td>
						</tr>
						<tr>
							<th class="check">
								모바일
								<%-- <spring:message code="label.WAB002.empAvailability" /> --%><!-- 사원 사용여부 -->
							</th>
							<td>
								<form:radiobutton id="mcdMobileY" path="mcdMobile" value="Y" checked="checked"/>
									<spring:message code="label.yes" /><!-- 예 -->&nbsp;
								<form:radiobutton id="mcdMobileN" path="mcdMobile" value="N" />
									<spring:message code="label.no" /><!-- 아니오 -->
								<form:errors path="mcdMobile" cssStyle="color:#ff0000;" element="span" />
							</td>
						</tr>
					</tbody>
				</table> 
				
				<div class="list-bnt writeOnly">
					<button type="button" class="red" name="Register" onclick="return updateFormMenu()">
						<spring:message code="label.modify" /><!-- 수정 -->
					</button>
					<button type="button" onclick="javascript:void(0)" class="gray _deleteBtn_">
						<spring:message code="label.delete" /><!-- 삭제 -->
					</button>
				</div>
			
			</form:form>
			
		</div>
	</div>
	
</div>
</c:if>
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '0' }"><%--조회권한 --%>
	<div>
		<span><spring:message code='DNKR-E2-0000'/><!-- 권한이 없습니다. --></span>
	</div>
</c:if>