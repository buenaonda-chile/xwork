var unitGrid;
var vnameMap = new HashMap();

var picker = new ax5.ui.picker();

(function() {
	mask.open();
})();

function search() {
	//113091   2013-04-01
	var pLocCode = $('#locCode').val();	//사업부
	var pStartDate = $('#startDate').val();	//기준녕월
	var pEndDate = $('#endDate').val();	//기준년월
	var pGlobj = $('#pGlobj').val();	//계정과목1
	var pGlobj2 = $('#pGlobj2').val();	//계정과목2
	
	if($("input[name=systemType]").is(":checked")) {
		if($("#locCode").val()=="LOC000000"){
			alert("[알림]'구환경'체크시 '공장구분'의 통합은 사용불가능합니다.");
			return;
		}
	}
	
	if (val_chk(pStartDate, "시작년월")) {
		if (val_chk(pEndDate, "종료년월")) {
			var pRltStartDate = calculation(pStartDate, "S");
			var pRltEndDate = calculation(pEndDate, "E");

			var params = {locCode:pLocCode, pStartDate: pRltStartDate, pEndDate: pRltEndDate, pGlobj: pGlobj, pGlobj2: pGlobj2};
			var objList = getAjaxList("/WAE039AccountingJournalSearch/ajaxSearch.do", params)
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
				if(parse.rltmsg === 'NG'){
					toastMsg('조회건수가 '+parse.rltCnt +'건으로 65,000건을 초과하여 조회가 불가능합니다.');
    			}
				else {
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
    	  /* 순서변경 - 2019.07.16
          {key: "glicu", label: "BATCH NUM", width:80},          
          {key: "gldgj", label: "회계일자(연속)", width:80},
          {key: "gldate", label: "회계일자"},
          {key: "glicut", label: "BT", width:50},
          {key: "gljeln", label: "JELINENUM", width:80},

          {key: "mcdc", label: "BUSINESS UNIT명", width:150},
          {key: "glmcu", label: "BUSINESS UNIT"},
          {key: "globj", label: "계정코드", width:80},

          {key: "glsub", label: "Subsidiary", width:70},
          {key: "glsbl", label: "Subledger", width:70},
          {key: "glasid", label: "자산ID", width:70},
          {key: "glsblt", label: "Subledger Type"},
          
          {key: "drdlCat", label: "범주코드12"},
                    
          {key: "gmdl01", label: "계정항목", width:150, align: "left"},
          {key: "glexr", label: "적요", width:150, align: "left"},
          {key: "glexa", label: "업체명", width:200, align: "left"},
          {key: "gldoc", label: "전표번호", width:80},
          
          {key: "gldct", label: "DT", width:50},
          {key: "gmdl02", label: "계정절", width:200},
          {key: "glr2", label: "Address Number"},
          {key: "abtax", label: "사업자등록번호"},
          {key: "glaa", label: "금액", formatter: "money", align: "right"},
          {key: "glaa01", label: "차변금액", formatter: "money", align: "right"},
          {key: "glaa02", label: "대변금액", formatter: "money", align: "right"},

          {key: "icuser", label: "최초전표 작성자"},
          {key: "gldicj", label: "최초전표 작성일자"}
          
          //{key: "gltorg", label: "최초전표 작성자"},
          //{key: "gluser", label: "User ID", width:80},
          //{key: "glupDate", label: "최초 작성일자"}      
          */ 
          {key: "gldate", label: "회계일자"},
          {key: "gldct", label: "DT", width:50},
          {key: "glicut", label: "BT", width:50},
    	  {key: "glicu", label: "BATCH NUM", width:80},          
          {key: "gldoc", label: "전표번호", width:80},

          {key: "glmcu", label: "BUSINESS UNIT"},
          {key: "globj", label: "계정코드", width:80},
          {key: "glsub", label: "Subsidiary", width:70},
          {key: "gmdl01", label: "계정항목", width:150, align: "left"},
          /*
          {key: "glan8", label: "거래처코드", width:80, formatter: function(){
		          	var cusno = this.value;
		        	if(cusno !== null){
		        		if(cusno.length != 1) {
		        			var pCusno=lpad(cusno, 6,'0');
		        			return pCusno;
		        		} else {
		        			return cusno;
		        		}
		        	}
				}
		    },*/
          {key: "glan8", label: "거래처코드", width:80},
          {key: "abalph", label: "거래처명", width:150, align: "left"},

          {key: "glaa", label: "금액", formatter: "money", align: "right"},
          {key: "glaa01", label: "차변금액", formatter: "money", align: "right"},
          {key: "glaa02", label: "대변금액", formatter: "money", align: "right"},         
          {key: "glexr", label: "적요", width:150, align: "left"},
                   
          {key: "mcdc", label: "BUSINESS UNIT명", width:150},
          {key: "gmdl02", label: "계정절", width:200},
          {key: "glr2", label: "Address Number"},
          {key: "glexa", label: "업체명", width:200, align: "left"},
          
          {key: "glsbl", label: "Subledger", width:70},
          {key: "glasid", label: "자산ID", width:70},
          {key: "glsblt", label: "Subledger Type"},
          {key: "drdlCat", label: "범주코드12"},
          {key: "abtax", label: "사업자등록번호"},

          {key: "icuser", label: "최초전표 작성자"},
          {key: "gldicj", label: "최초전표 작성일자"},
          {key: "gldgj", label: "회계일자(연속)", width:80},
          {key: "gljeln", label: "JELINENUM", width:80}
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
		unitGrid.exportExcel("JDE분개장.xls");
	});
//	=== //grid =================================================
    
	
	$('[data-ax5formatter]').ax5formatter();
	 // Select Month
	// Date-year
	picker.bind({
		target: $('[data-ax5picker="basic"]'),
        direction: "top",
        content: {
            width: 270,
            margin: 10,
            type: 'date',
            config: {
            	mode: "year", selectMode: "month",
                control: {
                    left: '<i class="fa fa-chevron-left"></i>',
                    yearTmpl: '%s',
                    monthTmpl: '%s',
                    right: '<i class="fa fa-chevron-right"></i>'
                },
                lang: {
                    yearTmpl: "%s년",
                    months: ['01월', '02월', '03월', '04월', '05월', '06월', '07월', '08월', '09월', '10월', '11월', '12월'],
                    dayTmpl: "%s"
                }
            }
        },
    });

	$('#locCode').on('change',function(obj){
		createGrid();
		$('span.total').text("");
		
		$.ajax({
			url: "/WAE039AccountingJournalSearch/ajaxCodeSearch.do",
			method : "POST",
			data : {locCode: this.value},
			success : function (res){
				//console.log(res);
				var data = JSON.parse(res);
				if (data.list.length > 0) {
					//console.log("정상");
					//조회 select 외의 데이터 초기화
					$("select[name='pGlobj'] option").remove();  
					$("#pGlobj").append('<option value="0">전체</option>');
					data.list.forEach(function(item, index){
						$("#pGlobj").append( '<option value="'+ item.gmobj +'">'+item.gmobjName+'</option>');
					});
					$("select[name='pGlobj2'] option").remove();  
					$("#pGlobj2").append('<option value="99999">전체</option>');
					data.list.forEach(function(item, index){
						$("#pGlobj2").append( '<option value="'+ item.gmobj +'">'+item.gmobjName+'</option>');
					});
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
	});	
})

//JDE회계일자 줄리안변환(년월일)
function calculation(pDate, flag){
	var sParamSplit = pDate.replace( /-/gi, '');	//정규식변환
	var rltDate = dateToJulianNumber(sParamSplit, flag);	//줄리안DATE 변환
	return rltDate;
}
//JDE회계일자 줄리안변환(년월일)줄리안 DATE변환
function dateToJulianNumber(pJNum, flag) {
	var rltDate="";
    var yyyy = parseInt(pJNum.substr(0,4)) - 1900;	//줄리안계산(년도)
    var yy = pJNum.substr(0,4);
    var mm = pJNum.substr(4,2);
    if(flag=="S"){	//시작일은 전월 day를 구하고 +1을 한다.
    	mm = parseInt(mm)-1;
    }
    var max_days=0;
    for (var i=1; i <=mm; i++){
    	if(i == 1) {
    		max_days = parseInt(max_days) + 31;
    	} else if(i == 2) {
    		if ((( yy % 4 == 0) && (yy % 100 != 0)) || (yy % 400 == 0)){
    			max_days = parseInt(max_days) + 29;
    		}else{
    			max_days = parseInt(max_days) + 28;
    		}
    	}
    	else if (i == 3){ max_days += 31;}
    	else if (i == 4){ max_days += 30;}
    	else if (i == 5){ max_days += 31;}
    	else if (i == 6){ max_days += 30;}
    	else if (i == 7){ max_days += 31;}
    	else if (i == 8){ max_days += 31;}
    	else if (i == 9){ max_days += 30;}
    	else if (i == 10){ max_days += 31;}
    	else if (i == 11){ max_days += 30;}
    	else if (i == 12){ max_days += 31;}
    	
    }
    if(flag=="S"){	//종료월인 경우 마지막일을 구한다.
    	max_days += 1;
    }
    rltDate=yyyy+""+lpad(max_days.toString(),3,"0");
    return rltDate;
}
//LPAD
function lpad(val, padLength, padString){
    while(val.length < padLength){
        val = padString + val;
    }
    return val;
}

//공장코드 활성화여부
function changeLocde(obj){
	if($("input[name="+obj.name+"]").is(":checked")) {
		$("#locCode").attr("disabled",false);
	}else{
		$("#locCode").attr("disabled",true);
		$("#locCode").val("LOC000000").attr("selected", "selected");
		$("#locCode").trigger("change");
	}
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


/* 미사용
//JDE회계일자 줄리안변환(년월일)
function calculation(pDate, flag){
	var sParamSplit = 	pDate.replace( /-/gi, '');	//정규식변환
	if(flag=="E"){	//종료월인 경우 마지막일을 구한다.
		//alert( sParamSplit.substr(0,4)+"=="+sParamSplit.substr(4,2));
		var endDay = getEndOfMonthDay(sParamSplit.substr(0,4), sParamSplit.substr(4,2));
		sParamSplit = sParamSplit+""+endDay;
	}else{
		sParamSplit = sParamSplit+"01";
		
	}
	//alert(sParamSplit);
	//var aaa = getDateType(sParamSplit); //DATE 형변환
	//var rltDate = dateToJulianNumber(aaa);	//줄리안DATE 변환
	
	return;
}

//문자->DATA 형변환
function getDateType(pDate){
	var secDate= pDate;  /// 문자열 or  숫자 데이터
	var year = secDate.substr(0,4);
	var month = secDate.substr(4,2);
	var day = secDate.substr(6,2);
	var date = new Date(year, month, day);  // date로 변경	
	return date;
}
//해당월의 마지막일 가져오기
function  getEndOfMonthDay(yy, mm)
{
	var max_days=0;
	if(mm == 1) {
		max_days = 31 ;
	} else if(mm == 2) {
		if ((( yy % 4 == 0) && (yy % 100 != 0)) || (yy % 400 == 0))
			max_days = 29;
		else
			max_days = 28;
	}
	else if (mm == 3)   max_days = 31;
	else if (mm == 4)   max_days = 30;
	else if (mm == 5)   max_days = 31;
	else if (mm == 6)   max_days = 30;
	else if (mm == 7)   max_days = 31;
	else if (mm == 8)   max_days = 31;
	else if (mm == 9)   max_days = 30;
	else if (mm == 10)  max_days = 31;
	else if (mm == 11)  max_days = 30;
	else if (mm == 12)  max_days = 31;
	else return '';
	return max_days;
}
//줄리안 DATE변환 - 미사용
function dateToJulianNumber(d) {
    var x = Math.floor((14 - d.getMonth())/12);
    var y = d.getFullYear() + 4800 - x;
    var z = d.getMonth() - 3 + 12 * x;
    var n = d.getDate() + Math.floor(((153 * z) + 2)/5) + (365 * y) + Math.floor(y/4) + Math.floor(y/400) - Math.floor(y/100) - 32045;
    return n;
} 

//JDE회계년도 계산(년월일) - 미사용
function calculationEx(pDate){
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
	alert(rDt[0]+"==="+rDt[1]);
	return rDt;
}

*/
