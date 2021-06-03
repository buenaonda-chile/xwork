//code intellisense typescript 정의
///<reference path = "../../wijmo/controls/wijmo.d.ts"/>	
///<reference path = "../../wijmo/controls/wijmo.grid.d.ts"/>
///<reference path = "../../wijmo/controls/wijmo.input.d.ts"/>

// 컬랙션 뷰는 조회후에 그리드의 상태변경을 체크한다. 
var cv = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수

var flexGrid = new wijmo.grid.FlexGrid('#wijmoGrid');	//그리드 전역변수
var itemMast = null;
var itemMast0 = null;
var tabNum = 0;
var zoomSize = 11;

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

					//if(c<2 || r<1){ //2열까지만 머징	
					//if(c<4){ //2열까지만 머징			
					if(c<5){ //2열까지만 머징		
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
					if(c>12){ //공백 머징
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

/**
 * 팝업창에서 값넘겨받아 부모창에 데이터 set
 * 
 * @param returnValue
 */
function getReturnValue(returnValue) {
	if(returnValue !== null) {
		clearGrid();
		var custObj = JSON.parse(returnValue);

		$('#getLocId').val(custObj.code);
		$('#getLocNm').val(custObj.name);
		mesSts();
		
	}
}


function handleEvent(){
	//등록폼 닫기버튼
	$("._closeBtn_").on("click",function(){
		var target = this.getAttribute("data-click-target");
		addBtnUiSet(this);
	});

	$('._custBtn_').on('click', function() {
		window.open("/ajaxPrdctIndComBase/initDeptPop.do","deptPop","width=550,height=620,scrollbars=yes,top=100,left=100");
	});
	
}

//년도
function isDateValid(d){
	var re = /[0-9]{4}/;
    return re.test(d);
}


function mainSearch() {
   if(tabNum == 0) {
		search();
   }else if(tabNum == 1) {
		search2();
   }else if(tabNum == 2) {
		search4();
   }else if(tabNum == 3) {
		search3();
   }else if(tabNum == 4) {
		search5();
   }else if(tabNum == 5) {
		search7();
   }
//	else if(tabNum == 6) {
//		search7();
//	}else if(tabNum == 7) {
//		search8();
//	}
	
}

function search(){
	//validation 체크기능으로 입력칸에 커서가 활성화 되어있을경우 조회시 오류가 발생함.
	//validation edit 기능을 비활성화 시키고 조회시킴.
	flexGrid.validateEdits = false;
	if(!$("#getComps").val()){
		toastMsg(LN_SELECT_COMPS);
		return false;
	}
//	else if(!$("#getLocId").val()){
//		toastMsg(LN_SELECT_DEPT);
//		return false;
//	}	
	
	var url = "/ajaxPrdPrfByItmNmb/search.do";	
	var params = {
		'getComps' : $("#getComps").val(),
		'getRepym' : $(".getDumcb").val().replace(/-/gi, ""),
		
		//'getYear' : $("#getYear").val(),
		'getLocId' : $("#getLocId").val()				
	};
	mask.open();
	$.ajax({
		method : "post",
		url : url,
		data :params,
		success : function(res) {
			var data = JSON.parse(res).list;
			cv.sourceCollection = data;
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


//수정
function update(){
}

function getToday(){
	var date = new Date();
	return date.getFullYear() + "-" + ("0"+(date.getMonth()+1)).slice(-2) + "-" + ("0"+date.getDate()).slice(-2);
}

/**
 * 엑셀 다운로드
 */
function downloadExcelTop(){
	
	if (tabNum == 0) {
		var fileName = "품번별생산성실적_"+getToday()+".xlsx";
	
		wijmo.grid.xlsx.FlexGridXlsxConverter.saveAsync(flexGrid, 
			{includeColumnHeaders: true},
		    fileName,
		    function (base64) {
				// user can access the base64 string in this callback.
				document.getElementById('importFile').href = 'data:application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;' + 'base64,' + base64;
				//console.log(base64);
			}, 
			function (reason) {
				//User can catch the failure reason in this callback.
				console.log('The reason of save failure is ' + reason);
		  	}
		);
	} else if(tabNum == 1) {
		downloadExcel2();
	} else if(tabNum == 2) {
		downloadExcel4();
	} else if(tabNum == 3) {
		downloadExcel3();
	} else if(tabNum == 4) {
		downloadExcel5();
	} else if(tabNum == 5) {
		downloadExcel7();
	} 
	
	
	
	
//	else if(tabNum == 6) {
//		downloadExcel7();
//	} else if(tabNum == 7) {
//		downloadExcel8();
//	}	 
	
}

function gridInit(){
//	var comsBase = new DataMap(coms_base, 'id', 'name');
	var columnsDefinition=[
		{binding:'rownum',visible:false},	
		{binding:'clsCode',visible:false},		
		{binding:'locCode',header: '부서(반)',width: 100, align:'center',dataType:'String', maxLength:4,isReadOnly: true, allowMerging: true},
		{binding:'lineCode',header: '* '+ LB_LINE_CODE,width: 100, align:'center',dataType:'String', maxLength:4,isReadOnly: true, allowMerging :true},
		{binding:'lineNm',header: '* '+ LB_LINE_NM, width: 100, align:'left',dataType:'String', maxLength:50,isReadOnly: true, allowMerging: true},
		{binding:'prdtNo',header: '* '+ LB_ITEM_CODE, width: 140, align:'center',dataType:'String', maxLength:50,isReadOnly: true},		
		{binding:'prdtNm',header: '* '+ LB_ITEM_NM, width: 250, align:'left',dataType:'String', maxLength:50,isReadOnly: true},				
		{binding:'cycleTime',header: '* '+ LB_CYCLE_TIME, width: 100, align:'right',dataType:'Number', format: 'n2', maxLength:4,isReadOnly: true},	//C/T(sec)								
		{binding:'jmLabor',header: '* '+ LB_JM_LABOR, width: 100, align:'right',dataType:'Number', format: 'n2', maxLength:4,isReadOnly: true},		//정미공수											
		{binding:'stdrLabor',header: '* '+ LB_STDR_LABOR, width: 100, align:'right',dataType:'Number', format: 'n2', maxLength:10,isReadOnly: true},	//생산성기준공수(sec)=정미공수×여유계수															
		{binding:'resultManHour',header: '* '+ LB_RESULT_MAN_HOUR, width: 100, align:'right',dataType:'Number', format: 'n2', maxLength:8,isReadOnly: true},
		{binding:'totalQY',header: '* '+ LB_TOTAL_QY, width: 100, align:'right',dataType:'Number', format: 'n0', maxLength:8,isReadOnly: true},	
		{binding:'jmBaseTime',header: '* '+ LB_JM_BASE_TIME, width: 100, align:'right',dataType:'Number', format: 'n2', maxLength:8,isReadOnly: true},	
		{binding:'nmlMnHrStndrdTm',header: '* '+ LB_NML_MNHR_STNDRD_TM, width: 100, align:'right',dataType:'Number', format: 'n2', maxLength:8,isReadOnly: true},	
		{binding:'prdctnInptTm',header: '* '+ LB_PRDCTN_INPUT_TM, width: 100, align:'right',dataType:'Number', format: 'n0', maxLength:8,isReadOnly: true},			
		{binding:'indexPlan',header: '* '+ LB_INDEX_PLAN, width: 100, align:'right',dataType:'Number', format: 'n2', maxLength:8,isReadOnly: true},	
		{binding:'indexResult',header: '* '+ LB_INDEX_RESULT, width: 100, align:'right',dataType:'Number', format: 'n2', maxLength:8,isReadOnly: true},
		{binding:'prodIndex',header: '* '+ LB_PROD_INDEX, width: 100, align:'right',dataType:'Number', format: 'n2', maxLength:8,isReadOnly: true},			
		{binding:'oldLineCode',visible:false},		
		{binding:'oldPrdtNo',visible:false},
		{binding:'year',visible:false},
		{binding:'fsHalf',visible:false},
		{binding:'oldYear',visible:false},
		{binding:'oldFsHalf',visible:false}									
	];	
	//컬럼 초기화
	flexGrid.initialize({
		columns: columnsDefinition,
		allowMerging: 'Cells' 
	});
	flexGrid.allowSorting = false;	
	flexGrid.columnHeaders.rows.defaultSize = 60; 	// 열 헤더 영역에 행의 높이 설정
}

function isCodeValid(d){
	var re = /^[A-Za-z0-9-+]*$/;
    return re.test(d);
}

function gridEvent(){
}

function getYear(){
	var date = new Date();
	return date.getFullYear();
}

function initSetMaster(){
	clearGrid();
}

function clearGrid() {
	cv.sourceCollection=[];
	cv2.sourceCollection=[];
	cv3.sourceCollection=[];
	cv4.sourceCollection=[];
	cv5.sourceCollection=[];
	cv7.sourceCollection=[];
//	cv6.sourceCollection=[];
//	cv8.sourceCollection=[];	

	$('#mesBt').css('visibility','hidden');
	$('#mesSpan').css('visibility','hidden');	
}

function clearComps() {
	$("#getLocId").val("");
	clearGrid();
}

/**
 * 부서코드로 업체명 검색하여 데이터 set
 * 
 * @param 업체코드
 */
function getDeptSch(gubn, value,s,e) {
	if(value != ""){
		clearGrid();
		$.ajax({
			method : "post",
			url : "/ajaxPrdctIndComBase/searchDeptMaster.do",
			data : {
				"getCode" : value,
				"getComps" : $("#getComps").val()
			},
			success : function(res) {
				var data = JSON.parse(res);			
				
				if (data.list.length > 0) {
					if(gubn == "input") $('#getLocNm').val(data.list[0].name);
					mesSts();
				}
				else {
					toastMsg(LN_IO_CHK1 + " : " + value);
					if(gubn == "input") {
						$('#getLocCode').val("");
					}
					if(gubn == "grid"){
						var oldValue = s.getCellData(e.row,5,false);
						if(oldValue == "" || oldValue == null || oldValue == undefined) oldValue = "0"; // dataType:'Number' 에는 공백 초기화가 안됨.
						s.setCellData(e.row,e.col,oldValue);
					} 
				}
			},
			error : function() {
				//console.log("dataset.error");
			},
			completed : function() {
				//console.log("dataset.completed");
			}
		});
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

//MES 생산실적 가져오기
function mesSave() {
	mask.open();		
	setTimeout(function() {
		mesInfoSave();
	}, 500);
}

//MES 생산실적 가져오기
function mesInfoSave() {
	if(!$("#getComps").val()){
		toastMsg(LN_SELECT_COMPS);
		mask.close();	
		return false;
	}else if(!$("#getLocId").val()){
		toastMsg(LN_SELECT_DEPT);
		mask.close();	
		return false;
	}else if(!$("#getDumcb").val()){
		toastMsg("년월 입력해주세요.");
		mask.close();	
		return false;
	}		
	
	var stateMsg=RESULT_OK;	
	var paramsData = {
		'getComps' : $("#getComps").val()
		,'getLocId' : $("#getLocId").val()
		,'getOpertDe' : $("#getDumcb").val()			
	};

	$.ajax({
		method : "post",
		url : "/ajaxPrdPrfrmRgs/SaveMesInsert.do",
		data : paramsData,
		async: false,
		success : function(xhr) {
        	var data = JSON.parse(xhr);
			if (data.result != RESULT_OK) {
				if(data.errMsg == "LN_INS_CHK1") stateMsg = LN_INS_CHK1;
				if(data.errMsg == "LN_INS_CHK2") stateMsg = LN_INS_CHK2;
			}
        },
        error : function() {
			toastMsg("error");
			mask.close();	
		},
		complete : function() {
			mask.close();			
		}
	});
	if(stateMsg == RESULT_OK){
		toastMsg(RESULT_OK);
    }else{
    	toastMsg(stateMsg);
    }
}

function mesSts(){
	if(!$("#getComps").val()){
		return false;
	}else if(!$("#getLocId").val()){
		return false;
	}	
	
	var url = "/ajaxPrdPrfByItmNmb/searchCountMes.do";	
	var params = {
		'getComps' : $("#getComps").val(),
		'getLocId' : $("#getLocId").val()				
	};
	$.ajax({
		method : "post",
		url : url,
		data :params,
		success : function(res) {
			var data = JSON.parse(res);
			var count = Number(data.count);
			if(count > 0) {
				$('#mesBt').css('visibility','visible');
				$('#mesSpan').css('visibility','visible');				

			}else{
				$('#mesBt').css('visibility','hidden');
				$('#mesSpan').css('visibility','hidden');				
			}
		},
		error : function() {
			console.log("dataset.error");
		},
		complete : function() {
		}
	});	
	
}



$(document.body).ready(function() {
	$.getScript('/js/sal/gridCommon.js').done(function() {
		commonGrid.init(flexGrid,cv,false); //그리드 공통부분		
		commonGrid.init(flexGrid2,cv2,false); 
		commonGrid.init(flexGrid4,cv4,false);
		commonGrid.init(flexGrid3,cv3,false); 
		commonGrid.init(flexGrid5,cv5,false);
		commonGrid.init(flexGrid7,cv7,false);
//		commonGrid.init(flexGrid6,cv6,false);
//		commonGrid.init(flexGrid8,cv8,false);
		
		gridInit();  	//그리드 초기화
		gridInit2();
		gridInit4();
		gridInit3();
		gridInit5();
		gridInit7();
//		gridInit6();
//		gridInit8();
		gridEvent();	//그리드 이벤트
		handleEvent();	//프로그램 버튼 이벤트
		calendar(); //캘린더
   		flexGrid.mergeManager = new wijmo.grid.CustomMergeManager(flexGrid);
		var tab = new wijmo.nav.TabPanel("#theTabPanel");
   			tab.selectedIndexChanged.addHandler(function(t,e){
			tabNum = t.selectedIndex;

			$('#tab0').css('display','none');
			$('#tab1').css('display','none');		
			$('#tab2').css('display','none');								
			$('#tab3').css('display','none');		
			$('#tab4').css('display','none');								
			$('#tab5').css('display','none');
//			$('#tab6').css('display','none');		
//			$('#tab7').css('display','none');								

			var idNm = "#tab"+tabNum;
			$(idNm).css('display','block');	
		   if(tabNum == 0) {
				search();
		   }else if(tabNum == 1) {
				search2();
		   }else if(tabNum == 2) {
				search4();
		   }else if(tabNum == 3) {
				search3();
		   }else if(tabNum == 4) {
				search5();
		   }else if(tabNum == 5) {
				search7();
		   }
//			else if(tabNum == 6) {
//				search7();
//		   } else if(tabNum == 7) {
//				search8();
//		   }			
   	   });
	});	
});
