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
<% 
    ArrayList<Order> orders = (ArrayList<Order>)session.getAttribute("orders");
    session.setAttribute("orders", orders);
    request.setAttribute("orders", orders);
    Order orderO = (Order)session.getAttribute("order");
%>
<!DOCTYPE html>
<link rel="stylesheet" type="text/css" href="css/main.css">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order History</title>
    </head>
    
    <body onload="startTime">
        <div class="form">
        <a href="main.jsp" class="button">Main</a>
        <h1>My Orders</h1>
        <form action="SearchOrderServlet" method="post">
            <table>
                <tr><th>Order ID</th> <th>Order Date</th></tr>
            <tr>
            <td><input type="text" name="searchID"  placeholder=""></td>
            <td><input type="text" name="searchDate"  placeholder=""></td>
            <td><input class="button" type="submit" value="Update"></td>
            </tr>
           </table>
        </form>

        
        <table class="tableCenter">
            <tr><th>Order ID</th><th>Order Date</th><th>Total Price</th></tr>
            
            <c:forEach items="${orders}" var="order">
                <tr><td>${order.getOrderID()}</td>
                    <td>${order.getOrderDate()}</td>
                    <td>${order.getTotalPrice()}</td>
      
                <tr>
            </c:forEach>
                
        </table>
        </div>

    </body>
</html>
