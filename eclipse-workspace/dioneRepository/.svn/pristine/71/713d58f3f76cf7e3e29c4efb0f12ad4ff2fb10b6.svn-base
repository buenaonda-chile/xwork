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

<c:url var="deleteUrl" value="/mobile/serviceSD/init/${serviceId}/delete" />

<c:url var="saveUrl2" value="/mobile/serviceSD/init/${serviceId}/save2" />
<c:url var="saveUrl3" value="/mobile/serviceSD/init/${serviceId}/save3" />
<c:url var="saveUrl4" value="/mobile/serviceSD/init/${serviceId}/save4" />

<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] 画面ID (@ViewIdで定義) --%>
<c:set var="screenId" value="<%= request.getAttribute(Globals.SCREEN_ID_KEY) %>"/>

<!--◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ #head ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆-->
<div id="head" class="init">
  <!-- container -->
  <div id="headerView" class="container">
    <h1>비용(에어컨)</h1>
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
    <li><a href="${initResultUrl}"><i class="ic5"></i><span class="t1">결과</span></a></li>
    <li class="on"><a href="javascript:;"><i class="ic6"></i><span class="t1">비용</span></a></li>
  </ul>
</div>
<!--◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ /#cnb1 ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆-->    

<hr class="dpn" />

<!--◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ #body_content ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆-->
<div id="body_content" class="init body_cnb1"> <!-- cnb1 가 있는 경우 body_cnb1을 넣어준다-->
  <!-- container -->
  <div class="container" id="view_container">

    <!-- 공임비 -->
    <div class="bList mod">
        <span class="tit">
          <!--공임비 : <input type="text" id="labor" data-bind="value: data.labor" style="width: 80px">원-->
          ①공임비 : <span id="labor" data-bind="text: data.labor"></span>원
        </span>
    </div>
    <!-- 작업시간 -->

    <div class="bList mod">
      <a id="about" href="#">
      <span class="tit">
            ②작업시간 : <span id="time" data-bind="text: data.time"></span>시간
      </span>
      </a>

      <span id="gridDiv1" class="gridMod" style="display: none;">
        <div id="grid4"></div>
      </span>

    </div>
    <!-- 수리비 -->
    <div class="bList">
      <span class="tit">
        ③수리비(①*②) :
        <!--<input type="text" id="repairAmtTot" data-bind="value: data.repairAmtTot" style="width: 80px"/>-->
        <span id="repairAmtTot" data-bind="text: data.repairAmtTot"></span>
        원
      </span>
    </div>
    <div class="bList mod">
      <a id="about4" href="#">
      <span class="tit">
          ④제품대 : <span id="partAmtTot" data-bind="text: data.partAmtTot"></span>원
      </span>
      </a>

      <span id="gridDiv3" class="gridMod" style="display: none;">
        <div id="grid5"></div>
      </span>

    </div>
    <div class="bList">
      <span class="tit">
        ⑤제품마진(④*rate) :
        <span id="partMarginCulcu" data-bind="text: data.partMarginCulcu"></span>
        원
      </span>
    </div>
    <!-- 부대비 -->
    <div class="bList mod">
      <a id="about3" href="#">
      <span class="tit">
        ⑦부대비 :
          <!--<input type="text" id="partAmtTot" data-bind="value: data.partAmtTot" style="width: 80px"/>-->
        <span id="etcAmtTot" data-bind="text: data.etcAmtTot"></span>
        원
      </span>
      </a>

      <span id="gridDiv2" class="gridMod2" style="display: none;">

        <kendo:button name="add3">추가</kendo:button>
        <div id="grid3"></div>
        <div id="popup3"></div>

        <script type="text/x-kendo-template" id="windowTemplate2">
            <p class="tac">삭제 하시겠습니까 ? </p>
            <div class="tac">
                <button class="button submit" type="button" id="yesButton2" >확인</button>
                <button class="button" type="button" id="noButton2" > 취소</button>
            </div>
        </script>

        <div style="margin-top:40px;"><kendo:button name="add2" class="po2">추가</kendo:button></div>
        <div id="grid2"></div>
        <div id="popup2"></div>

        <script type="text/x-kendo-template" id="windowTemplate3">
            <p class="tac">삭제 하시겠습니까 ? </p>
            <div class="tac">
                <button class="button submit" type="button" id="yesButton3" >확인</button>
                <button class="button" type="button" id="noButton3" > 취소</button>
            </div>
        </script>

      </span>

    </div>
    <div class="bList">
      <a id="about2" href="#">
      <span class="tit">
        ⑧출장비 :
        <!--<input type="text" id="partAmtTot" data-bind="value: data.partAmtTot" style="width: 80px"/>-->
        <span id="travelAmt" data-bind="text: data.travelAmt"></span>
        원
      </span>
      </a>
       <span id="distInput" style="display: none;">
        왕복거리: <input type="text" id="inputDist" data-bind="value: data.dist" style="width: 80px">KM
       </span>
    </div>
    <div class="bList">
        <span class="tit">⑨부가세(③ + ④ + ⑤ + ⑥ + ⑦ + ⑧) * 10% :<span id="taxAmt" data-bind="text: data.taxAmt"></span>원</span>
    </div>
    <div class="bList">
        <!--<span class="tit">총   합 : <input type="text" id="totalAmt" data-bind="value: data.totalAmt" style="width: 90px"/>원</span>-->
        <span class="tit">총합(③ + ④ + ⑤ + ⑥ + ⑦ + ⑧ + ⑨):<span id="totalAmt" data-bind="text: data.totalAmt"></span>원</span>
    </div>

    <!-- /리스트 -->
    <!-- btns -->
    <div class="btns tac">
      <button type="button" id="saveChanges" class="button submit" >저장하기</button>
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

    var boardMdl = kendo.data.Model.define({
        id: "manageNo",
        fields: {
            manageNo: { type: "string" },
            labor: { type: "string" },
            taxAmt: { type: "string" },
            travelAmt: { type: "string" },
            totalAmt: { type: "string" },
            etcAmtTot: { type: "string" },
            partMarginCulcu: { type: "string" },
            repairAmtTot: { type: "string" },
            partAmtTot: { type: "string" },
            dist: { type: "string" },
            time: { type: "string" },

        }
    });

    var inputView = kendo.observable({
        data: null
    });
    kendo.bind($("#view_container"), inputView);

    getEditOptions2 = function (data) {

      var editoptions = [];

      item = {
        costNm: '선택해주세요.',
        costCd: ''
      }
      editoptions.push(item);

      for (var i = 0; i < data.length; i++) {

        var item;

        item = {
          costNm: data[i].itemNm,
          costCd: data[i].itemCd
        }

        editoptions.push(item);
      }
      return editoptions;
    };

    function categoryDropDownEditor2(container, options) {
        $('<input data-bind="value:' + options.field + '"/>')
            .appendTo(container)
            .kendoDropDownList({
                autoBind: false,
                dataTextField: "costNm",
                dataValueField: "costCd",
                dataSource: getEditOptions2(${jsonIncidentCostItems2}),
                change:function(e){      //드롭다운 내 값 선택했을 때 이벤트
                    var mm= this.dataItem(e.node);
                    var costNm= mm.costNm;  //선택된 값
                    var costCd= mm.costCd;  //선택된 값

                    sum();

                },
            });
    }

    function categoryDropDownEditor3(container, options) {
      $('<input data-bind="value:' + options.field + '"/>')
              .appendTo(container)
              .kendoDropDownList({
                autoBind: false,
                dataTextField: "costNm",
                dataValueField: "costCd",
                dataSource: getEditOptions2(${jsonIncidentCostItems1}),
                change:function(e){      //드롭다운 내 값 선택했을 때 이벤트
                  var mm= this.dataItem(e.node);
                  var costNm= mm.costNm;  //선택된 값
                  var costCd= mm.costCd;  //선택된 값

                  $.each(${jsonIncidentCostItems1},function(key,value) {
                    if (costCd == value.itemCd) {
                      //alert('key:' + key + ', value:' + value.value);
                      //value:' + value.value;
                      var grid = $("#grid3").data("kendoGrid");
                      var selectedItem = grid.dataItem(grid.select());
                      selectedItem.set("costValue",value.value);
                      //alert(value.value);
                      //alert(selectedItem.uid);
                    }
                  });

                  sum();

                },
              });
    }

    function onClick2(e) {
        var grid2 = $("#grid2").data("kendoGrid");
        //grid.addRow();
        grid2.dataSource.add( { costValue: "", costMap: {  costCd: "AC006-0001", costNm: "택배비" }} );
        sum();
    }

    function onClick3(e) {
      var grid3 = $("#grid3").data("kendoGrid");
      //grid.addRow();
      grid3.dataSource.add( { costValue: "9600", costMap: {  costCd: "AC001-0001", costNm: "냉매" }} );

      sum();
    }

    // 계산식
    function sum() {

        var sum = 0.0
        var time = 0.0;
        //시간전체계산

        var grid4 = $("#grid4").data("kendoGrid");
        var data4 = grid4.dataSource.data();
        var totalNumber4 = data4.length;

        for(var i = 0; i<totalNumber4; i++) {
            var currentDataItem = data4[i];
            time = time + Number(currentDataItem.workHour);
        }

        //작업시간 설정
        //time
        $("#time").html(time);

        var labor = ${resultForm.labor};
        //전체합계계산
        var repairAmtTot = 0;
        repairAmtTot = time * labor;
        repairAmtTot = Math.floor(repairAmtTot);
        $("#repairAmtTot").html(repairAmtTot);

        sum = sum + repairAmtTot;

      // 제품대
      // 조사결과의 자재구분이 DENSO인 경우 제품대 제외 자재구분이 모비스(현대,기아)인 경우 제품대 표시
      // 제품마진은 에어컨만 표시
      //자재구분이 DENSO가아닐때
      var matDiv = '${resultForm.matDiv}';
      var materialDiv = '${resultForm.materialDiv}';

      // 제품대
      var partAmtTot  = 0;

      var grid4 = $("#grid4").data("kendoGrid");
      var data4 = grid4.dataSource.data();
      var totalNumber4 = data4.length;

      for(var i = 0; i<totalNumber4; i++) {

        var currentDataItem = data4[i];
        var partsCost = currentDataItem.partsCost;
        var partCnt = currentDataItem.replacePartCnt;

        if (matDiv == '2') {
          partsCost = 0;
          //grid4.setValue(grid2.getRow(i).rowKey, 'partsCost', 0);
          //grid2.setValue(grid2.getRow(i).rowKey, 'partsCost', 0);
        }
        partAmtTot = partAmtTot + (partsCost * partCnt);

      }
      $("#partAmtTot").html(partAmtTot);
      sum = sum + Number(partAmtTot);

      var partMarginCulcu = 0;

      for(var i = 0; i<totalNumber4; i++) {

        var currentDataItem = data4[i];
        var partsCost = currentDataItem.partsCost;
        var margin = currentDataItem.margin;
        var partCnt = currentDataItem.replacePartCnt;

        partMarginCulcu = partMarginCulcu + (partsCost / 100 *  margin * partCnt);

        if (matDiv == '1' && materialDiv == '01') {
          partMarginCulcu = 0;
        }
      }
      $("#partMarginCulcu").html(partMarginCulcu);
      sum = sum + Number(partMarginCulcu);

        //부대비계산
        var grid2 = $("#grid2").data("kendoGrid");
      var data2 = grid2.dataSource.data();
      var totalNumber2 = data2.length;
      var etc = 0.0;

      for(var i = 0; i<totalNumber2; i++) {
        var currentDataItem = data2[i];
        etc = etc + Number(currentDataItem.costValue);
      }

      var grid3 = $("#grid3").data("kendoGrid");
      var data3 = grid3.dataSource.data();
      var totalNumber3 = data3.length;

      for(var i = 0; i<totalNumber3; i++) {
        var currentDataItem = data3[i];
        etc = etc + Number(currentDataItem.costValue);
      }

        $("#etcAmtTot").html(etc);
        //전체합계계산
        sum = sum + etc;

        //출장비
        var dist = $("#inputDist").val();
        var travelAmt = 0;
        if (dist === undefined || dist == 0) {
            dist = 0;
            $('#dist_input').val(0);
        } else {

            var strOfficeHRate = '20';
            var strOfficeKm100InRate = '3.4';
            var strOfficeKm100outRate = '1.7';

            var officeHRate = 0;
            var officeKm100InRate = 0;
            var officeKm100outRate = 0;
            if (strOfficeHRate != '') {
                officeHRate = Number(strOfficeHRate);
            }
            if (strOfficeKm100InRate != '') {
                officeKm100InRate = Number(strOfficeKm100InRate);
            }
            if (strOfficeKm100outRate != '') {
                officeKm100outRate = Number(strOfficeKm100outRate);
            }

            var base = labor / 100 * officeHRate;
            travelAmt = travelAmt + base;
            if (dist < 100) {
                var rate = labor / 100 * officeKm100InRate;
                travelAmt = travelAmt + (rate * dist);
            } else {
                var rate = labor / 100 * officeKm100outRate;
                travelAmt = travelAmt + (rate * dist);
            }
        }
        $("#travelAmt").html(travelAmt);
        sum = sum + travelAmt;

        var taxAmt = Math.floor(sum / 10);
        $("#taxAmt").html(taxAmt);
        sum = sum + taxAmt;

        //49원이하 절삭
        //50원이상 반올림
        var temp = sum / 100;
        temp = Math.round(temp);
        sum = temp * 100;

        //합계
        $("#totalAmt").html(sum);

    }

    $(document).ready(function() {

      var windowTemplate2 = kendo.template($("#windowTemplate2").html());
      var windowTemplate3 = kendo.template($("#windowTemplate3").html());

      var popup2 = $("#popup2").kendoWindow({
        title: "확인창",
        visible: false, //the window will not appear before its .open method is called
        width: "300px",
        height: "120px",
        modal: true,
      }).data("kendoWindow");

      var popup3 = $("#popup3").kendoWindow({
        title: "확인창",
        visible: false, //the window will not appear before its .open method is called
        width: "300px",
        height: "120px",
        modal: true,
      }).data("kendoWindow");

        var data = new boardMdl({
            manageNo: "${resultForm.manageNo}",
            labor: "${resultForm.labor}",
            taxAmt: "${resultForm.taxAmt}",
            travelAmt: "${resultForm.travelAmt}",
            totalAmt: "${resultForm.totalAmt}",
            etcAmtTot: "${resultForm.etcAmtTot}",
            partMarginCulcu: "${resultForm.partMarginCulcu}",
            repairAmtTot: "${resultForm.repairAmtTot}",
            partAmtTot: "${resultForm.partAmtTot}",
            dist: "${resultForm.dist}",


        });
        inputView.set('data', data);

        $('#about').click(   // If you wish to do something clicking anchor
            function(){
                //alert("Hello");
                $('#gridDiv1').toggle();
                $('#gridDiv1').css('height', '150px');
                var grid = $("#grid4").data("kendoGrid");
                grid.refresh();
            });

        $('#about2').click(   // If you wish to do something clicking anchor
            function(){
                //alert("Hello");
                $('#distInput').toggle();
            });

        $('#about3').click(   // If you wish to do something clicking anchor
            function(){
               //alert("Hello");
               $('#gridDiv2').toggle();
               $('#gridDiv2').css('height', '320px');
              $("#grid3").css('height', '140px');
              $("#grid2").css('margin-top', '100px');
               var grid2 = $("#grid2").data("kendoGrid");
              var grid3 = $("#grid3").data("kendoGrid");
              grid2.refresh();
              grid3.refresh();
            });

      $('#about4').click(   // If you wish to do something clicking anchor
              function(){
                //alert("Hello");
                $('#gridDiv3').toggle();
                $('#gridDiv3').css('height', '150px');
                var grid5 = $("#grid5").data("kendoGrid");
                grid5.refresh();
              });

        $("#inputDist").change(function(){
            sum();
        });

        $("#add2").kendoButton({
            click: onClick2
        });

      $("#add3").kendoButton({
        click: onClick3
      });

        //#:costNm#
        $("#grid2").kendoGrid({
            columns: [
                { field: "costMap", title: "구분", editor: categoryDropDownEditor2, template: "#=costMap.costNm#" },
                { field: "costValue", title: "금액" },
              { command: [
                  {
                    name: "삭제",
                    click: function (e) {  //add a click event listener on the delete button
                      e.preventDefault(); //prevent page scroll reset
                      var tr = $(e.target).closest("tr"); //get the row for deletion
                      var data = this.dataItem(tr); //get the row data so it can be referred later
                      popup2.content(windowTemplate2(data)); //send the row data object to the template and render it
                      popup2.center().open();

                      $("#yesButton2").click(function () {
                        var grid2 = $("#grid2").data("kendoGrid");
                        grid2.dataSource.remove(data);  //prepare a "destroy" request
                        grid2.dataSource.sync();  //actually send the request (might be ommited if the autoSync option is enabled in the dataSource)
                        popup2.close();
                        sum();
                      })
                      $("#noButton2").click(function () {
                        popup2.close();
                      })
                    }
                  }
                ] }
            ],
            dataSource: ${jsonResultmasterCostItems2},
            filterable: false,
            columnMenu: false,
            mobile: true,
            height: 150,
            editable: true,
            selectable: "row",
            remove: function(e) {
                //삭제시 추가 동작 처리 영역
              setTimeout(function(){
                // 1초 후 작동해야할 코드
                sum();
              }, 300);
            },
            change: function(e) {
                sum();
            },
          cellClose:  function(e) {
            sum();
          }
        });

      $("#grid3").kendoGrid({
        columns: [
          { field: "costMap", title: "구분", editor: categoryDropDownEditor3, template: "#=costMap.costNm#" },
          { field: "costValue", title: "금액" },
          { command: [
              {
                name: "삭제",
                click: function (e) {  //add a click event listener on the delete button
                  e.preventDefault(); //prevent page scroll reset
                  var tr = $(e.target).closest("tr"); //get the row for deletion
                  var data = this.dataItem(tr); //get the row data so it can be referred later
                  popup3.content(windowTemplate3(data)); //send the row data object to the template and render it
                  popup3.center().open();

                  $("#yesButton3").click(function () {
                    var grid3 = $("#grid3").data("kendoGrid");
                    grid3.dataSource.remove(data);  //prepare a "destroy" request
                    grid3.dataSource.sync();  //actually send the request (might be ommited if the autoSync option is enabled in the dataSource)
                    popup3.close();
                    sum();
                  })
                  $("#noButton3").click(function () {
                    popup3.close();
                  })
                }
              }
            ] }
        ],
        dataSource: ${jsonResultmasterCostItems1},
        filterable: false,
        columnMenu: false,
        mobile: true,
        height: 150,
        editable: true,
        selectable: "row",
        remove: function(e) {
          //삭제시 추가 동작 처리 영역
          setTimeout(function(){
            // 1초 후 작동해야할 코드
            sum();
          }, 300);
        },
        change: function(e) {
          sum();
        },
        cellClose:  function(e) {
          sum();
        }
      });

      $("#grid4").kendoGrid({
        columns: [
          { field: "replacePartNm", title: "구분" },
          { field: "workHour", title: "시간" }
        ],
        dataSource: ${jsonResultmasterItems},
        filterable: false,
        columnMenu: false,
        mobile: true,
        height: 150,
        editable: false,
        selectable: "row"
      });

      $("#grid5").kendoGrid({
        columns: [
          { field: "replacePartNm", title: "구분" },
          { field: "partsCost", title: "금액" }
        ],
        dataSource: ${jsonResultmasterItems},
        filterable: false,
        columnMenu: false,
        mobile: true,
        height: 150,
        editable: false,
        selectable: "row"
      });

        $("#saveChanges").kendoButton({
            click: function(e) {

                var inputv2 = JSON.stringify($("#grid2").data("kendoGrid").dataSource.data());
                var delval2 = JSON.stringify($("#grid2").data("kendoGrid").dataSource._destroyed);

              var inputv3 = JSON.stringify($("#grid3").data("kendoGrid").dataSource.data());
              var delval3 = JSON.stringify($("#grid3").data("kendoGrid").dataSource._destroyed);

              console.log(data);

                      $.ajax({
                          method: "POST",
                          url: '${deleteUrl}',
                          data: delval2,
                          contentType: 'application/json;charset=UTF-8'
                      }).done(function (data, status, jqXHR) {

                          $.ajax({
                              method: "POST",
                              url: '${saveUrl2}',
                              data: inputv2,
                              contentType: 'application/json;charset=UTF-8'
                          }).done(function (data, status, jqXHR) {

                            $.ajax({
                              method: "POST",
                              url: '${deleteUrl}',
                              data: delval3,
                              contentType: 'application/json;charset=UTF-8'
                            }).done(function (data, status, jqXHR) {

                              $.ajax({
                                method: "POST",
                                url: '${saveUrl3}',
                                data: inputv3,
                                contentType: 'application/json;charset=UTF-8'
                              }).done(function (data, status, jqXHR) {

                              var data =
                                  [
                                      {
                                      "labor":$("#labor").text(),
                                      "repairAmtTot":$("#repairAmtTot").text(),
                                      "partAmtTot":$("#partAmtTot").text(),
                                      "etcAmtTot":$("#etcAmtTot").text(),
                                      "travelAmt":$("#travelAmt").text(),
                                      "totalAmt":$("#totalAmt").text(),
                                      "taxAmt":$("#taxAmt").text(),
                                      "partMarginCulcu":$("#partMarginCulcu").text(),
                                      "dist":$("#inputDist").val()
                                      }
                                  ]

                              $.ajax({
                                  method: "POST",
                                  url: '${saveUrl4}',
                                  data: JSON.stringify(data),
                                  contentType: 'application/json;charset=UTF-8'
                              }).done(function (data, status, jqXHR) {
                                  // 리플래쉬
                                  window.location.reload();
                              }).fail(function (data, status, jqXHR) {
                                  alert("저장 중 오류가 발생하였습니다.");
                              });

                              }).fail(function (data, status, jqXHR) {
                                alert("저장 중 오류가 발생하였습니다.");
                              });

                            }).fail(function (data, status, jqXHR) {
                              alert("저장 중 오류가 발생하였습니다.");
                            });

                          }).fail(function (data, status, jqXHR) {
                              alert("저장 중 오류가 발생하였습니다.");
                          });

                      }).fail(function (data, status, jqXHR) {
                          alert("저장 중 오류가 발생하였습니다.");
                      });

            }
        })

        sum();

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

</script>