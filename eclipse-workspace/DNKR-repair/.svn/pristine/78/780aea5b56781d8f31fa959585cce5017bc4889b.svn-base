<%-- [EN] Variable definition --%>
<%-- [JP] 変数定義 --%>
<c:url var="readUrl" value="/menuRole/search" />
<c:url var="updateUrl" value="/menuRole/update"/>

<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] 画面ID (@ViewIdで定義) --%>
<c:set var="screenId" value="<%= request.getAttribute(Globals.SCREEN_ID_KEY) %>"/>

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
	<div class="left">
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
	</div>
	<div class="right">
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
</div>


<script type="text/javascript">

  var _dicasPage = new DicasPage('${screenId}');

  <%-- Control Definition--%>
  var roleList;
  var menuList;
  <%--// Control Definition --%>

	var searchView = kendo.observable({
		criteria: {
		  roleCd: null
		},
		search: function() {
		  menuList.dataSource.read();
		}
	});


  function categoryDropDownEditor(container, options) {
    console.log(options);
    $('<input type="checkbox" data-bind="checked:' + options.field + '"/>')
		.appendTo(container);
  }

  $(document).ready(function() {
    menuList = $("#menuList").data('kendoTreeList');
    menuList.options.dataSource.schema.model.expanded = !menuList.options.dataSource.schema.model.expanded
    menuList.setDataSource(menuList.options.dataSource);

    menuList.dataSource.bind('change', function(e) {
      if (e.action == 'itemchange') {
        menuList.saveChanges();
			}
		});

    roleList = $("#roleList").data('kendoTreeList');
    var count = roleList.dataSource.data().length;
    // roleList expand all
    if (count > 0) {
      var rows = $("tr.k-treelist-group", roleList.tbody);
      $.each(rows, function(idx, row) {
        if (idx == 0) {
          roleList.select($(row));
        }
        roleList.expand(row);
      });
    }

    $("#menuList .k-grid-content").on("change", "input[type=checkbox]", function(e) {
      var dataItem = menuList.dataItem($(e.target).closest("tr"));
      dataItem.set("use", this.checked);
    });
	});

</script>