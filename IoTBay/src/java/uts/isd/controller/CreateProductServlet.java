/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import uts.isd.model.Product;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author User
 */
public class CreateProductServlet extends HttpServlet  {
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String desc = request.getParameter("desc");
        String quant = request.getParameter("quant");
        String type = request.getParameter("type");
        DBManager manager = (DBManager) session.getAttribute("manager");
 
        try {
            manager.addProduct(id, name, price, desc, quant, type);
            ArrayList<Product> products = manager.fectProducts();
            session.setAttribute("productList", products);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            request.getRequestDispatcher("manageProducts.jsp").include(request, response);

        
    }
    
}
