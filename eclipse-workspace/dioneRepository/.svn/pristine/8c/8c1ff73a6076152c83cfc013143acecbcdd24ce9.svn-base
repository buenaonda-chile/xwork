﻿#include "script::form_init.js";
/* for File Upload */

var L_sysUrl = "http://140.101.1.11:8080/ifis"; // ()
var L_uploadRoot = "/webapp/ifis/upload"; // ()
var L_ServerUploadUrl = "http://211.106.113.225/upload/";
//var L_sysUrl = "http://localhost:8080/ifis"; // Local
//var L_uploadRoot = "C:/Program Files/Apache Software Foundation/Tomcat 5.0/webapps/ifis/upload"; // 

var L_uploadUrl = L_sysUrl + "/upload";
var L_upPacketSize = 1048576; // 1024*1024 1048576
var L_downPacketSize = 1048576; // 1024*1024 1048576

var L_downTempDir = "C:\\TEMP\\IFIS";

var L_sysDateTime = iif(isValid(G_sysDate), G_sysDate, getDate()); //  ׽Ʈ  ӽ ġ!  ߿  ˴ϴ.

var L_sysDate = mid(L_sysDateTime, 0, 8); // YYYYMMDD
var L_yearMon = mid(L_sysDateTime, 0, 6); // YYYYMM
var L_year = mid(L_sysDateTime, 0, 4); // YYYY
var L_month = mid(L_sysDateTime, 4, 2); // MM
var L_day = mid(L_sysDateTime, 6, 2); // DD
var L_hour = mid(L_sysDateTime, 8, 2); // HH24
var L_min = mid(L_sysDateTime, 10, 2); // MI
var L_sec = mid(L_sysDateTime, 12, 2); // SS

var L_fileSize = 1024 * 1000 * 5; // ε  ִ ũ 5M
var L_defaultPrefix = mid(this.Url, 0, pos(this.Url,"::"));
var L_ndf = "'Not defined'";
var L_sep = "@@"; // ޽ ڿ ġȯ 
var L_notNull = "NOTNULL"; // Not Null String
var L_alertMsgPrefix = "ALERT_"; // ˸ ޽ Prefix
var L_sessionTimeOut = "SESSIONTIMEOUT"; //  Ÿ ƿ ޽
var L_rowPerPage = 100; //    
var L_commCdDsPrefix = "ds_code"; // ڵ Dataset Prefix

var L_exeFile; //  Excel 
var L_nPopHandler; // ˾ ڵ鷯
var L_validTimerCnt = 0; // Form Timer  Ƚ
var L_invalidComp; // Invalid Component Object
var L_timerEventId_10 = 10; // Not Null ׸ ǥ Timer Event ID
var L_timerEventId_11 = 11; //  Grid Content  Timer Event ID

var L_DELETE = "D"; //  ڵ Ʈ ó ÷ : 
var L_UPDATE = "U"; //  ڵ Ʈ ó ÷ : 
var L_INSERT = "I"; //  ڵ Ʈ ó ÷ : Է

var L_CHK_DISABLE = ""; // ׸ üũ ڽ Disable 
var L_COND_SEPERATOR = " | "; // Ķ 
var L_LEN_HGANBR = 6; // 㰡ȣ 

var L_USER_GROUP_ADMIN = "1"; //  ׷
var L_USER_GROUP_DEV = "2"; //  ׷
var L_USER_GROUP_GUMSA = "3"; // ˻ ׷
var L_USER_GROUP_SEIP = "5"; // ȯ ׷
var L_USER_GROUP_ACCT = "6"; // 繫ȸ ׷
var L_USER_GROUP_JUNGBI = "7"; //  ׷
var L_USER_GROUP_EQUIP = "8"; //  ׷

var L_INFODOC_JIRONO = "<6975540+"; // ȳ ιȣ
var L_INFODOC_CODENO = "<11<"; // ȳ ڵȣ

var L_GUMSA_EQP = "F"; // ˻ 
var L_GUMSA_ACSR = "G"; // ˻ δǰ
var L_ELECT_EQP = "J"; // Ŀ 
var L_ELECT_ACSR = "K"; // Ŀ δǰ
var L_ETC_EQP = "H"; // Ÿ  
var L_ETC_ACSR = "I"; // Ÿ  δǰ

var L_COM_ALT_0001 = "ý Դϴ. ڿ ϼ.";
var L_COM_ALT_0002 = "ȿ  @@ : @@";
var L_COM_ALT_0003 = "ó ڵ尡 ϴ.";
var L_COM_ALT_0004 = "ʼ Ķ  : @@";
var L_COM_ALT_0005 = "Null query string! (in CodeHelp.xml)";
var L_COM_ALT_0006 = "Invalid column name in query string! (in CodeHelp.xml)";
var L_COM_ALT_0007 = "@@() ϼ.";
var L_COM_ALT_0008 = "ʼ Է  . @@";
var L_COM_ALT_0009 = " ü . @@";
var L_COM_ALT_0010 = "  @@ ϴ.";
var L_COM_ALT_0011 = "@@ ϷǾϴ.";
var L_COM_ALT_0012 = "ʼ Է ׸Դϴ. : @@";
var L_COM_ALT_0013 = "   Ʈ : @@";
var L_COM_ALT_0014 = " ϴ. : @@";
var L_COM_ALT_0015 = "̸ @@  ʽϴ.";
var L_COM_ALT_0016 = " @@ մϴ. @@ ϼ.";
var L_COM_ALT_0017 = " ׸  Ұ Դϴ.";
var L_COM_ALT_0018 = "  ϴ.";
var L_COM_ALT_0019 = "ùٸ ¥ ƴմϴ. - @@ / @@";
var L_COM_ALT_0020 = "ڰ ƴմϴ. - @@ / @@";
var L_COM_ALT_0021 = "'ã' ߰   ޴Դϴ.";
var L_COM_ALT_0022 = " Dataset ڵ尡 ϴ.";
var L_COM_ALT_0023 = "@@  Ұ Դϴ.";
var L_COM_ALT_0024 = "@@ ϴ.";
var L_COM_ALT_0025 = "÷  ִ  ũ ִ @@Mbyte Դϴ.";
var L_COM_ALT_0026 = "@@ !";
var L_COM_ALT_0027 = " ׸ ϴ.";
var L_COM_ALT_0028 = "Session time out!\n\nα׷ մϴ. ٽ αϼ.";
var L_COM_ALT_0029 = " ε . : @@";
var L_COM_ALT_0030 = " ε .";
var L_COM_ALT_0031 = " εԴϴ. : @@";
var L_COM_ALT_0032 = "÷ε  ϴ.";
var L_COM_ALT_0033 = "@@ óǾϴ.";
var L_COM_ALT_0034 = "ߺ Ű մϴ.";
var L_COM_ALT_0035 = "ü  ϴ.\n\n'ü ' ޴ ü   ϼ.";
var L_COM_ALT_0036 = "׷ Է  ̿ϼ.";
var L_COM_ALT_0037 = " Ͱ մϴ.   ̿ϼ.";
var L_COM_ALT_0038 = "   @@   ƴմϴ.\n\n  Ƿ ó մϴ.";
var L_COM_ALT_0039 = "     ƴմϴ.";
var L_COM_ALT_0040 = "@@  @@ óǾϴ.";
var L_COM_ALT_0041 = " ʴ @@ Դϴ.";
var L_COM_ALT_0042 = "̹ ϵ @@ մϴ.";
var L_COM_ALT_0043 = "@@ @@   ϴ.";
var L_COM_ALT_0044 = "@@Ǿϴ.";
var L_COM_ALT_0045 = "õ @@ ϴ.";
var L_COM_ALT_0046 = " Է  ̿Ͻñ ٶϴ.";
var L_COM_ALT_0047 = "  ̿ϼ.";
var L_COM_ALT_0048 = "' ' Ͻñ ٶϴ.";
var L_COM_ALT_0049 = "ȳ  뺸/˻/1˻¿ մϴ.";

var L_COM_CNF_0001 = "  Ͻðڽϱ?";
var L_COM_CNF_0002 = "@@ ׷쿡 ο    ˴ϴ.\n\nϽðڽϱ?";
var L_COM_CNF_0003 = "@@ Role ο    ˴ϴ.\n\nϽðڽϱ?";
var L_COM_CNF_0004 = "Ͻðڽϱ?";
var L_COM_CNF_0005 = "@@ Role ޴ @@() մϴ.\n\nϽðڽϱ?";
var L_COM_CNF_0006 = "@@ Role ޴ @@   ޴ մϴ.\n\nϽðڽϱ?";
var L_COM_CNF_0007 = "@@ Role ޴ @@() ߰մϴ.\n\n߰Ͻðڽϱ?";
var L_COM_CNF_0008 = "@@ Role ޴ @@   ޴ ߰մϴ.\n\n߰Ͻðڽϱ?";
var L_COM_CNF_0009 = "@@ Role ޴ @@ ѷ @@() մϴ.\n\nϽðڽϱ?";
var L_COM_CNF_0010 = "@@ Role ޴ @@() ѷ @@() ߰մϴ.\n\n߰Ͻðڽϱ?";
var L_COM_CNF_0011 = "͸ ʱȭ Ͻðڽϱ?";
var L_COM_CNF_0012 = "@@Ͻðڽϱ?";

/*****************************************************

      Ʈ  Լ 2006.03.27

*****************************************************/

/*
 *  ̵
 *
 * param sFormId - ̵ Form ID
 * param sPrefix - ̵   prefix
 *
 */
function lFcGoForm(sFormId, sPrefix)
{
    if(lFcIsNull(sFormId)) {

        trace("Form ID ϴ.");
        return;
    }

    var sUrl = iif(lFcIsNull(sPrefix), L_defaultPrefix, sPrefix);

    sUrl += iif(lFcIsNull(sUrl), sFormId, "::"+sFormId);

    if(toUpper(right(sUrl, 4))!=".XML") { sUrl += ".xml"; }

	Go(sUrl);
}


/*
 * ڷ  ڿ Null θ üũϿ   ش.
 *
 * param sValue - ڿ 
 *
 * return true/false - NULL / NOT NULL
 */
function lFcIsNull(sValue)
{
	var bRtn = false;

	if(length(trim(sValue))<1) bRtn = true;
	else bRtn = false;

	return bRtn;
}


/*
 * ڷ  ڿ Null θ üũϿ   ش.
 *
 * param sValue - ڿ 
 *
 * return true/false - Not Null / Null
 */
function lFcIsNotNull(sValue)
{
	var bRtn = false;

	if(length(trim(sValue))>0) bRtn = true;
	else bRtn = false;

	return bRtn;
}


/*
 * ù° ڷ  ڿ Null θ üũϿ
 *   Null̸ ι°  ,
 * Not Null̸ ù°   ״ ش.
 *
 * param sValue - ڿ 
 * param sTarget - ġȯ ڿ 
 *
 * return true/false - Not Null / Null
 */
function lFcReplaceNull(sValue, sTarget)
{
    var sRtn;

	if(lFcIsNull(sValue)) sRtn = sTarget;
	else sRtn = sValue;

	return sRtn;
}


/*
 * Ϸ 2
 *
 * ׸带      ⸦ ϴ  !
 *  OnTimer ̺Ʈ MiForm_OnTimer Լ Ǿ ־  ۵մϴ.
 *
 * param sGrid       Grid ID
 * param nStartCell  cell index number
 * param sExcYn     'α׷ ' flag [true/false]
 *
 * return void
 */
var sDynamicGrdId;
var nDynamicStartCell;
var bDynamicGrdId;

function lFcOpenExcelExportD(sGridId, nStartCell, bExcYn)
{
    var objGrdExcel = Object(sGridId);
    var objDsExcel = Object(objGrdExcel.BindDataset);

    sDynamicGrdId = sGridId;

    if(isValid(objGrdExcel)) {

        if(isValid(objDsExcel)) {

            if(objDsExcel.RowCount()<1) {

                lFcAlert(L_COM_ALT_0003);
                return;
            }
        } else {

            lFcAlert(L_COM_ALT_0002, "Dataset", objGrdExcel.BindDataset);
            return;
        }

        sDynamicGrdId = sGridId;

    } else {

        lFcAlert(L_COM_ALT_0002, "Grid", sGridId);
        return;
    }

    if(nStartCell>0) nDynamicStartCell = nStartCell;

    if(bExcYn!=null) bDynamicGrdId = bExcYn;

    SetTimer(L_timerEventId_11, 20);
}

/*
 * Ϸ 
 * ׸ ü ȿ üũ -   alert, return;
 * ׸ BindDataset ڵ  üũ - 0    alert, return;
 *
 * param objGrid -  Grid ü
 * param title - 
 * param cond - ȸ 
 * param dtFlag - /   (true/false)
 * param nameFlag - ۾ ̸   (true/false)
 *
 * return void
 */
function lFcOpenExcelExport(objGrid, title, cond, dtFlag, nameFlag)
{
    var sArg;
    var objDsExcel;

    if(isValid(objGrid)) {

		objDsExcel = Object(objGrid.BindDataset);

        if(isValid(objDsExcel)) {

            if(objDsExcel.RowCount()<1) {

                lFcAlert(L_COM_ALT_0003);
                return null;
            }
        } else {

            lFcAlert(L_COM_ALT_0002, "Dataset", objGrid.BindDataset);
            return null;
        }

        if(dtFlag==null) dtFlag = true;
        if(nameFlag==null) nameFlag = true;

        sArg = "objGridId=" + quote(objGrid.ID);
        SArg += " sTitle=" + quote(title);
        SArg += " sCond=" + quote(cond);
        SArg += " bDtFlag=" + quote(dtFlag);
        SArg += " bNameFlag=" + quote(nameFlag);

    } else {

        lFcAlert(L_COM_ALT_0002, "Grid", objGrid.ID);
        return null;
    }

    var dlgRtn = Dialog("Common::PopExcelDown.xml", sArg, 440, 170);

    if(dlgRtn) {

		ExecShell(L_exeFile);
	}

    return null;
}

/*
 * Ϸ 
 * ׸ ü ȿ üũ -   alert, return;
 * ׸ BindDataset ڵ  üũ - 0    alert, return;
 *
 * param sGridId -  Grid ID
 * param title - 
 * param cond - ȸ 
 * param dtFlag - /   (true/false)
 * param nameFlag - ۾ ̸   (true/false)
 *
 * return void
 */
function lFcOpenExcelExport2(sGridId, title, cond, dtFlag, nameFlag)
{
    var sArg;
    var objDsExcel;

    var objGrid = object(sGridId);

    if(isValid(objGrid)) {

		objDsExcel = Object(objGrid.BindDataset);

        if(isValid(objDsExcel)) {

            if(objDsExcel.RowCount()<1) {

                lFcAlert(L_COM_ALT_0003);
                return null;
            }
        } else {

            lFcAlert(L_COM_ALT_0002, "Dataset", objGrid.BindDataset);
            return null;
        }

        if(dtFlag==null) dtFlag = true;
        if(nameFlag==null) nameFlag = true;

        sArg = "objGridId=" + quote(sGridId);
        SArg += " sTitle=" + quote(title);
        SArg += " sCond=" + quote(cond);
        SArg += " bDtFlag=" + quote(dtFlag);
        SArg += " bNameFlag=" + quote(nameFlag);

    } else {

        lFcAlert(L_COM_ALT_0002, "Grid", objGrid.ID);
        return null;
    }

    var dlgRtn = Dialog("Common::PopExcelDown.xml", sArg, 440, 170);

    if(dlgRtn) {

		ExecShell(L_exeFile);
	}

    return null;
}



/*
 * ֹεϹȣ ռ  üũ Լ
 *
 * param strNumb - ֹιȣ 13ڸ Ǵ 14ڸ('-' )
 *
 * return true/false -  / 
 */
function lFcCheckJumin(strNumb) {

    strNumb = replace(strNumb, "-", "");

    var rtn = _lFcCheckJumin(strNumb.substr(0, 6), strNumb.substr(6));

	if(rtn==-1) {

		return false;

	} else {

		return true;
	}
}

function _lFcCheckJumin(val1, val2) {

    var tmp1, tmp2, tmp3;
    var t1, t2, t3, t4, t5, t6, t11, t12, t13, t14, t15, t16, t17;

    tmp1 = val1.substr(2, 2);
    tmp2 = val1.substr(4);
    tmp3 = val2.substr(0, 1);

    if( _lFcDoCheckProResnoLength( val1 ) == -1 ) return -1;
    if( _lFcDoCheckPreResnoLength( val2 ) == -1 ) return -1;
    if ( (tmp1 < "01") || (tmp1 > "12") ) return -1;
    if ( (tmp2 < "01") || (tmp2 > "31") ) return -1;
    if ( (tmp3 == "5") ) return 0; //ܱϰ  üũ ǳʶ
    if ( (tmp3 == "6") ) return 0; //ܱϰ  üũ ǳʶ
    if ( (tmp3 < "1" ) || (tmp3 > "4" ) ) return -1;

    //alert('tmp1:'+tmp1+'tmp2:'+tmp2+'tmp3:'+tmp3);
    
    t1 = val1.substr( 0, 1 );
    t2 = val1.substr( 1, 1 );
    t3 = val1.substr( 2, 1 );
    t4 = val1.substr( 3, 1 );
    t5 = val1.substr( 4, 1 );
    t6 = val1.substr( 5, 1 );
    t11 = val2.substr( 0, 1 );
    t12 = val2.substr( 1, 1 );
    t13 = val2.substr( 2, 1 );
    t14 = val2.substr( 3, 1 );
    t15 = val2.substr( 4, 1 );
    t16 = val2.substr( 5, 1 );
    t17 = val2.substr( 6, 1 );

    //alert('t1:'+t1+'t2:'+t2+'t3:'+t3+'t4:'+t4+'t5:'+t5+'t6:'+t6+'t11:'+t11+'t12:'+t12+'t13:'+t13+'t14:'+t14+'t15:'+t15+'t16:'+t16+'t17:'+t17);
    //var tot = t1 * 2 + t2 * 3 + t3 * 4 + t4 * 5 + t5 * 6 + t6 * 7;
    //tot += t11 * 8 + t12 * 9 + t13 * 2 + t14 * 3 + t15 * 4 + t16 * 5 ;

    //var result = tot % 11;
    //result = ( 11 - result ) % 10;

    var tot = tointeger(t1) * 2 + tointeger(t2) * 3 + tointeger(t3) * 4 + tointeger(t4) * 5 + tointeger(t5) * 6 + tointeger(t6) * 7;
    tot += tointeger(t11) * 8 + tointeger(t12) * 9 + tointeger(t13) * 2 + tointeger(t14) * 3 + tointeger(t15) * 4 + tointeger(t16) * 5 ;

    var result = tointeger(tot) % 11;
    result = ( 11 - tointeger(result) ) % 10;

    if (result==t17) {

        return 0;

    } else {

        return -1;
    }
}


// ֹιȣ  check ( 6ڸ)
function _lFcDoCheckProResnoLength( szProResno ) {

    if( szProResno.length == 6 ) {

        return 0;

    } else {

        return -1;
    }
}

// ֹιȣ  check ( 7ڸ)
function _lFcDoCheckPreResnoLength( szPreResno ) {

    if( szPreResno.length == 7 ) {

        return 0;

    } else {

        return -1;
    }
}


/*
 * ڹȣ ռ  üũ Լ
 *
 * param strNumb - ڹȣ 10ڸ Ǵ 11ڸ('-' )
 *
 * return true/false -  / 
 */
function lFnChkWorkNumb(strNumb) {

    strNumb = replace(strNumb, "-", "");

    if (strNumb.length!=10) {
        //alert("ڵϹȣ ߸Ǿϴ.");
        return false;
    }

    var nSumMod = 0;

    nSumMod += ParseInt(strNumb.substr(0,1));
    nSumMod += ParseInt(strNumb.substr(1,1)) * 3 % 10;
    nSumMod += ParseInt(strNumb.substr(2,1)) * 7 % 10;
    nSumMod += ParseInt(strNumb.substr(3,1)) * 1 % 10;
    nSumMod += ParseInt(strNumb.substr(4,1)) * 3 % 10;
    nSumMod += ParseInt(strNumb.substr(5,1)) * 7 % 10;
    nSumMod += ParseInt(strNumb.substr(6,1)) * 1 % 10;
    nSumMod += ParseInt(strNumb.substr(7,1)) * 3 % 10;
    nSumMod += Floor(ParseInt(strNumb.substr(8,1)) * 5 / 10);
    nSumMod += ParseInt(strNumb.substr(8,1)) * 5 % 10;
    nSumMod += ParseInt(strNumb.substr(9,1));

    if(nSumMod%10 != 0) {
		//alert("ڵϹȣ ߸Ǿϴ.");
        return false;
    }
    return true;
}


/**
 *  Dataset (߰,,) ڵ常 Ͽ Target Dataset Ѵ.
 * Target Dataset FLAG column ߰Ǿ ߰:I, :U, :D  Ѵ.
 * Delete, Update, Insert   -->  2007.02.16
 *
 * param objDsSrc -  Dastset ü
 * param objDsTgt - Target Dastset ü
 *
 * return void
 */
function lFcSetModDs(objDsSrc, objDsTgt) {

    var sRowType;
    var nRowNum;

    var sInUserCol = "CRTID"; //  ID() Į
    var sUpUserCol = "CHGID"; //  ID() Į

    var sUserColNm = "SAWNBR"; // α  ID() Į

    //var sInDtCol = "CRTDAT";
    //var sUpDtCol = "CHGDAT";

    if(!isValid(objDsSrc)) {

        lFcAlert(L_COM_ALT_0002, "Dataset", objDsSrc);
        return;
    }

    if(!isValid(objDsTgt)) {

        lFcAlert(L_COM_ALT_0002, "Dataset", objDsTgt);
        return;
    }

    if(objDsSrc.GetOrgBuffCount()<1 && objDsSrc.RowCount<1) {

        objDsTgt.ClearData();
        return;
    }

    objDsTgt.Copy(objDsSrc);
    objDsTgt.ClearData();
    objDsTgt.AddColumn("_FLAG", "STRING", 10);
    objDsTgt.AddColumn("_SORT", "INT", 1);
    var v_chk;

    for(var i=0; i<objDsSrc.GetOrgBuffCount(); i++) {

        sRowType = objDsSrc.GetOrgBuffType(i);
		
		//v_chk = objDsSrc.GetColIndex('CHK');
		
        if(sRowType=="delete") {
			//if( v_chk > -1 && objDsSrc.GetColumn(i,objDsSrc.GetColID(v_chk)) != '1' ) continue;	//߰ 07.28
				
				nRowNum = objDsTgt.AppendRow();
	
				for(var j=0; j<objDsSrc.GetColCount(); j++) {
					
					objDsTgt.SetColumn(
						nRowNum,
						objDsSrc.GetColID(j),
						objDsSrc.GetOrgBuffColumn(i, objDsSrc.GetColID(j))
					);
				}
	
				objDsTgt.SetColumn(nRowNum, "_FLAG", toUpperCase(sRowType.mid(0,1)));
				objDsTgt.SetColumn(nRowNum, "_SORT", 1);
	
				if(objDsTgt.GetColIndex(sUpUserCol)!=-1) { //   Է
	
					objDsTgt.SetColumn(nRowNum, sUpUserCol, G_ds_user.GetColumn(0, sUserColNm));
				}

        }
    }

    for(var i=0; i<objDsSrc.RowCount(); i++) {
	
        sRowType = objDsSrc.GetRowType(i);
        //v_chk = objDsSrc.GetColIndex('CHK');	// 07.30

        if(sRowType=="insert" || sRowType=="update") {
			//if( v_chk > -1 && objDsSrc.GetColumn(i,objDsSrc.GetColID(v_chk)) != '1' ) continue;	//߰ 07.28
			
			nRowNum = objDsTgt.AppendRow();
			objDsTgt.CopyRow(nRowNum, objDsSrc, i);
			objDsTgt.SetColumn(nRowNum, "_FLAG", toUpperCase(sRowType.mid(0,1)));

			if(sRowType=="update") {

				objDsTgt.SetColumn(nRowNum, "_SORT", 2);

				if(objDsTgt.GetColIndex(sUpUserCol)!=-1) { //   Է

					objDsTgt.SetColumn(nRowNum, sUpUserCol, G_ds_user.GetColumn(0, sUserColNm));
				}
				
			} else if(sRowType=="insert") {

				objDsTgt.SetColumn(nRowNum, "_SORT", 3);

				if(objDsTgt.GetColIndex(sInUserCol)!=-1) { //   Է

					objDsTgt.SetColumn(nRowNum, sInUserCol, G_ds_user.GetColumn(0, sUserColNm));
				}
			}

        }
    }

    objDsTgt.Sort("_SORT");
    
}


/**
 * ͵  Dataset  Ͽ ...
 *  Dataset (߰,,) ڵ常 Ͽ Target Dataset Ѵ.
 * Target Dataset FLAG column ߰Ǿ ߰:I, :U, :D  Ѵ.
 * Delete, Update, Insert   -->  2007.02.16
 *
 * param objDsSrc -  Dastset ü
 * param objDsTgt - Target Dastset ü
 *
 * return void
 */
function lFcSetModDsNF(objDsSrc, objDsTgt) {

    var sRowType;
    var nRowNum;

    var sInUserCol = "CRTID"; //  ID() Į
    var sUpUserCol = "CHGID"; //  ID() Į

    var sUserColNm = "SAWNBR"; // α  ID() Į

    //var sInDtCol = "CRTDAT";
    //var sUpDtCol = "CHGDAT";

    if(!isValid(objDsSrc)) {

        lFcAlert(L_COM_ALT_0002, "Dataset", objDsSrc);
        return;
    }

    if(!isValid(objDsTgt)) {

        lFcAlert(L_COM_ALT_0002, "Dataset", objDsTgt);
        return;
    }

    if(objDsSrc.GetOrgBuffCount()<1 && objDsSrc.RowCount<1) {

        objDsTgt.ClearData();
        return;
    }

    objDsTgt.Copy(objDsSrc);
    objDsTgt.ClearData();
    objDsTgt.AddColumn("_FLAG", "STRING", 10);
    objDsTgt.AddColumn("_SORT", "INT", 1);

    for(var i=0; i<objDsSrc.GetOrgBuffCount(); i++) {

        sRowType = objDsSrc.GetOrgBuffType(i);

        if(sRowType=="delete") {

            nRowNum = objDsTgt.AppendRow();

            for(var j=0; j<objDsSrc.GetColCount(); j++) {

                objDsTgt.SetColumn(
                    nRowNum,
                    objDsSrc.GetColID(j),
                    objDsSrc.GetOrgBuffColumn(i, objDsSrc.GetColID(j))
                );
            }

            objDsTgt.SetColumn(nRowNum, "_FLAG", toUpperCase(sRowType.mid(0,1)));
            objDsTgt.SetColumn(nRowNum, "_SORT", 1);

            if(objDsTgt.GetColIndex(sUpUserCol)!=-1) { //   Է

                objDsTgt.SetColumn(nRowNum, sUpUserCol, G_ds_user.GetColumn(0, sUserColNm));
            }
        }
    }

	var sColId;

    for(var i=0; i<objDsSrc.RowCountNF(); i++) {

        sRowType = objDsSrc.GetRowTypeNF(i);

        if(sRowType=="insert" || sRowType=="update") {

            nRowNum = objDsTgt.AppendRow();

            //objDsTgt.CopyRow(nRowNum, objDsSrc, i);

			for(var j=0; j<objDsSrc.GetColCount(); j++) {

				sColId = objDsSrc.GetColID(j);
				
				objDsTgt.SetColumn(nRowNum, sColId, objDsSrc.GetColumnNF(i, sColId));
			}

            objDsTgt.SetColumn(nRowNum, "_FLAG", toUpperCase(sRowType.mid(0,1)));

            if(sRowType=="update") {

                objDsTgt.SetColumn(nRowNum, "_SORT", 2);

                if(objDsTgt.GetColIndex(sUpUserCol)!=-1) { //   Է

                    objDsTgt.SetColumn(nRowNum, sUpUserCol, G_ds_user.GetColumn(0, sUserColNm));
                }
            } else if(sRowType=="insert") {

                objDsTgt.SetColumn(nRowNum, "_SORT", 3);

                if(objDsTgt.GetColIndex(sInUserCol)!=-1) { //   Է

                    objDsTgt.SetColumn(nRowNum, sInUserCol, G_ds_user.GetColumn(0, sUserColNm));
                }
            }
        }
    }

    objDsTgt.Sort("_SORT");
}


/*
 * ΰ ¥  ޾Ƽ   ϼ ش.
 *
 * param sFdate -  From  YYYYMMDD
 * param sTdate - To  YYYYMMDD
 * return  ϼ
 */
function lFcCalcuDayCnt(sFdate, sTdate) {

    if(lFcIsNotNull(sFdate) && !lFcChkDate(sFdate)) {

        return;
    }

    if(lFcIsNotNull(sTdate) && !lFcChkDate(sTdate)) {

        return;
    }

    //var fromDate = lFcGetDayCnt(sFdate); // from date   
    //var toDate = lFcGetDayCnt(sTdate); // to date   
    var fromDate = DateTime(sFdate);
    var toDate = DateTime(sTdate);

    return (toDate - fromDate);
}

var L_ArrLastDayOfMonth = [31,28,31,30,31,30,31,31,30,31,30,31];

/*
 * ¥  ȿ üũ
 *
 * param sDate -  
 * param sFormat - date format : YYYYMMDD / YYYYMM / MMDD / MM / DD
 * return true/false
 */
function lFcChkDate(sDate, sFormat)
{
    var nYear = 0;
    var nMonth = 0;
    var nDay = 0;
    var nLastDay;
    
    if(lFcIsNull(sDate)) {

		return false;
    }

    if(lFcIsNull(sFormat)) {

        sFormat = "YYYYMMDD";
    }

    if(!isDigit(sDate)) {

        lFcAlert(L_COM_ALT_0020, sDate, sFormat);

        return false;
    }

    if(sFormat=="YYYYMMDD") {

        if(length(sDate)!=8) {

            lFcAlert(L_COM_ALT_0019, sDate, sFormat);

            return false;
        }

        nYear = parseInt(sDate.substr(0, 4));
        nMonth = parseInt(sDate.substr(4, 2));
        nDay = parseInt(sDate.substr(6, 2));

        if(nMonth==2) {

            nLastDay = iif(((nYear%4==0 && nYear%100!=0) || nYear%400==0), 29, L_ArrLastDayOfMonth[nMonth-1]);

        } else {
        
            nLastDay = L_ArrLastDayOfMonth[nMonth-1];
        }

    } else if(sFormat=="YYYYMM") {

        if(length(sDate)!=6 ) {

            lFcAlert(L_COM_ALT_0019, sDate, sFormat);

            return false;
        }

        nYear = parseInt(sDate.substr(0, 4));
        nMonth = parseInt(sDate.substr(4, 2));

    } else if(sFormat=="YYYY") {

        if(length(sDate)!=4) {

            lFcAlert(L_COM_ALT_0019, sDate, sFormat);
            
            return false;
        }

        nYear = parseInt(sDate);

    } else if(sFormat=="MMDD") {

        if(length(sDate)!=4) {

            lFcAlert(L_COM_ALT_0019, sDate, sFormat);
            
            return false;
        }

        nMonth = parseInt(sDate.substr(0, 2));
        nDay = parseInt(sDate.substr(2, 2));
        nLastDay = L_ArrLastDayOfMonth[nMonth-1];

    } else if(sFormat=="MM") {

        if(length(sDate)!=2) {

            lFcAlert(L_COM_ALT_0019, sDate, sFormat);
            
            return false;
        }

        nMonth = parseInt(sDate);

    } else if(sFormat=="DD" ) {

        if(length(sDate)!=2) {

            lFcAlert(L_COM_ALT_0019, sDate, sFormat);

            return false;
        }

        nDay = parseInt(sDate);
        nLastDay = 31;
    }

    if(nYear!=0 && (nYear<1891 || nYear>2099)) {

        lFcAlert(L_COM_ALT_0019, sDate, sFormat);

        return false;
    }

    if(nMonth!=0 && (nMonth<1 || nMonth>12)) {

        lFcAlert(L_COM_ALT_0019, sDate, sFormat);

        return false;
    }

	if(nDay!=0 && nDay<1 || nDay>nLastDay) {

        lFcAlert(L_COM_ALT_0019, sDate, sFormat);

        return false;
    }

    return true;
}


// ׸ ı : 
var L_SORT_ASC  = "";
var L_SORT_DESC = "";


/**
 * ׸  
 *
 * param objGrd - ׸ ü
 * param nCellbody - ļ(body) Index Ǵ '^' ڷ еǴ index ڿ ) "0^1", "1^2", "0^1^2", ...
 * param nCellHead - ı ǥ (head) Index : Nullable
 * param sFlag - ı(L_SORT_ASC/L_SORT_DESC) : Nullable
 * param bBigNull - true/false : NULL   ,  ũ   : Nullable
 *
 * return void
 */
function lFcGridSort(objGrd, nCellBody, nCellHead, sFlag, bBigNull)
{
    var nHeadCnt;
    var arrCellIdx;

    //var objGrd = Object(gridId);

    if(!isValid(objGrd)) {

        lFcAlert(L_COM_ALT_0002, "Grid", objGrd);

        return;
    }

    var objDs = Object(objGrd.BindDataset);

    if(!isValid(objDs)) {

        lFcAlert(L_COM_ALT_0002, "Dataset.ID", objGrd.BindDataset);

        return;
    }

    if(objDs.GetRowCount()<1) {

        return;
    }

    if(nCellBody==null) {

        lFcAlert(L_COM_ALT_0004, "ι° Ķ - ļ(body) Index");

        return;
    }

    if(nCellHead==null) {

        nCellHead = nCellBody;
    }

    if(sFlag!=null && sFlag!=L_SORT_ASC && sFlag!=L_SORT_DESC) {

        lFcAlert(L_COM_ALT_0002, " ", sFlag);

        return;
    }

    if(bBigNull==null) {

        bBigNull = false;
    }

    nHeadCnt = objGrd.GetCellCount("head");

    //objGrd.BindDataset = "";
    objDs.FireEvent = false;

    var sTargetFlag;
    var sTitle;
    //var sOriginFlag = right(objGrd.GetCellProp("head", nCellBody, "text"), 1);
    var sOriginFlag = right(objGrd.GetCellProp("head", nCellHead, "text"), 1);

    if(sFlag!=null) sTargetFlag = sFlag;
    else if(sOriginFlag==L_SORT_ASC) sTargetFlag = L_SORT_DESC;
    else if(sOriginFlag==L_SORT_DESC) sTargetFlag = L_SORT_ASC;
    else sTargetFlag = L_SORT_ASC;

    arrCellIdx = split(nCellBody, "^");

    var sSort = "";

    /*
    for(var i=0; i<length(arrCellIdx); i++) {
        sSort += objGrd.GetCellProp("body", arrCellIdx[i], "colid");
        if(i<length(arrCellIdx)-1) {

            sSort += ",";
        }
    }
    */
	// WS Project  ͸   ٲ㼭 ۾ϱ⶧
	//    ӽʵ ޾ƿ ʵ óǵ 
    for(var i=0; i<length(arrCellIdx); i++) {
		var colid = objGrd.GetCellProp("body", arrCellIdx[i], "colid");
		colid = iif(objDs.GetColIndex("_SORT4NUM_"+colid)>-1, "_SORT4NUM_", "") + colid;
        sSort += colid;
        if(i<length(arrCellIdx)-1) {

            sSort += ",";
        }
    }
		trace(sSort);

    //trace(sSort);

    // شϴ  ŸƲ Ʈũ ߰ Ǵ Ѵ.
    if(sTargetFlag==L_SORT_ASC) {

        //objDs.sort(objGrd.GetCellProp("body", nCellBody, "colid"), true);
        objDs.sort(sSort, true, bBigNull);

        sTitle = objGrd.GetCellProp("head",nCellHead,"text");
        sTitle = replace(sTitle, L_SORT_ASC, "");
        sTitle = replace(sTitle, L_SORT_DESC, "");
        sTitle = sTitle + L_SORT_ASC;

    } else if(sTargetFlag==L_SORT_DESC) {

        //objDs.sort(objGrd.GetCellProp("Body",nCellBody,"colid"), false);
        objDs.sort(sSort, false, bBigNull);

        sTitle = objGrd.GetCellProp("head",nCellHead,"text");
        sTitle = replace(sTitle, L_SORT_ASC, "");
        sTitle = replace(sTitle, L_SORT_DESC, "");
        sTitle = sTitle + L_SORT_DESC;
    }

    objGrd.SetCellProp("head", nCellHead, "text", sTitle);

    var sRepText = "";

    // شϴ  ̿ ش ŸƲ Ʈũ Ѵ.
    for(i=0; i<nHeadCnt; i++)
    {
        if(nCellHead<>i) {

            sRepText = replace(objGrd.GetCellProp("head",i,"text"), L_SORT_ASC, "");
            sRepText = replace(sRepText, L_SORT_DESC, "");

            objGrd.SetCellProp("head", i, "text", sRepText);
        }
    }

    //objGrd.BindDataset = objDs.ID();
    objDs.FireEvent = true;

    return;
}

/*
 * ׸    Ŭ忡 Ѵ.
 *
 * param objGrd - ׸ ü
 *
 * return void
 */
function lFcGridCellValueToClipBoard(objGrd)
{
	var objDs = object(objGrd.BindDataSet);
	var nRow = objDs.row;
	var nCol = objGrd.GetCellPos();

	var cell_value = objGrd.GetCellValue(nRow,nCol);
	if (lfcIsNull(cell_value)) cell_value = objGrd.GetCellText("body", nRow, nCol);

	ClearClipboard();
	SetClipBoard("CF_TEXT", cell_value);
}

/*
 * ׸  ŸƲ ߰ Sort Mark Ѵ.
 *
 * param objGrd - ׸ ü
 *
 * return void
 */
function lFcClearSortMark(objGrd) {

    if(!isValid(objGrd)) {

        lFcAlert(L_COM_ALT_0002, "Grid", objGrd);

        return;
    }

    var nHeadCnt = objGrd.GetCellCount("head");
    var sRepText;

    for(i=0; i<nHeadCnt; i++) {
        
        sRepText = objGrd.GetCellProp("head",i,"text");

        sRepText = replace(sRepText, L_SORT_ASC, "");
        sRepText = replace(sRepText, L_SORT_DESC, "");

        objGrd.SetCellProp("head", i, "text", sRepText);
    }
}

/*
 * Combo.InnerDataset  ε Dataset 0° index ڵ带 ߰Ѵ.
 * flag Ķ   "- ü -", "-  -" ׸ ޺ڽ µȴ.
 *
 * param datasetId - Combo.InnerDataset ID
 * param codeCol - Combo.CodeColumn 
 * param nameCol - Combo.DataComumn 
 * param flag - "A"/"- ü -", "S"/"-  -"
 *
 * return void
 */
function lFcInsertRow(datasetId, codeCol, nameCol, flag) {

    var objDs = Object(datasetId);
	var sAll = "- ü -";
	var sSel = "-  -";

	if(objDs.GetColumn(0, nameCol) == sAll || objDs.GetColumn(0, nameCol) == sSel) return;

    if(!isValid(objDs)) {
        alert("ȿ  Dataset! - " + datasetId);
        return;
    }

    if(lFcIsNull(codeCol)) {
        alert("CodeColumn  ϴ. - " + codeCol);
        return;
    }

    if(lFcIsNull(nameCol)) {
        alert("DataColumn  ϴ. - " + nameCol);
        return;
    }

    if(flag!="A" && flag!="S") {

        alert("ȿ  Ķ flag - " + flag + "\n\n" +
              "'A' Ǵ 'S' ϼ.\n"
        );
        return;
    }

    if(objDs.GetColIndex(codeCol)==-1) {
        alert(" ʴ Column -" + codeCol);
        return;
    }

    if(objDs.GetColIndex(nameCol)==-1) {
        alert(" ʴ Column -" + nameCol);
        return;
    }

    objDs.InsertRow(0);
    objDs.SetColumn(0, codeCol, "");

    if(flag=="A") {
		objDs.SetColumn(0, nameCol, sAll);
    } else if(flag=="S") {
		objDs.SetColumn(0, nameCol, sSel);
    }
}



/**
 * ̹  ̸
 *
 * @param fullName -  ̹  URL Ǵ  ̹  full name
 *                   http://140.101.1.11:8080/ifis/upload/image/200600038400010002_imga.jpg
 *                   C:\\img_folder\\img_file.gif
 * @return void
 */
function lFcImgPreView(fullName) {

    var nWidth = 800;
    var nHeight = 600;

    var nPosX = (getDeviceInfo("CXScreen")-nWidth)/2;
    var nPosY = (getDeviceInfo("CYScreen")-nHeight-30)/2;

    if(indexOf(toUpper(fullName), "HTTP")!=-1) {

        fullName = replace(fullName, " ", "%20");
    }

    var sArg = "fullName="+quote(fullName);

    if(lFcIsNull(L_nPopHandler)) {

        L_nPopHandler = Open("common::PopImgPreView.xml", sArg, nWidth, nHeight, "", nPosX, nPosY);

        //trace(L_nPopHandler);

    } else {

        PopImgPreView.img_real.ImageID = fullName;

        //trace(PopImgPreView.UserData);
        //PopImgPreView.Open("common::CommViewer.xml", sArg); //  !
    }

    return;
}






/*
 * Confirm Popup window open!
 *
 * param msg -  ޽
 * param arg1 - ޽ Ե ڰ1
 * param arg2 - ޽ Ե ڰ2
 * param arg3 - ޽ Ե ڰ3
 * param arg4 - ޽ Ե ڰ4
 * param arg5 - ޽ Ե ڰ5
 *
 * return true/false - ̿ڰ 'Yes'ư  true/ 'No'ư  false
 */
function lFcConfirm(msg, arg1, arg2, arg3, arg4, arg5) {

    var objArrArg;

    if(arg1==null) {

        objArrArg = array();

    } else if(arg2==null) {

        objArrArg = array(1);

        objArrArg[0] = lFcReplaceNull(arg1, L_ndf);

    } else if(arg3==null) {

        objArrArg = array(2);

        objArrArg[0] = lFcReplaceNull(arg1, L_ndf);
        objArrArg[1] = lFcReplaceNull(arg2, L_ndf);

    } else if(arg4==null) {

        objArrArg = array(3);

        objArrArg[0] = lFcReplaceNull(arg1, L_ndf);
        objArrArg[1] = lFcReplaceNull(arg2, L_ndf);
        objArrArg[2] = lFcReplaceNull(arg3, L_ndf);

    } else if(arg5==null) {

        objArrArg = array(4);

        objArrArg[0] = lFcReplaceNull(arg1, L_ndf);
        objArrArg[1] = lFcReplaceNull(arg2, L_ndf);
        objArrArg[2] = lFcReplaceNull(arg3, L_ndf);
        objArrArg[3] = lFcReplaceNull(arg4, L_ndf);

    } else {

        objArrArg = array(5);

        objArrArg[0] = lFcReplaceNull(arg1, L_ndf);
        objArrArg[1] = lFcReplaceNull(arg2, L_ndf);
        objArrArg[2] = lFcReplaceNull(arg3, L_ndf);
        objArrArg[3] = lFcReplaceNull(arg4, L_ndf);
        objArrArg[4] = lFcReplaceNull(arg5, L_ndf);
    }

    return lFcConfirms(msg, objArrArg);
}


/*
 * Confirm Popup window open!
 *
 * param msg -  ޽
 * param saArg - ޽ Ե ڰ 迭
 *
 * return true/false - ̿ڰ 'Yes'ư  true/ 'No'ư  false
 */
function lFcConfirms(msg, saArg) {

    var sMsg;

    msg = iif(right(msg, 2)==L_sep, msg + " ", msg);

    var objArrMsg = split(msg, L_sep, false, true, false);
    var objArrArg;

    if(length(objArrMsg)<2) {

        sMsg = msg;

    } else {

        objArrArg = array(length(objArrMsg)-1);

        for(var i=0; i<length(objArrArg); i++) {

            objArrArg[i] = iif(lFcIsNull(saArg[i]), L_ndf, saArg[i]);
        }

        for(var i=0; i<length(objArrMsg); i++) {

            sMsg += objArrMsg[i];

            if(i+1==length(objArrMsg)) {

                break;
            }

            sMsg += objArrArg[i];
        }
    }

    //var bRtn = Dialog("common::MsgAlert.xml", "msg="+quote(trim(sMsg)), 482, 156);
    var bRtn = Confirm(trim(sMsg));

    return bRtn;
}


/*
 * Alert Popup window open!
 *
 * param msg -  ޽
 * param arg1 - ޽ Ե ڰ1
 * param arg2 - ޽ Ե ڰ2
 * param arg3 - ޽ Ե ڰ3
 * param arg4 - ޽ Ե ڰ4
 * param arg5 - ޽ Ե ڰ5
 *
 * return void
 */
function lFcAlert(msg, arg1, arg2, arg3, arg4, arg5) {

    var objArrArg;

    if(arg1==null) {

        objArrArg = array();

    } else if(arg2==null) {

        objArrArg = array(1);

        objArrArg[0] = lFcReplaceNull(arg1, L_ndf);

    } else if(arg3==null) {

        objArrArg = array(2);

        objArrArg[0] = lFcReplaceNull(arg1, L_ndf);
        objArrArg[1] = lFcReplaceNull(arg2, L_ndf);

    } else if(arg4==null) {

        objArrArg = array(3);

        objArrArg[0] = lFcReplaceNull(arg1, L_ndf);
        objArrArg[1] = lFcReplaceNull(arg2, L_ndf);
        objArrArg[2] = lFcReplaceNull(arg3, L_ndf);

    } else if(arg5==null) {

        objArrArg = array(4);

        objArrArg[0] = lFcReplaceNull(arg1, L_ndf);
        objArrArg[1] = lFcReplaceNull(arg2, L_ndf);
        objArrArg[2] = lFcReplaceNull(arg3, L_ndf);
        objArrArg[3] = lFcReplaceNull(arg4, L_ndf);

    } else {

        objArrArg = array(5);

        objArrArg[0] = lFcReplaceNull(arg1, L_ndf);
        objArrArg[1] = lFcReplaceNull(arg2, L_ndf);
        objArrArg[2] = lFcReplaceNull(arg3, L_ndf);
        objArrArg[3] = lFcReplaceNull(arg4, L_ndf);
        objArrArg[4] = lFcReplaceNull(arg5, L_ndf);
    }

    lFcAlerts(msg, objArrArg);
}


/*
 * Alert Popup window open!
 *
 * param msg -  ޽
 * param saArg - ޽ Ե ڰ 迭
 *
 * return void
 */
function lFcAlerts(msg, saArg) {

    var sMsg;

    msg = iif(right(msg, 2)==L_sep, msg + " ", msg);

    var objArrMsg = split(msg, L_sep, false, true, false);
    var objArrArg;

    if(length(objArrMsg)<2) {

        sMsg = msg;

    } else {

        objArrArg = array(length(objArrMsg)-1);

        for(var i=0; i<length(objArrArg); i++) {

            objArrArg[i] = iif(lFcIsNull(saArg[i]), L_ndf, saArg[i]);
        }

        for(var i=0; i<length(objArrMsg); i++) {

            sMsg += objArrMsg[i];

            if(i+1==length(objArrMsg)) {

                break;
            }

            sMsg += objArrArg[i];
        }
    }
	
	var bRtn;

	// Sesstion Timeout ޽   α׷   ó
    if(sMsg==L_sessionTimeOut) {

        bRtn = alert(L_COM_ALT_0028);

        execProc("Miplatform320.exe", "eKins"); // ٽ ȣ ִ κ

        exit();
    }

    //bRtn = Dialog("common::MsgAlert.xml", "msg="+quote(trim(sMsg)), 482, 156);
    bRtn = alert(trim(sMsg));

    return null;
}

/*
 *  ޽ Alert Popup window open!
 *
 * param msg -  ޽
 * param arg1 - ޽ Ե ڰ1
 * param arg2 - ޽ Ե ڰ2
 * param arg3 - ޽ Ե ڰ3
 * param arg4 - ޽ Ե ڰ4
 * param arg5 - ޽ Ե ڰ5
 *
 * return void
 */
function lFcAlertErr(msg, arg1, arg2, arg3, arg4, arg5) {

    var objArrArg;

    if(arg1==null) {

        objArrArg = array();

    } else if(arg2==null) {

        objArrArg = array(1);

        objArrArg[0] = lFcReplaceNull(arg1, L_ndf);

    } else if(arg3==null) {

        objArrArg = array(2);

        objArrArg[0] = lFcReplaceNull(arg1, L_ndf);
        objArrArg[1] = lFcReplaceNull(arg2, L_ndf);

    } else if(arg4==null) {

        objArrArg = array(3);

        objArrArg[0] = lFcReplaceNull(arg1, L_ndf);
        objArrArg[1] = lFcReplaceNull(arg2, L_ndf);
        objArrArg[2] = lFcReplaceNull(arg3, L_ndf);

    } else if(arg5==null) {

        objArrArg = array(4);

        objArrArg[0] = lFcReplaceNull(arg1, L_ndf);
        objArrArg[1] = lFcReplaceNull(arg2, L_ndf);
        objArrArg[2] = lFcReplaceNull(arg3, L_ndf);
        objArrArg[3] = lFcReplaceNull(arg4, L_ndf);

    } else {

        objArrArg = array(5);

        objArrArg[0] = lFcReplaceNull(arg1, L_ndf);
        objArrArg[1] = lFcReplaceNull(arg2, L_ndf);
        objArrArg[2] = lFcReplaceNull(arg3, L_ndf);
        objArrArg[3] = lFcReplaceNull(arg4, L_ndf);
        objArrArg[4] = lFcReplaceNull(arg5, L_ndf);
    }

    lFcAlertErrs(msg, objArrArg);
}


/*
 *  ޽ Alert Popup window open!
 *
 * param msg -  ޽
 * param saArg - ޽ Ե ڰ 迭
 *
 * return void
 */
function lFcAlertErrs(msg, saArg) {

    var sMsg;

    msg = iif(right(msg, 2)==L_sep, msg + " ", msg);

    var objArrMsg = split(msg, L_sep, false, true, false);
    var objArrArg;

    if(length(objArrMsg)<2) {

        sMsg = msg;

    } else {

        objArrArg = array(length(objArrMsg)-1);

        for(var i=0; i<length(objArrArg); i++) {

            objArrArg[i] = iif(lFcIsNull(saArg[i]), L_ndf, saArg[i]);
        }

        for(var i=0; i<length(objArrMsg); i++) {

            sMsg += objArrMsg[i];

            if(i+1==length(objArrMsg)) {

                break;
            }

            sMsg += objArrArg[i];
        }
    }

    var bRtn;

    if(indexOf(sMsg, L_alertMsgPrefix)==0) {

        sMsg = mid(sMsg, length(L_alertMsgPrefix));

        bRtn = Dialog("common::MsgAlert.xml", "msg="+quote(trim(sMsg)), 482, 156);

    } else if(sMsg==L_sessionTimeOut) {

        bRtn = Dialog("common::MsgAlert.xml", "msg="+quote(trim(L_COM_ALT_0028)), 482, 156);

        execProc("Miplatform311.exe", "IFIS"); // ٽ ȣ ִ κ

        exit();

    } else {

        bRtn = Dialog("common::MsgError.xml", "msg="+quote(trim(sMsg)), 400, 340);
    }

    return;
}



/*
 * Window ¹ٿ ޽ Ѵ.
 *
 * param msg -  ޽
 * param arg1 - ޽ Ե ڰ1
 * param arg2 - ޽ Ե ڰ2
 * param arg3 - ޽ Ե ڰ3
 * param arg4 - ޽ Ե ڰ4
 * param arg5 - ޽ Ե ڰ5
 *
 * return void
 */
//function lFcSetStatusBar(msg, arg1, arg2, arg3, arg4, arg5) {
function lFcSetMsgBar(msg, arg1, arg2, arg3, arg4, arg5) {

    var objArrArg;

    if(arg1==null) {

        objArrArg = array();

    } else if(arg2==null) {

        objArrArg = array(1);

        objArrArg[0] = lFcReplaceNull(arg1, L_ndf);

    } else if(arg3==null) {

        objArrArg = array(2);

        objArrArg[0] = lFcReplaceNull(arg1, L_ndf);
        objArrArg[1] = lFcReplaceNull(arg2, L_ndf);

    } else if(arg4==null) {

        objArrArg = array(3);

        objArrArg[0] = lFcReplaceNull(arg1, L_ndf);
        objArrArg[1] = lFcReplaceNull(arg2, L_ndf);
        objArrArg[2] = lFcReplaceNull(arg3, L_ndf);

    } else if(arg5==null) {

        objArrArg = array(4);

        objArrArg[0] = lFcReplaceNull(arg1, L_ndf);
        objArrArg[1] = lFcReplaceNull(arg2, L_ndf);
        objArrArg[2] = lFcReplaceNull(arg3, L_ndf);
        objArrArg[3] = lFcReplaceNull(arg4, L_ndf);

    } else {

        objArrArg = array(5);

        objArrArg[0] = lFcReplaceNull(arg1, L_ndf);
        objArrArg[1] = lFcReplaceNull(arg2, L_ndf);
        objArrArg[2] = lFcReplaceNull(arg3, L_ndf);
        objArrArg[3] = lFcReplaceNull(arg4, L_ndf);
        objArrArg[4] = lFcReplaceNull(arg5, L_ndf);
    }

    lFcSetMsgBars(msg, objArrArg);
}


/*
 * Window ¹ٿ ޽ Ѵ.
 *
 * param msg -  ޽
 * param saArg - ޽ Ե ڰ 迭
 *
 * return void
 */
function lFcSetMsgBars(msg, saArg) {

    var sMsg;

    msg = iif(right(msg, 2)==L_sep, msg + " ", msg);

    var objArrMsg = split(msg, L_sep, false, true, false);
    var objArrArg;

    if(length(objArrMsg)<2) {

        sMsg = msg;

    } else {

        objArrArg = array(length(objArrMsg)-1);

        for(var i=0; i<length(objArrArg); i++) {

            objArrArg[i] = iif(lFcIsNull(saArg[i]), L_ndf, saArg[i]);
        }

        for(var i=0; i<length(objArrMsg); i++) {

            sMsg += objArrMsg[i];

            if(i+1==length(objArrMsg)) {

                break;
            }

            sMsg += objArrArg[i];
        }
    }

	if(isValid(object("global.FrameBottom"))) {

        global.FrameBottom.fcSetMsgBar(sMsg);

	} else {

        alert(sMsg);
	}

	return;
}

/*
 * ڿ ڷ иϿ 迭  ش.
 *
 * param arg - ڷ и ڿ
 * param separator -  ڿ
 *
 * return objArrArg - ڿ 迭
 */
function lFcToArray(arg, separator) {

    var sSep = ",";

    if(lFcIsNotNull(separator)) {

        sSep = separator;
    }

    var objArrArg = split(arg, separator);

    for(var i=0; i<length(objArrArg); i++) {

        objArrArg[i] = trim(objArrArg[i]);
    }

    return objArrArg;
}




/**
 * Open CodeHelp Popup
 *
 * param codeHelpId - ڵ ID
 * param searchWord - ˻ : Nullable
 * param multiSelFlag - ߼  'Y'/'N' : Nullable
 * param searchCondYn - ˻ Enable/Disable 'Y'/'N' : Nullable
 * param combIdx - ȸ  Index : Nullable
 * param searchYn -  ε  ڵ  ȸ  'Y'/'N' : Nullable
 *
 * return bRtn - true/false
 */
function lFcOpenCodeHelp(codeHelpId, searchWord, multiSelFlag, searchCondYn, combIdx, searchYn) {

    var sArg = "";

    if(codeHelpId==null || lFcIsNull(codeHelpId)) {

        //lFcAlert(L_COM_ALT_0004, "ڵ ID");
        lFcSetMsgBar(L_COM_ALT_0004, "ڵ ID");
        return;
    }

    sArg += "codeHelpId=" + quote(trim(codeHelpId));

    if(lFcIsNotNull(searchWord)) {

        sArg += " searchWord=" + quote(trim(searchWord));
    }

    if(lFcIsNotNull(multiSelFlag)) {

        sArg += " multiSelFlag=" + quote(trim(multiSelFlag));
    }

    if(lFcIsNotNull(searchCondYn)) {

        sArg += " searchCondYn=" + quote(trim(searchCondYn));
    }

    if(lFcIsNotNull(combIdx)) {

        sArg += " combIdx=" + quote(trim(combIdx));
    }

    if(lFcIsNotNull(searchYn)) {

        sArg += " searchYn=" + quote(trim(searchYn));
    }


    var bRtn = Dialog("common::PopCodeHelp.xml", sArg, 492, 494);

    return bRtn;
}




function _lFcReplaceMsg(msg) {

    var sRtn = replace(msg, "<", "&lt;");

    sRtn = replace(sRtn, ">", "&gt;");
    sRtn = replace(sRtn, "|", "!");

    return sRtn;
}


/*
 * 迭     Ȯ
 *
 * param arrParam - 迭 ü
 * param valParam - 
 *
 * return true/false
 */
function lFcInArray(arrParam, valParam) {

    var bRtn = false;

    for(var i=0; i<length(arrParam); i++) {

        if(arrParam[i]==valParam) {

            bRtn = true;
            break;
        }
    }
    return bRtn;
}


/**
 * 迭     Ȯ
 *
 * param arrParam - 迭 ü
 * param valParam - 
 *
 * return true/false
 */
function lFcNotInArray(arrParam, valParam) {

    var bRtn = true;

    for(var i=0; i<length(arrParam); i++) {

        if(arrParam[i]==valParam) {

            bRtn = false;
            break;
        }
    }
    return bRtn;
}



/**
 * Form ü Null üũ  Ʈ  ȯϴ.
 *
 * @param objForm - Form Object
 * @param arrChkStr - üũ ڿ 迭
 * @param bLike - üũ ڿ Like   
 *
 * @return arrComp - Null üũ  Ʈ 迭
 */
function _lFcGetTargetComp(objForm, chkStr, bLike) {

	var arrComp;

    var arrValidComp = ["Edit", "MaskEdit", "Spin", "Combo", "Radio", "TextArea", "Calendar", "Div", "Tab"];
    var arrValidComp2 = ["Edit", "MaskEdit", "Spin", "Combo", "Radio", "TextArea", "Calendar"];

	if(length(objForm.Components)<1) {

		return null;
	}

	if(isValid(object("_ds_comp"))) {

        _ds_comp.ClearData();

	} else {

		create("Dataset", "_ds_comp");

		_ds_comp.AddColumn("COMP_ID", "STRING", 50);
		_ds_comp.AddColumn("COMP_IDX", "INT", 3);
		_ds_comp.AddColumn("COMP_TAB_ORDER", "INT", 3);
	}

	var objComp;
	var sCompType;
	var nRnum;

	for(var i=0; i<length(objForm.Components); i++) {

        objComp = objForm.Components[i];
        sCompType = objComp.GetType();

        if(lFcInArray(arrValidComp, sCompType)) {

            if(lFcInArray(arrValidComp2, sCompType)) {

                if(!_lFcIsTargetComp(objComp, chkStr, bLike)) {

                    continue;
                }
            } else if(sCompType=="Div") { // Div, Tab

                if(objComp.GetFirstComponent()==null) {

                    continue;
                }
            } else if(sCompType=="Tab") {

                if(objComp.TabCount<1) {

                    continue;
                }
            }

            nRnum = _ds_comp.AppendRow();

            _ds_comp.SetColumn(nRnum, "COMP_ID", objComp.ID);
            _ds_comp.SetColumn(nRnum, "COMP_IDX", i);
            _ds_comp.SetColumn(nRnum, "COMP_TAB_ORDER", objComp.TabOrder);
        }
	}

	if(_ds_comp.RowCount()>0) {

        _ds_comp.Sort("COMP_TAB_ORDER", true, true);

        arrComp = array(_ds_comp.RowCount());

        var nCompIdx;

        for(var i=0; i<_ds_comp.RowCount(); i++) {

            nCompIdx = _ds_comp.GetColumn(i, "COMP_IDX");

            arrComp[i] = objForm.Components[nCompIdx];
        }
	}

	return arrComp;
}


/**
 * Ư Ʈ Null üũ  θ ȯϴ.
 *
 * @param objForm - Form Object
 * @param arrChkStr - üũ ڿ 迭
 * @param bLike - üũ ڿ Like  
 *
 * @return bRtn - true/false
 */
function _lFcIsTargetComp(comp, chkStr, bLike) {

    var bRtn = false;

    var arrVal = split(comp.UserData, "|");

    if(bLike) {

        if(indexOf(arrVal[0], chkStr)!=-1) {

            bRtn = true;
        }
    } else {

        if(arrVal[0]==chkStr) {

            bRtn = true;
        }
    }

    return bRtn;
}


/**
 * Form ü  Component.UserData ("chkStr|Ʈ") ȸϿ
 * ʼ Է ׸ NULL θ ȮѴ.
 *
 * param objForm - Form Object
 * param arrChkStr - üũ ڿ 迭
 *
 * return true/false
 */
function lFcIsValidComps(objForm, arrChkStr) {

    var bRtn = true;

    if(objForm==null) {

        objForm = this;
    }

    if(arrChkStr==null || length(arrChkStr)<1) {

        return bRtn;
    }

    for(var i=0; i<length(arrChkStr); i++) {

        if(!lFcIsValidComp(objForm, arrChkStr[i], false)) {

            bRtn = false;

            break;
        }
    }

    return bRtn;
}


/**
 * Form ü  Component.UserData ("chkStr|Ʈ") ȸϿ
 * ʼ Է ׸ NULL θ ȮѴ.
 *
 *  : lFcForm_OnTimer(obj, nEventID) Լ Ѵ.
 *  Լ ϴ Form OnTimer ̺Ʈ
 * 'lFcForm_OnTimer'  ش.    ȿ lFcForm_OnTimer Լ δ Ѵ.
 *
 * param objForm - Form Object (NULLABLE)
 * param chkStr - üũ ڿ
 * param bLike - üũ ڿ Like   true/false
 *
 * return true/false
 */
function lFcIsValidComp(objForm, chkStr, bLike) {

    var bRtn = true;

    if(objForm==null) {

        objForm = this;
    }

    //trace("[RUGA] Null check form : " + objForm.ID + " in lFcIsValidComp()");

    if(chkStr==null || lFcIsNull(chkStr)) {

        chkStr = L_notNull;
    }

    if(bLike==null) {

        bLike = false;
    }

    if(objForm.GetType()=="Tab") {

        if(!_lFcIsValidCompOnTab(objForm, chkStr, bLike)) {

            return false;
        }
    } else if(objForm.GetType()=="Div") {

        if(!_lFcIsValidCompOnDiv(objForm, chkStr)) {

            return false;
        }
    }

    var arrComp = _lFcGetTargetComp(objForm, chkStr, bLike);

    //trace(arrComp);

    var sCompType;

    for(var i=0; i<length(arrComp); i++) {

        sCompType = arrComp[i].GetType();

        if(sCompType=="Tab") {

            if(!_lFcIsValidCompOnTab(arrComp[i], chkStr, bLike)) {

                bRtn = false;
                break;
            }
        } else if(sCompType=="Div") {

            if(!_lFcIsValidCompOnDiv(arrComp[i], chkStr, bLike)) {

                bRtn = false;
                break;
            }
        } else {

            if(lFcIsNullComp(arrComp[i], chkStr, bLike)) {

                bRtn = false;
                break;
            }
        }
    }

    return bRtn;
}


/**
 * Tab component   Component.UserData  ȸϿ
 * ʼ Է ׸ NULL θ ȮѴ.
 *
 * param objTab - Tab component
 * param chkStr - üũ ڿ
 * param bLike - üũ ڿ Like   : true/false
 *
 * return true/false
 */
function _lFcIsValidCompOnTab(objTab, chkStr, bLike) {

    var bRtn = true;

    //trace("[RUGA] Null check form : " + objTab.ID + " in _lFcIsValidCompOnTab()");

	if(objTab.TabCount<1) {

        return bRtn;
    }

	var objTabPage;
    var arrComp;

	for(var i=0; i<objTab.TabCount; i++) {

        objTabPage =objTab.GetItem(i);

        arrComp = _lFcGetTargetComp(objTabPage, chkStr, bLike);

        var sCompType;

        for(var j=0; j<length(arrComp); j++) {

            sCompType = arrComp[j].GetType();

            if(sCompType=="Tab") {

                if(!_lFcIsValidCompOnTab(arrComp[j], chkStr, bLike)) {

                    bRtn = false;
                    break;
                }
            } else if(sCompType=="Div") {

                if(!_lFcIsValidCompOnDiv(arrComp[j], chkStr, bLike)) {

                    bRtn = false;
                    break;
                }
            } else {

                if(lFcIsNullComp(arrComp[j], chkStr, bLike)) {

                    bRtn = false;
                    break;
                }
            }
        }

        if(!bRtn) {

            break;
        }
    }

    return bRtn;
}


/**
 * Div component   Component.UserData  ȸϿ
 * ʼ Է ׸ NULL θ ȮѴ.
 *
 * param objDiv - Div component
 * param chkStr - üũ ڿ
 * param bLike - üũ ڿ Like   : true/false
 *
 * return true/false
 */
function _lFcIsValidCompOnDiv(objDiv, chkStr, bLike) {

    var bRtn = true;

    //trace("[RUGA] Null check form : " + objDiv.ID + " in lFcIsValidCompOnDiv()");

    if(objDiv.GetFirstComponent()==null) {

        return bRtn;
    }

    var arrComp = _lFcGetTargetComp(objDiv, chkStr, bLike);

    var sCompType;

    for(var i=0; i<length(arrComp); i++) {

        sCompType = arrComp[i].GetType();

        if(sCompType=="Tab") {

            if(!_lFcIsValidCompOnTab(arrComp[i], chkStr, bLike)) {

                bRtn = false;
                break;
            }

        } else if(sCompType=="Div") {

            if(!_lFcIsValidCompOnDiv(arrComp[i], chkStr, bLike)) {
            
                bRtn = false;
                break;
            }
        } else {

            if(lFcIsNullComp(arrComp[i], chkStr, bLike)) {

                bRtn = false;
                break;
            }
        }
    }

    return bRtn;
}


/**
 * Ư Component ʼԷ   Էµ  NULL θ ش.
 *
 * param comp - component
 * param chkStr - üũ ڿ
 * param bLike - üũ ڿ Like   : true/false
 *
 * return true/false
 */
function lFcIsNullComp(comp, chkStr, bLike) {

    var bRtn = false;
    
    if(chkStr==null) {
    
		chkStr = L_notNull;
    }

    if(!comp.Enable) {

        return bRtn;
    }

    var arrUserData = split(comp.UserData, "|");

    if(bLike) {

        if(indexOf(arrUserData[0], chkStr)==-1) {

            return bRtn;
        }
    } else {

        if(arrUserData[0]!=chkStr) {

            return bRtn;
        }
    }

    var sCompType = comp.GetType();

    if(sCompType=="MaskEdit") {

        if(toUpper(comp.Type)="NUMBER" && comp.Value==0) {

            bRtn = true;

        } else if(lFcIsNull(comp.Value)) {

            bRtn = true;
        }
    } else {

        if(lFcIsNull(comp.Value)) {

            bRtn = true;
        }
    }

    if(bRtn) {

        lFcSetInvalidComp(comp);
    }

    return bRtn;
}


/**
 * 1.Component Focusing
 * 2.Not Null Message
 * 3.Component (Border  )
 *
 * param comp - Component ü
 *
 * return void
 */
function lFcSetInvalidComp(comp) {

    var arrUserData = split(comp.UserData, "|");

    var sComment = iif(lFcIsNull(arrUserData[1])==true, "(Ŀ׸)", "(" + arrUserData[1] + ")");

    lFcSetFocusToComp(comp);

    lFcAlert(L_COM_ALT_0008, sComment);

    L_invalidComp = comp;

	this.SetTimer(L_timerEventId_10, 230); // Form OnTimer ̺Ʈ ߻Ų.

	return null;
}


/**
 * Component Focusing
 *
 * param comp - Component ü
 *
 * return void
 */
function lFcSetFocusToComp(comp) {

    var objForm = comp.GetForm();
    var sFormType;

    while(toUpper(objForm.GetType())!="FORM") {

        sFormType = objForm.GetType();

        if(toUpper(sFormType)=="TABPAGE") {

            objForm.GetForm().TabIndex = lFcGetTabPageIdx(objForm);
        }

        objForm = objForm.GetForm();
    }

    comp.SetFocus();

    return null;
}


/**
 * TabPage ü TabIndex Ѵ.
 *
 * param objTabPage - TabPage ü
 *
 * return nRtn - TabIndex
 */
function lFcGetTabPageIdx(objTabPage) {

    var nRtn = -1;

    var objTab = objTabPage.GetForm();
    var sTabPageId = objTabPage.ID;

    for(var i=0; i<objTab.TabCount; i++) {

        if(objTab.GetItem(i).ID==sTabPageId) {

            nRtn = i;

            break;
        }
    }

    return nRtn;
}


/*
 * Form OnTimer ̺Ʈ ȣ Լ
 * ȿ  Component  Ƚ(5) ǥѴ.
 *
 * param obj - OnTimer ̺Ʈ ߻ ü
 * param nEventID - ̺Ʈ ID
 *
 * return void
 */
function lFcForm_OnTimer(obj, nEventID)
{
    if(nEventID==L_timerEventId_10) {

        _lFcSetCompBorder(L_invalidComp);

        _lFcKillTimer(nEventID);

    } else if(nEventID==L_timerEventId_11) {

        _lFcKillTimer(nEventId);
    }
}


/**
 * Form OnTimer ̺Ʈ ߻  ȣǴ Լ.
 * L_validTimerCnt   comp Ʈ Border  Ѵ.
 *
 * param comp - Component ü
 *
 * return void
 */
function _lFcSetCompBorder(comp) {

    if(!isValid(comp)) {

        trace("ȿ  ü " + comp);

        return null;
    }

    if(L_validTimerCnt%2==0) {

        if(toUpper(comp.Border)=="SUNKEN") {

            comp.Face3dColor = "#ea516b";
            comp.ShadowColor = "#ea516b";

        } else {

            comp.BorderColor = "#ea516b";
        }
    } else {

        if(toUpper(comp.Border)=="SUNKEN") {

            comp.Face3dColor = ""; // default
            comp.ShadowColor = ""; // default

        } else {

            comp.BorderColor = ""; // default
        }
    }

    L_validTimerCnt++;

    return null;
}


/**
 * Form OnTimer ̺Ʈ .
 *
 * param nEventID - ̺Ʈ ID
 *
 * return void
 */
function _lFcKillTimer(nEventId) {

    if(nEventID==L_timerEventId_10) {

        if(L_validTimerCnt>9) {

            this.KillTimer(nEventId);

            L_validTimerCnt = 0;
            L_invalidComp = null;
        }
    } else if(nEventID==L_timerEventId_11) {

        this.KillTimer(nEventId);

        lFcOpenExcelExport(sDynamicGrdId, nDynamicStartCell, bDynamicGrdId);
    }
}







/**
 * Ʈ ̸ ˾ 
 *
 * param rptFile - Ʈ (ID)
 * param dsParamDsId - Dataset Ķ  Dataset ID
 * param dsParamId - Ķ  Dataset ID
 *
 * return void
 */
function lFcReportPreView(rptFile, dsParamDsId, paramDsId) {

    var nWidth = 884;
    var nHeight = 700;

    var nPosX = (getDeviceInfo("CXScreen")-nWidth)/2;
    var nPosY = (getDeviceInfo("CYScreen")-nHeight-30)/3;
    var nPosY = 10;

    if(rptFile==null || lFcIsNull(rptFile)) {

        lFcAlert(L_COM_ALT_0004, "rptFile");

        return;
    }

    var sArg = "sRptFile=" + quote(rptFile);

    if(lFcIsNotNull(dsParamDsId)) {

        sArg += " sDsParamDsId=" + quote(dsParamDsId);
    }

    if(lFcIsNotNull(paramDsId)) {

        sArg += " sParamDsId=" + quote(paramDsId);
    }

    //var bRtn = Open("Common::PopReportPreView.xml", sArg, nWidth, nHeight, "", nPosX, nPosY);
    var bRtn = Dialog("Common::PopReportPreView.xml", sArg, nWidth, nHeight, "", nPosX, nPosY);

    return null;
}


/**
 * ׸ Ʈ Null  üũ
 *
 * param objGrid - ׸ obj
 * param sColId1 - üũ Dataset 'Column ID|Column' 1st
 * param sColId2 - üũ Dataset 'Column ID|Column' 2nd
 * param sColId3 - üũ Dataset 'Column ID|Column' 3rd
 * param sColId4 - üũ Dataset 'Column ID|Column' 4th
 * param sColId5 - üũ Dataset 'Column ID|Column' 5th
 *
 * return true/false
 */
function lFcIsValidGrid(objGrid, sColId1, sColId2, sColId3, sColId4, sColId5) {

    var sArrCellInfo;

    if(!isValid(objGrid)) {

        trace("ȿ  Grid " + objGrid + " in lFcIsValidGrid()");
        return false;
    }

    if(sColId1==null) {

        return;

    } else if(sColId2==null) {

        sArrCellInfo = array(1);

        sArrCellInfo[0] = sColId1;

    } else if(sColId3==null) {

        sArrCellInfo = array(2);

        sArrCellInfo[0] = sColId1;
        sArrCellInfo[1] = sColId2;

    } else if(sColId4==null) {

        sArrCellInfo = array(3);

        sArrCellInfo[0] = sColId1;
        sArrCellInfo[1] = sColId2;
        sArrCellInfo[2] = sColId3;

    } else if(sColId5==null) {

        sArrCellInfo = array(4);

        sArrCellInfo[0] = sColId1;
        sArrCellInfo[1] = sColId2;
        sArrCellInfo[2] = sColId3;
        sArrCellInfo[3] = sColId4;

    } else {

        sArrCellInfo = array(5);

        sArrCellInfo[0] = sColId1;
        sArrCellInfo[1] = sColId2;
        sArrCellInfo[2] = sColId3;
        sArrCellInfo[3] = sColId4;
        sArrCellInfo[4] = sColId5;
    }

    return lFcIsValidGrids(objGrid, sArrCellInfo);
}


/*
 * ׸ Ʈ Null  üũ
 *
 * param objGrid - ׸ obj
 * param sArrCell - ˻ Cell Index 迭
 *
 * return true/false
 */
function lFcIsValidGrids(objGrid, sArrCell) {

    var bRtn = true;

    var objDs = object(objGrid.BindDataset);

    if(!isValid(objDs)) {

        trace("ȿ  Dataset " + objGrid.BindDataset + " in lFcIsValidGrids()");
        return false;
    }

    var sArrCol = array(2);
    var sColId;
    var sColNm;
    var nCellIdx;

    var sColType;
    var value;

    for(var i=0; i<length(sArrCell); i++) {

		sArrCol = split(sArrCell[i], "|");

        sColId = sArrCol[0];
        sColNm = iif(lFcIsNull(sArrCol[1]), "Not defined", sArrCol[1]);

        for(var j=0; j<objDs.RowCount(); j++) {

			sColType = objDs.GetColType(sColId);
			value = objDs.GetColumn(j, sColId);

            if(lFcIsNull(value) || ((sColType=="LONG" || sColType=="INT" || sColType=="DECIMAL") && value==0))
            {
                nCellIdx = _getCellIdx(objGrid, sColId);

                //_setTabPage(sGridId);
				//objGrid.SetFocus();

                lFcAlert(L_COM_ALT_0012, "[" + sColNm + "]");

				lFcSetFocusToComp(objGrid);

				objDs.row = j;

				objGrid.SetCellPos(nCellIdx);

				//trace("Null ColId : " + sColId + "    cellIdx : " + nCellIdx);

				return false;
            }
        }
    }
    return bRtn;
}


/**
 * ׸ Sub Property ColId  Ͽ
 * ġϴ Cell index  Ѱش.
 *
 * param objGrid - ׸ obj
 * param sColId - ã ColId
 *
 * return nRtn - Cell Index
 */
function _getCellIdx(objGrid, sColId) {
 
	var nRtn = -1;

    for(var i=0; i<objGrid.GetCellCount("body"); i++) {

        if(objGrid.GetCellProp("body", i, "ColId")==sColId) {

            nRtn = i;
            break;
        }
    }

	return nRtn;
}


/*
 * Ʈ ID мϿ Tab ȿ ϴ Ʈ 
 * Ʈ ϴ Tab Page  Ŀ ̵Ѵ.
 *
 * param sObjId - Ʈ ID
 *
 * return void

function _setTabPage(sObjId) {

    var arrObjId = split(sObjId, ".");

    var nLen = length(arrObjId);

    if(nLen!=3) {

        return;
    }

    var sTabId = arrObjId[nLen-3];
    var sTabPageId = arrObjId[nLen-2];

    var objTab = object(sTabId);
	var nTabIdx = -1;

    if(!isValid(objTab) || objTab.GetType()!="Tab") {

        trace("ȿ  Tab " + sTabId);

        return;
    }

    var nTabPageCnt = objTab.TabCount;

    var objTabPage;

    for(var i=0; i<nTabPageCnt; i++) {

        objTabPage = objTab.GetItem(i);

        //trace("objTabPage.ID + sTabPageId : " + objTabPage.ID + " || " + sTabPageId);

        if(objTabPage.ID==sTabPageId) {

            objTab.TabIndex = i;
            break;
        }
    }
	return;
}
*/


/*
 * Modeless popup window open
 *  Լ óǴ ŸƲ   ޴   ѱ .
 *
 * param sMenuId - ޴ ID
 * param sUrl - ˾â  ȭ URL
 * param sInArgument - ˾ ѱ  ڿ
 * param nWidth - ˾â  
 * param nHeight - ˾â  
 * param sOpenStyle - ˾â  Ÿ
 * param nLeft - ˾â ´ ġ(ȼ)
 * param nTop - ˾â  ġ(ȼ)
 *
 * return vRtn - ˾â  Ѱ 
 */
function lFcOpen(sMenuId, sUrl, sInArgument, nWidth, nHeight, sOpenStyle, nLeft, nTop) {

    var vRtn;
    var sExcStr = "open(sUrl,sInArgument";

    if(sMenuId==null) {

        lFcAlert(L_COM_ALT_0004, "sMenuId");
        return;
    }

    if(sUrl==null) {

        lFcAlert(L_COM_ALT_0004, "sUrl");
        return;
    }

    if(nWidth!=null) { sExcStr += ",nWidth"; }

    if(nHeight!=null) { sExcStr += ",nHeight"; }

    if(sOpenStyle!=null) { sExcStr += ",sOpenStyle"; }

    if(nLeft!=null) { sExcStr += ",nLeft"; }

    if(nTop!=null) { sExcStr += ",nTop"; }

    sExcStr += ")";

    http.Sync = true;

    lFcTransaction(
        "Lib_lFcOpen",     				            // Transaction ID
        "svcomm::CommonAction.do?mode=getMenuInfo",	// service
        "",                                         // input Dataset
        "",                                         // output Dataset
        "menuId="+quote(sMenuId),                   // parameter
        ""                                          // callback
    );

    vRtn = eval(sExcStr);

    http.Sync = false;

    return vRtn;
}


/*
 * Popup window open
 *  Լ óǴ ŸƲ   ޴   ѱ .
 *
 * param sMenuId - ޴ ID
 * param sUrl - ˾â  ȭ URL
 * param sInArgument - ˾ ѱ  ڿ
 * param nWidth - ˾â  
 * param nHeight - ˾â  
 * param sOpenStyle - ˾â  Ÿ
 * param nLeft - ˾â ´ ġ(ȼ)
 * param nTop - ˾â  ġ(ȼ)
 *
 * return vRtn - ˾â  Ѱ 
 */
function lFcDialog(sMenuId, sUrl, sInArgument, nWidth, nHeight, sOpenStyle, nLeft, nTop) {

    var vRtn;
    var sExcStr = "dialog(sUrl,sInArgument";

    if(sMenuId==null) {

        lFcAlert(L_COM_ALT_0004, "sMenuId");
        return;
    }

    if(sUrl==null) {

        lFcAlert(L_COM_ALT_0004, "sUrl");
        return;
    }

    if(nWidth!=null) { sExcStr += ",nWidth"; }

    if(nHeight!=null) { sExcStr += ",nHeight"; }

    if(sOpenStyle!=null) { sExcStr += ",sOpenStyle"; }

    if(nLeft!=null) { sExcStr += ",nLeft"; }

    if(nTop!=null) { sExcStr += ",nTop"; }

    sExcStr += ")";

    http.Sync = true;

    lFcTransaction(
        "Lib_lFcOpen",     				            // Transaction ID
        "svcomm::CommonAction.do?mode=getMenuInfo",	// service
        "",                                         // input Dataset
        "",                                         // output Dataset
        "menuId="+quote(sMenuId),                   // parameter
        ""                                          // callback
    );

    vRtn = eval(sExcStr);

    http.Sync = false;

    return vRtn;
}



/*
 * 콺 Ŀ ۾ · Ѵ.
 *
 * param bFlag - true/false ۾(𷡽ð)/۾Ϸ(ȭǥ)
 *
 * return void
 */
function lFcSetWaitCursor(bFlag) {

    if(bFlag==null) {

        bFlag = false;
    }

    if(bFlag) {

        SetWaitCursor(true);
        SetCapture();

    } else {

        ReleaseCapture();
        SetWaitCursor(false);
    }
}


var L_GrdBindDs = ""; // Grid.BindDataset ü
var L_GrdBindDsRow; // Grid.BindDataset ü 
var L_GrdBindDsColId; // Grid.BindDataset ü 

var L_RtnVal = ""; // Return Value
var L_RtnFlag; // Return Falg

var L_codeColumn;


/*
 * PopupDiv List 
 *
 * param objGrid - ׸ ü
 * param nRow - ׸ row index
 * param nCell - ׸ cell index
 * param innerDs - Inner Dataset
 * param codeCol - Inner Dataset Code Column
 * param dataCol - Inner Dataset Data Column
 * param xLen - List Width
 * param yLen - List Height
 * param chkFlg - return Flag : true/false,  ѱ / Dataset  Ҵ
 *
 * return L_RtnVal
 */
function lFcSetPivList(objGrid, nRow, nCell, innerDs, codeCol, dataCol, initVal, len, chkFlg) {

    L_RtnVal = "";

	L_GrdBindDs = object(objGrid.BindDataset);

	L_GrdBindDsRow = nRow;
	L_GrdBindDsColId = objGrid.GetCellProp("Body", nCell, "ColId");
	
	L_codeColumn = codeCol;

	//var sInitVal = L_GrdBindDs.GetColumn(L_GrdBindDsRow, L_GrdBindDsColId);
	var sInitVal = initVal;

	var xLen = iif(len==null, 120, len);
	var yLen = iif(innerDs.RowCount()>20, 20*16+2, innerDs.RowCount()*16+2);

	if(innerDs.RowCount()>10) xLen += 20; // ũѹ Size add!

	if(chkFlg) {

        L_RtnFlag = true;
        L_RtnVal = sInitVal;

	} else {

        L_RtnFlag = false;
    }

	var arrCoordie =  objGrid.GetCellRect(nRow, nCell);

	var nCellW = arrCoordie[2] - arrCoordie[0];
	var nCellH = arrCoordie[3] - arrCoordie[1];
	var nDivX = ClientToScreenX(objGrid, arrCoordie[0])+(nCellW-xLen);
	var nDivY = ClientToScreenY(objGrid, arrCoordie[1]);

	if(Find("_piv_list")==null) {

		Create("PopupDiv", "_piv_list", "Width='" + xLen + "' Height='" + yLen + "'");

	} else {

		_piv_list.Width = xLen;
		_piv_list.Height = yLen;
	}

	_piv_list.Contents = _lFcSetPivGridContent(innerDs, codeCol, dataCol, xLen, yLen, sInitVal);
	//_piv_list.Contents = _lFcSetPivListContent(innerDs, codeCol, dataCol, xLen, yLen, sInitVal);

	innerDs.row = innerDs.FindRow("KJNGUN", initVal);

	//_piv_list.TrackPopup(nDivX, nDivY);
	_piv_list.TrackPopup(nDivX, nDivY, nCellW, nCellH);

	return L_RtnVal;
}


/**
 * List Component Content  Ͽ ش.
 *
 * param innerDs - InnerDataset
 * param codeCol - CodeColumn
 * param dataCol - DataColumn
 * param xLen - List.Width
 * param yLen - List.Height
 * param initVal - ʱⰪ
 *
 * return sRtn
 */
function _lFcSetPivListContent(innerDs, codeCol, dataCol, xLen, yLen, initVal) {

	var sRtn = "";

	sRtn += '<Contents>' + chr(10);
	sRtn += '<List Border="Flat" CodeColumn="' + codeCol + '" DataColumn="' + dataCol + '" ' + chr(10);
	sRtn += 'Height="' + yLen + '" Id="list0" InnerDataset="' + innerDs.ID + '" Left="0" ' + chr(10);
	sRtn += 'OnClick="_lFcListOnClick" TabOrder="0" Top="0" Value="' + initVal + '" Width="' + xLen + '">' + chr(10);
	sRtn += '</List>' + chr(10);
	sRtn += '</Contents>';

	return sRtn;
}


/**
 * List Component OnClick ̺Ʈ ó Լ
 *
 * param obj - List Component ü
 *
 * return void
 */
function _lFcListOnClick(obj) {

	if(L_RtnFlag) {

		trace("Click Value : " + obj.Value);

        L_RtnVal = obj.Value;

    } else {

        L_GrdBindDs.SetColumn(L_GrdBindDsRow, L_GrdBindDsColId, obj.Value);
    }

	_piv_list.ClosePopup();
}


/**
 * Grid Component Content  Ͽ ش.
 *
 * param innerDs - InnerDataset
 * param codeCol - CodeColumn
 * param dataCol - DataColumn
 * param xLen - List.Width
 * param yLen - List.Height
 * param initVal - ʱⰪ
 *
 * return sRtn
 */
function _lFcSetPivGridContent(innerDs, codeCol, dataCol, xLen, yLen, initVal) {

	var sRtn = "";

	sRtn += '<Contents>' + chr(10);
	sRtn += '<Grid ' + chr(10);
	sRtn += 'AutoFit="TRUE" AutoFitEndLine="Hide" BindDataset="' + innerDs.ID + '" ' + chr(10);
	sRtn += 'BkColor2="default" BoldHead="true" Border="Flat" ' + chr(10);
	sRtn += 'Bottom="" Enable="true" EndLineColor="default" ' + chr(10);
	sRtn += 'Height="' + yLen + '" Id="Grid0" InputPanel="FALSE" ' + chr(10);
	sRtn += 'Left="0" LineColor="default" LineType="NONE" ' + chr(10);
	sRtn += 'MinWidth="100" OnCellClick="_grd_OnCellClick" Right="" RowHeight="16" ' + chr(10);
	sRtn += 'TabOrder="16" TabStop="true" Top="0" ' + chr(10);
	sRtn += 'UseDBuff="true" UsePopupMenu="true" UseSelColor="true" ' + chr(10);
	sRtn += 'Visible="true" VLineColor="default" WheelScrollRow="1" ' + chr(10);
	sRtn += 'Width="' + xLen + '">' + chr(10);
	sRtn += '<contents>' + chr(10);
	sRtn += '<format id="Default">' + chr(10);
	sRtn += '<columns>' + chr(10);
	sRtn += '<col width="100"/>' + chr(10);
	sRtn += '</columns>' + chr(10);
	sRtn += '<body>' + chr(10);
	sRtn += '<cell col="0" colid="' + dataCol + '" display="text" limit="-1"/>' + chr(10);
	sRtn += '</body>' + chr(10);
	sRtn += '</format>' + chr(10);
	sRtn += '</contents>' + chr(10);
	sRtn += '</Grid>' + chr(10);
	sRtn += '</Contents>';

	return sRtn;
}



function _grd_OnCellClick(obj,nRow,nCell,nX,nY,nPivotIndex)
{
	var objDs = object(obj.BindDataset);
	
	var sRtn = objDs.GetColumn(nRow, L_codeColumn);

	if(L_RtnFlag) {

		//trace("Click Value : " + sRtn);

        L_RtnVal = sRtn;

    } else {

        L_GrdBindDs.SetColumn(L_GrdBindDsRow, L_GrdBindDsColId, sRtn);
    }

	_piv_list.ClosePopup();
}






/*
 * PopupDiv Calendar 
 *
 * param objGrid - ׸ ü
 * param nRow - ׸ row index
 * param nCell - ׸ cell index
 * param chkFlg - return Flag : true/false,  ѱ / Dataset  Ҵ
 *
 * return L_RtnVal
 */
function lFcSetPopupDivCalendar(objGrid, nRow, nCell, chkFlg) {

    L_RtnVal = "";

	L_GrdBindDs = object(objGrid.BindDataset);

	L_GrdBindDsRow = nRow;
	L_GrdBindDsColId = objGrid.GetCellProp("Body", nCell, "ColId");

	var sInitVal = L_GrdBindDs.GetColumn(L_GrdBindDsRow, L_GrdBindDsColId);

	if(chkFlg) {

        L_RtnFlag = true;
        L_RtnVal = sInitVal;

	} else {

        L_RtnFlag = false;
    }

	var arr_val =  objGrid.GetCellRect(nRow,nCell);
	var div_x = ClientToScreenX(objGrid, arr_val[0]);
	var div_y = ClientToScreenY(objGrid, arr_val[1]);
	var div_w = arr_val[2] - arr_val[0];
	var div_h = arr_val[3] - arr_val[1];

	if(Find("PopDiv_Calendar")==null) {

		Create("PopupDiv", "PopDiv_Calendar", "width='152' height='133'");
	}

	PopDiv_Calendar.Contents = _lFcSetPopDivCalContent(sInitVal);

	PopDiv_Calendar.TrackPopup(div_x, div_y, div_w, div_h);

	return L_RtnVal;
}


/*
 * Calendar Component Content  Ͽ ش.
 *
 * param initVal - ʱ 
 *
 * return sRtn
 */
function _lFcSetPopDivCalContent(initVal) {

	var sRtn = "";

	sRtn += '<Contents>' + chr(10);
	sRtn += '<Calendar Border="Flat" ClickedBkColor="#394c5a" ClickedTextColor="white" ' + chr(10);
	sRtn += 'UseTrailingDay="FALSE" LeftMargin="2" Height="152" Id="CAL_PopupDiv" ' + chr(10);
	sRtn += 'Value="' + initVal + '"Left="0" LeftMargin="2" NullValue="&#32;" RightMargin="2" MonthOnly="TRUE" ' + chr(10);
	sRtn += 'OnDayClick="_lFcCalendarOnDayClick" SaturdayTextColor="blue" Style="cal_style1" SundayTextColor="red" ' + chr(10);
	sRtn += 'TextColorColumn="TEXTCOLOR" Top="0" Width="152"></Calendar>' + chr(10);
	sRtn += '</Contents>';

	return sRtn;
}


/*
 * Calendar Component OnDayClick ̺Ʈ ó Լ
 *
 * param obj - Calendar Component ü
 * param strText -  ¥  : YYYYMMDD
 *
 * return void
 */
function _lFcCalendarOnDayClick(obj, strText) {

	if(L_RtnFlag) {

        L_RtnVal = strText;

    } else {

        L_GrdBindDs.SetColumn(L_GrdBindDsRow, L_GrdBindDsColId, strText);
    }

	PopDiv_Calendar.ClosePopup();
}


/*
 * PopupDiv TextArea 
 *
 * param objGrid - ׸ ü
 * param nRow - ׸ row index
 * param nCell - ׸ cell index
 * param chkFlg - return Flag : true/false,  ѱ / Dataset  Ҵ
 *
 * return L_RtnVal
 */
function lFcSetPopupDivTextArea(objGrid, nRow, nCell, chkFlg){

    L_RtnVal = "";

	L_GrdBindDs = object(objGrid.BindDataset);

	L_GrdBindDsRow = nRow;
	L_GrdBindDsColId = objGrid.GetCellProp("Body",nCell, "ColId");

	var sInitVal = L_GrdBindDs.GetColumn(L_GrdBindDsRow, L_GrdBindDsColId);

	if(chkFlg) {

        L_RtnFlag = true;
        L_RtnVal = sInitVal;

	} else {

        L_RtnFlag = false;
	}

	var arr_val =  objGrid.GetCellRect(nRow, nCell);
	var div_x = ClientToScreenX(objGrid, arr_val[0]);
	var div_y = ClientToScreenY(objGrid, arr_val[1]);
	var div_w = arr_val[2] - arr_val[0];
	var div_h = arr_val[3] - arr_val[1];

	if(Find("PopDiv_TextArea")==null) {

		Create("PopupDiv", "PopDiv_TextArea", 'width="152" height="152"');
	}

	PopDiv_TextArea.Contents = _lFcSetPopDivTxtContent(sInitVal);
	PopDiv_TextArea.TrackPopup(div_x, div_y, div_w, div_h);

	return L_RtnVal;
}


/*
 * TextArea Component Content  Ͽ ش.
 *
 * param initVal - ʱ 
 *
 * return sRtn
 */
function _lFcSetPopDivTxtContent(initVal) {

	var sRtn = "";

	sRtn += '<Contents>' + chr(10);
	sRtn += '<TextArea Id="Txt_PopupDiv" Text="' + initVal + '" ' + chr(10);
	sRtn += 'Left="0" Top="0" Width="152" Height="152" ' + chr(10);
	sRtn += 'OnChanged="_lFcTextAreaOnChanged"></TextArea>' + chr(10);
	sRtn += '</Contents>';

	return sRtn;
}

/*
 * TextArea Component OnChanged ̺Ʈ ó Լ
 *
 * param obj - TextArea Component ü
 * param strText -  
 *
 * return void
 */
function _lFcTextAreaOnChanged(obj, strText) {

	if(L_RtnFlag) {

        L_RtnVal = strText;

    } else {

        L_GrdBindDs.SetColumn(L_GrdBindDsRow, L_GrdBindDsColId, strText);
    }

	PopDiv_TextArea.ClosePopup();
}





function MiForm_OnKeyDown(objSenderObj, nChar) {

	if(nChar==13 && objSenderObj.Gettype()=="Button") {

		objSenderObj.Click();
	}
}



/*
 * ܱεϹȣ ȿ Ȯ
 *
 * param foreNo - ܱεϹȣ : 13ڸ 
 *
 * return true/false
 */
function lFcIsForeigner(foreNo) {

    var sForeNo = replace(foreNo, " ", "");

    sForeNo = replace(foreNo, "-", "");

    if(length(sForeNo)!=13) {

        return false;
    }

	var sum = 0;
	var odd = 0;

	var buf = Array(13);

	for(i=0; i<13; i++) {

        buf[i]=parseInt(sForeNo.charAt(i));
    }

	odd = buf[7]*10 + buf[8];

	if(odd%2!=0) {

        return false;
    }

	if( (buf[11]!=6) && (buf[11]!=7) && (buf[11]!=8) && (buf[11]!=9) ) {

		return false;
	}

	var multipliers = [2,3,4,5,6,7,8,9,2,3,4,5];

	for(i=0, sum=0; i<12; i++) {

        //sum += (buf[i] *= multipliers[i]);
        buf[i] = buf[i] * multipliers[i];
        sum += buf[i];
    }

	sum = 11 - (sum%11);

	if(sum >= 10) {

        sum -= 10;
    }

	sum += 2;

	if(sum >= 10) {

        sum -= 10;
    }

	if(sum != buf[12]) {

        return false;
    }

	return true;
}



/************************************************************************************
 *
 *      IFIS Script
 *
 ************************************************************************************/




/*
 * ڿ ̰ maxLen  Ŭ  maxLen-1 ũ ڸ "..." ٿ ش.
 * 
 * param str - ڿ
 * param maxLen - ִ ũ
 *
 * return sRtn
 */
function lFcCutStr(str, maxLen) {

    var sRtn;
    
    if(length(str)>maxLen) {
    
        sRtn = mid(str, 0, maxLen-1) + "...";

    } else {

        sRtn = str;
    }

    return sRtn;
}


/**
 *  ڵ ȸ
 * 
 * param objDs - ȸ   ڵ  Dataset(ds_combo)
 *
 * return void
 */
function lFcGetCodeDs(objDs,bSync) {

    if(objDs==null) objDs = object("ds_combo");

    if(!isValid(objDs)) {
        trace("ȿ  Dataset " + objDs.ID + " in lFcGetCodeDs()");
        return;
    }

	var sInDs = objDs.ID + "=" + objDs.ID;
	var sOutDs;
	var sParam;

	var sCodeId;

	for(var i=0; i<objDs.GetRowCount(); i++) {
        sCodeId = L_commCdDsPrefix + objDs.GetColumn(i, "CDGUBN");
        sOutDs += sCodeId + "=" + sCodeId+" ";
	}

    sParam += " appName=" + quote("Common.Common"); // ʼ 
    sParam += " method=" + quote("getCommCode"); // ʼ 
    sParam += " dsName=" + quote(objDs.ID); // ʼ 

    lFcTransaction(
        "GetCommCodeTr",		// Transaction ID
        "service::Process.do",	// service
        sInDs,					// input Dataset
        sOutDs,	            	// output Dataset
        sParam,             	// parameter
        "fcbGetCodeDs",			// callback
        bSync					// Sync
    );
}


/**
 *  Dataset   return Dataset īѴ.
 *
 * param dsSrc -  Dataset ü
 * param rowIdxs -  index,   '^'ڷ Ѵ. (0^1^2^3^4 ...) : Nullable
 * param dsSrc - return Dataset : Nullable
 *
 * return void
 */
function lFcSetReturnDs(dsSrc, rowIdx, dsReturn) {

    var nRnum;
    var arrRowIdx;

    if(rowIdx==null) {

        rowIdx = dsSrc.GetCurrow();
    }

    if(dsReturn==null) {

        dsReturn = G_ds_return;
    }

    arrRowIdx = split(rowIdx, "^");

    dsReturn.Copy(dsSrc);

	dsReturn.DeleteAll();

	for(var i=0; i<length(arrRowIdx); i++) {

        nRnum = dsReturn.AppendRow();

        dsReturn.CopyRow(nRnum, dsSrc, arrRowIdx[i]);
	}
}


/*
 * μ  ˾ 
 *
 * return bRtn - /ݱ true/false
 */
function lFcOpenDeptTree() {

    var bRtn = Dialog("common::PopDeptTree.xml", "", 302, 500);

    return bRtn;
}


/*
 *   ˾ 
 *
 * param multiSelFlag ߼ 
 * return bRtn - / true/false
 */
function lFcOpenEmp(multiSelFlag) {

    var sArg;

    if(multiSelFlag==null) {

        multiSelFlag = false;
    }
    
    if(multiSelFlag) {
    
        sArg = "multiSelFlag=Y";

    } else {

        sArg = "multiSelFlag=N";
    }

    var bRtn = Dialog("common::PopEmp.xml", sArg, 550, 494);
    
    //alert(bRtn);

    return bRtn;
}



/**
 * Form ü(Form, Div, Tab)  Ʈ ʱȭ
 *
 * @param formObj - ʱȭ 
 * @param unClearComp - ʱȭ  Ʈ ID 迭
 *
 * @return Boolean
 */
function lFcCearFields(formObj, unClearComp) {

	if(length(formObj.Components)<1) {

		return true;
	}

	trace(formObj.GetType());

	for(var i=0; i<length(formObj.Components); i++) {

        //trace(formObj.Components[i].GetType() + " ---> " + formObj.Components[i].ID);
	}

	if(formObj.GetType()=="Tab") {

        lFcClearFieldsOnTab(formObj, unClearComp);

        return true;
	}

	var comp = null;

	for(var b=0; b<length(formObj.Components); b++) {

		comp = formObj.components(b);

		//if(indexOf(comp.ID,"Misplit")>-1) continue;

		if(_lFcIsSkipComponent(comp)) {

            if(comp.getType()=="Div") {

                if(comp.GetFirstComponent()==null) {

                    continue;
                }

				lFcClearFieldsOnDiv(comp, unClearComp);

			} else if(comp.getType()=="Tab") {

				lFcClearFieldsOnTab(comp, unClearComp);

			}/* else if(comp.getType()=="Dataset") {

				if(_lFcIsClearComp(comp.Id, unClearComp)) {

					comp.ClearData(); // Dataset Record !
                }
			}*/
			continue;
		}

		_lFcClearCompValue(comp, unClearComp);
	}
	return true;
}

/**
 * Div Component Clear
 * @param divObj - Div Ʈ ü
 * @param unClearComp - ʱȭ  Ʈ ID 迭
 * @return Boolean
 */
function lFcClearFieldsOnDiv(divObj, unClearComp) {

    if(length(divObj.Components)<1) {

		return true;
	}

	var comp = null;

	for(var c=0; c<length(divObj.Components); c++) {

		comp = divObj.Components(c);

		if(_lFcIsSkipComponent(comp)) {

			if(comp.getType()=="Div") {

				if(comp.GetFirstComponent()==null) {

					continue;
				}

                lFcClearFieldsOnDiv(comp, unClearComp);

			} else if(comp.getType()=="Tab") {

				lFcClearFieldsOnTab(comp, unClearComp);

			}/* else if(comp.getType()=="Dataset") {

				if(_lFcIsClearComp(comp.Id, unClearComp)) {

					comp.ClearData(); // Dataset Record !
                }
			}*/
			continue;
		}

		_lFcClearCompValue(comp, unClearComp);
	}
	return true;
}

/**
 * Tab Components Clear
 * @param tabObj - Tab Ʈ ü
 * @param unClearComp - ʱȭ  Ʈ ID 迭
 * @return Boolean
 */
function lFcClearFieldsOnTab(tabObj, unClearComp) {

	if(tabObj.TabCount<1) {

        return true;
    }

	var tabPage;

	for(var x=0; x<tabObj.TabCount; x++) {

        tabPage =tabObj.GetItem(x);

		var comp = null;

		for(var c=0; c<length(tabPage.Components); c++) {

			comp = tabPage.Components(c);

			if(_lFcIsSkipComponent(comp)) {

				if(comp.getType()=="Div") {

					if(comp.GetFirstComponent()==null) {

						continue;
					}

                    lFcClearFieldsOnDiv(comp, unClearComp);

				} else if(comp.getType()=="Tab") {

					lFcClearFieldsOnTab(comp, unClearComp);

				}/* else if(comp.getType()=="Dataset") {

                    if(_lFcIsClearComp(comp.Id, unClearComp)) {

                        comp.ClearData(); // Dataset Record !
                    }
                }*/

                continue;
            }

            _lFcClearCompValue(comp, unClearComp);
        }
    }
    return true;
}

/**
 * Լ üũ  Ʈ  Ǻϴ Լν, 
 * üũ Ʈ 쿡 true ȯѴ.
 *
 * @param comp - Ʈ ü
 *
 * @return boolean üũ  Ʈ  true/false
 */
function _lFcIsSkipComponent(comp) {

	var bRtn = false;

	switch(comp.getType()) {

		case "Button" :
		case "Static" :
		case "Image" :
		case "Grid" :
		case "Tab" :
		case "Div" :
		case "TreeView" :
		case "Shape" :
		case "WebBrowser" :
		case "swFlash" :
		case "MenuBar" :
		case "File" :
		case "FileDialog" :
		case "Dataset" :
		case "UbiReport" :
			bRtn = true;
			break;
		default :
			bRtn = false;
			break;
	}

	return bRtn;
}


/**
 * Ʈ  ʱȭ
 *
 * @param comp - Target Component
 * @param unClearComp - ʱȭ  Ʈ ID 迭
 *
 * @return void
 */
function _lFcClearCompValue(comp, unClearComp) {

    if(_lFcIsClearComp(comp.Id, unClearComp)) {

        switch(comp.getType()) {

            case "Checkbox" :

                comp.Value = comp.FalseValue;
                break;

            case "Combo" :

                comp.Index = 0;
                break;

            case "Dataset" :

                comp.ClearData();
                break;

            default :

                comp.Value = "";
                break;
        }
    }
}


/**
 * ʱȭ Ϸ ü ʱȭ  Ͽ ִ Ǵ  ,  ȯѴ.
 *
 * @param compId - Ʈ ID
 * @param unClearComp - ʱȭ  ʴ ü ID 迭
 *
 * @return Boolean
 */
function _lFcIsClearComp(compId, unClearComp) {

	var bRtn = true;

	if(unClearComp!=null && unClearComp.Length>0) {

        if(lFcInArray(unClearComp, compId)) {

            bRtn = false;
        }
/*
		for(var u=0; u<unClearComp.Length; u++) {

			if(compId==unClearComp[u]) {

				bRtn = false;
				break;
			}
		}
*/
	}
	return bRtn;
}


/**
 *  ε Լ
 *
 * @param objDsFile -    ִ ͼ
 *
 * @return Boolean
 */
function lFcFileUp(objDsFile) {

    var bRtn = true;

	if(find("_hf_upload")==NULL) {

		create("HttpFile", "_hf_upload");
	}

	var nFileSize;
    var sFullNmLocal;
    var nHfRtn;
	var nWriteSize;
	var nTotWriteSize;
    var sRemoteUrl;
	var sSaveNm;

	lFcSetWaitCursor(true);

    for(var i=0; i<objDsFile.GetRowCount(); i++) {

        sRemoteUrl = L_sysUrl + "/fileUpload.jsp";
        nTotWriteSize = 0;

        sSaveNm = objDsFile.GetColumn(i, "SAVE_NM");

        if(lFcIsNull(sSaveNm)) {

            sSaveNm = objDsFile.GetColumn(i, "NAME");
            sRemoteUrl = sRemoteUrl + "?uniqYn=Y";

        } else {

            sRemoteUrl = sRemoteUrl + "?uniqYn=N";
        }

        sFullNmLocal = objDsFile.GetColumn(i, "LPATH") + "\\" + objDsFile.GetColumn(i, "NAME");

        nFileSize = _hf_upload.GetFileSizeLocal(sFullNmLocal);

        _hf_upload.CookieParam = objDsFile.GetColumn(i, "SPATH") + "/" + sSaveNm; // ϸ
        
        //trace(sRemoteUrl + "\n" + _hf_upload.CookieParam);

        nHfRtn = _hf_upload.OpenFile(sRemoteUrl, sFullNmLocal, "PUT");

        if(nHfRtn<0) {

            lFcSetMsgBar(L_COM_ALT_0014, sFullNmLocal);

            bRtn = false;

            break;
        }

        global.FrameBottom.pb_fileUp.Enable = true;
        global.FrameBottom.pb_fileUp.Visible = true;
        global.FrameBottom.pb_fileUp.Pos = 0;
        global.FrameBottom.pb_fileUp.Step = L_upPacketSize;
        global.FrameBottom.pb_fileUp.Max = nFileSize;

		while(true) {

			nWriteSize = _hf_upload.WriteFile(L_upPacketSize);

			nTotWriteSize += nWriteSize;

			global.FrameBottom.pb_fileUp.Pos = nTotWriteSize;

			if(nWriteSize<L_upPacketSize) {

                break;
            }
		}

		//if(nTotWriteSize!=nFileSize) {
		if(nWriteSize==-1) {

            lFcSetMsgBar(L_COM_ALT_0029, sFullNmLocal);

            bRtn = false;

            break;
		}

        _hf_upload.CloseFile();

        var arrCookie = split2(_hf_upload.CookieParam, ";", "=");
        var arrParam;

        for(var k=0; k<length(arrCookie); k++) {

            arrParam = arrCookie[k];

            if(arrParam[0].pos("FileParam")>-1) {

                //trace(arrParam[1]);
                if(length(trim(arrParam[1]))==19) {

                    objDsFile.SetColumn(i, "SAVE_NM", trim(arrParam[1]) + objDsFile.GetColumn(i, "NAME"));
                }
            }
        }
    }

	//Destroy("_hf_upload");

	lFcSetWaitCursor(false);

	if(bRtn) {

        lFcSetMsgBar(L_COM_ALT_0030);
    }

    global.FrameBottom.pb_fileUp.Enable = false;
    global.FrameBottom.pb_fileUp.Visible = false;

    return bRtn;
}

/**
 *  ǥ ˾ 
 *
 * @return void
 */
function lFcProgressPop(step, max, min) {

	var sArg = "nStep=" + iif(step==null, 10, step) +
	           " nMax=" + iif(max==null, 100, max) +
	           " nMin=" + iif(min==null, 0, min);

    nHandle = open("Common::Progress.xml", sArg, 420, 120, "Title=false");
    //dialog("Common::Progress.xml", sArg, 420, 120, "Title=false");

    //return nHandle;
}



/**
 * ϴٿε Լ
 *
 * @param fileFullNm - full ϸ ( + ϸ)
 * @param cutLen -  ϸ��� ڸ ڿ  : Nullable
 *
 * @return void
 */
function lFcFileDown(fileFullNm, cutLen)
{
    if(fileFullNm==null || lFcIsNull(fileFullNm)) {

        trace("Full ϸ ϴ!");

        return;
    }

    //trace(fileFullNm);

	var sDownUrl = G_baseUrl + "fileDownload.jsp";

	var sCutLen = iif(cutLen==null, "0", cutLen);

	var sAttr = 'Height="29" Left="43" Width="29" visible="false"';

	if(find("_wb_fileDown")==null) {

		create("WebBrowser", "_wb_fileDown", sAttr);
	}

	_wb_fileDown.PageUrl = sDownUrl + "?fileFullNm=" + trim(fileFullNm) + "&cutLen=" + trim(sCutLen);

	_wb_fileDown.Run();
}


/**
 * ȸ  ¡ ó Լ
 *
 * @param totCnt - ü  
 * @param page -  
 * @param objPageCb -  ޺ ü : Nullable
 * @param objPreBtn -  ư ü : Nullable
 * @param objNextBtn -  ư ü : Nullable
 *
 * @return void
 */
function lFcSetPageCombo(TotCnt, rowPerPage, page, objPageCb, objPreBtn, objNextBtn) {

    if(rowPerPage==null) {

        rowPerPage = L_rowPerPage;
    }

    if(page==null) {

        page = 1;
    }
    
    if(objPageCb==null) {

        objPageCb = object("cb_page");
    }

    if(objPreBtn==null) {

        objPreBtn = object("btn_prePage");
    }

    if(objNextBtn==null) {

        objNextBtn = object("btn_nextPage");
    }

	if(find("_ds_page")==null) {

		create("Dataset","_ds_page");

		_ds_page.AddColumn("CODE", "String", 10);
		_ds_page.AddColumn("NAME", "String", 10);
	}

    var nMaxPageCnt = ceil(parseInt(totCnt)/parseInt(rowPerPage));
    
    var nRnum;

    for(var i=_ds_page.RowCount(); i<nMaxPageCnt; i++) {

        nRnum = _ds_page.AppendRow();

        _ds_page.SetColumn(nRnum, "CODE", i+1);
        _ds_page.SetColumn(nRnum, "NAME", i+1+"/"+nMaxPageCnt);
    }

    objPageCb.InnerDataset = _ds_page.ID;
    objPageCb.CodeColumn = "CODE";
    objPageCb.DataColumn = "NAME";

    objPageCb.Value = page;

    if(page==1 && nMaxPageCnt==1) {

        objPreBtn.Enable = false;
        objNextBtn.Enable = false;

    } else if(page==1) {

        objPreBtn.Enable = false;

        objNextBtn.Enable = true;
        objNextBtn.UserData = parseInt(page)+1;

    } else if(page==nMaxPageCnt) {

        objNextBtn.Enable = false;

        objPreBtn.Enable = true;
        objPreBtn.UserData = parseInt(page)-1;

    } else {

        objPreBtn.Enable = true;
        objNextBtn.Enable = true;

        objPreBtn.UserData = parseInt(page)-1;
        objNextBtn.UserData = parseInt(page)+1;
    }
}


/**
 * MDI Form  : ޴ ȭ   ۵
 *
 * @param url - ȣ ȭ URL. ex) "budget::B010401.xml"
 * @param paramFlag -  Ķ  true/false : Ķ    Dataset 'G_ds_param' ̿Ͽ Ѵ.
 *
 * @return void
 */
function lFcOpenMdiForm(url, paramFlag) {

    if(paramFlag==null) {

        paramFlag = false;
    }

    global.FrameBottom.fcOpenMDI(url, paramFlag);
}


/**
 * ڷ  迭 ޸ еǴ ڿ ȯѴ.
 *
 * @param arr - 迭
 * @param valType - value type("STRING"/"INT")
 *
 * @return sRtn - ޸ е ڿ : 'val1','val2','val3', ... Ǵ  val1,val2,val3, ...
 */
function lFcArrToStr(arr, valType) {

	var sRtn;

    if(valType==null) {

        valType = "STRING";
    }

	for(var i=0; i<length(arr); i++) {

		sRtn += iif(valType=="STRING", quote(arr[i]), arr[i]) + ",";
	}

	sRtn = substr(sRtn, 0, length(sRtn)-1);

	if(valType=="STRING") {

		sRtn = replace(sRtn, "\"", "'");
	}

	//trace(sRtn);

	return sRtn;
}


/**
 * ü  ޺ Ʈ  Null("")  Combo.Index  0 Ѵ.
 *
 * @param objForm - Form Ʈ
 *
 * @return void
 */
function lFcResetCombo(objForm) {

	//var arrComp = objForm.Components;
	var arrComp = objForm.Components["Combo"];

	var nCompCnt = 0;

	for(var i=0; i<length(arrComp); i++) {

		if(arrComp[i].GetType()=="Combo") {

			if(lFcIsNull(arrComp[i].Value)) {

				arrComp[i].Index = 0;
			}
		}
		nCompCnt++;
	}
	//trace("޺ : " + nCompCnt);
}


function lFcShowProgressBar() {

	global.FrameBottom.fcShowProgressBar();
}

function lFcHideProgressBar() {

	global.FrameBottom.fcHideProgressBar();
}

function lFcSetProgressMsg(msg) {

	global.FrameBottom.fcSetProgressMsg(msg);
}

function lFcSetProgressBar(nPos) {

	global.FrameBottom.fcSetProgressBar(nPos);
}



/**
 * Ķ  ش   ¥ ش.
 *
 * @param sDate - 
 *
 * @return sMonday - ش   ¥
 */
function lFcGetMonday(sDate) {

	var nDayOfWeek = getDay(sDate);
		
	var sMonday = addDate(sDate, -1*(nDayOfWeek-1));

	return sMonday;
}


/**
 * ش   ڸ ش.
 *
 * @param sDate - 
 * @param dayOfWeek -  (Ͽ 0,  1, ȭ 2,  3,  4, ݿ 5,  6)
 *
 * @return sFirstDayOfWeek -  ù° 
 */
function lFcGetFirstDayOfWeek(sDate, dayOfWeek) {

	if(dayOfWeek==null) {

		dayOfWeek = 1; // Ͽ 0,  1, ȭ 2,  3,  4, ݿ 5,  6
	}

	var sFirstDay = mid(sDate,0,6)+"01";

	var nDayIdx = getDay(sFirstDay);

	var sFirstDayOfWeek = addDate(sFirstDay, (7-nDayIdx+parseInt(dayOfWeek))%7);

	return sFirstDayOfWeek;
}


/**
 * Dataset Ʈ XML  
 *
 * @return void
 */
function lFcOpenDsExportPop() {

    var sRtn = Dialog("Common::DatasetExport.xml", "", 400, 400);
}

/**
 *  Ʈ Լ
 * 
 * @param strSvcID - Transaction  ID
 * @param strURL - Service URL
 * @param strInDatasets - input Datasets
 * @param strOutDatasets - output Datasets
 * @param strArgument - parameters
 * @param strCallbackFunc - callback function
 *
 * @return void
 */
function lFcTransaction(strSvcID, strURL, strInDatasets, strOutDatasets, strArgument, strCallbackFunc, bSync)
{
	G_transactionFlag = 1;
/*
	if(lFcIsNull(L_nPopHandler)) {
		L_nPopHandler = Open("Common::PopProgress.xml", "", 253, 42, "TitleBar=false");		
		//L_nPopHandler = Dialog("Common::PopProgress.xml","","253","42","TitleBar=false");
	}
*/
	if( bSync == true ){
		http.Sync = true;
	}

	//  ̵ - CIS ȭ鿡  
	if (G_ds_user.GetColumn(0,"DEPT_KIND")=="B") {
		strArgument += " WRK_ID="+quote(G_ds_user.GetColumn(0,"USER_ID"));
	} else {
		strArgument += " WRK_ID="+quote(substr(G_ds_user.GetColumn(0,"USER_ID"),0,6));
	}
	
	//  ̵ - űȭ鿡  
	strArgument += " WRK_SAWON_ID="+quote(G_ds_user.GetColumn(0,"SAWON_ID"));  
	
	//  ���
	strArgument += " WRK_CC="+quote(G_ds_user.GetColumn(0,"BS_ID"));

	if(lFcIsNull(L_nPopHandler)) {
		//L_nPopHandler = Open("Common::PopProgress.xml", "", 253, 42, "TitleBar=false");		
		//L_nPopHandler = Dialog("Common::PopProgress.xml","","253","42","TitleBar=false");
	}
	
    Transaction(
        strSvcID,			// Transaction ID
        strURL,				// service
        strInDatasets,		// input Dataset
        strOutDatasets, 	// output Dataset
        strArgument,    	// parameter
        strCallbackFunc		// callback function
    );

    if( bSync == true ){
		http.Sync = false;
	}
}

/**
 *  Ʈ Լ
 * 
 * @param strSvcID - Transaction  ID
 * @param strURL - Service URL
 * @param strInDatasets - input Datasets
 * @param strOutDatasets - output Datasets
 * @param strArgument - parameters
 * @param strCallbackFunc - callback function
 *
 * @return void
 */
function lFcTransactionNotPrc(strSvcID, strURL, strInDatasets, strOutDatasets, strArgument, strCallbackFunc, bSync)
{
	G_transactionFlag = 1;
/*
	if(lFcIsNull(L_nPopHandler)) {
		L_nPopHandler = Open("Common::PopProgress.xml", "", 253, 42, "TitleBar=false");		
		//L_nPopHandler = Dialog("Common::PopProgress.xml","","253","42","TitleBar=false");
	}
*/
	if( bSync == true ){
		http.Sync = true;
	}
	
	//  ̵ - CIS ȭ鿡  
	if (G_ds_user.GetColumn(0,"DEPT_KIND")=="B") {
		strArgument += " WRK_ID="+quote(G_ds_user.GetColumn(0,"USER_ID"));
	} else {
		strArgument += " WRK_ID="+quote(substr(G_ds_user.GetColumn(0,"USER_ID"),0,6));
	}
	
	//  ̵ - űȭ鿡  
	strArgument += " WRK_SAWON_ID="+quote(G_ds_user.GetColumn(0,"SAWON_ID"));  
	
	//  ���
	strArgument += " WRK_CC="+quote(G_ds_user.GetColumn(0,"BS_ID"));

    Transaction(
        strSvcID,			// Transaction ID
        strURL,				// service
        strInDatasets,		// input Dataset
        strOutDatasets, 	// output Dataset
        strArgument,    	// parameter
        strCallbackFunc		// callback function
    );

    if( bSync == true ){
		http.Sync = false;
	}
}


/**
 * ȣ ˻ ˾ 
 *  Dataset G_ds_return   ȣ ּҸ Ѵ.
 *
 * <dataset id="G_ds_return">
 *    <colinfo id="ZIPADR" size="256" type="STRING"/>
 *    <colinfo id="ZIPNBR" size="256" type="STRING"/>
 * </dataset>
 *
 * @return ˾  Flag true/false
 */
function lFcPopPostNo() {

	return Dialog("Common::post.xml", "", 400, 342);
}


/**
 * α  Ҽ ׷쿩θ ȮѴ.
 *
 * @param groupId - ׷ ID
 *
 * @return true/false
 */
function lFcHasGroup(groupId) {

	var bRtn = iif(G_ds_userGroup.FindRow("GROUPID", groupId)==-1, false, true);

	return bRtn;
}

/**
 * ȳ  ȣ Bit  .
 *
 * @param OTOGNB - ȣ
 *
 * @return OTOGNBS-ȣ Ȱ
 */
function lFcBitCheckCUSTNO(CUSTNO){
	
	var Flag = 2;
	var temp = 0;
	var temp1 = 0;
	var temp2 = 0;
	var sumTong = 0;
	var result = 0;
	var st_result = "";
	
	//���ȣ Bit ϱ
	for (i=0; i <=18; i++){
	
		temp = toInteger(substr(CUSTNO,i,1)) * Flag;
		
		if (length(toString(temp)) == 2){
			temp1 = substr(temp,0,1);
			temp2 = substr(temp,1,2);
		}else{
			temp1 = 0;
			temp2 = temp;
		}
		
		//���ȣ Bit ϱ
		sumTong = sumTong + toInteger(temp1) + toInteger(temp2);
		
		if (Flag == 1){	
			Flag = 2;
		}else{
			Flag = 1;
		}
		
	}
	
	//���ȣ Bit  result
	result = (10 - toInteger(substr(sumTong,1,2)));
	
	//trace(length(result));
	
	if (length(toString(result)) == 2){
		result = substr(result,1,2);
	}
	
	st_result = "+"+CUSTNO+result+"+";
	
	return st_result;

	
}


/**
 * ȳ   Bit  .
 *
 * @param GUMAMT - 
 *
 * @return GUMAMTS- Ȱ
 */
function lFcBitCheckJIROAMT(JIROAMT){
	
	var Flag = 1;
	var result = 0;
	var amtTemp = 0;
	var st_result = "";
	var temp = "0";
	
	//JIROAMT 10ڸ ä
	if (length(JIROAMT) <> 10){
		
		for (i=1; i < (10-length(toString(JIROAMT)));i++){
			temp = temp + "0";
		}
		
	}
	
	//trace("äڸ------->"+temp);
	
	for (j=1; j<=9; j++){
	
		amtTemp = amtTemp + (toInteger(substr(temp+JIROAMT,j,1)) * Flag);
		
		if (Flag == 1){
			Flag = 3;
		}else if (Flag == 3){
			Flag = 7;
		}else if (Flag == 7){
			Flag = 1;
		}
		
	}
	
	if (length(toString(amtTemp)) == 2){
		amttemp = toInteger(substr(amtTemp,1,2));
	}else{
		amttemp = (amttemp % 10);
		//amttemp = amttemp;
	}
	
	trace("Ǿ°?????????????"+amtTemp);
	
	// Bit  result
	result = (10 - amttemp);
	
	trace("̴---------"+length(toString(result)));
	
	if (length(toString(result)) == 2){
		result = substr(result,1,2);
	}
	
	trace("result+++++++++++++++++++++++++++"+result);
	
	st_result = "+"+JIROAMT+result+"<";

	return st_result;
	
}


/**
 * ü   ˾ 
 *
 * @param cscCod - üڵ
 *
 * @return ڹȣ
 */
function lFcOpenModCustInfo(cscCod) {

	var sArg;

	sArg = "sCscCod=" + quote(cscCod);

    return Dialog("Cust::eKins_CST010P.xml", sArg, 434, 464);
}


/**
 * ��� ۾̷ Ÿ¿ ֽ ´.
 *
 * @param objDs : ۾ Ÿ ѱ.
 *
 * @return 
 */     
function lFcCustHistoryInsert(objDs)
{
	
	if ( global.FrameTop2.ds_cust_history.rowcount != 0  &&
	 objDs.GetColumn(objDs.row, "ADMIT_NO") == global.FrameTop2.ds_cust_history.GetColumn(0, 'ADMIT_NO') ) {
		return;
	}
	// ӽ÷ => pc ð   ð
	var work_time = mid(GetDate(),8,6);	
	
	global.FrameTop2.ds_cust_history.InsertRow(0);

	global.FrameTop2.ds_cust_history.SetColumn(0, 'WORK_TIME', work_time);
	global.FrameTop2.ds_cust_history.SetColumn(0, 'ADMIT_NO', objDs.GetColumn(objDs.row, "ADMIT_NO"));
	global.FrameTop2.ds_cust_history.SetColumn(0, 'CUST_NAME', objDs.GetColumn(objDs.row, "CUST_NAME"));
	global.FrameTop2.ds_cust_history.SetColumn(0, 'ADDR_COM', objDs.GetColumn(objDs.row, "ADDR_COM"));
	global.FrameTop2.ds_cust_history.SetColumn(0, 'BLD_NAME', objDs.GetColumn(objDs.row, "BLD_NAME"));
	global.FrameTop2.ds_cust_history.SetColumn(0, 'BLD_DONG', objDs.GetColumn(objDs.row, "BLD_DONG"));
	global.FrameTop2.ds_cust_history.SetColumn(0, 'BLD_HOSU', objDs.GetColumn(objDs.row, "BLD_HOSU"));
	global.FrameTop2.ds_cust_history.SetColumn(0, 'TEL_NO', objDs.GetColumn(objDs.row, "TEL_NO"));	
	

//	lFcSetCustNo(objDs.GetColumn(objDs.row, "ADMIT_NO"));	// ���   ȸ // ʿ
	//global.GetTopWindow().div_content.lFcSearch();  // 2008.05.16 lsy
	
}

/**
 *   ���ȣ  ȭ Edit Box Ѵ.
 *
 * @param objDs : ۾ Ÿ ѱ. lsy
 *   OnLoad Ȱ
 * @return 
 */
function lFcSetCustNo(ObjEdit)
{	
	if( ObjEdit == null ) return;
	
	var v_return;
	var v_cust_no = G_ds_cust_info.GetColumn(0,'ADMIT_NO');
	if(  length(trim(v_cust_no)) > 0 ){
		ObjEdit.value = G_ds_cust_info.GetColumn(0,'ADMIT_NO');
		v_return = true;
	}else{
		v_return = false;
	}
	
	return v_return;
}

//  ֻ MDi   ȭ麰 ȸ Լ ȣѴ.
function lFcCommSearchCall()
{

	//lFcSetCustNo(global.GetTopWindow().div_content.edt_cust_no);
	
	/*if(lFcSetCustNo(global.GetTopWindow().div_content.edt_cust_no)){
		global.GetTopWindow().div_content.lFcSearch();
	}*/
	
}

//  ȭ  Ŭ  ��� ȸ ϴ Լ
function lFcTopCustReflash(CUST_NO)
{
	if (G_ds_cust_info.GetColumn(0,"ADMIT_NO") != CUST_NO) {
		global.FrameTop2.lfcCustInfo(CUST_NO,false);
	
	}
}

/**
 *  ׸  Ŭ sort üũ ڽ ý ü/ Ѵ.
 *
 * @param objGrd : ׸
 * @param nCell : cell ε
 *
 * @return 
 */
 function lFcGridOnHeadClick(objGrd,nCell)
{
	var objBindDs = object(objGrd.BindDataset);
	var v_colid = objGrd.GetCellProp('body',nCell,'colid');	

	// ׸  ü üũ ڽ ü/ü Ѵ.
	if( v_colid == 'CHK' ){
		var v_chk = objGrd.GetCellProp('head',nCell,'text');
	
		if( v_chk == '1' ){
			objGrd.SetCellProp('head',nCell,'text','0');
			v_chk = '0';
		}else{
			objGrd.SetCellProp('head',nCell,'text','1');
			v_chk = '1';
		}
		
		for( i=0; i<objBindDs.rowcount; i++ ){
			if( v_chk == '1' ){
				objBindDs.SetColumn(i,'CHK','1');
			}else{
				objBindDs.SetColumn(i,'CHK','0');
			}
		}
	}else{
		//׸ Ʈ Ѵ.
		lFcGridSort(objGrd, nCell);
	}
}

function lfcSplit(strString,strDelimiter)
{
	var varArray = Array();
	var sTemp = strString;
	var nArrIdx = 0;
	var nPos = 0;

	while (true) {
		nPos = pos(sTemp, "|");
		varArray[nArrIdx] = substr(sTemp,0,nPos);
		sTemp = substr(sTemp,nPos+1);
		nArrIdx++;
		if (nPos==-1) {
			varArray[nArrIdx] = sTemp;
			break;
		}
	}
	
	return varArray;
}

/**************************************************************
 1.    : l_fn_openFileAttachPopup(pFileNo)
 2. Ķ : 	pFileNo           :  File_NO
				pSingleFileOnlyYn : ѰǸ ÷ 
				pDownLoadOnlyYn   : ٿε常  
				pUpLoadOnlyYn     : ε常  
 3.    : File_NO
 4.      : ÷ ̾α׸ 
**************************************************************/
function lFc_openFileAttachPopup(pFileNo,pSingleFileOnlyYn,pDownLoadOnlyYn,pUpLoadOnlyYn)
{
	var arg = "fileNo="+quote(pFileNo);
		arg += " singleFileOnlyYn="+pSingleFileOnlyYn;
		arg += " downLoadOnlyYn="+pDownLoadOnlyYn;
		arg += " upLoadOnlyYn="+pUpLoadOnlyYn;
		
	var ret = Dialog("Common::PopFileAttach.xml", arg, 500, 500, false, -1, -1);
	return ret;
}

//  Ȯ Ͽ return
function lFcGetFileExtension(strFileNm)
{
	var idx = 0;
	while (IndexOf(strFileNm,".", idx+2) > 0)
	{
		idx = IndexOf(strFileNm,".", idx+1) ;
	}
	
	var file_ext=substr(strFileNm,idx,length(strFileNm));
	//trace("file_ext="+file_ext);
	return file_ext;
}

/**************************************************************
 1.    : l_fn_openFileAttachPopup(pFileNo)
 2. Ķ : 	fr_cc_id	: ��� combobox object (from) -   cb_cc_id  νϿ 
				to_cc_id	: ��� combobox object (to) -    
				* ds_codeCCID   ޺ڽ
 3.    : 
 4.      : ���ڵ带 ۷ι Ÿ¿ ִ   
               Ѻ Ѵ.
**************************************************************/
function lFcCcSet(fr_cc_id, to_cc_id)
{
	ds_codeCCID.Copy(G_ds_cc_id);  // ۷ι ��� ڵ带 ´.
	
	if(!IsValidObject(fr_cc_id)){
		fr_cc_id = object("cb_cc_id");
	}

	//Loginμ 
	if (G_ds_user.GetColumn(0, "SAWON_GB") == "A"){
		//
		fr_cc_id.Enable = true;
		fr_cc_id.index = 0;
	}else{
		//���͸
		fr_cc_id.Enable = false;
		fr_cc_id.Value = G_ds_user.GetColumn(0, "CC_ID");
		
	}

	if(IsValidObject(to_cc_id)){
		//Loginμ 
		if (G_ds_user.GetColumn(0, "SAWON_GB") == "A"){
			//
			to_cc_id.Enable = true;
			to_cc_id.index = 0;
		}else{
			//���͸
			to_cc_id.Enable = false;
			to_cc_id.Value = G_ds_user.GetColumn(0, "CC_ID");
		}
	}

}

/**************************************************************
 1.    : lFcCC_Authority_Chk()
 2. Ķ : 	
 3.    : true/false
 4.      :  ���Ϳ ��� ���  üũѴ.
               1)     ���  üũ 
               2) ��� ڰ ��� ���Ϳ ġ  false return
**************************************************************/
function lFcCC_Authority_Chk()
{
	if( G_ds_cust_info.rowcount == 0){
		alert('ȸ ��� ϴ.');
		return false;
	}
	
	if (G_ds_user.GetColumn(0, "SAWON_GB") != "A"){
		if (G_ds_user.GetColumn(0, "CC_ID") != G_ds_cust_info.GetColumn(0,'CC_ID')){
			return false;
		}
	}
	
	return true;
}

/**************************************************************
 1.    : lFcHelpDocuExport(scrId)
 2. Ķ : scrID(ȭID)
 3.    : true/false
 4.      : ư Ŭ ش 幮 ExportѴ.
**************************************************************/
function lFcHelpDocuExport(scrId){
	
	//alert("غԴϴ.");
	lFcAlert("  ø ٷּ.");
	ExecBrowser(G_baseURL + "manual/" + scrId + ".doc");

}

/**************************************************************
 1.    : lFcCCQuery()
 2. Ķ : -
 3.    : true/false
 4.      : ��� ȸ  
 5. history: 2009 3 ��� տ  ߰ Լ!
**************************************************************/
function lFcCCQuery()
{
var l_ccid = cb_cc_id.Value;
var g_ccid = G_ds_user.GetColumn(0, "CC_ID");

    if (G_ds_user.GetColumn(0, "SAWON_GB") == "A")
        return true;

	if (l_ccid <> g_ccid)
	{
	     if (g_ccid == "131" && l_ccid=="132")
	     {
	    	    return true;
	     } else if (g_ccid == "333" && l_ccid=="335")
	     {   
	            return true; 
	     } else if (g_ccid == "435" && l_ccid=="436")
	     {
	            return true;
	     } else if (g_ccid == "631" && l_ccid=="633")
	     {
	            return true;
	     } else {  
	       lfcalert("ȸ  ϴ.");
	       return false; 
	     }
	}else
	{
	   return true;
	}
}

/**************************************************************
 1.    : lFcShowDataset()
 2. Ķ : Dataset(Ÿ¸)
 3.    : -
 4.      : Ÿ ÷ outputâ ȸҼ ִԼ
 5. history: 2009 9 α׷  ߰ Լ!
**************************************************************/
function lFcShowDataset(Dataset)
{
	var i,j;
	var tempStr = "";
	var RowCount = Dataset.RowCount();
	var ColCount = Dataset.ColCount();
	
	//Dataset ID 
	tempStr = "[" + Dataset.id + "]\n\n"; 
	
	//Column ID 
	tempStr = tempStr + "|";
	for (j=0; j < ColCount; j++)
		tempStr = tempStr + Dataset.GetColID(j) + "\t|";
	tempStr = tempStr + "\n\n";
	
	//Column Data  
	for (i=0; i < RowCount; i++) 
	{
		tempStr = tempStr + "Row "+ i + " :\n";


		for (j=0; j < ColCount; j++) 
		{
			tempGetColumn = Dataset.GetColumn(i, j);
	
			tempStr = tempStr + tempGetColumn;
			if ((j == 10)||(j == 20)||(j == 30)||(j == 40)||(j == 50))
				tempStr = tempStr + "\n|";
			else
				tempStr = tempStr + "\t|";
		}
		tempStr = tempStr + "\n\n";
	}
	trace(tempStr);
}

/**************************************************************
 1.    : lFcSetAddr()
 2. Ķ : Dataset(Ÿ¸)
 3.    : -
 4.      : ּҸ ϴ Լ
 5. history: 2009 9 ּҼÿ ߰ Լ!
**************************************************************/
function lFcSetZIP_ADDR(Dataset)
{
	Dataset.FireEvent = false;
	for(i=0;i<Dataset.rowcount;i++)
	{
		Dataset.SetColumn(i,"ZIP_ADDR",G_ds_code31.GetColumn(G_ds_code31.FindRow("CD_CODE",Dataset.GetColumn(i,"ZIP_SIDO")),"CD_NAME")
		+ " " + G_ds_code32.GetColumn(G_ds_code32.FindRow("CD_CODE",Dataset.GetColumn(i,"ZIP_GUGUN")),"CD_NAME")
		+ " " + G_ds_code33.GetColumn(G_ds_code33.FindRow("CD_CODE",Dataset.GetColumn(i,"ZIP_DONG")),"CD_NAME")
		+ iif(Dataset.GetColumn(i,"ZIP_RI")="","", " " + G_ds_code34.GetColumn(G_ds_code34.FindRow("CD_CODE",Dataset.GetColumn(i,"ZIP_RI")),"CD_NAME"))
		+ " " + Dataset.GetColumn(i,"ZIP_BUNJI")
		+ iif(Dataset.GetColumn(i,"ZIP_HOSU")="","", "-" + Dataset.GetColumn(i,"ZIP_HOSU")));
	}
	Dataset.FireEvent = true;

}

/**
 * Tab component   Component  θ Ѵ
 *
 * param objTab - Tab component
 * param bEnable - 뿩 : true/false
 *
 */
function lFcEnableCompOnTab(objTab, bEnable) {

	for ( var i = 0 ; i < objTab.Components.Count ; i++ )
	{
		if (  ( objTab.Components[i].GetType() == "Dataset" ) ||
			  ( objTab.Components[i].GetType() == "File" ) ||	
			  ( objTab.Components[i].GetType() == "FileDialog" ) ||	
			  ( objTab.Components[i].GetType() == "PopupDiv" ) ||	
			  ( objTab.Components[i].GetType() == "Shape" )  ||	
			  ( objTab.Components[i].GetType() == "Button" ) ||	
			  ( objTab.Components[i].GetType() == "Static" ) ||	
			  ( objTab.Components[i].TabStop == false ) 
		   )	
			continue;
		if ( objTab.Components[i].GetType() == "Grid")
		{
			objTab.Components[i].Editable = bEnable;
		} else {
			objTab.Components[i].Enable = bEnable;
		}
	}
}


