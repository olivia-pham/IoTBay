<%-- 
    Document   : customerManagement
    Created on : 16/05/2021, 10:55:24 PM
    Author     : jasminehinds
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.*"%>
<%@page import="uts.isd.model.dao.*"%>
<%
  ArrayList<Customer> customers = (ArrayList<Customer>) session.getAttribute("customerList");
  session.setAttribute("customers", customers);
  request.setAttribute("customers", customers);
  Customer customerO = (Customer)session.getAttribute("customer");
%>
<!DOCTYPE html>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Management Page</title>
    </head>
    <body onload="startTime()">
        <div class="form">
        <a href="main.jsp" class="button">main</a>
        <h1>Search Customers</h1>
        <form action="TServlet" method="get" >
            <table>
                <tr><th>Email</th> <th>Password</th></tr>
            <tr>
            <td><input type="text" name="searchName"  placeholder="Name"></td>
            <td><input type="text" name="searchEmail"  placeholder="Email"></td>
            <td><input class="button" type="submit" value="Update"></td>
            </tr>
           </table>
        </form>
       
        <table class="tableCenter">
            <tr><th>Customer Name</th><th>Update</th></tr>
            
            <c:forEach items="${customers}" var="customer">
                <tr><td>${customer.getName()}</td>
                    <td>
                        <form action ="GetCustomerServlet" method="get"> 
                            <input type="hidden" name = "customerSelect" value="${customer.getName()}"> 
                        </form>
                    </td>
                <tr>
                <tr><td>${customer.getEmail()}</td>
                    <td>
                        <form action ="GetCustomerServlet" method="get"> 
                            <input type="hidden" name = "customerSelect" value="${customer.getEmail()}"> 
                        </form>
                    </td>
                <tr>
                <tr><td>${customer.getPassword()}</td>
                    <td>
                        <form action ="GetCustomerServlet" method="get"> 
                            <input type="hidden" name = "customerSelect" value="${customer.getPassword()}"> 
                        </form>
                    </td>
                <tr>
                <tr><td>${customer.getDob()}</td>
                    <td>
                        <form action ="GetCustomerServlet" method="get"> 
                            <input type="hidden" name = "customerSelect" value="${customer.getDob()}"> 

                        </form>
                    </td>
                <tr>
            </c:forEach>
                
        </table>                
        <a href="deleteCustomer.jsp" class="button">Delete a Customer</a>
        <a href="edit.jsp" class="button">Edit a Customer</a>
        <a href="register.jsp" class="button">Add a Customer</a>
        
        </div>
    </body>
</html>
