<%-- [EN] Variable definition --%>
<%-- [JP] ???? --%>
<c:url var="codeUrl" value="/code/list2.json"/>

<c:url var="initUrl" value="/trainingInfoBase/init"/>

<c:url var="readUrl" value="/trainingInfoBase/search"/>

<c:url var="createUrl" value="/trainingInfoBase/create"/>

<c:url var="updateUrl" value="/trainingInfoBase/update"/>

<c:url var="deleteUrl" value="/trainingInfoBase/delete"/>

<c:url var="downloadUrl" value="/trainingInfoBase/download"/>

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
  <h2 class="subpage-tit">교육정보관리</h2>
  <!-- 버튼들 -->
  <div class="sub-btn-group">
    <!-- 
    <button id="btn_search" type="button" class="button" data-bind="click: search"><i class="w_search"></i>검색</button>
    <button id="btn_down" class="button" data-bind="click: download2"><i class="w_down"></i>다운로드</button>
     -->
    <button id="btn_search" type="button" class="button" ><i class="w_search"></i>검색</button>
    <button id="btn_down" class="button"><i class="w_down"></i>다운로드</button>
  </div>
  <!-- /버튼들 -->
</div>

<%-- .search1 --%>
<div class="search1">
  <form id="frm_search" method="get" >
    <fieldset>
      <table>
        <colgroup>
          <col style="width:80px"/>
          <col style="width:155px"/>
<!--           <col style="width:80px"/>
          <col style="width:155px"/> -->
          <col style="width:80px"/>
          <col style="width:280px"/>
          <!-- <col style="width:80px"/>
          <col style="width:155px"/> -->
          <col/>
        </colgroup>
        <tr>
          <th>교육대상 구분</th>
           
          <td>
          	<div id="eduDiv"></div>
          </td>
          
          <th>교육기간</th>
          <td>
          	<input id="searchEduDtFr"> ~ <input id="searchEduDtTo">
          </td>
        </tr>
      </table>
    </fieldset>
  </form>
</div>
<%--// .search1 --%>

<%--
<div class="sub-con-wrap">
  <!-- <h2 class="subpage-tit">비용승인</h2> -->
  <!-- 버튼들 -->
  <div class="sub-btn-group">
    <button id="btn_add" class="button bc1" data-bind="click: add, visible: btnGrp0Visible"><i class="w_add"></i>추가</button>
    <button id="btn_save" class="button bc2" data-bind="click: save, visible: btnGrp3Visible"><i class="w_save"></i>저장</button>
    <button id="btn_remove" class="button" data-bind="click: remove, visible: btnGrp3Visible"><i class="w_minus"></i>삭제</button>
  </div>
  <!-- /버튼들 -->
</div>
--%>

<div style="margin-bottom: 5px;overflow: auto;">
	<div class="float-right">
		<button id="btn_add" type="button" class="button bc1"><i class="w_add"></i>추가</button>
	    <button id="btn_save" class="button bc2" data-bind="click: save, visible: btnGrp3Visible"><i class="w_save"></i>저장</button>
	    <button id="btn_remove" class="button" data-bind="click: remove, visible: btnGrp3Visible"><i class="w_minus"></i>삭제</button>
    </div>
</div>


<div class="grid-container" style="position: relative; height: 650px;">
	<div id="wijmoGrid" ></div>
	<a href="javascript:zoomIn($('#wijmoGrid'),flexGrid);">확대</a>
	<a href="javascript:zoomOut($('#wijmoGrid'),flexGrid);">축소</a>
</div>
 
<script type="text/javascript">

    var _dicasPage = new DicasPage('${screenId}');
    
    //getScript로 호출을 해야지 js파일이 브라우저 캐시에 남지않고 새로고침시 바로바로 적용됩니다.    
    $.getScript('/js/edu/edu0001.js');
    
    
</script>
