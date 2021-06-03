var unitGrid;
var vnameMap = new HashMap();

var picker = new ax5.ui.picker();

(function() {
	mask.open();
})();

function search() {
	var pYear = $('#year').val();
	var pDivision = $('#division').val();
	if (val_chk(pYear, "조회년도")) {
		var params = {
				"year": pYear,
				"division": pDivision
				};
		var objList = getAjaxList("/WAE003SalesPlanMaterialCostSearch/ajaxSearch.do", params)
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
            {key: "pyvnd", label: "득의선"},
            {key: "pspno", label: "품번", width:200},
            {key: "itdsc", label: "차종"},
            {key: "mstsm", label: "계획단가", width:200},
            {key: "yescs", label: "판매단가적용일"},
            {key: "edatm", label: "판매단가"},
            {key: "price", label: "원재료"},
            {key: "krsur", label: "원재료\\"},
            {key: "surkr", label: "원재료$"},
            {key: "surus", label: "원재료Y"},
            {key: "surjp", label: "원재료U"},
            {key: "surur", label: "구매품"},
            {key: "krpur", label: "CKD\\"},
            {key: "krckd", label: "CKD$"},
            {key: "ckdus", label: "CKDY"},
            {key: "ckdjp", label: "CKDU"},
            {key: "ckdur", label: "CKD\\"},
            {key: "ckdkr", label: "4月"},
            {key: "ym1", label: "4月"},
            {key: "ym2", label: "5月"},
            {key: "ym3", label: "6月"},
            {key: "ym4", label: "7月"},
            {key: "ym5", label: "8月"},
            {key: "ym6", label: "9月"},
            {key: "ym7", label: "10月"},
            {key: "ym8", label: "11月"},
            {key: "ym9", label: "12月"},
            {key: "ym10", label: "1月"},
            {key: "ym11", label: "2月"},
            {key: "ym12", label: "3月"},
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