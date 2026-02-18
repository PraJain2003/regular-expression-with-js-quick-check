<%@page import="java.sql.*" %>
<%
    String ut="",e1="";
    session =request.getSession(false);
    if(session==null)
    {
        response.sendRedirect("../AuthError.jsp");
    }
    else
    {
        try
        {
            e1=session.getAttribute("email").toString();
            ut=session.getAttribute("usertype").toString();
            if(ut.equalsIgnoreCase("admin")==false)
            {
                response.sendRedirect("../AuthError.jsp");
            }
        }
        catch(NullPointerException e)
        {
            response.sendRedirect("../AuthError.jsp");
        }
    }
%>

<h1>Welcome to Fee_System</h1>

<p><a href="#">Home</a></p>
<p><a href="Login.jsp">Logout</a></p>
<p><a href="ChangePassword.jsp">Change password</a></p>
<p><a href="Operator.jsp">Operator Reg</a></p>
<p><a href="ShowOperator.jsp">Show Operator</a></p>