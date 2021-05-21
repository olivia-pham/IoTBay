<%-- 
    Document   : editPayment
    Created on : 21/05/2021, 8:59:08 AM
    Author     : JH
--%>

<%@page language="java"  contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.SQLException"%>

<%
    String send_id = request.getParameter("send_id");
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    String dbid = null;
    String dbnoc = null;
    String dbcn = null;
    String expM = null;
    String expY = null;
    String cvv = null;
    
    try
    {
            String driver = "jdbc:mysql://database-isd2021.cp1vsrjedvsf.us-east-1.rds.amazonaws.com/isd2021?useSSL=false";
            String user = "dbadmin";
            String pass = "dbadmin";
            conn = DriverManager.getConnection(driver, user, pass);
            pstmt = conn.prepareStatement("SELECT * FROM PAYMENT WHERE Payment_ID=?");
            pstmt.setString(1, send_id);
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
            dbid = rs.getString("Payment_ID");
            dbnoc = rs.getString("Name_On_Card");
            dbcn = rs.getString("Card_Number");
            expM = rs.getString("Expiry_Month");
            expY = rs.getString("Expiry_Year");
            cvv = rs.getString("CVV");
            }

    }catch (SQLException ex) {
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

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

<div class="row">
    <div class="col-75">
        <div class="container">
            <form id="validate" action="<%=request.getContextPath()%>/updatePayment.jsp" method="POST">
                <div class="row">
                   

                    <div class="col-50">
                        <br><h3>Payment</h3>
                        <input type="hidden" name="m_id" size="20" value="<%=dbid%>"/>
                        
                        
                        <label for="cname">Name on Card</label>
                        <input type="text" id="cname" name="cardname" placeholder="" value="<%=dbnoc%>" required><br><br>
                        <label for="ccnum">Credit card number</label>
                        <input type="text" id="ccnum" name="cardnumber" placeholder="" value="<%=dbcn%>" required><br><br>
                        <label for="expmonth">Exp Month</label>
                        <input type="text" id="expmonth" name="expmonth" placeholder="" value="<%=expM%>" required><br><br>
                        <div class="row">
                            <div class="col-50">
                                <label for="expyear">Expiry Year</label>
                                <input type="text" id="expyear" name="expyear" placeholder="" value="<%=expY%>" required<br><br><br>
                            </div>
                            <div class="col-50">
                                <label for="cvv">CVV</label>
                                <input type="text" id="cvv" name="cvv" placeholder="" value="<%=cvv%>" required><br><br><br>
                            </div>
                        </div>
                    </div>
                </div>
<!--                <label>
                <input type="checkbox" checked="checked" name="sameadr"> Save my payment detail
                </label>-->
                <br><input type="submit" value="submit" class="btn">
            </form>
        </div>
    </div>
</div>
        <script>
    $('#validate').validate({
        roles: {
            fullname: {
                required: true,
            },
            email: {
                required: true,
            },
            address: {
                required: true,
            },
            city: {
                required: true,
            },
            state: {
                required: true,
            },
            zip: {
                required: true,
            },
            cardname: {
                required: true,
            },
            cardnumber: {
                required: true,
            },
            expmonth: {
                required: true,
            },
            expyear: {
                required: true,
            },
            cvv: {
                required: true,
            },
           
        },
        messages: {
            fullname:"Please input full name*",
            email:"Please input email*",
            city:"Please input city*",
            address:"Please input address*",
            state:"Please input state*",
            zip:"Please input address*",
            cardname:"Please input card name*",
            cardnumber:"Please input card number*",
            expmonth:"Please input exp month*",
            expyear:"Please input exp year*",
            cvv:"Please input cvv*",
        },
    });
</script>
    </body>
</html>
