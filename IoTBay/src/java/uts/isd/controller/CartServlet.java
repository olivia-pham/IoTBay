/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.Order;
import uts.isd.model.OrderLine;
import uts.isd.model.Product;
import uts.isd.model.dao.*;

/**
 *
 * @author olivi
 */
public class CartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        int orderID = Integer.parseInt(session.getAttribute("orderID").toString());
        int userID = Integer.parseInt(session.getAttribute("userID").toString());
        try {
            ArrayList<OrderLine> orderLines = manager.fetchOrders(orderID);
            session.setAttribute("orderLines", orderLines);
            Order order = manager.findOrder(orderID);
            double totalPrice = 0;
            for (OrderLine orderLine : orderLines) {
                totalPrice = totalPrice + orderLine.getTotalPrice();
            }
            double tax = totalPrice/10;
            order.setTotalPrice(totalPrice);
            session.setAttribute("order", order);
            request.getRequestDispatcher("cart.jsp").include(request, response);
            
        } catch (SQLException ex) {
            Logger.getLogger(CartServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}