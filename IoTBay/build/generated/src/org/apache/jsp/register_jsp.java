package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Registration Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Sign Up</h1>\n");
      out.write("        <form action=\"welcome.jsp\" method=\"POST\">\n");
      out.write("            <table>\n");
      out.write("                <tr><td>Full Name:</td><td><input type=\"text\" placeholder=\"Enter name\" name=\"name\" required=\"true\"></td></tr>\n");
      out.write("                <tr><td>Email:</td><td><input type=\"email\" placeholder=\"Enter email\" name=\"email\" required=></td></tr>\n");
      out.write("                <tr><td>Password:</td><td><input type=\"password\" placeholder=\"Enter password\" name=\"password\" required></td></tr>\n");
      out.write("                <tr><td>Date of Birth:</td><td><input type=\"date\" name=\"dob\" required></td></tr>\n");
      out.write("                <tr><td>Gender:</td><td>\n");
      out.write("                        <input type=\"radio\" id=\"male\" name=\"gender\" value=\"male\">\n");
      out.write("                        <label for=\"male\">Male</label>\n");
      out.write("                        <input type=\"radio\" id=\"female\" name=\"gender\" value=\"female\">\n");
      out.write("                        <label for=\"female\">Female</label>\n");
      out.write("                        <input type=\"radio\" id=\"other\" name=\"gender\" value=\"other\">\n");
      out.write("                        <label for=\"other\">Other</label>\n");
      out.write("                </td></tr>\n");
      out.write("                \n");
      out.write("                <tr><td>Agree to Terms of Service:</td><td><input type=\"checkbox\" name=\"tos\" required></td></tr>\n");
      out.write("            </table>\n");
      out.write("            <div>\n");
      out.write("                <a href=\"index.jsp\">Cancel</a>\n");
      out.write("                <input type=\"submit\" value=\"Sign up\">\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
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
