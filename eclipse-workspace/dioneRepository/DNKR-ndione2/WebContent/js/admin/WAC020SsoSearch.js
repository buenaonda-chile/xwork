/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
"use strict";

//실행파일위치
//var execSCM="C:\\Program Files\\코아정보기술(주)\\SCM\\CORESCMLOGIN.exe";	//SCM(KA협력업체용)
var execSCMx86="C:\\Program Files\\코아정보기술(주)\\협력업체종합정보관리시스템\\COREERPLOGIN.exe";	//SCM(KA사내용)
var execSCMx64="C:\\Program Files (x86)\\코아정보기술(주)\\협력업체종합정보관리시스템\\COREERPLOGIN.exe";	//SCM(KA사내용)
var execMES="\\Microsoft\\Windows\\Start Menu\\Programs\\Miracom Inc\\MESplusV5 EE\\MESClient.lnk ";	//MES(사내용7용)
//var execMES_C1="\\Denso Korea\\MESplusV5 EE\\MESClient\\MESClient.exe ";	//MES(협력업체용 창원)
//var execMES_H1="http://mes-h1.dnka.kr ";	////MES(협력업체용 홍성)
//var execMES_KE="\\Microsoft\\Windows\\Start Menu\\Programs\\Miracom Inc\\MESplusV5 EE\\MESClient.lnk ";	//MES(사내용7용)
//var execMES_KA="\\Microsoft\\Windows\\Start Menu\\Programs\\Miracom Inc\\MESplusV5 EE\\MESClient.lnk ";	//MES(사내용7용)
//var execMES_KA="\\Miracom Inc\\MESplusV5 EE\\MESClient\\MESClient.exe ";	//MES(사내용 XP용)
var execOrderProdx86="C:\\Program Files\\코아정보기술(주)\\DNPE순서생산\\COREERPLOGIN.exe";	//순서생산(KE)
var execOrderProdx64="C:\\Program Files (x86)\\코아정보기술(주)\\DNPE순서생산\\COREERPLOGIN.exe";	//순서생산(KE)
var execPreventionx86="C:\\Program Files\\불량유출방지 시스템\\UpNStart_ALL.exe"; //공정누락방지(KE)
var execPreventionx64="C:\\Program Files (x86)\\불량유출방지 시스템\\UpNStart_ALL.exe"; //공정누락방지(KE)
var execSPC_Cx86="C:\\Program Files\\DNKASPC\\UpNStart.exe"; //SPC(KAC)
var execSPC_Cx64="C:\\Program Files (x86)\\DNKASPC\\UpNStart.exe"; //SPC(KAC)
var execSPC_Hx86="C:\\Program Files\\DNHOSPC\\UpNStart.exe"; //SPC(KAH)
var execSPC_Hx64="C:\\Program Files (x86)\\DNHOSPC\\UpNStart.exe"; //SPC(KAH)
var execSPC_Sx86="C:\\Program Files\\DNHSSPC\\UpNStart.exe"; //SPC(KAS)
var execSPC_Sx64="C:\\Program Files (x86)\\DNHSSPC\\UpNStart.exe"; //SPC(KAS)
//var execSPC32="C:\\Program Files\\DNKASPC\\UpNStart.exe"; //SPC(KAC)
//var execSPC64="C:\\Program Files (x86)\\DNKASPC\\UpNStart.exe"; //SPC(KAC)

//설치파일위치
//var instSCM="http://10.72.149.81:8080/CWORKS/Setup/SCM";	//SCM(KA협력업체용)
var instSCM="http://10.72.149.81:8080/CWORKS/Setup/PGM";	//SCM(KA사내용)
var instMES="";//MES
//var instMES_C1="http://cvs2802.korea.asia.denso:8099/publishOSP.htm";	//MES창원(KA협력업체용)
//var instMES_KE="\\\\Evs017\\MES\\9 V5.3Client Setup For 7";	//MES(KE사내용)
var instMES_KE="\\\\10.73.254.163\\ssosw\\3.MES\\KE";	//MES(KE사내용)
var instMES_KA="ftp://10.72.149.96/0.%BC%B3%C4%A1%20%20%A1%D9%A1%DA%A1%D9_%BB%E8%C1%A6%B1%DD%C1%F6%20%A1%DA%A1%D9%A1%DA/0.MES/1.MESClientSetupKitFor7/";	//MES(KA사내용)
//var instMES_KA="http://10.72.149.96:8099/publishMES.htm";	//MES(KA사내용)
//var instMES_H1="http://mes-h1.dnka.kr ";	//MES창원
var instOrderProd="http://orderprod.dnke.kr:8080/CWORKS/Setup/PGM/"; //순서생산(KE)
//var instPrevention="\\\\10.73.254.163\\net_int\\setup\\setup.exe"; //공정누락방지(KE)
//var instSPC_C="\\\\10.73.254.163\\net_int\\2.SPC\\KAC\\setup.exe";//SPC(KA창원)
var instPrevention="\\\\10.73.254.163\\ssosw\\1.Prevention\\setup.exe"; //공정누락방지(KE)
//var instSPC_C="\\\\10.73.254.163\\ssosw\\2.SPC\\KAC\\setup.exe";//SPC(KA창원)
//var instSPC_H="\\\\10.73.254.163\\ssosw\\2.SPC\\KAH\\setup.exe"; //SPC(KA홍성)
//var instSPC_S="\\\\10.73.254.163\\ssosw\\2.SPC\\KAS\\setup.exe"; //SPC(KA화성)
var instSPC_C="\\\\10.73.254.163\\ssosw\\2.SPC\\KAC\\SetupDNKASPC.msi";//SPC(KA창원)
var instSPC_H="\\\\10.73.254.163\\ssosw\\2.SPC\\KAH\\SetupDNHOSPC.msi"; //SPC(KA홍성)
var instSPC_S="\\\\10.73.254.163\\ssosw\\2.SPC\\KAS\\SetupDNHSSPC.msi"; //SPC(KA화성)

//미사용
function linkOpen(sysSeq, sysType) {
	if(sysType=="CS"){
		runFile(sysSeq);
	}else{
		openLink(sysSeq);
	}
}

function openLink(sysSeq, sysType, company) {
	
	var pJob = $('#pCompany')[0].selectedIndex;
	if (pJob == "") {
		alert("[알림]사업부를 선택해주세요.");
		return;
	}
		
	var rltBrower = isBrowserCheck();
	mask.open();
	var systemSeq;
	systemSeq = sysSeq;
	var company = $('#pCompany').val();	//2019.11.20 수정
		
	$.ajax({
		method : "post",
		url : "/ssoAccounts.do",
		data : {systemSeq: systemSeq, ssoCompany: company},
		success : function(data) {
			try {
				var parse = JSON.parse(data);
				if(parse.result=="y"){	    
					console.log(parse.url);
					/*window.open(parse.url,"linkPop","width=1040,height=700,scrollbars=yes,top=100,left=100");*/
					if(parse.appType=="cs"){
						//alert("cs");
						if(rltBrower=="ie"){
							if(systemSeq=="1" || systemSeq =="11" || systemSeq =="12" || systemSeq =="13" || systemSeq =="15"){
								//PGM(KA SCM, KE 순서생산, KE 공정누락, KE/KA MES, KA SPC)
								var rlt = runFileCheck(systemSeq, parse.rltParam);
								if(rlt == false) return;
								if(systemSeq =="1" || systemSeq =="11"){	//PGM(KA SCM, KE 순서생산)
									//window.open("http://orderprod.dnke.kr:8080/DNPESTART/Default.aspx?id=E030172");	
									if(systemSeq =="1"){	//PGM(KA SCM, KE 순서생산)
										window.open(parse.url);
									}else{
										window.open(parse.url, "noticePop", "resizable=yes, width=300,height=200");
									}
								}else if(systemSeq =="12"|| systemSeq =="13"|| systemSeq =="15"){	//PGM(KE 공정누락, KE/KA MES, KA SPC)
									runFileExec(systemSeq, parse.rltParam);
								}
							}
						}else{
							toastMsg('[알림]인터넷익스플로우만 사용가능합니다.');
							return;
						}
					}else{
						//alert("web");
						//window.open(parse.url);
						var rltReplace = replaceUrl(parse.url);
						window.open(rltReplace);						
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

function runFileCheck(sysSeq, sParam){
	var rlt = true;		
	
	var execName="";	//실행파일
	var instName="";	//설치파일
	
	var WshShell="";
	try {
		WshShell = new ActiveXObject("WScript.Shell");
	} catch (e) {
		rlt = false;
		alert("'인터넷옵션>보안>>신뢰할수 있는 사이트'에  등록하셔야 정상작동 합니다.");
		//alert("1)인터넷옵션>보안>>신뢰할수 있는 사이트에  등록 \n"+
	    //  "2)인터넷옵션>보안>인터넷>사용자지정수준>스크립팅하기 안전하지 않은 것으로 표시된 ActiveX 컨트롤 초기화를 '사용'으로 수정하셔야 정상작동 합니다.");
	}
	if(rlt != false){	//ActiveX가 정상동작일 때만 동작
		var fileTF = new ActiveXObject("Scripting.FileSystemObject");
		//var WshShell = new ActiveXObject("WScript.Shell");
		//var fileTF = new ActiveXObject("Scripting.FileSystemObject");
		var osBit = isOSbitCheck();
		//alert(osBit);
		if(sysSeq=='1'){	//KA SCM
			instName = instSCM;
			execName = execSCMx86;
			if(osBit=='x64'){
				execName = execSCMx64;
			}
		}else if(sysSeq=='11'){	//KE 순서생산
			instName = instOrderProd;
			execName = execOrderProdx86;
			if(osBit=='x64'){
				execName = execOrderProdx64;
			}
		}else if(sysSeq=='12'){	//KE 공정누락
			instName = instPrevention;
			execName = execPreventionx86;
			if(osBit=='x64'){
				execName = execPreventionx64;
			}
		}else if(sysSeq=='13'){	//KE/KA MES
			var p_comps = $('#pCompany').val();
			if(p_comps=="PE"){
				instName=instMES_KE;
				//execMES=execMES_KE;
			}else{
				instName=instMES_KA;
				//execMES=execMES_KA;
			}
			
			execName = WshShell.ExpandEnvironmentStrings("%AppData%")+execMES;
			//execName = WshShell.ExpandEnvironmentStrings("%userprofile%")+execMES;
		}else if(sysSeq=='15'){	//KA SPC(공장별 설치파일 및 실행파일 경로가 다름
			var sParamSplit = sParam.split("||");
			//alert(sParamSplit[0]+"==="+sParamSplit[1]);
			if(sParamSplit[1]=="C1"){
				instName = instSPC_C;
				execName = execSPC_Cx86;
				if(osBit=='x64'){
					execName = execSPC_Cx64;
				}
			}else if(sParamSplit[1]=="H1"){
				instName = instSPC_H;
				execName = execSPC_Hx86;
				if(osBit=='x64'){
					execName = execSPC_Hx64;
				}
			}else if(sParamSplit[1]=="S1"){
				instName = instSPC_S;
				execName = execSPC_Sx86;
				if(osBit=='x64'){
					execName = execSPC_Sx64;
				}
			}
			//alert(sParamSplit[1]);
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
	var osBit = isOSbitCheck();	//OS bit체크
	
	if(sysSeq=='12'){	//KE 공정누락
		execName = execPreventionx86;
		if(osBit=='x64'){
			execName = execPreventionx64;				
		}
		//alert(sParam+"=="+execName);
	}else if(sysSeq=='13'){	//KE/KA MES
		execName = WshShell.ExpandEnvironmentStrings("%AppData%")+execMES;//사내용 실행파일위치는 동일함
		//execName = WshShell.ExpandEnvironmentStrings("%userprofile%")+execMES;
		//excShell.ShellExecute(execName, ' -factory:'+"DNP1"+' -userId:'+"1111"+' -password:'+"2222", "", "open", "1");
		//excShell.ShellExecute(execName, ' -siteId:mes-c1.densops.co.kr -factory:'+"OSP1"+' -userId:'+"15b"+' -password:'+"1", "", "open", "1");
		//alert(sParam);
	}else if(sysSeq=='15'){	//KA SPC
		var sParamSplit = sParam.split("||");		
		sParam=sParamSplit[0];
		if(sParamSplit[1]=="C1"){
			execName = execSPC_Cx86;
			if(osBit=='x64'){
				execName = execSPC_Cx64;				
			}
		}else if(sParamSplit[1]=="H1"){
			execName = execSPC_Hx86;
			if(osBit=='x64'){
				execName = execSPC_Hx64;				
			}
		}else if(sParamSplit[1]=="S1"){
			execName = execSPC_Sx86;
			if(osBit=='x64'){
				execName = execSPC_Sx64;				
			}
		}	
		//alert(sParam);
	}
	excShell.ShellExecute(execName, sParam, "", "open", "1");
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

//OS bit체크
function isOSbitCheck(){

	var osVersion  = navigator.userAgent;	//OS버전체크
	var agentUserOs= osVersion.replace(/ /g,'');
	var rltOsBit="";

	if(agentUserOs.indexOf("WOW64") != -1){
		//alert("WOW64");
		rltOsBit = "x64";
	}else{
		//alert("on x86");
		rltOsBit = "x86";
	} 

	return rltOsBit;
}

//특수기호 파라미터 변환
function replaceUrl(url) {
    url= url.replace(/#/g,"%23"); 
    //url= url.replace(/%/g,"%25"); 
    //url= url.replace(/?/g,"%3F"); 
    //url= url.replace(/=/g,"%3D"); 
    //url= url.replace(/3F/g,"%2F"); 
    //url= url.replace(/\//g,"%23"); 
    //url= url.replace(/#/g,"%23"); 
    return url;
}

$(document.body).ready(function () {

	// 셀렉트 박스 selected 인덱스번호 저장
	
	var pCompanyDefault = $('#pCompany')[0].selectedIndex;
	$('#pCompany').change(function() {
		/*
		$(this)[0].selectedIndex = pCompanyDefault;
		alert("[알림]해당값은 변경할 수 없습니다.")
		return;
		*/
		if(pCompanyDefault!=""){
			$(this)[0].selectedIndex = pCompanyDefault;
			alert("[알림]해당값은 변경할 수 없습니다.")
			return;
		}
		$("#WAC020SsoSearchForm").attr("action", "search.do");
		$("#WAC020SsoSearchForm").submit();
	});
	
});

