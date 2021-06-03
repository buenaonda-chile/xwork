var lgsDstRtSum = 0;

// 컬랙션 뷰는 조회후에 그리드의 상태변경을 체크한다. 
var cv = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수

var flexGrid = new wijmo.grid.FlexGrid('#wijmoGrid');	//그리드 전역변수
var zoomSize = 11;


/**
 * 업체코드로 업체명 검색하여 데이터 set
 * 
 * @param 업체코드
 */
function getCustSch() {
	if($('#getPyvnd').val() != ""){	
		$.ajax({
			method : "post",
			url : "/ajaxCustomer/search.do",
			data : {
				"getCusno" : $("#getPyvnd").val()
			},
			success : function(res) {
				var data = JSON.parse(res).list;
				cv.sourceCollection = data;
			},
			error : function() {
				console.log("dataset.error");
			},
			completed : function() {
				setTimeout(function() {
					mask.close();				
				}, 500);
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
 * 등록시 오류검증
 */
function validation(item){	
	if(item.clsCode==null || wijmo.isEmpty(item.clsCode) || item.clsCode == ""){
		alert("수정이나 추가한 행의 [사업부]컬럼을 입력해야 됩니다.");
		return false;
	}
	
	if(item.lineCode==null || wijmo.isEmpty(item.lineCode) || item.lineCode ==""){
		alert("수정이나 추가한 행의 [라인코드]컬럼을 입력 하세요");
		return false;
	}

	return true;
}


function handleEvent(){
//	$('.getPyvnd').on('change', function() {
//		$(".getCusnm").val("");
//	});

	
	//등록폼 닫기버튼
	$("._closeBtn_").on("click",function(){
		var target = this.getAttribute("data-click-target");
		addBtnUiSet(this);
	});

	$('._custBtn_').on('click', function() {
		window.open("/ajaxCustomer/init.do","customerPop","width=550,height=600,scrollbars=yes,top=100,left=100");
	});
	
	//행 추가버튼
	$("._addBtn_").on("click",function(){
/*		
		if(!$(".getComps").val()){
			toastMsg(LN_SELECT_COMPS);
			return false;
		}else if(!$(".getPyvnd").val()){
			toastMsg(LN_SELECT_PYVND);
			return false;
		}
*/		
		var addRow = cv.addNew();
		addRow.clsCode = $(".getComps").val();
		cv.commitNew();		
//		addRow.pyvnd = $(".getPyvnd").val();
		
	});
	
	// 그리드 row 삭제
	$("._delBtn").on("click",function(){
		cv.remove(cv.currentItem);
	});
}


function search(){
	if(!$(".getComps").val()){
//		toastMsg(LN_SELECT_COMPS);
		return false;
	}
	var url = "/ajaxLgstTimeDstrRtBase/search.do";	
	var params = {
		'getComps' : $("#getComps").val()
//		,'code' : $("#code").val()
//		,'name' : $("#name").val()		
	};
	
	mask.open();
	$.ajax({
		method : "post",
		url : url,
		data :params,
		success : function(res) {
			var data = JSON.parse(res).list;
			cv.sourceCollection = data;
			
//			for(var i=0; i<data.length; i ++ ) {
//				lgsDstRtSum = lgsDstRtSum + Number(data[i].lgsDstRt);
//			}
			
//			flexGrid.columnFooters.setCellData(0, 3, lgsDstRtSum);

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

//수정
function update(){
	/**
	 * 익스플로러에서 그리드외 다른영역으로 포커스가 빠졌을경우(클릭) 컬랙션뷰에서 변경된 내용을 인식하지 못하는 버그발생
	 * 아래처럼 포커스와 셀을 강제로 영역을 지정함.
	 */
	flexGrid.focus ();
	flexGrid.select( new wijmo.grid.CellRange( 0 , 0 , 0 , 0 ), true );
	
		
//	if(flexGrid.rows.length<1){
//		alert("등록할 내용이 없습니다.");
//		return;
//	} 
	
	//validation	
	for ( var i = 0; i <cv.itemsAdded.length; i ++) {
		if(!validation(cv.itemsAdded[i])){
			return false;
		}	
		isModify = true;
	}
	
	for ( var i = 0; i <cv.itemsEdited.length; i ++) {
		if(!validation(cv.itemsEdited[i])){
			return false;
		}	
		isModify = true;
	}
	
	
	var stateMsg=RESULT_OK;
	var isModify = false;
	
	// Update : 업데이트 프로세스 
    for ( var i = 0; i <cv.itemsEdited.length; i ++) {
		updateGrid(cv.itemsEdited[i]);
		isModify = true;
	}
	
 	// Create : 생성 처리
    for ( var i = 0; i <cv.itemsAdded.length; i ++) {
		insertGrid(cv.itemsAdded[i]);
		isModify = true;
	}

    // Delete : 삭제 처리 
    for ( var i = 0; i <cv.itemsRemoved.length; i ++) {
		deleteGrid(cv.itemsRemoved[i]);
		isModify = true;
	}
	
	if(isModify){
		if(stateMsg == RESULT_OK){
    		search();
	    }else{
	    	toastMsg(stateMsg);
	    }
	}	
	
}

/**
 * 스프레드 추가
 */
function insertGrid(item){
	
	$.ajax({
		method : "post",
		url : "/ajaxLgstTimeDstrRtBase/create.do",
		data : item,
		async: false,
		success : function(res) {
			var data = JSON.parse(res);
			if (data.result === RESULT_OK) {
				toastMsg(RESULT_OK);
			} else {

				setTimeout(function() {
					toastMsg(data.errMsg);
//					if(data.errMsg == "LN_INS_CHK1") toastMsg(LN_INS_CHK1);
//					if(data.errMsg == "LN_INS_CHK2") toastMsg(LN_INS_CHK2);
				}, 500);
				
			}
		},
		error : function() {
			toastMsg("error");
		},
		complete : function() {
			
		}
	});
	
}


/**
 * 스프레드 수정
 */
function updateGrid(item){
	var stateMsg = "OK";
	$.ajax({
		url : "/ajaxLgstTimeDstrRtBase/update.do",
		type : "post",
		data : item,
		async: false,
		success : function(res) {
			var data = JSON.parse(res);
			if(data.result === RESULT_OK) {
				stateMsg = "OK";
			} else {
				//stateMsg = data.errMsg;
				
	//			if(data.errMsg == "LN_UPD_CHK1") stateMsg = LN_UPD_CHK1;
	//			if(data.errMsg == "LN_UPD_CHK2") stateMsg = LN_UPD_CHK2;				
	//			if(data.errMsg == "LN_UPD_CHK3") stateMsg = LN_UPD_CHK3;
			}
			
		},
		error : function() {
			stateMsg = "error";
		},
		complete : function() {
			toastMsg(stateMsg);
		}
	});	
}

function deleteGrid(item){
	
	$.ajax({
		url : "/ajaxLgstTimeDstrRtBase/delete.do",
		type : "get",
		data : item,
		async: false,
		success : function(res) {
			//console.log("delete.success");
			var data = JSON.parse(res);
			if(data.result === "OK") {
				stateMsg = "OK";
			} else {
				//console.log("err");
				stateMsg = data.errMsg?data.errMsg:"";
			}
		},
		error : function() {
			stateMsg = "error";
		},
		complete : function() {
			setTimeout(function() {
	//			if(stateMsg == "LN_DEL_CHK1") toastMsg(LN_DEL_CHK1);
	//			else toastMsg(stateMsg);
			}, 1000);
		}
	});
	
}

/**
 * 엑셀 다운로드
 */
function downloadExcel(){
	
	var fileName = '물류시간배분비율관리마스타.xlsx';
	
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

function gridInit(){
//	var comsBase = new DataMap(coms_base, 'id', 'name');
	var columnsDefinition=[	
		{binding:'clsCode',visible:false},				
		{binding:'lineCode',header: '* '+ LB_LINE_CODE,width: '*', align:'center',dataType:'String', maxLength:4,isReadOnly: true},
		{binding:'lineNm',header: '* '+ LB_LINE_NM, width: '*', align:'left',dataType:'String', maxLength:50,isReadOnly: true},
		{binding:'lgsDstRt',header: '* '+ LB_LGS_DST_RT, width: '*', align:'center',dataType:'Number', format: 'n1', maxLength:10, aggregate: 'Sum'}
	];	
	//컬럼 초기화
	flexGrid.initialize({
		columns: columnsDefinition
	});
}

function gridEvent(){
	//validation
	cv.getError = function(item,prop){
		switch(prop){
			case "clsCode":
				if(item.clsCode==null || wijmo.isEmpty(item.clsCode) || item.clsCode == ""){
					return "[사업부]을 입력해야 됩니다.";
				}
				return null;
				
			case "lineCode":
				if(item.lineCode==null || wijmo.isEmpty(item.lineCode) || item.lineCode == "" ){
					return "[라인코드]을 입력 하세요.";
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
	$.getScript('/js/sal/gridCommon.js').done(function() {
		commonGrid.init(flexGrid,cv); //그리드 공통부분			
		gridInit();  	//그리드 초기화
		gridEvent();	//그리드 이벤트
		handleEvent();	//프로그램 버튼 이벤트
	});		
	
});
