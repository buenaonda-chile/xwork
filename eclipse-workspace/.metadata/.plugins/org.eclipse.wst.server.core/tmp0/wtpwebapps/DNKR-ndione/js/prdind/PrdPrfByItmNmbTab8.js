//code intellisense typescript 정의
///<reference path = "../../wijmo/controls/wijmo.d.ts"/>	
///<reference path = "../../wijmo/controls/wijmo.grid.d.ts"/>
///<reference path = "../../wijmo/controls/wijmo.input.d.ts"/>

// 컬랙션 뷰는 조회후에 그리드의 상태변경을 체크한다. 
var cv8 = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수
var flexGrid8 = new wijmo.grid.FlexGrid('#wijmoGrid8');	//그리드 전역변수

function search8(){
	//validation 체크기능으로 입력칸에 커서가 활성화 되어있을경우 조회시 오류가 발생함.
	//validation edit 기능을 비활성화 시키고 조회시킴.
	flexGrid8.validateEdits = false;
	if(!$("#getComps").val()){
		toastMsg(LN_SELECT_COMPS);
		return false;
	}else if(!$("#getLocId").val()){
		toastMsg(LN_SELECT_DEPT);
		return false;
	}	
	
	var url = "/ajaxPrdPrfByItmNmb/search8.do";	
	var params = {
		'getComps' : $("#getComps").val(),
		'getRepym' : $(".getDumcb").val().replace(/-/gi, ""),
		
		//'getYear' : $("#getYear").val(),
		'getLocId' : $("#getLocId").val()				
	};
	
	mask.open();
	$.ajax({
		method : "post",
		url : url,
		data :params,
		success : function(res) {
			var data = JSON.parse(res).list;
			cv8.sourceCollection = data;
			console.log(data);
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
function downloadExcel8(){
	
	var fileName = "라인실적지수목표_"+getToday()+".xlsx";
	
	wijmo.grid.xlsx.FlexGridXlsxConverter.saveAsync(flexGrid8, 
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

function gridInit8(){
//	var comsBase = new DataMap(coms_base, 'id', 'name');
	var columnsDefinition=[
		{binding:'rownum',visible:false},	
		{binding:'clsCode',visible:false},		
		{binding:'lineCode',header: '* '+ LB_LINE_CODE,width: 120, align:'center',dataType:'String', maxLength:4,isReadOnly: true},
		{binding:'lineNm',header: '* '+ LB_LINE_NM, width: 150, align:'left',dataType:'String', maxLength:50,isReadOnly: true},
		{binding:'jan',header: '1월', width: '*',align:'right',dataType:'Number',isReadOnly: true},
		{binding:'feb',header: '2월', width: '*',align:'right',dataType:'Number',isReadOnly: true},			
		{binding:'mar',header: '3월', width: '*',align:'right',dataType:'Number',isReadOnly: true},	
		{binding:'apr',header: '4월', width: '*',align:'right',dataType:'Number',isReadOnly: true},	
		{binding:'may',header: '5월', width: '*',align:'right',dataType:'Number',isReadOnly: true},			
		{binding:'jun',header: '6월', width: '*',align:'right',dataType:'Number',isReadOnly: true},			
		{binding:'july',header: '7월', width: '*',align:'right',dataType:'Number',isReadOnly: true},						
		{binding:'aug',header: '8월', width: '*',align:'right',dataType:'Number',isReadOnly: true},			
		{binding:'sep',header: '9월', width: '*',align:'right',dataType:'Number',isReadOnly: true},			
		{binding:'oct',header: '10월', width: '*',align:'right',dataType:'Number',isReadOnly: true},			
		{binding:'nov',header: '11월', width: '*',align:'right',dataType:'Number',isReadOnly: true},	
		{binding:'dec',header: '12월', width: '*',align:'right',dataType:'Number',isReadOnly: true},									
		/*{binding:'ttl',header: LB_TTL, width: '*',align:'right',dataType:'Number',isReadOnly: true}*/
	];	
	//컬럼 초기화
	flexGrid8.initialize({
		columns: columnsDefinition
	});
	flexGrid8.allowSorting = false;			
//	flexGrid8.columnHeaders.rows.defaultSize = 80; 	// 열 헤더 영역에 행의 높이 설정		
}


