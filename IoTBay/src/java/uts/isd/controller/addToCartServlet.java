/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import uts.isd.model.Order;
import uts.isd.model.OrderLine;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author olivi
 */
public class addToCartServlet extends HttpServlet {

    @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
        HttpSession session = request.getSession();
        int productID = Integer.parseInt(request.getParameter("productID").toString());
        String productName = request.getParameter("productName");
        int orderLineID = Integer.parseInt(session.getAttribute("ID").toString());
        int orderID = Integer.parseInt(session.getAttribute("orderID").toString());
        double price =  Double.parseDouble(request.getParameter("price"));
        DBManager manager = (DBManager) session.getAttribute("manager");
          
        try {
            OrderLine orderLine = manager.findOrderLine(orderLineID, productID);
            if (orderLine == null) {
                manager.addOrderLine(orderLineID,orderID,1,productID,productName, price, price);
                Order order = manager.findOrder(orderID);
                order.updatePrice(price, 1);
                request.getRequestDispatcher("product.jsp").include(request, response);
            }
            else {
                orderLine.upQuantity();
                manager.updateOrderLine(orderLineID, orderID, orderLine.getQuantity(), productID, productName, orderLine.getTotalPrice(), price);
                Order order = manager.findOrder(orderID);
                order.updatePrice(price, orderLine.getQuantity());
                request.getRequestDispatcher("product.jsp").include(request, response);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(CartServlet.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        }
}
