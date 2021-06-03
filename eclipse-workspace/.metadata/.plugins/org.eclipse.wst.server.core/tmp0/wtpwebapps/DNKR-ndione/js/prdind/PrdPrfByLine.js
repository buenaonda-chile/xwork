

//--------------------------------------------------------------------------------------------//
// CustomMergeManager class (transpiled from TypeScript)
// 행열에 상관 없이 인접한 동일 데이터에 대해서 셀 병합을 하고자 하시는 경우,
// 해당 클래스를 JS 또는 스트립트 단에서 그대로 복사하셔서 사용 하시면 됩니다.
//--------------------------------------------------------------------------------------------//
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

					if(c<2){ //2열까지만 머징			
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
//# sourceMappingURL=CustomMergeManager.js.map
//--------------------------------------------------------------------------------------------//
// CustomMergeManager class END



// 컬랙션 뷰는 조회후에 그리드의 상태변경을 체크한다. 
//var cv = new wijmo.collections.CollectionView(null);
var cv1 = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수(총투입시간 및 직접생산시간)
//var cv2 = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수(손실제외간접 시간)
//var cv3 = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수(기준시간 및 공수저감지수등등)

//var flexGrid = new wijmo.grid.FlexGrid('#wijmoGrid');	//그리드 전역변수
var flexGrid1 = new wijmo.grid.FlexGrid('#wijmoGrid1');	//그리드 전역변수(총투입시간 및 직접생산시간)
//var flexGrid2 = new wijmo.grid.FlexGrid('#wijmoGrid2');	//그리드 전역변수(손실제외간접 시간)
//var flexGrid3 = new wijmo.grid.FlexGrid('#wijmoGrid3');	//그리드 전역변수(기준시간 및 공수저감지수등등)
var zoomSize = 11;
var baseLgstTime = 0;
var workMast = null;  //빵,쿠폰 마스트
var lineCodeMast = null;

var itemMast = null;
var itemMast0 = null;

var columnsDefinition1=[	
	//{binding:'colNm',header: '항목',width:220 , align:'center',isReadOnly:true},		
	{binding:'seNm',header: LB_ITEM,width:80 , align:'center',isReadOnly:true},
	{binding:'codeNm',header: LB_ITEM,width:120 , align:'center',isReadOnly:true},
	{binding:'totHrMntD01',header: '1',width: 55, align:'center',dataType:'Number', maxLength:4,isReadOnly: true,allowMerging :true},
	{binding:'totHrMntD02',header: '2',width: 55, align:'center',dataType:'Number', maxLength:4,isReadOnly: true,allowMerging :true},
	{binding:'totHrMntD03',header: '3',width: 55, align:'center',dataType:'Number', maxLength:4,isReadOnly: true,allowMerging :true},
	{binding:'totHrMntD04',header: '4',width: 55, align:'center',dataType:'Number', maxLength:4,isReadOnly: true,allowMerging :true},
	{binding:'totHrMntD05',header: '5',width: 55, align:'center',dataType:'Number', maxLength:4,isReadOnly: true,allowMerging :true},
	{binding:'totHrMntD06',header: '6',width: 55, align:'center',dataType:'Number', maxLength:4,isReadOnly: true,allowMerging :true},
	{binding:'totHrMntD07',header: '7',width: 55, align:'center',dataType:'Number', maxLength:4,isReadOnly: true,allowMerging :true},
	{binding:'totHrMntD08',header: '8',width: 55, align:'center',dataType:'Number', maxLength:4,isReadOnly: true,allowMerging :true},
	{binding:'totHrMntD09',header: '9',width: 55, align:'center',dataType:'Number', maxLength:4,isReadOnly: true,allowMerging :true},
	{binding:'totHrMntD10',header: '10',width: 55, align:'center',dataType:'Number', maxLength:4,isReadOnly: true,allowMerging :true},
	{binding:'totHrMntD11',header: '11',width: 55, align:'center',dataType:'Number', maxLength:4,isReadOnly: true,allowMerging :true},
	{binding:'totHrMntD12',header: '12',width: 55, align:'center',dataType:'Number', maxLength:4,isReadOnly: true,allowMerging :true},
	{binding:'totHrMntD13',header: '13',width: 55, align:'center',dataType:'Number', maxLength:4,isReadOnly: true,allowMerging :true},
	{binding:'totHrMntD14',header: '14',width: 55, align:'center',dataType:'Number', maxLength:4,isReadOnly: true,allowMerging :true},
	{binding:'totHrMntD15',header: '15',width: 55, align:'center',dataType:'Number', maxLength:4,isReadOnly: true,allowMerging :true},
	{binding:'totHrMntD16',header: '16',width: 55, align:'center',dataType:'Number', maxLength:4,isReadOnly: true,allowMerging :true},
	{binding:'totHrMntD17',header: '17',width: 55, align:'center',dataType:'Number', maxLength:4,isReadOnly: true,allowMerging :true},
	{binding:'totHrMntD18',header: '18',width: 55, align:'center',dataType:'Number', maxLength:4,isReadOnly: true,allowMerging :true},
	{binding:'totHrMntD19',header: '19',width: 55, align:'center',dataType:'Number', maxLength:4,isReadOnly: true,allowMerging :true},
	{binding:'totHrMntD20',header: '20',width: 55, align:'center',dataType:'Number', maxLength:4,isReadOnly: true,allowMerging :true},
	{binding:'totHrMntD21',header: '21',width: 55, align:'center',dataType:'Number', maxLength:4,isReadOnly: true,allowMerging :true},
	{binding:'totHrMntD22',header: '22',width: 55, align:'center',dataType:'Number', maxLength:4,isReadOnly: true,allowMerging :true},
	{binding:'totHrMntD23',header: '23',width: 55, align:'center',dataType:'Number', maxLength:4,isReadOnly: true,allowMerging :true},
	{binding:'totHrMntD24',header: '24',width: 55, align:'center',dataType:'Number', maxLength:4,isReadOnly: true,allowMerging :true},
	{binding:'totHrMntD25',header: '25',width: 55, align:'center',dataType:'Number', maxLength:4,isReadOnly: true,allowMerging :true},
	{binding:'totHrMntD26',header: '26',width: 55, align:'center',dataType:'Number', maxLength:4,isReadOnly: true,allowMerging :true},
	{binding:'totHrMntD27',header: '27',width: 55, align:'center',dataType:'Number', maxLength:4,isReadOnly: true,allowMerging :true},
	{binding:'totHrMntD28',header: '28',width: 55, align:'center',dataType:'Number', maxLength:4,isReadOnly: true,allowMerging :true},
	{binding:'totHrMntD29',header: '29',width: 55, align:'center',dataType:'Number', maxLength:4,isReadOnly: true,allowMerging :true},
	{binding:'totHrMntD30',header: '30',width: 55, align:'center',dataType:'Number', maxLength:4,isReadOnly: true,allowMerging :true},
	{binding:'totHrMntD31',header: '31',width: 55, align:'center',dataType:'Number', maxLength:4,isReadOnly: true,allowMerging :true},
	{binding:'totSum',header: '합계',width: 55, align:'center',dataType:'Number', maxLength:4,isReadOnly: true,allowMerging :true},
	
	{binding:'clsCode',visible:false},
	{binding:'locCode',visible:false},	
	{binding:'opertDe',visible:false},	
	{binding:'intType',visible:false}
];


/**
 * 팝업창에서 값넘겨받아 부모창에 데이터 set
 * 
 * @param returnValue
 */
function getReturnValue(returnValue) {
	if(returnValue !== null) {
		var custObj = JSON.parse(returnValue);

		$('#getLocId').val(custObj.code);
		$('#getLocNm').val(custObj.name);
	}
}

function lineCodeSearch(){
	if(!$(".getComps").val()){
		return false;
	}
	var url = "/ajaxProdctIndctBaseLine/search.do";	
	var params = {
		'getComps' : $("#getComps").val(),
		'code' : '',
		'name' : ''		
	};
	
	mask.open();
	$.ajax({
		method : "post",
		url : url,
		data :params,
		success : function(res) {
			lineCodeMast = JSON.parse(res).list;
			//console.log("data:================================="+lineCodeMast);
		},
		error : function() {
			console.log("dataset.error");
			return null;
		},
		complete : function() {
			//console.log("lineCodeMast@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+lineCodeMast);
			//cv1.sourceCollection = lineCodeMast;
//			cv1.sourceCollection=[0,0,0,0];
//			flexGrid1.setCellData(0,4,"총투입시간(직접시간+제외간접)");
//			flexGrid1.setCellData(1,4,"직접생산시간(라인내)");
//			flexGrid1.setCellData(2,4,"직접생산시간(라이외 물류)");
//			flexGrid1.setCellData(3,4,"직접생산시간(손실포함)");
			
			
			
			
//			for (var i = 0; i < countries.length; i++) {
//		        data.push({
//		            country: countries[i],
//		            downloads: Math.round(Math.random() * 20000),
//		            sales: Math.random() * 10000,
//		            expenses: Math.random() * 5000
//		        });
//		    }
//
//			var countries=['a1', 'a2', 'a3'];
//			var data=[];			
//	        data.push({
//	            lineCode: countries[0]            
//	   		});
//			//cv1.sourceCollection = data;
//			
//	
//    // grid with no fixed columns and custom scrollable columns
//    //var theSecondGrid = new FlexGrid('#theSecondGrid');
//    flexGrid1.rowHeaders.columns.splice(0, 1); // no extra columns
//    flexGrid1.autoGenerateColumns = false; // custom scrollable columns
//    flexGrid1.itemsSource = data;
//
//    var cols = flexGrid1.columns;
//    cols.push(new Column({ binding: 'lineCode', header: '라인코드' }));
//    
				
			console.log("dataset.completed");
			setTimeout(function() {
				mask.close();				
			}, 500);
				
		}
		
	});
}

/**
 * 팝업창에서 값넘겨받아 부모창에 데이터 set
 * 
 * @param returnValue
 */
/**
function getReturnValue(returnValue) {
	if(returnValue !== null) {
		var custObj = JSON.parse(returnValue);

		$('#getPyvnd').val(custObj.cusno);
		$('#getCusnm').val(custObj.cusnm);
	}
}*/


/**
 * 등록시 오류검증
 */
function validation(item){	
	if(item.clsCode==null || wijmo.isEmpty(item.clsCode) || item.clsCode == ""){
		toastMsg("수정이나 추가한 행의 [사업부]컬럼을 입력해야 됩니다.");
		return false;
	}
	
	if(item.lineCode==null || wijmo.isEmpty(item.lineCode) || item.lineCode ==""){
		toastMsg("수정이나 추가한 행의 [라인코드]컬럼을 입력 하세요");
		return false;
	}

	if(item.prdtNo==null || wijmo.isEmpty(item.prdtNo) || item.prdtNo ==""){
		toastMsg("수정이나 추가한 행의 [제품코드]컬럼을 입력 하세요");
		return false;
	}


	return true;
}


function handleEvent(){
//	$('.getPyvnd').on('change', function() {
//		$(".getCusnm").val("");
//	});

	
	//등록폼 닫기버튼
	$("._closeBtn_").on("click",function(){
		var target = this.getAttribute("data-click-target");
		addBtnUiSet(this);
	});

	//선택버튼
	$('._custBtn_').on('click', function() {
		window.open("/ajaxPrdctIndComBase/initDeptPop.do","deptPop","width=550,height=620,scrollbars=yes,top=100,left=100");
	});
	
}

//년도
function isDateValid(d){
	var re = /[0-9]{4}/;
    return re.test(d);
}


function search(){
	//최상단 합계 초기화
	$("#stTime").val(''); //기준시간(분)
	$("#dirPrTime").val('');   //직접생산시간(분)
	$("#prLowInx").val('');   //공수저감지수			
	$("#exIndDepRatio").val('');   //제외간접부서비율
	$("#prodEfPrice").val('');   //생산성효과금액(원)
	
	//validation 체크기능으로 입력칸에 커서가 활성화 되어있을경우 조회시 오류가 발생함.
	//validation edit 기능을 비활성화 시키고 조회시킴.
	flexGrid1.validateEdits = false;
	//flexGrid2.validateEdits = false;
	//flexGrid3.validateEdits = false;
	
	//validation
	if(!$("#getComps").val()){
		toastMsg(LN_SELECT_COMPS); //E1
		return false;
	}else if(!$("#getLocId").val()){
		//console.log(LN_SELECT_DEPT); //부서반을 선택해주세요.
		toastMsg(LN_SELECT_DEPT);
		return false;
	}else if(!$("#getLineId").val()){
		toastMsg(LN_SELECT_LINE);
		return false;
	}
	
	gridSearch1();  	//최상단 그리드 조회
	//gridSearch2();  	//중간 그리드 조회
	//gridSearch3();  	//하단 그리드 조회
	totCountSearch();
}


function totCountSearch(){

	//상반기 하반기
	var fsHalf ="";
	var tYear = "";
	if($("#getDumcb").val().substring(5,7)<10&&$("#getDumcb").val().substring(5,7)>3){
		tYear=	$("#getDumcb").val().substring(0,4);		
		fsHalf ="F"; //상반기 4월부터 9월까지
	}else{
		if($("#getDumcb").val().substring(5,7)<4){ //1~3월은 하반기이지만 한해 빼줘야 함(4~8월 상반기, 9~3월 하반기)
		console.log($("#getDumcb").val().substring(0,4)); //부서반을 선택해주세요.
		tYear=	$("#getDumcb").val().substring(0,4)-1;
		console.log(String(tYear)); 
		}
		
		fsHalf ="S"; //하반기
	}
	
	var url = "/ajaxPrdPrfByLine/totCountSearch.do";	
	var params = {
		'getComps' : $("#getComps").val()
		,'getLocId' : $("#getLocId").val()
		,'getRepym' : $(".getDumcb").val().replace(/-/gi, "")
		,'getYear' : String(tYear)
		,'getFsHalf' : fsHalf
		,'getLineId' : $("#getLineId").val()
	};
	
	mask.open();
	$.ajax({
		method : "post",
		url : url,
		data :params,
		success : function(res) {
			//var data = JSON.parse(res).list;
			//var resHalfWRate = JSON.parse(res).baseLgstTime;	
			var resStTime = JSON.parse(res).stTimeTot;	
			var resDirPrTime = JSON.parse(res).hrMntTot;				
			var resPrLowInx = JSON.parse(res).ptmTot;							
			var resExIndDepRatio = JSON.parse(res).hrMntDeTot;							
			var resProdEfPrice = JSON.parse(res).prodEfPrice;
						
			//$("#halfWRate").val(resHalfWRate);   //반임율								
			$("#stTime").val(resStTime); //기준시간(분)
			$("#dirPrTime").val(resDirPrTime);   //직접생산시간(분)
			$("#prLowInx").val(resPrLowInx);   //공수저감지수			
			$("#exIndDepRatio").val(resExIndDepRatio);   //제외간접부서비율
			$("#prodEfPrice").val(resProdEfPrice);   //생산성효과금액(원)

			//cv.sourceCollection = data;
			//setRowReadOnly();
			
			//flexGrid1.columnFooters.setCellData(0, 3, lgsDstRtSum);

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

function gridSearch1(){
	
	//컬럼 초기화
	flexGrid1.initialize({
		columns: columnsDefinition1,
		allowMerging : 'Cells'
	});
	
	flexGrid1.allowSorting = false;
	//
	
	//상반기 하반기
	var fsHalf ="";
	var tYear = "";
	if($("#getDumcb").val().substring(5,7)<10&&$("#getDumcb").val().substring(5,7)>3){		
		tYear=	$("#getDumcb").val().substring(0,4);
		fsHalf ="F"; //상반기 4월부터 9월까지
	}else{
		if($("#getDumcb").val().substring(5,7)<4){ //1~3월은 하반기이지만 한해 빼줘야 함(4~8월 상반기, 9~3월 하반기)
		//console.log($("#getDumcb").val().substring(0,4)); //부서반을 선택해주세요.
		tYear=	$("#getDumcb").val().substring(0,4)-1	;
		//console.log(tYear); 
		}
		fsHalf ="S"; //하반기
	}
	
	var url = "/ajaxPrdPrfByLine/searchBytotHrMnt.do";	
	var params = {
		'getComps' : $("#getComps").val(),
		'getRepym' : $(".getDumcb").val().replace(/-/gi, ""),
		'getYear' : String(tYear),
		'getFsHalf' : fsHalf, 
		//'getYear' : $("#getYear").val(),
		'getLocId' : $("#getLocId").val(),
		'getLineId' : $("#getLineId").val()								
	};
	
	mask.open();
	$.ajax({
		method : "post",
		url : url,
		data :params,
		success : function(res) {
			var data = JSON.parse(res).list;
			
			cv1.sourceCollection = data;

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

function gridSearch2(){
	
	//그리드 초기화
	var gridColumns = new Array();
	var url = "/ajaxLosExcIndTm/searchLine.do";
	var params = {
		'getComps' : $("#getComps").val(),
		'getLocId' : $("#getLocId").val()
	};
	var columnsDefinition2 = new Array();

	var jObject1 = new Object();
	jObject1.binding = 'clsCode';
	jObject1.visible = false;
	columnsDefinition2.push(jObject1);

	var jObject2 = new Object();
	jObject2.binding = 'locCode';
	jObject2.visible = false;
	columnsDefinition2.push(jObject2);

	var jObject3 = new Object();
	jObject3.binding = 'lineCode';
	jObject3.visible = false;
	columnsDefinition2.push(jObject3);

	var jObject4 = new Object();
	jObject4.binding = 'se';
	jObject4.visible = false;
	columnsDefinition2.push(jObject4);

	var jObject5 = new Object();
	jObject5.binding = 'seNm';
	jObject5.align = 'center';
	//jObject5.header = '작업구분';
	jObject5.dataType = 'String';
	jObject5.width = 120;
	jObject5.visible = true;
	jObject5.isReadOnly = true;
	jObject5.allowMerging = true;
	columnsDefinition2.push(jObject5);

	var jObject6 = new Object();
	jObject6.binding = 'codeNm';
	//jObject6.header = '코드명';
	jObject6.width = 100;
	jObject6.align = 'center';
	jObject6.isReadOnly = true;
	jObject6.visible = true;
	columnsDefinition2.push(jObject6);


	var inputNumber = new wijmo.input.InputNumber(document.createElement('div'),{
		format:'n0'
	});
	//inputNumber.inputElement.maxLength = 10;
	
	//$("#getLocId").val('4707');
	//console.log("getLocId:::::::::::::"+$("#getLocId").val());

//두전째 그리드 헤더 감추기
 //flexGrid2.columnHeaders.rows.defaultSize = 0;

	
	// 부서(반)의 검색값이 존재할 경우에만 라인을 표시한다. 처음 로드될때는 부서(반)값이 없어서 해당구문 타지 않음
	if ($("#getLocId").val() != "") {
		$.ajax({
			method : "post",
			url : url,
			data : params,
			async : true,
			success : function(res) {

				if (res != 'null') {
					var data = JSON.parse(res).lineList;

					if (data.length > 0) {
						//헤더(코드명)오른쪽부분의 헤더명 셋팅
						for (var i = 1; i < 10; i++) {
							var jObject = new Object();
							jObject.binding = "hrMntD0" + i;
							jObject.header = "D0" + i;
							//jObject.width = 120;
							jObject.align = 'center';
							jObject.dataType = 'Number';
							//jObject.editor = inputNumber;
							jObject.width = '*';
							jObject.isRequired = false;
							columnsDefinition2.push(jObject);
						}
						for (var i = 10; i < 32; i++) {
							var jObject = new Object();
							jObject.binding = "hrMntD" + i;
							jObject.header = "D" + i;
							//jObject.width = 120;
							jObject.align = 'center';
							jObject.dataType = 'Number';
							//jObject.editor = inputNumber;
							jObject.width = '*';
							jObject.isRequired = false;
							columnsDefinition2.push(jObject);
						}
					} else {
						var jObject = new Object();
						//jObject.header = '해당 검색에 대한 라인이 없습니다.';
						jObject.align = 'center';
						jObject.width = '*';
						columnsDefinition2.push(jObject);
					}
					flexGrid2.initialize({
						columns : columnsDefinition2,
						allowMerging : 'Cells'
					});
					//flexGrid2.columnHeaders.rows.defaultSize = 40; // 열 헤더 영역에
																	// 행의 높이 설정
				}
				setTimeout(function() {
					mask.close();
				}, 500);
			},
			error : function(e) {
				setTimeout(function() {
					mask.close();
				}, 500);
			},
			complete : function() {

			}
		});
	} else {
		var jObjectInit = new Object();
		//jObjectInit.header = '부서(반) 선택시 라인이 표시됩니다.';
		jObjectInit.align = 'center';
		jObjectInit.width = '*';
		columnsDefinition2.push(jObjectInit);

		flexGrid2.initialize({
			columns : columnsDefinition2,
			allowMerging : 'Cells'
		});
		flexGrid2.columnHeaders.rows.defaultSize = 40;
		mask.close();
	}
	
	//왼쪽 손실제외코드네임 불러오기
	var url = "/ajaxPrdPrfByLine/losExcIndNmSearch.do";
	var opertDe = $("#opertDe").val();
	var params = {
		'getComps' : $("#getComps option:selected").val(),
		'getLocId' : $("#getLocId").val(),
		'getOpertDe' : opertDe
	};

	mask.open();
	$.ajax({
		method : "post",
		url : url,
		data : params,
		success : function(res) {
//console.log("res:::::::::::::"+res);
			var data = JSON.parse(res).list;
			cv2.sourceCollection = data;

		},
		error : function(e) {
			console.log("dataset.error : " + e);
			setTimeout(function() {
				mask.close();
			}, 500);
		},
		complete : function() {
			// console.log("dataset.completed");
			
			if (!$("#getComps").val()) {
				toastMsg(LN_SELECT_COMPS);
				return false;
			} else if (!$("#getLocId").val()) {
				toastMsg(LN_SELECT_DEPT); //부서반선택
				return false;
			} else if (!$("#getDumcb").val()) {
				toastMsg("작업월을 입력해주세요.");
				return false;
			}
			
			//상반기 하반기
			var fsHalf ="";
			var tYear = "";
			if($("#getDumcb").val().substring(5,7)<10&&$("#getDumcb").val().substring(5,7)>3){		
				tYear=	$("#getDumcb").val().substring(0,4);
				fsHalf ="F"; //상반기 4월부터 9월까지
			}else{
				if($("#getDumcb").val().substring(5,7)<4){ //1~3월은 하반기이지만 한해 빼줘야 함(4~8월 상반기, 9~3월 하반기)
				//console.log($("#getDumcb").val().substring(0,4)); //부서반을 선택해주세요.
				tYear=	$("#getDumcb").val().substring(0,4)-1	;
				//console.log(tYear); 
				}
				fsHalf ="S"; //하반기
			}
	
			var url = "/ajaxPrdPrfByLine/searchByHrMnt.do";
			var opertDe = $("#opertDe").val();
			var params = {
				'getComps' : $("#getComps").val(),
				'getRepym' : $(".getDumcb").val().replace(/-/gi, ""),
				'getYear' : String(tYear),
				'getFsHalf' : fsHalf, 
				//'getYear' : $("#getYear").val(),
				'getLocId' : $("#getLocId").val(),
				'getLineId' : $("#getLineId").val()				
			};
		
			mask.open();
			$.ajax({
				method : "post",
				url : url,
				data : params,
				success : function(res) {		
					var data = JSON.parse(res).list2;					
					cv2.sourceCollection = data;		
				},
				error : function(e) {
					console.log("dataset.error : " + e);
					setTimeout(function() {
						mask.close();
					}, 500);
				},
				complete : function() {
					// console.log("dataset.completed");
					setTimeout(function() {
						mask.close();
					}, 500);
		
				}
			});
			
			
			setTimeout(function() {
				mask.close();
			}, 500);

		}
	});
	
	
}

function gridSearch3(){
	//컬럼 초기화
	flexGrid3.initialize({
		columns: columnsDefinition3
	});
	
	//상반기 하반기
	var fsHalf ="";
	var tYear = "";
	if($("#getDumcb").val().substring(5,7)<10&&$("#getDumcb").val().substring(5,7)>3){
		tYear=	$("#getDumcb").val().substring(0,4);
		fsHalf ="F"; //상반기 4월부터 9월까지
	}else{
		if($("#getDumcb").val().substring(5,7)<4){ //1~3월은 하반기이지만 한해 빼줘야 함(4~8월 상반기, 9~3월 하반기)
		//console.log($("#getDumcb").val().substring(0,4)); //부서반을 선택해주세요.
		tYear=	$("#getDumcb").val().substring(0,4)-1	;
		//console.log(tYear); 
		}
		fsHalf ="S"; //하반기
	}
	
	var url = "/ajaxPrdPrfByLine/searchBySt.do";	
	var params = {
		'getComps' : $("#getComps").val(),
		'getRepym' : $(".getDumcb").val().replace(/-/gi, ""),
		'getYear' : String(tYear),
		'getFsHalf' : fsHalf, 
		//'getYear' : $("#getYear").val(),
		'getLocId' : $("#getLocId").val(),
		'getLineId' : $("#getLineId").val()								
	};
	
	mask.open();
	$.ajax({
		method : "post",
		url : url,
		data :params,
		success : function(res) {
			
			var data = JSON.parse(res).list;
						
			cv3.sourceCollection = data;
			
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


function getToday(){
	var date = new Date();
	return date.getFullYear() + "-" + ("0"+(date.getMonth()+1)).slice(-2) + "-" + ("0"+date.getDate()).slice(-2);
}

/**
 * 엑셀 다운로드
 */
function downloadExcel(){
	
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
	
	
}

/**
	그리드 row height 자동크기조절
 */
function autoSizeRowsAsync(grid, rowIndex) {
    if (rowIndex != null) {
      grid.rows[rowIndex].height = null;
    } else {
      grid.rows.forEach(function(row) {
        row.height = null;
      });
    }
    setTimeout(function() {
      grid.onScrollPositionChanged();
    })
}

function gridInit1(){
	
	//컬럼 초기화
	flexGrid1.initialize({
		columns: columnsDefinition1
	});	
	
	flexGrid1.columnHeaders.rows.defaultSize = 55; 	// 열 헤더 영역에 행의 높이 설정
	
	/*var countries = '총투입시간(직접시간+제외간접),직접생산시간(라인내),직접생산시간(라이외 물류),직접생산시간(손실포함)'.split(',');
	var data = [];
    
    for (var i = 0; i < countries.length; i++) {
        data.push({
            colNm: countries[i],
        });
    }*/
    //flexGrid1.itemsSource = data;
	//cv1.sourceCollection = data;
	//flexGrid1.autoGenerateColumns = false;
	//cv1.autoGenerateColumns = false;
	
}

function gridInit2(){

	var gridColumns = new Array();
	var url = "/ajaxLosExcIndTm/searchLine.do";
	var params = {
		'getComps' : $("#getComps").val(),
		'getLocId' : $("#getLocId").val()
	};
	var columnsDefinition2 = new Array();

	var jObject1 = new Object();
	jObject1.binding = 'clsCode';
	jObject1.visible = false;
	columnsDefinition2.push(jObject1);

	var jObject2 = new Object();
	jObject2.binding = 'locCode';
	jObject2.visible = false;
	columnsDefinition2.push(jObject2);

	var jObject3 = new Object();
	jObject3.binding = 'lineCode';
	jObject3.visible = false;
	columnsDefinition2.push(jObject3);

	var jObject4 = new Object();
	jObject4.binding = 'se';
	jObject4.visible = false;
	columnsDefinition2.push(jObject4);

	var jObject5 = new Object();
	jObject5.binding = 'seNm';
	jObject5.align = 'center';
	//jObject5.header = '작업구분';
	jObject5.dataType = 'String';
	jObject5.width = 120;
	jObject5.visible = true;
	jObject5.isReadOnly = true;
	jObject5.allowMerging = true;
	columnsDefinition2.push(jObject5);

	var jObject6 = new Object();
	jObject6.binding = 'codeNm';
	//jObject6.header = '코드명';
	jObject6.width = 100;
	jObject6.align = 'center';
	jObject6.isReadOnly = true;
	jObject6.visible = true;
	columnsDefinition2.push(jObject6);

	var inputNumber = new wijmo.input.InputNumber(document.createElement('div'),{
		format:'n0'
	});
	//inputNumber.inputElement.maxLength = 10;
	
	//$("#getLocId").val('4707');
	console.log("getLocId:::::::::::::"+$("#getLocId").val());

//두전째 그리드 헤더 감추기
 //flexGrid2.columnHeaders.rows.defaultSize = 0;

	
	// 부서(반)의 검색값이 존재할 경우에만 라인을 표시한다. 처음 로드될때는 부서(반)값이 없어서 해당구문 타지 않음
	if ($("#getLocId").val() != "") {
		$.ajax({
			method : "post",
			url : url,
			data : params,
			async : true,
			success : function(res) {

				if (res != 'null') {
					var data = JSON.parse(res).lineList;

					if (data.length > 0) {
						//헤더(코드명)오른쪽부분의 헤더명 셋팅
						for (var i = 1; i < 10; i++) {
							var jObject = new Object();
							jObject.binding = "hrMntD0" + i;
							jObject.header = "D0" + i;
							//jObject.width = 120;
							jObject.align = 'center';
							jObject.dataType = 'Number';
							//jObject.editor = inputNumber;
							jObject.width = '*';
							jObject.isRequired = false;
							columnsDefinition2.push(jObject);
						}
						for (var i = 10; i < 32; i++) {
							var jObject = new Object();
							jObject.binding = "hrMntD" + i;
							jObject.header = "D" + i;
							//jObject.width = 120;
							jObject.align = 'center';
							jObject.dataType = 'Number';
							//jObject.editor = inputNumber;
							jObject.width = '*';
							jObject.isRequired = false;
							columnsDefinition2.push(jObject);
						}
					} else {
						var jObject = new Object();
						//jObject.header = '해당 검색에 대한 라인이 없습니다.';
						jObject.align = 'center';
						jObject.width = '*';
						columnsDefinition2.push(jObject);
					}
					flexGrid2.initialize({
						columns : columnsDefinition2,
						allowMerging : 'Cells'
					});
					//flexGrid2.columnHeaders.rows.defaultSize = 40; // 열 헤더 영역에
																	// 행의 높이 설정
				}
				setTimeout(function() {
					mask.close();
				}, 500);
			},
			error : function(e) {
				setTimeout(function() {
					mask.close();
				}, 500);
			},
			complete : function() {

			}
		});
	} else {
		var jObjectInit = new Object();
		//jObjectInit.header = '부서(반) 선택시 라인이 표시됩니다.';
		jObjectInit.align = 'center';
		jObjectInit.width = '*';
		columnsDefinition2.push(jObjectInit);

		flexGrid2.initialize({
			columns : columnsDefinition2,
			allowMerging : 'Cells'
		});
		flexGrid2.columnHeaders.rows.defaultSize = 40;
		mask.close();
	}
	
	
	
	//왼쪽 손실제외코드네임 불러오기
	var url = "/ajaxPrdPrfByLine/losExcIndNmSearch.do";
	var opertDe = $("#opertDe").val();
	var params = {
		'getComps' : $("#getComps option:selected").val(),
		'getLocId' : $("#getLocId").val(),
		'getOpertDe' : opertDe
	};
//console.log("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX:::::::::::::");
	mask.open();
	$.ajax({
		method : "post",
		url : url,
		data : params,
		success : function(res) {
//console.log("res:::::::::::::"+res);
			var data = JSON.parse(res).list;
			cv2.sourceCollection = data;

		},
		error : function(e) {
			console.log("dataset.error : " + e);
			setTimeout(function() {
				mask.close();
			}, 500);
		},
		complete : function() {
			// console.log("dataset.completed");
			setTimeout(function() {
				mask.close();
			}, 500);

		}
	});
	
}

function gridInit3(){
	//컬럼 초기화
	flexGrid3.initialize({
		columns: columnsDefinition3
	});	
	
	var countries = '기준시간(분),공수저감지수(직접생산시간/기준시간*100),설총율,생산 실적수(업무종료기준)(대),총대당투입공수,직접대당투입공수,UPH(대)'.split(',');
	var data = [];
    
    for (var i = 0; i < countries.length; i++) {
        data.push({
            colNm: countries[i],
        });
    }
    //flexGrid1.itemsSource = data;
	cv3.sourceCollection = data;
	
}

function gridInit(){

//	var comsBase = new DataMap(coms_base, 'id', 'name');
	var columnsDefinition=[
		{binding:'rownum',visible:false},	
		{binding:'clsCode',visible:false},
		//{binding:'partCode',header: ''+ LB_CODE,width: '*', align:'center',dataType:'String', maxLength:4}, //부서파트
		{binding:'partCode',header: '부서(파트)',width: '*', align:'center',dataType:'String', maxLength:4}, //부서파트
		{binding:'partNm'  ,header: '파트명',width: '*', align:'center',dataType:'String', maxLength:50,isReadOnly: true},
		{binding:'locCode' ,header: '부서(반)',width: '*', align:'center',dataType:'String', maxLength:4},
		{binding:'locNm'   ,header: '반명',width: '*', align:'center',dataType:'String', maxLength:50,isReadOnly: true},
		
		{binding:'sickLeaveTot'   ,header: '병가',width: '*', align:'center',dataType:'String', maxLength:50,isReadOnly: true},
		{binding:'bHrMnt'   ,header: '제외',width: '*', align:'center',dataType:'String', maxLength:50,isReadOnly: true},
				
		{binding:'oldLineCode',visible:false},		
		{binding:'oldPrdtNo',visible:false},
		{binding:'year',visible:false},
		{binding:'fsHalf',visible:false},
		{binding:'oldYear',visible:false},
		{binding:'oldFsHalf',visible:false}									
	];	
	//컬럼 초기화
	flexGrid.initialize({
		columns: columnsDefinition
	});
	flexGrid.columnHeaders.rows.defaultSize = 60; 	// 열 헤더 영역에 행의 높이 설정
}

function isCodeValid(d){
	var re = /^[A-Za-z0-9-+]*$/;
    return re.test(d);
}

function gridEvent(){
	
	cv1.getError = function(item,prop){
		switch(prop){
			case "lineCode":
				if(item.lineCode==null || wijmo.isEmpty(item.lineCode) || item.lineCode == "" ){
					return "[라인코드]를 입력 하세요.";
				}else{
					var flag = isCodeValid(item.lineCode);
					if(!flag) {
						item.lineCode = "";
						item.lineNm = "";
					}
				}
				return null;
			case "prdtNo":
				if(item.prdtNo==null || wijmo.isEmpty(item.prdtNo) || item.prdtNo == "" ){
					return "[제품코드]를 입력 하세요.";
				}		
				return null;
		}
		return null;
	}

	/**
	 * 수정할경우 rownum 넣어주는 이벤트
	 * 기존에 cellEditEnded 이벤트에 넣어주니 같은값으로 변경될때도 rownum이 들어가는 오류와 
  	 * 수정을 안하고 input박스만 생성되는 경우도 rownum이 찍히는 버그가 발생하여 cellEditEnding 이벤트로 변경함. 
	 */
	flexGrid1.cellEditEnding.addHandler(function(s,e){
		var oldVal = s.getCellData(e.row,e.col);
		if(typeof s.activeEditor != "undefined" && s.activeEditor != "" && s.activeEditor != null){		
			var newVal = s.activeEditor.value;
	
			if(oldVal!=newVal){
				if(e.col == 6 || e.col == 7 || e.col == 8 || e.col == 9 || e.col == 10 || e.col == 15 ) {
					s.setCellData(e.row,e.col,newVal,true);
					//calFunction(s, e);
				}
				s.setCellData(e.row,"rownum",e.row,true);
			}
		}
	});
	
	flexGrid1.cellEditEnded.addHandler(function(s,e){
		var value = s.getCellData(e.row,e.col,false);
		if(s.columns[e.col].dataType==wijmo.DataType.String){
			value = value.trim();
		}

		//라인코드
		if(e.col == 2) {
			var flag = true;
			if(value==null || wijmo.isEmpty(value) || value == "" ){
				
			}else{
				var flag = true;
				lineCodeMast.forEach (function (data, index) {		
					var code = data.lineCode;	  		
					var trimCode = code.trim();
					var itemCode = value.trim();
					if(itemCode == trimCode) {
						var name = data.lineNm;
						s.setCellData(e.row,e.col+1,name); //라인명
//						item.prdtNm = data.name;
						flag = false;
						return false;
					}
				});	
				if(flag) {
					s.setCellData(e.row,e.col,""); //라인코드
					s.setCellData(e.row,e.col+1,""); //라인명
				}
			}
		}
		
		//제품코드1
		if(e.col == 4) {
			var flag = true;
			if(value==null || wijmo.isEmpty(value) || value == "" ){
				
			}else{
				var flag = true;
				itemMast.forEach (function (data, index) {			  		
					var code = data.code;
					var trimCode = code.trim();
					var itemCode = value.trim();
					if(itemCode == trimCode) {
						var name = data.name;
						s.setCellData(e.row,e.col+1,name); //제품명
//						item.prdtNm = data.name;
						flag = false;
						return false;
					}
				});	
				if(flag) {
					s.setCellData(e.row,e.col,""); //제품명					
					s.setCellData(e.row,e.col+1,""); //제품명
				}
			}
		}
		
//		if(s.columns[e.col].dataType==wijmo.DataType.String){
//			s.setCellData(e.row,e.col,value.toUpperCase());
//		}
		
	});
}

function getYear(){
	var date = new Date();
	return date.getFullYear();
}

function calFunction(s, e){
	var cycleTime = s.getCellData(e.row,6,false);
	var drctHdcn = s.getCellData(e.row,7,false);	
	var indrHdcn = s.getCellData(e.row,8,false);	
	var jmLabor = s.getCellData(e.row,9,false);	
	var prfrTime = s.getCellData(e.row,10,false);		
	var excIndRt = s.getCellData(e.row,15,false);	
	
	var mrgFct = Number(prfrTime)/Number(jmLabor); //여유계수(계산)	
	var stdrLabor = Number(jmLabor)*mrgFct; //정미공수(계산)	
	var sgmRgsArb = stdrLabor/(1-Number(excIndRt));  //시그마등록공수(S)(계산)
	var uph = 3600 / Number(cycleTime);	//uph
	
	s.setCellData(e.row,11,mrgFct); //여유계수(계산)	
	s.setCellData(e.row,12,stdrLabor); //정미공수(계산)	
	s.setCellData(e.row,16,sgmRgsArb); //시그마등록공수(S)(계산)	
	s.setCellData(e.row,17,uph); //uph	
	
}

function initSetMaster(){
	lineCodeSearch(); //라인코드
	getItemMaster(); //제품Master정보 취득
	clearGrid();
}

function clearGrid() {
	cv.sourceCollection=[];
}

/**
 * 부서코드로 업체명 검색하여 데이터 set
 * 
 * @param 업체코드
 */
function getDeptSch(gubn, value,s,e) {
	if(value != ""){
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


$(document.body).ready(function() {
	function init1(){
		commonGrid.init(flexGrid1,cv1); //그리드 공통부분	
		gridInit1();  	//그리드 초기화
		
		gridEvent();	//그리드 이벤트
		handleEvent();	//프로그램 버튼 이벤트
		
		//lineCodeSearch(); //라인코드정보 취득
	}
	
/*	function init2(){
		commonGrid.init(flexGrid2,cv2); //그리드 공통부분	
		gridInit2();  	//그리드 초기화
	}
	function init3(){
		commonGrid.init(flexGrid3,cv3); //그리드 공통부분	
		gridInit3();  	//그리드 초기화
	}
	*/

	$.getScript('/js/sal/gridCommon.js').done(function() {
		calendar(); //캘린더
		init1();
		flexGrid1.mergeManager = new wijmo.grid.CustomMergeManager(flexGrid1);
		//init2();
		//init3();
		/*var nowDate = getToday();
		$("#opertDe").val(nowDate);*/

	});		
	
});
