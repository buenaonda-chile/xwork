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

<c:url var="itemDelete" value="/mobile/serviceSD/init/${serviceId}/itemDelete"/>
<c:url var="itemAdd" value="/mobile/serviceSD/init/${serviceId}/itemAdd"/>
<%-- 클레임조사 결과업데이트  --%>
<c:url var="updateUrl2" value="/resultMaster/updateManageNo"/>
<%-- 교환품번 업데이트  --%>
<c:url var="updateUrl3" value="/resultMaster/gridUpdate"/>
<%-- 부품검색 팝업 --%>
<c:url var="popupUrl" value="/mobile/serviceSD/init/partNumberPop"/>
<c:url var="dataUrl" value="/mobile/serviceSD/init/${serviceId}/search"/>

<%-- File Upload Url --%>
<c:url var="chunkUrl" value="/api/file/chunk"/>
<c:url var="downloadUrl" value="/api/file/download" />
<c:url var="deleteFileUrl" value="/api/file/delete"/>

<c:url var="checkSdUrl" value="/mobile/serviceSD/init/${serviceId}/checkSD"/>
<c:url var="sdCostApproval" value="/mobile/serviceSD/init/${serviceId}/sdCostApproval"/>

<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] 画面ID (@ViewIdで定義) --%>
<c:set var="screenId" value="<%= request.getAttribute(Globals.SCREEN_ID_KEY) %>"/>

<!--◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ #head ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆-->
<div id="head" class="init">
  <div id="itemDiv" style="">
    <form id="itemForm" name="itemForm" method="post">

    </form>
  </div>
  <!-- container -->
  <div id="headerView" class="container">
    <h1>클레임 결과</h1>
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
    <li><a href="${initResearchUrl}"><i class="ic4"></i><span class="t1">조사</span></a></li>
    <li class="on"><a href="javascript:;"><i class="ic5"></i><span class="t1">결과</span></a></li>
    <li><a href="${initCostUrl}"><i class="ic6"></i><span class="t1">비용</span></a></li>
  </ul>
</div>
<!--◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ /#cnb1 ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆-->    

<hr class="dpn" />

<!--◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ #body_content ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆-->
<div id="body_content" class="body_cnb1 init"> <!-- cnb1 가 있는 경우 body_cnb1을 넣어준다-->
  <!-- container -->
  <div class="container">
    <!-- 등록 -->
    <table id="view_container" class="bWrite">
      <col style="width:90px" />
      <col />
      <tr>
        <th>고품송부일</th>
        <td><input type="tel" class="calendar" data-bind="value: data.receiveDate" /></td>
      </tr>
      <tr>
        <th>수리일</th>
        <td><input type="tel" class="calendar" data-bind="value: data.repairDate" /></td>
      </tr>
      <tr>
        <th>엔진No</th>
        <td><input type="text" class="w100" data-bind="value: data.enginNo" /></td>
      </tr>
      <tr>
        <th>자재선택</th>
        <td>
          <kendo:dropDownList id="cmb_matDiv_input" name="cmb_matDiv_input" dataTextField="codeNm"
                              dataValueField="codeCd"
                              data-value-primitive="true"
                              data-bind="value: data.matDiv">
            <kendo:dataSource data="${matDivItems}"/>
          </kendo:dropDownList>
        </td>
      </tr>
      <tr>
        <th>결과구분</th>
        <td>
          <kendo:dropDownList id="cmb_approval_input" name="cmb_approval_input" dataTextField="codeNm"
                              dataValueField="codeCd"
                              data-value-primitive="true"
                              data-bind="value: data.actionType">
            <kendo:dataSource data="${approvalItems}"/>
          </kendo:dropDownList>
        </td>
      </tr>
      <tr>
        <th>출동비용</th>
        <td><div class="search_input">
          <input type="text" disabled="disabled" data-bind="value: data.totalAmt" />
          <button id="costSearch"><i class="ic_search1"></i><span class="blind">검색</span></button>
        </div></td>
      </tr>
    </table>
    <div class="h2btns">
      <h2>교환품번</h2>
      <div class="btns_small">
        <button type="button" id="btn_add" class="button" ><i class="plus"></i></button>
        <%--<button type="button" id="btn_remove" class="button" data-bind="click: remove"><i class="minus"></i></button>--%>
      </div>
    </div>

    <table id="view_container2" class="bWrite">
      <input type="hidden" id="IU"  name="IU" data-vind="value:IU" value="" />
      <input type="hidden" id="D"   name="D"  data-vind="value:D" value="" />
      <col style="width:90px" />
      <col />
      <%--<tr>--%>
        <%--<th>대표</th>--%>
        <%--<td><input type="checkbox" value="" /></td>--%>
      <%--</tr>--%>

      <tr>
        <th>고객품번</th>
        <td><div id="text_hmncPartNo" class="search_input">
          <input id="hmcPartNo_v" type="text" class="w100" data-bind="value: data.hmcPartNo"/>
          <button type="button" data-bind= "click: popup"><i class="ic_search1"></i><span class="blind">검색</span></button>

        </div></td>
      </tr>



      <tr>
        <th>교환품명</th>
        <td><input id="replacePartNm_v" type="text" class="w100" data-bind="value: data.replacePartNm"/></td>
      </tr>
      <tr>
        <th>수량</th>
        <td>
          <input id="replacePartCnt_v" type="number" class="w100" data-bind="value: data.replacePartCnt"/>
          <input type="hidden" class="w100" data-bind="value: data.id"/>
          <input id="replacePartNo_v" type="hidden" class="w100" data-bind="value: data.replacePartNo"/>
        </td>
      </tr>

    </table>
   <div>
     <table id="data_container" class="bWrite">
       <col style="width:25%; text-align: center" />
       <col style="width:35%; text-align: center" />
       <col style="width:25%; text-align: center" />
       <col style="width:15%; text-align: center" />
       <thead>
       <tr>
         <th>고객품번</th>
         <th>교환품명</th>
         <th>수량</th>
         <th></th>
       </tr>
       </thead>
       <tbody id="partTbl">

       <c:forEach var="itemList" items="${itemList}" varStatus="status">
        <tr id="tr_${itemList.hmcPartNo}" data-value="${itemList.hmcPartNo}" data-id="${itemList.id}" >
          <td><c:out value="${itemList.hmcPartNo}" /></td>
          <td><c:out value="${itemList.replacePartNm}" /></td>
          <td><c:out value="${itemList.replacePartCnt}" /></td>
          <td><button class="button" onclick='javascript:delTr("${itemList.hmcPartNo}", "${itemList.id}")'>제거</button></td>
        </tr>
       </c:forEach>
       </tbody>
     </table>
   </div>



    <table id="view_container3" class="bWrite">
      <col style="width:90px" />
      <col />
      <th>첨부파일</th>
      <td>
        <div class="search1">
          <kendo:upload name="files" showFileList="true" dropZone=".search1"
                        complete="onComplete" error="onError" upload="onUpload" select="onSelect" success="onSuccess">
            <kendo:upload-async autoUpload="true" saveUrl="${chunkUrl}" removeUrl="${deleteFileUrl}"
                                concurrent="true" saveField="uploadFile" chunkSize="102400" />
            <kendo:upload-validation maxFileSize="${maxFileSizeVar}" />
          </kendo:upload>
        </div>
        <ul class="f_list" data-template="file-template" data-bind="source: data"></ul>
      </td>
    </table>
    <!-- btns -->
    <div class="btns tac">
      <button type="button" id="costApprBtn" class="button info" data-bind="click: approval">비용신청하기</button>
      <button type="button" class="button submit" data-bind="click: save">저장하기</button>
      <button type="button "class="button" data-bind="click: search">취소하기</button>
    </div>
    <!-- /btns -->
    <!-- /등록 -->
  </div>
  <!-- /container -->
</div>
<!--◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ /#body_content ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆-->

<script id="file-template" type="text/x-kendo-template">
  <li data-id="#= atchmnflId #">
		<span class="f_name">
			#if (ext === ".doc" || ext == ".docx") {#
			<img src="<c:url value="/assets/img/lib/ic16_doc.png"/>" />
			#} else if (ext == ".gif") {#
			<img src="<c:url value="/assets/img/lib/ic16_gif.png"/>" />
			#} else if (ext == ".hwp") {#
			<img src="<c:url value="/assets/img/lib/ic16_hwp.png"/>" />
			#} else if (ext == ".jpg" || ext == '.jpeg') {#
			<img src="<c:url value="/assets/img/lib/ic16_jpg.png"/>" />
			#} else if (ext == ".pdf") {#
			<img src="<c:url value="/assets/img/lib/ic16_pdf.png"/>" />
			#} else if (ext == ".ppt" || ext == ".pptx") {#
			<img src="<c:url value="/assets/img/lib/ic16_ppt.png"/>" />
			#} else if (ext == ".txt") {#
			<img src="<c:url value="/assets/img/lib/ic16_txt.png"/>"/>
			#} else if (ext == ".xls" || ext == ".xlsx") {#
			<img src="<c:url value="/assets/img/lib/ic16_xls.png"/>"/>
			#} else if (ext == ".zip") {#
			<img src="<c:url value="/assets/img/lib/ic16_zip.png"/>"/>
		  #} else {#
			<img src="<c:url value="/assets/img/lib/ic16_file.png"/>"/>
			#}#
			#= name #
		</span>
    <div class="f_btns">
      <button type="button" class="button" title="삭제" data-id="#= atchmnflId #" data-bind="click: delete"><i class="minus"></i></button>
      <a href="${downloadUrl}/#= atchmnflId #" class="button" title="다운로드"><i class="down"></i></a>
    </div>
  </li>
</script>

<script type="text/javascript">
    var costApprYn = "${costInfo}";
    if(costApprYn == "Y"){
      //비용신청을 하였을 경우에
      $("#costApprBtn").hide();  //비용신청 버튼 숨김
      $("#cmb_approval_input").kendoDropDownList({  //결과구분 disable
        enable: false
      });
      $("#cmb_matDiv_input").kendoDropDownList({  //자재선택 disable
        enable: false
      });
      $("#costSearch").hide(); //출동비용 버튼 숨김
      $("#btn_add").hide();   //교환품번 추가 버튼 숨김
    }
    var _dicasPage = new DicasPage('${screenId}');

    <%-- Control Definition --%>
    var editor;
    <%--// Control Definition --%>

    <%-- Variable Definition --%>
    var validatable = null;
    <%--// Variable Definition --%>

    var boardMdl = kendo.data.Model.define({
        id: "manageNo",
        fields: {
            manageNo            : { type: "string" },
            roNo                : { type: "string" },
            recallReqDate       : { type: "string" },
            gqnetIssueDate      : { type: "string" },
            repairDate          : { type: "string" },
            enginNo             : { type: "string" },
            receiveDate         : { type: "string" },
            removeNo            : { type: "string" },
            roConfirmDate       : { type: "string" },
            dnResearchResult    : { type: "string" },
            matDiv              : { type: "string" },
            callCenterApproval  : { type: "string" },
            gqnetNo             : { type: "string" },
            fieldWorkResult     : { type: "string" },
            finalResearchResult : { type: "string" },
            qualityProblemNm    : { type: "string" },
            travelAmt           : { type: "string" },
            totalAmt            : { type: "string" },
            partAmtTot          : { type: "string" },
            labor               : { type: "string" },
            recallType          : { type: "string" },
            reprYn              : { type: "string" },
            actionType          : { type: "string" },
            partVal             : { type: "string" },
            laborVal            : { type: "string" },
            etcVal              : { type: "string" },
            totalVal            : { type: "string" }
        }
    });

    var boardMdl1 = kendo.data.Model.define({
        id: "id",
        fields: {
            hmcPartNo           : { type: "string" },
            replacePartNo       : {type: "string"},
            replacePartNm       : { type: "string" },
            replacePartCnt      : { type: "string" },
            updtrId             : { type: "string" },
            updtDt              : { type: "string" },
            id                  : { type: "string" }
        }
    });

    var inputView = kendo.observable({
      data: null,
      save: function() {
        // if (!inputView.validate()) {
        //   _dicasPage.alert({
        //     title: '저장확인',
        //     message: '필수 항목을 입력해 주십시오.'
        //   });
        //   return;
        // }
        if (inputView.hasChanges()) {
          _dicasPage.confirm({
            title: '저장확인',
            message: '변경사항을 저장하시겠습니까?',
            confirm: function() {
              inputViewAjax();
              var insValue = "";

              //추가 된 교환품번 체크
              $('#partTbl').find('tr').each(function() {
                if($(this).attr('data-id') == ''){ //data-id가 null인 항목은 신규 추가
                  insValue += $(this).attr('data-value')+ "|"+$(this).attr('data-name')+"|"+$(this).attr('data-cnt')+"|"+$(this).attr('data-repartNo')+",";
                }
              });
              insValue = insValue.substr(0, insValue.length -1);
              $("#IU").val(insValue);

              inputView1Ajax();
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
      approval: function(){
        var mngNo = "${mstInfoForm.manageNo}";
        $.ajax({
          method: "POST",
          url: '${checkSdUrl}',
          data: {"manageNo" : mngNo},
          //data: JSON.stringify(inputView1.get('data')),
          contentType: 'application/json;charset=UTF-8'
        }).done(function (data, status, jqXHR) {

          if (data.auditInfo == '03') {

            //alert(data.auditInfo);
            if(confirm("비용신청을 하시겠습니까?")){
              $.ajax({
                method: "POST",
                url: '${sdCostApproval}',
                data: {"manageNo" : mngNo},
                contentType: 'application/json;charset=UTF-8'
              }).success(function(data, status){

                alert("비용신청을 완료하였습니다.");
                $("#costApprBtn").hide();
                window.location.href = "${initServiceUrl}";
                return false;


              }).fail(function (data, status, jqXHR) {

                alert("신청 중 오류가 발생하였습니다.");
                return false;

              });
            }
          }else{

            alert("SD출동시에만 비용승인신청이 가능합니다.");
            return false;

          }
        }).fail(function (data, status, jqXHR) {

          alert("신청 중 오류가 발생하였습니다.");

        }).always(function () {

          // _dicasPage.maskClose();

        });
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

    var inputView1 = kendo.observable({
        data: null,
        validate: function () {
            if (validatable == null) return true;
            return validatable.validate();
        },
        hasChanges: function () {
            return true;
        },
        popup: function () {
            var that = this;
            _dicasPage.popupOpen({
                url: "${popupUrl}",
                code: 'codeHelp',
                width: 1400,
                height: 800,
                params: {
                },
                beforeOpen: function () {
                    _dicasPage.beforeCodeHelpVal = true;
                },
                afterClose: function(info) {
                    if (info.result) {
                        var _data = JSON.parse(info.data);
                        that.set('data.hmcPartNo', _data.hmc)
                        that.set('data.replacePartNm', _data.exchangeNm);
                        that.set('data.replacePartNo', _data.replacePartNo);
                    } else {
                        that.set('data.hmcPartNo', null);
                        that.set('data.replacePartNm', null);
                        that.set('data.replacePartNo', null);
                    }
                }
            });
        }

    });
    kendo.bind($("#view_container2"), inputView1);

    var fileView = kendo.observable({
      data: [],
      delete: function(e) {
        var atchmnflId = e.data.atchmnflId;
        $.ajax({
          type: 'POST',
          url: "${deleteFileUrl}/" + atchmnflId,
          dataType: 'json',
          contentType: "application/json",
          success: function(data, state, xhr) {
            try {
              var fileItem = $("li[data-id=" + atchmnflId + "]");
              fileItem.remove();

              var files = "";
              $("ul.f_list li").each(function(i,v) {
                var atchmnflId = $(v).attr('data-id');
                if (i == 0)
                  files = atchmnflId;
                else
                  files += "," + atchmnflId;
              });

              if (files.length > 0) {
                inputView.set('data.files', files);
              }

            } catch(e) {
              alert('파일 삭제 후 오류가 발생하였습니다.');
            }
          },
          error: function (xhr, state, err) {
            try {
              alert(xhr.responseJSON.message);
            } catch(e) {
              alert('파일 삭제 중 오류가 발생하였습니다.');
            }
          }
        });
      }
    });
    kendo.bind($(".f_list"), fileView);

    function addData(){

      if($("#hmcPartNo_v").val() == ""){
        alert("교환품번을 먼저 선택하셔야 합니다.");
        return false;
      }
      if($("#replacePartCnt_v").val()==""){
        alert("교환수량을 입력해 주세요.");
        return false;
      }
      var partNo = $("#hmcPartNo_v").val();         //고객품번
      var partNm = $("#replacePartNm_v").val();     //교환품명
      var partCnt = $("#replacePartCnt_v").val();   //교환수량
      var repartNo = $("#replacePartNo_v").val();   //교환품번
      var strLi = "";
      var exists = false;

      //품번 기등록 여부 체크
      $('#partTbl').find('tr').each(function() {     //품번테이블 loop 체크
        if($(this).attr('data-value') == partNo){
          alert("해당 품번은 이미 추가되어 있습니다.");
          exists = true;
          return false;
        }
      });

      if(!exists) {
        strLi += '<tr id="tr_' + partNo + '" data-value=\"' + partNo + '\" data-name=\"' + partNm + '\" data-cnt=\"' + partCnt + '\" data-id="" data-repartNo=\"' + repartNo + '\" >';
        strLi += '<td>' + partNo + '</td>';
        strLi += '<td>' + partNm + '</td>';
        strLi += '<td>' + partCnt + '</td>';
        strLi += '<td style="text-algn:center"><button class="button" onclick=delTr(\"' + partNo + '\","")>제거</buttom></td>';
        strLi += '</tr>';
        $("#partTbl").append(strLi);
        //인풋값 초기화
        $("#hmcPartNo_v").val("");
        $("#replacePartNm_v").val("");
        $("#replacePartCnt_v").val("");
        $("#replacePartNo_v").val("");
      }
    }

    function delTr(partNo, id){
     if(costApprYn == "Y"){
       alert("비용승인신청 상태일 경우에는 제거하실 수 없습니다.");
       return false;
     }
      var value = "";
      if(confirm("해당 항목을 제거하시겠습니까?\n저장시 삭제가 완료됩니다.")) {
        if(id != ""){  /* id가 있을 경우엔 DB에서 지워야 할 목록을 담는다. */
          if ($("#D").val() == "") {
            value = id;
            $("#D").val(value);
          } else {
            value = $("#D").val() + "," + id;
            $("#D").val(value);
          }
        }
        $("#tr_"+partNo).remove();
      }
    }
    $(document).ready(function() {

      $("#btn_add").click(function(){
        addData();
      });

      cmbMatDivInput = $("#cmb_matDiv_input", "#body_content").data("kendoDropDownList");
      cmbApprovalInput = $("#cmb_approval_input", "#body_content").data("kendoDropDownList");

      // validatable = $("#body_content").kendoValidator({validateOnBlur: false})
      //     .data("kendoValidator")

      var data = new boardMdl({
          manageNo              : "${resultForm.manageNo}",
          roNo                  : "${resultForm.roNo}",
          recallReqDate         : "${resultForm.recallReqDate}",
          gqnetIssueDate        : "${resultForm.gqnetIssueDate}",
          repairDate            : "${resultForm.repairDate}",
          enginNo               : "${resultForm.enginNo}",
          receiveDate           : "${resultForm.receiveDate}",
          removeNo              : "${resultForm.removeNo}",
          roConfirmDate         : "${resultForm.roConfirmDate}",
          dnResearchResult      : "${resultForm.dnResearchResult}",
          matDiv                : "${resultForm.matDiv}",
          callCenterApproval    : "${resultForm.callCenterApproval}",
          gqnetNo               : "${resultForm.gqnetNo}",
          fieldWorkResult       : "${resultForm.fieldWorkResult}",
          finalResearchResult   : "${resultForm.finalResearchResult}",
          qualityProblemNm      : "${resultForm.qualityProblemNm}",
          travelAmt             : "${resultForm.travelAmt}",
          totalAmt              : "${resultForm.totalAmt}",
          partAmtTot            : "${resultForm.partAmtTot}",
          labor                 : "${resultForm.labor}",
          recallType            : "${resultForm.recallType}",
          reprYn                : "${resultForm.reprYn}",
          actionType            : "${resultForm.actionType}",
          partVal               : "${resultForm.partVal}",
          laborVal              : "${resultForm.laborVal}",
          etcVal                : "${resultForm.etcVal}",
          totalVal              : "${resultForm.totalVal}",
      });
      inputView.set('data', data);

        var data = new boardMdl1({
            hmcPartNo             : "${resultForm.hmcPartNo}",
            replacePartNm         : "${resultForm.replacePartNm}",
            replacePartCnt        : "${resultForm.replacePartCnt}",
            replacePartNo        :  "${resultForm.replacePartNo}",
            updtrId               : "${resultForm.updtrId}",
            updtDt                : "${resultForm.updtDt}",
            id                    : "${resultForm.id}"
        });
        inputView1.set('data', data);

      upload = $("#files").data("kendoUpload");

      <c:if test="${fileItems != null}">
        var files = [];

        <c:forEach var="item" items="${fileItems}" varStatus="status">
          <c:if test="${item.atchmnflItem != null}">
          files.push({
            atchmnflId : "${item.atchmnflId}",
            ext: "${item.flext}",
            name: "${item.atchmnflNm}"
          });
          </c:if>
        </c:forEach>
        fileView.set('data', files);
      </c:if>

    });

    var headerView = kendo.observable({
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


    function inputView1Ajax() {

        var valueArray = new Array();
        var inputInfo = new Object();
        var delInfo = new Object();
        var mngNo = "${mstInfoForm.manageNo}";
        var vinNo = "${mstInfoForm.vinno}";
        delInfo.D = $("#D").val(); /* 삭제 히든값 추가 */
        valueArray.push(delInfo); /* 삭제는 id만 있으면 됨. */

       if($("#D").val() != ""){
         $.ajax({
           method: "POST",
           url: '${itemDelete}',
           data: JSON.stringify(valueArray),
           //data: JSON.stringify(inputView1.get('data')),
           contentType: 'application/json;charset=UTF-8'
         }).done(function (data, status, jqXHR) {
           console.log(data+", "+status+", "+jqXHR);
           $("#D").val(""); /* 삭제 후 히든값 초기화 */
         }).fail(function (data, status, jqXHR) {
           alert("제거 중 오류가 발생하였습니다.");
         }).always(function () {
           // _dicasPage.maskClose();
         });
       }

       valueArray = new Array();  /* 배열 초기화 */
       inputInfo.IU = $("#IU").val();  /* 등록 히든값을 배열에 추가 */
       inputInfo.manageNo = mngNo; /* manageNo 추가 */
       inputInfo.vinno = vinNo; /*vinno 추가*/
       inputInfo.serviceDegree = 1; /* serviceDegree는 신규 등록시 기본 1로 세팅 */
       valueArray.push(inputInfo); /* 등록에 필요한 마스터+교환품 정보 추가 */

       if($("#IU").val() != ""){
          $.ajax({
            method: "POST",
            url: '${itemAdd}',
            data: JSON.stringify(valueArray),
            contentType: 'application/json;charset=UTF-8'
          }).done(function (data, status, jqXHR) {
            $("#IU").val(""); /!* 등록 후 히든값 초기화 *!/

          }).fail(function (data, status, jqXHR) {
            alert("신규 등록 중 중 오류가 발생하였습니다.");
          }).always(function () {
            // _dicasPage.maskClose();
          });
       }

    }

    function inputViewAjax() {

      //file upload
      var files = "";
      $("ul.f_list li").each(function(i,v) {
        var atchmnflId = $(v).attr('data-id');
        if (i == 0)
          files = atchmnflId;
        else
          files += "," + atchmnflId;
      });

      if (files.length > 0) {
        inputView.set('data.files', files);
      }

      $.ajax({
        method: "POST",
        url: '${updateUrl2}',
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

    function onComplete(e) {
    }

    function onError(e) {
      try {
        var resp = JSON.parse(e.XMLHttpRequest.responseText);
        console.log(resp.message);
      } catch (e) {
        console.log("파일 업로드 중 오류가 발생하였습니다.");
      }
    }

    function onUpload(e) {
      var xhr = e.XMLHttpRequest;
      xhr.addEventListener("readystatechange", function (e) {
        if (xhr.readyState == 1 /* OPENED */) {
          try {
            xhr.setRequestHeader('X-Requested-With', "XMLHttpRequest");
          } catch (e) {
          }
        }
      });
    }

    function onSelect(e) {
      setTimeout(function() {
        $(window).trigger('resize');
      },100);
    }

    function onSuccess(e) {
      var fileInfo = {
        atchmnflId : e.response.atchmnflId,
        ext: e.files[0].extension.replace(/\\./g,""),
        name: e.files[0].name
      }
      fileView.data.push(fileInfo);
      setTimeout(function() {
        upload.clearFileByUid(e.files[0].uid);

        var files = "";
        $("ul.f_list li").each(function(i,v) {
          var atchmnflId = $(v).attr('data-id');
          if (i == 0)
            files = atchmnflId;
          else
            files += "," + atchmnflId;
        });

        if (files.length > 0) {
          inputView.set('data.files', files);
        }

      }, 500);
    }



</script>