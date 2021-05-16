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
import java.sql.*;
import uts.isd.model.dao.DBManager;
import uts.isd.model.dao.DBConnector;

/**
 *
 * @author jkmod
 */
public class StaffRegistrationServlet extends HttpServlet {
    
     private DBConnector conn;
    private DBManager manager;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        char Staff = 's';
        validator.validateEmail(email);
        validator.validatePassword(password);
        validator.validateName(name);
        validator.validateContactNumber(phone);
        validator.clear(session);
        
        if (validator.failed()) {
            request.getRequestDispatcher("staffRegistration.jsp").include(request, response);
        return;
        }
        
        try {
            conn = new DBConnector();
            manager = new DBManager(conn.openConnection());
            manager.addUser(name, email, password, phone, Staff);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            User staff = new User(name, email, password, phone, Staff);
            session.setAttribute("user", staff);
            request.getRequestDispatcher("main.jsp").include(request, response);

        
    }
}
