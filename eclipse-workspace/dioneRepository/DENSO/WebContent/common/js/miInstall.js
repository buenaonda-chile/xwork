function checkOS()
{
	var strOS = "VISTA";
	
	/*
	if( navigator.appVersion.indexOf("Windows NT 6.0") != -1) 
		strOS = "VISTA";
	else if( navigator.appVersion.indexOf("Windows 98") != -1) 
		strOS = "98";
	else if( navigator.appVersion.indexOf("Windows NT 5.0") != -1) 
		strOS = "2000";
	else if( navigator.appVersion.indexOf("Windows NT 5.2") != -1) 
		strOS = "XP";		
  	else if( navigator.appVersion.indexOf("Windows NT 5.1") != -1) 
  		strOS = "XP";

  	return strOS;
 	*/
	/* modify date : 20171219  */
	if( navigator.appVersion.indexOf("Windows NT 10.0") != -1) //Windows 10
		strOS = "VISTA";
	else if( navigator.appVersion.indexOf("Windows NT 6.3") != -1) //Windows 8.1
		strOS = "VISTA";
	else if( navigator.appVersion.indexOf("Windows NT 6.2") != -1) //Windows 8
		strOS = "VISTA";
	else if( navigator.appVersion.indexOf("Windows NT 6.1") != -1) //Windows 7
		strOS = "VISTA";
	else if( navigator.appVersion.indexOf("Windows NT 6.0") != -1) //Windows Vista
		strOS = "VISTA";
	else if( navigator.appVersion.indexOf("Windows 98") != -1)
		strOS = "98";
	else if( navigator.appVersion.indexOf("Windows NT 5.0") != -1) //Windows 2000
		strOS = "2000";
	else if( navigator.appVersion.indexOf("Windows NT 5.2") != -1) //Windows XP 64-Bit
		strOS = "XP";
	else if( navigator.appVersion.indexOf("Windows NT 5.1") != -1) //Windows XP
		strOS = "XP";
	
	if( navigator.userAgent.indexOf("Trident") != -1){
		strOS = "VISTA";
	}
  	return strOS;
}

function Is98()
{
  var bChk = false;
  if( navigator.appVersion.indexOf("Windows 98") != -1) 
  	bChk = true;
  return bChk;
}

function Is2000()
{
  var bChk = false;
  if( navigator.appVersion.indexOf("Windows NT 5.0") != -1) 
  	bChk = true;
  return bChk;
}

function Is2003()
{
  var bChk = false;
  if( navigator.appVersion.indexOf("Windows NT 5.2") != -1) 
  	bChk = true;
  return bChk;
}

function IsXp()
{
  var bChk = false;
  if( navigator.appVersion.indexOf("Windows NT 5.1") != -1) 
  	bChk = true;
  return bChk;
}

function IsAfterVista()
{
  var bChk = false;
  if( navigator.appVersion.indexOf("Windows NT 6.0") != -1) 
  	bChk = true;
  return bChk;
}


function CreateMiInstlr(strID, Device,Version,Key)
{
	
	/*document.write("<object id=\""+strID+"\" classid=\"clsid:1A000B1F-B285-4fbf-B3CD-B50845003EBB\" width=\"0\" height=\"0\" CodeBase=\"./MiinstallU/MiPlatform_Updater321.cab#VERSION=2013.5.31.1\" SHOWASTEXT>" +
		"<PARAM NAME=\"DeviceType\" VALUE=\""+Device+"\" >" +
		"<PARAM NAME=\"Version\" VALUE=\""+Version+"\" >" +
		"<PARAM NAME=\"key\" VALUE=\""+Key+"\" >" +
		"</object>" );
		*/
	/* CodeBase 대소문자변경
	document.write('<OBJECT ID="'+strID+'" CLASSID="CLSID:1A000B1F-B285-4fbf-B3CD-B50845003EBB" ' +
            '    CodeBase="./MiinstallU/MiPlatform_Updater321.cab#VERSION=2013.5.31.1" width=0 height=0 SHOWASTEXT> ' +
            '    <param name="Version"       value="3.2"> ' +
            '    <param name="DeviceType"    value="'+Device+'"> ' +
            '    <param name="Key"           value="'+Key+'"> ' +
            '</OBJECT> ');
    */
	document.write('<OBJECT ID="'+strID+'" CLASSID="CLSID:1A000B1F-B285-4fbf-B3CD-B50845003EBB" ' +
            '    CodeBase="./miInstallU/MiPlatform_Updater321.cab#VERSION=2013.5.31.1" width=0 height=0 SHOWASTEXT> ' +
            '    <param name="Version"       value="3.2"> ' +
            '    <param name="DeviceType"    value="'+Device+'"> ' +
            '    <param name="Key"           value="'+Key+'"> ' +
            '</OBJECT> ');
}

function ObjectMiInstlr(strID, Device,Version,Key)
{
	document.write("<object id=\""+strID+"\" classid=\"clsid:1A000B1F-B285-4fbf-B3CD-B50845003EBA\" width=\"0\" height=\"0\" SHOWASTEXT>" +
		"<PARAM NAME=\"DeviceType\" VALUE=\""+Device+"\" >" +
		"<PARAM NAME=\"Version\" VALUE=\""+Version+"\" >" +
		"<PARAM NAME=\"key\" VALUE=\""+Key+"\" >" +
		"</object>" );
}
