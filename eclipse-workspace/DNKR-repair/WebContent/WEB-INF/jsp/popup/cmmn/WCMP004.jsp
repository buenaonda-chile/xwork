<%-- [EN] Variable definition --%>
<%-- [JP] 変数定義 --%>
<c:url var="readUrl" value="/office/search"/>
<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] 画面ID (@ViewIdで定義) --%>
<c:set var="screenId" value="<%= request.getAttribute(Globals.SCREEN_ID_KEY) %>"/>

<h2>정비소도움</h2>
<a onclick="_isDirty=false;window.close();return false;" class="close ckd_close">창닫기</a>
<div class="popup_body">

    <div class="search1">
        <form id="frm_search" method="get" data-bind="events: {submit: submit}">
            <fieldset>
                <table>
                    <col style="width:120px"/>
                    <col/>
                    <col style="width:85px"/>
                    <tr>
                        <th>정비소명</th>
                        <td>
                            <input type="text" id="text_officeNm" data-bind="value: criteria.officeNm" />
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


    var searchView = kendo.observable({
        criteria: {
            deptCd: null,
            upDeptCd: null,
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

    $(document).ready(function() {


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
                {
                    title: '정비소코드',
                    name: 'officeCd',
                    align: 'center',
                },
                {
                    title: '정비소명',
                    name: 'officeNm',
                    align: 'center',

                }
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