<%-- 
    Document   : product
    Created on : 15/05/2021, 2:37:58 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.dao.*"%>
<%@page import="uts.isd.model.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Product</h1>
        <%Product product = (Product)session.getAttribute("product");%>
        <h1><%= product.getId()%></h1>
        <h1><%= product.getName()%></h1>
        <h1><%= product.getPrice()%></h1>
        <h1><%= product.getDescription()%></h1>
        <h1><%= product.getQuantity()%></h1>
        
    </body>
</html>
