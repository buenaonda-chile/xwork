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
<c:url var="readUrl" value="/totalAlnalysis/search"/>
<c:url var="readUrl2" value="/totalAlnalysis/search2"/>
<c:url var="readUrl3" value="/totalAlnalysis/search3"/>
<c:url var="readUrl4" value="/totalAlnalysis/search4"/>
<c:url var="readUrl5" value="/totalAlnalysis/search5"/>
<c:url var="readUrl6" value="/totalAlnalysis/search6"/>

<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] ??ID (@ViewId???) --%>
<c:set var="screenId" value="<%= request.getAttribute(Globals.SCREEN_ID_KEY) %>"/>
<c:url var="popupUrl1" value="/popup/models/init"/>
<c:url var="popupUrl2" value="/popup/partNumber/init"/>

<div class="sub-con-wrap">
  <h2 class="subpage-tit">클레임종합분석</h2>
  <!-- 버튼들 -->
  <div class="sub-btn-group">
    <button id="btn_search" class="button" data-bind="click: search, visible: btnGrp0Visible"><i
        class="w_search"></i>검색
    </button>
  </div>
  <!-- /버튼들 -->
</div>
<%-- .search1 --%>
<div class="search1">
  <form id="frm_search" method="get">
    <fieldset>
      <table>

        <tr>
          <td>
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
          <th style="width:80px">부품구분</th>
          <td>
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
          <th>차종</th>
          <td>
            <div class="search_input" style="width:300px;">
              <input type="text" id="model_search" data-bind="value: criteria.model" required/>
              <button type="button" data-bind="click: popup1"><i class="ic_search1"></i><span
                      class="blind">검색</span></button>
            </div>
            <%--<button type="button" class="button" data-bind="click: popup1"><i class="w_nwin"></i>팝업</button>--%>
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
                    return JSON.stringify(options);r
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
          <th>고객품번</th>
          <td>
            <div class="search_input" style="width:300px;">
            <input type="text" id="hmcPartNo_search" data-bind="value: criteria.hmcPartNo" />
            <button type="button" data-bind="click: popup2"><i class="ic_search1"></i><span
                    class="blind">검색</span></button>
            </div>
            <%--<button type="button" class="button" data-bind="click: popup2"><i class="w_nwin"></i>팝업</button>--%>
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
          <th>품질문제명</th>
          <td>
              <kendo:dropDownList name="cmb_qualityProblemNm_input" dataTextField="qualityProblemNm"
                                  dataValueField="id"
                                  data-value-primitive="true"
                                  data-bind="value: criteria.qualityProblemNm"
                                  optionLabel="전체" style="width: 300px;">
                  <kendo:dataSource data="${qualityProblemNmItems}"/>
              </kendo:dropDownList>
            <%--<input type="text" id="text_qualityProblemNm"--%>
                   <%--data-bind="value: criteria.qualityProblemNm"/>--%>
          </td>
        </tr>
      </table>
    </fieldset>
  </form>
</div>
<%--// .search1 --%>
<%-- .layout-LW --%>
<div class="layout-LW">
  <div class="left" style="width:100%;">

    <div class="demo-section k-content wide">
      <div id="chart" style="height: 250px"></div>
    </div>

    <div style="margin-bottom:10px;"></div>
    <div id="grid" data-grid-type="view"></div>

    <table style="width:100%;margin-top:10px;">
      <tr>
        <td style="width:24%;">
          <h2>현상별 상담현황</h2>
          <div id="grid2" class="lc4item lc4c1" data-grid-type="view"></div>
        </td>
        <td style="width:24%;padding-left:1.333%;">
          <h2>주행거리별 현황</h2>
          <div id="grid5" class="lc4item lc4c2" data-grid-type="view"></div>
        </td>
        <td style="width:24%;padding-left:1.333%;">
          <h2>차종별 현황</h2>
          <div id="grid3" class="lc4item lc4c3" data-grid-type="view"></div>
        </td>
        <td style="width:24%;padding-left:1.333%;">
          <h2>부품별 현황</h2>
          <div id="grid4" class="lc4item lc4c4" data-grid-type="view" onclick="return false;"></div>
        </td>
      </tr>
    </table>

  </div>
</div>
<%--// .layout-LW --%>


<script type="text/javascript">
  var _dicasPage = new DicasPage('${screenId}');

  <%-- Control Definition--%>
  var grid;
  var pagination;
  var net;

  var grid2;
  var net2;

  var grid3;
  var net3;

  var grid4;
  var net4;

  var grid5;
  var net5;
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
        if($("#searchResultDateFr").val()=="" || $("#searchResultDateTo").val()==""){
            alert("검색 시작/종료일은 필수입력입니다.");
            return false;
        }
      searchView.submit();
    },
    cancel: function () {

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
          engineType: searchView.get('criteria.engineType'),
          model: $('#model_search').val()
          // model: searchView.get('criteria.model')
        },
        beforeOpen: function () {
          _dicasPage.beforeCodeHelpVal = true;
        },
        afterClose: function (info) {
          if (info.result) {
            var _data = JSON.parse(info.data);
            that.set('criteria.model', _data.model);
          } else {
            that.set('criteria.model', null);
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
          partDiv: searchView.get('criteria.inquiryGubun'),
          engineType: searchView.get('criteria.engineType'),
          hmc: $('#hmcPartNo_search').val()
          // hmc: searchView.get('criteria.hmcPartNo')
        },
        beforeOpen: function () {
          _dicasPage.beforeCodeHelpVal = true;
        },
        afterClose: function (info) {
          if (info.result) {
            var _data = JSON.parse(info.data);
            that.set('criteria.hmcPartNo', _data.hmc)
          } else {
            that.set('criteria.hmcPartNo', null)
          }
        }
      });
    }
  });
  kendo.bind($("#frm_search"), searchView);

  function goPage(gridId, page) {
    if (gridId == "grid1") {
      searchView.set("rowKey", null);
      net.readData(1, searchView.criteria.toJSON(), true);
      net2.readData(1, searchView.criteria.toJSON(), true);
      net3.readData(1, searchView.criteria.toJSON(), true);
      net4.readData(1, searchView.criteria.toJSON(), true);
      net5.readData(1, searchView.criteria.toJSON(), true);

        $.ajax({

            url: "${readUrl6}",
            data : searchView.criteria.toJSON(),

            dataType: "json", // "jsonp" is required for cross-domain requests; use "json" for same-domain requests
            success: function(result) {
                // notify the data source that the request succeeded
                //alert(JSON.stringify(result));
                //alert(JSON.stringify(result.data));

                var dataSource = new kendo.data.DataSource({
                    data: result.data
                });
                createChart(dataSource);

                /*var chart = $("#chart").data("kendoChart");
                var dataSource = new kendo.data.DataSource( {
                    data : JSON.stringify(result.data)
                    ,sort: {
                        field: "baseDate",
                        dir: "asc"
                    }
                });
                chart.setDataSource(dataSource);
                chart.redraw();
                chart.refresh();*/
            },
            error: function(result) {
                // notify the data source that the request failed
                alert("데이터 조회중 오류가 발생했습니다.");
            }
        });
    }
  }

  function createChart(data) {
    var seriesData = data.options.data;
    console.log(seriesData)
    $("#chart").kendoChart({
        series: [{
          name: "생산수",
          type: "column",
          data: seriesData,
          field: "saleCnt",
          categoryField: "baseDate",
          tooltip: {
            visible: true
          }
        }
        ,{
            name: "판매수",
            type: "column",
            data: seriesData,
            field: "prodCnt",
            categoryField: "baseDate",
            tooltip: {
                visible: true
            }
        }
        ,{
          name: "수리수",
          type: "column",
          data: seriesData,
          field: "repairCnt",
          categoryField: "baseDate",
          tooltip: {
            visible: true
          }
        }],
        categoryAxis: {
            categoryField: "baseDate"
        }
    });
  }

  $(document).ready(function () {
      var today = new Date();
      var dd = today.getDate();
      var mm = today.getMonth()+1; //January is 0!
      var yyyy = today.getFullYear();
      var yyyy_1 = yyyy-1;
      if(dd<10) { dd='0'+dd }
      if(mm<10) { mm='0'+mm }

      today = yyyy+""+mm+''+dd;
      btoday = yyyy_1+""+mm+''+dd;
    //createChart();
    //$("#searchResultDateFr").val(btoday); //검색일자 시작 (현재일 -1년)
    //$("#searchResultDateTo").val(today);   //검색일자 종료 (현재일자)
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

    $("#hmcPartNo_search").keypress(function(e){
      if(e.keyCode === 13){
        searchView.popup2();
      }
    });


    $(".calendar").datepicker();
    // 검색설정
    var loadDt = new Date();

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

    cmbQualityProblemNmInput = $("#cmb_qualityProblemNm_input", "#frm_input").data("KendoDropDownList")

    tui.Grid.applyTheme('clean');
    grid = new tui.Grid({
      el: $('#grid'),
      scrollX: false,
      scrollY: true,
      rowHeight: 30,
      useClientSort: false,
      showDummyRows: true,
      minBodyHeight: 30,
      bodyHeight: 200,
      pagination: false,
      selectionUnit: 'ROW',
      editingEvent: false,
      usageStatistics: false,
      treeColumnOptions: {
        name: 'ID',
        useCascadingCheckbox: false
      },

      columns: [

         {title: '월', name: 'baseDate', align: 'center'}
        , {title: '생산수', name: 'prodCnt', align: 'center'}
        , {title: '판매수', name: 'saleCnt', align: 'center', width: 50}
        , {title: '수리수', name: 'repairCnt', align: 'center', width: 120}

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
    }).on('response', function (data) {
    }).on('successResponse', function (data) {
    }).on('failResponse', function (data) {
    }).on('errorResponse', function (data) {
    }).on('focusChange', function (eventData) {
    });

    net = grid.getAddOn('Net');

    grid2 = new tui.Grid({
        el: $('#grid2'),
        scrollX: false,
        scrollY: true,
        rowHeight: 30,
        useClientSort: false,
        showDummyRows: true,
        minBodyHeight: 30,
        bodyHeight: 200,
        pagination: false,

        editingEvent: false,
        usageStatistics: false,
        treeColumnOptions: {
            name: 'ID',
            useCascadingCheckbox: false
        },

        columns: [

            {title: '현상명', name: 'name', align: 'center'}
            , {title: '건수', name: 'cnt', align: 'center'}
            , {title: '비율', name: 'per', align: 'center', width: 50}

        ],
        summary: {
            height: 20,
            position: 'bottom', // or 'top'
            columnContent: {
                name : {
                    template: function(valueMap) {
                        return '합계';
                    }
                },
                cnt: {
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
    }).on('response', function (data) {
    }).on('successResponse', function (data) {
    }).on('failResponse', function (data) {
    }).on('errorResponse', function (data) {
    }).on('focusChange', function (eventData) {
    });

    net2 = grid2.getAddOn('Net');

    grid3 = new tui.Grid({
        el: $('#grid3'),
        scrollX: false,
        scrollY: true,
        rowHeight: 30,
        useClientSort: false,
        showDummyRows: true,
        minBodyHeight: 30,
        bodyHeight: 200,
        pagination: false,
        selectionUnit: 'ROW',
        editingEvent: false,
        usageStatistics: false,
        treeColumnOptions: {
            name: 'ID',
            useCascadingCheckbox: false
        },

        columns: [

            {title: '차종', name: 'name', align: 'center'}
            , {title: '건수', name: 'cnt', align: 'center'}
            , {title: '비율', name: 'per', align: 'center', width: 50}

        ],
        summary: {
            height: 20,
            position: 'bottom', // or 'top'
            columnContent: {
                name : {
                    template: function(valueMap) {
                        return '합계';
                    }
                },
                cnt: {
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
            'readData': '${readUrl3}',
            // 'downloadExcel': './api/download/excel',
            // 'downloadExcelAll': './api/download/excelAll'
        }
    });

    // Bind event handlers
    grid3.on('beforeRequest', function (data) {
    }).on('response', function (data) {
    }).on('successResponse', function (data) {
    }).on('failResponse', function (data) {
    }).on('errorResponse', function (data) {
    }).on('focusChange', function (eventData) {
    });

    net3 = grid3.getAddOn('Net');

    grid4 = new tui.Grid({
        el: $('#grid4'),
        scrollX: false,
        scrollY: true,
        rowHeight: 30,
        useClientSort: false,
        showDummyRows: true,
        minBodyHeight: 30,
        bodyHeight: 200,
        pagination: false,
        selectionUnit: 'ROW',
        editingEvent: false,
        usageStatistics: false,
        treeColumnOptions: {
            name: 'ID',
            useCascadingCheckbox: false
        },

        columns: [

            {title: '품번', name: 'name', align: 'center'}
            , {title: '건수', name: 'cnt', align: 'center'}
            , {title: '비율', name: 'per', align: 'center', width: 50}

        ],
        summary: {
            height: 20,
            position: 'bottom', // or 'top'
            columnContent: {
                name : {
                    template: function(valueMap) {
                        return '합계';
                    }
                },
                cnt: {
                    template: function(valueMap) {
                        return valueMap.sum;
                    }
                }
            }
        }
    });

    grid4.use('Net', {
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
    grid4.on('beforeRequest', function (data) {
    }).on('response', function (data) {
    }).on('successResponse', function (data) {
    }).on('failResponse', function (data) {
    }).on('errorResponse', function (data) {
    }).on('focusChange', function (eventData) {
    });

    net4 = grid4.getAddOn('Net');

    grid5 = new tui.Grid({
        el: $('#grid5'),
        scrollX: false,
        scrollY: true,
        rowHeight: 30,
        useClientSort: false,
        showDummyRows: true,
        minBodyHeight: 30,
        bodyHeight: 200,
        pagination: false,
        selectionUnit: 'ROW',
        editingEvent: false,
        usageStatistics: false,
        treeColumnOptions: {
            name: 'ID',
            useCascadingCheckbox: false
        },

        columns: [

            {title: '거리', name: 'name', align: 'center'}
            , {title: '건수', name: 'cnt', align: 'center'}
            , {title: '비율', name: 'per', align: 'center', width: 50}

        ],
        summary: {
            height: 20,
            position: 'bottom', // or 'top'
            columnContent: {
                name : {
                    template: function(valueMap) {
                        return '합계';
                    }
                },
                cnt: {
                    template: function(valueMap) {
                        return valueMap.sum;
                    }
                }
            }
        }
    });

    grid5.use('Net', {
        el: $('#frm_input'),
        initialRequest: false,
        readDataMethod: 'GET',
        perPage: 25,
        enableAjaxHistory: false,
        api: {
            'readData': '${readUrl5}',
            // 'downloadExcel': './api/download/excel',
            // 'downloadExcelAll': './api/download/excelAll'
        }
    });

    // Bind event handlers
    grid5.on('beforeRequest', function (data) {
    }).on('response', function (data) {
    }).on('successResponse', function (data) {
    }).on('failResponse', function (data) {
    }).on('errorResponse', function (data) {
    }).on('focusChange', function (eventData) {
    });

    net5 = grid5.getAddOn('Net');

  });

</script>