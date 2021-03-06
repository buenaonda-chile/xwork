//code intellisense typescript 정의
///<reference path = "../../wijmo/controls/wijmo.d.ts"/>	
///<reference path = "../../wijmo/controls/wijmo.grid.d.ts"/>
///<reference path = "../../wijmo/controls/wijmo.grid.detail.d.ts"/>
///<reference path = "../../wijmo/controls/wijmo.grid.sheet.d.ts"/>
///<reference path = "../../wijmo/controls/wijmo.input.d.ts"/>
///<reference path = "../../wijmo/controls/wijmo.grid.cellmaker.d.ts"/>

/// <reference path ="../../wijmo/controls/wijmo.chart.d.ts"/>
/// <reference path ="../../wijmo/controls/wijmo.pdf.d.ts"/>
/// <reference path ="../../wijmo/controls/wijmo.nav.d.ts"/>


// 컬랙션 뷰는 조회후에 그리드의 상태변경을 체크한다. 
var cv = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수 그리드의 수정,추가,삭제 되는 부분을 감지한다.

var flexGrid = new wijmo.grid.FlexGrid('#wijmoGrid');	//그리드 전역변수

var comboStatus = new wijmo.input.ComboBox("#status");	//접수진행상태

var sdat = new wijmo.input.InputDate("#searchRecDtFr");	//접수일자 시작
		
var edat = new wijmo.input.InputDate("#searchRecDtTo");	//접수일자 종료

var dat = new wijmo.input.InputDate(document.createElement('div')); //접수일자

var zoomSize = 11;	//확대축소 기본 사이즈


/**
	버튼 이벤트
 */
var handleEvent = function(){
	
	$("#btn_search").on("click",search);
	
	//저장
	$("#btn_save").on("click",save);

}


/**
	저장
	추가/수정/삭제 한번에 처리함.
 */
var save = function(){
	
	//익스플로러에서 포커스가 그리드 밖으로 빠졌을경우 flexGrid.rows.length 를 받아오지 못하는 버그 존재하여 포커스를 그리드에 강제로 두게함.
	flexGrid.focus ();
	flexGrid.select( new wijmo.grid.CellRange( 0 , 0 , 0 , 0 ), true );

	//수정행 저장
	for ( var i = 0; i <cv.itemsEdited.length; i ++) {
		console.debug("edit:");
		console.debug(cv.itemsEdited[i]);
		
		ajaxCommit("/receiptCDBrkPartAdmiss/update",cv.itemsEdited[i]);
	}
	
	
	_dicasPage.maskClose();
	
	//조회
	search();	
}

//등록,수정,삭제
var ajaxCommit = function(url,item){	
	
	$.ajax({
		method : "post",
		url : url,
		data : item,
		async: false,
		beforeSend:function(){
			
		},
		success : function(res) {
			
	    	var data = res.result;
			//console.debug(data);
        	 
	    },
        error : function() {
			console.log("등록 오류:"+url);
		},
		complete : function() {
			
		}
	});	
}


//조회
var search = function(){
	
	var url = '/receiptCDBrkPartAdmiss/search';
	
	var params = {
		"searchRecDtFr" : wijmo.Globalize.format(sdat.value,'yyyy-MM-dd'),
		"searchRecDtTo" : wijmo.Globalize.format(edat.value,'yyyy-MM-dd'),
		"status" : comboStatus.selectedValue,
		"rectNo" : $("#rectNo").val(),
		"partNo" : $("#partNo").val(),
		"custNm" : $("#custNm").val(),
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
	var statusMap = new wijmo.grid.DataMap(comboStatus.itemsSource, 'codeCd', 'codeNm'); //진행상태 콤보박스 (조회부분에서 가져온 데이터를 그대로 사용함.)
	
	//셀버튼 정의
	var cellMaker = wijmo.grid.cellmaker.CellMaker;
	
	//컬럼정의
	columnsDefinition = [
		{binding:'id',visible:false},
	    {binding:'chk',visible:false},
	    {binding: 'rectNo', header: '접수번호', width: '*', align:'center',dataType:'Number',isReadOnly:true},  
        {binding: 'rectDt', header: '접수일자', width: '*', align:'center',dataType:'String',editor: dat,isReadOnly:true}, //wordWrap: true: 텍스트 자동줄바꿈 autorowHeights랑 같이 사용
        {binding: 'partNo', header: '고품번호', width: '*', align:'center',dataType:'String',isReadOnly:true},
		{binding: 'partNm', header: '고품명', width: '*', align:'center',dataType:'String',isReadOnly:true},
        {binding: 'custNm', header: '접수처', width: '*', align:'center',dataType:'String',isReadOnly:true},
		{binding: 'custId', header: '접수처아이디', width: '*', align:'center',dataType:'Number',visible:false},
        {binding: 'custEmpNm', header: '접수처담당자', width: '*', align:'center',dataType:'String',isReadOnly:true},
        {binding: 'status', header: '진행상태', width: '*', dataMap:statusMap, align:'center',dataType:'String'},
 		{binding: 'admissStatus', header: '승인상태', width: '*',align:'center',dataType:'String',visible:false},
        {binding: 'remark', header: '비고', width: '*', align:'center',dataType:'String', maxLength:50,isReadOnly:true},
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
var statusInit = function(){
	
	comboStatus.displayMemberPath = "codeNm";
	comboStatus.selectedValuePath = "codeCd";
	
	var statusList= new wijmo.collections.ObservableArray([{codeNm:"전체",codeCd:""}]);
	var url = '/code/list2.json/RECEIPT_STATUS';
	
	$.ajax({
		method : "post",
		url : url,
		//data:params,
		async:false,
		dataType :"json",
		success : function(res) {
			
			$.each(res.data,function(index,item){
				statusList.push(item);
			});
			
			comboStatus.itemsSource =statusList;
			
		},
		error : function() {
			console.log("dataset.error");
			
		},
		complete : function() {
			
		}
	});
	
}

/**
	접수일자 초기화
 */
var srcDatInit = function(){
	
	sdat.isRequired = false;
	sdat.value = null;		//주석처리할경우 오늘날짜 자동으로 박힘.
	sdat.placeholder = "접수일자";
	sdat.format = "yyyy-MM-dd";
	commonInput.calendarInit(sdat);
	
	edat.isRequired = false;
	edat.value = null;
	edat.placeholder = "접수일자";
	edat.format = "yyyy-MM-dd";
	commonInput.calendarInit(edat);
	
	dat.isRequired = true;
	dat.value = null;
	dat.format = "yyyy-MM-dd";
	commonInput.calendarInit(dat);
}

var getFormatDate = function(date){
	
	var year =  date.getFullYear();
	var month = (1 + date.getMonth());
	month = month >= 10 ? month : '0' + month;
	var day = date.getDate();
	day = day >=10 ? day : '0' + day;
	var id = '000000';
	if(id<99999) id++;
	return year+'-'+month+'-'+day;
	
}

/**
	진행상태 변경시 승인상태 처리
 */
var gridEvent = function(){
	var checkValue;
	flexGrid.cellEditEnded.addHandler(function (s, e) {
	checkValue = s.getCellData(e.row,e.col);
	console.log("cellEditEnding row: " + checkValue);
	if(checkValue == 'R2'){ 
		flexGrid.setCellData(e.row, 10, 'A2', true);
	}else{
		flexGrid.setCellData(e.row, 10, 'A1', true);
	}
	})	
	
}
	

$(document.body).ready(function() {
	
	//그리드 공통js 호출 후에 나머지 함수 호출함.
	$.when(
		$.getScript('/js/wijmo/commonGrid.js'),
		$.getScript('/js/wijmo/commonInput.js')
	).done(function() {
		
		statusInit();	//진행상태 콤보박스 초기화
		srcDatInit();	//접수일자 초기화
		handleEvent();	//프로그램 버튼 이벤트
		
		commonGrid.init(flexGrid,cv); //그리드 공통부분
		gridInit();  	//그리드 초기화
		gridEvent();
		
		search();		//조회
	});
	
	
	
});
