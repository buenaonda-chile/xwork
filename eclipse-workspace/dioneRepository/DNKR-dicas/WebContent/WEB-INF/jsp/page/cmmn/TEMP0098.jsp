<%-- [EN] Variable definition --%>
<%-- [JP] ???? --%>
<c:url var="codeUrl" value="/code/list.json"/>

<c:url var="readUrl" value="/resultSub/search"/>
<c:url var="createUrl" value="/resultSub/create"/>
<c:url var="updateUrl" value="/resultSub/update"/>
<c:url var="deleteUrl" value="/resultSub/delete"/>

<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] ??ID (@ViewId???) --%>
<c:set var="screenId" value="<%= request.getAttribute(Globals.SCREEN_ID_KEY) %>"/>

<div class="sub-con-wrap">
  <h2 class="subpage-tit">결과서브화면</h2>
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
              <th scope="row"><label for="id_input">ID</label>
              </th>
              <td>
                <input type="text" id="id_input" data-bind="value: data.id" disabled='disabled' /> 
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="vinno_input">VINNO</label>
              </th>
              <td>
                <input type="text" id="vinno_input" data-bind="value: data.vinno" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="manageNo_input">관리NO</label>
              </th>
              <td>
                <input type="text" id="manageNo_input" data-bind="value: data.manageNo" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="serviceDegree_input">서비스차수</label>
              </th>
              <td>
                <input type="text" id="serviceDegree_input" data-bind="value: data.serviceDegree" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="resultDegree_input">결과차수</label>
              </th>
              <td>
                <input type="text" id="resultDegree_input" data-bind="value: data.resultDegree" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="actionType_input">작업유형</label>
              </th>
              <td>
                <input type="text" id="actionType_input" data-bind="value: data.actionType" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="callCenterApproval_input">콜센터승인여부</label>
              </th>
              <td>
                <input type="text" id="callCenterApproval_input" data-bind="value: data.callCenterApproval" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="repairDate_input">수리일</label>
              </th>
              <td>
                <input type="text" id="repairDate_input" data-bind="value: data.repairDate" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="roNo_input">RONO</label>
              </th>
              <td>
                <input type="text" id="roNo_input" data-bind="value: data.roNo" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="roConfirmDate_input">RO확정일</label>
              </th>
              <td>
                <input type="text" id="roConfirmDate_input" data-bind="value: data.roConfirmDate" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="roSpecialFeature_input">RO특기사항</label>
              </th>
              <td>
                <input type="text" id="roSpecialFeature_input" data-bind="value: data.roSpecialFeature" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="lotNo_input">LOTNO</label>
              </th>
              <td>
                <input type="text" id="lotNo_input" data-bind="value: data.lotNo" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="hmcPartNo_input">HMC품번</label>
              </th>
              <td>
                <input type="text" id="hmcPartNo_input" data-bind="value: data.hmcPartNo" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="replacePartNo_input">교환품번</label>
              </th>
              <td>
                <input type="text" id="replacePartNo_input" data-bind="value: data.replacePartNo" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="replacePartNm_input">교환품명</label>
              </th>
              <td>
                <input type="text" id="replacePartNm_input" data-bind="value: data.replacePartNm" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="replacePartCnt_input">교환품갯수</label>
              </th>
              <td>
                <input type="text" id="replacePartCnt_input" data-bind="value: data.replacePartCnt" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="usage_input">사용자재</label>
              </th>
              <td>
                <input type="text" id="usage_input" data-bind="value: data.usage" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="recallType_input">회수유형</label>
              </th>
              <td>
                <input type="text" id="recallType_input" data-bind="value: data.recallType" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="recallReqDate_input">회수요청일</label>
              </th>
              <td>
                <input type="text" id="recallReqDate_input" data-bind="value: data.recallReqDate" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="receiveDate_input">고품수령일</label>
              </th>
              <td>
                <input type="text" id="receiveDate_input" data-bind="value: data.receiveDate" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="qirIssueYn_input">QIR발행여부</label>
              </th>
              <td>
                <input type="text" id="qirIssueYn_input" data-bind="value: data.qirIssueYn" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="reprYn_input">대표여부</label>
              </th>
              <td>
                <input type="text" id="reprYn_input" data-bind="value: data.reprYn" />
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
	,manageNo: { type: 'string' }
	,serviceDegree: { type: 'number' }
	,resultDegree: { type: 'number' }
	,actionType: { type: 'string' }
	,callCenterApproval: { type: 'number' }
	,repairDate: { type: 'string' }
	,roNo: { type: 'string' }
	,roConfirmDate: { type: 'string' }
	,roSpecialFeature: { type: 'string' }
	,lotNo: { type: 'string' }
	,hmcPartNo: { type: 'string' }
	,replacePartNo: { type: 'string' }
	,replacePartNm: { type: 'string' }
	,replacePartCnt: { type: 'number' }
	,usage: { type: 'string' }
	,recallType: { type: 'string' }
	,recallReqDate: { type: 'string' }
	,receiveDate: { type: 'string' }
	,qirIssueYn: { type: 'number' }
	,reprYn: { type: 'string' }

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

	{ title: 'ID', name: 'id', align: 'center' }
	,{ title: 'VINNO', name: 'vinno', align: 'center' }
	,{ title: '관리NO', name: 'manageNo', align: 'center' }
	,{ title: '서비스차수', name: 'serviceDegree', align: 'center' }
	,{ title: '결과차수', name: 'resultDegree', align: 'center' }
	,{ title: '작업유형', name: 'actionType', align: 'center' }
	,{ title: '콜센터승인여부', name: 'callCenterApproval', align: 'center' }
	,{ title: '수리일', name: 'repairDate', align: 'center' }
	,{ title: 'RONO', name: 'roNo', align: 'center' }
	,{ title: 'RO확정일', name: 'roConfirmDate', align: 'center' }
	,{ title: 'RO특기사항', name: 'roSpecialFeature', align: 'center' }
	,{ title: 'LOTNO', name: 'lotNo', align: 'center' }
	,{ title: 'HMC품번', name: 'hmcPartNo', align: 'center' }
	,{ title: '교환품번', name: 'replacePartNo', align: 'center' }
	,{ title: '교환품명', name: 'replacePartNm', align: 'center' }
	,{ title: '교환품갯수', name: 'replacePartCnt', align: 'center' }
	,{ title: '사용자재', name: 'usage', align: 'center' }
	,{ title: '회수유형', name: 'recallType', align: 'center' }
	,{ title: '회수요청일', name: 'recallReqDate', align: 'center' }
	,{ title: '고품수령일', name: 'receiveDate', align: 'center' }
	,{ title: 'QIR발행여부', name: 'qirIssueYn', align: 'center' }
	,{ title: '대표여부', name: 'reprYn', align: 'center' }


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
