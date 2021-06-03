
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

	var typcd = $(":input:radio[name=getTypcd]:checked").val();
	
	gridInit();
	mask.open();
	$.ajax({
		method : "post",
		url : "/ajaxNonOrderHostUpList/search.do",
		data : {
			"getComps" : $(".getComps").val(),
			"getPyvnd" : $(".getPyvnd").val(),
			"getTypcd" : typcd,
			"getPlndt" : $(".getPlndt").val().replace(/-/gi, "")
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
		error : function() {
			//console.log("dataset.error");
		},
		completed : function() {
			//console.log("dataset.completed");			
			setTimeout(function() {
				mask.close();				
			}, 500);
			
		}
	});
}

var listGrid;

function gridInit() {
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