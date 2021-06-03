<%--
 * PROJECT：
 *
 * [KR] 뉴디오네 예외부서코드 관리
 * 
 * $Id$
 *
 * Copyright (c) 2017 DENSO CORPORATION. All rights reserved.
 *
--%>
<!-- [EN] Contents area -->
<!-- [JP] コンテンツエリア -->
<%-- <spring:message code="label.filename" /> : <c:out value="${url }"></c:out> --%>
<jsp:useBean id="today" class="java.util.Date" />

<link rel="stylesheet" media="all" href="/css/content.css?ver" />

<link rel="stylesheet" media="all" href="/css/board.css">
<!-- <link type="text/css" href="/css/commonGrid.css" rel="stylesheet"> -->
<style>
[data-ax5grid-container="root"] [data-ax5grid-panel-scroll="body"] table tr>td:FIRST-CHILD
	{
	cursor: text;
	box-shadow: inset 0 0 0 0 transparent;
	background-color: transparent;
	border-radius: inherit;
	border-bottom: 1px solid #ccc !important;
	border-right: 1px solid #ccc !important;
}


.menu_wrap {
    width: 1100px;
    overflow-x: auto;
}

.menuGrid {
 	min-height: 250px;
}

.gridContents {
	width: 100%;
}

.grid-block {
	width : 350px;
	min-width:350px; 
	display:inline-block; 
	margin:0 5px
}

.gridBtn {
	height:22px;
	line-height: 14px;
}

[data-ax5grid] [data-ax5grid-container="root"] 
[data-ax5grid-container="body"] [data-ax5grid-panel] 
table tr td [data-ax5grid-cellHolder] {
	padding: 2px 5px;
}

.sc_tit {
    color: #555;
    font-weight: bold;
    width: 110px;
    font-size: 16px;
    text-align: center;
    margin: 0 auto 10px;
}

.sc_tit .btLine {
    display: block;
    height: 4px;
    background: url(/img/btl_bg.jpg) repeat-y -7px center #c1393b;
    border-radius: 20px;
    margin-top: 4px;
}

.menu_wrap .gridBtnBlock {
	height: 68px;
}

.board-write-wrap {
	width: 1080px;
    margin-left: 5px;
}

.menu_wrap .board-write-wrap table th, .menu_wrap .board-write-wrap table td {
	padding: 5px 20px;
}

.menu_wrap .board-write-wrap table th .necessary {
	margin-left: -10px;
}

.menu_wrap .board-write-wrap tr {
    height: 47px;
}
.grid-cell-red{
	background: #f8d2cb;
}
.grid-cell-blue{
	background: #dcf0f8;
}

</style>
<script type="text/javascript" src="https://cdn.rawgit.com/ax5ui/ax5ui-binder/master/dist/ax5binder.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/WAD013ExceptionCodeMng.js"></script>
<!-- [EN] Contents area -->
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }">
	<%--조회권한 --%>
	<form:form name="binder-form" >
		<div class="searchCondition">
			<div class="sssgap"></div>
			<div class="list-top text-right">
				<strong class="pr5"><spring:message code='label.type'/><%-- 공장 --%></strong>
				 <select class="pCodeType" autofocus="true" name="pCodeType"  id="pCodeType"  style="width:99.2px" title="<spring:message code='DNKR-I0-0001'/>" onchange="commonClear()">
					<option value="A" 
								<c:if test="${paraDomain.pCodeType eq 'A'}">
									selected
								</c:if>
							>부서코드</option>
					<option value="B"
								<c:if test="${paraDomain.pCodeType ne 'A'}">
									selected
								</c:if>
							>기타코드</option>
				</select>
				
				<button class="blue btn-st02 _searchBtn_" type="button" id="searchBtn">
					<span><spring:message code="label.search"/><!-- 조회 --></span>
				</button>
				<button class="gray btn-st02 addBtn" type="button" id="registerBtn">
					<span><spring:message code="label.register"/><!-- 추가 --></span>
				</button>
				<button class="red btn-st02 delBtn" type="button" id="deleteBtn">
					<span><spring:message code="label.delete"/><!-- 삭제 --></span>
				</button>
				<button class="black btn-st02 saveBtn" type="button" id="saveBtn" >
					<span><spring:message code="label.save"/><!-- 저장 --></span>
				</button>
				<%-- <button class="orange btn-st02 printBtn" type="button" id="printBtn">
					<span><spring:message code="label.print"/><!--출력 --></span>
				</button> --%>
				<button class="green btn-st02 exel fr" type="button" id="excelBtn" style="margin-left:4px;">
					<span><spring:message code="label.excelBtn" /><!-- 엑셀 --></span>
				</button>
			</div>		
			
			
			<!--cont-->
			<div class="fl total">
				<strong>Total : <span class="total">0</span></strong>
			</div>
			
			<div class="sssgap"></div>
						<table>
				<tr>
					<td style="width:900px;"><strong>예외 <span class="codeTypeNm">부서코드</span></strong>
						<div style="position: relative; height: 600px; width:950px;" id="grid-parent" name="grid-parent">
							<div data-ax5grid="unit-grid"
								data-ax5grid-config="{
							                    showLineNumber: true,
							                    lineNumberColumnWidth: 40}"
								style="height: 100%;"></div>
						</div>
					</td>
					<td>
<div class="menu_wrap">
<div class="board-write-wrap">	
				<span class="top-border" style="width:700px"></span> 
				<table class="write_01" summary="각 해당하는 항목에 알맞게 내용을 입력해주세요" style="width:700px">
					<caption>내용 입력폼</caption>
					<colgroup>
						<col width="22%">
						<col width="78%">
					</colgroup>
					<tbody>
						<tr >
							<th class="check">
								<span class="necessary">* </span>
								<label for="codeType">
									예외구분
									<%-- <spring:message code="label.WAB002.empNumber" /> --%>
								</label>
							</th>
							<td>
								<select class="codeType" id="codeType" name=codeType  style="width:99.2px"  data-ax-path="codeType" onchange="gridReload(this)">
									<option value="">--없음--</option>
									<option value="A">부서코드 </option> 
									<option value="B">기타코드</option> 
								</select>
							</td>
						</tr>
						<tr>
							<th class="check">
								<label for="clsCode">
									사업장코드
									<%-- <spring:message code="label.WAB002.empNumber" /> --%>
								</label>
							</th>
							<td>	
								<select class="clsCode" autofocus="true" name="clsCode"  id="clsCode"  style="width:99.2px"  data-ax-path="clsCode" onchange="gridReload(this)">
									<option value="">--없음--</option>
									<option value="CLS000001">구DNKA</option>
									<option value="CLS000002">구DNKE</option>
									<option value="CLS000003">구DIKR</option>
								</select>
							</td>
						</tr>
						<tr>
							<th class="check">
								사업부코드
								<%-- <spring:message code="label.WAB002.empAvailability" /> --%><!-- 사원 사용여부 -->
							</th>
							<td>
							<select class="locCode" autofocus="true" name="locCode"  id="locCode"  style="width:99.2px" data-ax-path="locCode" onchange="gridReload(this)">
								<c:if test="${fn:length(locList) > 0}">
									<option value="">--없음--</option>
									<c:forEach var="locDomain" items="${locList}" varStatus="status">
										<option value="${locDomain.relationCode}"><c:out value="${locDomain.relationName}"/></option>
									</c:forEach>
								</c:if>
							</select>
							</td>
						</tr>
						<tr>
							<th class="check">
							<span class="necessary">* </span>
								부서코드
								<%-- <spring:message code="label.WAB002.empAvailability" /> --%><!-- 사원 사용여부 -->
							</th>
							<td>
								<input class="AXInput code" style="width: 99.2px;" type="text"
								id="code" name="code" maxlength="10" data-ax-path="code" onchange="gridReload(this)"/>
								<input class="AXInput codeName" style="width:50%" type="text" id="codeName" name="codeName" data-ax-path="codeName" readonly="true"/>
								
							    <button type="button" onclick="" class="AXButton Normal _deptBtn_" name="deptBtn" id='deptBtn'>
									<spring:message code="label.deptName" /><!-- 부서 -->
									<spring:message code="label.select" /><!-- 선택 -->
								</button>
							</td>
						</tr>
						<tr>
							<th class="check">
								비고
								<%-- <spring:message code="label.WAB002.empAvailability" /> --%><!-- 사원 사용여부 -->
							</th>
							<td>
								<input class="AXInput etc" style="width: 50%;" type="text"
								id="etc" name="etc" placeholder="비고를 입력해주세요" title="비고를 입력해주세요"  maxlength="50" data-ax-path="etc" onchange="gridReload(this)">
							</td>
						</tr>
						<tr>
							<th class="check">
								타시스템 사용여부
								<%-- <spring:message code="label.WAB002.empAvailability" /> --%><!-- 사원 사용여부 -->
							</th>
							<td>
								<select class="form-control" style="width: 50%;" id="useTf" name=useTf style="width:99.2px" data-ax-path="useTf" onchange="gridReload(this)">
									<option value="Y">사용 </option> 
									<option value="N">미사용</option> 
								</select>
														
														
							</td>
						</tr>
				</tbody>
				</table> 
</div>
</div>
					</td>
				</tr>

			</table>
			
		</div>
		<!--WAE001_wrap-->
	</form:form>

</c:if>
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '0' }">
	<%--조회권한 --%>
	<div>
		<span><spring:message code='DNKR-E2-0000' /> <!-- 권한이 없습니다. --></span>
	</div>
</c:if>