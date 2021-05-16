  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;

import java.sql.*;
import java.util.ArrayList;
import uts.isd.model.User;

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
    public User findUser(String email, String password) throws SQLException {
        String fetch = "select * from IOTBAYUSER.Customers where EMAIL = '" + email + "' and PASSWORD='" + password + "'";
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()) {
            String userEmail = rs.getString(2);
            String userPass = rs.getString(3);
            if (userEmail.equals(email) && userPass.equals(password)) {
                String userName = rs.getString(1);
                String userPhone = rs.getString(4);
                return new User(userName, userEmail, password, userPhone, 'c');
            }            
        }
        return null;
    }
    
    //add customer data into database
    public void addUser(String name, String email, String password, String phone, char accountType) throws SQLException {
        st.executeUpdate("INSERT INTO isduser.users " + "VALUES ('" + name + "', '" + email + "', '" + password + "','" + phone + "','" + accountType + "')");
    }
    
    //update customer details in database
    public void updateUser(String name, String email, String password, String phone) throws SQLException {
        st.executeUpdate("UPDATE isduser.users SET NAME='" + name + "',PASSWORD='" + password + "',phone='" + phone + "' WHERE EMAIL='" + email + "'");
    }
    
    //delete customer from database
    public void deleteUser(String name, String email, String password, String phone) throws SQLException {
        st.executeUpdate("DELETE FROM isduser.users WHERE EMAIL='" + email + "'");
    }
    
    public ArrayList<User> fectUser() throws SQLException {
        String fetch = "select * from users";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<User> temp = new ArrayList();
        
        while (rs.next()) {
            String name = rs.getString(1);
            String email = rs.getString(2);
            String password = rs.getString(3);
            String phone = rs.getString(4);
            temp.add(new User(name, email, password, phone,'c'));
        }
        return temp;        
    }
    public boolean checkUser(String email, String password) throws SQLException {
        String fetch = "select * from isduser.users where EMAIL = '" + email + "' and password='" + password + "'";
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()) {
            String userEmail = rs.getString(2);
            String userPass = rs.getString(3);
            if (userEmail.equals(email) && userPass.equals(password)) {
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
    public void deleteProduct(String id, String name, String price, String desc, String quant) throws SQLException {
        st.executeUpdate("DELETE FROM IOTBAYUSER.Products WHERE ID=" + id + "");
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

    
    public Order findOrder(String oID) throws SQLException {
        String fetch = "select * from IOTBAYUSER.ORDERS where ID = " + oID + "'";
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()) {  // reads every row in USERS table and gets the result by index and stores them Stringo Strings
            String orderID = rs.getString(1);
            
            if (orderID.equals(oID)) {
                String userEmail = rs.getString(2);
                String orderDate = rs.getString(3);
                String totalPrice = rs.getString(4);
                String shippingAddress = rs.getString(5);
                return new Order(orderID, userEmail, orderDate, totalPrice, shippingAddress);
            }
            
        }
        return null;
    }
    
    public void addOrder(String orderID, String userEmail) throws SQLException {
        st.executeUpdate("INSERT INTO IOTBAYUSER.ORDERS VALUES ("+orderID+", '" +userEmail+"', null, null, null, null, null)");
              
        
          
    }
    
    public void updateOrder(String orderID, String userEmail, String orderDate, String totalPrice, String shippingAddress) throws SQLException {
        st.executeUpdate("UPDATE IOTBAYUSER.ORDERS SET ORDER_DATE='"+orderDate+"',TOTAL="+totalPrice+",SHIPPING_ADDRESS='"+
                shippingAddress+"' WHERE ID="+orderID + " AND USER_EMAIL='"+userEmail+"'");
    }
    
    public void deleteOrder(String orderID) throws SQLException {
        st.executeUpdate("DELETE FROM IOTBAYUSER.ORDERS WHERE ID=" +orderID+"");
    }
    
    public ArrayList<Order> fetchOrder() throws SQLException {
        String fetch = "select * from IOTBAYUSER.ORDERS";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Order> temp = new ArrayList();
        
        while (rs.next()) {
            String orderID = rs.getString(1);
            String userEmail = rs.getString(2);
            String orderDate = rs.getString(3);
            String totalPrice = rs.getString(4);
            String shippingAddress = rs.getString(5);
            
            temp.add(new Order(orderID, userEmail, orderDate, totalPrice, shippingAddress));
        }
        return temp;
    }
    
    public ArrayList<Order> searchOrders(String input) throws SQLException {
        String fect = "select * from IOTBAYUSER.ORDERS WHERE ID LIKE '%" + input + "%'";
        ResultSet rs = st.executeQuery(fect);
        ArrayList<Order> temp = new ArrayList();
        
        while (rs.next()) {
            String orderID = rs.getString(1);
            String userEmail = rs.getString(2);
            String orderDate = rs.getString(3);
            String totalPrice = rs.getString(4);
            String shippingAddress = rs.getString(5);
            temp.add(new Order(orderID, userEmail, orderDate, totalPrice, shippingAddress));
        }
        return temp;        
    }
    
    public ArrayList<Order> searchDOrders(String input) throws SQLException {
        String fect = "select * from IOTBAYUSER.ORDERS WHERE ORDER_DATE LIKE '%" + input + "%'";
        ResultSet rs = st.executeQuery(fect);
        ArrayList<Order> temp = new ArrayList();
        
        while (rs.next()) {
            String orderID = rs.getString(1);
            String userEmail = rs.getString(2);
            String orderDate = rs.getString(3);
            String totalPrice = rs.getString(4);
            String shippingAddress = rs.getString(5);
            temp.add(new Order(orderID, userEmail, orderDate, totalPrice, shippingAddress));
        }
        return temp;        
    }
    
    public ArrayList<Order> searchBothOrders(String input, String input2) throws SQLException {
        String fect = "select * from IOTBAYUSER.ORDERS WHERE ID LIKE '%" + input + "%' AND ORDER_DATE LIKE '%" + input2 + "%'";
        ResultSet rs = st.executeQuery(fect);
        ArrayList<Order> temp = new ArrayList();
        
        while (rs.next()) {
            String orderID = rs.getString(1);
            String userEmail = rs.getString(2);
            String orderDate = rs.getString(3);
            String totalPrice = rs.getString(4);
            String shippingAddress = rs.getString(5);
            temp.add(new Order(orderID, userEmail, orderDate, totalPrice, shippingAddress));
        }
        return temp;        
    }
    
    //orderline dbmanager
    public OrderLine findOrderLine(String olID) throws SQLException {
        String fetch = "select * from IOTBAYUSER.ORDER_LINE where ID = " + olID +"";
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()) {  // reads every row in USERS table and gets the result by index and stores them Stringo Strings
            String orderLineID = rs.getString(1);
            if (orderLineID.equals(olID)) {                
                String orderID = rs.getString(2);
                String productID = rs.getString(3);
                String quantity = rs.getString(4);
                String productName = rs.getString(5);
                String totalPrice = rs.getString(6);
                String price = rs.getString(7);
                return new OrderLine(orderLineID, orderID, quantity, productID, productName, totalPrice, price);
                
            }
            
        }
        return null;
    }
    
    public void addOrderLine(String orderLineID, String orderID, String quantity, String productID, String productName, String totalPrice, String price) throws SQLException {
        st.executeUpdate("INSERT INTO IOTBAYUSER.ORDER_LINE " + "VALUES (" +orderLineID+", " +orderID+", "+quantity+", "+productID+", '"+productName+"', "+totalPrice+", "+ price+")");
    }
    
    public void updateOrderLine(String orderLineID, String orderID, String quantity, String productID, String productName, String totalPrice, String price) throws SQLException {
        st.executeUpdate("UPDATE IOTBAYUSER.ORDER_LINE SET ORDER_ID="+orderID+",QUANTITY="+quantity+",PRODUCT_ID="+productID+",PRODUCT_NAME='"+
                productName+"',TOTAL_PRICE="+totalPrice+", PRICE="+price+" WHERE ID="+orderLineID+"");
    }
    
    public void deleteOrderLine(String orderLineID) throws SQLException {
        st.executeUpdate("DELETE FROM IOTBAYUSER.ORDER_LINE WHERE ID=" +orderLineID+"");
    }
    
    public ArrayList<OrderLine> fetchOrders() throws SQLException {
        String fetch = "select * from IOTBAYUSER.ORDER_LINE";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<OrderLine> temp = new ArrayList();
        
        while (rs.next()) {
            String orderLineID = rs.getString(1);
            String orderID = rs.getString(2);
            String quantity = rs.getString(3);                
            String productID = rs.getString(4);
            String productName = rs.getString(5);
            String totalPrice = rs.getString(6);
            String price = rs.getString(7);
            temp.add(new OrderLine(orderLineID, orderID, quantity, productID, productName, totalPrice, price));
        }
        return temp;
    }


}
