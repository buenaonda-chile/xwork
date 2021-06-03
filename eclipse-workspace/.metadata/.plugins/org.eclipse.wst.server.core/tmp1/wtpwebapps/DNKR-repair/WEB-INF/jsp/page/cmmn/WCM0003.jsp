<%-- [EN] Variable definition --%>
<%-- [JP] 変数定義 --%>
<c:url var="readUrl" value="/menuRole/search" />
<c:url var="updateUrl" value="/menuRole/update"/>

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


<style type="text/css">
	.ax-mask.edit .ax-mask-bg {
		background: #215efa;
		opacity: .1;
	}
</style>

<div class="sub-con-wrap">
	<h2 class="subpage-tit">그룹별메뉴관리</h2>
</div>

<div class="layout-LW">
	<%-- <div class="left">
		<kendo:treeList name="roleList" selectable="true" height="650">
			<kendo:treeList-change>
				<script>
          function onChange(args) {
            var selectedCells = this.select();
            var selectedDataItems = [];
            for (var i = 0; i < selectedCells.length; i++) {
              selectedDataItems.push(this.dataItem(selectedCells[i]));
            }
            searchView.set('criteria.roleCd', selectedDataItems[0].roleCd);
            searchView.search();
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
	
	
	  <div class="left grid-container" style="position: relative; width:49%; height: 650px;"> 
	  <!-- <div class="grid-container"> -->
		<div id="wijmoGrid" ></div>
		<a href="javascript:zoomIn($('#wijmoGrid'),flexGrid);">확대</a>
		<a href="javascript:zoomOut($('#wijmoGrid'),flexGrid);">축소</a>
	  </div>
	  
	  <div class="right grid-container" style="position: relative; width:49%; height: 650px;"> 
	  <!-- <div class="grid-container"> -->
		<div id="wijmoGrid2" ></div>
		<a href="javascript:zoomIn($('#wijmoGrid2'),flexGrid);">확대</a>
		<a href="javascript:zoomOut($('#wijmoGrid2'),flexGrid);">축소</a>
	  </div>
  
	<%-- <div class="right">
		<kendo:treeList name="menuList" autoBind="false" selectable="true" editable="true" height="650px">
			<kendo:treeList-columns>
				<kendo:treeList-column field="menuKoNm" title="한글"></kendo:treeList-column>
				<kendo:treeList-column field="menuEnNm" title="영어"></kendo:treeList-column>
				<kendo:treeList-column field="menuJaNm" title="일어"></kendo:treeList-column>
				<kendo:treeList-column field="use" title="사용여부"
															 template="<input type='checkbox' data-uid='#: uid #' #= use ? checked='checked' : '' #/>">
				</kendo:treeList-column>
			</kendo:treeList-columns>
			<kendo:dataSource>
				<kendo:dataSource-schema data="data">
					<kendo:dataSource-schema-model id="menuKey">
						<kendo:dataSource-schema-model-fields>
							<kendo:dataSource-schema-model-field name="menuKey" type="string" editable="false" />
							<kendo:dataSource-schema-model-field name="menuKoNm" type="string" editable="false" />
							<kendo:dataSource-schema-model-field name="menuEnNm" type="string" editable="false" />
							<kendo:dataSource-schema-model-field name="menuJaNm" type="string" editable="false" />
							<kendo:dataSource-schema-model-field name="use" type="boolean"/>
							<kendo:dataSource-schema-model-field name="parentId" from="upperMenuKey" type="string" nullable="true" editable="false"/>
						</kendo:dataSource-schema-model-fields>
					</kendo:dataSource-schema-model>
				</kendo:dataSource-schema>
				<kendo:dataSource-transport>
					<kendo:dataSource-transport-read url="${readUrl}" type="GET"
																					 contentType="application/json"/>
					<kendo:dataSource-transport-update url="${updateUrl}" type="POST"
																						 contentType="application/json" />
					<kendo:dataSource-transport-parameterMap>
						<script type="text/javascript">
              function parameterMap(options, type) {
                if (type != 'read') {
                  options = $.extend(options, searchView.criteria.toJSON());
                  console.log(options);
                  return JSON.stringify(options);
                } else {
                  return searchView.criteria.toJSON();
                }
              }
						</script>
					</kendo:dataSource-transport-parameterMap>
				</kendo:dataSource-transport>
				<kendo:dataSource-requestStart>
					<script type="text/javascript">
            function requestStart(e) {
              _dicasPage.maskOpen();
            }
					</script>
				</kendo:dataSource-requestStart>
				<kendo:dataSource-requestEnd>
					<script type="text/javascript">
            function requestEnd(e) {
              _dicasPage.maskClose();
              if (e.type != 'read') {
                menuList.dataSource.read();
              }
            }
					</script>
				</kendo:dataSource-requestEnd>
				<kendo:dataSource-error>
					<script type="text/javascript">
            function error(e) {
              try {
                var data = JSON.parse(e.xhr.responseText);
                alert(data.message);
              } catch (e) {
                alert('처리 중 오류가 발생하였습니다.');
              }
            }
					</script>
				</kendo:dataSource-error>
			</kendo:dataSource>
		</kendo:treeList>
	</div>
</div> --%>


<script type="text/javascript">

  var _dicasPage = new DicasPage('${screenId}');

//getScript로 호출을 해야지 js파일이 브라우저 캐시에 남지않고 새로고침시 바로바로 적용됩니다.    
  $.getScript('/js/comm/wcm0003.js');

</script>