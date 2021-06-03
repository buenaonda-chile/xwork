<%@ page contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>

<html>
<head>
<title>UbiReport Preview</title>
<script language='javascript' src='http://java.com/js/deployJava.js'></script>
<script language='javascript'>
<!--

	/* �⺻ ���� */
	var host = self.location.host;							// ip:port
	var app = "myapp";										// WebApplication ��.
	var url = "http://" + host + (app==""?"":("/" + app));	// WebApplication URL.

	/* ȯ�� ���� ���� */
	var file_url = url + "/ubireport/";			// ����Ʈ���� ���Ǵ� �̹��� �Ǵ� ���� ������ ������ ������������ ����.
	var form_url = url + "/UbiForm";			// Form Servlet URL
	var data_url = url + "/UbiData";			// Data Servlet URL
	var jrf_dir = "/WAS/myapp/ubireport/work/";	// ����Ʈ ���� ���.
	var jrf = "ubi_sample.jrf";					// ����Ʈ���ϸ�.
	var ds  = "jdbc/tutorial";					// ����Ÿ�ҽ���.
	var scale = "120";							// �ʱ� ����
	var is_deflater = "true";					// �������� ��� �ɼ� (ubigateway.property�� �Ӽ��� ���ƾ���).
	var is_base64 = "true";						// �������� ��� �ɼ� (ubigateway.property�� �Ӽ��� ���ƾ���).
	var is_unicode = "false";					// �������� ��� �ɼ� (ubigateway.property�� �Ӽ��� ���ƾ���).
	var utf_data = "false";						// �������� ��� �ɼ� (ubigateway.property�� �Ӽ��� ���ƾ���).

	var codebase = url + "/ubireport/";			// UbiViewer ���� ���
	var jar_ver = "2.502.1506.101";			// UbiViewer ����.

	var w_gap = 12; // ���� ũ�� ����.
	var h_gap = 12; // ���� ũ�� ����.

	function getArg() { // �ƱԸ�Ʈ �� ����. �ڵ� ȣ��.
	
		var args = 'arg1#arg1_value1#arg2#arg2_value#...#argn#argn_value#';
		return args;
	}

	function Ubi_Resize() { // ������ �������� �� ������Ʈ ũ�� ����.

		var w = ((self.innerWidth || (document.documentElement && document.documentElement.clientWidth) || document.body.clientWidth)) - w_gap;
		var h = ((self.innerHeight || (document.documentElement && document.documentElement.clientHeight) || document.body.clientHeight)) - h_gap;
		document.getElementById("UbiViewer").width = w + 'px';
		document.getElementById("UbiViewer").height = h + 'px';
	}

	function Ubi_CheckIE() { // ������ üũ(IE or Non-IE).
	
		var isIE = false;
		if( window.ActiveXObject ) {
			isIE = true;
		}
		else if( navigator.userAgent.indexOf('Trident/7') != -1 && navigator.appName.indexOf("Netscape") != -1 && navigator.product == "Gecko" ) {
			isIE = true;
		}
		return isIE;
	}

	function Ubi_CheckJre() { // JRE ��ġ ���� �� ���� üũ.

		if( !deployJava.versionCheck("1.6.0+") ) {

			if( confirm('JVM ��ġ�� �ʿ��մϴ�.\n\n��ġ�������� �̵��մϴ�.') ) deployJava.installLatestJRE();
		}
	}

//-->
</script>
</head>
<body style='margin:3px' onresize="Ubi_Resize()">
<script type="text/javascript">
<!--
	if( Ubi_CheckIE() ) Ubi_CheckJre();	// JRE ��ġ���θ� Ȯ���ϴµ� IE��� Ubi_CheckJre()�� üũ�ϰ� IE�� �ƴ϶�� �ش� ���������� üũ ó��.

	var w = ((self.innerWidth || (document.documentElement && document.documentElement.clientWidth) || document.body.clientWidth)) - w_gap;
	var h = ((self.innerHeight || (document.documentElement && document.documentElement.clientHeight) || document.body.clientHeight)) - h_gap;

	document.write("<applet id='UbiViewer' code='com.icm.report.preview.UbiViewer.class' archive='UbiViewer.jar' width='" + w + "px' height='" + h + "px' mayscript>");
	document.write("	<param name='type'					value='application/x-java-applet;version=1.6'>");
	document.write("	<param name='codebase'				value='" + codebase + "'>");
	document.write("	<param name='cache_version'			value='" + jar_ver + "'>");

	document.write("	<param name='fileURL'				value='" + file_url + "'>");
	document.write("	<param name='servletRootURL'		value='" + url + "'>");
	document.write("	<param name='servletURL1'			value='" + form_url + "'>");
	document.write("	<param name='servletURL2'			value='" + data_url + "'>");
	document.write("	<param name='jrfFileDir'			value='" + jrf_dir + "'>");
	document.write("	<param name='jrfFileName'			value='" + jrf + "'>");
	document.write("	<param name='dataSource'			value='" + ds + "'>");
	document.write("	<param name='scale'					value='" + scale + "'>");

	document.write("	<param name='isDeflater'			value='" + is_deflater + "'>");
	document.write("	<param name='isBase64'				value='" + is_base64 + "'>");
	document.write("	<param name='isUnicode'				value='" + is_unicode + "'>");
	document.write("	<param name='utfData'				value='" + utf_data + "'>");

	document.write("	<param name='execType'				value='TYPE4'>");	// ��������. ���� �Ұ�.
	document.write("	<param name='margin'				value='true'>");	// ���� ��ũ ���� ���� �Ӽ�.
	document.write("	<param name='progress'				value='true'>");	// ���α׷����� ���� ���� �Ӽ�.
	document.write("	<param name='toolbar'				value='true'>");	// ���� ���� ���� �Ӽ�.
	document.write("	<param name='fontRevision'			value='true'>");	// ��Ʈ����. ���� �Ұ�.
	document.write("	<param name='printMarginRevision'	value='true'>");	// ��º���. ���� �Ұ�.
	document.write("</applet>");

//-->
</script>

</body>
</html>

