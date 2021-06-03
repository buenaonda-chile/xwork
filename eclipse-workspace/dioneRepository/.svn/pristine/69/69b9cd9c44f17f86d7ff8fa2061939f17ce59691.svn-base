//code intellisense typescript 정의
///<reference path = "../../wijmo/controls/wijmo.d.ts"/>	
///<reference path = "../../wijmo/controls/wijmo.grid.d.ts"/>
///<reference path = "../../wijmo/controls/wijmo.input.d.ts"/>

var lgsDstRtSum = 0;

var workMast = null;  //빵,쿠폰 마스트

// 컬랙션 뷰는 조회후에 그리드의 상태변경을 체크한다. 
var cv = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수

var flexGrid = new wijmo.grid.FlexGrid('#wijmoGrid');	//그리드 전역변수
var zoomSize = 11;
var baseLgstTime = 0;

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
	if(item.clsCode==null || wijmo.isEmpty(item.clsCode) || item.clsCode == ""){
		alert("수정이나 추가한 행의 [사업부]컬럼을 입력해야 됩니다.");
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
		addRow.locCode = $(".getLocId").val();		
		cv.commitNew();		
		flexGrid.select(new wijmo.grid.CellRange(flexGrid.rows.length+1,0), true);		
		
	});
	
	// 그리드 row 삭제
	$("._delBtn").on("click",function(){
		cv.remove(cv.currentItem);
	});
}


function search(){
	if(!$("#getComps").val()){
		toastMsg(LN_SELECT_COMPS);
		return false;
	}else if(!$("#getLocId").val()){
		toastMsg(LN_SELECT_DEPT);
		return false;
	}else if(!$("#opertDe").val()){
		toastMsg("작업일자를 입력해주세요.");
		return false;
	}	
	
	
	var url = "/ajaxLnPrsInpTm/search.do";	
	var params = {
		'getComps' : $("#getComps").val()
		,'getLocId' : $("#getLocId").val()
		,'getOpertDe' : $("#opertDe").val()	
	};
	
	mask.open();
	$.ajax({
		method : "post",
		url : url,
		data :params,
		success : function(res) {
			var data = JSON.parse(res).list;
			var resBaseLgstTime = JSON.parse(res).baseLgstTime;	
			var resBaseHrMntSum = JSON.parse(res).baseHrMntSum;	
			var prSnlSum = JSON.parse(res).prSnlSum;				
			var reqWork = JSON.parse(res).reqWork;							
			var ruling = JSON.parse(res).ruling;							
						
			$("#reqWork").val(reqWork);   //특근신청 총작업시간								
			$("#ttlLgst").val(resBaseLgstTime); //특근신청물류시간
			$("#getLgstTm").val(prSnlSum);   //저장된 물류시간	
			$("#ruling").val(ruling);   //판정			
			$("#ttlWork").val(resBaseHrMntSum);   //총작업시간

			cv.sourceCollection = data;
			setRowReadOnly();
			
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

function clearGrid(){
	cv.sourceCollection=[];
}

//수정
function update(){
	/**
	 * 익스플로러에서 그리드외 다른영역으로 포커스가 빠졌을경우(클릭) 컬랙션뷰에서 변경된 내용을 인식하지 못하는 버그발생
	 * 아래처럼 포커스와 셀을 강제로 영역을 지정함.
	 */
	flexGrid.focus ();
	flexGrid.select( new wijmo.grid.CellRange( 0 , 0 , 0 , 0 ), true );

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
		chkItem = cv.itemsEdited[i];
		$.ajax({
			method : "post",
			url : "/ajaxLnPrsInpTm/update.do",
			data : cv.itemsEdited[i],
			async: false,
			success : function(xhr) {
    	    	var data = JSON.parse(xhr);
    	    	if(data.result != RESULT_OK) {
					var rowNum = cv.itemsEdited[i].rownum;
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
				var rowNum = cv.itemsAdded[i].rownum;
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
			url : "/ajaxLnPrsInpTm/create.do",
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
			url : "/ajaxLnPrsInpTm/delete.do",
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

	//물류시간 갱신
	lgstTmUpdate();

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


/**
 * 엑셀 다운로드
 */
function downloadExcel(){

	var fileName = "라인인원투입시간등록_"+getToday()+".xlsx";	
	
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


//물류시간
function lgstTmUpdate() {
	if(!$("#getComps").val()){
		toastMsg(LN_SELECT_COMPS);
		return false;
	}else if(!$("#getLocId").val()){
		toastMsg(LN_SELECT_DEPT);
		return false;
	}else if(!$("#opertDe").val()){
		toastMsg("작업일자를 입력해주세요.");
		return false;
	}		
	
	var stateMsg=RESULT_OK;	
	var paramsData = {
		'getComps' : $("#getComps").val()
		,'getLocId' : $("#getLocId").val()
		,'getOpertDe' : $("#opertDe").val()		
		,'getLgstTm' : $("#getLgstTm").val()		
	};
	
	$.ajax({
		method : "post",
		url : "/ajaxStEmpAbsTrd/SaveLgstTm.do",
		data : paramsData,
		async: false,
		success : function(xhr) {
        	var data = JSON.parse(xhr);
			if (data.result != RESULT_OK) {
				if(data.errMsg == "LN_INS_CHK1") stateMsg = LN_INS_CHK1;
				if(data.errMsg == "LN_INS_CHK2") stateMsg = LN_INS_CHK2;
			}
//			if (data.result == RESULT_OK) {
//				changeRgstTime();
//			}			
		
        },
        error : function() {
			toastMsg("error");
		},
		complete : function() {

		}
	});

}


function gridInit(){
//	var comsBase = new DataMap(coms_base, 'id', 'name');

	var columnsDefinition=[	
		{binding:'clsCode',visible:false},				
		{binding:'locCode',visible:false},
		{binding:'lineCode',visible:false},
		{binding:'opertDe',visible:false},
		{binding:'type',visible:false},		
		{binding:'lineNm',header: '라인명', width: 150, align:'center',dataType:'String', maxLength:50,isReadOnly: true, allowMerging :true},		
		{binding:'dayTit',header: '대상일자', width: '*', align:'center',dataType:'String', maxLength:50,isReadOnly: true},		
		{binding:'lgstTime',header: '물류시간', width: '*', align:'center',dataType:'String', maxLength:50,isReadOnly: true},				
		{ header: '1', align: 'center',  columns: [
			{binding:'prsnl1',header: '인원(명)', width: '*', align:'right',dataType:'Number', format: 'n2', maxLength:8},
			{binding:'hrMnt1',header: '시간(분)', width: '*', align:'right',dataType:'Number', format: 'n0', maxLength:8},
		]},
		{ header: '2', align: 'center',  columns: [
			{binding:'prsnl2',header: '인원(명)', width: '*', align:'right',dataType:'Number', format: 'n2', maxLength:8},
			{binding:'hrMnt2',header: '시간(분)', width: '*', align:'right',dataType:'Number', format: 'n0', maxLength:8},
		]},
		{ header: '3', align: 'center',  columns: [
			{binding:'prsnl3',header: '인원(명)', width: '*', align:'right',dataType:'Number', format: 'n2', maxLength:8},
			{binding:'hrMnt3',header: '시간(분)', width: '*', align:'right',dataType:'Number', format: 'n0', maxLength:8},
		]},		
		{ header: '4', align: 'center',  columns: [
			{binding:'prsnl4',header: '인원(명)', width: '*', align:'right',dataType:'Number', format: 'n2', maxLength:8},
			{binding:'hrMnt4',header: '시간(분)', width: '*', align:'right',dataType:'Number', format: 'n0', maxLength:8},
		]},
		{ header: '5', align: 'center',  columns: [
			{binding:'prsnl5',header: '인원(명)', width: '*', align:'right',dataType:'Number', format: 'n2', maxLength:8},
			{binding:'hrMnt5',header: '시간(분)', width: '*', align:'right',dataType:'Number', format: 'n0', maxLength:8},
		]},
		{ header: '6', align: 'center',  columns: [
			{binding:'prsnl6',header: '인원(명)', width: '*', align:'right',dataType:'Number', format: 'n2', maxLength:8},
			{binding:'hrMnt6',header: '시간(분)', width: '*', align:'right',dataType:'Number', format: 'n0', maxLength:8},
		]},
		{ header: '7', align: 'center',  columns: [
			{binding:'prsnl7',header: '인원(명)', width: '*', align:'right',dataType:'Number', format: 'n2', maxLength:8},
			{binding:'hrMnt7',header: '시간(분)', width: '*', align:'right',dataType:'Number', format: 'n0', maxLength:8},
		]},
		{ header: '8', align: 'center',  columns: [
			{binding:'prsnl8',header: '인원(명)', width: '*', align:'right',dataType:'Number', format: 'n2', maxLength:8},
			{binding:'hrMnt8',header: '시간(분)', width: '*', align:'right',dataType:'Number', format: 'n0', maxLength:8},
		]},
		{binding:'hrMntSum',header: '라인소계',width: '*', align:'right',dataType:'Number', format: 'n0', maxLength:8 }									
	];	
	//컬럼 초기화
	flexGrid.initialize({
		columns: columnsDefinition,
		allowMerging: 'Cells' 
	});
	flexGrid.columnHeaders.rows.defaultSize = 45; 	// 열 헤더 영역에 행의 높이 설정	
//	flexGrid.columnFooters.rows.push(new wijmo.grid.GroupRow());
//   flexGrid.bottomLeftCells.setCellData(0, 0, '\u03A3');
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
		}
		return null;
	}
	
	flexGrid.cellEditEnded.addHandler(function(s,e){
		var value = s.getCellData(e.row,e.col,false);
		if(s.columns[e.col].dataType==wijmo.DataType.String){
			value = value.trim();
		}

		var row = e.row +1;
		//짝수열만 계산
		if(row%2 == 0) {
			if(e.col == 9 || e.col == 11 || e.col == 13 || e.col == 15 || e.col == 17 || e.col == 19|| e.col == 21 || e.col == 23 ) {
				if(value==null || wijmo.isEmpty(value) || value == "" ){		
				}else{
					calFunction(s, e);
				}
			}		
		}
		
		
	});	
}

//        	int lineHrMbtSumPct = 0;
//        	int lineLgstTime = 0;
//        	if(lineHrMbtSum > 0) {
//        		//라인별 시간 퍼센트 구함
//        		lineHrMbtSumPct = (lineHrMbtSum / prSnlSum) * 100;
//           	 	//총 근태정보 물류시간 취득
//            	lineLgstTime = (lgstTime / 100) * lineHrMbtSum;
//        	}

function calFunction(s, e){	
	var baseLgstTimeSum = 0;
	var lgst = 0;
	lgst = $("#getLgstTm").val(); 
	if(typeof lgst != "undefined" && lgst != "" && lgst != null){
		if(lgst > 0) {
			baseLgstTimeSum = lgst; 
		}
	}else {
		lgst =  $("#ttlLgst").val();
		if(typeof lgst != "undefined" && lgst != "" && lgst != null){		
			baseLgstTimeSum =lgst;  //가져온 총 물류
		}else{
			baseLgstTimeSum = 0;
		}
	}

	
	
	var rowHrMntSum = 0; //총 시간입력값

	var hrMnt1 = s.getCellData(e.row,9,false);
	var hrMnt2 = s.getCellData(e.row,11,false);
	var hrMnt3 = s.getCellData(e.row,13,false);
	var hrMnt4 = s.getCellData(e.row,15,false);
	var hrMnt5 = s.getCellData(e.row,17,false);
	var hrMnt6 = s.getCellData(e.row,19,false);
	var hrMnt7 = s.getCellData(e.row,21,false);
	var hrMnt8 = s.getCellData(e.row,23,false);						

	var lineHrMbtSum = Number(hrMnt1) + Number(hrMnt2) + Number(hrMnt3) + Number(hrMnt4) + Number(hrMnt5) + Number(hrMnt6) + Number(hrMnt7) + Number(hrMnt8);
	s.setCellData(e.row,24,lineHrMbtSum); //라인소계	
	
	var rowCnt = flexGrid.rows.length;
	for(var i = 1; i < rowCnt+1; i++) {
		if(i%2 == 0) {
			var value = s.getCellData(i-1,24,false);
			rowHrMntSum = rowHrMntSum +Number(value);
		}
	}
	for(var i = 1; i < rowCnt+1; i++) {
			var hrMnt1 = 0;
			var hrMnt2 = 0;
			var hrMnt3 = 0;
			var hrMnt4 = 0;
			var hrMnt5 = 0;
			var hrMnt6 = 0;
			var hrMnt7 = 0;
			var hrMnt8 = 0;	
			var lineHrMbtSum = 0;
		if(i%2 == 0) {
			hrMnt1 = s.getCellData(i-1,9,false);
			hrMnt2 = s.getCellData(i-1,11,false);
			hrMnt3 = s.getCellData(i-1,13,false);
			hrMnt4 = s.getCellData(i-1,15,false);
			hrMnt5 = s.getCellData(i-1,17,false);
			hrMnt6 = s.getCellData(i-1,19,false);
			hrMnt7 = s.getCellData(i-1,21,false);
			hrMnt8 = s.getCellData(i-1,23,false);						
		
			lineHrMbtSum = Number(hrMnt1) + Number(hrMnt2) + Number(hrMnt3) + Number(hrMnt4) + Number(hrMnt5) + Number(hrMnt6) + Number(hrMnt7) + Number(hrMnt8);
			s.setCellData(i-1,24,lineHrMbtSum); //라인소계
				
			
	   		//라인별 시간 퍼센트 구함
			var linePercent = (lineHrMbtSum * 100) / rowHrMntSum;
	   	 	//총 근태정보 물류시간 취득
	       	lineLgstTime = (baseLgstTimeSum * linePercent) / 100;   //(Base물류시간 / 100)*라인퍼센트
	
			s.setCellData(i-1,7,lineLgstTime); //물류시간
		}
	}	
	//물류제외 총작업시간
	$("#ttlWork").val(rowHrMntSum);
}

function changeRgstTime(){	
	var baseLgstTimeSum = 0;
	var lgst = 0;
	lgst = $("#getLgstTm").val(); 
	if(typeof lgst != "undefined" && lgst != "" && lgst != null){
		if(lgst > 0) {
			baseLgstTimeSum = lgst; 
		}
	}else {
		lgst =  $("#ttlLgst").val();
		if(typeof lgst != "undefined" && lgst != "" && lgst != null){		
			baseLgstTimeSum =lgst;  //가져온 총 물류
		}else{
			baseLgstTimeSum = 0;
		}
	}
	
	var rowCnt = flexGrid.rows.length;
	var rowHrMntSum = $("#ttlWork").val(); //물류제외 총작업시간
	
	
	for(var i = 1; i < rowCnt+1; i++) {
			var hrMnt1 = 0;
			var hrMnt2 = 0;
			var hrMnt3 = 0;
			var hrMnt4 = 0;
			var hrMnt5 = 0;
			var hrMnt6 = 0;
			var hrMnt7 = 0;
			var hrMnt8 = 0;	
			var lineHrMbtSum = 0;
		if(i%2 == 0) {
			
			hrMnt1 = flexGrid.getCellData(i-1,9,false);
			hrMnt2 = flexGrid.getCellData(i-1,11,false);
			hrMnt3 = flexGrid.getCellData(i-1,13,false);
			hrMnt4 = flexGrid.getCellData(i-1,15,false);
			hrMnt5 = flexGrid.getCellData(i-1,17,false);
			hrMnt6 = flexGrid.getCellData(i-1,19,false);
			hrMnt7 = flexGrid.getCellData(i-1,21,false);
			hrMnt8 = flexGrid.getCellData(i-1,23,false);			
			lineHrMbtSum = Number(hrMnt1) + Number(hrMnt2) + Number(hrMnt3) + Number(hrMnt4) + Number(hrMnt5) + Number(hrMnt6) + Number(hrMnt7) + Number(hrMnt8);
			flexGrid.setCellData(i-1,24,lineHrMbtSum); //라인소계
				
	   		//라인별 시간 퍼센트 구함
			var linePercent = (lineHrMbtSum * 100) / rowHrMntSum;
			if (!isNaN(linePercent)) {
		   	 	//총 근태정보 물류시간 취득
		       	var lineLgstTime = (baseLgstTimeSum * linePercent) / 100;   //(Base물류시간 / 100)*라인퍼센트
			
				flexGrid.setCellData(i-1,7,lineLgstTime); //물류시간
			}
		}
	}	
}


/**
 * 부서코드로 업체명 검색하여 데이터 set
 * 
 * @param 업체코드
 */
function getDeptSch(gubn, value,s,e) {
	if(value != ""){
		clearGrid();
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

function setRowReadOnly(){
	var rows = flexGrid.rows;
	var cnt = 0;
	for (var i =0; i < rows.length; i ++) {
		cnt = i +1;
		if(cnt%2 == 0) {
		}else{
			rows[i].isReadOnly = true;
			rows[i].cssClassAll = "readOnlyColor";
		}
	}
}

function getToday(){
	var date = new Date();
	return date.getFullYear() + "-" + ("0"+(date.getMonth()+1)).slice(-2) + "-" + ("0"+date.getDate()).slice(-2);
}

$(document.body).ready(function() {
/* 
   let theInputDate = new input.InputDate('#theInputDate', {
        valueChanged: (sender) => setDateTime(sender.value)
    });
*/
	var plndt_calendar = new ax5.ui.calendar({
        target: document.getElementById("plndt_calendar"),
        control: {
            left: '<i class="fa fa-chevron-left"></i>',
            yearTmpl: '%s',
            monthTmpl: '%s',
            right: '<i class="fa fa-chevron-right"></i>',
            yearFirst: true
        },
        displayDate: (new Date()),
        dimensions: {
            height: 250,
            controlHeight: 40,
            itemPadding: 1
        },
        lang: {
        	yearTmpl: YEAR_FORMAT,
        	months: MONTH,
        	dayTmpl: "%s"
        },
        onClick: function () {
            $(this.target).css('display', 'none');
            $(this.target).prev().val(plndt_calendar.getSelection());            
        },
        onStateChanged: function () {
            //console.log(this);
        }
    });

	$('.log_board .dropdown').on('click', function(e){
		$($(e.target).next('.dropdown-menu')).css('display', 'block');
	});

	$.getScript('/js/sal/gridCommon.js').done(function() {
		commonGrid.init(flexGrid,cv); //그리드 공통부분	
		gridInit();  	//그리드 초기화
		gridEvent();	//그리드 이벤트
		handleEvent();	//프로그램 버튼 이벤트
		
		var nowDate = getToday();
		$("#opertDe").val(nowDate);
		$("#ttlLgst").val("");
	});		
	
});
