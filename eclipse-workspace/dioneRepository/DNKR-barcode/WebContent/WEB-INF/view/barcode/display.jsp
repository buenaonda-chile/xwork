<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta http-equiv="Cache-Control" content="no-cache" />  
<meta http-equiv="Expires" content="0" />  
<meta http-equiv="Pragma" content="no-cache" />
<html>
<head>
<link rel="stylesheet" href='<c:url value="/resources/static/css/jquery-ui.css"/>' type="text/css" />
<link rel="stylesheet" href='<c:url value="/resources/static/css/jquery.monthpicker-0.1.css"/>' type="text/css" />
<link rel="stylesheet" href='<c:url value="/resources/static/css/default.css"/>' type="text/css" />

<script type="text/javascript" src='<c:url value="/resources/static/js/jquery.min.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resources/static/js/jquery.monthpicker-0.1.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resources/static/js/jquery-ui.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resources/static/js/ui_old.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resources/static/js/ui.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resources/static/js/jquery.smartmenus.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resources/se2/js/HuskyEZCreator.js"/>' charset="utf-8"></script>
<script type="text/javascript">
	setInterval('getStatus()', 500);
	function getStatus(){
		 $.ajax({       
			type:"GET",   
			url:'/barcode/ajaxStatus',       
			data:{
					"sessionId":$.trim($('#sessionId').val())
				},
			traditional:true,
			success:function(data){
				var rlt = data.result;
				if(rlt != null){
					$('#cusno').text(rlt.CUSNO);             //업체
					$('#procs').text(rlt.PROCS);			 //공정
					$('#orcqy').text(rlt.ORCQY);			 //생산지수
					$('#prtnol').text(rlt.PRTNO);            //품번
					$('#cprtn').text(rlt.CPRTN);             //업체품번
					$('#mkacl_carcd').text(rlt.MKALC_CARCD); //ALC 차종
					$('#issueNumber').text(rlt.ISSUENUMBER); //인쇄번호
					$('#sqn').text(rlt.SQN);
				}                 
			}   
		});
	} 	
	
	function printStop(){
		 $.ajax({       
			type:"GET",   
			url:'/barcode/printStop',       
			data:{
					"sessionId":$.trim($('#sessionId').val())
				},
			traditional:true,
			success:function(data){
				// alert("바코드 프로그램이 종료 되었습니다.");
			}   
		});
	} 	
</script>
</head>
<body>
<form id="form" method="get">
<input type="hidden" id="sessionId" name="sessionId" value="<c:out value="${sessionId}"/>"/>
<!-- s: main content -->
<div class="main_content">
	&nbsp;
	
	<!-- e: btn -->
	<!-- s: table list -->
	<div class="table_list_type01">
		<table>
			<colgroup>
				<col width="100" />
				<col width="100" /> 
				<col width="100" /> 
				<col width="100" /> 
				<col width="100" />  
				<col width="100" /> 
				<col width="100" /> 
				<col width="100" />  
			</colgroup>
			<thead>
			
				<tr>
					<th>업체</th>
					<th>공정</th>
					<th>생산지시수</th>
					<th>품번</th>
					<th>업체품번</th>
					<th>ALC차종</th>
					<th>인쇄중매수</th>
					<th>품목최종수</th>
				</tr>
			</thead>
			<tbody>
			<tr>
				<td><div id="cusno"></div></td>
				<td><div id="procs"></div></td>
				<td><div id="orcqy"></div></td>
				<td><div id="prtnol"></div></td>	
				<td><div id="cprtn"></div></td>
				<td><div id="mkacl_carcd"></div></td>
				<td><div id="issueNumber"></div></td>
				<td><div id="sqn"></div></td>
			</tr>
					
			</tbody>
		</table>
	</div>
	<!-- e: table list -->
	
	<!-- s: btn -->
	<div class="btnAlign_wrap01">
		<span class="btn b_pt"><a href="javascript:printStop()" class="b_in" style="width:82px;">인쇄정지</a></span>
	</div>

</div>
</form>	
</body>
</html>


    