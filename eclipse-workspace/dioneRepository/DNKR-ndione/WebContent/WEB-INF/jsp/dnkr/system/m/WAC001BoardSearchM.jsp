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
<link type="text/css" rel="stylesheet" media="all" href="/css/m/content.css">

<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" 	prefix="fn" %> --%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/WAC001Board.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/WAC001BoardSearch.js" charset="utf-8"></script>

<div class="sub_Toptit">공지사항관리</div>

<!-- container:S -->
<div id="bLst-container">
	<form:form action="${pageContext.request.contextPath}/WAC001BoardSearch/search.do" method="POST" onsubmit="searchProc();" modelAttribute="WAC001BoardSearchForm" name="WAC001BoardSearchForm" id="WAC001BoardSearchForm">
		<input type="hidden" name="tabId" value="<c:out value="${tabId}"></c:out>" />
		<input type="hidden" name="boardId" value="${boardId}" />
		<input type="hidden" name="chkIdx" id="chkIdx" />
		<div class="search">
			<div class="width-wrap">
				<select name="sv" title="검색내용을 선택해주세요"
					class="select-st01">
					<option value="">검색구분</option>
					<option value="title" ${WAC001BoardSearchForm.sv eq 'title' ? 'selected' : ''}>제목</option>
					<option value="cnts" ${WAC001BoardSearchForm.sv eq 'cnts' ? 'selected' : ''}>내용</option>
					<option value="dual" ${WAC001BoardSearchForm.sv eq 'dual' ? 'selected' : ''}>제목+내용</option>
				</select> 
				<input class="search-text" name="sw" title="검색내용을 입력해주세요" type="text" value="${WAC001BoardSearchForm.sw }">
				<button class="search-bnt" type="submit">
					<span>검색</span>
				</button>
			</div>
		</div>
		<!--search-->
		<div class="lst-num">
			<p class="num-icon"></p>
			<p class="num-box">
				<span class="num">${totCount eq null ? '0' : totCount }</span>건
			</p>
		</div>
		<!--<p class="ntc-topline"></p>-->
		<div class="board-wrap">
			<table class="boardLst-notice tblleft">
				<caption>공지사항</caption>
				<colgroup>
					<col width="90px">
					<col width="*">
				</colgroup>
				<tbody>
					<c:choose>
						<c:when test="${fn:length(boardList) > 0}">
							<c:set value="${fn:length(boardList)}" var="boardListSize" />
							<c:forEach var="board" items="${boardList}" varStatus="status">
								<c:set var="circulation_id" value="${fn:split(board.circulation_Id,'/')[1] }" />
								<c:set var="circulation_id" value="${fn:split(circulation_id,',')[0] }" />
								<tr>
									<th>
										<c:forEach var="data" items="${categoryList}" varStatus="status">
											<c:if test="${data.cmcCode eq board.category }">
												<p class="BLst-badge badge0${status.index + 1}">
													<c:out value="${data.cnmName }">
													</c:out>
												</p>
											</c:if>
										</c:forEach></th>
									<td>
										<div class="tit-box">
											<a class="cont-tit" href="<%= request.getContextPath() %>/WAC002BoardSelect/init.do?tabId=${tabId}&boardId=${boardId}&idx=${board.idx}&pageNo=${paging.pageNo }&sv=${paging.sv}&sw=${paging.sw}">${board.title }</a>
										</div>
										<div class="icon">
											<c:if test="${board.regiDtm eq today }">
												<span class="new"></span>
											</c:if>
											<c:if test="${board.fileCnt > 0 }">
												<span class="file"></span>
											</c:if>
										</div>
										<p class="date">${fn:substring(board.regiDtm, 0, 10) }</p>
									</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="2"><spring:message code="label.no_data" /> 
									<input type="hidden" name="pageNo" value="1" /></td>
							</tr>
						</c:otherwise>
					</c:choose>
					<%-- <tr>
						<th><p class="BLst-badge badge01">전체</p></th>
						<td>
							<div class="tit-box">
								<a class="cont-tit" href="/WAC002BoardSelect/init.do?boardId=${boardId}&idx=${board.idx}">임시공휴일 지정으로 인해서 5-6일 이틀간 업무를 하지 않습니다. 참고바랍니다.</a>
							</div>
							<div class="icon">
								<span class="new"></span><span class="file"></span>
							</div>
							<p class="date">2018-03-05</p>
						</td>
					</tr>
					<tr>
						<th><p class="BLst-badge badge02">부서명</p></th>
						<td>
							<div class="tit-box">
								<p class="cont-tit"><a href="/WAC002BoardSelect/init.do">업무에 참고 하시기 바랍니다.</a><span class="new-icon"></span></p>
							</div>
							<div class="icon">
								<span class="new"></span><span class="file"></span>
							</div>
							<p class="date">2018-03-05</p>
						</td>
					</tr>
					<tr>
						<th><p class="BLst-badge badge03">부서명</p></th>
						<td>
							<div class="tit-box">
								<p class="cont-tit"><a href="/WAC002BoardSelect/init.do">업무 조기 마감으로 인해 근무 시간이 조정됩니다.</a><span class="new-icon"></span></p>
							</div>
							<div class="icon">
								<span class="new"></span><span class="file"></span>
							</div>
							<p class="date">2018-03-05</p>
						</td>
					</tr>
					<tr>
						<th><p class="BLst-badge badge04">부서명</p></th>
						<td>
							<div class="tit-box">
								<p class="cont-tit"><a href="/WAC002BoardSelect/init.do">덴소코리아 신입사원 교육</a><span class="new-icon"></span></p>
							</div>
							<div class="icon">
								<span class="new"></span><span class="file"></span>
							</div>
							<p class="date">2018-03-05</p>
						</td>
					</tr>
					<tr>
						<th><p class="BLst-badge badge01">전체</p></th>
						<td>
							<div class="tit-box">
								<p class="cont-tit"><a href="/WAC002BoardSelect/init.do">임시공휴일 지정으로 인해서 5-6일 이틀간 업무를 하지 않습니다. 참고바랍니다.</a><span class="new-icon"></span></p>
							</div>
							<p class="date">2018-03-05</p>
						</td>
					</tr>
					<tr>
						<th><p class="BLst-badge badge01">전체</p></th>
						<td>
							<div class="tit-box">
								<p class="cont-tit"><a href="/WAC002BoardSelect/init.do">참고바랍니다.</a><span class="new-icon"></span></p>
							</div>
							<p class="date">2018-03-05</p>
						</td>
					</tr>
					<tr>
						<th><p class="BLst-badge badge01">전체</p></th>
						<td>
							<div class="tit-box">
								<p class="cont-tit"><a href="/WAC002BoardSelect/init.do">참고바랍니다.</a><span class="new-icon"></span></p>
							</div>
							<p class="date">2018-03-05</p>
						</td>
					</tr>
					<tr>
						<th><p class="BLst-badge badge01">전체</p></th>
						<td>
							<div class="tit-box">
								<p class="cont-tit"><a href="/WAC002BoardSelect/init.do">참고바랍니다.</a><span class="new-icon"></span></p>
							</div>
							<p class="date">2018-03-05</p>
						</td>
					</tr>
					<tr>
						<th><p class="BLst-badge badge01">전체</p></th>
						<td>
							<div class="tit-box">
								<p class="cont-tit"><a href="/WAC002BoardSelect/init.do">참고바랍니다.</a><span class="new-icon"></span></p>
							</div>
							<p class="date">2018-03-05</p>
						</td>
					</tr>
					<tr>
						<th><p class="BLst-badge badge01">전체</p></th>
						<td>
							<div class="tit-box">
								<p class="cont-tit"><a href="/WAC002BoardSelect/init.do">참고바랍니다.</a><span class="new-icon"></span></p>
							</div>
							<p class="date">2018-03-05</p>
						</td>
					</tr> --%>
				</tbody>
			</table>

			<div class="ssgap"></div>

			<!-- <div class="btnRight">
				<button type="" class="btn-st1 bt-red" name="" onclick="location.href='/WAC004BoardCreate/init.do'">글쓰기
				</button>
			</div>
		
			<div class="ssgap"></div> -->

			<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"> <%--조회권한 --%>
				<c:if test="${fn:length(boardList) > 0}">
					<div class="pagenation">
						<smpl:seqpaging maxSeq="5" formId="WAC001BoardSearchForm" />
					</div>
					<ai:pagingoption countPerPage="5" />
				</c:if>
			</c:if>

			<!-- <ul class="paging-wrap">
				<li><a href="#n" class="first BdBg">첫페이지로</a></li>
				<li><a href="#n" class="prev BdBg">이전 페이지로</a></li>
				<li><a href="#n" class="active">1</a></li>
				<li><a href="#n" title="2페이지로 이동합니다.">2</a></li>
				<li><a href="#n" title="3페이지로 이동합니다.">3</a></li>
				<li><a href="#n" title="4페이지로 이동합니다.">4</a></li>
				<li><a href="#n" title="5페이지로 이동합니다.">5</a></li>
				<li><a href="#n" class="next BdBg">다음페이지로</a></li>
				<li><a href="#n" class="last BdBg">마지막페이지로</a></li>
			</ul> -->

			<div class="gap"></div>
	</form:form>

</div>
<!--board-wrap-->



</div>


<!-- container:E -->