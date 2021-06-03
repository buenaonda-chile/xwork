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
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/design4.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/design4.js"></script>

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
					<select name="comps" id="comp">
						<option value="E1">DNKE</option>
					</select>
				</td>
			</tr>
		</tbody>
	</table>
	<div class="sssgap"></div>
	<div style="text-align: center">
	<!-- <form action=""> -->
		  <input type="file" name="img" multiple>
		  <!-- <input type="submit">
		</form> -->
		<button type="button" class="upLoad" style="right:0px">
			<span>업로드</span>
		</button>
	</div>
	
	<div class="gap"></div>
	
	<div>
		<div class="grid-parent">
			<div>
				<h3>HOST UP 정상LIST(중복DATA포함)</h3>
				<button type="button" class="xlsDown _excelBtn_" style="right:0px" data-target="normal">
					<span>엑셀</span>
				</button>		
			</div>
			<div data-ax5grid="normal-grid" data-ax5grid-config="{}" style="height: 100%;">
            </div>
        </div>
        <div class="grid-parent">
			<div>
				<h3>HOST UP ERROR LIST</h3>
				<button type="button" class="xlsDown _excelBtn_" style="right:0px" data-target="error">
					<span>엑셀</span>
				</button>		
			</div>
			<div data-ax5grid="error-grid" data-ax5grid-config="{}" style="height: 100%;">
            </div>
        </div>
	</div>
</div>