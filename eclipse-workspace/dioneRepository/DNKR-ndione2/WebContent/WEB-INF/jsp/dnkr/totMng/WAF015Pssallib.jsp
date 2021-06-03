<!-- <!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>UbiReport Preview</title> -->
<!--[if IE]><script src="../ajax/js4/excanvas.js"></script><![endif]-->

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/wafCommon.css" />
<style>
	.ubiWrap .first_div {
		width: 800px;
		display: inline-block;
		margin-right: 0.4rem;
	}
	
	@media screen and (max-width:1200px){
		.ubiWrap .first_div {
			width:100%;
		}
	}
	.ubiWrap .second_div {
		width: 290px;
		display: inline-block;
	}
	
	.ubiWrap .second_div th {
		width: 50px;
		min-width: 50px;
		border-right : 1px solid #bbb
	}
	.ubiWrap .second_div table td {
		border : 1px solid #bbb
	}
	
	.ubiWrap .second_div table td {
	    border: 1px solid #bbb;
	    height: 25px;
	}
</style>
<script src="/ubireport/ajax/js4/ubiajax.js"></script>
<script language='javascript'>
<!--
	/* URL 정보 */
	var app = '';
	var appUrl = self.location.protocol + '//' + self.location.host + (app==''?'':('/' + app));

	/* Viewer Object */
	var htmlViewer = null;

	/* Viewer Param Info */
	var pKey = '<%= session.getId() %>';
	var pGatewayUrl = appUrl + '/UbiGateway';
	var pResUrl = appUrl + '/ubireport/ajax/js4';
	var pResId = 'UBIAJAX';
	var pDivId = 'UbiHTMLViewer';
	var pScale = '160';
	var pScrollPage = 'true';
	var pIsStreaming = 'true';
	
	var pTimeOut = '600000';

	/* Modify for your environment */
	var pJrfName = 'SMDZ123P_1.jrf';
	var pArg = 'SYSDATE#${SYSDATE}#SYSTIME#${SYSTIME}#';

	/* Viewer Size Adjustment */
	var wGap = 6;
	var hGap = 112;
	
	var customHeight = 0;

	/* Viewer Resize */
	function Ubi_Resize() {
		var w = (document.getElementById('ubiWrap').clientWidth);
		var h = (document.getElementById('UbiHTMLViewer_preview_1').clientHeight) + hGap;
		try {
			var div = document.getElementById("tab_container");
			var parentDiv = document.getElementById("tab_container").firstElementChild.innerText;
			if (div.offsetHeight != 0) {
				$('#' + parentDiv, window.parent.document).css(
						"height", h + 270 + "px");
				$('#' + parentDiv, window.parent.document).css(
						"min-height", "500px");
			}
		} catch (e) {
			//toastMsg(e);
		}	
		
		document.getElementById(pDivId).style.width = w + 'px';
		$('#ubiWrap').css("min-width", (Number(w + 5)) + 'px');
		document.getElementById(pDivId).style.height = h + 'px';
		
	}

	/* Report Preview */
	function Ubi_LoadReport() {

		
		htmlViewer = new UbiViewer( {

			key        : pKey,
			gatewayurl : pGatewayUrl,
			resource   : pResUrl,
			resid      : pResId,
			divid      : pDivId,
			scale      : pScale,
			scrollpage : pScrollPage,
			isStreaming: pIsStreaming,
			streamdata : "ds_SMDZ123P#\"${pssForm}\"#",     //UDS stream 사용시 작성
			//streamdata : "ds_SMDZ123P#\"C1§0101001§749838§20060103§1190§0§null§null§null§03351-10510L §null§null§504§9340.00§ §KW§4707360.00§^nC1§0101001§749838§20060103§1190§0§null§null§null§03361-30100L §null§null§336§12338.00§ §KW§4145568.00§^n\"#",     //UDS stream 사용시 작성
			timeout    : pTimeOut,

			jrffile    : pJrfName,
			arg        : pArg
		});
		htmlViewer.showReport(Ubi_PreviewEnd);
		//htmlViewer.events.printEnd = Ubi_PrintEnd;
		//htmlViewer.events.exportEnd = Ubi_ExportEnd;
	}

        function Ubi_PreviewEnd() { 
        	Ubi_Resize();
        	parent.leftNavResize();
		//console.log('Ubi_PreviewEnd');
        }

        function Ubi_PrintEnd(flag) {

			 //console.log('Print Flag : ' + flag);
        }

	function Ubi_ExportEnd(flag) {

		//console.log('Export Flag : ' + flag);
        }
	
	
	var tabResize = function() {
		//console.log("tabResize()");
		try {
			var div = document.getElementById("tab_container");
			var parentDiv = document.getElementById("tab_container").firstElementChild.innerText;
			//toastMsg("parentDiv : " + parentDiv);
			if (div.offsetHeight != 0) {
				/*console.log("parentDiv:" + parentDiv);
				console.log("div:" + div);
				console.log("div.offsetHeight:" + div.offsetHeight);*/
				$('#' + parentDiv, window.parent.document).css(
						"height", customHeight + 270 + "px");
				$('#' + parentDiv, window.parent.document).css(
						"min-height", "500px");
			}
		} catch (e) {
			//toastMsg(e);
		}	
	}
	
	
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/waf/WAF015Pssallib.js?ver"></script>

<div id="ubiWrap" class="ubiWrap waf_wrap">
	<div class="list-top">
		<div class="first_div">
			<form id="searchForm"  action='${pageContext.request.contextPath}/WAF015Pssallib/search.do?tabId=${tabId}&menu=${menu}' method="POST" name="PssallibDomain">
				<div class="cb pt5"></div>
				<table class="pd-s-table">
					<colgroup>
						<col/>
						<col/>
						<col/>
						<col/>
						<col/>
						<col/>
					</colgroup>
					<tbody>
						<tr>
							<th>
								사업부
							</th>
							<td colspan="3">
								<select  autofocus="true" name="COMP" id="ComboBoxPlant" dataSet="ds_ComCode_PLNT">
									<c:if test="${fn:length(codeList) > 0}">
										<c:forEach var="codeD2Domain" items="${codeList}" varStatus="status">
											<option value="${codeD2Domain.code2}"><c:out value="${codeD2Domain.code_name}"/></option>
										</c:forEach>
									</c:if>
								</select>
							</td>
						</tr>
						<tr>
							<th>
								전표NO
							</th>
							<td>
								<c:choose>
									<c:when test="${paramForm ne null }">
										<input type="text" id="jpnno" name="jpnno" value="${paramForm.jpnno}"/> ~
										<input type="text" id="jpnno2" name="jpnno2" value="${paramForm.jpnno2}"/>
									</c:when>
									<c:when test="${fn:length(ds_SMDZ123P_CHK) > 0 }">
										<input type="text" id="jpnno" name="jpnno" value="${ds_SMDZ123P_CHK[0].trknos}"/> ~
										<input type="text" id="jpnno2" name="jpnno2" value="${ds_SMDZ123P_CHK[0].trknoe}"/>
									</c:when>
									<c:otherwise>
										<input type="text" id="jpnno" name="jpnno"/> ~
										<input type="text" id="jpnno2" name="jpnno2"/>
									</c:otherwise>
								</c:choose>
							</td>
							<th>
								업체
							</th>
							<td>
								<input type="text" id="pyvnd" name="pyvnd" value="${paramForm.pyvnd}"/> ~
								<input type="text" id="pyvnd2" name="pyvnd2" value="${paramForm.pyvnd2}"/>
							</td>
						</tr>
						<tr>
							<th>
								전표일자
							</th>
							<td>
								<div data-ax5picker="basic">
									<c:choose>
										<c:when test="${paramForm ne null }">
											<input type="text" id="jpsdt" name="jpsdt" placeholder="yyyy-mm-dd" data-ax5formatter="date" value="${paramForm.jpsdt}"/> ~
											<input type="text" id="jpsdt2" name="jpsdt2" placeholder="yyyy-mm-dd" data-ax5formatter="date" value="${paramForm.jpsdt2}"/>
										</c:when>
										<c:when test="${fn:length(ds_SMDZ123P_CHK) > 0 }">
											<input type="text" id="jpsdt" name="jpsdt" placeholder="yyyy-mm-dd" data-ax5formatter="date" value="${ds_SMDZ123P_CHK[0].prcdt}"/> ~
											<input type="text" id="jpsdt2" name="jpsdt2" placeholder="yyyy-mm-dd" data-ax5formatter="date" value="${ds_SMDZ123P_CHK[0].prcdt}"/>
										</c:when>
										<c:otherwise>
											<input type="text" id="jpsdt" placeholder="yyyy-mm-dd" data-ax5formatter="date" name="jpsdt"/> ~
											<input type="text" id="jpsdt2" placeholder="yyyy-mm-dd" data-ax5formatter="date" name="jpsdt2"/>
										</c:otherwise>
									</c:choose>
								</div>
							</td>
							<th>
								마감일자
							</th>
							<td>
								<div data-ax5picker="basic2">
									<c:choose>
										<c:when test="${paramForm ne null }">
											<input type="text" id="jptdt1" name="jptdt1" placeholder="yyyy-mm-dd" data-ax5formatter="date" value="${paramForm.jptdt1}"/> ~
											<input type="text" id="jptdt2" name="jptdt2" placeholder="yyyy-mm-dd" data-ax5formatter="date" value="${paramForm.jptdt2}"/>
										</c:when>
										<c:when test="${fn:length(ds_SMDZ123P_CHK) > 0 }">
											<input type="text" id="jptdt1" name="jptdt1" placeholder="yyyy-mm-dd" data-ax5formatter="date" value="${ds_SMDZ123P_CHK[0].jptdt1}"/> ~
											<input type="text" id="jptdt2" name="jptdt2" placeholder="yyyy-mm-dd" data-ax5formatter="date" value="${ds_SMDZ123P_CHK[0].jptdt1}"/>
										</c:when>
										<c:otherwise>
											<input type="text" id="jptdt1" placeholder="yyyy-mm-dd" data-ax5formatter="date" name="jptdt1"/> ~
											<input type="text" id="jptdt2" placeholder="yyyy-mm-dd" data-ax5formatter="date" name="jptdt2"/>
										</c:otherwise>
									</c:choose>
								</div>
							</td>
						</tr>
						<tr>
							<th>
								출력구분
							</th>
							<td colspan="3">
								<select name="dyes">
									<c:choose>
										<c:when test="${paramForm ne null }">
											<c:choose>	
												<c:when test="${paramForm.dyes eq 'Y'}">
													<option value="">전체</option>
													<option value="Y" selected>단가누락분만</option>
												</c:when>
												<c:otherwise>
													<option value="" selected>전체</option>
													<option value="Y">단가누락분만</option>
												</c:otherwise>
											</c:choose>
										</c:when>
										<c:otherwise>
											<option value="" selected>전체</option>
											<option value="Y">단가누락분만</option>
										</c:otherwise>
									</c:choose>
								</select>
							</td>
						</tr>
					</tbody>	
				</table>
			</form>
		</div>
		<div class="second_div">
			<div class="top-btns fr">
				<button type="submit" class="AXButton Black _searchBtn_" onclick="return check();">
					<i class="axi axi-ion-android-search"><spring:message code='label.search'/><!-- 조회 --></i>
				</button>
			</div>
			<div class="sssgap"></div>
			<table class="pd-s-table">
				<colgroup>
					<col/>
					<col/>
					<col/>
				</colgroup>
				<tbody>
					<tr>
						<th rowspan="2">
							전표일자
						</th>
						<th colspan="2">
							전표NO
						</th>
					</tr>
					<tr>
						<th>FROM</th>
						<th>TO</th>
					</tr>
					<c:choose>
						<c:when test = "${fn:length(ds_SMDZ123P_CHK) > 0}">
							<c:forEach var="ds" items="${ds_SMDZ123P_CHK}" varStatus="status">
								<tr>
									<td>
										<c:out value="${ds.prcdt}"/>
									</td>
									<td>
										<c:out value="${ds.trknos}"/>
									</td>
									<td>
										<c:out value="${ds.trknoe}"/>
									</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<c:forEach var="i" begin="1" end="4" step="1">
								<tr>
									<td></td>
									<td></td>
									<td></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
	</div>
	<div class="ssgap"></div>
	<div id="UbiHTMLViewer" style="border: solid 1px #aaa; position:relative;">
	</div>
</div>
<script>Ubi_LoadReport();</script>
<!-- </head>
<body style='margin:3px' onresize='Ubi_Resize()'>
<div id="UbiHTMLViewer" style="border: solid 1px #aaa; position:relative;"></div>
<script>Ubi_LoadReport();</script>
</body>
</html> -->