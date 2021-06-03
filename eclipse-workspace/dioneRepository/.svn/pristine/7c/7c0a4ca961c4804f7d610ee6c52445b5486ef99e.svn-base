﻿﻿﻿﻿﻿﻿﻿﻿/**********************************************************************************************
//                                 Copyright 2006 Tobesoft
// -. 사용 방법
// nWidth,nHeight 는 현재 Form size를 상수값으로 구성해야 함...
// Form  OnLoadCompleted 이벤트에서 Gfn_ResizeInit(nWidth,nHeight); 를 호출하시면 자동으로 Resize 처리가 됩니다.
//   예제
  #include "lib::FormResize.js"
  function form_OnLoadCompleted(obj)
  {
	Gfn_ResizeInit(1024,768);
  }
// -. 주의 사항
// Running 중간에 Component를 Destory하는 처리가 있으면 Resize처리가 오 작동 할 수 있습니다.
// Gfn_ResizeInit();  호출후에 Component 위치 및 size를 조정하면 Resize시에 조정된 위치및 size가 무시됩니다.   
// Tab 인경우 Url Link 처리 되면서 Preload에서 false하면 로드되지 전에 Gfn_ResizeInit하면
// Resize할 Control를 등록하지 못하여 로드되지 않아서 처리가 안되게 되어 있습니다.
**********************************************************************************************/

var fv_nResizeProcCnt = 0;
var fv_FirstResize = false;
var fv_orgWidth;
var fv_orgHeight;

var fv_forgWidth;
var fv_forgHeight;

var fv_ArrHorzPosition = Array();
var fv_ArrVertPosition = Array();


var fv_ArrSubHorzPosition = Array();
var fv_ArrSubVertPosition = Array();
var fv_SubSeq = -1;


var fv_SuborgWidth = Array();
var fv_SuborgHeight = Array();

var fv_SubforgWidth = Array();
var fv_SubforgHeight = Array();

//초기화
function Gfn_ResizeInit_Default(chk_Def, tObj){
	if(chk_Def=false){
			trace("초기화");
		fv_nResizeProcCnt = 0;
		fv_FirstResize = false;
		fv_orgWidth= 0;
		fv_orgHeight= 0;
		fv_forgWidth= 0;
		fv_forgHeight= 0;
		
		fv_ArrHorzPosition = Array();
		fv_ArrVertPosition =  Array();
			
		fv_ArrSubHorzPosition = Array();
		fv_ArrSubVertPosition = Array();
		fv_SubSeq = -1;
		
		
		fv_SuborgWidth  = Array();
		fv_SuborgHeight  = Array();
		
		fv_SubforgWidth  = Array();
		fv_SubforgHeight  = Array();

		//강제조정
		div_content.Top="0";
		div_content.Width="1056";
		div_content.Height="800";
		div_content.Left="0";
		
		tObj.titleBar.Top="0";
		tObj.titleBar.Width="1060";
		tObj.titleBar.Height="28";
		tObj.titleBar.Left="-2";
		
		tObj.title_text.Top="8";
		tObj.title_text.Width="1032";
		tObj.title_text.Height="13";
		tObj.title_text.Left="16";
				
		tObj.Div_LAYOUT_DEF.Top="29";
		tObj.Div_LAYOUT_DEF.Width="911";
		tObj.Div_LAYOUT_DEF.Height="587";
		tObj.Div_LAYOUT_DEF.Left="0";
	/*
		tObj.Div_LAYOUT_DEF.Div_LAYOUT_BOT.Top="551";
		tObj.Div_LAYOUT_DEF.Div_LAYOUT_BOT.Width="911";
		tObj.Div_LAYOUT_DEF.Div_LAYOUT_BOT.Height="32";
		tObj.Div_LAYOUT_DEF.Div_LAYOUT_BOT.Left="0";
					

		tObj.Div_LAYOUT_DEF.Div_LAYOUT_BOT.st_label1.Top="2";
		tObj.Div_LAYOUT_DEF.Div_LAYOUT_BOT.st_label1.Width="148";
		tObj.Div_LAYOUT_DEF.Div_LAYOUT_BOT.st_label1.Height="26";
		tObj.Div_LAYOUT_DEF.Div_LAYOUT_BOT.st_label1.Left="2";
		
		tObj.Div_LAYOUT_DEF.Div_LAYOUT_BOT.st_label2.Top="2";
		tObj.Div_LAYOUT_DEF.Div_LAYOUT_BOT.st_label2.Width="148";
		tObj.Div_LAYOUT_DEF.Div_LAYOUT_BOT.st_label2.Height="26";
		tObj.Div_LAYOUT_DEF.Div_LAYOUT_BOT.st_label2.Left="153";
		
		tObj.Div_LAYOUT_DEF.Div_LAYOUT_BOT.st_label3.Top="2";
		tObj.Div_LAYOUT_DEF.Div_LAYOUT_BOT.st_label3.Width="148";
		tObj.Div_LAYOUT_DEF.Div_LAYOUT_BOT.st_label3.Height="26";
		tObj.Div_LAYOUT_DEF.Div_LAYOUT_BOT.st_label3.Left="304";

		tObj.Div_LAYOUT_DEF.Div_LAYOUT_BOT.st_label4.Top="2";
		tObj.Div_LAYOUT_DEF.Div_LAYOUT_BOT.st_label4.Width="148";
		tObj.Div_LAYOUT_DEF.Div_LAYOUT_BOT.st_label4.Height="26";
		tObj.Div_LAYOUT_DEF.Div_LAYOUT_BOT.st_label4.Left="455";
		
		tObj.Div_LAYOUT_DEF.Div_LAYOUT_BOT.st_label5.Top="2";
		tObj.Div_LAYOUT_DEF.Div_LAYOUT_BOT.st_label5.Width="148";
		tObj.Div_LAYOUT_DEF.Div_LAYOUT_BOT.st_label5.Height="26";
		tObj.Div_LAYOUT_DEF.Div_LAYOUT_BOT.st_label5.Left="606";

		
		tObj.Div_LAYOUT_DEF.Div_LAYOUT_BOT.st_label6.Top="2";
		tObj.Div_LAYOUT_DEF.Div_LAYOUT_BOT.st_label6.Width="148";
		tObj.Div_LAYOUT_DEF.Div_LAYOUT_BOT.st_label6.Height="26";
		tObj.Div_LAYOUT_DEF.Div_LAYOUT_BOT.st_label6.Left="757";
	*/	
		
		Gfn_ResizeInit(911,620);//최종

	}
}

function Gfn_ResizeInit(nWidth,nHeight)
{
	this.OnSize = "Gfn_frm_OnSize";
		
	fv_orgWidth   = nWidth;
	fv_orgHeight  = nHeight;
	fv_forgWidth  = nWidth;
	fv_forgHeight = nHeight;
	var seq = 0;
	for ( var i = 0 ; i < this.Components.Count ; i++ )
	{
		if (  ( this.Components[i].GetType() == "Dataset" ) ||
			  ( this.Components[i].GetType() == "File" ) ||	
			  ( this.Components[i].GetType() == "FileDialog" ) ||	
			  ( this.Components[i].GetType() == "PopupDiv" )
		   )
			continue;
		//alert("id==="+this+"=="+this.Components[i].id);
		fv_ArrHorzPosition[seq] = Components[i].left;
		fv_ArrVertPosition[seq] = Components[i].top;
		seq++;
		fv_ArrHorzPosition[seq] = Components[i].right;
		fv_ArrVertPosition[seq] = Components[i].bottom;
		seq++;
		if ( Components[i].IsComposite() )
		{
			Gfn_SubFormResizeInit(Components[i]);
		}
	}
	
	fv_FirstResize = true;
	Gfn_frm_OnSize(this,this.width,this.height);

}

function Gfn_SubFormResizeInit(obj)
{
	var seq = 0;
	var tmpArrayHorz = Array();
	var tmpArrayVert = Array();
	fv_SubSeq++;
	var subseq = fv_SubSeq;
	fv_SuborgWidth[subseq] = obj.width;
	fv_SuborgHeight[subseq] = obj.height;

	fv_SubforgWidth[subseq] = obj.width;
	fv_SubforgHeight[subseq] = obj.height;
	
	for ( var i = 0 ; i < obj.Components.Count ; i++ )
	{
		if (  ( obj.Components[i].GetType() == "Dataset" ) ||
			  ( obj.Components[i].GetType() == "File" ) ||	
			  ( obj.Components[i].GetType() == "FileDialog" ) ||	
			  ( obj.Components[i].GetType() == "PopupDiv" )
		   )	
			continue;
//trace(obj.Components[i].id);
		tmpArrayHorz[seq] = obj.Components[i].left;
		tmpArrayVert[seq] = obj.Components[i].top;
		seq++;
		tmpArrayHorz[seq] = obj.Components[i].right;
		tmpArrayVert[seq] = obj.Components[i].bottom;
		seq++;
		if ( obj.Components[i].IsComposite() )
		{
			Gfn_SubFormResizeInit(obj.Components[i]);
		}
	}
	fv_ArrSubHorzPosition[subseq] = tmpArrayHorz;
	fv_ArrSubVertPosition[subseq] = tmpArrayVert;	
}

function Gfn_ResizeProc(nCx,nCy)
{
	fv_SubSeq = -1;
	var seq = 0;
	var nWidthRate;
	var nHeightRate;
	var bProcSizeFlag = true;
	for ( var i = 0 ; i < this.Components.Count ; i++ )
	{
		if (  ( this.Components[i].GetType() == "Dataset" ) ||
			  ( this.Components[i].GetType() == "File" ) ||	
			  ( this.Components[i].GetType() == "FileDialog" ) ||	
			  ( this.Components[i].GetType() == "PopupDiv" )
		   )	
			continue;
		
		bProcSizeFlag = true;
		
		if ( this.Components[i].GetType() == "Button" )  bProcSizeFlag = true; // Button Resize
		else if ( this.Components[i].GetType() == "Image" )
		{
			if ( this.Components[i].FillType == "NONE" ) bProcSizeFlag = false;
		}
		
		if ( Components[i].GetType() != "TabPage" )
		{		    
			if ( !bProcSizeFlag ) // 위치를 중앙으로 조정
			{
				nWidthRate  = parseInt( (ToNumber(fv_ArrHorzPosition[seq]) * ToNumber(nCx)) / ToNumber(fv_forgWidth) );
				nHeightRate = parseInt( (ToNumber(fv_ArrVertPosition[seq]) * ToNumber(nCy)) / ToNumber(fv_forgHeight) );
				seq++;
				nWidthRate  = nWidthRate + parseInt( ((ToNumber(fv_ArrHorzPosition[seq]) * ToNumber(nCx)) / ToNumber(fv_forgWidth) - nWidthRate)/2) - parseInt(this.Components[i].Width/2);
				nHeightRate = nHeightRate + parseInt( ((ToNumber(fv_ArrVertPosition[seq]) * ToNumber(nCy)) / ToNumber(fv_forgHeight) - nHeightRate)/2) - parseInt(this.Components[i].Height/2);
				this.Components[i].left = nWidthRate;
				this.Components[i].top = nHeightRate;
				seq++;
			}
			else // size 조정 처리.
			{
				if ( this.Components[i].id  == "DivButton" ) //divbutton인 경우처리
				{
					this.Components[i].left  = ToNumber(nCx) - this.Components[i].width;
					seq++;
					this.Components[i].right = ToNumber(nCx);
					seq++;
					continue;
				} else {
					nWidthRate  = parseInt( (ToNumber(fv_ArrHorzPosition[seq]) * ToNumber(nCx)) / ToNumber(fv_forgWidth) );
					nHeightRate = parseInt( (ToNumber(fv_ArrVertPosition[seq]) * ToNumber(nCy)) / ToNumber(fv_forgHeight) );
					this.Components[i].left = nWidthRate;
					this.Components[i].top = nHeightRate;
					seq++;
					nWidthRate  = parseInt( (ToNumber(fv_ArrHorzPosition[seq]) * ToNumber(nCx)) / ToNumber(fv_forgWidth) );
					nHeightRate = parseInt( (ToNumber(fv_ArrVertPosition[seq]) * ToNumber(nCy)) / ToNumber(fv_forgHeight) );
					this.Components[i].right = nWidthRate;
					this.Components[i].bottom = nHeightRate;
					seq++;
				}
			 }
		 }
		 else
		 {
			seq++;
			seq++;
		 }
		 /*
		 if ( this.Components[i].GetType() == "Grid" ) {
			if ( this.Components[i].AutoFit )	this.Components[i].FitToArea();
		 }	
		 */
		 if ( this.Components[i].IsComposite() )
		 {
			Gfn_SubFormResizeProc(this.Components[i]);
		 }
	}
}

function Gfn_SubFormResizeProc(obj)
{
	var nCx = obj.width;
	var nCy = obj.height;
	var seq = 0;
	var nWidthRate;
	var nHeightRate;
	var bProcSizeFlag = true;
	var tmpArrayHorz;
	var tmpArrayVert;
	fv_SubSeq++;
	var subseq = fv_SubSeq;
	fv_SuborgWidth[subseq] = obj.width;
	fv_SuborgHeight[subseq] = obj.height;

	tmpArrayHorz = fv_ArrSubHorzPosition[subseq];
	tmpArrayVert = fv_ArrSubVertPosition[subseq];
		
//trace(obj.id);	
//trace(tmpArrayHorz);	
	var loopCnt = 	tmpArrayHorz.length()/2;
	for ( var i = 0 ; i < loopCnt ; i++ )
	{
//trace("1"+obj.id + "////" + obj.Components[i].id + "///" + obj.Components[i].GetType());

		if (  ( obj.Components[i].GetType() == "Dataset" ) ||
			  ( obj.Components[i].GetType() == "File" ) ||	
			  ( obj.Components[i].GetType() == "FileDialog" ) ||	
			  ( obj.Components[i].GetType() == "PopupDiv" )
		   )
	
			continue;
		
		bProcSizeFlag = true;
		
//trace("2"+obj.id + "////" + obj.Components[i].id + "///" + obj.Components[i].GetType());
		//trace(obj.id + "////" + obj.Components[i].id + "///" + obj.Components[i].GetType());
		if ( obj.Components[i].id== "div_content" )  bProcSizeFlag = false;
		
		if ( obj.Components[i].GetType() == "Button" )  bProcSizeFlag = false;
		else if ( obj.Components[i].GetType() == "Image" )
		{
			if ( obj.Components[i].FillType == "NONE" ) bProcSizeFlag = false;
		}
		
		if ( obj.Components[i].GetType() != "TabPage" )
		{
			if ( !bProcSizeFlag ) // 위치를 중앙으로 조정
			{
				nWidthRate  = parseInt( (ToNumber(tmpArrayHorz[seq]) * ToNumber(nCx)) / ToNumber(fv_SubforgWidth[subseq]) );
				nHeightRate = parseInt( (ToNumber(tmpArrayVert[seq]) * ToNumber(nCy)) / ToNumber(fv_SubforgHeight[subseq]) );
				seq++;
				nWidthRate  = nWidthRate + parseInt( ((ToNumber(tmpArrayHorz[seq]) * ToNumber(nCx)) / ToNumber(fv_SubforgWidth[subseq]) - nWidthRate)/2) - parseInt(obj.Components[i].Width/2);
				nHeightRate = nHeightRate + parseInt( ((ToNumber(tmpArrayVert[seq]) * ToNumber(nCy)) / ToNumber(fv_SubforgHeight[subseq]) - nHeightRate)/2) - parseInt(obj.Components[i].Height/2);
				obj.Components[i].left = nWidthRate;
				obj.Components[i].top = nHeightRate;
				seq++;
			}
			else // size 조정 처리.
			{
				nWidthRate  = parseInt( (ToNumber(tmpArrayHorz[seq]) * ToNumber(nCx)) / ToNumber(fv_SubforgWidth[subseq]) );
				nHeightRate = parseInt( (ToNumber(tmpArrayVert[seq]) * ToNumber(nCy)) / ToNumber(fv_SubforgHeight[subseq]) );
				obj.Components[i].left = nWidthRate;
				obj.Components[i].top = nHeightRate;
				seq++;
				nWidthRate  = parseInt( (ToNumber(tmpArrayHorz[seq]) * ToNumber(nCx)) / ToNumber(fv_SubforgWidth[subseq]) );
				nHeightRate = parseInt( (ToNumber(tmpArrayVert[seq]) * ToNumber(nCy)) / ToNumber(fv_SubforgHeight[subseq]) );
				obj.Components[i].right = nWidthRate;
				obj.Components[i].bottom = nHeightRate;
				seq++;
			 }
		 }
		 else
		 {
			seq++;
			seq++;
		 }
//trace(obj.Components[i]);
		 //if ( obj.Components[i].GetType() == "Grid" ) obj.Components[i].FitToArea();
		 if ( obj.Components[i].IsComposite() )
		 {
			Gfn_SubFormResizeProc(obj.Components[i]);
		 }
	}
	
	if ( obj.GetType() != "TabPage" )
		obj.ResizeScroll();
}

function Gfn_frm_OnSize(obj,nCx,nCy,nState)
{
	if ( ( fv_orgWidth == nCx ) && ( fv_orgHeight == nCy ) ) return;
	
	fv_nResizeProcCnt++;
	
	if ( fv_nResizeProcCnt > 1 )
	{
		fv_nResizeProcCnt--;
		return;
	}	
	
	var GapW;
	var GapH;
	
	if ( !fv_FirstResize )
	{
		fv_orgWidth = nCx;
		fv_orgHeight = nCy;
		fv_FirstResize = true;
		fv_nResizeProcCnt--;
		return;
	}

    Gfn_ResizeProc(nCx,nCy);
	ResizeScroll();
	fv_orgWidth = nCx;
	fv_orgHeight = nCy;
	fv_nResizeProcCnt--;
}