var currClsCode,
	currLocCode,
	currTeamCode;

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
		type: 'post',
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
					$('select.locCode').html('<option value="">사업장전체</option>');
//					teamCode에 리스트 초기화
					$('select.teamCode').html('<option value="">부서(팀)전체</option>');
					
					//사업부서 등록 시 상위코드로 사용할 사업장 코드 초기화
					currLocCode = "";
					
				} else if(type === "TEAM"){
//					teamCode에 리스트 초기화
					$('select.teamCode').html('<option value="">부서(팀)전체</option>');
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

$(document).ready(function() {
	var log_calendar = new ax5.ui.calendar({
        target: document.getElementById("log_calendar"),
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
            console.log(this);
        }
    });
	
	$('.log_board .dropdown').on('click', function(e){
		$($(e.target).closest('div.fl').find('.dropdown-menu')).css('display', 'block');
	});
	
	//사업부서(팀) autocomplete 리스트
	$('#workAutoComplete').on('click', function(e) {
		console.log("autocomplete2.click");
		console.log(e.target);
		var divEl = $(e.target).closest('.searchWrap');
		var workMCode = divEl.find('select#workMCode').val() + "";
		console.log(divEl);
		console.log("workMCode:" + workMCode);
		if( workMCode.trim().length === 0 || workMCode === null || workMCode === "null" || workMCode === "undefined" || workMCode === undefined){
			toastMsg('업무분류(대), 업무분류(소)를 먼져 선택해주세요');
			options = [];
			return;
		}
		var params = {
				"type": "S",
				"upperCode": workMCode,
		};
    	
    	setOptions(params);
	});
	
	//사업부서(팀) autocomplete
    $('#workAutoComplete').ax5autocomplete({
        removeIcon: '<i class="fa fa-times" aria-hidden="true"></i>',
        onSearch: function (callBack) {
            var searchWord = this.searchWord;
            setTimeout(function () {
                var regExp = new RegExp(searchWord);
                var myOptions = [];
                options.forEach(function (n) {
                    if (n.text.match(regExp)) {
                        myOptions.push({
                            value: n.value,
                            text: n.text
                        })
                    }
                });
                callBack({
                	options: myOptions
                });
            }, 150);

        },
        onChange: function() {
        	console.log('aa');
        	console.log(this.value[0].value);
        	console.log(typeof this.value);
        	$('#workCode').val(this.value[0].value);
        	/* setValue($('#workAutoComplete'), {value:"", text:""}) */
        }
	});
    
    /*
  //사업부 셀렉트박스의 값이 변경될때  
	$('select.clsCode').change(function(){
		var currClsCode = this.value;
		currLocCode = null;
		currTeamCode = null;
		setData('LOC', currClsCode);
	});
	*/
	
	//사업장 셀렉트박스의 값이 변경될때  
	$('select.locCode').change(function(){
		var currLocCode = this.value;
		currTeamCode = null;
		setData('TEAM', currLocCode);
	});
	
	//아이디,성명 셀렉트박스의 값이 변경될때  
	$('select.nameId').change(function(){
		var nameId = this.value;
		if (nameId === 'empName') {
			$('#empName').val($('#searchData').val());
			$('#empId').val("");
		} else {
			$('#empId').val($('#searchData').val());
			$('#empName').val("");
		}
	});
})