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
 * @author olivi
 */
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        User customer = new User(name, email, password, phone,'c');
        DBManager manager = (DBManager) session.getAttribute("manager");
        try {
                if(customer!= null){   
                    session.setAttribute("customer", customer);    
                    manager.updateUser(name, email, password, phone);
                    session.setAttribute("updated", "Update was successful"); 
                    request.getRequestDispatcher("main.jsp").include(request, response);
                } else {
                    session.setAttribute("updated", "Update was not successful");
                    request.getRequestDispatcher("edit.jsp").include(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(EditServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            //response.sendRedirect("edit.jsp");
        }    

}
