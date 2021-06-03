//탭 메뉴 클릭
$(document).ready(function() {

	$(".tab").find("li.tab-li a").click(function(){
		$(this).parent('li.tab-li').siblings('li.tab-li').removeClass('on');
		$(this).parent('li.tab-li').addClass('on');
})

 //바로가기 팝업
	$('.topBar a').click(function(){
		if($(".ico-menu").hasClass("opened")){
			$(".ico-menu").removeClass("opened");
			$(".ico-menu").stop().animate({'right':'-242px'},300);
			initMiFlatform2();
			
			
		}else{
			$(".ico-menu").stop().animate({'right':'0px'},300);
			$('.ico-menu').css('box-shadow','-5px 0px 10px rgba(0, 0, 0, 0.1)')
			$('.ico-menu .topBar').css('box-shadow','-5px 1px 10px rgba(0, 0, 0, 0.25)')
			$(".ico-menu").addClass("opened");	
			
			slideMiFlatform2("200")
		}
		
	});
	
	$('.ico-menu').css('height', $(document).height());
	$('#mainNav-wrap').css('height', $(document).height());
})