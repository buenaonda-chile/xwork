var unitGrid;
var vnameMap = new HashMap();

var picker = new ax5.ui.picker();

(function() {
	mask.open();
})();

function search() {

	var pJobFileName = "DWH109PF";
	//var pLocCode = $('#locCode').val();	//사업부
	var pLocCode ="LOC000001";	//사업부(창원 강제)
	if (val_chk(pJobFileName, "작업파일")) {
		var params = {jobFileName: pJobFileName, locCode: pLocCode};
		var objList = getAjaxList("/WAE030MaterialScrapTicketSearch/ajaxSearch.do", params)
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
            {key: "packc", label: "PACKING CODE"},
            {key: "prtno", label: "품번"},
            {key: "itdsc", label: "ITEM DESCRIPTION", width:200},
            {key: "house", label: "창고"},
            {key: "trndt", label: "실적일자", formatter: function(){
	            	var date = this.value;
	        		if(date.length == 8) {
	        			return date.substr(0, 4) + "-" + date.substr(4, 2) + "-" + date.substr(6);
	        		} else {
	        			return date;
	        		}
	    		}
            },
            {key: "slpno", label: "전표번호"},          
            {key: "reasn", label: "이유코드"},
            {key: "qtycd", label: "수량구분"},
            {key: "trqty", label: "처리수량", formatter: "money", align: "right"},
            {key: "succd", label: "공급／득의"},
            {key: "ittyp", label: "ITEM TYPE"},
            {key: "itcls", label: "ITEM CLASS"},
            {key: "mnfcs", label: "MANUFACTURING COST", width:150, formatter: "money", align: "right"}
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
		unitGrid.exportExcel("월 ScrapTicket.xls");
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
