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
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%-- 조회권한 --%>
<link type="text/css" href="/css/wafCommon.css" rel="stylesheet">
<script type="text/javascript" src="/js/form_valid.js"></script>
<script type="text/javascript">
	/**
	 * [KO]교환부품 객체
	 *
	 */
	function SpareUnit (prtno, prtnm, ptype, maker, quaty, price, amont, jisno) {
		this.prtno = prtno;
		this.prtnm = prtnm;
		this.ptype = ptype;
		this.maker = maker;
		this.quaty = quaty;
		this.price = price;
		this.amont = amont;
		this.jisno = jisno;
	}
	var list = ${unitList};
	var unitGrid = {
		initView: function() {
			this.target = new ax5.ui.grid();
			this.target.setConfig({
				target : $('[data-ax5grid="unit-grid"]'),
				showLineNumber: true, 
				header: {
					align: "center",
				},
				columns : 
					[
						{
							  key : "prtno",
							  label : "예비품NO",
							  width: 150,
						},
						{
							  key : "prtnm",
							  label : "부품명",
							  width: 150,
						},
						{
							  key : "ptype",
							  label : "규격",
							  width: 80,
						},
						{
							  key : "maker",
							  label : "MAKER",
							  width: 150,
						},
						{
							  key : "quaty",
							  label : "수량",
							  align: "right",
							  width: 80,
							  editor : {
									type : "text"
							  },
						},
						{
							  key : "price",
							  label : "단가",
							  align: "right",
							  width: 80,
						},
						{
							  key : "amont",
							  label : "금액",
							  align: "right",
							  width: 100,
						},
						{
							  key : "delchk",
							  label : "삭제",
							  align: "center",
							  width: 150,
							  editor : {
									type : "",
								},
								formatter:function(){		
									var seqno = this.item.seqno;
									return "<input type='checkbox' class='' onClick='delFile(this, " + '"' + seqno + '"' + ")'/>";
								}
						},
						{
							  key : "seqno",
							  label : "SEQNO",
							  width: 80,
						},
				    ],
			});
			this.target.onDataChanged = function() {
				var amount = Number(this.item.quaty) * Number(this.item.price);
				var jisno = $('#jisno').val();
				this.item.amont = amount;
				var updateData = new SpareUnit(this.item.prtno, this.item.prtnm, this.item.ptype, this.item.maker, this.item.quaty, this.item.price, amount, jisno);
				updateSpareUnit(updateData);
			}
			return this;
		}
	};
	
	function delFile (target, seqno) {
		if($(target).is(":checked")) {
			if(confirm("[확인]삭제하시겠습니까?")){
				var url = "/WAF002PsogmCreate/deleteChangeUnit.do";
				var jisno = $('#jisno').val();
				var params = {seqno : seqno};
				var obj = getAjaxDomain(url, params);
				if(obj !== undefined) {
					if(obj.result === RESULT_Y) {
						toastMsg('삭제되었습니다.');
						location.replace("/WAF002PsogmCreate/changeUnitPop.do?jisno=" + jisno);
					}
				}
			} else {
				$(target).prop("checked", false);
			}
		}
	}
	
	/**
	 * [KO] 등록하는 예비품 No가 등록되어있는지 확인 <br>
	 * [KO] 등록 되어 있으면 true 반환 <br>
	 * 
	 * @param prtno 부품 No
	 * @return boolean
	 */
	function chkPrtno (prtno) {
		var resultStr = false;
		list.forEach(function (item, index) {
			if (item.prtno === prtno) {
				$('#prtno').val("");
				resultStr = true; 
			}
		});
		
		return resultStr;
	}
	 
	/**
	 * 예비품 No 입력 후 Enter 키를 눌렀을때 수행하는 함수
	 */
	function enterProc(prtno) {
		 if(event.keyCode==13){
			 getSpareUnit(prtno);
			 return false;
		 }
	}
	
	/**
	 * [KO] prtno로 예비품 정보 가져오기
	 */
	function getSpareUnit (prtno) {
		if(prtno !== undefined && prtno.trim().length > 0) {
			
			//부품교환 리스트에 있는지 확인
			if(chkPrtno(prtno)){
				toastMsg("예비품No가 등록되어 있습니다. 해당내역을 수정하세요.");
				return false;
			} else {
				
				var url = "/WAF002PsogmCreate/ajaxSpareUnitInfo.do";
				var obj = getAjaxDomain(url, {prtno : prtno});	
				if(obj !== undefined) {
					if(obj.result === RESULT_Y) {
						var pDomain = obj.pDomain;
						//console.log(pDomain);
						$('#prtnm').val(pDomain.prtnm);
						$('#model').val(pDomain.model);
						$('#maknm').val(pDomain.maknm);
						$('#pcost').val(pDomain.pcost);
					}
				}  else {
					$('#prtno').val("");
					$('#prtnm').val("");
					$('#model').val("");
					$('#maknm').val("");
					$('#pcost').val("");
					$('#quaty').val("");
					$('#amount').val("");
				}
			}

		}
	}
	
	/**
	 * ==================================================================== 
	 * [KO] Function: 화면에 입력한 교환부품정보의 내용을 수정.<br> 
	 * [KO] Argument: [1st argument] 수정할 내용객체(SpareUnit)<br>
	 * [KO] Summary : 이함수는 화면에 입력한 교환부품정보의 내용을 수정한다.<br>
	 * [KO] Argument: [1st argument] SpareUnit<br>
	 * [EN] Summary : <br>
	 * ====================================================================
	 */
	function updateSpareUnit(updateData) {
		var ajaxParams = updateData;
		var url = "/WAF002PsogmCreate/updateChangeUnit.do";
		var jisno = $('#jisno').val();
		var resultObj = getAjaxDomain(url, updateData);	
		if(resultObj !== undefined) {
			toastMsg("수정되었습니다.");
			location.replace("/WAF002PsogmCreate/changeUnitPop.do?jisno=" + jisno);
		}
	}
	
	
	/**
	 * [KO] 총액구하기
	 * 
	 * @param quaty 수량
	 */  
	function calcuAmount(quaty) {
		$('#amount').val(Number(quaty) * Number($('#pcost').val() || 0));	
	}
	
	/**
	 * 팝업창에서 값넘겨받아 부모창에 데이터 set
	 * 
	 * @param type
	 * @param returnValue
	 */
	function getReturnValue(returnValue) {
		if (returnValue !== null) {
			var param = JSON.parse(returnValue); 
			console.log("교환부품창:" + param.prtno.trim());
		    $('#prtnm').val(param.prtnm);
		    $('#model').val(param.model);
		    $('#maknm').val(param.maknm);
		    $('#prtno').val(param.prtno);
		    $('#pcost').val(param.pcost);
		}

	}

	$(document.body).ready(function () {
		
		unitGrid.initView();
		unitGrid.target.setData(list);
		
		$('.searchBtn').click(function(){
			window.open("/WAF002PsogmCreate/spareUnitPop.do", "spareUnitPop", "width=565, height=700, scrollbars=yes, top=100, left=100");
		});
		
		$('.regiBtn').click(function(){
			$('#prtno').prop("readonly", false);
			$('#prtnm').prop("readonly", false);
			$('#model').prop("readonly", false);
			$('#maknm').prop("readonly", false);
			$('#pcost').prop("readonly", false);
			$('#amount').prop("readonly", false);
		});
		
		$('.addBtn').click(function(){
			if(val_chk($('#prtnm').val(), "부품명") && val_chk($('#quaty').val(), "수량")
					&& val_chk($('#pcost').val(), "단가")) {
				//toastMsg("등록");
				var chkPrtno = true;
				list.forEach(function(item, index) {
					if ( $('#prtno').val().trim() === item.prtno.trim()) {
						toastMsg("예비품No가 등록되어 있습니다. 해당내역을 수정하세요.");
						chkPrtno = false;
					}
				});
				
				return chkPrtno;
			}
			return false;
		});
		
		$('.closeBtn').click(function(){
			console.log(list.length);
			if (list.length > 0) {
				window.opener.setChangeUnit(JSON.stringify(list));
				self.close();	
			} else {
				window.opener.setChangeUnit(null);
				self.close();
			}
		});
		
		window.addEventListener("beforeunload", function (e) {
			if (list.length > 0) {
				window.opener.setChangeUnit(JSON.stringify(list));
			} else {
				window.opener.setChangeUnit(null);
			}
		    //var confirmationMessage = "";
	
			//e.returnValue = confirmationMessage;     // Gecko, Trident, Chrome 34+
			//return confirmationMessage;              // Gecko, WebKit, Chrome <34
		});
	});
	
	
</script>
<style>
.unitWrap .regTbl .btnDiv {
	text-align: center;
	padding: 5px;
}

.unitWrap .last-tbl {
	border-top: none;
}
</style>
<div class="unitWrap">	
	<h2 class="subpage-tit">교환부품입력<!-- 사업부서 선택 --></h2>
	<div class="list-top">
		<div class="fr">
			<button type="button" class="black btn-st02 closeBtn" onclick="">
				<spring:message code='label.close' />
				<!-- 삭제 -->
			</button>
		</div>
		<div class="sssgap"></div>
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
						지시 No
					</th>
					<td>
						<input type="text" placeholder="" title="" value="${jisno}" readonly/>
					</td>
					<td>
						<%-- <button type="button" class="AXButton Black closeBtn" onclick=""
							data-click-target="auth-close">
							<spring:message code='label.close' />
							<!-- 삭제 -->
						</button> --%>
						
					</td>
				</tr>
			</tbody>
		</table>
				
	</div>
	<div class="sssgap"></div>
	<div>
		<div class="gridContents" style="" id="grid-parent">
		    <div class="" data-ax5grid="unit-grid" data-ax5grid-config="{showLineNumber: true}" style="height: 300px"></div>
	    </div>
	</div>
	<div class="sssgap"></div>
	<div>
		<form action="/WAF002PsogmCreate/createSpareUnit.do" method="POST">
			<input type="hidden" id="jisno" name="jisno" value="${jisno}"/>
			<input type="hidden" name="status" value="insert"/>
			<table class="pd-s-table regTbl">
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
							부품명
						</th>
						<td>
							<input type="text" id="prtnm" name="prtnm" placeholder="" title="" required readonly/>
						</td>
						<th>
							규격
						</th>
						<td>
							<input type="text" id="model" name="ptype" placeholder="" title="" readonly/>
						</td>
						<td rowspan="5">
							<div>
								<div class="btnDiv">				
									<button type="button" class="red btn-st02 regiBtn" onclick=""
										data-click-target="">
										<spring:message code='label.register' />
										<!-- 추가 -->
									</button>
								</div>
								<div class="btnDiv">				
									<button type="submit" class="red btn-st02 addBtn" onclick=""
										data-click-target="">
										<spring:message code='label.add' />
										<!-- 등록 -->
									</button>
								</div>
								<%-- <div class="btnDiv">				
									<button type="button" class="AXButton Red" onclick=""
										data-click-target="">
										<spring:message code='label.register' />
										<!-- 추가 -->
									</button>
								</div>
								<div class="btnDiv">				
									<button type="button" class="AXButton Red" onclick=""
										data-click-target="">
										<spring:message code='label.add' />
										<!-- 등록 -->
									</button>
								</div> --%>
							</div>
						</td>
					</tr>
					<tr>
						<th>
							MAKER
						</th>
						<td colspan="3">
							<input type="text" name="maker" id="maknm" placeholder="" title="" readonly/>
						</td>
					</tr>
					<tr>
						<th>
							예비품 No
						</th>
						<td colspan="3">
							<input type="text" id="prtno" name="prtno" placeholder="" title="" onkeypress="return enterProc(this.value);" onfocusout="getSpareUnit(this.value)" readonly/>
							<button type="button" class="AXButton Black searchBtn" onclick=""
								data-click-target="">
								<i class="axi axi-ion-android-search"></i>
								<%-- <spring:message code='label.search' /> --%>
								<!-- 등록 -->
							</button>
							<%-- <button type="button" class="AXButton Black" onclick=""
								data-click-target="">
								<i class="axi axi-ion-android-search"></i>
								<spring:message code='label.search' />
								<!-- 등록 -->
							</button> --%>
						</td>
					</tr>
				</tbody>
			</table>
			<table class="pd-s-table last-tbl">
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
						<th>수량</th>
						<td><input type="number" id="quaty" name="quaty" title="" placeholder="" onfocusout="calcuAmount(this.value)" required/></td>
						<th>단가</th>
						<td><input type="number" id="pcost" name="price" title="" placeholder="" required readonly/></td>
						<th>금액</th>
						<td><input type="number" id="amount" name="amont" title="" placeholder="" readonly/></td>
					</tr>
				</tbody>
			</table>
		</form>	
	</div>
	<p>* 예비품No를 입력후 엔터를 치거나 직접 입력 하세요</p>
</div>
</c:if>