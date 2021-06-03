

// 컬랙션 뷰는 조회후에 그리드의 상태변경을 체크한다. 
var cv = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수

var flexGrid = new wijmo.grid.FlexGrid('#wijmoGrid');	//그리드 전역변수
var zoomSize = 11;


/**
 * ======================================
 * [ko] 정보 검색하는 함수<br>
 * ======================================
 */
function search() {
	
	
	var url = '/ajaxBatchHist/search.do';
	var params = {
		//'getComps' : $(".getComps").val(),
		//'getPyvnd' : $(".getPyvnd").val()
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

/** 
 * 확대
 */
function zoomIn(){
	
	if (zoomSize>17) return;
	zoomSize++;
	
	var headerSize = zoomSize-11;
	if(headerSize <0) headerSize = headerSize * -1;
	
	$("#wijmoGrid").css("font-size",zoomSize+"pt");
	flexGrid.collectionView.refresh();
	flexGrid.columnHeaders.rows.defaultSize = flexGrid.columnHeaders.rows.defaultSize+(headerSize/2); 	// 열 헤더 영역에 행의 높이 설정
	
}

/**
 * 축소
 */
function zoomOut(){
	if (zoomSize<6) return;
	zoomSize--;
	
	var headerSize = zoomSize-11;
	if(headerSize <0) headerSize = headerSize * -1;
	
	$("#wijmoGrid").css("font-size",zoomSize+"pt");
	flexGrid.collectionView.refresh();
	flexGrid.columnHeaders.rows.defaultSize = flexGrid.columnHeaders.rows.defaultSize-(headerSize/2); 	// 열 헤더 영역에 행의 높이 설정
}


/**
  그리드 초기화
 */
function gridInit() {

	
	/**
	 *	grid 셋팅
	 */
	//컬럼정의
	columnsDefinition = [
        {binding: 'seq', header: 'No.', width: '*', wordWrap: true, align:'center', isReadOnly: true},  //wordWrap: true: 텍스트 자동줄바꿈 autorowHeights랑 같이 사용
        {binding: 'batchcd', header: '배치코드', width: '*', align:'center', isReadOnly: true},
        {binding: 'batchnm', header: '배치명', width: '*', align:'center', isReadOnly: true},
        {binding: 'rst', header: '결과코드', width: '*', align:'center', isReadOnly: true},
        {binding: 'rstdata', header: '결과상세', width: '*', align:'center', isReadOnly: true},
        {binding: 'regdt', header: '시작시간', width: '*', align:'center', isReadOnly: true},
        {binding: 'updt', header: '완료시간', width: '*', align:'center', isReadOnly: true}
		// 콤보박스 추가하려면 dataMap
    ];

	//컬럼 초기화
	flexGrid.initialize({
		columns: columnsDefinition
	});
	
	flexGrid.itemsSource = cv;
	//flexGrid.allowAddNew = true; 					//행추가 
	flexGrid.deletedRow = true;						//행삭제
	flexGrid.autoGenerateColumns = false;			//컬럼명자동화
	flexGrid.keyActionEnter = "MoveDown"  			//엔터키액션 (None, MoveDown,MoveAcross,Cycle,CycleOut)
	flexGrid.keyActionTab = "CycleOut";  			//탭키액션 (None, MoveDown, MoveAcross,Cycle,CycleOut)
	flexGrid.allowPinning = 2; 						//고정클립 (0없음, 1컬럼하나,2컬럼범위, 3모두)
	flexGrid.allowSorting=2; 						//멀티정렬 (0없음, 1컬럼하나,2컬럼범위, 3모두)
	flexGrid.isReadOnly = false;					//그리드 전체 readonly
	flexGrid.columnHeaders.rows.defaultSize = 30; 	// 열 헤더 영역에 행의 높이 설정
	//flexGrid.rows.defaultSize = 50;					// 스크롤 가능한 영역에 행의 높이 설정
	
	
	//엑셀처럼 하나의 컬럼헤드 선택시 전체 선택을 요할경우
	/*
	flexGrid.allowSorting= 0;
    flexGrid.allowDragging= false; 			//컬럼헤드를 잡고 드레그 하면 이동가능
    flexGrid.selectionMode= "MultiRange";
	*/
	
	//footer 활성화
	//그리드 필드옵션에 aggregate: 'Sum' 추가하면 자동으로 footer에 합계 산출됨.
	/*
	flexGrid.columnFooters.rows.push(new wijmo.grid.GroupRow());
	flexGrid.bottomLeftCells.setCellData(0, 0, '\u03A3');
	//flexGrid.columnFooters.setCellData(0,1, 567);  //풋터에 강제로 값넣기
	*/
	
	/** 자동 row height 설정 ==> 필드옵션에 "wordWrap: true" 있는것만 작동함.  */
	/** 아래 내용은 컬럼이 내용이 수정될때 데이터 수가 많을경우 시간이 오래걸리는데 비동기 방식으로 화면이 보여질때 리사이징하여 속도를 개선시킴 */
	/** 그리드 내용이 많지 않을때는 autoRowHeights= true 만사용해도 됨. */
	
	flexGrid.loadedRows.addHandler(function(s,e){
		autoSizeRowsAsync(s);
	});
	
	// auto-size all rows when a wrapping column is resized
	flexGrid.resizedColumn.addHandler(function(s,e){
		if (s.columns[e.col].wordWrap) {
			autoSizeRowsAsync(s);
		}
	});
	
	// auto-size a single row when a wrapping cell is edited
	flexGrid.cellEditEnded.addHandler(function(s,e){
		if (s.columns[e.col].wordWrap) {
			autoSizeRowsAsync(s, e.row);
		}
	});
	
	// autosize rows within view that haven't been autosized yet
	flexGrid.scrollPositionChanged.addHandler(function(s,e){
		if(flexGrid.rows.length>0){
			var vr = s.viewRange;
			for (var r = vr.topRow; r <= vr.bottomRow; r++) {
				if (s.rows[r].height == null) {
					s.autoSizeRows(r, r);
				}
			}
		}
	});
	
	
	//row heaer에 순번 붙이기
	flexGrid.itemFormatter = function(p,r,c,cell){
		if(p.cellType == wijmo.grid.CellType.RowHeader){
			//cell.textContent = (r+1).toString();
			cell.textContent =  (cv.pageSize * cv.pageIndex + r + 1).toString()
		}
	}
	
	//필터기능 활성화
	new wijmo.grid.filter.FlexGridFilter(flexGrid);

	
	//그리드의 변경된 데이터 추적을 활성화
	cv.trackChanges=true;   
	
	/**페이징 html 페이지에서 <div id='thePager'></div> 코드를 페이징해야될 자리에 추가해야함.	
	cv.pageSize = 15;
	new wijmo.input.CollectionViewNavigator('#thePager', {
        byPage: true,
        headerFormat: 'Page {currentPage:n0} of {pageCount:n0}',
        cv: cv
	});
	*/
}

function gridEvent(){
	
}


$(document.body).ready(function() {
	
	gridInit();  	//그리드 초기화
	gridEvent();	//그리드 이벤트
	//handleEvent();	//프로그램 버튼 이벤트ㅡ

});