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
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="form">
        <a href="shop.jsp" class="button">Shop</a>
        <h1>Product</h1>
        <%Product product = (Product)session.getAttribute("product");%>
        <form action="addToCartServlet" method="post">
        <h1><%= product.getId()%></h1>
        <h1><%= product.getName()%></h1>
        <h1><%= product.getPrice()%></h1>
        <h1><%= product.getDescription()%></h1>
        <h1><%= product.getQuantity()%></h1>
        <div class="buttonDiv1">
            <input type="submit" class="submitButton" value="Add to Cart">
        </div>
        </form>
        
        <div class="buttonDiv1">
            <a href="CartServlet" class="button">Go to Cart</a>
        </div>
    </body>
</html>