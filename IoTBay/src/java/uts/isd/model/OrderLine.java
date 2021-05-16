/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;
import java.io.Serializable;

/**
 *
 * @author olivi
 */
public class OrderLine implements Serializable{
    private int orderLineID;
    private int orderID;
    private int quantity;
    private int productID;
    private String productName;
    private double totalPrice;
    private double price;
    
    
    public OrderLine() {
    }
   
    
    public OrderLine(int orderLineID, int orderID, int quantity, int productID, String productName, double totalPrice, double price) {
        this.orderLineID = orderLineID;
        this.orderID = orderID;
        this.quantity = quantity;
        this.productID = productID;
        this.productName = productName;
        this.totalPrice = totalPrice;
        this.price = price;
    }


    public int getOrderlineID() {
        return orderLineID;
    }

    public void setOrderlineID(int orderLineID) {
        this.orderLineID = orderLineID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public void upQuantity() {
        this.quantity++;
        this.totalPrice = this.totalPrice + (quantity*price);
    }

    public int downQuantity() {
        this.quantity--;
        this.totalPrice = this.totalPrice - (quantity*price);
        return this.quantity;
    }
    
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice() {
        this.totalPrice = this.price * this.quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    
    
}