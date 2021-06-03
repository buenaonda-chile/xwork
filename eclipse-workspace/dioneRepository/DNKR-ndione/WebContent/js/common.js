/**
 * ax5 의 라이브러리를 이용해 기존의 alert 기능을 재정의하고 라이브러리의 API 사용방법을 단순화 시킨다.
 * @param w (window object)
 */
(function(w){
	var bridge = closeStyle;
	w.alert = function(msg){
		var toast = new ax5.ui.toast();
        toast.setConfig({
            icon: '<i class="fa fa-bell"></i>',
            containerPosition: "top-left",
            closeIcon: '<i class="fa fa-times"></i>'
        });
        
		toast.confirm(msg.toString());
	}
	
	w.danger = function(msg){
		var toast = new ax5.ui.toast();
        toast.setConfig({
            icon: '<i class="fa fa-bell"></i>',            
            theme: 'danger',
            containerPosition: "top-left",
            closeIcon: '<i class="fa fa-times"></i>'
        });
        
		toast.confirm(msg.toString());
	}
	//console.log(123);
	w.toastMsg = function(msg){
		var toastMsg = new ax5.ui.toast();
		toastMsg.setConfig({
            icon: '<i class="fa fa-bell"></i>', 
            containerPosition: "top-left",
            closeIcon: '<i class="fa fa-times"></i>'
        });        
		toastMsg.push(msg.toString());
	}
	
	w.mask = new ax5.ui.mask();
	w.mask.setConfig({
		target: document.body, 
	    content: '<h1><i class="fa fa-spinner fa-spin"></i> Loading</h1>',
	    onStateChanged: function(){
	    	
	    }
    });
	
	w.navClose = function() {
		$(".depth-wrap").hide().stop().animate({'width':'0'},0);	
		$('.depth-wrap').css('box-shadow','0px 0px 0px #fff')
		$(".bookmark-page").hide().stop().animate({'right':'-324px'},300);	
		$('.bookmark-page').css('box-shadow','0px 0px 0px #fff')
		$(".hd-icon .bookmark").removeClass('over');
		bridge();
		initMiFlatform();
		
		$('#mainNav-wrap').css('height', $(window).height());
		/* 북마크 */
		$('.bookmark-page').css('height', $(window).height());
		/* 북마크 */
		$('.ico-menu').css('height', $(window).height() - 45);
	}
	
	w.initMiFlatform = function() {
		var iframes = window.frames;
		 
		if(iframes.length > 0) {
			for(var i = 0; i < iframes.length; i++) {
				var miFlatforms = iframes[i].document.getElementsByClassName("MI");
				if(miFlatforms.length > 0) {
					for(var j = 0; j < miFlatforms.length; j++) { 
						if($('.depth-wrap').width() > 0) {
							var miFlat_width = Number((miFlatforms[j].style.left).replace("px", ""));
							miFlatforms[j].style.marginLeft = (miFlat_width - 70) + "px";
						} else {
							//miFlatforms[j].style.position = "";
							miFlatforms[j].style.marginLeft = "";
						}
						
					}
				}
			}
		}
		
		miFlatform = slideMiFlatform;
	}
	
	w.slideMiFlatform = function (mode) {
		var iframes = window.frames;
		 
		if(iframes.length > 0) {
			for(var i = 0; i < iframes.length; i++) {
				var miFlatforms = iframes[i].document.getElementsByClassName("MI");
				if(miFlatforms.length > 0) {
					for(var j = 0; j < miFlatforms.length; j++) {
						//miFlatforms[j].style.position = "absolute";
						
						//'#mainNav-wrap .menu-bnt' 을 클릭했을 때
						if(mode === undefined) {
							if($('.depth-wrap').width() === 0) {	//메뉴가 닫혀있을 때
								miFlatforms[j].style.marginLeft = "55px";
								
							} else {	//메뉴가 열려있을 때
								miFlatforms[j].style.marginLeft = "400px";
							}
							miFlatform = initMiFlatform;
							
						//메뉴가 열릴 때	
						} else if (mode !== undefined && $('.depth-wrap').width() > 0) {
						
							if($("#mainNav-wrap").width() === 170) {//openStyle일 때
								miFlatforms[j].style.marginLeft = (Number(mode) + 70) + "px";
							} else {//closeStyle일 때
								miFlatforms[j].style.marginLeft = mode + "px";
							}
						} else {
							if($("#mainNav-wrap").width() === 170) {//openStyle일 때
								miFlatforms[j].style.marginLeft = (Number(mode) + 70) + "px";
							} else {//closeStyle일 때
								miFlatforms[j].style.marginLeft = mode + "px";
							}
						} 
					}
				}
			}
		}
	}
	

	w.leftNavResize = function() {
		//console.log("leftNavResize()");
		var doc_wrap_div = document.getElementById("super-doc-wrap");
		var mainNavdiv = document.getElementById("mainNav-wrap");
		
		if( doc_wrap_div !== undefined && doc_wrap_div !== null
				&& mainNavdiv !== undefined && mainNavdiv !== null ) {
			var div_offsetHeight = doc_wrap_div.offsetHeight;
			var nav_offsetHeight = mainNavdiv.offsetHeight;
			var dif_height = div_offsetHeight - nav_offsetHeight;
			
			var currPaddingBottom = $(mainNavdiv).css('padding-bottom');
			var numCurrPaddingBottom = parseInt(currPaddingBottom.substring(0, currPaddingBottom.length - 2));
			var changePaddingBottom = numCurrPaddingBottom + dif_height;
			
			if(dif_height > 0) {
				//console.log("if(dif_height > 0) {");
				//$('#mainNav-wrap').css('paddingBottom', changePaddingBottom);
				//$('#mainNav-wrap').css('paddingBottom', numCurrPaddingBottom + dif_height + "px");
			} 
		} else {
			//console.log('새창입니다.');
		}
	}

	
})(window);


var dropFunction = function() {
    document.getElementById("dropdown").classList.toggle("show");
}

function loadTab(obj, pType){
	pageInit();
	
	//toastMsg($(obj).attr("href"));
	
	var href = $(obj).attr("href");
	var id = '';
	var isOpened = false;
	var menuCd = getUrlParam(href, 'menu');
	var tabNum = '';
	
	$('iframe').each(function(){
		var src = $(this).attr('src');
		var iMenuCd = getUrlParam(src, 'menu');
		
		if (menuCd == iMenuCd){
			var tabId = getUrlParam(src, 'tabId')
			tabNum = tabId.substring(6,8);
			isOpened = true;
		}
	});
	
//	if(isOpened && menuCd !== "686"){
	if(isOpened){
		var target = $('#myTab04_AX_Tabs_AX_' + tabNum);
		
		target.trigger('click');
		setLangeMenuCd(href);
	} else {
//		if(isOpened && menuCd == "686"){
//			var target = $('#myTab04_AX_Tabs_AX_' + tabNum + ' span');
//			target.trigger('click');
//		}
		var options = [];
		var hrefVal = "";
		if(pType === undefined) {
			hrefVal = $(obj).attr("href");
		} else {
			hrefVal = $(obj).attr("href") + "&pType=" + pType;
		}
		options.push({
			optionText: $(obj).attr("data-name"), 
			optionValue: hrefVal, 
			closable:true
		});
		
		$("#myTab04").addTabs(options);
		$("#myTab04").setValueTab(options[0].optionValue);
		
		//상단 Languge menuCd 세팅
		setLangeMenuCd(options[0].optionValue);
	}
	
	closeStyle();
	
	
	
	return false;
}

/*네비 펼치기 */
var oldStyle = {
	display:"",
	top:"",
	left:"",
	background:"",
	width:"",
	padding:""
};

function openStyle(){
	$('#mainNav-wrap').stop().animate({'width':'170'},300,function(){
		oldStyle.display = $('#mainNav li a .mNname').css("display");
		oldStyle.top = $('#mainNav li a .mNname').css("top");
		oldStyle.left = $('#mainNav li a .mNname').css("left");
		oldStyle.background = $('#mainNav li a .mNname').css("background");
		oldStyle.width = $('#mainNav li a .mNname').css("width");
		oldStyle.width = $('#mainNav-wrap .mNav-ctrl a').css("padding");
		$('#mainNav li > a').css("position","relative");
		$('#mainNav li a .mNname')
			.css('display','inline-block')
			.css('top','12px')
			.css('left','50px')
			.css('background','none')
			.css('width','auto');
		$('#mainNav-wrap .mNav-ctrl a').css('padding','0 20px');
		bridge = closeStyle;
		$("#mainNav").addClass("opened");
	});
	$('.depth-wrap').css('left','170px');
	$('#mainNav > ul > li').css('text-align','left');
	$('#mainNav > ul > li > a > span ').css('padding-left','20px');
	$('#mainNav li a .mNname .tri').css('display','none');
	//$(this).parent('li.lm_l1').siblings('li.lm_l1').find('.depth-wrap').hide().stop().animate({'left':'350'},300)
}

function closeStyle(){	
	$('#mainNav li a .mNname').css('display','none');
	$('#mainNav-wrap').stop().animate({'width':'100'},400,function(){
//		console.log(oldStyle);
		$('#mainNav li a .mNname').attr("style","");
		bridge = openStyle;
		$("#mainNav").removeClass("opened");
	});
	$('.depth-wrap').css('left','100px');
	$('#mainNav > ul > li').css('text-align','center');
	$('#mainNav > ul > li > a > span ').css('padding-left','0px');
	$('#mainNav li a .mNname .tri').css('display','inline-block');
	$('#mainNav-wrap .mNav-ctrl a').attr("style","");
		
}


/**
 * [KO] 숫자만 입력받기
 * @param event
 * @returns {Boolean}
 */
function onlyNum(event) {
	var keyCode;
	event = event || window.event;
	if(event.which !== undefined) {
		keyCode = event.which;
	} else {
		keyCode = event.keyCode;
	}
	
	if( ( Number(keyCode) >= 48 && Number(keyCode) <= 57 ) || ( Number(keyCode) >=96 && Number(keyCode) <= 105 ) ){
		return;
	} else {
		return false;
	}
}

function pageInit() {
	navClose();
	
	leftNavResize();
}

HashMap = function(){   
    this.map = new Array(); 
};   
HashMap.prototype = {   
    put : function(key, value){   
        this.map[key] = value; 
    },   
    get : function(key){   
        return this.map[key]; 
    },   
    getAll : function(){   
        return this.map; 
    },   
    clear : function(){   
        this.map = new Array(); 
    },   
    isEmpty : function(){     
         return (this.map.size() == 0); 
    }, 
    remove : function(key){     
         delete this.map[key]; 
    }, 
    toString : function(){ 
        var temp = ''; 
        for(i in this.map){   
            temp = temp + ',' + i + ':' +  this.map[i]; 
        } 
        temp = temp.replace(',',''); 
          return temp; 
    }, 
    keySet : function(){   
        var keys = new Array();   
        for(i in this.map){   
            keys.push(i); 
        }   
        return keys; 
    } 
}; 

//HashMap 사용예제
/*
 function Hashtest(){ 
    try{ 
        var map = new HashMap(); 
        map.put("key", "value"); 
        map.put("key2", "value2"); 
        map.remove("key"); 
        var allTemp = map.getAll(); 
        for(i in allTemp){  
        	//console.log(i);}   
        	console.log(map.toString());     
    }catch(e){
    	console.log(e);
    } 
} 
*/
    
//상단 Language menuCd 세팅
function setLangeMenuCd(url){
	var menuCd = getUrlParam(url, 'menu');
    if(menuCd){
    	$('#langKr').attr('href', 'init.do?locale=kr&menu=' + menuCd);
    	$('#langEn').attr('href', 'init.do?locale=en&menu=' + menuCd);
    	$('#langJa').attr('href', 'init.do?locale=ja&menu=' + menuCd);
    	
    }
}


//url 에서 parameter 값 받아오기
function getUrlParam(url, param){
	var rtnStr = '';
    var urlArray = url.split('?');
    for(var i=0; i<urlArray.length;i++){
    	var _tempArray = urlArray[i+1].split('&');// '&'을 기준으로 분리하기
        for(var j = 0; j < _tempArray.length; j++) {
        	var tmp = _tempArray[j];
        	if(tmp){
        		var _keyValuePair = tmp.split('='); // '=' 을 기준으로 분리하기
    	    	//var _keyValuePair = _tempArray[i].split('='); // '=' 을 기준으로 분리하기
    	    	if(_keyValuePair[0] == param){ // _keyValuePair[0] : 파라미터 명 
    		    	// _keyValuePair[1] : 파라미터 값 
    	    		rtnStr = _keyValuePair[1];
    	    		return rtnStr;
    		    }
        	}
    	}
    }
    
    return rtnStr;
}

/**
 * [KO] 게시판으로 이동
 * 
 * @param el 클릭타겟
 */
function goBoardPage(el, boardId) {
	if(boardId === "BID0001") {
		location.href="WAA000Sub/init.do?menu=6";
	} else if(boardId === "BID0003") {
		location.href="WAA000Sub/init.do?menu=441";
	}
}