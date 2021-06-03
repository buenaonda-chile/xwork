var _isEmbeded = false;

if (typeof parent.resizeTopIframe !== "undefined") {

  _isEmbeded = true;
  /**
   * ax5 의 라이브러리를 이용해 기존의 alert 기능을 재정의하고
   * 라이브러리의 API 사용방법을 단순화 시킨다. (parent 함수 사용)
   * @param w (window object)
   */
  (function (w) {
    w.alert2 = parent.alert2;
    w.danger = parent.danger;
    w.toastMsg = parent.toastMsg;
    w.mask = parent.mask;
    w.alertmask = parent.alertmask;
  })(window);

  $(window).bind('load', function () {
    // var height = document.getElementsByTagName('body')[0].scrollHeight;
    var height = $('div.doc-wrap')[0].offsetHeight;
    var menuid = getUrlParam(this.location.href, "menu");
    parent.resizeTopIframe(menuid, height);
  });

  $(window).bind('resize', function () {
    // var height = document.getElementsByTagName('body')[0].scrollHeight;
    var height = $('div.doc-wrap')[0].offsetHeight;
    var menuid = getUrlParam(this.location.href, "menu");
    parent.resizeTopIframe(menuid, height);
  });

  $(document).ready(function () {
    var height = document.getElementsByTagName('body')[0].scrollHeight;
    var title = decodeURIComponent(_dicasPage.getParameterByName('pageTitle'));
    $("div.sub-con-wrap > h2.subpage-tit").text(title);
  });

  function getUrlParam(url, param) {
    return parent.getUrlParam(url, param);
  }
}

/**
 * DICAS 페이지 클래스
 */
function DicasPage(screenId) {
  this.screenId = screenId;

  this.getParameterByName = function (name) {
    var url = window.location.href;
    name = name.replace(/[\[\]]/g, "\\$&");
    var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
        results = regex.exec(url);
    return results[2];
  };

  this.requestParams = null;
  try {
    this.menuCd = this.getParameterByName("menu");
    if (sessionStorage.getItem(this.menuCd) != null) {
      this.requestParams = JSON.parse(sessionStorage.getItem(this.menuCd));
      sessionStorage.removeItem(this.menuCd);
    }
  } catch(e) {
  }

  this.pageMask = new ax5.ui.mask({
    target: document.body,
    content: '<h3><i class="fa fa-spinner fa-spin"></i> <span>Loading</span></h3>',
    onStateChanged: function () {
    }
  });
  this.getEditOptions = function (data) {
    var editoptions = [];
    for (var i = 0; i < data.length; i++) {
      var item = {
        text: data[i].get('codeNm'),
        value: data[i].get('codeCd')
      }
      editoptions.push(item);
    }
    return editoptions;
  };
  this.maskOpen = function () {
    if (_isEmbeded)
      mask.open();
    else
      this.pageMask.open();
  };
  this.maskClose = function () {
    if (_isEmbeded)
      mask.close();
    else
      this.pageMask.close();
  };

  this.maskClose();

  this.isEmptyObject = function (obj) {
    for (var prop in obj) {
      if (Object.prototype.hasOwnProperty.call(obj, prop)) {
        return false;
      }
    }
    return true;
  };
  this.codeHelpVal = null;
  this.beforeCodeHelpVal = null;
  this.popupOpen = function (options) {
    var that = this;

    var defaultOption = {
      url: null,
      code: null,
      width: 500,
      height: 800,
      beforeOpen: undefined,
      afterClose: undefined,
      params: {}
    };

    options = $.extend(defaultOption, options);

    if (typeof options.beforeOpen !== "undefined") {
      var chkVal = null;
      var repeat = setInterval(function () {
        if (that.beforeCodeHelpVal != null) {
          clearInterval(repeat);
          if (!that.beforeCodeHelpVal) {
            that.beforeCodeHelpVal = null;
            return;
          }
          that.beforeCodeHelpVal = null;
          that._openCodeHelp(options);
          return;
        }
      }, 100);
      options.beforeOpen();
    } else
      that._openCodeHelp(options);
  };

  this._openCodeHelp = function (options) {
    var winOpt = "location=0,directories=0,resizable=1,status=0,toolbar=0,menubar=0,scrollbars=1,"
        + "width=" + options.width + ", height=" + options.height
        + ",left=" + ((screen.availWidth - options.width) / 2)
        + ",top=" + ((screen.availHeight - options.height) / 2);

    var that = this;

    function popupClose() {
      if (typeof options.afterClose !== 'undefined') {
        setTimeout(function () {
          options.afterClose({
            code: options.code,
            result: that.codeHelpVal != null ? true : false,
            data: that.codeHelpVal,
          });
        }, 200);
      }

      return null;
    };

    var popupUrl = options.url;
    if (!this.isEmptyObject(options.params)) {
      popupUrl += "?";
      var params = "";
      for (var prop in options.params) {
        params += prop + "=" + options.params[prop] + "&";
      }
      params = params.substring(0, params.length - 1);

      popupUrl += params;
    }

    var popupWindow = window.open(popupUrl, options.popupTitle, winOpt);
    if (popupWindow.addEventListener !== undefined) {
      popupWindow.addEventListener('beforeunload', function () {
        popupClose();
      });
    } else {
      var _close = setInterval(function() {
        try {
          if (popupWindow._dicasPage == undefined ) {
          }
        } catch(e) {
          clearInterval(_close);
          popupClose();
        }
      }, 100);
    }
  }

  this.alert = function(options) {
    var defaultOptions = {
      title: '알림',
      width: '300px',
      height: '150px',
      message: null,
      confirm: null,
      cancel: null,
      _confirm: function(e) {
        $("#alertPopupLayer").remove();
        if (this.confirm != null) {
          var that = this;
          setTimeout(function() {
            that.confirm();
          }, 100);
        }
      },
      _cancel: function(e) {
        e.preventDefault();
        $("#alertPopupLayer").remove();
        if (this.cancel != null) {
          var that = this;
          setTimeout(function() {
            that.cancel();
          }, 100);
        }
      },
    }
    options = $.extend(defaultOptions, options);

    var template = kendo.template($("#alertTemplate").html());
    var result = template(options); //Execute the template
    $("body").append(result); //Append the result
    kendo.bind($("#alertPopupLayer"), options);
  }

  this.confirm = function(options) {
    var defaultOptions = {
      title: '알림',
      width: '300px',
      height: '150px',
      message: null,
      confirm: null,
      cancel: null,
      _confirm: function(e) {
        $("#confirmPopupLayer").fadeOut().remove();
        if (this.confirm != null) {
         var that = this;
         setTimeout(function() {
           that.confirm();
         }, 100);
        }
      },
      _cancel: function(e) {
        e.preventDefault();
        $("#confirmPopupLayer").fadeOut().remove();
        if (this.cancel != null) {
          var that = this;
          setTimeout(function() {
            that.cancel();
          }, 100);
        }
      },
    }
    options = $.extend(defaultOptions, options);

    var template = kendo.template($("#confirmTemplate").html());
    var result = template(options); //Execute the template
    $("body").append(result); //Append the result
    kendo.bind($("#confirmPopupLayer"), options);
  }
};


