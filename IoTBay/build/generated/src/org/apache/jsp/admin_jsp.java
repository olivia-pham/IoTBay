package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import uts.isd.model.Admin;

public final class admin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Admin Login Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Admin Login</h1>\n");
      out.write("        ");
Admin admin = new Admin();
      out.write("\n");
      out.write("        ");
if (request.getParameter("something") == null) {
      out.write("\n");
      out.write("        <div class=\"form\">\n");
      out.write("        <form action =\"admin.jsp\" method=\"POST\" class=\"centreText\">\n");
      out.write("            <table>\n");
      out.write("                <tr><td>Email:</td><td><input type=\"text\" name=\"email\" required=\"true\" placeholder=\"Enter email\"></td></tr>\n");
      out.write("                <tr><td>Password:</td><td><input type=\"password\" name=\"password\" required=\"true\" placeholder=\"Enter password\"></td></tr>\n");
      out.write("                <input type=\"hidden\" name=\"something\">           \n");
      out.write("            </table>\n");
      out.write("            <div class=\"buttonDiv1\">\n");
      out.write("                <input type=\"submit\" class=\"submitButton\" value=\"Continue\">\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <div class=\"cancelDiv\">\n");
      out.write("                <a href=\"login.jsp\">Go Back</a>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("        </div>\n");
      out.write("        ");
} else {
      out.write("\n");
      out.write("            ");
if (request.getParameter("email").equals(admin.getEmail()) && request.getParameter("password").equals(admin.getPassword())) { 
      out.write("\n");
      out.write("                <form action=\"staffRegistration.jsp\" method=\"POST\">\n");
      out.write("                <input type=\"submit\" value=\"Contiune\">\n");
      out.write("                </from>\n");
      out.write("            ");
} else {
      out.write("\n");
      out.write("                <div> Password or Email is wrong <a href=\"admin.jsp\"> back</a></div>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("        ");
}
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
