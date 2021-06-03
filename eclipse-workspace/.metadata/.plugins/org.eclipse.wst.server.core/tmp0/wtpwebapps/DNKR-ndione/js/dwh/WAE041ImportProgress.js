var unitGrid;
var vnameMap = new HashMap();

var picker = new ax5.ui.picker();

(function() {
	mask.open();
})();

var pageingList;

function search() {

	var pLocCode = $('#pLocCode').val();	//사업부
	var pGubun = $('#pGubun').val();	//구분
	var pStartDate = $('#startDate').val();	//기준일자(From)
		//pStartDate = pStartDate.replaceAll('-','');	//IE에서 replaceAll사용불가
		pStartDate = pStartDate.replace(/-/gi, "");	//IE에서 정규식을 사용해야함.
	var pEndDate = $('#endDate').val();	//기준일자(To)
		pEndDate = pEndDate.replace(/-/gi, "");
	var pOrder = $('#pOrder').val();	//오더번호
	if (val_chk(pLocCode, "사업부")) {
		if(pGubun=='X'){
			if (val_chk(pOrder, "오더번호")) {
				var params = {locCode: pLocCode, pGubun: pGubun, startDate: pStartDate, endDate: pEndDate, pOrder: pOrder};
				var objList = getAjaxList("/WAE041ImportProgressSearch/ajaxSearch.do", params)
			}
	    }else{
	    	if (val_chk(pStartDate, "기준일자(From)")) {
				if (val_chk(pEndDate, "기준일자(To)")) {
					var checkPeriod = getDiffernceDate();
					if(checkPeriod > 729){	//364
						alert("[알림]2년이상의 DATA는 조회가 불가능합니다.");
						return false;
					}
					var params = {locCode: pLocCode, pGubun: pGubun, startDate: pStartDate, endDate: pEndDate, pOrder: pOrder};
					var objList = getAjaxList("/WAE041ImportProgressSearch/ajaxSearch.do", params)
				}
			}
	    }
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
	
	//페이징추가시
	//pageingList= objList.list;
	//searchPaging(1);
		
	//페이징추가시
	$('span.total').text(objList.list.length);
}


function searchPaging(_pageNo) {
	
	unitGrid.setData({
	    list: pageingList,
	    page: {
	        currentPage: _pageNo || 0,
	        pageSize: 50,
	        totalElements: 500,
	        totalPages: 100
	    }
	});
}


//=== grid =================================================
function createGrid(){
	unitGrid = new ax5.ui.grid({
        target: $('[data-ax5grid="unit-grid"]'),
        //showLineNumber: false, showRowSelector: true, multipleSelect: false, virtualScrollY: false, lineNumberColumnWidth: 40, rowSelectorColumnWidth: 27,
        header: {
            align: "center",
        },
        body: {
        	align: "center",
        	onClick : function() {
					this.self.clearSelect();
					this.self.select(this.dindex);
			},
        },
        /*
        page: {
            navigationItemCount: 9,
            height: 30,
            display: true,
            firstIcon: '<i class="fa fa-step-backward" aria-hidden="true"></i>',
            prevIcon: '<i class="fa fa-caret-left" aria-hidden="true"></i>',
            nextIcon: '<i class="fa fa-caret-right" aria-hidden="true"></i>',
            lastIcon: '<i class="fa fa-step-forward" aria-hidden="true"></i>',
            onChange: function () {
                gridView.setData(this.page.selectPage);
            }
		},
		*/
        /*
		 page: {
	            navigationItemCount: 9,
	            height: 30,
	            display: true,
	            firstIcon: '|<',
	            prevIcon: '<',
	            nextIcon: '>',
	            lastIcon: '>|',
	            onChange: function () {
	            	searchPaging(this.page.selectPage);
	            }
	     },
	     */
        columns: [
        	{key: "ordym", label: "오더년월", width:60},
        	{
                key: undefined, label: "메인화면", columns: [
                    {key: "order", label: "오더번호"},
                    {key: "expno", label: "수입품번"},
                    {key: "ccord", label: "CIGMA Ord"},
/*                    {key: "opndt", label: "<span style='display:inline-block;line-height: 14px;vertical-align: middle;colspan: 2'>개설</span>"},
*/                    

                    {key: "opndt", label: "개설"},
                    {key: "orseq", label: "일련", width:40},
                    {key: "ptdat", label: "도착", width:70},
                    {key: "ftadts", label: "결제", width:70},
                    {key: "toadt", label: "통관", width:70},
                    {key: "saseq", label: "분할", width:40},
                    {key: "ipdat", label: "사입", width:70}
                    /*
                    {key: "ipdat", label: "사입일", width:70,
	                     formatter: function(){
	    	            	var dateChg = this.value;
	    	            	if(dateChg !== null){
	    	            		if(dateChg.length != 1) {
	    	            			var pDate=lpad(dateChg, 6,'0');
	    		        			return pDate.substr(0, 4) + "/" + pDate.substr(2, 2) + "/" + pDate.substr(4);
	    		        		} else {
	    		        			return dateChg;
	    		        		}
	    	            	}
	    	    		}
                    }
                    */
                ]
            },
            {
                key: undefined, label: "발주내역", columns: [
                    {key: "orderx", label: "오더번호"},
                    {key: "ordgu", label: "①", width:30},
                    {key: "oresr", label: "②", width:30},
                    {key: "orfl1", label: "③", width:30},
                    {key: "ccordx", label: "CIGMA ORD"},
                    {key: "prvnd", label: "VENDOR", width:60},
                    {key: "prvnm", label: "VENDOR명", width:100},
                    {key: "ordat", label: "DATE", width:70},
                    {key: "expnox", label: "수입품번"},
                    {key: "exdsc", label: "품명", width:180, align: "left"},
                    {key: "orcstx", label: "발주단가", formatter: "money", align: "right"},
                    //{key: "orcstx", label: "발주단가", formatter: function() {return ax5.util.number(this.item.orcstx, {"money": 1});}, align: "right"},
                    {key: "oruntx", label: "화폐", width:40},
                    {key: "orqtyx", label: "수량", formatter: "money", align: "right"},
                    //{key: "orqtyx", label: "수량", formatter: function() {return ax5.util.number(this.item.orqtyx, {"money": 1});}, align: "right"},
                    {key: "exuntx", label: "단위", width:40},
                    {key: "bamttt", label: "발주금액", formatter: "money", align: "right"},
                    //{key: "bamttt", label: "발주금액", formatter: function() {return ax5.util.number(this.item.bamttt, {"money": 1});}, align: "right"},
                    {key: "orcob", label: "Remarks", width:120, align: "left"}
                ]
            },
            {
                key: undefined, label: "발주조건", columns: [
                    {key: "orreq", label: "ReqPr", width:45},
                    {key: "orreqm", label: "ReqPr명", align: "left"},
                    {key: "dudatx", label: "DlySc"},
                    {key: "orshp", label: "DesTo", width:45},
                    {key: "orshpm", label: "DesTo명", width:180, align: "left"},
                    {key: "ortem", label: "Paytm", width:45},
                    {key: "ortemm", label: "Paytm명", width:180, align: "left"},
                    {key: "orcss", label: "Price", width:45},
                    {key: "orcssm", label: "Price명", width:50},
                    {key: "orpot", label: "Shppt"},
                    {key: "orpotm", label: "Shppt명", width:180, align: "left"},
                    {key: "orapp", label: "Payct", width:45},
                    {key: "orappm", label: "Payct명", align: "left"},
                    {key: "carnm", label: "Descr"},
                    {key: "ororg", label: "원산지", width:50},
                    {key: "ororgm", label: "원산지명", align: "left"}
                ]
            },
            {
                key: undefined, label: "개설내역", columns: [
                    {key: "bnkcd5", label: "은행코드", width:60},
                    {key: "bnknm", label: "개설은행"},
                    {key: "opndtx", label: "개설일자", width:70},
                    {key: "locno", label: "LC번호", width:120},
                    {key: "clottt", label: "개설비용", formatter: "money", align: "right"}
                ]
            },
            {
                key: undefined, label: "도착내역", columns: [
                    {key: "pblno1", label: "BL번호", width:120},
                    {key: "orseq1", label: "일련번호", width:60},
                    {key: "ptqty1", label: "도착수량", formatter: "money", align: "right"},
                    {key: "ptdat1", label: "도착일자"},
                    {key: "docst1", label: "도착단가", formatter: "money", align: "right"},
                    {key: "dount1", label: "화폐", width:40},
                    {key: "shpdt1", label: "선적일자", width:70},
                    {key: "doattt", label: "도착금액", formatter: "money", align: "right"}
                ]
            },
            {
                key: undefined, label: "결제내역", columns: [
                    {key: "ftadtx", label: "결제일자", width:70},
                    {key: "ftacdx", label: "결제내역", width:60},
                    {key: "ftanm", label: "내역1", width:50},
                    {key: "lcnam", label: "내역2", width:50},
                    {key: "ftattt", label: "결제총액", formatter: "money", align: "right"}
                ]
            },
            {
                key: undefined, label: "사입내역", columns: [
                    {key: "ipdat2", label: "사입일자", width:70},
                    {key: "sagub", label: "사입구분", width:60},
                    {key: "sagnm", label: "구분명", width:60},
                    {key: "saseq2", label: "차수", width:60},
                    {key: "isqty", label: "사입수량", formatter: "money", align: "right"}
                ]
            },
            {
                key: undefined, label: "통관내역", columns: [
                	 {key: "togcd", label: "지불처", width:50},
                     {key: "tognm", label: "지불처명"},
                     {key: "togdt", label: "통관일자", width:70},
                     {key: "totttt", label: "통관총액", formatter: "money", align: "right"}
                ]
            }
            /*
			{key: "order", label: "오더번호"},
            {key: "expno", label: "수입품번"},
            {key: "ccord", label: "CGMA"},
            {key: "opndt", label: "개설"},
            {key: "orseq", label: ""},
            {key: "ptdat", label: "도착"},
            {key: "ftadts", label: "결제"},
            {key: "toadt", label: "통관"},
            {key: "saseq", label: ""},
            {key: "ipdat", label: "사입일"},
            {key: "orderx", label: "오더번호"},
            {key: "ordgu", label: ""},
            {key: "oresr", label: ""},
            {key: "orfl1", label: ""},
            {key: "ccordx", label: "CIGMA ORD"},
            {key: "prvnd", label: "VENDOR"},
            {key: "prvnm", label: ""},
            {key: "ordat", label: "DATE"},
            {key: "expnox", label: "수입품번"},
            {key: "exdsc", label: "품명"},
            {key: "orcstx", label: "발주단가"},
            {key: "oruntx", label: ""},
            {key: "orqtyx", label: "수량"},
            {key: "exuntx", label: ""},
            {key: "bamttt", label: "발주금액"},
            {key: "orcob", label: "Remarks"},
            {key: "orreq", label: "ReqPr"},
            {key: "orreqm", label: ""},
            {key: "dudatx", label: "DlySc"},
            {key: "orshp", label: "DesTo"},
            {key: "orshpm", label: ""},
            {key: "ortem", label: "Paytm"},
            {key: "ortemm", label: ""},
            {key: "orcss", label: "Price"},
            {key: "orcssm", label: ""},
            {key: "orpot", label: "Shppt"},
            {key: "orpotm", label: ""},
            {key: "orapp", label: "Payct"},
            {key: "orappm", label: ""},
            {key: "carnm", label: "Descr"},
            {key: "ororg", label: ""},
            {key: "ororgm", label: ""},
            {key: "bnkcd5", label: "은행코드"},
            {key: "bnknm", label: "개설은행"},
            {key: "opndtx", label: "개설일자"},
            {key: "locno", label: "LC번호"},
            {key: "clottt", label: "개설비용"},
            {key: "pblno1", label: "BL번호"},
            {key: "orseq1", label: "일련번호"},
            {key: "ptqty1", label: "도착수량"},
            {key: "ptdat1", label: "도착일자"},
            {key: "docst1", label: "도착단가"},
            {key: "dount1", label: ""},
            {key: "shpdt1", label: "선적일자"},
            {key: "doattt", label: "도착금액"},
            {key: "ftadtx", label: "결제일자"},
            {key: "ftacdx", label: "결제내역"},
            {key: "ftanm", label: ""},
            {key: "lcnam", label: ""},
            {key: "ftattt", label: "결제총액"},
            {key: "ipdat2", label: "사입일자"},
            {key: "sagub", label: "사입구분"},
            {key: "sagnm", label: ""},
            {key: "saseq2", label: "사입수량"},
            {key: "isqty", label: ""},
            {key: "togcd", label: "지불처"},
            {key: "togdt", label: "통관일자"},
            {key: "tognm", label: ""},
            {key: "totttt", label: "통관총액", formatter: "money", align: "right"}
             */
        ]
	});
	

}
function commonClear(){
	createGrid();
	$('span.total').text("");
}

//구분항목 변경시 기준일자 활성화
function changeDate(){
	createGrid();
	if($('#pGubun').val()=='X'){
    	$('#startDate').val('');
    	$('#startDate').attr("disabled",true);
    	$('#endDate').val('');
    	$('#endDate').attr("disabled",true);
    }else{
    	$('#startDate').attr("disabled",false);
    	$('#endDate').attr("disabled",false);
    	
    	
    	var todayOrg = new Date();   	
    	if($('#pGubun').val()=='Z'){
    		/*
    		var month = todayOrg.getUTCMonth() + 1; //months from 1-12
    		var year = todayOrg.getUTCFullYear();
    		var getMonDay = new Date(year, month);
    		//var dayFirst = getTodayType(new Date(getMonDay +1 ));
        	//var dayLast = getTodayType(new Date(getMonDay - 1 ));
			*/
    		var dayFirst = getTodayType(new Date(todayOrg.getUTCFullYear(), todayOrg.getUTCMonth(), 2));
        	var dayLast = getTodayType(new Date(todayOrg.getUTCFullYear(), todayOrg.getUTCMonth()+1, 0));
    		$('#startDate').val(dayFirst);
    		$('#endDate').val(dayLast);
    		
        }else{
        	//날짜 기본셋팅
        	var today = getTodayType(todayOrg);

        	if($('#startDate').val()==''){
        		$('#startDate').val(today);
        	}
        	if($('#endDate').val()==''){
        		$('#endDate').val(today);
        	}
        }
    	$('#pOrder').val('');	//오더번호 초기화
    }
}

//현재일자 가져오기
function getTodayType(todayOrg){
	var today = todayOrg;
	var month = today.getUTCMonth() + 1; //months from 1-12
	var day = today.getUTCDate();
	var year = today.getUTCFullYear();

	//today = year + "-" + month + "-" + lpad(day, 2,'0');
	today = year + "-" + lpad(month, 2,'0') + "-" + lpad(day, 2,'0');
	return today;
	
}
//날짜 차이계산
function getDiffernceDate(){
	
	var strDate1 = $('#startDate').val();	//기준일자(From)
	var strDate2 = $('#endDate').val();	//기준일자(To)
	
	var arrStrDate1 = strDate1.split('-');
	var arrStrDate2 = strDate2.split('-');
	
	var checkDate1 = new Date(arrStrDate1[0], arrStrDate1[1], arrStrDate1[2]);
	var checkDate2 = new Date(arrStrDate2[0], arrStrDate2[1], arrStrDate2[2]);

	var checkDate = (checkDate2 - checkDate1) / (1000*60*60*24);
	
	return checkDate;
}

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

$(document).ready(function() {
	mask.close();
//	=== grid =================================================
	createGrid();

	$('._searchBtn_').on('click', function() {
		search();
		return false;
	});	
	
	$('.exel').on('click', function() {
		unitGrid.exportExcel("수입품 진도관리 조회.xls");
	});
//	=== //grid =================================================
    
	
	$('[data-ax5formatter]').ax5formatter();
	 // Select Month
    picker.bind({
        target: $('[data-picker-date="date1"]'),
        content: {
            type: 'date',
            config: {
                mode: "day", selectMode: "day",
                control: {
                         yearTmpl: '%s',
                         monthTmpl: '%s',
                         yearFirst: true
                	},
                lang: {
                     	yearTmpl: "%s년",
                         months: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
                     	dayTmpl: "%s"
                     },
                marker: (function () {
                         var marker = {};
                         marker[ax5.util.date(new Date(), {'return': 'yyyy-MM-dd', 'add': {d: 0}})] = true;
                         return marker;
                     })()
            },
            formatter: {
                pattern: 'date(day)'
            }
        }
    });
    
    picker.bind({
        target: $('[data-picker-date="date2"]'),
        content: {
            type: 'date',
            config: {
                mode: "day", selectMode: "day",
                control: {
                         yearTmpl: '%s',
                         monthTmpl: '%s',
                         yearFirst: true
                	},
                lang: {
                     	yearTmpl: "%s년",
                         months: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
                     	dayTmpl: "%s"
                     },
                marker: (function () {
                         var marker = {};
                         marker[ax5.util.date(new Date(), {'return': 'yyyy-MM-dd', 'add': {d: 0}})] = true;
                         return marker;
                     })()
            },
            formatter: {
                pattern: 'date(day)'
            },
        }
    });
    
    if($('#pGubun').val()=='X'){
    	$('#startDate').val('');
    	$('#startDate').attr("disabled",true);
    	$('#endDate').val('');
    	$('#endDate').attr("disabled",true);
    }
    //$('#pOrder').val('PF2-382');
}) 
