var unitGrid;
var vnameMap = new HashMap();

var picker = new ax5.ui.picker();

(function() {
	mask.open();
})();

function search() {
	/*
	var pComps = $('#comps').val();	//사업부
	var pYear = $('#year').val();
		
	if (val_chk(pComps, "사업부")) {
		var params = {comps: pComps, year: pYear};
		var objList = getAjaxList("/WAE019MaterialShippingReceivingSearch/ajaxSearch.do", params)
	}
	return false;
	*/
	var pSelectMenu = document.querySelector('input[name="selectMenu"]:checked').value;	
	//var pLocCode = $('#locCode').val();	//사업부
	var pLocCode ="LOC000001";	//사업부(창원 강제)
	var params = {jobFileName: pSelectMenu, locCode: pLocCode};
	var objList = getAjaxList("/WAE019MaterialInventorySearch/ajaxSearch.do", params)
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
    					var pSelectMenu = document.querySelector('input[name="selectMenu"]:checked').value;	
    					createGrid(pSelectMenu);
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

function createGrid(type){
	//그리드 객체 생성
	if(type=="DWH151PF"){
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
	            {key: "house", label: "창고", width:80},          
	            {key: "packc", label: "PACKC", width:80},
	            {key: "prdcd", label: "제품코드", width:80},
	            {key: "pspno", label: "품번", width:200},
	            {key: "itdsc", label: "품명", width:250},
	            {key: "imqqy", label: "재고수량", align:"right", formatter: "money"}, 
	            {key: "price", label: "PRICE", align:"right", formatter: "money"}
	           
	        ]
		});		
	}
	else if(type=="DWH155PF"){
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
	            {key: "pspno", label: "품번", width:200},
	            {key: "itdsc", label: "품명", width:250, align:"left"},
	            {key: "house", label: "창고", width:50},
	            {key: "gubun", label: "구분", width:50},
	            {key: "itcls1", label: "ITCLS1", width:50},
	            {key: "itcls2", label: "ITCLS2", width:50}, 
	            {key: "ittyp", label: "ITTYP", width:50}, 
	            {key: "plann", label: "PLANNER"}, 
	            {key: "imq00", label: "전월재고", align:"right", formatter: "money"}, 
	            {key: "imi12", label: "당월입고", align:"right", formatter: "money"}, 
	            {key: "imo12", label: "당월출고", align:"right", formatter: "money"}, 
	            {key: "imc12", label: "당월조정", align:"right", formatter: "money"}, 
	            {key: "imq12", label: "당월재고", align:"right", formatter: "money"}, 
	            {key: "dif12", label: "조정", align:"right", formatter: "money"}, 
	            {key: "mnfcs", label: "표준원가", align:"right", formatter: "money"} 
	        ],
	        footSum: [
	          [
	            {label: "합계", colspan: 9, align: "center"},
	            {key: "imq00", collector: "sum", formatter: "money", align: "right"},
	            {key: "imi12", collector: "sum", formatter: "money", align: "right"},
	            {key: "imo12", collector: "sum", formatter: "money", align: "right"},
	            {key: "imc12", collector: "sum", formatter: "money", align: "right"},
	            {key: "imq12", collector: "sum", formatter: "money", align: "right"},
	            {key: "dif12", collector: "sum", formatter: "money", align: "right"},
	            {label: "", align: "center"}

	          ]
	        ]
		});		
	}
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
		
	$('._searchBtn_').on('click', function() {
		search();
		return false;
	});	
	
	$('.exel').on('click', function() {
		unitGrid.exportExcel("MaterialInventory-excel.xls");
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
    	alert("[알림]구KA사업부 전용프로그램입니다.");
    }
}) 

function commonClear(obj){
	createGrid(obj.value);	
}