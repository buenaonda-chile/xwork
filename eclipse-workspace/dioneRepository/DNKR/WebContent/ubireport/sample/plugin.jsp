<%@ page contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>

<html>
<head>
<title>UbiReport Preview</title>
<script type="text/javascript" src="/myapp/ubireport/nonax/ubiplugin.js"></script>
<script language='javascript'>
<!--

	/* �⺻ ���� */
	var host = self.location.host;				// ip:port
	var app = "myapp";							// WebApplication ��.
	var wasRoot = "/usr/tomcat/webapps/";		// WAS WebRoot
	var url = "http://" + host + (app==""?"":("/" + app));	// WebApplication URL.

	/* ȯ�� ���� ���� */
	var file_url = url + "/ubireport/";	// ����Ʈ���� ���Ǵ� �̹��� �Ǵ� ���� ������ ������ ������������ ����.
	var form_url = url + "/UbiForm";			// Form Servlet URL
	var data_url = url + "/UbiData";			// Data Servlet URL
	var jrf_dir = wasRoot+app+"/ubireport/work/";	// ����Ʈ ���� ���.
	var jrf = "ubi_sample.jrf";					// ����Ʈ���ϸ�.
	var ds  = "jdbc/tutorial";					// ����Ÿ�ҽ���.
	var scale = "120";							// �ʱ� ����
	var is_deflater = "true";					// �������� ��� �ɼ� (ubigateway.property�� �Ӽ��� ���ƾ���).
	var is_base64 = "true";						// �������� ��� �ɼ� (ubigateway.property�� �Ӽ��� ���ƾ���).
	var is_unicode = "false";					// �������� ��� �ɼ� (ubigateway.property�� �Ӽ��� ���ƾ���).
	var utf_data = "false";						// �������� ��� �ɼ� (ubigateway.property�� �Ӽ��� ���ƾ���).

	var w_gap = 12;	// ���� ũ�� ����.
	var h_gap = 12;	// ���� ũ�� ����.

	function getArg() {			// �ƱԸ�Ʈ �� ����. �ڵ� ȣ��.
	
		var args = 'arg1#arg1_value1#arg2#arg2_value#...#argn#argn_value#';
		return args;
	}

	function Ubi_Resize() {		// ������ �������� �� ������Ʈ ũ�� ����.

		var w = ((self.innerWidth || (document.documentElement && document.documentElement.clientWidth) || document.body.clientWidth)) - w_gap;
		var h = ((self.innerHeight || (document.documentElement && document.documentElement.clientHeight) || document.body.clientHeight)) - h_gap;
		document.getElementById("UbiViewer").width = w + 'px';
		document.getElementById("UbiViewer").height = h + 'px';
	}

	function Ubi_Version() {	// ��� ���� Ȯ�ο�

		var nl = Ubi_isIE?"\n":"\\n";
		Alert('Plugin : ' + Ubi_Object.GetVersion() + nl + nl + 'OCX : ' + document.getElementById('UbiViewer').GetOcxVersion() + '(' + Ubi_ActiveXEdition() + ')');
	}

//-->
</script>
</head>
<body style='margin:3px' onresize="Ubi_Resize()">
<script type="text/javascript">
<!--

	if( Ubi_PluginCheck() ) {

		var w = ((self.innerWidth || (document.documentElement && document.documentElement.clientWidth) || document.body.clientWidth)) - w_gap;
		var h = ((self.innerHeight || (document.documentElement && document.documentElement.clientHeight) || document.body.clientHeight)) - h_gap;

		document.write("<object id='UbiViewer' type='" + Ubi_PluginType() + "' width='" + w + "px' height='" + h + "px'>");
		document.write("	<param name='ocxtype'				value='" + Ubi_ActiveXEdition() + "'>");
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
		document.write("</object>");
	}

//-->
</script>
</body>
</html>