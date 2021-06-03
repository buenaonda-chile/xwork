<%--
 * PROJECTÃ¯Â¼Â
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

<link rel="stylesheet" media="all" href="/css/board.css"/>
<link rel="stylesheet" media="all" href="/css/content.css"/>

<!-- 그리드 css -->
<link rel="stylesheet" href="/wijmo/styles/wijmo.css"/>
 
<script type="text/javascript" src="/wijmo/controls/wijmo.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.grid.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.input.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.xlsx.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.grid.xlsx.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.grid.filter.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/cultures/wijmo.culture.ko.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/jszip.min.js"></script>

<script  type="text/javascript">

//위즈모 LicenseKey 설정
wijmo.setLicenseKey('${wijmoLicenseKey}');

//사업부를 선택해주세요.
var LN_SELECT_COMPS = "<spring:message code='WAN-I0-0001'/>";
//기준일자를 선택해 주세요.
var LN_SELECT_CHGDT = "<spring:message code='WAN-I0-0011'/>";
//구분을 선택해 주세요.
var LN_SELECT_TYPCD = "<spring:message code='WAN-I0-0017'/>";
//업체를 선택해 주세요.
var LN_SELECT_PYVND = "<spring:message code='WAN-I0-0002'/>";

var LB_COMPS = "<spring:message code='label.WAN025.comps'/>"; //사업부
var LB_TYPCNM = "<spring:message code='label.WAN025.typcnm'/>"; //구분
var LB_PYVND = "<spring:message code='label.WAN025.pyvnd'/>"; //업체
var LB_CUSNM = "<spring:message code='label.WAN025.cusnm'/>"; //업체명
var LB_PSPNO = "<spring:message code='label.WAN025.pspno'/>"; //품번
var LB_PLNDT = "<spring:message code='label.WAN025.plndt'/>"; //계획일자
var LB_PLNCD = "<spring:message code='label.WAN025.plncd'/>"; //계획구분
var LB_CHGDT = "<spring:message code='label.WAN025.chgdt'/>"; //최종갱신기간

//[확인] 업체코드 확인바랍니다.
var LN_IO_CHK1 = "<spring:message code='WAN-I0-Chk1'/>";
//품번 확인바랍니다.
var LN_IO_CHK2 = "<spring:message code='WAN_I0_Chk2'/>";

var LN_CHK_BASQY = "<spring:message code='label.WAN014.basqy'/>";

var LN_DEL_CHK1 = "<spring:message code='label.WAN000.delChk1'/>";
var LN_UPD_CHK1 = "<spring:message code='label.WAN000.updChk1'/>";
var LN_UPD_CHK2 = "<spring:message code='label.WAN000.updChk2'/>";

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
	min-width:1100px; 
	display:inline-block; 
	margin:0 5px;
	width: 100%;
}

.schLine {
	margin: 0px 15px 0px 0px;
}

.wj-flexgrid {
	max-height: 620px;
	height: auto;
	width: 100%;
	/*font-size: 11pt;*/
	/*font-size:10px;*/
}

.wj-header {
 	background: white;
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
						<button type="button" class="AXButton Normal" style="" onclick="return update()">
							<spring:message code="label.save" /><!-- 저장 -->
						</button>
						<button type="button" class="AXButton Normal _delBtn" style="" onclick="">
							<spring:message code="label.delete" /><!-- 삭제 -->
						</button>
					</div>
					<%-- 
					<div class="inlineBlock">
						<button type="button" class="AXButton Red _addBtn_" style="" onclick = "">
							<i><!--  class="axi axi-ion-person-add"> --></i>
							<spring:message code='label.register'/>
						</button>
					</div>
					 --%>
					<div class="displayNone">
						<button type="button" class="AXButton Blue _saveBtn_" onclick = "">
							<spring:message code='label.save'/>	<!-- 저장 -->			
						</button>
						<button type="button" class="AXButton Normal _closeBtn_" style="" onclick="">
							<i><!--  class="axi axi-ion-person-add"> --></i> 
							<spring:message code='label.close'/>	<!-- 닫기 -->
						</button>
					</div>
					
					<button type="button" class="xlsDown" onclick="downloadExcel();">
						<span><spring:message code='label.excelDown' /></span><!-- 엑셀다운로드 -->
					</button>
				</div>
					
				<div class="gridBtnBlock k_sg1">
					
					<!-- <input type="hidden" id="getCompany" name="getCompany" value="${company}"/> -->
					
					<label class="k_l1"><spring:message code='label.WAN002.comps2'/></label>
					<select name="getLocCode" id="getLocCode" class="getLocCode schLine">
					<!-- 
						<option value="E1">마산</option>
						<option value="C1">창원</option>
						<option value="S1">화성</option>
					 -->
						<c:if test="${fn:length(locList) > 0}">
							<c:forEach var="locDomain" items="${locList}" varStatus="status">
							<option value="${locDomain.relationCode}"
							<c:if test="${locDomain.relationCode eq empLoc}">
							selected
							</c:if>
							><c:out value="${locDomain.relationName}"/></option>
							</c:forEach>
						</c:if>

					</select>
					<input type="text" class="AXInput getComps" name="getComps" id="getComps" style="width:50px;" hidden="true"/>
					
					<label class="k_l1"><spring:message code='label.WAN012.chldt'/></label>
					<div class="dropdown schLine">						
						<span class="calendar_icon vcen2"></span>
						<input type="text" class="dropbtn calendar_input getChgdt" name="getChgdt" id="getChgdt"/>
						<div class="dropdown-menu" role="menu"  id="chgdt_calendar" style="width:250px;
						           border:1px solid #ccc;
						           border-radius: 5px;
						           padding: 5px;
						           overflow: hidden;" >
						</div>
					</div>
				
					
					<div class="inlineBlock schLine">
						<label class="k_l1"><spring:message code='label.type'/></label>
						<select name="getTypcd" id="getTypcd" class="getTypcd schLine">
							<option value="">전체</option>
							<option value="AA">서열</option>
							<option value="BB">비서열</option>
							<option value="CC">확정오더</option>
					</select>
					</div>
					
					<div class="inlineBlock schLine">
						<label class="k_l1"><spring:message code='label.WAN002.pyvnd2'/></label>	
						<input type="text" class="AXInput getPyvnd" style="width : 60px;" name="getPyvnd" id="getPyvnd"  maxlength="8"
							onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)' onBlur="getCustSch('input', this.value);">
						<input type="text" class="AXInput getCusnm" style="width : 180px;" name="getCusnm" id="getCusnm" placeholder="<spring:message code='WAN-I0-0002'/>" title="<spring:message code='WAN-I0-0002'/>" disabled readOnly>
						<button type="button" onclick="" class="AXButton Normal _custBtn_">
							<spring:message code="label.select" />
						</button>						
					</div>
					
					<div class="inlineBlock">
						<label class="k_l1"><spring:message code='label.pspno'/></label>
						<input type="text" class="AXInput getPspno" style="width : 150px;" name="getPspno" id="getPspno" maxlength="15" onBlur="getItemSch();">
					</div>
					
					<label class="k_l1"><spring:message code='label.WAN014.plndt'/></label>
					<div class="dropdown schLine">						
						<span class="calendar_icon vcen2"></span>
						<input type="text" class="dropbtn calendar_input getPlndt" name="getPlndt" id="getPlndt"/>
						<div class="dropdown-menu" role="menu"  id="plndt_calendar" style="width:250px;
						           border:1px solid #ccc;
						           border-radius: 5px;
						           padding: 5px;
						           overflow: hidden;" >
						</div>
					</div>
				</div>
				
			</div>
			
			<div class="cb pt5">
			</div>
			
		     <div class="grid-container"  style="position: relative; height: 650px;">
				<div id="wijmoGrid" ></div>
				<a href="javascript:zoomIn($('#wijmoGrid'),flexGrid);">확대</a>
				<a href="javascript:zoomOut($('#wijmoGrid'),flexGrid);">축소</a>
		    </div>
		</div>
	</div>
</div>


<script>

	//getscript로  처리하면 timestamp기능이 뒤에 붙어서 캐쉬사용없이 계속 로딩함. -수정사항이 바로 반영됨-	
	$.getScript('/js/sal/WAN025CustOrderDataMng.js');
	
	//그리드 사용하기 위한 공통 script
	// 그리드 로딩이 가끔씩 빠져서 다시 위로 선언함.
	// wijmo 공통선언은 최상위에서 하고 실사용 js파일은 아래에 정의해야.
	/*		
	$.getScript('/wijmo/controls/wijmo.min.js').done(function() {
			
		$.getScript('/wijmo/controls/wijmo.grid.min.js'),					//grid
		$.getScript('/wijmo/controls/wijmo.input.min.js'),					//grid 필터기능에서 input박스가 들어감으로 필요함.
		$.getScript('/wijmo/controls/wijmo.xlsx.min.js'),					//엑셀변환
		$.getScript('/wijmo/controls/wijmo.grid.xlsx.min.js'),				//그리드 엑셀변환
		$.getScript('/wijmo/controls/wijmo.grid.filter.min.js'),			//필터기능
		$.getScript('/wijmo/controls/cultures/wijmo.culture.ko.min.js'),	//한국어
		$.getScript('/wijmo/controls/jszip.min.js'),						//엑셀파일 다운로드시 필요
		$.getScript('${pageContext.request.contextPath}/js/sal/TopCustTypeMst.js?ver=1.1'),
		$.Deferred(function( deferred ){
		})
				
	});
	*/
	
</script>