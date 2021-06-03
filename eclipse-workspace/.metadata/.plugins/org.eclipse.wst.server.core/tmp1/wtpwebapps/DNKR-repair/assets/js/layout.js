/*네비 펼치기 */
var oldStyle = {
  display: "",
  top: "",
  left: "",
  background: "",
  width: "",
  padding: ""
};

var bridge = openStyle;

function openStyle() {
  $('#mainNav-wrap').stop().animate({'width': '170'}, 300, function () {
    oldStyle.display = $('#mainNav li a .mNname').css("display");
    oldStyle.top = $('#mainNav li a .mNname').css("top");
    oldStyle.left = $('#mainNav li a .mNname').css("left");
    oldStyle.background = $('#mainNav li a .mNname').css("background");
    oldStyle.width = $('#mainNav li a .mNname').css("width");
    oldStyle.width = $('#mainNav-wrap .mNav-ctrl a').css("padding");
    $('#mainNav li > a').css("position", "relative");
    $('#mainNav li a .mNname')
    .css('display', 'inline-block')
    .css('top', '12px')
    .css('left', '50px')
    .css('background', 'none')
    .css('width', 'auto');
    $('#mainNav-wrap .mNav-ctrl a').css('padding', '0 20px');
    bridge = closeStyle;
    $("#mainNav").addClass("opened");
  });
  $('.depth-wrap').css('left', '170px');
  $('#mainNav > ul > li').css('text-align', 'left');
  $('#mainNav > ul > li > a > span ').css('padding-left', '20px');
  $('#mainNav li a .mNname .tri').css('display', 'none');
  //$(this).parent('li.lm_l1').siblings('li.lm_l1').find('.depth-wrap').hide().stop().animate({'left':'350'},300)
}

function closeStyle() {
  $('#mainNav li a .mNname').css('display', 'none');
  $('#mainNav-wrap').stop().animate({'width': '100'}, 400, function () {
    $('#mainNav li a .mNname').attr("style", "");
    bridge = openStyle;
    $("#mainNav").removeClass("opened");
  });
  $('.depth-wrap').css('left', '100px');
  $('#mainNav > ul > li').css('text-align', 'center');
  $('#mainNav > ul > li > a > span ').css('padding-left', '0px');
  $('#mainNav li a .mNname .tri').css('display', 'inline-block');
  $('#mainNav-wrap .mNav-ctrl a').attr("style", "");

}



/*즐겨찾기 팝업*/
// $('#header-wrap').find('.hd-icon .bookmark a').click(function () {
//   $(".bookmark-page").stop().animate({'right': '0px'}, 300);
//   $('.bookmark-page').css('box-shadow', '-5px 0px 10px rgba(0, 0, 0, 0.1)')
//   $(".hd-icon .bookmark").addClass('over');
//   $(".bookmark-page").stop().animate({'right': '0'}, 300)
// }).focus(function () {
//   $(".bookmark-page").stop().animate({'right': '0px'}, 300);
//   $('.bookmark-page').css('box-shadow', '-5px 0px 10px rgba(0, 0, 0, 0.1)')
//   $(".hd-icon .bookmark").addClass('over');
//   $(".bookmark-page").stop().animate({'right': '0'}, 300)
// });
//
// $(".bookmark-page .bmark-top .close").click(function () {
//   navClose();
//   /*$(".bookmark-page").animate({'right':'-324px'},300);
//   $('.bookmark-page').css('box-shadow','0px 0px 0px #fff')
//   $(".hd-icon .bookmark").removeClass('over');*/
// });

(function ($) {
  //즐겨찾기 스크롤바
  // $(window).load(function () {
  //   $(".tabDiv").mCustomScrollbar();
  // });
  $(document).ready(function() {
    pageInit();

    /*아코디언 메뉴*/
    $(function ($) {
      $('.depth2 > li').find('a').click(function () {
        $(this).parent().siblings('li').find('a').removeClass('on');
        $(this).parent('ul').removeClass('on');

        $(this).parent('li').find('.depth3').addClass('on');
        $(this).parent('li').find('.depth3').slideDown('fast');
        $(this).parent('li').siblings('li').find('.depth3').slideUp('fast');
        $(this).parent('ul').removeClass('on');
      }).focus(function () {
        $(this).parent().siblings('li').find('a').removeClass('on');
        $(this).parent('ul').removeClass('on');
        $(this).addClass('on');
        $(this).parent('li').find('.depth3').slideDown('fast');
        $(this).parent('li').siblings('li').find('.depth3').slideUp('fast');
      });
      $(function () {
        $('.dropdown-toggle').dropdown();
      })
    });


    $('#mainNav-wrap').find('.menu-bnt').click(function () {
      bridge();
    }).focus(function () {
      bridge();
    });

//메뉴슬라이드
    $(function () {
      $('.mNav-ctrl a').css({cursor: 'pointer'}).click(function () {
        var ih = $(this).index() == 0 ? -65 : 65; //위아래로 움직이는 px 숫자
        var obj = $('#mainNav > ul');
        obj.animate({scrollTop: obj.scrollTop() + ih}, 100);
      });
    });

    /*세부 메뉴*/
    $('#mainNav').find('li.lm_l1 > a.lm_a1').click(function () {
      $(this).parent('li.lm_l1').find('.depth-wrap').show().stop().animate(
          {'width': '350'}, 90, function () {
            $('.depth-wrap').css('box-shadow',
                '10px 0px 10px rgba(0, 0, 0, 0.3)')
          });
      $(this).parent('li.lm_l1').removeClass('over').addClass('over');
      /*$(this).parent('li.lm_l1').addClass('over');*/
      $(this).parent('li.lm_l1').siblings('li.lm_l1').find(
          '.depth-wrap').hide().stop().animate({'width': '350'}, 90)
      $(this).parent('li.lm_l1').siblings('li.lm_l1').removeClass('over');

    }).focus(function () {
      $(this).parent('li.lm_l1').find('.depth-wrap').stop().animate(
          {'width': '350'}, 90, function () {
            $('.depth-wrap').css('box-shadow',
                '10px 0px 10px rgba(0, 0, 0, 0.3)')
          });
      $(this).parent('li.lm_l1').removeClass('over').addClass('over');
      $(this).parent('li.lm_l1').siblings('li.lm_l1').find(
          '.depth-wrap').stop().animate({'width': '350'}, 90)
      $(this).parent('li.lm_l1').siblings('li.lm_l1').removeClass('over');
      $('.depth-wrap').css('box-shadow', '10px 0px 10px rgba(0, 0, 0, 0.3)')
    });

    $(".Mmenu-close-btn").click(function () {
      navClose();
    });

    $(".lm_a1").on("mouseover", function () {
      if ($("#mainNav").hasClass("opened")) {
        $(this).find(".mNname").css("color", "#d7363c");
      } else {
        var obj = $(this).parent().offset();
        var baseTop = obj.top;
//				$('#mainNav li a').css("position","static");
        $('#mainNav li > a').css("position", "static");
        $(this).find(".mNname").css("top", baseTop + 15);
        $(this).find(".mNname").css("z-index", 9999);
      }
    }).on("mouseout", function () {
      if ($("#mainNav").hasClass("opened")) {
        $(this).find(".mNname").css("color", "");
      }
    }).on("mouseover", function () {
      if (!$("#mainNav").hasClass("opened")) {
        $(this).find(".mNname").css("color", "#fff");
      }
    });
  });
})(jQuery);