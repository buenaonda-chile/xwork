<%-- [EN] Variable definition --%>
<%-- [JP] 変数定義 --%>
<c:url var="initUrl" value="/mobile/serviceSD/init" />
<c:url var="initServiceUrl" value="/mobile/serviceSD/init/${serviceId}/service"/>
<c:url var="initDtcUrl" value="/mobile/serviceSD/init/${serviceId}/dtc"/>
<c:url var="initConsultUrl" value="/mobile/serviceSD/init/${serviceId}/consult"/>

<c:url var="initResearchUrl" value="/mobile/serviceSD/init/${serviceId}/research"/>
<c:url var="initResultUrl" value="/mobile/serviceSD/init/${serviceId}/result"/>
<c:url var="initCostUrl" value="/mobile/serviceSD/init/${serviceId}/cost"/>

<%-- 부품검색  --%>
<c:url var="readUrl" value="/popup/partNumber/search"/>

<%-- 코드검색  --%>
<c:url var="codeUrl" value="/code/list.json"/>

<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] ??ID (@ViewId???) --%>
<c:set var="screenId" value="<%= request.getAttribute(Globals.SCREEN_ID_KEY) %>"/>

<!--◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ #head ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆-->
<div id="head" class="init">
  <!-- container -->
  <div id="headerView" class="container">
    <h1>부품검색 도움</h1>
  </div>
  <!-- /container -->

</div>
<!--◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ /#head ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆-->

<%--<hr class="dpn" />--%>

<!--◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ #cnb1 ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆-->

<%--<div id="cnb1" class="init">--%>
  <%--<ul>--%>
    <%--<li><a href="${initResearchUrl}"><i class="ic4"></i><span class="t1">조사</span></a></li>--%>
    <%--<li class="on"><a href="javascript:;"><i class="ic5"></i><span class="t1">결과</span></a></li>--%>
    <%--<li><a href="${initCostUrl}"><i class="ic6"></i><span class="t1">비용</span></a></li>--%>
  <%--</ul>--%>
<%--</div>--%>
<!--◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ /#cnb1 ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆-->

<!--◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ #body_content ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆-->
<div id="body_content" class="body_cnb1 init"> <!-- cnb1 가 있는 경우 body_cnb1을 넣어준다-->
  <!-- container -->
  <div class="container">
    <!-- 등록 -->
    <table id="view_container" class="bWrite">
      <col style="width:90px" />
      <col />
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
      </tr>
      <tr>
        <th>부품구분</th>
        <td>
          <kendo:dropDownList name="cmb_partDiv_search" dataTextField="codeNm"
                              data-value-primitive="true"
                              dataValueField="codeCd"
                              data-bind="value: criteria.partDiv"
                              optionLabel="전체" style="width: 100%;">
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
      </tr>
      <tr>
        <th>배기형식</th>
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
      <tr>
        <th>품명</th>
        <td>
          <input type="text" id="exchangeNm_search" data-bind="value: criteria.exchangeNm" />
        </td>
      </tr>
      <tr>
        <th>고객품번</th>
        <td>
          <input type="text" id="hmc_search" data-bind="value: criteria.hmc" />
        </td>
      </tr>
      <tr>
        <th>엔진명</th>
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
        <button type="button " class="button" data-bind="click: search" >검색</button>
      </tr>
    </table>

    <table id="view_container2" class="bWrite">
      <col style="width:90px" />
      <col />
      <%-- container --%>
      <div id="list_container" class="container" data-template="listTemplate" data-bind="source: data">
        <%-- 리스트 --%>
        <div class="bList" data-bind="click: send">
        <span class="txt">
          고객품번 : 94023-35220
          <i class="ic_bar"></i>
          품명 : Cluster
        </span>
        </div>
        <%--// 리스트 --%>
      </div>
      <%--// container --%>
    </table>

    <!-- btns -->

    <div class="btns tac">
      <button id="btnMore" type="button" class="button">더보기</button>
    </div>
    <!-- /btns -->
    <!-- /등록 -->
  </div>
  <!-- /container -->
</div>
<!--◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ /#body_content ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆-->

<script id="listTemplate" type="text/x-kendo-template">
  <div class="bList" data-bind="click: send" data-hmc="#= hmc #" data-nm="#= exchangeNm #">
      <span class="txt">
          고객품번 : #= hmc #
          <i class="ic_bar"></i>
          품명 : #= exchangeNm #
      </span>
  </div>
</script>

<script type="text/javascript">

  var _dicasPage = new DicasPage('${screenId}');
  var _openerPage = window.opener._dicasPage;

  var pageIndex = 1;
  var boardMdl = kendo.data.Model.define({
    id: 'manageNo',
    fields: {
      rn: { type: 'string' }
      ,maker: { type: 'string' }
      ,exhaustReg: { type: 'string' }
      ,engineType: { type: 'string' }
      ,exchangeNm: { type: 'string' }
      ,hmc: { type: 'string' }
      ,denso: { type: 'string' }
      ,partDiv: { type: 'string' }
      ,useYn: { type: 'string' }
      ,groupId: { type: 'string' }
      ,partsCost: { type: 'number' }
      ,margin: { type: 'number' }
      ,workHour: { type: 'number' }
    }
  });

  var searchView = kendo.observable({
    criteria: {
      searchKeyword: null,
      maker: null,
      partDiv : null,
      exhaustReg: null,
      exchangeNm: null,
      hmc: null,
      engineType: null
    },
    search: function(e) {
      e.preventDefault();
      $("#list_container").html("");
      pageIndex = 1;
      goPage(pageIndex);
    }
  });
  kendo.bind($('#body_content'), searchView);

  var listView = kendo.observable({
    data: [],
      send: function(e) {
        console.log(window.parent);
        console.log(e.data.hmc); //고객품번
        console.log(e.data.id);
        console.log(e.data.denso); //교환품번
        console.log(e.data.exchangeNm);

        var data = {
            hmc: e.data.hmc,
            id: e.data.id,
            exchangeNm: e.data.exchangeNm,
            replacePartNo : e.data.denso
        };

        _openerPage.codeHelpVal = JSON.stringify(data);
        window.close();
      }
  });
  kendo.bind($('#list_container'), listView);

  var boardDs = new kendo.data.DataSource({
    autoSync: false,
    serverPaging: true,
    page: 1,
    pageSize: 25,
    schema: {
      type: 'json',
      total: 'data.pagination.totalCount',
      data: 'data',
      model: boardMdl
    },
    transport: {
      read: {
        type: 'GET',
        url: '${readUrl}',
        dataType: 'json',
        contentType: 'application/json'
      },
      parameterMap: function(data, type) {
        if (type == 'read') {
          var _data = $.extend(searchView.criteria.toJSON, {perPage: data.pageSize, page: data.page});
          _data = $.extend(_data, searchView.criteria.toJSON());
          return _data;
        }
      }
    },
    requestStart: function(e) {
      _dicasPage.maskOpen();
      $("#btnMore").addClass("button_more");
    },
    requestEnd: function(e) {
      _dicasPage.maskClose();
      $("#btnMore").removeClass("button_more");
    },
    error: function(e) {
      try {
        _dicasPage.alert({
          title: '알림',
          message: e.xhr.responseJSON.message
        });
      } catch(e) {
        _dicasPage.alert({
          title: '알림',
          message: "클레임 접수 처리 중 오류가 발생하였습니다."
        });
      }
    },
    change: function(e) {
      if (e.action !== undefined) {
      } else {
        var _data = e.items[0].contents.toJSON();
        for(var i in _data) {
          listView.data.push(_data[i]);
        }
      }
    }
  });

  function goPage(page) {
    boardDs.page(page);
  }

  $(document).ready(function(){
    pageIndex = 1;
    goPage(pageIndex);

    $("#btnMore").click(function() {
      pageIndex++;
      goPage(pageIndex);
    });
  });

</script>