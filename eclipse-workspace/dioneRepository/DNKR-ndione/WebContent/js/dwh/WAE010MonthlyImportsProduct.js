var unitGrid;
var vnameMap = new HashMap();

var picker = new ax5.ui.picker();

(function() {
	mask.open();
})();

function search() {


	var pLocCode = $('#locCode').val();	//사업부
	if (val_chk(pLocCode, "사업부")) {
		var params = {locCode: pLocCode};
		var objList = getAjaxList("/WAE010MonthlyImportsProductSearch/ajaxSearch.do", params)
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
                {key: "kubun", label: "구분", width:50},          
                {key: "cc",    label: "제품코드", width:50},
                {key: "pspno", label: "품번", width:150},
                {key: "itdsc", label: "품명", width:150},
                {key: "ittyp", label: "형태", width:150},
                {key: "itcls", label: "분류"},
                {key: "jpsqy", label: "판매수량"},
                {key: "cpano", label: "구성품번", width:150},
                {key: "ee",    label: "제품코드", width:150},
                {key: "ittyp", label: "형태"},
                {key: "itcls", label: "분류"},
                {key: "qtypr", label: "구성수량"},
                {key: "edatm", label: "적용시작일", formatter: function(){
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
                {key: "edato", label: "적용종료일", formatter: function(){
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
                {key: "dpg1s1", label: "구매업체"},
                {key: "vcntr", label: "국가"},
                {key: "mnfcs", label: "제조원가", formatter: "money", align: "right"},
                {key: "aa", label: "소요량", formatter: "money", align: "right"},
                {key: "bb", label: "소요금액", formatter: "money", align: "right"},
                {key: "crcye", label: "통화"},
                {key: "prcee", label: "구매단가", formatter: "money", align: "right"}
              
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
		unitGrid.exportExcel("월별제품별 수입품 사용현황.xls");
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
	
	alert("[알림]구KA사업부 전용프로그램입니다.");
}) 