<%-- 
    Document   : deletePayment
    Created on : 21/05/2021, 10:54:43 AM
    Author     : JH
--%>

<%@page language= "java" contentType="text/html" pageEncoding="UTF-8"%>

<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.SQLException"%>

<%

    Connection conn = null;
    PreparedStatement pstmt = null;

    String send_id = request.getParameter("send_id");
    Class.forName("com.mysql.cj.jdbc.Driver");
    

    try
    {
        String driver = "jdbc:mysql://database-isd2021.cp1vsrjedvsf.us-east-1.rds.amazonaws.com/isd2021?useSSL=false";
        String user = "dbadmin";
        String pass = "dbadmin";
        conn = DriverManager.getConnection(driver, user, pass);

        pstmt = conn.prepareStatement("DELETE FROM PAYMENT WHERE Payment_ID=?");
        pstmt.setString(1, send_id);
        
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