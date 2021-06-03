<%-- <%--
 * PROJECT：
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
<link rel="stylesheet" type="text/css"	href="/js/lib/assets/lib/ax5ui-autocomplete/dist/ax5autocomplete.css">
<script type="text/javascript" src="/js/lib/assets/lib/ax5ui-autocomplete/dist/ax5autocomplete.min.js"></script>

<link rel="stylesheet" media="all" href="/css/board.css" />

<script type="text/javascript">

/* var initBody;
function beforePrint(){
	boxes = document.body.innerHTML;
	document.body.innerHTML = box.innerHTML;
}
function afterPrint(){
	document.body.innerHTML = boxes;
}

window.onbeforeprint = beforePrint;
window.onafterprint = afterPrint; */

$(document.body).ready(function () {

	// focus 지정
	$('#qrRead').focus();		
	
	$('#qrRead').on('blur', function() {
		$('#qrRead').focus();
	});
	$('#qrRead').on('keyup', function() {
	});
	/* 	$('#qrRead').css("ime-mode", "disabled"); */
	
	// qr 리딩값 start
	$('#qrRead').on('change', function() {
		
		var qrValue = $('#qrRead').val();
		
		if(qrValue=="QT"){
			qrPartListPrint();
			return;
		} else if(qrValue.length < 50) {
			// qr리딩값 초기화
			$('#qrRead').val("");
			return;
		}
	
			
		var seqLen = $("input[name='seq']").length;
	    if(seqLen > 0){
	    	for(var i=0; i<seqLen; i++){                          
		     	if($("input[name='seq']")[i].value == qrValue.substring(143,150)){
					$('#qrRead').val("");
					return;
				}
		    }	
	    }
	    
		
		var qrRead = $('#qrRead').val();
		$.ajax({
			method : "post",
			url : "/WAO001PartListView/ajaxPartNameSearch.do",
			data : {
				qrRead: qrRead,		
			},
			success : function(res) {
				
				var data = JSON.parse(res);
				if (data.list.length > 0) {
					
					var trLength = $( "tr[name=trReadList]").length;
					var addStaffText ="";
					var lineCode = $('#lineCode').text();
					data.list.forEach(function(item, index){
						var quantity = parseInt(item.quantity);
						var sumQuantity = $('td[name="sumQuantity"]').text();
						addStaffText =
							'<tr name="trReadList">'+
							'	<td>' + trLength + '</td>'+
							'	<td>' + item.partNum + '</td>'+
							'	<input type="hidden" id="conditionPart" name="conditionPart" value="'+item.partNum + '" />' +
							'	<td>' + item.partName + '</td>'+
							'	<td name="quantity">' + quantity + '</td>'+
							'	<input type="hidden" id="conditionQuantity" name="conditionQuantity" value="'+quantity + '" />' +
							'	<input type="hidden" id="seq" name="seq" value="'+item.seq + '" />' +
							'</tr>';
							
							$('td[name="sumQuantity"]').text(parseFloat(sumQuantity) + parseFloat(quantity));
							
							lineCode = item.lineCode;
							
					}); 
						// 위 리스트의 tr 추가하기							
						$( "tr[name=trReadList]:last" ).after(addStaffText);
						// rowspan 추가하기 	 
						$( "td[id=titleRow]" ).attr("rowspan", (trLength+1));
						// qr리딩값 초기화
						$('#qrRead').val("");
						// qr리딩값 초기화
						$('#lineCode').text(lineCode);
							
						
						
				}
			},
			error : function(res) {
				
				//console.log("error");
				//console.log(res);
			},
			complete : function(res) {
				setTimeout(function() {
				
				}, 1000);
			}
		});
	});
	// qr 리딩값 end
	
	// qr print start
	$('#qrPrint').on('click', function() {
		qrPartListPrint();
	});
	// qr print end
	
});
// qr 프린터 end

function qrPartListPrint(){
	
	// 제품 품번 파라미터
	var fileValue = $("input[name='conditionPart']").length;
    var fileData = new Array(fileValue);
    
    var checkSameConditionPart =  true;

	// 동일 제품 확인용
    for(var i=0; i<fileValue; i++){                          
         fileData[i] = $("input[name='conditionPart']")[i].value;
         
         if(fileData[0] != fileData[i]){
        	 checkSameConditionPart = false;
         }
         
    }
    
    // 수량 전송 파라미터
	var fileValue2 = $("input[name='conditionQuantity']").length;
    var fileData2 = new Array(fileValue2);
    
    for(var i=0; i<fileValue2; i++){                          
    	fileData2[i] = $("input[name='conditionQuantity']")[i].value;
         
    }
    
	 $.ajax({
		method : "post",
		url : "/WAO001PartListView/ajaxQrPartPrint.do",
		traditional : true,
		data : {
			conditionPart: fileData,	
			conditionQuantity:fileData2
		},
		success : function(res) {
			var data = JSON.parse(res);
			var sumQuantity;
			if (data.list.length > 0) {
				
				var addStaffText ="";
				
				data.list.forEach(function(item, index){
					// 총 제품 생산량
					sumQuantity = $('td[name="sumQuantity"]').text();
					
					// 소요량
					//var totalQtypr = (sumQuantity * item.qtypr);
					// 박스 수량
					var mulqyCal = parseInt(item.calculateQtypr) /parseInt(item.mulqy);
					mulqyCal = Math.ceil(mulqyCal);
					
					addStaffText +=
						'<tr name="trQrPartList">'+
						'	<td>' + (index+1) + '</td>'+
						'	<td>' + item.whslc + '</td>'+
						'	<td class="jb-large" style="padding-top: 5px;padding-bottom: 5px;padding-right: 5px;padding-left: 5px">' + item.cinbr + '</td>'+							
						'	<td>' + item.itdsc + '</td>'+						
						'	<td>' + item.calculateQtypr +'</td>'+
						'	<td>' + mulqyCal + '</td>'+
						'</tr>';
					}); 
				
					// 위 리스트의 tr 추가하기							
					$( "tr[name=trQrPartList]:last" ).after(addStaffText);
					// rowspan 추가하기 	 
					//$( "td[id=qrPartListRow]" ).attr("rowspan", $('tr[name="trQrPartList]"').length);
					
					// 동일 품번이지 또는 12가 아닐경우는 별 표시
					
					//if 동일 품번이지만 12가 아닐경우
					if(checkSameConditionPart == true){
						if(sumQuantity != "12"){
							$('td[name="sumQuantity"]').text(parseFloat(sumQuantity) + '★');	
						}

					// else 동일품번이 아닐경우
					}else{
						$('td[name="sumQuantity"]').text(parseFloat(sumQuantity) + '★');
					}
					
					window.print();
					location.reload();
			}
		},
		error : function(res) {
			console.log("error");
			console.log(res);
			
		},
		complete : function(res) {
			setTimeout(function() {
				
			}, 1000);
		}
	});
}

/* function printPage(){
 var initBody;
 window.onbeforeprint = function(){
  initBody = document.body.innerHTML;
  document.body.innerHTML =  document.getElementById('box').innerHTML;
 };
 window.onafterprint = function(){
  document.body.innerHTML = initBody;
 };
 window.print();
 return false;
} */

</script>

<style>

 .input[type=text] { 
-webkit-ime-mode:disabled; 
-moz-ime-mode:disabled; 
-ms-ime-mode:disabled; 
ime-mode:disabled; 

} 

button.black {
	height: 34px;
	width: 230px;
}
.board-write-wrap table {width:100%; border:1px solid #dfdfdf;}
.board-write-wrap table th {text-align:left;border-bottom:1px solid #ddd;background:#ccc;padding:10px 30px;}
.board-write-wrap table th .necessary {color:#d7363c;margin-left:-1em;}
.board-write-wrap table td {text-align:left;border-bottom:1px solid #ddd;background:#fff;padding:10px 30px 10px 15px;}

.subpage-tit {font-size:20px;padding-left:15px;font-weight:bold;background:url(/img/sub-tit.png)no-repeat 0 5px; /*margin-bottom:35px;*/margin-bottom:5px;}
.subpage-tit2 {font-size:20px;padding-left:15px;font-weight:bold;margin-bottom:5px;}

@media print {
   
    subpage-tit {
        display: none;
    }
}

.jb-xx-small { font-size: xx-small; }
.jb-x-small { font-size: x-small; }
.jb-small { font-size: small; }
.jb-medium { font-size: medium; }
.jb-large { font-size: large; }
.jb-x-large { font-size: x-large; }
.jb-xx-large { font-size: xx-large; }

</style>

<style type="text/css" media="print">
	.noprint {display:none;}
</style>

<h2 class="subpage-tit noprint">부품투입지시서 발행</h2>

<div class="board-write-wrap noprint">
	<table name="upList" id="upList" style="width: 720px; margin-left:3px;">
		<caption>내용 입력폼</caption>
		<colgroup>
			<col style="width: 10%">
			<col style="width: 70%">
			<col style="width: 20%">
		</colgroup>
		<tbody>
			<tr>
				<th>QR</td>
				<td><input type="text"  id="qrRead" style="width: 100%"></input></td>
				<td rowspan="2" style="align-items: center;"><img src="/img/login/qr.png" alt="QR" style="height: 110px;"></td>
			</tr>
			<tr>
				<td colspan="2">
				<div class="fl bnt">
					<button type="button" class="black" onclick="javascript:location.href='${pageContext.request.contextPath}/WAO001PartListView/qrRead.do'" style='margin-left:5px;'>삭제</button>
					<button type="button" class="black" id="qrPrint" name="qrPrint" style='margin-left:15px;'> 발행</button>
				</div>
				</td>
			</tr>
		</tbody>
	</table>
</div>

<div class="board-write-wrap" id="box">
	
	<table style="width: 720px;margin-left:3px;">
		<colgroup>
			<col style="width: 30%">
			<col style="width: 70%">
		</colgroup>
		<tbody>
		<tr>
			<td><h2 class="subpage-tit2" id="lineCode" ></h2></td>
			<td><h2 class="subpage-tit2">라인투입지시서</h2></td>
		</tr>
	</table>
	
	<table name="upList" id="upList" style="width: 720px;margin-left:3px;">
		<caption>내용 입력폼</caption>
		<colgroup>
			<col style="width: 5%">
			<col style="width: 20%">
			<col style="width: 40%">
			<col style="width: 15%">
			<col style="width: 15%">
		</colgroup>
		<tbody>
			<tr name='trReadList'>
				<td>No.</td>
				<td>품번</td>
				<td>품명</td>
				<td>수량</td>
				<td id='titleRow' name='sumQuantity' style="font-size: 50px;">0</td>	
			</tr>
		</tbody>
	</table>

	<!-- 부품투입지시서 발행 -->
	<table name="qrPartList" id="qrPartList" style="width: 720px;margin-left:2px;">
		<caption>내용 입력폼</caption>
		<colgroup>
			<col style="width: 5%">
			<col style="width: 12%">
			<col style="width: 25%">
			<col style="width: 35%">
			<col style="width: 12%">
			<col style="width: 12%">
		</colgroup>
		<tbody>
			<tr name='trQrPartList'>
				<td>No.</td>
				<td>로케<br>번지</td>
				<td>품번</td>
				<td>품명</td>
				<td>소요량</td>
				<td>투입박스</td>
			</tr>
		</tbody>
	</table>
</div>

