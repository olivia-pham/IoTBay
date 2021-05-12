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
  
  String test = (String) request.getAttribute("test1");
  //request.setAttribute("test1", test);
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
        <table class="tableCenter">
            <tr><th>Product Name</th></tr>
            
            <c:forEach items="${products}" var="product">
                <tr><td>${product.getName()}</td><tr>
            </c:forEach>
                
        </table>
        <form action="TServlet" method="post" >
            <table><tr>
            <td><input type="text" name="searchProduct"  placeholder=""></td>
            <td><input class="button" type="submit" value="Update"></td>
            </tr>
           </table>
        </form>
        </div>
    </body>
</html>
