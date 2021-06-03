var lgsDstRtSum = 0;

// 컬랙션 뷰는 조회후에 그리드의 상태변경을 체크한다. 
var cv = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수

var flexGrid = new wijmo.grid.FlexGrid('#wijmoGrid');	//그리드 전역변수
var zoomSize = 11;
var lineCodeMast = null;
var itemMast = null;
var itemMast0 = null;

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
		window.open("/ajaxCustomer/init.do","customerPop","width=550,height=600,scrollbars=yes,top=100,left=100");
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
	
	if(!$("#getYear").val()){
		toastMsg("년도를 입력 하세요.");
		return false;
	}else {
		var year = $("#getYear").val();
		if(!isDateValid(year)) {
			toastMsg("년도는 yyyy 형식입니다.");
			return false;
		}
	}
	
	var url = "/ajaxMnhrCntrBaseBase/search.do";	
	var params = {
		'getComps' : $("#getComps").val(),
		'getYear' : $("#getYear").val(),
		'getFsHalf' : $("#getFsHalf").val(),
		'getItemCode' : $("#getItemCode").val(),	
		'getItemNm' : $("#getItemNm").val()						
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
			url : "/ajaxMnhrCntrBaseBase/update.do",
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
			url : "/ajaxMnhrCntrBaseBase/create.do",
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
			url : "/ajaxMnhrCntrBaseBase/delete.do",
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
	
	var fileName = "공수관리마스타_"+getToday()+".xlsx";
	
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
		{binding:'lineCode',header: '* '+ LB_LINE_CODE,width: '*', align:'center',dataType:'String', maxLength:4},
		{binding:'lineNm',header: '* '+ LB_LINE_NM, width: 150, align:'left',dataType:'String', maxLength:50,isReadOnly: true},
		{binding:'prdtNo',header: '* '+ LB_ITEM_CODE, width: 150, align:'center',dataType:'String', maxLength:50},		
		{binding:'prdtNm',header: '* '+ LB_ITEM_NM, width: 200, align:'left',dataType:'String', maxLength:50,isReadOnly: true},				
		{binding:'cycleTime',header: '* '+ LB_CYCLE_TIME, width: '*', align:'right',dataType:'Number', format: 'n3', maxLength:4},	//C/T(sec)					
		{binding:'drctHdcn',header: '* '+ LB_DRCT_HDCN, width: '*', align:'right',dataType:'Number', format: 'n3', maxLength:4},	//제조직접인원수(명)					
		{binding:'indrHdcn',header: '* '+ LB_INDR_HDCN, width: '*', align:'right',dataType:'Number', format: 'n3', maxLength:4},	//제조간접인원수(조장,피다,검사)				
		{binding:'jmLabor',header: '* '+ LB_JM_LABOR, width: '*', align:'right',dataType:'Number', format: 'n3', maxLength:4},		//정미공수								
		{binding:'prfrTime',header: '* '+ LB_PRFR_TIME, width: '*', align:'right',dataType:'Number', format: 'n3', maxLength:4},	//실적시간													
		{binding:'mrgFct',header: '* '+ LB_MRG_FCT, width: '*', align:'right',dataType:'Number', format: 'n3', maxLength:10,isReadOnly: true},		//여유계수(생산실적시간/정미시간)*100			
		{binding:'stdrLabor',header: '* '+ LB_STDR_LABOR, width: '*', align:'right',dataType:'Number', format: 'n3', maxLength:10},	//생산성기준공수(sec)=정미공수×여유계수
		{binding:'excTmRt',header: '* '+ LB_EXC_TM_RT, width: '*', align:'right',dataType:'Number', format: 'n3', maxLength:4},	//제외시간율	
		{binding:'indTmRt',header: '* '+ LB_IND_TM_RT, width: '*', align:'right',dataType:'Number', format: 'n3', maxLength:4},	//간접시간율				
		{binding:'excIndRt',header: '* '+ LB_EXC_IND_RT, width: '*', align:'right',dataType:'Number', format: 'n3', maxLength:4},	//제외간접율							
		{binding:'sgmRgsArb',header: '* '+ LB_SGM_RGS_ARB, width: '*', align:'right',dataType:'Number', format: 'n5', maxLength:10,isReadOnly: true}, //시그마등록공수(S)															
		{binding:'uph',header: '* '+ LB_UPH, width: '*', align:'right',dataType:'Number', format: 'n5', maxLength:10,isReadOnly: true},				 //UPH	
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

function toUpperCase(str){
	var res = str.toUpperCase();
	return res;
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
					return "[품목코드]를 입력 하세요.";
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
					calFunction(s, e);
				}
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
		if(e.col == 2) {
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
				}
			}
		}
		
		//제품코드1
		if(e.col == 4) {
			var flag = true;
			if(value==null || wijmo.isEmpty(value) || value == "" ){
				
			}else{
				debugger;
				var flag = true;
				var itemCode = value.trim();
				itemCode = itemCode.toUpperCase();	
				getItemMaster(itemCode,s,e);
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
//	getItemMaster(); //제품Master정보 취득
	clearGrid();
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
		lineCodeSearch(); //라인코드
//		getItemMaster(); //제품Master정보 취득
		var nowYear = getYear();
		$("#getYear").val(nowYear);
	});		
});
