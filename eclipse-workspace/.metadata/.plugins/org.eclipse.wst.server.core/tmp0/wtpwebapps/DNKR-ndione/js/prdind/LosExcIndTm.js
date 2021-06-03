var lgsDstRtSum = 0;

var workMast = null; // 빵,쿠폰 마스트

// 컬랙션 뷰는 조회후에 그리드의 상태변경을 체크한다.
var cv = new wijmo.collections.CollectionView(null); // 컬랙션뷰 전역변수
var flexGrid = new wijmo.grid.FlexGrid('#wijmoGrid'); // 그리드 전역변수
var zoomSize = 11;
var baseLgstTime = 0;

/**
 * 팝업창에서 값넘겨받아 부모창에 데이터 set
 * 
 * @param returnValue
 */
function getReturnValue(returnValue) {
	if (returnValue !== null) {
		var custObj = JSON.parse(returnValue);

		$('#getLocId').val(custObj.code);
		$('#getLocNm').val(custObj.name);
	}
}

/**
 * 등록시 오류검증
 */
function validation(item) {
	if (item.clsCode == null || wijmo.isEmpty(item.clsCode) || item.clsCode == "") {
		toastMsg("수정이나 추가한 행의 [사업부]컬럼을 입력해야 됩니다.");
		return false;
	}

	return true;
}

function handleEvent() {
	// 등록폼 닫기버튼
	$("._closeBtn_").on("click", function() {
		var target = this.getAttribute("data-click-target");
		addBtnUiSet(this);
	});

	$('._custBtn_').on('click', function() {
		window.open("/ajaxPrdctIndComBase/initDeptPop.do","deptPop","width=550,height=620,scrollbars=yes,top=100,left=100");
	});

	// 그리드 row 삭제
	$("._delBtn").on("click", function() {
		cv.remove(cv.currentItem);
	});
}

function search() {
	if (!$("#getComps").val()) {
		toastMsg(LN_SELECT_COMPS);
		return false;
	} else if (!$("#getLocId").val()) {
		toastMsg(LN_SELECT_DEPT);
		return false;
	} else if (!$("#getOpertDe").val()) {
		toastMsg("작업일자를 입력해주세요.");
		return false;
	}

	var url = "/ajaxLosExcIndTm/search.do";
	var opertDe = $("#getOpertDe").val();
	var params = {
		'getComps' : $("#getComps option:selected").val(),
		'getLocId' : $("#getLocId").val(),
		'getOpertDe' : opertDe
	};

	mask.open();
	$.ajax({
		method : "post",
		url : url,
		data : params,
		success : function(res) {

			var data = JSON.parse(res).list;
			cv.sourceCollection = data;

		},
		error : function(e) {
			console.log("dataset.error : " + e);
			setTimeout(function() {
				mask.close();
			}, 500);
		},
		complete : function() {
			// console.log("dataset.completed");
			setTimeout(function() {
				mask.close();
			}, 500);

		}
	});
	
}

// 수정
function update() {
	/**
	 * 익스플로러에서 그리드외 다른영역으로 포커스가 빠졌을경우(클릭) 컬랙션뷰에서 변경된 내용을 인식하지 못하는 버그발생 아래처럼 포커스와
	 * 셀을 강제로 영역을 지정함.
	 */
	flexGrid.focus();
	flexGrid.select(new wijmo.grid.CellRange(0, 0, 0, 0), true);

	// validation
	for (var i = 0; i < cv.itemsAdded.length; i++) {
		if (!validation(cv.itemsAdded[i])) {
			return false;
		}
		isModify = true;
	}

	for (var i = 0; i < cv.itemsEdited.length; i++) {
		if (!validation(cv.itemsEdited[i])) {
			return false;
		}
		isModify = true;
	}

	var stateMsg = RESULT_OK;
	var isModify = false;

	// Update : 업데이트 프로세스
    for ( var i = 0; i <cv.itemsEdited.length; i ++) {
		console.log(cv.itemsEdited[i]);
		chkItem = cv.itemsEdited[i];
		$.ajax({
			method : "post",
			url : "/ajaxLosExcIndTm/update.do",
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
			url : "/ajaxLosExcIndTm/create.do",
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
			url : "/ajaxLosExcIndTm/delete.do",
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
function downloadExcel() {

//	var fileName = $("#opertDe").val + "손실제외간접시간_.xlsx";	
	var fileName = "손실제외간접시간_"+getToday()+".xlsx";
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


function getLines() {
	var url = "/ajaxLosExcIndTm/searchLine.do";
	var params = {
		'getComps' : $("#getComps").val(),
		'getLocId' : $("#getLocId").val()
	};
	var columnsDefinition = [];
	$.ajax({
		method : "post",
		url : url,
		data : params,
		success : function(res) {
			var data = JSON.parse(res).linelist;
		},
		error : function(e) {
			setTimeout(function() {
				mask.close();
			}, 500);
		},
		complete : function() {

		}
	});
	return columnsDefinition;
}

function gridInit(flag) {
	if(!flag) {
		search();
	}
	var gridColumns = new Array();
	var url = "/ajaxLosExcIndTm/searchLine.do";
	var params = {
		'getComps' : $("#getComps").val(),
		'getLocId' : $("#getLocId").val()
	};
	var columnsDefinition = new Array();

	var jObject1 = new Object();
	jObject1.binding = 'clsCode';
	jObject1.visible = false;
	columnsDefinition.push(jObject1);

	var jObject2 = new Object();
	jObject2.binding = 'locCode';
	jObject2.visible = false;
	columnsDefinition.push(jObject2);

	var jObject3 = new Object();
	jObject3.binding = 'lineCode';
	jObject3.visible = false;	
	columnsDefinition.push(jObject3);

	var jObject4 = new Object();
	jObject4.binding = 'se';
	jObject4.visible = false;
	columnsDefinition.push(jObject4);

	var jObject5 = new Object();
	jObject5.binding = 'seNm';
	jObject5.align = 'center';
	jObject5.header = '작업구분';
	jObject5.dataType = 'String';
	jObject5.width = 120;
	jObject5.visible = true;
	jObject5.isReadOnly = true;
	jObject5.allowMerging = true;
	columnsDefinition.push(jObject5);

	var jObject6 = new Object();
	var jObject6_1 = new Array();
	var jObject6_1_1 = new Object();
	var jObject6_1_2 = new Object();
	jObject6.header = '구분';
	jObject6.align = 'center';
	jObject6_1_1.binding = 'code';
	jObject6_1_1.header = '코드';
	jObject6_1_1.width = 60;
	jObject6_1_1.align = 'center';
	jObject6_1_1.isReadOnly = true;
	jObject6_1_1.visible = true;

	jObject6_1_2.binding = 'codeNm';
	jObject6_1_2.header = '코드명';
	jObject6_1_2.width = 100;
	jObject6_1_2.align = 'center';
	jObject6_1_2.isReadOnly = true;
	jObject6_1_2.visible = true;
	jObject6_1.push(jObject6_1_1);
	jObject6_1.push(jObject6_1_2);
	jObject6.columns = jObject6_1;
	columnsDefinition.push(jObject6);

//	var inputNumber = new wijmo.input.InputNumber(document.createElement('div'),{
//		format:'n0'
//	});
//	inputNumber.inputElement.maxLength = 8;
	flexGridFilter.filterColumns = [];	 //필터제거		
	
	// 부서(반)의 검색값이 존재할 경우에만 라인을 표시한다.
	if ($("#getLocId").val() != "") {
		$.ajax({
			method : "post",
			url : url,
			data : params,
			async : true,
			success : function(res) {

				if (res != 'null') {
					var data = JSON.parse(res).lineList;

					if (data.length > 0) {
						for (var i = 0; i < data.length; i++) {
							var jObject = new Object();
							jObject.binding = "line_" + data[i].locCode+ "_" + data[i].lineCode;
							jObject.header = data[i].lineNm;
							jObject.align = 'center';
							jObject.dataType = 'Number';
							jObject.maxLength = 8;
//							jObject.editor = inputNumber;
							jObject.width = 125;
							jObject.isRequired = false;
							columnsDefinition.push(jObject);
						}
						
					} else {
						var jObject = new Object();
						jObject.header = '해당 검색에 대한 라인이 없습니다.';
						jObject.align = 'center';
						jObject.width = '*';
						columnsDefinition.push(jObject);
					}
					flexGrid.initialize({
						columns : columnsDefinition,
						allowMerging : 'Cells',
						allowSorting: 0
//						allowPinning: 0						
					});
//					flexGrid.columnHeaders.rows.defaultSize = 40; // 열 헤더 영역에 행의 높이 설정
				}
				setTimeout(function() {
					mask.close();
				}, 500);
			},
			error : function(e) {
				setTimeout(function() {
					mask.close();
				}, 500);
			},
			complete : function() {
			}
		});
	} else {
		var jObjectInit = new Object();
		jObjectInit.header = '부서(반) 선택시 라인이 표시됩니다.';
		jObjectInit.align = 'center';
		jObjectInit.width = '*';
		columnsDefinition.push(jObjectInit);

		flexGrid.initialize({
			columns : columnsDefinition,
			allowMerging : 'Cells'
		});
//		flexGrid.columnHeaders.rows.defaultSize = 40;
		mask.close();
	}
	// 컬럼 초기화

}

function gridEvent() {
	// validation

}

function calFunction(s, e) {
	return 0;
}

function clearGrid(){
	cv.sourceCollection=[];
}

/**
 * 부서코드로 업체명 검색하여 데이터 set
 * 
 * @param 업체코드
 */
function getDeptSch(gubn, value, s, e) {
	if (value != "") {
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
					if (gubn == "input")
						$('#getLocNm').val(data.list[0].name);
				} else {
					toastMsg(LN_IO_CHK1 + " : " + value);
					if (gubn == "input") {
						$('#getLocCode').val("");
					}
					if (gubn == "grid") {
						var oldValue = s.getCellData(e.row, 5, false);
						if (oldValue == "" || oldValue == null
								|| oldValue == undefined)
							oldValue = "0"; // dataType:'Number' 에는 공백 초기화가 안됨.
						s.setCellData(e.row, e.col, oldValue);
					}
				}
			},
			error : function() {
				// console.log("dataset.error");
			},
			completed : function() {
				// console.log("dataset.completed");
			}
		});
	}
}

function setRowReadOnly() {
	var rows = flexGrid.rows;
	var cnt = 0;
	for (var i = 0; i < rows.length; i++) {
		cnt = i + 1;
		if (cnt % 2 == 0) {
		} else {
			rows[i].isReadOnly = true;
		}
	}
}

function getToday() {
	var date = new Date();
	return date.getFullYear() + "-" + ("0" + (date.getMonth() + 1)).slice(-2)
			+ "-" + ("0" + date.getDate()).slice(-2);
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

	$.getScript('/js/sal/gridCommon.js').done(function() {
		commonGrid.init(flexGrid, cv); // 그리드 공통부분
		gridInit(true); // 그리드 초기화
		handleEvent(); // 프로그램 버튼 이벤트

	});
	
	$("#delBtn").on('click', function(e) {
		var item = flexGrid.selectedItems;
		var rowNo = flexGrid.selection.row;
		for(var i=0; i<item.length; i++){
			var data= item[i];
			for (var key in data) {
				if(key.indexOf("line_") > -1){
					flexGrid.setCellData(rowNo, key, 0);
				} 
			}
		}
		
	});
	

		

});
