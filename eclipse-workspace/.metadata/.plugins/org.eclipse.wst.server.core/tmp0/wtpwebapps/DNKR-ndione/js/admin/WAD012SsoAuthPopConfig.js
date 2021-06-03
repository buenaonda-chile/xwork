
function chkBoxClicked(obj) {
	alert("chkBoxClicked");
	console.log("chkBoxClicked");
	var groupClsName = $(obj).closest('tr').attr('class');
	var trEls = $('.'+groupClsName);
	var check = $(obj).is(':checked'); 
	if(check){
		console.log("if");
		for(var i = 0; i < trEls.length; i++){
			$(trEls[i]).find('input[type=checkbox]').prop('checked', true);
			$(trEls[i]).find('.authNum').val(15);
		};
	} else {
		console.log('else');
		for(var i = 0; i < trEls.length; i++){
			$(trEls[i]).find('input[type=checkbox]').prop('checked', false);
			$(trEls[i]).find('.authNum').val(0);
		};
	}
}

/*
function aa(obj){
	var authChk=$('input:checkbox[name="authOption"]').is(":checked");
	alert(authChk);
	
	if(authChk==true){
		this.value="Y";
	}else{
		this.value="N";		
	}
	var authChk2=obj.value;
	alert("authChk=="+authChk+"authChk2=="+authChk2);
	
	
}
*/
function companyOnChage(){
	var changeCompany = $('#changeCompany').val();	
	var empNumber = $('#empNumber').val();
	var pCompany = "";	//사업부
	//alert(chkCompany+"===" +this.item.clsCode);
	if(changeCompany=="CLS000001"){
		pCompany="PS";
	}else if(changeCompany=="CLS000002"){
		pCompany="PE";
	}else if(changeCompany=="CLS000003"){
		pCompany="KR";
	}
	
	location.replace("/WAD012SsoAuthConfig/init.do?empNumber=" + empNumber + "&company="+pCompany + "&changeCompany="+changeCompany);
	
}

$(document.body).ready(function () {
	mask.close();
	
	$('._searchBtn_').on( 'click', function(e){
		companyOnChage();
	});
	
	$('._saveBtn_').on( 'click', function(e){
		if(confirm(LN_CONFIRM_SAVE)) {
			mask.open();
			/* $('#AuthDomain').submit(); */
			var params = $("#SsoAuthDomain").serialize();
			$.ajax({
				url: '/WAD012SsoAuthConfig/SsoAuthConfig.do',
				data : params,
				type: 'post',
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
		
	$('._closeBtn_').on( 'click', function(e){
		self.close();
	});

	$('.useYn').on( 'click', function(e){
		var trEl = $($(e.target).closest('tr'));
		var check_useYn = $(trEl[0]).find('.useYn').is(':checked');
		var useTf;
		if(check_useYn==true){
			$(trEl[0]).find('.useTf').val('Y');
			useTf=$(trEl[0]).find('.useTf').val();
		} else {
			$(trEl[0]).find('.useTf').val('N');
			useTf=$(trEl[0]).find('.useTf').val();
		}
		//alert(useTf);
	});
});