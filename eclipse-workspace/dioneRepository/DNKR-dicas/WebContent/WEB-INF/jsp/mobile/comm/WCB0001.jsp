<%-- [EN] Variable definition --%>
<%-- [JP] 変数定義 --%>
<c:url var="readUrl" value="/mobile/board/${boardType}/search" />
<c:url var="readUrl1" value="/mobile/board/${boardType}/search2" />
<c:url var="viewUrl" value="/mobile/board/${boardType}/view/" />

<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] 画面ID (@ViewIdで定義) --%>
<c:set var="screenId" value="<%= request.getAttribute(Globals.SCREEN_ID_KEY) %>"/>

<%--◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ #head ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆--%>
<div id="head" class="init">
	<%-- container --%>
	<div class="container">
		<h1>
			<c:choose>
				<c:when test="${boardType == 'notice'}">
					공지사항
				</c:when>
				<c:when test="${boardType == 'file'}">
					자료실
				</c:when>
			</c:choose>
		</h1>
		<button class="menu" id="tnb1_menu"><span class="blind">메뉴</span></button>
		<a href="#pop_search" class="b1 layer_open search"><span class="blind">검색</span></a>

		<%-- #pop_search [jQ] --%>
		<div id="pop_search">
			<form method="get" data-bind="events: {submit: submit}">
				<input type="text" id="searchKeyword_search" class="search1" data-bind="value: criteria.searchKeyword"
					   placeholder="검색어를 입력해주세요" title="검색어" />
				<button type="submit" value="submit"><span class="blind">검색</span></button>
			</form>
			<a href="#pop_search" class="b1 layer_close close"><span class="blind">검색</span></a>
		</div>
		<%--// #pop_search [jQ] --%>

	</div>
	<%--// container --%>
</div>
<%--// ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ #head ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆--%>

<hr class="dpn" />

<%--◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ #body_content ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆--%>
<div id="body_content" class="init">

	<%-- container --%>
	<div id="list_container" class="container" data-template="listTemplate" data-bind="source: data">
		<!-- bList -->
		<div class="bList">
			<a href="?">
				<span class="tit">[공지]DST-PC 활성화<i class="ic1 new">N</i></span>
				<span class="txt">
              2018-11-14 <i class="ic_bar"></i>
              백중기<br />
              설치를 진행후 첨부파일을 참조하시어 사용하세요.
          </span>
			</a>
		</div>
		<!-- /bList -->
	</div>
	<%--// container --%>
	<%--// btns --%>
	<div class="btns">
		<button id="btnMore" type="button" class="button">더보기</button>
	</div>
	<%--// btns --%>
</div>
<%--// ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ #body_content ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆--%>

<script id="listTemplate" type="text/x-kendo-template">
	<div class='bList'>
		<a href='${viewUrl}#=seq#'>
			<span class='tit'>
				#= subject #
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
				# if(data.createDate == today){				   #
					<i class="c1 new">N</i>
				# }											   #
			</span>
			<span class="txt">
				#= createDate # <i class='ic_bar'></i>
				#= name #<br />
				조회수: #= cntHit #
			</span>
		</a>
	</div>
</script>

<script type="text/javascript">

  var _dicasPage = new DicasPage('${screenId}');

	var pageIndex = 1;
	var boardMdl = kendo.data.Model.define({
		id: 'seq',
		fields: {
		  rn: {type: 'string'},
			userId: {type: 'string'},
			name: {type: 'string'},
			subject: {type: 'string'},
			cntHit: {type: 'string'},
			createDate: {type: 'string'},
			seq: {type: 'string'}
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
	kendo.bind($('#pop_search'), headerView);

	var listView = kendo.observable({
		data: [],
	});
	kendo.bind($('#list_container'), listView);

	var boardDs = new kendo.data.DataSource({
		autoSync: false,
		serverPaging: true,
		page: 1,
		pageSize: 20,
			schema: {
				type: 'json',
				total: 'data.pagination.totalCount',
				data: 'data.contents',
				model: boardMdl
			},
			transport: {
				read: {
					type: 'GET',
					url: '${readUrl1}',
					dataType: 'json',
					contentType: 'application/json'
				},
				parameterMap: function(data, type) {
					if (type == 'read') {
						var _data = $.extend({}, {perPage: data.pageSize, page: data.page});
						_data = $.extend(_data, headerView.criteria.toJSON());
						return _data;
					}
			    }
			},
			requestStart: function(e) {
				_dicasPage.maskOpen();
				$("#btnMore").addClass("button_more")
			},
			requestEnd: function(e) {
				//console.log("totPageCnt : "+e.response.data.totalPageCnt);
				//console.log("nowPageCnt : "+e.response.data.pagination.page);
				var totPageCnt = e.response.data.totalPageCnt;
				var nowPageCnt = e.response.data.pagination.page;

				_dicasPage.maskClose();
				if(totPageCnt != 0) {
					if (totPageCnt == nowPageCnt) {
						$("#btnMore").hide();
					} else {
						$("#btnMore").removeClass("button_more");
					}
				}else{
					$("#btnMore").hide();
				}
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
					  message: "게시판 처리 중 오류가 발생하였습니다."
				  });
			}
		},
		change: function(e) {
			if (e.action !== undefined) {

			} else {
				var _data = e.items.toJSON();
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
