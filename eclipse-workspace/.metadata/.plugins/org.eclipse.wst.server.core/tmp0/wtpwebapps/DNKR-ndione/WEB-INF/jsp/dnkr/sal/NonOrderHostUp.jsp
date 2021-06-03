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

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/wamCommon.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/sal/NonOrderHostUp.js"></script>


<script type="text/javascript">
//사업부를 선택해주세요.
var LN_SELECT_COMPS = "<spring:message code='WAN-I0-0001'/>";
//기준일자를 입력해주세요.
var LN_SELECT_PLNYM = "<spring:message code='WAN-I0-0011'/>";
//처리기간을 입력해주세요.
var LN_SELECT_PERIOD = "<spring:message code='WAN-I0-0013'/>";
//업체를 선택해주세요.
var LN_SELECT_PYVND = "<spring:message code='WAN-I0-0002'/>";
//[확인] 업체코드 확인바랍니다.
var LN_IO_CHK1 = "<spring:message code='WAN-I0-Chk1'/>";

//첨부파일을 선택해주세요.
var LN_SELECT_FILE = "<spring:message code='WAN-I0-0012'/>";

var plndt = '${plndt}';

var result = '${result}';

if(result){
	alert(result);
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

.schLine {
	margin: 0px 15px 0px 0px;
}

/* 2021.01.08 */
.k_cg1{padding:9px 10px 5px 15px;margin-bottom:0px;text-align:left;}
.k_cg1 .k_sg2{display:inline-block;}
.k_cg1 .k_sg3{display:inline-block;}
.k_cg1 .k_sg4{display:block;}
</style>

<div class="wrap">	
	<div style="text-align: center">
	<form:form action="${pageContext.request.contextPath}/WAN015NonOrderHostUp/procExcelUpload.do"  name="excelUploadForm"  id="excelUploadForm" method="POST" enctype="multipart/form-data">

	<div class="k_cg1">
	  <div class="k_sg2">
		<label class="k_l1"><spring:message code='label.WAN002.comps2'/></label>

		<select name="getComps" id="getComps" class="getComps schLine">
		
			<option value="E1" <c:if test="${comps eq 'E1'}">selected</c:if>>마산</option>
			<option value="C1" <c:if test="${comps eq 'C1'}">selected</c:if>>창원</option>
			<option value="S1" <c:if test="${comps eq 'S1'}">selected</c:if>>화성</option>
		
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
	  <div class="k_sg3">	
		<div class="sssgap" style="height:1px"></div>

		<!-- <form action=""> -->
		  <input type="file" name="upFile" multiple>
		  <!-- <input type="submit">
		</form> -->
		<button type="button" class="upLoad _excelUploadBtn_" style="right:0px">
			<span><spring:message code='label.WAN008.upload'/></span>
		</button>
		
		<button type="button" class="xlsDown" onclick="location.href='${pageContext.request.contextPath}/WAN015NonOrderHostUp/fileDownload.do?fileDir=/assets/excel/commonForm.xlsx'" <c:if test="${typcd eq 'CC' && ccTypcd ne '1'}">style="display: none;"</c:if>>
			<span>공통양식다운로드</span>
		</button>
		<!-- 양식 다운로드 확인1 
		<button type="button" class="xlsDown" onclick="location.href='${pageContext.request.contextPath}/data/excel/공통양식.xlsx'" <c:if test="${typcd eq 'CC' && ccTypcd ne '1'}">style="display: none;"</c:if>>
			<span>공통양식다운로드</span>
		</button>
		 -->		
		<!-- 양식 다운로드 확인2
		<button type="button" class="xlsDown _excelDownBtn_" data-target="down" <c:if test="${typcd eq 'CC' && ccTypcd ne '1'}">style="display: none;"</c:if>>
			<span>공통양식다운로드</span>
		</button>
		 -->
				
		<div class="sssgap"></div>
	  </div>
	  <div class="k_sg4">
		<div class="board-bList-wrap log_board">
			<div class="list-top">
				<div class="fl">

					<div class="inlineBlock schLine" >
						<input type="radio" name="getTypcd" class="getTypcd" style="width : 30px;" value="BB" <c:if test="${typcd eq 'BB'}">checked</c:if> /><spring:message code='label.WAN015.BB'/>
						<input type="radio" name="getTypcd" class="getTypcd schLine" style="width : 30px;" value="CC" <c:if test="${typcd eq 'CC'}">checked</c:if> /><spring:message code='label.WAN015.CC'/>
					</div>
					
					<select name="getCCTypcd" id="getCCTypcd" class="getCCTypcd schLine" <c:if test="${typcd eq 'BB'}">disabled</c:if>>
						<option value="1" <c:if test="${ccTypcd eq null}">selected</c:if><c:if test="${ccTypcd eq '1'}">selected</c:if>>표준양식</option>
						<option value="2" <c:if test="${ccTypcd eq '2'}">selected</c:if>>HMC CKD</option>
						<option value="3" <c:if test="${ccTypcd eq '3'}">selected</c:if>>KMC CKD</option>
						<option value="4" <c:if test="${ccTypcd eq '4'}">selected</c:if>>MOBIS CKD</option>
						<option value="5" <c:if test="${ccTypcd eq '5'}">selected</c:if>>MOBIS AS</option>
						<option value="6" <c:if test="${ccTypcd eq '6'}">selected</c:if>>GLOVIS</option>
					</select>
					
					<div class="inlineBlock schLine" >	
						<label class="k_l1"><spring:message code='label.WAN002.pyvnd2'/></label>
						<input type="text" class="AXInput getPyvnd" style="width : 50px;" name="getPyvnd" id="getPyvnd" maxlength="8" value="${pyvnd}"
							onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)' onBlur="getCustSch();">
						<input type="text" class="AXInput getCusnm" style="width : 180px;" name="getCusnm" id="getCusnm" value="${cusnm}" placeholder="<spring:message code='WAN-I0-0002'/>" title="<spring:message code='WAN-I0-0002'/>" readOnly>
						<button type="button" onclick="" class="AXButton Normal _custBtn_">
							<spring:message code="label.select" />
						</button>				
					</div>
				
					<label class="k_l1"><spring:message code='label.WAN009.chkdt'/></label>
					<div class="dropdown schLine">						
						<span class="calendar_icon vcen2"></span>
						<input type="text" class="dropbtn calendar_input getPlndt" name="getPlndt" id="getPlndt" value="${plndt}"/>
						<div class="dropdown-menu" role="menu"  id="plndt_calendar" style="width:250px;
						           border:1px solid #ccc;
						           border-radius: 5px;
						           padding: 5px;
						           overflow: hidden;" >
						</div>
					</div>
					
					<div class="inlineBlock" >
						<label class="k_l1"><spring:message code='label.WAN015.period'/></label>
						<input type="text" class="AXInput getPeriod" style="width : 50px;" name="getPeriod" id="getPeriod" maxlength="2"  value="${period}"
                            <c:if test="${typcd eq 'CC' && ccTypcd ne '1'}">disabled readOnly</c:if>
							onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)' onBlur="checkPeriod();">			
					</div>
				</div>
			</div>
		</div>
		<input type="hidden" name="getCCTypGbcd" class="getCCTypGbcd" value='${ccTypGbcd}' />
		
		<input type="hidden" name="sucList" value='${sucList}' />
		<input type="hidden" name="failList" value='${failList}' />
	   </div>			
	</div>			
	</form:form>
	</div>
	
	<div class="cb pt5">
	</div>
						
	<div>
		<div data-ax5grid="down-grid" data-ax5grid-config="{}" style="height: 0%; display: none;">
        </div>	
		<div class="grid-parent" style="height: 560px;">
			<div>
				<h3>HOST UP 정상LIST(중복DATA포함)</h3>
				<button type="button" class="xlsDown _excelBtn_" style="right:0px" data-target="normal">
					<span><spring:message code='label.excelDown' /><!-- 엑셀다운 --></span>
				</button>		
			</div>
			<div data-ax5grid="normal-grid" data-ax5grid-config="{}" style="height: 100%;">
            </div>
        </div>
        <div class="grid-parent" style="height: 560px;float:right">
			<div>
				<h3>HOST UP ERROR LIST</h3>
				<button type="button" class="xlsDown _excelBtn_" style="right:0px" data-target="error">
					<span><spring:message code='label.excelDown' /><!-- 엑셀다운 --></span>
				</button>
			</div>
			<div data-ax5grid="error-grid" data-ax5grid-config="{}" style="height: 100%;">
            </div>
        </div>
        <div data-ax5grid="first-grid" data-ax5grid-config="{
                    showLineNumber: true,
                    showRowSelector: true,
                    sortable: true,
                    header: {align:"center"}
                    }" style="height: 200px;"></div>
	</div>
</div>