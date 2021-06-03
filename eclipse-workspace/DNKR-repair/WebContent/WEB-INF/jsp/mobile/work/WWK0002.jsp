<%-- [EN] Variable definition --%>
<%-- [JP] 変数定義 --%>
<c:url var="readUrl" value="/service/search"/>

<c:url var="initUrl" value="/mobile/serviceSD/init" />
<c:url var="initServiceUrl" value="/mobile/serviceSD/init/${serviceId}/service"/>
<c:url var="initDtcUrl" value="/mobile/serviceSD/init/${serviceId}/dtc"/>
<c:url var="initConsultUrl" value="/mobile/serviceSD/init/${serviceId}/consult"/>

<c:url var="initResearchUrl" value="/mobile/serviceSD/init/${serviceId}/research"/>
<c:url var="initResultUrl" value="/mobile/serviceSD/init/${serviceId}/result"/>
<c:url var="initCostUrl" value="/mobile/serviceSD/init/${serviceId}/cost"/>

<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] 画面ID (@ViewIdで定義) --%>
<c:set var="screenId" value="<%= request.getAttribute(Globals.SCREEN_ID_KEY) %>"/>

<%--◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ #head ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆--%>
<div id="head" class="init">

	<%-- container --%>
	<div id="headerView" class="container">
		<h1>서비스 접수</h1>
		<button type="button" class="back" data-bind="click: back"><span class="blind">이전</span></button>
		<a href="#pop_option" class="b1 layer_open more"><span class="blind">옵션</span></a>
		<%-- pop_option --%>
		<div id="pop_option">
			<div class="wrap">
				<ul>
					<li><a href="${initResearchUrl}" data-page="inv" data-bind="click: optionMenu">클레임조사</a></li>
					<li><a href="${initResultUrl}" data-page="result" data-bind="click: optionMenu">클레임결과</a></li>
					<li><a href="${initCostUrl}" data-page="cost" data-bind="click: optionMenu">비용청구</a></li>
				</ul>
			</div>
		</div>
		<%--// pop_option --%>
	</div>
	<%--// container --%>

</div>
<%--// --◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ #head ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆--%>

<hr class="dpn" />

<%--◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ #cnb1 ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆--%>
<div id="cnb1" class="init">
	<ul>
		<li class="on"><a href="javascript;"><i class="ic1"></i><span class="t1">서비스접수</span></a></li>
		<li><a href="${initDtcUrl}"><i class="ic2"></i><span class="t1">현상/DTC</span></a></li>
		<li><a href="${initConsultUrl}"><i class="ic3"></i><span class="t1">상담</span></a></li>
	</ul>
</div>
<%--// ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ /#cnb1 ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆--%>

<%--◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ #body_content ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆--%>
<div id="body_content" class="body_cnb1 init">
	<%-- container --%>
	<div class="container">
		<%-- 등록 --%>
		<div class="h2search">
			<h2>차량제원</h2>
			<%--<div class="search_input">--%>
				<%--<input type="text" id="" value="" placeholder="차량 상세 검색" />--%>
				<%--<button><i class="ic_search1"></i><span class="blind">검색</span></button>--%>
			<%--</div>--%>
		</div>
		<table id="view_container1" class="bWrite">
			<col style="width:90px" />
			<col />
			<tr>
				<th>메이커</th>
				<td>
					<input type="text" disabled="disabled" class="w100" data-bind="value: data.makerNm" />
				</td>
			</tr>
			<tr>
				<th>차종</th>
				<td>
					<input type="text" disabled="disabled" class="w100" data-bind="value: data.model" />
				</td>
			</tr>
			<tr>
				<th>배기형식</th>
				<td>
					<input type="text" disabled="disabled" class="w100" data-bind="value: data.exhaustRegNm" />
				</td>
			</tr>
			<tr>
				<th>엔진명</th>
				<td>
					<input type="text" disabled="disabled" class="w100" data-bind="value: data.engineTypeNm" />
				</td>
			</tr>
			<tr>
				<th>VIN No</th>
				<td>
					<input type="text" disabled="disabled" class="w100" readonly data-bind="value: data.vinno" />
				</td>
			</tr>
			<tr>
				<th>생산일</th>
				<td>
					<input type="text" disabled="disabled" class="calendar" data-bind="value: data.prodDate" />
				</td>
			</tr>
			<tr>
				<th>판매일</th>
				<td>
					<input type="text" disabled="disabled" class="calendar" data-bind="value: data.saleDate" />
				</td>
			</tr>
		</table>

		<h2>서비스내역(접수)</h2>
		<table id="view_container2" class="bWrite">
			<col style="width:90px" />
			<col />
			<tr>
				<th>접수일</th>
				<td><input type="text" class="calendar" data-bind="value: data2.receiptDate" /></td>
			</tr>
			<tr>
				<th>주행거리</th>
				<td><input type="text" class="w100" data-bind="value: data2.mileage" /></td>
			</tr>
			<tr>
				<th>보증여부</th>
				<td>
					<input type="radio" name="warranty_input" value="0" data-bind="checked: data2.warranty" />보증
					<input type="radio" name="warranty_input" value="1" data-bind="checked: data2.warranty" />미보증
				</td>
			</tr>
			<tr>
				<th>소재지</th>
				<td>
					<input type="text" class="w100" data-bind="value: data2.officeCityNm" />
				</td>
			</tr>
			<tr>
				<th>정비소명</th>
				<td>
					<input type="text" data-bind="value: data2.officeNm" />
				</td>
			</tr>
			<tr>
				<th rowspan="2">정비사정보</th>
				<%--<td>--%>
					<%--<input type="text" class="w100" data-bind="value: data2.expatNm" />--%>
				<%--</td>--%>
				<td>
					<input type="text" class="w100" data-bind="value: data2.mechanic1Nm" />
				</td>
			</tr>
                <td>
                    <input type="text" class="w100" data-bind="value: data2.mechanic1Tel" />
                </td>
		</table>

		<%--// 등록 --%>
	</div>
	<%--// container --%>
</div>
<%--//◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ /#body_content ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆--%>

<script type="text/javascript">

    var _dicasPage = new DicasPage('${screenId}');

    <%-- Control Definition --%>
    var editor;
    <%--// Control Definition --%>

    var boardMdl = kendo.data.Model.define({
        id: "manageNo",
        fields: {
            manageNo: { type: "string" },
            vinno: { type: "string" },
            // maker: { type: "string" },
            makerNm: { type: "string" },
            model: { type: "string" },
            // exhaustReg: { type: "string" },
            exhaustRegNm: { type: "string" },
            // engineType: { type: "string" },
            engineTypeNm: { type: "string" },
            prodDate: { type: "string" },
            saleDate: { type: "string" },
        }
    });

    var boardMdl2 = kendo.data.Model.define({
        id: "manageNo",
        fields: {
            manageNo: { type: "string" },
            receiptDate: { type: "string" },
            mileage: { type: "string" },
            warranty: { type: "string" },
            // officeCity: { type: "string" },
			officeCityNm: { type: "string" },
            officeNm: { type: "string" },
            // expatNm: { type: "string" },
			mechanic1Nm: { type: "string" },
            mechanic1Tel: { type: "string" },
        }
    });

    var inputView = kendo.observable({
        data: null
    });
    kendo.bind($("#view_container1"), inputView);

    var inputView2 = kendo.observable({
        data: null
    });
    kendo.bind($("#view_container2"), inputView2);

    $(document).ready(function() {

        var data = new boardMdl({
            manageNo: "${vehicleForm.manageNo}",
            vinno: "${vehicleForm.vinno}",
            <%--maker: "${vehicleForm.maker}",--%>
            makerNm: "${vehicleForm.makerNm}",
            model: "${vehicleForm.model}",
            <%--exhaustReg: "${vehicleForm.exhaustReg}",--%>
            exhaustRegNm: "${vehicleForm.exhaustRegNm}",
            <%--engineType: "${vehicleForm.engineType}",--%>
            engineTypeNm: "${vehicleForm.engineTypeNm}",
            prodDate: "${vehicleForm.prodDate}",
            saleDate: "${vehicleForm.saleDate}"
        });
        inputView.set('data', data);

        var data2 = new boardMdl2({
            manageNo: "${serviceForm.manageNo}",
            receiptDate: "${serviceForm.receiptDate}",
            mileage: "${serviceForm.mileage}",
            warranty: "${serviceForm.warranty}",
            <%--officeCity: "${serviceForm.officeCity}",--%>
			officeCityNm: "${serviceForm.officeCityNm}",
            officeNm: "${serviceForm.officeNm}",
            <%--expatNm: "${serviceForm.expatNm}",--%>
			mechanic1Nm: "${serviceForm.mechanic1Nm}",
            mechanic1Tel: "${serviceForm.mechanic1Tel}",
        });
        inputView2.set('data2', data2);
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
