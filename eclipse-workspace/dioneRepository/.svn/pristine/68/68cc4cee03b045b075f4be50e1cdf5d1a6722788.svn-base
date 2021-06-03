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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/sal/OrderDayShipQtyCheckList.js?ver"></script>

<script  type="text/javascript">

//사업부를 선택해주세요.
var LN_SELECT_COMPS = "<spring:message code='WAN-I0-0001'/>";
//기준일자를 입력해주세요.
var LN_SELECT_DUMCB = "<spring:message code='WAN-I0-0011'/>";
//[확인] 업체코드 확인바랍니다.
var LN_IO_CHK1 = "<spring:message code='WAN-I0-Chk1'/>";

$(function(){
	grid = gridCheck;
	gridCheckinit("");
}); 

function gridCheckinit(titleList){
	var makmk0Label = "";
	var makmk1Label = "";
	var makmk2Label = "";
	var makmk3Label = "";
	var makmk4Label = "";
	var makmk5Label = "";
	var makmk6Label = "";

	var makdt0Label = "";
	var makdt1Label = "";
	var makdt2Label = "";
	var makdt3Label = "";
	var makdt4Label = "";
	var makdt5Label = "";
	var makdt6Label = "";	
	
	if(titleList != ""){
		if(titleList.length >= 1) makmk0Label = titleList[0].makmk + " " + titleList[0].clhcd;
		if(titleList.length >= 2) makmk1Label = titleList[1].makmk + " " + titleList[1].clhcd;
		if(titleList.length >= 3) makmk2Label = titleList[2].makmk + " " + titleList[2].clhcd;
		if(titleList.length >= 4) makmk3Label = titleList[3].makmk + " " + titleList[3].clhcd;
		if(titleList.length >= 5) makmk4Label = titleList[4].makmk + " " + titleList[4].clhcd;
		if(titleList.length >= 6) makmk5Label = titleList[5].makmk + " " + titleList[5].clhcd;
		if(titleList.length >= 7) makmk6Label = titleList[6].makmk + " " + titleList[6].clhcd;
		
		if(titleList.length >= 1) makdt0Label = titleList[0].makdt.substr(4,2) + "/" + titleList[0].makdt.substr(6,2);
		if(titleList.length >= 2) makdt1Label = titleList[1].makdt.substr(4,2) + "/" + titleList[1].makdt.substr(6,2);
		if(titleList.length >= 3) makdt2Label = titleList[2].makdt.substr(4,2) + "/" + titleList[2].makdt.substr(6,2);
		if(titleList.length >= 4) makdt3Label = titleList[3].makdt.substr(4,2) + "/" + titleList[3].makdt.substr(6,2);
		if(titleList.length >= 5) makdt4Label = titleList[4].makdt.substr(4,2) + "/" + titleList[4].makdt.substr(6,2);
		if(titleList.length >= 6) makdt5Label = titleList[5].makdt.substr(4,2) + "/" + titleList[5].makdt.substr(6,2);
		if(titleList.length >= 7) makdt6Label = titleList[6].makdt.substr(4,2) + "/" + titleList[6].makdt.substr(6,2);
	}
	 
	grid.initView({
		chldt:{label:"기준일자"},
		
		cusnm:{label:"업체명"},
		pyvnd:{label:"업체코드"},
		
		faccd:{label:"FC"},
		seycd:{label:"서열"},	
		mkcar:{label:"차종"},
		
		//"품번"
		mkpno:{label:"MK품번"},
		pspno:{label:"DNPE품번"},
		//--""
		itmnm:{label:"품명"},
		
		//"재고현황"
		makqy:{label:"MK"},
		pspqy:{label:"DNPE"},
		
		//"계획대비 출하현황"
		suyqy:{label:"수용"},
		//"1차"
		cllq1:{label:"1차"},
		cllbox1:{label:"부족"}, //--BOX		
		//--""
		clpq1:{label:"1차"},
		boxq1:{label:"요구"},
		//--""
		//"2차"
		cllq2:{label:"2차"},
		cllbox2:{label:"부족"}, //--BOX		
		//--""
		clpq2:{label:"2차"},
	    boxq2:{label:"요구"},
	    
		junqy:{label:"출하량"},
		notqy:{label:"미출하"},
		
		//"생산계획 대비 부족량"
		trimd:{label:"실적"},
		pbsqy:{label:"PBS"},
		
		datq0:{label:makmk0Label},	//1
		dapq0:{label:makdt0Label},	//2
		sujq0:{label:""},
		
		dat11:{label:makmk1Label}, 	//3
		dap11:{label:makdt1Label},	//4
		//--"8T" 
		dat12:{label:makmk1Label},	//5
		dap12:{label:makdt1Label},	//6
		sujq1:{label:"12T"},
		
		dat21:{label:makmk2Label},	//7
		dap21:{label:makdt2Label},	//8
		//--"DAY"
		dat22:{label:makmk2Label},	//9
		dap22:{label:makdt2Label},	//10
		sujq2:{label:"NIGHT"},
				
		dat31:{label:makmk3Label},	//11
		dap31:{label:makdt3Label},	//12
		//--"DAY"
		dat32:{label:makmk3Label},	//13
		dap32:{label:makdt3Label},	//14
		sujq3:{label:"NIGHT"},
		
		dat41:{label:makmk4Label},	//15
		dap41:{label:makdt4Label},	//16
		//--"DAY"
		dat42:{label:makmk4Label},	//17
		dap42:{label:makdt4Label},	//18
		sujq4:{label:"NIGHT"},
				
		dat51:{label:makmk5Label},	//19
		dap51:{label:makdt5Label},	//20
		//--"DAY"
		dat52:{label:makmk5Label},	//21
		dap52:{label:makdt5Label},	//22
		sujq5:{label:"NIGHT"},
				
		dat61:{label:makmk6Label},	//23
		dap61:{label:makdt6Label},	//24
		//--"DAY"
		dat62:{label:makmk6Label},	//25
		dap62:{label:makdt6Label},	//26
		sujq6:{label:"NIGHT"},

		datqy:{label:"TOTAL"},
		//--""
		sujqy:{label:""},
		
		plqty:{label:"판매계획"},
		slqty:{label:"판매실적"},
		dalpr:{label:"달성율(%)"},
	});//.setData();	
}

function gridErrorinit(titleList){
	var q0tLabel = "";
	var q1tLabel = "";
	var q2tLabel = "";
	var q3tLabel = "";
	var q4tLabel = "";
	var q5tLabel = "";
	var q6tLabel = "";
	var q7tLabel = "";
	var q8tLabel = "";
	var q9tLabel = "";
	var qatLabel = "";
	var qbtLabel = "";
	var qctLabel = "";
	
	if(titleList != ""){
		if(titleList.length >= 1) q0tLabel = titleList[0].prcdt.substr(4,2) + "/" + titleList[0].prcdt.substr(6,2);
		if(titleList.length >= 2) q1tLabel = titleList[1].prcdt.substr(4,2) + "/" + titleList[1].prcdt.substr(6,2);
		if(titleList.length >= 3) q2tLabel = titleList[2].prcdt.substr(4,2) + "/" + titleList[2].prcdt.substr(6,2);
		if(titleList.length >= 4) q3tLabel = titleList[3].prcdt.substr(4,2) + "/" + titleList[3].prcdt.substr(6,2);
		if(titleList.length >= 5) q4tLabel = titleList[4].prcdt.substr(4,2) + "/" + titleList[4].prcdt.substr(6,2);
		if(titleList.length >= 6) q5tLabel = titleList[5].prcdt.substr(4,2) + "/" + titleList[5].prcdt.substr(6,2);
		if(titleList.length >= 7) q6tLabel = titleList[6].prcdt.substr(4,2) + "/" + titleList[6].prcdt.substr(6,2);
		if(titleList.length >= 8) q7tLabel = titleList[7].prcdt.substr(4,2) + "/" + titleList[7].prcdt.substr(6,2);
		if(titleList.length >= 9) q8tLabel = titleList[8].prcdt.substr(4,2) + "/" + titleList[8].prcdt.substr(6,2);
		if(titleList.length >= 10) q9tLabel = titleList[9].prcdt.substr(4,2) + "/" + titleList[9].prcdt.substr(6,2);
		if(titleList.length >= 11) qatLabel = titleList[10].prcdt.substr(4,2) + "/" + titleList[10].prcdt.substr(6,2);
		if(titleList.length >= 12) qbtLabel = titleList[11].prcdt.substr(4,2) + "/" + titleList[11].prcdt.substr(6,2);
		if(titleList.length >= 13) qctLabel = titleList[12].prcdt.substr(4,2) + "/" + titleList[12].prcdt.substr(6,2);	
	}

	grid.initView({
		chldt:{label:"기준일자"},
		cusnm:{label:"업체명"},
		pyvnd:{label:"업체코드"},
		faccd:{label:"FC"},
		mkcar:{label:"CAR"},
		seycd:{label:"CODE"},
		mkpno:{label:"업체품번"},
		pspno:{label:"풍성품번"},		
		//MK재고
		//PS재고
		trimdt:{label:"TRM/I"},
		pbsqyt:{label:"PBS"},
		datq0t:{label:q0tLabel},
		datq1t:{label:q1tLabel},
		datq2t:{label:q2tLabel},
		datq3t:{label:q3tLabel},
		datq4t:{label:q4tLabel},
		datq5t:{label:q5tLabel},
		datq6t:{label:q6tLabel},
		datq7t:{label:q7tLabel},
		datq8t:{label:q8tLabel},
		datq9t:{label:q9tLabel},
		datqat:{label:qatLabel},
		datqbt:{label:qbtLabel},
		datqct:{label:qctLabel},
		errcd:{label:"ERR_CD"},
		errnm:{label:"ERR_NM"},
	});//.setData();	
}

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


/*[data-ax5grid-container="root"] -> height: 650px;*/
/* footSum 추가에 따른 높이 지정. */
[data-ax5grid-panel="aside-body"] {
	height: 430px !important;
}
[data-ax5grid-panel="body"] {
	height: 430px !important;
}
[data-ax5grid-panel="bottom-aside-body"] {
	height: 86px !important;
	top: auto !important;
	bottom: 0px;
}
[data-ax5grid-panel="bottom-body"] {
	height: 86px !important;
	top: auto !important;
	bottom: 0px;
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
									<input type="text" class="dropbtn calendar_input getChald" name="getChald" id="getChald" value="${today}"/>
									<div class="dropdown-menu" role="menu"  id="chk_calendar" style="width:250px;
									           border:1px solid #ccc;
									           border-radius: 5px;
									           padding: 5px;
									           overflow: hidden;" >
									</div>
								</div>
								
							</div>
						</div>
					</div>
						
					<div class="inlineBlock schLine" style="display:none;">	
						<input type="radio" name="getSelchk" class="getSelchk" style="width : 30px;" value="P6" checked /><spring:message code='label.WAN008.p6'/>
						<input type="radio" name="getSelchk" class="getSelchk" style="width : 30px;" value="P7" /><spring:message code='label.WAN008.p7'/>
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
						<input type="text" class="AXInput getPyvnd1" style="width : 80px;" name="getPyvnd1" id="getPyvnd1" maxlength="8"
						 onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)' onBlur="getCustSch('1',this.value);" placeholder="<spring:message code='label.WAN007.pyvnd'/>" title="<spring:message code='label.WAN007.pyvnd'/>">
						~
						<input type="text" class="AXInput getPyvnd2" style="width : 80px;" name="getPyvnd2" id="getPyvnd2" maxlength="8"
						 onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)' onBlur="getCustSch('2',this.value);" placeholder="<spring:message code='label.WAN007.pyvnd'/>" title="<spring:message code='label.WAN007.pyvnd'/>">
					</div>
					
					<div class="inlineBlock gubcd" style="" disabled>
						<input type="radio" name="getGubcd" class="getGubcd" style="width : 30px;" value="1" checked />CHECK LIST
						<input type="radio" name="getGubcd" class="getGubcd" style="width : 30px;" value="2" />ERROR LIST
					</div>
			
				</div>
			</div>
	
		    <div class="pt5 salGrid" data-ax5grid="grid" data-ax5grid-config="{showLineNumber: true}"></div>
		</div>
	</div>
</div>
