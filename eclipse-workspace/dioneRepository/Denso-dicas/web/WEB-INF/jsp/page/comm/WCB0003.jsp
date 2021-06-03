<%-- [EN] Variable definition --%>
<%-- [JP] 変数定義 --%>
<c:url var="deleteUrl" value="/board/${type}/delete/${boardSeq}" />
<c:url var="downloadUrl" value="/api/file/download" />

<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] 画面ID (@ViewIdで定義) --%>
<c:set var="screenId" value="<%= request.getAttribute(Globals.SCREEN_ID_KEY) %>"/>

<div class="sub-con-wrap">
	<h2 class="subpage-tit">${pageTitle}</h2>

	<!-- 버튼들 -->
	<div class="sub-btn-group">

		<c:choose>
			<c:when test="${userStore.getEgovUserVO().getOfficeCd() != null}">
			</c:when>
			<c:otherwise>
				<button id="btn_update" class="button bc2" data-bind="click: update, visible: visible.update"><i class="w_edit"></i>수정</button>
				<button id="btn_remove" class="button" data-bind="click: remove, visible: visible.remove"><i class="w_minus"></i>삭제</button>
			</c:otherwise>
		</c:choose>
		<button id="btn_cancel" class="button" data-bind="click: cancel, visible: visible.cancel"><i class="w_cancel"></i>취소</button>
	</div>
	<!-- /버튼들 -->
</div>

<div id="form_container">
	<div class="wrap">
		<form id="frm_input" method="post" autocomplete="off">
			<fieldset>
				<input type="text" id="txt_subject_fake" autocomplete="off" style="display: none;" />
				<input type="password" id="user_pwd_fake" name="user_pwd_fake" autocomplete="off" style="display: none;">
				<table class="bWrite">
					<colgroup>
						<col style="width:100px" />
						<col />
					</colgroup>
					<tbody>
					<tr>
						<th scope="row"><label for="txt_subject_input">제목 <em class="required" title="필수항목">*</em></label></th>
						<td>
							<input type="text" id="txt_subject_input" data-bind="value: data.subject" required="true" style="width:700px" autocomplete="off" readonly/>
                            &nbsp;
                            <input type="checkbox" id="chk_noticeYn_input" value="0"
                                   data-bind="checked: data.isNotice" required disabled/><lable for="chk_noticeYn_input">공지여부</lable>
                            <input type="checkbox" id="chk_sdYn_input" value="0"
                                   data-bind="checked: data.isSd" disabled/><lable for="chk_sdYn_input">SD공개</lable>
						</td>
					</tr>
					</tbody>
				</table>
			</fieldset>
		</form>
	</div>
</div>
<div class="bbs_cotent_view"><div id="editSection"></div></div>
<ul class="f_list" data-template="file-template" data-bind="source: data"></ul>

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
			<a href="${downloadUrl}/#= atchmnflId #" class="button" title="다운로드"><i class="w_down"></i></a>
		</div>
	</li>
</script>
<script type="text/javascript">

  var _dicasPage = new DicasPage('${screenId}');

  <%-- Control Definition --%>
  var editor;
  var upload;
  <%--// Control Definition --%>

  <%-- Variable Definition --%>
  var validatable = null;
  <%--// Variable Definition --%>

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
      password: {
        type: "string"
      },
      isNotice: {
        type: "boolean",
        defaultValue: false,
      },
      isSd: {
        type: "boolean",
        defaultValue: false,
      },
      content: {
        type: "string"
      },
      files: {
        type: "string"
      }
    }
  });

  var buttonView = kendo.observable({
    visible: {
      update: true,
      remove: true,
      cancel: true,
    },
    update: function(e) {
      var updateUrl = window.location.protocol + "//"
          + window.location.host
          + window.location.pathname.replace(/view/g,"form")
          + window.location.search;
      document.location.href=updateUrl;
    },
    remove: function(e) {

      var message = "해당 자료를 삭제 하시겠습니까?";

			if (!confirm(message)) {
				return;
			}

      _dicasPage.maskOpen();
      $.ajax({
        method: "POST",
        url: '${deleteUrl}',
        data: JSON.stringify(inputView.data.toJSON()),
        contentType: 'application/json;charset=UTF-8'
      }).done(function (data, status, jqXHR) {
        alert('해당 자료를 삭제 하였습니다.');
        buttonView.cancel();
      }).fail(function (data, status, jqXHR) {
        alert("삭제 중 오류가 발생하였습니다.");
      }).always(function () {
        _dicasPage.maskClose();
      });

    },
    cancel: function(e) {
      var initUrl = window.location.protocol + "//"
          + window.location.host
          + window.location.pathname.replace(/view[/0-9]*/g,"init")
          + window.location.search;
      document.location.href = initUrl;
    }
  });
  buttonView.bind('change', function(e) {
  });
  kendo.bind($("div.sub-con-wrap"), buttonView);

  var inputView = kendo.observable({
    data: null,
  });
  kendo.bind($("#form_container"), inputView);

  var fileView = kendo.observable({
    data: [],
  });
  kendo.bind($(".f_list"), fileView);

  $(document).ready(function() {

    $("div.sub-con-wrap > h2.subpage-tit").text("${pageTitle}");

    upload = $("#files").data("kendoUpload");
    editor = new tui.Editor({
      el: document.querySelector('#editSection'),
      height: '500px',
      viewer: true,
      initialValue: "${boardForm.content}"
    });

    var data = new boardMdl({
      boardSeq: "${boardForm.boardSeq}",
      subject: "${boardForm.subject}",
      isNotice: ${boardForm.isNotice},
      isSd: ${boardForm.isSd},
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

    setTimeout(function() {
      $(window).trigger('resize');
    },100);
  });

</script>

