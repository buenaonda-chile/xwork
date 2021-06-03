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

function tableToCSV( table ) {
    // We'll be co-opting `slice` to create arrays
    var slice = Array.prototype.slice;

    return slice.call( table.rows ).map(function ( row ) {
      return slice.call( row.cells ).map(function ( cell ) {
        return '"t"'.replace( "t", cell.textContent );
      }).join( "," );
    }).join( "\r\n" );

}

function searchSubmit() {
	//console.log('search clicked');
	var sort = $('.nameId').val();
	if(sort === 'empName') {
		$('#empName').val($('#searchData').val());
		$('#empId').val("");
	} else if (sort === 'empId') {
		$('#empId').val($('#searchData').val());
		$('#empName').val("");
	}
	$('#WAB001EmpSearchForm').submit();
}

function enterProc() {
	 if(event.keyCode==13){
		searchSubmit();
	 }
}

$(function(){
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
	
	//사업부서(팀) 셀렉트박스의 값이 변경될때  
	$('select.teamCode').change(function(){
		var teamClsCode = this.value;
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
	
	//조회버튼 클릭
	$('._searchBtn_').on('click', function(){
		searchSubmit();
	});
	
	//내부외부직원 셀렉트박스의 값이 변경될때
	$('select.inoutType').change(function(){
		searchSubmit();
	});
	
	$('._excelBtn_').on('click', function(e){
		//console.log('excelBtn clicked');
		//fnExcelReport('empExcel', 'empInfo');
		//location.href = "/WAB001EmpSearch/empExcel.do?filename=empList";
		var menu = $(e.target).attr('data-menu');
		if(menu === '2'){
			location.href = "/WAB001EmpSearch/empExcel.do?filename=empList";
		}else{
			location.href = "/WAB007RelationCompanySearch/empExcel.do?filename=empList";
		}
	});
})