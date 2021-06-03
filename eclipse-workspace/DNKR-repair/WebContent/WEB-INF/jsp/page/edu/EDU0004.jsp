<%-- [EN] Variable definition --%>
<%-- [JP] ???? --%>
<c:url var="codeUrl" value="/code/list.json"/>

<c:url var="code2Url" value="/trainingAppcntView/list.json"/>

<c:url var="initUrl" value="/tainingAppRegist/init"/>

<c:url var="readUrl" value="/trainingAppRegist/search"/>

<c:url var="readUrl2" value="/trainingAppRegist/searchSd"/>

<c:url var="createUrl" value="/trainingAppRegist/create"/>

<c:url var="createUrl2" value="/trainingAppRegist/create2"/>

<c:url var="popupUrl3" value="/trainingAppRegist/popup"/>

<%-- [EN] ID screen (defined by @ViewId) --%>
<%-- [JP] ??ID (@ViewId???) --%>
<c:set var="screenId" value="<%= request.getAttribute(Globals.SCREEN_ID_KEY) %>"/>

<div id="title_0" class="sub-con-wrap">
  <h2 class="subpage-tit">교육신청등록</h2>
  <!-- 버튼들 -->
  <div class="sub-btn-group">
    <!-- <button type="button" class="button" data-bind="click: popup"><i class="w_print"></i>인쇄</button> -->
    <!-- <button id="btn_search" type="button" class="button" data-bind="click: search"><i class="w_search"></i>검색</button> -->
    <!-- <button id="btn_cancel" type="button" class="button" data-bind="click: cancel, visible: btnGrp1Visible"><i class="w_cancel"></i>취소</button> -->
  </div>
  <!-- /버튼들 -->
</div>

<%-- .search1 --%>

<div id="container" style="width:100%; height: 750px;">
	<div class="layout-B" style="width:820px; margin-left:auto; margin-right:auto; ">
		<h2 class="subpage-tit">■ 개인정보 수집 · 이용동의</h2>
		<tr >
		    <div style="width:820px; margin-left:auto; margin-right:auto; ">
			<textarea wrap="virtual" style=" height:200px;">
덴소코리아 (이하 "회사"라 함)는 방문자의 개인정보를 소중하게 생각하며, "개인정보보호법" 등 관련 법규를 준수하며, 방문자 들의 개인정보보호에 최선을 다하고 있습니다.

1. 수집 및 이용하려는 개인정보 항목 및 목적
  ① 개인정보 항목
    성명, 방문일자, 방문시간, 퇴소시간, 연락처, 업체명, 방문목적, 담당직원(만날사람),차량번호, 동행인정보(성명)
  ② 수집/이용하려는 목적
     방문객출입에 필요한 확인 및 식별

2. 수집하지 않는 항목
   방문객의 주민등록번호, 운전면허번호, 기타 [개인정보 보호법] 상 고유식별정보 및 사상, 정당, 건강, 기타 「개인정보 보호법」상 민감정보는 귀하로부터 별도의 동의가 없는 한 수집하지 않습니다.

3. 개인정보의 보유 및 이용기간
   당사는 귀하로부터 제공된 모든 정보를 위에 기재된 수집/이용 목적 또는 관련 법령을 준수하기 위한 목적 이외의 용도로 사용하지 않을 것이며, 법령상의 보유의무 등 정당한 사유가 없는 한 보유/이용기간이 초과(1)하거나 개인정보 수집 및 이용 목적이 달성된 후에는 해당 정보를 파기(2)할 것입니다.

4. 동의를 거부할 권리에 대한 안내
   귀하께서는 본 안내에 따른 개인정보 수집, 이용에 대하여 동의를 거부하실 권리가 있습니다.
   다만, 귀하가 위 1.항의 필수항목에 관한 개인정보 수집/이용에 거부하는 경우, 당사의 개인정보 수집에 동의하지 않을 경우 당사의 출입이 제한될 수 있음을 알려드립니다.

5. 개인정보 수집/이용하도록 하는데 동의

「개인정보보호법」, 「동법 시행령」, 「동법 시행규칙」에 의거하여 본인의 개인정보를 위와 같이 수집/이용하도록 하는데 동의 합니다.
				
			</textarea>
			</div>
		</tr>
		<tr>
		  <div style="width:260px; margin-left:auto; margin-right:auto; ">
          <td>
            <input type="checkBox" id="infoYn" data-bind="value: criteria.infoYn" />
            위와 같이 개인정보의 수집 및 이용에 동의합니다.
          </td>
          </div>
        </tr>
	</div>
	<div class="layout-B" style="width:820px; margin-left:auto; margin-right:auto; margin-top:40px; ">
		<h2 class="subpage-tit">■ 개인정보처리방침 동의</h2>
		<tr>
			<div style="width:820px; margin-left:auto; margin-right:auto; ">
			<textarea style=" height:200px;">
1. 개인정보의 처리 목적 <덴소코리아주식회사>('https://www.denso.com/kr/ko/' 이하 '덴소코리아주식회사')은(는) 다음의 목적을 위하여 개인정보를 처리하고 있으며, 다음의 목적 이외의 용도로는 이용하지 않습니다.
   - 방문객출입에 필요한 확인 및 식별 등

2. 개인정보의 처리 및 보유 기간
  ① <덴소코리아주식회사>('https://www.denso.com/kr/ko/' 이하 '덴소코리아주식회사')은(는)   정보주체로부터 개인정보를 수집할 때 동의 받은 개인정보 보유/이용기간 또는 법령에 따른 개인정보 보유/이용기간 내에서개인정보를 처리/보유합니다.
  ② 구체적인 개인정보 처리 및 보유 기간은 다음과 같습니다.
1) 이용자의 개인정보는 원칙적으로 개인정보의 처리목적이 달성되면 지체 없이 파기합니다.
2) 개인정보보유기간 : 최대 1년


3. 개인정보의 제3자 제공
  <덴소코리아주식회사>('https://www.denso.com/kr/ko/' 이하 '덴소코리아주식회사')은(는)   정보주체의 별도 동의, 법률의 특별한 규정 등 개인정보 보호법 제17조에 해당하는 경우 외에는 개인정보를 제3자에게 제공하지 않습니다.

4. 정보주체의 권리,의무 및 그 행사방법 이용자는 개인정보주체로서 다음과 같은 권리를 행사할 수 있습니다.
  정보주체는 <기관/회사명>('사이트URL'이하 '사이트명) 에 대해 언제든지 다음 각 호의 개인정보 보호 관련 권리를 행사할 수 있습니다.
    1) 개인정보 열람요구
    2) 오류 등이 있을 경우 정정 요구
    3) 삭제요구
    4) 처리정지 요구

5. 처리하는 개인정보의 항목 작성
  덴소코리아주식회사>('https://www.denso.com/kr/ko/' 이하 '덴소코리아주식회사')는 다음의 개인정보 항목을 처리하고 있습니다.
   - 성명, 방문일자, 방문시간, 퇴소시간, 연락처, 업체명, 방문목적, 담당직원(만날사람),차량번호, 동행인정보(성명)

6. 개인정보의 파기
<덴소코리아주식회사>('덴소코리아주식회사')는  원칙적으로 개인정보 처리목적이 달성된 경우에는 지체없이 해당 개인정보를 파기합니다. 파기의 절차, 기한 및 방법은 다음과 같습니다.
   -파기절차
      이용자가 입력한 정보는 목적 달성 후 별도의 DB에 옮겨져(종이의 경우 별도의 서류) 내부 방침 및 기타 관련 법령에 따라 일정기간 저장된 후 혹은 즉시 파기됩니다. 이 때, DB로 옮겨진 개인정보는 법률에 의한 경우가 아니고서는 다른 목적으로 이용되지 않습니다.
  -파기기한
      이용자의 개인정보는 개인정보의 보유기간이 경과된 경우에는 보유기간의 종료일로부터 5일 이내에, 개인정보의 처리 목적 달성, 해당 서비스의 폐지, 사업의 종료 등 그 개인정보가 불필요하게 되었을 때에는 개인정보의 처리가 불필요한 것으로 인정되는 날로부터 5일 이내에 그 개인정보를 파기합니다.

7. 개인정보의 안전성 확보 조치 <덴소코리아주식회사>('덴소코리아주식회사')는  개인정보보호법 제29조에 따라 다음과 같이 안전성 확보에 필요한 기술적/관리적 및 물리적 조치를 하고 있습니다.
  ①  개인정보 취급 직원의 최소화 및 교육
     개인정보를 취급하는 직원을 지정(1)하고 담당자에 한정시켜 최소화 하여 개인정보를 관리하는 대책을 시행(2)하고 있습니다.
  ② 개인정보의 암호화
     이용자의 개인정보는 비밀번호는 암호화 되어 저장 및 관리되고 있어, 본인만이 알 수 있으며 중요한 데이터는 파일 및 전송 데이터를 암호화 하거나 파일 잠금 기능을 사용하는 등의 별도 보안기능을 사용하고 있습니다.
  ③  해킹 등에 대비한 기술적 대책
    <덴소코리아주식회사>('덴소코리아주식회사')는  해킹이나 컴퓨터 바이러스 등에 의한 개인정보 유출 및 훼손을 막기 위하여 보안프로그램을 설치하고 주기적인 갱신·점검을 하며 외부로부터 접근이 통제된 구역에 시스템을 설치하고 기술적/물리적으로 감시 및 차단하고 있습니다.
  ④ 개인정보에 대한 접근 제한
     개인정보를 처리하는 데이터베이스시스템에 대한 접근권한의 부여,변경,말소를 통하여 개인정보에 대한 접근통제를 위하여 필요한 조치를 하고 있으며 침입차단시스템을 이용하여 외부로부터의 무단 접근을 통제하고 있습니다.
  ⑤ 접속기록의 보관 및 위변조 방지
     개인정보처리시스템에 접속한 기록을 최소 6개월 이상 보관, 관리하고 있으며, 접속 기록이 위변조 및 도난, 분실되지 않도록 보안기능 사용하고 있습니다.

8. 개인정보 보호책임자 작성
  ① <덴소코리아주식회사>('https://www.denso.com/kr/ko/' 이하 '덴소코리아주식회사')는  개인정보 처리에 관한 업무를 총괄해서 책임지고, 개인정보 처리와 관련한 정보주체의 불만처리 및 피해구제 등을 위하여 아래와 같이 개인정보 보호책임자를 지정하고 있습니다.
      ▶ 개인정보 보호책임자
      성명 : 서배영
      직급 : 책임사원
      연락처 : 055-220-9121,   seoby@densokorea.com
      ※ 개인정보 보호 담당부서로 연결됩니다.

      ▶ 개인정보 보호 담당부서
      성명 : 서배영
      직급 : 책임사원
      연락처 : 055-220-9121,   seoby@densokorea.com
  ② 정보주체께서는 <덴소코리아주식회사>('https://www.denso.com/kr/ko/' 이하 '덴소코리아주식회사') 의 서비스(또는 사업)을 이용하시면서 발생한 모든 개인정보 보호 관련 문의, 불만처리, 피해구제 등에 관한 사항을 개인정보 보호책임자 및 담당부서로 문의하실 수 있습니다. <덴소코리아주식회사>('https://www.denso.com/kr/ko/' 이하 '덴소코리아주식회사')는  정보주체의 문의에 대해 지체 없이 답변 및 처리해드릴 것입니다.

9. 개인정보 처리방침 변경
  이 개인정보처리방침은 시행일로부터 적용되며, 법령 및 방침에 따른 변경내용의 추가, 삭제 및 정정이 있는 경우에는 변경사항의 시행 7일 전부터 공지사항을 통하여 고지할 것입니다.

  10. 시행일
①시행일 : 2017년 4월1일 시행 한다
②개정일 : 2018년7월2일부터 개정시행 한다.
			</textarea>
			</div>
		</tr>
		<tr>
		<div style="width:260px; margin-left:auto; margin-right:auto; ">
          <td>
            <input type="checkBox" id="infoYn2" data-bind="value: criteria.infoYn2" />
            위와 같이 개인정보 취급위탁 이용에 동의합니다.
          </td>
          </div>
        </tr>
	</div>
	<!-- <a href="#" onclick="history.back()"> -->
	<div class="sub-con-wrap"  style="width:140px; margin-left:auto; margin-right:auto; ">
	<div class="sub-btn-group" style="width:140px; margin-left:auto; margin-right:auto; ">
		<button id="btn_can" class="button bc1" style="margin-top:40px; " data-bind="click: cancel"><i class="w_cancel"></i>취소</button>
    	<button id="btn_next" class="button bc2" style="margin-top:40px; " data-bind="click: next"><i class="w_add"></i>다음</button>
  	</div>
  	</div>
</div>

<!-- <div id="container2" style="display: none;"> -->
<div id="container2">
	<div class="layout-LW">
	<div id="form_container" class="center" style="width:100%;"> 
	<form id="frm_input" method="post">
	<div class="layout-B">
		<h2 class="subpage-tit">[교육 선택]</h2>
	</div>
	<div class="search1">
		<fieldset>
	      <table>
	        <colgroup>
	          <col style="width:80px"/>
	          <col style="width:155px"/>
			  <col style="width:80px"/>
	          <col style="width:155px"/>
	          <col style="width:80px"/>
	          <col style="width:280px"/>
	          <col style="width:80px"/>
	          <col style="width:155px"/>
	          <col/>
	        </colgroup>
	        <tr>
	          <th>교육대상 구분</th>
	          <td>
	              <kendo:dropDownList name="eduDiv" dataTextField="codeNm"
	                                data-value-primitive="true"
	                                dataValueField="codeCd"
	                                data-bind="value: criteria.eduDiv"
	                                optionLabel="전체" style="width: 200px;">
	              <kendo:dataSource>
	                <kendo:dataSource-transport>
	                  <kendo:dataSource-transport-read url="${codeUrl}/EDUCATION" type="POST"
	                                                   contentType="application/json"/>
	                  <kendo:dataSource-transport-parameterMap>
	                    function(options){
	                    return JSON.stringify(options);
	                    }
	                  </kendo:dataSource-transport-parameterMap>
	                </kendo:dataSource-transport>
	                <kendo:dataSource-schema data="data" total="total">
	                </kendo:dataSource-schema>
	              </kendo:dataSource>
	            </kendo:dropDownList>
	          </td>
	          <th>교육 항목</th>
	          <td>
	              <kendo:dropDownList name="eduNm" dataTextField="eduNm"
	                                data-value-primitive="true"
	                                dataValueField="id"
	                                data-bind="value: criteria.eduItem"
	                                optionLabel="전체" style="width: 200px;">
	              <kendo:dataSource>
	                <kendo:dataSource-transport>
	                  <kendo:dataSource-transport-read url="${code2Url}/EDUCATION" type="POST"
	                                                   contentType="application/json"/>
	                  <kendo:dataSource-transport-parameterMap>
	                    function(options){
	                    return JSON.stringify(options);
	                    }
	                  </kendo:dataSource-transport-parameterMap>
	                </kendo:dataSource-transport>
	                <kendo:dataSource-schema data="data" total="total">
	                </kendo:dataSource-schema>
	              </kendo:dataSource>
	            </kendo:dropDownList>
	          </td>
	        </tr>
	      </table>
	    </fieldset>
	</div>
	
	<h2 class="subpage-tit">[수강자 정보]</h2>
	    
	      <table class="bWrite" style="width:700px; margin-left:auto; margin-right:auto; ">
	        <colgroup>
	          <col style="width:200px"/>
	          <col/>
	          <col style="width:300px"/>
	          <col/>
	        </colgroup>
	        <!-- <tr>
	          <th>업체명</th>
	          <td>
	            <input type="text" id="custNm" data-bind="value: criteria.custNm" size="40"/>
	          </td>
	          
	          
	        </tr> -->
	        <tr>
	          <th>정비소명</th>
	          <td>
	            <input type="text" id="officeNm" data-bind="value: criteria.officeNm" size="40"/>
	            <!--<button type="button" class="button">${data.qualityIndex}</button>-->
	            
	            <!-- <div class="search_input" style="width:180px;"> -->
	            <!-- <div class="search_input">
	              <input type="text" id="officeNm" data-bind="value: criteria.officeNm"  style="width:260px;"/>
	              <input type="hidden" id="officeCd" data-bind="value: criteria.officeCode" />
	              <button type="button" data-bind="click: popup3" style="left:225px;"><i class="ic_search1"></i><span
	                      class="blind">검색</span></button>
	            </div> -->
	            
	            
	          </td>
	          <!--<th>생산거점</th>
	          <td colspan="3"><select name="" id="">
	            <option value="" selected="selected">DNJP</option>
	          </select></td>-->
	          
	        </tr>
	        <tr>
	          <th>대표자명</th>
	          <td>
	            <input type="text" id="reprNm" data-bind="value: criteria.reprNm" size="40"/>
	          </td>
	          
	        </tr>
	        <tr>
	          <th>연락처(회사)</th>
	          <td>
	            <input type="text" id="officeTel" data-bind="value: criteria.officeTel" size="40"/>
	          </td>
	          
	        </tr>
	        
	        <tr>
	          <th>연락처(핸드폰)</th>
	          <td>
	            <input type="text" id="telNo" data-bind="value: criteria.telNo" size="40"/>
	          </td>
	          
	        </tr>
	        
	        <tr>
	          <th>E-mail</th>
	          <td>
	            <input type="text" id="email" data-bind="value: criteria.email" size="40"/>
	          </td>
	          
	        </tr>
	        
	        <tr>
	          <th>등록 비밀번호</th>
	          <td>
	            <input type="password" id="officePw"  maxLength="4" data-bind="value: criteria.officePw" autocomplete="off" size="40"/>
	            * 숫자 4자리 입력해주세요.
	          </td>          
	        </tr>
	        
	        <tr>
	          <th>등록 비밀번호 확인</th>
	          <td>
	            <input type="password" id="officePwConfirm"  maxLength="4"  data-bind="value: criteria.officePwConfirm" autocomplete="off" size="40"/>            
	          </td>
	        </tr>
	        
	      </table>
	    </form>
	  </div>
	
	</div>
	
	<div class="sub-con-wrap">
	  <!-- <h2 class="subpage-tit">비용승인</h2> -->
	  <!-- 버튼들 -->
	  <div class="sub-btn-group">
	    <button id="btn_add" class="button bc1" data-bind="click: add, visible: btnGrp0Visible"><i class="w_add"></i>추가</button>
	  </div>
	  <!-- /버튼들 -->
	</div>
	
	<%-- .layout-LW --%>
	<div class="layout-LW">
	    <div class="left" style="width:100%;">
	    <!-- <div class="left" style="width:1730px;"> -->
	    <div style="margin-bottom:10px; "></div>
	  	<div id="grid" data-grid-type="view"></div>
	  	<!-- <div id="grid2" data-grid-type="view"></div>   -->
	  	<!-- <div id="grid2" data-grid-type="view" style="display:none;"></div>   -->
	  </div>
	</div>
	
	
	
	<!-- <div class="layout-LW">
		<div class="search1">
		  <form id="frm_search2" method="get" >
		    <fieldset>
		      <table>
		        <colgroup>
		          <col style="width:80px"/>
		          <col style="width:155px"/>
		          <col/>
		        </colgroup>
		        <tr>
		          <th>개인정보 수집 및 활용에 동의합니다.</th>
		          <td>
		            <input type="checkBox" id="infoYn" data-bind="value: criteria.infoYn" />
		            개인정보 수집 및 활용 동의서
		          </td>
		          
		        </tr>
		      </table>
		    </fieldset>
		  </form>
		</div>
	</div> -->
	
	<div class="sub-con-wrap">
	  <!-- <h2 class="subpage-tit">비용승인</h2> -->
	  <!-- 버튼들 -->
	  <div class="sub-btn-group">
	    <button id="btn_save" class="button bc2" data-bind="click: save, visible: btnGrp3Visible"><i class="w_save"></i>신청저장</button>
	  </div>
	  <!-- /버튼들 -->
	</div>
	<%--// .layout-LW --%>
</div>
<script type="text/javascript">

    var _dicasPage = new DicasPage('${screenId}');

    $( ".calendar" ).datepicker();

    // 검색설정
    var loadDt = new Date();
    // $('#searchResultDateFr').val($.datepicker.formatDate('yymmdd', new Date(Date.parse(loadDt) - 15 * 1000 * 60 * 60 * 24))); // 보름전
    // $('#searchResultDateTo').val($.datepicker.formatDate('yymmdd', new Date()));

    /* 달력보기 */
    $.datepicker.setDefaults({
        prevText: '이전 달',
        nextText: '다음 달',
        monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        dayNames: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
        showMonthAfterYear: true,
        changeMonth: true,
        changeYear : true,
        dateFormat: "yymmdd",
        yearSuffix: '년'
    });



    <%-- Variable Definition --%>
    var validatable = null;
    <%--// Variable Definition --%>

    var codeMdl = kendo.data.Model.define({
        ID: 'ID',
        fields: {
		    rn: { type: 'number' }
	       ,rnkCd: { type: 'string' }
	       ,traineeNm: { type: 'string' }
	       ,officeTel: { type: 'string' }
	       ,moblphonNo: { type: 'string' }
	       ,email: { type: 'string' }
   		}
    });
    
    var codeMdl2 = kendo.data.Model.define({
        ID: 'ID',
        fields: {
       	 applyId: { type: 'number' }
        ,eduDiv: { type: 'string' }
        ,eduItem: { type: 'string' }
        ,custNm: { type: 'string' }
        ,officeNm: { type: 'string' }
        ,reprNm: { type: 'string' }
        ,officeTel: { type: 'string' }
        ,telNo: { type: 'string' }
        ,email: { type: 'string' } 
        ,infoYn: { type: 'string' }
        ,infoYn2: { type: 'string' }
       }
    });
    
    var buttonView = kendo.observable({
        btnGrp0Visible: true,
        btnGrp3Visible: true,
        //btnGrp1Visible: false,
        //btnGrp2Visible: false,
        search: function() {
            searchView.submit();
        },
        cancel: function() {
        	/* window.history.back(); */
        	document.getElementById('infoYn').checked = false;
			document.getElementById('infoYn2').checked = false; 
        },
        next: function(){
        	if($('#infoYn').prop("checked") == true){
				inputView2.set('criteria.infoYn', 'Y');
			}else{
				alert("개인정보 수집 및 이용 동의 체크는 필수 입니다.");
				inputView2.set('criteria.infoYn', 'N');
				return;
			}
        	
        	if($('#infoYn2').prop("checked") == true){
				inputView2.set('criteria.infoYn2', 'Y');
			}else{
				alert("개인정보 취급위탁 이용 동의 체크는 필수 입니다.");
				inputView2.set('criteria.infoYn2', 'N');
				return;
			}
        	
        	document.getElementById("container").style.display = "none";
        	document.getElementById("container2").style.display = "block";
        	document.getElementById("container2").style.height = "650px";
        	
        	var v_grid = document.getElementById('grid');
            v_grid.children[0].children[1].style.width = "100%";
            v_grid.children[0].children[1].children[0].children[0].style.width = "100%";
            v_grid.children[0].children[1].children[1].children[0].children[0].children[0].style.width = "100%";
        	
        },
        add: function () {
          var dataItem = new codeMdl().toJSON();
          grid.prependRow(dataItem, {focus: true});
          
          var gridRowkey = grid.getFocusedCell().rowKey
          grid.setValue(gridRowkey, "rn", grid.getRowCount());
        },
        save: function() {
			
			// 교육대상 구분 체크
			if($('#eduDiv').val() == ""){
				alert("교육대상 구분을 선택하세요.");
				return;
			}
			
			// 교육항목 체크
			if($('#eduNm').val() == ""){
				alert("교육항목 선택하세요.");
				return;
			}
			
			// 업체명 체크
			//if($('#custNm').val() == ""){
			//	alert("업체명을 입력해주세요.");
			//	return;
			//}
			
			// 정비소명 체크
			if($('#officeNm').val() == ""){
				alert("정비소명 입력해주세요.");
				return;
			}
			
			// 대표자명 체크
			if($('#reprNm').val() == ""){
				alert("대표자명을 입력해주세요.");
				return;
			}
			
			// 연락처(회사) 체크
			if($('#officeTel').val() == ""){
				alert("연락처(회사)를 입력해주세요.");
				return;
			}
			
			// 연락처(핸드폰) 체크
			if($('#telNo').val() == ""){
				alert("연락처(핸드폰)을 입력해주세요.");
				return;
			}
				
			// E-mail 체크
			if($('#email').val() == ""){
				alert("E-mail을 입력해주세요.");
				return;
			}
			
			// 등록 비밀번호 체크
			if($('#officePw').val() == ""){
				alert("비밀번호를 입력해주세요.");
				return;
			}
			
			// 등록 비밀번호 확인 체크
			if($('#officePwConfirm').val() == ""){
				alert("비밀번호 확인을 입력해주세요.");
				return;
			}
			
			// 등록 비밀번호 = 등록 비밀번호 확인 체크
			if($('#officePw').val() != $('#officePwConfirm').val()){
				alert("비밀번호와 비밀번호 확인이 서로 상이 합니다.");
				return;
			}
			
			if (grid.getModifiedRows().createdRows.length <= 0){
				alert("추가 버튼을 클릭하여 수강자 정보를 입력 해주시기 바랍니다.");
				return;
			}
			
			if($('#infoYn').prop("checked") == true){
				inputView2.set('criteria.infoYn', 'Y');
			}else{
				alert("개인정보 수집 및 활용 동의서 체크는 필수 입니다.");
				inputView2.set('criteria.infoYn', 'N');
				return;
			}
			
			for (var i = 0; i < grid.getModifiedRows().createdRows.length; i++){
				
				if(grid.getModifiedRows().createdRows[i].rnkCd == ""){
					alert("직급을 선택해주세요");
					return;
				}
				
				if(grid.getModifiedRows().createdRows[i].traineeNm == ""){
					alert("수강자 이름을 입력해주세요");
					return;
				}
				
				if(grid.getModifiedRows().createdRows[i].moblphonNo == ""){
					alert("수강자 리스트에서 연락처(핸드폰)을 입력해주세요");
					return;
				}
			}
			
			_dicasPage.maskOpen();
			
			$.ajax({
		          method: "POST",
		          url: '${createUrl}',
		          data: JSON.stringify(inputView2.get('criteria')),
		          dataType: 'JSON',
		          contentType: 'application/json;charset=UTF-8'
		        }).done(function (data, result, jqXHR ) {
		        	
		        	if(data.dataChk == 'fail'){
		        		alert("이미 등록되어 있습니다.");
		        		return;
		        	}
		        	
		        	if (grid.getModifiedRows().createdRows.length > 0) {
						for (var i = 0; i < grid.getModifiedRows().createdRows.length; i++){
							
							grid.setValue(i, "applyId", data.result);

							 $.ajax({
						          method: "POST",
						          url: '${createUrl2}',
						          data: JSON.stringify(grid.getModifiedRows().createdRows[i]),
						          dataType: 'JSON',
						          contentType: 'application/json;charset=UTF-8'
						        }).done(function (data, status, jqXHR) {
						        	
						        	
					        }).fail(function (data, status, jqXHR) {
					          alert("저장 중 오류가 발생하였습니다.");
					        }).always(function () {
					          _dicasPage.maskClose();
					        });
							 
						}
						
						grid.clear();
						document.getElementById('infoYn').checked = false;
						document.getElementById('infoYn2').checked = false;
						var dataItem = new codeMdl2().toJSON();
						inputView2.set('criteria', null);
						inputView2.set('criteria', dataItem);
						alert("수정 및 저장이 완료되었습니다.");
						document.getElementById("container").style.display = "block";
			        	document.getElementById("container2").style.display = "none";
					} 
		
	        }).fail(function (data, status, jqXHR) {
	          alert("저장 중 오류가 발생하였습니다.");
	        }).always(function () {
	          _dicasPage.maskClose();
	        });

        },
        remove: function () {

          if (grid.getRowCount() == 0) {
            return;
          }

          if(confirm("교육 정보를 삭제 하시겠습니까?")) {
              _dicasPage.maskOpen();

              var data = inputView.get('data');

              if (data.id == null) {
                return;
              }else if(data.chk == "I"){
            	  grid.removeRow(inputView.get('rowKey'));
            	  return;
              }

              $.ajax({
                method: "POST",
                url: '${deleteUrl}',
                data: JSON.stringify(inputView.get('data')),
                contentType: 'application/json;charset=UTF-8'
              }).done(function (data, status, jqXHR) {
                //searchView.search();
                var dataItem = new codeMdl().toJSON();
                inputView.set('data', dataItem);

                grid.clear();
    			searchView.submit();

              }).fail(function (data, status, jqXHR) {
                alert("삭제 중 오류가 발생하였습니다.");
              }).always(function () {
                _dicasPage.maskClose();
              });
        	  
          }

        }
      });   

    buttonView.bind('change', function (e) {
    	
    });

    kendo.bind($("div.sub-con-wrap"), buttonView);

    var searchView = kendo.observable({
    	
        rowKey: null,
        criteria: {
            grpCd: null,
        },
        rowIndex: 0,
        data: null,

        submit: function () {
        	
        	buttonView.set('btnGrp0Visible', true);
            if (inputView.hasChanges()) {
                if (!confirm("변경된 데이터가 있습니다. 조회 하시겠습니까?")) {
                    return;
                }
            }
            
            var dataItem = new codeMdl2().toJSON();
            inputView2.set('criteria', null);
            inputView2.set('criteria', dataItem);
            goPage('grid', 1);
            return false;
        },

    });
    kendo.bind($("#frm_search"), searchView);    
    
    // 콤보 박스 데이터 내용 및 코드값 변환
    getEditOptions = function (data) {
        var editoptions = [];
        
        item = {
        	      text: '선택해주세요.',
        	      value: ''
        	    }
        
    	editoptions.push(item);
        
        for (var i = 0; i < data.length; i++) {

          var item = {
            text: data[i].codeKoNm,
            value: data[i].codeCd
          }

          editoptions.push(item);
        }
        return editoptions;
      };
      

    var inputView = kendo.observable({
        btnGrp3Visible: true,
        btnGrp4Visible: true,
        rowIndex: 0,
        rowKey: null,
        data: null,
        save: function () {
        	 
        	

        },
        validate: function () {
            if (validatable == null) return true;
            return validatable.validate();
        },
        hasChanges: function () {
            return grid.isModified();
        },
    });

    inputView.bind('change', function (e) {
        if (e.field.indexOf('data.') > -1) {
            var itemNm = e.field.substr(5);
            grid.setValue(this.get('rowKey'), itemNm, this.get(e.field));
            if (this.hasChanges()) {
                buttonView.set('btnGrp1Visible', true);
            } else {
                buttonView.set('btnGrp1Visible', false);
            }
        }
    });
    kendo.bind($("#grid"), inputView);
    
    var inputView2 = kendo.observable({
        data: {
          id: null,
          applyId: null,
          eduDiv: null,
          eduItem: null,
          custNm: null,
          officeNm: null,
          reprNm: null,
          officeTel: null,
          telNo: null,
          email: null,
          infoYn: null,
        },
        flag: false,
        validate: function () {
          if (validatable == null) return true;
          return validatable.validate();
        },
        hasChanges: function () {
          return this.flag;
        },
        popup3: function () {
            var that = this;
            _dicasPage.popupOpen({
              url: "${popupUrl3}",
              code: 'codeHelp',
              width: 1400,
              height: 800,
              params: {
                maker: "",
                officeNm: "",
                officeCity: "",
                partDiv: ""
              },
              beforeOpen: function () {
                _dicasPage.beforeCodeHelpVal = true;
              },
              afterClose: function (info) {
                if (info.result) {
                  var _data = JSON.parse(info.data);
                  
                  that.set('criteria.officeCd', _data.officeCd);
                  that.set('criteria.officeNm', _data.officeNm);
                  
                } else {
                  
                }
              }
            });
        }
      });
      inputView2.bind('change', function (e) {
        if (e.field.indexOf('criteria.') > -1) {
          var itemNm = e.field;
          inputView2.set(itemNm, this.get(e.field));
        }
      });
      kendo.bind($("#form_container"), inputView2);

    function setPageUI(type) {
        if (type == "init") {
            $("input[type]", "#form_container").each(function (i, v) {
            	searchView.submit();
            });
        } else if (type == 'view' || type == 'add') {
            $("input[type]", "#form_container").each(function (i, v) {
                
            });
        }

        var state = grid.getValue(inputView.get('rowKey'), "approvalStatus");
        if (state == "SUBMISSION") {
            inputView.set('btnGrp3Visible', true);
            inputView.set('btnGrp4Visible', true);
        }
    }

    function goPage(gridId, page) {
        if (gridId == "grid") {
            searchView.set("rowKey", null);
            searchView.set("rowData", null);
            net.readData(1, searchView.criteria.toJSON(), true);
        }
    }

    <%-- Control Definition--%>
    var grid;
    var pagination;
    var net;
    
    

    <%--// Control Definition --%>

    $(document).ready(function () {
    	
	    validatable = $("#form_container").kendoValidator({validateOnBlur: false}).data("kendoValidator");
	
	    var rnkData = new kendo.data.DataSource({data: ${rnkItems}}),
	    rnkItems = getEditOptions(rnkData.options.data);
	    
	    tui.Grid.applyTheme('clean');
	    grid = new tui.Grid({
	        el: $('#grid'),
	        scrollX: false,
	        scrollY: true,
	        rowHeight: 30,
	        useClientSort: false,
	        showDummyRows: true,
	        minBodyHeight: 30,
	        bodyHeight: 100,
	        pagination: true,
	        selectionUnit: 'CELL',
	        editingEvent: true,
	        usageStatistics: false,
	        treeColumnOptions: {
	            name: 'ID',
	            useCascadingCheckbox: false
	        },
	        columns: [
	               { title: 'ID', name: 'id', align: 'center', hidden: true  }
	              ,{ title: '신청ID', name: 'applyId', align: 'center', hidden: true }
	              ,{ title: 'No', name: 'rn', align: 'center' }
	              ,{ title: '직급', name: 'rnkCd', align: 'center'
	            	  , editOptions: {type: 'select', listItems: rnkItems, useViewMode: false}
	               }
	              ,{ title: '수강자이름', name: 'traineeNm', align: 'center'
	            	  , editOptions: { type: 'text', maxLength: 20, useViewMode: false }
	               }
	              ,{ title: '연락처(회사)', name: 'officeTel', align: 'center'
	            	  , editOptions: { type: 'text', maxLength: 13, useViewMode: false }
	               }
	              ,{ title: '연락처(핸드폰)', name: 'moblphonNo', align: 'center'
	            	  , editOptions: { type: 'text', maxLength: 13, useViewMode: false }
	               }
	              ,{ title: 'E-mail', name: 'email', align: 'center'
	            	  , editOptions: { type: 'text', maxLength: 100, useViewMode: false }
	               }
	          ]
	    });
	
	    grid.use('Net', {
	        el: $('#frm_input'),
	        initialRequest: false,
	        readDataMethod: 'GET',
	        perPage: 25,
	        enableAjaxHistory: false,
	        api: {
	            'readData': '${readUrl}'
	        }
	    });
	
	    // Bind event handlers
	    grid.on('beforeRequest', function (data) {
	        // For all requests
	        
	    }).on('response', function (data) {
	        // For all response (regardless of success or failure)
	        
	    }).on('successResponse', function (data) {
	    }).on('failResponse', function (data) {
	    }).on('errorResponse', function (data) {
	    }).on('focusChange', function (eventData) {
	    });
	
	    net = grid.getAddOn('Net');
	    pagination = grid.getPagination();
	    pagination.on('afterMove', function (eventData) {
	        if (grid.getRowCount() > 0) {
	            grid.focusAt(0, 0);
	        }
	    });
	
	    if(_dicasPage.requestParams != null)
	      searchView.submit();
	    
      document.getElementById("container2").style.height = "0px"; 
	    
      setPageUI("init");
    
	});

</script>

