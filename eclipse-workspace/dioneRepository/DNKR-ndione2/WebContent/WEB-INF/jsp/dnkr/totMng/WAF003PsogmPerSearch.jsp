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
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%-- 조회권한 --%>

<%--
	BindDataSet : ds_omg312_gridVal
	지시No	: jisno
	방법		: jobnm
	처치		: chonm
	총공수	: tothr
	정지시간	: stphr
	완료일	: wndat
	
	현상 		: hyonm
	원인		: cause
	실원인	: trunm
	대분류	: assnm
	셋트부품 	: cpart
	분해불가	: dpart
--%>

<style>
[data-ax5grid-container="root"] [data-ax5grid-panel-scroll="body"] table tr> td:FIRST-CHILD {
    cursor: text;
    box-shadow: inset 0 0 0 0 transparent;
    background-color: transparent;
    border-radius: inherit;
    border-bottom: 1px solid #ccc !important;
    border-right: 1px solid #ccc !important;
}

[data-ax5grid-container="root"] [data-ax5grid-panel-scroll="body"] table tr> td:FIRST-CHILD:hover {
    background-color: transparent;
}

</style>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/wafCommon.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/waf/WAF003PsogmPerSearch.js"></script>
<form name="searchForm" id="searchForm">
<div class="top-btns fr">
	<button type="button" class="AXButton Black _searchBtn_" onclick="javascript:searchData();">
		<i class="axi axi-ion-android-search">조회</i>
	</button>
	<button type="button" class="downLoad _excelBtn_">
		<span>엑셀</span>
	</button>
</div>
<div class="pt5 cb"></div>
<table class="pd-s-table">
	<colgroup>
		<col style="width:120px;" />
		<col style="width:300px;" />
		<col style="width:120px;" />
		<col style="width:*px" />
	</colgroup>
	<tbody>
		<tr>
			<th>
				사업부
			</th>
			<td>
				<select autofocus="true" name="COMP" id="ComboBoxPlant" dataSet="ds_ComCode_PLNT">
					<c:if test="${fn:length(codeList) > 0}">
						<c:forEach var="codeD2Domain" items="${codeList}" varStatus="status">
							<option value="${codeD2Domain.code2}"><c:out value="${codeD2Domain.code_name}"/></option>
						</c:forEach>
					</c:if>
				</select>
			</td>
			<th>
				검색기간
			</th>
			<td>
				<div data-ax5picker="basic" style="width:450px;">
				<input type="text" name="cmbWnDatS" id="cmbWnDatS" style="width:120px;" placeholder="yyyy-mm-dd" data-ax5formatter="date" value="${nowYmd }"/>
	            ~
	            <input type="text" name="cmbWnDatE" id="cmbWnDatE" style="width:120px;" placeholder="yyyy-mm-dd" data-ax5formatter="date" value="${nowYmd }"/>
				
				</div>
			</td>
		</tr>
		<tr>
			<th>
				설비No
			</th>
			<td colspan="3">
				<input type="text" name="txtmshno" id="txtmshno" style="width:120px;" maxlength="10" onfocusout="txtmshno_chk(this.value)"/>
				<button type="button" class="next-arrow" onclick="javascript:ogm312_pop_OnClick();"></button>
				
				<input type="text" name="txtmshnm" id="txtmshnm" style="width:120px;" readonly/>
				<!-- omg200_pop.xml 설비선택 -->
				<input type="text" name="txttimnm" id="txttimnm" style="width:120px;" readonly/>
				<input type="text" name="txtprtnm" id="txtprtnm" style="width:120px;" readonly/>
				<input type="text" name="mtbindat" id="mtbindat" style="width:120px;" readonly/>
				
			</td>
			 
		</tr>
	</tbody>
</table>
</form>
<form name="gridForm" id="gridForm">
<table class="pd-s-table" style="margin-top:20px;">
<colgroup>
		<col style="width:120px;" />
		<col style="width:180px;" />
		<col style="width:120px;" />
		<col style="width:180px;" />
		<col style="width:120px;" />
		<col style="width:180px;" />
		<col style="width:120px;" />
		<col style="width:*px;" />
	</colgroup>
	<tbody>
		<tr>
			<th>
				총 보전건수
			</th>
			<td>
				<input type="text" name="txtttcnt" id="txtttcnt" style="width:120px;text-align:right" value="0"/>			 
			</td>
			<th>
				 총 보전공수
			</th>
			<td>
				<input type="text" name="txttthr" id="txttthr" style="width:120px;text-align:right" value="0"/>
			</td>
			<th>
				 Running Cost
			</th>
			<td><input type="text" name="txttcost" id="txttcost" style="width:120px;text-align:right" value="0"/>
				 
			</td>
			<th>
				 고 장 손 실
			</th>
			<td>
				 <input type="text" name="txtstcost" id="txtstcost" style="width:120px;text-align:right" value="0"/>	
			</td>
		</tr>
		<tr>
			<th>
				예방보전건수
			</th>
			<td>
				<input type="text" name="lblpmcnt" id="lblpmcnt" style="width:120px;text-align:right" value="0"/>	
			</td>
			<th>
				 예방보전공수(H)
			</th>
			<td>
				<input type="text" name="lblpmhr" id="lblpmhr" style="width:120px;text-align:right" value="0"/>
			</td>
			<th>
				 부 품 비 (천원)
			</th>
			<td><input type="text" name="lblpcost" id="lblpcost" style="width:120px;text-align:right" value="0"/>
				 
			</td>
			<th>
				설비정지시간(H)
			</th>
			<td>
				 <input type="text" name="lblstphr" id="lblstphr" style="width:120px;text-align:right" value="0"/>
			</td>
		</tr>
		<tr>
			<th>
				사회보전건수
			</th>
			<td>
				<input type="text" name="lblbmcnt" id="lblbmcnt" style="width:120px;text-align:right" value="0"/> 
			</td>
			<th>
				 사후보전공수(H)
			</th>
			<td>
				<input type="text" name="lblbmhr" id="lblbmhr" style="width:120px;text-align:right" value="0"/>
			</td>
			<th>
				 외 주 비(천원)
			</th>
			<td><input type="text" name="lblscost" id="lblscost" style="width:120px;text-align:right" value="0"/>
				 
			</td>
			<th>
				생산장애시간(H)
			</th>
			<td>
				 <input type="text" name="lbljanhr" id="lbljanhr" style="width:120px;text-align:right" value="0"/>
			</td>
		</tr>
		<tr>
			<th>
				개량보전건수
			</th>
			<td>
				<input type="text" name="lblcmcnt" id="lblcmcnt" style="width:120px;text-align:right" value="0"/> 
			</td>
			<th>
				 개량보전공수(H)
			</th>
			<td>
				<input type="text" name="lblcmhr" id="lblcmhr" style="width:120px;text-align:right" value="0"/>
			</td>
			<th>
				 보전노무비(천원)
			</th>
			<td><input type="text" name="lblhrcost" id="lblhrcost" style="width:120px;text-align:right" value="0"/>
				 
			</td>
			<th>
				손실노무비(천원)
			</th>
			<td>
				 <input type="text" name="lbljacost" id="lbljacost" style="width:120px;text-align:right" value="0"/>
			</td>
		</tr>
	</tbody>
</table>
<div style="margin-top:10px;">
	<!-- BindDataSet : ds_omg312_gridVal -->
	
</div>

<div style="position: relative;height:400px;" id="grid-parent">
    <div data-ax5grid="first-grid" data-ax5grid-config="{
                    showLineNumber: true,
                    showRowSelector: true,
                    sortable: true,
                    header: {align:"center"}
                    }" style="height: 100%;"></div>
</div>
</form>

</c:if>
<%-- <spring:message code="label.filename" /> : <c:out value="${url }"></c:out>


<link rel="stylesheet" href="${pageContext.request.contextPath}/css/content.css?ver" />
<style>
	.totManage .list-top select {
		width: 100px;
	}
</style>

<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }">조회권한

	<!--설비No별실적 cont_s-->
	<div class="gm_01_03_01_wrap totManage">
		<form>
			<div class="list-top">
				<div class="fl mr20">
					<span><strong>사업부</strong></span>
					<select name="sv" title="사업부를 선택해주세요" class="sel-st01">
						<option>사업부전체</option>
						<option>PS</option>
						<option>PS</option>
						<option>PS</option>
						<option>PS</option>
					</select>	
				</div>
				<div class="date fl">
					<div class="pr20">
						<span><strong>검색기간</strong></span>&nbsp;
						<div class="date-inwrap">
							<span class="calendar_icon vcen2 c1"></span>
							<input class="boxform tc w90px" value="2018-02-02" readonly="" type="text">
						</div>
						<span>&nbsp; ~ &nbsp;</span>
						<div class="date-inwrap">
							<span class="calendar_icon vcen2 c2"></span>
							<input class="boxform tc w90px" value="2018-02-02" readonly="" type="text">
						</div>
					</div>
				</div><!--date-->
				<div class="fr">
					<button class="view-bnt-big" type="" name="">
						<span>조회</span>
					</button>
				</div>
			</div><!--list-top-->

			<div class="ssgap"></div>

			<div class="cont">

				<div class="board-bList-wrap">
					<table>
						<caption>설비No별실적표</caption>
						<colgroup>
							<col width="125px">
							<col width="*">
							<col width="35px">
							<col width="*">
							<col width="*">
							<col width="*">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th class="bg-gray">설비 No</th>
								<td>
									<input class="text ipTxt03 " name="equipment" title="내용을 입력해주세요" type="text">
								</td>
								<td class="plr-none">
									<button class="fl next-arrow" type="submit"></button>
								</td>
								<td>
									<input class="text ipTxt03 " name="" title="내용을 입력해주세요" type="text">
								</td>
								<td>
									<input class="text ipTxt03 " name="" title="내용을 입력해주세요" type="text">
								</td>
								<td>
									<input class="text ipTxt03 " name="" title="내용을 입력해주세요" type="text">
								</td>
								<td>
									<p class="acq">
										<span>0000 - 00</span>
										<span>취득</span>
									</p>
								</td>
							</tr>
						</tbody>
					</table>
				</div>

				<div class="sssgap"></div>

				<div class="board-bList-wrap big fl">
					<table class="rline fl pd-s">
						<caption>설비No별실적표</caption>
						<colgroup>
							<col width="50%">
							<col width="50%">
						</colgroup>
						<tbody>
							<tr>
								<th class="bg-gray">총 보전건수</th>
								<td>
									<input name="eqNo-01" title="내용을 입력해주세요" type="text" readonly>
								</td>
							</tr>
							<tr>
								<th class="bg-gray">예방보전건수</th>
								<td>
									<input name="eqNo-02" title="내용을 입력해주세요" type="text" readonly>
								</td>
							</tr>
							<tr>
								<th class="bg-gray">사후보전건수</th>
								<td>
									<input name="eqNo-03" title="내용을 입력해주세요" type="text" readonly>	
								</td>
							</tr>
							<tr>
								<th class="bg-gray">개량보전건수</th>
								<td>
									<input name="eqNo-04" title="내용을 입력해주세요" type="text" readonly>	
								</td>
							</tr>
						</tbody>
					</table>
					<table class="rline fl pd-s">
						<caption>설비No별실적표</caption>
						<colgroup>
							<col width="50%">
							<col width="50%">
						</colgroup>
						<tbody>
							<tr>
								<th class="bg-gray">총 보전공수</th>
								<td>
									<input name="eqNo-05" title="내용을 입력해주세요" type="text" readonly>
								</td>
							</tr>
							<tr>
								<th class="bg-gray">예방보전공수 (H)</th>
								<td>
									<input name="eqNo-06" title="내용을 입력해주세요" type="text" readonly>
								</td>
							</tr>
							<tr>
								<th class="bg-gray">사후보전공수 (H)</th>
								<td>
									<input name="eqNo-07" title="내용을 입력해주세요" type="text" readonly>
								</td>
							</tr>
							<tr>
								<th class="bg-gray">개량보전공수 (H)</th>
								<td>
									<input name="eqNo-08" title="내용을 입력해주세요" type="text" readonly>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				
				<div class="board-bList-wrap s-front fl">
					<table class="rline pd-s">
						<caption>보전이력분석 검색표</caption>
						<colgroup>
							<col width="50%">
							<col width="50%">
						</colgroup>
						<tbody>
							<tr>
								<th class="bg-gray">Running Cost</th>
								<td>
									<input name="eqNo-09" title="내용을 입력해주세요" type="text" readonly>
								</td>
							</tr>
							<tr>
								<th class="bg-gray">부품비 (천원)</th>
								<td>
									<input name="eqNo-10" title="내용을 입력해주세요" type="text" readonly>
								</td>
							</tr>
							<tr>
								<th class="bg-gray">외주비 (천원)</th>
								<td>
									<input name="eqNo-11" title="내용을 입력해주세요" type="text" readonly>
								</td>
							</tr>
							<tr>
								<th class="bg-gray">보전노무비 (천원)</th>
								<td>
									<input name="eqNo-12" title="내용을 입력해주세요" type="text" readonly>
								</td>
							</tr>
						</tbody>
					</table>
				</div>

				<div class="board-bList-wrap small fl">
					<table class="rline pd-s">
						<caption>보전이력분석 검색표</caption>
						<colgroup>
							<col width="50%">
							<col width="50%">
						</colgroup>
						<tbody>
							<tr>
								<th class="bg-gray">고장손실</th>
								<td>
									<input name="eqNo-13" title="내용을 입력해주세요" type="text" readonly>
								</td>
							</tr>
							<tr>
								<th class="bg-gray">설비정지시간 (H)</th>
								<td>
									<input name="eqNo-14" title="내용을 입력해주세요" type="text" readonly>
								</td>
							</tr>
							<tr>
								<th class="bg-gray">생산장애시간 (H)</th>
								<td>
									<input name="eqNo-15" title="내용을 입력해주세요" type="text" readonly>
								</td>
							</tr>
							<tr>
								<th class="bg-gray">손실노무비 (천원)</th>
								<td>
									<input name="eqNo-16" title="내용을 입력해주세요" type="text" readonly>
								</td>
							</tr>
						</tbody>
					</table>
				</div>

				<div class="sgap"></div>

				<div class="inner-line3">
					<table class="tc tForm3 pd-s">
							<colgroup>
								<col width="11%">
								<col width="11%">
								<col width="11%">
								<col width="11%">
								<col width="11%">
								<col width="*">
								<col width="11%">
								<col width="11%">
								<col width="11%">
							</colgroup>
							<thead>
								<tr>
									<th>지시No</th>
									<th>방법</th>
									<th>처치</th>
									<th>총공수</th>
									<th>정지시간</th>
									<th>완료일</th>
									<th colspan="3" class="last"></th>
								</tr>
								<tr>
									<th></th>
									<th colspan="2">현상</th>
									<th colspan="2">원인</th>
									<th>실원인</th>
									<th>대분류</th>
									<th>셋트부품</th>
									<th class="last">분해불가</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>2</td>
									<td>3</td>
									<td>4</td>
									<td>5</td>
									<td>6</td>
									<td>7</td>
									<td>8</td>
									<td class="last">9</td>
								</tr>
								<tr>
									<td>11</td>
									<td>12</td>
									<td>13</td>
									<td>14</td>
									<td>15</td>
									<td>15</td>
									<td>15</td>
									<td>15</td>
									<td class="last">15</td>
								</tr>
							</tbody>
						</table>
				</div>
			</div><!--cont-->
		</form>
		<div class="gap"></div>
	</div><!--설비No별실적 cont_e-->

</c:if> --%>