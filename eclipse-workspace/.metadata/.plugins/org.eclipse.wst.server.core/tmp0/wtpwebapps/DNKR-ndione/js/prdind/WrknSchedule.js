
var workMast = null;  //반복간격
var workMastMap = null;

// 컬랙션 뷰는 조회후에 그리드의 상태변경을 체크한다. 
var cv = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수

var flexGrid = new wijmo.grid.FlexGrid('#wijmoGrid');	//그리드 전역변수
var zoomSize = 11;

//var weekIntrMap = [{"weekIntr":"1"},{"weekIntr":"2"},{"weekIntr":"3"}];
var data2 = {"list":[{"weekIntr":"1","name":"1주"},{"weekIntr":"2","name":"2주"},{"weekIntr":"3","name":"3주"}]};
var weekIntrMast = null;
var weekIntrMastMap = null;
//var weekIntrMastMap = new wijmo.grid.DataMap(weekIntrMast, 'weekIntr', 'name'); 

/**
 * 팝업창에서 값넘겨받아 부모창에 데이터 set
 * 
 * @param returnValue
 */
function getReturnValue(returnValue) {
	if(returnValue !== null) {
		var custObj = JSON.parse(returnValue);

		$('#getLocId').val(custObj.code);
		$('#getLocNm').val(custObj.name);
	}
}

/**
 * 등록시 오류검증
 */
function validation(item){	
	
	if(item.rcRn==null || wijmo.isEmpty(item.rcRn) || item.rcRn ==""){
		toastMsg("수정이나 추가한 행의 [반복항목]컬럼을 입력 하세요");
		return false;
	}
	
	if(item.weekIntr==null || wijmo.isEmpty(item.weekIntr) || item.weekIntr ==""){
		toastMsg("수정이나 추가한 행의 [반복간격]컬럼을 입력 하세요");
		return false;
	}
	
	if(item.startDe==null || wijmo.isEmpty(item.startDe) || item.startDe ==""){
		toastMsg("수정이나 추가한 행의 [시작일]컬럼을 입력 하세요");
		return false;
	}else{
		var flag = isDatetimeValid(item.startDe);
		if(!flag) {
			toastMsg("시작일은 [yyyymmdd] 형식으로 입력해주세요.");
			return false;
		}		
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
		window.open("/ajaxPrdctIndComBase/initDeptPop.do","deptPop","width=550,height=620,scrollbars=yes,top=100,left=100");
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
		addRow.rownum = flexGrid.rows.length -1;
		cv.commitNew();				
		flexGrid.select(new wijmo.grid.CellRange(flexGrid.rows.length+1,0), true);		
	});
	
	// 그리드 row 삭제
	$("._delBtn").on("click",function(){
		var removeNum = flexGrid.selection.row;
		for(var i=removeNum;i<flexGrid.rows.length;i++){
			var rowNum = flexGrid.getCellData(i,'rownum')
			if(typeof rowNum != "undefined" && rowNum != "" && rowNum != null){		
				flexGrid.setCellData(i,'rownum',rowNum-1);
			}
		}		
		cv.remove(cv.currentItem);
	});
}


function search(){
	//validation 체크기능으로 입력칸에 커서가 활성화 되어있을경우 조회시 오류가 발생함.
	//validation edit 기능을 비활성화 시키고 조회시킴.
	flexGrid.validateEdits = false;			
	if(!$("#getComps").val()){
		toastMsg(LN_SELECT_COMPS);
		return false;
	}else if(!$("#getLocId").val()){
		toastMsg(LN_SELECT_DEPT);
		return false;
	}	
	
	var url = "/ajaxWrknSchedule/search.do";	
	var params = {
		'getComps' : $("#getComps").val()
		,'getLocId' : $("#getLocId").val()
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
//		toastMsg("등록할 내용이 없습니다.");
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
		console.log(cv.itemsEdited[i]);

		$.ajax({
			method : "post",
			url : "/ajaxWrknSchedule/update.do",
			data : cv.itemsEdited[i],
			async: false,
			success : function(xhr) {
    	    	var data = JSON.parse(xhr);
            	
    	    	if(data.result != RESULT_OK) {
					var rowNum = cv.itemsEdited[i].rownum;
					if(typeof rowNum != "undefined" && rowNum != "" && rowNum != null){						
						addErrorLineColor(flexGrid,rowNum);
					}			
    	    		if(data.errMsg == "LN_UPD_CHK1") stateMsg = LN_UPD_CHK1;
    				if(data.errMsg == "LN_UPD_CHK2") stateMsg = LN_UPD_CHK2;
    				if(data.errMsg == "LN_UPD_CHK3") stateMsg = LN_UPD_CHK3;
    				if(data.errMsg == "LN_UPD_CHK4") stateMsg = LN_UPD_CHK4;			
    			} 
				if(data.result == RESULT_OK){
					//성공시 rownum이 있으면 라인색상 제거
					var rowNum = cv.itemsEdited[i].rownum;
					if(typeof rowNum != "undefined" && rowNum != "" && rowNum != null){		
						removeErrorLineColor(flexGrid,rowNum);
					}
				}
    	    },
            error : function() {
				stateMsg = "error";
				var rowNum = cv.itemsEdited[i].rownum;
				addErrorLineColor(flexGrid,rowNum);	
    		},
    		complete : function() {
    			//toastMsg(stateMsg);
    		}
		});
		
		
		isModify = true;
		
     } 
    // Create : 생성 처리
    
    for ( var i = 0; i <cv.itemsAdded.length; i ++) {
    	console.debug(cv.itemsAdded[i]);
		
		$.ajax({
			method : "post",
			url : "/ajaxWrknSchedule/create.do",
			data : cv.itemsAdded[i],
			async: false,
			success : function(xhr) {
            	var data = JSON.parse(xhr);
            	
    			if (data.result != RESULT_OK) {
					var rowNum = cv.itemsAdded[i].rownum;
					addErrorLineColor(flexGrid,rowNum);	    				
    				if(data.errMsg == "LN_INS_CHK1") stateMsg = LN_INS_CHK1;
					if(data.errMsg == "LN_INS_CHK2") stateMsg = LN_INS_CHK2;
				}  
				if(data.result == RESULT_OK){
					//성공시 rownum이 있으면 라인색상 제거
					var rowNum = cv.itemsAdded[i].rownum;
					if(typeof rowNum != "undefined" && rowNum != "" && rowNum != null){		
						removeErrorLineColor(flexGrid,rowNum);
					}
				}					   			
            },
            error : function() {
				stateMsg = "error";
				var rowNum = cv.itemsAdded[i].rownum;
				addErrorLineColor(flexGrid,rowNum);	
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
			url : "/ajaxWrknSchedule/delete.do",
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


function getToday(){
	var date = new Date();
	return date.getFullYear() + "-" + ("0"+(date.getMonth()+1)).slice(-2) + "-" + ("0"+date.getDate()).slice(-2);
}

/**
 * 엑셀 다운로드
 */
function downloadExcel(){
	
	var fileName = "작업자정보관리마스타_"+getToday()+".xlsx";
	
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
		{binding:'locCode',visible:false},		
		{binding:'fullNm',header: '* '+ LB_FULL_NM, width: '*', align:'center',dataType:'String', maxLength:50,isReadOnly: true},		
		{binding:'empNumber',header: '* '+ LB_EMP_NUMBER, width: '*', align:'center',dataType:'String', maxLength:50,isReadOnly: true},		
		{binding:'startDe', header: '* ' + LB_START_DE, width: '*', align: 'center', dataType: 'String', maxLength: 10}, //시작일자
		{binding:'rcRn',header: '* '+ LB_WRKN_RCRN , width: '*', align:'center',dataType:'Number', format: 'n0', maxLength:2, dataMap: workMastMap},
		{binding:'weekIntr',header: '* '+ LB_WRKN_WEEK_INTR , width: '*', align:'center',dataType:'Number', format: 'n0', maxLength:7, dataMap: weekIntrMastMap},		
		{binding:'rownum',visible:false}		
	];	
	//컬럼 초기화
	flexGrid.initialize({
		columns: columnsDefinition
	});
}

function isDatetimeValid(data){
	var str = data.replace(/-/g,"");	
    var re = /[0-9]{4}(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])/;
	if(re.test(str)) {
		var intStr = Number(str);
		if(intStr > 0) {
			return true;
		}else {
			return false;
		}
	}else {
		return false;
	}
}

function gridEvent(){
	//validation
	cv.getError = function(item,prop){
		switch(prop){
//			case "clsCode":
//				if(item.clsCode==null || wijmo.isEmpty(item.clsCode) || item.clsCode == ""){
//					return "[사업부]을 입력해야 됩니다.";
//				}
//				return null;
			case "rcRn":
				if(item.rcRn==null || wijmo.isEmpty(item.rcRn) || item.rcRn == "" ){
					//return "[반복간격]을 입력하세요.";					
				}else{
					var flag = true;
					if(workMast != null) {					
						workMast.forEach (function (data, index) {			  		
							var mastCode = data.rcRn;							
							//var masterName = data.codeNm;
							var itemCode = item.rcRn;
							
							//if(itemCode != null) {
								//itemCode = itemCode.trim();
							//}
							if(mastCode != null) {
								mastCode = mastCode.trim();
							}						
							if(itemCode == mastCode) {
								//item.cpnNm = masterName;
								flag = false;
								return false;
							}
						});	
					}
					if(flag) {
						item.rcRn = "";
					}						
				}
				return null;
			case "startDe":
				var flag = false;
				if(item.startDe==null || wijmo.isEmpty(item.startDe) || item.startDe == "" ){
						//return "[시작일]]를 입력 하세요.";
				}else{
					var flag = isDatetimeValid(item.startDe);
					if(!flag) {
						return "날짜는 yyyymmdd 형식으로 입력해주세요.";
					}
				}
			
			case "weekIntr":
				var flag = false;
				if(item.weekIntr==null || wijmo.isEmpty(item.weekIntr) || item.weekIntr == "" ){
						//return "[시작일]]를 입력 하세요.";
				}else{
					var flag = true;
					if(weekIntrMast != null) {					
						weekIntrMast.forEach (function (data, index) {			  		
							var mastCode = data.weekIntr;							
							//var masterName = data.codeNm;
							var itemCode = item.weekIntr;
							//if(itemCode != null) {
								//itemCode = itemCode.trim();
							//}
							if(mastCode != null) {
								mastCode = mastCode.trim();
							}						
							if(itemCode == mastCode) {
								//item.cpnNm = masterName;
								flag = false;
								return false;
							}
						});	
					}
					if(flag) {
						item.weekIntr = "";
					}	
				}
//				if(!flag) {
//					return "날짜는 yyyymmdd 형식으로 입력해주세요.";
//				}
	
				//if(item.appendDe!=null && !wijmo.isEmpty(item.appendDe) && item.appendDe != "" ){
					//var iStartDe = item.startDe.replace(/-/g,"");						
					//var iendDe = item.appendDe.replace(/-/g,"");							

					//var itemStartDe = Number(iStartDe);
					//var itemEndDe = Number(iendDe);
					
//					if(itemEndDe < itemStartDe) {
//						return "시작일이 종료일 보다 큽니다.";
//					}
				//}
				return null;
		}
		return null;
	}
	
	flexGrid.pastedCell.addHandler(function(s,e){
		s.setCellData(e.row,"rownum",e.row,true);
	});
		
	/**
	 * 수정할경우 rownum 넣어주는 이벤트
	 * 기존에 cellEditEnded 이벤트에 넣어주니 같은값으로 변경될때도 rownum이 들어가는 오류와 
  	 * 수정을 안하고 input박스만 생성되는 경우도 rownum이 찍히는 버그가 발생하여 cellEditEnding 이벤트로 변경함. 
	 */
	flexGrid.cellEditEnding.addHandler(function(s,e){
		
		var oldVal = s.getCellData(e.row,e.col);
		if(typeof s.activeEditor != "undefined" && s.activeEditor != "" && s.activeEditor != null){			
			var newVal = s.activeEditor.value;
	       	
			if(oldVal!=newVal){
				s.setCellData(e.row,"rownum",e.row,true);
			}
		}
		

	});	
	
}

function initSetCodeMaster(){
	if($('#getComps').val() != ""){	
		$.ajax({
			method : "post",
			url : "/ajaxWrknSchedule/searchCode.do",
			data : {
				'getComps' : $("#getComps").val(),
				'getSe' : 'E'
			},
			success : function(res) {
				workMast = JSON.parse(res).list;
				workMastMap = new wijmo.grid.DataMap(workMast, 'rcRn', 'rcRn');
				weekIntrMast = data2.list;
				weekIntrMastMap = new wijmo.grid.DataMap(weekIntrMast, 'weekIntr', 'name');				 
				gridInit();
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
 * 부서코드로 업체명 검색하여 데이터 set
 * 
 * @param 업체코드
 */
function getDeptSch(gubn, value,s,e) {
	if(value != ""){
		$.ajax({
			method : "post",
			url : "/ajaxPrdctIndComBase/searchDeptMaster.do",
			data : {
				"getCode" : value,
				"getComps" : $("#getComps").val()
			},
			success : function(res) {
				var data = JSON.parse(res);			
				
				if (data.list.length > 0) {
					if(gubn == "input") $('#getLocNm').val(data.list[0].name);
				}
				else {
					toastMsg(LN_IO_CHK1 + " : " + value);
					if(gubn == "input") {
						$('#getLocCode').val("");
					}
					if(gubn == "grid"){
						var oldValue = s.getCellData(e.row,5,false);
						if(oldValue == "" || oldValue == null || oldValue == undefined) oldValue = "0"; // dataType:'Number' 에는 공백 초기화가 안됨.
						s.setCellData(e.row,e.col,oldValue);
					} 
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

function clearGrid() {
	cv.sourceCollection=[];
}


$(document.body).ready(function() {
	$.getScript('/js/sal/gridCommon.js').done(function() {
		commonGrid.init(flexGrid,cv); //그리드 공통부분	
		initSetCodeMaster();	
		gridInit();  	//그리드 초기화
		gridEvent();	//그리드 이벤트
		handleEvent();	//프로그램 버튼 이벤트
	});		
	
});
