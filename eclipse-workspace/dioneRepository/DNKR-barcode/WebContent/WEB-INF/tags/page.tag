<%@ tag import="com.denso.common.intf.Page"%>
<%@ tag body-content="empty" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="page" rtexprvalue="true" required="true" type="com.denso.common.intf.Page" %>
<%@ attribute name="groupSize" rtexprvalue="true" required="true" type="java.lang.Integer" %>
<%@ attribute name="func" rtexprvalue="true" required="true" type="java.lang.String" %>

<%!
private String getCallFuncStr(int pageNum, String mode) {
	if(mode.equals("prev")) {
		if(!page.hasPreviousPage()) return " onclick=\"return false;\"";
	} else if(mode.equals("next")) {
		if(!page.hasNextPage()) return " onclick=\"return false;\"";
	}
	return " onclick=\""+func+"("+pageNum+")"+"; return false;\"";
}
%>

<%
int startPage = (page.getNumber()) / groupSize;
startPage = startPage*groupSize+1;

if(!page.hasContent()) {
%>
<span class="button">
	<a href="#" class="start"><img src="<c:url value="/resources/static/images/btn_start01_on.gif"/>" width="17" height="17" alt="맨앞" onclick="return false;"/></a>
	<a href="#" class="prev"><img src="<c:url value="/resources/static/images/btn_prev01_on.gif"/>" width="17" height="17" alt="이전" onclick="return false;"/></a>
</span>
<span class="button">
	<a href="#none">1</a>
</span>
<span class="button">
	<a href="#" class="next"><img src="<c:url value="/resources/static/images/btn_next01_on.gif"/>" width="17" height="17" alt="다음" onclick="return false;"/></a>
	<a href="#" class="end"><img src="<c:url value="/resources/static/images/btn_end01_on.gif"/>" width="17" height="17" alt="맨뒤" onclick="return false;"/></a>
</span>
<%		
} else {
	int prevGroupNum = startPage - groupSize;
	int prevPageNum = page.getNumber()+1 - 1;
	int nextGroupNum = startPage + groupSize;
	int nextPageNum = page.getNumber()+1 + 1;
	
	if(prevGroupNum <= 0) prevGroupNum = 1;
	if(prevPageNum <= 0) prevPageNum = 1;
	if(nextGroupNum >= page.getTotalPages()) nextGroupNum = page.getTotalPages();
	if(nextPageNum >= page.getTotalPages()) nextPageNum = page.getTotalPages();
%>

<span class="button">
	<a href="#" class="start"><img src="<c:url value="/resources/static/images/btn_start01_on.gif"/>" width="17" height="17" alt="맨앞" <%=getCallFuncStr(prevGroupNum, "prev") %> /></a>
	<a href="#" class="prev"><img src="<c:url value="/resources/static/images/btn_prev01_on.gif"/>" width="17" height="17" alt="이전" <%=getCallFuncStr(prevPageNum, "prev") %> /></a>
</span>
<span class="count">
<%
	for(int i=startPage; i<startPage+groupSize; i++) {
		if(i > page.getTotalPages()) break;
		if(page.getNumber()+1 == i)
			out.print("<a href=\"\" onclick=\"return false;\"><strong>"+i+"</strong></a>");
		else
			out.print("<a"+getCallFuncStr(i, "count")+">"+i+"</a>");
	}
%>
</span>
<span class="button">

	<a href="#" class="next"><img src="<c:url value="/resources/static/images/btn_next01_on.gif"/>" width="17" height="17" alt="다음" <%=getCallFuncStr(nextPageNum, "next") %>/></a>
	<a href="#" class="end"><img src="<c:url value="/resources/static/images/btn_end01_on.gif"/>" width="17" height="17" alt="맨뒤" <%=getCallFuncStr(nextGroupNum, "next") %>/></a>
</span>
<% 
} 
%>