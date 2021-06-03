/*업무상세 입력창 띄우기*/
$(document).ready(function() {
	$('.pj_regist').find('table td .detail_bnt').click(function(){
		$('.pj_regist').find('.detail').hide();
		$(this).parent('td').find('.detail').show();	
	}).focus(function(){
		$(this).parent('td').find('.detail').show();	
		$(this).siblings('td').find('.detail').hide();
	});
	
	$('.detail').find('.close').click(function(){
		$('.detail').hide();
	});










	/*보전이력분석 팝업 띄우기*/

	$('.gm_01_02_01_wrap .view-bnt-big').click(function(){
		window.open("gm_01_02_02.html", "a", "width=1038, height=auto, left=100, top=50");
	});
	$('.gm_01_02_02_wrap .close').click(function(){
		self.close();
	});


	/*종합관리 표 스크롤*/

	(function($){
		$(window).load(function(){
				$(".thfFix").mCustomScrollbar();
		});
	})(jQuery)		


});