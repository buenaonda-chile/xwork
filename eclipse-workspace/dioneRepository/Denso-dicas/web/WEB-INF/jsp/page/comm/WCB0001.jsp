<%-- [EN] Variable definition --%>
<%-- [JP] 変数定義 --%>
<c:url var="codeUrl" value="/code/list.json"/>
<c:url var="formUrl" value="/board/${type}/form" />
<c:url var="readUrl" value="/board/${type}/search" />

<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] 画面ID (@ViewIdで定義) --%>
<c:set var="screenId" value="<%= request.getAttribute(Globals.SCREEN_ID_KEY) %>"/>

<div class="sub-con-wrap">
	<h2 class="subpage-tit">${pageTitle}</h2>

	<!-- 버튼들 -->
	<div class="sub-btn-group">
        <button id="btn_search" class="button" data-bind="click: search, visible: visible.search"><i class="w_search"></i>검색</button>

		<c:choose>
			<c:when test="${userStore.getEgovUserVO().getOfficeCd() != null}">
			</c:when>
			<c:otherwise>
				<button id="btn_create" class="button bc2" data-bind="click: create, visible: visible.create"><i class="w_save"></i>등록</button>
			</c:otherwise>
		</c:choose>

		<!--
		<button id="btn_update" class="button" data-bind="click: update, visible: visible.update"><i class="w_edit"></i>수정</button>
		<button id="btn_view" class="button" data-bind="click: view, visible: visible.view"><i class="w_nwin"></i>보기</button>
		-->
	</div>
	<!-- /버튼들 -->
</div>
<%-- .search1 --%>
<div class="search1">
	<form id="frm_search" method="get"  data-bind="events: {submit: submit}">
		<fieldset>
			<table>
				<colgroup>
					<col style="width:80px"/>
					<col style="width:80px"/>
					<col style="width:100px"/>
					<col style="width:600px"/>
					<col/>
				</colgroup>
				<tr>
			 		<th>게시물검색</th>
					<%--<td>--%>
						<%--<select name="category_search_option" id="category_search_option" data-bind="value: criteria.categorySearchOption">--%>
							<%--<option value="01">공통 자료실</option>--%>
							<%--<option value="02">DIKR 자료실</option>--%>
							<%--<option value="02">A/C 자료실</option>--%>
							<%--<option value="02">CRS 자료실</option>--%>
						<%--</select>--%>
					<%--</td>--%>
					<td>
						<kendo:dropDownList name="cmb_category_search" dataTextField="codeNm"
											data-value-primitive="true"
											dataValueField="ref2"
											data-bind="value: criteria.category"
											optionLabel="전체"
											style="width: 120px;">
							<kendo:dataSource>
								<kendo:dataSource-transport>
									<kendo:dataSource-transport-read url="${codeUrl}/COCATEGORY" type="POST" contentType="application/json"/>
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
						<select name="date_search_option" id="date_search_option" data-bind="value: criteria.dateSearchOption">
							<option value="01">제목</option>
							<option value="02">작성자</option>
							<option value="03">내용</option>
						</select>
					</td>
					<td>
						<input type="text" id="text_subject" data-bind="value: criteria.subject"/>
					</td>
					<td>
						<button type="submit" value="submit" style="background-color:transparent;  border:0px transparent solid;"/>
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
    <div class="left" style="width:100%;">
        <div style="margin-bottom:10px;"></div>
        <table id="grid" class="bList" data-grid-type="view"></table>
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

  var rsMdl = kendo.data.Model.define({
      ID:'SEQ',
      fields:{
          rn:{type:'string'}
          , userId:{type : 'string'}
          , name : {type : 'string'}
          , subject: {type : 'string'}
          , cntHit: {type : 'string'}
          , createDate: {type : 'string'}
          , seq: {type : 'string'}
      }
  });

  var buttonView = kendo.observable({
    visible: {
      search: true,
      create: true,
      update: true,
	  view: true
    },
    search: function () {
     searchView.submit();
    },
      add: function () {

          grid.prependRow(dataItem, {focus: true});
          //inputView.set('rowKey', grid.getRowAt(0)['rowKey']);
          //inputView.set('rowIndex', 0)
          //inputView.set('data', dataItem);
          //this.set('btnGrp1Visible', true);

          setPageUI('add');
      },
    create: function(e) {
      var createUrlL = window.location.protocol + "//"
					+ window.location.host
					+ window.location.pathname.replace(/init/g,"form")
					+ window.location.search
      document.location.href=createUrlL;
    },
    // update: function(e) {
    //   var updateUrl = window.location.protocol + "//"
    //       + window.location.host
    //       + window.location.pathname.replace(/init/g,"form/107")
	// 				+ window.location.search
    //   document.location.href=updateUrl;
    // },
    // view: function(e) {
    //   var viewUrl = window.location.protocol + "//"
    //       + window.location.host
    //       + window.location.pathname.replace(/init/g,"view/107")
    //       + window.location.search
    //   document.location.href=viewUrl;
    // },
  });

  buttonView.bind('change', function(e) {

      if (this.get(e.field)) {

          this.set('search', false);

          if (searchView.get('rowKey') != null) {
              if (grid.getRow(searchView.get('rowKey')) != null)
                  grid.disableRow(searchView.get('rowKey'));
          }
          $(pagination._view._containerElement).hide();
      } else {
          this.set('search', true);

          if (searchView.get('rowKey') != null) {
              if (grid.getRow(searchView.get('rowKey')) != null)
                  grid.enableRow(searchView.get('rowKey'));
          }
          $(pagination._view._containerElement).show();
      }
  });

  kendo.bind($("div.sub-con-wrap"), buttonView);


  var searchView = kendo.observable({
      rowKey: null,
      criteria: {
      },

      rowIndex: 0,
      data: null,

      submit: function () {
          goPage('grid1', 1);
          return false;
      }
  });

  kendo.bind($("#frm_search"), searchView);

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

	  <c:if test="${type == 'notice'}">
		  $("#cmb_category_search").kendoDropDownList({
			  enable: false
		  });
	  </c:if>
  }

  function goPage(gridId, page) {
      if (gridId == "grid1") {
          searchView.set("rowKey", null);
          net.readData(1, searchView.criteria.toJSON(), true);
      }
  }

  $(document).ready(function () {

	  $("#date_search_option").val("01").change();

      validatable = $("#form_container").kendoValidator({validateOnBlur: false})
          .data("kendoValidator");

      tui.Grid.applyTheme('clean');
      grid = new tui.Grid({
          el: $('#grid'),
          scrollX: false,
          scrollY: true,
          rowHeight: 30,
          useClientSort: false,
          showDummyRows: false,
          minBodyHeight: 30,
          bodyHeight: 600,
          pagination: true,
          selectionUnit: 'ROW',
          editingEvent: false,
          usageStatistics: false,
          treeColumnOptions: {
              name: 'SEQ',
              useCascadingCheckbox: false
          },

          columns: [
                {title: '번호', name: 'rn', align: 'center', width: 100}
              , {title: '제목', name: 'subject', align: 'left',  formatter: function(value, rowData) {

					 var regDate = rowData.createDate;
					 var subject = rowData.subject;
					 var tag = "";
					 var date = new Date();
					 var year = date.getFullYear();
					 var month = new String(date.getMonth()+1);
					 var day = new String(date.getDate());
					 if(month.length == 1){
					 	month = "0" + month;
					 }
					 if(day.length == 1){
						 day = "0" + day;
					 }
					 var today = year + "-" + month + "-" + day;
					 if(regDate == today){

					 	tag = "<i class='ic1 new'>N</i>";
						subject = value+" "+tag;
					 }else{
					 	tag = "<i class=''></i>";
						subject = tag + " "+value;
					 }
					 return subject;
				  }}
              , {title: '작성자', name: 'name', align: 'center', width: 150}
              , {title: '작성일', name: 'createDate', align: 'center', width: 150}
              , {title: '조회수', name: 'cntHit', align: 'center', width: 150}
              , {title: 'seq', name: 'seq', align: 'center', hidden: true}
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
          // For all response (regardless of success or failure)tk
          _dicasPage.maskClose();
      }).on('successResponse', function (data) {
          if (data.requestType == 'readData') {
              //inputView.set('data', null);
              //inputView.set('rowKey', null);
              //inputView.set('rowIndex', 0);
          } else {
          }
      }).on('failResponse', function (data) {
      }).on('errorResponse', function (data) {
      }).on('focusChange', function (eventData) {
      }).on('click', function (eventData) {
		  var key = this.getRow(eventData.rowKey).seq;

		  var viewUrl = window.location.protocol + "//"
				  + window.location.host
				  + window.location.pathname.replace(/init/g,"view/"+key)
				  + window.location.search
		  document.location.href=viewUrl;
      });

      net = grid.getAddOn('Net');
      pagination = grid.getPagination();
      pagination.on('afterMove', function (eventData) {
          if (grid.getRowCount() > 0)
              grid.focusAt(0, 0);
      });

      setPageUI("init");

      searchView.submit();

		if (_dicasPage.requestParams != null) {

			_dicasPage.maskOpen();

			var seq = _dicasPage.requestParams.seq;
			var viewUrl = window.location.protocol + "//"
					+ window.location.host
					+ window.location.pathname.replace(/init/g, "view/" + seq)
					+ window.location.search

			document.location.href = viewUrl;
		}
  });
</script>