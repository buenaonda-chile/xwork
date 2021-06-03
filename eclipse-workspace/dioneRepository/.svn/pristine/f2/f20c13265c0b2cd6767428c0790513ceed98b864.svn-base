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
		setData('LOC', currClsCode);
	});
	*/
	
	//사업장 셀렉트박스의 값이 변경될때  
	$('select.locCode').change(function(){
		//console.log('select changed');
		var currLocCode = this.value;
		$('#locCode').val(currLocCode);
		currTeamCode = null;
		setData('TEAM', currLocCode);
	});
	
	//사업부서(팀) 셀렉트박스의 값이 변경될때  
	$('select.teamCode').change(function(){
		//console.log('select changed');
		var currTeamCode = this.value;
		$('#teamCode').val(currTeamCode);
		//currEmpNumber = null;
		//setData('EMP', currTeamCode);
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
		$('#WAB005EmpList').submit();
		
	});
	    
    $('._closeBtn_').on( 'click', function(e){
		//console.log("popClose");
    	self.close();
	});
    
	//저장버튼 클릭(WAB005EmpList.jsp)
	$('._saveBtn_PopList').on('click', function(){
		var check = confirm(LN_CONFIRM_SAVE);
		if(check){
			
			var total = $('.empNumList:checked').length;
			var checkArray = [];
			var test_teamCode_Array = [];
			var resultArray = [];
			if(total > 0){
				$('.empNumList:checked').each(function(index){
					checkArray.push($(this).val());//checkArray 출력하면 ,로 나옴. []로도 뽑아옴.
				});
				for(var test_i=0; test_i < checkArray.length; test_i++){
					test_Array = checkArray[test_i].split(',');
					for(var test_Array_cnt = 0; test_Array_cnt < test_Array.length; test_Array_cnt++){
						test_Array_test = test_Array[test_Array_cnt].split('/');
						test_teamCode_Array.push(test_Array_test[2]);//선택된 팀코드들의 집합체 
						//중복제거된 집합체 => uniqArr(test_teamCode_Array)
					}
				}
				//test_teamCode_Array에 선택된사람들의 팀코드를 넣어놨음.
				var no_Array = uniqArr(test_teamCode_Array);
				var team_Name_Array=[];
				for(var team_Name = 0; team_Name < no_Array.length; team_Name++){
					var result_ajax = "";
					if(no_Array[team_Name]){
						$.ajax({
							url : "/ajaxEmp/teamName.do",
							type : "post",
							async:false,
							data : {teamCode:no_Array[team_Name]},
							contentType: "application/x-www-form-urlencoded; charset=UTF-8",
							success : function(res) {
								console.log("ajax.success");
								var data = JSON.parse(res);
								if(data.result != "" || data.result != null){
									result_ajax = data.result;
								}else{
									result_ajax = "사업부없음";
								}
							},
							error : function() {
								console.log("ajax.error");
								stateMsg = "error";
							},
							complete : function() {
								console.log("ajax.complete");
							}
						});	
						////////////////특수문자 치환///////////////////
//						result_ajax = result_ajax.replace('.','_');
//						result_ajax = result_ajax.replace('(','_');
//						result_ajax = result_ajax.replace(')','_');
//						result_ajax = result_ajax.replace(' ','_');
//						result_ajax = result_ajax.replace('/','_');
						////////////////특수문자 치환///////////////////
							
						var chk = document.getElementsByName("empNumList_"+no_Array[team_Name]);
						var checked_chk = 0;
						for( var i = 0; i<chk.length; i++){
							if(chk[i].checked == true){
								checked_chk ++;
							}
						}
						if(checked_chk == chk.length){
							var temp_save_id="";
							var temp_save_data;
							$("input[name=empNumList_"+no_Array[team_Name]+"]").each(function(index){
								var value = $(this).val();
								console.log(value);
								var new_value ="";
								temp_save_data = value.split('/');
								console.log(temp_save_data);
	//							alert(temp_save[0]);
	//							alert(temp_save[1]);
	//							alert(temp_save[2]);
								temp_save_id += temp_save_data[1]+"@";
								
							});
							new_value = result_ajax+"/"+temp_save_id+"/"+temp_save_data[2];
							resultArray.push(new_value);
						}else{
							$("input[name=empNumList_"+no_Array[team_Name]+"]:checked").each(function(index){
								resultArray.push($(this).val());
							});
						}	
					} else{
						$("input[name=empNumList_]:checked").each(function(index){
							var no_teamCode="외부업체";
							var value = $(this).val();
							var result_value = value+no_teamCode;
							$(this).val(result_value);
							resultArray.push($(this).val());
						});
					}
				}
				console.log("resultArray : "+resultArray);
				
				window.opener.getReturnValue(JSON.stringify(resultArray));
				window.close();
				
			}else{
				alert('선택된 인원이 없습니다.');
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