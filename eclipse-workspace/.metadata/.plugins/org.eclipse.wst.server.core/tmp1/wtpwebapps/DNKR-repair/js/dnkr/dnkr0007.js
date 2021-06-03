//code intellisense typescript 정의
///<reference path = "../../wijmo/controls/wijmo.d.ts"/>	
///<reference path = "../../wijmo/controls/wijmo.grid.d.ts"/>
///<reference path = "../../wijmo/controls/wijmo.grid.detail.d.ts"/>
///<reference path = "../../wijmo/controls/wijmo.grid.sheet.d.ts"/>
///<reference path = "../../wijmo/controls/wijmo.input.d.ts"/>
///<reference path = "../../wijmo/controls/wijmo.grid.cellmaker.d.ts"/>

/// <reference path ="../../wijmo/controls/wijmo.chart.d.ts"/>
/// <reference path ="../../wijmo/controls/wijmo.pdf.d.ts"/>
/// <reference path ="../../wijmo/controls/wijmo.nav.d.ts"/>


// 컬랙션 뷰는 조회후에 그리드의 상태변경을 체크한다. 

var chart = new wijmo.chart.FlexChart('#wijmoChart');	//그리드 전역변수

var comboStatus = new wijmo.input.ComboBox("#div");	//구분

var sdat = new wijmo.input.InputDate("#searchDtFr");	//일자 시작
		
var edat = new wijmo.input.InputDate("#searchDtTo");	//일자 종료

/**
	버튼 이벤트
 */
var handleEvent = function(){
	
	$("#btn_search").on("click",search);

}

//조회
var search = function(){
	
	var url = '/kpiManagementDNKR/search';
	
	var params = {
		"searchDtFr" : wijmo.Globalize.format(sdat.value,'yyyyMMdd'),
		"searchDtTo" : wijmo.Globalize.format(edat.value,'yyyyMMdd'),
		"div" : comboStatus.selectedValue,
		"page":1
	};
	
	
	$.ajax({
		method : "get",
		url : url,
		data :params,
		beforeSend:function(){
			_dicasPage.maskOpen();
		},
		success : function(res) {
			var data = res.data.contents;
			chart.itemsSource = data;
						
		},
		error : function() {
			console.log("dataset.error");
			
		},
		complete : function() {
			_dicasPage.maskClose();
		}
	});
	
}

/**
 날짜변경시 차트 초기화
 */
var clearChart = function(){
	chart.itemsSource =[];
}


/**
  차트 초기화
 */
var chartInit = function() {
	
	chart.initialize({
		header : 'KPI 실적',
		bindingX : '',
		
		series : [
				{name:'',binding:''},
				{name:'',binding:''},
		],
		
		axisY: {
			title: "",
			axisLine: true
		},
		
		dataLabel: {
			content: '{value:n0}',
			offset:10,
			position:'Top',  // Top, Left, Right, Center, Bottom, None
			connectingLine : true
		},
		
		legend: {
			position: wijmo.chart.Position.Bottom
		},
		
		footer: ""
	});
	
	var axisY = new wijmo.chart.Axis(wijmo.chart.Position.Right);
	axisY.axisLine = true;
	chart.series[1].axisY = axisY;
}

/**
	콤보박스 초기화
 */
var statusInit = function(){
	
	comboStatus.displayMemberPath = "codeNm";
	comboStatus.selectedValuePath = "codeCd";
	
	var statusList= new wijmo.collections.ObservableArray([{codeNm:"전체",codeCd:""}]);
	var url = '/code/list2.json/REST';
	
	$.ajax({
		method : "post",
		url : url,
		//data:params,
		async:false,
		dataType :"json",
		success : function(res) {
			
			$.each(res.data,function(index,item){
				statusList.push(item);
			});
			
			comboStatus.itemsSource =statusList;
			
		},
		error : function() {
			console.log("dataset.error");
			
		},
		complete : function() {
			
		}
	});
	
}

/**
	기간 일자 초기화
 */
var srcDatInit = function(){
	
	sdat.isRequired = false;
	//sdat.value = null;		//주석처리할경우 오늘날짜 자동으로 박힘.
	sdat.placeholder = "일자";
	sdat.format = "yyyyMMdd";
	commonInput.calendarInit(sdat);
	
	edat.isRequired = false;
	//edat.value = null;
	edat.placeholder = "일자";
	edat.format = "yyyyMMdd";
	commonInput.calendarInit(edat);
}

var getFormatDate = function(date){
	
	var year =  date.getFullYear();
	var month = (1 + date.getMonth());
	month = month >= 10 ? month : '0' + month;
	var day = date.getDate();
	day = day >=10 ? day : '0' + day;
	var id = '000000';
	if(id<99999) id++;
	return year+"-"+month+"-"+day;
	
}

$(document.body).ready(function() {
	
	//그리드 공통js 호출 후에 나머지 함수 호출함.
	$.when(
		$.getScript('/js/wijmo/commonGrid.js'),
		$.getScript('/js/wijmo/commonInput.js')
	).done(function() {
		
		statusInit();	//진행상태 콤보박스 초기화
		srcDatInit();	//일자 초기화
		handleEvent();	//프로그램 버튼 이벤트
		
		chartInit();
		
		search();		//조회
	});
	
	
	
});
