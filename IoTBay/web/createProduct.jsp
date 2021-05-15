<%-- 
    Document   : createProduct
    Created on : 15/05/2021, 5:41:42 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Create Product</h1>
        <form action="CreateProductServlet" method="post">
            <table>
                <tr><td>ID:</td><td><input type="int"  name="id"></td></tr>
                <tr><td>Name:</td><td><input type="text"  name="name"></td></tr>
                <tr><td>Price:</td><td><input type="double"  name="price"></td></tr>
                <tr><td>Description:</td><td><input type="text" name="desc"></td></tr>
                <tr><td>Quantity:</td><td><input type="int" name="quant" required></td></tr>
                <tr><td>Type:</td><td><input type="text" name="type" required></td></tr>
                <tr><td></td>
                    <td><a href="manageProducts.jsp" class="button">Cancel</a>
                        <input class="button" type="submit" value="Enter">                        
                    </td>
                </tr>                
                
            </table>
          
        </form>
    </body>
</html>
