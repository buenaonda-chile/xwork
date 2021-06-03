/**
 * [KO] 답변 수 추가하기
 *
 * @param targetId 'insertDiv'
 */
 function PrintAnswerLayout(targetID)
{
	var obj = document.getElementById(targetID);
	var Layout = "<input type=\"text\" class=\"research-tit\" name=\"answerTitle[]\" size=\"20\" title=\"설문제목을 입력해주세요\">";
	$(obj).append(Layout);
}

function addquestion()
{	
	var state = false
	if(document.getElementsByName("qstTitle")[0].value=="")
	{
		alert("질문을 등록하세요");
		document.getElementsByName("qstTitle")[0].focus();
		return false;
	}
	if(method.nType!="text"){
		//객관식인 경우
		var aCnt = document.getElementsByName("answerTitle[]").length;
		for(var i = 0 ;i < aCnt; i++)
		{
			if(document.getElementsByName("answerTitle[]")[i].value!="")
			{				
				state = true;
				break;
			}
		}
	}else{
		//주관식인 경우
		state = true;
	}
	if(!state)
	{
		alert("답변을 등록해 주세요");
	}
	else
	{
		if(confirm("추가 하시겠습니까?")){
			document.WAG002SurveyQuestionCreate.submit();
		}
	}
	return false;
}

var method = {
	init:function(){
		try{
			this.changeLayout();				
			var shCheck = document.getElementsByName("qstType");
			var len = shCheck.length;
			for(var i=0;i<len;i++){					
				shCheck[i].onclick = function(){
					method.changeLayout();						
				}
			}
		}catch(e){
			//초기화 실패시 객관식기능 활성화
			this.multipleChoiceLayout();
		}
					
	},
	changeLayout:function(){
		//선택항목에 맞는 레이아웃 구성 함수 호출
		var shCheck = document.getElementsByName("qstType");
		var len = shCheck.length;
		for(var i=0;i<len;i++){
			if(shCheck[i].checked){
				switch(shCheck[i].value){
					case "text":							
						this.shortAnswerLayout();
						this.nType = "text";
						break;
					case "radio":
						this.multipleChoiceLayout();
						this.nType = "radio";
						break;
					case "checkbox":
						this.multipleChoiceLayout();
						this.nType = "checkbox";
						break;
					default:
						this.multipleChoiceLayout();
						this.nType = "radio";
				}
			}
		}			
	},
	multipleChoiceLayout:function(){
		//객관식 레이아웃 구성
		$(".shortAnswerNode").hide();
		$(".answerTr").show();			
	},
	shortAnswerLayout:function(){
		//주관식 레이아웃 구성
		$(".answerTr").hide();
		$(".shortAnswerNode").show();
	}
};
	
	
	
	
function updateQuestion(srvCode,qstCode){
	if(confirm("확인을 누르시면 해당 질문을 수정하실 수 있습니다.")){
		location.href= "${pageContext.request.contextPath}/WAG002SurveyQuestionCreate/init.do?menu=${menu}&tabId=${tabId}&srvCode="+srvCode+"&qstCode="+qstCode;
	}  
}

function modiCancle(srvCode){
	if(confirm("확인을 누르시면 원래하면으로 돌아갑니다.")){
		location.href= "${pageContext.request.contextPath}/WAG002SurveyQuestionCreate/init.do?menu=${menu}&tabId=${tabId}&srvCode="+srvCode;
	}  
}

function modiQuestion(srvCode,qstCode){
	var form = document.WAG002SurveyQuestionCreate;
	if(confirm("해당 질문을 수정하시겠습니까?")){
		form.action = "${pageContext.request.contextPath}/WAG003SurveyQuestionUpdate/update.do?menu=${menu}&tabId=${tabId}";
		form.submit();
	}
}

function deleteQuestion(srvCode,qstCode,mode){
	if(confirm("해당 질문을 삭제하시겠습니까?(삭제하면 다른언어에 관한 항목들도 삭제됩니다.)")){
		location.href="${pageContext.request.contextPath}/WAG003SurveyQuestionUpdate/delete.do?menu=${menu}&tabId=${tabId}&srvCode="+srvCode+"&qstCode="+qstCode+"&mode="+mode;
	}
}

function deleteAnswer(srvCode,aswCode,mode){
	if(confirm("해당 질문을 삭제하시겠습니까?(삭제하면 다른언어에 관한 항목들도 삭제됩니다.)")){
		location.href="${pageContext.request.contextPath}/WAG003SurveyQuestionUpdate/delete.do?menu=${menu}&tabId=${tabId}&srvCode="+srvCode+"&qstCode="+aswCode+"&mode="+mode;
	}
}
	
function loadquestion(surveyidx) {
	
	if(confirm('이전문항을 불러오시겠습니까?\n* 주의 : 현재 작성되어있는 설문문항들은 삭제됩니다.')) {
		// 이전문항 세팅
		$.ajax({
			type:"POST",
			url:"${pageContext.request.contextPath}/WAG003SurveyQuestionUpdate/prevData.do?menu=${menu}&tabId=${tabId}",
			data : {srvCode : surveyidx},
			dataType : "json",
			async: false,
			success: function(data){
				alert(data.result);
			},
			error: function(xhr, status, error) {
				alert(error);
			}   
		});
		
		document.location.reload();
	}
}

$(function(){
	method.init();
});