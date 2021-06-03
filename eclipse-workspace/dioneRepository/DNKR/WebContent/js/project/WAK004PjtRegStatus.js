/**
 * 
 * @param type
 * @param relationCode
 */
function setData(type, relationCode){
	//console.log("setData()");
	$.ajax({
		method : "post",
		url : "/ajaxRelation/init.do",
		data : {
			type: type,
			parentCode: relationCode,			
		},
		success : function(res) {
			//console.log(res);
			var data = JSON.parse(res);
			if (data.list.length > 0) {
				
				//조회 select 외의 데이터 초기화
				if(type === "LOC") {
//					teamCode 리스트 초기화
					$('select.teamCode').html('<option value="">부서(팀)전체</option>');
					var listStr = "<option value=''>사업장전체</option>";
					data.list.forEach(function(item, index){
						listStr += '<option value="'+ item.relationCode +'">'+item.relationName+'</option>';	
					});
					
					$('select.locCode').html(listStr);
				} else if(type === "TEAM") {
					var listStr = "<option value=''>부서(팀)전체</option>";
					data.list.forEach(function(item, index){
						listStr += '<option value="'+ item.relationCode +'">'+item.relationName+'</option>';	
					});
					
					$('select.teamCode').html(listStr);
				}
				setTimeout(function() {
					mask.close();
				}, 1000);
			} else {
				
				//하위그리드 데이터 조회일 때 초기화
				if(type === "LOC") {
//					locCode에 리스트 초기화
					$('select.locCode').html('<option>사업장전체</option>');
//					teamCode에 리스트 초기화
					$('select.teamCode').html('<option>부서(팀)전체</option>');
					
					//사업부서 등록 시 상위코드로 사용할 사업장 코드 초기화
					currLocCode = "";
					
				} else if(type === "TEAM"){
//					teamCode에 리스트 초기화
					$('select.teamCode').html('<option>부서(팀)전체</option>');
				}
				
				setTimeout(function() {
					mask.close();
					toastMsg("데이터가 없습니다.");
				}, 1000);
			}
		},
		error : function(res) {
			//console.log("error");
			//console.log(res);
		},
		complete : function(res) {
			setTimeout(function() {
				mask.close();
			}, 1000);
		}
	});
	//console.log('ajaxend');
	// return true;
}

$(function() {
	mask.close();
	var myCalendar = new ax5.ui.calendar({
        target: document.getElementById("calendar-target"),
        control: {
            left: '<i class="fa fa-chevron-left"></i>',
            yearTmpl: '%s',
            monthTmpl: '%s',
            right: '<i class="fa fa-chevron-right"></i>',
            yearFirst: true
        },
        displayDate: (new Date()),
        lang: {
        	/*yearTmpl: "%s년",*/
            /*months: ['일월', '이월', '삼월', '사월', '오월', '육월', '칠월', '팔월', '구월', '시월', '십일월', '십이월'],*/
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
            //console.log(this);
            //console.log(myCalendar.getSelection());
            $(this.target).css('display', 'none');
            $(this.target).prev().val(myCalendar.getSelection());
//            $('#pjtSearchForm').submit();
        },
        onStateChanged: function () {
            //console.log(this);
        }
    });
	
	$('.pjt-wrap .dropdown').on('click', function(e){
		//console.log($(e.target));
		//console.log($($(e.target).next('.dropdown-menu')));
		$($(e.target).next('.dropdown-menu')).css('display', 'block');
	});
	
	$('.uM_search .dropdown').on('click', function(e){
		//console.log($(e.target));
		//console.log($($(e.target).next('.dropdown-menu')));
		$($(e.target).next('.dropdown-menu')).css('display', 'block');
	});
	
	//사업부 셀렉트박스의 값이 변경될때  
	$('select.clsCode').change(function(){
		//console.log('select changed');
		var currClsCode = this.value;
		setData('LOC', currClsCode);
	});
	
	//사업장 셀렉트박스의 값이 변경될때  
	$('select.locCode').change(function(){
		//console.log('select changed');
		var currLocCode = this.value;
		setData('TEAM', currLocCode);
	});
	
	//사업부서(팀) 셀렉트박스의 값이 변경될때  
	$('select.teamCode').change(function(){
		var teamClsCode = this.value;
		//console.log('select changed');
	});
	
	$('._searchBtn_').on('click', function(e){
		//console.log('search clicked');
		var divEl = $(e.target).closest('div');
		//console.log(divEl);
		if(val_chk(divEl.find('#searchDate').val(), '조회일자')	){
			mask.open();
			$('#empDomain').submit();
		}
		return false;
	});
	
	
})