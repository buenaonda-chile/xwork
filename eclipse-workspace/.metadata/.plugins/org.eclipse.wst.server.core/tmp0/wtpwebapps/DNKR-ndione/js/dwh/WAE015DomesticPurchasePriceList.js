var unitGrid;
var vnameMap = new HashMap();

var picker = new ax5.ui.picker();

(function() {
	mask.open();
})();

function search() {

	var pLocCode = $('#locCode').val();	//사업부
	var gStartDate = $('#startDate').val();	//시작일자
	var gEndDate = $('#endDate').val();	//종료일자
	var pStartDate = gStartDate.replace(/-/gi,"");
	var pEndDate =  gEndDate.replace(/-/gi,"");
	
	if (val_chk(pStartDate, "시작일자")) {
		if (val_chk(pEndDate, "종료일자")) {	
			var params = {locCode: pLocCode, startDate: pStartDate, endDate: pEndDate};
			var objList = getAjaxList("/WAE015DomesticPurchasePriceListSearch/ajaxSearch.do", params)
		}
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
          {key: "itcls", label: "제품"},          
          {key: "vndnr", label: "입고업체"},
          {key: "pspno", label: "품번", width:200},
          {key: "itdsc", label: "품명", width:250},
          {key: "trndt", label: "입고일자", formatter: function(){
		          	var date = this.value;
		        	if(date !== null){
		        		if(date.length == 8) {
		        			return date.substr(0, 4) + "-" + date.substr(4, 2) + "-" + date.substr(6);
		        		} else {
		        			return date;
		        		}
		        	}
				}
		    },
          {key: "trqty", label: "거래수량", formatter: "money", align: "right"},
          {key: "trfot", label: "단가구분"},
          {key: "trcst", label: "거래단가", formatter: "money", align: "right"}
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
		unitGrid.exportExcel("국내 구매단가 정단가화 List.xls");
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