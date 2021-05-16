/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.OrderLine;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author olivi
 */
public class removeFromCartServlet extends HttpServlet {

    @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
        HttpSession session = request.getSession();
        String orderLineID = request.getParameter("orderLineID");
        String orderID = request.getParameter("orderID");
        String userID = request.getParameter("userID");
        String productID = request.getParameter("productID");
        String productName = request.getParameter("productName");
        String price = request.getParameter("price");
        DBManager manager = (DBManager) session.getAttribute("manager");
        
        
        try {
                if (manager.findOrderLine(orderLineID) != null){
                    manager.deleteOrderLine(orderLineID);
                    ArrayList<OrderLine> orderLines = manager.fetchOrders();
                    session.setAttribute("orderList", orderLines);
                } else {
                }
            } catch (SQLException ex) {
                Logger.getLogger(addToCartServlet.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getErrorCode() + " and " + ex.getMessage());
            }
            request.getRequestDispatcher("cart.jsp").include(request, response);
        } 
}



