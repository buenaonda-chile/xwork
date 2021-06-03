<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../view/include/taglib.jsp"%>
<script type="text/javascript" src='<c:url value="/resources/static/js/common.js"/>'></script>

<script type="text/javascript">
Array.prototype.remove = function(idx) {
	return (idx<0 || idx>this.length) ? this : this.slice(0, idx).concat(this.slice(idx + 1, this.length));
};

String.prototype.startsWith = function(prefix) {    
	return this.indexOf(prefix) == 0;
};

String.prototype.endsWith = function(suffix) {
	return this.match(suffix+"$") == suffix;
};

String.prototype.contains = function(str) {
	return this.indexOf(str) != -1; 
};

//set $root
var $root = '<c:url value="/"/>'=='/'?'':'<c:url value="/"/>';

if($root.indexOf(';jsessionid') > -1) {
    $root = $root.substr(0, $root.indexOf(';jsessionid'));
}

if($root.lastIndexOf('/')==($root.length-1)) $root = $root.substr(0, $root.length-1);

if(location.pathname.startsWith($root)){
	$path = location.pathname.substr($root.length+1).split('/');
}

$(document).ready(function () {
	var saveName = getCookie("loginUserId");
	$("#user_id").text(saveName);
	$(".state_logout").hide();
	$(".state_login").show();
	
	
	$('#gnb-menu').find('li[id="' + $path[0] + '"]').find('a').addClass('on');
	
});

function logout(){
	if(confirm('로그아웃 하시겠습니까?')){
		setCookie("loginUserId", "", -1);
		setCookie("loginUserNo", "", -1);
		
		location.href = "/densopf/main/login";
	}else{
		return;
	}
}

</script>

<!-- s: header container -->
<div id="header_container"> 
	<div class="inner_content"> 
		<h1 class="logo"><a href="#"><img src="<c:url value="/resources/static/images/img_logo01.gif"/>" width="220" height="30" alt="Smart Appcessory" /></a></h1>
		<p class="userinfo"><strong id="user_id"></strong>님 <a href="#"><img src="<c:url value="/resources/static/images/btn_logout01.gif"/>" width="62" height="22" onclick="javascript:logout();" alt="로그아웃" /></a></p>
	</div>
	<div class="gnb_wrap">
		<ul id="gnb-menu">
			<li id="notice"><a href="<c:url value="/notice/news/list"/>">게시판 관리</a></li>
			<li id="service"><a href="<c:url value="/service/main/banner/list"/>">서비스 관리</a></li>
			<li id="partnership"><a href="<c:url value="/partnership/sample/list"/>">샘플/제휴 신청관리</a></li>
			<li id="admin"><a href="<c:url value="/admin/memberList/"/>">Admin 관리</a></li>
		</ul>
	</div>
</div> 
<!-- e: header container -->