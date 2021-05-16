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
    
    
}
