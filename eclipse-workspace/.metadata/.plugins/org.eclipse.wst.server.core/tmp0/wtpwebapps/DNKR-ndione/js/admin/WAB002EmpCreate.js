/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */

"use strict";

/**
 * 사업부, 사업장, 사업부서(팀) 입력폼에 autocomplete 리스트 불러오는 함수 
 * @param params ajax 매개변수
 */
function setOptions(params) {
	$.ajax({
		method : "post",
		url : "/ajaxRelation/init.do",
		data : params,
		success : function(res) {
			console.log(res);
			var data = JSON.parse(res);
			console.log(data);
			console.log(typeof data);
			options = [];
			if(data.list.length > 0){
				data.list.forEach(function(n) {
					console.log(typeof n.relationName);
					options.push({value: ""+ n.relationCode, text: ""+n.relationName});
				});
			}
			console.log("options2:" + options2)
			 
		},
		error : function(res) {
			
		},
		completed : function(res) {
			
		}
	});
}
$(document).ready(function () {	
	var chkDom = $('#inOutTypeI').length;
	if ( chkDom != 0 ) {
		var extType= document.querySelector('input[name=inOutType]:checked').value;	
		  //alert(extType);
		  if(extType=="O"){
			  empfieldInit(extType);
			  //$('input[name=inOutType]:radio').prop("disabled", true);
			  $('#inOutTypeI').prop("disabled", true);
		  }
	}
});

$(document.body).ready(function () {
	tabResize();
/*	//사업부 autocomplete 리스트 
	$('#clsAutoComplete').on('click', function() {
		console.log("autocomplete1.click");
		var params = {
				"type": "CLS",
				"clsCode": "",
		};
    	setOptions(params);
	});
	
	//사업장 autocomplete 리스트
	$('#locAutoComplete').on('click', function() {
		console.log("locAutoComplete.click");
		var clsCode = $('#clsAutoComplete select.form-control').val() + "";
		
		if( clsCode.trim().length === 0 || clsCode === null || clsCode === "null"){
			toastMsg('사업부를 먼져 입력해주세요');
			options = [];
			return;
		}
		var params = {
				"type": "LOC",
				"parentCode": clsCode,
		};
    	
    	setOptions(params);
	});
	
	//사업부서(팀) autocomplete 리스트
	$('#teamAutoComplete').on('click', function() {
		console.log("autocomplete2.click");
		var locCode = $('#locAutoComplete select.form-control').val() + "";
		
		if( locCode.trim().length === 0 || locCode === null || locCode === "null"){
			toastMsg('사업장를 먼져 입력해주세요');
			options = [];
			return;
		}
		var params = {
				"type": "TEAM",
				"parentCode": locCode,
		};
    	
    	setOptions(params);
	});
	
	//사업부 autocomplete
    $('#clsAutoComplete').ax5autocomplete({
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
        	
        }
    });
    
    //사업장 autocomplete
    $('#locAutoComplete').ax5autocomplete({
        removeIcon: '<i class="fa fa-times" aria-hidden="true"></i>',
        onSearch: function (callBack) {
        	console.log(this);
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
        	setValue($('#clsAutoComplete'), {value:"", text:""})
        }
	});
    
    //사업부서(팀) autocomplete
    $('#teamAutoComplete').ax5autocomplete({
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
	});*/
    //개인권한 사용여부에 따른 개인권한설정버튼 디스플레이 유무
	$('input[name=empPrivateAuth]:radio').on('change', function() {
		console.log('change');
		var empPrivateAuthValue = this.value;
		if(empPrivateAuthValue === 'Y'){
			$('#authCode').closest('tr').removeClass('displayNone');
		} else {
			$('#authCode').closest('tr').addClass('displayNone');
		}
	});
	
	$('#empNumber').keyup(function() {
		if($('#empNumber').attr('readonly') !== 'readonly'){
			var clsRltnCode = $('#clsCode').attr('data-rltnCode');
			var locRltnCode = $('#locCode').attr('data-rltnCode');
			makeEmpId(clsRltnCode, locRltnCode);
		}
	});
	
});