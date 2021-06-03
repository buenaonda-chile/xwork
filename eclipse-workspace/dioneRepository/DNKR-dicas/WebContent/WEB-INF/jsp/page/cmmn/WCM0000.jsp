<%-- [EN] Variable definition --%>
<%-- [JP] 変数定義 --%>

<c:url var="readUrl" value="/api/file/search"/>
<c:url var="uploadUrl" value="/api/file/upload"/>
<c:url var="chunkUrl" value="/api/file/chunk"/>
<c:url var="deleteUrl" value="/api/file/delete"/>
<c:url var="deleteAllUrl" value="/api/file/deleteAll"/>

<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] 画面ID (@ViewIdで定義) --%>
<c:set var="screenId" value="<%= request.getAttribute(Globals.SCREEN_ID_KEY) %>"/>

<div id="editSection"></div>
<div class="search1">
	Drag and drop file here
	<kendo:upload name="files" complete="onComplete" error="onError" upload="onUpload" showFileList="true" select="onSelect" success="onSuccess" remove="onRemove" dropZone=".search1">
		<kendo:upload-async autoUpload="true" saveUrl="${chunkUrl}" removeUrl="${deleteUrl}"
												concurrent="true" saveField="customSaveField" chunkSize="102400" />
		<kendo:upload-validation maxFileSize="4194304"  />
	</kendo:upload>
</div>

<script type="text/javascript">

  var _dicasPage = new DicasPage('${screenId}');
	var upload;

	$(document).ready(function() {
		upload = $("#files").data("kendoUpload");

    $('#editSection').tuiEditor({
      initialEditType: 'markdown',
      previewStyle: 'vertical',
      height: '500px'
    });
	});

  function onSelect(e) {
		var selected = e.files;
		var filesInList = upload.getFiles();

		for (var i = 0; i < selected.length; i++) {

			var filename = selected[i].name;

			if (filesInList.length > 0) {
			  console.log(filesInList);
				// filesInList.each(function (i, v) {
				// 	console.log(v);
				// 	// console.log($(this).text(), filename, $(this).text() === filenam);
				// 	// if ($(this).text() === filename) {
				// 	// 	e.preventDefault();
				// 	// }
				// });
			}
		}

		setTimeout(function() {
			$(window).trigger('resize');
		},100);
	}

	function onRemove(e) {
	}

	function onSuccess(e)
	{
	  console.log("sucess", e);
	}

  function onComplete(e) {
    console.log("complete", e);
  	var files = upload.getFiles();

		console.log(files);
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