
<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/WAJ002Main.js"></script>

<div class="ico-menu opened" id="shortcut" style="z-index: 200; right: -242px;">
	<div class="icoM-wrap">
		<div class="topBar">
			<a href="#n"></a>
			<span><spring:message code="label.shortcut" /></span>
		</div>
		<ul>
			<li class="n-bg">
			<%-- 
				<a href="http://10.73.254.21/displaySession.jsp?EmpNo='E110290'&Company='PE'&PlantCd='E1'" target="_blank" title="display session 새창열림">
			--%>	
				<a href="javascript:void(0)"  data-systemNm="disPlay" onclick="sessionLink(this)">
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
				<span class="tit"><spring:message code="label.groupware" /><spring:message code="label.system" /><!-- 시스템 --></span>
				</a>
			</li>
			<li class="icoM-03 ">
				<a href="javascript:void(0)" data-systemType="internal"  onclick="pageLink(this)">
				<span class="tit"><spring:message code="label.internal" /> <spring:message code="label.sites" /><!-- 사내업무사이트 --></span>
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
				<span class="tit"><spring:message code="label.visit" /><spring:message code="label.site" /><!-- 방문자예약사이트 --></span>			
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