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

<link rel="stylesheet" type="text/css" href="assets/css/kendo-reset.css" />
<link rel="stylesheet" type="text/css" href="assets/js/jqgrid-4.6.0/css/ui.jqgrid.css" />
<link rel="stylesheet" type="text/css" href="assets/css/ui.jqgrid-reset.css" />
<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="assets/css/bootstrap-reset.css" />
<link rel="stylesheet" type="text/css" href="assets/css/jquery-ui.css" />
<link rel="stylesheet" type="text/css" href="assets/js/tui-grid/tui-grid.css"/>
<link rel="stylesheet" type="text/css" href="assets/css/tui-grid-reset.css"/>
<link rel="stylesheet" type="text/css" href="assets/js/tui-pagination/tui-pagination.css"/>
<link rel="stylesheet" type="text/css" href="assets/js/tui-tree/tui-tree.css"/>

<!-- 메뉴바 -->
<link rel="stylesheet" type="text/css" href="assets/css/font-awesome.css" />
<link type="text/css" href="assets/js/axisj/ui/arongi/page.css" rel="stylesheet"/>
<link type="text/css" href="assets/js/axisj/ui/arongi/AXJ.min.css" rel="stylesheet">
<link type="text/css" href="assets/js/axisj/axicon/axicon.min.css" rel="stylesheet" />
<link type="text/css" href="assets/css/messageArea.css" rel="stylesheet" />
<link type="text/css" href="assets/css/jquery.mCustomScrollbar.css" rel="stylesheet" />
<link type="text/css" href="assets/css/common.css" rel="stylesheet" />
<link type="text/css" href="assets/css/layout.css" rel="stylesheet" />
<link type="text/css" href="assets/css/main.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="assets/css/font.css"/>
<link rel="stylesheet" type="text/css" href="assets/css/lib.css"/>
<link rel="stylesheet" type="text/css" href="assets/css/sub-layout.css"/>
<link rel="stylesheet" type="text/css" href="assets/css/content.css"/>
<link rel="stylesheet" type="text/css" href="assets/css/template.css"/>
<link rel="stylesheet" type="text/css" href="assets/css/main2018.css"/>
<!-- 메뉴바/ -->

<!-- 웹에디터 -->
<!-- <link rel="stylesheet" type="text/css" href="assets/js/widgEditor_1.0.1/css/info.css";> -->
<!-- <link rel="stylesheet" type="text/css" href= "assets/js/widgEditor_1.0.1/css/main.css";> -->
<link rel="stylesheet" type="text/css" href= "assets/js/widgEditor_1.0.1/css/widgEditor.css";>
<!-- 웹에디터/ -->


<!-- 커스텀이에요 -->
<link rel="stylesheet" type="text/css" href="assets/css/custom.css"/>
<!-- 커스텀이에요 -->
<!-- <link rel="stylesheet" type="text/css" href="assets/css/info.css"/>
<link rel="stylesheet" type="text/css" href="assets/css/main.css"/>
<link rel="stylesheet" type="text/css" href="assets/css/widgEditor.css"/> -->


<script type="text/javascript" src="/assets/js/underscore/underscore-min.js"></script>
<script type="text/javascript" src="/assets/js/backbone/backbone-min.js"></script>

<script type="text/javascript" src="/assets/js/libphonenumber-js.min.js"></script>
<script type="text/javascript" src="/assets/js/moment.min.js"></script>
<script type="text/javascript" src="/assets/js/moment.timezone.js"></script>

<script type="text/javascript" src="/assets/js/subcommon.js"></script>
<script type="text/javascript" src="/assets/js/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="/assets/js/axisj/dist/AXJ.coremin.js"></script>
<script type="text/javascript" src="/assets/js/axisj/lib/AXTab.js"></script>

<!-- <script type="text/javascript" src="/assets/js/common.js"></script>
<script type="text/javascript" src="/assets/js/layout.js"></script> -->

<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>


<script type="text/javascript" src="/assets/js/commonGridUtil.js" charset='utf-8'></script>
<script type="text/javascript" src="/assets/js/commonTextUtil.js" charset='utf-8'></script>
<script type="text/javascript" src="/assets/js/jqueryAjax.js" charset='utf-8'></script>

<!--[if lt IE 9]>
<script type="text/javascript" src="assets/js/html5shiv.min.js"></script>
<![endif]-->

<script type="text/javascript">

$(function(){
	
	$("#p_start_date, #p_end_date").datepicker({
		closeText          : '닫기',
        currentText        : '오늘',
        dateFormat         : 'yy-mm-dd',
        prevText           : '이전 달',
        nextText           : '다음 달',
        monthNames         : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
        monthNamesShort    : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
        dayNames           : ['일','월','화','수','목','금','토'],
        dayNamesShort      : ['일','월','화','수','목','금','토'],
        dayNamesMin        : ['일','월','화','수','목','금','토'],
        showMonthAfterYear : true,
        buttonImage        : '/images/icon/calendar.gif',
        buttonImageOnly    : true,
        changeMonth        : true,
        changeYear         : true,
        showButtonPanel    : true			    	
  	});
});

$(document).ready(function(){
	
	$("#btnSave").click(function() {
		fn_save();
	});
	
	$("#btnCancel").click(function(){
		location.href = "que.do?edu_pk=" + $("#edu_pk").val();
	});
	
	$("#btnDel").click(function(){
		fn_del();
	});
	
	$('#factory_table').on("click", "button", function() {
		
		var tempArray = [];
		
	    $(this).closest("tr").remove();
	    
	    var trIdx = $("#factory_table tr").length;
	    
	    for(var i=0; i < trIdx; i++) {
	    	//alert($("#factory_table tr:eq(" + i + ") td input").val());
	    	tempArray.push($("#factory_table tr:eq(" + i + ") td input").val());
	    }
	    
	  	$("#factory_tbody").empty();
	  	
	  	var rowItem = '';
	  	for(var i=1; i <= tempArray.length; i++) {
	  		rowItem += "<tr>";
			rowItem += "<td><span>" + i + ".</span><input type='text' class='w100' value='" + tempArray[i-1] + "'/>";
			if(i != 1) {
				rowItem += "<button class='button'><i class='w_minus'></i>삭제</button></td>";
			}
			rowItem += "</tr>";
	  	}
	  	$('#factory_table').append(rowItem);
		
	});
	
});

function replaceAll(str, searchStr, replaceStr) {
	  return str.split(searchStr).join(replaceStr);
}

function fn_save() {
	
	var result = true;
	var message = "";
	
	var dataArrayToSend = [];
	var data = {};
	
	var length = $("#factory_table tr").find("td").length;
	if(length < 2) {
		alert("답안 목록은 2개 이상 입력해주세요.");
		return false;
	}
	
	$("#factory_table tr").each(function(){
		var len = $(this).find("td").length;
		
		var str = $(this).find("td input").eq(0).val();
		str = replaceAll(str, ',', '@@');
		
		dataArrayToSend.push(str);
	});
	
	data.dataArrayToSend = dataArrayToSend;
	
	$("#tableArray").val(data.dataArrayToSend);
	
	$("#tableArray").val();
	
	if(uniqeValidation()) {
		
		var formData = fn_getFormData('#application_form');

		//ajax 호출
        if ( confirm( '저장 하시겠습니까?' ) != 0 ) {
	        $.ajax({
	            url         :   "queSave.do",
	            dataType    :   "json",
	            contentType :   "application/x-www-form-urlencoded; charset=UTF-8",
	            type        :   "post",
	            data        :   formData,
	            success     :   function(data){
	            	alert(data.resultMsg);
	    			if ( data.result == 'success' ) {
	    				location.href = "que.do?edu_pk=" + $("#edu_pk").val();
	    			}
	            },
	            error       :   function(request, status, error){
	            	alert( "시스템 오류입니다.\n전산담당자에게 문의해주세요." );
	            	location.href = "queDetail.do";
	            }
	        });
        }
	}
}

function fn_del() {
	
	var formData = fn_getFormData('#application_form');
	
	//ajax 호출
    if ( confirm( '삭제 하시겠습니까?' ) != 0 ) {
        $.ajax({
            url         :   "queDel.do",
            dataType    :   "json",
            contentType :   "application/x-www-form-urlencoded; charset=UTF-8",
            type        :   "post",
            data        :   formData,
            success     :   function(data){
            	alert(data.resultMsg);
    			if ( data.result == 'success' ) {
    				location.href = "que.do?edu_pk=" + $("#edu_pk").val();
    			}
            },
            error       :   function(request, status, error){
            	alert( "시스템 오류입니다.\n전산담당자에게 문의해주세요." );
            	location.href = "queDetail.do";
            }
        });
    }
	
}

//필수 항목 Validation
var uniqeValidation = function(){
	var rnt = true;
	
	if($("#p_subject").val() == '') {
		alert("문제가 누락되었습니다.");
		rnt = false;
		return false;
	}
	
	if($("#p_answer").val() == '') {
		alert("정답번호가 누락되었습니다.");
		rnt = false;
		return false;
	}
	
	return rnt;
}

function btnAdd() {
	
	var trIdx = $("#factory_table tr").length;
	
	var rowItem = "<tr>"
				+ "<td><span>" + (trIdx+1) + ".</span><input type='text' class='w100' value=''/><button class='button'><i class='w_minus'></i>삭제</button></td>"
				+ "</tr>";
	$('#factory_table').append(rowItem);
}
</script>

</head>
<body>
<form id="application_form" name="application_form" >
<input type="hidden" id="edu_pk" name="edu_pk" value="${edu_pk}" />
<input type="hidden" id="que_pk" name="que_pk" value="${que_pk}" />
<input type="hidden" id="tableArray" name="tableArray" value="" />
    
    <!-- 메뉴바 -->
    <jsp:include page="/eduHeader.do" flush="true"></jsp:include>
    <!-- 메뉴바/-->
    
    <!-- 가운데 잡아줌 -->
    <div class="doc-wrap" id="docBaseWrap">
        <div class="layout-LW">
            <!-- 좌측 -->
            <div class="left" style="width:923px;">
                <!-- 1번표 -->
                <col style="width:100px" />
                <col />
                <h2 class="subpage-tit"><spring:message code='label.queDetail1'/></h2>
                <table class="bWrite">
                    <tr>
                        <th><spring:message code='label.queDetail2'/><div class="helper"></div><span class="important">*</span></th>
                        <td><textarea id="p_subject" name="p_subject">${subject}</textarea></td>
                    </tr>
                    <tr>
                        <th><spring:message code='label.queDetail3'/><div class="helper"></div><span class="important">*</span></th>
                        <td>
                            <table>
                                <tbody>
                                    <tr style="background-color: #e6e6e6; border-top: #bbb solid 1px; border-right: #bbb solid 1px; border-left: #bbb solid 1px;">
                                        <th><a href="javascript:btnAdd();" style="margin: 7px 0px;height: 32px;width: 58px;" class="button">
                                        	<i class="w_plus"></i><spring:message code='label.queDetail4'/></a>
                                        </th>
                                    </tr>
                                    <tr>
                                        <td style="height: 350px;">
                                            <div style="overflow-y: auto; height: 100%;">
                                                <table class="second_table3" id="factory_table">
                                                    <tbody id="factory_tbody">
                                                    	<c:choose>
                                                    		<c:when test="${fn:length(answerList) > 0}">
																<c:forEach var="answer" items="${answerList}" varStatus="status">
																	<c:choose>
																		<c:when test="${status.count == 1}">
																			<tr>
																				<td><span>${status.count}.</span><input type="text" id="" class="w100" value="${answer.subject}"/></td>
					                                                        </tr>
																		</c:when>
																		<c:otherwise>
																			<tr>
																				<td><span>${status.count}.</span><input type="text" id="" class="w100" value="${answer.subject}"/>
																				<button class='button'><i class='w_minus'></i><spring:message code='label.queDetail5'/></button>
																				</td>
					                                                        </tr>
																		</c:otherwise>
																	</c:choose>	
																</c:forEach>
															</c:when>
															<c:otherwise>
																<tr>
																	<td><span>1.</span><input type="text" id="" class="w100" value=""/></td>
		                                                        </tr>
															</c:otherwise>
													   </c:choose>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <th><spring:message code='label.queDetail6'/><div class="helper"></div><span class="important">*</span></th>
                        <td><input type="text" id="p_answer" name="p_answer" class="w100" value="${answer }"/></td>
                    </tr>
                </table>
                <div class="enrollment_center">
                    <a class="button" id="btnSave"><i class="w_save"></i><spring:message code='label.queDetail7'/></a>
                    <c:if test="${que_pk != '' }">
                    	<a class="button bc1" id="btnDel"><i class="w_del"></i><spring:message code='label.queDetail8'/></a>
                    </c:if>
                    <a class="button" id="btnCancel"><i class="w_cancel"></i><spring:message code='label.queDetail9'/></a>
                </div>
            </div>
            <!-- 가운데 잡아줌// -->
        </div>
        <!-- <script type="text/javascript">/*<![CDATA[*/
            $(function(){
                $("a.b1.toggle").on("click",function(e){
                    e.preventDefault();
                    var $that = $($(this).attr('href'));
                    if($(this).hasClass("on")){
                        $(this).removeClass("on");
                        $that.hide();
                    }else{
                        $(this).addClass("on");
                        $that.show();
                    }
                });
            });
            /*]]>*/</script> -->
    </div>
</form>
</body>
</html>