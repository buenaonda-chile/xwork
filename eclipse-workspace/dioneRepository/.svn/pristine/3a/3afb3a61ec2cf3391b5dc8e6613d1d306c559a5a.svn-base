///<reference path = "../../spreadJS/definition/gc.spread.sheets.d.ts"/>
//GC.Spread.Sheets.LicenseKey = "";  

var isValidationCheck = true;

var spread = new GC.Spread.Sheets.Workbook(document.getElementById("grid"),{sheetCount:1,newTabVisible:false});  
var sheet = spread.getActiveSheet();
var excelIO = new GC.Spread.Excel.IO();
//var spreadNS = GC.Spread.Sheets;
//var SheetArea = spreadNS.SheetArea;
var spreadNS = GC.Spread.Sheets;
var cellStyle = new spreadNS.Style();
    cellStyle.backColor = "red";
    cellStyle.backColor = "white";

var duzon_loc_code = [
	 {code:"1001",name:"제조1T"}
	,{code:"1002",name:"제조2T"}
];

var duzon_part_code = [
	 {code:"1001",name:"제조1P"}
	,{code:"1002",name:"제조2P"}
];

var duzon_team_code = [
	 {code:"1001",name:"ETC조립반"}
	,{code:"1002",name:"ETC서브반"}
];


var duzon_prdt_code = [
	 {code:"A",name:"제품A"}
	,{code:"B",name:"제품B"}
];


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

spread.highlightInvalidData(true);  
//var dv = GcSpread.Sheets.DefaultDataValidator.createTextLengthValidator(GC.Spread.Sheets.ConditionalFormatting.ComparisonOperators.equalsTo, "4", "20");  
//dv.showInputMessage = true;  
//dv.inputMessage = "숫자 4자리 입니다.";  
//dv.inputTitle = "tip";  



var dv1 = GC.Spread.Sheets.DataValidation.createNumberValidator (GC.Spread.Sheets.ConditionalFormatting.ComparisonOperators.between, "10" , "99" , true );
dv1.showInputMessage = true;  
dv1.inputMessage = "숫자 2자리 입니다.";  
dv1.inputTitle = "tip";  




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
	//			else toastMsg(LN_IO_CHK1);
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
		var row = sheet.getRowCount();
		sheet.addRows(row,1);

		setAddStyle(row);
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

	var hoverStyle1 = new GC.Spread.Sheets.Style();
	//hoverStyle1.backColor = "pink";
	hoverStyle1.foreColor = "red";
	
	var hoverStyle2 = new GC.Spread.Sheets.Style();
	//hoverStyle2.backColor = "white";
	hoverStyle2.foreColor = "black";

	var numberCheck = /^[0-9]/g;
	
	
	sheet.bind(GC.Spread.Sheets.Events.ValueChanged, function (sender, args) {
		var changeCode = sheet.getValue(args.row,args.col).toString();  //부서(반)코드
//		var partCode = sheet.getValue(args.row,5).toString();  //부서(Part)코드	
		//부서(반)코드
		if(args.col == 3) {
			//duzon_loc_code  4
			var flag = true;
			duzon_loc_code.forEach (function (data, index) {			  		
				var code = data.code;
				var name = data.name;
				if(changeCode == code) {
					sheet.setValue(args.row,4,name);
					flag = false;
					return false;
				}
			});	
			if(flag) {
				sheet.setValue(args.row,4,"");	
			}
		}	
		//부서(Part)
		if(args.col == 5) {
			//duzon_part_code
			var flag = true;
			duzon_part_code.forEach (function (data, index) {			  		
				var code = data.code;
				var name = data.name;
				if(changeCode == code) {
					sheet.setValue(args.row,6,name);
					flag = false;
					return false;
				}
			});	
			if(flag) {
				sheet.setValue(args.row,6,"");	
			}
		}
		//부서(Team)
		if(args.col == 7) {
			//duzon_team_code
			var flag = true;
			duzon_team_code.forEach (function (data, index) {			  		
				var code = data.code;
				var name = data.name;
				if(changeCode == code) {
					sheet.setValue(args.row,8,name);
					flag = false;
					return false;
				}
			});	
			if(flag) {
				sheet.setValue(args.row,8,"");	
			}
		}

		//제품1
		if(args.col == 11) {
			var flag = true;
			duzon_prdt_code.forEach (function (data, index) {			  		
				var code = data.code;
				var name = data.name;
				if(changeCode == code) {
					sheet.setValue(args.row,12,name);
					flag = false;
					return false;
				}
			});	
			if(flag) {
				sheet.setValue(args.row,12,"");	
			}
		}			
					
		//제품2
		if(args.col == 13) {
			var flag = true;
			duzon_prdt_code.forEach (function (data, index) {			  		
				var code = data.code;
				var name = data.name;
				if(changeCode == code) {
					sheet.setValue(args.row,14,name);
					flag = false;
					return false;
				}
			});	
			if(flag) {
				sheet.setValue(args.row,14,"");	
			}		
		}	
		
		//제품3
		if(args.col == 15) {
			var flag = true;
			duzon_prdt_code.forEach (function (data, index) {			  		
				var code = data.code;
				var name = data.name;
				if(changeCode == code) {
					sheet.setValue(args.row,16,name);
					flag = false;
					return false;
				}
			});	
			if(flag) {
				sheet.setValue(args.row,16,"");	
			}
		}					
		

		var locName = sheet.getValue(args.row,4).toString();
		var locNameLen = locName.length;
		if(locNameLen < 1) {
			sheet.setStyle(args.row, 3, hoverStyle1, spreadNS.SheetArea.viewport);
			sheet.getCell(args.row, 3, GcSpread.Sheets.SheetArea.viewport).locked(false);
			sheet.getCell(args.row, 3).cellPadding('0 0 0 3').vAlign(GC.Spread.Sheets.VerticalAlign.center).hAlign(GC.Spread.Sheets.VerticalAlign.center);						
		}else{
			sheet.setStyle(args.row, 3, hoverStyle2, spreadNS.SheetArea.viewport);
			sheet.getCell(args.row, 3, GcSpread.Sheets.SheetArea.viewport).locked(false);
			sheet.getCell(args.row, 3).cellPadding('0 0 0 3').vAlign(GC.Spread.Sheets.VerticalAlign.center).hAlign(GC.Spread.Sheets.VerticalAlign.center);									
		}


		var partName = sheet.getValue(args.row,6).toString();
		var partNameLen = partName.length;
		if(partNameLen < 1) {
			sheet.setStyle(args.row, 5, hoverStyle1, spreadNS.SheetArea.viewport);
			sheet.getCell(args.row, 5, GcSpread.Sheets.SheetArea.viewport).locked(false);
			sheet.getCell(args.row, 5).cellPadding('0 0 0 3').vAlign(GC.Spread.Sheets.VerticalAlign.center).hAlign(GC.Spread.Sheets.VerticalAlign.center);						
		}else{
			sheet.setStyle(args.row, 5, hoverStyle2, spreadNS.SheetArea.viewport);
			sheet.getCell(args.row, 5, GcSpread.Sheets.SheetArea.viewport).locked(false);
			sheet.getCell(args.row, 5).cellPadding('0 0 0 3').vAlign(GC.Spread.Sheets.VerticalAlign.center).hAlign(GC.Spread.Sheets.VerticalAlign.center);									
		}

		
		

/*
		var paymentCd = sheet.getValue(args.row,0).toString();
		var paymentCdLen = paymentCd.length;
		if(paymentCdLen != 4 || !numberCheck.test(paymentCd)) {
//			isValidationCheck = false;
			validColumn1.push(args.row);
			sheet.setStyle(args.row, 0, hoverStyle1, spreadNS.SheetArea.viewport);
			sheet.getCell(args.row, 0, GcSpread.Sheets.SheetArea.viewport).locked(false);			
//			sheet.setValue(args.row,0,null);
			sheet.getCell(args.row, 0).cellPadding('0 0 0 3').vAlign(GC.Spread.Sheets.VerticalAlign.center).hAlign(GC.Spread.Sheets.VerticalAlign.center);
		}else{
//			isValidationCheck = true;
			sheet.setStyle(args.row, 0, hoverStyle2, spreadNS.SheetArea.viewport);
			sheet.getCell(args.row, 0, GcSpread.Sheets.SheetArea.viewport).locked(false);
			sheet.getCell(args.row, 0).cellPadding('0 0 0 3').vAlign(GC.Spread.Sheets.VerticalAlign.center).hAlign(GC.Spread.Sheets.VerticalAlign.center);
		}
*/		
	});	
}

function setSelectStyle(row) {
/*	
	sheet.getCell(row, 0).cellPadding('0 0 0 3').vAlign(GC.Spread.Sheets.VerticalAlign.center).hAlign(GC.Spread.Sheets.HorizontalAlign.center);	//라인코드
	sheet.getCell(row, 1).cellPadding('0 0 0 3').vAlign(GC.Spread.Sheets.VerticalAlign.center).hAlign(GC.Spread.Sheets.HorizontalAlign.left);	//라인명	
	sheet.getCell(row, 2).cellPadding('0 0 0 3').vAlign(GC.Spread.Sheets.VerticalAlign.center).hAlign(GC.Spread.Sheets.HorizontalAlign.center);	//부서반(코드)	
	sheet.getCell(row, 3).cellPadding('0 0 0 3').vAlign(GC.Spread.Sheets.VerticalAlign.center).hAlign(GC.Spread.Sheets.HorizontalAlign.left);	//부서반(명)			
	sheet.getCell(row, 4).cellPadding('0 0 0 3').vAlign(GC.Spread.Sheets.VerticalAlign.center).hAlign(GC.Spread.Sheets.HorizontalAlign.center);	//부서Part(코드)		
	sheet.getCell(row, 5).cellPadding('0 0 0 3').vAlign(GC.Spread.Sheets.VerticalAlign.center).hAlign(GC.Spread.Sheets.HorizontalAlign.left);	//부서Part(명)		
	sheet.getCell(row, 6).cellPadding('0 0 0 3').vAlign(GC.Spread.Sheets.VerticalAlign.center).hAlign(GC.Spread.Sheets.HorizontalAlign.center);	//부서Team(코드)		
	sheet.getCell(row, 7).cellPadding('0 0 0 3').vAlign(GC.Spread.Sheets.VerticalAlign.center).hAlign(GC.Spread.Sheets.HorizontalAlign.left);	//부서Team(명)
	sheet.getCell(row, 8).cellPadding('0 0 0 3').vAlign(GC.Spread.Sheets.VerticalAlign.center).hAlign(GC.Spread.Sheets.HorizontalAlign.center);		
	sheet.getCell(row, 9).cellPadding('0 0 0 3').vAlign(GC.Spread.Sheets.VerticalAlign.center).hAlign(GC.Spread.Sheets.HorizontalAlign.center);		
	sheet.getCell(row, 10).cellPadding('0 0 0 3').vAlign(GC.Spread.Sheets.VerticalAlign.center).hAlign(GC.Spread.Sheets.HorizontalAlign.left);		
	sheet.getCell(row, 11).cellPadding('0 0 0 3').vAlign(GC.Spread.Sheets.VerticalAlign.center).hAlign(GC.Spread.Sheets.HorizontalAlign.center);		
	sheet.getCell(row, 12).cellPadding('0 0 0 3').vAlign(GC.Spread.Sheets.VerticalAlign.center).hAlign(GC.Spread.Sheets.HorizontalAlign.left);		
	sheet.getCell(row, 13).cellPadding('0 0 0 3').vAlign(GC.Spread.Sheets.VerticalAlign.center).hAlign(GC.Spread.Sheets.HorizontalAlign.center);		
	sheet.getCell(row, 14).cellPadding('0 0 0 3').vAlign(GC.Spread.Sheets.VerticalAlign.center).hAlign(GC.Spread.Sheets.HorizontalAlign.left);		
	sheet.getCell(row, 15).cellPadding('0 0 0 3').vAlign(GC.Spread.Sheets.VerticalAlign.center).hAlign(GC.Spread.Sheets.HorizontalAlign.center);	
*/
    sheet.getCell(row, 0).backColor("#D1CBC5");		
    sheet.getCell(row, 1).backColor("#D1CBC5");	
    sheet.getCell(row, 2).backColor("#D1CBC5");	
    sheet.getCell(row, 4).backColor("#D1CBC5");	
    sheet.getCell(row, 6).backColor("#D1CBC5");		
    sheet.getCell(row, 8).backColor("#D1CBC5");	
    sheet.getCell(row, 12).backColor("#D1CBC5");	
    sheet.getCell(row, 14).backColor("#D1CBC5");		
    sheet.getCell(row, 16).backColor("#D1CBC5");	
	
    sheet.setDataValidator(row, 0, dv1);		

    var range = sheet.getRange(row-1, 0, row,17 );
    range.setBorder(new spreadNS.LineBorder("#EBECEB", spreadNS.LineStyle.thin), {all: true});
}

function setAddStyle(row) {
/*
	sheet.getCell(row, 0).cellPadding('0 0 0 3').vAlign(GC.Spread.Sheets.VerticalAlign.center).hAlign(GC.Spread.Sheets.HorizontalAlign.center);	//라인코드
	sheet.getCell(row, 1).cellPadding('0 0 0 3').vAlign(GC.Spread.Sheets.VerticalAlign.center).hAlign(GC.Spread.Sheets.HorizontalAlign.left);	//라인명	
	sheet.getCell(row, 2).cellPadding('0 0 0 3').vAlign(GC.Spread.Sheets.VerticalAlign.center).hAlign(GC.Spread.Sheets.HorizontalAlign.center);	//부서반(코드)	
	sheet.getCell(row, 3).cellPadding('0 0 0 3').vAlign(GC.Spread.Sheets.VerticalAlign.center).hAlign(GC.Spread.Sheets.HorizontalAlign.left);	//부서반(명)			
	sheet.getCell(row, 4).cellPadding('0 0 0 3').vAlign(GC.Spread.Sheets.VerticalAlign.center).hAlign(GC.Spread.Sheets.HorizontalAlign.center);	//부서Part(코드)		
	sheet.getCell(row, 5).cellPadding('0 0 0 3').vAlign(GC.Spread.Sheets.VerticalAlign.center).hAlign(GC.Spread.Sheets.HorizontalAlign.left);	//부서Part(명)		
	sheet.getCell(row, 6).cellPadding('0 0 0 3').vAlign(GC.Spread.Sheets.VerticalAlign.center).hAlign(GC.Spread.Sheets.HorizontalAlign.center);	//부서Team(코드)		
	sheet.getCell(row, 7).cellPadding('0 0 0 3').vAlign(GC.Spread.Sheets.VerticalAlign.center).hAlign(GC.Spread.Sheets.HorizontalAlign.left);	//부서Team(명)
	sheet.getCell(row, 8).cellPadding('0 0 0 3').vAlign(GC.Spread.Sheets.VerticalAlign.center).hAlign(GC.Spread.Sheets.HorizontalAlign.center);		
	sheet.getCell(row, 9).cellPadding('0 0 0 3').vAlign(GC.Spread.Sheets.VerticalAlign.center).hAlign(GC.Spread.Sheets.HorizontalAlign.center);		
	sheet.getCell(row, 10).cellPadding('0 0 0 3').vAlign(GC.Spread.Sheets.VerticalAlign.center).hAlign(GC.Spread.Sheets.HorizontalAlign.left);		
	sheet.getCell(row, 11).cellPadding('0 0 0 3').vAlign(GC.Spread.Sheets.VerticalAlign.center).hAlign(GC.Spread.Sheets.HorizontalAlign.center);		
	sheet.getCell(row, 12).cellPadding('0 0 0 3').vAlign(GC.Spread.Sheets.VerticalAlign.center).hAlign(GC.Spread.Sheets.HorizontalAlign.left);		
	sheet.getCell(row, 13).cellPadding('0 0 0 3').vAlign(GC.Spread.Sheets.VerticalAlign.center).hAlign(GC.Spread.Sheets.HorizontalAlign.center);		
	sheet.getCell(row, 14).cellPadding('0 0 0 3').vAlign(GC.Spread.Sheets.VerticalAlign.center).hAlign(GC.Spread.Sheets.HorizontalAlign.left);		
	sheet.getCell(row, 15).cellPadding('0 0 0 3').vAlign(GC.Spread.Sheets.VerticalAlign.center).hAlign(GC.Spread.Sheets.HorizontalAlign.center);	
*/
    sheet.getCell(row, 4).backColor("#D1CBC5");	
    sheet.getCell(row, 6).backColor("#D1CBC5");		
    sheet.getCell(row, 8).backColor("#D1CBC5");	
    sheet.getCell(row, 12).backColor("#D1CBC5");	
    sheet.getCell(row, 14).backColor("#D1CBC5");		
    sheet.getCell(row, 16).backColor("#D1CBC5");	
	
    sheet.setDataValidator(row, 0, dv1);		

    var range = sheet.getRange(row-1, 0, row,17 );
    range.setBorder(new spreadNS.LineBorder("#EBECEB", spreadNS.LineStyle.thin), {all: true});


	sheet.getCell(row, 0, GcSpread.Sheets.SheetArea.viewport).locked(false);		
	sheet.getCell(row, 1, GcSpread.Sheets.SheetArea.viewport).locked(false);	
	sheet.getCell(row, 2, GcSpread.Sheets.SheetArea.viewport).locked(false);
	sheet.getCell(row, 3, GcSpread.Sheets.SheetArea.viewport).locked(false);	
	sheet.getCell(row, 5, GcSpread.Sheets.SheetArea.viewport).locked(false);
	sheet.getCell(row, 7, GcSpread.Sheets.SheetArea.viewport).locked(false);
	sheet.getCell(row, 9, GcSpread.Sheets.SheetArea.viewport).locked(false);
	sheet.getCell(row, 10, GcSpread.Sheets.SheetArea.viewport).locked(false);	
	sheet.getCell(row, 11, GcSpread.Sheets.SheetArea.viewport).locked(false);
	sheet.getCell(row, 13, GcSpread.Sheets.SheetArea.viewport).locked(false);
	sheet.getCell(row, 15, GcSpread.Sheets.SheetArea.viewport).locked(false);
	sheet.getCell(row, 17, GcSpread.Sheets.SheetArea.viewport).locked(false);												
}

function search(){
	if(!$(".getComps").val()){
//		toastMsg(LN_SELECT_COMPS);
		return false;
	}
		
	var params = {
		'comps' : $("#comps").val(),
		'code' : $("#code").val(),
		'name' : $("#name").val()		
	};
	
	$.ajax({
		method : "post",
		url : "/ajaxProdctIndctBaseLine/search.do",
		data : params,
		success : function(res) {
			var data = JSON.parse(res);
			spread.suspendPaint();
			sheet.setDataSource(data.list);
			sheet.setIsProtected(true);  
			for (var i=0; i < data.list.length; i++) {	
				sheet.getCell(i, 0, GcSpread.Sheets.SheetArea.viewport).locked(true);					
				sheet.getCell(i, 1, GcSpread.Sheets.SheetArea.viewport).locked(true);	
				sheet.getCell(i, 2, GcSpread.Sheets.SheetArea.viewport).locked(true);	
				sheet.getCell(i, 3, GcSpread.Sheets.SheetArea.viewport).locked(false);
				sheet.getCell(i, 4, GcSpread.Sheets.SheetArea.viewport).locked(true);				
				sheet.getCell(i, 5, GcSpread.Sheets.SheetArea.viewport).locked(false);
				sheet.getCell(i, 6, GcSpread.Sheets.SheetArea.viewport).locked(true);				
				sheet.getCell(i, 7, GcSpread.Sheets.SheetArea.viewport).locked(false);
				sheet.getCell(i, 8, GcSpread.Sheets.SheetArea.viewport).locked(true);				
				sheet.getCell(i, 9, GcSpread.Sheets.SheetArea.viewport).locked(false);
				sheet.getCell(i, 10, GcSpread.Sheets.SheetArea.viewport).locked(false);	
				sheet.getCell(i, 11, GcSpread.Sheets.SheetArea.viewport).locked(false);
				sheet.getCell(i, 12, GcSpread.Sheets.SheetArea.viewport).locked(true);							
				sheet.getCell(i, 13, GcSpread.Sheets.SheetArea.viewport).locked(false);
				sheet.getCell(i, 14, GcSpread.Sheets.SheetArea.viewport).locked(true);
				sheet.getCell(i, 15, GcSpread.Sheets.SheetArea.viewport).locked(false);
				sheet.getCell(i, 16, GcSpread.Sheets.SheetArea.viewport).locked(true);
				sheet.getCell(i, 17, GcSpread.Sheets.SheetArea.viewport).locked(false);				
				setSelectStyle(i);
			}

			spread.resumePaint();
			$("#updateButton").attr("disabled",false);
		},
		error : function() {
//			console.log("c");
		},
		completed : function() {
//			console.log("dataset.completed");
			setTimeout(function() {
				mask.close();				
			}, 500);
			
		}
	});
}

//수정
function update(){
	if(!isValidationCheck) {
		toastMsg("에러입니다..");
		return false;
	}
		
	if(!$(".getComps").val()){
//		toastMsg(LN_SELECT_COMPS);
		return false;
	}
	
	mask.open();
	var updateRows = sheet.getDirtyRows();
	var insertRows = sheet.getInsertRows();	
	
	updateRows.map(function(item){
		//console.log("update:");
		console.log(item.item);
		updateCar(item.item);
	});
	

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
		url : "/ajaxProdctIndctBaseLine/create.do",
		data : item,
		async: false,
		success : function(res) {
			var data = JSON.parse(res);
			if (data.result === RESULT_OK) {
				toastMsg(RESULT_OK);
			} else {

				setTimeout(function() {
					toastMsg(data.errMsg);
//					if(data.errMsg == "LN_INS_CHK1") toastMsg(LN_INS_CHK1);
//					if(data.errMsg == "LN_INS_CHK2") toastMsg(LN_INS_CHK2);
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
	var stateMsg = "OK";
	$.ajax({
		url : "/ajaxProdctIndctBaseLine/update.do",
		type : "post",
		data : item,
		async: false,
		success : function(res) {
			var data = JSON.parse(res);
			if(data.result === RESULT_OK) {
				stateMsg = "OK";
			} else {
				//stateMsg = data.errMsg;
				
	//			if(data.errMsg == "LN_UPD_CHK1") stateMsg = LN_UPD_CHK1;
	//			if(data.errMsg == "LN_UPD_CHK2") stateMsg = LN_UPD_CHK2;				
	//			if(data.errMsg == "LN_UPD_CHK3") stateMsg = LN_UPD_CHK3;
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
		url : "/ajaxProdctIndctBaseLine/delete.do",
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
	//			if(stateMsg == "LN_DEL_CHK1") toastMsg(LN_DEL_CHK1);
	//			else toastMsg(stateMsg);
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
/*
    var startRow = 3;
    var col = 2;	
	spread.options.highlightInvalidData = true;
	var dv = GC.Spread.Sheets.DataValidation.createNumberValidator(GC.Spread.Sheets.ConditionalFormatting.ComparisonOperators.between, "5", "20", true);
	dv.showInputMessage(true);
	dv.inputMessage("Value must be between 5 and 20.");
	dv.inputTitle("tip");
	activeSheet.setDataValidator(1, 1, 1, 1, dv, GC.Spread.Sheets.SheetArea.viewport);
	
    for (var i = 1; i < 8; i++) {
        sheet.getCell(startRow + i, col).formatter(myFormatter);
    }	
*/
}


function initSpread(){
	statusBarInit();  //status 바 활성화
	//sheet.visible(false);  //spread 보이기 여부
	spread.options.allowUserZoom = true;	//줌허용
	//sheet.setColumnWidth(0,160);  //spread 컬럼 width 설정
	spread.suspendPaint();		//페인팅 일시적 비활성화시키고 스프레드 변경작업이 끝난후 다시 활성화 시키는 함수임, resumePaint()와 한쌍. => 속도개선
	
    var sheet = spread.getActiveSheet();
//    sheet.setRowCount(16);
	sheet.name("라인기준정보");  //sheet이름 지정
    sheet.setColumnCount(18);
    sheet.defaults.rowHeight = 30;
    sheet.defaults.colWidth = 100;
    sheet.defaults.colHeaderRowHeight = 30;
    sheet.defaults.rowHeaderColWidth = 100;
    sheet.setRowCount(2, GC.Spread.Sheets.SheetArea.colHeader);
    sheet.setColumnCount(1, GC.Spread.Sheets.SheetArea.rowHeader);
    ["","","",LB_LOC,LB_LOC, LB_PART,LB_PART, LB_TEAM,LB_TEAM, "","", LB_PRDT1,LB_PRDT1, LB_PRDT2,LB_PRDT2, LB_PRDT3,LB_PRDT3, ""].forEach(function (value, index) {
        sheet.setValue(0, index, value, GC.Spread.Sheets.SheetArea.colHeader);
    });
    [LB_CLS_CODE,LB_LINE_CODE,LB_LINE_NAME ,LB_CODE, LB_NAME,LB_CODE,LB_NAME,LB_CODE,LB_NAME, LB_LCODE_GB,LB_WORK_STLE,LB_CODE,LB_NAME,LB_CODE, LB_NAME,LB_CODE,LB_NAME,LB_IF_CODE].forEach(function (value, index) {
        sheet.setValue(1, index, value, GC.Spread.Sheets.SheetArea.colHeader);
    });


    //apply auto merge
    var range = new GC.Spread.Sheets.Range(-1, -1, -1, -1);
    sheet.autoMerge(range, GC.Spread.Sheets.AutoMerge.AutoMergeDirection.row, GC.Spread.Sheets.AutoMerge.AutoMergeMode.free, GC.Spread.Sheets.SheetArea.colHeader);
    sheet.autoMerge(range, GC.Spread.Sheets.AutoMerge.AutoMergeDirection.column, GC.Spread.Sheets.AutoMerge.AutoMergeMode.free, GC.Spread.Sheets.SheetArea.rowHeader);
	
//	sheet.addSpan (1, 0, 2, 0, GC.Spread.Sheets.SheetArea.colHeader);
	
	sheet.setRowCount(0);
/*
	var columns=[
		{name:'pyvnd',displayName:LB_LINE_CODE,resizable: true,size:"*"},
		{name:'comps',displayName:LB_LINE_NAME,resizable: true,size:"*"},
		{name:'mkcar',displayName:LB_CODE,resizable: true,size:"*"},
		{name:'seyno',displayName:LB_NAME,resizable: true,size:"*"},
		{name:'seycd',displayName:LB_CODE,resizable: true,size:"*"},
	    {name:"part_name",displayName:LB_NAME,resizable: true,size:"*"},		
		{name:'team_code',displayName:LB_CODE,resizable: true,size:"*"},
	    {name:"team_name",displayName:LB_NAME,resizable: true,size:"*"},
	    {name:"work_stle",displayName:LB_WORK_STLE,resizable: true,size:"*"},
	    {name:"prdt_code1",displayName:LB_CODE,resizable: true,size:"*"},
	    {name:"prdt_name1",displayName:LB_NAME,resizable: true,size:"*"},
	    {name:"prdt_code2",displayName:LB_CODE,resizable: true,size:"*"},
	    {name:"prdt_name2",displayName:LB_NAME,resizable: true,size:"*"},
	    {name:"prdt_code3",displayName:LB_CODE,resizable: true,size:"*"},
	    {name:"prdt_name3",displayName:LB_NAME,resizable: true,size:"*"},
	    {name:"if_code",displayName:LB_IF_CODE,resizable: true,size:"*"}
	];	
	*/
	
	var columns=[
		{name:'clsCode',displayName:LB_CLS_CODE,resizable: true,size:"*"},		
		{name:'lineCode',displayName:LB_LINE_CODE,resizable: true,size:"*"},
		{name:'lineNm',displayName:LB_LINE_NAME,resizable: true,size:100},
		{name:'locCode',displayName:LB_CODE,resizable: true,size:"*"},
		{name:'locNm',displayName:LB_NAME,resizable: true,size:"*"},
		{name:'partCode',displayName:LB_CODE,resizable: true,size:"*"},
	    {name:"partNm",displayName:LB_NAME,resizable: true,size:"*"},
	    {name:"teamCode",displayName:LB_CODE,resizable: true,size:"*"},
	    {name:"teamName",displayName:LB_NAME,resizable: true,size:"*"},		
	    {name:"lcodeGb",displayName:LB_LCODE_GB,resizable: true,size:"*"},
	    {name:"workStle",displayName:LB_WORK_STLE,resizable: true,size:"*"},
	    {name:"prdtCode1",displayName:LB_CODE,resizable: true,size:"*"},
	    {name:"prdtNm1",displayName:LB_NAME,resizable: true,size:"*"},
	    {name:"prdtCode2",displayName:LB_CODE,resizable: true,size:"*"},
	    {name:"prdtNm2",displayName:LB_NAME,resizable: true,size:"*"},
	    {name:"prdtCode3",displayName:LB_CODE,resizable: true,size:"*"},
	    {name:"prdtNm3",displayName:LB_NAME,resizable: true,size:"*"},
	    {name:"ifCode",displayName:LB_IF_CODE,resizable: true,size:"*"}
	];	
	sheet.bindColumns(columns);	
	
	sheet.autoGenerateColumns = false;
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
//	spreadInit();
	initSpread();
	handleEvent();
	
});
