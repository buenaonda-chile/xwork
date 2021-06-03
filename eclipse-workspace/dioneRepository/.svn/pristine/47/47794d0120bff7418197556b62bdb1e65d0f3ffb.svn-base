<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/taglib.jsp"%>

<script type="text/javascript">

	function regNotice(){
		 oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);	// 에디터의 내용이 textarea에 적용됩니다.
		if(checkRegFormValid()){
			if(confirm("등록하시겠습니까?")){
				$('#pressRegForm').submit();
			}
		}
	}
	
	function updNotice(){
		 oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);	// 에디터의 내용이 textarea에 적용됩니다.
		if(checkRegFormValid()){
			if(confirm("수정하시겠습니까?")){
				$('#pressRegForm').submit();
			}
		}
	}
	
	function checkRegFormValid(){
		return true;
	}
	
</script>

<!-- s: main content -->

<form id="pressRegForm" method="post">
	<c:set var="now" value="<%=new java.util.Date() %>" />
	<input type="hidden" name="boardDate" value="${now}"/>
	
	<div class="main_content">
		<div class="main_title">
			<h3 class="tit">Press 등록</h3>
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
						<td><div class="ct"><input type="text" name="title" class="txtEntry01" style="width:568px;" value="${noticeInfo.title}"/></div></td> 
					</tr>
					<tr>
						<th><div class="tit">작성자</div></th>
						<td><div class="ct">관리자</div></td> 
					</tr>
					<tr>
						<th><div class="tit">등록일</div></th>
						<td><div class="ct"><fmt:formatDate value="${now}" pattern="yyyy.MM.dd" /></div></td> 
					</tr>
					<tr>
						<th><div class="tit">전시 구분</div></th>
						<td>
							<div class="ct">
								<span class="selectBox">
									<label for="select01" style="width:68px;">ㅇㅇㅇ</label>
									
									<c:choose>
										<c:when test="${type == 'update'}">
											<select id="select01" name="displayYn">
												<option value="Y" <c:if test="${'Y' == noticeInfo.displayYn}">selected="selected"</c:if> >Y</option>
												<option value="N" <c:if test="${'N' == noticeInfo.displayYn}">selected="selected"</c:if> >N</option>
											</select>
										</c:when>
										<c:otherwise>
											<select id="select01" name="displayYn">
												<option value="Y" selected="selected">Y</option>
												<option value="N">N</option>
											</select>
										</c:otherwise>
									</c:choose>
									
									
								</span>
							</div>
						</td> 
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
						<td><div class="ct">
							<textarea name="content" id="content" rows="10" cols="100" style="width:568px; height:300px;" class="txtEntry01">${noticeInfo.content}</textarea>
						</div></td> 
					</tr>
				</tbody>
			</table>
		</div>
		<!-- e: write -->
	
		<!-- s: 테이블 하단 -->
		<div class="tfoot_wrap">
			<div class="rtl"> 
				<span class="btn b_pt"><a href="javascript:regNotice();" class="b_in" style="width:57px;">등록</a></span>
				<span class="btn"><a href="javascript:history.go(-1);" class="b_in" style="width:57px;">취소</a></span>
			</div>
		</div>
		<!-- e: 테이블 하단 -->
	
	</div>
</form>
<script type="text/javascript">
	
	var oEditors = [];
	nhn.husky.EZCreator.createInIFrame({
		oAppRef: oEditors,
		elPlaceHolder: "content",
		sSkinURI: '<c:url value="/resources/se2/SmartEditor2Skin.html"/>',	
		htParams : {
			bUseToolbar : true,				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseVerticalResizer : true,		// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseModeChanger : true,			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
			//aAdditionalFontList : aAdditionalFontSet,		// 추가 글꼴 목록
			fOnBeforeUnload : function(){
				//alert("완료!");
			}
		}, //boolean
		fOnAppLoad : function(){
			//예제 코드
			//oEditors.getById["ir1"].exec("PASTE_HTML", ["로딩이 완료된 후에 본문에 삽입되는 text입니다."]);
		},
		fCreator: "createSEditor2"
	});
</script>
<!-- e: main content -->
    