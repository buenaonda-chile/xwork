/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.21
 * Generated at: 2021-05-10 05:31:44 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.base;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.globaldenso.ai.miyabi.constant.Globals;

public final class footer_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(22);
    _jspx_dependants.put("/WEB-INF/jsp/base/prelude.jsp", Long.valueOf(1620624368808L));
    _jspx_dependants.put("/WEB-INF/kendoui.tld", Long.valueOf(1620624375454L));
    _jspx_dependants.put("jar:file:/C:/Users/user/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/DNKR-repair/WEB-INF/lib/jstl-1.2.jar!/META-INF/c-1_0-rt.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("jar:file:/C:/Users/user/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/DNKR-repair/WEB-INF/lib/jstl-1.2.jar!/META-INF/fmt.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("jar:file:/C:/Users/user/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/DNKR-repair/WEB-INF/lib/jstl-1.2.jar!/META-INF/x-1_0-rt.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("jar:file:/C:/Users/user/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/DNKR-repair/WEB-INF/lib/jstl-1.2.jar!/META-INF/sql.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("jar:file:/C:/Users/user/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/DNKR-repair/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("jar:file:/C:/Users/user/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/DNKR-repair/WEB-INF/lib/jstl-1.2.jar!/META-INF/x.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/spring-security-taglibs-4.0.3.RELEASE.jar", Long.valueOf(1620624375703L));
    _jspx_dependants.put("/WEB-INF/tld/ai.tld", Long.valueOf(1620624375766L));
    _jspx_dependants.put("jar:file:/C:/Users/user/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/DNKR-repair/WEB-INF/lib/tiles-jsp-3.0.5.jar!/META-INF/tld/tiles-extras-jsp.tld", Long.valueOf(1411309930000L));
    _jspx_dependants.put("jar:file:/C:/Users/user/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/DNKR-repair/WEB-INF/lib/jstl-1.2.jar!/META-INF/sql-1_0-rt.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("jar:file:/C:/Users/user/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/DNKR-repair/WEB-INF/lib/spring-webmvc-4.2.6.RELEASE.jar!/META-INF/spring.tld", Long.valueOf(1462487332000L));
    _jspx_dependants.put("jar:file:/C:/Users/user/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/DNKR-repair/WEB-INF/lib/spring-security-taglibs-4.0.3.RELEASE.jar!/META-INF/security.tld", Long.valueOf(1446175026000L));
    _jspx_dependants.put("jar:file:/C:/Users/user/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/DNKR-repair/WEB-INF/lib/spring-webmvc-4.2.6.RELEASE.jar!/META-INF/spring-form.tld", Long.valueOf(1462487332000L));
    _jspx_dependants.put("jar:file:/C:/Users/user/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/DNKR-repair/WEB-INF/lib/jstl-1.2.jar!/META-INF/fmt-1_0-rt.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/tiles-jsp-3.0.5.jar", Long.valueOf(1620624375724L));
    _jspx_dependants.put("jar:file:/C:/Users/user/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/DNKR-repair/WEB-INF/lib/jstl-1.2.jar!/META-INF/fn.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/spring-webmvc-4.2.6.RELEASE.jar", Long.valueOf(1620624375712L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1620624375587L));
    _jspx_dependants.put("/WEB-INF/jsp/base/coda.jsp", Long.valueOf(1620624368783L));
    _jspx_dependants.put("jar:file:/C:/Users/user/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/DNKR-repair/WEB-INF/lib/tiles-jsp-3.0.5.jar!/META-INF/tld/tiles-jsp.tld", Long.valueOf(1411309930000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.globaldenso.ai.miyabi.constant.Globals");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fai_005fcontextInfo_0026_005fvarname_005fkey_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ffmt_005fsetLocale_0026_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fai_005fcontextInfo_0026_005fvarname_005fkey_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ffmt_005fsetLocale_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fai_005fcontextInfo_0026_005fvarname_005fkey_005fnobody.release();
    _005fjspx_005ftagPool_005ffmt_005fsetLocale_0026_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      if (_jspx_meth_ai_005fcontextInfo_005f0(_jspx_page_context))
        return;
      if (_jspx_meth_fmt_005fsetLocale_005f0(_jspx_page_context))
        return;
      out.write("<div class=\"container\">\r\n");
      out.write("    Copyright&nbsp;&copy;&nbsp;2018&nbsp;DENSO&nbsp;CORPORATION.&nbsp;All&nbsp;rights&nbsp;reserved.\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_ai_005fcontextInfo_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  ai:contextInfo
    com.globaldenso.ai.miyabi.customtag.ContextInfoTag _jspx_th_ai_005fcontextInfo_005f0 = (com.globaldenso.ai.miyabi.customtag.ContextInfoTag) _005fjspx_005ftagPool_005fai_005fcontextInfo_0026_005fvarname_005fkey_005fnobody.get(com.globaldenso.ai.miyabi.customtag.ContextInfoTag.class);
    _jspx_th_ai_005fcontextInfo_005f0.setPageContext(_jspx_page_context);
    _jspx_th_ai_005fcontextInfo_005f0.setParent(null);
    // /WEB-INF/jsp/base/prelude.jsp(54,0) name = key type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_ai_005fcontextInfo_005f0.setKey("locale");
    // /WEB-INF/jsp/base/prelude.jsp(54,0) name = varname type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_ai_005fcontextInfo_005f0.setVarname("dclocale");
    int _jspx_eval_ai_005fcontextInfo_005f0 = _jspx_th_ai_005fcontextInfo_005f0.doStartTag();
    if (_jspx_th_ai_005fcontextInfo_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fai_005fcontextInfo_0026_005fvarname_005fkey_005fnobody.reuse(_jspx_th_ai_005fcontextInfo_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fai_005fcontextInfo_0026_005fvarname_005fkey_005fnobody.reuse(_jspx_th_ai_005fcontextInfo_005f0);
    return false;
  }

  private boolean _jspx_meth_fmt_005fsetLocale_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  fmt:setLocale
    org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag _jspx_th_fmt_005fsetLocale_005f0 = (org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag) _005fjspx_005ftagPool_005ffmt_005fsetLocale_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag.class);
    _jspx_th_fmt_005fsetLocale_005f0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fsetLocale_005f0.setParent(null);
    // /WEB-INF/jsp/base/prelude.jsp(55,0) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fsetLocale_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dclocale}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
    int _jspx_eval_fmt_005fsetLocale_005f0 = _jspx_th_fmt_005fsetLocale_005f0.doStartTag();
    if (_jspx_th_fmt_005fsetLocale_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fsetLocale_0026_005fvalue_005fnobody.reuse(_jspx_th_fmt_005fsetLocale_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fsetLocale_0026_005fvalue_005fnobody.reuse(_jspx_th_fmt_005fsetLocale_005f0);
    return false;
  }
}
