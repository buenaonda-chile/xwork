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

var sdat = new wijmo.input.InputDate("#searchDisDtFr");	//접수일자 시작
		
var edat = new wijmo.input.InputDate("#searchDisDtTo");	//접수일자 종료

var dat = new wijmo.input.InputDate(document.createElement('div')); //폐기일자

var zoomSize = 11;	//확대축소 기본 사이즈

// 유저이름 ajax로 받아오기
var userName = -1;
var userId = -1;

// 고품번호 로우 선택 인덱스(index)
var partNo = -1;
var custId = -1;

/**
	버튼 이벤트
 */
var handleEvent = function(){
	
	$("#btn_search").on("click",search);
	
	//행 추가버튼
	$("#btn_add").on("click", function() {
		var addRow = cv.addNew();
		var date = new Date();
		addRow.disDt = getFormatDate(date);
		addRow.custEmpNm = userName;
		addRow.custEmpId = userId;
		cv.commitNew();
		flexGrid.select(new wijmo.grid.CellRange(flexGrid.rows.length+1,2), true);  //셀선택 추가된행으로 선택되게
	});
	
	// 행삭제
	$("#btn_remove").on("click", function() {
			cv.remove(cv.currentItem);	
	});
	
	//저장
	$("#btn_save").on("click",save);

}

/**
 * 팝업창에서 값넘겨받아 부모창에 데이터 set
 * 
 * @param returnValue
 */
	var getReturnValue = function (returnValue,value) {
	retObj = JSON.parse(returnValue);
	if(value=='part'){
			flexGrid.setCellData(partNo, 'partNo', retObj.partNo, true);
			flexGrid.setCellData(partNo, 'partNm', retObj.itemNm, true);
		}else if(value=='customer'){
			flexGrid.setCellData(custId, 'custNm', retObj.custNm, true);
			flexGrid.setCellData(custId, 'custId', retObj.custId, true);
		}
	}


//validation
var validation = function(item){
				
	if (item.disDt == null || wijmo.isEmpty(item.disDt) || item.disDt == "") {
		alert("[폐기일자를 입력 해주세요.]");
		return false;
	}
			
			
	if (item.partNo == null || wijmo.isEmpty(item.partNo) || item.partNo == "") {
		alert("[품목번호를 입력 해주세요.]");
		return false;
	}
	
	if (item.partNm == null || wijmo.isEmpty(item.partNm) || item.partNm == "") {
		alert("[품목명을 입력 해주세요.]");
		return false;
	}
	
	if (item.custNm == null || wijmo.isEmpty(item.custNm) || item.custNm == "") {
		alert("[페기처를 입력 해주세요.]");
		return false;
	}
	
	if (item.qty == null || wijmo.isEmpty(item.qty) || item.qty == "") {
		alert("[수량를 입력 해주세요.]");
		return false;
	}
	
	return true;				
			
}

/**
	저장
	추가/수정/삭제 한번에 처리함.
 */
var save = function(){
	
	//익스플로러에서 포커스가 그리드 밖으로 빠졌을경우 flexGrid.rows.length 를 받아오지 못하는 버그 존재하여 포커스를 그리드에 강제로 두게함.
	flexGrid.focus ();
	flexGrid.select( new wijmo.grid.CellRange( 0 , 0 , 0 , 0 ), true );
	
	if(flexGrid.rows.length < 1 && cv.itemsRemoved.length == 0){
		alert("등록할 내용이 없습니다.");
		return;
	} 
	
	//그리드 이벤트에 cv.getError 사용하여 자체 validation을 사용했지만 붉은색 칸이 있는상태(미입력상태)로 저장버튼을 눌렀을경우가 있기때문에
	// 따로 한번더 validation 체크를 한다.
	
	// 추가행과 수정행만 validation	
	for ( var i = 0; i <cv.itemsAdded.length; i ++) {
		if(!validation(cv.itemsAdded[i])){
			return false;
		}	
	}

	for ( var i = 0; i <cv.itemsEdited.length; i ++) {
		if(!validation(cv.itemsEdited[i])){
			return false;
		}	
	}
	
	_dicasPage.maskOpen();
	
	//추가행 저장
	for ( var i = 0; i <cv.itemsAdded.length; i ++) {
		console.debug("add:");
		console.debug(cv.itemsAdded[i]);
		
		ajaxCommit("/receiptCDRepairPart/create",cv.itemsAdded[i]);
		
	}
	
	//수정행 저장
	for ( var i = 0; i <cv.itemsEdited.length; i ++) {
		console.debug("edit:");
		console.debug(cv.itemsEdited[i]);
		
		ajaxCommit("/receiptCDRepairPart/update",cv.itemsEdited[i]);
	}
	
	//삭제행 저장
	for ( var i = 0; i <cv.itemsRemoved.length; i ++) {
		console.debug("del:");
		console.debug(cv.itemsRemoved[i]);
		ajaxCommit("/receiptCDRepairPart/delete",cv.itemsRemoved[i]);
		
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
	
	var url = '/receiptCDRepairPart/search';
	
	var params = {
		"searchDisDtFr" : wijmo.Globalize.format(sdat.value,'yyyy-MM-dd'),
		"searchDisDtTo" : wijmo.Globalize.format(edat.value,'yyyy-MM-dd'),
		"partNo" : $("#partNo").val(),
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
			var user = res.loginVO;
			userName = user.fstNm;
			userId = user.uniqId;
						
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
	
		
	//셀버튼 정의
	var cellMaker = wijmo.grid.cellmaker.CellMaker;
	
	//컬럼정의
	columnsDefinition = [
		{binding:'id',visible:false},
	    {binding:'chk',visible:false},  
        {binding: 'disDt', header: '폐기일자', width: '*', align:'center',dataType:'String',maxLength:12}, //wordWrap: true: 텍스트 자동줄바꿈 autorowHeights랑 같이 사용
        {binding: 'partNo', header: '폐기품번호', width: '*', align:'center',dataType:'String',isReadOnly:true},
		{binding: 'partNm', header: '폐기품명', width: '*', align:'center',dataType:'String',isReadOnly:true},
		{header: '', width: 40, align:'center',
					cellTemplate: cellMaker.makeButton({
								text:"<img src='/assets/img/lib/ic_search1.png'>",
								click: function(e, ctx) {
								partNo = ctx.row.index;								
								window.open("/itemPopUp/init.do", "itemPop", "width=1300,height=600,scrollbars=yes,top=100,left=100")
								}		
								})},  
  		{binding: 'custNm', header: '폐기처', width: '*', align:'center',dataType:'String',isReadOnly:true},
  		{binding: 'custId', header: '폐기처아이디', width: '*', align:'center',dataType:'Number',visible:false,isReadOnly:true},
		{header: '', width: 40, align:'center',
					cellTemplate: cellMaker.makeButton({
								text:"<img src='/assets/img/lib/ic_search1.png'>",
								click: function(e, ctx) {
								custId = ctx.row.index;								
								window.open("/customerPopUp/init.do", "customerPop", "width=1300,height=600,scrollbars=yes,top=100,left=100")
								}		
								})},    
		{binding: 'qty', header: '수량', width: '*', align:'center',dataType:'String'},
        {binding: 'custEmpNm', header: '작업자', width: '*', align:'center',dataType:'String',isReadOnly:true},
		{binding: 'custEmpId', header: '작업자아이디', width: '*', align:'center',dataType:'Number',isReadOnly:true,visible:false},
        {binding: 'remark', header: '비고', width: '*', align:'center',dataType:'String', maxLength:50},
        // 콤보박스 추가하려면 dataMap
    ];

	//컬럼 초기화
	flexGrid.initialize({
		columns: columnsDefinition
	});
	
}

/**
	그리드 이벤트 모음
 */
var gridEvent = function(){
	
	//validation 
	cv.getError = function(item, prop) {
		
		switch (prop) {
			case "disDt":
				if (item.disDt == null || wijmo.isEmpty(item.disDt) || item.disDt == "") {
					return "[폐기일자를 입력 해주세요.]";
				}
				return null;
				
			case "partNo":
				if (item.partNo == null || wijmo.isEmpty(item.partNo) || item.partNo == "") {
					return "[품목번호를 입력 해주세요.]";
				}
				return null;
				
			case "partNm":
				if (item.partNm == null || wijmo.isEmpty(item.partNm) || item.partNm == "") {
					return "[품목명을 입력 해주세요.]";
				}
				return null;	

			case "custNm":
				if (item.custNm == null || wijmo.isEmpty(item.custNm) || item.custNm == "") {
					return "[폐기처를 입력 해주세요.]";
				}
				return null;
			
			case "qty":
				if (item.qty == null || wijmo.isEmpty(item.qty) || item.qty == "") {
					return "[수량을 입력 해주세요.]";
				}
				return null;	
						
		}
		return null;
	}
	
}

/**
	폐기기간 일자 초기화
 */
var srcDatInit = function(){
	
	sdat.isRequired = false;
	sdat.value = null;		//주석처리할경우 오늘날짜 자동으로 박힘.
	sdat.placeholder = "폐기일자";
	sdat.format = "yyyy-MM-dd";
	commonInput.calendarInit(sdat);
	
	edat.isRequired = false;
	edat.value = null;
	edat.placeholder = "폐기일자";
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
	return year+"-"+month+"-"+day;
	
}

$(document.body).ready(function() {
	
	//그리드 공통js 호출 후에 나머지 함수 호출함.
	$.when(
		$.getScript('/js/wijmo/commonGrid.js'),
		$.getScript('/js/wijmo/commonInput.js')
	).done(function() {
		
		statusInit();	//교육대상 콤보박스 초기화
		srcDatInit();	//교육기간 일자 초기화
		handleEvent();	//프로그램 버튼 이벤트
		
		commonGrid.init(flexGrid,cv); //그리드 공통부분
		gridInit();  	//그리드 초기화
		gridEvent();	//그리드 이벤트
		
		search();		//조회
	});
	
	
	
});
