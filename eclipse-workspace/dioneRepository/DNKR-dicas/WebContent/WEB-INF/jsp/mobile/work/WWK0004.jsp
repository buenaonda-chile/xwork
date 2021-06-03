<%-- [EN] Variable definition --%>
<%-- [JP] 変数定義 --%>
<c:url var="readUrl" value="/mobile/serviceSD/search/${serviceId}/consult"/>

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
		<h1>상담내역</h1>
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
		<li><a href="${initServiceUrl}"><i class="ic1"></i><span class="t1">서비스접수</span></a></li>
		<li><a href="${initDtcUrl}"><i class="ic2"></i><span class="t1">현상/DTC</span></a></li>
		<li class="on"><a href="javascript:;"><i class="ic3"></i><span class="t1">상담</span></a></li>
	</ul>
</div>
<%--// ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ /#cnb1 ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆--%>

<%--◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ #body_content ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆--%>
<div id="body_content" class="body_cnb1 init">
	<%-- container --%>
	<div class="container">
		<%-- 상세보기 --%>
		<table id="view_container" class="bWrite">
			<col style="width:90px" />
			<col />
			<tr>
				<th scope="row">상담일</th>
				<td><input type="text" class="calendar" data-bind="value: data.consultingDate" /></td>
			</tr>
			<tr>
				<th scope="row">상담자</th>
				<td>
					<input type="text" class="w100" data-bind="value: data.receiveUser" />
				</td>
			</tr>
		</table>
		<%--// 상세보기 --%>

		<table id="view_container2" class="bWrite">
			<tr>
				<th scope="col">정비소 점검내용</th>
			</tr>
			<tr>
				<td>
					<textarea rows="5" cols="80" class="w100" data-bind="value: data.checkCont" ></textarea>
				</td>
			</tr>
		</table>

		<table id="view_container3" class="bWrite">
			<tr>
				<th scope="col">정비소 상담내용</th>
			</tr>
			<tr>
				<td>
					<textarea rows="5" cols="80" class="w100" data-bind="value: data.consultingCont"></textarea>
				</td>
			</tr>
		</table>
	</div>
	<%--// container --%>
</div>
<%--// ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ #body_content ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆--%>

<script type="text/javascript">

    var _dicasPage = new DicasPage('${screenId}');

    <%-- Control Definition --%>
    var editor;
    <%--// Control Definition --%>

    var boardMdl = kendo.data.Model.define({
        id: "manageNo",
        fields: {
            manageNo: { type: "string" },
            consultingDate: { type: "string" },
            consultingNm: { type: "string" },
            checkCont: { type: "string" },
            consultingCont: { type: "string" },
			receiveUser: { type: "string" }
        }
    });

    var inputView = kendo.observable({
        data: null
    });
    kendo.bind($("#view_container"), inputView);
    kendo.bind($("#view_container2"), inputView);
    kendo.bind($("#view_container3"), inputView);

    $(document).ready(function() {

        var data = new boardMdl({
            manageNo: "${consultingForm.manageNo}",
            consultingDate: "${consultingForm.consultingDate}",
            consultingNm: "${consultingForm.consultingNm}",
            checkCont: "${consultingForm.checkCont}",
            consultingCont: "${consultingForm.consultingCont}",
			receiveUser: "${consultingForm.receiveUser}"
        });
        inputView.set('data', data);
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