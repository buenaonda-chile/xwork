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

var currentEditItem = null;

// exit edit mode when scrolling the grid or losing focus
    flexGrid.scrollPositionChanged.addHandler(cancelEdit);
    flexGrid.lostFocus.addHandler(cancelEdit);

function cancelEdit() {
        if (currentEditItem) {
            currentEditItem = null;
            flexGrid.invalidate();
        }
    }

/**
	버튼 이벤트
 */
var handleEvent = function(){
	
	$("#btn_search").on("click",search);
	
	flexGrid.formatItem.addHandler(function (s, e) {
        if (e.panel == s.cells) {
            var col = s.columns[e.col], item = s.rows[e.row].dataItem;
            //
            if (item == currentEditItem) {
                //
                // create editors and buttons for the item being edited
                switch (col.binding) {
                    case 'buttons':
                        e.cell.innerHTML = document.getElementById('tplBtnEditMode').innerHTML;
                        e.cell['dataItem'] = item;
                        break;
                    case 'country':
                    case 'sales':
                    case 'expenses':
                        e.cell.innerHTML = '<input class="form-control" ' +
                            'id="' + col.binding + '" ' +
                            'value="' + s.getCellData(e.row, e.col, true) + '"/>';
                        break;
                }
            }
            else {
                //
                // create buttons for items not being edited
                switch (col.binding) {
                    case 'buttons':
                        e.cell.innerHTML = document.getElementById('tplBtnViewMode').innerHTML;
                        e.cell['dataItem'] = item;
                        break;
                }
            }
        }
    });
	
	//행 추가버튼
	$("#btn_add").on("click", function() {
		var addRow = cv.addNew();
		addRow.onoffYn = "N";	//온오프라인 기본N으로 설정
		addRow.useYn = false;	//사용유무 체크안함으로 설정
		cv.commitNew();
		flexGrid.select(new wijmo.grid.CellRange(flexGrid.rows.length+1,2), true);  //셀선택 추가된행으로 선택되게

	});
	
	// 행삭제
	$("#btn_remove").on("click", function() {
		cv.remove(cv.currentItem);
	});
	
	//저장
	$("#btn_save").on("click",save);
	
	//엑셀 다운로드
	$("#btn_down").on("click",function(){
		var fileName = "교육정보관리";
		transExcel(flexGrid, fileName);

	});
		
	
}


//validation
var validation = function(item){
	
	if (item.eduDiv == null || wijmo.isEmpty(item.eduDiv) || item.eduDiv == "") {
		alert("[교육대상을 선택 해주세요.]");
		return false;
	}
				
				
	if (item.eduNm == null || wijmo.isEmpty(item.eduNm) || item.eduNm == "") {
		alert("[교육명을 입력 해주세요.]");
		return false;
	}
				
	if (item.eduDt == null || wijmo.isEmpty(item.eduDt) || item.eduDt == "") {
		alert("[교육일시를 입력 해주세요.]");
		return false;
	}
			
			
	if (item.receiptEndDate == null || wijmo.isEmpty(item.receiptEndDate) || item.receiptEndDate == "") {
		alert("[접수마감일시를 입력 해주세요.]");
		return false;
	}
				
	if ( item.persCnt == undefined || item.persCnt < 1) {
		alert("[인원수를 입력 해주세요.]");
		return false
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
		
		ajaxCommit("/trainingInfoBase/create2",cv.itemsAdded[i]);
		
	}
	
	//수정행 저장
	for ( var i = 0; i <cv.itemsEdited.length; i ++) {
		console.debug("edit:");
		console.debug(cv.itemsEdited[i]);
		
		ajaxCommit("/trainingInfoBase/update2",cv.itemsEdited[i]);
	}
	
	//삭제행 저장
	for ( var i = 0; i <cv.itemsRemoved.length; i ++) {
		console.debug("del:");
		console.debug(cv.itemsRemoved[i]);
		ajaxCommit("/trainingInfoBase/delete2",cv.itemsRemoved[i]);
		
	}
	
	_dicasPage.maskClose();
	
	//조회
	search();	
}

//등록,수정,삭제
var ajaxCommit = function(url,item){
	
	//사용유무가 체크박스로 되어있는데 wijmo에서 체크박스는 true, false로 값을 가져옴.
	//DB상에는 Y,N으로 들어가는거 같아서 beforsend 에서 값을 치환시켰음.
	if(item.useYn==true){
		item.useYn = "Y";
	}else{
		item.useYn = "N";	
	}
	
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
	
	var url = '/role/search';
	
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
			
						
		},
		error : function() {
			console.log("dataset.error");
			
		},
		complete : function() {
			_dicasPage.maskClose();
		}
	});
	
}



var convertJsonOfTreeGrid = function(array){
	
	var map = {};
	
    for(var i = 0; i < array.length; i++){
    	var obj = {"roleCd" : array[i]['roleCd'], "roleNm" : array[i]['roleNm'], "upperRoleCd" : array[i]['upperRoleCd'] };
      	obj.children = [];
      	map[obj.roleCd] = obj;
      	var parent = array[i]['upperRoleCd'] || '-';

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
		{binding:'roleCd',visible:false},
	    {binding: 'roleNm', header: '권한명', width: '*', align:'left',dataType:'String',wordWrap: true}, //wordWrap: true: 텍스트 자동줄바꿈 autorowHeights랑 같이 사용
		{binding:'upperRoleCd',visible:false}
		
    ];

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
		var ht = flexGrid.hitTest(e);
		
		$("#roleCd_input").val(flexGrid.getCellData(ht.row,"roleCd",true));
		$("#upperRoleCd_input").val(flexGrid.getCellData(ht.row,"upperRoleCd",true));
		$("#roleNm_input").val(flexGrid.getCellData(ht.row,"roleNm",true));
		
	});
		
}



$(document.body).ready(function() {
	
	//그리드 공통js 호출 후에 나머지 함수 호출함.
	$.when(
		$.getScript('/js/wijmo/commonGrid.js'),
		$.getScript('/js/wijmo/commonInput.js')
	).done(function() {
		
		//handleEvent();	//프로그램 버튼 이벤트
		
		commonGrid.init(flexGrid,cv); //그리드 공통부분
		gridInit();  	//그리드 초기화
		gridEvent();	//그리드 이벤트
		
		search();		//조회
	});
	
	
	
});
