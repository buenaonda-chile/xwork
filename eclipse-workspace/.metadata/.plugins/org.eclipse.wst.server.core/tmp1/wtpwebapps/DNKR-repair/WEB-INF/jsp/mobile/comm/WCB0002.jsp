<%-- [EN] Variable definition --%>
<%-- [JP] 変数定義 --%>
<c:url var="initUrl" value="/mobile/board/${boardType}/init" />
<c:url var="downloadUrl" value="/api/file/download" />

<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] 画面ID (@ViewIdで定義) --%>
<c:set var="screenId" value="<%= request.getAttribute(Globals.SCREEN_ID_KEY) %>"/>

<%--◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ #head ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆--%>
<div id="head" class="init">
	<%-- container --%>
	<div id="headerView" class="container">
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
		<button type="button" class="back" data-bind="click: back"><span class="blind">이전</span></button>
	</div>
	<%--// container --%>
</div>
<%--// ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ #head ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆--%>

<hr class="dpn" />

<%--◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ #body_content ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆--%>
<div id="body_content" class="init">

	<%-- container --%>
	<div class="container">
		<%-- 상세보기 --%>
		<table id="view_container" class="bWrite">
			<colgroup>
				<col style="width:90px" />
				<col />
			</colgroup>
			<tbody>
				<tr>
					<th scope="row">작성자</th>
					<td>
						<input type="text" class="w100" readonly data-bind="value: data.name" />
					</td>
				</tr>
				<tr>
					<th scope="row">작성일자</th>
					<td>
						<input type="text" class="calendar" disabled="true" data-bind="value: data.createDate" />
					</td>
				</tr>
				<tr>
					<th scope="row">제목</th>
					<td>
						<input type="text" class="w100" readonly data-bind="value: data.subject" />
					</td>
				</tr>
			</tbody>
		</table>
		<div class="bbs_cotent_view"><div id="editSection"></div></div>
		<ul class="f_list" data-template="file-template" data-bind="source: data"></ul>
		<%--// 상세보기 --%>
	</div>
	<%--// container --%>

</div>
<%--// ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆ #body_content ◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆◆--%>

<script id="file-template" type="text/x-kendo-template">
	<li data-id="#= atchmnflId #">
		<span class="f_name">
			#if (ext === "doc" || ext == "docx") {#
			<img src="<c:url value="/assets/img/lib/ic16_doc.png"/>" />
			#} else if (ext == "gif") {#
			<img src="<c:url value="/assets/img/lib/ic16_gif.png"/>" />
			#} else if (ext == "hwp") {#
			<img src="<c:url value="/assets/img/lib/ic16_hwp.png"/>" />
			#} else if (ext == "jpg" || ext == 'jpeg') {#
			<img src="<c:url value="/assets/img/lib/ic16_jpg.png"/>" />
			#} else if (ext == "pdf") {#
			<img src="<c:url value="/assets/img/lib/ic16_pdf.png"/>" />
			#} else if (ext == "ppt" || ext == "pptx") {#
			<img src="<c:url value="/assets/img/lib/ic16_ppt.png"/>" />
			#} else if (ext == "txt") {#
			<img src="<c:url value="/assets/img/lib/ic16_txt.png"/>"/>
			#} else if (ext == "xls" || ext == "xlsx") {#
			<img src="<c:url value="/assets/img/lib/ic16_xls.png"/>"/>
			#} else if (ext == "zip") {#
			<img src="<c:url value="/assets/img/lib/ic16_zip.png"/>"/>
		  #} else {#
			<img src="<c:url value="/assets/img/lib/ic16_file.png"/>"/>
			#}#
			#= name #
		</span>
		<div class="f_btns">
			<a href="${downloadUrl}/#= atchmnflId #" class="button" title="다운로드"><i class="down"></i></a>
		</div>
	</li>
</script>
<script type="text/javascript">

  var _dicasPage = new DicasPage('${screenId}');

  <%-- Control Definition --%>
  var editor;
  <%--// Control Definition --%>

  var boardMdl = kendo.data.Model.define({
    id: "boardSeq",
    fields: {
      boardSeq: {
        editable: false,
        nullable: true,
      },
      boardType: {
        type: "string",
        defaultValue: "${boardForm.boardType}"
      },
      subject: {
        type: "string"
      },
      createDate : {
        type: "string"
      },
      content: {
        type: "string"
      },
      files: {
        type: "string"
      }
    }
  });

  var headerView = kendo.observable({
    back: function() {
	    document.location.href="${initUrl}"
    },
  });
  kendo.bind($("#headerView"), headerView);

  var inputView = kendo.observable({
    data: null
  });
  kendo.bind($("#view_container"), inputView);

  var fileView = kendo.observable({
    data: [],
  });
  kendo.bind($(".f_list"), fileView);

  $(document).ready(function() {
    editor = new tui.Editor({
      el: document.querySelector('#editSection'),
      height: '300px',
      viewer: true,
      initialValue: "${boardForm.content}"
    });

    var data = new boardMdl({
      boardSeq: "${boardForm.boardSeq}",
      subject: "${boardForm.subject}",
			name: "${boardForm.name}",
      createDate: "${boardForm.createDate}"
    });
    inputView.set('data', data);

    <c:if test="${fileItems != null}">
    var files = [];
    <c:forEach var="item" items="${fileItems}" varStatus="status">
    <c:if test="${item.atchmnflItem != null}">
    files.push({
      atchmnflId : "${item.atchmnflId}",
      ext: "${item.atchmnflItem.flext}",
      name: "${item.atchmnflNm}"
    });
    </c:if>
    </c:forEach>
    fileView.set('data', files);
    </c:if>

  });

</script>