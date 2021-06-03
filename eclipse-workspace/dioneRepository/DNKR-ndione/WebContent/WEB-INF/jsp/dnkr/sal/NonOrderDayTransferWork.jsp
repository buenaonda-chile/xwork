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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/sal/NonOrderDayTransferWork.js?ver"></script>

<script  type="text/javascript">

//사업부를 선택해주세요.
var LN_SELECT_COMPS = "<spring:message code='WAN-I0-0001'/>";
//업체를 선택해주세요.
var LN_SELECT_PYVND = "<spring:message code='WAN-I0-0002'/>";
//[확인] 업체코드 확인바랍니다.
var LN_IO_CHK1 = "<spring:message code='WAN-I0-Chk1'/>";
//기준일자를 입력해주세요.
var LN_SELECT_PLNYM = "<spring:message code='WAN-I0-0011'/>";

$(function(){
	//
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
	width: 800px;
	overflow-x: auto;
	height:400px;
}

.grid-block {
	min-width:800px; 
	display:inline-block; 
	margin:0 5px
}

.gridBtn {
	height:22px;
	line-height: 14px;
}

.schLine {
	margin: 0px 15px 0px 0px;
}
</style>
				
<div class="grid-block team-ms">
	<div class="gridContents" style="" id="grid-parent">
		<div class="gridBtnBlock">
			<button type="button" class="AXButton Blue _transBtn_" onclick="trans();">
				<span><spring:message code='label.WAN013.trans'/></span>
			</button>
		</div>
				
		<div class="gridBtnBlock">
	
			<input type="hidden" id="getUserId" name="getUserId" value="${userId}"/>
			
			<div class="board-bList-wrap log_board">
				<div class="list-top">
					<div class="fl">
						<spring:message code='label.WAN009.chkdt'/>
						<div class="dropdown">
							<span class="calendar_icon vcen2"></span>
							<input type="text" class="dropbtn calendar_input getPlnym" name="getPlnym" id="getPlnym" value="${today}"/>
							<div class="dropdown-menu" role="menu"  id="plnym_calendar" style="width:250px;
							           border:1px solid #ccc;
							           border-radius: 5px;
							           padding: 5px;
							           overflow: hidden;" >
							</div>
						</div>
						
					</div>
				</div>
			</div>
				
			<div class="inlineBlock schLine" >
				<input type="radio" name="getTypcd" class="getTypcd" style="width : 30px;" value="BB" checked /><spring:message code='label.WAN015.BB'/>
				<input type="radio" name="getTypcd" class="getTypcd" style="width : 30px;" value="CC" /><spring:message code='label.WAN015.CC'/>
			</div>				
			
			<spring:message code='label.WAN002.comps2'/>
			<select name="getComps" id="getComps" class="getComps schLine">
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
		
			<div class="inlineBlock" >	
				<spring:message code='label.WAN002.pyvnd2'/>
				<input type="text" class="AXInput getPyvnd" style="width : 50px;" name="getPyvnd" id="getPyvnd" maxlength="8"
					onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)' onBlur="getCustSch();">
				<input type="text" class="AXInput getCusnm" style="width : 150px;" name="getCusnm" id="getCusnm" placeholder="<spring:message code='WAN-I0-0002'/>" title="<spring:message code='WAN-I0-0002'/>" disabled readOnly>
				<button type="button" onclick="" class="AXButton Normal _custBtn_">
					<spring:message code="label.select" />
				</button>				
			</div>

		</div>

		<div class="cb pt5 " style="min-width:800px;">

			<table class="pd-s-table first-tbl">
				<tr>
					<th style="width : 25%;">
						<spring:message code='label.WAN013.cigmaDate'/>
					</th>
					<td style="width : 25%;">
						<input type="text" name="cigmaDate" id="cigmaDate" style="width: 100%;text-align: center;" title="" value="${cigmaDate}" readonly disabled />
					</td>
					<th style="width : 25%;">
						<spring:message code='label.WAN013.systemDate'/>
					</th>
					<td style="width : 25%;">
						<input type="text" name="systemDate" id="systemDate" style="width: 100%;text-align: center;" title="" value="${today}" readonly disabled />
					</td>
				</tr>
			</table>
		</div>
		
	</div>
</div>
