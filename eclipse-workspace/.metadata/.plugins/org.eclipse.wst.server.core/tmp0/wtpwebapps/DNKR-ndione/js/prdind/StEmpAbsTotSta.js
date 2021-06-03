//code intellisense typescript 정의
///<reference path = "../../wijmo/controls/wijmo.d.ts"/>	
///<reference path = "../../wijmo/controls/wijmo.grid.d.ts"/>
///<reference path = "../../wijmo/controls/wijmo.grid.sheet.d.ts"/>
///<reference path = "../../wijmo/controls/wijmo.input.d.ts"/>

/// <reference path ="../../wijmo/controls/wijmo.chart.d.ts"/>
/// <reference path ="../../wijmo/controls/wijmo.pdf.d.ts"/>
/// <reference path ="../../wijmo/controls/wijmo.nav.d.ts"/>


// 컬랙션 뷰는 조회후에 그리드의 상태변경을 체크한다. 
var cv = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수

var flexGrid = new wijmo.grid.FlexGrid('#wijmoGrid');	//그리드 전역변수
var itemMast = null;



//
////--------------------------------------------------------------------------------------------//
//// CustomMergeManager class (transpiled from TypeScript)
//// 행열에 상관 없이 인접한 동일 데이터에 대해서 셀 병합을 하고자 하시는 경우,
//// 해당 클래스를 JS 또는 스트립트 단에서 그대로 복사하셔서 사용 하시면 됩니다.
////--------------------------------------------------------------------------------------------//


var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
var wijmo;
(function (wijmo) {
    var grid;
    (function (grid) {
        'use strict';
        /**
         * Class that extends the standard MergeManager to support merged ranges that
         * span both rows and columns.
         *
         * This class uses the same content-based approach used by the built-in merge
         * manager, but it could use any other logic instead (for example, a fixed list
         * of pre-defined merged ranges).
         */


        var CustomMergeManager = (function (_super) {
            __extends(CustomMergeManager, _super);
            function CustomMergeManager() {
                _super.apply(this, arguments);
            }
            CustomMergeManager.prototype.getMergedRange = function (panel, r, c, clip) {
                if (clip === void 0) { clip = true; }
                // create basic cell range
				var rg = new grid.CellRange(r, c);
					
					//4열보다 작은 컬럼(헤더포함) 가로병합, 모든헤더컬럼 가로병합
					if(c < 5 || panel.cellType == wijmo.grid.CellType.ColumnHeader){ 		
		                // expand left/right
		                for (var i = rg.col; i < panel.columns.length - 1; i++) {
		                    if (panel.getCellData(rg.row, i, true) != panel.getCellData(rg.row, i + 1, true))
		                        break;
		                    rg.col2 = i + 1;
		                }
		                for (var i = rg.col; i > 0; i--) {
		                    if (panel.getCellData(rg.row, i, true) != panel.getCellData(rg.row, i - 1, true))
		                        break;
		                    rg.col = i - 1;
		                }
		                // expand up/down
		                for (var i = rg.row; i < panel.rows.length - 1; i++) {
		                    if (panel.getCellData(i, rg.col, true) != panel.getCellData(i + 1, rg.col, true))
		                        break;
		                    rg.row2 = i + 1;
		                }
		                for (var i = rg.row; i > 0; i--) {
		                    if (panel.getCellData(i, rg.col, true) != panel.getCellData(i - 1, rg.col, true))
		                        break;
		                    rg.row = i - 1;
		                }
					}						
					
					
                // done
                return rg;
            };
            return CustomMergeManager;
        }(grid.MergeManager));
        grid.CustomMergeManager = CustomMergeManager;
    })(grid = wijmo.grid || (wijmo.grid = {}));
})(wijmo || (wijmo = {}));
////# sourceMappingURL=CustomMergeManager.js.map
////--------------------------------------------------------------------------------------------//
//// CustomMergeManager class END

	

// 컬랙션 뷰는 조회후에 그리드의 상태변경을 체크한다. 
//var cv = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수
//
//var flexGrid = new wijmo.grid.FlexGrid('#wijmoGrid');	//그리드 전역변수
//var itemMast = null;

	// create extra header row
//    var extraRow = new wijmo.grid.Row();
//    extraRow.allowMerging = true;
//    //
//    // add extra header row to the grid
//    var panel = flexGrid.columnHeaders;
//    panel.rows.splice(0, 0, extraRow);



/**
 * 더존 부서정보 취득
 */
function getDeptMaster() {
	if($('#getComps').val() != ""){	
		$.ajax({
			method : "post",
			url : "/ajaxPrdctIndComBase/searchDeptMaster.do",
			data : {
				'getComps' : $("#getComps").val()
			},
			success : function(res) {
				itemMast = JSON.parse(res).list;
			},
			error : function() {
				console.log("dataset.error");
			},
			completed : function() {
				setTimeout(function() {
					mask.close();				
				}, 500);
			}
		});
	}
}



function getToday(){
    var date = new Date();
    var year = date.getFullYear();
    var month = ("0" + (1 + date.getMonth())).slice(-2);
    var day = ("0" + date.getDate()).slice(-2);

    return year + month + day;
}


/**
 * 팝업창에서 값넘겨받아 부모창에 데이터 set
 * 
 * @param returnValue
 */
function getReturnValue(returnValue) {
	if(returnValue !== null) {
		var custObj = JSON.parse(returnValue);

		$('#getPyvnd').val(custObj.cusno);
		$('#getCusnm').val(custObj.cusnm);
	}
}


/**
 * 등록시 오류검증
 */
function validation(item){

}


function handleEvent(){

	//등록폼 닫기버튼
	$("._closeBtn_").on("click",function(){
		var target = this.getAttribute("data-click-target");
		addBtnUiSet(this);
	});

	$('._custBtn_').on('click', function() {
		window.open("/ajaxCustomer/init.do","customerPop","width=550,height=600,scrollbars=yes,top=100,left=100");
	});
	
}


function search(){
	//validation 체크기능으로 입력칸에 커서가 활성화 되어있을경우 조회시 오류가 발생함.
	//validation edit 기능을 비활성화 시키고 조회시킴.
	flexGrid.validateEdits = false;	
	flexGrid.allowSorting = false;
//	if(!$(".getComps").val()){
////		toastMsg(LN_SELECT_COMPS);
//		return false;
//	}else if(!$("#getPartId").val()){
//		toastMsg(LN_SELECT_LINE);
//		return false;
//	}
	

	var url = "/ajaxStEmpAbsTotSta/search.do";	
	var params = {
		'getComps' : $("#getComps").val()
		,'getOpertDe' : $("#getOpertDe").val()		
	};
	
	mask.open();
	$.ajax({
		method : "post",
		url : url,
		data :params,
		success : function(res) {
			var data = JSON.parse(res).list;
			cv.sourceCollection = data;
			
//			console.log("data.length"+data.length);
//			console.log("data[0].locCode:"+data[0].locCode);
			
			for(var i=0; i<data.length; i++){
//				console.log("data[i].locCode:"+data[i].locCode);
				
				if(data[i].locCode==null || wijmo.isEmpty(data[i].locCode) || data[i].locCode == "" ){
					return "[부서(반)]를 입력 하세요.";		
				}else{
					var flag = true;
					itemMast.forEach (function (data2, index) {	
//						console.log("i:"+i);
//						console.log("data[i].locCode:"+data[i].locCode);		  		
						var code = data2.code;
						var name = data2.name;	
						
						var trimCode = "";	
						if(code != null) {
							trimCode = code.trim();
						}
						var locCode = data[i].locCode;
						var trimLocCode = locCode.trim();
						
						if(trimLocCode == trimCode) {						
							data[i].locNm = name;
							flag = false;
							return false;
						}
					});		
				}
				
				if(data[i].partCode==null || wijmo.isEmpty(data[i].partCode) || data[i].partCode == "" ){
//					item.locNm = "";
					return "[부서(Part)]를 입력 하세요.";
				}else{
					var flag = true;
					itemMast.forEach (function (data2, index) {			  		
						var code = data2.code;
						var name = data2.name;	
						var trimCode = "";	
						if(code != null) {
							trimCode = code.trim();
						}
						var partCode = data[i].partCode;
						var trimLocCode = partCode.trim();
						if(trimLocCode == trimCode) {
							data[i].partNm = name;
							flag = false;
							return false;
						}
					});	
					if(flag) {
						data[i].partCode = "";						
						data[i].partNm = "";
					}
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
 * 엑셀 다운로드
 */
function downloadExcel(){
	var fileName = "작업신청집계현황_"+getToday()+".xlsx";
	transExcel(flexGrid,fileName);
}


function gridInit(){
	
	var columnsDefinition=[
					
		{binding:'partCode',header: LB_PART_CODE,width: 90, align:'center',dataType:'String', isReadOnly: true,allowMerging: true}, //부서파트
		{binding:'partNm'  ,header: LB_PART_NM,width: 100, align:'center',dataType:'String', isReadOnly: true,allowMerging: true},
		{binding:'locCode',header: LB_LOC_CODE ,width: 90, align:'center',dataType:'String', isReadOnly: true,allowMerging: true},
		{binding:'locNm',header: LB_LOC_NM ,width: 150, align:'center',dataType:'String', isReadOnly: true,allowMerging: true},

		{binding:'shiftWorkNm',header: '근무조', width: 120, align:'center',dataType:'String', isReadOnly: true},
		{binding:'hr1',header: '1HR' ,width: 80, align:'center',dataType:'Number',format:'n0', isReadOnly: true},
		{binding:'hr2',header: '2HR' ,width: 80, align:'center',dataType:'Number',format:'n0', isReadOnly: true},
		{binding:'hr3',header: '3HR' ,width: 80, align:'center',dataType:'Number',format:'n0', isReadOnly: true},
		{binding:'hr4',header: '4HR' ,width: 80, align:'center',dataType:'Number',format:'n0', isReadOnly: true},
		{binding:'hr5',header: '5HR' ,width: 80, align:'center',dataType:'Number',format:'n0', isReadOnly: true},
		{binding:'hr6',header: '6HR' ,width: 80, align:'center',dataType:'Number',format:'n0', isReadOnly: true},
		{binding:'hr7',header: '7HR' ,width: 80, align:'center',dataType:'Number',format:'n0', isReadOnly: true},
		{binding:'hr8',header: '8HR' ,width: 80, align:'center',dataType:'Number',format:'n0', isReadOnly: true},
		{binding:'hr9',header: '9HR' ,width: 80, align:'center',dataType:'Number',format:'n0', isReadOnly: true},
		{binding:'hrTot',header: '합계' ,width: 80, align:'center',dataType:'Number',format:'n0', isReadOnly: true},
		{binding:'mealDiv',header: '식사구분', width: 120, align:'center',dataType:'Number', isReadOnly: true,isReadOnly: true},
		{binding:'rownum',visible:false}
	    
	];	
	
	
	
	//컬럼 초기화
	flexGrid.initialize({
		columns: columnsDefinition,
		//allowMerging: 'ColumnHeaders',
		//allowMerging: 'Cells'
		allowMerging:true
		//, itemsSource: new wijmo.collections.CollectionView(data, {sortDescriptions: ['partCode', 'partNm']})
	});
	
}

	
function gridEvent(){
	//validation
	cv.getError = function(item,prop){	
		switch(prop){			
			
			case "locCode":			
			console.log("item.locCode:"+item.locCode);
				if(item.locCode==null || wijmo.isEmpty(item.locCode) || item.locCode == "" ){					
//					item.locNm = "";
					return "[부서(반)]를 입력 하세요.";
				}else{
					
					var flag = true;
					itemMast.forEach (function (data, index) {			  		
						var code = data.code;
						var name = data.name;	
						
						var trimCode = "";	
						if(code != null) {
							trimCode = code.trim();
						}
						var locCode = item.locCode;
						var trimLocCode = locCode.trim();
						
						if(trimLocCode == trimCode) {						
							item.locNm = name;
							flag = false;
							return false;
						}
					});	
					
					if(flag) {
						item.locCode = "";						
						item.locNm = "";
					}
				}
				return null;
			case "partCode":
				if(item.partCode==null || wijmo.isEmpty(item.partCode) || item.partCode == "" ){
//					item.locNm = "";
					return "[부서(Part)]를 입력 하세요.";
				}else{
					var flag = true;
					itemMast.forEach (function (data, index) {			  		
						var code = data.code;
						var name = data.name;	
						var trimCode = "";	
						if(code != null) {
							trimCode = code.trim();
						}
						var partCode = item.partCode;
						var trimLocCode = partCode.trim();
						if(trimLocCode == trimCode) {
							item.partNm = name;
							flag = false;
							return false;
						}
					});	
					if(flag) {
						item.partCode = "";						
						item.partNm = "";
					}
				}
				return null;				
											
		}
		return null;
	}

}


function clearGrid() {
	getDeptMaster();
	cv.sourceCollection=[];
}

function getToday(){
	var date = new Date();
	return date.getFullYear() + "-" + ("0"+(date.getMonth()+1)).slice(-2) + "-" + ("0"+date.getDate()).slice(-2);
}

function getChangeNumber(data) {
	if(typeof data != "undefined" && data != "" && data != null) {
		return Number(data);
	}else {
		return 0;
	}
}

function ymdFormatter(){
	var num = $("#getOpertDe").val();
     if(!num) return "";
     var formatNum = '';
     // 공백제거
     num=num.replace(/\s/gi, "");
     try{
     	if(num.length == 8) {
        	formatNum = num.replace(/(\d{4})(\d{2})(\d{2})/, '$1-$2-$3');
         }
     } catch(e) {
         $("#getOpertDe").val("");
          console.log(e);
     }
	if(formatNum.length == 10) {
		$("#getOpertDe").val(formatNum);
	}
}

$(document.body).ready(function() {
	var curr = new Date(), firstDay = new Date(curr.setDate(curr.getDate() - curr.getDay())), lastDay = new Date(curr.setDate(curr.getDate() - curr.getDay() + 6));
	
	wijmo.input.InputDate.controlTemplate = '<div style="position:relative" class="wj-template">' +
    '<div class="wj-input">' +
    '<div class="wj-input-group wj-input-btn-visible">' +
    '<input wj-part="input" type="text" class="wj-form-control getOpertDe" name="getOpertDe" id="getOpertDe" onchange ="ymdFormatter();" style="width : 90px;height: 32px;box-sizing: border-box;"/>' +

    '<span wj-part="btn" class="wj-input-group-btn" tabindex="-1">' +
    '<button class="wj-btn wj-btn-default" type="button" tabindex="-1" style="height: 32px;">' +
    '<span class="wj-glyph-calendar"></span>' +
    '</button>' +
    '</span>' +
    '</div>' +
    '</div>' +
    '<div wj-part="dropdown" class="wj-content wj-dropdown-panel" ' +
    'style="display:none;position:absolute;z-index:100">' +
    '</div>' +
    '</div>';

    new wijmo.input.InputDate('#theInputDate', {
        format: 'yyyy-MM-dd',
		valueChanged:function(){
			clearGrid()
		}
    });	

	$.getScript('/js/sal/gridCommon.js').done(function() {
		//calendar(); //캘린더
		commonGrid.init(flexGrid,cv,false); //그리드 공통부분		
		getDeptMaster(); //부서
		gridInit();  	//그리드 초기화
		//gridEvent();	//그리드 이벤트
		handleEvent();	//프로그램 버튼 이벤트
		flexGrid.mergeManager = new wijmo.grid.CustomMergeManager(flexGrid);
		
	});	
});
