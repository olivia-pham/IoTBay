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
    private String ID;
    private String customerEmail;
    private String shippingAddress;
    private String total;
    private String status;
    private String trackingID;    
    private String shippingID;   

    public Order(String ID, String customerEmail, String shippingAddress, String total, String status, String trackingID, String shippingID) {
        this.ID = ID;
        this.customerEmail = customerEmail;
        this.shippingAddress = shippingAddress;
        this.total = total;
        this.status = status;
        this.trackingID = trackingID;
        this.shippingID = shippingID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTrackingID() {
        return trackingID;
    }

    public void setTrackingID(String trackingID) {
        this.trackingID = trackingID;
    }

    public String getShippingID() {
        return shippingID;
    }

    public void setShippingID(String shippingID) {
        this.shippingID = shippingID;
    }
    
}