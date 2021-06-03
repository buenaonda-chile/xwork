<%-- [EN] Variable definition --%>
<%-- [JP] 変数定義 --%>
<c:url var="readUrl" value="/mobile/serviceSD/search/${serviceId}/dtc"/>

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
		<h1>현상/DTC</h1>
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
		<li class="on"><a href="javascript:;"><i class="ic2"></i><span class="t1">현상/DTC</span></a></li>
		<li><a href="${initConsultUrl}"><i class="ic3"></i><span class="t1">상담</span></a></li>
	</ul>
</div>
<%--// ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ /#cnb1 ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆--%>

<%--◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ #body_content ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆--%>
<div id="body_content" class="body_cnb1 init">

	<%-- container --%>
	<div class="container">
		<%-- 탭 --%>
		<div class="cnb2">
			<ul class="col2">
				<li class="on"><a href="#tab_cont1" class="b1 tab"><span>현상</span></a></li>
				<li><a href="#tab_cont2" class="b1 tab"><span>DTC</span></a></li>
			</ul>
		</div>
		<%--// 탭 --%>

		<%-- 컨텐츠 1 --%>
		<div id="tab_cont1" class="tab_cont on">

			<c:forEach var="item" items="${phenomenonList}">
				<%-- bList --%>
				<div class="bList">
					<!--<a href="?">-->
					<span class="tit">대표</span>
					<span class="txt">
              			SNO ${item.serviceDegree}차수 <br />
						<!--
							상태에 따라서 컬러가 달라진다.
							stat01 : 파랑
							stat02 : 빨강
							stat03 : 초록
							stat04 : 보라
							stat05 : 검정
						-->
              		<span class="status stat01">${item.mainCategoryNm}</span><br/>${item.smallCategoryNm}</span>
					<!--</a>-->
				</div>
				<%--// bList --%>
			</c:forEach>

		</div>
		<%--// 컨텐츠 1 --%>
		<%-- 컨텐츠 2 --%>
		<div id="tab_cont2" class="tab_cont">

			<c:forEach var="item" items="${phenomenonsubList}">
				<%-- bList --%>
				<div class="bList">
					<span class="tit">${item.code}</span>
					<span class="txt">${item.explan}</span>
				</div>
				<%-- //bList --%>
			</c:forEach>

		</div>
		<%--// 컨텐츠 2 --%>

	</div>
	<%--// container --%>
</div>
<%--// ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ #body_content ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆--%>

<script type="text/javascript">

    var _dicasPage = new DicasPage('${screenId}');

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