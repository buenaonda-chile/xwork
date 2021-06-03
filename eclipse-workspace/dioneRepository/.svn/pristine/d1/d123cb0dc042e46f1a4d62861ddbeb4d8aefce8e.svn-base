var unitGrid;
var vnameMap = new HashMap();

var picker = new ax5.ui.picker();

(function() {
	mask.open();
})();

function search() {

	var pJobFileName = "DWH102PF";
	var pLocCode = $('#locCode').val();	//사업부
	if (val_chk(pJobFileName, "작업파일")) {
		var params = {jobFileName: pJobFileName, locCode: pLocCode};
		var objList = getAjaxList("/WAE022ShippingSalesSearch/ajaxSearch.do", params)
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
                  {key: "comps", label: "사업부", width:50},   
                  {key: "pyvnd", label: "거래처코드", width:80},   
                  {key: "cusnm", label: "거래처명", width:200},   
                  {key: "prdcd", label: "제품코드", width:70},   
                  {key: "pspno", label: "품번", width:200},   
                  {key: "itdsc", label: "품명", width:250},   
                  {key: "cprtn", label: "OEM품번", width:200},   
                  {key: "cpdsc", label: "OEM품명", width:250},   
                  {key: "ittyp", label: "Item Type", width:80},   
                  {key: "itcls", label: "Item Class", width:80},   
                  {key: "carcd", label: "차종코드", width:80},   
                  {key: "mstsm", label: "차종명1", width:80},   
                  {key: "mstrm", label: "차종명2"},   
                  {key: "jpsqy", label: "출하수량", formatter: "money", align: "right"},   
                  {key: "jpsam", label: "출하금액", formatter: "money", align: "right"},   
                  {key: "strtam", label: "특소세", formatter: "money", align: "right"},   
                  {key: "etrtam", label: "교육세", formatter: "money", align: "right"},   
                  {key: "bugaam", label: "부가세", formatter: "money", align: "right"},   
                  {key: "edatm", label: "단가적용일자", formatter: function(){
			            	var date = this.value;
			        		if(date.length == 8) {
			        			return date.substr(0, 4) + "-" + date.substr(4, 2) + "-" + date.substr(6);
			        		} else {
			        			return date;
			        		}
		            	}
                  },
                  {key: "price", label: "현단가", formatter: "money", align: "right"},   
                  {key: "iordt", label: "수주유형", width:70},   
                  {key: "ialyr", label: "적용율", width:50},   
                  {key: "idisr", label: "배분율", width:50},   
                  {key: "iqtyp", label: "단위수량", width:70},   
                  {key: "ifrdt", label: "시작일자", formatter: function(){
			            	var date = this.value;
			        		if(date.length == 8) {
			        			return date.substr(0, 4) + "-" + date.substr(4, 2) + "-" + date.substr(6);
			        		} else {
			        			return date;
			        		}
		            	}
                  }
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
		unitGrid.exportExcel("출하매출현황.xls");
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
}) 
