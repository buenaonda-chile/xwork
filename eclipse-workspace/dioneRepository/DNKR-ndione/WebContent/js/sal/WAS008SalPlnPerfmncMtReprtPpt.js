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

var chartITME = new wijmo.chart.FlexChart("#chartITME");   //ITME별 판매계획 차트
var chartITMEComps = new wijmo.chart.FlexChart("#chartITMEComps");	//ITME 공장별 판매계획 차트
var chartITMECompsSum = new wijmo.chart.FlexChart("#chartITMECompsSum");	//ITME 공장별 판매계획 누계 차트

/**
 조회버튼
 */
function search(){
	
	if(!$(".getLocCode").val()){
		toastMsg(LN_SELECT_COMPS);
		return false;
	}
	
	var url = '/ajaxSalPlnPerfmncMtReprtPpt/search.do';
	var params = {
		'getLocCode' : $("#getLocCode").val(),
		'getDumcb':$("#getDumcb").val().replace(/-/gi, "")
	};
	
	mask.open();
	$.ajax({
		method : "post",
		url : url,
		data :params,
		success : function(res) {
			var makerList = JSON.parse(res).makerList;
			chartMaker.itemsSource = makerList;	
			var makerCompsList = JSON.parse(res).makerCompsList;
			chartMakerComps.itemsSource = makerCompsList;
			
			var makerCompsListSum = JSON.parse(res).makerCompsListSum;
			chartMakerCompsSum.itemsSource = makerCompsListSum;
			
			var ITMEList = JSON.parse(res).ITMEList;
			chartITME.itemsSource = ITMEList;	
			
			var ITMECompsList = JSON.parse(res).ITMECompsList;
			chartITMEComps.itemsSource = ITMECompsList;
			
			var ITMECompsListSum = JSON.parse(res).ITMECompsListSum;
			chartITMECompsSum.itemsSource = ITMECompsListSum;
			
			var comentList = JSON.parse(res).comentList;
			for (var i = 0; i < comentList.length; i++) {
				
				$("#text1").val(comentList[i].cmncn);
				/*if (comentList[i].cmnitm == 'C1') {
					$("#text1").val(comentList[i].cmncn);
				}
				
				if (comentList[i].cmnitm == 'C2') {
					$("#text2").val(comentList[i].cmncn);
				}		*/		
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
		
		header:{
			declarative:{
				text:$("#getDumcb").val()+'판매현황'
				//font: wijmo.pdf.PdfFont('helvetica',10,'nomal','bold') 
			}
		},
		footer:{
			declarative: {
                text: '\t&[Page]/&[Pages]',
                brush: '#3173c0'
                //font: wijmo.pdf.PdfFont('helvetica',10,'nomal','bold')
            }
			
		},
		//header:{height:0},
		//footer:{height:0},
			
		ended:function(sender,args){
			wijmo.pdf.saveBlob(args.blob,"판매계획대실적-월간보고.pdf")	
		}
	});
	
	chartMaker.saveImageToDataUrl(wijmo.chart.ImageFormat.Svg,function(url){
		//doc.drawText('월매상현황(MAKER)');
		doc.drawSvg(url,0,0,{height:400,width:350});
		
	})
	
	chartMakerComps.saveImageToDataUrl(wijmo.chart.ImageFormat.Svg,function(url){
		//doc.drawText('월매상현황(MAKER)');
		doc.drawSvg(url,410,0,{height:400,width:250});
	})
	
	chartMakerCompsSum.saveImageToDataUrl(wijmo.chart.ImageFormat.Svg,function(url){
		//doc.drawText('월매상현황(MAKER)');
		//doc.drawSvg(url,410,0,{height:400,width:250});
	})
	
	doc.end();
	
}


/**
  차트 초기화
 */
function chartInit() {
	
	chartMaker.initialize({
		header:'Maker별 판매현황',
		bindingX: 'maker',
		series: [
	    	{ name: '년간계획', binding: 'pcosty' },
	    	{ name: '단기계획', binding: 'pcostm' },
	    	{ name: '실적', binding: 'pcosts' }
	  	],
	
		dataLabel:{
			content:'{y}'
		},
		
		legend: {
            position: wijmo.chart.Position.Bottom
        },
		footer:'( 단위:백만W )'

	});
	
	chartMakerComps.initialize({
		header:'Maker 당월 판매현황',
		bindingX: 'maker',
		series: [
	    	{ name: '년간계획', binding: 'pcosty' },
	    	{ name: '단기계획', binding: 'pcostm' },
	    	{ name: '실적', binding: 'pcosts' }
	  	],
	
		dataLabel:{
			content:'{y}'
		},
		
		legend: {
            position: wijmo.chart.Position.Bottom
        },
		footer:'( 단위:백만W )'
	});
	
	chartMakerCompsSum.initialize({
		header:'Maker 누계 판매현황',
		bindingX: 'maker',
		series: [
	    	{ name: '년간계획', binding: 'pcosty' },
	    	{ name: '단기계획', binding: 'pcostm' },
	    	{ name: '실적', binding: 'pcosts' }
	  	],
	
		dataLabel:{
			content:'{y}'
		},
		
		legend: {
            position: wijmo.chart.Position.Bottom
        },
		footer:'( 단위:백만W )'
		
	});
	
	
		
	chartITME.initialize({
		header:'ITME별 판매현황',
		bindingX: 'maker',
		series: [
	    	{ name: '년간계획', binding: 'pcosty' },
	    	{ name: '단기계획', binding: 'pcostm' },
	    	{ name: '실적', binding: 'pcosts' }
	  	],
	
		dataLabel:{
			content:'{y}'
		},
		
		legend: {
            position: wijmo.chart.Position.Bottom
        },
		footer:'( 단위:백만W )'

	});
	
	chartITMEComps.initialize({
		header:'ITME 당월 판매현황',
		bindingX: 'maker',
		series: [
	    	{ name: '년간계획', binding: 'pcosty' },
	    	{ name: '단기계획', binding: 'pcostm' },
	    	{ name: '실적', binding: 'pcosts' }
	  	],
	
		dataLabel:{
			content:'{y}'
		},
		
		legend: {
            position: wijmo.chart.Position.Bottom
        },
		footer:'( 단위:백만W )'
	});
	
	chartITMECompsSum.initialize({
		header:'ITME 누계 판매현황',
		bindingX: 'maker',
		series: [
	    	{ name: '년간계획', binding: 'pcosty' },
	    	{ name: '단기계획', binding: 'pcostm' },
	    	{ name: '실적', binding: 'pcosts' }
	  	],
	
		dataLabel:{
			content:'{y}'
		},
		
		legend: {
            position: wijmo.chart.Position.Bottom
        },
		footer:'( 단위:백만W )'
		
	});
	
	//주석 표시기 사용 차트어떤부분이든 삽입가능함.
	var data = [
		{
            "type": "Text",
            "attachment": 2,
            "text": "단위:백만W",
            "position": 0,
            "point": { "x": 0.90, "y": 0.05 },
            "tooltip": "",
            "style": { "font-size": "11px", "font-weight": "bold"}
            
        }
	]
	//var basic = new wijmo.chart.annotation.AnnotationLayer(chartMaker,data);
}

/**
	버튼 이벤트 처리
 */
function handleEvent(){
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
	
	//셀렉트박스 미사용 사업부코드 제거
	$("#getLocCode option[value='H1']").remove();
	$("#getLocCode option[value='R1']").remove();
	
	chartInit();
	handleEvent();	//프로그램 버튼 이벤트
	calendar(); //캘린더
	new wijmo.nav.TabPanel("#theTabPanel");
	
});

