/**
 * [KO] 저장 시 입력값 체크
 * 
 * @returns {Boolean}
 */
function check_form() {
	if($('#teima').val().trim().length === 0) {
		toastMsg("[경고] 테마를 입력해 주세요.");
		return false;
	}
	
	if($('#tSum').val().trim() < 0) {
		toastMsg("[경고] 금액을 확인하세요.");
		return false;
	}
	
	if($('#tSum').val().trim() > 100000) {
		if(! confirm("[경고] [확인] 효과금액이 1억원을 넘고 있습니다. 등록해도 괜찮습니까? 효과단위 천원입니다.")) {
			return false;	
		}	
	}
	return true;
}


/**
 * [KO] 선택한 파일을 img에 보이게 셋팅
 * 
 * @param that file타입 input
 */
function fileSelected(that) {
	var imgGroup = that.closest('.imgGroup');
	if(window.FileReader){ // modern browser
		//image 파일만 
		if (!that[0].files[0].type.match(/image\//)) {
			return;
		}
		
		var reader = new FileReader(); 
		reader.onload = function(e){
			var src = e.target.result; 
			imgGroup.find('img').attr('src', src); 
		} 
		reader.readAsDataURL(that[0].files[0]);
		var filename = that[0].files[0].name;
	} else { // old IE 
		var filename = that.val().split('/').pop().split('\\').pop(); // 파일명만 추출 
	} 
}

/**
 * [KO] 파일업로드 전 선택한 파일이 있는지 체크
 *
 * @param target 업로드버튼
 */
function chkFile (target) {
	var fileInput = $(target).prev();	//파일타입 input
	var filename;
	
	if($(fileInput).val() !== "") {	//선택한 파일이 있으면
		if(window.FileReader){ // modern browser
			filename = $(fileInput)[0].files[0].name;
		} else { // old IE
			filename = $(fileInput).val().split('/').pop().split('\\').pop(); // 파일명만 추출 
		}
		
		return true;
	} else {
		toastMsg("파일을 선택해주세요.");
		return false;	
	}
}

/**
 * [KO] 파일취소시 등록된 파일이 있는지 체크
 * 
 * @param jisno 지시 No
 * @param type imgbf, imgaf구분
 */
function existRegFile(jisno, type) {
	var params = {jisno: jisno};
	var url = "/WAF026PsogmImprvD/ajaxGetImprvD.do";
	var jsonData = getAjaxDomain(url, params, "GET");
	var imgStr = "";
	if(jsonData !== undefined) {
		if(jsonData.result === RESULT_Y) {
			var pDomain = jsonData.pDomain;
			if(type === "imgbf") {
				imgStr = pDomain.imgbf;
			} else {
				imgStr = pDomain.imgaf;
			}
			if(imgStr.trim() !== "") {
				return true;
			}
		}
	}
	return false;
}


/**
 * [KO] 필드값이 바뀔때마다 새로 asum,bsum,csum,dsum을 계산한다 
 */
function calcu_sums()
{
	var aSum, 
		bSum,
		cSum,
		dSum,
		gmanpower_loss_value = 30,
		gline_loss_value = 200;
	
	$('#a1hyo').text(Number($('[name=a1hyn]').val()) - Number($('[name=a1cst]').val()));
	$('#a2hyo').text($('[name=a2hyo]').val());
	$('#a3hyo').text(Number($('[name=a3hyn]').val()) - Number($('[name=a3cst]').val()));
	$('#a4hyo').text(Number($('[name=a4hyn]').val()) - Number($('[name=a4cst]').val()) + Number($('[name=a4aft]').val()));
	$('#a5hyo').text(Number($('[name=a5hyn]').val()) - Number($('[name=a5aft]').val()));
	$('#a6hyo').text(Number($('[name=a6hyn]').val()) - Number($('[name=a6cst]').val()) + Number($('[name=a6aft]').val()));
	
	aSum = Number($('#a1hyo').text()) + Number($('#a2hyo').text()) + Number($('#a3hyo').text()) 
		+ Number($('#a4hyo').text()) + Number($('#a5hyo').text()) + Number($('#a6hyo').text());
	$('#aSum').text(aSum);
	
	$('#b1hyo').text(Number($('[name=b1hyn]').val()) * gmanpower_loss_value - Number($('[name=b1cst]').val()) 
			+ Number($('[name=b1aft]').val()) * gmanpower_loss_value);	
	$('#b2hyo').text(Number($('[name=b2hyn]').val()) * gmanpower_loss_value - Number($('[name=b2cst]').val()) 
			+ Number($('[name=b2aft]').val()) * gmanpower_loss_value);
	$('#b3hyo').text(Number($('[name=b3hyn]').val()) * gmanpower_loss_value - Number($('[name=b3cst]').val()) 
			+ Number($('[name=b3aft]').val()) * gmanpower_loss_value);
	$('#b4hyo').text(Number($('[name=b4hyn]').val()) * gmanpower_loss_value - Number($('[name=b4cst]').val()) 
			+ Number($('[name=b4aft]').val()) * gmanpower_loss_value); 
	
	bSum = Number($('#b1hyo').text()) + Number($('#b2hyo').text()) + Number($('#b3hyo').text()) 
			+ Number($('#b4hyo').text());
	$('#bSum').text(bSum);
	
	$('#c1hyo').text(Number($('[name=c1hyn]').val()) * gline_loss_value - Number($('[name=c1cst]').val()) 
			+ Number($('[name=c1aft]').val()) * gline_loss_value);				
	$('#c2hyo').text(Number($('[name=c2hyn]').val()) * gline_loss_value - Number($('[name=c2cst]').val()) 
			+ Number($('[name=c2aft]').val()) * gline_loss_value);
	$('#c3hyo').text(Number($('[name=c3hyn]').val()) * Number($('[name=c3cst]').val())/1000 
			- Number($('[name=c3aft]').val()) * Number($('[name=c3cst]').val())/1000);
	$('#c4hyo').text(Number($('[name=c4hyn]').val()) - Number($('[name=c4cst]').val())
			+ Number($('[name=c4aft]').val()));
	
	cSum = Number($('#c1hyo').text()) + Number($('#c2hyo').text()) + Number($('#c3hyo').text()) 
			+ Number($('#c4hyo').text());
	$('#cSum').text(cSum);
	
	$('#d1hyo').text(Number($('[name=d1hyn]').val()) - Number($('[name=d1cst]').val()) + Number($('[name=d1aft]').val()));
	$('#d2hyo').text(Number($('[name=d2hyn]').val()) - Number($('[name=d2cst]').val()) + Number($('[name=d2aft]').val()));
	$('#d3hyo').text(Number($('[name=d3hyn]').val()) - Number($('[name=d3cst]').val()) + Number($('[name=d3aft]').val()));
	$('#d5hyo').text(Number($('[name=d5hyn]').val()) - Number($('[name=d5aft]').val()));
	$('#d7hyo').text(Number($('[name=d7hyn]').val()) - Number($('[name=d7cst]').val()) + Number($('[name=d7aft]').val()));
	$('#d8hyo').text(Number($('[name=d8hyn]').val()) - Number($('[name=d8aft]').val()));
	$('#dbhyo').text(Number($('[name=dbhyn]').val()) - Number($('[name=dbcst]').val()) + Number($('[name=dbaft]').val()));
	$('#dchyo').text(Number($('[name=dchyn]').val()) - Number($('[name=dcaft]').val()));
	$('#ddhyo').text(Number($('[name=ddhyn]').val()) - Number($('[name=ddcst]').val()) + Number($('[name=ddaft]').val()));
	$('#dehyo').text(Number($('[name=dehyn]').val()) - Number($('[name=deaft]').val()));
	$('#dfhyo').text(Number($('[name=dfhyn]').val()) - Number($('[name=dfcst]').val()) + Number($('[name=dfaft]').val()));
	$('#dghyo').text(Number($('[name=dghyn]').val()) - Number($('[name=dgcst]').val()) + Number($('[name=dgaft]').val()));
	$('#dhhyo').text(Number($('[name=dhhyn]').val()) - Number($('[name=dhaft]').val()));
	$('#dihyo').text(Number($('[name=dihyn]').val()) - Number($('[name=dicst]').val()) + Number($('[name=diaft]').val()));
	$('#djhyo').text(Number($('[name=djhyn]').val()) - Number($('[name=djcst]').val()));
	
	dSum = Number($('#d1hyo').text()) + Number($('#d2hyo').text()) + Number($('#d3hyo').text()) 
			+ Number($('#d5hyo').text()) + Number($('#d7hyo').text()) + Number($('#d8hyo').text())
			+ Number($('#dbhyo').text()) + Number($('#dchyo').text()) + Number($('#ddhyo').text())
			+ Number($('#dehyo').text()) + Number($('#dfhyo').text()) + Number($('#dghyo').text())
			+ Number($('#dhhyo').text()) + Number($('#dihyo').text()) + Number($('#djhyo').text());
	$('#dSum').text(dSum);
	
	$('#tSum').val(aSum + bSum + cSum + dSum);
	if($('#tSum').val().length > 8) {
		alert("효과금액은 최대8자리까지 입니다.");
		return;
	}

}


$(document.body).ready(function() {
	$('._ubiRptBtn_').on('click', function() {
		var jisno = $('#jisno').val();
		window.open("/WAF026PsogmImprvD/ubiReportPop.do?jisno=" + jisno,"resultPop","width=1280,height=845,scrollbars=yes,top=100,left=100");
	});
	
	$('._saveBtn_').on('click', function() {
		if(! check_form()) {
			return false;
		}
		
		if(confirm("저장하시겠습니까?")) {
			//var form = document.createForm;
			//form.submit();
			var params = $('#createForm').serialize();
			var url = "/WAF026PsogmImprvD/create.do";
			
			var resultObj = getAjaxDomain(url, params);
			if(resultObj !== undefined) {
				if(resultObj.status === "insert") {
					toastMsg("저장되었습니다.");
					errMsg = "insert";
				} else if(resultObj.status === "update") {
					toastMsg("수정되었습니다.");
					errMsg = "update";
				} else {
					toastMsg("오류가 발생했습니다.<br>잠시 후 시도해 주세요.");
				}
				window.opener.setEcost($('#tSum').val());
			}
		}
	});
	 
	$('.btnDiv .imgInput').on('change', function(e){ // 값이 변경되면
		e.preventDefault();
		var that = $(this);
		fileSelected(that);
	});
	
	$('.imgUpBtn').on('click', function() {
		var that = $(this);
		if (errMsg === "") {	//개선상세테이블에 저장된 데이터가 있는지 확인 
			toastMsg("[알림] 개선테이블에 지시번호가 없습니다. 먼저 개선데이타를 저장해 주세요");
		} else {
			if(chkFile(that)) {
				var formData = new FormData();
				formData.append("filnm", that.prev()[0].files[0]);
				formData.append("jisno", $('#jisno').val());
				formData.append(that.prev()[0].getAttribute('data-type'), "imgSort");
				$.ajax({
				    url: '/WAF026PsogmImprvD/ajaxDrawImgUpdate.do',
				    //data: that.prev().attr('files'),
				    data: formData,
				    cache: false,
				    contentType: false,
				    processData: false,
				    type: 'POST',
				    success: function(res){
				    	try {
					    	//console.log(data);
					    	var data = JSON.parse(res);
					    	if(data.result === "Y") {
					    		toastMsg("처리되었습니다.");
					    	} else {
					    		toastMsg("오류가 발생했습니다<br>잠시 후 다시 시도해 주십시요");
					    	}
				    	} catch (e) {
				    		toastMsg("오류가 발생했습니다<br>잠시 후 다시 시도해 주십시요");
				    	}
				        
				    },
				    error: function(e) {
				    	console.log(e);
				    }
				});
			}	
		}
	}); 

	$('.imgCancleBtn').on('click', function() {
		var imgGroup = $(this).closest('.imgGroup');
		var dataTarget = this.getAttribute('data-target');
		var jisno = $('#jisno').val();
		if (errMsg === "") {	//개선상세테이블에 저장된 데이터가 있는지 확인 
			toastMsg("[알림] 개선테이블에 지시번호가 없습니다.");
			return;
		}
		
		if (!existRegFile(jisno, dataTarget)) {	
			toastMsg("[알림] 저장된 도면이 없습니다.");
			return;
		}

		if(confirm("도면이미지를 삭제하시겠습니까?")) {
			imgGroup.find('img').attr('src', "");
			var url = "/WAF026PsogmImprvD/ajaxDrawImgDelete.do";
			var resultObj = getAjaxResult(url, {jisno: jisno, dataSort: dataTarget}, "GET");
			if(resultObj !== undefined) {
				if(resultObj === RESULT_Y) {
					toastMsg("삭제되었습니다.");
				}
			} else {
				toastMsg("오류가 발생했습니다.<br> 잠시후 시도해 주세요.");
			}
		}

	});
});

