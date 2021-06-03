///<reference path = "../../spreadJS/definition/gc.spread.sheets.d.ts"/>
//GC.Spread.Sheets.LicenseKey = "";  
var spread = new GC.Spread.Sheets.Workbook(document.getElementById("grid"),{sheetCount:1,newTabVisible:false});  
var sheet = spread.getActiveSheet();
var excelIO = new GC.Spread.Excel.IO();
//var spreadNS = GC.Spread.Sheets;
//var SheetArea = spreadNS.SheetArea;


function downloadExcel(){
	
	var fileName = sheet.getName()+".xlsx";
	
	var json = spread.toJSON({
		includeBindingSource : true ,
		rowHeadersAsFrozenColumns : true ,
		columnHeadersAsFrozenRows : true ,
		ignoreFormula : true ,
		ignoreStyle : false
	});
		
    // here is excel IO API
    excelIO.save(json, function(blob){
        saveAs(blob, fileName);
    }, function (e) {
        // process error
        console.log(e);
    }, {password: ""});
    
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
				var data = JSON.parse(res);			
				
				dataLength = data.list.length;
				
				if (data.list.length > 0) {
					$('#getCusnm').val(data.list[0].cusnm);
				}
				else toastMsg(LN_IO_CHK1);
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


function handleEvent(){
	$('.getPyvnd').on('change', function() {
		$(".getCusnm").val("");
	});
	
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
		var row = sheet.getRowCount();
		sheet.addRows(row,1);
		sheet.setValue(row,0,$(".getPyvnd").val());
		sheet.setValue(row,1,$(".getComps").val());
		sheet.setActiveCell(row, 5);
		spread.focus(true);
	});
	
	//행 삭제
	$("._delBtn").on("click",function(){
		var check = confirm(LN_CONFIRM_DELETE);
		
		if(check){
			
			var activeRowIndex = sheet.getActiveRowIndex();
			var activeColIndex = sheet.getActiveColumnIndex();
			sheet.deleteRows(sheet.getActiveRowIndex(), 1);
			sheet.setActiveCell(activeRowIndex-1, activeColIndex);
			spread.focus(true);
		}
	});
	
}



function search(){
	
	if(!$(".getComps").val()){
		toastMsg(LN_SELECT_COMPS);
		return false;
	}else if(!$(".getPyvnd").val()){
		toastMsg(LN_SELECT_PYVND);
		return false;
	}
	
	var params = {
		'getComps' : $(".getComps").val(),
		'getPyvnd' : $(".getPyvnd").val()
	};
	
	$.ajax({
		method : "post",
		url : "/ajaxCustTypeOrderExceptMst/search.do",
		data : params,
		success : function(res) {
			var data = JSON.parse(res);
			
			spread.suspendPaint();
			sheet.setDataSource(data.list);
			spread.resumePaint();
			$("#updateButton").attr("disabled",false);
		},
		error : function() {
			//console.log("dataset.error");
		},
		completed : function() {
			//console.log("dataset.completed");
			setTimeout(function() {
				mask.close();				
			}, 500);
			
		}
	});
}

//수정
function update(){
	
	if(!$(".getComps").val()){
		toastMsg(LN_SELECT_COMPS);
		return false;
	}else if(!$(".getPyvnd").val()){
		toastMsg(LN_SELECT_PYVND);
		return false;
	}
	
	mask.open();
	
	var updateRows = sheet.getDirtyRows();
	updateRows.map(function(item){
		//console.log("update:");
		//console.log(item.item);
		updateCar(item.item);
	});
	
	var insertRows = sheet.getInsertRows();
	insertRows.map(function(item){
		//console.log("insert");
		//console.log(item.item);
		insertCar(item.item);
		
	});
	
	var deleteRows = sheet.getDeletedRows();
	deleteRows.map(function(item){
		//console.log("delete");
		//console.log(item.originalItem);
		deleteCar(item.originalItem);
		
	});
	
	mask.close();
	search();
	
	
}

/**
 * 스프레드 추가
 */
function insertCar(item){
	
	$.ajax({
		method : "post",
		url : "/ajaxCustTypeOrderExceptMst/create.do",
		data : item,
		async: false,
		success : function(res) {
			var data = JSON.parse(res);

			if (data.result === RESULT_OK) {
				toastMsg(RESULT_OK);
				
			} else {

				setTimeout(function() {
					//toastMsg(data.errMsg);
					if(data.errMsg == "LN_INS_CHK1") toastMsg(LN_INS_CHK1);
					if(data.errMsg == "LN_INS_CHK2") toastMsg(LN_INS_CHK2);
				}, 500);
				
			}
		},
		error : function() {
			toastMsg("error");
		},
		complete : function() {
			
		}
	});
}


/**
 * 스프레드 수정
 */
function updateCar(item){
	
	$.ajax({
		url : "/ajaxCustTypeOrderExceptMst/update.do",
		type : "post",
		data : item,
		async: false,
		success : function(res) {
			var data = JSON.parse(res);
			
			if(data.result === RESULT_OK) {
				stateMsg = RESULT_OK;
			} else {
				//stateMsg = data.errMsg;
				
				if(data.errMsg == "LN_UPD_CHK1") stateMsg = LN_UPD_CHK1;
				if(data.errMsg == "LN_UPD_CHK2") stateMsg = LN_UPD_CHK2;				
				if(data.errMsg == "LN_UPD_CHK3") stateMsg = LN_UPD_CHK3;
			}
			
		},
		error : function() {
			stateMsg = "error";
		},
		complete : function() {
			toastMsg(stateMsg);
		}
	});	
}

function deleteCar(item){
	
	$.ajax({
		url : "/ajaxCustTypeOrderExceptMst/delete.do",
		type : "get",
		data : item,
		async: false,
		success : function(res) {
			//console.log("delete.success");
			var data = JSON.parse(res);
			if(data.result === "OK") {
				stateMsg = "OK";
			} else {
				//console.log("err");
				stateMsg = data.errMsg?data.errMsg:"";
			}
		},
		error : function() {
			stateMsg = "error";
		},
		complete : function() {
			setTimeout(function() {
				if(stateMsg == "LN_DEL_CHK1") toastMsg(LN_DEL_CHK1);
				else toastMsg(stateMsg);
			}, 1000);
		}
	});
	
}

/**
 * 상태바 활성화 
 */
function statusBarInit(){
	var statusBar = new GC.Spread.Sheets.StatusBar.StatusBar(document.getElementById("statusBar"));
	statusBar.bind(spread);
}

/**
 * 스프레드 초기화
 */
function spreadInit(){
	
	statusBarInit();  //status 바 활성화
	//sheet.visible(false);  //spread 보이기 여부
	spread.options.allowUserZoom = true;	//줌허용
	//sheet.setColumnWidth(0,160);  //spread 컬럼 width 설정
	
	spread.suspendPaint();		//페인팅 일시적 비활성화시키고 스프레드 변경작업이 끝난후 다시 활성화 시키는 함수임, resumePaint()와 한쌍. => 속도개선
	
	sheet.name("업체차종서열제외마스타");  //sheet이름 지정
	sheet.setRowCount(0);
	var columns=[
		{name:'pyvnd',visible:false},
		{name:'comps',visible:false},
		{name:'oldMkcar',visible:false},
		{name:'oldSeyno',visible:false},
		{name:'oldSeycd',visible:false},
	    {name:"mkcar",displayName:"차종",resizable: true,size:"*"},
	    {name:"seyno",displayName:"서열",size:"*"},
	    {name:"seycd",displayName:"번호",size:"*"}
	];
	
	sheet.bindColumns(columns);
	sheet.autoGenerateColumns = false;
	
	
	//sheet.deleteRows(0,1);
	
    spread.resumePaint();
	
	/*변경된 데이터는 dirty에 저장되는데 정렬중인 경우 이를 막음.*/
	spread.bind(GC.Spread.Sheets.Events.RangeSorting, function(sender, args) {
	    sheet.supsendDirty();
	});

	spread.bind(GC.Spread.Sheets.Events.RangeSorted, function(sendder, args) {
	    sheet.resumeDirty();
	});
	
}


$(document.body).ready(function() {
	
	spreadInit();
	handleEvent();
	
});
