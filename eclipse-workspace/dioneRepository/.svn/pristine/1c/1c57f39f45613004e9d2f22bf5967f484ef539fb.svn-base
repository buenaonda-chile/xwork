var unitGrid;
var vnameMap = new HashMap();

var picker = new ax5.ui.picker();

(function() {
	mask.open();
})();

function search() {

	var pJobFileName = "DWH251PF";
	//var pLocCode = $('#locCode').val();	//사업부
	var pLocCode ="LOC000001";	//사업부(창원 강제)
	if (val_chk(pJobFileName, "작업파일")) {
		var params = {jobFileName: pJobFileName, locCode: pLocCode};
		var objList = getAjaxList("/WAE032WipReportSearch/ajaxSearch.do", params)
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
    				$('#year').val(parse.year);
    				objList = parse;
    				try {
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

function gridSetData (objList) {
	try { 
		objList.vnameList.forEach(function(item, index) {
			vnameMap.put(item.vndnr, item.vname);
		});
		
	} catch (e) {
		//console.log(e);
	}
	unitGrid.setData(objList.list);
	$('span.total').text(objList.list.length);
}
//=== grid =================================================
function createGrid(){
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
            {key: "itnbr", label: "품번", width:200},          
            {key: "itdsc", label: "품명", width:250},
            {key: "ittyp", label: "ITEM TYPE"},
            {key: "itcls", label: "ITEM CLASS"},
            {key: "packc", label: "PACKING"},
            {key: "plann", label: "PLANNER"},
            {key: "mnfcs", label: "MANUFACTURING COST", formatter: "money", align: "right"},
            {key: "d0bfj", label: "전월재고", formatter: "money", align: "right"},
            {key: "d0inp", label: "투입수량", formatter: "money", align: "right"},
            {key: "d0out", label: "실적수량", formatter: "money", align: "right"},
            {key: "d0bad", label: "불량수량", formatter: "money", align: "right"},
            {key: "d1bfj", label: "전월재고", formatter: "money", align: "right"},
            {key: "d1inp", label: "투입수량", formatter: "money", align: "right"},
            {key: "d1out", label: "실적수량", formatter: "money", align: "right"},
            {key: "d1bad", label: "불량수량", formatter: "money", align: "right"},
            {key: "d2bfj", label: "전월재고", formatter: "money", align: "right"},
            {key: "d2inp", label: "투입수량", formatter: "money", align: "right"},
            {key: "d2out", label: "실적수량", formatter: "money", align: "right"},
            {key: "d2bad", label: "불량수량", formatter: "money", align: "right"},
            {key: "d3bfj", label: "전월재고", formatter: "money", align: "right"},
            {key: "d3inp", label: "투입수량", formatter: "money", align: "right"},
            {key: "d3out", label: "실적수량", formatter: "money", align: "right"},
            {key: "d3bad", label: "불량수량", formatter: "money", align: "right"},
            {key: "d4bfj", label: "전월재고", formatter: "money", align: "right"},
            {key: "d4inp", label: "투입수량", formatter: "money", align: "right"},
            {key: "d4out", label: "실적수량", formatter: "money", align: "right"},
            {key: "d4bad", label: "불량수량", formatter: "money", align: "right"},
            {key: "d5bfj", label: "전월재고", formatter: "money", align: "right"},
            {key: "d5inp", label: "투입수량", formatter: "money", align: "right"},
            {key: "d5out", label: "실적수량", formatter: "money", align: "right"},
            {key: "d5bad", label: "불량수량", formatter: "money", align: "right"}
        
        ]
	});
}
function commonClear(){
	createGrid();
}
$(document).ready(function() {
	mask.close();
	
//	=== grid =================================================
	createGrid();
	
	$('._searchBtn_').on('click', function() {
		search();
		return false;
	});	
	
	$('.exel').on('click', function() {
		unitGrid.exportExcel("WIP REPORT.xls");
	});
//	=== //grid =================================================
    
	
	$('[data-ax5formatter]').ax5formatter();
	 // Select Month
    picker.bind({
        target: $('[data-picker-date="month"]'),
        content: {
            type: 'date',
            config: {
                mode: "year", selectMode: "month"
            },
            formatter: {
                pattern: 'date(month)'
            }
        }
    });
    
    if($('#year').val()==""){
    	alert("[알림]구KA사업부 전용프로그램입니다.");
    }
}) 
