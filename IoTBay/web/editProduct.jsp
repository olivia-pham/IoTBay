<%-- 
    Document   : editProduct
    Created on : 15/05/2021, 12:56:29 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*"%>
<!DOCTYPE html>
<link rel="stylesheet" type="text/css" href="css/main.css">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Edit Product</title>
    </head>
    <body>
        <h1>Edit Product</h1>
        <h1>Product</h1>
        <%Product product = (Product)session.getAttribute("product");%>
        <div class="form">
         <form action="EditProductServlet" method="get">
            <table>
                <tr><td>Name:</td><td><input type="text"  name="name" value="<%= product.getName()%>"></td></tr>
                <tr><td>Price:</td><td><input type="number" step="0.01"  name="price" value="<%= product.getPrice()%>"></td></tr>
                <tr><td>Description:</td><td><input type="text" name="desc" value="<%= product.getDescription()%>"></td></tr>
                <tr><td>Quantity:</td><td><input type="number" name="quant" required value="<%= product.getQuantity()%>"></td></tr>
                <tr><td>Type:</td><td><input type="text" name="type" required value="<%= product.getType()%>"></td></tr>
                <input type="hidden" name="id" value="<%= product.getId()%>">
                <tr><td></td>
                    <td><a href="manageProducts.jsp" class="button">Cancel</a>
                        <input class="button" type="submit" value="update">                        
                    </td>
                </tr>                
                
            </table>
          
        </form>
        </div>
    </body>
</html>
