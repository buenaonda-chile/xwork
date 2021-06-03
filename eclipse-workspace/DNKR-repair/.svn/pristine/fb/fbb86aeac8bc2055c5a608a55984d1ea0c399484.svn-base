<%--
 * Project : DICAS
 *
 * [EN] JSP is a common menu area of the entire screen.
 * [EN] Please implement depending on the requirements of each application.
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
--%>
<ul>
<%-- <c:choose>
  <c:when test="${fn:length(menuItems) > 0}">
    <c:forEach var="mainItem" items="${menuItems}" varStatus="status">
      <li class="lm_l1">
        <a href="javascript:;" class="lm_a1">
          <span class="${mainItem.menuIcon}"></span>
          <p class="mNname"><span class="tri">◀</span><c:out value="${mainItem.menuNm}"/></p>
        </a>
        <div class="depth-wrap">
          <div class="depth2-wrap">
            <h2><c:out value="${mainItem.menuNm}"/></h2>
            <c:if test="${fn:length(mainItem.subMenuItems) > 0}">
              <ul class="depth2">
                <c:forEach var="menuItem2" items="${mainItem.subMenuItems}" varStatus="status2">
                  <li class="depth2-li">
                    <c:choose>
                      <c:when test="${fn:length(menuItem2.subMenuItems) == 0}">
                        <c:choose>
                          <c:when test="${fn:length(menuItem2.menuUrl) > 0}">
                            <a href="<c:url value="${menuItem2.menuUrl}"/>" id="${menuItem2.menuCd}" onclick="javascript: return loadTab(this);" style="border-bottom: 1px solid #dddddd;" data-name="${menuItem2.menuNm}" data-menu-id="${menuItem2.menuKey}">
                              <span class="li-deco"></span><c:out value="${menuItem2.menuNm}"/>
                            </a>
                          </c:when>
													<c:otherwise>
                            <a href="javascript:;" id="${menuItem2.menuCd}" style="border-bottom: 1px solid #dddddd;" data-name="${menuItem2.menuNm}" data-menu-id="${menuItem2.menuKey}">
                              <span class="li-deco"></span><c:out value="${menuItem2.menuNm}"/>
                            </a>
                          </c:otherwise>
                        </c:choose>
                      </c:when>
                      <c:otherwise>
                        <a href="javascript:;" class="li-bg"><span class="li-deco"></span><c:out value="${menuItem2.menuNm}"/></a>
                        <ul class="depth3">
                          <c:forEach var="menuItem3" items="${menuItem2.subMenuItems}" varStatus="status3">
                            <li>
                              <c:choose>
                                <c:when test="${fn:length(menuItem3.menuUrl) > 0}">
                                  <a href="<c:url value="${menuItem3.menuUrl}"/>" id="${menuItem3.menuCd}" onclick="javascript: return loadTab(this);" data-name="${menuItem3.menuNm}" data-menu-id="${menuItem3.menuKey}">
                                    <c:out value="${menuItem3.menuNm}"/>
                                  </a>
                                </c:when>
																<c:otherwise>
                                  <a href="javascript:;" id="${menuItem3.menuCd}" data-name="${menuItem3.menuNm}" data-menu-id="${menuItem3.menuKey}">
                                    <c:out value="${menuItem3.menuNm}"/>
                                  </a>
                                </c:otherwise>
                              </c:choose>
                            </li>
                          </c:forEach>
                        </ul>
                      </c:otherwise>
                    </c:choose>
                  </li>
                </c:forEach>
              </ul>
            </c:if>
            <a href="javascript:;" class="Mmenu-close-btn"><img src="<c:url value="/assets/img/depth-close.png"/>" alt="메뉴닫기"></a>
          </div>
        </div>
      </li>
    </c:forEach>
  </c:when>
  <c:otherwise> --%>
  <li class="lm_l1">
        <a href="javascript:;" class="lm_a1">
          <span class="axi-book3"></span>
          <p class="mNname"><span class="tri">◀</span>사외교육</p>
        </a>
        <div class="depth-wrap">
          <div class="depth2-wrap">
            <h2>사외교육</h2>
            <ul class="depth2">
                <li class="depth2-li">
                    <a href="javascript:;" class="li-bg"><span class="li-deco"></span>교육정보</a>
                        <ul class="depth3">
                          <li>
                              <a href="/trainingAppRegist/init2" id="7010400000" onclick="javascript: return loadTab(this);" data-name="교육신청등록" data-menu-id="149">
                                    교육신청등록</a>
                                </li>
                          <li>
                              <a href="/trainingAppView/init" id="7010500000" onclick="javascript: return loadTab(this);" data-name="교육신청자조회" data-menu-id="150">
                                    교육신청조회</a>
                                </li>
                          
                          </ul>
                      </li>
                </ul>
            <a href="javascript:;" class="Mmenu-close-btn"><img src="/assets/img/depth-close.png" alt="메뉴닫기"></a>
          </div>
        </div>
   </li>
   <%-- </c:otherwise>
   </c:choose> --%>
</ul>

