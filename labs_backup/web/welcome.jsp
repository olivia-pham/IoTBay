<%-- 
    Document   : welcome
    Created on : 16/03/2021, 8:17:08 PM
    Author     : olivi
--%>
<%@page import="uts.isd.model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
    </head>
    <body>
        
        <%
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String phone = request.getParameter("phone");
            
            
        %>
        <h1>Welcome, <%= name %>! </h1>
        <div class="centerForm">
        <p>Your email is: <%= email%></p>
        <p>Your password is: <%= password%></p>
        <p>Your Phone Number is: <%= phone%></p>
        
        <div class="buttonDiv1">
            <a class="mainButton" href="main.jsp">Main Page</a>
        </div>
        
        <div class="cancelDiv">
             <a class="button" href="index.jsp">Cancel</a>
        </div>
        </div>
        <%
            Customer customer = new Customer(name, email, password, phone);
            session.setAttribute("customer", customer);
        %>
        
      
    </body>
</html>
