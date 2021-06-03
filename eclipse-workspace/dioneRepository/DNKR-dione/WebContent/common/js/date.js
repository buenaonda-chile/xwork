/**
 * �˾� 
 */
function open_Window1( url, openwindow ,width ,height, left, top, scrollbars, status){

	var temp = eval("'" + "width="+ width +",height=" + height +",left=" + left +",top=" + top +",status=" + status + ",scrollbars=" + scrollbars + ",resiable=true,menubar=no" + "'") ;

	w_remote = window.open( url, openwindow, temp );

	if ( w_remote.opener == null )
		w_remote.opener = window;

}

/**
 * �����˾� 
 */
function open_Window2(title, seq, openwindow, design, width ,height, left, top, scrollbars, status){
	if(width==0)width=1;
	if(height==0)height=1;
	var temp = eval("'" + "width="+ width +",height=" + height +",left=" + left +",top=" + top +",status=" + status + ",scrollbars=" + scrollbars + ",resiable=true,menubar=no" + "'") ;

	w_remote1 = window.open( "/dcguser/common/mainPop.jsp?seq="+seq+"&design="+design+"&title="+title+"&height="+height, openwindow, temp );

	if ( w_remote1.opener == null )
		w_remote1.opener = window;

}