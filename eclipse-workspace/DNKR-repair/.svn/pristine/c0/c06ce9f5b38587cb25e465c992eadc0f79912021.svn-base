<%-- [EN] Variable definition --%>
<%-- [JP] ???? --%>
<c:url var="codeUrl" value="/code/list.json"/>

<c:url var="readUrl" value="/resultMaster/search5"/>
<c:url var="downloadUrl" value="/resultMaster/download"/>
<c:url var="createUrl" value="/resultMaster/create"/>
<c:url var="updateUrl" value="/resultMaster/update"/>
<c:url var="deleteUrl" value="/resultMaster/delete"/>

<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] ??ID (@ViewId???) --%>
<c:set var="screenId" value="<%= request.getAttribute(Globals.SCREEN_ID_KEY) %>"/>

<div class="sub-con-wrap">
  <h2 class="subpage-tit">비용처리상황</h2>
  <!-- 버튼들 -->
  <div class="sub-btn-group">
    <button id="btn_search" class="button" data-bind="click: search, visible: btnGrp0Visible"><i class="w_search"></i>검색</button>
    <button id="btn_down" class="button" data-bind="click: download2"><i class="w_down"></i>다운로드</button>
    <%--<button id="btn_add" class="button bc1" data-bind="click: add, visible: btnGrp0Visible"><i class="w_add"></i>추가</button>--%>
    <%--<button id="btn_save" class="button bc2" data-bind="click: save, visible: btnGrp1Visible"><i class="w_save"></i>저장</button>--%>
    <%--<button id="btn_cancel" class="button" data-bind="click: cancel, visible: btnGrp1Visible"><i class="w_cancel"></i>취소</button>--%>
    <%--<button id="btn_remove" class="button" data-bind="click: remove, visible: btnGrp2Visible"><i class="w_minus"></i>삭제</button>--%>
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
          <col style="width:100px"/>
          <col style="width:80px"/>
          <col style="width:280px"/>
          <col style="width:80px"/>
          <col style="width:280px"/>
          <col style="width:70px"/>
          <col style="width:100px"/>
          <col style="width:70px"/>
          <col/>
        </colgroup>
        <tr>
          <%--<th>결과등록일</th>--%>
          <%--<td>--%>
            <%--<input type="text" id="searchResultDateFr" data-bind="value: criteria.searchResultDateFr"  class="calendar" /> - <input type="text" id="searchResultDateTo"  data-bind="value: criteria.searchResultDateTo" class="calendar" />--%>
          <%--</td>--%>
          <th>결재상태</th>
          <td>
              <select id="approvalStatus_search" data-bind="value: criteria.approvalStatus" >
                  <option value='' >전체</option>
                  <option value='SUBMISSION' >제출</option>
                  <option value='APPROVAL' >승인</option>
                  <option value='REJECT' >반려</option>
              </select>
          </td>
          <th>접수일</th>
          <td>
            <input type="text" id="searchReceiptDateFr" data-bind="value: criteria.searchReceiptDateFr"  class="calendar" /> - <input type="text" id="searchReceiptDateTo"  data-bind="value: criteria.searchReceiptDateTo" class="calendar" />
          </td>
          <th>조사일</th>
          <td>
            <input type="text" id="searchResearchDateFr" data-bind="value: criteria.searchResearchDateFr"  class="calendar" /> - <input type="text" id="searchResearchDateTo"  data-bind="value: criteria.searchResearchDateTo" class="calendar" />
          </td>
          <th>SD명</th>
          <td><input type="text" id="sdNm_search" data-bind="value: criteria.sdNm" style="width: 200px" /></td>
          <td>&nbsp;</td>
        </tr>
      </table>
    </fieldset>
  </form>
</div>
<%--// .search1 --%>
<%--// count--%>
<div>총건수 : <label id="totCnt"></label></div>
<%--// count--%>
<%-- .layout-LW --%>
<div class="layout-LW">
  <div class="left" style="width:100%;">
    <div style="margin-bottom:10px;"></div>
    <div id="grid" data-grid-type="view"></div>
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
       rn: { type: 'string'}
      ,vinno: { type: 'string' }
      ,manageNo: { type: 'string' }
      ,masterId : {type: 'string'}
      ,totalAmts: { type: 'string' }
      ,hmcPartNo: { type: 'string' }
      ,replacePartNm: { type: 'string' }
      ,approvalNo: { type: 'string' }
      ,receiptDate: { type: 'string' }
      ,researchDate: { type: 'string' }
      ,resultDate: { type: 'string' }
      ,officeNm: { type: 'string' }
      ,sdNm: { type: 'string' }
      ,inquiry: { type: 'string' }
      ,inquiryGubun: { type: 'string' }
      ,exchangeNm: { type: 'string' }
      ,approvalStatus: { type: 'string' }
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
    },
    download2: function() {
      net.download('excelAll');
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

      $( ".calendar" ).datepicker();

      // 검색설정
      var loadDt = new Date();
      // $('#searchResultDateFr').val($.datepicker.formatDate('yymmdd', new Date(Date.parse(loadDt) - 15 * 1000 * 60 * 60 * 24))); // 보름전
      // $('#searchResultDateTo').val($.datepicker.formatDate('yymmdd', new Date()));

      /* 달력보기 */
      $.datepicker.setDefaults({
          prevText: '이전 달',
          nextText: '다음 달',
          monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
          monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
          dayNames: ['일', '월', '화', '수', '목', '금', '토'],
          dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
          dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
          showMonthAfterYear: true,
          changeMonth: true,
          changeYear : true,
          dateFormat: "yymmdd",
          yearSuffix: '년'
      });

    validatable = $("#form_container").kendoValidator({validateOnBlur: false})
    .data("kendoValidator");

    tui.Grid.applyTheme('clean');
    grid = new tui.Grid({
      el: $('#grid'),
      scrollX: false,
      scrollY: true,
      rowHeight: 30,
      useClientSort: false,
      showDummyRows: true,
      minBodyHeight: 30,
      bodyHeight: 600,
      pagination: true,
      selectionUnit: 'ROW',
      editingEvent: false,
      usageStatistics: false,
        treeColumnOptions: {
            name: 'ID',
            useCascadingCheckbox: false
        },

      columns: [
           { title: '번호', name: 'rn', align: 'center', width:50 }
          ,{ title: '클레임번호', name: 'manageNo', align: 'center' }
          ,{ title: '접수일', name: 'receiptDate', align: 'center' }
          ,{ title: '조사일', name: 'researchDate', align: 'center' }
          ,{ title: '결과등록일', name: 'resultDate', align: 'center', hidden: 'false'  }
          ,{ title: '정비소명', name: 'officeNm', align: 'center' }
          ,{ title: 'SD명', name: 'sdNm', align: 'center' }
          ,{ title: '교환품명', name: 'exchangeNm', align: 'center', hidden:'false'}
          ,{ title: '교환품번', name: 'hmcPartNo', align: 'center', hidden:'false' }
          ,{ title: '교환품명', name: 'replacePartNm', align: 'center' }
          ,{ title: '총비용(원)', name: 'totalAmts', align: 'right' }
          ,{ title: '결재상태', name: 'approvalStatus', align: 'center' }
          ,{ title: '관리번호', name: 'approvalNo', align: 'center', hidden:'false'  }
          ,{ title: 'MASTER_ID', name: 'masterId', align: 'center', hidden:'false'  }
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

        var cnt = data.responseData.data.pagination.totalCount;
        $("#totCnt").text(cnt);

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
