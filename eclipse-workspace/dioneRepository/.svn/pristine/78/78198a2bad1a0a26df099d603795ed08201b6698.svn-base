var unitGrid;
var vnameMap = new HashMap();

var picker = new ax5.ui.picker();

(function() {
	mask.open();
})();

function search() {

	var pJobFileName = "DWH122PF";
	//var pLocCode = $('#locCode').val();	//사업부
	var pLocCode ="LOC000001";	//사업부(창원 강제)
	if (val_chk(pJobFileName, "작업파일")) {
		var params = {jobFileName: pJobFileName, locCode: pLocCode};
		var objList = getAjaxList("/WAE014OceanListSalesRevenueSearch/ajaxSearch.do", params)
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
          {key: "comps", label: "사업부", width:50},          
          {key: "house", label: "WAREHOUSE"},
          {key: "prddv", label: "PRODUCT DIVISION"},
          {key: "prddd", label: "DIVISION DESCRIPTION",},
          {key: "pyvnd", label: "업체코드"},
          {key: "pspno", label: "품번", width:150},
          {key: "jpsqy1", label: "수량1", formatter: "money", align: "right"},
      /*    {key: "jpsam1", label: "금액1", formatter: "money", align: "right"},*/
          {key: "jpsam1", label: "금액1", formatter: function() {return ax5.util.number(this.item.jpsam1, {"money": 1});}, align: "right"},
          {key: "jpsqy2", label: "수량2", formatter: "money", align: "right"},
     /*     {key: "jpsam2", label: "금액2", formatter: "money", align: "right"},*/
          {key: "jpsam2", label: "금액2", formatter: function() {return ax5.util.number(this.item.jpsam2, {"money": 1});}, align: "right"},
          {key: "addno", label: "JDE ADDRESS"},
          {key: "prli1", label: "ITEM 1ST"},
          {key: "prli2", label: "ITEM 2ST"},
          {key: "prtno", label: "PART NO.", width:150},
          {key: "odate", label: "DATE OCCURED", formatter: function(){
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
          {key: "invct", label: "INVENTORY CATEGORY"},
          {key: "prlcd", label: "PRODUCT LINE"},
          {key: "edate", label: "ENTRY DATE", formatter: function(){
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
/*		    
          {key: "mnfcs", label: "MFG.COST", formatter: "money", align: "right"},
          {key: "dircs", label: "DIRECT COST", formatter: "money", align: "right"},
          {key: "dirmc", label: "DIR.MAT.COST", formatter: "money", align: "right"},
          {key: "rmatl", label: "RAW MAT.LOCAL", formatter: "money", align: "right"},
          {key: "rmati", label: "RAW MAT.IMPORT", formatter: "money", align: "right"},
          {key: "rmimc", label: "RAW MAT.CHARGE", formatter: "money", align: "right"},
          {key: "purcl", label: "PUR.LOCAL", formatter: "money", align: "right"},
          {key: "purci", label: "PUR.IMPORT", formatter: "money", align: "right"},
          {key: "ppimc", label: "PUR.CHARGE", formatter: "money", align: "right"},
          {key: "labcs", label: "LABOR COST", formatter: "money", align: "right"},
          {key: "depcs", label: "DEP.COST", formatter: "money", align: "right"},
          {key: "mfexp", label: "MFG.EXPENSES", formatter: "money", align: "right"},
          {key: "diecs", label: "DIE COST", formatter: "money", align: "right"},
          {key: "mohcs", label: "MFG.OVERHEAD", formatter: "money", align: "right"}
          */
          
          {key: "mnfcs", label: "MFG.COST", formatter: function() {return ax5.util.number(this.item.mnfcs, {"money": 1});}, align: "right"},
          {key: "dircs", label: "DIRECT COST", formatter: function() {return ax5.util.number(this.item.dircs, {"money": 1});}, align: "right"},
          {key: "dirmc", label: "DIR.MAT.COST", formatter: function() {return ax5.util.number(this.item.rmatl, {"money": 1});}, align: "right"},
          {key: "rmatl", label: "RAW MAT.LOCAL", formatter: function() {return ax5.util.number(this.item.rmatl, {"money": 1});}, align: "right"},
          {key: "rmati", label: "RAW MAT.IMPORT", formatter: function() {return ax5.util.number(this.item.rmati, {"money": 1});}, align: "right"},
          {key: "rmimc", label: "RAW MAT.CHARGE", formatter: function() {return ax5.util.number(this.item.rmimc, {"money": 1});}, align: "right"},
          {key: "purcl", label: "PUR.LOCAL", formatter: function() {return ax5.util.number(this.item.purcl, {"money": 1});}, align: "right"},
          {key: "purci", label: "PUR.IMPORT", formatter: function() {return ax5.util.number(this.item.purci, {"money": 1});}, align: "right"},
          {key: "ppimc", label: "PUR.CHARGE", formatter: function() {return ax5.util.number(this.item.ppimc, {"money": 1});}, align: "right"},
          {key: "labcs", label: "LABOR COST", formatter: function() {return ax5.util.number(this.item.labcs, {"money": 1});}, align: "right"},
          {key: "depcs", label: "DEP.COST", formatter: function() {return ax5.util.number(this.item.depcs, {"money": 1});}, align: "right"},
          {key: "mfexp", label: "MFG.EXPENSES", formatter: function() {return ax5.util.number(this.item.mfexp, {"money": 1});}, align: "right"},
          {key: "diecs", label: "DIE COST", formatter: function() {return ax5.util.number(this.item.diecs, {"money": 1});}, align: "right"},
          {key: "mohcs", label: "MFG.OVERHEAD", formatter: function() {return ax5.util.number(this.item.mohcs, {"money": 1});}, align: "right"}
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
		unitGrid.exportExcel("진매상 OCEAN LIST(가매출).xls");
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