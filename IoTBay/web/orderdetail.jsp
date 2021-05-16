<%-- 
    Document   : orderdetail
    Created on : 17/05/2021, 1:08:14 AM
    Author     : JH
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%
    
    String fullName = request.getParameter("fullname");
    String email = request.getParameter("email");
    String address = request.getParameter("address");
    String cardnumber = request.getParameter("cardnumber");
    
    
    //System.out.println(email);
    //System.out.println(password);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body>
        <h1>Hey <%=fullName%> Thanks for your order!</h1>
        <br><br>
        <h2>Order detail</h2><br>
        <h3>Your shipping address is: <%=address%>  </h3>
        <h3>Payment Card used: <%=cardnumber%></h3>
        <br><br>
        <div class="col-25">
        <div class="container">
            <h2>Items <span class="price" style="color:black"><i class="fa fa-shopping-cart"></i> <b>2</b></span></h4>
            <p><a href="#">Product B</a>&nbsp;&nbsp;<a class="quantity">Qty: 2&nbsp;</a> <span class="price">$20</span></p>
            <p><a href="#">Product C</a>&nbsp;&nbsp;<a class="quantity">Qty: 1&nbsp;</a> <span class="price">$10</span></p>
<!--            <p><a href="#">StuffC</a> <span class="price">$1400</span></p>
            <p><a href="#">StuffD</a> <span class="price">$1200</span></p>-->
            <hr>
            <p>Total <span class="price" style="color:black"><b>$30</b></span></p>
        </div>
            <form action="main.jsp">
                <input type="submit" value="GetToMain" class="btn">
            </form>
    </body>
</html>
