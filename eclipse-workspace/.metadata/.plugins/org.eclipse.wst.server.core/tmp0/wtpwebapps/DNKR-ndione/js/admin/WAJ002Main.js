/**
 * 
 */

var miplatFormIntall=""; //마이플렛폼 설치여부 플래그
var miplatFormUrl=""; //마이플렛폼 URL

var rltSessionType="";	//return 세션 구분


//HR Link
function openLink(obj) {
	mask.open();
	var tagName = $(obj).prop("tagName").toLowerCase();
	var systemSeq;
	var pageType;	//2019.11.19추가
	if (tagName === "a") {
		systemSeq = $(obj).attr('data-systemSeq');
		pageType = $(obj).attr('data-pageType');
	} else if (tagName === "span") {
		systemSeq = $(obj).prev().attr('data-systemSeq');
		pageType = $(obj).attr('data-pageType');
	}
	$.ajax({
		method : "post",
		url : "/ssoAccounts.do",
		data : {systemSeq: systemSeq, pageType: pageType},
		success : function(data) {
			try {
				var parse = JSON.parse(data);
				if(parse.result=="y"){	    
					console.log(parse.url);
					/*window.open(parse.url,"linkPop","width=1040,height=700,scrollbars=yes,top=100,left=100");*/
					window.open(parse.url);
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

//Display&Print Session
function sessionLink(obj) {
	
	var rlt = isBrowserCheck();
	mask.open();
	var tagName = $(obj).prop("tagName").toLowerCase();
	var systemNm;
	if (tagName === "a") {
		systemNm = $(obj).attr('data-systemNm');
	} else if (tagName === "span") {
		systemNm = $(obj).prev().attr('data-systemNm');
	}
	var rltSessionParam="";	//return 세션 정보
	var rltSessionArray="";	//return 세션 정보 split
		rltSessionType="";	//return 세션 구분
		
	$.ajax({
		method : "post",
		url : "/ssoSessionAccounts.do",
		data : {systemNm : systemNm},
		success : function(data) {
			try {
				var parse = JSON.parse(data);
					rltSessionType = parse.sysName;
					rltSessionParam = parse.sessionParam;
					rltSessionArray = rltSessionParam.split("||");
				if(parse.result=="y"){
					console.log(parse.url);
					if(parse.url =="dione"){
						/* 미사용
						$("#userId").val(parse.sysId); 
						postLink(obj);
						*/
					}else{
						//alert(rlt);
						//console.log(parse.sessionParam);
						//console.log(parse.sessionCount);
						if(rlt=="ie"){
							/*
							//toastMsg('[알림]성공');
							window.open(parse.url,"linkPop","width=1040,height=700,scrollbars=yes,top=100,left=100");	
							*/			
							//toastMsg('[알림]성공');
							if(rltSessionType == "disPlay"){
								//console.log("rltSessionArray : "+rltSessionArray.length);
								//console.log("rltSessionArray : "+rltSessionArray);
								for(i=0; i <rltSessionArray.length-1; i++){
									//console.log("rltSessionArray : ["+i+"]"+rltSessionArray[i]);
									//console.log("http://dione.dnke.kr/sessionDisplay"+(i+1)+".jsp?"+rltSessionArray[i]);
									//window.open("http://10.74.227.115/sessionDisplayNew"+(i+1)+".jsp?"+rltSessionArray[i],"linkPop","width=1040,height=700,scrollbars=yes,top=100,left=100");
									//window.open("http://dione.dnke.kr/sessionDisplayNew"+(i+1)+".jsp?"+rltSessionArray[i],"linkPop","width=1040,height=700,scrollbars=yes,top=100,left=100");
									/*
									var rltReplace = replaceUrl(rltSessionArray[i]);
									setTimeout(function() {
										window.open("http://dione.dnke.kr/sessionDisplayNew"+(i+1)+".jsp?"+rltReplace,"linkPop","width=1040,height=700,scrollbars=yes,top=100,left=100");
									}, 3000);//3초후 
									*/
									//클로저처리
									(function(x){
										var rltReplace = replaceUrl(rltSessionArray[x]);
									    setTimeout(function(){
									    	window.open("http://dione.dnke.kr/sessionDisplayNew"+(x+1)+".jsp?"+rltReplace,"linkPop","width=1040,height=700,scrollbars=yes,top=100,left=100");
									    }, 1500*x);	//1초
									})(i);
								}
							}else if(rltSessionType == "printer"){
								window.open(parse.url,"linkPop","width=1040,height=700,scrollbars=yes,top=100,left=100");									
							}
						}else{
							toastMsg('[알림]인터넷익스플로우만 사용가능합니다.');
						}
						//window.open(parse.url,"linkPop","width=1040,height=700,scrollbars=yes,top=100,left=100");	
					}
				}else if(parse.result=="n"){
					toastMsg('지정된 링크가 없습니다.');
				}else if(parse.result=="i"){
					if(rlt=="ie"){
						//toastMsg('설치페이지로 이동합니다.');
						/*
						var rltPop = window.showModalDialog(parse.urlSetup, self,"dialogWidth:1040px; dialogHeight:700px");
						window.self.location.reload(true);
						if(rltPop=="OK"){
							window.open(parse.url,"linkPop","width=1040,height=700,scrollbars=yes,top=100,left=100");	
						}
						*/
						/*
						miplatFormIntall = window.open(parse.urlSetup,"InstallPop","width=1040,height=700,scrollbars=yes,top=100,left=100");	
						miplatFormUrl = parse.url;
						*/
						miplatFormIntall = window.open(parse.urlSetup,"InstallPop","width=1040,height=700,scrollbars=yes,top=100,left=100");	
						if(rltSessionType == "disPlay"){
							miplatFormUrl = rltSessionArray;
						}else if(rltSessionType == "printer"){
							miplatFormUrl = parse.url;
						}
					}else{
						toastMsg('[알림]인터넷익스플로우만 사용가능합니다.');
					}
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
function postLink(obj){
	$("#dioneForm").one("submit", function() {
		window.open('','pop_dione','width=700, height=600');
		this.action = "http://dione.dnke.kr/login/checkLoginSSO.do";
		this.method = 'POST';
		this.target = 'pop_dione';
     }).trigger("submit"); 
}
/* 미사용
function postLink_org(obj){
	//$("#dioneForm").attr('action', "http://dione.dnke.kr/login/checkLoginLdap.do").submit();
	//alert($( "#userId" ).val());
	//$("#password").val()
	
	$("#userId").val(""); 
	$("#password").val(""); 
	$("#dioneForm").one("submit", function() {
		window.open('','pop_dione','width=700, height=600');
		this.action = "http://dione.dnke.kr/login/checkLoginLdap.do";
		this.method = 'POST';
		this.target = 'pop_dione';
     }).trigger("submit"); 
}
*/
function pageLink(obj){

	var pType="";
	var pUseTf ="Y";
	var pMenuId="";
	var linkType= $(obj).attr('data-systemType');
	
	if(linkType == "internal"){
		//pType = "PE";
		pMenuId="761";
		location.href="/WAA000Sub/init.do?menu="+pMenuId;
	}else{
		if(linkType == "external"){
			pType = "MAKER";
			pMenuId="686";
		}else if(linkType == "global"){
			pType = "GLOBAL";		
			pMenuId="686";
		}
		location.href="/WAA000Sub/init.do?menu="+pMenuId+"&pType="+pType;
	}
}

function etcLink(obj){

	var linkType= $(obj).attr('data-systemType');
	var etcUrl="";
	if(linkType == "visit"){	//방문자예약사이트
		//etcUrl="http://visit.densokorea.com/_visit/_main/main.html";
		etcUrl="http://visit.densokorea.com";  
		//window.open(etcUrl,"linkPop","scrollbars=yes,top=100,left=100");	
		window.open(etcUrl);	
	}
}
/* 미사용
function sessionPrtLink(obj) {
	//var prtParam="/H cigma_c1.dnka.kr /D H00PC /S1";
	var prtParam1="/H cigma_c1.dnka.kr /D H00PC /S";
	var prtParam2="/H cigma_c1.dnka.kr /D H00PD /S";
	var sessionCnt=2;
	window.open("http://dione.dnka.kr/sessionPrinterCheck.jsp?PrtSetup1='"+prtParam1+"'&PrtSetup2='"+prtParam2+"'&SessionCnt="+sessionCnt,"sessionPrt","toolbar=no");
}
*/

// Brower version Check
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
/*
function getReturnValue(returnValue) {
	if(returnValue=="OK"){
		miplatFormIntall.close();
		window.open(miplatFormUrl,"linkPop","width=1040,height=700,scrollbars=yes,top=100,left=100");
	}
}
*/
function getReturnValue(returnValue) {
	if(returnValue=="OK"){
		miplatFormIntall.close();
		if(rltSessionType == "disPlay"){
			for(i=0; i <miplatFormUrl.length-1; i++){
				//window.open("http://dione.dnke.kr/sessionDisplayNew"+(i+1)+".jsp?"+miplatFormUrl[i],"linkPop","width=1040,height=700,scrollbars=yes,top=100,left=100");
				//var rltReplace = replaceUrl(miplatFormUrl[i]);
				//window.open("http://dione.dnke.kr/sessionDisplayNew"+(i+1)+".jsp?"+rltReplace,"linkPop","width=1040,height=700,scrollbars=yes,top=100,left=100");
				/*
				setTimeout(function() {
					window.open("http://dione.dnke.kr/sessionDisplayNew"+(i+1)+".jsp?"+rltReplace,"linkPop","width=1040,height=700,scrollbars=yes,top=100,left=100");
				}, 3000);//3초후 
				*/
				(function(x){
					var rltReplace = replaceUrl(miplatFormUrl[x]);
				    setTimeout(function(){
				    	window.open("http://dione.dnke.kr/sessionDisplayNew"+(x+1)+".jsp?"+rltReplace,"linkPop","width=1040,height=700,scrollbars=yes,top=100,left=100");
				    }, 1500*x);	//1.5초
				})(i);
			}
		}else{
			window.open(miplatFormUrl,"linkPop","width=1040,height=700,scrollbars=yes,top=100,left=100");
		}
	}
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
//DIONE ID 카운트(Display Session용)
function sessionIdCount(obj) {
	
	var rlt = isBrowserCheck();
	mask.open();
	var tagName = $(obj).prop("tagName").toLowerCase();
	var systemNm;
	if (tagName === "a") {
		systemNm = $(obj).attr('data-systemNm');
	} else if (tagName === "span") {
		systemNm = $(obj).prev().attr('data-systemNm');
	}
	
	//alert("sessionIdCount");
	//var pUuserId="";	//dione ID
	//var pPantCd="";	//dione ID별 공장코드
	var pIdPant="";	//dione ID/공장코드
	var dioneAccountCnt="";
	var userIdPantCd=""; //dione ID/공장코드
	
	$.ajax({
		method : "post",
		url : "/ssoSessionAccounts2.do",
		data : {systemNm : systemNm},
		success : function(data) {
			try {
				var parse = JSON.parse(data);
				if(parse.result=="y"){
					dioneAccountCnt=parse.dioneAccount;
					//pUuserId = parse.dioneId;
					//pPantCd =parse.plantCd;
					//userIdPantCd = pUuserId.split("||")+"||"+pPantCd.split("||");
					pIdPant =parse.idPlant;
					userIdPantCd = pIdPant.split("||");
					//userIdPantCd = pIdPant;
					//alert("ID 수 : "+dioneAccountCnt+" ID = "+userIdPantCd);
					if(dioneAccountCnt > 1){
						//alert("1개이상");
						window.open("/WAA001MainPopup/sessionIdSelectPop.do"+"?userIdPantCd="+userIdPantCd,"sessionSelectPop","width=320, height=200");
						//var popupW = 320;
						//var popupH = 200;
						//var left = Math.ceil((window.screen.width - popupW)/2);
						//var top = Math.ceil((window.screen.height - popupH - 200)/2);
						//window.open("/WAA001MainPopup/sessionIdSelectPop.do"+"?userIdPantCd="+userIdPantCd,"sessionSelectPop",'width='+popupW+',height='+popupH+',left='+left+',top='+top);			
					}else{
						//alert("1개");
						$('#disPlaySession').trigger('click'); 
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

//미사용
/*
function runFile(){
	WshShell = new ActiveXObject("WScript.Shell");
	WshShell.Run("c:/Program Files/불량유출방지 시스템/UpNStart_ALL.exe", 1, false);
	
//	var path = String.fromCharCode(34)+'C:\\Program Files\\Starcraft\\StarCraft.exe'+String.fromCharCode(34) ;
//	 alert(path); 
//	 var WshShell = new ActiveXObject("WScript.Shell");
//	 WshShell.Run(path);
}
*/