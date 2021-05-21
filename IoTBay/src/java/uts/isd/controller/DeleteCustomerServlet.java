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
import uts.isd.model.User;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author jkmod
 */
public class DeleteCustomerServlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        DBManager manager = (DBManager) session.getAttribute("manager");
        User user = null;
        
         try {
             user = manager.findUser(email, password);
            if (email != null && password != null) {
                session.setAttribute("user", user);
                manager.deleteUser(email);
                request.getRequestDispatcher("logout.jsp").include(request, response);
            }

            else {
                session.setAttribute("existErr", "Error: Customer does not exist in database");
                request.getRequestDispatcher("edit.jsp").include(request, response);
            }
            request.getRequestDispatcher("logout.jsp").include(request, response);
            response.sendRedirect("logout.jsp"); 
            
        } catch (SQLException ex) {
            Logger.getLogger(TServlet.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
