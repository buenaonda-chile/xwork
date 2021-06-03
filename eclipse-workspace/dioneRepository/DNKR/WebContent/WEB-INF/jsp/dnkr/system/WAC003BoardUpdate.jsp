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

<link rel="stylesheet" media="all" href="/css/board.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/WAC001Board.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/WAC004BoardCreate.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/assets/lib/nhn_se2/js/HuskyEZCreator.js" charset="utf-8"></script>
<style>
.input_tr input, .update_tr input, .form-group input {
	height: 17px;
}

.list-top {
	overflow: visible;
}

[data-ax5autocomplete] {
	display: inline-block;
	width: 150px;
	vertical-align: bottom;
}

.form-control {
	height: 30px;
	padding: 3px 12px;
}

.ax5autocomplete-display .ax5autocomplete-display-table 
[data-ax5autocomplete-display="label"]{
	padding: 0;
}

.board-write-wrap table th {
    min-width: 110px;
}

.fileSpan {
	display: inline-block;
	margin: 5px;
}
</style>

<div class="board-write-wrap">
	<span class="top-border"></span>
	<form:form action="${pageContext.request.contextPath}/WAC003BoardUpdate/update.do" modelAttribute="WAC004BoardCreateForm" name="WAC004BoardCreateForm" method="POST"  enctype="multipart/form-data">
		<input type="hidden" name="tabId" value="<c:out value="${tabId}"></c:out>" />
		<input type="hidden" name="boardId" value="<c:out value="${boardTextDomain.boardId}"></c:out>" />
		<input type="hidden" name="idx" value="<c:out value="${boardTextDomain.idx}"></c:out>" />
		<form:hidden style="width:100px;" cssClass="form-control" id="noticeYn" path="noticeYn"/>
		<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%--조회권한 --%>
		<table class="write_01" summary="각 해당하는 항목에 알맞게 내용을 수정해주세요">
			<caption>내용 수정폼</caption>
			<colgroup>
				<col width="12%">
				<col width="88%">
			</colgroup>
			<tbody> 
				<tr>
					<th class="check"><spring:message code="label.WAC004.writer" /><!-- ìì±ì --></th>
					<td>
						<form:hidden style="width:150px;" cssClass="form-control input-xs required inlineBlock" id="writer" path="writer" maxlength="50" cssErrorClass="form-control input-xs bg_error" required="true" value="${boardTextDomain.writer }" autofocus="true" />
						${boardTextDomain.writer }
					</td>
				</tr>
				<c:if test="${userId eq '' || userId eq null || infoDomain.secretUse eq 'Y' }">
					<tr>
						<th class="tdl"><span class="necessary">* </span>비밀번호</th>
						<td>
							<form:input style="width:150px;" cssClass="form-control input-xs required inlineBlock" type="password" id="pwd" path="pwd" maxlength="20" cssErrorClass="form-control input-xs bg_error" required="true" autofocus="true" />
							<%-- <c:if test="${infoDomain.secretUse eq 'Y'}">
								<form:hidden style="width:100px;" cssClass="form-control" id="secretYn" path="secretYn" value="${boardTextDomain.secretYn }" />
								<input type="checkbox" value="Y" id="secretYnChk" class="input_radio" ${boardTextDomain.secretYn eq 'Y' ? 'checked' : '' } >
								<label for="Tnotice">비밀글</label>
							</c:if> --%>
		               </td>
					</tr>
				</c:if>
				<tr>
					<th class="tbl"><spring:message code="label.WAC004.category" /><!-- 카테고리 --></th>
					<td>
						<select name="category" title="카테고리를 선택해주세요">
							<c:forEach var="data" items="${categoryList}" varStatus="status">
								<option value="${data.cmcCode }" <c:if test="${boardTextDomain.category eq data.cmcCode }">selected</c:if> >${data.cnmName }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<th class="tbl"><spring:message code="label.circulation" />_<spring:message code="label.WAG001.teamSelect" /><!-- íëì íë³ì í --></th>
					<td>
					<ul>
						<div class="inlineBlock">	
							<button type="button" onclick="" class="AXButton Normal _circulatorBtn_Team">
								<spring:message code="label.circulation" /><!-- 회람자 -->
								<spring:message code="label.select" /><!-- 선택 -->
							</button>
							<div class="inlineBlock" id="circulationAddBtn_Team">
								<c:if test="${boardTextDomain.circulation_Id_Team ne null}">
									<button type="button" onclick="all_delete(1);" class="AXButton Normal">
										전체삭제 
									</button>
								</c:if>
							</div>
						</div>
						<div class="inlineBlock" id="circulationIdTxt_Team">
							<c:forEach var="cir" items="${circulation_Team}" varStatus="status">
								<a href='#' id='del_circulation_Team${status.index }' data-target="" name="${circulation_Team[status.index] }">
									<span>
										${fn:split(circulation_Team[status.index],'/')[0] }
									</span>
									<i class="axi axi-cancel" onclick='del_circulation(${status.index},1);'></i>
								</a>
							</c:forEach>
            			</div>
            				<input type="hidden" id="circulation_num_Team" name="circulation_num_Team" value="${fn:length(circulation_Team) }">
						<div class="inlineBlock" id="circulationEmpId_Team">
							<input type="hidden" id="circulation_Id_Team" name="circulation_Id_Team" value="${boardTextDomain.circulation_Id_Team }">
            			</div>
					</td>
					</ul>
					
				</tr>
				<tr>
					<th class="tbl"><spring:message code="label.circulation" />_<spring:message code="label.WAG001.individualSelect" /><!-- íëì ê°ì¸ë³ì í --></th>
					<td>
						<div class="inlineBlock">	
							<button type="button" onclick="" class="AXButton Normal _circulatorBtn_">
								<spring:message code="label.circulation" /><!-- 회람자 -->
								<spring:message code="label.select" /><!-- 선택 -->
							</button>
							<div class="inlineBlock" id="circulationAddBtn">
								<c:if test="${boardTextDomain.circulation_Id ne null}">
									<button type="button" onclick="all_delete(2);" class="AXButton Normal">
										전체삭제
									</button>
								</c:if>
							</div>
						</div>
						<div class="inlineBlock" id="circulationIdTxt">
							<c:forEach var="cir" items="${circulation}" varStatus="status">
								<a href='#' id='del_circulation${status.index }' data-target="" name="${circulation[status.index] }">
									<span>
										${fn:split(circulation[status.index],'/')[0] }
									</span>
									<i class="axi axi-cancel" onclick='del_circulation(${status.index},2);'></i>
								</a>
							</c:forEach>
            			</div>
            				<input type="hidden" id="circulation_num" name="circulation_num" value="${fn:length(circulation) }">
						<div class="inlineBlock" id="circulationEmpId">
							<input type="hidden" id="circulation_Id" name="circulation_Id" value="${boardTextDomain.circulation_Id }">
            			</div>
					</td>
				</tr>
				<tr>
					<th class="tbl"><spring:message code="label.WAC004.datecreated" /><!-- 작성일 --></th>
					<td>${boardTextDomain.regiDtm }</td>
				</tr>
				<tr>
					<th class="tdl"><span class="necessary">* </span><spring:message code="label.WAC004.title" /><!-- 제목 --></th>
					<td>
						<form:input style="width:400px;" value="${boardTextDomain.title }" cssClass="form-control input-xs required inlineBlock" type="text" id="title" path="title" maxlength="200" cssErrorClass="form-control input-xs bg_error" required="true" autofocus="true" />
						<%--
						<span>
							<input type="checkbox" value="Y" id="noticeYnChk" class="input_radio" ${boardTextDomain.noticeYn eq 'Y' ? 'checked' : '' } >
							<label for="Tnotice">게시판 상단 고정</label> 
						</span>
						--%>
					</td>
				 </tr>
				 <tr>
					<th class="tdl"><span class="necessary">* </span><spring:message code="label.WAC004.content" /><!-- 내용 --></th>
					<td>
						<form:textarea style="height:180px;" cssClass="form-control input-xs required inlineBlock" id="cnts" path="cnts" cssErrorClass="form-control input-xs bg_error" required="true" autofocus="true" ></form:textarea>
						<input type="hidden" name="cntsTmp" id="cntsTmp" value="<c:out value='${boardTextDomain.cnts }'/>" />
						<script type="text/javascript">
						var obj = [];              
					    //스마트에디터 프레임생성
					    nhn.husky.EZCreator.createInIFrame({
					        oAppRef: obj,
					        elPlaceHolder: "cnts",
					        sSkinURI: "../js/lib/assets/lib/nhn_se2/SmartEditor2Skin.html",
					        htParams : {
					            // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
					            bUseToolbar : true,            
					            // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
					            bUseVerticalResizer : true,    
					            // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
					            bUseModeChanger : false,
					        },
					        fCreator: "createSEditor2"
					    });
						</script>
					</td>
				 </tr>
			     <tr>
					<th class="pd_no"><spring:message code="label.WAC004.attachments" /><!-- 파일첨부 --></th>
					<td id="fileTd">
						<input type="hidden" name="fileNum" id="fileNum" value="${infoDomain.fileNum }" />
						<c:forEach var="file" items="${fileList}" varStatus="status">
							<span class="fileSpan">
								<a href="#" onclick="downFile('${file.fidx}','${file.idx }')"><img src="/img/board/file_icon.png" alt="첨부파일">${file.realName }</a>&nbsp;&nbsp;
								<a href="#n" onclick="delFile(this, '${file.fidx}');" style="text-decoration-line: underline;color: crimson;"><spring:message code="label.delete" /><!-- 삭제 --></a>
							</span>
						</c:forEach>
						
						<c:forEach var="cnt" begin="${fn:length(fileList) }" end="${infoDomain.fileNum -1 }">
							<input type="file" class="input_text" name="upfile${cnt }" style="width:70%;height:25px;border:1px solid #ddd;margin-right:10px;" title="첨부하실 파일을 선택해주세요">
			     		</c:forEach>
					</td>
				</tr>
			</tbody>
		</table> 
		</c:if>
		<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '0' }"><%--조회권한 --%>
			<spring:message code='DNKR-E2-0000'/><!-- 권한이 없습니다. -->
		</c:if>
		<div class="list-bnt writeOnly">
			<c:if test="${fn:substring(authBinaryNum, 1, 2) eq '1' }"><%--수정권한 --%>
				<button type="submit" class="red" name="Register" onclick="return boardCheck();">
					<spring:message code="label.modify" /><!-- 수정 -->
				</button>
			</c:if>
			<button type="button" onclick="javascript:location.href='${pageContext.request.contextPath}/WAC001BoardSearch/init.do?tabId=<c:out value="${tabId}"></c:out>&boardId=<c:out value="${boardTextDomain.boardId }"></c:out>'" class="gray" name="Cancel">
				<spring:message code="label.cancel" /><!-- 취소 -->
			</button>
		</div>
	</form:form>
	<div id="bottomDiv" style="padding:300px"></div>
</div><!--board-write-wrap-->