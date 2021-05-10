<%-- 
    Document   : test
    Created on : 16/03/2021, 7:49:13 PM
    Author     : olivi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/main.css"> 
        <script type ="text/javascript" src="js/script.js"></script>
        <title>Home Page</title>
    </head>
    <body onload="startTime()">
        <div><span class="time" id="time" ></span></div>
        <h1>The IoT Store</h1>        
        <div class="buttonDiv1">
            <a href="register.jsp" class="mainButton">Register</a>
            <a href="login.jsp" class="mainButton">Login</a>
        </div>

        <jsp:include page="/ConnServlet" flush="true" />
    </body>
</html>
