<%-- 
    Document   : one
    Created on : 23/03/2021, 7:42:20 PM
    Author     : olivi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <form action="one.jsp" method="POST">
            <table>
                <tr><td>Full Name:</td><td><input type="text" placeholder="Enter name" name="name" required="true"></td></tr>
                <tr><td>Email:</td><td><input type="email" placeholder="Enter email" name="email" required=></td></tr>
                <tr><td>Password:</td><td><input type="password" placeholder="Enter password" name="password" required></td></tr>
                <tr><td>Date of Birth:</td><td><input type="date" name="dob" required></td></tr>
                <tr><td>Agree to Terms of Service:</td><td><input type="checkbox" name="tos" required></td></tr>
            </table>
            <div>
                <a href="index.jsp">Cancel</a>
                <input type="submit" name="submit" value="Sign up" onclick=
                    "
        <%
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String dob = request.getParameter("dob");
            
        %>
        <h1>Welcome, <%= name %>! </h1>
        <p>Your email is: <%= email%></p>
        <p>Your password is: <%= password%></p>
        <p>Your DOB is: <%= dob%></p>
       "
                >
                
            </div>
        </form>

    </body>
</html>
