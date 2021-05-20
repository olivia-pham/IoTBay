/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import uts.isd.model.User;
import uts.isd.model.dao.DBManager;
import uts.isd.model.dao.*;


/**
 *
 * @author olivi
 */
public class LoginServlet extends HttpServlet {
    
    private DBManager manager;
    private DBConnector Connector;
    
    @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
            throws ServletException, IOException {  
        HttpSession session = request.getSession();
        long lastTime = session.getLastAccessedTime();
        Validator validator = new Validator();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        DBManager manager = (DBManager) session.getAttribute("manager");
        User user = null;
        validator.clear(session);
        
        if(!validator.validateEmail(email)){
            session.setAttribute("emailErr", "Error: Email format is incorrect!");
            request.getRequestDispatcher("login.jsp").include(request, response);
        } else if(!validator.validatePassword(password)){
            session.setAttribute("passErr,", "Error: Password format is incorrect!");
            request.getRequestDispatcher("login.jsp").include(request, response);
        } else {
            try {
                user = manager.findUser(email, password);
                    if(user!= null){   
                        session.setAttribute("user", user);                            
                        request.getRequestDispatcher("main.jsp").include(request, response);
                    } else {
                        session.setAttribute("existErr", "Error: Customer does not exist in database");
                        request.getRequestDispatcher("login.jsp").include(request, response);
                    }
                } catch (SQLException | NullPointerException ex) {
                        System.out.println(ex.getMessage() == null ? "Customer does not exist" : "Welcome");
                }
            }
        }
}
