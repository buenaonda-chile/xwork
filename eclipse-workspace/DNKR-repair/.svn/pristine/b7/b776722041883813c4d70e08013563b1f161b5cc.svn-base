//code intellisense typescript 정의
///<reference path = "../../wijmo/controls/wijmo.d.ts"/>	
///<reference path = "../../wijmo/controls/wijmo.grid.d.ts"/>
///<reference path = "../../wijmo/controls/wijmo.grid.detail.d.ts"/>
///<reference path = "../../wijmo/controls/wijmo.grid.sheet.d.ts"/>
///<reference path = "../../wijmo/controls/wijmo.input.d.ts"/>

/// <reference path ="../../wijmo/controls/wijmo.chart.d.ts"/>
/// <reference path ="../../wijmo/controls/wijmo.pdf.d.ts"/>
/// <reference path ="../../wijmo/controls/wijmo.nav.d.ts"/>


// 컬랙션 뷰는 조회후에 그리드의 상태변경을 체크한다. 
var cv = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수 그리드의 수정,추가,삭제 되는 부분을 감지한다.

var flexGrid = new wijmo.grid.FlexGrid('#wijmoGrid');	//그리드 전역변수

var zoomSize = 11;	//확대축소 기본 사이즈

/**
	버튼 이벤트
 */
var handleEvent = function(){
	
	$("#btn_search").on("click",search);
	
}

//조회
var search = function(){
	
	var url = '/itemPopUp/search';
	
	var params = {
		"partNo" : $("#partNo").val(),
		"itemNm" : $("#itemNm").val(),
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
			cv.sourceCollection = data;
						
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
  그리드 초기화
 */
var gridInit = function() {

 	
	/**
	 *	grid 셋팅
	 *	gridCommon.js 에서 공통으로 처리되있는 옵션을 변경하고 싶다면 gridInit 함수에서 바꾸고싶은 옵션만 재정의 하면됨.
	 */     
	
	//콤보박스 정의
	//var statusMap = new wijmo.grid.DataMap(comboStatus.itemsSource, 'codeCd', 'codeNm'); //진행상태 콤보박스 (조회부분에서 가져온 데이터를 그대로 사용함.)

	//컬럼정의
	columnsDefinition = [
		{binding:'id',visible:false},
	    {binding:'chk',visible:false},
	    {binding: 'partNo', header: '품번', width: '*', align:'center',dataType:'String',isReadOnly:true},  
        {binding: 'itemNm', header: '품목명', width: '*', align:'center',dataType:'String',isReadOnly:true}, //wordWrap: true: 텍스트 자동줄바꿈 autorowHeights랑 같이 사용
        {binding: 'unit', header: '단위', width: '*', align:'center',dataType:'String',isReadOnly:true},
        {binding: 'standard', header: '규격', width: '*', align:'center',dataType:'String',isReadOnly:true},   
        {binding: 'material', header: '재질', width: '*', align:'center',dataType:'String',isReadOnly:true},
        // 콤보박스 추가하려면 dataMap
    ];

	//컬럼 초기화
	flexGrid.initialize({
		columns: columnsDefinition
	});

}

$(document.body).ready(function() {
	
	//그리드 공통js 호출 후에 나머지 함수 호출함.
	$.when(
		$.getScript('/js/wijmo/commonGrid.js'),
		$.getScript('/js/wijmo/commonInput.js')
	).done(function() {
	
		handleEvent();	//프로그램 버튼 이벤트
		
		commonGrid.init(flexGrid,cv); //그리드 공통부분
		gridInit();  	//그리드 초기화
		
		search();		//조회
	});
	
			
	flexGrid.hostElement.addEventListener('dblclick',function(e){
		var value = 'part';
		var ht = flexGrid.hitTest(e);  //더블클릭한 행의 정보를 가지고있음.
		var returnValue = {
          partNo: flexGrid.getCellData(ht.row,'partNo'),
          itemNm: flexGrid.getCellData(ht.row,'itemNm')
        };
		opener.getReturnValue(JSON.stringify(returnValue),value);
		window.close();
		});
});

