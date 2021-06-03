
//code intellisense typescript 정의
///<reference path = "../../wijmo/controls/wijmo.d.ts"/>	
///<reference path = "../../wijmo/controls/wijmo.grid.d.ts"/>
///<reference path = "../../wijmo/controls/wijmo.input.d.ts"/>

var lgsDstRtSum = 0;

var itemMast = null;

var workMastG = null;  //조
var workMastA = null;  //근무코드

var workMastGMap = null;  //조
var workMastAMap = null;  //근무코드

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
	getDeptMaster();
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
	}else if(!$("#getPartId").val()){
		toastMsg(LN_SELECT_PART);
		return false;
	}else if(!$("#getOpertDe").val()){
		toastMsg("작업일자를 입력해주세요.");
		return false;
	}	
	var url = "/ajaxStEmpAbsSta/search.do";	
	var params = {
		'getComps' : $("#getComps").val()
		,'getPartId' : $("#getPartId").val()
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
			for(var i=0; i<data.length; i++){
				
				if(data[i].locCode==null || wijmo.isEmpty(data[i].locCode) || data[i].locCode == "" ){
					return "[부서(반)]를 입력 하세요.";		
				}else{
					var flag = true;
					itemMast.forEach (function (data2, index) {	
//						console.log("i:"+i);
//						console.log("data[i].locCode:"+data[i].locCode);		  		
						var code = data2.code;
						var name = data2.name;	
						
						var trimCode = "";	
						if(code != null) {
							trimCode = code.trim();
						}
						var locCode = data[i].locCode;
						var trimLocCode = locCode.trim();
						
						if(trimLocCode == trimCode) {						
							data[i].locNm = name;
							flag = false;
							return false;
						}
					});		
				}
				
			}						
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


/**
 * 엑셀 다운로드
 */
function downloadExcel(){
	
	var fileName = "잔업신청현황_"+getToday()+".xlsx";
	
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

inputNumber.inputElement.maxLength = 3;

function gridInit(){
//	var comsBase = new DataMap(coms_base, 'id', 'name');
	var columnsDefinition=[	
		{binding:'opertDe',visible:false},
		{binding:'clsCode',visible:false},				
		{binding:'partCode',visible:false},
		//{binding:'locCode',visible:false},
		{binding:'locCode',header: LB_LOC_CODE ,width: 110, align:'center',dataType:'String', isReadOnly: true,allowMerging: true},
		{binding:'locNm',header: LB_LOC_NM ,width: 150, align:'center',dataType:'String', isReadOnly: true,allowMerging: true},
		{binding:'empnm',header: '* '+ LB_FULL_NM, width: 120, align:'center',dataType:'String', maxLength:50,isReadOnly: true},		
		{binding:'empno',header: '* '+ LB_EMP_NUMBER, width: 120, align:'center',dataType:'String', maxLength:50,isReadOnly: true},		
		{header: '근무조', align: 'center',  columns: [
			{binding:'shiftwork',header: '코드', width: 80, align:'center',dataType:'String', maxLength:2,isReadOnly: true},
			{binding:'shiftworkNm',header: '코드명', width: 120, align:'center',dataType:'String',  maxLength:50,isReadOnly: true}
		]},
		{binding:'strLogiType',header: '물류Check', width: 120, align:'center',dataType:'String', maxLength:1,isReadOnly: true},		
		{header: '근무코드', align: 'center',  columns: [
			{binding:'workCode',header: '코드', width: 80, align:'center',dataType:'String', maxLength:2,isReadOnly: true},
			{binding:'workNm',header: '코드명', width: 120, align:'center',dataType:'String', maxLength:50,isReadOnly: true}
		]},		
		{binding:'rsnsOvrt',header: '잔업사유', width: 180, align:'left',dataType:'String', maxLength:50,isReadOnly: true},
		{binding:'arqstTime',header: '지원보낸시간', width: 150, align:'center',dataType:'Number', isRequired:false,isReadOnly: true},
		{binding:'workPsbTime',header: '근무가능시간', width: 150, align:'center',dataType:'Number', isReadOnly: true,isReadOnly: true},
		{binding:'mealDiv',header: '식사구분', width: 120, align:'center',dataType:'Number', isReadOnly: true,isReadOnly: true},
		{binding:'rownum',visible:false}
	];
	//컬럼 초기화
	flexGrid.initialize({
		columns: columnsDefinition,
		allowMerging:true
	});
}

/*
function validationCodeNull(item){
	if(item.shiftwork.length > 0 
	||item.shiftwork.length > 0 
	){
		
	}
}
*/


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
			case "lrlyTime":
				if(item.lrlyTime==null || wijmo.isEmpty(item.lrlyTime) || item.lrlyTime == ""){
				}else{
					var strVal = item.lrlyTime.toString().split(".")[0];
					 return strVal.length > 4 ? "네 자리 이하 정수를 입력하시오" : "";
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
					workMastGMap = new wijmo.grid.DataMap(workMastG, 'code', 'code');						
				}else if(code == "A") {
					workMastA = JSON.parse(res).list;	
					workMastAMap = new wijmo.grid.DataMap(workMastA, 'code', 'code');										
				}
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
		commonGrid.init(flexGrid,cv); //그리드 공통부분	
		initSetCodeMaster('G');	//조
		initSetCodeMaster('A');	//근무코드
		getDeptMaster(); //부서정보
		gridInit();  	//그리드 초기화
		gridEvent();	//그리드 이벤트
		handleEvent();	//프로그램 버튼 이벤트
		
		
	});		
});
