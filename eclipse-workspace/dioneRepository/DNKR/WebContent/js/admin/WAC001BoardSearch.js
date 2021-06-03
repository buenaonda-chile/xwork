

function onKeyDown(e){
     if(e.keyCode == 13){
         searchProc();
         $('#WAC001BoardInfoSearchForm').submit();
         return false;
     }else{
    	 return true;
     }
}

function searchProc(){
	console.log('seachProc 실행');
	var sort = $('.nameId').val();
	if(sort === 'boardNm') {
		$('#boardNm').val($('#searchData').val());
	} else if (sort === 'boardId') {
		$('#boardId').val($('#searchData').val());
	}
	//$('#WAC001BoardInfoSearchForm').submit();
}

function chkDel(){
	var total = $('.chk:checked').length;
	var checkArray = [];
	if(total > 0){
		$('.chk:checked').each(function(index){
			checkArray.push($(this).val());
		});
		
		$('#chkIdx').val(checkArray.join(','));
		var frm = document.WAC001BoardInfoSearchForm;
		$('#WAC001BoardSearchForm').attr('action','chkDelete.do');
		$('#WAC001BoardSearchForm').submit();
		
	}else{
		alert('선택된 게시글이 없습니다.');
	}
}

$(function(){	
	
	//조회버튼 클릭
	$('._searchBtn_').on('click', function(){
		console.log('조회 버튼 클릭');
		var sort = $('.nameId').val();
		if(sort === 'boardNm') {
			$('#boardNm').val($('#searchData').val());
		} else if (sort === 'boardId') {
			$('#boardId').val($('#searchData').val());
		}
		$('#WAC001BoardInfoSearchForm').submit();
	});
	
	$('._excelBtn_').on('click', function(){
		fnExcelReport();
	});
})