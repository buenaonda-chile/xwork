<%--
 * PROJECT：
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
	var pScale = '140';
	var pScrollPage = 'true';
	var pIsStreaming = 'true';
	var pData = "ds_ogm220_rep#\"${result}\"#".replace(/<br>/gi, "\n");
	
	var pTimeOut = '600000';

	/* Modify for your environment */
	var pJrfName = 'ogm220_rep.jrf';
	var pArg = '';

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
			streamdata : pData,     //UDS stream 사용시 작성
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

<div id="ubiWrap" class="ubiWrap waf_wrap">
	<div id="UbiHTMLViewer" style="border: solid 1px #aaa; position:relative;">
	</div>
</div>
<script>Ubi_LoadReport();</script>