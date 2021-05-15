<%-- 
    Document   : cart
    Created on : 10/05/2021, 11:04:09 AM
    Author     : olivi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
    </head>
    <body>
        <h1>My Cart</h1>
        <table>
                <tr>
                    <th>Product Name</th>
                    <th></th>
                    <th>Quantity</th>
                    <th></th>
                    <th>Total Price</th>
                </tr>
        <c:forEach items="${orderLines}" var="orderLineItem">
            
            <tr>
                <td>${orderLineItem.product}</td> 
                              
                <td>${orderLineItem.quantity}</td>
                
                <td>${OrderLineItem.getSumPrice()}</td>
            </tr>
            
            
        </c:forEach>
            <tr></tr>
            <tr>
                <td>Total Price:</td>
                <td>${OrderLineItem.getSumPrice()}<<td>
            </tr>
            </table>

        <form action="ShippingServlet" method="post">
            <input type="submit" value="Continue to Shipping">
        </form>
    </body>
</html>
