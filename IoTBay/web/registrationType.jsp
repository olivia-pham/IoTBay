<%-- 
    Document   : registrationType
    Created on : 16/05/2021, 2:46:33 PM
    Author     : jkmod
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/main.css"> 
        <script type ="text/javascript" src="js/script.js"></script>
        <title>Registration Type</title>
    </head>
    <body onload="startTime()">
        <div><span class="time" id="time" ></span></div>
        <h1>Register as...</h1>        
        <div class="buttonDiv1">
            <a href="register.jsp" class="mainButton">Customer</a>
            <a href="admin.jsp" class="mainButton">Staff</a>
        </div>

        <jsp:include page="/ConnServlet" flush="true" />
    </body>
</html>
