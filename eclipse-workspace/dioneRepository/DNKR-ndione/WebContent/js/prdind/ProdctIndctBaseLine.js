// 컬랙션 뷰는 조회후에 그리드의 상태변경을 체크한다. 
var cv = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수

var flexGrid = new wijmo.grid.FlexGrid('#wijmoGrid');	//그리드 전역변수
var zoomSize = 11;

var itemMast = null;
var prdtCodeMast = null;
var workMast = null;  //작업코드(근무형태)

var ifType = [
      {id:'',name:''},	
      {id:'Q',name:'QR'},
      {id:'M',name:'MES'}
   ];

var ifTypeMap = new wijmo.grid.DataMap(ifType, 'id', 'name');


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

function initSetMaster(){
	getDeptMaster();
	getProdctCodeMaster();
	initSetCodeMaster();
	clearGrid();	
}

function getToday(){
    var date = new Date();
    var year = date.getFullYear();
    var month = ("0" + (1 + date.getMonth())).slice(-2);
    var day = ("0" + date.getDate()).slice(-2);

    return year + month + day;
}

/**
 * 제품코드정보 취득
 */
function getProdctCodeMaster() {
	$.ajax({
		method : "post",
		url : "/ajaxProdctCodeBase/search.do",
		data : {
			'startDe' : getToday()				
		},
		success : function(res) {
			prdtCodeMast = JSON.parse(res).list;
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

function initSetCodeMaster(){
	//F: 근무형태	
	if($('#getComps').val() != ""){	
		$.ajax({
			method : "post",
			url : "/ajaxWorkCodeBase/search.do",
			data : {
				'getComps' : $("#getComps").val(),
				'getSe' : 'F'
			},
			success : function(res) {
				workMast = JSON.parse(res).list;
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
		toastMsg("수정이나 추가한 행의 [사업부]컬럼을 입력해야 됩니다.");
		return false;
	}
	
	if(item.lineCode==null || wijmo.isEmpty(item.lineCode) || item.lineCode ==""){
		toastMsg("수정이나 추가한 행의 [라인코드]컬럼을 입력 하세요");
		return false;
	}else{
		var flag = isCodeValid(item.lineCode);
		if(!flag) {
			toastMsg("영문, 숫자만 입력 가능 합니다.");
			return false;
		}		
	}


	if(item.locCode==null || wijmo.isEmpty(item.locCode) || item.locCode ==""){
		toastMsg("수정이나 추가한 행의 [부서(반)]컬럼을 입력 하세요");
		return false;
	}else{
		var value = item.locCode;
		value = value.trim();
		var flag = true;
		itemMast.forEach (function (data, index) {
			var code = data.code;
			if(code != null) {
				code = code.trim();
			}
			if(value == code) {
				flag = false;
				return true;
			}
		});	
		if(flag) {
			toastMsg("수정이나 추가한 행의[부서(반)]코드값이 없습니다.");
			return false;
		}					
	}
	
	if(item.partCode==null || wijmo.isEmpty(item.partCode) || item.partCode ==""){
		toastMsg("수정이나 추가한 행의 [부서(Part)]컬럼을 입력 하세요");
		return false;
	}else{
		var value = item.partCode;
		value = value.trim();
		var flag = true;
		itemMast.forEach (function (data, index) {
			var code = data.code;
			if(code != null) {
				code = code.trim();
			}
			if(value == code) {
				flag = false;
				return true;
			}
		});	
		if(flag) {
			toastMsg("수정이나 추가한 행의[부서(Part)]코드값이 없습니다.");
			return false;
		}					
	}	
	

	if(item.workStle==null || wijmo.isEmpty(item.workStle) || item.workStle ==""){
		toastMsg("수정이나 추가한 행의 [근무형태]컬럼을 입력 하세요");
		return false;
	}
	
	if(item.prdtCode1==null || wijmo.isEmpty(item.prdtCode1) || item.prdtCode1 ==""){
		toastMsg("수정이나 추가한 행의 [제품1]컬럼을 입력 하세요");
		return false;
	}else{
		var value = item.prdtCode1;
		var flag = true;
		prdtCodeMast.forEach (function (data, index) {
			var code = data.prdtCode;
			var trimCode = code.trim();
			if(value == trimCode) {
				flag = false;
				return true;
			}
		});
		if(flag) {
			toastMsg("수정이나 추가한 행의[제품1]코드값이 없습니다.");
			return false;
		}		
	}
	

	
	if(item.ifCode==null || wijmo.isEmpty(item.ifCode) || item.ifCode ==""){
	}else{
		var flag = isIfCodeValid(item.ifCode);
		if(!flag) {
			toastMsg("영문, 숫자만 입력 가능 합니다.");
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


function search(){
	//validation 체크기능으로 입력칸에 커서가 활성화 되어있을경우 조회시 오류가 발생함.
	//validation edit 기능을 비활성화 시키고 조회시킴.
	flexGrid.validateEdits = false;	
	
	if(!$(".getComps").val()){
//		toastMsg(LN_SELECT_COMPS);
		return false;
	}
	var url = "/ajaxProdctIndctBaseLine/search.do";	
	var params = {
		'getComps' : $("#getComps").val(),
		'code' : $("#code").val(),
		'name' : $("#name").val()		
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
			url : "/ajaxProdctIndctBaseLine/update.do",
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
			url : "/ajaxProdctIndctBaseLine/create.do",
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
			url : "/ajaxProdctIndctBaseLine/delete.do",
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
/**
 * 엑셀 다운로드
 */
function downloadExcel(){
	var fileName = "라인코드마스타_"+getToday()+".xlsx";
	transExcel(flexGrid,fileName);
}


function gridInit(){
//	var comsBase = new DataMap(coms_base, 'id', 'name');
	var columnsDefinition=[
		{binding:'rownum',visible:false},				
		{binding:'oldLineCode',visible:false},
		{binding:'clsCode',visible:false},
		{binding:'lineCode',header: '* '+ LB_LINE_CODE,width: '*', align:'center',dataType:'String', maxLength:4},
		{binding:'lineNm',header: '* '+ LB_LINE_NAME, width: 250, align:'center',dataType:'String', maxLength:50},
		{ header: '* 부서(반)', align: 'center',  columns: [
			{binding:'locCode',header: '* '+ LB_CODE,width: '*', align:'center',dataType:'String', maxLength:4},
			{binding:'locNm',header: '* '+ LB_NAME,width: '*', align:'center',dataType:'String', maxLength:50,isReadOnly: true},
		]},
		{ header: '* 부서(Part)', align: 'center',  columns: [
			{binding:'partCode',header: '* '+ LB_CODE,width: '*', align:'center',dataType:'String', maxLength:4},
			{binding:'partNm',header: '* '+ LB_NAME,width: '*', align:'center',dataType:'String', maxLength:50,isReadOnly: true},
		]},		
	    {binding:"workStle",header: '* '+ LB_WORK_STLE,width: '*', align:'center',dataType:'String', maxLength:2},
   		{ header: '* 제품1', align: 'center',  columns: [	
			{binding:"prdtCode1",header: '* '+ LB_CODE,width: '*', align:'center',dataType:'String', maxLength:1},
	    	{binding:"prdtNm1",header: '* '+ LB_NAME,width: '*', align:'center',dataType:'String', maxLength:50,isReadOnly: true}
		]},
   		{ header: '* 제품2', align: 'center',  columns: [			
	    	{binding:"prdtCode2",header:LB_CODE,width: '*', align:'center',dataType:'String', maxLength:1},
	    	{binding:"prdtNm2",header:LB_NAME,width: '*', align:'center',dataType:'String', maxLength:50,isReadOnly: true}
		]},
   		{ header: '* 제품3', align: 'center',  columns: [				
	    	{binding:"prdtCode3",header:LB_CODE,width: '*', align:'center',dataType:'String', maxLength:1},
	    	{binding:"prdtNm3",header:LB_NAME,width: '*', align:'center',dataType:'String', maxLength:50,isReadOnly: true}
		]},
	    {binding:"ifCode",header: '* '+ LB_IF_CODE,width: '*', align:'center',dataType:'String', maxLength:4},
	    {binding:"ifType",header: '* '+ LB_IF_TYPE,width: '*', align:'center',dataType:'String', maxLength:1, dataMap: ifTypeMap}
	];	
	//컬럼 초기화
	flexGrid.initialize({
		columns: columnsDefinition
	});
	
}

function isCodeValid(d){
	var re = /^[A-Za-z0-9-+]*$/;
    return re.test(d);
}

function isIfCodeValid(d){
	var re = /^[A-Za-z0-9+]*$/;
    return re.test(d);
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
				}else{
					var flag = isCodeValid(item.lineCode);
					if(!flag) {
						item.lineCode = "";
					}					
				}
				return null;
				
			case "lineNm":
			
				if(item.lineNm==null || wijmo.isEmpty(item.lineNm) || item.lineNm == "" ){
					return "[라인명]를 입력 하세요.";
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
				
/*					
			case "partCode":
				var flag = true;
				if(item.partCode==null || wijmo.isEmpty(item.partCode) || item.partCode == "" ){
//					item.partNm = "";
					return "[부서(Part)코드]를 입력 하세요.";
				}else{
					var flag = true;
					duzon_part_code.forEach (function (data, index) {			  		
						var code = data.code;
						var name = data.name;
						if(item.partCode == code) {
							item.partNm = name;
							flag = false;
							return false;
						}
					});	
					if(flag) {
//						item.partNm = "";
						return "해당하는[부서(Part)코드]가 없습니다.";
					}					
				}
				return null;
												
			case "teamCode":
				var flag = true;
				if(item.teamCode==null || wijmo.isEmpty(item.teamCode) || item.teamCode == "" ){
//					item.teamNm = "";
					return "[부서(Team)코드]를 입력 하세요.";
				}else{
					var flag = true;
					duzon_team_code.forEach (function (data, index) {			  		
						var code = data.code;
						var name = data.name;
						if(item.teamCode == code) {
							item.teamNm = name;
							flag = false;
							return false;
						}
					});	
					if(flag) {
//						item.teamNm = "";
						return "해당하는[부서(Team)코드]가 없습니다.";
					}					
				}
				return null;		
*/						
				
			case "workStle":
				if(item.workStle==null || wijmo.isEmpty(item.workStle) || item.workStle == "" ){
					return "[근무형태]를 입력 하세요.";
				}else{
					var flag = true;
					if(workMast != null) {					
						workMast.forEach (function (data, index) {			  		
							var mastCode = data.code;
//							var masterName = data.codeNm;
							var itemCode = item.workStle;
							if(itemCode != null) {
								itemCode = itemCode.trim();
							}
							if(mastCode != null) {
								mastCode = mastCode.trim();
							}						
							if(itemCode == mastCode) {
//								item.cpnNm = masterName;
								flag = false;
								return false;
							}
						});	
					}
					if(flag) {
						item.workStle = "";
					}						
				}
				return null;				
				
			case "prdtCode1":
				if(item.prdtCode1==null || wijmo.isEmpty(item.prdtCode1) || item.prdtCode1 == "" ){
					return  "[제품1]코드를 입력하세요.";
				}				
				return null;	

			case "ifCode":
				if(item.ifCode==null || wijmo.isEmpty(item.ifCode) || item.ifCode == "" ){
				}else{
					var flag = isIfCodeValid(item.ifCode);
					if(!flag) {
						return "영문, 숫자만 입력 가능 합니다.";
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
				s.setCellData(e.row,"rownum",e.row,true);
			}
		}
		

	});
	
	//대문자 변경
	flexGrid.cellEditEnded.addHandler(function(s,e){
		var value = s.getCellData(e.row,e.col,false);
		//제품1
		if(e.col == 10 || e.col == 12 || e.col == 14) {
			if(s.columns[e.col].dataType==wijmo.DataType.String){
				value = value.toUpperCase();
				s.setCellData(e.row,e.col,value); //제품코드
			}
			var flag = true;
			if(value==null || wijmo.isEmpty(value) || value == "" ){
				
			}else{
				var flag = true;
				prdtCodeMast.forEach (function (data, index) {
					var code = data.prdtCode;
					var name = data.prdtNm;					
					var trimCode = code.trim();
					if(value == trimCode) {
						s.setCellData(e.row,e.col+1,name); //제품명
						flag = false;
						return false;
					}
				});
				if(flag) {
					s.setCellData(e.row,e.col,""); //제품코드					
					s.setCellData(e.row,e.col+1,""); //제품명
				}
			}
		}
	});
}

function clearGrid() {
	cv.sourceCollection=[];
}

$(document.body).ready(function() {
	$.getScript('/js/sal/gridCommon.js').done(function() {
		commonGrid.init(flexGrid,cv); //그리드 공통부분		
		getDeptMaster(); //부서
		getProdctCodeMaster(); //제품
		initSetCodeMaster(); //근무형태
		gridInit();  	//그리드 초기화
		gridEvent();	//그리드 이벤트
		handleEvent();	//프로그램 버튼 이벤트
	});	
});
