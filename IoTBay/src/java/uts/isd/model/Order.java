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
    private String orderID;
    private String userEmail;
    private String orderDate;
    private String totalPrice;
    private String shippingAddress;
    
    
    public Order() {
    
    }

    public Order(String orderID, String userEmail, String orderDate, String totalPrice, String shippingAddress) {
        this.orderID = orderID;
        this.userEmail = userEmail;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.shippingAddress = shippingAddress;  
    }
    
    
    
    
    public String getOrderID() {
        return orderID;
    }
    
    public void setOrderID(String orderID) {
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

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
    

    
}