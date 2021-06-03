/**
 * 
 */

var miplatFormIntall=""; //마이플렛폼 설치여부 플래그
var miplatFormUrl=""; //마이플렛폼 URL

var rltSessionType="";	//return 세션 구분


//Display&Print Session
function linkOpen(pSystemNm, pDioneId, pCompanyCd, pPlantCd) {
	var rlt = isBrowserCheck();
	mask.open();
	var systemNm = pSystemNm;
	var dioneId = pDioneId;
	var companyCd = pCompanyCd;
	var plantCd = pPlantCd;
	var checkCode = "Y";
	
	var rltSessionParam="";	//return 세션 정보
	var rltSessionArray="";	//return 세션 정보 split
		rltSessionType="";	//return 세션 구분
	
	//console.log(systemNm+"=="+dioneId+"=="+companyCd+"=="+plantCd+"=="+checkCode);
	$.ajax({
		method : "post",
		url : "/ssoSessionAccounts.do",
		data : {systemNm: systemNm, dioneId: dioneId, companyCd: companyCd, plantCd: plantCd, checkCode: checkCode},
		success : function(data) {
			//console.log("success");
			try {
				var parse = JSON.parse(data);
					rltSessionType = parse.sysName;
					rltSessionParam = parse.sessionParam;
					rltSessionArray = rltSessionParam.split("||");
				if(parse.result == "y"){
					//console.log(parse.url);
					//console.log(parse.sessionParam);
					//console.log(parse.sessionCount);
					if(rlt=="ie"){
						//toastMsg('[알림]성공');
						/*
						window.open(parse.url,"linkPop","width=1040,height=700,scrollbars=yes,top=100,left=100");
						window.close();
						*/
						if(rltSessionType == "disPlay"){
							//console.log("rltSessionArray : "+rltSessionArray.length);
							//console.log("rltSessionArray : "+rltSessionArray);
							
							for(i=0; i <rltSessionArray.length-1; i++){
								//console.log("rltSessionArray : ["+i+"]"+rltSessionArray[i]);
								//console.log("http://10.74.227.115/sessionDisplayNew"+(i+1)+".jsp?"+rltSessionArray[i]);
								//window.open("http://10.74.227.115/sessionDisplayNew"+(i+1)+".jsp?"+rltSessionArray[i],"linkPop","width=1040,height=700,scrollbars=yes,top=100,left=100");
								//window.open("http://dione.dnke.kr/sessionDisplayNew"+(i+1)+".jsp?"+rltSessionArray[i],"linkPop","width=1040,height=700,scrollbars=yes,top=100,left=100");
								//var rltReplace = replaceUrl(rltSessionArray[i]);
								//alert(rltReplace);
								//window.open("http://dione.dnke.kr/sessionDisplayNew"+(i+1)+".jsp?"+rltReplace,"linkPop","width=1040,height=700,scrollbars=yes,top=100,left=100");
								/*
								setTimeout(function() {
									window.open("http://dione.dnke.kr/sessionDisplayNew"+(i+1)+".jsp?"+rltReplace,"linkPop","width=1040,height=700,scrollbars=yes,top=100,left=100");
								}, 3000);//3초후 
								*/
								(function(x){
									var rltReplace = replaceUrl(rltSessionArray[x]);
									setTimeout(function(){
								    	window.open("http://dione.dnke.kr/sessionDisplayNew"+(x+1)+".jsp?"+rltReplace,"linkPop","width=1040,height=700,scrollbars=yes,top=100,left=100");
								    }, 1500*x);	//1.5초
								  })(i);
							}
							/*
							window.opener = 'nothing';
							window.open('','_parent','');
							window.close();
							*/
							setTimeout(function(){
								window.opener = 'nothing';
								window.open('','_parent','');
								window.close();
						    }, 4000);	//4초
							//window.close();
							/*
							rltSessionParam =parse.sessionParam;
							window.open("http://10.74.227.115/sessionDisplayNew.jsp?rltSessionParam="+rltSessionParam,"linkPop","width=1040,height=700,scrollbars=yes,top=100,left=100");
							window.close();
							*/
						}
					}else{
						toastMsg('[알림]인터넷익스플로우만 사용가능합니다.');
					}
				}else if(parse.result=="n"){
					toastMsg('지정된 링크가 없습니다.');
				}else if(parse.result=="i"){
					if(rlt=="ie"){
						miplatFormIntall = window.open(parse.urlSetup,"InstallPop","width=1040,height=700,scrollbars=yes,top=100,left=100");	
						if(rltSessionType == "disPlay"){
							miplatFormUrl = rltSessionArray;
						}else{
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
	if(returnValue == "OK"){
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
			/*
			window.opener = 'nothing';
			window.open('','_parent','');
			window.close();
			*/
			setTimeout(function(){
				window.opener = 'nothing';
				window.open('','_parent','');
				window.close();
		    }, 4000);	//4초
		}else{
			window.open(miplatFormUrl,"linkPop","width=1040,height=700,scrollbars=yes,top=100,left=100");
		}
	}
}

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
