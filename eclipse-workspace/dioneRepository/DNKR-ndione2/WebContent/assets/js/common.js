/**
 * ax5 의 라이브러리를 이용해 기존의 alert 기능을 재정의하고 라이브러리의 API 사용방법을 단순화 시킨다.
 * @param w (window object)
 */
(function (w) {
  w.alert2 = function (msg) {
    var toast = new ax5.ui.toast();
    toast.setConfig({
      icon: '<i class="fa fa-bell"></i>',
      containerPosition: "top-right",
      closeIcon: '<i class="fa fa-times"></i>',
      onStateChanged: function () {
        if (this.state == "open") {
          alertmask.open();
        } else {
          alertmask.close();
        }
      }
    });

    toast.confirm(msg);
  }

  w.danger = function (msg) {
    var toast = new ax5.ui.toast();
    toast.setConfig({
      icon: '<i class="fa fa-bug"></i>',
      theme: 'danger',
      containerPosition: "top-right",
      closeIcon: '<i class="fa fa-times"></i>'
    });

    toast.confirm(msg);
  }

  w.toastMsg = function (msg) {
    var toastMsg = new ax5.ui.toast();
    toastMsg.setConfig({
      icon: '<i class="fa fa-bell"></i>',
      containerPosition: "top-right",
      closeIcon: '<i class="fa fa-times"></i>'
    });
    toastMsg.push(msg);
  }

  w.mask = new ax5.ui.mask();
  w.mask.setConfig({
    target: document.body,
    content: '<h1><i class="fa fa-spinner fa-spin"></i>  <span>Loading</span></h1>',
    onStateChanged: function () {
    }
  });

  w.alertmask = new ax5.ui.mask();
  w.alertmask.setConfig({
    target: document.body,
    content: '',
    onStateChanged: function () {
    }
  });

  w.navClose = function () {
    $(".depth-wrap").animate({'width': '0'}, 0);
    $('.depth-wrap').css('box-shadow', '0px 0px 0px #fff');
  }

  w.leftNavResize = function () {
    //console.log("leftNavResize()");
    var doc_wrap_div = document.getElementById("docBaseWrap")
    var mainNavdiv = document.getElementById("mainNav-wrap");

    if (doc_wrap_div !== undefined && mainNavdiv !== undefined) {
      var div_offsetHeight = doc_wrap_div.offsetHeight;
      var nav_offsetHeight = mainNavdiv.offsetHeight;
      var dif_height = div_offsetHeight - nav_offsetHeight;

      var currPaddingBottom = $(mainNavdiv).css('padding-bottom');
      var numCurrPaddingBottom = parseInt(
          currPaddingBottom.substring(0, currPaddingBottom.length - 2));
      var changePaddingBottom = numCurrPaddingBottom + dif_height;

      if (dif_height > 0) {
        //console.log("if(dif_height > 0) {");
        $(mainNavdiv).css('paddingBottom', changePaddingBottom);
        $(mainNavdiv).css('paddingBottom', numCurrPaddingBottom + dif_height + "px");
      }
    } else {
      //console.log('새창입니다.');
    }
  }

})(window);

var dropFunction = function () {
  document.getElementById("dropdown").classList.toggle("show");
}

function loadTab(obj, params) {

  var menuCd = $(obj).attr("data-menu-id");

  if (params !== undefined) {
    sessionStorage.setItem(menuCd, JSON.stringify(params));
  }

  if ($("#myTab04").length == 0) {
    document.location.href = DICAS_URL + "/sub/" + menuCd;
    return false;
  }

  pageInit();

  var href = $(obj).attr("href");
  var id = '';
  var isOpened = false;
  // var menuCd = getUrlParam(href, 'menu');
  var tabNum = '';

  $('iframe').each(function () {
    var src = $(this).attr('src');
    var menuId = getUrlParam(src, 'menu');

    if (menuCd == menuId) {
      var tabId = getUrlParam(src, 'tabId')
      tabNum = tabId.substring(6);
      isOpened = true;
      return;
    }
  });

  if (isOpened) {
    var target = $('#myTab04_AX_Tabs_AX_' + tabNum);
     target.trigger('click');
    //setLangeMenuCd(href);
  } else {

    var options = [];
    var hrefVal = $(obj).attr('href') + "?menu=" + menuCd;

    // if (pType === undefined) {
    //   hrefVal = $(obj).attr("href");
    // } else {
    //   hrefVal = $(obj).attr("href") + "&pType=" + pType;
    // }

    options.push({
      optionText: $(obj).attr("data-name"),
      optionValue: hrefVal,
      closable: true
    });

    $("#myTab04").addTabs(options);
    $("#myTab04").setValueTab(options[0].optionValue);

    //상단 Languge menuCd 세팅
    //setLangeMenuCd(options[0].optionValue);
  }

  closeStyle();

  return false;
}

function closeStyle() {
  $('#mainNav li a .mNname').css('display', 'none');
  $('#mainNav-wrap').stop().animate({'width': '100'}, 400, function () {
//		console.log(oldStyle);
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

/**
 * [KO] 숫자만 입력받기
 * @param event
 * @returns {Boolean}
 */
function onlyNum(event) {
  var keyCode;
  event = event || window.event;
  if (event.which !== undefined) {
    keyCode = event.which;
  } else {
    keyCode = event.keyCode;
  }

  if ((Number(keyCode) >= 48 && Number(keyCode) <= 57) || (Number(keyCode) >= 96
      && Number(keyCode) <= 105)) {
    return;
  } else {
    return false;
  }
}

function pageInit() {
  navClose();
  leftNavResize();
}

HashMap = function () {
  this.map = new Array();
};
HashMap.prototype = {
  put: function (key, value) {
    this.map[key] = value;
  },
  get: function (key) {
    return this.map[key];
  },
  getAll: function () {
    return this.map;
  },
  clear: function () {
    this.map = new Array();
  },
  isEmpty: function () {
    return (this.map.size() == 0);
  },
  remove: function (key) {
    delete this.map[key];
  },
  toString: function () {
    var temp = '';
    for (i in this.map) {
      temp = temp + ',' + i + ':' + this.map[i];
    }
    temp = temp.replace(',', '');
    return temp;
  },
  keySet: function () {
    var keys = new Array();
    for (i in this.map) {
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
function setLangeMenuCd(url) {
  var menuCd = getUrlParam(url, 'menu');
  if (menuCd) {
    $('#langKr').attr('href', 'init.do?locale=kr&menu=' + menuCd);
    $('#langEn').attr('href', 'init.do?locale=en&menu=' + menuCd);
    $('#langJa').attr('href', 'init.do?locale=ja&menu=' + menuCd);
  }
}

//url 에서 parameter 값 받아오기
function getUrlParam(url, param) {
  var rtnStr = '';
  var urlArray = url.split('?');
  for (var i = 0; i < urlArray.length; i++) {
    var _tempArray = urlArray[i + 1].split('&');// '&'을 기준으로 분리하기
    for (var j = 0; j < _tempArray.length; j++) {
      var tmp = _tempArray[j];
      if (tmp) {
        var _keyValuePair = tmp.split('='); // '=' 을 기준으로 분리하기
        //var _keyValuePair = _tempArray[i].split('='); // '=' 을 기준으로 분리하기
        if (_keyValuePair[0] == param) { // _keyValuePair[0] : 파라미터 명
          // _keyValuePair[1] : 파라미터 값
          rtnStr = _keyValuePair[1];
          return rtnStr;
        }
      }
    }
  }

  return rtnStr;
}

