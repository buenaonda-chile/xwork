<%-- [EN] Variable definition --%>
<%-- [JP] ???? --%>
<c:url var="codeUrl" value="/code/list.json"/>

<c:url var="readUrl" value="/office/search"/>
<c:url var="createUrl" value="/office/create"/>
<c:url var="updateUrl" value="/office/update"/>
<c:url var="deleteUrl" value="/office/delete"/>

<c:url var="readUrl2" value="/officedetail/search"/>
<c:url var="createUrl2" value="/officedetail/create"/>
<c:url var="updateUrl2" value="/officedetail/update"/>
<c:url var="deleteUrl2" value="/officedetail/delete"/>

<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] ??ID (@ViewId???) --%>
<c:set var="screenId" value="<%= request.getAttribute(Globals.SCREEN_ID_KEY) %>"/>

<div class="sub-con-wrap">
    <h2 class="subpage-tit">정비소관리</h2>
    <!-- 버튼들 -->
    <div class="sub-btn-group">
        <button id="btn_search" class="button" data-bind="click: search, visible: btnGrp0Visible"><i class="w_search"></i>검색</button>
        <button id="btn_add" class="button bc1" data-bind="click: add, visible: btnGrp0Visible"><i class="w_add"></i>추가</button>
        <button id="btn_save" class="button bc2" data-bind="click: save, visible: btnGrp1Visible"><i class="w_save"></i>저장</button>
        <button id="btn_cancel" class="button" data-bind="click: cancel, visible: btnGrp1Visible"><i class="w_cancel"></i>취소</button>
        <button id="btn_remove" class="button" data-bind="click: remove, visible: btnGrp2Visible"><i class="w_minus"></i>삭제</button>
    </div>
    <!-- /버튼들 -->
</div>

<%-- .search1 --%>
<div class="search1">
  <form id="frm_search" method="get" data-bind="events: {submit: submit}">
    <fieldset>
      <table>
        <%--<colgroup>--%>
          <%--<col style="width:100px"/>--%>
          <%--<col style="width:100px"/>--%>
          <%--<col style="width:100px"/>--%>
          <%--<col style="width:100px"/>--%>
          <%--<col style="width:100px"/>--%>
          <%--<col style="width:100px"/>--%>
          <%--<col style="width:100px"/>--%>
          <%--<col style="width:155px"/>--%>
          <%--<col style="width:100px"/>--%>
          <%--<col style="width:155px"/>--%>
          <%--<col/>--%>
        <%--</colgroup>--%>
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
                                      optionLabel="전체" style="width: 100%;">
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
                                      optionLabel="전체" style="width: 100%;">
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
              <th>자재구분</th>
              <td>
                  <kendo:dropDownList name="cmb_materialDiv_search" dataTextField="codeNm"
                                      data-value-primitive="true"
                                      dataValueField="codeCd"
                                      data-bind="value: criteria.materialDiv"
                                      optionLabel="전체" style="width: 100%;">
                      <kendo:dataSource>
                          <kendo:dataSource-transport>
                              <kendo:dataSource-transport-read url="${codeUrl}/CASEPMATR" type="POST" contentType="application/json"/>
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
              <td>&nbsp;</td>
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
                                        data-bind="value: data.maker">
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
                                        data-bind="value: data.useYn">
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
                                        data-bind="value: data.officeDiv">
                        <kendo:dataSource data="${officeDivItems}"/>
                    </kendo:dropDownList>
                </td>
                <th scope="row"><label for="officeNm_input">정비소명</label>
                </th>
                <td>
                    <input type="text" id="officeNm_input" data-bind="value: data.officeNm" />
                </td>
            </tr>

            <tr>
                <th scope="row"><label for="officeCd_input">정비소코드</label>
                </th>
                <td>
                    <input type="text" id="officeCd_input" data-bind="value: data.officeCd" />
                </td>
                <th scope="row"><label for="num_labor_input">공임</label>
                </th>
                <td>
                    <kendo:numericTextBox name="num_labor_input" format="###,###,###,###,###" min="0"
                                          data-bind="value: data.labor"/>
                </td>
                <!--<th scope="row"><label for="officeOriNm_input">정비소원명</label>
                </th>
                <td>
                    <input type="text" id="officeOriNm_input" data-bind="value: data.officeOriNm" />
                </td>-->
            </tr>

            <tr>
                <th scope="row"><label for="officeTel_input">대표번호</label>
                </th>
                <td>
                    <input type="text" id="officeTel_input" data-bind="value: data.officeTel" />
                </td>
                <th scope="row"><label for="fax_input">팩스</label>
                </th>
                <td>
                    <input type="text" id="fax_input" data-bind="value: data.fax" />
                </td>
            </tr>

            <tr>
                <th scope="row"><label for="cmb_officeCity_input">소재지</label>
                </th>
                <td>
                    <kendo:dropDownList name="cmb_officeCity_input" dataTextField="codeNm"
                                        dataValueField="codeCd"
                                        data-value-primitive="true"
                                        data-bind="value: data.officeCity" >
                        <kendo:dataSource data="${officeCityItems}"/>
                    </kendo:dropDownList>
                </td>
                <th scope="row"><label for="address_input">주소</label>
                </th>
                <td>
                    <input type="text" id="address_input" data-bind="value: data.address" />
                </td>
            </tr>


            <tr>
              <th scope="row"><label for="num_km100InRate_input">100Km이내</label>
              </th>
                <td>
                    <kendo:numericTextBox name="num_km100InRate_input" format="###.###" min="0"
                                      data-bind="value: data.km100InRate"/>
                </td>
              <th scope="row"><label for="num_km100OutRate_input">100Km이상</label>
              </th>
                <td>
                    <kendo:numericTextBox name="num_km100OutRate_input" format="###.###" min="0"
                                          data-bind="value: data.km100OutRate"/>
                </td>
            </tr>

            <tr>
                <th scope="row"><label for="num_hRate_input">기본_RATE</label>
                </th>
                <td>
                    <kendo:numericTextBox name="num_hRate_input" format="###,###,###,###,###" min="0"
                                          data-bind="value: data.hrate"/>
                </td>
                <th scope="row"><label for="cmb_materialDiv_input">자재구분</label>
                </th>
                <td>
                    <kendo:dropDownList name="cmb_materialDiv_input" dataTextField="codeNm"
                                        dataValueField="codeCd"
                                        data-value-primitive="true"
                                        data-bind="value: data.materialDiv">
                        <kendo:dataSource data="${materialDivItems}"/>
                    </kendo:dropDownList>
                </td>
            </tr>

            <tr>
                <kendo:dropDownList name="ddl" dataTextField="codeNm"
                                    dataValueField="codeCd"
                                    data-value-primitive="true" >
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
      <div class="btns">
          <div id="btn_group_3" class="right" data-bind="visible: btnGrp3Visible">
              <button type="button" id="btn_add2" class="button" data-bind="click: add2"><i class="b_plus"></i><span class="blind">행추가</span></button>
              <button type="button" id="btn_remove2" class="button" data-bind="click: remove2"><i class="b_minus"></i><span class="blind">행삭제</span></button>
          </div>
      </div>
      <!-- /버튼 -->
      <!-- 추가 그리드 START -->
      <div>
          <div style="margin-bottom:10px;"></div>
          <div id="grid2"></div>
      </div>
      <!-- /추가 그리드 END -->
  </div>

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
     maker: { type: 'string' }
	,groupId: { type: 'string' }
	,officeDiv: { type: 'string' }
	,partDiv: { type: 'string' }
	,officeCd: { type: 'string' }
	,officeCity: { type: 'string' }
	,officeNm: { type: 'string' }
	,officeOriNm: { type: 'string' }
	,officeTel: { type: 'string' }
	,fax: { type: 'string' }
	,address: { type: 'string' }
	,expatNm: { type: 'string' }
	,expatTel: { type: 'string' }
	,partMaintenance: { type: 'string' }
	,useYn: { type: 'string' }
	,labor: { type: 'number' }
	,hRate: { type: 'number' }
     ,hrate: { type: 'number' }
	,km100InRate: { type: 'double' }
	,km100OutRate: { type: 'double' }
	,materialDiv: { type: 'string' }

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
      btnGrp0Visible: true,
      btnGrp1Visible: false,
      btnGrp2Visible: false,
      search: function() {
          searchView.submit();
      },
      add: function() {

          var dataItem = new codeMdl().toJSON();
          grid.prependRow(dataItem, {focus: true});
          inputView.set('rowKey', grid.getRowAt(0)['rowKey']);
          inputView.set('rowIndex', 0)
          inputView.set('data', dataItem);
          this.set('btnGrp1Visible', true);
          inputView.set('btnGrp3Visible', false);

          setPageUI('add');
      },
      remove: function() {
          grid.removeRow(inputView.get('rowKey'));
          buttonView.set('btnGrp1Visible', true);
          inputView.set('btnGrp3Visible', false);
      },
      save: function() {
          inputView.save();
      },
      cancel: function () {
          if (inputView.hasChanges() || inputView.hasChanges2() ) {
              if (!confirm("변경된 데이터가 있습니다. 취소 하시겠습니까?")) {
                  return;
              }
              grid.enable();
              grid.restore();
              grid2.restore();
              this.set('btnGrp1Visible', false);
              inputView.set('btnGrp3Visible', true);
              // grid.focusAt(inputView.get('rowIndex'), 0);
              buttonView.search();
          } else {
              buttonView.search();
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
    }
  });
  kendo.bind($("#frm_search"), searchView);

  var inputView = kendo.observable({
    rowIndex: 0,
    rowKey: null,
    data: null,
    btnGrp3Visible: true,

    save: function () {
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
      } else if (grid.getModifiedRows().updatedRows.length > 0) {
          message = "변경된 데이터가 있습니다.  수정 하시겠습니까?";
          isupdate = true;
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
      } else {
          _dicasPage.maskClose();
      }

    },
    validate: function () {
      if (validatable == null) return true;
      return validatable.validate();
    },
    hasChanges: function () {
      return grid.isModified();
    },
    hasChanges2: function () {
      return grid2.isModified();
    },
    add2: function () {
        var dataItem = new codeMdl2().toJSON();
        grid2.prependRow(dataItem, {focus: true});

        var grid2Rowkey = grid2.getFocusedCell().rowKey
        grid2.setValue(grid2Rowkey, "officeCd", grid.getValue(inputView.get('rowKey'), "officeCd", true));
        // 저장버튼 활성화
        buttonView.set('btnGrp1Visible', true);

        //this.set('rowKey', grid2.getRowAt(0)['rowKey']);
        //this.set('rowIndex', 0)
        //this.set('data', dataItem);
        //this.set('btnGrp0Visible', true);

        //setPageUI('add');
    },
    remove2: function () {
        //alert(grid2.getFocusedCell());
        var grid2Rowkey = grid2.getFocusedCell().rowKey

        grid2.removeRow(grid2Rowkey);
        buttonView.set('btnGrp1Visible', true);
    },
  });

  function detailAjax() {

      if (grid2.getModifiedRows().createdRows.length > 0) {

          for (var i=0; i<grid2.getModifiedRows().createdRows.length; i++) {
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
      searchView.set("rowData", null);
      net.readData(1, searchView.criteria.toJSON(), true);
    }
  }

  <!-- 추가 그리드 START -->

  var grid2;
  var pagination2;
  var net2;

  <!-- 추가 그리드 END -->

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

    tui.Grid.applyTheme('clean');
    grid = new tui.Grid({
      el: $('#grid'),
      scrollX: false,
      scrollY: true,
      rowHeight: 40,
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

	 { title: 'No', name: 'rn', align: 'center', hidden: false, width: 50 }
	,{ title: '메이커', name: 'maker', align: 'center', hidden: true }
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
    ,{ title: 'H_RATE', name: 'hrate', align: 'center', hidden: true  }
	,{ title: 'KM100_IN_RATE', name: 'km100InRate', align: 'center' , hidden: true }
	,{ title: 'KM100_OUT_RATE', name: 'km100OutRate', align: 'center', hidden: true }
	,{ title: '자재구분', name: 'materialDiv', align: 'center', hidden: true }

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
          setPageUI('view');

            var searchView2 = kendo.observable({
                rowKey: null,
                rowData: null,
                criteria: {
                    officeCd: grid.getValue(eventData.rowKey,"officeCd", true),
                }
            });
            net2.readData(1, searchView2.criteria.toJSON(), true);
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

          <!-- 추가 그리드 START -->
          //alert(grid.getValue(0, "officeCd", true));

          //searchView.set("rowKey", "officeCd");
          //searchView.set("rowData", grid.getValue(0, "officeCd", true));
          //
          var gridRowkey = grid.getFocusedCell().rowKey

          var searchView2 = kendo.observable({
              rowKey: null,
              rowData: null,
              criteria: {
                  officeCd: grid.getValue(gridRowkey, "officeCd", true),
              }
          });
          net2.readData(1, searchView2.criteria.toJSON(), true);
          <!-- 추가 그리드 END -->
        }
    });

      <!-- 추가 그리드 START -->

      grid2 = new tui.Grid({
          el: $('#grid2'),
          scrollX: false,
          scrollY: true,
          rowHeight: 40,
          // keyColumnName: 'codeKey',
          useClientSort: false,
          showDummyRows: true,
          minBodyHeight: 30,
          bodyHeight: 600,
          pagination: true,
          selectionUnit: 'CELL',
          editingEvent: true,
          usageStatistics: false,
          columns: [

              { title: 'ID', name: 'id', align: 'center',hidden: true  }
              ,{ title: '메이커', name: 'maker', align: 'center' ,hidden: true }
              ,{ title: '사업소코드', name: 'officeCd', align: 'center', hidden: true }
              ,{ title: 'No', name: 'rn', align: 'center' }
              ,{ title: '이름/직위', name: 'mechanic', align: 'center' ,  editOptions: { type: 'text', maxLength: 20, useViewMode: false } }
              ,{ title: '전화번호', name: 'mechanicTel', align: 'center' ,  editOptions: { type: 'text', maxLength: 20, useViewMode: false} }
              ,{
                  title: '사용여부',
                  name: 'reprYn',
                  align: 'center',
                  editOptions: {
                      type: 'select',
                      listItems: reprYnItems,
                      useViewMode: false
                  },
                  hidden: true
              }
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
      }).on('focusChange', function (eventData) {
      });

      net2 = grid2.getAddOn('Net');
      pagination2 = grid2.getPagination();
      pagination2.on('afterMove', function (eventData) {
          if (grid2.getRowCount() > 0)
              grid2.focusAt(0, 0);
      });

      <!-- 추가 그리드 END -->

    setPageUI("init");
  });

</script>
