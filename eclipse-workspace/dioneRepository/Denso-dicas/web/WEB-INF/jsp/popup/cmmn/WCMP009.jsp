<%-- [EN] Variable definition --%>
<%-- [JP] ???? --%>
<c:url var="codeUrl" value="/code/list.json"/>

<c:url var="readUrl" value="/resultMasterCost/search"/>
<c:url var="createUrl" value="/resultMasterCost/create"/>
<c:url var="updateUrl" value="/resultMasterCost/update"/>
<c:url var="deleteUrl" value="/resultMasterCost/delete"/>

<c:url var="readUrl2" value="/resultMaster/search2"/>
<c:url var="updateUrl2" value="/resultMaster/update2"/>

<c:url var="readUrl3" value="/resultMasterCost/search2"/>

<c:url var="readUrl4" value="/resultMasterCost/search3"/>

<c:url var="deleteUrl2" value="/resultMaster/delete2"/>

<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] ??ID (@ViewId???) --%>
<c:set var="screenId" value="<%= request.getAttribute(Globals.SCREEN_ID_KEY) %>"/>

<div class="sub-con-wrap">
  <h2 class="subpage-tit">위탁비용등록(CRS SD 출동)</h2>
  <!-- 버튼들 -->
  <div class="sub-btn-group">
    <button id="btn_search" class="button" data-bind="click: search, visible: btnGrp0Visible"><i class="w_cancel"></i>조회</button>
    <button id="btn_save" class="button bc2" data-bind="click: save, visible: btnGrp1Visible"><i class="w_save"></i>저장</button>
    <button id="btn_remove" class="button" data-bind="click: remove, visible: btnGrp2Visible"><i class="w_minus"></i>초기화</button>
    <button id="btn_cancel" class="button" data-bind="click: cancel, visible: btnGrp1Visible"><i class="w_cancel"></i>닫기</button>
  </div>
  <!-- /버튼들 -->
</div>

<%-- .search1 --%>
<%--
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
--%>
<%--// .search1 --%>

<!-- 조사 -->
<div class="layout-B">

    <div id="form_container">

        <form id="frm_input" method="post">
        <input type="hidden" id="manageNo_input" data-bind="value: criteria.manageNo"/>

  <table class="bWrite">
    <colgroup>
      <col style="width:120px" />
      <col style="width:120px" />
      <col style="width:120px" />
      <col style="width:120px" />
      <col style="width:120px" />
      <col style="width:120px" />
      <col />
    </colgroup>

    <tr>
      <th colspan="2">구분</th>
      <th>항목</th>
      <th colspan="2">비용산출방법</th>
      <th>금액</th>
    </tr>

    <tr>
      <td rowspan="7">위탁비용</td>
      <td rowspan="3">수리비</td>
      <td>①공임</td>
      <td colspan="2">①</td>
      <td>
          <input type="text" id="labor_input" data-bind="value: data.labor" disabled/>
          <input type="hidden" id="manageNo2_input" data-bind="value: data.manageNo"/>
      </td>
    </tr>

    <tr>
      <td>②작업시간</td>
      <td>
        <div id="gridDiv2">
            <button type="button" id="btn_add2" class="button" data-bind="click: add"><i class="b_plus"></i><span class="blind">추가</span></button>
            <button type="button" id="btn_remove2" class="button" data-bind="click: remove"><i class="b_minus"></i><span class="blind">삭제</span></button>
        </div>
      </td>
      <td colspan="2">
        <div id="grid" data-grid-type="view"></div>
      </td>
    </tr>

    <tr>
      <td>③수리비</td>
      <td colspan="2">①*②</td>
      <td>
          <input type="text" id="repairAmtTot_input" data-bind="value: data.repairAmtTot" disabled/>
      </td>
    </tr>

    <tr>
      <td>부품대</td>
      <td>④제품대</td>
      <td>④</td>
      <td colspan="2">
          <input type="hidden" id="partAmtTot_input" data-bind="value: data.partAmtTot"/>
          <input type="hidden" id="partMarginCulcu_input" data-bind="value: data.partMarginCulcu"/>
          <div id="grid2" data-grid-type="view"></div>
      </td>
    </tr>

<!--
    <tr>
      <td>5.제품마진</td>
      <td colspan="2">4*rate</td>
      <td>
          0
          <input type="hidden" id="partMarginCulcu_input" data-bind="value: data.partMarginCulcu"/>
      </td>
    </tr>
-->
<!--
    <tr>
      <td rowspan="2">부대비</td>
        <td>
            6
            <table style="width:100%;height:40px;">
                <tr>
                    <%--<td><h2>현상/DTC</h2></td>--%>
                    <div id="gridDiv4">
                        <button type="button" id="btn_add4" class="button" data-bind="click: add3"><i class="b_plus"></i><span class="blind">추가</span></button>
                        <button type="button" id="btn_remove4" class="button" data-bind="click: remove3"><i class="b_minus"></i><span class="blind">삭제</span></button>
                    </div>
                </tr>
            </table>
        </td>
        <td colspan="3">
            <div id="grid4" data-grid-type="view"></div>
        </td>
    </tr>
-->

      <tr>
          <td>부대비</td>
          <td>
              <table style="width:100%;height:40px;">
                  <tr>
                      <td align="center">
                      <%--<td><h2>현상/DTC</h2></td>--%>
                      <div id="gridDiv3">
                          <button type="button" id="btn_add3" class="button" data-bind="click: add2"><i class="b_plus"></i><span class="blind">추가</span></button>
                          <button type="button" id="btn_remove3" class="button" data-bind="click: remove2"><i class="b_minus"></i><span class="blind">삭제</span></button>
                      </div>
                      </td>
                  </tr>
                  <tr><td align="center">⑦</td></tr>
              </table>
          </td>
          <td colspan="3">
              <div id="grid3"></div>
          </td>
      </tr>

    <tr>
      <td colspan="2">⑧출장비</td>
      <td>왕복거리(Km)</td>
      <td>
          <input type="text" id="dist_input" data-bind="value: data.dist"/>
      </td>
      <td>
          <input type="text" id="travelAmt_input" data-bind="value: data.travelAmt" disabled/>
      </td>
    </tr>

    <tr>
      <td colspan="2">총합</td>
      <td colspan="2">③ + ④ + ⑦ + ⑧</td>
      <td>
          <input type="text" id="totalAmt_input" data-bind="value: data.totalAmt" disabled/>
      </td>
    </tr>

  </table>

        </form>
    </div>

</div>
<!-- /조사 -->

<script type="text/javascript">

  var _dicasPage = new DicasPage('${screenId}');

  <%-- Control Definition--%>
  var grid;
  //var pagination;
  var net;

  var grid2;
  //var pagination2;
  var net2;
  <%--// Control Definition --%>

  <%-- Variable Definition --%>
  var validatable = null;
  <%--// Variable Definition --%>

  var codeMdl = kendo.data.Model.define({
      id: 'ID',
      fields: {
          vinno: { type: 'string' }
          ,mngNo: { type: 'string' }
          ,serviceSeq: { type: 'number' }
          ,costCd: { type: 'string' }
          ,costValue: { type: 'number' }
          ,div: { type: 'string' }
          ,seq: { type: 'number' }

      }
  });

  var codeMdl2 = kendo.data.Model.define({
      id: 'ID',
      fields: {
          rn: { type: 'string'}
          ,vinno: { type: 'string' }
          ,manageNo: { type: 'string' }
          ,masterId : {type: 'string'}
          ,totalAmts: { type: 'string' }
          ,hmcPartNo: { type: 'string' }
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

  var codeMdl3 = kendo.data.Model.define({
      id: 'ID',
      fields: {
          vinno: { type: 'string' }
          ,mngNo: { type: 'string' }
          ,serviceSeq: { type: 'number' }
          ,costCd: { type: 'string' }
          ,costValue: { type: 'number' }
          ,div: { type: 'string' }
          ,seq: { type: 'number' }

      }
  });

  var buttonView = kendo.observable({
    btnGrp0Visible: true,
    btnGrp01Visible: false,
    btnGrp1Visible: true,
    btnGrp2Visible: true,
    search: function() {
      searchView.submit();
    },
    save: function() {

      //승인신청후
      //private String submission;
      //private String approval;
      //private String reject;
      var submission = '${submission}';
      var approval = '${approval}';
      var reject = '${reject}';
      if (submission == '1' && approval == '0' && reject == '0') {
          alert('승인신청상태에서는 수정되지않습니다.');
          return;
      }

      inputView.save();
      detailAjax();
      detailAjax2();
    },
    cancel: function () {
      if (inputView.hasChanges()) {
          window.close();

        //if (!confirm("변경된 데이터가 있습니다. 취소 하시겠습니까?")) {
        //  return;
        //}
        //grid.enable();
        //grid.restore();
        //this.set('btnGrp1Visible', false);
        //grid.focusAt(inputView.get('rowIndex'), 0);
      }
    },
    remove : function () {
        // 비용삭제
        var submission = '${submission}';
        var approval = '${approval}';
        var reject = '${reject}';
        if (submission == '1' && approval == '0' && reject == '0') {
            alert('승인신청상태에서는 초기화되지않습니다.');
            return;
        }

        $.ajax({
            method: "POST",
            url: '${deleteUrl2}',
            data: JSON.stringify(inputView.get('data')),
            contentType: 'application/json;charset=UTF-8'
        }).done(function (data, status, jqXHR) {
            //return false;
            alert('비용내역이 초기화되었습니다.');
            window.close();
        }).fail(function (data, status, jqXHR) {
            alert("수정 중 오류가 발생하였습니다.");
        }).always(function () {
            _dicasPage.maskClose();
        });

    }
  });

  kendo.bind($("div.sub-con-wrap"), buttonView);

  var searchView = kendo.observable({
    rowKey: null,
    criteria: {
      manageNo: '${manageNo}',
    },
      rowIndex: 0,
      data: null,

    submit: function () {
      //if (inputView.hasChanges()) {
      //  if (!confirm("변경된 데이터가 있습니다. 조회 하시겠습니까?")) {
      //    return;
      //  }
      //}
      goPage('grid1', 1);
      return false;
    },
  });

  kendo.bind($("#frm_search"), searchView);

  var inputView = kendo.observable({
      data: {
          labor: null,
          manageNo: '${manageNo}',
          repairAmtTot: null,
          dist: null,
          travelAmt: null,
          totalAmt: null,
          etcAmtTot: null,
      },
    save: function () {

      if (!inputView.validate()) {
        alert('필수 항목을 입력해 주십시오.');
        return;
      }

      var message = "", isupdate = false;
      message = "변경된 데이터가 있습니다.  등록 하시겠습니까?";
      isupdate = true;

      if (inputView.hasChanges()) {
        if (!confirm(message)) {
          return;
        }
      }

      _dicasPage.maskOpen();

      inputViewAjax();
    },
    validate: function () {
      if (validatable == null) return true;
      return validatable.validate();
    },
    hasChanges: function () {
      return true;
    },
      add2: function() {

          var dataItem = new codeMdl3().toJSON();
          dataItem.mngNo = '${manageNo}';
          dataItem.vinno = '${vinno}';
          dataItem.serviceSeq = 1;
          dataItem.div = '02';
          dataItem.seq = 1;
          dataItem.costValue = null;

          //grid3.prependRow(dataItem, {focus: true});
          grid3.appendRow(dataItem, {focus: true});
          grid3.setValue(grid3.getFocusedCell().rowKey, 'costCd', incidentCostItems2[0].value);
          grid3.focusAt(grid3.getRowCount(), 2);

      },
      remove2: function() {
          //선택그리드 취득
          var gridRowkey = grid3.getFocusedCell().rowKey;
          grid3.removeRow(gridRowkey);
          calSum();
      },
      add: function() {

          var dataItem = new codeMdl3().toJSON();
          dataItem.mngNo = '${manageNo}';
          dataItem.vinno = '${vinno}';
          dataItem.serviceSeq = 1;
          dataItem.div = '03';
          dataItem.seq = 1;

          //grid.prependRow(dataItem, {focus: true});
          grid.appendRow(dataItem, {focus: true});
          grid.setValue(grid.getFocusedCell().rowKey, 'costCd', incidentCostItems[0].value);
      },
      remove: function() {
          //선택그리드 취득
          var gridRowkey = grid.getFocusedCell().rowKey
          grid.removeRow(gridRowkey);
          calSum();
      }
  });

  kendo.bind($("#form_container"), inputView);

  function detailAjax() {

      if (grid3.getModifiedRows().createdRows.length > 0) {

          for (var i=0; i<grid3.getModifiedRows().createdRows.length; i++) {
              $.ajax({
                  method: "POST",
                  url: '${createUrl}',
                  data: JSON.stringify(grid3.getModifiedRows().createdRows[i]),
                  contentType: 'application/json;charset=UTF-8'
              }).done(function (data, status, jqXHR) {
                  //
              }).fail(function (data, status, jqXHR) {
                  alert("저장 중 오류가 발생하였습니다.");
              });
          }

      }
      if (grid3.getModifiedRows().updatedRows.length > 0) {

          for (var i=0; i<grid3.getModifiedRows().updatedRows.length; i++) {

              //alert(JSON.stringify(grid3.getModifiedRows().updatedRows[i]));

              $.ajax({
                  method: "POST",
                  url: '${updateUrl}',
                  data: JSON.stringify(grid3.getModifiedRows().updatedRows[i]),
                  contentType: 'application/json;charset=UTF-8'
              }).done(function (data, status, jqXHR) {
                  //
              }).fail(function (data, status, jqXHR) {
                  alert("저장 중 오류가 발생하였습니다.");
              });
          }
      }
      if (grid3.getModifiedRows().deletedRows.length > 0) {

          for (var i=0; i<grid3.getModifiedRows().deletedRows.length; i++) {
              $.ajax({
                  method: "POST",
                  url: '${deleteUrl}',
                  data: JSON.stringify(grid3.getModifiedRows().deletedRows[i]),
                  contentType: 'application/json;charset=UTF-8'
              }).done(function (data, status, jqXHR) {
                  //
              }).fail(function (data, status, jqXHR) {
                  alert("저장 중 오류가 발생하였습니다.");
              });
          }
      }
  }

  function detailAjax2() {

      if (grid.getModifiedRows().createdRows.length > 0) {

          for (var i=0; i<grid.getModifiedRows().createdRows.length; i++) {
              $.ajax({
                  method: "POST",
                  url: '${createUrl}',
                  data: JSON.stringify(grid.getModifiedRows().createdRows[i]),
                  contentType: 'application/json;charset=UTF-8'
              }).done(function (data, status, jqXHR) {
                  //
              }).fail(function (data, status, jqXHR) {
                  alert("저장 중 오류가 발생하였습니다.");
              });
          }

      }
      if (grid.getModifiedRows().updatedRows.length > 0) {

          for (var i=0; i<grid.getModifiedRows().updatedRows.length; i++) {

              //alert(JSON.stringify(grid.getModifiedRows().updatedRows[i]));

              $.ajax({
                  method: "POST",
                  url: '${updateUrl}',
                  data: JSON.stringify(grid.getModifiedRows().updatedRows[i]),
                  contentType: 'application/json;charset=UTF-8'
              }).done(function (data, status, jqXHR) {
                  //
              }).fail(function (data, status, jqXHR) {
                  alert("저장 중 오류가 발생하였습니다.");
              });
          }
      }
      if (grid.getModifiedRows().deletedRows.length > 0) {

          for (var i=0; i<grid.getModifiedRows().deletedRows.length; i++) {

              //alert(JSON.stringify(grid.getModifiedRows().deletedRows[i]));

              $.ajax({
                  method: "POST",
                  url: '${deleteUrl}',
                  data: JSON.stringify(grid.getModifiedRows().deletedRows[i]),
                  contentType: 'application/json;charset=UTF-8'
              }).done(function (data, status, jqXHR) {
                  //
              }).fail(function (data, status, jqXHR) {
                  alert("저장 중 오류가 발생하였습니다.");
              });
          }
      }
  }

  function goPage(gridId, page) {
    if (gridId == "grid1") {

      grid.clear();
      searchView.set("rowKey", null);
      net.readData(1, searchView.criteria.toJSON(), true);

      grid2.clear();
      net2.readData(1, searchView.criteria.toJSON(), true);

      grid3.clear();
      net3.readData(1, searchView.criteria.toJSON(), true);
    }
  }

  $("#dist_input").on('change keyup paste', function () {

      var temp = $("#dist_input").val();
      if(isNaN(temp) == true) {
          temp = 0;
      }
      $("#dist_input").val(Math.floor(temp));

      calSum();
  });

  function calSum() {

      var labor = $('#labor_input').val();

      //alert(labor);
      // 그리드 1 작업시간 합계
      var time = 0.0;
      var cnt = grid.getRowCount();
      for (var i=0; i<cnt; i++) {
          var workHour = Number(grid.getRowAt(i)['costValue']);
          time = time + workHour;
      }

      // 합계 설정
      var sum = Number(labor) * Number(time);
      //alert(sum);

      inputView.set('data.repairAmtTot', sum);

      // 제품대
      // 조사결과의 자재구분이 DENSO인 경우 제품대 제외 자재구분이 모비스(현대,기아)인 경우 제품대 표시
      // 제품마진은 에어컨만 표시
      //자재구분이 DENSO가아닐때
      var matDiv = '${matDiv}';

      var partAmtTot = 0.0;
      var cnt2 = grid2.getRowCount();
      for (var i=0; i<cnt2; i++) {

          var partsCost = grid2.getRowAt(i)['partsCost'];
          if (matDiv == '2') {
              partsCost = 0.0;
              grid2.setValue(grid2.getRow(i).rowKey, 'partsCost', 0);
          }
          var margin = grid2.getRowAt(i)['margin'];
          var cnt = grid2.getRowAt(i)['replacePartCnt'];
          partAmtTot = partAmtTot + (partsCost * cnt);
      }

      //inputView.set('data.partAmt', partAmtTot);
      inputView.set('data.partAmtTot', partAmtTot);
      inputView.set('data.partMarginCulcu', 0);
      sum = sum + Number(partAmtTot);
      //alert(sum);

      var dist = $('#dist_input').val();
      var travelAmt = 0;
      if (dist === undefined || dist == 0) {
          dist = 0;
          $('#dist_input').val(0);
      } else {
          var strOfficeHRate = '${officeHRate}';
          var strOfficeKm100InRate = '${officeKm100InRate}';
          var strOfficeKm100outRate = '${officeKm100outRate}';

          var officeHRate = 0;
          var officeKm100InRate = 0;
          var officeKm100outRate = 0;
          if (strOfficeHRate != '') {
              officeHRate = Number(strOfficeHRate);
          }
          if (strOfficeKm100InRate != '') {
              officeKm100InRate = Number(strOfficeKm100InRate);
          }
          if (strOfficeKm100outRate != '') {
              officeKm100outRate = Number(strOfficeKm100outRate);
          }

          var base = labor / 100 * officeHRate;
          travelAmt = travelAmt + base;
          if (dist < 100) {
              var rate = labor / 100 * officeKm100InRate;
              travelAmt = travelAmt + (rate * dist);
          } else {
              var rate = labor / 100 * officeKm100outRate;
              travelAmt = travelAmt + (rate * dist);
          }
      }

      inputView.set('data.travelAmt', travelAmt);

      // 부대비용합
      var etcAmtTot = 0.0;
      var cnt3 = grid3.getRowCount();
      for (var i=0; i<cnt3; i++) {
          var costValue = grid3.getRowAt(i)['costValue'];
          etcAmtTot = etcAmtTot + Number(costValue);
      }

      sum = sum + Number(etcAmtTot);
      //alert(sum);
      inputView.set('data.etcAmtTot', etcAmtTot);

      sum = sum + Number(travelAmt);
      //alert(sum);

      //var taxAmt = sum / 10;
      //inputView.set('data.taxAmt', taxAmt);
      //sum = sum + taxAmt;

      //49원이하 절삭
      //50원이상 반올림
      var temp = sum / 100;
      temp = Math.round(temp);
      sum = temp * 100;

      inputView.set('data.totalAmt', sum);

  }

  function inputViewAjax() {

      //alert(JSON.stringify(inputView.get('data')));

      $.ajax({
          method: "POST",
          url: '${updateUrl2}',
          data: JSON.stringify(inputView.get('data')),
          contentType: 'application/json;charset=UTF-8'
      }).done(function (data, status, jqXHR) {
          //return false;
          calSum();
      }).fail(function (data, status, jqXHR) {
          alert("수정 중 오류가 발생하였습니다.");
      }).always(function () {
          _dicasPage.maskClose();
      });

  }

  getEditOptions2 = function(data) {

      var editoptions = [];
      for (var i = 0; i < data.length; i++) {

          var item = {
              text: data[i].itemNm,
              value: data[i].itemCd,
              value2: data[i].value
          }
          editoptions.push(item);
      }
      return editoptions;
  };

  // function setPageUI(type) {
  //     if (type == "init") {
  //         $("input[type]", "#form_container").each(function (i, v) {
  //             $(v).attr("disabled", true);
  //         });
  //
  //     } else if (type == 'view') {
  //
  //         $("input[type]", "#form_container").each(function (i, v) {
  //             $(v).attr("disabled", false);
  //         });
  //
  //     }
  // }

  var incidentCostData, incidentCostItems;
  var incidentCostData2, incidentCostItems2;

  $(document).ready(function () {

    validatable = $("#form_container").kendoValidator({validateOnBlur: false})
    .data("kendoValidator");

    $("#manageNo_input").val('${manageNo}');
    //$("#manageNo2_input").val('${manageNo}');
    //$("#labor_input").val('${officeLabor}');
    //$("#dist_input").val('${dist}');
    inputView.set('data.manageNo', '${manageNo}');
    inputView.set('data.labor', '${officeLabor}');
    inputView.set('data.dist', '${dist}');

    incidentCostData = new kendo.data.DataSource({ data: ${incidentCostItems}}),
        incidentCostItems = getEditOptions2(incidentCostData.options.data);

    incidentCostData2 = new kendo.data.DataSource({ data: ${incidentCostItems2}}),
        incidentCostItems2 = getEditOptions2(incidentCostData2.options.data);

    tui.Grid.applyTheme('clean');
    grid = new tui.Grid({
      el: $('#grid'),
      scrollX: false,
      scrollY: true,
      rowHeight: 23,
        header: {
            height: 23
        },
      // keyColumnName: 'codeKey',
      useClientSort: false,
      showDummyRows: true,
      minBodyHeight: 23,
      bodyHeight: 100,
      pagination: false,
      selectionUnit: 'CELL',
      editingEvent: true,
      usageStatistics: false,
        treeColumnOptions: {
            name: 'ID',
            useCascadingCheckbox: false
        },
      columns: [

          { title: '구분', name: 'costCd', align: 'center',  editOptions: { type: 'select', listItems: incidentCostItems, useViewMode: false }
            ,onAfterChange: function(ev) {

                  for (var i=0; i<incidentCostItems.length; i++) {
                      var data = incidentCostItems[i];
                      if (ev.value == data.value) {
                          //alert(data.value2);
                          var temp = data.value2;
                          if (temp == null || temp == '') {
                              temp = 0;
                          }
                          grid.setValue(ev.rowKey, "costValue", temp);
                          break;
                      }
                  }
                  calSum();
             }
          }
          ,{ title: '시간', name: 'costValue', align: 'center',  editOptions: { type: 'text', maxLength: 20, useViewMode: true } }
          ,{ title: 'VINNO', name: 'vinno', align: 'center', hidden: 'false' }
          ,{ title: '관리번호', name: 'mngNo', align: 'center', hidden: 'false' }
          ,{ title: '차수', name: 'serviceSeq', align: 'center', hidden: 'false' }
          ,{ title: '구분', name: 'div', align: 'center', hidden: 'false' }
          ,{ title: '순서', name: 'seq', align: 'center', hidden: 'false' }
          ,{ title: 'id', name: 'id', align: 'center', hidden: 'false' }

      ],
        summary: {
            height: 20,
            position: 'bottom', // or 'top'
            columnContent: {
                costCd : {
                    template: function(valueMap) {
                        return '합계';
                    }
                },
                costValue: {
                    template: function(valueMap) {
                        return valueMap.sum;
                    }
                }
            }
        }
    });

    grid.use('Net', {
      el: $('#frm_input'),
      initialRequest: false,
      readDataMethod: 'GET',
      perPage: 25,
      enableAjaxHistory: false,
      api: {
        'readData': '${readUrl3}',
        // 'downloadExcel': './api/download/excel',
        // 'downloadExcelAll': './api/download/excelAll'
      }
    });

    // Bind event handlers
    grid.on('beforeRequest', function (data) {
      // For all requests
      //_dicasPage.maskOpen();
    }).on('response', function (data) {
      // For all response (regardless of success or failure)
      //_dicasPage.maskClose();
    }).on('successResponse', function (data) {

        var _count = data.responseData.data.contents.length;
        if (_count > 0) {
            var checkInterval = setInterval(function() {
                if (grid.getRowCount() > 0) {
                    clearInterval(checkInterval);
                    calSum();
                }
            }, 100);
        } else {
            calSum();
        }

    }).on('failResponse', function (data) {
    }).on('errorResponse', function (data) {
    }).on('focusChange', function (eventData) {
    });

    net = grid.getAddOn('Net');
    //pagination = grid.getPagination();
    //pagination.on('afterMove', function (eventData) {
    //  buttonView.set('btnGrp1Visible', false);
    //  if (grid.getRowCount() > 0)
    //    grid.focusAt(0, 0);
    //});

      grid2 = new tui.Grid({
          el: $('#grid2'),
          scrollX: false,
          scrollY: true,
          rowHeight: 23,
          header: {
              height: 23
          },
          // keyColumnName: 'codeKey',
          useClientSort: false,
          showDummyRows: true,
          minBodyHeight: 23,
          bodyHeight: 100,
          pagination: false,
          selectionUnit: 'CELL',
          editingEvent: true,
          usageStatistics: false,
          columns: [

              { title: '구분', name: 'replacePartNm', align: 'center' }
              ,{ title: '금액', name: 'partsCost', align: 'center' }
              ,{ title: '시간', name: 'workHour', align: 'center', hidden : 'false' }
              ,{ title: '수량', name: 'replacePartCnt', align: 'center', hidden : 'false' }

          ],
          summary: {
              height: 20,
              position: 'bottom', // or 'top'
              columnContent: {
                  replacePartNm : {
                      template: function(valueMap) {
                          return '합계';
                      }
                  },
                  partsCost: {
                      template: function(valueMap) {
                          return valueMap.sum;
                      }
                  }
              }
          }
      });

      grid2.use('Net', {
          el: $('#frm_input'),
          initialRequest: false,
          readDataMethod: 'GET',
          perPage: 25,
          enableAjaxHistory: false,
          api: {
              'readData': '${readUrl2}',
              // 'downloadExcel': './api/download/excel',
              // 'downloadExcelAll': './api/download/excelAll'
          }
      });

      // Bind event handlers
      grid2.on('beforeRequest', function (data) {
          // For all requests
          //_dicasPage.maskOpen();
      }).on('response', function (data) {
          // For all response (regardless of success or failure)
          //_dicasPage.maskClose();
          var _count = data.responseData.data.contents.length;
          if (_count > 0) {
              var checkInterval = setInterval(function() {
                  if (grid2.getRowCount() > 0) {
                      clearInterval(checkInterval);
                      calSum();
                  }
              }, 100);
          } else {
              calSum();
          }

      }).on('successResponse', function (data) {
      }).on('failResponse', function (data) {
      }).on('errorResponse', function (data) {
      }).on('focusChange', function (eventData) {
      });

      net2 = grid2.getAddOn('Net');
      //pagination3 = grid3.getPagination();
      //pagination3.on('afterMove', function (eventData) {
      //    if (grid3.getRowCount() > 0) {
      //        grid3.focusAt(0, 0);
      //    }
      //});

      grid3 = new tui.Grid({
          el: $('#grid3'),
          scrollX: false,
          scrollY: true,
          rowHeight: 23,
          header: {
              height: 23
          },
          // keyColumnName: 'codeKey',
          useClientSort: false,
          showDummyRows: true,
          minBodyHeight: 23,
          bodyHeight: 100,
          pagination: false,
          selectionUnit: 'CELL',
          editingEvent: true,
          usageStatistics: false,
          treeColumnOptions: {
              name: 'ID',
              useCascadingCheckbox: false
          },
          columns: [

              { title: '구분', name: 'costCd', align: 'center',  editOptions: { type: 'select', listItems: incidentCostItems2, useViewMode: false }
              }
              ,{ title: '금액', name: 'costValue', align: 'center',  editOptions: { type: 'text', maxLength: 20, useViewMode: false }
                  ,onAfterChange: function(ev) {
                      var temp = ev.value;
                      if(isNaN(temp) == true) {
                          temp = 0;
                      }
                      grid3.setValue(ev.rowKey, "costValue", Math.floor(temp));
                      calSum();
                  }
              }
              ,{ title: 'VINNO', name: 'vinno', align: 'center', hidden: 'false' }
              ,{ title: '관리번호', name: 'mngNo', align: 'center', hidden: 'false' }
              ,{ title: '차수', name: 'serviceSeq', align: 'center', hidden: 'false' }
              ,{ title: '구분', name: 'div', align: 'center', hidden: 'false' }
              ,{ title: '순서', name: 'seq', align: 'center', hidden: 'false' }
              ,{ title: 'id', name: 'id', align: 'center', hidden: 'false' }

          ],
          summary: {
              height: 20,
              position: 'bottom', // or 'top'
              columnContent: {
                  costCd : {
                      template: function(valueMap) {
                          return '합계';
                      }
                  },
                  costValue: {
                      template: function(valueMap) {
                          return valueMap.sum;
                      }
                  }
              }
          }
      });

      grid3.use('Net', {
          el: $('#frm_input'),
          initialRequest: false,
          readDataMethod: 'GET',
          perPage: 25,
          enableAjaxHistory: false,
          api: {
              'readData': '${readUrl4}',
              // 'downloadExcel': './api/download/excel',
              // 'downloadExcelAll': './api/download/excelAll'
          }
      });

      // Bind event handlers
      grid3.on('beforeRequest', function (data) {
          // For all requests
          //_dicasPage.maskOpen();
      }).on('response', function (data) {
          // For all response (regardless of success or failure)
          //_dicasPage.maskClose();
      }).on('successResponse', function (data) {

          var _count = data.responseData.data.contents.length;
          if (_count > 0) {
              var checkInterval = setInterval(function() {
                  if (grid3.getRowCount() > 0) {
                      clearInterval(checkInterval);
                      calSum();
                  }
              }, 100);
          } else {
              calSum();
          }

      }).on('failResponse', function (data) {
      }).on('errorResponse', function (data) {
      }).on('focusChange', function (eventData) {
      });

      net3 = grid3.getAddOn('Net');

      // 그리드 크기 맞추기 위해 강제 resize 호출
      $(window).bind('resize', function () {
      }).trigger('resize');

      buttonView.search();

      // setPageUI("init");
  });

</script>
