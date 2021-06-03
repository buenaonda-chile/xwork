<%--
 * dnkrHeader.jsp
 *
 * [EN] JSP is a common header area of the entire screen.
 * [EN] Please implement depending on the requirements of each application.
 *
 * [JP] 全画面のヘッダエリア共通のJSPです。
 * [JP] 各アプリの要件に応じて実装してください。
 *
 * $ header.jsp 1753 2015-07-03 00:24:13Z 815372040074 $
 *
 * Copyright (c) 2012 DENSO CORPORATION. All rights reserved.
--%>

<%-- [EN] Variable definition -----------------------------------------------------%>
<%-- [JP] 変数定義 ----------------------------------------------------------------%>

<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] 画面ID (@ViewIdで定義) --%>
<c:set var="screenId" value="<%= request.getAttribute(Globals.SCREEN_ID_KEY) %>"/>

<%-- [EN] Screen type (defined in tiles-defs.xml) --%>
<%-- [JP] 画面種別 (tiles-defs.xmlに定義) --%>
<c:set var="type"><tiles:getAsString name="type" /></c:set>

<%-- [EN] Screen mode (defined in tiles-defs.xml) --%>
<%-- [JP] 画面モード (tiles-defs.xmlに定義) --%>
<c:set var="mode"><tiles:getAsString name="mode" /></c:set>

<%-- [EN] Availability of changing language (defined i tiles-defs.xml) --%>
<%-- [JP] 言語切替可否 (tiles-defs.xmlに定義) --%>
<c:set var="language"><tiles:getAsString name="language" /></c:set>

<%-- [EN] Screen drawing ----------------------------------------------------------%>
<%-- [JP] 画面描画 ----------------------------------------------------------------%>

<!-- header:S -->
		<div id="header">
			<div id="logo"><a href="/"></a></div>
			<button type="button" class="bt-mnall" id="mn-ctrs-btns"><span class="blind">전체메뉴</span></button>
			<div id="navi-wrap">
				<div id="mainNavi">
					<button type="button" class="bt-mnclose"><span class="blind">전체메뉴 닫기</span></button>
					<div class="mn-tit">
						<p class="fl user-name ml10"><span class="name"><strong>${empName }</strong>님</span> 반갑습니다.</p>
						<a class="fr logout mr10" href="/logout.do"><img src="/img/main/logout-icon.png" alt="로그아웃"></a>
					</div>
					<ul class="menu depth1">
					
						<c:if test="${fn:length(menuList) > 0}">
							<c:forEach var="menuDomain" items="${menuList}" varStatus="status">
								<li id="menu1">
									<a href="#n">${menuDomain.mcdName }</a>
									<c:if test="${fn:length(menuDomain.subList)>0}">
										
										<ul class="depth2">
											<c:forEach var="subDomain" items="${menuDomain.subList}" varStatus="status">
												<li>
													<c:if test="${fn:length(subDomain.subList) == 0}"><!-- 3depth 메뉴가 없으면 -->
														<c:set var = "depth2_p" value="${fn:split(subDomain.mcdUrl, '?')}"/>
															<c:choose>
																<c:when test="${fn:length(depth2_p) == 2}">
																	<a href="<%= request.getContextPath() %>${depth2_p[0]}?menu=${subDomain.mcdCode}&${depth2_p[1]}" id="${subDomain.mcdCode }"
																</c:when>
																<c:otherwise>
																	<a href="<%= request.getContextPath() %>${subDomain.mcdUrl}?menu=${subDomain.mcdCode}" id="${subDomain.mcdCode }"
																</c:otherwise>
															</c:choose>
															target="blank" class="li-bg" data-name="${subDomain.mcdName }">
															<%-- <a href="<%= request.getContextPath() %>/WAB001EmpSearch/init.do" id="emp" onclick="return loadTab(this);" class="li-bg" data-name="<spring:message code="label.WAB001.name" />"> --%>
														<%-- <span class="li-deco"></span><spring:message code="label.WAB001.name" /></a> --%>
														<span class="li-deco"></span><c:out value="${subDomain.mcdName }"/></a>
													</c:if><!-- //3depth 메뉴가 없으면 -->
												
													<c:if test="${fn:length(subDomain.subList)>0}">
														<a href="#n" class="li-bg"><span class="li-deco"></span><c:out value="${subDomain.mcdName }"/></a>
														<ul class="depth3">
															<c:forEach var="lastSubDomain" items="${subDomain.subList}" varStatus="status">
																<li>
																	<!-- <a href="">depth3</a> -->
																	<c:set var = "depth3_p" value="${fn:split(lastSubDomain.mcdUrl, '?')}"/>
																		<c:choose>
																			<c:when test="${fn:length(depth3_p) == 2}">
																				<a href="<%= request.getContextPath() %>${depth3_p[0]}?menu=${lastSubDomain.mcdCode}&${depth3_p[1]}" id="${lastSubDomain.mcdCode }"
																			</c:when>
																			<c:otherwise>
																				<a href="<%= request.getContextPath() %>${lastSubDomain.mcdUrl}?menu=${lastSubDomain.mcdCode}" id="${lastSubDomain.mcdCode }"
																			</c:otherwise>
																		</c:choose>
																		<c:choose> 
																			<c:when test="${lastSubDomain.mcdNewWindow eq 'Y'}">
																				target="blank"
																			</c:when>
																		</c:choose>
																	 data-name="${lastSubDomain.mcdName }">
																	<%-- <a href="<%= request.getContextPath() %>/WAB001EmpSearch/init.do" id="emp" onclick="return loadTab(this);" class="li-bg" data-name="<spring:message code="label.WAB001.name" />"> --%>
																	<c:out value="${lastSubDomain.mcdName }"/></a>
																</li>
															</c:forEach>
														</ul>
													</c:if>
											
												</li>
										
											</c:forEach>
										
										
											<%-- <c:forEach var="subDomain" items="${menuDomain.subList}" varStatus="status">
												<li><a href="<%= request.getContextPath() %>${subDomain.mcdUrl}?menu=${subDomain.mcdCode}" id="${subDomain.mcdCode }"
													 	<c:choose>
															<c:when test="${subDomain.mcdNewWindow eq 'Y'}">
																target="blank"
															</c:when>
															<c:otherwise>
															</c:otherwise>
														</c:choose> >${subDomain.mcdName }</a></li>
											</c:forEach> --%>
										</ul>
									</c:if>
									<%-- <c:if test="${fn:length(menuDomain.subList)<=0}">
										<a href="<%= request.getContextPath() %>${menuDomain.mcdUrl}?menu=${menuDomain.mcdCode}" id="${menuDomain.mcdCode }"
											<c:choose>
												<c:when test="${menuDomain.mcdNewWindow eq 'Y'}">
													target="blank"
												</c:when>
												<c:otherwise>
												</c:otherwise>
											</c:choose>
										>${menuDomain.mcdName }</a>
									</c:if> --%>
									
								</li>
							</c:forEach>
						</c:if>
						<!-- <li id="menu1">
							<a href="#n">시스템관리</a>
							<ul class="depth2">
								<li><a href="/WAB001EmpSearch/init.do?menu=2">사용자관리</a></li>
								<li><a href="/WAC001BoardSearch/init.do?boardId=BID0001">공지사항관리</a></li>
							</ul>
						</li> -->
						<!-- <li id="menu2">
							<a href="#n">프로젝트 관리</a>
							<ul class="depth2">
								<li><a href="#">depth2</a></li>
								<li><a href="#">depth2</a></li>
								<li><a href="#">depth2</a></li>
							</ul>
						</li>
						<li id="menu3">
							<a href="#n">종합관리</a>
							<ul class="depth2">
								<li><a href="#">depth2</a></li>
								<li><a href="#">depth2</a></li>
								<li><a href="#">depth2</a></li>
							</ul>
						</li>
						<li id="menu4">
							<a href="#n">경영관리</a>
							<ul class="depth2">
								<li><a href="#">depth2</a></li>
								<li><a href="#">depth2</a></li>
								<li><a href="#">depth2</a></li>
							</ul>
						</li> -->
						<!-- <li id="menu5">
							<a href="#n">설문조사</a>
							<ul class="depth2">
								<li><a href="/WAG005SurveyPaper/init.do?menu=501">설문조사</a></li>
							</ul>
						</li>
						<li id="menu6">
							<a href="#n">메뉴1</a>
							<ul class="depth2">
								<li><a href="#">depth2</a></li>
								<li><a href="#">depth2</a></li>
								<li><a href="#">depth2</a></li>
							</ul>
						</li>
						<li id="menu7">
							<a href="#n">메뉴2</a>
							<ul class="depth2">
								<li><a href="#">depth2</a></li>
								<li><a href="#">depth2</a></li>
								<li><a href="#">depth2</a></li>
							</ul>
						</li>
						<li id="menu8">
							<a href="#n">메뉴3</a>
							<ul class="depth2">
								<li><a href="#">depth2</a></li>
								<li><a href="#">depth2</a></li>
								<li><a href="#">depth2</a></li>
							</ul>
						</li>
						<li id="menu9">
							<a href="#n">메뉴4</a>
							<ul class="depth2">
								<li><a href="#">depth2</a></li>
								<li><a href="#">depth2</a></li>
								<li><a href="#">depth2</a></li>
							</ul>
						</li> -->
					</ul>
				</div>
			</div>
			<div class="body-slider-ovclick"></div>
		</div>

    <!-- header:E-->
	
	