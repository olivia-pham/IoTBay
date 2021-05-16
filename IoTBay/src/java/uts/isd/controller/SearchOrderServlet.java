/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;
import uts.isd.model.*;
import uts.isd.model.dao.*;

/**
 *
 * @author olivi
 */
public class SearchOrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        String ID = request.getParameter("searchID");
        String date = request.getParameter("searchDate");
        try {
            if (!ID.isEmpty() && date.isEmpty()) {
                ArrayList<Order> orders = manager.searchOrders(ID);
                session.setAttribute("orders", orders);
            }
            else if (ID.isEmpty() && !date.isEmpty()) {
                ArrayList<Order> orders = manager.searchDOrders(date);
                session.setAttribute("orders", orders);
            }
            else if (!ID.isEmpty() && !date.isEmpty()) {
                ArrayList<Order> orders = manager.searchBothOrders(ID, date);
                session.setAttribute("orders", orders);
            }
            else {
                ArrayList<Order> orders = manager.fetchOrder();
                session.setAttribute("orders", orders);
            }
            request.getRequestDispatcher("orderHistory.jsp").include(request, response);
            response.sendRedirect("orderHistory.jsp"); 
            
        } catch (SQLException ex) {
            Logger.getLogger(SearchOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        //request.getRequestDispatcher("shop.jsp").include(request, response);
    }


}
