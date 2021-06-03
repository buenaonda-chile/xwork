<%--
 * PROJECT：
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
<link rel="stylesheet" type="text/css" href="/js/lib/camohub_sortableList/style.css" media="screen">
<script type="text/javascript" src="/js/lib/camohub_sortableList/jquery-sortable-lists.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/WAD010Menu.js"></script>
<link rel="stylesheet" type="text/css" href="/css/WAD010Menu.css" media="screen">

<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '1' }"><%--조회권한 --%>
	<div class="text_align_left">
		<div class="text_align_right">
			<button type="button" autofocus="true" class="AXButton Normal _iconSearchBtn_" style="" id="" data-click-target="icon_search">
				<!-- 아이콘링크 -->
				<spring:message code='label.WAA002.name'/>
			</button>
			<c:if test="${fn:substring(authBinaryNum, 2, 3) eq '1' }"><%--등록권한 --%>
				<button type="button" class="AXButton Red" style="" id="addMenu" data-click-target="cancel">
					<spring:message code='label.mcdregister'/>	<!-- 등록 -->			
				</button>
			</c:if>
		</div>
		<c:if test="${fn:length(menuList) > 0}">
			<ul class="sTree2 listsClass" id="sTree2">
				<c:forEach var="menuDomain" items="${menuList}" varStatus="status">
					<li id="${menuDomain.mcdCode }" data-depth="1" data-hassub="${menuDomain.subList.size()}" data-haslastsub="">
						<div class="menu_box">
							<c:if test="${fn:substring(authBinaryNum, 1, 2) eq '1' }"><%--수정권한 --%>
								<div class="menu_edit_box" style="display:none">
									<div class="inlineBlock">
								 		ICON : <input type="text" class="clickable mcdIcon" value="${menuDomain.mcdIcon }"/> 
							 		</div> 
									<div style="display: inline-block">
										<spring:message code='label.WAP001.mcdName'/><!-- 메뉴명 --> : <input type="text" class="clickable mcdName" value="${menuDomain.mcdName}">
									</div>
								 	<div class="display_none">
								 		<input type="hidden" class="clickable mcdCode" value="${menuDomain.mcdCode }"/>
							 		</div>
							 		<div class="menu_right_part">
									 	
									 	<div class="display_none">${menuDomain.mcdSort }</div>
									 	<div class="display_none">${menuDomain.mcdRef }</div>
									 	<div style="display: inline-block" class="mcdUrlDiv">
									 		URL : <input type="text" class="clickable mcdUrl" value="${menuDomain.mcdUrl }"/>
								 		</div>
								 		<div class="mcdUseDiv" style="display: inline-block">
									 		<spring:message code='label.newWindow'/><!-- 새창여부 --> : <input type="checkbox" class="clickable mcdNewWindow" value="${menuDomain.mcdNewWindow }"
									 					<c:if test="${menuDomain.mcdNewWindow eq 'Y'}">
									 						checked
									 					</c:if>  
													/>
								 		</div>
								 		<div class="mcdUseDiv" style="display: inline-block">
									 		<spring:message code='label.useYn'/><!-- 사용여부 --> : <input type="checkbox" class="clickable mcdUse" value="${menuDomain.mcdUse }"
									 					<c:if test="${menuDomain.mcdUse eq 'Y'}">
									 						checked
									 					</c:if>  
													/>
								 		</div>
								 		<div class="mcdUseDiv" style="display: inline-block">
									 		<spring:message code='label.certification'/><!-- 추가인증 --> : <input type="checkbox" class="clickable mcdAddCert" value="${menuDomain.mcdAddCert}"
									 					<c:if test="${menuDomain.mcdAddCert eq 'Y'}">
									 						checked
									 					</c:if>  
													/>
								 		</div>
								 		<div class="mcdUseDiv" style="display: inline-block">
									 		<spring:message code='label.mobile'/><!-- 모바일여부 --> : <input type="checkbox" class="clickable mcdMobile" value="${menuDomain.mcdMobile}"
									 					<c:if test="${menuDomain.mcdMobile eq 'Y'}">
									 						checked
									 					</c:if>  
													/>
								 		</div>
									 	<div class="display_none">depth:${menuDomain.mcdDepth }</div>
									 	<button type="button" class="AXButton Red _saveBtn_ clickable" style="" onclick = "" data-click-target="update">
											<spring:message code='label.save'/>	<!-- 저장  -->			
										</button>
										<button type="button" class="AXButton Normal _cancelBtn_ clickable" style="" onclick = "" data-click-target="cancel">
											<spring:message code='label.cancel'/>	<!-- 취소  -->			
										</button>
									</div>
							 	</div>
						 	</c:if>
							<div class="paddingZero">
								<div class="mcdIcon inlineBlock fl"><span class="${menuDomain.mcdIcon}"></span></div>
								<div class="mcdName inlineBlock fl">${menuDomain.mcdName}</div>
							 	<div class="display_none">${menuDomain.mcdCode }</div>
							 	<div class="menu_right_part">							 	
								 	<div class="display_none">${menuDomain.mcdSort }</div>
								 	<div class="display_none">${menuDomain.mcdRef }</div>
								 	<div class="mcdUrlDiv" style="display: inline-block">
								 		URL : <span class="mcdUrl">${menuDomain.mcdUrl }</span>
							 		</div>
							 		<div class="mcdUseDiv" style="display: inline-block">
								 		<spring:message code='label.newWindow'/><!-- 새창여부 --> : <span class="mcdNewWindow">
									 				<c:choose>
											 			<c:when test="${menuDomain.mcdNewWindow eq 'Y'}"><spring:message code='label.useY'/><!-- 사용 --></c:when>
									 					<c:otherwise><spring:message code='label.useN'/><!-- 미사용 --></c:otherwise>
								 					</c:choose>
						 					  </span>
							 		</div>
							 		<div class="mcdUseDiv" style="display: inline-block">
								 		<spring:message code='label.useYn'/><!-- 사용여부 --> : <span class="mcdUse">
									 				<c:choose>
											 			<c:when test="${menuDomain.mcdUse eq 'Y'}"><spring:message code='label.useY'/><!-- 사용 --></c:when>
									 					<c:otherwise><spring:message code='label.useN'/><!-- 미사용 --></c:otherwise>
								 					</c:choose>
						 					  </span>
							 		</div>
							 		<div class="mcdUseDiv" style="display: inline-block">
								 		<spring:message code='label.certification'/><!-- 추가인증 --> : <span class="mcdAddCert">
									 				<c:choose>
											 			<c:when test="${menuDomain.mcdAddCert eq 'Y'}"><spring:message code='label.useY'/><!-- 사용 --></c:when>
									 					<c:otherwise><spring:message code='label.useN'/><!-- 미사용 --></c:otherwise>
								 					</c:choose>
						 					  </span>
							 		</div>
							 		<div class="mcdUseDiv" style="display: inline-block">
								 		<spring:message code='label.mobile'/><!-- 모바일여부 --> : <span class="mcdMobile">
									 				<c:choose>
											 			<c:when test="${menuDomain.mcdMobile eq 'Y'}"><spring:message code='label.useY'/><!-- 사용 --></c:when>
									 					<c:otherwise><spring:message code='label.useN'/><!-- 미사용 --></c:otherwise>
								 					</c:choose>
						 					  </span>
							 		</div>
								 	<div class="display_none">depth:${menuDomain.mcdDepth }</div>
								 	<c:if test="${fn:substring(authBinaryNum, 1, 2) eq '1' }"><%--수정권한 --%>
									 	<button type="button" class="AXButton Red _modifyBtn_ clickable" style="" onclick = "" data-click-target="">
											<spring:message code='label.modify'/>	<!-- 수정  -->			
										</button>
									</c:if>
									<c:if test="${fn:substring(authBinaryNum, 0, 1) eq '1' }"><%--삭제권한 --%>
										<button type="button" class="AXButton Normal clickable" style="" onclick = "remove(this)" data-click-target="">
											<spring:message code='label.delete'/>	<!-- 삭제  -->			
										</button>
									</c:if>
								</div>
						 	</div>
					 	</div>
						 	<c:if test="${fn:length(menuDomain.subList)>0}">
						 		<ul>
							 		<c:forEach var="subDomain" items="${menuDomain.subList}" varStatus="status">
							 			<li id="${subDomain.mcdCode}" data-depth="2" data-hassub="${subDomain.subList.size()}">
								 			<div class="menu_box">
								 				<c:if test="${fn:substring(authBinaryNum, 1, 2) eq '1' }"><%--수정권한 --%>
									 				<div class="menu_edit_box" style="display:none">
									 					<div style="display: inline-block" class="">
															ICON : <input type="text" class="clickable mcdIcon" value="${subDomain.mcdIcon }"/>
													 	</div>
														<div style="display: inline-block">
															<spring:message code='label.WAP001.mcdName'/><!-- 메뉴명 --> : <input type="text" class="clickable mcdName" value="${subDomain.mcdName }">
														</div>
													 	<div class="display_none">
													 		<input type="hidden" class="clickable mcdCode" value="${subDomain.mcdCode }"/>
												 		</div>
												 		<div class="menu_right_part">
														 	
														 	<div class="display_none">${subDomain.mcdSort }</div>
														 	<div class="display_none">${subDomain.mcdRef }</div>
														 	<div style="display: inline-block" class="mcdUrlDiv">
														 		URL : <input type="text" class="clickable mcdUrl" value="${subDomain.mcdUrl }"/>
													 		</div>
													 		<div class="mcdUseDiv" style="display: inline-block">
														 		<spring:message code='label.newWindow'/><!-- 새창여부 --> : <input type="checkbox" class="clickable mcdNewWindow" value="${subDomain.mcdNewWindow }" 
														 					<c:if test="${subDomain.mcdNewWindow eq 'Y'}">
														 						checked
														 					</c:if> 
														 				/>
													 		</div>
													 		<div class="mcdUseDiv" style="display: inline-block">
														 		<spring:message code='label.useYn'/><!-- 사용여부 --> : <input type="checkbox" class="clickable mcdUse" value="${subDomain.mcdUse }" 
														 					<c:if test="${subDomain.mcdUse eq 'Y'}">
														 						checked
														 					</c:if> 
														 				/>
													 		</div>
													 		<div class="mcdUseDiv" style="display: inline-block">
														 		<spring:message code='label.certification'/><!-- 추가인증 --> : <input type="checkbox" class="clickable mcdAddCert" value="${subDomain.mcdAddCert}"
														 					<c:if test="${subDomain.mcdAddCert eq 'Y'}">
														 						checked
														 					</c:if> 
														 				/>
													 		</div>
													 		<div class="mcdUseDiv" style="display: inline-block">
														 		<spring:message code='label.mobile'/><!-- 모바일 여부 --> : <input type="checkbox" class="clickable mcdMobile" value="${subDomain.mcdMobile}"
														 					<c:if test="${subDomain.mcdMobile eq 'Y'}">
														 						checked
														 					</c:if> 
														 				/>
													 		</div>
														 	<div class="display_none">depth:${subDomain.mcdDepth }</div>
														 	<button type="button" class="clickable AXButton Red _saveBtn_" style="" onclick = "" data-click-target="update">
																<spring:message code='label.save'/>	<!-- 저장  -->			
															</button>
															<button type="button" class="AXButton Normal _cancelBtn_ clickable" style="" onclick = "" data-click-target="cancel">
																<spring:message code='label.cancel'/>	<!-- 취소  -->			
															</button>
														</div>
												 	</div>
											 	</c:if>
								 				<div class="paddingZero">
								 					<div class="mcdIcon inlineBlock fl"><span class="${subDomain.mcdIcon}"></span></div>
										 			<div class="mcdName inlineBlock fl">${subDomain.mcdName}</div>
												 	<div class="display_none">${subDomain.mcdCode }</div>
												 	<div class="menu_right_part">
													 	
													 	<div class="display_none">${subDomain.mcdSort }</div>
													 	<div class="display_none">${subDomain.mcdRef }</div>
													 	<div class="mcdUrlDiv" style="display: inline-block">
													 		URL : <span class="mcdUrl">${subDomain.mcdUrl }</span>
													 	</div>
													 	<div class="mcdUseDiv" style="display: inline-block">
													 		<spring:message code='label.newWindow'/><!-- 새창여부 --> : <span class="mcdNewWindow">
													 					<c:choose>
																 			<c:when test="${subDomain.mcdNewWindow eq 'Y'}"><spring:message code='label.useY'/><!-- 사용 --></c:when>
														 					<c:otherwise><spring:message code='label.useN'/><!-- 미사용 --></c:otherwise>
												 						</c:choose>
												 					</span>
												 		</div>
													 	<div class="mcdUseDiv" style="display: inline-block">
													 		<spring:message code='label.useYn'/><!-- 사용여부 --> : <span class="mcdUse">
													 					<c:choose>
																 			<c:when test="${subDomain.mcdUse eq 'Y'}"><spring:message code='label.useY'/><!-- 사용 --></c:when>
														 					<c:otherwise><spring:message code='label.useN'/><!-- 미사용 --></c:otherwise>
												 						</c:choose>
												 					</span>
												 		</div>
												 		<div class="mcdUseDiv" style="display: inline-block">
													 		<spring:message code='label.certification'/><!-- 추가인증 --> : <span class="mcdAddCert">
															 			<c:choose>
																 			<c:when test="${subDomain.mcdAddCert eq 'Y'}"><spring:message code='label.useY'/><!-- 사용 --></c:when>
														 					<c:otherwise><spring:message code='label.useN'/><!-- 미사용 --></c:otherwise>
												 						</c:choose>
												 					</span>
												 		</div>
												 		<div class="mcdUseDiv" style="display: inline-block">
													 		<spring:message code='label.mobile'/><!-- 모바일여부 --> : <span class="mcdMobile">
															 			<c:choose>
																 			<c:when test="${subDomain.mcdMobile eq 'Y'}"><spring:message code='label.useY'/><!-- 사용 --></c:when>
														 					<c:otherwise><spring:message code='label.useN'/><!-- 미사용 --></c:otherwise>
												 						</c:choose>
												 					</span>
												 		</div>
													 	<div class="display_none">depth:${subDomain.mcdDepth }</div>
													 	<c:if test="${fn:substring(authBinaryNum, 1, 2) eq '1' }"><%--수정권한 --%>
														 	<button type="button" class="AXButton Red _modifyBtn_ clickable" style="" onclick = "" data-click-target="">
																<spring:message code='label.modify'/>	<!-- 수정  -->			
															</button>
														</c:if>
														<c:if test="${fn:substring(authBinaryNum, 0, 1) eq '1' }"><%--삭제권한 --%>
															<button type="button" class="AXButton Normal clickable" style="" onclick = "remove(this)" data-click-target="">
																<spring:message code='label.delete'/>	<!-- 삭제  -->			
															</button>
														</c:if>
													</div>
											 	</div>
										 	</div>
											 	<c:if test="${fn:length(subDomain.subList)>0}">
											 		<ul>
												 		<c:forEach var="lastSubDomain" items="${subDomain.subList}" varStatus="status">
												 			<script>
												 				/* script 위치이동 불가  */
												 				$('li#${menuDomain.mcdCode}').attr('data-haslastsub', '1');
												 			</script>
												 			<li id="${lastSubDomain.mcdCode}" data-depth="3" data-hassub="${lastSubDomain.subList.size()}">
												 				<div class="menu_box">
												 					<c:if test="${fn:substring(authBinaryNum, 1, 2) eq '1' }"><%--수정권한 --%>
														 				<div class="menu_edit_box" style="display:none">
															 				<div style="display: inline-block" class="">
																		 		ICON : <input type="text" class="clickable mcdIcon" value="${lastSubDomain.mcdIcon }"/>
																	 		</div>
																			<div style="display: inline-block">
																				<spring:message code='label.WAP001.mcdName'/><!-- 메뉴명 --> : <input type="text" class="clickable mcdName" value="${lastSubDomain.mcdName }">
																			</div>
																		 	<div class="display_none">
																		 		<input type="hidden" class="clickable mcdCode" value="${lastSubDomain.mcdCode }"/>
																	 		</div>
																	 		<div class="menu_right_part">
																			 	<div class="display_none">${lastSubDomain.mcdSort }</div>
																			 	<div class="display_none">${lastSubDomain.mcdRef }</div>
																			 	<div style="display: inline-block" class="mcdUrlDiv">
																			 		URL : <input type="text" class="clickable mcdUrl" value="${lastSubDomain.mcdUrl }"/>
																		 		</div>
																		 		<div class="mcdUseDiv" style="display: inline-block">
																			 		<spring:message code='label.newWindow'/><!-- 새창여부 --> : <input type="checkbox" class="clickable mcdNewWindow" value="${lastSubDomain.mcdNewWindow }" 
																			 					<c:if test="${lastSubDomain.mcdNewWindow eq 'Y'}">
														 											checked
														 										</c:if> 
																			 				/>
																		 		</div>
																		 		<div class="mcdUseDiv" style="display: inline-block">
																			 		<spring:message code='label.useYn'/><!-- 사용여부 --> : <input type="checkbox" class="clickable mcdUse" value="${lastSubDomain.mcdUse }" 
																			 					<c:if test="${lastSubDomain.mcdUse eq 'Y'}">
														 											checked
														 										</c:if> 
																			 				/>
																		 		</div>
																		 		<div class="mcdUseDiv" style="display: inline-block">
																			 		<spring:message code='label.certification'/><!-- 추가인증 --> : <input type="checkbox" class="clickable mcdAddCert" value="${lastSubDomain.mcdAddCert}"
																			 					<c:if test="${lastSubDomain.mcdAddCert eq 'Y'}">
														 											checked
														 										</c:if> 
																			 				/>
																		 		</div>
																		 		<div class="mcdUseDiv" style="display: inline-block">
																			 		<spring:message code='label.mobile'/><!-- 모바일사용여부 --> : <input type="checkbox" class="clickable mcdMobile" value="${lastSubDomain.mcdMobile}"
																			 					<c:if test="${lastSubDomain.mcdMobile eq 'Y'}">
														 											checked
														 										</c:if> 
																			 				/>
																		 		</div>
																			 	<div class="display_none">depth:${lastSubDomain.mcdDepth }</div>
																			 	<button type="button" class="AXButton Red _saveBtn_ clickable" style="" onclick = "" data-click-target="update">
																					<spring:message code='label.save'/>	<!-- 저장  -->			
																				</button>
																				<button type="button" class="AXButton Normal _cancelBtn_ clickable" style="" onclick = "" data-click-target="cancel">
																					<spring:message code='label.cancel'/>	<!-- 취소  -->			
																				</button>
																			</div>
																	 	</div>
																 	</c:if>
																 	<div class="paddingZero">
																 		<div class="mcdIcon inlineBlock fl"><span class="${lastSubDomain.mcdIcon}"></span></div>
																 		<div class="mcdName inlineBlock fl">${lastSubDomain.mcdName}</div>
																	 	<div class="display_none">${lastSubDomain.mcdCode }</div>
																	 	<div class="menu_right_part">
																		 	<div class="display_none">${lastSubDomain.mcdSort }</div>
																		 	<div class="display_none">${lastSubDomain.mcdRef }</div>
																		 	<div class="mcdUrlDiv" style="display: inline-block">
																		 		URL : <span class="mcdUrl">${lastSubDomain.mcdUrl }</span>
																	 		</div>
																	 		<div class="mcdUseDiv" style="display: inline-block">
																		 		<spring:message code='label.newWindow'/><!-- 새창여부 --> :  <span class="mcdNewWindow">  
																			 				<c:choose>
																					 			<c:when test="${lastSubDomain.mcdNewWindow eq 'Y'}"><spring:message code='label.useY'/><!-- 사용 --></c:when>
																			 					<c:otherwise><spring:message code='label.useN'/><!-- 미사용 --></c:otherwise>
																		 					</c:choose>
																	 					</span>
																	 		</div>
																	 		<div class="mcdUseDiv" style="display: inline-block">
																		 		<spring:message code='label.useYn'/><!-- 사용여부 --> :  <span class="mcdUse">  
																			 				<c:choose>
																					 			<c:when test="${lastSubDomain.mcdUse eq 'Y'}"><spring:message code='label.useY'/><!-- 사용 --></c:when>
																			 					<c:otherwise><spring:message code='label.useN'/><!-- 미사용 --></c:otherwise>
																		 					</c:choose>
																	 					</span>
																	 		</div>
																	 		<div class="mcdUseDiv" style="display: inline-block">
																		 		<spring:message code='label.certification'/><!-- 추가인증 --> :  <span class="mcdAddCert"> 
																		 					<c:choose>
																					 			<c:when test="${lastSubDomain.mcdAddCert eq 'Y'}"><spring:message code='label.useY'/><!-- 사용 --></c:when>
																			 					<c:otherwise><spring:message code='label.useN'/><!-- 미사용 --></c:otherwise>
																		 					</c:choose>
																	 					</span>
																	 		</div>
																	 		<div class="mcdUseDiv" style="display: inline-block">
																		 		<spring:message code='label.mobile'/><!--모바일사용여부 --> :  <span class="mcdMobile"> 
																		 					<c:choose>
																					 			<c:when test="${lastSubDomain.mcdMobile eq 'Y'}"><spring:message code='label.useY'/><!-- 사용 --></c:when>
																			 					<c:otherwise><spring:message code='label.useN'/><!-- 미사용 --></c:otherwise>
																		 					</c:choose>
																	 					</span>
																	 		</div>
																		 	<div class="display_none">depth:${lastSubDomain.mcdDepth }</div>
																		 	<c:if test="${fn:substring(authBinaryNum, 1, 2) eq '1' }"><%--수정권한 --%>
																			 	<button type="button" class="AXButton Red _modifyBtn_ clickable" style="" onclick = "" data-click-target="">
																					<spring:message code='label.modify'/>	<!-- 수정  -->			
																				</button>
																			</c:if>
																			<c:if test="${fn:substring(authBinaryNum, 0, 1) eq '1' }"><%--삭제권한 --%>
																				<button type="button" class="AXButton Normal clickable" style="" onclick = "remove(this)" data-click-target="">
																					<spring:message code='label.delete'/>	<!-- 삭제  -->			
																				</button>
																			</c:if>
																		</div>
																 	</div>
															 	</div>
														 	</li>
													 	</c:forEach>
												 	</ul>	
											 	</c:if>
									 	</li>
							 		</c:forEach> 	
							 	</ul>	
						 	</c:if>
					 	
				 	</li>
				</c:forEach>
			</ul>
		</c:if>
		
	</div>
</c:if>
<c:if test="${fn:substring(authBinaryNum, 3, 4) eq '0' }"><%--조회권한 --%>
	<div>
		<span><spring:message code='DNKR-E2-0000'/><!-- 권한이 없습니다. --></span>
	</div>
</c:if>