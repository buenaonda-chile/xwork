var pdfInstallerUrl="";var UbiDaemon_Validation=false;var exportSeq;var _isFF=false;var _isIE=false;var _isChrome=false;var _isOpera=false;var _isKHTML=false;var _isMacOS=false;var _isIE6=false;var _isIE7=false;var _isIE8=false; var _isIE9=false; var _isIE10=false;var _isMobile=false;var mobileKeyWords=new Array('iPhone', 'iPod', 'iPad', 'BlackBerry', 'Android', 'Windows CE', 'LG', 'MOT', 'SAMSUNG', 'SonyEricsson');for (var word in mobileKeyWords) { if( navigator.userAgent.match(mobileKeyWords[word]) != null ) { _isMobile=true; break; }};if (navigator.userAgent.indexOf('Macintosh')!= -1) _isMacOS=true;if ((navigator.userAgent.indexOf('Safari')!= -1)||(navigator.userAgent.indexOf('Konqueror') != -1)) { var _KHTMLrv=parseFloat(navigator.userAgent.substr(navigator.userAgent.indexOf('Safari')+7, 5)); if (_KHTMLrv > 525) { _isFF=true; var _FFrv=1.9; } else _isKHTML=true;}else if (navigator.userAgent.indexOf('Opera')!= -1) { _isOpera=true; _OperaRv=parseFloat(navigator.userAgent.substr(navigator.userAgent.indexOf('Opera')+6, 3));}else if (navigator.appName.indexOf("Microsoft")!= -1) { _isIE=true; if (navigator.appVersion.indexOf("MSIE 10.0")!= -1 && document.compatMode != "BackCompat") _isIE10=true; if (navigator.appVersion.indexOf("MSIE 9.0")!= -1 && document.compatMode != "BackCompat") _isIE9=true; if (navigator.appVersion.indexOf("MSIE 8.0")!= -1 && document.compatMode != "BackCompat") _isIE8=true; if (navigator.appVersion.indexOf("MSIE 7.0")!= -1) _isIE7=true;}else { _isFF=true; var _FFrv=parseFloat(navigator.userAgent.split("rv:")[1]);};if (_isIE) { _isIE6=(window.XMLHttpRequest==null?true:false);};function checkPdfReader() { var obj=null; if( window.ActiveXObject ) { try { obj=new ActiveXObject("AcroPDF.PDF"); if( obj != null ) return true; } catch(e){ try { obj=new ActiveXObject("PDF.PdfCtrl"); if( obj != null ) return true; } catch(e1) { } } } else { var nav=navigator.plugins; for ( var i=0; i < nav.length; i++) { var name=nav[i].name; if( name.indexOf("Adobe Reader") != -1 || name.indexOf("Adobe PDF") != -1 || name.indexOf("Acrobat") != -1 || name.indexOf("Chrome PDF") != -1 ) { return true; } } } return false;}var UbiViewer=Base.extend({ key: "", page: 0, totalpage: 0, constructor: function(params) { function createKey(key) { return params.jrffile.split('.')[0] + "_" + key; }; function printHTML(viewer) { viewer.divPrint.innerHTML="<iframe id='printFrame'><html><body>"+ viewer.divPreviewPage.innerHTML +"</body></html></ifrmae>"; }; this.params={ reqtype: "0", imageid: "", div: params.div || document.getElementById(params.divid), key: params.key || "", gatewayurl: params.gatewayurl || "", timeout: params.timeout || "60000", jrffile: params.jrffile || "", resid: params.resid || "", arg: params.arg || "", ismultireport: params.ismultireport || "false", multicount: params.multicount || "1", exportseq: params.exportseq || "", reporttitle: params.reporttitle || "", sheetname: params.sheetname || "", toolbar: params.toolbar || "true", resource: params.resource || "", divid: params.divid || params.div.id, skin: params.skin || "ubi_standard", scale: params.scale || "100", isencrypt: params.isencrypt || "false" }; page=1; totalpage=0; var params=this.params; this.divMain=null; this.divPreviewFrame=null; this.divPreview=null; this.divPreviewPage=null; this.divCanvas=null; this.divPrint=null; this.divLoading=null; this.toolbar=null; this.ubidocument=null; this.divMsg=null; this.divDownload=null; this.divMain=params.div; var divMain=this.divMain; var divMainWidth= divMain.style.width; var divMainHeight=divMain.style.height; if( divMain.style.width.indexOf("%") != -1 ) { divMain.style.width=(parseInt(windowWidth() * parseInt(divMain.style.width) / 100)) + "px"; } if( divMain.style.height.indexOf("%") != -1 ) { divMain.style.height=(parseInt(windowHeight() * parseInt(divMain.style.height) / 100)) + "px"; } if( divMainWidth.length == 0 ) divMain.style.width=(windowWidth() - 2 ) + "px"; if( divMain.style.marginLeft != "" ) divMain.style.width=parseInt(divMain.style.width) - parseInt(divMain.style.marginLeft) + "px"; if( divMainHeight.length == 0 ) { if( params.toolbar == "true" ) divMain.style.height=(windowHeight() - 31) + "px"; else divMain.style.height=(windowHeight() - 0) + "px"; } if( divMain.style.marginTop != "" ) divMain.style.height=parseInt(divMain.style.height) - parseInt(divMain.style.marginTop) + "px"; divMain.style.textAlign="center"; this.divPreviewFrame=document.createElement("div"); var divPreviewFrame=this.divPreviewFrame; divPreviewFrame.id=params.divid + "_previewFrame"; divPreviewFrame.style.backgroundColor="#f3f3f3"; divPreviewFrame.style.position="relative"; divPreviewFrame.style.margin="0px"; divPreviewFrame.style.padding="0px"; divPreviewFrame.style.width="100%"; divPreviewFrame.style.height=divMain.style.height; divPreviewFrame.style.overflow="auto"; var divToolbar=null; if( params.toolbar == "true" ) { divToolbar=document.createElement("div"); divToolbar.id=params.divid + "_toolbar"; divMain.appendChild(divToolbar); this.toolbar=new PreviewToolbar({viewer:this, divid:divToolbar.id, skin:params.skin, scale:params.scale}); divMain.style.height=(parseInt(divMain.style.height) + 31) + "px"; } else { divPreviewFrame.style.height=(parseInt(divPreviewFrame.style.height) + 31) + "px"; } divMain.appendChild(divPreviewFrame); this.divPreview=document.createElement("div"); var divPreview=this.divPreview; divPreview.id=params.divid + "_preview"; divPreview.style.borderTop="1px solid #ccc"; divPreview.style.borderLeft="1px solid #ccc"; divPreview.style.borderRight="2px solid #bbb"; divPreview.style.borderBottom="2px solid #bbb"; divPreview.style.backgroundColor="#ffffff"; divPreview.style.marginTop="10px"; divPreview.style.marginRight="auto"; divPreview.style.marginBottom="10px"; divPreview.style.marginLeft="auto"; divPreview.style.position="relative"; divPreview.style.width="595px"; divPreview.style.height="842px"; divPreview.style.overflow="hidden"; divPreviewFrame.appendChild(divPreview); this.divPreviewPage=document.createElement("div"); var divPreviewPage=this.divPreviewPage; divPreviewPage.id=params.divid + "_previewPage"; divPreviewPage.style.position="relative"; divPreviewPage.style.marginLeft="58px"; divPreviewPage.style.marginRight="58px"; divPreviewPage.style.marginTop="58px"; divPreviewPage.style.marginBottom="58px"; divPreviewPage.style.width=(595-58*2)+"px"; divPreviewPage.style.height=(842-58*2)+"px"; divPreview.appendChild(divPreviewPage); this.divPrint=document.createElement("div"); var divPrint=this.divPrint; divPrint.id=params.divid + "_print"; divPrint.style.display="none"; divMain.appendChild(divPrint); this.divDownload=document.createElement("div"); var divDownload=this.divDownload; divDownload.id=params.divid + "_download"; divDownload.style.display="none"; divMain.appendChild(divDownload); this.divMsg=document.createElement("div"); var divMsg=this.divMsg; divMsg.id=params.divid + "_msg"; divMsg.style.display="none"; var msgWidth=380; var msgHeight=122; if(pdfInstallerUrl == "") msgWidth=350; divMsg.style.left=(parseInt(this.divMain.style.width) - msgWidth) / 2 + "px"; divMsg.style.top=(parseInt(this.divMain.style.height) - msgHeight) / 2 + "px"; divMsg.style.width=(msgWidth + "px"); divMsg.style.height=(msgHeight + "px"); divMsg.style.margin="0 auto"; divMsg.style.fontFamily="Tahoma"; divMsg.style.fontSize="11px"; divMsg.style.display="none"; divMsg.style.position="absolute"; divMsg.style.backgroundColor="#f3f3f3"; divMsg.style.borderTop="2px solid #000000"; divMsg.style.borderLeft="2px solid #000000"; divMsg.style.borderRight="2px solid #000000"; divMsg.style.borderBottom="2px solid #000000"; divMain.appendChild(divMsg); this.divLoading=document.createElement("div"); var divLoading=this.divLoading; divLoading.style.top=(parseInt(divMain.style.height) - 55)/2 + 'px'; divLoading.style.left=(parseInt(divMain.style.width) - 54)/2 + 'px'; divLoading.style.margin="0 auto"; divLoading.style.fontFamily="Tahoma"; divLoading.style.fontSize="11px"; divLoading.style.display="none"; divLoading.style.position="absolute"; var loading=""; loading += "<table cellspacing='0' width='32px' height='32px'><tr>\n"; loading += "<td align='absmiddle'><center><img src='" + params.resource + "/images/page_loading.gif' width='54px' height='55px'></center></td>\n"; loading += "</tr></table>\n"; divLoading.innerHTML=loading; divMain.appendChild(divLoading); }, printPDF: function(viewer, tp) { var url=viewer.params.gatewayurl + "?reqtype=2&jrffile="+viewer.params.jrffile+"&resid="+viewer.params.resid+"&key="+viewer.params.key+"&arg=&pagenum=&imageid=&exportseq=" + exportSeq; var pdf_version="0"; var view_msg=false; if( _isIE ) { if( checkPdfReader() ) { viewer.divPrint.style.display=""; viewer.divPrint.innerHTML="<object classid='CLSID:CA8A9780-280D-11CF-A24D-444553540000' id='UbiPdfDoc' type='application/pdf' style='width:0px;height:0px'></object>"; pdf_version=document.UbiPdfDoc.getVersions(); pdf_version=pdf_version.substring(pdf_version.indexOf('=')+1, pdf_version.indexOf('.')); } else { view_msg=true; } if( !view_msg ) { if( _isIE10 ) { if( parseInt(pdf_version) <= 9 ) { view_msg=true; } } else { if( parseInt(pdf_version) <= 6 ) { view_msg=true; } } } if( view_msg ) { if( viewer.divMsg.style.display == "none" ) { var msg; var msgWidth=380; var msgHeight=122; if(pdfInstallerUrl == "") msgWidth=350; if( pdfInstallerUrl == "" ) { msg="<table cellspacing='0' width='" + msgWidth + "px' height='" + msgHeight + "px' style='margin:0; padding:0px; border;1px solid #000000;' background='" + viewer.params.resource + "/images/background.png'>"; msg += " <tr>"; msg += " <td height='14px' align='right' colspan='2'>"; msg += " <img src='"+viewer.params.resource+"/images/close.gif' width='13' height='13' onclick='viewer.divMsg.style.display=&quot;none&quot;'>"; msg += " </td>"; msg += " </tr>"; msg += " <tr>"; msg += " <td align='center' width='40' valign='top' style='padding-top:10px'>"; msg += " <img src='"+viewer.params.resource+"/images/pdf.gif' width='32' height='32'>"; msg += " </td>"; msg += " <td style='padding:10px;' align='left' valign='top'>"; if( _isIE10 ) msg += " Under Adobe Reader 9 or is not installed.<br><br>"; else msg += " Under Adobe Reader 6 or is not installed.<br><br>"; msg +=" Please install the latest Adobe Reader from the <b><br><br><a href='http:/"; msg += "/www.adobe.com/reader' target='_blank' style='text-decoration:none; color:red;'>Adobe website</a></b>."; msg += " </td>"; msg += "</tr>"; msg += "</table>"; } else { msg="<table cellspacing='0' width='" + msgWidth + "px' height='" + msgHeight + "px' style='margin:0; padding:0px; border;1px solid #000000;' background='" + viewer.params.resource + "/images/background.png'>"; msg += " <tr>"; msg += " <td align='center' width='40px' valign='top' style='padding-top:5px' rowspan='2'>"; msg += " <img src='" + viewer.params.resource + "/images/pdf.gif' width='32' height='32' align='absmiddle'>"; msg += " </td>"; msg += " <td style='padding:10px 10px 0px 10px;' align='left' valign='top'>"; if( _isIE10 ) msg += " Under Adobe Reader 9 or is not installed.<br><br>"; else msg += " Under Adobe Reader 6 or is not installed.<br><br>"; msg += " </td>"; msg += " <td align='right' valign='top'>"; msg += " <img src='" + viewer.params.resource + "/images/close.gif' style='cursor:hand' width='13' height='13' onclick='viewer.divMsg.style.display=&quot;none&quot;'>"; msg += " </td>"; msg += " </tr>"; msg += " <tr>"; msg += " <td style='padding:15px 10px 0px 20px;' align='left' valign='top' colspan='2'>"; msg += " 1. Please install the latest Adobe Reader from the <b><br><br><a href='http:/"; msg += "/www.adobe.com/reader' target='_blank' style='text-decoration:none; color:red;'><b>Adobe website.</a></b><br><br>"; msg += " 2. You have to <a onclick='viewer.download(viewer, 1);' style='text-decoration:none; color:red; cursor:hand'><b>download</b></a> the Abode Reader installation file. And then, you directly install it.<br><br>"; msg += " 3. If you use the others Reader except for Adobe Reader, you should save as the <a onclick='viewer.download(viewer, 2);' style='text-decoration:none; color:red; cursor:hand'><b>PDF file</b></a>."; msg += " </td>"; msg += " </tr>"; msg += "</table>"; } viewer.divMsg.innerHTML=msg; } viewer.divMsg.style.display=""; } else { document.getElementById('UbiPdfDoc').src=url; if( tp == 'Y' ) document.getElementById('UbiPdfDoc').printAll(); else document.getElementById('UbiPdfDoc').printWithDialog(); } } else { window.open('', 'Ubi_PDF','menubar=no,toolbar=no,status=no,scrollbars=no'); var postUrl="<form name='pdfForm' method='post' action='" + viewer.params.gatewayurl + "#toolbar=1' target='Ubi_PDF'>"; postUrl += "<input type='hidden' name='reqtype' value='2'>"; postUrl += "<input type='hidden' name='jrffile' value='" + viewer.params.jrffile + "'>"; postUrl += "<input type='hidden' name='resid' value='" + viewer.params.resid + "'>"; postUrl += "<input type='hidden' name='key' value='" + viewer.params.key + "'>"; postUrl += "<input type='hidden' name='daemonid' value='" + viewer.ubidocument.doc.daemonid + "'>"; postUrl += "<input type='hidden' name='exportseq' value='" + exportSeq + "'>"; postUrl += "</form>"; viewer.divPrint.innerHTML=postUrl; document.pdfForm.submit(); } }, download: function(viewer, id) { var innerHtml="<iframe name='UbiDownloadFrame' width='1' height='1' frameborder='0' scrolling='no'></iframe>"; if( id == "1") { innerHtml += "<form name='UbiDownloadForm' method='post' action='" + pdfInstallerUrl + "' target='UbiDownloadFrame'>"; innerHtml += "</form>"; } else if( id == "2") { innerHtml += "<form name='UbiDownloadForm' method='post' action='" + viewer.params.gatewayurl + "' target='UbiDownloadFrame'>"; innerHtml += "<input type='hidden' name='reqtype' value='11'>"; innerHtml += "<input type='hidden' name='jrffile' value='" + viewer.params.jrffile + "'>"; innerHtml += "<input type='hidden' name='resid' value='" + viewer.params.resid + "'>"; innerHtml += "<input type='hidden' name='key' value='" + viewer.params.key + "'>"; innerHtml += "<input type='hidden' name='daemonid' value='" + viewer.ubidocument.doc.daemonid + "'>"; innerHtml += "<input type='hidden' name='reporttitle' value='" + viewer.params.reporttitle + "'>"; innerHtml += "<input type='hidden' name='exportseq' value='" + exportSeq + "'>"; innerHtml += "</form>"; } viewer.divDownload.innerHTML=innerHtml; document.UbiDownloadForm.submit(); }, exportPDF: function(viewer) { var innerHtml="<iframe name='UbiExportFrame' width='1' height='1' frameborder='0' scrolling='no'></iframe>"; innerHtml += "<form name='UbiExprotForm' method='post' action='" + viewer.params.gatewayurl + "' target='UbiExportFrame'>"; innerHtml += "<input type='hidden' name='reqtype' value='11'>"; innerHtml += "<input type='hidden' name='jrffile' value='" + viewer.params.jrffile + "'>"; innerHtml += "<input type='hidden' name='resid' value='" + viewer.params.resid + "'>"; innerHtml += "<input type='hidden' name='key' value='" + viewer.params.key + "'>"; innerHtml += "<input type='hidden' name='daemonid' value='" + viewer.ubidocument.doc.daemonid + "'>"; innerHtml += "<input type='hidden' name='reporttitle' value='" + viewer.params.reporttitle + "'>"; innerHtml += "<input type='hidden' name='exportseq' value='" + exportSeq + "'>"; innerHtml += "</form>"; viewer.divDownload.innerHTML=innerHtml; document.UbiExprotForm.submit(); }, exportRtf: function(viewer) { var innerHtml="<iframe name='UbiExportFrame' width='1' height='1' frameborder='0' scrolling='no'></iframe>"; innerHtml += "<form name='UbiExprotForm' method='post' action='" + viewer.params.gatewayurl + "' target='UbiExportFrame'>"; innerHtml += "<input type='hidden' name='reqtype' value='14'>"; innerHtml += "<input type='hidden' name='jrffile' value='" + viewer.params.jrffile + "'>"; innerHtml += "<input type='hidden' name='resid' value='" + viewer.params.resid + "'>"; innerHtml += "<input type='hidden' name='key' value='" + viewer.params.key + "'>"; innerHtml += "<input type='hidden' name='daemonid' value='" + viewer.ubidocument.doc.daemonid + "'>"; innerHtml += "<input type='hidden' name='reporttitle' value='" + viewer.params.reporttitle + "'>"; innerHtml += "<input type='hidden' name='exportseq' value='" + exportSeq + "'>"; innerHtml += "</form>"; viewer.divDownload.innerHTML=innerHtml; document.UbiExprotForm.submit(); }, exportExcel1: function(viewer) { var innerHtml="<iframe name='UbiExportFrame' width='1' height='1' frameborder='0' scrolling='no'></iframe>"; innerHtml += "<form name='UbiExprotForm' method='post' action='" + viewer.params.gatewayurl + "' target='UbiExportFrame'>"; innerHtml += "<input type='hidden' name='reqtype' value='12'>"; innerHtml += "<input type='hidden' name='jrffile' value='" + viewer.params.jrffile + "'>"; innerHtml += "<input type='hidden' name='resid' value='" + viewer.params.resid + "'>"; innerHtml += "<input type='hidden' name='key' value='" + viewer.params.key + "'>"; innerHtml += "<input type='hidden' name='daemonid' value='" + viewer.ubidocument.doc.daemonid + "'>"; innerHtml += "<input type='hidden' name='reporttitle' value='" + encodeURIComponent(viewer.params.reporttitle) + "'>"; innerHtml += "<input type='hidden' name='sheetname' value='" + encodeURIComponent(viewer.params.sheetname) + "'>"; innerHtml += "<input type='hidden' name='exportseq' value='" + exportSeq + "'>"; innerHtml += "</form>"; viewer.divDownload.innerHTML=innerHtml; document.UbiExprotForm.submit(); }, exportExcel2: function(viewer) { var innerHtml="<iframe name='UbiExportFrame' width='1' height='1' frameborder='0' scrolling='no'></iframe>"; innerHtml += "<form name='UbiExprotForm' method='post' action='" + viewer.params.gatewayurl + "' target='UbiExportFrame'>"; innerHtml += "<input type='hidden' name='reqtype' value='13'>"; innerHtml += "<input type='hidden' name='jrffile' value='" + viewer.params.jrffile + "'>"; innerHtml += "<input type='hidden' name='resid' value='" + viewer.params.resid + "'>"; innerHtml += "<input type='hidden' name='key' value='" + viewer.params.key + "'>"; innerHtml += "<input type='hidden' name='arg' value='" + viewer.params.arg + "'>"; innerHtml += "<input type='hidden' name='daemonid' value='" + viewer.ubidocument.doc.daemonid + "'>"; innerHtml += "<input type='hidden' name='reporttitle' value='" + encodeURIComponent(viewer.params.reporttitle) + "'>"; innerHtml += "<input type='hidden' name='sheetname' value='" + encodeURIComponent(viewer.params.sheetname) + "'>"; innerHtml += "</form>"; viewer.divDownload.innerHTML=innerHtml; document.UbiExprotForm.submit(); }, exportHwp: function(viewer) { var innerHtml="<iframe name='UbiExportFrame' width='1' height='1' frameborder='0' scrolling='no'></iframe>"; innerHtml += "<form name='UbiExprotForm' method='post' action='" + viewer.params.gatewayurl + "' target='UbiExportFrame'>"; innerHtml += "<input type='hidden' name='reqtype' value='15'>"; innerHtml += "<input type='hidden' name='jrffile' value='" + viewer.params.jrffile + "'>"; innerHtml += "<input type='hidden' name='resid' value='" + viewer.params.resid + "'>"; innerHtml += "<input type='hidden' name='key' value='" + viewer.params.key + "'>"; innerHtml += "<input type='hidden' name='daemonid' value='" + viewer.ubidocument.doc.daemonid + "'>"; innerHtml += "<input type='hidden' name='reporttitle' value='" + viewer.params.reporttitle + "'>"; innerHtml += "<input type='hidden' name='exportseq' value='" + exportSeq + "'>"; innerHtml += "</form>"; viewer.divDownload.innerHTML=innerHtml; document.UbiExprotForm.submit(); }, drawPage: function(page) { this.page=page; var divPreviewPage=this.divPreviewPage; divPreviewPage.innerHTML=""; var doc=this.ubidocument.doc; this.ubidocument.Draw(divPreviewPage, this.page); }, changeScale: function(viewer) { var scale=viewer.params.scale; var exists=false; for( var j=60; j<=300; j+=20 ) { if( scale == j ) { exists=true; break; } } if( !exists ) scale=100; var previewFrameWidth=parseInt(viewer.divPreviewFrame.clientWidth); var previewWidth=parseInt(viewer.divPreview.style.width); var scaleWidth=previewWidth * (scale/100); var leftPos=(previewFrameWidth - scaleWidth - 8) / 2; if( _isIE ) { if( _isIE9 || _isIE10) { viewer.divPreview.style.msTransformOrigin='top'; if( previewFrameWidth < scaleWidth ) { viewer.divPreview.style.msTransform='translate(' + (-1 * leftPos) + 'px) scale(' + (scale/100) + ')'; } else viewer.divPreview.style.msTransform='scale(' + (scale/100) + ')'; } else { viewer.divPreview.style.zoom=(scale/100); } } else { viewer.divPreview.style.WebkitTransformOrigin='top'; viewer.divPreview.style.MozTransformOrigin='top'; viewer.divPreview.style.OTransformOrigin='top'; if( previewFrameWidth < scaleWidth ) { viewer.divPreview.style.WebkitTransform='translate(' + (-1 * leftPos) + 'px) scale(' + (scale/100) + ')'; viewer.divPreview.style.MozTransform='translate(' + (-1 * leftPos) + 'px) scale(' + (scale/100) + ')'; viewer.divPreview.style.OTransform='translate(' + (-1 * leftPos) + 'px) scale(' + (scale/100) + ')'; } else { viewer.divPreview.style.WebkitTransform='scale(' + (scale/100) + ')'; viewer.divPreview.style.MozTransform='scale(' + (scale/100) + ')'; viewer.divPreview.style.OTransform='scale(' + (scale/100) + ')'; } } }, showReport: function() { function createControl(xml, viewer) { var doc=UbiDoc.CreateInstance(xml); viewer.ubidocument=new UbiDocument(doc, viewer.params.jrffile, viewer.params.key, viewer.params.resid, viewer.params.gatewayurl); viewer.divPreview.style.width=doc.docprop.width +"px"; viewer.divPreview.style.height=doc.docprop.height +"px"; viewer.divPreviewPage.style.width=(doc.docprop.width - doc.docprop.marginleft - doc.docprop.marginright) +"px"; viewer.divPreviewPage.style.height=(doc.docprop.height - doc.docprop.margintop - doc.docprop.marginbottom) +"px"; viewer.divPreviewPage.style.marginLeft=doc.docprop.marginleft + "px"; viewer.divPreviewPage.style.marginRight=doc.docprop.marginright + "px"; viewer.divPreviewPage.style.marginTop=doc.docprop.margintop + "px"; viewer.divPreviewPage.style.marginBottom=doc.docprop.marginbottom + "px"; viewer.totalpage=doc.pagecount; if( viewer.params.toolbar == "true" ) { viewer.toolbar.setTotalPage(viewer.totalpage); toolbarobj.setTabIndex("save", "1"); toolbarobj.setTabIndex("print", "2"); toolbarobj.setTabIndex("printset", "3"); toolbarobj.setTabIndex("first", "4"); toolbarobj.setTabIndex("previous", "5"); toolbarobj.setTabIndex("pages", "6"); toolbarobj.setTabIndex("next", "7"); toolbarobj.setTabIndex("last", "8"); toolbarobj.setTabIndex("zoomout", "9"); toolbarobj.setTabIndex("zoom", "10"); toolbarobj.setTabIndex("zoomin", "11"); toolbarobj.setTabIndex("refresh", "12"); if( !_isIE ) toolbarobj.hideItem("printset"); } viewer.drawPage(1); if( viewer.params.toolbar ) viewer.changeScale(viewer); else viewer.toolbar.changeScale(); }; function requestReport(viewer) { ajax({ type: "POST", datatype: "xml", timeout: viewer.params.timeout, url: viewer.params.gatewayurl, reqdata: viewer.params, exportseq: "", onSuccess: function(xml) { UbiDaemon_Validation=true; if (xml == null) { alert("리포트가 생성되지 않았습니다."); } else { createControl(xml, viewer); exportSeq=this.exportseq; } }, onComplete: function() { viewer.divLoading.style.display="none"; }, onError: function(msg) { UbiDaemon_Validation=false; viewer.divLoading.style.display="none"; if( msg.indexOf("ER0") == -1 ) { msg="ER0901#Unknown error. Check UbiGateway URL."; return; } msg=msg.split("#")[0] + " : " + msg.split("#")[1]; alert(msg); } }); }; this.divLoading.style.display=""; requestReport(this); }});var PreviewToolbar=Base.extend({ viewer: null, toolbar: null, toolbarobj: null, divid: "", skin: "", scale: 100, page: 1, totalpage: 1, scaleCount: 0, constructor: function(params) { viewer=params.viewer; divid=params.divid; skin=params.skin; scale=params.scale; toolbar=this; toolbarobj=new dhtmlXToolbarObject(divid, skin); toolbarobj.setIconsPath(viewer.params.resource + "/images/toolbar/"); toolbarobj.loadXML(viewer.params.resource + "/css/toolbar.xml", onLoadFunction); function onLoadFunction() { var scaleIndex=0; for( var j=60; j<=300; j+=20 ) { if( scale == j ) scale=scaleIndex; scaleIndex++; toolbarobj.appendOption("zoom", j); } if( scale < 0 || scale > 12 ) scale=2; toolbarobj.setSelectedIndex("zoom", scale); scaleCount=toolbarobj.getCount("zoom"); }; toolbarobj.attachEvent("onClick", function(id) { switch (id) { case "save": break; case "exp_1": if( UbiDaemon_Validation ) viewer.exportPDF(viewer); break; case "exp_2": if( UbiDaemon_Validation ) viewer.exportExcel1(viewer); break; case "exp_3": if( UbiDaemon_Validation ) viewer.exportRtf(viewer); break; case "exp_4": if( UbiDaemon_Validation ) viewer.exportHwp(viewer); break; case "print": if( UbiDaemon_Validation ) viewer.printPDF(viewer, 'Y'); break; case "printset": if( UbiDaemon_Validation ) viewer.printPDF(viewer, 'N'); break; case "first": toolbar.start(); break; case "previous": toolbar.back(); break; case "next": toolbar.forward(); break; case "last": toolbar.end(); break; case "zoomout": toolbar.zoomout(); break; case "zoomin": toolbar.zoomin(); break; case "refresh": toolbar.refresh(); break; default: return false; } }); toolbarobj.attachEvent("onChange", function(id, value) { switch (id) { case "pages": toolbar.changePage(); break; case "zoom": toolbar.changeScale(); break; default: return false; } }); }, initScale: function(scale) { var scaleIndex=0; for( var j=60; j<=300; j+=20 ) { if( scale == j ) scale=scaleIndex; scaleIndex++; } if( scale < 0 || scale > 12 ) scale=2; toolbarobj.setSelectedIndex("zoom", scale); scaleCount=toolbarobj.getCount("zoom"); }, setNaviState: function() { if( page == totalpage ) { toolbarobj.disableItem("next"); toolbarobj.disableItem("last"); } else { toolbarobj.enableItem("next"); toolbarobj.enableItem("last"); } if( page == 1 ) { toolbarobj.disableItem("previous"); toolbarobj.disableItem("first"); } else { toolbarobj.enableItem("previous"); toolbarobj.enableItem("first"); } }, setNaviStateInit: function() { page=1; this.setNaviState(); }, setScaleState: function() { var scaleindex=toolbarobj.getSelectedIndex("zoom"); if( scaleindex == 0 ) { toolbarobj.disableItem("zoomout"); } else { toolbarobj.enableItem("zoomout"); } if( scaleindex == (scaleCount-1) ) { toolbarobj.disableItem("zoomin"); } else { toolbarobj.enableItem("zoomin"); } }, setTotalPage: function(totPage) { totalpage=totPage; this.setNaviState(); for (var i=1; i<=totPage; i++) { toolbarobj.appendOption("pages", i); } }, changeScale: function() { var scale=toolbarobj.getSelectedText("zoom"); var previewFrameWidth=parseInt(viewer.divPreviewFrame.clientWidth); var previewWidth=parseInt(viewer.divPreview.style.width); var scaleWidth=previewWidth * (scale/100); var leftPos=(previewFrameWidth - scaleWidth - 8) / 2; if( _isIE ) { if( _isIE9 || _isIE10) { viewer.divPreview.style.msTransformOrigin='top'; if( previewFrameWidth < scaleWidth ) { viewer.divPreview.style.msTransform='translate(' + (-1 * leftPos) + 'px) scale(' + (scale/100) + ')'; } else viewer.divPreview.style.msTransform='scale(' + (scale/100) + ')'; } else { viewer.divPreview.style.zoom=(scale/100); } } else { viewer.divPreview.style.WebkitTransformOrigin='top'; viewer.divPreview.style.MozTransformOrigin='top'; viewer.divPreview.style.OTransformOrigin='top'; if( previewFrameWidth < scaleWidth ) { viewer.divPreview.style.WebkitTransform='translate(' + (-1 * leftPos) + 'px) scale(' + (scale/100) + ')'; viewer.divPreview.style.MozTransform='translate(' + (-1 * leftPos) + 'px) scale(' + (scale/100) + ')'; viewer.divPreview.style.OTransform='translate(' + (-1 * leftPos) + 'px) scale(' + (scale/100) + ')'; } else { viewer.divPreview.style.WebkitTransform='scale(' + (scale/100) + ')'; viewer.divPreview.style.MozTransform='scale(' + (scale/100) + ')'; viewer.divPreview.style.OTransform='scale(' + (scale/100) + ')'; } } this.setScaleState(); }, zoomin: function() { var index=toolbarobj.getSelectedIndex("zoom"); toolbarobj.setSelectedIndex("zoom", ++index); this.changeScale(); }, zoomout: function() { var index=toolbarobj.getSelectedIndex("zoom"); toolbarobj.setSelectedIndex("zoom", --index); this.changeScale(); }, start: function() { page=1; this.movePage(page); }, back: function() { if( page > 1 ) { page--; this.movePage(page); } }, forward: function() { if( page < totalpage ) { page++; this.movePage(page); } }, end: function() { if( page < totalpage ) { page=totalpage; this.movePage(page); } }, changePage: function() { var selpage=toolbarobj.getSelectedText("pages"); if( page != selpage ) { page=selpage; this.movePage(page); } }, movePage: function(page) { viewer.drawPage(page); toolbarobj.setSelectedIndex("pages", page-1); this.setNaviState(); }, refresh: function(page) { toolbarobj.removeOption("pages"); viewer.divPreviewPage.innerHTML=""; viewer.divPrint.innerHTML=""; viewer.showReport(); this.setNaviStateInit(); this.initScale(viewer.params.scale); }});