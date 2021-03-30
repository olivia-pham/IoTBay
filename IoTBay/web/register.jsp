<%-- 
    Document   : register
    Created on : 16/03/2021, 7:54:30 PM
    Author     : olivi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
    </head>
    <body>
        <h1>Sign Up</h1>
        <form action="welcome.jsp" method="POST">
            <table>
                <tr><td>Full Name:</td><td><input type="text" placeholder="Enter name" name="name" required="true"></td></tr>
                <tr><td>Email:</td><td><input type="email" placeholder="Enter email" name="email" required=></td></tr>
                <tr><td>Password:</td><td><input type="password" placeholder="Enter password" name="password" required></td></tr>
                <tr><td>Date of Birth:</td><td><input type="date" name="dob" required></td></tr>
                <tr><td>Gender:</td><td>
                        <input type="radio" id="male" name="gender" value="male">
                        <label for="male">Male</label>
                        <input type="radio" id="female" name="gender" value="female">
                        <label for="female">Female</label>
                        <input type="radio" id="other" name="gender" value="other">
                        <label for="other">Other</label>
                </td></tr>
                
                <tr><td>Agree to Terms of Service:</td><td><input type="checkbox" name="tos" required></td></tr>
            </table>
            <div>
                <a href="index.jsp">Cancel</a>
                <input type="submit" value="Sign up">
            </div>
        </form>

    </body>
</html>
