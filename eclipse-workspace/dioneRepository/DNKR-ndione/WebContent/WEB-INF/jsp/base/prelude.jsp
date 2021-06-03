<%--
 * prelude.jsp
 *
 * [EN] It is the header information that is automatically inserted at the beginning of all JSP.
 * [EN]
 * [EN] I'm using the JSP configuration. (Set in web.xml)
 *
 * [JP] 全 JSP の先頭に自動的に挿入されるヘッダ情報です。
 * [JP]
 * [JP] JSP コンフィギュレーションを利用しています。( web.xml にて設定)
 *
 * $ prelude.jsp 1753 2015-07-03 00:24:13Z 815372040074 $
 *
 * Copyright (c) 2012 DENSO IT SOLUTIONS. All rights reserved.
--%>

<%-- [EN] Page setup --%>
<%-- [JP] ページ設定 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%-- [EN] import settings --%>
<%-- [JP] import 設定 --%>
<%@ page import="com.globaldenso.ai.core.context.DensoContext" %>
<%@ page import="com.globaldenso.ai.miyabi.constant.Globals" %>

<%-- JSTL --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"          prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt"           prefix="c_rt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"           prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt"            prefix="fmt_rt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml"           prefix="x" %>
<%@ taglib uri="http://java.sun.com/jstl/xml_rt"            prefix="x_rt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql"           prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jstl/sql_rt"            prefix="sql_rt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"     prefix="fn" %>
<%-- Spring MVC --%>
<%@ taglib uri="http://www.springframework.org/tags/form"   prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags"        prefix="spring" %>
<%-- Apache Tiles --%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles"         prefix="tiles" %>

<%-- [JP] その他カスタムタグ --%>
<%-- [EN] Other custom tags --%>
<%-- [JP] 必要に応じてセットして下さい --%>
<%-- [EN] Set as necessary --%>
<%-- AI-LIBRARY --%>
<%@ taglib uri="http://ai.globaldenso.com/customTag"            prefix="ai" %>
<%@ taglib uri="http://ai.globaldenso.com/ai_sample/customTag"  prefix="smpl" %>


<%-- [JP] JSTLタグのロケールの設定 --%>
<%-- [EN] Locale setting of JSTL tags --%>
<fmt:setLocale value="<%= DensoContext.get().getLocale() %>"/>
