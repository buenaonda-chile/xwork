/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
"use strict";

var picker = new ax5.ui.picker();

//조회함수
function getPpmi001m () {
	mask.open();
	var params = $('#prodStatusForm').serialize();
	$.ajax({
		type: "POST",
		url: "/WAF008PsogmProdStatus/selectPpmi001M.do",
		data: params,
		success : function (res) {
			//console.log(res);
			var data = JSON.parse(res);
			try {
				if(data.result === RESULT_Y){
					var today = new Date();
					var strToday = today.getFullYear() + "년 " + Number(today.getMonth() + 1) + "월 "
					+ today.getDate() + "일 " + today.getHours() + "시 " + today.getMinutes() + '분 '
					+ today.getSeconds() + '초'
					//console.log('today:' + today);
					//console.log('year:' + today.getFullYear());
					//console.log('month:' + Number(today.getMonth() + 1));
					//console.log('day:' + today.getDate());
					//console.log('hour:' + today.getHours());
					//console.log('min:' + today.getMinutes());
					//console.log('sec:' + today.getSeconds());
					$('#updateTime span').text("갱신시간 : " + strToday);
					if(data.result1 === RESULT_Y){
						firstGrid.target.setData(data.searchList);
					};
					
					if(data.result2 === RESULT_Y){
						secondGrid.target.setData(data.searchList2);
					};
					var sumObjs = [
					               data.sumDomain1,
					               data.sumDomain2,
					               data.sumDomain3,
					               data.sumDomain4,
					               ];
					for (var i = 0; i < 4; i++) {
						$('#sumTable' + i +' .sum1').text(sumObjs[i].sum1);
						$('#sumTable' + i +' .sum2').text(sumObjs[i].sum2);
						$('#sumTable' + i +' .sum3').text(sumObjs[i].sum3);
						$('#sumTable' + i +' .per1').text(sumObjs[i].per1);
						$('#sumTable' + i +' .per2').text(sumObjs[i].per2);
					}
				} else {
					toastMsg("데이터가 없습니다.");
				}
				
			} catch(e) {
				//console.log(e);
			}
			
		},
		error: function(res) {
			toastMsg("처리되었습니다.");
			//console.log(res);
		},
		complete : function() {
			mask.close();
		}
	});
}

var firstGrid = {
		initView: function() {
			this.target = new ax5.ui.grid();
			this.target.setConfig({
				target : $('[data-ax5grid="first-grid"]'),
				showLineNumber:true,
				header: {
					align:"center",
					columnHeight: 40,
				},
				body:{
					align:"center"
				},
				columns: gridColumn,
			});
			
		},
		setData: function () {
			
		}
};

var secondGrid = {
		initView: function() {
			this.target = new ax5.ui.grid();
			this.target.setConfig({
				target : $('[data-ax5grid="second-grid"]'),
				showLineNumber:true,
				header: {
					align:"center",
					columnHeight: 40,
				},
				body:{
					align:"center"
				},
				columns: gridColumn,
			});
			
		},
		setData: function () {
			
		}
};

var gridColumn = [
		           {
						key : "procs",
						label : "공정코드",
						width : 60,
					},
					{
						key : "prosm",
						label : "공정명",
						width : 80,
					},
					{
						key : "mstsm",
						label : "생산중 차종명",
						width : 100,
					},
					{
						key : "cyctm",
						label : "<p style='top: 3px;position: absolute;left: 12px;line-height:16px'>택트<br>타임</p>",
						width : 50,
					},
					{
						key : "fstqy",
						label : "<p style='top: 3px;position: absolute;left: 12px;line-height:16px'>생산<br>계획</p>",
						width : 50,
						styleClass : function () {
							return "textColorRed";
						},
					},
					{
						key : "atoqy",
						label : "<p style='top: 3px;position: absolute;left: 12px;line-height:16px'>생산<br>능력</p>",
						width : 50,
						styleClass : function () {
							return "textColorRed";
						},
					},
					{
						key : "prdqy",
						label : "<p style='top: 3px;position: absolute;left: 12px;line-height:16px'>생산<br>실적</p>",
						width : 50,
						styleClass : function () {
							return "textColorRed";
						},
					},
					{
						key : "fstqyRate",
						label : "<p style='top: 3px;position: absolute;left: 12px;line-height:16px'>실적 /<br>계획 %</p>",
						width : 50,
						formatter : function() {
							return Number(this.value).toFixed(2);
						}
					},
					{
						key : "atoqyRate",
						label : "<p style='top: 3px;position: absolute;left: 12px;line-height:16px'>실적 /<br>능력 %</p>",
						width : 50,
						formatter : function() {
							return Number(this.value).toFixed(2);
						}
					},
					{
						key : "runcd",
						label : "공정상태",
						width : 80,
						formatter : function() {
							if(this.value === 'P') {
								return "비가동";
							} else {
								//가동 R
								return "가동";
							}
						}
					},
					{
						key : "daygu",
						label :"주야구분",
						width : 80,
						formatter : function() {
							//console.log(this);
							//console.log(this.item);
							if(this.value === 'D') {
								return "주간";
							} else {
								//야간 N
								return "야간";
							}
						}
					},
					
				];

$(document.body).ready(function() {
	mask.close();
	var myInterval;
	
	$('[data-ax5formatter]').ax5formatter();
	firstGrid.initView();
	secondGrid.initView();
	 
	//Date
	picker.bind({
        target: $('[data-ax5picker="basic"]'),
        direction: "top",
        content: {
            width: 270,
            margin: 10,
            type: 'date',
            config: {
                control: {
                    left: '<i class="fa fa-chevron-left"></i>',
                    yearTmpl: '%s',
                    monthTmpl: '%s',
                    right: '<i class="fa fa-chevron-right"></i>'
                },
                lang: {
                    yearTmpl: "%s년",
                    months: ['01월', '02월', '03월', '04월', '05월', '06월', '07월', '08월', '09월', '10월', '11월', '12월'],
                    dayTmpl: "%s"
                }
            }
        },
        onStateChanged: function () {

        }
	});
	
	$('._searchBtn_').on('click', function() {
		getPpmi001m();
	});
	
	$('#rowgb').on('change', function(){
		//console.log($('#prodStatus_wrap .grid-parent:nth-child(1) > h3'));
		//console.log($('#prodStatus_wrap .grid-parent:nth-child(2) > h3'));
		if (this.value === "1") {
			$('#prodStatus_wrap .grid-parent:nth-child(1) > h3').text("2공장2층");
			$('#prodStatus_wrap .grid-parent:nth-child(2) > h3').text("3공장2층 외");
		} else if (this.value === "2") {
			$('#prodStatus_wrap .grid-parent:nth-child(1) > h3').text("3공장2층 외");
			$('#prodStatus_wrap .grid-parent:nth-child(2) > h3').text("전자공장");
		} else if (this.value === "3") {
			$('#prodStatus_wrap .grid-parent:nth-child(1) > h3').text("전자공장");
			$('#prodStatus_wrap .grid-parent:nth-child(2) > h3').text("성형반");
		}
		getPpmi001m();
	});
	
	//갱신
	$('#replayTime').on('change', function() {
		if(this.value !== "0") {
			myInterval = setInterval(getPpmi001m, this.value * 1000);
		} else {
			clearInterval(myInterval);
		}
	});
	
	getPpmi001m();
	
	
	
});