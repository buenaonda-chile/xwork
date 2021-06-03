
$(document).ready(function() {
		
//로그인화면 로그인 방법
	$("a.login-gui-bnt").click(function(){
		$(".login-gui-cont").fadeIn(300);
		
	})
	$(".login-gui-cont .close").click(function(){
		$(".login-gui-cont").fadeOut(300);	
	});


//메인화면 mainmenu
	$('.bt-mnall').click(function(){
		$('#mainNavi').show().stop().animate({'right':'0'},300);
		$('.body-slider-ovclick').show();
	})		
	$(".bt-mnclose").click(function(){
		$("#mainNavi").animate({'right':'-300'},300);
		$('.body-slider-ovclick').hide()
	});

	$(".body-slider-ovclick").click(function(){
		$(this).hide();
		$("#mainNavi").animate({'right':'-300'},300);
	});


//메인화면 mainmenu 아코디언
	$('.depth1 > li').find('a').click(function(){										
		$(this).parent().siblings('li').find('a').removeClass('on');
		$(this).parent('ul').removeClass('on');
		
		$(this).parent('li').find('.depth2').addClass('on');
		$(this).parent('li').find('.depth2').slideDown('fast');	
		$(this).parent('li').siblings('li').find('.depth2').slideUp('fast');
		$(this).parent('ul').removeClass('on');

	}).focus(function(){
		$(this).parent().siblings('li').find('a').removeClass('on');
		$(this).parent('ul').removeClass('on');
		$(this).addClass('on');
		$(this).parent('li').find('.depth2').slideDown('fast');	
		$(this).parent('li').siblings('li').find('.depth2').slideUp('fast');
	});

		$('.depth2 > li').find('a').click(function(){										
			$(this).parent().siblings('li').find('a').removeClass('on');
			$(this).parent('ul').removeClass('on');
			
			$(this).parent('li').find('.depth3').addClass('on');
			$(this).parent('li').find('.depth3').slideDown('fast');	
			$(this).parent('li').siblings('li').find('.depth2').slideUp('fast');
			$(this).parent('ul').removeClass('on');

		}).focus(function(){
			$(this).parent().siblings('li').find('a').removeClass('on');
			$(this).parent('ul').removeClass('on');
			$(this).addClass('on');
			$(this).parent('li').find('.depth3').slideDown('fast');	
			$(this).parent('li').siblings('li').find('.depth3').slideUp('fast');
		});

		/*1차메뉴 이미지 처리*/
		$('.depth1 > li').each(function(){
			if($(this).children('ul').length == 0){
				$(this).children('a').css('background-image','url("")');
			}else if($(this).hasClass('over')){
				$(this).children('ul').show();
			}
		});

		/*2차메뉴 이미지 처리*/
		$('.depth2 > li').each(function(){
			if($(this).children('ul').length == 0){
				$(this).children('a').css('background-image','url("")');
			}else if($(this).hasClass('over')){
				$(this).children('ul').show();
			}
		});


//메인화면 공지사항 슬라이드
	$('.notice-slide').slick({
		dots: true,
		//dotsClass: '.mvisual-dot',
		speed: 1000,
		arrows: true,
		autoplay: true,
		draggable: false,
		autoplaySpeed: 3000,
		vertical: true,
		easing: 'easeInOutQuint',
		pauseOnHover: false,
		touchMove: true,
		pauseOnDotsHover: false,
		prevArrow: $('.notice-ctrl').find('.prev'),
		nextArrow: $('.notice-ctrl').find('.next'),
		verticalSwiping: true,
	});






});




