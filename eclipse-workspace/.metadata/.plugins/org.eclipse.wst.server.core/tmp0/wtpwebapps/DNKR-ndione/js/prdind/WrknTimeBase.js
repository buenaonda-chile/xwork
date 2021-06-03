//code intellisense typescript 정의
///<reference path = "../../wijmo/controls/wijmo.d.ts"/>	
///<reference path = "../../wijmo/controls/wijmo.grid.d.ts"/>
///<reference path = "../../wijmo/controls/wijmo.input.d.ts"/>

// 컬랙션 뷰는 조회후에 그리드의 상태변경을 체크한다. 
var cv = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수
var flexGrid = new wijmo.grid.FlexGrid('#wijmoGrid');	//그리드 전역변수
var zoomSize = 11;

var workStleMast = null;
var groupMast = null;

var workStleMastMap = null;
var groupMastMap = null;

/**
 * 등록시 오류검증
 */
function validation(item){
	var getSe = $("#getSe").val();
	
	if(item.clsCode==null || wijmo.isEmpty(item.clsCode) || item.clsCode == ""){
		toastMsg("수정이나 추가한 행의 [사업부]컬럼을 입력해야 됩니다.");
		return false;
	}
	
	if(item.workStle==null || wijmo.isEmpty(item.workStle) || item.workStle ==""){
		toastMsg("수정이나 추가한 행의 [교대구분]컬럼을 입력 하세요");
		return false;
	}

	if(item.group==null || wijmo.isEmpty(item.group) || item.group ==""){
		toastMsg("수정이나 추가한 행의 [조]컬럼을 입력 하세요");
		return false;
	}
	
	if(item.startTime==null || wijmo.isEmpty(item.startTime) || item.startTime ==""){
		toastMsg("[시작시간]을 입력 하세요.");
		return false;		
	}else{
		var flag = isDateTimeValid(item.startTime);
		if(!flag) {
			toastMsg("시작시간은 [hhmm]형식으로 입력해주세요.");
			return false;
		}		
	}
	
	if(item.endTime==null || wijmo.isEmpty(item.endTime) || item.endTime ==""){
		toastMsg("[종료시간]을 입력 하세요.");
		return false;		
	}else{
		var flag = isDateTimeValid(item.endTime);
		if(!flag) {
			toastMsg("종료시간은 [hhmm] 형식으로 입력해주세요.");
			return false;
		}			
	}
	
	if(item.eastTime==null || wijmo.isEmpty(item.eastTime) || item.eastTime ==""){
		toastMsg("[출근가능시작시간]을 입력 하세요.");
		return false;		
	}else{
		var flag = isDateTimeValid(item.eastTime);
		if(!flag) {
			toastMsg("출근가능시작시간은 [hhmm]형식으로 입력해주세요.");
			return false;
		}		
	}
	
	if(item.exenTime==null || wijmo.isEmpty(item.exenTime) || item.exenTime ==""){
		toastMsg("[퇴근가능종료시간]을 입력 하세요.");
		return false;		
	}else{
		var flag = isDateTimeValid(item.exenTime);
		if(!flag) {
			toastMsg("퇴근가능종료시간은 [hhmm] 형식으로 입력해주세요.");
			return false;
		}			
	}
	
	if(item.appstaDe==null || wijmo.isEmpty(item.appstaDe) || item.appstaDe ==""){
		toastMsg("[적용시작일자]을 입력 하세요.");	
		return false;	
	}else{
		var flag = isDateValid(item.appstaDe);
		if(!flag) {
			toastMsg("적용시작일자는 [yyyymmdd] 형식으로 입력해주세요.");
			return false;
		}		
	}
	
	if(item.appendDe==null || wijmo.isEmpty(item.appendDe) || item.appendDe ==""){
		toastMsg("[적용종료일자]을 입력 하세요.");	
		return false;
	}else{
		var flag = isDateValid(item.appendDe);
		if(!flag) {
			toastMsg("적용종료일자는 [yyyymmdd] 형식으로 입력해주세요.");
			return false;
		}			
	}	
	
	if(item.appstaDe!=null && !wijmo.isEmpty(item.appstaDe) && item.appstaDe != "" && item.appendDe!=null && !wijmo.isEmpty(item.appendDe) && item.appendDe != ""){
		var startDe = item.appstaDe.replace(/-/g,"");
		var endDe = item.appendDe.replace(/-/g,"");		
		var itemStartDe = Number(startDe);
		var itemEndDe = Number(endDe);
		if(itemEndDe < itemStartDe) {
			toastMsg("시작일이 종료일 보다 큽니다.");
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
		window.open("/ajaxCustomer/init.do","customerPop","width=550,height=600,scrollbars=yes,top=100,left=100");
	});
	
	//행 추가버튼
	$("._addBtn_").on("click",function(){
		var addRow = cv.addNew();
		addRow.clsCode = $(".getComps").val();	
		addRow.appendDe = '9999-12-31';		
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
	var url = "/ajaxWrknTimeBase/search.do";	
	var params = {
		'getComps' : $("#getComps").val()
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
			url : "/ajaxWrknTimeBase/update.do",
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
			url : "/ajaxWrknTimeBase/create.do",
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
			url : "/ajaxWrknTimeBase/delete.do",
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
	var fileName = "근무조시간관리마스타_"+getToday()+".xlsx";
	
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
	var columnsDefinition=[
		{binding:'clsCode',visible:false},										
		{ header: '* '+ LB_WORK_DIV, align: 'center',  columns: [
			{binding:'workStle',header: '* '+ LB_CODE,width: '*', align:'center',dataType:'String', maxLength:2, dataMap: workStleMastMap},
			{binding:'workStleNm',header: '* '+ LB_NAME,width: '*', align:'center',dataType:'String', maxLength:50,isReadOnly: true},
		]},
		{ header: '* '+ LB_GROUP, align: 'center',  columns: [
			{binding:'group',header: '* '+ LB_CODE,width: '*', align:'center',dataType:'String', maxLength:2, dataMap: groupMastMap},
			{binding:'groupNm',header: '* '+ LB_NAME,width: '*', align:'center',dataType:'String', maxLength:50,isReadOnly: true},
		]},
		{binding:'startTime',header: ''+ LB_START_TIME , width: '*', align:'center',dataType:'String', maxLength:5},
		{binding:'endTime',header: ''+ LB_END_TIME , width: '*', align:'center',dataType:'String', maxLength:5},
		{binding:'eastTime',header: ''+ LB_EAST_TIME , width: '*', align:'center',dataType:'String', maxLength:5},
		{binding:'exenTime',header: ''+ LB_EXEN_TIME , width: '*', align:'center',dataType:'String', maxLength:5},			
		{binding:'appstaDe',header: ''+ LB_APPLY_START_DE, width: '*', align:'center',dataType:'String', maxLength:10},
		{binding:'appendDe',header: ''+ LB_APPLY_END_DE, width: '*', align:'center',dataType:'String', maxLength:10},
		{binding:'refrn',header: ''+ LB_REFRN, width: '*', align:'left',dataType:'String', maxLength:50},
		{binding:'oldWorkStle',visible:false},
		{binding:'oldGroup',visible:false},
		{binding:'oldAppstaDe',visible:false},	
		{binding:'oldAppendDe',visible:false},
		{binding:'rownum',visible:false}														
	];
	//컬럼 초기화
	flexGrid.initialize({
		columns: columnsDefinition
	});
		
}

function isDateTimeValid(data){
	var str = data.replace(/:/gi,"");
    var rep = /^(0[0-9]|1[0-9]|2[0-3])[0-5][0-9]$/;

	var re = rep.test(str) &&
            (str.substr(0,2) <= 23)  && (str.substr(3,2) <= 59)
	if(re) {
		return true;
	}else {
		return false;
	}
}

function getChangeDatetime(data){
	var strVal = "";
	if(!isDateTimeValid(data)) {
		return "";
	}else {
		var index = data.indexOf(':');
		if(index > 0) {
			strVal = data;
		}else {
			strVal = data.substring(0,2)+":"+data.substring(2,4);
		}
	}
   	return strVal;
}

function isDateValid(data){
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

function getChangeDate(data){
	var strVal = "";
	if(!isDateValid(data)) {
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

function gridEvent(){
	cv.getError = function(item,prop){
		switch(prop){
			case "clsCode":
				if(item.clsCode==null || wijmo.isEmpty(item.clsCode) || item.clsCode == ""){
					return "[사업부]을 입력해야 됩니다.";
				}
				return null;
				
			case "workStle":
				if(item.workStle==null || wijmo.isEmpty(item.workStle) || item.workStle == ""){
					return "[교대구분]을 입력해야 됩니다.";
				}else{
					var flag = true;
					if(workStleMast != null) {
						workStleMast.forEach (function (data, index) {			  		
							var mastCode = data.code;
							var masterName = data.codeNm;
							var itemCode = item.workStle;
							if(itemCode != null) {
								itemCode = itemCode.trim();
							}
							if(mastCode != null) {
								mastCode = mastCode.trim();
							}						
							if(itemCode == mastCode) {
								item.workStleNm = masterName;
								flag = false;
								return false;
							}
						});	
						if(flag) {
							item.workStle = "";
							item.workStleNm = "";							
//							return "해당하는[교대구분]가 없습니다.";
						}
					}
				}
				return null;	

			case "group":
				if(item.group==null || wijmo.isEmpty(item.group) || item.group == "" ){
					return "[조]를 입력 하세요.";
				}else{
					var flag = true;
					if(groupMast != null) {					
						groupMast.forEach (function (data, index) {			  		
							var mastCode = data.code;
							var masterName = data.codeNm;
							var itemCode = item.group;
							if(itemCode != null) {
								itemCode = itemCode.trim();
							}
							if(mastCode != null) {
								mastCode = mastCode.trim();
							}						
							if(itemCode == mastCode) {
								item.groupNm = masterName;
								flag = false;
								return false;
							}
						});	
						if(flag) {
							item.group = "";
							item.groupNm = "";							
//							return "해당하는[조]가 없습니다.";
						}	
					}
				}
				return null;
				
			case "startTime":
				var flag = true;
				if(item.startTime==null || wijmo.isEmpty(item.startTime) || item.startTime == "" ){
					return "시작시간은 [hhmm]형식으로 입력해주세요.";					
				}
				return null;
				
			case "endTime":
				var flag = true;
				if(item.endTime==null || wijmo.isEmpty(item.endTime) || item.endTime == "" ){
					return "종료시간은 [hhmm]형식으로 입력해주세요.";					
				}
				return null;
			case "eastTime":
				var flag = true;
				if(item.eastTime==null || wijmo.isEmpty(item.eastTime) || item.eastTime == "" ){
					return "출근가능시작시간은 [hhmm]형식으로 입력해주세요.";					
				}
				return null;
				
			case "exenTime":
				var flag = true;
				if(item.exenTime==null || wijmo.isEmpty(item.exenTime) || item.exenTime == "" ){
					return "퇴근가능종료시간은 [hhmm]형식으로 입력해주세요.";					
				}
				return null;
			case "appstaDe":
				var flag = false;
				if(item.appstaDe==null || wijmo.isEmpty(item.appstaDe) || item.appstaDe == "" ){
					return "적용시작일자는 [yyyymmdd] 형식으로 입력해주세요.";			
				}else{
					var flag = isDateValid(item.appstaDe);
				}
				if(!flag) {
					return "날짜는 yyyymmdd 형식으로 입력해주세요.";
				}
	
				if(item.appendDe!=null && !wijmo.isEmpty(item.appendDe) && item.appendDe != "" ){
					var iStartDe = item.appstaDe.replace(/-/g,"");						
					var iendDe = item.appendDe.replace(/-/g,"");							

					var itemStartDe = Number(iStartDe);
					var itemEndDe = Number(iendDe);
					
					if(itemEndDe < itemStartDe) {
						return "시작일이 종료일 보다 큽니다.";
					}
				}
				return null;
			case "appendDe":
				var flag = false;
				if(item.appendDe==null || wijmo.isEmpty(item.appendDe) || item.appendDe == "" ){
					return "적용종료일자는 [yyyymmdd] 형식으로 입력해주세요.";
				}else{
					var flag = isDateValid(item.appendDe);
				}
				if(!flag) {
					return "날짜는 yyyymmdd 형식으로 입력해주세요.";
				}
	
				if(item.appstaDe!=null && !wijmo.isEmpty(item.appstaDe) && item.appstaDe != "" ){
					var iStartDe = item.appstaDe.replace(/-/g,"");						
					var iendDe = item.appendDe.replace(/-/g,"");							

					var itemStartDe = Number(iStartDe);
					var itemEndDe = Number(iendDe);
					
					if(itemEndDe < itemStartDe) {
						return "시작일이 종료일 보다 큽니다.";
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
	
	//대문자 변경
	flexGrid.cellEditEnded.addHandler(function(s,e){
		var value = s.getCellData(e.row,e.col,false);
		
		if(s.columns[e.col].dataType==wijmo.DataType.String){
			s.setCellData(e.row,e.col,value.toUpperCase());
		}
		
		//Time Validateion
		if(e.col == 5 || e.col == 6 || e.col == 7 || e.col == 8 ) {
			var flag = true;
			if(value==null || wijmo.isEmpty(value) || value == "" ){
			}else{
				flag = isDateTimeValid(value);
				if(flag) {
					var strVal = getChangeDatetime(value);
					s.setCellData(e.row,e.col,strVal); //시간
					return false;			
				}else{
					toastMsg("시간은 hhmm 형식으로 입력해주세요.")	
					s.setCellData(e.row,e.col,""); //시간				
				}					
			}
		}
		//Date Validateion
	
		if(e.col == 9 || e.col == 10 ) {
			var flag = true;
			if(value==null || wijmo.isEmpty(value) || value == "" ){
			}else{
				var flag = true;
				var flag = isDateValid(value);
				if(flag) {
					var strVal = getChangeDate(value);
					s.setCellData(e.row,e.col,strVal); //시간
					return false;			
				}else{
					toastMsg("일자는 [yyyymmdd] 형식으로 입력해주세요.")	
					return false;		
				}				
			}
		}			
	});
	
}

function initSetCodeMaster(){
	if($('#getComps').val() != ""){	
		$.ajax({
			method : "post",
			url : "/ajaxWorkCodeBase/search.do",
			data : {
				'getComps' : $("#getComps").val(),
				'getSe' : 'F'
			},
			success : function(res) {
				workStleMast = JSON.parse(res).list;
				workStleMastMap = new wijmo.grid.DataMap(workStleMast, 'code', 'code');	
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
		
		$.ajax({
			method : "post",
			url : "/ajaxWorkCodeBase/search.do",
			data : {
				'getComps' : $("#getComps").val(),
				'getSe' : 'G'
			},
			success : function(res) {
				groupMast = JSON.parse(res).list;
				groupMastMap = new wijmo.grid.DataMap(groupMast, 'code', 'code');	
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

function clearGrid() {
	cv.sourceCollection=[];
}

function initSetMaster(){
	initSetCodeMaster();
	clearGrid();
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
