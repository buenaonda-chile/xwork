/* 메뉴 */
function initTnb(){
  $("#tnb1_menu").on("click",function(e){
    e.preventDefault();
    $("html").css("overflowY","hidden");
    $("#tnb1").fadeIn();      
  });

  $("#tnb1 > .bg").on("click",function(e){
    e.preventDefault();
    $("html").css("overflowY","scroll");
    $("#tnb1").fadeOut();      
  });     
}

/* 기본 정의 jquery */
function initFnc(){
	// 레이어 열기
	$("a.b1.layer_open").on("click",function(e){
		e.preventDefault();
		var $that = $($(this).attr('href')); 
		$that.show();		
    });  
    
	// 레이어 닫기
	$("a.b1.layer_close").on("click",function(e){
		e.preventDefault();
		var $that = $($(this).attr('href')); 
		$that.hide();		
	});    

	// 본문 탭
	$("a.b1.tab").on("click",function(e){
		e.preventDefault();
		var $that = $($(this).attr('href')); 
		$(".tab_cont").removeClass("on");
		$(".cnb2 ul li").removeClass("on");
		$that.addClass("on");			
		$(this).parent().addClass("on");
	});  
		
}



/* 달력보기 */
$.datepicker.setDefaults({
  prevText: '이전 달',
  nextText: '다음 달',
  monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'], 
  monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
  dayNames: ['일', '월', '화', '수', '목', '금', '토'],
  dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
  dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
  showMonthAfterYear: true,
  /*changeMonth: true,*/
  /*changeYear : true,  */
  dateFormat: "yy-mm-dd",  
  yearSuffix: '년'
});  