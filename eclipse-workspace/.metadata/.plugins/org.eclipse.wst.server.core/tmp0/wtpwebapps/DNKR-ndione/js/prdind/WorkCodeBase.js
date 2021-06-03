//code intellisense typescript 정의
///<reference path = "../../wijmo/controls/wijmo.d.ts"/>	
///<reference path = "../../wijmo/controls/wijmo.grid.d.ts"/>
///<reference path = "../../wijmo/controls/wijmo.input.d.ts"/>


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

function isCodeValid(d){
	var re = /^[A-Za-z0-9+]*$/;
    return re.test(d);
}

/**
 * 등록시 오류검증
 */
function validation(item){
	var getSe = $("#getSe").val();

	if(item.clsCode==null || wijmo.isEmpty(item.clsCode) || item.clsCode == ""){
		toastMsg("수정이나 추가한 행의 [사업부]컬럼을 입력해야 됩니다.");
		return false;
	}
	
	if(item.se==null || wijmo.isEmpty(item.se) || item.se ==""){
		toastMsg("수정이나 추가한 행의 [코드구분]컬럼을 입력 하세요");
		return false;
	}

	if(item.code==null || wijmo.isEmpty(item.code) || item.code ==""){
		toastMsg("수정이나 추가한 행의 [코드]컬럼을 입력 하세요");
		return false;
	}else{
		var flag = isCodeValid(item.code);
		if(!flag) {
			toastMsg("영문, 숫자만 입력 가능 합니다.");
			return false;
		}
	}
	
	if(item.codeNm==null || wijmo.isEmpty(item.codeNm) || item.codeNm ==""){
		toastMsg("수정이나 추가한 행의 [코드명]컬럼을 입력 하세요");
		return false;
	}
	
	//근무코드 일때만 체크
	if(getSe == "A") {
		if(item.startTime==null || wijmo.isEmpty(item.startTime) || item.startTime ==""){
			toastMsg("시작시간은 hhmm 형식으로 입력해주세요.");
			return false;
		}else{
			var flag = isDateTimeValid(item.startTime);
			if(!flag) {
				toastMsg("시작시간은 hhmm 형식으로 입력해주세요.");
				return false;
			}		
		}
		
		if(item.endTime==null || wijmo.isEmpty(item.endTime) || item.endTime ==""){
			toastMsg("종료시간은 hhmm 형식으로 입력해주세요.");
			return false;
		}else{
			var flag = isDateTimeValid(item.endTime);
			if(!flag) {
				toastMsg("종료시간은 hhmm 형식으로 입력해주세요.");
				return false;
			}			
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
		addRow.se = $("#getSe").val();
		addRow.rownum = flexGrid.rows.length -1;
		cv.commitNew();			
		flexGrid.select(new wijmo.grid.CellRange(flexGrid.rows.length+1,0), true);	

//		flexGrid.setCellData(flexGrid.length,"rownum",flexGrid.length,true);	
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
	var url = "/ajaxWorkCodeBase/search.do";	
	var params = {
		'getComps' : $("#getComps").val(),
		'getSe' : $("#getSe").val()	
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

function findGridRow(obj){
	var strErrKeyVal = obj.se + "-" +obj.code
	for(var i =0; i < cv.items.length; i++) {
		var se = cv.items[i].se;
		var code = cv.items[i].code;
		
		var strKeyVal = se + "-" +code
		
		if(strErrKeyVal == strKeyVal) {
			return i+1;
		}
	}
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
	var chkItem = null;
	// Update : 업데이트 프로세스
    for ( var i = 0; i <cv.itemsEdited.length; i ++) {
		console.log(cv.itemsEdited[i]);
		chkItem = cv.itemsEdited[i];
		$.ajax({
			method : "post",
			url : "/ajaxWorkCodeBase/update.do",
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
			url : "/ajaxWorkCodeBase/create.do",
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
			url : "/ajaxWorkCodeBase/delete.do",
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
	var fileName = "작업코드마스타_"+getToday()+".xlsx";
	
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


//삭제하시면 됩니다.
/** 
 * 확대
 
function zoomIn(){
	
	if (zoomSize>17) return;
	zoomSize++;
	
	var headerSize = zoomSize-11;
	if(headerSize <0) headerSize = headerSize * -1;
	
	$("#wijmoGrid").css("font-size",zoomSize+"pt");
	flexGrid.collectionView.refresh();
	flexGrid.columnHeaders.rows.defaultSize = flexGrid.columnHeaders.rows.defaultSize+(headerSize/2); 	// 열 헤더 영역에 행의 높이 설정
	
}
*/

/**
 * 축소

function zoomOut(){
	if (zoomSize<6) return;
	zoomSize--;
	
	var headerSize = zoomSize-11;
	if(headerSize <0) headerSize = headerSize * -1;
	
	$("#wijmoGrid").css("font-size",zoomSize+"pt");
	flexGrid.collectionView.refresh();
	flexGrid.columnHeaders.rows.defaultSize = flexGrid.columnHeaders.rows.defaultSize-(headerSize/2); 	// 열 헤더 영역에 행의 높이 설정
}
 */

function gridInit(){
	var columnsDefinition=[
		{binding:'rownum',visible:false},
		{binding:'clsCode',visible:false},							
		{binding:'se',header: '구분코드',width: '*', align:'center',dataType:'String', maxLength:2, isReadOnly: true},					
		{binding:'code',header: '* '+ LB_CODE,width: '*', align:'center',dataType:'String', maxLength:2},
		{binding:'codeNm',header: '* '+ LB_CODE_NM, width: 300, align:'left',dataType:'String', maxLength:50},
		{binding:'startTime',header: '시작시간' , width: '*', align:'center',dataType:'String', maxLength:5},
		{binding:'endTime',header: '종료시간' , width: '*', align:'center',dataType:'String', maxLength:5},	
		{binding:'overtimeH',visible:false},							
		{binding:'overtimeM',header: ''+ LB_OVERTIME_M, width: '*', align:'center',dataType:'Number', maxLength:3},
		{binding:'oldSe',visible:false},
		{binding:'oldCode',visible:false}
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

function gridEvent(){
	cv.getError = function(item,prop){
		switch(prop){
			case "clsCode":
				if(item.clsCode==null || wijmo.isEmpty(item.clsCode) || item.clsCode == ""){
					return "[사업부]을 입력해야 됩니다.";
				}
				return null;
				
			case "se":
				if(item.clsCode==null || wijmo.isEmpty(item.clsCode) || item.clsCode == ""){
					return "[코드구분]을 입력해야 됩니다.";
				}
				return null;				
				

			case "code":
				if(item.code==null || wijmo.isEmpty(item.code) || item.code == "" ){
					return "[코드]를 입력 하세요.";
				}else{
					var flag = isCodeValid(item.code);
					if(!flag) {
						item.code = "";
//						return "영문, 숫자만 입력 가능 합니다.";
					}
				}
				return null;
				
			case "codeNm":
				if(item.codeNm==null || wijmo.isEmpty(item.codeNm) || item.codeNm == "" ){
					return "[코드명]을 입력 하세요.";
				}
				return null;

			case "startTime":
			   	//근무코드 일때만 체크
				if(item.se == "A") {		
					if(item.startTime==null || wijmo.isEmpty(item.startTime) || item.startTime == "" ){
						return "[시작시간]을 입력 하세요.";
					}
				}
				return null;
				
			case "endTime":
			   	//근무코드 일때만 체크
				if(item.se == "A") {				
					if(item.endTime==null || wijmo.isEmpty(item.endTime) || item.endTime == "" ){
						return "[종료시간]을 입력 하세요.";						
					}
				}	
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

	//대문자 변경
	flexGrid.cellEditEnded.addHandler(function(s,e){
		var value = s.getCellData(e.row,e.col,false);
		
		if(s.columns[e.col].dataType==wijmo.DataType.String){
			s.setCellData(e.row,e.col,value.toUpperCase());
		}
				
		//Time Validateion
		//if(e.col == 5 || e.col == 6 ) {
		//컬럼명으로 찾도록 수정함.	
		
		if(s.columns[e.col].binding=="startTime" || s.columns[e.col].binding=="endTime"){
			var flag = true;
			if(value==null || wijmo.isEmpty(value) || value == "" ){
			}else{
				var flag = true;
				var flag = isDateTimeValid(value);
				if(flag) {
					strVal = getChangeDatetime(value);
					s.setCellData(e.row,e.col,strVal); //시간
					return false;			
				}else{
					toastMsg("시간은 hhmm 형식으로 입력해주세요.")	
					s.setCellData(e.row,e.col,""); //시간				
				}				
			}
		}
		
		
	});
	
	
}

function changeSe(){
	var se = $("#getSe").val();
	if(se == "A") {
		initSeCodeA();
	}else {
		gridInitNotA();
	}
	
	
}
function gridInitNotA(){
	
	flexGrid.columns.getColumn("startTime").visible = false;
	flexGrid.columns.getColumn("endTime").visible = false;
	flexGrid.columns.getColumn("overtimeM").visible = false;
	
	//flexGrid.columns[5].visible=false;
	//flexGrid.columns[6].visible=false;
	//flexGrid.columns[8].visible=false;	
	search();
}

function initSeCodeA() {
	flexGrid.columns.getColumn("startTime").visible = true;
	flexGrid.columns.getColumn("endTime").visible = true;
	flexGrid.columns.getColumn("overtimeM").visible = true;
	
	//flexGrid.columns[5].visible=true;
	//flexGrid.columns[6].visible=true;
	//flexGrid.columns[8].visible=true;		
	search();
}


function clearGrid() {
	cv.sourceCollection=[];
}

$(document.body).ready(function() {
	$.getScript('/js/sal/gridCommon.js').done(function() {
		commonGrid.init(flexGrid,cv); //그리드 공통부분		
		gridInit();  	//그리드 초기화
		gridEvent();	//그리드 이벤트
		handleEvent();	//프로그램 버튼 이벤트
	});			
});
