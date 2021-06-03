  
       
        <link media="all" href="/css/board.css" rel="stylesheet"/>
 		<link media="all" href="/css/content.css" rel="stylesheet"/>
		<div class="receipt01_wrap">
			<div class="list-top">
				<div class="left pjr_top">
					<span>기간</span>&nbsp;
					<span class="calendar_icon vcen2 c1"></span>
					<input class="boxform tc w90px" type="text" value="2018-02-02" readonly style="width:120px;">
					~
					<span class="calendar_icon vcen2 c2"></span>
					<input class="boxform tc w90px" type="text" value="2018-02-02" readonly style="width:120px;">
				</div>
				<div class="search">
					<form class="searchForm">
						<select name="sv" title="검색내용을 선택해주세요">
							<option>그룹번호</option>
							<option>접수번호</option>
							<option>Bill No</option>
						</select>
						<input class="search-text" name="sw" title="검색내용을 입력해주세요" type="text"> 
						<button class="search-bnt" type="submit" name="Search">
							<span>검색</span>
						</button> 
					</form>
				</div>
			</div><!--list-top-->
			<div class="gap"></div>
			<table class="tForm">
				<caption></caption>
				<colgroup>
					<col width="12.5%">
					<col width="12.5%">
					<col width="12.5%">
					<col width="12.5%">
					<col width="12.5%">
					<col width="12.5%">
					<col width="12.5%">
					<col width="12.5%">
				</colgroup>
				<thead>
					<tr>
						<th>이름</th>
						<th>여권번호</th>
						<th>전화번호</th>
						<th>E-mail</th>
						<th>대리구분</th>
						<th>VIP</th>
						<th>블랙리스트</th>
						<th>메모</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td class="last">정산금있음</td>
					</tr>
				</tbody>
			</table>
			<div class="gap"></div>
			<div class="table_wrap board-bList-wrap">
				<div class="list-top pb10">
					<div class="left">
						<select>
							<option>전체</option>
							<option>스캐너</option>
							<option>엑셀</option>
							<option>수동</option>
						</select>
					</div>
					<div class="list-bnt fr nopadd">
						<button type="button" class="red">모두 선택</button>
						<button type="button" class="black">선택 확인</button>
					</div>
				</div>
				<span class="top-border"></span>
				<table class="rline">
					<caption>영수증 확인 표</caption>
					<colgroup>
						<col width="1%">
						<col width="1%">
						<col width="*">
						<col width="*">
						<col width="13%">
						<col width="9%">
						<col width="9%">
						<col width="6%">
						<col width="7%">
						<col width="9%">
					</colgroup>
					<thead>
						<tr>
							<th><input id="li-select" name="li-select" type="checkbox"></th>
							<th>접수번호</th>
							<th>이미지</th>
							<th colspan="2">확인</th>
							<th>상세보기</th>
							<th>영수증<br>전체보기</th>
							<th>면세점<br>데이터<br>확인</th>
							<th>정산대상</th>
							<th>확인</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td rowspan="6"><input id="li-select" name="li-select" type="checkbox"></td>
							<td rowspan="6">AZQQ1234</td>
							<td><img src="./img/content/receipt01-1.jpg" alt=""></td>
							<td>1078-170030966</td>
							<td><button type="button" class="btn_type01 gradi-black">확인</button></td>
							<td rowspan="6"><button type="button" class="btn_type01 gradi-red" onclick="location.href='receipt_detailview.html'">보기</button></td>
							<td rowspan="6"><button type="button" class="btn_type01 gradi-red" onclick="location.href='#n'">보기</button></td>
							<td rowspan="6">x</td>
							<td rowspan="6">대기</td>
							<td rowspan="6" class="last">
								<button type="button" class="btn_type01 gradi-black">확인</button><br>
								<button type="button" class="btn_type01 gradi">수정</button><br>
								<button type="button" class="btn_type01 gradi">제외</button>
							</td>
						</tr>
						<tr>
							<td><img src="./img/content/receipt01-2.jpg" alt=""></td>
							<td>17315422</td>
							<td><button type="button" class="btn_type01 gradi-black">확인</button></td>
						</tr>
						<tr>
							<td><img src="./img/content/receipt01-3.jpg" alt=""></td>
							<td>20616250817<br>shu</td>
							<td>
								<button type="button" class="btn_type01 gradi">변경</button>
								<button type="button" class="btn_type01 gradi-black">확인</button>
							</td>
						</tr>
						<tr>
							<td>품목이미지</td>
							<td>상품코드<br>상품명</td>
							<td>
								<button type="button" class="btn_type01 gradi">변경</button>
								<button type="button" class="btn_type01 gradi-black">확인</button>
							</td>
						</tr>
						<tr>
							<td>품목이미지</td>
							<td>상품코드<br>상품명</td>
							<td>
								<button type="button" class="btn_type01 gradi">변경</button>
								<button type="button" class="btn_type01 gradi-black">확인</button>
							</td>
						</tr>
						<tr>
							<td><img src="./img/content/receipt01-4.jpg" alt=""></td>
							<td>44</td>
							<td>
								<button type="button" class="btn_type01 gradi-black">확인</button>
							</td>
						</tr>
						<tr>
							<td><input id="li-select" name="li-select" type="checkbox"></td>
							<td>AZQQ1234</td>
							<td></td>
							<td></td>
							<td></td>
							<td><button type="button" class="btn_type01 gradi-red" onclick="location.href='receipt_detailview.html'">보기</button></td>
							<td><button type="button" class="btn_type01 gradi-red" onclick="location.href='#n'">보기</button></td>
							<td>x</td>
							<td>완료</td>
							<td class="last">
								<button type="button" class="btn_type01 gradi-black">확인</button><br>
								<button type="button" class="btn_type01 gradi">수정</button><br>
								<button type="button" class="btn_type01 gradi">제외</button>
							</td>
						</tr>
						<tr>
							<td><input id="li-select" name="li-select" type="checkbox"></td>
							<td>AZQQ1234</td>
							<td></td>
							<td></td>
							<td></td>
							<td><button type="button" class="btn_type01 gradi-red" onclick="location.href='receipt_detailview.html'">보기</button></td>
							<td><button type="submit" class="btn_type01 gradi-red" onclick="location.href='#n'">보기</button></td>
							<td>x</td>
							<td>제외</td>
							<td class="last">
								<button type="button" class="btn_type01 gradi-black">확인</button><br>
								<button type="button" class="btn_type01 gradi">수정</button><br>
								<button type="button" class="btn_type01 gradi">제외</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div><!--receipt01_wrap-->