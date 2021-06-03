var unitGrid;
var vnameMap = new HashMap();

var picker = new ax5.ui.picker();

(function() {
	mask.open();
})();

function search() {

	var pJobFileName = "DWH301PF";
	//var pLocCode = $('#locCode').val();	//사업부
	var pLocCode ="LOC000001";	//사업부(창원 강제)
	if (val_chk(pJobFileName, "작업파일")) {
		var params = {jobFileName: pJobFileName, locCode: pLocCode};
		var objList = getAjaxList("/WAE026MonthlySalesPlanSearch/ajaxSearch.do", params)
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
            {key: "ittyp", label: "ITEM TYPE", width:70},   
            {key: "itcls", label: "ITEM CLASS", width:70},
            {key: "pyvnd", label: "업체코드", width:200},
            {key: "cusnm", label: "업체명", width:150},
            {key: "pspno", label: "품번", width:200},
            {key: "itdsc", label: "품명", width:250},
            {key: "sm0qy", label: "기본M0계획 ", width:90, formatter: "money", align: "right"},
            {key: "sm1qy", label: "기본M1계획", width:90, formatter: "money", align: "right"},
            {key: "sm2qy", label: "기본M2계획", width:90, formatter: "money", align: "right"},
            {key: "sm3qy", label: "기본M3계획", width:90, formatter: "money", align: "right"},
            {key: "sm4qy", label: "기본M4계획", width:90, formatter: "money", align: "right"},
            {key: "sm5qy", label: "기본M5계획", width:90, formatter: "money", align: "right"},
            {key: "sm0am", label: "기본M0금액", width:90, formatter: "money", align: "right"},
            {key: "sm1am", label: "기본M1금액", width:90, formatter: "money", align: "right"},
            {key: "sm2am", label: "기본M2금액", width:90, formatter: "money", align: "right"},
            {key: "sm3am", label: "기본M3금액", width:90, formatter: "money", align: "right"},
            {key: "sm4am", label: "기본M4금액", width:90, formatter: "money", align: "right"},
            {key: "sm5am", label: "기본M5금액", width:90, formatter: "money", align: "right"}
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
		unitGrid.exportExcel("월판매계획현황.xls");
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
