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
				} else if(type === "EMP") {
					var listStr = "<option value=''>성명</option>";
					data.list.forEach(function(item, index){
						listStr += '<option value="'+ item.empNumber +'">'+item.empName+'</option>';	
					});
					
					$('select.empNumber').html(listStr);
				}
				
				
				
				
				setTimeout(function() {
					mask.close();
				}, 1000);
			} else {
				
				//하위그리드 데이터 조회일 때 초기화
				if(type === "LOC") {
//					locCode에 리스트 초기화
					$('select.locCode').html('<option value="">사업장전체</option>');
//					teamCode에 리스트 초기화
					$('select.teamCode').html('<option value="">부서(팀)전체</option>');
					
					//사업부서 등록 시 상위코드로 사용할 사업장 코드 초기화
					currLocCode = "";
					
				} else if(type === "TEAM"){
//					teamCode에 리스트 초기화
					$('select.teamCode').html('<option value="">부서(팀)전체</option>');
				} else if(type === "EMP"){
//					teamCode에 리스트 초기화
					$('select.empNumber').html('<option value="">성명</option>');
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
	tabResize();
	
	$('.list-top .dropdown').on('click', function(e){
		$($(e.target).closest('div.pr20').find('.dropdown-menu')).css('display', 'block');
	});
	
	var personal_calendar = new ax5.ui.calendar({
        target: document.getElementById("calendar-personalDetail"),
        control: {
            left: '<i class="fa fa-chevron-left"></i>',
            yearTmpl: '%s',
            monthTmpl: '%s',
            right: '<i class="fa fa-chevron-right"></i>',
            yearFirst: true
        },
        displayDate: (new Date()),
        multipleSelect: 2,
        dimensions: {
            height: 250,
            controlHeight: 50,
            itemPadding: 5
        },
        lang: {
        	/*yearTmpl: "%s년",*/
            /*months: ['일월', '이월', '삼월', '사월', '오월', '육월', '칠월', '팔월', '구월', '시월', '십일월', '십이월'],*/
        	yearTmpl: YEAR_FORMAT,
        	months: MONTH,
        	dayTmpl: "%s"
        },
        onClick: function () {
        	var dates = this.self.getSelection();
            
            if (dates.length > 1) {
                var minDate = new Date(Math.min(ax5.util.date(dates[0]).getTime(), ax5.util.date(dates[1]).getTime()));
                var maxDate = new Date(Math.max(ax5.util.date(dates[0]).getTime(), ax5.util.date(dates[1]).getTime()));
                if(dates[0] < dates[1]) {
                	$(this.target).prev().val(dates[0]);
                    $($(this.target).closest('div.dropdown').next()).find('input').val(dates[1]);
                } else {
                	$(this.target).prev().val(dates[1]);
                    $($(this.target).closest('div.dropdown').next()).find('input').val(dates[0]);
                }
                
                this.self.setPeriod({
                    range: [
                        {from: minDate, to: maxDate, fromLabel: '', toLabel: ''}
                    ]
                });
                $(this.target).css('display', 'none');
            } else {
            	$(this.target).prev().val(dates[0]);
            }
            
        },
        onStateChanged: function () {
            //console.log(this);
        }
    });
	
	/*
	//사업부 셀렉트박스의 값이 변경될때  
	$('select.clsCode').change(function(){
		//console.log('select changed');
		var currClsCode = this.value;
		$('#clsCode').val(currClsCode);
		currLocCode = null;
		currTeamCode = null;
		currEmpNum = null;
		setData('LOC', currClsCode);
	});
	*/
	
	//사업장 셀렉트박스의 값이 변경될때  
	$('select.locCode').change(function(){
		//console.log('select changed');
		var currLocCode = this.value;
		$('#locCode').val(currLocCode);
		currTeamCode = null;
		currEmpNum = null;
		setData('TEAM', currLocCode);
	});
	
	//사업부서(팀) 셀렉트박스의 값이 변경될때  
	$('select.teamCode').change(function(){
		var currTeamCode = this.value;
		//console.log('select changed');
		//console.log('currTeamCode:' + currTeamCode);
		currEmpNum = null;
		setData('EMP', currTeamCode);
	});
	
	//조회버튼 클릭
	$('._searchBtn_').on('click', function(e){
		var divEl = $(e.target).closest('div');
		//console.log('search clicked');
		//console.log(divEl.find('select#empNumber').val());
		if(val_chk(divEl.find('select#empNumber').val(), '성명')
				& val_chk(divEl.find('select#teamCode').val(), '부서(팀)')
				& val_chk(divEl.find('select#locCode').val(), '사업장')
//				& val_chk(divEl.find('select#clsCode').val(), '사업부')
				& val_chk(divEl.find('#endDate').val(), '마지막 날짜')
				& val_chk(divEl.find('#startDate').val(), '시작 날짜')) {
			$('#pjtDomain').submit();
		}
	});
	
	//업무분류(대), (중), (소), 관련시스템 버튼 클릭
	$('ul.pj-smtab li').on('click', function(e) {
		var divEl = $('#searchBoxDiv');
		var worktype = $(e.target).attr('data-click');
		//console.log(worktype);
		$('input#workType').val(worktype);
		//console.log('search clicked');
		//console.log(divEl.find('select#empNumber').val());
		if(val_chk(divEl.find('select#empNumber').val(), '성명')
				& val_chk(divEl.find('select#teamCode').val(), '부서(팀)')
				& val_chk(divEl.find('select#locCode').val(), '사업장')
//				& val_chk(divEl.find('select#clsCode').val(), '사업부')
				& val_chk(divEl.find('#endDate').val(), '마지막 날짜')
				& val_chk(divEl.find('#startDate').val(), '시작 날짜')) {
			$('#pjtDomain').submit();
		}
	});
})