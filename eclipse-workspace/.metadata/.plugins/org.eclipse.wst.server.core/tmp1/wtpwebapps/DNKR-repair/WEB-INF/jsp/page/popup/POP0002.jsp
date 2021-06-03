<%-- [EN] Variable definition --%>
<%-- [JP] ???? --%>
<c:url var="codeUrl" value="/code/list2.json"/>

<c:url var="initUrl" value="/CustomerPopUp/init"/>

<c:url var="readUrl" value="/CustomerPopUp/search"/>

<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] ??ID (@ViewId???) --%>
<c:set var="screenId" value="<%= request.getAttribute(Globals.SCREEN_ID_KEY) %>"/>


<!-- wijmo css -->
<link rel="stylesheet" href="/wijmo/styles/custom.css"/>
<link rel="stylesheet" href="/wijmo/styles/wijmo.css"/>

<!-- wijmo js -->
<script type="text/javascript" src="/wijmo/controls/wijmo.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.grid.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.input.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.xlsx.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.grid.xlsx.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.grid.filter.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/cultures/wijmo.culture.ko.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/jszip.min.js"></script>
<script type="text/javascript" src="/js/wijmo/commonWijmo.js"></script>
<!--  -->


<div class="sub-con-wrap">
  <h2 class="subpage-tit">업체 검색</h2>
  <!-- 버튼들 -->
  <div class="sub-btn-group">
    <button id="btn_search" type="button" class="button" ><i class="w_search"></i>검색</button>
  </div>
  <!-- /버튼들 -->
</div>

<%-- .search1 --%>
<div class="search1">
  <form id="frm_search" method="get" >
    <fieldset>
      <table style="width:800px;">
        <colgroup>
          <col style="width:80px"/>
          <col style="width:80px"/>
          <col style="width:80px"/>
          <col style="width:80px"/>
          <col style="width:80px"/>
          <col/>
        </colgroup>
        <tr>
          <th style="width:10px;">업체명</th>
          <td>
          	<input type="text" style="width:100px; height:35px;" name="custNm" id="custNm">
          </td>
          <th style="width:10px;">업체코드</th>
          <td>
          	<input type="text" style="width:100px; height:35px;" name="custCd" id="custCd">
          </td>
          <th>업체구분</th>
          <td>
          	<div id="custDiv"></div>
          </td>
        </tr>
      </table>
    </fieldset>
  </form>
</div>

<div class="grid-container" style="position: relative; height: 650px;">
	<div id="wijmoGrid" ></div>
	<a href="javascript:zoomIn($('#wijmoGrid'),flexGrid);">확대</a>
	<a href="javascript:zoomOut($('#wijmoGrid'),flexGrid);">축소</a>
</div>
 
<script type="text/javascript">

    var _dicasPage = new DicasPage('${screenId}');
    
    //getScript로 호출을 해야지 js파일이 브라우저 캐시에 남지않고 새로고침시 바로바로 적용됩니다.    
    $.getScript('/js/popup/pop0002.js');
    
    
</script>
