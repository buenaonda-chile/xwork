<%-- [EN] Variable definition --%>
<%-- [JP] ???? --%>
<c:url var="codeUrl" value="/code/list.json"/>

<c:url var="readUrl" value="/vehicleView/search"/>
<c:url var="createUrl" value="/vehicleView/create"/>
<c:url var="updateUrl" value="/vehicleView/update"/>
<c:url var="deleteUrl" value="/vehicleView/delete"/>

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
              <th scope="row"><label for="id_input">null</label>
              </th>
              <td>
                <input type="text" id="id_input" data-bind="value: data.id" disabled='disabled' /> 
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="manageNo_input">null</label>
              </th>
              <td>
                <input type="text" id="manageNo_input" data-bind="value: data.manageNo" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="masterId_input">null</label>
              </th>
              <td>
                <input type="text" id="masterId_input" data-bind="value: data.masterId" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="tireStd_input">null</label>
              </th>
              <td>
                <input type="text" id="tireStd_input" data-bind="value: data.tireStd" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="maker_input">null</label>
              </th>
              <td>
                <input type="text" id="maker_input" data-bind="value: data.maker" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="vinno_input">null</label>
              </th>
              <td>
                <input type="text" id="vinno_input" data-bind="value: data.vinno" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="carNo_input">null</label>
              </th>
              <td>
                <input type="text" id="carNo_input" data-bind="value: data.carNo" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="exhaustReg_input">null</label>
              </th>
              <td>
                <input type="text" id="exhaustReg_input" data-bind="value: data.exhaustReg" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="engineType_input">null</label>
              </th>
              <td>
                <input type="text" id="engineType_input" data-bind="value: data.engineType" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="model_input">null</label>
              </th>
              <td>
                <input type="text" id="model_input" data-bind="value: data.model" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="prodDate_input">null</label>
              </th>
              <td>
                <input type="text" id="prodDate_input" data-bind="value: data.prodDate" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="saleDate_input">null</label>
              </th>
              <td>
                <input type="text" id="saleDate_input" data-bind="value: data.saleDate" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="registYn_input">null</label>
              </th>
              <td>
                <input type="text" id="registYn_input" data-bind="value: data.registYn" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="remark_input">null</label>
              </th>
              <td>
                <input type="text" id="remark_input" data-bind="value: data.remark" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="saleCountry_input">null</label>
              </th>
              <td>
                <input type="text" id="saleCountry_input" data-bind="value: data.saleCountry" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="payment_input">null</label>
              </th>
              <td>
                <input type="text" id="payment_input" data-bind="value: data.payment" />
              </td>
            </tr>
		            <tr>
              <th scope="row">
                <label for="cmb_useYn_input">null</label>
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
              <th scope="row"><label for="enginTranYn_input">null</label>
              </th>
              <td>
                <input type="text" id="enginTranYn_input" data-bind="value: data.enginTranYn" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="carTranYn_input">null</label>
              </th>
              <td>
                <input type="text" id="carTranYn_input" data-bind="value: data.carTranYn" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="modelId_input">null</label>
              </th>
              <td>
                <input type="text" id="modelId_input" data-bind="value: data.modelId" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="receiptDate_input">null</label>
              </th>
              <td>
                <input type="text" id="receiptDate_input" data-bind="value: data.receiptDate" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="condition_input">null</label>
              </th>
              <td>
                <input type="text" id="condition_input" data-bind="value: data.condition" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="consultingExp_input">null</label>
              </th>
              <td>
                <input type="text" id="consultingExp_input" data-bind="value: data.consultingExp" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="div_input">null</label>
              </th>
              <td>
                <input type="text" id="div_input" data-bind="value: data.div" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="prodBase_input">null</label>
              </th>
              <td>
                <input type="text" id="prodBase_input" data-bind="value: data.prodBase" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="inquiryGubun_input">null</label>
              </th>
              <td>
                <input type="text" id="inquiryGubun_input" data-bind="value: data.inquiryGubun" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="cdsdResearchYn_input">null</label>
              </th>
              <td>
                <input type="text" id="cdsdResearchYn_input" data-bind="value: data.cdsdResearchYn" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="replacePartNo_input">null</label>
              </th>
              <td>
                <input type="text" id="replacePartNo_input" data-bind="value: data.replacePartNo" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="replacePartNm_input">null</label>
              </th>
              <td>
                <input type="text" id="replacePartNm_input" data-bind="value: data.replacePartNm" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="qualityProblemNm_input">null</label>
              </th>
              <td>
                <input type="text" id="qualityProblemNm_input" data-bind="value: data.qualityProblemNm" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="roNo_input">null</label>
              </th>
              <td>
                <input type="text" id="roNo_input" data-bind="value: data.roNo" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="gqnetNo_input">null</label>
              </th>
              <td>
                <input type="text" id="gqnetNo_input" data-bind="value: data.gqnetNo" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="receiveDate_input">null</label>
              </th>
              <td>
                <input type="text" id="receiveDate_input" data-bind="value: data.receiveDate" />
              </td>
            </tr>
		
            <tr>
              <th scope="row"><label for="resultDegree_input">null</label>
              </th>
              <td>
                <input type="text" id="resultDegree_input" data-bind="value: data.resultDegree" />
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
	manageNo: { type: 'string' }
	,masterId: { type: 'string' }
	,tireStd: { type: 'string' }
	,maker: { type: 'string' }
	,vinno: { type: 'string' }
	,carNo: { type: 'string' }
	,exhaustReg: { type: 'string' }
	,engineType: { type: 'string' }
	,model: { type: 'string' }
	,prodDate: { type: 'string' }
	,saleDate: { type: 'string' }
	,registYn: { type: 'string' }
	,remark: { type: 'string' }
	,saleCountry: { type: 'string' }
	,payment: { type: 'string' }
	,useYn: { type: 'string' }
	,enginTranYn: { type: 'string' }
	,carTranYn: { type: 'string' }
	,modelId: { type: 'number' }
	,receiptDate: { type: 'string' }
	,condition: { type: 'string' }
	,consultingExp: { type: 'string' }
	,div: { type: 'string' }
	,prodBase: { type: 'string' }
	,inquiryGubun: { type: 'string' }
	,cdsdResearchYn: { type: 'number' }
	,replacePartNo: { type: 'string' }
	,replacePartNm: { type: 'string' }
	,qualityProblemNm: { type: 'string' }
	,roNo: { type: 'string' }
	,gqnetNo: { type: 'string' }
	,receiveDate: { type: 'string' }
	,resultDegree: { type: 'number' }

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

																	cmbuseYnInput = $("#cmb_useYn_input", "#frm_input").data("kendoDropDownList");var useYnData = cmbuseYnInput.dataSource.data(), useYnItems = _dicasPage.getEditOptions(useYnData);
																	

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

	{ title: 'null', name: 'id', align: 'center' }
	,{ title: 'null', name: 'manageNo', align: 'center' }
	,{ title: 'null', name: 'masterId', align: 'center' }
	,{ title: 'null', name: 'tireStd', align: 'center' }
	,{ title: 'null', name: 'maker', align: 'center' }
	,{ title: 'null', name: 'vinno', align: 'center' }
	,{ title: 'null', name: 'carNo', align: 'center' }
	,{ title: 'null', name: 'exhaustReg', align: 'center' }
	,{ title: 'null', name: 'engineType', align: 'center' }
	,{ title: 'null', name: 'model', align: 'center' }
	,{ title: 'null', name: 'prodDate', align: 'center' }
	,{ title: 'null', name: 'saleDate', align: 'center' }
	,{ title: 'null', name: 'registYn', align: 'center' }
	,{ title: 'null', name: 'remark', align: 'center' }
	,{ title: 'null', name: 'saleCountry', align: 'center' }
	,{ title: 'null', name: 'payment', align: 'center' }
	,{
          title: 'null',
          name: 'useYn',
          align: 'center',
          editOptions: {
            type: 'select',
            listItems: useYnItems,
            useViewMode: true
          }
        }
	,{ title: 'null', name: 'enginTranYn', align: 'center' }
	,{ title: 'null', name: 'carTranYn', align: 'center' }
	,{ title: 'null', name: 'modelId', align: 'center' }
	,{ title: 'null', name: 'receiptDate', align: 'center' }
	,{ title: 'null', name: 'condition', align: 'center' }
	,{ title: 'null', name: 'consultingExp', align: 'center' }
	,{ title: 'null', name: 'div', align: 'center' }
	,{ title: 'null', name: 'prodBase', align: 'center' }
	,{ title: 'null', name: 'inquiryGubun', align: 'center' }
	,{ title: 'null', name: 'cdsdResearchYn', align: 'center' }
	,{ title: 'null', name: 'replacePartNo', align: 'center' }
	,{ title: 'null', name: 'replacePartNm', align: 'center' }
	,{ title: 'null', name: 'qualityProblemNm', align: 'center' }
	,{ title: 'null', name: 'roNo', align: 'center' }
	,{ title: 'null', name: 'gqnetNo', align: 'center' }
	,{ title: 'null', name: 'receiveDate', align: 'center' }
	,{ title: 'null', name: 'resultDegree', align: 'center' }


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
