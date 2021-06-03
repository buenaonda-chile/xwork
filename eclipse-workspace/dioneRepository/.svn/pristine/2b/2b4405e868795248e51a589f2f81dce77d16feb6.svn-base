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

<link rel="stylesheet" media="all" href="/css/wafCommon.css"/>
<script type="text/javascript">
	$(document.body).ready(function () {
		$('[data-ax5formatter]').ax5formatter();
		
		$('.close').click(function(){
			self.close();
		});
		
		$('.ubiRpt').click(function(){
			var comps = $('#comps').val();
			var jisno = $('#jisno').val();
			window.open("/WAF001PsogmSearch/ubiReportPop.do?jisno=" + jisno + "&comps=" + comps,"resultPop","width=1080,height=845,scrollbars=yes,top=100,left=100");
		});
	});
</script>

<style>

	.waf_wrap table:nth-child(2) {
		border-top: none;
		margin-bottom: 5px;
	}
	.ul_wrap_tr ul{
		text-align: center;
	}
	
	.ul_wrap_tr li {
		display: inline-block;
		width: 16%;
		vertical-align: top;
	}
	
	.last_tbl_r1, .last_tbl_r2 {
		width: 100%;
		heigth: 180px;
		vertical-align: top;
	}
	
	.last_tbl_r2 {
		height: 115px;
	}
	
	.waf_wrap .last_tbl_r1 td  {
		height: 70px;
	}
	
	.changeUnitTable {
		height: 114px;
	    margin-bottom: 5px;
	    overflow: auto;
	    border: 1px solid #bbb;
	}
	
	.changeUnitTable table {
		border: none;
	}
	
</style>
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%-- 조회권한 --%>
	
	<c:if test="${resultDomain eq null }">
		<script type="text/javascript">
			
				toastMsg(LN_NO_DATA);
		</script>	
	</c:if>
	
	<div class="waf_wrap">
		<div>
			<table class="pd-s-table">
				<caption>사업부 선택표</caption>
				<colgroup></colgroup>
				<tbody>
					<tr>
						<th>지시 No</th>
						<td>
							<input type="text" style="width: 65%" value="<c:out value="${resultDomain.jisno}"/>" readonly>
						</td>
						<td colspan="4">
							<div style="text-align: right">
								<button class="black btn-st02 ubiRpt" type="button">
									<span>발행</span>
								</button>
								<button class="black btn-st02 close" type="button">
									<span>닫기</span>
								</button>
								<input type="hidden" id="comps" value="<c:out value="${comps}"/>"/>
								<input type="hidden" id="jisno" value="<c:out value="${jisno}"/>"/>
							</div>
						</td>
					</tr>
					<tr>
						<th>설비 No</th>
						<td>
							<input type="text" style="width: 30%" value="<c:out value="${resultDomain.mshno}"/>" readonly>
							<input type="text" style="width: 54%" value="<c:out value="${resultDomain.mshnm}"/>" readonly>
						</td>
						<th>보전방법</th>
						<td>
							<input type="text" style="width: 20%" value="<c:out value="${resultDomain.jobcd}"/>" readonly>
							<input type="text" style="width: 64%" value="<c:out value="${resultDomain.jobnm}"/>" readonly>
						</td>
						<th>기능저하</th>
						<td>
							<input type="text" style="width: 20%" value="<c:out value="${resultDomain.kdown}"/>" readonly> %
						</td>
					</tr>
					<tr>
						<th>내 외 구 분</th>
						<td>
							<input type="text" style="width: 20%" value="<c:out value="${resultDomain.inocd}"/>" readonly>
							<input type="text" style="width: 64%" value="<c:out value="${resultDomain.inonm}"/>" readonly>
						</td>
						<th>우 선 도</th>
						<td>
							<input type="text" style="width: 20%" value="<c:out value="${resultDomain.emgcd}"/>" readonly>
							<input type="text" style="width: 64%" value="<c:out value="${resultDomain.emgry}"/>" readonly>
						</td>
						<th>품 질 확 인</th>
						<td>
							<input type="text" style="width: 20%" value="<c:out value="${resultDomain.qorcd}"/>"  readonly>
							<input type="text" style="width: 64%" value="<c:out value="${resultDomain.qornm}"/>"  readonly>
						</td>
					</tr>
					<tr class="ul_wrap_tr">
						<th>작업개소</th>
						<td colspan="5">
							<div>
								<ul>
									<li>
										<h3>설비부위분류</h3>
										<input type="text" placeholer="" title="" value="<c:out value="${resultDomain.subas}"/>"  readonly/>
										<input type="text" placeholer="" title="" value="<c:out value="${resultDomain.assnm}"/>"  readonly/>
									</li>
									<li>
										<h3>ASSY NO</h3>
										<input type="text" placeholer="" title="" value="<c:out value="${resultDomain.assno}"/>"  readonly/>
									</li>
									<li>
										<h3>ASSY부품</h3>
										<input type="text" placeholer="" title="" value="<c:out value="${resultDomain.comcd}"/>"  readonly/>
										<input type="text" placeholer="" title="" value="<c:out value="${resultDomain.cpart}"/>"  readonly/>
									</li>
									<li>
										<h3>단위부품</h3>
										<input type="text" placeholer="" title="" value="<c:out value="${resultDomain.deccd}"/>"  readonly/>
										<input type="text" placeholer="" title="" value="<c:out value="${resultDomain.dpart}"/>"  readonly/>
									</li>
									<li>
										<h3>부품 No</h3>
										<input type="text" placeholer="" title="" value="<c:out value="${resultDomain.prtno}"/>"  readonly/>
									</li>
									<li>
										<h3>처치</h3>
										<input type="text" placeholer="" title="" value="<c:out value="${resultDomain.chocd}"/>"  readonly/>
										<input type="text" placeholer="" title="" value="<c:out value="${resultDomain.chonm}"/>"  readonly/>
									</li>
									
								</ul>
							</div>
						</td>
					</tr>
					<tr>
						<th>현상</th>
						<td>
							<input type="text" style="width: 20%;" placeholer="" title="" value="<c:out value="${resultDomain.hyocd}"/>"  readonly/>
							<input type="text" style="width: 64%;" placeholer="" title="" value="<c:out value="${resultDomain.hyonm}"/>"  readonly/>
						</td>
						<th>원인</th>
						<td>
							<input type="text" style="width: 20%;" placeholer="" title="" value="<c:out value="${resultDomain.caucd}"/>"  readonly/>
							<input type="text" style="width: 64%;" placeholer="" title="" value="<c:out value="${resultDomain.cause}"/>"  readonly/>
						</td>
						<th>실원인</th>
						<td>
							<input type="text" style="width: 20%;" placeholer="" title="" value="<c:out value="${resultDomain.trucd}"/>"  readonly/>
							<input type="text" style="width: 64%;" placeholer="" title="" value="<c:out value="${resultDomain.trunm}"/>"  readonly/>
						</td>
					</tr>
				</tbody>
			</table>
			<table class="pd-s-table">
				<caption>사업부 선택표</caption>
				<colgroup></colgroup>
				<tbody>
					<tr>
						<th>발생시각</th>
						<td style="width: 213px;">
							<c:if test="${resultDomain.padat eq 0}">
								${resultDomain.padat = ""}
							</c:if>
							<input type="text" style="width: 64%;" placeholer="yyyy-mm-dd" data-ax5formatter="date" title="" value="<c:out value="${resultDomain.padat}"/>"  readonly/>
							<input type="text" style="width: 20%;" placeholder="hh:mi" data-ax5formatter="time" title="" value="<c:out value="${resultDomain.patim}"/>"  readonly/>
						</td>
						<th>수리대기시간</th>
						<td>
							<input type="text" style="width: 65%;" placeholer="" title="" value="<c:out value="${resultDomain.wathr}"/>"  readonly/>
						</td>
						<th>설비정지시간</th>
						<td>
							<input type="text" style="width: 65%;" placeholer="" title="" value="<c:out value="${resultDomain.stphr}"/>"  readonly/>
						</td>
						<th>보전공수</th>
						<td>
							<input type="text" style="width: 65%;" placeholer="" title="" value="<c:out value="${resultDomain.tothr}"/>"  readonly/>
						</td>
					</tr>
					<tr>
						<th>의뢰시각</th>
						<td style="width: 213px;">
							<c:if test="${resultDomain.urdat eq 0}">
								${resultDomain.urdat = ""}
							</c:if>
							<input type="text" style="width: 64%;" placeholer="yyyy-mm-dd" data-ax5formatter="date" title="" value="<c:out value="${resultDomain.urdat}"/>"  readonly/>
							<input type="text" style="width: 20%;" placeholder="hh:mi" data-ax5formatter="time" title="" value="<c:out value="${resultDomain.urtim}"/>"  readonly/>
						</td>
						<th>책임자</th>
						<td colspan="5">
							<input type="text" style="width: 15%;" placeholer="" title="" value="<c:out value="${resultDomain.wrkm}"/>"  readonly/>
							<input type="text" style="width: 15%;" placeholer="" title="" value="<c:out value="${resultDomain.kornm}"/>"  readonly/>
							<input type="text" style="width: 50%;" placeholer="" title="" value="<c:out value="${resultDomain.sdpnm}"/>"  readonly/>
						</td>
					</tr>
					<tr>
						<th>개시시각</th>
						<td style="width: 213px;">
							<c:if test="${resultDomain.ksdat eq 0}">
								${resultDomain.ksdat = ""}
							</c:if>
							<input type="text" style="width: 64%;"  placeholder="yyyy-mm-dd" data-ax5formatter="date" title="" value="<c:out value="${resultDomain.ksdat}"/>"  readonly/>
							<input type="text" style="width: 20%;"  placeholder="hh:mi" data-ax5formatter="time" title="" value="<c:out value="${resultDomain.kstim}"/>"  readonly/>
						</td>
						<th>부책임자</th>
						<td colspan="5">
							<c:if test="${resultDomain.wrkm2 eq 0}">
								${resultDomain.wrkm2 = ""}
							</c:if>
							<input type="text" style="width: 15%;" placeholer="" title="" value="<c:out value="${resultDomain.wrkm2}"/>"  readonly/>
							<input type="text" style="width: 15%;" placeholer="" title="" value="<c:out value="${resultDomain.kornm2}"/>"  readonly/>
							<input type="text" style="width: 50%;" placeholer="" title="" value="<c:out value="${resultDomain.sdpnm2}"/>"  readonly/>
						</td>
					</tr>
					<tr>
						<th>완료시각</th>
						<td style="width: 213px;">
							<c:if test="${resultDomain.wndat eq 0}">
								${resultDomain.wndat = ""}
							</c:if>
							<input type="text" style="width: 64%;" placeholder="yyyy-mm-dd" data-ax5formatter="date" title="" value="<c:out value="${resultDomain.wndat}"/>"  readonly/>
							<input type="text" style="width: 20%;" placeholder="hh:mi" data-ax5formatter="time"  title="" value="<c:out value="${resultDomain.wntim}"/>"  readonly/>
						</td>
						<th>외주업자</th>
						<td colspan="2">
							<input type="text" style="width: 65%;" placeholer="" title="" value="<c:out value="${resultDomain.subcn}"/>"  readonly/>
						</td>
						<th>비용</th>
						<td colspan="2">
							<input type="text" style="width: 20%;" placeholer="" title="" value="<c:out value="${resultDomain.scost}"/>"  readonly/>
						</td>
					</tr>
					<tr>
						<th>생산장애시간</th>
						<td style="width: 214px;" colspan="4">
							<input type="text" style="width: 20%;" placeholer="" title="" value="<c:out value="${resultDomain.janhr}"/>"  readonly/> H
						</td>
						<th>효과금액</th>
						<td colspan="2">
							<input type="text" style="width: 65%;" placeholer="" title="" value="<c:out value="${resultDomain.ecost}"/>"  readonly/> 천원/Y
						</td>
					</tr>
					<tr>
						<th>재발방지</th>
						<td style="width: 213px;">
							<input type="text" style="width: 20%;" placeholer="" title="" value="<c:out value="${resultDomain.repcd}"/>"  readonly/> 
							<input type="text" style="width: 64%;" placeholer="" title="" value="<c:out value="${resultDomain.repnm}"/>"  readonly/>
						</td>
						<th>효과구분</th>
						<td style="width: 214px;" colspan="2">
							<input type="text" style="width: 15%;" placeholer="" title="" value="<c:out value="${resultDomain.effcd}"/>"  readonly/> 
							<input type="text" style="width: 64%;" placeholer="" title="" value="<c:out value="${resultDomain.effnm}"/>"  readonly/>
						</td>
						<th>부품비</th>
						<td  colspan="2">
							<input type="text" style="width: 65%;" placeholer="" title="" value="<c:out value="${resultDomain.pcost}"/>"  readonly/> 천원/Y
						</td>
					</tr>
				</tbody>
			</table>
			<table class="pd-s-table last_tbl">
				<caption>사업부 선택표</caption>
				<colgroup></colgroup>
				<tbody>
					<tr>
						<th>현상파악</th>
						<td><textarea><c:out value="${resultDomain.hyosn}"/></textarea></td>
					</tr>
					<tr>
						<th>원인추구</th>
						<td><textarea><c:out value="${resultDomain.wonin}"/></textarea></td>
					</tr>
					<tr>
						<th>처치</th>
						<td><textarea><c:out value="${resultDomain.daech}"/></textarea></td>
					</tr>
				</tbody>
			</table>
			<div class="r_tbl_wrap">
				<div class="changeUnitTable">
					<table class="pd-s-table last_tbl_r1">
						<caption>사업부 선택표</caption>
						<colgroup></colgroup>
						<tbody>
							<tr>
								<th>부품명</th>
								<th>규격</th>
								<th>수량</th>
								<th>금액</th>
							</tr>
							<c:if test="${fn:length(replaceProduct) > 0 }">
								<c:forEach var = "replaceDomain" items="${replaceProduct}" varStatus="status">
									<tr>
										<td><c:out value="${replaceDomain.prtnm}"/></td>
										<td><c:out value="${replaceDomain.ptype}"/></td>
										<td><c:out value="${replaceDomain.quaty}"/></td>
										<td><c:out value="${replaceDomain.amont}"/></td>
									</tr>
								</c:forEach>
							</c:if>
						</tbody>
					</table>
				</div>
				<table class="pd-s-table last_tbl_r2" style="border-top: 1px solid #bbb;">
					<caption></caption>
					<colgroup></colgroup>
					<tbody>
						<tr>
							<th>비고</th>
							<td><textarea><c:out value="${resultDomain.cnote}"/></textarea></td>
						</tr>
					</tbody>
				</table>
			</div>	
		</div>
	</div>

</c:if>