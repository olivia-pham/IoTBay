<%-- 
    Document   : orderHistory
    Created on : 16/05/2021, 7:50:25 AM
    Author     : olivi
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.*"%>
<%@page import="uts.isd.model.dao.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order History</title>
    </head>
    <% 
        ArrayList<Order> orders = (ArrayList<Order>)session.getAttribute("orders");
        session.setAttribute("orders", orders);
        request.setAttribute("orders", orders);
    %>
    <body>
        <h1>My Orders</h1>
        <form action="GetOrderLines" method="post">
            <table>
                <tr>
                    <td><label for="searchOrderID">Search:</label></td>
                    <td><input type="text" name="searchOrderID"></td>
                    <td><input type="submit" value="Search"></td>
                </tr>
                
            </table>
        </form>
        <table>
                <tr>
                    <th>Order ID</th>
                    <th>Date</th>
                    <th>Total Price</th>
                </tr>
        <c:forEach items="${orders}" var="order">            
                <tr>
                    <td>${order.orderID}</td>
                    <td>${order.orderDate}</td>
                    <td>${order.totalPrice}</td>
                </tr>
        </c:forEach>
        </table>
    </body>
</html>
