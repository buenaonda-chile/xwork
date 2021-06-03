﻿﻿﻿﻿﻿var upload_packetSize = 4096000; //1048576;
var download_packetSize = 1048576;

/*====================================================================
= 기능 : File 생성 (Write)
= 인수 : file_url			file Path
				 str_param		Parameter (Cookie)
				 nRow					Dataset Row Position 
				 strCol				Column ID (Progress 설정)
				 objState			Progress 표시 Grid
= Return : Result/Message/file Size				 
=====================================================================*/
function gfn_FileWrite(httpfileObj,file_url, str_param, nRow, strCol, objState){
	var rtn_arr = Array(3);
	rtn_arr[0] = "FAIL";

	if (length(file_url) < 7) {
		rtn_arr[1] = "Not Found Seleced File!";
		return rtn_arr;
	}
	
	if (length(str_param) < 1){
		rtn_arr[1] = "Not Found CookieParam!";
		return rtn_arr;
	} 

	
	var write_size;
	var tot_write_size;
	var file_size;
	
	// Spring Controller를 이용하기위해 .do주소이용
	// (SampleController의 bigFileUload메소드 호출
	//remote_url = "http://10.72.209.23/pscomlib/bigFileUload.do";
	remote_url = G_baseURL+ "pscomlib/bigFileUload.do";

	file_size = httpfileObj.GetFileSizeLocal(file_url);
	
	trace("파일사이즈" + file_size);
	
	//사이즈 체크(5MB제한)
	// if(file_size > 5000000){
		// alert("업로드 가능 용량은 5MB입니다. 확인하고 다시 시도해주십시오.");
		// return;
	// }
	
	//JAVA Controller에 파일명 전달위해 객체의 CookieParam에 설정, 한글처리:UrlEncode()
	httpFileObj.CookieParam = UrlEncode(str_Param);	

	trace("넘겨주는 파일명: " + httpfileObj.CookieParam);
	trace("서버주소(Java Cotroller) : " + remote_url);
	trace("경로(파일명포함) : " + file_url);

	//Java Controller 호출
	ret = httpfileObj.OpenFile(remote_url, file_url, "PUT");

	trace("ret : " + ret);
	
	//호출 후 처리 리턴값 체크
	if( ret < 0 )	{
		rtn_arr[0] = "FAIL";
		rtn_arr[1] = "OpenFile Failed :: " + httpfileObj.ErrorMsg;
		return rtn_arr;
	}

    //이하의 처리 설명 생략
	if (IsValidObject(objState)){
		var objDs = objState.BindDataset;
		var readpercent;
		object(objDs).SetColumn(nRow, "filesize",round(file_size/1024)); 

		while(1) {
			write_size = httpfileObj.WriteFile(upload_packetSize);
			
			trace(write_size);
			
			tot_write_size += write_size;
			
			readpercent = truncate((tot_write_size / file_size) * 100,1);
			
			object(objDs).SetColumn(nRow, strCol, readpercent); 
			object(objDs).SetColumn(nRow, "progsize",round(tot_write_size/1024)); 
			
			if( write_size < upload_packetSize )	break;
		}
		
	} else {
		while(1)	{
			write_size = httpfileObj.WriteFile(upload_packetSize);	
			if( write_size < upload_packetSize )	break;
		}
	}

	httpfileObj.CloseFile();

	if (isExistVar("objState",true)){
		if ( write_size == -1 )	{
			rtn_arr[0] = "FAIL";
			rtn_arr[1] = httpfileObj.ErrorMsg;
			return rtn_arr;
		}
	}

	var rtn_val = httpfileObj.CookieParam;

	var str_sp = split2(rtn_val,";","=");
	var tmp_a;
	
	for ( var i = 0 ; i < str_sp.length() ; i++ )
	{
		tmp_a = str_sp[i];
		if ( tmp_a[0].pos("FileParam") > -1 )
		{
			rtn_arr[0] = left(tmp_a[1],4);
			rtn_arr[1] = right(tmp_a[1], length(tmp_a[1]) -6);
		}	
	}	
	
	trace("return : " + rtn_arr);
	
	return rtn_arr;
}

/*====================================================================
= 기능 : File Read
= 인수 : file_url			file Path
				 str_cookie		Cookie (parameter)
				 str_size			File Size
				 nRow					Dataset Row Position
				 strCol				Column ID (progress 설정)
				 objState			progress 설정 Grid
= Return : Result/Message/file Size				 
=====================================================================*/
function gfn_FileRead(httpfileObj,file_url, str_cookie, str_size, nRow, strCol, objState){
	  trace("file_url::"+file_url);
	  trace("str_cookie::"+str_cookie);
	  trace("str_size::"+str_size);
	var rtn_arr = Array(2);
	rtn_arr[0] = "FAIL";

	if (length(quote(file_url)) < 7) {
		rtn_arr[1] = "Not Found Seleced File!";
		return rtn_arr;
	}
	
	if (length(quote(str_cookie)) < 1){
		rtn_arr[1] = "Not Found CookieParam!";
		return rtn_arr;
	}

	if (length(quote(str_size)) < 1 || str_size == 0){
		rtn_arr[1] = "Not Found File Size!";
		return rtn_arr;
	}

	// Spring Controller를 이용하기위해 .do주소이용
	// (SampleController의 bigFileDownload메소드 호출
	//remote_url = "http://10.72.209.23/pscomlib/bigFileDownload.do";
	//remote_url = G_baseURL+ "pscomlib/bigFileUload.do";
	remote_url = G_baseURL+ "pscomlib/bigFileDownload.do";
	
	var read_size;
	var tot_read_size;
	var file_size;

	//JAVA Controller에 파일명 전달위해 객체의 CookieParam에 설정, 한글처리:UrlEncode()
	httpFileObj.CookieParam = UrlEncode(str_cookie);
	
	file_size = str_size;
	trace("서버주소(Java Cotroller):"+remote_url);	
	trace("경로(파일명포함) :"+file_url);
	
	//Java Controller 호출
	ret = httpfileObj.OpenFile(remote_url, file_url, "GET");
	
	//호출 후 처리 리턴값 체크
	if( ret < 0 ) {
		rtn_arr[0] = "FAIL";
		rtn_arr[1] = "OpenFile Fail ::" + httpfileObj.ErrorMsg;
		return rtn_arr;
	}
	
	tot_read_size = 0;	

	//이하의 처리 설명 생략
	if (IsValidObject(objState)){
		var objDs = objState.BindDataset;
		var readpercent;

		while(1) {
			read_size = httpfileObj.ReadFile(download_packetSize);
            
            trace(read_size);
			
			tot_read_size += read_size;
			
			readpercent = truncate((toNumber(tot_read_size) / toNumber(file_size)) * 100,1);
			
			object(objDs).SetColumn(nRow, strCol, readpercent); 
			
			if( (read_size == 0) || ( read_size == -1) ) break;
		}
		
	} else {
		while(1) {
			read_size = httpfileObj.ReadFile(download_packetSize);
			if( (read_size == 0) || ( read_size == -1) ) break;
		}
	}
	
	httpfileObj.CloseFile();
	
	if ( read_size == -1 )	{
		rtn_arr[0] = "FAIL";
		rtn_arr[1] = httpfileObj.ErrorMsg;
		return rtn_arr;
	}
	
	var rtn_val = httpfileObj.CookieParam;
	var str_sp = split2(rtn_val,";","=");
	var tmp_a;
	
	for ( var i = 0 ; i < str_sp.length() ; i++ )
	{
		tmp_a = str_sp[i];
		if ( tmp_a[0].pos("FileParam") > -1 )
		{
			rtn_arr[0] = left(tmp_a[1],4);
			rtn_arr[1] = right(tmp_a[1], length(tmp_a[1]) -6);
		}	
	}	
	
	return rtn_arr;
}
