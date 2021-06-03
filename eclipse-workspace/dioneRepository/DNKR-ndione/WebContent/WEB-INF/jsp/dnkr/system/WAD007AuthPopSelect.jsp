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

<script type="text/javascript" src="${pageContext.request.contextPath}/js/commonPop.js"></script>
<c:if test="${fn:length(authList) > 0}">
	<script type="text/javascript">
	var options = [];
	
	
	<c:forEach var="authDomain" items="${authList}" varStatus="status">
	
		options.push({value: "${authDomain.authCode}", text: "${authDomain.authName}"});
	
	</c:forEach>
	</script>
</c:if>
<script type="text/javascript">
$(document.body).ready(function () {
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
    
    $('._saveBtn_').on( 'click', function(e){
		var saveCheck = confirm(LN_CONFIRM_SAVE);
		if(saveCheck){
			var authCodeCheck = $('input[type=radio]:checked').val();
			if(authCodeCheck === undefined){
				toastMsg("권한그룹을 선택해주세요.");
				return false;
			}
			var params = $("#selectConfigForm").serialize();
			$.ajax({
				url: '<c:url value='/WAD006AuthPopSelect/selectConfig.do' />',
				data : params,
				type: 'post',
				success: function() {
					toastMsg("저장완료");
					//console.log("저장완료");
				},
				error: function() {
					
				},
				complete: function() {
					
				}
			});	
		}
		
	});
	
    
    $('._searchBtn_').on( 'click', function(e){
		var researchAuth = $('select.form-control').val() || "";
		location.replace("/WAD006AuthPopSelect/init.do?teamCode=${teamCode}&researchCode="+researchAuth);
	});
    
    $('._closeBtn_').on( 'click', function(e){
		self.close();
	});
    
});
</script>
<h2 class="subpage-tit"><c:out value="${teamName}"/> 권한선택</h2>
<div class="board-bList-wrap">
	<div class="list-top">
		<div class="search">
		
			<div class="row">
			    <div class="col-md-6">
			        <div class="form-group">
			        	<div data-ax5autocomplete="autocomplete1" data-ax5autocomplete-config="{editable: true}"></div>
						<!-- <button class="search-bnt _searchBtn_" type="submit">
							<span>검색</span>
						</button> -->
						<button type="button" class="AXButton Black" onclick="">
							<i class="axi axi-ion-android-search"></i>
							<spring:message code='label.select'/>
						</button>
						<button type="button" class="AXButton Blue _saveBtn_" style=""
							onclick="" data-click-target="auth-save">
							<spring:message code='label.save' />
						</button>
						<button type="button" class="AXButton Normal _closeBtn_" onclick="close(window.self)"
							data-click-target="auth-close">
							<spring:message code='label.close' />
							<!-- 삭제 -->
						</button>
			  		</div>
			    </div>
			</div>
		</div>
		<!-- search -->
	</div>
	<!-- list-top -->
	<div class="gap20"></div>
	<span class="top-border"></span>
	<table>
		<caption></caption>
		<colgroup>
			<col scope="col" width="*">
			<col scope="col" width="*">
			<col scope="col" width="*">
			<col scope="col" width="*">
			<col scope="col" width="*">
		</colgroup>
		<thead>
			<tr>
				<th>번호</th>
				<th>권한그룹명</th>
				<th>권한그룹설명</th>
				<th>선택</th>
			</tr>
		</thead>
		<tbody>
			<form:form action="/WAD006AuthPopSelect/selectConfig.do?" id="selectConfigForm" commandName="relationTeamDomain" name="selectConfigForm"  method="POST">
				<input type="hidden" id="teamCode" name="teamCode" value="${teamCode}"/>
				<c:choose>
					<c:when test="${researchList eq null}">
						<c:if test="${fn:length(authList) > 0}">
							<c:set value="${fn:length(authList)}" var="itemListSize"/>
							<c:forEach var="authDomain" items="${authList}" varStatus="status">
								<tr>
									<td>${itemListSize - status.index}</td>
									<td>${authDomain.authName}</td>
									<td>${authDomain.authDescription}</td>
									<td>
										<input type="radio" name="authCode" value="${authDomain.authCode}"
											<c:if test="${authDomain.authCode eq authCode }">
												checked
											</c:if>
										/>
									</td>
								</tr>
							</c:forEach>
						</c:if>
					</c:when>
					<c:otherwise>
						<c:if test="${fn:length(researchList) > 0}">
							<c:set value="${fn:length(researchList)}" var="itemListSize"/>
							<c:forEach var="authDomain" items="${researchList}" varStatus="status">
								<tr>
									<td>${itemListSize - status.index}</td>
									<td>${authDomain.authName}</td>
									<td>${authDomain.authDescription}</td>
									<td>
										<c:choose>
											<c:when test="${authDomain.useYn eq 'Y'}">
												<input type="radio" name="authCode" value="${authDomain.authCode}"
													<c:if test="${authDomain.authCode eq authCode }">
														checked
													</c:if>
												/>
											</c:when>
											<c:otherwise>
												미사용
											</c:otherwise>
										</c:choose>
											
									</td>
								</tr>
							</c:forEach>
						</c:if>
					</c:otherwise>
				</c:choose>
			</form:form>
		</tbody>
	</table>
	<div class="gap20"></div>
</div>
<!--board-view-wrap-->