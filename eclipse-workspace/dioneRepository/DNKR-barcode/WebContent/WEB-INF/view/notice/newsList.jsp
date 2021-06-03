<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/taglib.jsp"%>
<%@ taglib prefix="spdata" tagdir="/WEB-INF/tags" %>

<script type="text/javascript">
	function inquerySubmit(page) {
		
		if(page){
			$('#newListForm input[name="page"]').val(page-1);
		} else{
			$('#newListForm input[name="page"]').val(0);
		}
		$('#newListForm').submit();
	}
	
	function goList(){
		location.href='<c:url value="/notice/news/proc?type=regist"/>';
	}
</script>
<form id="newListForm" method="get">
<input type="hidden" id="page" name="page" value="${pageVo.page}"/> 
<input type="hidden" id="size" name="size" value="${pageVo.size}"/>
<input type="hidden" id="property" name="property" value="${pageVo.property}">
<input type="hidden" id="direction" name="direction" value="${pageVo.direction}">
<!-- s: main content -->
<div class="main_content">
	<div class="main_title">
		<h3 class="tit">뉴스 리스트</h3>
	</div>
	<!-- s: search -->
	<div class="search_form_wrap">
		<table>
			<colgroup>
				<col width="100" />
				<col width="620" />
			</colgroup>
			<tbody> 
				<tr class="first">
					<th><div class="tit">조건 설정</div></th>
					<td>
						전시 구분
						&nbsp;
						<span class="selectBox">
							<label for="select01" style="width:68px;">전시구분</label>
							<select id="select01" name="displayCondition">
								<option value="" <c:if test="${'' == noticeParam.displayCondition}">selected="selected"</c:if>>전체</option>
								<option value="Y" <c:if test="${'Y' == noticeParam.displayCondition}">selected="selected"</c:if>>전시</option>
								<option value="N" <c:if test="${'N' == noticeParam.displayCondition}">selected="selected"</c:if>>미전시</option>
							</select>
						</span>
						&nbsp;
						<span class="selectBox" >
							<label for="select01" style="width:68px;"></label>
							<select id="select01" name="statusCondition">
								<option value="title" <c:if test="${'title' == noticeParam.statusCondition}">selected="selected"</c:if>>제목</option>
								<option value="writer"<c:if test="${'writer' == noticeParam.statusCondition}">selected="selected"</c:if>>작성자</option>
							</select>
						</span>
						<input type="text" class="txtEntry01" name="statusText" value="${noticeParam.statusText}" style="width:250px;" /> 
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- e: search -->
	<!-- s: btn -->
	<div class="btnAlign_wrap01">
		<span class="btn b_pt"><a href="javascript:inquerySubmit('${pageVo.page + 1}')" class="b_in" style="width:82px;">검색</a></span>
	</div>
	<!-- e: btn -->
	<!-- s: 테이블 상단 -->
	<div class="thead_wrap">
		<div class="ltr txt01">
			<span class="">총 : &nbsp; <c:out value="${fn:length(noticePage.content)}" /></span>
		</div> 
	</div>
	<!-- e: 테이블 상단 -->

	<!-- s: table list -->
	<div class="table_list_type01">
		<table>
			<colgroup>
				<col width="60" />
				<col width="*" /> 
				<col width="140" /> 
				<col width="100" /> 
				<col width="100" />  
			</colgroup>
			<thead>
				<tr>
					<th>no</th>
					<th>제목</th>
					<th>작성자</th>
					<th>등록일</th>
					<th>전시구분</th>
				</tr>
			</thead>
			<tbody>
			
			<c:choose>
				<c:when test="${fn:length(noticePage.content) > 0}">
					<c:forEach var="result" items="${noticePage.content}" varStatus="status">
						<tr>
							<td>
								<c:out value="${result.seq}" />
							</td>
							<td>
								<a href="<c:url value='/notice/news/detail'/>?seq=${result.seq}&type=update"><c:out value="${result.title}" /></a>
							</td>
							<td>
								관리자
							</td>
							<td>
								<fmt:formatDate value="${result.boardDate}" pattern="yyyy.MM.dd" />
							</td>
							<td>
								<c:out value="${result.displayYn}" />
							</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="5">news가 없습니다.</td>
					</tr>
				</c:otherwise>
			</c:choose>
			</tbody>
		</table>
	</div>
	<!-- e: table list -->

	<!-- s: 테이블 하단 -->
	<div class="tfoot_wrap"> 
		<div class="rtl"> 
			<span class="btn">
			<a href="javascript:goList()" class="b_in" style="width:57px;">등록</a></span>
		</div>
	</div>
	<!-- e: 테이블 하단 -->
	
	<!-- s: 페이징 -->
	<div class="pageNavi_wrap">
		<span id="currentPage">
			<spdata:page groupSize="5" func="inquerySubmit" page="${noticePage}" />
		</span>
	</div> 
	<!-- e: 페이징 -->
</div>
</form>	



    