<%--
 * PROJECTï¼Â
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

<%-- <c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"> 조회권한
</c:if> --%>
<style>
.doc-wrap {
    padding: 20px 10px;
}

.ficSearchWrap {
	width: 100%;
    max-width: 545px;
}

.pd-s-table td select {
	width: 120px;
}

.contentTb th, .contentTb td{
	border: 1px solid #bbb;
}
</style>

<script type="text/javascript">
	function UnitObj (prtno, prtnm, model, maknm, pcost) {
		this.prtno = prtno;
		this.prtnm = prtnm;
		this.model = model;
		this.maknm = maknm;
		this.pcost = pcost;
	}
	
	var prtObj = null;
	
	var grid = {
			initView: function() {
				this.target = new ax5.ui.grid();
				this.target.setConfig({
					target : $('[data-ax5grid="grid"]'),
					showLineNumber: true,
					header :  {
						align: "center"
					},
					body : {
						align: "center",
						onClick : function() {
							var prtno = this.item.prtno;
							prtObj = new UnitObj(this.item.prtno, this.item.prtnm, this.item.model, this.item.maknm, this.item.pcost);
							this.self.clearSelect();
							this.self.select(this.dindex);
						},
					},
					columns : 
					[
					  {
						  key : "prtno",
						  label : "부품No",
					  },
					  {
						  key : "prtnm",
						  label : "부품명",  
					  },
					  {
						  key : "model",
						  label : "규격",
						  width: 200
					  },
					  {
						  key : "maknm",
						  label : "Maker",
					  },
					 ],
						 
				});
			}
	}	
	
	$(document.body).ready(function() {
		grid.initView();
		
		$('.searchBtn').on('click', function() {
			var params =  {
					"prtnm" : $('#prtnm').val(),
					"maknm" : $('#maknm').val()
				};
			var url = "/WAF002PsogmCreate/ajaxSearchUnit.do";
			var resultObj = getAjaxDomain(url, params);
			console.log(resultObj);
			if(resultObj !== undefined) {
				grid.target.setData(resultObj.unitList);
			}
		});
		
		$('._applyBtn_').on( 'click', function(e){
			if(prtObj === null){
				toastMsg("부품을 선택해 주세요")
				return false;
			} 
			console.log(prtObj);
			window.opener.getReturnValue(JSON.stringify(prtObj));
			window.close();
		});
		
		$('._closeBtn_').on( 'click', function(){
			self.close();
		});
	});
</script>

<!--설비No별실적 팝업 cont_s-->
<div class="ficSearchWrap">
	<div class="inwrap">
		<h2 class="subpage-tit">
			부품 조회
		</h2>
		
		<div class="">
			<form name="" id="searchForm">
				<div class="fr">
					<button type="button" class="AXButton Black searchBtn">
						<i class="axi axi-ion-android-search"></i>
						<spring:message code='label.search'/><!-- 조회 -->
					</button>
					<button type="button" class="AXButton Blue _applyBtn_" style=""
						onclick="" data-click-target="auth-save">
						<spring:message code='label.applyEmp' /><!-- 적용 -->
					</button>
					<button type="button" class="AXButton Normal _closeBtn_" onclick=""
						data-click-target="auth-close">
						<spring:message code='label.close' />
						<!-- 삭제 -->
					</button>
				</div>
				<div class="sssgap"></div>
				<table class="pd-s-table">
					<caption>부품명 선택표</caption>
					<colgroup>
						<col width="125px">
						<col width="*">
						<col width="125px">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th>부품명</th>
							<td>
								<input type="text" id="prtnm" name="prtnm" placeholder="부품명을 입력하세요" title="부품명을 입렧하세요"/>
							</td>
							<th>Maker</th>
							<td>
								<input type="text" id="maknm" name="maknm" placeholder="Maker명을 입력하세요" title="Maker명을 입렧하세요"/>
							</td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
		<div class="sssgap"></div>
		<div class="">
			<div class="grid-block">
				<div class="gridContents" style="" id="grid-parent">
				    <div style="height: 500px" id="searchGrid" class="searchGrid" data-ax5grid="grid" data-ax5grid-config="{showLineNumber: true}"></div>
				       
				</div>
			</div>
		</div>
	</div><!---->
</div>