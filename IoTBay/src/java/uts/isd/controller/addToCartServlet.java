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
public class addToCartServlet extends HttpServlet {

    @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {       
        HttpSession session = request.getSession();
        int productID = Integer.parseInt(request.getParameter("productID").toString());
        int userID = Integer.parseInt(session.getAttribute("userID").toString());
        String productName = request.getParameter("productName");
        int orderID = Integer.parseInt(session.getAttribute("orderID").toString());
        int orderLineID = Integer.parseInt(session.getAttribute("orderLineID").toString());
        double price =  Double.parseDouble(request.getParameter("price"));
        DBManager manager = (DBManager) session.getAttribute("manager");
        
        
        try {
                if(manager.findOrderLine(orderID, userID) != null){
                   manager.updateOrderLine(orderLineID, orderID, userID, productID, productName, price, price);
                   ArrayList<OrderLine> orderLines = manager.fetchOrders(orderID);
                   session.setAttribute("orderList", orderLines);
                }
            } catch (SQLException ex) {
                Logger.getLogger(addToCartServlet.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getErrorCode() + " and " + ex.getMessage());
            }
            request.getRequestDispatcher("manageProducts.jsp").include(request, response);
        } 
}
