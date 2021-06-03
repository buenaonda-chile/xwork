<%-- [EN] Variable definition --%>
<%-- [JP] 変数定義 --%>
<c:url var="codeUrl" value="/code/list.json"/>

<c:url var="readUrl" value="/group/search"/>
<c:url var="createUrl" value="/group/create"/>
<c:url var="updateUrl" value="/group/update"/>
<c:url var="deleteUrl" value="/group/delete"/>

<c:url var="popupUrl" value="/popup/group/init"/>

<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] 画面ID (@ViewIdで定義) --%>
<c:set var="screenId" value="<%= request.getAttribute(Globals.SCREEN_ID_KEY) %>"/>

<style type="text/css">
  .ax-mask.edit .ax-mask-bg {
    background: #215efa;
    opacity: .1;
  }
</style>


<div class="sub-con-wrap">
  <h2 class="subpage-tit">조직관리</h2>
  <!-- 버튼들 -->
  <div class="sub-btn-group">
    <button id="btn_add" class="button bc1" data-bind="click: add, visible: visible.add"><i class="w_add"></i>추가</button>
    <button id="btn_save" class="button bc2" data-bind="click: save, visible: visible.save"><i class="w_save"></i>저장</button>
    <button id="btn_cancel" class="button" data-bind="click: cancel, visible: visible.cancel"><i class="w_cancel"></i>취소</button>
    <button id="btn_remove" class="button" data-bind="click: remove, visible: visible.remove"><i class="w_minus"></i>삭제</button>
  </div>
  <!-- /버튼들 -->
</div>

<%-- .search1 --%>
<div class="search1">
  <form id="frm_search" method="get" data-bind="events: {submit: submit}">
    <fieldset>
      <table>
        <colgroup>
          <col style="width:50px"/>
          <col style="width:155px"/>
          <%--<col style="width:80px"/>--%>
          <%--<col style="width:155px"/>--%>
          <col/>
        </colgroup>
        <tbody>
        <tr>
          <th>그룹</th>
          <td>
            <kendo:dropDownList name="cmb_groupId_search" dataTextField="codeNm"
                                data-value-primitive="true"
                                dataValueField="codeCd"
                                data-bind="value: criteria.groupId"
                                style="width: 100%;">
              <kendo:dataSource>
                <kendo:dataSource-transport>
                  <kendo:dataSource-transport-read url="${codeUrl}/COGROUPID" type="POST" contentType="application/json"/>
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
          <%--<th>사용여부</th>--%>
          <%--<td>--%>
            <%--<kendo:dropDownList name="cmb_useYn_search" dataTextField="codeNm"--%>
                                <%--data-value-primitive="true"--%>
                                <%--dataValueField="codeCd"--%>
                                <%--data-bind="value: criteria.useYn"--%>
                                <%--optionLabel="전체" style="width: 100%;">--%>
              <%--<kendo:dataSource data="${useYnItems}" />--%>
          <%--</td>--%>
					<td></td>
        </tr>
        </tbody>
      </table>
    </fieldset>
  </form>
</div>
<%--// .search1 --%>

<%-- .layout-LW --%>
<div class="layout-LW">
  <div class="left" style="width:38%;height:650px;">
    <div style="margin-bottom:10px;"></div>
    <kendo:treeList name="treeList" selectable="true" editable="true" height="640px" autoBind="false">
      <kendo:treeList-columns>
        <kendo:treeList-column field="deptKoNm" title="한글"></kendo:treeList-column>
        <kendo:treeList-column field="deptEnNm" title="영어"></kendo:treeList-column>
        <kendo:treeList-column field="deptJaNm" title="일어"></kendo:treeList-column>
        <kendo:treeList-column field="useYn" title="사용여부" ></kendo:treeList-column>
      </kendo:treeList-columns>
      <kendo:dataSource>
        <kendo:dataSource-schema data="data">
          <kendo:dataSource-schema-model id="deptCd">
            <kendo:dataSource-schema-model-fields>
              <kendo:dataSource-schema-model-field name="deptCd" type="string" />
              <kendo:dataSource-schema-model-field name="parentId" from="parentId" type="string" nullable="true" />
              <kendo:dataSource-schema-model-field name="upperDeptCd" type="string" />
              <kendo:dataSource-schema-model-field name="groupId" type="string" />
              <kendo:dataSource-schema-model-field name="deptKoNm" type="string" />
              <kendo:dataSource-schema-model-field name="deptEnNm" type="string" />
              <kendo:dataSource-schema-model-field name="deptJaNm" type="string" />
              <kendo:dataSource-schema-model-field name="telNo" type="string" />
              <kendo:dataSource-schema-model-field name="faxNo" type="string" />
              <kendo:dataSource-schema-model-field name="telNo2" type="string" />
              <kendo:dataSource-schema-model-field name="faxNo2" type="string" />
              <kendo:dataSource-schema-model-field name="zip" type="string" />
              <kendo:dataSource-schema-model-field name="adres" type="string" />
              <kendo:dataSource-schema-model-field name="roadAdres" type="string" />
              <kendo:dataSource-schema-model-field name="dtlAdres" type="string" />
              <kendo:dataSource-schema-model-field name="closDe" type="string" />
              <kendo:dataSource-schema-model-field name="useYn" type="string" />
              <kendo:dataSource-schema-model-field name="partDiv" type="string" />
              <kendo:dataSource-schema-model-field name="tranYn" type="string" />
            </kendo:dataSource-schema-model-fields>
          </kendo:dataSource-schema-model>
        </kendo:dataSource-schema>
        <kendo:dataSource-transport>
          <kendo:dataSource-transport-read url="${readUrl}" type="GET"
                                           contentType="application/json"/>
          <kendo:dataSource-transport-create url="${createUrl}" type="POST"
                                             contentType="application/json" />
          <kendo:dataSource-transport-update url="${updateUrl}" type="POST"
                                             contentType="application/json" />
          <kendo:dataSource-transport-destroy url="${deleteUrl}" type="POST"
                                              contentType="application/json" />
          <kendo:dataSource-transport-parameterMap>
            <script type="text/javascript">
              function parameterMap(options, type) {
                if (type != 'read') {
                  return JSON.stringify(options);
                } else {
                  return searchView.criteria.toJSON();
                }
              }
            </script>
          </kendo:dataSource-transport-parameterMap>
        </kendo:dataSource-transport>
        <kendo:dataSource-requestStart>
          <script type="text/javascript">
            function requestStart(e) {
              if (e.type != 'read') {

                var message = "", iscreate = false, isupdate = false, isdelete = false;
                if (e.type == 'create') {
                  message = "변경된 데이터가 있습니다.  등록 하시겠습니까?";
                  iscreate = true;
                } else if (e.type == 'update') {
                  message = "변경된 데이터가 있습니다.  수정 하시겠습니까?";
                  isupdate = true;
                } else {
                  message = "변경된 데이터가 있습니다.  삭제 하시겠습니까?";
                  isdelete = true;
                }

                if (!confirm(message)) {
                  e.preventDefault();
                  return;
                }
              } else
                inputView.set('data', null);

              _dicasPage.maskOpen();
            }
          </script>
        </kendo:dataSource-requestStart>
        <kendo:dataSource-requestEnd>
          <script type="text/javascript">
            function requestEnd(e) {
              _dicasPage.maskClose();
              if (e.type != 'read') {
                treeList.dataSource.read();
              }
            }
          </script>
        </kendo:dataSource-requestEnd>
        <kendo:dataSource-error>
          <script type="text/javascript">
            function error(e) {
              try {
                var data = JSON.parse(e.xhr.responseText);
                alert(data.message);
              } catch (e) {
                alert('처리 중 오류가 발생하였습니다.');
              }
            }
          </script>
        </kendo:dataSource-error>
      </kendo:dataSource>
    </kendo:treeList>
  </div>
  <div id="form_container" class="right" style="width:61%;">
		<div class="wrap">
      <form id="frm_input" method="post">
        <fieldset>
          <table class="bWrite">
            <colgroup>
              <col style="width:100px;" />
              <col />
              <col style="width:100px;" />
              <col />
            </colgroup>
						<tbody>
              <tr>
                <th scope="row"><label for="txt_deptCd_input">부서코드 <em class="required" title="필수항목">*</em></label></th>
                <td>
                  <input type="text" id="txt_deptCd_input" data-bind="value: data.deptCd" style="width:150px;" required placeholder="부서코드"/>
                </td>
                <th scope="row"><label for="txt_upperDeptCd_input">상위부서코드</label></th>
                <td>
                  <input type="text" id="txt_upperDeptCd_input" data-bind="value: data.upperDeptCd" style="width:150px;" placeholder="상위부서코드" disabled="true" />
                  <input type="text" id="txt_groupId_input" data-bind="value: data.groupId" style="width:80px;" placeholder="그룹ID" disabled="true"  />
                </td>
              </tr>
              <tr>
								<th scope="row"><label for="txt_deptKoNm_input">부서명 <em class="required" title="필수항목">*</em></label></th>
								<td colspan="3">
                  <input type="text" id="txt_deptKoNm_input" data-bind="value: data.deptKoNm" style="width:230px;" required placeholder="한글" />
                  <input type="text" id="txt_deptJaNm_input" data-bind="value: data.deptJaNm" style="width:220px;" required placeholder="일어" />
                  <input type="text" id="txt_deptEnNm_input" data-bind="value: data.deptEnNm" style="width:220px;" required placeholder="영어" />
                </td>
              </tr>
              <tr>
                <th scope="row"><label for="txt_telNo_input">전화번호</label></th>
								<td>
                  <input type="tel" id="txt_telNo_input" data-bind="value: data.telNo, events:{focus:telFocus, blur:telBlur}" style="width:230px;" placeholder="전화번호" />
                </td>
                <th scope="row"><label for="txt_faxNo_input">팩스번호</label></th>
                <td>
                  <input type="tel" id="txt_faxNo_input" data-bind="value: data.faxNo, events:{focus:telFocus, blur:telBlur}" style="width:230px;" placeholder="팩스번호" />
                </td>
              </tr>
              <tr>
                <th scope="row"><label for="txt_telNo2_input">전화번호2</label></th>
                <td>
                  <input type="tel" id="txt_telNo2_input" data-bind="value: data.telNo2, events:{focus:telFocus, blur:telBlur}" style="width:230px;" placeholder="전화번호2" />
                </td>
                <th scope="row"><label for="txt_faxNo2_input">팩스번호2</label></th>
                <td>
                  <input type="tel" id="txt_faxNo2_input" data-bind="value: data.faxNo2, events:{focus:telFocus, blur:telBlur}" style="width:230px;" placeholder="팩스번호2" />
                </td>
              </tr>
              <tr>
                <th scope="row" rowspan="2"><label for="txt_zip_input">주소</label></th>
                <td colspan="3">
                  <div class="search_input" style="display:inline-block;width:100px;">
                    <input type="text" id="txt_zip_input" data-bind="value: data.zip" placeholder="우편번호" readonly/>
                    <button type="button" data-bind="click: popupZip"><i class="ic_search1"></i><span
                        class="blind">검색</span></button>
                  </div>
                  <input type="text" id="txt_adres_input" data-bind="value: data.adres" placeholder="주소(지번)" style="width:275px;" readonly />
                  <input type="text" id="txt_road_adres_input" data-bind="value: data.roadAdres" placeholder="주소(도로명)" style="width:300px;" readonly />
                </td>
              </tr>
              <tr>
                <td colspan="3">
                  <input type="text" id="txt_dtl_adres_input" data-bind="value: data.dtl_adres" placeholder="상세주소" style="width:685px;"readonly />
                </td>
              </tr>
              <tr>
                <th scope="row"><label>사용여부</label></th>
                <td>
                  <kendo:dropDownList name="cmb_useYn_input" dataTextField="codeNm"
                                      data-value-primitive="true"
                                      dataValueField="codeCd"
                                      data-bind="value: data.useYn"
                                      style="width: 120px;">
                    <kendo:dataSource data="${useYnItems}">
                    </kendo:dataSource>
                  </kendo:dropDownList>
                </td>
                <th scope="row"><label>부품구분</label></th>
                <td>
                  <kendo:dropDownList name="cmb_partDiv_input" dataTextField="codeNm"
                                      data-value-primitive="true"
                                      dataValueField="codeCd"
                                      data-bind="value: data.partDiv"
                                      optionLabel="선택" style="width: 120px;">
                    <kendo:dataSource data="${partDivItems}">
                    </kendo:dataSource>
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

<script type="text/javascript">

  var _dicasPage = new DicasPage('${screenId}');

  <%-- Control Definition --%>
  var treeList;
  var treeMask;
  var cmbUseYnInput;
  var cmbPartDivInput;
  var phoneNumber;
  <%--// Control Definition --%>

  <%-- Variable Definition --%>
  var validatable = null;
  <%--// Variable Definition --%>

  var buttonView = kendo.observable({
		visible: {
		  add: false,
      save: false,
      cancel: false,
      remove: false
    },
    add: function() {
      if (inputView.get('data') != null) {
        var row = treeList.itemFor(inputView.get('data'));
        treeList.addRow(row);
      }
    },
    save: function() {
		  inputView.save();
    },
    cancel: function() {
      if (inputView.hasChanges()) {
        if (!confirm("변경된 데이터가 있습니다. 취소 하시겠습니까?")) {
          return;
        }
        treeList.cancelChanges();
      }
    },
    remove: function() {
      if (inputView.get('data') != null && treeList.dataSource.total() > 0) {
        treeList.dataSource.remove(inputView.get('data'));
      }
    }
  });
  buttonView.bind('change', function(e) {
  });
  kendo.bind($("div.sub-con-wrap"), buttonView);

  var searchView = kendo.observable({
		criteria: {
		  groupId: "01",
    },
    submit: function() {
      // if (inputView.hasChanges()) {
      //   if (!confirm("변경된 데이터가 있습니다. 조회 하시겠습니까?")) {
      //     return;
      //   }
      // }
      treeList.dataSource.read();
      return false;
    }
  });
  searchView.bind('change', function (e) {
    var that = this;
    if (e.field.indexOf('criteria') > -1) {
      that.submit();
    }
  });
  kendo.bind($("#frm_search"), searchView);

  var inputView = kendo.observable({
    data: null,
    hold: false,
    save: function() {

      if (!inputView.validate()) {
        alert('필수 항목을 입력해 주십시오.');
        return;
      }

      treeList.saveChanges();
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
		popupZip: function(e) {
      alert('서비스 준비 중입니다.');
    },
    validate: function() {
      if (validatable == null) return true;
      return validatable.validate();
    },
    hasChanges: function() {
      return treeList.dataSource.hasChanges();
    }
  });
  inputView.bind('change', function (e) {
    if (e.field == 'data') {
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

  function treeListOnChange(e) {
    var selectedCells = this.select();
    var selectedDataItems = [];
    for (var i = 0; i < selectedCells.length; i++) {
      selectedDataItems.push(this.dataItem(selectedCells[i]));
    }

    // 전화번호, 팩스번호 변경
    inputView.set('data', selectedDataItems[0]);
    if (!selectedDataItems[0].dirty) {

      if (!(selectedDataItems[0].hasChildren || selectedDataItems[0].deptLvl == 1))
        buttonView.set('visible.remove', true);
      else
        buttonView.set('visible.remove', false);

      buttonView.set('visible.add', true);
    }
  }

  $(document).ready(function() {

    phoneNumber = new libphonenumber.AsYouType('KR');

    treeList = $("#treeList").data("kendoTreeList");
    treeMask = new ax5.ui.mask();
    treeList.options.dataSource.schema.model.expanded = !treeList.options.dataSource.schema.model.expanded
    treeList.setDataSource(treeList.options.dataSource);

    treeList.dataSource.read();

    treeList.bind('change', treeListOnChange);

    treeList.dataSource.bind('change', function(e) {

      if (e.action !== undefined) {
        if (e.action == 'add') {
          e.items[0] = $.extend(e.items[0], {
            upperDeptCd: e.items[0].parentId,
            useYn: 'Y',
						groupId: inputView.data.groupId
          });

          inputView.set('data', e.items[0]);
        }
      } else {
      }

      if (inputView.hasChanges()) {
        buttonView.set('visible.save', true);
        buttonView.set('visible.cancel', true);
        buttonView.set('visible.add', false);
        buttonView.set('visible.remove', false);
        treeMask.open({
          zIndex: 99,
          target: $("#treeList").get(0),
          content: '',
          theme: 'edit',
          onClick: function(){
          }
        });
      } else {
        buttonView.set('visible.save', false);
        buttonView.set('visible.cancel', false);
        buttonView.set('visible.add', false);
        buttonView.set('visible.remove', false);

        if (inputView.get('data') != null) {
          var item = treeList.dataSource.get(inputView.get('data').id);
          if (item !== undefined) {
            var row = treeList.itemFor(item);
            treeList.select(row);
          }
        }
        treeMask.close();
      }
    });

    cmbUseYnInput = $("#cmb_useYn_input", "#frm_input").data("kendoDropDownList");
    cmbPartDivInput = $("#cmb_useYn_input", "#frm_input").data("kendoDropDownList");
  });


</script>
