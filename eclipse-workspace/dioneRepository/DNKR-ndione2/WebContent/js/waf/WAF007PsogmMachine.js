/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
"use strict";

/**
 * [KO] 그리드에 data 셋팅
 * 
 * @param params Obj
 * @param _pageNo
 * @param gridTarget
 */
function setList(params, _pageNo, gridTarget) {
	mask.open();
	//console.log(gridTarget);
	gridTarget.setConfig({columns : [
	             					/*
	            					 * {key: "group", label: "필드A", width: 80, styleClass:
	            					 * function () { return "ABC"; }, enableFilter: true, align:
	            					 * "center", editor: { type: "text", disabled: function () { //
	            					 * item, value return false; } } },
	            					 */
	            					{
	            						key : "group",
	            						label : "교정분야",
	            						width : 80,
	            						styleClass : function() {
	            							return "ABC";
	            						},
	            						enableFilter : true,
	            						align : "center",
	            						editor : {
	            							type : "text",
	            							disabled : function() {
	            								// item, value
	            								return false;
	            							}
	            						}
	            					}, {
	            						key : "mngno",
	            						label : "관리번호",
	            						width : 80,
	            						styleClass : function() {
	            							return "ABC";
	            						},
	            						enableFilter : true,
	            						align : "center",
	            						editor : {
	            							type : "text",
	            							disabled : function() {
	            								// item, value
	            								return false;
	            							}
	            						}
	            					}, {
	            						key : "mname",
	            						label : "장비명",
	            						width : 80,
	            						styleClass : function() {
	            							return "ABC";
	            						},
	            						enableFilter : true,
	            						align : "center",
	            						editor : {
	            							type : "text",
	            							disabled : function() {
	            								// item, value
	            								return false;
	            							}
	            						}
	            					}, {
	            						key : "maker",
	            						label : "제조회사",
	            						width : 80,
	            						styleClass : function() {
	            							return "ABC";
	            						},
	            						enableFilter : true,
	            						align : "center",
	            						editor : {
	            							type : "text",
	            							disabled : function() {
	            								// item, value
	            								return false;
	            							}
	            						}
	            					}, {
	            						key : "mtype",
	            						label : "형식",
	            						width : 80,
	            						styleClass : function() {
	            							return "ABC";
	            						},
	            						enableFilter : true,
	            						align : "center",
	            						editor : {
	            							type : "text",
	            							disabled : function() {
	            								// item, value
	            								return false;
	            							}
	            						}
	            					}, {
	            						key : "jnbno",
	            						label : "장비번호",
	            						width : 80,
	            						styleClass : function() {
	            							return "ABC";
	            						},
	            						enableFilter : true,
	            						align : "center",
	            						editor : {
	            							type : "text",
	            							disabled : function() {
	            								// item, value
	            								return false;
	            							}
	            						}
	            					}, {
	            						key : "ipdat",
	            						label : "입고일자",
	            						width : 80,
	            						styleClass : function() {
	            							return "ABC";
	            						},
	            						enableFilter : true,
	            						align : "center",
	            						editor : {
	            							type : "text",
	            							disabled : function() {
	            								// item, value
	            								return false;
	            							}
	            						}
	            					}, {
	            						key : "rpdat",
	            						label : "최종교정일",
	            						width : 80,
	            						styleClass : function() {
	            							return "ABC";
	            						},
	            						enableFilter : true,
	            						align : "center",
	            						editor : {
	            							type : "text",
	            							disabled : function() {
	            								// item, value
	            								return false;
	            							}
	            						}
	            					}, {
	            						key : "repno",
	            						label : "교정번호",
	            						width : 80,
	            						styleClass : function() {
	            							return "ABC";
	            						},
	            						enableFilter : true,
	            						align : "center",
	            						editor : {
	            							type : "text",
	            							disabled : function() {
	            								// item, value
	            								return false;
	            							}
	            						}
	            					}, {
	            						key : "yedat",
	            						label : "예정일자",
	            						width : 80,
	            						styleClass : function() {
	            							return "ABC";
	            						},
	            						enableFilter : true,
	            						align : "center",
	            						editor : {
	            							type : "text",
	            							disabled : function() {
	            								// item, value
	            								return false;
	            							}
	            						}
	            					}, {
	            						key : "dptcd",
	            						label : "사용부서",
	            						width : 80,
	            						styleClass : function() {
	            							return "ABC";
	            						},
	            						enableFilter : true,
	            						align : "center",
	            						editor : {
	            							type : "text",
	            							disabled : function() {
	            								// item, value
	            								return false;
	            							}
	            						}
	            					}, {
	            						key : "disyn",
	            						label : "폐기여부",
	            						width : 80,
	            						styleClass : function() {
	            							return "ABC";
	            						},
	            						enableFilter : true,
	            						align : "center",
	            						editor : {
	            							type : "text",
	            							disabled : function() {
	            								// item, value
	            								return false;
	            							}
	            						}
	            					}, {
	            						key : "didat",
	            						label : "폐기일자",
	            						width : 80,
	            						styleClass : function() {
	            							return "ABC";
	            						},
	            						enableFilter : true,
	            						align : "center",
	            						editor : {
	            							type : "text",
	            							disabled : function() {
	            								// item, value
	            								return false;
	            							}
	            						}
	            					}, {
	            						key : "dresn",
	            						label : "폐기사유",
	            						width : 80,
	            						styleClass : function() {
	            							return "ABC";
	            						},
	            						enableFilter : true,
	            						align : "center",
	            						editor : {
	            							type : "text",
	            							disabled : function() {
	            								// item, value
	            								return false;
	            							}
	            						}
	            					}, {
	            						key : "j_gub",
	            						label : "장비구분",
	            						width : 80,
	            						styleClass : function() {
	            							return "ABC";
	            						},
	            						enableFilter : true,
	            						align : "center",
	            						editor : {
	            							type : "text",
	            							disabled : function() {
	            								// item, value
	            								return false;
	            							}
	            						}
	            					}, {
	            						key : "jkind",
	            						label : "장비유형",
	            						width : 80,
	            						styleClass : function() {
	            							return "ABC";
	            						},
	            						enableFilter : true,
	            						align : "center",
	            						editor : {
	            							type : "text",
	            							disabled : function() {
	            								// item, value
	            								return false;
	            							}
	            						}
	            					}, {
	            						key : "g_gub",
	            						label : "교정구분",
	            						width : 80,
	            						styleClass : function() {
	            							return "ABC";
	            						},
	            						enableFilter : true,
	            						align : "center",
	            						editor : {
	            							type : "text",
	            							disabled : function() {
	            								// item, value
	            								return false;
	            							}
	            						}
	            					}, {
	            						key : "gcycl",
	            						label : "교정주기",
	            						width : 80,
	            						styleClass : function() {
	            							return "ABC";
	            						},
	            						enableFilter : true,
	            						align : "center",
	            						editor : {
	            							type : "text",
	            							disabled : function() {
	            								// item, value
	            								return false;
	            							}
	            						}
	            					}, {
	            						key : "gnamt",
	            						label : "취득금액",
	            						width : 80,
	            						styleClass : function() {
	            							return "ABC";
	            						},
	            						enableFilter : true,
	            						align : "center",
	            						editor : {
	            							type : "text",
	            							disabled : function() {
	            								// item, value
	            								return false;
	            							}
	            						}
	            					}, {
	            						key : "jspec",
	            						label : "기기사양",
	            						width : 80,
	            						styleClass : function() {
	            							return "ABC";
	            						},
	            						enableFilter : true,
	            						align : "center",
	            						editor : {
	            							type : "text",
	            							disabled : function() {
	            								// item, value
	            								return false;
	            							}
	            						}
	            					}, {
	            						key : "accno",
	            						label : "자산번호",
	            						width : 80,
	            						styleClass : function() {
	            							return "ABC";
	            						},
	            						enableFilter : true,
	            						align : "center",
	            						editor : {
	            							type : "text",
	            							disabled : function() {
	            								// item, value
	            								return false;
	            							}
	            						}
	            					}, {
	            						key : "cnote",
	            						label : "비고",
	            						width : 80,
	            						styleClass : function() {
	            							return "ABC";
	            						},
	            						enableFilter : true,
	            						align : "center",
	            						editor : {
	            							type : "text",
	            							disabled : function() {
	            								// item, value
	            								return false;
	            							}
	            						}
	            					}

	            					]});
	var def = 1;
	for(var i = 1; i < 23; i++) {
		if($('#chk_Field'+i).is(':checked') === false) {
			gridTarget.removeColumn(i-def);
			def += 1;
		}
	}
	$.ajax({
		method : "post",
		url : "/WAF007PsogmMachineSearch/getData.do",
		data : params,
		success : function(res) {
			 //console.log(res);
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
				toastMsg(LN_NO_DATA);
				gridTarget.setData({
					list : [],
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
			}
		},
		error : function(res) {
			// //console.log("error");
			// console.log(res);
		},
		complete : function(res) {
			// gridBtnInit();
			setTimeout(function() {
				mask.close();
			}, 1000);
			// console.log("completed");
			// console.log(res);
		}
	});
	// console.log('ajaxend');
	// return true;
}

var machineGrid = {
	initView : function() {
		this.target = new ax5.ui.grid();
		this.target
				.setConfig({
					target : $('[data-ax5grid="first-grid"]'),
					frozenColumnIndex : 0,
					frozenRowIndex : 0,
					showLineNumber : true,
					showRowSelector : false,
					multipleSelect : true,
					lineNumberColumnWidth : 40,
					/* rowSelectorColumnWidth: 28, */
					sortable : false, // 모든 컬럼에 정렬 아이콘 표시
					multiSort : false, // 다중 정렬 여부
					remoteSort : false, // remoteSort에 함수를 sortable 컬럼이 클릭되었을때
										// 실행 setColumnSort를 직접 구현. (remoteSort를
										// 사용하면 헤더에 정렬 상태만 표시 하고 데이터 정렬은 처리 안함)
					header : {
						align : "center",
						columnHeight : 28
					},
					body : {
						align : "center",
						columnHeight : 28,
						onClick : function() {
							// console.log(this);
							this.self.select(this.dindex);
						},

					/*
					 * columns: [ { label: function () { return
					 * this.groupBy.labels.join(", ") + " 합계"; }, colspan: 2 },
					 * {key: "price", collector: "avg", formatter: "money",
					 * align: "right"}, {key: "amount", collector: "sum",
					 * formatter: "money", align: "right"}, { key: "cost",
					 * collector: function () { var value = 0;
					 * this.list.forEach(function (n) { if (!n.__isGrouping)
					 * value += (n.price * n.amount); }); return
					 * ax5.util.number(value, {"money": 1}); }, align: "right" },
					 * {label: "~~~", colspan: 3} ]
					 */

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
					/*
					 * {key: "group", label: "필드A", width: 80, styleClass:
					 * function () { return "ABC"; }, enableFilter: true, align:
					 * "center", editor: { type: "text", disabled: function () { //
					 * item, value return false; } } },
					 */
					{
						key : "group",
						label : "교정분야",
						width : 80,
						styleClass : function() {
							return "ABC";
						},
						enableFilter : true,
						align : "center",
						editor : {
							type : "text",
							disabled : function() {
								// item, value
								return false;
							}
						}
					}, {
						key : "mngno",
						label : "관리번호",
						width : 80,
						styleClass : function() {
							return "ABC";
						},
						enableFilter : true,
						align : "center",
						editor : {
							type : "text",
							disabled : function() {
								// item, value
								return false;
							}
						}
					}, {
						key : "mname",
						label : "장비명",
						width : 80,
						styleClass : function() {
							return "ABC";
						},
						enableFilter : true,
						align : "center",
						editor : {
							type : "text",
							disabled : function() {
								// item, value
								return false;
							}
						}
					}, {
						key : "maker",
						label : "제조회사",
						width : 80,
						styleClass : function() {
							return "ABC";
						},
						enableFilter : true,
						align : "center",
						editor : {
							type : "text",
							disabled : function() {
								// item, value
								return false;
							}
						}
					}, {
						key : "mtype",
						label : "형식",
						width : 80,
						styleClass : function() {
							return "ABC";
						},
						enableFilter : true,
						align : "center",
						editor : {
							type : "text",
							disabled : function() {
								// item, value
								return false;
							}
						}
					}, {
						key : "jnbno",
						label : "장비번호",
						width : 80,
						styleClass : function() {
							return "ABC";
						},
						enableFilter : true,
						align : "center",
						editor : {
							type : "text",
							disabled : function() {
								// item, value
								return false;
							}
						}
					}, {
						key : "ipdat",
						label : "입고일자",
						width : 80,
						styleClass : function() {
							return "ABC";
						},
						enableFilter : true,
						align : "center",
						editor : {
							type : "text",
							disabled : function() {
								// item, value
								return false;
							}
						}
					}, {
						key : "rpdat",
						label : "최종교정일",
						width : 80,
						styleClass : function() {
							return "ABC";
						},
						enableFilter : true,
						align : "center",
						editor : {
							type : "text",
							disabled : function() {
								// item, value
								return false;
							}
						}
					}, {
						key : "repno",
						label : "교정번호",
						width : 80,
						styleClass : function() {
							return "ABC";
						},
						enableFilter : true,
						align : "center",
						editor : {
							type : "text",
							disabled : function() {
								// item, value
								return false;
							}
						}
					}, {
						key : "yedat",
						label : "예정일자",
						width : 80,
						styleClass : function() {
							return "ABC";
						},
						enableFilter : true,
						align : "center",
						editor : {
							type : "text",
							disabled : function() {
								// item, value
								return false;
							}
						}
					}, {
						key : "dptcd",
						label : "사용부서",
						width : 80,
						styleClass : function() {
							return "ABC";
						},
						enableFilter : true,
						align : "center",
						editor : {
							type : "text",
							disabled : function() {
								// item, value
								return false;
							}
						}
					}, {
						key : "disyn",
						label : "폐기여부",
						width : 80,
						styleClass : function() {
							return "ABC";
						},
						enableFilter : true,
						align : "center",
						editor : {
							type : "text",
							disabled : function() {
								// item, value
								return false;
							}
						}
					}, {
						key : "didat",
						label : "폐기일자",
						width : 80,
						styleClass : function() {
							return "ABC";
						},
						enableFilter : true,
						align : "center",
						editor : {
							type : "text",
							disabled : function() {
								// item, value
								return false;
							}
						}
					}, {
						key : "dresn",
						label : "폐기사유",
						width : 80,
						styleClass : function() {
							return "ABC";
						},
						enableFilter : true,
						align : "center",
						editor : {
							type : "text",
							disabled : function() {
								// item, value
								return false;
							}
						}
					}, {
						key : "j_gub",
						label : "장비구분",
						width : 80,
						styleClass : function() {
							return "ABC";
						},
						enableFilter : true,
						align : "center",
						editor : {
							type : "text",
							disabled : function() {
								// item, value
								return false;
							}
						}
					}, {
						key : "jkind",
						label : "장비유형",
						width : 80,
						styleClass : function() {
							return "ABC";
						},
						enableFilter : true,
						align : "center",
						editor : {
							type : "text",
							disabled : function() {
								// item, value
								return false;
							}
						}
					}, {
						key : "g_gub",
						label : "교정구분",
						width : 80,
						styleClass : function() {
							return "ABC";
						},
						enableFilter : true,
						align : "center",
						editor : {
							type : "text",
							disabled : function() {
								// item, value
								return false;
							}
						}
					}, {
						key : "gcycl",
						label : "교정주기",
						width : 80,
						styleClass : function() {
							return "ABC";
						},
						enableFilter : true,
						align : "center",
						editor : {
							type : "text",
							disabled : function() {
								// item, value
								return false;
							}
						}
					}, {
						key : "gnamt",
						label : "취득금액",
						width : 80,
						styleClass : function() {
							return "ABC";
						},
						enableFilter : true,
						align : "center",
						editor : {
							type : "text",
							disabled : function() {
								// item, value
								return false;
							}
						}
					}, {
						key : "jspec",
						label : "기기사양",
						width : 80,
						styleClass : function() {
							return "ABC";
						},
						enableFilter : true,
						align : "center",
						editor : {
							type : "text",
							disabled : function() {
								// item, value
								return false;
							}
						}
					}, {
						key : "accno",
						label : "자산번호",
						width : 80,
						styleClass : function() {
							return "ABC";
						},
						enableFilter : true,
						align : "center",
						editor : {
							type : "text",
							disabled : function() {
								// item, value
								return false;
							}
						}
					}, {
						key : "cnote",
						label : "비고",
						width : 80,
						styleClass : function() {
							return "ABC";
						},
						enableFilter : true,
						align : "center",
						editor : {
							type : "text",
							disabled : function() {
								// item, value
								return false;
							}
						}
					},

					],
				/*
				 * footSum: [ [ {label: "전체 합계", colspan: 2, align: "center"},
				 * {key: "price", collector: "avg", formatter: "money", align:
				 * "right"}, {key: "amount", collector: "sum", formatter:
				 * "money", align: "right"}, { key: "cost", collector: function () {
				 * var value = 0; this.list.forEach(function (n) { if
				 * (!n.__isGrouping) value += (n.price * n.amount); }); return
				 * ax5.util.number(value, {"money": 1}); }, align: "right" } ]]
				 */
				});
		return this;
	},
	setData : function(_pageNo) {

		// var list = [];
		// for (var i = 0, l = 100; i < l; i++) {
		// list.push($.extend({}, sampleData[(Math.floor(Math.random() *
		// sampleData.length))]));
		// }

		setList("", _pageNo, this.target);
		return this;
	}
};

function cmb_field_OnChanged(obj) {
	var strCode = obj.value;
	//console.log(obj);
	var targetNo = $(obj).attr('data-target');
	//console.log(targetNo);
	//console.log($('#cmb_operatot' + targetNo));
	$('#cmb_operatot' + targetNo).val("=");
	if (strCode == "IPDAT" || strCode == "RPDAT" || strCode == "YEDAT"
			|| strCode == "DIDAT") {
		// if (strCode == "IPDAT" || strCode == "GCYCL" || strCode == "GNAMT" ||
		// strCode == "DIDAT"){
		$('#ed_where' + targetNo).val("").addClass("displayNone");
		$('#cmb_where' + targetNo).val("").addClass("displayNone");
		$('#cal_where' + targetNo).val("").removeClass("displayNone");
		$('#lblselfield' + targetNo).val("");
	} else if (strCode == "DPTCD" || strCode == "DRESN" || strCode == "J_GUB"
			|| strCode == "JKIND" || strCode == "G_GUB") {
		var strCodeval = ""; // 코드값
		$('#ed_where' + targetNo).val("").addClass("displayNone");
		$('#cmb_where' + targetNo).val("").removeClass("displayNone");
		$('#cal_where' + targetNo).val("").addClass("displayNone");

		switch (strCode) // 폐기여부사용안함.
		{
		case "DPTCD": // 부서코드
			strCodeval = "";
			getogmGauge_mst650(targetNo);
			break;
		case "DRESN": // 폐기사유
			strCodeval = "DRN";
			getcmb_field(strCodeval, targetNo);
			break;
		case "J_GUB": // 장비구분
			strCodeval = "GAG";
			getcmb_field(strCodeval, targetNo);
			break;
		case "JKIND": // 장비유형
			strCodeval = "GKN";
			getcmb_field(strCodeval, targetNo);
			break;
		case "G_GUB": // 교정구분
			strCodeval = "";
			// getcmb_field(strCodeval);
			var strHtml = "";
			strHtml += "<option value=''></option>";
			strHtml += "<option>사내</option>";
			strHtml += "<option>사외</option>";
			strHtml += "<option>표준기(사외)</option>";
			$('#cmb_where' + targetNo).html(strHtml);

			// ds_cmbsel.InsertRow(0);
			// ds_cmbsel.SetColumn(0,"CODE","");
			// ds_cmbsel.SetColumn(0,"CODENM","");
			// ds_cmbsel.SetColumn(0,"CDNM","");
			// ds_cmbsel.InsertRow(1);
			// ds_cmbsel.SetColumn(1,"CODE","1");
			// ds_cmbsel.SetColumn(1,"CODENM","사내");
			// ds_cmbsel.SetColumn(1,"CDNM","1 | 사내");
			// ds_cmbsel.InsertRow(2);
			// ds_cmbsel.SetColumn(2,"CODE","2");
			// ds_cmbsel.SetColumn(2,"CODENM","사외");
			// ds_cmbsel.SetColumn(2,"CDNM","2 | 사외");
			// ds_cmbsel.InsertRow(3);
			// ds_cmbsel.SetColumn(3,"CODE","3");
			// ds_cmbsel.SetColumn(3,"CODENM","표준기(사외)");
			// ds_cmbsel.SetColumn(3,"CDNM","3 | 표준기(사외)");
			break;
		}
		$('#lblselfield' + targetNo).val("");
	} else {
		$('#ed_where' + targetNo).val("").removeClass("displayNone");
		// ed_where1.Text = "";
		// ed_where1.Visible = true;
		ed_where1.Number = false;
		ed_where1.UpperOnly = true;
		$('#cmb_where' + targetNo).val("").addClass("displayNone");
		// cmb_where1.Value = "";
		// cmb_where1.Visible = false;
		$('#cal_where' + targetNo).val("").addClass("displayNone");
		// cal_where1.Value = "";
		// cal_where1.Visible = false;
		if (strCode == "GCYCL" || strCode == "GNAMT") {
			$('#ed_where' + targetNo).val(0)
			ed_where1.Number = true;
			// ed_where1.Text = "0";
		}
		$('#lblselfield' + targetNo).val("");
	}
}

/**
 * 부서리스트
 * @param targetNo number
 */
function getogmGauge_mst650(targetNo){
	$.ajax({
		type    : "POST",
		url     : "/WAF007PsogmMachineSearch/selectOGMgauge_Mst650pf.do",
		success : function (res){
			//console.log(res)
			var data = JSON.parse(res);
			var strHtml = "<option value=''></option>";
			if(data.relationList.length > 0 ) {
				data.relationList.forEach(function(item, index) {
					strHtml += '<option value="' + item.dpcode + '">' + item.cdnm + '</option>';
				});
				$('#cmb_where' + targetNo).html(strHtml);
			} else {
				$('#cmb_where' + targetNo).html(strHtml);
			}
			
			
		},
		error   : function(x,e){
			ajaxError(x,e);
		}
	});
//	var sKind		= "getMst650pf";						
//	var sMethodName = "service::psogmlib/selectOGMgauge_Mst650pf.do"; 
//	var sInDataSet  = "";
//	var sOutDataSet = "ds_cmbsel=ds_mst650pf";
//	var sArgument   = "";
//		sArgument += " LIB2=" + quote(Lib2);
//		sArgument += " COMPS=" + quote(ComboBoxPlant.Value); //사업부
//		
//	http.Sync = true;
//	Transaction(sKind, sMethodName, sInDataSet, sOutDataSet, sArgument, "");
//	http.Sync = false;
}

function getcmb_field(cmbselVal, targetNo){

	$.ajax({
		type    : "POST",
		url     : "/WAF007PsogmMachineSearch/selectOgm411_cmbsel.do",
		data : {grpcd : cmbselVal},
		success : function (res){
			//console.log(res)
			var data = JSON.parse(res);
			var strHtml = "<option value=''></option>";
			if(data.list.length > 0 ) {
				data.list.forEach(function(item, index) {
					strHtml += '<option value="' + item.code + '">' + item.cdNm + '</option>';
				});
				$('#cmb_where' + targetNo).html(strHtml);
			} else {
				$('#cmb_where' + targetNo).html(strHtml);
			}
			
			
		},
		error   : function(x,e){
			ajaxError(x,e);
		}
	});
		
//    var sKind		= "getcmb_field";						
//	var sMethodName = "service::psogmlib/selectOgm411_cmbsel.do";   // 서버에서 호출 될 Method 명
//	var sInDataSet  = "";                             				// 자료 저장 시 보낼 DataSet 명칭
//	var sOutDataSet = "ds_cmbsel=ds_cmbsel";    				// 조회 후 돌려 받을 DataSet 명칭
//	var sArgument   = "";
//		sArgument += " LIB2=" + quote(lib2);
//		sArgument += " COMPS=" + quote(ComboBoxPlant.Value); //사업부
//		sArgument += " GRPCD=" + quote(cmbselVal); //사업부
//	http.Sync = true;
//	Transaction(sKind, sMethodName, sInDataSet, sOutDataSet, sArgument, "");
//	http.Sync = false;
}

function getOgm411(gridTarget){
	
	var params = {};
	params['comps'] = $('#ComboBoxPlant').val();
	
	//교정분야
	var CheckedCount1 = Number($('#chk_group1').is(':checked'))
		+ Number($('#chk_group2').is(':checked')) + Number($('#chk_group3').is(':checked'));
	//console.log("CheckedCount1:" + CheckedCount1);
	
	var rvalue;
	if (CheckedCount1 == 0){
		rvalue = "('1','2','3')";
	}else{		
		rvalue = " (";
		var checking = 0;
		if ($('#chk_group1').is(':checked') === true){
			checking = checking+1;
			rvalue = rvalue+"'"+"1"+"'";
		}
		if ($('#chk_group2').is(':checked') === true){
			if (checking != 0) rvalue = rvalue+",";
			checking = checking+1;
			rvalue = rvalue+"'"+"2"+"'";
		}
		if ($('#chk_group3').is(':checked') === true){
			if (checking != 0) rvalue = rvalue+",";
			checking = checking+1;
			rvalue = rvalue+"'"+"3"+"'";
		}
		rvalue = rvalue+")";
	}
	
	params['group'] = rvalue;
	
	//폐기여부
	//console.log("sDISYN:" + $('input[name = rd_endYN]:checked').val());
	var sDISYN = $('input[name = rd_endYN]:checked').val();
	params['disyn'] = sDISYN;
	//검색조건선택
	var rcondition;
	var rcondition1;
	var rcondition2;
			
	var len1 = $('#lblselfield1').val().length;
	var len2 = $('#lblselfield2').val().length;
	//console.log("len1:" + len1);
	//console.log("len2:" + len2)
	
	if (len1 > 0){
//		if (length(cmb_field1.Value)==0 || length(cmb_operatot1.Text) == 0){
		if ($('#cmb_field1').val().length === 0 || $('#cmb_operatot1').val().length === 0){
//			alert(setPopMessage("3057"));
			toastMsg("E01");
			return false;
		} else {
			if ($('#cmb_field1').val() === "IPDAT" || $('#cmb_field1').val() === "DIDAT" || $('#cmb_field1').val() === "GCYCL" || $('#cmb_field1').val() === "GNAMT" ){
				rcondition1 = "(A." + $('#cmb_field1').val() +" "+ $('#cmb_operatot1').val() +" "+ $('#lblselfield1').val().trim() + ")";
			}else if ($('#cmb_field1').val() === "RPDAT" || $('#cmb_field1').val() === "YEDAT"){
				rcondition1 = "(B." + $('#cmb_field1').val() +" "+ $('#cmb_operatot1').val() + " "+ $('#lblselfield1').val().trim() + ")";
			}else{
				if ($('#cmb_operatot1').val() === "="){
					if($('#cmb_field1').val() === "REPNO"){
						rcondition1 = "(B." + $('#cmb_field1').val() +" Like '"+ $('#lblselfield1').val().trim() + "%')";
					}
					else{
						rcondition1 = "(A." + $('#cmb_field1').val() +" Like '"+ $('#lblselfield1').val().trim() + "%')";				
					}
				}
				else {
					rcondition1 = "(A." + $('#cmb_field1').val() +" "+ $('#cmb_operatot1').val() + " '" + $('#lblselfield1').val().trim() + "')";
			
				}
				//console.log("rcondition1:" + rcondition1);
			}
		}	
	}
	
	if (len2 > 0){
		if ($('#cmb_field2').val().length === 0 || $('#cmb_operatot2').val().length === 0){
//			alert(setPopMessage("3057"));
			toastMsg("E02");
			return false;
		}
		else {
			if ($('#cmb_field2').val() === "IPDAT" || $('#cmb_field2').val() === "DIDAT" || $('#cmb_field2').val() === "GCYCL" || $('#cmb_field2').val() === "GNAMT" ){
				rcondition2 = "(A." + $('#cmb_field2').val() +" "+ $('#cmb_operatot2').val() +" "+ $('#lblselfield2').val().trim() + ")";
			}else if ($('#cmb_field2').val() === "RPDAT" || $('#cmb_field2').val() == "YEDAT"){
				rcondition2 = "(B." + $('#cmb_field2').val() +" "+ $('#cmb_operatot2').val() + " "+ $('#lblselfield2').val().trim() + ")";
			}else{
				if ($('#cmb_operatot2').val() === "="){
					if($('#cmb_field2').val() === "REPNO"){
						rcondition2 = "(B." + $('#cmb_field2').val() +" Like '"+ $('#lblselfield2').val().trim() + "%')";
					}
					else{
						rcondition2 = "(A." + $('#cmb_field2').val() +" Like '"+ $('#lblselfield2').val().trim() + "%')";				
					}
				}
				else {
					rcondition2 = "(A." + $('#cmb_field2').val() +" "+ $('#cmb_operatot2').val() + " '" + $('#lblselfield2').val().trim() + "')";
			
				}
				//console.log("rcondition2:" + rcondition2);
			}
		}	
	}

	if ((len1 > 0) && (len2 > 0)){
		rcondition = "(" + rcondition1 + " " + $('#cmb_Lo').val() + " " + rcondition2 + ")";
		//console.log("rcondition:" + rcondition);
	}else if ((len1 > 0) && (len2 == 0)){
		rcondition = rcondition1;
	}else if ((len1 == 0) && (len2 > 0)){
		rcondition = rcondition2;
	}
	//console.log("rcondition" + rcondition);
	if(rcondition !== undefined){
		//console.log('????');
		params['pwhere'] = rcondition;
	}
	
	setList(params, 1, gridTarget);
	return false;
	
	
	//조회항목선택
//	var Grd_Cellcnt = 0;
//	ds_selectCnt.ClearData();
//	for (var i=1; i<=22;i++){
//		var chk_Field = "chk_Field"+i;
//		var arr_UserData;
//		if (object(chk_Field).Value == true){
//			arr_UserData = split(object(chk_Field).UserData,',');
//			Grd_Cellcnt = Grd_Cellcnt + 1;
//			ds_selectCnt.InsertRow(Grd_Cellcnt-1);
//			ds_selectCnt.SetColumn(Grd_Cellcnt-1,"NO",i);
//			ds_selectCnt.SetColumn(Grd_Cellcnt-1,"FIELDNM",object(chk_Field).Text);
//			ds_selectCnt.SetColumn(Grd_Cellcnt-1,"FIELDCD",arr_UserData[0]);
//			ds_selectCnt.SetColumn(Grd_Cellcnt-1,"POSITION",arr_UserData[1]);
//			ds_selectCnt.SetColumn(Grd_Cellcnt-1,"WIDTH",arr_UserData[2]);
//		}
//	}
//	
//	//그리드 Contents 생성
//	MainGrid.contents = fn_makeGrdContents(MainGrid, Grd_Cellcnt);
//
//	//조회
//	var sKind		= "getOgm411";						
//	var sMethodName = "service::psogmlib/selectogm411.do";     		// 서버에서 호출 될 Method 명
//	var sInDataSet  = "";                             				// 자료 저장 시 보낼 DataSet 명칭
//	var sOutDataSet = "ds_ogm411=ds_ogm411";    				// 조회 후 돌려 받을 DataSet 명칭
//	var sArgument   = "";
//	sArgument += "@LIB2=" + quote(lib2); //PSCDBLIB사용일경우 폐기사유, 장비구분유형 데이터 안나옴.
//	sArgument += "@COMPS=" + quote(ComboBoxPlant.Value); //사업부
//	sArgument += "@PGROUP=" + quote(rvalue); //교정분야
//	sArgument += "@PDISYN=" + quote(sDISYN); //폐기여부
//	sArgument += "@PWHERE=" + quote(rcondition); //검색조건 rcondition
//	http.Sync = true;
//	var str = dialog("Common::PGMLOAD.xml","sKind=" + sKind + " " + "sMethodName=" + sMethodName + " " + "sOutDataSet=" + sOutDataSet + " " + "sArgument=" + sArgument,272,64,"TitleBar=false");
//	http.Sync = false;
//	if (str == 'T'){  //정상조회
//		alert(setPopMessage("1004"));
//		setMessage("1004");	
//	}else if (str == 'B'){   //data값이 없을때
//		alert(setPopMessage("1003"));
//		setMessage("1003");	
//	}else if (str == 'E'){   //error발생시
//		alert(setPopMessage("1002"));
//		setMessage("1002");	
//	}
//	get_TotalCount(); //total구하기
}

function cmb_where_onchange (e) {
	var targetNo = $(e).attr('data-target');
	//console.log("targetNo:" + targetNo);
	//console.log($(e).val());
	$('#lblselfield' + targetNo).val($(e).val());
}

$(function() {
	var grid = machineGrid.initView();
	
	$('.sc-condi .dropdown').on('click', function(e){
		$($(e.target).closest('.dropdown').find('.dropdown-menu')).css('display', 'block');
	});
	
	var Calendar1 = new ax5.ui.calendar({
        target: document.getElementById("calendar_where1"),
        control: {
            left: '<i class="fa fa-chevron-left"></i>',
            yearTmpl: '%s',
            monthTmpl: '%s',
            right: '<i class="fa fa-chevron-right"></i>',
            yearFirst: true
        },
        displayDate: (new Date()),
        lang: {
        	/*yearTmpl: "%s년",*/
            /*months: ['일월', '이월', '삼월', '사월', '오월', '육월', '칠월', '팔월', '구월', '시월', '십일월', '십이월'],*/
        	yearTmpl: YEAR_FORMAT,
        	months: MONTH,
        	dayTmpl: "%s"
        },
        dimensions: {
            height: 250,
            controlHeight: 50,
            itemPadding: 5
        },
        onClick: function () {
        	var date = this.self.getSelection();
       	 	$(this.target).css('display', 'none');
            $(this.target).prev().val(date);
            $('#lblselfield1').val(date);
        },
        onStateChanged: function () {
            //console.log(this);
        }
    });

	var Calendar2 = new ax5.ui.calendar({
        target: document.getElementById("calendar_where2"),
        control: {
            left: '<i class="fa fa-chevron-left"></i>',
            yearTmpl: '%s',
            monthTmpl: '%s',
            right: '<i class="fa fa-chevron-right"></i>',
            yearFirst: true
        },
        displayDate: (new Date()),
        lang: {
        	/*yearTmpl: "%s년",*/
            /*months: ['일월', '이월', '삼월', '사월', '오월', '육월', '칠월', '팔월', '구월', '시월', '십일월', '십이월'],*/
        	yearTmpl: YEAR_FORMAT,
        	months: MONTH,
        	dayTmpl: "%s"
        },
        dimensions: {
            height: 250,
            controlHeight: 50,
            itemPadding: 5
        },
        onClick: function () {
        	var date = this.self.getSelection();
        	 $(this.target).css('display', 'none');
             $(this.target).prev().val(date);
             $('#lblselfield2').val(date);
        },
        onStateChanged: function () {
            //console.log(this);
        }
    });

	
	// $("input:radio[name=rd_endYN]").click(function() {
	// common_OnChanged();
	// })

	$("._searchBtn_").on('click', function() {
		getOgm411(machineGrid.target);
//		setList("", 1, machineGrid.target);
	});
	
	$('._excelBtn_').click(function () {
		machineGrid.target.exportExcel("PsogmMachine-excel.xls");
    });

	// on_LoadCompleted();

})