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
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/wamCommon.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/sal/OrderDayTransferWork.js?ver"></script>

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
	overflow-x: auto;
	height:400px;
}

.grid-block {
	width:100%;
	display:block; 
	margin:0 15px 0 0;
}

.gridBtn {
	height:22px;
	line-height: 14px;
}

.schLine {
	margin: 0px 15px;
}

/* 2021.01.08 */
.k_cg1{padding:9px 10px 5px 15px;margin-bottom:5px;}
.k_cg1 .k_bg1{width:250px;}
.k_cg1 .k_sg1{width:calc(100% - 250px);}
.k_cg1 .k_sg1 .inlineBlock{float:left;}
</style>
				
<div class="grid-block team-ms" style="margin:0 15px 0 0">
	<div class="gridContents" style="" id="grid-parent">
		<div class="k_cg1">
			<div class="gridBtnBlock k_bg1">
				<button type="button" class="AXButton Blue _transBtn_" onclick="trans();">
					<span><spring:message code='label.WAN013.trans'/></span>
				</button>
				
				<button type="button" class="xlsDown _excelDownBtn_" data-target="down">
					<span>CIGMA 수주 DATA 다운로드</span>
				</button>					
			</div>
					
			<div class="k_sg1">					
				<div class="inlineBlock">
			
					<input type="hidden" id="getUserId" name="getUserId" value="${userId}"/>
					
					<div class="board-bList-wrap log_board">
						<div class="list-top">
							<div class="fl">
								<label class="k_l1"><spring:message code='label.WAN009.chkdt'/></label>
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
				</div>
						
				<div class="inlineBlock schLine" style="padding-top:7px;display:none;">	
					<input type="radio" name="getSelchk" class="getSelchk" style="width : 30px;" value="P6" checked /><spring:message code='label.WAN008.p6'/>
					<input type="radio" name="getSelchk" class="getSelchk" style="width : 30px;" value="P7" /><spring:message code='label.WAN008.p7'/>
				</div>
				
				<div class="inlineBlock schLine" >	
					<label class="k_l1"><spring:message code='label.WAN002.comps2'/></label>
					<select name="getComps" id="getComps" class="getComps">
					
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
				</div>
			
				<div class="inlineBlock" >	
					<label class="k_l1"><spring:message code='label.WAN002.pyvnd2'/></label>
					<input type="text" class="AXInput getPyvnd" style="width : 50px;" name="getPyvnd" id="getPyvnd" maxlength="8"
						onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)' onBlur="getCustSch();">
					<input type="text" class="AXInput getCusnm" style="width : 180px;" name="getCusnm" id="getCusnm" placeholder="<spring:message code='WAN-I0-0002'/>" title="<spring:message code='WAN-I0-0002'/>" disabled readOnly>
					<button type="button" onclick="" class="AXButton Normal _custBtn_">
						<spring:message code="label.select" />
					</button>				
				</div>
			</div>
		</div>

		<div class="cb pt5 ">

			<table class="pd-s-table first-tbl">
			<col style="width:100px" />
			<col style="calc( 50% - 200px )"/>
			<col style="width:100px" />
			<col style="calc( 50% - 200px )"/>
				<tr>
					<th>
						<spring:message code='label.WAN013.cigmaDate'/>
					</th>
					<td>
						<input type="text" name="cigmaDate" id="cigmaDate" style="width:120px;" title="" value="${cigmaDate}" readonly disabled />
					</td>
					<th>
						<spring:message code='label.WAN013.systemDate'/>
					</th>
					<td>
						<input type="text" name="systemDate" id="systemDate" style="width:120px" title="" value="${today}" readonly disabled />
					</td>
				</tr>
			</table>
		</div>
	
		<div data-ax5grid="down-grid" data-ax5grid-config="{}" style="height: 0%; display: none;">
        </div>
	</div>
</div>
