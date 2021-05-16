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
import uts.isd.model.Customer;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author User
 */
public class CustomerManagementServelet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        String name = request.getParameter("searchName");
        String email = request.getParameter("searchEmail");
        try {
            if (!name.isEmpty() && email.isEmpty()) {
                ArrayList<Customer> customers = manager.searchCustomers(name);
                session.setAttribute("customerList", customers);
            }
            else if (name.isEmpty() && !email.isEmpty()) {
                ArrayList<Customer> customers = manager.searchTCustomers(email);
                session.setAttribute("customerList", customers);
            }
            else if (!name.isEmpty() && !email.isEmpty()) {
                ArrayList<Customer> customers = manager.searchBothCustomers(name, email);
                session.setAttribute("customerList", customers);
            }
            else {
                ArrayList<Customer> customers = manager.fectCustomers();
                session.setAttribute("customerList", customers);
            }
            
 
            request.getRequestDispatcher("customerManagement.jsp").include(request, response);
            response.sendRedirect("customerManagement.jsp"); 
            
        } catch (SQLException ex) {
            Logger.getLogger(TServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        //request.getRequestDispatcher(".jsp").include(request, response);
    }



}
