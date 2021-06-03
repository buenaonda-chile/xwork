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

<div class="sub_Toptit">공지사항관리</div>

<!-- container:S -->
<div id="bLWri-container">
	<div class="board-wrap">
		<div class="boardWri">
			<table class="write_01"
				summary="각 해당하는 항목에 알맞게 내용을 입력해주세요">
				<caption>내용 입력폼</caption>
				<colgroup>
					<col width="90px">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th class="check"><span class="necessary">* </span>작성자</th>
						<td><input name="" value="" class="txtbox-st01 bg-yellow"
							title="이름을 입력해주세요" type="text"></td>
					</tr>
					<tr>
						<th class="tdl"><span class="necessary">* </span>비밀번호</th>
						<td><input name="" class="txtbox-st01 bg-yellow"
							type="password"></td>
					</tr>
					<tr>
						<th class="tdl"><span class="necessary">* </span>제목</th>
						<td><input class="txtbox-st01 bg-yellow" name="" value=""
							type="text"> <span class="Tnotice-wrap"> <input
								name="Tnotice" value="" id="Tnotice" class="input_radio"
								type="checkbox"> <label for="Tnotice">게시판
									상단 고정</span></label> </span></td>
					</tr>
					<tr>
						<th class="tdl"><span class="necessary">* </span>내용</th>
						<td><textarea class="txtarea-st01 bg-yellow" name=""></textarea></td>
					</tr>
					<tr>
						<th class="pd_no">파일첨부</th>
						<td><input class="txtbox-st01" name="upfile[]"
							title="첨부하실 파일을 선택해주세요" type="file">
							<a href="#n" class="fileAdd">+ 추가하기</a></td>
					</tr>

				</tbody>
			</table>
		</div>
		</form>
		<div class="ssgap"></div>

		<div class="btnRight">
			<button type="" onclick="javascript:history.back()" class="btn-st1 bt-gray" name="">취소</button>
			<button class="btn-st1 bt-red" name="">등록</button>
		</div>

		<div class="gap"></div>

	</div>
	<!--board-wrap-->


</div>
<!-- container:E -->