﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿/*********************************************************************
*  예비품관리 class구분                             *
*    1) 예비품,비품,식자재 구분                     *
*********************************************************************/
function SetClass(obj, ds) {
	ds.InsertRow(0);
	ds.SetColumn(0,"CODE1","1");
	ds.SetColumn(0,"CODE_NAME","예비품");
	
	//현재 예비품만 사용하므로 비품,식자재는 제외함.2012/03/28
	
	ds.InsertRow(1);
	ds.SetColumn(1,"CODE1","2");
	ds.SetColumn(1,"CODE_NAME","비품");
	ds.InsertRow(2);
	ds.SetColumn(2,"CODE1","3");
	ds.SetColumn(2,"CODE_NAME","식자재");
	obj.index = 0;
	obj.Enable = False;
}

﻿﻿﻿/*********************************************************************
*  예비품관리 단위구분                             *
*    1) ea,mt,st,lt 구분                     *
*********************************************************************/
function SetUnit(obj, ds) {
	ds.InsertRow(0);
	ds.SetColumn(0,"CODE1","EA");
	ds.SetColumn(0,"CODE_NAME","EA");
	ds.InsertRow(1);
	ds.SetColumn(1,"CODE1","MT");
	ds.SetColumn(1,"CODE_NAME","MT");
	ds.InsertRow(2);
	ds.SetColumn(2,"CODE1","ST");
	ds.SetColumn(2,"CODE_NAME","ST");
	ds.InsertRow(3);
	ds.SetColumn(3,"CODE1","LT");
	ds.SetColumn(3,"CODE_NAME","LT");
	//obj.Value = GetVariable("ClassGB","Local");
	//obj.Enable = false;
}

﻿﻿﻿/*********************************************************************
*  예비품관리 YES,NO구분                             *
*    1) Y,N구분                     *
*********************************************************************/
function SetYesNo(obj, ds) {
	ds.InsertRow(0);
	ds.SetColumn(0,"CODE1","Y");
	ds.SetColumn(0,"CODE_NAME","YES");
	ds.InsertRow(1);
	ds.SetColumn(1,"CODE1","N");
	ds.SetColumn(1,"CODE_NAME","NO");
}

/*********************************************************************
*  예비품관리 마감확인                                               *
*    true,false return                                               *
*********************************************************************/
function closeYN(str,str1,str2,str3)
{
	var flag = false;
	http.Sync = true;
	var sKind  = "getcloseYN";      
	var sMethodName = "service::psogmlib/selectcloseYN.do";
	var sInDataSet  = "";
	var sOutDataSet = "ds_closeYN=ds_closeYN";
	var sArgument   = "";
	sArgument   += " LIB2=" + quote(str);
	sArgument   += " COMPS=" + quote(str1);
	sArgument   += " GROUP=" + quote(str2);
	sArgument   += " CLOYM=" + quote(str3);
	Transaction(sKind, sMethodName, sInDataSet, sOutDataSet, sArgument, ""); 
	http.Sync = false;
	if(ds_closeYN.GetRowCount() == 0) flag = true;
	
	return flag; 
}	

/*********************************************************************
*  예비품관리 년도 생성                                              *
*                                                                    *
*********************************************************************/
function SetYYYY(str, ds) {
	var yyyy = toNumber(str)-5;
	for (var a=0;a<10;a++){
		ds.InsertRow(a);
		ds.SetColumn(a,"YYYY",yyyy);
		yyyy++;
	}
	
}

/*********************************************************************
*  예비품/설비보전/계측기 관리자 권한확인                            *
*    true,false return                                               *
*********************************************************************/
function managerYN(str,str1,str2,str3)
{
	var flag = "S";
	http.Sync = true;
	var sKind  = "getmanagerYN";      
	var sMethodName = "service::psogmlib/selectmanagerYN.do";
	var sInDataSet  = "";
	var sOutDataSet = "ds_managerYN=ds_managerYN";
	var sArgument   = "";
	sArgument   += " LIB2=" + quote(str);
	sArgument   += " COMPS=" + quote(str1);
	sArgument   += " GROUP=" + quote(str2);
	sArgument   += " DIOID=" + quote(str3);
	Transaction(sKind, sMethodName, sInDataSet, sOutDataSet, sArgument, ""); 
	http.Sync = false;
	if(ds_managerYN.GetRowCount() != 0) flag = "M";
	
	return flag; 
}

/*********************************************************************
*  QR WEB DEVID COMBO생성                                            *
*                                               *
*********************************************************************/
function SetDevID(sLib, sComp)
{
	if(sComp == "") {
		return false;
	}
	http.Sync = true;
	var sKind  = "getDevID";      
	var sMethodName = "service::psogmlib/selectDevID.do";
	var sInDataSet  = "";
	var sOutDataSet = "ds_DevID=ds_DevID";
	var sArgument   = "";
	sArgument   += " LIB2=" + quote(sLib);
	sArgument   += " COMPS=" + quote(sComp);
	Transaction(sKind, sMethodName, sInDataSet, sOutDataSet, sArgument, ""); 
	http.Sync = false;
	ds_DevID.InsertRow(0);
	ds_DevID.SetColumn(0,"DEVID","99");
	ds_DevID.SetColumn(0,"DEBNM","전체");
}
/*********************************************************************
*  QR WEB 공정 COMBO생성                                            *
*                                               *
*********************************************************************/
function SetProc(sLib, sComp){
	if(sComp == "") {
		return false;
	}
	http.Sync = true;
	var sKind  = "getProc";      
	var sMethodName = "service::psogmlib/selectProc.do";
	var sInDataSet  = "";
	var sOutDataSet = "ds_Proc=ds_Proc";
	var sArgument   = "";
	sArgument   += " LIB2=" + quote(sLib);
	sArgument   += " COMPS=" + quote(sComp);
	Transaction(sKind, sMethodName, sInDataSet, sOutDataSet, sArgument, ""); 
	http.Sync = false;
	ds_Proc.InsertRow(0);
	ds_Proc.SetColumn(0,"PROCS","99");
	ds_Proc.SetColumn(0,"PNAME","전체");
}
﻿﻿﻿﻿﻿﻿﻿
/*********************************************************************
*  QR WEB 주야 구분                          *
*    1) D:주간 N:야간                        *
*********************************************************************/
function SetDN(obj, ds) {
	ds.InsertRow(0);
	ds.SetColumn(0,"CODE","D");
	ds.SetColumn(0,"CODE_NAME","주간");
	ds.InsertRow(1);
	ds.SetColumn(1,"CODE","N");
	ds.SetColumn(1,"CODE_NAME","야간");
}

/*********************************************************************
*  QR WEB 창고CODE생성                                            *
*   1,2,3,V,W                                                     *
*********************************************************************/
function SetHouse(sLib){
	if(sLib == "") {
		return false;
	}
	http.Sync = true;
	var sKind  = "getHouse";      
	var sMethodName = "service::psogmlib/selectHouse.do";
	var sInDataSet  = "";
	var sOutDataSet = "ds_House=ds_House";
	var sArgument   = "";
	sArgument   += " LIB2=" + quote(sLib);
	Transaction(sKind, sMethodName, sInDataSet, sOutDataSet, sArgument, ""); 
	http.Sync = false;
}

/*********************************************************************
*  QR WEB 창고CODE생성                                            *
*   1,2,3,V,W                                                     *
*********************************************************************/
function GetTime(obj1,obj2,sComp,sDaygu){
	if(sComp == "") {
		return false;
	}
	
	http.Sync = true;
	var sKind  = "getQRTime";      
	var sMethodName = "service::psogmlib/selectQRTime.do";
	var sInDataSet  = "";
	var sOutDataSet = "ds_QRTime=ds_QRTime";
	var sArgument   = "";
	sArgument   += " LIB2=" + quote(Lib2);
	sArgument   += " COMPS=" + quote(sComp);
	sArgument   += " DAYGU=" + quote(sDaygu);
	Transaction(sKind, sMethodName, sInDataSet, sOutDataSet, sArgument, ""); 
	http.Sync = false;
	var iRow =ds_QRTime.GetRowCount();
	if (iRow < 1){
		return true;
	}
	var stime = "";
	var etime = "";
	for(var i=0; i<iRow ; i++) {
		var sT  = ds_qrtime.GetColumn(i,"WRKST");
		var eT  = ds_qrtime.GetColumn(i,"WRKED");
		stime = stime + sT + "00";
		etime = etime + eT + "00";
	}
	for(var i = iRow; i < 12; i++) {
		stime = stime + "000000";
		etime = etime + "000000";
	}
	if(obj1 == null || obj2 == null) return true;
	obj1.Text = stime;
	obj2.Text = etime;
}