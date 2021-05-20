<%-- 
    Document   : editOrderLine
    Created on : 20/05/2021, 10:05:50 PM
    Author     : olivi
--%>

<%@page import="uts.isd.model.*"%>
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
        <%  Product product = (Product)session.getAttribute("product");
            OrderLine orderLine = (OrderLine)session.getAttribute("orderLine");
        %>
        <form action="EditOrderLineServlet" method="get">
            <table>
                <tr><td>OrderLine ID:</td><td><input type="number" name="id" value="<%= orderLine.getOrderLineId()%>" required></td></tr>
                <tr><td>Quantity:</td><td><input type="number" name="quantity" value="<%= orderLine.getQuantity()%>" required></td></tr>
                <tr><td>Product ID:</td><td><input value="<%= orderLine.getProductId()%>" name="productId" required></td></tr> 
                <tr><td>Product Name:</td><td>${product.name}</td></tr> 
                <tr><td>Price/Unit ($):</td><td><input value="<%= orderLine.getPrice()%>" name="price" required></td></tr>
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
