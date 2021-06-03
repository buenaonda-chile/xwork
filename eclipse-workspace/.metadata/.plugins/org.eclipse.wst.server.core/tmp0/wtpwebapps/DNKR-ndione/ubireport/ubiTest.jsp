<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- HTML SAMPLE -->
<html>
<head>
<title>test(SAMPLE)</title>

<!-- [UbiReport] Don't remove this script -->
<script type="text/javascript">
function refresh(args)
{
   document.UbiViewer.refreshFrame("", args, "TYPE1");
}

function getArg()
{
	alert('dd');
   var arg = "";
   return arg;
}

getArg();
</script>

</head>
<body style="margin=0">

<object id="UbiViewer" classid="CLSID:CCE578F0-6DFC-4649-8D30-82682A583E05" codebase="http://dynamice.busan.go.kr/ubireport/UbiViewerX.cab#version=2,5,0,1" width="100%" height="100%">
   <param name="fileUrl" value="http://localhost/ubiviewer">
   <param name="servletURL1" value="http://dynamice.go.kr/ubireport/Form">
   <param name="servletURL2" value="http://dynamice.go.kr/ubireport/Result">
   <param name="jrfFileDir" value="C:/eGovFrameDev-3.5.1-64bit/dynamics/busan/src/main/webapp/ubireport/work/">
   <param name="jrfFileName" value="test.jrf">
   <param name="dataSource" value="BUSAN##">
   <param name="execType" value="TYPE1">
   <param name="scale" value="120">
   <param name="Progress" value="true">
   <param name="toolbar" value="true">
   <param name="margin" value="true">
   <param name="isDeflater" value="true">
   <param name="UtfData" value="false">
   <param name="IsUnicode" value="false">
   <param name="fontRevision" value="true">
</object>

</body>
</html>