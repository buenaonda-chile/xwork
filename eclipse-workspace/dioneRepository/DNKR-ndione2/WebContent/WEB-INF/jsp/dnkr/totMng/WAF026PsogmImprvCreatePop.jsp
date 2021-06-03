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
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/wafCommon.css" />
<style>
.doc-wrap {
	min-width: 1080px;
}

input.imgInput {
	position: absolute; 
	width: 1px; 
	height: 1px; 
	padding: 0; 
	margin: -1px; 
	overflow: hidden; 
	clip: rect(0,0,0,0); 
	border: 0;
}

label.Blue {
	margin-bottom: 10px;
}
</style>
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%-- 조회권한 --%>
<script type="text/javascript">
		var errMsg = "${imprvDomain.jisno}";
		if (errMsg === "") {
			toastMsg("[알림] 지시번호의 개선효과가 없습니다.");
		}
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/waf/WAF026PsogmImprvCreatePop.js"></script>

<div class="waf_wrap imprv_wrap">
	<h2 class="subpage-tit">
		개선상세
	</h2>
	<div class="fr">
		<button type="button" class="AXButton Normal _ubiRptBtn_">
			<%-- <spring:message code='label.save'/> --%>발행
		</button>
		<button type="button" class="AXButton Red _saveBtn_">
			<spring:message code='label.save'/><!-- 저장 -->
		</button>
		<button type="button" class="AXButton Black _closeBtn_" onclick="" data-target="psogmC">
			<span>닫기</span>
		</button>
	</div>
	<div class="sssgap"></div>
	<form:form action="${pageContext.request.contextPath}/WAF026PsogmImprvD/create.do?menu=${menu}" method="POST" name="createForm" id="createForm">
		<input type="hidden" id="jisno" name="jisno" value="${jisno}"/>
		<c:choose>
			<c:when test="${imprvDomain ne null}">
				<table class="pd-s-table">
					<caption></caption>
						<colgroup>
							<col>
							<col>
							<col>
							<col>
						</colgroup>
						<tbody>
							<tr>
								<th rowspan="2">테마</th>
								<td rowspan="2">
									<textarea id="teima" name="teima"><c:out value="${imprvDomain.teima}"/></textarea>
								</td>
								<th>효과금액</th>
								<td class="t_left"><input type="number" id="tSum" name="tSum" placeholder="" title="" value="${imprvDomain.tSum}"/> (단위:천원)</td>
							</tr>
							<tr>
								<th>협조부서</th>
								<td><input type="text" name="kyoru" onchange="calcu_sums()" placeholder="" title="" value="${imprvDomain.kyoru}"/></td>
							</tr>
							<tr>
								<th style="height: 84px">대상</th>
								<td>
									<textarea name="daesn"><c:out value="${imprvDomain.daesn}"/></textarea>
								</td>
								<th>착안점</th>
								<td>
									<textarea name="chkan"><c:out value="${imprvDomain.chkan}"/></textarea>
								</td>
							</tr>
						</tbody>
				</table>
				<div class="sssgap"></div>
				<table class="pd-s-table imprvTbl line-table">
					<caption></caption>
					<colgroup>
						<col>
						<col>
						<col>
						<col>
					</colgroup>
					<tbody>
						<tr>
							<th class="thWidth">구분</th>
							<th class="thWidth">코드<br>No</th>
							<th style="width: 15%">개선효과내용</th>
							<th style="width: 15%">A. 현상의 비용</th>
							<th style="width: 15%">B. 개선의 비용</th>
							<th style="width: 15%">C. 개선후의 비용</th>
							<th style="width: 15%">효과금액(A - ( B+C ))</th>
							<th>합계</th>
						</tr>
						<tr>
							<th rowspan="6" class="thWidth">
								기계보전비의억제활동
							</th>
							<td class="t_center">
								A1
							</td>
							<td class="exceptTd">
								부품비의 절감<br>
								(부품재생이용, 기타)
							</td>
							<td>
								(신작비용)
								<input type="number" name="a1hyn" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.a1hyn}"/>
							</td>
							<td>
								(재생비용)
								<input type="number" name="a1cst" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.a1cst}"/>
							</td>
							<td>
							</td>
							<td class="t_right" id="a1hyo">
								<c:out value="${imprvDomain.a1hyo}"/>
							</td>
							<td rowspan="6" class="t_right">
								<span id="aSum"><c:out value="${imprvDomain.aSum}"/></span> 
								천원/Y
							</td>
						</tr>
						<tr>
							<td class="t_center">
								A2
							</td>
							<td>
								부품비의 절감<br>
								(유휴, 중고품의 사용)
							</td>
							<td>
								(신작비용)
								<input type="number" name="a2hyo" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.a2hyo}"/>
							</td>
							<td></td>
							<td></td>
							<td id="a2hyo">
								<c:out value="${imprvDomain.a2hyo}"/>
							</td>
						</tr>
						<tr>
							<td class="t_center">
								A3
							</td>
							<td>
								부품비의 절감<br>
								(저가품에의 변경, 기타)
							</td>
							<td>
								
								<input type="number" name="a3hyn" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.a3hyn}"/>
							</td>
							<td>
								(교체부품비)
								<input type="number" name="a3cst" title="" onchange="calcu_sums()" placeholder="" value="${imprvDomain.a3cst}"/>
							</td>
							<td>
							</td>
							<td id="a3hyo">
								<c:out value="${imprvDomain.a3hyo}"/>
							</td>
						</tr>
						<tr>
							<td class="t_center">
								A4
							</td>
							<td>
								부품비의 절감<br>
								(부품의 수명 연장, 기타)
							</td>
							<td>
								천원 X회/Y
								<input type="number" name="a4hyn" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.a4hyn}"/>
							</td>
							<td>
								<input type="number" name="a4cst" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.a4cst}"/>
							</td>
							<td>
								천원 X회/Y
								<input type="number" name="a4aft" title="" onchange="calcu_sums()" placeholder="" value="${imprvDomain.a4aft}"/>
							</td>
							<td id="a4hyo">
								<c:out value="${imprvDomain.a4hyo}"/>
							</td>
						</tr>
						<tr>
							<td class="t_center">
								A5
							</td>
							<td>
								부품비의 절감<br>
								(MAKER 변경, 기타)
							</td>
							<td>
								(현상의 비용)
								<input type="number" name="a5hyn" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.a5hyn}"/>
							</td>
							<td></td>
							<td>
								(변경후의 비용)
								<input type="number" name="a5aft" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.a5aft}"/>
							</td>
							<td id="a5hyo">
								<c:out value="${imprvDomain.a5hyo}"/>
							</td>
						</tr>
						<tr>
							<td class="t_center">
								A6
							</td>
							<td>
								부품비의 절감<br>
								(시공 방법의 변경, 기타)
							</td>
							<td>
								(현상의 비용)
								<input type="number" name="a6hyn" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.a6hyn}"/>
							</td>
							<td>
								(현상의 비용)
								<input type="number" name="a6cst" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.a6cst}"/>
							</td>
							<td>
								(변경후의 비용)
								<input type="number" name="a6aft" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.a6aft}"/>
							</td>
							<td id="a6hyo">
								<c:out value="${imprvDomain.a6hyo}"/>
							</td>
						</tr>
						<tr class="h10">
						</tr>
						<tr>
							<th rowspan="4" class="thWidth">
								생산성향상활동
							</th>
							<td class="thWidth t_center">
								B1
							</td>
							<td class="exceptTd" style="width: 15%">
								인건비(공수)의 절감<br>
								(고장 대책등에 의한)
							</td>
							<td class="t_center" style="width: 15%">
								H/Y
								<input type="number" name="b1hyn" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.b1hyn}"/>
							</td>
							<td style="width: 15%">
								<input type="number" name="b1cst" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.b1cst}"/>
							</td>
							<td style="width: 15%">
								H/Y
								<input type="number" name="b1aft" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.b1aft}"/>
							</td>
							<td id="b1hyo" class="t_right" style="width: 15%">
								<c:out value="${imprvDomain.b1hyo}"/>
							</td>
							<td rowspan="4" class="t_right">
								<span id="bSum"><c:out value="${imprvDomain.bSum}"/></span>
								천원/Y
							</td>
						</tr>
						<tr>
							<td class="t_center">
								B2
							</td>
							<td>
								인건비(공수)의 절감<br>
								(업무의 개선, 개량)
							</td>
							<td>
								H/Y
								<input type="number" name="b2hyn" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.b2hyn}"/>
							</td>
							<td>
								<input type="number" name="b2cst" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.b2cst}"/>
							</td>
							<td>
								H/Y
								<input type="number" name="b2aft" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.b2aft}"/>
							</td>
							<td id="b2hyo">
								<c:out value="${imprvDomain.b2hyo}"/>
							</td>
						</tr>
						<tr>
							<td class="t_center">
								B3
							</td>
							<td>
								인건비(공수)의 절감<br>
								(품질 향상 대책에 의한)
							</td>
							<td>
								H/Y
								<input type="number" name="b3hyn" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.b3hyn}"/>
							</td>
							<td>
								<input type="number" name="b3cst" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.b3cst}"/>
							</td>
							<td>
								H/Y
								<input type="number" name="b3aft" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.b3aft}"/>
							</td>
							<td id="b3hyo">
								<c:out value="${imprvDomain.b3hyo}"/>
							</td>
						</tr>
						<tr>
							<td class="t_center">
								B4
							</td>
							<td>
								인건비(공수)의 절감<br>
								(가동율 향상 대책에 의한)
							</td>
							<td>
								OP인원수XC/T(H)
								<input type="number" name="b4hyn" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.b4hyn}"/>
							</td>
							<td>
								<input type="number" name="b4cst" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.b4cst}"/>
							</td>
							<td>
								OP인원수XC/T(H)
								<input type="number" name="b4aft" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.b4aft}"/>
							</td>
							<td id="b4hyo">
								<c:out value="${imprvDomain.b4hyo}"/>
							</td>
						</tr>
						<tr class="h10">
						</tr>
						<tr>
							<th rowspan="20" class="thWidth">
								설비에<br>관한개선활동
							</th>
							<td class="thWidth t_center">
								C1
							</td>
							<td class="exceptTd" style="width: 15%">
								고장손실비의 절감<br>
								(고장의재발 방지 대책)
							</td>
							<td class="t_center" style="width: 15%">
								(고장 정지 시간) H/Y
								<input type="number" name="c1hyn" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.c1hyn}"/>
							</td>
							<td style="width: 15%">
								<input type="number" name="c1cst" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.c1cst}"/>
							</td>
							<td style="width: 15%">
								(고장 정지 시간) H/Y
								<input type="number" name="c1aft" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.c1aft}"/>
							</td>
							<td id="c1hyo" class="t_right" style="width: 15%">
								<c:out value="${imprvDomain.c1hyo}"/>
							</td>
							<td rowspan="4" class="t_right">
								<span id="cSum"><c:out value="${imprvDomain.cSum}"/></span>
								천원/Y
							</td>
						</tr>
						<tr>
							<td class="t_center">
								C2
							</td>
							<td>
								고장손실비의 절감<br>
								(쵸크정지 재발 방지 대책)
							</td>
							<td>
								(쵸크 정지 시간) H/Y
								<input type="number" name="c2hyn" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.c2hyn}"/>
							</td>
							<td>
								<input type="number" name="c2cst" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.c2cst}"/>
							</td>
							<td>
								(쵸크 정지 시간) H/Y
								<input type="number" name="c2aft" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.c2aft}"/>
							</td>
							<td id="c2hyo">
								<c:out value="${imprvDomain.c2hyo}"/>
							</td>
						</tr>
						<tr>
							<td class="t_center">
								C3
							</td>
							<td>
								재료비의 절감
							</td>
							<td>
								(단가/ 워크 1개)원
								<input type="number" name="c3hyn" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.c3hyn}"/>
							</td>
							<td>
								(년간생산개수)
								<input type="number" name="c3cst" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.c3cst}"/>
							</td>
							<td>
								(단가/ 워크 1개)원
								<input type="number" name="c3aft" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.c3aft}"/>
							</td>
							<td id="c3hyo">
								<c:out value="${imprvDomain.c3hyo}"/>
							</td>
						</tr>
						<tr>
							<td class="t_center">
								C4
							</td>
							<td>
								안전대책의 효과
							</td>
							<td>
								<input type="number" name="c4hyn" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.c4hyn}"/>
							</td>
							<td>
								<input type="number" name="c4cst" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.c4cst}"/>
							</td>
							<td>
								<input type="number" name="c4aft" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.c4aft}"/>
							</td>
							<td id="c4hyo">
								<c:out value="${imprvDomain.c4hyo}"/>
							</td>
						</tr>
						<tr class="h10">
						</tr>
						<tr>
							<td class="t_center">
								11
							</td>
							<td>
								O I L 비용의 절감
							</td>
							<td>
								<input type="number" name="d1hyn" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.d1hyn}"/>
							</td>
							<td>
								<input type="number" name="d1cst" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.d1cst}"/>
							</td>
							<td>
								<input type="number" name="d1aft" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.d1aft}"/>
							</td>
							<td id="d1hyo">
								<c:out value="${imprvDomain.d1hyo}"/>
							</td>
							<td rowspan="16" class="t_right">
								<span id="dSum"><c:out value="${imprvDomain.dSum}"/></span>
								천원/Y
							</td>
						</tr>
						<tr>
							<td class="t_center">
								12
							</td>
							<td>
								도료비의 절감
							</td>
							<td>
								<input type="number" name="d2hyn" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.d2hyn}"/>
							</td>
							<td>
								<input type="number" name="d2cst" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.d2cst}"/>
							</td>
							<td>
								<input type="number" name="d2aft" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.d2aft}"/>
							</td>
							<td id="d2hyo">
								<c:out value="${imprvDomain.d2hyo}"/>
							</td>
						</tr>
						<tr>
							<td class="t_center">
								13
							</td>
							<td>
								약품비의 절감
							</td>
							<td>
								<input type="number" name="d3hyn" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.d3hyn}"/>
							</td>
							<td>
								<input type="number" name="d3cst" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.d3cst}"/>
							</td>
							<td>
								<input type="number" name="d3aft" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.d3aft}"/>
							</td>
							<td id="d3hyo">
								<c:out value="${imprvDomain.d3hyo}"/>
							</td>
						</tr>
						<tr>
							<td class="t_center">
								15
							</td>
							<td>
								용도품비의 절감
							</td>
							<td>
								<input type="number" name="d5hyn" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.d5hyn}"/>
							</td>
							<td></td>
							<td>
								<input type="number" name="d5aft" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.d5aft}"/>
							</td>
							<td id="d5hyo">
								<c:out value="${imprvDomain.d5hyo}"/>
							</td>
						</tr>
						<tr>
							<td class="t_center">
								17
							</td>
							<td>
								소모공구비의 절감
							</td>
							<td>
								<input type="number" name="d7hyn" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.d7hyn}"/>
							</td>
							<td>
								<input type="number" name="d7cst" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.d7cst}"/>
							</td>
							<td>
								<input type="number" name="d7aft" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.d7aft}"/>
							</td>
							<td id="d7hyo">
								<c:out value="${imprvDomain.d7hyo}"/>
							</td>
						</tr>
						<tr>
							<td class="t_center">
								18
							</td>
							<td>
								공구비의 절감
							</td>
							<td>
								<input type="number" name="d8hyn" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.d8hyn}"/>
							</td>
							<td></td>
							<td>
								<input type="number" name="d8aft" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.d8aft}"/>
							</td>
							<td id="d8hyo">
								<c:out value="${imprvDomain.d8hyo}"/>
							</td>
						</tr>
						<tr>
							<td class="t_center">
								20
							</td>
							<td>
								치구비의 절감
							</td>
							<td>
								<input type="number" name="dbhyn" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.dbhyn}"/>
							</td>
							<td>
								<input type="number" name="dbcst" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.dbcst}"/>
							</td>
							<td>
								<input type="number" name="dbaft" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.dbaft}"/>
							</td>
							<td id="dbhyo">
								<c:out value="${imprvDomain.dbhyo}"/>
							</td>
						</tr>
						<tr>
							<td class="t_center">
								21
							</td>
							<td>
								계측비의 절감
							</td>
							<td>
								<input type="number" name="dchyn" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.dchyn}"/>
							</td>
							<td></td>
							<td>
								<input type="number" name="dcaft" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.dcaft}"/>
							</td>
							<td id="dc hyo">
								<c:out value="${imprvDomain.dchyo}"/>
							</td>
						</tr>
						<tr>
							<td class="t_center">
								22
							</td>
							<td>
								금형비의 절감
							</td>
							<td>
								<input type="number" name="ddhyn" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.ddhyn}"/>
							</td>
							<td>
								<input type="number" name="ddcst" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.ddcst}"/>
							</td>
							<td>
								<input type="number" name="ddaft" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.ddaft}"/>
							</td>
							<td id="ddhyo">
								<c:out value="${imprvDomain.ddhyo}"/>
							</td>
						</tr>
						<tr>
							<td class="t_center">
								24
							</td>
							<td>
								기기비품비의 절감
							</td>
							<td>
								<input type="number" name="dehyn" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.dehyn}"/>
							</td>
							<td></td>
							<td>
								<input type="number" name="deaft" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.deaft}"/>
							</td>
							<td id="dehyo">
								<c:out value="${imprvDomain.dehyo}"/>
							</td>
						</tr>
						<tr>
							<td class="t_center">
								31
							</td>
							<td>
								수선비의 절감
							</td>
							<td>
								<input type="number" name="dfhyn" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.dfhyn}"/>
							</td>
							<td>
								<input type="number" name="dfcst" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.dfcst}"/>
							</td>
							<td>
								<input type="number" name="dfaft" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.dfaft}"/>
							</td>
							<td id="dfhyo">
								<c:out value="${imprvDomain.dfhyo}"/>
							</td>
						</tr>
						<tr>
							<td class="t_center">
								32
							</td>
							<td>
								에네지로스의 절감
							</td>
							<td>
								<input type="number" name="dghyn" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.dghyn}"/>
							</td>
							<td>
								<input type="number" name="dgcst" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.dgcst}"/>
							</td>
							<td>
								<input type="number" name="dgaft" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.dgaft}"/>
							</td>
							<td id="dghyo">
								<c:out value="${imprvDomain.dghyo}"/>
							</td>
						</tr>
						<tr>
							<td class="t_center">
								48
							</td>
							<td>
								외주위탁비의 절감
							</td>
							<td>
								<input type="number" name="dhhyn" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.dhhyn}"/>
							</td>
							<td></td>
							<td>
								<input type="number" name="dhaft" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.dhaft}"/>
							</td>
							<td id="dhhyo">
								<c:out value="${imprvDomain.dhhyo}"/>
							</td>
						</tr>
						<tr>
							<td class="t_center">
								51
							</td>
							<td>
								청소비의 절감
							</td>
							<td>
								<input type="number" name="dihyn" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.dihyn}"/>
							</td>
							<td>
								<input type="number" name="dicst" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.dicst}"/>
							</td>
							<td>
								<input type="number" name="diaft" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.diaft}"/>
							</td>
							<td id="dihyo">
								<c:out value="${imprvDomain.dihyo}"/>
							</td>
						</tr>
						<tr>
							<td class="t_center">
								53
							</td>
							<td>
								仕損費의 절감
							</td>
							<td>
								<input type="number" name="djhyn" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.djhyn}"/>
							</td>
							<td>
								<input type="number" name="djcst" onchange="calcu_sums()" title="" placeholder="" value="${imprvDomain.djcst}"/>
							</td>
							<td></td>
							<td id="djhyo">
								<c:out value="${imprvDomain.djhyo}"/>
							</td>
						</tr>
					</tbody>
				</table>
			</c:when>
			
			<c:otherwise>
				<table class="pd-s-table">
					<caption></caption>
						<colgroup>
							<col>
							<col>
							<col>
							<col>
						</colgroup>
						<tbody>
							<tr>
								<th rowspan="2">테마</th>
								<td rowspan="2">
									<textarea id="teima" name="teima"></textarea>
								</td>
								<th>효과금액</th>
								<td class="t_left"><input type="number" id="tSum" name="tSum" placeholder="" title="" value="0"/> (단위:천원)</td>
							</tr>
							<tr>
								<th>협조부서</th>
								<td><input type="text" name="kyoru" placeholder="" title="" value=""/></td>
							</tr>
							<tr>
								<th style="height: 84px">대상</th>
								<td>
									<textarea name="daesn"></textarea>
								</td>
								<th>착안점</th>
								<td>
									<textarea name="chkan"></textarea>
								</td>
							</tr>
						</tbody>
				</table>
				<div class="sssgap"></div>
				<table class="pd-s-table imprvTbl line-table">
					<caption></caption>
					<colgroup>
						<col>
						<col>
						<col>
						<col>
					</colgroup>
					<tbody>
						<tr>
							<th class="thWidth">구분</th>
							<th class="thWidth">코드<br>No</th>
							<th style="width: 15%">개선효과내용</th>
							<th style="width: 15%">A. 현상의 비용</th>
							<th style="width: 15%">B. 개선의 비용</th>
							<th style="width: 15%">C. 개선후의 비용</th>
							<th style="width: 15%">효과금액(A - ( B+C ))</th>
							<th>합계</th>
						</tr>
						<tr>
							<th rowspan="6" class="thWidth">
								기계보전비의억제활동
							</th>
							<td class="t_center">
								A1
							</td>
							<td style="text-align: left">
								부품비의 절감<br>
								(부품재생이용, 기타)
							</td>
							<td class="t_center">
								(신작비용)
								<input type="number" id="a1hyn" name="a1hyn" onchange="calcu_sums()"  title="" placeholder="" value="0"/>
							</td>
							<td>
								(재생비용)
								<input type="number" id="a1cst" name="a1cst" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td>
							</td>
							<td class="t_right" id="a1hyo">
								0
							</td>
							<td rowspan="6" class="t_right"> 
								<span id="aSum"></span>
								천원/Y
							</td>
						</tr>
						<tr>
							<td class="t_center">
								A2
							</td>
							<td>
								부품비의 절감<br>
								(유휴, 중고품의 사용)
							</td>
							<td>
								(신작비용)
								<input type="number" name="a2hyo" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td></td>
							<td></td>
							<td id="a2hyo">
								0
							</td>
						</tr>
						<tr>
							<td class="t_center">
								A3
							</td>
							<td>
								부품비의 절감<br>
								(저가품에의 변경, 기타)
							</td>
							<td>
								
								<input type="number" name="a3hyn" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td>
								(교체부품비)
								<input type="number" name="a3cst" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td>
							</td>
							<td id="a3hyo">
								0
							</td>
						</tr>
						<tr>
							<td class="t_center">
								A4
							</td>
							<td>
								부품비의 절감<br>
								(부품의 수명 연장, 기타)
							</td>
							<td>
								천원 X회/Y
								<input type="number" name="a4hyn" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td>
								<input type="number" name="a4cst" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td>
								천원 X회/Y
								<input type="number" name="a4aft" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td id="a4hyo">
							0
							</td>
						</tr>
						<tr>
							<td class="t_center">
								A5
							</td>
							<td>
								부품비의 절감<br>
								(MAKER 변경, 기타)
							</td>
							<td>
								(현상의 비용)
								<input type="number" name="a5hyn" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td></td>
							<td>
								(변경후의 비용)
								<input type="number" name="a5aft" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td id="a5hyo">
							0
							</td>
						</tr>
						<tr>
							<td class="t_center">
								A6
							</td>
							<td>
								부품비의 절감<br>
								(시공 방법의 변경, 기타)
							</td>
							<td>
								(현상의 비용)
								<input type="number" name="a6hyn" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td>
								(현상의 비용)
								<input type="number" name="a6cst" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td>
								(변경후의 비용)
								<input type="number" name="a6aft" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td id="a6hyo">
							0
							</td>
						</tr>
						<tr class="h10">
						</tr>
						<tr>
							<th rowspan="4" class="thWidth">
								생산성향상활동
							</th>
							<td class="thWidth t_center">
								B1
							</td>
							<td class="t_right" style="width: 15%">
								인건비(공수)의 절감<br>
								(고장 대책등에 의한)
							</td>
							<td class="t_center" style="width: 15%">
								H/Y
								<input type="number" name="b1hyn" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td style="width: 15%">
								<input type="number" name="b1cst" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td style="width: 15%">
								H/Y
								<input type="number" name="b1aft" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td id="b1hyo" class="t_right" style="width: 15%">
							0
							</td>
							<td rowspan="4" class="t_right">
								<span id="bSum"></span> 
								천원/Y
							</td>
						</tr>
						<tr>
							<td class="t_center">
								B2
							</td>
							<td>
								인건비(공수)의 절감<br>
								(업무의 개선, 개량)
							</td>
							<td>
								H/Y
								<input type="number" name="b2hyn" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td>
								<input type="number" name="b2cst" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td>
								H/Y
								<input type="number" name="b2aft" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td id="b2hyo">
							0
							</td>
						</tr>
						<tr>
							<td class="t_center">
								B3
							</td>
							<td>
								인건비(공수)의 절감<br>
								(품질 향상 대책에 의한)
							</td>
							<td>
								H/Y
								<input type="number" name="b3hyn" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td>
								<input type="number" name="b3cst" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td>
								H/Y
								<input type="number" name="b3aft" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td id="b3hyo">
							0
							</td>
						</tr>
						<tr>
							<td class="t_center">
								B4
							</td>
							<td>
								인건비(공수)의 절감<br>
								(가동율 향상 대책에 의한)
							</td>
							<td>
								OP인원수XC/T(H)
								<input type="number" name="b4hyn" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td>
								<input type="number" name="b4cst" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td>
								OP인원수XC/T(H)
								<input type="number" name="b4aft" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td id="b4hyo">
							0
							</td>
						</tr>
						<tr class="h10">
						</tr>
						<tr>
							<th rowspan="20" class="thWidth">
								설비에<br>관한개선활동
							</th>
							<td class="thWidth t_center">
								C1
							</td>
							<td class="t_right" style="width: 15%">
								고장손실비의 절감<br>
								(고장의재발 방지 대책)
							</td>
							<td class="t_center" style="width: 15%">
								(고장 정지 시간) H/Y
								<input type="number" name="c1hyn" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td style="width: 15%">
								<input type="number" name="c1cst" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td style="width: 15%">
								(고장 정지 시간) H/Y
								<input type="number" name="c1aft" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td id="c1hyo" class="t_right" style="width: 15%">
							0
							</td>
							<td rowspan="4" class="t_right"> 
								<span id="cSum"></span>
								천원/Y
							</td>
						</tr>
						<tr>
							<td class="t_center">
								C2
							</td>
							<td>
								고장손실비의 절감<br>
								(쵸크정지 재발 방지 대책)
							</td>
							<td>
								(쵸크 정지 시간) H/Y
								<input type="number" name="c2hyn" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td>
								<input type="number" name="c2cst" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td>
								(쵸크 정지 시간) H/Y
								<input type="number" name="c2aft" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td id="c2hyo">
							0
							</td>
						</tr>
						<tr>
							<td class="t_center">
								C3
							</td>
							<td>
								재료비의 절감
							</td>
							<td>
								(단가/ 워크 1개)원
								<input type="number" name="c3hyn" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td>
								(년간생산개수)
								<input type="number" name="c3cst" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td>
								(단가/ 워크 1개)원
								<input type="number" name="c3aft" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td id="c3hyo">
							0
							</td>
						</tr>
						<tr>
							<td class="t_center">
								C4
							</td>
							<td>
								안전대책의 효과
							</td>
							<td>
								<input type="number" name="c4hyn" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td>
								<input type="number" name="c4cst" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td>
								<input type="number" name="c4aft" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td id="c4hyo">
							0
							</td>
						</tr>
						<tr class="h10">
						</tr>
						<tr>
							<td class="t_center">
								11
							</td>
							<td>
								O I L 비용의 절감
							</td>
							<td>
								<input type="number" name="d1hyn" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td>
								<input type="number" name="d1cst" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td>
								<input type="number" name="d1aft" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td id="d1hyo">
							0
							</td>
							<td rowspan="16" class="t_right">
								<span id="dSum"></span>
								천원/Y
							</td>
						</tr>
						<tr>
							<td class="t_center">
								12
							</td>
							<td>
								도료비의 절감
							</td>
							<td>
								<input type="number" name="d2hyn" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td>
								<input type="number" name="d2cst" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td>
								<input type="number" name="d2aft" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td id="d2hyo">
							0
							</td>
						</tr>
						<tr>
							<td class="t_center">
								13
							</td>
							<td>
								약품비의 절감
							</td>
							<td>
								<input type="number" name="d3hyn" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td>
								<input type="number" name="d3cst" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td>
								<input type="number" name="d3aft" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td id="d3hyo">
							0
							</td>
						</tr>
						<tr>
							<td class="t_center">
								15
							</td>
							<td>
								용도품비의 절감
							</td>
							<td>
								<input type="number" name="d5hyn" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td></td>
							<td>
								<input type="number" name="d5aft" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td id="d5hyo">
							0
							</td>
						</tr>
						<tr>
							<td class="t_center">
								17
							</td>
							<td>
								소모공구비의 절감
							</td>
							<td>
								<input type="number" name="d7hyn" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td>
								<input type="number" name="d7cst" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td>
								<input type="number" name="d7aft" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td id="d7hyo">
							0
							</td>
						</tr>
						<tr>
							<td class="t_center">
								18
							</td>
							<td>
								공구비의 절감
							</td>
							<td>
								<input type="number" name="d8hyn" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td></td>
							<td>
								<input type="number" name="d8aft" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td id="d8hyo">
							0
							</td>
						</tr>
						<tr>
							<td class="t_center">
								20
							</td>
							<td>
								치구비의 절감
							</td>
							<td>
								<input type="number" name="dbhyn" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td>
								<input type="number" name="dbcst" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td>
								<input type="number" name="dbaft" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td id="dbhyo">
							0
							</td>
						</tr>
						<tr>
							<td class="t_center">
								21
							</td>
							<td>
								계측비의 절감
							</td>
							<td>
								<input type="number" name="dchyn" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td></td>
							<td>
								<input type="number" name="dcaft" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td> 
							<td id="dchyo">
							0
							</td>
						</tr>
						<tr>
							<td class="t_center">
								22
							</td>
							<td>
								금형비의 절감
							</td>
							<td>
								<input type="number" name="ddhyn" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td>
								<input type="number" name="ddcst" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td>
								<input type="number" name="ddaft" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td id="ddhyo">
							0
							</td>
						</tr>
						<tr>
							<td class="t_center">
								24
							</td>
							<td>
								기기비품비의 절감
							</td>
							<td>
								<input type="number" name="dehyn" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td></td>
							<td>
								<input type="number" name="deaft" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td id="dehyo">
							0
							</td>
						</tr>
						<tr>
							<td class="t_center">
								31
							</td>
							<td>
								수선비의 절감
							</td>
							<td>
								<input type="number" name="dfhyn" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td>
								<input type="number" name="dfcst" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td>
								<input type="number" name="dfaft" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td id="dfhyo">
							0
							</td>
						</tr>
						<tr>
							<td class="t_center">
								32
							</td>
							<td>
								에네지로스의 절감
							</td>
							<td>
								<input type="number" name="dghyn" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td>
								<input type="number" name="dgcst" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td>
								<input type="number" name="dgaft" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td id="dghyo">
							0
							</td>
						</tr>
						<tr>
							<td class="t_center">
								48
							</td>
							<td>
								외주위탁비의 절감
							</td>
							<td>
								<input type="number" name="dhhyn" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td></td>
							<td>
								<input type="number" name="dhaft" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td id="dhhyo">
							0
							</td>
						</tr>
						<tr>
							<td class="t_center">
								51
							</td>
							<td>
								청소비의 절감
							</td>
							<td>
								<input type="number" name="dihyn" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td>
								<input type="number" name="dicst" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td>
								<input type="number" name="diaft" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td id="dihyo">
							0
							</td>
						</tr>
						<tr>
							<td class="t_center">
								53
							</td>
							<td>
								仕損費의 절감
							</td>
							<td>
								<input type="number" name="djhyn" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td>
								<input type="number" name="djcst" onchange="calcu_sums()" title="" placeholder="" value="0"/>
							</td>
							<td></td>
							<td id="djhyo">
							0
							</td>
						</tr>
					</tbody>
				</table>
			</c:otherwise>	
		</c:choose>
		
		<div class="sssgap"></div>
		<div class="lastDiv">
			<div class="imgGroup">
				<span>개선전</span>
				<div class="imgDiv">
					<img src="/data/DIONE_UPDOWN_FILE${fn:trim(imprvDomain.imgbf)}" alt="개선전 이미지"/>
				</div>
				<div class="btnDiv fr">
					<form>
						<label for="imgbf" class="AXButton Blue">도면파일선택</label>
						<input type="file" id="imgbf" class="imgInput" name="imgbf" data-type="imgbf"/>
						<button type="button" class="AXButton Red imgUpBtn">
							<%-- <spring:message code='label.save'/> --%><!-- 저장 -->
							도면등록변경
						</button>
						<input type="hidden" class="compare" value="${fn:trim(imprvDomain.imgbf)}" disabled/>
					</form>
					<div class="sssgap"></div>
					<button type="button" class="AXButton normal imgCancleBtn" data-target="imgbf">
						<%-- <spring:message code='label.save'/> --%><!-- 저장 -->
						그림취소
					</button>
				</div>
			</div>
			<div class="fr imgGroup">
				<span>개선후</span>
				<div class="imgDiv">
					<img src="/data/DIONE_UPDOWN_FILE${fn:trim(imprvDomain.imgaf)}" alt="개선후 이미지"/>
				</div>
				<div class="btnDiv fr">
					<form>
						<label for="imgaf" class="AXButton Blue">도면파일선택</label>
						<input type="file" id="imgaf" class="imgInput" name="imgaf" data-type="imgaf"/>
						<button type="button" class="AXButton Red imgUpBtn">
							<%-- <spring:message code='label.save'/> --%><!-- 저장 -->
							도면등록변경
						</button>
						<input type="hidden" class="compare" value="${imprvDomain.imgbf}" disabled/>
					</form>
					<div class="sssgap"></div>
					<button type="button" class="AXButton normal imgCancleBtn" data-target="imgaf">
						<%-- <spring:message code='label.save'/> --%><!-- 저장 -->
						그림취소
					</button>
				</div>
			</div>
		</div>
	</form:form>
</div>
</c:if>
