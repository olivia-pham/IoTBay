<%-- 
    Document   : login
    Created on : 30/03/2021, 12:01:39 PM
    Author     : olivi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action ="welcome.jsp" method="POST">
            <table>
                <tr><td>Email:</td><td><input type="text" name="email" required="true" placeholder="Enter email"></td></tr>
                <tr><td>Password:</td><td><input type="text" name="email" required="true" placeholder="Enter password"></td></tr>
            </table>
            <div>
                <a href="index.jsp">Cancel</a>
                <input type="submit" value="Login">
            </div>
        </form>
    </body>
</html>
