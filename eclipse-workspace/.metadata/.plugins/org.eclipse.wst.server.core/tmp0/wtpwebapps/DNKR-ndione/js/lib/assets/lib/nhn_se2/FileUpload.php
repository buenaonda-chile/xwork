<?php
require_once $_SERVER['DOCUMENT_ROOT']."/boss/common/config.php";
$process = new DeverProcess;
$url	 = $_REQUEST["callback"] .'?callback_func='. $_REQUEST["callback_func"];
$extArr = array("jpg","gif","png","bmp");
$saveDir= ROOT."/data/nhn_se2_photo/";
if(is_uploaded_file($_FILES['up_file']['tmp_name'])==true){
	$returnStr = checkFileExt($_FILES['up_file']['name'],$extArr);
	if($returnStr==true){
		$rname  = $_FILES['up_file']['name'];
		$sname  = returnFileName($rname,$saveDir);
		$fsize  = $_FILES['up_file']['size'];
		$ftype  = $_FILES['up_file']['type'];
		move_uploaded_file($_FILES['up_file']['tmp_name'],$saveDir.$sname);
		clearstatcache();
		/*
		if($ftype=="image/pjpeg" or $ftype=="image/jpeg" or $ftype=="image/gif" or $ftype=="image/png"):
			sumNail($sname,$saveDir,$saveDir."thumb/",120,80);
		endif;
		*/
	    $sql = "insert into photofile (sname,rname,size,type)";
	    $sql.= " values (";
	    $sql.= "'".$sname."'";
	    $sql.= ",'".$rname."'";
	    //$sql.= ",'".iconv("UTF-8","EUC-KR",$rname)."'";
	    $sql.= ",'".$fsize."'";
	    $sql.= ",'".$ftype."')";
	    $process->sql = $sql;
	    $ret = $process->query();

	    if(!$ret):
			$url .= '&errstr=error';
		else:
			$url .= "&sFileName=".$rname."&sFileURL=/data/nhn_se2_photo/".$sname."&bNewLine=true";
		endif;
 
	}else{
			$url .= '&errstr=error';
	}
}else{
			$url .= '&errstr=error';
}
 

header('Location: '. $url);

?>
 