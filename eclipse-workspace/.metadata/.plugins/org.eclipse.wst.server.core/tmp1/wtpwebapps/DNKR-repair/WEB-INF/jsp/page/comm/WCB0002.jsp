<%-- [EN] Variable definition --%>
<%-- [JP] 変数定義 --%>
<c:url var="createUrl" value="/board/${type}/create" />
<c:if test="${boardSeq !=null}">
	<c:url var="updateUrl" value="/board/${type}/update/${boardSeq}" />
	<c:url var="deleteUrl" value="/board/${type}/delete/${boardSeq}" />
</c:if>

<c:url var="chunkUrl" value="/api/file/chunk"/>
<c:url var="downloadUrl" value="/api/file/download" />
<c:url var="deleteFileUrl" value="/api/file/delete"/>

<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] 画面ID (@ViewIdで定義) --%>
<c:set var="screenId" value="<%= request.getAttribute(Globals.SCREEN_ID_KEY) %>"/>

<div class="sub-con-wrap">
	<h2 class="subpage-tit">${pageTitle}</h2>

	<!-- 버튼들 -->
	<div class="sub-btn-group">
		<button id="btn_save" class="button bc2" data-bind="click: save, visible: visible.save"><i class="w_save"></i>저장</button>
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
						<col style="width:120px" />
						<col />
					</colgroup>
					<tbody>
						<tr>
							<th scope="row"><label for="txt_subject_input">제목 <em class="required" title="필수항목">*</em></label></th>
							<td>
								<input type="text" id="txt_subject_input" data-bind="value: data.subject" required="true" class="w-100" autocomplete="off" />
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="txt_boardpw_input">비밀번호 <em class="required" title="필수항목">*</em></label> </th>
							<td>
								<input type="password" id="txt_boardpw_input" data-bind="value: data.password" required="true" autocomplete="off" />
								<input type="checkbox" id="chk_noticeYn_input" value="0"
											 data-bind="checked: data.isNotice"/><lable for="chk_noticeYn_input">공지여부</lable>

								<input type="checkbox" id="chk_sdYn_input" value="0"
									   data-bind="checked: data.isSd"/><lable for="chk_sdYn_input">SD공개</lable>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="cmb_category_input">카테고리</label>
							<td>
								<kendo:dropDownList name="cmb_category_input" dataTextField="codeNm"
													dataValueField="ref2"
													data-value-primitive="true"
													data-bind="value: data.category" optionLabel="전체">
									<kendo:dataSource data="${categoryItems}"/>
								</kendo:dropDownList>
							</td>
							</th>
						</tr>
					</tbody>
				</table>
				<div id="editSection"></div>
			</fieldset>
		</form>
	</div>
</div>
<div class="search1">
	Drag and drop file here
	<kendo:upload name="files" showFileList="true" dropZone=".search1"
								complete="onComplete" error="onError" upload="onUpload" select="onSelect" success="onSuccess">
		<kendo:upload-async autoUpload="true" saveUrl="${chunkUrl}" removeUrl="${deleteFileUrl}"
												concurrent="true" saveField="uploadFile" chunkSize="102400" />
		<kendo:upload-validation maxFileSize="${maxFileSizeVar}" />
	</kendo:upload>
</div>
<ul class="f_list" data-template="file-template" data-bind="source: data"></ul>

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
		  save: false,
			cancel: true,
		},
		save: function(e) {
		  inputView.save();
		},
		cancel: function(e) {
      var initUrl = window.location.protocol + "//"
          + window.location.host
          + window.location.pathname.replace(/form[/0-9]*/g,"init")
          + window.location.search;
      document.location.href = initUrl;
		}
	});
  buttonView.bind('change', function(e) {
  });
  kendo.bind($("div.sub-con-wrap"), buttonView);

  var inputView = kendo.observable({
		data: null,
		save: function() {
		  if (!this.validate()) {
		    alert('필수 항목을 입력해 주십시오.');
		    return;
			}

		  var message = "";
		  if ("${boardSeq}".length == 0) {
		    message = "변경된 데이터가 있습니다. 등록 하시겠습니까?";
      } else {
        message = "변경된 데이터가 있습니다. 수정 하시겠습니까?";
      }

      if (this.hasChanges()) {
        if (!confirm(message)) {
          return;
        }

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

        boardDs.sync();
      }
		},
		validate: function() {
		  if (validatable == null) return true;
		  else
		    return validatable.validate();
		},
		hasChanges: function() {
		  return boardDs.hasChanges();
    }
	});
  inputView.bind('change', function (e) {
  });
  kendo.bind($("#form_container"), inputView);

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

  var boardDs = new kendo.data.DataSource({
		autoSync: false,
		schema: {
		  type: 'json',
			data: 'data',
			model: boardMdl
		},
		transport: {

		  <c:choose>
				<c:when test="${boardSeq != null}">
			update: {
			  type: 'POST',
				url: '${updateUrl}',
				dataType: 'json',
				contentType: 'application/json'
      },
			destory: {
			  type: 'POST',
				url: '${deleteUrl}',
				dataType: 'json',
				contentType: 'application/json'
      },
				</c:when>
				<c:otherwise>
			create: {
			  type: 'POST',
				url: '${createUrl}',
				dataType: 'json',
				contentType: 'application/json'
      },
				</c:otherwise>
			</c:choose>
			parameterMap: function(data, type) {
			  return JSON.stringify(data);
      }
		},
		requestStart: function(e) {
      _dicasPage.maskOpen();
    },
		requestEnd: function(e) {
      var response = e.response;
      var type = e.type;

      _dicasPage.maskClose();

      if (type == 'create' || type == 'update') {
        var viewUrl = window.location.protocol + "//"
            + window.location.host
            + window.location.pathname.replace(/form[/0-9]*/g,"view/" + response.data.boardSeq)
            + window.location.search
        document.location.href=viewUrl;
      }
    },
		error: function(e) {
      try {
        alert(e.xhr.responseJSON.message);
      } catch (e) {
        alert('처리 중 오류가 발생하였습니다.');
      }
    },
		change: function(e) {
		  if (this.hasChanges()) {
		    buttonView.set('visible.save', true);
        buttonView.set('visible.cancel', true);
      }
      if (inputView.get('data.boardSeq') != null) {
        buttonView.set('visible.remove', true);
      }
    }
	});

  $(document).ready(function() {

    cmbCategoryInput = $("#cmb_category_input", "#frm_input").data("kendoDropDownList");
    var categoryData = cmbCategoryInput.dataSource.data(), categoryItems = _dicasPage.getEditOptions(categoryData);

    $("div.sub-con-wrap > h2.subpage-tit").text("${pageTitle}");

    upload = $("#files").data("kendoUpload");
    editor = new tui.Editor({
      el: document.querySelector('#editSection'),
      height: '500px',
      initialEditType: 'wysiwyg',
      hideModeSwitch: true,
      events: {
        change: function(e) {
          inputView.set('data.content', editor.getHtml());
				}
			}
		});

    validatable = $("#form_container").kendoValidator({validateOnBlur: false})
										.data("kendoValidator");
    //카테고리 뷰설정
    <c:if test="${type == 'notice'}">
        $("#cmb_category_input").kendoDropDownList({
            enable: false
        });
    </c:if>

		<c:choose>
			<c:when test="${boardSeq == null}">
    var data = new boardMdl();
    boardDs.insert(0, data);
			</c:when>
			<c:otherwise>
		var data = boardDs.add({
			boardSeq: "${boardForm.boardSeq}",
			subject: "${boardForm.subject}",
			isNotice: ${boardForm.isNotice},
			isSd: ${boardForm.isSd},
			content: "${boardForm.content}",
			boardType: "${boardForm.boardType}",
            category: "${boardForm.category}"

		});
			</c:otherwise>
		</c:choose>
    inputView.set('data', data);
    editor.setValue(data.content);

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

    setTimeout(function() {
      $(window).trigger('resize');
    },100);
  });

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

</script>
