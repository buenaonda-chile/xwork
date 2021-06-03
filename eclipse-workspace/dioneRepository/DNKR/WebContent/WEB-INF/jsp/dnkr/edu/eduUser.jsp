<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible"  content="IE=Edge" />
<meta http-equiv="Pragma"           content="no-cache" />
<meta http-equiv="Cache-Control"    content="no-cache, no-store" />
<meta http-equiv="Expires"          content="-1" />

<title><spring:message code='label.edutitle'/></title>

<!-- <link rel="stylesheet" type="text/css" href="/assets/js/ax5ui/ax5ui-kernel/dist/ax5ui.all.css" />
<link rel="stylesheet" type="text/css" href="/assets/js/kendo-2018.3.1017/css/web/kendo.common.min.css" />
<link rel="stylesheet" type="text/css" href="/assets/js/kendo-2018.3.1017/css/web/kendo.rtl.min.css" />
<link rel="stylesheet" type="text/css" href="/assets/js/kendo-2018.3.1017/css/web/kendo.default.min.css" />
<link rel="stylesheet" type="text/css" href="/assets/js/kendo-2018.3.1017/css/web/kendo.default.mobile.min.css" />
<link rel="stylesheet" type="text/css" href="/assets/js/kendo-2018.3.1017/css/dataviz/kendo.dataviz.min.css" />
<link rel="stylesheet" type="text/css" href="/assets/js/kendo-2018.3.1017/css/dataviz/kendo.dataviz.default.min.css" /> -->
<!-- <link rel="stylesheet" type="text/css" href="/assets/css/kendo-reset.css" />
<link rel="stylesheet" type="text/css" href="/assets/js/jqgrid-4.6.0/css/ui.jqgrid.css" />
<link rel="stylesheet" type="text/css" href="/assets/css/ui.jqgrid-reset.css" />
<link rel="stylesheet" type="text/css" href="/assets/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/assets/css/bootstrap-reset.css" />
<link rel="stylesheet" type="text/css" href="/assets/css/jquery-ui.css" />
<link rel="stylesheet" type="text/css" href="/assets/js/tui-grid/tui-grid.css"/>
<link rel="stylesheet" type="text/css" href="/assets/css/tui-grid-reset.css"/>
<link rel="stylesheet" type="text/css" href="/assets/js/tui-pagination/tui-pagination.css"/>
<link rel="stylesheet" type="text/css" href="/assets/js/tui-tree/tui-tree.css"/> -->

<!-- 메뉴바 -->
<link rel="stylesheet" type="text/css" href="/assets/css/font-awesome.css" />
<link type="text/css" href="/assets/js/axisj/ui/arongi/page.css" rel="stylesheet"/>
<link type="text/css" href="/assets/js/axisj/ui/arongi/AXJ.min.css" rel="stylesheet">
<link type="text/css" href="/assets/js/axisj/axicon/axicon.min.css" rel="stylesheet" />
<!-- <link type="text/css" href="/assets/js/ax5ui/ax5ui-kernel/dist/ax5ui.all.css" rel="stylesheet"> -->
<link type="text/css" href="/assets/css/messageArea.css" rel="stylesheet" />
<link type="text/css" href="/assets/css/jquery.mCustomScrollbar.css" rel="stylesheet" />
<link type="text/css" href="/assets/css/common.css" rel="stylesheet" />
<link type="text/css" href="/assets/css/layout.css" rel="stylesheet" />
<link type="text/css" href="/assets/css/main.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="/assets/css/font.css"/>
<link rel="stylesheet" type="text/css" href="/assets/css/lib.css"/>
<link rel="stylesheet" type="text/css" href="/assets/css/sub-layout.css"/>
<link rel="stylesheet" type="text/css" href="/assets/css/content.css"/>
<link rel="stylesheet" type="text/css" href="/assets/css/template.css"/>
<link rel="stylesheet" type="text/css" href="/assets/css/main2018.css"/>
<!-- 메뉴바/ -->

<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
<link rel="stylesheet" href="/assets/css/summernote-bs4.css"> -->

<!-- include jquery -->
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.13.0/moment.min.js"></script>

<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.min.css" rel="stylesheet"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
<link rel="stylesheet" href="/assets/css/summernote-bs4.css">

<!-- 커스텀이에요 -->
<link rel="stylesheet" type="text/css" href="/assets/css/custom.css"/>
<style type="text/css">
.layout-LW {
	text-shadow : none;
}
</style>

<!-- 커스텀이에요 -->

<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.8.2/moment-with-locales.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.min.js"></script>

<!-- include libs stylesheets -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<!-- <script type="text/javascript" src="/assets/js/kendo-2018.3.1017/js/jquery.min.js"></script> -->
<!-- <script type="text/javascript" src="/assets/js/underscore/underscore-min.js"></script> -->
<!-- <script type="text/javascript" src="/assets/js/backbone/backbone-min.js"></script> -->
<!-- <script type="text/javascript" src="/assets/js/jquery.mockjax.min.js"></script> -->
<!-- <script type="text/javascript" src="/assets/js/fileUploadCheck.js"></script> -->
<!--<script type="text/javascript" src="/assets/js/warningDialog.js"></script> -->
<!-- <script type="text/javascript" src="/assets/js/jquery.mCustomScrollbar.concat.min.js"></script> -->
<!-- <script type="text/javascript" src="/assets/js/bootstrap.min.js"></script> -->

<!-- <script src="/assets/js/kendo-2018.3.1017/js/kendo.all.min.js"></script>
<script src="/assets/js/kendo-2018.3.1017/js/kendo.timezones.min.js"></script>
<script src="/assets/js/kendo-2018.3.1017/js/cultures/kendo.culture.ko-KR.min.js"></script> -->

<!-- <script type="text/javascript" src="/assets/js/tui-code-snippet/tui-code-snippet.min.js"></script>
<script type="text/javascript" src="/assets/js/tui-pagination/tui-pagination.min.js"></script>
<script type="text/javascript" src="/assets/js/tui-grid/tui-grid.js"></script>
<script type="text/javascript" src="/assets/js/tui-tree/tui-tree.js"></script> -->
<!-- <script type="text/javascript" src="/assets/js/libphonenumber-js.min.js"></script>
<script type="text/javascript" src="/assets/js/moment.min.js"></script>
<script type="text/javascript" src="/assets/js/moment.timezone.js"></script> -->

<!-- <script type="text/javascript" src="/assets/js/ax5ui/ax5ui-kernel/dist/ax5ui.all.min.js"></script> -->
<!-- <script type="text/javascript" src="/assets/js/subcommon.js"></script>
<script type="text/javascript" src="/assets/js/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="/assets/js/axisj/dist/AXJ.coremin.js"></script>
<script type="text/javascript" src="/assets/js/axisj/lib/AXTab.js"></script> -->

<!-- <script type="text/javascript" src="/assets/js/common.js"></script> -->
<!-- <script type="text/javascript" src="/assets/js/layout.js"></script> -->
<!--[if lt IE 9]>
<script type="text/javascript" src="/assets/js/html5shiv.min.js"></script>
<![endif]-->
  
<!-- <script type="text/javascript" src="/assets/js/jqueryAjax.js" charset='utf-8'></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script> -->

<script type="text/javascript" src="/assets/js/commonGridUtil.js" charset='utf-8'></script>
<script type="text/javascript" src="/assets/js/commonTextUtil.js" charset='utf-8'></script>
<script type="text/javascript" src="/assets/js/jqueryAjax.js" charset='utf-8'></script>
<script type="text/javascript" src="/assets/js/jquery.form.js" charset='utf-8'></script>

<script type="text/javascript" src="/assets/js/summernote-bs4.js"></script>
<!-- include summernote-ko-KR -->
<script src="/assets/js/summernote-ko-KR.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	
	/* $('.summernote').summernote({
	  height: 250,
	  followingToolbar: false,
	  lang: 'ko-KR' // default: 'en-US'
	}); */
	
	$('.summernote').summernote({
		toolbar: [],
	});
	
	$('.summernote').summernote('disable');
	//$('.summernote').css("background-color", "white");
	
	$("#btnSave").click(function() {
		fn_save();
	});
	
});

function fileDownlaod() {
	$.download('fileDownload.do?fileName=${att_name}&org_file_name=${org_att_name}',null,'post' );
}

//폼데이터를 Json Arry로 직렬화
function fn_getFormData(form) {
    var unindexed_array = $(form).serializeArray();
    var indexed_array = {};
	
    $.map(unindexed_array, function(n, i){
        indexed_array[n['name']] = n['value'];
    });
	
    return indexed_array;
};

function fn_save() {
	
	var rnt = true;
	
	<c:forEach var="que" items="${queList}" varStatus="status">
	if($('input[name="radioTxt${que.PK}"]:checked').val() != "${que.ANSWER}") {
		rnt = false;
	} 
	</c:forEach>
	
	if(!rnt) {
		alert( "틀린 문제가 있습니다.\n다시 확인해 주십시오." );
		return false;
	}
	
	if($("#description_use").val() == 'Y') {
		if($("#p_descript").val() == '') {
			alert("교육의견이 누락되었습니다.");
			return false;
		}
	}
	
	var formData = fn_getFormData('#application_form');
	//사용자 첨부파일 사용시
	/* var form = $('#application_form')[0]; 
	var formData = new FormData(form); */
	
	//var file = $("#fileImg").val().toLowerCase();
	
	//if(isImageFile(file)){
		//ajax 호출
	    if ( confirm( '제출 하시겠습니까?' ) != 0 ) {
	    	$.ajax({
				url         :   "eduUserSave.do",
				dataType    :   "json",
				contentType :   "application/x-www-form-urlencoded; charset=UTF-8",
				// 사용자 첨부파일 사용시
				//contentType : 	false,
	            //processData : 	false,
				type        :   "post",
				data        :   formData,
				success     :   function(data){
		           	alert(data.resultMsg);
		   			if ( data.result == 'success' ) {
		   				location.href = "eduUserAgree.do?edu_pk=" + $("#edu_pk").val();
		   			}
				},
		        error       :   function(request, status, error) {
		        	alert( "시스템 오류입니다.\n전산담당자에게 문의해주세요." );
		           	location.href = "eduUser.do?edu_pk=" + $("#edu_pk").val();
				}
			});
		}
	/* } else{
		return false;				
	} */
       
}

//엑셀 파일 체크
var isImageFile = function(file){
	if(file == "" || (file.indexOf(".jpg") < 0 && file.indexOf(".jpeg") < 0 && file.indexOf(".bmp") < 0 && file.indexOf(".gif") < 0 && file.indexOf(".png") < 0)) {
		alert("이미지 파일만 업로드 가능합니다.");
		return false;
	}else{
		return true;
	}
};
</script>

</head>
<body>
    <form id="application_form" name="application_form" enctype="multipart/form-data" method="post">
        <input type="hidden" id="edu_pk" name="edu_pk" value="${edu_pk }" />
        <input type="hidden" id="description_use" name="description_use" value="${description_use}" />
        <!-- 메뉴바 -->
        <jsp:include page="/userHeader.do" flush="true"></jsp:include>
        <!-- 메뉴바/ -->
        <!-- 가운데 잡아줌 -->
        <div class="doc-wrap" id="docBaseWrap">
            <div class="layout-LW" style="width:60%;">
                <!-- 좌측 -->
                <div class="left" style="width:100%;">
                    <!-- 1번표 -->
                    <col style="width:100px" />
                    <col />
                    <h2 class="subpage-tit"><spring:message code='label.eduUser1'/></h2>
                    <table  class="bWrite">
                        <tbody id="second_table_2">
                            <tr>
                                <th><spring:message code='label.eduUser2'/></th>
                                <td style="text-align: left;">${edu_subject }</td>
                            </tr>
                            <tr>
                                <th><spring:message code='label.eduUser3'/></th>
                                <td style="text-align: left;">${start_date }</td>
                            </tr>
                            <tr>
                                <th><spring:message code='label.eduUser4'/></th>
                                <td style="text-align: left;">${instructor }</td>
                            </tr>
                            <tr>
                                <th><spring:message code='label.eduUser5'/></th>
                                <td style="text-align: left;">${time} <spring:message code='label.eduUser11'/></td>
                            </tr>
                            <tr>
                                <th><spring:message code='label.eduUser6'/></th>
                                <td class="download"><a href="javascript:fileDownlaod();">${org_att_name}</a></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <!-- 가운데 잡아줌// -->
                <div class="left_2" style="width:100%;">
                    <table class="bWrite" >
                        <tbody>
                            <div class="quiz">
                                <h2 class="subpage-tit"><spring:message code='label.eduUser7'/></h2>
                            </div>
                        </tbody>
                    </table>
                </div>
                <table class="bWrite" style="width:100%;">
                    <tbody>
                        <tr>
                            <td style="text-align: left;">
                                <div class="summernote">${edu_content}</div>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <div class="left_2" style="width:100%;">
                    <table class="bWrite">
                        <tbody>
                            <div class="quiz">
                                <h2 class="subpage-tit"><spring:message code='label.eduUser8'/></h2>
                                <br/>(올바른 답변이 아닌 경우 교육수료가 되지 않으니 내용을 다시 확인하시기 바랍니다)
                            </div>
                        </tbody>
                    </table>
                </div>
                <table class="bWrite" style="width:100%;">
                    <tbody>
                        <div class="left_3" style="width:100%;">
                            <div class="quiz_conteiner">
                                <div class="quoz_conteiner_start">
                                    <c:forEach var="que" items="${queList}" varStatus="status">
                                        <div class="quoz_1">
                                            <p>${status.count}. ${que.SUBJECT}</p>
                                            <div class="quoz_sort">
                                                <c:forEach var="ans" items="${ansList}" varStatus="ansStatus">
                                                    <c:if test="${que.PK == ans.QUE_PK}">
                                                        <input type="radio" name="radioTxt${que.PK}" value="${ans.NUM}" style="cursor: pointer;"/>
                                                        <p>${ans.SUBJECT}</p>
                                                    </c:if>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                        </div>
                    </tbody>
                </table>
                
                <c:if test="${description_use == 'Y' }">
	                <div class="left_2" style="width:100%;">
	                    <table class="bWrite" >
	                        <tbody>
	                            <div class="quiz">
	                                <h2 class="subpage-tit"><spring:message code='label.eduUser9'/></h2>
	                            </div>
	                            ${edu_descript }
	                        </tbody>
	                    </table>
	                </div>
	                
	             
	                <table class="bWrite" style="width:100%;">
	                    <tbody>
	                        <tr>
	                            <td style="text-align: left;">
	                                <textarea id="p_descript" name="p_descript"></textarea>
	                            </td>
	                        </tr>
	                    </tbody>
	                </table>
                </c:if>
                <div class="left_3" style="width:100%;">
	                <a class="button_education bc1" style="color: #fff; height: 30px;" id="btnSave"><i class="w_reply"></i> 
	                	<spring:message code='label.eduUser10'/>
	                </a>
	              </div>
	              <div style="height:60px; width:60%;">
	              </div>
                
                
	            <!-- <div class="left_2" style="width:30%;">
                    <table class="bWrite" >
                        <tbody>
                            <div class="quiz">
                                <h2 class="subpage-tit">교육 완료 사진</h2>
                            </div>
                        </tbody>
                    </table>
                </div>
                <table class="bWrite" style="width:60%;">
                    <tbody>
                        <tr>
                            <td style="text-align: left;">
                                <input type="file" name="fileName" id="fileImg" size="100" multiple />
                            </td>
                        </tr>
                    </tbody>
                </table> -->
                
            </div>  
        </div>
         
    </form>
</body>
</html>