<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/taglib.jsp"%>

<script type="text/javascript">

function goList(){
	location.href='<c:url value="/notice/news/list"/>';
}

function goUpdate(){
	$('#detailForm').submit();
}
function goDelete(){
	if(confirm("삭제하시겠습니까?")){
		$('#type').val('delete');
		$('#detailForm').attr('method', 'post').submit();	
	}
}
</script>
<!-- s: main content -->
<form id="detailForm" method="get" action="<c:url value="/notice/news/proc"/>">
<input type="hidden" name="seq" value="${noticeInfo.seq}"/>
<input type="hidden" id="type" name="type" value="${type}"/>
<div class="main_content">

	<div class="main_title">
		<h3 class="tit">뉴스/공지 상세</h3>
	</div>

	<h4 class="tit">기본 정보</h4>
	 
	<!-- s: write -->
	<div class="table_write_type01">
		<table>
			<colgroup>
				<col width="130" />
				<col width="599" />
			</colgroup>
			<tbody>
				<tr>
					<th><div class="tit">제목</div></th>
					<td><div class="ct">${noticeInfo.title}</div></td> 
				</tr>
				<tr>
					<th><div class="tit">작성자</div></th>
					<td><div class="ct">관리자</div></td> 
				</tr>
				<tr>
					<th><div class="tit">등록일</div></th>
					<td><div class="ct"><fmt:formatDate value="${noticeInfo.boardDate}" pattern="yyyy.MM.dd" /> </div></td> 
				</tr>
				<tr>
					<th><div class="tit">전시 구분</div></th>
					<td><div class="ct"><c:out value="${noticeInfo.displayYn}" /></div></td> 
					
				</tr>
			</tbody>
		</table>
	</div>
	<!-- e: write -->

	<h4 class="tit">내용</h4>
	 
	<!-- s: write -->
	<div class="table_write_type01">
		<table>
			<colgroup>
				<col width="130" />
				<col width="599" />
			</colgroup>
			<tbody>
				<tr>
					<th><div class="tit">내용</div></th>
					<td><div class="ct"><c:out value="${noticeInfo.content}" escapeXml="false"/></div></td> 
				</tr>
			</tbody>
		</table>
	</div>
	<!-- e: write -->

	<!-- s: 테이블 하단 -->
	<div class="tfoot_wrap">
		<div class="ltr"> 
			<span class="btn"><a href="javascript:goList()" class="b_in" style="width:57px;">목록</a></span>
		</div>
		<div class="rtl"> 
			<span class="btn b_pt"><a href="javascript:goUpdate();" class="b_in" style="width:57px;">수정</a></span>
			<span class="btn"><a href="javascript:goDelete();" class="b_in" style="width:57px;">삭제</a></span>
		</div>
	</div>
	<!-- e: 테이블 하단 -->

</div>
</form>
<!-- e: main content -->
