<%-- [EN] Variable definition --%>
<%-- [JP] ???? --%>
<c:url var="codeUrl" value="/code/list.json"/>

<c:url var="readUrl" value="/costApprove/search"/>
<c:url var="updateUrl" value="/costApprove/update"/>

<c:url var="readUrl2" value="/resultMasterCost/search"/>

<c:url var="readUrl3" value="/resultMaster/search2"/>

<c:url var="readUrl4" value="/costApprove/costSearch"/>

<c:url var="readUrl5" value="/resultMasterCost/search3"/>

<c:url var="popupUrl" value="/popup/costApprove/init"/>

<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] ??ID (@ViewId???) --%>
<c:set var="screenId" value="<%= request.getAttribute(Globals.SCREEN_ID_KEY) %>"/>

<div class="sub-con-wrap">
  <h2 class="subpage-tit">비용승인</h2>
  <!-- 버튼들 -->
  <div class="sub-btn-group">
    <button type="button" class="button" data-bind="click: popup"><i class="w_print"></i>인쇄</button>
    <button id="btn_search" type="button" class="button" data-bind="click: search, visible: btnGrp0Visible"><i class="w_search"></i>검색</button>
    <button id="btn_cancel" type="button" class="button" data-bind="click: cancel, visible: btnGrp1Visible"><i class="w_cancel"></i>취소</button>
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
          <col style="width:280px"/>
          <col style="width:80px"/>
          <col style="width:280px"/>
          <col style="width:80px"/>
          <col style="width:155px"/>
          <col style="width:80px"/>
          <col style="width:155px"/>
          <col/>
        </colgroup>
        <tr>
          <%--<th>결과날짜</th>--%>
          <%--<td>--%>
              <%--<input type="text" id="searchResultDateFr" data-bind="value: criteria.searchResultDateFr"  class="calendar" /> - <input type="text" id="searchResultDateTo"  data-bind="value: criteria.searchResultDateTo" class="calendar" />--%>
          <%--</td>--%>
          <th>접수일</th>
          <td>
            <input type="text" id="searchReceiptDateFr" data-bind="value: criteria.searchReceiptDateFr"  class="calendar" /> - <input type="text" id="searchReceiptDateTo"  data-bind="value: criteria.searchReceiptDateTo" class="calendar" />
          </td>
          <th>조사일</th>
          <td>
            <input type="text" id="searchResearchDateFr" data-bind="value: criteria.searchResearchDateFr"  class="calendar" /> - <input type="text" id="searchResearchDateTo"  data-bind="value: criteria.searchResearchDateTo" class="calendar" />
          </td>
          <th>차대번호</th>
          <td>
            <input type="text" id="vinno_search" data-bind="value: criteria.vinno" />
            <input type="hidden" id="manageNo_input" data-bind="value: criteria.manageNo" />
          </td>
          <th>결재상태</th>
          <td>
              <select id="approvalStatus_search" data-bind="value: criteria.approvalStatus" >
                  <option value='' >전체</option>
                  <option value='SUBMISSION' >제출</option>
                  <option value='APPROVAL' >승인</option>
                  <option value='REJECT' >반려</option>
              </select>
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
    <div style="margin-bottom:10px;"></div>
    <div id="grid" data-grid-type="view"></div>
  </div>
  <div id="form_container" class="right" style="width:60%;">
    <div class="wrap">
      <form id="frm_input" method="post">
        <fieldset>
          <table class="bWrite">
            <tbody>
            <tr>
              <th scope="row"><label for="vinno_input">차대번호</label>
              </th>
              <td>
                <input type="text" id="vinno_input" data-bind="value: data.vinno" style="width:140px;" />
                <input type="hidden" id="approvalNo_input" data-bind="value: data.approvalNo" />
              </td>
              <th scope="row"><label for="useMonth_input">사용개월</label>
              </th>
              <td>
                <input type="text" id="useMonth_input" data-bind="value: data.useMonth" style="width:140px;" />
              </td>
              <td colspan="2">
                <button id="btn_approval" type="button" class="button" data-bind="click: approval, visible: btnGrp3Visible" style="width: 100px">승인</button>
                <button id="btn_reject" type="button" class="button" data-bind="click: reject, visible: btnGrp4Visible" style="width: 100px">승인취소</button>
                <button id="btn_sendClime" href="/service/init" data-name="클레임접수" data-menu-id = "6" type="button" class="button" data-bind="click: sendClime, visible: btnGrp4Visible" style="width: 100px">클레임접수</button>
              </td>
            </tr>

            <tr>
              <th scope="row"><label for="officeNm_input">정비소명</label>
              </th>
              <td>
                <input type="text" id="officeNm_input" data-bind="value: data.officeNm" style="width:140px;" />
              </td>
              <th scope="row"><label for="receiptDate_input">접수일</label>
              </th>
              <td>
                <input type="text" id="receiptDate_input" data-bind="value: data.receiptDate" style="width:140px;" />
              </td>
              <th scope="row"><label for="researchDate_input">조사일</label>
              </th>
              <td>
                <input type="text" id="researchDate_input" data-bind="value: data.researchDate" style="width:140px;" />
              </td>
            </tr>

            <tr>
              <th scope="row"><label for="sdNm_input">SD정비소명</label>
              </th>
              <td>
                <input type="text" id="sdNm_input" data-bind="value: data.sdNm" style="width:140px;" />
              </td>
              <th scope="row"><label for="receiveUser_input">상담자</label>
              </th>
              <td>
                <input type="text" id="receiveUser_input" data-bind="value: data.receiveUser" style="width:140px;" />
              </td>
              <th scope="row"><label for="requestUser_input">조사자</label>
              </th>
              <td>
                <input type="text" id="requestUser_input" data-bind="value: data.requestUser" style="width:140px;" />
              </td>
            </tr>

            <%--<tr>--%>
              <%--<th scope="row"><label for="exchangeNm_input">문의품</label>--%>
              <%--</th>--%>
              <%--<td>--%>
                <%--<input type="text" id="exchangeNm_input" data-bind="value: data.exchangeNm" style="width:140px;" />--%>
              <%--</td>--%>
              <%--<th scope="row"><label for="hmcPartNo_input">품번</label>--%>
              <%--</th>--%>
              <%--<td colspan="3">--%>
                <%--<input type="text" id="hmcPartNo_input" data-bind="value: data.hmcPartNo" style="width:140px;" />--%>
              <%--</td>--%>
            <%--</tr>--%>

            <%--<tr>--%>
              <%--<th scope="row"><label for="approvalNo_input">승인번호</label>--%>
              <%--</th>--%>
              <%--<td>--%>
                <%--<input type="text" id="approvalNo_input" data-bind="value: data.approvalNo" style="width:140px;" />--%>
              <%--</td>--%>
              <%--<td colspan="4"></td>--%>
            <%--</tr>--%>

            </tbody>
          </table>
        </fieldset>
      </form>

    </div>

    <div>

      <!-- 비용계산 모양 -->

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
          <td rowspan="10">위탁비용</td>
          <td rowspan="3">수리비</td>
          <td>①공임</td>
          <td colspan="2">①</td>
          <td>
            <input type="text" id="labor_input" data-bind="value: data.labor" />
          </td>
        </tr>

        <tr>
          <td>②작업시간</td>
          <td>
          </td>
          <td colspan="2">
            <div id="grid2" data-grid-type="view"></div>
          </td>
        </tr>

        <tr>
          <td>③수리비</td>
          <td colspan="2">①*②</td>
          <td>
            <input type="text" id="repairAmtTot_input" data-bind="value: data.repairAmtTot"/>
          </td>
        </tr>

        <tr>
          <td rowspan="2">부품대</td>
          <td>④제품대</td>
          <td>④</td>
          <td colspan="2">
            <div id="grid3" data-grid-type="view"></div>
          </td>
        </tr>

        <tr>
          <td>⑤제품마진</td>
          <td colspan="2">④*rate</td>
          <td>
            <input type="text" id="partMarginCulcu_input" data-bind="value: data.partMarginCulcu"/>
          </td>
        </tr>

        <tr>
          <td rowspan="2">부대비</td>
          <td>
            ⑥
          </td>
          <td colspan="3">
            <div id="grid4" data-grid-type="view"></div>
          </td>
        </tr>

        <tr>
          <td>
            ⑦
          </td>
          <td colspan="3">
            <div id="grid5" data-grid-type="view"></div>
          </td>
        </tr>

        <tr>
          <td colspan="2">⑧출장비</td>
          <td>왕복거리(Km)</td>
          <td>
            <input type="text" id="dist_input" data-bind="value: data.dist"/>
          </td>
          <td>
            <input type="text" id="travelAmt_input" data-bind="value: data.travelAmt"/>
          </td>
        </tr>

        <tr>
          <td colspan="2">⑨부가세</td>
          <td colspan="2">(③ + ④ + ⑤ + ⑥ + ⑦ + ⑧) * 10%</td>
          <td>
            <input type="text" id="taxAmt_input" data-bind="value: data.taxAmt"/>
          </td>
        </tr>

        <tr>
          <td colspan="2">총합</td>
          <td colspan="2">③ + ④ + ⑤ + ⑥ + ⑦ + ⑧ + ⑨</td>
          <td>
            <input type="text" id="totalAmts_input" data-bind="value: data.totalAmts"/>
          </td>
        </tr>

      </table>

      <!-- 비용계산 모양 -->

    </div>

  </div>
  <!-- END form_container -->

</div>
<%--// .layout-LW --%>

<script type="text/javascript">

    var _dicasPage = new DicasPage('${screenId}');

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
            masterId: { type: 'string' }
            ,manageNo: { type: 'string' }
            ,serviceDegree: { type: 'number' }
            ,totalAmt: { type: 'number' }
            ,totalAmts: { type: 'string' }
            ,vinno: { type: 'string' }
            ,receiptDate: { type: 'string' }
            ,receiveUser: { type: 'string' }  //상담자
            ,officeNm: { type: 'string' }
            ,officeCd: { type: 'string' }
            ,exchangeNm: { type: 'string' }
            ,officeCity: { type: 'string' }
            ,maker: { type: 'string' }
            ,resultDate: { type: 'string' }
            ,approvalNo: { type: 'string' }
            ,sdAppoint: { type: 'string' }
            ,sdNm: { type: 'string' }
            ,researchDate: { type: 'string' }   //조사일
            ,hmcPartNo: { type: 'string' }
            ,submission: { type: 'string' }
            ,approval: { type: 'string' }
            ,reject: { type: 'string' }
            ,approvalStatus: { type: 'string' }
            ,requestUser: { type: 'string' }   //조사자
            ,qualityIndex: { type: 'string' }
            ,useMonth: { type: 'string' }
        }
    });

    var buttonView = kendo.observable({
        btnGrp0Visible: true,
        btnGrp1Visible: false,
        btnGrp2Visible: false,
        search: function() {
            searchView.submit();
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
        popup: function () {
          var gridRowkey = grid.getFocusedCell().rowKey;
            if(gridRowkey == null){
              alert("출력 할 대상을 먼저 선택해주세요.");
              return false;
            }else{
            var that = this;
            _dicasPage.popupOpen({
              url: "${popupUrl}",
              code: 'codeHelp',
              width: 1400,
              height: 800,
              params: {
                vinno: grid.getValue(grid.getFocusedCell().rowKey, 'vinno'),
                manageNo: grid.getValue(grid.getFocusedCell().rowKey, 'manageNo')
              },
              beforeOpen: function () {
                _dicasPage.beforeCodeHelpVal = true;
              },
              afterClose: function (info) {
              }
            });
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
        btnGrp3Visible: true,
        btnGrp4Visible: true,
        rowIndex: 0,
        rowKey: null,
        data: null,
        save: function (cmd) {

            if (cmd == 'approval') {
                var gridRowkey = grid.getFocusedCell().rowKey;
                grid.setValue(gridRowkey, "submission", "1");
                grid.setValue(gridRowkey, "approval", "1");
                grid.setValue(gridRowkey, "reject", "0");
            } else if (cmd == 'reject') {
                var gridRowkey = grid.getFocusedCell().rowKey;
                grid.setValue(gridRowkey, "submission", "1");
                grid.setValue(gridRowkey, "approval", "0");
                grid.setValue(gridRowkey, "reject", "1");
            }

            var message = "", isupdate = false;
            message = "변경된 데이터가 있습니다.  수정 하시겠습니까?";
            isupdate = true;

            if (inputView.hasChanges()) {
                if (!confirm(message)) {
                    return;
                }
            }

            var dataMap = grid.getModifiedRows({
                checkedOnly: false
            });

            _dicasPage.maskOpen();

            if (isupdate) {
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
            }

        },
        validate: function () {
            if (validatable == null) return true;
            return validatable.validate();
        },
        hasChanges: function () {
            return grid.isModified();
        },
        approval: function() {
            inputView.save('approval');
        },
        reject: function() {
            inputView.save('reject');
        },
      sendClime : function(){

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
                $(v).attr("disabled", true);
            });
        }

        var state = grid.getValue(inputView.get('rowKey'), "approvalStatus");
        if ( state == "APPROVAL") {
            inputView.set('btnGrp3Visible', false);
            inputView.set('btnGrp4Visible', true);
        } else if (state == "REJECT") {
            inputView.set('btnGrp3Visible', true);
            inputView.set('btnGrp4Visible', false);

        } else if (state == "SUBMISSION") {
            inputView.set('btnGrp3Visible', true);
            inputView.set('btnGrp4Visible', true);
        }
    }

    function goPage(gridId, page) {
        if (gridId == "grid1") {
            searchView.set("rowKey", null);
            net.readData(1, searchView.criteria.toJSON(), true);
        }
    }

    $(document).ready(function () {

      $("#btn_sendClime").click(function(){

        var gridRowkey = grid.getFocusedCell().rowKey;
        if(gridRowkey == null){
          alert("클레임접수 대상을 먼저 선택해주세요.");
          return false;
        }else{
            if(confirm("해당 접수건에 대하여 클레임접수 처리를 진행하시겠습니까?")){
                var manageNo = grid.getValue(gridRowkey, "manageNo");
                var vinno = grid.getValue(gridRowkey, "vinno");
                var obj = $("#btn_sendClime");

                var pacnt = parent.$("#myTab04").children().children().children('.trayScroll').children('a').length;
                if(pacnt > 1){
                    parent.$("#myTab04").children().children().children('.trayScroll').children('a').each(function(index, value){

                        if($(this).text() == "클레임접수"){
                            console.log($(this).text()+", "+$(this).html());
                            $(this).children('span').trigger('click');
                        }
                    });
                }
                parent.loadTab(obj, {manageNo:manageNo, vinno : vinno});
            }
        }
      });

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

                { title: '결과등록일', name: 'resultDate', align: 'center', hidden : true }
                ,{ title: '접수일', name: 'receiptDate', align: 'center' }
                ,{ title: '조사일', name: 'researchDate', align: 'center' }
                ,{ title: '클레임번호', name: 'manageNo', align: 'center'}
                ,{ title: '정비소명', name: 'officeNm', align: 'center' }
                ,{ title: '승인상태', name: 'approvalStatus', align: 'center' }
                ,{ title: '', name: 'approvalNo', align: 'center', hidden : true }
                ,{ title: 'null', name: 'masterId', align: 'center', hidden : true }
                ,{ title: 'null', name: 'serviceDegree', align: 'center', hidden : true }
                ,{ title: 'null', name: 'totalAmt', align: 'center', hidden : true }
                ,{ title: 'null', name: 'vinno', align: 'center', hidden : true }
                ,{ title: 'null', name: 'receiptDate', align: 'center', hidden : true }
                ,{ title: 'null', name: 'receiveUser', align: 'center', hidden : true }
                ,{ title: 'null', name: 'officeCd', align: 'center', hidden : true }
                ,{ title: 'null', name: 'exchangeNm', align: 'center', hidden : true }
                ,{ title: 'null', name: 'officeCity', align: 'center', hidden : true }
                ,{ title: 'null', name: 'maker', align: 'center', hidden : true }
                ,{ title: 'null', name: 'sdAppoint', align: 'center', hidden : true }
                ,{ title: 'null', name: 'sdNm', align: 'center', hidden : true }
                ,{ title: 'null', name: 'id', align: 'center', hidden : true }
                ,{ title: 'null', name: 'hmcPartNo', align: 'center', hidden : true }
                ,{ title: 'null', name: 'submission', align: 'center', hidden : true }
                ,{ title: 'null', name: 'approval', align: 'center', hidden : true }
                ,{ title: 'null', name: 'reject', align: 'center', hidden : true }
                ,{ title: 'null', name: 'labor', align: 'center', hidden : true }
                ,{ title: 'null', name: 'repairAmtTot', align: 'center', hidden : true }
                ,{ title: 'null', name: 'partAmtTot', align: 'center', hidden : true }
                ,{ title: 'null', name: 'partMarginCulcu', align: 'center', hidden : true }
                ,{ title: 'null', name: 'dist', align: 'center', hidden : true }
                ,{ title: 'null', name: 'travelAmt', align: 'center', hidden : true }
                ,{ title: 'null', name: 'taxAmt', align: 'center', hidden : true }
                ,{ title: 'null', name: 'totalAmts', align: 'center', hidden : true }

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

                    //alert(inputView.data.manageNo);

                    searchView.criteria.manageNo = inputView.data.manageNo;

                    net2.readData(1, searchView.criteria.toJSON(), true);
                    net3.readData(1, searchView.criteria.toJSON(), true);
                    net4.readData(1, searchView.criteria.toJSON(), true);
                    net5.readData(1, searchView.criteria.toJSON(), true);

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
            if (grid.getRowCount() > 0) {
                grid.focusAt(0, 0);
            }
        });

        grid2 = new tui.Grid({
            el: $('#grid2'),
            scrollX: false,
            scrollY: true,
            rowHeight: 30,
            header: {
                height: 30
            },
            // keyColumnName: 'codeKey',
            useClientSort: false,
            showDummyRows: true,
            minBodyHeight: 30,
            bodyHeight: 100,
            pagination: false,
            selectionUnit: 'CELL',
            editingEvent: false,
            usageStatistics: false,
            treeColumnOptions: {
                name: 'ID',
                useCascadingCheckbox: false
            },
            columns: [

                { title: '구분', name: 'costCd', align: 'center', hidden: 'false' }
                ,{ title: '구분', name: 'costNm', align: 'center' }
                ,{ title: '금액', name: 'costValue', align: 'center' }
                ,{ title: '관리번호', name: 'mngNo', align: 'center', hidden: 'false' }
                ,{ title: '차수', name: 'serviceSeq', align: 'center', hidden: 'false' }

            ],
            summary: {
                height: 20,
                position: 'bottom', // or 'top'
                columnContent: {
                    costNm : {
                        template: function(valueMap) {
                            return '합계';
                        }
                    },
                    costValue: {
                        template: function(valueMap) {
                            return valueMap.sum.toFixed(1);
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
                'readData': '${readUrl4}',
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
            header: {
                height: 30
            },
            // keyColumnName: 'codeKey',
            useClientSort: false,
            showDummyRows: true,
            minBodyHeight: 30,
            bodyHeight: 140,
            pagination: false,
            selectionUnit: 'CELL',
            editingEvent: true,
            usageStatistics: false,
            columns: [

                { title: '구분', name: 'replacePartNm', align: 'center' }
                ,{ title: '금액', name: 'partsCost', align: 'center' }
                ,{ title: '시간', name: 'workHour', align: 'center', hidden : 'false' }

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
            // For all requests
            //_dicasPage.maskOpen();
        }).on('response', function (data) {
            // For all response (regardless of success or failure)
            //_dicasPage.maskClose();
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
            header: {
                height: 30
            },
            // keyColumnName: 'codeKey',
            useClientSort: false,
            showDummyRows: true,
            minBodyHeight: 30,
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

                { title: '구분', name: 'costCd', align: 'center',  editOptions: { type: 'text', maxLength: 20, useViewMode: false }, hidden: 'false' }
                ,{ title: '구분', name: 'costNm', align: 'center' }
                ,{ title: '금액', name: 'costValue', align: 'center' }
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
                  costNm : {
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

        grid4.use('Net', {
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
        grid4.on('beforeRequest', function (data) {
            // For all requests
            //_dicasPage.maskOpen();
        }).on('response', function (data) {
            // For all response (regardless of success or failure)
            //_dicasPage.maskClose();
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

                { title: '구분', name: 'costCd', align: 'center',  editOptions: { type: 'text', maxLength: 20, useViewMode: false }, hidden: 'false' }
                ,{ title: '구분', name: 'costNm', align: 'center' }
                ,{ title: '금액', name: 'costValue', align: 'center' }
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
                    costNm : {
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
            // For all requests
            //_dicasPage.maskOpen();
        }).on('response', function (data) {
            // For all response (regardless of success or failure)
            //_dicasPage.maskClose();
        }).on('successResponse', function (data) {
        }).on('failResponse', function (data) {
        }).on('errorResponse', function (data) {
        }).on('focusChange', function (eventData) {
        });

        net5 = grid5.getAddOn('Net');

        setPageUI("init");


        if(_dicasPage.requestParams != null) {

          var vinno = _dicasPage.requestParams.vinno;
          var manageNo = _dicasPage.requestParams.manageNo;
          searchView.set('criteria.vinno', vinno);
          searchView.set('criteria.manageNo', manageNo);

          searchView.submit();
        }
    });


    /*function loadTab(obj, params) {
      var menuCd = $(obj).attr("data-menu-id");

      if (params !== undefined) {
        sessionStorage.setItem(menuCd, JSON.stringify(params));
      }

      if ($("#myTab04").length == 0) {
        window.parent.location.href = DICAS_URL + "/sub/" + menuCd;
        return false;
      }

      pageInit();

      var href = $(obj).attr("href");
      var id = '';
      var isOpened = false;
      // var menuCd = getUrlParam(href, 'menu');
      var tabNum = '';

      $('iframe').each(function () {
        var src = $(this).attr('src');
        var menuId = getUrlParam(src, 'menu');
        if (menuCd == menuId) {
          var tabId = getUrlParam(src, 'tabId')
          tabNum = tabId.substring(6);
          isOpened = true;
          return;
        }
      });

      if (isOpened) {
        var target = $('#myTab04_AX_Tabs_AX_' + tabNum);
        target.trigger('click');
        //setLangeMenuCd(href);
      } else {

        var options = [];
        var hrefVal = $(obj).attr('href') + "?menu=" + menuCd;

        // if (pType === undefined) {
        //   hrefVal = $(obj).attr("href");
        // } else {
        //   hrefVal = $(obj).attr("href") + "&pType=" + pType;
        // }

        options.push({
          optionText: $(obj).attr("data-name"),
          optionValue: hrefVal,
          closable: true
        });

        $("#myTab04").addTabs(options);
        $("#myTab04").setValueTab(options[0].optionValue);

        //상단 Languge menuCd 세팅
        //setLangeMenuCd(options[0].optionValue);
      }

      closeStyle();

      return false;
    }

    function closeStyle() {
      $('#mainNav li a .mNname').css('display', 'none');
      $('#mainNav-wrap').stop().animate({'width': '100'}, 400, function () {
//		console.log(oldStyle);
        $('#mainNav li a .mNname').attr("style", "");
        bridge = openStyle;
        $("#mainNav").removeClass("opened");
      });
      $('.depth-wrap').css('left', '100px');
      $('#mainNav > ul > li').css('text-align', 'center');
      $('#mainNav > ul > li > a > span ').css('padding-left', '0px');
      $('#mainNav li a .mNname .tri').css('display', 'inline-block');
      $('#mainNav-wrap .mNav-ctrl a').attr("style", "");

    }*/
</script>
