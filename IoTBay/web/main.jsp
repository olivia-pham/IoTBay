<%-- 
    Document   : main
    Created on : 30/03/2021, 7:14:58 PM
    Author     : olivi
--%>

<%@page import="uts.isd.model.User"%>
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
            User user = (User)session.getAttribute("user");
        %>
        <h1>User Profile</h1>
        <hr>
        <table id="profile_table" class="tableCenter">
            <thead><th>Name</th><th>Email</th><th>Password</th><th>Date of Birth</th></thead>
<<<<<<< HEAD
        <tr><td>${user.name}</td><td>${user.email}</td><td>${user.password}</td><td>${user.phone}</td></tr>        
        </table>

        <div class="buttonDiv1">
            <a href="shop.jsp" class="button">Shop</a>
            <a href="cart.jsp" class="button">My Cart</a>
            <a href="EditServlet?email='<%= user.getEmail()%>'&password='<%=user.getPassword()%>'" class="button">Account</a>
=======
        <tr><td>${customer.name}</td><td>${customer.email}</td><td>${customer.password}</td><td>${customer.dob}</td></tr>        
        </table>       
        <div class="buttonDiv1">
            <a href="shop.jsp" class="button">Shop</a>
            <a href="cart.jsp" class="button">My Cart</a>
            <a href="manageProducts.jsp" class="button">ManageProducts</a>
            <a href="EditServlet?email='<%= customer.getEmail()%>'&password='<%=customer.getPassword()%>'" class="button">Account</a>
>>>>>>> origin/shoptest
            <a href="LogoutController" class="button">Logout</a>
        </div>
    </body>
</html>
