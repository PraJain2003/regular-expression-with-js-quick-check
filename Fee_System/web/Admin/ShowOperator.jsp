<%@page import="java.sql.*" %>
<% 
    Class.forName("com.mysql.jdbc.Driver");
    String path="jdbc:mysql://localhost:3306/fee_system";
    String dbuser="root";
    String dbpass="";
    Connection cn=DriverManager.getConnection(path,dbuser,dbpass);
    String s1="select * from operatordata";
    PreparedStatement p1=cn.prepareStatement(s1);
    ResultSet r1=p1.executeQuery();
    if(r1.next())
    {
        String a,b,c,d;
        a=r1.getString("name");
        b=r1.getString("contact");
        c=r1.getString("address");
        d=r1.getString("email");
       %>
       <h3><%= a %></h3>
       <p>
           Contact:<%= b %><br/>
           address:<%= c %><br/>
           address:<%= d %><br/>
       </p>
       <%
    }
    else
    {
        %>
        <h2>No data found</h2>
    <%
    }
    %>  