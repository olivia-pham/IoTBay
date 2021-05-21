<%-- 
    Document   : editOrderForm
    Created on : 21/05/2021, 8:54:28 AM
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
        <title>Edit Cart</title>
    </head>
    <body>
        <h1>Order Form</h1>
        <%OrderLine orderLine = (OrderLine)session.getAttribute("orderLine");%>
        <div class="form">
        <form action="UpdateCartServlet" method="get">
            <table>
                <tr><td>OrderLine ID:</td><td><input value="<%= orderLine.getOrderLineId()%>" name="id" required></td></tr>
                <tr><td>Quantity:</td><td><input value="<%= orderLine.getProductId()%>" name="quantity" required></td></tr>
                <tr><td>ProductID:</td><td><input value="<%= orderLine.getQuantity()%>" name="productId" required></td></tr> 
                <tr><td>Product:</td><td>${product.name}</td></tr> 
                <tr><td>Price/Unit:</td><td><input value="<%= orderLine.getPrice()%>" name="price" required></td></tr>
                <tr><td></td>
                    <td><a href="cart.jsp" class="button">Cancel</a>
                        <input class="button" type="submit" value="Update">                        
                    </td>
                </tr>                
                
            </table>
          
        </form>
        </div>
    </body>
</html>
