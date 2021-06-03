<%--
 * PROJECT：
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

<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/WAC011Board.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/WAC011BoardSearch.js" charset="utf-8"></script>

<c:choose>
	<c:when test="${WAC001BoardInfoSearchForm.boardNm ne '' }">
		<c:set value="boardNm" var="nameId"/>
		<c:set value="${WAC001BoardInfoSearchForm.boardNm }" var="searchData"/>
	</c:when>
	<c:when test="${WAC001BoardInfoSearchForm.boardId ne '' }">
		<c:set value="boardId" var="nameId"/>
		<c:set value="${WAC001BoardInfoSearchForm.boardId }" var="searchData"/>
	</c:when>
	<c:otherwise>
		<c:set value="" var="nameId"/>
		<c:set value="" var="searchData"/>
	</c:otherwise>
</c:choose>

<div class="board-bList-wrap">
	<form:form action="${pageContext.request.contextPath}/WAC001BoardSearch/infoSearch.do" method="POST" onsubmit="searchProc();" modelAttribute="WAC001BoardInfoSearchForm" name="WAC001BoardInfoSearchForm" id="WAC001BoardInfoSearchForm">
	<div class="list-top text-right">
		<input type="hidden" name="boardNm" id="boardNm" value="${boardNm }" />
		<input type="hidden" name="boardId" id="boardId" value="${boardId }" />
		
		<select autofocus="true" class="nameId" name="" title="게시판명 또는 게시판아이디를 선택해주세요">
				<option value="boardNm" ${nameId eq 'boardNm' ? 'selected' : '' }>게시판명</option>
				<option value="boardId" ${nameId eq 'boardId' ? 'selected' : '' }>게시판아이디</option>
		</select>
		<input class="AXInput" id="searchData" type="text" title="성명 또는 아이디를 입력해주세요" value="${searchData }" onkeypress="return onKeyDown(event);" />
		
		<button type="button" class="AXButton Black _searchBtn_" onclick="">
			<i class="axi axi-ion-android-search"></i>
			<spring:message code='label.search'/>
		</button>
		<c:if test="${fn:substring(authBinaryNum, 2, 3) eq '1' }"><%--등록권한 --%>
		<button type="button" class="AXButton Red _addBtn_" style="" onclick="javascript:location.href='/WAC004BoardCreate/infoInit.do?tabId=<c:out value="${tabId}"></c:out>';">
			<i><!--  class="axi axi-ion-person-add"> --></i>
			<spring:message code='label.WAC001.board'/>&nbsp;
			<spring:message code='label.add'/><!-- 사용자등록  -->
		</button>
		</c:if>
	</div>
		 
	<div class="gap10"></div>
	<span class="top-border"></span>
	<table id="boardInfoTable">
		<caption></caption>
		<colgroup>
			<col scope="col" width="*">
			<col scope="col" width="*">
			<col scope="col" width="*">
			<col scope="col" width="*">
			<col scope="col" width="*">
			<col scope="col" width="*">
			<col scope="cobl" width="*">
		</colgroup>
		<thead>
			<tr>
				<th><spring:message code='label.number'/><!-- 번호 --></th>
				<th><spring:message code='label.WAC001.boardNm'/><!-- 게시판명 --></th>
				<th><spring:message code='label.WAC001.boardId'/><!-- 게시판 아이디 --></th>
				<th><spring:message code='label.WAC001.boardType'/><!-- 분류 --></th>
				<th><spring:message code='label.WAC001.writeAuth'/><!-- 쓰기권한 --></th>
				<th><spring:message code='label.WAC001.readAuth'/><!-- 읽기 권한 --></th>
				<th><spring:message code='label.management'/><!-- 관리 --></th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%--조회권한 --%>

			<c:choose>
				<c:when test="${fn:length(infoList) > 0}">
					<c:set value="${fn:length(infoList)}" var="infoListSize"/>
						<c:forEach var="info" items="${infoList}" varStatus="status">
							<tr>
								<td>${totCount + 1 - info.rowNum}</td>
								<td>
									${info.boardNm}
								</td>
								<td>${info.boardId}</td>
								<td>${boardType[info.boardType]}</td>
								<td>${boardAuth[info.writeAuth]}</td>
								<td>${boardAuth[info.readAuth]}</td>
								<td>
									<div>
										<c:if test="${fn:substring(authBinaryNum, 1, 2) eq '1' }"><%--수정권한 --%>
											<button type="button" class="AXButton Normal _modifyBtn_"
												style="" onclick="javascript:location.href='/WAC003BoardUpdate/infoInit.do?tabId=<c:out value="${tabId}"></c:out>&boardId=<c:out value="${info.boardId}"></c:out>';" data-click-target="">
												<spring:message code='label.modify'/><!-- 수정 -->
											</button>
										</c:if>
										<c:if test="${fn:substring(authBinaryNum, 0, 1) eq '1' }"><%--삭제권한 --%>
											<button type="button" class="AXButton Normal _deleteBtn_"
												onclick="" data-loction=""
												data-click-target="${info.boardId}">
												<spring:message code='label.delete' />
												<!-- 삭제 -->
											</button>
										</c:if>
									</div>
								</td>
							</tr>
						</c:forEach>
				</c:when>
				<c:otherwise>
					<tr><td colspan="7"><spring:message code='label.no_data'/><!-- 데이터가 없습니다. --></td></tr>
				</c:otherwise>
			</c:choose>
			</c:if>
			<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '0' }"><%--조회권한 --%>
				<spring:message code='DNKR-E2-0000'/><!-- 권한이 없습니다. -->
			</c:if>
		</tbody>
	</table>
	<div class="gap20"></div>
		<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%--조회권한 --%>
			<c:if test="${fn:length(infoList) > 0}">
				<div class="pagenation">
		            <smpl:seqpaging maxSeq="3" formId="WAC001BoardInfoSearchForm" />
		        </div>
		        <ai:pagingoption countPerPage="3" />
	        </c:if>
        </c:if>
	</form:form>	
	<div class="gap20"></div>
	 <!-- 
	<div  style="display: inline-block; float:right">
		<button class="downLoad _excelBtn_" style="right:0px">
			<span>엑셀다운</span>
		</button>
	</div> -->
</div><!--board-view-wrap-->

