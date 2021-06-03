<%-- [EN] Variable definition --%>
<%-- [JP] ???? --%>
<c:url var="codeUrl" value="/code/list.json"/>

<c:url var="readUrl" value="/trainingAppRegist/searchOffice"/>
<%-- <c:url var="createUrl" value="/office/create"/> --%>
<%-- <c:url var="updateUrl" value="/office/update"/> --%>
<%-- <c:url var="deleteUrl" value="/office/delete"/> --%>

<c:url var="readUrl2" value="/trainingAppRegist/officeDetailSearch"/>
<%-- <c:url var="createUrl2" value="/officedetail/create"/> --%>
<%-- <c:url var="updateUrl2" value="/officedetail/update"/> --%>
<%-- <c:url var="deleteUrl2" value="/officedetail/delete"/> --%>

<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] ??ID (@ViewId???) --%>
<c:set var="screenId" value="<%= request.getAttribute(Globals.SCREEN_ID_KEY) %>"/>

<h2>정비소검색</h2>
<a onclick="_isDirty=false;window.close();return false;" class="close ckd_close">창닫기</a>

<div class="popup_body">
    <%-- .search1 --%>
    <div class="search1">
        <form id="frm_search" method="get" data-bind="events: {submit: submit}">
            <fieldset>
                <table>
                    <tr>
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
                        <th>정비소명</th>
                        <td>
                            <input type="text" id="officeNm_search" data-bind="value: criteria.officeNm" />
                        </td>
                        <th>CD/SD</th>
                        <td>
                            <kendo:dropDownList name="cmb_officeDiv_search" dataTextField="codeNm"
                                                data-value-primitive="true"
                                                dataValueField="codeCd"
                                                data-bind="value: criteria.officeDiv"
                                                optionLabel="전체" style="width: 120px;">
                                <kendo:dataSource>
                                    <kendo:dataSource-transport>
                                        <kendo:dataSource-transport-read url="${codeUrl}/COGROUPDIV" type="POST" contentType="application/json"/>
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
                        <th>소재지</th>
                        <td>
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
                        <%--<th>자재구분</th>--%>
                        <%--<td>--%>
                        <%--<kendo:dropDownList name="cmb_materialDiv_search" dataTextField="codeNm"--%>
                        <%--data-value-primitive="true"--%>
                        <%--dataValueField="codeCd"--%>
                        <%--data-bind="value: criteria.materialDiv"--%>
                        <%--optionLabel="전체" style="width: 100%;">--%>
                        <%--<kendo:dataSource>--%>
                        <%--<kendo:dataSource-transport>--%>
                        <%--<kendo:dataSource-transport-read url="${codeUrl}/CASEPMATR" type="POST" contentType="application/json"/>--%>
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
                        <th>부품구분</th>
                        <td>
                            <kendo:dropDownList name="cmb_partDiv_search" dataTextField="codeNm"
                                                data-value-primitive="true"
                                                dataValueField="codeCd"
                                                data-bind="value: criteria.partDiv"
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
                        <th>사용여부</th>
                        <td>
                            <kendo:dropDownList name="cmb_useYn_search" dataTextField="codeNm"
                                                data-value-primitive="true"
                                                dataValueField="codeCd"
                                                data-bind="value: criteria.useYn"
                                                optionLabel="전체" style="width: 120px;">
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
                        <td>
                            <button type="submit" value="submit" class="button"><i class="w_search"></i>검색</button>
                            <%--<button id="btn_save" class="button bc2" data-bind="click: save"><i class="w_save"></i>저장</button>--%>
                            <!--<button id="btn_remove" class="button" data-bind="click: remove"><i class="w_minus"></i>삭제</button>-->
                            <%--<button id="btn_cancel" class="button" data-bind="click: cancel"><i class="w_cancel"></i>닫기</button>--%>
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
            <!-- 오른쪽 첫번째 표 -->
            <div class="wrap">
                <form id="frm_input" method="post">
                    <fieldset>
                        <table class="bWrite">
                            <colgroup>
                                <col style="width:200px"/>
                                <col style="width:300px"/>
                                <col style="width:200px"/>
                                <col/>
                            </colgroup>
                            <tbody>

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

                            <tr>
                                <th scope="row"><label for="cmb_officeDiv_input">CD/SD</label>
                                </th>
                                <td>
                                    <kendo:dropDownList name="cmb_officeDiv_input" dataTextField="codeNm"
                                                        dataValueField="codeCd"
                                                        data-value-primitive="true"
                                                        data-bind="value: data.officeDiv"
                                                        disabled="disabled">
                                        <kendo:dataSource data="${officeDivItems}"/>
                                    </kendo:dropDownList>
                                </td>
                                <th scope="row"><label for="officeNm_input">정비소명</label>
                                </th>
                                <td>
                                    <input type="text" id="officeNm_input" data-bind="value: data.officeNm"/>
                                </td>
                            </tr>

                            <tr>
                                <th scope="row"><label for="officeCd_input">정비소코드</label>
                                </th>
                                <td>
                                    <input type="text" id="officeCd_input" data-bind="value: data.officeCd"/>
                                </td>
                                <th scope="row"><label for="num_labor_input">공임</label>
                                </th>
                                <td>
                                    <kendo:numericTextBox name="num_labor_input" format="###,###,###,###,###" min="0"
                                                          data-bind="value: data.labor"
                                                          disabled="disabled"/>
                                </td>
                            </tr>

                            <tr>
                                <th scope="row"><label for="officeTel_input">대표번호</label>
                                </th>
                                <td>
                                    <input type="text" id="officeTel_input" data-bind="value: data.officeTel"/>
                                </td>
                                <th scope="row"><label for="fax_input">팩스</label>
                                </th>
                                <td>
                                    <input type="text" id="fax_input" data-bind="value: data.fax"/>
                                </td>
                            </tr>

                            <tr>
                                <th scope="row"><label for="cmb_officeCity_input">소재지</label>
                                </th>
                                <td>
                                    <kendo:dropDownList name="cmb_officeCity_input" dataTextField="codeNm"
                                                        dataValueField="codeCd"
                                                        data-value-primitive="true"
                                                        data-bind="value: data.officeCity"
                                                        disabled="disabled">
                                        <kendo:dataSource data="${officeCityItems}"/>
                                    </kendo:dropDownList>
                                </td>
                                <th scope="row"><label for="address_input">주소</label>
                                </th>
                                <td>
                                    <input type="text" id="address_input" data-bind="value: data.address"/>
                                </td>
                            </tr>

                            <tr>
                                <th scope="row"><label for="num_km100InRate_input">100Km이내</label>
                                </th>
                                <td>
                                    <kendo:numericTextBox name="num_km100InRate_input" format="###,###,###,###,###" min="0"
                                                          data-bind="value: data.km100InRate"
                                                          disabled="disabled"/>
                                </td>
                                <th scope="row"><label for="num_km100OutRate_input">100Km이상</label>
                                </th>
                                <td>
                                    <kendo:numericTextBox name="num_km100OutRate_input" format="###,###,###,###,###" min="0"
                                                          data-bind="value: data.km100OutRate"
                                                          disabled="disabled"/>
                                </td>
                            </tr>

                            <tr>
                                <th scope="row"><label for="num_hRate_input">기본_RATE</label>
                                </th>
                                <td>
                                    <kendo:numericTextBox name="num_hRate_input" format="###,###,###,###,###" min="0"
                                                          data-bind="value: data.hrate"
                                                          disabled="disabled"/>
                                </td>
                                <th scope="row"><label for="cmb_materialDiv_input">자재구분</label>
                                </th>
                                <td>
                                    <kendo:dropDownList name="cmb_materialDiv_input" dataTextField="codeNm"
                                                        dataValueField="codeCd"
                                                        data-value-primitive="true"
                                                        data-bind="value: data.materialDiv"
                                                        disabled="disabled">
                                        <kendo:dataSource data="${materialDivItems}"/>
                                    </kendo:dropDownList>
                                </td>
                            </tr>

                            <tr>
                                <kendo:dropDownList name="ddl" dataTextField="codeNm"
                                                    dataValueField="codeCd"
                                                    data-value-primitive="true"
                                                    disabled="disabled">
                                    <kendo:dataSource data="${reprYnItems}"/>
                                </kendo:dropDownList>
                            </tr>

                            </tbody>
                        </table>
                    </fieldset>
                </form>
            </div>
            <!-- / 오른쪽 첫번째 표 -->
            <!-- 버튼 -->
            <%--<div class="btns">--%>
            <%--<div id="btn_group_3" class="left" data-bind="visible: btnGrp3Visible">--%>
            <%--<button id="btn_add2" class="button bc1" data-bind="click: add2"><i class="w_add"></i>행추가--%>
            <%--</button>--%>
            <%--</div>--%>
            <%--<div id="btn_group_4" class="right" data-bind="visible: btnGrp3Visible">--%>
            <%--<button id="btn_remove2" class="button" data-bind="click: remove2"><i class="w_minus"></i>행삭제--%>
            <%--</button>--%>
            <%--</div>--%>
            <%--</div>--%>
            <!-- /버튼 -->
            <!-- 버튼 -->
            <!-- <div class="btns">
                <div id="btn_group_3" class="right">
                    <button id="btn_save" class="button bc2" data-bind="click: save"><i class="w_save"></i>저장</button>
                    <button type="button" id="btn_add2" class="button" data-bind="click: add2"><i class="w_add"></i><span class="blind">행추가</span></button>
                    <button type="button" id="btn_remove2" class="button" data-bind="click: remove2"><i class="w_minus"></i><span class="blind">행삭제</span></button>
                </div>
            </div> -->
            <!-- /버튼 -->
            <!-- 추가 그리드 START -->
            <div>
                <div style="margin-bottom:10px;"></div>
                <div id="grid2"></div>
            </div>
            <!-- /추가 그리드 END -->
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
            maker: { type: 'string' }
            ,partDiv: { type: 'string' }
            ,officeCity: { type: 'string' }
            ,officeNm: { type: 'string' }
        }
    });

    var codeMdl2 = kendo.data.Model.define({
        ID: 'ID',
        fields: {
            maker: { type: 'string' }
            ,officeCd: { type: 'string' }
            ,rn: { type: 'number' }
            ,mechanic: { type: 'string' }
            ,mechanicTel: { type: 'string' }
            ,reprYn: { type: 'string' }
            ,groupId: { type: 'string' }
            ,officeDiv: { type: 'string' }
            ,partDiv: { type: 'string' }

        }
    });

    var buttonView = kendo.observable({
        search: function() {
            searchView.submit();
        },
    });

    var searchView = kendo.observable({
        rowKey: null,
        rowData: null,
        criteria: {
            grpCd: null,
        },
        submit: function () {
             if (inputView.hasChanges()) {
                 if (!confirm("변경된 데이터가 있습니다. 조회 하시겠습니까?")) {
                     return;
                 }
             }
            goPage('grid1', 1);
            return false;
        },
        remove: function() {
            grid.removeRow(inputView.get('rowKey'));
        },
        save: function() {
            inputView.save();
        },
        cancel: function () {
            if (inputView.hasChanges()) {
                if (!confirm("변경된 데이터가 있습니다. 취소 하시겠습니까?")) {
                    return;
                }
            }
            _isDirty=false;
            window.close();
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
        },
        /* save: function () {
            if (!inputView.validate()) {
                alert('필수 항목을 입력해 주십시오.');
                return;
            }
            var message = "", iscreate = false, isupdate = false, isdelete = false, ischildUpdate = false;
            if (grid.getModifiedRows().createdRows.length > 0) {
                message = "변경된 데이터가 있습니다.  등록 하시겠습니까?";
                iscreate = true;
            } else if (grid.getModifiedRows().updatedRows.length > 0) {
                message = "변경된 데이터가 있습니다.  수정 하시겠습니까?";
                isupdate = true;
            } else if (grid.getModifiedRows().deletedRows.length > 0) {
                message = "변경된 데이터가 있습니다.  삭제 하시겠습니까?";
                isdelete = true;
            } else if (grid2.getModifiedRows().createdRows.length > 0 ||
                grid2.getModifiedRows().updatedRows.length > 0 ||
                grid2.getModifiedRows().deletedRows.length > 0
            ) {
                message = "변경된 데이터가 있습니다.  수정 하시겠습니까?";
                ischildUpdate = true;
            }

            if (inputView.hasChanges() || ischildUpdate) {
                if (!confirm(message)) {
                    return;
                }
            }

            var dataMap = grid.getModifiedRows({
                checkedOnly: false
            });
            // _dicasPage.maskOpen();

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
                    // 디테일 데이터 등록,수정,삭제
                    detailAjax();
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
            } else if (ischildUpdate) {

                // 디테일 데이터 등록,수정,삭제
                detailAjax();
                _dicasPage.maskClose();
                goPage('grid1', 1);
            }

        }, */
        add2: function () {
            var dataItem = new codeMdl2().toJSON();
            //grid2.prependRow(dataItem, {focus: true});
            grid2.appendRow(dataItem, {focus: true});

            var grid2Rowkey = grid2.getFocusedCell().rowKey;
            grid2.setValue(grid2Rowkey, "officeCd", grid.getValue(inputView.get('rowKey'), "officeCd", true));
            // 저장버튼 활성화
            //searchView.set('btnGrp1Visible', true);

            //this.set('rowKey', grid2.getRowAt(0)['rowKey']);
            //this.set('rowIndex', 0)
            //this.set('data', dataItem);
            //this.set('btnGrp0Visible', true);

            //setPageUI('add');
        },
        /* remove2: function () {
            //alert(grid2.getFocusedCell());
            var grid2Rowkey = grid2.getFocusedCell().rowKey;

            grid2.removeRow(grid2Rowkey);
            //searchView.set('btnGrp1Visible', true);
        }, */
    });

    function detailAjax() {

        if (grid2.getModifiedRows().createdRows.length > 0) {

            for (var i=0; i<grid2.getModifiedRows().createdRows.length; i++) {

                //alert(JSON.stringify(grid2.getModifiedRows().createdRows[i]));

                $.ajax({
                    method: "POST",
                    url: '${createUrl2}',
                    data: JSON.stringify(grid2.getModifiedRows().createdRows[i]),
                    contentType: 'application/json;charset=UTF-8'
                }).done(function (data, status, jqXHR) {
                    //
                }).fail(function (data, status, jqXHR) {
                    alert("저장 중 오류가 발생하였습니다.");
                });
            }

        }
        if (grid2.getModifiedRows().updatedRows.length > 0) {

            for (var i=0; i<grid2.getModifiedRows().updatedRows.length; i++) {

                //alert(JSON.stringify(grid2.getModifiedRows().updatedRows[i]));

                $.ajax({
                    method: "POST",
                    url: '${updateUrl2}',
                    data: JSON.stringify(grid2.getModifiedRows().updatedRows[i]),
                    contentType: 'application/json;charset=UTF-8'
                }).done(function (data, status, jqXHR) {
                    //
                }).fail(function (data, status, jqXHR) {
                    alert("저장 중 오류가 발생하였습니다.");
                });
            }

        }
        if (grid2.getModifiedRows().deletedRows.length > 0) {

            for (var i=0; i<grid2.getModifiedRows().deletedRows.length; i++) {
                $.ajax({
                    method: "POST",
                    url: '${deleteUrl2}',
                    data: JSON.stringify(grid2.getModifiedRows().deletedRows[i]),
                    contentType: 'application/json;charset=UTF-8'
                }).done(function (data, status, jqXHR) {
                    //
                }).fail(function (data, status, jqXHR) {
                    alert("저장 중 오류가 발생하였습니다.");
                });
            }

        }
    }

    inputView.bind('change', function (e) {

        if (e.field.indexOf('data.') > -1) {

            var itemNm = e.field.substr(5);
            grid.setValue(this.get('rowKey'), itemNm, this.get(e.field));
            //if (this.hasChanges()) {
            //    searchView.set('btnGrp1Visible', false);
            //} else {
            //    searchView.set('btnGrp1Visible', false);
            //}
        }
    });
    kendo.bind($("#form_container"), inputView);

    function setPageUI(type) {
        if (type == "init") {
            $("input[type]", "#form_container").each(function (i, v) {
                $(v).attr("disabled", true);
            });

        } else if (type == 'view') {

            $("input[type]", "#form_container").each(function (i, v) {
                $(v).attr("disabled", true);
            });

        }
    }

    function goPage(gridId, page) {
        if (gridId == "grid1") {
            grid.clear();
            searchView.set("rowKey", null);
            searchView.set("rowData", null);
            net.readData(1, searchView.criteria.toJSON(), true);
        }
    }

    <!-- 추가 그리드 START -->

    var grid2;
    var pagination2;
    var net2;

    <!-- 추가 그리드 END -->

    function convertUndefined(str) {
        if (str == "undefined" || str == "" || str == "null") {
            return null;
        } else {
            return str;
        }
    }

    $(document).ready(function () {

        cmbuseYnInput = $("#cmb_useYn_input", "#frm_input").data("kendoDropDownList");
        var useYnData = cmbuseYnInput.dataSource.data(), useYnItems = _dicasPage.getEditOptions(useYnData);

        cmbMakerInput = $("#cmb_maker_input", "#frm_input").data("kendoDropDownList");
        //var makerData = cmbMakerInput.dataSource.data(), makerItems = _dicasPage.getEditOptions(makerData);

        cmbOfficeDivInput = $("#cmb_officeDiv_input", "#frm_input").data("kendoDropDownList");
        //var officeDivData = cmbOfficeDivInput.dataSource.data(), officeDivItems = _dicasPage.getEditOptions(officeDivData);

        cmbOfficeCityInput = $("#cmb_officeCity_input", "#frm_input").data("kendoDropDownList");
        //var officeCityData = cmbOfficeCityInput.dataSource.data(), officeCityItems = _dicasPage.getEditOptions(officeCityData);

        cmbMaterialDivInput = $("#cmb_materialDiv_input", "#frm_input").data("kendoDropDownList");
        //var marerialDivData = cmbMaterialDivInput.dataSource.data(), marerialDivItems = _dicasPage.getEditOptions(marerialDivData);

        var dropdownlist = $("#ddl").data("kendoDropDownList");
        dropdownlist.wrapper.hide();
        var reprYnData = dropdownlist.dataSource.data(), reprYnItems = _dicasPage.getEditOptions(reprYnData);

        validatable = $("#form_container").kendoValidator({validateOnBlur: false})
            .data("kendoValidator");

        var data = new codeMdl({
            maker: convertUndefined("${officeForm.maker}"),
            officeNm: convertUndefined(decodeURI("${officeForm.officeNm}")),
            officeCity: convertUndefined("${officeForm.officeCity}"),
            <%--partDiv: convertUndefined("${officeForm.partDiv}"),--%>
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

                { title: 'No', name: 'rn', align: 'center', width: 50}
                ,{ title: '메이커', name: 'maker', align: 'center', hidden: true , }
                ,{ title: '그룹', name: 'groupId', align: 'center', hidden: true }
                ,{ title: '사업소구분', name: 'officeDiv', align: 'center', hidden: true }
                ,{ title: '부품종류', name: 'partDiv', align: 'center', hidden: true }
                ,{ title: '정비소코드', name: 'officeCd', align: 'center' }
                ,{ title: '소재지', name: 'officeCity', align: 'center', hidden: true }
                ,{ title: '정비소명', name: 'officeNm', align: 'center' }
                ,{ title: '사업소원명', name: 'officeOriNm', align: 'center', hidden: true }
                ,{ title: '대표번호', name: 'officeTel', align: 'center', hidden: true }
                ,{ title: '팩스', name: 'fax', align: 'center', hidden: true }
                ,{ title: '주소', name: 'address', align: 'center', hidden: true }
                ,{ title: '주재원', name: 'expatNm', align: 'center', hidden: true }
                ,{ title: '주재원전화', name: 'expatTel', align: 'center', hidden: true }
                ,{ title: '부분정비', name: 'partMaintenance', align: 'center', hidden: true }
                ,{
                    title: '사용여부',
                    name: 'useYn',
                    align: 'center',
                    editOptions: {
                        type: 'select',
                        listItems: useYnItems,
                        useViewMode: true
                    },
                    hidden: true
                }
                ,{ title: '공임', name: 'labor', align: 'center', hidden: true }
                ,{ title: 'H_RATE', name: 'hrate', align: 'center', hidden: true }
                ,{ title: 'KM100_IN_RATE', name: 'km100InRate', align: 'center', hidden: true }
                ,{ title: 'KM100_OUT_RATE', name: 'km100OutRate', align: 'center', hidden: true }
                ,{ title: '자재구분', name: 'materialDiv', align: 'center', hidden: true }
                ,{ title: '이름/직위', name: 'mechanic', align: 'center', hidden: true }
                ,{ title: '전화번호', name: 'mechanicTel', align: 'center', hidden: true }
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

            var mechanic;
            var mechanicTel;

            var cnt = grid2.getRowCount();
            for (var i=0; i<cnt; i++) {
                var grid2Data = grid2.getRowAt(i);
                var grid2RowKey = grid2Data.rowKey;

                if (grid2.getValue(grid2RowKey, 'reprYn') == 1) {
                    mechanic = grid2.getValue(grid2RowKey, 'mechanic');
                    mechanicTel = grid2.getValue(grid2RowKey, 'mechanicTel');
                    break;
                }
            }

            grid.setValue(eventData.rowKey, 'mechanic', mechanic);
            grid.setValue(eventData.rowKey, 'mechanicTel', mechanicTel);

            _openerPage.codeHelpVal = JSON.stringify(this.getRow(eventData.rowKey));
            _isDirty = true;
            window.close();
        }).on('focusChange', function (eventData) {

            if (inputView.hasChanges()) {
                eventData.stop();
            } else {
                if (eventData.prevRowKey != eventData.rowKey) {

                    var rowIndex = this.getIndexOfRow(eventData.rowKey);
                    inputView.set("rowIndex", rowIndex);
                    inputView.set("rowKey", eventData.rowKey);

                    inputView.set('data', this.getRow(eventData.rowKey));
                    //searchView.set('btnGrp2Visible', false);
                    setPageUI('view');

                    var searchView2 = kendo.observable({
                        rowKey: null,
                        rowData: null,
                        criteria: {
                            officeCd: grid.getValue(eventData.rowKey,"officeCd", true),
                        }
                    });
                    grid2.clear();
                    net2.readData(1, searchView2.criteria.toJSON(), true);
                }
            }
        });

        net = grid.getAddOn('Net');
        pagination = grid.getPagination();
        pagination.on('afterMove', function (eventData) {
            //searchView.set('btnGrp1Visible', false);
            if (grid.getRowCount() > 0) {
                grid.focusAt(0, 0);

                <!-- 추가 그리드 START -->
                //alert(grid.getValue(0, "officeCd", true));

                //searchView.set("rowKey", "officeCd");
                //searchView.set("rowData", grid.getValue(0, "officeCd", true));
                //
                var gridRowkey = grid.getFocusedCell().rowKey;

                var searchView2 = kendo.observable({
                    rowKey: null,
                    rowData: null,
                    criteria: {
                        officeCd: grid.getValue(gridRowkey, "officeCd", true),
                    }
                });
                grid2.clear();
                net2.readData(1, searchView2.criteria.toJSON(), true);
                <!-- 추가 그리드 END -->
            }
        });

        <!-- 추가 그리드 START -->

        grid2 = new tui.Grid({
            el: $('#grid2'),
            scrollX: false,
            scrollY: true,
            rowHeight: 30,
            // keyColumnName: 'codeKey',
            useClientSort: false,
            showDummyRows: true,
            minBodyHeight: 30,
            bodyHeight: 300,
            pagination: true,
            selectionUnit: 'CELL',
            editingEvent: true,
            usageStatistics: false,
            columns: [

                { title: 'ID', name: 'id', align: 'center',hidden: true  }
                ,{ title: '메이커', name: 'maker', align: 'center' ,hidden: true }
                ,{ title: '사업소코드', name: 'officeCd', align: 'center', hidden: true }
                ,{ title: '사업소명', name: 'officeNm', align: 'center', hidden: true }
                ,{ title: '대표', name: 'reprYn', align: 'center',
                    editOptions: {
                        type: 'checkbox',
                        listItems: [
                            { text: '', value: '1' }
                        ],
                        useViewMode: false
                    }
                    ,onAfterChange: function(ev) {

                        if (ev.value == '1') {
                            var cnt = grid2.getRowCount();
                            for (var i=0; i<cnt; i++) {
                                var gridData = grid2.getRowAt(i);
                                if (gridData.rowKey != ev.rowKey) {
                                    grid2.setValue(gridData.rowKey, 'reprYn', null);
                                }
                            }
                        }
                    }
                }
                ,{ title: 'No', name: 'rn', align: 'center' }
                ,{ title: '이름/직위', name: 'mechanic', align: 'center' ,  editOptions: { type: 'text', maxLength: 20, useViewMode: false } }
                ,{ title: '전화번호', name: 'mechanicTel', align: 'center' ,  editOptions: { type: 'text', maxLength: 20, useViewMode: false } }
                ,{ title: '그룹', name: 'groupId', align: 'center', hidden: true }
                ,{ title: '사업소구분', name: 'officeDiv', align: 'center', hidden: true }
                ,{ title: '부품종류', name: 'partDiv', align: 'center', hidden: true }
            ]
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

        }).on('successResponse', function (data) {
        }).on('failResponse', function (data) {
        }).on('errorResponse', function (data) {
        }).on('click', function (eventData) {
            console.log(eventData);
            if (eventData.columnName == 'reprYn') {
                grid2.setValue(eventData.rowKey, 'reprYn', '1');
            }
        }).on('dblclick', function (eventData) {
            console.log(eventData);
            if (eventData.columnName == 'reprYn') {
                grid2.setValue(eventData.rowKey, 'reprYn', '1');
            }
            //_openerPage.codeHelpVal = JSON.stringify(this.getRow(eventData.rowKey));
            //_isDirty = true;
            //window.close();
        }).on('focusChange', function (eventData) {
        });

        net2 = grid2.getAddOn('Net');
        pagination2 = grid2.getPagination();
        pagination2.on('afterMove', function (eventData) {
            if (grid2.getRowCount() > 0)
                grid2.focusAt(0, 0);
        });

        <!-- 추가 그리드 END -->

        setPageUI("view");

        searchView.submit();
    });

</script>
