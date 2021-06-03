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

<!-- <link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script> 
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script> --> 

<!-- include jquery -->
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.13.0/moment.min.js"></script>

<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.min.css" rel="stylesheet"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
<link rel="stylesheet" href="/assets/css/summernote-bs4.css">

<!-- 커스텀이에요 -->
<link rel="stylesheet" type="text/css" href="assets/css/custom.css"/>
<!-- 커스텀이에요 -->

<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.8.2/moment-with-locales.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.min.js"></script>

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
		toolbar: [],
		height: 250
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
		location.href = "edu.do";
	});
	
	$("#btnDel").click(function(){
		fn_del();
	});
	
	$("#btnGoQue").click(function(){
		fn_goQue();
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
		
		if( $("input:checkbox[id='description_use_chk']").is(":checked") ) {
			$("#p_description_use").val('Y');
		} else {
			$("#p_description_use").val('N');
		}
		
		var form = $('#application_form')[0]; 
		var formData = new FormData(form);
        
      	//ajax 호출
        if ( confirm( '<spring:message code="label.eduDetail2"/>' ) != 0 ) {
	        $.ajax({
	            url         :   "eduSave.do",
	            dataType    :   "json",
	            contentType : 	false,
	            processData : 	false,
	            type        :   "post",
	            data        :   formData,
	            success     :   function(data){
	            	alert(data.resultMsg);
	    			if ( data.result == 'success' ) {
	    				location.href = "edu.do";
	    			}
	            },
	            error       :   function(request, status, error){
	            	alert( "<spring:message code='label.eduDetail3'/>" );
	            	location.href = "eduDetail.do";
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
            url         :   "eduDel.do",
            dataType    :   "json",
            contentType :   "application/x-www-form-urlencoded; charset=UTF-8",
            type        :   "post",
            data        :   formData,
            success     :   function(data){
            	alert(data.resultMsg);
    			if ( data.result == 'success' ) {
    				location.href = "edu.do";
    			}
            },
            error       :   function(request, status, error){
            	alert( "<spring:message code='label.eduDetail3'/>" );
            	location.href = "eduDetail.do";
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
	
	if($("#p_instructor").val() == '') {
		alert("<spring:message code='label.eduDetail7'/>");
		rnt = false;
		return false;
	}
	
	if($("#p_end_date").val() == '') {
		alert("<spring:message code='label.eduDetail6'/>");
		rnt = false;
		return false;
	}
	
	if($("#p_dept_cd").val() == '') {
		alert("<spring:message code='label.eduDetail8'/>");
		rnt = false;
		return false;
	}
	
	if($("#p_time").val() == '') {
		alert("<spring:message code='label.eduDetail9'/>");
		rnt = false;
		return false;
	}
	
	if($("#p_content").val() == '<p><br></p>') {
		alert("<spring:message code='label.eduDetail10'/>");
		rnt = false;
		return false;
	}
	
	if($("#p_agree_title").val() == '') {
		alert("<spring:message code='label.eduDetail11'/>");
		rnt = false;
		return false;
	}
	
	if($("#p_agree").val() == '') {
		alert("<spring:message code='label.eduDetail12'/>");
		rnt = false;
		return false;
	}
	
	return rnt;
}

function showPopup() {
	window.open("eduPopup.do", "<spring:message code='label.eduDetail17'/>", "width=1100, height=590, left=300, top=50"); 
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
	
function fileDownlaod() {
	$.download('fileDownload.do?fileName=${att_name}&org_file_name=${org_att_name}',null,'post' );
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
<textarea style="display: none;" id="p_content" name="p_content"></textarea>
<textarea style="display: none;" id="p_agree" name="p_agree"></textarea>
    
    <!-- 메뉴바 -->
    <jsp:include page="/eduHeader.do" flush="true"></jsp:include>
    <!-- 메뉴바/-->
    
    <!-- 우측 --> 
    <div class="right" style="width:923px;">
        <table class="bWrite">
            <div class="layout-LW">
                <h2 class="subpage-tit"><spring:message code="label.eduDetail13"/></h2>
                <tbody>
                    <tr>
                        <th><spring:message code="label.eduDetail14"/><div class="helper"></div><span class="important">*</span></th>
                        <td><input type="text" id="p_subject" name="p_subject" value="${subject}" class="w100" /></td>
                    </tr>
                    <tr>
                        <th><spring:message code="label.eduDetail15"/><div class="helper"></div><span class="important">*</span></th>
                        <td id="calendar_left">
                            <input type="tel" id="p_start_date" name="p_start_date" autocomplete=off value="${start_date}" class="calendar" placeholder="" />
                            <samp>&nbsp;~&nbsp;</samp>
                            <input type="tel" id="p_end_date" name="p_end_date" autocomplete=off value="${end_date}" class="calendar" placeholder="" />
                        </td>
                    </tr>
                    
                    <tr>
                        <th><spring:message code="label.eduDetail16"/><div class="helper"></div><span class="important">*</span></th>
                        <td><input type="text" id="p_instructor" name="p_instructor" value="${instructor}" class="w100" /></td>
                    </tr>
                    
                    <tr>
                        <th><spring:message code="label.eduDetail17"/><div class="helper"></div><span class="important">*</span></th>
                        <td>
                        	<input type="button" value="<spring:message code='label.eduDetail28'/>" onclick="showPopup();" />
                        	<input type="button" value="<spring:message code='label.eduDetail30'/>" onclick="initDept();" /><br/>
                        	<div id="p_dept" name="p_dept">${dept_nm }</div>
                        </td>
                    </tr>
                    
                    <tr>
                        <th><spring:message code="label.eduDetail18"/><div class="helper"></div><span class="important">*</span></th>
                        <td style="text-align: left;">
                        <input type="text" id="p_time" name="p_time" value="${time}" class="w100" /><spring:message code="label.eduDetail29"/></td>
                    </tr>
                    
                    <tr>
                        <th><spring:message code="label.eduDetail19"/><div class="helper"></div><span class="important">*</span></th>
                        <td style="text-align: left;">
                            <div class="summernote">${content}</div> 
                        </td>    
                    </tr>
                    
                    
                    <tr>
                        <th><spring:message code="label.eduDetail20"/><div class="helper"></div><span class="important">*</span></th>
                        <td><input type="text" id="p_agree_title" name="p_agree_title" value="${agree_title}" class="w100" /></td>
                    </tr>
                    <tr>
                        <th><spring:message code="label.eduDetail21"/><div class="helper"></div><span class="important">*</span></th>
                        <td style="text-align: left;">
                            <%-- <textarea id="p_agree" name="p_agree">${agree}</textarea> --%>
                            <div class="summernote" id="p_agree_summernote">${agree}</div>
                        </td>
                    </tr>
                    
                    <tr>
                        <th><spring:message code="label.eduDetail31"/></th>
						<td><input type="text" id="p_descript" name="p_descript" value="${descript}" class="w100" /></td>
                    </tr>
                    <tr>
                        <th><spring:message code="label.eduDetail22"/></th>
                        <td style="text-align: left;">
                            <input type="checkbox" id="description_use_chk" name="description_use_chk" <c:if test="${description_use == 'Y' }">checked</c:if > />
                        </td>
                    </tr>
                    
                    <tr>
                        <th><spring:message code="label.eduDetail23"/></th>
                        <td style="text-align: left;">
                        	<a href="javascript:fileDownlaod();">${org_att_name}</a>
                        </td>
                    </tr>
                </tbody>
            </div>
        </table>
        <div id="conteiner_button_1">
            <!-- <a class="button"><i class="w_up"></i>파일업로드</a>
            <input type="text" id="" class="w100"/> -->
            <input type="file" name="fileName" id="fileExl" size="51" multiple />
        </div>
        <div id="conteiner_button_2" name="conteiner_button">
            <a class="button bc1" id="btnSave"><i class="w_save"></i><spring:message code="label.eduDetail24"/></a>
            <c:if test="${edu_pk != '' }">
            	<a class="button bc1" id="btnDel"><i class="w_minus"></i><spring:message code="label.eduDetail25"/></a>
            	<a class="button" id="btnGoQue"><i class="w_plus"></i><spring:message code="label.eduDetail26"/></a>
            </c:if>
            <a class="button" id="btnCancel"><i class="w_cancel"></i><spring:message code="label.eduDetail27"/></a>
        </div>
    </div>
    </div>
    <!-- // 우측 -->
</form>    
</body>
</html>