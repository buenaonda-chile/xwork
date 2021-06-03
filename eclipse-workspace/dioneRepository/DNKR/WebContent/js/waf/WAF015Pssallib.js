var picker = new ax5.ui.picker();
var picker2 = new ax5.ui.picker();
	
$(document).ready(function() {
	/* 	$('._searchBtn_').on('click', function(){
		console.log('searchBtn clicked');
		$('#searchForm').submit();
	}); */
	$('[data-ax5formatter]').ax5formatter();
	 
	//Date
	picker.bind({
        target: $('[data-ax5picker="basic"]'),
        direction: "top",
        content: {
            width: 270,
            margin: 10,
            type: 'date',
            config: {
                control: {
                    left: '<i class="fa fa-chevron-left"></i>',
                    yearTmpl: '%s',
                    monthTmpl: '%s',
                    right: '<i class="fa fa-chevron-right"></i>'
                },
                lang: {
                    yearTmpl: "%s년",
                    months: ['01월', '02월', '03월', '04월', '05월', '06월', '07월', '08월', '09월', '10월', '11월', '12월'],
                    dayTmpl: "%s"
                }
            }
        },
        onStateChanged: function () {

        }
	});
        
        picker2.bind({
	        target: $('[data-ax5picker="basic2"]'),
	        direction: "top",
	        content: {
	            width: 270,
	            margin: 10,
	            type: 'date',
	            config: {
	                control: {
	                    left: '<i class="fa fa-chevron-left"></i>',
	                    yearTmpl: '%s',
	                    monthTmpl: '%s',
	                    right: '<i class="fa fa-chevron-right"></i>'
	                },
	                lang: {
	                    yearTmpl: "%s년",
	                    months: ['01월', '02월', '03월', '04월', '05월', '06월', '07월', '08월', '09월', '10월', '11월', '12월'],
	                    dayTmpl: "%s"
	                }
	            }
	        },
	        onStateChanged: function () {

	        }
    });
});


function check() {
	
	if($('#jpnno').val() === "") {
		$('#jpnno').val("0000000000");
	}
	if($('#jpnno2').val() === "") {
		$('#jpnno2').val("9999999999");
	}
	if($('#pyvnd').val() === "") {
		$('#pyvnd').val("00000000");
	}
	if($('#pyvnd2').val() === "") {
		$('#pyvnd2').val("99999999");
	}
	if($('#jpsdt').val() === "") {
		$('#jpsdt').val("00000000");
	}
	if($('#jpsdt2').val() === "") {
		$('#jpsdt2').val("99999999");
	}
	if($('#jpsdt').val() === "") {
		$('#jpsdt').val("00000000");
	}
	if($('#jpsdt2').val() === "") {
		toastMsg("전표일자를 선택해주세요");
	} else {
		$('#searchForm').submit();
	}
	/*if($('#jptdt1').val() === "") {
		$('#jptdt1').val("00000000");
	}
	if($('#jptdt2').val() === "") {
		$('#jptdt2').val("99999999");
	}*/
	return;
}