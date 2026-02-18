package org.apache.jsp.operator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import amaan.projects.fee_mgmt.MyLib;
import java.sql.*;

public final class View_jsp extends org.apache.jasper.runtime.HttpJspBase
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
        Connection cn=DriverManager.getConnection(path,dbuser,dbpass);
        String s1="select * from stdata where s_id=?";
        PreparedStatement p1=cn.prepareStatement(s1);                                                               
        int e=Integer.parseInt(s_id);
        p1.setInt(1, e);                         
        ResultSet r1=p1.executeQuery();                                   
        if(r1.next())
        {
            String a,b,c,d;
            e=r1.getInt("s_id");
            a=r1.getString("name");
            b=r1.getString("contact");
            c=r1.getString("address");
            d=r1.getString("email");


            String s2="select * from st_photo where s_id=?";
            PreparedStatement p2=cn.prepareCall(s2);
            p2.setInt(1, e);
            ResultSet r2=p2.executeQuery();
            if(r2.next()) //photo found
            {
                String photo=r2.getString("photo");
                
      out.write("\n");
      out.write("                <img src=\"photo/");
      out.print( photo );
      out.write("\" width=\"100\" height=\"125\" />\n");
      out.write("               ");

            }
            else
            {
            
      out.write("\n");
      out.write("\n");
      out.write("                <form method=\"post\" enctype=\"multipart/form-data\" action=\"Uploadphoto.jsp?s_id=");
      out.print( e );
      out.write("\" >\n");
      out.write("                <p>Photo \n");
      out.write("                    <label for=\"F1\"></label>\n");
      out.write("                    <input type=\"file\" name=\"F1\" id=\"F1\" />\n");
      out.write("                </p>\n");
      out.write("                <p>\n");
      out.write("                    <input type=\"submit\" name=\"B1\" id=\"B1\" value=\"Upload Photo\" />\n");
      out.write("                </p>\n");
      out.write("                    </form>\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("           <h2>");
      out.print( e );
      out.write('.');
      out.write(' ');
      out.print( a );
      out.write("</h2>\n");
      out.write("           <p>\n");
      out.write("               Contact:");
      out.print( b );
      out.write("<br/>\n");
      out.write("               Address:");
      out.print( c );
      out.write("<br/>\n");
      out.write("               Email:");
      out.print( d );
      out.write("<br/>\n");
      out.write("           </p>\n");
      out.write("    \n");
      out.write("       \n");
      out.write("       <a href=\"editStudent.jsp?s_id=");
      out.print( e );
      out.write("\">edit</a>\n");
      out.write("       <a href=\"deleteStudent.jsp?s_id=");
      out.print( e );
      out.write("\">delete</a>\n");
      out.write("       \n");
      out.write("       <br/>\n");
      out.write("       <br/> \n");
      out.write("      \n");
      out.write("       \n");
      out.write("       \n");
      out.write("       <form method=\"post\" action=\"AddCourse.jsp\">\n");
      out.write("           <h2>Courses\n");
      out.write("           <input type=\"hidden\" name=\"t1\" value=\"");
      out.print( e );
      out.write("\"/>\n");
      out.write("           <input type=\"submit\" name=\"B1\" value=\"Add\" />\n");
      out.write("           </h2>\n");
      out.write("       </form>\n");
      out.write("           \n");
      out.write("           \n");
      out.write("       <table border=\"2px solid #000000\">\n");
      out.write("           <tr>\n");
      out.write("                <th>course_id</th>\n");
      out.write("                <th>s_id</th>\n");
      out.write("                <th>course_name</th>\n");
      out.write("                <th>fees</th>\n");
      out.write("                <th>duration</th>\n");
      out.write("                <th>commencement_date</th>\n");
      out.write("                <th>Paid</th>\n");
      out.write("                <th>Due</th>\n");
      out.write("                <th>pay</th>\n");
      out.write("                <th>Changes</th>                \n");
      out.write("            </tr>\n");
      out.write("        ");

            
            String s3="select * from st_course where s_id=?";
            PreparedStatement p3=cn.prepareCall(s3);
            p3.setInt(1, e);
            ResultSet r3=p3.executeQuery();
            int total_fee=0;
            while(r3.next())
            {
                
               String r,s,u,v;
               int p=r3.getInt("course_id");
               int q=r3.getInt("s_id");
               r=r3.getString("course_name");
               s=r3.getString("fee");
               total_fee=total_fee+Integer.parseInt(s);
               u=r3.getString("duration");
               v=r3.getString("commencement_date");
               int c_paid=new MyLib().course_paid(q,p);
               int course_due=Integer.parseInt(s)-c_paid;        
               
        
      out.write(" \n");
      out.write("        \n");
      out.write("             \n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print( p );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( q );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( r );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( s );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( u );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( v );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( c_paid );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( course_due );
      out.write("</td>\n");
      out.write("                <td>\n");
      out.write("                    ");

                    if(course_due==0)
                    {
                        
      out.write("\n");
      out.write("                        <p> Completed </p>\n");
      out.write("                        ");

                    }
                    else
                    {
                    
      out.write("\n");
      out.write("                    <form method=\"post\" action=\"Installment.jsp\">\n");
      out.write("                        <input type=\"hidden\" name=\"s1\"  value=\"");
      out.print( e );
      out.write("\"/>\n");
      out.write("                        <input type=\"hidden\" name=\"s2\"  value=\"");
      out.print( p );
      out.write("\"/>\n");
      out.write("                        <input type=\"hidden\" name=\"s3\"  value=\"");
      out.print( s );
      out.write("\"/>\n");
      out.write("                        <input type=\"submit\" name=\"s4\" value=\"pay\"/> \n");
      out.write("                    </form>\n");
      out.write("                        ");

                    }
                    
      out.write("\n");
      out.write("                </td>\n");
      out.write("                \n");
      out.write("            </tr>\n");
      out.write("        \n");
      out.write("       ");
    
            }
            
      out.write("\n");
      out.write("            </table>\n");
      out.write("            <h3>Total:");
      out.print( total_fee );
      out.write("</h3>\n");
      out.write("      \n");
      out.write("            <br/>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            <h1>Installment</h1>\n");
      out.write("                <table border=\"2px solid #000000\">\n");
      out.write("                    <tr>\n");
      out.write("                        <th>T ID</th>\n");
      out.write("                        <th>S_id</th>\n");
      out.write("                        <th>Course_id</th>\n");
      out.write("                        <th>Amount</th>\n");
      out.write("                        <th>T date</th>\n");
      out.write("                        <th>Remarks</th>\n");
      out.write("                        <th>&nbsp;</th>\n");
      out.write("                    </tr>\n");
      out.write("        ");

            String s4="select * from st_installment where s_id=?";
            PreparedStatement p4=cn.prepareCall(s4);
            p4.setInt(1, e);
            ResultSet r4=p4.executeQuery();
            int paid=0;
            while(r4.next())
            {
                String i,j,k,l; 
                int g=r4.getInt("t_id");
                int h=r4.getInt("s_id");
                l=r4.getString("course_id");
                String course_id=new MyLib().getCourseName(Integer.parseInt(l));
                i=r4.getString("amount");
                paid=paid+Integer.parseInt(i);
                j=r4.getString("t_date");
                k=r4.getString("remark");
                
            

      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print( g );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( h );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( course_id );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( i );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( j );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( k );
      out.write("</td>\n");
      out.write("                <td>\n");
      out.write("                <form method=\"post\" action=\"\">\n");
      out.write("                <input type=\"hidden\" name=\"t1\" value=\"");
      out.print( e );
      out.write("\"/>\n");
      out.write("                <input type=\"submit\" name=\"B2\" value=\"edit\" />\n");
      out.write("               \n");
      out.write("                </form>\n");
      out.write("                    \n");
      out.write("                </td>\n");
      out.write("            </tr>   \n");
          
            }
            int due=total_fee-paid;
           
      out.write("\n");
      out.write("           \n");
      out.write("         <h3>total paid:");
      out.print( paid );
      out.write("\n");
      out.write("         <h3>due:");
      out.print( due );
      out.write("\n");
      out.write("             ");

        }
    }

      out.write(" \n");
      out.write("</table>");
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
