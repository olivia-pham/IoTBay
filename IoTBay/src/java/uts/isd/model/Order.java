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
public class Order implements Serializable {
    private int ID;
    private Customer customer;
    private double total;
    private String trackingID;
    private String status;
    private String shippingAddress;
    private String cardUsed;

    public Order() { }

    public int getID() { return ID; }
    public void setID(int ID) { this.ID = ID; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public String getTrackingID() { return trackingID; }
    public void setTrackingID(String trackingID) { this.trackingID = trackingID; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getShippingAddress() { return shippingAddress; }
    public void setShippingAddress(String shippingAddress) { this.shippingAddress = shippingAddress; }

    public String getCardUsed() { return cardUsed; }
    public void setCardUsed(String cardUsed) { this.cardUsed = cardUsed; }
}