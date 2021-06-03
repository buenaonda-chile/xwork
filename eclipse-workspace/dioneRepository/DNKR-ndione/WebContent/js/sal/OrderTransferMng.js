//code intellisense typescript 정의
///<reference path = "../../wijmo/controls/wijmo.d.ts"/>	
///<reference path = "../../wijmo/controls/wijmo.grid.d.ts"/>
///<reference path = "../../wijmo/controls/wijmo.input.d.ts"/>


// 컬랙션 뷰는 조회후에 그리드의 상태변경을 체크한다. 
var cv = new wijmo.collections.CollectionView(null);	//컬랙션뷰 전역변수


var flexGrid = new wijmo.grid.FlexGrid('#wijmoGrid');	//그리드 전역변수
var zoomSize = 11;
/**
 조회버튼
 */
function search(){
	/*
	if(!$(".getComps").val()){
		toastMsg(LN_SELECT_COMPS);
		return false;
	}else if(!$(".getPlndt").val()){
		toastMsg(LN_SELECT_PLNDT);
		return false;
	}
	*/
	if(!$(".getPlndt").val()){
		toastMsg(LN_SELECT_PLNDT);
		return false;
	}
	
	var url = '/ajaxOrderTransferMng/search.do';
	var params = {
		'getComps' : $(".getComps").val(),
		'getPyvnd' : $(".getPyvnd").val(),
		'getPlndt' : $(".getPlndt").val()
	};
	
	mask.open();
	$.ajax({
		method : "post",
		url : url,
		data :params,
		success : function(res) {
			var data = JSON.parse(res).list;
			cv.sourceCollection = data;
						
		},
		error : function() {
			console.log("dataset.error");
			
		},
		complete : function() {
			//console.log("dataset.completed");
			setTimeout(function() {
				mask.close();				
			}, 500);
			
		}
	});
	
}


/**
 * 업체코드로 업체명 검색하여 데이터 set
 * 
 * @param 업체코드
 */
function getCustSch(gubn, value,s,e) {
	if(value != ""){
		
		$.ajax({
			method : "post",
			url : "/ajaxCustomer/search.do",
			data : {
				"getCusno" : value,
				"getComps" : $("#getComps").val()
			},
			success : function(res) {
				var data = JSON.parse(res);			
				
				if (data.list.length > 0) {
					if(gubn == "input") $('#getCusnm').val(data.list[0].cusnm);
				}
				else {
					toastMsg(LN_IO_CHK1 + " : " + value);
					if(gubn == "input") {
						$('#getPyvnd').val("");
					}
					if(gubn == "grid"){
						/*
						var oldValue = s.getCellData(e.row,5,false);
						if(oldValue == "" || oldValue == null || oldValue == undefined) oldValue = "0"; // dataType:'Number' 에는 공백 초기화가 안됨.
						s.setCellData(e.row,e.col,oldValue);
						*/
					} 
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
		var custObj = JSON.parse(returnValue);

		$('#getPyvnd').val(custObj.cusno);
		$('#getCusnm').val(custObj.cusnm);
	}
}



/**
	버튼 이벤트 처리
 */
function handleEvent(){
	
		
	$('.getPyvnd').on('change', function() {
		$(".getCusnm").val("");
	});

	
}


/**
  그리드 초기화
 */
function gridInit() {
	
	/**
	 * grid 셋팅
	 * gridCommon.js 에서 공통으로 처리되있는 옵션을 변경하고 싶다면 gridInit 함수에서 바꾸고싶은 옵션만 재정의 하면됨.
	 */
	//컬럼정의
	columnsDefinition = [
		{binding:'comps',visible:false},
	    {binding:'pyvnd',visible:false},
	    {binding:'plndt',visible:false},
	    {binding:'stcd1',visible:false},
	    {binding:'stcd2',visible:false},
	    {binding:'stcd3',visible:false},
	    {binding:'magdt',visible:false},
	    {binding:'magtm',visible:false},
	    {binding: 'comps', header: '사업부코드', width: '*', align:'center', isReadOnly: true},  //wordWrap: true: 텍스트 자동줄바꿈 autorowHeights랑 같이 사용
	    {binding: 'pyvnd', header: '업체코드', width: '*', align:'center', isReadOnly: true},
	    {binding: 'plndt', header: '처리일자', width: '*', align:'center', isReadOnly: true },
	    {binding: 'stcd1', header: '서열', width: '*', align:'center', isReadOnly: true},
	    {binding: 'stcd2', header: '비서열', width: '*', align:'center', isReadOnly: true},
	    {binding: 'stcd3', header: '확정오더', width: '*', align:'center', isReadOnly: true},
	    {binding: 'magdt', header: '최종갱신일자', width: '*', align:'center', isReadOnly: true},
	    {binding: 'magtm', header: '최종갱신기간', width: '*', align:'center', isReadOnly: true}
		// 콤보박스 추가하려면 dataMap
	];
	//컬럼 초기화
	flexGrid.initialize({
		columns: columnsDefinition
	});
	
}

function gridEvent(){
	
}

function getToday(){
	var date = new Date();
	return date.getFullYear() + "-" + ("0"+(date.getMonth()+1)).slice(-2) + "-" + ("0"+date.getDate()).slice(-2);
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
	
	$('.gridContents .dropdown').on('click', function(e){
		$($(e.target).next('.dropdown-menu')).css('display', 'block');
	});
	
	//그리드 공통js 호출 후에 나머지 함수 호출함.
	$.getScript('/js/sal/gridCommon.js').done(function() {
		
		commonGrid.init(flexGrid,cv); //그리드 공통부분
		
		gridInit();  	//그리드 초기화
		gridEvent();	//그리드 이벤트
		handleEvent();	//프로그램 버튼 이벤트	
		
		// 처리일자 오늘날짜로 셋팅
		var nowDate = getToday();
		$('#getPlndt').val(nowDate);	
		
	});
	
	
});

