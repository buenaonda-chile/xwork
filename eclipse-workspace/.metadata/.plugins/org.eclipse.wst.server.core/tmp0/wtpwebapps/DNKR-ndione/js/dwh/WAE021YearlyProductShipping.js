var unitGrid;
var vnameMap = new HashMap();

var picker = new ax5.ui.picker();

(function() {
	mask.open();
})();

function search() {
		
	var pLocCode = $('#locCode').val();	//사업부
	var pStartDate = $('#startDate').val();	//시작일자
	var pEndDate = $('#endDate').val();	//사업부
	if (val_chk(pLocCode, "사업부")) {
		if (val_chk(pStartDate, "시작일자")) {
			if (val_chk(pEndDate, "종료일자")) {
				var params = {locCode: pLocCode, startDate: pStartDate, endDate: pEndDate};
				var objList = getAjaxList("/WAE021YearlyProductShippingSearch/ajaxSearch.do", params);
			}
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
			//console.log(data);
			try{
				var parse = JSON.parse(data);
    			if(parse.result === RESULT_Y){
    				objList = parse;
    				try {    				
    					//Start - 날짜계산
    					var sDt = $('#startDate').val().split('-');
    					var eDt = $('#endDate').val().split('-');
    					var sYear= sDt[0];
    					var sMonth = sDt[1];
    					var eYear = eDt[0];
    					var eMonth =  eDt[1];
    					//alert(sYear+sMonth);
    					
    					var month_diff = (eYear - sYear)* 12 + (eMonth - sMonth);
    					createGrid($('#locCode').val(), month_diff);
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


function createGrid(type, monCnt){
	//그리드 객체 생성
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
			{key: "ITCLS", label: "제품", width:50},   
		

        ]
	});	
	if(type=="LOC000004"){//구KE인 경우
		unitGrid.addColumn({key: "PYVND", label: "거래처", width:70});
		unitGrid.addColumn({key: "CUSNM", label: "거래처명", width:200});
		unitGrid.addColumn({key: "CARCD", label: "차종", width:150});   
		unitGrid.addColumn({key: "MSTRM", label: "차종명", width:150});   
		unitGrid.addColumn({key: "PSPNO", label: "품번", width:150});   
		unitGrid.addColumn({key: "ITDSC", label: "품명", width:200}); 
	}else{//구KA인경우
		unitGrid.addColumn({key: "PSPNO", label: "품번", width:150});   
		unitGrid.addColumn({key: "ITDSC", label: "품명", width:200}); 
		unitGrid.addColumn({key: "PYVND", label: "거래처", width:70});
		unitGrid.addColumn({key: "CUSNM", label: "거래처명", width:200});
		unitGrid.addColumn({key: "PCOST", label: "단가", formatter: "money", align: "right"});
	}
	
	var sDt = $('#startDate').val().split('-');
	var dtCnt = new Date(sDt[0], sDt[1], '01');

	for(i=0; i<=monCnt; i++){
		if (i != 0){
			dtCnt.setMonth(dtCnt.getMonth()+1);       		
    	}
		var iYear = dtCnt.getFullYear();
		var iMonth = dtCnt.getMonth();
		if(dtCnt.getMonth()==0){
			iYear = dtCnt.getFullYear()-1;
			iMonth = "12";
		}
		unitGrid.addColumn({key: "JPSQY"+i, label: iYear+"/"+iMonth+"수량", formatter: "money", align: "right"});		
		unitGrid.addColumn({key: "JPSAM"+i, label: iYear+"/"+iMonth+"금액", formatter: "money", align: "right"});		
	}
	
}

function commonClear(){
	createGrid($('#locCode').val(), -1);
}

$(document).ready(function() {
	mask.close();
	
	$('._searchBtn_').on('click', function() {
		search();
		return false;
	});	
	
	$('.exel').on('click', function() {
		unitGrid.exportExcel("년제품출하현황(월별).xls");
	});
//	=== //grid =================================================
    
	/*
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
    */
	// Date-year
	picker.bind({
		target: $('[data-ax5picker="basic"]'),
        direction: "top",
        content: {
            width: 270,
            margin: 10,
            type: 'date',
            config: {
            	mode: "year", selectMode: "month",
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
