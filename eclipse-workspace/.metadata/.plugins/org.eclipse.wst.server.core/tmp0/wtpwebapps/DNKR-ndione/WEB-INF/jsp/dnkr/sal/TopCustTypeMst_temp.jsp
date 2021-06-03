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

<script type="text/javascript" src="${pageContext.request.contextPath}/js/sal/TopCustTypeMst.js?ver"></script>


<script  type="text/javascript">

//사업부를 선택해주세요.
var LN_SELECT_COMPS = "<spring:message code='WAN-I0-0001'/>";
//업체를 선택해주세요.
var LN_SELECT_PYVND = "<spring:message code='WAN-I0-0002'/>";
//대표차종을 입력해주세요.
var LN_SELECT_CARCD = "<spring:message code='WAN-I0-0003'/>";
//대표규격을 입력해 주세요.
var LN_SELECT_BDYCD = "<spring:message code='WAN-I0-0008'/>";
//[확인] 업체코드 확인바랍니다.
var LN_IO_CHK1 = "<spring:message code='WAN-I0-Chk1'/>";

var LN_CHK_COMPS2 = "<spring:message code='label.WAN002.comps2'/>";
var LN_CHK_PYVND2 = "<spring:message code='label.WAN002.pyvnd2'/>";
var LN_CHK_CARCD2 = "<spring:message code='label.WAN002.carcd2'/>";
var LN_CHK_BDYCD2 = "<spring:message code='label.WAN002.bdycd2'/>";

var LN_DEL_CHK1 = "<spring:message code='label.WAN000.delChk1'/>";
var LN_INS_CHK1 = "<spring:message code='label.WAN000.insChk1'/>";
var LN_UPD_CHK1 = "<spring:message code='label.WAN000.updChk1'/>";
var LN_UPD_CHK2 = "<spring:message code='label.WAN000.updChk2'/>";

var LN_CHK1 = "<spring:message code='label.WAN002.Chk1'/>";
var LN_CHK2 = "<spring:message code='label.WAN002.Chk2'/>";
var LN_CHK3 = "<spring:message code='label.WAN002.Chk3'/>";
var LN_CHK4 = "<spring:message code='label.WAN002.Chk4'/>";
var LN_CHK5 = "<spring:message code='label.WAN002.Chk5'/>";

$(function(){
	grid.initView({
		comps2:{label:"<spring:message code='label.WAN002.comps2'/>"},
		pyvnd2:{label:"<spring:message code='label.WAN002.pyvnd2'/>"},
		carcd2:{label:"<spring:message code='label.WAN002.carcd2'/>"},
		bdycd2:{label:"<spring:message code='label.WAN002.bdycd2'/>"},
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


/* 2021.01.08 */
.k_cg1{padding:14px 10px 0 15px;}
.k_cg1 .k_bg1{width:340px;}
.k_cg1 .k_sg1{width:calc(100% - 340px);}

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
		
					<div class="inlineBlock">
						<button type="button" class="AXButton Normal" style="" onclick="return updateCar()">
							<spring:message code="label.modify" /><!-- ìì  -->
						</button>
						<button type="button" class="AXButton Normal" style="" onclick="return deleteCar()">
							<spring:message code="label.delete" /><!-- ì­ì  -->
						</button>
					</div>
					
					<div class="inlineBlock">
						<button type="button" class="AXButton Red _addBtn_" style="" onclick = "">
							<i><!--  class="axi axi-ion-person-add"> --></i>
							<spring:message code='label.register'/>
						</button>
					</div>
					<div class="displayNone">
						<button type="button" class="AXButton Blue _saveBtn_" onclick = "">
							<spring:message code='label.save'/>	<!-- ì ì¥ -->			
						</button>
						<button type="button" class="AXButton Normal _closeBtn_" style="" onclick="">
							<i><!--  class="axi axi-ion-person-add"> --></i> 
							<spring:message code='label.close'/>	<!-- ë«ê¸° -->
						</button>
					</div>
					
					<button type="button" class="xlsDown _excelBtn_">
						<span><spring:message code='label.excelDown' /></span>
					</button>
				</div>
					
				<div class="gridBtnBlock k_sg1">
					
					<input type="hidden" id="getCompany" name="getCompany" value="${company}"/>
					
					<label class="k_l1"><spring:message code='label.WAN002.comps2'/></label>
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
					
					<div class="inlineBlock schLine">
						<label class="k_l1"><spring:message code='label.WAN002.pyvnd2'/></label>	
						<input type="text" class="AXInput getPyvnd" style="width : 60px;" name="getPyvnd" id="getPyvnd"  maxlength="8"
							onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)' onBlur="getCustSch('input', this.value);">
						<button type="button" onclick="" class="AXButton Normal _custBtn_">
							<spring:message code="label.select" />
						</button>
						<input type="text" class="AXInput getCusnm" style="width : 180px;" name="getCusnm" id="getCusnm" placeholder="<spring:message code='WAN-I0-0002'/>" title="<spring:message code='WAN-I0-0002'/>" disabled readOnly>
					</div>
					
					<div class="inlineBlock schLine">
						<label class="k_l1"><spring:message code='label.WAN002.carcd2'/></label>
						<input type="text" class="AXInput getCarcd" style="width : 50px;" name="getCarcd" id="getCarcd"  maxlength="3" onBlur="getCarSch('input', this.value);">
						<input type="text" class="AXInput getCarnm" style="width : 180px;" name="getCarnm" id="getCarnm" placeholder="<spring:message code='WAN-I0-0003'/>" title="<spring:message code='WAN-I0-0003'/>" disabled readOnly>
					</div>
					
					<div class="inlineBlock">
						<label class="k_l1"><spring:message code='label.WAN002.bdycd2'/></label>
						<input type="text" class="AXInput getBdycd" style="width : 50px;" name="getBdycd" id="getBdycd" maxlength="3" onBlur="getBdySch('input', this.value);">
						<input type="text" class="AXInput getBdynm" style="width : 180px;" name="getBdynm" id="getBdynm" placeholder="<spring:message code='WAN-I0-0008'/>" title="<spring:message code='WAN-I0-0008'/>" disabled readOnly>
					</div>
					
				</div>
				
			</div>
			
			<div class="cb pt5">
	
				<input type="hidden" id="setComps1" name="setComps1" value=""/>
				<input type="hidden" id="setPyvnd1" name="setPyvnd1" value=""/>
				<input type="hidden" id="setCarcd1" name="setCarcd1" value=""/>
				<input type="hidden" id="setBdycd1" name="setBdycd1" value=""/>
				<input type="hidden" id="setComps2" name="setComps2" value=""/>
				<input type="hidden" id="setPyvnd2" name="setPyvnd2" value=""/>
				<input type="hidden" id="setCarcd2" name="setCarcd2" value=""/>
				<input type="hidden" id="setBdycd2" name="setBdycd2" value=""/>
				
				<input type="hidden" id="setOldComps2" name="setOldComps2" value=""/>
				<input type="hidden" id="setOldPyvnd2" name="setOldPyvnd2" value=""/>
				<input type="hidden" id="setOldCarcd2" name="setOldCarcd2" value=""/>
				<input type="hidden" id="setOldBdycd2" name="setOldBdycd2" value=""/>
	
			</div>
			
			<div calss="fr" style="padding-top:5px;">  
				<c:if test="${company eq 'E1'}"><spring:message code='label.WAN002.Chk1'/></c:if>
				<c:if test="${company ne 'E1'}"><spring:message code='label.WAN002.Chk2'/></c:if>
				<b>(접속 사용자 사업부 : ${company})</b>
			</div>
			  
		    <div class="pt5 cmcGrid" data-ax5grid="grid" data-ax5grid-config="{showLineNumber: true}"></div>
		    
		    
		        
		    
		</div>
	</div>
</div>