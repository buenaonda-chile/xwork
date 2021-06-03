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

var comboStatus = new wijmo.input.ComboBox("#status");	//수리상태

var comboNgType = new wijmo.input.ComboBox("#ngType");	//불량타입

var sdat = new wijmo.input.InputDate("#searchRepDtFr");	//수리일자 시작
		
var edat = new wijmo.input.InputDate("#searchRepDtTo");	//수리일자 종료

var dat = new wijmo.input.InputDate(document.createElement('div')); //수리일자

var zoomSize = 11;	//확대축소 기본 사이즈

// 고품 품번인지 수리품번인지 구분하기 위한 변수
var chkPartNo = '';

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
		addRow.repDt = getFormatDate(date);
		addRow.repNo = "[수리번호는 자동생성됩니다.]";
		addRow.status = "R1";	//수리상태 기본 "수리전"로
		addRow.custEmpNm = userName;
		addRow.custEmpId = userId;
		cv.commitNew();
		flexGrid.select(new wijmo.grid.CellRange(flexGrid.rows.length+1,2), true);  //셀선택 추가된행으로 선택되게
	});
	
	// 행삭제
	$("#btn_remove").on("click", function() {
		if(cv.currentItem.status == 'R3'){
			alert("[승인된 품목은 삭제불가능합니다.]");
		}else{
			cv.remove(cv.currentItem);	
		}
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
		if(chkPartNo=='brkPartNo'){
			flexGrid.setCellData(partNo, 'brkPartNo', retObj.partNo, true);
			flexGrid.setCellData(partNo, 'brkPartNm', retObj.itemNm, true);
		}else if(chkPartNo=='repPartNo'){
			flexGrid.setCellData(partNo, 'repPartNo', retObj.partNo, true);
			flexGrid.setCellData(partNo, 'repPartNm', retObj.itemNm, true);
		}
	}else if(value=='customer'){
			flexGrid.setCellData(custId, 'custNm', retObj.custNm, true);
			flexGrid.setCellData(custId, 'custId', retObj.custId, true);
	}
	}


//validation
var validation = function(item){
				
	if (item.repDt == null || wijmo.isEmpty(item.repDt) || item.repDt == "") {
		alert("[수리일자를 입력 해주세요.]");
		return false;
	}
	
	if (item.repCar == null || wijmo.isEmpty(item.repCar) || item.repCar == "") {
		alert("[수리차량을 입력 해주세요.]");
		return false;
	}
				
	if (item.brkPartNo == null || wijmo.isEmpty(item.brkPartNo) || item.brkPartNo == "") {
		alert("[품목번호를 입력 해주세요.]");
		return false;
	}
	
	if (item.brkPartNm == null || wijmo.isEmpty(item.brkPartNm) || item.brkPartNm == "") {
		alert("[품목명을 입력 해주세요.]");
		return false;
	}
	
	if (item.custNm == null || wijmo.isEmpty(item.custNm) || item.custNm == "") {
		alert("[수리처를 입력 해주세요.]");
		return false;
	}
	
	if (item.qty == null || wijmo.isEmpty(item.qty) || item.qty == "") {
		alert("[수량을 입력 해주세요.]");
		return false;
	}
	
	if (item.status == null || wijmo.isEmpty(item.status) || item.status == "") {
		alert("[수리상태를 선택 해주세요.]");
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
		
		ajaxCommit("/repairCDInfo/create",cv.itemsAdded[i]);
		
	}
	
	//수정행 저장
	for ( var i = 0; i <cv.itemsEdited.length; i ++) {
		console.debug("edit:");
		console.debug(cv.itemsEdited[i]);
		
		ajaxCommit("/repairCDInfo/update",cv.itemsEdited[i]);
	}
	
	//삭제행 저장
	for ( var i = 0; i <cv.itemsRemoved.length; i ++) {
		console.debug("del:");
		console.debug(cv.itemsRemoved[i]);
		ajaxCommit("/repairCDInfo/delete",cv.itemsRemoved[i]);
		
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
	
	var url = '/repairCDInfo/search';
	
	var params = {
		"searchRepDtFr" : wijmo.Globalize.format(sdat.value,'yyyyMMdd'),
		"searchRepDtTo" : wijmo.Globalize.format(edat.value,'yyyyMMdd'),
		"ngType" : comboNgType.selectedValue,
		"status" : comboStatus.selectedValue,
		"repNo" : $("#rectNo").val(),
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
	
	//콤보박스 정의
	var statusMap = new wijmo.grid.DataMap(comboStatus.itemsSource, 'codeCd', 'codeNm'); //수리상태 콤보박스 (조회부분에서 가져온 데이터를 그대로 사용함.)
	var ngTypeMap = new wijmo.grid.DataMap(comboNgType.itemsSource, 'codeCd', 'codeNm'); //불량타입 콤보박스
	
	//셀버튼 정의
	var cellMaker = wijmo.grid.cellmaker.CellMaker;
	
	//컬럼정의
	columnsDefinition = [
		{binding:'id',visible:false},
	    {binding:'chk',visible:false},
	    {binding: 'repNo', header: '수리번호', width: '*', align:'center',dataType:'Number',isReadOnly:true},  
        {binding: 'repDt', header: '수리일자', width: '*', align:'center',dataType:'String',maxLength:12}, 
		{binding: 'repCar', header: '수리차량', width: '*', align:'center',dataType:'String'}, 
        {binding: 'brkPartNo', header: '고품번호', width: '*', align:'center',dataType:'String',isReadOnly:true},
		{binding: 'brkPartNm', header: '고품명', width: '*', align:'center',dataType:'String',isReadOnly:true},
		{header: '', width: 40, align:'center',
					cellTemplate: cellMaker.makeButton({
								text:"<img src='/assets/img/lib/ic_search1.png'>",
								click: function(e, ctx) {
								chkPartNo = "brkPartNo";
								partNo = ctx.row.index;								
								window.open("/itemPopUp/init.do", "itemPop", "width=1300,height=600,scrollbars=yes,top=100,left=100")
								}		
								})},
		{binding: 'repPartNo', header: '수리부품'+'(수리대체품)번호', width: 200, align:'center',dataType:'String',isReadOnly:true,wordWrap: true}, //wordWrap: true: 텍스트 자동줄바꿈 autorowHeights랑 같이 사용
		{binding: 'repPartNm', header: '수리부품'+'(수리대체품)명', width: 200, align:'center',dataType:'String',isReadOnly:true,wordWrap: true},
		{header: '', width: 40, align:'center',
					cellTemplate: cellMaker.makeButton({
								text:"<img src='/assets/img/lib/ic_search1.png'>",
								click: function(e, ctx) {
								chkPartNo = "repPartNo";
								partNo = ctx.row.index;								
								window.open("/itemPopUp/init.do", "itemPop", "width=1300,height=600,scrollbars=yes,top=100,left=100")
								}		
								})},   
  		{binding: 'custNm', header: '수리처', width: '*', align:'center',dataType:'String',isReadOnly:true},
  		{binding: 'custId', header: '수리처아이디', width: '*', align:'center',dataType:'Number',visible:false,isReadOnly:true},
		{header: '', width: 40, align:'center',
					cellTemplate: cellMaker.makeButton({
								text:"<img src='/assets/img/lib/ic_search1.png'>",
								click: function(e, ctx) {
								custId = ctx.row.index;								
								window.open("/customerPopUp/init.do", "customerPop", "width=1300,height=600,scrollbars=yes,top=100,left=100")
								}		
								})},    
        {binding: 'custEmpNm', header: '수리담당자', width: 120, align:'center',dataType:'String',isReadOnly:true},
		{binding: 'custEmpId', header: '담당자아이디', width: '*', align:'center',dataType:'Number',isReadOnly:true,visible:false},
		{binding: 'qty', header: '수량', width: '*', align:'center',dataType:'String'},
        {binding: 'status', header: '수리상태', width: '*', dataMap:statusMap, align:'center',dataType:'String'},
		{binding: 'ngType', header: '불량항목', width: '*', dataMap:ngTypeMap, align:'center',dataType:'String'},
		{binding: 'ngCn', header: '불량사유', width: '*', align:'center',dataType:'String'},
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
			case "repDt":
				if (item.repDt == null || wijmo.isEmpty(item.repDt) || item.repDt == "") {
					return "[수리일자를 입력 해주세요.]";
				}
				return null;
				
			case "repCar":
				if (item.repCar == null || wijmo.isEmpty(item.repCar) || item.repCar == "") {
					return "[수리차량를 입력 해주세요.]";
				}
				return null;
				
			case "brkPartNo":
				if (item.brkPartNo == null || wijmo.isEmpty(item.brkPartNo) || item.brkPartNo == "") {
					return "[품목번호를 입력 해주세요.]";
				}
				return null;
				
			case "brkPartNm":
				if (item.brkPartNm == null || wijmo.isEmpty(item.brkPartNm) || item.brkPartNm == "") {
					return "[품목명을 입력 해주세요.]";
				}
				return null;		

			case "custNm":
				if (item.custNm == null || wijmo.isEmpty(item.custNm) || item.custNm == "") {
					return "[수리처를 입력 해주세요.]";
				}
				return null;
				
			case "qty":
				if (item.qty == null || wijmo.isEmpty(item.qty) || item.qty == "") {
					return "[수량을 입력 해주세요.]";
				}
				return null;
			
			case "status":
				if (item.status == null || wijmo.isEmpty(item.status) || item.status == "") {
					return "[수리상태를 선택 해주세요.]";
				}
				return null;	
						
		}
		return null;
	}
	
}


/**
	수리상태 초기화
 */
var statusInit = function(){
	
	comboStatus.displayMemberPath = "codeNm";
	comboStatus.selectedValuePath = "codeCd";
	
	var List= new wijmo.collections.ObservableArray([{codeNm:"전체",codeCd:""}]);
	var url = '/code/list2.json/REPAIR_STATUS';
	
	$.ajax({
		method : "post",
		url : url,
		//data:params,
		async:false,
		dataType :"json",
		success : function(res) {
			
			$.each(res.data,function(index,item){
				List.push(item);
			});
			
			comboStatus.itemsSource =List;
			
		},
		error : function() {
			console.log("dataset.error");
			
		},
		complete : function() {
			
		}
	});
	
}

/**
	불량타입 초기화
 */
var ngTypeInit = function(){
	
	comboNgType.displayMemberPath = "codeNm";
	comboNgType.selectedValuePath = "codeCd";
	
	var List= new wijmo.collections.ObservableArray([{codeNm:"전체",codeCd:""}]);
	var url = '/code/list2.json/NG_TYPE';
	
	$.ajax({
		method : "post",
		url : url,
		//data:params,
		async:false,
		dataType :"json",
		success : function(res) {
			
			$.each(res.data,function(index,item){
				List.push(item);
			});
			
			comboNgType.itemsSource =List;
			
		},
		error : function() {
			console.log("dataset.error");
			
		},
		complete : function() {
			
		}
	});
	
}

/**
	수리일자 초기화
 */
var srcDatInit = function(){
	
	sdat.isRequired = false;
	sdat.value = null;		//주석처리할경우 오늘날짜 자동으로 박힘.
	sdat.placeholder = "수리일자";
	sdat.format = "yyyy-MM-dd";
	commonInput.calendarInit(sdat);
	
	edat.isRequired = false;
	edat.value = null;
	edat.placeholder = "수리일자";
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
		
		ngTypeInit();	//불량타입 콤보박스 초기화
		statusInit();	//수리상태 콤보박스 초기화
		srcDatInit();	//수리일자 초기화
		handleEvent();	//프로그램 버튼 이벤트
		
		commonGrid.init(flexGrid,cv); //그리드 공통부분
		gridInit();  	//그리드 초기화
		gridEvent();	//그리드 이벤트
		
		search();		//조회
	});
	
	
	
});
