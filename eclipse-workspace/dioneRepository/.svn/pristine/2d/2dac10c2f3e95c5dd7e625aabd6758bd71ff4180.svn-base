<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../view/include/taglib.jsp"%>
<script type="text/javascript">
	$(document).ready(
			function() {
				$('#' + $path[0] + '_lnb').css("display", "block");
				$('#' + $path[0] + '_'+ $path[1]).addClass('on');
	});
</script>
<!-- s: left content -->
<div class="left_content">
	<div class="lnb_wrap">

		<!-- s : 게시판 관리  -->
		<div id="notice_lnb" style="display: none;">
			<h2 class="tit">게시판 관리</h2>
			<ul>
				<li id="notice_news" class="sm"><a href="<c:url value="/notice/news/list"/>" class="m">뉴스/공지 관리</a>
					<ul>
						<li>- <a href="<c:url value="/notice/news/list"/>">뉴스/공지
								리스트</a></li>
						<li>- <a
							href="<c:url value="/notice/news/proc?type=regist"/>">뉴스/공지
								등록</a></li>
					</ul></li>
				<li id="notice_press" class="sm"><a href="<c:url value="/notice/press/list"/>" class="m">Press 관리</a>
					<ul>
						<li>- <a href="<c:url value="/notice/press/list"/>">Press
								리스트</a></li>
						<li>- <a
							href="<c:url value="/notice/press/proc?type=regist"/>">Press
								등록</a></li>
					</ul></li>
				<li id="notice_faq" class="sm"><a href="<c:url value="/notice/faq/list"/>" class="m">FAQ 관리</a>
					<ul>
						<li>- <a href="<c:url value="/notice/faq/list"/>">FAQ 리스트</a></li>
						<li>- <a href="<c:url value="/notice/faq/proc?type=regist"/>">FAQ
								등록</a></li>
					</ul></li>
			</ul>
			<!-- e : 게시판 관리  -->
		</div>

		<!-- s : 서비스 관리  -->
		<div id="service_lnb" style="display: none;">
			<h2 class="tit">서비스 관리</h2>
			<ul>
				<li id="service_main" class="sm"><a href="<c:url value="/service/main/banner/list"/>" class="m">메인 화면 관리</a>
					<ul>
						<li>- <a href="<c:url value="/service/main/banner/list"/>">메인 배너 관리</a></li>
						<li>- <a href="<c:url value="/service/main/thumbnail/list"/>">상품 썸네일 관리</a></li>
						<li>- <a href="<c:url value="/service/main/product/list"/>">제품 리스트 관리</a></li>
					</ul></li>
					<li id="service_mobile" class="sm"><a href="<c:url value="/service/mobile/mobilebanner/list"/>" class="m">모바일 메인 화면 관리</a>
					<ul>
						<li>- <a href="<c:url value="/service/mobile/mobilebanner/list"/>">메인 배너 관리</a></li>
						<li>- <a href="<c:url value="/service/mobile/mobilethumbnail/list"/>">상품 썸네일 관리</a></li>
					</ul></li>
				<li id="service_purchase" class="sm"><a href="<c:url value="/service/purchase/list"/>" class="m">판매처 정보 관리</a>
					<ul>
						<li>- <a href="<c:url value="/service/purchase/list"/>">판매처 리스트</a></li>
						<li>- <a href="<c:url value="/service/purchase/proc?type=regist"/>">판매처 등록</a></li>
					</ul></li>
			</ul>
			<!-- e : 서비스 관리  -->
		</div>

		<!-- s : 샘플신청/구독관리  -->
		<div id="partnership_lnb" style="display: none;">
			<h2 class="tit">샘플/제휴 신청 관리</h2>
			<ul>
				<li id="partnership_sample"  class="sm"><a href="<c:url value="/partnership/sample/list"/>" class="m">샘플 신청 관리</a>
					<ul>
						<li>- <a href="<c:url value="/partnership/sample/list"/>">샘플 신청 리스트</a></li>
					</ul></li>
				<li id="partnership_cooperate"  class="sm"><a href="<c:url value="/partnership/cooperate/list"/>" class="m">제휴 신청 관리</a>
					<ul>
						<li>- <a href="<c:url value="/partnership/cooperate/list"/>">제휴 신청 리스트</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- e : 샘플신청/구독관리  -->

		<!-- s: ADMIN 관리 -->
		<div id="admin_lnb" style="display: none;">
			<h2 class="tit">Admin 관리</h2>
			<ul>
				<li id="member" class="sm"><a href="<c:url value="/admin/memberList"/>" class="m" >Admin 회원 관리</a>
					<ul>
						<li>- <a href="<c:url value="/admin/memberList"/>">Admin 회원 리스트</a></li>
						<li>- <a href="<c:url value="/admin/memberInsert"/>">Admin 회원 등록</a></li>
					</ul></li>
				<li id="approvalWait" class="sm"><a href="<c:url value="/admin/approvalWaitList"/>" class="m">Admin 회원 승인 관리</a>
					<ul>
						<li>- <a href="<c:url value="/admin/approvalWaitList"/>">Admin 회원 승인 대기 리스트</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- e: ADMIN 관리 -->
	</div>
</div>
<!-- e: left content -->

