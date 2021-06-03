var unitGrid;
var vnameMap = new HashMap();

var picker = new ax5.ui.picker();

(function() {
	mask.open();
})();

function search() {


	var pJobName = document.querySelector('input[name="selectMenu"]:checked').value;	//처리구분
	var pLocCode = $('#locCode').val();	//사업부
	var pHouse = $('#house').val();	//창고
	var pIttyp ="";	//A-PART포함여부
	if(document.getElementById("ittyp").checked==true){
		pIttyp = "1";
	}else{
		pIttyp = "0";
	}
	if(pJobName=="car" && pLocCode !="LOC000004"){
		alert("[알림]마산공장 선택시에만 조회 가능합니다.");
		return;
	}
	
	if (val_chk(pJobName, "처리구분")) {
		var params = {jobName: pJobName, locCode: pLocCode, house: pHouse, ittyp: pIttyp};
		var objList = getAjaxList("/WAE020ProductInventoryCostSearch/ajaxSearch.do", params)
	}
	return false;
}

/**
 * ajax로 리스트 가져오기
 * @param url
 */
function getAjaxList (url, params) {
	mask.open();
	var objList;
	$.ajax({
		url: url,
		type    : "POST",
//		async : false,
		data : params,
		success : function (data){
			//console.log(data);
			try{
				var parse = JSON.parse(data);
    			if(parse.result === RESULT_Y){
    				objList = parse;
    				try {
    					var pSelectMenu = document.querySelector('input[name="selectMenu"]:checked').value;	
    					createGrid(pSelectMenu);
    					gridSetData(objList);
    				} catch (e) {
    					console.log(e);
    				}
    			}else {
    				toastMsg('조회된 데이터가 없습니다.');
    				return;
    			}
			}catch(e){
				console.log(e);
			}
		},
		error: function(e){ 
			//console.log(e);
		},
		complete: function(e) {
			//console.log(e);
			
			mask.close();
		}
	});
	
	return objList;
}

//=== grid =================================================

function createGrid(type){
	//그리드 객체 생성
	if(type=="car"){
		unitGrid = new ax5.ui.grid({
	        target: $('[data-ax5grid="unit-grid"]'),
	        header: {
	            align: "center"
	        },
	        body: {
	        	align: "center",
	        	onClick : function() {
						this.self.clearSelect();
						this.self.select(this.dindex);
				},
	        },
	        columns: [
	            {key: "cusno", label: "업체코드"},          
	            {key: "cusnm", label: "업체명", width:200},
	            {key: "carcd", label: "차종코드"},
	            {key: "carnm", label: "차종명", width:200},
	            {key: "house", label: "창고"},
	            {key: "mohtq", label: "재고수량", formatter: "money"},
	            {key: "amt", label: "재고금액", formatter: "money"}
	        ],
	        footSum: [
	            [
		            {label: "TOTAL", colspan: 5, align: "center"},
		            {key: "mohtq", collector: "sum", formatter: "money", align: "right"},
		            {key: "amt", collector: "sum", formatter: "money", align: "right"},
		        ]
	        ]
		});	
	}
	else if(type=="customer"){
		unitGrid = new ax5.ui.grid({
	        target: $('[data-ax5grid="unit-grid"]'),
	        header: {
	            align: "center"
	        },
	        body: {
	        	align: "center",
	        	onClick : function() {
						this.self.clearSelect();
						this.self.select(this.dindex);
				},
	        },        
	        columns: [
	            {key: "cusno", label: "득의선코드", width:200},
	            {key: "cusnm", label: "득의선명", width:250, align:"left"},
	            {key: "house", label: "창고"},
	            {key: "mohtq", label: "재고수량", align:"right", formatter: "money"}, 
	            {key: "amt", label: "재고금액", align:"right", formatter: "money"}

	        ],
	        footSum: [
	          [
	            {label: "합계", colspan: 3, align: "center"},
	            {key: "mohtq", collector: "sum", formatter: "money", align: "right"},
	            {key: "amt", collector: "sum", formatter: "money", align: "right"},
	          ]
	        ]
		});		
	}

}

function gridSetData (objList) {

	unitGrid.setData(objList.list);
	$('span.total').text(objList.list.length);
}

function commonClear(jobName){
	
	createGrid(jobName);
	if(jobName=="car"){
		alert("[알림]구KE사업부 전용프로그램입니다.");
		$('#house').prop('disabled', false);	//창고
		$('#ittyp').prop('disabled', true);	//A-PART포함여부
	}else{
		$('#house').prop('disabled', true);	//창고
		$('#ittyp').prop('disabled', false);	//A-PART포함여부
	}
}

$(document).ready(function() {
	mask.close();
	
//	=== grid =================================================
	//그리드 객체 생성
	commonClear("customer");	//그리드 초기화
	$('#house').val("0"); //창고코드 초기화
	$('._searchBtn_').on('click', function() {
		search();
		return false;
	});
	
	
	$('.exel').on('click', function() {
		unitGrid.exportExcel("제품재고금액조회 .xls");
	});
//	=== //grid =================================================	
	$('[data-ax5formatter]').ax5formatter();
	
}) 
