<%-- [EN] Variable definition --%>
<%-- [JP] ???? --%>
<c:url var="codeUrl" value="/code/list2.json"/>

<c:url var="initUrl" value="/repairSDBrkVehicle/init"/>

<c:url var="readUrl" value="/repairSDBrkVehicle/search"/>

<c:url var="createUrl" value="/repairSDBrkVehicle/create"/>

<c:url var="updateUrl" value="/repairSDBrkVehicle/update"/>

<c:url var="deleteUrl" value="/repairSDBrkVehicle/delete"/>

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
<!--  -->


<div class="sub-con-wrap">
  <h2 class="subpage-tit">고장차 수리</h2>
  <!-- 버튼들 -->
  <div class="sub-btn-group">

    <button id="btn_search" type="button" class="button" ><i class="w_search"></i>검색</button>
    <button id="btn_add" class="button bc1"><i class="w_add"></i>추가</button>
    <button id="btn_save" class="button bc2"><i class="w_save"></i>저장</button>
    <button id="btn_remove" class="button"><i class="w_minus"></i>삭제</button>
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
          <th style="width:10px;">수리번호</th>
          <td>
          	<input type="text" style="width:100px; height:35px;" name="repNo" id="repNo">
          </td>
          <th>수리일자</th>
          <td style="width:300px;">
          	<input id="searchRepDtFr"> ~ <input id="searchRepDtTo">
          </td>
        </tr>
      </table>
    </fieldset>
  </form>
</div>

			<input type="text" style="display:none;" id="checkValue">

<div class="grid-container" style="position: relative; height: 650px;">
	<div id="wijmoGrid" ></div>
	<a href="javascript:zoomIn($('#wijmoGrid'),flexGrid);">확대</a>
	<a href="javascript:zoomOut($('#wijmoGrid'),flexGrid);">축소</a>
</div>
 
<script type="text/javascript">

    var _dicasPage = new DicasPage('${screenId}');
    
    //getScript로 호출을 해야지 js파일이 브라우저 캐시에 남지않고 새로고침시 바로바로 적용됩니다.    
    $.getScript('/js/sd/sd0005.js');
    
    
</script>
