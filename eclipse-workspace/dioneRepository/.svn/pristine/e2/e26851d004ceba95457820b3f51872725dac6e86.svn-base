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
<link rel="stylesheet" media="all" href="/css/main-b.css?ver=1"/>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/main-b.js?ver=1"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/WAJ002Main.js"></script>

<%-- <spring:message code="label.filename" /> : <c:out value="${url }"></c:out> --%>

<!--바로가기버튼-->

<div class="ico-menu opened"style="z-index: 300; right: 0px;" >


	<div class="icoM-wrap">
		<div class="topBar">
			<a href="#n"></a>
			<span>바로가기</span>
		</div>
		<ul>
			<li class="n-bg" hidden="true">
				<a id ="disPlaySession" href="javascript:void(0)"  data-systemNm="disPlay" onclick="sessionLink(this)" >
				<span class="tit">Display Session</span>
				</a>
			</li>
			<li class="n-bg">
				<a href="javascript:void(0)"  data-systemNm="disPlay" onclick="sessionIdCount(this)">
				<span class="tit">Display Session</span>
				</a>
			</li>
			<li class="n-bg">
				<a href="javascript:void(0)"  data-systemNm="printer"  onclick="sessionLink(this)">
				<span class="tit">Printer Session</span>
				</a>
			</li>
			<li class="icoM-01 ">
				<a href="javascript:void(0)" data-systemSeq="20" data-pageType="main" onclick="openLink(this)">
				<span class="tit">HR <spring:message code="label.system" /><!-- 시스템 --></span>
				</a>
			</li>
			<li class="icoM-06 ">
				<a href="javascript:void(0)" data-systemSeq="23" data-pageType="main" onclick="openLink(this)">
				<span class="tit">전자결재 <spring:message code="label.system" /><!-- 시스템 --></span>
				</a>
			</li>
			<%-- <li class="icoM-02 ">
				<a href="javascript:void(0)" data-systemSeq="21" onclick="openLink(this)">
				<span class="tit">NEXPOM <spring:message code="label.system" /><!-- 시스템 --></span>
				</a>
			</li>
			<li class="icoM-05 ">
				<a href="javascript:void(0)" data-systemSeq="22" onclick="openLink(this)">
				<span class="tit">PaperLess <spring:message code="label.system" /><!-- 시스템 --></span>
				</a>
			</li> --%>
			<li class="icoM-03 ">
				<a href="javascript:void(0)" data-systemType="internal"  onclick="pageLink(this)">
				<span class="tit"><spring:message code="label.internal" /> <spring:message code="label.site" /><!-- 사내업무사이트 --></span>
				</a>
			</li>
			<li class="icoM-04 ">
				<a href="javascript:void(0)" data-systemType="external" onclick="pageLink(this)">
				<span class="tit"><spring:message code="label.external" /> <spring:message code="label.sites" /><!-- 사외업무사이트 --></span>			
				</a>
			</li>
			<li class="icoM-05 ">
				<a href="javascript:void(0)" data-systemType="global" onclick="pageLink(this)">
				<span class="tit">Global <spring:message code="label.sites"/><!-- 사이트 --></span>
				</a>
			</li>
			<li class="icoM-02 last">
				<a href="javascript:void(0)" data-systemType="visit" onclick="etcLink(this)">
				<span class="tit">방문자예약<spring:message code="label.sites" /><!-- 방문자예약사이트 --></span>			
				</a>
			</li> 


		<%--
			<li class="icoM-02 ">
				<form id="dioneForm" method="post" action="#"> 
					<a href="javascript:void(0)" data-systemNm="dione"  onclick="sessionLink(this)">
						<input id="userId" name="userId" value="" hidden="true"/>
					<span class="tit">DIONE</span>
					</a>
				</form>

			</li> 		
			<li class="icoM-01">
				<a href="javascript:void(0)"  data-systemSeq="1" onclick="openLink(this)">
				<span class="tit">SCM System</span>
				</a>
			</li>
			<li class="icoM-02">
				<a href="javascript:void(0)" data-systemSeq="3" onclick="openLink(this)">
				<span class="tit">K-SOX System</span>
				</a>
			</li>
			<li class="icoM-03">
				<a href="javascript:void(0)" data-systemSeq="2" onclick="openLink(this)">
				<span class="tit">PDM System</span>
				</a>
			</li>
			<li class="icoM-04">
				<a href="javascript:void(0)" data-systemSeq="11" onclick="openLink(this)">
				<span class="tit">순서생산</span>
				</a>
			</li>
			<li class="icoM-05 last" onclick="runFile()">
				<a href="javascript:void(0)" onclick="runFile()">
				<span class="tit">공정누락방지</span>
				</a>
			</li>
			<li class="icoM-03">
				<a href="javascript:void(0)" data-systemSeq="14" onclick="openLink(this)">
				<span class="tit">TQMS</span>
				</a>
			</li>
			<li class="icoM-04">
				<a href="javascript:void(0)" data-systemSeq="17" onclick="openLink(this)">
				<span class="tit"><spring:message code="label.mold" /><spring:message code="label.management" /><!-- 금형관리 --></span>
				</a>
			</li>
			
	--%>	

			<%-- <li>
				<div class="rl">
					<a href="/WAA000Sub/init.do?menu=2">
					<span class="img-wrap">
						<img src="img/main-icon09.png" alt="사용자관리">
					</span>
					<span class="tit">사용자관리</span>
					</a>
				</div>
				<div>
					<a href="/WAA000Sub/init.do?menu=261">
					<span class="img-wrap">
						<img src="img/main-icon02.png" alt="프로젝트관리">
					</span>
					<span class="tit">프로젝트관리</span>
					</a>
				</div>
			</li>
			<li>
				<div class="rl">
					<a href="#">
					<span class="img-wrap">
						<img src="img/main-icon03.png" alt="종합관리">
					</span>
					<span class="tit">종합관리</span>
					</a>
				</div>
				<div>
					<a href="#">
					<span class="img-wrap">
						<img src="img/main-icon04.png" alt="경영관리">
					</span>
					<span class="tit">경영관리</span>
					</a>
				</div>
			</li>
			<li>
				<div class="rl">
					<a href="#">
					<span class="img-wrap">
						<img src="img/main-icon05.png" alt="설문조사">
					</span>
					<span class="tit">설문조사</span>
					</a>
				</div>
				<div>
					<a href="#">
					<span class="img-wrap">
						<img src="img/main-icon06.png" alt="메뉴1">
					</span>
					<span class="tit">메뉴1</span>
					</a>
				</div>
			</li>
			<li>
				<div class="rl">
					<a href="#">
					<span class="img-wrap">
						<img src="img/main-icon07.png" alt="메뉴2">
					</span>
					<span class="tit">메뉴2</span>
					</a>
				</div>
				<div>
					<a href="#">
					<span class="img-wrap">
						<img src="img/main-icon08.png" alt="메뉴3">
					</span>
					<span class="tit">메뉴3</span>
					</a>
				</div>
			</li>
			<li>
				<div class="rl">
					<a href="#">
					<span class="img-wrap">
						<img src="img/main-icon09.png" alt="메뉴4">
					</span>
					<span class="tit">메뉴4</span>
					</a>
				</div>
			</li> --%>
		</ul> 
	</div>
</div>
<!--바로가기버튼-->

<div class="cont-wrap">
	<div class="main-con-wrap">
		<div class="mainB-con">
			<div class="mbC-top"  style="display:none;">
				<div class="tab-wrap">
					<ul class="tab">
						<li class="tab-li on"><a href="#n"><spring:message code="label.business"/><spring:message code="label.performance"/><!-- 경영실적 --></a></li>
						<li class="tab-li"><a href="#n"><spring:message code="label.computational"/><!-- 전산 --></a></li>
						<li class="tab-li"><a href="#n"><spring:message code="label.Marketing"/><!-- 마케팅 --></a></li>
					</ul>
					<a href="#" class="set"></a>
				</div>
				<div class="con-wrap">

					<div class="circleG-wrap">
						<div class="circleChart">
							 <svg class="circle-chart" viewbox="0 0 33.83098862 33.83098862" width="158" height="158">
							<circle class="circle-chart__background" stroke="#ecf2f6" stroke-width="2.4" fill="none" cx="16.51549431" cy="16.51549431" r="15.51549431" />
							<circle class="circle-chart__circle" stroke="#47bac1" stroke-width="2.4" stroke-dasharray="59.3,100" stroke-linecap="round" fill="none" cx="16.71549431" cy="16.71549431" r="15.51549431" />
								<p class="cChart-txt cChart1-txt">
									<span class="num">596.5</span>
									<span class="tit">매출액</span>
								</p>
						</div>

						<div class="circleChart">
							<svg class="circle-chart" viewbox="0 0 33.83098862 33.83098862" width="158" height="158">
							<circle class="circle-chart__background" stroke="#ecf2f6" stroke-width="2.4" fill="none" cx="16.71549431" cy="16.71549431" r="15.51549431" />
							<circle class="circle-chart__circle" stroke="#d7363c" stroke-width="2.4" stroke-dasharray="81.5,100" stroke-linecap="round" fill="none" cx="16.71549431" cy="16.71549431" r="15.51549431" />
								<p class="cChart-txt cChart2-txt">
									<span class="num">815</span>
									<span class="tit">수출액</span>
								</p>
						</div>	
					
						<div class="circleChart">
							<svg class="circle-chart" viewbox="0 0 33.83098862 33.83098862" width="158" height="158">
							<circle class="circle-chart__background" stroke="#ecf2f6" stroke-width="2.4" fill="none" cx="16.71549431" cy="16.71549431" r="15.51549431" />
							<circle class="circle-chart__circle" stroke="#ae69af" stroke-width="2.4" stroke-dasharray="80,100" stroke-linecap="round" fill="none" cx="16.71549431" cy="16.71549431" r="15.51549431" />
								<p class="cChart-txt cChart3-txt">
									<span class="num">80<span class="per">%</span></span>
									<span class="tit">영업이익</span>
								</p>
						</div>
					
						<p class="tit"><span>전기대비 25% 상승</span></p>
					</div><!--circleG-wrap-->
					<div class="barG-wrap">
						<ul class="barGraph">
							<li class="num">
								<span class="n-5">500</span>
								<span class="n-4">400</span>
								<span class="n-3">300</span>
								<span class="n-2">200</span>
								<span class="n-1">100</span>
								<span class="n-0">0</span>
							</li>
							<li>
								<span class="gtxt">9월</span>
								<span class="gbar-bg">
									<span class="gbar" style="height:20%;"></span>
								</span>
							</li>
							<li>
								<span class="gtxt">10월</span>
								<span class="gbar-bg">
									<span class="gbar" style="height:40%;"></span>
								</span>
							</li>
							<li>
								<span class="gtxt">11월</span>
								<span class="gbar-bg">
									<span class="gbar" style="height:60%;"></span>
								</span>
							</li>
							<li>
								<span class="gtxt">12월</span>
								<span class="gbar-bg">
									<span class="gbar" style="height:35%;"></span>
								</span>
							</li>
							<li>
								<span class="gtxt">1월</span>
								<span class="gbar-bg">
									<span class="gbar" style="height:43%;"></span>
								</span>
							</li>
							<li>
								<span class="gtxt">2월</span>
								<span class="gbar-bg">
									<span class="gbar" style="height:76%;"></span>
								</span>
							</li>
							<li>
								<span class="gtxt">3월</span>
								<span class="gbar-bg">
									<span class="gbar" style="height:68%;"></span>
								</span>
							</li>
							<li>
								<span class="gtxt">4월</span>
								<span class="gbar-bg">
									<span class="gbar" style="height:85%;"></span>
								</span>
							</li>
							<li>
								<span class="gtxt">5월</span>
								<span class="gbar-bg">
									<span class="gbar" style="height:51%;"></span>
								</span>
							</li>
							<li>
								<span class="gtxt">6월</span>
								<span class="gbar-bg">
									<span class="gbar" style="height:74%;"></span>
								</span>
							</li>
							<li>
								<span class="gtxt">7월</span>
								<span class="gbar-bg">
									<span class="gbar" style="height:69%;"></span>
								</span>
							</li>
							<li>
								<span class="gtxt">8월</span>
								<span class="gbar-bg">
									<span class="gbar" style="height:87%;"></span>
								</span>
							</li>
						</ul>
						<p class="tit"><span>월별 경영실적</span></p>
					</div><!--barG-wrap-->
				</div> <!--con-wrap-->
			</div><!--mC-top-->
			<div class="gap20"></div>
			<div class="mbC-bottom">
				<div class="bottom-L">
					<p class="tit _popBoardBtn_" onclick="javascript:goBoardPage(this, '${boardInfoList[0].boardId}');">${boardInfoList[0].boardNm}<!-- 공지사항 --><a href="#" class="more"></a></p>
					<div class="notice">
					<c:choose>
							<c:when test="${fn:length(boardList) > 0}">
								<c:set value="${fn:length(boardList)}" var="boardListSize"/>
									<c:forEach var="board" items="${boardList}" varStatus="status">
										<c:if test="${status.count eq 1}">
											<div class="today">
												<div class="day">
													<p class="dd">${fn:substring(board.regiDtm, 8,10) }</p>
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
													<c:if test="${notice.regiDtm eq today }"><span class="new">N</span></c:if>
													<span class="date">${board.regiDtm }</span>
												</p>
											</div>
											<ul class="notice-list">
										</c:if>
										<c:if test="${status.count ne 1}">
											<li class=" _popBoardBtn_" onclick="javascript:goBoardPage(this, '${boardInfoList[0].boardId}');">
											<c:forEach var="data" items="${categoryList}" varStatus="status">
												<c:if test="${data.cmcCode eq board.category }">
													<span class="category"  style="line-height: 15px; position: relative; margin-bottom:0">
														<c:out value="${data.cnmName }"/>
													</span>
												</c:if>
											</c:forEach>
											<a href="#n">${board.titleCut }</a>
											<span>${board.regiDtm }</span>
										</li>
										</c:if>
									</c:forEach>
											</ul>
							</c:when>
							<c:otherwise>
									<div class="today">
										<p class="today-tit">게시글이 없습니다.</p>
									</div>
							</c:otherwise>
					</c:choose>
					</div>
					<!-- <div class="notice">
						<div class="today">
							<div class="day">
								<p class="dd">20</p>
								<p class="yy-mm">2017.08</p>
							</div>
							<p class="today-tit"><a href="board-view.html">새로운 업무공간에서 새로운 마음으로 힘차게...</a><span class="new">N</span><span class="date">2017-11-26</span></p>
						</div>
						<ul class="notice-list">
							<li><a href="board-view.html">임시공휴일 지정으로 인해서 5일 - 6일 이틀간 업무...</a><span>2017-11-26</span></li>
							<li><a href="board-view.html">업무에 참고하시기 바랍니다.</a><span>2017-11-26</span></li>
							<li><a href="board-view.html">업무 조기 마감으로 인해 근무 시간이 조정됩니다</a><span>2017-11-26</span></li>
							<li><a href="board-view.html">덴소코리아 신입사원교육</a><span>2017-11-26</span></li>
						</ul>
					</div> --><!--notice-->
				</div><!--bottom-L-->
				<div class="bottom-R">
					<p class="tit _popBoardBtn_" onclick="javascript:goBoardPage(this, '${boardInfoList[1].boardId}');">${boardInfoList[1].boardNm}<!-- 자료실 --><a href="#" class="more"></a></p>
					<ul class="reference">
						<c:choose>
							<c:when test="${fn:length(refList) > 0}">
								<c:set value="${fn:length(refList)}" var="boardListSize"/>
									<c:forEach var="ref" items="${refList}" varStatus="status">
										<li class=" _popBoardBtn_" onclick="javascript:goBoardPage(this, '${boardInfoList[1].boardId}');">
											<c:forEach var="data" items="${categoryList}" varStatus="status">
												<c:if test="${data.cmcCode eq ref.category }">
													<span class="category"  style="line-height: 14px; position: relative; margin-bottom:0">
														<c:out value="${data.cnmName }"/>
													</span>
												</c:if>
											</c:forEach>
											<a href="#">${ref.titleCut }</a>
											<c:if test="${ref.fileCnt > 0 }">
												<span class="file"></span>
											</c:if>
											<span class="date">${ref.regiDtm }</span>
										</li>
									</c:forEach>
							</c:when>
							<c:otherwise>
								<li>
									게시글이 없습니다.
								</li>	
							</c:otherwise>
					</c:choose>
						<!-- <li>
							<a href="#n">덴소코리아 프로젝트 관련 자료</a><span class="file"></span>
							<span class="date">2017-11-26</span>
						</li>
						<li>
								<a href="#n">덴소코리아 프로젝트 관련 자료</a><span class="file"></span>
								<span class="date">2017-11-26</span>
						</li>
						<li>
								<a href="#n">덴소코리아 프로젝트 관련 자료</a><span class="file"></span>
								<span class="date">2017-11-26</span>
						</li>
						<li>
								<a href="#n">덴소코리아 프로젝트 관련 자료</a><span class="file"></span>
								<span class="date">2017-11-26</span>
						</li>
						<li>
								<a href="#n">덴소코리아 프로젝트 관련 자료</a><span class="file"></span>
								<span class="date">2017-11-26</span>
						</li> -->
					</ul>
				</div><!--bottom-R-->
			</div><!--mbC-top-->
		</div><!--main-con-->
	</div><!--main-con-wrap-->
</div><!--cont-wrap-->
<div class="cont-bg"></div>