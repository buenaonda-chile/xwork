var picker = new ax5.ui.picker();
var firstGrid;

$(document.body).ready(function () {
	$('[data-ax5formatter]').ax5formatter();
	 
	//Date
	picker.bind({
        target: $('[data-ax5picker="basic"]'),
        direction: "top",
        content: {
            width: 270,
            margin: 10,
            type: 'date',
            config: {
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
        onStateChanged: function () {

        }
    });
	
	//Grid
    firstGrid = new ax5.ui.grid({
        target: $('[data-ax5grid="first-grid"]'),
        columns: [
            {key: "JISNO", width: 100, label: "지시No", align: "center"},
            {key: "HYONM", width: 200, label: "현상", align: "center", columns: [ 
								{key: "JOBNM", align: "center", label: "방법"},
								{key: "CHONM", align: "center", label: "처치"}]
            },
            {key: "CAUSE", label: "원인", width: 200, align: "center", columns: [ 
								{key: "TOTHR", align: "center", label: "총공수"},
								{key: "STPHR", align: "center", label: "정지시간"}]
            },
            {key: "WNDAT", label: "완료일", width: 200, align: "center", columns: [ 
								{key: "TRUNM", width: 200, align: "center", label: "실원인"}]     
        	} ,
			{key: "", label: "-", width: 300, align: "center", columns: [ 
								{key: "ASSNM", align: "center", label: "대분류"},
								{key: "CPART", align: "center", label: "셋트부품"},
								{key: "DPART", align: "center", label: "분해불가"}]
        	}
             
        ]  
        
    });
   
    //firstGrid.setData(gridList);
  
    });
    
    function searchData(){
    	
    	var params = $("#searchForm").serialize();
	
	//getGridVal, TextVal
	$.ajax({
		type    : "POST",
		//contentType : "application/json",
		url     : "/WAF003PsogmPerSearch/getGridVal.do",
		data    : params,
		//dataType : "json",
		success : function (data){
			try{
    			var parse = JSON.parse(data);
    			if(parse.result=="y"){	    			
	    			//alert(parse.text.SUM_JANHR);
	    			$("#txtttcnt").val(parseFloat(parse.text.CNT_PM)+parseFloat(parse.text.CNT_BM)+parseFloat(parse.text.CNT_CM));
	    			$("#txttthr").val(parseFloat(parse.text.SUM_PM)+parseFloat(parse.text.SUM_BM)+parseFloat(parse.text.SUM_CM));
	    			$("#txttcost").val(parseFloat(parse.text.SUM_PCOST)+parseFloat(parse.text.SUM_SCOST)+parseFloat(parseFloat($("#txttthr").val()) * 30));
	    			$("#txtstcost").val(parseFloat(parse.text.SUM_STPHR) * 200 + parseFloat($("#lblhrcost").val()));
	    			$("#lblpmcnt").val(parse.text.CNT_PM);
	    			$("#lblpmhr").val(parse.text.SUM_PM);
	    			$("#lblpcost").val(parse.text.SUM_PCOST);
	    			$("#lblstphr").val(parse.text.SUM_STPHR);
	    			$("#lblbmcnt").val(parse.text.CNT_BM);
	    			$("#lblbmhr").val(parse.text.SUM_BM);
	    			$("#lblscost").val(parse.text.SUM_SCOST);
	    			$("#lbljanhr").val(parse.text.SUM_JANHR);
	    			$("#lblcmcnt").val(parse.text.CNT_CM);
	    			$("#lblcmhr").val(parse.text.SUM_CM);
	    			$("#lblhrcost").val(parseFloat($("#txttthr").val()) * 30);
	    			$("#lbljacost").val($("#lblhrcost").val());
	    			/*
	    			CNT_PM=0, SUM_PM=0.0, CNT_BM=0, CNT_CM=0, SUM_CM=0.0, SUM_BM=0.0, SUM_STPHR=0.0, SUM_JANHR=0.0, SUM_SCOST=0, SUM_PCOST=0
	    			-lblpmcnt.Text = ds_ogm312_textVal.cnt_pm;
	    			-lblbmcnt.Text = ds_ogm312_textVal.cnt_bm;
	    			-lblcmcnt.Text = ds_ogm312_textVal.cnt_cm;
	    			-txtttcnt.Text = parseFloat(lblpmcnt.Text)+parseFloat(lblbmcnt.Text)+parseFloat(lblcmcnt.Text);
	    			-lblpmhr.Text = ds_ogm312_textVal.sum_pm;
	    			-lblbmhr.Text = ds_ogm312_textVal.sum_bm;;
	    			-lblcmhr.Text = ds_ogm312_textVal.sum_cm;
	    			-txttthr.Text = parseFloat(lblpmhr.Text)+parseFloat(lblbmhr.Text)+parseFloat(lblcmhr.Text);
	    			-lblpcost.Text = ds_ogm312_textVal.sum_pcost;
	    			-lblscost.Text = ds_ogm312_textVal.sum_scost;
	    			-lblhrcost.Text = parseFloat(txttthr.Text) * 30;
	    			-txtttcost.Text = parseFloat(lblpcost.Text)+parseFloat(lblscost.Text)+parseFloat(lblhrcost.Text);
	    			-lblstphr.Text = ds_ogm312_textVal.sum_stphr;
	    			-lbljanhr.Text = ds_ogm312_textVal.sum_janhr;
	    			-lbljacost.Text = lblhrcost.Text;
	    			txtstcost.Text = parseFloat(lblstphr.Text) * 200 + parseFloat(lbljacost.Text);
	    			*/
	    			////console.log(parse.list);
	    			firstGrid.setData(parse.list);
    			}else{
    				toastMsg('조회된 데이터가 없습니다.');
    				document.gridForm.reset();
    				firstGrid.setData([]);
    			}
			}catch(e){
				console.log(e);
			}
		},
		error   : function(x,e){
			ajaxError(x,e);
		}
	});
	
	$('._excelBtn_').on('click', function() {
		firstGrid.exportExcel("psogmPer-excel.xls");
	});
}

//설비선택
function ogm312_pop_OnClick(){
	
	//var str = dialog("psogmlib::ogm200_pop.xml","설비선택",300,300,"TitleBar=true");
	window.open("/WAF003PsogmPerSearch/machineSelectPop.do","machinePop","width=540,height=700,scrollbars=yes,top=100,left=100");

}

/**
 * 팝업창에서 값넘겨받아 부모창에 데이터 set
 * 
 * @param returnValue
 */
function getReturnValue(type, returnValue) {
	if(returnValue !== null) {
		var param = JSON.parse(returnValue);
		//console.log('txtmshno:' + param.mshno);
		$('#txtmshno').val(param.mshno);
		$('#txtmshnm').val(param.mshnm).prop('readonly', true);
		$('#txtmshnm').css('background-color', 'rgb(234, 233, 233)');
		txtmshno_chk(param.mshno);
	}
	
}

function txtmshno_chk(str){
	if(str !== "" && str !== undefined){
    	$.ajax({
    		type    : "GET",
    		//contentType : "application/json",
    		url     : "/WAF003PsogmPerSearch/getPrtcdTimcdByMshno.do",
    		data    : {"mshno" : str},
    		//dataType : "json",
    		success : function (resData){
    			try{
	    			var data = JSON.parse(resData);
	    			if(data.result === RESULT_Y){
						var strDate = data.machineInfo.indat.substr(0, 4) + '-' + data.machineInfo.indat.substr(4, 2) + ' - 취득'; 
    					$('#txtmshnm').val(data.machineInfo.mshnm);
    					$('#txttimnm').val(data.machineInfo.timnm);
    					$('#txtprtnm').val(data.machineInfo.prtnm);
    					$('#mtbindat').val(strDate);
	    			}else{
	    				toastMsg('조회된 데이터가 없습니다.');
	    				$('#txtmshno').val("");
	    				$('#txtmshnm').val("");
	    				$('#txttimnm').val("");
    					$('#txtprtnm').val("");
    					$('#mtbindat').val("");
	    			}
    			}catch(e){
    				//console.log(e);
    			}
    		},
    		error   : function(x,e){
				ajaxError(x,e);
    		}
		});
	} else {
		//console.log("emplty txtmshno_chk");
	}
}