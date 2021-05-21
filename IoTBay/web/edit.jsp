<%-- 
    Document   : edit
    Created on : 07/05/2021, 4:07:42 PM
    Author     : olivi
--%>

<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="js/script.js"></script>
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <title>Account Page</title>
    </head>
    <body onload="startTime()">
        <div><span class="time" id="time"></span></div>
        <%
            User user = (User)session.getAttribute("user");
            String updated = request.getParameter("updated");
        %>
        
        <div>
            <a href="MainServlet?email='<%= user.getEmail()%>'&password='<%=user.getPassword()%>'" class="button">Main</a>       
            <a href="LogoutController" class="button">Logout</a>  
                
        </div>
        
        <h1>Edit Student Information <span class="message"> <%=(updated != null ? updated : "")%></span></h1>
        <div class="form">
        <form action="UpdateServlet" method="post">
            <table id="form_table">
                <tr><td>Full Name:</td><td><input type="text" name="name" value="${user.name}"></td></tr>
                <tr><td>Email:</td><td><input type="email" name="email" value="${user.email}"></td></tr>
                <tr><td>Password:</td><td><input type="password" name="password" value="${user.password}"></td></tr>
                <tr><td>Phone:</td><td><input type="text" name="phone" name="phone" value="${user.phone}"></td></tr>
                <tr><td></td>
                    <td>
                        <input class="button" type="submit" value="Update">
                    </td>
                </tr>
            </table>
                
        </form>
        <form action="DeleteCustomerServlet" method="post">
            <input type="hidden" name="email" value="${user.email}">
            <input type="hidden" name="password" value="${user.password}">
            <input class="button" type="submit" value="Delete Account">
        </form>
        
        </div>
    </body>
</html>
