﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿var callIp 	 = "10.73.254.7";
var callUser = "xx";
var callPass = "xx";
var pgmSize  = 103;	

/*********************************************************************
*  회사명 dataset 생성                                               *
*********************************************************************/
function setCompanyName(ds) {
	ds.InsertRow(0);
	ds.SetColumn(0,"code2","PE");
	//ds.SetColumn(0,"code_name","DENSO KOREA ELECTRONICS");
	ds.SetColumn(0,"code_name","DNKE");
	ds.InsertRow(1);
	ds.SetColumn(1,"code2","PS");
	//ds.SetColumn(1,"code_name","DENSO KOREA AUTOMOTIVE");	
	ds.SetColumn(1,"code_name","DNKA");
}
/*********************************************************************
*  회사명 dataset 생성                                               *
*********************************************************************/
function setCompsName(ds) {
	ds.InsertRow(0);
	ds.SetColumn(0,"code2","E1");
	ds.SetColumn(0,"code_name","DNKE");
	ds.InsertRow(1);
	ds.SetColumn(1,"code2","C1");
	ds.SetColumn(1,"code_name","KA창원");
	ds.InsertRow(2);
	ds.SetColumn(2,"code2","H1");
	ds.SetColumn(2,"code_name","KA홍성");
	ds.InsertRow(3);
	ds.SetColumn(3,"code2","S1");
	ds.SetColumn(3,"code_name","KA화성");
	ds.InsertRow(4);
	ds.SetColumn(4,"code2","R1");
	ds.SetColumn(4,"code_name","DIKR");
}
/*********************************************************************
*  REMOTE CALL PROGRAM ID,PASSWORD가져오기                           *
*********************************************************************/
function getRemotecallID(sCOMPS){
	var reTurnV;
	if (sCOMPS ="E1"){
		reTurnV = "CDNPE_REMC";
	}else if (sCOMPS ="C1"){
		reTurnV = "CDNPS_REMC";
	}else if (sCOMPS ="H1"){
		reTurnV = "HDNPS_REMC";
	}else if (sCOMPS ="S1"){
		reTurnV = "SDNPS_REMC";
	}else{
		reTurnV = "ERROR";
	}
	return reTurnV;
}
/*********************************************************************
*  해당 DataSet의 변경 여부가 있는지 체크                            *
*    1) Argument(Obj=체크하고자 하는 DataSet Object)                 *
*********************************************************************/
function fnc_DatasetChangeCheck(obj) {

	//DataSet에 변경이 일어났는지 여부를 반환
	if (obj='') {
		return false;
	} else {
		return obj.GetUpdate();
	}

}
/*********************************************************************
*  조회 및 저장 時 Progress Bar Close                                *
*********************************************************************/
function fnc_CloseProgress() {
	
	//작업(조회,저장)전에 Progress Bar Windows Status false(화면을 닫기 위함)
	GBL_PROGRESSCHK = false;
	
}

/*********************************************************************
*  Grid에서 Multy로 선택된 Row Count를 반환하는 Function             *
*    1)  DataSet                                                     *
*********************************************************************/
function fnc_SelectRowCount(oDataSet) {

	var iRowCount = 0;
	
	for (var i=0; i < oDataSet.RowCount(); i++) {

		if (oDataSet.GetSelect(i)) iRowCount++;
		
	}
	
	return iRowCount;
	
}

/*********************************************************************
*  공통 코드 콤보 설정                                               *
*    1)  Grid Component Object                                       *
*********************************************************************/
function fnc_GetComboDs(oDataSet) {

    //Combo List를 가지고 있는 DataSet의 이름 및 OBJECT 유무 체크
    if(!isValid(oDataSet) || oDataSet.ID!="dsCombo") {
        fnc_Message("M1011");
        return;
    }

    var sMethodName  = "GetCommCode";                       //Mehtod Name
	var sInDataSet   = oDataSet.ID + "=" + oDataSet.ID;     //In DataSet Name
	var sOutDataSet  = "";                                  //Out DataSet Name
	var sDataSetName = "";                                  //DataSet Name  저장 변수

	for(var i=0; i<oDataSet.GetRowCount(); i++) {

        sDataSetName = oDataSet.GetColumn(i, "DSNAME");
        sOutDataSet += sDataSetName + "=" + sDataSetName + " ";

	}

	sArgument  = " pgm=" + quote("erp.c.common.ab.CommCodeAction");
	sArgument += " action=" + quote(sMethodName);
    Transaction(sMethodName, GBL_HTTPURL, sInDataSet, sOutDataSet, sArgument, "fn_CallBack");

	//작업(조회,저장)전에 Progress Bar Windows Status True
	GBL_PROGRESSCHK = true;
	 //조회 전에 Progress Bar Windows Open
	Dialog("popup::comprogressbar.xml", "", 272, 40, "titlebar=false",-1, -1);
	
}


// 권한 확인
function getMenuAuth(sMenuId){
	returnMeg = "";
	for(i=0;i<G_ds_menu.rowcount;i++){
		if(G_ds_menu.GetColumn(i,"MENU_ID") == sMenuId){
			if(G_ds_menu.GetColumn(i,"GROUP_AUTH") == "R"){
				returnMeg = "권한이 없습니다.                          \n\n관리자에게 문의하세요" ;
				alert(returnMeg);
				return false ;
			} else {
				return true ;
			}
		}
	}	
}


// 데이터셋 하니씩 저장하게 
function checkInsertCount(obj)
{
	ds_obj = Object(obj);
	var insertCnt = 0;
	
	for(i=0;i<ds_obj.rowcount;i++){
		if(ds_obj.GetRowType(i) == 'insert'){
			insertCnt++;
		}
	}
	
	if(insertCnt >= 1){
	
		alert(setPopMessage("1005"));
		setMessage("1005");	
		return false ;
	} 
	return true;
}

// 예약건이 있는 상품,요금,위치 확인
function checkReservCnt(media_item,line_no,class,station_no,floor_no,location_no) 
{
	http.Sync = true;
	var arg = "";
	
	arg += " media_item=" + quote(media_item);
	arg += " line_no=" + quote(line_no);
	arg += " class=" + quote(class);
	arg += " station_no=" + quote(station_no);
	arg += " floor_no=" + quote(floor_no);
	arg += " location_no=" + quote(location_no);

	Transaction("SEARCH11", "service::media/selectReservCnt.do", "", "ds_reservCnt=ds_reservCnt", arg, "");	

	if(Parseint(ds_reservCnt.GetColumn(0,"RESERV_CNT")) != 0) {
		alert("예약건이 있습니다.                 \n삭제할 수 없습니다.");
		return false;
	} 	
	
	return true;
}

// 개월수 구하기
function getReservMonth(from, to){
	if(from=="" || to=="" || from > to){
		edit_month.Value="0";
		return;
	}
	var fromDate = DateTime(from);
	var toDate = DateTime(to);
	var tempDate = fromDate;
	var beforeTempDate;
	
	var months = 0;
	var i=0;
	while(tempDate < toDate){
		i++;
		beforeTempDate = tempDate;
		tempDate = fromDate.AddMonth(i).AddDate(-1);		
		months++;
	}		
	var leftDates = 0;
	if(toDate != tempDate){
		months--;
		leftDates = ParseDateTime(toDate) - ParseDateTime(beforeTempDate); 
	}
	var dates = ParseDateTime(toDate) - ParseDateTime(fromDate);
	//alert("개월:"+months+"      총일수:"+dates+"     남은일수:"+leftDates);	
	months += round(leftDates/31,1);
	return months;
}

//excel 다중 시트 출력
function createExcelSheetS(fName,arrSheets)
{

 var ExportObject1;
  
 ExportObject1 = CreateExportObject();
 ExportObject1.ExportType  = "Excel";
 ExportObject1.ExportFileName = "c:\\" + fName + ".xls";
 ExportObject1.MakeEmptyFileWhenNotExist = true; 
   
 for(i=0;i<length(arrSheets);i++)
 {
  var sheets = split(arrSheets[i],"|");
  ExportObject1.AddExportGrid(sheets[1] + "!" + "A1", object(sheets[0]), true, false);
 }   

 ExportObject1.Export();
 ExportObject1.Close();
 ExportObject1 = null; 
 
}


//excel 다중 시트 출력 (경로지정)
function createExcelSheetS2(fdObj,fName,arrSheets)
{

	//파일 선택
	fdObj.Type = "DIR";
	if (!fdObj.Open()) {
		return;
	}	

	var ExportObject1;
	
	ExportObject1 = CreateExportObject();
	ExportObject1.ExportType  = "Excel";
	
	//2014.12.30 제환복추가
	//엑셀다운시 C루트만 저장되는 오류 해결
	var getLen=length(fdObj.FilePath);
	if(substr(fdObj.FilePath,getLen-1,1)!="\\"){
		fName= "\\"+fName;
	}
	ExportObject1.ExportFileName = fdObj.FilePath + fName + ".xls";
	ExportObject1.MakeEmptyFileWhenNotExist = true; 

	for(i=0;i<length(arrSheets);i++)
	{
		var sheets = split(arrSheets[i],"|");
		ExportObject1.AddExportGrid(sheets[1] + "!" + "A1", object(sheets[0]), true, false);
	}   
	
	ExportObject1.Export();
	ExportObject1.Close();
	ExportObject1 = null; 
 
}
//OGM401 월별계획대실적 엑셀출력 - 제환복추가
function createExcelSheetS3(fdObj,fName, arrSheets, dName)
{
	//파일 선택
	fdObj.Type = "DIR";
	if (!fdObj.Open()) {
		return;
	}


/*
	//var tnm = toString(dName);	
	//var headCnt;
	//var strContents = "";
	for(i=0; i<arrSheets.length; i++){
		headCnt = arrSheets[i].GetColCount();
alert(headCnt);
		create("grid","grdExcel_"+i);		
		
		strContents = "";
		strContents += '<contents>                                                        ';  
		strContents += '<format id="Default"> 											  '; 	                                                 
		strContents += '	<head>                                                        '; 
		//strContents += '		<cell col="0" font="굴림,14" colspan=41'+headCnt+' display="text" text=' + tnm +'/> ';
		strContents += '		<cell col="1" font="굴림,14" colspan="41" display="text" text=' + tnm +'/> ';
		strContents += '	</head>                                                       ';
		strContents += '</format>                                                         ';  
		strContents += '</contents>	                                                      '; 
		
		object("grdExcel_"+i).contents = strContents;
	}
*/	
	//-----------------------------------------------------------

	var ExportObject1;
	
	ExportObject1 = CreateExportObject();
	ExportObject1.ExportType  = "Excel";
	ExportObject1.ExportFileName = fdObj.FilePath + fName + ".xls";
	//ExportObject1.ExportSinglePivotColHead = true; //추가
	ExportObject1.MakeEmptyFileWhenNotExist = true; 
		
	for(i=0;i<length(arrSheets);i++)
	{
		var sheets = split(arrSheets[i],"|");
		ExportObject1.AddExportDataset(sheets[1] + "!" + "A1", dName, false);
		//ExportObject1.AddExportGrid(sheets[1] + "!" + "A1", object("grdExcel_"+i), true, true);
		ExportObject1.AddExportGrid(sheets[1] + "!" + "A2", object(sheets[0]), true, false);
	}   
	
	ExportObject1.Export();
	ExportObject1.Close();
	ExportObject1 = null; 
 
}



function getTitle() // 20110331_김성곤_수정
{
	var mCode;
	var up_Menu;
	var lev;
	var menu_Name;
	
	for(i=0;i<G_ds_menu.rowcount;i++)
	{
		if(G_ds_menu.GetColumn(i,"MENU_ID") == sMenuId)
		{
			mCode = G_ds_menu.GetColumn(i,"MCODE");
			up_Menu = G_ds_menu.GetColumn(i,"UP_MENU");
			lev = G_ds_menu.GetColumn(i,"LEV");
			menu_Name = G_ds_menu.GetColumn(i,"MENU_NAME");
		}
	}
	
	var tText;
	
	if(lev == 1) // 2단계 메뉴일 경우
	{
		for(i=0;i<G_ds_menu.rowcount;i++) // 대분류
		{
			if(G_ds_menu.GetColumn(i,"MENU_ID") == mCode)
			{
				tText += G_ds_menu.GetColumn(i,"MENU_NAME") + " > ";
			}
		}
		
		tText += menu_Name;	// 메뉴		
	}
	else if(lev == 2) // 3단계 메뉴일 경우
	{
		for(i=0;i<G_ds_menu.rowcount;i++) // 대분류
		{
			if(G_ds_menu.GetColumn(i,"MENU_ID") == mCode)
			{
				tText += G_ds_menu.GetColumn(i,"MENU_NAME") + " > ";
			}
		}	
			
		for(i=0;i<G_ds_menu.rowcount;i++) // 중분류
		{
			if(G_ds_menu.GetColumn(i,"MCODE") == mCode)
			{
				if(G_ds_menu.GetColumn(i,"MENU_ID") == up_Menu)
				{
					if(G_ds_menu.GetColumn(i,"INIT_URL") == "")
					{
						tText += G_ds_menu.GetColumn(i,"MENU_NAME") + " > ";
					} else {
						if(sMenuId == G_ds_menu.GetColumn(i,"MENU_ID"))
						{
							tText += G_ds_menu.GetColumn(i,"MENU_NAME");
							break;
						}
					}	
				}
			}
		}	
		
		tText += menu_Name;	// 메뉴				
	}
	
	title_text.text = "위치 :: " + tText; // 전체메뉴 경로 취합
}


// 암호화
function userIdEncode(userId)
{
	var varArray = Array();
	for(i=0; i<Length(userId); i++)
	{
		varArray[i] = SubStr(userId,i,1);
	}

	var returnArray = Array();
	for(i=0; i<=Length(userId); i++)
	{
		returnArray[i] = varArray[Length(varArray)-i];
	}

	var returnValue = "";
	for(i=0; i<Length(returnArray); i++)
	{
		returnValue += returnArray[i];
	}

	return returnValue ;
}




// 암호화 풀기
function userIdDecode(userId)
{
	var varArray = Array();
	for(i=0; i<Length(userId); i++)
	{
		varArray[i] = SubStr(userId,i,1);
	}

	var returnArray = Array();
	for(i=0; i<=Length(userId); i++)
	{
		returnArray[i] = varArray[Length(varArray)-i];
	}

	var returnValue = "";
	for(i=0; i<Length(returnArray); i++)
	{
		returnValue += returnArray[i];
	}

	return returnValue ;
}

// 날짜 형식 체크
function isDate(tDate)
{
	var YYYY 	= ParseInt(substr(tDate,0,4));
	var MM 		= substr(tDate,4,2);
	var DD 		= substr(tDate,6,2);
	
	if(MM < "01"){
		return false ;
	} 
	
	if(MM > "12"){
		return false ;
	} 	
	
	if(DD < "01"){
		return false ;
	} 		
	
	if(DD > "31"){
		return false ;
	} 	

	if( MM == '04' || MM == '06' || MM == '09' || MM == '11'){
		if(DD > "30"){
			return false;
		}
	}
	
	if( MM == '02'){
		if(DD > "29"){
			return false;
		}
	}	
	
	if(YYYY%4 != 0){
		if( MM == '02'){
			if(DD > "28"){
				return false;
			}
		}	
	}

	return true;
}

function bottomSet(){
	var arr = split(GetTopWindow().id,"::");
	global.FrameBottom.Static2.Text = arr[0];		
	
	var arr2 = split(arr[1],".");
	global.FrameBottom.Static3.Text = arr2[0];	
}

function setMessageDirect(msgTxt){
	global.FrameBottom.messageBox = msgTxt;
}

function setMessage(msgCode){
	global.FrameBottom.messageBox = G_ds_message.GetColumn(G_ds_message.FindRow("MSG_SEQ",msgCode),"MSG_TEXT");
}

function setPopMessage(msgCode){

	if(G_ds_message.FindRow("MSG_SEQ",msgCode) < 0){
		//return "[" + msgCode +"]메시지 코드 존재하지 않습니다. \n관리자에게 문의하세요";
		return ;
	}


	return G_ds_message.GetColumn(G_ds_message.FindRow("MSG_SEQ",msgCode),"MSG_TEXT")/* + "\n[" + G_ds_message.GetColumn(G_ds_message.FindRow("MSG_SEQ",msgCode),"MSG_SEQ") + "]"*/;
}

/*********************************************************************
*  년도 dataset 생성                                              *
*                                                                    *
*********************************************************************/
function SetYYYY13(str, ds) {
	var yyyy = toNumber(str)-5;
	for (var a=0;a<13;a++){
		ds.InsertRow(a);
		ds.SetColumn(a,"YYYY",yyyy);
		yyyy++;
	}
	
}
/*********************************************************************
*  금액 한자변환                                                    *
*  lsk                                                              *
*********************************************************************/
function convertHanjaAmt(amt){
//var rtn_arr = Array(3);
	var arrMM = Split("04,05,06,07,08,09,10,11,12,01,02,03",",");
	var arrayAmt = Split("壹,貳,參,四,五,六,七,八,九,拾",",");
	var arrayPosi = Split(" ,拾,百,阡",",");
	var arrayUnit = Split(" ,萬,億,兆",",");

	var posi = amt.length%4; //자리수
	var len = toString(amt.length/4);
	var unit;
	if(len.indexOf(".")>0){
		unit = toNumber(len.substr(0, len.indexOf("."))); //단위(0:일단위, 1:만단위...)
	}else{
		unit = amt.length/4-1;
	}

	var korAmt = "";
	op=0;
	for(i=0; i<amt.length; i++){
		if(posi==0){
			posi=4;
		}
		num = parseInt(amt.substr(i, 1));
		if(num!=0){
			korAmt += arrayAmt[num-1];
			korAmt += arrayPosi[posi-1];
			korAmt = trim(korAmt);
			op=1;
		}
		if(posi==1){
			if(op==1){
				korAmt += arrayUnit[unit];
				korAmt = trim(korAmt);
			}
			unit--;
			op=0;
		}
		posi--;
	}

	if (korAmt.length==0 || korAmt.length==null || amt.length>13){
		return "";
	} else {
		return korAmt+"원整";
	}
}
/*********************************************************************
*  윤년이면 1값을 평년이면 0값을 리턴한다                           *
* 4로 나누어 떨어지면 윤년, 그중 100으로 나누어떨어지는 것은 윤년이 아니며,그중 400으로 나누어 떨어지는것은 윤년이다. *
*  lsk                                                              *
*********************************************************************/
function isleapyear(year){
	var value;
	if(yoon%4==0 && yoon%100 !=0 || yoon%400 ==0){
		value = 1;
	}else{
		value = 0;
	}
	return value;
}
/*###############################################
########## Max5250  goUrl Script ################
#################################################*/


function fnc_goUrl(scrName)
{
	var row  =  ds_menu.FindRow("SCREEN_ID",scrName);
	Div5250.url = null;
	
		if(row == -1) {
			Max5250.visible = true;
			Max5250.top = 0;
			Max5250.left = 0;
			Max5250.height = 480;
			Max5250.width = 800;
			Div5250.visible =  false;
			Div5250.url = "";
			max5250.SetFocus();
		}else{
			var url =  ds_menu.getColumn(row,"URL");
			Max5250.visible = false;
			Max5250.top = 0;
			Max5250.left = 0;
			Max5250.height =480;
			Max5250.width = 800;
			Div5250.left = 0;
			Div5250.visible =  true;
			Div5250.url = url;
			Div5250.SetFocus();
		}

}

function fnc_popUrl(scrName)
{
	
	var row  =  ds_menu.FindRow("SCREEN_ID",scrName);
	var popUrl =  ds_menu.getColumn(row,"URL");
	if(pcnt  ==  0){
		pcnt = 1;
		var rstr = Dialog(popUrl,"");
		if(rstr != 1 && row >= 0) {
			MAX5250.SendKeys("[PF03]");
			pcnt = 0;
			page = 0;
		//	max5250.ResetPopupRange();
		}else{
			pcnt = 0;
			page = 0;
			
		}
	}else{
	
	
		
	}
}

function fnc_DataXmlConvert(xmlData,obj,clen,gbn)
{
	//trace("gbn:"+gbn);
	xmlData = replace(xmlData,"<data>" ,"<dataset id=\""+obj+"\">");
	xmlData = replace(xmlData,"</data>" ,"</data>");
	xmlData = replace(xmlData,"<column id" ,"<colinfo id");
	//컬럼생성
	ds_head.clear();
	if(gbn == 1)
		ds_column.clear();
	else
		ds_column_p.clear();
		
	for(var i=1; i<=parseInt(clen); i++){
		var ii  = parseInt(i);
		if(ii < 10)  ii = "0"+ii;
		ds_head.AddColumn("COLUMN_"+ii,"255","STRING");
		if(gbn == 1)
			ds_column.AddColumn("COLUMN_"+ii,"255","STRING");
		else
			ds_column_p.AddColumn("COLUMN_"+ii,"255","STRING");
	}

	object(obj).LoadXML(xmlData);	
	for(var i=0; i< object(obj).rowcount; i++){
		if(i =0){  //head

			var row = ds_head.AddRow();
			ds_head.copyRow(row,"ds_subfile", i);

		}else{  	//row
		
			
			if(gbn == 1){
				var row = ds_column.AddRow();
				ds_column.copyRow(row,"ds_subfile", i);
			}else{
				var row = ds_column_p.AddRow();
				ds_column_p.copyRow(row,"ds_subfile", i);
				
			}
		}
		ds_column.ROW = 0;
	}
		//trace(ds_column.saveXMl());
	
//	return xmlData;
}

//screen change
function changeScreen(flag)
{
	if(flag == 0) {
		Max5250.visible = true;
		Max5250.top = 0;
		Max5250.left = 0;
		Max5250.height = 480;
		Max5250.width = 800;
		Div5250.visible =  false;
		max5250.SetFocus();
	}else{
		Max5250.visible = true;
		Max5250.top = 0;
		Max5250.left = 0;
		Max5250.height =480;
		Max5250.width = 800;
		Div5250.left = 0;
		Div5250.left = 0;
		Div5250.visible =  true;
		Div5250.SetFocus();
	}
}

function fn_SetScreenSize(cx, cy)
{
		Max5250.top = 0;
		Max5250.left = 0;
		Max5250.height = cy;
		Max5250.width =  cx;	
}

//로딩바
function fn_DivProcess(arg) {
	var st_result;
	if (arg=="C") {
		st_result.Value ="";
		Create("Div","Div_Process",'left="300" top="200" width="256" height="45" visible="false" Bkcolor="#FFFFFF"');	
	} else if (arg == "T") {
		//SetCapture();
		SetWaitCursor(true);		
		Div_Process.Url = "Max5250::Process.xml";
		Div_Process.visible = true;
		
	} else {
		Div_Process.visible = false;
		Div_Process.Url = "";
		SetWaitCursor(false);		
	}
}
//More borrom chk
function chkPage(pg){
	var str = replace(trim(max5250.GetString(22,67,13)),".","");
	//trace(str);
	if(str == "More"){
		btn_pgdn.Visible = true;
		if(pg > 1) btn_pgup.Visible = true;
	}else if(str == "Bottom"){
		btn_pgdn.Visible = false;
		btn_pgup.Visible = true;
		btn_pgup.left = parseInt(btn_pgup.left) + 26;
	}
}


//More borrom chk
function chkPagePop(pg,row,col){
	var str = replace(trim(max5250.GetString(row,col,13)),".","");
	if(str == "More"){
		btn_pgdn.Visible = true;
		btn_pgup.Visible = true;
	
	}
}


function codePopupClick(nRow){
	Max5250.SendToColumn("COLUMN_01"," ",(nRow+1));
	close(1);
}

//system autologin check
function getAutoLogin(str)
{
	var flag = false;
	http.Sync = true;
	var sKind  = "getOutSystemLoginYn";      
	var sMethodName = "service::user/selectOutSystemLoginYn.do";
	var sInDataSet  = "";
	var sOutDataSet = "ds_loginYn=ds_loginYn";
 
 
	var sArgument   = "";
	sArgument   += " SYSTEM_SEQ=" + quote(str);
	sArgument   += " COMPANY=" + quote(G_ds_user.GetColumn(0,"COMPANY"));
	sArgument   += " INOUT_GUBN=" + quote("I");
 
	Transaction(sKind, sMethodName, sInDataSet, sOutDataSet, sArgument, ""); 
	http.Sync = false;
	//trace(ds_loginYn.getColumn(0,"LOGIN_YN") +" : : "+ds_loginYn.rowcount);
	//자동로그인 유무 비교
	if(ds_loginYn.getColumn(0,"LOGIN_YN") == "Y") flag = true;
	
	return flag; 
	
}

//background color setting
function setBkColor(id)
{
	var color;
	var row = ds_attr_value.FindRow("id",id);
	if(row == -1) color = "default";
	else color = ds_attr_value.getColumn(row,"bkcolor");
	return color;
}

//color setting
function setColor(id)
{
	var color;
	var row = ds_attr_value.FindRow("id",id);
	if(row == -1) color = "default";
	else color = ds_attr_value.getColumn(row,"color");
	return color;
}


/*===============================================================
	그리드 SORT 관련
===============================================================*/


var CONST_ASC_MARK="▲";
var CONST_DESC_MARK="▼";
var lib_gridv_CreateChkDS = false;		// Multi Sort(Column 정의 Dataset)
var lib_gridv_mCnt;
var lib_gridv_gCnt;

/*===============================================================
= 기능 : Grid Header Click => Sorting 처리
= 인수 : Gridobj		Grid Object
         nCell			Column Index(Click Head index)
===============================================================*/
function lib_grid_SetGridSort(Gridobj,nCell)
{
	var objBDs = Gridobj.BindDataset;
	
	
	lib_gridv_mCnt = Gridobj.GetCellProp("head",0,"colspan");
 	lib_gridv_gCnt = 0;
 	
 	if (Gridobj.GetSubCellCount("head",0) > 0) lib_gridv_gCnt = Gridobj.GetSubCellCount("head",0) - 1;
	
	
	if (getKeyState("shift")){
		
		if (lib_gridv_CreateChkDS == false){
			
			Create("Dataset","ds_grdsort", "");
			ds_grdsort.AddColumn("Col", "String",255); 
			ds_grdsort.AddColumn("Sort","String",255);
			
			lib_gridv_CreateChkDS = true;
		}
		
		if (ds_grdsort.RowCount() < 1) lib_grid_SetHeadClearAll(Gridobj);
		
		lib_grid_SetGridShiftSort(Gridobj, objBDs, nCell);
		
	} else {	
		if (lib_gridv_CreateChkDS) ds_grdsort.DeleteAll();
		lib_grid_GridSort(Gridobj,objBDs,nCell);
	}	
}

/*===============================================================
= 기능 : Grid Header Click => Sorting 처리
= 인수 : Gridobj		Grid Object
         dsObj      Grid BindDataset
         nCell			Column Index(Click Head index)
= 예제 : lib_grid_GridSort(Gridobj,Dataset,nCell);
===============================================================*/
function lib_grid_GridSort(Gridobj,dsObj,nCell){
	var nheadText,sflag;
	
	var sort_cell;
	var sort_col;
	var sort_span;
 	var sort_columns="";
 	
  //---------------------------------------------------------
	//  해당하는 셀의 타이틀의 소트마크를 추가 또는 변경한다.
	//---------------------------------------------------------
	if(right(Gridobj.GetCellProp("head",nCell,"text"),1) == CONST_ASC_MARK) {
	
		if (Gridobj.GetCellProp("head",nCell,"colspan") > 1){
			sort_col = Gridobj.GetCellProp("head",nCell,"col");
			sort_col -= lib_gridv_gCnt;
			sort_span = Gridobj.GetCellProp("head",nCell,"colspan");			
			//trace("1111   " + sort_col + " : " + sort_span);
			for (i=sort_col; i<toNumber(sort_col)+toNumber(sort_span); i++){
				sort_columns += Gridobj.GetCellProp("Body",i,"colid") + ",";
			}
		} else {
			sort_col = Gridobj.GetCellProp("head",nCell,"col");
			sort_col -= lib_gridv_gCnt;
			sort_columns = Gridobj.GetCellProp("Body",sort_col,"colid");
		}
		
		nheadText = Gridobj.GetCellProp("head",nCell,"text");
		nheadText = replace(nheadText,CONST_ASC_MARK,"");
		nheadText = nheadText + CONST_DESC_MARK;

//		alert(sort_columns);
		object(dsObj).sort(sort_columns,false);
		
	} else if(right(Gridobj.GetCellProp("head",nCell,"text"),1) == CONST_DESC_MARK) {	
		var body_cnt = Gridobj.GetCellCount("Body");
		var sort_idx = 0;
		for (i=0; i<body_cnt; i++){
			if (Length(Gridobj.GetCellProp("Body",i,"colid")) > 1){		
				sort_columns += Gridobj.GetCellProp("Body",i,"colid") + ",";
				sort_idx++;
			}
			if (sort_idx == 5) break;
		}
		
		nheadText = Gridobj.GetCellProp("head",nCell,"text");
		nheadText = replace(nheadText,CONST_DESC_MARK,"");
		
		object(dsObj).sort(sort_columns,true);
		
	} else {
	
		if (nCell == 0 && lib_gridv_gCnt > 0) return;
		
		if (Gridobj.GetCellProp("head",nCell,"colspan") > 1){
			sort_col = Gridobj.GetCellProp("head",nCell,"col");
			sort_col -= lib_gridv_gCnt;
			sort_span = Gridobj.GetCellProp("head",nCell,"colspan");
			for (i=sort_col; i<toNumber(sort_col)+toNumber(sort_span); i++){
				sort_columns += Gridobj.GetCellProp("Body",i,"colid") + ",";
			}
			
		} else {
			sort_col = Gridobj.GetCellProp("head",nCell,"col");
			
			sort_col -= lib_gridv_gCnt;
			sort_columns = Gridobj.GetCellProp("Body",sort_col,"colid");
		}
		
		nheadText = Gridobj.GetCellProp("head",nCell,"text");
		nheadText = nheadText + CONST_ASC_MARK;
		
		object(dsObj).sort(sort_columns,true);
	}
	 
	Gridobj.SetCellProp("head",nCell,"text",nheadText);	
	
	//---------------------------------------------------------
	//  해당하는 셀 이외의 해더 타이틀의 소트마크를 제거한다.
	//---------------------------------------------------------
	
	var nColCnt = Gridobj.GetCellCount("head");
	var sRepText;
	
	for(i=lib_gridv_gCnt;i<nColCnt;i++){
		
		if(nCell <> i) {
			sRepText = replace(Gridobj.GetCellProp("head",i,"text"), CONST_ASC_MARK,"");
			Gridobj.SetCellProp("head",i,"text", sRepText);
			
			sRepText = replace(Gridobj.GetCellProp("head",i,"text"), CONST_DESC_MARK,"");
			Gridobj.SetCellProp("head",i,"text", sRepText);
		}
	}
}

/*===============================================================
= 기능 : Shift Key + Grid Header Click => Sorting 처리
= 인수 : Gridobj		Grid Object
         dsObj      Grid BindDataset
         nCell			Column Index(Click Head index)
= 예제 : lib_grid_SetGridShiftSort(obj, Dataset ,nCell);
===============================================================*/
function lib_grid_SetGridShiftSort(Gridobj, dsObj, nCell){
	var nheadText,sflag;
	
	var sort_cell;
	var sort_col;
	var sort_span;
 	var sort_columns="";
 	var depth_row;
 	var endCell;
 	
	if(right(Gridobj.GetCellProp("head",nCell,"text"),1) == CONST_ASC_MARK)	{
	
		if (Gridobj.GetCellProp("head",nCell,"colspan") > 1){
			sort_col = Gridobj.GetCellProp("head",nCell,"col");
			sort_col -= lib_gridv_gCnt;
			sort_span = Gridobj.GetCellProp("head",nCell,"colspan");
			depth_row = Gridobj.GetCellProp("head",nCell,"row");
			
			for (i=sort_col; i<toNumber(sort_col)+toNumber(sort_span); i++){
				sort_columns += Gridobj.GetCellProp("Body",i,"colid") + ",";
			}
			endCell = toNumber(sort_col)+toNumber(sort_span);
			lib_grid_SetSubHeadClear(Gridobj, sort_col, endCell, depth_row);
			
		} else {
			sort_col = Gridobj.GetCellProp("head",nCell,"col");
			sort_col -= lib_gridv_gCnt;
			sort_columns = Gridobj.GetCellProp("Body",sort_col,"colid");
		}
		
		nheadText = Gridobj.GetCellProp("head",nCell,"text");
		nheadText = replace(nheadText,CONST_ASC_MARK,"");
		nheadText = nheadText + CONST_DESC_MARK;
		sflag = CONST_DESC_MARK;
		
	}	else if (right(Gridobj.GetCellProp("head",nCell,"text"),1) == CONST_DESC_MARK) {
	
		if (Gridobj.GetCellProp("head",nCell,"colspan") > 1){
			sort_col = Gridobj.GetCellProp("head",nCell,"col");
			sort_col -= lib_gridv_gCnt;
			sort_span = Gridobj.GetCellProp("head",nCell,"colspan");
			depth_row = Gridobj.GetCellProp("head",nCell,"row");
			
			for (i=sort_col; i<toNumber(sort_col)+toNumber(sort_span); i++){
				sort_columns += Gridobj.GetCellProp("Body",i,"colid") + ",";
			}
			
			endCell = toNumber(sort_col)+toNumber(sort_span);
			lib_grid_SetSubHeadClear(Gridobj, sort_col, endCell, depth_row);
			
		} else {
			sort_col = Gridobj.GetCellProp("head",nCell,"col");
			sort_col -= lib_gridv_gCnt;
			sort_columns = Gridobj.GetCellProp("Body",sort_col,"colid");
		}
		
		nheadText = Gridobj.GetCellProp("head",nCell,"text");
		nheadText = replace(nheadText,CONST_DESC_MARK,"");		
		sflag = "";
		
	} else {
	
		if (nCell == 0 && lib_gridv_gCnt > 0) return;
		
		if (Gridobj.GetCellProp("head",nCell,"colspan") > 1){
			sort_col = Gridobj.GetCellProp("head",nCell,"col");
			sort_col -= lib_gridv_gCnt;
			sort_span = Gridobj.GetCellProp("head",nCell,"colspan");
			depth_row = Gridobj.GetCellProp("head",nCell,"row");
			
			for (i=sort_col; i<toNumber(sort_col)+toNumber(sort_span); i++){
				sort_columns += Gridobj.GetCellProp("Body",i,"colid") + ",";
			}
			endCell = toNumber(sort_col)+toNumber(sort_span);
			lib_grid_SetSubHeadClear(Gridobj, sort_col, endCell, depth_row);
			
		} else {
			sort_col = Gridobj.GetCellProp("head",nCell,"col");
			sort_col -= lib_gridv_gCnt;
			sort_columns = Gridobj.GetCellProp("Body",sort_col,"colid");
		}
		
		nheadText = Gridobj.GetCellProp("head",nCell,"text");
		nheadText = nheadText + CONST_ASC_MARK;
		sflag = CONST_ASC_MARK;
	}
	
	var arr_cols = split(sort_columns,",");
	
	for (i=0; i<length(arr_cols); i++){
	
		var str_exist = ds_grdsort.FindRow("Col", arr_cols[i]);
		
		if (str_exist < 0) {
			ds_grdsort.AddRow();
			
			ds_grdsort.SetColumn(ds_grdsort.currow,"Col", arr_cols[i]);			
			ds_grdsort.SetColumn(ds_grdsort.currow,"Sort", "A");
			
			if (sflag == "") ds_grdsort.DeleteRow(str_exist);
			
		} else {
		
			ds_grdsort.DeleteRow(str_exist);
			
			if (sflag != "") {
				ds_grdsort.AddRow();
				ds_grdsort.SetColumn(ds_grdsort.currow,"Col", arr_cols[i]);
				if (sflag == CONST_DESC_MARK) ds_grdsort.SetColumn(ds_grdsort.currow,"Sort", "D");
				else ds_grdsort.SetColumn(ds_grdsort.currow,"Sort", "A");
			} 
		}
	}
	
	var str_sort = "";
	for (i=0; i<ds_grdsort.RowCount(); i++){
		str_sort += ds_grdsort.GetColumn(i,"Col") + ":" + ds_grdsort.GetColumn(i,"Sort") + ",";
	}
	
	if (ds_grdsort.RowCount() < 1){
		var body_cnt = Gridobj.GetCellCount("Body");
		var sort_idx = 0;
		for (i=0; i<body_cnt; i++){
			if (Length(Gridobj.GetCellProp("Body",i,"colid")) > 1){		
				str_sort += Gridobj.GetCellProp("Body",i,"colid") + ",";
				sort_idx++;
			}
			if (sort_idx == 2) break;
		}
	}
	
	object(dsObj).sort(str_sort,true);
	
	Gridobj.SetCellProp("head",nCell,"text",nheadText);
}

/*===============================================================
= 기능 : Grid Selected Head Clear All (공통)
= 인수 : obj				Grid Component ID
= 예제 : lib_grid_SetColumnAdd(obj)
===============================================================*/
function lib_grid_SetHeadClearAll(obj){	
	var nColCnt = obj.GetCellCount("head");
	var sRepText;
	
	for(i=lib_gridv_gCnt;i<nColCnt;i++){		
		sRepText = replace(obj.GetCellProp("head",i,"text"), CONST_ASC_MARK,"");
		obj.SetCellProp("head",i,"text", sRepText);
		
		sRepText = replace(obj.GetCellProp("head",i,"text"), CONST_DESC_MARK,"");
		obj.SetCellProp("head",i,"text", sRepText);		
	}
}

/*===============================================================
= 날짜 : 2012.04.09
= 사용자 : 제환복
= 목적  : MenuLevel Checking
===============================================================*/

function getTmenuLev(){
	var sKind		= "getTmenuLev";						
	var sMethodName = "service::user/selectTmenuLev.do";  					
	var sInDataSet  = "";
	var sOutDataSet = "ds_tmenuLev=ds_tmenuLev";
	var sArgument   = "";
	http.Sync=true;
	Transaction(sKind, sMethodName, sInDataSet, sOutDataSet, sArgument, "");
	http.Sync=false;
	
	var topVal="('";	//treemenu에 해당하는 menu값
	var topLevel="";	//level값
	var chklev="";	//indexOf의 return 값
	var chkval="m"; //체크 문자열
	var chkcnt=0;
	for (i=0; i<ds_tmenuLev.GetRowCount(); i++){
		topLevel = ds_tmenuLev.GetColumn(i,"TOP_MENU");
		chklev=indexOf(topLevel,chkval);
		if(chklev!=-1){
			if(chkcnt!=0){
				topVal+="', '";
			}
			topVal+=topLevel;
			chkcnt=1;
		}
	}
	if(length(topVal)==2){
		topVal+="1')"; //topmenu level 1은 무조건 포함됨.
	}
	else {
		topVal+="', '1')";
	}
	
	return topVal;
}


/*===============================================================
= 날짜 : 2012.04.09
= 사용자 : lee sk
= 목적  : 숫자Checking
===============================================================*/
function numberChk(str){
	var c = "";
	if(str == "") return false;
	for(var i = 0 ; i < str.length() ; i++){
		c = Asc(str.charAt(i));
		if(c < 48 || c > 57){  //48=0 ,49=1, ,,,, 57=9
			if(c != 46){       //46=.
				return false;
			}
		}
	}
	return true;
}

function chkbytelen_db2(snewVal, slenLimit)
{
//	http.usewaitcursor = false;
	var chkbyte = 0;
	var msgVal = snewVal;
	var tmpVal = "0";
	var tmpch = "";
	var ch = "";
	for(var i = 0 ; i < msgVal.length; i++){
			temval = ch;
			ch =Asc(msgVal.CharAt(i));

		if(i == (msgVal.length)-1){
			if( length(urlEncode(ch)) > 4){
				if(length(urlEncode(temval)) > 4){
					chkbyte +=3;
				}
				else {
					chkbyte +=4;
				}
			}
			else{
				if(length(urlEncode(temval)) > 4){
					chkbyte +=2;
				}
				else {
					chkbyte++;
				}
			}
		
		}
		else{
			if( length(urlEncode(ch)) > 4){
				if(length(urlEncode(temval)) > 4){
					chkbyte +=2;
				}
				else {
					chkbyte +=3;
				}
			}
			else{
				if(length(urlEncode(temval)) > 4){
					chkbyte +=2;
				}
				else {
					chkbyte++;
				}
			}
		}
		if(chkbyte > slenLimit){
			//ds_ogm080A.fireEvent = false;
			alert(setPopMessage("2561"));
			var dcVal=substr(msgVal,0,i);
			//ds_ogm080A.fireEvent = true;
			return dcVal;
		}
	}
//	http.usewaitcursor = true;
}

//MRP MANAGEMENT CODE
function getMngFlag(){

	http.Sync = true;
	var sKind		= "getMngFlag";						
	var sMethodName = "service::user/selectMngFlag.do";     // 서버에서 호출 될 Method 명
	var sInDataSet  = "";                             		// 자료 저장 시 보낼 DataSet 명칭
	var sOutDataSet = "ds_mngflag=ds_mngflag";    			// 조회 후 돌려 받을 DataSet 명칭
	var sArgument   = "";
		sArgument += " COMPS=" + quote(G_ds_user.GetColumn(0,"PLANT_CD"));
		sArgument += " CLASS=" + quote(G_ds_user.GetColumn(0,"COMPANY"));	
		sArgument += " COMPS_ORG=" + quote(G_ds_user.GetColumn(0,"COMPANY"));	
	Transaction(sKind, sMethodName, sInDataSet, sOutDataSet, sArgument, "");
	http.Sync = false;
}