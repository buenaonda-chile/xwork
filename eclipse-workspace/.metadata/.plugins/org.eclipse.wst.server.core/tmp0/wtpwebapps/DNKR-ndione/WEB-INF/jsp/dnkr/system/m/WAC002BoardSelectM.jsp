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

<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/WAC001Board.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/WAC001BoardSearch.js" charset="utf-8"></script>

<form name="file_form" method="post" action="/WAC001BoardSearch/downFile.do">
	<input type="hidden" name="boardId" value="${boardTextDomain.boardId}" />
	<input type="hidden" name="idx" value="" /> 
	<input type="hidden" name="fidx" value="" />
</form>

<div class="sub_Toptit">공지사항관리</div>

<!-- container:S -->
<div id="bLViw-container">
	<div class="board-wrap">
		<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%--조회권한 --%>
			<table class="board-Viw tl">
				<caption>
					<span class="blind">''</span>
				</caption>
				<thead>
					<tr>
						<th>
							<p class="btxt">${boardTextDomain.title }</p> 
								<span><strong><spring:message code="label.WAC004.writer" /><!-- 작성자 --></strong> : ${boardTextDomain.writer }</span> 
								<span><strong><spring:message code="label.WAC004.datecreated" /><!-- 작성일자 --></strong> : ${boardTextDomain.regiDtm }</span>
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							<div class="file-set">
								<strong class="file-btxt"><spring:message code="label.WAC004.attachments" /><!-- 파일첨부 --> :</strong>
								<c:forEach var="file" items="${fileList}" varStatus="status">
									<a href="#" onclick="downFile('${file.fidx}','${file.idx }')">
										<img src="/img/board/file_icon.png" alt="첨부파일">${file.realName }
									</a>
								</c:forEach>
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<div id="view-cont">${boardTextDomain.cnts }</div>
						</td>
					</tr>
					<c:if test="${boardTextDomain.prevIdx ne null }">
						<tr>
							<td>
								<span class="prev"><spring:message code="label.WAC004.prev" /><!-- 이전글 --></span>
								<a href="<%= request.getContextPath() %>/WAC002BoardSelect/init.do?boardId=${boardTextDomain.boardId }&idx=${boardTextDomain.prevIdx }">${boardTextDomain.prevTitle }</a>
							</td>
						</tr>
					</c:if>

					<c:if test="${boardTextDomain.nextIdx ne null }">
						<tr>
							<td>
								<span class="next"><spring:message code="label.WAC004.next" /><!-- 다음글 --></span>
								<a href="<%= request.getContextPath() %>/WAC002BoardSelect/init.do?boardId=${boardTextDomain.boardId }&idx=${boardTextDomain.nextIdx }">${boardTextDomain.nextTitle }</a>
							</td>
						</tr>
					</c:if>
				</tbody>
			</table>
		</c:if>
		<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '0' }"><%--조회권한 --%>
			<spring:message code='DNKR-E2-0000' /><!-- 권한이 없습니다. -->
		</c:if>
	</div>


	<div class="ssgap"></div>

	<div class="board-btnRight">
		<a href="<%= request.getContextPath() %>/WAC001BoardSearch/search.do?boardId=${boardTextDomain.boardId }&pageNo=${paging.pageNo}&sv=${paging.sv}&sw=${paging.sw}"class="bt-bakLst red">목록으로</a>
		<!-- <button type="" class="btn-st1 bt-gray" name="">삭제</button>
		<button type="" class="btn-st1 bt-gray" name="" onclick="location.href='board-write.html'">수정
		</button>
		<button type="" class="bt-bakLst" name="" onclick="javascript:history.back()">목록으로
		</button> -->
	</div>

	<div class="gap"></div>
</div>
<!-- container:E -->