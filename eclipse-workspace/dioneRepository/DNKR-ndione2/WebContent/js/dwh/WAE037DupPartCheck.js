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
		var objList = getAjaxList("/WAE037DupPartCheck/ajaxSearch.do", params)
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
        		  {key: "tcode", label: "TRANS CD", width:100},
                  {key: "trnno", label: "TRANS NO", width:100},
                  {key: "tagcd", label: "TAG SLIP CD", width:100},
                  {key: "insno", label: "INSTRUCTION NO", width:100},
                  {key: "prtno", label: "PART NO", width:200},
                  {key: "house", label: "WAREHOUSE", width:100},
                  {key: "trndt", label: "TRANS DATE", width:100},
                  {key: "qtycd", label: "QTY CD", width:100},
                  {key: "trqty", label: "TRANS QTY", width:100},
                  {key: "succd", label: "SUPPLIER CUSTOMER CD", width:100},
                  {key: "slpno", label: "SLIP NO", width:100},
                  {key: "ngdcd", label: "NO-GOOD CD", width:100},
                  {key: "reasn", label: "REASON CD", width:100},
                  {key: "price", label: "UNIT PRISE", width:100},
                  {key: "curcy", label: "CURRENCY CD", width:100},
                  {key: "purum", label: "PUCHASE UNIT OF MEASURE", width:100},
                  {key: "umcnv", label: "UNIT OF MEASURE", width:100},
                  {key: "itcls", label: "ITEM CLASS", width:100},
                  {key: "clsno", label: "CLASSIFICATION NO", width:100},
                  {key: "cprno", label: "CUSTOMER PART NO", width:100},
                  {key: "duedt", label: "DUE DATE", width:100},
                  {key: "orqty", label: "ORDER QTY", width:100},
                  {key: "pdtz6", label: "UPDATE", width:100},
                  {key: "devid", label: "DEVICE ID", width:100},
                  {key: "terno", label: "TERMINAL NO", width:100},
                  {key: "sradr", label: "SLIT READER", width:100},
                  {key: "linid", label: "LINE NAME", width:100}
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
		unitGrid.exportExcel("중복리스트.xls");
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
