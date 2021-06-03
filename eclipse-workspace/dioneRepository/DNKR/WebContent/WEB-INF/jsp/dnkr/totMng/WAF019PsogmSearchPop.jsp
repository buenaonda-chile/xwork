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

<script type="text/javascript" src="${pageContext.request.contextPath}/js/content.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/waf/WAF019PsogmSearchPop.js"></script>

<link rel="stylesheet" media="all" href="/css/content.css"/>

<style>
	table.gridTbl {
		    table-layout: fixed;
	    border-collapse: separate;
	    border-spacing: 0;
	    border: 0 none;
	    width: 100%;
	    height: 100%;
	    margin: 0;
	    padding: 0;
	    position: relative;
	    overflow: hidden;
	    background-color: #fff;
	    border: 0px none;
	    color: #222;
	    display: table;
	    border: 1px solid #ccc;
	    border-right: none;
	    border-bottom: none;
	}
	
	table.gridTbl tr td{
	    border-right: 1px solid #ccc;
	    border-bottom: 1px solid #ccc;
	    font-size: 12px;
	    cursor: pointer;
	    box-shadow: inset 1px 1px 0px 0px #fff;
	    min-height: 1px;
	    padding: 5px;	 
        /* background-image: linear-gradient(to bottom,#fff,#F0F0F0); */
        /* background: #f3f3f3;    */
	}
	
	table.gridTbl tr:nth-child(6n-2) td,
	table.gridTbl tr:nth-child(6n-1) td,
	table.gridTbl tr:nth-child(6n) td {
	    /* background-image: linear-gradient(to bottom,#ece9e9,#d6d4d4); */
	    /* background: #fff; */
	}
	
	table.gridTbl:nth-child(2n) {
		background: #f3f3f3;
	}
	
	table.gridTbl:hover {
		background: #dcdada;
	}
	
	table.gridTbl tr td.last_td{
		width: 190px;
		text-align: left;
	}
		
	.txt_l {
		text-align: left;
	}
	
	.wid80 {
		width: 80px;
	}
	
	.displayNone {
		display: none;
	}
	
</style>
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%-- 조회권한 --%>
	<div class="gm_01_02_02_wrap">
			<div class="inwrap">
				<div class="list-top">				
					<table>
							<colgroup>
								<col width="*">
								<col width="29%">
								<col width="11%">
								<col width="29%">
								<col width="11%">
							</colgroup>
							<tbody>
								<tr>
									<th rowspan="2" class="tit">직업보고 검색결과
										<div class="sssgap"></div>
										<c:choose>
											<c:when test="${fn:length(searchList) > 0}">
												<input class="text sc-num" value="${fn:length(searchList)}" name="sc-num" title="검색 결과입니다." type="text" readonly>
											</c:when>
											<c:otherwise>
												<input class="text sc-num" value="0" name="sc-num" title="검색 결과입니다." type="text" readonly>
											</c:otherwise>
										</c:choose>
										<span>건</span>
									</th>
									<td class="pd-none">
										<strong>표시전환</strong>
									</td>
									<td rowspan="2" style="padding: 30px 0 0">
										<button class="red btn-st02 btn01" type="" name="Search">
											<span>현상파악</span>
										</button>
									</td>
									<td class="pd-none">
										<strong>텍스트표시</strong>
									</td>
									<td rowspan="2" class="last" >
										<button class="green btn-st02 exel" type="" name="Search">
											<span>엑셀</span>
										</button>
										<div class="sssgap"></div>
										<button class="black btn-st02 close" type="" name="Search">
											<span>닫기</span>
										</button>
									</td>
								</tr>
								<tr>
									<td>
										<button class="black btn-st02 btn02 directorBtn" type="button" data-type="D" data-target="directorTd">
											<span>책임자</span>
										</button>
										<button class="black btn-st02 btn03 wndatBtn" type="button" data-type="D" data-target="wndatTd">
											<span>완료일</span>
										</button>
										<button class="black btn-st02 btn04 jisnoBtn" type="button" data-type="D" data-target="jisnoTd">
											<span>지시No</span>
										</button>
									</td>
									<td>
										<button class="black btn-st02 btn05 hyosnBtn" type="button" data-type="T" data-target="hyosnTd">
											<span>현상</span>
										</button>
										<button class="black btn-st02 btn06 woninBtn" type="button" data-type="T" data-target="woninTd">
											<span>원인</span>
										</button>
										<button class="black btn-st02 btn07 daechBtn" type="button" data-type="T" data-target="daechTd">
											<span>대책</span>
										</button>
									</td>
								</tr>
								
						</tbody></table>
					
				</div><!--list-top-->
				<div class="ssgap"></div>
				<div class="cont">
					
					<c:choose>
						<c:when test="${fn:length(searchList) > 0 }">
							<form id="searchForm" name="searchForm">
								<input type="hidden" name="comps" id="comps" value="${comps}"/>
								
								<input type="hidden" name="prtcd" id="prtcd" value="${paraDomain.prtcd}"/>
								<input type="hidden" name="lincd" id="lincd" value="${paraDomain.lincd}"/>
								<input type="hidden" name="mshno" id="mshno" value="${paraDomain.mshno}"/>
								<input type="hidden" name="kogub" id="kogub" value="${paraDomain.kogub}"/>
								<input type="hidden" name="jobcd" id="jobcd" value="${paraDomain.jobcd}"/>
								<input type="hidden" name="sdpcd" id="sdpcd" value="${paraDomain.sdpcd}"/>
								<input type="hidden" name="wrkm" id="wrkm" value="${paraDomain.wrkm}"/>
								<input type="hidden" name="subas" id="subas" value="${paraDomain.subas}"/>
								<input type="hidden" name="comcd" id="comcd" value="${paraDomain.comcd}"/>
								<input type="hidden" name="deccd" id="deccd" value="${paraDomain.deccd}"/>
								<input type="hidden" name="chocd" id="chocd" value="${paraDomain.chocd}"/>                                        
								<input type="hidden" name="hyocd" id="hyocd" value="${paraDomain.hyocd}"/>
								<input type="hidden" name="caucd" id="caucd" value="${paraDomain.caucd}"/>
								<input type="hidden" name="trucd" id="trucd" value="${paraDomain.trucd}"/>
								<input type="hidden" name="andor" id="andor" value="${paraDomain.andor}"/>
								<input type="hidden" name="hyosn" id="hyosn" value="${paraDomain.hyosn}"/>
								<input type="hidden" name="hyosn2" id="hyosn2" value="${paraDomain.hyosn2}"/>
								<input type="hidden" name="hyosn3" id="hyosn3" value="${paraDomain.hyosn3}"/>
								<input type="hidden" name="wonin" id="wonin" value="${paraDomain.wonin}"/>
								<input type="hidden" name="wonin2" id="wonin2" value="${paraDomain.wonin2}"/>
								<input type="hidden" name="wonin3" id="wonin3" value="${paraDomain.wonin3}"/>
								<input type="hidden" name="daech" id="daech" value="${paraDomain.daech}"/>
								<input type="hidden" name="daech2" id="daech2" value="${paraDomain.daech2}"/>
								<input type="hidden" name="daech3" id="daech3" value="${paraDomain.daech3}"/>
								<input type="hidden" name="wndats" id="wndats" value="${paraDomain.wndats}"/>
								<input type="hidden" name="wndate" id="wndate" value="${paraDomain.wndate}"/>
							</form>
							<c:forEach var = "psogmDomain" items="${searchList}" varStatus="status">
								<table class="gridTbl"  ondblclick="resultPop('${fn:trim(psogmDomain.jisno)}')">
									<tr>
										<td class="wid80">설비</td>
										<td colspan="3" class="txt_l"><c:out value="${psogmDomain.mshno}"/></td>
										<td colspan="3" class="txt_l" style="width: 320px;"><c:out value="${psogmDomain.mshnm}"/></td>
										<td class="wid80 directorTd">책임자</td>
										<td class="wid80 directorTd"><c:out value="${psogmDomain.kornm}"/></td>
										
										<td class="displayNone wid80 wndatTd">완료일</td>
										<td class="wid80 displayNone wndatTd"><c:out value="${psogmDomain.wndat}"/></td>
										
										<td class="wid80 displayNone jisnoTd">지시No</td>
										<td class="wid80 displayNone jisnoTd"><c:out value="${psogmDomain.jisno}"/></td>
										
										<!-- 현상 -->
										<td class="hyosnTd last_td" rowspan="3"><c:out value="${psogmDomain.hyosn}"/></td>
										
										<!-- 원인 -->
										<td class="displayNone last_td woninTd" rowspan="3" ><c:out value="${psogmDomain.wonin}"/></td>
										
										<!-- 대책 -->
										<td class="displayNone last_td daechTd" rowspan="3" ><c:out value="${psogmDomain.daech}"/></td>
									</tr>
									<tr>
										<td colspan="2">보전방법</td>
										<td class="txt_l wid80"><c:out value="${psogmDomain.jobcd}"/></td>
										<td class="wid80"><c:out value="${psogmDomain.jobnm}"/></td>
										<td class="wid80">Assy분류</td>
										<td><c:out value="${psogmDomain.assnm}"/></td>
										<td class="wid80">셋트품</td>
										<td colspan="2" class="txt_l"><c:out value="${psogmDomain.cpart}"/></td>
									</tr>
									<tr>
										<td colspan="2">현상</td>
										<td colspan="2" class="txt_l"><c:out value="${psogmDomain.hyonm}"/></td>
										<td class=" wid80">처치</td>
										<td><c:out value="${psogmDomain.chonm}"/></td>
										<td class=" wid80">분해</td>
										<td colspan="2" class="txt_l"><c:out value="${psogmDomain.dpart}"/></td>
									</tr>
								</table>
							</c:forEach>
						</c:when>
					</c:choose>
					
				</div><!--cont-->
			</div><!--inwrap-->
		</div><!--gm_01_02_02_wrap-->

</c:if>