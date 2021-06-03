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

var sRoleCd = '';

var zoomSize = 11;	//확대축소 기본 사이즈

var gridRow = -1;
var btnChk = false;
var addChk = false;


/**
	버튼 이벤트
 */
var handleEvent = function(){
	
	$("#btn_search").on("click",search);
	
	// 최상위 버튼
	$("#btn_root").on("click", function() {
		gridAdd(gridRow, "R");
	});

	//행 추가버튼
	$("#btn_add").on("click", function() {
		gridAdd(gridRow, "A");
	});
	
	//저장
	$("#btn_save").on("click",save);
	
	// 행삭제
	$("#btn_remove").on("click", function() {
		if (!confirm("해당 데이터를 삭제 하시겠습니까?")) {
	      return;
		}
		
		del();
		
		search();
	});
	
	// 취소
	$("#btn_cancel").on("click", function() {
		
		if (!confirm("변경된 데이터가 있습니다. 취소 하시겠습니까?")) {
	      return;
		}
		
		cancel();
	});
	
	//엑셀 다운로드
	$("#btn_down").on("click",function(){
		var fileName = "교육정보관리";
		transExcel(flexGrid, fileName);
	});	
}

/**
	체인지 이벤트
 */
//메뉴 한글
$("#txt_menuKoNm_input").on('change', function(){
	textChange("menuKoNm");
});

//메뉴 영어
$("#txt_menuEnNm_input").on('change', function(){
	textChange("menuEnNm");
});

//메뉴 일어
$("#txt_menuJaNm_input").on('change', function(){
	textChange("menuJaNm");
});

//순서
$("#num_menuOrdr_input").on('change', function(){
	textChange("menuOrdr");
});

//게시여부
$("#cmb_pubYn_input").on('change', function(){
	textChange("pubYn");
});

//메뉴URL
$("#txt_menuUrl_input").on('change', function(){
	textChange("menuUrl");
});

//메뉴icon
$("#txt_menuIcon_input").on('change', function(){
	textChange("menuIcon");
});

//상위메뉴
$("#txt_upperMenuKey_input").on('change', function(){
	textChange("upperMenuKey");
});

// 메뉴 수정시
var textChange = function(gubun){
	$("#btn_save").show();
	$("#btn_cancel").show();
	$("#btn_root").hide();
	$("#btn_add").hide();
	$("#btn_remove").hide();
	flexGrid.selectionMode = 'None';
	btnChk = true;
	
	if(gubun == "menuKoNm"){
		flexGrid.setCellData(gridRow, "menuKoNm", $("#txt_menuKoNm_input").val(), true);
	}
	
	if(gubun == "menuEnNm"){
		flexGrid.setCellData(gridRow, "menuEnNm", $("#txt_menuEnNm_input").val(), true);	
	}
	
	if(gubun == "menuJaNm"){
		flexGrid.setCellData(gridRow, "menuJaNm", $("#txt_menuJaNm_input").val(), true);	
	}
	
	if(gubun == "menuOrdr"){
		flexGrid.setCellData(gridRow, "menuOrdr", $("#num_menuOrdr_input").val(), true);	
	}
	
	if(gubun == "pubYn"){
		flexGrid.setCellData(gridRow, "pubYn", $("#cmb_pubYn_input").data("kendoDropDownList").value(), true);
	}
	
	if(gubun == "menuUrl"){
		flexGrid.setCellData(gridRow, "menuUrl", $("#txt_menuUrl_input").val(), true);	
	}
	
	if(gubun == "menuIcon"){
		flexGrid.setCellData(gridRow, "menuIcon", $("#txt_menuIcon_input").val(), true);	
	}
	
	if(gubun == "upperMenuId"){
		flexGrid.setCellData(gridRow, "upperMenuId", $("#txt_upperMenuKey_input").val(), true);	
	}
}

// 최상위, 추가 버튼 클릭시
var gridAdd = function(iRow, type){

	flexGrid.select(new wijmo.grid.CellRange(flexGrid.rows.length, 2), true);  //셀선택 추가된행으로 선택되게
	flexGrid.select(new wijmo.grid.CellRange(flexGrid.rows.length - 1, 2), true);  //셀선택 추가된행으로 선택되게
	
	$("#btn_save").show();
	$("#btn_cancel").show();
	$("#btn_root").hide();
	$("#btn_add").hide();
	$("#btn_remove").hide();
	
	$("#txt_menuKoNm_input").val("");
	$("#txt_menuEnNm_input").val("");
	$("#txt_menuJaNm_input").val("");
	
	$("#num_menuOrdr_input").data("kendoNumericTextBox").value("1");
	$("#cmb_pubYn_input").data("kendoDropDownList").value("Y");
			
	$("#txt_menuUrl_input").val("");
	$("#txt_menuIcon_input").val("");
	if(type == "A"){
		$("#txt_upperMenuKey_input").val(flexGrid.getCellData(iRow,"menuKey",true));	
	}else{
		$("#txt_upperMenuKey_input").val("");
	}
	
	var addRow = cv.addNew();
	addRow.menuKey = "";
	addRow.menuKoNm = "";
	addRow.menuEnNm = "";
	addRow.menuJaNm = "";
	addRow.pubYn = "Y";
	addRow.menuOrdr = "";
	addRow.menuUrl = "";
	addRow.menuIcon = "";
	addRow.upperMenuId = $("#txt_upperMenuKey_input").val();
	//addRow.menuKoNm = "N";	//온오프라인 기본N으로 설정
	//addRow.pubYn = "Y";	//사용유무 체크안함으로 설정
	cv.commitNew();
	
	gridRow = flexGrid.rows.length - 1;
	flexGrid.selectionMode = 'None';
	btnChk = true;
	addChk = true;
}


//validation
var validation = function(){

	if($("#txt_menuKoNm_input").val() == ""){
		alert("메뉴(한글)은 필수 입력 항목입니다.");
		return false;
	}
	
	if($("#txt_menuEnNm_input").val() == ""){
		alert("메뉴(영어)은 필수 입력 항목입니다.");
		return false;
	}
	
	if($("#txt_menuJaNm_input").val() == ""){
		alert("메뉴(일어)은 필수 입력 항목입니다.");
		return false;
	}
	
	if($("#num_menuOrdr_input").data("kendoNumericTextBox").value() == "" || $("#num_menuOrdr_input").data("kendoNumericTextBox").value() == null){
		alert("순서는 필수 입력 항목입니다.");
		return false;
	}
	
	return true;				
			
}

//조회
var search = function(){
	
	var url = '/menu/search';
	
	$.ajax({
		method : "get",
		url : url,
		//data :params,
		beforeSend:function(){
			_dicasPage.maskOpen();
		},
		success : function(res) {
			
			var data = convertJsonOfTreeGrid(res.data);
			cv.sourceCollection = data;
			btnChk = false;
			addChk = false;
			cancel();
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
	저장
	추가/수정/삭제 한번에 처리함.
 */
var save = function(){
	
	//익스플로러에서 포커스가 그리드 밖으로 빠졌을경우 flexGrid.rows.length 를 받아오지 못하는 버그 존재하여 포커스를 그리드에 강제로 두게함.
	flexGrid.focus();
	flexGrid.select( new wijmo.grid.CellRange( 0 , 0 , 0 , 0 ), true );
	
	if(!validation()){
		return false;
	}

	_dicasPage.maskOpen();
	
	//추가행 저장
	for ( var i = 0; i <cv.itemsAdded.length; i ++) {
		var params = {  
		 	"menuKey": flexGrid.getCellData(gridRow, "menuKey", true),
			"menuKoNm": flexGrid.getCellData(gridRow, "menuKoNm", true),
			"menuEnNm": flexGrid.getCellData(gridRow, "menuEnNm", true),
			"menuJaNm": flexGrid.getCellData(gridRow, "menuJaNm", true),
			"pubYn" : flexGrid.getCellData(gridRow, "pubYn", true),
			"menuOrdr" : flexGrid.getCellData(gridRow, "menuOrdr", true),
			"menuUrl" : flexGrid.getCellData(gridRow, "menuUrl", true),
			"menuIcon" : flexGrid.getCellData(gridRow, "menuIcon", true),
			"upperMenuId": flexGrid.getCellData(gridRow, "upperMenuId", true)
		};

		ajaxCommit("/menu/create",params);
		
	}

	
	//수정행 저장
	if(addChk == false){
		var params = {  
		 	"menuKey": flexGrid.getCellData(gridRow, "menuKey", true),
			"menuKoNm": flexGrid.getCellData(gridRow, "menuKoNm", true),
			"menuEnNm": flexGrid.getCellData(gridRow, "menuEnNm", true),
			"menuJaNm": flexGrid.getCellData(gridRow, "menuJaNm", true),
			"pubYn" : flexGrid.getCellData(gridRow, "pubYn", true),
			"menuOrdr" : flexGrid.getCellData(gridRow, "menuOrdr", true),
			"menuUrl" : flexGrid.getCellData(gridRow, "menuUrl", true),
			"menuIcon" : flexGrid.getCellData(gridRow, "menuIcon", true),
			"upperMenuId": flexGrid.getCellData(gridRow, "upperMenuId", true)
		};
		
		ajaxCommit("/menu/update",params);
	}

	/*//삭제행 저장
	for ( var i = 0; i <cv.itemsRemoved.length; i ++) {
		console.debug("del:");
		console.debug(cv.itemsRemoved[i]);
		ajaxCommit("/trainingInfoBase/delete2",cv.itemsRemoved[i]);
		
	}*/
	
	_dicasPage.maskClose();
	
	//조회
	search();	
}

var del = function(){

	var params = {  
		 	"menuKey": flexGrid.getCellData(gridRow, "menuKey", true),
			"menuKoNm": flexGrid.getCellData(gridRow, "menuKoNm", true),
			"menuEnNm": flexGrid.getCellData(gridRow, "menuEnNm", true),
			"menuJaNm": flexGrid.getCellData(gridRow, "menuJaNm", true),
			"pubYn" : flexGrid.getCellData(gridRow, "pubYn", true),
			"menuOrdr" : flexGrid.getCellData(gridRow, "menuOrdr", true),
			"menuUrl" : flexGrid.getCellData(gridRow, "menuUrl", true),
			"menuIcon" : flexGrid.getCellData(gridRow, "menuIcon", true),
			"upperMenuId": flexGrid.getCellData(gridRow, "upperMenuId", true)
		};
		
		ajaxCommit("/menu/delete",params);
}

var cancel = function(){
	$("#txt_menuKoNm_input").val("");
	$("#txt_menuEnNm_input").val("");
	$("#txt_menuJaNm_input").val("");
	
	$("#num_menuOrdr_input").data("kendoNumericTextBox").value("1");
	$("#cmb_pubYn_input").data("kendoDropDownList").value("Y");
			
	$("#txt_menuUrl_input").val("");
	$("#txt_menuIcon_input").val("");
	
	flexGrid.select(new wijmo.grid.CellRange(flexGrid.rows.length, 2), true);  //셀선택 추가된행으로 선택되게
	cv.remove(cv.currentItem);
	flexGrid.selectionMode = 'Row';
	$("#btn_save").hide();
	$("#btn_cancel").hide();
	$("#btn_root").show();
	$("#btn_add").show();
	$("#btn_remove").hide();
	btnChk = false;	
	flexGrid.select(new wijmo.grid.CellRange(gridRow, 2), true);  //셀선택 추가된행으로 선택되게
}


//등록,수정,삭제
var ajaxCommit = function(url, item){
	//사용유무가 체크박스로 되어있는데 wijmo에서 체크박스는 true, false로 값을 가져옴.
	//DB상에는 Y,N으로 들어가는거 같아서 beforsend 에서 값을 치환시켰음.
	/*if(item.useYn==true){
		item.useYn = "Y";
	}else{
		item.useYn = "N";	
	}*/

	$.ajax({
		method : "post",
		url : url,
		contentType: 'application/json',
		data : JSON.stringify(item),
		async: false,
		beforeSend:function(){
			
		},
		success : function(res) {
			
	    	var data = res.result;
			console.debug(data);
        	 
	    },
        error : function() {
			console.log("등록 오류:"+url);
		},
		complete : function() {
			
		}
	});	
}

var convertJsonOfTreeGrid = function(array){
	var map = {};
	
    for(var i = 0; i < array.length; i++){
    	var obj = {"menuKey" : array[i]['menuKey'], "menuKoNm" : array[i]['menuKoNm'], "menuEnNm" : array[i]['menuEnNm'], "menuJaNm" : array[i]['menuJaNm'],
				   "pubYn" : array[i]['pubYn'], "menuOrdr" : array[i]['menuOrdr'], "menuUrl" : array[i]['menuUrl'], "menuIcon" : array[i]['menuIcon'],
				   "menuLvl" : array[i]['menuLvl'], "menuMaxLvl" : array[i]['menuMaxLvl'], "childYn" : array[i]['childYn'], "upperMenuId" : array[i]['upperMenuId'] };
	
      	obj.children = [];
      	map[obj.menuKey] = obj;
      	var parent = array[i]['upperMenuId'] || '-';

      	if(!map[parent]){
      		map[parent] = {
        		children: []
        	};
      	}
	    map[parent].children.push(obj);
    }
	return map['-'].children 
}

/**
  그리드 초기화
 */
var gridInit = function() {
	/**
	 *	grid 셋팅
	 *	gridCommon.js 에서 공통으로 처리되있는 옵션을 변경하고 싶다면 gridInit 함수에서 바꾸고싶은 옵션만 재정의 하면됨.
	 */     

	//컬럼정의
	columnsDefinition = [
		{binding:'menuKey',dataType:'String',visible:false},
		{binding: 'menuKoNm', header: '한글', width: '*', align:'center',dataType:'String',wordWrap: true,isRequired: true, isReadOnly: true}, 
	    {binding: 'menuEnNm', header: '영어', width: '*', align:'center',dataType:'String',wordWrap: true, isReadOnly: true}, 
		{binding: 'menuJaNm', header: '일어', width: '*', align:'center',dataType:'String',wordWrap: true, isReadOnly: true}, //wordWrap: true: 텍스트 자동줄바꿈 autorowHeights랑 같이 사용
		{binding: 'pubYn', header: '게시여부', width: '*', align:'center',dataType:'String',wordWrap: false},
		
		{binding:'menuOrdr',dataType:'String',visible:false},
		{binding:'menuUrl',dataType:'String',visible:false},
		{binding:'menuIcon',dataType:'String',visible:false},
		{binding:'menuLvl',dataType:'String',visible:false},
		{binding:'menuMaxLvl',dataType:'String',visible:false},
		{binding:'childYn',dataType:'String',visible:false},
		{binding:'upperMenuId',dataType:'String',visible:false}
    ];

	flexGrid.isReadOnly = false;
	
	//컬럼 초기화
	flexGrid.initialize({
		columns: columnsDefinition,
		childItemsPath:'children'
	});
}
/**
	그리드 이벤트 모음
 */
var gridEvent = function(){
	flexGrid.hostElement.addEventListener("click",function(e){  
		
		if(btnChk == true){
			return;
		}
		
		var ht = flexGrid.hitTest(e);
		
		gridRow = ht.row;
		
		$("#txt_menuKoNm_input").val(flexGrid.getCellData(ht.row,"menuKoNm",true));
		$("#txt_menuEnNm_input").val(flexGrid.getCellData(ht.row,"menuEnNm",true));
		$("#txt_menuJaNm_input").val(flexGrid.getCellData(ht.row,"menuJaNm",true));
		$("#num_menuOrdr_input").data("kendoNumericTextBox").value(flexGrid.getCellData(ht.row,"menuOrdr",true));
		$("#cmb_pubYn_input").data("kendoDropDownList").value(flexGrid.getCellData(ht.row,"pubYn",true));
		$("#txt_menuUrl_input").val(flexGrid.getCellData(ht.row,"menuUrl",true));
		$("#txt_menuIcon_input").val(flexGrid.getCellData(ht.row,"menuIcon",true));
		$("#txt_upperMenuKey_input").val(flexGrid.getCellData(ht.row,"upperMenuId",true));
		
		if(flexGrid.getCellData(ht.row,"childYn",true) == 1 ){
			$("#btn_remove").show();
		}else{
			$("#btn_remove").hide();
		}
		
		if(flexGrid.getCellData(ht.row,"menuLvl",true) < 3 ){
			$("#btn_add").show();	
		}else{
			$("#btn_add").hide();
		}
		
		$("#btn_root").show();
	});
	
}

$(document.body).ready(function() {
	
	//그리드 공통js 호출 후에 나머지 함수 호출함.
	$.when(
		$.getScript('/js/wijmo/commonGrid.js'),
		$.getScript('/js/wijmo/commonInput.js')
	).done(function() {
		
		handleEvent();	//프로그램 버튼 이벤트
		
		commonGrid.init(flexGrid,cv, false); //그리드 공통부분
		flexGrid.allowPinning = 0; 						//고정클립 (0없음, 1컬럼하나,2컬럼범위, 3모두)
		flexGrid.allowSorting = 0; 						//멀티정렬 (0없음, 1컬럼하나,2컬럼범위, 3모두)
		gridInit();  	//그리드 초기화
		gridEvent();	//그리드 이벤트
		search();		//조회
		flexGrid.selectionMode = 'Row';
		
		$("#btn_save").hide();
		$("#btn_cancel").hide();
		$("#btn_remove").hide();
	});
	
});
