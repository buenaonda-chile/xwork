

$(document).ready(function() {
	
	objectResize();
}) 


function locationChange() {
	$('#WAN004MiPlatformForm').submit();
}

function CreateMiPlatformCtrl()
{
	/*	
 	document.MiPlatformCtrl.AutoSize = false;
	document.MiPlatformCtrl.Key      = "callDione";
 	document.MiPlatformCtrl.startxml = "http://dione.dnka.kr/ui/denso_ci_main_Win32_Inf.xml";
 	//document.MiPlatformCtrl.InitUrl  = "PSSALLIB::SPMC128Q.xml";
 	document.MiPlatformCtrl.InitUrl  = "PSFACLIB::FACC110.xml";
 	//document.MiPlatformCtrl.InitUrl  = "PSOGMLIB::OBSE01.xml";
 	//document.MiPlatformCtrl.InitUrl  = "PSOGMLIB::OBMZ230Q.xml";
  	document.MiPlatformCtrl.DoRun();
 	//document.MiPlatformCtrl.ShowMenuBar(false);
	*/
 	document.MiPlatformCtrl.DoRun();
 	document.MiPlatformCtrl.ShowMenuBar(false);
}

//조회
function callSearch() {
	document.MiPlatformCtrl.CallScript(document.MiPlatformCtrl.startxml,"mi_fn_Search()");	//MiPlatformMX용
	//document.MiPlatformCtrl.CallScript("fn_Search()"); 	//MiPlatformX용
}
//추가
function callInput() {
	document.MiPlatformCtrl.CallScript(document.MiPlatformCtrl.startxml,"mi_fn_Input()");	//MiPlatformMX용
	//document.MiPlatformCtrl.CallScript("fn_Input()"); 	//MiPlatformX용
}
//삭제
function callDelete() {
	document.MiPlatformCtrl.CallScript(document.MiPlatformCtrl.startxml,"mi_fn_Delete()");	//MiPlatformMX용
	//document.MiPlatformCtrl.CallScript("fn_Delete()"); 	//MiPlatformX용
}
//저장
function callSave() {
	document.MiPlatformCtrl.CallScript(document.MiPlatformCtrl.startxml,"mi_fn_Save()");	//MiPlatformMX용
	//document.MiPlatformCtrl.CallScript("fn_Save()"); 	//MiPlatformX용
}
//출력
function callPrint() {
	document.MiPlatformCtrl.CallScript(document.MiPlatformCtrl.startxml,"mi_fn_print()");	//MiPlatformMX용
	//document.MiPlatformCtrl.CallScript("fn_print()"); 	//MiPlatformX용
}
//엑셀
function callExcel() {
	document.MiPlatformCtrl.CallScript(document.MiPlatformCtrl.startxml,"mi_fn_Excel()");	//MiPlatformMX용
	//document.MiPlatformCtrl.CallScript("fn_Excel()"); 	//MiPlatformX용
}

function setBtnAuth(bcType){
	//var bcType=document.MiPlatformCtrl.GetGlobalVariableValue(document.MiPlatformCtrl.startxml,"G_BtnAuth");
	
    //개인권한 사용여부에 따른 개인권한설정버튼 디스플레이 유무	
	if(bcType=="0"){ //기본(enable:없음) 
		$('#MiPlatformBtn').empty();
	} else if(bcType=="1"){ //조회메뉴(enable:조회,excel)
		//$('#searchBtn').remove();
		$('#registerBtn').remove();
		$('#deleteBtn').remove();
		$('#saveBtn').remove();
		$('#printBtn').remove();
		//$('#excelBtn').remove();	
	} else if(bcType=="1.1"){ //조회메뉴(enable:조회,발행,excel)
		//$('#searchBtn').remove();
		$('#registerBtn').remove();
		$('#deleteBtn').remove();
		$('#saveBtn').remove();
		//$('#printBtn').remove();
		//$('#excelBtn').remove();	
	} else if(bcType=="1.2"){ //조회메뉴(enable:조회)
		//$('#searchBtn').remove();
		$('#registerBtn').remove();
		$('#deleteBtn').remove();
		$('#saveBtn').remove();
		$('#printBtn').remove();
		$('#excelBtn').remove();
	} else if(bcType=="1.3"){ //조회메뉴(enable:즐겨찾기, 발행)
		$('#searchBtn').remove();
		$('#registerBtn').remove();
		$('#deleteBtn').remove();
		$('#saveBtn').remove();
		//$('#printBtn').remove();
		$('#excelBtn').remove();
	} else if(bcType=="1.4"){ //조회메뉴(조회, 발행)
		//$('#searchBtn').remove();
		$('#registerBtn').remove();
		$('#deleteBtn').remove();
		$('#saveBtn').remove();
		//$('#printBtn').remove();
		$('#excelBtn').remove();
	}else if(bcType=="2.1"){ //변경메뉴-1(조회,추가,삭제,저장)
		//$('#searchBtn').remove();
		//$('#registerBtn').remove();
		//$('#deleteBtn').remove();
		//$('#saveBtn').remove();
		$('#printBtn').remove();
		$('#excelBtn').remove();
	} else if(bcType=="2.2"){ //변경메뉴-2(조회,추가,삭제,저장,excel)
		//$('#searchBtn').remove();
		//$('#registerBtn').remove();
		//$('#deleteBtn').remove();
		//$('#saveBtn').remove();
		$('#printBtn').remove();
		//$('#excelBtn').remove();
	} else if(bcType=="2.3"){ //변경메뉴-3(조회,저장,excel)
		//$('#searchBtn').remove();
		$('#registerBtn').remove();
		$('#deleteBtn').remove();
		//$('#saveBtn').remove();
		$('#printBtn').remove();
		//$('#excelBtn').remove();
	}else if(bcType=="2.4"){ //변경메뉴-4(조회,추가,저장)
		//$('#searchBtn').remove();
		//$('#registerBtn').remove();
		$('#deleteBtn').remove();
		//$('#saveBtn').remove();
		$('#printBtn').remove();
		$('#excelBtn').remove();
	}else if(bcType=="2.5"){ //변경메뉴-5(저장)
		$('#searchBtn').remove();
		$('#registerBtn').remove();
		$('#deleteBtn').remove();
		//$('#saveBtn').remove();
		$('#printBtn').remove();
		$('#excelBtn').remove();
	}else if(bcType=="2.6"){ //변경메뉴-2(조회,삭제,저장)
		//$('#searchBtn').remove();
		$('#registerBtn').remove();
		//$('#deleteBtn').remove();
		//$('#saveBtn').remove();
		$('#printBtn').remove();
		$('#excelBtn').remove();
	}else if(bcType=="2.7"){ //변경메뉴-2(조회,추가,저장,excel)
		//$('#searchBtn').remove();
		//$('#registerBtn').remove();
		$('#deleteBtn').remove();
		//$('#saveBtn').remove();
		$('#printBtn').remove();
		//$('#excelBtn').remove();
	}else if(bcType=="2.8"){ //변경메뉴-2(조회,삭제,저장, excel)
		//$('#searchBtn').remove();
		$('#registerBtn').remove();
		//$('#deleteBtn').remove();
		//$('#saveBtn').remove();
		$('#printBtn').remove();
		//$('#excelBtn').remove();	
	}else if(bcType=="2.9"){ //변경메뉴-2(삭제)
		$('#searchBtn').remove();
		$('#registerBtn').remove();
		//$('#deleteBtn').remove();
		$('#saveBtn').remove();
		$('#printBtn').remove();
		$('#excelBtn').remove();	
	}else if(bcType=="3.0"){ //변경메뉴-3(조회,추가,삭제,저장,출력,excel)		
		//$('#searchBtn').remove();
		//$('#registerBtn').remove();
		//$('#deleteBtn').remove();
		//$('#saveBtn').remove();
		//$('#printBtn').remove();
		//$('#excelBtn').remove();	
	}else if(bcType=="3.1"){ //변경메뉴-3(조회,삭제,저장,출력,excel)
		//$('#searchBtn').remove();
		//$('#registerBtn').remove();
		//$('#deleteBtn').remove();
		//$('#saveBtn').remove();
		$('#printBtn').remove();
		//$('#excelBtn').remove();
	}else if(bcType==""){
		//$('#MiPlatformBtn').empty();
	}
}

function objectResize(){
	/*
    var mCtl = $('#MiPlatformCtrl');
    mCtl.attr('height');
    mCtl.prop((parseInt(window.innerHeight)-65)); 
 */

	var tagObj = document.getElementById("MiPlatformCtrl");	//Default 650px
	if(tagObj == null) {
		return;
	}
	else {
		tagObj.style.height = (parseInt(window.innerHeight)-75)+'px';
	}	

	//alert(parseInt(window.innerHeight)+"=="+(parseInt(window.innerHeight)-65));
}
