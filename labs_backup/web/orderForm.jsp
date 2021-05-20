<%-- 
    Document   : orderForm
    Created on : 19/05/2021, 11:52:38 AM
    Author     : olivi
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.*"%>
<%@page import="uts.isd.model.dao.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Order Form</h1>
        <div class="form">
        <%Product product = (Product)session.getAttribute("product");%>
        <form action="addToCartServlet" method="post">
            <table>
                <tr><td>OrderLine ID:</td><td><input type="number" name="id" required></td></tr>
                <tr><td>Quantity:</td><td><input type="number" name="quantity" required></td></tr>
                <tr><td>Product ID:</td><td><input value="${product.id}" name="productId" required></td></tr> 
                <tr><td>Product Name:</td><td>${product.name}</td></tr> 
                <tr><td>Price/Unit ($):</td><td><input value="${product.price}" name="price" required></td></tr>
                <tr><td></td>
                    <td><a href="shop.jsp" class="button">Cancel</a>
                        <input class="button" type="submit" value="Add To Cart">                        
                    </td>
                </tr>             
                
            </table>
          
        </form>
        </div>
    </body>
</html>
