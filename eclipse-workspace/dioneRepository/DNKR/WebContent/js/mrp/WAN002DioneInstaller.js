

$(document).ready(function() {
	fnOnLoad();
}) 


function setSessionSuccess() {
	var params = {result: true};
	var objList = getAjaxList("/WAN002MiPlatform/ajaxSuccess.do", params)
	return false;
}

/**
 * ajax로 리스트 가져오기
 * @param url
 */
function getAjaxList (url, params) {
	mask.open();
	$.ajax({
		url: url,
		type    : "POST",
		async : false,
		data : params,
		success : function (data){
			//console.log(data);
			try{
				var parse = JSON.parse(data);
    			if(parse.result !== RESULT_Y){
    				toastMsg('세션에 설치파일 성공 여부를 전달하지 못하였습니다. IT팀에 문의를 부탁 드립니다.');
    				return;
    			}
			}catch(e){
				console.log(e);
			}
		},
		error: function(e){ 
			//console.log(e);
		},
		complete: function(e) {
			//console.log(e);
			mask.close();
		}
	});
	
	return;
}
