<%--
 * PROJECTÃ¯Â¼Â
 *
 * [KR] 
 * 
 * yoonjae.jeong
 *
 * Copyright (c) 2017 DENSO CORPORATION. All rights reserved.
 *
--%>
<!-- [EN] Contents area -->
<!-- [JP] Ã£ÂÂ³Ã£ÂÂ³Ã£ÂÂÃ£ÂÂ³Ã£ÂÂÃ£ÂÂ¨Ã£ÂÂªÃ£ÂÂ¢ -->
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

//사업부 필수체크 메시지
var LN_SELECT_COMPS = "<spring:message code='WAN-I0-0001'/>";
//처리일자 필수체크 메시지
var LN_SELECT_PLNDT = "<spring:message code='WAN-I0-0016'/>";
//업체 필수체크 메시지
var LN_SELECT_PYVND = "<spring:message code='WAN-I0-0002'/>";
//업체코드확인바랍니다 메시지
var LN_IO_CHK1 = "<spring:message code='WAN-I0-Chk1'/>";


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

.third-grid-block {
	min-width: 420px;
	line-height: 14px;
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


.schLine {
	margin: 0px 15px 0px 0px;
}


.wj-flexgrid {
	max-height: 400px;
	height: auto;
	width: 100%;
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
						<spring:message code='label.search'/><!-- 조회 -->
					</button>
		
				</div>
		
				<div class="gridBtnBlock k_sg1">
					<!-- 사업부 -->
					<input type="hidden" id="getCompany" name="getCompany" value="${company}"/>
					
					<label class="k_l1"><spring:message code='label.WAN019.comps'/></label>
					<select name="getComps" id="getComps" class="getComps schLine">
						<option value="">전체</option>
						<option value="E1">마산</option>
						<option value="C1">창원</option>
						<option value="S1">화성</option>

					</select>
					
					<!-- 처리일자 -->
					<label class="k_l1"><spring:message code='label.WAN023.plndt'/></label>
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
					
					<!-- 업체 -->
					<div class="inlineBlock schLine">
						<label class="k_l1"><spring:message code='label.WAN019.cusnm'/></label>	
						<input type="text" class="AXInput getPyvnd" style="width : 60px;" name="getPyvnd" id="getPyvnd"  maxlength="8"
							onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)' onBlur="getCustSch('input', this.value);">
						<button type="button" onclick="" class="AXButton Normal _custBtn_">
							<spring:message code="label.select" />
						</button>
						<input type="text" class="AXInput getCusnm" style="width : 180px;" name="getCusnm" id="getCusnm" placeholder="<spring:message code='WAN-I0-0002'/>" title="<spring:message code='WAN-I0-0002'/>" disabled readOnly>
					</div>
					
				</div>
			</div>
			
			<div class="cb pt5 ">
				
			</div>
	    
		     <div class="gridContents" style="position: relative; height: 650px;">
				<div id="wijmoGrid" ></div>
				<a href="javascript:zoomIn($('#wijmoGrid'),flexGrid);">확대</a>
				<a href="javascript:zoomOut($('#wijmoGrid'),flexGrid);">축소</a>
		    </div>
			
 		</div>
	</div>
</div>


<script>

	$.getScript('/js/sal/OrderTransferMng.js');
	
</script>
   


