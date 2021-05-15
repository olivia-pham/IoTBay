<%-- 
    Document   : shop
    Created on : 10/05/2021, 11:02:36 AM
    Author     : olivi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.*"%>
<%@page import="uts.isd.model.dao.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
  ArrayList<Product> products = (ArrayList<Product>) session.getAttribute("productList");
  session.setAttribute("products", products);
  request.setAttribute("products", products);
  Product productO = (Product)session.getAttribute("product");
%>
<!DOCTYPE html>
<link rel="stylesheet" type="text/css" href="css/main.css">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shop</title>
    </head>
    <body onload="startTime()">
        <div>
        <h1>Search Products</h1>
        <form action="TServlet" method="get" >
            <table>
                <tr><th>Name</th> <th>Type</th></tr>
            <tr>
            <td><input type="text" name="searchProduct"  placeholder=""></td>
            <td><input type="text" name="searchType"  placeholder=""></td>
            <td><input class="button" type="submit" value="Update"></td>
            </tr>
           </table>
        </form>
       
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
        
        </div>
    </body>
</html>
