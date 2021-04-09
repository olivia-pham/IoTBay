<%-- 
    Document   : logout
    Created on : 04/04/2021, 4:54:11 PM
    Author     : olivi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout Page</title>
    </head>
    <body>
        <h1>Logout</h1>
        
            <table>
                <tr>You have been logged out. Click <a href="index.jsp">here</a> to return to the index.</tr>
            </table>
       
        <% session.invalidate();%>
    </body>
</html>

