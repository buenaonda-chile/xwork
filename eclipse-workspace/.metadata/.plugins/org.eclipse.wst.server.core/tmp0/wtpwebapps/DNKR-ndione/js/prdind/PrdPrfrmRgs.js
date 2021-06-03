var lgsDstRtSum = 0;

var workMast = null;  //빵,쿠폰 마스트

// 컬랙션 뷰는 조회후에 그리드의 상태변경을 체크한다. 
var cv = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수

var cv1 = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수(interface)

var flexGrid = new wijmo.grid.FlexGrid('#wijmoGrid');	//그리드 전역변수
var flexGrid1 = new wijmo.grid.FlexGrid('#wijmoGrid1');	//그리드 전역변수(interface)
var zoomSize = 11;
var baseLgstTime = 0;

var lineCodeMast = null;
var itemMast = null;

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
		toastMsg("수정이나 추가한 행의 [사업부]컬럼을 입력해야 됩니다.");
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
		if(!$(".getComps").val()){
			toastMsg(LN_SELECT_COMPS);
			return false;
		}else if(!$(".getLocId").val()){
			toastMsg("부서(반)정보를 입력하세요.");
			return false;
		}
		
		var addRow = cv.addNew();
		addRow.clsCode = $(".getComps").val();
		addRow.locCode = $(".getLocId").val();	
		addRow.opertDe = $("#getOpertDe").val();	
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

function getItemLoad(){
	if(!$("#getComps").val()){
		toastMsg(LN_SELECT_COMPS);
		return false;
	}else if(!$("#getLocId").val()){
		toastMsg(LN_SELECT_DEPT);
		return false;
	}else if(!$("#getOpertDe").val()){
		toastMsg("작업일자를 입력해주세요.");
		return false;
	}		
	var url = "/ajaxPrdPrfrmRgs/searchItemLoad.do";	
	var params = {
		'getComps' : $("#getComps").val()
		,'getLocId' : $("#getLocId").val()
		,'getOpertDe' : $("#getOpertDe").val()
		,'getIntType' : 'M'			
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
			mask.close();	
		},
		complete : function() {
			mask.close();				
		}
	});	
}

function search(){
	if(!$("#getComps").val()){
		toastMsg(LN_SELECT_COMPS);
		return false;
	}else if(!$("#getLocId").val()){
		toastMsg(LN_SELECT_DEPT);
		return false;
	}else if(!$("#getOpertDe").val()){
		toastMsg("작업일자를 입력해주세요.");
		return false;
	}	
	
	var url = "/ajaxPrdPrfrmRgs/search.do";	
	var params = {
		'getComps' : $("#getComps").val()
		,'getLocId' : $("#getLocId").val()
		,'getOpertDe' : $("#getOpertDe").val()
		,'getIntType' : 'M'			
	};
	
	mask.open();
	$.ajax({
		method : "post",
		url : url,
		data :params,
		success : function(res) {
			var data = JSON.parse(res).list;
			cv.sourceCollection = data;
			var dataIf = JSON.parse(res).listIf;
			cv1.sourceCollection = dataIf;	
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


function search2(){
	if(!$("#getComps").val()){
		toastMsg(LN_SELECT_COMPS);
		return false;
	}else if(!$("#getLocId").val()){
		toastMsg(LN_SELECT_DEPT);
		return false;
	}else if(!$("#getOpertDe").val()){
		toastMsg("작업일자를 입력해주세요.");
		return false;
	}	
	
	var url = "/ajaxPrdPrfrmRgs/search2.do";	
	var params = {
		'getComps' : $("#getComps").val()
		,'getLocId' : $("#getLocId").val()
		,'getOpertDe' : $("#getOpertDe").val()	
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
	
	// Update : 업데이트 프로세스 (I/F)
/*
    for ( var i = 0; i <cv1._view.length; i ++) {
		console.log(cv1._view[i]);
	
		$.ajax({
			method : "post",
			url : "/ajaxPrdPrfrmRgs/update2.do",
			data : cv1._view[i],
			async: false,
			success : function(xhr) {
    	    	var data = JSON.parse(xhr);
            	
    	    	if(data.result != RESULT_OK) {
    	    		if(data.errMsg == "LN_UPD_CHK1") stateMsg = LN_UPD_CHK1;
    				if(data.errMsg == "LN_UPD_CHK2") stateMsg = LN_UPD_CHK2;
    				if(data.errMsg == "LN_UPD_CHK3") stateMsg = LN_UPD_CHK3;
    				if(data.errMsg == "LN_UPD_CHK4") stateMsg = LN_UPD_CHK4;						
    			} 
				if(data.result == RESULT_OK){
				}
    	    },
            error : function() {
    			stateMsg = "error";
    		},
    		complete : function() {
    		}
		});
		
		
		isModify = true;
		
     } 
*/	
	
	// Update : 업데이트 프로세스 
    for ( var i = 0; i <cv.itemsEdited.length; i ++) {
		console.log(cv.itemsEdited[i]);

		$.ajax({
			method : "post",
			url : "/ajaxPrdPrfrmRgs/update.do",
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
    				if(data.errMsg == "LN_INS_CHK3") stateMsg = LN_INS_CHK3;	
    				if(data.errMsg == "LN_INS_CHK4") stateMsg = LN_INS_CHK4;					
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
			url : "/ajaxPrdPrfrmRgs/create.do",
			data : cv.itemsAdded[i],
			async: false,
			success : function(xhr) {
            	var data = JSON.parse(xhr);
            	
    			if (data.result != RESULT_OK) {
					var rowNum = cv.itemsAdded[i].rownum;
					addErrorLineColor(flexGrid,rowNum);	      				
    				if(data.errMsg == "LN_INS_CHK1") stateMsg = LN_INS_CHK1;
					if(data.errMsg == "LN_INS_CHK2") stateMsg = LN_INS_CHK2;
    				if(data.errMsg == "LN_INS_CHK3") stateMsg = LN_INS_CHK3;	
    				if(data.errMsg == "LN_INS_CHK4") stateMsg = LN_INS_CHK4;					
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
			url : "/ajaxPrdPrfrmRgs/delete.do",
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
    		search2();
	    	
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
	
	var fileName = "생산실적등록_"+getToday()+".xlsx";
	
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


var inputNumber = new wijmo.input.InputNumber(document.createElement('div'),{
	format:'n0'
});
inputNumber.inputElement.maxLength = 13;


function gridInit(){
	var columnsDefinition=[	
		{binding:'rownum',visible:false},		
		{binding:'clsCode',visible:false},
		{binding:'locCode',visible:false},				
		{binding:'opertDe',visible:false},	
		{binding:'intType',visible:false},						
		{binding:'lineCode',header: '라인코드',width: 400, align:'center',dataType:'String', maxLength:4},
		{binding:'lineNm',header: '라인명', width: 400, align:'center',dataType:'String', maxLength:50,isReadOnly: true},
		{binding:'productNo',header: '품번',width: 300, align:'center',dataType:'String', maxLength:15},
		{binding:'productNm',header: '품명', width: 300, align:'left',dataType:'String', maxLength:50,isReadOnly: true},
		{binding:'qy',header: '수량', width: 300,align:'center',dataType:'Number', editor:inputNumber },
		{binding:'oldLineCode',visible:false},	
		{binding:'oldProductNo',visible:false}			
	];
	//컬럼 초기화
	flexGrid.initialize({
		columns: columnsDefinition,
		allowMerging: 'Cells' 
	});
}

function gridInit1(){
	var columnsDefinition=[	
		{binding:'clsCode',visible:false},
		{binding:'locCode',visible:false},	
		{binding:'opertDe',visible:false},	
		{binding:'intType',visible:false},						
		{binding:'lineCode',header: '라인코드',width: 400, align:'center',dataType:'String', maxLength:4,isReadOnly: true,allowMerging :true},
		{binding:'lineNm',header: '라인명', width: 400, align:'center',dataType:'String', maxLength:50,isReadOnly: true,allowMerging :true},
		{binding:'productNo',header: '품번',width: 300, align:'center',dataType:'String', maxLength:15,isReadOnly: true},
		{binding:'productNm',header: '품명', width: 300, align:'left',dataType:'String', maxLength:50,isReadOnly: true},
		{binding:'qy',header: '수량', width: 300,align:'center',dataType:'Number', format: 'n0', maxLength:8,isReadOnly: true }		
	];
	//컬럼 초기화
	flexGrid1.initialize({
		columns: columnsDefinition,
		allowMerging: 'Cells' 		
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
					return "[라인코드]를 입력 하세요.";
				}		
				return null;				
			case "productNo":
				if(item.productNo==null || wijmo.isEmpty(item.productNo) || item.productNo == "" ){
					return "[품목코드]를 입력 하세요.";
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
		
	flexGrid.cellEditEnded.addHandler(function(s,e){
		var value = s.getCellData(e.row,e.col,false);
		if(s.columns[e.col].dataType==wijmo.DataType.String){
			s.setCellData(e.row,e.col,value.toUpperCase());
		}
		
		//라인코드
		if(s.columns[e.col].binding=="lineCode") {
			var flag = true;
			if(value==null || wijmo.isEmpty(value) || value == "" ){
				
			}else{
				var flag = true;
				lineCodeMast.forEach (function (data, index) {		
					var code = data.lineCode;	  		
					var trimCode = code.trim();
					var itemCode = value.trim();
					itemCode = itemCode.toUpperCase();
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
					toastMsg("잘못된 라인코드 입니다.");
				}
			}
		}
		
		//제품코드
		if(s.columns[e.col].binding=="productNo") {
			var flag = true;
			if(value==null || wijmo.isEmpty(value) || value == "" ){
				
			}else{
				var flag = true;
				var itemCode = value.trim();
				itemCode = itemCode.toUpperCase();	
				getItemMaster(itemCode,s,e);
			}
		}		
		
	});	
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
		}
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
function getItemMaster(code,s,e) {
	if($('#getComps').val() != ""){	
		$.ajax({
			method : "post",
			url : "/ajaxPrdctIndComBase/searchItemMaster.do",
			data : {
				'getComps' : $("#getComps").val(),
				'itemCode' : code,								
			},
			success : function(res) {
				itemMast = JSON.parse(res).list;
				if(itemMast.length > 0) {
					var name = itemMast[0].name;
					s.setCellData(e.row,e.col+1,name); //제품명
				}else{
					s.setCellData(e.row,e.col,""); //제품코드
					s.setCellData(e.row,e.col+1,""); //제품명
					toastMsg("잘못된 품번입니다.");
				}
				
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

function getToday(){
	var date = new Date();
	return date.getFullYear() + "-" + ("0"+(date.getMonth()+1)).slice(-2) + "-" + ("0"+date.getDate()).slice(-2);
}

function clearGrid(){
	lineCodeSearch(); //라인코드정보 취득	
	cv.sourceCollection=[];
	cv1.sourceCollection=[];	
}

function toUpperCase(str){
	var res = str.toUpperCase();
	return res;
}

function ymdFormatter(){
	var num = $("#getOpertDe").val();
     if(!num) return "";
     var formatNum = '';
     // 공백제거
     num=num.replace(/\s/gi, "");
     try{
     	if(num.length == 8) {
        	formatNum = num.replace(/(\d{4})(\d{2})(\d{2})/, '$1-$2-$3');
         }
     } catch(e) {
         $("#getOpertDe").val("");
          console.log(e);
     }
	if(formatNum.length == 10) {
		$("#getOpertDe").val(formatNum);
	}
}

$(document.body).ready(function() {
    var curr = new Date(), firstDay = new Date(curr.setDate(curr.getDate() - curr.getDay())), lastDay = new Date(curr.setDate(curr.getDate() - curr.getDay() + 6));
	
	wijmo.input.InputDate.controlTemplate = '<div style="position:relative" class="wj-template">' +
    '<div class="wj-input">' +
    '<div class="wj-input-group wj-input-btn-visible">' +
    '<input wj-part="input" type="text" class="wj-form-control getOpertDe" name="getOpertDe" id="getOpertDe" onchange ="ymdFormatter();" style="width : 90px;height: 32px;box-sizing: border-box;"/>' +

    '<span wj-part="btn" class="wj-input-group-btn" tabindex="-1">' +
    '<button class="wj-btn wj-btn-default" type="button" tabindex="-1" style="height: 32px;">' +
    '<span class="wj-glyph-calendar"></span>' +
    '</button>' +
    '</span>' +
    '</div>' +
    '</div>' +
    '<div wj-part="dropdown" class="wj-content wj-dropdown-panel" ' +
    'style="display:none;position:absolute;z-index:100">' +
    '</div>' +
    '</div>';

    new wijmo.input.InputDate('#theInputDate', {
        format: 'yyyy-MM-dd',
		valueChanged:function(){
			clearGrid()
		}
    });	
	function init1(){
		commonGrid.init(flexGrid1,cv1); //그리드 공통부분	
		gridInit1();  	//그리드 초기화
	}
	function init2(){
		commonGrid.init(flexGrid,cv); //그리드 공통부분	
		gridInit();  	//그리드 초기화
		gridEvent();	//그리드 이벤트
		handleEvent();	//프로그램 버튼 이벤트
		lineCodeSearch(); //라인코드정보 취득		
//		getItemMaster(); //제품Master정보 취득			
	}

	$.getScript('/js/sal/gridCommon.js').done(function() {
		init2();
		init1();
	});		
	
});
