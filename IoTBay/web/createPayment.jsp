<%-- 
    Document   : createPayment
    Created on : 21/05/2021, 10:30:26 AM
    Author     : JH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.SQLException"%>

<%
    Connection conn = null;
    PreparedStatement pstmt = null;
    
    String noc = request.getParameter("cardname");
    String cn = request.getParameter("cardnumber");
    String expM = request.getParameter("expmonth");
    String expY = request.getParameter("expyear");
    String cvv = request.getParameter("cvv");

    Class.forName("com.mysql.cj.jdbc.Driver");
    
    try
    {
        String driver = "jdbc:mysql://database-isd2021.cp1vsrjedvsf.us-east-1.rds.amazonaws.com/isd2021?useSSL=false";
        String user = "dbadmin";
        String pass = "dbadmin";
        conn = DriverManager.getConnection(driver, user, pass);
        
        pstmt = conn.prepareStatement("INSERT INTO PAYMENT VALUES(default, ?, ?, ?, ?, ?)");
                

        pstmt.setString(1, noc);
        pstmt.setString(2, cn);
        pstmt.setString(3, expM);
        pstmt.setString(4, expY);
        pstmt.setString(5, cvv);
        
        int result = pstmt.executeUpdate();
        System.out.println(result);
        
        response.sendRedirect(request.getContextPath() +"/myPaymentdetail.jsp");
        
        
        
    }finally {
     
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