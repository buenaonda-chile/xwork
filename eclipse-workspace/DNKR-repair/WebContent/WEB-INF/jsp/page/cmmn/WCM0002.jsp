<%@ taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags" %>
<%-- [EN] Variable definition --%>
<%-- [JP] ???? --%>
<c:url var="codeUrl" value="/code/list.json"/>

<c:url var="readUrl" value="/role/search"/>
<c:url var="createUrl" value="/role/create"/>
<c:url var="updateUrl" value="/role/update"/>
<c:url var="deleteUrl" value="/role/delete"/>

<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] 画面ID (@ViewIdで定義) --%>
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
  <h2 class="subpage-tit">권한그룹관리</h2>
</div>

<%-- .layout-LW --%>
<div class="layout-LW">
  <%-- <div class="left br_tree" style="width:38%;height:650px;">
		<kendo:treeList name="treelist" selectable="true">
			<kendo:treeList-change>
        <script>
          function onChange(args) {
            var selectedCells = this.select();
            var selectedDataItems = [];
            for (var i = 0; i < selectedCells.length; i++) {
              selectedDataItems.push(this.dataItem(selectedCells[i]));
            }
            inputView.set('data', selectedDataItems[0]);
          }
        </script>
      </kendo:treeList-change>
			<kendo:treeList-columns>
        <kendo:treeList-column field="roleNm" title="권한그룹" expandable="true"></kendo:treeList-column>
      </kendo:treeList-columns>
			<kendo:dataSource data="${roleItems}">
        <kendo:dataSource-schema>
          <kendo:dataSource-schema-model id="roleCd">
            <kendo:dataSource-schema-model-fields>
              <kendo:dataSource-schema-model-field name="roleCd" type="string" />
              <kendo:dataSource-schema-model-field name="parentId" from="upperRoleCd" type="string" nullable="true" />
              <kendo:dataSource-schema-model-field name="roleNm" type="string" />
							<kendo:dataSource-schema-model-field name="etcCn" type="string" />
            </kendo:dataSource-schema-model-fields>
          </kendo:dataSource-schema-model>
        </kendo:dataSource-schema>
      </kendo:dataSource>
    </kendo:treeList>
  </div> --%>
  <div class="left br_tree" style="width:38%;height:650px;">
	  <!-- <div class="left grid-container" style="position: relative; width:38%; height: 650px;"> -->
	  <div class="grid-container">
		<div id="wijmoGrid" ></div>
		<a href="javascript:zoomIn($('#wijmoGrid'),flexGrid);">확대</a>
		<a href="javascript:zoomOut($('#wijmoGrid'),flexGrid);">축소</a>
	  </div>
  </div>
 
  <div id="form_container" class="right" style="width:60%;">
    <div class="wrap">
      <form id="frm_input" method="post">
        <fieldset>
          <table class="bWrite">
            <colgroup>
              <col style="width:130px"/>
              <col/>
            </colgroup>
            <tbody>
				<tr>
					<th scope="row"><label for="roleCd_input">그룹ID</label>
					</th>
					<td>
						<input type="text" id="roleCd_input" name="roleCd_input" readonly data-bind="value: data.roleCd" />
					</td>
				</tr>
				<tr>
					<th scope="row"><label for="roleNm_input">그룹명</label>
					</th>
					<td>
						<input type="text" id="roleNm_input" name="roleNm_input" readonly data-bind="value: data.roleNm" />
					</td>
				</tr>
				<%--<tr>--%>
					<%--<th scope="row"><label for="etcCn_input">비고</label>--%>
					<%--</th>--%>
					<%--<td>--%>
						<%--<input type="text" id="etcCn_input" name="etcCn_input" readonly data-bind="value: data.etcCn" />--%>
					<%--</td>--%>
				<%--</tr>--%>
				<tr>
					<th scope="row"><label for="upperRoleCd_input">상위그룹ID</label>
					</th>
					<td>
						<input type="text" id="upperRoleCd_input" name="upperRoleCd_input" readonly data-bind="value: data.parentId" />
					</td>
				</tr>
            </tbody>
          </table>
        </fieldset>
      </form>
    </div>
  </div>
</div>
<%--// .layout-LW --%>

<script type="text/javascript">

    var _dicasPage = new DicasPage('${screenId}');

  //getScript로 호출을 해야지 js파일이 브라우저 캐시에 남지않고 새로고침시 바로바로 적용됩니다.    
    $.getScript('/js/comm/wcm0002.js');
</script>
