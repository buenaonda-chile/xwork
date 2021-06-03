<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/taglib.jsp"%>
<%@ taglib prefix="spdata" tagdir="/WEB-INF/tags"%>

<script type="text/javascript">
	function inquerySubmit(page) {
		
		if(page){
			$('#faqForm input[name="page"]').val(page-1);
		} else{
			$('#faqForm input[name="page"]').val(0);
		}
		$('#faqForm').submit();
	}
	
	function goList(){
		location.href='<c:url value="/notice/faq/proc?type=regist"/>';
	}
</script>
<form id="faqForm" method="get">
	<input type="hidden" id="page" name="page" value="${pageVo.page}" /> <input
		type="hidden" id="size" name="size" value="${pageVo.size}" /> <input
		type="hidden" id="property" name="property" value="${pageVo.property}">
	<input type="hidden" id="direction" name="direction"
		value="${pageVo.direction}">
	<!-- s: main content -->
	<div class="main_content">
		<div class="main_title">
			<h3 class="tit">FAQ 리스트</h3>
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
						<td>상품 구분 &nbsp; 
						
						<span class="selectBox"> <label for="select01" style="width: 80px;"></label> 
							<select name="faqProductTypeCondition" id="faqProductTypeCondition" >
								<option value="" >전체</option>
								<c:forEach var="pdtDivision" items="${pdtList}">
									<option value="${pdtDivision.code}" <c:if test="${pdtDivision.code == noticeParam.faqProductTypeCondition}">selected</c:if>>${pdtDivision.name}</option>
								</c:forEach>
							</select>
						</span>
						&nbsp; &nbsp; &nbsp; 
						
						<span class="selectBox" >
							<label for="select01" style="width:68px;"></label>
							<select id="select01" name="statusCondition">
								<option value="question" <c:if test="${'question' == noticeParam.statusCondition}">selected="selected"</c:if>>문의</option>
								<option value="reply" <c:if test="${'reply' == noticeParam.statusCondition}">selected="selected"</c:if>>답변</option>
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
				<span class="">총 : <c:out value="${fn:length(noticePage.content)}" /></span>
			</div>
		</div>
		<!-- e: 테이블 상단 -->

		<!-- s: table list -->
		<div class="table_list_type01">
			<table>
				<colgroup>
					<col width="40" />
					<col width="50" />
					<col width="80" />
					<col width="80" />
					<col width="40" />
					<col width="289" />
					<col width="90" />
					<col width="90" />
				</colgroup>
				<thead>
					<tr>
						<th>no</th>
						<th>국문</th>
						<th>상품 구분</th>
						<th>유형 구분</th>
						<th colspan="2">문의/답변</th>
						<th>등록일</th>
						<th class="last">관리</th>
					</tr>
				</thead>
				<tbody>
				
				 <c:choose>
					<c:when test="${fn:length(noticePage.content) > 0}">
						<c:forEach var="result" items="${noticePage.content}" varStatus="status">
							<!-- s: repeat -->
							<tr>
								<td rowspan="2">${result.seq}</td>
								<c:if test="${result.faqEncoding eq 'kor'}">
									<td rowspan="2">국문</td>
								</c:if>
								<c:if test="${result.faqEncoding eq 'eng'}">
									<td rowspan="2">영어</td>
								</c:if>
								<td rowspan="2">${result.faqProductTypeName}</td>
								<td rowspan="2">${result.faqClassName}</td>
								<td>Q</td>
								<td><div class="tal">${result.faqQuestion}</div></td>
								<td rowspan="2"><fmt:formatDate value="${result.boardDate}" pattern="yyyy.MM.dd" /></td>
								<td rowspan="2"><span class="btn">
								<a href="<c:url value='/notice/faq/detail'/>?seq=${result.seq}&type=update" class="b_in" style="width: 37px;">수정</a></span></td>
							</tr>
							<tr>
								<td>A</td>
								<td><div class="tal">${result.faqReply}</div></td>
							</tr>
							<!-- e: repeat -->
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="5">FAQ가 없습니다.</td>
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
				<span class="btn"><a href="javascript:goList()" class="b_in"
					style="width: 57px;">등록</a></span>
			</div>
		</div>
		<!-- e: 테이블 하단 -->


		<!-- s: 페이징 -->
		<div class="pageNavi_wrap">
			<span id="currentPage"> <spdata:page groupSize="5"
					func="inquerySubmit" page="${noticePage}" />
			</span>
		</div>
		<!-- e: 페이징 -->
	</div>
</form>



