/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import uts.isd.model.Order;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author olivi
 */
public class submitOrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int orderID = Integer.parseInt(session.getAttribute("orderID").toString());
        int userID = Integer.parseInt(session.getAttribute("userID").toString());
        
        DBManager manager = (DBManager) session.getAttribute("manager");
        String billingAddress = request.getParameter("billingAddress");
        String shippingAddress = request.getParameter("shippingAddress");
        try {
            Order order = manager.findOrder(orderID);
            order.setShippingAddress(shippingAddress);

            String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());

            order.setOrderDate(date);
            manager.updateOrder(orderID, userID, date, order.getTotalPrice(), shippingAddress);
            session.setAttribute("order", order);
            request.getRequestDispatcher("finalOrder.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(submitOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
