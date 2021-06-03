//code intellisense typescript 정의
///<reference path = "../../wijmo/controls/wijmo.d.ts"/>	
///<reference path = "../../wijmo/controls/wijmo.grid.d.ts"/>
///<reference path = "../../wijmo/controls/wijmo.input.d.ts"/>

// 컬랙션 뷰는 조회후에 그리드의 상태변경을 체크한다. 
var cv = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수
var flexGrid = new wijmo.grid.FlexGrid('#wijmoGrid');	//그리드 전역변수
var zoomSize = 11;
 
/**
 * 등록시 오류검증
 */
function validation(item){
	var getSe = $("#getSe").val();
	
	
	if(item.refrn==null || wijmo.isEmpty(item.refrn) || item.refrn ==""){
		toastMsg("수정이나 추가한 행의 [비고]컬럼을 입력 하세요");
		return false;
	}
	
	if(item.pblcDate==null || wijmo.isEmpty(item.pblcDate) || item.pblcDate ==""){
		toastMsg("수정이나 추가한 행의 [일자]컬럼을 입력 하세요");
		return false;
	}else{
		var flag = isDatetimeValid(item.pblcDate);
		if(!flag) {
			toastMsg("일자는 [yyyymmdd] 형식으로 입력해주세요.");
			return false;
		}		
	}

	
		
	return true;
}


function handleEvent(){
	
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
		var addRow = cv.addNew();
		addRow.clsCode = $(".getComps").val();	
		//addRow.appendDe = '9999-12-31';		
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
	if(!$(".getComps").val()){
//		toastMsg(LN_SELECT_COMPS);
		return false;
	}
	var url = "/ajaxHolidayAppointed/search.do";	
	var params = {
		'getComps' : $("#getComps").val()
		,'getPblcYear' : $("#getYear").val()
	};
	
	mask.open();
	$.ajax({
		method : "post",
		url : url,
		data :params,
		success : function(res) {
			var data = JSON.parse(res).list;
			cv.sourceCollection = data;
			
			
			for(var i=0; i<data.length; i ++ ) {
				
				var week = new Array('일요일','월요일','화요일','수요일','목요일','금요일','토요일');
				var dotwDate = isDatetimeValid(data[i].pblcDate);				
				var dayOfTheWeek = new Date(data[i].pblcDate).getDay();
				
				if(dotwDate) {
				
					flexGrid.setCellData(i,'dotw',week[dayOfTheWeek]);
				}
				
				
			}
			//flexGrid.setCellData(i,2,data[i].pblcDate);
			//flexGrid.columnFooters.setCellData(0, 3, lgsDstRtSum);
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
			url : "/ajaxHolidayAppointed/update.do",
			data : cv.itemsEdited[i],
			async: false,
			success : function(xhr) {
    	    	var data = JSON.parse(xhr);
            	
    	    	if(data.result != RESULT_OK) {
					var rowNum = cv.itemsEdited[i].rownum;
					if(typeof rowNum != "undefined" && rowNum != "" && rowNum != null){						
						addErrorLineColor(flexGrid,rowNum);
					}
					if(data.errMsg == "LN_INS_CHK1") stateMsg = LN_INS_CHK1;
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
			url : "/ajaxHolidayAppointed/create.do",
			data : cv.itemsAdded[i],
			async: false,
			success : function(xhr) {
            	var data = JSON.parse(xhr);
            	
    			if (data.result != RESULT_OK) {
					var rowNum = cv.itemsAdded[i].rownum;
					if(typeof rowNum != "undefined" && rowNum != "" && rowNum != null){						
						addErrorLineColor(flexGrid,rowNum);	    		
					}		
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
				if(typeof rowNum != "undefined" && rowNum != "" && rowNum != null){		
					addErrorLineColor(flexGrid,rowNum);	
				}
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
			url : "/ajaxHolidayAppointed/delete.do",
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

function clearGridPlanYear(){
	cv.sourceCollection=[];
	gridInit();
}

function getToday(){
	var date = new Date();
	return date.getFullYear() + "-" + ("0"+(date.getMonth()+1)).slice(-2) + "-" + ("0"+date.getDate()).slice(-2);
}

/**
 * 엑셀 다운로드
 */
function downloadExcel(){
	var fileName = "공휴일지정_"+getToday()+".xlsx";
	
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


function gridInit(){
	var yyyy = $("#getYear option:selected").val();
	var columnsDefinition=[
		{binding:'clsCode',visible:false},
		{binding:'pblcDate',header: LB_DATE+' *' , width: 120, align: 'center', dataType: 'String', maxLength: 10},
		{binding:'dotw',header: LB_DOTW, width: 120, align:'center', dataType:'String', maxLength:12},
		{binding:'refrn',header: LB_REFRN+' *' , width: '*', align:'center', dataType:'String', maxLength:100},													
		{binding:'oldPblcDate',visible:false},
		{binding:'rownum',visible:false}														
	];
	//컬럼 초기화
	flexGrid.initialize({
		columns: columnsDefinition
	});
		
}


//function getChangeDatetime(data){
//	var strVal = "";
//	if(!isDateTimeValid(data)) {
//		return "";
//	}else {
//		var index = data.indexOf(':');
//		if(index > 0) {
//			strVal = data;
//		}else {
//			strVal = data.substring(0,2)+":"+data.substring(2,4);
//		}
//	}
//   	return strVal;
//}
//
//function isDateValid(data){
//	var str = data.replace(/-/g,"");	
//    var re = /[0-9]{4}(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])/;
//	if(re.test(str)) {
//		var intStr = Number(str);
//		if(intStr > 0) {
//			return true;
//		}else {
//			return false;
//		}
//	}else {
//		return false;
//	}
//}

function getChangeDate(data){
	var strVal = "";
	if(!isDatetimeValid(data)) {
		return "";
	}else {
		var index = data.indexOf('-');
		if(index > 0) {
			strVal = data;
		}else {
			
			strVal = data.substring(0,4)+"-"+data.substring(4,6)+"-"+data.substring(6,8);
		}
	}
   	return strVal;
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
	cv.getError = function(item,prop){
		switch(prop){
								
			case "pblcDate":
				var flag = true;
				if(item.pblcDate==null || wijmo.isEmpty(item.pblcDate) ){
					return "[일자]을 입력하세요.";					
				}else{
					var flag = isDatetimeValid(item.pblcDate);
					if(!flag) {
						return "날짜는 yyyymmdd 형식으로 입력해주세요.";
					}else{						
						var week = new Array('일요일','월요일','화요일','수요일','목요일','금요일','토요일');
						var dowtDate = getChangeDate(item.pblcDate);
						var dayOfTheWeek = new Date(dowtDate).getDay();
												
						item.dotw = week[dayOfTheWeek];						
					}
				}
				return null;
			
			case "refrn":
				var flag = true;
				if(item.refrn==null || wijmo.isEmpty(item.refrn)){
					return "[비고]을 입력하세요.";					
				}
				return null;
				
//			case "weekIntr":
//				var flag = true;
//				if(item.weekIntr==null || wijmo.isEmpty(item.weekIntr) ){
//					return "[반복간격]을 입력하세요.";					
//				}
//				return null;
			
			
		}
		return null;
	}

	/**
	 * 수정할경우 rownum 넣어주는 이벤트
	 * 기존에 cellEditEnded 이벤트에 넣어주니 같은값으로 변경될때도 rownum이 들어가는 오류와 
  	 * 수정을 안하고 input박스만 생성되는 경우도 rownum이 찍히는 버그가 발생하여 cellEditEnding 이벤트로 변경함. 
	 */
	
	
	flexGrid.pastedCell.addHandler(function(s,e){
		s.setCellData(e.row,"rownum",e.row,true);
	});
	
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

function getYearList(){
	var dt = new Date();
	var year = dt.getFullYear();
	var yearList = "";
	for(var i = (year - 20); i<= (year + 2); i++){
		if(i == year){
			yearList += $("#getYear").append("<option value='"+i+"' selected>"+i+"</option>");
		}else{
			yearList += $("#getYear").append("<option value='"+i+"'>"+i+"</option>");
		}
	}
}


function clearGrid() {
	cv.sourceCollection=[];
}


$(document.body).ready(function() {
	$.getScript('/js/sal/gridCommon.js').done(function() {
		commonGrid.init(flexGrid,cv); //그리드 공통부분		
		getYearList();
		gridInit();  	//그리드 초기화
		gridEvent();	//그리드 이벤트
		handleEvent();	//프로그램 버튼 이벤트
	});			
});
