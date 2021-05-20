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
    private String orderLineId;
    private String quantity;
    private String productId;
    private String price;
    
    
    public OrderLine() {
    }

    public OrderLine(String orderLineId, String quantity, String productId, String price) {
        this.orderLineId = orderLineId;
        this.quantity = quantity;
        this.productId = productId;
        this.price = price;
    }

    public String getOrderLineId() {
        return orderLineId;
    }

    public void setOrderLineId(String orderLineId) {
        this.orderLineId = orderLineId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
   
    
   
    
    
}