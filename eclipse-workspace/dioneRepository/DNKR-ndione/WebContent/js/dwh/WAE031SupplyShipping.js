var unitGrid;
var vnameMap = new HashMap();

var picker = new ax5.ui.picker();

(function() {
	mask.open();
})();

function search() {

	var pJobFileName = document.querySelector('input[name="selectMenu"]:checked').value;
	//var pLocCode = $('#locCode').val();	//사업부
	var pLocCode ="LOC000001";	//사업부(창원 강제)
	if (val_chk(pJobFileName, "작업파일")) {
		var params = {jobFileName: pJobFileName, locCode: pLocCode};
		var objList = getAjaxList("/WAE031SupplyShippingSearch/ajaxSearch.do", params)
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



function createGrid(type){
	//그리드 객체 생성
	if(type=="DWH201PF"){
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
	            {key: "isijp", label: "출고전표번호"},
	            {key: "isdpt", label: "출고부서업체"},
	            {key: "dpconm", label: "짧은명", width:250, align:"left"},
	            {key: "isidt", label: "출고일자", formatter: function(){
		            	var date = this.value;
		        		if(date.length == 8) {
		        			return date.substr(0, 4) + "-" + date.substr(4, 2) + "-" + date.substr(6);
		        		} else {
		        			return date;
		        		}
		    		}
	            },
	            {key: "isicl", label: "출고계정분류", width:80},
	            {key: "isipn", label: "출고품번", width:150, align:"left"},
	            {key: "smonm", label: "품명", width:200, align:"left"},
	            {key: "smobd", label: "규격", width:80},
	            {key: "isadt", label: "등록일자", width:80},
	            {key: "istim", label: "등록시간", width:80},
	            {key: "chlqy", label: "출고수량", width:80, formatter: "money", align: "right"},
	            {key: "rpist", label: "출고단가", width:80, formatter: "money", align: "right"},
	            {key: "chlam", label: "출고금액", width:80, formatter: "money", align: "right"},
	            {key: "opmcu", label: "Business Unit", width:80},
	            {key: "opobj", label: "Obj Account", width:80},
	            {key: "opsub", label: "Subsidiary", width:80},
	            {key: "gmdl0", label: "JDE DESCRIPTION"}
	        ],
	        footSum: [
	            [
		            {label: "TOTAL", colspan: 11, align: "center"},
		            {key: "chlqy", collector: "sum", formatter: "money", align: "right"},
		            {label: ""},
		            {key: "chlam", collector: "sum", formatter: "money", align: "right"}
		        ]
	        ]
		});	
	}
	else if(type=="DWH202PF"){
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
	            {key: "isicl", label: "출고계정분류"},
	            {key: "isipn", label: "출고품번", width:200},
	            {key: "smonm", label: "품명", width:250, align:"left"},
	            {key: "isijp", label: "출고전표번호"},
	            {key: "isdpt", label: "출고부서업체"},
	            {key: "isidt", label: "출고일자", formatter: function(){
		            	var date = this.value;
		        		if(date.length == 8) {
		        			return date.substr(0, 4) + "-" + date.substr(4, 2) + "-" + date.substr(6);
		        		} else {
		        			return date;
		        		}
		    		}
	            },
	            {key: "chlam", label: "출고금액", align:"right", formatter: "money"}

	        ],
	        footSum: [
	          [
	            {label: "합계", colspan: 6, align: "center"},
	            {key: "chlam", collector: "sum", formatter: "money", align: "right"}
	          
	          ]
	        ]
		});		
	}
}

function commonClear(jobName){
	
	createGrid(jobName);
	$('#year').val("");
	
}
$(document).ready(function() {
	mask.close();
		
	commonClear("DWH201PF");	//그리드 초기화

	$('._searchBtn_').on('click', function() {
		search();
		return false;
	});	
	
	$('.exel').on('click', function() {
		unitGrid.exportExcel("저장품출고현황.xls");
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
