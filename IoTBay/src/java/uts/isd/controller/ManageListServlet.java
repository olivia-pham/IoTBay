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
import uts.isd.model.Product;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author User
 */
public class ManageListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        String stuff = request.getParameter("searchProduct");
        try {
            if (!stuff.equals("")) {
                ArrayList<Product> products = manager.searchProducts(stuff);
                session.setAttribute("productList", products);
            }
            else {
                ArrayList<Product> products = manager.fectProducts();
                session.setAttribute("productList", products);
            }
            
 
            request.getRequestDispatcher("manageProducts.jsp").include(request, response);
            response.sendRedirect("manageProducts.jsp"); 
            
        } catch (SQLException ex) {
            Logger.getLogger(TServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        //request.getRequestDispatcher("shop.jsp").include(request, response);
    }
}

