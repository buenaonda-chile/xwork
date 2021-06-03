//code intellisense typescript 정의
///<reference path = "../../wijmo/controls/wijmo.d.ts"/>	
///<reference path = "../../wijmo/controls/wijmo.grid.d.ts"/>
///<reference path = "../../wijmo/controls/wijmo.input.d.ts"/>

/// <reference path ="../../wijmo/controls/wijmo.chart.d.ts"/>
/// <reference path ="../../wijmo/controls/wijmo.chart.annotation.d.ts"/>
/// <reference path ="../../wijmo/controls/wijmo.pdf.d.ts"/>
/// <reference path ="../../wijmo/controls/wijmo.nav.d.ts"/>

//차트
var chartMaker = new wijmo.chart.FlexChart("#chartMaker");   //maker 별 판매계획 차트

var currGridIndex,
    dataLength = 0,
    popGugn;
/**
 * [KO] 그리드에 data 셋팅
 * @param params Obj 
 * @param _pageNo
 * @param gridTarget
 */
function setList(params, _pageNo, gridTarget) {
	var ajaxParams = params;
	
	$.ajax({
		method : "post",
		url : "/ajaxSalPlnPerfmncWkReprtExl/init.do",
		data : ajaxParams,
		success : function(res) {
			/*
			var data = JSON.parse(res);
			
			if (data.list.length > 0) {
				gridTarget.setData({
					list : data.list,
					page : {
						currentPage : _pageNo || 0,
						pageSize : 50,
						totalElements : 500,
						totalPages : 100
					}
				});

				setTimeout(function() {
					mask.close();
				}, 1000);
			} else {
				gridDataInit(gridTarget);
				
				setTimeout(function() {
					mask.close();
					toastMsg(LN_NO_DATA);
				}, 1000);
			}
			*/
		},
		error : function() {
			//console.log("error");
		},
		complete : function() {
			//console.log("completed");			
			//gridBtnInit();
			setTimeout(function() {
				mask.close();
			}, 1000);			
		}
	});
}

/**
 * ==================================================================== 
 * [KO] Function: 그리드 빈값으로 초기화. <br>
 * [KO] Argument: [1st argument] 초기화할 그리드 <br>
 * [KO] Summary : 이함수는 그리드를 빈값으로 초기화한다. <br>
 * [EN] Summary : <br>
 * ====================================================================
 */
function gridDataInit(gridTarget) {
	gridTarget.setData({
		list : [],
		page : {
			currentPage : 0,
			pageSize : 50,
			totalElements : 500,
			totalPages : 100
		}						
	});
}
// ===================== 그리드 ====================================/
var grid;

var grid = {
	initView : function(labels) {
		this.target = new ax5.ui.grid();
		this.target
				.setConfig({
					target : $('[data-ax5grid="grid"]'),
					frozenRowIndex : 0,
					showLineNumber : true,
					rowSelectorColumnWidth : 25,
					header : {
						align : "center",
						columnHeight : 28
					},
					body : {
						align : "center",
						columnHeight : 28,
						onClick : function() {
							currGridIndex = this.dindex;

							this.self.clearSelect();
							this.self.select(this.dindex);
						},
					},
					contextMenu : {
						iconWidth : 20,
						acceleratorWidth : 100,
						itemClickAndClose : false,
						icons : {
							'arrow' : '<i class="fa fa-caret-right"></i>'
						},
						popupFilter : function(item, param) {
							if (param.element) {
								return true;
							} else {
								return item.type == 1;
							}
						},
						onClick : function(item, param) {
							grid.target.contextMenu.close();
						}
					},
					page : {
						navigationItemCount : 1,
						height : 30,
						display : false,
						firstIcon : '<i class="fa fa-step-backward" aria-hidden="true"></i>',
						prevIcon : '<i class="fa fa-caret-left" aria-hidden="true"></i>',
						nextIcon : '<i class="fa fa-caret-right" aria-hidden="true"></i>',
						lastIcon : '<i class="fa fa-step-forward" aria-hidden="true"></i>',
						onChange : function() {
							gridView.setData(this.page.selectPage);
						}
					},
					columns : [
						// 첫번째 컬럼에 선택 css 가 있어 숨김 컬럼을 추가.
						{
							key : "",						
							label : "",
							width : 0
						}, {
							key : "standrd",
//							label : "기준",
							label : labels.standrd.label,
							width : 50,
							align : "center",
							columns : [
								{
									key : "locNm",
									width : 50,
//									label : "공장",
									label : labels.locNm.label,
									align : "center"
								}
							  ]
						}, {
							key : "date",
//							label : "기준일자",
//							label : labels.standrd.label,
							width : 90,
							columns : [
								{
									key : "majrItem",
									width : 180,
//									label : "주요품목",
									label : labels.majrItem.label,
									align : "center"
								}
							  ]
						}, {
							key : "",
//							width : 240,
							label : "",
//							label : labels.salPlan.label,
							columns : [
								{
									key : "salPlan",
									width : 100,
//									label : "판매계획",
									label : labels.salPlan.label,
									align : "center",
									columns : [
										{
											key : "yearSum",
											width : 100,
//											label : "년계",
											label : labels.yearSum.label,
											align : "center"
										}
					        		 ]
								}
					          ]
						}, {
							key : "",
//							width : 240,
							label : "",
//							label : labels.salPlan.label,
							columns : [
								{
									key : "salPlan",
									width : 100,
//									label : "판매계획",
									label : labels.salPlan.label,
									align : "center",
									columns : [
										{
											key : "shtSum",
											width : 100,
//											label : "단계",
											label : labels.shtSum.label,
											align : "center"
										}
					        		 ]
								}
					          ]
						},{
							key : "",
//							width : 240,
							label : "",
//							label : labels.salPlan.label,
							columns : [
								{
									key : "salPlan",
									width : 100,
//									label : "판매계획",
									label : labels.salPlan.label,
									align : "center",
									columns : [
										{
											key : "prcnt",
											width : 100,
//											label : "%",
											label : "%",
											align : "center"
										}
					        		 ]
								}
					          ]
						},{
							key : "mnUnit",
//							width : 240,
//							label : "금액단위",
							label : labels.mnUnit.label,
							columns : [
								{
									key : "salPerfrmnc",
									width : 100,
//									label : "판매실적",
									label : labels.salPerfrmnc.label,
									align : "center",
									columns : [
										{
											key : "achivRateStandard",
											width : 100,
//											label : "진도율기준",
											label : labels.achivRateStandard.label,
											align : "center"
										}
					        		 ]
								}
					          ]
						}, {
							key : "",
//							width : 240,
							label : "",
//							label : labels.salPlan.label,
							columns : [
								{
									key : "salPerfrmnc",
									width : 100,
//									label : "판매실적",
									label : labels.salPerfrmnc.label,
									align : "center",
									columns : [
										{
											key : "salPerfrmnc",
											width : 100,
//											label : "판매실적",
											label : labels.salPerfrmnc.label,
											align : "center"
										}
					        		 ]
								}
					          ]
						},{
//							key : "",
//							width : 240,
							label : "",
							columns : [
								{
									key : "salPerfrmnc",
									width : 100,
//									label : "판매실적",
									label : labels.salPerfrmnc.label,
									align : "center",
									columns : [
										{
											key : "margin",
											width : 100,
//											label : "차이",
											label : labels.margin.label,
											align : "center"
										}
					        		 ]
								}
					          ]
						},{
//							key : "progrsRate",
							width : 100,
//							label : "진도율",
							label : labels.progrsRate.label,
							columns : [
								{
									key : "achivRate",
									width : 100,
//									label : "달성률",
									label : labels.achivRate.label,
									align : "center",
									columns : [
										{
											key : "yearSumCompr",
											width : 100,
//											label : "년계비",
											label : labels.yearSumCompr.label,
											align : "center"
										}
					        		 ]
								}
					          ]
						},{
							key : "progrsRate",
							width : 100,
//							label : "진도율",
//							label : labels.progrsRate.label,
							columns : [
								{
									key : "achivRate",
									width : 100,
//									label : "달성률",
									label : labels.achivRate.label,
									align : "center",
									columns : [
										{
											key : "shtSumCompr",
											width : 100,
//											label : "단계삐",
											label : labels.shtSumCompr.label,
											align : "center"
										}
					        		 ]
								}
					          ]
						}],
						footSum : [
							[
								{},
								{
									label : "TOTAL",
									colspan : 2,
									align : "center"
								},
								{
									key : "yearSum",
									collector : "sum",
									formatter : "number",
									align : "center"
								},
								{
									key : "shtSum",
									collector : "sum",
									formatter : "number",
									align : "center"
								},
								{
									key : "%",
									collector : "sum",
									formatter : "number",
									align : "center"
								},
								{
									key : "achivRateStandard",
									collector : "sum",
									formatter : "number",
									align : "center"
								},
								{
									key : "salPerfrmnc",
									collector : "sum",
									formatter : "number",
									align : "center"
								},
								{
									key : "margin",
									collector : "sum",
									formatter : "number",
									align : "center"
								},
								{
									key : "yearSumCompr",
									collector : "sum",
									formatter : "number",
									align : "center"
								},
								{
									key : "shtSumCompr",
									collector : "sum",
									formatter : "number",
									align : "center"
								}
							]/*,
							[
								{},
								{
									label : "TOTAL",
									colspan : 2,
									align : "center"
								},
								{},
								{},
								{},
								{
									label : "progreCompr",
									colspan : 3,
									align : "center"
								},
								{
									key : "yearSumCompr",
									collector : "sum",
									formatter : "number",
									align : "center"
								},
								{
									key : "shtSumCompr",
									collector : "sum",
									formatter : "number",
									align : "center"
								},
							]*/
						]	
				});
		this.target.onLoad = function() {
			//console.log("");
		}
		return this;
	},
	setData : function(_pageNo) {
		mask.open();
		var gridTarget = this.target;
		var params = {

		};
		setList(params, _pageNo, gridTarget);

		return this;
	}
};

/**
 조회버튼
 */
function search(){
	
	var url = '/ajaxSalPlnPerfmncWkReprtExl/search.do';
	var params = {
		'getDumcb':$("#getDumcb").val().replace(/-/gi, "")
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
			//alert(JSON.stringify(makerList));
			
			var comentList = JSON.parse(res).comentList;
			for (var i = 0; i < comentList.length; i++) {
				
				if (comentList[i].cmnitm == 'C1') {
					$("#text1").val(comentList[i].cmncn);
				}
				
				if (comentList[i].cmnitm == 'C2') {
					$("#text2").val(comentList[i].cmncn);
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
				text:'판매계획대실적-주간보고'
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
			wijmo.pdf.saveBlob(args.blob,"판매계획대실적-주간보고.pdf")	
		}
	});
	
	chartMaker.saveImageToDataUrl(wijmo.chart.ImageFormat.Svg,function(url){
		//doc.drawText('월매상현황(MAKER)');
		doc.drawSvg(url,0,0,{height:400,width:350});
		
	})
	doc.end();
	
}

/**
  차트 초기화
 */
function chartInit() {
	
	chartMaker.initialize({
		header:'공장별 판매현황',
		bindingX: 'maker',
		series: [
	    	{ name: '년간계획', binding: 'pcosty' },
	    	{ name: '단기계획', binding: 'pcostm' },
			/*{ name: '진도율기준', binding: 'stndrd' },*/
	    	{ name: '실적', binding: 'pcosts' }
	  	],
	
		dataLabel:{
			content:'{y}'
		},
		
		legend: {
            position: wijmo.chart.Position.Bottom
        },
		footer:'( 단위:억W )'

	});
	
	
	
	//주석 표시기 사용 차트어떤부분이든 삽입가능함.
	var data = [
		{
            "type": "Text",
            "attachment": 2,
            "text": "단위:억W",
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
	
	//그리드엑셀다운
	$('.xlsDown').on('click', function() {
		grid.target.exportExcel("판매계획대실적-주간보고.xls");
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
	 
	gridinit();
	chartInit();
	handleEvent();	//프로그램 버튼 이벤트
	calendar(); //캘린더
	new wijmo.chart.FlexChart("#chartMaker");  
	
});

