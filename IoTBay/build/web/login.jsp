<%-- 
    Document   : login
    Created on : 30/03/2021, 12:01:39 PM
    Author     : olivi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="js/script.js"></script>
        <title>Login Page</title>
    </head>
    <body onload="startTime()">
        <div><span class="time" id="time"></span></div>
        <%
            String existErr = (String) session.getAttribute("existErr");
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
        %>
        
        <h1>Login <span class="message"> <%=(existErr != null ? existErr : "")%></span></h1>
        
        <div class="form">
        <form action="LoginServlet" method="post" class="centreText">
            <table id="form_table">
                <tr>
                    <td>Email:</td>
                    <td><input type="text" name="email" required="true" placeholder="<%=(emailErr != null ? emailErr : "Enter email")%>"></td>
                </tr>
                <tr><td>Password:</td>
                    <td><input type="password" name="password" required="true" placeholder="<%=(passErr != null ? passErr : "Enter password")%>"></td>
                </tr>
                        
            </table>
            <div class="buttonDiv1">
                <input type="submit" class="submitButton" value="Login">
            </div>
            
            <div class="cancelDiv">
                <a href="index.jsp">Go Back</a>
            </div>
        </form>
        </div>
    </body>
</html>