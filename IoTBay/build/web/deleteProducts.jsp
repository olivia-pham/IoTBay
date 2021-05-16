<%-- 
    Document   : deleteProducts
    Created on : 15/05/2021, 5:01:22 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.*"%>
<%@page import="uts.isd.model.dao.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<%
  ArrayList<Product> products = (ArrayList<Product>) session.getAttribute("productList");
  session.setAttribute("products", products);
  request.setAttribute("products", products);
  Product productO = (Product)session.getAttribute("product");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table class="tableCenter">
            <tr><th>Product Name</th><th>Select</th></tr>
            
            <c:forEach items="${products}" var="product">
                <tr><td>${product.getName()}</td>
                    <td>
                        <form action ="GetProductServlet" method="get"> 
                            <input type="hidden" name = "productSelect" value="${product.getId()}"> 
                            <input class="button" type="submit" value="select">
                        </form>
                    </td>
                <tr>
            </c:forEach>
                
        </table>
        <form action="TServlet" method="get" >
            <table><tr>
            <td><input type="text" name="searchProduct"  placeholder=""></td>
            <td><input class="button" type="submit" value="Update"></td>
            </tr>
           </table>
        </form>
        
        
    </body>
</html>
