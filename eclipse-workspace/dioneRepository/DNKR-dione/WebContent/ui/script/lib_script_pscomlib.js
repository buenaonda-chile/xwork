/******************************************************************************************************/
/* 1 pscomlib                                                                                         */
/******************************************************************************************************/

/*********************************************************************
*  품명,ITTYP,ITCLS등등                                             *
*********************************************************************/
function getBM001PR_0(c_Lib1,c_procs) {
	var sKind		= "getBM001PR";						
	var sMethodName = "service::pscomlib/selectBM001PR.do";    // 서버에서 호출 될 Method 명
	var sInDataSet  = "";               //자료 저장 시 보낼 DataSet 명칭
	var sOutDataSet = "ds_BM001PR=ds_BM001PR";  	   // 조회 후 돌려 받을 DataSet 명칭
	var sArgument   = "";
		sArgument += " LIB1=" + quote(c_Lib1);
		sArgument += " PROCS=" + quote(c_procs); //공정코드
	http.Sync=true;
	Transaction(sKind, sMethodName, sInDataSet, sOutDataSet, sArgument, "");
	http.Sync=false;
	if (ds_BM001PR.GetRowCount() < 1){
		return false;
	}
	return true;
}

/*********************************************************************
*  품명,ITTYP,ITCLS등등                                             *
*********************************************************************/
function getBM008PR_0(c_Lib1,c_pspno) {
	var sKind		= "getBM008PR";		
	var sMethodName = "service::pscomlib/selectBM008PR.do"; 
	var sInDataSet  = "";
	var sOutDataSet = "ds_BM008PR=ds_BM008PR";
	var sArgument   = "";
		sArgument  += " LIB1=" + quote(c_Lib1);
		sArgument  += " ITNBR=" + quote(trim(c_pspno));
	http.Sync = true;	
	Transaction(sKind, sMethodName, sInDataSet, sOutDataSet, sArgument, "");
	http.Sync = false;
	if (ds_BM008PR.GetRowCount() < 1){
		return false;
	}
	return true;
}


/*********************************************************************
*  LOTSIZE,배수량 등등                                        *
*********************************************************************/
function getBM009PR_0(c_Lib1,c_pspno) {
	var sKind		= "getBM009PR";		
	var sMethodName = "service::pscomlib/selectBM009PR.do"; 
	var sInDataSet  = "";
	var sOutDataSet = "ds_BM009PR=ds_BM009PR";
	var sArgument   = "";
		sArgument  += " LIB1=" + quote(c_Lib1);
		sArgument  += " PSPNO=" + quote(trim(c_pspno));
	http.Sync = true;	
	Transaction(sKind, sMethodName, sInDataSet, sOutDataSet, sArgument, "");
	http.Sync = false;
	if (ds_BM009PR.GetRowCount() < 1){
		return false;
	}
	return true;
}


/*********************************************************************
*  cigma재고                                      *
*********************************************************************/
function getHM000PR_0(c_Lib1,c_pspno,c_house) {
	http.Sync 	= true;
	var sKind		= "getHM000PR";		
	var sMethodName = "service::pscomlib/selectHM000PR.do"; 
	var sInDataSet  = "";
	var sOutDataSet = "ds_HM000PR=ds_HM000PR";
	var sArgument   = "";
		sArgument  += " LIB1=" + quote(c_Lib1);
		sArgument  += " ITNBR=" + quote(trim(c_pspno));
		sArgument  += " HOUSE=" + quote(c_house);
	http.Sync = true;	
	Transaction(sKind, sMethodName, sInDataSet, sOutDataSet, sArgument, "");
	http.Sync = false;
	if (ds_HM000PR.GetRowCount() < 1){
		return false;
	}
	return true;
}

/*********************************************************************
*  가입고재고                                      *
*********************************************************************/
function getBZI500PF_0(c_Lib2,c_comps,c_house,c_pspno,c_vndnr) {
	var sKind		= "getBZI500PF";		
	var sMethodName = "service::pscomlib/selectBZI500PF.do"; 
	var sInDataSet  = "";
	var sOutDataSet = "ds_BZI500PF=ds_BZI500PF";
	var sArgument   = "";
		sArgument  += " LIB2=" + quote(c_Lib2);
		sArgument  += " COMPS=" + quote(c_comps);
		sArgument  += " HOUSE=" + quote(c_house);
		sArgument  += " PSPNO=" + quote(trim(c_pspno));
		sArgument  += " VNDNR=" + quote(trim(c_vndnr));
	http.Sync = true;	
	Transaction(sKind, sMethodName, sInDataSet, sOutDataSet, sArgument, "");
	http.Sync = false;
	if (ds_BZI500PF.GetRowCount() < 1){
		return false;
	}
	return true;
}

/*********************************************************************
*  가입고품번 Check                                                  *
*********************************************************************/
function getBZI100PF_0(c_Lib2,c_comps,c_pspno) {
	var sKind		= "getBZI100PF";		
	var sMethodName = "service::pscomlib/selectBZI100PF.do"; 
	var sInDataSet  = "";
	var sOutDataSet = "ds_BZI100PF=ds_BZI100PF";
	var sArgument   = "";
		sArgument  += " LIB2=" + quote(c_Lib2);
		sArgument  += " COMPS=" + quote(c_comps);
		//sArgument  += " VNDNR=" + quote(trim(c_vndnr));
		sArgument  += " PSPNO=" + quote(trim(c_pspno));
	http.Sync = true;	
	Transaction(sKind, sMethodName, sInDataSet, sOutDataSet, sArgument, "");
	http.Sync = false;
	if (ds_BZI100PF.GetRowCount() < 1){
		return false;
	}
	return true;
}





/******************************************************************************************************/
/* 2 psimmlib                                                                                         */
/******************************************************************************************************/

/*********************************************************************
*  부품출고확정 집계                                                 *
*********************************************************************/
function getBZO210PF_0(c_Lib2,c_comps,c_pspno) {
	var sKind		= "getBZO210PF";		
	var sMethodName = "service::psimmlib/selectFinishBZO210PF.do"; 
	var sInDataSet  = "";
	var sOutDataSet = "ds_BZO210PF=ds_BZO210PF";
	var sArgument   = "";
		sArgument  += " LIB2=" + quote(c_Lib2);
		sArgument  += " COMPS=" + quote(ComboBoxPlant.Value);
		sArgument  += " PSPNO=" + quote(trim(displayDiv.ed_PSPNO.Text));
	http.Sync = true;	
	Transaction(sKind, sMethodName, sInDataSet, sOutDataSet, sArgument, "");
	http.Sync = false;
	if (ds_BZO210PF.GetRowCount() < 1){
		return false;
	}
	return true;
}


/******************************************************************************************************/
/* 3 psfaclib                                                                                         */
/******************************************************************************************************/
function getFHD000PF_0(c_Lib2,c_comps,c_dptcd,c_procs) {
	var sKind		= "getFHD000PF_0";		
	var sMethodName = "service::pscomlib/selectFHD000PF.do"; 
	var sInDataSet  = "";
	var sOutDataSet = "ds_FHD000PF=ds_FHD000PF";
	var sArgument   = "";
		sArgument  += " LIB2=" + quote(c_Lib2);
		sArgument  += " COMPS=" + quote(c_comps);
		sArgument  += " DPTCD=" + quote(trim(c_dptcd));
		sArgument  += " PROCS=" + quote(trim(c_procs));
	http.Sync = true;	
	Transaction(sKind, sMethodName, sInDataSet, sOutDataSet, sArgument, "");
	http.Sync = false;
	if (ds_FHD000PF.GetRowCount() < 1){
		return false;
	}
	return true;
}

function getFHD100PF_0(c_Lib2,c_comps,c_dptcd,c_wrkdt,c_sabun,c_wrkcd) {
	var sKind		= "getBZO210PF";		
	var sMethodName = "service::pscomlib/selectFHD100PF.do"; 
	var sInDataSet  = "";
	var sOutDataSet = "ds_FHD100PF=ds_FHD100PF";
	var sArgument   = "";
		sArgument  += " LIB2=" + quote(c_Lib2);
		sArgument  += " COMPS=" + quote(c_comps);
		sArgument  += " DPTCD=" + quote(trim(c_dptcd));
		sArgument  += " WRKDT=" + quote(trim(c_wrkdt));
		sArgument  += " SABUN=" + quote(trim(c_sabun));
		sArgument  += " WRKCD=" + quote(trim(c_wrkcd));
	http.Sync = true;	
	Transaction(sKind, sMethodName, sInDataSet, sOutDataSet, sArgument, "");
	http.Sync = false;
	if (ds_FHD100PF.GetRowCount() < 1){
		return false;
	}
	return true;
}
