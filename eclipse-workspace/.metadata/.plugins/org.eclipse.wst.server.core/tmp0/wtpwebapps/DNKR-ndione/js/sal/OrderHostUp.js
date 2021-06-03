var titleP6 = 
	"DN거래처,DN품번,대표,공장,문서일자,지시구분,서열번호,업체품명,서열코드,TRIM,대기댓수,도장댓수,비축댓수," +
	"D DAY," +
	"D+1 DAY," +
	"D+2 DAY," +
	"D+3 DAY," +
	"D+4 DAY," +
	"이후투입,합계,모델코드";

var titleKeyP6 = 
	"pyvnd,pspno,dmkcr,dfacd,dumcb,jbgb1,itmno,pnonm,itmcd,trimd,pbsqy,patqy,wbsqy," +
	"d0t01," +
	"d1t01," +
	"d2t01," +
	"d3t01," +	
	"d4t01," +
	"remqy,grtot,molcd";

var titleP7 = 
	"DN거래처,DN품번,대표,공장,문서일자,지시구분,서열번호,업체품명,서열코드,TRIM,대기댓수,도장댓수,비축댓수," +
	"수 량," +
	"이후투입,확정수량,MITU,PR-SEQ,당월미반영잔량,차월생산 ORDER,합계,모델코드";

var titleKeyP7 =
	"pyvnd,pspno,dmkcr,dfacd,dumcb,jbgb1,itmno,pnonm,itmcd,trimd,pbsqy,patqy,wbsqy," +		
	"dat00," +
	"remqy,okqty,mitqy,prseq,miqqy,mioqy,grtot,molcd";

function setList(){
	var excelForm = document.excelUploadForm;
	var selChk = $(":input:radio[name=getSelchk]:checked").val();
	var sucList = excelForm.sucList.value;
	var failList = excelForm.failList.value;
	
	var titleArr = new Array();
	var titleKeyArr = new Array();
	
	if(selChk == "P6"){
		titleArr = titleP6.split(',');
		titleKeyArr = titleKeyP6.split(',');
	}else{
		titleArr = titleP7.split(',');
		titleKeyArr = titleKeyP7.split(',');
	}
				
	errorGrid.addColumn({key: "ERROR", label: "ERROR", align: "center", width : 150});
		
	
	var mergeColumn;
	var P6Label = "2HR";
	var P6TotalLabel = "TOTAL";
	
	// 엑셀변환시 숫자형태로 변하는것 방지 (품목코드)
	var formatterYn = false;
	
	for(var i=0 ; i<titleArr.length ; i++){
		if(selChk == "P6"){			
			if(titleKeyArr[i] == "dmkcr"){
				mergeColumn = {label: titleArr[i], align: "center",	// 대표
				               columns: [{key: "dmkcr", label: "차종", align: "center"},
                                         {key: "dsecd", label: "서열코드", align: "center"},
                                         {key: "dseno", label: "서열번호", align: "center"}]
                              };
				errorGrid.addColumn(mergeColumn);
				normalGrid.addColumn(mergeColumn);	
			}else if(titleKeyArr[i] == "d0t01"){
				mergeColumn = {label: titleArr[i], align: "center", // D DAY
			                   columns: [{key: "d0t01", label: P6Label, align: "center"},
                                         {key: "d0t02", label: P6Label, align: "center"},
                                         {key: "d0t03", label: P6Label, align: "center"},
                                         {key: "d0t04", label: P6Label, align: "center"},
                                         {key: "d0t05", label: P6Label, align: "center"},
                                         {key: "d0t06", label: P6Label, align: "center"},
                                         {key: "d0t07", label: P6Label, align: "center"},
                                         {key: "d0t08", label: P6Label, align: "center"},
                                         {key: "d0t09", label: P6Label, align: "center"},
                                         {key: "d0t10", label: P6Label, align: "center"},
                                         {key: "d0tqy", label: P6TotalLabel, align: "center"}]
					      };
				errorGrid.addColumn(mergeColumn);
				normalGrid.addColumn(mergeColumn);	
			}else if(titleKeyArr[i] == "d1t01"){
				mergeColumn = {label: titleArr[i], align: "center", // DD+1 DAY
		                       columns: [{key: "d1t01", label: P6Label, align: "center"},
                                         {key: "d1t02", label: P6Label, align: "center"},
                                         {key: "d1t03", label: P6Label, align: "center"},
                                         {key: "d1t04", label: P6Label, align: "center"},
                                         {key: "d1t05", label: P6Label, align: "center"},
                                         {key: "d1t06", label: P6Label, align: "center"},
                                         {key: "d1t07", label: P6Label, align: "center"},
                                         {key: "d1t08", label: P6Label, align: "center"},
                                         {key: "d1t09", label: P6Label, align: "center"},
                                         {key: "d1t10", label: P6Label, align: "center"},
                                         {key: "d1tqy", label: P6TotalLabel, align: "center"}]
						      };
				errorGrid.addColumn(mergeColumn);
				normalGrid.addColumn(mergeColumn);	
			}else if(titleKeyArr[i] == "d2t01"){
				mergeColumn = {label: titleArr[i], align: "center", // DD+2 DAY
	                           columns: [{key: "d2t01", label: P6Label, align: "center"},
                                         {key: "d2t02", label: P6Label, align: "center"},
                                         {key: "d2t03", label: P6Label, align: "center"},
                                         {key: "d2t04", label: P6Label, align: "center"},
                                         {key: "d2t05", label: P6Label, align: "center"},
                                         {key: "d2t06", label: P6Label, align: "center"},
                                         {key: "d2t07", label: P6Label, align: "center"},
                                         {key: "d2t08", label: P6Label, align: "center"},
                                         {key: "d2t09", label: P6Label, align: "center"},
                                         {key: "d2t10", label: P6Label, align: "center"},
                                         {key: "d2tqy", label: P6TotalLabel, align: "center"}]
					          };
				errorGrid.addColumn(mergeColumn);
				normalGrid.addColumn(mergeColumn);	
			}else if(titleKeyArr[i] == "d3t01"){
				mergeColumn = {label: titleArr[i], align: "center", // DD+3 DAY
	                           columns: [{key: "d3t01", label: P6Label, align: "center"},
                                         {key: "d3t02", label: P6Label, align: "center"},
                                         {key: "d3t03", label: P6Label, align: "center"},
                                         {key: "d3t04", label: P6Label, align: "center"},
                                         {key: "d3t05", label: P6Label, align: "center"},
                                         {key: "d3t06", label: P6Label, align: "center"},
                                         {key: "d3t07", label: P6Label, align: "center"},
                                         {key: "d3t08", label: P6Label, align: "center"},
                                         {key: "d3t09", label: P6Label, align: "center"},
                                         {key: "d3t10", label: P6Label, align: "center"},
                                         {key: "d3tqy", label: P6TotalLabel, align: "center"}]
					          };
				errorGrid.addColumn(mergeColumn);
				normalGrid.addColumn(mergeColumn);	
			}else if(titleKeyArr[i] == "d4t01"){
				mergeColumn = {label: titleArr[i], align: "center", // DD+4 DAY
	                           columns: [{key: "d4t01", label: P6Label, align: "center"},
                                         {key: "d4t02", label: P6Label, align: "center"},
                                         {key: "d4t03", label: P6Label, align: "center"},
                                         {key: "d4t04", label: P6Label, align: "center"},
                                         {key: "d4t05", label: P6Label, align: "center"},
                                         {key: "d4t06", label: P6Label, align: "center"},
                                         {key: "d4t07", label: P6Label, align: "center"},
                                         {key: "d4t08", label: P6Label, align: "center"},
                                         {key: "d4t09", label: P6Label, align: "center"},
                                         {key: "d4t10", label: P6Label, align: "center"},
                                         {key: "d4tqy", label: P6TotalLabel, align: "center"}]
					          };
				errorGrid.addColumn(mergeColumn);
				normalGrid.addColumn(mergeColumn);	
			}else{
				// 품목코드
				if(titleKeyArr[i] == "pspno") formatterYn = true;	
				else formatterYn = false;	
				
				if(formatterYn){
					errorGrid.addColumn({key: titleKeyArr[i], label: titleArr[i], align: "center",
						                 formatter: function() {return this.value + "&nbsp;"}});
					normalGrid.addColumn({key: titleKeyArr[i], label: titleArr[i], align: "center",
						                  formatter: function() {return this.value + "&nbsp;"}});			
				}
				else{				
					errorGrid.addColumn({key: titleKeyArr[i], label: titleArr[i], align: "center"});
					normalGrid.addColumn({key: titleKeyArr[i], label: titleArr[i], align: "center"});
				}
			}
		}else{
			if(titleKeyArr[i] == "dmkcr"){
				mergeColumn = {label: titleArr[i], align: "center",	// 대표
					           columns: [{key: "dmkcr", label: "차종", align: "center"},
                                         {key: "dsecd", label: "서열코드", align: "center"},
                                         {key: "dseno", label: "서열번호", align: "center"}]
                              };
				errorGrid.addColumn(mergeColumn);
				normalGrid.addColumn(mergeColumn);				
			}else if(titleKeyArr[i] == "dat00"){
				mergeColumn = {label: titleArr[i], align: "center", // 수 량
					           columns: [{key: "dat00", label: "D DAY", align: "center"},
                                         {key: "dat01", label: "D+1 DAY", align: "center"},
                                         {key: "dat02", label: "D+2 DAY", align: "center"},
                                         {key: "dat03", label: "D+3 DAY", align: "center"},
                                         {key: "dat04", label: "D+4 DAY", align: "center"},
                                         {key: "dat05", label: "D+5 DAY", align: "center"},
                                         {key: "dat06", label: "D+6 DAY", align: "center"},
                                         {key: "dat07", label: "D+7 DAY", align: "center"},
                                         {key: "dat08", label: "D+8 DAY", align: "center"},
                                         {key: "dat09", label: "D+9 DAY", align: "center"},
                                         {key: "dat10", label: "D+10 DAY", align: "center"},
                                         {key: "dat11", label: "D+11 DAY", align: "center"},
                                         {key: "dat12", label: "D+12 DAY", align: "center"}]
							  };
				errorGrid.addColumn(mergeColumn);
				normalGrid.addColumn(mergeColumn);					
			}else{
				// 품목코드
				if(titleKeyArr[i] == "pspno") formatterYn = true;	
				else formatterYn = false;	
				
				if(formatterYn){
					errorGrid.addColumn({key: titleKeyArr[i], label: titleArr[i], align: "center",
						                 formatter: function() {return this.value + "&nbsp;"}});
					normalGrid.addColumn({key: titleKeyArr[i], label: titleArr[i], align: "center",
						                  formatter: function() {return this.value + "&nbsp;"}});			
				}
				else{					
					errorGrid.addColumn({key: titleKeyArr[i], label: titleArr[i], align: "center"});
					normalGrid.addColumn({key: titleKeyArr[i], label: titleArr[i], align: "center"});
				}
			}
		}
	}

	var sucData = "";
	var failData = "";
	
	if(sucList != ''){
		sucData = JSON.parse(sucList);
		normalGrid.appendToList(sucData);
		
		//sort
		normalGrid.setColumnSort({
			"pspno" : {orderBy: "asc", seq: 0}
		});	
	}
	
	if(failList != ''){
		failData = JSON.parse(failList);
		errorGrid.appendToList(failData);
		
		//sort
		errorGrid.setColumnSort({
			"pspno" : {orderBy: "asc", seq: 0}
		});	
	}
	
	if(sucData != '' && failData == '') $("._saleBtn_").prop('disabled', false);
	else $("._saleBtn_").prop('disabled', true);
	
	mask.close();
}


function excelUpload(){
	var excelForm = document.excelUploadForm;
	var value = excelForm.upFile.value;
	excelForm.action = "/WAN008OrderHostUp/procExcelUpload.do";
	
	if(value == ''){
		alert(LN_SELECT_FILE);
		mask.close();
	}else{
		// 파일 확장자 확인
		var ext = value.split('.').pop().toLowerCase();
		if($.inArray(ext, ['csv']) == -1) {
			alert('CSV 파일에 대해 업로드 가능합니다.'); 
			mask.close();
		}		
		else excelForm.submit();
	}
	
}

function excelImport(){
	
	var excelForm = document.excelUploadForm;
	excelForm.action = "/WAN008OrderHostUp/procExcelImport.do";
	
	excelForm.submit();
	
}

var normalGrid;
var errorGrid;

$(document.body).ready(function() {
	
	$('.getSelchk').on('change', function() {

		var excelForm = document.excelUploadForm;
		excelForm.action = "/WAN008OrderHostUp/init.do";
		excelForm.submit();

		//errorGrid.removeColumn();
		//normalGrid.removeColumn();
		
		////gridDataInit(errorGrid.target);
		////gridDataInit(normalGrid.target);
		//setList();

	});
	
	 normalGrid = new ax5.ui.grid({
         target: $('[data-ax5grid="normal-grid"]'),
         //sortable: true,
         columns: [
         ]
     });
	 
	 errorGrid = new ax5.ui.grid({
         target: $('[data-ax5grid="error-grid"]'),
         //sortable: true,
         columns: [
         ]
     });
	

	setList();
	
	$('._excelUploadBtn_').on('click', function() {
		mask.open();
		excelUpload();
	});
	
	$('._excelRecentlyUploadBtn_').on('click', function() {
		mask.open();
		excelImport();
	});
	
	// 달력 크기 때문에 height=400
	$('._saleBtn_').on('click', function() {
		window.open("/WAN010OrderDaySaleCreate/init.do","OrderDaySaleCreatePop","width=800,height=400,scrollbars=yes,top=100,left=100");
	});
	
	$('._excelBtn_').on('click', function() {
		if(this.getAttribute("data-target") === "normal") {
			normalGrid.exportExcel("HOST UP 정상LIST.xls");
		} else {
			errorGrid.exportExcel("HOST UP ERROR LIST.xls");
		}
	});
	mask.close();
});
