var unitGrid;
var vnameMap = new HashMap();

var picker = new ax5.ui.picker();

(function() {
	mask.open();
})();

function search() {
	var pStartDate = $('#startDate').val();
	var pEndDate = $('#endDate').val();
	var pDivision = $('#division').val();
	var pPerformanceDivision = $('#performanceDivision').val();
	
	
	if (val_chk(pStartDate, "년월일 시작")) {
		var params = {
				"startDate": pStartDate,
				"endDate": pEndDate,
				"division": pDivision,
				"performanceDivision": pPerformanceDivision
				};
		var objList = getAjaxList("/WAE004MaterialCostByPeriodSearch/ajaxSearch.do", params)
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
	alert("조회");
	$.ajax({
		url: url,
		type    : "POST",
		async : false,
		data : params,
		success : function (data){
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
        	{key: "pyvnd", label: "업체"},
            {key: "procs", label: "공정"},
            {key: "pspno", label: "품번"},
            {key: "edatm", label: "적용일자"},
            {key: "price", label: "판매단가"},
            {key: "unmsr", label: "단위"},
            {key: "ittyp", label: "ITTYP"},
            {key: "itdsc", label: "품명"},
            {key: "krsur", label: "원재료"},
            {key: "surkr", label: "원재료 원"},
            {key: "surus", label: "원재료 달러"},
            {key: "surjp", label: "원재료 Y"},
            {key: "surur", label: "원재료 U"},
            {key: "krpur", label: "구매품"},
            {key: "krckd", label: "CKD 원"},
            {key: "ckdus", label: "CKD 달러"},
            {key: "ckdjp", label: "CKD Y"},
            {key: "ckdur", label: "CKD U"},
            {key: "ckdkr", label: "CKD W"},
            {key: "krpat", label: "도장비"},
            {key: "krcot", label: "도금비"},
            {key: "mchmu", label: "금형삼각비"},
            {key: "mager", label: "판관비율액"},
            {key: "hndtm", label: "공수 합계"},
            {key: "drman", label: "직접노무비"},
            {key: "sbman", label: "간접노무비"},
            {key: "drmch", label: "고정 경비"},
            {key: "sbmch", label: "간접경비"},
            {key: "epckd", label: "로얄티금액"},
            {key: "dangu", label: "단가구분"},
            {key: "danst", label: "영업단가"},
            {key: "dandt", label: "단가적용일"},
            {key: "crtdt", label: "생성일자"},
            {key: "chgdt", label: "수정일자"},
            {key: "prtqy", label: "실적수량"},
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
		target: $('[data-ax5picker="basic"]'),
        direction: "top",
        content: {
            width: 270,
            margin: 10,
            type: 'date',
            config: {
                control: {
                    left: '<i class="fa fa-chevron-left"></i>',
                    yearTmpl: '%s',
                    monthTmpl: '%s',
                    right: '<i class="fa fa-chevron-right"></i>'
                },
                lang: {
                    yearTmpl: "%s년",
                    months: ['01월', '02월', '03월', '04월', '05월', '06월', '07월', '08월', '09월', '10월', '11월', '12월'],
                    dayTmpl: "%s"
                }
            }
        },
    });
}) 