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
        String fetch = "select * from IOTBAYUSER.CUSTOMERS where EMAIL = '" + email + "' and PASSWORD='" + password + "'";
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
        String fetch = "select * from IOTBAYUSER.CUSTOMERS";
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
    
    public Product findProduct(String id) throws SQLException {
        String fetch = "select * from IOTBAYUSER.Products where ID = " + id + "";
        ResultSet rs = st.executeQuery(fetch);
        
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
        String fetch = "select * from IOTBAYUSER.PRODUCTS";
        ResultSet rs = st.executeQuery(fetch);
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
        String fetch = "select * from IOTBAYUSER.PRODUCTS WHERE Name LIKE '%" + input + "%'";
        ResultSet rs = st.executeQuery(fetch);
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
        String fetch = "select * from IOTBAYUSER.Products where ID = '" + id + "'";
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()) {
            String productID = rs.getString(1);
            if (productID.equals(id)) {
                return true;
            }
        }
        return false;
    }
    // Order DBManager
    
    public Order findOrder(String ID) throws SQLException {
        String fetch = "select * from IOTBAYUSER.ORDERS where ID = " + ID + "'";
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()) {  // reads every row in USERS table and gets the result by index and stores them Stringo Strings
            String orderID = rs.getString(1);
            if (orderID == ID) {
                String customerEmail = rs.getString(2);
                String shippingAddress = rs.getString(3);
                String total = rs.getString(4);
                String status = rs.getString(5);
                String trackingID = rs.getString(6);
                String shipmentID = rs.getString(7);
                return new Order(orderID, customerEmail, shippingAddress, total, status, trackingID, shipmentID);                
            }
            
        }
        return null;
    }
    
    public void addOrder(String orderID, String customerEmail) throws SQLException {
        st.executeUpdate("INSERT StringO IOTBAYUSER.ORDERS VALUES ("+orderID+", '" +customerEmail+"', null, null, null, null, null)");          
    }
    
    public void updateOrder(String orderID, String customerEmail, String shippingAddress, String total, String status, String trackingID, String shipmentID) throws SQLException {
        st.executeUpdate("UPDATE IOTBAYUSER.ORDERS SET TOTAL="+total+",SHIPPING_ADDRESS='"+
                shippingAddress+"' WHERE ID="+orderID + " AND CUSTOMER_EMAIL='"+customerEmail+"'");
    }
    
    public void deleteOrder(String orderID) throws SQLException {
        st.executeUpdate("DELETE FROM IOTBAYUSER.ORDERS WHERE ID=" +orderID+"");
    }
    
    public ArrayList<Order> fetchOrders(String customerEmail) throws SQLException {
        String fetch = "select * from ORDERS where CUSTOMER_EMAIL='"+customerEmail+"'";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Order> temp = new ArrayList();
        
        while (rs.next()) {
            String orderID = rs.getString(1);
            String shippingAddress = rs.getString(3);
            String total = rs.getString(4);
            String status = rs.getString(5);
            String trackingID = rs.getString(6);
            String shipmentID = rs.getString(7);               
            
            temp.add(new Order(orderID, customerEmail, shippingAddress, total, status, trackingID, shipmentID));
        }
        return temp;
    }

    //OrderLineItem
    public OrderLineItem findOrderLineItem(String oID, String pID) throws SQLException {
        String fetch = "select * from IOTBAYUSER.ORDERLINEITEM where orderID = " + oID + " and productID="+pID+"";
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()) {  // reads every row in USERS table and gets the result by index and stores them Stringo Strings
            String orderID = rs.getString(2);
            String productID = rs.getString(3);
            if (orderID == orderID && productID==productID) {
                String orderLineItemID = rs.getString(1);
                String quantity = rs.getString(4);
                String price = rs.getString(5);
                return new OrderLineItem(orderLineItemID, orderID, productID, quantity, price);
                
            }
            
        }
        return null;
    }
    
    public void addOrderLineItem(String orderLineItemID, String orderID, String productID, String quantity, String price) throws SQLException {
        st.executeUpdate("INSERT INTO IOTBAYUSER.ORDERLINEITEM " + "VALUES (" +orderLineItemID+", " +orderID+", "+productID+", "+quantity+", "+ price+")");
    }
    
    public void updateOrderLineItem(String orderLineItemID, String orderID, String productID, String quantity, String price) throws SQLException {
        st.executeUpdate("UPDATE IOTBAYUSER.ORDERLINEITEM SET orderID="+orderID+",productID="+productID+",quantity="+quantity+",price="+price+" WHERE orderLineID="+orderLineItemID+"");
    }
    
    public void deleteOrderLineItem(String orderLineItemID) throws SQLException {
        st.executeUpdate("DELETE FROM IOTBAYUSER.ORDERLINEITEM WHERE orderLineID=" +orderLineItemID+"");
    }
    
    public ArrayList<OrderLineItem> fetchOrderLineItems(String orderID) throws SQLException {
        String fetch = "select * from IOTBAYUSER.ORDERLINEITEM where orderID="+orderID+"";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<OrderLineItem> temp = new ArrayList<OrderLineItem>();
        
        while (rs.next()) {
            String orderLineItemID = rs.getString(1);
            String productID = rs.getString(3);               
            String quantity = rs.getString(4);
            String price = rs.getString(5);
            
            temp.add(new OrderLineItem(orderLineItemID, orderID, productID, quantity, price));
        }
        return temp;
    }
    
    
    
}
