<%-- [EN] Variable definition --%>
<%-- [JP] 変数定義 --%>
<!-- 서비스 -->
<c:url var="menu1Url" value="/mobile/serviceSD/init"/>
<c:url var="menu2Url" value="/mobile/serviceSD/init"/>
<c:url var="menu3Url" value="/mobile/board/notice/init"/>
<c:url var="menu4Url" value="/mobile/board/file/init"/>

<div id="tnb1" class="init">
	<div class="bg"></div>
	<h3 class="blind">주메뉴</h3>
	<%-- d1 --%>
	<div class="d1">
		<%-- tnb1_head --%>
		<div class="tnb1_head">
			<div class="logo"><span class="blind">로고</span></div>
			<p class="t1">${userStore.getEgovUserVO().getFulnm()}님, 반갑습니다.</p>
			<p class="t2">
				<c:choose>
					<c:when test="${userStore.getEgovUserVO().getOfficeCd() != null}">
						${userStore.getEgovUserVO().getOfficeNm()}
					</c:when>
					<c:otherwise>
						${userStore.getEgovUserVO().getDeptNm()}
					</c:otherwise>
				</c:choose>
			</p>
		</div>
		<%--// tnb1_head --%>
		<%-- ul menu --%>
		<ul>
			<li class="m1"><a href="${menu1Url}"><i></i>클레임접수</a></li>
			<li class="m2"><a href="${menu2Url}"><i></i>비용청구</a></li>
			<li class="m3"><a href="${menu3Url}"><i></i>공지사항</a></li>
			<li class="m4"><a href="${menu4Url}"><i></i>자료실</a></li>
		</ul>
		<%--// ul menu --%>
	</div>
	<%--// d1 --%>
</div>
