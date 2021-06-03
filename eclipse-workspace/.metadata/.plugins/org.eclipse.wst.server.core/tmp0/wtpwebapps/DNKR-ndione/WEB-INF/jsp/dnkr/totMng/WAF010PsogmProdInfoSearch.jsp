<%--
 * PROJECT：
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

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/board.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/content.css?ver=1" />
<script src="${pageContext.request.contextPath}/js/content.js"></script>

<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%-- 조회권한 --%>
	<!--생산 정보 조회 cont_s-->
		<div class="gm_04_01_03_wrap">
			<form>
				<div class="list-top">
					<div class="fl mr20">
						<span><strong>사업부</strong></span>
						<select name="sv" title="사업부를 선택해주세요" class="sel-st01" style="width:100px;">
							<option>사업부전체</option>
							<option>PS</option>
							<option>PS</option>
							<option>PS</option>
							<option>PS</option>
						</select>	
					</div>
					<div class="date fl">
						<div class="pr20">
							<span><strong>작업일자</strong></span>&nbsp;
							<div class="date-inwrap">
								<span class="calendar_icon vcen2 c1"></span>
								<input class="boxform tc w90px" value="2018-02-02" readonly="" type="text" style="width:130px;">
							</div>
						</div>
					</div><!--date-->
					<div class="fr">
						<button class="btn-st01 green" type="submit" name="exel">
							<span>엑셀</span>
						</button>
						<button class="view-bnt-big" type="submit" name="Search">
							<span>조회</span>
						</button>
					</div>
				</div><!--list-top-->
	
				<div class="ssgap"></div>
	
				<div class="cont">
					<div class="lfbox-wrap">
						<div class="left-box ms">
							<div class="dtb01">
								<table class="tc tForm3 pd-s">
									<caption>번호,공정코드,공정명 내용이 담긴 표</caption>
									<colgroup>
										<col width="20%">
										<col width="30%">
										<col width="50%">
									</colgroup>
									<thead>
										<tr>
											<th>번호</th>
											<th>공정코드</th>
											<th>공정명</th>
										</tr>
									</thead>
								</table>
							</div>
							<div class="thfFix Fix01"  data-mcs-theme="pink">
								<table class="tc tForm3 pd-s">
									<caption>번호,공정코드,공정명 내용이 담긴 표</caption>
									<colgroup>
										<col width="20%">
										<col width="30%">
										<col width="50%">
									</colgroup>
									<tbody>
										<tr>
											<td>1</td>
											<td>C-01</td>
											<td>C032 조립 12</td>
										</tr>
										<tr>
											<td>1</td>
											<td>C-01</td>
											<td>C032 조립 12</td>
										</tr>
										<tr>
											<td>1</td>
											<td>C-01</td>
											<td>C032 조립 12</td>
										</tr>
										<tr>
											<td>1</td>
											<td>C-01</td>
											<td>C032 조립 12</td>
										</tr>
										<tr>
											<td>1</td>
											<td>C-01</td>
											<td>C032 조립 12</td>
										</tr>
										<tr>
											<td>1</td>
											<td>C-01</td>
											<td>C032 조립 12</td>
										</tr>
										<tr>
											<td>1</td>
											<td>C-01</td>
											<td>C032 조립 12</td>
										</tr>
										<tr>
											<td>1</td>
											<td>C-01</td>
											<td>C032 조립 12</td>
										</tr>
										<tr>
											<td>1</td>
											<td>C-01</td>
											<td>C032 조립 12</td>
										</tr>
										<tr>
											<td>1</td>
											<td>C-01</td>
											<td>C032 조립 12</td>
										</tr>
										<tr>
											<td>1</td>
											<td>C-01</td>
											<td>C032 조립 12</td>
										</tr>
										<tr>
											<td>1</td>
											<td>C-01</td>
											<td>C032 조립 12</td>
										</tr>
										<tr>
											<td>1</td>
											<td>C-01</td>
											<td>C032 조립 12</td>
										</tr>
										<tr>
											<td>1</td>
											<td>C-01</td>
											<td>C032 조립 12</td>
										</tr>
										<tr>
											<td>1</td>
											<td>C-01</td>
											<td>C032 조립 12</td>
										</tr>
										<tr>
											<td>1</td>
											<td>C-01</td>
											<td>C032 조립 12</td>
										</tr>
										<tr>
											<td>1</td>
											<td>C-01</td>
											<td>C032 조립 12</td>
										</tr>
										<tr>
											<td>1</td>
											<td>C-01</td>
											<td>C032 조립 12</td>
										</tr>
										<tr>
											<td>1</td>
											<td>C-01</td>
											<td>C032 조립 12</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="lfbox-side ms">
							<ul class="pj-smtab">
								<li class="over first"><a href="#"><span>생산작업지시</span></a></li>
								<li><a href="#"><span>일일 작업 일보</span></a></li>
								<li><a href="#"><span>일별 이상발생 시간</span></a></li>
								<li class="last"><a href="#"><span>불량처리</span></a></li>
							</ul>
	
							<div class="sssgap"></div>
	
							<div class="inner-line2">
								<div class="board-bList-wrap">
									<table class="time">
										<caption>주야구분 선택표</caption>
										<colgroup>
											<col width="*">
											<col width="*">
											<col width="*">
										</colgroup>
										<tbody>
											<tr>
												<td>
													<input name="coType" value="" id="coType-01" class="radio-st01" type="radio"><label for="coType-01"><span class="radio-deco"></span> 주간</label>
												</td>
												<td>
													<input name="coType" value="" id="coType-02" class="radio-st01" type="radio"><label for="coType-02"><span class="radio-deco"></span> 야간</label>
												</td>
												<td>
													<input name="coType" value="" id="coType-03" class="radio-st01" type="radio"><label for="coType-03"><span class="radio-deco"></span> 전체</label>
												</td>
											</tr>
										</tbody>
									</table>
								</div>
								<div class="ssgap"></div>
								<p class="s-title-sm">작업 지시</p>
								<div class="inner-line3">
								<div class="dtb01">
									<table class="tc tForm3 pd-s">
										<caption>번호,주야구분,작업순위,품번,차종,지시수량,텍트타임,소요공수,SEQ 내용이 담긴 표</caption>
										<colgroup>
											<col width="7%">
											<col width="9.5%">
											<col width="9%">
											<col width="10%">
											<col width="15%">
											<col width="12%">
											<col width="13.5%">
											<col width="12%">
											<col width="12%">
										</colgroup>
										<thead>
											<tr>
												<th>번호</th>
												<th>주야구분</th>
												<th>작업순위</th>
												<th>품번</th>
												<th>차종</th>
												<th>지시수량</th>
												<th>텍트타임</th>
												<th>소요공수</th>
												<th>SEQ</th>
											</tr>
										</thead>
										</table>
										</div>
										<div class="thfFix Fix02"  data-mcs-theme="pink">
											<table class="tc tForm3 pd-s">
												<caption>번호,주야구분,작업순위,품번,차종,지시수량,텍트타임,소요공수,SEQ 내용이 담긴 작업지시 내용표</caption>
												<colgroup>
													<col width="7%">
													<col width="9.5%">
													<col width="9%">
													<col width="10%">
													<col width="15%">
													<col width="12%">
													<col width="13.5%">
													<col width="12%">
													<col width="12%">
												</colgroup>
										<tbody>
											<tr>
												<td>1</td>
												<td>주간</td>
												<td>1</td>
												<td>C-031</td>
												<td>가나다</td>
												<td>가나다</td>
												<td>가나다</td>
												<td>가나다</td>
												<td>C032</td>
											</tr>
											<tr>
												<td>1</td>
												<td>주간</td>
												<td>1</td>
												<td>C-031</td>
												<td>가나다</td>
												<td>가나다</td>
												<td>가나다</td>
												<td>가나다</td>
												<td>C032</td>
											</tr>
											<tr>
												<td>1</td>
												<td>주간</td>
												<td>1</td>
												<td>C-031</td>
												<td>가나다</td>
												<td>가나다</td>
												<td>가나다</td>
												<td>가나다</td>
												<td>C032</td>
											</tr>
											<tr>
												<td>1</td>
												<td>주간</td>
												<td>1</td>
												<td>C-031</td>
												<td>가나다</td>
												<td>가나다</td>
												<td>가나다</td>
												<td>가나다</td>
												<td>C032</td>
											</tr>
											<tr>
												<td>1</td>
												<td>주간</td>
												<td>1</td>
												<td>C-031</td>
												<td>가나다</td>
												<td>가나다</td>
												<td>가나다</td>
												<td>가나다</td>
												<td>C032</td>
											</tr>
											<tr>
												<td>1</td>
												<td>주간</td>
												<td>1</td>
												<td>C-031</td>
												<td>가나다</td>
												<td>가나다</td>
												<td>가나다</td>
												<td>가나다</td>
												<td>C032</td>
											</tr>
										</tbody>
									</table>
								</div>
								</div>
	
								<div class="ssgap"></div>
	
								<p class="s-title-sm">생산 합계</p>
								<div class="inner-line3">
								<div class="dtb01">
									<table class="tc tForm3 pd-s">
										<caption>번호,주야구분,작업인원,시작시간,종료시간,작업공수,계획공수,차이공수 내용이 담긴 생산합계 내용표</caption>
										<colgroup>
											<col width="7%">
											<col width="9.5%">
											<col width="9%">
											<col width="17%">
											<col width="17%">
											<col width="13.5%">
											<col width="13.5%">
											<col width="13.5%">
										</colgroup>
										<thead>
											<tr>
												<th>번호</th>
												<th>주야구분</th>
												<th>작업인원</th>
												<th>시작시간</th>
												<th>종료시간</th>
												<th>작업공수</th>
												<th>계획공수</th>
												<th>차이공수</th>
											</tr>
										</thead>
									</table>
									</div>
									<div class="thfFix Fix03" data-mcs-theme="pink">
										<table class="tc tForm3 pd-s">
											<caption>생산합계 내역표</caption>
											<colgroup>
												<col width="7%">
												<col width="9.5%">
												<col width="9%">
												<col width="17%">
												<col width="17%">
												<col width="13.5%">
												<col width="13.5%">
												<col width="13.5%">
											</colgroup>
										<tbody>
											<tr>
												<td>1</td>
												<td>주간</td>
												<td>1</td>
												<td>18.01.20 10:00</td>
												<td>18.01.20 10:00</td>
												<td>가나다</td>
												<td>가나다</td>
												<td>가나다</td>
											</tr>
											<tr>
												<td>1</td>
												<td>주간</td>
												<td>1</td>
												<td>18.01.20 10:00</td>
												<td>18.01.20 10:00</td>
												<td>가나다</td>
												<td>가나다</td>
												<td>가나다</td>
											</tr>
											<tr>
												<td>1</td>
												<td>주간</td>
												<td>1</td>
												<td>18.01.20 10:00</td>
												<td>18.01.20 10:00</td>
												<td>가나다</td>
												<td>가나다</td>
												<td>가나다</td>
											</tr>
										</tbody>
									</table>
									</div>
									<div class="dtb01">
										<table class="tc tForm3 pd-s tfoot">
											<caption>생산합계 내역표</caption>
											<colgroup>
												<col width="7%">
												<col width="9.5%">
												<col width="9%">
												<col width="17%">
												<col width="17%">
												<col width="13.5%">
												<col width="13.5%">
												<col width="13.5%">
											</colgroup>
										<tfoot>
											<tr class="tr ptdnone">
												<th></th>
												<th class="tc">합계</th>
												<th>0</th>
												<th></th>
												<th></th>
												<th>0</th>
												<th>0</th>
												<th>0</th>
											</tr>
										</tfoot>
									</table>
								</div>
								</div>
								<div class="sssgap"></div>
							</div>
						</div><!--lfbox-side-->
					</div>
				</div><!--cont-->
			</form>
		<div class="gap"></div>
	</div><!--생산 정보 조회 cont_e-->
</c:if>