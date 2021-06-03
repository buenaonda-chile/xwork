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

<link rel="stylesheet" media="all" href="/css/board.css"/>
<link rel="stylesheet" media="all" href="/css/content.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/sal/NonOrderHostUpList.js?ver"></script>

<script  type="text/javascript">

//사업부를 선택해주세요.
var LN_SELECT_COMPS = "<spring:message code='WAN-I0-0001'/>";
//기준일자를 입력해주세요.
var LN_SELECT_PLNYM = "<spring:message code='WAN-I0-0011'/>";
//업체를 선택해주세요.
var LN_SELECT_PYVND = "<spring:message code='WAN-I0-0002'/>";
//[확인] 업체코드 확인바랍니다.
var LN_IO_CHK1 = "<spring:message code='WAN-I0-Chk1'/>";

var pyvndLabel = "<spring:message code='label.WAN007.pyvnd'/>";
var cusnmLabel = "<spring:message code='label.WAN000.cusnm'/>";
var faccdLabel = "<spring:message code='label.WAN016.faccd'/>";
var yardLabel = "<spring:message code='label.WAN016.yard'/>";	
var mkpnoLabel = "<spring:message code='label.WAN000.cprtn'/>";
var pspnoLabel = "<spring:message code='label.WAN001.pspno'/>";
var itdscLabel = "<spring:message code='label.WAN001.itdsc'/>";
var outqyLabel = "<spring:message code='label.WAN016.outqy'/>";

$(function(){
	
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
.gridContents {
	width: 100%;
	overflow-x: auto;
	position: relative;
	display: inline-block;
}

.grid-block {
	#min-width:1100px; 
	display:inline-block; 
	margin:0 5px;
	width: 100%;
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

.schLine {
	margin: 0px 15px 0px 0px;
}

/* 2021.01.08 */
.k_cg1{padding:14px 10px 0 15px;}
.k_cg1 .k_bg1{width:340px;}
.k_cg1 .k_sg1{width:calc(100% - 340px);}

.salGrid {
    height: 100%;
    min-height: 650px;
}

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
		
					<button type="button" class="xlsDown _excelBtn_">
						<span><spring:message code='label.excelDown' /></span>
					</button>
				</div>
					
				<div class="gridBtnBlock k_sg1">
		
					<div class="board-bList-wrap log_board">
						<div class="list-top">
							<div class="fl schLine">
								<label class="k_l1"><spring:message code='label.WAN009.chkdt'/></label>
								<div class="dropdown">
									<span class="calendar_icon vcen2"></span>
									<input type="text" class="dropbtn calendar_input getPlndt" name="getPlndt" id="getPlndt" value="${today}"/>
									<div class="dropdown-menu" role="menu"  id="plndt_calendar" style="width:250px;
									           border:1px solid #ccc;
									           border-radius: 5px;
									           padding: 5px;
									           overflow: hidden;" >
									</div>
								</div>
								
							</div>
						</div>
					</div>
					
					<label class="k_l1"><spring:message code='label.WAN002.comps2'/></label>
					<select name="getComps" id="getComps" class="getComps schLine">
						
						<option value="E1">마산</option>
						<option value="C1">창원</option>
						<option value="S1">화성</option>
						
						<!--<c:if test="${fn:length(codeList) > 0}">
							<c:forEach var="codeD2Domain" items="${codeList}" varStatus="status">
								<option value="${codeD2Domain.code2}"
									<c:if test="${codeD2Domain.code2 eq empComps}">
										selected
									</c:if>
								><c:out value="${codeD2Domain.code_name}"/></option>
							</c:forEach>
						</c:if>-->
					</select>	
		
					<div class="inlineBlock schLine" >	
						<label class="k_l1"><spring:message code='label.WAN002.pyvnd2'/></label>
						<input type="text" class="AXInput getPyvnd" style="width : 50px;" name="getPyvnd" id="getPyvnd" maxlength="8"
							onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)' onBlur="getCustSch();">
						<input type="text" class="AXInput getCusnm" style="width : 180px;" name="getCusnm" id="getCusnm" placeholder="<spring:message code='WAN-I0-0002'/>" title="<spring:message code='WAN-I0-0002'/>" disabled readOnly>
						<button type="button" onclick="" class="AXButton Normal _custBtn_">
							<spring:message code="label.select" />
						</button>				
					</div>
					
					<div class="inlineBlock" >
						<input type="radio" name="getTypcd" class="getTypcd" style="width : 30px;" value="BB" checked /><spring:message code='label.WAN015.BB'/>
						<input type="radio" name="getTypcd" class="getTypcd" style="width : 30px;" value="CC" /><spring:message code='label.WAN015.CC'/>
					</div>
		
				</div>
			</div>
	
		    <div class="pt5 salGrid" data-ax5grid="list-grid" data-ax5grid-config="{showLineNumber: true}"></div>
		       
		</div>
	</div>
</div>
