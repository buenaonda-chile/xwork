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
<!-- [JP] Ã£ÂÂ³Ã£ÂÂ³Ã£ÂÂÃ£ÂÂ³Ã£ÂÂÃ£ÂÂ¨Ã£ÂÂªÃ£ÂÂ¢ -->
<%-- <spring:message code="label.filename" /> : <c:out value="${url }"></c:out> --%>

<link rel="stylesheet" media="all" href="/css/board.css" />
<link rel="stylesheet" media="all" href="/css/content.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/sal/CustPartConstMstView.js?ver"></script>

<script type="text/javascript">
	//ì¬ìë¶ë¥¼ ì íí´ì£¼ì¸ì.
	var LN_SELECT_COMPS = "<spring:message code='WAN-I0-0001'/>";
	//ìì²´ë¥¼ ì íí´ì£¼ì¸ì.
	var LN_SELECT_PYVND = "<spring:message code='WAN-I0-0002'/>";
	//[íì¸] ìì²´ì½ë íì¸ë°ëëë¤.
	var LN_IO_CHK1 = "<spring:message code='WAN-I0-Chk1'/>";

	var LN_CHK1 = "<spring:message code='label.WAN002.Chk6'/>";

	$(function() {
		grid.initView({
			cusnm : {
				label : "<spring:message code='label.WAN000.cusnm'/>"
			},
			pyvnd : {
				label : "<spring:message code='label.WAN007.pyvnd'/>"
			},
			pspno : {
				label : "<spring:message code='label.WAN001.pspno'/>"
			},
			cinbr : {
				label : "<spring:message code='label.WAN003.cinbr'/>"
			},
			qtypr : {
				label : "<spring:message code='label.WAN003.qtypr'/>"
			},
			carcd : {
				label : "<spring:message code='label.WAN007.carcd'/>"
			},
			carnm : {
				label : "<spring:message code='label.WAN001.carnm'/>"
			},
			bdycd : {
				label : "<spring:message code='label.WAN007.bdycd'/>"
			},
			bdynm : {
				label : "<spring:message code='label.WAN007.bdynm'/>"
			},
		}).setData();
	});

	function onlyNumber(event) {
		event = event || window.event;
		var keyID = (event.which) ? event.which : event.keyCode;
		if ((keyID >= 48 && keyID <= 57) || (keyID >= 96 && keyID <= 105)
				|| keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39)
			return;
		else
			return false;
	}
	function removeChar(event) {
		event = event || window.event;
		var keyID = (event.which) ? event.which : event.keyCode;
		if (keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39)
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

.grid-block { #
	min-width: 1100px;
	display: inline-block;
	margin: 0 5px;
	width: 100%;
}

.third-grid-block {
	min-width: 420px;
	line-height: 14px;
}

@media screen and (max-width:1100px) {
	.third-grid-block.team-ms {
		min-width: 0;
		min-width: 660px;
	}
}

@media screen and (max-width:800px) {
	.grid-block.team-ms {
		min-width: 0;
		width: 49%;
		margin: 0 0px;
	}
	.third-grid-block.team-ms {
		width: 100%;
	}
}

.gridBtn {
	height: 22px;
	line-height: 14px;
}

/*2021.01.27 스타일수정-박가람
[data-ax5grid] [data-ax5grid-container="root"] 
[data-ax5grid-container="body"] [data-ax5grid-panel] 
table tr td [data-ax5grid-cellHolder] {
	padding: 2px 5px;
} */
.schLine {
	margin: 0px 15px 0px 0px;
}

.wj-flexgrid {
	max-height: 400px;
	height: auto;
	width: 100%;
	/*font-size: 11pt;*/
	/*font-size:10px;*/
}

.wj-header {
	background: white;
}

/* 2021.01.08 */
.k_cg1 {
	padding: 14px 10px 0 15px;
}

.k_cg1 .k_bg1 {
	width: 300px;
}

.k_cg1 .k_sg1 {
	width: calc(100% - 300px);
}

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
						<spring:message code='label.search' />
					</button>

					<button type="button" class="xlsDown _excelBtn_">
						<span><spring:message code='label.excelDown' /></span>
					</button>
				</div>

				<div class="gridBtnBlock k_sg1">

					<spring:message code='label.WAN002.comps2' />
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

					<div class="inlineBlock schLine">
						<spring:message code='label.WAN002.pyvnd2' />
						<input type="text" class="AXInput getPyvnd" style="width: 50px;"
							name="getPyvnd" id="getPyvnd" maxlength="8"
							onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)'
							onBlur="getCustSch();"> <input type="text"
							class="AXInput getCusnm" style="width: 180px;" name="getCusnm"
							id="getCusnm" placeholder="<spring:message code='WAN-I0-0002'/>"
							title="<spring:message code='WAN-I0-0002'/>" disabled readOnly>
						<button type="button" onclick="" class="AXButton Normal _custBtn_">
							<spring:message code="label.select" />
						</button>
					</div>

					<div class="inlineBlock">
						<spring:message code='label.WAN001.pspno' />
						<input type="text" class="AXInput getPspno" style="width: 180px;"
							name="getPspno" id="getPspno" maxlength="15"
							onBlur="getItemSch();"
							placeholder="<spring:message code='WAN-I0-0010'/>"
							title="<spring:message code='WAN-I0-0010'/>">
						<spring:message code='label.WAN005.after' />
					</div>

				</div>
			</div>
			<div class="pt5 salGrid" data-ax5grid="grid"
				data-ax5grid-config="{showLineNumber: true}"></div>

		</div>
	</div>
</div>
