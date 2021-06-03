<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/taglib.jsp"%>

<script type="text/javascript">

	function regNotice(){
		 oEditors.getById["faqQuestion"].exec("UPDATE_CONTENTS_FIELD", []);	// 에디터의 내용이 textarea에 적용됩니다.
		 oEditors.getById["faqReply"].exec("UPDATE_CONTENTS_FIELD", []);	// 에디터의 내용이 textarea에 적용됩니다.
		if(checkRegFormValid()){
			if(confirm("등록하시겠습니까?")){
				
				$('#frmFaq').submit();
			}
		}
	}
	
	function updNotice(){
		 oEditors.getById["faqQuestion"].exec("UPDATE_CONTENTS_FIELD", []);	// 에디터의 내용이 textarea에 적용됩니다.
		 oEditors.getById["faqReply"].exec("UPDATE_CONTENTS_FIELD", []);	// 에디터의 내용이 textarea에 적용됩니다.
		if(checkRegFormValid()){
			if(confirm("수정하시겠습니까?")){
				$('#frmFaq').submit();
			}
		}
	}
	
	function checkRegFormValid(){
		return true;
	}
	
	function selectBoxChange() {
		 $.ajax({       
				type:"GET",   
				url:$root+'/notice/faq/typeList',       
				data:{
						"productCode":$.trim($('#faqProductType').val()),
						"encodingType":$.trim($('#faqEncoding').val())
					},
				traditional:true,
				success:function(data){
					receiverInfoList = data.result;
					var html = "";
					for(var i=0; i<receiverInfoList.length; i++){
						receiverInfo = receiverInfoList[i];
						html += "<option value=" + receiverInfo.code +">"+receiverInfo.codeName+"</option>";	
					}
					$('#faqClass').empty().append(html);
					$('#faqClassLabel').find("label").text("선택");
				}   
			});
	}
	
</script>

<!-- s: main content -->
<form id="frmFaq" name="frmFaq" method="post">
	<div class="main_content">
		<div class="main_title">
			<h3 class="tit">FAQ 등록</h3>
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
						<th><div class="tit">언어 구분</div></th>
						<td>
							<div class="ct">
								<span class="selectBox"> <label for="select01"
									style="width: 68px;"></label> <select name="faqEncoding"  id="faqEncoding" onchange="selectBoxChange()">
										<option value="kor" selected="selected">국문</option>
										<option value="eng">영문</option>
								</select>
								</span>
							</div>
						</td>
					</tr>
					<tr>
						<th><div class="tit">상품 구분</div></th>
						<td>
							<div class="ct">
								<span class="selectBox"> <label for="select01" style="width: 200px;"></label> 
									<select name="faqProductType" id="faqProductType" style="width: 250px" onchange="selectBoxChange()">
										<c:forEach var="pdtDivision" items="${pdtList}">
											<option value="${pdtDivision.code}" <c:if test="${pdtDivision.code == noticeInfo.faqProductType}">selected</c:if>>${pdtDivision.name}</option>
										</c:forEach>
									</select>
								</span>
							</div>
						</td>
					</tr>
					<tr>
						<th><div class="tit">유형 구분</div></th>
						<td>
							<div class="ct">
									<span class="selectBox" id="faqClassLabel"> 
									<label for="select01" style="width: 200px;"></label> 
									<select name="faqClass" id="faqClass" style="width: 200px">
										<c:forEach var="type" items="${typeList}">
											<option value="${type.code}" <c:if test="${type.code == noticeInfo.faqClass}">selected</c:if>>${type.codeName}</option>
										</c:forEach>
									</select>
								</span>
							</div>
						</td>
					</tr>
					<tr>
						<th><div class="tit">질문</div></th>
						<td><div class="ct"><textarea maxlength="200" name="faqQuestion" id="faqQuestion" rows="10" cols="100" style="width:568px; height:150px;" class="txtEntry01">${noticeInfo.faqQuestion}</textarea></div></td>
					</tr>
					<tr>
						<th><div class="tit">답변</div></th>
						<td><div class="ct"><textarea name="faqReply" id="faqReply"  rows="10" cols="100" style="width:568px; height:150px;" class="txtEntry01">${noticeInfo.faqReply}</textarea></div></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- e: write -->

		<!-- s: 테이블 하단 -->
		<div class="tfoot_wrap">
			<div class="rtl">
				<span class="btn b_pt"><a href="javascript:regNotice();" class="b_in"
					style="width: 57px;">등록</a></span> <span class="btn"><a href="javascript:history.go(-1);"
					class="b_in" style="width: 57px;">취소</a></span>
			</div>
		</div>
		<!-- e: 테이블 하단 -->

	</div>
</form>

<script type="text/javascript">
	var oEditors = [];
	nhn.husky.EZCreator.createInIFrame({
		oAppRef: oEditors,
		elPlaceHolder: "faqQuestion",
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
	
	nhn.husky.EZCreator.createInIFrame({
		oAppRef: oEditors,
		elPlaceHolder: "faqReply",
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
