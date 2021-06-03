

// 컬랙션 뷰는 조회후에 그리드의 상태변경을 체크한다. 
var cv = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수

var flexGrid = new wijmo.grid.FlexGrid('#wijmoGrid');	//그리드 전역변수
var zoomSize = 11;


/**
 * 업체코드로 업체명 검색하여 데이터 set
 * 
 * @param 업체코드
 */
function getCustSch(gubn, value) {
	if(value != ""){
		
		$.ajax({
			method : "post",
			url : "/ajaxCustomer/search.do",
			data : {
				"getCusno" : value,
				"getComps" : $("#getComps").val()
			},
			success : function(res) {
				var data = JSON.parse(res);			
				
				if (data.list.length > 0) {
					if(gubn == "input") $('#getCusnm').val(data.list[0].cusnm);
				}
				else {
					toastMsg(LN_IO_CHK1 + " : " + value);
					if(gubn == "input") {
						$('#getPyvnd').val("");
						//$('#getCusnm').val("");					
					}
					if(gubn == "grid") grid.target.setValue(currGridIndex, "pyvnd", "");
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


/**
 * 팝업창에서 값넘겨받아 부모창에 데이터 set
 * 
 * @param returnValue
 */
function getReturnValue(returnValue) {
	if(returnValue !== null) {
		var custObj = JSON.parse(returnValue);

		$('#getPyvnd').val(custObj.cusno);
		$('#getCusnm').val(custObj.cusnm);
	}
}

/**
 * ======================================
 * [ko] 정보 검색하는 함수<br>
 * ======================================
 */
function search() {
	//gridBtnInit();
	
	if(!$(".getComps").val()){
		toastMsg(LN_SELECT_COMPS);
		return false;
	}else if(!$(".getPyvnd").val()){
		toastMsg(LN_SELECT_PYVND);
		return false;
	}
	
	var url = '/ajaxOrderDayITEMMst/search.do';
	var params = {
		'getComps' : $(".getComps").val(),
		'getPyvnd' : $(".getPyvnd").val()
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
 * 등록시 오류검증
 */
function validation(item){
	
	if(item.pspno==null || wijmo.isEmpty(item.pspno) || item.pspno == ""){
		alert("[품번]컬럼을 입력하세요");
		return false;
	}
	
	return true;
}


/**
	등록버튼
 */
function update(){

	/**
	 * 익스플로러에서 그리드외 다른영역으로 포커스가 빠졌을경우(클릭) 컬랙션뷰에서 변경된 내용을 인식하지 못하는 버그발생
	 * 아래처럼 포커스와 셀을 강제로 영역을 지정함.
	 */
	flexGrid.focus ();
	flexGrid.select( new wijmo.grid.CellRange( 0 , 0 , 0 , 0 ), true );
	
	if(flexGrid.rows.length < 1 && cv.itemsRemoved.length == 0){
		alert("등록할 내용이 없습니다.");
		return;
	} 
	
	//validation	
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
	
		
	var stateMsg=RESULT_OK;
	var isModify = false;
	
	// Update : 업데이트 프로세스 
    for ( var i = 0; i <cv.itemsEdited.length; i ++) {
    	alert("수정할 수 없습니다.");
     } 
	
	// Create : 생성 처리
    for ( var i = 0; i <cv.itemsAdded.length; i ++) {
    	console.debug(cv.itemsAdded[i]);
    	
		$.ajax({
			method : "post",
			url : "/ajaxOrderDayITEMMst/create.do",
			data : cv.itemsAdded[i],
			async: false,
			success : function(xhr) {
            	var data = JSON.parse(xhr);
            	
    			if (data.result != RESULT_OK) {
    				
    				if(data.errMsg == "LN_CHK7") stateMsg = LN_CHK7;
    				if(data.errMsg == "LN_INS_CHK1") stateMsg = LN_INS_CHK1;
				
				}     			
            },
            error : function() {
    			toastMsg("error");
    		},
    		complete : function() {
    			
    		}
		});
		
		isModify = true;
		
    } 
	
	// Delete : 삭제 처리 
    for ( var i = 0; i <cv.itemsRemoved.length; i ++) {
    	console.debug(cv.itemsRemoved[i]);
    	
		$.ajax({
			method : "post",
			url : "/ajaxOrderDayITEMMst/delete.do",
			data : cv.itemsRemoved[i],
            async: false,
            success : function(xhr) {
            	
            	var data = JSON.parse(xhr);
            	
            	if (data.result != RESULT_OK) {
    				if(data.errMsg == "LN_DEL_CHK1") stateMsg = LN_DEL_CHK1;
				} 
    		},
            error : function() {
    			toastMsg("error");
    		},
    		complete : function() {
    			
    		}
		});
		
		isModify = true;
    	
    }
	
	if(isModify){
		
		if(stateMsg == RESULT_OK){
    		toastMsg(RESULT_OK);
    		search();
	    	
	    }else{
	    	toastMsg(stateMsg);
	    }
			
	}else{
		toastMsg("등록할 내역이 없습니다.");
	}
   
}

// 엑셀다운 버튼 처리
function downloadExcel(){
	
	var fileName = '일일수주갱신 ITEM 제어마스타'+".xlsx";
	
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
	버튼 이벤트 처리
 */
function handleEvent(){

	//업체 선택버튼
	$('._custBtn_').on('click', function() {
		window.open("/ajaxCustomer/init.do","customerPop","width=550,height=600,scrollbars=yes,top=100,left=100");
	});
	
	//추가버튼	
	$("._addBtn_").on("click",function(){
	
		if(!$(".getComps").val() || !$(".getPyvnd").val()){
			toastMsg("조회 후 추가가능합니다.");
			return false;
		}
		
		var addRow = cv.addNew();
		addRow.comps = $(".getComps").val();
		addRow.pyvnd = $(".getPyvnd").val();
		cv.commitNew();
		
	});
		
	
	//행 삭제
	$("._delBtn").on("click",function(){
		cv.remove(cv.currentItem);
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
		{binding:'pspno',visible:false},
	    {binding:'oldPspno',visible:false},
        {binding: 'pspno', header: '* '+ LN_CHK_PSPNO, width: '*', wordWrap: true, align:'center',dataType:'String',maxLength:13  },  //wordWrap: true: 텍스트 자동줄바꿈 autorowHeights랑 같이 사용
        {binding: 'itdsc', header: LN_CHK_ITDSC, width: '*', align:'center', isReadOnly: true},
        {binding: 'carcd', header: LN_CHK_CARCD, width: '*', align:'center', isReadOnly: true},
        {binding: 'carnm', header: LN_CHK_CARNM, width: '*', align:'center', isReadOnly: true},
        {binding: 'bdycd', header: LN_CHK_BDYCD, width: '*', align:'center', isReadOnly: true},
        {binding: 'bdynm', header: LN_CHK_BDYNM, width: '*', align:'center', isReadOnly: true}
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
	
	//validation
	cv.getError = function(item,prop){
		switch(prop){
			case "pspno":
				
				if(item.pspno==null || wijmo.isEmpty(item.pspno) || item.pspno == ""){
					return "[품번]를 입력 하세요.";
				}
				return null;
		}
		return null;
	}

	//대문자 변경
	flexGrid.cellEditEnded.addHandler(function(s,e){
		var value = s.getCellData(e.row,e.col,false);
		
		if(s.columns[e.col].dataType==wijmo.DataType.String){
			s.setCellData(e.row,e.col,value.toUpperCase());
		}
		
	});
	
}


$(document.body).ready(function() {
	
	gridInit();  	//그리드 초기화
	gridEvent();	//그리드 이벤트
	handleEvent();	//프로그램 버튼 이벤트ㅡ
	
});