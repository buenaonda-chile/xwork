var unitGridPop;

function getAjaxListPop (url, params) {
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
    					gridSetDataPop(objList);
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

function gridSetDataPop (objList) {
	unitGridPop.setData(objList.list);
}

$(document).ready(function() {

	//	=== grid =================================================
	//그리드 객체 생성
	unitGridPop = new ax5.ui.grid({
		
        target: $('[data-ax5grid="unit-gridPop"]'),
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
            {key: "order", label: "ORDER NO", width:85},          
            {key: "dudat", label: "납기일자", width:85,  formatter: function(){
	            	var date = this.value;
	        		if(date.length == 8) {
	        			return date.substr(0, 4) + "-" + date.substr(4, 2) + "-" + date.substr(6);
	        		} else {
	        			return date;
	        		}
        		}
            },
            {key: "orqty", width:85, label: "발주수량", align:"right", formatter: "money"}
        ],
        footSum: [
          [
            {label: "합계", colspan: 2, align: "center"},
            {key: "orqty", collector: "sum", formatter: "money", align: "right"},
          ]
        ]
	});
	
//	=== //grid =================================================
	callPop2(); //grid조회
}) 
function callPop2(){
	var pComps = $('#comps').val();
	var pExpno = $('#expno').val();
	var pLocCode = $('#locCode').val();
	var params = {comps: pComps, expno: pExpno, locCode: pLocCode};
	var actionUrl = "/WAE017ImportInventorySearch/ajaxImportInventoryPop.do";
	getAjaxListPop(actionUrl,params);
}
