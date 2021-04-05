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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
    </head>
    <body>
        
        <%
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String dob = request.getParameter("dob");
            String gender = request.getParameter("gender");
            
            
        %>
        <h1>Welcome, <%= name %>! </h1>
        <p>Your email is: <%= email%></p>
        <p>Your password is: <%= password%></p>
        <p>Your DOB is: <%= dob%></p>
        <p>Your gender is: <%= gender%></p>
        <div>
            <a class="button" href="index.jsp">Cancel</a>
            <a class="button" href="main.jsp">Main</a>         
                    
          
        </div>
        <%
            Customer customer = new Customer(name, email, password, dob, gender);
            session.setAttribute("customer", customer);
        %>
        
      
    </body>
</html>
