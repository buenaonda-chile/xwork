var moldGrid = {
		initView: function() {
			this.target = new ax5.ui.grid();
			this.target.setConfig({
				target : $('[data-ax5grid="mold-grid"]'),
				showLineNumber: true,
				header : {
					align: "center",
				},
				columns: [
				          {
				        	  key : "itmno",
				        	  label : "품번",
				        	  width: 150,
				          },
				          {
				        	  key : "itmnm",
				        	  label : "품명",
				        	  width: 250,
				          },
				          {
				        	  key : "wrknm",
				        	  label : "작업번호",
				        	  width: 100,
				          },
				          {
				        	  key : "gubcd",
				        	  label : "이력구분",
				        	  width: 100,
				          },
				          {
				        	  label : "진척률 %",
				        	  columns: [
		        	             {key : "wrktmp", label : "계획", width : 50, align : "center"},
		        	             {key : "wrktms", label : "실적", width : 50, align : "center"},
		        	             {key : "g", label : "차이", width : 50, align : "center",
		        	            	 formatter : function() {
		        	            		 return Number(this.item.wrktmp - this.item.wrktms);
		        	            	 },
		        	            	 styleClass : function () {
		        	            		 if(Number(this.item.wrktmp - this.item.wrktms) < 0.01) {
		        	            			 return "limeColor";
		        	            		 } else if (Number(this.item.wrktmp - this.item.wrktms) >= 0.01 || Number(this.item.wrktmp - this.item.wrktms) > 0.3) {
		        	            			 return "yellowColor";
		        	            		 } else if (Number(this.item.wrktmp - this.item.wrktms) >= 0.3) {
		        	            			 return "redColor";
		        	            		 }
		        	            	 }
		        	             },
	        	              ],
				          },
				          {
				        	  key : "pwkdth",
				        	  label : "완료예정일자",
				        	  width: 100,
				        	  align : "center",
				        	  formatter : function() {
				        		  ////console.log(this.value);
				        		  //console.log(typeof this.value)
				        		  if (this.value === 'null' || this.value === '0') {
				        			  return '00 - 00 - 00';
				        		  } else {
				        			  return this.value.substr(0,4) + " - " + this.value.substr(4,2) + this.value.substr(6,2);
				        		  }  
				        	  },
				        	  
				          },
				          {
				        	  key : "inttx",
				        	  label : "현황",
				        	  width: 200,
				          },
	            ],
			});
		},
		setData : function() {
			
		}
};


function search() {
	mask.open();
	var params = $('#psfacForm').serialize();
	//console.log(params);
	$.ajax({
		type : "POST",
		url : "/WAF012PsfacSearch/getGridVal.do",
		data : params,
		success : function(res) {
			//console.log(res);
			var data = JSON.parse(res);
			try {
				if(data.result === RESULT_Y) {
					moldGrid.target.setData(data.list);
				} else {
					toastMsg("데이터가 없습니다.");
					moldGrid.target.setData([]);
				}
			} catch (e) {
				//console.log(e);
			}
		},
		error : function(res) {
			//console.log(res);
		},
		complete : function() {
			mask.close();
		}
	});
}

$(document.body).ready(function() {
	mask.close();
	moldGrid.initView();
	search();
	
	//갱신
	$('#replayTime').on('change', function() {
		if(this.value !== "0") {
			myInterval = setInterval(search, this.value * 1000);
		} else {
			clearInterval(myInterval);
		}
	});
	
	$('._searchBtn_').on('click', function() {
		search();
	});
	
	 $('._excelBtn_').click(function () {
		 moldGrid.target.exportExcel("Psfac-excel.xls");
     });
});