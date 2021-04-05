<%-- 
    Document   : main
    Created on : 30/03/2021, 7:14:58 PM
    Author     : olivi
--%>

<%@page import="uts.isd.model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Page</title>
    </head>
    <body>
        <%
            Customer customer = (Customer)session.getAttribute("customer");
        %>
        <h1>Customer Profile</h1>
        <table id="profile_table">
            <thead><th>Name</th><th>Email</th><th>Password</th><th>Date of Birth</th><th>Gender</th></thead>
        <tr><td>${customer.name}</td><td>${customer.email}</td><td>${customer.password}</td><td>${customer.dob}</td><td>${customer.gender}</td></tr>        
        </table>
        
        <div class="panel_div">
            
            <a href="logout.jsp" class="button">Logout</a>
        </div>
    </body>
</html>
