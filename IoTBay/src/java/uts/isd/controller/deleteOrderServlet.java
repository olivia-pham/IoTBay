/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author olivi
 */
public class deleteOrderServlet extends HttpServlet {
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        int orderID = Integer.parseInt(session.getAttribute("orderID").toString());
        DBManager manager = (DBManager) session.getAttribute("manager");
        try {
            manager.deleteOrder(orderID);
            manager.deleteOrderLine(orderID);
            request.getRequestDispatcher("cart.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(deleteOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
