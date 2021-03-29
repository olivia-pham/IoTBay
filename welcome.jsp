<%-- 
    Document   : welcome
    Created on : 16/03/2021, 8:17:08 PM
    Author     : olivi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
    </head>
    <body>
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
       
    </body>
</html>
