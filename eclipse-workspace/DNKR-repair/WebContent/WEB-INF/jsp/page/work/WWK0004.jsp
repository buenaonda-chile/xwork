<%-- [EN] Variable definition --%>
<%-- [JP] ???? --%>
<c:url var="codeUrl" value="/code/list.json"/>

<c:url var="readUrl" value="/researchSD/search"/>
<c:url var="readUrl2" value="/resultMaster/search3"/>
<c:url var="readUrl3" value="/user/search2"/>

<c:url var="createUrl" value="/research/create"/>
<c:url var="updateUrl" value="/research/update"/>
<c:url var="deleteUrl" value="/research/delete"/>

<c:url var="createUrl2" value="/resultMaster/create"/>
<c:url var="updateUrl2" value="/resultMaster/updateManageNo"/>
<c:url var="deleteUrl2" value="/resultMaster/deleteManageNo"/>

<c:url var="createUrl3" value="/resultMaster/create"/>
<c:url var="updateUrl3" value="/resultMaster/gridUpdate"/>
<c:url var="deleteUrl3" value="/resultMaster/delete"/>

<c:url var="popupUrl1" value="/popup/research/init"/>
<c:url var="popupUrl2" value="/popup/partNumber/init"/>

<c:url var="chunkUrl" value="/api/file/chunk"/>
<%--<c:url var="downloadUrl" value="/api/file/download" />--%>

<c:url var="downloadUrl" value="/api/file/download" />
<c:url var="deleteFileUrl" value="/api/file/delete"/>

<!-- 특이사항 반영 -->
<c:url var="updateUrl4" value="/resultMaster/update5"/>

<!-- 결과상태변경 -->
<c:url var="updateUrl6" value="/resultMaster/update4"/>

<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] ??ID (@ViewId???) --%>
<c:set var="screenId" value="<%= request.getAttribute(Globals.SCREEN_ID_KEY) %>"/>

<!-- popup_container -->
<div class="popup_container">
    <form id="frm_search" method="get" >
        <div class="sub-con-wrap">
            <h2 class="subpage-tit">클레임 조사(SD)</h2>

            <!-- 버튼들 -->
            <div class="sub-btn-group">
                <button type="button" id="btn_search" class="button" data-bind="click: search"><i class="w_cancel"></i>조회</button>
                <button type="button" id="btn_save" class="button bc2" data-bind="click: save"><i class="w_save"></i>저장</button>
                <button type="button" id="btn_save2" class="button bc2" data-bind="click: save2"><i class="w_save"></i>승인요청</button>
                <button type="button" id="btn_cancel" class="button" data-bind="click: cancel"><i class="w_cancel"></i>닫기</button>
                <%--<button id="btn_remove" class="button" data-bind="click: remove"><i class="w_minus"></i>삭제</button>--%>
            </div>
            <!-- /버튼들 -->
        </div>
    </form>

    <%-- .search1 --%>
    <%--
    <div class="search1">
      <form id="frm_search" method="get" >
        <fieldset>
          <table>
            <colgroup>
              <col style="width:100px"/>
              <col style="width:155px"/>
              <col/>
            </colgroup>
            <tr>
              <th>그룹</th>
              <td>
                검색조건 미입력
              </td>
              <td>&nbsp;</td>
            </tr>
          </table>
        </fieldset>
      </form>
    </div>
    --%>
    <%--// .search1 --%>

    <!-- 조사 -->

    <div class="layout-B">
        <table class="base_btn" style="width:100%;">
            <tr>
                <td style="width:100px;"><h2>조사</h2></td>
                <td class="search2">
                </td>
                <td class="tar">
                    <div id="divDelBtn1">
                        <button id="btn_remove1" class="button" data-bind="click: remove, visible: btnGrpVisible" ><i class="w_minus"></i>조사삭제</button>
                    </div>
                </td>
            </tr>
        </table>

        <div id="form_container1">
            <form id="frm_input1" method="post">
                <input type="hidden" id="id_input" data-bind="value: data.id" />
                <table class="bWrite">
                    <colgroup>
                        <col style="width:85px" />
                        <col />
                        <col style="width:85px" />
                        <col />
                        <col style="width:85px" />
                        <col style="width:200px" />
                        <col style="width:85px" />
                        <col />
                    </colgroup>
                    <tr>
                        <th>조사일</th>
                        <td>
                            <%--<kendo:datePicker name="dp_researchDate_input" style="width:70%" title="datepicker" data-bind="value: data.researchDate" />--%>
                            <input type="text" id="researchDate_input" data-bind="value: data.researchDate"  class="calendar" />
                        </td>
                        <th rowspan="2">조사내용</th>
                        <td rowspan="2" colspan="5">
                            <textarea id="researchCont_input" data-bind="value: data.researchCont" rows="5" cols="40" class="w100" style="min-height:80px;"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <th>조사자</th>
                        <td>
                            <kendo:dropDownList name="cmb_researchNmS_input" dataTextField="fulnm"
                                                dataValueField="userId"
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
                    </tr>
                    <!--
                    <tr>
                        <th>조사유형</th>
                        <td>
                            <kendo:dropDownList name="cmb_researchType_input" dataTextField="codeNm"
                                                dataValueField="codeCd"
                                                data-value-primitive="true"
                                                data-bind="value: data.researchType" >
                                <kendo:dataSource data="${researchTypeItems}"/>
                            </kendo:dropDownList>
                        </td>
                    </tr>
                    -->
                </table>
            </form>
        </div>

    </div>

    <!-- /조사 -->

    <!-- 결과 -->

    <div class="layout-B">

        <table class="base_btn" style="width:100%;">
            <tr>
                <td style="width:100px;"><h2>결과</h2></td>
                <td class="search2">
                </td>
                <td class="tar">
                    <div id="divDelBtn2">
                        <button id="btn_remove2" class="button" data-bind="click: remove, visible: btnGrpVisible"><i class="w_minus"></i>결과삭제</button>
                    </div>
                </td>
            </tr>
        </table>

        <div id="form_container2">
            <form id="frm_input2" method="post">
                <input type="hidden" id="id_input2" data-bind="value: data.id" />
                <input type="hidden" id="id_manageNo2" data-bind="value: data.manageNo" />
                <table class="bWrite">
                    <colgroup>
                        <col style="width:85px" />
                        <col />
                        <col style="width:85px" />
                        <col />
                        <col style="width:85px" />
                        <col />
                    </colgroup>
                    <tr>
                        <th>고품송부일</th>
                        <td>
                            <input type="text" id="gqnetIssueDate_input" data-bind="value: data.gqnetIssueDate"  class="calendar" />
                        </td>
                        <th>수리일</th>
                        <td>
                            <input type="text" id="repairDate_input" data-bind="value: data.repairDate"  class="calendar" />
                        </td>
                        <th>엔진NO</th>
                        <td>
                            <input type="text" id="enginNo_input" data-bind="value: data.enginNo" />
                        </td>
                    </tr>

                    <tr>
                        <th>자재선택</th>
                        <td>
                            <kendo:dropDownList name="cmb_matDiv_input" dataTextField="codeNm"
                                                dataValueField="codeCd"
                                                data-value-primitive="true"
                                                data-bind="value: data.matDiv"
                                                change="cmbChange">
                                <kendo:dataSource data="${matDivItems}"/>
                            </kendo:dropDownList>
                            <%--<input type="text" id="matDiv_input" data-bind="value: data.matDiv" />--%>
                        </td>
                        <th>결과구분</th>
                        <td>
                            <kendo:dropDownList name="cmb_approval_input" dataTextField="codeNm"
                                                dataValueField="codeCd"
                                                data-value-primitive="true"
                                                data-bind="value: data.actionType" >
                                <kendo:dataSource data="${approvalItems}"/>
                            </kendo:dropDownList>
                            <%--<input type="text" id="approval_input" data-bind="value: data.approval" />--%>
                        </td>
                        <th>출동비용</th>
                        <td>
                            <input type="text" id="travelAmt_input" data-bind="value: data.totalAmt" disabled="disabled"/>
                            <button type="button" class="button" data-bind="click: popup1">
                                <i class="b_nwin"></i>내역
                            </button>
                        </td>
                    </tr>

                    <!--
                    <tr>
                        <th>클레임비용</th>
                        <td colspan="7">
                            부품비
                            <input type="text" id="partVal_input" data-bind="value: data.partVal" />
                            +
                            공임비
                            <input type="text" id="laborVal_input" data-bind="value: data.laborVal" />
                            +
                            외주비
                            <input type="text" id="etcVal_input" data-bind="value: data.etcVal" />
                            =
                            클레임비용
                            <input type="text" id="totalVal_input" data-bind="value: data.totalVal" disabled="disabled"/>
                        </td>
                    </tr>
                    -->


                </table>

            </form>
        </div>

    </div>

    <!-- /결과 -->

    <!-- 교품 그리드 -->

    <div class="layout-LW">
        <!-- 좌측 -->
        <div class="left" style="width:49%;">
            <div style="width:100%;">
                <table style="width:100%;height:40px;">
                    <tr>
                        <%--<td><h2>현상/DTC</h2></td>--%>
                        <td class="tar">
                            <div id="gridDiv">
                                <button type="button" id="btn_add3" class="button" data-bind="click: add"><i class="b_plus"></i><span class="blind">추가</span></button>
                                <button type="button" id="btn_remove3" class="button" data-bind="click: remove"><i class="b_minus"></i><span class="blind">삭제</span></button>
                            </div>
                        </td>
                    </tr>
                </table>
                <div style="margin-bottom:10px;"></div>
                <div id="grid" data-grid-type="view"></div>
            </div>
        </div>

        <div class="right" style="width:49%;padding-top:40px;">
            <!-- 특이사항 -->
            <div id="form_container3">
                <form id="frm_input3" method="post">
                    <div class="layout-B">
                        <!--
                        <table class="bWrite">
                            <colgroup>
                                <col style="width:85px" />
                                <col />
                            </colgroup>
                            <tr>
                                <th>R/O 특이사항</th>
                                <td>
                                    <textarea id="roSpecialFeature_input" data-bind="value: data.roSpecialFeature" rows="5" cols="40" class="w100" style="min-height:100px;" ></textarea>
                                    <input type="hidden" id="id_input3" data-bind="value: data.id" />
                                    <input type="hidden" id="id_manageNo3" data-bind="value: data.manageNo" />
                                </td>
                            </tr>
                        </table>
                        -->
                    </div>
                </form>
            </div>
            <!-- /조사 -->

            <!-- 첨부파일 -->
            <div class="search1">
                Drag and drop file here
                <kendo:upload name="files" showFileList="true" dropZone=".search1"
                              complete="onComplete" error="onError" upload="onUpload" select="onSelect" success="onSuccess">
                    <kendo:upload-async autoUpload="true" saveUrl="${chunkUrl}"
                                        concurrent="true" saveField="uploadFile" chunkSize="102400" />
                    <kendo:upload-validation maxFileSize="${maxFileSizeVar}" />
                </kendo:upload>
            </div>
            <ul class="f_list" data-template="file-template" data-bind="source: data"></ul>
        </div>

    </div>
    <%--// .layout-LW --%>

</div>

<!-- /popup_container -->

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
            <button type="button" class="button" title="삭제" data-id="#= atchmnflId #" data-bind="click: delete"><i class="w_del"></i></button>
            <a href="${downloadUrl}/#= atchmnflId #" class="button" title="다운로드"><i class="w_down"></i></a>
        </div>
    </li>
</script>

<script type="text/javascript">

    function unhighlight(x) {
        //$("#help_txt_1").html("");
        $("#help_txt_1").hide();

    }

    function highlight(x) {
        //$("#help_txt_1").html("<em>미회수의 경우, 1999.99.99 입력</em>");
        //$("#help_txt_1").show();
        $("#help_txt_1").show();
    }

    var _dicasPage = new DicasPage('${screenId}');

    <%-- Control Definition--%>
    var grid;
    var pagination;
    var net;
    <%--// Control Definition --%>

    <%-- Variable Definition --%>
    var validatable = null;
    <%--// Variable Definition --%>

    var upload;

    var codeMdl = kendo.data.Model.define({
        ID: 'ID',
        fields: {
            vinno           : { type: 'string' }
            ,manageNo        : { type: 'string' }
            ,serviceDegree   : { type: 'string' }
            ,researchDegree  : { type: 'string' }
            ,researchDate    : { type: 'string' }
            ,researchNm      : { type: 'string' }
            ,researchNmS     : { type: 'string' }
            ,researchType    : { type: 'string' }
            ,cdsdResearchYn  : { type: 'string' }
            ,cdsdCd          : { type: 'string' }
            ,officeCity      : { type: 'string' }
            ,officeNm        : { type: 'string' }
            ,officeCd        : { type: 'string' }
            ,researchCont    : { type: 'string' }
            ,researchResult  : { type: 'string' }
            ,autoinsert      : { type: 'string' }
            ,investUid       : { type: 'string' }
            ,investDate      : { type: 'string' }
        }
    });

    var codeMdl2 = kendo.data.Model.define({
        ID: 'ID',
        fields: {
            vinno               : { type: 'string' }
            ,manageNo           : { type: 'string' }
            ,serviceDegree      : { type: 'string' }
            ,resultDegree       : { type: 'string' }
            ,actionType         : { type: 'string' }
            ,callCenterApproval : { type: 'string' }
            ,repairDate         : { type: 'string' }
            ,roNo               : { type: 'string' }
            ,roConfirmDate      : { type: 'string' }
            ,roSpecialFeature   : { type: 'string' }
            ,lotNo              : { type: 'string' }
            ,hmcPartNo          : { type: 'string' }
            ,replacePartNo      : { type: 'string' }
            ,replacePartNm      : { type: 'string' }
            ,replacePartCnt     : { type: 'string' }
            ,usage              : { type: 'string' }
            ,otherMate          : { type: 'string' }
            ,recallType         : { type: 'string' }
            ,recallReqDate      : { type: 'string' }
            ,receiveDate        : { type: 'string' }
            ,qualityInfoNo      : { type: 'string' }
            ,localInfoNo        : { type: 'string' }
            ,gqnetIssueDate     : { type: 'string' }
            ,gqnetIssueNm       : { type: 'string' }
            ,waybillNo          : { type: 'string' }
            ,qirIssueYn         : { type: 'string' }
            ,fieldWorkNm        : { type: 'string' }
            ,fieldWorkDate      : { type: 'string' }
            ,fieldWorkCont      : { type: 'string' }
            ,fieldWorkResult    : { type: 'string' }
            ,fieldWorkDetail    : { type: 'string' }
            ,dnResearchResult   : { type: 'string' }
            ,dnResearchDetail   : { type: 'string' }
            ,finalResearchResult: { type: 'string' }
            ,finalResearchDetail: { type: 'string' }
            ,commentCont        : { type: 'string' }
            ,autoinsert         : { type: 'string' }
            ,manageCate2        : { type: 'string' }
            ,submission         : { type: 'string' }
            ,approval           : { type: 'string' }
            ,reject             : { type: 'string' }
            ,regUserId          : { type: 'string' }
            ,regDate            : { type: 'string' }
            ,updUserId          : { type: 'string' }
            ,updDate            : { type: 'string' }
            ,garageCd           : { type: 'string' }
            ,matDiv             : { type: 'string' }
            ,partAmt            : { type: 'string' }
            ,partMagin          : { type: 'string' }
            ,labor              : { type: 'string' }
            ,hRate              : { type: 'string' }
            ,km100InRate        : { type: 'string' }
            ,km100OutRate       : { type: 'string' }
            ,dist               : { type: 'string' }
            ,travelAmt          : { type: 'string' }
            ,taxAmt             : { type: 'string' }
            ,repairAmtTot       : { type: 'string' }
            ,partAmtTot         : { type: 'string' }
            ,etcAmtTot          : { type: 'string' }
            ,partMarginCulcu    : { type: 'string' }
            ,totalAmt           : { type: 'string' }
            ,enginNo            : { type: 'string' }
            ,removeNo           : { type: 'string' }
            ,gqnetNo            : { type: 'string' }
            ,qualityProblemNm   : { type: 'string' }
            ,files              : {type: "string"  }
            ,partVal              : {type: "string"  }
            ,laborVal              : {type: "string"  }
            ,etcVal              : {type: "string"  }
            ,totalVal              : {type: "string"  }
        }
    });

    var codeMdl3 = kendo.data.Model.define({
        ID: 'ID',
        fields: {
            vinno           : { type: 'string' }
            ,manageNo             : { type: 'string' }
            ,serviceDegree        : { type: 'string' }
            ,resultDegree         : { type: 'string' }
            ,actionType           : { type: 'string' }
            ,callCenterApproval   : { type: 'string' }
            ,repairDate           : { type: 'string' }
            ,roNo                 : { type: 'string' }
            ,roConfirmDate        : { type: 'string' }
            ,roSpecialFeature     : { type: 'string' }
            ,lotNo                : { type: 'string' }
            ,hmcPartNo            : { type: 'string' }
            ,replacePartNo        : { type: 'string' }
            ,replacePartNm        : { type: 'string' }
            ,replacePartCnt       : { type: 'string' }
            ,usage                : { type: 'string' }
            ,recallType           : { type: 'string' }
            ,recallReqDate        : { type: 'string' }
            ,receiveDate          : { type: 'string' }
            ,qirIssueYn           : { type: 'string' }
            ,autoinsert           : { type: 'string' }
            ,reprYn               : { type: 'string' }
        }
    });

    var updateFlag = false;

    var searchView = kendo.observable({
        rowKey: null,
        criteria: {
            <%--manageNo: '${manageNo}',--%>
            <%--masterId: '${masterId}',--%>
            <%--vinno: '${manageId}',--%>
            manageNo: "",
            masterId: "",
            vinno: "",
        },
        rowIndex: 0,
        data: {
            maker: null,
            model: null,
        },
        save: function() {
            //inputView1.save();

            if(updateFlag==true) {
                //이미 신청상태인지 체크
                if (submission == '1' && approval == '0' && reject == '0') {
                    alert("승인신청상태에서는 결과구분,자재구분,교환품 수정이 안됩니다.");
                    return;
                }
            }

            //조사 저장
            if(inputView1.hasChanges() ){
                inputView1Ajax();

            }else{
                //결과 저장
                if(inputView2.hasChanges() ){
                    inputView2Ajax();
                }else{
                    if(inputView4.hasChanges() ){
                        inputView4Ajax();
                    }else{
                        //그리드 저장
                        detailAjax();
                    }
                }

            }

            //특이사항 저장
            //inputView4Ajax();
        },
        save2: function () {

            var auditInfo= '${auditInfo}';
            if (auditInfo == '03') {
                var temp = grid.getRow(grid.getFocusedCell().rowKey);
                inputView5Ajax(temp);
            } else {
                alert("SD출동시에만 비용승인신청이 가능합니다.");
            }

        },
        cancel: function () {
            window.close();
        },
        search: function() {
            /*if (
                    inputView1.hasChanges() || inputView2.hasChanges() || inputView4.hasChanges()
            ) {
              if (!confirm("변경된 데이터가 있습니다. 조회 하시겠습니까?")) {
                return;
              }
            }*/
            goPage('grid1', 1);
            return false;
        },
        search2: function() {
            //alert("재조회");
            goPage('grid1', 1);
            return false;
        },
    });
    kendo.bind($("#frm_search"), searchView);

    var submission;
    var approval;
    var reject;

    function inputView5Ajax(temp) {

        //alert(JSON.stringify(inputView2.get('data2')));

        //이미 신청상태인지 체크
        if (submission == '1' && approval == '0' && reject == '0') {
            alert('이미 승인신청중입니다.');
            return;
        }

        $.ajax({
            method: "POST",
            url: '${updateUrl6}',
            data: JSON.stringify(temp),
            contentType: 'application/json;charset=UTF-8'
        }).done(function (data, status, jqXHR) {
            alert('승인요청 완료했습니다.');
            searchView.search();
            //return false;
        }).fail(function (data, status, jqXHR) {
            alert("수정 중 오류가 발생하였습니다.");
        }).always(function () {
            //_dicasPage.maskClose();
        });

    }

    var buttonView = kendo.observable({
        add: function() {

            var dataItem = new codeMdl2().toJSON();
            //grid.prependRow(dataItem, {focus: true});
            grid.appendRow(dataItem, {focus: true});

            /*
                  inputView4.set('rowKey', grid.getRowAt(0)['rowKey']);
                  inputView4.set('rowIndex', 0);

                  dataItem.manageNo = searchView.criteria.manageNo;
                  dataItem.vinno = searchView.criteria.vinno;
                  dataItem.serviceDegree = "1";
                  dataItem.resultDegree = "1";

                  inputView4.set('data', dataItem);
            */

            var gridRowkey = grid.getFocusedCell().rowKey;

            grid.setValue(gridRowkey, "vinno", searchView.criteria.vinno);
            grid.setValue(gridRowkey, "manageNo", searchView.criteria.manageNo);
            grid.setValue(gridRowkey, "serviceDegree", "1");
            //grid.setValue(gridRowkey, "resultDegree", "1");

            updateFlag = true;
            setPageUI('add');

        },
        remove: function() {
            //var gridRowkey = grid.getFocusedCell().rowKey;
            //grid.removeRow(gridRowkey);
            grid.removeRow(inputView4.get('rowKey'));
            updateFlag = true;
        },
    });
    kendo.bind($("#gridDiv"), buttonView);

    function cmbChange() {
        updateFlag = true;
    }

    var delButtonView1 = kendo.observable({
        btnGrpVisible: true,
        remove: function() {
            //조사삭제
            if(confirm("조사 내용을 삭제 하시겠습니까?")) {
                $.ajax({
                    method: "POST",
                    url: '${deleteUrl}',
                    data: JSON.stringify(inputView1.data),
                    contentType: 'application/json;charset=UTF-8'
                }).done(function (data, status, jqXHR) {
                    searchView.search2();
                }).fail(function (data, status, jqXHR) {
                    alert("삭제 중 오류가 발생하였습니다.");
                }).always(function () {
                    _dicasPage.maskClose();
                });
            }
        },
    });
    kendo.bind($("#divDelBtn1"), delButtonView1);

    var delButtonView2 = kendo.observable({
        btnGrpVisible: true,
        remove: function() {
            //결과삭제
            if(confirm("결과 내용을 삭제 하시겠습니까?")) {
                $.ajax({
                    method: "POST",
                    url: '${deleteUrl2}',
                    data: JSON.stringify(inputView2.data),
                    contentType: 'application/json;charset=UTF-8'
                }).done(function (data, status, jqXHR) {
                    searchView.search2();
                }).fail(function (data, status, jqXHR) {
                    alert("삭제 중 오류가 발생하였습니다.");
                }).always(function () {
                    _dicasPage.maskClose();
                });
            }
        },
    });
    kendo.bind($("#divDelBtn2"), delButtonView2);

    var inputView1 = kendo.observable({
        data: null,
        flag: false,
        validate: function () {
            if (validatable == null) return true;
            return validatable.validate();
        },
        hasChanges: function () {
            return this.flag;
        },
    });
    inputView1.bind('change', function (e) {
        if (e.field.indexOf('data.') > -1) {
            inputView1.set('flag', true);
        }
    });
    function getConsultingView() {
        var manageNo = searchView.criteria.manageNo;
        $.ajax(
            {
                type: 'GET',
                url: '${readUrl}',
                dataType: 'json',
                data: { page: '1', manageNo: manageNo },
                success: function (result) {
                    inputView1.set('data', result.data.contents[0]);

                    //조사삭제 활성화
                    delButtonView1.set("btnGrpVisible", true);
                    if(JSON.stringify(result.data.contents[0]) == null){
                        //조사삭제 비활성화
                        delButtonView1.set("btnGrpVisible", false);

                        var dataItem = new codeMdl().toJSON();
                        dataItem.manageNo = searchView.criteria.manageNo;
                        dataItem.vinno = searchView.criteria.vinno;
                        dataItem.serviceDegree = "1";
                        dataItem.researchDegree = "1";
                        dataItem.cdsdResearchYn = "0";
                        inputView1.set('data', dataItem);
                    }

                    getConsultingView2();
                }
            });
    }
    kendo.bind($("#form_container1"), inputView1);

    var inputView2 = kendo.observable({
        rowIndex: 0,
        rowKey: null,
        data: null,
        flag: false,
        validate: function () {
            if (validatable == null) return true;
            return validatable.validate();
        },
        hasChanges: function () {
            return this.flag;
        },
        popup1: function() {

            var auditInfo = '${auditInfo}';
            if (auditInfo != '03') {
                alert('SD출동시에만 비용계산이 가능합니다.');
                return;
            }

            if (inputView2.get('data.id') === undefined
                || inputView2.get('data.id') == null
                || inputView2.get('data.id') == ''
                || inputView1.hasChanges()
                || inputView2.hasChanges()
            ) {
                alert('저장후에 비용계산이 가능합니다.');
                return;
            }

            var that = this;
            _dicasPage.popupOpen({
                url: "${popupUrl1}",
                code: 'codeHelp',
                popupTitle: 'cost',
                width: 1000,
                height: 900,
                params:{
                    manageNo: inputView2.get('data.manageNo'),
                    vinno: inputView2.get('data.vinno')
                },
                beforeOpen: function() {
                    _dicasPage.beforeCodeHelpVal = true;
                },
                afterClose: function(info) {

                    if (info.result) {
                        //that.set('criteria.vinno', info.data.vinno);
                        //inputView3.set('data3', info.data);
                    } else {
                        //that.set('criteria.vinno', null);
                        //inputView3.set('data3', null);
                    }
                    searchView.search();

                }
            });
        },
    });
    inputView2.bind('change', function (e) {
        if (e.field.indexOf('data.') > -1) {
            var itemNm = e.field.substr(5);
            //
            // if(itemNm == "partVal" || itemNm == "laborVal" || itemNm == "etcVal") {
            //     inputView2.set('data.totalVal', Number(this.get("data.partVal")) + Number(this.get("data.laborVal")) + Number(this.get("data.etcVal")) );
            // }
            this.set('flag', true);
        }
    });

    // $("#partVal_input").on('change keyup paste', function () {
    //     var temp = $("#partVal_input").val();
    //     if(isNaN(temp) == true) {
    //         temp = 0;
    //     }
    //     $("#partVal_input").val(Math.floor(temp));
    // });
    // $("#laborVal_input").on('change keyup paste', function () {
    //     var temp = $("#laborVal_input").val();
    //     if(isNaN(temp) == true) {
    //         temp = 0;
    //     }
    //     $("#laborVal_input").val(Math.floor(temp));
    // });
    // $("#etcVal_input").on('change keyup paste', function () {
    //     var temp = $("#etcVal_input").val();
    //     if(isNaN(temp) == true) {
    //         temp = 0;
    //     }
    //     $("#etcVal_input").val(Math.floor(temp));
    // });


    function getConsultingView2() {
        var manageNo = searchView.criteria.manageNo;
        $.ajax(
            {
                type: 'GET',
                url: '${readUrl2}',
                dataType: 'json',
                data: { page: '1', manageNo: manageNo },
                success: function (result) {

                    //결과삭제 활성화
                    //delButtonView2.set("btnGrpVisible", true);

                    if(JSON.stringify(result.data.contents[0]) == null){
                        //결과삭제 비활성화
                        //delButtonView2.set("btnGrpVisible", false);

                        var dataItem = new codeMdl2().toJSON();
                        dataItem.manageNo = searchView.criteria.manageNo;
                        dataItem.vinno = searchView.criteria.vinno;
                        dataItem.serviceDegree = "1";
                        dataItem.resultDegree = "1";
                        inputView2.set('data', dataItem);
                        inputView4.set('data', dataItem);

                        //기본 1건 생성
                        $.ajax({
                            method: "POST",
                            url: '${updateUrl2}',
                            data: JSON.stringify(inputView2.get('data')),
                            contentType: 'application/json;charset=UTF-8'
                        }).done(function (data, status, jqXHR) {
                            searchView.search2();
                            var auditInfo = '${auditInfo}';
                            if (auditInfo != '03') {
                                inputView2.set('data.travelAmt', 0);
                            }
                        }).fail(function (data, status, jqXHR) {
                            //alert("수정 중 오류가 발생하였습니다.");
                        }).always(function (data, status, jqXHR) {
                            _dicasPage.maskClose();
                        });

                    } else {
                        inputView2.set('data', result.data.contents[0]);

                        submission = result.data.contents[0].submission;
                        approval = result.data.contents[0].approval;
                        reject = result.data.contents[0].reject;

                        inputView4.set('data', result.data.contents[0]);
                    }

                    var auditInfo = '${auditInfo}';
                    if (auditInfo != '03') {
                        inputView2.set('data.travelAmt', 0);
                    }
                }

            });
    }
    kendo.bind($("#form_container2"), inputView2);

    function inputView1Ajax() {

        if (!inputView1.validate()) {
            alert('필수 항목을 입력해 주십시오.');
            return;
        }

        $.ajax({
            method: "POST",
            url: '${updateUrl}',
            data: JSON.stringify(inputView1.get('data')),
            contentType: 'application/json;charset=UTF-8'
        }).done(function (data, status, jqXHR) {
            alert("조사 저장 완료")

            //결과 저장
            if(inputView2.hasChanges() ){
                inputView2Ajax();
            }else{
                if(inputView4.hasChanges() ){
                    inputView4Ajax();
                }else{
                    //그리드 저장
                    detailAjax();
                }
            }

        }).fail(function (data, status, jqXHR) {
            alert("수정 중 오류가 발생하였습니다.");
        }).always(function (data, status, jqXHR) {
            _dicasPage.maskClose();
        });
    }

    function inputView2Ajax() {

        var files = "";
        $("ul.f_list li").each(function(i,v) {
            var atchmnflId = $(v).attr('data-id');
            if (i == 0)
                files = atchmnflId;
            else
                files += "," + atchmnflId;
        });

        if (files.length > 0) {
            inputView2.set('data.files', files);
        }

        $.ajax({
            method: "POST",
            url: '${updateUrl2}',
            data: JSON.stringify(inputView2.get('data')),
            contentType: 'application/json;charset=UTF-8'
        }).done(function (data, status, jqXHR) {
            alert("결과 저장 완료");

            if(inputView4.hasChanges() ){
                inputView4Ajax();
            }else{
                //그리드 저장
                detailAjax();
            }

        }).fail(function (data, status, jqXHR) {
            alert("수정 중 오류가 발생하였습니다.");
        }).always(function (data, status, jqXHR) {
            _dicasPage.maskClose();
        });
    }

    function inputView4Ajax() {
        $.ajax({
            method: "POST",
            url: '${updateUrl4}',
            data: JSON.stringify(inputView4.get('data')),
            contentType: 'application/json;charset=UTF-8'
        }).done(function (data, status, jqXHR) {
            alert("특이사항 저장 완료");
            //그리드 저장
            detailAjax();
        }).fail(function (data, status, jqXHR) {
            alert("수정 중 오류가 발생하였습니다.");
        }).always(function () {
            _dicasPage.maskClose();
        });
    }

    function detailAjax() {
        var tranCnt = grid.getModifiedRows().deletedRows.length + grid.getModifiedRows().createdRows.length + grid.getModifiedRows().updatedRows.length;

        if (grid.getModifiedRows().deletedRows.length > 0) {

            for (var i=0; i<grid.getModifiedRows().deletedRows.length; i++) {
                $.ajax({
                    method: "POST",
                    url: '${deleteUrl3}',
                    data: JSON.stringify(grid.getModifiedRows().deletedRows[i]),
                    contentType: 'application/json;charset=UTF-8'
                }).done(function (data, status, jqXHR) {
                    //alert("그리드 삭제");
                }).fail(function (data, status, jqXHR) {
                    alert("저장 중 오류가 발생하였습니다.");
                });
                tranCnt++;
            }

        }else if (grid.getModifiedRows().createdRows.length > 0) {
            for (var i=0; i<grid.getModifiedRows().createdRows.length; i++) {

                $.ajax({
                    method: "POST",
                    url: '${createUrl3}',
                    data: JSON.stringify(grid.getModifiedRows().createdRows[i]),
                    contentType: 'application/json;charset=UTF-8'
                }).done(function (data, status, jqXHR) {
                    //alert("그리드 추가완료");
                    //searchView.criteria.manageNo = data.data.manageNo;
                }).fail(function (data, status, jqXHR) {
                    alert("저장 중 오류가 발생하였습니다.");
                });
                tranCnt++;
            }

        }else if (grid.getModifiedRows().updatedRows.length > 0) {

            for (var i=0; i<grid.getModifiedRows().updatedRows.length; i++) {

                $.ajax({
                    method: "POST",
                    url: '${updateUrl3}',
                    data: JSON.stringify(grid.getModifiedRows().updatedRows[i]),
                    contentType: 'application/json;charset=UTF-8'
                }).done(function (data, status, jqXHR) {
                    //alert("그리드 수정완료");
                }).fail(function (data, status, jqXHR) {
                    alert("저장 중 오류가 발생하였습니다.");
                });
                tranCnt++;
            }
        }

        if(tranCnt > 0 || inputView1.hasChanges() || inputView2.hasChanges() || inputView4.hasChanges()) {

            if (tranCnt > 0) {
                alert("교환품 저장완료");
            }

            searchView.search2();
            inputView1.set('flag', false);
            inputView2.set('flag', false);
            inputView4.set('flag', false);

        }else{
            alert("변경된 데이터가 없습니다.");
        }
    }

    var inputView4 = kendo.observable({
        rowIndex: 0,
        rowKey: null,
        data: null,
        flag: false,
        validate: function () {
            if (validatable == null) return true;
            return validatable.validate();
        },
        hasChanges: function () {
            return this.flag;
        },
        popup: function () {
            var that = this;
            _dicasPage.popupOpen({
                url: "${popupUrl2}",
                code: 'codeHelp',
                width: 1400,
                height: 800,
                params: {
                    maker: '${popupParam.maker}',
                    exhaustReg: '${popupParam.exhaustReg}',
                    engineType: '${popupParam.engineType}',
                    partDiv: '${popupParam.partDiv}',
                    exchangeNm: encodeURI(grid.getValue(grid.getFocusedCell().rowKey, 'replacePartNm'))
                },
                beforeOpen: function () {
                    _dicasPage.beforeCodeHelpVal = true;
                },
                afterClose: function (info) {
                    if (info.result) {
                        var _data = JSON.parse(info.data);
                        //그리드에 설정
                        var gridRowkey = grid.getFocusedCell().rowKey;
                        grid.setValue(gridRowkey, 'replacePartNm', _data.exchangeNm);
                        grid.setValue(gridRowkey, 'hmcPartNo', _data.hmc);
                        grid.setValue(gridRowkey, 'replacePartNo', _data.denso);
                        grid.setValue(gridRowkey, 'replacePartCnt', 1);

                    } else {
                        //var gridRowkey = grid.getFocusedCell().rowKey;
                        //grid.setValue(gridRowkey, 'replacePartNm', null);
                        //grid.setValue(gridRowkey, 'hmcPartNo', null);
                        //grid.setValue(gridRowkey, 'replacePartNo', null);
                    }
                }
            });
        }
    });
    inputView4.bind('change', function (e) {
        if (e.field.indexOf('data.') > -1) {
            var itemNm = e.field.substr(5);
            //grid.setValue(this.get('rowKey'), itemNm, this.get(e.field));
            this.set('flag', true);
        }
    });
    kendo.bind($("#form_container3"), inputView4);

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
                            inputView2.set('data.files', files);
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
    }

    function goPage(gridId, page) {
        if (gridId == "grid1") {
            grid.clear();
            searchView.set("rowKey", null);
            net.readData(1, searchView.criteria.toJSON(), true);
            updateFlag = false;
        }
    }

    $(document).ready(function () {

        $( ".calendar" ).datepicker();
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
            dateFormat: "yy-mm-dd",
            yearSuffix: '년'
        });

        searchView.set('criteria.manageNo', _dicasPage.getParameterByName("manageNo"));
        searchView.set('criteria.masterId', _dicasPage.getParameterByName("masterId"));
        searchView.set('criteria.vinno', _dicasPage.getParameterByName("masterId"));

        // cmbResearchNmSInput = $("#cmb_researchNmS_input", "#frm_input").data("kendoDropDownList");

        cmbResearchTypeInput = $("#cmb_researchType_input", "#frm_input").data("kendoDropDownList");

        cmbApprovalInput = $("#cmb_approval_input", "#frm_input").data("kendoDropDownList");

        cmbMatDivInput = $("#cmb_matDiv_input", "#frm_input").data("kendoDropDownList");

        cmbQualityProblemNmInput = $("#cmb_qualityProblemNm_input", "#frm_input").data("kendoDropDownList");

        validatable = $("#form_container1").kendoValidator({validateOnBlur: false})
            .data("kendoValidator");

        tui.Grid.applyTheme('clean');
        grid = new tui.Grid({
            el: $('#grid'),
            scrollX: false,
            scrollY: true,
            rowHeight: 40,
            // keyColumnName: 'codeKey',
            useClientSort: false,
            showDummyRows: true,
            minBodyHeight: 40,
            bodyHeight: 200,
            pagination: true,
            selectionUnit: 'CELL',
            editingEvent: false,
            usageStatistics: false,
            treeColumnOptions: {
                name: 'ID',
                useCascadingCheckbox: false
            },
            columns: [
                { title: 'id', name: 'id', align: 'center', hidden: true }
                ,{ title: '대표', name: 'reprYn', align: 'center', width: 20,
                    editOptions: {
                        type: 'checkbox',
                        listItems: [
                            { text: '', value: 'Y' }
                        ],
                        useViewMode: false
                    }
                    ,onAfterChange: function(ev) {

                        if (ev.value == 'Y') {
                            var cnt = grid.getRowCount();
                            for (var i=0; i<cnt; i++) {
                                var gridData = grid.getRowAt(i);
                                if (gridData.rowKey != ev.rowKey) {
                                    grid.setValue(gridData.rowKey, 'reprYn', null);
                                }
                            }
                        }
                    }
                }
                ,{ title: '결과차수', name: 'resultDegree', align: 'center', hidden: true }
                ,{ title: '교환품번', name: 'hmcPartNo', align: 'center', editOptions: { type: 'text', maxLength: 50, useViewMode: true } }
                ,{ title: '', name: 'img', align: 'center', width: 10,
                    formatter: function(value) {
                        var url = "<c:url value='../../../assets/img/grid_popup_img.png' />";
                        return '<img src="' + url + '" />';
                    }
                }
                ,{ title: '교환품명', name: 'replacePartNm', align: 'center',  editOptions: { type: 'text', maxLength: 50, useViewMode: true } }
                ,{ title: '수량', name: 'replacePartCnt', align: 'center',  editOptions: { type: 'text', maxLength: 10, useViewMode: false }
                    ,onAfterChange: function(ev) {
                        var temp = ev.value;
                        if(isNaN(temp) == true) {
                            temp = 0;
                        }
                        grid.setValue(ev.rowKey, "replacePartCnt", Math.floor(temp));
                        updateFlag = true;
                    }
                }
                //,{ title: '특이사항', name: 'roSpecialFeature', align: 'center', editOptions: { type: 'text', maxLength: 50, useViewMode: false }, hidden: true }
            ]
        });

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

        grid.use('Net', {
            //el: $('#frm_input'),
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
        grid.on('beforeRequest', function (data) {
            // For all requests
            _dicasPage.maskOpen();
        }).on('response', function (data) {
            // For all response (regardless of success or failure)
            _dicasPage.maskClose();
        }).on('successResponse', function (data) {
            if (data.requestType == 'readData') {
                /*
                inputView4.set('data', null);
                inputView4.set('rowKey', null);
                inputView4.set('rowIndex', 0);
                */
                setPageUI('view');

                getConsultingView();

            } else {
            }
        }).on('failResponse', function (data) {
        }).on('errorResponse', function (data) {
        }).on('click', function (eventData) {

            console.log(eventData);
            if (eventData.columnName == 'reprYn') {
                grid.setValue(eventData.rowKey, 'reprYn', 'Y');
            }
        }).on('dblclick', function (eventData) {

            if (eventData.columnName == 'hmcPartNo' || eventData.columnName == 'replacePartNm' || eventData.columnName == 'img') {
                //교환품일때 팝업띄우기
                inputView4.popup();
            }

        }).on('focusChange', function (eventData) {
            /*
            if (inputView4.hasChanges()) {
              var rowIndex = this.getIndexOfRow(eventData.prevRowKey);
              var columnIndex = this.getIndexOfColumn(eventData.prevColumnName);
              inputView4.set("rowIndex", rowIndex);
              this.focusAt(rowIndex, columnIndex);
              eventData.stop();
            } else {
              if (eventData.prevRowKey != eventData.rowKey) {
                var rowIndex = this.getIndexOfRow(eventData.rowKey);
                inputView4.set("rowIndex", rowIndex);
                inputView4.set("rowKey", eventData.rowKey);
                inputView4.set('data', this.getRow(eventData.rowKey));
                setPageUI('view');
              }
            }
            */
            if (eventData.prevRowKey != eventData.rowKey) {
                var rowIndex = this.getIndexOfRow(eventData.rowKey);
                inputView4.set("rowIndex", rowIndex);
                inputView4.set("rowKey", eventData.rowKey);
                //inputView4.set('data', this.getRow(eventData.rowKey));
                setPageUI('view');
            }

        });

        net = grid.getAddOn('Net');
        pagination = grid.getPagination();
        pagination.on('afterMove', function (eventData) {
            if (grid.getRowCount() > 0)
                grid.focusAt(0, 0);
        });

        goPage('grid1', 1);
        return false;
        //setPageUI("init");

    });

    //  function onchangeRoInput() {
    //
    //      var gridRowkey = grid.getFocusedCell().rowKey;
    //      var cnt = grid.getRowCount();
    //      for (var i=0; i<cnt; i++) {
    //          var gridData = grid.getRowAt(i);
    //          if (gridRowkey != gridData.rowKey) {
    //              grid.setValue(gridData.rowKey, 'roSpecialFeature', $('#roSpecialFeature_input').val());
    //          }
    //      }
    //  }

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
                inputView2.set('data.files', files);
            }

        }, 500);
    }
    $(function(){
        $("a.b1.toggle").on("click",function(e){
            e.preventDefault();
            var $that = $($(this).attr('href'));
            if($(this).hasClass("on")){
                $(this).removeClass("on");
                $that.hide();
            }else{
                $(this).addClass("on");
                $that.show();
            }
        });
    });

</script>
