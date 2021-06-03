<%--
 * PROJECTï¼
 *
 * [KR] 
 * 
 * $Id$
 *
 * Copyright (c) 2017 DENSO CORPORATION. All rights reserved.
 *
--%>
<script type="text/javascript" >
	 
	function checkFileType(filePath) {
		var fileFormat = filePath.split(".");
		if (fileFormat.indexOf("xlsx") > -1 || fileFormat.indexOf("xls") > -1 ) {
			return true;
		} else {
			return false;
		}
	}

	function check() {
		<%//업로드한 파일 존재 여부와 파일의 확장자가 엑셀파일인지 확인%>
		var file = $("#excelFile").val();
		if (file == "" || file == null) {
			alert("파일을 선택해주세요.");
			return false;
		} else if (!checkFileType(file)) {
			alert("엑셀 파일(xls)만 업로드 가능합니다.");
			return false;
		}

		return true;
	}

	function uploadForm(){
		if(!check()) return false;
		var frm = document.excelUploadForm;
		var message = "";
		if (confirm("등록하시겠습니까?")) {
			frm.submit();
			/* var options = {
				success : function(data) {
					alert(data);
				},
				error : function(request,status,error){
					alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				},

				//beforeSubmit : loading(),
				type		: "POST",
				dataType    : 'json'
			}; 
			$("#excelUploadForm").ajaxSubmit(options); */
		}
	}

	 

</script>
 
<link rel="stylesheet" media="all" href="/css/board.css"/>


<spring:message code="label.filename" /> : <c:out value="${url }"></c:out>

  

<div class="board-write-wrap">
			<span class="top-border"></span> 
			<form action="${pageContext.request.contextPath}/design/procExcelUpload.do"  name="excelUploadForm"  id="excelUploadForm" method="POST" enctype="multipart/form-data">
			<input type="hidden" name="tabId" value="<c:out value="${tabId}"></c:out>" />
				<table class="write_01" summary="리스트">
					<caption>엑셀</caption>
					<colgroup>
						<col width="12%">
						<col width="88%">
					</colgroup>
					<tbody>
						 
						<tr>
							<th class="check">
							 	파일
							</th>
							<td>
								<input type="file" name="excelFile" id="excelFile"   style="width:300px;"/>
							
							</td>
						</tr>
						 
					</tbody>
				</table> 
				
				<div class="list-bnt writeOnly">
					 
					<button type="button" class="red" name="Register" onclick="javascript:return uploadForm();">
						<spring:message code="label.add" /> 
					</button>
					 
				</div>
			
			</form>
			
		</div> 
	
  