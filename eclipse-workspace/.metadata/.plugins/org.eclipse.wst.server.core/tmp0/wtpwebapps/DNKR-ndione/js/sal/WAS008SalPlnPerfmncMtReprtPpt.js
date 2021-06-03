	//code intellisense typescript 정의
///<reference path = "../../wijmo/controls/wijmo.d.ts"/>	
///<reference path = "../../wijmo/controls/wijmo.grid.d.ts"/>
///<reference path = "../../wijmo/controls/wijmo.input.d.ts"/>

/// <reference path ="../../wijmo/controls/wijmo.chart.d.ts"/>
/// <reference path ="../../wijmo/controls/wijmo.chart.annotation.d.ts"/>
/// <reference path ="../../wijmo/controls/wijmo.pdf.d.ts"/>
/// <reference path ="../../wijmo/controls/wijmo.nav.d.ts"/>


var chartMaker = new wijmo.chart.FlexChart("#chartMaker");   //maker 별 판매계획 차트
var chartMakerComps = new wijmo.chart.FlexChart("#chartMakerComps");	//Maker 공장별 판매계획 차트
var chartMakerCompsSum = new wijmo.chart.FlexChart("#chartMakerCompsSum");	//Maker 공장별 판매계획 누계 차트

var chartMaker2 = new wijmo.chart.FlexChart("#chartMaker2");   //maker 별 판매계획 차트
var chartMakerComps2 = new wijmo.chart.FlexChart("#chartMakerComps2");	//Maker 공장별 판매계획 차트
var chartMakerCompsSum2 = new wijmo.chart.FlexChart("#chartMakerCompsSum2");	//Maker 공장별 판매계획 누계 차트

var chartITME = new wijmo.chart.FlexChart("#chartITME");   //ITME별 판매계획 차트
var chartITMEComps = new wijmo.chart.FlexChart("#chartITMEComps");	//ITME 공장별 판매계획 차트
var chartITMECompsSum = new wijmo.chart.FlexChart("#chartITMECompsSum");	//ITME 공장별 판매계획 누계 차트

var chartITME2 = new wijmo.chart.FlexChart("#chartITME2");   //ITME별 판매계획 차트
var chartITMEComps2 = new wijmo.chart.FlexChart("#chartITMEComps2");	//ITME 공장별 판매계획 차트
var chartITMECompsSum2 = new wijmo.chart.FlexChart("#chartITMECompsSum2");	//ITME 공장별 판매계획 누계 차트

var chartITME3 = new wijmo.chart.FlexChart("#chartITME3");   //ITME별 판매계획 차트
var chartITMEComps3 = new wijmo.chart.FlexChart("#chartITMEComps3");	//ITME 공장별 판매계획 차트
var chartITMECompsSum3 = new wijmo.chart.FlexChart("#chartITMECompsSum3");	//ITME 공장별 판매계획 누계 차트

var slectCheckbox = "";
var arraySelectCheckboxS1 = new Array();
var arraySelectCheckboxC1 = new Array();
var arraySelectCheckboxE1 = new Array();
var checkS1 = "0";
var checkC1 = "0";
var checkE1 = "0";
/**
 조회버튼
 */
function search(){
	getCheckboxValue();
	//사업부 변환
	var getOrgComps = $(".getComps").val();
	var getComps = "";
	if($(".getComps").val() == "PE"){
		getComps = "'E1'";
	}else if($(".getComps").val() == "PS"){
		getComps = "'S1','C1'";
	}else {
		getComps = "ALL";
	}
	
	var url = '/ajaxSalPlnPerfmncMtReprtPpt/search.do';
	var params = {
		'getComps' : getComps,
		'getDumcb':$("#getDumcb").val().replace(/-/gi, ""),
		'getOrgComps' : getOrgComps,
		'getPlngb' : $(".getPlngb").val(),
		'getCheckBoxE1' : arraySelectCheckboxE1.toString(),
		'getCheckBoxC1' : arraySelectCheckboxC1.toString(),
		'getCheckBoxS1' : arraySelectCheckboxS1.toString(),
		'getCheckS1' : checkS1,
		'getCheckC1' : checkC1,
		'getCheckE1' : checkE1
	};
	
	mask.open();
	$.ajax({
		method : "post",
		url : url,
		data :params,
		success : function(res) {
			
			// 전체 
			if (getOrgComps == "AL") {
				
				$("#chartMaker").show();
				$("#chartMakerComps").show();
				$("#chartMakerCompsSum").show();
				$("#chartMaker2").css("visibility", "visible");
				$("#chartMakerComps2").css("visibility", "visible");
				$("#chartMakerCompsSum2").css("visibility", "visible");
				
				$("#chartITME").show();
				$("#chartITMEComps").show();
				$("#chartITMECompsSum").show();
				$("#chartITME2").css("visibility", "visible");
				$("#chartITMEComps2").css("visibility", "visible");
				$("#chartITMECompsSum2").css("visibility", "visible");
				$("#chartITME3").css("visibility", "visible");
				$("#chartITMEComps3").css("visibility", "visible");
				$("#chartITMECompsSum3").css("visibility", "visible");
				
				$("#comment").css("visibility", "visible");
				$("#comment2").css("visibility", "visible");
				$("#comment3").css("visibility", "visible");
				$("#comment5").css("visibility", "visible");
				$("#comment6").css("visibility", "visible");
				
				var makerList = JSON.parse(res).makerList;
				chartMaker.itemsSource = makerList;	
				
				//판매현황 값->당월판매현황 그래프 구성
				var makerCompsList = JSON.parse(res).makerCompsListSum;
				var pcosty = 0;
				var pcostm = 0;
				var pcosts = 0;
				for (var i = 0; i < makerList.length; i++) {
					pcosty += makerList[i].pcosty;
					pcostm += makerList[i].pcostm;
					pcosts += makerList[i].pcosts;
				}
				makerCompsList[0].pcosty = pcosty;
				makerCompsList[0].pcostm = pcostm;
				makerCompsList[0].pcosts = pcosts;
				chartMakerComps.itemsSource = makerCompsList;
				
				var makerCompsListSum = JSON.parse(res).makerCompsListSum;
				chartMakerCompsSum.itemsSource = makerCompsListSum;
				
				var makerList2 = JSON.parse(res).makerList2;
				chartMaker2.itemsSource = makerList2;	
				
				//판매현황 값->당월판매현황 그래프 구성
				var makerCompsList2 = JSON.parse(res).makerCompsListSum2;
				var pcosty = 0;
				var pcostm = 0;
				var pcosts = 0;
				for (var i = 0; i < makerList2.length; i++) {
					pcosty += makerList2[i].pcosty;
					pcostm += makerList2[i].pcostm;
					pcosts += makerList2[i].pcosts;
				}
				makerCompsList2[0].pcosty = pcosty;
				makerCompsList2[0].pcostm = pcostm;
				makerCompsList2[0].pcosts = pcosts;
				chartMakerComps2.itemsSource = makerCompsList2;
				
				var makerCompsListSum = JSON.parse(res).makerCompsListSum;
				chartMakerCompsSum.itemsSource = makerCompsListSum;
				
				var makerCompsListSum2 = JSON.parse(res).makerCompsListSum2;
				chartMakerCompsSum2.itemsSource = makerCompsListSum2;
				
				var ITMEList = JSON.parse(res).ITMEList;
				chartITME.itemsSource = ITMEList;	
				
				//판매현황 값->당월판매현황 그래프 구성
				var ITMECompsList = JSON.parse(res).ITMECompsListSum;
				var pcosty = 0;
				var pcostm = 0;
				var pcosts = 0;
				for (var i = 0; i < ITMEList.length; i++) {
					pcosty += ITMEList[i].pcosty;
					pcostm += ITMEList[i].pcostm;
					pcosts += ITMEList[i].pcosts;
				}
				ITMECompsList[0].pcosty = pcosty;
				ITMECompsList[0].pcostm = pcostm;
				ITMECompsList[0].pcosts = pcosts;
				chartITMEComps.itemsSource = ITMECompsList;
				
				var ITMECompsListSum = JSON.parse(res).ITMECompsListSum;
				chartITMECompsSum.itemsSource = ITMECompsListSum;
				
				var ITMEList2 = JSON.parse(res).ITMEList2;
				chartITME2.itemsSource = ITMEList2;	
				
				//판매현황 값->당월판매현황 그래프 구성
				var ITMECompsList2 = JSON.parse(res).ITMECompsListSum2;
				var pcosty = 0;
				var pcostm = 0;
				var pcosts = 0;
				for (var i = 0; i < ITMEList2.length; i++) {
					pcosty += ITMEList2[i].pcosty;
					pcostm += ITMEList2[i].pcostm;
					pcosts += ITMEList2[i].pcosts;
				}
				ITMECompsList2[0].pcosty = pcosty;
				ITMECompsList2[0].pcostm = pcostm;
				ITMECompsList2[0].pcosts = pcosts;
				chartITMEComps2.itemsSource = ITMECompsList2;
				
				var ITMECompsListSum2 = JSON.parse(res).ITMECompsListSum2;
				chartITMECompsSum2.itemsSource = ITMECompsListSum2;
				
				var ITMEList3 = JSON.parse(res).ITMEList3;
				chartITME3.itemsSource = ITMEList3;	
				
					//판매현황 값->당월판매현황 그래프 구성
				var ITMECompsList3 = JSON.parse(res).ITMECompsListSum3;
				var pcosty = 0;
				var pcostm = 0;
				var pcosts = 0;
				for (var i = 0; i < ITMEList3.length; i++) {
					pcosty += ITMEList3[i].pcosty;
					pcostm += ITMEList3[i].pcostm;
					pcosts += ITMEList3[i].pcosts;
				}
				ITMECompsList3[0].pcosty = pcosty;
				ITMECompsList3[0].pcostm = pcostm;
				ITMECompsList3[0].pcosts = pcosts;
				chartITMEComps3.itemsSource = ITMECompsList3;
				
				var ITMECompsListSum3 = JSON.parse(res).ITMECompsListSum3;
				chartITMECompsSum3.itemsSource = ITMECompsListSum3;
				
			} else if (getOrgComps == "PS") {
				
				$("#chartMaker2").css("visibility", "visible");
				$("#chartMakerComps2").css("visibility", "visible");
				$("#chartMakerCompsSum2").css("visibility", "visible");
				
				$("#chartITME2").css("visibility", "visible");
				$("#chartITMEComps2").css("visibility", "visible");
				$("#chartITMECompsSum2").css("visibility", "visible");
				$("#chartITME3").css("visibility", "visible");
				$("#chartITMEComps3").css("visibility", "visible");
				$("#chartITMECompsSum3").css("visibility", "visible");
				
				$("#comment3").css("visibility", "visible");
				$("#comment5").css("visibility", "visible");
				$("#comment6").css("visibility", "visible");
				
				var makerList2 = JSON.parse(res).makerList2;
				chartMaker2.itemsSource = makerList2;	
				
				//판매현황 값->당월판매현황 그래프 구성
				var makerCompsList2 = JSON.parse(res).makerCompsListSum2;
				var pcosty = 0;
				var pcostm = 0;
				var pcosts = 0;
				for (var i = 0; i < makerList2.length; i++) {
					pcosty += makerList2[i].pcosty;
					pcostm += makerList2[i].pcostm;
					pcosts += makerList2[i].pcosts;
				}
				makerCompsList2[0].pcosty = pcosty;
				makerCompsList2[0].pcostm = pcostm;
				makerCompsList2[0].pcosts = pcosts;
				chartMakerComps2.itemsSource = makerCompsList2;
					
				var makerCompsListSum2 = JSON.parse(res).makerCompsListSum2;
				chartMakerCompsSum2.itemsSource = makerCompsListSum2;
				
				var ITMEList3 = JSON.parse(res).ITMEList3;
				chartITME3.itemsSource = ITMEList3;	
				
					//판매현황 값->당월판매현황 그래프 구성
				var ITMECompsList3 = JSON.parse(res).ITMECompsListSum3;
				var pcosty = 0;
				var pcostm = 0;
				var pcosts = 0;
				for (var i = 0; i < ITMEList3.length; i++) {
					pcosty += ITMEList3[i].pcosty;
					pcostm += ITMEList3[i].pcostm;
					pcosts += ITMEList3[i].pcosts;
				}
				ITMECompsList3[0].pcosty = pcosty;
				ITMECompsList3[0].pcostm = pcostm;
				ITMECompsList3[0].pcosts = pcosts;
				chartITMEComps3.itemsSource = ITMECompsList3;
				
				var ITMECompsListSum3 = JSON.parse(res).ITMECompsListSum3;
				chartITMECompsSum3.itemsSource = ITMECompsListSum3;
				
				var ITMEList2 = JSON.parse(res).ITMEList2;
				chartITME2.itemsSource = ITMEList2;	
				
				//판매현황 값->당월판매현황 그래프 구성
				var ITMECompsList2 = JSON.parse(res).ITMECompsListSum2;
				var pcosty = 0;
				var pcostm = 0;
				var pcosts = 0;
				for (var i = 0; i < ITMEList2.length; i++) {
					pcosty += ITMEList2[i].pcosty;
					pcostm += ITMEList2[i].pcostm;
					pcosts += ITMEList2[i].pcosts;
				}
				ITMECompsList2[0].pcosty = pcosty;
				ITMECompsList2[0].pcostm = pcostm;
				ITMECompsList2[0].pcosts = pcosts;
				chartITMEComps2.itemsSource = ITMECompsList2;
				
				var ITMECompsListSum2 = JSON.parse(res).ITMECompsListSum2;
				chartITMECompsSum2.itemsSource = ITMECompsListSum2;
				
				$("#chartMaker").css("display", "none");
				$("#chartMakerComps").css("display", "none");
				$("#chartMakerCompsSum").css("display", "none");
				
				$("#chartITME").css("display", "none");
				$("#chartITMEComps").css("display", "none");
				$("#chartITMECompsSum").css("display", "none");
				
				$("#comment").css("display", "none");
				$("#comment2").css("display", "none");
				
			} else if (getOrgComps == "PE") {
				
				$("#chartMaker").show();
				$("#chartMakerComps").show();
				$("#chartMakerCompsSum").show();
				
				$("#comment").css("visibility", "visible");
				
				$("#chartITME").show();
				$("#chartITMEComps").show();
				$("#chartITMECompsSum").show();
				
				var makerList = JSON.parse(res).makerList;
				chartMaker.itemsSource = makerList;	
				
				//판매현황 값->당월판매현황 그래프 구성
				var makerCompsList = JSON.parse(res).makerCompsListSum;
				var pcosty = 0;
				var pcostm = 0;
				var pcosts = 0;
				for (var i = 0; i < makerList.length; i++) {
					pcosty += makerList[i].pcosty;
					pcostm += makerList[i].pcostm;
					pcosts += makerList[i].pcosts;
				}
				makerCompsList[0].pcosty = pcosty;
				makerCompsList[0].pcostm = pcostm;
				makerCompsList[0].pcosts = pcosts;
				chartMakerComps.itemsSource = makerCompsList;
				
				
				
				var makerList = JSON.parse(res).makerList;
				chartMaker.itemsSource = makerList;	
				
				var makerCompsListSum = JSON.parse(res).makerCompsListSum;
				chartMakerCompsSum.itemsSource = makerCompsListSum;
				
				var ITMEList = JSON.parse(res).ITMEList;
				chartITME.itemsSource = ITMEList;	
				
				//판매현황 값->당월판매현황 그래프 구성
				var ITMECompsList = JSON.parse(res).ITMECompsListSum;
				var pcosty = 0;
				var pcostm = 0;
				var pcosts = 0;
				for (var i = 0; i < ITMEList.length; i++) {
					pcosty += ITMEList[i].pcosty;
					pcostm += ITMEList[i].pcostm;
					pcosts += ITMEList[i].pcosts;
				}
				ITMECompsList[0].pcosty = pcosty;
				ITMECompsList[0].pcostm = pcostm;
				ITMECompsList[0].pcosts = pcosts;
				chartITMEComps.itemsSource = ITMECompsList;
				
				var ITMECompsListSum = JSON.parse(res).ITMECompsListSum;
				chartITMECompsSum.itemsSource = ITMECompsListSum;
				
				$("#chartMaker2").css("visibility", "hidden");
				$("#chartMakerComps2").css("visibility", "hidden");
				$("#chartMakerCompsSum2").css("visibility", "hidden");
				
				$("#chartITME2").css("visibility", "hidden");
				$("#chartITMEComps2").css("visibility", "hidden");
				$("#chartITMECompsSum2").css("visibility", "hidden");
				$("#chartITME3").css("visibility", "hidden");
				$("#chartITMEComps3").css("visibility", "hidden");
				$("#chartITMECompsSum3").css("visibility", "hidden");
				
				$("#comment3").css("visibility", "hidden");
				$("#comment5").css("visibility", "hidden");
				$("#comment6").css("visibility", "hidden");
				
			}
			
			var commentList = JSON.parse(res).commentList;
			for (var i = 0; i < commentList.length; i++) {
				
				if(commentList[i].cmnitm == 'C6' && commentList[i].reprtse == 'R3'){
					$("#text1").val(commentList[i].cmncn);
					$("#comps1").val(commentList[i].oldComps);
					$("#reprtse1").val(commentList[i].reprtse);
					$("#cmnitm1").val(commentList[i].cmnitm);
				}
				if(commentList[i].cmnitm == 'C7' && commentList[i].reprtse == 'R3'){
					$("#text3").val(commentList[i].cmncn);	
					$("#comps3").val(commentList[i].oldComps);
					$("#reprtse3").val(commentList[i].reprtse);
					$("#cmnitm3").val(commentList[i].cmnitm);
				}
				if(commentList[i].cmnitm == 'C3' && commentList[i].reprtse == 'R4'){
					$("#text2").val(commentList[i].cmncn);	
					$("#comps2").val(commentList[i].oldComps);
					$("#reprtse2").val(commentList[i].reprtse);
					$("#cmnitm2").val(commentList[i].cmnitm);
				}
				if(commentList[i].cmnitm == 'C4' && commentList[i].reprtse == 'R4'){
					$("#text5").val(commentList[i].cmncn);	
					$("#comps5").val(commentList[i].oldComps);
					$("#reprtse5").val(commentList[i].reprtse);
					$("#cmnitm5").val(commentList[i].cmnitm);
				}
				if(commentList[i].cmnitm == 'C5' && commentList[i].reprtse == 'R4'){
					$("#text6").val(commentList[i].cmncn);	
					$("#comps6").val(commentList[i].oldComps);
					$("#reprtse6").val(commentList[i].reprtse);
					$("#cmnitm6").val(commentList[i].cmnitm);
				}
			}		
			arraySelectCheckboxC1 = [];
			arraySelectCheckboxS1 = [];
			arraySelectCheckboxE1 = [];
			checkS1 = "0";
			checkC1 = "0";
			checkE1 = "0";									
		},
		error : function() {
			console.log("dataset.error");
			
		},
		complete : function() {
			//console.log("dataset.completed");
			setTimeout(function() {
				mask.close();				
			}, 500);
			
		}
	});
	
}



/**
 * pdf 다운로드
 */
function downloadPdf(){
	var doc = new wijmo.pdf.PdfDocument({
			pageSettings:{
				layout:wijmo.pdf.PdfPageOrientation.Landscape,
				size:wijmo.pdf.PdfPageSize.A4,
				margins:{
				left:50,
				top:50,
				right:50,
				bottom:50
			}
			}, 

			ended:function(sender,args){
				wijmo.pdf.saveBlob(args.blob, LN_FILE_NM+'.pdf')
			}
			
		});
		
		//나눔고딕 폰트를 등록해줌.
		doc.registerFont({
			source:"/fonts/NanumGothic.ttf",
			name:"nanum",
			style:"normal",
			weight:"normal",
			sansSerif:true,
		});
		

		//등록한 font를 변수로 잡고
		var font = new wijmo.pdf.PdfFont("nanum",10);
		
		if($(".getComps").val() == "PE" || $(".getComps").val() == "AL"){
		chartMaker.saveImageToDataUrl(wijmo.chart.ImageFormat.Svg,function(url){
			//폰트를 글자에 적용시킴
			doc.drawText("ㅤ",0,0,{font:font});
			//doc.paths.rect(doc.x, 0, 230, 330).stroke();
			//폰트를 차트에 적용시킴
			doc.drawSvg(url,0,0,{font:font,height:350,width:250});
		});
		
		chartMakerComps.saveImageToDataUrl(wijmo.chart.ImageFormat.Svg,function(url){
			//폰트를 글자에 적용시킴
			doc.drawText("ㅤ",250,0,{font:font});
			//doc.paths.rect(doc.x, 0, 200, 330).stroke();
			//폰트를 차트에 적용시킴
			doc.drawSvg(url,250,0,{font:font,height:350,width:200});
		});
		
		chartMakerCompsSum.saveImageToDataUrl(wijmo.chart.ImageFormat.Svg,function(url){
			//폰트를 글자에 적용시킴
			doc.drawText("ㅤ",470,0,{font:font});
			//doc.paths.rect(doc.x, 0, 200, 330).stroke();
			//폰트를 차트에 적용시킴
			doc.drawSvg(url,470,0,{font:font,height:350,width:200});
		});
		
		doc.moveDown(30);
		
		doc.drawText(LN_COMENT_TITLE1,0,doc.y,{font:font});
		doc.paths.rect(0, doc.y, 670, 100).stroke();
		doc.drawText($('#text1').val(),null,null,{font:font})
		}
		
		if($(".getComps").val() == "AL"){
			
		chartMaker2.saveImageToDataUrl(wijmo.chart.ImageFormat.Svg,function(url){
			//폰트를 글자에 적용시킴
		doc.drawText("ㅤ",0,1000,{font:font});
		//doc.paths.rect(doc.x, 0, 230, 330).stroke();
			//폰트를 차트에 적용시킴
		doc.drawSvg(url,0,0,{font:font,height:350,width:250});
		});
		
		chartMakerComps2.saveImageToDataUrl(wijmo.chart.ImageFormat.Svg,function(url){
			//폰트를 글자에 적용시킴
			doc.drawText("ㅤ",250,0,{font:font});
			//doc.paths.rect(doc.x, 0, 200, 330).stroke();
			//폰트를 차트에 적용시킴
			doc.drawSvg(url,250,0,{font:font,height:350,width:200});
		});
		
		chartMakerCompsSum2.saveImageToDataUrl(wijmo.chart.ImageFormat.Svg,function(url){
			//폰트를 글자에 적용시킴
			doc.drawText("ㅤ",470,0,{font:font});
			//doc.paths.rect(doc.x, 0, 200, 330).stroke();
			//폰트를 차트에 적용시킴
			doc.drawSvg(url,470,0,{font:font,height:350,width:200});
		});
		
		doc.moveDown(30);
		
		doc.drawText(LN_COMENT_TITLE2,0,doc.y,{font:font});
		doc.paths.rect(0, doc.y, 670, 100).stroke();
		doc.drawText($('#text3').val(),null,null,{font:font});
		}
		
		if($(".getComps").val() == "PS"){
			
		chartMaker2.saveImageToDataUrl(wijmo.chart.ImageFormat.Svg,function(url){
			//폰트를 글자에 적용시킴
		doc.drawText("ㅤ",0,0,{font:font});
		//doc.paths.rect(doc.x, 0, 230, 330).stroke();
			//폰트를 차트에 적용시킴
		doc.drawSvg(url,0,0,{font:font,height:350,width:250});
		});
		
		chartMakerComps2.saveImageToDataUrl(wijmo.chart.ImageFormat.Svg,function(url){
			//폰트를 글자에 적용시킴
			doc.drawText("ㅤ",250,0,{font:font});
			//doc.paths.rect(doc.x, 0, 200, 330).stroke();
			//폰트를 차트에 적용시킴
			doc.drawSvg(url,250,0,{font:font,height:350,width:200});
		});
		
		chartMakerCompsSum2.saveImageToDataUrl(wijmo.chart.ImageFormat.Svg,function(url){
			//폰트를 글자에 적용시킴
			doc.drawText("ㅤ",470,0,{font:font});
			//doc.paths.rect(doc.x, 0, 200, 330).stroke();
			//폰트를 차트에 적용시킴
			doc.drawSvg(url,470,0,{font:font,height:350,width:200});
		});
		
		doc.moveDown(30);
		
		doc.drawText(LN_COMENT_TITLE2,0,doc.y,{font:font});
		doc.paths.rect(0, doc.y, 670, 100).stroke();
		doc.drawText($('#text3').val(),null,null,{font:font});
		}
		
		if($(".getComps").val() == "PE" || $(".getComps").val() == "AL"){		
		chartITME.saveImageToDataUrl(wijmo.chart.ImageFormat.Svg,function(url){
			//폰트를 글자에 적용시킴
			doc.drawText("ㅤ",0,600,{font:font});
			//doc.paths.rect(doc.x, 0, 230, 330).stroke();
			//폰트를 차트에 적용시킴
			doc.drawSvg(url,0,0,{font:font,height:350,width:250});
		});
		
		chartITMEComps.saveImageToDataUrl(wijmo.chart.ImageFormat.Svg,function(url){
			//폰트를 글자에 적용시킴
			doc.drawText("ㅤ",250,0,{font:font});
			//doc.paths.rect(doc.x, 0, 200, 330).stroke();
			//폰트를 차트에 적용시킴
			doc.drawSvg(url,250,0,{font:font,height:350,width:200});
		});
		
		chartITMECompsSum.saveImageToDataUrl(wijmo.chart.ImageFormat.Svg,function(url){
			//폰트를 글자에 적용시킴
			doc.drawText("ㅤ",470,0,{font:font});
			//doc.paths.rect(doc.x, 0, 200, 330).stroke();
			//폰트를 차트에 적용시킴
			doc.drawSvg(url,470,0,{font:font,height:350,width:200});
		});
		
		doc.moveDown(30);
		
		doc.drawText(LN_COMENT_TITLE3,0,doc.y,{font:font});
		doc.paths.rect(0, doc.y, 670, 100).stroke();
		doc.drawText($('#text2').val(),null,null,{font:font});
		}
		
		if($(".getComps").val() == "AL"|| $(".getComps").val() == "PS"){
		
			chartITME2.saveImageToDataUrl(wijmo.chart.ImageFormat.Svg,function(url){
			//폰트를 글자에 적용시킴
			doc.drawText("ㅤ",0,600,{font:font});
			//doc.paths.rect(doc.x, 0, 230, 330).stroke();
			//폰트를 차트에 적용시킴
			doc.drawSvg(url,0,0,{font:font,height:350,width:250});
		});
		
		chartITMEComps2.saveImageToDataUrl(wijmo.chart.ImageFormat.Svg,function(url){
			//폰트를 글자에 적용시킴
			doc.drawText("ㅤ",250,0,{font:font});
			//doc.paths.rect(doc.x, 0, 200, 330).stroke();
			//폰트를 차트에 적용시킴
			doc.drawSvg(url,250,0,{font:font,height:350,width:200});
		});
		
		chartITMECompsSum2.saveImageToDataUrl(wijmo.chart.ImageFormat.Svg,function(url){
			//폰트를 글자에 적용시킴
			doc.drawText("ㅤ",470,0,{font:font});
			//doc.paths.rect(doc.x, 0, 200, 330).stroke();
			//폰트를 차트에 적용시킴
			doc.drawSvg(url,470,0,{font:font,height:350,width:200});
		});
		
		doc.moveDown(30);
		
		doc.drawText(LN_COMENT_TITLE4,0,doc.y,{font:font});
		doc.paths.rect(0, doc.y, 670, 100).stroke();
		doc.drawText($('#text5').val(),null,null,{font:font});
		
		chartITME3.saveImageToDataUrl(wijmo.chart.ImageFormat.Svg,function(url){
			//폰트를 글자에 적용시킴
			doc.drawText("ㅤ",0,1000,{font:font});
			//doc.paths.rect(doc.x, 0, 230, 330).stroke();
			//폰트를 차트에 적용시킴
			doc.drawSvg(url,0,0,{font:font,height:350,width:250});
		});
		
		chartITMEComps3.saveImageToDataUrl(wijmo.chart.ImageFormat.Svg,function(url){
			//폰트를 글자에 적용시킴
			doc.drawText("ㅤ",250,0,{font:font});
			//doc.paths.rect(doc.x, 0, 200, 330).stroke();
			//폰트를 차트에 적용시킴
			doc.drawSvg(url,250,0,{font:font,height:350,width:200});
		});
		
		chartITMECompsSum3.saveImageToDataUrl(wijmo.chart.ImageFormat.Svg,function(url){
			//폰트를 글자에 적용시킴
			doc.drawText("ㅤ",470,0,{font:font});
			//doc.paths.rect(doc.x, 0, 200, 330).stroke();
			//폰트를 차트에 적용시킴
			doc.drawSvg(url,470,0,{font:font,height:350,width:200});
		});
		
		doc.moveDown(30);
		
		doc.drawText(LN_COMENT_TITLE5,0,doc.y,{font:font});
		doc.paths.rect(0, doc.y, 670, 100).stroke();
		doc.drawText($('#text6').val(),null,null,{font:font});
		}
		doc.end();
}


/**
  차트 초기화
 */
function chartInit() {
	
	chartMaker.initialize({
		header: "["+LN_OPT_2+"] "+LN_CHART_TITLE1,
		bindingX: 'maker',
		series: [
	    	{ name: LN_CHART_LB1, binding: 'pcosty' },
	    	{ name: LN_CHART_LB2, binding: 'pcostm' },
	    	{ name: LN_CHART_LB3, binding: 'pcosts' }
	  	],
	
		dataLabel:{
			content:'{y}'
		},
		
		legend: {
            position: wijmo.chart.Position.Bottom
        },
		footer:LN_CHART_LB4

	});
	
	chartMakerComps.initialize({
		header:"["+LN_OPT_2+"] "+LN_CHART_TITLE2,
		bindingX: 'maker',
		series: [
	    	{ name: LN_CHART_LB1, binding: 'pcosty' },
	    	{ name: LN_CHART_LB2, binding: 'pcostm' },
	    	{ name: LN_CHART_LB3, binding: 'pcosts' }
	  	],
	
		dataLabel:{
			content:'{y}'
		},
		
		legend: {
            position: wijmo.chart.Position.Bottom
        },
		footer:LN_CHART_LB4
	});
	
	chartMakerCompsSum.initialize({
		header:"["+LN_OPT_2+"] "+LN_CHART_TITLE3,
		bindingX: ' ',
		series: [
	    	{ name: LN_CHART_LB1, binding: 'pcosty' },
	    	{ name: LN_CHART_LB2, binding: 'pcostm' },
	    	{ name: LN_CHART_LB3, binding: 'pcosts' }
	  	],
	
		dataLabel:{
			content:'{y}'
		},
		
		legend: {
            position: wijmo.chart.Position.Bottom
        },
		footer:LN_CHART_LB4
		
	});
	
	chartMaker2.initialize({
		header:"["+LN_OPT_3+"] "+LN_CHART_TITLE1,
		bindingX: 'maker',
		series: [
	    	{ name: LN_CHART_LB1, binding: 'pcosty' },
	    	{ name: LN_CHART_LB2, binding: 'pcostm' },
	    	{ name: LN_CHART_LB3, binding: 'pcosts' }
	  	],
	
		dataLabel:{
			content:'{y}'
		},
		
		legend: {
            position: wijmo.chart.Position.Bottom
        },
		footer:LN_CHART_LB4

	});
	
	chartMakerComps2.initialize({
		header:"["+LN_OPT_3+"] "+LN_CHART_TITLE2,
		bindingX: 'maker',
		series: [
	    	{ name: LN_CHART_LB1, binding: 'pcosty' },
	    	{ name: LN_CHART_LB2, binding: 'pcostm' },
	    	{ name: LN_CHART_LB3, binding: 'pcosts' }
	  	],
	
		dataLabel:{
			content:'{y}'
		},
		
		legend: {
            position: wijmo.chart.Position.Bottom
        },
		footer:LN_CHART_LB4
	});
	
	chartMakerCompsSum2.initialize({
		header:"["+LN_OPT_3+"] "+LN_CHART_TITLE3,
		bindingX: 'maker',
		series: [
	    	{ name: LN_CHART_LB1, binding: 'pcosty' },
	    	{ name: LN_CHART_LB2, binding: 'pcostm' },
	    	{ name: LN_CHART_LB3, binding: 'pcosts' }
	  	],
	
		dataLabel:{
			content:'{y}'
		},
		
		legend: {
            position: wijmo.chart.Position.Bottom
        },
		footer:LN_CHART_LB4
		
	});
	
	chartITME.initialize({
		header:"["+LB_LOCNM1+"] "+LN_CHART_TITLE4,
		bindingX: 'maker',
		series: [
	    	{ name: LN_CHART_LB1, binding: 'pcosty' },
	    	{ name: LN_CHART_LB2, binding: 'pcostm' },
	    	{ name: LN_CHART_LB3, binding: 'pcosts' }
	  	],
	
		dataLabel:{
			content:'{y}'
		},
		
		legend: {
            position: wijmo.chart.Position.Bottom
        },
		footer:LN_CHART_LB4

	});
	
	chartITMEComps.initialize({
		header:"["+LB_LOCNM1+"] "+LN_CHART_TITLE5,
		bindingX: 'maker',
		series: [
	    	{ name: LN_CHART_LB1, binding: 'pcosty' },
	    	{ name: LN_CHART_LB2, binding: 'pcostm' },
	    	{ name: LN_CHART_LB3, binding: 'pcosts' }
	  	],
	
		dataLabel:{
			content:'{y}'
		},
		
		legend: {
            position: wijmo.chart.Position.Bottom
        },
		footer:LN_CHART_LB4
	});
	
	chartITMECompsSum.initialize({
		header:"["+LB_LOCNM1+"] "+LN_CHART_TITLE6,
		bindingX: 'maker',
		series: [
	    	{ name: LN_CHART_LB1, binding: 'pcosty' },
	    	{ name: LN_CHART_LB2, binding: 'pcostm' },
	    	{ name: LN_CHART_LB3, binding: 'pcosts' }
	  	],
	
		dataLabel:{
			content:'{y}'
		},
		
		legend: {
            position: wijmo.chart.Position.Bottom
        },
		footer:LN_CHART_LB4
		
	});
	
	chartITME2.initialize({
		header:"["+LB_LOCNM3+"] "+LN_CHART_TITLE4,
		bindingX: 'maker',
		series: [
	    	{ name: LN_CHART_LB1, binding: 'pcosty' },
	    	{ name: LN_CHART_LB2, binding: 'pcostm' },
	    	{ name: LN_CHART_LB3, binding: 'pcosts' }
	  	],
	
		dataLabel:{
			content:'{y}'
		},
		
		legend: {
            position: wijmo.chart.Position.Bottom
        },
		footer:LN_CHART_LB4

	});
	
	chartITMEComps2.initialize({
		header:"["+LB_LOCNM3+"] "+LN_CHART_TITLE5,
		bindingX: 'maker',
		series: [
	    	{ name: LN_CHART_LB1, binding: 'pcosty' },
	    	{ name: LN_CHART_LB2, binding: 'pcostm' },
	    	{ name: LN_CHART_LB3, binding: 'pcosts' }
	  	],
	
		dataLabel:{
			content:'{y}'
		},
		
		legend: {
            position: wijmo.chart.Position.Bottom
        },
		footer:LN_CHART_LB4
	});
	
	chartITMECompsSum2.initialize({
		header:"["+LB_LOCNM3+"] "+LN_CHART_TITLE6,
		bindingX: 'maker',
		series: [
	    	{ name: LN_CHART_LB1, binding: 'pcosty' },
	    	{ name: LN_CHART_LB2, binding: 'pcostm' },
	    	{ name: LN_CHART_LB3, binding: 'pcosts' }
	  	],
	
		dataLabel:{
			content:'{y}'
		},
		
		legend: {
            position: wijmo.chart.Position.Bottom
        },
		footer:LN_CHART_LB4
		
	});
	
	chartITME3.initialize({
		header:"["+LB_LOCNM4+"] "+LN_CHART_TITLE4,
		bindingX: 'maker',
		series: [
	    	{ name: LN_CHART_LB1, binding: 'pcosty' },
	    	{ name: LN_CHART_LB2, binding: 'pcostm' },
	    	{ name: LN_CHART_LB3, binding: 'pcosts' }
	  	],
	
		dataLabel:{
			content:'{y}'
		},
		
		legend: {
            position: wijmo.chart.Position.Bottom
        },
		footer:LN_CHART_LB4

	});
	
	chartITMEComps3.initialize({
		header:"["+LB_LOCNM4+"] "+LN_CHART_TITLE5,
		bindingX: 'maker',
		series: [
	    	{ name: LN_CHART_LB1, binding: 'pcosty' },
	    	{ name: LN_CHART_LB2, binding: 'pcostm' },
	    	{ name: LN_CHART_LB3, binding: 'pcosts' }
	  	],
	
		dataLabel:{
			content:'{y}'
		},
		
		legend: {
            position: wijmo.chart.Position.Bottom
        },
		footer:LN_CHART_LB4
	});
	
	chartITMECompsSum3.initialize({
		header:"["+LB_LOCNM4+"] "+LN_CHART_TITLE6,
		bindingX: ' ',
		series: [
	    	{ name: LN_CHART_LB1, binding: 'pcosty' },
	    	{ name: LN_CHART_LB2, binding: 'pcostm' },
	    	{ name: LN_CHART_LB3, binding: 'pcosts' }
	  	],
	
		dataLabel:{
			content:'{y}'
		},
		
		legend: {
            position: wijmo.chart.Position.Bottom
        },
		footer:LN_CHART_LB4
		
	});
	
	//주석 표시기 사용 차트어떤부분이든 삽입가능함.
	var data = [
		{
            "type": "Text",
            "attachment": 2,
            "text": LN_CHART_LB4,
            "position": 0,
            "point": { "x": 0.90, "y": 0.05 },
            "tooltip": "",
            "style": { "font-size": "11px", "font-weight": "bold"}
            
        }
	]
	//var basic = new wijmo.chart.annotation.AnnotationLayer(chartMaker,data);
}

/*	
	등록버튼
*/
function update(textNum){
	
	if(textNum == "1"){
		var cmncn =  $('#text1').val();
		var comps = $('#comps1').val();
		var reprtse = $('#reprtse1').val();
		var cmnitm = $('#cmnitm1').val();
		var insComps = $(".getComps").val();
		var insReprtse = "R3";
		var insCmnitm = "C6";
	}else if(textNum == "3"){
		var cmncn =  $('#text3').val();
		var comps = $('#comps3').val();
		var reprtse = $('#reprtse3').val();
		var cmnitm = $('#cmnitm3').val();
		var insComps = $(".getComps").val();
		var insReprtse = "R3";
		var insCmnitm = "C7";
	}else if(textNum == "2"){
		var cmncn =  $('#text2').val();
		var comps = $('#comps2').val();
		var reprtse = $('#reprtse2').val();
		var cmnitm = $('#cmnitm2').val();
		var insComps = $('.getComps').val();
		var insReprtse = "R4";
		var insCmnitm = "C3";
	}else if(textNum == "5"){
		var cmncn =  $('#text5').val();
		var comps = $('#comps5').val();
		var reprtse = $('#reprtse5').val();
		var cmnitm = $('#cmnitm5').val();
		var insComps = $(".getComps").val();
		var insReprtse = "R4";
		var insCmnitm = "C4";
	}else{
		var cmncn =  $('#text6').val();
		var comps = $('#comps6').val();
		var reprtse = $('#reprtse6').val();
		var cmnitm = $('#cmnitm6').val();
		var insComps = $('.getComps').val();
		var insReprtse = "R4";
		var insCmnitm = "C5";
	}
	var url = "/ajaxSalAnlysComent/update2.do";
	var params = {
		'cmncn': cmncn,
		'comps': comps,
		'reprtse': reprtse,
		'cmnitm': cmnitm,
		'insComps': insComps,
		'insReprtse': insReprtse,
		'insCmnitm': insCmnitm,
		'getDumcb':$("#getDumcb").val().replace(/-/gi, "")
		
	};
	
	$.ajax({
		method : "post",
		url : url,
		data :params,
		success : function(res) {
			var data = JSON.parse(res);
			if (data.result != RESULT_OK) {
    			if(data.errMsg == "LN_UPD_CHK1") stateMsg = LN_UPD_CHK1;
    			if(data.errMsg == "LN_UPD_CHK2") stateMsg = LN_UPD_CHK2;
    			if(data.errMsg == "LN_INS_CHK1") stateMsg = LN_INS_CHK1;
				toastMsg(stateMsg);
				bntReset(textNum);
			} else {
				toastMsg("OK");
				bntReset(textNum);
			}
		},
		error : function() {
			console.log("dataset.error");
			
		},
		complete : function() {
			//console.log("dataset.completed");
			setTimeout(function() {
				mask.close();				
			}, 500);
		}
	});
}

//등록후 버튼 비활성화전환
function bntReset(textNum){
	var bntNum = textNum;
	if(bntNum == "1"){
		$('#saveBtn1').css('display', 'none');
		$('#pdfDown1').show();
		$('#text1').prop('readonly', true);
	} else if(bntNum == "2") {
		$('#saveBtn2').css('display', 'none');
		$('#pdfDown4').show();
		$('#text2').prop('readonly', true);
	} else if(bntNum == "3") {
		$('#saveBtn3').css('display', 'none');
		$('#pdfDown2').show();
		$('#text3').prop('readonly', true);
	} else if(bntNum == "5") {
		$('#saveBtn5').css('display', 'none');
		$('#pdfDown5').show();
		$('#text5').prop('readonly', true);
	} else {
		$('#saveBtn6').css('display', 'none');
		$('#pdfDown6').show();
		$('#text6').prop('readonly', true);
	}
}

/**
	버튼 이벤트 처리
 */
function handleEvent(){
	
	// 더보기버튼
	$(".loadMore").on("click",function(compsVal){
		var compsVal = $(".getComps").val();
		if(compsVal == "PE"){
			$(".checkboxE1List").show();
			$(".checkboxS1List").css('display', 'none');
			$(".checkboxAllList").css('display', 'none');
			slectCheckbox = "prdcdE1List";	
		}else if(compsVal == "PS"){
			$(".checkboxS1List").show();
			$(".checkboxE1List").css('display', 'none');
			$(".checkboxAllList").css('display', 'none');
			slectCheckbox = "prdcdS1List";
		}else{
			$(".checkboxAllList").show();
			$(".checkboxE1List").css('display', 'none');
			$(".checkboxC1List").css('display', 'none');
			$(".checkboxS1List").css('display', 'none');
			slectCheckbox = "prdcdList";
		}
		$(".checkboxWrap").show();
		$('.loadMore').css('display', 'none');
		$('.close').show();
		//그리드, 코멘트창 초기화
		$('.text').val("");//텍스트
		$('.text').css('readonly',true);
		$('.comment').css('display','none');
		//차트리셋
		chartMaker.itemsSource = [];
		chartMakerComps.itemsSource = [];
		chartMakerCompsSum.itemsSource = [];
		chartITME.itemsSource = [];
		chartITMEComps.itemsSource = [];
		chartITMECompsSum.itemsSource = [];
		
		chartMaker2.itemsSource = [];
		chartMakerComps2.itemsSource = [];
		chartMakerCompsSum2.itemsSource = [];
		
		chartITME2.itemsSource = [];
		chartITMEComps2.itemsSource = [];
		chartITMECompsSum2.itemsSource = [];		
		chartITME3.itemsSource = [];
		chartITMEComps3.itemsSource = [];
		chartITMECompsSum3.itemsSource = [];
	});
	
	$(".close").on("click",function(){
		$(".checkboxWrap").css('display', 'none');	
		$('.close').css('display', 'none');
		$('.loadMore').show();
		slectCheckbox = "";
	});
	
	//날짜변경시reset
	$('#getDumcb').on('blur', function() {
		$("#getComps option[value='AL']").prop('selected',true);
		$('.text').val("");//텍스트
		$('.text').css('readonly',true);
		$('.comment').css('display','none');
		//차트리셋
		chartMaker.itemsSource = [];
		chartMakerComps.itemsSource = [];
		chartMakerCompsSum.itemsSource = [];
		chartITME.itemsSource = [];
		chartITMEComps.itemsSource = [];
		chartITMECompsSum.itemsSource = [];
		
		chartMaker2.itemsSource = [];
		chartMakerComps2.itemsSource = [];
		chartMakerCompsSum2.itemsSource = [];
		
		chartITME2.itemsSource = [];
		chartITMEComps2.itemsSource = [];
		chartITMECompsSum2.itemsSource = [];		
		chartITME3.itemsSource = [];
		chartITMEComps3.itemsSource = [];
		chartITMECompsSum3.itemsSource = [];
	});
	
	//사업부 변경시 reset
	$('#getComps').on('change', function() {
		$('.text').val("");//텍스트
		$('.text').css('readonly',true);
		$('.comment').css('display','none');
		//차트리셋
		chartMaker.itemsSource = [];
		chartMakerComps.itemsSource = [];
		chartMakerCompsSum.itemsSource = [];
		chartITME.itemsSource = [];
		chartITMEComps.itemsSource = [];
		chartITMECompsSum.itemsSource = [];
		
		chartMaker2.itemsSource = [];
		chartMakerComps2.itemsSource = [];
		chartMakerCompsSum2.itemsSource = [];
		
		chartITME2.itemsSource = [];
		chartITMEComps2.itemsSource = [];
		chartITMECompsSum2.itemsSource = [];		
		chartITME3.itemsSource = [];
		chartITMEComps3.itemsSource = [];
		chartITMECompsSum3.itemsSource = [];
	});
	
	//MAKER 수정버튼->등록버튼
	$('#pdfDown1').on('click', function() {
		$('#pdfDown1').css('display', 'none');
		$('#saveBtn1').show();
		$('#text1').prop('readonly', false);
	});
	$('#pdfDown2').on('click', function() {
		$('#pdfDown2').css('display', 'none');
		$('#saveBtn3').show();
		$('#text3').prop('readonly', false);
		
	});
	//ITEM 수정버튼->등록버튼
	$('#pdfDown4').on('click', function() {
		$('#pdfDown4').css('display', 'none');
		$('#saveBtn2').show();
		$('#text2').prop('readonly', false);
	});
	$('#pdfDown5').on('click', function() {
		$('#pdfDown5').css('display', 'none');
		$('#saveBtn5').show();
		$('#text5').prop('readonly', false);
	});
	$('#pdfDown6').on('click', function() {
		$('#pdfDown6').css('display', 'none');
		$('#saveBtn6').show();
		$('#text6').prop('readonly', false);
	});
	
	//조회버튼->코멘트창
	$('#searchBtn').on('click', function() {
		$('.comment').show();
	});
	
	//MAKER - TEXT 등록 버튼
	$('._saveBtn1_').on('click', function(e) {
		var textNum = $(e.target).val();
		update(textNum);
	});
	
	//ITEM - TEXT 등록 버튼
	$('._saveBtn2_').on('click', function(e) {
		var textNum = $(e.target).val();
		update(textNum);
	});
}

//그리드,차트,텍스트 리셋
function clearGrid(num){
	console.log("s");
	if(num == '1'){
		$("#getComps option[value='AL']").prop('selected',true);
	}

	arraySelectCheckboxC1 = [];
	arraySelectCheckboxS1 = [];
	arraySelectCheckboxE1 = [];
	
	$('.checkboxWrap').css('display','none');
	$('.close').css('display', 'none');
	$('.loadMore').show();
	$(".prdcdS1List").prop('checked', false);
	$(".prdcdE1List").prop('checked', false);
	$(".prdcdC1List").prop('checked', false);
}

//체크박스 카운트
function CountChecked(){
	$("input[name='prdcdE1List']").on("click" , function(){
	var cnt = $("input:checked[name='prdcdE1List']").size();
	if(cnt > 5){
			$(this).attr("checked" , false);
			toastMsg(LN_ALERT_MS);
			}
		});
	$("input[name='prdcdS1List']").on("click" , function(){
	var cnt = $("input:checked[name='prdcdS1List']").size();
	if(cnt > 5){
			$(this).attr("checked" , false);
			toastMsg(LN_ALERT_MS);
			}
		});	
	$("input[name='prdcdC1List']").on("click" , function(){
	var cnt = $("input:checked[name='prdcdC1List']").size();
	if(cnt > 5){
			$(this).attr("checked" , false);
			toastMsg(LN_ALERT_MS);
			}
		});		
}

/*
	checkbox value 취득
*/
function getCheckboxValue(){
	if(slectCheckbox == "prdcdList"){
	if($("input:checkbox[name='prdcdE1List']").is(":checked")== true){
		$("input:checkbox[name='prdcdE1List']:checked").each(function() {
		var arr =[];
			arr.push($(this).val());
			for (var i=0; i<arr.length; i++){
			if(arraySelectCheckboxE1.indexOf(arr[i]) === -1) arraySelectCheckboxE1.push(arr[i]);
			}
		checkE1="E";
	});
	}
	if($("input:checkbox[name='prdcdS1List']").is(":checked")== true){
		$("input:checkbox[name='prdcdS1List']:checked").each(function() {
		var arr =[];
			arr.push($(this).val());
			for (var i=0; i<arr.length; i++){
			if(arraySelectCheckboxS1.indexOf(arr[i]) === -1) arraySelectCheckboxS1.push(arr[i]);
			}
		checkS1="S";
		});		
	}
	if($("input:checkbox[name='prdcdC1List']").is(":checked")== true){
		$("input:checkbox[name='prdcdC1List']:checked").each(function() {
		var arr =[];
			arr.push($(this).val());
			for (var i=0; i<arr.length; i++){
			if(arraySelectCheckboxC1.indexOf(arr[i]) === -1) arraySelectCheckboxC1.push(arr[i]);
			}
		checkC1="C";
		});			
	}
	}
	if(slectCheckbox == "prdcdE1List"){
		if($("input:checkbox[name='prdcdE1List']").is(":checked")== true){
		$("input:checkbox[name='prdcdE1List']:checked").each(function() {
		var arr =[];
			arr.push($(this).val());
			for (var i=0; i<arr.length; i++){
			if(arraySelectCheckboxE1.indexOf(arr[i]) === -1) arraySelectCheckboxE1.push(arr[i]);
			}	
		checkE1="E";
		});
	}
	}
	if(slectCheckbox == "prdcdS1List"){
		if($("input:checkbox[name='prdcdS1List']").is(":checked")== true){
		$("input:checkbox[name='prdcdS1List']:checked").each(function() {
		var arr =[];
			arr.push($(this).val());
			for (var i=0; i<arr.length; i++){
			if(arraySelectCheckboxS1.indexOf(arr[i]) === -1) arraySelectCheckboxS1.push(arr[i]);
			}
		checkS1="S";
		});		
	}
		if($("input:checkbox[name='prdcdC1List']").is(":checked")== true){
		$("input:checkbox[name='prdcdC1List']:checked").each(function() {
		var arr =[];
			arr.push($(this).val());
			for (var i=0; i<arr.length; i++){
			if(arraySelectCheckboxC1.indexOf(arr[i]) === -1) arraySelectCheckboxC1.push(arr[i]);
			}
		checkC1="C";
		});		
	}
	}
}

function calendar(){
	var chk_calendar = new ax5.ui.calendar({
        target: document.getElementById("chk_calendar"),
        control: {
            left: '<i class="fa fa-chevron-left"></i>',
            yearTmpl: '%s',
            monthTmpl: '%s',
            right: '<i class="fa fa-chevron-right"></i>',
            yearFirst: true
        },
        displayDate: (new Date()),
		mode: "month",
    	selectMode: "month",
		dateFormat: 'yyyy-MM', // yyyy-mm-dd 
        dimensions: {
            height: 250,
            controlHeight: 40,
            itemPadding: 1
        },
        lang: {
        	/*yearTmpl: "%s년",*/
            /*months: ['일월', '이월', '삼월', '사월', '오월', '육월', '칠월', '팔월', '구월', '시월', '십일월', '십이월'],*/
        	yearTmpl: YEAR_FORMAT,
        	months: MONTH
        },
        onClick: function () {
            $(this.target).css('display', 'none');
			var date = JSON.stringify(chk_calendar.getSelection());
            $(this.target).prev().val(date.substring(2,9));
        },
        onStateChanged: function () {
            //console.log(this);
        }
    });
	
	$('.log_board .dropdown').on('click', function(e){
		$($(e.target).next('.dropdown-menu')).css('display', 'block');
	});
}


$(document.body).ready(function() {
	
	chartInit();
	handleEvent();	//프로그램 버튼 이벤트
	calendar(); //캘린더
	new wijmo.nav.TabPanel("#theTabPanel");
	
});

