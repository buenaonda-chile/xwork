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


<!-- container:S -->
    <div id="m-container">
		<div class="notice-bar">
			<h3 class="notice-icon"></h3>
			<div class="notice-bar-wrap">
				<div class="notice-slide">
					<div class="item"><a href="#n"><span>임시공휴일 지정으로 인해 5일 - 6일 업무 하지 않습니다.</span></a></div>
					<div class="item"><a href="#n"><span>덴소코리아 신입 연수</span></a></div>
					<div class="item"><a href="#n"><span>업무에 참고하세요</span></a></div>
				</div>
			</div><!--notice-bar-wrap-->
		</div><!--notice-bar-->
    	<div class="bg-wrap">
			<div class="cont-bg">
				<div class="tab-wrap">
					<ul class="tab">
						<li class="tab-li on"><a href="#n"><spring:message code="label.business"/><spring:message code="label.performance"/><!-- 경영실적 --></a></li>
						<li class="tab-li"><a href="#n"><spring:message code="label.computational"/><!-- 전산 --></a></li>
						<li class="tab-li"><a href="#n"><spring:message code="label.Marketing"/><!-- 마케팅 --></a></li>
					</ul>
					<a href="#" class="set"></a>
				</div>
				<div class="cont">
					<div class="grape-wrap" style="visibility:hidden; height:200px;"> 
						<div class="circleG-wrap">
							<div class="inwrap">
								<div class="circleChart">
								 <svg class="circle-chart" viewbox="0 0 33.83098862 33.83098862" width="158px" height="158px">
								<circle class="circle-chart__background" stroke="#ecf2f6" stroke-width="2.4" fill="none" cx="16.51549431" cy="16.51549431" r="15.51549431" />
								<circle class="circle-chart__circle" stroke="#47bac1" stroke-width="2.4" stroke-dasharray="59.3,100" stroke-linecap="round" fill="none" cx="16.71549431" cy="16.71549431" r="15.51549431" />
									<p class="cChart-txt cChart1-txt">
										<span class="num">596.5</span>
										<span class="tit">매출액</span>
									</p>
								</div>
								<div class="circleChart">
									<svg class="circle-chart" viewbox="0 0 33.83098862 33.83098862" width="158px" height="158px">
									<circle class="circle-chart__background" stroke="#ecf2f6" stroke-width="2.4" fill="none" cx="16.71549431" cy="16.71549431" r="15.51549431" />
									<circle class="circle-chart__circle" stroke="#d7363c" stroke-width="2.4" stroke-dasharray="81.5,100" stroke-linecap="round" fill="none" cx="16.71549431" cy="16.71549431" r="15.51549431" />
									<p class="cChart-txt cChart2-txt">
										<span class="num">815</span>
										<span class="tit">수출액</span>
									</p>
								</div>	
								<div class="circleChart last">
									<svg class="circle-chart" viewbox="0 0 33.83098862 33.83098862" width="158px" height="158px">
									<circle class="circle-chart__background" stroke="#ecf2f6" stroke-width="2.4" fill="none" cx="16.71549431" cy="16.71549431" r="15.51549431" />
									<circle class="circle-chart__circle" stroke="#ae69af" stroke-width="2.4" stroke-dasharray="80,100" stroke-linecap="round" fill="none" cx="16.71549431" cy="16.71549431" r="15.51549431" />
									<p class="cChart-txt cChart3-txt">
										<span class="num">80<span class="per">%</span></span>
										<span class="tit">영업이익</span>
									</p>
								</div>
								<p class="tit"><span>전기대비 25% 상승</span></p>
							</div><!--inwrap-->
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
								<li class="m5">
									<span class="gtxt">5월</span>
									<span class="gbar-bg">
										<span class="gbar" style="height:51%;"></span>
									</span>
								</li>
								<li class="m6">
									<span class="gtxt">6월</span>
									<span class="gbar-bg">
										<span class="gbar" style="height:74%;"></span>
									</span>
								</li>
								<li class="m7">
									<span class="gtxt">7월</span>
									<span class="gbar-bg">
										<span class="gbar" style="height:69%;"></span>
									</span>
								</li>
								<li class="m8">
									<span class="gtxt">8월</span>
									<span class="gbar-bg">
										<span class="gbar" style="height:87%;"></span>
									</span>
								</li>
							</ul>
							<p class="tit"><span>월별 경영실적</span></p>
						</div><!--barG-wrap-->
					</div><!--grape-wrap-->
				</div>
			</div>
		</div>
    </div>

    <!-- container:E -->