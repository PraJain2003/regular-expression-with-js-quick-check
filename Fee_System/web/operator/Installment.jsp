<%@page  import="java.sql.*" %> 

<h2>Deposit Section</h2>

<%
    String s_id=request.getParameter("s1");
    String course_id=request.getParameter("s2");
    String fee=request.getParameter("s3");
    
    Class.forName("com.mysql.jdbc.Driver");
    
    String path="jdbc:mysql://localhost:3306/fee_system";
    String dbuser="root";
    String dbpass="";
    
    Connection cn=DriverManager.getConnection(path, dbuser, dbpass);
    
    String sql="select * from st_course where course_id=? and s_id=?";
    
    PreparedStatement p1=cn.prepareStatement(sql);
    java.sql.Date dt=new java.sql.Date(new java.util.Date().getTime());
    p1.setInt(1,Integer.parseInt(course_id));
    p1.setInt(2,Integer.parseInt(s_id));
    ResultSet r1=p1.executeQuery();
    
    if(r1.next())
    {
        String a,c,d;
        int f=r1.getInt("s_id");
        int e=r1.getInt("course_id");
        a=r1.getString("course_name");
        int b=r1.getInt("fee");
        c=r1.getString("duration");
        d=r1.getString("commencement_date");
 %>
 <h3><%= e%>.<%= a %></h3>
 <p>Fees: <%= b %><br/></p>
 <p>Duration: <%= c%></p>
 <p>Commencement_date: <%= d %></p>

 <form method="post" action="Installment1.jsp">
     <input type="hidden" name="h1" value="<%= f %>"/>
     <input type="hidden" name="h2" value="<%= e %>"/>
     <p>Amount to pay:<input type="text" name="txt1"/></p>
     <p>Remark :<input type="text" name="txt2"/></p>
     <button type="submit">Submit</button>     
 </form>

<%
    }
%>