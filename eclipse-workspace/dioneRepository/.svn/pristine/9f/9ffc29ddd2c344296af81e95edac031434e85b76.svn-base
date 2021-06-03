/**
 * 
 */

//실행파일위치
var execSCM="C:\\Program Files\\코아정보기술(주)\\SCM\\CORESCMLOGIN.exe";	//SCM(KA협력업체용)
//var execSCM="C:\\Program Files\\코아정보기술(주)\\협력업체종합정보관리시스템\\COREERPLOGIN.exe.exe";	//SCM(KA사내용)
var execMES="";//MES
var execMES_C1="\\Denso Korea\\MESplusV5 EE\\MESClient\\MESClient.exe ";	//MES(협력업체용)
//var execMES_C1="\\Microsoft\\Windows\\Start Menu\\Programs\\Miracom Inc\\MESplusV5 EE\\MESClient.lnk ";	//MES(사내용7용)
//var execMES_C1="\\Miracom Inc\\MESplusV5 EE\\MESClient\\MESClient.exe ";	//MES(사내용 XP용)
//var execMES_H1="http://mes-h1.dnka.kr ";	////MES(협력업체용 홍성)
//var execPrevention="C:\\Program Files\\불량유출방지 시스템\\UpNStart_ALL.exe"; //공정누락방지

//설치파일위치
var instSCM="http://10.72.149.81:8080/CWORKS/Setup/SCM";	//SCM(KA협력업체용)
//var instSCM="http://10.72.149.81:8080/CWORKS/Setup/PGM";	//SCM(KA사내용)
var instMES="";//MES
//var instMES_C1="http://cvs2802.korea.asia.denso:8099/publishOSP.htm";	//MES창원(KA협력업체용) //변경 : 2020.09.03
var instMES_C1="http://mes-c1.densops.co.kr/";	//MES창원(KA협력업체용)
//var instMES_S1="http://hvs1401.korea.asia.denso:8099/publishOSP.htm";	//MES화성(KA협력업체용)
//var instMES_C1="ftp://10.72.149.96/0.%BC%B3%C4%A1%20%20%A1%D9%A1%DA%A1%D9_%BB%E8%C1%A6%B1%DD%C1%F6%20%A1%DA%A1%D9%A1%DA/0.MES/1.MESClientSetupKitFor7/";	//MES창원(KA사내용)
//var instMES_H1="http://mes-h1.dnka.kr ";	//MES창원
//var instPrevention="'\\\\10.73.254.163\\net_int\\setup\\setup.exe"; //공정누락방지
	
function openLink(obj) {	
	var rltBrower = isBrowserCheck();
	mask.open();
	var tagName = $(obj).prop("tagName").toLowerCase();
	var systemSeq;
	var relationCompany;
	if (tagName === "a") {
		systemSeq = $(obj).attr('data-systemSeq');
		relationCompany = $(obj).attr('data-relationCompany');
	} else if (tagName === "span") {
		systemSeq = $(obj).prev().attr('data-systemSeq');
		relationCompany = $(obj).prev().attr('data-relationCompany');
	}
	$.ajax({
		method : "post",
		url : "/ssoAccountsExternal.do",
		data : {systemSeq: systemSeq, relationCompany: relationCompany},
		success : function(data) {
			try {
				var parse = JSON.parse(data);
				if(parse.result=="y"){	    
					console.log(parse.url);
					/*window.open(parse.url,"linkPop","width=1040,height=700,scrollbars=yes,top=100,left=100");*/
					if(parse.appType=="cs"){
						//alert("cs");
						if(systemSeq=="1" || systemSeq =="13"){	//협력업체 PGM(KA SCM, KE/KA창원 MES)
							if(rltBrower=="ie"){
								//toastMsg('[알림]성공');
								var rlt = runFileCheck(systemSeq);
								if(rlt == false) return;
								if(systemSeq =="1"){	//협력업체 PGM(KA SCM)
									window.open(parse.url);	
								}else if(systemSeq =="13"){	//협력업체 PGM(KE/KA창원 MES)	
									if(relationCompany=="LOC000003"){
										alert("[알림]화성공장 제품(HVAC,ETC)에 관련된 업체만 사용하시기 바랍니다.\n ※구 홍성공장 납품업체 사용금지");
									}
									runFileExec(systemSeq, parse.rltParam);
								}
							}else{
								toastMsg('[알림]인터넷익스플로우만 사용가능합니다.');
								return;
							}
						}
					}else{
						//alert("web");
						 if(systemSeq =="13"){	//협력업체 PGM(홍성 MES 서비스 종료 알림)	
							if(relationCompany=="LOC000002"){
								alert("[알림]홍성공장 MES서비스는 종료되어 사용이 불가능합니다.");
								return;
							}
						}
						window.open(parse.url);	
					}
				}else if(parse.result=="n"){
					toastMsg('지정된 링크가 없습니다.');
				}else {
					toastMsg('권한이 없습니다.');
				}
			}catch(e){
				alert(e);
			}
		},
		error : function(res) {
			console.log("error");
			console.log(res);
		},
		complete : function(res) {
			console.log("completed");
			console.log(res);
			mask.close();
		}
	});
}

function externalLink(obj) {
	if(obj=="1"){
		//alert("홈페이지");
		window.open("https://www.denso.com/kr/ko/");
	}else if(obj=="2"){
		//alert("방문자예약");
		window.open("http://visit.densokorea.com/_visit/_main/main.html");
	}
	return;
	window.open();
}


function runFileCheck(sysSeq){
	
	var rlt = true;		
	var execName="";	//실행파일
	var instName="";	//설치파일
	
	var WshShell="";
	try {
		WshShell = new ActiveXObject("WScript.Shell");
	} catch (e) {
		// TODO: handle exception
		rlt = false;
		//alert("'인터넷옵션>보안>신뢰할수 있는 사이트'에  등록하셔야 정상작동 합니다.");
		alert("1)인터넷옵션>보안>신뢰할수 있는 사이트>사이트  등록 \n"+
	          "2)인터넷옵션>보안>신뢰할수 있는 사이트>사용자지정수준> ActiveX 설정 후  정상작동 합니다.\n" +
			  " ActiveX 설정은 매뉴얼을 참고하세요");
	}
	if(rlt != false){	//ActiveX가 정상동작일 때만 동작
		var fileTF = new ActiveXObject("Scripting.FileSystemObject");
		
		//var WshShell = new ActiveXObject("WScript.Shell");
		//var fileTF = new ActiveXObject("Scripting.FileSystemObject");
		
		if(sysSeq=='1'){
			instName = instSCM;
			execName = execSCM;
		}else if(sysSeq=='13'){
			instMES = instMES_C1;
			instName = instMES;
			execMES=execMES_C1;
			//execName = WshShell.ExpandEnvironmentStrings("%AppData%")+execMES;
			execName = WshShell.ExpandEnvironmentStrings("%userprofile%")+execMES;
		}
		
		if(!fileTF.FileExists(execName)){
			window.open(instName);
			rlt = false;
		}
	}
	return rlt;
}

function runFileExec(sysSeq, sParam){
	var execName="";	//실행파일
	
	var WshShell = new ActiveXObject("WScript.Shell");
	var excShell = new ActiveXObject("Shell.Application");
	
	if(sysSeq=='13'){
		execMES=execMES_C1;
		//execName = WshShell.ExpandEnvironmentStrings("%AppData%")+execMES;
		execName = WshShell.ExpandEnvironmentStrings("%userprofile%")+execMES;
	}
	//excShell.ShellExecute(execName, ' -factory:'+"DNP1"+' -userId:'+"1111"+' -password:'+"2222", "", "open", "1");
	//excShell.ShellExecute(execName, ' -siteId:mes-c1.densops.co.kr -factory:'+"OSP1"+' -userId:'+"15b"+' -password:'+"1", "", "open", "1");
	//alert(sParam);
	excShell.ShellExecute(execName, sParam+"1", "", "open", "1");
}

function isBrowserCheck(){

	var agent = navigator.userAgent.toLowerCase();
	var name = navigator.appName;
	var browser="";
	//MS 계열 브라우저를 구분하기 위함.
	if(name === 'Microsoft Internet Explorer' || agent.indexOf('trident') > -1 || agent.indexOf('edge/') > -1) {
	    browser = 'ie';
	    if(name === 'Microsoft Internet Explorer') { // IE old version (IE 10 or Lower)
	        agent = /msie ([0-9]{1,}[\.0-9]{0,})/.exec(agent);
	        //browser += parseInt(agent[1]);
	    } else { // IE 11+
	        if(agent.indexOf('trident') > -1) { // IE 11 
	            //browser += 11;
	        } else if(agent.indexOf('edge/') > -1) { // Edge
	            browser = 'edge';
	        }
	        //browser="ie";	//강제TEST
	    }
	} else if(agent.indexOf('safari') > -1) { // Chrome or Safari
	    if(agent.indexOf('opr') > -1) { // Opera
	        browser = 'opera';
	    } else if(agent.indexOf('chrome') > -1) { // Chrome
	        browser = 'chrome';
	    } else { // Safari
	        browser = 'safari';
	    }
	} else if(agent.indexOf('firefox') > -1) { // Firefox
	    browser = 'firefox';
	}

	return browser;
}
//MES WEB버전 Miracom.SmartWeb.MainUI.dll 체크로직
//http://mes-h1.dnka.kr/bin/Miracom.SmartWeb.MainUI.dll
//http://scm-mes.dnke.kr/bin/Miracom.SmartWeb.MainUI.dll
