<%--
 * PROJECTÃÂ¯ÃÂ¼ÃÂ
 *
 * [KR] 
 * 
 * $Id$
 *
 * Copyright (c) 2017 DENSO CORPORATION. All rights reserved.
 *
--%>
<!-- [EN] Contents area -->
<!-- [JP] ÃÂ£ÃÂÃÂ³ÃÂ£ÃÂÃÂ³ÃÂ£ÃÂÃÂÃÂ£ÃÂÃÂ³ÃÂ£ÃÂÃÂÃÂ£ÃÂÃÂ¨ÃÂ£ÃÂÃÂªÃÂ£ÃÂÃÂ¢ -->
<%-- <spring:message code="label.filename" /> : <c:out value="${url }"></c:out> --%>

<link rel="stylesheet" media="all" href="/css/board.css" />
<link rel="stylesheet" media="all" href="/css/content.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/sal/CustOrderTypeHistMstView.js?ver"></script>

<script type="text/javascript">
	//Ã¬ÂÂ¬Ã¬ÂÂÃ«Â¶ÂÃ«Â¥Â¼ Ã¬ÂÂ Ã­ÂÂÃ­ÂÂ´Ã¬Â£Â¼Ã¬ÂÂ¸Ã¬ÂÂ.
	var LN_SELECT_COMPS = "<spring:message code='WAN-I0-0001'/>";
	//Ã¬ÂÂÃ¬Â²Â´Ã«Â¥Â¼ Ã¬ÂÂ Ã­ÂÂÃ­ÂÂ´Ã¬Â£Â¼Ã¬ÂÂ¸Ã¬ÂÂ.
	var LN_SELECT_PYVND = "<spring:message code='WAN-I0-0002'/>";
	//[Ã­ÂÂÃ¬ÂÂ¸] Ã¬ÂÂÃ¬Â²Â´Ã¬Â½ÂÃ«ÂÂ Ã­ÂÂÃ¬ÂÂ¸Ã«Â°ÂÃ«ÂÂÃ«ÂÂÃ«ÂÂ¤.
	var LN_IO_CHK1 = "<spring:message code='WAN-I0-Chk1'/>";

	var LN_CHK1 = "<spring:message code='label.WAN002.Chk6'/>";

	$(function() {
		grid.initView({
			pspno : {
				label : "<spring:message code='label.WAN001.pspno'/>"
			},
			gubcd : {
				label : "<spring:message code='label.WAN005.gubcd'/>"
			},
			mcrcd1 : {
				label : "<spring:message code='label.WAN005.mcrcd1'/>"
			},
			seqcd1 : {
				label : "<spring:message code='label.WAN001.seqcd'/>"
			},
			seqno1 : {
				label : "<spring:message code='label.WAN001.seqno'/>"
			},
			efffr1 : {
				label : "<spring:message code='label.WAN005.efffr'/>"
			},
			effto1 : {
				label : "<spring:message code='label.WAN005.effto'/>"
			},
			devnm2 : {
				label : "<spring:message code='label.WAN005.devnm2'/>"
			},
			usrid2 : {
				label : "<spring:message code='label.WAN005.usrid2'/>"
			},
			itdsc : {
				label : "<spring:message code='label.WAN001.itdsc'/>"
			},
			mcrcd2 : {
				label : "<spring:message code='label.WAN005.mcrcd2'/>"
			},
			seqcd2 : {
				label : "<spring:message code='label.WAN001.seqcd'/>"
			},
			seqno2 : {
				label : "<spring:message code='label.WAN001.seqno'/>"
			},
			efffr2 : {
				label : "<spring:message code='label.WAN005.efffr'/>"
			},
			effto2 : {
				label : "<spring:message code='label.WAN005.effto'/>"
			},
			uptdt2 : {
				label : "<spring:message code='label.WAN005.uptdt2'/>"
			},
			upttm2 : {
				label : "<spring:message code='label.WAN005.upttm2'/>"
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
					<select name="getComps" id="getComps" class="getComps schLine"
						disabled>

						<option value="E1">마산</option>
						<option value="C1">창원</option>
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
						<input type="text" class="AXInput getPyvnd" style="width: 60px;"
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

					<div class="inlineBlock schLine">
						<spring:message code='label.WAN001.pspno' />
						<input type="text" class="AXInput getPspno" style="width: 130px;"
							name="getPspno" id="getPspno" onBlur="getItemSch();"
							maxlength="15">
						<spring:message code='label.WAN005.after' />
						<input type="text" class="AXInput getItdsc" style="width: 180px;"
							name="getItdsc" id="getItdsc"
							placeholder="<spring:message code='WAN-I0-0005'/>"
							title="<spring:message code='WAN-I0-0005'/>" disabled readOnly>
						<button type="button" onclick="" class="AXButton Normal _itemBtn_">
							<spring:message code="label.select" />
						</button>
					</div>

					<div class="inlineBlock">
						<spring:message code='label.WAN005.gubcd' />
						<select name="getGubcd" id="getGubcd" class="getGubcd">
							<option value="" selected><spring:message
									code='label.WAN005.all' /></option>
							<option value="A"><spring:message code='label.add' />(A)
							</option>
							<option value="C"><spring:message code='label.modify' />(C)
							</option>
							<option value="D"><spring:message code='label.delete' />(D)
							</option>
						</select>
					</div>
				</div>
			</div>
			<div class="pt5 salGrid" data-ax5grid="grid"
				data-ax5grid-config="{showLineNumber: true}"></div>

		</div>
	</div>
</div>
