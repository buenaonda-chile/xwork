var currClsCode,
currLocCode,
currTeamCode;

$(document.body).ready(function () {
	mask.close();
	
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
//						teamCode 리스트 초기화
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
//						locCode에 리스트 초기화
						$('select.locCode').html("<option value=''>사업장전체</option>");
//						teamCode에 리스트 초기화
						$('select.teamCode').html("<option value=''>부서(팀)전체</option>");
						
						//사업부서 등록 시 상위코드로 사용할 사업장 코드 초기화
						currLocCode = "";
						
					} else if(type === "TEAM"){
//						teamCode에 리스트 초기화
						$('select.teamCode').html("<option value=''>부서(팀)전체</option>");
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
    
    $('._saveBtn_').on( 'click', function(e){
		var saveCheck = confirm(LN_CONFIRM_SAVE);
		if(saveCheck){
			mask.open();
			var params = $("#aprvEmpSetForm").serialize();
			//console.log(params);
			$.ajax({
				url: '/ajaxWorkSort/aprvEmpSet.do',
				data : params,
				success: function() {
					toastMsg("저장완료");
					//console.log("저장완료");
				},
				error: function() {
					
				},
				complete: function() {
					mask.close();
				}
			});	
		}
		return false;
		
	});
    
    $('#all_check').click(function(){
    	if($('#all_check').prop("checked")){
    		$('.empNumList').prop("checked",true);
    	} else {
    		$('.empNumList').prop("checked",false);
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
		$('#locCode').val(currLocCode);
		$('#teamCode').val(currTeamCode);
		setData('LOC', currClsCode);
	});
	*/
	
	//사업장 셀렉트박스의 값이 변경될때  
	$('select.locCode').change(function(){
		//console.log('select changed');
		var currLocCode = this.value;
		$('#locCode').val(currLocCode);
		currTeamCode = null;
		$('#teamCode').val(currTeamCode);
		setData('TEAM', currLocCode);
	});
	
	//사업부서(팀) 셀렉트박스의 값이 변경될때  
	$('select.teamCode').change(function(){
		//console.log('select changed');
		var currTeamCode = this.value;
		console.log("????" + currTeamCode);
		$('#teamCode').val(currTeamCode);
		//currEmpNumber = null;
		setData('EMP', currTeamCode);
	});
	
	//조회버튼 클릭
	$('._searchBtn_').on('click', function(){
		//console.log('search clicked');
		var sort = $('.nameId').val();
		if (sort === 'empId') {
			$('#empId').val($('#searchData').val());
			$('#empName').val("");
		} else if(sort === 'empName' || sort === undefined ) {
			$('#empName').val($('#searchData').val());
			$('#empId').val("");
		}
		$('#WAC005BoardPop').submit();
		
	});	
	
	//조회버튼 클릭
	$('._searchBtn_Team').on('click', function(){
		//console.log('search clicked');
		var sort = $('.nameId').val();
		if (sort === 'empId') {
			$('#empId').val($('#searchData').val());
			$('#empName').val("");
		} else if(sort === 'empName' || sort === undefined ) {
			$('#empName').val($('#searchData').val());
			$('#empId').val("");
		}
		$('#WAC005BoardTeamPop').submit();
		
	});
	    
    $('._closeBtn_').on( 'click', function(e){
		//console.log("popClose");
    	self.close();
	});
    
	//저장버튼 클릭(WAB005EmpList.jsp)
    $('._saveBtn_PopList').on('click', function(){
		var check = confirm(LN_CONFIRM_SAVE);
		if(check){
			var maskEvent = mask.open();
			if(maskEvent.status === "on") {
				var total = $('.empNumList:checked').length;
				var checkArray = [];
				if(total > 0){
					$('.empNumList:checked').each(function(index){
						checkArray.push($(this).val());
					});
					window.opener.getReturnValue(JSON.stringify(checkArray));
					try {
						var paddingDiv = window.opener.document.getElementById("bottomDiv").style.display = "none";
					} catch (e) {
						console.log(e);
					}
					window.close();
					
				}else{
					alert('선택된 인원이 없습니다.');
					mask.close();
				}
			}
		}
	});
    
	//저장버튼 클릭(WAB005EmpList.jsp)
	$('._saveBtn_TeamPopList').on('click', function(){
		var check = confirm(LN_CONFIRM_SAVE);
		if(check){
			var maskEvent = mask.open();
			if(maskEvent.status === "on") {
				var total = $('.empNumList:checked').length;
				var checkArray = [];
				if(total > 0){
					$('.empNumList:checked').each(function(index){
						checkArray.push($(this).val());
					});
					window.opener.getReturnTeamValue(JSON.stringify(checkArray));
					var paddingDiv = window.opener.document.getElementById("bottomDiv").style.display = "none";
					window.close();
					
				}else{
					alert('선택된 인원이 없습니다.');
					mask.close();
				}
			}
		}
	});
    
});


function enterProc() {
	 if(event.keyCode==13){
		 var sort = $('.nameId').val();
			if (sort === 'empId') {
				$('#empId').val($('#searchData').val());
				$('#empName').val("");
			} else if(sort === 'empName' || sort === undefined ) {
				$('#empName').val($('#searchData').val());
				$('#empId').val("");
			}
			$('#WAB005EmpList').submit();
	 }
}

function uniqArr(arr) {
    var chk = [];
    for (var i = 0; i < arr.length; i++) {
        if (chk.length == 0) {
            chk.push(arr[i]);
        } else {
            var flg = true;
            for (var j = 0; j < chk.length; j++) {
                if (chk[j] == arr[i]) {
                    flg = false;
                    break;
                }
            }
            if (flg) {
                chk.push(arr[i]);
            }
        }
    }
    return chk;
}

//(WAB005EmpList.jsp)
function teamClick(team){
	var chk = document.getElementsByName("empNumList_"+team);
	var checked_chk = 0;
	for( var i = 0; i<chk.length; i++){
		if(chk[i].checked == true){
			checked_chk ++;
		}
	}
	if(checked_chk == chk.length){
		$("input[name=empNumList_"+team+"]").prop("checked",false);
	}
	else if($("input[name=empNumList_"+team+"]").prop("checked",false)){
		$("input[name=empNumList_"+team+"]").prop("checked",true);
	}
}