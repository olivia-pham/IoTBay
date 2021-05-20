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
import uts.isd.model.*;
import uts.isd.model.dao.*;

/**
 *
 * @author olivi
 */
public class addToCartServlet extends HttpServlet  {
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String id = request.getParameter("id");
        String productId = request.getParameter("productId");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        DBManager manager = (DBManager) session.getAttribute("manager");
 
        try {
            manager.addOrderLine(id, quantity, productId, price);
            ArrayList<OrderLine> orderLines = manager.fetchOrders();
            session.setAttribute("orderLines", orderLines);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            request.getRequestDispatcher("cart.jsp").include(request, response);

        
    }
}