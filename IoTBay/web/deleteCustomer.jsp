<%-- 
    Document   : deleteCustomer
    Created on : 16/05/2021, 11:55:20 PM
    Author     : jasminehinds
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.*"%>
<%@page import="uts.isd.model.dao.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<%
  ArrayList<Customer> customers = (ArrayList<Customer>) session.getAttribute("customerList");
  session.setAttribute("customers", customers);
  request.setAttribute("customers", customers);
  Customer customerO = (Customer)session.getAttribute("customer");
%>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete a Customer Page</title>
    </head>
    <body>
        <table class="tableCenter">
            <tr><th>Customer Name</th><th>Select</th></tr>
            
            <c:forEach items="${customers}" var="customer">
                <tr><td>${customer.getName()}</td>
                    <td>
                        <form action ="GetCustomerServlet" method="get"> 
                            <input type="hidden" name = "CustomerSelect" value="${customer.getName()}"> 
                            <input class="button" type="submit" value="select">
                        </form>
                    </td>
                <tr>
            </c:forEach>
                
        </table>
        <form action="CustomerManagementServlet" method="get" >
            <table><tr>
            <td><input type="text" name="searchName"  placeholder=""></td>
            <td><input class="button" type="submit" value="Update"></td>
            </tr>
           </table>
        </form>
        
        
    </body>
</html>

