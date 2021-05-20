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
import uts.isd.model.*;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author olivi
 */
public class removeFromCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        //String id = request.getParameter("orderLineSelect");
        //OrderLine orderLine = null;
        String id = request.getParameter("orderLineSelect");
        OrderLine orderLine = null;
        
        try {
            orderLine = manager.findOrderLine(id);
            if (orderLine != null) {
              
                manager.deleteOrderLine(orderLine.getOrderLineId());
                ArrayList<OrderLine> orderLines = manager.fetchOrders();
                session.setAttribute("orderLines", orderLines);
                //request.getRequestDispatcher("manageOrderLines.jsp").forward(request, response);
                response.sendRedirect("cart.jsp"); 
                
                
            }
            } catch (SQLException ex) {
                Logger.getLogger(removeFromCartServlet.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getErrorCode() + " and " + ex.getMessage());
            }
    }
}



