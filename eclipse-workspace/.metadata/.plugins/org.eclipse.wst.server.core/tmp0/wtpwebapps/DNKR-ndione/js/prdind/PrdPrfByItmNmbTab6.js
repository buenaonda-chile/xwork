//code intellisense typescript 정의
///<reference path = "../../wijmo/controls/wijmo.d.ts"/>	
///<reference path = "../../wijmo/controls/wijmo.grid.d.ts"/>
///<reference path = "../../wijmo/controls/wijmo.input.d.ts"/>

// 컬랙션 뷰는 조회후에 그리드의 상태변경을 체크한다. 
var cv6 = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수
var flexGrid6 = new wijmo.grid.FlexGrid('#wijmoGrid6');	//그리드 전역변수

function search6(){
	//validation 체크기능으로 입력칸에 커서가 활성화 되어있을경우 조회시 오류가 발생함.
	//validation edit 기능을 비활성화 시키고 조회시킴.
	flexGrid6.validateEdits = false;
	if(!$("#getComps").val()){
		toastMsg(LN_SELECT_COMPS);
		return false;
	}else if(!$("#getLocId").val()){
		toastMsg(LN_SELECT_DEPT);
		return false;
	}	
	
	var url = "/ajaxPrdPrfByItmNmb/search6.do";	
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
			cv6.sourceCollection = data;
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
function downloadExcel6(){
	
	var fileName = "공수저감지수_실적_"+getToday()+".xlsx";
	
	wijmo.grid.xlsx.FlexGridXlsxConverter.saveAsync(flexGrid6, 
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


function gridInit6(){
//	var comsBase = new DataMap(coms_base, 'id', 'name');
	var columnsDefinition=[
		{binding:'rownum',visible:false},	
		{binding:'clsCode',visible:false},		
		{binding:'lineCode',header: '* '+ LB_LINE_CODE,width: 120, align:'center',dataType:'String', maxLength:4,isReadOnly: true},
		{binding:'lineNm',header: '* '+ LB_LINE_NM, width: 150, align:'left',dataType:'String', maxLength:50,isReadOnly: true},	
		{binding:'day1',header: '1일', width: 60,align:'right',dataType:'Number',isReadOnly: true},			
		{binding:'day2',header: '2일', width: 60,align:'right',dataType:'Number',isReadOnly: true},			
		{binding:'day3',header: '3일', width: 60,align:'right',dataType:'Number',isReadOnly: true},			
		{binding:'day4',header: '4일', width: 60,align:'right',dataType:'Number',isReadOnly: true},						
		{binding:'day5',header: '5일', width: 60,align:'right',dataType:'Number',isReadOnly: true},			
		{binding:'day6',header: '6일', width: 60,align:'right',dataType:'Number',isReadOnly: true},			
		{binding:'day7',header: '7일', width: 60,align:'right',dataType:'Number',isReadOnly: true},			
		{binding:'day8',header: '8일', width: 60,align:'right',dataType:'Number',isReadOnly: true},	
		{binding:'day9',header: '9일', width: 60,align:'right',dataType:'Number',isReadOnly: true},			
		{binding:'day10',header: '10일', width: 60,align:'right',dataType:'Number',isReadOnly: true},
		{binding:'day11',header: '11일', width: 60,align:'right',dataType:'Number',isReadOnly: true},			
		{binding:'day12',header: '12일', width: 60,align:'right',dataType:'Number',isReadOnly: true},			
		{binding:'day13',header: '13일', width: 60,align:'right',dataType:'Number',isReadOnly: true},			
		{binding:'day14',header: '14일', width: 60,align:'right',dataType:'Number',isReadOnly: true},						
		{binding:'day15',header: '15일', width: 60,align:'right',dataType:'Number',isReadOnly: true},			
		{binding:'day16',header: '16일', width: 60,align:'right',dataType:'Number',isReadOnly: true},			
		{binding:'day17',header: '17일', width: 60,align:'right',dataType:'Number',isReadOnly: true},			
		{binding:'day18',header: '18일', width: 60,align:'right',dataType:'Number',isReadOnly: true},	
		{binding:'day19',header: '19일', width: 60,align:'right',dataType:'Number',isReadOnly: true},			
		{binding:'day20',header: '20일', width: 60,align:'right',dataType:'Number',isReadOnly: true},
		{binding:'day21',header: '21일', width: 60,align:'right',dataType:'Number',isReadOnly: true},			
		{binding:'day22',header: '22일', width: 60,align:'right',dataType:'Number',isReadOnly: true},			
		{binding:'day23',header: '23일', width: 60,align:'right',dataType:'Number',isReadOnly: true},			
		{binding:'day24',header: '24일', width: 60,align:'right',dataType:'Number',isReadOnly: true},						
		{binding:'day25',header: '25일', width: 60,align:'right',dataType:'Number',isReadOnly: true},			
		{binding:'day26',header: '26일', width: 60,align:'right',dataType:'Number',isReadOnly: true},			
		{binding:'day27',header: '27일', width: 60,align:'right',dataType:'Number',isReadOnly: true},			
		{binding:'day28',header: '28일', width: 60,align:'right',dataType:'Number',isReadOnly: true},	
		{binding:'day29',header: '29일', width: 60,align:'right',dataType:'Number',isReadOnly: true},			
		{binding:'day30',header: '30일', width: 60,align:'right',dataType:'Number',isReadOnly: true},
		{binding:'day31',header: '31일', width: 60,align:'right',dataType:'Number',isReadOnly: true},
		{binding:'ttl',header: LB_TTL, width: 100,align:'right',dataType:'Number',isReadOnly: true}					
	];	
	//컬럼 초기화
	flexGrid6.initialize({
		columns: columnsDefinition
	});
	flexGrid6.allowSorting = false;		
//	flexGrid6.columnHeaders.rows.defaultSize = 80; 	// 열 헤더 영역에 행의 높이 설정		
}


