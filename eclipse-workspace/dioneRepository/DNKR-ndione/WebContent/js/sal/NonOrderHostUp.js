
var title,
    titleKey;

function setList(){
	var excelForm = document.excelUploadForm;
	
	var typcd = $(":input:radio[name=getTypcd]:checked").val();
	var ccTypcd = excelForm.getCCTypcd.value;
	var ccTypGbcd = excelForm.getCCTypGbcd.value;
		
	var sucList = excelForm.sucList.value;
	var failList = excelForm.failList.value;
	
	var titleArr = new Array();
	var titleKeyArr = new Array();
	
	var stTitle    = "고객코드,고객명,생산공장,하치장,고객품번,덴소품번,품명,적입량," + 
                     "D,D+1,D+2,D+3,D+4,D+5,D+6,D+7,D+8,D+9,D+10,D+11,D+12,D+13";
    var stTitleKey = "cusno,col1,faccd,yard,cprtn,pspno,cpdsc,outqy," +
                     "do0qy,do1qy,do2qy,do3qy,do4qy,do5qy,do6qy,do7qy,do8qy,do9qy,do10qy,do11qy,do12qy,do13qy";

	// 확정오더 : 엑셀 데이터에서 고객품번(cprtn)에 대한 덴소품번(pspno) 항목을 추가함.
	if(typcd == "CC") {
		//확정오더 - 표준양식
		if(ccTypcd == "1"){
			title    = stTitle;
            titleKey = stTitleKey;
		//확정오더 - HMC CKD
		}else if(ccTypcd == "2"){
			//창원
			if(ccTypGbcd == "" || ccTypGbcd == "2A"){
				title    = "col0,col1,col2,col3,col4,col5,덴소품번,col6,col7,col8,col9," + 
	                       "col10,col11,col12,col13,col14,col15,col16,col17,col18,col19," +
	                       "col20,col21,col22,col23,col24,col25,col26,col27,col28,col29," +
	                       "col30,col31,col32,col33,col34,col35,col36,col37,col38,col39," +
	                       "col40,col41,col42,col43,col44,col45,col46,col47,col48,col49," +
	                       "col50,col51,col52,col53,col54,col55";
	            titleKey = "col0,col1,col2,col3,col4,cprtn,pspno,col6,col7,col8,col9," + 
	                       "basqy,col11,plndt,col13,col14,ponum,col16,col17,col18,col19," +
	                       "col20,col21,col22,col23,col24,col25,col26,col27,col28,col29," +
	                       "col30,col31,col32,col33,col34,col35,col36,col37,col38,col39," +
	                       "col40,col41,col42,col43,col44,col45,col46,col47,col48,col49," +
	                       "col50,col51,col52,col53,col54,col55";
			}
			//화성
			if(ccTypGbcd == "2B"){
				title    = "DOCUMENT CODE,상태코드,자재번호,덴소품번,플랜트정보,기본단위,계산수량,D일계획 수량,포장완료일,품목남품일,포장장," + 
		                   "판재문서 유형,판매문서,SD문서의 품목번호,포장배치,판매문서 (FROM),판매문서 (TO),국가 + 딜러,모델코드,CASE TYPE,CASE NO," +
		                   "RELATION,중포장 수량,SOURCE 구분자,사급구분,직대구분,입고지시자,분합납품 가능여부,현재고,전일실적,포장완료 수량," +
		                   "발주생성 여부,구매문서 번호,구매문서 품목번호,구매증빙일,메시지텍스트,자재구분,CT적입장,포장라인,입고누계 수량,순중량 (총박스)," +
		                   "총중량 (중박스),중량단위";
		                   //"수납수,상수,게이트,보관장소,외주포장,품질검사,박스코드,포장사"; // 숨김열
                titleKey = "col0,col1,cprtn,pspno,col3,col4,col5,basqy,col7,plndt,col9," + 
                           "col10,ponum,col12,col13,col14,col15,col16,col17,col18,col19," +
                           "col20,col21,col22,col23,col24,col25,col26,col27,col28,col29," +
                           "col30,col31,col32,col33,col34,col35,col36,col37,col38,col39," +
                           "col40,col41";
                           //"col42,col43,col44,col45,col46,col47,col48,col49"; // 숨김열
			}
		//확정오더 - KMC CKD
		}else if(ccTypcd == "3"){
			title    = "자재번호,덴소품번,자재명,품질검사,납품요청일,발주수량,납입잔량,납품일자 및 수량,납품 차질 사유,담당(이름/직급/핸드폰번호),납입장소," +
			           "업체코드,업체명,오더번호(FROM),오더번호(TO),담당자,보관장소,박스코드";
			titleKey = "cprtn,pspno,col1,col2,plndt,basqy,col5,col6,col7,col8,col9," +
			           "col10,col11,ponum,col13,col14,col15,col16";
		//확정오더 - MOBIS CKD
		}else if(ccTypcd == "4"){
			title    = "오더유형,발주일,발주번호,발주항번,주문번호,LINE,자재번호,덴소품번,납입처,요구납기,납기계획,발주경과일,납기경과일,발주수량," +
					   "출하량,출고미납,입고수량,입고미납,단위,차종코드,차종내역,고객코드,고객명,발주메모";
	        titleKey = "col0,col1,ponum,col3,col4,col5,cprtn,pspno,col7,plndt,col9,col10,col11,basqy,col13,col14,col15,col16,col17,col18,col19,col20,col21,col22";
		//확정오더 - MOBIS AS
		}else if(ccTypcd == "5"){
			//신양식 (SRS)
			if(ccTypGbcd == "" || ccTypGbcd == "5A"){
				title    = "No,Part No.,덴소품번,업체 Part No.,품명,계열,H/K,차종,차종명,조달담당자,재고담당," +
				           "재고담당자,발주번호,품목,발주번호+품목,기존 발주번호,발주구분,발주유형,제품구분,납기구분,양/단산," +
				           "파텍스여부,유상사급여부,발주처,납품처,예매대리점,사급업체,포장구분,포장유형,CLASS,발주일자," +
				           "납기일자,요청일자,최초발주수량,발주수량,ASN수량,입고량,취소량,미납량,선납가능수량,오더단위," +
				           "단가,발주금액,미납금액,제품가,도장가,포장가,통화,미납분석 공급예정일,ATP일자,긴급결품," +
				           "긴급충진,충진,B/O계,예상발주일자,예상발주량(7일),예상발주량(30일),예상발주량(45일),검필증 유형,검필증 부착수량,검필증 제품수량," +
				           "검필증 부착위치,원발주업체,원발주번호,원발주품목,원발주ASN,원발주ASN 항목번호,일반원산지,인증대상,인증번호,완료," +
				           "금형문제,공용화,EAC,타각,자동화창고,Q-MARK,품질메시지";
                titleKey = "col0,cprtn,pspno,col2,col3,col4,col5,col6,col7,col8,col9," + 
                           "col10,ponum,col12,col13,col14,col15,col16,col17,col18,col19," +
                           "col20,col21,col22,col23,col24,col25,col26,col27,col28,plndt," +
                           "plndt,col31,col32,basqy,col34,col35,col36,col37,col38,col39," +
                           "col40,col41,col42,col43,col44,col45,col46,col47,col48,col49," +
                           "col50,col51,col52,col53,col54,col55,col56,col57,col58,col59," +
                           "col60,col61,col62,col63,col64,col65,col66,col67,col68,col69," +
                           "col70,col71,col72,col73,col74,col75,col76";     
			}
			//구양식 (SPIN)
			if(ccTypGbcd == "5B"){
				title    = "SEQ,PART NO,덴소품번,업체관리 PART NO,PART NAME,업체,담당,재고담당,포장유형,발주처,납품처," +
				           "발주번호,PO번호,발주PROCESS,발주구분,발주유형,사급업체,수급CLASS,통합CLASS,차종,발주일자," +
				           "납기일자,요청일자,예매사업소,대리점,발주량,취소량,입고량,선납가능량,발주단가,미납량," +
				           "긴급(결품),B/O(충진),내수계,VOR(긴급),AIR(충진),SEA(충진),수출계,B/O 금액,검필증 유형,검필증 부착수량," + 
				           "검필증 제품수량,검필증 부착위치,양단관리,Q-MARK,원발주업체,공용화 적용여부,REMARK,품목점차월예상발주량(M+1),품목점차월예상발주량(M+2),인증대상," + 
				           "인증번호,용품유무,MIL수량,COP수량,MAX수량,POI수량,발주가능량,1일소요량,예상발주일자,예상발주량(7일)," + 
				           "예상발주량(30일),예상발주량(45일),긴급발주구분,원발주번호,금형문제코드,납기구분,LOCATION NO,입고통제";
		        titleKey = "col0,cprtn,pspno,col2,col3,col4,col5,col6,col7,col8,col9," + 
		                   "ponum,col11,col12,col13,col14,col15,col16,col17,col18,col19," +
		                   "plndt,col21,col22,col23,basqy,col25,col26,col27,col28,col29," +
		                   "col30,col31,col32,col33,col34,col35,col36,col37,col38,col39," +
		                   "col40,col41,col42,col43,col44,col45,col46,col47,col48,col49," +
		                   "col50,col51,col52,col53,col54,col55,col56,col57,col58,col59," +
		                   "col60,col61,col62,col63,col64,col65,col66,col67";
			}
		//확정오더 - GLOVIS
		}else if(ccTypcd == "6"){
			title    = "오더넘버,발주넘버,품번,덴소품번,품명,납기일자,용기수,수량,발주일자,발주구분,납입장소,상태";
			titleKey = "ponum,col1,cprtn,pspno,col3,plndt,col5,basqy,col7,col8,col9,col10";
		}
		
		titleArr = title.split(',');
		titleKeyArr = titleKey.split(',');
	}
	else {
		//비서열 - 표준양식		
		titleArr = stTitle.split(',');
		titleKeyArr = stTitleKey.split(',');
	}
	
	// 표준양식 다운로드 그리드
	downTitleArr = stTitle.split(',');
	downTitleKeyArr = stTitleKey.split(',');
	for(var i=0 ; i<downTitleArr.length ; i++){
		downGrid.addColumn({key: downTitleKeyArr[i], label: downTitleArr[i], align: "center", width : 250});
	}


	errorGrid.addColumn({key: "ERROR", label: "ERROR", align: "center", width : 150});

	// 엑셀변환시 숫자형태로 변하는것 방지 ( 987003E000 -> 987003 (9.87E+05) , 400025318400010 -> 4.00025E+14 , 00010 -> 10 등. )
	var formatterYn = false;
	
	for(var j=0 ; j<titleArr.length ; j++){
		
		//MOBIS CKD : 발주항번,주문번호,LINE,고객코드
		if (ccTypcd == "4" && (j==3 || j==4 || j==5 || j==21)) formatterYn = true;
		//MOBIS AS - 신양식 (SRS) : 품목,발주번호+품목,원발주품목,원발주ASN 항목번호
		else if (ccTypcd == "5" && ccTypGbcd == "5A" && (j==13 || j==14 || j==64 || j==66)) formatterYn = true;
		// 품목코드
		else if(titleKeyArr[j] == "cprtn" || titleKeyArr[j] == "pspno") formatterYn = true;	
		else formatterYn = false;		
		
		if(formatterYn){
			errorGrid.addColumn({key: titleKeyArr[j], label: titleArr[j], align: "center",
				                 formatter: function() {return this.value + "&nbsp;"}});
			normalGrid.addColumn({key: titleKeyArr[j], label: titleArr[j], align: "center",
				                  formatter: function() {return this.value + "&nbsp;"}});			
		}
		else{
			errorGrid.addColumn({key: titleKeyArr[j], label: titleArr[j], align: "center"});
			normalGrid.addColumn({key: titleKeyArr[j], label: titleArr[j], align: "center"});
		}
	}

	if(sucList != ''){
		var sucData = JSON.parse(sucList);
		normalGrid.appendToList(sucData);
		
		//sort
		if(typcd == "BB" || (typcd == "CC" && ccTypcd == "1")) {
			normalGrid.setColumnSort({
				"pspno" : {orderBy: "asc", seq: 0}
			});
		}else{
			normalGrid.setColumnSort({
				"plndt" : {orderBy: "asc", seq: 0},
				"pspno" : {orderBy: "asc", seq: 1}
			});			
		}
	}
	
	if(failList != ''){		
		var failData = JSON.parse(failList);
		errorGrid.appendToList(failData);
		
		//sort	
		if(typcd == "BB" || (typcd == "CC" && ccTypcd == "1")) {
			errorGrid.setColumnSort({
				"cprtn" : {orderBy: "asc", seq: 0}
			});
		}else{
			errorGrid.setColumnSort({
				"plndt" : {orderBy: "asc", seq: 0}
			});			
		}
	}
	
	mask.close();
}


function excelUpload(){
	var excelForm = document.excelUploadForm;
	var value = excelForm.upFile.value;
	
	if(value == ''){
		alert(LN_SELECT_FILE);
		mask.close();
	}else{
		
		// 파일 확장자 확인
		var ext = value.split('.').pop().toLowerCase();
		if($.inArray(ext, ['xls','xlsx']) == -1) {
			alert('엑셀파일[XLS, XLSX]에 대해 업로드 가능합니다.'); 
			mask.close();
		}
		else {		
			var typcd = $(":input:radio[name=getTypcd]:checked").val();
			var ccTypcd = $(".getCCTypcd").val();
	
			var nameChkYn = false;
			if(typcd == "BB") nameChkYn = true;
			else {
				if(ccTypcd == "1") nameChkYn = true;
				else {
					// 파일명 확인
					var fileValue = value.split("\\");
					var fileName = fileValue[fileValue.length-1];
					
					var ccTypcdName= $(".getCCTypcd>option:selected").text();
					
					if(fileName.indexOf(ccTypcdName) == -1) nameChkYn = false;
					else nameChkYn = true;
				}
			}
	
			if(nameChkYn) excelForm.submit();
			else {
				alert("선택하신 파일명이 [" + ccTypcdName + "] 이(가) 아닙니다.");
				mask.close();
			} 
		}
	}
	
}

var normalGrid;
var errorGrid;
var downGrid;

$(document.body).ready(function() {
	var plndt_calendar = new ax5.ui.calendar({
        target: document.getElementById("plndt_calendar"),
        control: {
            left: '<i class="fa fa-chevron-left"></i>',
            yearTmpl: '%s',
            monthTmpl: '%s',
            right: '<i class="fa fa-chevron-right"></i>',
            yearFirst: true
        },
        displayDate: (new Date()),
        dimensions: {
            height: 250,
            controlHeight: 40,
            itemPadding: 1
        },
        lang: {
        	/*yearTmpl: "%s년",*/
            /*months: ['일월', '이월', '삼월', '사월', '오월', '육월', '칠월', '팔월', '구월', '시월', '십일월', '십이월'],*/
        	yearTmpl: YEAR_FORMAT,
        	months: MONTH,
        	dayTmpl: "%s"
        },
        onClick: function () {
            $(this.target).css('display', 'none');
            $(this.target).prev().val(plndt_calendar.getSelection());            
        },
        onStateChanged: function () {
            //console.log(this);
        }
    });
	
	$('.log_board .dropdown').on('click', function(e){
		$($(e.target).next('.dropdown-menu')).css('display', 'block');
	});
	
	$('.getComps').on('change', function() {
		$(".getPyvnd").val("");
		$(".getCusnm").val("");
	});
	
	$('.getPyvnd').on('change', function() {
		$(".getCusnm").val("");
	});
	
	$('._custBtn_').on('click', function() {
		window.open("/ajaxCustomer/init.do","customerPop","width=550,height=600,scrollbars=yes,top=100,left=100");
	});
	
	$('.getTypcd').on('change', function() {

		var excelForm = document.excelUploadForm;

		var typcd = $(":input:radio[name=getTypcd]:checked").val();

		if(typcd == "BB") excelForm.getCCTypcd.disabled = true;
		else excelForm.getCCTypcd.disabled = false;
			
		loadForm();
	});
	
	$('.getCCTypcd').on('change', function() {
		
		$(".getCCTypGbcd").val("");
			
		loadForm();

	});

	 normalGrid = new ax5.ui.grid({
         target: $('[data-ax5grid="normal-grid"]'),
         //sortable: true,
         columns: [
         ]
     });
	 
	 errorGrid = new ax5.ui.grid({
         target: $('[data-ax5grid="error-grid"]'),
         //sortable: true,
         columns: [
         ]
     });
	
	 downGrid = new ax5.ui.grid({
         target: $('[data-ax5grid="down-grid"]'),
         columns: [
         ]
     });
	 
	 
	setList();
	
	$('._excelUploadBtn_').on('click', function() {
		if(!$(".getComps").val()){
			toastMsg(LN_SELECT_COMPS);
			return false;
		}else if(!$(".getPyvnd").val()){
			toastMsg(LN_SELECT_PYVND);
			return false;
		}
		
		var typcd = $(":input:radio[name=getTypcd]:checked").val();
		var ccTypcd = $(".getCCTypcd").val();

		var plndtChk = false;
		if(typcd == "BB") plndtChk = true;
		else {
			if(ccTypcd == "1") plndtChk = true;
		}
		
		if(plndtChk){
			if(!$(".getPlndt").val()){
				toastMsg(LN_SELECT_PLNYM);
				return false;
			}else if(!$(".getPeriod").val()){
				toastMsg(LN_SELECT_PERIOD);
				return false;
			}
		}
		
		mask.open();
		excelUpload();
	});
	
	$('._excelBtn_').on('click', function() {
		if(this.getAttribute("data-target") === "normal") {
			normalGrid.exportExcel("HOST UP 정상LIST.xls");
		} else {
			errorGrid.exportExcel("HOST UP ERROR LIST.xls");
		}
	});
	
	$('._excelDownBtn_').on('click', function() {
		if(this.getAttribute("data-target") === "down") {
			downGrid.exportExcel("공통양식.xls");
		}
	});
	
	mask.close();
});

function loadForm() {
	var excelForm = document.excelUploadForm;
	excelForm.action = "/WAN015NonOrderHostUp/init.do";
	excelForm.submit();

	//errorGrid.removeColumn();
	//normalGrid.removeColumn();
	
	////gridDataInit(errorGrid.target);
	////gridDataInit(normalGrid.target);
	//setList();
}

function checkPeriod() {
	if (parseInt($("#getPeriod").val()) == 0){
		toastMsg("처리기간(day)을 입력하세요.");
		$("#getPeriod").val("");	
	}
	
	if (parseInt($("#getPeriod").val()) > 14){
		toastMsg("처리기간(day)은 최대 14일까지 입력가능합니다.");
		$("#getPeriod").val("");	
	}
}

/**
 * 업체코드로 업체명 검색하여 데이터 set
 * 
 * @param 업체코드
 */
function getCustSch() {
	if($('#getPyvnd').val() != ""){
		
		$.ajax({
			method : "post",
			url : "/ajaxCustomer/search.do",
			data : {
				"getCusno" : $("#getPyvnd").val(),
				"getComps" : $("#getComps").val()
			},
			success : function(res) {
				var data = JSON.parse(res);			
				
				if (data.list.length > 0) {
					$('#getCusnm').val(data.list[0].cusnm);
				}
				else {
					toastMsg(LN_IO_CHK1 + " : " + $("#getPyvnd").val());
					$("#getPyvnd").val("");					
					//$("#getCusnm").val("");
				}
			},
			error : function() {
				//console.log("dataset.error");
			},
			completed : function() {
				//console.log("dataset.completed");
			}
		});
	}
}

/**
 * 팝업창에서 값넘겨받아 부모창에 데이터 set
 * 
 * @param returnValue
 */
function getReturnValue(returnValue) {
	if(returnValue !== null) {
		var retObj = JSON.parse(returnValue);

		$('#getPyvnd').val(retObj.cusno);
		$('#getCusnm').val(retObj.cusnm);	
	}
}