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

var cv2 = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수 그리드의 수정,추가,삭제 되는 부분을 감지한다.
var flexGrid2 = new wijmo.grid.FlexGrid('#wijmoGrid2');	//그리드 전역변수

var sRoleCd = '';

var zoomSize = 11;	//확대축소 기본 사이즈

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

var convertJsonOfTreeGrid2 = function(array){
	
	var map = {};
	
    for(var i = 0; i < array.length; i++){
    	var obj = {"menuId" : array[i]['menuId'], "menuKoNm" : array[i]['menuKoNm'], "menuEnNm" : array[i]['menuEnNm'], "menuJaNm" : array[i]['menuJaNm'], "use" : array[i]['use'], "menuJaNm" : array[i]['menuJaNm'], "upperMenuId" : array[i]['upperMenuId'] };
      	obj.children = [];
      	map[obj.menuId] = obj;
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
		{binding:'roleCd',visible:false},
	    {binding:'roleNm', header: '권한명', width: '*', align:'left',dataType:'String',wordWrap: true}, //wordWrap: true: 텍스트 자동줄바꿈 autorowHeights랑 같이 사용
		{binding:'upperRoleCd',visible:false}
		
    ];

	//컬럼 초기화
	flexGrid.initialize({
		columns: columnsDefinition,
		childItemsPath:'children'
	});
	flexGrid.select( new wijmo.grid.CellRange( 1 , 1 , 1 , 1 ), true );
	flexGrid.selectionChanged.addHandler(function(){
		gridSelect();
	});
	
	
	/*<kendo:treeList-column field="menuKoNm" title="한글"></kendo:treeList-column>
				<kendo:treeList-column field="menuEnNm" title="영어"></kendo:treeList-column>
				<kendo:treeList-column field="menuJaNm" title="일어"></kendo:treeList-column>
				<kendo:treeList-column field="use" title="사용여부"*/
	//컬럼정의
	columnsDefinition2 = [
		{binding:'menuId',visible:false},
		{binding: 'menuKoNm', header: '한글', width: '*', align:'left',dataType:'String',wordWrap: true, isReadOnly: true}, 
	    {binding: 'menuEnNm', header: '영어', width: '*', align:'left',dataType:'String',wordWrap: true, isReadOnly: true}, 
		{binding: 'menuJaNm', header: '일어', width: '*', align:'left',dataType:'String',wordWrap: true, isReadOnly: true}, //wordWrap: true: 텍스트 자동줄바꿈 autorowHeights랑 같이 사용
		{binding: 'use', header: '사용여부', width: '*', align:'center',dataType:'Boolean',wordWrap: false}, 
		{binding:'upperMenuId',visible:false}
    ];

	flexGrid2.isReadOnly = false;
	
	//컬럼 초기화
	flexGrid2.initialize({
		columns: columnsDefinition2,
	    childItemsPath:'children',
	    loadedRows: function (s, e) {
			s.rows.forEach(function (row) {
				row.isReadOnly = false;
	         });
	    },
	    beginningEdit: function (s, e) {
	        var item = s.rows[e.row].dataItem, binding = s.columns[e.col].binding;
	        if (!(binding in item)) { // property not on this item?
	            e.cancel = true; // can't edit!
	        }
    	}
	});
	
}

/**
	그리드 이벤트 모음
 */
var gridSelect = function(){
	
	var url = '/menuRole/search';
	
	var ht = flexGrid.selection;
	sRoleCd = flexGrid.getCellData(ht.row,"roleCd",true);

	var params = {
		"roleCd" : flexGrid.getCellData(ht.row,"roleCd",true)
	};
	
	$.ajax({
		method : "get",
		url : url,
		data :params,
		beforeSend:function(){
			_dicasPage.maskOpen();
		},
		success : function(res) {
			var data = convertJsonOfTreeGrid2(res.data);
			cv2.sourceCollection = data;						
		},
		error : function() {
			console.log("dataset.error");
		},
		complete : function() {
			_dicasPage.maskClose();
		}
	});

}


var gridEvent = function(){
	
	flexGrid2.cellEditEnding.addHandler (function (s, e) {
	    var flex = s,
	    oldVal = flex.getCellData(e.row, e.col),
	    newVal = flex.activeEditor.value;
		/*console.log("cellEditEnding row: " + e.row + " col: " + e.col);
	    console.log("old: ", oldVal, " new: ", newVal);*/
		
		var url = '/menuRole/update';
		var chkUse = false;
		
		if(oldVal == true){
			chkUse = false;
		}else{
			chkUse = true;
		}

		var params = {
			"menuId": flex.getCellData(e.row, 0),
			"roleCd": sRoleCd,  
		 	"menuKey": flex.getCellData(e.row, 0),
			"menuKoNm": flex.getCellData(e.row, 1),
			"menuEnNm": flex.getCellData(e.row, 2),
			"menuJaNm": flex.getCellData(e.row, 3),
			"upperMenuId": flex.getCellData(e.row, 5),
			"use" : chkUse
		};
		
		$.ajax({
			method : "post",
			url : url,
			contentType: 'application/json',
			data : JSON.stringify(params),
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
    });
		
}


input.addEventListener('change', updateValue);

function updateValue(e) {
  log.textContent = e.target.value;
}


$(document.body).ready(function() {
	
	//그리드 공통js 호출 후에 나머지 함수 호출함.
	$.when(
		$.getScript('/js/wijmo/commonGrid.js'),
		$.getScript('/js/wijmo/commonInput.js')
	).done(function() {
		
		//handleEvent();	//프로그램 버튼 이벤트
		
		commonGrid.init(flexGrid,cv); //그리드 공통부분
		commonGrid.init(flexGrid2,cv2); //그리드 공통부분
		gridInit();  	//그리드 초기화
		gridEvent();	//그리드 이벤트
		
		search();		//조회
	});
	
});
