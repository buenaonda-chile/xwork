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
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%-- 조회권한 --%>
<link type="text/css" href="/css/wafCommon.css" rel="stylesheet">
<script type="text/javascript">

	var list = ${fileDomain};

	function downFile(seqno){
		var frm = document.file_form;
		frm.seqno.value = seqno;
		frm.submit();
	}
	
	var unitGrid = {
		initView: function() {
			this.target = new ax5.ui.grid();
			this.target.setConfig({
				target : $('[data-ax5grid="unit-grid"]'),
				showLineNumber: true, 
				header: {
					align: "center",
				},
				body : {
					align : "center",
					columnHeight : 28,
					onClick : function() {
						console.log(this.target);
						if(this.column.key !== "delchk") {
							this.self.clearSelect();
							this.self.select(this.dindex);
						} 
					},
					onDBLClick : function() {
						if(this.column.key !== "delchk") {
							var seqno = this.item.seqno;
							console.log("seqno" + seqno);
							downFile(seqno); 
						}
					}, 
				},
				columns : 
					[
						{
							  key : "siryo",
							  label : "자료타이틀",
							  width: 600,
						},
						{
							  key : "ftype",
							  label : "화일타입",
							  width: 150,
						},
						{
							  key : "delchk",
							  label : "삭제",
							  align: "center",
							  width: 80,
							  editor : {
									type : "",
								},
								formatter:function(){		
									var seqno = this.item.seqno;
									console.log(seqno);
									return "<input type='checkbox' class='' onClick='delFile(this, " + '"' + seqno + '"' + ")'/>";
								}
						},
				    ],
			});
		}
	};
	
	/**
	 * [KO] 파일삭제
	 *
	 **/
	function delFile (target, seqno) {
		if($(target).is(":checked")) {
			if(confirm("[확인]삭제하시겠습니까?")){
				console.log("삭제");
				var url = "/WAF002PsogmCreate/attachedFileDelete.do";
				var jisno = $('#jisno').val();
				var params = {seqno : seqno};
				var obj = getAjaxDomain(url, params);
				if(obj !== undefined) {
					if(obj.result === RESULT_Y) {
						toastMsg('삭제되었습니다.');
						location.replace("/WAF002PsogmCreate/attachedFilePop.do?jisno=" + jisno);
					}
				}
			} else {
				$(target).prop("checked", false);
			}
		}
	}
	
	
	/**
	 * [KO] 파일업로드 전 선택한 파일이 있는지 체크
	 *
	 * @param target 업로드버튼
	 */
	function chkFile (target) {
		var fileInput = $(target).prev();	//파일타입 input
		var filename;
		
		if($(fileInput).val() !== "") {	//선택한 파일이 있으면
			if(window.FileReader){ // modern browser 
				console.log("1");
				filename = $(fileInput)[0].files[0].name;
			} else { // old IE
				console.log("2");
				filename = $(fileInput).val().split('/').pop().split('\\').pop(); // 파일명만 추출 
			}
			
			return true;
		} else {
			toastMsg("파일을 선택해주세요.");
			return false;	
		}
	}
	
	$(document.body).ready(function () {
		
		unitGrid.initView();
		unitGrid.target.setData(list);
		
		$('.addBtn').click(function(){
			$('.addFile').removeClass("displayNone");
		});
		
		$('.closeBtn').click(function(e){
			if(e.target.getAttribute('data-target') === "pop") {
				self.close();	
			} else {
				$('.addFile').addClass("displayNone");	
			}
		});
	});
	
	
</script>
<style>
.unitWrap .regTbl .btnDiv {
	text-align: center;
	padding: 5px;
}

select {
    max-width: 200px;
}

.unitWrap .last-tbl {
	border-top: none;
}

input[type="file"] {
    display: inline-block;
    border: none;
}

button.upLoad {
    background: url(/img/board/upload-icon.png)no-repeat 25px center #666;
    color: #fff;
    padding: 8px 27px 8px 45px;
    border-radius: 3px;
    cursor: pointer;
}

.addFile {
    border: 1px solid #bbb;
    text-align: center;
    padding: 10px;
}

.displayNone {
	display: none;
}

</style>
<div class="unitWrap">	
	<h2 class="subpage-tit">첨부자료등록<!-- 사업부서 선택 --></h2>
	<div class="list-top">
		<table class="pd-s-table">
			<colgroup>
				<col/>
				<col/>
				<col/>
				<col/>
				<col/>
				<col/>
			</colgroup>
			<tbody>
				<tr>
					<th>
						지시 No
					</th>
					<td>
						<input type="text" id="" placeholder="" title="" value="${jisno}"/>
					</td>
					<td>
						<button type="button" class="red btn-st02 addBtn" onclick="">
							<spring:message code='label.add' />
							<!-- 등록 -->
						</button>
						<button type="button" class="black btn-st02 closeBtn" onclick="" data-target="pop">
							<spring:message code='label.close' />
							<!-- 닫기 -->
						</button>
					</td>
				</tr>
			</tbody>
		</table>
				
	</div>
	<div class="sssgap"></div>
	<div class="addFile displayNone">
		<form:form action="${pageContext.request.contextPath}/WAF002PsogmCreate/attachedFileCreate.do" method="POST" name="attachedFileForm" enctype="multipart/form-data">
			<input type="hidden" id="jisno" name="jisno" placeholder="" title="" value="${jisno}"/>
			<select name="siryo">
				<option>작업부 상세도(삽입그림)</option>
				<option>장시간고장발생보고서(A링크)</option>
				<option>이력보고 보충자료</option>
			</select>
			<input type="file" name="filn"/>
			<button type="submit" class="upLoad" style="right:0px" onclick="return chkFile(this);">
				<span>업로드</span>
			</button>
			<button type="button" class="black btn-st02 closeBtn" onclick="" data-target="addDiv">
				<spring:message code='label.close' />
				<!-- 닫기 -->
			</button>
		</form:form>
	</div>
	<div class="sssgap"></div>
	<form name="file_form" method="post" action="/WAF002PsogmCreate/downFile.do">
		<input type="hidden" name="seqno" value="" /> 
	</form>
	<div>
		<div class="gridContents" style="" id="grid-parent">
		    <div class="" data-ax5grid="unit-grid" data-ax5grid-config="{showLineNumber: true}" style="height: 350px"></div>
	    </div>
	</div>
</div>
</c:if>