<%--
 * PROJECT： DICAS
 *
 * [KR]
 *
 * $Id$
 *
 * Copyright (c) 2018 DENSO CORPORATION. All rights reserved.
 *
--%>

<!-- [EN] Contents area -->
<!-- [JP] コンテンツエリア -->
<%-- [EN] Contents area --%>
<%-- [JP] コンテンツエリア --%>

<%-- .cont-wrap --%>
<div class="cont-wrap">
  <%-- .sub-tab --%>
  <div class="sub-tab">
    <div id="myTab04" class="tab-slide"></div>
  </div>
  <%--// .sub-tab --%>


  <div class="sub-con-wrap">
    <h2 class="subpage-tit">공지사항</h2>
  </div>

</div>

<script type="text/javascript">
  var pageCnt = 0;
  $(document).ready(function () {
    $("div#myTab04").bindTab({
      theme: 'AXTabsLarge',
      value: "1",
      overflow: "scroll",
      scollAmount: 5,
      options: [],
      onchange: function (selectedObject, value) {
        var obj = this;
        var title = selectedObject.optionText;
        var menuId = getUrlParam(value, "menu");
        if (!document.getElementById("tabDiv" + obj.index)) {
          var contentsLayout = "<div id='tabDiv" + obj.index
              + "'  class='tabDiv' style='position: relative;'>"
              + "<iframe scrolling='yes'   id='iframe_" + obj.index + "' data-menu-id='" + menuId + "' style='min-height:100%; min-width:1752px;'></iframe></div>";
          $(".sub-con-wrap").append($(contentsLayout));
          $("#tabDiv" + obj.index + " iframe").attr("src", value + "&tabId=tabDiv" + obj.index + "&pageTitle=" + encodeURIComponent(title));
        }
        $(".tabDiv").css("display", "none");
        $("#tabDiv" + obj.index).css("display", "block");
        pageCnt = $(".tabDiv").length;
      },
      onclose: function (selectedObject, value) {
        //닫은 탭 콘텐츠 삭제하기
        var i;
        $('#tabDiv' + this.index).remove();
        var index_d = this.index * 1;
        for (i = 0; i < pageCnt - 1; i++) {
          $('#tabDiv' + ((index_d + 1) + i)).attr("id", 'tabDiv' + (index_d + i));
        }
        if (pageCnt <= 2) {
          $("#tabDiv0").css("display", "block");
        } else {
          if (this.index == 0) {
            $("#tabDiv1").css("display", "block");
          }
        }
      }
    });
    
    
    $("div#myTab04").trigger("onchange");
  		
  });

  function resizeTopIframe(menuId, height) {
    var elIframe = $("iframe[data-menu-id=" + menuId + "]");
    elIframe.css('height', (height+ 5) + 'px');
  }

</script>

<c:if test="${menuKey != null}">
<script type="text/javascript">
  $(document).ready(function() {
    var menuAnchor = $("div#mainNav a[data-menu-id=<c:out value="${menuKey}"/>]");
    loadTab(menuAnchor[0]);
  });
</script>
</c:if>
<%--// .cont-wrap --%>
<div class="sub-con-bg"></div>



