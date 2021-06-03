var unitGrid;
var vnameMap = new HashMap();

var picker = new ax5.ui.picker();

(function() {
	mask.open();
})();

function search() {
	var pYear = $('#year').val();
	if (val_chk(pYear, "조회년도")) {
		var params = {year: pYear};
		var objList = getAjaxList("/WAE002PurchasePriceSearch/ajaxSearch.do", params)
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

$(document).ready(function() {
	mask.close();
	
//	=== grid =================================================
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
            {key: "recid", label: "RECORD IDENTIFIER", width:200},
            {key: "prtno", label: "PART NO"},
            {key: "itdsc", label: "ITEM DESCRIPTION", width:200},
            {key: "spcod", label: "SPCOD"},
            {key: "vname", label: "VNAME"},
            {key: "unmsr", label: "UNIT OF MEASUER"},
            {key: "itcls", label: "ITEM CLASS"},
            {key: "ittyp", label: "ITEM TYPE CODE"},
            {key: "crcye", label: "CURRENCY CODE"},
            {key: "tempe", label: "TEMPORARY CODE"},
            {key: "resne", label: "CHANGE REASON"},
            {key: "prcee", label: "UNIT PRICE"},
            {key: "edate", label: "EFECTIVE DATE FROM", width:200},
        ]
	});
        
	
	$('._searchBtn_').on('click', function() {
		search();
		return false;
	});
	
	
	$('.exel').on('click', function() {
		unitGrid.exportExcel("psogmPer-excel.xls");
	});
//	=== //grid =================================================
    
	
	$('[data-ax5formatter]').ax5formatter();
	
	// Date-year
	picker.bind({
        target: $('[data-picker-date="year"]'),
        direction: "top",
        content: {
            width: 270,
            margin: 10,
            type: 'date',
            config: {
            	mode : "year",
            	selectMode: "year",
                control: {
                    left: '<i class="fa fa-chevron-left"></i>',
                    yearTmpl: '%s'
                },
                lang: {
                    yearTmpl: "%s년"
                }
            }
        },
    });
}) 