<%@page import="java.sql.*" %>
<%
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
        p1.setInt(1,e);
        
        ResultSet r1=p1.executeQuery();
        while(r1.next())
        {
            String a,b,c,d;
            a=r1.getString("name");
            b=r1.getString("contact");
            c=r1.getString("address");
            d=r1.getString("email");
            %>
            <h1>Edit</h1>
            <form method="post" action="deleteStudent1.jsp">
            <p><input type="hidden" value="<%= e %>" name="t5" id="txt1"/>    
            <p>name<br/><input type="text" value="<%= a %>" name="t1" id="txt1"/>
            <p>contact<br/><input type="text" value="<%= b %>" name="t2" id="txt2"/>
            <p>address<br/><input type="text" value="<%= c %>" name="t3" id="txt3"/>
            <p>email<br/><input readonly type="text" value="<%= d %>" name="t4" id="txt4"/>
            <p><button type="submit" name="b1" id="btn1">Delete</button></p>
        </form>
            <%
        }
}
%>
