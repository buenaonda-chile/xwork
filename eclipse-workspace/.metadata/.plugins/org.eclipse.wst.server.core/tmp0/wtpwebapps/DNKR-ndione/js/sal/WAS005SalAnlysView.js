//code intellisense typescript 정의
///<reference path = "../../wijmo/controls/wijmo.d.ts"/>	
///<reference path = "../../wijmo/controls/wijmo.grid.d.ts"/>
///<reference path = "../../wijmo/controls/wijmo.input.d.ts"/>

/// <reference path ="../../wijmo/controls/wijmo.chart.d.ts"/>
/// <reference path ="../../wijmo/controls/wijmo.chart.annotation.d.ts"/>
/// <reference path ="../../wijmo/controls/wijmo.pdf.d.ts"/>
/// <reference path ="../../wijmo/controls/wijmo.nav.d.ts"/>
/// <reference path ="../../wijmo/controls/wijmo.grid.pdf.d.ts"/>
/// <reference path ="../../wijmo/controls/wijmo.pdf.d.ts"/>

var cv = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수
var popCv = new wijmo.collections.CollectionView(null);	//팝업그리드 컬렉션뷰

var flexGrid = new wijmo.grid.FlexGrid('#wijmoGrid');	//그리드 전역변수
var popGrid  = new wijmo.grid.FlexGrid("#popGrid");		//팝업그리드

var zoomSize = 11;
var grid1 = [];
var grid2 = [];
var grid3 = [];
var grid4 = [];

/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
"use strict";

var currGridIndex,
	dataLength = 0,
	popGugn,
	bntVal = "",
	getStartYm = "",
	getPlnym = "",
	getEndYm = "";


/**
 * ======================================
 * [ko] 정보 검색하는 함수<br>
 * ======================================
 */
function search() {

	//gridBtnInit();
	if (!dateCheckMsg() || !prdcdAsc()) {
		return false;
	}
	
	var compsValue = $(".getComps").val();
	var getPrdcd1 = ""; //제품코드1
	var getPrdcd2 = ""; //제품코드2
	var getEndccd = ""; //최종고객구분

	if (compsValue == "ALL") {
		getEndccd = $(".getEndccdAll").val();
	} else if (compsValue == "PE") {
		getPrdcd1 = $("#getPrdcdE1").val();
		getPrdcd2 = $("#getPrdcd2E1").val();
		getEndccd = $(".getEndccdPE").val();
	} else {
		getPrdcd1 = $("#getPrdcdS1").val();
		getPrdcd2 = $("#getPrdcd2S1").val();
		getEndccd = $(".getEndccdPS").val();
	}

	var getPyvnd2 = $("#getPyvnd2").val();
	if (getPyvnd2 == "") {
		getPyvnd2 = "99999999";
	}

	//gridDataInit(grid.target);

	mask.open();
	$.ajax({
		method: "post",
		url: "/ajaxSalAnlysView/search.do",
		data: {
			"getComps": compsValue, //사업부
			"getPltcd": $(".getPltcd").val(), //공장구분
			"getPlnym": $(".getPlnym").val().replace(/-/gi, ""), //계획년월
			"getPyvnd1": $("#getPyvnd1").val(), //업체코드1
			//"getPyvnd2" : $("#getPyvnd2").val(), //업체코드2
			"getPyvnd2": getPyvnd2, //업체코드2
			"getPrdcd1": getPrdcd1, //제품코드1
			"getPrdcd2": getPrdcd2, //제품코드2
			"getEndccd": getEndccd, //최종고객구분
			"getPaygub": $(".getPaygub").val(), //납입구분
			"startDate": $("#startDate").val().replace(/-/gi, ""), //출하일자-start 
			"endDate": $("#endDate").val().replace(/-/gi, ""), //출하일자 -end
			"getPlngb": $("#getPlngb").val(), //계획구분	
			"getSelectgub": $(".getSelectgub").val() //조회구분

		},
		success: function(res) {
			var data = JSON.parse(res).list;
			cv.sourceCollection = data;
			
			//Add total row
			//조회구분에 따라 columns 구분
			var getSelectgub = $(".getSelectgub").val();
			var columnsNo = 0;
			if(getSelectgub == "1" || getSelectgub == "2"){
				columnsNo = 3;
			}else{
				columnsNo = 5;
			}
			flexGrid.rows.push(new wijmo.grid.Row());
			flexGrid.setCellData(flexGrid.rows.length - 1, "comps", "TOTAL");
			
			var sum = 0;
			for(var i = columnsNo; i<flexGrid.columns.length; i++){
				for(var j = 0; j<flexGrid.rows.length-1; j++){
					var getData = parseFloat(flexGrid.getCellData(j,i,false));
					sum += getData;
				}
				flexGrid.setCellData(flexGrid.rows.length - 1, i, sum);
				sum = 0;
			}
			
			setTimeout(function() {
					mask.close();
				}, 500);

		},
		error: function() {
			//console.log("dataset.error");
		},
		completed: function() {
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
function downloadExcel() {

	var fileName = LB_XLSXTITLE+'.xlsx';

	wijmo.grid.xlsx.FlexGridXlsxConverter.saveAsync(flexGrid,
		{ includeColumnHeaders: true },
		fileName,
		function(base64) {
			// user can access the base64 string in this callback.
			document.getElementById('importFile').href = 'data:application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;' + 'base64,' + base64;
			//console.log(base64);
		},
		function(reason) {
			//User can catch the failure reason in this callback.
			//console.log('The reason of save failure is ' + reason);
		}
	);
}

/**
  그리드
 */
function gridInit() {
	//제품별
	grid1 = [
		{ binding: 'comps', header: LB_COMPS, width: '*', align: 'center', dataType: 'String', isReadOnly: true,allowMerging: true}, //사업부
		{ binding: 'prdcd', header: LB_PRDCD, width: '*', align: 'center', dataType: 'String', isReadOnly: true,allowMerging: true}, //제품
		{ binding: 'prdnm', header: LB_PRDNM, width: '*', align: 'center', dataType: 'String', isReadOnly: true,allowMerging: true}, //제품명
		{
			header: LB_QTY, align: 'center', columns: [ //수량
				{ binding: 'pQtyY', header: LB_YSUM, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //년계
				{ binding: 'pQtyM', header: LB_MSUM, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //단계
				{ binding: 'pQtyS', header: LB_PAYSUM, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //판매실적
				{
				header: LB_YSUM, align: 'center', columns: [ //년계
					{ binding: 'pQtyYgp', header: LB_GAP, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //차이
					{ binding: 'pQtyYflat', header: LB_ACHIRATE, width: '*', align: 'right', dataType: 'Number', isReadOnly: true } //달성률
				
				]
				},
				{
				header: LB_MSUM, align: 'center', columns: [ //단계
					{ binding: 'pQtyMgp', header: LB_GAP, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //차이
					{ binding: 'pQtyMflat', header: LB_ACHIRATE, width: '*', align: 'right', dataType: 'Number', isReadOnly: true } //달성률
				
				]
				},
			]
		},
		{
			header: LB_AMOUNT, align: 'center', columns: [ //금액
				{ binding: 'pCostY', header: LB_YSUM, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //년계
				{ binding: 'pCostM', header: LB_MSUM, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //단계
				{ binding: 'pCostS', header: LB_PAYSUM, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //판매실적
				{
				header: LB_YSUM, align: 'center', columns: [ //년계
					{ binding: 'pCostYgp', header: LB_GAP, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //차이
					{ binding: 'pCostYflat', header: LB_ACHIRATE, width: '*', align: 'right', dataType: 'Number', isReadOnly: true } //달성률
				
				]
				},
				{
				header: LB_MSUM, align: 'center', columns: [ //단계
					{ binding: 'pCostMgp', header: LB_GAP, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //차이
					{ binding: 'pCostMflat', header: LB_ACHIRATE, width: '*', align: 'right', dataType: 'Number', isReadOnly: true } //달성률
				
				]
				},
			]
		},
	];
	
	//득의선별
	grid2 = [
		{ binding: 'comps', header: LB_COMPS, width: '*', align: 'center', dataType: 'String', isReadOnly: true}, //사업부
		{ binding: 'pyvnd', header: LB_CUST, width: '*', align: 'center', dataType: 'String', isReadOnly: true}, //거래처
		{ binding: 'prdnm', header: LB_CUSTNM, width: '*', align: 'center', dataType: 'String', isReadOnly: true}, //거래처명
		{
			header: LB_QTY, align: 'center', columns: [ //수량
				{ binding: 'pQtyY', header: LB_YSUM, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //년계
				{ binding: 'pQtyM', header: LB_MSUM, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //단계
				{ binding: 'pQtyS', header: LB_PAYSUM, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //판매실적
				{
				header: LB_YSUM, align: 'center', columns: [ //년계
					{ binding: 'pQtyYgp', header: LB_GAP, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //차이
					{ binding: 'pQtyYflat', header: LB_ACHIRATE, width: '*', align: 'right', dataType: 'Number', isReadOnly: true } //달성률
				
				]
				},
				{
				header: LB_MSUM, align: 'center', columns: [ //단계
					{ binding: 'pQtyMgp', header: LB_GAP, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //차이
					{ binding: 'pQtyMflat', header: LB_ACHIRATE, width: '*', align: 'right', dataType: 'Number', isReadOnly: true } //달성률
				
				]
				},
			]
		},
		{
			header: LB_AMOUNT, align: 'center', columns: [ //금액
				{ binding: 'pCostY', header: LB_YSUM, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //년계
				{ binding: 'pCostM', header: LB_MSUM, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //단계
				{ binding: 'pCostS', header: LB_PAYSUM, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //판매실적
				{
				header: LB_YSUM, align: 'center', columns: [ //년계
					{ binding: 'pCostYgp', header: LB_GAP, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //차이
					{ binding: 'pCostYflat', header: LB_ACHIRATE, width: '*', align: 'right', dataType: 'Number', isReadOnly: true } //달성률
				
				]
				},
				{
				header: LB_MSUM, align: 'center', columns: [ //단계
					{ binding: 'pCostMgp', header: LB_GAP, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //차이
					{ binding: 'pCostMflat', header: LB_ACHIRATE, width: '*', align: 'right', dataType: 'Number', isReadOnly: true } //달성률
				
				]
				},
			]
		},
	];
	
	//제품/득의선별
	grid3 = [
		{ binding: 'comps', header: LB_COMPS, width: '*', align: 'center', dataType: 'String', isReadOnly: true}, //사업부
		{ binding: 'prdcd', header: LB_PRDCD, width: '*', align: 'center', dataType: 'String', isReadOnly: true}, //제품
		{ binding: 'prdnm', header: LB_PRDNM, width: '*', align: 'center', dataType: 'String', isReadOnly: true}, //제품명
		{ binding: 'pyvnd', header: LB_CUST, width: '*', align: 'center', dataType: 'String', isReadOnly: true}, //거래처
		{ binding: 'pyPrdnm', header: LB_CUSTNM, width: '*', align: 'center', dataType: 'String', isReadOnly: true}, //거래처명
		{
			header: LB_QTY, align: 'center', columns: [ //수량
				{ binding: 'pQtyY', header: LB_YSUM, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //년계
				{ binding: 'pQtyM', header: LB_MSUM, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //단계
				{ binding: 'pQtyS', header: LB_PAYSUM, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //판매실적
				{
				header: LB_YSUM, align: 'center', columns: [ //년계
					{ binding: 'pQtyYgp', header: LB_GAP, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //차이
					{ binding: 'pQtyYflat', header: LB_ACHIRATE, width: '*', align: 'right', dataType: 'Number', isReadOnly: true } //달성률
				
				]
				},
				{
				header: LB_MSUM, align: 'center', columns: [ //단계
					{ binding: 'pQtyMgp', header: LB_GAP, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //차이
					{ binding: 'pQtyMflat', header: LB_ACHIRATE, width: '*', align: 'right', dataType: 'Number', isReadOnly: true } //달성률
				
				]
				},
			]
		},
		{
			header: LB_AMOUNT, align: 'center', columns: [ //금액
				{ binding: 'pCostY', header: LB_YSUM, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //년계
				{ binding: 'pCostM', header: LB_MSUM, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //단계
				{ binding: 'pCostS', header: LB_PAYSUM, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //판매실적
				{
				header: LB_YSUM, align: 'center', columns: [ //년계
					{ binding: 'pCostYgp', header: LB_GAP, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //차이
					{ binding: 'pCostYflat', header: LB_ACHIRATE, width: '*', align: 'right', dataType: 'Number', isReadOnly: true } //달성률
				
				]
				},
				{
				header: LB_MSUM, align: 'center', columns: [ //단계
					{ binding: 'pCostMgp', header: LB_GAP, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //차이
					{ binding: 'pCostMflat', header: LB_ACHIRATE, width: '*', align: 'right', dataType: 'Number', isReadOnly: true } //달성률
				
				]
				},
			]
		},
	];
	
	
	//득의선별/제품
	grid4 = [
		{ binding: 'comps', header: LB_COMPS, width: '*', align: 'center', dataType: 'String', isReadOnly: true}, //사업부
		{ binding: 'pyvnd', header: LB_CUST, width: '*', align: 'center', dataType: 'String', isReadOnly: true}, //거래처
		{ binding: 'pyPrdnm', header: LB_CUSTNM, width: '*', align: 'center', dataType: 'String', isReadOnly: true}, //거래처명
		{ binding: 'prdcd', header: LB_PRDCD, width: '*', align: 'center', dataType: 'String', isReadOnly: true}, //제품
		{ binding: 'prdnm', header: LB_PRDNM, width: '*', align: 'center', dataType: 'String', isReadOnly: true}, //제품명
		{
			header: LB_QTY, align: 'center', columns: [ //수량
				{ binding: 'pQtyY', header: LB_YSUM, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //년계
				{ binding: 'pQtyM', header: LB_MSUM, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //단계
				{ binding: 'pQtyS', header: LB_PAYSUM, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //판매실적
				{
				header: LB_YSUM, align: 'center', columns: [ //년계
					{ binding: 'pQtyYgp', header: LB_GAP, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //차이
					{ binding: 'pQtyYflat', header: LB_ACHIRATE, width: '*', align: 'right', dataType: 'Number', isReadOnly: true } //달성률
				
				]
				},
				{
				header: LB_MSUM, align: 'center', columns: [ //단계
					{ binding: 'pQtyMgp', header: LB_GAP, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //차이
					{ binding: 'pQtyMflat', header: LB_ACHIRATE, width: '*', align: 'right', dataType: 'Number', isReadOnly: true } //달성률
				
				]
				},
			]
		},
		{
			header: LB_AMOUNT, align: 'center', columns: [ //금액
				{ binding: 'pCostY', header: LB_YSUM, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //년계
				{ binding: 'pCostM', header: LB_MSUM, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //단계
				{ binding: 'pCostS', header: LB_PAYSUM, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //판매실적
				{
				header: LB_YSUM, align: 'center', columns: [ //년계
					{ binding: 'pCostYgp', header: LB_GAP, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //차이
					{ binding: 'pCostYflat', header: LB_ACHIRATE, width: '*', align: 'right', dataType: 'Number', isReadOnly: true } //달성률
				
				]
				},
				{
				header: LB_MSUM, align: 'center', columns: [ //단계
					{ binding: 'pCostMgp', header: LB_GAP, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //차이
					{ binding: 'pCostMflat', header: LB_ACHIRATE, width: '*', align: 'right', dataType: 'Number', isReadOnly: true } //달성률
				
				]
				},
			]
		},
	];
	
	//차종별
	grid5 = [
		{ binding: 'comps', header: LB_COMPS, width: '*', align: 'center', dataType: 'String', isReadOnly: true}, //사업부
		{ binding: 'carcd', header: LB_CARCD, width: '*', align: 'center', dataType: 'String', isReadOnly: true}, //거래처
		{ binding: 'carnm', header: LB_CARNM, width: '*', align: 'center', dataType: 'String', isReadOnly: true}, //거래처명
		{
			header: LB_QTY, align: 'center', columns: [ //수량
				{ binding: 'pQtyY', header: LB_YSUM, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //년계
				{ binding: 'pQtyM', header: LB_MSUM, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //단계
				{ binding: 'pQtyS', header: LB_PAYSUM, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //판매실적
				{
				header: LB_YSUM, align: 'center', columns: [ //년계
					{ binding: 'pQtyYgp', header: LB_GAP, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //차이
					{ binding: 'pQtyYflat', header: LB_ACHIRATE, width: '*', align: 'right', dataType: 'Number', isReadOnly: true } //달성률
				
				]
				},
				{
				header: LB_MSUM, align: 'center', columns: [ //단계
					{ binding: 'pQtyMgp', header: LB_GAP, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //차이
					{ binding: 'pQtyMflat', header: LB_ACHIRATE, width: '*', align: 'right', dataType: 'Number', isReadOnly: true } //달성률
				
				]
				},
			]
		},
		{
			header: LB_AMOUNT, align: 'center', columns: [ //금액
				{ binding: 'pCostY', header: LB_YSUM, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //년계
				{ binding: 'pCostM', header: LB_MSUM, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //단계
				{ binding: 'pCostS', header: LB_PAYSUM, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //판매실적
				{
				header: LB_YSUM, align: 'center', columns: [ //년계
					{ binding: 'pCostYgp', header: LB_GAP, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //차이
					{ binding: 'pCostYflat', header: LB_ACHIRATE, width: '*', align: 'right', dataType: 'Number', isReadOnly: true } //달성률
				
				]
				},
				{
				header: LB_MSUM, align: 'center', columns: [ //단계
					{ binding: 'pCostMgp', header: LB_GAP, width: '*', align: 'right', dataType: 'Number', isReadOnly: true }, //차이
					{ binding: 'pCostMflat', header: LB_ACHIRATE, width: '*', align: 'right', dataType: 'Number', isReadOnly: true } //달성률
				
				]
				},
			]
		},
	];
	
	
	//컬럼 초기화
	flexGrid.initialize({
		columns: grid1
	});
	
	//그리드 더블클릭시 이벤트 ==> 팝업
	flexGrid.hostElement.addEventListener('dblclick',function(e){
		var ht = flexGrid.hitTest(e);  //더블클릭한 행의 정보를 가지고있음.
		
		//제품코드필드가 존재하는지 확인 =>제품코드필드가 존재하지않는 그리드가 있기때문에
		var isCol = false;
		for (var ii = 0; ii < flexGrid.columns.length; ii++) {
			if (flexGrid.columns[ii].binding=='prdcd') {
				isCol = true;
				break;
			}
		}
		//제품코드필드가 존재함.
		if(isCol){
					
			var prdcd=flexGrid.getCellData(ht.row,'prdcd');  //제품코드
			var comps = flexGrid.getCellData(ht.row,'comps');	//사업부
			
			//품번이 있는것만 작동			
			if(prdcd!=""){
				popDetail.show(true,function(sender){
					//창이 사라질때 그리드 초기화	
					popCv.sourceCollection = [];				
				});
				popOpenDetail(prdcd,comps);
			}
			
		}
		
	});
	
	
	var popDetail = new wijmo.input.Popup('#popDetail');
}

/*
*	상세 팝업
*/
function popOpenDetail(prdcd,comps){

	mask.open();
	$.ajax({
		method: "post",
		url: "/ajaxSalAnlysView/searchByDetail.do",
		data: {
			"getComps": comps, //선택한 행의 사업부
			"getPrdcd":prdcd,  // 선택한 행의 제품코드
			"getPltcd": $(".getPltcd").val(), //공장구분
			"getPlnym": $(".getPlnym").val().replace(/-/gi, ""), //계획년월
			"getPltcd": $(".getPltcd").val(), //공장구분
			"getPlnym": $(".getPlnym").val().replace(/-/gi, ""), //계획년월
			"getPyvnd1": $("#getPyvnd1").val(), //업체코드1
			//"getPyvnd2" : $("#getPyvnd2").val(), //업체코드2
//			"getPyvnd2": getPyvnd2, //업체코드2
//			"getPrdcd1": getPrdcd1, //제품코드1
//			"getPrdcd2": getPrdcd2, //제품코드2
//			"getEndccd": getEndccd, //최종고객구분
			"getPaygub": $(".getPaygub").val(), //납입구분
			"startDate": $("#startDate").val().replace(/-/gi, ""), //출하일자-start 
			"endDate": $("#endDate").val().replace(/-/gi, ""), //출하일자 -end
			"getPlngb": $("#getPlngb").val(), //계획구분	
			"getSelectgub": $(".getSelectgub").val() //조회구분
		},
		success: function(res) {
			var data = JSON.parse(res).list;
			popCv.sourceCollection = data;
			setTimeout(function() {
					mask.close();
				}, 500);
		}, 
		error: function() {
			//console.log("dataset.error");
		},
		completed: function() {
			//console.log("dataset.completed");			
			setTimeout(function() {
				mask.close();
			}, 500);

		}
	});
	
}


function popGridInit(){
	
	var popGridColumnDefinition = [
		{ binding: 'pspno', header: '품번', width: '2*', align: 'center', dataType: 'String', isReadOnly: true,allowMerging: true}, //품번
		{
			header: LB_QTY, align: 'center', columns: [ //수량
				{ binding: 'pQtyY', header: LB_YSUM, width: '*', align: 'center', dataType: 'Number', isReadOnly: true }, //년계
				{ binding: 'pQtyM', header: LB_MSUM, width: '*', align: 'center', dataType: 'Number', isReadOnly: true }, //단계
				{ binding: 'pQtyS', header: LB_PAYSUM, width: '*', align: 'center', dataType: 'Number', isReadOnly: true }, //판매실적
				{
				header: LB_YSUM, align: 'center', columns: [ //년계
					{ binding: 'pQtyYgp', header: LB_GAP, width: '*', align: 'center', dataType: 'Number', isReadOnly: true }, //차이
					{ binding: 'pQtyYflat', header: LB_ACHIRATE, width: '*', align: 'center', dataType: 'Number', isReadOnly: true } //달성률
				
				]
				},
				{
				header: LB_MSUM, align: 'center', columns: [ //단계
					{ binding: 'pQtyMgp', header: LB_GAP, width: '*', align: 'center', dataType: 'Number', isReadOnly: true }, //차이
					{ binding: 'pQtyMflat', header: LB_ACHIRATE, width: '*', align: 'center', dataType: 'Number', isReadOnly: true } //달성률
				
				]
				},
			]
		},
		{
			header: LB_AMOUNT, align: 'center', columns: [ //금액
				{ binding: 'pCostY', header: LB_YSUM, width: '*', align: 'center', dataType: 'Number', isReadOnly: true }, //년계
				{ binding: 'pCostM', header: LB_MSUM, width: '*', align: 'center', dataType: 'Number', isReadOnly: true }, //단계
				{ binding: 'pCostS', header: LB_PAYSUM, width: '*', align: 'center', dataType: 'Number', isReadOnly: true }, //판매실적
				{
				header: LB_YSUM, align: 'center', columns: [ //년계
					{ binding: 'pCostYgp', header: LB_GAP, width: '*', align: 'center', dataType: 'Number', isReadOnly: true }, //차이
					{ binding: 'pCostYflat', header: LB_ACHIRATE, width: '*', align: 'center', dataType: 'Number', isReadOnly: true } //달성률
				
				]
				},
				{
				header: LB_MSUM, align: 'center', columns: [ //단계
					{ binding: 'pCostMgp', header: LB_GAP, width: '*', align: 'center', dataType: 'Number', isReadOnly: true }, //차이
					{ binding: 'pCostMflat', header: LB_ACHIRATE, width: '*', align: 'center', dataType: 'Number', isReadOnly: true } //달성률
				
				]
				},
			]
		}
	]
	
	//컬럼 초기화
	popGrid.initialize({
		columns: popGridColumnDefinition
	});
}

$(document.body).ready(function() {

	//그리드 공통js 호출 후에 나머지 함수 호출함.
	$.getScript('/js/sal/gridCommon.js').done(function() {
	commonGrid.init(flexGrid,cv); //그리드 공통부분
	commonGrid.init(popGrid,popCv); //그리드 공통부분
	//제품코드 null값 제거
	$("#getPrdcd1 option[value='']").remove();
	gridInit();  	//그리드 초기화
	popGridInit();	//팝업 그리드 초기화
	handleEvent(); //버튼 핸들러
	calendar(); //캘린더
	calendarFromTo();//출하일자캘린더
	});
});

/**
	조회조건 변경 시 제품별 그리드로 리셋
 */
function prdctGridReset(){
	cv.sourceCollection = [];
	//제품별 그리드 리셋
	flexGrid.initialize({
		columns: grid1
	});
	$(".getSelectgub option[value='1']").prop('selected', true);//조회구분-제품코드
	//gridInit();  	//그리드 초기화
}

/**
	버튼 이벤트 처리
 */
function handleEvent() {
	// 사업부 변경
	$('.getComps').on('change', function() {
		//사업부 전체시 업체코드 disabled
		if ($('.getComps').val() == 'ALL') {
			$('.getCusnm1').prop("disabled", true);
			$('.getCusnm2').prop("disabled", true);
			$('._custBtn1_').prop("disabled", true);
			$('._custBtn2_').prop("disabled", true);
			$('#getEndccdPS').css("display", 'none');
			$('#getEndccdPE').css("display", 'none');
			$('#getEndccdAll').show();
			clear('1');
			$('.getPyvnd').prop("disabled", true);
		} else if ($('.getComps').val() == 'PS') {
			//제품코드
			$('#getPrdcdE1').css("display", 'none');
			$('#getPrdcdS1').show();
			$('#getPrdcd2E1').css("display", 'none');
			$('#getPrdcd2S1').show();
			//최종고객코드
			$('#getEndccdAll').css("display", 'none');
			$('#getEndccdPE').css("display", 'none');
			$('#getEndccdPS').show();
			clear('1');
		} else {
			//제품코드
			$('#getPrdcd2E1').prop("disabled", false);
			$('#getPrdcd2E1').show();
			$('#getPrdcd2S1').css("display", 'none');
			$('#getPrdcdE1').prop("disabled", false);
			$('#getPrdcdE1').show();
			$('#getPrdcdS1').css("display", 'none');
			//최종고객코드
			$('#getEndccdAll').css("display", 'none');
			$('#getEndccdPS').css("display", 'none');
			$('#getEndccdPE').show();

			$('.getCusnm1').prop("disabled", false);
			$('.getCusnm2').prop("disabled", false);
			$('.getPyvnd').prop("disabled", false);
			$('._custBtn1_').prop("disabled", false);
			$('._custBtn2_').prop("disabled", false);
			clear('1');

		}
		//공장구분 변경
		if ($(".getComps").val() == 'ALL') {
			// 전체 선택시 공장구분 전체만 표시
			$("#getPltcd option[value='ALL']").prop('disabled', false);
			$("#getPltcd option[value='E1']").prop('disabled', true);
			$("#getPltcd option[value='C1']").prop('disabled', true);
			$("#getPltcd option[value='S1']").prop('disabled', true);

			$("#getPltcd option[value='ALL']").prop('selected', true);

			// 전체선택시 업체코드 비활성화
			$('.getCusnm1').prop("disabled", true);
			$('.getCusnm2').prop("disabled", true);
			$('.getPyvnd').prop("disabled", true);
			$('._custBtn1_').prop("disabled", true);
			$('._custBtn2_').prop("disabled", true);
			clear('1');

		} else if ($(".getComps").val() == 'PE') {
			//구KE (마산) 선택시 공장구분 마산만 표시
			$("#getPltcd option[value='ALL']").prop('disabled', true);
			$("#getPltcd option[value='E1']").prop('disabled', false);
			$("#getPltcd option[value='C1']").prop('disabled', true);
			$("#getPltcd option[value='S1']").prop('disabled', true);

			$("#getPltcd option[value='E1']").prop('selected', true);
			clear('1');
		} else if ($(".getComps").val() == 'PS') {
			//구KA (창원,화성) 공장구분 선택시 전체,창원,화성 표시
			$("#getPltcd option[value='ALL']").prop('disabled', false);
			$("#getPltcd option[value='E1']").prop('disabled', true);
			$("#getPltcd option[value='C1']").prop('disabled', false);
			$("#getPltcd option[value='S1']").prop('disabled', false);

			$("#getPltcd option[value='ALL']").prop('selected', true);

			// 전체선택시 업체코드 비활성화
			$('.getCusnm1').prop("disabled", false);
			$('.getCusnm2').prop("disabled", false);
			$('.getPyvnd').prop("disabled", false);
			$('._custBtn1_').prop("disabled", false);
			$('._custBtn2_').prop("disabled", false);
			clear('1');
		}
	});

	//공장구분 변경시 조회조건 리셋
	$('.getPltcd').on('change', function() {
		//공장구분 전체시 업체코드 disaled
		if ($('.getPltcd').val() == 'ALL') {
			$('.getCusnm1').prop("disabled", true);
			$('.getCusnm2').prop("disabled", true);
			$('.getPyvnd').prop("disabled", true);
			$('._custBtn1_').prop("disabled", true);
			$('._custBtn2_').prop("disabled", true);
			clear('1');
		} else {
			$('.getCusnm1').prop("disabled", false);
			$('.getCusnm2').prop("disabled", false);
			$('.getPyvnd').prop("disabled", false);
			$('._custBtn1_').prop("disabled", false);
			$('._custBtn2_').prop("disabled", false);
			clear('1');
		}
	});
	
	$('._custBtn1_').on('click', function() {
		popGugn = "CUST";
		bntVal = $('._custBtn1_').val();
		window.open("/ajaxCustomer/init.do", "customerPop", "width=550,height=600,scrollbars=yes,top=100,left=100");
	});
	$('._custBtn2_').on('click', function() {
		popGugn = "CUST";
		bntVal = $('._custBtn2_').val();
		window.open("/ajaxCustomer/init.do", "customerPop", "width=550,height=600,scrollbars=yes,top=100,left=100");
	});
	$('._itemBtn_').on('click', function() {
		popGugn = "ITEM";
		window.open("/ajaxItemMaster/init.do", "itemPop", "width=550,height=600,scrollbars=yes,top=100,left=100");
	});
	
	$('#getPyvnd1').on('blur', function() {
		prdctGridReset();
	});
	$('#getPyvnd2').on('blur', function() {
		prdctGridReset();
	});
	
	$('.getPlngb').on('change', function() {
		clear('2');
	});
	
	$('.getPlnym').on('blur', function() {
		clear('1');
	});
	
	$('.calendar_input').on('blur', function() {
		clear('2');
	});
	
	$('.getSelectgub').on('change', function(e) {
		var val =$(e.target).val();
		
		if(val == '1'){
			cv.sourceCollection = [];
			flexGrid.initialize({
				columns: grid1
			});
		} else if (val == '2') {
			cv.sourceCollection = [];
			flexGrid.initialize({
				columns: grid2
			});
		} else if (val == '3') {
			cv.sourceCollection = [];
			flexGrid.initialize({
				columns: grid3
			});
		} else if (val == '4')  {
			cv.sourceCollection = [];
			flexGrid.initialize({
				columns: grid4
			});
		}else{
			cv.sourceCollection = [];
			flexGrid.initialize({
				columns: grid5
			});
		}
	});
	
	//제품코드1 선택시 제품코드2 자동선택
	$('.getPrdcdList1').on('change', function(e) {
		$('.getPrdcdList2').val($(e.target).val()).prop('selected', true);
		prdctGridReset();
	});
	
	//제품코드1,2 선택시 대소비교
	$('.getPrdcdList2').on('change', function() {
		prdcdAsc();
	});
}

/*
*	제품코드1,2 선택시 asc대소비교->msg
*/
function prdcdAsc(){
	var comps = $('.getComps').val();
	
	if(comps == "PE"){
		var prdcd1 = $('.getPrdcdList1').val();
		var prdcd2 = $('.getPrdcdList2').val();
		if(prdcd1>prdcd2){
			toastMsg(LB_CHECKPRDCD);
			return false;
		}else{
			return true;
		}
	}else if(comps == "PS"){
		var prdcd1 = $('#getPrdcdS1').val();
		var prdcd2 = $('#getPrdcd2S1').val();
		if(prdcd1>prdcd2){
			toastMsg(LB_CHECKPRDCD);
			return false;
		}else{
			return true;
		}
	}else{
		return true;
	}
}

/*
*	계획년월 변경시 조회조건 리셋
*/
function clear(num) {
	if (num == '1') {
		$("#getPlngb option[value='1']").prop('selected', true); //계획구분-년계
		$(".getPyvnd").val(""); //업체코드
		$(".getCusnm1").val(""); //업체명1
		$(".getCusnm2").val(""); //업체명2
		$(".getPrdcdList1 option[value='']").prop('selected', true); //제품코드
		$(".getPrdcdList2 option[value='']").prop('selected', true); //제품코드
		$(".getSelectgub option[value='1']").prop('selected', true);//조회구분
		$(".getPaygub option[value='']").prop('selected', true);//납입구분
		$(".getEndccdList option[value='']").prop('selected', true);//최종고개구분
		cv.sourceCollection = [];
		
		flexGrid.initialize({
			columns: grid1
		});
		
	}else{
		$(".getPyvnd").val(""); //업체코드
		$(".getCusnm1").val(""); //업체명1
		$(".getCusnm2").val(""); //업체명2
		$(".getPrdcdList1 option[value='']").prop('selected', true); //제품코드
		$(".getPrdcdList2 option[value='']").prop('selected', true); //제품코드
		$(".getSelectgub option[value='1']").prop('selected', true);//조회구분
		$(".getPaygub option[value='']").prop('selected', true);//납입구분
		$(".getEndccdList option[value='']").prop('selected', true);//최종고개구분
		cv.sourceCollection = [];
		flexGrid.initialize({
			columns: grid1
		});
	}
	
}

/*
*	출하일자-계획년월과 취득
*/
function dateCheck() {
	var startDate = $("#startDate").val();
	var subStartDate = startDate.substring(0, 7);
	getStartYm = subStartDate.replace(/-/gi, "");
	getPlnym = $(".getPlnym").val().replace(/-/gi, "");
	var endDate = $("#endDate").val();
	var subEndDate = endDate.substring(0, 7);
	getEndYm = subEndDate.replace(/-/gi, "");
	dateCheckMsg();
}

/*
*	출하일자-계획년월과 안맞을시 오류메세지
*/
function dateCheckMsg() {
	if (getStartYm !== getPlnym) {
		toastMsg(LB_CHECKPLNUMDATE);
		return false;
	} else if (getEndYm !== getPlnym) {
		toastMsg(LB_CHECKPLNUMDATE);
		return false;
	} else {
		return true;
	}
}

function calendar() {
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
		onClick: function() {
			$(this.target).css('display', 'none');
			var date = JSON.stringify(chk_calendar.getSelection());
			$(this.target).prev().val(date.substring(2, 9));
			dateCheck();
		},
		onStateChanged: function() {
		}
	});

	$('.log_board1 .dropdown').on('click', function(e) {
		$($(e.target).next('.dropdown-menu')).css('display', 'block');
	});
}

function calendarFromTo() {
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
		multipleSelect: 2,
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
		onClick: function() {
			var dates = this.self.getSelection();

			if (dates.length > 1) {
				var minDate = new Date(Math.min(ax5.util.date(dates[0]).getTime(), ax5.util.date(dates[1]).getTime()));
				var maxDate = new Date(Math.max(ax5.util.date(dates[0]).getTime(), ax5.util.date(dates[1]).getTime()));

				if (dates[0] < dates[1]) {
					$(this.target).prev().val(dates[0]);
					$("#endDate").val(dates[1]);
					dateCheck();
				} else {
					$("#endDate").val(dates[0]);
					$(this.target).prev().val(dates[1]);
					dateCheck();
				}

				this.self.setPeriod({
					range: [
						{ from: minDate, to: maxDate, fromLabel: '', toLabel: '' }
					]
				});
				$(this.target).css('display', 'none');
			} else {
				$(this.target).prev().val(dates[0]);
			}

		},
		onStateChanged: function() {
		}
	});

	$('.log_board1 .date').on('click', function() {
		$('#log_calendar').css('display', 'block');
	});
}

/**
 * 업체코드로 업체명 검색하여 데이터 set
 * 
 * @param 업체코드
 */
function getCustSch1(comps, value, num) {
	var cusName = "";
	var gubn = "";
	if (num == '1') {
		if (comps == 'PS') {
			comps = "S1";
			gubn = "input";
		} else {
			comps = "E1";
			gubn = "input";
		}
	}
	$.ajax({
		method: "post",
		url: "/ajaxCustomer/search.do",
		data: {
			"getCusno": value,
			"getComps": comps
		},
		success: function(res) {
			if (num == '1') {
				var data = JSON.parse(res);

				if (data.list.length > 0) {
					if (gubn == "input") $('#getCusnm1').val(data.list[0].cusnm);
				}
				else {
					toastMsg(LN_IO_CHK1 + " : " + value);
					if (gubn == "input") {
					}
				}
			} else {
				if (comps == 'E1') {
					e1CustSch = JSON.parse(res).list;
				} else {
					e1CustSch = JSON.parse(res).list;
				}
			}

		},
		error: function() {
			//console.log("dataset.error");
		},
		completed: function() {
			//console.log("dataset.completed");
		}
	});
}

function getCustSch2(comps, value, num) {
	var cusName = "";
	var gubn = "";
	if (num == '1') {
		if (comps == 'PS') {
			comps = "S1";
			gubn = "input";
		} else {
			comps = "E1";
			gubn = "input";
		}
	}
	$.ajax({
		method: "post",
		url: "/ajaxCustomer/search.do",
		data: {
			"getCusno": value,
			"getComps": comps
		},
		success: function(res) {
			if (num == '1') {
				var data = JSON.parse(res);

				if (data.list.length > 0) {
					if (gubn == "input") $('#getCusnm2').val(data.list[0].cusnm);
				}
				else {
					toastMsg(LN_IO_CHK1 + " : " + value);
					if (gubn == "input") {
					}
				}
			} else {
				if (comps == 'E1') {
					e1CustSch = JSON.parse(res).list;
				} else {
					e1CustSch = JSON.parse(res).list;
				}
			}

		},
		error: function() {
			//log("dataset.error");
		},
		completed: function() {
			//console.log("dataset.completed");
		}
	});
}


/**
 * 팝업창에서 값넘겨받아 부모창에 데이터 set
 * 
 * @param returnValue
 */
function getReturnValue(returnValue, num) {
	var num = bntVal;
	if (returnValue !== null && num == "1") {
		var retObj = JSON.parse(returnValue);
		$('#getPyvnd1').val(retObj.cusno);
		$('#getCusnm1').val(retObj.cusnm);
	}
	if (returnValue !== null && num == "2") {
		var retObj = JSON.parse(returnValue);
		$('#getPyvnd2').val(retObj.cusno);
		$('#getCusnm2').val(retObj.cusnm);
	}
}