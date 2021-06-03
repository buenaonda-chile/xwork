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

<link rel="stylesheet" href="/css/board.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/content.css?ver" />
<script src="/js/content.js"></script>

<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%-- 조회권한 --%>

	<!--교정등록 cont_s-->
	<div class="gm_03_01_01_wrap">
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
				
				<div class="fr">
					<button class="view-bnt-big" type="submit" name="Pub">
						<span>통보서발행</span>
					</button>
				</div>
			</div><!--list-top-->

			<div class="ssgap"></div>


			<div class="cont" style="/*min-width:840px*/ min-width:590px;">
				<div class="fr">
					<button class="btn-st01 green" type="submit" name="exel">
						<span>엑셀</span>
					</button>
					<button class="btn-st01 black" type="submit" name="Search">
						<span>검색</span>
					</button>
					<button class="btn-st01 black" type="submit" name="receipt">
						<span>교정접수</span>
					</button>
					<button class="btn-st01 red" type="submit" name="save">
						<span>저장</span>
					</button>
					<button class="btn-st01 black" type="submit" name="select">
						<span>선택하기</span>
					</button>
				</div>

				<div class="sssgap"></div>
				<div class="m-scroll">
				<div style="min-width:950px;">
				<div class="board-bList-wrap">
					<table class="pd-s">
						<caption>교정분야선택표</caption>
						<colgroup>
							<col width="65px">
							<col width="85px">
							<col width="85px">
							<col width="75px">
							<col width="65px">
							<col width="*">
							<col width="65px">
							<col width="12%">
							<col width="65px">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th class="bg-gray">교정분야</th>
								<td>
									<input name="coType" value="" id="coType-01" class="radio-st01" type="checkbox"><label for="coType-01"><span class="radio-deco"></span> 측정기</label>
								</td>
								<td>
									<input name="coType" value="" id="coType-02" class="radio-st01" type="checkbox"><label for="coType-02"><span class="radio-deco"></span> 검사구</label>
								</td>
								<td>
									<input name="coType" value="" id="coType-03" class="radio-st01" type="checkbox"><label for="coType-03"><span class="radio-deco"></span> 설비</label>
								</td>
								<th class="bg-gray">정렬순서</th>
								<td>
									<select name="sc-condi" title="검색조건을 선택해주세요" class="sel-st01">
										<option selected>관리번호순</option>
										<option>&nbsp;</option>
										<option>&nbsp;</option>
										<option>&nbsp;</option>
										<option>&nbsp;</option>
									</select>
								</td>
								<th class="bg-gray">사용부서</th>
								<td>
									<select name="sc-condi" title="검색조건을 선택해주세요" class="sel-st01">
										<option selected>가공반</option>
										<option>&nbsp;</option>
										<option>&nbsp;</option>
										<option>&nbsp;</option>
										<option>&nbsp;</option>
									</select>
								</td>
								<th class="bg-gray">예정년월</th>
								<td>
									<select name="sc-condi" title="검색조건을 선택해주세요" class="sel-st01">
										<option selected>2018년03월</option>
										<option>&nbsp;</option>
										<option>&nbsp;</option>
										<option>&nbsp;</option>
										<option>&nbsp;</option>
									</select>
								</td>
							</tr>
						</tbody>
					</table>

				</div>
				
				<div class="sssgap"></div>

				<div class="inner-line3">
				<div class="dtb01">
					<table class="tc tForm3 pd-s">
						<caption>번호,관리번호,장비명,제조회사,형식,장비번호,최종교정일,예정일자,사용부서,구분,처리 내용이 담긴 표</caption>
						<colgroup>
							<col width="4%">
							<col width="8.5%">
							<col width="16%">
							<col width="8%">
							<col width="11.5%">
							<col width="8%">
							<col width="8%">
							<col width="9%">
							<col width="8%">
							<col width="10%">
							<col width="4%">
							<col width="3%">
						</colgroup>
						<thead>
							<tr>
								<th>No</th>
								<th>관리번호</th>
								<th>장비명</th>
								<th>제조회사</th>
								<th>형식</th>
								<th>장비번호</th>
								<th>최종교정일</th>
								<th>교정번호</th>
								<th>예정일자</th>
								<th>사용부서</th>
								<th>구분</th>
								<th>처리</th>
							</tr>
						</thead>
						</table>
						</div>
						<div class="thfFix Fix01"  data-mcs-theme="pink">
							<table class="tc tForm3 pd-s">
								<caption>번호,관리번호,장비명,제조회사,형식,장비번호,최종교정일,예정일자,사용부서,구분,처리 내용이 담긴 표</caption>
								<colgroup>
									<col width="4%">
									<col width="8.5%">
									<col width="16%">
									<col width="8%">
									<col width="11.5%">
									<col width="8%">
									<col width="8%">
									<col width="9%">
									<col width="8%">
									<col width="10%">
									<col width="4%">
									<col width="3%">
								</colgroup>
						<tbody>
							<tr>
								<td>111</td>
								<td>PA0701001</td>
								<td class="tl">HEIGHT GAUGE</td>
								<td>MITUTOYO</td>
								<td class="tl">0~300 0.01mm</td>
								<td>9409418</td>
								<td>2018-03-27</td>
								<td>PSCM17-636</td>
								<td>2018-03-27</td>
								<td>가공반</td>
								<td>사내</td>
								<td><input id="li-select" name="li-select" type="checkbox"></td>
							</tr>
							<tr>
								<td>111</td>
								<td>PA0701001</td>
								<td class="tl">HEIGHT GAUGE</td>
								<td>MITUTOYO</td>
								<td class="tl">0~300 0.01mm</td>
								<td>9409418</td>
								<td>2018-03-27</td>
								<td>PSCM17-636</td>
								<td>2018-03-27</td>
								<td>가공반</td>
								<td>사내</td>
								<td><input id="li-select" name="li-select" type="checkbox"></td>
							</tr>
							<tr>
								<td>111</td>
								<td>PA0701001</td>
								<td class="tl">HEIGHT GAUGE</td>
								<td>MITUTOYO</td>
								<td class="tl">0~300 0.01mm</td>
								<td>9409418</td>
								<td>2018-03-27</td>
								<td>PSCM17-636</td>
								<td>2018-03-27</td>
								<td>가공반</td>
								<td>사내</td>
								<td><input id="li-select" name="li-select" type="checkbox"></td>
							</tr>
							<tr>
								<td>111</td>
								<td>PA0701001</td>
								<td class="tl">HEIGHT GAUGE</td>
								<td>MITUTOYO</td>
								<td class="tl">0~300 0.01mm</td>
								<td>9409418</td>
								<td>2018-03-27</td>
								<td>PSCM17-636</td>
								<td>2018-03-27</td>
								<td>가공반</td>
								<td>사내</td>
								<td><input id="li-select" name="li-select" type="checkbox"></td>
							</tr>
							<tr>
								<td>111</td>
								<td>PA0701001</td>
								<td class="tl">HEIGHT GAUGE</td>
								<td>MITUTOYO</td>
								<td class="tl">0~300 0.01mm</td>
								<td>9409418</td>
								<td>2018-03-27</td>
								<td>PSCM17-636</td>
								<td>2018-03-27</td>
								<td>가공반</td>
								<td>사내</td>
								<td><input id="li-select" name="li-select" type="checkbox"></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			</div>
			</div>
			<div class="sgap"></div>

			<span class="top-border"></span>

			<div class="sgap"></div>
			
				<div class="fr">
					<button class="btn-st01 green" type="submit" name="exel">
						<span>엑셀</span>
					</button>
					<button class="btn-st01 black" type="submit" name="Search">
						<span>검색</span>
					</button>
					<button class="btn-st01 black" type="submit" name="receipt">
						<span>교정접수</span>
					</button>
					<button class="btn-st01 red" type="submit" name="save">
						<span>저장</span>
					</button>
					<button class="btn-st01 black" type="submit" name="select">
						<span>선택하기</span>
					</button>
				</div>

				<div class="sssgap"></div>
				
				<div class="m-scroll">
				<div style="min-width:950px;">
				<div class="board-bList-wrap">
					<table class="pd-s">
						<caption>교정분야선택표</caption>
						<colgroup>
							<col width="65px">
							<col width="85px">
							<col width="85px">
							<col width="75px">
							<col width="65px">
							<col width="*">
							<col width="65px">
							<col width="12%">
							<col width="65px">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th class="bg-gray">교정분야</th>
								<td>
									<input name="coType" value="" id="coType-01" class="radio-st01" type="checkbox"><label for="coType-01"><span class="radio-deco"></span> 측정기</label>
								</td>
								<td>
									<input name="coType" value="" id="coType-02" class="radio-st01" type="checkbox"><label for="coType-02"><span class="radio-deco"></span> 검사구</label>
								</td>
								<td>
									<input name="coType" value="" id="coType-03" class="radio-st01" type="checkbox"><label for="coType-03"><span class="radio-deco"></span> 설비</label>
								</td>
								<th class="bg-gray">정렬순서</th>
								<td>
									<select name="sc-condi" title="검색조건을 선택해주세요" class="sel-st01">
										<option selected>관리번호순</option>
										<option>&nbsp;</option>
										<option>&nbsp;</option>
										<option>&nbsp;</option>
										<option>&nbsp;</option>
									</select>
								</td>
								<th class="bg-gray">사용부서</th>
								<td>
									<select name="sc-condi" title="검색조건을 선택해주세요" class="sel-st01">
										<option selected>가공반</option>
										<option>&nbsp;</option>
										<option>&nbsp;</option>
										<option>&nbsp;</option>
										<option>&nbsp;</option>
									</select>
								</td>
								<th class="bg-gray">교정일자</th>
								<td>
									<select name="sc-condi" title="검색조건을 선택해주세요" class="sel-st01">
										<option selected>2018년03월</option>
										<option>&nbsp;</option>
										<option>&nbsp;</option>
										<option>&nbsp;</option>
										<option>&nbsp;</option>
									</select>
								</td>
							</tr>
						</tbody>
					</table>
				</div>

				<div class="sssgap"></div>

				<div class="inner-line3">
				<div class="dtb01">
					<table class="tc tForm3 pd-s">
						<caption>번호,관리번호,장비명,제조회사,형식,장비번호,최종교정일,예정일자,사용부서,구분,처리 내용이 담긴 표</caption>
						<colgroup>
							<col width="4%">
							<col width="8.5%">
							<col width="16%">
							<col width="8%">
							<col width="11.5%">
							<col width="8%">
							<col width="8%">
							<col width="9%">
							<col width="8%">
							<col width="10%">
							<col width="4%">
							<col width="3%">
						</colgroup>
						<thead>
							<tr>
								<th>No</th>
								<th>관리번호</th>
								<th>장비명</th>
								<th>제조회사</th>
								<th>형식</th>
								<th>장비번호</th>
								<th>최종교정일</th>
								<th>교정번호</th>
								<th>예정일자</th>
								<th>사용부서</th>
								<th>구분</th>
								<th>처리</th>
							</tr>
						</thead>
						</table>
						</div>
						<div class="thfFix Fix01"  data-mcs-theme="pink">
							<table class="tc tForm3 pd-s">
								<caption>번호,관리번호,장비명,제조회사,형식,장비번호,최종교정일,예정일자,사용부서,구분,처리 내용이 담긴 표</caption>
								<colgroup>
									<col width="4%">
									<col width="8.5%">
									<col width="16%">
									<col width="8%">
									<col width="11.5%">
									<col width="8%">
									<col width="8%">
									<col width="9%">
									<col width="8%">
									<col width="10%">
									<col width="4%">
									<col width="3%">
								</colgroup>
						<tbody>
							<tr>
								<td>111</td>
								<td>PA0701001</td>
								<td class="tl">HEIGHT GAUGE</td>
								<td>MITUTOYO</td>
								<td class="tl">0~300 0.01mm</td>
								<td>9409418</td>
								<td>2018-03-27</td>
								<td>PSCM17-636</td>
								<td>2018-03-27</td>
								<td>가공반</td>
								<td>사내</td>
								<td><input id="li-select" name="li-select" type="checkbox"></td>
							</tr>
							
						</tbody>
					</table>
				</div>
			</div>
								</div>
								</div>

			</div><!--cont-->
		</form>
		<div class="gap"></div>
	</div><!--교정등록 cont_e-->

</c:if>