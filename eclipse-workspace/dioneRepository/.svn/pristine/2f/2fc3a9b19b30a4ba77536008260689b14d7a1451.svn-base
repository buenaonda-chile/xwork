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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/sal/CustOrderTypeMst.js?ver"></script>

<script  type="text/javascript">

//사업부를 선택해주세요.
var LN_SELECT_COMPS = "<spring:message code='WAN-I0-0001'/>";
//업체를 선택해주세요.
var LN_SELECT_PYVND = "<spring:message code='WAN-I0-0002'/>";
//[확인] 업체코드 확인바랍니다.
var LN_IO_CHK1 = "<spring:message code='WAN-I0-Chk1'/>";

//[확인] 시작일자가 종료일자보다 클 수는 없습니다.
var LN_SELECT_EFFCK = "<spring:message code='label.WAN001.effChk'/>";

var LN_CHK_MCRCD = "<spring:message code='label.WAN001.mcrcd'/>";
var LN_CHK_SEQCD = "<spring:message code='label.WAN001.seqcd'/>";
var LN_CHK_SEQNO = "<spring:message code='label.WAN001.seqno'/>";

var LN_CHK1 = "<spring:message code='label.WAN001.check1'/>";
var LN_CHK2 = "<spring:message code='label.WAN001.check2'/>";
var LN_CHK3 = "<spring:message code='label.WAN001.check3'/>";
var LN_CHK4 = "<spring:message code='label.WAN001.check4'/>";
var LN_CHK5 = "<spring:message code='label.WAN002.Chk4'/>";
var LN_CHK6 = "<spring:message code='label.WAN002.Chk6'/>";
var LN_DEL_CHK1 = "<spring:message code='label.WAN000.delChk1'/>";
var LN_INS_CHK1 = "<spring:message code='label.WAN000.insChk1'/>";
var LN_INS_CHK2 = "<spring:message code='label.WAN001.insChk2'/>";
var LN_UPD_CHK1 = "<spring:message code='label.WAN001.updChk1'/>";
var LN_UPD_CHK2 = "<spring:message code='label.WAN001.updChk2'/>";

$(function(){
	grid.initView({
		pspno:{label:"<spring:message code='label.WAN001.pspno'/>"},
		itdsc:{label:"<spring:message code='label.WAN001.itdsc'/>"},
		carnm:{label:"<spring:message code='label.WAN001.carnm'/>"},
		mkpno:{label:"<spring:message code='label.WAN001.mkpno'/>"},
		mcrcd:{label:"<spring:message code='label.WAN001.mcrcd'/>"},
		seqcd:{label:"<spring:message code='label.WAN001.seqcd'/>"},
		seqno:{label:"<spring:message code='label.WAN001.seqno'/>"},
		efffr:{label:"<spring:message code='label.WAN001.efffr'/>"},
		effto:{label:"<spring:message code='label.WAN001.effto'/>"},
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
</style>

<div class="grid-block team-ms">
	<div style="margin: 0px 15px 0px 0px;">
		<div class="gridContents" style="" id="grid-parent">
			<div class="gridBtnBlock">
				<button type="button" class="AXButton Black" onclick="search();">
					<i class="axi axi-ion-android-search"></i>
					<spring:message code='label.search'/>
				</button>
	
				<button type="button" class="AXButton Blue _saveBtn_" style="" onclick="">
					<spring:message code="label.save" /><!-- ìì  -->
				</button>
				<button type="button" class="AXButton Normal _delBtn_" style="" onclick="return deleteSeq()">
					<spring:message code="label.delete" /><!-- ì­ì  -->
				</button>
	
				<button type="button" class="xlsDown _excelBtn_">
					<span><spring:message code='label.excelDown' /></span>
				</button>
			</div>
					
			<div class="gridBtnBlock">
	
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
	
				<div class="inlineBlock schLine" >	
					<spring:message code='label.WAN002.pyvnd2'/>
					<input type="text" class="AXInput getPyvnd" style="width : 60px;" name="getPyvnd" id="getPyvnd" maxlength="8"
						onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)' onBlur="getCustSch();">
					<input type="text" class="AXInput getCusnm" style="width : 180px;" name="getCusnm" id="getCusnm" placeholder="<spring:message code='WAN-I0-0002'/>" title="<spring:message code='WAN-I0-0002'/>" disabled readOnly>
					<button type="button" onclick="" class="AXButton Normal _custBtn_">
						<spring:message code="label.select" />
					</button>				
				</div>
	
				<div class="inlineBlock schLine">	
					<spring:message code='label.WAN001.pspno'/>
					<input type="text" class="AXInput getPspno" style="width : 130px;" name="getPspno" id="getPspno" onBlur="getItemSch();" maxlength="15"><spring:message code='label.WAN005.after'/>
					<input type="text" class="AXInput getItdsc" style="width : 180px;" name="getItdsc" id="getItdsc" placeholder="<spring:message code='WAN-I0-0005'/>" title="<spring:message code='WAN-I0-0005'/>" disabled readOnly>
					<button type="button" onclick="" class="AXButton Normal _itemBtn_">
						<spring:message code="label.select" />
					</button>				
				</div>
	
	          	<input type="radio" class="getPchk" style="width : 30px;" id="getPchk" name="getPchk"  value="1" checked /><spring:message code='label.modify'/>
	          	<input type="radio" class="getPchk" style="width : 30px;" id="getPchk" name="getPchk"  value="2" /><spring:message code='label.register'/>
	
			</div>
	
			<input type="hidden" id="setComps" name="setComps" value=""/>
			<input type="hidden" id="setPyvnd" name="setPyvnd" value=""/>
			<input type="hidden" id="setPspno" name="setPspno" value=""/>
			<input type="hidden" id="setMcrcd" name="setMcrcd" value=""/>
			<input type="hidden" id="setSeqno" name="setSeqno" value=""/>
			<input type="hidden" id="setSeqcd" name="setSeqcd" value=""/>
			<input type="hidden" id="setEfffr" name="setEfffr" value=""/>
			<input type="hidden" id="setEffto" name="setEffto" value=""/>
			
			<input type="hidden" id="setOldSeqno" name="setOldSeqno" value=""/>
			<input type="hidden" id="setOldSeqcd" name="setOldSeqcd" value=""/>
			<input type="hidden" id="setOldMcrcd" name="setOldMcrcd" value=""/>
			<input type="hidden" id="setOldEfffr" name="setOldEfffr" value=""/>
			<input type="hidden" id="setOldEffto" name="setOldEffto" value=""/>
	
		    <div class="pt5 cmcGrid" data-ax5grid="grid" data-ax5grid-config="{showLineNumber: true}"></div>
		       
		</div>
	</div>
</div>
