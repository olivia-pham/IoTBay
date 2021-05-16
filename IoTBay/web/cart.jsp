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
                <td>${orderLine.productName}</td> 
                <td>
                    <form method="post" action="QuantityUp">
                    <input type="hidden" name="productID" value="${orderLine.productID}">
                    <input type="submit" value="Up">
                    </form>
                </td>                
                <td>${orderLine.quantity}</td>
                <td><form method="post" action="QuantityDown">
                    <input type="hidden" name="productID" value="${orderLine.productID}">
                    <input type="submit" value="Down">
                    </form></td>
                <td>${orderLine.price}</td>
            </tr>
            <tr></tr>
            <tr>
                <td>Total Price:</td>
                <td>${order.totalPrice}<td>
            </tr>
        </c:forEach>
            </table>
        <form action="OrderServlet" method="post">
            <input type="submit" value="Submit Order">
        </form>
    </body>
</html>
