<%-- 
    Document   : paymnet
    Created on : 16/05/2021, 5:40:30 PM
    Author     : JH
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    
    <title>Payment</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- library validate -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.js"></script>
    <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.js"></script>
    <!-- style css -->
    <link rel="stylesheet" href="css/main.css">
</head>
<body>

<h2>Payment Detail</h2>
<div class="row">
    <div class="col-75">
        <div class="container">
            <form id="validate" action="orderdetail.jsp" method="POST">
                <div class="row">
                    <div class="col-50">
                        <h3>Shipping Address</h3>
                        <label for="fname"><i class="fa fa-user"></i> Full Name</label>
                        <input type="text" id="fname" name="fullname" placeholder="" value=${customer.name} required><br><br>
                        <label for="email"><i class="fa fa-envelope"></i> Email</label>
                        <input type="text" id="email" name="email" placeholder="" value=${customer.email} required><br><br>
                        <label for="adr"><i class="fa fa-address-card-o"></i> Address</label>
                        <input type="text" id="adr" name="address" placeholder="" required><br><br>
                        <label for="city"><i class="fa fa-phone"></i> Phone</label>
                        <input type="text" id="city" name="phone" placeholder="" required><br><br>

<!--                        <div class="row">
                            <div class="col-50">
                                <label for="state">State</label>
                                <input type="text" id="state" name="state" placeholder=""required><br><br>
                            </div>
                            <div class="col-50">
                                <label for="zip">Zip</label>
                                <input type="text" id="zip" name="zip" placeholder=""required><br><br>
                            </div>
                        </div>-->
                    </div>

                    <div class="col-50">
                        <br><h3>Payment</h3>
<!--                        <label for="fname">Accepted Cards</label>
                        <div class="icon-container">
                            <i class="fa fa-cc-visa" style="color:navy;"></i>
                            <i class="fa fa-cc-amex" style="color:blue;"></i>
                            <i class="fa fa-cc-mastercard" style="color:red;"></i>
                            <i class="fa fa-cc-discover" style="color:orange;"></i>
                        </div>-->

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
                <label>
                <input type="checkbox" checked="checked" name="sameadr"> Save my payment detail
                </label>
                <br><input type="submit" value="checkout" class="btn">
            </form>
        </div>
    </div>
    <div class="col-25">
        <div class="container">
            <% 
                ArrayList<OrderLine> orderLines = (ArrayList<OrderLine>) session.getAttribute("orderLines");
                session.setAttribute("orderLines", orderLines);
                request.setAttribute("orderLines", orderLines);
            %>
            <h4>Cart <span class="price" style="color:black"><i class="fa fa-shopping-cart"></i> <b>2</b></span></h4>
            <table class="tableCenter">
            <tr><th>Product Name</th><th>Quantity</th><th>Price</th></tr>
            
            <c:forEach items="${orderLines}" var="orderLine">
            
            <tr>
                <td>${orderLine.orderLineId}</td> 
                <td>${orderLine.quantity}</td>
                <td>${orderLine.price}</td>
                <td><form method="post" action="addToCartServlet">
                    <input type="submit" value="+">
                </form></td>
                <td><form method="post" action="removeFromCartServlet">
                    <input type="submit" value="-">
                </form></td>
            </tr>
            <tr></tr>

            </c:forEach>
                
        </table>
<!--            <p><a href="#">StuffC</a> <span class="price">$1400</span></p>
            <p><a href="#">StuffD</a> <span class="price">$1200</span></p>-->
            <hr>
            <p>Total <span class="price" style="color:black"><b>$30</b></span></p>
        </div>
    </div>
</div>
<!-- script validate js -->
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
