/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;

import java.sql.*;
import java.util.ArrayList;
import uts.isd.model.*;

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
        String fect = "select * from IOTBAYUSER.CUSTOMERS where EMAIL = '" + email + "' and PASSWORD='" + password + "'";
        ResultSet rs = st.executeQuery(fect);
        
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
    
    //add customer data Stringo database
    public void addCustomer(String name, String email, String password, String dob) throws SQLException {
        st.executeUpdate("INSERT StringO IOTBAYUSER.CUSTOMERS " + "VALUES ('" + name + "', '" + email + "', '" + password + "','" + dob + "')");
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
        String fect = "select * from IOTBAYUSER.CUSTOMERS";
        ResultSet rs = st.executeQuery(fect);
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
        String fect = "select * from IOTBAYUSER.Customers where EMAIL = '" + email + "' and password='" + password + "'";
        ResultSet rs = st.executeQuery(fect);
        
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
        String fect = "select * from IOTBAYUSER.Products where ID = " + id + "";
        ResultSet rs = st.executeQuery(fect);
        
        while (rs.next()) {
          String productID = rs.getString(1);
            if (productID.equals(id)) {
                String productName = rs.getString(2);
                String productPrice = rs.getString(3);
                String productDesc = rs.getString(4);
                String productQuant = rs.getString(5);
                return new Product(productID, productName, productPrice, productDesc, productQuant);
            }            
        }
        return null;
    }
    
    //add customer data Stringo database
    public void addProduct(String id, String name, String price, String desc, String quant) throws SQLException {
        st.executeUpdate("INSERT StringO IOTBAYUSER.Products " + "VALUES (" + id + ", '" + name + "', " + price + ",'" + desc + "'," + quant + " )");
    }
    
    //update customer details in database
    public void updateProduct(String id, String name, String price, String desc, String quant) throws SQLException {
        st.executeUpdate("UPDATE IOTBAYUSER.Products SET ID=" + id + ",NAME='" + name + "',PRICE=" + price + " WHERE DESCRIPTION='" + desc + "'");
    }
    
    //delete customer from database
    public void deleteProduct(String id, String name, String price, String desc, String quant) throws SQLException {
        st.executeUpdate("DELETE FROM IOTBAYUSER.Products WHERE ID=" + id + "");
    }
    
    public ArrayList<Product> fectProducts() throws SQLException {
        String fect = "select * from IOTBAYUSER.PRODUCTS";
        ResultSet rs = st.executeQuery(fect);
        ArrayList<Product> temp = new ArrayList();
        
        while (rs.next()) {
            String id = rs.getString(1);
            String name = rs.getString(2);
            String price = rs.getString(3);
            String desc = rs.getString(4);
            String quant = rs.getString(5);
            temp.add(new Product(id, name, price, desc, quant));
        }
        return temp;        
    }


    
    public ArrayList<Product> searchProducts(String input) throws SQLException {
        String fect = "select * from IOTBAYUSER.PRODUCTS WHERE Name LIKE '%" + input + "%'";
        ResultSet rs = st.executeQuery(fect);
        ArrayList<Product> temp = new ArrayList();
        
        while (rs.next()) {
            String id = rs.getString(1);
            String name = rs.getString(2);
            String price = rs.getString(3);
            String desc = rs.getString(4);
            String quant = rs.getString(5);
            temp.add(new Product(id, name, price, desc, quant));
        }
        return temp;        
    }
    
    public boolean checkProduct(String id) throws SQLException {
        String fect = "select * from IOTBAYUSER.Products where ID = '" + id + "'";
        ResultSet rs = st.executeQuery(fect);
        
        while (rs.next()) {
            String productID = rs.getString(1);
            if (productID.equals(id)) {
                return true;
            }
        }
        return false;
    }
    // Order DBManager
    
    public Order findOrder(int oID) throws SQLException {
        String fetch = "select * from IOTBAYUSER.ORDERS where ID = " + oID + "'";
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()) {  // reads every row in USERS table and gets the result by index and stores them into Strings
            int orderID = rs.getInt(1);
            
            if (orderID == oID) {
                String userEmail = rs.getString(2);
                String orderDate = rs.getString(3);
                double totalPrice = rs.getDouble(4);
                String shippingAddress = rs.getString(5);
                return new Order(orderID, userEmail, orderDate, totalPrice, shippingAddress);
            }
            
        }
        return null;
    }
    
    public void addOrder(int orderID, String userEmail) throws SQLException {
        st.executeUpdate("INSERT INTO IOTBAYUSER.ORDERS VALUES ("+orderID+", '" +userEmail+"', null, null, null, null, null)");
              
        
          
    }
    
    public void updateOrder(int orderID, int userEmail, String orderDate, double totalPrice, String shippingAddress) throws SQLException {
        st.executeUpdate("UPDATE IOTBAYUSER.ORDERS SET ORDER_DATE='"+orderDate+"',TOTAL="+totalPrice+",SHIPPING_ADDRESS='"+
                shippingAddress+"' WHERE ID="+orderID + " AND USER_EMAIL='"+userEmail+"'");
    }
    
    public void deleteOrder(int orderID) throws SQLException {
        st.executeUpdate("DELETE FROM IOTBAYUSER.ORDERS WHERE ID=" +orderID+"");
    }
    
    public ArrayList<Order> fetchOrder() throws SQLException {
        String fetch = "select * from IOTBAYUSER.ORDERS";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Order> temp = new ArrayList();
        
        while (rs.next()) {
            int orderID = rs.getInt(1);
            String userEmail = rs.getString(2);
            String orderDate = rs.getString(3);
            double totalPrice = rs.getDouble(4);
            String shippingAddress = rs.getString(5);
            
            temp.add(new Order(orderID, userEmail, orderDate, totalPrice, shippingAddress));
        }
        return temp;
    }
    
    //orderline dbmanager
    public OrderLine findOrderLine(int oID, int pID) throws SQLException {
        String fetch = "select * from IOTBAYUSER.ORDERLINE where ID = " + oID + " and PRODUCT_ID="+pID+"";
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()) {  // reads every row in USERS table and gets the result by index and stores them into Strings
            
            int orderID = rs.getInt(2);
            int productID = rs.getInt(4);
            if (orderID == oID && productID==pID) {
                
                int orderLineID = rs.getInt(1);
                int quantity = rs.getInt(3);
                String productName = rs.getString(5);
                double totalPrice = rs.getDouble(6);
                double price = rs.getDouble(7);
                return new OrderLine(orderLineID, orderID, quantity, productID, productName, totalPrice, price);
                
            }
            
        }
        return null;
    }
    
    public void addOrderLine(int orderLineID, int orderID, int quantity, int productID, String productName, double totalPrice, double price) throws SQLException {
        st.executeUpdate("INSERT INTO IOTBAYUSER.ORDERLINE " + "VALUES (" +orderLineID+", " +orderID+", "+quantity+", "+productID+", '"+productName+"', "+totalPrice+", "+ price+")");
    }
    
    public void updateOrderLine(int orderLineID, int orderID, int quantity, int productID, String productName, double totalPrice, double price) throws SQLException {
        st.executeUpdate("UPDATE IOTBAYUSER.ORDERLINE SET ORDER_ID="+orderID+",QUANTITY="+quantity+",PRODUCT_ID="+productID+",PRODUCT_NAME='"+
                productName+"',TOTAL_PRICE="+totalPrice+", PRICE="+price+" WHERE ID="+orderLineID+"");
    }
    
    public void deleteOrderLine(int orderLineID) throws SQLException {
        st.executeUpdate("DELETE FROM IOTBAYUSER.ORDERLINE WHERE ID=" +orderLineID+"");
    }
    
    public ArrayList<OrderLine> fetchOrders(int orderID) throws SQLException {
        String fetch = "select * from IOTBAYUSER.ORDERLINE where ORDER_ID="+orderID+"";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<OrderLine> temp = new ArrayList<OrderLine>();
        
        while (rs.next()) {
            int orderLineID = rs.getInt(1);
            int quantity = rs.getInt(3);                
            int productID = rs.getInt(4);
            String productName = rs.getString(5);
            double totalPrice = rs.getDouble(6);
            double price = rs.getDouble(7);
            temp.add(new OrderLine(orderLineID, orderID, quantity, productID, productName, totalPrice, price));
        }
        return temp;
    }


}
