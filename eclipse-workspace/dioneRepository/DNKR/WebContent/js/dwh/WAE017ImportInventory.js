

var unitGrid;

var picker = new ax5.ui.picker();

(function() {
	mask.open();
})();

function search() {
	
	var pLocCode = $('#locCode').val();
	var pExpno = $('#expno').val();
	var pMohtqTf ="";
	if($('#mohtqTf').is(":checked") == true){
		pMohtqTf="T"
	}else{
		pMohtqTf="F"
	}	
	if (val_chk(pLocCode, "사업부")) {
		var params = {locCode: pLocCode, expno: pExpno, mohtqTf: pMohtqTf};
		var objList = getAjaxList("/WAE017ImportInventorySearch/ajaxSearch.do", params)
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
			onDBLClick : function() {
					//alert(this.item.expno);
					var actionUrl = "/WAE017ImportInventorySearch/importInventoryPop.do";
					$('#pExpno').val(this.item.expno);
					var popUp = document.WAE017ImportInventoryForm;
					var popCall = window.open("" ,"importInventoryPop","width=1024,height=700,scrollbars=yes,top=100,left=100");
						popUp.action =actionUrl; 
						popUp.method="post";
						popUp.target="importInventoryPop";
						popUp.submit();
			},
        },
        columns: [
            {key: "expno", label: "수입품번", width:200},          
            {key: "mohtq", label: "무상사급", align:"right", formatter: "money"}, 
            {key: "doqtySaqtyMohtq", label: "보세+자재 수량", align:"right", formatter: "money"}, 
            {key: "mnfcs", label: "제조원가", align:"right", formatter: "money" }, 
            {key: "dsmMnfcsPrice", label: "보세+자재금액", align:"right" ,  formatter: function(){
            	if(this.value == null){
            		this.value=0;
            	}
            	return ax5.util.number(this.value, {"money": true});}
            },
            {key: "dsmPrice", label: "보세재고금액", align:"right", formatter: "money" }
        ],
        footSum: [
           [
            {label: "합계", colspan: 4, align: "center"},
            {key: "dsmMnfcsPrice", collector: "sum", formatter: "money", align: "right"},
            {key: "dsmPrice", collector: "sum", formatter: "money", align: "right"}
           ]
        ]
	});
}
function commonClear(){
	createGrid();
}
$(document).ready(function() {
	mask.close();
	alert("[알림]구KE사업부 전용프로그램입니다.");
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
	createGrid();

	$('._searchBtn_').on('click', function() {
		search();
		return false;
	});
	
	
	$('.exel').on('click', function() {
		unitGrid.exportExcel("psogmPer-excel.xls");
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

