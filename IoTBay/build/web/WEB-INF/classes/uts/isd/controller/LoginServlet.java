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
import uts.isd.model.Customer;
import uts.isd.model.Product;
import uts.isd.model.dao.DBManager;



/**
 *
 * @author olivi
 */
public class LoginServlet extends HttpServlet {
    
    @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
            throws ServletException, IOException {  
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        DBManager manager = (DBManager) session.getAttribute("manager");
        Customer customer = null;
        validator.clear(session);
        
        if(!validator.validateEmail(email)){
            session.setAttribute("emailErr", "Error: Email format is incorrect!");
            request.getRequestDispatcher("login.jsp").include(request, response);
        } else if(!validator.validatePassword(password)){
            session.setAttribute("passErr,", "Error: Password format is incorrect!");
            request.getRequestDispatcher("login.jsp").include(request, response);
        } else {
            try {
                customer = manager.findCustomer(email, password);
                    if(customer!= null){   
                        session.setAttribute("customer", customer);                            
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
