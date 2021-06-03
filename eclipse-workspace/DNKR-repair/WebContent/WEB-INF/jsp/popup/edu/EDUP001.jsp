<%-- [EN] Variable definition --%>
<%-- [JP] ???? --%>
<c:url var="codeUrl" value="/code/list.json"/>

<c:url var="readUrl" value="/popup/trainingAppView/search"/>

<c:url var="updateUrl" value="/popup/trainingAppView/update"/>
<c:url var="deleteUrl" value="/popup/trainingAppView/delete"/>

<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] ID (@ViewId) --%>
<c:set var="screenId" value="<%= request.getAttribute(Globals.SCREEN_ID_KEY) %>"/>

<h2>교육 신청 수정</h2>
<a onclick="_isDirty=false;window.close();return false;" class="close ckd_close">창닫기</a>

<div class="sub-con-wrap">
  <!-- 버튼들 -->
  <div class="sub-btn-group">
    <!-- <button id="btn_add" class="button bc1" data-bind="click: add, visible: btnGrp0Visible"><i class="w_add"></i>추가</button> -->
    <button id="btn_save" class="button bc2" data-bind="click: save, visible: btnGrp3Visible"><i class="w_save"></i>저장</button>
    <button id="btn_remove" class="button" data-bind="click: remove, visible: btnGrp3Visible"><i class="w_minus"></i>삭제</button>
  </div>
  <!-- /버튼들 -->
</div>


<%-- .search1 --%>
<%-- <div class="search1">
    <form id="frm_search" method="get" data-bind="events: {submit: submit}">
        <fieldset>
            <table>
                <colgroup>
                    <col style="width:100px"/>
                    <col style="width:100px"/>
                    <col style="width:155px"/>
                    <col style="width:100px"/>
                    <col style="width:155px"/>
                    <col style="width:100px"/>
                    <col style="width:155px"/>
                    <col/>
                </colgroup>
                <tr>
                    <th>DTC 검색</th>
                    <td>
                        <select name="date_search_option" id="date_search_option" data-bind="value: criteria.dateSearchOption">
                            <option value="01">코드</option>
                            <option value="02">한글명</option>
                            <option value="03">영문명</option>
                        </select>
                    </td>
                    <td>
                        <input type="text" id="dtcKrNm_search" data-bind="value: criteria.dtcKrNm" />
                    </td>
                    <th>배기규제형식</th>
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
                    <th>엔진형식</th>
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
                        <button type="submit" value="submit" class="button"><i class="w_search"></i>검색</button>
                    </td>
                    <td>&nbsp;</td>
                </tr>
            </table>
        </fieldset>
    </form>
</div> --%>
<%--// .search1 --%>

<%-- .layout-LW --%>

<div class="layout-LW">
    <div class="left" style="width:58%;">
        <div style="margin-bottom:10px;"></div>
        <div id="grid" data-grid-type="view"></div>
    </div>
    <div id="form_container" class="right" style="width:40%;">
        <div class="wrap">
            <form id="frm_input" method="post">
                <input type="hidden" id="id_input" data-bind="value: data.id" disabled='enabled' />
                <fieldset>
                    <table class="bWrite">
                        <colgroup>
                            <col style="width:130px"/>
                            <col/>
                        </colgroup>
                        <tbody>
                        <tr>
                            <th scope="row"><label for="cmb_exhaustReg_input">No.</label>
                            </th>
                            <td>
                                <input type="text" id="rn" data-bind="value: data.rn" style="width: 50%" />
                            </td>
                        </tr>
                        <tr>
                            <th scope="row"><label for="rnkCd">직급</label>
                            </th>
                            <td>
                                <kendo:dropDownList name="rnkCd" dataTextField="codeNm"
                                                    dataValueField="codeCd"
                                                    data-value-primitive="true"
                                                    data-bind="value: data.rnkCd"
                                                    
                                                    >
                                    <kendo:dataSource data="${rnkCdItems}"/>
                                </kendo:dropDownList>
                            </td>
                        </tr>

                        <tr>
                            <th scope="row"><label for="traineeNm">수강자이름</label>
                            </th>
                            <td>
                                <input type="text" id="traineeNm" data-bind="value: data.traineeNm" style="width: 50%" />
                            </td>
                        </tr>
                        <tr>
                            <th scope="row"><label for="officeTel">연락처(회사)</label>
                            </th>
                            <td>
                                <input type="text" id="officeTel" data-bind="value: data.officeTel" style="width: 50%" />
                            </td>
                        </tr>

                        <tr>
                            <th scope="row"><label for="moblphonNo">연락처(핸드폰)</label>
                            </th>
                            <td>
                                <input type="text" id="moblphonNo" data-bind="value: data.moblphonNo" style="width: 50%" />
                            </td>
                        </tr>

                        <tr>
                            <th scope="row"><label for="email">E-mail</label>
                            </th>
                            <td>
                                <input type="text" id="email" data-bind="value: data.email" style="width: 50%" />
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
            rn:{ type: 'string'}
            ,rnkCd: { type: 'string' }
            ,traineeNm: { type: 'string' }
            ,officeTel: { type: 'string' }
            ,moblphonNo: { type: 'string' }
            ,email: { type: 'string' }
        }
    });

    var buttonView = kendo.observable({
    	btnGrp3Visible: true,
        search: function() {
            searchView.submit();          
        },
          save: function() {
  			if (grid.getRowCount() == 0) {
  			    return;
  			}
  			
  			
  			for (var i = 0; i < grid.getModifiedRows().updatedRows.length; i++){
  				if(grid.getModifiedRows().updatedRows[i].rnkCd == ""){
					alert("직급을 선택해주세요");
					return;
				}
				
				if(grid.getModifiedRows().updatedRows[i].traineeNm == ""){
					alert("수강자 이름을 입력해주세요");
					return;
				}
				
				if(grid.getModifiedRows().updatedRows[i].moblphonNo == ""){
					alert("수강자 리스트에서 연락처(핸드폰)을 입력해주세요");
					return;
				}
  			}

  			if (grid.getModifiedRows().updatedRows.length > 0) {
  				
  				for (var i = 0; i < grid.getModifiedRows().updatedRows.length; i++) {
  					 $.ajax({
  				           method: "POST",
  				           url: '${updateUrl}',
  				           data: JSON.stringify(grid.getModifiedRows().updatedRows[i]),
  				           dataType: 'JSON',
  				           contentType: 'application/json;charset=UTF-8'
  				         }).done(function (data, status, jqXHR) {
  				        	 
  				         }).fail(function (data, status, jqXHR) {
  				           alert("저장 중 오류가 발생하였습니다.");
  				         }).always(function () {
  				           _dicasPage.maskClose();
  				         });
  				}
  			}
  			
  			grid.clear();
  			searchView.submit();
  			alert("수정 및 저장이 완료되었습니다.");
          },
          remove: function () {

            if (grid.getRowCount() == 0) {
              return;
            }

            if(confirm("교육 정보를 삭제 하시겠습니까?")) {
                _dicasPage.maskOpen();

                var data = inputView.get('data');

                if (data.id == null) {
                  return;
                }else if(data.chk == "I"){
              	  grid.removeRow(inputView.get('rowKey'));
              	  return;
                }

                $.ajax({
                  method: "POST",
                  url: '${deleteUrl}',
                  data: JSON.stringify(inputView.get('data')),
                  contentType: 'application/json;charset=UTF-8'
                }).done(function (data, status, jqXHR) {
                  //searchView.search();
                  var dataItem = new codeMdl().toJSON();
                  inputView.set('data', dataItem);
                  //조사삭제 비활성화
                  /* delButtonView1.set("btnGrpVisible", false); */

                  /* inputView2Disabled(); */
                  
                  grid.clear();
      			  searchView.submit();

                }).fail(function (data, status, jqXHR) {
                  alert("삭제 중 오류가 발생하였습니다.");
                }).always(function () {
                  _dicasPage.maskClose();
                });
          	  
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
    
 	// 콤보 박스 데이터 내용 및 코드값 변환
    getEditOptions = function (data) {

        var editoptions = [];
        
        item = {
        	      text: '선택해주세요.',
        	      value: ''
        	    }
        
    	editoptions.push(item);
        
        for (var i = 0; i < data.length; i++) {

          var item = {
            text: data[i].codeKoNm,
            value: data[i].codeCd
          }

          editoptions.push(item);
        }
        return editoptions;
    };

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

        } else if (type == 'view' || type == 'add') {
            $("input[type]", "#form_container").each(function (i, v) {
                /* $(v).attr("disabled", true); */
            });

        }
    }

    function goPage(gridId, page) {
        if (gridId == "grid1") {
            searchView.set("rowKey", null);
            searchView.set("rowData", null);
            /* alert("${trainingAppViewForm.reprNm}");
            searchView.set("criteria.reprNm", "${trainingAppViewForm.reprNm}");
            searchView.set("criteria.officePw", "${trainingAppViewForm.officePw}");
            searchView.set("criteria.eduNm", "${trainingAppViewForm.eduNm}");
            searchView.set("criteria.eduDt", "${trainingAppViewForm.eduDt}"); */
            net.readData(1, searchView.criteria.toJSON(), true);

        }
    }

    function convertUndefined(str) {
        if (str == "undefined" || str == "" || str == "null") {
            return null;
        } else {
            return str;
        }
    }


    $(document).ready(function () {

        // DropDownList
        /* cmbExhaustRegInput = $("#cmb_exhaustReg_input", "#frm_input").data("kendoDropDownList");
        var exhaustRegData = cmbExhaustRegInput.dataSource.data();
        var exhausRegItems = _dicasPage.getEditOptions(exhaustRegData);

        cmbEngineTypeInput = $("#cmb_engineType_input", "#frm_input").data("kendoDropDownList");
        var engineTypeData = cmbEngineTypeInput.dataSource.data();
        var engineTypeItems = _dicasPage.getEditOptions(engineTypeData); */
        
        var rnkData = new kendo.data.DataSource({data: ${rnkCdItems2}}),
        rnkCdItems2 = getEditOptions(rnkData.options.data);
        
        validatable = $("#form_container").kendoValidator({validateOnBlur: false}).data("kendoValidator");

        var data = new codeMdl({
        	 reprNm: convertUndefined("${trainingAppViewForm.reprNm}")
        	,officePw: convertUndefined("${trainingAppViewForm.officePw}")
        	,eduNm: convertUndefined("${trainingAppViewForm.eduNm}")
        	,eduDt: convertUndefined("${trainingAppViewForm.eduDt}")
        });
        searchView.set('criteria', data);

        $("#date_search_option").val("01").change();

        tui.Grid.applyTheme('clean');
        grid = new tui.Grid({
            el: $('#grid'),
            scrollX: false,
            scrollY: true,
            rowHeight: 30,
            useClientSort: false,
            showDummyRows: true,
            minBodyHeight: 30,
            bodyHeight: 600,
            pagination: true,
            selectionUnit: 'CELL',
            editingEvent: false,
            usageStatistics: false,
            columns: [
            	 {title:'ID', name:'id', align:'center', width: 50, hidden: true }
                ,{title:'No.', name:'rn', align:'center', width: 50 }
                ,{ title: '직급', name: 'rnkCd', align: 'center'
                	, editOptions: {type: 'select', listItems: rnkCdItems2, useViewMode: true}
                 }
                ,{ title: '수강자이름', name: 'traineeNm', align: 'center' }
                ,{ title: '연락처(회사)', name: 'officeTel', align: 'center' }
                ,{ title: '연락처(핸드폰)', name: 'moblphonNo', align: 'center' }
                ,{ title: 'E-mail', name: 'email', align: 'center' }
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
                    // buttonView.set('btnGrp2Visible', true);
                    setPageUI('view');
                }
            }
        }).on('dblclick', function (eventData) {
            _openerPage.codeHelpVal = JSON.stringify(this.getRow(eventData.rowKey));
            _isDirty = true;
            /* window.close(); */
        });

        net = grid.getAddOn('Net');
        pagination = grid.getPagination();
        pagination.on('afterMove', function (eventData) {
            /* buttonView.set('btnGrp1Visible', false); */
            if (grid.getRowCount() > 0)
                grid.focusAt(0, 0);
        });

        /* setPageUI("view"); */

        searchView.submit();
    });
    
    

</script>
