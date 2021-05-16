<%-- 
    Document   : admin
    Created on : 16/05/2021, 2:48:37 PM
    Author     : jkmod
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.Admin"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Login Page</title>
    </head>
    <body>
        <h1>Admin Login</h1>
        <%Admin admin = new Admin();%>
        <%if (request.getParameter("something") == null) {%>
        <div class="form">
        <form action ="admin.jsp" method="POST" class="centreText">
            <table>
                <tr><td>Email:</td><td><input type="text" name="email" required="true" placeholder="Enter email"></td></tr>
                <tr><td>Password:</td><td><input type="password" name="password" required="true" placeholder="Enter password"></td></tr>
                <input type="hidden" name="something">           
            </table>
            <div class="buttonDiv1">
                <input type="submit" class="submitButton" value="Continue">
            </div>
            
            <div class="cancelDiv">
                <a href="login.jsp">Go Back</a>
            </div>
        </form>
        </div>
        <%} else {%>
            <%if (request.getParameter("email").equals(admin.getEmail()) && request.getParameter("password").equals(admin.getPassword())) { %>
                <form action="customerManagement.jsp" method="POST">
                <input type="submit" value="Contiune">
                </from>
            <%} else {%>
                <div> Password or Email is wrong <a href="admin.jsp"> back</a></div>
            <%}%>
        <%}%>
    </body>
</html>
