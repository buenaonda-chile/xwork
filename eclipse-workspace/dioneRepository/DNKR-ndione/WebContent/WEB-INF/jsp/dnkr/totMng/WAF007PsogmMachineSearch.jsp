<%--
 * PROJECT：
 *
 * [KR] 
 * 
 * $Id$
 *
 * Copyright (c) 2017 DENSO CORPORATION. All rights reserved.
 *
--%>
<!-- [EN] Contents area -->
<!-- [JP] コンテンツエリア -->
<%-- <spring:message code="label.filename" /> : <c:out value="${url }"></c:out> --%>

<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/css/board.css" /> --%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/wafCommon.css" />

<script src="${pageContext.request.contextPath}/js/content.js"></script>
<%-- <script src="${pageContext.request.contextPath}/js/waf/WAF001Psogm_ogm411.js"></script> --%>
<script src="${pageContext.request.contextPath}/js/waf/WAF007PsogmMachine.js?ver"></script>

<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%-- 조회권한 --%>

<div class="gm_03_02_02_wrap project02_wrap waf_wrap">
		<form:form action="${pageContext.request.contextPath}/WAF007PsogmMachineSearch/search.do?tabId=${tabId}&menu=${menu}" method="POST" modelAttribute="WAF007PsogmMachineSearchForm" name="WAF007PsogmMachineSearchForm">
			<div class="top-btns fr">
				<button type="button" class="AXButton Black _searchBtn_">
					<i class="axi axi-ion-android-search"><spring:message code='label.search'/><!-- 조회 --></i>
				</button>
				<button type="button" class="downLoad _excelBtn_">
					<span><spring:message code='label.excelDown' /><!-- 엑셀다운 --></span>
				</button>
			</div>
			<div class="list-top cb pt5">
				<table class="pd-s-table">
					<colgroup>
						<col style="width:120px;" />
						<col style="width:300px;" />
						<col style="width:120px;" />
						<col style="width:*px" />
					</colgroup>
					<tbody>
						<tr>
							<th>
								사업부
							</th>
							<td colspan = "5">
								<select autofocus="true" name="COMP" id="ComboBoxPlant" dataSet="ds_ComCode_PLNT">
									<c:if test="${fn:length(codeList) > 0}">
										<c:forEach var="codeD2Domain" items="${codeList}" varStatus="status">
											<option value="${codeD2Domain.code2}"><c:out value="${codeD2Domain.code_name}"/></option>
										</c:forEach>
									</c:if>
								</select>
							</td>
						</tr>
						<tr>
							<th>교정분야</th>
							<td colspan="2">
								<input id="chk_group1" name="coType" value="" class="radio-st01" type="checkbox"><label for="chk_group1"><span class="radio-deco"></span> 측정기</label>
								<input id="chk_group2" name="coType" value="" class="radio-st01" type="checkbox"><label for="chk_group2"><span class="radio-deco"></span> 검사구</label>
								<input id="chk_group3" name="coType" value="" class="radio-st01" type="checkbox"><label for="chk_group3"><span class="radio-deco"></span> 설비</label>
							</td>
							<th colspan="2" style="width:120px">폐기여부</th>
							<td>
								<input name="rd_endYN" value="" id="dis-all" class="radio-st01" type="radio" checked><label for="dis-all"><span class="radio-deco"></span> 전체</label>
								<input name="rd_endYN" value="N" id="dis-n" class="radio-st01" type="radio"><label for="dis-n"><span class="radio-deco"></span> 사용</label>
								<input name="rd_endYN" value="Y" id="dis-y" class="radio-st01" type="radio"><label for="dis-y"><span class="radio-deco"></span> 폐기</label>
							</td>
						</tr>
					</tbody>
				</table>
			</div><!--list-top-->

			<div class="ssgap"></div>

			<div class="cont">
				<div class="sssgap"></div>

				<div class="">
				<div class="m-scroll">
					<table class="pd-s-table">
						<caption>조회항목선택표</caption>
						<colgroup>
							<col width="80px">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th rowspan="3">조회항목</th>
								<td>
									<input name="viewLst" value="" id="chk_Field1" onclick="return false;" class="radio-st01" type="checkbox" checked><label for="chk_Field1"><span class="radio-deco"></span> 교정분야</label>
								</td>
								<td>
									<input name="viewLst" value="" id="chk_Field2" class="radio-st01" type="checkbox" checked><label for="chk_Field2"><span class="radio-deco"></span> 관리번호</label>
								</td>
								<td>
									<input name="viewLst" value="" id="chk_Field3" class="radio-st01" type="checkbox" checked><label for="chk_Field3"><span class="radio-deco"></span> 장비명</label>
								</td>
								<td>
									<input name="viewLst" value="" id="chk_Field4" class="radio-st01" type="checkbox" checked><label for="chk_Field4"><span class="radio-deco"></span> 제조회사</label>
								</td>
								<td>
									<input name="viewLst" value="" id="chk_Field5" class="radio-st01" type="checkbox" checked><label for="chk_Field5"><span class="radio-deco"></span> 형식</label>
								</td>
								<td>
									<input name="viewLst" value="" id="chk_Field6" class="radio-st01" type="checkbox" checked><label for="chk_Field6"><span class="radio-deco"></span> 장비번호</label>
								</td>
								<td>
									<input name="viewLst" value="" id="chk_Field7" class="radio-st01" type="checkbox" checked><label for="chk_Field7"><span class="radio-deco"></span> 입고일자</label>
								</td>
								<td>
									<input name="viewLst" value="" id="chk_Field8" class="radio-st01" type="checkbox" checked><label for="chk_Field8"><span class="radio-deco"></span> 최종교정일</label>
								</td>
							<tr>
								<td>
									<input name="viewLst" value="" id="chk_Field9" class="radio-st01" type="checkbox" checked><label for="chk_Field9"><span class="radio-deco"></span> 교정번호</label>
								</td>
								<td>
									<input name="viewLst" value="" id="chk_Field10" class="radio-st01" type="checkbox" checked><label for="chk_Field10"><span class="radio-deco"></span> 예정일자</label>
								</td>
								<td>
									<input name="viewLst" value="" id="chk_Field11" class="radio-st01" type="checkbox" checked><label for="chk_Field11"><span class="radio-deco"></span> 사용부서</label>
								</td>
								<td>
									<input name="viewLst" value="" id="chk_Field12" class="radio-st01" type="checkbox" checked><label for="chk_Field12"><span class="radio-deco"></span> 폐기여부</label>
								</td>
								<td>
									<input name="viewLst" value="" id="chk_Field13" class="radio-st01" type="checkbox" checked><label for="chk_Field13"><span class="radio-deco"></span> 폐기일자</label>
								</td>
								<td>
									<input name="viewLst" value="" id="chk_Field14" class="radio-st01" type="checkbox" checked><label for="chk_Field14"><span class="radio-deco"></span> 폐기사유</label>
								</td>
								<td>
									<input name="viewLst" value="" id="chk_Field15" class="radio-st01" type="checkbox" checked><label for="chk_Field15"><span class="radio-deco"></span> 장비구분</label>
								</td>
								<td>
									<input name="viewLst" value="" id="chk_Field16" class="radio-st01" type="checkbox" checked><label for="chk_Field16"><span class="radio-deco"></span> 장비유형</label>
								</td>
							</tr>
							<tr>
								<td>
									<input name="viewLst" value="" id="chk_Field17" class="radio-st01" type="checkbox" checked><label for="chk_Field17"><span class="radio-deco"></span> 교정구분</label>
								</td>
								<td>
									<input name="viewLst" value="" id="chk_Field18" class="radio-st01" type="checkbox" checked><label for="chk_Field18"><span class="radio-deco"></span> 교정주기</label>
								</td>
								<td>
									<input name="viewLst" value="" id="chk_Field19" class="radio-st01" type="checkbox" checked><label for="chk_Field19"><span class="radio-deco"></span> 취득금액</label>
								</td>
								<td>
									<input name="viewLst" value="" id="chk_Field20" class="radio-st01" type="checkbox" checked><label for="chk_Field20"><span class="radio-deco"></span> 기기사양</label>
								</td>
								<td>
									<input name="viewLst" value="" id="chk_Field21" class="radio-st01" type="checkbox" checked><label for="chk_Field21"><span class="radio-deco"></span> 자산번호</label>
								</td>
								<td>
									<input name="viewLst" value="" id="chk_Field22" class="radio-st01" type="checkbox" checked><label for="chk_Field22"><span class="radio-deco"></span> 비고</label>
								</td>
								<td></td>
								<td></td>
							</tr>
						</tbody>
					</table>
				</div>
				</div>
				
				<div class="sssgap"></div>

				<div class="sc-condi">
					<table class="pd-s-table">
						<caption>검색조건선택표</caption>
						<colgroup>
							<col width="80px">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th>검색조건</th>
								<td>
									<select id="cmb_field1" onchange="cmb_field_OnChanged(this)" data-target="1" name="sc-condi" title="검색조건을 선택해주세요" class="sel-st01">
										<option value=""></option>
										<option value="MNGNO">관리번호</option>
										<option value="MNAME">장&nbsp;비&nbsp;명</option>
										<option value="MAKER">제조회사</option>
										<option value="MTYPE">형&nbsp;&nbsp;&nbsp;&nbsp;식</option>
										<option value="JNBNO">장비번호</option>
										<option value="IPDAT">입고일자</option>
										<option value="RPDAT">최종교정일</option>
										<option value="REPNO">교정번호</option>
										<option value="YEDAT">예정일자</option>
										<option value="DPTCD">사용부서</option>
										<option value="DISYN">폐기여부</option>
										<option value="DIDAT">폐기일자</option>
										<option value="DRESN">폐기사유</option>
										<option value="J_GUB">장비구분</option>
										<option value="JKIND">장비유형</option>
										<option value="G_GUB">교정구분</option>
										<option value="GCYCL">교정주기</option>
										<option value="GNAMT">취득금액</option>
										<option value="JSPEC">기기사양</option>
										<option value="ACCNO">자산번호</option>
										<option value="CNOTE">비&nbsp;&nbsp;고</option>
									</select>	
									<select id="cmb_operatot1" name="sc-condi" title="검색조건을 선택해주세요" class="sel-st01">
										<option value=""></option>
										<option>=</option>
										<option><></option>
										<option>></option>
										<option><</option>
										<option>>=</option>
										<option><=</option>
									</select>
									<!-- <div  id="cal_where1" class="displayNone">	 -->
									<div class="dropdown displayNone" id="cal_where1">
										<!-- <span class="calendar_icon vcen2"></span> -->
										<input type="text" class="dropbtn calendar_input"  title="검색조건을 입력해주세요">
										<%-- <form:input type="text" class="dropbtn calendar_input" path="startDate" name="startDate" id="startDate"/> --%>
										<div class="dropdown-menu" role="menu"  id="calendar_where1" style="width:250px;
										           border:1px solid #ccc;
										           border-radius: 5px;
										           padding: 5px;
										           overflow: hidden;" >
										</div>
									</div>
									<!-- </div> -->
									<select id="cmb_where1" onchange="cmb_where_onchange(this)" data-target="1" class="displayNone"  title="검색조건을 선택해주세요" >
										<option></option>									
									</select>
									<input type="text" id="ed_where1" class="" title="검색조건을 입력해주세요">
									<input type="text" value="" id="lblselfield1" class="displayNone">
									
									<select id="cmb_Lo" name="sc-condi" title="검색조건을 선택해주세요" class="sel-st01 andOr">
										<option>AND</option>
										<option>OR</option>
									</select>

									<select id="cmb_field2" onchange="cmb_field_OnChanged(this)" data-target="2" name="sc-condi" title="검색조건을 선택해주세요" class="sel-st01">
										<option value=""></option>
										<option value="MNGNO">관리번호</option>
										<option value="MNAME">장&nbsp;비&nbsp;명</option>
										<option value="MAKER">제조회사</option>
										<option value="MTYPE">형&nbsp;&nbsp;&nbsp;&nbsp;식</option>
										<option value="JNBNO">장비번호</option>
										<option value="IPDAT">입고일자</option>
										<option value="RPDAT">최종교정일</option>
										<option value="REPNO">교정번호</option>
										<option value="YEDAT">예정일자</option>
										<option value="DPTCD">사용부서</option>
										<option value="DISYN">폐기여부</option>
										<option value="DIDAT">폐기일자</option>
										<option value="DRESN">폐기사유</option>
										<option value="J_GUB">장비구분</option>
										<option value="JKIND">장비유형</option>
										<option value="G_GUB">교정구분</option>
										<option value="GCYCL">교정주기</option>
										<option value="GNAMT">취득금액</option>
										<option value="JSPEC">기기사양</option>
										<option value="ACCNO">자산번호</option>
										<option value="CNOTE">비&nbsp;&nbsp;고</option>
									</select>	
									<select id="cmb_operatot2" name="sc-condi" title="검색조건을 선택해주세요" class="sel-st01">
										<option value=""></option>
										<option>=</option>
										<option><></option>
										<option>></option>
										<option><</option>
										<option>>=</option>
										<option><=</option>
									</select>
									<!-- <input type="text" id="cal_where2" title="검색조건을 입력해주세요"> -->
									<div class="dropdown displayNone" id="cal_where2">
										<!-- <span class="calendar_icon vcen2"></span> -->
										<input type="text" class="dropbtn calendar_input"  title="검색조건을 입력해주세요">
										<%-- <form:input type="text" class="dropbtn calendar_input" path="startDate" name="startDate" id="startDate"/> --%>
										<div class="dropdown-menu" role="menu"  id="calendar_where2" style="width:250px;
										           border:1px solid #ccc;
										           border-radius: 5px;
										           padding: 5px;
										           overflow: hidden;" >
										</div>
									</div>
									<select id="cmb_where2" onchange="cmb_where_onchange(this)" data-target="2" class="displayNone"  title="검색조건을 선택해주세요" >
										<option></option>									
									</select>
									<input type="text" id="ed_where2" class="" title="검색조건을 입력해주세요">
									<input type="text" value="" id="lblselfield2" class="displayNone">
								</td>
							</tr>
						</tbody>
					</table>
				</div>

				<div class="sgap"></div>				
				<div style="position: relative;height:400px;" id="grid-parent">
				    <div data-ax5grid="first-grid" data-ax5grid-config="{
				                    showLineNumber: true,
				                    showRowSelector: true,
				                    sortable: true,
				                    header: {align:"center"}
				                    }" style="height: 100%;"></div>
				</div>	
				
				<div class="gap20"></div>
					
				<%-- <c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }">ì¡°íê¶í
					<c:if test="${fn:length(machineList) > 0}">
					<c:if test="${false}">
						<div class="pagenation">
				            <smpl:seqpaging maxSeq="10" action='${pageContext.request.contextPath}/WAF007PsogmMachineSearch/search.do?tabId=${tabId}&menu=${menu}' formId="WAF007PsogmMachineSearchForm" />
				        </div>
				        <ai:pagingoption countPerPage="10" />
			        </c:if>
				</c:if> --%>
				
				<div class="gap20"></div>
			</div><!--cont-->
		</form:form>
		<div class="gap"></div>
	</div><!--장비조회 cont_e-->

</c:if>