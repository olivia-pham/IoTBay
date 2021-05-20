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
%>
<body>
        <h1>My Orders</h1>
        
        <table class="tableCenter">
            <tr><th>Order ID</th><th>Status</th></tr>
            
            <c:forEach items="${orders}" var="order">
            
            <tr>
                <td>${order.orderId}</td> 
                <td>${order.status}</td>

            </tr>
            <tr></tr>

            </c:forEach>
                
        </table>

        
        <div class="buttonDiv1">
            <a href="main.jsp" class="button">Back to Main</a>
        </div>
        
    </body>
</html>