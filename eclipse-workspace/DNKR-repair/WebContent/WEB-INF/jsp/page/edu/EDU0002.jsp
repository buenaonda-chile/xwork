<%-- [EN] Variable definition --%>
<%-- [JP] ???? --%>
<c:url var="codeUrl" value="/code/list.json"/>

<c:url var="code2Url" value="/trainingAppRegist/list.json"/>

<c:url var="initUrl" value="/trainingAppcntView/init"/>

<c:url var="readUrl" value="/trainingAppcntView/search"/>

<c:url var="downloadUrl" value="/trainingAppcntView/download"/>


<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] ??ID (@ViewId???) --%>
<c:set var="screenId" value="<%= request.getAttribute(Globals.SCREEN_ID_KEY) %>"/>

<div class="sub-con-wrap">
  <h2 class="subpage-tit">교육신청자현황</h2>
  <!-- 버튼들 -->
  <div class="sub-btn-group">
    <!-- <button type="button" class="button" data-bind="click: popup"><i class="w_print"></i>인쇄</button> -->
    <button id="btn_search" type="button" class="button" data-bind="click: search"><i class="w_search"></i>검색</button>
    <button id="btn_down" class="button" data-bind="click: download2"><i class="w_down"></i>다운로드</button>
    <!-- <button id="btn_cancel" type="button" class="button" data-bind="click: cancel, visible: btnGrp1Visible"><i class="w_cancel"></i>취소</button> -->
  </div>
  <!-- /버튼들 -->
</div>

<%-- .search1 --%>
<div class="search1">
  <form id="frm_search" method="get" >
    <fieldset>
      <table>
        <colgroup>
          <col style="width:80px"/>
          <col style="width:280px"/>
          <col style="width:80px"/>
          <col style="width:155px"/>
          <col style="width:80px"/>
          <col style="width:155px"/>
          <col style="width:80px"/>
          <col style="width:155px"/>
          <col/>
        </colgroup>
        <tr>
         <th>교육기간</th>
          <td>
            <input type="text" id="searchEduDtFr" data-bind="value: criteria.searchEduDtFr"  class="calendar" /> - <input type="text" id="searchEduDtTo"  data-bind="value: criteria.searchEduDtTo" class="calendar" />
          </td>
          <th>교육대상 구분</th>
          <td>
              <kendo:dropDownList name="cmb_eduDiv_search" dataTextField="codeNm"
                                data-value-primitive="true"
                                dataValueField="codeCd"
                                data-bind="value: criteria.eduDiv"
                                optionLabel="전체" style="width: 200px;">
              <kendo:dataSource>
                <kendo:dataSource-transport>
                  <kendo:dataSource-transport-read url="${codeUrl}/EDUCATION" type="POST"
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
          <th>교육 항목</th>
          <td>
              <kendo:dropDownList name="cmb_eduItem_search" dataTextField="eduNm"
                                data-value-primitive="true"
                                dataValueField="id"
                                data-bind="value: criteria.eduNm"
                                optionLabel="전체" style="width: 200px;">
              <kendo:dataSource>
                <kendo:dataSource-transport>
                  <kendo:dataSource-transport-read url="${code2Url}/EDUCATION" type="POST"
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
          <th>정비소명</th>
          <td>
            <input type="text" id="officeNm_search" data-bind="value: criteria.officeNm" />
            <!-- <input type="hidden" id="manageNo_input" data-bind="value: criteria.manageNo" /> -->
          </td>
        </tr>
      </table>
    </fieldset>
  </form>
</div>
<%--// .search1 --%>

<%-- .layout-LW --%>
<div class="layout-LW">
  <div class="left" style="width:100%;">
    <div style="margin-bottom:10px;"></div>
    <div id="grid" data-grid-type="view"></div>
  </div>

</div>
<%--// .layout-LW --%>

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

    <%--// Control Definition --%>

    <%-- Variable Definition --%>
    var validatable = null;
    <%--// Variable Definition --%>

    var codeMdl = kendo.data.Model.define({
        ID: 'ID',
        fields: {
        	 rgstrId: { type: 'string' }
    		,rn: { type: 'string' }
    		,eduItem: { type: 'string' }
            ,officeNm: { type: 'string' }
            ,reprNm: { type: 'string' }
            ,telNo: { type: 'string' }
            ,email: { type: 'string' }
        }
    });
    
    var buttonView = kendo.observable({
        btnGrp0Visible: true,
        btnGrp3Visible: true,
        //btnGrp1Visible: false,
        //btnGrp2Visible: false,
        search: function() {
            searchView.submit();
        },
        download2: function() {
        	// 교육항목 체크
			if($('#cmb_eduDiv_search').val() == ""){
				alert("교육대상 구분을 선택하세요.");
				return;
			}
        	
            net.download('excelAll');
        },
        add: function () {

        },
        save: function() {
			
        },
        remove: function () {

        },
      });   

    buttonView.bind('change', function (e) {
        
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
        	// 교육항목 체크
			if($('#cmb_eduDiv_search').val() == ""){
				alert("교육대상 구분을 선택하세요.");
				return;
			}
        	
        	buttonView.set('btnGrp0Visible', true);
            if (inputView.hasChanges()) {
                if (!confirm("변경된 데이터가 있습니다. 조회 하시겠습니까?")) {
                    return;
                }
            }
            goPage('grid', 1);
            return false;
        },

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
        btnGrp3Visible: true,
        btnGrp4Visible: true,
        rowIndex: 0,
        rowKey: null,
        data: null,
        save: function () {

        },
        validate: function () {
            if (validatable == null) return true;
            return validatable.validate();
        },
        hasChanges: function () {
            return grid.isModified();
        }
    });

    inputView.bind('change', function (e) {    
/*         if (e.field.indexOf('data.') > -1) {

            var itemNm = e.field.substr(5);
            grid.setValue(this.get('rowKey'), itemNm, this.get(e.field));
            if (this.hasChanges()) {
                buttonView.set('btnGrp1Visible', true);
            } else {
                buttonView.set('btnGrp1Visible', false);
            }
        } */
    });
    kendo.bind($("#form_container"), inputView);
    

    function setPageUI(type) {
        if (type == "init") {
            $("input[type]", "#form_container").each(function (i, v) {
                $(v).attr("disabled", true);
            });

        } else if (type == 'view' || type == 'add') {

            $("input[type]", "#form_container").each(function (i, v) {
                $(v).attr("disabled", true);
            });
        }

        var state = grid.getValue(inputView.get('rowKey'), "approvalStatus");
        if (state == "SUBMISSION") {
            inputView.set('btnGrp3Visible', true);
            inputView.set('btnGrp4Visible', true);
        }
    }

    function goPage(gridId, page) {
        if (gridId == "grid") {
            searchView.set("rowKey", null);
            net.readData(1, searchView.criteria.toJSON(), true);
        }
    }

    $(document).ready(function () {
    	
		/* var educationData = new kendo.data.DataSource({data: ${educationItems}}),
		educationItems = getEditOptions(educationData.options.data);
		
		var onoffData = new kendo.data.DataSource({data: ${onoffItems}}),
		onoffItems = getEditOptions(onoffData.options.data); */
    
	    validatable = $("#form_container").kendoValidator({validateOnBlur: false}).data("kendoValidator");
	
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
	        treeColumnOptions: {
	            name: 'ID',
	            useCascadingCheckbox: false
	        },
	        columns: [
	        	 { title: 'ID', name: 'id', align: 'center', hidden: 'true' }
	        	,{ title: 'No.', name: 'rn', align: 'center' }
	        	,{ title: '교육 항목', name: 'eduNm', align: 'center' }
	        	,{ title: '접수 정비소', name: 'officeNm', align: 'center' }
	        	,{ title: '대표자명', name: 'reprNm', align: 'center' }
	        	,{ title: '연락처(핸드폰)', name: 'telNo', align: 'center' }
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
	            'downloadExcelAll': '${downloadUrl}'
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
	            /* eventData.stop(); */
	        } else {
	        	
	            if (eventData.prevRowKey != eventData.rowKey) {
	                var rowIndex = this.getIndexOfRow(eventData.rowKey);
	                inputView.set("rowIndex", rowIndex);
	                inputView.set("rowKey", eventData.rowKey);
	                inputView.set('data', this.getRow(eventData.rowKey));
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
	        /* buttonView.set('btnGrp1Visible', false);
	        if (grid.getRowCount() > 0) {
	            grid.focusAt(0, 0);
	        } */
	    });
	
	    if(_dicasPage.requestParams != null)
	      searchView.submit();
	    
    
	});

</script>
