var unitGrid;
var vnameMap = new HashMap();

var picker = new ax5.ui.picker();

(function() {
	mask.open();
})();

function search() {

	var pJobFileName = "DWH101PF";
	var pLocCode = $('#locCode').val();	//사업부
	if (val_chk(pJobFileName, "작업파일")) {
		var params = {jobFileName: pJobFileName, locCode: pLocCode};
		var objList = getAjaxList("/WAE023BusinessShippingMaterialSearch/ajaxSearch.do", params)
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
                  {key: "itcls", label: "Item Type", width:80},   
                  {key: "pspno", label: "품번", width:150},   
                  {key: "itdsc", label: "품명", width:200},   
                  {key: "carcd", label: "차종코드", width:70},   
                  {key: "mstrm", label: "차종명"},   
                  {key: "pyvnd", label: "업체코드", width:70},   
                  {key: "cusnm", label: "업체명", width:180},   
                  {key: "edatm", label: "적용일자", formatter: function(){
		            	var date = this.value;
		        		if(date.length == 8) {
		        			return date.substr(0, 4) + "-" + date.substr(4, 2) + "-" + date.substr(6);
		        		} else {
		        			return date;
		        		}
	            	}
                  },
                  {key: "price", label: "SALES PRICE", width:80},   
                  {key: "jpsqy", label: "전표수량", width:80},   
                  {key: "jpsam", label: "금액", width:80, formatter: "money", align: "right"},   
                  {key: "krsur", label: "원재료", width:80, formatter: "money", align: "right"},   
                  {key: "surkr", label: "원재료(￦)", width:80, formatter: "money", align: "right"},   
                  {key: "surus", label: "원재료($)", width:80, formatter: "money", align: "right"},   
                  {key: "surjp", label: "원재료(Y)", width:80, formatter: "money", align: "right"},   
                  {key: "surur", label: "원재료(U)", width:80, formatter: "money", align: "right"},   
                  {key: "krpur", label: "구매품", width:80, formatter: "money", align: "right"},   
                  {key: "krckd", label: "CKD(￦)", width:80, formatter: "money", align: "right"},   
                  {key: "ckdus", label: "CKD($)", width:80, formatter: "money", align: "right"},   
                  {key: "ckdjp", label: "CKD(Y)", width:80, formatter: "money", align: "right"},   
                  {key: "ckdur", label: "CKD(U)", width:80, formatter: "money", align: "right"},   
                  {key: "ckdkr", label: "CKD(￦)", width:80, formatter: "money", align: "right"}
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
		unitGrid.exportExcel("영업출하현황(재료비).xls");
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
    	alert("[알림]구KE사업부 전용프로그램입니다.");
    }
}) 
