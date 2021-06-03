

$(document).ready(function() {
	mask.open();
	CreateMiPlatformCtrl();
	$('._searchBtn_').on('click', function() {
		callSearch();
		return false;
	});	
	
	$('.addBtn').on('click', function() {
		callInput();
	});
	
	$('.delBtn').on('click', function() {
		callDelete();
	});
	
	$('.saveBtn').on('click', function() {
		callSave();
	});
	
	$('.printBtn').on('click', function() {
		callPrint();
	});
	
	$('.exel').on('click', function() {
		callExcel();
	});
	
}) 

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
	try {
		document.MiPlatformCtrl.DoRun();
		document.MiPlatformCtrl.ShowMenuBar(false);
	} catch (e) {
		console.log(e);
	}
	setTimeout(function() {
		mask.close();
	}, 500);
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
	//document.MiPlatformCtrl.CallScript(document.MiPlatformCtrl.startxml,"setParam()");	//MiPlatformMX용
}

//미사용
function setGloParamKey() {
	var G_ParamKey =  "E110290::제환복::PE::E1::PERESLIB::PSEDBLIB::PSEDBLIB::CLTDTAE::1234";
	document.MiPlatformCtrl.CallScript(document.MiPlatformCtrl.startxml,"setParam('"+G_ParamKey+"')");	//MiPlatformMX용
}
