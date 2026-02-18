<%@page import="java.sql.*" %>
<%
    String name,contact,email,address;
    name=request.getParameter("t1");
    contact=request.getParameter("t2");
    address=request.getParameter("t3");
    email=request.getParameter("t4");
    int s_id=0;
    
    Class.forName("com.mysql.jdbc.Driver");
    String path="jdbc:mysql://localhost:3306/fee_system";
    String dbuser="root";
    String dbpass="";
    String s1="insert into stdata values(0,?,?,?,?)";
    Connection cn=DriverManager.getConnection(path,dbuser,dbpass);
    PreparedStatement p1 =cn.prepareStatement(s1);
    
   
    p1.setString(1, name);
    p1.setString(2, contact);
    p1.setString(3, address);
    p1.setString(4, email);
        
    
    String msg="";
    int a=p1.executeUpdate();
    
    if(a==1)
    {
        msg="Data is saved";
    }
    else
    {
        msg="Not Saved";
    }
%>
<h3><%= msg %></h3>