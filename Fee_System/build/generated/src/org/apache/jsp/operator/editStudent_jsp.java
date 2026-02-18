package org.apache.jsp.operator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class editStudent_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');

    String s_id=request.getParameter("s_id");
    if(s_id==null)
    {
        response.sendRedirect("ShowStudent.jsp");
    }
    else
    {
      
        Class.forName("com.mysql.jdbc.Driver");
        String path="jdbc:mysql://localhost:3306/fee_system";
        String dbuser="root";
        String dbpass="";
        String s1="select * from stdata where s_id=?";
        Connection cn=DriverManager.getConnection(path,dbuser,dbpass);
        PreparedStatement p1=cn.prepareStatement(s1);
        int e=Integer.parseInt(s_id);
        p1.setInt(1, e);
        
        ResultSet r1=p1.executeQuery();
        while(r1.next())
        {
            String a,b,c,d;
            a=r1.getString("name");
            b=r1.getString("contact");
            c=r1.getString("address");
            d=r1.getString("email");
            
      out.write("\n");
      out.write("            <h1>Edit</h1>\n");
      out.write("            <form method=\"post\" action=\"editStudent1.jsp\">\n");
      out.write("                <p><input type=\"hidden\" name=\"t5\" id=\"txt5\" value=\"");
      out.print( e );
      out.write("\"/></p>\n");
      out.write("                <p>name<br/><input type=\"text\" value=\"");
      out.print( a );
      out.write("\" name=\"t1\" id=\"txt1\"/>\n");
      out.write("                <p>contact<br/><input type=\"text\" value=\"");
      out.print( b );
      out.write("\" name=\"t2\" id=\"txt2\"/>\n");
      out.write("                <p>address<br/><input type=\"text\" value=\"");
      out.print( c );
      out.write("\" name=\"t3\" id=\"txt3\"/>\n");
      out.write("                <p>email<br/><input readonly type=\"text\" value=\"");
      out.print( d );
      out.write("\" name=\"t4\" id=\"txt4\"/>\n");
      out.write("                <p><button type=\"submit\" name=\"b1\" id=\"btn1\">save changes</button></p>\n");
      out.write("        </form>\n");
      out.write("            ");

        }
}

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
