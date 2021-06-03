
<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>UbiReport Preview</title>
<!--[if IE]><script src="/myapp/ubireport/ajax/js4/excanvas.js"></script><![endif]-->
<script src="/ubireport/ajax/js4/ubiajax.js"></script>
<script language='javascript'>
<!--

	/* �⺻ ���� */
	var host = self.location.host;							// ip:port
	var app = "";										// WebApplication ��.
	var url = "http://" + host + (app==""?"":("/" + app));	// WebApplication URL.

	/* ȯ�� ���� ���� */
	var key = "key";													// ����� ���� ������ ��. �Ϲ������� JSP���� session.getId() ���.
	var jrf = "test.jrf";											// ����Ʈ���ϸ�.
	var arg = "arg1#arg1_value1#arg2#arg2_value#...#argn#argn_value#";	// �ƱԸ�Ʈ
	var res_id = "UBIAJAX";												// ubidaemon.property�� ��ϵ� ���ҽ� ���̵�.
	var viewer_id = "UbiAjaxViewer";									// ��� DIV ���̵�.
	var scale = "120";													// ���� �̸����� ����.
	var timeout = "600000";												// ����ð� Ÿ�Ӿƿ�(1��).

	var w_gap = 12; // ���� ũ�� ����.
	var h_gap = 12; // ���� ũ�� ����.

	function Ubi_Resize() { // ������ �������� �� ������Ʈ ũ�� ����.

		var w = ((self.innerWidth || (document.documentElement && document.documentElement.clientWidth) || document.body.clientWidth)) - w_gap;
		var h = ((self.innerHeight || (document.documentElement && document.documentElement.clientHeight) || document.body.clientHeight)) - h_gap;
		document.getElementById(viewer_id).style.width = w + 'px';
		document.getElementById(viewer_id).style.height = h + 'px';
	}

	function Ubi_LoadReport() {// ����Ʈ �ε�.

		var w = ((self.innerWidth || (document.documentElement && document.documentElement.clientWidth) || document.body.clientWidth)) - w_gap;
		var h = ((self.innerHeight || (document.documentElement && document.documentElement.clientHeight) || document.body.clientHeight)) - h_gap;
		document.getElementById(viewer_id).style.width = w + 'px';
		document.getElementById(viewer_id).style.height = h + 'px';

		var viewer = new UbiViewer( {

			key       : '<%= session.getId() %>',
			gatewayurl: url + '/UbiGateway',
			resource  : url + '/ubireport/ajax/js4',
			jrffile   : jrf,
			arg       : arg,
			resid     : res_id,
			divid     : viewer_id,
			scale     : scale,
			scrollpage : 'true',
			isstreaming : 'true',
			timeout   : timeout,
			toolbar   : 'false'
			
		});
		viewer.showReport();
	}

//-->
</script>
</head>
<body style='margin:3px' onresize='Ubi_Resize()'>
<div id="UbiAjaxViewer" style="border: solid 1px #aaa; position:relative;"></div>
<script>Ubi_LoadReport();</script>
</body>
</html>
