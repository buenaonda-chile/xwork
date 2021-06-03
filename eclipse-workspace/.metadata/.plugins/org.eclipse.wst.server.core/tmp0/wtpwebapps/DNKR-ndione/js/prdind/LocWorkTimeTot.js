var lgsDstRtSum = 0;

// 컬랙션 뷰는 조회후에 그리드의 상태변경을 체크한다. 
var cv = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수

var flexGrid = new wijmo.grid.FlexGrid('#wijmoGrid');	//그리드 전역변수
var zoomSize = 11;
var lineCodeMast = null;
var itemMast = null;
var itemMast0 = null;

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
 * 더존 부서정보 취득
 */
function getDeptMaster() {
	if($('#getComps').val() != ""){	
		$.ajax({
			method : "post",
			url : "/ajaxPrdctIndComBase/searchDeptMaster.do",
			data : {
				'getComps' : $("#getComps").val()
			},
			success : function(res) {
				itemMast = JSON.parse(res).list;
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


function lineCodeSearch(){
	if(!$(".getComps").val()){
		return false;
	}
	var url = "/ajaxProdctIndctBaseLine/search.do";	
	var params = {
		'getComps' : $("#getComps").val(),
		'code' : '',
		'name' : ''		
	};
	
	mask.open();
	$.ajax({
		method : "post",
		url : url,
		data :params,
		success : function(res) {
			lineCodeMast = JSON.parse(res).list;
		},
		error : function() {
			console.log("dataset.error");
			return null;
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
 * 품목마스트 검색하여 데이터 set
 * 
 * @param 업체코드
 */
function getItemMaster() {
	if($('#getComps').val() != ""){	
		$.ajax({
			method : "post",
			url : "/ajaxPrdctIndComBase/searchItemMaster.do",
			data : {
				'getComps' : $("#getComps").val()
			},
			success : function(res) {
				itemMast = JSON.parse(res).list;
				console.log("===>"+itemMast[0].code);
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
/*

	$.ajax({
		method : "post",
		url : "/ajaxItemMaster/search.do",
		data : {
			'comps' : $("#getComps").val()
		},
		success : function(res) {
			var data = JSON.parse(res);			
			
			if (data.list.length > 0) {
				if(gubn == "input") $('#getItdsc').val(data.list[0].itdsc);
			}
			else {
				toastMsg(LN_CHK1 + " : " + value);
				if(gubn == "input") {
					$('#getPspno').val("");
										
				}
				if(gubn == "grid") grid.target.setValue(currGridIndex, "cinbr", "");
			}
		},
		error : function() {
			//console.log("dataset.error");
		},
		completed : function() {
			//console.log("dataset.completed");
		}
	});
*/
/**
 * 팝업창에서 값넘겨받아 부모창에 데이터 set
 * 
 * @param returnValue
 */
/**
function getReturnValue(returnValue) {
	if(returnValue !== null) {
		var custObj = JSON.parse(returnValue);

		$('#getPyvnd').val(custObj.cusno);
		$('#getCusnm').val(custObj.cusnm);
	}
}*/


/**
 * 등록시 오류검증
 */
function validation(item){	
	if(item.clsCode==null || wijmo.isEmpty(item.clsCode) || item.clsCode == ""){
		toastMsg("수정이나 추가한 행의 [사업부]컬럼을 입력해야 됩니다.");
		return false;
	}
	
	if(item.lineCode==null || wijmo.isEmpty(item.lineCode) || item.lineCode ==""){
		toastMsg("수정이나 추가한 행의 [라인코드]컬럼을 입력 하세요");
		return false;
	}

	if(item.prdtNo==null || wijmo.isEmpty(item.prdtNo) || item.prdtNo ==""){
		toastMsg("수정이나 추가한 행의 [제품코드]컬럼을 입력 하세요");
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
		window.open("/ajaxPrdctIndComBase/initDeptPop.do","deptPop","width=550,height=620,scrollbars=yes,top=100,left=100");
	});
	
	//행 추가버튼
	$("._addBtn_").on("click",function(){

		if(!$("#getYear").val()){
			toastMsg("년도를 입력 하세요.");
			return false;
		}
		var addRow = cv.addNew();
		addRow.clsCode = $("#getComps").val();
		addRow.year = $("#getYear").val();
		addRow.fsHalf = $("#getFsHalf").val();		
		addRow.rownum = flexGrid.rows.length -1;		
		cv.commitNew();	
		flexGrid.select(new wijmo.grid.CellRange(flexGrid.rows.length+1,0), true);	

			
	});
	
	// 그리드 row 삭제
	$("._delBtn").on("click",function(){
		var removeNum = flexGrid.selection.row;
		
		for(var i=removeNum;i<flexGrid.rows.length;i++){
			var rownum = flexGrid.getCellData(i,'rownum')
			if(typeof rownum != "undefined" && rownum != "" && rownum != null){
				flexGrid.setCellData(i,'rownum',rownum-1);
			}
		}		

		cv.remove(cv.currentItem);
	});
}

//년도
function isDateValid(d){
	var re = /[0-9]{4}/;
    return re.test(d);
}


function search(){
	//validation 체크기능으로 입력칸에 커서가 활성화 되어있을경우 조회시 오류가 발생함.
	//validation edit 기능을 비활성화 시키고 조회시킴.
	flexGrid.validateEdits = false;
	
	/**
	if(!$("#getYear").val()){
		toastMsg("년도를 입력 하세요.");
		return false;
	}else {
		var year = $("#getYear").val();
		if(!isDateValid(year)) {
			toastMsg("년도는 yyyy 형식입니다.");
			return false;
		}
	}*/
	
	if(!$("#getComps").val()){
		toastMsg(LN_SELECT_COMPS);
		return false;
	}/*else if(!$("#getLocId").val()){
		toastMsg(LN_SELECT_DEPT);
		return false;
	}*/	
	
	var url = "/ajaxLocWorkTimeTot/search.do";	
	var params = {
		'getComps' : $("#getComps").val(),
		'getRepym' : $(".getDumcb").val().replace(/-/gi, ""),
		
		//'getYear' : $("#getYear").val(),
		'getLocId' : $("#getLocId").val()				
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
		console.log(cv.itemsEdited[i]);

		$.ajax({
			method : "post",
			url : "/ajaxLocWorkTimeTot/update.do",
			data : cv.itemsEdited[i],
			async: false,
			success : function(xhr) {
    	    	var data = JSON.parse(xhr);
    	    	if(data.result != RESULT_OK) {
					var rowNum = cv.itemsEdited[i].rownum;
					
					//오류시 행라인 색생 표시 (그리드명,행번) 넘겨줘야함.
					//jsp파일에 .redRow css 정의되어 있음. 각jsp파일에 선언하거나 공통으로 사용되는 css에 넣어줘야함.
					addErrorLineColor(flexGrid,rowNum);
						
   	    			if(data.errMsg == "LN_UPD_CHK1") stateMsg = LN_UPD_CHK1;
    				if(data.errMsg == "LN_UPD_CHK2") stateMsg = LN_UPD_CHK2;
    				if(data.errMsg == "LN_UPD_CHK3") stateMsg = LN_UPD_CHK3;
    				if(data.errMsg == "LN_UPD_CHK4") stateMsg = LN_UPD_CHK4;			
			
    			} 
				if(data.result == RESULT_OK){
					//성공시 rownum이 있으면 라인색상 제거
					var rowNum = cv.itemsEdited[i].rownum;
					if(typeof rownum != "undefined" && rownum != "" && rownum != null){
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
			url : "/ajaxLocWorkTimeTot/create.do",
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
					if(typeof rownum != "undefined" && rownum != "" && rownum != null){
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
			url : "/ajaxLocWorkTimeTot/delete.do",
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
	
	var fileName = "품번별생산성실적_"+getToday()+".xlsx";
	
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

function gridInit(){

//	var comsBase = new DataMap(coms_base, 'id', 'name');
	var columnsDefinition=[
		{binding:'rownum',visible:false},	
		{binding:'clsCode',visible:false},
		//{binding:'partCode',header: ''+ LB_CODE,width: '*', align:'center',dataType:'String', maxLength:4}, //부서파트
		{binding:'partCode',header: '파트',width: '*', align:'center',dataType:'String', maxLength:4}, //부서파트
		{binding:'partNm'  ,header: '파트명',width: '*', align:'center',dataType:'String', maxLength:50,isReadOnly: true},
		{binding:'locCode' ,header: '부서(반)',width: '*', align:'center',dataType:'String', maxLength:4},
		{binding:'locNm'   ,header: '부서명',width: '*', align:'center',dataType:'String', maxLength:50,isReadOnly: true},
		{binding:'totPo'   ,header: '총원(명)',width: '*', align:'center',dataType:'String', maxLength:4},
		{binding:'absentPo',header: '결근(명)',width: '*', align:'center',dataType:'String', maxLength:4},
		{binding:'vacationTot' 	,header: '휴가(명)',width: '*', align:'center',dataType:'String', maxLength:4},
		{binding:'injuryTot' 	,header: '공상(명)',width: '*', align:'center',dataType:'String', maxLength:4},
		{binding:'sickLeaveTot'	,header: '병가(명)',width: '*', align:'center',dataType:'String', maxLength:4},
		{binding:'gotoWorkPo' 	,header: '출근(명)',width: '*', align:'center',dataType:'String', maxLength:4},
		{binding:'lrlyLatenTime',header: '조퇴지각(HR)',width: '*', align:'center',dataType:'String', maxLength:4},
		{binding:'overtimeSum'	,header: '잔업(HR)',width: '*', align:'center',dataType:'String', maxLength:4},
		{binding:'bHrMnt'		,header: '제외시간(HR)',width: '*', align:'center',dataType:'String', maxLength:4},
		{binding:'cHrMnt'		,header: '간접시간(HR)',width: '*', align:'center',dataType:'String', maxLength:4},
		{binding:'ptm'			,header: '직접시간(HR)',width: '*', align:'center',dataType:'String', maxLength:4},
		{binding:'totHrMnt'		,header: '총투입시간(HR)',width: '*', align:'center',dataType:'String', maxLength:4},
		
		/*{binding:'lineCode',header: ''+ LB_LINE_CODE,width: '*', align:'center',dataType:'String', maxLength:4,isReadOnly: true},
		{binding:'lineNm',header: ''+ LB_LINE_NM, width: 150, align:'left',dataType:'String', maxLength:50,isReadOnly: true},
		{binding:'prdtNo',header: ''+ LB_ITEM_CODE, width: 150, align:'center',dataType:'String', maxLength:50,isReadOnly: true},		
		{binding:'prdtNm',header: ''+ LB_ITEM_NM, width: 200, align:'left',dataType:'String', maxLength:50,isReadOnly: true},*/				

	/*	{binding:'cycleTime',header: ''+ LB_CYCLE_TIME, width: '*', align:'right',dataType:'Number', format: 'n3', maxLength:4,isReadOnly: true},	//C/T(sec)								
		{binding:'jmLabor',header: ''+ LB_JM_LABOR, width: '*', align:'right',dataType:'Number', format: 'n3', maxLength:4,isReadOnly: true},		//정미공수											
		{binding:'stdrLabor',header: ''+ LB_STDR_LABOR, width: '*', align:'right',dataType:'Number', format: 'n3', maxLength:10,isReadOnly: true},	//생산성기준공수(sec)=정미공수×여유계수															
	
		{binding:'resultManHour',header: ''+ LB_RESULT_MAN_HOUR, width: '*', align:'right',dataType:'Number', format: 'n3', maxLength:8,isReadOnly: true},
		{binding:'totalQY',header: ''+ LB_TOTAL_QY, width: '*', align:'right',dataType:'Number', format: 'n3', maxLength:8,isReadOnly: true},	
		{binding:'jmBaseTime',header: ''+ LB_JM_BASE_TIME, width: '*', align:'right',dataType:'Number', format: 'n3', maxLength:8,isReadOnly: true},	
		{binding:'indexPlan',header: ''+ LB_INDEX_PLAN, width: '*', align:'right',dataType:'Number', format: 'n3', maxLength:8,isReadOnly: true},	
		{binding:'indexResult',header: ''+ LB_INDEX_RESULT, width: '*', align:'right',dataType:'Number', format: 'n3', maxLength:8,isReadOnly: true},
		{binding:'prodIndex',header: ''+ LB_PROD_INDEX, width: '*', align:'right',dataType:'Number', format: 'n3', maxLength:8,isReadOnly: true},	*/		
		
		{binding:'oldLineCode',visible:false},		
		{binding:'oldPrdtNo',visible:false},
		{binding:'year',visible:false},
		{binding:'fsHalf',visible:false},
		{binding:'oldYear',visible:false},
		{binding:'oldFsHalf',visible:false}									
	];	
	//컬럼 초기화
	flexGrid.initialize({
		columns: columnsDefinition
	});
	flexGrid.columnHeaders.rows.defaultSize = 60; 	// 열 헤더 영역에 행의 높이 설정
}

function isCodeValid(d){
	var re = /^[A-Za-z0-9-+]*$/;
    return re.test(d);
}

function gridEvent(){
	
	cv.getError = function(item,prop){
		switch(prop){
			case "lineCode":
				if(item.lineCode==null || wijmo.isEmpty(item.lineCode) || item.lineCode == "" ){
					return "[라인코드]를 입력 하세요.";
				}else{
					var flag = isCodeValid(item.lineCode);
					if(!flag) {
						item.lineCode = "";
						item.lineNm = "";
					}
				}
				return null;
			case "prdtNo":
				if(item.prdtNo==null || wijmo.isEmpty(item.prdtNo) || item.prdtNo == "" ){
					return "[제품코드]를 입력 하세요.";
				}		
				return null;
			case "locCode":
				if(item.locCode==null || wijmo.isEmpty(item.locCode) || item.locCode == "" ){
//					item.locNm = "";
					return "[부서(반)]를 입력 하세요.";
				}else{
					var flag = true;
					itemMast.forEach (function (data, index) {			  		
						var code = data.code;
						var name = data.name;	
						var trimCode = "";	
						if(code != null) {
							trimCode = code.trim();
						}
						var locCode = item.locCode;
						var trimLocCode = locCode.trim();
						if(trimLocCode == trimCode) {
							item.locNm = name;
							flag = false;
							return false;
						}
					});	
					if(flag) {
						item.locCode = "";						
						item.locNm = "";
					}
				}
				return null;
			case "partCode":
			console.log("xxxxxxxxxxxxxxxxxxxxxxxxx");
				if(item.partCode==null || wijmo.isEmpty(item.partCode) || item.partCode == "" ){
//					item.locNm = "";
					return "[부서(Part)]를 입력 하세요.";
				}else{
					var flag = true;
					itemMast.forEach (function (data, index) {			  		
						var code = data.code;
						var name = data.name;	
						var trimCode = "";	
						if(code != null) {
							trimCode = code.trim();
						}
						var partCode = item.partCode;
						var trimLocCode = partCode.trim();
						if(trimLocCode == trimCode) {
							item.partNm = name;
							flag = false;
							return false;
						}
					});	
					if(flag) {
						item.partCode = "";						
						item.partNm = "";
					}
				}
				return null;	
		}
		return null;
	}

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
				if(e.col == 6 || e.col == 7 || e.col == 8 || e.col == 9 || e.col == 10 || e.col == 15 ) {
					s.setCellData(e.row,e.col,newVal,true);
					//calFunction(s, e);
				}
				s.setCellData(e.row,"rownum",e.row,true);
			}
		}
	});
	
	flexGrid.cellEditEnded.addHandler(function(s,e){
		var value = s.getCellData(e.row,e.col,false);
		if(s.columns[e.col].dataType==wijmo.DataType.String){
			value = value.trim();
		}

		//라인코드
		if(e.col == 2) {
			var flag = true;
			if(value==null || wijmo.isEmpty(value) || value == "" ){
				
			}else{
				var flag = true;
				lineCodeMast.forEach (function (data, index) {		
					var code = data.lineCode;	  		
					var trimCode = code.trim();
					var itemCode = value.trim();
					if(itemCode == trimCode) {
						var name = data.lineNm;
						s.setCellData(e.row,e.col+1,name); //라인명
//						item.prdtNm = data.name;
						flag = false;
						return false;
					}
				});	
				if(flag) {
					s.setCellData(e.row,e.col,""); //라인코드
					s.setCellData(e.row,e.col+1,""); //라인명
				}
			}
		}
		
		//제품코드1
		if(e.col == 4) {
			var flag = true;
			if(value==null || wijmo.isEmpty(value) || value == "" ){
				
			}else{
				var flag = true;
				itemMast.forEach (function (data, index) {			  		
					var code = data.code;
					var trimCode = code.trim();
					var itemCode = value.trim();
					if(itemCode == trimCode) {
						var name = data.name;
						s.setCellData(e.row,e.col+1,name); //제품명
//						item.prdtNm = data.name;
						flag = false;
						return false;
					}
				});	
				if(flag) {
					s.setCellData(e.row,e.col,""); //제품명					
					s.setCellData(e.row,e.col+1,""); //제품명
				}
			}
		}
		
//		if(s.columns[e.col].dataType==wijmo.DataType.String){
//			s.setCellData(e.row,e.col,value.toUpperCase());
//		}
		
	});
}

function getYear(){
	var date = new Date();
	return date.getFullYear();
}

function calFunction(s, e){
	var cycleTime = s.getCellData(e.row,6,false);
	var drctHdcn = s.getCellData(e.row,7,false);	
	var indrHdcn = s.getCellData(e.row,8,false);	
	var jmLabor = s.getCellData(e.row,9,false);	
	var prfrTime = s.getCellData(e.row,10,false);		
	var excIndRt = s.getCellData(e.row,15,false);	
	
	var mrgFct = Number(prfrTime)/Number(jmLabor); //여유계수(계산)	
	var stdrLabor = Number(jmLabor)*mrgFct; //정미공수(계산)	
	var sgmRgsArb = stdrLabor/(1-Number(excIndRt));  //시그마등록공수(S)(계산)
	var uph = 3600 / Number(cycleTime);	//uph
	
	s.setCellData(e.row,11,mrgFct); //여유계수(계산)	
	s.setCellData(e.row,12,stdrLabor); //정미공수(계산)	
	s.setCellData(e.row,16,sgmRgsArb); //시그마등록공수(S)(계산)	
	s.setCellData(e.row,17,uph); //uph	
	
}

function initSetMaster(){
	lineCodeSearch(); //라인코드
	getItemMaster(); //제품Master정보 취득
	clearGrid();
}

function clearGrid() {
	cv.sourceCollection=[];
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

function calendar(){
	var chk_calendar = new ax5.ui.calendar({
        target: document.getElementById("chk_calendar"),
        control: {
            left: '<i class="fa fa-chevron-left"></i>',
            yearTmpl: '%s',
            monthTmpl: '%s',
            right: '<i class="fa fa-chevron-right"></i>',
            yearFirst: true
        },
        displayDate: (new Date()),
		mode: "month",
    	selectMode: "month",
		dateFormat: 'yyyy-MM', // yyyy-mm-dd 
        dimensions: {
            height: 250,
            controlHeight: 40,
            itemPadding: 1
        },
        lang: {
        	/*yearTmpl: "%s년",*/
            /*months: ['일월', '이월', '삼월', '사월', '오월', '육월', '칠월', '팔월', '구월', '시월', '십일월', '십이월'],*/
        	yearTmpl: YEAR_FORMAT,
        	months: MONTH
        },
        onClick: function () {
            $(this.target).css('display', 'none');
			var date = JSON.stringify(chk_calendar.getSelection());
            $(this.target).prev().val(date.substring(2,9));
        },
        onStateChanged: function () {
            //console.log(this);
        }
    });
	
	$('.log_board .dropdown').on('click', function(e){
		$($(e.target).next('.dropdown-menu')).css('display', 'block');
	});
}


$(document.body).ready(function() {
	$.getScript('/js/sal/gridCommon.js').done(function() {
		commonGrid.init(flexGrid,cv); //그리드 공통부분
		getDeptMaster(); //부서
		gridInit();  	//그리드 초기화
		gridEvent();	//그리드 이벤트
		handleEvent();	//프로그램 버튼 이벤트
		//lineCodeSearch(); //라인코드
		//getItemMaster(); //제품Master정보 취득
		calendar(); //캘린더
		//var nowYear = getYear();
		//$("#getYear").val(nowYear);
	});		
});
