<%-- 
    Document   : orderDetails
    Created on : 16/05/2021, 8:56:43 AM
    Author     : olivi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
    int orderId = (int) session.getAttribute("orderId");
    int userId = (int) session.getAttribute("userId");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Details</title>
    </head>
    <body>
        <h1>Order Details</h1>
    </body>
</html>
