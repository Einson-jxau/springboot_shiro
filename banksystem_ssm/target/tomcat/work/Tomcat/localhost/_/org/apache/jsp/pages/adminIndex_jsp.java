/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-09-23 17:48:18 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class adminIndex_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"zh\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\">\r\n");
      out.write("    <title></title>\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/icon?family=Material+Icons\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Raleway:200,300,400,600,700\">\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/reset.css\">\r\n");
      out.write("    <!--演示页面样式，使用时可以不引用-->\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/demo.css\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div id=\"container\">\r\n");
      out.write("\r\n");
      out.write("    <header>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"wrapper cf\">\r\n");
      out.write("\r\n");
      out.write("            <nav id=\"main-nav\">\r\n");
      out.write("\r\n");
      out.write("                <ul class=\"first-nav\">\r\n");
      out.write("                    <li class=\"cryptocurrency\">\r\n");
      out.write("                        <a href=\"#\" target=\"_blank\">用户信息管理</a>\r\n");
      out.write("                        <ul>\r\n");
      out.write("                            <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin/findAllUser.do\">用户信息</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("\r\n");
      out.write("                <ul class=\"second-nav\">\r\n");
      out.write("                    <li class=\"devices\">\r\n");
      out.write("                        <a href=\"#\">银行运营管理</a>\r\n");
      out.write("                        <ul>\r\n");
      out.write("                            <li><a href=\"#\">收支详情</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"magazines\">\r\n");
      out.write("                        <a href=\"#\">银行贷款管理</a>\r\n");
      out.write("                        <ul>\r\n");
      out.write("                            <li><a href=\"#\">贷款详情</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"store\">\r\n");
      out.write("                        <a href=\"#\">理财产品管理</a>\r\n");
      out.write("                        <ul>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <a href=\"#\">转账</a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"collections\">\r\n");
      out.write("                        <a href=\"#\">利息调整</a>\r\n");
      out.write("                        <ul>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <a href=\"#\">存款利息</a>\r\n");
      out.write("                                <a href=\"#\">贷款利息</a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </li>\r\n");
      out.write("\r\n");
      out.write("                    <li class=\"credits\"><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin/logout.do\">退出</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("\r\n");
      out.write("            </nav>\r\n");
      out.write("\r\n");
      out.write("            <h1>银行后台管理系统</h1>\r\n");
      out.write("            <h3>欢迎您，管理员<span style=\"color: red\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.admin.username}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</span></h3><br>\r\n");
      out.write("\r\n");
      out.write("            <h5 style=\"font-family: 宋体\">适用浏览器：FireFox、Chrome、Opera、傲游、搜狗、世界之窗. 不支持Safari、IE8及以下浏览器。<br></h5>\r\n");
      out.write("\r\n");
      out.write("            <a class=\"toggle\">\r\n");
      out.write("                <span></span>\r\n");
      out.write("                菜单栏\r\n");
      out.write("            </a>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("    </header>\r\n");
      out.write("\r\n");
      out.write("    <main>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"wrapper\">\r\n");
      out.write("\r\n");
      out.write("            <div class=\"content\">\r\n");
      out.write("\r\n");
      out.write("                <h4>选择导航出现的位置</h4>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"actions\">\r\n");
      out.write("\r\n");
      out.write("                    <div><a href=\"#\" data-demo=\"{side:'left'}\" class=\"button active\">左侧</a></div>\r\n");
      out.write("\r\n");
      out.write("                    <div><a href=\"#\" data-demo=\"{side:'right'}\" class=\"button\">右侧</a></div>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <h4>水平开放</h4>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"actions\">\r\n");
      out.write("\r\n");
      out.write("                    <div><a href=\"#\" data-demo=\"{levelOpen:'overlap', levelSpacing:40}\" class=\"button active\">重叠</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div><a href=\"#\" data-demo=\"{levelOpen:'expand', levelSpacing:25}\" class=\"button\">扩大</a></div>\r\n");
      out.write("\r\n");
      out.write("                    <div><a href=\"#\" data-demo=\"{levelOpen:false, levelSpacing:25}\" class=\"button\">展开</a></div>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("    </main>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery-1.11.0.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/dist/hc-mobile-nav.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("    (function ($) {\r\n");
      out.write("        var $nav = $('#main-nav');\r\n");
      out.write("        var $toggle = $('.toggle');\r\n");
      out.write("        var defaultData = {\r\n");
      out.write("            maxWidth: false,\r\n");
      out.write("            customToggle: $toggle,\r\n");
      out.write("            navTitle: '请选择操作',\r\n");
      out.write("            levelTitles: true,\r\n");
      out.write("        };\r\n");
      out.write("\r\n");
      out.write("        // we'll store our temp stuff here\r\n");
      out.write("        var $clone = null;\r\n");
      out.write("        var data = {};\r\n");
      out.write("\r\n");
      out.write("        // calling like this only for demo purposes\r\n");
      out.write("\r\n");
      out.write("        const initNav = function (conf) {\r\n");
      out.write("            if ($clone) {\r\n");
      out.write("                // clear previous instance\r\n");
      out.write("                $clone.remove();\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            // remove old toggle click event\r\n");
      out.write("            $toggle.off('click');\r\n");
      out.write("\r\n");
      out.write("            // make new copy\r\n");
      out.write("            $clone = $nav.clone();\r\n");
      out.write("\r\n");
      out.write("            // remember data\r\n");
      out.write("            $.extend(data, conf)\r\n");
      out.write("\r\n");
      out.write("            // call the plugin\r\n");
      out.write("            $clone.hcMobileNav($.extend({}, defaultData, data));\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        // run first demo\r\n");
      out.write("        initNav({});\r\n");
      out.write("\r\n");
      out.write("        $('.actions').find('a').on('click', function (e) {\r\n");
      out.write("            e.preventDefault();\r\n");
      out.write("\r\n");
      out.write("            var $this = $(this).addClass('active');\r\n");
      out.write("            var $siblings = $this.parent().siblings().children('a').removeClass('active');\r\n");
      out.write("\r\n");
      out.write("            initNav(eval('(' + $this.data('demo') + ')'));\r\n");
      out.write("        });\r\n");
      out.write("    })(jQuery);\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
