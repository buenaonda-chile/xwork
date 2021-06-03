<%-- [EN] Variable definition --%>
<%-- [JP] ???? --%>
<c:url var="codeUrl" value="/code/list.json"/>

<c:url var="readUrl" value="/partNumber/search"/>
<c:url var="createUrl" value="/partNumber/create"/>
<c:url var="updateUrl" value="/partNumber/update"/>
<c:url var="deleteUrl" value="/partNumber/delete"/>

<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] ??ID (@ViewId???) --%>
<c:set var="screenId" value="<%= request.getAttribute(Globals.SCREEN_ID_KEY) %>"/>

<div class="sub-con-wrap">
  <h2 class="subpage-tit">교환품번관리</h2>
  <!-- 버튼들 -->
  <div class="sub-btn-group">
    <button id="btn_search" class="button" data-bind="click: search, visible: btnGrp0Visible"><i class="w_search"></i>검색</button>
    <button id="btn_add" class="button bc1" data-bind="click: add, visible: btnGrp0Visible"><i class="w_add"></i>추가</button>
    <button id="btn_save" class="button bc2" data-bind="click: save, visible: btnGrp1Visible"><i class="w_save"></i>저장</button>
    <button id="btn_cancel" class="button" data-bind="click: cancel, visible: btnGrp1Visible"><i class="w_cancel"></i>취소</button>
    <button id="btn_remove" class="button" data-bind="click: remove, visible: btnGrp2Visible"><i class="w_minus"></i>삭제</button>
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
          <col style="width:100px"/>
          <col style="width:155px"/>
          <col style="width:100px"/>
          <col style="width:155px"/>
          <col style="width:100px"/>
          <col style="width:155px"/>
          <col style="width:100px"/>
          <col style="width:155px"/>
          <col/>
        </colgroup>
        <tr>
          <th>메이커</th>
          <td>
            <kendo:dropDownList name="cmb_maker_search" dataTextField="codeNm"
                                data-value-primitive="true"
                                dataValueField="codeCd"
                                data-bind="value: criteria.maker"
                                optionLabel="전체" style="width: 100%;">
              <kendo:dataSource>
                <kendo:dataSource-transport>
                  <kendo:dataSource-transport-read url="${codeUrl}/CAMAK" type="POST" contentType="application/json"/>
                  <kendo:dataSource-transport-parameterMap>
                    function(options){
                    return JSON.stringify(options);
                    }
                  </kendo:dataSource-transport-parameterMap>
                </kendo:dataSource-transport>
                <kendo:dataSource-schema data="data" total="total">
                </kendo:dataSource-schema>
              </kendo:dataSource>
            </kendo:dropDownList>
          </td>
          <th>부품구분</th>
          <td>
            <kendo:dropDownList name="cmb_partDiv_search" dataTextField="codeNm"
                                data-value-primitive="true"
                                dataValueField="codeCd"
                                data-bind="value: criteria.partDiv"
                                optionLabel="전체" style="width: 100%;">
              <kendo:dataSource>
                <kendo:dataSource-transport>
                  <kendo:dataSource-transport-read url="${codeUrl}/CAQPD" type="POST" contentType="application/json"/>
                  <kendo:dataSource-transport-parameterMap>
                    function(options){
                    return JSON.stringify(options);
                    }
                  </kendo:dataSource-transport-parameterMap>
                </kendo:dataSource-transport>
                <kendo:dataSource-schema data="data" total="total">
                </kendo:dataSource-schema>
              </kendo:dataSource>
            </kendo:dropDownList>
          </td>
          <th>배기형식</th>
          <td>
            <kendo:dropDownList name="cmb_exhaustReg_search" dataTextField="codeNm"
                                data-value-primitive="true"
                                dataValueField="codeCd"
                                data-bind="value: criteria.exhaustReg"
                                optionLabel="전체" style="width: 100%;">
              <kendo:dataSource>
                <kendo:dataSource-transport>
                  <kendo:dataSource-transport-read url="${codeUrl}/CAEMS" type="POST" contentType="application/json"/>
                  <kendo:dataSource-transport-parameterMap>
                    function(options){
                    return JSON.stringify(options);
                    }
                  </kendo:dataSource-transport-parameterMap>
                </kendo:dataSource-transport>
                <kendo:dataSource-schema data="data" total="total">
                </kendo:dataSource-schema>
              </kendo:dataSource>
            </kendo:dropDownList>
          </td>
          <th>사용여부</th>
          <td>
            <kendo:dropDownList name="cmb_useYn_search" dataTextField="codeNm"
                                data-value-primitive="true"
                                dataValueField="codeCd"
                                data-bind="value: criteria.useYn"
                                optionLabel="전체" style="width: 100%;">
              <kendo:dataSource>
                <kendo:dataSource-transport>
                  <kendo:dataSource-transport-read url="${codeUrl}/C020" type="POST" contentType="application/json"/>
                  <kendo:dataSource-transport-parameterMap>
                    function(options){
                    return JSON.stringify(options);
                    }
                  </kendo:dataSource-transport-parameterMap>
                </kendo:dataSource-transport>
                <kendo:dataSource-schema data="data" total="total">
                </kendo:dataSource-schema>
              </kendo:dataSource>
            </kendo:dropDownList>
          </td>
        </tr>
        <tr>
          <th>부품명</th>
          <td>
            <input type="text" id="exchangeNm_search" data-bind="value: criteria.exchangeNm" />
          </td>
          <th>HMC P/N</th>
          <td>
            <input type="text" id="hmc_search" data-bind="value: criteria.hmc" />
          </td>
          <th>DENSO P/N</th>
          <td>
            <input type="text" id="denso_search" data-bind="value: criteria.denso" />
          </td>
          <th>엔진형식</th>
          <td>
            <kendo:dropDownList name="cmb_engineType_search" dataTextField="codeNm"
                                data-value-primitive="true"
                                dataValueField="codeCd"
                                data-bind="value: criteria.engineType"
                                optionLabel="전체" style="width: 100%;">
              <kendo:dataSource>
                <kendo:dataSource-transport>
                  <kendo:dataSource-transport-read url="${codeUrl}/C021" type="POST" contentType="application/json"/>
                  <kendo:dataSource-transport-parameterMap>
                    function(options){
                    return JSON.stringify(options);
                    }
                  </kendo:dataSource-transport-parameterMap>
                </kendo:dataSource-transport>
                <kendo:dataSource-schema data="data" total="total">
                </kendo:dataSource-schema>
              </kendo:dataSource>
            </kendo:dropDownList>
          </td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
      </table>
    </fieldset>
  </form>
</div>
<%--// .search1 --%>

<%-- .layout-LW --%>
<div class="layout-LW">
  <div class="left" style="width:58%;">
    <div style="margin-bottom:10px;"></div>
    <div id="grid"  data-grid-type="view"></div>
  </div>
  <div id="form_container" class="right" style="width:40%;">
    <div class="wrap">
      <form id="frm_input" method="post">
        <input type="hidden" id="id_input" data-bind="value: data.id" disabled='disabled' />
        <fieldset>
          <table class="bWrite">
            <colgroup>
              <col style="width:130px"/>
              <col/>
            </colgroup>
            <tbody>
            </tr>
		
            <tr>
              <th scope="row"><label for="cmb_maker_input">메이커</label>
              </th>
              <td>
                <kendo:dropDownList name="cmb_maker_input" dataTextField="codeNm"
                                    dataValueField="codeCd"
                                    data-value-primitive="true"
                                    data-bind="value: data.maker">
                  <kendo:dataSource data="${makerItems}"/>
                </kendo:dropDownList>
              </td>
            </tr>
            <tr>
              <th scope="row"><label for="cmb_partDiv_input">부품구분</label>
              </th>
              <td>
                <kendo:dropDownList name="cmb_partDiv_input" dataTextField="codeNm"
                                    dataValueField="codeCd"
                                    data-value-primitive="true"
                                    data-bind="value: data.partDiv">
                  <kendo:dataSource data="${partDivItems}"/>
                </kendo:dropDownList>
              </td>
            </tr>

            <tr>
              <th scope="row"><label for="cmb_exhaustReg_input">배기규제형식</label>
              </th>
              <td>
                <kendo:dropDownList name="cmb_exhaustReg_input" dataTextField="codeNm"
                                    dataValueField="codeCd"
                                    data-value-primitive="true"
                                    data-bind="value: data.exhaustReg">
                  <kendo:dataSource data="${exhaustRegItems}"/>
                </kendo:dropDownList>
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="cmb_engineType_input">엔진형식</label>
              </th>
              <td>
                <kendo:dropDownList name="cmb_engineType_input" dataTextField="codeNm"
                                    dataValueField="codeCd"
                                    data-value-primitive="true"
                                    data-bind="value: data.engineType">
                  <kendo:dataSource data="${engineTypeItems}"/>
                </kendo:dropDownList>
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="exchangeNm_input">부품명</label>
              </th>
              <td>
                <input type="text" id="exchangeNm_input" data-bind="value: data.exchangeNm" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="hmc_input">HMC P/N</label>
              </th>
              <td>
                <input type="text" id="hmc_input" data-bind="value: data.hmc" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="denso_input">DENSO P/N</label>
              </th>
              <td>
                <input type="text" id="denso_input" data-bind="value: data.denso" />
              </td>
            </tr>

            <tr>
              <th scope="row"><label for="partsCost_input">부품비</label>
              </th>
              <td>
                <input type="text" id="partsCost_input" data-bind="value: data.partsCost" />
              </td>
            </tr>

            <tr>
              <th scope="row"><label for="margin_input">마진</label>
              </th>
              <td>
                <input type="text" id="margin_input" data-bind="value: data.margin" />
              </td>
            </tr>

            <tr>
              <th scope="row"><label for="workHour_input">작업시간</label>
              </th>
              <td>
                <input type="text" id="workHour_input" data-bind="value: data.workHour" />
              </td>
            </tr>

            <tr>
              <th scope="row">
                <label for="cmb_useYn_input">사용여부</label>
              </th>
              <td>
                <kendo:dropDownList name="cmb_useYn_input" dataTextField="codeNm"
                                    dataValueField="codeCd"
                                    data-value-primitive="true"
                                    data-bind="value: data.useYn">
                  <kendo:dataSource data="${useYnItems}"/>
                </kendo:dropDownList>
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

  <%-- Control Definition--%>
  var grid;
  var pagination;
  var net;
  <%--// Control Definition --%>

  <%-- Variable Definition --%>
  var validatable = null;
  <%--// Variable Definition --%>

  var codeMdl = kendo.data.Model.define({
      ID: 'ID',
      fields: {
        rn: { type: 'string' }
        ,maker: { type: 'string' }
        ,exhaustReg: { type: 'string' }
        ,engineType: { type: 'string' }
        ,exchangeNm: { type: 'string' }
        ,hmc: { type: 'string' }
        ,denso: { type: 'string' }
        ,partDiv: { type: 'string' }
        ,useYn: { type: 'string' }
        ,groupId: { type: 'string' }
        ,partsCost: { type: 'number' }
        ,margin: { type: 'number' }
        ,workHour: { type: 'number' }
    }
  });

  var buttonView = kendo.observable({
      btnGrp0Visible: true,
      btnGrp1Visible: false,
      btnGrp2Visible: false,
      search: function() {
          searchView.submit();
      },
      add: function() {

          var dataItem = new codeMdl().toJSON();
          grid.prependRow(dataItem, {focus: true});
          inputView.set('rowKey', grid.getRowAt(0)['rowKey']);
          inputView.set('rowIndex', 0)
          inputView.set('data', dataItem);
          this.set('btnGrp1Visible', true);

          setPageUI('add');
      },
      remove: function() {
          grid.removeRow(inputView.get('rowKey'));
          buttonView.set('btnGrp1Visible', true);
      },
      save: function() {
          inputView.save();
      },
      cancel: function () {
          if (inputView.hasChanges()) {
              if (!confirm("변경된 데이터가 있습니다. 취소 하시겠습니까?")) {
                  return;
              }
              grid.enable();
              grid.restore();
              this.set('btnGrp1Visible', false);
              grid.focusAt(inputView.get('rowIndex'), 0);
          }
      }
  });
  buttonView.bind('change', function (e) {

      if (e.field == "btnGrp1Visible") {

          if (this.get(e.field)) {

              this.set('btnGrp0Visible', false);
              this.set('btnGrp2Visible', false);

              if (searchView.get('rowKey') != null) {
                  if (grid.getRow(searchView.get('rowKey')) != null)
                      grid.disableRow(searchView.get('rowKey'));
              }
              $(pagination._view._containerElement).hide();
          } else {
              this.set('btnGrp0Visible', true);

              if (searchView.get('rowKey') != null) {
                  if (grid.getRow(searchView.get('rowKey')) != null)
                      grid.enableRow(searchView.get('rowKey'));
              }
              $(pagination._view._containerElement).show();
          }
      }
  });

  kendo.bind($("div.sub-con-wrap"), buttonView);

  var searchView = kendo.observable({
    rowKey: null,
    rowData: null,
    criteria: {
      grpCd: null,
    },
    submit: function () {
      if (inputView.hasChanges()) {
        if (!confirm("변경된 데이터가 있습니다. 조회 하시겠습니까?")) {
          return;
        }
      }
      goPage('grid1', 1);
      return false;
    }
  });
  kendo.bind($("#frm_search"), searchView);

  var inputView = kendo.observable({
    rowIndex: 0,
    rowKey: null,
    data: null,
    save: function () {
      if (!inputView.validate()) {
        alert('필수 항목을 입력해 주십시오.');
        return;
      }

      var message = "", iscreate = false, isupdate = false, isdelete = false;
      if (grid.getModifiedRows().createdRows.length > 0) {
        message = "변경된 데이터가 있습니다.  등록 하시겠습니까?";
        iscreate = true;
      } else if (grid.getModifiedRows().updatedRows.length > 0) {
        message = "변경된 데이터가 있습니다.  수정 하시겠습니까?";
        isupdate = true;
      } else if (grid.getModifiedRows().deletedRows.length > 0) {
        message = "변경된 데이터가 있습니다.  삭제 하시겠습니까?";
        isdelete = true;
      }

      if (inputView.hasChanges()) {
        if (!confirm(message)) {
          return;
        }
      }

      var dataMap = grid.getModifiedRows({
        checkedOnly: false
      });

      _dicasPage.maskOpen();

      if (iscreate) {
        $.ajax({
          method: "POST",
          url: '${createUrl}',
          data: JSON.stringify(dataMap.createdRows[0]),
          contentType: 'application/json;charset=UTF-8'
        }).done(function (data, status, jqXHR) {
          goPage('grid1', 1);
        }).fail(function (data, status, jqXHR) {
          alert("저장 중 오류가 발생하였습니다.");
        }).always(function () {
          _dicasPage.maskClose();
        });
      } else if (isupdate) {
        $.ajax({
          method: "POST",
          url: '${updateUrl}',
          data: JSON.stringify(dataMap.updatedRows[0]),
          contentType: 'application/json;charset=UTF-8'
        }).done(function (data, status, jqXHR) {
          _dicasPage.maskClose();
          goPage('grid1', 1);
        }).fail(function (data, status, jqXHR) {
          alert("수정 중 오류가 발생하였습니다.");
        }).always(function () {
          _dicasPage.maskClose();
        });
      } else if (isdelete) {
        $.ajax({
          method: "POST",
          url: '${deleteUrl}',
          data: JSON.stringify(dataMap.deletedRows[0]),
          contentType: 'application/json;charset=UTF-8'
        }).done(function (data, status, jqXHR) {
          _dicasPage.maskClose();
          goPage('grid1', 1);
        }).fail(function (data, status, jqXHR) {
          alert("삭제 중 오류가 발생하였습니다.");
        }).always(function () {
          _dicasPage.maskClose();
        });
      }
    },
    validate: function () {
      if (validatable == null) return true;
      return validatable.validate();
    },
    hasChanges: function () {
      return grid.isModified();
    }
  });

  inputView.bind('change', function (e) {

      if (e.field.indexOf('data.') > -1) {

          var itemNm = e.field.substr(5);
          grid.setValue(this.get('rowKey'), itemNm, this.get(e.field));
          if (this.hasChanges()) {
              buttonView.set('btnGrp1Visible', true);
          } else {
              buttonView.set('btnGrp1Visible', false);
          }
      }
  });
  kendo.bind($("#form_container"), inputView);

  function setPageUI(type) {
    if (type == "init") {
      $("input[type]", "#form_container").each(function (i, v) {
        $(v).attr("disabled", true);
      });

    } else if (type == 'view' || type == 'add') {

      $("input[type]", "#form_container").each(function (i, v) {
        $(v).attr("disabled", false);
      });

    }
  }

  function goPage(gridId, page) {
    if (gridId == "grid1") {
      searchView.set("rowKey", null);
      searchView.set("rowData", null);
      net.readData(1, searchView.criteria.toJSON(), true);
    }
  }

  $(document).ready(function () {

	cmbuseYnInput = $("#cmb_useYn_input", "#frm_input").data("kendoDropDownList");
	var useYnData = cmbuseYnInput.dataSource.data(), useYnItems = _dicasPage.getEditOptions(useYnData);

    cmbMakerInput = $("#cmb_maker_input", "#frm_input").data("kendoDropDownList");
    var makerData = cmbMakerInput.dataSource.data(), makerItems = _dicasPage.getEditOptions(makerData);

    // cmbGroupIdInput = $("#cmb_groupId_input", "#frm_input").data("kendoDropDownList");
    // var groupIdData = cmbGroupIdInput.dataSource.data(), groupIdItems = _dicasPage.getEditOptions(groupIdData);

    cmbPartDivInput = $("#cmb_partDiv_input", "#frm_input").data("kendoDropDownList");
    var partDivData = cmbPartDivInput.dataSource.data(), partDivItems = _dicasPage.getEditOptions(partDivData);

    cmbExhaustRegInput = $("#cmb_exhaustReg_input", "#frm_input").data("kendoDropDownList");
    var exhaustRegData = cmbExhaustRegInput.dataSource.data(), exhaustRegItems = _dicasPage.getEditOptions(exhaustRegData);

    cmbEgineTypeInput = $("#cmb_engineType_input", "#frm_input").data("kendoDropDownList");
      var engineTypeData = cmbEgineTypeInput.dataSource.data(), engineTypeItems = _dicasPage.getEditOptions(engineTypeData);

    validatable = $("#form_container").kendoValidator({validateOnBlur: false})
    .data("kendoValidator");

    tui.Grid.applyTheme('clean');
    grid = new tui.Grid({
      el: $('#grid'),
      scrollX: false,
      scrollY: true,
      rowHeight: 30,
      // keyColumnName: 'codeKey',
      useClientSort: false,
      showDummyRows: true,
      minBodyHeight: 30,
      bodyHeight: 600,
      pagination: true,
      selectionUnit: 'CELL',
      editingEvent: false,
      usageStatistics: false,
      columns: [

	{ title: '순번', name: 'rn', align: 'center' }
	,{
          title: '메이커',
          name: 'maker',
          align: 'center',
          editOptions: {
            type: 'select',
            listItems: makerItems,
            useViewMode: true
          }
    }
    ,{
          title: '부품구분',
          name: 'partDiv',
          align: 'center',
          editOptions: {
            type: 'select',
            listItems: partDivItems,
            useViewMode: true
          }
    }
	,{
          title: '배기규제형식',
          name: 'exhaustReg',
          align: 'center',
          editOptions: {
            type: 'select',
            listItems: exhaustRegItems,
            useViewMode: true
          }
    }
	,{
          title: '엔진형식',
          name: 'engineType',
          align: 'center',
          editOptions: {
              type: 'select',
              listItems: engineTypeItems,
              useViewMode: true
          }
    }
	,{ title: '부품명', name: 'exchangeNm', align: 'center' }
	,{ title: 'HMC P/N', name: 'hmc', align: 'center' }
	,{ title: 'DENSO P/N', name: 'denso', align: 'center' }
	,{ title: '부품비', name: 'partsCost', align: 'center' }
	,{ title: '마진', name: 'margin', align: 'center' }
	,{ title: '작업시간', name: 'workHour', align: 'center' }
          ,{
              title: '사용여부',
              name: 'useYn',
              align: 'center',
              editOptions: {
                  type: 'select',
                  listItems: useYnItems,
                  useViewMode: true
              }
          }
      ]
    });

    grid.use('Net', {
      el: $('#frm_input'),
      initialRequest: false,
      readDataMethod: 'GET',
      perPage: 25,
      enableAjaxHistory: false,
      api: {
        'readData': '${readUrl}',
        // 'downloadExcel': './api/download/excel',
        // 'downloadExcelAll': './api/download/excelAll'
      }
    });

    // Bind event handlers
    grid.on('beforeRequest', function (data) {
      // For all requests
      _dicasPage.maskOpen();
    }).on('response', function (data) {
      // For all response (regardless of success or failure)
      _dicasPage.maskClose();
    }).on('successResponse', function (data) {
      if (data.requestType == 'readData') {
        inputView.set('data', null);
        inputView.set('rowKey', null);
        inputView.set('rowIndex', 0);
      } else {
      }
    }).on('failResponse', function (data) {
    }).on('errorResponse', function (data) {
    }).on('focusChange', function (eventData) {

      if (inputView.hasChanges()) {
        eventData.stop();
      } else {
        if (eventData.prevRowKey != eventData.rowKey) {
          var rowIndex = this.getIndexOfRow(eventData.rowKey);
          inputView.set("rowIndex", rowIndex);
          inputView.set("rowKey", eventData.rowKey);
          inputView.set('data', this.getRow(eventData.rowKey));
          buttonView.set('btnGrp2Visible', true);
          setPageUI('view');
        }

        var that = this;
        setTimeout(function() {
            that.selection({
                start: [rowIndex, 0],
                end: [rowIndex, that.modelManager.columnModel.getVisibleColumns().length - 1]
            });
        },100);
      }
    });

    net = grid.getAddOn('Net');
    pagination = grid.getPagination();
    pagination.on('afterMove', function (eventData) {
      buttonView.set('btnGrp1Visible', false);
      if (grid.getRowCount() > 0)
        grid.focusAt(0, 0);
    });

    setPageUI("init");
  });

</script>
