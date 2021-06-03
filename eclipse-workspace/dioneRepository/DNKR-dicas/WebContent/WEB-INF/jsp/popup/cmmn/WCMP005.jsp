<%-- [EN] Variable definition --%>
<%-- [JP] 変数定義 --%>
<c:url var="codeUrl" value="/code/list.json" />

<c:url var="readUrl" value="/popup/claimVehicle/search"/>
<%--<c:url var="readUrl2" value="/popup/vehicleView/search"/>--%>

<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] 画面ID (@ViewIdで定義) --%>
<c:set var="screenId" value="<%= request.getAttribute(Globals.SCREEN_ID_KEY) %>"/>
<c:url var="popupUrl1" value="/popup/models/init"/>
<c:url var="popupUrl2" value="/popup/office2/init"/>
<c:url var="popupUrl3" value="/popup/partNumber/init"/>

<h2>차량검색</h2>
<a onclick="_isDirty=false;window.close();return false;" class="close ckd_close">창닫기</a>
<div class="popup_body">
       <form id="frm_search" method="get" data-bind="events: {submit: submit}">
            <fieldset>
                <table>
                    <tr>
                        <td>
                            <select name="date_search_option" id="date_search_option" data-bind="value: criteria.dateSearchOption">
                                <option value="01" >접수일</option>
                                <option value="02" >판매일</option>
                                <option value="03" >생산일</option>
                            </select>
                        </td>
                        <td colspan="3">
                            <input type="text" id="searchResultDateFr" data-bind="value: criteria.searchResultDateFr"  class="calendar" /> - <input
                                type="text" id="searchResultDateTo"  data-bind="value: criteria.searchResultDateTo" class="calendar" />
                        </td>
                        <th>차종</th>
                        <td>
                            <input type="text" id="text_model" data-bind="value: criteria.model" />
                        </td>
                        <td>
                            <button type="button" class="button" data-bind="click: popup1">
                                <i class="b_nwin"></i>팝업
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
                                        <kendo:dataSource-transport-read url="${codeUrl}/CLRSN" type="POST" contentType="application/json"/>
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
                            <input type="text" id="officeNm" data-bind="value: criteria.officeNm"/>
                        </td>
                        <td>
                            <button type="button" class="button" data-bind="click: popup2">
                                <i class="b_nwin"></i>팝업
                            </button>
                        </td>
                    </tr>
                    <tr>
                        <th style="width: 80px">CS/RS</th>
                        <td>
                            <select name="csrs_search_option" id="csrs_search_option" data-bind="value: criteria.csrsSearchOption" style="width:120px">
                                <option value="">전체</option>
                                <option value="CS">CS</option>
                                <option value="RS">RS</option>
                            </select>
                        </td>

                        <th>메이커</th>
                        <td>
                            <kendo:dropDownList name="cmb_maker_search" dataTextField="codeNm"
                                                data-value-primitive="true"
                                                dataValueField="codeCd"
                                                data-bind="value: criteria.maker"
                                                optionLabel="전체" style="width: 120px;">
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
                        <th>승상용</th>
                        <td>
                            <kendo:dropDownList name="cmb_tireStd_search" dataTextField="codeNm"
                                                data-value-primitive="true"
                                                dataValueField="codeCd"
                                                data-bind="value: criteria.tireStd"
                                                optionLabel="전체" style="width: 120px;">
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
                        <td>&nbsp;</td>
                        <th>부품구분</th>
                        <td colspan="2">
                            <kendo:dropDownList name="cmb_inquiryGubun_search" dataTextField="codeNm"
                                                data-value-primitive="true"
                                                dataValueField="codeCd"
                                                data-bind="value: criteria.inquiryGubun"
                                                optionLabel="전체" style="width: 120px;">
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
                        <th>품질문제명</th>
                        <td>
                            <kendo:dropDownList name="cmb_qualityProblemNm_input" dataTextField="qualityProblemNm"
                                                dataValueField="id"
                                                data-value-primitive="true"
                                                data-bind="value: criteria.qualityProblemNm"
                                                optionLabel="전체"
                                                autoWidth="true">
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
                                        <kendo:dataSource-transport-read url="${codeUrl}/C011" type="POST" contentType="application/json"/>
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
                        <td>&nbsp;</td>
                        <th>고객품번</th>
                        <td colspan="2">
                            <input type="text" id="text_hmcPartNo" data-bind="value: criteria.hmcPartNo" style="width:140px" />
                        </td>
                        <th>VINNO</th>
                        <td>
                            <input type="text" id="text_vinno" data-bind="value: criteria.vinno"/>
                        </td>
                    </tr>
                    <tr>
                        <th>RO 등록</th>
                        <td>
                            <select name="ro_search_option" id="ro_search_option" data-bind="value: criteria.roSearchOption" style="width:120px">
                                <option value="" selected>전체</option>
                                <option value="Y" >포함</option>
                                <option value="N" >미포함</option>
                            </select>
                        </td>
                        <th>주행거리</th>
                        <td>
                            <kendo:numericTextBox name="text_mileage" id="text_mileage" format="###,###,###,###,###" min="0"  data-bind="value: criteria.mileage" style="width: 120px"/>
                        </td>
                        <th>판매국가</th>
                        <td>
                            <kendo:dropDownList name="cmb_saleCountry_search" dataTextField="codeNm"
                                                data-value-primitive="true"
                                                dataValueField="codeNm"
                                                data-bind="value: criteria.saleCountry"
                                                optionLabel="전체" style="width: 120px;">
                                <kendo:dataSource>
                                    <kendo:dataSource-transport>
                                        <kendo:dataSource-transport-read url="${codeUrl}/CASCO" type="POST" contentType="application/json"/>
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
                        <td>&nbsp;</td>
                        <th>GQNET No.</th>
                        <td colspan="2">
                            <input type="text" id="text_gqnetNo" data-bind="value: criteria.gqnetNo" style="width:140px" />
                        </td>
                        <th>R/O NO</th>
                        <td>
                            <input type="text" id="text_roNo" data-bind="value: criteria.roNo"/>
                        </td>
                        <td>
                            <button type="submit" value="submit" class="button"><i class="b_search"></i>검색
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

    var searchView = kendo.observable({
        criteria: {
            deptCd: null,
            upDeptCd: null,
        },
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
                // params: {
                //     codeVal: 'AAAA',
                //     codeVal1: 'BBBB'
                // },
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
                // params:{
                //     codeVal:'AAAA',
                //     codeVal1: 'BBBB'
                // },
                beforeOpen: function () {
                    _dicasPage.beforeCodeHelpVal = true;
                },
                afterClose: function (info) {
                    console.log(info);
                    if (info.result) {
                        var _data = JSON.parse(info.data);
                        that.set('criteria.officeNm', _data.officeNm);
                    } else {
                        that.set('criteria.officeNm', null);
                    }
                }
            });
        },
        popup3: function () {
            var that = this;
            _dicasPage.popupOpen({
                url: "${popupUrl3}",
                code: 'codeHelp',
                width: 1400,
                height: 800,
                // params: {
                //     codeVal: 'AAAA',
                //     codeVal1: 'BBBB'
                // },
                beforeOpen: function () {
                    _dicasPage.beforeCodeHelpVal = true;
                },
                afterClose: function (info) {
                    if (info.result) {
                        var _data = JSON.parse(info.data);
                        that.set('criteria.exchangeNm', _data.exchangeNm);
                    } else {
                        that.set('criteria.exchangeNm', null);
                    }
                }
            });
        }
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

    $(document).ready(function() {

        /* 옵션 selected */
        $("#date_search_option").val("01").change();
        $("#csrs_search_option").val("").prop("selected", true);
        $("#ro_search_option").val("").prop("selected", true);

        $( ".calendar" ).datepicker();

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
            showDummyRows: true,
            minBodyHeight: 30,
            bodyHeight: 600,
            pagination: true,
            selectionUnit: 'CELL',
            editingEvent: false,
            usageStatistics: false,
            columns: [
                { title: '번호', name: 'rn', align: 'center', width:50 }
                ,{ title: '접수일', name: 'receiptDate', align: 'center' }
                ,{ title: '상태', name: 'callStatus', align: 'center'  }
                ,{ title: 'CS/RS', name: 'csrs', align: 'center', width:50 }
                ,{ title: '정비소명', name: 'officeNm', align: 'center' , width:120 }
                ,{ title: 'R/O NO', name: 'roNo', align: 'center', width:250 }
                ,{ title: 'VIN NO', name: 'vinno', align: 'center', width:200  }
                ,{ title: '메이커', name: 'makerNm', align: 'center', width:60 }
                ,{ title: '배기형식', name: 'exhaustRegNm', align: 'center' }
                ,{ title: '엔진명', name: 'engineTypeNm', align: 'center' }
                ,{ title: '차종', name: 'model', align: 'center' }
                ,{ title: '현상', name: 'mainCategoryNm', align: 'center' }
                ,{ title: '주원인품명', name: 'replacePartNm', align: 'center' }
                ,{ title: '고품요청일', name: 'recallReqDate', align: 'center' }
                ,{ title: '진행', name: 'status', align: 'center' , width:50}
                ,{ title: '주행거리', name: 'mileage', align: 'center' , hidden: true }
                ,{ title: '고객품번', name: 'hmcPartNo', align: 'center' , hidden: true}
                ,{ title: 'masterId', name: 'masterId', align: 'center' , hidden: true }
                ,{ title: '판매일자', name: 'prodDate', align: 'center' , hidden: true }
                ,{ title: '생산일자', name: 'saleDate', align: 'center' , hidden: true }
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

    });

</script>