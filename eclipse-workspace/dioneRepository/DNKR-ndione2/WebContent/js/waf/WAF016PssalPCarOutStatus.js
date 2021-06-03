var picker = new ax5.ui.picker();
var firstGrid;


//데이터 조회
function searchData(){
	
	if($('#pyvnd').val() === undefined || $('#pyvnd').val().trim().length === 0) {
		$('#pyvnd').val("00000000");
	}
	
	if($('#pyvnd2').val() === undefined || $('#pyvnd2').val().trim().length === 0) {
		$('#pyvnd2').val("99999999");
	}
	
	var params = $("#searchForm").serialize();

	mask.open();
	//getGridVal, TextVal
	$.ajax({
		type    : "POST",
		//contentType : "application/json",
		url     : "/WAF016PssalPCarOutStatus/getGridVal.do",
		data    : params,
		//dataType : "json",
		success : function (data){
			try{
				var parse = JSON.parse(data);
				if(parse.result === RESULT_Y){	 
					firstGrid.setData(parse.list);
				}else{
					toastMsg(LN_NO_DATA);
					document.gridForm.reset();
					firstGrid.setData([]);
				}
			}catch(e){
//				console.log(e);
			}
		},
		error   : function(x,e){
			ajaxError(x,e);
		},
		complete :  function() {
			mask.close();
		}
	});
	
}


$(document.body).ready(function() {
	mask.close();
	
	$('.excelBtn').on('click', function() {
		firstGrid.exportExcel("grid-to-excel.xls");
	});
	
	$('[data-ax5formatter]').ax5formatter();
	 
	// Date
	picker.bind({
        target: $('[data-picker-date="date"]'),
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
                },
                marker: (function () {
                    var marker = {};
                    marker[ax5.util.date(new Date(), {'return': 'yyyy-MM-dd', 'add': {d: 0}})] = true;

                    return marker;
                })()
            }
        },
        onStateChanged: function () {
            if (this.state == "open") {
                //console.log(this.item);
                var selectedValue = this.self.getContentValue(this.item["$target"]);
                if (!selectedValue) {
                    this.item.pickerCalendar[0].ax5uiInstance.setSelection([ax5.util.date(new Date(), {'add': {d: 1}})]);
                }
            }
        }
    });
	
	// Date-year
	picker.bind({
        target: $('[data-picker-date="year"]'),
        direction: "top",
        content: {
            width: 270,
            margin: 10,
            type: 'date',
            config: {
            	mode : "year",
            	selectMode: "year",
                control: {
                    left: '<i class="fa fa-chevron-left"></i>',
                    yearTmpl: '%s'
                },
                lang: {
                    yearTmpl: "%s년"
                }
            }
        },
    });
	
	//Grid
	firstGrid = new ax5.ui.grid({
        target: $('[data-ax5grid="first-grid"]'),
        header: {
        	align: "center"
        },
        columns: [
                  	/**
                  	 * 사업부, 업체코드, 업체명을 그룹으로 해준 이유는 같은값끼리 셀병합 위해
                  	 * 그룹으로 해주지 않으면 다른 그룹때문에 그 row는 빈값으로 채워지므로 셀병합이 이뤄지지않음
                  	 * */
					{key: "comps", label: "사업부", align: "center", 
						columns: [
     					   {key: "comps", label: "사업부", align: "center"},
				    ]},
					{key: "pyvnd", label: "업체코드", align: "center", columns: [
					   {key: "pyvnd", label: "업체코드", align: "center"},
				    ]},
				    {key: "cusnm", label: "업체명", align: "center", columns: [
  					   {key: "cusnm", label: "업체명", align: "center"}
  				    ]},
					{key: "carnm", label: "차종명", align: "center", columns: [
					   {key: "carcd", label: "차종명", align: "center",
						formatter: function() {
							return "(" + this.value + ")";
						}   
					   }
				    ]},
					{key: "mon4", label: "4월", align: "right", columns: [
   					   {key: "pcost4", label: "4월", align: "right"}
   				    ]},
					{key: "mon5", label: "5월", align: "right", columns: [
					   {key: "pcost5", label: "5월", align: "right"}
   				    ]},
					{key: "mon6", label: "6월", align: "right", columns: [
  					   {key: "pcost6", label: "6월", align: "right"}
   				    ]},
					{key: "mon7", label: "7월", align: "right", columns: [
  					   {key: "pcost7", label: "7월", align: "right"}
   				    ]},
					{key: "mon8", label: "8월", align: "right", columns: [
  					   {key: "pcost8", label: "8월", align: "right"}
   				    ]},
					{key: "mon9", label: "9월", align: "right", columns: [
  					   {key: "pcost9", label: "9월", align: "right"}
   				    ]},
   				    {key: "mon", label: "상반기계", align: "right",
   				    	formatter: function() {
   				    		return Number(this.item.mon4) + Number(this.item.mon5) + Number(this.item.mon6) + Number(this.item.mon7) + Number(this.item.mon8) + Number(this.item.mon9);
   				    	}, 
   				    	columns: [
					   {key: "pcost", label: "상반기계", align: "right", 
						   formatter: function() {
							   return Number(this.item.pcost4) + Number(this.item.pcost5) + Number(this.item.pcost6) + Number(this.item.pcost7) + Number(this.item.pcost8) + Number(this.item.pcost9);
						   }
					   }
				    ]},
					{key: "mon10", label: "10월", align: "right", columns: [
					   {key: "pcost10", label: "10월", align: "right"}
   				    ]},
					{key: "mon11", label: "11월", align: "right", columns: [
					   {key: "pcost11", label: "11월", align: "right"}
   				    ]},
					{key: "mon12", label: "12월", align: "right", columns: [
					   {key: "pcost12", label: "12월", align: "right"}
   				    ]},
					{key: "mon1", label: "1월", align: "right", columns: [
   					   {key: "pcost1", label: "1월", align: "right"}
  				    ]},
					{key: "mon2", label: "2월", align: "right", columns: [
   					   {key: "pcost2", label: "2월", align: "right"}
  				    ]},
					{key: "mon3", label: "3월", align: "right", columns: [
   					   {key: "pcost3", label: "3월", align: "right"}
  				    ]},
					{key: "monSum", label: "년계", align: "center",
  				    	formatter: function() {
				    		return Number(this.item.mon4) + Number(this.item.mon5) + Number(this.item.mon6) + Number(this.item.mon7) 
				    		+ Number(this.item.mon8) + Number(this.item.mon9) + Number(this.item.mon10) + Number(this.item.mon11)
				    		+ Number(this.item.mon12) + Number(this.item.mon1)+ Number(this.item.mon2) + Number(this.item.mon3);
				    	},
				    	columns: [
                        {key: "pcostSum", label: "년계", align: "center", 
						   formatter: function() {
							   return Number(this.item.pcost4) + Number(this.item.pcost5) + Number(this.item.pcost6) + Number(this.item.pcost7)
							   + Number(this.item.pcost8) + Number(this.item.pcost9)+ Number(this.item.pcost10) + Number(this.item.pcost11)
							   + Number(this.item.pcost12) + Number(this.item.pcost1)+ Number(this.item.pcost2) + Number(this.item.pcost3);
						   }
                        }
   				    ]}
         ],
         body: {
           	 mergeCells: ["comps", "pyvnd", "cusnm"]
         },
         footSum: 
    	 [
    	  //(C/M)금액
    	  [
            {label:"총합계", colspan:3, align: "center"},
            {label:"(C/M)금액", align: "center"},
            {
                key: "mon4", collector: function () {
                    var value = 0;
                    this.list.forEach(function (n) {
                    	if(n.carnm === 'C/M(금액)') {
                    		value += Number(n.mon4);
                    	}
                    });
                    return ax5.util.number(value, {"money": 1});
                }, align: "right"
        	},
            {
                key: "mon5", collector: function () {
                    var value = 0;
                    this.list.forEach(function (n) {
                    	if(n.carnm === 'C/M(금액)') {
                    		value += Number(n.mon5);
                    	}
                    });
                    return ax5.util.number(value, {"money": 1});
                }, align: "right"
            },
            {
                key: "mon6", collector: function () {
                    var value = 0;
                    this.list.forEach(function (n) {
                    	if(n.carnm === 'C/M(금액)') {
                    		value += Number(n.mon6);
                    	}
                    });
                    return ax5.util.number(value, {"money": 1});
                }, align: "right"
            },
            {
                key: "mon7", collector: function () {
                    var value = 0;
                    this.list.forEach(function (n) {
                    	if(n.carnm === 'C/M(금액)') {
                    		value += Number(n.mon7);
                    	}
                    });
                    return ax5.util.number(value, {"money": 1});
                }, align: "right"
            },
            {
                key: "mon8", collector: function () {
                    var value = 0;
                    this.list.forEach(function (n) {
                    	if(n.carnm === 'C/M(금액)') {
                    		value += Number(n.mon8);
                    	}
                    });
                    return ax5.util.number(value, {"money": 1});
                }, align: "right"
            },
            {
                key: "mon9", collector: function () {
                    var value = 0;
                    this.list.forEach(function (n) {
                    	if(n.carnm === 'C/M(금액)') {
                    		value += Number(n.mon9);
                    	}
                    });
                    return ax5.util.number(value, {"money": 1});
                }, align: "right"
            },
            {
                key: "mon", collector: function () {
                    var value = 0;
                    this.list.forEach(function (n) {
                    	if(n.carnm === 'C/M(금액)') {
                    		value += Number(n.mon4) + Number(n.mon5) + Number(n.mon6)
                    		+ Number(n.mon7) + Number(n.mon8) + Number(n.mon9);
                    	}
                    });
                    return ax5.util.number(value, {"money": 1});
                }, align: "right"
            },
            {
                key: "mon10", collector: function () {
                    var value = 0;
                    this.list.forEach(function (n) {
                    	if(n.carnm === 'C/M(금액)') {
                    		value += Number(n.mon10);
                    	}
                    });
                    return ax5.util.number(value, {"money": 1});
                }, align: "right"
            },
            {
                key: "mon11", collector: function () {
                    var value = 0;
                    this.list.forEach(function (n) {
                    	if(n.carnm === 'C/M(금액)') {
                    		value += Number(n.mon11);
                    	}
                    });
                    return ax5.util.number(value, {"money": 1});
                }, align: "right"
            },
            {
                key: "mon12", collector: function () {
                    var value = 0;
                    this.list.forEach(function (n) {
                    	if(n.carnm === 'C/M(금액)') {
                    		value += Number(n.mon12);
                    	}
                    });
                    return ax5.util.number(value, {"money": 1});
                }, align: "right"
            },
            {
                key: "mon1", collector: function () {
                    var value = 0;
                    this.list.forEach(function (n) {
                    	if(n.carnm === 'C/M(금액)') {
                    		value += Number(n.mon1);
                    	}
                    });
                    return ax5.util.number(value, {"money": 1});
                }, align: "right"
            },
            {
                key: "mon2", collector: function () {
                    var value = 0;
                    this.list.forEach(function (n) {
                    	if(n.carnm === 'C/M(금액)') {
                    		value += Number(n.mon2);
                    	}
                    });
                    return ax5.util.number(value, {"money": 1});
                }, align: "right"
            },
            {
                key: "mon3", collector: function () {
                    var value = 0;
                    this.list.forEach(function (n) {
                    	if(n.carnm === 'C/M(금액)') {
                    		value += Number(n.mon3);
                    	}
                    });
                    return ax5.util.number(value, {"money": 1});
                }, align: "right"
            },
            {
                key: "monSum", collector: function () {
                    var value = 0;
                    this.list.forEach(function (n) {
                    	if(n.carnm === 'C/M(금액)') {
                    		value += Number(n.mon4) + Number(n.mon5) + Number(n.mon6) + Number(n.mon7)
                    		+ Number(n.mon8) + Number(n.mon9) + Number(n.mon10) + Number(n.mon11)
                    		+ Number(n.mon12) + Number(n.mon1) + Number(n.mon2) + Number(n.mon3);
                    	}
                    });
                    return ax5.util.number(value, {"money": 1});
                }, align: "right"
            }
           
        ],
        
        //(C/M)수량
        [
	         {label:"총합계", colspan:3, align: "center"},
	         {label:"(C/M)수량", align: "center"},
	         {
	             key: "pcost4", collector: function () {
	                 var value = 0;
	                 this.list.forEach(function (n) {
	                 	if(n.carnm === 'C/M(금액)') {
	                 		value += Number(n.pcost4);
	                 	}
	                 });
	                 return ax5.util.number(value, {"money": 1});
	             }, align: "right"
	         },
	         {
	             key: "pcost5", collector: function () {
	                 var value = 0;
	                 this.list.forEach(function (n) {
	                 	if(n.carnm === 'C/M(금액)') {
	                 		value += Number(n.pcost5);
	                 	}
	                 });
	                 return ax5.util.number(value, {"money": 1});
	             }, align: "right"
	         },
	         {
	             key: "pcost6", collector: function () {
	                 var value = 0;
	                 this.list.forEach(function (n) {
	                 	if(n.carnm === 'C/M(금액)') {
	                 		value += Number(n.pcost6);
	                 	}
	                 });
	                 return ax5.util.number(value, {"money": 1});
	             }, align: "right"
	         },
	         {
	             key: "pcost7", collector: function () {
	                 var value = 0;
	                 this.list.forEach(function (n) {
	                 	if(n.carnm === 'C/M(금액)') {
	                 		value += Number(n.pcost7);
	                 	}
	                 });
	                 return ax5.util.number(value, {"money": 1});
	             }, align: "right"
	         },
	         {
	             key: "pcost8", collector: function () {
	                 var value = 0;
	                 this.list.forEach(function (n) {
	                 	if(n.carnm === 'C/M(금액)') {
	                 		value += Number(n.pcost8);
	                 	}
	                 });
	                 return ax5.util.number(value, {"money": 1});
	             }, align: "right"
	         },
	         {
	             key: "pcost9", collector: function () {
	                 var value = 0;
	                 this.list.forEach(function (n) {
	                 	if(n.carnm === 'C/M(금액)') {
	                 		value += Number(n.pcost9);
	                 	}
	                 });
	                 return ax5.util.number(value, {"money": 1});
	             }, align: "right"
	         },
	         {
	             key: "pcost", collector: function () {
	                 var value = 0;
	                 this.list.forEach(function (n) {
	                 	if(n.carnm === 'C/M(금액)') {
	                 		value += Number(n.pcost4) + Number(n.pcost5) + Number(n.pcost6)
	                 		+ Number(n.pcost7) + Number(n.pcost8) + Number(n.pcost9);
	                 	}
	                 });
	                 return ax5.util.number(value, {"money": 1});
	             }, align: "right"
	         },
	         {
	             key: "pcost10", collector: function () {
	                 var value = 0;
	                 this.list.forEach(function (n) {
	                 	if(n.carnm === 'C/M(금액)') {
	                 		value += Number(n.pcost10);
	                 	}
	                 });
	                 return ax5.util.number(value, {"money": 1});
	             }, align: "right"
	         },
	         {
	             key: "pcost11", collector: function () {
	                 var value = 0;
	                 this.list.forEach(function (n) {
	                 	if(n.carnm === 'C/M(금액)') {
	                 		value += Number(n.pcost11);
	                 	}
	                 });
	                 return ax5.util.number(value, {"money": 1});
	             }, align: "right"
	         },
	         {
	             key: "pcost12", collector: function () {
	                 var value = 0;
	                 this.list.forEach(function (n) {
	                 	if(n.carnm === 'C/M(금액)') {
	                 		value += Number(n.pcost12);
	                 	}
	                 });
	                 return ax5.util.number(value, {"money": 1});
	             }, align: "right"
	         },
	         {
	             key: "pcost1", collector: function () {
	                 var value = 0;
	                 this.list.forEach(function (n) {
	                 	if(n.carnm === 'C/M(금액)') {
	                 		value += Number(n.pcost1);
	                 	}
	                 });
	                 return ax5.util.number(value, {"money": 1});
	             }, align: "right"
	         },
	         {
	             key: "pcost2", collector: function () {
	                 var value = 0;
	                 this.list.forEach(function (n) {
	                 	if(n.carnm === 'C/M(금액)') {
	                 		value += Number(n.pcost2);
	                 	}
	                 });
	                 return ax5.util.number(value, {"money": 1});
	             }, align: "right"
	         },
	         {
	             key: "pcost3", collector: function () {
	                 var value = 0;
	                 this.list.forEach(function (n) {
	                 	if(n.carnm === 'C/M(금액)') {
	                 		value += Number(n.pcost3);
	                 	}
	                 });
	                 return ax5.util.number(value, {"money": 1});
	             }, align: "right"
	         },
	         {
	             key: "pcostSum", collector: function () {
	                 var value = 0;
	                 this.list.forEach(function (n) {
	                 	if(n.carnm === 'C/M(금액)') {
	                 		value += Number(n.pcost4) + Number(n.pcost5) + Number(n.pcost6) + Number(n.pcost7)
                    		+ Number(n.pcost8) + Number(n.pcost9) + Number(n.pcost10) + Number(n.pcost11)
                    		+ Number(n.pcost12) + Number(n.pcost1) + Number(n.pcost2) + Number(n.pcost3);
	                 	}
	                 });
	                 return ax5.util.number(value, {"money": 1});
	             }, align: "right"
	         }
        
         ],
         
         //(M/M)금액
         [
		       {label:"총합계", colspan:3, align: "center"},
		       {label:"(C/M)금액", align: "center"},
		       {
		           key: "mon4", collector: function () {
		               var value = 0;
		               this.list.forEach(function (n) {
		               	if(n.carnm === 'M/M(금액)') {
		               		value += Number(n.mon4);
		               	}
		               });
		               return ax5.util.number(value, {"money": 1});
		           }, align: "right"
		       },
		       {
		           key: "mon5", collector: function () {
		               var value = 0;
		               this.list.forEach(function (n) {
		               	if(n.carnm === 'M/M(금액)') {
		               		value += Number(n.mon5);
		               	}
		               });
		               return ax5.util.number(value, {"money": 1});
		           }, align: "right"
		       },
		       {
		           key: "mon6", collector: function () {
		               var value = 0;
		               this.list.forEach(function (n) {
		               	if(n.carnm === 'M/M(금액)') {
		               		value += Number(n.mon6);
		               	}
		               });
		               return ax5.util.number(value, {"money": 1});
		           }, align: "right"
		       },
		       {
		           key: "mon7", collector: function () {
		               var value = 0;
		               this.list.forEach(function (n) {
		               	if(n.carnm === 'M/M(금액)') {
		               		value += Number(n.mon7);
		               	}
		               });
		               return ax5.util.number(value, {"money": 1});
		           }, align: "right"
		       },
		       {
		           key: "mon8", collector: function () {
		               var value = 0;
		               this.list.forEach(function (n) {
		               	if(n.carnm === 'M/M(금액)') {
		               		value += Number(n.mon8);
		               	}
		               });
		               return ax5.util.number(value, {"money": 1});
		           }, align: "right"
		       },
		       {
		           key: "mon9", collector: function () {
		               var value = 0;
		               this.list.forEach(function (n) {
		               	if(n.carnm === 'M/M(금액)') {
		               		value += Number(n.mon9);
		               	}
		               });
		               return ax5.util.number(value, {"money": 1});
		           }, align: "right"
		       },
		       {
		           key: "mon", collector: function () {
		               var value = 0;
		               this.list.forEach(function (n) {
		               	if(n.carnm === 'M/M(금액)') {
		               		value += Number(n.mon4) + Number(n.mon5) + Number(n.mon6)
                    		+ Number(n.mon7) + Number(n.mon8) + Number(n.mon9);
		               	}
		               });
		               return ax5.util.number(value, {"money": 1});
		           }, align: "right"
		       },
		       {
		           key: "mon10", collector: function () {
		               var value = 0;
		               this.list.forEach(function (n) {
		               	if(n.carnm === 'M/M(금액)') {
		               		value += Number(n.mon10);
		               	}
		               });
		               return ax5.util.number(value, {"money": 1});
		           }, align: "right"
		       },
		       {
		           key: "mon11", collector: function () {
		               var value = 0;
		               this.list.forEach(function (n) {
		               	if(n.carnm === 'M/M(금액)') {
		               		value += Number(n.mon11);
		               	}
		               });
		               return ax5.util.number(value, {"money": 1});
		           }, align: "right"
		       },
		       {
		           key: "mon12", collector: function () {
		               var value = 0;
		               this.list.forEach(function (n) {
		               	if(n.carnm === 'M/M(금액)') {
		               		value += Number(n.mon12);
		               	}
		               });
		               return ax5.util.number(value, {"money": 1});
		           }, align: "right"
		       },
		       {
		           key: "mon1", collector: function () {
		               var value = 0;
		               this.list.forEach(function (n) {
		               	if(n.carnm === 'M/M(금액)') {
		               		value += Number(n.mon1);
		               	}
		               });
		               return ax5.util.number(value, {"money": 1});
		           }, align: "right"
		       },
		       {
		           key: "mon2", collector: function () {
		               var value = 0;
		               this.list.forEach(function (n) {
		               	if(n.carnm === 'M/M(금액)') {
		               		value += Number(n.mon2);
		               	}
		               });
		               return ax5.util.number(value, {"money": 1});
		           }, align: "right"
		       },
		       {
		           key: "mon3", collector: function () {
		               var value = 0;
		               this.list.forEach(function (n) {
		               	if(n.carnm === 'M/M(금액)') {
		               		value += Number(n.mon3);
		               	}
		               });
		               return ax5.util.number(value, {"money": 1});
		           }, align: "right"
		       },
		       {
		           key: "monSum", collector: function () {
		               var value = 0;
		               this.list.forEach(function (n) {
		               	if(n.carnm === 'M/M(금액)') {
		               		value += Number(n.mon4) + Number(n.mon5) + Number(n.mon6) + Number(n.mon7)
                    		+ Number(n.mon8) + Number(n.mon9) + Number(n.mon10) + Number(n.mon11)
                    		+ Number(n.mon12) + Number(n.mon1) + Number(n.mon2) + Number(n.mon3);
		               	}
		               });
		               return ax5.util.number(value, {"money": 1});
		           }, align: "right"
		       }
		      
		   ],
		   
		   //(M/M)수량
		   [
			    {label:"총합계", colspan:3, align: "center"},
			    {label:"(M/M)수량", align: "center"},
			    {
			        key: "pcost4", collector: function () {
			            var value = 0;
			            this.list.forEach(function (n) {
			            	if(n.carnm === 'M/M(금액)') {
			            		value += Number(n.pcost4);
			            	}
			            });
			            return ax5.util.number(value, {"money": 1});
			        }, align: "right"
			    },
			    {
			        key: "pcost5", collector: function () {
			            var value = 0;
			            this.list.forEach(function (n) {
			            	if(n.carnm === 'M/M(금액)') {
			            		value += Number(n.pcost5);
			            	}
			            });
			            return ax5.util.number(value, {"money": 1});
			        }, align: "right"
			    },
			    {
			        key: "pcost6", collector: function () {
			            var value = 0;
			            this.list.forEach(function (n) {
			            	if(n.carnm === 'M/M(금액)') {
			            		value += Number(n.pcost6);
			            	}
			            });
			            return ax5.util.number(value, {"money": 1});
			        }, align: "right"
			    },
			    {
			        key: "pcost7", collector: function () {
			            var value = 0;
			            this.list.forEach(function (n) {
			            	if(n.carnm === 'M/M(금액)') {
			            		value += Number(n.pcost7);
			            	}
			            });
			            return ax5.util.number(value, {"money": 1});
			        }, align: "right"
			    },
			    {
			        key: "pcost8", collector: function () {
			            var value = 0;
			            this.list.forEach(function (n) {
			            	if(n.carnm === 'M/M(금액)') {
			            		value += Number(n.pcost8);
			            	}
			            });
			            return ax5.util.number(value, {"money": 1});
			        }, align: "right"
			    },
			    {
			        key: "pcost9", collector: function () {
			            var value = 0;
			            this.list.forEach(function (n) {
			            	if(n.carnm === 'M/M(금액)') {
			            		value += Number(n.pcost9);
			            	}
			            });
			            return ax5.util.number(value, {"money": 1});
			        }, align: "right"
			    },
			    {
			        key: "pcost", collector: function () {
			            var value = 0;
			            this.list.forEach(function (n) {
			            	if(n.carnm === 'M/M(금액)') {
			            		value += Number(n.pcost4) + Number(n.pcost5) + Number(n.pcost6) 
			            		+ Number(n.pcost7) + Number(n.pcost8) + Number(n.pcost9);
			            	}
			            });
			            return ax5.util.number(value, {"money": 1});
			        }, align: "right"
			    },
			    {
			        key: "pcost10", collector: function () {
			            var value = 0;
			            this.list.forEach(function (n) {
			            	if(n.carnm === 'M/M(금액)') {
			            		value += Number(n.pcost10);
			            	}
			            });
			            return ax5.util.number(value, {"money": 1});
			        }, align: "right"
			    },
			    {
			        key: "pcost11", collector: function () {
			            var value = 0;
			            this.list.forEach(function (n) {
			            	if(n.carnm === 'M/M(금액)') {
			            		value += Number(n.pcost11);
			            	}
			            });
			            return ax5.util.number(value, {"money": 1});
			        }, align: "right"
			    },
			    {
			        key: "pcost12", collector: function () {
			            var value = 0;
			            this.list.forEach(function (n) {
			            	if(n.carnm === 'M/M(금액)') {
			            		value += Number(n.pcost12);
			            	}
			            });
			            return ax5.util.number(value, {"money": 1});
			        }, align: "right"
			    },
			    {
			        key: "pcost1", collector: function () {
			            var value = 0;
			            this.list.forEach(function (n) {
			            	if(n.carnm === 'M/M(금액)') {
			            		value += Number(n.pcost1);
			            	}
			            });
			            return ax5.util.number(value, {"money": 1});
			        }, align: "right"
			    },
			    {
			        key: "pcost2", collector: function () {
			            var value = 0;
			            this.list.forEach(function (n) {
			            	if(n.carnm === 'M/M(금액)') {
			            		value += Number(n.pcost2);
			            	}
			            });
			            return ax5.util.number(value, {"money": 1});
			        }, align: "right"
			    },
			    {
			        key: "pcost3", collector: function () {
			            var value = 0;
			            this.list.forEach(function (n) {
			            	if(n.carnm === 'M/M(금액)') {
			            		value += Number(n.pcost3);
			            	}
			            });
			            return ax5.util.number(value, {"money": 1});
			        }, align: "right"
			    },
			    {
			        key: "pcostSum", collector: function () {
			            var value = 0;
			            this.list.forEach(function (n) {
			            	if(n.carnm === 'M/M(금액)') {
			            		value += Number(n.pcost4) + Number(n.pcost5) + Number(n.pcost6) + Number(n.pcost7)
	                    		+ Number(n.pcost8) + Number(n.pcost9) + Number(n.pcost10) + Number(n.pcost11)
	                    		+ Number(n.pcost12) + Number(n.pcost1) + Number(n.pcost2) + Number(n.pcost3);
			            	}
			            });
			            return ax5.util.number(value, {"money": 1});
			        }, align: "right"
			    }
	   
			],
			
			//(전체)금액
	         [
		       {label:"총합계", colspan:3, align: "center"},
		       {label:"(전체)금액", align: "center"},
		       {
		           key: "mon4", collector: function () {
		               var value = 0;
		               this.list.forEach(function (n) {
		               	if(n.carnm === '전체(금액)') {
		               		value += Number(n.mon4);
		               	}
		               });
		               return ax5.util.number(value, {"money": 1});
		           }, align: "right"
		       },
		       {
		           key: "mon5", collector: function () {
		               var value = 0;
		               this.list.forEach(function (n) {
		               	if(n.carnm === '전체(금액)') {
		               		value += Number(n.mon5);
		               	}
		               });
		               return ax5.util.number(value, {"money": 1});
		           }, align: "right"
		       },
		       {
		           key: "mon6", collector: function () {
		               var value = 0;
		               this.list.forEach(function (n) {
		               	if(n.carnm === '전체(금액)') {
		               		value += Number(n.mon6);
		               	}
		               });
		               return ax5.util.number(value, {"money": 1});
		           }, align: "right"
		       },
		       {
		           key: "mon7", collector: function () {
		               var value = 0;
		               this.list.forEach(function (n) {
		               	if(n.carnm === '전체(금액)') {
		               		value += Number(n.mon7);
		               	}
		               });
		               return ax5.util.number(value, {"money": 1});
		           }, align: "right"
		       },
		       {
		           key: "mon8", collector: function () {
		               var value = 0;
		               this.list.forEach(function (n) {
		               	if(n.carnm === '전체(금액)') {
		               		value += Number(n.mon8);
		               	}
		               });
		               return ax5.util.number(value, {"money": 1});
		           }, align: "right"
		       },
		       {
		           key: "mon9", collector: function () {
		               var value = 0;
		               var cnt = 0;
		               var cnt2 = 0;
		               this.list.forEach(function (n) {
		               	if(n.carnm === '전체(금액)') {
		               		value += Number(n.mon9);
		               	}
		               });
		               return ax5.util.number(value, {"money": 1});
		           }, align: "right"
		       },
		       {
		           key: "mon", collector: function () {
		               var value = 0;
		               this.list.forEach(function (n) {
		               	if(n.carnm === '전체(금액)') {
		               		value += Number(n.mon4) + Number(n.mon5) + Number(n.mon6) 
		               		+ Number(n.mon7) + Number(n.mon8) + Number(n.mon9);
		               	}
		               });
		               return ax5.util.number(value, {"money": 1});
		           }, align: "right"
		       },
		       {
		           key: "mon10", collector: function () {
		               var value = 0;
		               this.list.forEach(function (n) {
		               	if(n.carnm === '전체(금액)') {
		               		value += Number(n.mon10);
		               	}
		               });
		               return ax5.util.number(value, {"money": 1});
		           }, align: "right"
		       },
		       {
		           key: "mon11", collector: function () {
		               var value = 0;
		               this.list.forEach(function (n) {
		               	if(n.carnm === '전체(금액)') {
		               		value += Number(n.mon11);
		               	}
		               });
		               return ax5.util.number(value, {"money": 1});
		           }, align: "right"
		       },
		       {
		           key: "mon12", collector: function () {
		               var value = 0;
		               this.list.forEach(function (n) {
		               	if(n.carnm === '전체(금액)') {
		               		value += Number(n.mon12);
		               	}
		               });
		               return ax5.util.number(value, {"money": 1});
		           }, align: "right"
		       },
		       {
		           key: "mon1", collector: function () {
		               var value = 0;
		               this.list.forEach(function (n) {
		               	if(n.carnm === '전체(금액)') {
		               		value += Number(n.mon1);
		               	}
		               });
		               return ax5.util.number(value, {"money": 1});
		           }, align: "right"
		       },
		       {
		           key: "mon2", collector: function () {
		               var value = 0;
		               this.list.forEach(function (n) {
		               	if(n.carnm === '전체(금액)') {
		               		value += Number(n.mon2);
		               	}
		               });
		               return ax5.util.number(value, {"money": 1});
		           }, align: "right"
		       },
		       {
		           key: "mon3", collector: function () {
		               var value = 0;
		               this.list.forEach(function (n) {
		               	if(n.carnm === '전체(금액)') {
		               		value += Number(n.mon3);
		               	}
		               });
		               return ax5.util.number(value, {"money": 1});
		           }, align: "right"
		       },
		       {
		           key: "monSum", collector: function () {
		               var value = 0;
		               this.list.forEach(function (n) {
		               	if(n.carnm === '전체(금액)') {
		               		value += Number(n.mon4) + Number(n.mon5) + Number(n.mon6) + Number(n.mon7)
                    		+ Number(n.mon8) + Number(n.mon9) + Number(n.mon10) + Number(n.mon11)
                    		+ Number(n.mon12) + Number(n.mon1) + Number(n.mon2) + Number(n.mon3);
		               	}
		               });
		               return ax5.util.number(value, {"money": 1});
		           }, align: "right"
		       }
		      
		   ],
		   
		   //(전체)수량
		   [
			    {label:"총합계", colspan:3, align: "center"},
			    {label:"(전체)수량", align: "center"},
			    {
			        key: "pcost4", collector: function () {
			            var value = 0;
			            this.list.forEach(function (n) {
			            	if(n.carnm === '전체(금액)') {
			            		value += Number(n.pcost4);
			            	}
			            });
			            return ax5.util.number(value, {"money": 1});
			        }, align: "right"
			    },
			    {
			        key: "pcost5", collector: function () {
			            var value = 0;
			            this.list.forEach(function (n) {
			            	if(n.carnm === '전체(금액)') {
			            		value += Number(n.pcost5);
			            	}
			            });
			            return ax5.util.number(value, {"money": 1});
			        }, align: "right"
			    },
			    {
			        key: "pcost6", collector: function () {
			            var value = 0;
			            this.list.forEach(function (n) {
			            	if(n.carnm === '전체(금액)') {
			            		value += Number(n.pcost6);
			            	}
			            });
			            return ax5.util.number(value, {"money": 1});
			        }, align: "right"
			    },
			    {
			        key: "pcost7", collector: function () {
			            var value = 0;
			            this.list.forEach(function (n) {
			            	if(n.carnm === '전체(금액)') {
			            		value += Number(n.pcost7);
			            	}
			            });
			            return ax5.util.number(value, {"money": 1});
			        }, align: "right"
			    },
			    {
			        key: "pcost8", collector: function () {
			            var value = 0;
			            this.list.forEach(function (n) {
			            	if(n.carnm === '전체(금액)') {
			            		value += Number(n.pcost8);
			            	}
			            });
			            return ax5.util.number(value, {"money": 1});
			        }, align: "right"
			    },
			    {
			        key: "pcost9", collector: function () {
			            var value = 0;
			            this.list.forEach(function (n) {
			            	if(n.carnm === '전체(금액)') {
			            		value += Number(n.pcost9);
			            	}
			            });
			            return ax5.util.number(value, {"money": 1});
			        }, align: "right"
			    },
			    {
			        key: "pcost", collector: function () {
			            var value = 0;
			            this.list.forEach(function (n) {
			            	if(n.carnm === '전체(금액)') {
			            		value += Number(n.pcost4) + Number(n.pcost5) + Number(n.pcost6)
			            		+ Number(n.pcost7) + Number(n.pcost8) + Number(n.pcost9);
			            	}
			            });
			            return ax5.util.number(value, {"money": 1});
			        }, align: "right"
			    },
			    {
			        key: "pcost10", collector: function () {
			            var value = 0;
			            this.list.forEach(function (n) {
			            	if(n.carnm === '전체(금액)') {
			            		value += Number(n.pcost10);
			            	}
			            });
			            return ax5.util.number(value, {"money": 1});
			        }, align: "right"
			    },
			    {
			        key: "pcost11", collector: function () {
			            var value = 0;
			            this.list.forEach(function (n) {
			            	if(n.carnm === '전체(금액)') {
			            		value += Number(n.pcost11);
			            	}
			            });
			            return ax5.util.number(value, {"money": 1});
			        }, align: "right"
			    },
			    {
			        key: "pcost12", collector: function () {
			            var value = 0;
			            this.list.forEach(function (n) {
			            	if(n.carnm === '전체(금액)') {
			            		value += Number(n.pcost12);
			            	}
			            });
			            return ax5.util.number(value, {"money": 1});
			        }, align: "right"
			    },
			    {
			        key: "pcost1", collector: function () {
			            var value = 0;
			            this.list.forEach(function (n) {
			            	if(n.carnm === '전체(금액)') {
			            		value += Number(n.pcost1);
			            	}
			            });
			            return ax5.util.number(value, {"money": 1});
			        }, align: "right"
			    },
			    {
			        key: "pcost2", collector: function () {
			            var value = 0;
			            var cnt = 0;
			            var cnt2 = 0;
			            this.list.forEach(function (n) {
			            	if(n.carnm === '전체(금액)') {
			            		value += Number(n.pcost2);
			            	}
			            });
			            return ax5.util.number(value, {"money": 1});
			        }, align: "right"
			    },
			    {
			        key: "pcost3", collector: function () {
			            var value = 0;
			            this.list.forEach(function (n) {
			            	if(n.carnm === '전체(금액)') {
			            		value += Number(n.pcost3);
			            	}
			            });
			            return ax5.util.number(value, {"money": 1});
			        }, align: "right"
			    },
			    {
			        key: "pcostSum", collector: function () {
			            var value = 0;
			            this.list.forEach(function (n) {
			            	if(n.carnm === '전체(금액)') {
			            		value += Number(n.pcost4) + Number(n.pcost5) + Number(n.pcost6) + Number(n.pcost7)
	                    		+ Number(n.pcost8) + Number(n.pcost9) + Number(n.pcost10) + Number(n.pcost11)
	                    		+ Number(n.pcost12) + Number(n.pcost1) + Number(n.pcost2) + Number(n.pcost3);
			            	}
			            });
			            return ax5.util.number(value, {"money": 1});
			        }, align: "right"
			    }
	   
			]
        ],
    });
	
});

