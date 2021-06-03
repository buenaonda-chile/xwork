<%-- [EN] Variable definition --%>
<%-- [JP] ???? --%>
<c:url var="codeUrl" value="/code/list2.json"/>

<c:url var="initUrl" value="/kpiManagementDNKR/init"/>

<c:url var="readUrl" value="/kpiManagementDNKR/search"/>

<c:url var="updateUrl" value="/kpiManagementDNKR/update"/>

<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] ??ID (@ViewId???) --%>
<c:set var="screenId" value="<%= request.getAttribute(Globals.SCREEN_ID_KEY) %>"/>


<!-- wijmo css -->
<link rel="stylesheet" href="/wijmo/styles/custom.css"/>
<link rel="stylesheet" href="/wijmo/styles/wijmo.css"/>

<!-- wijmo js -->
<script type="text/javascript" src="/wijmo/controls/wijmo.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.grid.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.grid.cellmaker.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.input.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.xlsx.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.grid.xlsx.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.grid.filter.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/cultures/wijmo.culture.ko.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/jszip.min.js"></script>
<script type="text/javascript" src="/js/wijmo/commonWijmo.js"></script>

<!-- chart 관련 -->
<script type="text/javascript" src="/wijmo/controls/wijmo.chart.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.pdf.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.nav.min.js"></script>
<script type="text/javascript" src="/wijmo/controls/wijmo.grid.pdf.min.js"></script>
<!--  -->

<style  type="text/css">
input {
	width:100px;
	height:35px;
}
</style>


<div class="sub-con-wrap">
  <h2 class="subpage-tit">KPI실적관리(월간보고)</h2>
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
      <table style="width:600px;">
        <tr>
          <th>일자</th>
          <td>
          	<input id="searchDtFr" onblur="clearChart();"> ~ <input id="searchDtTo" onblur="clearChart();">
          </td>
          <th>구분</th>
          <td>
          	<div id="div" style="width:100px; height:35px;"></div>
          </td>
        </tr>
      </table>
    </fieldset>
  </form>
</div>

<div class="chart-container" style="position: relative; height: 650px;">
	<div id="wijmoChart" ></div>
</div>
 
<script type="text/javascript">

    var _dicasPage = new DicasPage('${screenId}');
    
    //getScript로 호출을 해야지 js파일이 브라우저 캐시에 남지않고 새로고침시 바로바로 적용됩니다.    
    $.getScript('/js/dnkr/dnkr0007.js');
    
    
</script>
