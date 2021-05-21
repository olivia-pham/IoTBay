<%-- 
    Document   : addPayment
    Created on : 21/05/2021, 10:23:32 AM
    Author     : JH
--%>

<%@page language="java"  contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Payment Detail</h2>
<div class="row">
    <div class="col-75">
        <div class="container">
            <form id="validate" action="<%= request.getContextPath() %>/createPayment.jsp" method="POST">


                    <div class="col-50">
                        <br><h3>Create new Payment method </h3>


                        <label for="cname">Name on Card</label>
                        <input type="text" id="cname" name="cardname" placeholder=""required><br><br>
                        <label for="ccnum">Credit card number</label>
                        <input type="text" id="ccnum" name="cardnumber" placeholder=""required><br><br>
                        <label for="expmonth">Exp Month</label>
                        <input type="text" id="expmonth" name="expmonth" placeholder=""required><br><br>
                        <div class="row">
                            <div class="col-50">
                                <label for="expyear">Expiry Year</label>
                                <input type="text" id="expyear" name="expyear" placeholder=""required<br><br><br>
                            </div>
                            <div class="col-50">
                                <label for="cvv">CVV</label>
                                <input type="text" id="cvv" name="cvv" placeholder=""required><br><br><br>
                            </div>
                        </div>
                    </div>
                </div>

                <br><input type="submit" value="Submit" class="btn">
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
