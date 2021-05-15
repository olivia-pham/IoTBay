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
             <thead><th>Product</th><th>Quantity</th><th>Price</th></thead>
        <tr><td>${orderLineItem.productID}</td><td>${orderLineItem.quantity}</td><td>${orderLineItem.price}</td></tr>    

            </table>

        <form action="ShippingServlet" method="post">
            <input type="submit" value="Continue to Shipping">
        </form>
    </body>
</html>
