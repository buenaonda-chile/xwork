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

<title><spring:message code="label.edutitle"/></title>

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

<!-- 웹에디터 -->
<!-- <link rel="stylesheet" type="text/css" href="assets/js/widgEditor_1.0.1/css/info.css";> -->
<!-- <link rel="stylesheet" type="text/css" href= "assets/js/widgEditor_1.0.1/css/main.css";> -->
<!-- <link rel="stylesheet" type="text/css" href= "/assets/js/widgEditor_1.0.1/css/widgEditor.css";> -->
<!-- 웹에디터/ -->



<!-- <link rel="stylesheet" type="text/css" href="assets/css/info.css"/>
<link rel="stylesheet" type="text/css" href="assets/css/main.css"/>
<link rel="stylesheet" type="text/css" href="assets/css/widgEditor.css"/> -->


<!-- <script type="text/javascript" src="/assets/js/underscore/underscore-min.js"></script>
<script type="text/javascript" src="/assets/js/backbone/backbone-min.js"></script> -->

<!-- <script type="text/javascript" src="/assets/js/libphonenumber-js.min.js"></script>
<script type="text/javascript" src="/assets/js/moment.min.js"></script>
<script type="text/javascript" src="/assets/js/moment.timezone.js"></script> -->

<!-- <script type="text/javascript" src="/assets/js/subcommon.js"></script>
<script type="text/javascript" src="/assets/js/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="/assets/js/axisj/dist/AXJ.coremin.js"></script>
<script type="text/javascript" src="/assets/js/axisj/lib/AXTab.js"></script> -->

<!-- <script type="text/javascript" src="/assets/js/common.js"></script>
<script type="text/javascript" src="/assets/js/layout.js"></script> -->


<!-- include jquery -->
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.13.0/moment.min.js"></script>

<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.min.css" rel="stylesheet"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
<link rel="stylesheet" href="/assets/css/summernote-bs4.css">

<!-- 커스텀이에요 -->
<link rel="stylesheet" type="text/css" href="/assets/css/custom.css"/>
<!-- 커스텀이에요 -->

<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.8.2/moment-with-locales.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.min.js"></script>

<!-- 달력 디자인 사용못함 썸머노트때문에 사용 불가 
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script> 
-->


<!-- include libs stylesheets -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<!-- <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.43/css/bootstrap-datetimepicker.min.css" />
<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.43/js/bootstrap-datetimepicker.min.js"></script> -->

<script type="text/javascript" src="/assets/js/commonGridUtil.js" charset='utf-8'></script>
<script type="text/javascript" src="/assets/js/commonTextUtil.js" charset='utf-8'></script>
<script type="text/javascript" src="/assets/js/jqueryAjax.js" charset='utf-8'></script>
<script type="text/javascript" src="/assets/js/jquery.form.js" charset='utf-8'></script>

<script type="text/javascript" src="/assets/js/summernote-bs4.js"></script>
<!-- include summernote-ko-KR -->
<script src="/assets/js/summernote-ko-KR.js"></script>
<script src="/assets/js/summernote-ja-JP.js"></script>

<!--[if lt IE 9]>
	<script type="text/javascript" src="assets/js/html5shiv.min.js"></script>
<![endif]-->

<script type="text/javascript">

$(function(){
	$('#p_start_date').datepicker({
		calendarWeeks: false,
		todayHighlight: true,
		autoclose: true,
		format: "yyyy-mm-dd",
		language: "kr"
	});
	
     $('#p_end_date').datepicker({
    	calendarWeeks: false,
		todayHighlight: true,
 		autoclose: true,
 		format: "yyyy-mm-dd",
 		language: "kr"		    	
 	});
	
 	
});

$(document).ready(function(){
	
	$('#p_agree_summernote').summernote({
		toolbar: [
		    // [groupName, [list of button]]
		    ['fontname', ['fontname']],
		    ['fontsize', ['fontsize']],
		    ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
		    ['color', ['forecolor','color']],
		    ['table', ['table']],
		    ['para', ['ul', 'ol', 'paragraph']],
		    ['height', ['height']],
		    ['insert',['picture','link','video']],
		    ['view', ['fullscreen', 'help']]
		  ],
		fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋음체','바탕체'],
		fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72'],
	
		followingToolbar: true,
		height: 500,	
		width : 1150,
		lang: 'ko-KR'
	});
	
	$('.summernote').summernote({
	  height: 250,
	  followingToolbar: true,
	  lang: 'ko-KR' // default: 'en-US' lang: 'ja-JP' 
	});
	
	$("#btnSave").click(function() {
		fn_save();
	});
	
	$("#btnCancel").click(function(){
		location.href = "salary.do";
	});
	
	$("#btnDel").click(function(){
		fn_del();
	});
	
	$("#btnGoQue").click(function(){
		fn_goQue();
	});
	
	$("#p_imagecours").val('');
	
	// edu_pk가 존재하면 첨부파일 리스트 취득 표시
	if($("#edu_pk").val() != null){
		fn_selectFile($("#edu_pk").val());
	}
	
	
	
	var fileTarget = $('.filebox .upload-hidden');
	fileTarget.on('change', function(){ // 값이 변경되면

		if(window.FileReader){ // modern browser

            var temp = $(this)[0].files;
            for (var i=0; i<temp.length; i++) {

                var filename = temp[i].name;

                var file = temp[i];

                var formData = new FormData();
                formData.append("file", file);

                // 파일 업로드 AJAX 통신
                fn_upload(formData);
			}

		} else { // old IE
			var filename = $(this).val().split('/').pop().split('\\').pop(); // 파일명만 추출

            var file = $(this)[0].files[0];

            var formData = new FormData();
            formData.append("file", file);

            // 파일 업로드 AJAX 통신
            fn_upload(formData);
		}
	});
});

function fn_save() {
	
	var result = true;
	var message = "";
	
	// Editor 저장
	$("#p_content").val($('.summernote').summernote('code'));
	$("#p_agree").val($('#p_agree_summernote').summernote('code'));
	
	if(uniqeValidation()) {
		
		var strDate1 = $("#p_start_date").val();
	    var strDate2 = $("#p_end_date").val();
	    
		if(strDate1 != '' && strDate2 != '') {
	    	
	    	var arr1 = strDate1.split('-');
		    var arr2 = strDate2.split('-');
		    
		    var dat1 = new Date(arr1[0], arr1[1], arr1[2]);
		    var dat2 = new Date(arr2[0], arr2[1], arr2[2]);
		    
		    if(dat1.getTime() > dat2.getTime()) {
		    	result = false;
		    	message = "<spring:message code='label.eduDetail1'/>";
		    	$("#p_end_date").focus();
		    }
		}
		
		if (!result) {
	    	alert(message);
	    	return false;
	    }
		
		// 사용자의견 체크
		/* if( $("input:checkbox[id='description_use_chk']").is(":checked") ) {
			$("#p_description_use").val('Y');
		} else {
			$("#p_description_use").val('N');
		} */
		
		// 일본인출향자 체크
		var emp_type_jp_chk = $(":input:radio[name=emp_type_jp_chk]:checked").val();
		$("#p_emp_type_jp").val(emp_type_jp_chk);
		

		// 기능직 체크
		var emp_type_step_chk = $(":input:radio[name=emp_type_step_chk]:checked").val();
		$("#p_emp_type_step").val(emp_type_step_chk);
		
		
		// 승격용 연봉계약 체크 (2021년 1월 14일 추가)
		var emp_type_promotion = $(":input:radio[name=emp_type_promotion]:checked").val();
		$("#p_emp_type_promotion").val(emp_type_promotion);

		
		var form = $('#application_form')[0]; 
		var formData = new FormData(form);
		formData.append("폼요소",  "폼값");
        
      	//ajax 호출
        if ( confirm( '<spring:message code="label.eduDetail2"/>' ) != 0 ) {
	        $.ajax({
	            url         :   "salarySave.do",
	            dataType    :   "json",
	            contentType : 	false,
	            processData : 	false,
	            type        :   "post",
	            data        :   formData,
	            success     :   function(data){
	            	alert(data.resultMsg);
	    			if ( data.result == 'success' ) {
	    				location.href = "salary.do";
	    			}
	            },
	            error       :   function(request, status, error){
	            	//alert( error );
	            	alert( "<spring:message code='label.eduDetail3'/>" );
	            	location.href = "salaryDetail.do";
	            }
	        });
        }
	}
}

function fn_del() {
	
	var formData = fn_getFormData('#application_form');
	
	//ajax 호출
    if ( confirm( '<spring:message code="label.eduDetail4"/>' ) != 0 ) {
        $.ajax({
            url         :   "salaryDel.do",
            dataType    :   "json",
            contentType :   "application/x-www-form-urlencoded; charset=UTF-8",
            type        :   "post",
            data        :   formData,
            success     :   function(data){
            	alert(data.resultMsg);
    			if ( data.result == 'success' ) {
    				location.href = "salary.do";
    			}
            },
            error       :   function(request, status, error){
            	alert( "<spring:message code='label.eduDetail3'/>" );
            	location.href = "salaryDetail.do";
            }
        });
    }
	
}

function fn_goQue() {
	location.href = "que.do?edu_pk=" + $("#edu_pk").val();
}

//필수 항목 Validation
var uniqeValidation = function(){
	var rnt = true;
	
	if($("#p_subject").val() == '') {
		alert("<spring:message code='label.eduDetail5'/>");
		rnt = false;
		return false;
	}
	
	if($("#p_start_date").val() == '') {
		alert("<spring:message code='label.eduDetail6'/>");
		rnt = false;
		return false;
	}
	
	if($("#p_end_date").val() == '') {
		alert("<spring:message code='label.eduDetail6'/>");
		rnt = false;
		return false;
	}
	
	/* if($("#p_instructor").val() == '') {
		alert("<spring:message code='label.eduDetail7'/>");
		rnt = false;
		return false;
	} */
	
	/* if($("#p_end_date").val() == '') {
		alert("<spring:message code='label.eduDetail6'/>");
		rnt = false;
		return false;
	} */
	
	/* if($("#p_dept_cd").val() == '') {
		alert("<spring:message code='label.eduDetail8'/>");
		rnt = false;
		return false;
	} */
	
	/* if($("#p_time").val() == '') {
		alert("<spring:message code='label.eduDetail9'/>");
		rnt = false;
		return false;
	}
	
	if($("#p_content").val() == '<p><br></p>') {
		alert("<spring:message code='label.eduDetail10'/>");
		rnt = false;
		return false;
	} */
	
	/* if($("#p_agree_title").val() == '') {
		alert("<spring:message code='label.eduDetail11'/>");
		rnt = false;
		return false;
	} */
	
	if($("#p_agree").val() == '') {
		alert("<spring:message code='label.eduDetail12'/>");
		rnt = false;
		return false;
	}
	
	return rnt;
}

function showPopup() {
	window.open("salaryPopup.do", "<spring:message code='label.eduDetail17'/>", "width=1100, height=590, left=300, top=50"); 
}

function initDept() {
	$("#p_dept_cd").val('');
	$("#p_dept_name").val('');
	$("#p_dept").text(''); 
}

$.fn.datepicker.dates['kr'] = {
		days: ["<spring:message code='label.eduCalendar24'/>", "<spring:message code='label.eduCalendar25'/>", 
			"<spring:message code='label.eduCalendar26'/>", "<spring:message code='label.eduCalendar27'/>", 
			"<spring:message code='label.eduCalendar28'/>", "<spring:message code='label.eduCalendar29'/>",
			"<spring:message code='label.eduCalendar30'/>"],
		daysShort: ["<spring:message code='label.eduCalendar17'/>", "<spring:message code='label.eduCalendar18'/>", 
			"<spring:message code='label.eduCalendar19'/>", "<spring:message code='label.eduCalendar20'/>", 
			"<spring:message code='label.eduCalendar21'/>", "<spring:message code='label.eduCalendar22'/>",
			"<spring:message code='label.eduCalendar23'/>"],
		daysMin: ["<spring:message code='label.eduCalendar17'/>", "<spring:message code='label.eduCalendar18'/>", 
			"<spring:message code='label.eduCalendar19'/>", "<spring:message code='label.eduCalendar20'/>", 
			"<spring:message code='label.eduCalendar21'/>", "<spring:message code='label.eduCalendar22'/>",
			"<spring:message code='label.eduCalendar23'/>"],
		months: ["<spring:message code='label.eduCalendar5'/>", "<spring:message code='label.eduCalendar6'/>",
			"<spring:message code='label.eduCalendar7'/>", "<spring:message code='label.eduCalendar8'/>",
			"<spring:message code='label.eduCalendar9'/>", "<spring:message code='label.eduCalendar10'/>",
			"<spring:message code='label.eduCalendar11'/>", "<spring:message code='label.eduCalendar12'/>",
			"<spring:message code='label.eduCalendar13'/>", "<spring:message code='label.eduCalendar14'/>",
			"<spring:message code='label.eduCalendar15'/>", "<spring:message code='label.eduCalendar16'/>"],
		monthsShort: ["<spring:message code='label.eduCalendar5'/>", "<spring:message code='label.eduCalendar6'/>",
			"<spring:message code='label.eduCalendar7'/>", "<spring:message code='label.eduCalendar8'/>",
			"<spring:message code='label.eduCalendar9'/>", "<spring:message code='label.eduCalendar10'/>",
			"<spring:message code='label.eduCalendar11'/>", "<spring:message code='label.eduCalendar12'/>",
			"<spring:message code='label.eduCalendar13'/>", "<spring:message code='label.eduCalendar14'/>",
			"<spring:message code='label.eduCalendar15'/>", "<spring:message code='label.eduCalendar16'/>"]
	};
	
	
	
	
//파일 업로드
function fn_upload(formData){
	
    $.ajax({
		url: "attachFileUpload.do?edu_pk="+$("#edu_pk").val(),
		dataType: "json",
		data: formData,
		type: "POST",
		//multipart/form-data 방식으로 넘겨야 하기에 false
		processData: false,
		contentType: false,
		error: function () {
			alert('시스템 오류입니다.\n전산담당자에게 문의해주세요.');
		},
		//이 파라미터를 넣으면 비동기에서 동기화로 바뀝니다.
        async:false,
		success: function (data) {
		    console.log("1 : "+data)
            console.log("1 : "+JSON.stringify(data));
		    if ( data.result == 'fail' ) {
				alert("첨부파일 업로드 실패");
			} else {
				fn_printFile(data);
				$("#p_imagecours").val(data.edu_pk);
			}
		}

	});
}

//파일목록 추가
function fn_printFile(data){

    console.log("fn_printFile : "+data);
    
    var str = "";
    var del_link = "javascript:fn_deleteFile(" + data.edu_pk +","+data.pk +");";
    str = "<br><li class='file_list' id='li_" + data.pk + "' >"
   		 + "<a href='/fileDownload.do?fileName=" + data.file_name + "&org_file_name=" + encodeURI(data.org_file_name) + "' target='_blank'>" 
    	+  data.org_file_name + "</a>" +
        "<br><input type='button' value='삭제' onclick='" + del_link + "'/></li><br>";
        
    $("#file_list").append(str);
}


//파일목록 삭제
function fn_printFileDel(pk){
    $("#li_" +pk).remove();
    $(".filebox").val('');
    $(".upload-hidden").val('');
}

//파일 목록 조회
function fn_selectFile(edu_pk){
	var formData = null;

	$.ajax({
		url: "searchFileDataList.do?edu_pk="+edu_pk,
		data: formData,
		dataType: "json",
		type: "POST",
		error: function () {
			alert('시스템 오류입니다.\n전산담당자에게 문의해주세요.');
		},
		success: function (data) {

			if ( data.result == 'fail' ) {
				alert("첨부파일 조회 실패");
			} else {
			    // 목록 표시
                for (var i = 0; i < data.list.length; i++) {
                    var item = data.list[i];
                    $("#p_imagecours").val(item.edu_pk);
                    $('.pk').val(item.pk);
                    fn_printFile(item);
                }
			}
		}
	});
}

//파일 삭제
function fn_deleteFile(edu_pk, pk){
	 var formData = null;

	$.ajax({
		url: "attachFileDelete.do?edu_pk="+edu_pk+"&pk="+pk,
		data: formData,
		dataType: "json",
		type: "POST",
		error: function () {
			alert('시스템 오류입니다.\n전산담당자에게 문의해주세요.');
		},
		success: function (data) {
			//alert("data.result : " + data.result);
			if ( data.result == 'fail' ) {
				alert("첨부파일 삭제 실패");
			} else {
                fn_printFileDel(pk);
			}
		}
	});
}

</script>

<style>

.note-editor.note-frame.card {
	width: 823px;
}

</style>

</head>
<body>
<form id="application_form" name="application_form" enctype="multipart/form-data" method="post">
<input type="hidden" id="edu_pk" name="edu_pk" value="${edu_pk}" />
<input type="hidden" id="p_dept_cd" name="p_dept_cd" value="${dept}" />
<input type="hidden" id="p_dept_name" name="p_dept_name" value="${dept_nm}" />
<input type="hidden" id="p_description_use" name="p_description_use" value="" />
<input type="hidden" id="p_emp_type_jp" name="p_emp_type_jp" value="" />
<input type="hidden" id="p_emp_type_step" name="p_emp_type_step" value="" />
<input type="hidden" id="p_emp_type_promotion" name="p_emp_type_promotion" value="" />
<input type="hidden" id="p_imagecours" name="p_imagecours" value="" />
<textarea style="display: none;" id="p_content" name="p_content"></textarea>
<textarea style="display: none;" id="p_agree" name="p_agree"></textarea>
    
    <!-- 메뉴바 -->
    <jsp:include page="/salary/salaryHeader.do" flush="true"></jsp:include>
    <!-- 메뉴바/-->
    
    <!-- 우측 --> 
    <div class="right" style="width:1300px;">
        <table class="bWrite">
            <div class="layout-LW">
                <h2 class="subpage-tit">연봉상세</h2>
                <tbody>
                    <tr>
                        <th>제목<div class="helper"></div><span class="important">*</span></th>
                        <td><input type="text" id="p_subject" name="p_subject" value="${subject}" class="w100" /></td>
                    </tr>
                    <tr>
                        <th>기간<div class="helper"></div><span class="important">*</span></th>
                        <td id="calendar_left">
                            <input type="tel" id="p_start_date" name="p_start_date" autocomplete=off value="${start_date}" class="calendar" placeholder="" />
                            <samp>&nbsp;~&nbsp;</samp>
                            <input type="tel" id="p_end_date" name="p_end_date" autocomplete=off value="${end_date}" class="calendar" placeholder="" />
                        </td>
                    </tr>
                    
                    <%-- <tr>
                        <th><spring:message code="label.eduDetail16"/><div class="helper"></div><span class="important">*</span></th>
                        <td><input type="text" id="p_instructor" name="p_instructor" value="${instructor}" class="w100" /></td>
                    </tr> --%>
                    
                    <tr>
                        <th><spring:message code="label.eduDetail17"/><div class="helper"></div><span class="important">*</span></th>
                        <td>
                        	<input type="button" value="<spring:message code='label.eduDetail28'/>" onclick="showPopup();" />
                        	 <!-- 초기화버튼 신규등록일때만 표시 --> 
                        	 <c:if test="${edu_pk == '' }">
                        		<input type="button" value="<spring:message code='label.eduDetail30'/>" onclick="initDept();" /><br/>
                        	</c:if>
                        	
                        	<div id="p_dept" name="p_dept">${dept_nm }</div>
                        </td>
                    </tr>
                    
                    <tr>
                        <th>구분<div class="helper"></div></th>
                        <td style="text-align: left;">
                        	<input type="radio" id="emp_type_jp_chk" name="emp_type_jp_chk"  value="N" <c:if test="${edu_pk == '' }"> checked </c:if > <c:if test="${emp_type_jp == 'N' }">checked</c:if > <c:if test="${edu_pk != '' }"> disabled </c:if > />일본인 출향자 제외 
                        	<input type="radio" id="emp_type_jp_chk" name="emp_type_jp_chk"  value="Y" <c:if test="${emp_type_jp == 'Y' }">checked</c:if > <c:if test="${edu_pk != '' }"> disabled </c:if > />일본인 출향자 전용 <br/>
                        	<input type="radio" id="emp_type_step_chk" name="emp_type_step_chk"  value="N" <c:if test="${edu_pk == '' }"> checked </c:if > <c:if test="${emp_type_step == 'N' }">checked</c:if > <c:if test="${edu_pk != '' }"> disabled </c:if > />연봉직
                        	<input type="radio" id="emp_type_step_chk" name="emp_type_step_chk"  value="Y" <c:if test="${emp_type_step == 'Y' }">checked</c:if > <c:if test="${edu_pk != '' }"> disabled </c:if > /> 기능직 <br/>
                        	<%-- 일반 승격 추가 2021년 1월 14일 --%>
                        	<input type="radio" id="emp_type_promotion" name="emp_type_promotion"  value="N" <c:if test="${edu_pk == '' }"> checked </c:if > <c:if test="${emp_type_promotion == 'N' }">checked</c:if > <c:if test="${edu_pk != '' }"> disabled </c:if > />일반연봉계약
                        	<input type="radio" id="emp_type_promotion" name="emp_type_promotion"  value="Y" <c:if test="${emp_type_promotion == 'Y' }">checked</c:if > <c:if test="${edu_pk != '' }"> disabled </c:if > />승격연봉계약<br/>
                        </td>
                        
                    </tr>
                    
                    <%-- <tr>
                        <th><spring:message code="label.eduDetail18"/><div class="helper"></div><span class="important">*</span></th>
                        <td style="text-align: left;">
                        <input type="text" id="p_time" name="p_time" value="${time}" class="w100" /><spring:message code="label.eduDetail29"/></td>
                    </tr> --%>
                    
                   <%-- <tr>
                        <th><spring:message code="label.eduDetail19"/><div class="helper"></div><span class="important">*</span></th>
                        <td style="text-align: left;">
                            <div class="summernote">${content}</div> 
                        </td>    
                    </tr>
                     --%>
                    
                  <%--   <tr>
                        <th><spring:message code="label.eduDetail20"/><div class="helper"></div><span class="important">*</span></th>
                        <td><input type="text" id="p_agree_title" name="p_agree_title" value="${agree_title}" class="w100" /></td>
                    </tr> --%>
                    <tr>
                        <th>연봉계약서<div class="helper"></div><span class="important">*</span></th>
                        <td style="text-align: left;">
                            <%-- <textarea id="p_agree" name="p_agree">${agree}</textarea> --%>
                            <%-- <div class="summernote" id="p_agree_summernote">${agree}</div> --%>
<style type="text/css">
.note-editor.note-frame .note-editing-area{width:100%;}
</style>
                            <div class="summernote" id="p_agree_summernote">${agree}</div>
                        </td>
                    </tr>
                    
                    <%-- <tr>
                        <th><spring:message code="label.eduDetail31"/></th>
						<td><input type="text" id="p_descript" name="p_descript" value="${descript}" class="w100" /></td>
                    </tr> --%>
                   <%--  <tr>
                        <th><spring:message code="label.eduDetail22"/></th>
                        <td style="text-align: left;">
                            <input type="checkbox" id="description_use_chk" name="description_use_chk" <c:if test="${description_use == 'Y' }">checked</c:if > />
                        </td>
                    </tr> --%>
                    
                   <%--  <tr>
                        <th><spring:message code="label.eduDetail23"/></th>
                        <td style="text-align: left;">
                       		<div class="filebox">
                       			<!--  <input class="upload-name" value="파일선택" disabled="disabled"/> 
								<label for="file">찾아보기</label>-->
								<input type="file" id="file" name="file"  class="upload-hidden"
								 style="text-align:center; width:400px; height:30px;"
								 multiple/>
                        	</div>
                        	<ul id="file_list"></ul>
                        </td>
                    </tr> --%>
                </tbody>
            </div>
        </table>
        <div id="conteiner_button_2" name="conteiner_button">
            <a class="button bc1" id="btnSave"><i class="w_save"></i><spring:message code="label.eduDetail24"/></a>
            <c:if test="${edu_pk != '' }">
            	<a class="button bc1" id="btnDel"><i class="w_minus"></i><spring:message code="label.eduDetail25"/></a>
            	<%-- <a class="button" id="btnGoQue"><i class="w_plus"></i><spring:message code="label.eduDetail26"/></a> --%>
            </c:if>
            <a class="button" id="btnCancel"><i class="w_cancel"></i><spring:message code="label.eduDetail27"/></a>
        </div>
    </div>
    </div>
    <!-- // 우측 -->
</form>    
</body>
</html>