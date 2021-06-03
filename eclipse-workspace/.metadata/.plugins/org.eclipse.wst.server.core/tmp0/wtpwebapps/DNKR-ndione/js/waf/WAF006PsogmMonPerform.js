var monPlanGrid;

$(document.body).ready(function () {
    monPlanGrid = new ax5.ui.grid({
        target: $('[data-ax5grid="monPlan-grid"]'),
        header: {
            align: "center"
        },
        body: {
        	align: "center",
        },
        footSum: [[
		    {label:"計", colspan:2},
		    {key:"cnt_jnbno_08", collector:"sum"},
		    {key:"cnt_jnbno_04", collector:"sum"},
		    {key: "cnt_jnbno_05", collector:"sum"},
			{key: "cnt_jnbno_02", collector:"sum"},
			{key: "cnt_jnbno_03", collector:"sum"},
			{key: "cnt_jnbno_15", collector:"sum"},
			{key: "cnt_jnbno_11", collector:"sum"},
			{key: "cnt_jnbno_09", collector:"sum"},
			{key: "cnt_jnbno_06", collector:"sum"},
			{key: "cnt_jnbno_01", collector:"sum"},
			{key: "cnt_jnbno_16", collector:"sum"},
			{key: "cnt_jnbno_17", collector:"sum"},
			{key: "cnt_jnbno_14", collector:"sum"},
			{key: "cnt_jnbno_total", collector:"sum"}, 
			{key: "cnt_yedat_04", collector:"sum"},
			{key: "cnt_rpdat_04", collector:"sum"},
			{key: "cnt_yedat_05", collector:"sum"},
			{key: "cnt_rpdat_05", collector:"sum"},
			{key: "cnt_yedat_06", collector:"sum"},
			{key: "cnt_rpdat_06", collector:"sum"},
			{key: "cnt_yedat_07", collector:"sum"},
			{key: "cnt_rpdat_07", collector:"sum"},
			{key: "cnt_yedat_08", collector:"sum"},
			{key: "cnt_rpdat_08", collector:"sum"},
			{key: "cnt_yedat_09", collector:"sum"},
			{key: "cnt_rpdat_09", collector:"sum"},
			{key: "cnt_yedat_10", collector:"sum"},
			{key: "cnt_rpdat_10", collector:"sum"},
			{key: "cnt_yedat_11", collector:"sum"},
			{key: "cnt_rpdat_11", collector:"sum"},
			{key: "cnt_yedat_12", collector:"sum"},
			{key: "cnt_rpdat_12", collector:"sum"},
			{key: "cnt_yedat_01", collector:"sum"},
			{key: "cnt_rpdat_01", collector:"sum"},
			{key: "cnt_yedat_02", collector:"sum"},
			{key: "cnt_rpdat_02", collector:"sum"},
			{key: "cnt_yedat_03", collector:"sum"},
			{key: "cnt_rpdat_03", collector:"sum"},
			{key: "cnt_total", collector:"sum"},
        ]],
		page : {
			navigationItemCount : 1,
			height : 30,
			display : false,
			firstIcon : '<i class="fa fa-step-backward" aria-hidden="true"></i>',
			prevIcon : '<i class="fa fa-caret-left" aria-hidden="true"></i>',
			nextIcon : '<i class="fa fa-caret-right" aria-hidden="true"></i>',
			lastIcon : '<i class="fa fa-step-forward" aria-hidden="true"></i>',
			onChange : function() {
				gridView.setData(this.page.selectPage);
			}
		},
        columns: [
            {
            	label: "",
            	columns : [
            	           {key: "timnm", label: "", width: 80},
            	           {key: "prtnm", label: "部署", width: 120},
    	        ],
        	},
            {
            	label: "較正 品目 月別 現況",
        		columns: [
					{key: "cnt_jnbno_08", label: "전기", width: 50},
					{key: "cnt_jnbno_04", label: "온도", width: 50},
					{key: "cnt_jnbno_05", label: "압력", width: 50},
					{key: "cnt_jnbno_02", label: "힘", width: 50},
					{key: "cnt_jnbno_03", label: "토크", width: 50},
					{key: "cnt_jnbno_15", label: "속도", width: 50},
					{key: "cnt_jnbno_11", label: "<p style='top: 7px;position: absolute;left: 12px;'>음향<br>진동</p>", width: 50},
					{key: "cnt_jnbno_09", label: "질량", width: 50},
					{key: "cnt_jnbno_06", label: "유량", width: 50},
					{key: "cnt_jnbno_01", label: "길이", width: 50},
					{key: "cnt_jnbno_16", label: "게이지", width: 50},
					{key: "cnt_jnbno_17", label: "치공구", width: 50},
					{key: "cnt_jnbno_14", label: "기타", width: 50},
					{key: "cnt_jnbno_total", label: "계", width: 50},      
					{
						label: "4",
						columns: [
							{key: "cnt_yedat_04", label: "계획", width: 50},
							{key: "cnt_rpdat_04", label: "실적", width: 50}      
						],
					
					},
					{
						label: "5",
						columns: [
							{key: "cnt_yedat_05", label: "계획", width: 50},
							{key: "cnt_rpdat_05", label: "실적", width: 50}      
						],
					
					},
					{
						label: "6",
						columns: [
							{key: "cnt_yedat_06", label: "계획", width: 50},
							{key: "cnt_rpdat_06", label: "실적", width: 50}      
						],
					
					},
					{
						label: "7",
						columns: [
							{key: "cnt_yedat_07", label: "계획", width: 50},
							{key: "cnt_rpdat_07", label: "실적", width: 50}      
						],
					
					},
					{
						label: "8",
						columns: [
							{key: "cnt_yedat_08", label: "계획", width: 50},
							{key: "cnt_rpdat_08", label: "실적", width: 50}      
						],
					
					},
					{
						label: "9",
						columns: [
							{key: "cnt_yedat_09", label: "계획", width: 50},
							{key: "cnt_rpdat_09", label: "실적", width: 50}      
						],
					
					},
					{
						label: "10",
						columns: [
							{key: "cnt_yedat_10", label: "계획", width: 50},
							{key: "cnt_rpdat_10", label: "실적", width: 50}      
						],
					
					},
					{
						label: "11",
						columns: [
							{key: "cnt_yedat_11", label: "계획", width: 50},
							{key: "cnt_rpdat_11", label: "실적", width: 50}      
						],
					
					},
					{
						label: "12",
						columns: [
							{key: "cnt_yedat_12", label: "계획", width: 50},
							{key: "cnt_rpdat_12", label: "실적", width: 50}      
						],
					
					},
					{
						label: "1",
						columns: [
							{key: "cnt_yedat_01", label: "계획", width: 50},
							{key: "cnt_rpdat_01", label: "실적", width: 50}      
						],
					
					},
					{
						label: "2",
						columns: [
							{key: "cnt_yedat_02", label: "계획", width: 50},
							{key: "cnt_rpdat_02", label: "실적", width: 50}      
						],
					
					},
					{
						label: "3",
						columns: [
							{key: "cnt_yedat_03", label: "계획", width: 50},
							{key: "cnt_rpdat_03", label: "실적", width: 50}      
						],
					
					},
					{key: "cnt_total", label: "계", width: 70},
					{label:"", width: 50},
					{label:"", width: 50},
					{label:"", width: 50},
					{label:"", width: 50},
					{label:"", width: 50},
					{label:"", width: 50},
					{label:"", width: 50},
					{label:"", width: 50},
					{label:"", width: 50},
					{label:"", width: 50},
					{label:"", width: 50},
					{label:"", width: 50},
                ]
            },
        ],
        
        
        
        
        /*
        columns: [
                  {
                  	label: "",
                  	columns : [
                  	           {key: "timnm", label: "", width: 80},
                  	           {key: "prtnm", label: "", width: 80},
          	        ],
              	  },
                  
      					{key: "cnt_jnbno_08", label: "전기", width: 50},
      					{key: "cnt_jnbno_04", label: "온도", width: 50},
      					{key: "cnt_jnbno_05", label: "압력", width: 50},
      					{key: "cnt_jnbno_02", label: "힘", width: 50},
      					{key: "cnt_jnbno_03", label: "토크", width: 50},
      					{key: "cnt_jnbno_15", label: "속도", width: 50},
      					{key: "cnt_jnbno_11", label: "음향진동", width: 50},
      					{key: "cnt_jnbno_09", label: "질량", width: 50},
      					{key: "cnt_jnbno_06", label: "유량", width: 50},
      					{key: "cnt_jnbno_01", label: "길이", width: 50},
      					{key: "cnt_jnbno_16", label: "게이지", width: 50},
      					{key: "cnt_jnbno_17", label: "치공구", width: 50},
      					{key: "cnt_jnbno_14", label: "기타", width: 50},
      					{key: "cnt_jnbno_total", label: "계", width: 50},      
      					{
      						label: "4",
      						columns: [
      							{key: "cnt_yedat_04", label: "계획", width: 50},
      							{key: "cnt_rpdat_04", label: "실적", width: 50}      
      						],
      					
      					},
      					{
      						label: "5",
      						columns: [
      							{key: "cnt_yedat_05", label: "계획", width: 50},
      							{key: "cnt_rpdat_05", label: "실적", width: 50}      
      						],
      					
      					},
      					{
      						label: "6",
      						columns: [
      							{key: "cnt_yedat_06", label: "계획", width: 50},
      							{key: "cnt_rpdat_06", label: "실적", width: 50}      
      						],
      					
      					},
      					{
      						label: "7",
      						columns: [
      							{key: "cnt_yedat_07", label: "계획", width: 50},
      							{key: "cnt_rpdat_07", label: "실적", width: 50}      
      						],
      					
      					},
      					{
      						label: "8",
      						columns: [
      							{key: "cnt_yedat_08", label: "계획", width: 50},
      							{key: "cnt_rpdat_08", label: "실적", width: 50}      
      						],
      					
      					},
      					{
      						label: "9",
      						columns: [
      							{key: "cnt_yedat_09", label: "계획", width: 50},
      							{key: "cnt_rpdat_09", label: "실적", width: 50}      
      						],
      					
      					},
      					{
      						label: "10",
      						columns: [
      							{key: "cnt_yedat_10", label: "계획", width: 50},
      							{key: "cnt_rpdat_10", label: "실적", width: 50}      
      						],
      					
      					},
      					{
      						label: "11",
      						columns: [
      							{key: "cnt_yedat_11", label: "계획", width: 50},
      							{key: "cnt_rpdat_11", label: "실적", width: 50}      
      						],
      					
      					},
      					{
      						label: "12",
      						columns: [
      							{key: "cnt_yedat_12", label: "계획", width: 50},
      							{key: "cnt_rpdat_12", label: "실적", width: 50}      
      						],
      					
      					},
      					{
      						label: "1",
      						columns: [
      							{key: "cnt_yedat_01", label: "계획", width: 50},
      							{key: "cnt_rpdat_01", label: "실적", width: 50}      
      						],
      					
      					},
      					{
      						label: "2",
      						columns: [
      							{key: "cnt_yedat_02", label: "계획", width: 50},
      							{key: "cnt_rpdat_02", label: "실적", width: 50}      
      						],
      					
      					},
      					{
      						label: "3",
      						columns: [
      							{key: "cnt_yedat_03", label: "계획", width: 50},
      							{key: "cnt_rpdat_03", label: "실적", width: 50}      
      						],
      					
      					},
      					{key: "cnt_total", label: "계", width: 70},
      					
                
              ],*/
    });
    
    monPlanGrid.setData([]); 
    
    var picker = new ax5.ui.picker();
  //Date
	picker.bind({
        target: $('[data-picker-date="year"]'),
        direction: "top",
        content: {
            width: 270,
            margin: 10,
            type: 'date',
            config: {
            	mode: "year", 
            	selectMode: "year",
            },
            formatter: {
                pattern: 'date(year)'
            }
        },
        onStateChanged: function () {
        	if(this.state === "changeValue") {
        		$('#waf006Calendar').val(this.value.substr(0,4));
        	}
        	
        }
    });
	
	$('#waf006Calendar').on('change', function() {
		$('.waf_monPerform_wrap h1 span').text(this.value);
	});
	
	$('._searchBtn_').on('click', function() {
		if($('#waf006Calendar').val === "") {
			toastMsg("기준년월을 선택하세요.");
			return false;
		}
		//console.log($('input[name=mon]').val());
		if($('input[name=mon]:checked').val() === '01') {
			monPlanGrid.setConfig({
				columns: [
						
                     {
                     	label: "",
                     	columns : [
                     	           {key: "timnm", label: "", width: 80},
                     	           {key: "prtnm", label: "部署", width: 110},
             	        ],
                 	},
                     {
                     	label: "較正 品目 月別 現況",
                 		columns: [
         					{key: "cnt_jnbno_08", label: "전기", width: 50},
         					{key: "cnt_jnbno_04", label: "온도", width: 50},
         					{key: "cnt_jnbno_05", label: "압력", width: 50},
         					{key: "cnt_jnbno_02", label: "힘", width: 50},
         					{key: "cnt_jnbno_03", label: "토크", width: 50},
         					{key: "cnt_jnbno_15", label: "속도", width: 50},
         					{key: "cnt_jnbno_11", label: "<p style='top: 7px;position: absolute;left: 12px;'>음향<br>진동</p>", width: 50},
         					{key: "cnt_jnbno_09", label: "질량", width: 50},
         					{key: "cnt_jnbno_06", label: "유량", width: 50},
         					{key: "cnt_jnbno_01", label: "길이", width: 50},
         					{key: "cnt_jnbno_16", label: "게이지", width: 50},
         					{key: "cnt_jnbno_17", label: "치공구", width: 50},
         					{key: "cnt_jnbno_14", label: "기타", width: 50},
         					{key: "cnt_jnbno_total", label: "계", width: 50},      
         					{
         						label: "1",
         						columns: [
         							{key: "cnt_yedat_04", label: "계획", width: 50},
         							{key: "cnt_rpdat_04", label: "실적", width: 50}      
         						],
         					
         					},
         					{
         						label: "2",
         						columns: [
         							{key: "cnt_yedat_05", label: "계획", width: 50},
         							{key: "cnt_rpdat_05", label: "실적", width: 50}      
         						],
         					
         					},
         					{
         						label: "3",
         						columns: [
         							{key: "cnt_yedat_06", label: "계획", width: 50},
         							{key: "cnt_rpdat_06", label: "실적", width: 50}      
         						],
         					
         					},
         					{
         						label: "4",
         						columns: [
         							{key: "cnt_yedat_07", label: "계획", width: 50},
         							{key: "cnt_rpdat_07", label: "실적", width: 50}      
         						],
         					
         					},
         					{
         						label: "5",
         						columns: [
         							{key: "cnt_yedat_08", label: "계획", width: 50},
         							{key: "cnt_rpdat_08", label: "실적", width: 50}      
         						],
         					
         					},
         					{
         						label: "6",
         						columns: [
         							{key: "cnt_yedat_09", label: "계획", width: 50},
         							{key: "cnt_rpdat_09", label: "실적", width: 50}      
         						],
         					
         					},
         					{
         						label: "7",
         						columns: [
         							{key: "cnt_yedat_10", label: "계획", width: 50},
         							{key: "cnt_rpdat_10", label: "실적", width: 50}      
         						],
         					
         					},
         					{
         						label: "8",
         						columns: [
         							{key: "cnt_yedat_11", label: "계획", width: 50},
         							{key: "cnt_rpdat_11", label: "실적", width: 50}      
         						],
         					
         					},
         					{
         						label: "9",
         						columns: [
         							{key: "cnt_yedat_12", label: "계획", width: 50},
         							{key: "cnt_rpdat_12", label: "실적", width: 50}      
         						],
         					
         					},
         					{
         						label: "10",
         						columns: [
         							{key: "cnt_yedat_01", label: "계획", width: 50},
         							{key: "cnt_rpdat_01", label: "실적", width: 50}      
         						],
         					
         					},
         					{
         						label: "11",
         						columns: [
         							{key: "cnt_yedat_02", label: "계획", width: 50},
         							{key: "cnt_rpdat_02", label: "실적", width: 50}      
         						],
         					
         					},
         					{
         						label: "12",
         						columns: [
         							{key: "cnt_yedat_03", label: "계획", width: 50},
         							{key: "cnt_rpdat_03", label: "실적", width: 50}      
         						],
         					
         					},
         					{key: "cnt_total", label: "계", width: 70},
         					{label:"", width: 50},
         					{label:"", width: 50},
         					{label:"", width: 50},
         					{label:"", width: 50},
         					{label:"", width: 50},
         					{label:"", width: 50},
         					{label:"", width: 50},
         					{label:"", width: 50},
         					{label:"", width: 50},
         					{label:"", width: 50},
         					{label:"", width: 50},
         					{label:"", width: 50},
                         ]
                     }
         	]
			});
		} else {
			monPlanGrid.setConfig({
				columns: [
						
		                     {
		                     	label: "",
		                     	columns : [
		                     	           {key: "timnm", label: "", width: 80},
		                     	           {key: "prtnm", label: "部署", width: 110},
		             	        ],
		                 	},
		                     {
		                     	label: "較正 品目 月別 現況",
		                 		columns: [
									{key: "cnt_jnbno_08", label: "전기", width: 50},
									{key: "cnt_jnbno_04", label: "온도", width: 50},
									{key: "cnt_jnbno_05", label: "압력", width: 50},
									{key: "cnt_jnbno_02", label: "힘", width: 50},
									{key: "cnt_jnbno_03", label: "토크", width: 50},
									{key: "cnt_jnbno_15", label: "속도", width: 50},
									{key: "cnt_jnbno_11", label: "<p style='top: 7px;position: absolute;left: 12px;'>음향<br>진동</p>", width: 50},
									{key: "cnt_jnbno_09", label: "질량", width: 50},
									{key: "cnt_jnbno_06", label: "유량", width: 50},
									{key: "cnt_jnbno_01", label: "길이", width: 50},
									{key: "cnt_jnbno_16", label: "게이지", width: 50},
									{key: "cnt_jnbno_17", label: "치공구", width: 50},
									{key: "cnt_jnbno_14", label: "기타", width: 50},
									{key: "cnt_jnbno_total", label: "계", width: 50},      
									{
										label: "4",
										columns: [
											{key: "cnt_yedat_04", label: "계획", width: 50},
											{key: "cnt_rpdat_04", label: "실적", width: 50}      
										],
									
									},
									{
										label: "5",
										columns: [
											{key: "cnt_yedat_05", label: "계획", width: 50},
											{key: "cnt_rpdat_05", label: "실적", width: 50}      
										],
									
									},
									{
										label: "6",
										columns: [
											{key: "cnt_yedat_06", label: "계획", width: 50},
											{key: "cnt_rpdat_06", label: "실적", width: 50}      
										],
									
									},
									{
										label: "7",
										columns: [
											{key: "cnt_yedat_07", label: "계획", width: 50},
											{key: "cnt_rpdat_07", label: "실적", width: 50}      
										],
									
									},
									{
										label: "8",
										columns: [
											{key: "cnt_yedat_08", label: "계획", width: 50},
											{key: "cnt_rpdat_08", label: "실적", width: 50}      
										],
									
									},
									{
										label: "9",
										columns: [
											{key: "cnt_yedat_09", label: "계획", width: 50},
											{key: "cnt_rpdat_09", label: "실적", width: 50}      
										],
									
									},
									{
										label: "10",
										columns: [
											{key: "cnt_yedat_10", label: "계획", width: 50},
											{key: "cnt_rpdat_10", label: "실적", width: 50}      
										],
									
									},
									{
										label: "11",
										columns: [
											{key: "cnt_yedat_11", label: "계획", width: 50},
											{key: "cnt_rpdat_11", label: "실적", width: 50}      
										],
									
									},
									{
										label: "12",
										columns: [
											{key: "cnt_yedat_12", label: "계획", width: 50},
											{key: "cnt_rpdat_12", label: "실적", width: 50}      
										],
									
									},
									{
										label: "1",
										columns: [
											{key: "cnt_yedat_01", label: "계획", width: 50},
											{key: "cnt_rpdat_01", label: "실적", width: 50}      
										],
									
									},
									{
										label: "2",
										columns: [
											{key: "cnt_yedat_02", label: "계획", width: 50},
											{key: "cnt_rpdat_02", label: "실적", width: 50}      
										],
									
									},
									{
										label: "3",
										columns: [
											{key: "cnt_yedat_03", label: "계획", width: 50},
											{key: "cnt_rpdat_03", label: "실적", width: 50}      
										],
				                     }
								]
		                     }
                 	]
			});
		}
		
		var params = {
				comps: $('#ComboBoxPlant').val(),
				year : $('#waf006Calendar').val(),
				mon  : $('input[name=mon]:checked').val(),
				g_gub: $('input[name=g_gub]:checked').val(),
		};	
		
		$.ajax({
			type    :"POST",
			url     :"/WAF006PsogmMonPerform/getGridVal.do",
			data    : params,
			success : function(res) {
				//console.log(res);
				try{
					var data = JSON.parse(res);
					if(data.result === RESULT_Y) {
//						monPlanGrid.target.setData(data.list);
						//console.log(monPlanGrid);
						//console.log(monPlanGrid.target);
						monPlanGrid.setData(data.list);
					} else {
						toastMsg("데이터가 없습니다.");
					}
					
				} catch(e) {
					//console.log(e);
				}
			},
			errors  : function(res) {
				toastMsg(res);
			},
			complete: function(res) {
				//console.log(res);
			}
		});
	});
	
	 $('._excelBtn_').click(function () {
		 monPlanGrid.exportExcel("grid-to-excel.xls");
     });
    
});