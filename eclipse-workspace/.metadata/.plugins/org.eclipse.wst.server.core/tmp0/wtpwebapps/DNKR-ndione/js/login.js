$(document).ready(function() {
	$(".login-text .left a").click(function(){
		$("#lText-pop").fadeIn(300);
		
	})
	$(".close").click(function(){
		$("#lText-pop").fadeOut(300);	
		$(".logInFail").fadeOut(300);
	});
	
	
	$("#idPwclose").click(function(){
		$("#idPwFindBox").fadeOut(300);	
	});
	
	
	
//	bgChange();
//	setInterval(bgChange, 3000);
	var $bgDiv = $('#login-bg');			// bgwrap div 안에 있는 div 자식들을 가져옴
	var imgCount = $bgDiv.children().length;	// 위에서 가져온 div 자식들의 개수
	var changeSec = 3000;					// 이미지를 변경할 시간 (3000 = 3초)
	var changeAble = false;						// 자동으로 변경할 지 여부
	var index = 0;						// 변경할 이미지의 Index
	
	if(changeAble == true) {
		setInterval(bgChange, changeSec);		// Javascript setInterval 함수 호출
	}
	
	function bgChange() {
		index += 1;
		var next = (index % imgCount);
		$($bgDiv.children().get(next - 1)).fadeOut(1000);
		$($bgDiv.children().get(next)).fadeIn(1000);
	}
	
	isAuthentic();
	
	var myId = getCookie("myId");
	if(myId!=null && myId!=""){
		$("#userId").val(myId);
		$("#idSave").attr("checked", true);
	}
});


function isAuthentic() {
	if(getCookie("AUTHENTICATED") === "N") {
		$('.logInFail p span').text("아이디 또는 비번이 맞지 않습니다.");
		//$('.logInFail p span').text("시스템에 등록되지 않은 사용자입니다.");
		$(".logInFail").fadeIn(300);
		if(getCookie("LDAP_CHECK") === "A") {
			$('.logInFail p span').text("AD에 등록되지 않은 사용자입니다.");
			$(".logInFail").fadeIn(300);
		}else if(getCookie("LDAP_CHECK") === "B") {
			$('.logInFail p span').text("계정이 잠겼습니다. 3분후 다시 시도하세요.");
			$(".logInFail").fadeIn(300);
		}else if(getCookie("LDAP_CHECK") === "C") {
			$('.logInFail p span').text("패스워드가 맞지 않습니다. 재확인 해주세요.");
			$(".logInFail").fadeIn(300);
		}else if(getCookie("LDAP_CHECK") === "D") {
			$('.logInFail p span').text("LDAP 인증오류 입니다.");
			$(".logInFail").fadeIn(300);
		}else if(getCookie("LDAP_CHECK") === "G") {
			$('.logInFail p span').text("GCI-AD 인증이 지연되었습니다. 잠시 후 재시도하세요.");
			$(".logInFail").fadeIn(300);
		}
	}
}

function getCookie(name) {
  var value = document.cookie.match('(^|;) ?' + name + '=([^;]*)(;|$)');
  if (value) {
  	return value[2];
  } else {
  	return null;
  }
}


function openIdPw(){
	$("#idPwFindBox").fadeIn(300)
}

function validChk() {
	if($('#userId').val().trim().length === 0) {
		$('.logInFail p span').text("아이디를 입력하세요");
		$('.logInFail').fadeIn(300);
		return false;
	} else if ($('#userPw').val().trim().length === 0) {
		$('.logInFail p span').text("패스워드를 입력하세요");
		$('.logInFail').fadeIn(300);
		return false;
	} else {
		chkIdSave();
		return true;
	}
}

//{{{ setcookie
function setcookie(name, value, expires, path, domain, secure) {
    // Send a cookie
    // 
    // +    discuss at: http://kevin.vanzonneveld.net/techblog/article/javascript_equivalent_for_phps_setcookie/
    // +       version: 804.1712
    // +   original by: Jonas Raoni Soares Silva (http://www.jsfromhell.com)
    // *     example 1: setcookie('author_name', 'Kevin van Zonneveld');
    // *     returns 1: true

    expires instanceof Date ? expires = expires.toGMTString() : typeof(expires) == 'number' && (expires = (new Date(+(new Date) + expires * 1e3)).toGMTString());
    var r = [name + "=" + escape(value)], s, i;
    for(i in s = {expires: expires, path: path, domain: domain}){
        s[i] && r.push(i + "=" + s[i]);
    }
    return secure && r.push("secure"), document.cookie = r.join(";"), true;
}// }}}

function chkIdSave(obj){
	var chk = $("#idSave").is(":checked");
	var myId = $("#userId").val();
	if(chk==true){
		setcookie('myId', myId);
	}else{
		setcookie('myId', "");
	}
}
