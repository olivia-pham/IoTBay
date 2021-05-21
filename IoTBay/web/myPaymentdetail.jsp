<%-- 
    Document   : myPaymentdetail
    Created on : 21/05/2021, 7:16:53 AM
    Author     : JH
--%>

<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.SQLException"%>

<%--<%=request.getRequestURI()%>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Paymnet Detail</title>
    </head>
    <body>
        <h1>Your PaymentDetail</h1>
        <br><br>
        <a href="addPayment.jsp">
                <input type="button" value="New" />
        </a>
        <a href="main.jsp">
                <input type="button" value="Go To Main" />
            </a>
        <table width="100%" border="1">
    <tr>
        <td>Payment ID</td>
        <td>Name On Card</td>
        <td>Card Number</td>
        <td>Expiry Month</td>
        <td>Expiry Year</td>
        <td>CVV</td>
    </tr>
    
     <%
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        try
        {
            String driver = "jdbc:mysql://database-isd2021.cp1vsrjedvsf.us-east-1.rds.amazonaws.com/isd2021?useSSL=false";
            String user = "dbadmin";
            String pass = "dbadmin";
            conn = DriverManager.getConnection(driver, user, pass);
            

            
            pstmt = conn.prepareStatement("SELECT * FROM PAYMENT");
            rs = pstmt.executeQuery();
            while (rs.next()){
                  String id = rs.getString(1);
                  String noc = rs.getString("Name_On_Card");
                  String cn = rs.getString(3);
                  String exM = rs.getString(4);   
                  String exY = rs.getString(5);  
                  String cvv = rs.getString(6);  
        
     %>
     <tr>
         <td><%= id %></td>
         <td><%= noc%></td>
         <td with = "250"><%= cn %></td>
         <td><%= exM %></td>
         <td><%= exY %></td>
         <td><%= cvv %></td>

        <td>
            <a href="<%=request.getContextPath()%>/editPayment.jsp?send_id=<%=rs.getString("Payment_ID")%>">
                <input type="button" value="edit" />
            </a>
        </td>
        <td>
            <a href="<%=request.getContextPath()%>/deletePayment.jsp?send_id=<%=rs.getString("Payment_ID")%>">
                <input type="button" value="delete" />
            </a>
        </td>
     </tr>
     <%
       
            }
           
 
        } catch (SQLException ex) {
            out.println(ex.getMessage());
            ex.printStackTrace();
        } finally {
            
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException ex) {
                }
            if (pstmt != null)
                try {
                    pstmt.close();
                } catch (SQLException ex) {
                }
 
          
            if (conn != null)
                try {
                    conn.close();
                } catch (SQLException ex) {
                }
        }
    %>
 
</table>
    </body>
</html>
