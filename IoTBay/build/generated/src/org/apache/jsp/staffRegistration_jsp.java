package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class staffRegistration_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <script type=\"text/javascript\" src=\"js/script.js\"></script>\n");
      out.write("        <title>Registration Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body onload=\"startTime()\">\n");
      out.write("        <div><span class=\"time\" id=\"time\" ></span></div>\n");
      out.write("    \n");
      out.write("        ");

            String existErr = (String) session.getAttribute("existErr");
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
            String nameErr = (String) session.getAttribute("nameErr");
        
      out.write("\n");
      out.write("        <h1>Sign Up<span class=\"message\">");
      out.print((existErr != null ? existErr : ""));
      out.write("</span></h1>\n");
      out.write("        \n");
      out.write("        <div class=\"form\">\n");
      out.write("        <form action=\"StaffRegistrationServlet\" method=\"post\">\n");
      out.write("            <table>\n");
      out.write("                <tr><td>Full Name:</td><td><input type=\"text\" placeholder=\"");
      out.print((nameErr != null ? nameErr : "Enter name"));
      out.write("\" name=\"name\"></td></tr>\n");
      out.write("                <tr><td>Email:</td><td><input type=\"email\" placeholder=\"");
      out.print((emailErr != null ? emailErr : "Enter email"));
      out.write("\" name=\"email\"></td></tr>\n");
      out.write("                <tr><td>Password:</td><td><input type=\"password\" placeholder=\"");
      out.print((passErr != null ? passErr : "Enter password"));
      out.write("\" name=\"password\"></td></tr>\n");
      out.write("                <tr><td>Phone:</td><td><input type=\"text\" placeholder=\"");
      out.print((nameErr != null ? nameErr : "Enter Phone"));
      out.write("\" name=\"phone\"></td></tr>\n");
      out.write("                <tr><td>Agree to Terms of Service:</td><td><input type=\"checkbox\" name=\"tos\" required></td></tr>\n");
      out.write("                <tr><td></td>\n");
      out.write("                    <td><a href=\"index.jsp\" class=\"button\">Cancel</a>\n");
      out.write("                        <input class=\"button\" type=\"submit\" value=\"Sign Up\">                        \n");
      out.write("                    </td>\n");
      out.write("                </tr>                \n");
      out.write("                \n");
      out.write("            </table>\n");
      out.write("           \n");
      out.write("        </form>\n");
      out.write("        </div>\n");
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
