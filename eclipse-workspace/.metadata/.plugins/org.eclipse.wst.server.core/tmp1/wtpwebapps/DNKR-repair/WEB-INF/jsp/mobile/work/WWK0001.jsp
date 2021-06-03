<%-- [EN] Variable definition --%>
<%-- [JP] 変数定義 --%>

<c:url var="readUrl" value="/service/searchSd" />
<c:url var="viewUrl" value="/mobile/board/notice/view/" />

<c:url var="initServiceUrl" value="/mobile/serviceSD/init" />

<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] 画面ID (@ViewIdで定義) --%>
<c:set var="screenId" value="<%= request.getAttribute(Globals.SCREEN_ID_KEY) %>"/>

<%--◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ #head ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆--%>
<div id="head" class="init">

	<%-- container --%>
	<div class="container">
		<h1>클레임접수</h1>
		<button class="menu" id="tnb1_menu"><span class="blind">메뉴</span></button>
		<a href="#pop_search" class="b1 layer_open search"><span class="blind">검색</span></a>

		<%-- #pop_search [jQ] --%>
		<%--<div id="pop_search">--%>
		<form id="frm_search"  data-bind="events:{submit: submit}" >
			<div id="pop_search" class="search1">
				<select name="pop_search_option" id="pop_search_option" data-bind="value: criteria.popSearchOption">
					<option value="01" select="true">VONNO</option>
					<option value="02">접수일</option>
					<option value="03">정비소명</option>
				</select>
				<input type="text" id="searchKeyword_search" data-bind="value: criteria.searchKeyword"
					   placeholder="검색어를 입력해주세요" title="검색어"/>
				<%--<input type="text" id="" value="" class="search1" placeholder="검색어를 입력해주세요" title="검색어" />--%>
				<button type="submit" value="submit"><span class="blind">검색</span></button>
				<a href="#pop_search" class="b1 layer_close close"><span class="blind">검색</span></a>
			</div>
		</form>
		<%--// #pop_search [jQ] --%>

	</div>
	<%--// container --%>
</div>
<%--// --◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ #head ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆--%>

<hr class="dpn" />

<%--◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ #body_content ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆--%>
<div id="body_content" class="init">
	<%-- container --%>
	<div id="list_container" class="container" data-template="listTemplate" data-bind="source: data">
		<%-- 리스트 --%>
		<div class="bList">
			<span class="category"><span class="cg_wrap cgbc1"><span>상태1</span></span></span>
			<a href="${initServiceUrl}/1/service">
				<span class="tit">KMFGA17TP5C022383<i class="ic1 new">N</i></span></span>
				<span class="txt">
              접수일 : 2018-11-14
              <i class="ic_bar"></i>
              상태 : 콜대상<br />
              정비소명 : 박달점 기아오토큐
          </span>
			</a>
		</div>
		<%--// 리스트 --%>
	</div>
	<%--// container --%>
	<%--// btns --%>
	<div class="btns">
		<button id="btnMore" type="button" class="button">더보기</button>
	</div>
	<%--// btns --%>
</div>
<%--//◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ #body_content ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆--%>

<script id="listTemplate" type="text/x-kendo-template">
    <div class='bList'>

        # if ( conditionNm == '상담') {#
        <span class="category"><span class="cg_wrap cgbc1" ><span>#= conditionNm #</span></span></span>
        # } else if ( conditionNm == '접수' ) { #
        <span class="category"><span class="cg_wrap cgbc2" ><span>#= conditionNm #</span></span></span>
        # } else if ( conditionNm == '조사' ) { #
        <span class="category"><span class="cg_wrap cgbc3" ><span>#= conditionNm #</span></span></span>
        #} else {#
        <span class="category"><span class="cg_wrap cgbc4"><span>#= conditionNm #</span></span></span>
        #}#

		<a href="${initServiceUrl}/#= manageNo #/service">
			<span class="tit">
				#= vinno #
				# var date = new Date(); 					   #
				# var year = date.getFullYear(); 			   #
				# var month = new String(date.getMonth()+1);   #
				# var day = new String(date.getDate()); 	   #
				# if(month.length == 1){ 					   #
				# month = "0" + month; 						   #
				# } 										   #
				# if(day.length == 1){ 						   #
				#  day = "0" + day; 						   #
				# } 										   #
				# var today = year + "-" + month + "-" + day;  #
				# if(data.receiptDate == today){				   #
					<i class="c1 new">N</i>
				# }											   #
			</span>

			</span>
			<span class="txt">
              접수일 : #= receiptDate #
              <i class="ic_bar"></i>
              상태 : #= conditionNm #<br />
              정비소명 : # if ( officeNm != null) {# #= officeNm # #} else {# - #}#

          </span>
		</a>
	</div>
</script>

<script type="text/javascript">

    var _dicasPage = new DicasPage('${screenId}');

    var pageIndex = 1;
    var boardMdl = kendo.data.Model.define({
        id: 'manageNo',
        fields: {
            manageNo: {type: 'string'},
            rn: {type: 'string'},
            vinno: {type: 'string'},
            officeNm: {type: 'string'},
            receiptDate: {type: 'string'},
			condition: {type: 'string'}
        }
    });

    var headerView = kendo.observable({
        criteria: {
			searchKeyword: null
        },
        submit: function (e) {
            e.preventDefault();
			$("#list_container").html("");
			pageIndex = 1;
            goPage(pageIndex);
        }
    });
    kendo.bind($('#frm_search'), headerView);

    var listView = kendo.observable({
        data: [],
    });
    kendo.bind($('#list_container'), listView);

    var boardDs = new kendo.data.DataSource({
        autoSync: false,
        serverPaging: true,
        page: 1,
        pageSize: 10,
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
                	console.log(data);
                    var _data = $.extend(headerView.criteria.toJSON(), {perPage: data.pageSize, page: data.page});
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
		//boardDs.clear();
    }

    $(document).ready(function(){
        pageIndex = 1;
        goPage(1);

        $("#btnMore").click(function() {
        	pageIndex++;
            goPage(pageIndex);
        });

    });

	$("#pop_search_option").val("01").change();

</script>
