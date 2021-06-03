//code intellisense typescript 정의
///<reference path = "../../wijmo/controls/wijmo.d.ts"/>	
///<reference path = "../../wijmo/controls/wijmo.grid.d.ts"/>
///<reference path = "../../wijmo/controls/wijmo.input.d.ts"/>

/// <reference path ="../../wijmo/controls/wijmo.chart.d.ts"/>
/// <reference path ="../../wijmo/controls/wijmo.pdf.d.ts"/>
/// <reference path ="../../wijmo/controls/wijmo.nav.d.ts"/>


var chartSalPln = new wijmo.chart.FlexChart("#chartSalPln");   //판매현황 계획실적 그래프 차트
var chart = new wijmo.chart.FlexChart("#chart");     // 주요상품별 사업계획 대비 증감수량

/**
 조회버튼
 */
function search(){
	
	if(!$(".getLocCode").val()){
		toastMsg(LN_SELECT_COMPS);
		return false;
	}
	
	var url = '/ajaxSalPlnPerfmncMtReprtExl/search.do';
	var params = {
		'getLocCode' : $(".getLocCode").val(),
		'getComps' : $("#getComps").val(),
		'getDumcb' : $("#getDumcb").val().replace(/-/gi, "")
	};
		
	mask.open();
	$.ajax({
		method : "post",
		url : url,
		data :params,
		success : function(res) {
		
			// 판매현황 계획실적
			var salPlnList = JSON.parse(res).salPlnList;
			chartSalPln.itemsSource = salPlnList;
			
			//alert(JSON.stringify(salPlnList));
		
			// 주요상품별 사업계획 대비 증감수량
			var data = JSON.parse(res).list;
			
			var chartList = JSON.parse(res).chartList;
			chart.itemsSource = chartList;
			var date = $("#getDumcb").val();
			$('.title2').text("2."+date.substring(2,6)+LB_YAER+date.substring(7,9)+LB_MM+LB_TITLE2);
			
			//alert("date"+ date);
			
			// 코멘트
			var comentList = JSON.parse(res).comentList;
			
			for (var i = 0; i < comentList.length; i++) {
				
				if (comentList[i].cmnitm == 'C1') {
					$("#text1").val(comentList[i].cmncn);
				}
				
				if (comentList[i].cmnitm == 'C2') {
					$("#text2").val(comentList[i].cmncn);
				}				
				
			}
			
			//alert(JSON.stringify(comentList));
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
 * 엑셀 다운로드
 */
function downloadExcel(){
	
	var fileName = '엑셀.xlsx';
	transExcel(flexGrid,fileName);
	
}

/**
	버튼 이벤트 처리
 */
function handleEvent(){
		
	// 체크박스 - 전체선택
	$(".allCheck").on("click",function(){
		if($(".check_all_list").prop("checked")){
			$(".check_all_list").prop('checked', false);
			$(".allCheck").prop('checked', false);
		}else{
			$(".check_all_list").prop('checked', true);
		}
	});
	// 체크박스 - 부분선택 시, 전체선택 해제
	$(".check_all_list").on("click",function(){
		if($(".allCheck").prop("checked")){
			$(".allCheck").prop('checked', false);
		}
	});
	// 더보기버튼
	$(".loadMore").on("click",function(){
		$(".checkboxList").show();
	});
	
}

/*차트 초기화*/
function chartInit() {

	//판매현황 계획실적
	chartSalPln.initialize({
		header:'판매현황 (계획/실적)',
		bindingX: 'itemCd',
		series: [
	    	{ name: '계획', binding: 'pQtyM' },
	    	{ name: '실적', binding: 'pQtyS' },
	    	{ name: '달성율', binding: 'rate',chartType:'LineSymbols' }
	  	],
	
		dataLabel:{
			content:'{y}'
		},
		
		legend: {
            position: wijmo.chart.Position.Bottom
        },
		footer:'( 단위:백만W )'

	});
	
	//계획 실적부분
	var p1 = new wijmo.chart.PlotArea();
	p1.row = chart.plotAreas.length;
	p1.name ='amounts';
	p1.height ='3*';
	
	chartSalPln.plotAreas.push(p1);
	
	//차트 공백
	p1 = new wijmo.chart.PlotArea();
	p1.row = chart.plotAreas.length;
	p1.name = 'spacer';
	p1.height = 35;
	
	chartSalPln.plotAreas.push(p1);
	
	p1 = new wijmo.chart.PlotArea();
    p1.row = chart.plotAreas.length;
    p1.name = 'quantities';
    p1.height = '*';
	
	var axisYQty = new wijmo.chart.Axis(wijmo.chart.Position.Left);
	axisYQty.plotArea = p1;
	
	chartSalPln.series[2].axisY = axisYQty;
	chartSalPln.plotAreas.push(p1);

	
	
	// 주요상품별 사업계획 대비 증감수량
	chart.initialize({
		header:'주요제품별 판매현황 (계획/실적)',
		bindingX: 'itemCd',
		series: [
	    	{ name: '계획', binding: 'pQtyM' },
	    	{ name: '실적', binding: 'pQtyS' },
	    	{ name: '달성율', binding: 'rate',chartType:'LineSymbols' }
	  	],
	
		dataLabel:{
			content:'{y}'
		},
		
		legend: {
            position: wijmo.chart.Position.Bottom
        },
		footer:'( 단위:백만W )'

	});
	
	//계획 실적부분
	var p = new wijmo.chart.PlotArea();
	p.row = chart.plotAreas.length;
	p.name ='amounts';
	p.height ='3*';
	
	chart.plotAreas.push(p);
	
	//차트 공백
	p = new wijmo.chart.PlotArea();
	p.row = chart.plotAreas.length;
	p.name = 'spacer';
	p.height = 35;
	
	chart.plotAreas.push(p);
	
	p = new wijmo.chart.PlotArea();
    p.row = chart.plotAreas.length;
    p.name = 'quantities';
    p.height = '*';
	
	var axisYQty = new wijmo.chart.Axis(wijmo.chart.Position.Left);
	axisYQty.plotArea = p;
	
	chart.series[2].axisY = axisYQty;
	chart.plotAreas.push(p);
	
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
				text:$("#getDumcb").val()+'판매현황(계획/실적)'
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
			wijmo.pdf.saveBlob(args.blob,"판매현황(계획/실적).pdf")	
		}
	});
	
	chartSalPln.saveImageToDataUrl(wijmo.chart.ImageFormat.Svg,function(url){
		doc.drawSvg(url,0,0,{height:400,width:350});
		
	})
	
	chart.saveImageToDataUrl(wijmo.chart.ImageFormat.Svg,function(url){
		doc.drawSvg(url,410,0,{height:400,width:250});
	})
	
	doc.end();
	
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

