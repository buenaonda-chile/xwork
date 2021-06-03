var unitGrid;
var vnameMap = new HashMap();

var picker = new ax5.ui.picker();

(function() {
	mask.open();
})();

function search() {
	var pYear = $('#year').val();
	var pLocCode = $('#locCode').val();
	if (val_chk(pYear, "조회년도")) {
		var params = {year: pYear,
						  locCode : pLocCode,
		};
		var objList = getAjaxList("/WAE001MaterialReceivingSearch/ajaxSearch.do", params)
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
            {key: "house", label: "창고"},
            {key: "vndnr", label: "입고업체"},
            {key: "vname", label: "입고업체명", width:200,
            	formatter:function(){		
					var vndnr = this.item.vndnr;
					//console.log(vndnr);
					if(vnameMap.get(vndnr)) {
						return vnameMap.get(vndnr);
					} else {
						return "";
					}
				}
            },
            {key: "pspno", label: "품번"},
            {key: "itdsc", label: "ITDSC", width:200},
            {key: "ittyp", label: "형태"},
            {key: "itcls", label: "분류"},
            {key: "prdgu", label: "제품구분"},
            {key: "prdcd", label: "제품코드"},
            {key: "supgu", label: "조달구분"},
            {key: "trcst", label: "거래단가"},
            {key: "crcyw", label: "거래통화"},
            {key: "trfot", label: "단가구분"},
            {key: "month1", label: "01月"},
            {key: "month2", label: "02月"},
            {key: "month3", label: "03月"},
            {key: "month4", label: "04月"},
            {key: "month5", label: "05月"},
            {key: "month6", label: "06月"},
            {key: "month7", label: "07月"},
            {key: "month8", label: "08月"},
            {key: "month9", label: "09月"},
            {key: "month10", label: "10月"},
            {key: "month11", label: "11月"},
            {key: "month12", label: "12月"},
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
	
	/*// Date-year
	picker.bind({
        target: $('[data-picker-date="month"]'),
        direction: "top",
        content: {
            width: 270,
            margin: 10,
            type: 'date',
            formatter: {
                pattern: 'date(month)'
            },
            config: {
            	mode : "year",
            	selectMode: "month",
                control: {
                    left: '<i class="fa fa-chevron-left"></i>',
                    yearTmpl: '%s'
                },
                lang: {
                    yearTmpl: "%s년"
                }
            }
        },
    });*/
	
	
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
}) 