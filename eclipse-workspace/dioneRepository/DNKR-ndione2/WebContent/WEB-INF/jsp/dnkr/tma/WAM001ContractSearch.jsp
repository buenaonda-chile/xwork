<%--
 * PROJECT：
 *
 * [KR] 
 * 
 * $Id$
 *
 * Copyright (c) 2017 DENSO CORPORATION. All rights reserved.
 *
--%>
<!-- [EN] Contents area -->
<!-- [JP] コンテンツエリア -->
<%-- <spring:message code="label.filename" /> : <c:out value="${url }"></c:out> --%>
<!-- 수주업로드 -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/wamCommon.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/wam/WAM001Contract.js"></script>


<script type="text/javascript">
var result = '${result }';

if(result){
	alert(result);
}
</script>
<div class="wrap">
	<table class="pd-s-table">
		<colgroup>
			<col/>
			<col/>
			<col/>
			<col/>
		</colgroup>
		<tbody>
			<tr>
				<th>
					사업부
				</th>
				<td>
					<select autofocus="true" name="comps" id="comp">
						<option value="E1">DNKE</option>
					</select>
				</td>
			</tr>
		</tbody>
	</table>
	<div class="sssgap"></div>
	<div style="text-align: center">
	<form:form action="${pageContext.request.contextPath}/WAM001Contract/procExcelUpload.do"  name="excelUploadForm"  id="excelUploadForm" method="POST" enctype="multipart/form-data">
		<input type="hidden" name="titleList" value='${titleList }' />
		<input type="hidden" name="sucList" value='${sucList }' />
		<input type="hidden" name="failList" value='${failList }' />
	<!-- <form action=""> -->
		  <input type="file" name="upFile" multiple>
		  <!-- <input type="submit">
		</form> -->
		<button type="button" class="upLoad _excelUploadBtn_" style="right:0px">
			<span>업로드</span>
		</button>
	</form:form>
	</div>
	
	<div class="gap"></div>
	
	<div>
		<div class="grid-parent">
			<div>
				<h3>HOST UP 정상LIST(중복DATA포함)</h3>
				<button type="button" class="xlsDown _excelBtn_" style="right:0px" data-target="normal">
					<span><spring:message code='label.excelDown' /><!-- 엑셀다운 --></span>
				</button>		
			</div>
			<div data-ax5grid="normal-grid" data-ax5grid-config="{}" style="height: 100%;">
            </div>
        </div>
        <div class="grid-parent">
			<div>
				<h3>HOST UP ERROR LIST</h3>
				<button type="button" class="xlsDown _excelBtn_" style="right:0px" data-target="error">
					<span><spring:message code='label.excelDown' /><!-- 엑셀다운 --></span>
				</button>		
				<button type="button" class="_test_" style="right:0px" data-target="normal">
					<span>테스트</span>
				</button>
			</div>
			<div data-ax5grid="error-grid" data-ax5grid-config="{}" style="height: 100%;">
            </div>
        </div>
        <div data-ax5grid="first-grid" data-ax5grid-config="{
                    showLineNumber: true,
                    showRowSelector: true,
                    sortable: true,
                    header: {align:"center"}
                    }" style="height: 500px;"></div>
	</div>
</div>