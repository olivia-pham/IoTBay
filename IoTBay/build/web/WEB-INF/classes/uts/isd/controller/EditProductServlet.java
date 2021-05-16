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
import uts.isd.model.Product;
import uts.isd.model.dao.DBManager;
import java.util.ArrayList;
/**
 *
 * @author User
 */
public class EditProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
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
                if(manager.findProduct(id) != null){                                
                   manager.updateProduct(id, name, price, desc, quant, type);
                   ArrayList<Product> products = manager.fectProducts();
                   session.setAttribute("productList", products);
                }
            } catch (SQLException ex) {
                Logger.getLogger(EditServlet.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getErrorCode() + " and " + ex.getMessage());
            }
            request.getRequestDispatcher("manageProducts.jsp").include(request, response);
        } 
    
}
