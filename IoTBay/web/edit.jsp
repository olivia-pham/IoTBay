<%-- 
    Document   : edit
    Created on : 07/05/2021, 4:07:42 PM
    Author     : olivi
--%>

<%@page import="uts.isd.model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account Page</title>
    </head>
    <body>
        <%
            Customer customer = (Customer)session.getAttribute("customer");
            String updated = request.getParameter("updated");
        %>
        <h1>Edit Student Information <span> <%= (updated !=null) ? "Update was Successful":""%></span></h1>
        <div class="form">
        <form action="edit.jsp" method="POST">
            <table>
                <tr><td>Full Name:</td><td><input type="text" name="name" value="${customer.name}" required="true"></td></tr>
                <tr><td>Email:</td><td><input type="email" name="email" value="${customer.email}" required=></td></tr>
                <tr><td>Password:</td><td><input type="password" name="password" value="${customer.password}" required></td></tr>
                <tr><td>Date of Birth:</td><td><input type="date" name="dob" name="dob" value="${customer.dob}" required></td></tr>
                
            </table>
            <div>
                <a href="main.jsp" class="button">Main</a>
                <input class="button" type="submit" value="Update">
                <input type="hidden" name="updated" value="updated">
            </div>
        </form>
        </div>
                <%
                    String name = request.getParameter("name");
                    String email = request.getParameter("email");
                    String password = request.getParameter("password");
                    String dob = request.getParameter("dob");  
                    customer = new Customer(name, email, password, dob);
                    session.setAttribute("customer", customer);
                %>
        
    </body>
</html>
