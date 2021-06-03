<%-- [EN] Variable definition --%>
<%-- [JP] 変数定義 --%>
<c:url var="groupCodeUrl" value="/code/group/list.json"/>
<c:url var="codeUrl" value="/code/list.json"/>

<c:url var="readUrl" value="/code/search"/>
<c:url var="downloadUrl" value="/code/download"/>
<c:url var="createUrl" value="/code/create"/>
<c:url var="updateUrl" value="/code/update"/>
<c:url var="deleteUrl" value="/code/delete"/>

<c:url var="popupUrl" value="/popup/code/init"/>

<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] 画面ID (@ViewIdで定義) --%>
<c:set var="screenId" value="<%= request.getAttribute(Globals.SCREEN_ID_KEY) %>"/>

<%-- .search1 --%>
<div class="search1">
  <form id="frm_search" method="get" data-bind="events: {submit: submit}">
    <fieldset>
      <table>
        <colgroup>
          <col style="width:100px"/>
          <col style="width:155px"/>
          <col style="width:155px"/>
          <col/>
        </colgroup>
        <tr>
          <th>조회조건</th>
          <td>
            <kendo:dropDownList name="cmb_grpCd_search" dataTextField="codeNm"
                                data-value-primitive="true"
                                dataValueField="codeCd"
                                data-bind="value: criteria.grpCd"
                                optionLabel="전체" style="width: 100%;">
              <kendo:dataSource>
                <kendo:dataSource-transport>
                  <kendo:dataSource-transport-read url="${groupCodeUrl}" type="POST"
                                                   contentType="application/json"/>
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
          <td><input type="text" id="txt_codeNm" value="" title="코드명"
                     data-bind="value: criteria.codeNm"/></td>
          <td>
            <button type="submit" value="submit" class="button">
              <i class="w_search"></i>검색
            </button>
            <button type="button" class="button" data-bind="click: popup">
              <i class="w_nwin"></i>팝업
            </button>
						<button type="button" class="button" data-bind="click: download">
              <i class="w_down"></i>다운로드
            </button>
          </td>
        </tr>
      </table>
    </fieldset>
  </form>
</div>
<%--// .search1 --%>

<%-- .layout-LW --%>
<div class="layout-LW">
  <div class="left" style="width:38%;">
    <h2>코드목록</h2>
    <div style="margin-bottom:10px;"></div>
    <div id="grid" data-grid-type="view"></div>
  </div>
  <div id="form_container" class="right" style="width:60%;">
    <div id="btn_group_0" style="position:absolute;top:60px;right:5px;z-index:2;"
         data-bind="visible: btnGrp0Visible">
      <button id="btn_save" class="button bc2" data-bind="click: save">
        <i class="w_save"></i> 저장
      </button>
      <button id="btn_cancel" class="button" data-bind="click: cancel">
        <i class="w_cancel"></i> 취소
      </button>
    </div>
    <div class="wrap">
      <form id="frm_input" method="post">
        <fieldset>
          <h2>코드정보</h2>
          <table class="bWrite">
            <colgroup>
              <col style="width:130px"/>
              <col/>
            </colgroup>
            <tbody>
            <tr>
              <th scope="row">
                <label for="cmb_grpCd_input">코드그룹 <em class="required" title="필수항목">*</em></label>
              </th>
              <td>
                <kendo:dropDownList name="cmb_grpCd_input" dataTextField="codeNm"
                                    data-value-primitive="true"
                                    dataValueField="codeCd"
                                    data-bind="value: data.grpCd"
                                    optionLabel="그룹코드">
                  <kendo:dataSource data="${groupItems}"/>
                </kendo:dropDownList>
              </td>
            </tr>
            <tr>
              <th scope="row"><label for="codeCd_input">코드 <em class="required" title="필수항목">*</em></label>
              </th>
              <td>
                <input type="text" id="codeCd_input" data-bind="value: data.codeCd" required/>
              </td>
            </tr>
            <tr>
              <th scope="row"><label for="codeKoNm_input">코드명(한글) <em class="required" title="필수항목">*</em></label>
              </th>
              <td>
                <input type="text" id="codeKoNm_input" data-bind="value: data.codeKoNm" required/>
              </td>
            </tr>
            <tr>
              <th scope="row"><label for="codeEnNm_input">코드명(영문)</label></th>
              <td>
                <input type="text" id="codeEnNm_input" data-bind="value: data.codeEnNm"/>
              </td>
            </tr>
            <tr>
              <th scope="row"><label for="codeJaNm_input">코드명(일문)</label></th>
              <td>
                <input type="text" id="codeJaNm_input" data-bind="value: data.codeJaNm"/>
              </td>
            </tr>
            <tr>
              <th scope="row">
                <label for="num_codeOrder_input">순서</label>
              </th>
              <td>
                <kendo:numericTextBox name="num_codeOrder_input" format="#" min="1"
                                      data-bind="value: data.codeOrdr"/>
              </td>
            </tr>
            <tr>
              <th scope="row">
                <label for="cmb_useYn_input">사용</label>
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
            <tr>
              <th scope="row"><label for="ref1_input">참고1</label>
              </th>
              <td>
                <input type="text" id="ref1_input" data-bind="value: data.ref1" />
              </td>
            </tr>
            <tr>
              <th scope="row"><label for="ref2_input">참고2</label>
              </th>
              <td>
                <input type="text" id="ref2_input" data-bind="value: data.ref2" />
              </td>
            </tr>
            <tr>
              <th scope="row"><label for="ref3_input">참고3</label>
              </th>
              <td>
                <input type="text" id="ref3_input" data-bind="value: data.ref3" />
              </td>
            </tr>
            <tr>
              <th scope="row"><label for="ref4_input">참고4</label>
              </th>
              <td>
                <input type="text" id="ref4_input" data-bind="value: data.ref4" />
              </td>
            </tr>
            <tr>
              <th scope="row"><label for="ref5_input">참고5</label>
              </th>
              <td>
                <input type="text" id="ref5_input" data-bind="value: data.ref5" />
              </td>
            </tr>
            </tbody>
          </table>
        </fieldset>
      </form>
    </div>
    <div class="btns">
      <div id="btn_group_1" class="left" data-bind="visible: btnGrp1Visible">
        <button id="btn_add" class="button bc1" data-bind="click: add"><i class="w_add"></i>추가
        </button>
      </div>
      <div id="btn_group_2" class="right" data-bind="visible: btnGrp2Visible">
        <button id="btn_remove" class="button" data-bind="click: remove"><i class="w_minus"></i>삭제
        </button>
      </div>
    </div>
  </div>
</div>
<%--// .layout-LW --%>

<script type="text/javascript">

  var _dicasPage = new DicasPage('${screenId}');

  <%-- Control Definition--%>
  var cmbUseYnInput;
  var cmbGroupInput;
  var numCodeOrdrInput;
  var grid;
  var pagination;
  var net;
  <%--// Control Definition --%>

  <%-- Variable Definition --%>
  var validatable = null;
  <%--// Variable Definition --%>

  var codeMdl = kendo.data.Model.define({
    id: 'codeKey',
    fields: {
      codeKey: {
        type: 'string',
      },
      grpCd: {
        type: 'string'
      },
      codeCd: {
        type: 'string',
      },
      codeNm: {
        type: 'string',
      },
      codeKoNm: {
        type: 'string',
      },
      codeEnNm: {
        type: 'string'
      },
      codeJaNm: {
        type: 'string'
      },
      codeOrdr: {
        type: "number",
        defaultValue: 1
      },
      useYn: {
        type: "string",
        defaultValue: "Y"
      },
    }
  });

  var searchView = kendo.observable({
    rowKey: null,
    rowData: null,
    criteria: {
      grpCd: null,
      codeNm: null,
    },
    submit: function () {
      if (inputView.hasChanges()) {
        if (!confirm("변경된 데이터가 있습니다. 조회 하시겠습니까?")) {
          return;
        }
      }
      goPage('grid1', 1);
      return false;
    },
    popup: function() {
      var that = this;
      _dicasPage.popupOpen({
        url: "${popupUrl}",
        code: 'codeHelp',
        width: 500,
        height: 500,
        beforeOpen: function() {
          _dicasPage.beforeCodeHelpVal = true;
        },
        afterClose: function(info) {
          if (info.result) {
            var _data = JSON.parse(info.data);
            that.set('criteria.codeNm', _data.codeNm);
          } else
            that.set('criteria.codeNm', null);

        }
      });
    },
    download: function() {
      net.download('excelAll');
    }
  });
  kendo.bind($("#frm_search"), searchView);

  var inputView = kendo.observable({
    rowIndex: 0,
    rowKey: null,
    data: null,
    btnGrp0Visible: false,
    btnGrp1Visible: true,
    btnGrp2Visible: false,
    add: function () {
      var dataItem = new codeMdl().toJSON();

      grid.prependRow(dataItem, {focus: true});
      this.set('rowKey', grid.getRowAt(0)['rowKey']);
      this.set('rowIndex', 0)
      this.set('data', dataItem);
      this.set('btnGrp0Visible', true);

      setPageUI('add');
    },
    remove: function () {
      grid.removeRow(this.get('rowKey'));
      this.set('btnGrp0Visible', true);
    },
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
    cancel: function () {
      if (inputView.hasChanges()) {
        if (!confirm("변경된 데이터가 있습니다. 취소 하시겠습니까?")) {
          return;
        }
        grid.enable();
        grid.restore();
        this.set('btnGrp0Visible', false);
        grid.focusAt(this.get('rowIndex'), 0);
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
      console.log(this.hasChanges());
      if (this.hasChanges()) {
        this.set('btnGrp0Visible', true);
      } else {
        this.set('btnGrp0Visible', false);
      }
    } else if (e.field == "btnGrp0Visible") {
      if (this.get(e.field)) {
        this.set('btnGrp1Visible', false);
        this.set('btnGrp2Visible', false);
        if (this.get('rowKey') != null) {
          if (grid.getRow(this.get('rowKey')) != null)
            grid.disableRow(this.get('rowKey'));
        }
        $(pagination._view._containerElement).hide();
      } else {
        this.set('btnGrp1Visible', true);
        this.set('btnGrp2Visible', true);

        if (this.get('rowKey') != null) {
          if (grid.getRow(this.get('rowKey')) != null)
            grid.enableRow(this.get('rowKey'));
        }
        $(pagination._view._containerElement).show();
      }
    }
  });
  kendo.bind($("#form_container"), inputView);

  function setPageUI(type) {
    if (type == "init") {
      $("input[type]", "#form_container").each(function (i, v) {
        $(v).attr("disabled", true);
      });

      cmbGroupInput.enable(false);
      cmbUseYnInput.enable(false);
      numCodeOrdrInput.enable(false);
    } else if (type == 'view' || type == 'add') {

      $("input[type]", "#form_container").each(function (i, v) {
        $(v).attr("disabled", false);
      });

      cmbGroupInput.enable(true);
      cmbUseYnInput.enable(true);
      numCodeOrdrInput.enable(true);
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

    cmbGroupInput = $("#cmb_grpCd_input", "#frm_input").data("kendoDropDownList");
    cmbUseYnInput = $("#cmb_useYn_input", "#frm_input").data("kendoDropDownList");
    numCodeOrdrInput = $("#num_codeOrder_input", "#frm_input").data("kendoNumericTextBox");
    validatable = $("#form_container").kendoValidator({validateOnBlur: false}).data("kendoValidator");
    // $('#txt_codeNm').tagsInput({
    //   interactive: false,
    //   defaultText: '',
    //   width:'380px',
    //   height:'28px',
    //   onAddTag: function(tag) {
    //     console.log(tag);
    //     searchView.set('criteria.codeNm', tag);
    //     console.log(searchView.criteria.toJSON());
    //   },
    //   onRemoveTag: function(tag) {
    //     console.log(tag);
    //   }
    // });

    var groupData = cmbGroupInput.dataSource.data(),
        groupItems = _dicasPage.getEditOptions(groupData);

    var useYnData = cmbUseYnInput.dataSource.data(),
        useYnItems = _dicasPage.getEditOptions(useYnData);

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
      selectionUnit: 'row',
      editingEvent: false,
      usageStatistics: false,
      columns: [
        {
          title: '그룹',
          name: 'grpCd',
          align: 'center',
          editOptions: {
            type: 'select',
            listItems: groupItems,
            useViewMode: true
          }
        },
        {
          title: '코드',
          name: 'codeCd',
          align: 'center',
        },
        {
          title: '코드명',
          name: 'codeNm',
          align: 'center',
        },
        {
          title: '순서',
          name: 'codeOrdr',
          align: 'right',
        },
        {
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
        'downloadExcelAll': '${downloadUrl}'
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

        var rowIndex = this.getIndexOfRow(eventData.rowKey);
        if (eventData.prevRowKey != eventData.rowKey) {
          inputView.set("rowIndex", rowIndex);
          inputView.set("rowKey", eventData.rowKey);
          inputView.set('data', this.getRow(eventData.rowKey));
          inputView.set('btnGrp2Visible', true);
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
      inputView.set('btnGrp0Visible', false);
      if (grid.getRowCount() > 0)
        grid.focusAt(0, 0)
    });

    setPageUI("init");
  });

</script>


