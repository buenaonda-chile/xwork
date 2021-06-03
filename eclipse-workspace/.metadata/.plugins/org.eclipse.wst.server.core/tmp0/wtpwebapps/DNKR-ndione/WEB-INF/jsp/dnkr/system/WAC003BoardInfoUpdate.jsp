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
<!-- [EN] Contents area -->
<!-- [JP] コンテンツエリア -->
																					

<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/WAC011Board.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/WAC014BoardCreate.js" charset="utf-8"></script>
<link rel="stylesheet" media="all" href="/css/board.css"/>

																															   
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

		   
					   
			 
 
</style>

<div class="board-write-wrap">
			<span class="top-border"></span> 
			<form:form action="${pageContext.request.contextPath}/WAC003BoardUpdate/infoUpdate.do" modelAttribute="WAC004BoardInfoCreateForm" name="WAC004BoardInfoCreateForm" method="POST">
			<input type="hidden" name="tabId" value="<c:out value="${tabId}"></c:out>" />
			<input type="hidden" name="boardId" value="<c:out value="${boardInfoDomain.boardId}"></c:out>" />
																																		   
																																		   
				<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%--ì¡°íê¶í --%>
				<table class="write_01" summary="각 해당하는 항목에 알맞게 내용을 입력해주세요">
					<caption>내용 수정폼</caption>
					<colgroup>
						<col width="12%">
						<col width="38%">
						<col width="12%">
						<col width="38%">
					</colgroup>
					<tbody>
						<tr>
							<th class="check">
								<label for="boardNm">
									<span class="necessary">* </span>
									<spring:message code="label.WAC001.boardNm" />
								</label>
								<!-- 사원 구분 -->
							</th>
							<td>
								<form:input style="width:150px;" value="${boardInfoDomain.boardNm }" cssClass="form-control input-xs required inlineBlock" type="text" id="boardNm" path="boardNm" maxlength="50" cssErrorClass="form-control input-xs bg_error" required="true" autofocus="true" />
							</td>
							<th class="check"><spring:message code="label.WAC001.boardId" /></th>
							<td>
								${boardInfoDomain.boardId }
							</td>
						</tr> 
						<tr>
							<th class="check">
								<label for="boardType">
									<spring:message code="label.WAC001.boardType" />
								</label>
							</th>
							<td>
								<form:select cssClass="form-control input-xs required" id="boardType" path="boardType" required="true" style="width:150px;">
									<c:forEach var="type" items="${boardType}" varStatus="status">
										<option value="${type.key }" ${type.key eq boardInfoDomain.boardType ? 'selected' : '' }>${type.value }</option>
									</c:forEach>
	                        	</form:select>
							</td>
							<th class="check">
								<label for="readAuth">
									<spring:message code="label.WAC001.readAuth" />
								</label>
							</th>
							<td>
								<form:select cssClass="form-control input-xs required" id="readAuth" path="readAuth" required="true" style="width:150px;">
									<c:forEach var="vo" items="${boardAuth}" varStatus="status">
										<option value="${vo.key }" ${vo.key eq boardInfoDomain.readAuth ? 'selected' : '' }>${vo.value }</option>
									</c:forEach>
	                        	</form:select>
							</td>
						</tr>
						
		   
																		  
			
																																																																																									 
														  
																																																												  
																																																											 
												
					 
						
			
			 
						<tr>
							<th class="check">
								<label for="writeAuth">
									<spring:message code="label.WAC001.writeAuth" />
								</label>
							</th>
							<td>
								<form:select cssClass="form-control input-xs required" id="writeAuth" path="writeAuth" required="true" style="width:150px;">
									<c:forEach var="vo" items="${boardAuth}" varStatus="status">
										<option value="${vo.key }" ${vo.key eq boardInfoDomain.writeAuth ? 'selected' : '' }>${vo.value }</option>
									</c:forEach>
	                        	</form:select>
							</td>
							<th class="check">
								<label for="nsrAuth">
									<spring:message code="label.WAC001.nsrAuth" />
								</label>
							</th>
							<td>
								<form:select cssClass="form-control input-xs required" id="nsrAuth" path="nsrAuth" required="true" style="width:150px;">
									<c:forEach var="vo" items="${boardAuth}" varStatus="status">
										<option value="${vo.key }" ${vo.key eq boardInfoDomain.nsrAuth ? 'selected' : '' }>${vo.value }</option>
									</c:forEach>
	                        	</form:select>
							</td>
						</tr>
						
						<tr>
							<th class="check">
								<label for="notiAuth">
									<spring:message code="label.WAC001.notiAuth" />
								</label>
							</th>
							<td>
								<form:select cssClass="form-control input-xs required" id="notiAuth" path="notiAuth" required="true" style="width:150px;">
									<c:forEach var="vo" items="${boardAuth}" varStatus="status">
										<option value="${vo.key }" ${vo.key eq boardInfoDomain.notiAuth ? 'selected' : '' }>${vo.value }</option>
									</c:forEach>
	                        	</form:select>
							</td>
							<th class="check">
								<label for="secretUse">
									<spring:message code="label.WAC001.secretUse" />
								</label>
							</th>
							<td>
								<c:choose>
									<c:when test="${boardInfoDomain.secretUse eq 'Y' }">
										<form:radiobutton id="secretUseY" path="secretUse" value="Y" checked="checked" />
											<spring:message code="label.yes" /><!-- 예 -->&nbsp;
										<form:radiobutton id="secretUseN" path="secretUse" value="N" />
											<spring:message code="label.no" /><!-- 아니오 -->
										<form:errors path="secretUse" cssStyle="color:#ff0000;" element="span" />
									</c:when>
									<c:otherwise>
										<form:radiobutton id="secretUseY" path="secretUse" value="Y" />
											<spring:message code="label.yes" /><!-- 예 -->&nbsp;
										<form:radiobutton id="secretUseN" path="secretUse" value="N" checked="checked" />
											<spring:message code="label.no" /><!-- 아니오 -->
										<form:errors path="secretUse" cssStyle="color:#ff0000;" element="span" />
									</c:otherwise>
								</c:choose>
								
																																		   
																																																															
						
							</td>
						</tr>
						
						<tr>
							<th class="check">
								<label for="rowCnt">
									<span class="necessary">* </span>
									<spring:message code="label.WAC001.rowCnt" />
								</label>
							</th>
							<td>
								<form:input style="width:150px;" value="${boardInfoDomain.rowCnt }" cssClass="form-control input-xs required inlineBlock" type="text" id="rowCnt" path="rowCnt" maxlength="5" cssErrorClass="form-control input-xs bg_error" required="true" autofocus="true" />
							</td>
							<th class="check">
								<label for="pageCnt">
									<span class="necessary">* </span>
									<spring:message code="label.WAC001.pageCnt" />
								</label>
							</th>
							<td>
								<form:input style="width:150px;" value="${boardInfoDomain.pageCnt }" cssClass="form-control input-xs required inlineBlock" type="text" id="pageCnt" path="pageCnt" maxlength="5" cssErrorClass="form-control input-xs bg_error" required="true" autofocus="true" />
							</td>
						</tr>
						
						<tr>
							<th class="check">
								<label for="fileNum">
									<spring:message code="label.WAC001.fileNum" />
								</label>
							</th>
							<td>
								<form:select cssClass="form-control input-xs required" id="fileNum" path="fileNum" required="true" style="width:100px;">
									<c:forEach var="num" items="${fileNum}" varStatus="status">
										<option value="${num }" ${num eq boardInfoDomain.fileNum ? 'selected' : '' }>${num }</option>
									</c:forEach>
	                        	</form:select>
							</td>
							<th class="check">
								<label for="fileSize">
									<spring:message code="label.WAC001.fileSize" />
								</label>
							</th>
							<td>
								<form:select cssClass="form-control input-xs required" id="fileSize" path="fileSize" required="true" style="width:100px;">
									<c:forEach var="size" items="${fileSize}" varStatus="status">
										<option value="${size }" ${size eq boardInfoDomain.fileSize ? 'selected' : '' }>${size }MB</option>
									</c:forEach>
	                        	</form:select>
							</td>
						</tr>
						
						<tr>
							<th class="check">
								<label for="fileExt">
									<spring:message code="label.WAC001.fileExt" />
								</label>
							</th>
							<td colspan="3">
								<form:input style="width:550px;" cssClass="form-control input-xs required inlineBlock" type="text" id="fileExt" path="fileExt" maxlength="200" cssErrorClass="form-control input-xs bg_error" required="true" autofocus="true" value="${boardInfoDomain.fileExt }" /> 세미콜론(;)으로구분
							</td>
						</tr>
					</tbody>
				</table> 
				</c:if>
				<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '0' }"><%--ì¡°íê¶í --%>
					<spring:message code='DNKR-E2-0000'/><!-- ê¶íì´ ììµëë¤. -->
				</c:if>
				<div class="list-bnt writeOnly">
					<button type="button" onclick="javascript:location.href='${pageContext.request.contextPath}/WAC001BoardSearch/infoInit.do?tabId=<c:out value="${tabId}"></c:out>'" class="gray" name="Cancel">
						<spring:message code="label.cancel" /><!-- 취소 -->
					</button>
	 
					<c:if test="${fn:substring(authBinaryNum, 1, 2) eq '1' }"><%--ìì ê¶í --%>
						<button type="submit" class="red" name="Register" onclick="return boardCheck();">
							<spring:message code="label.modify" /><!-- 등록 -->
						</button>
					</c:if>
											  
											
				</div>
			
			</form:form>
			
		</div> 
	
  