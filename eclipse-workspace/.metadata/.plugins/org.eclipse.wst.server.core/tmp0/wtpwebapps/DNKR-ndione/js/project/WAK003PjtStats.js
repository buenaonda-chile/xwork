 $(function(){
	mask.close();
     
    $('.list-top .dropdown').on('click', function(e){
 		$($(e.target).closest('div.pr20').find('.dropdown-menu')).css('display', 'block');
 	});
    
	var myCalendar = new ax5.ui.calendar({
        target: document.getElementById("calendar-workStats"),
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
            //console.log(this);
        }
    });
	
	//조회버튼 클릭
	$('._searchBtn_').on('click', function(e){
		$('#pjtDomain').submit();
	});
	
	//업무분류(대), (중), (소), 관련시스템 버튼 클릭
	$('ul.pj-smtab li').on('click', function(e) {
		//console.log("smtab");
		var worktype = $(e.target).attr('data-click');
		//console.log(worktype);
		$('input#workType').val(worktype);
		$('#pjtDomain').submit();
	});
})
