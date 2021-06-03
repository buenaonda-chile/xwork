$(document.body).ready(function() {
	$('._closeBtn_').on('click', function() {
		self.close();
	});
});

/**
 * ajax로 결과 체크하기
 * @param url
 */
function getAjaxResult (url, params, pType) {
	if(pType === undefined) {
		pType = "GET";
	}
	var resultStr;
	$.ajax({
		url: url,
		type    : pType,
		async : false,
		data : params,
		success : function (data){
			//console.log(data);
			try{
				var parse = JSON.parse(data);
    			if(parse.result === RESULT_Y){
    				resultStr = RESULT_Y;
    			}else if(parse.result === RESULT_N){
    				resultStr = RESULT_N;
    				return;
    			}
			}catch(e){
				//console.log(e);
			}
		},
		error: function(e){ 
			//console.log(e);
		},
		complete: function(e) {
			//console.log(e);
		}
	});
	
	return resultStr;
}

/**
 * ajax로 도메인 가져오기
 * @param url
 */
function getAjaxDomain (url, params, pType) {
	mask.open();
	if(pType === undefined) {
		pType = "GET";
	}
	var obj;
	$.ajax({
		url: url,
		type    : pType,
		async : false,
		data : params,
		success : function (data){
			console.log(data);
			try{
				var parse = JSON.parse(data);
    			if(parse.result === RESULT_Y){
    				obj = parse;
    			}else {
    				obj = undefined;
    				return;
    			}
			}catch(e){
				console.log(e);
			}
		},
		error: function(e){ 
			console.log(e);
		},
		complete: function(e) {
			//console.log(e);
			mask.close();
		}
	});
	
	return obj;
}