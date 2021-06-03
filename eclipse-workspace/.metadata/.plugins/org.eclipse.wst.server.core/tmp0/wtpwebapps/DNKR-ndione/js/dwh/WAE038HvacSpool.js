var unitGrid;
var vnameMap = new HashMap();

var picker = new ax5.ui.picker();

(function() {
	mask.open();
})();

function search() {

	
	var pLocCode = $('#locCode').val();	//사업부
	var searchDate = $('#searchDate').val();	//기준년월
	var searchPrdcd = $('#searchPrdcd').val();	//제품코드
	var searchKubun = $('#searchKubun').val();	//구분
	//alert(pLocCode);
	var pHouse =""; //창고코드(사외창고제외)
	if(pLocCode=="LOC000001"){ //창원
		pHouse="('1','2','3','V','W')";
	}else if(pLocCode=="LOC000002"){ //홍성
		pHouse="('3')";
	}else if(pLocCode=="LOC000003"){ //화성
		pHouse="('2','V','W')";
	}else if(pLocCode=="LOC000004"){ //마산
		pHouse="('1')";
	}

	if (val_chk(searchDate, "기준년월")) {
		var params = {locCode: pLocCode, searchDate:searchDate, searchPrdcd: searchPrdcd, searchKubun: searchKubun, searchHouse: pHouse};
		var objList = getAjaxList("/WAE038HvacSpool/ajaxSearch.do", params)
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
        columns: [
                  {key: "comps", label: "사업부", width:50},
                  {key: "itcls", label: "분류", width:50},
                  //{key: "prdcd", label: "제품코드", width:50},
                  {key: "pspno", label: "품번", width:120, align: "left"},
                  {key: "itdsc", label: "품명", width:180, align: "left"},
                  {key: "mohtq", label: "현재고", width:60, formatter: "money", align: "right"},
                  /*
                  {key: "mohtq", label: "현재고", width:80, formatter: function(){
		            	var mohtq = this.value;
		            	return mohtq.substr(0, mohtq.indexOf('.'));
		    		}
                  },
                  */
        		  {key: "kubun", label: "구분", width:50},
                  {key: "msum", label: "총합", width:60, formatter: "money", align: "right"},
                  {key: "qty01", label: "1일", width:60, formatter: "money", align: "right"},
                  {key: "qty02", label: "2일", width:60, formatter: "money", align: "right"},
                  {key: "qty03", label: "3일", width:60, formatter: "money", align: "right"},
                  {key: "qty04", label: "4일", width:60, formatter: "money", align: "right"},
                  {key: "qty05", label: "5일", width:60, formatter: "money", align: "right"},
                  {key: "qty06", label: "6일", width:60, formatter: "money", align: "right"},
                  {key: "qty07", label: "7일", width:60, formatter: "money", align: "right"},
                  {key: "qty08", label: "8일", width:60, formatter: "money", align: "right"},
                  {key: "qty09", label: "9일", width:60, formatter: "money", align: "right"},
                  {key: "qty10", label: "10일", width:60, formatter: "money", align: "right"},
                  {key: "qty11", label: "11일", width:60, formatter: "money", align: "right"},
                  {key: "qty12", label: "12일", width:60, formatter: "money", align: "right"},
                  {key: "qty13", label: "13일", width:60, formatter: "money", align: "right"},
                  {key: "qty14", label: "14일", width:60, formatter: "money", align: "right"},
                  {key: "qty15", label: "15일", width:60, formatter: "money", align: "right"},
                  {key: "qty16", label: "16일", width:60, formatter: "money", align: "right"},
                  {key: "qty17", label: "17일", width:60, formatter: "money", align: "right"},
                  {key: "qty18", label: "18일", width:60, formatter: "money", align: "right"},
                  {key: "qty19", label: "19일", width:60, formatter: "money", align: "right"},
                  {key: "qty20", label: "20일", width:60, formatter: "money", align: "right"},
                  {key: "qty21", label: "21일", width:60, formatter: "money", align: "right"},
                  {key: "qty22", label: "22일", width:60, formatter: "money", align: "right"},
                  {key: "qty23", label: "23일", width:60, formatter: "money", align: "right"},
                  {key: "qty24", label: "24일", width:60, formatter: "money", align: "right"},
                  {key: "qty25", label: "25일", width:60, formatter: "money", align: "right"},
                  {key: "qty26", label: "26일", width:60, formatter: "money", align: "right"},
                  {key: "qty27", label: "27일", width:60, formatter: "money", align: "right"},
                  {key: "qty28", label: "28일", width:60, formatter: "money", align: "right"},
                  {key: "qty29", label: "29일", width:60, formatter: "money", align: "right"},
                  {key: "qty30", label: "30일", width:60, formatter: "money", align: "right"},
                  {key: "qty31", label: "31일", width:60, formatter: "money", align: "right"}
                 ],
          body: {
                 	align: "center",
                	onClick : function() {
        					this.self.clearSelect();
        					this.self.select(this.dindex);
        			},
        			 mergeCells: ["comps", "itcls", "pspno", "itdsc", "mohtq"]
        }
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
		unitGrid.exportExcel("제품생산출하재고실적.xls");
	});
//	=== //grid =================================================
    
	
	/*$('[data-ax5formatter]').ax5formatter();
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
    });*/
	var Calendar1 = new ax5.ui.calendar({
        target: document.getElementById("calendar_where1"),
        control: {
            left: '<i class="fa fa-chevron-left"></i>',
            yearTmpl: '%s',
            monthTmpl: '%s',
            right: '<i class="fa fa-chevron-right"></i>',
            yearFirst: true
        },
        displayDate: (new Date()),
        lang: {
        	yearTmpl: YEAR_FORMAT,
        	months: MONTH,
        	//months: ['01월', '02월', '03월', '04월', '05월', '06월', '07월', '08월', '09월', '10월', '11월', '12월'],
        	dayTmpl: "%s"
        },
        dimensions: {
            height: 250,
            controlHeight: 50,
            itemPadding: 5
        },
        onClick: function () {
        	var date = this.self.getSelection();
        	var formattedDate = new Date(date);
        	
        	var y = formattedDate.getFullYear();  
        	var m = formattedDate.getMonth(); 
        		m += 1; // JavaScript months are 0-11
        		m = m >= 10 ? m : '0' + m;	//month 두자리로 저장 
        	        	
       	 	$(this.target).css('display', 'none');
            $(this.target).prev().val(y+''+m);
            $('#lblselfield1').val(date);            
        },
        onStateChanged: function () {
            //console.log(this);
        }
    });
	
	$(' .dropdown').on('click', function(e){
		console.log('dropdown');
		$($(e.target).closest('.dropdown').find('.dropdown-menu')).css('display', 'block');
	});
	
	//제품코드 재조회
	$('#locCode').on('change',function(obj){
		createGrid();
		$('span.total').text("");
		
		$.ajax({
			url: "/WAE038HvacSpool/ajaxCodeSearch.do",
			method : "POST",
			data : {locCode: this.value},
			success : function (res){
				//console.log(res);
				var data = JSON.parse(res);
				//if (data.list.length > 0) { //없는 공장도 있음.
					//console.log("정상");
					//조회 select 외의 데이터 초기화
					$("select[name='searchPrdcd'] option").remove();  
					$("#searchPrdcd").append('<option value="">전체</option>');
					data.list.forEach(function(item, index){
						$("#searchPrdcd").append( '<option value="'+ item.mstcd +'">'+item.mstrm+'</option>');
					});
				//}
			},
			error: function(e){ 
				//console.log(e);
			},
			complete: function(e) {
				//console.log(e);
				mask.close();
			}
		});
	});
	
	//의왕 공장코드 삭제
	$("select[name='locCode'] option[value='LOC000005']").remove();
	//마산 공장코드 삭제 - Table이 다름
	$("select[name='locCode'] option[value='LOC000004']").remove();
}) 
