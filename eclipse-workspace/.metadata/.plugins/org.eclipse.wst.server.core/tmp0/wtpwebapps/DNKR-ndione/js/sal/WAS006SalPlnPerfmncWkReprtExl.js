//code intellisense typescript 정의
///<reference path = "../../wijmo/controls/wijmo.d.ts"/>	
///<reference path = "../../wijmo/controls/wijmo.grid.d.ts"/>
///<reference path = "../../wijmo/controls/wijmo.input.d.ts"/>

/// <reference path ="../../wijmo/controls/wijmo.chart.d.ts"/>
/// <reference path ="../../wijmo/controls/wijmo.chart.annotation.d.ts"/>
/// <reference path ="../../wijmo/controls/wijmo.chart.animation.d.ts"/>
/// <reference path ="../../wijmo/controls/wijmo.pdf.d.ts"/>
/// <reference path ="../../wijmo/controls/wijmo.nav.d.ts"/>
/// <reference path ="../../wijmo/controls/wijmo.grid.pdf.d.ts"/>
/// <reference path ="../../wijmo/controls/wijmo.pdf.d.ts"/>


//그리드
var cv = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수
var flexGrid = new wijmo.grid.FlexGrid('#wijmoGrid');	//그리드 전역변수
var zoomSize = 11;

//차트
var chartMaker = new wijmo.chart.FlexChart("#chartMaker");   //maker 별 판매계획 차트

//마지막날짜 변수
var getEndDay = "";

//주요품목
var majorItem_E1="CLUSTER, SMK, HUD";
var majorItem_C1="CVVT, OCV, COIL, FUEL PUMP 外";
var majorItem_S1="HVAC, ETC, BUS, W/M, WSW 外";

/**
 조회버튼
 */
function search(){
	var reprtse = "R1";
	var comps = "AL";
	
	//이번달 yyyyMM 취득
	var today = $("#today").val().replace(/-/gi, "");
	var getToday = today.substring(0,6);
	
	//같은 달 선택했는지 체크
	if (!dateCheck()) {
		return false;
	}
	
	var comentym = $("#startDate").val().replace(/-/gi, "");
	comentym = comentym.substring(0,6);
	
	//당월 마지막일 취득
	getLastDay(comentym);
	
	var url = '/ajaxSalPlnPerfmncWkReprtExl/search.do';
	var params = {
		'reprtse' : reprtse,
		'comps' : comps,
		'getPlngb' : $(".getPlngb").val(),
		'startDate':$("#startDate").val().replace(/-/gi, ""),
		'endDate':$("#endDate").val().replace(/-/gi, ""),
		'getDumcb':comentym,
		'getEndDay' : getEndDay,
		'getToday' : getToday,
		'majorItemE1': majorItem_E1,
		'majorItemC1': majorItem_C1,
		'majorItemS1': majorItem_S1
		
	};
	
	mask.open();
	$.ajax({
		method : "post",
		url : url,
		data :params,
		success : function(res) {
			/*var data = JSON.parse(res).list;
			cv.sourceCollection = data;*/
			
			var makerList = JSON.parse(res).makerList;
			chartMaker.itemsSource = makerList;	
			//getPrgrsRate(makerList);
			var data = JSON.parse(res).salPlnGrid;
			cv.sourceCollection = data;
			
			var progressRate = JSON.parse(res).progressRate;
			for (var i = 0; i < progressRate.length; i++) {
				$("#rate").text(progressRate[i].prgrsRate);
			}
			var commentList = JSON.parse(res).commentList;
			for (var i = 0; i < commentList.length; i++) {
				
				if (commentList[i].cmnitm == 'C1') {
					$("#text1").val(commentList[i].cmncn);
					$("#comps1").val(commentList[i].oldComps);
					$("#repym1").val(commentList[i].repym);
					$("#reprtse1").val(commentList[i].reprtse);
					$("#cmnitm1").val(commentList[i].cmnitm);
				}
				
				if (commentList[i].cmnitm == 'C2') {
					$("#text2").val(commentList[i].cmncn);
					$("#comps2").val(commentList[i].oldComps);
					$("#repym2").val(commentList[i].repym);
					$("#reprtse2").val(commentList[i].reprtse);
					$("#cmnitm2").val(commentList[i].cmnitm);
				}				
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
 * 월 마지막 날 구하기
 */
function getLastDay(getday) {
	var subYear = getday.substring(0,4);
	var subMn = getday.substring(4);
	getEndDay = (new Date(subYear, subMn,0)).getDate();
}


/**
 * pdf 다운로드
 */
function downloadPdf(){
	var doc = new wijmo.pdf.PdfDocument({
		compress:true,
		pageSettings:{
			layout:wijmo.pdf.PdfPageOrientation.Landscape,  //페이지 방향
			size:wijmo.pdf.PdfPageSize.A4,
			margins:{
			left:50,
			top:20,
			right:50,
			bottom:20
			}
		},
		
		ended:function(sender,args){
			wijmo.pdf.saveBlob(args.blob, LN_FILE_NM+'.pdf')
		}
		
	});
	
	//문서 폰트 등록
	doc.registerFont({
		source:"/fonts/NanumGothic.ttf",
		name:"nanum",
		style:"normal",
		weight:"normal",
		sansSerif:true
	});
	
	var font = new wijmo.pdf.PdfFont("nanum");

	//그리드 셋팅
	var settings = {
		//그리드 스타일 지정
		styles: {
            cellStyle: {
                backgroundColor: '#ffffff',
                borderColor: '#c6c6c6',
				font:{
					family:'nanum'
				}
            },
            altCellStyle: {
                backgroundColor: '#f9f9f9'
            },
            groupCellStyle: {
                backgroundColor: '#dddddd'
            },
            headerCellStyle: {
                backgroundColor: '#eaeaea'
            }
        },
		//그리드 폰트 적용
		embeddedFonts:{
			source:"/fonts/NanumGothic.ttf",
			name:"nanum",
			style:"normal",
			weight:"normal",
			sansSerif:true
		},
		//그리드 순번표시
		formatItem:function(args){
			if(args.panel.cellType == wijmo.grid.CellType.RowHeader){
				args.data = (args.row+1).toString();
			}
		}
		
    };
	chartMaker.saveImageToDataUrl(wijmo.chart.ImageFormat.Svg,function(url){
			//폰트를 글자에 적용시킴
			doc.drawText("ㅤ",null,null,{font:font});
			//폰트를 차트에 적용시킴
			//doc.drawSvg(url,null,null,{font:font},{height:100,width:100});
			doc.drawSvg(url,null,null,{font:font,height:230,width:730});
			
		});
	//doc.drawText("그리드 인쇄",300,300,{font:font});
	doc.moveDown(); //한줄 내리기(enter)
	//settings.customCellContent = true;   그리드 오류선색까지 모두 가져오기 그러나 한글이 깨짐
	wijmo.grid.pdf.FlexGridPdfConverter.draw(flexGrid,doc,700,null,settings);
	
	doc.moveDown();
	doc.drawText(LB_COMENT1,null,null,{font:font});
	doc.paths.rect(doc.x, doc.y, 700, 60).stroke();
	doc.drawText($('#text1').val(),null,null,{font:font});
	
	doc.moveDown(6);
	
	doc.drawText(LB_COMENT2,null,null,{font:font});
	doc.paths.rect(doc.x, doc.y, 700, 60).stroke();
	doc.drawText($('#text2').val(),null,null,{font:font});
	
	doc.end();
}

/**
  차트 초기화
 */
function chartInit() {
	
	chartMaker.initialize({
		header:LB_CHAR1,
		bindingX: 'maker',
		series: [
	    	{ name: LB_CHAR2, binding: 'pcosty' },
	    	{ name: LB_CHAR3, binding: 'pcostm' },
			{ name: LB_CHAR4, binding: 'pcostwk' },
			{ name: LB_PROGRECOMPR, binding: 'prgrsRate', chartType:'LineSymbols'},
	    	{ name: LB_CHAR5, binding: 'pcosts' }
			
	  	],
		axisY: {
            title: LB_PROGRECOMPR,
            axisLine: true
        },
		dataLabel:{
			content:'{y}'
		},
		
		legend: {
            position: wijmo.chart.Position.Bottom
        },
		footer:' '

	});
	var axisYQty = new wijmo.chart.Axis(wijmo.chart.Position.Right);
	chartMaker.axisLine = true;
	chartMaker.series[3].axisY = axisYQty;
	
}
/*	
	등록버튼
*/
function update(textNum){
	
	//레포트, 코멘트 변수
	var insReprtse = "R1";
	var insCmnitm1 = "C1";
	var insCmnitm2 = "C2";
	var insComps = "AL";
	
	var stateMsg=RESULT_OK;
	
	if(textNum == "1"){
		var cmncn =  $('#text1').val();
		var comps = $('#comps1').val();
		var reprtse = $('#reprtse1').val();
		var cmnitm = $('#cmnitm1').val();
		var insComps = insComps;
		var insReprtse = insReprtse;
		var insCmnitm = insCmnitm1;
	}else{
		var cmncn =  $('#text2').val();
		var comps = $('#comps2').val();
		var reprtse = $('#reprtse2').val();
		var cmnitm = $('#cmnitm2').val();
		var insComps = insComps;
		var insReprtse = insReprtse;
		var insCmnitm = insCmnitm2;
	}
	
	var comentym = $("#startDate").val().replace(/-/gi, "");
	comentym = comentym.substring(0,6);
	
	var url = "/ajaxSalAnlysComent/update2.do";
	var params = {
		'cmncn': cmncn,
		'comps': comps,
		'reprtse': reprtse,
		'cmnitm': cmnitm,
		'insComps': insComps,
		'insReprtse': insReprtse,
		'insCmnitm': insCmnitm,
		'getDumcb':comentym 
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
		$('._saveBtn1_').css('display', 'none');
		$('#pdfDown1').show();
		$('#text1').prop('readonly', true);
	} else {
		$('._saveBtn2_').css('display', 'none');
		$('#pdfDown2').show();
		$('#text2').prop('readonly', true);
	}
	
}


//그리드,차트,텍스트 리셋
function clearGrid(){
	chartMaker.itemsSource = []; //차트 refresh
	cv.sourceCollection=[];	 //그리드 refresh
	$('#text1').val("");//텍스트
	$('#text2').val("");
	$('#text1').css('readonly',true);
	$('#text2').css('readonly',true);
	$('.comment').css('display','none');
}

/**
	버튼 이벤트 처리
 */
function handleEvent(){
	
	//그리드엑셀다운
	$('.xlsDown').on('click', function() {
		grid.target.exportExcel("판매계획대실적-주간보고.xls");
	});
	
	
	//조회버튼->코멘트창
	$('#searchBtn').on('click', function() {
		$('.comment').show();
	});
	
	//수정버튼->등록버튼
	$('#pdfDown1').on('click', function() {
		$('#pdfDown1').css('display', 'none');
		$('._saveBtn1_').show();
		$('#text1').prop('readonly', false);
		
	});
	
	//수정버튼->등록버튼
	$('#pdfDown2').on('click', function() {
		$('#pdfDown2').css('display', 'none');
		$('._saveBtn2_').show();
		$('#text2').prop('readonly', false);
		
	});
	
}

/**
  그리드 초기화
 */
function gridInit() {
	//컬럼정의
	var columnsDefinition = [
		{ binding: 'comps', header: LB_LOCCODE, width: 70, align: 'center', dataType: 'String', isReadOnly: true }, //공장
		{ binding: 'maker', header: LB_MAJRITEM, width: 200, align: 'center', dataType: 'String', isReadOnly: true }, //주요품목
		{
			header: LB_SALPLAN, align: 'center', columns: [
				{ binding: 'pcosty', header: LB_YEARSUM, width: '*', align: 'center', dataType: 'String', isReadOnly: true }, //년계
				{ binding: 'pcostm', header: LB_SHTSUM, width: '*', align: 'center', dataType: 'String', isReadOnly: true }, //단계
				{ binding: 'ymrate', header: '%', width: '*', align: 'center', dataType: 'String', isReadOnly: true } //%
			]
		},
		{
			header: LB_SALPERFRMNC, align: 'center', columns: [
				{ binding: 'pcostwk', header: LB_ACHIVRATESTANDARD, width: '*', align: 'center', dataType: 'String', isReadOnly: true }, //년계
				{ binding: 'pcosts', header: LB_SALPERFRMNC, width: '*', align: 'center', dataType: 'String', isReadOnly: true }, //단계
				{ binding: 'pcostcal', header: LB_MARGIN, width: '*', align: 'center', dataType: 'String', isReadOnly: true } //%
			]
		},
		{
			header: LB_ACHIVRATE, align: 'center', columns: [
				{ binding: 'rate1', header: LB_YEARSUMCOMPR, width: '*', align: 'center', dataType: 'String', isReadOnly: true }, //년계비
				{ binding: 'rate2', header: LB_SHTSUMCOMPR, width: '*', align: 'center', dataType: 'String', isReadOnly: true } //단계비
			]
		}

	];
	//컬럼 초기화
	flexGrid.initialize({
		columns: columnsDefinition
	});

}

/*
	같은 달 선택 체크
*/
function dateCheck(){
	var selectStartDate = $('#startDate').val().substring(0,7);
	var selectEndDate = $('#endDate').val().substring(0,7);
	
	if( selectStartDate != selectEndDate){
	 	toastMsg(LB_DATEINFO);
		return false;
	}else{
		return true;
	}
}

function calendarFromTo(){
	var log_calendar = new ax5.ui.calendar({
        target: document.getElementById("log_calendar"),
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
			var date = JSON.stringify(log_calendar.getSelection());
            $(this.target).prev().val(date.substring(2,9)+"-01");
			$('#endDate').prop('disabled',false);
			dateCheck();
			//weekDate(dates);
        },
        onStateChanged: function () {
        }
    });
	$('.k_cg1 .dropdown').on('click', function(e){
		$($(e.target).next('.dropdown-menu')).css('display', 'block');
	});
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
        dimensions: {
            height: 250,
            controlHeight: 40,
            itemPadding: 1
        },
        lang: {
        	/*yearTmpl: "%s년",*/
            /*months: ['일월', '이월', '삼월', '사월', '오월', '육월', '칠월', '팔월', '구월', '시월', '십일월', '십이월'],*/
        	yearTmpl: YEAR_FORMAT,
        	months: MONTH,
        	dayTmpl: "%s"
        },
        onClick: function () {
            $(this.target).css('display', 'none');
			var date = JSON.stringify(chk_calendar.getSelection());
            $(this.target).prev().val(date.substring(2,12));
			dateCheck();
        },
        onStateChanged: function () {
            //console.log(this);
        }
    });
	
	$('.k_cg1 .dropdown').on('click', function(e){
		$($(e.target).next('.dropdown-menu')).css('display', 'block');
	});
}


$(document.body).ready(function() {
	
	//그리드 공통js 호출 후에 나머지 함수 호출함.
	$.getScript('/js/sal/gridCommon.js').done(function() {
		
		commonGrid.init(flexGrid,cv); //그리드 공통부분			
	
		gridInit();
		chartInit();
		handleEvent();	//프로그램 버튼 이벤트
		calendarFromTo();//년월 캘린더
		calendar();//년월일 캘린더
	  
	});
});

