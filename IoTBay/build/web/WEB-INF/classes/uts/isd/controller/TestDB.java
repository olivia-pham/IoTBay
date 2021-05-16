/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import uts.isd.model.User;
import uts.isd.model.dao.*;

/**
 *
 * @author olivi
 */
public class TestDB {
    private static Scanner in = new Scanner(System.in);
    private DBConnector connector;
    private Connection conn;
    private DBManager db;
    
    public static void main(String[] args) throws SQLException {
        (new TestDB()).runQueries();
    }
    
    public TestDB() {
        try {
            connector = new DBConnector();
            conn = connector.openConnection();
            db = new DBManager(conn);
        } catch (ClassNotFoundException | SQLException ex){
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private char readChoice() {
        System.out.print("Operation CRUDS or * to exit: ");
        return in.nextLine().charAt(0);
    }

    private void runQueries() throws SQLException {
        char c;
        while ((c = readChoice()) != '*') {
            switch (c) {
                case 'C':
                    testAdd();
                    break;
                case 'R':
                    testRead();
                    break;
                case 'U': ;
                    testUpdate();
                    break;
                case 'D': ;
                    testDelete();
                    break;
                case 'S': ;
                    showAll();
                    break;
                default:
                    System.out.print("Unknown Command");
                    break;
            }            
        }
    }
    private void testAdd() {
        System.out.print("Customer name: ");
        String name = in.nextLine(); 
        System.out.print("Customer email: ");
        String email = in.nextLine();
        System.out.print("Customer password: ");
        String password = in.nextLine();
        System.out.print("Customer date of birth: ");
        String phone = in.nextLine();
        try {
            db.addUser(name, email, password, phone,'c');
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Customer is added to the database.");
    }
    
    private void testRead() throws SQLException{
        System.out.print("Customer email: ");
        String email = in.nextLine();
        System.out.print("Customer password: ");
        String password = in.nextLine();
        User customer = db.findUser(email, password);
        if (customer != null) {
            System.out.println("Customer " + customer.getName() + " exists in the database.");
        } else {
            System.out.println("Customer does not exist.");
        }
    }
    private void testUpdate() {
        System.out.print("Customer email: ");
        String email = in.nextLine();
        System.out.print("Customer password: ");
        String password = in.nextLine();
        try {
            if (db.checkUser(email, password)) {
                System.out.print("Customer name: ");
                String name = in.nextLine();
                System.out.print("Customer date of birth: ");
                String phone = in.nextLine();
                db.updateUser(name, email, password, phone);
            } else {
                System.out.println("Customer does not exist.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void testDelete() {
        System.out.print("Customer email: ");
        String email = in.nextLine();
        System.out.print("Customer password: ");
        String password = in.nextLine();
        try {
            if (db.checkUser(email, password)) {
                db.deleteUser(email, email, password, email);
            } else {
                System.out.println("Customer does not exist.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void showAll() {
        try {
            ArrayList<User> customers = db.fectUser();
            System.out.print("CUSTOMERS TABLE: ");
            customers.stream().forEach((customer)-> {
                System.out.printf("%-20s %-30s %-40s %-10s \n",customer.getName(), customer.getEmail(), customer.getPassword(), customer.getPhone());
            });
            System.out.println();
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 

    
}
