<%-- [EN] Variable definition --%>
<%-- [JP] 変数定義 --%>
<c:url var="codeUrl" value="/code/list.json"/>

<c:url var="readUrl" value="/models/search"/>
<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] 画面ID (@ViewIdで定義) --%>
<c:set var="screenId" value="<%= request.getAttribute(Globals.SCREEN_ID_KEY) %>"/>

<h2>차종 검색</h2>
<a onclick="_isDirty=false;window.close();return false;" class="close ckd_close">창닫기</a>
<div class="popup_body">

    <div class="search1">
        <form id="frm_search" method="get" data-bind="events: {submit: submit}">
            <fieldset>
                <table>
                    <col style="width:65px"/>
                    <col style="width:85px"/>
                    <col style="width:65px"/>
                    <col style="width:85px"/>
                    <col style="width:65px"/>
                    <col style="width:85px"/>
                    <col style="width:65px"/>
                    <col style="width:120px"/>
                    <col style="width:65px"/>
                    <col style="width:140px"/>
                    <col/>
                    <tr>
                        <th>승상용</th>
                        <td>
                            <kendo:dropDownList name="cmb_tireStd_search" dataTextField="codeNm"
                                                data-value-primitive="true"
                                                dataValueField="codeCd"
                                                data-bind="value: criteria.tireStd"
                                                optionLabel="전체" style="width: 100%;">
                                <kendo:dataSource>
                                    <kendo:dataSource-transport>
                                        <kendo:dataSource-transport-read url="${codeUrl}/CAUTY" type="POST" contentType="application/json"/>
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
                        <th>메이커</th>
                        <td>
                            <kendo:dropDownList name="cmb_maker_search" dataTextField="codeNm"
                                                data-value-primitive="true"
                                                dataValueField="codeCd"
                                                data-bind="value: criteria.maker"
                                                optionLabel="전체" style="width: 100%;">
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
                        <th>배기형식</th>
                        <td>
                            <kendo:dropDownList name="cmb_exhaustReg_search" dataTextField="codeNm"
                                                data-value-primitive="true"
                                                dataValueField="codeCd"
                                                data-bind="value: criteria.exhaustReg"
                                                optionLabel="전체" style="width: 100%;">
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
                        <th>엔진명</th>
                        <td>
                            <kendo:dropDownList name="cmb_engineType_search" dataTextField="codeNm"
                                                data-value-primitive="true"
                                                dataValueField="codeCd"
                                                data-bind="value: criteria.engineType"
                                                optionLabel="전체" style="width: 100%;"
                                                autoWidth="true">
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
                        <th>차종</th>
                        <td>
                            <input type="text" id="text_model" data-bind="value: criteria.model" />
                        </td>
                        <td>
                            <button type="submit" value="submit" class="button"><i class="w_search"></i>검색
                            </button>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </form>
    </div>

    <div id="grid" data-grid-type="view"></div>

</div>

<script type="text/javascript">

    var _dicasPage = new DicasPage('${screenId}');
    var _openerPage = window.opener._dicasPage;

    <%-- Control Definition--%>
    var grid;
    var pagination;
    var net;
    <%--// Control Definition --%>

    var modelsMdl = kendo.data.Model.define({
        id: "id",
        fields: {
            id: { type: "string" },
            tireStd: { type: "string" },
            maker: { type: "string" },
            exhaustReg: { type: "string" },
            engineType: { type: "string" },
            model: { type: "string" }
        }
    });

    var searchView = kendo.observable({
        criteria: {
            tireStd: null,
            maker: null,
            exhaustReg: null,
            engineType: null,
            model: null,
        },
        submit: function () {
            goPage('grid1', 1);
            return false;
        },
    });
    kendo.bind($("#frm_search"), searchView)

    function goPage(gridId, page) {
        if (gridId == "grid1") {
            net.readData(1, searchView.criteria.toJSON(), true);
        }
    }

    var _isDirty = false;
    if (this.addEventListener) {
        this.addEventListener('beforeunload', function () {
            if (!_isDirty) _openerPage.codeHelpVal = null;
        });
    } else {
        this.attachEvent('onbeforeunload', function () {
            if (!_isDirty) _openerPage.codeHelpVal = null;
        });
    }

    function convertUndefined(str) {
        if (str == "undefined" || str == "" || str == "null") {
            return null;
        } else {
            return str;
        }
    }

    $(document).ready(function() {

            var data = new modelsMdl({
                tireStd: convertUndefined("${modelsForm.tireStd}"),
                maker: convertUndefined("${modelsForm.maker}"),
                exhaustReg: convertUndefined("${modelsForm.exhaustReg}"),
                engineType: convertUndefined("${modelsForm.engineType}"),
                model: convertUndefined("${modelsForm.model}")
            });
            searchView.set('criteria', data);

        tui.Grid.applyTheme('clean');
        grid = new tui.Grid({
            el: $('#grid'),
            scrollX: false,
            scrollY: true,
            rowHeight: 30,
            showDummyRows: true,
            minBodyHeight: 30,
            bodyHeight: 280,
            pagination: true,
            selectionUnit: 'CELL',
            editingEvent: false,
            usageStatistics: false,
            columns: [

                { title: 'No', name: 'rn', align: 'center' }
                ,{ title: '차종', name: 'model', align: 'center' }
                ,{ title: '배기형식', name: 'exhaustRegNm', align: 'center' }
                ,{ title: '엔진명', name: 'engineTypeNm', align: 'center' }

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
            // For all requests
            _dicasPage.maskOpen();
        }).on('response', function (data) {
            // For all response (regardless of success or failure)
            _dicasPage.maskClose();
        }).on('successResponse', function (data) {
        }).on('failResponse', function (data) {
        }).on('errorResponse', function (data) {
        }).on('dblclick', function (eventData) {
            _openerPage.codeHelpVal = JSON.stringify(this.getRow(eventData.rowKey));
            _isDirty = true;
            window.close();
        }).on('focusChange', function (eventData) {
            _isDirty = false;
        });

        net = grid.getAddOn('Net');
        pagination = grid.getPagination();
        pagination.on('afterMove', function (eventData) {
            if (grid.getRowCount() > 0)
                grid.focusAt(0, 0);
        });

        searchView.submit();

    });

</script>