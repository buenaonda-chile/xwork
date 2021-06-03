function sumAuth(obj, num) {
	var checkValue = $(obj).is(':checked');
	var authNum = $($(obj).closest('tr')).find('.authNum');
	var authNumVal = Number(authNum.val());
	//console.log("authNumVal:" + authNumVal);
	//console.log("$(obj).val():" + $(obj).val());
	if(checkValue === true) {
		authNumVal = Number(authNumVal) + Number($(obj).val()); 
		//console.log("authNumVal:" + authNumVal);
	} else {
		authNumVal = Number(authNumVal) - Number($(obj).val());
	}
	authNum.val(authNumVal);
	//console.log("authNumVal:" + authNumVal);
}

function chkBoxClicked(obj) {
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

$(document.body).ready(function () {
	mask.close();
	$('[data-ax5autocomplete]').ax5autocomplete({
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

        }
    });
	
	$('[data-ax5autocomplete]').on('click', function() {
	    	//console.log('click');
	    	$('[data-ax5autocomplete]>span').css('z-index', '-100');
	    	$('[data-ax5autocomplete-display="input"]').focus();
    });
	
	$('._saveBtn_').on( 'click', function(e){
		if(confirm(LN_CONFIRM_SAVE)) {
			mask.open();
			/* $('#AuthDomain').submit(); */
			var params = $("#PrivateAuthDomain").serialize();
			$.ajax({
				url: '/WAD006PrivateAuthConfig/privateAuthConfig.do',
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
	
	$('._searchBtn_').on( 'click', function(e){
		var researchAuth = $('select.form-control').val();
		var empNumber = $('#empNumber').val();
		location.replace("/WAD006PrivateAuthConfig/init.do?empNumber=" + empNumber + "&researchCode="+researchAuth);
	});
	
	$('.selectAll').on( 'click', function(e){
		var trEl = $(e.target).closest('tr');
		var chkBoxs = trEl.find('.authChkBox input');
		var authNumEl =	trEl.find('.authNum');
		var check = $(e.target).is(':checked');
		if(check){
			chkBoxs.prop('checked', true);
			authNumEl.val(15);
		} else {
			chkBoxs.prop('checked', false);
			authNumEl.val(0);
		}
	});
	
	$('.groupChkBox').on( 'click', function(e){
		chkBoxClicked(e.target);
	});
	
	$('._closeBtn_').on( 'click', function(e){
		self.close();
	});
});