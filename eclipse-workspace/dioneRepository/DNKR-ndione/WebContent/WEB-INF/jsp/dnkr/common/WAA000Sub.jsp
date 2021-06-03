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
<%-- [EN] Contents area --%>
<%-- [JP] コンテンツエリア --%>

<link rel="stylesheet" media="all" href="/css/main-b.css?ver=1"/>
<jsp:include page="/WEB-INF/jsp/dnkr/common/ShorcutMenu.jsp" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/main-b.js?ver=1"></script>

<div class="cont-wrap">
   	<div class="sub-tab">
   		<div id="myTab04" class="tab-slide"></div>
    		<script type="text/javascript">
    		var cnt = null;
    		$("#myTab04").bindTab({
				theme : "AXTabsLarge",
				value:"1",
				overflow:"scroll",
				scrollAmount:5,
				options:[],
				onchange: function(selectedObject, value){
					var obj = this;
					var title = selectedObject.optionText;
					//toast.push(Object.toJSON(selectedObject));
					//toast.push(Object.toJSON(value));
					if(!document.getElementById("tabDiv"+obj.index)){
						var contentsLayout = "<div id='tabDiv"+obj.index+"' class='tabDiv' style='display:none;'><iframe></iframe></div>";
    					$(".sub-con-wrap").append($(contentsLayout));
    					$("#tabDiv"+obj.index+" iframe").attr("src",value+"&tabId=tabDiv"+obj.index);
					}
					$(".subpage-tit").text(title);
					$(".tabDiv").css("display","none");
					$("#tabDiv"+obj.index).css("display","block");
					cnt = $(".tabDiv").length;
				},
				onclose: function(selectedObject, value){
					//닫은 탭 콘텐츠 삭제하기
					var i;
					$('#tabDiv'+this.index).remove();
					var index_d = this.index*1;
					for(i=0;i<cnt-1;i++){
						$('#tabDiv'+((index_d+1)+i)).attr("id",'tabDiv'+(index_d+i));	
					}
					if(cnt <= 2){
						$("#tabDiv0").css("display","block");
					} else {
						if(this.index == 0){
							$("#tabDiv1").css("display","block");
						}
					}
					//toast.push(Object.toJSON(this));
					//toast.push(Object.toJSON(selectedObject));
					//toast.push("onclose: "+Object.toJSON(value));
				}
			});    
    		
    		function toLogin(){
    			location.href='<c:url value="/"/>';
    		}
    		
    		</script>
	</div><!-- sub-tab -->
	<div class="sub-con-wrap">
		<h2 class="subpage-tit">공지사항</h2>
      		
    </div>
</div><!-- con-wrap -->
<div class="sub-con-bg"></div>
<c:if test="${!empty menu}">
	<div id="menuValue" style="display:none;"><c:out value="${menu}"/></div>
	<div id="pType" style="display:none;"><c:out value="${pType}"/></div>
	<script type="text/javascript">
		var menuValue = document.getElementById("menuValue").innerText;
		var pType = document.getElementById("pType").innerText;
		var obj = document.getElementById(menuValue);
		if(pType.trim() !== '') {
			loadTab(obj, pType);
		} else {
			loadTab(obj);	
		}
		 
	</script>
</c:if>
