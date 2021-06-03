<%--
 * PROJECTÃ¯Â¼Â
 *
 * [KR] 
 * 
 * $Id$
 *
 * Copyright (c) 2017 DENSO CORPORATION. All rights reserved.
 *
--%>
<!-- [EN] Contents area -->
<!-- [JP] Ã£ÂÂ³Ã£ÂÂ³Ã£ÂÂÃ£ÂÂ³Ã£ÂÂÃ£ÂÂ¨Ã£ÂÂªÃ£ÂÂ¢ -->
<%-- <spring:message code="label.filename" /> : <c:out value="${url }"></c:out> --%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/wamCommon.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/sal/OrderHostUp.js?v=1.2"></script>


<script type="text/javascript">
//첨부파일을 선택해주세요.
var LN_SELECT_FILE = "<spring:message code='WAN-I0-0012'/>";

var result = '${result }';

if(result){
	alert(result);
}

</script>

<style>
/* 2021.01.08 */
.k_cg1{padding:9px 10px 5px 15px;margin-bottom:0px;}
.k_cg1 .k_bg1{width:600px;}
.k_cg1 .k_sg1{width:calc(100% - 600px);}
.k_cg1 .k_sg1 .inlineBlock{float:left;}
.k_cg1 .k_sg2{float:Right;}
</style>

<div class="wrap">	
	<div class="k_cg1" style="text-align: center">
	<form:form action="${pageContext.request.contextPath}/WAN008OrderHostUp/procExcelUpload.do"  name="excelUploadForm"  id="excelUploadForm" method="POST" enctype="multipart/form-data">
	
		<div class="k_sg1">
			<label class="k_l1"><spring:message code='label.WAN002.comps2'/></label>
		
			<select name="getComps" id="getComps" class="getComps schLine">
			
				<option value="E1" <c:if test="${comps eq 'E1'}">selected</c:if>>마산</option>
				<option value="C1" <c:if test="${comps eq 'C1'}">selected</c:if>>창원</option>
				<option value="S1" <c:if test="${comps eq 'S1'}">selected</c:if>>화성</option>			
			
				<!--<c:if test="${fn:length(codeList) > 0}">
					<c:forEach var="codeD2Domain" items="${codeList}" varStatus="status">
						<option value="${codeD2Domain.code2}"
							<c:if test="${codeD2Domain.code2 eq empComps}">
								selected
							</c:if>
						><c:out value="${codeD2Domain.code_name}"/></option>
					</c:forEach>
				</c:if>-->
			</select>
		</div>	
		<div class="k_bg1">
			<div class="sssgap" style="height:1px;"></div>
			
			<input type="radio" name="getSelchk" class="getSelchk" style="width : 30px;" value="P6" <c:if test="${selChk eq null}">checked</c:if > <c:if test="${selChk eq 'P6'}">checked</c:if> /><spring:message code='label.WAN008.p6'/>
			<input type="radio" name="getSelchk" class="getSelchk" style="width : 30px;" value="P7" <c:if test="${selChk eq 'P7'}">checked</c:if> /><spring:message code='label.WAN008.p7'/>
			
			<input type="hidden" name="sucList" value='${sucList}' />
			<input type="hidden" name="failList" value='${failList}' />
		<!-- <form action=""> -->
			  <input type="file" name="upFile" multiple>
			  <!-- <input type="submit">
			</form> -->
			<button type="button" class="upLoad _excelUploadBtn_" style="right:0px">
				<span><spring:message code='label.WAN008.upload'/></span>
			</button>
			<br>
			
			<!-- 공장구분 라디오버튼-->
			<input type="radio" name="getHmckmcchk" class="getHmckmcchk" style="width : 30px;" value="HMC" <c:if test="${hmckmcChk eq null}">checked</c:if > 
				<c:if test="${hmckmcChk eq 'HMC'}">checked</c:if> /><spring:message code='label.WAN008.hmc'/>
			<input type="radio" name="getHmckmcchk" class="getHmckmcchk" style="width : 30px;" value="KMC" <c:if test="${hmckmcChk eq 'KMC'}">checked</c:if> />
				<spring:message code='label.WAN008.kmc'/>&nbsp;&nbsp;
			<button type="button" class="upLoad _excelRecentlyUploadBtn_" style="right:0px">
				<span><spring:message code='label.WAN008.import'/></span>
			</button>
		</div>	
	</form:form>
	</div>
	
	<div class="cb pt5">
	</div>
	
	<div>
		<div class="grid-parent" style="height: 560px;">
			<div>
				<h3>HOST UP 정상LIST(중복DATA포함)</h3>
				<button type="button" class="xlsDown _excelBtn_" style="right:0px" data-target="normal">
					<span><spring:message code='label.excelDown' /><!-- ììë¤ì´ --></span>
				</button>		
			</div>
			<div data-ax5grid="normal-grid" data-ax5grid-config="{}" style="height: 100%;">
            </div>
        </div>
        <div class="grid-parent" style="height: 560px;float:right;">
			<div>
				<h3>HOST UP ERROR LIST</h3>
				<button type="button" class="xlsDown _excelBtn_" style="right:0px" data-target="error">
					<span><spring:message code='label.excelDown' /><!-- ììë¤ì´ --></span>
				</button>
				<button type="button" class="AXButton Red _saleBtn_" style="right:0px" data-target="normal" disabled>
					<span><spring:message code='label.WAN008.DaySaleCreate'/><!-- ì¼ì¼íë§¤ ìì± --></span>
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
                    }" style="height: 250px;"></div>
	</div>
</div>