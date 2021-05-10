/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;

import java.sql.*;
import java.util.ArrayList;
import uts.isd.model.Customer;

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
        String fetch = "select * from IOTBAYUSER.Customers where EMAIL = '" + email + "' and PASSWORD='" + password + "'";
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
        st.executeUpdate("INSERT INTO IOTBAYUSER.Customers " + "VALUES ('" + name + "', '" + email + "', '" + password + "','" + dob + "')");
    }
    
    //update customer details in database
    public void updateCustomer(String name, String email, String password, String dob) throws SQLException {
        st.executeUpdate("UPDATE IOTBAYUSER.Customers SET NAME='" + name + "',PASSWORD='" + password + "',dob='" + dob + "' WHERE EMAIL='" + email + "'");
    }
    
    //delete customer from database
    public void deleteCustomer(String name, String email, String password, String dob) throws SQLException {
        st.executeUpdate("DELETE FROM IOTBAYUSER.Customers WHERE EMAIL='" + email + "'");
    }
    
    public ArrayList<Customer> fectCustomers() throws SQLException {
        String fetch = "select * from CUSTOMERS";
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
        String fetch = "select * from IOTBAYUSER.Customers where EMAIL = '" + email + "' and password='" + password + "'";
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
    
    
}
