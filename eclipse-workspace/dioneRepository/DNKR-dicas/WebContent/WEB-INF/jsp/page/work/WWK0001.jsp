<%-- [EN] Variable definition --%>
<%-- [JP] ???? --%>
<c:url var="codeUrl" value="/code/list.json"/>

<!-- 서비스 -->
<c:url var="readUrl" value="/service/search"/>
<c:url var="createUrl" value="/service/create"/>
<c:url var="updateUrl" value="/service/update"/>
<c:url var="deleteUrl" value="/service/delete"/>

<c:url var="initUrl" value="/service/init"/>

<!-- 현상 -->
<c:url var="readUrl2" value="/phenomenon/search"/>
<c:url var="createUrl2" value="/phenomenon/create"/>
<c:url var="updateUrl2" value="/phenomenon/update"/>
<c:url var="deleteUrl2" value="/phenomenon/delete"/>

<!-- DTC -->
<c:url var="readUrl3" value="/phenomenonSub/search"/>
<c:url var="createUrl3" value="/phenomenonSub/create"/>
<c:url var="updateUrl3" value="/phenomenonSub/update"/>
<c:url var="deleteUrl3" value="/phenomenonSub/delete"/>

<!-- 상담 -->
<c:url var="readUrl4" value="/consulting/search"/>
<c:url var="createUrl4" value="/consulting/create"/>
<c:url var="updateUrl4" value="/consulting/update"/>
<c:url var="deleteUrl4" value="/consulting/delete"/>

<!-- 차량 -->
<c:url var="readUrl5" value="/vehicle/search"/>
<c:url var="createUrl5" value="/vehicle/create"/>
<c:url var="updateUrl5" value="/vehicle/update"/>
<c:url var="deleteUrl5" value="/vehicle/delete"/>

<!-- 결과상태변경 -->
<c:url var="updateUrl6" value="/resultMaster/update4"/>

<!-- 팝업 -->
<c:url var="popupUrl1" value="/popup/claimVehicle/init"/>
<c:url var="popupUrl2" value="/popup/models/init"/>
<c:url var="popupUrl3" value="/popup/office2/init"/>
<c:url var="popupUrl4" value="/research/init"/>
<c:url var="popupUrl5" value="/popup/partNumber/init"/>
<c:url var="popupUrl6" value="/popup/dtc/init"/>

<c:url var="readUrl6" value="/claimVehicle/searchByKey"/>
<c:url var="readUrl7" value="/user/search2"/>
<c:url var="readUrl8" value="/office/search2"/>

<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] ??ID (@ViewId???) --%>
<c:set var="screenId" value="<%= request.getAttribute(Globals.SCREEN_ID_KEY) %>"/>

<form id="frm_search" method="get">
  <div class="sub-con-wrap">
    <h2 class="subpage-tit">클레임 접수</h2>
    <!-- 버튼들 -->
    <div class="sub-btn-group">
      <!--<button type="button" id="btn_cancel" class="button" data-bind="click: cancel"><i class="w_cancel"></i>초기화</button>-->
      <button type="button" id="btn_newData" class="button" data-bind="click: newData"><i class="w_add"></i>신규</button>
      <button type="button" id="btn_search" class="button" data-bind="click: search"><i class="w_cancel"></i>조회</button>
      <button type="button" id="btn_save" class="button bc2" data-bind="click: save"><i class="w_save"></i>저장</button>
      <!--<button id="btn_cancel2" type="button"  class="button" data-bind="click: cancel2"><i class="w_cancel"></i>취소</button>-->
      <!--<button type="button" id="btn_save2" class="button bc2" data-bind="click: save2"><i class="w_save"></i>승인요청</button>-->
      <!--<button type="button" id="btn_cancel" class="button" data-bind="click: cancel"><i class="w_down"></i>닫기</button>-->
    </div>
    <!-- /버튼들 -->
  </div>

  <!-- 차량제원 -->
  <div class="layout-B">
    <table class="base_btn" style="width:100%;">
      <tr>
        <td style="width:100px;"><h2>차량제원</h2></td>
        <td class="search2">
          <input type="text" id="vinNo_search" data-bind="value: criteria.vinno" disabled="disabled" />
          <!--<button class="button"><i class="w_search"></i> 검색팝업</button>-->
          <span>
          <button type="button" class="button" data-bind="click: popup1">
            <i class="w_nwin"></i>검색팝업
          </button>
        </span>
          <span class="explain">&nbsp;&nbsp;※ 차량 상세 검색</span>
        </td>
        <td class="tar">
          <button type="button" class="button bc1" data-bind="click: popup4"><i class="w_claim"></i>
            클레임조사
          </button>
        </td>
      </tr>
    </table>
  </div>
</form>

<div id="form_container3">
  <form id="frm_input3" method="post">
    <table class="bWrite">
      <colgroup>
        <col style="width:85px"/>
        <col/>
        <col style="width:85px"/>
        <col/>
        <col style="width:85px"/>
        <col/>
        <col style="width:85px"/>
        <col/>
      </colgroup>
      <tr>
        <th>판매국가</th>
        <td>
          <kendo:dropDownList name="cmb_saleCountry_input" dataTextField="codeNm"
                              dataValueField="codeCd"
                              data-value-primitive="true"
                              data-bind="value: data3.saleCountry" required="required">
            <kendo:dataSource data="${saleCountryItems}"/>
          </kendo:dropDownList>
        </td>
        <th>승상용</th>
        <td>
          <kendo:dropDownList name="cmb_tireStd_input" dataTextField="codeNm"
                              dataValueField="codeCd"
                              data-value-primitive="true"
                              data-bind="value: data3.tireStd" required="required">
            <kendo:dataSource data="${tireStdItems}"/>
          </kendo:dropDownList>
        </td>
        <th>메이커</th>
        <td>
          <kendo:dropDownList name="cmb_maker_input" dataTextField="codeNm"
                              dataValueField="codeCd"
                              data-value-primitive="true"
                              data-bind="value: data3.maker" required="required">
            <kendo:dataSource data="${makerItems}"/>
          </kendo:dropDownList>
        </td>
        <th>차종</th>
        <td>
          <div class="search_input" style="width:180px;">
            <input type="text" id="model_search" data-bind="value: data3.model" disabled="disabled" required />
            <button type="button" data-bind="click: popup2"><i class="ic_search1"></i><span
                    class="blind">검색</span></button>
            <!--<button type="button" class="button" data-bind="click: popup2">
                <i class="w_nwin"></i>팝업
            </button>-->
          </div>
        </td>
      </tr>
      <tr>
        <!--<th>납입처</th>
        <td><select name="select5" id="select5">
          <option value="">HMC</option>
        </select></td>-->
        <th>배기형식</th>
        <td>
          <kendo:dropDownList name="cmb_exhaustReg_input" dataTextField="codeNm"
                              dataValueField="codeCd"
                              data-value-primitive="true"
                              autoBind="false"
                              data-bind="value: data3.exhaustReg" required="required">
            <%--<kendo:dataSource data="${exhaustRegItems}"/>--%>
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
          <kendo:dropDownList name="cmb_engineType_input" dataTextField="codeNm"
                              dataValueField="codeCd"
                              data-value-primitive="true"
                              autoBind="false"
                              data-bind="value: data3.engineType" required="required">
            <%--<kendo:dataSource data="${engineTypeItems}"/>--%>
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
        <td colspan="2">&nbsp;</td>
        <th rowspan="2">비고</th>
        <td rowspan="2"><textarea id="remark_input" data-bind="value: data3.remark" rows="5"
                                  cols="40" class="w100" style="min-height:55px;"></textarea></td>
      </tr>
      <tr>
        <th>VIN NO</th>
        <td>
          <input type="text" id="vinno_input" data-bind="value: data3.vinno" required/>
          <input type="hidden" id="masterId_input" data-bind="value: data3.masterId"/>
          <input type="hidden" id="id_input" data-bind="value: data3.id"/>
        </td>
        <th>생산일</th>
        <td>
          <input type="text" id="dp_prodDate_input" data-bind="value: data3.prodDate" class="calendar" required/>
        </td>
        <th>판매일</th>
        <td>
          <input type="text" id="dp_saleDate_input" data-bind="value: data3.saleDate" class="calendar" required/>
        </td>
      </tr>
    </table>
    <!-- /차량제원 -->
  </form>
</div>

<!-- 서비스내역(접수) -->
<div class="layout-LW">
  <!-- 좌측 -->
  <div class="left" style="width:40%;">
    <table style="width:100%;height:40px;">
      <tr>
        <td><h2>서비스내역(접수)</h2></td>
        <td class="tar">
          <div id="gridDiv1">
            <button type="button" id="btn_add" class="button" data-bind="click: add"><i
                    class="b_plus"></i><span class="blind">추가</span></button>
            <button type="button" id="btn_remove" class="button" data-bind="click: remove"><i
                    class="b_minus"></i><span class="blind">삭제</span></button>
          </div>
        </td>
      </tr>
    </table>
    <div style="margin-bottom:10px;"></div>
    <div id="grid" data-grid-type="view"></div>
    <!--<table class="bList">
      <thead>
      <tr>
        <th><input type="checkbox" id="" name="" value="" /></th>
        <th>CLMNo</th>
        <th>SNO</th>
        <th>상태</th>
        <th>접수일</th>
        <th>접수자</th>
      </tr>
      </thead>
      <tbody>
      <tr class="tac">
        <td><input type="checkbox" id="input" name="input" value="" /></td>
        <td>KR-000011587</td>
        <td>1</td>
        <td>상담</td>
        <td>2018-08-08</td>
        <td>김수은</td>
      </tr>
      </tbody>
    </table>-->
  </div>
  <!-- // 좌측 -->

  <!-- 우측 -->
  <div id="form_container" class="right" style="width:58%;padding-top:40px;">
    <form id="frm_input" method="post">
      <table class="bWrite">
        <colgroup>
          <col style="width:90px"/>
          <col/>
          <col style="width:90px"/>
          <col/>
        </colgroup>
        <tr>
          <th>접수일</th>
          <td>
            <input type="text" id="dp_receiptDate_input" data-bind="value: data.receiptDate" class="calendar"/>
          </td>
          <th>접수구분</th>
          <td><!--<input type="text" id="div_input" data-bind="value: data.div" />-->
            <!--<input type="text" id="" value="" disabled="disabled" style="width:50%;" />-->
            <kendo:dropDownList name="cmb_div_input" dataTextField="codeNm"
                                dataValueField="codeCd"
                                data-value-primitive="true"
                                data-bind="value: data.div">
              <kendo:dataSource data="${divItems}"/>
            </kendo:dropDownList>
          </td>
        </tr>
        <tr>
          <th>사용개월</th>
          <td>
            <input type="text" id="useMonth_input" data-bind="value: data.useMonth" disabled="disabled"/>
            <input type="text" id="qualityIndex_input" data-bind="value: data.qualityIndex" disabled="disabled"/>
            <!--<button type="button" class="button">${data.qualityIndex}</button>-->
          </td>
          <!--<th>생산거점</th>
          <td colspan="3"><select name="" id="">
            <option value="" selected="selected">DNJP</option>
          </select></td>-->
          <th>부품구분</th>
          <td>
            <kendo:dropDownList name="cmb_partDiv_input" dataTextField="codeNm"
                                dataValueField="codeCd"
                                data-value-primitive="true"
                                data-bind="value: data.inquiryGubun">
              <kendo:dataSource data="${partDivItems}"/>
            </kendo:dropDownList>
          </td>
        </tr>
        <tr>
          <th>소재지</th>
          <td>
            <kendo:dropDownList name="cmb_officeCity_input" dataTextField="codeNm"
                                dataValueField="codeCd"
                                data-value-primitive="true"
                                autoBind="false"
                                data-bind="value: data.officeCity"
                                optionLabel="전체">
              <%--<kendo:dataSource data="${officeCityItems}"/>--%>
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
          <th>문의품</th>
          <td>
            <div class="search_input" style="width:180px;">
              <input type="text" id="inquiry_input" data-bind="value: data.inquiry" disabled="disabled"/>
              <button type="button" data-bind="click: popup5"><i class="ic_search1"></i><span
                      class="blind">검색</span></button>
            </div>
          </td>
        </tr>
        <tr>
          <th>정비소명</th>
          <td>
            <div class="search_input" style="width:180px;">
              <input type="text" id="officeNane_input" data-bind="value: data.officeNm" disabled="disabled"/>
              <input type="hidden" id="officeCode_input" data-bind="value: data.officeCode" disabled="disabled"/>
              <button type="button" data-bind="click: popup3"><i class="ic_search1"></i><span
                      class="blind">검색</span></button>
            </div>
          </td>
          <th>상담예정</th>
          <td>
            <kendo:dropDownList name="cmb_consultingExp_input" dataTextField="fulnm"
                                dataValueField="acctId"
                                data-value-primitive="true"
                                autoBind="false"
                                data-bind="value: data.consultingExp">
              <%--<kendo:dataSource data="${officeCityItems}"/>--%>
              <kendo:dataSource>
                <kendo:dataSource-transport>
                  <kendo:dataSource-transport-read url="${readUrl7}" type="POST" contentType="application/json"/>
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
          <th rowspan="2">정비사정보</th>
          <td><input type="text" id="mechanic1Nm_input" data-bind="value: data.mechanic1Nm"/></td>
          <th>주행거리</th>
          <td>
            <kendo:numericTextBox name="mileage_input" format="###,###,###,###,###" min="0"
                                  data-bind="value: data.mileage"/>
          </td>
        </tr>
        <tr>
          <td><input type="text" id="mechanic1Tel_input" data-bind="value: data.mechanic1Tel"/></td>
          <th>보증</th>
          <td>
            <!--<input type="checkbox" id="warranty_input" value="0" data-bind="checked: warranty"/>-->
            <input type="radio" name="warranty_input" value="0" data-bind="checked: data.warranty" />보증
            <input type="radio" name="warranty_input" value="1" data-bind="checked: data.warranty" />미보증
          </td>
        </tr>
      </table>
    </form>
  </div>
  <!-- // 우측 -->
</div>
<!-- // 서비스내역(접수) -->

<!-- 현상 -->
<div class="layout-LW">
  <!-- 좌측 -->
  <div class="left" style="width:49%;">

    <table style="width:100%;height:40px;">
      <tr>
        <td><h2>현상/DTC</h2></td>
        <td class="tar">
          <div id="gridDiv2">
            <button type="button" id="btn_add2" class="button" data-bind="click: add"><i
                    class="b_plus"></i><span class="blind">추가</span></button>
            <button type="button" id="btn_remove2" class="button" data-bind="click: remove"><i
                    class="b_minus"></i><span class="blind">삭제</span></button>
          </div>
        </td>
      </tr>
    </table>
    <div style="margin-bottom:10px;"></div>
    <div id="grid2" data-grid-type="view"></div>
  </div>
  <!-- // 좌측 -->

  <!-- 우측 -->
  <div class="right" style="width:49%;">
    <table style="width:100%;height:40px;">
      <tr>
        <td class="tar">
          <div id="gridDiv3">
            <button type="button" id="btn_add3" class="button" data-bind="click: add"><i
                    class="b_plus"></i><span class="blind">추가</span></button>
            <button type="button" id="btn_remove3" class="button" data-bind="click: remove"><i
                    class="b_minus"></i><span class="blind">삭제</span></button>
          </div>
        </td>
      </tr>
    </table>
    <div style="margin-bottom:10px;"></div>
    <div id="grid3" data-grid-type="view"></div>
    <!--<table class="bList">
      <thead>
      <tr>
        <th><input type="checkbox" id="" name="" value="" /></th>
        <th>DTC</th>
        <th>DTC NAME</th>
      </tr>
      </thead>
      <tbody>
      <tr class="tac">
        <td><input type="checkbox" id="" name="" value="" /></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr class="tac">
        <td><input type="checkbox" id="" name="" value="" /></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr class="tac">
        <td><input type="checkbox" id="" name="" value="" /></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      </tbody>
    </table>-->
  </div>
  <!-- // 우측 -->
</div>
<!-- // 현상 -->

<!-- 상담 -->
<div id="form_container2">
  <form id="frm_input2" method="post">
    <div class="layout-B">
      <table style="width:100%;height:40px;">
        <tr>
          <td><h2>상담</h2></td>
          <td class="tar">
            <div id="divDelBtn1">
              <button id="btn_add1" type="button" class="button" data-bind="click: add" ><i class="b_plus"></i>상담추가</button>
              <button id="btn_remove1" type="button" class="button" data-bind="click: remove, visible: btnGrpVisible" ><i class="w_minus"></i>상담삭제</button>
            </div>
          </td>
          <!--<td class="tar">
            <button class="button"><i class="b_plus"></i><span class="blind">추가</span></button>
            <button class="button"><i class="b_minus"></i><span class="blind">삭제</span></button>
          </td>-->
        </tr>
      </table>
      <table class="bWrite">
        <colgroup>
          <col style="width:85px"/>
          <col/>
          <col style="width:85px"/>
          <col/>
          <col style="width:85px"/>
          <col/>
          <col style="width:85px"/>
          <col style="width:155px"/>
        </colgroup>
        <tr>
          <th>상담일</th>
          <td>
            <input type="text" id="dp_consultingDate_input" data-bind="value: data2.consultingDate" class="calendar" />
          </td>
          <th>상담자</th>
          <td>
            <kendo:dropDownList name="cmb_consultingNm_input" dataTextField="fulnm"
                                dataValueField="acctId"
                                data-value-primitive="true"
                                autoBind="false"
                                data-bind="value: data2.consultingNm">
              <%--<kendo:dataSource data="${officeCityItems}"/>--%>
              <kendo:dataSource>
                <kendo:dataSource-transport>
                  <kendo:dataSource-transport-read url="${readUrl7}" type="POST" contentType="application/json"/>
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
            <input type="hidden" id="consulting_id_input" data-bind="value: data2.id"/>
            <input type="hidden" id="consulting_vinno_input" data-bind="value: data2.vinno"/>
            <input type="hidden" id="consulting_manageNo_input" data-bind="value: data2.manageNo"/>
            <input type="hidden" id="consulting_serviceDegree_input"
                   data-bind="value: data2.serviceDegree"/>
            <input type="hidden" id="consulting_consultingDegree_input"
                   data-bind="value: data2.consultingDegree"/>
          </td>
          <th>출동구분</th>
          <td>
            <kendo:dropDownList name="cmb_auditInfo_input" dataTextField="codeNm"
                                dataValueField="codeCd"
                                data-value-primitive="true"
                                data-bind="value: data2.auditInfo"
                                change="auditOnchange">
              <kendo:dataSource data="${auditInfoItems}"/>
            </kendo:dropDownList>
          </td>
          <td colspan="2">&nbsp;</td>
        </tr>
        <tr>
          <th>소재지</th>
          <td>
            <kendo:dropDownList name="cmb_officeCity2_input" dataTextField="codeNm"
                                dataValueField="codeCd"
                                data-bind="value: data2.officeCity"
                                optionLabel="선택해주세요.">
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
          <th>SD지정</th>
          <td>
            <kendo:dropDownList name="cmb_sdAppoint_input" dataTextField="officeNm"
                                cascadeFrom="cmb_officeCity2_input"
                                dataValueField="officeCd"
                                autoBind="false"
                                data-bind="value: data2.sdAppoint"
                                optionLabel="선택해주세요.">
              <kendo:dataSource serverFiltering="true">
                <kendo:dataSource-transport>
                  <kendo:dataSource-transport-read url="${readUrl8}" type="GET" contentType="application/json"/>
                  <kendo:dataSource-transport-parameterMap>
                    function(options){
                    //alert(options);
                    //alert(options.filter);
                    //alert(options.filter.filters[0]);
                    //alert(options.filter.filters[0].value);
                    //alert(JSON.stringify(options));
                    //return JSON.stringify(options);

                    return {
                    filter: options.filter.filters[0].value
                    }
                    }
                  </kendo:dataSource-transport-parameterMap>
                </kendo:dataSource-transport>
                <kendo:dataSource-schema data="data" total="total">
                </kendo:dataSource-schema>
              </kendo:dataSource>
            </kendo:dropDownList>
          </td>
          <th>출동알람</th>
          <td>
            <button type="button" class="button"><i class="b_down"></i>출동알람</button>
          </td>
          <td colspan="2">&nbsp;</td>
        </tr>
      </table>
    </div>
    <!-- // 상담 -->

    <div class="layout-LW">
      <!-- 좌측 -->
      <div class="left" style="width:100%;">
        <table class="bWrite">
          <tr>
            <th class="no_ic">정비소점검 /<br/>상담내용</th>
            <td>
              <textarea id="consultingCont_input" rows="5" cols="80" class="w100"
                        data-bind="value: data2.consultingCont"></textarea>
            </td>
          </tr>
        </table>
      </div>
      <!-- // 좌측 -->

      <!-- 우측 -->
      <!--<div class="right" style="width:49%;">
        <table class="bWrite">
          <tr>
            <th class="no_ic">정비소<br />상담내용</th>
            <td><textarea id="f1textarea" rows="5" cols="80" class="w100"></textarea></td>
          </tr>
        </table>
      </div>-->
      <!-- // 우측 -->
    </div>
  </form>
</div>

<script type="text/javascript">

  var _dicasPage = new DicasPage('${screenId}');

  <%-- Control Definition--%>
  var grid;
  var pagination;
  var net;
  <%--// Control Definition --%>

  <%-- Control Definition--%>
  var grid2;
  var pagination2;
  var net2;
  <%--// Control Definition --%>

  <%-- Control Definition--%>
  var grid3;
  var pagination3;
  var net3;
  <%--// Control Definition --%>

  <%-- Variable Definition --%>
  var validatable = null;
  <%--// Variable Definition --%>

  var consultingReturn;

  var codeMdl = kendo.data.Model.define({
    ID: 'ID',
    fields: {
      masterId: {type: 'string'}
      , manageNo: {type: 'string'}
      , serviceDegree: {type: 'number'}
      , condition: {type: 'string'}
      , maker: {type: 'string'}
      , vinno: {type: 'string'}
      , carNo: {type: 'string'}
      , exhaustReg: {type: 'string'}
      , engineType: {type: 'string'}
      , model: {type: 'string'}
      , consultingExp: {type: 'string'}
      , div: {type: 'string'}
      , manageNoId: {type: 'number'}
      , approvalNoId: {type: 'number'}
      , approvalNo: {type: 'string'}
      , receiptDate: {type: 'string'}
      , receiptNm: {type: 'string'}
      , inquiry: {type: 'string'}
      , country: {type: 'string'}
      , mileage: {type: 'number'}
      , unit: {type: 'string'}
      , occurDate: {type: 'string'}
      , relapseDate: {type: 'string'}
      , reappearance: {type: 'string'}
      , officeCode: {type: 'string'}
      , officeCity: {type: 'string'}
      , officeNm: {type: 'string'}
      , officeTel: {type: 'string'}
      , officeFax: {type: 'string'}
      , officeAddr: {type: 'string'}
      , expatNm: {type: 'string'}
      , expatTel: {type: 'string'}
      , mechanic1Nm: {type: 'string'}
      , mechanic1Tel: {type: 'string'}
      , mechanic2Nm: {type: 'string'}
      , mechanic2Tel: {type: 'string'}
      , wearingDate: {type: 'string'}
      , cs1000: {type: 'number'}
      , warranty: {type: 'number'}
      , officeFix: {type: 'number'}
      , rs1000: {type: 'number'}
      , inquiryGubun: {type: 'string'}
      , prodBase: {type: 'string'}
      , useMonth: {type: 'string'}
      , qualityIndex: {type: 'string'}
    }
  });

  var codeMdl2 = kendo.data.Model.define({
    ID: 'ID',
    fields: {
      vinno: {type: 'string'}
      , manageNo: {type: 'string'}
      , serviceDegree: {type: 'number'}
      , phenomenonDegree: {type: 'number'}
      , mainCategory: {type: 'string'}
      , smallCategory: {type: 'string'}
      , div: {type: 'string'}
      , masterState: {type: 'string'}
      , cateChkYn: {type: 'string'}
      , cateSubTranYn: {type: 'string'}

    }
  });

  var codeMdl3 = kendo.data.Model.define({
    ID: 'ID',
    fields: {
      vinno: {type: 'string'}
      , manageNo: {type: 'string'}
      , serviceDegree: {type: 'number'}
      , phenomenonCdDiv: {type: 'string'}
      , code: {type: 'string'}
      , explan: {type: 'string'}

    }
  });

  var codeMdl4 = kendo.data.Model.define({
    ID: 'ID',
    fields: {
      vinno: {type: 'string'}
      , manageNo: {type: 'string'}
      , serviceDegree: {type: 'number'}
      , consultingDegree: {type: 'number'}
      , consultingNm: {type: 'string'}
      , consultingType: {type: 'string'}
      , checkCont: {type: 'string'}
      , consultingCont: {type: 'string'}
      , consultingResult: {type: 'string'}
      , consultingDate: {type: 'string'}
      , auditInfo: {type: 'string'}
      , sdAppoint: {type: 'string'}
      , id: {type: 'string'}

    }
  });

  var codeMdl5 = kendo.data.Model.define({
    ID: 'ID',
    fields: {
      saleCountry: {type: 'string'}
      , tireStd: {type: 'string'}
      , model: {type: 'string'}
      , exhaustReg: {type: 'string'}
      , engineType: {type: 'string'}
      , remark: {type: 'string'}
      , vinno: {type: 'string'}
      , masterId: {type: 'string'}
      , prodDate: {type: 'string'}
      , saleDate: {type: 'string'}

    }
  });

  var newFlg = false;

  var searchView = kendo.observable({
    rowKey: null,
    criteria: {
      vinno: null,
      manageNo: null,
    },
    rowIndex: 0,
    data: {
      maker: null,
      model: null,
    },
    save: function () {
      inputView.save();
    },
    save2: function () {
      inputView.save2();
    },
    cancel: function () {

      if (inputView.hasChanges()) {
        if (!confirm("변경된 데이터가 있습니다. 취소 하시겠습니까?")) {
          return;
        }
      }

      <%--location.href='${initUrl}';--%>
      location.reload(true);
    },
    cancel2: function () {
      if (inputView.hasChanges()) {
        if (!confirm("변경된 데이터가 있습니다. 취소 하시겠습니까?")) {
          return;
        }
        grid.enable();
        grid.restore();
        buttonView.set('btnGrp1Visible', false);
        grid.focusAt(inputView.get('rowIndex'), 0);
      }
    },
    search: function () {

      var vinNo = $('#vinNo_search').val();
      if (vinNo == '') {
        alert("차량검색후에 서비스 검색이 가능합니다.");
        return;
      }

      goPage('grid1', 1);
      return false;
    },
    newData: function () {

      newFlg = true;
      // alert("차량신규등록이 가능합니다.")

      var dataItem = new codeMdl5().toJSON();
      inputView3.set('data3', dataItem);

      inputView3.set('data3.saleCountry', '01');

      var dropdownlist = $("#cmb_saleCountry_input").data("kendoDropDownList");
      dropdownlist.focus();

      inputView3Enabled();

      searchView.set('criteria.vinno', '');

      grid.clear();
      grid2.clear();
      grid3.clear();

      inputView.set('data', null);
      inputView2.set('data2', null);

      return;
    },
    popup1: function () {
      var that = this;
      _dicasPage.popupOpen({
        url: "${popupUrl1}",
        code: 'codeHelp',
        popupTitle: 'claimVehicle',
        width: 1500,
        height: 900,
        params: {
          codeVal: 'AAAA',
          codeVal1: 'BBBB'
        },
        beforeOpen: function () {
          _dicasPage.beforeCodeHelpVal = true;
        },
        afterClose: function (info) {
          if (info.result) {
            var _data = JSON.parse(info.data);
            that.set('criteria.vinno', _data.vinno);
            that.set('criteria.manageNo', null);
            inputView3.set('data3', _data);

            var temp = $("#dp_prodDate_input").val();
            $("#dp_prodDate_input").val(changeFormat(temp));

            temp = $("#dp_saleDate_input").val();
            $("#dp_saleDate_input").val(changeFormat(temp));

            inputView3Enabled();

            searchView.search();

            //inputView3.set('data3.vinno', info.data.vinno);
            //inputView3.set('data3.maker', info.data.maker);
            //inputView3.set('data3.model', info.data.model);
            //inputView3.set('data3.saleCountry', info.data.saleCountry);
            //inputView3.set('data3.tireStd', info.data.tireStd);
            //inputView3.set('data3.exhaustReg', info.data.exhaustReg);
            //inputView3.set('data3.engineType', info.data.engineType);
            //inputView3.set('data3.remark', info.data.remark);
            //inputView3.set('data3.prodDate', info.data.prodDate);
            //inputView3.set('data3.saleDate', info.data.saleDate);
          } else {
            //that.set('criteria.vinno', null);
            //that.set('criteria.manageNo', null);
            //inputView3.set('data3', null);

            //inputView3.set('data3.vinno', null);
            //inputView3.set('data3.maker', null);
            //inputView3.set('data3.model', null);
            //inputView3.set('data3.saleCountry', null);
            //inputView3.set('data3.tireStd', null);
            //inputView3.set('data3.exhaustReg', null);
            //inputView3.set('data3.engineType', null);
            //inputView3.set('data3.remark', null);
            //inputView3.set('data3.prodDate', null);
            //inputView3.set('data3.saleDate', null);
          }

        }
      });
    },
    //,
    //submit: function () {
    //    goPage('grid1', 1);
    //    return false;
    //},
    popup4: function () {

      //alert(grid.getValue(inputView.get('rowKey'), "manageNo", true)
      //+ " " + grid.getValue(inputView.get('rowKey'), "vinno", true)
      //+ " " + grid.getValue(inputView.get('rowKey'), "masterId", true));

      var that = this;
      _dicasPage.popupOpen({
        url: "${popupUrl4}",
        code: 'codeHelp',
        popupTitle: 'research',
        width: 1400,
        height: 800,
        params: {
          manageNo: grid.getValue(inputView.get('rowKey'), "manageNo", true),
          vinno: grid.getValue(inputView.get('rowKey'), "vinno", true),
          masterId: grid.getValue(inputView.get('rowKey'), "masterId", true)
        },
        beforeOpen: function () {
          _dicasPage.beforeCodeHelpVal = true;
        },
        afterClose: function (info) {
          console.log(info);
        }
      });
    },

  });
  kendo.bind($("#frm_search"), searchView);

  function inputView3Enabled() {

    $("input[type]", "#form_container3").each(function (i, v) {
      $(v).attr("disabled", false);
    });

    var dropdownlist = $("#cmb_saleCountry_input").data("kendoDropDownList");
    dropdownlist.readonly(false);
    dropdownlist = $("#cmb_tireStd_input").data("kendoDropDownList");
    dropdownlist.readonly(false);
    dropdownlist = $("#cmb_maker_input").data("kendoDropDownList");
    dropdownlist.readonly(false);
    dropdownlist = $("#cmb_exhaustReg_input").data("kendoDropDownList");
    dropdownlist.readonly(false);
    dropdownlist = $("#cmb_engineType_input").data("kendoDropDownList");
    dropdownlist.readonly(false);

    $("#remark_input").attr("disabled", false);

    $("#dp_prodDate_input").attr("readonly", false);
    $("#dp_saleDate_input").attr("readonly", false);

  }

  function inputView2Enabled() {

    var dropdownlist = $("#cmb_consultingNm_input").data("kendoDropDownList");
    dropdownlist.readonly(false);
    dropdownlist = $("#cmb_auditInfo_input").data("kendoDropDownList");
    dropdownlist.readonly(false);
    //dropdownlist = $("#cmb_officeCity2_input").data("kendoDropDownList");
    //dropdownlist.readonly(false);
    //dropdownlist = $("#cmb_sdAppoint_input").data("kendoDropDownList");
    //dropdownlist.readonly(false);

    $("#consultingCont_input").attr("disabled", false);

    $("#dp_consultingDate_input").attr("disabled", false);
    $("#dp_consultingDate_input").attr("readonly", false);

  }

  function inputView2Disabled() {

    var dropdownlist = $("#cmb_consultingNm_input").data("kendoDropDownList");
    dropdownlist.readonly();
    dropdownlist = $("#cmb_auditInfo_input").data("kendoDropDownList");
    dropdownlist.readonly();
    dropdownlist = $("#cmb_officeCity2_input").data("kendoDropDownList");
    dropdownlist.readonly();
    dropdownlist = $("#cmb_sdAppoint_input").data("kendoDropDownList");
    dropdownlist.readonly();

    $("#consultingCont_input").attr("disabled", true);

    $("#dp_consultingDate_input").attr("disabled", true);
    $("#dp_consultingDate_input").attr("readonly", true);
  }

  function parse(str) {
    var y = str.substr(0, 4);
    var m = str.substr(4, 2);
    var d = str.substr(6, 2);
    return new Date(y,m-1,d);
  }

  /**
   *  yyyyMMdd 포맷으로 반환
   */
  function getFormatDate(date){
    var year = date.getFullYear();                 //yyyy
    var month = (1 + date.getMonth());             //M
    month = month >= 10 ? month : '0' + month;     // month 두자리로 저장
    var day = date.getDate();                      //d
    day = day >= 10 ? day : '0' + day;             //day 두자리로 저장
    return  year + '-' + month + '-' + day;
  }

  //날짜포맷
  function changeFormat(temp) {
    if (temp.length == 8) {
      var date = parse(temp);
      temp = getFormatDate(date);
    }
    return temp;
  }

  //날짜포맷맞춰주는 함수
  $("#dp_prodDate_input").on('change keyup paste', function () {

    var temp = $("#dp_prodDate_input").val();
    $("#dp_prodDate_input").val(changeFormat(temp));
  });

  //날짜포맷맞춰주는 함수
  $("#dp_saleDate_input").on('change keyup paste', function () {

    var temp = $("#dp_saleDate_input").val();
    $("#dp_saleDate_input").val(changeFormat(temp));
  });


  var inputView = kendo.observable({
    rowIndex: 0,
    rowKey: null,
    data: null,
    //warranty: ["0"],
    save: function () {

      if (newFlg) {

        // 차량신규 유효성체크
        if (!inputView3.validate()) {
          alert('필수 항목을 입력해 주십시오.');
          return;
        }

        var temp1 = $("#dp_prodDate_input").val();
        var temp2 = $("#dp_saleDate_input").val();

        inputView3.set('data3.prodDate', temp1);
        inputView3.set('data3.saleDate', temp2);

          _dicasPage.maskOpen();

        $.ajax({
          method: "POST",
          url: '${createUrl5}',
          data: JSON.stringify(inputView3.get('data3')),
          dataType: 'JSON',
          contentType: 'application/json;charset=UTF-8'
        }).done(function (data, status, jqXHR) {

          if (data.data.errCd == 'E001') {

            if (confirm(data.data.msg)){
            /** 재조회*/
            newFlg = false;
            var skey = inputView3.get('data3.vinno');
            searchView.set('criteria.vinno', inputView3.get('data3.vinno'));
            searchView.search();

            //차량검색
            $.ajax(
                    {
                      type: 'GET',
                      url: '${readUrl6}',
                      dataType: 'json',
                      data: {page: '1', vinno: skey},
                      success: function (result) {
                        //alert(result.data);
                        inputView3.set('data3', result.data);
                        inputView3Enabled();

                        var temp = $("#dp_prodDate_input").val();
                        $("#dp_prodDate_input").val(changeFormat(temp));

                        temp = $("#dp_saleDate_input").val();
                        $("#dp_saleDate_input").val(changeFormat(temp));
                      }
                    });
            }
          } else {
            //goPage('grid1', 1);
            //마스터ID설정
            //newFlg = false;
            console.log(data.data.masterId);
            searchView.set('criteria.vinno', data.data.vinno);
            inputView3.set("data3.masterId", data.data.masterId);

            if (grid.getRowCount() > 0) {
              var rowKey = grid.getRowAt(0)['rowKey'];
              grid.setValue(rowKey, "masterId", inputView3.get('data3.masterId'));
              grid.setValue(rowKey, "vinno", inputView3.get('data3.vinno'));

              serviceUpdate();
            }
            newFlg = false;

            //goPage('grid1', 1);
            //return false;
          }

        }).fail(function (data, status, jqXHR) {
          alert("저장 중 오류가 발생하였습니다.");
        }).always(function () {
          _dicasPage.maskClose();
        });
        //return;
      } else {
        serviceUpdate();
      }

    },
    save2: function () {

      if (inputView3.get('data3.masterId') === undefined || inputView.get('data.manageNo') === undefined) {
        alert('저장후에 승인 요청이 가능합니다.');
        return;
      }
      var temp = grid.getRow(grid.getFocusedCell().rowKey);
      inputView4Ajax(temp);

    },
    validate: function () {
      if (validatable == null) return true;
      return validatable.validate();
    },
    hasChanges: function () {
      return grid.isModified();
    },
    popup3: function () {
      var that = this;
      _dicasPage.popupOpen({
        url: "${popupUrl3}",
        code: 'codeHelp',
        width: 1400,
        height: 800,
        params: {
          maker: inputView3.get('data3.maker'),
          officeNm: encodeURI($('#officeNane_input').val()),
          officeCity: inputView.get('data.officeCity'),
          partDiv: inputView.get('data.inquiryGubun')
        },
        beforeOpen: function () {
          _dicasPage.beforeCodeHelpVal = true;
        },
        afterClose: function (info) {
          if (info.result) {
            var _data = JSON.parse(info.data);
            that.set('data.officeCity', _data.officeCity);
            that.set('data.officeCode', _data.officeCd);
            that.set('data.officeNm', _data.officeNm);
            that.set('data.mechanic1Nm', _data.mechanic);
            that.set('data.mechanic1Tel', _data.mechanicTel);
          } else {
            //that.set('data.officeCode', null);
            //that.set('data.officeNm', null);
            //that.set('data.mechanic1Nm', null);
            //that.set('data.mechanic1Tel', null);
          }
        }
      });
    },
    popup5: function () {
      var that = this;
      _dicasPage.popupOpen({
        url: "${popupUrl5}",
        code: 'codeHelp',
        width: 1400,
        height: 800,
        params: {
          maker: inputView3.get('data3.maker'),
          exhaustReg: inputView3.get('data3.exhaustReg'),
          engineType: inputView3.get('data3.engineType'),
          partDiv: inputView.get('data.inquiryGubun'),
          exchangeNm: encodeURI($('#inquiry_input').val())
        },
        beforeOpen: function () {
          _dicasPage.beforeCodeHelpVal = true;
        },
        afterClose: function (info) {
          if (info.result) {
            var _data = JSON.parse(info.data);
            that.set('data.inquiry', _data.exchangeNm);
          } else {
            //that.set('data.inquiry', null);
          }
        }
      });
    },
    popup6: function () {
      var that = this;
      _dicasPage.popupOpen({
        url: "${popupUrl6}",
        code: 'codeHelp',
        width: 1300,
        height: 900,
        params: {
          exhaustReg: inputView3.get('data3.exhaustReg'),
          engineType: inputView3.get('data3.engineType')
        },
        beforeOpen: function () {
          _dicasPage.beforeCodeHelpVal = true;
        },
        afterClose: function (info) {
          if (info.result) {
            var _data = JSON.parse(info.data);

            for (var i=0; i<dtcItems.length; i++) {
              var data1 = dtcItems[i];
              // console.log(_data);
              // console.log(data1);
              if( _data.dtcCode == data1.value) {
                var gridRowkey = grid3.getFocusedCell().rowKey;
                grid3.setValue(gridRowkey, 'code', data1.value);
              }
            }
            // that.set('data.inquiry', _data.exchangeNm);
          } else {
            //that.set('data.inquiry', null);
          }
        }
      });
    }
  });
  inputView.bind('change', function (e) {

    if (e.field.indexOf('data.') > -1) {

      var itemNm = e.field.substr(5);
      grid.setValue(this.get('rowKey'), itemNm, this.get(e.field));
    }
  });
  kendo.bind($("#form_container"), inputView);

  function serviceUpdate() {

    if (inputView3.get('data3.masterId') === undefined ) {
      alert('차량선택 및 입력후에 저장이 가능합니다.');
      return;
    }

    if (!inputView.validate()) {
      alert('필수 항목을 입력해 주십시오.');
      return;
    }

    var vinNo = $('#vinno_input').val();
    if (vinNo == '') {
      alert("VIN NO는 필수 항목입니다.");
      return;
    }

    var message = "", iscreate = false, isupdate = false, isdelete = false, ischildUpdate = false,
            ischildUpdate2 = false, ischildUpdate3 = false, ischildUpdate4 = false;
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

    if (grid2.getModifiedRows().createdRows.length > 0 ||
            grid2.getModifiedRows().updatedRows.length > 0 ||
            grid2.getModifiedRows().deletedRows.length > 0
    ) {
      message = "변경된 데이터가 있습니다.  수정 하시겠습니까?";
      ischildUpdate = true;
    }
    if (grid3.getModifiedRows().createdRows.length > 0 ||
            grid3.getModifiedRows().updatedRows.length > 0 ||
            grid3.getModifiedRows().deletedRows.length > 0
    ) {
      message = "변경된 데이터가 있습니다.  수정 하시겠습니까?";
      ischildUpdate2 = true;
    }
    if (inputView2.hasChanges()) {
      message = "변경된 데이터가 있습니다.  수정 하시겠습니까?";
      ischildUpdate3 = true;
    }
    if (inputView3.hasChanges()) {
      message = "변경된 데이터가 있습니다.  수정 하시겠습니까?";
      ischildUpdate4 = true;
    }

    if (inputView.hasChanges() || ischildUpdate || ischildUpdate2 || ischildUpdate3
            || ischildUpdate4) {
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

        //ID 설정,manageNo 설정
        console.log(data.data);
        var rowKey = grid.getRowAt(0)['rowKey'];
        grid.setValue(rowKey, "manageNo", data.data.manageNo);
        grid.setValue(rowKey, "id", data.data.id);

        var rows = grid2.getRows();
        for (var i=0; i<rows.length; i++) {
          grid2.setValue(rows[i].rowKey, "manageNo", data.data.manageNo);
        }

        var rows2 = grid3.getRows();
        for (var i=0; i<rows2.length; i++) {
          grid3.setValue(rows2[i].rowKey, "manageNo", data.data.manageNo);
        }

        // 디테일 데이터 등록,수정,삭제
        detailAjax();
        detailAjax2();
        if (ischildUpdate3) {
          inputView2Ajax();
        }
        if (ischildUpdate4) {
          inputView3Ajax();
        }

        _dicasPage.maskClose();
        goPage('grid1', 1);
        return false;

      }).fail(function (data, status, jqXHR) {
        alert("저장 중 오류가 발생하였습니다.");
      }).always(function () {
        _dicasPage.maskClose();
      });
    } else if (isupdate) {

      var temp = dataMap.updatedRows[0];

      $.ajax({
        method: "POST",
        url: '${updateUrl}',
        data: JSON.stringify(dataMap.updatedRows[0]),
        contentType: 'application/json;charset=UTF-8'
      }).done(function (data, status, jqXHR) {

        //alert(temp.condition);

        // 디테일 데이터 등록,수정,삭제
        detailAjax();
        detailAjax2();
        if (ischildUpdate3) {
          inputView2Ajax();
        }
        if (ischildUpdate4) {
          inputView3Ajax();
        }

        _dicasPage.maskClose();
        goPage('grid1', 1);
        return false;
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
        return false;
      }).fail(function (data, status, jqXHR) {
        alert("삭제 중 오류가 발생하였습니다.");
      }).always(function () {
        _dicasPage.maskClose();
      });
    } else if (ischildUpdate) {

      // 디테일 데이터 등록,수정,삭제
      detailAjax();
      detailAjax2();
      if (ischildUpdate3) {
        inputView2Ajax();
      }
      if (ischildUpdate4) {
        inputView3Ajax();
      }
      _dicasPage.maskClose();
      goPage('grid1', 1);
      return false;
    } else if (ischildUpdate2) {

      // 디테일 데이터 등록,수정,삭제
      detailAjax2();
      if (ischildUpdate3) {
        inputView2Ajax();
      }
      if (ischildUpdate4) {
        inputView3Ajax();
      }
      _dicasPage.maskClose();
      goPage('grid1', 1);
      return false;
    } else if (ischildUpdate3) {

      inputView2Ajax();
      // 상담 데이터 등록,수정,삭제
      if (ischildUpdate4) {
        inputView3Ajax();
      }
      _dicasPage.maskClose();
      goPage('grid1', 1);
      return false;
    } else if (ischildUpdate4) {

      // 상담 데이터 등록,수정,삭제
      inputView3Ajax();
      _dicasPage.maskClose();
      goPage('grid1', 1);
      return false;
    } else {
      _dicasPage.maskClose();
    }

  }

  var buttonView = kendo.observable({
    //btnGrp0Visible: true,
    //btnGrp1Visible: false,
    //btnGrp2Visible: false,
    add: function () {

      var vinNo = $('#vinNo_search').val();
      if (vinNo == '') {
            alert('차량저장후에 서비스등록이 가능합니다.');
            return;
      }

      if (inputView3.get('data3.vinno') === undefined || inputView3.get('data3.vinno') == '') {
        alert('차량저장후에 서비스등록이 가능합니다.');
        return;
      }

      var dataItem = new codeMdl().toJSON();
      dataItem.manageNo = '-';

      grid.prependRow(dataItem, {focus: true});
      grid.focusAt(0,0);
      //grid.appendRow(dataItem, {focus: true});
      //var rowKey = grid.getFocusedCell().rowKey;
      var rowKey = grid.getRowAt(0)['rowKey'];
      inputView.set('rowKey', rowKey);
      inputView.set('rowIndex', 0);
      //inputView.set('rowIndex', grid.getRowCount());

      grid.setValue(rowKey, "masterId", inputView3.get('data3.masterId'));
      grid.setValue(rowKey, "serviceDegree", "1");
      //grid.setValue(rowKey, "vinno", inputView3.get('data3.vinno'));
      grid.setValue(rowKey, "vinno", $('#vinno_input').val());
      grid.setValue(rowKey, "manageNo", '-');
      grid.setValue(rowKey, "condition", '01');

      var today = new Date();
      var dd = today.getDate();
      var mm = today.getMonth()+1; //January is 0!
      var yyyy = today.getFullYear();

      if(dd<10) {
        dd='0'+dd
      }

      if(mm<10) {
        mm='0'+mm
      }

      today = yyyy+'-'+mm+'-'+dd;
      grid.setValue(rowKey, "receiptDate", today);

      inputView.set('data', dataItem);
      inputView.set('data.receiptDate', today);
      //this.set('btnGrp1Visible', true);

      grid.setValue(rowKey, "receiptNm2", '${loginVO.getFstNm()}');

      //today
      calCsRs();

      inputView.set('data.inquiryGubun', '01');
      var dropdownlist = $("#cmb_div_input").data("kendoDropDownList");
      dropdownlist.focus();

      setPageUI('add');

      searchView.criteria.manageNo = '-';
      //alert(searchView.criteria.manageNo);
      goPage('grid2', 1);
      goPage('grid3', 1);

      getConsultingView();
    },
    remove: function () {

      if (grid.getRowCount() == 0) {
        return;
      }

      //var gridRowkey = grid.getFocusedCell().rowKey;
      //grid.removeRow(gridRowkey);
      grid.removeRow(inputView.get('rowKey'));

      if (grid.getRowCount() > 0) {
        inputView.set('rowKey', grid.getRowAt(0)['rowKey']);
        inputView.set('rowIndex', 0);
        grid.focusAt(0, 0);
      } else {
        inputView.set('rowKey', null);
        inputView.set('rowIndex', null);
      }

      //buttonView.set('btnGrp1Visible', true);
    },
  });
  kendo.bind($("#gridDiv1"), buttonView);

  $("#dp_saleDate_input").on('change keyup paste', function () {
    calCsRs();
  });

  $("#dp_receiptDate_input").on('change keyup paste', function () {
    calCsRs();
  });

  function calCsRs() {

    var today = $("#dp_receiptDate_input").val();
    var saleDay = $("#dp_saleDate_input").val();

    //alert(today + saleDay);

    if (today !='' && saleDay != '') {

      var toDayDate = stringToDate(today,"yyyy-mm-dd","-");

      if (saleDay.length == 8) {
        saleDay = saleDay.substring(0,4) + '-' + saleDay.substring(4,6) + '-' + saleDay.substring(6,8);
      }
      //alert(prodDay);

      var saleDayDate = stringToDate(saleDay,"yyyy-mm-dd","-");

      //alert(toDayDate);
      //alert(prodDayDate);

      var temp = toDayDate - saleDayDate;
      var day = temp/1000/60/60/24;

      var text;
      if (day <= 90) {
        text = 'CS'
      } else if (day >= 271 && day <=365) {
        text = 'RS'
      } else if (day >= 0 && day <=365) {
        text = 'RS1'
      }

      inputView.set('data.useMonth', Math.ceil(day/30));
      inputView.set('data.qualityIndex', text);
    }

  }

  function stringToDate(_date,_format,_delimiter)
  {
    var formatLowerCase=_format.toLowerCase();
    var formatItems=formatLowerCase.split(_delimiter);
    var dateItems=_date.split(_delimiter);
    var monthIndex=formatItems.indexOf("mm");
    var dayIndex=formatItems.indexOf("dd");
    var yearIndex=formatItems.indexOf("yyyy");
    var month=parseInt(dateItems[monthIndex]);
    month-=1;
    var formatedDate = new Date(dateItems[yearIndex],month,dateItems[dayIndex]);
    return formatedDate;
  }

  function detailAjax() {

    if (grid2.getModifiedRows().createdRows.length > 0) {

      for (var i = 0; i < grid2.getModifiedRows().createdRows.length; i++) {
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

      for (var i = 0; i < grid2.getModifiedRows().updatedRows.length; i++) {
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

      for (var i = 0; i < grid2.getModifiedRows().deletedRows.length; i++) {
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

  function detailAjax2() {

    if (grid3.getModifiedRows().createdRows.length > 0) {

      for (var i = 0; i < grid3.getModifiedRows().createdRows.length; i++) {

        $.ajax({
          method: "POST",
          url: '${createUrl3}',
          data: JSON.stringify(grid3.getModifiedRows().createdRows[i]),
          contentType: 'application/json;charset=UTF-8'
        }).done(function (data, status, jqXHR) {
          //
        }).fail(function (data, status, jqXHR) {
          alert("저장 중 오류가 발생하였습니다.");
        });
      }

    }
    if (grid3.getModifiedRows().updatedRows.length > 0) {

      for (var i = 0; i < grid3.getModifiedRows().updatedRows.length; i++) {
        $.ajax({
          method: "POST",
          url: '${updateUrl3}',
          data: JSON.stringify(grid3.getModifiedRows().updatedRows[i]),
          contentType: 'application/json;charset=UTF-8'
        }).done(function (data, status, jqXHR) {
          //
        }).fail(function (data, status, jqXHR) {
          alert("저장 중 오류가 발생하였습니다.");
        });
      }

    }
    if (grid3.getModifiedRows().deletedRows.length > 0) {

      for (var i = 0; i < grid3.getModifiedRows().deletedRows.length; i++) {
        $.ajax({
          method: "POST",
          url: '${deleteUrl3}',
          data: JSON.stringify(grid3.getModifiedRows().deletedRows[i]),
          contentType: 'application/json;charset=UTF-8'
        }).done(function (data, status, jqXHR) {
          //
        }).fail(function (data, status, jqXHR) {
          alert("저장 중 오류가 발생하였습니다.");
        });
      }

    }
  }

  function inputView2Ajax() {

    //alert(JSON.stringify(inputView2.get('data2')));
    var manageNo = inputView2.get('data2').manageNo;
    //alert(id);

    var data2 = inputView2.get('data2');

    if (data2.sdAppoint != null) {
      if (data2.sdAppoint.officeCd !== undefined) {
        data2.sdAppoint = data2.sdAppoint.officeCd;
      }
    }
    if (data2.officeCity != null) {
      if (data2.officeCity.codeCd !== undefined) {
        data2.officeCity = data2.officeCity.codeCd;
      }
    }

    if (manageNo == '' || manageNo == null) {

      inputView2.set('data2.vinno', inputView3.get('data3.vinno'));
      inputView2.set('data2.manageNo', grid.getValue(inputView.get('rowKey'), "manageNo"));
      inputView2.set('data2.serviceDegree',
              grid.getValue(inputView.get('rowKey'), "serviceDegree"));
      inputView2.set('data2.consultingDegree', '1');

      $.ajax({
        method: "POST",
        url: '${createUrl4}',
        data: JSON.stringify(data2),
        contentType: 'application/json;charset=UTF-8'
      }).done(function (data, status, jqXHR) {
        //return false;
      }).fail(function (data, status, jqXHR) {
        alert("수정 중 오류가 발생하였습니다.");
      }).always(function () {
        //_dicasPage.maskClose();
      });
    } else {

      $.ajax({
        method: "POST",
        url: '${updateUrl4}',
        data: JSON.stringify(data2),
        contentType: 'application/json;charset=UTF-8'
      }).done(function (data, status, jqXHR) {
        //return false;
      }).fail(function (data, status, jqXHR) {
        alert("수정 중 오류가 발생하였습니다.");
      }).always(function () {
        //_dicasPage.maskClose();
      });
    }
  }

  function inputView3Ajax() {

    //alert(JSON.stringify(inputView2.get('data2')));

    $.ajax({
      method: "POST",
      url: '${updateUrl5}',
      data: JSON.stringify(inputView3.get('data3')),
      contentType: 'application/json;charset=UTF-8'
    }).done(function (data, status, jqXHR) {

      if (data.data.errCd == 'E001') {
        // alert(data.data.msg);
      }

      //return false;
    }).fail(function (data, status, jqXHR) {
      alert("수정 중 오류가 발생하였습니다.");
    }).always(function () {
      //_dicasPage.maskClose();
    });

  }

  function inputView4Ajax(temp) {

    //alert(JSON.stringify(inputView2.get('data2')));

    $.ajax({
      method: "POST",
      url: '${updateUrl6}',
      data: JSON.stringify(temp),
      contentType: 'application/json;charset=UTF-8'
    }).done(function (data, status, jqXHR) {
      alert('승인요청 완료했습니다.');
      //return false;
    }).fail(function (data, status, jqXHR) {
      alert("수정 중 오류가 발생하였습니다.");
    }).always(function () {
      //_dicasPage.maskClose();
    });

  }

  function getConsultingView() {

    var manageNo = searchView.criteria.manageNo;

    $.ajax(
            {
              type: 'GET',
              url: '${readUrl4}',
              dataType: 'json',
              data: {page: '1', manageNo: manageNo},
              success: function (result) {

                //alert(result.data.contents[0]);

                //alert(JSON.stringify(result.data.contents[0]));
                var dataItem = new codeMdl4().toJSON();

                if (result.data.contents[0] === undefined) {
                  //조사삭제 비활성화
                  delButtonView1.set("btnGrpVisible", false);
                  inputView2.set('data2', dataItem);

                  inputView2Disabled();
                } else {

                  var data = result.data.contents[0];
                  delButtonView1.set("btnGrpVisible", true);

                  if (data.auditInfo == '03') {
                    dropdownlist = $("#cmb_officeCity2_input").data("kendoDropDownList");
                    dropdownlist.readonly(false);
                    dropdownlist = $("#cmb_sdAppoint_input").data("kendoDropDownList");
                    dropdownlist.readonly(false);
                  } else {
                    data.officeCity = null;
                    data.sdAppoint = null;
                  }
                  var dropdownlist = $("#cmb_consultingNm_input").data("kendoDropDownList");
                  dropdownlist.readonly(false);
                  dropdownlist = $("#cmb_auditInfo_input").data("kendoDropDownList");
                  dropdownlist.readonly(false);

                  $("#consultingCont_input").attr("disabled", false);

                  $("#dp_consultingDate_input").attr("disabled", false);
                  $("#dp_consultingDate_input").attr("readonly", false);

                  inputView2.set('data2', data);

                }
              }
            });
  }

  function setPageUI(type) {
    if (type == "init") {
      $("input[type]", "#form_container").each(function (i, v) {
        $(v).attr("disabled", true);
      });
      $("input[type]", "#form_container3").each(function (i, v) {
        $(v).attr("disabled", true);
      });

      var dropdownlist = $("#cmb_saleCountry_input").data("kendoDropDownList");
      dropdownlist.readonly();
      dropdownlist = $("#cmb_tireStd_input").data("kendoDropDownList");
      dropdownlist.readonly();
      dropdownlist = $("#cmb_maker_input").data("kendoDropDownList");
      dropdownlist.readonly();
      dropdownlist = $("#cmb_exhaustReg_input").data("kendoDropDownList");
      dropdownlist.readonly();
      dropdownlist = $("#cmb_engineType_input").data("kendoDropDownList");
      dropdownlist.readonly();

      dropdownlist = $("#cmb_officeCity2_input").data("kendoDropDownList");
      dropdownlist.readonly();
      dropdownlist = $("#cmb_sdAppoint_input").data("kendoDropDownList");
      dropdownlist.readonly();

      $("#remark_input").attr("disabled", true);

      $("#dp_prodDate_input").attr("readonly", true);
      $("#dp_saleDate_input").attr("readonly", true);

      dropdownlist = $("#cmb_consultingNm_input").data("kendoDropDownList");
      dropdownlist.readonly();
      dropdownlist = $("#cmb_auditInfo_input").data("kendoDropDownList");
      dropdownlist.readonly();
      dropdownlist = $("#cmb_officeCity2_input").data("kendoDropDownList");
      dropdownlist.readonly();
      dropdownlist = $("#cmb_sdAppoint_input").data("kendoDropDownList");
      dropdownlist.readonly();

      $("#consultingCont_input").attr("disabled", true);

      $("#dp_consultingDate_input").attr("disabled", true);
      $("#dp_consultingDate_input").attr("readonly", true);

      //var datePicker = $("#dp_prodDate_input").data("kendoDatePicker");
      //datePicker.readonly();
      //datePicker = $("#dp_saleDate_input").data("kendoDatePicker");
      //datePicker.readonly();

    } else if (type == 'view' || type == 'add') {

      $("input[type]", "#form_container").each(function (i, v) {

        if (v.id == 'useMonth_input' ||
                v.id == 'qualityIndex_input' ||
                v.id == 'officeCode_input' ) {
          return;
        }

        $(v).attr("disabled", false);
      });
    }
  }

  function goPage(gridId, page) {
    if (gridId == "grid1") {
      grid.clear();
      //searchView.set("rowKey", null);
      searchView.criteria.manageNo = null;
      net.readData(1, searchView.criteria.toJSON(), true);
    } else if (gridId == "grid2") {
      grid2.clear();
      //searchView.set("rowKey", null);
      net2.readData(1, searchView.criteria.toJSON(), true);
    } else if (gridId == "grid3") {
      grid3.clear();
      //searchView.set("rowKey", null);
      net3.readData(1, searchView.criteria.toJSON(), true);
    }
  }

  var inputView2 = kendo.observable({
    data: {
      id: null,
      vinno: null,
      manageNo: null,
      serviceDegree: null,
      consultingDegree: null,
      consultingCont: null,
      sdAppoint: null,
      officeCity: null,
      auditInfo: null,
      consultingNm: null,
      consultingDate: null,
    },
    flag: false,
    validate: function () {
      if (validatable == null) return true;
      return validatable.validate();
    },
    hasChanges: function () {
      return this.flag;
    },
  });
  inputView2.bind('change', function (e) {

    if (e.field.indexOf('data2.') > -1) {
      inputView2.set('flag', true);
    }
  });
  kendo.bind($("#form_container2"), inputView2);

  var buttonView2 = kendo.observable({
    //btnGrp0Visible: true,
    //btnGrp1Visible: false,
    //btnGrp2Visible: false,
    add: function () {

      var dataItem = new codeMdl2().toJSON();
      grid2.appendRow(dataItem, {focus: true});

      console.log(grid.getRow(inputView.get('rowKey')));
      var rowData = grid.getRow(inputView.get('rowKey'));

      //alert(rowData.vinno);
      //alert(rowData.manageNo);
      //alert(rowData.serviceDegree);

      var grid2Rowkey = grid2.getFocusedCell().rowKey;
      grid2.setValue(grid2Rowkey, "vinno", rowData.vinno);
      grid2.setValue(grid2Rowkey, "manageNo", rowData.manageNo);
      grid2.setValue(grid2Rowkey, "serviceDegree", rowData.serviceDegree);
      //grid2.setValue(grid2Rowkey, "manageNo", grid.getValue(inputView.get('rowKey'), "manageNo", true));
      //grid2.setValue(grid2Rowkey, "serviceDegree", grid.getValue(inputView.get('rowKey'), "serviceDegree", true));
      grid2.setValue(grid2Rowkey, "phenomenonDegree", '1');

      //this.set('btnGrp1Visible', true);
      //setPageUI('add');
    },
    remove: function () {
      var grid2Rowkey = grid2.getFocusedCell().rowKey;
      grid2.removeRow(grid2Rowkey);
      //buttonView.set('btnGrp1Visible', true);
    },
  });
  kendo.bind($("#gridDiv2"), buttonView2);

  var buttonView3 = kendo.observable({
    //btnGrp0Visible: true,
    //btnGrp1Visible: false,
    //btnGrp2Visible: false,
    add: function () {

      var dataItem = new codeMdl3().toJSON();
      grid3.appendRow(dataItem, {focus: true});

      var rowData = grid.getRow(inputView.get('rowKey'));

      var grid3Rowkey = grid3.getFocusedCell().rowKey;
      grid3.setValue(grid3Rowkey, "vinno", rowData.vinno);
      grid3.setValue(grid3Rowkey, "manageNo", rowData.manageNo);
      grid3.setValue(grid3Rowkey, "serviceDegree", rowData.serviceDegree);
      //this.set('btnGrp1Visible', true);
      //setPageUI('add');
    },
    remove: function () {
      var grid3Rowkey = grid3.getFocusedCell().rowKey;
      grid3.removeRow(grid3Rowkey);
      //buttonView.set('btnGrp1Visible', true);
    },
  });
  kendo.bind($("#gridDiv3"), buttonView3);

  var delButtonView1 = kendo.observable({
    btnGrpVisible: false,
    add: function() {

      if ($('#dp_consultingDate_input').val() != '') {
        return;
      }

      inputView2Enabled();

      //dp_consultingDate_input
      var today = new Date();
      var dd = today.getDate();
      var mm = today.getMonth()+1; //January is 0!
      var yyyy = today.getFullYear();

      if(dd<10) {
        dd='0'+dd
      }

      if(mm<10) {
        mm='0'+mm
      }

      today = yyyy+'-'+mm+'-'+dd;

      //alert('${loginVO.getUsername()}');
      inputView2.set('data2.consultingDate', today);
      inputView2.set('data2.consultingNm', '${loginVO.getUsername()}');

      var dropdownlist = $("#cmb_auditInfo_input").data("kendoDropDownList");
      dropdownlist.focus();

    },
    remove: function() {
      //상담삭제
      if(confirm("상담 내용을 삭제 하시겠습니까?")) {

        _dicasPage.maskOpen();

        var data2 = inputView2.get('data2');

        if (data2.sdAppoint != null) {
          data2.sdAppoint = data2.sdAppoint.officeCd;
        }
        if (data2.officeCity != null) {
          data2.officeCity = data2.officeCity.codeCd;
        }

        $.ajax({
          method: "POST",
          url: '${deleteUrl4}',
          data: JSON.stringify(inputView2.get('data2')),
          contentType: 'application/json;charset=UTF-8'
        }).done(function (data, status, jqXHR) {
          //searchView.search();
          var dataItem = new codeMdl4().toJSON();
          inputView2.set('data2', dataItem);
          //조사삭제 비활성화
          delButtonView1.set("btnGrpVisible", false);

          inputView2Disabled();

        }).fail(function (data, status, jqXHR) {
          alert("삭제 중 오류가 발생하였습니다.");
        }).always(function () {
          _dicasPage.maskClose();
        });
      }
    },
  });
  kendo.bind($("#divDelBtn1"), delButtonView1);

  getEditOptions2 = function (data, type) {

    var editoptions = [];

    item = {
      text: '선택해주세요.',
      value: ''
    }
    editoptions.push(item);

    for (var i = 0; i < data.length; i++) {

      var item;

      if (type == 'mainCategory') {
        item = {
          text: data[i].mainCategoryNm,
          value: data[i].mainCategory
        }
      } else if (type == 'subCategory') {
        item = {
          text: data[i].smallCategoryNm,
          value: data[i].smallCategory,
          value2: data[i].mainCategory
        }
      } else if (type = "dtc") {
        item = {
          text: data[i].dtcCode,
          value: data[i].dtcCode,
          value2: data[i].dtcKrNm
        }
      }

      editoptions.push(item);
    }
    return editoptions;
  };

  getEditOptions3 = function (data) {

    var editoptions = [];
    for (var i = 0; i < data.length; i++) {

      var item = {
        text: data[i].codeKoNm,
        value: data[i].codeCd
      }

      editoptions.push(item);
    }
    return editoptions;
  };

  var inputView3 = kendo.observable({
    rowIndex: 0,
    rowKey: null,
    data: null,
    flag: false,
    validate: function () {
      if (validatable3 == null) return true;
      return validatable3.validate();
    },
    popup2: function () {
      var that = this;
      _dicasPage.popupOpen({
        url: "${popupUrl2}",
        code: 'codeHelp',
        width: 1000,
        height: 700,
        params: {
          tireStd: inputView3.get('data3.tireStd'),
          maker: inputView3.get('data3.maker'),
          exhaustReg: inputView3.get('data3.exhaustReg'),
          engineType: inputView3.get('data3.engineType'),
          model: $('#model_search').val()
        },
        beforeOpen: function () {
          _dicasPage.beforeCodeHelpVal = true;
        },
        afterClose: function (info) {
          if (info.result) {
            var _data = JSON.parse(info.data);
            that.set('data3.tireStd', _data.tireStd);
            that.set('data3.maker', _data.maker);
            that.set('data3.model', _data.model);
            that.set('data3.exhaustReg', _data.exhaustReg);
            that.set('data3.engineType', _data.engineType);
          } else {
            //that.set('data3.model', null);
          }
        }
      });
    },
    hasChanges: function () {
      return this.flag;
    },
  });
  inputView3.bind('change', function (e) {

    if (e.field.indexOf('data3.') > -1) {
      inputView3.set('flag', true);
    }
  });
  kendo.bind($("#form_container3"), inputView3);

  function auditOnchange() {

    if ($("#cmb_auditInfo_input").val() == '03') {
      dropdownlist = $("#cmb_officeCity2_input").data("kendoDropDownList");
      dropdownlist.readonly(false);
      //dropdownlist = $("#cmb_sdAppoint_input").data("kendoDropDownList");
      //dropdownlist.readonly(false);
    } else {
      dropdownlist = $("#cmb_officeCity2_input").data("kendoDropDownList");
      dropdownlist.text("");
      dropdownlist.readonly();
      //$("#cmb_officeCity2_input").val(null);
      dropdownlist = $("#cmb_sdAppoint_input").data("kendoDropDownList");
      dropdownlist.text("");
      //dropdownlist.readonly();
      //$("#cmb_sdAppoint_input").val(null);
    }
  }

  var dtcData, dtcItems;

  $(document).ready(function () {

    cmbOfficeCityInput = $("#cmb_officeCity_input", "#frm_input").data("kendoDropDownList");

    cmbPartDivInput = $("#cmb_partDiv_input", "#frm_input").data("kendoDropDownList");

    var conditionData = new kendo.data.DataSource({data: ${conditionItems}}),
            conditionItems = getEditOptions3(conditionData.options.data);

    var mainCategoryData = new kendo.data.DataSource({data: ${mainCategoryItems}}),
            mainCategoryItems = getEditOptions2(mainCategoryData.options.data, "mainCategory");

    var subCategoryData = new kendo.data.DataSource({data: ${subCategoryItems}}),
            subCategoryItems = getEditOptions2(subCategoryData.options.data, "subCategory");

    dtcData = new kendo.data.DataSource({data: ${dtcItems}}),
            dtcItems = getEditOptions2(dtcData.options.data, "dtc");

    validatable = $("#form_container").kendoValidator({validateOnBlur: false})
            .data("kendoValidator");

    validatable3 = $("#form_container3").kendoValidator({validateOnBlur: false})
            .data("kendoValidator");

    $("#model_search").keypress(function(e){
      if(e.keyCode === 13){
        inputView3.popup2();
      }
    });

    $("#officeNane_input").keypress(function(e){
      if(e.keyCode === 13){
        inputView.popup3();
      }
    });

    $("#inquiry_input").keypress(function(e){
      if(e.keyCode === 13){
        inputView.popup5();
      }
    });

    $(".calendar").datepicker();
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
      changeYear: true,
      dateFormat: "yy-mm-dd",
      yearSuffix: '년'
    });

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
      bodyHeight: 150,
      pagination: true,
      selectionUnit: 'row',
      editingEvent: false,
      usageStatistics: false,
      columns: [

        {title: 'id', name: 'id', align: 'center', hidden: true}
        , {title: '마스터id', name: 'masterId', align: 'center', hidden: true}
        , {title: 'CLMNo', name: 'manageNo', align: 'center'}
        , {title: 'SNO', name: 'serviceDegree', align: 'center', hidden: true}
        , {
          title: '상태',
          name: 'condition',
          align: 'center',
          editOptions: {type: 'select', listItems: conditionItems, useViewMode: false}
        }
        , {title: '메이커', name: 'maker', align: 'center', hidden: true}
        , {title: 'VINNo', name: 'vinno', align: 'center', hidden: true}
        , {title: '차량번호', name: 'carNo', align: 'center', hidden: true}
        , {title: '배기규제형식', name: 'exhaustReg', align: 'center', hidden: true}
        , {title: '엔진형식', name: 'engineType', align: 'center', hidden: true}
        , {title: '차종', name: 'model', align: 'center', hidden: true}
        , {title: '상담예정', name: 'consultingExp', align: 'center', hidden: true}
        , {title: '구분', name: 'div', align: 'center', hidden: true}
        , {title: '관리NOid', name: 'manageNoId', align: 'center', hidden: true}
        , {title: '승인번호id', name: 'approvalNoId', align: 'center', hidden: true}
        , {title: '승인번호', name: 'approvalNo', align: 'center', hidden: true}
        , {title: '접수일', name: 'receiptDate', align: 'center'}
        , {title: '접수자', name: 'receiptNm', align: 'center', hidden: true}
        , {title: '접수자', name: 'receiptNm2', align: 'center'}
        , {title: '문의품', name: 'inquiry', align: 'center', hidden: true}
        , {title: '발생국', name: 'country', align: 'center', hidden: true}
        , {title: '주행거리', name: 'mileage', align: 'center', hidden: true}
        , {title: '단위', name: 'unit', align: 'center', hidden: true}
        , {title: '발생일', name: 'occurDate', align: 'center', hidden: true}
        , {title: '재발일', name: 'relapseDate', align: 'center', hidden: true}
        , {title: '재현성', name: 'reappearance', align: 'center', hidden: true}
        , {title: '정비소code', name: 'officeCode', align: 'center', hidden: true}
        , {title: '소재지', name: 'officeCity', align: 'center', hidden: true}
        , {title: '정비소명', name: 'officeNm', align: 'center', hidden: true}
        , {title: '대표번호', name: 'officeTel', align: 'center', hidden: true}
        , {title: '팩스', name: 'officeFax', align: 'center', hidden: true}
        , {title: '주소', name: 'officeAddr', align: 'center', hidden: true}
        , {title: '주재원', name: 'expatNm', align: 'center', hidden: true}
        , {title: '주재원전화', name: 'expatTel', align: 'center', hidden: true}
        , {title: '정비사1', name: 'mechanic1Nm', align: 'center', hidden: true}
        , {title: '정비사1전화', name: 'mechanic1Tel', align: 'center', hidden: true}
        , {title: '정비사2', name: 'mechanic2Nm', align: 'center', hidden: true}
        , {title: '정비사2전화', name: 'mechanic2Tel', align: 'center', hidden: true}
        , {title: '입고일', name: 'wearingDate', align: 'center', hidden: true}
        , {title: 'CS1000', name: 'cs1000', align: 'center', hidden: true}
        , {title: '보증대상', name: 'warranty', align: 'center', hidden: true}
        , {title: '정비소수정', name: 'officeFix', align: 'center', hidden: true}
        , {title: 'RS1000', name: 'rs1000', align: 'center', hidden: true}
        , {title: '문의품구분', name: 'inquiryGubun', align: 'center', hidden: true}
        , {title: '생산거점', name: 'prodBase', align: 'center', hidden: true}
        , {title: 'useMonth', name: 'useMonth', align: 'center', hidden: true}
        , {title: 'qualityIndex', name: 'qualityIndex', align: 'center', hidden: true}

      ]
    });

    grid.use('Net', {
      el: $('#frm_input'),
      initialRequest: false,
      readDataMethod: 'GET',
      perPage: 25,
      enableAjaxHistory: false,
      timeout: 10000,
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

        //alert(data.responseData.data);
        //alert(data.responseData.data.contents);

        if (data.responseData.data.contents != '') {

          var _count = data.responseData.data.contents.length;
          if (_count > 0) {
            var checkInterval = setInterval(function() {
              if (grid3.getRowCount() > 0) {
                clearInterval(checkInterval);
                grid.focusAt(0, 0);
              }
            }, 100);
          } else {
          }

          inputView.set('data', null);
          inputView.set('rowKey', null);
          inputView.set('rowIndex', 0);

          //alert(data);
          //console.log(data.responseData.data);
          console.log(data.responseData.data.contents[0]);
          //alert(JSON.stringify(data));
          //alert(JSON.stringify(data.contents[0]));

          searchView.criteria.manageNo = data.responseData.data.contents[0].manageNo;

          //alert(searchView.criteria.manageNo);

          goPage('grid2', 1);
          goPage('grid3', 1);

          getConsultingView();
          //consultingReturn.read();
        }

      } else {
      }

    }).on('failResponse', function (data) {
    }).on('errorResponse', function (data) {
    }).on('focusChange', function (eventData) {

      if (inputView.hasChanges()) {
        //    var rowIndex = this.getIndexOfRow(eventData.prevRowKey);
        //    var columnIndex = this.getIndexOfColumn(eventData.prevColumnName);
        //    inputView.set("rowIndex", rowIndex);
        //    this.focusAt(rowIndex, columnIndex);
        eventData.stop();
      } else {

        if (eventData.prevRowKey != eventData.rowKey) {

          var rowIndex = this.getIndexOfRow(eventData.rowKey);
          inputView.set("rowIndex", rowIndex);
          inputView.set("rowKey", eventData.rowKey);
          inputView.set('data', this.getRow(eventData.rowKey));
          //buttonView.set('btnGrp2Visible', true);
          setPageUI('view');

          searchView.criteria.manageNo = this.getRow(eventData.rowKey).manageNo;
          //alert(searchView.criteria.manageNo);
          goPage('grid2', 1);
          goPage('grid3', 1);

          getConsultingView();
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
      if (grid.getRowCount() > 0)
        grid.focusAt(0, 0);
    });

    setPageUI("init");

    grid2 = new tui.Grid({
      el: $('#grid2'),
      scrollX: false,
      scrollY: true,
      rowHeight: 30,
      // keyColumnName: 'codeKey',
      useClientSort: false,
      showDummyRows: true,
      minBodyHeight: 30,
      bodyHeight: 150,
      pagination: true,
      selectionUnit: 'CELL',
      editingEvent: true,
      usageStatistics: false,
      treeColumnOptions: {
        name: 'ID',
        useCascadingCheckbox: false
      },
      columns: [

        {title: 'id', name: 'id', align: 'center', hidden: 'true'}
        , {title: 'VINNO', name: 'vinno', align: 'center', hidden: 'true'}
        , {title: '관리NO', name: 'manageNo', align: 'center', hidden: 'true'}
        , {title: '대표', name: 'cateChkYn', align: 'center',
          editOptions: {
            type: 'checkbox',
            listItems: [
              { text: '', value: 'Y' }
            ],
            useViewMode: false
          }
          ,onAfterChange: function(ev) {

            if (ev.value == 'Y') {
              var cnt = grid2.getRowCount();
              for (var i=0; i<cnt; i++) {
                var gridData = grid2.getRowAt(i);
                if (gridData.rowKey != ev.rowKey) {
                  grid2.setValue(gridData.rowKey, 'cateChkYn', null);
                }
              }
            }
          }
        }
        , {title: 'SNO', name: 'serviceDegree', align: 'center', hidden: true}
        , {title: '차수', name: 'phenomenonDegree', align: 'center', hidden: true}
        //,{ title: '대분류', name: 'mainCategory', align: 'center', editOptions: { type: 'text', maxLength: 100, useViewMode: false } }
        , {
          title: '대분류',
          name: 'mainCategory',
          align: 'center',
          editOptions: {type: 'select', listItems: mainCategoryItems, useViewMode: false},
          relations: [
            {
              targetNames: ['smallCategory', 'selectedValue'],
              listItems: function(value) {

                var editoptions = [];
                for (var i = 0; i < subCategoryItems.length; i++) {

                  if (subCategoryItems[i].value2 == value) {
                    editoptions.push(subCategoryItems[i]);
                  }
                }
                return editoptions;
              },
              disabled: function(value) {
                return !(value);
              }
            }
          ]
        }
        , {
          title: '소분류',
          name: 'smallCategory',
          align: 'center',
          editOptions: {type: 'select', listItems: subCategoryItems, useViewMode: false}
        }
        , {title: 'Gubun', name: 'div', align: 'center', hidden: 'true'}
        , {title: 'MASTER_STATE', name: 'masterState', align: 'center', hidden: 'true'}
        , {title: '중메뉴전송', name: 'cateSubTranYn', align: 'center', hidden: 'true'}

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
    }).on('response', function (data) {
    // }).on('click', function (eventData) {
    //
    //   console.log(eventData);
    //   if (eventData.columnName == 'cateChkYn') {
    //     grid2.setValue(eventData.rowKey, 'cateChkYn', 'Y');
    //   }

    }).on('dblclick', function (eventData) {

      console.log(eventData);
      if (eventData.columnName == 'cateChkYn') {
        grid2.setValue(eventData.rowKey, 'cateChkYn', 'Y');
      }

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

    //setPageUI2("init");

    grid3 = new tui.Grid({
      el: $('#grid3'),
      scrollX: false,
      scrollY: true,
      rowHeight: 30,
      // keyColumnName: 'codeKey',
      useClientSort: false,
      showDummyRows: true,
      minBodyHeight: 30,
      bodyHeight: 150,
      pagination: true,
      selectionUnit: 'CELL',
      editingEvent: true,
      usageStatistics: false,
      treeColumnOptions: {
        name: 'ID',
        useCascadingCheckbox: false
      },
      columns: [

        {title: 'id', name: 'id', align: 'center', hidden: 'true'}
        , {title: 'VINNo', name: 'vinno', align: 'center', hidden: 'true'}
        , {title: '관리NO', name: 'manageNo', align: 'center', hidden: 'true'}
        , {title: '서비스차수', name: 'serviceDegree', align: 'center', hidden: 'true'}
        , {title: '현상코드구분', name: 'phenomenonCdDiv', align: 'center', hidden: 'true'}
        , {
          title: 'DTC',
          name: 'code',
          align: 'center',
          editOptions: {type: 'select', listItems: dtcItems, useViewMode: false},
          onAfterChange: function(ev) {

            if (ev.value == '') {
              grid3.setValue(ev.rowKey, "explan", '');
              return;
            }

            for (var i=0; i<dtcItems.length; i++) {
              var data = dtcItems[i];
              if (ev.value == data.text) {
                //alert(data.value2);
                grid3.setValue(ev.rowKey, "explan", data.value2);
                break;
              }
            }
          }
        }
        , {
          title: 'DTC NAME',
          name: 'explan',
          align: 'center',
          editOptions: {type: 'text', maxLength: 100, useViewMode: false}
        }
        ,{ title: '', name: 'img', align: 'center', width: 10,
          formatter: function(value) {
            var url = "<c:url value='../../../assets/img/grid_popup_img.png' />";
            return '<img src="' + url + '" />';
          }
        }

      ]
    });

    grid3.use('Net', {
      el: $('#frm_input'),
      initialRequest: false,
      readDataMethod: 'GET',
      perPage: 25,
      enableAjaxHistory: false,
      api: {
        'readData': '${readUrl3}',
        // 'downloadExcel': './api/download/excel',
        // 'downloadExcelAll': './api/download/excelAll'
      }
    });

    // Bind event handlers
    grid3.on('beforeRequest', function (data) {
      // For all requests
      //_dicasPage.maskOpen();
    }).on('response', function (data) {
      // For all response (regardless of success or failure)
      //_dicasPage.maskClose();
    }).on('successResponse', function (data) {
    }).on('failResponse', function (data) {
    }).on('errorResponse', function (data) {
    }).on('focusChange', function (eventData) {
    }).on('dblclick', function (eventData) {
      if(eventData.columnName == 'img') {
        inputView.popup6();
      }
    });

    net3 = grid3.getAddOn('Net');
    pagination3 = grid3.getPagination();
    pagination3.on('afterMove', function (eventData) {
      if (grid3.getRowCount() > 0)
        grid3.focusAt(0, 0);
    });

    //setPageUI("init");

    if (_dicasPage.requestParams != null) {

      //_dicasPage.maskOpen();

      //alert(_dicasPage.requestParams);
      //alert(_dicasPage.requestParams.vinno);
      //alert(_dicasPage.requestParams.manageNo);

      var vinno = _dicasPage.requestParams.vinno;
      searchView.set('criteria.vinno', vinno);
      searchView.set('criteria.manageNo', _dicasPage.requestParams.manageNo);

      searchView.search();
      //차량검색
      $.ajax(
              {
                type: 'GET',
                url: '${readUrl6}',
                dataType: 'json',
                data: {page: '1', vinno: vinno},
                success: function (result) {
                  //alert(result.data);
                  inputView3.set('data3', result.data);
                  inputView3Enabled();

                  var temp = $("#dp_prodDate_input").val();
                  $("#dp_prodDate_input").val(changeFormat(temp));

                  temp = $("#dp_saleDate_input").val();
                  $("#dp_saleDate_input").val(changeFormat(temp));
                }
              });

      //var seq = _dicasPage.requestParams.seq;
      //alert(seq);

    }

  });

</script>
