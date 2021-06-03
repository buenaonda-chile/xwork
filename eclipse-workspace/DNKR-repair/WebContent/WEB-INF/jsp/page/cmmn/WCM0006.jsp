<%-- [EN] Variable definition --%>
<%-- [JP] ???? --%>
<c:url var="codeUrl" value="/code/list.json"/>

<c:url var="readUrl" value="/user/search"/>
<c:url var="createUrl" value="/user/create"/>
<c:url var="updateUrl" value="/user/update"/>
<c:url var="deleteUrl" value="/user/delete"/>
<c:url var="passwordInitUrl" value="/user/password/init" />
<c:url var="passwordInitAllUrl" value="/user/password/init/all" />

<c:url var="popupOfficeUrl" value="/popup/office/init"/>


<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] ??ID (@ViewId???) --%>
<c:set var="screenId" value="<%= request.getAttribute(Globals.SCREEN_ID_KEY) %>"/>

<div class="sub-con-wrap">
  <h2 class="subpage-tit">유저관리</h2>
  <!-- 버튼들 -->
  <div class="sub-btn-group">
    <button id="btn_search" class="button" data-bind="click: search, visible: btnGrp0Visible"><i class="w_search"></i>검색</button>
    <button id="btn_add" class="button bc1" data-bind="click: add, visible: btnGrp0Visible"><i class="w_add"></i>추가</button>
    <button id="btn_save" class="button bc2" data-bind="click: save, visible: btnGrp1Visible"><i class="w_save"></i>저장</button>
    <button id="btn_cancel" class="button" data-bind="click: cancel, visible: btnGrp1Visible"><i class="w_cancel"></i>취소</button>
    <button id="btn_remove" class="button" data-bind="click: remove, visible: btnGrp2Visible"><i class="w_minus"></i>삭제</button>
    <sec:authorize access="hasAnyRole('ROLE_SYSTEM')">
      <button id="btn_passwdinit" class="button" data-bind="click: passwordAllInit, visible: passwdinit"><i class="w_claim"></i>일괄초기화</button>
    </sec:authorize>
  </div>
  <!-- /버튼들 -->
</div>

<%-- .search1 --%>
<div class="search1">
  <form id="frm_search" method="get" data-bind="events: {submit: submit}">
    <fieldset>
      <table>
        <colgroup>
          <col style="width:60px"/>
          <col style="width:200px"/>
          <col style="width:60px"/>
          <col style="width:155px"/>
          <col style="width:80px"/>
          <col style="width:155px"/>
          <col style="width:80px"/>
          <col style="width:155px"/>
          <col style="width:80px"/>
          <col style="width:155px"/>
          <col/>
        </colgroup>
        <th>조직</th>
        <td>
          <kendo:dropDownTree name="cmbDeptCd_search"
                              dataTextField="deptNm"
                              dataValueField="deptCd"
                              data-value-primitive="true"
                              data-bind="value: criteria.deptCd"
                              style="width:100%"
                              placeholder="조직">
            <kendo:dataSource data="${groupItems}">
              <kendo:dataSource-schema>
                <kendo:dataSource-schema-hierarchical-model children="items" id="deptCd" />
              </kendo:dataSource-schema>
            </kendo:dataSource>
          </kendo:dropDownTree>
        </td>
				<th>권한</th>
        <td>
          <kendo:dropDownList name="cmbRole_search"
                              dataTextField="roleNm"
                              dataValueField="roleCd"
                              data-value-primitive="true"
                              data-bind="value: criteria.roleCd"
                              optionLabel="전체">
            <kendo:dataSource data="${roleItems}"/>
          </kendo:dropDownList>
        </td>
        <th>사용자ID</th>
        <td>
          <input type="text" id="acctId_search" data-bind="value: criteria.acctId" />
        </td>
        <th>사용자명</th>
        <td>
          <input type="text" id="fstNm_search" data-bind="value: criteria.fulnm" />
        </td>
        <th>사용여부</th>
        <td>
          <kendo:dropDownList name="cmb_useYn_search" dataTextField="codeNm"
                              data-value-primitive="true"
                              dataValueField="codeCd"
                              data-bind="value: criteria.useYn"
                              optionLabel="전체" style="width: 100%;">
            <kendo:dataSource data="${useYnItems}" />
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
    <div class="wrap">
      <form id="frm_input" method="post">
        <fieldset>
          <table class="bWrite">
            <colgroup>
              <col style="width:130px"/>
              <col/>
            </colgroup>
            <tbody>
							<tr>
								<th scope="row"><label for="acctId_input">사용자ID <em class="required" title="필수항목">*</em></label>
								</th>
								<td>
									<input type="text" id="acctId_input" data-bind="value: data.acctId" placeholder="사용자ID" required="true"/>
								</td>
							</tr>
							<tr>
								<th scope="row"><label for="fstNm_input">성명 <em class="required" title="필수항목">*</em></label>
								</th>
								<td>
									<input type="text" id="lstNm_input" data-bind="value: data.lstNm" placeholder="Last Name" required="true" style="width:110px;"/>
									<input type="text" id="fstNm_input" data-bind="value: data.fstNm" placeholder="First Name" required="true" style="width:120px;"/>
								</td>
							</tr>
							<tr>
								<th scope="row"><label for="email_input">E-mail <em class="required" title="필수항목">*</em></label>
								</th>
								<td>
									<input type="email" id="email_input" data-bind="value: data.email" placeholder="이메일" />
								</td>
							</tr>
							<tr>
								<th scope="row"><label for="moblphonNo_input">휴대번호</label>
								</th>
								<td>
									<input type="tel" id="moblphonNo_input" data-bind="value: data.moblphonNo, events:{focus:telFocus, blur:telBlur}" placeholder="휴대번호" required="true" />
								</td>
							</tr>
							<tr>
								<th scope="row"><label for="telNo_input">전화번호</label>
								</th>
								<td>
									<input type="tel" id="telNo_input" data-bind="value: data.telNo, events:{focus:telFocus, blur:telBlur}" placeholder="전화번호" />
								</td>
							</tr>
							<tr>
								<th scope="row"><label for="cmbDeptCd_input">조직</label></th>
								<td>
									<kendo:dropDownTree name="cmbDeptCd_input"
																			dataTextField="deptNm"
																			dataValueField="deptCd"
																			change="onDeptChange"
																			style="width:155px;">
										<kendo:dataSource data="${groupItems}">
											<kendo:dataSource-schema>
												<kendo:dataSource-schema-hierarchical-model id="deptCd" children="items" />
											</kendo:dataSource-schema>
										</kendo:dataSource>
									</kendo:dropDownTree>
								</td>

							</tr>
							<tr>
								<th>권한</th>
								<td>
									<kendo:dropDownList name="cmbRole_input"
																			dataTextField="roleNm"
																			dataValueField="roleCd"
																			data-value-primitive="true"
																			data-bind="value: data.roleCd"
								  										style="width:155px;" required="true">
										<kendo:dataSource data="${roleItems}"/>
									</kendo:dropDownList>
								</td>
							</tr>
							<tr>
								<th scope="row"><label for="officeNm_input">정비소명</label>
								</th>
								<td>
									<input type="text" id="officeNm_input" data-bind="value: data.officeNm" placeholder="정비소" readonly />
									<span>
                  <button type="button" class="button" data-bind="click: popupOffice" >
                    <i class="b_nwin"></i>팝업
                  </button>
                </span>
								</td>
							</tr>
							<tr>
								<th scope="row">
									<label for="cmbUseYn_input">사용여부</label>
								</th>
								<td>
									<kendo:dropDownList name="cmbUseYn_input" dataTextField="codeNm"
																			dataValueField="codeCd"
																			data-value-primitive="true"
																			data-bind="value: data.useYn">
										<kendo:dataSource data="${useYnItems}"/>
									</kendo:dropDownList>
								</td>
							</tr>
							<tr>
								<th scope="row"><label>비밀번호</label>
								</th>
								<td>
									<button type="button" class="button" data-bind="click: passwordInit">초기화</button>
									<span class="ml-1">[<span class="text-info">${initPassword}</span>]로 초기화 됩니다.</span>
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

<script type="text/javascript">

  var _dicasPage = new DicasPage('${screenId}');

  <%-- Control Definition--%>
  var grid;
  var pagination;
  var net;
  var cmbRoleInput;
  var cmbDeptCdInput;
  var cmbDeptCdSearch;
  var cmbUseYnInput;
  var phoneNumber;
  <%--// Control Definition --%>

  <%-- Variable Definition --%>
  var validatable = null;
  <%--// Variable Definition --%>

  var codeMdl = kendo.data.Model.define({
    id: 'userId',
    fields: {
      userId: {
        type: 'string'
			},
			acctId: { type: 'string' },
			acctPw: { type: 'string' },
			email: { type: 'string' },
			telNo: { type: 'string' },
			moblphonNo: { type: 'string' },
			fstNm: { type: 'string' },
			mdlNm: { type: 'string' },
			lstNm: { type: 'string' },
			useYn: { type: 'string' },
			deptCd: {type: 'string'},
			roleCd: { type: 'string' },
			officeCd: { type: 'string' }

    }
  });

  var buttonView = kendo.observable({
    btnGrp0Visible: true,
    btnGrp1Visible: false,
    btnGrp2Visible: false,
    <sec:authorize access="hasAnyRole('ROLE_SYSTEM')">
		passwdinit: true,
    </sec:authorize>

    search: function() {
      searchView.submit();
    },
    add: function() {

      var dataItem = new codeMdl({
				useYn: "Y",
			}).toJSON();
      grid.prependRow(dataItem, {focus: true});

      inputView.set('rowKey', grid.getRowAt(0)['rowKey']);
      inputView.set('rowIndex', 0);
      inputView.set('data', dataItem);
      this.set('btnGrp1Visible', true);

      setPageUI('add');
    },
    remove: function() {
      grid.removeRow(inputView.get('rowKey'));
      buttonView.set('btnGrp1Visible', true);
    },
    save: function() {
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
    <sec:authorize access="hasAnyRole('ROLE_SYSTEM')">
    passwordAllInit: function() {

      if (!confirm("사용자 전원에 대해 비밀번호 초기화를 하시겠습니까?")) return;
      if (!confirm("정말 진행 하시겠습니까?")) return;

      _dicasPage.maskOpen();

      $.ajax({
        method: "POST",
        url: '${passwordInitAllUrl}',
        data: JSON.stringify(inputView.data),
        contentType: 'application/json;charset=UTF-8'
      }).done(function (data, status, jqXHR) {
        alert('사용자 전원에 대해 비밀번호를 초기화 하였습니다.');
      }).fail(function (data, status, jqXHR) {
        var message = JSON.parse(data.responseText).message;
        alert(message);
      }).always(function () {
        _dicasPage.maskClose();
      });
    }
    </sec:authorize>
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
      deptCd: null,
      acctId: null,
			fulnm: null,
      useYn: null
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
		passwordInit: function() {

      // if (inputView.data.userId != null) {
				_dicasPage.maskOpen();

				$.ajax({
					method: "POST",
					url: '${passwordInitUrl}',
					data: JSON.stringify(inputView.data),
					contentType: 'application/json;charset=UTF-8'
				}).done(function (data, status, jqXHR) {
				  alert('비밀번호를 초기화 하였습니다.');
				}).fail(function (data, status, jqXHR) {
				  var message = JSON.parse(data.responseText).message;
				  alert(message);
				}).always(function () {
					_dicasPage.maskClose();
				});
			// }
    },
    telFocus: function (e) {
      var value = $(e.currentTarget).val();
      if (value.length > 0) {
        $(e.currentTarget).val(value.replace(/-/g, ""));
      }
    },
    telBlur: function (e) {
      var value = $(e.currentTarget).val();

      if (value.length > 0) {
        phoneNumber.reset();
        value = phoneNumber.input(value);
        $(e.currentTarget).val(value);
      }
    },
    validate: function () {
      if (validatable == null) return true;
      return validatable.validate();
    },
    hasChanges: function () {

      return grid.isModified();
    },
    popupOffice: function() {
      var that = this;
      _dicasPage.popupOpen({
        url: "${popupOfficeUrl}",
        code: 'codeHelp',
        width: 500,
        height: 500,
        beforeOpen: function() {
          _dicasPage.beforeCodeHelpVal = true;
        },
        afterClose: function(info) {
          if (info.result) {
            var _data = JSON.parse(info.data);
            that.set('data.officeCd', _data.officeCd);
            that.set('data.officeNm', _data.officeNm);
          }
        }
      });
    }
  });
  inputView.bind('change', function (e) {

    if (e.field.indexOf('data.') > -1) {

      var itemNm = e.field.substr(5);
      grid.setValue(this.get('rowKey'), itemNm, this.get(e.field));

      if (inputView.hasChanges()) {
        buttonView.set('btnGrp1Visible', true);
      } else {
        buttonView.set('btnGrp1Visible', false);
      }
    } else if (e.field == 'data') {
      setTimeout(function() {
        <%-- 전화번호, 휴대폰 번호 대쉬 추가 --%>
        $("input[type=tel]", "#frm_input").each(function (i, v) {
          var value = $(v).val();
          if (value.length > 0) {
            phoneNumber.reset();
            value = phoneNumber.input(value);
            $(v).val(value);
          }
        });
      }, 100);
		}
  });
  kendo.bind($("#form_container"), inputView);

  function setPageUI(type) {
    if (type == "init") {
      $("input[type], button", "#form_container").each(function (i, v) {
        $(v).attr("disabled", true);
      });

      cmbDeptCdInput.enable(false);
      cmbRoleInput.enable(false);
      cmbUseYnInput.enable(false);

    } else if (type == 'view' || type == 'add') {

      $("input[type], button", "#form_container").each(function (i, v) {
        $(v).attr("disabled", false);
      });

      cmbDeptCdInput.enable(true);
      cmbRoleInput.enable(true);
      cmbUseYnInput.enable(true);
    }
  }

  function goPage(gridId, page) {
    if (gridId == "grid1") {
      searchView.set("rowKey", null);
      searchView.set("rowData", null);
      net.readData(1, searchView.criteria.toJSON(), true);
    }
  }

  function onDeptChange(e) {
    if (inputView.get('data.deptCd') != cmbDeptCdInput.value()) {
      inputView.set('data.deptCd', cmbDeptCdInput.value());
		}
	}

  $(document).ready(function () {

    phoneNumber = new libphonenumber.AsYouType('KR');

    cmbDeptCdInput = $("#cmbDeptCd_input", "#frm_input").data("kendoDropDownTree");
    cmbDeptCdSearch = $("#cmbDeptCd_search").data("kendoDropDownTree");

    cmbRoleInput = $("#cmbRole_input", "#frm_input").data("kendoDropDownList");
    var roleData = cmbRoleInput.dataSource.data(), roleItems = _dicasPage.getEditOptions(roleData);

    cmbUseYnInput = $("#cmbUseYn_input", "#frm_input").data("kendoDropDownList");
    var useYnData = cmbUseYnInput.dataSource.data(), useYnItems = _dicasPage.getEditOptions(useYnData);

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
      selectionUnit: 'row',
      editingEvent: false,
      usageStatistics: false,
      columns: [

        { title: 'No', name: 'userId', align: 'center', hidden: true }
        ,{ title: '사용자ID', name: 'acctId', align: 'center' }
        ,{ title: '성명', name: 'fulnm', align: 'center' }
        ,{
          title: '사용여부',
          name: 'useYn',
          align: 'center',
          editOptions: {
            type: 'select',
            listItems: useYnItems,
            useViewMode: true
          }
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
          if (this.getRow(eventData.rowKey).deptCd != null) {
            cmbDeptCdInput.value(this.getRow(eventData.rowKey).deptCd);
          } else {
            cmbDeptCdInput.value(null);
					}
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
      if (grid.getRowCount() > 0) {
        grid.focusAt(0, 0);
      }
    });

    setPageUI("init");
  });

</script>
