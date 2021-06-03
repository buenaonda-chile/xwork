//code intellisense typescript 정의
///<reference path = "../../wijmo/controls/wijmo.d.ts"/>	
///<reference path = "../../wijmo/controls/wijmo.grid.d.ts"/>
///<reference path = "../../wijmo/controls/wijmo.grid.sheet.d.ts"/>
///<reference path = "../../wijmo/controls/wijmo.input.d.ts"/>

/// <reference path ="../../wijmo/controls/wijmo.chart.d.ts"/>
/// <reference path ="../../wijmo/controls/wijmo.pdf.d.ts"/>
/// <reference path ="../../wijmo/controls/wijmo.nav.d.ts"/>

var chartSalPln = new wijmo.chart.FlexChart("#chartSalPln");   //판매현황 계획실적 그래프 차트
var chart = new wijmo.chart.FlexChart("#chart");     // 주요상품별 사업계획 대비 증감수량

// 컬랙션 뷰는 조회후에 그리드의 상태변경을 체크한다. 
var cv = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수
var salPlnGrid = new wijmo.grid.sheet.FlexSheet("#salPlnGrid");	//판매현황

//체크된 체크박스
var slectCheckbox = "";
var arraySlectCheckbox = new Array();
var allCheckbox = "ALL";
/**
 조회버튼
 */
function search(){
	
	//사업부 변환
	var getOrgComps = $(".getComps").val();
	getCheckboxValue();
	//사업부 변환
	var getComps = "";
	if($(".getComps").val() == "PE"){
		getComps = "'E1'";
	}else if($(".getComps").val() == "PS"){
		getComps = "'S1','C1'";
	}else {
		getComps = "ALL";
	}
	 
	var url = '/ajaxSalPlnPerfmncMtReprtExl/search.do';
	var params = {
		'allCheckbox' : allCheckbox,
		'getCheckBox' : arraySlectCheckbox.toString(),
		'getComps' : getComps,
		'getDumcb' : $("#getDumcb").val().replace(/-/gi, ""),
		'getOrgComps' : getOrgComps
	};
		
	mask.open();
	$.ajax({
		method : "post",
		url : url,
		data :params,
		success : function(res) {
		
			// 판매현황 계획실적
			var salPlnList = JSON.parse(res).salPlnList;
			console.debug(salPlnList);
			chartSalPln.itemsSource = salPlnList;
			
			var chartList = JSON.parse(res).chartList;
			chart.itemsSource = chartList;
			
			// 코멘트
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
						
			//초기화
			salPlnGridInit();
			
			var salPlnGridList = JSON.parse(res).salPlnGrid;
			
			//salPlnGrid.sheets.clear();
			//DB에서 넘어오는 데이터값의 월별필드명을 보고 loop돌면서 컬럼 생성시켜야함.
			var cd1="";
			var cd2="";
			for(var i=0;i<salPlnGridList.length;i++){
				if(i==0){
					cd1 = salPlnGridList[i].cd1;
					cd2 = salPlnGridList[i].cd2;
				}
				if(salPlnGridList[i].cd1!=cd1 || salPlnGridList[i].cd2!=cd2){
					break;	
				}
				
				var c = new wijmo.grid.Column({binding:salPlnGridList[i].plnym,header:salPlnGridList[i].plnym ,width:'*',dataType:'Number',format:'c'});  
				salPlnGrid.columns.push(c);	
			}
			
			var totalArray = new Array(); 
			
			cd1="",cd2="";
			colN = 2;
			//그리드 첫행부터 loop돌면서
			salPlnGrid.beginUpdate();
			for(var i = 0;i<salPlnGridList.length;i++){
				
				if(i>0 && salPlnGridList[i].cd1!=cd1){
					salPlnGrid.rows.push(new wijmo.grid.Row());
					salPlnGrid.setCellData(salPlnGrid.rows.length-1,0,cd1);
					salPlnGrid.setCellData(salPlnGrid.rows.length-1,1,"TOTAL");
					for(var jj=2;jj<totalArray.length;jj++){
						salPlnGrid.setCellData(salPlnGrid.rows.length-1,jj,totalArray[jj]);
					}
					totalArray = new Array();
				}
				
				if(salPlnGridList[i].cd1!=cd1 || salPlnGridList[i].cd2!=cd2){
					salPlnGrid.rows.push(new wijmo.grid.Row());
					cd1 = salPlnGridList[i].cd1;
					cd2 = salPlnGridList[i].cd2;
					colN=2;
					 
				}
				
				salPlnGrid.setCellData(salPlnGrid.rows.length-1,0,salPlnGridList[i].cd1);
				salPlnGrid.setCellData(salPlnGrid.rows.length-1,1,salPlnGridList[i].cd2);
				//salPlnGrid.setCellData(i,salPlnGridList[i].plnym,salPlnGridList[i].data);
				salPlnGrid.setCellData(salPlnGrid.rows.length-1,colN,salPlnGridList[i].data);
				//totalArray[colN] = totalArray[colN]+salPlnGrid.getCellData(salPlnGrid.rows.length-1,colN,true);
				
				if(totalArray[colN]==undefined) totalArray[colN] = 0;
				
				totalArray[colN] = parseInt(totalArray[colN])+salPlnGridList[i].data;
				
				colN++;
				
			}
			salPlnGrid.endUpdate();
			arraySlectCheckbox = [];
			allCheckbox = "ALL";
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

//그리드,차트,텍스트 리셋
function clearGrid(num){
	if(num == '1'){
		$("#getComps option[value='AL']").prop('selected',true);
	}
	
	salPlnGrid.itemsSource = [];
	chart.itemsSource = [];
	chartSalPln.itemsSource = [];
	arraySlectCheckbox = [];
	$('.checkboxWrap').css('display','none');
	$('.close').css('display', 'none');
	$('.loadMore').show();
	$('#text1').val("");//텍스트
	$('#text2').val("");//텍스트
	$('#text1').css('readonly',true);
	$('#text2').css('readonly',true);
	$('.comment').css('display','none');
	
}

/*	
	등록버튼
*/
function update(textNum){
	
	if(textNum == "1"){
		var cmncn = $('#text1').text();
		var comps = $('#comps1').val();
		var reprtse = $('#reprtse1').val();
		var cmnitm = $('#cmnitm1').val();
		var insComps = $(".getComps").val();
		var insReprtse = "R2";
		var insCmnitm = "C1";
	}else{
		var cmncn =  $('#text2').text();
		var comps = $('#comps2').val();
		var reprtse = $('#reprtse2').val();
		var cmnitm = $('#cmnitm2').val();
		var insComps = $(".getComps").val();
		var insReprtse = "R2";
		var insCmnitm = "C2";
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
				alert(stateMsg);
				bntReset(textNum);
			} else {
				alert("OK");
				bntReset(textNum);
			}
		},
		error : function() {
			//console.log("dataset.error");
			//alert("error");
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
		$('._saveBtn1_').css('display', 'none');
		$('#pdfDown1').show();
		$('#text1').prop('readonly', true);
	} else {
		$('._saveBtn2_').css('display', 'none');
		$('#pdfDown2').show();
		$('#text2').prop('readonly', true);
	}
	
}
/*
	checkbox value 취득
*/
function getCheckboxValue(){
	
	if(slectCheckbox == "prdcdList"){
		if($("input:checkbox[id='prdcdAllList']").is(":checked")== true){
			allCheckbox = "ALL";
		}else{
		$("input:checkbox[name='prdcdList']:checked").each(function() {
			arraySlectCheckbox.push($(this).val());
			allCheckbox = "prdcdSelect";
 		});
		}
	}
	if(slectCheckbox == "prdcdE1List"){
		if($("input:checkbox[id='prdcdE1AllList']").is(":checked")== true){
			allCheckbox = "ALL";
		}else{
		$("input:checkbox[name='prdcdE1List']:checked").each(function() {
			arraySlectCheckbox.push($(this).val());
			allCheckbox = "prdcdSelect";
 		});
		}
	}
	if(slectCheckbox == "prdcdS1List"){
		if($("input:checkbox[id='prdcdS1AllList']").is(":checked")== true){
			allCheckbox = "ALL";
		}else{
		$("input:checkbox[name='prdcdS1List']:checked").each(function() {
			arraySlectCheckbox.push($(this).val());
			allCheckbox = "prdcdSelect";
 		});
		}
	}
}
/**
	버튼 이벤트 처리
 */
function handleEvent(){
		
	// 체크박스 - 전체선택
	$(".checkboxElemt").on("click",function(event){
		var val = $(event.target).val();
		if(val == "prdcdAllList"){
			if($(".prdcdAllList").prop("checked")){
				$(".prdcdAllList").prop('checked', false);
				$(event.target).prop('checked', false);
			}else{
				$(".prdcdAllList").prop('checked', true);
			}
		}
		if(val == "prdcdS1AllList"){
			if($(".prdcdS1List").prop("checked")){
				$(".prdcdS1List").prop('checked', false);
				$(event.target).prop('checked', false);
			}else{
				$(".prdcdS1List").prop('checked', true);
			}
		}
		if(val == "prdcdE1AllList"){
			if($(".prdcdE1List").prop("checked")){
				$(".prdcdE1List").prop('checked', false);
				$(event.target).prop('checked', false);
			}else{
				$(".prdcdE1List").prop('checked', true);
			}
		}
	});
	// 체크박스 - 부분선택 시, 전체선택 해제
	$(".prdcdE1List").on("click",function(){
		if($("#prdcdE1AllList").prop("checked")){
			$("#prdcdE1AllList").prop('checked', false);
		}
	});
	$(".prdcdS1List").on("click",function(){
		if($("#prdcdS1AllList").prop("checked")){
			$("#prdcdS1AllList").prop('checked', false);
		}
	});
	
	
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
			$(".checkboxS1List").css('display', 'none');
			slectCheckbox = "prdcdList";	
		}
		$(".checkboxWrap").show();
		$('.loadMore').css('display', 'none');
		$('.close').show();
	});
	
	$(".close").on("click",function(){
		$(".checkboxWrap").css('display', 'none');	
		$('.close').css('display', 'none');
		$('.loadMore').show();
		slectCheckbox = "";
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

/*
	checkbox 선택된 목록
*/
function getCheckboxVal(){
	var query = "input[name]"
}


/*차트 초기화*/
function chartInit() {

	//판매현황 계획실적
	chartSalPln.initialize({
		header:'판매현황 (계획/실적)',
		bindingX: 'plnym',
		series: [
	    	{ name: '계획', binding: 'pQtyM' },
	    	{ name: '실적', binding: 'pQtyS' },
	    	{ name: '달성율', binding: 'rate', chartType:'LineSymbols' }
	  	],
        axisY: {
            title: '계획/실적 (단위:백만W)',
            axisLine: true
        },
	  	
		dataLabel:{
			content:'{y}'
		},
		
		legend: {
            position: wijmo.chart.Position.Bottom
        },
		footer:'( 단위:백만W )'

	});
    
	//계획 실적부분
	/*var p1 = new wijmo.chart.PlotArea();
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
	*/
	
	var p1 = new wijmo.chart.PlotArea();
    p1.row = chart.plotAreas.length;
    p1.name = 'quantities';
    p1.height = '*';
	
	var axisYQty = new wijmo.chart.Axis(wijmo.chart.Position.Right);
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
        axisY: {
            title: '계획/실적 (단위:백만W)',
            axisLine: true
        },	  	
	
		dataLabel:{
			content:'{y}'
		},
		
		legend: {
            position: wijmo.chart.Position.Bottom
        },
		footer:'( 단위:백만W )'

	});
	
	//계획 실적부분
	/*var p = new wijmo.chart.PlotArea();
	p.row = chart.plotAreas.length;
	p.name ='amounts';
	p.height ='3*';
	
	chart.plotAreas.push(p);
	
	//차트 공백
	p = new wijmo.chart.PlotArea();
	p.row = chart.plotAreas.length;
	p.name = 'spacer';
	p.height = 35;
	
	chart.plotAreas.push(p);*/
	
	var p = new wijmo.chart.PlotArea();
    p.row = chart.plotAreas.length;
    p.name = 'quantities';
    p.height = '*';
	
	var axisYQty = new wijmo.chart.Axis(wijmo.chart.Position.Right);
	axisYQty.plotArea = p;
	
	chart.series[2].axisY = axisYQty;
	chart.plotAreas.push(p);
	
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
		/*footer: {
            declarative: {
                text: '\t&[Page]\\&[Pages]'   //페이지 번호
            }
    	},*/
		
		ended:function(sender,args){
			wijmo.pdf.saveBlob(args.blob,'판매계획대실적-주간엑셀.pdf')
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
	chartSalPln.saveImageToDataUrl(wijmo.chart.ImageFormat.Svg,function(url){
			//폰트를 글자에 적용시킴
			doc.drawText("1",null,null,{font:font});
			//폰트를 차트에 적용시킴
			//doc.drawSvg(url,null,null,{font:font},{height:100,width:100});
			doc.drawSvg(url,null,null,{font:font,height:280,width:700});
		});
	//doc.drawText("그리드 인쇄",300,300,{font:font});
	doc.moveDown(); //한줄 내리기(enter)
	//settings.customCellContent = true;   그리드 오류선색까지 모두 가져오기 그러나 한글이 깨짐
	wijmo.grid.pdf.FlexGridPdfConverter.draw(salPlnGrid,doc,700,null,settings);
	
	doc.moveDown(600);
	
	chart.saveImageToDataUrl(wijmo.chart.ImageFormat.Svg,function(url){
			//폰트를 글자에 적용시킴
			doc.drawText("1",null,null,{font:font});
			//폰트를 차트에 적용시킴
			//doc.drawSvg(url,null,null,{font:font},{height:100,width:100});
			doc.drawSvg(url,null,null,{font:font,height:280,width:700});
		});
	
	doc.moveDown();
	
	doc.drawText("코멘트1",null,null,{font:font});
	doc.paths.rect(doc.x, doc.y, 700, 40).stroke();
	doc.drawText($('#text1').val(),null,null,{font:font});
	
	doc.moveDown(3);
	
	doc.drawText("코멘트2",null,null,{font:font});
	doc.paths.rect(doc.x, doc.y, 700, 40).stroke();
	doc.drawText($('#text2').val(),null,null,{font:font});
	
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

function salPlnGridInit(){
	
	
	salPlnGrid.addUnboundSheet('sheet',0,0);
	salPlnGrid.isTabHolderVisible = false;	//엑셀시트 탭 비활성화
	salPlnGrid.allowMerging = true;
	salPlnGrid._contextMenu.show
	
	var c = new wijmo.grid.Column({header:LB_DSTNCTN,width:100,allowMerging:true});
	salPlnGrid.columns.push(c);
	
	var c = new wijmo.grid.Column({header:LB_LOC,width:100});
	salPlnGrid.columns.push(c);
	
	
	return;
	
	if(ii<3){
		salPlnGrid.setCellData(ii,0,"aa");
		salPlnGrid.setCellData(ii,2,12315);				
		//salPlnGrid.setCellData(ii,2,wijmo.Globalize.formatNumber(1234,'c'));
	}else{
		salPlnGrid.setCellData(ii,0,"bb");
	}
	if(ii==3){
		salPlnGrid.insertRows(ii,1);
		salPlnGrid.setCellData(ii,1,"TOTAL");
		salPlnGrid.setCellData(ii,2,45648);
		/*
		//wijmo.Globalize.formatNumber(12315,'c')
		salPlnGrid.applyCellsStyle({
			fontWeight: 'bold'
		},new wijmo.grid.CellRange(ii,1,ii,salPlnGrid.columns.length));
		*/
	}
	
	
	//salPlnGrid.setCellData(salPlnGrid.rows.length-1,0,"aa");
	
	//var cellRange = new wijmo.grid.CellRange(0, 0, 3, 0);
	//salPlnGrid.mergeRange(cellRange);
	
	
	//salPlnGrid.setCellData(0,0,"aa");
	
	
	
}	

$(document.body).ready(function() {
	
	
	$.getScript('/js/sal/gridCommon.js').done(function() {
		
		chartInit();
		commonGrid.init(salPlnGrid, cv); //그리드 공통부분
		salPlnGridInit();
		handleEvent();	//프로그램 버튼 이벤트
		calendar(); //캘린더
		new wijmo.nav.TabPanel("#theTabPanel");
		
	});

	
	
	
	
	
});

