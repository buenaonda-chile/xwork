var normalGrid = {
	initView: function() {
		this.target = new ax5.ui.grid();
		this.target.setConfig({
			target : $('[data-ax5grid="normal-grid"]'),
			showLineNumber: true,
			header: {
	            align: "center"
	        },
	        body: {
	        	align: "center",
	        },
	        columns:
        	[
        	 	{label: "업체번호", key: "indat", width: 100},
        	 	{label: "발주구분", key: "indat", width: 100},
        	 	{label: "발주년월", key: "indat", width: 100},
        	 	{label: "발주순번", key: "indat", width: 100},
        	 	{label: "발주번호", key: "indat", width: 100},
        	 	{label: "업체코드", key: "indat", width: 100},
        	 	{label: "부품번호", key: "indat", width: 100},
        	 	{label: "K부품번호", key: "indat", width: 100},
        	 	{label: "현/기 구분", key: "indat", width: 100},
        	 	{label: "발주처", key: "indat", width: 100},
        	 	{label: "납품처", key: "indat", width: 100},
        	 	{label: "발주구분", key: "indat", width: 100},
        	 	{label: "발주진행", key: "indat", width: 100},
        	 	{label: "밣주유형", key: "indat", width: 100},
        	 	{label: "발주수량", key: "indat", width: 100},
        	 	{label: "선납입고량", key: "indat", width: 100},
        	 	{label: "납기전정상", key: "indat", width: 100},
        	 	{label: "납기후정상", key: "indat", width: 100},
        	 	{label: "후납입고량", key: "indat", width: 100},
        	 	{label: "납기전취소", key: "indat", width: 100},
        	 	{label: "납기후취소", key: "indat", width: 100},
        	 	{label: "클레임수량", key: "indat", width: 100},
        	 	{label: "발주일자", key: "indat", width: 100},
        	 	{label: "납기일자", key: "indat", width: 100},
        	 	{label: "요청일자", key: "indat", width: 100},
        	 	{label: "단가", key: "indat", width: 100},
        	 	{label: "발주타입", key: "indat", width: 100},
        	 	{label: "차종", key: "indat", width: 100},
        	 	{label: "재고등급", key: "indat", width: 100},
        	 	{label: "풍성품번", key: "indat", width: 100},
        	 	{label: "규격코드", key: "indat", width: 100},
        	 	{label: "차종코드", key: "indat", width: 100},
        	 	{label: "서열코드", key: "indat", width: 100},
        	 ],
		});
	}	
};
var	errorGrid = {
		initView: function() {
			this.target = new ax5.ui.grid();
			this.target.setConfig({
				target : $('[data-ax5grid="error-grid"]'),
				showLineNumber: true,
				header: {
		            align: "center"
		        },
		        body: {
		        	align: "center",
		        },
		        columns:
	        	[
	        	 	{label: "업체번호", key: "indat", width: 100},
	        	 	{label: "발주구분", key: "indat", width: 100},
	        	 	{label: "발주년월", key: "indat", width: 100},
	        	 	{label: "발주순번", key: "indat", width: 100},
	        	 	{label: "발주번호", key: "indat", width: 100},
	        	 	{label: "업체코드", key: "indat", width: 100},
	        	 	{label: "부품번호", key: "indat", width: 100},
	        	 	{label: "K부품번호", key: "indat", width: 100},
	        	 	{label: "현/기 구분", key: "indat", width: 100},
	        	 	{label: "발주처", key: "indat", width: 100},
	        	 	{label: "납품처", key: "indat", width: 100},
	        	 	{label: "발주구분", key: "indat", width: 100},
	        	 	{label: "발주진행", key: "indat", width: 100},
	        	 	{label: "밣주유형", key: "indat", width: 100},
	        	 	{label: "발주수량", key: "indat", width: 100},
	        	 	{label: "선납입고량", key: "indat", width: 100},
	        	 	{label: "납기전정상", key: "indat", width: 100},
	        	 	{label: "납기후정상", key: "indat", width: 100},
	        	 	{label: "후납입고량", key: "indat", width: 100},
	        	 	{label: "납기전취소", key: "indat", width: 100},
	        	 	{label: "납기후취소", key: "indat", width: 100},
	        	 	{label: "클레임수량", key: "indat", width: 100},
	        	 	{label: "발주일자", key: "indat", width: 100},
	        	 	{label: "납기일자", key: "indat", width: 100},
	        	 	{label: "요청일자", key: "indat", width: 100},
	        	 	{label: "단가", key: "indat", width: 100},
	        	 	{label: "발주타입", key: "indat", width: 100},
	        	 	{label: "차종", key: "indat", width: 100},
	        	 	{label: "재고등급", key: "indat", width: 100},
	        	 	{label: "풍성품번", key: "indat", width: 100},
	        	 	{label: "규격코드", key: "indat", width: 100},
	        	 	{label: "차종코드", key: "indat", width: 100},
	        	 	{label: "서열코드", key: "indat", width: 100},
	        	 ],
			});
		}		
};

$(document.body).ready(function() {
	
	normalGrid.initView();
	errorGrid.initView();
	
	$('._excelBtn_').on('click', function() {
		if(this.getAttribute("data-target") === "normal") {
			normalGrid.target.exportExcel("Host Up 정상List.xls");
		} else {
			errorGrid.target.exportExcel("Host Up Error List.xls");
		}
	});
	
});