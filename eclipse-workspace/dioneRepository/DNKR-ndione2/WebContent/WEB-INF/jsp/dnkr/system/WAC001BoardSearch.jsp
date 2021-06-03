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

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" 	prefix="fn" %>

<link rel="stylesheet" media="all" href="/css/board.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/WAC001Board.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/WAC001BoardSearch.js" charset="utf-8"></script>

<!-- <div class="cont-wrap"> -->
	<!-- <div class="sub-tab">
		<p class="prev"><a href="#n"><img src="/img/subtab_arrowL.png" alt="왼쪽으로"></a><p>
		<ul class="tab-slide">
			<li class="on"><a href="#n">공지사항<span class="close">X</span></a></li>
			<li><a href="#n">프로젝트관리-1<span class="close">X</span></a></li>
			<li><a href="#n">메뉴1-1<span class="close">X</span></a></li>
		</ul>
		<p class="next"><a href="#n"><img src="/img/subtab_arrowR.png" alt="오른쪽으로"></a></p>
	</div> -->
	<!-- <div class="sub-con-wrap"> -->
		<!-- <h2 class="subpage-tit">공지사항</h2> -->
	<div class="board-list-wrap">
		<form:form action="${pageContext.request.contextPath}/WAC001BoardSearch/search.do" method="POST" onsubmit="searchProc();" modelAttribute="WAC001BoardSearchForm" name="WAC001BoardSearchForm" id="WAC001BoardSearchForm">
		<input type="hidden" name="tabId" value="<c:out value="${tabId}"></c:out>" />
		<input type="hidden" name="boardId" value="${boardId}" />
		<input type="hidden" name="chkIdx" id="chkIdx" />
			<div class="list-top">
				<div class="left">
					<p class="num-icon"></p>
					<p class="num-box"><span class="num">${totCount }</span>건</p>
				</div>
				<div class="search">
					<select autofocus="true" name="category" title="카테고리를 선택해주세요">
						<option value="">카테고리</option>
						<c:forEach var="data" items="${categoryList}" varStatus="status">
							<option value="${data.cmcCode }"	
								<c:if test="${data.cmcCode eq WAC001BoardSearchForm.category }">
									selected
								</c:if>
							>
								<c:out value="${data.cnmName }">
								</c:out>
							</option>
						</c:forEach>
					</select>
					<select name="sv" title="검색내용을 선택해주세요">
						<option value="">검색구분</option>
						<option value="title" ${WAC001BoardSearchForm.sv eq 'title' ? 'selected' : ''}>제목</option>
						<option value="cnts" ${WAC001BoardSearchForm.sv eq 'cnts' ? 'selected' : ''}>내용</option>
						<option value="dual"  ${WAC001BoardSearchForm.sv eq 'dual' ? 'selected' : ''}>제목+내용</option>
					</select>
					<input class="search-text" type="text" name="sw" title="검색내용을 입력해주세요" value="${WAC001BoardSearchForm.sw }"></input> 
					<button class="search-bnt" type="submit">
						<span>검색</span>
					</button> 
				</div><!--search-->
			</div><!--list-top-->
			<div class="gap10"></div>
			<div class="board-inlist-wrap">
				<ol class="board-list">
					<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%--조회권한 --%>
						<%-- <c:choose>
							<c:when test="${fn:length(noticeList) > 0}">
								<c:set value="${fn:length(noticeList)}" var="boardListSize"/>
									<c:forEach var="notice" items="${noticeList}" varStatus="status">
										<li>
											<div class="head">
												<c:if test="${fn:substring(authBinaryNum, 0, 1) eq '1' }">
													<input type="checkbox" class="chk li-select" id="chk_${notice.idx }" name="chk" value="${notice.idx }">
												</c:if>
													<p class="list-num notice">${totCount + 1 - board.rowNum}</p>
													<p class="yymm">${fn:substring(notice.regiDtm, 0, 7) }</p>
													<p class="dd">${fn:substring(notice.regiDtm, 8, 10) }</p>
											</div>
											<dl class="cont">
												<dt><a href="<%= request.getContextPath() %>/WAC002BoardSelect/init.do?boardId=${boardId}&idx=${notice.idx}" onclick="return loadTab(this);">${notice.title }</a>
													<c:if test="${notice.regiDtm eq today }"><span class="new">N</span></c:if>
													<c:if test="${notice.fileCnt > 0 }"><span class="file"></span></c:if>
												</dt>
												<dd><a href="<%= request.getContextPath() %>/WAC002BoardSelect/init.do?boardId=${boardId}&idx=${notice.idx}" onclick="return loadTab(this);">${notice.cntsCut }</a></dd>
											</dl>
										</li>
									</c:forEach>
							</c:when>
						</c:choose> --%>
						<c:choose>
							<c:when test="${fn:length(boardList) > 0}">
								<c:set value="${fn:length(boardList)}" var="boardListSize"/>
									<c:forEach var="board" items="${boardList}" varStatus="status">
										<c:set var="circulation_id" value="${fn:split(board.circulation_Id,'/')[1] }"/>
										<c:set var="circulation_id" value="${fn:split(circulation_id,',')[0] }"/>
												<li>
													<div class="head">
														<%-- <c:if test="${fn:substring(authBinaryNum, 0, 1) eq '1' }"><!-- 삭제권한 --> --%>
														<c:if test="${(userId eq board.regiId) or (userId eq 'Admin')}"><!-- 삭제권한 -->
														<input type="checkbox" class="chk li-select" id="chk_${board.idx }" name="chk" value="${board.idx }">
														</c:if>
														<c:forEach var="data" items="${categoryList}" varStatus="status">
															<c:if test="${data.cmcCode eq board.category }">
																<p class="list-num">
																	<c:out value="${data.cnmName }">
																	</c:out>
																</p>
															</c:if>
														</c:forEach>
															<%--<p class="list-num">${totCount + 1 - board.rowNum}</p> --%>
															<p class="yymm">${fn:substring(board.regiDtm, 0, 7) }</p>
															<p class="dd">${fn:substring(board.regiDtm, 8, 10) }</p>
													</div>
													
													<div class="cont">
														<dt><a href="<%= request.getContextPath() %>/WAC002BoardSelect/init.do?tabId=${tabId}&boardId=${boardId}&idx=${board.idx}&category=${paging.category }&pageNo=${paging.pageNo }&sv=${paging.sv}&sw=${paging.sw}" onclick="return loadTab(this);">${board.title }</a>
															<c:if test="${board.regiDtm eq today }"><span class="new">N</span></c:if>
															<c:if test="${board.fileCnt > 0 }"><span class="file"></span></c:if>
														</dt>
														<dd>
															<a href="<%= request.getContextPath() %>/WAC002BoardSelect/init.do?tabId=${tabId}&boardId=${boardId}&idx=${board.idx}&category=${paging.category }&pageNo=${paging.pageNo }&sv=${paging.sv}&sw=${paging.sw}" onclick="return loadTab(this);">
																<%-- <c:out value="${board.cntsCut.replaceAll('\\\<.*?\\\>', '') }" escapeXml="true"/> --%>
																<c:out value='${fn:substring(board.cntsCut.replaceAll("\\\<.*?\\\>",""), 0, 300)}' escapeXml="true"/>
															</a>
														</dd>
													</div>
												</li>
									</c:forEach>
							</c:when>
							<c:otherwise>
								<li>
									<dl class="cont">
										<dt>데이터가 없습니다.</dt>
									</dl>
								</li>
							</c:otherwise>
						</c:choose>
						<%-- <li>
							<div class="head">
								<input type="checkbox" id="li-select" name="li-select">
									<p class="list-num notice">공지</p>
									<p class="yymm">2017년 08월</p>
									<p class="dd">08</p>
							</div>
							<dl class="cont">
								<dt><a href="<%= request.getContextPath() %>/WAC002BoardSelect/init.do" onclick="return loadTab(this);">덴소코리아 협력사 세미나</a><span class="new">N</span><span class="file"></span></dt>
								<dd><a href="<%= request.getContextPath() %>/WAC002BoardSelect/init.do" onclick="return loadTab(this);">지난 6월 2일, 창원컨벤션센터(CECO)에서는 DNKA와 DNKE의 임원, DIKR 이준식 사장 및 144개사 협력사 대표이사들이 참석한 가운데, ‘덴소코리아	2017년도 협력사 세미나’ 가 개최되었다. 이번 협력사 세미나는 덴소코리아의 향후 비전을 협력사와 공유함으로써 상생발전을 도모하고 품질 제일주의를 실현하기 위해 마련된 자리로, 덴소코리아 구매본부...</a></dd>
								
							</dl>
						</li>
						<li>
							<div class="head">
								<input type="checkbox" id="li-select" name="li-select">
									<p class="list-num">4</p>
									<p class="yymm">2017년 08월</p>
									<p class="dd">02</p>
							</div>
							<dl class="cont">
								<dt><a href="#">덴소코리아 협력사 세미나</a><span class="new">N</span></dt>
								<dd><a href="#">지난 6월 2일, 창원컨벤션센터(CECO)에서는 DNKA와 DNKE의 임원, DIKR 이준식 사장 및 144개사 협력사 대표이사들이 참석한 가운데, ‘덴소코리아	2017년도 협력사 세미나’ 가 개최되었다. 이번 협력사 세미나는 덴소코리아의 향후 비전을 협력사와 공유함으로써 상생발전을 도모하고 품질 제일주의를 실현하기 위해 마련된 자리로, 덴소코리아 구매본부...</a></dd>
								
							</dl>
						</li> --%>
					</c:if>
					<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '0' }"><%--조회권한 --%>
						<li>
							<dl class="cont">
								<dt><spring:message code='DNKR-E2-0000'/><!-- 권한이 없습니다. --></dt>
								<dd><a href="#"></a></dd>
							</dl>
						</li>
					</c:if>
				</ol>
				<div class="list-bnt listOnly">
					<c:if test="${fn:substring(authBinaryNum, 0, 1) eq '1' }"><%--삭제 권한 --%>
						<a href="#" class="gray" onclick="chkDel();">삭제</a>
					</c:if>
					<c:if test="${fn:substring(authBinaryNum, 2, 3) eq '1' }"><%--쓰기권한 --%>
						<a href="#" class="red" onclick="javascript:location.href='/WAC004BoardCreate/init.do?tabId=<c:out value="${tabId}"></c:out>&boardId=<c:out value="${boardId}"></c:out>';" >글쓰기</a>
					</c:if>
				</div>
				<div class="gap20"></div>
				<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%--조회권한 --%>
					<c:if test="${fn:length(boardList) > 0}">
						<div class="pagenation">
				            <smpl:seqpaging maxSeq="3" formId="WAC001BoardSearchForm" />
				        </div>
				        <ai:pagingoption countPerPage="3" />
			        </c:if>
		        </c:if>
		        <!-- 
				<ul class="paging-wrap">
					<li><a href="#n" class="first BdBg">첫페이지로</a></li>
					<li class="margin"><a href="#n" class="prev BdBg">이전 페이지로</a></li>
					<li><a href="#n" class="active">1</a></li>
					<li><a href="#n" title="2페이지로 이동합니다.">2</a></li>
					<li><a href="#n" title="3페이지로 이동합니다.">3</a></li>
					<li><a href="#n" title="4페이지로 이동합니다.">4</a></li>
					<li><a href="#n" title="5페이지로 이동합니다.">5</a></li>
					<li><a href="#n" title="6페이지로 이동합니다.">6</a></li>
					<li><a href="#n" title="7페이지로 이동합니다.">7</a></li>
					<li><a href="#n" title="8페이지로 이동합니다.">8</a></li>
					<li><a href="#n" title="9페이지로 이동합니다.">9</a></li>
					<li class="margin"><a href="#n" class="next BdBg">다음페이지로</a></li>
					<li><a href="#n" class="last BdBg">마지막페이지로</a></li>
				</ul> -->
			</div><!--board-inlist-wrap-->
		</form:form>
	</div><!--board-list-wrap-->
	<!-- </div>sub-con-wrap -->
<!-- </div> -->