<%-- [EN] Variable definition --%>
<%-- [JP] ???? --%>
<c:url var="codeUrl" value="/code/list.json"/>

<c:url var="readUrl" value="/popup/partNumber/search"/>

<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] ??ID (@ViewId???) --%>
<c:set var="screenId" value="<%= request.getAttribute(Globals.SCREEN_ID_KEY) %>"/>

<h2>부품검색</h2>
<a onclick="_isDirty=false;window.close();return false;" class="close ckd_close">창닫기</a>

<div class="popup_body">
    <%-- .search1 --%>
    <div class="search1">
        <form id="frm_search" method="get" data-bind="events: {submit: submit}">
            <fieldset>
                <table>
                    <colgroup>
                        <col style="width:100px"/>
                        <col style="width:155px"/>
                        <col style="width:100px"/>
                        <col style="width:155px"/>
                        <col style="width:100px"/>
                        <col style="width:155px"/>
                        <col style="width:100px"/>
                        <col style="width:155px"/>
                        <col style="width:100px"/>
                        <col style="width:155px"/>
                        <col/>
                    </colgroup>
                    <tr>
                        <th>메이커</th>
                        <td>
                            <kendo:dropDownList name="cmb_maker_search" dataTextField="codeNm"
                                                data-value-primitive="true"
                                                dataValueField="codeCd"
                                                data-bind="value: criteria.maker"
                                                optionLabel="전체" style="width: 100%;">
                                <kendo:dataSource>
                                    <kendo:dataSource-transport>
                                        <kendo:dataSource-transport-read url="${codeUrl}/CAMAK" type="POST" contentType="application/json"/>
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
                        <th>부품구분</th>
                        <td>
                            <kendo:dropDownList name="cmb_partDiv_search" dataTextField="codeNm"
                                                data-value-primitive="true"
                                                dataValueField="codeCd"
                                                data-bind="value: criteria.partDiv"
                                                optionLabel="전체" style="width: 100%;">
                                <kendo:dataSource>
                                    <kendo:dataSource-transport>
                                        <kendo:dataSource-transport-read url="${codeUrl}/CAQPD" type="POST" contentType="application/json"/>
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
                        <%--<th>그룹</th>--%>
                        <%--<td>--%>
                            <%--<kendo:dropDownList name="cmb_groupId_search" dataTextField="codeNm"--%>
                                                <%--data-value-primitive="true"--%>
                                                <%--dataValueField="codeCd"--%>
                                                <%--data-bind="value: criteria.groupId"--%>
                                                <%--optionLabel="전체" style="width: 100%;">--%>
                                <%--<kendo:dataSource>--%>
                                    <%--<kendo:dataSource-transport>--%>
                                        <%--<kendo:dataSource-transport-read url="${codeUrl}/COGROUPID" type="POST" contentType="application/json"/>--%>
                                        <%--<kendo:dataSource-transport-parameterMap>--%>
                                            <%--function(options){--%>
                                            <%--return JSON.stringify(options);--%>
                                            <%--}--%>
                                        <%--</kendo:dataSource-transport-parameterMap>--%>
                                    <%--</kendo:dataSource-transport>--%>
                                    <%--<kendo:dataSource-schema data="data" total="total">--%>
                                    <%--</kendo:dataSource-schema>--%>
                                <%--</kendo:dataSource>--%>
                            <%--</kendo:dropDownList>--%>
                        <%--</td>--%>
                        <th>배기형식</th>
                        <td>
                            <kendo:dropDownList name="cmb_exhaustReg_search" dataTextField="codeNm"
                                                data-value-primitive="true"
                                                dataValueField="codeCd"
                                                data-bind="value: criteria.exhaustReg"
                                                optionLabel="전체" style="width: 100%;">
                                <kendo:dataSource>
                                    <kendo:dataSource-transport>
                                        <kendo:dataSource-transport-read url="${codeUrl}/C006" type="POST" contentType="application/json"/>
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
                        <th>사용여부</th>
                        <td>
                            <kendo:dropDownList name="cmb_useYn_search" dataTextField="codeNm"
                                                data-value-primitive="true"
                                                dataValueField="codeCd"
                                                data-bind="value: criteria.useYn"
                                                optionLabel="전체" style="width: 100%;">
                                <kendo:dataSource>
                                    <kendo:dataSource-transport>
                                        <kendo:dataSource-transport-read url="${codeUrl}/C020" type="POST" contentType="application/json"/>
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
                        <th>품명</th>
                        <td>
                            <input type="text" id="exchangeNm_search" data-bind="value: criteria.exchangeNm" />
                        </td>
                        <th>고객품번</th>
                        <td>
                            <input type="text" id="hmc_search" data-bind="value: criteria.hmc" />
                        </td>
                        <th>덴소품번</th>
                        <td>
                            <input type="text" id="denso_search" data-bind="value: criteria.denso" />
                        </td>
                        <th>엔진명</th>
                        <td>
                            <kendo:dropDownList name="cmb_engineType_search" dataTextField="codeNm"
                                                data-value-primitive="true"
                                                dataValueField="codeCd"
                                                data-bind="value: criteria.engineType"
                                                optionLabel="전체" style="width: 100%;">
                                <kendo:dataSource>
                                    <kendo:dataSource-transport>
                                        <kendo:dataSource-transport-read url="${codeUrl}/C021" type="POST" contentType="application/json"/>
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
                        <td>
                            <button type="submit" value="submit" class="button"><i class="w_search"></i>검색
                            </button>
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
        <div class="left" style="width:70%;">
            <div style="margin-bottom:10px;"></div>
            <div id="grid" data-grid-type="view"></div>
        </div>
        <div id="form_container" class="right" style="width:28%;">
            <div class="wrap">
                <form id="frm_input" method="post">
                    <input type="hidden" id="id_input" data-bind="value: data.id" disabled='disabled' />
                    <fieldset>
                        <table class="bWrite">
                            <colgroup>
                                <col style="width:130px"/>
                                <col/>
                            </colgroup>
                            <tbody>
                            </tr>

                            <tr>
                                <th scope="row"><label for="cmb_maker_input">메이커</label>
                                </th>
                                <td>
                                    <kendo:dropDownList name="cmb_maker_input" dataTextField="codeNm"
                                                        dataValueField="codeCd"
                                                        data-value-primitive="true"
                                                        data-bind="value: data.maker"
                                                        disabled="disabled">
                                        <kendo:dataSource data="${makerItems}"/>
                                    </kendo:dropDownList>
                                </td>
                            </tr>

                            <tr>
                                <th scope="row"><label for="cmb_groupId_input">그룹</label>
                                </th>
                                <td>
                                    <kendo:dropDownList name="cmb_groupId_input" dataTextField="codeNm"
                                                        dataValueField="codeCd"
                                                        data-value-primitive="true"
                                                        data-bind="value: data.groupId"
                                                        disabled="disabled">
                                        <kendo:dataSource data="${groupIdItems}"/>
                                    </kendo:dropDownList>
                                </td>
                            </tr>

                            <tr>
                                <th scope="row"><label for="cmb_partDiv_input">부품구분</label>
                                </th>
                                <td>
                                    <kendo:dropDownList name="cmb_partDiv_input" dataTextField="codeNm"
                                                        dataValueField="codeCd"
                                                        data-value-primitive="true"
                                                        data-bind="value: data.partDiv"
                                                        disabled="disabled">
                                        <kendo:dataSource data="${partDivItems}"/>
                                    </kendo:dropDownList>
                                </td>
                            </tr>

                            <tr>
                                <th scope="row"><label for="cmb_exhaustReg_input">배기형식</label>
                                </th>
                                <td>
                                    <kendo:dropDownList name="cmb_exhaustReg_input" dataTextField="codeNm"
                                                        dataValueField="codeCd"
                                                        data-value-primitive="true"
                                                        data-bind="value: data.exhaustReg"
                                                        disabled="disabled">
                                        <kendo:dataSource data="${exhaustRegItems}"/>
                                    </kendo:dropDownList>
                                </td>
                            </tr>

                            <tr>
                                <th scope="row"><label for="cmb_engineType_input">엔진명</label>
                                </th>
                                <td>
                                    <kendo:dropDownList name="cmb_engineType_input" dataTextField="codeNm"
                                                        dataValueField="codeCd"
                                                        data-value-primitive="true"
                                                        data-bind="value: data.engineType"
                                                        disabled="disabled">
                                        <kendo:dataSource data="${engineTypeItems}"/>
                                    </kendo:dropDownList>
                                </td>
                            </tr>

                            <tr>
                                <th scope="row"><label for="exchangeNm_input">품명</label>
                                </th>
                                <td>
                                    <input type="text" id="exchangeNm_input" data-bind="value: data.exchangeNm" />
                                </td>
                            </tr>

                            <tr>
                                <th scope="row"><label for="hmc_input">고객품번</label>
                                </th>
                                <td>
                                    <input type="text" id="hmc_input" data-bind="value: data.hmc" />
                                </td>
                            </tr>

                            <tr>
                                <th scope="row"><label for="denso_input">덴소품번</label>
                                </th>
                                <td>
                                    <input type="text" id="denso_input" data-bind="value: data.denso" />
                                </td>
                            </tr>

                            <tr>
                                <th scope="row"><label for="partsCost_input">부품비</label>
                                </th>
                                <td>
                                    <input type="text" id="partsCost_input" data-bind="value: data.partsCost" />
                                </td>
                            </tr>

                            <tr>
                                <th scope="row"><label for="margin_input">마진</label>
                                </th>
                                <td>
                                    <input type="text" id="margin_input" data-bind="value: data.margin" />
                                </td>
                            </tr>

                            <tr>
                                <th scope="row"><label for="workHour_input">작업시간</label>
                                </th>
                                <td>
                                    <input type="text" id="workHour_input" data-bind="value: data.workHour" />
                                </td>
                            </tr>

                            <tr>
                                <th scope="row">
                                    <label for="cmb_useYn_input">사용여부</label>
                                </th>
                                <td>
                                    <kendo:dropDownList name="cmb_useYn_input" dataTextField="codeNm"
                                                        dataValueField="codeCd"
                                                        data-value-primitive="true"
                                                        data-bind="value: data.useYn"
                                                        disabled="disabled">
                                        <kendo:dataSource data="${useYnItems}"/>
                                    </kendo:dropDownList>
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

</div>

<script type="text/javascript">

    var _dicasPage = new DicasPage('${screenId}');
    var _openerPage = window.opener._dicasPage;

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
            rn: { type: 'string' }
            ,maker: { type: 'string' }
            ,exhaustReg: { type: 'string' }
            ,engineType: { type: 'string' }
            ,exchangeNm: { type: 'string' }
            ,hmc: { type: 'string' }
            ,denso: { type: 'string' }
            ,partDiv: { type: 'string' }
            ,useYn: { type: 'string' }
            ,groupId: { type: 'string' }
            ,partsCost: { type: 'number' }
            ,margin: { type: 'number' }
            ,workHour: { type: 'number' }
        }
    });

    var buttonView = kendo.observable({
        search: function() {
            searchView.submit();
        }
    });
    kendo.bind($("div.sub-con-wrap"), buttonView);


    var searchView = kendo.observable({
        rowKey: null,
        rowData: null,
        criteria: {
            grpCd: null,
        },
        submit: function () {
            // if (inputView.hasChanges()) {
            //     if (!confirm("변경된 데이터가 있습니다. 조회 하시겠습니까?")) {
            //         return;
            //     }
            // }
            goPage('grid1', 1);
            return false;
        }
    });
    kendo.bind($("#frm_search"), searchView);

    var inputView = kendo.observable({
        rowIndex: 0,
        rowKey: null,
        data: null,

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
        }
    });
    kendo.bind($("#form_container"), inputView);

    function setPageUI(type) {
        if (type == "init") {
            $("input[type]", "#form_container").each(function (i, v) {
                $(v).attr("disabled", true);
            });

        }
    }

    function goPage(gridId, page) {
        if (gridId == "grid1") {
            searchView.set("rowKey", null);
            searchView.set("rowData", null);
            net.readData(1, searchView.criteria.toJSON(), true);
        }
    }

    function convertUndefined(str) {
        if (str == "undefined" || str == "" || str =="null") {
            return null;
        } else {
            return str;
        }
    }

    $(document).ready(function () {

        cmbuseYnInput = $("#cmb_useYn_input", "#frm_input").data("kendoDropDownList");
        var useYnData = cmbuseYnInput.dataSource.data(), useYnItems = _dicasPage.getEditOptions(useYnData);

        cmbMakerInput = $("#cmb_maker_input", "#frm_input").data("kendoDropDownList");
        var makerData = cmbMakerInput.dataSource.data(), makerItems = _dicasPage.getEditOptions(makerData);

        cmbGroupIdInput = $("#cmb_groupId_input", "#frm_input").data("kendoDropDownList");
        var groupIdData = cmbGroupIdInput.dataSource.data(), groupIdItems = _dicasPage.getEditOptions(groupIdData);

        cmbPartDivInput = $("#cmb_partDiv_input", "#frm_input").data("kendoDropDownList");
        var partDivData = cmbPartDivInput.dataSource.data(), partDivItems = _dicasPage.getEditOptions(partDivData);

        cmbExhaustRegInput = $("#cmb_exhaustReg_input", "#frm_input").data("kendoDropDownList");
        var exhaustRegData = cmbExhaustRegInput.dataSource.data(), exhaustRegItems = _dicasPage.getEditOptions(exhaustRegData);

        cmbEgineTypeInput = $("#cmb_engineType_input", "#frm_input").data("kendoDropDownList");
        var engineTypeData = cmbEgineTypeInput.dataSource.data(), engineTypeItems = _dicasPage.getEditOptions(engineTypeData);

        validatable = $("#form_container").kendoValidator({validateOnBlur: false})
            .data("kendoValidator");

        var data = new codeMdl({
            maker: convertUndefined("${partNumberForm.maker}"),
            exhaustReg: convertUndefined("${partNumberForm.exhaustReg}"),
            engineType: convertUndefined("${partNumberForm.engineType}"),
            partDiv: convertUndefined("${partNumberForm.partDiv}"),
            exchangeNm: convertUndefined(decodeURI("${partNumberForm.exchangeNm}")),
            hmc: convertUndefined("${partNumberForm.hmc}"),
            useYn: 'Y'
        });
        searchView.set('criteria', data);

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
            columns: [

                { title: '순번', name: 'rn', align: 'center', width: 30 }
                ,{
                    title: '메이커',
                    name: 'maker',
                    align: 'center',
                    width: 40,
                    editOptions: {
                        type: 'select',
                        listItems: makerItems,
                        useViewMode: true
                    }
                }
                ,{
                    title: '그룹',
                    name: 'groupId',
                    align: 'center',
                    editOptions: {
                        type: 'select',
                        listItems: groupIdItems,
                        useViewMode: true
                    },
                    hidden : 'true'
                }
                ,{
                    title: '부품구분',
                    name: 'partDiv',
                    align: 'center',
                    width: 80,
                    editOptions: {
                        type: 'select',
                        listItems: partDivItems,
                        useViewMode: true
                    }
                }
                ,{
                    title: '배기형식',
                    name: 'exhaustReg',
                    align: 'center',
                    editOptions: {
                        type: 'select',
                        listItems: exhaustRegItems,
                        useViewMode: true
                    }
                }
                ,{
                    title: '엔진명',
                    name: 'engineType',
                    align: 'center',
                    editOptions: {
                        type: 'select',
                        listItems: engineTypeItems,
                        useViewMode: true
                    }
                }
                ,{ title: '품명', name: 'exchangeNm', align: 'center' }
                ,{ title: '고객품번', name: 'hmc', align: 'center' }
                ,{ title: '덴소품번', name: 'denso', align: 'center' }
                ,{ title: '부품비', name: 'partsCost', align: 'center' }
                ,{ title: '마진', name: 'margin', align: 'center', hidden : 'true' }
                ,{ title: '작업시간', name: 'workHour', align: 'center', hidden : 'true' }
                ,{
                    title: '사용여부',
                    name: 'useYn',
                    align: 'center',
                    width: 40,
                    editOptions: {
                        type: 'select',
                        listItems: useYnItems,
                        useViewMode: true
                    }
                }
                ,{ title: 'id', name: 'id', align: 'center', hidden : 'true' }
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
        }).on('dblclick', function (eventData) {
            _openerPage.codeHelpVal = JSON.stringify(this.getRow(eventData.rowKey));
            _isDirty = true;
            window.close();
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

        searchView.submit();
    });

</script>
