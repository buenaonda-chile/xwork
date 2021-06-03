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

<title>덴소코리아 &gt; 집체교육</title>

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
<script src="/assets/js/summernote-ja-JP.js"></script>

<!--[if lt IE 9]>
	<script type="text/javascript" src="assets/js/html5shiv.min.js"></script>
<![endif]-->

<script type="text/javascript">

$(function(){
	
// 	$("#p_start_date, #p_end_date").datepicker({
// 		closeText          : '닫기',
//         currentText        : '오늘',
//         dateFormat         : 'yy-mm-dd',
//         prevText           : '이전 달',
//         nextText           : '다음 달',
//         monthNames         : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
//         monthNamesShort    : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
//         dayNames           : ['일','월','화','수','목','금','토'],
//         dayNamesShort      : ['일','월','화','수','목','금','토'],
//         dayNamesMin        : ['일','월','화','수','목','금','토'],
//         showMonthAfterYear : true,
//         buttonImage        : '/images/icon/calendar.gif',
//         buttonImageOnly    : true,
//         changeMonth        : true,
//         changeYear         : true,
//         showButtonPanel    : true			    	
//   	});
	
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
	
	$('.summernote').summernote({
	  height: 250,
	  followingToolbar: true,
	  lang: 'ja-JP' // default: 'en-US'
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
		    	message = "終了日は開始日より後の日付を選択してください。";
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
        if ( confirm( '保存しますか?' ) != 0 ) {
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
	            	alert( "システムエラーです。\nシステム管理者に連絡してください。" );
	            	location.href = "eduDetail.do";
	            }
	        });
        }
	}
}

function fn_del() {
	
	var formData = fn_getFormData('#application_form');
	
	//ajax 호출
    if ( confirm( '削除しますか?' ) != 0 ) {
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
            	alert( "システムエラーです。\nシステム管理者に連絡してください。" );
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
		alert("教育タイトルは必須です。");
		rnt = false;
		return false;
	}
	
	if($("#p_start_date").val() == '') {
		alert("教育期間は必須です。");
		rnt = false;
		return false;
	}
	
	if($("#p_end_date").val() == '') {
		alert("教育期間は必須です。");
		rnt = false;
		return false;
	}
	
	if($("#p_instructor").val() == '') {
		alert("教育講師は必須です。");
		rnt = false;
		return false;
	}
	
	if($("#p_dept_cd").val() == '') {
		alert("教育対象は必須です。");
		rnt = false;
		return false;
	}
	
	if($("#p_time").val() == '') {
		alert("教育時間は必須です。");
		rnt = false;
		return false;
	}
	
	if($("#p_content").val() == '<p><br></p>') {
		alert("教育内容は必須です。");
		rnt = false;
		return false;
	}
	
	if($("#p_agree_title").val() == '') {
		alert("同意書のタイトルは必須です。");
		rnt = false;
		return false;
	}
	
	if($("#p_agree").val() == '') {
		alert("同意書の内容は必須です。");
		rnt = false;
		return false;
	}
	
	return rnt;
}

function showPopup() {
	$("#p_dept_cd").val('');
	$("#p_dept_name").val('');
	window.open("eduPopup.do", "教育対象", "width=1100, height=590, left=300, top=50"); 
}

$.fn.datepicker.dates['kr'] = {
		days: ["日曜日","月曜日","火曜日","水曜日","木曜日","金曜日","土曜日","日曜日"],
		daysShort: ["日", "月", "火", "水", "木", "金", "土", "日"],
		daysMin: ["日", "月", "火", "水", "木", "金", "土", "日"],
		months: ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"],
		monthsShort: ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"]
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
    
    <!-- 메뉴바 -->
    <jsp:include page="/eduHeader.do" flush="true"></jsp:include>
    <!-- 메뉴바/-->
    
    <!-- 우측 --> 
    <div class="right" style="width:923px;">
        <table class="bWrite">
            <div class="layout-LW">
                <h2 class="subpage-tit">教育の詳細</h2>
                <tbody>
                    <tr>
                        <th>教育タイトル<div class="helper"></div><span class="important">*</span></th>
                        <td><input type="text" id="p_subject" name="p_subject" value="${subject}" class="w100" /></td>
                    </tr>
                    <tr>
                        <th>教育期間<div class="helper"></div><span class="important">*</span></th>
                        <td id="calendar_left">
                            <input type="tel" id="p_start_date" name="p_start_date" autocomplete=off value="${start_date}" class="calendar" placeholder="" />
                            <samp>&nbsp;~&nbsp;</samp>
                            <input type="tel" id="p_end_date" name="p_end_date" autocomplete=off value="${end_date}" class="calendar" placeholder="" />
                        </td>
                    </tr>
                    
                    <tr>
                        <th>教育講師<div class="helper"></div><span class="important">*</span></th>
                        <td><input type="text" id="p_instructor" name="p_instructor" value="${instructor}" class="w100" /></td>
                    </tr>
                    
                    <tr>
                        <th>育対象<div class="helper"></div><span class="important">*</span></th>
                        <td><input type="button" value="ポップアップ" onclick="showPopup();" /><br/><div id="p_dept" name="p_dept">${dept_nm }</div></td>
                    </tr>
                    
                    <tr>
                        <th>教育時間<div class="helper"></div><span class="important">*</span></th>
                        <td style="text-align: left;">
                        <input type="text" id="p_time" name="p_time" value="${time}" class="w100" />分</td>
                    </tr>
                    
                    <tr>
                        <th>教育内容<div class="helper"></div><span class="important">*</span></th>
                        <td style="text-align: left;">
                            <div class="summernote">${content}</div> 
                        </td>    
                    </tr>
                    
                    
                    <tr>
                        <th>同意書のタイトル<div class="helper"></div><span class="important">*</span></th>
                        <td><input type="text" id="p_agree_title" name="p_agree_title" value="${agree_title}" class="w100" /></td>
                    </tr>
                    <tr>
                        <th>同意書の内容<div class="helper"></div><span class="important">*</span></th>
                        <td>
                            <textarea id="p_agree" name="p_agree">${agree}</textarea>
                        </td>
                    </tr>
                    
                    <tr>
                        <th>ユーザーのコメント</th>
                        <td style="text-align: left;">
                            <input type="checkbox" id="description_use_chk" name="description_use_chk" <c:if test="${description_use == 'Y' }">checked</c:if > />
                        </td>
                    </tr>
                    
                    <tr>
                        <th>教育資料</th>
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
            <a class="button bc1" id="btnSave"><i class="w_save"></i> 保存</a>
            <c:if test="${edu_pk != '' }">
            	<a class="button bc1" id="btnDel"><i class="w_minus"></i> 削除</a>
            </c:if>
            <a class="button" id="btnGoQue"><i class="w_plus"></i> 問題の登録</a>
            <a class="button" id="btnCancel"><i class="w_cancel"></i> キャンセル</a>
        </div>
    </div>
    </div>
    <!-- // 우측 -->
</form>    
</body>
</html>