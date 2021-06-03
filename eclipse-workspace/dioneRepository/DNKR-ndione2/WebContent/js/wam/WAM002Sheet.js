
var shipGrid;

function searchSubmit() {
	console.log('search clicked');
	//$('#WAM001ContractSearchForm').submit();
	$('.tipMsg').remove();
	getData();
}


function getData(type){
	
	var frm = document.searchForm;
	var searchDate = frm.searchDate.value;
    
    if(searchDate == ''){
    	alert('조회일자를 선택해주세요.');
    	return;
    }
    
    $.ajax({
		method : "POST",
		async: false,
		cashe: false,
		url : "/ajaxSheet/getWinusData.do",
		data : {
			searchDate: searchDate
		},
		success : function(res) {
			//console.log('res : ' + res);
			var resData = JSON.parse(res);
			var cnt = resData.cnt;
			
			if(cnt > 0){
				var columns = resData.columns_arr;
				var data = resData.data;
				
				//그리드 세로스크롤 없애기
				var gridHeight = (data.length * 80 + 100) + "px";
				$('.gridWarp').css("height", gridHeight);
				tabResize();
				
				initView(columns);
				shipGrid.appendToList(data);
			}else{
				$('.gridWarp').css("height", "500px");
				tabResize();
				toastMsg('조회된 데이터가 없습니다.');
				var columns = [];
				initView(columns);
			}
			
		},
		error : function(res) {
			//console.log("error");
			console.log(res);
		},
		complete : function(res) {
			setTimeout(function() {
				mask.close();
			}, 1000);
		}
	});
    
}

function gridStyle() {
	if(Number(this.item[this.key]) < 0) {
		return "textColorRed";
	}
}

function initView(columns){
	columns.forEach(function (item, index) {
//		if(item.styleClass !== undefined) {
//				item.styleClass = gridStyle;
//		}
		if(item.columns !== undefined) {
			item.columns.forEach(function(inItem, inIndex) {
//				if(inItem.styleClass !== undefined) {
//					inItem.styleClass = gridStyle;
//				}
				
				if(inItem.columns !== undefined) {
					inItem.columns.forEach(function (lastItem, lastIndex) {
						lastItem.styleClass = gridStyle;
					});
				} 
			});
		}
		
	});
	shipGrid = new ax5.ui.grid({
		target : $('[data-ax5grid="ship-grid"]'),
		showLineNumber: true,
		header: {
            align: "center"
        },
        body: {
        	align: "center",
        },
        columns: columns
    });
	
//	console.log('initView : ' + columns);
//	console.log(columns);
}

$(document.body).ready(function() {
	
	//조회버튼 클릭
	$('._searchBtn_').on('click', function(){
		searchSubmit();
	});
	
	var Calendar1 = new ax5.ui.calendar({
        target: document.getElementById("calendar_where1"),
        control: {
            left: '<i class="fa fa-chevron-left"></i>',
            yearTmpl: '%s',
            monthTmpl: '%s',
            right: '<i class="fa fa-chevron-right"></i>',
            yearFirst: true
        },
        displayDate: (new Date()),
        lang: {
        	yearTmpl: YEAR_FORMAT,
        	months: MONTH,
        	dayTmpl: "%s"
        },
        dimensions: {
            height: 250,
            controlHeight: 50,
            itemPadding: 5
        },
        onClick: function () {
        	var date = this.self.getSelection();
       	 	$(this.target).css('display', 'none');
            $(this.target).prev().val(date);
            $('#lblselfield1').val(date);
        },
        onStateChanged: function () {
            //console.log(this);
        }
    });

	$(' .dropdown').on('click', function(e){
		console.log('dropdown');
		$($(e.target).closest('.dropdown').find('.dropdown-menu')).css('display', 'block');
	});
	
	$('._excelBtn_').on('click', function() {
		if(shipGrid){
			shipGrid.exportExcel("과부족시트.xls");
		}else{
			alert('조회된 데이터가 없습니다.');
		}
		
	});
	
});