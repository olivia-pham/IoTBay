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
public class UpdateCartItemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        String id = request.getParameter("orderLineSelect");
        OrderLine orderLine = null;
        
        try {
            orderLine = manager.findOrderLine(id);
            if (orderLine != null) {
              
                session.setAttribute("orderLine", orderLine);
                
                request.getRequestDispatcher("editOrderLine.jsp").include(request, response);
                
            }
            } catch (SQLException ex) {
                Logger.getLogger(UpdateCartItemServlet.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getErrorCode() + " and " + ex.getMessage());
            }
    }
}
