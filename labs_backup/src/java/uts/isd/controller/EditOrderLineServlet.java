/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.*;
import uts.isd.model.dao.*;
import java.util.ArrayList;

/**
 *
 * @author olivi
 */
public class EditOrderLineServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String id = request.getParameter("id");
        String price = request.getParameter("price");
        String productId = request.getParameter("productId");
        String quantity = request.getParameter("quantity");
        DBManager manager = (DBManager) session.getAttribute("manager");
        
        try {
                if(manager.findOrderLine(id) != null){                                
                   manager.updateOrderLine(id, quantity, productId, price);
                   ArrayList<OrderLine> orderLines = manager.fetchOrders();
                   session.setAttribute("orderLines", orderLines);
                }
            } catch (SQLException ex) {
                Logger.getLogger(EditServlet.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getErrorCode() + " and " + ex.getMessage());
            }
            request.getRequestDispatcher("cart.jsp").include(request, response);
        } 
    
}
