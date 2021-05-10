/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.dao.*;

/**
 *
 * @author olivi
 */
public class ConnServlet extends HttpServlet {
       private DBConnector db;
       private DBManager manager;
       private Connection conn;       

       @Override //Create and instance of DBConnector for the deployment session
       public void init() {
           try {
               db = new DBConnector();
           } catch (ClassNotFoundException | SQLException ex) {
               Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
           } 
       }     

       @Override //Add the DBConnector, DBManager, Connection instances to the session
       protected void doGet(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
           response.setContentType("text/html;charset=UTF-8");      
           HttpSession session = request.getSession();
           conn = db.openConnection();      
           try {
               manager = new DBManager(conn);
           } catch (SQLException ex) {
               Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
           }
           //export the DB manager to the view-session (JSPs)
           session.setAttribute("manager", manager);          
       }   

       @Override //Destroy the servlet and release the resources of the application (terminate also the db connection)
        public void destroy() {
           try {
               db.closeConnection();
           } catch (SQLException ex) {
               Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
}
