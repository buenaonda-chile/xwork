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

var comboCustDiv = new wijmo.input.ComboBox("#custDiv");	//업체구분

var zoomSize = 11;	//확대축소 기본 사이즈


/**
	버튼 이벤트
 */
var handleEvent = function(){
	
	$("#btn_search").on("click",search);
	
}

//조회
var search = function(){
	
	var url = '/customerPopUp/search';
	
	var params = {
		"custNm" : $("#custNm").val(),
		"custCd" : $("#custCd").val(),
		"custDiv" : comboCustDiv.selectedValue,
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
	var custDivMap = new wijmo.grid.DataMap(comboCustDiv.itemsSource, 'codeCd', 'codeNm'); //진행상태 콤보박스 (조회부분에서 가져온 데이터를 그대로 사용함.)

	//컬럼정의
	columnsDefinition = [
		{binding:'id',visible:false},
	    {binding:'chk',visible:false},
	    {binding: 'custDiv', header: '업체구분', width: '*', dataMap:custDivMap, align:'center',dataType:'String',isReadOnly:true},  
		{binding: 'custId', header: '업체아이디', width: '*', align:'center',dataType:'String',isReadOnly:true,visible:false},
        {binding: 'custCd', header: '업체코드', width: '*', align:'center',dataType:'String',isReadOnly:true}, //wordWrap: true: 텍스트 자동줄바꿈 autorowHeights랑 같이 사용
        {binding: 'custNm', header: '업체명', width: '*', align:'center',dataType:'String',isReadOnly:true},
        {binding: 'custTel', header: '전화번호', width: '*', align:'center',dataType:'String',isReadOnly:true},   
        {binding: 'fax', header: '팩스번호', width: '*', align:'center',dataType:'String',isReadOnly:true},
		{binding: 'address', header: '주소', width: '*', align:'center',dataType:'String',isReadOnly:true},
        // 콤보박스 추가하려면 dataMap
    ];

	//컬럼 초기화
	flexGrid.initialize({
		columns: columnsDefinition
	});
	
}

/**
	콤보박스 초기화
 */
var custDivInit = function(){
	
	comboCustDiv.displayMemberPath = "codeNm";
	comboCustDiv.selectedValuePath = "codeCd";
	
	var custList= new wijmo.collections.ObservableArray([{codeNm:"전체",codeCd:""}]);
	var url = '/code/list2.json/EDUCATION';
	
	$.ajax({
		method : "post",
		url : url,
		//data:params,
		async:false,
		dataType :"json",
		success : function(res) {
			
			$.each(res.data,function(index,item){
				custList.push(item);
			});
			
			comboCustDiv.itemsSource =custList;
			
		},
		error : function() {
			console.log("dataset.error");
			
		},
		complete : function() {
			
		}
	});
	
}
/*
$(document.body).ready(function() {
	
	//그리드 공통js 호출 후에 나머지 함수 호출함.
	$.when(
		$.getScript('/js/wijmo/commonGrid.js'),
		$.getScript('/js/wijmo/commonInput.js')
	).done(function() {
	
		handleEvent();	//프로그램 버튼 이벤트
		custDivInit(); //콤보박스초기화
		
		commonGrid.init(flexGrid,cv); //그리드 공통부분
		gridInit();  	//그리드 초기화
		
		search();		//조회
	});
	
	flexGrid.hostElement.addEventListener('dblclick',function(e){
		var value = 'customer';
		var ht = flexGrid.hitTest(e);  //더블클릭한 행의 정보를 가지고있음.
		var returnValue = {
          custNm: flexGrid.getCellData(ht.row,'custNm'),
     	  custCd: flexGrid.getCellData(ht.row,'custCd')
        };
		alert('박준호' + returnValue.custNm);
		opener.getReturnValue(JSON.stringify(returnValue),value);
		alert('바바바' + returnValue.custNm);
		window.close();
		});
});*/

$(document.body).ready(function() {
	
	//그리드 공통js 호출 후에 나머지 함수 호출함.
	$.when(
		$.getScript('/js/wijmo/commonGrid.js'),
		$.getScript('/js/wijmo/commonInput.js')
	).done(function() {
	
		handleEvent();	//프로그램 버튼 이벤트
		custDivInit();
		
		commonGrid.init(flexGrid,cv); //그리드 공통부분
		gridInit();  	//그리드 초기화
		
		
		search();		//조회
	});
	
			
	flexGrid.hostElement.addEventListener('dblclick',function(e){
		var value = 'customer';
		var ht = flexGrid.hitTest(e);  //더블클릭한 행의 정보를 가지고있음.
		var returnValue = {
          custNm: flexGrid.getCellData(ht.row,'custNm'),
		  custId: flexGrid.getCellData(ht.row,'custId'),
        };
		opener.getReturnValue(JSON.stringify(returnValue),value);
		window.close();
		});
});
