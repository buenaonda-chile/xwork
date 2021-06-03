var lgsDstRtSum = 0;

var workMastG = null;  //조
var workMastA = null;  //근무코드

// 컬랙션 뷰는 조회후에 그리드의 상태변경을 체크한다. 
var cv = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수

var flexGrid = new wijmo.grid.FlexGrid('#wijmoGrid');	//그리드 전역변수
var zoomSize = 11;


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

function clearGrid(){
	initSetCodeMaster('G');	//조
	initSetCodeMaster('A');	//근무코드	
	cv.sourceCollection=[];
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
		window.open("/ajaxPrdctIndComBase/initDeptPop.do","deptPop","width=550,height=600,scrollbars=yes,top=100,left=100");
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
	}else if(!$("#getOpertDe").val()){
		toastMsg("작업일자를 입력해주세요.");
		return false;
	}	
	var url = "/ajaxStEmpAbsTrd/search.do";	
	var params = {
		'getComps' : $("#getComps").val()
		,'getLocId' : $("#getLocId").val()
		,'getOpertDe' : $("#getOpertDe").val()		
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
			
			var rcvsupTm = JSON.parse(res).rcvsupTm;
			$("#getRcvsupTm").val(rcvsupTm);
			var sumWorkTime = JSON.parse(res).sumWorkTime;
			$("#getTtlWork").val(sumWorkTime);			
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
			url : "/ajaxStEmpAbsTrd/update.do",
			data : cv.itemsEdited[i],
			async: false,
			success : function(xhr) {
    	    	var data = JSON.parse(xhr);
            	
    	    	if(data.result != RESULT_OK) {
    				
    	    		if(data.errMsg == "LN_UPD_CHK1") stateMsg = LN_UPD_CHK1;
    				if(data.errMsg == "LN_UPD_CHK2") stateMsg = LN_UPD_CHK2;
    				if(data.errMsg == "LN_UPD_CHK3") stateMsg = LN_UPD_CHK3;
    				if(data.errMsg == "LN_UPD_CHK4") stateMsg = LN_UPD_CHK4;			
    			} 
    	    },
            error : function() {
    			stateMsg = "error";
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
			url : "/ajaxStEmpAbsTrd/create.do",
			data : cv.itemsAdded[i],
			async: false,
			success : function(xhr) {
            	var data = JSON.parse(xhr);
            	
    			if (data.result != RESULT_OK) {
    				
    				if(data.errMsg == "LN_INS_CHK1") stateMsg = LN_INS_CHK1;
					if(data.errMsg == "LN_INS_CHK2") stateMsg = LN_INS_CHK2;
				
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

    // Delete : 삭제 처리 
    for ( var i = 0; i <cv.itemsRemoved.length; i ++) {
    	console.debug(cv.itemsRemoved[i]);
		$.ajax({
			method : "post",
			url : "/ajaxStEmpAbsTrd/delete.do",
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

//지원받은시간(분) 저장
function rcvsupTmUpdate() {
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
	
	var stateMsg=RESULT_OK;	
	var paramsData = {
		'getComps' : $("#getComps").val()
		,'getLocId' : $("#getLocId").val()
		,'getOpertDe' : $("#getOpertDe").val()		
		,'getRcvsupTm' : $("#getRcvsupTm").val()		
	};
	
	$.ajax({
		method : "post",
		url : "/ajaxStEmpAbsTrd/SaveRcvsupTm.do",
		data : paramsData,
		async: false,
		success : function(xhr) {
        	var data = JSON.parse(xhr);
			if (data.result != RESULT_OK) {
				if(data.errMsg == "LN_INS_CHK1") stateMsg = LN_INS_CHK1;
				if(data.errMsg == "LN_INS_CHK2") stateMsg = LN_INS_CHK2;
			}
		     			
        },
        error : function() {
			toastMsg("error");
		},
		complete : function() {

		}
	});

	if(stateMsg == RESULT_OK){
		toastMsg(RESULT_OK);
		search();
    }else{
    	toastMsg(stateMsg);
    }
}

/**
 * 엑셀 다운로드
 */
function downloadExcel(){
	
	var fileName = "일일근태등록_"+getToday()+".xlsx";
	
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
		{binding:'opertDe',visible:false},						
		{binding:'clsCode',visible:false},				
		{binding:'locCode',visible:false},
		{binding:'empnm',header: '* '+ LB_FULL_NM, width: '*', align:'center',dataType:'String', maxLength:50,isReadOnly: true},		
		{binding:'empno',header: '* '+ LB_EMP_NUMBER, width: '*', align:'center',dataType:'String', maxLength:50,isReadOnly: true},		
		{header: '조', align: 'center',  columns: [
			{binding:'shiftwork',header: '코드', width: '*', align:'center',dataType:'String', maxLength:2},
			{binding:'shiftworkNm',header: '코드명', width: '*', align:'center',dataType:'String', format: 'n1', maxLength:50,isReadOnly: true}
		]},
		{binding:'logiType',header: '물류Check', width: '*', align:'center',dataType:'Boolean', maxLength:1},		
		{header: '근무코드', align: 'center',  columns: [
			{binding:'workCode',header: '코드', width: '*', align:'center',dataType:'String', maxLength:2},
			{binding:'workNm',header: '코드명', width: '*', align:'center',dataType:'String', maxLength:50,isReadOnly: true}
		]},
		{binding:'lrlyTime',header: '조퇴', width: '*', align:'center',dataType:'Number',  maxLength:3},
		{binding:'latenTime',header: '지각', width: '*', align:'center',dataType:'Number', maxLength:3},
		{binding:'gnotTime',header: '외출', width: '*', align:'center',dataType:'Number', maxLength:3},
		{binding:'arqstTime',header: '지원보낸시간', width: '*', align:'center',dataType:'Number', maxLength:3},
		{binding:'workPsbTime',header: '근무가능시간', width: '*', align:'center',dataType:'Number', maxLength:3,isReadOnly: true}								
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
			case "shiftwork":
				if(item.shiftwork==null || wijmo.isEmpty(item.shiftwork) || item.shiftwork == "" ){
				}else{					
					var flag = true;
					if(workMastG != null) {					
						workMastG.forEach (function (data, index) {			  		
							var mastCode = data.code;
							var masterName = data.codeNm;
							var itemCode = item.shiftwork;
							if(itemCode != null) {
								itemCode = itemCode.trim();
							}
							if(mastCode != null) {
								mastCode = mastCode.trim();
							}						
							if(itemCode == mastCode) {
								item.shiftworkNm = masterName;
								flag = false;
								return false;
							}
						});	
					}
					if(flag) {
						item.shiftwork = "";
						item.shiftworkNm = "";
					}						
				}
				return null;
			case "workCode":
				if(item.workCode==null || wijmo.isEmpty(item.workCode) || item.workCode == "" ){
				}else{
					var flag = true;
					var message = "";
					if(workMastA != null) {					
						workMastA.forEach (function (data, index) {			  		
							var mastCode = data.code;
							var masterName = data.codeNm;
							var overtimeM = data.overtimeM; //근무시간
							
							var itemCode = item.workCode;
							if(itemCode != null) {
								itemCode = itemCode.trim();
							}
							if(mastCode != null) {
								mastCode = mastCode.trim();
							}
							if(itemCode == mastCode) {
								item.workNm = masterName;
								//근무시간이 근무가능시간보다 클경우
								
								
								var numOvertimeM = getChangeNumber(overtimeM);	
								var numWorkPsbTime = getChangeNumber(item.workPsbTime);	//근무시간
								var numLrlyTime = getChangeNumber(item.lrlyTime);	    //조퇴
								var numLatenTime = getChangeNumber(item.latenTime);	    //지각
								var numGnotTime = getChangeNumber(item.gnotTime);	    //외출
								var workTime = numWorkPsbTime - (numLrlyTime + numLatenTime + numGnotTime);
								if(numOvertimeM > workTime) {
									flag = true;
									message = "주52시간관리로 OVER 되었습니다.";	
									return false;	
								}
								flag = false;
								return false;															
							}
						});	
					}
					if(flag) {
						item.workCode = "";
						item.workNm = "";
						if(message.length > 0) {
							return message;
						}
					}
				}
				return null;				
		}
		return null;
	}
	
}

function initSetCodeMaster(code){
	if($('#getComps').val() != ""){	
		$.ajax({
			method : "post",
			url : "/ajaxWorkCodeBase/search.do",
			data : {
				'getComps' : $("#getComps").val(),
				'getSe' : code
			},
			success : function(res) {
				if(code == "G") {
					workMastG = JSON.parse(res).list;
				}else if(code == "A") {
					workMastA = JSON.parse(res).list;					
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

function getToday(){
	var date = new Date();
	return date.getFullYear() + "-" + ("0"+(date.getMonth()+1)).slice(-2) + "-" + ("0"+date.getDate()).slice(-2);
}

function getChangeNumber(data) {
	if(typeof data != "undefined" && data != "" && data != null) {
		return Number(data);
	}else {
		return 0;
	}
}
	
$(document.body).ready(function() {
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
		initSetCodeMaster('G');	//조
		initSetCodeMaster('A');	//근무코드
		gridInit();  	//그리드 초기화
		gridEvent();	//그리드 이벤트
		handleEvent();	//프로그램 버튼 이벤트
		
		var nowDate = getToday();
		$("#getOpertDe").val(nowDate);		
	});		
});
