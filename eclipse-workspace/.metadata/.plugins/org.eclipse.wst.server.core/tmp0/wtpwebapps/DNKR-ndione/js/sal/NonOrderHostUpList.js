
var title,
    titleKey;
    
function setList(listData) {
	var stTitle    = "";
    var stTitleKey = "";
    
    if(listData != ""){
   
    	for(var i=0; i<31; i++){
    		if(eval('listData[0].plndt' + i) != null) {
    			stTitle += eval('listData[0].plndt' + i) + ",";
    			stTitleKey += "basqy" + i + ",";
    		} 
    	}
    	
    	listTitleArr = stTitle.split(',');
    	listTitleKeyArr = stTitleKey.split(',');
    	for(var i=0 ; i<listTitleArr.length-1 ; i++){
    		listGrid.addColumn({key: listTitleKeyArr[i], label: listTitleArr[i], align: "center", width : 100});
    	}
    	
		listGrid.appendToList(listData);
    }
    else {
    	gridInit();
    }
}

/**
 * ======================================
 * [ko] 정보 검색하는 함수<br>
 * ======================================
 */
function search() {
	// 필수체크
	if(!$(".getComps").val()){
		toastMsg(LN_SELECT_COMPS);
		return false;
	}else if(!$(".getPyvnd").val()){
		toastMsg(LN_SELECT_PYVND);
		return false;
	}else if(!$(".getPlndt").val()){
		toastMsg(LN_SELECT_PLNYM);
		return false;
	}
	
	//조회구분에 따른 그리드 변경
	//기준일자 
	var getPlndt = $(".getPlndt").val().replace(/-/gi, "");
	
	//오늘날짜
	var date = new Date(); 
	var year = date.getFullYear(); 
	var month = new String(date.getMonth()+1); 
	var day = new String(date.getDate()); 

	// 한자리수일 경우 0을 채워준다. 
	if(month.length == 1){ 
	  month = "0" + month; 
	} 
	if(day.length == 1){ 
	  day = "0" + day; 
	} 
	var today = year + month + day;
	//alert(" today : " + today);

	// 취득할 데이터 타입   1: 전일조회 (기존양식 사용), 2: 당일조회,비서열 , 3:당일조회,확정오더
	var dataType = null;
	var typcd = $(":input:radio[name=getTypcd]:checked").val();
	var houseList = null;
	
	// 기준일자가 오늘보다 이전 날짜
	if (today > getPlndt) {
		//기존 양식 SQL
		dataType = '1';
		gridInit();
		
	}else {
				
		if (typcd == "BB") {
			//당일조회,비서열
			dataType = '2';
			
			// 창고코드
			if ($(".getComps").val() == 'E1') {
				houseList = "J,V,1";
			} else if ($(".getComps").val() == 'C1') {
				houseList = "W,V,1";
			} else if ($(".getComps").val() == 'S1') {
				houseList = "W,V,2";
			}
			
			gridInitBB();
		} else {
			//당일조회,확정오더
			dataType = '3';
			gridInitCC();
		}
	}

	//alert(" dataType : " + dataType);
	//gridInit();
	
	mask.open();
	$.ajax({
		method : "post",
		url : "/ajaxNonOrderHostUpList/search.do",
		data : {
			"getComps" : $(".getComps").val(),
			"getPyvnd" : $(".getPyvnd").val(),
			"getTypcd" : typcd,
			"getPlndt" : $(".getPlndt").val().replace(/-/gi, ""),
			"dataType" : dataType,
			"houseList" : houseList
		},
		success : function(res) {
			var data = JSON.parse(res);			

			if (data.list.length > 0) {
				setList(data.list);
				
				setTimeout(function() {
					mask.close();
				}, 500);
				
			} else {
				setList("");
				
				setTimeout(function() {
					mask.close();
					toastMsg(LN_NO_DATA);
				}, 500);
			}
		},
		error:function(request,status,error){
		    alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);

		},
		completed : function() {
			//console.log("dataset.completed");			
			setTimeout(function() {
				mask.close();				
			}, 500);
			
		}
	});
}


function gridDataInit(gridTarget) {
	gridTarget.setData({
		list : [],
		page : {
			currentPage : 0,
			pageSize : 50,
			totalElements : 500,
			totalPages : 100
		}						
	});
}


var listGrid; /* 기준일자 전일  */ 
function gridInit() {
	/* 기준일자 전일  -- 기존 */ 
	listGrid = new ax5.ui.grid({
	    target: $('[data-ax5grid="list-grid"]'),
	    //sortable: true,
	    columns: [
	    ]
	});
	listGrid.addColumn({key: "pyvnd", label: pyvndLabel, align: "center", width : 100});
	listGrid.addColumn({key: "cusnm", label: cusnmLabel, align: "center", width : 180});
	listGrid.addColumn({key: "faccd", label: faccdLabel, align: "center", width : 100});
	listGrid.addColumn({key: "yard", label: yardLabel, align: "center", width : 100});
	listGrid.addColumn({key: "shpto", label: "SHIP TO", align: "center", width : 100});
	listGrid.addColumn({key: "mkpno", label: mkpnoLabel, align: "center", width : 150,
		                formatter: function() {return this.value + "&nbsp;"}});	// 엑셀변환시 숫자형태로 변하는것 방지 ( 987003E000 -> 987003 (9.87E+05) )
	listGrid.addColumn({key: "pspno", label: pspnoLabel, align: "center", width : 150});
	listGrid.addColumn({key: "itdsc", label: itdscLabel, align: "center", width : 200});
	listGrid.addColumn({key: "outqy", label: outqyLabel, align: "center", width : 100});
	
}

function gridInitBB() {
	/* 기준일자 당일, 비서열 */
	listGrid = new ax5.ui.grid({
	    target: $('[data-ax5grid="list-grid"]'),
	    //sortable: true,
	    columns: [
	    ]
	});
	listGrid.addColumn({key: "pyvnd", label: pyvndLabel, align: "center", width : 100});
	listGrid.addColumn({key: "cusnm", label: cusnmLabel, align: "center", width : 180});
	listGrid.addColumn({key: "faccd", label: faccdLabel, align: "center", width : 100});
	listGrid.addColumn({key: "yard", label: yardLabel, align: "center", width : 100});
	listGrid.addColumn({key: "shpto", label: "SHIP TO", align: "center", width : 100});
	listGrid.addColumn({key: "mkpno", label: mkpnoLabel, align: "center", width : 150,
		                formatter: function() {return this.value + "&nbsp;"}});	// 엑셀변환시 숫자형태로 변하는것 방지 ( 987003E000 -> 987003 (9.87E+05) )
	listGrid.addColumn({key: "pspno", label: pspnoLabel, align: "center", width : 150});
	listGrid.addColumn({key: "itdsc", label: itdscLabel, align: "center", width : 200});
	listGrid.addColumn({key: "outqy", label: outqyLabel, align: "center", width : 100});
	
	// 창고코드
	if ($(".getComps").val() == 'E1') {
		listGrid.addColumn({key: "stock0", label: stocka2Label, align: "center", width : 100 });/*공장*/
		listGrid.addColumn({key: "stock1", label: stockb2Label, align: "center", width : 100 });/*창고1*/
		listGrid.addColumn({key: "stock2", label: stockc2Label, align: "center", width : 100 });/*창고2*/
	} else if ($(".getComps").val() == 'C1') {
		listGrid.addColumn({key: "stock0", label: stocka3Label, align: "center", width : 100 });/*공장*/
		listGrid.addColumn({key: "stock1", label: stockb3Label, align: "center", width : 100 });/*창고1*/
		listGrid.addColumn({key: "stock2", label: stockc3Label, align: "center", width : 100 });/*창고2*/
	} else if ($(".getComps").val() == 'S1') {
		listGrid.addColumn({key: "stock0", label: stocka4Label, align: "center", width : 100 });/*공장*/
		listGrid.addColumn({key: "stock1", label: stockb4Label, align: "center", width : 100 });/*창고1*/
		listGrid.addColumn({key: "stock2", label: stockc4Label, align: "center", width : 100 });/*창고2*/
	}
	
}

function gridInitCC() {	
	/* 기준일자 당일, 확정오더  */
	listGrid = new ax5.ui.grid({
	    target: $('[data-ax5grid="list-grid"]'),
	    //sortable: true,
	    columns: [
	    ]
	});
	listGrid.addColumn({key: "pyvnd", label: pyvndLabel, align: "center", width : 100});
	listGrid.addColumn({key: "cusnm", label: cusnmLabel, align: "center", width : 180});
	listGrid.addColumn({key: "faccd", label: faccdLabel, align: "center", width : 100});
	listGrid.addColumn({key: "yard", label: yardLabel, align: "center", width : 100});
	listGrid.addColumn({key: "shpto", label: "SHIP TO", align: "center", width : 100});
	listGrid.addColumn({key: "mkpno", label: mkpnoLabel, align: "center", width : 150,
		                formatter: function() {return this.value + "&nbsp;"}});	// 엑셀변환시 숫자형태로 변하는것 방지 ( 987003E000 -> 987003 (9.87E+05) )
	listGrid.addColumn({key: "pspno", label: pspnoLabel, align: "center", width : 150});
	listGrid.addColumn({key: "itdsc", label: itdscLabel, align: "center", width : 200});
	listGrid.addColumn({key: "outqy", label: outqyLabel, align: "center", width : 100});
	listGrid.addColumn({key: "lackcnt", label: lackcntLabel, align: "center", width : 100 });/*미납량*/
	listGrid.addColumn({key: "stock1", label: stockaLabel, align: "center", width : 100 });/*양산품재고수량*/
	listGrid.addColumn({key: "stock2", label: stockbLabel, align: "center", width : 100 });/*CKD재고수량*/
	listGrid.addColumn({key: "stock3", label: stockcLabel, align: "center", width : 100 });/*A/S재고수량*/
	
}



$(document.body).ready(function() {
	
	var plndt_calendar = new ax5.ui.calendar({
        target: document.getElementById("plndt_calendar"),
        control: {
            left: '<i class="fa fa-chevron-left"></i>',
            yearTmpl: '%s',
            monthTmpl: '%s',
            right: '<i class="fa fa-chevron-right"></i>',
            yearFirst: true
        },
        displayDate: (new Date()),
        dimensions: {
            height: 250,
            controlHeight: 40,
            itemPadding: 1
        },
        lang: {
        	/*yearTmpl: "%s년",*/
            /*months: ['일월', '이월', '삼월', '사월', '오월', '육월', '칠월', '팔월', '구월', '시월', '십일월', '십이월'],*/
        	yearTmpl: YEAR_FORMAT,
        	months: MONTH,
        	dayTmpl: "%s"
        },
        onClick: function () {
            $(this.target).css('display', 'none');
            $(this.target).prev().val(plndt_calendar.getSelection());            
        },
        onStateChanged: function () {
            //console.log(this);
        }
    });
	
	$('.log_board .dropdown').on('click', function(e){
		$($(e.target).next('.dropdown-menu')).css('display', 'block');
	});
	
	$('.getComps').on('change', function() {
		$(".getPyvnd").val("");
		$(".getCusnm").val("");
	});
	
	$('.getPyvnd').on('change', function() {
		$(".getCusnm").val("");
	});

	$('._custBtn_').on('click', function() {
		window.open("/ajaxCustomer/init.do","customerPop","width=550,height=600,scrollbars=yes,top=100,left=100");
	});
    
	gridInit();	
	setList("");
	 
	$('._excelBtn_').on('click', function() {
		listGrid.exportExcel("비서열/확정오더형 산출물.xls");
	});
});


/**
 * 업체코드로 업체명 검색하여 데이터 set
 * 
 * @param 업체코드
 */
function getCustSch() {
	if($('#getPyvnd').val() != ""){
		
		$.ajax({
			method : "post",
			url : "/ajaxCustomer/search.do",
			data : {
				"getCusno" : $("#getPyvnd").val(),
				"getComps" : $("#getComps").val()
			},
			success : function(res) {
				var data = JSON.parse(res);			
				
				if (data.list.length > 0) {
					$('#getCusnm').val(data.list[0].cusnm);
				}
				else {
					toastMsg(LN_IO_CHK1 + " : " + $("#getPyvnd").val());
					$("#getPyvnd").val("");					
					//$("#getCusnm").val("");
				}
			},
			error : function() {
				//console.log("dataset.error");
			},
			completed : function() {
				//console.log("dataset.completed");
			}
		});
	}
}

/**
 * 팝업창에서 값넘겨받아 부모창에 데이터 set
 * 
 * @param returnValue
 */
function getReturnValue(returnValue) {
	if(returnValue !== null) {
		var retObj = JSON.parse(returnValue);

		$('#getPyvnd').val(retObj.cusno);
		$('#getCusnm').val(retObj.cusnm);	
	}
}