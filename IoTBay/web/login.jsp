<%-- 
    Document   : login
    Created on : 30/03/2021, 12:01:39 PM
    Author     : olivi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.Customer"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <%Customer customer = new Customer("Dave","b@c","pass","20/22/1999","Male");%>
        <%if (request.getParameter("something") == null) {%>
        <form action ="login.jsp" method="POST">
            <table>
                <tr><td>Email:</td><td><input type="text" name="email" required="true" placeholder="Enter email"></td></tr>
                <tr><td>Password:</td><td><input type="text" name="password" required="true" placeholder="Enter password"></td></tr>
                <input type="hidden" name="something">           
            </table>
            <div>
                <a href="index.jsp">Cancel</a>
                <input type="submit" value="Login">
            </div>
        </form>
        <%} else {%>
            <%if (request.getParameter("email").equals(customer.getEmail()) && request.getParameter("password").equals(customer.getPassword())) { %>
                <form action="welcome.jsp" method="POST">
                    <input type="hidden" name="name" value="<%= customer.getName() %>">
                    <input type="hidden" name="email" value="<%= request.getParameter("email")%>">
                    <input type="hidden" name="password" value="<%= request.getParameter("password") %>">
                    <input type="hidden" name="dob" value="<%= customer.getDob() %>">
                    <input type="hidden" name="gender" value="<%= customer.getGender() %>">
                    <table>
                        <tr>Account found.</tr>
                    </table>
                    <input type="submit" value="Contiune">
                </from>
            <%} else {%>
                <div> Password or Email is wrong <a href="login.jsp"> back</a></div>
            <%}%>
        <%}%>
    </body>
</html>
