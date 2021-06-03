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

<style>
.main-con .mC-right .icon-menu p.ic-mn-03 a:hover { background-color: yellow; }
 
</style>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/WAA001Main.js"></script> --%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/WAJ001Main.js"></script>

<%-- <spring:message code="label.filename" /> : <c:out value="${url }"></c:out> --%>


<div class="cont-wrap">
	<div class="main-con-wrap">
		<div class="main-con">
			<div class="mC-left">
				<div class="notice mbC-bottom">
					<p class="tit _popBoardBtn_" onclick="javascript:goBoardPage(this, '${boardInfoList[0].boardId}');">${boardInfoList[0].boardNm}<!-- 공지사항 --><a href="#" class="more"></a></p>
					<c:choose>
							<c:when test="${fn:length(boardList) > 0}">
								<c:set value="${fn:length(boardList)}" var="boardListSize"/>
									<c:forEach var="board" items="${boardList}" varStatus="status">
										<c:if test="${status.count eq 1}">
											<div class="today">
												<div class="day">
													<p class="dd">${fn:substring(board.regiDtm, 8, 10) }</p>
													<p class="yy-mm">${fn:substring(board.regiDtm, 0,4)}.${fn:substring(board.regiDtm, 5,7)}</p>
												</div>
												<p class="today-tit _popBoardBtn_" onclick="javascript:goBoardPage(this, '${boardInfoList[0].boardId}');">
													<c:forEach var="data" items="${categoryList}" varStatus="status2">
														<c:if test="${data.cmcCode eq board.category }">
															<span class="category">
																<c:out value="${data.cnmName }"/>
															</span>
														</c:if>
													</c:forEach>
													<a href="#n">${board.titleCut }</a>
												</p>
											</div>
											<ul class="notice-list">
										</c:if>
										<c:if test="${status.count ne 1}">
											<li class="_popBoardBtn_" onclick="javascript:goBoardPage(this, '${boardInfoList[0].boardId}');">
												<c:forEach var="data" items="${categoryList}" varStatus="status">
													<c:if test="${data.cmcCode eq board.category }">
														<span class="category"  style="line-height: 15px; position: relative; margin-bottom:0">
															<c:out value="${data.cnmName }"/>
														</span>
													</c:if>
												</c:forEach>
												<a href="#n">${board.titleCut }</a>
											</li>
										</c:if>
									</c:forEach>
											</ul>
							</c:when>
							<c:otherwise>
								
							</c:otherwise>
					</c:choose>
	
				</div>
				<%-- 즐겨찾기 제외
				<div class="bookmark">
						<p class="set-icon"><a href="#n" onclick="window.open('/WAP001Bkmk/init.do','bkmk','width=950,height=700,top=100,left=100');"><img src="/img/setup-icon.png" alt="즐겨찾기설정"></a></p>
						<div class="bmark-wrap">
							<c:forEach var="list" items="${bkmkList }" varStatus="status">
								<c:if test="${status.count < 7 }">
									<a href="<%= request.getContextPath() %>/WAA000Sub/init.do?menu=${list.menuCode}" id="${list.menuCode }" data-name="${list.menuCodeNm }" class="bmark-${status.count }">
										<span class="bmark-name">${list.menuCodeNm }</span>
										<span class="${list.mcdIcon}" style="font-size:40px;line-height:2;"></span>
									</a>
								</c:if>
							</c:forEach>

						</div>
				</div>
			--%>	
			</div>
			<div class="mC-right">
				<div class="icon-menu">
					<p class="ic-mn-01"><a href="javascript:void(0)" data-systemSeq="1"  data-relationCompany="" onclick="openLink(this)" title ="<spring:message code="label.tooltip2"/>"><span class="img-wrap"><img src="/img/ex-sso-icon01.png" alt="SCM">SCM</span></a></p>
					<p class="ic-mn-02"><a href="javascript:void(0)" data-systemSeq="10" data-relationCompany="" onclick="openLink(this)" title ="<spring:message code="label.tooltip2"/>"><span class="img-wrap"><img src="/img/ex-sso-icon02.png" alt="FTA">FTA</span></a></p>
<!--
 					<p class="ic-mn-03"><a href="javascript:void(0)" onclick="runFile()"><span class="img-wrap"><img src="/img/ex-sso-icon03.png" alt="MES">MES</span></a></p>
 -->
<%--  
					<p class="ic-mn-03"><a href="javascript:void(0)" data-systemSeq="13" onclick="openLink(this)" title ="<spring:message code="label.tooltip2"/>"><span class="img-wrap"><img src="/img/ex-sso-icon03.png" alt="MES">MES</span></a></p>
 
 --%> 
					<p class="ic-mn-03"><span class="img-wrap"><img src="/img/ex-sso-icon03.png" alt="MES" title ="접속공장을 클릭하세요." >MES</span>
					<br><br>
					
					<a href="javascript:void(0)" data-systemSeq="13" data-relationCompany="LOC000004" onclick="openLink(this)" title ="<spring:message code="label.tooltip2"/>" style="display:inline; color: #0080ff;">마산</a>
 					<a href="javascript:void(0)" data-systemSeq="13" data-relationCompany="LOC000001" onclick="openLink(this)" title ="<spring:message code="label.tooltip2"/>" style="display:inline; color: #0080ff;">창원</a>
 					<a href="javascript:void(0)" data-systemSeq="13" data-relationCompany="LOC000002" onclick="openLink(this)" title ="<spring:message code="label.tooltip2"/>" style="display:inline; color: #0080ff;">홍성</a>
 					<a href="javascript:void(0)" data-systemSeq="13" data-relationCompany="LOC000003" onclick="openLink(this)" title ="<spring:message code="label.tooltip2"/>" style="display:inline; color: #0080ff;">화성</a>

  					</p>
					<p class="ic-mn-04"><a href="javascript:void(0)" data-systemSeq="14" data-relationCompany="" onclick="openLink(this)" title ="<spring:message code="label.tooltip2"/>"><span class="img-wrap"><img src="/img/ex-sso-icon04.png" alt="TQMS">TQMS</span></a></p>
					<p class="ic-mn-05"><a href="javascript:void(0)" onclick="externalLink(1)" title ="<spring:message code="label.tooltip2"/>"><span class="img-wrap"><img src="/img/ex-external-icon01.png" alt="홈페이지"></span>홈페이지</a></p>
					<p class="ic-mn-06"><a href="javascript:void(0)" onclick="externalLink(2)" title ="<spring:message code="label.tooltip2"/>"><span class="img-wrap"><img src="/img/ex-external-icon02.png" alt="방문자예약"></span>방문자예약</a></p>			
					<%-- 
					<p class="ic-mn-01"><a href="#"><span class="img-wrap"><img src="/img/main-icon01.png" alt="시스템관리"></span></a></p>
					<p class="ic-mn-02"><a href="#"><span class="img-wrap"><img src="/img/main-icon02.png" alt="프로젝트관리"></span></a></p>
					<p class="ic-mn-03"><a href="#"><span class="img-wrap"><img src="/img/main-icon03.png" alt="종합관리"></span></a></p>
					<p class="ic-mn-04"><a href="#"><span class="img-wrap"><img src="/img/main-icon04.png" alt="경영관리"></span></a></p>
					<p class="ic-mn-05"><a href="#"><span class="img-wrap"><img src="/img/main-icon05.png" alt="설문조사"></span></a></p>
					<p class="ic-mn-06"><a href="#"><span class="img-wrap"><img src="/img/main-icon06.png" alt="메뉴1"></span></a></p>
					<p class="ic-mn-07"><a href="#"><span class="img-wrap"><img src="/img/main-icon07.png" alt="메뉴2"></span></a></p>
					<p class="ic-mn-08"><a href="#"><span class="img-wrap"><img src="/img/main-icon08.png" alt="메뉴3"></span></a></p>
					<p class="ic-mn-09"><a href="#"><span class="img-wrap"><img src="/img/main-icon09.png" alt="메뉴4"></span></a></p>
					--%>
				</div><!--icon-menu-->
			</div><!--mC-right-->
		</div><!--main-con-->
	</div><!--main-con-wrap-->
</div><!--cont-wrap-->
<div class="cont-bg"></div>