<%-- 
    Document   : register
    Created on : 16/03/2021, 7:54:30 PM
    Author     : olivi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
    </head>
    <body>
        <main>
        <section>
        <h1>Sign Up</h1>
        <div class="form">
        <form action="RegisterServlet" method="POST">
            <table id="form_table">
                <tr><td>Full Name:</td><td><input type="text" placeholder="Enter name" name="name" required="true"></td></tr>
                <tr><td>Email:</td><td><input type="email" placeholder="Enter email" name="email" required=></td></tr>
                <tr><td>Password:</td><td><input type="password" placeholder="Enter password" name="password" required></td></tr>
                <tr><td>Date of Birth:</td><td><input type="date" name="dob" required></td></tr>
                
                <tr><td>Agree to Terms of Service:</td><td><input type="checkbox" name="tos" required></td></tr>
            </table>
            <div class="buttonDiv1">
                <input type="submit" value="Sign up" class="submitButton">
            </div>
            <div class="cancelDiv">
                <a href="index.jsp">Cancel</a>
            </div>
        </form>
        </div>
        </section>
        </main>
    </body>
</html>
