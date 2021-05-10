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
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="js/script.js"></script>
        <title>Main Page</title>
    </head>
    <body onload="startTime(); resetSearch();">
        <div><span class="time" id="time"></span></div>
        <%
            Customer customer = (Customer)session.getAttribute("customer");
        %>
        <h1>Customer Profile</h1>
        <hr>
        <table id="profile_table" class="tableCenter">
            <thead><th>Name</th><th>Email</th><th>Password</th><th>Date of Birth</th></thead>
        <tr><td>${customer.name}</td><td>${customer.email}</td><td>${customer.password}</td><td>${customer.dob}</td></tr>        
        </table>

        <div class="buttonDiv1">
            <a href="EditServlet?email='<%= customer.getEmail()%>'&password='<%=customer.getPassword()%>'" class="button">Edit</a>
            <a href="LogoutController" class="logoutButton">Logout</a>
        </div>
    </body>
</html>
