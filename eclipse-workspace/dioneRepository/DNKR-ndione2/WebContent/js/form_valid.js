//유효성검사
function val_chk(val,alias){
	if(val == "" || val == null || val == undefined || ( val != null && typeof val == "object" && !Object.keys(val).length )){
		var rtnMsg = "";
		if(LN_CHK === "kr"){
			rtnMsg = alias + "을(를) 입력해주세요.";
		}else if(LN_CHK === "ja") {
			rtnMsg = alias + " 入力してください";
		}else {
			rtnMsg = "Please enter " + alias;	
		}
		toastMsg(rtnMsg);
//		obj.focus();
		return false;
	}
	return true;
}