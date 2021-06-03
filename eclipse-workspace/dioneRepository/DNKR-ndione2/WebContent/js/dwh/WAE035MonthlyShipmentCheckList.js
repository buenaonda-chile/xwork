var unitGrid;
var vnameMap = new HashMap();

var picker = new ax5.ui.picker();

(function() {
	mask.open();
})();

function search() {

	var pCompany = $('#company').val();	//사업부
	if(pCompany=="KR"){
		alert("[알림]구KR사업부는 사용이 불가능합니다.");
		return false;
	}		
	if (val_chk(pCompany, "사업부")) {
		var params = {company: pCompany};
		var objList = getAjaxList("/WAE035MonthlyShipmentCheckListSearch/ajaxSearch.do", params)
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
            {key: "pinbr", label: "모품번", width:150},          
            {key: "usrs1", label: "SEQ1", width:50},
            {key: "cinbr", label: "자품번", width:150},
            {key: "usrs2", label: "SEQ2", width:50},
            //{key: "edatm", label: "시작일(FR)"},
            {key: "edatm", label: "시작일(FR)", formatter: function(){
	            	var date = this.value;
	            	if(date !== null){
	            		if(date.length != 1) {
	            			var pDate=lpad(date, 6,'0');
		        			return pDate.substr(0, 2) + "/" + pDate.substr(2, 2) + "/" + pDate.substr(4);
		        		} else {
		        			return date;
		        		}
	            	}
	    		}
            },
            {key: "edato", label: "종료일(TO)", formatter: function(){
            	var date = this.value;
	            	if(date !== null){
	            		if(date.length != 1) {
	            			var pDate=lpad(date, 6,'0');
		        			return pDate.substr(0, 2) + "/" + pDate.substr(2, 2) + "/" + pDate.substr(4);
		        		} else {
		        			return date;
		        		}
	            	}
	    		}
	        },
            {key: "mdate", label: "수정일", formatter: function(){
	            	var date = this.value;
	            	if(date !== null){
	            		if(date.length != 1) {
	            			var pDate=lpad(date, 6,'0');
		        			return pDate.substr(0, 2) + "/" + pDate.substr(2, 2) + "/" + pDate.substr(4);
		        		} else {
		        			return date;
		        		}
	            	}
	    		}
	        },
            {key: "qtypr", label: "양", formatter: "money", align: "right"},
            {key: "unmsr", label: "단위"}
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
		unitGrid.exportExcel("적상체크리스트.xls");
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
    alert("[알림]구KE사업부 전용프로그램입니다.");
}) 

function lpad(str, padLen, padStr) {
    if (padStr.length > padLen) {
        console.log("오류 : 채우고자 하는 문자열이 요청 길이보다 큽니다");
        return str;
    }
    str += ""; // 문자로
    padStr += ""; // 문자로
    while (str.length < padLen)
        str = padStr + str;
    str = str.length >= padLen ? str.substring(0, padLen) : str;
    return str;
}
