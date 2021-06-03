//code intellisense typescript 정의
///<reference path = "../../wijmo/controls/wijmo.d.ts"/>	
///<reference path = "../../wijmo/controls/wijmo.grid.d.ts"/>
///<reference path = "../../wijmo/controls/wijmo.grid.detail.d.ts"/>
///<reference path = "../../wijmo/controls/wijmo.grid.sheet.d.ts"/>
///<reference path = "../../wijmo/controls/wijmo.input.d.ts"/>

/// <reference path ="../../wijmo/controls/wijmo.chart.d.ts"/>
/// <reference path ="../../wijmo/controls/wijmo.pdf.d.ts"/>
/// <reference path ="../../wijmo/controls/wijmo.nav.d.ts"/>



var chartSalPlnSum = new wijmo.chart.FlexChart("#chartSalPlnSum"); //판매현황 계획실적 합계 차트
var chartSalPln = new wijmo.chart.FlexChart("#chartSalPln");   //판매현황 계획실적 그래프 차트
var chart = new wijmo.chart.FlexChart("#chart");     // 주요상품별 사업계획 대비 증감수량

// 컬랙션 뷰는 조회후에 그리드의 상태변경을 체크한다. 
var cv = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수
//var salPlnGrid = new wijmo.grid.sheet.FlexSheet("#salPlnGrid");	//판매현황
var salPlnGrid = new wijmo.grid.FlexGrid('#salPlnGrid');	//그리드 전역변수

//체크된 체크박스
var slectCheckbox = "";
var arraySelectCheckboxPe = new Array();
var arraySelectCheckboxPs = new Array();
var allCheckbox1 = "";
var allCheckbox2 = "";
/**
 조회버튼
 */
function search() {

	//사업부 변환
	var getOrgComps = $(".getComps").val();
	getCheckboxValue();
	//사업부 변환
	var getComps = "";
	if ($(".getComps").val() == "PE") {
		getComps = "'E1'";
	} else if ($(".getComps").val() == "PS") {
		getComps = "'S1','C1'";
	} else {
		getComps = "ALL";
	}
	var getDumcb = $("#getDumcb").val().replace(/-/gi, "");

	var url = '/ajaxSalPlnPerfmncMtReprtExl/search.do';
	var params = {
		'allCheckbox1': allCheckbox1,
		'allCheckbox2': allCheckbox2,
		'getPlngb' : $(".getPlngb").val(),
		'getCheckBoxPe': arraySelectCheckboxPe.toString(),
		'getCheckBoxPs': arraySelectCheckboxPs.toString(),
		'getComps': getComps,
		'getDumcb': getDumcb,
		'getOrgComps': getOrgComps
	};

	mask.open();
	$.ajax({
		method: "post",
		url: url,
		data: params,
		success: function(res) {

			// 판매현황 계획실적
			var salPlnList = JSON.parse(res).salPlnList;
			// 판매현황 계획실적 합계
			var salPlnListSum = JSON.parse(res).salPlnListSum;



			//alert(JSON.stringify(salPlnList));

			chartSalPln.itemsSource = salPlnList;
			chartSalPlnSum.itemsSource = salPlnListSum;

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

			//그리드 부분

			var salPlnGridList = JSON.parse(res).salPlnGrid;
			//console.debug(salPlnGridList);

			//초기화
			cv.sourceCollection = [];

			var colCnt = salPlnGrid.columns.length;
			for (ii = 0; ii < colCnt; ii++) {
				salPlnGrid.columns.remove(salPlnGrid.columns[0]);
			}

			salPlnGridInit();

			var totalMap = new Array();
			for (var ii = 0; ii < salPlnList.length; ii++) {
				totalMap[ii] = 0;
			}


			var tempcd1 = "";
			var cd1 = "";
			var compsCnt = 0;
			for (var ii = 0; ii < salPlnGridList.length; ii++) {

				if (salPlnGridList[ii].cd1 == "P_QTY_Y") {  //년계획
					cd1 = LB_GRID1
				} else if (salPlnGridList[ii].cd1 == "P_QTY_M") {	//단계획
					cd1 = LB_GRID2
				} else {
					cd1 = LB_GRID3	//실적
				}

				if (ii == 0) {
					tempcd1 = cd1;
				}

				if (tempcd1 != cd1) {
					if (compsCnt < 1) {
						compsCnt = ii + 1;
					}
					salPlnGrid.rows.push(new wijmo.grid.Row());
					salPlnGrid.setCellData(salPlnGrid.rows.length - 1, "cd1", tempcd1);
					salPlnGrid.setCellData(salPlnGrid.rows.length - 1, "comps", "TOTAL");


					for (var jj = 0; jj < totalMap.length; jj++) {
						salPlnGrid.setCellData(salPlnGrid.rows.length - 1, jj + 3, totalMap[jj]);
					}

					tempcd1 = cd1;
					for (var jj = 0; jj < salPlnList.length; jj++) {
						totalMap[jj] = 0;
					}
				}

				//행추가
				salPlnGrid.rows.push(new wijmo.grid.Row());
				salPlnGrid.setCellData(salPlnGrid.rows.length - 1, "cd1", cd1);
				salPlnGrid.setCellData(salPlnGrid.rows.length - 1, "comps", salPlnGridList[ii].comps);

				//실적 컬럼추가
				if (ii == 0) {
					var c = new wijmo.grid.Column({ binding: "result", header: LB_CHAR12+"(" + salPlnList[0].plnym + "~" + getDumcb + ")", width: '1.3*', dataType: 'Number', format: 'c', align: "right",wordWrap: true });
					salPlnGrid.columns.push(c);
				}

				if (salPlnGridList[ii].apr >= 0) {
					if (ii == 0) {
						var c = new wijmo.grid.Column({ binding: "apr", header: salPlnList[0].plnym, width: '*', dataType: 'Number', format: 'c' });
						salPlnGrid.columns.push(c);
					}
					if (salPlnGridList[ii].apr >= 0) {
						salPlnGrid.setCellData(salPlnGrid.rows.length - 1, "apr", salPlnGridList[ii].apr);
						totalMap[0] = totalMap[0] + salPlnGridList[ii].apr;
					}
				}
				if (salPlnGridList[ii].may >= 0) {
					if (ii == 0) {
						var c = new wijmo.grid.Column({ binding: "may", header: salPlnList[1].plnym, width: '*', dataType: 'Number', format: 'c' });
						salPlnGrid.columns.push(c);
					}
					if (salPlnGridList[ii].may >= 0) {
						salPlnGrid.setCellData(salPlnGrid.rows.length - 1, "may", salPlnGridList[ii].may);
						totalMap[1] = totalMap[1] + salPlnGridList[ii].may;

					}
				}
				if (salPlnGridList[ii].jun >= 0) {
					if (ii == 0) {
						var c = new wijmo.grid.Column({ binding: "jun", header: salPlnList[2].plnym, width: '*', dataType: 'Number', format: 'c' });
						salPlnGrid.columns.push(c);
					}
					if (salPlnGridList[ii].jun >= 0) {
						salPlnGrid.setCellData(salPlnGrid.rows.length - 1, "jun", salPlnGridList[ii].jun);
						totalMap[2] = totalMap[2] + salPlnGridList[ii].jun;

					}
				}
				if (salPlnGridList[ii].jul >= 0) {
					if (ii == 0) {
						var c = new wijmo.grid.Column({ binding: "jul", header: salPlnList[3].plnym, width: '*', dataType: 'Number', format: 'c' });
						salPlnGrid.columns.push(c);
					}
					if (salPlnGridList[ii].jul >= 0) {
						salPlnGrid.setCellData(salPlnGrid.rows.length - 1, "jul", salPlnGridList[ii].jul);
						totalMap[3] = totalMap[3] + salPlnGridList[ii].jul;

					}
				}
				if (salPlnGridList[ii].aug >= 0) {
					if (ii == 0) {
						var c = new wijmo.grid.Column({ binding: "aug", header: salPlnList[4].plnym, width: '*', dataType: 'Number', format: 'c' });
						salPlnGrid.columns.push(c);
					}
					if (salPlnGridList[ii].aug >= 0) {
						salPlnGrid.setCellData(salPlnGrid.rows.length - 1, "aug", salPlnGridList[ii].aug);
						totalMap[4] = totalMap[4] + salPlnGridList[ii].aug;
					}
				}
				if (salPlnGridList[ii].sep >= 0) {
					if (ii == 0) {
						var c = new wijmo.grid.Column({ binding: "sep", header: salPlnList[5].plnym, width: '*', dataType: 'Number', format: 'c' });
						salPlnGrid.columns.push(c);
					}
					if (salPlnGridList[ii].sep >= 0) {
						salPlnGrid.setCellData(salPlnGrid.rows.length - 1, "sep", salPlnGridList[ii].sep);
						totalMap[5] = totalMap[5] + salPlnGridList[ii].sep;

					}
				}
				if (salPlnGridList[ii].oct >= 0) {
					if (ii == 0) {
						var c = new wijmo.grid.Column({ binding: "oct", header: salPlnList[6].plnym, width: '*', dataType: 'Number', format: 'c' });
						salPlnGrid.columns.push(c);
					}
					if (salPlnGridList[ii].oct >= 0) {
						salPlnGrid.setCellData(salPlnGrid.rows.length - 1, "oct", salPlnGridList[ii].oct);
						totalMap[6] = totalMap[6] + salPlnGridList[ii].oct;

					}
				}
				if (salPlnGridList[ii].nov >= 0) {
					if (ii == 0) {
						var c = new wijmo.grid.Column({ binding: "nov", header: salPlnList[7].plnym, width: '*', dataType: 'Number', format: 'c' });
						salPlnGrid.columns.push(c);
					}
					if (salPlnGridList[ii].nov >= 0) {
						salPlnGrid.setCellData(salPlnGrid.rows.length - 1, "nov", salPlnGridList[ii].nov);
						totalMap[7] = totalMap[7] + salPlnGridList[ii].nov;

					}
				}
				if (salPlnGridList[ii].dec >= 0) {
					if (ii == 0) {
						var c = new wijmo.grid.Column({ binding: "dec", header: salPlnList[8].plnym, width: '*', dataType: 'Number', format: 'c' });
						salPlnGrid.columns.push(c);
					}
					if (salPlnGridList[ii].dec >= 0) {
						salPlnGrid.setCellData(salPlnGrid.rows.length - 1, "dec", salPlnGridList[ii].dec);
						totalMap[8] = totalMap[8] + salPlnGridList[ii].dec;

					}
				}
				if (salPlnGridList[ii].jan >= 0) {
					if (ii == 0) {
						//년월 표시하기위해 차트의 plnym을 header에 표기함.
						var c = new wijmo.grid.Column({ binding: "jan", header: salPlnList[9].plnym, width: '*', dataType: 'Number', format: 'c' });
						salPlnGrid.columns.push(c);
					}
					if (salPlnGridList[ii].jan >= 0) {
						salPlnGrid.setCellData(salPlnGrid.rows.length - 1, "jan", salPlnGridList[ii].jan);
						totalMap[9] = totalMap[9] + salPlnGridList[ii].jan;

					}
				}
				if (salPlnGridList[ii].feb >= 0) {
					if (ii == 0) {
						var c = new wijmo.grid.Column({ binding: "feb", header: salPlnList[10].plnym, width: '*', dataType: 'Number', format: 'c' });
						salPlnGrid.columns.push(c);
					}
					if (salPlnGridList[ii].feb >= 0) {
						salPlnGrid.setCellData(salPlnGrid.rows.length - 1, "feb", salPlnGridList[ii].feb);
						totalMap[10] = totalMap[10] + salPlnGridList[ii].feb;

					}
				}

				if (salPlnGridList[ii].mar >= 0) {
					if (ii == 0) {
						var c = new wijmo.grid.Column({ binding: "mar", header: salPlnList[11].plnym, width: '*', dataType: 'Number', format: 'c' });
						salPlnGrid.columns.push(c);
					}
					if (salPlnGridList[ii].mar >= 0) {
						salPlnGrid.setCellData(salPlnGrid.rows.length - 1, "mar", salPlnGridList[ii].mar);
						totalMap[11] = totalMap[11] + salPlnGridList[ii].mar;

					}
				}

			}

			salPlnGrid.rows.push(new wijmo.grid.Row());
			salPlnGrid.setCellData(salPlnGrid.rows.length - 1, "cd1", tempcd1);
			salPlnGrid.setCellData(salPlnGrid.rows.length - 1, "comps", "TOTAL");

			//TOTAL
			for (var jj = 0; jj < totalMap.length; jj++) {
				salPlnGrid.setCellData(salPlnGrid.rows.length - 1, jj + 3, totalMap[jj]);
			}



			//년계대비단계차, 년계대비실적, 단계대비실적
			var gridList = [LB_GRID4, LB_GRID5, LB_GRID6];

			//그리드 row추가
			for (var j = 0; j < gridList.length; j++) {
				for (var ii = 0; ii < compsCnt-1; ii++) {
					salPlnGrid.rows.push(new wijmo.grid.Row());
					salPlnGrid.setCellData(salPlnGrid.rows.length - 1, "cd1", gridList[j]);
					salPlnGrid.setCellData(salPlnGrid.rows.length - 1, "comps", salPlnGridList[ii].comps);
				}
				salPlnGrid.rows.push(new wijmo.grid.Row());
				salPlnGrid.setCellData(salPlnGrid.rows.length - 1, "cd1", gridList[j]);
				salPlnGrid.setCellData(salPlnGrid.rows.length - 1, "comps", "TOTAL");
				//% row 추가			
				if (gridList[j] == LB_GRID5 || gridList[j] == LB_GRID6) {
					salPlnGrid.rows.push(new wijmo.grid.Row());
					salPlnGrid.setCellData(salPlnGrid.rows.length - 1, "cd1", gridList[j]);
					salPlnGrid.setCellData(salPlnGrid.rows.length - 1, "comps", "%");
				}
			}


			for (var i = 0; i < compsCnt; i++) {
				for (var j = 3; j < salPlnGrid.columns.length; j++) {
					if (salPlnList[j - 3].plnym <= getDumcb) {
						var pqtyy = salPlnGrid.getCellData(i, j, false); //년계획
						var pqtym = salPlnGrid.getCellData(i + compsCnt, j, false); //단계획
						var pqtys = salPlnGrid.getCellData(i + compsCnt * 2, j, false); //실적
						var yearPcnt = ((pqtys - pqtyy) / pqtyy); //실적-년계/년계
						var mnthPcnt = ((pqtys - pqtym) / pqtym); //실적-단계/단계
						salPlnGrid.setCellData(i + compsCnt * 3, j, (pqtym - pqtyy));//년계대비단계차
						salPlnGrid.setCellData(i + compsCnt * 4, j, (pqtys - pqtyy));//년계대비실적
						salPlnGrid.setCellData(i + 1 + (compsCnt * 5), j, (pqtys - pqtym));//단계대비실적
						//단계획,실적0일때 0세팅
						if(pqtym == 0 && pqtys == 0) {
							salPlnGrid.setCellData(compsCnt * 5, j, yearPcnt);//년계대비실적%
							salPlnGrid.setCellData(salPlnGrid.rows.length - 1, j, 0);//단계대비실적%
						}else{
							salPlnGrid.setCellData(compsCnt * 5, j, yearPcnt);//년계대비실적%
							salPlnGrid.setCellData(salPlnGrid.rows.length - 1, j, mnthPcnt);//단계대비실적% 
						}
					} else {
						salPlnGrid.setCellData(i + compsCnt * 3, j, 0);//년계대비단계차
						salPlnGrid.setCellData(i + compsCnt * 4, j, 0)//년계대비실적
						salPlnGrid.setCellData(i + 1 + (compsCnt * 5), j, 0);//단계대비실적
						salPlnGrid.setCellData(compsCnt * 5, j, 0);//년계대비실적%
						salPlnGrid.setCellData(salPlnGrid.rows.length - 1, j, 0);//단계대비실적%
					}
				}
			}
			
			
			
			// 원화"C"->퍼센트"%"
			salPlnGrid.formatItem.addHandler(function(s, e) {
				/*
				if (e.panel == s.columnHeaders) {
					e.cell.innerHTML = '<div class="v-center">' +
					e.cell.innerHTML + '</div>';
				}
				*/
				// custom rendering for "Diff" columns
				if (e.panel == s.cells) {
					if (e.row > 0 && s.getCellData(e.row, 'comps', true) == '%') {
						if(e.col==2){
							var diff = s.getCellData(e.row, e.col, false);
							var html = wijmo.Globalize.format(diff/100, 'p1');
						}else{
							var diff = s.getCellData(e.row, e.col, false);
							var html = wijmo.Globalize.format(diff, 'p1');
						}
						e.cell.innerHTML = html;	
					}
				}
			});

			//실적합계
			var sum = 0;		//합계
			for (var ii = 0; ii < salPlnGrid.rows.length; ii++) {
				sum = 0;
				for (var jj = 3; jj < salPlnGrid.columns.length; jj++) {
					if (salPlnList[jj - 3].plnym <= getDumcb) {
						if(salPlnGrid.getCellData(ii, 'comps', true) == '%'){
							sum = sum +parseFloat(wijmo.Globalize.formatNumber(salPlnGrid.getCellData(ii, jj, false)*100,'f1'));
						}else{
							sum = sum +salPlnGrid.getCellData(ii, jj, false);	
						}
					}
				}		
				salPlnGrid.setCellData(ii, "result", sum);				
			}


			//년합계 필드생성
			var c = new wijmo.grid.Column({ binding: "sum", header: LB_CHAR16, width: '*', align: "right" });  //숫자와 문자를 같이 사용하기때문에 dateType 설정하지 않음.
			salPlnGrid.columns.push(c);

			//년계획 년합계
			sum = 0;
			for (var ii = 0; ii < salPlnGrid.rows.length; ii++) {
				sum = 0;
				if (salPlnGrid.getCellData(ii, "cd1", true) == LB_GRID1) {
					for (var jj = 3; jj < salPlnGrid.columns.length - 1; jj++) {
						sum = sum + parseInt(salPlnGrid.getCellData(ii, jj, false));
					}
					salPlnGrid.setCellData(ii, salPlnGrid.columns.length - 1, wijmo.Globalize.format(sum, "c"));  //화폐포맷으로 변경하여 그리드에 입력
				}
			}

			//단계획 년합계
			for (var ii = 0; ii < salPlnGrid.rows.length; ii++) {
				sum = 0;
				if (salPlnGrid.getCellData(ii, "cd1", true) == LB_GRID2 && salPlnGrid.getCellData(ii, "comps") == "TOTAL") {
					for (var jj = 3; jj < salPlnGrid.columns.length - 1; jj++) {
						sum = sum + parseInt(salPlnGrid.getCellData(ii, jj, false));
					}
					salPlnGrid.setCellData(ii - 1, salPlnGrid.columns.length - 1, LB_CHAR17);
					salPlnGrid.setCellData(ii, salPlnGrid.columns.length - 1, wijmo.Globalize.format(sum, "c")); //화폐포맷으로 변경하여 그리드에 입력
				}

			}

			arraySelectCheckboxPe = [];
			arraySelectCheckboxPs = [];
			allCheckbox1 = "";
			allCheckbox2 = "";

		},
		error: function() {
			console.log("dataset.error");

		},
		complete: function() {
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

	var fileName = LN_FILE_NM;
	transExcel(flexGrid, fileName);

}

//그리드,차트,텍스트 리셋
function clearGrid(num) {
	if (num == '1') {
		$("#getComps option[value='AL']").prop('selected', true);
	}

	salPlnGrid.itemsSource = [];
	chart.itemsSource = [];
	chartSalPln.itemsSource = [];
	chartSalPlnSum.itemsSource = [];
	arraySelectCheckboxPe = [];
	arraySelectCheckboxPs = [];

	$('.checkboxWrap').css('display', 'none');
	$('.close').css('display', 'none');
	$('.loadMore').show();
	$('#text1').val("");//텍스트
	$('#text2').val("");//텍스트
	$('#text1').css('readonly', true);
	$('#text2').css('readonly', true);
	$('.comment').css('display', 'none');
	$(".prdcdS1List").prop('checked', false);
	$(".prdcdE1List").prop('checked', false);
	$(".checkboxElemt").prop('checked', false);
}

/*	
	등록버튼
*/
function update(textNum) {

	if (textNum == "1") {
		var cmncn = $('#text1').val();
		var comps = $('#comps1').val();
		var reprtse = $('#reprtse1').val();
		var cmnitm = $('#cmnitm1').val();
		var insComps = $(".getComps").val();
		var insReprtse = "R2";
		var insCmnitm = "C1";
	} else {
		var cmncn = $('#text2').val();
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
		'getDumcb': $("#getDumcb").val().replace(/-/gi, "")
	};

	$.ajax({
		method: "post",
		url: url,
		data: params,
		success: function(res) {
			var data = JSON.parse(res);
			if (data.result != RESULT_OK) {
				if (data.errMsg == "LN_UPD_CHK1") stateMsg = LN_UPD_CHK1;
				if (data.errMsg == "LN_UPD_CHK2") stateMsg = LN_UPD_CHK2;
				if (data.errMsg == "LN_INS_CHK1") stateMsg = LN_INS_CHK1;
				toastMsg(stateMsg);
				bntReset(textNum);
			} else {
				toastMsg("OK");
				bntReset(textNum);
			}
		},
		error: function() {
			//console.log("dataset.error");
			//alert("error");
		},
		complete: function() {
			//console.log("dataset.completed");
			setTimeout(function() {
				mask.close();
			}, 500);

		}
	});
}

//등록후 버튼 비활성화전환
function bntReset(textNum) {
	var bntNum = textNum;
	if (bntNum == "1") {
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
function getCheckboxValue() {

	if (slectCheckbox == "prdcdList") {
		if ($("input:checkbox[id='prdcdE1AllList']").is(":checked") == true) {
			allCheckbox2 = "AllE1List";
			if ($("input:checkbox[name='prdcdS1List']").is(":checked") == false
				&& $("input:checkbox[id='prdcdS1AllList']").is(":checked") == false) {
				allCheckbox1 = "S";
			}
		} else {
			$("input:checkbox[name='prdcdE1List']:checked").each(function() {
				var arr = [];
				arr.push($(this).val());
				for (var i = 0; i < arr.length; i++) {
					if (arraySelectCheckboxPe.indexOf(arr[i]) === -1) arraySelectCheckboxPe.push(arr[i]);
				}
				allCheckbox2 = "E1List";
				if ($("input:checkbox[name='prdcdS1List']").is(":checked") == false
					&& $("input:checkbox[id='prdcdS1AllList']").is(":checked") == false) {
					allCheckbox1 = "S";
				}
			});
		}
		if ($("input:checkbox[id='prdcdS1AllList']").is(":checked") == true) {
			allCheckbox1 = "AllS1List";
			if ($("input:checkbox[name='prdcdE1List']").is(":checked") == false
				&& $("input:checkbox[id='prdcdE1AllList']").is(":checked") == false) {
				allCheckbox2 = "E";
			}
		} else {
			$("input:checkbox[name='prdcdS1List']:checked").each(function() {
				var arr = [];
				arr.push($(this).val());
				for (var i = 0; i < arr.length; i++) {
					if (arraySelectCheckboxPs.indexOf(arr[i]) === -1) arraySelectCheckboxPs.push(arr[i]);
				}
				allCheckbox1 = "S1List";
				if ($("input:checkbox[name='prdcdE1List']").is(":checked") == false
					&& $("input:checkbox[id='prdcdE1AllList']").is(":checked") == false) {
					allCheckbox2 = "E";
				}
			});
		}
		/*else{
		$("input:checkbox[name='prdcdS1List']:checked").each(function() {
			arraySelectCheckboxPs.push($(this).val());
			allCheckbox1 = "S1List";
			});
			if($("input:checkbox[name='prdcdE1List']").is(":checked")== true){
				$("input:checkbox[name='prdcdE1List']:checked").each(function() {
				arraySelectCheckboxPe.push($(this).val());
				allCheckbox2 = "E1List";
			});
			}
	}*/
	}
	if (slectCheckbox == "prdcdE1List") {
		if ($("input:checkbox[id='prdcdE1AllList']").is(":checked") == true) {
			allCheckbox2 = "AllE1List";
		} else {
			$("input:checkbox[name='prdcdE1List']:checked").each(function() {
				arraySelectCheckboxPe.push($(this).val());
				allCheckbox2 = "E1List";
			});
		}
	}
	if (slectCheckbox == "prdcdS1List") {
		if ($("input:checkbox[id='prdcdS1AllList']").is(":checked") == true) {
			allCheckbox1 = "AllS1List";
		} else {
			$("input:checkbox[name='prdcdS1List']:checked").each(function() {
				arraySelectCheckboxPs.push($(this).val());
				allCheckbox1 = "S1List";
			});
		}
	}
}
/**
	버튼 이벤트 처리
 */
function handleEvent() {

	// 체크박스 - 전체선택
	$(".checkboxElemt").on("click", function(event) {
		var val = $(event.target).val();
		if (val == "prdcdAllList") {
			if ($(".prdcdAllList").prop("checked")) {
				$(".prdcdAllList").prop('checked', false);
				$(event.target).prop('checked', false);
			} else {
				$(".prdcdAllList").prop('checked', true);
			}
		}
		if (val == "prdcdS1AllList") {
			if ($(".prdcdS1List").prop("checked")) {
				$(".prdcdS1List").prop('checked', false);
				$(event.target).prop('checked', false);
			} else {
				$(".prdcdS1List").prop('checked', true);
			}
		}
		if (val == "prdcdE1AllList") {
			if ($(".prdcdE1List").prop("checked")) {
				$(".prdcdE1List").prop('checked', false);
				$(event.target).prop('checked', false);
			} else {
				$(".prdcdE1List").prop('checked', true);
			}
		}
	});
	// 체크박스 - 부분선택 시, 전체선택 해제
	$(".prdcdE1List").on("click", function() {
		if ($("#prdcdE1AllList").prop("checked")) {
			$("#prdcdE1AllList").prop('checked', false);
		}
	});
	$(".prdcdS1List").on("click", function() {
		if ($("#prdcdS1AllList").prop("checked")) {
			$("#prdcdS1AllList").prop('checked', false);
		}
	});


	// 더보기버튼
	$(".loadMore").on("click", function(compsVal) {
		var compsVal = $(".getComps").val();
		if (compsVal == "PE") {
			$(".checkboxE1List").show();
			$(".checkboxS1List").css('display', 'none');
			$(".checkboxAllList").css('display', 'none');
			slectCheckbox = "prdcdE1List";
		} else if (compsVal == "PS") {
			$(".checkboxS1List").show();
			$(".checkboxE1List").css('display', 'none');
			$(".checkboxAllList").css('display', 'none');
			slectCheckbox = "prdcdS1List";
		} else {
			$(".checkboxAllList").show();
			$(".checkboxE1List").css('display', 'none');
			$(".checkboxS1List").css('display', 'none');
			slectCheckbox = "prdcdList";
		}
		$(".checkboxWrap").show();
		$('.loadMore').css('display', 'none');
		$('.close').show();
	});

	$(".close").on("click", function() {
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
function getCheckboxVal() {
	var query = "input[name]"
}


/*차트 초기화*/
function chartInit() {

	//판매현황 계획실적
	chartSalPln.initialize({
		header: "Repair rate",
		bindingX: 'plnym',
		series: [
			{ name: "", binding: 'pCostY' },
			{ name: "", binding: 'pCostM' },
			//{ name: LB_CHAR3, binding: 'pCostS', chartType: 'LineSymbols' }
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
	//판매현황 계획실적 합계
	chartSalPlnSum.initialize({
		header: LB_TITLE3,
		bindingX: 'plnym',
		series: [
			{ name: LB_CHAR11, binding: 'pCostY' },
			{ name: LB_CHAR12, binding: 'pCostS' },
			{ name: LB_CHAR15, binding: 'rate', chartType: 'LineSymbols' }
			//{ name: LB_CHAR15, binding: 'rate',chartType:wijmo.chart.ChartType.Line }
		],
		axisY: {
			title: LB_CHAR14,
			axisLine: true
		},

		dataLabel: {
			content: '{value:n0}'
			//offset:10
			//connectingLine : true
		},

		legend: {
			position: wijmo.chart.Position.Bottom
		},
		footer: LB_CHAR13

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


	/*var axisYQty = new wijmo.chart.Axis(wijmo.chart.Position.Right);
	axisYQty.axisLine = true;
	chartSalPln.series[2].axisY = axisYQty;*/

	var axisYDiff = new wijmo.chart.Axis(wijmo.chart.Position.Right);
	axisYDiff.axisLine = true;
	axisYDiff.min = 0;
	axisYDiff.max = -8000;
	chartSalPlnSum.series[2].axisY = axisYDiff;


	/*************** 여기 아래 부분때문에 header 부분이랑 숫자부분이 겹칩니다.  (위소스로 대체함.) 아래 소스는 삭제하심 되겠어요.. *******/
	/*
	var p1 = new wijmo.chart.PlotArea();
	p1.row = chart.plotAreas.length;
	p1.name = 'quantities';
	p1.height = '*';
	
	var axisYQty = new wijmo.chart.Axis(wijmo.chart.Position.Right);
	axisYQty.plotArea = p1;
	
	chartSalPln.series[2].axisY = axisYQty;
	chartSalPln.plotAreas.push(p1);
	
	
	var p2 = new wijmo.chart.PlotArea();
	p2.row = chartSalPlnSum.plotAreas.length;
	p2.name = 'rate';
	p2.height = '*';
	
	var axisYDiff = new wijmo.chart.Axis(wijmo.chart.Position.Right);
	axisYDiff.plotArea = p2;
	
	chartSalPlnSum.series[2].axisY = axisYDiff;
	chartSalPlnSum.plotAreas.push(p2);
	chartSalPlnSum.axisLine = true;
	*/
	/********************************** */

	// 주요상품별 사업계획 대비 증감수량
	chart.initialize({
		header: LB_TITLE2,
		bindingX: 'itemCd',
		series: [
			{ name: LB_CHAR6, binding: 'pQtyM' },
			{ name: LB_CHAR7, binding: 'pQtyS' },
			{ name: LB_CHAR8, binding: 'rate', chartType: 'LineSymbols' }
		],
		axisY: {
			title: LB_CHAR10,
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
		footer: LB_CHAR9

	});

	var axisYQty = new wijmo.chart.Axis(wijmo.chart.Position.Right);
	axisYQty.axisLine = true;
	chart.series[2].axisY = axisYQty;
	/*
	// 원화"C"->퍼센트"%"
	salPlnGrid.formatItem.addHandler(function(s, e) {
		
		if (e.panel == s.columnHeaders) {
			e.cell.innerHTML = '<div class="v-center">' +
				e.cell.innerHTML + '</div>';
		}
		
		// custom rendering for "Diff" columns
		if (e.panel == s.cells) {
			if (e.row > 0&& s.getCellData(e.row, 'comps', true) == '%') {
				var diff = s.getCellData(e.row, e.col, false);
				var html = wijmo.Globalize.format(diff, 'p1');
				e.cell.innerHTML = html;
			}
		}
		
	});*/
}

/**
 * pdf 다운로드
 */
function downloadPdf() {
	var doc = new wijmo.pdf.PdfDocument({
		compress: true,
		pageSettings: {
			layout: wijmo.pdf.PdfPageOrientation.Landscape,  //페이지 방향
			size: wijmo.pdf.PdfPageSize.A4,
			margins: {
				left: 50,
				top: 20,
				right: 50,
				bottom: 20
			}
		},
		/*footer: {
			declarative: {
				text: '\t&[Page]\\&[Pages]'   //페이지 번호
			}
		},*/

		ended: function(sender, args) {
			wijmo.pdf.saveBlob(args.blob, LN_FILE_NM+'.pdf')
		}

	});

	//문서 폰트 등록
	doc.registerFont({
		source: "/fonts/NanumGothic.ttf",
		name: "nanum",
		style: "normal",
		weight: "normal",
		sansSerif: true
	});
	
	var font = new wijmo.pdf.PdfFont("nanum");

	//그리드 셋팅
	var settings = {
		//그리드 스타일 지정
		styles: {
			cellStyle: {
				backgroundColor: '#ffffff',
				borderColor: '#c6c6c6',
				font: {
					family: 'nanum'
				}
			},
			altCellStyle: {
				backgroundColor: '#f9f9f9'
			},
			groupCellStyle: {
				backgroundColor: '#dddddd'
			},
			headerCellStyle: {
				backgroundColor: '#eaeaea',
				font: {
		        	size: 8
		        }
			}
		},
		//그리드 폰트 적용
		embeddedFonts: {
			source: "/fonts/NanumGothic.ttf",
			name: "nanum",
			style: "normal",
			weight: "normal",
			sansSerif: true
		},
		
		formatItem: function(args) {
			//그리드 순번표시
			if (args.panel.cellType == wijmo.grid.CellType.RowHeader) {
				args.data = (args.row + 1).toString();
			}
			
			//% 표시
			if(args.panel.cellType===wijmo.grid.CellType.Cell){
				if (args.row > 0 &&  salPlnGrid.getCellData(args.row, 'comps', true) == '%') {
					var diff = salPlnGrid.getCellData(args.row,args.col,false);
					if(args.col==2){
						args.data = wijmo.Globalize.format(diff/100,'p1');
					}else{
						args.data = wijmo.Globalize.format(diff,'p1');								
					}						
				}
			}
			
		}
		

	};
	chartSalPlnSum.saveImageToDataUrl(wijmo.chart.ImageFormat.Svg, function(url) {
		//폰트를 글자에 적용시킴
		doc.drawText("ㅤ", 0, 0, { font: font });
		//폰트를 차트에 적용시킴
		//doc.drawSvg(url,null,null,{font:font},{height:100,width:100});
		doc.drawSvg(url, 0, 0, { font: font, height: 280, width: 200 });
	});
	chartSalPln.saveImageToDataUrl(wijmo.chart.ImageFormat.Svg, function(url) {
		//폰트를 글자에 적용시킴
		doc.drawText("ㅤ", 170, 0, { font: font });
		//폰트를 차트에 적용시킴
		//doc.drawSvg(url,null,null,{font:font},{height:100,width:100});
		doc.drawSvg(url, 170, 0, { font: font, height: 300, width: 600 });
	});

	//doc.drawText("그리드 인쇄",300,300,{font:font});
	doc.moveDown(25); //한줄 내리기(enter)
	//settings.customCellContent = true;   그리드 오류선색까지 모두 가져오기 그러나 한글이 깨짐
	wijmo.grid.pdf.FlexGridPdfConverter.draw(salPlnGrid, doc, 730, null, settings);

	doc.moveDown(600);

	chart.saveImageToDataUrl(wijmo.chart.ImageFormat.Svg, function(url) {
		//폰트를 글자에 적용시킴
		doc.drawText("ㅤ", 0, doc.y, { font: font });
		//폰트를 차트에 적용시킴
		//doc.drawSvg(url,null,null,{font:font},{height:100,width:100});
		doc.drawSvg(url, 0, doc.y, { font: font, height: 300, width: 750 });
	});

	doc.moveDown(25);
	doc.setBrush(new wijmo.pdf.PdfSolidBrush('#141414'));
	doc.drawText(LB_COMENT1,0,doc.y,{font:font});
	doc.paths.rect(doc.x, doc.y, 750, 80).stroke();
	doc.drawText($('#text1').val(), null, null, { font: font });

	doc.moveDown(8);

	doc.drawText(LB_COMENT2,0,doc.y,{font:font});
	doc.paths.rect(doc.x, doc.y, 750, 80).stroke();
	doc.drawText($('#text2').val(), null, null, { font: font });

	doc.end();

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
		},
		onStateChanged: function() {
			//console.log(this);
		}
	});

	$('.log_board .dropdown').on('click', function(e) {
		$($(e.target).next('.dropdown-menu')).css('display', 'block');
	});
}

function salPlnGridInit() {

	/*
	salPlnGrid.addUnboundSheet('sheet',0,0);
	salPlnGrid.isTabHolderVisible = false;	//엑셀시트 탭 비활성화
	salPlnGrid.allowMerging = true;
	salPlnGrid._contextMenu.show
	*/

	cv.sourceCollection = [];

	var c = new wijmo.grid.Column({ binding: "cd1", header: LB_DSTNCTN, width: 100, allowMerging: true });
	salPlnGrid.columns.push(c);

	var c = new wijmo.grid.Column({ binding: "comps", header: LB_LOC, width: 70 });
	salPlnGrid.columns.push(c);


	//필터제거
	flexGridFilter.filterColumns = [];
	salPlnGrid.allowPinning = 0; 						//고정클립 (0없음, 1컬럼하나,2컬럼범위, 3모두)
	salPlnGrid.allowMerging = 'Cells';
	salPlnGrid.columnHeaders.rows.defaultSize = 40; 	// 열 헤더 영역에 행의 높이 설정

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

