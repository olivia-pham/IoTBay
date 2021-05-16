/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;
import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author olivi
 */
public class Order implements Serializable{
    private int orderID;
    private String userEmail;
    private String orderDate;
    private double totalPrice;
    private String shippingAddress;
    
    
    public Order() {
    
    }

    public Order(int orderID, String userEmail, String orderDate, double totalPrice, String shippingAddress) {
        this.orderID = orderID;
        this.userEmail = userEmail;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.shippingAddress = shippingAddress;  
    }
    
    
    
    
    public int getOrderID() {
        return orderID;
    }
    
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }


    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
    
    public void updatePrice(double price, int quantity) {
        this.totalPrice = this.totalPrice + (price*quantity);
    }
    
    public void deleteOrderLine(double totalPrice) {
        this.totalPrice = this.totalPrice - totalPrice;
    }
    
}