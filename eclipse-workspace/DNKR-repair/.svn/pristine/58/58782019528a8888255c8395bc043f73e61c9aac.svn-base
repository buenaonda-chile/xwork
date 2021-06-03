<%-- [EN] Variable definition --%>
<%-- [JP] 変数定義 --%>
<c:url var="readUrl" value="/menu/search"/>
<c:url var="createUrl" value="/menu/create"/>
<c:url var="updateUrl" value="/menu/update"/>
<c:url var="deleteUrl" value="/menu/delete"/>

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
	<h2 class="subpage-tit">메뉴관리</h2>

	<!-- 버튼들 -->
	<div class="sub-btn-group">
		<button id="btn_root" class="button bc2" data-bind="click: root, visible: visible.root"><i class="w_add"></i>최상위</button>
		<button id="btn_add" class="button bc1" data-bind="click: add, visible: visible.add"><i class="w_add"></i>추가</button>
		<button id="btn_save" class="button bc2" data-bind="click: save, visible: visible.save"><i class="w_save"></i>저장</button>
		<button id="btn_cancel" class="button" data-bind="click: cancel, visible: visible.cancel"><i class="w_cancel"></i>취소</button>
		<button id="btn_remove" class="button" data-bind="click: remove, visible: visible.remove"><i class="w_minus"></i>삭제</button>
	</div>
	<!-- /버튼들 -->

</div>

<%-- .search1 --%>
<div class="search1">
	<form id="frm_search" method="get" data-bind="events: {submit: submit}">
		<fieldset>
			<table>
				<colgroup>
					<col style="width:100px"/>
					<col style="width:155px"/>
					<col/>
				</colgroup>
				<tbody>
					<tr>
						<th>대분류</th>
						<td>
							<kendo:dropDownList name="cmb_category_search" dataTextField="menuNm"
																	data-value-primitive="true"
																	dataValueField="menuKey"
																	data-bind="value: criteria.upperMenuKey"
																	optionLabel="전체" style="width: 100%;">
								<kendo:dataSource data="${menuCategoryItems}" />
								<kendo:dropDownList-change>
									<script type="text/javascript">
										function cmbCategorySearchOnChange(e) {
										  searchView.submit();
										}
									</script>
								</kendo:dropDownList-change>
							</kendo:dropDownList>
						</td>
						<td class="dpb"></td>
					</tr>
				</tbody>
			</table>
		</fieldset>
	</form>
</div>
<%--// .search1 --%>

<%-- .layout-LW --%>
<div class="layout-LW">
	<%-- <div class="left" style="width:38%;height:650px;">
		<div style="margin-bottom:10px;"></div>
			<kendo:treeList name="treeList" selectable="true" editable="true" height="640px" autoBind="false">
				<kendo:treeList-columns>
					<kendo:treeList-column field="menuKoNm" title="한글"></kendo:treeList-column>
					<kendo:treeList-column field="menuEnNm" title="영어"></kendo:treeList-column>
					<kendo:treeList-column field="menuJaNm" title="일어"></kendo:treeList-column>
					<kendo:treeList-column field="pubYn" title="게시여부" ></kendo:treeList-column>
				</kendo:treeList-columns>
				<kendo:dataSource>
					<kendo:dataSource-schema data="data">
						<kendo:dataSource-schema-model id="menuKey">
							<kendo:dataSource-schema-model-fields>
								<kendo:dataSource-schema-model-field name="menuKey" type="string" />
								<kendo:dataSource-schema-model-field name="menuKoNm" type="string" />
								<kendo:dataSource-schema-model-field name="menuEnNm" type="string" />
								<kendo:dataSource-schema-model-field name="menuJaNm" type="string" />
								<kendo:dataSource-schema-model-field name="menuCd" type="string" />
								<kendo:dataSource-schema-model-field name="menuOrdr" type="number" />
								<kendo:dataSource-schema-model-field name="menuUrl" type="string" />
								<kendo:dataSource-schema-model-field name="pubYn" type="string" />
								<kendo:dataSource-schema-model-field name="parentId" from="upperMenuId" type="string" nullable="true" />
								<kendo:dataSource-schema-model-field name="upperMenuKey" type="string" />
								<kendo:dataSource-schema-model-field name="menuIcon" type="string" />
							</kendo:dataSource-schema-model-fields>
						</kendo:dataSource-schema-model>
					</kendo:dataSource-schema>
					<kendo:dataSource-transport>
						<kendo:dataSource-transport-read url="${readUrl}" type="GET"
																						 contentType="application/json"/>
						<kendo:dataSource-transport-create url="${createUrl}" type="POST"
																							 contentType="application/json" />
						<kendo:dataSource-transport-update url="${updateUrl}" type="POST"
																							 contentType="application/json" />
						<kendo:dataSource-transport-destroy url="${deleteUrl}" type="POST"
																							 contentType="application/json" />
						<kendo:dataSource-transport-parameterMap>
							<script type="text/javascript">
								function parameterMap(options, type) {
								  if (type != 'read') {
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
							  if (e.type != 'read') {

                  var message = "", iscreate = false, isupdate = false, isdelete = false;
                  if (e.type == 'create') {
                    message = "변경된 데이터가 있습니다.  등록 하시겠습니까?";
                    iscreate = true;
                  } else if (e.type == 'update') {
                    message = "변경된 데이터가 있습니다.  수정 하시겠습니까?";
                    isupdate = true;
                  } else {
                    message = "변경된 데이터가 있습니다.  삭제 하시겠습니까?";
                    isdelete = true;
                  }

                  if (!confirm(message)) {
                    e.preventDefault();
                    return;
									}
								} else
								  inputView.set('data', null);

							  _dicasPage.maskOpen();
							}
						</script>
					</kendo:dataSource-requestStart>
					<kendo:dataSource-requestEnd>
						<script type="text/javascript">
							function requestEnd(e) {
                _dicasPage.maskClose();
                if (e.type != 'read') {
                  treeList.dataSource.read();
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
	</div> --%>
	
	<div class="left grid-container" style="position: relative; width:38%; height: 650px;"> 
	  <!-- <div class="grid-container"> -->
		<div id="wijmoGrid" ></div>
		<a href="javascript:zoomIn($('#wijmoGrid'),flexGrid);">확대</a>
		<a href="javascript:zoomOut($('#wijmoGrid'),flexGrid);">축소</a>
  	</div>
	
	<div id="form_container" class="right" style="width:61%;">
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
							<th scope="row"><label for="txt_menuKoNm_input">메뉴(한글) <em class="required" title="필수항목">*</em></label></th>
							<td>
								<input type="text" id="txt_menuKoNm_input" data-bind="value: data.menuKoNm" required/>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="txt_menuEnNm_input">메뉴(영어) <em class="required" title="필수항목">*</em></label></th>
							<td>
								<input type="text" id="txt_menuEnNm_input" data-bind="value: data.menuEnNm" required/>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="txt_menuJaNm_input">메뉴(일어) <em class="required" title="필수항목">*</em></label></th>
							<td>
								<input type="text" id="txt_menuJaNm_input" data-bind="value: data.menuJaNm" required/>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="num_menuOrdr_input">순서 <em class="required" title="필수항목">*</em></label></th>
							<td>
								<kendo:numericTextBox name="num_menuOrdr_input" format="#" min="1" max="99"
																			data-bind="value: data.menuOrdr" required="true"/>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="cmb_pubYn_input">게시여부 <em class="required" title="필수항목">*</em></label></th>
							<td>
								<kendo:dropDownList name="cmb_pubYn_input"
																		dataTextField="codeNm"
																		data-value-primitive="true"
																		dataValueField="codeCd"
																		data-bind="value: data.pubYn"
																		style="width: 240px;" required="true">
									<kendo:dataSource data="${pubYnItems}" />
								</kendo:dropDownList>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="txt_menuUrl_input">메뉴URL</label></th>
							<td>
								<input type="text" id="txt_menuUrl_input" data-bind="value: data.menuUrl"/>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="txt_menuIcon_input">메뉴Icon</label></th>
							<td>
								<input type="text" id="txt_menuIcon_input" data-bind="value: data.menuIcon"/>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="txt_upperMenuKey_input">상위메뉴</label></th>
							<td>
								<input type="text" id="txt_upperMenuKey_input" data-bind="value: data.upperMenuKey" readonly/>
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
  $.getScript('/js/comm/wcm0004.js');

</script>