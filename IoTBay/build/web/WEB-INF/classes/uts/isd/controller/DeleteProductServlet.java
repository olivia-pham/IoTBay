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
import uts.isd.model.OrderLine;
import uts.isd.model.Product;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author User
 */
public class DeleteProductServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        String id = request.getParameter("productSelect");
        Product product = null;
        
        try {
            product = manager.findProduct(id);
            if (product != null) {
              
                manager.deleteProduct(product.getId(), product.getName(), product.getPrice(), product.getQuantity(), product.getType());
                ArrayList<Product> products = manager.fectProducts();
                session.setAttribute("productList", products);
                //request.getRequestDispatcher("manageProducts.jsp").forward(request, response);
                response.sendRedirect("manageProducts.jsp"); 
                
                
            }
            } catch (SQLException ex) {
                Logger.getLogger(GetProductServlet.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getErrorCode() + " and " + ex.getMessage());
            }
    }
    
}
