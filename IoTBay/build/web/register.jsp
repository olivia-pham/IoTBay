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
        <script type="text/javascript" src="js/script.js"></script>
        <title>Registration Page</title>
    </head>
    <body onload="startTime()">
        <div><span class="time" id="time" ></span></div>
    
        <%
            String existErr = (String) session.getAttribute("existErr");
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
            String nameErr = (String) session.getAttribute("nameErr");
        %>
        <h1>Sign Up<span class="message"><%=(existErr != null ? existErr : "")%></span></h1>
        
        <div class="form">
        <form action="RegisterServlet" method="post">
            <table>
                <tr><td>Full Name:</td><td><input type="text" placeholder="<%=(nameErr != null ? nameErr : "Enter name")%>" name="name"></td></tr>
                <tr><td>Email:</td><td><input type="email" placeholder="<%=(emailErr != null ? emailErr : "Enter email")%>" name="email"></td></tr>
                <tr><td>Password:</td><td><input type="password" placeholder="<%=(passErr != null ? passErr : "Enter password")%>" name="password"></td></tr>
                <tr><td>Phone:</td><td><input type="text" placeholder="<%=(nameErr != null ? nameErr : "Enter Phone")%>" name="phone"></td></tr>
                <tr><td>Agree to Terms of Service:</td><td><input type="checkbox" name="tos" required></td></tr>
                <tr><td></td>
                    <td><a href="index.jsp" class="button">Cancel</a>
                        <input class="button" type="submit" value="Sign Up">                        
                    </td>
                </tr>                
                
            </table>
          
        </form>
        </div>

    </body>
</html>
