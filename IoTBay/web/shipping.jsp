<%-- 
    Document   : shipping
    Created on : 16/05/2021, 5:01:54 PM
    Author     : olivi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shipping</title>
        <link rel="stylesheet" type="text/css" href="./css/main.css">
    </head>
    <body>
        
        <h1>Shipping</h1>
        <form action="FinishOrderServlet" method="post">
            <table>
                <tr>
                    <td><label for="shippingAddress">Shipping Address: </label></td>
                    <td><input type="text" name="shippingAddress"></td>
                </tr>
                <tr>
                    <td><label for="date">Date: </label></td>
                    <td><input type="date" name="date"></td>
                    
                </tr>
            </table>
            <input type="submit" value="Proceed to Confirmation">
        </form>
    </body>
</html>
