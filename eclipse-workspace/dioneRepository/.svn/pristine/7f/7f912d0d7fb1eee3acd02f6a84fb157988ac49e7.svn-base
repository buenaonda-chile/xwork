var unitGrid;
var vnameMap = new HashMap();

var picker = new ax5.ui.picker();

(function() {
	mask.open();
})();

function search() {

	
	var pJobName = document.querySelector('input[name="selectMenu"]:checked').value;	//처리구분
	//var pComps = $('#comps').val();	//사업부
	var pLocCode = $('#locCode').val();	//사업부
	var pPspno = $('#pspno').val();	//품번
	var pHouse = $('#house').val();	//창고
	var pPrdcd = $('#prdcd').val();	//제품구분
	var pItcls = $('#itcls').val();	//Item Class구분
	var pPackc = $('#packc').val();	//packing 사업부

	if(pJobName!="item" && pLocCode =="LOC000004"){
		alert("[알림]구KA사업부 선택시에만 조회 가능합니다.");
		return;
	}
	
	if (val_chk(pJobName, "처리구분")) {
		var params = {jobName: pJobName, locCode: pLocCode, pspno: pPspno, house: pHouse, prdcd: pPrdcd, itcls: pItcls, packc: pPackc};
		var objList = getAjaxList("/WAE016ProductInventorySearch/ajaxSearch.do", params)
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
	if(type=="item"){
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
	            {key: "itnbr", label: "품번", width:200},
	            {key: "itdsc", label: "품명", width:250, align:"left"},
	            {key: "cusno", label: "업체"},
	            {key: "cusnm", label: "업체명", width:200},
	            {key: "mohtq", label: "현)재고수량", align:"right", formatter: "money"},
	            {key: "enddt", label: "최종출고일", formatter: function(){
		            	var date = this.value;
		            	if(date !== null){
		            		if(date.length == 8) {
			        			return date.substr(0, 4) + "-" + date.substr(4, 2) + "-" + date.substr(6);
			        		} else {
			        			return date;
			        		}
		            		
		            	}
		        		
		    		}
	            }
	        ],
	        footSum: [
	            [
		            {label: "TOTAL", colspan: 5, align: "center"},
		            {key: "mohtq", collector: "sum", formatter: "money", align: "right"},
		            {label: ""}
		        ]
	        ]
		});	
	}
	else if(type=="prdcd"){
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
	            {key: "itnbr", label: "품번", width:200},
	            {key: "itdsc", label: "품명", width:250, align:"left"},
	            {key: "house", label: "창고"},
	            {key: "ittyp", label: "ITTYP"},
	            {key: "itcls", label: "ITCLS"},
	            {key: "mohtq", label: "재고수량", align:"right", formatter: "money"}, 
	            {key: "amt", label: "재고금액", align:"right", formatter: "money"}

	        ],
	        footSum: [
	          [
	            {label: "합계", colspan: 5, align: "center"},
	            {key: "mohtq", collector: "sum", formatter: "money", align: "right"},
	            {key: "amt", collector: "sum", formatter: "money", align: "right"},
	            {key: "imc12", collector: "sum", formatter: "money", align: "right"}
	          ]
	        ]
		});		
	}
	else if(type=="house"){
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
	                  {key: "itnbr", label: "품번", width:200},          
	                  {key: "itdsc", label: "품명", width:250, align:"left"},
	                  {key: "house", label: "창고", width:80},
	                  {key: "ittyp", label: "ITTYP", width:80},
	                  {key: "itcls", label: "ITCLS", width:80},
	                  {key: "begin", label: "이월", formatter: "money", align: "right"},
	                  {key: "trqtyRc", label: "전일입고", formatter: "money", align: "right"},
	                  {key: "recmo", label: "입고누계", formatter: "money", align: "right"},
	                  {key: "trqtyIw", label: "전일출고", formatter: "money", align: "right"},          
	                  {key: "issmo", label: "출고누계", formatter: "money", align: "right"},          
	                  {key: "adjmo", label: "조정", formatter: "money", align: "right"},
	                  {key: "mohtq", label: "재고수량", formatter: "money", align: "right"}
	                  //{key: "amt", label: "재고금액", formatter: "money", align: "right"}
	              ],
	  	   footSum: [
	                 [
	                  {label: "합계", colspan: 5, align: "center"},
	                  {key: "begin", collector: "sum", formatter: "money", align: "right"},
	                  {key: "trqtyRc", collector: "sum", formatter: "money", align: "right"},
	                  {key: "recmo", collector: "sum", formatter: "money", align: "right"},
	                  {key: "trqtyIw", collector: "sum", formatter: "money", align: "right"},
	                  {key: "issmo", collector: "sum", formatter: "money", align: "right"},
	                  {key: "adjmo", collector: "sum", formatter: "money", align: "right"},
	                  {key: "mohtq", collector: "sum", formatter: "money", align: "right"}
	                  //{key: "amt", collector: "sum", formatter: "money", align: "right"}
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
function commonClear(){
	
	var pJobName = document.querySelector('input[name="selectMenu"]:checked').value;	//처리구분
	if(pJobName=="item"){
		$('#locCode').prop('disabled', false);
		$('#pspno').prop('disabled', false);
		$('#house').prop('disabled', true);	//창고
		$('#prdcd').prop('disabled', true);	//제품구분
		$('#itcls').prop('disabled', true);	//Item Class구분	
		$('#packc').prop('disabled', true);	//packing 사업부
	}else if(pJobName=="prdcd"){
		$('#locCode').val("LOC000001");	//사업부(창원 강제)
		
		$('#locCode').prop('disabled', true);
		$('#pspno').prop('disabled', true);	
		$('#house').prop('disabled', false);	//창고
		$('#prdcd').prop('disabled', false);	//제품구분
		$('#itcls').prop('disabled', false);	//Item Class구분	
		$('#packc').prop('disabled', true);	//packing 사업부
	}else if(pJobName=="house"){
		$('#locCode').val("LOC000001");	//사업부(창원 강제)
		$('#locCode').prop('disabled', true);
		$('#pspno').prop('disabled', true);	
		$('#house').prop('disabled', false);	//창고
		$('#prdcd').prop('disabled', false);	//제품구분
		$('#itcls').prop('disabled', false);	//Item Class구분	
		$('#packc').prop('disabled', false);	//packing 사업부
	}
	createGrid(pJobName);	 
}

$(document).ready(function() {
	mask.close();
	
//	=== grid =================================================
	
	/*
	//dash(-)로 구분되는 날짜 포맷터 
	ax5.ui.grid.formatter["date"] = function() {
		var date = this.value;
		if(date.length == 8) {
			return date.substr(0, 4) + "-" + date.substr(4, 2) + "-" + date.substr(6);
		} else {
			return date;
		}
	}
	*/
	//그리드 객체 생성
	commonClear();	//그리드 초기화
	
	$('._searchBtn_').on('click', function() {
		search();
		return false;
	});
	
	
	$('.exel').on('click', function() {
		unitGrid.exportExcel("현재고 조회.xls");
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
