var unitGrid;
var vnameMap = new HashMap();

var picker = new ax5.ui.picker();

(function() {
	mask.open();
})();

function search() {

	//var pLocCode = $('#locCode').val();	//사업부
	var pJyymm = $('#jyymm').val();	//기준녕월
	//alert(pJyymm);
	if (val_chk(pJyymm, "기준년월")) {
		var pRltDate = calculation(pJyymm);
		//alert(pRltDate[0]+"==="+pRltDate[1]);
		//var params = {locCode: pLocCode, pYear: pRltDate[0], pMonth: pRltDate[1]};
		var params = {pYear: pRltDate[0], pMonth: pRltDate[1]};
		var objList = getAjaxList("/WAE036DailyDepartmentCostSearch/ajaxSearch.do", params)
	}
	return false;
}

//회계년도 계산
function calculation(pDate){
	var sParamSplit = pDate.split("-");
	var rDt =  new Array(); 
	var chkYY= sParamSplit[0].substr(2,4);
	var chkMM= parseInt(sParamSplit[1]);
	
	if(chkMM >= 1 && chkMM < 4){
		rDt[0]=chkYY-1;
	}else{
		rDt[0]=chkYY;
	}
	if(chkMM >= 4 && chkMM < 13){
		rDt[1]=chkMM-3;
	}else{
		rDt[1]=chkMM+9;
	}
	//alert(rDt[0]+"==="+rDt[1]);
	return rDt;
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
		//async : false,
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
          {key: "glmcu", label: "Business Unit", width:80},          
          {key: "mcdc", label: "Business Name", width:200},
          {key: "globj", label: "Object Account"},
          {key: "glsub", label: "Subsidiary", width:80},
          {key: "gmdl01", label: "Subsidiary Name", width:150},
          {key: "gldct", label: "Document Type"},
          {key: "gldgj", label: "JULIAN GL Date"},
          {key: "gldate", label: "GL Date", width:80},
          {key: "glsbl", label: "Subledger", width:80},
          {key: "glsblt", label: "Subledger Type"},
          {key: "glaa", label: "Amount", formatter: "money", align: "right"},
          {key: "glexa", label: "Explanation - Name", width:200},
          {key: "glexr", label: "Explanation - Remark", width:200},
          {key: "batchDate", label: "Batch Date", width:80}
      ]
	});
}
function commonClear(){
	//$('#year').val("");
	createGrid();
	$('span.total').text("");
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
		unitGrid.exportExcel("일일 부문비현황.xls");
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