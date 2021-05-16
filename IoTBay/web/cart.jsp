<%-- 
    Document   : cart
    Created on : 10/05/2021, 11:04:09 AM
    Author     : olivi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.*"%>
<%@page import="uts.isd.model.dao.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
    </head>
    <% 
        ArrayList<OrderLine> orderLines = (ArrayList<OrderLine>) session.getAttribute("orderLines");
        session.setAttribute("orderLines", orderLines);
        request.setAttribute("orderLines", orderLines);
    %>
    <body>
        <h1>My Cart</h1>
        
        <table class="tableCenter">
            <tr><th>Product Name</th><th>Quantity</th><th>Price</th></tr>
            
            <c:forEach items="${orderLines}" var="orderLine">
            
            <tr>
                <td>${orderLine.productName}</td> 
                <td>${orderLine.quantity}</td>
                <td>${orderLine.price}</td>
                <td><form method="post" action="addToCartServlet">
                    <input type="submit" value="+">
                </form></td>
                <td><form method="post" action="removeFromCartServlet">
                    <input type="submit" value="-">
                </form></td>
            </tr>
            <tr></tr>

            </c:forEach>
                
        </table>

        <form action="ShippingServlet" method="post">
            <input type="submit" value="Submit Order">
        </form>
        <div class="buttonDiv1">
            <a href="shop.jsp" class="button">Back</a>
        </div>
        
    </body>
</html>
