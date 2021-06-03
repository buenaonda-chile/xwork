<%-- [EN] Variable definition --%>
<%-- [JP] ???? --%>
<c:url var="codeUrl" value="/code/list.json"/>

<c:url var="readUrl" value="/costApprove/search"/>

<c:url var="readUrl2" value="/resultMasterCost/search"/>

<c:url var="readUrl3" value="/resultMaster/search2"/>

<c:url var="readUrl4" value="/costApprove/costSearch"/>

<c:url var="readUrl5" value="/resultMasterCost/search3"/>

<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] ??ID (@ViewId???) --%>
<c:set var="screenId" value="<%= request.getAttribute(Globals.SCREEN_ID_KEY) %>"/>

<div class="sub-con-wrap">
    <!-- 버튼들 -->
    <div class="sub-btn-group">
        <button id="btn_search" type="button" class="button" data-bind="click: search, visible: btnGrp0Visible"><i class="w_search"></i>검색</button>
        <form id="frm_search" method="get" >
            <input type="hidden" id="manageNo_input" data-bind="value: criteria.manageNo" />
        </form>
    </div>
    <!-- /버튼들 -->
</div>

<div id="form_container" class="left" style="width:100%;">

    <form id="frm_input" method="post">
        <table class="bWrite">
            <col style="width:110px" /><col style="width:25%" />
            <col style="width:110px" /><col style="width:25%" />
            <col style="width:110px" /><col />
            <tbody>
            <tr>
                <th>차대번호</th>
                </th>
                <td>
                    <input type="text" id="vinno_input" data-bind="value: data.vinno" style="border:none"/>
                    <input type="hidden" id="approvalNo_input" data-bind="value: data.approvalNo" />
                </td>
                <th>사용개월</th>
                </th>
                <td colspan="3">
                    <input type="text" id="useMonth_input" data-bind="value: data.useMonth" style="border:none" />
                </td>
            </tr>

            <tr>
                <th>정비소명</th>
                </th>
                <td>
                    <input type="text" id="officeNm_input" data-bind="value: data.officeNm" style="border:none" />
                </td>
                <th>접수일</th>
                </th>
                <td>
                    <input type="text" id="receiptDate_input" data-bind="value: data.receiptDate" style="border:none" />
                </td>
                <th>조사일</th>
                </th>
                <td>
                    <input type="text" id="researchDate_input" data-bind="value: data.researchDate" style="border:none" />
                </td>
            </tr>

            <tr>
                <th>SD정비소명</th>
                </th>
                <td>
                    <input type="text" id="sdNm_input" data-bind="value: data.sdNm" style="border:none" />
                </td>
                <th>상담자</th>
                </th>
                <td>
                    <input type="text" id="receiveUser_input" data-bind="value: data.receiveUser" style="border:none" />
                </td>
                <th>조사자</th>
                </th>
                <td>
                    <input type="text" id="requestUser_input" data-bind="value: data.requestUser" style="border:none" />
                </td>
            </tr>
            </tbody>
        </table>

        <!-- 비용계산 모양 -->
        <table class="bList">

            <thead>
            <tr>
                <th colspan="2">구분</th>
                <th colspan="2">항목</th>
                <th class="inTable_cw2">비용산출방법</th>
                <th class="inTable_cw3">금액</th>
            </tr>
            </thead>
            <tr>
                <td rowspan="10" class="tac">위탁비용</td>
                <td rowspan="3" class="tac">수리비</td>
                <td colspan="2" class="tac">① 공임</td>
                <td colspan="2" class="inTable">
                    <table>
                        <tr>
                            <td class="tac inTable_cw2">①</td>
                            <td class="tar inTable_cw3">
                                <input type="text" id="labor_input" data-bind="value: data.labor" style="border:none" />
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td colspan="2" class="tac">② 작업시간</td>
                <td colspan="2" class="inTable">
                    <table>
                        <tr>
                            <div id="grid2" data-grid-type="view"></div>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td colspan="2" class="tac">③ 수리비</td>
                <td colspan="2" class="inTable">
                    <table>
                        <tr>
                            <td class="tac inTable_cw2">①*②</td>
                            <td class="tar inTable_cw3">
                                <input type="text" id="repairAmtTot_input" data-bind="value: data.repairAmtTot" style="border:none" />
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td rowspan="2" class="tac">부품대</td>
                <td colspan="2" class="tac">④ 제품대</td>
                <td colspan="2" class="inTable">
                    <table>
                        <tr>
                            <div id="grid3" data-grid-type="view"></div>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td colspan="2" class="tac">⑤ 제품마진</td>
                <td colspan="2" class="inTable">
                    <table>
                        <tr>
                            <td class="tac inTable_cw2">④*rate</td>
                            <td class="tar inTable_cw3">
                                <input type="text" id="partMarginCulcu_input" data-bind="value: data.partMarginCulcu" style="border:none"/>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td rowspan="2" class="tac">부대비</td>
                <td colspan="2" class="inTable_cw1_1 inTable">
                    ⑥
                </td>
                <td colspan="2" class="inTable">
                    <table>
                        <tr>
                            <div id="grid4" data-grid-type="view"></div>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td colspan="2" class="inTable_cw1_1 inTable">
                    ⑦
                </td>
                <td colspan="2" class="inTable">
                    <table>
                        <tr>
                            <div id="grid5" data-grid-type="view"></div>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td colspan="3" class="tac">⑧ 출장비</td>
                <td colspan="2" class="inTable">
                    <table>
                        <tr>
                            <td class="tac inTable_cw2">왕복거리(km) </td>
                            <td class="tar inTable_cw3">
                                <input type="text" id="travelAmt_input" data-bind="value: data.travelAmt" style="border:none"/>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td colspan="3" class="tac">⑨ 부가세</td>
                <td colspan="2" class="inTable">
                    <table>
                        <tr>
                            <td class="tac inTable_cw2">( ③+④+⑤+⑥ ) * 10%</td>
                            <td class="tar inTable_cw3">
                                <input type="text" id="taxAmt_input" data-bind="value: data.taxAmt" style="border:none"/>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td colspan="3" class="tac">종합</td>
                <td colspan="2" class="inTable">
                    <table>
                        <tr>
                            <td class="tac inTable_cw2">( ③+④+⑤+⑥+⑦+⑧+⑨ ) * 10%</td>
                            <td class="tar inTable_cw3">
                                <input type="text" id="totalAmts_input" data-bind="value: data.totalAmts" style="border:none"/>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
        <!-- 비용계산 모양 -->
    </form>
</div>
<!-- END form_container -->
<div style="height: 0%">
    <div id="grid" style="width: 0%;display:none"></div>
</div>

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
        btnGrp0Visible: false,
        btnGrp1Visible: false,
        btnGrp2Visible: false,
        search: function() {
            searchView.submit();
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
                this.set('btnGrp0Visible', false);

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
        validate: function () {
            if (validatable == null) return true;
            return validatable.validate();
        },
        hasChanges: function () {
            return grid.isModified();
        },
    });

    kendo.bind($("#form_container"), inputView);

    function setPageUI(type) {
        if (type == "init") {
            $("input[type]", "#form_container").each(function (i, v) {
                $(v).attr("readonly", true);
            });

        } else if (type == 'view' || type == 'add') {

            $("input[type]", "#form_container").each(function (i, v) {
                $(v).attr("readonly", true);
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


        searchView.set('criteria.vinno', _dicasPage.getParameterByName("vinno"));
        searchView.set('criteria.manageNo', _dicasPage.getParameterByName("manageNo"));

        validatable = $("#form_container").kendoValidator({validateOnBlur: false})
            .data("kendoValidator");

        tui.Grid.applyTheme('clean');
        grid = new tui.Grid({
            el: $('#grid'),
            scrollX: false,
            scrollY: false,
            rowHeight: 30,
            // keyColumnName: 'codeKey',
            useClientSort: false,
            showDummyRows: true,
            minBodyHeight: 30,
            bodyHeight: 150,
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
                ,{ title: '접수일', name: 'receiptDate', align: 'center',hidden : true }
                ,{ title: '조사일', name: 'researchDate', align: 'center',hidden : true }
                ,{ title: '클레임번호', name: 'manageNo', align: 'center'}
                ,{ title: '정비소명', name: 'officeNm', align: 'center',hidden : true }
                ,{ title: '승인상태', name: 'approvalStatus', align: 'center', hidden : true }

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
            }
        });

        // Bind event handlers
        grid.on('beforeRequest', function (data) {
            _dicasPage.maskOpen();
        }).on('response', function (data) {
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
            scrollY: false,
            rowHeight: 30,
            header: {
                height: 30
            },
            useClientSort: false,
            showDummyRows: true,
            minBodyHeight: 30,
            bodyHeight: 150,
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
                ,{ title: '구분', name: 'costNm', align: 'center', width: 347}
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
            scrollY: false,
            rowHeight: 30,
            header: {
                height: 30
            },
            useClientSort: false,
            showDummyRows: true,
            minBodyHeight: 30,
            bodyHeight: 150,
            pagination: false,
            selectionUnit: 'CELL',
            editingEvent: true,
            usageStatistics: false,
            columns: [

                { title: '구분', name: 'replacePartNm', align: 'center', width: 347 }
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
            scrollY: false,
            rowHeight: 30,
            header: {
                height: 30
            },
            // keyColumnName: 'codeKey',
            useClientSort: false,
            showDummyRows: true,
            minBodyHeight: 30,
            bodyHeight: 150,
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
                ,{ title: '구분', name: 'costNm', align: 'center', width: 347}
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
            scrollY: false,
            rowHeight: 23,
            header: {
                height: 23
            },
            useClientSort: false,
            showDummyRows: true,
            minBodyHeight: 23,
            bodyHeight: 150,
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
                ,{ title: '구분', name: 'costNm', align: 'center' , width: 347}
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

        setPageUI("init");

        searchView.submit();
        setTimeout(function() {
            window.print();
        }, 1500); // 3000ms(3초)가 경과하면 이 함수가 실행됩니다.
    });

</script>

