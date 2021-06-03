<%-- [EN] Variable definition --%>
<%-- [JP] ???? --%>
<%-- <c:url var="codeUrl" value="/code/list.json"/> --%>

<%-- <c:url var="code2Url" value="/trainingAppcntView/list.json"/> --%>

<c:url var="initUrl" value="/trainingAppView/init"/>

<c:url var="readUrl" value="/trainingAppView/search"/>

<%-- <c:url var="readUrl2" value="/trainingAppView/searchSd"/> --%>

<%-- <c:url var="createUrl" value="/trainingAppView/create"/> --%>

<%-- <c:url var="createUrl2" value="/trainingAppView/create2"/> --%>

<c:url var="popupUrl" value="/popup/trainingAppView/init"/>

<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] ??ID (@ViewId???) --%>
<c:set var="screenId" value="<%= request.getAttribute(Globals.SCREEN_ID_KEY) %>"/>

<!-- <div class="sub-con-wrap2"> -->
  <h2 class="subpage-tit">교육신청조회</h2>
  <!-- 버튼들 -->
  <!-- <div class="sub-btn-group"> -->
    <!-- <button type="button" class="button" data-bind="click: popup"><i class="w_print"></i>인쇄</button> -->
    <!-- <button id="btn_search" type="button" class="button" data-bind="click: search"><i class="w_search"></i>검색</button> -->
    <!-- <button id="btn_cancel" type="button" class="button" data-bind="click: cancel, visible: btnGrp1Visible"><i class="w_cancel"></i>취소</button> -->
  <!-- </div> -->
  <!-- /버튼들 -->
<!-- </div> -->

<%-- .search1 --%>


<%-- <div class="search1">
  <form id="frm_search" method="get" >
    <fieldset>
      <table>
        <colgroup>
          <col style="width:80px"/>
          <col style="width:155px"/>
<!--           <col style="width:80px"/>
          <col style="width:155px"/> -->
          <col style="width:80px"/>
          <col style="width:280px"/>
          <!-- <col style="width:80px"/>
          <col style="width:155px"/> -->
          <col/>
        </colgroup>
        <tr>
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
                                data-bind="value: criteria.eduItem"
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
        </tr>
      </table>
    </fieldset>
  </form>
</div> --%>
<%--// .search1 --%>

<div class="layout-LW">
<h2 class="subpage-tit">[교육 신청 조회 화면]</h2>
<div id="form_container" class="center" style="width:30%; margin-left:auto; margin-right:auto;">
	<div class="search1">
		<form id="frm_input" method="post">
			
				
			
			<fieldset>
			  
		      <table>
		        <h4>비밀번호 확인</h4>
		        <tr>
		          <th>대표자명</th>
		          <td>
		              <input type="text" id="reprNm" data-bind="value: criteria.reprNm" autocomplete="off" />
		          </td>
		       </tr>
		       <tr>
		          <th>비밀번호</th>
		          <td>
		          	  <input type="text" id="officePw_con" style="display:none;"  autocomplete="off"/>
		              <input type="password" id="officePw" data-bind="value: criteria.officePw"  maxLength="4"  autocomplete="off" />
		          </td>
		       </tr>
		       </table>
		    </fieldset>
		</form>
		<tr>
		<div class="sub-con-wrap">
		   	<div class='btns tac'>
				<button id="btn_search" type="button" class="button" data-bind="click: search"><i class="w_search"></i>확인</button>
				<button id="btn_cancel" type="button" class="button" data-bind="click: cancel"><i class="w_cancel"></i>초기화</button>
				<!-- <button id="btn_search" type="button" class="button" data-bind="click: search"><i class="w_search"></i>검색</button> -->
			</div>
		</div>
		</tr>
	</div>
	

</div>

<%-- .layout-LW --%>
<div class="layout-LW">
<h2 class="subpage-tit">[교육 신청 리스트]</h2>
  <div class="left" style="width:100%;">
    <div style="margin-bottom:10px; "></div>
  	<div id="grid" data-grid-type="view"></div>
  	<!-- <div id="grid2" data-grid-type="view"></div>   -->
  	<!-- <div id="grid2" data-grid-type="view" style="display:none;"></div>   -->
  </div>
</div>

<%--// .layout-LW --%>

<script type="text/javascript">

    var _dicasPage = new DicasPage('${screenId}');
    $( ".calendar" ).datepicker();

    // 검색설정
    var loadDt = new Date();

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
        eduNm: { type: 'string' }
       ,eduDt: { type: 'string' }
   		}
    });

    var buttonView = kendo.observable({
        search: function() {
        	if($('#reprNm').val() == ''){
        		alert("대표자명을 입력하세요.");
        		return;
        	}
        	if($('#officePw').val() == ''){
        		alert("비밀번호를 입력하세요.");
        		return;
        	}
            searchView.submit();
        },
    	cancel: function() {
    		$('#reprNm').val('');
    		$('#officePw').val('');
    		grid.clear();
    	}
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
            if (inputView.hasChanges()) {
                if (!confirm("변경된 데이터가 있습니다. 조회 하시겠습니까?")) {
                    return;
                }
            }
            
            goPage('grid', 1);
            return false;
        },

    });
    kendo.bind($("#frm_input"), searchView);    
    
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
        },
        popup6: function () {
        	/* alert(grid.getValue(inputView.get('rowKey'), "eduNm"));
        	alert(grid.getValue(inputView.get('rowKey'), "eduDt")); */
        	/* alert(searchView.get('criteria.reprNm'));
        	alert(searchView.get('criteria.officePw')); */
            var that = this;
            _dicasPage.popupOpen({
              url: "${popupUrl}",
              code: 'codeHelp',
              width: 1300,
              height: 900,
              params: {
            	  /* reprNm: encodeURI(encodeURIComponent(searchView.get('criteria.reprNm'))),
            	  officePw: encodeURI(encodeURIComponent(searchView.get('criteria.officePw'))),
            	  eduNm: encodeURI(encodeURIComponent(grid.getValue(inputView.get('rowKey'), "eduNm"))),
            	  eduDt: encodeURI(encodeURIComponent(grid.getValue(inputView.get('rowKey'), "eduDt"))) */
            	  reprNm: searchView.get('criteria.reprNm'),
            	  officePw: searchView.get('criteria.officePw'),
            	  eduNm: grid.getValue(inputView.get('rowKey'), "eduNm"),
            	  eduDt: grid.getValue(inputView.get('rowKey'), "eduDt")
            	  /* reprNm: '1',
            	  officePw: '2',
            	  eduNm: '1',
            	  eduDt: '2' */
              },
              beforeOpen: function () {
                _dicasPage.beforeCodeHelpVal = true;
              },
              afterClose: function (info) {
                if (info.result) {
                  var _data = JSON.parse(info.data);

                  /* for (var i=0; i<dtcItems.length; i++) {
                    var data1 = dtcItems[i];
                    // console.log(_data);
                    // console.log(data1);
                    if( _data.dtcCode == data1.value) {
                      var gridRowkey = grid.getFocusedCell().rowKey;
                      grid.setValue(gridRowkey, 'code', data1.value);
                    }
                  } */
                  
                } else {
                  
                }
              }
            });
          }
    });

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
    kendo.bind($("#grid"), inputView);

    function setPageUI(type) {
        if (type == "init") {
            $("input[type]", "#form_container").each(function (i, v) {
            	searchView.submit();
            });

        } else if (type == 'view' || type == 'add') {

            $("input[type]", "#form_container").each(function (i, v) {
                
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
            /* net2.readData(1, searchView.criteria.toJSON(), true); */
        }
    }
    
    $(document).ready(function () {
    	/* document.getElementById("header-wrap").style.display = "none";
		document.getElementById("logo").style.display = "none"; */
		
	    validatable = $("#form_container").kendoValidator({validateOnBlur: false}).data("kendoValidator");
	
	    var rnkData = new kendo.data.DataSource({data: ${rnkItems}}),
	    rnkItems = getEditOptions(rnkData.options.data);
	    
	    tui.Grid.applyTheme('clean');
	    grid = new tui.Grid({
	        el: $('#grid'),
	        scrollX: false,
	        scrollY: true,
	        rowHeight: 30,
	        useClientSort: false,
	        showDummyRows: true,
	        minBodyHeight: 30,
	        bodyHeight: 300,
	        pagination: true,
	        selectionUnit: 'CELL',
	        editingEvent: true,
	        usageStatistics: false,
	        treeColumnOptions: {
	            name: 'ID',
	            useCascadingCheckbox: false
	        },
	        columns: [
	               { title: 'ID', name: 'id', align: 'center', hidden: true  }
	              ,{ title: '교육명', name: 'eduNm', align: 'center' }
	              ,{ title: '교육일', name: 'eduDt', align: 'center' }
	              ,{ title: '', name: 'img', align: 'center', width: 10,
	                  formatter: function(value) {
	                    var url = "<c:url value='../../../assets/img/grid_popup_img.png' />";
	                    return '<img src="' + url + '" />';
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
	            /* eventData.stop();  */
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
	
	    }).on('dblclick', function (eventData) {
	    	/* alert("김준수"); */
	        if(eventData.columnName == 'img') {
	            inputView.popup6();
	          }
        });
	
	    net = grid.getAddOn('Net');
	    pagination = grid.getPagination();
	    pagination.on('afterMove', function (eventData) {
	        /* buttonView.set('btnGrp1Visible', false); */
	        if (grid.getRowCount() > 0) {
	            grid.focusAt(0, 0);
	        }
	    });
	
	    if(_dicasPage.requestParams != null)
	      searchView.submit();

	    
        /* setPageUI("init"); */
	});

</script>
