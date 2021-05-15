/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;
import java.io.Serializable;
import java.text.DecimalFormat;

/**
 *
 * @author olivi
 */
public class OrderLineItem implements Serializable {
    private Product product;
    private int quantity;

    public OrderLineItem() { }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getSumPrice() {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(product.getPrice() * quantity));
    }
}
