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
					if(c < 4 || panel.cellType == wijmo.grid.CellType.ColumnHeader){ 		
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
	
	//상반기 하반기
	var fsHalf ="";
	var tYear = "";
	var tMonth = "";
	var pMonth = "";
	var stlaYear = "";
	
	tMonth = String($("#getDumcb").val().substring(5,7));
	
	if($("#getDumcb").val().substring(5,7)<2){ //1월인경우 년도 1빼주고 12월로 셋팅
		pMonth = String($("#getDumcb").val().substring(0,4)-1)+"12";
	}else if($("#getDumcb").val().substring(5,7)>10){
		pMonth = String($("#getDumcb").val().substring(0,4)) + String($("#getDumcb").val().substring(5,7)-1);
	}else{
		pMonth = String($("#getDumcb").val().substring(0,4)) + "0" + String($("#getDumcb").val().substring(5,7)-1);
	}
	
	if($("#getDumcb").val().substring(5,7)<10&&$("#getDumcb").val().substring(5,7)>3){		
		stlaYear=	$("#getDumcb").val().substring(0,4);
		fsHalf ="F"; //상반기 4월부터 9월까지
	}else{
		if($("#getDumcb").val().substring(5,7)<4){ //1~3월은 하반기이지만 한해 빼줘야 함(4~8월 상반기, 9~3월 하반기)
//		console.log($("#getDumcb").val().substring(0,4)); //부서반을 선택해주세요.
		stlaYear=	$("#getDumcb").val().substring(0,4)-1	;
//		console.log(tYear); 
		}
		fsHalf ="S"; //하반기
	}
	
	var url = "/ajaxPrdPrfByLoc/search.do";	
	var params = {
		'getComps' : $("#getComps").val(),
		'getPart' : $("#getPartId").val(),
		'getRepym' : $(".getDumcb").val().replace(/-/gi, ""),
		'getTMonth' : String(tMonth),
		'getPMonth' : String(pMonth),
		'getStlaYear' : String(stlaYear), //공수관리에 들어갈 년도
		'getYear' : $("#getDumcb").val().substring(0,4), //생산성지수년계획에 들어갈 년도		
		'getFsHalf' : fsHalf 
		//'getYear' : $("#getYear").val(),
		//'getLocId' : $("#getLocId").val(),
		//'getLineId' : $("#getLineId").val()
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
	var fileName = "라인코드마스타_"+getToday()+".xlsx";
	transExcel(flexGrid,fileName);
}


function gridInit(){
	
	var columnsDefinition=[
					
		{binding:'partCode',header: '파트',width: 50, align:'center',dataType:'String', isReadOnly: true,allowMerging: true}, //부서파트
		{binding:'partNm'  ,header: '파트명',width: 100, align:'center',dataType:'String', isReadOnly: true,allowMerging: true},
		{binding:'locCode',header: LB_LOC_CODE ,width: 50, align:'center',dataType:'String', isReadOnly: true,allowMerging: true},
		{binding:'locNm',header: LB_LOC_NM ,width: 150, align:'center',dataType:'String', isReadOnly: true,allowMerging: true},

		{binding:'reCnt',header: LB_RE_CNT ,width: 80, align:'center',dataType:'Number',format:'n2', isReadOnly: true}, //여유계수
		{binding:'frRa',header: LB_FR_RA ,width: 80, align:'center',dataType:'Number',format:'n2', isReadOnly: true},
		{binding:'stTiYct',header: LB_ST_TI_YCT ,width: 80, align:'center',dataType:'Number',format:'n2', isReadOnly: true},
		{binding:'stTiPr',header: LB_ST_TI_PR ,width: 80, align:'center',dataType:'Number',format:'n2', isReadOnly: true},
		{binding:'obTi',header: LB_OB_TI ,width: 80, align:'center',dataType:'Number',format:'n2', isReadOnly: true},
		{binding:'hrMntDe',header: LB_HR_MNT_DE ,width: 80, align:'center',dataType:'Number',format:'n2', isReadOnly: true},
		
		{binding:'prIn',header: LB_PR_IND ,width: 80, align:'center',dataType:'Number',format:'n2', isReadOnly: true},
			
		{binding:"pmonPrf",header: LB_PMON_PRF ,width: 80, align:'center',dataType:'Number',format:'n2', isReadOnly: true},
    	{binding:"wsReIn",header: LB_WS_RE_IN ,width: 80, align:'center',dataType:'Number',format:'n2', isReadOnly: true},
		{binding:"prfInd",header: LB_PRF_IND ,width: 80, align:'center',dataType:'Number',format:'n2', isReadOnly: true},
		{binding:"stLaAchRa",header: LB_ACH_RA ,width: 80, align:'center',dataType:'Number',format:'n2', isReadOnly: true},
		{binding:"undTi",header: LB_UND_TI ,width: 80, align:'center',dataType:'Number',format:'n2', isReadOnly: true},
		
    	{binding:"prdObEffAmo",header:LB_PRD_OB_EFF_AMO ,width: 80, align:'center',dataType:'Number',format:'n2', isReadOnly: true},
    	{binding:"prdEffAmo",header:LB_PRD_EFF_AMO ,width: 80, align:'center',dataType:'Number',format:'n2', isReadOnly: true},
		{binding:"prdAchRa",header:LB_ACH_RA ,width: 80, align:'center',dataType:'Number',format:'n2', isReadOnly: true},
		{binding:"undAmo",header:LB_UND_AMO ,width: 80, align:'center',dataType:'Number',format:'n2', isReadOnly: true},
						
    	{binding:"totHrMnt",header:LB_TOT_HR_MNT ,width: 80, align:'center',dataType:'Number',format:'n2', isReadOnly: true},
    	{binding:"exTiOb",header:LB_EX_TI_OB ,width: 80, align:'center',dataType:'Number',format:'n2', isReadOnly: true},
		{binding:"exTiPrf",header:LB_EX_TI_PRF ,width: 80, align:'center',dataType:'Number',format:'n2', isReadOnly: true},
		{binding:"exUseRa",header:LB_EX_USE_RA ,width: 80, align:'center',dataType:'Number',format:'n2', isReadOnly: true},
		{binding:"indTiOb",header:LB_IND_TI_OB ,width: 80, align:'center',dataType:'Number',format:'n2', isReadOnly: true},
		{binding:"indTiPrf",header:LB_IND_TI_PRF ,width: 80, align:'center',dataType:'Number',format:'n2', isReadOnly: true},
		{binding:"indUseRa",header:LB_IND_USE_RA ,width: 80, align:'center',dataType:'Number',format:'n2', isReadOnly: true},
		{binding:"exIndTiOb",header:LB_EX_IND_TI_OB ,width: 80, align:'center',dataType:'Number',format:'n2', isReadOnly: true},
		{binding:"exIndTiPrf",header:LB_EX_IND_TI_PRF ,width: 80, align:'center',dataType:'Number',format:'n2', isReadOnly: true},
		{binding:"exIndUseRa",header:LB_EX_IND_USE_RA ,width: 80, align:'center',dataType:'Number',format:'n2', isReadOnly: true}
	    
	];	
	
	
	
	//컬럼 초기화
	flexGrid.initialize({
		columns: columnsDefinition,
		//allowMerging: 'ColumnHeaders',
		//allowMerging: 'Cells'
		allowMerging:true
		//, itemsSource: new wijmo.collections.CollectionView(data, {sortDescriptions: ['partCode', 'partNm']})
	});
	
	flexGrid.allowSorting = false;
	flexGrid.columnHeaders.rows.defaultSize = 60;
	
	
	var headerRow = new wijmo.grid.Row();
	headerRow.allowMerging = true;
	
	var panel = flexGrid.columnHeaders;
	panel.rows.splice(0,0,headerRow);
	
	for(var ii=0;ii<4;ii++){
		panel.setCellData(0,ii,LB_GROUP);
	}
	
	for(var ii=4;ii<10;ii++){
		panel.setCellData(0,ii,LB_BA_UNI);
	}
	panel.setCellData(0,10,LB_PR_IND);
	
	for(var ii=11;ii<16;ii++){
		panel.setCellData(0,ii,LB_ST_LA);
	}
	
	for(var ii=16;ii<20;ii++){
		panel.setCellData(0,ii,LB_EFF_AMO);
	}
	
	for(var ii=20;ii<30;ii++){
		panel.setCellData(0,ii,LB_EX_IND_TI);
	}
	

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

function clearGrid() {
	cv.sourceCollection=[];
}

$(document.body).ready(function() {
	$.getScript('/js/sal/gridCommon.js').done(function() {
		calendar(); //캘린더
		commonGrid.init(flexGrid,cv,false); //그리드 공통부분		
		getDeptMaster(); //부서
		gridInit();  	//그리드 초기화
		//gridEvent();	//그리드 이벤트
		handleEvent();	//프로그램 버튼 이벤트
		flexGrid.mergeManager = new wijmo.grid.CustomMergeManager(flexGrid);
		
	});	
});
