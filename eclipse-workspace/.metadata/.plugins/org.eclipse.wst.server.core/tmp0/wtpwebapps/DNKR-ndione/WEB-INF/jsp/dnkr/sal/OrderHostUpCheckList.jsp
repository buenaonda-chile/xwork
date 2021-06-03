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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/sal/OrderHostUpCheckList.js?ver"></script>

<script  type="text/javascript">

//사업부를 선택해주세요.
var LN_SELECT_COMPS = "<spring:message code='WAN-I0-0001'/>";
//업체를 선택해주세요.
var LN_SELECT_PYVND = "<spring:message code='WAN-I0-0002'/>";
//[확인] 업체코드 확인바랍니다.
var LN_IO_CHK1 = "<spring:message code='WAN-I0-Chk1'/>";
//기준일자를 입력해주세요.
var LN_SELECT_DUMCB = "<spring:message code='WAN-I0-0011'/>";

$(function(){
	grid = gridP6;
	gridP6init();
}); 

function gridP6init(){
	grid.initView({
		pyvnd:{label:"코드"},     //DENSO거래처
		cusnm:{label:"거래처 명"}, //DENSO거래처
		dfacd:{label:"공장"},
		dmkcr:{label:"차종"},	//대표
		dsecd:{label:"서열"},	//대표
		dseno:{label:"번호"},	//대표
		cprtn:{label:"OEM품번"},	
		pspno:{label:"DENSO품번"},
		itdsc:{label:"DENSO품번 명"},		
		oemjg:{label:"OEM재고"},
		sane:{label:"사내"},    	//DENSO재고
		sawe:{label:"사외"},	    //DENSO재고
		mohtq:{label:"TOTAL"},	//DENSO재고
		trimd:{label:"TRIM"},
		pbsqy:{label:"대기댓수"},		
		patqy:{label:"도장댓수"},
		wbsqy:{label:"비축댓수"},		
		culjis:{label:"출하지시"},
		ilonjs:{label:"이론재고"},
		pbs:{label:"PBS"},
		dtq01:{label:"투입량"},		
		d0t01:{label:"D 2H"},
		dtt01:{label:""},  //toNumber(DTQ01)-toNumber(D0T01)		
		d0t02:{label:"D 2H"},
		dtt02:{label:""},  //toNumber(DTQ01)-toNumber(D0T01)-toNumber(D0T02)
		d0t03:{label:"D 2H"},
		dtt03:{label:""},  //toNumber(DTQ01)-toNumber(D0T01)-toNumber(D0T02)-toNumber(D0T03)
		d0t04:{label:"D 2H"},
		dtt04:{label:""},  //toNumber(DTQ01)-toNumber(D0T01)-toNumber(D0T02)-toNumber(D0T03)-toNumber(D0T04)
		d0t05:{label:"D 2H"},
		dtt05:{label:""},  //toNumber(DTQ01)-toNumber(D0T01)-toNumber(D0T02)-toNumber(D0T03)-toNumber(D0T04)-toNumber(D0T05)
		d0t06:{label:"D 2H"},
		dtt06:{label:""},  //toNumber(DTQ01)-toNumber(D0T01)-toNumber(D0T02)-toNumber(D0T03)-toNumber(D0T04)-toNumber(D0T05)-toNumber(D0T06)
		d0t07:{label:"D 2H"},
		dtt07:{label:""},  //toNumber(DTQ01)-toNumber(D0T01)-toNumber(D0T02)-toNumber(D0T03)-toNumber(D0T04)-toNumber(D0T05)-toNumber(D0T06)-toNumber(D0T07)
		d0t08:{label:"D 2H"},
		dtt08:{label:""},  //toNumber(DTQ01)-toNumber(D0T01)-toNumber(D0T02)-toNumber(D0T03)-toNumber(D0T04)-toNumber(D0T05)-toNumber(D0T06)-toNumber(D0T07)-toNumber(D0T08)
		d0t09:{label:"D 2H"},
		dtt09:{label:""},  //toNumber(DTQ01)-toNumber(D0T01)-toNumber(D0T02)-toNumber(D0T03)-toNumber(D0T04)-toNumber(D0T05)-toNumber(D0T06)-toNumber(D0T07)-toNumber(D0T08)-toNumber(D0T09)
		d0t10:{label:"D 2H"},
		dtt10:{label:""},  //toNumber(DTQ01)-toNumber(D0T01)-toNumber(D0T02)-toNumber(D0T03)-toNumber(D0T04)-toNumber(D0T05)-toNumber(D0T06)-toNumber(D0T07)-toNumber(D0T08)-toNumber(D0T09)-toNumber(D0T10)
		d0tqy:{label:"D 합"},
		dtq02:{label:"투입량"},
		d1t01:{label:"D+1 2H"},
		//DTQ13
		d1t02:{label:"D+1 2H"},
		//DTQ14
		d1t03:{label:"D+1 2H"},
		//DTQ13
		d1t04:{label:"D+1 2H"},
		//DTQ14
		d1t05:{label:"D+1 2H"},
		//DTQ13
		d1t06:{label:"D+1 2H"},
		//DTQ14
		d1t07:{label:"D+1 2H"},
		//DTQ13
		d1t08:{label:"D+1 2H"},
		//DTQ14
		d1t09:{label:"D+1 2H"},
		//DTQ13
		d1t10:{label:"D+1 2H"},
		//DTQ14
		d1tqy:{label:"D+1 합"},
		dtq03:{label:"투입량"},		
		d2t01:{label:"D+2 2H"},
		//DTQ13
		d2t02:{label:"D+2 2H"},
		//DTQ14
		d2t03:{label:"D+2 2H"},
		//DTQ13
		d2t04:{label:"D+2 2H"},
		//DTQ14
		d2t05:{label:"D+2 2H"},
		//DTQ13
		d2t06:{label:"D+2 2H"},
		//DTQ14
		d2t07:{label:"D+2 2H"},
		//DTQ13
		d2t08:{label:"D+2 2H"},
		//DTQ14
		d2t09:{label:"D+2 2H"},
		//DTQ13
		d2t10:{label:"D+2 2H"},
		//DTQ14
		d2tqy:{label:"D+2 합"},
		dtq04:{label:"투입량"},
		d3t01:{label:"D+3 2H"},
		//DTQ13
		d3t02:{label:"D+3 2H"},
		//DTQ14
		d3t03:{label:"D+3 2H"},
		//DTQ13
		d3t04:{label:"D+3 2H"},
		//DTQ14
		d3t05:{label:"D+3 2H"},
		//DTQ13
		d3t06:{label:"D+3 2H"},
		//DTQ14
		d3t07:{label:"D+3 2H"},
		//DTQ13
		d3t08:{label:"D+3 2H"},
		//DTQ14
		d3t09:{label:"D+3 2H"},
		//DTQ13
		d3t10:{label:"D+3 2H"},
		//DTQ14
		d3tqy:{label:"D+3 합"},
		dtq05:{label:"투입량"},		
		d4t01:{label:"D+4 2H"},
		//DTQ13
		d4t02:{label:"D+4 2H"},
		//DTQ14
		d4t03:{label:"D+4 2H"},
		//DTQ13
		d4t04:{label:"D+4 2H"},
		//DTQ14
		d4t05:{label:"D+4 2H"},
		//DTQ13
		d4t06:{label:"D+4 2H"},
		//DTQ14
		d4t07:{label:"D+4 2H"},
		//DTQ13
		d4t08:{label:"D+4 2H"},
		//DTQ14
		d4t09:{label:"D+4 2H"},
		//DTQ13
		d4t10:{label:"D+4 2H"},
		//DTQ14
		d4tqy:{label:"D+4 합"},
		dtq06:{label:"투입량"},
		remqy:{label:"이후투입"},
		grtot:{label:"합계"},
		
		dtq13:{label:""},
		dtq14:{label:""},
	});//.setData();	
}

function gridP7init(sdate){
	var dat00Label = "D Day";
	var dat01Label = "D+1 Day";
	var dat02Label = "D+2 Day";
	var dat03Label = "D+3 Day";
	var dat04Label = "D+4 Day";
	var dat05Label = "D+5 Day";
	var dat06Label = "D+6 Day";
	var dat07Label = "D+7 Day";
	var dat08Label = "D+8 Day";
	var dat09Label = "D+9 Day";
	var dat10Label = "D+10 Day";
	var dat11Label = "D+11 Day";
	var dat12Label = "D+12 Day";
	
	if(sdate != ""){
		dat00Label = date_add(sdate,0);
		dat01Label = date_add(sdate,1);
		dat02Label = date_add(sdate,2);
		dat03Label = date_add(sdate,3);
		dat04Label = date_add(sdate,4);
		dat05Label = date_add(sdate,5);
		dat06Label = date_add(sdate,6);
		dat07Label = date_add(sdate,7);
		dat08Label = date_add(sdate,8);
		dat09Label = date_add(sdate,9);
		dat10Label = date_add(sdate,10);
		dat11Label = date_add(sdate,11);
		dat12Label = date_add(sdate,12);	
	}
	
	grid.initView({
		pyvnd:{label:"코드"},     //DENSO거래처
		cusnm:{label:"거래처 명"}, //DENSO거래처
		dfacd:{label:"공장"},
		dmkcr:{label:"차종"},	//대표
		dsecd:{label:"서열"},	//대표
		dseno:{label:"번호"},	//대표
		cprtn:{label:"OEM품번"},	
		pspno:{label:"DENSO품번"},
		itdsc:{label:"DENSO품번 명"},
		oemjg:{label:"OEM재고"},
		sane:{label:"사내"},    	//DENSO재고
		sawe:{label:"사외"},	    //DENSO재고
		mohtq:{label:"TOTAL"},	//DENSO재고
		trimd:{label:"TRIM"},
		pbsqy:{label:"대기댓수"},
		patqy:{label:"도장댓수"},
		wbsqy:{label:"비축댓수"},	
		culjis:{label:"출하지시"},
		ilonjs:{label:"이론재고"},
		silqty:{label:"생산실적"},
		pbs:{label:"PBS"},
		dtq01:{label:"투입량"},
		dat00:{label:dat00Label},
		dtq02:{label:"투입량"},
		dat01:{label:dat01Label},
		dtq03:{label:"투입량"},
		dat02:{label:dat02Label},
		dtq04:{label:"투입량"},
		dat03:{label:dat03Label},
		dtq05:{label:"투입량"},
		dat04:{label:dat04Label},
		dtq06:{label:"투입량"},
		dat05:{label:dat05Label},
		dtq07:{label:"투입량"},
		dat06:{label:dat06Label},
		dtq08:{label:"투입량"},
		dat07:{label:dat07Label},
		dtq09:{label:"투입량"},
		dat08:{label:dat08Label},
		dtq10:{label:"투입량"},
		dat09:{label:dat09Label},
		dtq11:{label:"투입량"},
		dat10:{label:dat10Label},
		dtq12:{label:"투입량"},
		dat11:{label:dat11Label},
		dtq13:{label:"투입량"},
		dat12:{label:dat12Label},
		dtq14:{label:"투입량"},		
		remqy:{label:"이후투입"},
		okqty:{label:"확정수량"},
		mitqy:{label:"MITU"},
		prseq:{label:"PRSEQ"},
		miqqy:{label:"미반영량"},
		mioqy:{label:"차이오더량"},
		grtot:{label:"합계"},
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
					
					<button type="button" class="AXButton Red _saleBtn_" style="right:0px" data-target="normal">
						<span><spring:message code='label.WAN008.DaySaleCreate'/><!-- 일일판매 생성 --></span>
					</button>
				</div>
					
				<div class="gridBtnBlock k_sg1">
			
					<div class="board-bList-wrap log_board">
						<div class="list-top">
							<div class="fl schLine">
								<label class="k_l1"><spring:message code='label.WAN009.chkdt'/></label>
								<div class="dropdown">
									<span class="calendar_icon vcen2"></span>
									<input type="text" class="dropbtn calendar_input getDumcb" name="getDumcb" id="getDumcb" value="${dumcb}"/>
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
					
					<div class="inlineBlock schLine" >	
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
						<input type="text" class="AXInput getPyvnd" style="width : 50px;" name="getPyvnd" id="getPyvnd" maxlength="8"
							onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)' onBlur="getCustSch();">
						<input type="text" class="AXInput getCusnm" style="width : 150px;" name="getCusnm" id="getCusnm" placeholder="<spring:message code='WAN-I0-0002'/>" title="<spring:message code='WAN-I0-0002'/>" disabled readOnly>
						<button type="button" onclick="" class="AXButton Normal _custBtn_">
							<spring:message code="label.select" />
						</button>				
					</div>
					
					<div class="inlineBlock gubcd" style="display : none;" >
						<input type="radio" name="getGubcd" class="getGubcd" style="width : 30px;" value="0" checked /><spring:message code='label.WAN009.gubcd0'/>
						<input type="radio" name="getGubcd" class="getGubcd" style="width : 30px;" value="1" /><spring:message code='label.WAN009.gubcd1'/>
						<input type="radio" name="getGubcd" class="getGubcd" style="width : 30px;" value="2" /><spring:message code='label.WAN009.gubcd2'/>
					</div>
			
				</div>
			</div>
		
		    <div class="pt5 salGrid" data-ax5grid="grid" data-ax5grid-config="{showLineNumber: true}" ></div>	
		       
		</div>
	</div>
</div>
