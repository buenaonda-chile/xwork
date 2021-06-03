
function setList(){
	var excelForm = document.excelUploadForm;
	var title = excelForm.titleList.value;
	var sucList = excelForm.sucList.value;
	var failList = excelForm.failList.value;
	
	//title = '[No, Material Number, Short text, Release date, 2018-05-28, 2018-06-04, 2018-06-11, 2018-06-18, 2018-06-25, 2018-07-09, 2018-07-16, 2018-07-23, 2018-07-30, 2018-08-06, 2018-08-13, 2018-08-20, 2018-08-27, Base Unit of Measure]';
	title = title.replace('[', '').replace(']', '');
	var titleArr = new Array();
	
	if(title != ''){
		titleArr= title.split(',');
		
		for(var i=0 ; i<titleArr.length ; i++){
			errorGrid.addColumn({key: i, label: titleArr[i]});
			normalGrid.addColumn({key: i, label: titleArr[i]});
		}
	}
	
	if(sucList != ''){
		var sucData = JSON.parse(sucList);
		normalGrid.appendToList(sucData);
	}
	
	if(failList != ''){
		var failData = JSON.parse(failList);
		errorGrid.appendToList(failData);
	}
	
	mask.close();
}


function excelUpload(){
	var excelForm = document.excelUploadForm;
	var value = excelForm.upFile.value;
	
	if(value == ''){
		alert('첨부파일을 선택해주세요.');
		mask.close();
	}else{
		excelForm.submit();
	}
	
}
var normalGrid;
var errorGrid;

$(document.body).ready(function() {
	
	
	 normalGrid = new ax5.ui.grid({
         target: $('[data-ax5grid="normal-grid"]'),
         columns: [
         ]
     });
	 
	 errorGrid = new ax5.ui.grid({
         target: $('[data-ax5grid="error-grid"]'),
         columns: [
                   
         ]
     });
	
	setList();
	$('._excelUploadBtn_').on('click', function() {
		mask.open();
		excelUpload();
	});
	
	
	$('._excelBtn_').on('click', function() {
		if(this.getAttribute("data-target") === "normal") {
			normalGrid.exportExcel("Host Up 정상List.xls");
		} else {
			errorGrid.exportExcel("Host Up Error List.xls");
		}
	});
	mask.close();
});