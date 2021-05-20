<%-- 
    Document   : confirmOrder
    Created on : 19/05/2021, 4:02:39 PM
    Author     : olivi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Confirm Order</h1>
        <div class="form">
        <form action="addOrderServlet" method="post">
            <table>
                             
                <tr><td>Order ID:</td><td><input type="number" name="id" required></td></tr>
                <tr><td>Account ID:</td><td><input value="${user.email}" name="userEmail" required></td></tr>
                <tr><td>Status:</td><td><input value="Pending" name="status" required></td></tr>
                <tr><td></td>
                    <td><a href="cart.jsp" class="button">Cancel</a>
                        <input class="button" type="submit" value="Confirm and Proceed">                        
                    </td>
                </tr>                
                
            </table>
          
        </form>
        </div>
    </body>
</html>
