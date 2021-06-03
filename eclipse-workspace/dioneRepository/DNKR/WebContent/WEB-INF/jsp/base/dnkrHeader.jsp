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


<div id="header-wrap">
		<div id="header">
			<div class="div-wrap">
				<div class="hd-left">
					<p class="username-deco"><img src="/img/username-deco.png"></p>
					<p><span class="user-name">${empName }</span>님 반갑습니다.</p></div>
				<div class="hd-right">
					<div class="dropdown hd-lang-sel">
						<button type="button" class="dropbtn-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Language</button>
						  <ul id="dropdown" class="dropdown-menu" role="menu" >
						    <c:choose>
								<c:when test="${empty main}">  	
								    <li  role="presentation"><a href="init.do?locale=kr&menu=${menu}" id="langKr">Korean</a></li>
								    <li  role="presentation"><a href="init.do?locale=en&menu=${menu}" id="langEn">English</a></li>
								    <li role="presentation"><a href="init.do?locale=ja&menu=${menu}" id="langJa">Japanese</a></li>
							    </c:when>
					    		<c:otherwise>  	
								    <li role="presentation"><a href="main.do?locale=kr">Korean</a></li>
								    <li role="presentation"><a href="main.do?locale=en">English</a></li>
								    <li role="presentation"><a href="main.do?locale=ja">Japanese</a></li>
							    </c:otherwise>
						    </c:choose>
						  </ul>
					</div>
					<div class="hd-icon">
<%-- 즐겨찾기 기능오류 임시삭제 - 2018.12.14
						<p class="bookmark">
							<a href="#"><span class="icon-bookmark"></span></a>
						</p>
						<!-- <p class="email">
							<a href=""><span class="icon-email"></span><span class="num">3</span></a>
						</p> -->
						<c:if test="${inOutType eq 'O'}" >
							<p class="my">
--%>	
								<%-- <a href="javascript:void(0)" onclick="javascript:location.href='/WAB006EmpMyPage/init.do?tabId=<c:out value="${tabId}"></c:out>&menu=<c:out value="${menu}"></c:out>';"><span class="icon-my"></span></a> --%>
<%-- 즐겨찾기 기능오류 임시삭제 - 2018.12.14
								<c:choose>
									<c:when test="${empty main}">
										<a href="<%= request.getContextPath() %>/WAB006EmpMyPage/init.do?menu=myPage" id="myPage" onclick="return loadTab(this);" data-name="마이페이지">
									</c:when>
									<c:otherwise>
										<a href="<%= request.getContextPath() %>/WAA000Sub/init.do?menu=myPage" id="myPage" data-name="마이페이지">										
									</c:otherwise>
								</c:choose>
								<span class="icon-my"></span></a>
							</p>
						</c:if>
--%>
						<p class="logout">
							<a href="/logout.do"><span class="icon-logout"></span></a>
						</p>
					</div><!--hd-icon-->
				</div><!--hd-right-->
			</div><!--div-wrap-->
		</div><!--header-->
	</div><!--header-wrap-->
	<div class="bookmark-page">
		<div class="bmark-top">
			<p class="title"><spring:message code='label.WAP001.title' /></p>
			<p class="set-icon"><a href="#n" onclick="window.open('/WAP001Bkmk/init.do','bkmk','width=950,height=700,top=100,left=100');"><img src="/img/setup-icon.png" alt="즐겨찾기설정"></a></p>
			<p class="close"><a href="#"><img src="/img/depth-close.png" alt="창닫기버튼"></a></p>
		</div>
		<div class="gap30"></div>
		<ul class="bmark-con mCustomScrollbar "  data-mcs-theme="pink">
			<%-- <li>
				<p class="left-line"></p>
				<p class="deco"></p>
				<c:choose>
					<c:when test="${empty main}">
						<a href="<%= request.getContextPath() %>/WAB001EmpSearch/init.do" id="emp" 
							<c:choose>
								<c:when test="${subDomain.mcdNewWindow eq 'Y'}">
									target="blank"
								</c:when>
								<c:otherwise>
									onclick="return loadTab(this);"
								</c:otherwise>
							</c:choose> 
						data-name="<spring:message code="label.WAB001.name" />">
					</c:when>
					<c:otherwise>
						<a href="<%= request.getContextPath() %>/WAA000Sub/init.do?menu=emp" id="emp" data-name="<spring:message code="label.WAB001.name" />">										
					</c:otherwise>
				</c:choose>
				<span class="icon-bg"><img src="/img/main-icon01.png" alt="시스템관리"></span><spring:message code="label.WAB001.name" /></a>
				
			</li> --%>
			
			<c:forEach var="list" items="${bkmkList }">
				<li>
					<p class="left-line"></p>
					<p class="deco"></p>
					<c:choose>
						<c:when test="${empty main}">
							<a href="<%= request.getContextPath() %>${list.mcdUrl }?menu=${list.menuCode }" id="${list.menuCode }" onclick="return loadTab(this)" data-name="${list.menuCodeNm }">
								<span class="icon-bg"><span class="${list.mcdIcon}" style="font-size:40px;line-height:1.8;"></span></span>
								<span>${list.menuCodeNm }</span>
								
							</a>
							
						</c:when>
						<c:otherwise>
							<a href="<%= request.getContextPath() %>/WAA000Sub/init.do?menu=${list.menuCode}" id="${list.menuCode }"data-name="${list.menuCodeNm }">
								<span class="icon-bg"><span class="${list.mcdIcon}" style="font-size:40px;line-height:1.8;"></span></span>
								<span>${list.menuCodeNm }</span>
							</a>
						</c:otherwise>
					</c:choose>
				</li>
			</c:forEach>
			<!-- 
			<li>
				<p class="left-line"></p>
				<p class="deco"></p>
				<a href="#">
					<span class="icon-bg"><img src="/img/main-icon02.png" alt="시스템관리"></span>
				프로젝트관리-1
				</a>
			</li>
			<li>
				<p class="left-line"></p>
				<p class="deco"></p>
				<a href="#">
					<span class="icon-bg"><img src="/img/main-icon03.png" alt="시스템관리"></span>
				종합관리-2
				</a>
			</li>
			<li>
				<p class="left-line"></p>
				<p class="deco"></p>
				<a href="#">
					<span class="icon-bg"><img src="/img/main-icon04.png" alt="시스템관리"></span>
				경영관리-2
				</a>
			</li>
			<li>
				<p class="left-line"></p>
				<p class="deco"></p>
				<a href="#">
					<span class="icon-bg"><img src="/img/main-icon05.png" alt="시스템관리"></span>
				설문조사
				</a>
			</li> -->
		</ul>
	</div>
	
	
		<div id="mainNav-wrap">
		<h1 id="logo"><a href="/main.do"><img src="/img/logo.png" alt="로고"></a></h1>
		<p class="menu-bnt"><a href="#"><img src="/img/menu-bnt.png" alt="전체메뉴버튼"></a></p>
		<div class="gap20"></div>
		<div id="mainNav">
			<ul>
				<c:if test="${fn:length(menuList) > 0}">
					<c:forEach var="menuDomain" items="${menuList}" varStatus="status">
						<li class="lm_l1">
							<a href="#" class="lm_a1" >
								<!-- <span class="icon-menu01"></span> -->
								<span class="${menuDomain.mcdIcon}"></span>
								<%-- <p class="mNname"><span class="tri">◀</span><spring:message code="label.menu.system" /></p> --%>
								<p class="mNname"><span class="tri">◀</span><c:out value="${menuDomain.mcdName }"/></p>
							</a>
							<div class="depth-wrap">
								<div class="depth2-wrap">
									<%-- <h2><spring:message code="label.menu.system" /></h2> --%>
									<h2><c:out value="${menuDomain.mcdName }"/></h2>
									<c:if test="${fn:length(menuDomain.subList)>0}">
										<ul class="depth2">
											<c:forEach var="subDomain" items="${menuDomain.subList}" varStatus="status">
												<li class="depth2-li">
													<!-- ì¬ì©ìê´ë¦¬1 -->
													<%-- <a href="<%= request.getContextPath() %>/WAB001EmpSearch/init.do" onclick="return loadTab(this);" class="li-bg" data-name="<spring:message code="label.WAB001.name" />"><span class="li-deco"></span><spring:message code="label.WAB001.name" /></a> --%>
													
													<c:if test="${fn:length(subDomain.subList) == 0}"><!-- 3depth 메뉴가 없으면 -->
														<c:set var = "depth2_p" value="${fn:split(subDomain.mcdUrl, '?')}"/>
														<c:choose>
															<c:when test="${empty main}">
																<c:choose>
																	<c:when test="${fn:length(depth2_p) == 2}">
																
																		<a href="<%= request.getContextPath() %>${depth2_p[0]}?menu=${subDomain.mcdCode}&${depth2_p[1]}" id="${subDomain.mcdCode }"
																	</c:when>
																	<c:when test="${subDomain.mcdAddCert eq 'Y'}">
																		<a href= "<%= request.getContextPath() %>${depth2_p[0]}addCert.do?menu=${subDomain.mcdCode}&${depth2_p[1]}" id="${subDomain.mcdCode }"
																	</c:when> 
																	<c:otherwise>
																		<a href="<%= request.getContextPath() %>${subDomain.mcdUrl}?menu=${subDomain.mcdCode}" id="${subDomain.mcdCode }"
																	</c:otherwise>
																</c:choose> 
																<c:choose>
																	<c:when test="${subDomain.mcdNewWindow eq 'Y'}">
																		target="blank"
																	</c:when>
																	<c:otherwise>
																		onclick="return loadTab(this);"
																	</c:otherwise>
																</c:choose>
																class="li-bg" data-name="${subDomain.mcdName }">
																<%-- <a href="<%= request.getContextPath() %>/WAB001EmpSearch/init.do" id="emp" onclick="return loadTab(this);" class="li-bg" data-name="<spring:message code="label.WAB001.name" />"> --%>
															</c:when>
															<c:otherwise>
																<c:choose>
																	<c:when test="${fn:length(depth2_p) == 2}">
																		<a href="<%= request.getContextPath() %>/WAA000Sub/init.do?menu=${subDomain.mcdCode }&${depth2_p[1]}"
																	</c:when>
																	<c:when test="${subDomain.mcdAddCert eq 'Y'}">
																		<a href= "<%= request.getContextPath() %>/WAA000Sub/addCert.do?menu=${subDomain.mcdCode }"
																	</c:when>
																	<c:otherwise>
																		<a href="<%= request.getContextPath() %>/WAA000Sub/init.do?menu=${subDomain.mcdCode }"
																	</c:otherwise>
																</c:choose> 
																<c:if test="${subDomain.mcdNewWindow eq 'Y'}">
																	target="blank"
																</c:if>
																id="${subDomain.mcdCode }" class="li-bg" data-name="${subDomain.mcdName }">										
															</c:otherwise>
														</c:choose>
													
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
																		<c:when test="${empty main}">
																			<%-- <a href="<%= request.getContextPath() %>${lastSubDomain.mcdUrl}?menu=${lastSubDomain.mcdCode}" id="${lastSubDomain.mcdCode }" --%>
																				<c:choose>
																					<c:when test="${fn:length(depth3_p) == 2}">
																						<a href="<%= request.getContextPath() %>${depth3_p[0]}?menu=${lastSubDomain.mcdCode}&${depth3_p[1]}" id="${lastSubDomain.mcdCode }"
																					</c:when>
																					<c:when test="${lastSubDomain.mcdAddCert eq 'Y'}">
																						<a href= "<%= request.getContextPath() %>/WAA000Sub/addCert.do?menu=${lastSubDomain.mcdCode }" id="${lastSubDomain.mcdCode }"
																					</c:when>
																					<c:otherwise>
																						<a href="<%= request.getContextPath() %>${lastSubDomain.mcdUrl}?menu=${lastSubDomain.mcdCode}" id="${lastSubDomain.mcdCode }"
																					</c:otherwise>
																				</c:choose>
																				<c:choose> 
																					<c:when test="${lastSubDomain.mcdNewWindow eq 'Y'}">
																						target="blank"
																					</c:when>
																					<c:otherwise>
																						onclick="return loadTab(this);"
																					</c:otherwise>
																				</c:choose>
																			 data-name="${lastSubDomain.mcdName }">
																			<%-- <a href="<%= request.getContextPath() %>/WAB001EmpSearch/init.do" id="emp" onclick="return loadTab(this);" class="li-bg" data-name="<spring:message code="label.WAB001.name" />"> --%>
																		</c:when>
																		<c:otherwise>
																	
																			<%-- <a href="<%= request.getContextPath() %>/WAA000Sub/init.do?menu=${lastSubDomain.mcdCode }" --%>
																				<c:choose>
																					<c:when test="${fn:length(depth3_p) == 2}">
																						<a href="<%= request.getContextPath() %>/WAA000Sub/init.do?menu=${lastSubDomain.mcdCode }&${depth3_p[1]}" id="${lastSubDomain.mcdCode }"
																					</c:when>
																					<c:when test="${lastSubDomain.mcdNewWindow eq 'Y'}">
																						<a href="<%= request.getContextPath() %>${lastSubDomain.mcdUrl}?menu=${lastSubDomain.mcdCode }"
																					</c:when>
																					<c:when test="${lastSubDomain.mcdAddCert eq 'Y'}">
																						<a href= "<%= request.getContextPath() %>/WAA000Sub/addCert.do?menu=${lastSubDomain.mcdCode }" 
																					</c:when>
																					<c:otherwise>
																						<a href="<%= request.getContextPath() %>/WAA000Sub/init.do?menu=${lastSubDomain.mcdCode }"
																					</c:otherwise>
																				</c:choose> 
																				<c:if test="${lastSubDomain.mcdNewWindow eq 'Y'}">
																					target="blank"
																				</c:if>
																			id="${lastSubDomain.mcdCode }" data-name="${lastSubDomain.mcdName }">										
																		</c:otherwise>
																	</c:choose>
																	<c:out value="${lastSubDomain.mcdName }"/></a>
																</li>
															</c:forEach>
														</ul>
													</c:if>
												</li>
											</c:forEach>
										</ul>
									</c:if>
									<a href="#" class="Mmenu-close-btn"><img src="/img/depth-close.png" alt="창닫기버튼"></a>
								</div><!--depth2-wrap-->
							</div><!--depth-wrap-->
						</li>
					</c:forEach>
				</c:if>
			</ul>
			<div class="gap20"></div>
			<div class="mNav-ctrl">
				<a href="#n" class="als-prev"><img src="/img/arrow-top.png" alt="위로가기"></a>
				<a href="#n" class="als-next"><img src="/img/arrow-bottom.png" alt="아래로가기"></a>
			</div>
		</div><!--mainNav-->
		<div class="home"><a href="/main.do"><img src="/img/home.png" alt="홈버튼"></a></div>
	</div><!--mainNav-wrap-->
	