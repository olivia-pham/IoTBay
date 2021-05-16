<%-- 
    Document   : cart
    Created on : 10/05/2021, 11:04:09 AM
    Author     : olivi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
    
    ArrayList<OrderLine> orderLines = (ArrayList<OrderLine>) session.getAttribute("orderLines");
    session.setAttribute("orderLines", orderLines);
    request.setAttribute("orderLines", orderLines);
    OrderLine order0 = (OrderLine)session.getAttribute("orderLine");
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
    </head>
    <body onload="startTime()">
        <h1>My Cart</h1>
        <table>
                <tr>
                    <th>Product Name</th>
                    <th></th>
                    <th>Quantity</th>
                    <th></th>
                    <th>Price</th>
                </tr>
        <c:forEach items="${orderLines}" var="orderLine">
            
            <tr>
                <td>${orderLine.getProductName()}</td> 
                <td>
                    <form method="post" action="QuantityUp">
                    <input type="hidden" name="orderLineID" value="${orderLine.orderLineID}">
                    <input type="hidden" name="productID" value="${orderLine.productID}">
                    <input type="submit" value="Up">
                    </form>
                    </td>                
                <td>${orderLine.getQuantity()}</td>
                <td><form method="post" action="QuantityDown">
                    <input type="hidden" name="orderLineID" value="${orderLine.orderLineID}">
                    <input type="hidden" name="productID" value="${orderLine.productID}">
                    <input type="submit" value="Down">
                    </form></td>
                <td>${orderLine.getPrice()}</td>
            </tr>
            
            
        </c:forEach>
            <tr></tr>
            <tr>
                <td>Total Price:</td>
                <td>${orderLine.getTotalPrice()}<td>
            </tr>
            </table>
            <% 
            //session.setAttribute("totalPrice", ${orderLine.getTotalPrice()});
            %>
        <form action="ShippingServlet" method="post">
            <input type="submit" value="Continue to Shipping">
        </form>
    </body>
</html>
