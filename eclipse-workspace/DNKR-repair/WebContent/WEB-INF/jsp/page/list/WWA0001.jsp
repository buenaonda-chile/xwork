<%--
  Created by IntelliJ IDEA.
  User: kansa
  Date: 2018-12-29
  Time: 오전 1:39
  To change this template use File | Settings | File Templates.
--%>
<%-- [EN] Variable definition --%>
<%-- [JP] ???? --%>
<c:url var="codeUrl" value="/code/list.json"/>
<c:url var="readUrl" value="/claimVehicle/search"/>
<c:url var="readUrl2" value="/claimVehicle/typeSearch"/>
<c:url var="downloadUrl" value="/claimVehicle/download"/>

<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] ??ID (@ViewId???) --%>
<c:set var="screenId" value="<%= request.getAttribute(Globals.SCREEN_ID_KEY) %>"/>
<c:url var="popupUrl1" value="/popup/models/init"/>
<c:url var="popupUrl2" value="/popup/office2/init"/>

<div class="sub-con-wrap">
  <h2 class="subpage-tit">클레임현황</h2>
  <!-- 버튼들 -->
  <div class="sub-btn-group">
    <button id="btn_search" class="button" data-bind="click: search, visible: btnGrp0Visible"><i class="w_search"></i>검색</button>
    <button id="btn_down" class="button" data-bind="click: download2"><i class="w_down"></i>다운로드</button>
    <button id="btn_refresh" class="button" data-bind="click: refresh"><i class="w_x"></i>조건초기화</button>
  </div>
  <!-- /버튼들 -->
</div>
<%-- .search1 --%>
<div class="search1">
  <form id="frm_search" method="get" data-bind="events: {submit: submit}">
    <fieldset>
      <table>
        <tr>
          <td>
            <input type="hidden" id="txt_mainType" data-bind="value: criteria.mainType" />
            <input type="hidden" id="txt_statusUsr" data-bind="value: criteria.statusType" />

            <select name="date_search_option" id="date_search_option"
                    data-bind="value: criteria.dateSearchOption">
              <option value="01">접수일</option>
              <option value="02">판매일</option>
              <option value="03">생산일</option>
            </select>
          </td>
          <td colspan="3">
            <input type="text" id="searchResultDateFr"
                   data-bind="value: criteria.searchResultDateFr" class="calendar"/> - <input
              type="text" id="searchResultDateTo" data-bind="value: criteria.searchResultDateTo"
              class="calendar"/>
          </td>
          <th>차종</th>
          <td>
            <input type="text" id="model_search" data-bind="value: criteria.model"/>
          </td>
          <td>
            <button type="button" class="button" data-bind="click: popup1">
              <i class="w_nwin"></i>팝업
            </button>
          </td>
          <th>소재지</th>
          <td colspan="2">
            <kendo:dropDownList name="cmb_officeCity_search" dataTextField="codeNm"
                                data-value-primitive="true"
                                dataValueField="codeCd"
                                data-bind="value: criteria.officeCity"
                                optionLabel="전체" style="width: 120px;">
              <kendo:dataSource>
                <kendo:dataSource-transport>
                  <kendo:dataSource-transport-read url="${codeUrl}/CLRSN" type="POST"
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
          <th>정비소명</th>
          <td>
            <input type="text" id="officeNm_search" data-bind="value: criteria.officeNm"/>
          </td>
          <td>
            <button type="button" class="button" data-bind="click: popup2">
              <i class="w_nwin"></i>팝업
            </button>
          </td>
        </tr>
        <tr>
          <th style="width:80px">CS/RS</th>
          <td>
            <select name="csrs_search_option" id="csrs_search_option"
                    data-bind="value: criteria.csrsSearchOption" style="width:120px">
              <option value="" selected>전체</option>
              <option value="CS">CS</option>
              <option value="RS">RS</option>
              <option value="RS1">RS1</option>
            </select>
          </td>

          <th style="width:80px">메이커</th>
          <td>
            <kendo:dropDownList name="cmb_maker_search" dataTextField="codeNm"
                                data-value-primitive="true"
                                dataValueField="codeCd"
                                data-bind="value: criteria.maker"
                                optionLabel="전체" style="width: 120px;">
              <kendo:dataSource>
                <kendo:dataSource-transport>
                  <kendo:dataSource-transport-read url="${codeUrl}/CAMAK" type="POST"
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
          <th style="width:80px">승상용</th>
          <td>
            <kendo:dropDownList name="cmb_tireStd_search" dataTextField="codeNm"
                                data-value-primitive="true"
                                dataValueField="codeCd"
                                data-bind="value: criteria.tireStd"
                                optionLabel="전체" style="width: 120px;">
              <kendo:dataSource>
                <kendo:dataSource-transport>
                  <kendo:dataSource-transport-read url="${codeUrl}/CAUTY" type="POST"
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
          <td colspan="1"></td>
          <th style="width:80px">부품구분</th>
          <td colspan="2">
            <kendo:dropDownList name="cmb_inquiryGubun_search" dataTextField="codeNm"
                                data-value-primitive="true"
                                dataValueField="codeCd"
                                data-bind="value: criteria.inquiryGubun"
                                optionLabel="전체" style="width: 120px;">
              <kendo:dataSource>
                <kendo:dataSource-transport>
                  <kendo:dataSource-transport-read url="${codeUrl}/CAQPD" type="POST"
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
          <th>품질문제명</th>
          <td>
            <kendo:dropDownList name="cmb_qualityProblemNm_input" dataTextField="qualityProblemNm"
                                dataValueField="id"
                                data-value-primitive="true"
                                data-bind="value: criteria.qualityProblemNm"
                                optionLabel="전체"
                                autoWidth="true"  style="width: 250px;">
              <kendo:dataSource data="${qualityProblemNmItems}"/>
            </kendo:dropDownList>
          </td>
        </tr>
        <tr>
          <th>접수구분</th>
          <td>
            <kendo:dropDownList name="cmb_div_search" dataTextField="codeNm"
                                data-value-primitive="true"
                                dataValueField="codeCd"
                                data-bind="value: criteria.div"
                                optionLabel="전체" style="width: 120px;">
              <kendo:dataSource>
                <kendo:dataSource-transport>
                  <kendo:dataSource-transport-read url="${codeUrl}/C011" type="POST"
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
          <th>엔진명</th>
          <td>
            <kendo:dropDownList name="cmb_engineType_search" dataTextField="codeNm"
                                data-value-primitive="true"
                                dataValueField="codeCd"
                                data-bind="value: criteria.engineType"
                                optionLabel="전체" style="width: 120px;">
              <kendo:dataSource>
                <kendo:dataSource-transport>
                  <kendo:dataSource-transport-read url="${codeUrl}/C021" type="POST"
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
          <th>배기형식</th>
          <td>
            <kendo:dropDownList name="cmb_exhaustReg_search" dataTextField="codeNm"
                                data-value-primitive="true"
                                dataValueField="codeCd"
                                data-bind="value: criteria.exhaustReg"
                                optionLabel="전체" style="width: 120px;">
              <kendo:dataSource>
                <kendo:dataSource-transport>
                  <kendo:dataSource-transport-read url="${codeUrl}/C006" type="POST"
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
          <td colspan="1"></td>
          <th>고객품번</th>
          <td colspan="2">
            <input type="text" id="text_hmcPartNo" data-bind="value: criteria.hmcPartNo"/>
          </td>
          <th style="width:80px">VINNO</th>
          <td>
            <input type="text" id="text_vinno" data-bind="value: criteria.vinno"/>
          </td>
        </tr>
        <tr>
          <th>RO 등록</th>
          <td>
            <select name="ro_search_option" id="ro_search_option"
                    data-bind="value: criteria.roSearchOption" style="width:120px">
              <option value="" selected>전체</option>
              <option value="01">포함</option>
              <option value="02">미포함</option>
            </select>
          </td>
          <th>주행거리</th>
          <td>
            <kendo:numericTextBox name="text_mileage" id="text_mileage" format="###,###,###,###,###" min="0"  data-bind="value: criteria.mileage" style="width: 120px"/>
          </td>
          <th style="width:80px">판매국가</th>
          <td>
            <kendo:dropDownList name="cmb_saleCountry_search" dataTextField="codeNm"
                                data-value-primitive="true"
                                dataValueField="codeNm"
                                data-bind="value: criteria.saleCountry"
                                optionLabel="전체" style="width: 120px;">
              <kendo:dataSource>
                <kendo:dataSource-transport>
                  <kendo:dataSource-transport-read url="${codeUrl}/CASCO" type="POST"
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
          <td colspan="1"></td>
          <th>GQNET No.</th>
          <td colspan="2">
            <input type="text" id="text_gqnetNo" data-bind="value: criteria.gqnetNo"/>
          </td>
          <th>R/O NO</th>
          <td>
            <input type="text" id="text_roNo" data-bind="value: criteria.roNo"/>
          </td>
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
      rn: {type: 'string'}
      , receiptDate: {type: 'string'}
      , callStatus: {type: 'string'}
      , csrs: {type: 'string'}
      , officeCode: {type: 'string'}
      , officeCodeNm: {type: 'string'}
      , officeNm: {type: 'string'}
      , consultingExp: {type: 'string'}
      , vinno: {type: 'string'}
      , maker: {type: 'string'}
      , makerNm: {type: 'string'}
      , exhaustReg: {type: 'string'}
      , exhaustRegNm: {type: 'string'}
      , engineType: {type: 'string'}
      , engineTypeNm: {type: 'string'}
      , model: {type: 'string'}
      , modelNm: {type: 'string'}
      , mainCategory: {type: 'string'}
      , mainCategoryNm: {type: 'string'}
      , hmcPartNo: {type: 'string'}
      , replacePartNo: {type: 'string'}
      , replacePartNm: {type: 'string'}
      , recallReqDate: {type: 'string'}
      , stausCode: {type: 'string'}
      , status: {type: 'string'}
      , qualityProblemNm: {type: 'string'}
    }
  });

  var buttonView = kendo.observable({
    btnGrp0Visible: true,
    btnGrp1Visible: false,
    btnGrp2Visible: false,
    search: function () {
      if($("#searchResultDateFr").val() == ""){
        alert("검색기간의 시작일자는 필수입력입니다.");
        $("#searchResultDateFr").focus();
        return false;
      }
      searchView.submit();
    },
    add: function () {

      var dataItem = new codeMdl().toJSON();
      grid.prependRow(dataItem, {focus: true});
      inputView.set('rowKey', grid.getRowAt(0)['rowKey']);
      inputView.set('rowIndex', 0)
      inputView.set('data', dataItem);
      this.set('btnGrp1Visible', true);

      setPageUI('add');
    },
    remove: function () {
      grid.removeRow(inputView.get('rowKey'));
      buttonView.set('btnGrp1Visible', true);
    },
    save: function () {
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
    },
    refresh: function(){
      location.reload();
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
    popup1: function () {
      var that = this;
      _dicasPage.popupOpen({
        url: "${popupUrl1}",
        code: 'codeHelp',
        width: 1000,
        height: 700,
        params: {
          tireStd: searchView.get('criteria.tireStd'),
          maker: searchView.get('criteria.maker'),
          model: $('#model_search').val(),
          exhaustReg: searchView.get('criteria.exhaustReg'),
          engineType: searchView.get('criteria.engineType')
        },
        beforeOpen: function () {
          _dicasPage.beforeCodeHelpVal = true;
        },
        afterClose: function (info) {
          if (info.result) {
            var _data = JSON.parse(info.data);
            that.set('criteria.tireStd', _data.tireStd);
            that.set('criteria.maker', _data.maker);
            that.set('criteria.model', _data.model);
            that.set('criteria.exhaustReg', _data.exhaustReg);
            that.set('criteria.engineType', _data.engineType);
          } else {
            // that.set('criteria.tireStd', null);
            // that.set('criteria.maker', null);
            // that.set('criteria.model', null);
            // that.set('criteria.exhaustReg', null);
            // that.set('criteria.engineType', null);
          }
        }
      });
    },
    popup2: function () {
      var that = this;
      _dicasPage.popupOpen({
        url: "${popupUrl2}",
        code: 'codeHelp',
        width: 1400,
        height: 800,
        params: {
          maker: searchView.get('criteria.maker'),
          officeNm: $("#officeNm_search").val(),
          officeCity: searchView.get('criteria.officeCity'),
          partDiv: searchView.get('criteria.inquiryGubun')
        },
        beforeOpen: function () {
          _dicasPage.beforeCodeHelpVal = true;
        },
        afterClose: function (info) {
          if (info.result) {
            var _data = JSON.parse(info.data);
            that.set('criteria.maker', _data.maker);
            that.set('criteria.officeNm', _data.officeNm);
            that.set('criteria.officeCity', _data.officeCity);
            that.set('criteria.partDiv', _data.partDiv);
          } else {
            // that.set('criteria.maker', null);
            // that.set('criteria.officeNm', null);
            // that.set('criteria.officeCity', null);
            // that.set('criteria.partDiv', null);
          }
        }
      });
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
      net.readData(1, searchView.criteria.toJSON(), true);
    }
  }

  $(document).ready(function () {

    /* 옵션 selected */
    $("#date_search_option").val("01").change();
    $("#csrs_search_option").val("").prop("selected", true);
    $("#ro_search_option").val("").prop("selected", true);
    // $('#date_search_option').attr('data-bind', "01");

    $("#model_search").keypress(function(e){
      if(e.keyCode === 13){
        searchView.popup1();
      }
    });
    $("#officeNm_search").keypress(function(e){
      if(e.keyCode === 13){
        searchView.popup2();
      }
    });

    $(".calendar").datepicker();
    // 검색설정
    var loadDt = new Date();
    // $('#searchResultDateFr').val($.datepicker.formatDate('yymmdd', new Date(Date.parse(loadDt) - 15 * 1000 * 60 * 60 * 24))); // 보름전
    //$('#searchResultDateTo').val($.datepicker.formatDate('yymmdd', new Date()));

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
      changeYear: true,
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
        {title: '번호', name: 'rn', align: 'center', width: 50}
        , {title: '접수일', name: 'receiptDate', align: 'center'}
        , {title: '상태', name: 'callStatus', align: 'center'}
        , {title: 'CS/RS', name: 'csrs', align: 'center', width: 50}
        , {title: '정비소명', name: 'officeNm', align: 'center', width: 120}
        , {title: 'R/O NO', name: 'roNo', align: 'center'}
        , {title: 'VIN NO', name: 'vinno', align: 'center', width: 200}
        , {title: '메이커', name: 'makerNm', align: 'center', width: 60}
        , {title: '배기형식', name: 'exhaustRegNm', align: 'center'}
        , {title: '엔진명', name: 'engineTypeNm', align: 'center'}
        , {title: '차종', name: 'model', align: 'center'}
        , {title: '현상', name: 'mainCategoryNm', align: 'center'}
        , {title: '주원인품명', name: 'replacePartNm', align: 'center'}
        , {title: '고품요청일', name: 'recallReqDate', align: 'center'}
        , {title: '진행', name: 'status', align: 'center', width: 50}
        , {title: '주행거리', name: 'mileage', align: 'center', hidden: true}
        , {title: '고객품번', name: 'text_replacePartNo', align: 'center', hidden: true}
        , {title: '품질문제명', name: 'qualityProblemNm', align: 'center', hidden: true}
      ]
    });

    grid.use('Net', {
      el: $('#frm_search'),
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
      // For all response (regardless of success or failure)tk
      _dicasPage.maskClose();


    }).on('successResponse', function (data) {
      if (data.requestType == 'readData') {

        //var _data = JSON.parse(data);
        //console.log('시작');
        //console.log(data);
        var cnt = data.responseData.data.pagination.totalCount;
        $("#totCnt").text(cnt);
        //console.log('종료');

        inputView.set('data', null);
        inputView.set('rowKey', null);
        inputView.set('rowIndex', 0);

        console.log('성공십봉');
      } else {
      }
    }).on('failResponse', function (data) {
    }).on('errorResponse', function (data) {
    }).on('focusChange', function (eventData) {
      if (inputView.hasChanges()) {
        // var rowIndex = this.getIndexOfRow(eventData.prevRowKey);
        // var columnIndex = this.getIndexOfColumn(eventData.prevColumnName);
        // inputView.set("rowIndex", rowIndex);
        // this.focusAt(rowIndex, columnIndex);
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

      if (_dicasPage.requestParams != null) {

          _dicasPage.maskOpen();
          var mainType = _dicasPage.requestParams.inquiryGubun;
          var statusType = _dicasPage.requestParams.statusType;
          // $("#mainType").val(mainType);
          // $("#statusType").val(statusType);

          // 고품회수구분
          searchView.set('criteria.mainType', mainType);
          searchView.set('criteria.statusType', statusType);
          searchView.submit();
      }
  });

</script>