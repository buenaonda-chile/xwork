<%-- [EN] Variable definition --%>
<%-- [JP] ???? --%>
<c:url var="codeUrl" value="/code/list.json"/>

<c:url var="readUrl" value="/resultMasterCost/search"/>
<c:url var="createUrl" value="/resultMasterCost/create"/>
<c:url var="updateUrl" value="/resultMasterCost/update"/>
<c:url var="deleteUrl" value="/resultMasterCost/delete"/>

<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] ??ID (@ViewId???) --%>
<c:set var="screenId" value="<%= request.getAttribute(Globals.SCREEN_ID_KEY) %>"/>

<div class="sub-con-wrap">
  <h2 class="subpage-tit">화면명</h2>
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
  <form id="frm_search" method="get" >
    <fieldset>
      <table>
        <colgroup>
          <col style="width:100px"/>
          <col style="width:155px"/>
          <col/>
        </colgroup>
        <tr>
          <th>그룹</th>
          <td>
            검색조건 미입력
          </td>
          <td>&nbsp;</td>
        </tr>
      </table>
    </fieldset>
  </form>
</div>
<%--// .search1 --%>

<%-- .layout-LW --%>
<div class="layout-LW">
  <div class="left" style="width:38%;">
    <div style="margin-bottom:10px;"></div>
    <div id="grid" data-grid-type="view"></div>
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
              <th scope="row"><label for="vinno_input">VINNO</label>
              </th>
              <td>
                <input type="text" id="vinno_input" data-bind="value: data.vinno" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="mngNo_input">MNG_NO</label>
              </th>
              <td>
                <input type="text" id="mngNo_input" data-bind="value: data.mngNo" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="serviceSeq_input">SERVICE_SEQ</label>
              </th>
              <td>
                <input type="text" id="serviceSeq_input" data-bind="value: data.serviceSeq" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="div_input">DIV</label>
              </th>
              <td>
                <input type="text" id="div_input" data-bind="value: data.div" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="seq_input">SEQ</label>
              </th>
              <td>
                <input type="text" id="seq_input" data-bind="value: data.seq" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="costCd_input">COST_CD</label>
              </th>
              <td>
                <input type="text" id="costCd_input" data-bind="value: data.costCd" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="costValue_input">COST_VALUE</label>
              </th>
              <td>
                <input type="text" id="costValue_input" data-bind="value: data.costValue" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="regUserId_input">REG_USER_ID</label>
              </th>
              <td>
                <input type="text" id="regUserId_input" data-bind="value: data.regUserId" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="regDt_input">REG_DT</label>
              </th>
              <td>
                <input type="text" id="regDt_input" data-bind="value: data.regDt" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="updUserId_input">UPD_USER_ID</label>
              </th>
              <td>
                <input type="text" id="updUserId_input" data-bind="value: data.updUserId" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="updDt_input">UPD_DT</label>
              </th>
              <td>
                <input type="text" id="updDt_input" data-bind="value: data.updDt" />
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
	vinno: { type: 'string' }
	,mngNo: { type: 'string' }
	,serviceSeq: { type: 'number' }
	,div: { type: 'string' }
	,seq: { type: 'number' }
	,costCd: { type: 'string' }
	,costValue: { type: 'number' }
	,regUserId: { type: 'string' }
	,regDt: { type: 'string' }
	,updUserId: { type: 'string' }
	,updDt: { type: 'string' }

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
    criteria: {
      grpCd: null,
    },
      rowIndex: 0,
      data: null,

    submit: function () {
      if (inputView.hasChanges()) {
        if (!confirm("변경된 데이터가 있습니다. 조회 하시겠습니까?")) {
          return;
        }
      }
      goPage('grid1', 1);
      return false;
    },

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
      net.readData(1, searchView.criteria.toJSON(), true);
    }
  }

  $(document).ready(function () {

											

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
        treeColumnOptions: {
            name: 'ID',
            useCascadingCheckbox: false
        },
      columns: [

	{ title: 'VINNO', name: 'vinno', align: 'center' }
	,{ title: 'MNG_NO', name: 'mngNo', align: 'center' }
	,{ title: 'SERVICE_SEQ', name: 'serviceSeq', align: 'center' }
	,{ title: 'DIV', name: 'div', align: 'center' }
	,{ title: 'SEQ', name: 'seq', align: 'center' }
	,{ title: 'COST_CD', name: 'costCd', align: 'center' }
	,{ title: 'COST_VALUE', name: 'costValue', align: 'center' }
	,{ title: 'REG_USER_ID', name: 'regUserId', align: 'center' }
	,{ title: 'REG_DT', name: 'regDt', align: 'center' }
	,{ title: 'UPD_USER_ID', name: 'updUserId', align: 'center' }
	,{ title: 'UPD_DT', name: 'updDt', align: 'center' }


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
          var rowIndex = this.getIndexOfRow(eventData.prevRowKey);
          var columnIndex = this.getIndexOfColumn(eventData.prevColumnName);
          inputView.set("rowIndex", rowIndex);
          this.focusAt(rowIndex, columnIndex);
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
