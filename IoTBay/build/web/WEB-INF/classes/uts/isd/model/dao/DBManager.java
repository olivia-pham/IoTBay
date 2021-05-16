/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;

import java.sql.*;
import java.util.ArrayList;
import uts.isd.model.Customer;
import uts.isd.model.Product;

/**
 *
 * @author olivi
 */
public class DBManager {
    private Statement st;
    public DBManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }
    
    //Find customer by ID in the database
    public Customer findCustomer(String email, String password) throws SQLException {
        String fetch = "select * from ADMIN1.CUSTOMERS where EMAIL = '" + email + "' and PASSWORD='" + password + "'";
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()) {
            String customerEmail = rs.getString(2);
            String customerPass = rs.getString(3);
            if (customerEmail.equals(email) && customerPass.equals(password)) {
                String customerName = rs.getString(1);
                String customerDOB = rs.getString(4);
                return new Customer(customerName, customerEmail, password, customerDOB);
            }            
        }
        return null;
    }
    
    //add customer data into database
    public void addCustomer(String name, String email, String password, String dob) throws SQLException {
        st.executeUpdate("INSERT INTO ADMIN1.CUSTOMERS " + "VALUES ('" + name + "', '" + email + "', '" + password + "','" + dob + "')");
    }
    
    //update customer details in database
    public void updateCustomer(String name, String email, String password, String dob) throws SQLException {
        st.executeUpdate("UPDATE ADMIN1.Customers SET NAME='" + name + "',PASSWORD='" + password + "',dob='" + dob + "' WHERE EMAIL='" + email + "'");
    }
    
    //delete customer from database
    public void deleteCustomer(String name, String email, String password, String dob) throws SQLException {
        st.executeUpdate("DELETE FROM ADMIN1.Customers WHERE EMAIL='" + email + "'");
    }
    
    public ArrayList<Customer> fectCustomers() throws SQLException {
        String fetch = "select * from ADMIN1.CUSTOMERS";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Customer> temp = new ArrayList();
        
        while (rs.next()) {
            String name = rs.getString(1);
            String email = rs.getString(2);
            String password = rs.getString(3);
            String dob = rs.getString(4);
            temp.add(new Customer(name, email, password, dob));
        }
        return temp;        
    }
    
    public boolean checkCustomer(String email, String password) throws SQLException {
        String fetch = "select * from ADMIN1.Customers where EMAIL = '" + email + "' and password='" + password + "'";
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()) {
            String customerEmail = rs.getString(2);
            String customerPass = rs.getString(3);
            if (customerEmail.equals(email) && customerPass.equals(password)) {
                return true;
            }
        }
        return false;
    }
    
    public Product findProduct(String id) throws SQLException {
        String fetch = "select * from ADMIN1.Products where ID =" + id + "";
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()) {
          String productID = rs.getString(1);
            if (productID.equals(id)) {
                String productName = rs.getString(2);
                String productPrice = rs.getString(3);
                String productDesc = rs.getString(4);
                String productQuant = rs.getString(5);
                String productType = rs.getString(6);
                return new Product(productID, productName, productPrice, productDesc, productQuant, productType);
            }            
        }
        return null;
    }
    
    //add customer data into database
    public void addProduct(String id, String name, String price, String desc, String quant, String type) throws SQLException {
        st.executeUpdate("INSERT INTO ADMIN1.Products " + "VALUES (" + id + ", '" + name + "', " + price + ",'" + desc + "'," + quant + ", '" + type+"')");
    }
    
    //update customer details in database
    public void updateProduct(String id, String name, String price, String desc, String quant, String type) throws SQLException {
        st.executeUpdate("UPDATE ADMIN1.Products SET NAME='" + name + "',PRICE=" + price + ", DESCRIPTION='" + desc + "',QUANTITY="+ quant+" ,TYPE='"+type +"' WHERE ID=" + id + "");
    }
    
    //delete customer from database
    public void deleteProduct(String id, String name, String price, String desc) throws SQLException {
        st.executeUpdate("DELETE FROM ADMIN1.Products WHERE ID=" + id + "");
    }
    
    public ArrayList<Product> fectProducts() throws SQLException {
        String fetch = "select * from ADMIN1.PRODUCTS";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Product> temp = new ArrayList();
        
        while (rs.next()) {
            String id = rs.getString(1);
            String name = rs.getString(2);
            String price = rs.getString(3);
            String desc = rs.getString(4);
            String quant = rs.getString(5);
            String type = rs.getString(6);
            temp.add(new Product(id, name, price, desc, quant, type));
        }
        return temp;        
    }
    
    public ArrayList<Product> searchProducts(String input) throws SQLException {
        String fetch = "select * from ADMIN1.PRODUCTS WHERE Name LIKE '%" + input + "%'";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Product> temp = new ArrayList();
        
        while (rs.next()) {
            String id = rs.getString(1);
            String name = rs.getString(2);
            String price = rs.getString(3);
            String desc = rs.getString(4);
            String quant = rs.getString(5);
            String type = rs.getString(6);
            temp.add(new Product(id, name, price, desc, quant, type));
        }
        return temp;        
    }
    
    public ArrayList<Product> searchTProducts(String input) throws SQLException {
        String fetch = "select * from ADMIN1.PRODUCTS WHERE Type LIKE '%" + input + "%'";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Product> temp = new ArrayList();
        
        while (rs.next()) {
            String id = rs.getString(1);
            String name = rs.getString(2);
            String price = rs.getString(3);
            String desc = rs.getString(4);
            String quant = rs.getString(5);
            String type = rs.getString(6);
            temp.add(new Product(id, name, price, desc, quant, type));
        }
        return temp;        
    }
    
    public ArrayList<Product> searchBothProducts(String input, String input2) throws SQLException {
        String fetch = "select * from ADMIN1.PRODUCTS WHERE Name LIKE '%" + input + "%' AND Type LIKE '%" + input2 + "%'";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Product> temp = new ArrayList();
        
        while (rs.next()) {
            String id = rs.getString(1);
            String name = rs.getString(2);
            String price = rs.getString(3);
            String desc = rs.getString(4);
            String quant = rs.getString(5);
            String type = rs.getString(6);
            temp.add(new Product(id, name, price, desc, quant, type));
        }
        return temp;        
    }
    
    public boolean checkProduct(String id) throws SQLException {
        String fetch = "select * from ADMIN1.Products where ID = '" + id + "'";
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()) {
            String productID = rs.getString(1);
            if (productID.equals(id)) {
                return true;
            }
        }
        return false;
    }
    
}
