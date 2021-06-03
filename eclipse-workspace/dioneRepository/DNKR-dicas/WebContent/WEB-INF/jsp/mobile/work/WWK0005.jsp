<%-- [EN] Variable definition --%>
<%-- [JP] 変数定義 --%>
<link rel="stylesheet" href="https://kendo.cdn.telerik.com/2019.2.514/styles/kendo.common.min.css"/>
<link rel="stylesheet" href="https://kendo.cdn.telerik.com/2019.2.514/styles/kendo.rtl.min.css"/>
<link rel="stylesheet" href="https://kendo.cdn.telerik.com/2019.2.514/styles/kendo.silver.min.css"/>
<link rel="stylesheet" href="https://kendo.cdn.telerik.com/2019.2.514/styles/kendo.mobile.all.min.css"/>
<c:url var="initUrl" value="/mobile/serviceSD/init" />
<c:url var="initServiceUrl" value="/mobile/serviceSD/init/${serviceId}/service"/>
<c:url var="initDtcUrl" value="/mobile/serviceSD/init/${serviceId}/dtc"/>
<c:url var="initConsultUrl" value="/mobile/serviceSD/init/${serviceId}/consult"/>

<c:url var="initResearchUrl" value="/mobile/serviceSD/init/${serviceId}/research"/>
<c:url var="initResultUrl" value="/mobile/serviceSD/init/${serviceId}/result"/>
<c:url var="initCostUrl" value="/mobile/serviceSD/init/${serviceId}/cost"/>

<!-- 조사자 검색 -->
<c:url var="readUrl3" value="/user/search2"/>

<!-- 조사 업데이트 -->
<c:url var="updateUrl" value="/research/update"/>
<c:url var="createUrl" value="/research/mobileData"/>

<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] 画面ID (@ViewIdで定義) --%>
<c:set var="screenId" value="<%= request.getAttribute(Globals.SCREEN_ID_KEY) %>"/>

<!--◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ #head ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆-->
<div id="head" class="init">
  <!-- container -->
  <div id="headerView" class="container">
    <h1>클레임 조사</h1>
    <button type="button" class="back" data-bind="click: back"><span class="blind">이전</span></button>
    <a href="#pop_option" class="b1 layer_open more"><span class="blind">옵션</span></a> 
    <!-- pop_option -->
    <div id="pop_option">
      <div class="wrap">
        <ul>
          <li><a href="${initServiceUrl}">서비스접수</a></li>
          <li><a href="${initDtcUrl}">현상/DTC</a></li>
          <li><a href="${initConsultUrl}">상담</a></li>
        </ul>
      </div>
    </div>  
    <!-- / pop_option -->        
  </div>
  <!-- /container -->            

</div>
<!--◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ /#head ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆-->    

<hr class="dpn" />

<!--◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ #cnb1 ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆-->
<div id="cnb1" class="init">
  <ul>
    <li class="on"><a href="javascript:;"><i class="ic4"></i><span class="t1">조사</span></a></li>
    <li><a href="${initResultUrl}"><i class="ic5"></i><span class="t1">결과</span></a></li>
    <li><a href="${initCostUrl}"><i class="ic6"></i><span class="t1">비용</span></a></li>
  </ul>
</div>
<!--◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ /#cnb1 ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆-->    

<hr class="dpn" />

<!--◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ #body_content ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆-->  
<div id="body_content" class="body_cnb1 init"> <!-- cnb1 가 있는 경우 body_cnb1을 넣어준다-->
  <td><input type="hidden" class="w100" data-bind="value: data.id"> </td>
  <!-- container -->
    <div class="container">    
      <!-- 상세보기 -->
      <table id="view_container" class="bWrite">
        <col style="width:90px" />
        <col />
        <tr>
          <th scope="row">조사일</th>
          <td><input type="text" class="calendar" data-bind="value: data.researchDate" /></td>
        </tr>
        <tr>
          <th scope="row">조사자</th>
          <td>
            <kendo:dropDownList name="cmb_researchNmS_input" dataTextField="fulnm"
                                dataValueField="acctId"
                                data-value-primitive="true"
                                autoBind="false"
                                data-bind="value: data.researchNmS">
              <%--<kendo:dataSource data="${officeCityItems}"/>--%>
              <kendo:dataSource>
                <kendo:dataSource-transport>
                  <kendo:dataSource-transport-read url="${readUrl3}" type="POST" contentType="application/json"/>
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
          <%--<td>--%>
            <%--<input type="text" class="w100" data-bind="value: data.requestUser" />--%>
          <%--</td>--%>
        </tr>
      </table>      
      <!-- /상세보기 -->
      
      <table id="view_container2" class="bWrite">
        <tr>
          <th scope="col">조사내용</th>
        </tr>
        <tr>
          <td>
            <textarea rows="5" cols="80" class="w100" data-bind="value: data.researchCont"></textarea>
          </td>
        </tr>
      </table>
       
      <!-- btns -->
      <div id="btns_container" class="btns tac">
        <button type="button" class="button submit" data-bind="click: save">저장하기</button>
        <button type="button "class="button" data-bind="click: search">취소하기</button>
      </div>                            
      <!-- /btns -->        
    </div>
    <!-- /container -->
</div>
<!--◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ /#body_content ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆-->

<script type="text/javascript">

    var _dicasPage = new DicasPage('${screenId}');

    <%-- Control Definition --%>
    var editor;
    <%--// Control Definition --%>

    <%-- Variable Definition --%>
    var validatable = null;
    <%--// Variable Definition --%>

    var boardMdl = kendo.data.Model.define({
        id: "id",
        fields: {
            id: { type: "string" },
            vinno: { type: "string" },
            manageNo: { type: "string" },
            serviceDegree: { type: "string" },
            researchDegree: { type: "string" },
            researchDate: { type: "string" },
            researchNm: { type: "string" },
            researchNmS: { type: "string" },
            researchType: { type: "string" },
            cdsdResearchYn: { type: "string" },
            cdsdCd: { type: "string" },
            officeCity: { type: "string" },
            officeNm: { type: "string" },
            officeCd: { type: "string" },
            researchCont: { type: "string" },
            researchResult: { type: "string" },
            autoinsert: { type: "string" },
            investUid: { type: "string" },
            investDate: { type: "string" },
            updtrId: { type: "string" },
            updtDt: { type: "string" },
            requestUser: { type: "string" }
        }
    });

    var inputView = kendo.observable({
      data: null,
      save: function() {
        if (!inputView.validate()) {
          _dicasPage.alert({
            title: '저장확인',
            message: '필수 항목을 입력해 주십시오.'
          });
          return;
        }
        if (inputView.hasChanges()) {
          _dicasPage.confirm({
            title: '저장확인',
            message: '변경사항을 저장하시겠습니까?',
            confirm: function() {
              inputViewAjax();
            },
            cancel: function() {
            }
          });
        }
      },
      search: function() {
        if (inputView.hasChanges()) {
          _dicasPage.confirm({
            title: '취소확인',
            message: '변경사항을 취소하시겠습니까?',
            confirm: function() {
              location.reload();
            },
            cancel: function() {
            }
          });
        }
      },
      validate: function () {
        if (validatable == null) return true;
        return validatable.validate();
      },
      hasChanges: function () {
        return true;
      }

    });
    kendo.bind($("#body_content"), inputView);

    $(document).ready(function() {

      validatable = $("#body_content").kendoValidator({validateOnBlur: false})
              .data("kendoValidator");
      var data = new boardMdl({
          id: "${researchForm.id}",
          vinno: "${researchForm.vinno}",
          manageNo: "${researchForm.manageNo}",
          serviceDegree: "${researchForm.serviceDegree}",
          researchDegree: "${researchForm.researchDegree}",
          researchDate: "${researchForm.researchDate}",
          researchNm: "${researchForm.researchNm}",
          researchNmS: "${researchForm.researchNmS}",
          researchType: "${researchForm.researchType}",
          cdsdResearchYn: "${researchForm.cdsdResearchYn}",
          cdsdCd: "${researchForm.cdsdCd}",
          officeCity: "${researchForm.officeCity}",
          officeNm: "${researchForm.officeNm}",
          officeCd: "${researchForm.officeCd}",
          researchCont:  "${researchForm.researchCont}",
          researchResult: "${researchForm.researchResult}",
          autoinsert: "${researchForm.autoinsert}",
          investUid: "${researchForm.investUid}",
          investDate: "${researchForm.investDate}",
          updtrId: "${researchForm.updtrId}",
          updtDt: "${researchForm.updtDt}",
          requestUser: "${researchForm.requestUser}"
      });
      inputView.set('data', data);
    });

    var headerView = kendo.observable({
        inputValue: "Input value",
        textareaValue: "Textarea value",
        back: function() {
            _dicasPage.confirm({
                title: '페이지이동',
                message: '클레임접수로 이동 하시겠습니까?',
                confirm: function() {
                    document.location.href="${initUrl}"
                },
                cancel: function() {
                }
            });
        },
        optionMenu: function(e) {
            e.preventDefault();
            var href = $(e.target).attr('href');
            var page = $(e.target).attr('data-page');
            var title = $(e.target).html();

            _dicasPage.confirm({
                title: '페이지이동',
                message: '[' + title + ']로 이동 하시겠습니까?',
                confirm: function() {
                    document.location.href=href;
                },
                cancel: function() {
                }
            });
        }
    });
    kendo.bind($("#headerView"), headerView);

    function inputViewAjax() {

      $.ajax({
        method: "POST",
        url: '${createUrl}',
        data: JSON.stringify(inputView.get('data')),
        contentType: 'application/json;charset=UTF-8'
      }).done(function (data, status, jqXHR) {
        _dicasPage.alert({
          title: '알림',
          message: "변경 사항이 저장되었습니다."
        });
      }).fail(function (data, status, jqXHR) {
        _dicasPage.alert({
          title: '알림',
          message: "수정 중 오류가 발생하였습니다."
        });
      }).always(function () {
        _dicasPage.maskClose();
      });

    }

</script>